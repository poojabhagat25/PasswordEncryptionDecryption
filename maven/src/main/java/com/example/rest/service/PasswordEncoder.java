package com.example.rest.service;

public interface PasswordEncoder {

	String encrypt(String Data, String emailId) throws Exception;

	String decrypt(String encryptedData, String emailId) throws Exception;

//	String encryptPassword(String plainTextPassword);

}
