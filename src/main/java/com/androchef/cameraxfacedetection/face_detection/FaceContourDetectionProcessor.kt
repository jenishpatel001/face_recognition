package com.androchef.cameraxfacedetection.face_detection

import android.graphics.Rect
import android.util.Log
import com.androchef.cameraxfacedetection.camerax.BaseImageAnalyzer
import com.androchef.cameraxfacedetection.camerax.GraphicOverlay
import com.google.android.gms.tasks.Task
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.Face
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions
import java.io.IOException

class FaceContourDetectionProcessor(private val view: GraphicOverlay,
                                    private val onSuccessCallback: ((FaceStatus) -> Unit)) :
    BaseImageAnalyzer<List<Face>>() {

    private val realTimeOpts = FaceDetectorOptions.Builder()
        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_FAST)
        .setContourMode(FaceDetectorOptions.CONTOUR_MODE_NONE)
        .build()

    private val detector = FaceDetection.getClient(realTimeOpts)

    override val graphicOverlay: GraphicOverlay
        get() = view

    override fun detectInImage(image: InputImage): Task<List<Face>> {
        return detector.process(image)
    }

    override fun stop() {
        try {
            detector.close()
        } catch (e: IOException) {
            Log.e(TAG, "Exception thrown while trying to close Face Detector: $e")
        }
    }

    override fun onSuccess(
        results: List<Face>,
        graphicOverlay: GraphicOverlay,
        rect: Rect
    ) {
        graphicOverlay.clear()
       if (results.isNotEmpty()){
           results.forEach {
               val faceGraphic = FaceContourGraphic(graphicOverlay, it, rect
               ,onSuccessCallback)
               graphicOverlay.add(faceGraphic)
           }
           graphicOverlay.postInvalidate()
       }else{
           onSuccessCallback(FaceStatus.NO_FACE)
           Log.e(TAG, "Face Detector failed.")
       }

    }



    override fun onFailure(e: Exception) {
        Log.e(TAG, "Face Detector failed. $e")
        onSuccessCallback(FaceStatus.NO_FACE)
    }

    companion object {
        private const val TAG = "FaceDetectorProcessor"
    }

}