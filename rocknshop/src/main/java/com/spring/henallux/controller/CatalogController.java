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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.EquivalentCategoryDAO;
import com.spring.henallux.dataAccess.dao.ModelDAO;
import com.spring.henallux.dataAccess.dao.PromotionDAO;
import com.spring.henallux.model.EquivalentCategory;
import com.spring.henallux.model.Promotion;
import com.spring.henallux.sessionAttributeModel.Categories;
import com.spring.henallux.util.Constant;

@Controller
@RequestMapping(value="/catalog")
@SessionAttributes({Constant.CATEGORIES})
public class CatalogController {

	@Autowired
	private MessageSource titleMessage;
	
	@Autowired
	private ModelDAO modelDAO;
	
	@Autowired
	private PromotionDAO promotionDAO;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private EquivalentCategoryDAO equivalentCategoryDAO;
	
	
	private static final String ALLCATALOG = "allCatalog";
	private static final String MESSAGECATALOG = "textContentCatalog";
	private static final String TITLEPAGE = "titlePage";
	private static final String PROMOTIONLIST = "promotionList";
	private static final String HASEXECUTEDSEARCH = "hasExecutedSearch";
	private List<com.spring.henallux.model.Model> lastResearch;
	
	
	@RequestMapping(value="/{categorySelected}",method=RequestMethod.GET)
	public String getCatalogSelected(Model model, Locale locale, 
			@ModelAttribute(value=Constant.CATEGORIES)Categories categories,
			@PathVariable("categorySelected") Integer idCategory){
		List<com.spring.henallux.model.Model> models = new ArrayList<>();
		models = modelDAO.findModelsByCategory(idCategory);
		HashSet<Promotion> promoList = getPromotionsList(models);
		model.addAttribute(PROMOTIONLIST,promoList);
		
		model.addAttribute(ALLCATALOG, models);
		model.addAttribute(HASEXECUTEDSEARCH,false);
		
		ArrayList<EquivalentCategory> listCategory = equivalentCategoryDAO.getCategoriesByLanguage(locale.getLanguage());		
		categories.setCategories(listCategory);
		model.addAttribute("categories", categories);
		
		model.addAttribute("titlePage", titleMessage.getMessage("catalogTitlePage", null, locale));
		return "integrated:catalog";
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/promotions")
	public String promotions(Model model, Locale locale,
			@ModelAttribute(value=Constant.CATEGORIES)Categories categories){

		ArrayList<Promotion> allPromotions = promotionDAO.getAllPromotions();
		ArrayList<com.spring.henallux.model.Model> modelsWithPromotion = new ArrayList<>();
		Date today = new Date(System.currentTimeMillis());
		
		for(Promotion p : allPromotions){
			
			if(p.getDateBeginning().compareTo(today) < 0 && p.getDateEnd().compareTo(today) > 0){
				modelsWithPromotion.addAll(p.getBrand().getModels());
			}
		}
		
		HashSet<Promotion> promoList = getPromotionsList(modelsWithPromotion);

		
		model.addAttribute(PROMOTIONLIST,promoList);
		model.addAttribute(ALLCATALOG, modelsWithPromotion);
		ArrayList<EquivalentCategory> listCategory = equivalentCategoryDAO.getCategoriesByLanguage(locale.getLanguage());		
		categories.setCategories(listCategory);
		model.addAttribute(MESSAGECATALOG,messageSource.getMessage("promotionsText", null, locale));
		model.addAttribute(TITLEPAGE, titleMessage.getMessage("detailTitlePage", null, locale));
		model.addAttribute(HASEXECUTEDSEARCH,false);
		return "integrated:catalog";
	}
	
	private HashSet<Promotion> getPromotionsList(List<com.spring.henallux.model.Model> models) {
		Date today = new Date(System.currentTimeMillis());
		HashSet<Promotion> promoList = new HashSet<>();
		
		for(com.spring.henallux.model.Model m : models){

			for(Promotion p : m.getBrand().getPromotions()){
				
				if(p.getDateBeginning().compareTo(today) < 0 && p.getDateEnd().compareTo(today) > 0){
					promoList.add(p);
				}
			}
		}

		HashSet<Object> seen=new HashSet<>();
		promoList.removeIf(p->!seen.add(p.getBrand().getNameBrand()));	//Pour retirer les éléments dupliqués. seen.add renvoie false si l'opération a modifié le HashSet

		return promoList;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String searchPost(@RequestParam String keyword,@RequestParam String criteria,Model model, Locale locale,
			@ModelAttribute(value=Constant.CATEGORIES)Categories categories){

		ArrayList<com.spring.henallux.model.Model> result = modelDAO.searchModel(keyword,criteria);

		lastResearch = result;
		HashSet<Promotion> promoList = getPromotionsList(result);
		model.addAttribute(PROMOTIONLIST,promoList);	
		model.addAttribute(HASEXECUTEDSEARCH,true);
		model.addAttribute(ALLCATALOG, result);
		ArrayList<EquivalentCategory> listCategory = equivalentCategoryDAO.getCategoriesByLanguage(locale.getLanguage());		
		categories.setCategories(listCategory);
		return "integrated:catalog";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String searchGet(Model model, Locale locale, @ModelAttribute(value=Constant.CATEGORIES)Categories categories){
		
		if(lastResearch != null){
			HashSet<Promotion> promoList = getPromotionsList(lastResearch);
			model.addAttribute(PROMOTIONLIST,promoList);	
			model.addAttribute(HASEXECUTEDSEARCH,true);
			model.addAttribute(ALLCATALOG, lastResearch);
			ArrayList<EquivalentCategory> listCategory = equivalentCategoryDAO.getCategoriesByLanguage(locale.getLanguage());		
			categories.setCategories(listCategory);
		}
		
		return "integrated:catalog";
	}
	
}
