package br.com.jonathan.service.executor;

public class ServiceProcessorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ServiceProcessorException() {
		super();
	}

	public ServiceProcessorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceProcessorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceProcessorException(String message) {
		super(message);
	}

	public ServiceProcessorException(Throwable cause) {
		super(cause);
	}

}