package ru.ilinykh.springcourse.models;

public class Person {
    private int personId;
    private String fullName;
    private int age;

    public Person() {
    }

    public Person(int id, String fullName, int age) {
        this.personId = id;
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
