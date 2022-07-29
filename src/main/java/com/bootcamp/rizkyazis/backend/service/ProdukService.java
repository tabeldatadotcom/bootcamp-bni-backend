package com.bootcamp.rizkyazis.backend.service;

import com.bootcamp.rizkyazis.backend.dao.ProdukDao;
import com.bootcamp.rizkyazis.backend.dao.ProdusenDao;
import com.bootcamp.rizkyazis.backend.dto.ProdukDto;
import com.bootcamp.rizkyazis.backend.dto.ProdusenDto;
import com.bootcamp.rizkyazis.backend.entity.Produk;
import com.bootcamp.rizkyazis.backend.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdukService {

    @Autowired
    ProdukDao dao;

    public Produk findId(Integer id)
            throws EmptyResultDataAccessException {
        return dao.findId(id);
    }

    public List<Produk> findAll() {
        return dao.findAll();
    }

    public List<Produk> findAllByProdusen(Integer id) {
        return dao.findAllByIdProdusen(id);
    }

    @Transactional
    public Integer create(ProdukDto.Create produk) {
        return dao.create(produk);
    }

    @Transactional
    public void update(ProdukDto.Update produk) {
        dao.update(produk);
    }

    @Transactional
    public void delete(Integer id){
        dao.delete(id);
    }
}
