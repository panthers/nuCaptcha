package com.github.panthers.nuCaptcha.base;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 * Solid color background maker.
 * Default color is light gray
 * @author Jayant Pratim Saikia
 *
 */
public class SolidBGMaker extends BGMaker {
	
	private Color BG_COLOR = Color.lightGray;
	
	public SolidBGMaker() {
	}
	
	/**
	 * Background color to be used.
	 * @param color null will create a transparent image
	 */
	public SolidBGMaker(Color color) {
		this.BG_COLOR = color;
	}

	@Override
	public BufferedImage makeBG(int width, int height) {
		if(null == this.BG_COLOR) {
			return getInitialBG(width, height);
		}
		
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = img.createGraphics();
        graphics.setPaint(this.BG_COLOR);
        graphics.fill(new Rectangle2D.Double(0, 0, width, height));
        graphics.drawImage(img, 0, 0, null);
        graphics.dispose();
        return img;
	}

}
