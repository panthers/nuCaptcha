package com.github.panthers.nuCaptcha.noise;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Dots pattern noise maker for captcha.
 * Default dotSize is 1.
 * Default fill threshold is 20.
 * Default dot color is randomly selected. 
 * @author Jayant Pratim Saikia
 *
 */
public class DotsMaker implements NoiseMaker {
	
	private static final Random RAND = new SecureRandom();
	private static final int DOT_DEF_PIXEL = 1;
	private static final int DOT_FILL_THRESHOLD = 20;
	private static final Color DOT_COLOR = null; //Random dot color
	
	private final int _dotSize;
	private final int _dotFillThreshold;
	private final Color _dotColor;
	
	public DotsMaker() {
		this(DOT_DEF_PIXEL, DOT_FILL_THRESHOLD, DOT_COLOR);
	}
	
	public DotsMaker(int dotSize, int dotFillThreshold, Color dotColor) {
		this._dotSize = dotSize;
		this._dotFillThreshold = dotFillThreshold;
		this._dotColor = dotColor;
	}

	@Override
	public void noisify(BufferedImage bi) {
		Graphics2D g = bi.createGraphics();
		Color dotColor = this._dotColor;
		int fillCount = bi.getHeight() * bi.getWidth() * _dotFillThreshold / 100;
		for(int i = 0; i < fillCount; i++) {
			if(null == this._dotColor) {
				dotColor = new Color(RAND.nextInt(255), RAND.nextInt(255), RAND.nextInt(255));
			}
			g.setColor(dotColor);
			int x1 = RAND.nextInt(bi.getWidth());
			int y1 = RAND.nextInt(bi.getHeight());
			drawDot(g, x1, y1);
		}
	}
	
	private void drawDot(Graphics2D g, int x1, int y1) {
		g.fillRect(x1, y1, this._dotSize, this._dotSize);
	}

}
