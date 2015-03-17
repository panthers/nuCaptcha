package com.github.panthers.nuCaptcha.text.renderer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

/**
 * Renders the text to the image provided.
 * 
 * @author Jayant Pratim Saikia
 *
 */
public class DefaultTxtRenderer implements TxtRenderer {
	
	private static final Random RAND = new SecureRandom();
	private static final double X_DEF_OFFSET = 0.05D;
	private static final double Y_DEF_OFFSET = 0.25D;
	private static final Color DEFAULT_COLOR = Color.BLACK;
	private static final Font[] DEFAULT_FONTS = new Font[] {
		new Font("Arial", Font.BOLD, 30),
		new Font("Arial", Font.ITALIC, 40),
		new Font("Courier", Font.BOLD, 30),
		new Font("Courier", Font.ITALIC, 40)
	};
	
	private final Color _fontColor;
	private final Font[] _fontsToUse;
	private final double xOffset;
	private final double yOffset;
	
	/**
	 * Default Color Black
	 * Default Fonts Arial B 20, Courier B 20, Arial I 40, Courier I 40
	 * Default x axis offset 0.05 % of width
	 * Default y axis offset 0.25 % of height 
	 */
	public DefaultTxtRenderer() {
		this(DEFAULT_COLOR, DEFAULT_FONTS, X_DEF_OFFSET, Y_DEF_OFFSET);
	}
	
	/**
	 * Default x axis offset 0.05 % of width
	 * Default y axis offset 0.25 % of height 
	 */
	public DefaultTxtRenderer(Color fontColor, Font[] fonts) {
		this(fontColor, fonts, X_DEF_OFFSET, Y_DEF_OFFSET);
	}
	
	public DefaultTxtRenderer(Color fontColor, Font[] fonts, double xOffset, double yOffset) {
		if(null != fontColor) {
			this._fontColor = fontColor;
		} else {
			this._fontColor = Color.BLACK;
		}
		this._fontsToUse = Arrays.copyOf(fonts, fonts.length);
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	@Override
	public void render(String txt, BufferedImage bi) {
		Graphics2D g = bi.createGraphics();
		g.setColor(this._fontColor);
		
		FontRenderContext frc = g.getFontRenderContext();
		int xPos = (int) Math.round(bi.getWidth() * this.xOffset);
		int yPos = bi.getHeight() - (int) Math.round(bi.getHeight() * this.yOffset);
		
		int txtLen = txt.length();
		for(int i = 0; i < txtLen; i++) {
			char[] chars = new char[] {txt.charAt(i)};
			g.setFont(_fontsToUse[RAND.nextInt(_fontsToUse.length)]);
			
			GlyphVector gv = g.getFont().createGlyphVector(frc, chars);
			g.drawChars(chars, 0, 1, xPos, yPos);
			
			//Next character should be printed after the previous character
			xPos += (int) gv.getVisualBounds().getWidth();
		}
	}

}
