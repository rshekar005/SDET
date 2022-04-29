package com.qa.Fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import com.qa.fixtures.Address;
import com.qa.fixtures.Employee;

import java.util.Arrays;
import java.util.List;

public class RunnerWithFixtures {
    public static void main(String[] args) {

        //Traditional Way
        Employee employee = new Employee(1, "Rajashekar", true,
                new Address("Hyderabad", "Telangana"),
                Arrays.asList("Manual Testing", "Automation Testing"));
        System.out.println("*********  Traditional Way ************");
        System.out.println(employee);

        //Creating a template Using FixturesLibrary with valid values
        Fixture.of(Employee.class)
                .addTemplate("valid", new Rule() {
                    {
                        add("id", random(Integer.class, range(100, 1000)));
                        add("fname", random("Rajashekar", "Manoj", "Amar", "Sai"));
                        add("isFTE", random(true, false));
                        add("roles", uniqueRandom(Arrays.asList("functional", "Non Functional"), Arrays.asList("Manual testing", "Automation testing")));
                        add("address", uniqueRandom(new Address("Hyderabad", "telangana"), new Address("Amalapuram", "AP")));
                    }
                });

        System.out.println("********* Single Valid Employee Object Using Fixtures ************");
        Employee employee1=Fixture.from(Employee.class).gimme("valid");
        System.out.println(employee1);

        System.out.println("********* 10 Valid Employee Object Using Fixtures ************");
        List<Employee> employeeList=Fixture.from(Employee.class).gimme(10,"valid");
        employeeList.forEach(System.out::println);
    }
}
