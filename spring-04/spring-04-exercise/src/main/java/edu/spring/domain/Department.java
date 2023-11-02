package edu.spring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Department {
    private final int id;
    private final String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
