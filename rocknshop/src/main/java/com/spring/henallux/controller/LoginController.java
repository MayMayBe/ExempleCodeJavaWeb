package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.validation.Valid;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
import com.spring.henallux.model.OrderShop;
import com.spring.henallux.service.CategoriesService;
import com.spring.henallux.service.CountryService;
import com.spring.henallux.sessionAttributeModel.Categories;
import com.spring.henallux.sessionAttributeModel.ClientAndBasket;
import com.spring.henallux.sessionAttributeModel.ClientLogin;
import com.spring.henallux.sessionAttributeModel.ConnectedClient;
import com.spring.henallux.sessionAttributeModel.Countries;
import com.spring.henallux.sessionAttributeModel.InscriptionErrorMessage;
import com.spring.henallux.sessionAttributeModel.LoginErrorMessage;
import com.spring.henallux.sessionAttributeModel.NewClient;
import com.spring.henallux.util.*;

@Controller
@RequestMapping(value="/login")

@SessionAttributes({Constant.CLIENT})
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
	

	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale,
					   @ModelAttribute(value=Constant.CLIENT)ClientAndBasket client,
					   @ModelAttribute(value=Constant.CATEGORIES)Categories categories,
					   @ModelAttribute(value=Constant.CLIENTLOGIN) ClientLogin clientLogin,
					   @ModelAttribute(value=Constant.ERRORMESSAGE)String errorMessage){
		
		//Client déjà connecté => direct à la page account
		if(client.getIdClient() != 0) return "redirect:/account";
		
		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));
		errorMessage= "";
		
		model.addAttribute(Constant.ERRORMESSAGE, errorMessage);
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute("titlePage", messageSource.getMessage("loginTitlePage", null, locale));
		model.addAttribute(Constant.CATEGORIES, categories);
		model.addAttribute(Constant.CLIENTLOGIN, clientLogin);
		return "integrated:login";
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String getLoginData(Model model,Locale locale,
			@ModelAttribute(value=Constant.CLIENT)ClientAndBasket client,
			   @ModelAttribute(value=Constant.CATEGORIES)Categories categories,
			   @ModelAttribute(value=Constant.CLIENTLOGIN) ClientLogin clientLogin,
			   @ModelAttribute(value=Constant.ERRORMESSAGE)String errorMessage){
		

		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));
		
		model.addAttribute(Constant.CATEGORIES, categories);
		errorMessage = "";

		if(client.getIdClient() != 0) return "redirect:/account";
		
		if(clientLogin.getEmail().isEmpty() || !mailChecker.isEmailValid(clientLogin.getEmail())){
			errorMessage = messageSource.getMessage("mailError", null, locale);
		}else{
			if(clientLogin.getPassword().isEmpty()){
				errorMessage = messageSource.getMessage("emptyPassword", null, locale);
			}else{
			
			Client clientSystem = clientDAO.findByEmail(clientLogin.getEmail());
			
			if(clientSystem == null || !sha256.correctPassword(clientSystem.getPassword(), clientLogin.getPassword())){
				errorMessage = messageSource.getMessage("loginIncorrect", null, locale);
			}else{
				client.setIdClient(clientSystem.getIdClient());
				client.setFirstName(clientSystem.getFirstName());
				client.setLastName(clientSystem.getLastName());
			}
			}
		}
		
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute("titlePage", messageSource.getMessage("loginTitlePage", null, locale));
		model.addAttribute(Constant.CATEGORIES, categories);
		
		
		if(errorMessage.isEmpty()){
			return "integrated:welcome";
		}else{
			
			model.addAttribute(Constant.ERRORMESSAGE, errorMessage);
			model.addAttribute(Constant.CLIENTLOGIN, clientLogin);
			return "integrated:login";
		}

		
			/*Client recordClient = null;
			recordClient = clientDAO.findByEmail(client.getEmail());
			if(recordClient != null && SHA256.correctPassword(recordClient, client)){
				
				client.setIdClient(recordClient.getIdClient());
				client.setFirstName(recordClient.getFirstName());
				client.setLastName(recordClient.getLastName());
				client.setEmail(recordClient.getEmail());
				client.setTelephoneNumber(recordClient.getTelephoneNumber());
				client.setMobileNumber(recordClient.getMobileNumber());
				client.setStreetName(recordClient.getStreetName());
				client.setCity(recordClient.getCity());
				client.setStreetName(recordClient.getStreetName());
				client.setZipcode(recordClient.getZipcode());
				client.setStreetNumber(recordClient.getStreetNumber());
				client.setCountry(recordClient.getCountry());
				loginErrorMessage.setContent("");
				inscriptionErrorMessage.setContent("");
				
				//ConnectedClient
				connectedClient.setConnected(true);
				//Ajout gestion panier client
				orderShop.setClient(client);
				Date today = Calendar.getInstance().getTime();
				orderShop.setDateOrderShop(today);
				orderShop.setOrderShopSent(false);

				model.addAttribute(Constant.CLIENT, client);
			
				return "redirect:/account";
			}
			else
			{
				
				loginErrorMessage.setContent(messageSource.getMessage("loginIncorrect", null, locale));
			}*/
		
			
	}
	

}
