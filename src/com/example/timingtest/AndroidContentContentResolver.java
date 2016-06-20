package com.example.timingtest;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
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
		cr.delete(ContactsContract.Contacts.CONTENT_URI, "sid in (?,?)", new String[]{"1","2"});
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
		Uri rawContactUri = cr.insert(RawContacts.CONTENT_URI,
                v);         
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
}
