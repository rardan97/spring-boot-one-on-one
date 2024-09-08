package com.blackcode.spring_boot_one_on_one.controller;

import com.blackcode.spring_boot_one_on_one.model.Capital;
import com.blackcode.spring_boot_one_on_one.service.CapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/capital")
public class CapitalController {

    @Autowired
    private CapitalService capitalService;

    @GetMapping
    public ResponseEntity<List<Capital>> getListAll(){
        return ResponseEntity.ok(capitalService.getListAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Capital> getById(@PathVariable Long id){
        Optional<Capital> capital = capitalService.getCapitalById(id);
        return new ResponseEntity<>(capital.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Capital> addCapital(@RequestBody Capital capital){
        Capital capital1 = capitalService.addCapital(capital);
        return new ResponseEntity<>(capital1, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Capital> updateCapital(@PathVariable Long id, @RequestBody Capital capital){
        Capital capital1 = capitalService.updateCapital(id, capital);
        return new ResponseEntity<>(capital1, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCapital(@PathVariable Long id){
        boolean capital = capitalService.deleteCapital(id);
        if(capital){
            return new ResponseEntity<>("Data "+id+" Successfully Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Data not Found", HttpStatus.NOT_FOUND);
    }
}
