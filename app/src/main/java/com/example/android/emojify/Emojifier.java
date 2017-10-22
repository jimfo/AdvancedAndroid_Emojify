package com.example.android.emojify;


import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by Jim on 10/22/2017.
 */

public class Emojifier {

    public Emojifier(){}

    public static void detectFaces(Context context, Bitmap bitmap){

        String TAG = "FACES";

        // Create face detector, disable tracking and enable classifications
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        // Build the frame
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        // Detect faces
        SparseArray<Face> faces = detector.detect(frame);

        Log.d(TAG, "DetectFaces: number of faces = " + faces.size());

        if(faces.size() == 0){
            Toast.makeText(context, "No faces detected", Toast.LENGTH_LONG).show();
        }
        detector.release();
    }

}
