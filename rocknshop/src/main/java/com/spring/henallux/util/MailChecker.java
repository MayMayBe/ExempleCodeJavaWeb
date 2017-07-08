package com.spring.henallux.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class MailChecker {

	public boolean isEmailValid(String string){
		
		Pattern pattern = Pattern.compile("^[A-Za-z0-9._]{1,16}+@{1}+[a-z]{1,7}\\.[a-z]{1,3}$");
        Matcher mail = pattern.matcher(string);

        return mail.find();
        
	}
	
}
