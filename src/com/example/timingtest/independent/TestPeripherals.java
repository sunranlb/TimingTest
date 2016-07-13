package com.example.timingtest.independent;

import com.example.timingtest.util.TimeStampUilts;

import android.content.Context;
import android.hardware.Camera;
/*
 * Camera.open
 */
public class TestPeripherals {
	public static void callPeripheralsApis(Context c){
		TimeStampUilts.stampBeforeApi("Camera.open");
		Camera camera = Camera.open();
		TimeStampUilts.stampAfterApi("Camera.open");
		camera.release();
	}
}
