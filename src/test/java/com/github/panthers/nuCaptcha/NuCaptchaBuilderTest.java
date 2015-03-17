package com.github.panthers.nuCaptcha;

import org.junit.Assert;
import org.junit.Test;

import com.github.panthers.nuCaptcha.exception.CaptchaBasePreparationException;
import com.github.panthers.nuCaptcha.exception.NuCaptchaException;
import com.github.panthers.nuCaptcha.noise.LineMaker;

/**
 * Rudimentary tests for the nucaptcha builder
 * @author Jayant Pratim Saikia
 *
 */
public class NuCaptchaBuilderTest {
	
	@Test
	public void prepareTest1() throws NuCaptchaException {
		NuCaptchaBuilder builder = new NuCaptchaBuilder();
		builder.prepareBase(200, 50);
		Assert.assertEquals(200, builder.getImage().getWidth());
		Assert.assertEquals(50, builder.getImage().getHeight());
	}
	
	@Test(expected = CaptchaBasePreparationException.class)
	public void prepareTest2() throws NuCaptchaException {
		NuCaptchaBuilder builder = new NuCaptchaBuilder();
		builder.prepareBase(200, 50);
		builder.prepareBase(200, 100);
	}
	
	@Test
	public void buildTest() throws NuCaptchaException {
		NuCaptchaBuilder builder = new NuCaptchaBuilder()
			.prepareBase(200, 50)
			.addNoise(new LineMaker());
		NuCaptcha nuCaptcha = builder.build();
		Assert.assertEquals(200, nuCaptcha.getImage().getWidth());
		Assert.assertEquals(50, nuCaptcha.getImage().getHeight());
		Assert.assertTrue(nuCaptcha.match(builder.getText()));
		Assert.assertFalse(nuCaptcha.match("Random"));
	}

}
