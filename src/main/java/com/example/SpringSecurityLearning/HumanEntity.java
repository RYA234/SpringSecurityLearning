package com.example.SpringSecurityLearning;


import lombok.Getter;

import javax.persistence.Entity;


@Getter
public class HumanEntity {

    int age;
    String name;

    public HumanEntity(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
