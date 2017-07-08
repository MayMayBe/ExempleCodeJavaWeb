package com.spring.henallux.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import com.spring.henallux.model.Client;

@Service
public class SHA256 {

	
	public String encodePassword(String clientPassword){
		
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
	
	public Boolean correctPassword(String passwordClient, String passwordLogin){
		
		String password = encodePassword(passwordLogin);
		
		if(passwordClient.equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	
	
}
