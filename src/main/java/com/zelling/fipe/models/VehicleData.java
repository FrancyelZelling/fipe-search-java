package com.zelling.fipe.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VehicleData(
        @JsonAlias("Marca") String brand,
        @JsonAlias("Modelo") String model,
        @JsonAlias("Valor") String value,
        @JsonAlias("AnoModelo") String yearModel,
        @JsonAlias("Combustível") String fuelType,
        @JsonAlias("CodigoFipe") String fipeCode,
        @JsonAlias("MesReferencia") String monthRef
) {
}
