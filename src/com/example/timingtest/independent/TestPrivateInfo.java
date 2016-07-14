package com.example.timingtest.independent;

import com.example.timingtest.util.TimeStampUilts;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
/*
 * query(CONTACTS)
 * query(CALL_LOG)
 * query(SMS)
 */
public class TestPrivateInfo {
	public static void callPrivateInfoApis(Context c) {
		TimeStampUilts.stampBeforeApi("query(CONTACTS)");
		Cursor c1 = c.getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		TimeStampUilts.stampAfterApi("query(CONTACTS)");
		
		TimeStampUilts.stampBeforeApi("query(CALL_LOG)");
		Cursor c2 = c.getContentResolver().query(CallLog.Calls.CONTENT_URI,
				null, null, null, null);
		TimeStampUilts.stampAfterApi("query(CALL_LOG)");
		
		TimeStampUilts.stampBeforeApi("query(SMS)");
		Cursor c3 = c.getContentResolver().query(Uri.parse("content://sms"),
				null, null, null, null);
		TimeStampUilts.stampAfterApi("query(SMS)");
		
	}
}
