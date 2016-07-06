package com.example.timingtest.independent;

import com.example.timingtest.util.TimeStampUilts;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
/*
 * getLastKnownLocation
 * getLongitude
 * getLatitude
 */
public class TestLoacation {

	public static void callLocation(Context c) {
		LocationManager lm = (LocationManager) c
				.getSystemService(Context.LOCATION_SERVICE);
		
		TimeStampUilts.stampBeforeApi("getLastKnownLocation");
		Location l = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		TimeStampUilts.stampAfterApi("getLastKnownLocation");
		if(l==null){
			Log.e("TestLocation", "getLastKnownLocation failed!!!");
			return;
		}
		TimeStampUilts.stampBeforeApi("getLongitude");
		double lo = l.getLongitude();
		TimeStampUilts.stampAfterApi("getLongitude");
		
		TimeStampUilts.stampBeforeApi("getLatitude");
		double la = l.getLatitude();
		TimeStampUilts.stampAfterApi("getLatitude");
	}


}
