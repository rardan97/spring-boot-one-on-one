package com.blackcode.spring_boot_one_on_one.controller;


import com.blackcode.spring_boot_one_on_one.model.Country;
import com.blackcode.spring_boot_one_on_one.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getAll(){
        return ResponseEntity.ok(countryService.getListAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getById(@PathVariable Long id){
        Country country = countryService.getCountryById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country){
        Country countryData = countryService.addCountry(country);
        return new ResponseEntity<>(countryData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable Long id, @RequestBody Country country){
        Country countryData = countryService.updateCountry(id, country);
        return new ResponseEntity<>(countryData, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id){
        boolean country = countryService.deleteCountry(id);
        if(country){
            return new ResponseEntity<>("Data "+id+" Successfully Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Data "+id+" Not Found", HttpStatus.NOT_FOUND);
    }
}
