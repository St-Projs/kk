package org.st.projs.android.util;

import android.location.LocationManager;

public class GpsProcess {

	static public boolean chkGpsService(LocationManager location) {
		if (!location.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			return false;
		} else {
			return true;
		}
	}
}
