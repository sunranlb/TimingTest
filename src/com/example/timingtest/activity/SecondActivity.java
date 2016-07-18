package com.example.timingtest.activity;

import com.example.timingtest.R;
import com.example.timingtest.independent.DalvikSystemDexClassLoader;
import com.example.timingtest.independent.DalvikSystemPathClassLoader;
import com.example.timingtest.independent.JavaLangClassloader;
import com.example.timingtest.independent.JavaLangRuntime;
import com.example.timingtest.independent.JavaLangSystem;
import com.example.timingtest.independent.TestAppEnv;
import com.example.timingtest.independent.TestLoacation;
import com.example.timingtest.independent.TestMobileComm;
import com.example.timingtest.independent.TestNetworking;
import com.example.timingtest.independent.TestPeripherals;
import com.example.timingtest.independent.TestPrivateInfo;
import com.example.timingtest.util.TimeStampUilts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PowerManager;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

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
 * setWifiEnabled
 * execute
 * Socket
 * getSystemService 
 * onCallStateChanged
 * getLastKnownLocation
 * getLongitude 
 * getLatitude
 * Camera.open
 * setAudioSource
 * query(CONTACTS)
 * query(CALL_LOG)
 * query(SMS)
 * getInstalledPackages
 * getRunningTasks
 * getRunningServices
 * System.loadLibrary
 * DexClassLoader.loadClass
 * PathClassLoader.loadClass
 * DexClassLoader.findLibrary
 * Runtime.exec
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
		setContentView(R.layout.activity_second);
		Button testBtn = (Button) findViewById(R.id.test_btn);
		Button sendMSGBtn = (Button) findViewById(R.id.sms_btn);
		testBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TestAppEnv.callAppEnvApis(SecondActivity.this);
			}
		});
		/*
		 * sendTextMessage
		 */
		sendMSGBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SmsManager smsM = SmsManager.getDefault();
				TimeStampUilts.stampBeforeApi("sendTextMessage");
				smsM.sendTextMessage("+8618501957842", null, "zds", null, null);
				TimeStampUilts.stampAfterApi("sendTextMessage");
			}
		});
		// Runtime.exec
		JavaLangRuntime.callExec();
		
		// DexClassLoader.findLibrary
		DalvikSystemDexClassLoader.callFindLibrary(this);
		
		// PathClassLoader.loadClass
		// hook后调用该api会闪退 syh 2016年07月18日
//		DalvikSystemPathClassLoader.allLoadClass(this);
		
		// DexClassLoader.loadClass
		JavaLangClassloader.callLoadClass(this);
		
		// System.loadLibrary
		JavaLangSystem.callLoadLibrary();
		/*
		 * getInstalledPackages getRunningTasks getRunningServices
		 */
		TestAppEnv.callAppEnvApis(this);

		/*
		 * query(CONTACTS) query(CALL_LOG) query(SMS)
		 */
		TestPrivateInfo.callPrivateInfoApis(this);

		/*
		 * Camera.open setAudioSource
		 */
		TestPeripherals.callPeripheralsApis(this);

		/*
		 * setWifiEnabled execute Socket
		 */
		TestNetworking.callNetworkingApis(this);

		/*
		 * getSystemService onCallStateChanged
		 */
		TestMobileComm.callMobileCommApis(this);

		/*
		 * getLastKnownLocation getLongitude getLatitude
		 */
		TestLoacation.callLocationApis(this);

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
