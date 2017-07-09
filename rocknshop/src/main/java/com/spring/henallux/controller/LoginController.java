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
import com.spring.henallux.dataAccess.dao.ClientDAO;
import com.spring.henallux.model.Client;
import com.spring.henallux.modelAttribute.Categories;
import com.spring.henallux.modelAttribute.ClientAndBasket;
import com.spring.henallux.modelAttribute.ClientLogin;
import com.spring.henallux.service.CategoriesService;
import com.spring.henallux.util.*;

@Controller
@RequestMapping(value = "/login")
@SessionAttributes({ Constant.CLIENT })
public class LoginController {

	@Autowired
	private MailChecker mailChecker;

	@Autowired
	private SHA256 sha256;

	@Autowired
	private CategoriesService categoriesService;

	@Autowired
	private ClientDAO clientDAO;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model, Locale locale, @ModelAttribute(value = Constant.CLIENT) ClientAndBasket client,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories,
			@ModelAttribute(value = Constant.CLIENTLOGIN) ClientLogin clientLogin,
			@ModelAttribute(value = Constant.ERRORMESSAGE) String errorMessage) {

		if (client.getIdClient() != 0)
			return "integrated:changePassword";

		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));
		errorMessage = "";

		model.addAttribute(Constant.ERRORMESSAGE, errorMessage);
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute("titlePage", messageSource.getMessage("loginTitlePage", null, locale));
		model.addAttribute(Constant.CATEGORIES, categories);
		model.addAttribute(Constant.CLIENTLOGIN, clientLogin);
		return "integrated:login";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String getLoginData(Model model, Locale locale,
			@ModelAttribute(value = Constant.CLIENT) ClientAndBasket client,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories,
			@ModelAttribute(value = Constant.CLIENTLOGIN) ClientLogin clientLogin,
			@ModelAttribute(value = Constant.ERRORMESSAGE) String errorMessage) {

		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));

		errorMessage = "";

		if (client.getIdClient() != 0)
			return "integrated:changePassword";

		if (clientLogin.getEmail().isEmpty() || !mailChecker.isEmailValid(clientLogin.getEmail())) {
			errorMessage = messageSource.getMessage("mailError", null, locale);
		} else {
			if (clientLogin.getPassword().isEmpty()) {
				errorMessage = messageSource.getMessage("emptyPassword", null, locale);
			} else {

				Client clientSystem = clientDAO.findByEmail(clientLogin.getEmail());

				if (clientSystem == null
						|| !sha256.correctPassword(clientSystem.getPassword(), clientLogin.getPassword())) {
					errorMessage = messageSource.getMessage("loginIncorrect", null, locale);
				} else {
					client.setIdClient(clientSystem.getIdClient());
					client.setFirstName(clientSystem.getFirstName());
					client.setLastName(clientSystem.getLastName());
					client.setCountry(clientSystem.getCountry().getCountryName());
					client.setEmail(clientSystem.getEmail());
				}
			}
		}

		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute("titlePage", messageSource.getMessage("loginTitlePage", null, locale));
		model.addAttribute(Constant.CATEGORIES, categories);

		if (errorMessage.isEmpty()) {
			return "integrated:welcome";
		} else {
			model.addAttribute(Constant.ERRORMESSAGE, errorMessage);
			model.addAttribute(Constant.CLIENTLOGIN, clientLogin);
			return "integrated:login";
		}
	}

}
