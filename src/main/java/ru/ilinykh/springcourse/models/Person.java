package ru.ilinykh.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int personId;
    @NotEmpty(message = "Fullname should no be empty")
    @Size(min = 2, max = 60, message = "Fullname should be between 2 and 60 character")
    private String fullName;

    @Min(value = 10, message = "The age must be more than 10")
    private int age;

    public Person() {
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public int getId() {
        return personId;
    }

    public void setId(int id) {
        this.personId = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
