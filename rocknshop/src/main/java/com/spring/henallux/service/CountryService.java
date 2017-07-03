package com.spring.henallux.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.dao.CountryDAO;
import com.spring.henallux.model.Country;

@Service
public class CountryService {
	
	@Autowired
	private CountryDAO countryDAO;
	
	public ArrayList<Country> getCountries(){
		return countryDAO.getAllCountries();
	}
}