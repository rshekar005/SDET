package com.qa.templates;


import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.github.javafaker.Faker;
import com.qa.fixtures.Address;
import com.qa.fixtures.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeTemplate implements TemplateLoader {

    public Object[] getFirstName() {
        Faker faker = new Faker();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(faker.name().firstName());
        }
        return list.toArray();
    }

    @Override
    public void load() {
        //Creating a template Using FixturesLibrary with valid values
        Fixture.of(Employee.class)
                .addTemplate("valid", new Rule() {
                    {
                        add("id", random(Integer.class, range(100, 1000)));
                        add("fname", random("Rajashekar", "Manoj", "Amar", "Sai"));
                        add("isFTE", random(true, false));
                        add("roles", uniqueRandom(Arrays.asList("functional", "Non Functional"), Arrays.asList("Manual testing", "Automation testing")));
                        add("address", uniqueRandom(new Address("Hyderabad","Telangana"), new Address("Amalapuram","AP")));
                    }
                });

        Fixture.of(Employee.class)
                .addTemplate("inValid", new Rule() {
                    {
                        add("id", 887);
                        add("fname", random(getFirstName()));
                        add("isFTE", random(true, false));
                        add("roles", uniqueRandom(Arrays.asList("functional", "Non Functional"), Arrays.asList("Manual testing", "Automation testing")));
                        add("address", uniqueRandom(new Address("Hyderabad","Telangana"), new Address("Amalapuram","AP")));
                    }
                });

        Fixture.of(Employee.class)
                .addTemplate("inValidFirstName").inherits("valid", new Rule() {
                    {
                        add("fname", random("", null, "Amar&*^&^&&122"));
                    }
                });
    }
}
