package org.st.projs.android.util;

public class DaoException extends RuntimeException {

	private static final long serialVersionUID = -2962221591236461654L;

	public enum Error {
		ERROR, NOT_FOUND, CONSTRAINT;
	}

	private Error err;

	public DaoException(Error err) {
		super();

		ArgumentChecker.checkNull(err);

		this.err = err;
	}

	public DaoException(Error err, String msg) {
		super(msg);

		ArgumentChecker.checkNull(err);

		this.err = err;
	}

	public DaoException(Error err, Throwable cause) {
		super(cause);

		ArgumentChecker.checkNull(err);

		this.err = err;
	}

	public DaoException(Error err, String msg, Throwable cause) {
		super(msg);

		ArgumentChecker.checkNull(err);

		this.err = err;
	}

	public Error getError() {
		return this.err;
	}
}
