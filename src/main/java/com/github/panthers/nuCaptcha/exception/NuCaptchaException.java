package com.github.panthers.nuCaptcha.exception;

/**
 * NuCaptcha exception class 
 * @author Jayant Pratim Saikia
 *
 */
public class NuCaptchaException extends Exception {

	private static final long serialVersionUID = 8398316946495665160L;

	public NuCaptchaException() {
		super();
	}

	public NuCaptchaException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NuCaptchaException(String message, Throwable cause) {
		super(message, cause);
	}

	public NuCaptchaException(String message) {
		super(message);
	}

	public NuCaptchaException(Throwable cause) {
		super(cause);
	}
	
}
