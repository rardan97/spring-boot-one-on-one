package com.blackcode.spring_boot_one_on_one.service;


import com.blackcode.spring_boot_one_on_one.model.Capital;
import com.blackcode.spring_boot_one_on_one.model.Country;
import com.blackcode.spring_boot_one_on_one.repository.CapitalRepository;
import com.blackcode.spring_boot_one_on_one.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapitalImplService implements CapitalService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CapitalRepository capitalRepository;

    @Override
    public List<Capital> getListAll() {
        return capitalRepository.findAll();
    }

    @Override
    public Optional<Capital> getCapitalById(Long id) {
        return capitalRepository.findById(id);
    }

    @Override
    public Capital addCapital(Capital capital) {
        Capital capitalData = new Capital();
        capitalData.setCapital_name(capital.getCapital_name());
        Optional<Country> country = countryRepository.findById(capital.getCountry().getCountry_id());
        capitalData.setCountry(country.get());
        return capitalRepository.save(capitalData);
    }

    @Override
    public Capital updateCapital(Long id, Capital capital) {
        Optional<Capital> capital1 = capitalRepository.findById(id);
        Capital capitalTemp = capital1.get();
        capitalTemp.setCapital_name(capital.getCapital_name());
        return capitalRepository.save(capitalTemp);
    }

    @Override
    public boolean deleteCapital(Long id) {
        Optional<Capital> capitalData = capitalRepository.findById(id);
        if(capitalData.isPresent()){
            capitalRepository.deleteById(id);
            return true;
        }else{

            return false;
        }
    }
}
