package com.zelling.fipe.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zelling.fipe.models.Data;
import com.zelling.fipe.models.VehicleSimpleData;
import com.zelling.fipe.utils.ApiSearch;
import com.zelling.fipe.utils.Converter;
import com.zelling.fipe.utils.UserInput;

import java.io.IOException;
import java.util.List;

public class Main {
    public void Main() throws IOException {
        ApiSearch api = new ApiSearch();
        UserInput userInput = new UserInput();
        Converter converter = new Converter();
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("Digite o tipo de veículo que deseja buscar:");
        System.out.println("As opções são: carros, motos, caminhões");
        var option = userInput.typeVehicle();

        String json = api.search(String.format("https://parallelum.com.br/fipe/api/v1/%s/marcas", option));
        System.out.println(json);
        List<Data> brandsData = converter.getDataAsList(json, Data.class);

        brandsData.stream()
                .forEach(b -> System.out.println(String.format("Código: %s, Marca: %s", b.code(), b.name())));

        System.out.println("Digite o código da marca desejada para ver os modelos disponíveis:");
        var brandCode = userInput.brandCode();


        json = api.search(String.format("https://parallelum.com.br/fipe/api/v1/carros/marcas/120/modelos", brandCode));

        var modelsData = converter.getData(json, VehicleSimpleData.class);

        modelsData.modelos().forEach(System.out::println);
    }
}
