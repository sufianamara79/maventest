package com.google.qa.testcases;
import org.apache.commons.codec.binary.Base64;

public class Encode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String password = "sufian123";
		
		byte[] encodedBytes = Base64.encodeBase64(password.getBytes());
		System.out.println("encodedBytes " + new String(encodedBytes));
		
		byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
		System.out.println("decodedBytes " + new String(decodedBytes));
		System.out.println(System.getenv("USERNAME"));
	}

}
