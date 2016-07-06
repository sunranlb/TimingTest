package com.example.timingtest.activity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	private static final String TAG = "MyService";
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.d(TAG, "onbind");
		return null;
	}
	

	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate");
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		Log.d(TAG, "onDestroy");
		super.onDestroy();
	}
}
