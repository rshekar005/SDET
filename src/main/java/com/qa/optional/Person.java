package com.qa.optional;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String firstname;
    private List<String> jobs;
    private Favfoods favfoods;
}
