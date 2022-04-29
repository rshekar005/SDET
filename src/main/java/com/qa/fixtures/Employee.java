package com.qa.fixtures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String fname;
    private boolean isFTE;
    private Address address;
    private List<String> roles;
}
