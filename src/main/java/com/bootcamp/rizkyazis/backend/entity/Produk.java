package com.bootcamp.rizkyazis.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Produk {
    Integer id;
    String nama;
    String jenis;
    String berat;
}
