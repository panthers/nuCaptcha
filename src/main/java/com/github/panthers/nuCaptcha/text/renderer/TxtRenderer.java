package com.github.panthers.nuCaptcha.text.renderer;

import java.awt.image.BufferedImage;

/**
 * Captcha text renderer interface
 * @author Jayant Pratim Saikia
 *
 */
public interface TxtRenderer {
	
	/**
	 * Render text to a buffered image
	 * @param txt
	 * @param bi
	 */
	public void render(final String txt, BufferedImage bi);

}
