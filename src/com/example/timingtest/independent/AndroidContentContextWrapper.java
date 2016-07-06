package com.example.timingtest.independent;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.provider.ContactsContract.Contacts;

public class AndroidContentContextWrapper {
	public static long callGetContentResolver(Context c) {
		long b = 0, e = 0;
		b = System.nanoTime();
		c.getContentResolver();
		e = System.nanoTime();
		return e - b;
	}
}
