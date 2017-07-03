package com.spring.henallux.dataAccess.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.ModelEntity;

@Repository
@Transactional
public interface ModelRepository extends JpaRepository<ModelEntity, Integer>{
	
	public List<ModelEntity>findAllByOrderByIdModelDesc();
	public List<ModelEntity>findTop10ByOrderByIdModelDesc();
	
}