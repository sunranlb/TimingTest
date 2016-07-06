package com.example.timingtest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URI;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

import DexTest.DexHello;
import DexTest.DexHelper;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

public class Test {
	public static long test(Context c) {
		long b = 0, e = 0;

		TestContextAndIntent.callContextAndIntent(c);
		b = System.nanoTime();
		e = System.nanoTime();
		return e - b;
	}

}
