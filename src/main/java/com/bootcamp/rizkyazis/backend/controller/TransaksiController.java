package com.bootcamp.rizkyazis.backend.controller;

import com.bootcamp.rizkyazis.backend.dto.TransaksiDto;
import com.bootcamp.rizkyazis.backend.entity.Transaksi;
import com.bootcamp.rizkyazis.backend.service.ProdukService;
import com.bootcamp.rizkyazis.backend.service.TransaksiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transaksi")
@Slf4j
public class TransaksiController {

    @Autowired
    TransaksiService service;

    @Autowired
    ProdukService produkService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findId(@PathVariable Integer id) {
        try {
            Transaksi transaksi = service.findId(id);
            return ResponseEntity.ok(transaksi);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().body("Data tidak ditemukan");
        }
    }

    @GetMapping("")
    public List<Transaksi> findAll() {
        return service.findAll();
    }

    @GetMapping("/produk/{id}")
    public List<Transaksi> findAllByIdProduk(@PathVariable Integer id) {
        return service.findAllByIdProduk(id);
    }

    @GetMapping("/produsen/{id}")
    public List<Transaksi> findAllByIdProdusen(@PathVariable Integer id) {
        return service.findAllByIdProdusen(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> create
            (@RequestBody @Valid TransaksiDto.Create transaksi,
             BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            output.put("id", null);
            output.put("status", "Create data gagal");
            output.put("errors", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);
        } else {
            try {
                produkService.findId(transaksi.getProduk_id());
                output.put("id", service.create(transaksi));
                output.put("status", "Create data berhasil");
                return ResponseEntity.ok(output);
            } catch (EmptyResultDataAccessException e) {
                output.put("id", null);
                output.put("status", "Tidak dapat menemukan id produk");
                return ResponseEntity.badRequest().body(output);
            }

        }
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> update(
            @RequestBody @Valid TransaksiDto.Update transaksi,
            BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            output.put("status", "Update data gagal");
            output.put("errors", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);
        } else {
            try {
                service.findId(transaksi.getId());
                produkService.findId(transaksi.getProduk_id());
                service.update(transaksi);
                output.put("status", "Berhasil update data");
                return ResponseEntity.ok().body(output);
            } catch (EmptyResultDataAccessException e) {
                output.put("status", "Id tidak ditemukan");
                return ResponseEntity.badRequest().body(output);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete
            (@PathVariable Integer id) {
        Map<String, Object> output = new HashMap<>();
        try {
            service.findId(id);
            service.delete(id);
            output.put("status", "Berhasil hapus data");
            return ResponseEntity.ok(output);
        } catch (EmptyResultDataAccessException e) {
            output.put("status", "Id tidak ditemukan");
            return ResponseEntity.badRequest().body(output);
        }
    }

    @GetMapping("/{id}/detail")
    public ResponseEntity<?> findIdDetail(@PathVariable Integer id) {
        try {
            TransaksiDto.Detail transaksi = service.findIdDetail(id);
            return ResponseEntity.ok(transaksi);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.badRequest().body("Data tidak ditemukan");
        }
    }
}
