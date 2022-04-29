package com.qa.lombok;

public class Runner {
    public static void main(String[] args) {
        Student student= new Student();
        student.setFirstname("Raja");
        student.setLastname("Shekar");
        System.out.println(student);

        Student student1=Student.builder().firstname("Raja").lastname("Shekar").build();
        System.out.println(student1);
    }
}
