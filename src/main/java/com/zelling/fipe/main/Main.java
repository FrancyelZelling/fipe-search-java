package com.zelling.fipe.main;

import com.zelling.fipe.utils.ApiSearch;
import com.zelling.fipe.utils.UserInput;

import java.util.Scanner;

public class Main {
    public void Main(){
        ApiSearch api = new ApiSearch();
        UserInput userInput = new UserInput();

        System.out.println("Digite o tipo de veículo que deseja buscar:");
        System.out.println("As opções são: carros, motos, caminhões");
        var option = userInput.typeVehicle();

        api.search(String.format("https://parallelum.com.br/fipe/api/v1/%s/marcas", option));
    }
}
