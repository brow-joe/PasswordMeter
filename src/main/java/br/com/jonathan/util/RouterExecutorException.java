package br.com.jonathan.util;

public class RouterExecutorException extends Exception {
	private static final long serialVersionUID = 1L;

	public RouterExecutorException() {
		super();
	}

	public RouterExecutorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RouterExecutorException(String message, Throwable cause) {
		super(message, cause);
	}

	public RouterExecutorException(String message) {
		super(message);
	}

	public RouterExecutorException(Throwable cause) {
		super(cause);
	}

}