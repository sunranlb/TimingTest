package com.example.timingtest.independent;

import com.example.timingtest.util.TimeStampUilts;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
/*
 * getSystemService
 * onCallStateChanged
 */
public class TestMobileComm {
	public static void callMobileCommApis(Context c) {
		// 获得相应的系统服务
		TimeStampUilts.stampBeforeApi("getSystemService");
		TelephonyManager tm = (TelephonyManager) c
				.getSystemService(Context.TELEPHONY_SERVICE);
		TimeStampUilts.stampAfterApi("getSystemService");

		// 创建Listener
		MyPhoneCallListener myPhoneCallListener = new MyPhoneCallListener();

		// 注册监听 设置监听的State
		tm.listen(myPhoneCallListener, PhoneStateListener.LISTEN_CALL_STATE);

	}

	// 实现PhoneStateListener listener并实现相应的方法
	public static class MyPhoneCallListener extends PhoneStateListener {
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			// 电话通话的状态
			case TelephonyManager.CALL_STATE_OFFHOOK:
				System.out.println("THE PHONE IS CALLING!");
				break;
			// 电话响铃的状态
			case TelephonyManager.CALL_STATE_RINGING:
				System.out.println("THE PHONE IS RINGING!");
				break;
			// 空闲中
			case TelephonyManager.CALL_STATE_IDLE:
				System.out.println("THE PHONE IS IDLE!");
				break;
			}
			TimeStampUilts.stampBeforeApi("onCallStateChanged");
			super.onCallStateChanged(state, incomingNumber);
			TimeStampUilts.stampAfterApi("onCallStateChanged");
		}
	}
}