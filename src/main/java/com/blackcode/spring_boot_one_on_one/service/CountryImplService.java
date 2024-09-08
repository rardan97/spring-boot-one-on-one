package com.blackcode.spring_boot_one_on_one.service;


import com.blackcode.spring_boot_one_on_one.model.Country;
import com.blackcode.spring_boot_one_on_one.repository.CapitalRepository;
import com.blackcode.spring_boot_one_on_one.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryImplService implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CapitalRepository capitalRepository;

    @Override
    public List<Country> getListAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long id) {
        Optional<Country> countryTemp = countryRepository.findById(id);
        return countryTemp.get();
    }

    @Override
    public Country addCountry(Country country) {
        Country countryData = new Country();
        countryData.setCountry_name(country.getCountry_name());
        return countryRepository.save(countryData);
    }

    @Override
    public Country updateCountry(Long id, Country country) {
        Optional<Country> countryData = countryRepository.findById(id);
        Country countryTmp = countryData.get();
        countryTmp.setCountry_name(country.getCountry_name());
        return countryRepository.save(countryTmp);

    }

    @Override
    public boolean deleteCountry(Long id) {
        Optional<Country> countryData = countryRepository.findById(id);
        if(countryData.isPresent()){
            capitalRepository.deleteById(countryData.get().getCountry_id());
            countryRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
