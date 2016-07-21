package com.example.timingtest.independent;

import android.content.Context;
import android.util.Base64;

public class AndroidUtilBase64 {
	public static long callDecode() {
		long b = 0, e = 0;
		byte[] encode = Base64
				.encode("Hello, World".getBytes(), Base64.DEFAULT);
		b = System.nanoTime();
		Base64.decode("SGVsbG8sIFdvcmxk", Base64.DEFAULT);
		e = System.nanoTime();
		return e - b;
	}

	public static long callEncode() {
		long b = 0, e = 0;
		b = System.nanoTime();
		Base64.encode("Hello, World".getBytes(), Base64.DEFAULT);
		e = System.nanoTime();
		return e - b;
	}
	
	public static long callEncodeToString() {
		long b = 0, e = 0;
		b = System.nanoTime();
		Base64.encodeToString("Hello, World".getBytes(), Base64.DEFAULT);
		e = System.nanoTime();
		return e - b;
	}

}
