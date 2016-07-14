package com.example.timingtest.independent;

import com.example.timingtest.util.TimeStampUilts;

import android.content.Context;
import android.hardware.Camera;
import android.media.MediaRecorder;
/*
 * Camera.open
 * setAudioSource
 */
public class TestPeripherals {
	public static void callPeripheralsApis(Context c){
		TimeStampUilts.stampBeforeApi("Camera.open");
		Camera camera = Camera.open();
		TimeStampUilts.stampAfterApi("Camera.open");
		
		camera.release();
		
		MediaRecorder rec = new MediaRecorder();
		
		TimeStampUilts.stampBeforeApi("setAudioSource");
		rec.setAudioSource(MediaRecorder.AudioSource.MIC);
		TimeStampUilts.stampAfterApi("setAudioSource");
	}
}
