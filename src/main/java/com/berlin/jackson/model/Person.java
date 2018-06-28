package com.berlin.jackson.model;

import com.berlin.jackson.starters.ReadWriteToFile;
import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Person {

    private String name;
    private Integer age;
    private Gender gender; //{.... "gender" : 1}


    public Person(String name, Integer age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Person{ name: %s, age: %s, gender: %s",
                this.name,
                this.age,
                this.gender == null ? null : this.gender.getDescription());
    }
}
