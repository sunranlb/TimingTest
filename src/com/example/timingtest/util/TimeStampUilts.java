package com.example.timingtest.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.apache.http.impl.conn.Wire;

import android.os.Environment;
import android.util.Log;

public class TimeStampUilts {

	private static final String TAG = "TimeStamp";

	private static long sTimeStampBefore;
	private static String sApiNameBefore;
	private static long sTimeStampAfter;
	private static String sApiNameAfter;
	private final static String FILE_NAME = "r.txt";
	private static File targetFile;
	private static RandomAccessFile raf;

	public static void init() {
		try {
			targetFile = new File(Environment.getExternalStorageDirectory()
					.getCanonicalPath() + "/"+FILE_NAME);
			raf = new RandomAccessFile(targetFile, "rw");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static long stampBeforeApi(String apiName) {
		sTimeStampBefore = System.nanoTime();
		Log.d(TAG, apiName + "前：\t" + sTimeStampBefore);
		sApiNameBefore = apiName;
		return sTimeStampBefore;
	}

	public static long stampAfterApi(String apiName) {
		sTimeStampAfter = System.nanoTime();
		Log.d(TAG, apiName + "后：\t" + sTimeStampAfter);
		sApiNameAfter = apiName;
		calTimeDiff();
		return sTimeStampAfter;
	}

	public static long calTimeDiff() {
		if (sApiNameAfter.equals(sApiNameBefore)) {
			long diff = sTimeStampAfter - sTimeStampBefore;
			Log.d(TAG, sApiNameAfter + "时间差：\t" + diff);
			writeToFile(sApiNameAfter+":"+diff+"\n");
			return diff;
		}
		return 0;
	}

	private static void writeToFile(String s) {
		try {
			raf.seek(targetFile.length());
			raf.write(s.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
