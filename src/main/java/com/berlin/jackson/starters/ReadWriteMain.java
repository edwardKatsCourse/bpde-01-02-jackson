package com.berlin.jackson.starters;

import com.berlin.jackson.model.Gender;
import com.berlin.jackson.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadWriteMain {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person("Jane", 31, Gender.FEMALE);
        //{"name":"Jane","age":null, "car":null, "city":null} = { "name":"Jane" }

//        System.out.println(objectMapper.writeValueAsString(person));

//        System.out.println("Gender (MALE) ordinal: " + Gender.MALE.ordinal());
//        System.out.println("Gender (MALE) id: " + Gender.MALE.getId());
//        System.out.println("Gender name: " + Gender.MALE.getDescription());




//        String json = "{\"name\":\"Jane\",\"age\":31, \"address\": \"Baker St.\"}";
        String json = objectMapper.writeValueAsString(person);
//        {name:"Jane",age:31}

        Person deserializedPerson = objectMapper.readValue(json, Person.class);

        System.out.println(deserializedPerson.toString());

    }
}
