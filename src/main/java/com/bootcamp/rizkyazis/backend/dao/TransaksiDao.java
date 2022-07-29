package com.bootcamp.rizkyazis.backend.dao;

import com.bootcamp.rizkyazis.backend.dto.ProdukDto;
import com.bootcamp.rizkyazis.backend.dto.TransaksiDto;
import com.bootcamp.rizkyazis.backend.entity.Produk;
import com.bootcamp.rizkyazis.backend.entity.Produsen;
import com.bootcamp.rizkyazis.backend.entity.Transaksi;
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
import java.util.Map;

@Repository
public class TransaksiDao {


    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public Transaksi findId(Integer id) {
        String query = "SELECT transaksi.id, \n" +
                "transaksi.kuantitas,\n" +
                "produk.id as produk_id,\n" +
                "produk.nama as produk_nama,\n" +
                "produk.jenis as produk_jenis,\n" +
                "produk.berat as produk_berat,\n" +
                "produk.harga as produk_harga\n" +
                "FROM public.transaksi transaksi\n" +
                "left join public.produk produk on transaksi.produk_id = produk.id " +
                "where transaksi.id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(query, map, new RowMapper<Transaksi>() {
            @Override
            public Transaksi mapRow(ResultSet rs, int rowNum) throws SQLException {
                Transaksi transaksi = new Transaksi();
                transaksi.setId(rs.getInt("id"));
                transaksi.setKuantitas(rs.getInt("kuantitas"));

                Produk produk = new Produk();
                produk.setId(rs.getInt("produk_id"));
                produk.setNama(rs.getString("produk_nama"));
                produk.setJenis(rs.getString("produk_jenis"));
                produk.setBerat(rs.getString("produk_berat"));
                produk.setHarga(rs.getDouble("produk_harga"));
                transaksi.setProduk(produk);
                return transaksi;
            }
        });
    }

    public List<Transaksi> findAll() {
        String query = "SELECT transaksi.id, \n" +
                "transaksi.kuantitas,\n" +
                "produk.id as produk_id,\n" +
                "produk.nama as produk_nama,\n" +
                "produk.jenis as produk_jenis,\n" +
                "produk.berat as produk_berat,\n" +
                "produk.harga as produk_harga\n" +
                "FROM public.transaksi transaksi\n" +
                "left join public.produk produk on transaksi.produk_id = produk.id ";
        return jdbcTemplate.query(query, new RowMapper<Transaksi>() {
            @Override
            public Transaksi mapRow(ResultSet rs, int rowNum) throws SQLException {
                Transaksi transaksi = new Transaksi();
                transaksi.setId(rs.getInt("id"));
                transaksi.setKuantitas(rs.getInt("kuantitas"));

                Produk produk = new Produk();
                produk.setId(rs.getInt("produk_id"));
                produk.setNama(rs.getString("produk_nama"));
                produk.setJenis(rs.getString("produk_jenis"));
                produk.setBerat(rs.getString("produk_berat"));
                produk.setHarga(rs.getDouble("produk_harga"));
                transaksi.setProduk(produk);
                return transaksi;
            }
        });
    }


    public List<Transaksi> findAllByIdProduk(Integer id) {
        String query = "SELECT transaksi.id, \n" +
                "transaksi.kuantitas,\n" +
                "produk.id as produk_id,\n" +
                "produk.nama as produk_nama,\n" +
                "produk.jenis as produk_jenis,\n" +
                "produk.berat as produk_berat,\n" +
                "produk.harga as produk_harga\n" +
                "FROM public.transaksi transaksi\n" +
                "left join public.produk produk on transaksi.produk_id = produk.id " +
                "where produk.id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.query(query, map, new RowMapper<Transaksi>() {
            @Override
            public Transaksi mapRow(ResultSet rs, int rowNum) throws SQLException {
                Transaksi transaksi = new Transaksi();
                transaksi.setId(rs.getInt("id"));
                transaksi.setKuantitas(rs.getInt("kuantitas"));

                Produk produk = new Produk();
                produk.setId(rs.getInt("produk_id"));
                produk.setNama(rs.getString("produk_nama"));
                produk.setJenis(rs.getString("produk_jenis"));
                produk.setBerat(rs.getString("produk_berat"));
                produk.setHarga(rs.getDouble("produk_harga"));
                transaksi.setProduk(produk);
                return transaksi;
            }
        });
    }

    public List<Transaksi> findAllByIdProdusen(Integer id) {
        String query = "SELECT transaksi.id, \n" +
                "transaksi.kuantitas,\n" +
                "produk.id as produk_id,\n" +
                "produk.nama as produk_nama,\n" +
                "produk.jenis as produk_jenis,\n" +
                "produk.berat as produk_berat,\n" +
                "produk.harga as produk_harga\n" +
                "FROM public.transaksi transaksi\n" +
                "left join public.produk produk on transaksi.produk_id = produk.id " +
                "where produk.produsen_id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.query(query, map, new RowMapper<Transaksi>() {
            @Override
            public Transaksi mapRow(ResultSet rs, int rowNum) throws SQLException {
                Transaksi transaksi = new Transaksi();
                transaksi.setId(rs.getInt("id"));
                transaksi.setKuantitas(rs.getInt("kuantitas"));

                Produk produk = new Produk();
                produk.setId(rs.getInt("produk_id"));
                produk.setNama(rs.getString("produk_nama"));
                produk.setJenis(rs.getString("produk_jenis"));
                produk.setBerat(rs.getString("produk_berat"));
                produk.setHarga(rs.getDouble("produk_harga"));
                transaksi.setProduk(produk);
                return transaksi;
            }
        });
    }

    public Integer create(TransaksiDto.Create transaksi) {
        String query = "INSERT INTO public.transaksi\n" +
                "(produk_id, kuantitas)\n" +
                "VALUES(:produk_id, :kuantitas);\n";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("produk_id", transaksi.getProduk_id());
        map.addValue("kuantitas", transaksi.getKuantitas());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(query, map, keyHolder);
        return (Integer) keyHolder.getKeys().get("id");
    }

    public void update(TransaksiDto.Update transaksi) {
        String query = "UPDATE public.transaksi\n" +
                "SET produk_id=:produk_id, kuantitas=:kuantitas\n" +
                "WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("produk_id", transaksi.getProduk_id());
        map.addValue("kuantitas", transaksi.getKuantitas());
        map.addValue("id", transaksi.getId());
        jdbcTemplate.update(query, map);
    }

    public void delete(Integer id) {
        String query = "DELETE FROM public.transaksi\n" +
                "WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query, map);
    }

    public TransaksiDto.Detail findIdDetail(Integer id) {
        String query = "SELECT transaksi.id, \n" +
                "transaksi.kuantitas,\n" +
                "produk.nama as produk,\n" +
                "produsen.nama as produsen,\n" +
                "produk.harga as harga,\n" +
                "(transaksi.kuantitas * produk.harga) as totalHarga\n" +
                "FROM public.transaksi transaksi\n" +
                "left join public.produk produk on transaksi.produk_id = produk.id \n" +
                "left join public.produsen produsen on produk.produsen_id = produsen.id \n" +
                "where transaksi.id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(query, map, new RowMapper<TransaksiDto.Detail>() {
            @Override
            public TransaksiDto.Detail mapRow(ResultSet rs, int rowNum) throws SQLException {
                TransaksiDto.Detail transaksi = new TransaksiDto.Detail();
                transaksi.setId(rs.getInt("id"));
                transaksi.setKuantitas(rs.getInt("kuantitas"));
                transaksi.setProdusen(rs.getString("produsen"));
                transaksi.setProduk(rs.getString("produk"));
                transaksi.setHarga(rs.getDouble("harga"));
                transaksi.setTotalHarga(rs.getDouble("totalHarga"));
                return transaksi;
            }
        });
    }
}
