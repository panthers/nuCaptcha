package com.github.panthers.nuCaptcha.exception;

/**
 * Captcha base preparation exception
 * @author Jayant Pratim Saikia
 *
 */
public class CaptchaBasePreparationException extends NuCaptchaException {

	private static final long serialVersionUID = -8106743967222200945L;

	public CaptchaBasePreparationException() {
		super();
	}

	public CaptchaBasePreparationException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CaptchaBasePreparationException(String message, Throwable cause) {
		super(message, cause);
	}

	public CaptchaBasePreparationException(String message) {
		super(message);
	}

	public CaptchaBasePreparationException(Throwable cause) {
		super(cause);
	}

}
