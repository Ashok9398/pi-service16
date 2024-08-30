package com.example.Piservice.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

@RestController
public class PiController {
    String filePath ;
    public PiController(@Value("${chunk.file}") String filePath){
        this.filePath = filePath;

    }
    @GetMapping("/pi")
    public String getPi(@RequestParam long searchX){

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            BigDecimal searchValue = BigDecimal.valueOf(searchX);


            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length >= 2) {
                    try {
                        BigDecimal x = new BigDecimal(parts[0]);
                        String piVal = parts[1];
                        if (x.compareTo(searchValue)==0) {

                            return ("pi(" + x + ") = " + piVal);

                        }
                        else if(x.compareTo(searchValue)>0){
                            return "Exact match not found. Nearest pi(" + x + ") = " + piVal;
                        }
                    } catch (NumberFormatException ignored) {

                    }
                }
            }
            return "No suitable x value found in the file.";

        } catch (IOException e) {
            return "Error reading the file "+ e.getMessage();
        }

    }
}
