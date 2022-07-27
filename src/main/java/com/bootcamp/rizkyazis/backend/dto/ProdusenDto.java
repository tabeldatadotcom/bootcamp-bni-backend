package com.bootcamp.rizkyazis.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProdusenDto {

    @Data
    @NoArgsConstructor
    public static class Create{
        @Size(min = 5)
        @NotEmpty
        @NotNull
        String nama;

        @Size(min = 2)
        @NotEmpty
        @NotNull
        String kode;

        @NotEmpty
        @NotNull
        String alamat;
    }
}
