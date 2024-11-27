package com.zelling.fipe.utils;

import java.util.Scanner;

public class UserInput {
    Scanner scanner = new Scanner(System.in);

    public String typeVehicle(){
        var option = scanner.nextLine();

        if(option.equalsIgnoreCase("caminhões")){
            return "caminhoes";
        } else {
            return option;
        }
    }
}
