package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.DescriptionEntity;



@Repository
@Transactional
public interface DescriptionRepository extends JpaRepository<DescriptionEntity, Integer> {

}
