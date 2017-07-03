package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.OrderShopEntity;
import com.spring.henallux.dataAccess.repository.OrderShopRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.OrderShop;

@Service
@Transactional
public class OrderShopDAO {

	@Autowired
	private OrderShopRepository orderShopRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public OrderShop save(OrderShop orderShop){
		OrderShopEntity orderShopEntity = providerConverter.orderShopModelToOrderShopEntity(orderShop);
		orderShopEntity = orderShopRepository.save(orderShopEntity);
		return providerConverter.orderShopEntityToOrderShopModel(orderShopEntity);
	}
	
	public ArrayList<OrderShop> getAllOrdersShop(){
		List<OrderShopEntity> orderShopEntities = orderShopRepository.findAll();
		ArrayList<OrderShop> orderShop = new ArrayList<>();
		for(OrderShopEntity entity : orderShopEntities){
			OrderShop order = providerConverter.orderShopEntityToOrderShopModel(entity);
			orderShop.add(order);
		}
		return orderShop;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<OrderShop> findOrderByIdClient(Integer id){
		Session session = sessionFactory.openSession();
		Query query = session.getNamedQuery("findOrderByIdClient").setInteger("id", id);
		List<OrderShopEntity> orderShopEntities = query.list();
		ArrayList<OrderShop> orderShop = new ArrayList<>();
		for(OrderShopEntity entity : orderShopEntities){
			OrderShop order = providerConverter.orderShopEntityToOrderShopModel(entity);
			orderShop.add(order);
		}
		
		session.close();
		return orderShop;
	}

	
}
