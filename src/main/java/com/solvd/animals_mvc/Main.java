package com.solvd.animals_mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.animals_mvc.model.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        File personJson = new File("src/main/resources/json/person.json");
        File animalJson = new File("src/main/resources/json/animal.json");
        File departmentJson = new File("src/main/resources/json/department.json");
        File employeeIdentifierJson = new File("src/main/resources/json/employee_identifier.json");
        File zooJson = new File("src/main/resources/json/zoo.json");
        File habitatJson = new File("src/main/resources/json/habitat.json");

        LOGGER.info(parseJson(personJson,Person.class));
        LOGGER.info(parseJson(animalJson,Animal.class));
        LOGGER.info(parseJson(departmentJson,Department.class));
        LOGGER.info(parseJson(employeeIdentifierJson,EmployeeIdentifier.class));
        LOGGER.info(parseJson(zooJson,Zoo.class));
        LOGGER.info(parseJson(habitatJson, Habitat.class));
    }

    private static <T> T parseJson(File jsonFile, Class<T> clazz){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
            return objectMapper.readValue(jsonFile,clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
