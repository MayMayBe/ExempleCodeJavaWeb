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
import com.spring.henallux.dataAccess.dao.ClientDAO;
import com.spring.henallux.dataAccess.dao.CountryDAO;
import com.spring.henallux.dataAccess.dao.EquivalentCategoryDAO;
import com.spring.henallux.model.Client;
import com.spring.henallux.model.Country;
import com.spring.henallux.model.EquivalentCategory;
import com.spring.henallux.modelAttribute.Categories;
import com.spring.henallux.modelAttribute.ClientAndBasket;
import com.spring.henallux.modelAttribute.Countries;
import com.spring.henallux.modelAttribute.NewClient;
import com.spring.henallux.service.CategoriesService;
import com.spring.henallux.service.CountryService;
import com.spring.henallux.util.*;

@Controller
@RequestMapping(value = "/register")

@SessionAttributes({ Constant.CLIENT })
public class RegisterController {

	@Autowired
	private MailChecker mailChecker;

	@Autowired
	private SHA256 sha256;

	@Autowired
	private CategoriesService categoriesService;

	@Autowired
	private ClientDAO clientDAO;

	@Autowired
	private CountryDAO countryDAO;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CountryService countryService;

	@Autowired
	private EquivalentCategoryDAO equivalentCategoryDAO;

	public ArrayList<EquivalentCategory> setCategory(Locale locale) {
		ArrayList<EquivalentCategory> listCategory = equivalentCategoryDAO
				.getCategoriesByLanguage(locale.getLanguage());
		return listCategory;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model, Locale locale, @ModelAttribute(value = Constant.CLIENT) ClientAndBasket client,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories,
			@ModelAttribute(value = Constant.COUNTRIES) Countries countries,
			@ModelAttribute(value = Constant.NEWCLIENT) NewClient newClient,
			@ModelAttribute(value = Constant.ERRORMESSAGE) String errorMessage) {

		if (client.getIdClient() != 0)
			return "integrated:changePassword";

		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));
		countries.setCountryList(countryService.getCountries());

		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute("titlePage", messageSource.getMessage("loginTitlePage", null, locale));
		model.addAttribute("categories", categories);
		model.addAttribute(Constant.CATEGORIES, categories);
		model.addAttribute(Constant.COUNTRIES, countries);
		model.addAttribute(Constant.NEWCLIENT, newClient);
		model.addAttribute(Constant.ERRORMESSAGE, "");
		return "integrated:register";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String getFormData(Model model, Locale locale,
			@ModelAttribute(value = Constant.CLIENT) ClientAndBasket client,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories,
			@ModelAttribute(value = Constant.COUNTRIES) Countries countries,
			@ModelAttribute(value = Constant.NEWCLIENT) NewClient newClient,
			@ModelAttribute(value = Constant.ERRORMESSAGE) String errorMessage) {

		categories.setCategories(setCategory(locale));
		countries.setCountryList(countryService.getCountries());

		errorMessage = "";

		if (newClient.getLastName().isEmpty() || newClient.getLastName().length() > 50) {
			errorMessage = messageSource.getMessage("lastNameError", null, locale);
		} else {
			if (newClient.getFirstName().isEmpty() || newClient.getFirstName().length() > 50) {
				errorMessage = messageSource.getMessage("firstNameError", null, locale);
			} else {
				if (newClient.getEmail().isEmpty() || !mailChecker.isEmailValid(newClient.getEmail())) {
					errorMessage = messageSource.getMessage("mailError", null, locale);
				} else {
					if (newClient.getPassword().length() < 8 || newClient.getPassword().length() > 65) {
						errorMessage = messageSource.getMessage("passwordRegisterError", null, locale);
					} else {
						if (newClient.getConfirmPassword().length() < 8
								|| newClient.getConfirmPassword().length() > 65) {
							errorMessage = messageSource.getMessage("passwordConfirmError", null, locale);
						} else {
							if (!newClient.getConfirmPassword().equals(newClient.getPassword())) {
								errorMessage = messageSource.getMessage("passwordMatchError", null, locale);
							} else {
								if (newClient.getTelephoneNumber().isEmpty()
										|| newClient.getTelephoneNumber().length() > 25) {
									errorMessage = messageSource.getMessage("telephoneError", null, locale);
								} else {
									if (!newClient.getMobileNumber().isEmpty()
											&& newClient.getMobileNumber().length() > 36) {
										errorMessage = messageSource.getMessage("mobileError", null, locale);
									} else {
										if (newClient.getStreetName().isEmpty()
												|| newClient.getStreetName().length() > 25) {
											errorMessage = messageSource.getMessage("streetNameError", null, locale);
										} else {
											if (newClient.getStreetNumber().isEmpty()
													|| newClient.getStreetNumber().length() > 8) {
												errorMessage = messageSource.getMessage("streetNumError", null, locale);
											} else {
												if (newClient.getZipcode().isEmpty()
														|| newClient.getZipcode().length() > 8) {
													errorMessage = messageSource.getMessage("zipCodeError", null,
															locale);
												} else {
													if (newClient.getCity().isEmpty()
															|| newClient.getCity().length() > 50) {
														errorMessage = messageSource.getMessage("cityError", null,
																locale);
													} else {
														if (newClient.getCountry().isEmpty()
																|| newClient.getCountry().length() > 50) {
															errorMessage = messageSource.getMessage("countryError",
																	null, locale);
														} else {
															Client alreadyClient = clientDAO
																	.findByEmail(newClient.getEmail());
															if (alreadyClient != null) {
																errorMessage = messageSource.getMessage("alreadyClient",
																		null, locale);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		if (errorMessage.isEmpty()) {
			Country country = countryDAO.findByName(newClient.getCountry());
			Client registerClient = new Client(newClient.getFirstName(), newClient.getLastName(), newClient.getEmail(),
					sha256.encodePassword(newClient.getPassword()), newClient.getTelephoneNumber(),
					newClient.getMobileNumber(), newClient.getStreetName(), newClient.getStreetNumber(),
					newClient.getZipcode(), newClient.getCity(), country);

			Client savedClient = clientDAO.save(registerClient);

			client.setIdClient(savedClient.getIdClient());
			client.setFirstName(savedClient.getFirstName());
			client.setLastName(savedClient.getLastName());
			client.setCountry(savedClient.getCountry().getCountryName());
			client.setEmail(savedClient.getEmail());

			model.addAttribute(Constant.CLIENT, client);
			model.addAttribute("titlePage", messageSource.getMessage("loginTitlePage", null, locale));
			model.addAttribute(Constant.CATEGORIES, categories);
			return "integrated:welcome";
		} else {

			model.addAttribute(Constant.CLIENT, client);
			model.addAttribute("titlePage", messageSource.getMessage("loginTitlePage", null, locale));
			model.addAttribute(Constant.CATEGORIES, categories);
			model.addAttribute(Constant.COUNTRIES, countries);
			model.addAttribute(Constant.NEWCLIENT, newClient);
			model.addAttribute(Constant.ERRORMESSAGE, errorMessage);
			return "integrated:register";
		}
	}

}
