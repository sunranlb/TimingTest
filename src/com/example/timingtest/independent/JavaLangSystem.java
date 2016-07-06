package com.example.timingtest.independent;

public class JavaLangSystem {
	public static long callLoadLibrary() {
		long b = 0, e = 0;
		b = System.nanoTime();
		System.loadLibrary("test");
		e = System.nanoTime();
		return e - b;
	}
}
