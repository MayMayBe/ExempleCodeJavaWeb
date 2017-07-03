package com.spring.henallux.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.ui.Model;
import com.spring.henallux.dataAccess.dao.EquivalentCategoryDAO;
import com.spring.henallux.dataAccess.dao.OrderShopDAO;
import com.spring.henallux.dataAccess.dao.OrderShopLineDAO;
import com.spring.henallux.model.Client;
import com.spring.henallux.model.EquivalentCategory;
import com.spring.henallux.model.OrderShop;
import com.spring.henallux.model.OrderShopLine;
import com.spring.henallux.sessionAttributeModel.Categories;
import com.spring.henallux.sessionAttributeModel.ClientBasket;
import com.spring.henallux.sessionAttributeModel.ConnectedClient;
import com.spring.henallux.sessionAttributeModel.ProcessCommand;
import com.spring.henallux.util.Constant;

@Controller
@RequestMapping(value = "/processCommand")
@SessionAttributes({ Constant.ORDERSHOP, Constant.CONNECTEDCLIENT, Constant.CLIENT, Constant.CLIENTBASKET,
		Constant.PROCESSCOMMAND, Constant.CATEGORIES })
public class ProcessCommandController {

	@Autowired
	private MessageSource titleMessage;

	@Autowired
	private OrderShopDAO orderShopDAO;

	@Autowired
	private OrderShopLineDAO orderShopLineDAO;

	@Autowired
	private EquivalentCategoryDAO equivalentCategoryDAO;

	@ModelAttribute(Constant.ORDERSHOP)
	public OrderShop currentOrderShop() {
		return new OrderShop();
	}

	public ArrayList<EquivalentCategory> setCategory(Locale locale) {
		ArrayList<EquivalentCategory> listCategory = equivalentCategoryDAO
				.getCategoriesByLanguage(locale.getLanguage());
		return listCategory;
	}

	@RequestMapping(value = "payment", method = RequestMethod.GET)
	public String getPayment(Model model, Locale locale,
			@ModelAttribute(value = Constant.ORDERSHOP) OrderShop orderShop,
			@ModelAttribute(value = Constant.CONNECTEDCLIENT) ConnectedClient connectedClient,
			@ModelAttribute(value = Constant.CLIENTBASKET) ClientBasket clientBasket,
			@ModelAttribute(value = Constant.PROCESSCOMMAND) ProcessCommand processCommand,
			@ModelAttribute(value = Constant.CLIENT) Client client,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories) {

		model.addAttribute("titlePage", titleMessage.getMessage("basketTitlePage", null, locale));
		model.addAttribute(Constant.CLIENTBASKET, clientBasket);
		model.addAttribute(Constant.CONNECTEDCLIENT, connectedClient);
		model.addAttribute(Constant.ORDERSHOP, orderShop);
		model.addAttribute(Constant.PROCESSCOMMAND, processCommand);
		model.addAttribute(Constant.CLIENT, client);
		categories.setCategories(setCategory(locale));
		model.addAttribute("categories", categories);

		if (connectedClient.isConnected()) {
			return "integrated:processCommand";
		} else {
			return "integrated:errorBasket";
		}
	}

	@RequestMapping(value = "/pickPayment", method = RequestMethod.POST)
	public String updateBasket(Model model, @Valid @ModelAttribute(value = Constant.ORDERSHOP) OrderShop orderShop,
			@ModelAttribute(value = Constant.CONNECTEDCLIENT) ConnectedClient connectedClient, Locale locale,
			@ModelAttribute(value = Constant.CLIENTBASKET) ClientBasket clientBasket,
			@ModelAttribute(value = Constant.PROCESSCOMMAND) ProcessCommand processCommand,
			@ModelAttribute(value = Constant.CLIENT) Client client,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories) {

		model.addAttribute(Constant.CLIENTBASKET, clientBasket);
		model.addAttribute(Constant.CONNECTEDCLIENT, connectedClient);
		model.addAttribute(Constant.ORDERSHOP, orderShop);
		model.addAttribute(Constant.PROCESSCOMMAND, processCommand);
		model.addAttribute(Constant.CLIENT, client);
		categories.setCategories(setCategory(locale));
		model.addAttribute("categories", categories);

		if (connectedClient.isConnected()) {

			orderShop.setClient(client);
			LocalDate today = LocalDate.now();
			orderShop.setDateOrderShop(Date.valueOf(today));
			orderShop.setOrderShopSent(false);
			orderShop.setPaymentDone(false);

			OrderShop orderShopSaved = orderShopDAO.save(orderShop);

			orderShop.setNumberOrderShop(orderShopSaved.getNumberOrderShop());

			Iterator<Entry<String, OrderShopLine>> iterator = clientBasket.getOrderShopLines().entrySet().iterator();

			while (iterator.hasNext()) {
				Map.Entry<String, OrderShopLine> entry = iterator.next();
				OrderShopLine updateLine = (OrderShopLine) entry.getValue();
				updateLine.setOrderShop(orderShop);
				entry.setValue(updateLine);
				orderShopLineDAO.save(updateLine);
			}

			processCommand.setInPayment(false);

			return "redirect:/processCommand/yourOrder";

		} else {
			return "integrated:errorBasket";
		}
	}

	@RequestMapping(value = "/yourOrder", method = RequestMethod.GET)
	public String getOrderReview(Model model, Locale locale,
			@ModelAttribute(value = Constant.ORDERSHOP) OrderShop orderShop,
			@ModelAttribute(value = Constant.CONNECTEDCLIENT) ConnectedClient connectedClient,
			@ModelAttribute(value = Constant.CLIENTBASKET) ClientBasket clientBasket,
			@ModelAttribute(value = Constant.PROCESSCOMMAND) ProcessCommand processCommand,
			@ModelAttribute(value = Constant.CLIENT) Client client,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories) {

		model.addAttribute(Constant.CONNECTEDCLIENT, connectedClient);
		model.addAttribute(Constant.PROCESSCOMMAND, processCommand);
		model.addAttribute(Constant.CLIENT, client);
		categories.setCategories(setCategory(locale));
		model.addAttribute("categories", categories);

		model.addAttribute("titlePage", titleMessage.getMessage("basketTitlePage", null, locale));

		clientBasket.clearClientBasket();
		model.addAttribute(Constant.CLIENTBASKET, clientBasket);
		model.addAttribute(Constant.ORDERSHOP, currentOrderShop());

		return "integrated:processCommand";

	}

}
