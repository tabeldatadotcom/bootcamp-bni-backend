package com.bootcamp.rizkyazis.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TransaksiDto {

    @Data
    @NoArgsConstructor
    public static class Create {

        @Min(1)
        @NotNull
        Integer produk_id;

        @Min(1)
        @NotNull
        Integer kuantitas;
    }

    @Data
    @NoArgsConstructor
    public static class Update {

        @Min(1)
        @NotNull
        Integer id;

        @Min(1)
        @NotNull
        Integer produk_id;

        @Min(1)
        @NotNull
        Integer kuantitas;
    }

    @Data
    @NoArgsConstructor
    public static class Detail {
        Integer id;
        String produk;
        String produsen;
        Double harga;
        Integer kuantitas;
        Double totalHarga;
    }

}
