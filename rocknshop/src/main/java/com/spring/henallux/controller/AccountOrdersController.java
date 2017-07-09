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

import com.spring.henallux.dataAccess.dao.OrderShopDAO;
import com.spring.henallux.model.OrderShop;
import com.spring.henallux.modelAttribute.Categories;
import com.spring.henallux.modelAttribute.ClientAndBasket;
import com.spring.henallux.service.CategoriesService;
import com.spring.henallux.util.Constant;

@Controller
@RequestMapping(value = "/accountOrders")
@SessionAttributes({ Constant.CLIENT })
public class AccountOrdersController {

	@Autowired
	private OrderShopDAO orderShopDAO;

	@Autowired
	private MessageSource titleMessage;

	@Autowired
	private CategoriesService categoriesService;

	@RequestMapping(method = RequestMethod.GET)
	public String getOrders(Model model, Locale locale, @ModelAttribute(value = Constant.CLIENT) ClientAndBasket client,
			@ModelAttribute(value = "orderShopSelection") OrderShop orderSelection,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories) {

		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));

		ArrayList<OrderShop> orderShop = new ArrayList<OrderShop>();
		orderShop = orderShopDAO.findOrderByIdClient(client.getIdClient());

		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute(Constant.ORDERS, orderShop);
		model.addAttribute("orderShopSelection", orderSelection);
		model.addAttribute("titlePage", titleMessage.getMessage("accountTitlePage", null, locale));
		model.addAttribute(Constant.CATEGORIES, categories);
		return "integrated:accountOrders";
	}

}
