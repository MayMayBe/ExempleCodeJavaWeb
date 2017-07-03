package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.henallux.dataAccess.entity.BrandEntity;
import com.spring.henallux.dataAccess.repository.BrandRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Brand;

@Service
@Transactional
public class BrandDAO {

	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	
	public Brand save(Brand brand){
		BrandEntity brandEntity = providerConverter.brandModelToBrandEntity(brand);
		brandEntity = brandRepository.save(brandEntity);
		return providerConverter.brandEntityToBrandModel(brandEntity);
	}
	
	public ArrayList<Brand> getAllBrands(){
		List<BrandEntity> brandEntities = brandRepository.findAll();
		ArrayList<Brand> brand = new ArrayList<>();
		for(BrandEntity entity : brandEntities){
			Brand brandProvider = providerConverter.brandEntityToBrandModel(entity);
			brand.add(brandProvider);
		}
		return brand;
	}
	
	public Brand findOne(Integer id){
		BrandEntity brandEntity = brandRepository.findOne(id);
		return providerConverter.brandEntityToBrandModel(brandEntity);
	}
	
}