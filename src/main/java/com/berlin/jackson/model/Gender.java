package com.berlin.jackson.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

/**
 * name -> string
 * ordinal -> integer
 */
public enum Gender {
    /*ordinal 0*/ FEMALE(2, "Female"),
    /*ordinal 1*/ RATHER_NOT_TO_TELL(3, "Rather not to tell"),
    /*ordinal 2*/ MALE(1, "Male")
    ;

    private Integer id;
    private String description;

    Gender(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    @JsonValue
    public Integer getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }


    @JsonCreator
    public static Gender getById(Integer id) {
        if (id == null) {
            return null;
        }

        /*for (Gender gender : Gender.values()) {
            if (gender.getId().equals(id)) {
                return gender;
            }
        }

        return null;
        */

        return Arrays.stream(Gender.values())
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
