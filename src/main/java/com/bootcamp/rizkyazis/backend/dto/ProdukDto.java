package com.bootcamp.rizkyazis.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProdukDto {

    @Data
    @NoArgsConstructor
    public static class Create {

        @Size(min = 5)
        @NotEmpty
        @NotNull
        String nama;

        @NotEmpty
        @NotNull
        String jenis;

        @NotEmpty
        @NotNull
        String berat;

        @NotNull
        Double harga;

        @Min(1)
        @NotNull
        Integer produsen_id;
    }

    @Data
    @NoArgsConstructor
    public static class Update {

        @Min(1)
        @NotNull
        Integer id;

        @Size(min = 5)
        @NotEmpty
        @NotNull
        String nama;

        @NotEmpty
        @NotNull
        String jenis;

        @NotEmpty
        @NotNull
        String berat;

        @NotNull
        Double harga;

        @Min(1)
        @NotNull
        Integer produsen_id;

    }
}
