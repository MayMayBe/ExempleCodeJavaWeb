package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.EquivalentDescriptionEntity;

@Repository
@Transactional
public interface EquivalentDescriptionRepository extends JpaRepository<EquivalentDescriptionEntity, Integer> {
}
