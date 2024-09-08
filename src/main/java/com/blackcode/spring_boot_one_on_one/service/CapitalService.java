package com.blackcode.spring_boot_one_on_one.service;

import com.blackcode.spring_boot_one_on_one.model.Capital;
import java.util.List;
import java.util.Optional;

public interface CapitalService {
    List<Capital> getListAll();

    Optional<Capital> getCapitalById(Long id);

    Capital addCapital(Capital capital);

    Capital updateCapital(Long id, Capital capital);

    boolean deleteCapital(Long id);
}
