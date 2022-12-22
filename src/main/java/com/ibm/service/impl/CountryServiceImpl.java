package com.ibm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ibm.model.Country;
import com.ibm.repo.CountryRepository;
import com.ibm.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Override
	public List<Country> getCountryBySortingAndFiltering(int page, int size, String q, String sort) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sort));
		List<Country> findByIso3CodeLikeAndCountryNameLike = countryRepository
				.getCountryBySortingAndFiltering(q, pageable);
		
		return findByIso3CodeLikeAndCountryNameLike;
	}

}
