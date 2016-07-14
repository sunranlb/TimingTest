package com.example.timingtest.independent;

import com.example.timingtest.util.TimeStampUilts;

import android.util.Log;
/*
 * Runtime.exec
 */
public class JavaLangRuntime {
	public static void callExec() {

		try {
			Runtime runTime = Runtime.getRuntime();

			TimeStampUilts.stampBeforeApi("Runtime.exec");
			runTime.exec("ps");
			TimeStampUilts.stampAfterApi("Runtime.exec");

		} catch (Exception ee) {
			Log.e("Error", ee.getMessage());
			ee.printStackTrace();
		}

	}
}
