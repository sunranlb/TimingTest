package com.example.timingtest.independent;

import android.util.Log;

public class JavaLangRuntime {
	public static long callExec() {
		long b = 0, e = 0;

        Process process = null;

        try {
            process = Runtime.getRuntime().exec("ps");
		} catch (Exception ee) {
			Log.e("Error", ee.getMessage());
			ee.printStackTrace();
		} 
		
		b = System.nanoTime();
		e = System.nanoTime();
		return e - b;
	}
}
