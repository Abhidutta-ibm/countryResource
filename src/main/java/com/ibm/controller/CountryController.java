package com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.Country;
import com.ibm.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	CountryService countryService;

	@GetMapping("/country")
	public List<Country> fetchCountryDataAsPageWithSorting(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "") String q, 
			@RequestParam(defaultValue = "countryName") String sort) {
		
		return countryService.getCountryBySortingAndFiltering(page, size, q,sort);
	}

}
