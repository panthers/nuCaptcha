package com.github.panthers.nuCaptcha.base;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Abstract captcha background maker
 * @author Jayant Pratim Saikia
 *
 */
public abstract class BGMaker {
	
	/**
	 * Generates a transparent image canvas for more painting
	 * @param width
	 * @param height
	 * @return the image
	 */
	protected BufferedImage getInitialBG(int width, int height) {
		BufferedImage bg = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
		Graphics2D g = bg.createGraphics();

		g.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
		g.fillRect(0, 0, width, height);
		
		return bg;
	}
	
	/**
	 * Build the base according to the implementor
	 * @return the image
	 */
	public abstract BufferedImage makeBG(int width, int height);

}
