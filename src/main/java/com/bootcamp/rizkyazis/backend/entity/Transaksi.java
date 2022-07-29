package com.bootcamp.rizkyazis.backend.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Transaksi {
    Integer id;
    Produk produk;
    Integer kuantitas;
}
