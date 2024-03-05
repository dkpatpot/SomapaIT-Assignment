package com.thanaphat.SomapaITassignment.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.thanaphat.SomapaITassignment.model.UserModel;

@Service
@Transactional
public class UserService {
    private static final String CSV_FILE_PATH = "E:\\github\\SomapaIT-Assignment\\Backend\\SomapaIT-assignment\\src\\main\\java\\com\\thanaphat\\SomapaITassignment\\service\\Template.csv";
     public List<UserModel> readDataFromCSVFile() throws IOException, CsvValidationException {
        Path filePath = Paths.get(CSV_FILE_PATH);

        if (Files.exists(filePath)) {
            try (
                Reader reader = Files.newBufferedReader(filePath);
                CSVReader csvReader = new CSVReader(reader);
            ) {
                CsvToBean<UserModel> csvToBean = new CsvToBeanBuilder<UserModel>(csvReader)
                        .withType(UserModel.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                return csvToBean.parse();
            }
        } else {
            System.err.println("File not found: " + filePath);
            return Collections.emptyList();
        }
    }
}
