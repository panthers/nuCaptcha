package com.github.panthers.nuCaptcha;

import java.awt.image.BufferedImage;

/**
 * nuCaptcha. Generate using the nuCaptchaBuilder
 * @author Jayant Pratim Saikia
 *
 */
public class NuCaptcha {
	
	private BufferedImage _image;
	
	private String _text;
	
	/**
	 * Generate captcha image from the NuCaptchaBuilder
	 */
	protected NuCaptcha(BufferedImage image, String text) {
		this._image = image;
		this._text = text;
	}
	
	public boolean match(String text) {
		return this._text.equals(text);
	}
	
	public BufferedImage getImage() {
		return this._image;
	}

}
