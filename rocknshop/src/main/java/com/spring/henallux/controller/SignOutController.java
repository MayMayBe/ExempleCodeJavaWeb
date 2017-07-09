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
import com.spring.henallux.modelAttribute.ClientAndBasket;
import com.spring.henallux.modelAttribute.Categories;
import com.spring.henallux.service.CategoriesService;
import com.spring.henallux.util.Constant;

@Controller
@RequestMapping(value = "/signout")
@SessionAttributes({ Constant.CLIENT })
public class SignOutController {

	@Autowired
	private MessageSource titleMessage;

	@Autowired
	private CategoriesService categoriesService;

	@RequestMapping(method = RequestMethod.GET)
	public String signout(Model model, Locale locale, 
			@ModelAttribute(value = Constant.CLIENT) ClientAndBasket client,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories) {

		client.setDefault();
		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));

		model.addAttribute("titlePage", titleMessage.getMessage("accountTitlePage", null, locale));
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute(Constant.CATEGORIES, categories);
		return "integrated:welcome";
	}

}