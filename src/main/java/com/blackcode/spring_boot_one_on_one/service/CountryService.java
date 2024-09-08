package com.blackcode.spring_boot_one_on_one.service;

import com.blackcode.spring_boot_one_on_one.model.Country;
import java.util.List;

public interface CountryService {

    List<Country> getListAll();

    Country getCountryById(Long id);

    Country addCountry(Country country);

    Country updateCountry(Long id, Country country);

    boolean deleteCountry(Long id);

}
