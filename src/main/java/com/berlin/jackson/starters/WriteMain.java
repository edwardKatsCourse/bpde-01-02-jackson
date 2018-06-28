package com.berlin.jackson.starters;

import com.berlin.jackson.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
//import javax.persistence.
//import javax.validation.

public class WriteMain {
    //1
    //AR_00001000
    //AR_00000002
    //AR_00000003
    //...
    //AR_00000010
    //AR_00000100

    public static void main(String[] args) throws Exception {
        File file = new File("string.txt");
        FileUtils.write(file, "this is my string", "UTF-8");


        //XML, JSON
        //XML -> object, object -> XML

        //unmarshalling (XML->object)   marshalling (object -> XML)
        //deserialization               serialization
        //JSON -> object,               object -> JSON

        // JSON object ->  { "object": { "name": "value" }, "name":"david", "age": 32 }
        // JSON array -> [{}, {}]

        //Json: boolean, string, number (int, double), object, array
        //{ "name" : "David" }
        //{ "status" : true }
        //{ "age" : 37 }
        //{"address": { "street" : "Baker St."} }
        //{"names" : ["Sarah", "Jacob"] }
        //{ "age" : null }

        //Jackson (fasterxml)


        List<Person> personList = new ArrayList<>();


//        personList.add(new Person("Bella", 24));
//        personList.add(new Person("Andrew", 45));
//        personList.add(new Person("Pavel", 51));
//        personList.add(new Person("Natalie", 21));
//        personList.add(new Person("Simon", 33));
//        personList.add(new Person("Daniel", 67));
//        personList.add(new Person("Sarah", 51));
//        personList.add(new Person("Jane", 31));

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(personList);

        System.out.println(json);
    }
}
