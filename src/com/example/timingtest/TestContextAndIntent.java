package com.example.timingtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;

/*
 * sendBroadcast
 * sendOrderedBroadcast
 * registerReceiver
 * unregisterReceiver
 * getSystemService
 * getPackageManager
 * getResources
 * setAction
 * putExtra
 */
public class TestContextAndIntent {
	public static long callContextAndIntent(Context c) {
		long b = 0, e = 0;
		System.out.println("1");
		
		MyBroadcastReceiver mbr = new MyBroadcastReceiver();
		IntentFilter ftr = new IntentFilter();
		ftr.addAction("com.example.timingtest.test");
		
		c.registerReceiver(mbr, ftr);
		
		Intent i = new Intent();
		i.setAction("com.example.timingtest.test");
		i.putExtra("name", "timingtest");
		
		c.sendBroadcast(i);
		c.sendOrderedBroadcast(i, null);
		
		
		c.unregisterReceiver(mbr);
		
		
		PowerManager powerManager = (PowerManager) c
				.getSystemService(Context.POWER_SERVICE);
		PackageManager pkgMgr = c.getPackageManager(); 
		c.getResources();
		System.out.println("2");

		b = System.nanoTime();
		e = System.nanoTime();
		return e - b;
	}

}
