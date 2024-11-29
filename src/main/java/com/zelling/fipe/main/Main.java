package com.zelling.fipe.main;

import com.zelling.fipe.models.Data;
import com.zelling.fipe.models.VehicleSimpleData;
import com.zelling.fipe.models.YearListModels;
import com.zelling.fipe.utils.ApiSearch;
import com.zelling.fipe.utils.Converter;
import com.zelling.fipe.utils.UserInput;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public void Main() {
        ApiSearch api = new ApiSearch();
        UserInput userInput = new UserInput();
        Converter converter = new Converter();

        System.out.println("Digite o tipo de veículo que deseja buscar:");
        System.out.println("As opções são: carros, motos, caminhões");
        var vehicleType = userInput.typeVehicle();

        var baseUrl = "https://parallelum.com.br/fipe/api/v1/";

        String json = api.search(baseUrl + vehicleType + "/marcas/");
        System.out.println(json);
        List<Data> brandsData = converter.getDataAsList(json, Data.class);

        brandsData
                .forEach(b -> System.out.printf("Código: %s, Marca: %s%n", b.code(), b.name()));

        System.out.println("Digite o código da marca desejada para ver os modelos disponíveis:");
        var brandCode = userInput.brandCode();

        json = api.search(baseUrl + vehicleType + "/marcas/" + brandCode +"/modelos");

        var modelsData = converter.getData(json, VehicleSimpleData.class);
//        var yearListModels = converter.getData(json, YearListModels.class);

        modelsData.modelos().forEach(System.out::println);
        System.out.println("Digite o nome do veiculo que deseja procurar:");
        var vehicleName = userInput.vehicleName();

        List<Data> anosDisponiveis = modelsData.modelos().stream()
                .filter(m -> m.name().toLowerCase().contains(vehicleName.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("Filtered List");

        anosDisponiveis.forEach(System.out::println);

    }
}
