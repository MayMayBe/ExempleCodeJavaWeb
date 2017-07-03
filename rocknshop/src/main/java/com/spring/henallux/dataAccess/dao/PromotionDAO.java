package com.spring.henallux.dataAccess.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.PromotionEntity;
import com.spring.henallux.dataAccess.repository.PromotionRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;

import com.spring.henallux.model.Promotion;

@Service
@Transactional
public class PromotionDAO {

	@Autowired
	private PromotionRepository promotionRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Promotion save(Promotion promotion){
		
		PromotionEntity promotionEntity = providerConverter.promotionModelToPromotionEntity(promotion);
		
		promotionEntity = promotionRepository.save(promotionEntity);

		return providerConverter.promotionEntityToPromotionModel(promotionEntity);
	}
	
	public ArrayList<Promotion> getAllPromotions(){
		List<PromotionEntity> promotionEntities = promotionRepository.findAll();
		ArrayList<Promotion> promotions = new ArrayList<>();
		for(PromotionEntity entity : promotionEntities){
			Promotion promotion = providerConverter.promotionEntityToPromotionModel(entity);
			promotions.add(promotion);
		}
		return promotions;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Promotion> findPromotionByIdBrandAndDateOfDay(Integer idBrand){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("findPromotionByIdBrandAndDateOfDay").setInteger("idOfBrand", idBrand);
		List <PromotionEntity> promotionEntities = query.list();
		ArrayList <Promotion> promotions = new ArrayList<>();
		for(PromotionEntity entity : promotionEntities){
			Promotion promotion = providerConverter.promotionEntityToPromotionModel(entity);
			promotions.add(promotion);
		}
		session.getTransaction().commit();
		return promotions;
	}
	
	
}
