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
import com.spring.henallux.modelAttribute.PasswordChangeForm;
import com.spring.henallux.modelAttribute.UpdateClientForm;
import com.spring.henallux.service.CategoriesService;
import com.spring.henallux.util.Constant;
import com.spring.henallux.util.SHA256;

@Controller
@RequestMapping(value = "/changePassword")
@SessionAttributes({ Constant.CLIENT })

public class ChangePasswordController {

	@Autowired
	private MessageSource titleMessage;

	@Autowired
	private ClientDAO clientDAO;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private SHA256 sha256;

	@ModelAttribute(Constant.UPDATECLIENTFORM)
	public UpdateClientForm updateClientForm() {
		return new UpdateClientForm();
	}

	@Autowired
	private CategoriesService categoriesService;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model, Locale locale, @ModelAttribute(value = Constant.CLIENT) ClientAndBasket client,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories,
			@ModelAttribute(value = Constant.ERRORMESSAGE) String errorMessage) {

		errorMessage = "";

		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));

		model.addAttribute("titlePage", titleMessage.getMessage("accountTitlePage", null, locale));
		model.addAttribute(Constant.PASSWORDCHANGEFORM, new PasswordChangeForm());
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute(Constant.CATEGORIES, categories);
		model.addAttribute(Constant.ERRORMESSAGE, errorMessage);
		return "integrated:changePassword";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/signout")
	public String signout(Model model, Locale locale, @ModelAttribute(value = Constant.CLIENT) ClientAndBasket client,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories) {

		client.setDefault();
		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));

		model.addAttribute("titlePage", titleMessage.getMessage("accountTitlePage", null, locale));
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute(Constant.CATEGORIES, categories);
		return "integrated:welcome";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String changePassword(Model model, Locale locale,
			@ModelAttribute(value = Constant.CLIENT) ClientAndBasket client,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories,
			@ModelAttribute(value = Constant.PASSWORDCHANGEFORM) PasswordChangeForm passwordForm,
			@ModelAttribute(value = Constant.ERRORMESSAGE) String errorMessage) {

		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));

		errorMessage = "";

		Client savedClient = clientDAO.findByEmail(client.getEmail());

		if (passwordForm.getOldPassword().isEmpty() || passwordForm.getNewPassword().isEmpty()
				|| passwordForm.getRetypeNewPassword().isEmpty()) {
			errorMessage = messageSource.getMessage("passwordsError", null, locale);
		} else {
			if (!sha256.correctPassword(savedClient.getPassword(), passwordForm.getOldPassword())) {
				errorMessage = messageSource.getMessage("oldPasswordError", null, locale);
			} else {
				if (passwordForm.getNewPassword().length() < 8 || passwordForm.getNewPassword().length() > 65) {
					errorMessage = messageSource.getMessage("newPasswordError", null, locale);
				} else {
					if (passwordForm.getRetypeNewPassword().length() < 8
							|| passwordForm.getRetypeNewPassword().length() > 65) {
						errorMessage = messageSource.getMessage("passwordConfirmError", null, locale);
					} else {
						if (!passwordForm.getNewPassword().equals(passwordForm.getRetypeNewPassword())) {
							errorMessage = messageSource.getMessage("passwordMatchError", null, locale);
						}
					}
				}
			}
		}

		if (errorMessage.isEmpty()) {

			savedClient.setPassword(sha256.encodePassword(passwordForm.getNewPassword()));
			clientDAO.update(savedClient);
			errorMessage = "0";
		}

		model.addAttribute(Constant.PASSWORDCHANGEFORM, passwordForm);
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute(Constant.CATEGORIES, categories);
		model.addAttribute("titlePage", titleMessage.getMessage("accountTitlePage", null, locale));
		model.addAttribute(Constant.ERRORMESSAGE, errorMessage);

		return "integrated:changePassword";
	}

}
