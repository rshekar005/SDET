package com.qa.customassertion;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class PersonAssert extends AbstractAssert<PersonAssert,Person> {
    private PersonAssert(Person person, Class<?> selfType) {
        super(person, selfType);
    }
    public static PersonAssert assertThat(Person person){
        return new PersonAssert(person,PersonAssert.class);
    }

    public PersonAssert hasName(){
        Assertions.assertThat(actual.getFirstname())
                .contains("Rajashekar")
                .withFailMessage("Name is mismatching");
        return this;
    }

    public PersonAssert hasListOfJobs(){
        Assertions.assertThat(actual.getJobs().size())
                .isEqualTo(2)
                .withFailMessage("Number of jobs are not equal");
        return this;
    }
}
