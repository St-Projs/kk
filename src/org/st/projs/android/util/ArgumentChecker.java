package org.st.projs.android.util;

public final class ArgumentChecker {

	public static void checkTrue(boolean b) {
		checkTrue(b, null);
	}

	public static void checkTrue(boolean b, String message)
			throws ArgumentException {
		if (b) {
			String msg = "Argument is true.";
			if (message != null) {
				msg += ": " + message;
			}
			throw new ArgumentException(msg);
		}
	}

	public static void checkFalse(boolean b) {
		checkFalse(b, null);
	}

	public static void checkFalse(boolean b, String message) {
		if (!b) {
			String msg = "Argument is false.";
			if (message != null) {
				msg += ": " + message;
			}
			throw new ArgumentException(msg);
		}
	}

	public static void checkNull(Object arg) {
		checkNull(arg, null);
	}

	public static void checkNull(Object arg, String message)
			throws ArgumentException {
		if (arg == null) {
			String msg = "Argument is null";
			if (message != null) {
				msg += ": " + message;
			}
			throw new ArgumentException(msg);
		}
	}

	public static void checkNullAndEmpty(String arg) throws ArgumentException {
		checkNullAndEmpty(arg, null);
	}

	public static void checkNullAndEmpty(String arg, String message)
			throws ArgumentException {
		checkNull(arg, message);

		if ("".equals(message)) {
			String msg = "Argument is empty.";
			if (message != null) {
				msg += ": " + message;
			}
			throw new ArgumentException(msg);
		}
	}

	public static void checkRange(int arg, int min, int max) {
		checkRange(arg, min, max, null);
	}

	public static void checkRange(int arg, int min, int max, String message) {
		if (arg < min || max < arg) {
			String msg = "Invalid range argument.";
			if (message != null) {
				msg += ": " + message;
			}
			throw new ArgumentException(msg);
		}
	}

	private ArgumentChecker() {
	}

}
