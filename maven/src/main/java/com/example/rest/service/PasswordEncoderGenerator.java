package com.example.rest.service;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.security.*;
import sun.misc.*;

/**
 * 
 * @author Pooja Bhagat.
 * 
 * Encryption and Decryption of Data using AES algorithm with example code
 *
 */

public class PasswordEncoderGenerator implements PasswordEncoder {

	// static Cipher cipher;

	private static final String ALGO = "AES";


	
	@SuppressWarnings("restriction")
	public String encrypt(String Data, String emailId) throws Exception {
		Key key = generateKey(emailId.getBytes());
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(Data.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}

	
	@SuppressWarnings("restriction")
	public String decrypt(String encryptedData, String emailId) throws Exception {
		Key key = generateKey(emailId.getBytes());
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
		byte[] decValue = c.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	private static Key generateKey(byte[] keyValue) throws Exception {
		keyValue = Arrays.copyOf(keyValue, 16);
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}

}
