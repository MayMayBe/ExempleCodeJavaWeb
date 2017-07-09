package com.spring.henallux.controller;

import java.sql.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.dataAccess.dao.BrandDAO;
import com.spring.henallux.dataAccess.dao.EquivalentDescriptionDAO;
import com.spring.henallux.dataAccess.dao.ModelDAO;
import com.spring.henallux.model.Promotion;
import com.spring.henallux.modelAttribute.Categories;
import com.spring.henallux.service.CategoriesService;
import com.spring.henallux.util.Constant;

@Controller
@RequestMapping(value = "/details")
public class DetailsController {

	@Autowired
	private MessageSource titleMessage;

	@Autowired
	private MessageSource fretlessMessage;

	@Autowired
	private ModelDAO modelDAO;

	@Autowired
	private BrandDAO brandDAO;

	@Autowired
	private EquivalentDescriptionDAO equivalentDescriptionDAO;

	@Autowired
	private CategoriesService categoriesService;

	@RequestMapping(value = "/{idModel}", method = RequestMethod.GET)
	public String getResponse(@PathVariable("idModel") Integer idModel, Model model, Locale locale,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories) {

		com.spring.henallux.model.Model modelChoosed = modelDAO.findOne(idModel);

		if (modelChoosed.getFretless()) {
			model.addAttribute("fretlessModel", fretlessMessage.getMessage("yes", null, locale));
		} else {
			model.addAttribute("fretlessModel", fretlessMessage.getMessage("no", null, locale));
		}

		Date today = new Date(System.currentTimeMillis());

		for (Promotion p : modelChoosed.getBrand().getPromotions()) {
			if (p.getDateBeginning().compareTo(today) < 0 && p.getDateEnd().compareTo(today) > 0) {
				model.addAttribute("promotedPrice", modelChoosed.getPrice() * (1 - p.getPercentageReduction()));
			}
		}

		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));

		model.addAttribute("model", modelChoosed);
		model.addAttribute("categories", categories);
		model.addAttribute("numStrings", modelChoosed.getNbStrings());
		model.addAttribute("brand", brandDAO.findOne(modelChoosed.getBrand().getIdBrand()));
		model.addAttribute("description", equivalentDescriptionDAO
				.findDescriptionByModelAndLanguage(modelChoosed.getIdModel(), locale.getLanguage()));
		model.addAttribute("titlePage", titleMessage.getMessage("detailTitlePage", null, locale));
		return "integrated:details";
	}

}
