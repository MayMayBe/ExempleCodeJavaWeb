package com.spring.henallux.controller;


import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.EquivalentCategoryDAO;
import com.spring.henallux.model.EquivalentCategory;
import com.spring.henallux.sessionAttributeModel.Categories;
import com.spring.henallux.util.Constant;


@Controller
@RequestMapping(value="/aboutus")
@SessionAttributes({Constant.CATEGORIES})
public class AboutUsController {
	
	@Autowired
	private MessageSource titleMessage;
	
	@Autowired
	private EquivalentCategoryDAO equivalentCategoryDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale, @ModelAttribute(value=Constant.CATEGORIES)Categories categories){
		model.addAttribute("titlePage", titleMessage.getMessage("aboutusTitlePage", null, locale));
		ArrayList<EquivalentCategory> listCategory = equivalentCategoryDAO.getCategoriesByLanguage(locale.getLanguage());		
		categories.setCategories(listCategory);
		model.addAttribute("categories", categories);
		return "integrated:aboutus";
	}

}
