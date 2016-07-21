package com.example.timingtest.independent;

import java.util.List;

import com.example.timingtest.util.TimeStampUilts;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/*
 * getInstalledPackages
 * getRunningTasks
 * getRunningServices
 */
public class TestAppEnv {
	public static void callAppEnvApis(Context c){
		PackageManager pckMan = c.getPackageManager();
		TimeStampUilts.stampBeforeApi("getInstalledPackages");
		List<PackageInfo> packsInfoList = pckMan.getInstalledPackages(0);
		TimeStampUilts.stampAfterApi("getInstalledPackages");
		
		ActivityManager am = (ActivityManager)c.getSystemService(Context.ACTIVITY_SERVICE);
		TimeStampUilts.stampBeforeApi("getRunningTasks");
	    List<RunningTaskInfo> taskInfoList = am.getRunningTasks(100);
	    TimeStampUilts.stampAfterApi("getRunningTasks");
	    
	    TimeStampUilts.stampBeforeApi("getRunningServices");
	    List<RunningServiceInfo> serviceInfoList = am.getRunningServices(100);
	    TimeStampUilts.stampAfterApi("getRunningServices");
	}
}
