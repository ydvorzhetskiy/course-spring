package edu.spring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private final String tabNum;
    private final String fullName;
    private final String position;

    public Employee(String tabNum, String fullName, String position) {
        this.tabNum = tabNum;
        this.fullName = fullName;
        this.position = position;
    }
}
