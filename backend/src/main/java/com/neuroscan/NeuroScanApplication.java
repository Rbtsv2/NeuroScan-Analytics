package com.neuroscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import com.neuroscan.service.CSVImportService;

@SpringBootApplication(exclude = { R2dbcAutoConfiguration.class })
public class NeuroScanApplication implements CommandLineRunner {

    @Autowired
    private CSVImportService csvImportService;

    public static void main(String[] args) {
        SpringApplication.run(NeuroScanApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Chemin vers le CSV, par exemple "data/kaggle_dataset.csv"
        csvImportService.importCSVData("data/kaggle_dataset.csv");
    }
}
