package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.ModelEntity;
import com.spring.henallux.dataAccess.repository.ModelRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Model;

@Service
@Transactional
public class ModelDAO {

	@Autowired
	private ModelRepository modelRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	
	public Model findOne(Integer id){
		ModelEntity modelEntity = modelRepository.findOne(id);
		return providerConverter.modelEntityToModelModel(modelEntity);
	}
	
	public ArrayList<Model> getAllModels(){
		List<ModelEntity> modelEntities = modelRepository.findAll();
		ArrayList<Model> models = new ArrayList<>();
		for(ModelEntity entity : modelEntities){
			Model model = providerConverter.modelEntityToModelModel(entity);
			models.add(model);
		}
		return models;
	}
	
	public ArrayList<Model> getAllModelsOrderByDesc(){
		List<ModelEntity> modelEntities = modelRepository.findAllByOrderByIdModelDesc();
		ArrayList<Model> models = new ArrayList<>();
		for(ModelEntity entity : modelEntities){
			Model model = providerConverter.modelEntityToModelModel(entity);
			models.add(model);
		}
		return models;
	}
	
	public ArrayList<Model> findTop10ByOrderByIdModelDesc(){
		List<ModelEntity> modelEntities = modelRepository.findTop10ByOrderByIdModelDesc();
		ArrayList<Model> models = new ArrayList<>();
		for(ModelEntity entity : modelEntities){
			Model model = providerConverter.modelEntityToModelModel(entity);
			models.add(model);
		}
		return models;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Model> findModelsByCategory(Integer id){
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("findModelsByCategory").setInteger("idcategory", id);
		List<ModelEntity> modelEntities = query.list();
		ArrayList<Model> models = new ArrayList<>();
		for(ModelEntity entity : modelEntities){
			Model model = providerConverter.modelEntityToModelModel(entity);
			models.add(model);
		}
		session.close();
		return models;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Model> executeQuery(Query query){
		List<ModelEntity> modelsEntity = query.list();
		ArrayList<com.spring.henallux.model.Model> models = new ArrayList<>();
		
		for(ModelEntity m : modelsEntity){
			com.spring.henallux.model.Model modelModel = providerConverter.modelEntityToModelModel(m);
			models.add(modelModel);
		}
		return models;
	}
	
	
	public ArrayList<Model> searchModel(String keyword,String criteria){
		EntityManager em = entityManagerFactory.createEntityManager();
		FullTextEntityManager fullTextEntityManager =
		    org.hibernate.search.jpa.Search.getFullTextEntityManager(em);
		em.getTransaction().begin();

		// create native Lucene query unsing the query DSL
		// alternatively you can write the Lucene query using the Lucene query parser
		// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
		QueryBuilder qb = fullTextEntityManager.getSearchFactory()
		    .buildQueryBuilder().forEntity(ModelEntity.class).get();
		org.apache.lucene.search.Query luceneQuery = qb
		  .keyword()
		  .onFields(criteria)
		  .matching(keyword)
		  .createQuery();

		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, ModelEntity.class);

		// execute search
		List<Object> result = jpaQuery.getResultList();

		em.getTransaction().commit();

		
		ArrayList<Model> models = new ArrayList<>();
		for(Object o : result){
			models.add(providerConverter.modelEntityToModelModel((ModelEntity)o));
		}
		em.close();
		return models;
	}
	
}