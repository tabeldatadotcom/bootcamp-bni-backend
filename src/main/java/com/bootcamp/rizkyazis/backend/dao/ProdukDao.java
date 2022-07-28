package com.bootcamp.rizkyazis.backend.dao;

import com.bootcamp.rizkyazis.backend.dto.ProdukDto;
import com.bootcamp.rizkyazis.backend.dto.ProdusenDto;
import com.bootcamp.rizkyazis.backend.entity.Produk;
import com.bootcamp.rizkyazis.backend.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProdukDao {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public Produk findId(Integer id) {
        String query = "SELECT id, nama, jenis, berat\n" +
                "FROM public.produk where id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(query, map, new RowMapper<Produk>() {
            @Override
            public Produk mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produk produk = new Produk();
                produk.setId(rs.getInt("id"));
                produk.setNama(rs.getString("nama"));
                produk.setJenis(rs.getString("jenis"));
                produk.setBerat(rs.getString("berat"));
                return produk;
            }
        });
    }

    public List<Produk> findAll() {
        String query = "SELECT id, nama, jenis, berat\n" +
                "FROM public.produk";
        return jdbcTemplate.query(query, new RowMapper<Produk>() {
            @Override
            public Produk mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produk produk = new Produk();
                produk.setId(rs.getInt("id"));
                produk.setNama(rs.getString("nama"));
                produk.setJenis(rs.getString("jenis"));
                produk.setBerat(rs.getString("berat"));
                return produk;
            }
        });
    }

    public Integer create(ProdukDto.Create produk) {
        String query = "INSERT INTO public.produk\n" +
                "(nama, jenis, berat)\n" +
                "VALUES(:nama, :jenis, :berat)";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("nama", produk.getNama());
        map.addValue("jenis", produk.getJenis());
        map.addValue("berat", produk.getBerat());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, map, keyHolder);
        return (Integer) keyHolder.getKeys().get("id");
    }

    public void update(ProdukDto.Update produk) {
        String query = "UPDATE public.produk\n" +
                "SET nama=:nama, jenis=:jenis, berat=:berat\n" +
                "WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("nama", produk.getNama());
        map.addValue("jenis", produk.getJenis());
        map.addValue("berat", produk.getBerat());
        map.addValue("id", produk.getId());
        jdbcTemplate.update(query, map);
    }

    public void delete(Integer id) {
        String query = "DELETE FROM public.produk\n" +
                "WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query, map);
    }
}
