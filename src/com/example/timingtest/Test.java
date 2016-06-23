package com.example.timingtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

import dalvik.system.PathClassLoader;

import android.content.Context;
import android.util.Base64;

public class Test {
	public static long test() {
		long b = 0, e = 0;
		b = System.nanoTime();
		System.loadLibrary("test");
		e = System.nanoTime();
		return e - b;
	}
}
