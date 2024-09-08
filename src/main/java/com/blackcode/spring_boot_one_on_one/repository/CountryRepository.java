package com.blackcode.spring_boot_one_on_one.repository;

import com.blackcode.spring_boot_one_on_one.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
