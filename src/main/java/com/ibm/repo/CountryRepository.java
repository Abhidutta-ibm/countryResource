package com.ibm.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ibm.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	//String FILTER_COUNTRY_ON_ISO3_CODE_AND_COUNTRY_NAME_QUERY = "select b from Country b where b.iso3Code like %?1% or b.countryName like %?1%";
	String FILTER_COUNTRY_ON_ISO3_CODE_AND_COUNTRY_NAME_QUERY = "select b from Country b where LOWER(b.iso3Code) LIKE LOWER(concat(?1, '%')) or LOWER(b.countryName) LIKE LOWER(concat(?1, '%'))";


	@Query(FILTER_COUNTRY_ON_ISO3_CODE_AND_COUNTRY_NAME_QUERY)
	List<Country> getCountryBySortingAndFiltering(String q, Pageable pageable);

}
