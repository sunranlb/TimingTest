package com.example.timingtest;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

public class Loacation {

	public static long callLocation(Context c) {
		long b = 0, e = 0;
		LocationManager lm = (LocationManager) c
				.getSystemService(Context.LOCATION_SERVICE);
		TimeStampUilts.stampBeforeApi("Location");
		Location l = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		double lo = l.getLongitude();
		double la = l.getLatitude();
		TimeStampUilts.stampAfterApi("Location");
		System.out.println("long:"+lo+",la:"+la);
		
		b = System.nanoTime();
		e = System.nanoTime();
		return e - b;
	}


}
