package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.EquivalentDescriptionEntity;
import com.spring.henallux.dataAccess.repository.EquivalentDescriptionRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.EquivalentDescription;

@Service
@Transactional
public class EquivalentDescriptionDAO {

	@Autowired
	private EquivalentDescriptionRepository equivalentDescriptionRepository;

	@Autowired
	private ProviderConverter providerConverter;

	@Autowired
	private SessionFactory sessionFactory;

	public ArrayList<EquivalentDescription> getAllCharacteristics() {
		List<EquivalentDescriptionEntity> listEntities = equivalentDescriptionRepository.findAll();
		ArrayList<EquivalentDescription> result = new ArrayList<>();
		for (EquivalentDescriptionEntity entity : listEntities) {
			EquivalentDescription provider = providerConverter
					.equivalentDescriptionEntityToEquivalentDescriptionModel(entity);
			result.add(provider);
		}
		return result;
	}

	public EquivalentDescription findDescriptionByModelAndLanguage(Integer idModel, String language) {
		Session session = sessionFactory.openSession();

			Query query = session.getNamedQuery("findDescriptionByModelAndLanguage").setInteger("modelID", idModel).setString("languageName", language);
			EquivalentDescriptionEntity result = (EquivalentDescriptionEntity) query.list().get(0);
			EquivalentDescription equivalentDescription = providerConverter.equivalentDescriptionEntityToEquivalentDescriptionModel(result);
			session.close();
			return equivalentDescription;
	}
}
