package com.github.panthers.nuCaptcha.text.generators;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

/**
 * The random text generator. Can be customized to set characters to use and length.
 * 
 * @author Jayant Pratim Saikia
 *
 */
public class TxtGenerator {
	
	private static final Random RAND = new SecureRandom();
	private static final int DEFAULT_LENGTH = 5;
    private static final char[] DEFAULT_CHARS = new char[] { 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i','j', 'k', 'l', 'm', 'n','o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    private final int _length;
    private final char[] _srcChars;

    public TxtGenerator() {
    	this(DEFAULT_LENGTH, DEFAULT_CHARS);
    }
    
    public TxtGenerator(int length) {
    	this(length, DEFAULT_CHARS);
    }
    
    public TxtGenerator(int length, char[] srcChars) {
    	this._length = length;
    	this._srcChars = Arrays.copyOf(srcChars, srcChars.length);
    }
    
    /**
     * Get the random text.
     * @return
     */
    public String getTxt() {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < this._length; i++) {
    		sb.append(_srcChars[RAND.nextInt(_srcChars.length)]);
    	}
    	return sb.toString();
    }

}
