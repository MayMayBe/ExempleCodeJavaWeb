package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.EquivalentCategoryDAO;
import com.spring.henallux.dataAccess.dao.ModelDAO;
import com.spring.henallux.dataAccess.dao.PromotionDAO;
import com.spring.henallux.model.Client;
import com.spring.henallux.model.EquivalentCategory;
import com.spring.henallux.model.OrderShop;
import com.spring.henallux.model.OrderShopLine;
import com.spring.henallux.model.Promotion;
import com.spring.henallux.sessionAttributeModel.Categories;
import com.spring.henallux.sessionAttributeModel.ClientBasket;
import com.spring.henallux.sessionAttributeModel.ConnectedClient;
import com.spring.henallux.sessionAttributeModel.ProcessCommand;
import com.spring.henallux.util.*;

@Controller
@RequestMapping(value = "/basket")
@SessionAttributes({ Constant.ORDERSHOP, Constant.CONNECTEDCLIENT, Constant.CLIENTBASKET, 
	Constant.PROCESSCOMMAND, Constant.CLIENT, Constant.CATEGORIES})
public class BasketController {

	@Autowired
	private MessageSource titleMessage;

	@Autowired
	private ModelDAO modelDAO;
	
	@Autowired
	private PromotionDAO promotionDAO;
	
	@Autowired
	private EquivalentCategoryDAO equivalentCategoryDAO;
	
	@Autowired
	private MessageSource messageSource;
	
	
	public ArrayList<EquivalentCategory> setCategory(Locale locale){
		ArrayList<EquivalentCategory> listCategory = equivalentCategoryDAO.getCategoriesByLanguage(locale.getLanguage());
		return listCategory;
	}
	
	@RequestMapping(value="/deleteInstrument/{idModel}", method= RequestMethod.GET)
	public String deleteInstrument(Model model, @ModelAttribute(value = Constant.ORDERSHOP) OrderShop orderShop,
			@PathVariable("idModel") Integer idModel,
			@ModelAttribute(value=Constant.CONNECTEDCLIENT) ConnectedClient connectedClient, 
			@ModelAttribute(value=Constant.CLIENTBASKET) ClientBasket clientBasket, Locale locale,
			@ModelAttribute(value = Constant.CLIENT) Client client,
			@ModelAttribute(value=Constant.CATEGORIES)Categories categories) {
		model.addAttribute("orderShop", orderShop);
		model.addAttribute("titlePage", titleMessage.getMessage("basketTitlePage", null, locale));
		com.spring.henallux.model.Model modelChoosed = modelDAO.findOne(idModel);
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute("quantityError", messageSource.getMessage("errorQuantity", null, locale));
		Boolean lineAlreadyExists = false;
		
		lineAlreadyExists = clientBasket.getOrderShopLines().containsKey(modelChoosed.getNameModel());
		
		if(lineAlreadyExists){
			clientBasket.getOrderShopLines().remove(modelChoosed.getNameModel());
		}
		
		model.addAttribute(Constant.CLIENTBASKET, clientBasket);
		categories.setCategories(setCategory(locale));
		model.addAttribute("categories", categories);
		
		return "integrated:basket";
	}
	
	@RequestMapping(value = "/yourBasket",method = RequestMethod.GET)
	public String getBasket(Model model, @ModelAttribute(value = Constant.ORDERSHOP) OrderShop orderShop,
			@ModelAttribute(value=Constant.CONNECTEDCLIENT) ConnectedClient connectedClient,
			@ModelAttribute(value=Constant.CLIENTBASKET) ClientBasket clientBasket, Locale locale,
			@ModelAttribute(value = Constant.CLIENT)Client client,
			@ModelAttribute(value=Constant.CATEGORIES)Categories categories) {
		model.addAttribute("orderShop", orderShop);
		model.addAttribute(Constant.CLIENTBASKET, clientBasket);
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute("titlePage", titleMessage.getMessage("basketTitlePage", null, locale));
		model.addAttribute("quantityError", messageSource.getMessage("errorQuantity", null, locale));
		categories.setCategories(setCategory(locale));
		model.addAttribute("categories", categories);
		return "integrated:basket";
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public String updateBasket(Model model, @ModelAttribute(value = Constant.ORDERSHOP) OrderShop orderShop, @ModelAttribute(value=Constant.CONNECTEDCLIENT) ConnectedClient connectedClient, 
			@ModelAttribute(value=Constant.CLIENTBASKET) ClientBasket clientBasket, Locale locale,
			@ModelAttribute(value=Constant.CLIENT)Client client,
			@ModelAttribute(value=Constant.CATEGORIES)Categories categories) {
		
		model.addAttribute(Constant.ORDERSHOP, orderShop);
		model.addAttribute(Constant.CLIENTBASKET, clientBasket);
		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute("quantityError", messageSource.getMessage("errorQuantity", null, locale));
		model.addAttribute("titlePage", titleMessage.getMessage("basketTitlePage", null, locale));
		categories.setCategories(setCategory(locale));
		model.addAttribute("categories", categories);
		
		return "redirect:/basket/yourBasket";
	}

	@RequestMapping(value = "/newInstrument/{idModel}", method = RequestMethod.GET)
	public String setNewInstrument(Model model, @ModelAttribute(value = Constant.ORDERSHOP) OrderShop orderShop,
			@PathVariable("idModel") Integer idModel,
			@ModelAttribute(value=Constant.CONNECTEDCLIENT) ConnectedClient connectedClient, 
			@ModelAttribute(value=Constant.CLIENTBASKET) ClientBasket clientBasket, Locale locale,
			@ModelAttribute(value=Constant.PROCESSCOMMAND) ProcessCommand processCommand,
			@ModelAttribute(value=Constant.CLIENT)Client client,
			@ModelAttribute(value=Constant.CATEGORIES)Categories categories) {

		model.addAttribute(Constant.CLIENT, client);
		model.addAttribute("quantityError", messageSource.getMessage("errorQuantity", null, locale));
		categories.setCategories(setCategory(locale));
		model.addAttribute("categories", categories);
		
		if(!processCommand.getInPayment()){
			processCommand.setInPayment(true);
		}
		
			
			com.spring.henallux.model.Model modelChoosed = modelDAO.findOne(idModel);
			boolean modelAlreadySet = false;
			OrderShopLine orderShopLine = new OrderShopLine();
			
			if(!clientBasket.getOrderShopLines().isEmpty()){
				Boolean lineAlreadyExists = false;
				
				lineAlreadyExists = clientBasket.getOrderShopLines().containsKey(modelChoosed.getNameModel());
				
				if(lineAlreadyExists){
					
					modelAlreadySet = true;
				}
				
			
			}
			
			if(modelAlreadySet ){
			if(clientBasket.getOrderShopLines().get(modelChoosed.getNameModel()).getQuantity() < 10){	
				OrderShopLine updateLine = clientBasket.getOrderShopLines().get(modelChoosed.getNameModel());
				updateLine.addQuantity(1);
				clientBasket.getOrderShopLines().remove(modelChoosed.getNameModel());
				clientBasket.setNewOrderLineShopInCollection(modelChoosed.getNameModel(), updateLine);
			}
			}else{
				if (clientBasket.getOrderShopLines().isEmpty()) {
					orderShopLine.setNumberLine(1);
				} else {
					orderShopLine.setNumberLine(clientBasket.getOrderShopLines().size() + 1);
				}
	
				
				ArrayList<Promotion> promotions = (ArrayList<Promotion>) promotionDAO.findPromotionByIdBrandAndDateOfDay(modelChoosed.getBrand().getIdBrand());
				
				orderShopLine.setModel(modelChoosed);
	
				orderShopLine.setOrderShop(orderShop);
				orderShopLine.setQuantity(1);
				orderShopLine.setRealPrice(modelChoosed.getPrice());
				if(promotions.isEmpty()){
					orderShopLine.setPercentageDiscount(0.0);
				}else{
					orderShopLine.setPercentageDiscount(promotions.get(0).getPercentageReduction());
				}
				clientBasket.setNewOrderLineShopInCollection(modelChoosed.getNameModel(), orderShopLine);

			}
			model.addAttribute(Constant.ORDERSHOP, orderShop);
			model.addAttribute(Constant.CLIENTBASKET, clientBasket);
			
			model.addAttribute("titlePage", titleMessage.getMessage("basketTitlePage", null, locale));
			return "integrated:basket";

		
	}
}