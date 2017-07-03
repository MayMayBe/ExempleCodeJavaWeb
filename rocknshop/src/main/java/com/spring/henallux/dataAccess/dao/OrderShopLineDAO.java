package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.OrderShopLineEntity;
import com.spring.henallux.dataAccess.repository.OrderShopLineRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.OrderShopLine;

@Service
@Transactional
public class OrderShopLineDAO {
	
	@Autowired
	private OrderShopLineRepository orderShopLineRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	
	public OrderShopLine save(OrderShopLine orderShopLine){
		OrderShopLineEntity orderShopLineEntity = providerConverter.orderShopLineModelToOrderShopLineEntity(orderShopLine);
		orderShopLineEntity = orderShopLineRepository.save(orderShopLineEntity);
		return providerConverter.orderShopLineEntityToOrderShopLineModel(orderShopLineEntity);
	}
	
	public ArrayList<OrderShopLine> getAllOrdersLinesShop(){
		List<OrderShopLineEntity> orderShopLineEntities = orderShopLineRepository.findAll();
		ArrayList<OrderShopLine> entities = new ArrayList<>();
		for(OrderShopLineEntity entity : orderShopLineEntities){
			OrderShopLine orderShopLine = providerConverter.orderShopLineEntityToOrderShopLineModel(entity);
			entities.add(orderShopLine);
		}
		return entities;
	}


}
