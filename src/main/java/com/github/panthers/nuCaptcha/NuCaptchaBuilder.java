package com.github.panthers.nuCaptcha;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.github.panthers.nuCaptcha.base.BGMaker;
import com.github.panthers.nuCaptcha.base.SolidBGMaker;
import com.github.panthers.nuCaptcha.exception.CaptchaBasePreparationException;
import com.github.panthers.nuCaptcha.exception.NuCaptchaException;
import com.github.panthers.nuCaptcha.noise.NoiseMaker;
import com.github.panthers.nuCaptcha.text.generators.TxtGenerator;
import com.github.panthers.nuCaptcha.text.renderer.DefaultTxtRenderer;
import com.github.panthers.nuCaptcha.text.renderer.TxtRenderer;

/**
 * The nuCaptchaBuilder class builds the nuCaptcha instance based on the configurations provided.
 * prepareBase must called before building the nuCaptcha
 * addTextGenerator must be called before building the nuCaptcha
 * addTextRenderer must be called before building the nuCaptcha
 * @author Jayant Pratim Saikia
 *
 */
public class NuCaptchaBuilder {
	
	private BufferedImage _image;
	private String _text;
	private TxtGenerator _txtGenerator;
	private TxtRenderer _txtRenderer;
	private List<NoiseMaker> _noiseMakers = new ArrayList<NoiseMaker>();
	
	/**
	 * Will prepare the inital captcha with default BGMaker i.e. SolidBGMaker
	 * @param width with of captcha
	 * @param height height of captcha
	 * @return the builder
	 */
	public NuCaptchaBuilder prepareBase(int width, int height) throws NuCaptchaException {
		return prepareBase(width, height, new SolidBGMaker());
	}
	
	/**
	 * Will prepare the inital captcha with given BGMaker
	 * @param width with of captcha
	 * @param height height of captcha
	 * @param bgMaker bgMaker
	 * @return the builder
	 */
	public NuCaptchaBuilder prepareBase(int width, int height, BGMaker bgMaker) throws NuCaptchaException {
		if(null == this._image) {
			this._image = bgMaker.makeBG(width, height);
		} else {
			throw new CaptchaBasePreparationException("Base was already prepared");
		}
		return this;
	}
	
	/**
	 * Provide the text generator to use.
	 * @param txtGenerator
	 * @return the builder
	 */
	public NuCaptchaBuilder addTextGenerator(TxtGenerator txtGenerator) {
		this._txtGenerator = txtGenerator;
		return this;
	}
	
	/**
	 * Provide the text renderer to use
	 * @param txtRenderer
	 * @return the builder
	 */
	public NuCaptchaBuilder addTextRenderer(TxtRenderer txtRenderer) {
		this._txtRenderer = txtRenderer;
		return this;
	}
	
	/**
	 * Provide the noise makers to use. You can add multiple noise makers
	 * @param noiseMaker
	 * @return the builder
	 */
	public NuCaptchaBuilder addNoise(NoiseMaker noiseMaker) {
		this._noiseMakers.add(noiseMaker);
		return this;
	}
	
	/**
	 * Build the captcha
	 * @return nuCaptcha
	 */
	public NuCaptcha build() {
		if(null == this._txtGenerator) {
			this._txtGenerator = new TxtGenerator();
		}
		this._text = this._txtGenerator.getTxt();
		if(null == this._txtRenderer) {
			this._txtRenderer = new DefaultTxtRenderer();
		}
		this._txtRenderer.render(this._text, this._image);
		for(NoiseMaker noiseMaker : this._noiseMakers) {
			noiseMaker.noisify(this._image);
		}
		return new NuCaptcha(this._image, this._text);
	}
	
	/**
	 * Used only for testing purpose
	 * @return the current state of image
	 */
	protected BufferedImage getImage() {
		return this._image;
	}
	
	/**
	 * Used only for testing purpose
	 */
	protected String getText() {
		return this._text;
	}

}
