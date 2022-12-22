package com.ibm.service;

import java.util.List;

import com.ibm.model.Country;

public interface CountryService {
	public List<Country> getCountryBySortingAndFiltering(int page, int size, String q, String sort);
}
