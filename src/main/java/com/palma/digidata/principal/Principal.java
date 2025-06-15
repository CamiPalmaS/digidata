package com.palma.digidata.principal;

import com.palma.digidata.service.ConectionAPI;
import com.palma.digidata.service.DataConversor;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Principal {
    private ConectionAPI conectionAPI = new ConectionAPI();
    private DataConversor conversor = new DataConversor();
    private String URL_BASE = "https://digi-api.com/api/v1/digimon/";
    private Scanner keyboard = new Scanner(System.in);

    public void showMenu() {
        System.out.println("Write the name to search for a digimon.");
        System.out.println("For combine names, you should use a space between,");
        System.out.println("(for example: Were Garurumon");
        var name = keyboard.nextLine().trim().toLowerCase();
        System.out.println(name);
        var json = "";
        if (!name.isEmpty()) {
            // Codificar espacios y otros caracteres especiales
            String encodedName = name.replace(" ", "%20");
            System.out.println(encodedName);
            json = conectionAPI.obtainData(URL_BASE + encodedName);

        } else {
            System.out.println("You must enter a name.");
        }
        //var data = conversor.obtainData(json, DataConversor.class);
        System.out.println(json);

    }
}
