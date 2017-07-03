package com.spring.henallux.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.spring.henallux.model.Client;

public class SHA256 {

	
	public static String encodePassword(String clientPassword){
		
		String password = clientPassword;
        MessageDigest md = null;
        
        try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
	
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
	
	}
	
	public static Boolean correctPassword(Client clientRecord, Client clientOnWebsite){
		
		String password = encodePassword(clientOnWebsite.getPassword());
		
		if(clientRecord.getPassword().equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	
	
}
