package com.berlin.jackson.starters;

import com.berlin.jackson.model.Gender;
import com.berlin.jackson.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadWriteToFile {
    private static final String ENCODING = "UTF-8";

    static List<Person> personList = new ArrayList<>();
    static File personFile = new File("person.list");
    static ObjectMapper objectMapper = new ObjectMapper();


    public static void main(String[] args) throws Exception {

        init();
        personList.add(getPerson());
        String json = objectMapper.writeValueAsString(personList);
        FileUtils.write(personFile, json, ENCODING);

        personList.forEach(System.out::println);
    }

    private static void init() throws Exception {
        String personFileContent = FileUtils.readFileToString(personFile, ENCODING);
        //JSON -> LinkedHashMap
        // {"key" : "value", "key1":"value"} -> LinkedHashMap

        //List<LinkedHashMap<Object, Object>> != List<Person>
        personList = objectMapper.readValue(personFileContent, new TypeReference<List<Person>>() {});
//        personList = objectMapper.readValue(personFileContent, List.class);
    }

    public static Person getPerson() {

        System.out.println("Name: ");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Age: ");
        Integer age = new Scanner(System.in).nextInt();

        System.out.println("Gender (1-Male, 2-Female, 3-Rather not to tell)");
        Integer genderInt = new Scanner(System.in).nextInt();
        Gender gender = Gender.getById(genderInt);

        return new Person(name, age, gender);
    }
}
