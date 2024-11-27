package com.zelling.fipe.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record BrandData(
        @JsonAlias("codigo") String code,
        @JsonAlias("name") String name
) {

}
