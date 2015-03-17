package com.github.panthers.nuCaptcha.noise;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Line pattern noise maker for captcha
 * Default line thickness is 1.
 * Default horizontal lines.
 * Default fill threshold is 5.
 * Default line color is randomly selected.
 * @author Jayant Pratim Saikia
 *
 */
public class LineMaker implements NoiseMaker {
	
	private static final Random RAND = new SecureRandom();
	private static final int DEF_LINE_THICKNESS = 1;
	private static final boolean DEF_HORIZ_LINE = true;
	private static final int DEF_THRESHOLD = 5;
	private static final Color DEF_LINE_COLOR = null; //Random line color 
	
	private final int _lineThickness;
	private final boolean _horizontal;
	private final int _threshold;
	private final Color _lineColor;

	public LineMaker() {
		this(DEF_LINE_THICKNESS, DEF_HORIZ_LINE, DEF_THRESHOLD, DEF_LINE_COLOR);
	}
	
	public LineMaker(int lineThickness, boolean horizontal, int threshold, Color lineColor) {
		this._lineThickness = lineThickness;
		this._horizontal = horizontal;
		this._threshold = threshold;
		this._lineColor = lineColor;
	}
	
	@Override
	public void noisify(BufferedImage bi) {
		Graphics2D g = bi.createGraphics();
		int fillCount = this._horizontal ? bi.getHeight() * this._threshold / 100 : bi.getWidth() * this._threshold / 100;
		for(int i = 0; i < fillCount; i++) {
			Color lineColor = this._lineColor;
			if(null == this._lineColor) {
				lineColor = new Color(RAND.nextInt(255), RAND.nextInt(255), RAND.nextInt(255));
			}
			g.setColor(lineColor);
			Point startPt = new Point(this._horizontal ? 0 : RAND.nextInt(bi.getWidth()), this._horizontal ? RAND.nextInt(bi.getHeight()) : 0);
			Point endPt = new Point(this._horizontal ? bi.getWidth() : startPt.x, this._horizontal ? startPt.y : bi.getHeight());
			drawLine(g, startPt, endPt);
		}
	}
	
	private void drawLine(Graphics2D g, Point startPt, Point endPt) {
		int[] xPoints = new int[] {
				startPt.x,
				startPt.x + this._lineThickness,
				endPt.x,
				endPt.x - this._lineThickness
				};
		int[] yPoints = new int[] {
				startPt.y,
				startPt.y + this._lineThickness,
				endPt.y,
				endPt.y - this._lineThickness
				};
		g.fillPolygon(xPoints, yPoints, 4);
	}

}
