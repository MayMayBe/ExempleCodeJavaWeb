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
import com.spring.henallux.model.NewClient;
import com.spring.henallux.model.OrderShop;
import com.spring.henallux.service.CountryService;
import com.spring.henallux.sessionAttributeModel.Categories;
import com.spring.henallux.sessionAttributeModel.ConnectedClient;
import com.spring.henallux.sessionAttributeModel.Countries;
import com.spring.henallux.sessionAttributeModel.InscriptionErrorMessage;
import com.spring.henallux.sessionAttributeModel.LoginErrorMessage;
import com.spring.henallux.util.*;

@Controller
@RequestMapping(value="/loginRegister")

@SessionAttributes({Constant.CLIENT , 
					LoginRegisterController.NEWCLIENT,
					Constant.CONNECTEDCLIENT,
					Constant.ERRORMESSAGE,
					Constant.ORDERSHOP,
					Constant.COUNTRIES,
					Constant.LOGINERROR,
					Constant.CATEGORIES})
public class LoginRegisterController {
	
	protected static final String NEWCLIENT = "newClient";
	
	@ModelAttribute(NEWCLIENT)
	public NewClient newClient(){
		return new NewClient();
	}
	
	@ModelAttribute(Constant.LOGINERROR)
	public LoginErrorMessage loginErrorMessage(){
		return new LoginErrorMessage();
	}
	
	@ModelAttribute(Constant.COUNTRIES)
	public Countries countries(){
		return new Countries();
	}
	
	@ModelAttribute(Constant.ERRORMESSAGE)
	public InscriptionErrorMessage errorMessage(){
		return new InscriptionErrorMessage();
	}
	
	@ModelAttribute(Constant.CONNECTEDCLIENT)
	public ConnectedClient currentConnectedClient(){
		return new ConnectedClient();
	}
	
	@ModelAttribute(Constant.ORDERSHOP)
	public OrderShop currentOrderShop(){
		return new OrderShop();
	}
	
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
	
	public ArrayList<EquivalentCategory> setCategory(Locale locale){
		ArrayList<EquivalentCategory> listCategory = equivalentCategoryDAO.getCategoriesByLanguage(locale.getLanguage());
		return listCategory;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale, @ModelAttribute(value=Constant.CONNECTEDCLIENT) ConnectedClient connectedClient,
					   @ModelAttribute(value=Constant.COUNTRIES) Countries countries,
					   @ModelAttribute(value=Constant.CLIENT)Client client,
					   @ModelAttribute(value=Constant.CATEGORIES)Categories categories){
		
		
		//Client déjà connecté => direct à la page account
		if(connectedClient.isConnected()) return "redirect:/account";
		
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute("titlePage", messageSource.getMessage("loginTitlePage", null, locale));
		countries.setCountryList(countryService.getCountries());
		categories.setCategories(setCategory(locale));
		model.addAttribute("categories", categories);

		return "integrated:loginRegister";
		
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String getLoginData(Model model,Locale locale,
			@ModelAttribute(value=Constant.CLIENT) Client client,
			@ModelAttribute(value=Constant.ORDERSHOP) OrderShop orderShop,
			@ModelAttribute(value=Constant.CONNECTEDCLIENT) ConnectedClient connectedClient,
			@ModelAttribute(value=Constant.LOGINERROR) LoginErrorMessage loginErrorMessage,
			@ModelAttribute(value=Constant.ERRORMESSAGE) InscriptionErrorMessage inscriptionErrorMessage,
			@ModelAttribute(value=Constant.CATEGORIES)Categories categories){
		
		categories.setCategories(setCategory(locale));
		model.addAttribute("categories", categories);

		if(connectedClient.isConnected()) return "redirect:/account";
		
		if(MailChecker.isEmailValid(client.getEmail()) && !client.getPassword().equals((""))){

			Client recordClient = null;
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
			}
		}
		return "redirect:/loginRegister";
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public String getFormData(Model model,
							@Valid @ModelAttribute(value=NEWCLIENT) NewClient newClient, 
							final BindingResult errors,
							@ModelAttribute(value=Constant.CLIENT) Client client, 
							Locale locale,
							@ModelAttribute(value=Constant.ERRORMESSAGE) InscriptionErrorMessage errorMessage,
							@ModelAttribute(value=Constant.CONNECTEDCLIENT) ConnectedClient connectedClientState,
							@ModelAttribute(value=Constant.CATEGORIES)Categories categories){
		
		categories.setCategories(setCategory(locale));
		model.addAttribute("categories", categories);
		
		if(errors.hasErrors()){
			errorMessage.setContent(messageSource.getMessage("errorInscription", null, locale));
			Set<String> listErrors = new HashSet<String>(); //Pour retirer les éléments dupliqués
			for(FieldError f : errors.getFieldErrors()){
				listErrors.add(f.getField());
			}
			
			for(String f : listErrors){
				errorMessage.appendContent("<br>" + messageSource.getMessage(f,null,locale));
				
			}
			
		}
		else
		{
			if(!newClient.getPassword().equals(newClient.getConfirmPassword())){
				errorMessage.setContent(messageSource.getMessage("passwordNotCorrespondingToConfirm", null, locale));
				
			}
			else
			{
				if(!NumberUtils.isNumber(newClient.getTelephoneNumber())){
					errorMessage.setContent(messageSource.getMessage("contactNumberOnlyNumbers", null, locale));
				}
				else
				{
					if(!newClient.getMobileNumber().equals("") && !NumberUtils.isNumber(newClient.getMobileNumber())){
						errorMessage.setContent(messageSource.getMessage("contactNumberOnlyNumbers", null, locale));
					}
					else
					{
						
						if((clientDAO.findByEmail(newClient.getEmail())) != null){
							errorMessage.setContent(messageSource.getMessage("alreadyClient", null, locale));
						}
						else
						{
							
							Country country = countryDAO.findByName(newClient.getCountry());

							String password = SHA256.encodePassword(newClient.getPassword());
							
							Client currentClient = new Client(newClient.getEmail(),
													password,newClient.getFirstName(),
													newClient.getLastName(),newClient.getTelephoneNumber(),
													newClient.getMobileNumber(),newClient.getStreetName(),
													newClient.getStreetNumber(), newClient.getZipcode(),
													newClient.getCity(),country);
							
							clientDAO.save(currentClient);
							client.setFirstName(currentClient.getFirstName());
							client.setLastName(currentClient.getLastName());
							client.setEmail(currentClient.getEmail());
							client.setTelephoneNumber(currentClient.getTelephoneNumber());
							client.setMobileNumber(currentClient.getMobileNumber());
							client.setStreetName(currentClient.getStreetName());
							client.setCity(currentClient.getCity());
							client.setStreetName(currentClient.getStreetName());
							client.setZipcode(currentClient.getZipcode());
							client.setStreetNumber(currentClient.getStreetNumber());
							
							//Initialiser l'attribut de session client
							Client clientAttribute = clientDAO.findByEmail(currentClient.getEmail());
							client.setIdClient(clientAttribute.getIdClient());
							
							
							
							
							//ConnectedClient
							connectedClientState.setConnected(true);
							model.addAttribute(Constant.CLIENT, client);
							errorMessage.setContent(null);
							return "redirect:/account";
						}
					}
				}
			}
		}

		
		return "redirect:/loginRegister"; //Si le retour n'est pas une redirection, l'URL reste /send et les liens ne sont plus fonctionnels
	}
	


}
