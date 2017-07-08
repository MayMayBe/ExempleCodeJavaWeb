package com.spring.henallux.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.dao.ModelDAO;

@Service
public class ModelService {

	
	@Autowired
	private ModelDAO modelDAO;
	
	public ArrayList<com.spring.henallux.model.Model> getLast10Models(){
		return modelDAO.findTop10ByOrderByIdModelDesc();
	}
	
	public ArrayList<com.spring.henallux.model.Model> getModelsByCategory(Integer id){
		return modelDAO.findModelsByCategory(id);
	}
	
}