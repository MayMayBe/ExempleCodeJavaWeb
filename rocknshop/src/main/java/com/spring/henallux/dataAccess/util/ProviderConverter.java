package com.spring.henallux.dataAccess.util;



import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Component;

import com.spring.henallux.dataAccess.entity.*;
import com.spring.henallux.model.*;

@Component
public class ProviderConverter {
	
	Mapper mapper = new DozerBeanMapper();
	
	public OrderShopLineEntity orderShopLineModelToOrderShopLineEntity(OrderShopLine orderShopLine){
		OrderShopLineEntity orderShopLineEntity = mapper.map(orderShopLine, OrderShopLineEntity.class);
		return orderShopLineEntity;
	}
	
	public OrderShopLine orderShopLineEntityToOrderShopLineModel(OrderShopLineEntity orderShopLineEntity){
		OrderShopLine orderShopLine = mapper.map(orderShopLineEntity, OrderShopLine.class);
		return orderShopLine;
	}
	
	public OrderShopEntity orderShopModelToOrderShopEntity(OrderShop orderShop){
		OrderShopEntity orderShopEntity = mapper.map(orderShop, OrderShopEntity.class);
		return orderShopEntity;
	}
	
	public OrderShop orderShopEntityToOrderShopModel(OrderShopEntity orderShopEntity){
		OrderShop orderShop = mapper.map(orderShopEntity, OrderShop.class);
		return orderShop;
	}
	
	
	public Client clientEntitytoClientModel(ClientEntity clientEntity) {
		Client client = mapper.map(clientEntity, Client.class);
		return client;
	}

	public ModelEntity modelModeltoModelEntity(Model model) {
		ModelEntity modelEntity = mapper.map(model, ModelEntity.class);
		return modelEntity;
	}

	public Model modelEntityToModelModel(ModelEntity modelEntity) {
		Model model = mapper.map(modelEntity, Model.class);
		return model;
	}
	
	public CountryEntity countryModeltoCountryEntity(Country country) {
		CountryEntity countryEntity = mapper.map(country, CountryEntity.class);
		return countryEntity;
	}

	public Country countryEntityToCountryModel(CountryEntity countryEntity) {
		Country country = mapper.map(countryEntity, Country.class);
		return country;
	}

	public Brand brandEntityToBrandModel(BrandEntity brandEntity) {
		Brand brand = mapper.map(brandEntity, Brand.class);
		return brand;
	}	

	public BrandEntity brandModelToBrandEntity(Brand brand) {
		BrandEntity brandEntity = mapper.map(brand, BrandEntity.class);
		return brandEntity;
	}
	
	public ClientEntity clientModelToClientEntity(Client client){
		ClientEntity clientEntity = mapper.map(client, ClientEntity.class);
		return clientEntity;
	}
	
	public Client clientEntityToClientModel(ClientEntity clientEntity){
		Client client = mapper.map(clientEntity, Client.class);
		return client;
	}
	

	public CategoryEntity categoryModelToCategoryEntity(Category category) {
		CategoryEntity c = mapper.map(category, CategoryEntity.class);		
		return c;
	}
	
	public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
		Category c = mapper.map(categoryEntity, Category.class);
		return c;
	}

	public EquivalentCategoryEntity equivalentCategoryModelToEquivalentCategoryEntity(EquivalentCategory equivalentCategory){
		EquivalentCategoryEntity c = mapper.map(equivalentCategory, EquivalentCategoryEntity.class);
		return c;
	}
	
	public EquivalentCategory equivalentCategoryEntityToEquivalentCategoryModel(EquivalentCategoryEntity equivalentCategoryEntity){
		EquivalentCategory c = mapper.map(equivalentCategoryEntity, EquivalentCategory.class);
		return c;
	}
	
	public Characteristic characteristicEntityToCharacteristicModel(CharacteristicEntity cE){
		Characteristic c = mapper.map(cE, Characteristic.class);
		return c;
	}
	
	public CharacteristicEntity characteristicModelToCharacteristicEntity(Characteristic c){
		CharacteristicEntity cE = mapper.map(c, CharacteristicEntity.class);
		return cE;
	}

	public EquivalentCharacteristic equivalentCharacteristicEntityToEquivalentCharacteristicModel(EquivalentCharacteristicEntity eC){
		EquivalentCharacteristic e = mapper.map(eC, EquivalentCharacteristic.class);
		return e;
	}
	
	public EquivalentCharacteristicEntity equivalentCharacteristicModelToEquivalentCharacteristicEntity(EquivalentCharacteristic eC){
		EquivalentCharacteristicEntity e = mapper.map(eC, EquivalentCharacteristicEntity.class);
		return e;
	}
	
	public Description descriptionEntityToDescriptionModel(DescriptionEntity dE){
		Description d = mapper.map(dE, Description.class);
		return d;
	}
	
	public DescriptionEntity descriptionModelToDescriptionEntity(Description d){
		DescriptionEntity dE = mapper.map(d, DescriptionEntity.class);
		return dE;
	}
	
	public EquivalentDescription equivalentDescriptionEntityToEquivalentDescriptionModel(EquivalentDescriptionEntity eD){
		EquivalentDescription e = mapper.map(eD, EquivalentDescription.class);
		return e;
	}
	
	public EquivalentDescriptionEntity equivalentDescriptionModelToEquivalentDescriptionEntity(EquivalentDescription eD){
		EquivalentDescriptionEntity e = mapper.map(eD, EquivalentDescriptionEntity.class);
		return e;
	}
	
	public LanguageEntity equivalentLanguageModelToLanguageEntity(Language l){
		LanguageEntity e = mapper.map(l, LanguageEntity.class);
		return e;
	}
	
	public Language equivalentLanguageEntityToLanguageModel(LanguageEntity l){
		Language e = mapper.map(l, Language.class);
		return e;
	}
	
	public Promotion promotionEntityToPromotionModel(PromotionEntity p){
		Promotion e = mapper.map(p, Promotion.class);
		return e;
	}
	
	public PromotionEntity promotionModelToPromotionEntity(Promotion p){
		PromotionEntity e = mapper.map(p, PromotionEntity.class);
		return e;
	}

}
