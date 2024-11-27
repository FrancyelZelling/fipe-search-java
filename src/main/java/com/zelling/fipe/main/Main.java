package com.zelling.fipe.main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zelling.fipe.models.BrandData;
import com.zelling.fipe.utils.ApiSearch;
import com.zelling.fipe.utils.Converter;
import com.zelling.fipe.utils.UserInput;

import java.util.List;


public class Main {
    public void Main() throws JsonProcessingException {
        ApiSearch api = new ApiSearch();
        UserInput userInput = new UserInput();
        Converter converter = new Converter();
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("Digite o tipo de veículo que deseja buscar:");
        System.out.println("As opções são: carros, motos, caminhões");
        var option = userInput.typeVehicle();

        String json = api.search(String.format("https://parallelum.com.br/fipe/api/v1/%s/marcas", option));
        System.out.println(json);
        List<BrandData> brandsData = converter.getDataAsList(json, BrandData.class);

        System.out.println(brandsData);
    }
}
