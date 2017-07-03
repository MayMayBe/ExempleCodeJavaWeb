package com.spring.henallux.dataAccess.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.OrderShopEntity;

@Repository
@Transactional
public interface OrderShopRepository extends JpaRepository<OrderShopEntity,Integer>{

	//public List<OrderShopEntity> findOrderByIdClient(Integer id);
}
