package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.ui.Model;

import com.spring.henallux.dataAccess.dao.EquivalentCategoryDAO;
import com.spring.henallux.model.EquivalentCategory;
import com.spring.henallux.model.OrderShop;
import com.spring.henallux.sessionAttributeModel.Categories;
import com.spring.henallux.sessionAttributeModel.ClientBasket;
import com.spring.henallux.sessionAttributeModel.ConnectedClient;
import com.spring.henallux.util.Constant;

@Controller
@RequestMapping(value = "/orderReview")
@SessionAttributes({ Constant.ORDERSHOP, Constant.CONNECTEDCLIENT, Constant.CLIENTBASKET, 
	Constant.CATEGORIES})
public class OrderReviewController {

	@Autowired
	private MessageSource titleMessage;
	
	@Autowired
	private EquivalentCategoryDAO equivalentCategoryDAO;

	@RequestMapping(value="yourOrder", method = RequestMethod.GET)
	public String getOrderReview(Model model, Locale locale,
			@ModelAttribute(value = Constant.ORDERSHOP) OrderShop orderShop,
			@ModelAttribute(value = Constant.CONNECTEDCLIENT) ConnectedClient connectedClient,
			@ModelAttribute(value = Constant.CLIENTBASKET) ClientBasket clientBasket,
			@ModelAttribute(value=Constant.CATEGORIES)Categories categories) {
		
		model.addAttribute("titlePage", titleMessage.getMessage("basketTitlePage", null, locale));
		model.addAttribute(Constant.CLIENTBASKET, clientBasket);
		model.addAttribute(Constant.CONNECTEDCLIENT, connectedClient);
		model.addAttribute(Constant.ORDERSHOP, orderShop);
		ArrayList<EquivalentCategory> listCategory = equivalentCategoryDAO.getCategoriesByLanguage(locale.getLanguage());		
		categories.setCategories(listCategory);
		model.addAttribute("categories", categories);
		
		return "integrated:orderReview";

	}

}
