package com.bootcamp.rizkyazis.backend.dao;

import com.bootcamp.rizkyazis.backend.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProdusenDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public Produsen findId(Integer id) {
        String query = "SELECT id, nama, kode, alamat\n" +
                "FROM public.produsen where id = :idProdusen";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idProdusen", id);
        return jdbcTemplate.queryForObject(query, map, new RowMapper<Produsen>() {
            @Override
            public Produsen mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produsen produsen = new Produsen();
                produsen.setId(rs.getInt("id"));
                produsen.setNama(rs.getString("nama"));
                produsen.setKode(rs.getString("kode"));
                produsen.setAlamat(rs.getString("alamat"));
                return produsen;
            }
        });
    }

    public List<Produsen> findAll(){
        String query = "SELECT id, nama, kode, alamat\n" +
                "FROM public.produsen";
        return jdbcTemplate.query(query, new RowMapper<Produsen>() {
            @Override
            public Produsen mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produsen produsen = new Produsen();
                produsen.setId(rs.getInt("id"));
                produsen.setNama(rs.getString("nama"));
                produsen.setKode(rs.getString("kode"));
                produsen.setAlamat(rs.getString("alamat"));
                return produsen;
            }
        });
    }

}