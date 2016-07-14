package com.example.timingtest.independent;

import com.example.timingtest.util.TimeStampUilts;

/*
 * System.loadLibrary
 */
public class JavaLangSystem {
	public static void callLoadLibrary() {
		TimeStampUilts.stampBeforeApi("System.loadLibrary");
		System.loadLibrary("test");
		TimeStampUilts.stampAfterApi("System.loadLibrary");
	}
}
