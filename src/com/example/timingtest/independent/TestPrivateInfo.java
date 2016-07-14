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
		c1.close();
		
		TimeStampUilts.stampBeforeApi("query(CALL_LOG)");
		Cursor c2 = c.getContentResolver().query(CallLog.Calls.CONTENT_URI,
				null, null, null, null);
		TimeStampUilts.stampAfterApi("query(CALL_LOG)");
		c2.close();
		
		TimeStampUilts.stampBeforeApi("query(SMS)");
		Cursor c3 = c.getContentResolver().query(Uri.parse("content://sms"),
				null, null, null, null);
		TimeStampUilts.stampAfterApi("query(SMS)");
		c3.close();
		
	}
}
