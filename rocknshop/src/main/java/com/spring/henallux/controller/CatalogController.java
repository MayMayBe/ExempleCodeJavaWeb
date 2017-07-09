package com.spring.henallux.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.dataAccess.dao.EquivalentCategoryDAO;
import com.spring.henallux.dataAccess.dao.ModelDAO;
import com.spring.henallux.dataAccess.dao.PromotionDAO;
import com.spring.henallux.model.EquivalentCategory;
import com.spring.henallux.model.Promotion;
import com.spring.henallux.modelAttribute.Categories;
import com.spring.henallux.service.CategoriesService;
import com.spring.henallux.service.ModelService;
import com.spring.henallux.util.Constant;

@Controller
@RequestMapping(value = "/catalog")
public class CatalogController {

	@Autowired
	private MessageSource titleMessage;

	@Autowired
	private CategoriesService categoriesService;

	@Autowired
	private ModelService modelService;

	@Autowired
	private ModelDAO modelDAO;

	@Autowired
	private PromotionDAO promotionDAO;

	@Autowired
	private EquivalentCategoryDAO equivalentCategoryDAO;

	@RequestMapping(value = "/{categorySelected}", method = RequestMethod.GET)
	public String getCatalogSelected(Model model, Locale locale,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories,
			@PathVariable(Constant.CATEGORYSELECTED) Integer idCategory) {

		categories.setCategories(categoriesService.getCategoriesByLanguage(locale.getLanguage()));
		List<com.spring.henallux.model.Model> models = modelDAO.findModelsByCategory(idCategory);
		HashSet<Promotion> promoList = getPromotionsList(models);

		model.addAttribute(Constant.PROMOTIONLIST, promoList);
		model.addAttribute(Constant.ALLCATALOG, modelService.getModelsByCategory(idCategory));
		model.addAttribute(Constant.CATEGORIES, categories);
		model.addAttribute("titlePage", titleMessage.getMessage("catalogTitlePage", null, locale));
		return "integrated:catalog";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/promotions")
	public String promotions(Model model, Locale locale,
			@ModelAttribute(value = Constant.CATEGORIES) Categories categories) {

		ArrayList<Promotion> allPromotions = promotionDAO.getAllPromotions();
		ArrayList<com.spring.henallux.model.Model> modelsWithPromotion = new ArrayList<>();
		Date today = new Date(System.currentTimeMillis());

		for (Promotion p : allPromotions) {

			if (p.getDateBeginning().compareTo(today) < 0 && p.getDateEnd().compareTo(today) > 0) {
				modelsWithPromotion.addAll(p.getBrand().getModels());
			}
		}

		HashSet<Promotion> promoList = getPromotionsList(modelsWithPromotion);

		model.addAttribute(Constant.PROMOTIONLIST, promoList);
		model.addAttribute(Constant.ALLCATALOG, modelsWithPromotion);
		ArrayList<EquivalentCategory> listCategory = equivalentCategoryDAO
				.getCategoriesByLanguage(locale.getLanguage());
		categories.setCategories(listCategory);
		model.addAttribute("titlePage", titleMessage.getMessage("detailTitlePage", null, locale));
		return "integrated:catalog";
	}

	private HashSet<Promotion> getPromotionsList(List<com.spring.henallux.model.Model> models) {
		Date today = new Date(System.currentTimeMillis());
		HashSet<Promotion> promoList = new HashSet<>();

		for (com.spring.henallux.model.Model m : models) {

			for (Promotion p : m.getBrand().getPromotions()) {

				if (p.getDateBeginning().compareTo(today) < 0 && p.getDateEnd().compareTo(today) > 0) {
					promoList.add(p);
				}
			}
		}

		HashSet<Object> seen = new HashSet<>();
		promoList.removeIf(p -> !seen.add(p.getBrand().getNameBrand())); 

		return promoList;
	}

}
