package com.github.panthers.nuCaptcha.noise;

import java.awt.image.BufferedImage;

/**
 * Captcha noise maker interface
 * @author Jayant Pratim Saikia
 *
 */
public interface NoiseMaker {
	
	/**
	 * Add noise to the image
	 * @param bi
	 */
	public void noisify(BufferedImage bi);

}
