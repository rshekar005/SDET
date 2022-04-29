package com.qa.optional;

import org.testng.annotations.Test;

import java.util.Optional;

public class UsageInAPI {
    @Test
    public void test1() {

        /*
            Retrieving data which is null. Here it will throw null pointer exception
         */
        Person person = Person.builder().firstname("rajashekar").build();
      //  System.out.println(person.getFirstname().equalsIgnoreCase("abc"));

        /*
          Using Optional class to handle null pointer exception
         */

        Optional.ofNullable(person.getFirstname()).
                ifPresentOrElse(System.out::println, () -> System.out.println("Null value"));
    }
}
