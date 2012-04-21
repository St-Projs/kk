package org.st.projs.android.util;

import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Contains global application constants.
 * 
 * @author mogura
 * 
 */
public class Constants {

	public static final int RESULT_OK = Activity.RESULT_OK;
	public static final int RESULT_CANCELED = Activity.RESULT_CANCELED;
	public static final int RESULT_UNKNOWN = RESULT_CANCELED + 1;
	public static final int RESULT_CLEAR = RESULT_CANCELED + 2;
	public static final int RESULT_UPDATE = RESULT_CANCELED + 3;

	// Gets the unique device ID in a uniform way
	public static String getAndroidID(Context c) {
		String aid = ((TelephonyManager) c
				.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
		return aid;
	}
}
