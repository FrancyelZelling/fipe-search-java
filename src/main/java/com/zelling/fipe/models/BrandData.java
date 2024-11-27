package com.zelling.fipe.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BrandData(
        @JsonAlias("codigo") String code,
        @JsonAlias("nome") String name
) {

}
