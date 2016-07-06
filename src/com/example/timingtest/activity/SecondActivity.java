package com.example.timingtest.activity;

import com.example.timingtest.independent.TestLoacation;
import com.example.timingtest.util.TimeStampUilts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PowerManager;

/*
 * onCreate
 * onStart
 * onResume
 * onPause
 * onStop
 * onDestroy
 * onRestart
 * registerReceiver
 * setAction
 * putExtra
 * sendBroadcast
 * unregisterReceiver
 * Intent
 * sendOrderedBroadcast
 * getSystemService
 * getPackageManager
 * getResources
 */
public class SecondActivity extends Activity {
	private MyBroadcastReceiver mbr;

	private ServiceConnection sc = new ServiceConnection() {
		public void onServiceConnected(android.content.ComponentName name,
				android.os.IBinder service) {
		};

		public void onServiceDisconnected(android.content.ComponentName name) {
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		TimeStampUilts.stampBeforeApi("onCreate");
		super.onCreate(savedInstanceState);
		TimeStampUilts.stampAfterApi("onCreate");

		TestLoacation.callLocation(this);
		
		TimeStampUilts.stampBeforeApi("getSystemService");
		PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
		TimeStampUilts.stampAfterApi("getSystemService");
		
		TimeStampUilts.stampBeforeApi("getPackageManager");
		PackageManager pkgMgr = getPackageManager();
		TimeStampUilts.stampAfterApi("getPackageManager");
		
		TimeStampUilts.stampBeforeApi("getResources");
		getResources();
		TimeStampUilts.stampAfterApi("getResources");

		mbr = new MyBroadcastReceiver();
		IntentFilter ftr = new IntentFilter();
		ftr.addAction("com.example.timingtest.ACTION");

		TimeStampUilts.stampBeforeApi("registerReceiver");
		registerReceiver(mbr, ftr);
		TimeStampUilts.stampAfterApi("registerReceiver");

		TimeStampUilts.stampBeforeApi("Intent");
		Intent i = new Intent();
		TimeStampUilts.stampAfterApi("Intent");

		TimeStampUilts.stampBeforeApi("setAction");
		i.setAction("com.example.timingtest.ACTION");
		TimeStampUilts.stampAfterApi("setAction");

		Bundle b = new Bundle();
		b.putString("name", "timingtest from bundle");

		TimeStampUilts.stampBeforeApi("putExtra");
		i.putExtra("bundle", b);
		TimeStampUilts.stampAfterApi("putExtra");

		TimeStampUilts.stampBeforeApi("sendBroadcast");
		sendBroadcast(i);
		TimeStampUilts.stampAfterApi("sendBroadcast");

		TimeStampUilts.stampBeforeApi("sendOrderedBroadcast");
		sendOrderedBroadcast(i, null);
		TimeStampUilts.stampAfterApi("sendOrderedBroadcast");

	}

	@Override
	protected void onStart() {
		TimeStampUilts.stampBeforeApi("onStart");
		super.onStart();
		TimeStampUilts.stampAfterApi("onStart");
	}

	@Override
	protected void onResume() {
		TimeStampUilts.stampBeforeApi("onResume");
		super.onResume();
		TimeStampUilts.stampAfterApi("onResume");
	}

	@Override
	protected void onPause() {
		TimeStampUilts.stampBeforeApi("onPause");
		super.onPause();
		TimeStampUilts.stampAfterApi("onPause");
	}

	@Override
	protected void onStop() {
		TimeStampUilts.stampBeforeApi("onStop");
		super.onStop();
		TimeStampUilts.stampAfterApi("onStop");

		TimeStampUilts.stampBeforeApi("unregisterReceiver");
		unregisterReceiver(mbr);
		TimeStampUilts.stampAfterApi("unregisterReceiver");
	}

	@Override
	protected void onDestroy() {
		TimeStampUilts.stampBeforeApi("onDestroy");
		super.onDestroy();
		TimeStampUilts.stampAfterApi("onDestroy");
	}

	@Override
	protected void onRestart() {
		TimeStampUilts.stampBeforeApi("onRestart");
		super.onRestart();
		TimeStampUilts.stampAfterApi("onRestart");
	}
}
