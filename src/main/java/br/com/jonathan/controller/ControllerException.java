package br.com.jonathan.controller;

public class ControllerException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ControllerException() {
		super();
	}

	public ControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ControllerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ControllerException(String message) {
		super(message);
	}

	public ControllerException(Throwable cause) {
		super(cause);
	}

}