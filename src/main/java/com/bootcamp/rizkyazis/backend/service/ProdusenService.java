package com.bootcamp.rizkyazis.backend.service;

import com.bootcamp.rizkyazis.backend.dao.ProdusenDao;
import com.bootcamp.rizkyazis.backend.dto.ProdusenDto;
import com.bootcamp.rizkyazis.backend.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdusenService {

    @Autowired
    ProdusenDao dao;

    public Produsen findId(Integer id)
            throws EmptyResultDataAccessException {
        return dao.findId(id);
    }
    public List<Produsen> findAll(){
        return dao.findAll();
    }

    @Transactional
    public Integer create(ProdusenDto.Create produsen){
        return dao.create(produsen);
    }
}
