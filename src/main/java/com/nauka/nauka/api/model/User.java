package com.nauka.nauka.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    private String email;
}
