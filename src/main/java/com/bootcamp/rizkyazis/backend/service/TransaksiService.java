package com.bootcamp.rizkyazis.backend.service;

import com.bootcamp.rizkyazis.backend.dao.TransaksiDao;
import com.bootcamp.rizkyazis.backend.dto.TransaksiDto;
import com.bootcamp.rizkyazis.backend.entity.Transaksi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransaksiService {

    @Autowired
    TransaksiDao dao;

    public Transaksi findId(Integer id)
            throws EmptyResultDataAccessException {
        return dao.findId(id);
    }

    public List<Transaksi> findAll() {
        return dao.findAll();
    }

    public List<Transaksi> findAllByIdProduk(Integer id) {
        return dao.findAllByIdProduk(id);
    }

    public List<Transaksi> findAllByIdProdusen(Integer id) {
        return dao.findAllByIdProdusen(id);
    }

    @Transactional
    public Integer create(TransaksiDto.Create transaksi) {
        return dao.create(transaksi);
    }

    @Transactional
    public void update(TransaksiDto.Update transaksi) {
        dao.update(transaksi);
    }

    @Transactional
    public void delete(Integer id) {
        dao.delete(id);
    }

    public TransaksiDto.Detail findIdDetail(Integer id)
            throws EmptyResultDataAccessException {
        return dao.findIdDetail(id);
    }
}
