package com.bootcamp.rizkyazis.backend.controller;

import com.bootcamp.rizkyazis.backend.entity.Produsen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.rizkyazis.backend.service.ProdusenService;

import java.util.List;

@RestController
@RequestMapping("/api/produsen")
@Slf4j
public class ProdusenController {

    @Autowired
    ProdusenService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable Integer id){
        try{
            Produsen produsen = service.findId(id);
            return ResponseEntity.ok(produsen);
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.badRequest().body("Data tidak ditemukan");
        }
    }

    @GetMapping("")
    public List<Produsen> findAll(){
        return service.findAll();
    }
}
