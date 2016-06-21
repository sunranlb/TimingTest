package com.example.timingtest;

import java.io.FileNotFoundException;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;

public class AndroidContentContentResolver {
	public static long callAcquireContentProviderClient(Context c) {
		ContentResolver cr = c.getContentResolver();
		long b = System.nanoTime();
		cr.acquireContentProviderClient("zds");
		long e = System.nanoTime();
		return e - b;
	}

	public static long callAcquireUnstableContentProviderClient(Context c) {
		ContentResolver cr = c.getContentResolver();
		long b = System.nanoTime();
		cr.acquireUnstableContentProviderClient("zds");
		long e = System.nanoTime();
		return e - b;
	}

	public static long callDelete(Context c) {
		ContentResolver cr = c.getContentResolver();
		long b = System.nanoTime();
		cr.delete(ContactsContract.Contacts.CONTENT_URI, "sid in (?,?)",
				new String[] { "1", "2" });
		long e = System.nanoTime();
		return e - b;
	}

	public static long callGetType(Context c) {
		ContentResolver cr = c.getContentResolver();
		long b = System.nanoTime();
		cr.getType(ContactsContract.Contacts.CONTENT_URI);
		long e = System.nanoTime();
		return e - b;
	}

	public static long callInsert(Context c) {
		ContentResolver cr = c.getContentResolver();
		ContentValues v = new ContentValues();
		Uri rawContactUri = cr.insert(RawContacts.CONTENT_URI, v);
		long rawContactId = ContentUris.parseId(rawContactUri);
		v.clear();
		v.put(Data.RAW_CONTACT_ID, rawContactId);
		v.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
		v.put(StructuredName.DISPLAY_NAME, "zds");
		long b = System.nanoTime();
		cr.insert(Data.CONTENT_URI, v);
		long e = System.nanoTime();
		return e - b;
	}

	public static long callOpenAssetFileDescriptor(Context c) {
		ContentResolver cr = c.getContentResolver();
		long b = 0, e = 0;
		try {
			b = System.nanoTime();
			cr.openAssetFileDescriptor(
					Uri.parse("android.resource://com.example.timingtest/raw/test"),
					"r");
			e = System.nanoTime();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return -1l;
		}
		return e - b;
	}

	public static long callOpenInputStream(Context c) {
		ContentResolver cr = c.getContentResolver();
		long b = 0, e = 0;
		try {
			b = System.nanoTime();
			cr.openInputStream(Uri
					.parse("android.resource://com.example.timingtest/raw/test"));
			e = System.nanoTime();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return -1l;
		}
		return e - b;
	}

	public static long callQuery(Context c) {
		ContentResolver cr = c.getContentResolver();
		String[] col = { Contacts._ID,Contacts.DISPLAY_NAME,};
		long b = 0, e = 0;
		b = System.nanoTime();
		cr.query(Contacts.CONTENT_URI, col, null,null,null);
		e = System.nanoTime();
		return e - b;
	}
	
	public static long callUpdate(Context c) {
		ContentResolver cr = c.getContentResolver();
		ContentValues v = new ContentValues();
		v.put(Contacts.DISPLAY_NAME, "zdszds");
		long b = 0, e = 0;
		b = System.nanoTime();
		cr.update(Contacts.CONTENT_URI, v, Contacts.DISPLAY_NAME + " = ?", new String[]{"zds"});
		e = System.nanoTime();
		return e - b;
	}
}
