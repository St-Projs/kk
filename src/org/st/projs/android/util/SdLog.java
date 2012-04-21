package org.st.projs.android.util;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import android.os.Environment;
import android.util.Log;

public class SdLog {
	private final static String LOGDIR = Environment
			.getExternalStorageDirectory().getPath() + "/hoge/";
	private final static String SDFILE = LOGDIR + "log.txt";
	private static boolean enable = true;

	static public void put(String text) {
		if (!enable)
			return;
		Date now = new Date();
		BufferedWriter bw = null;
		StackTraceElement[] ste = (new Throwable()).getStackTrace();
		text = ste[1].getMethodName() + "(" + ste[1].getFileName() + ":"
				+ ste[1].getLineNumber() + ") " + text;
		try {
			try {
				mkdir_p(LOGDIR);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			FileOutputStream file = new FileOutputStream(SDFILE, true);
			bw = new BufferedWriter(new OutputStreamWriter(file, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			bw.append((now.getYear() + 1900) + "/" + (now.getMonth() + 1) + "/"
					+ now.getDate() + " " + now.getHours() + ":"
					+ now.getMinutes() + ":" + now.getSeconds() + "\t" + text
					+ "\n");
			Log.e("log",
					(now.getYear() + 1900) + "/" + (now.getMonth() + 1) + "/"
							+ now.getDate() + " " + now.getHours() + ":"
							+ now.getMinutes() + ":" + now.getSeconds() + "\t"
							+ text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		bw = null;
	}

	public static boolean mkdir_p(File dir) throws IOException {
		if (!dir.exists()) {
			if (!dir.mkdirs()) {
				throw new IOException("File.mkdirs() failed.");
			}
			return true;
		} else if (!dir.isDirectory()) {
			throw new IOException("Cannot create path. " + dir.toString()
					+ " already exists and is not a directory.");
		} else {
			return false;
		}
	}

	public static boolean mkdir_p(String dir) throws IOException {
		return mkdir_p(new File(dir));
	}
}