package com.spring.henallux.controller;


import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.modelAttribute.Categories;
import com.spring.henallux.modelAttribute.ClientAndBasket;
import com.spring.henallux.service.CategoriesService;
import com.spring.henallux.service.ModelService;
import com.spring.henallux.util.Constant;


@Controller
@RequestMapping(value="/welcome")
@SessionAttributes({Constant.CLIENT})
public class WelcomeController {
	

	@Autowired
	private CategoriesService categoriesService;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private MessageSource titleMessage;
	
	@ModelAttribute(Constant.CLIENT)
	public ClientAndBasket newClient(){
		return new ClientAndBasket();
	}
	

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale, 
			@ModelAttribute(value=Constant.CLIENT) ClientAndBasket client,
			@ModelAttribute(value=Constant.CATEGORIES)Categories categories){
		
		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));
		
		model.addAttribute(Constant.MODEL, modelService.getLast10Models());
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute(Constant.CATEGORIES, categories);
		model.addAttribute("titlePage", titleMessage.getMessage("homeTitlePage", null, locale));
		
		return "integrated:welcome";
	}

	
}