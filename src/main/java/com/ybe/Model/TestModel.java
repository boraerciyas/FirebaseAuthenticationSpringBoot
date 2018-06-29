package com.ybe.Model;

import java.util.Map;

public class TestModel {

    private String name, surname, dept;
    private Map<String, TestModelHobby> hobby;
    private Integer age;

    public TestModel() {
    }

    public TestModel(String name, String surname, String dept, Map<String, TestModelHobby> hobby, Integer age) {
        this.name = name;
        this.surname = surname;
        this.dept = dept;
        this.hobby = hobby;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Map<String, TestModelHobby> getHobby() {
        return hobby;
    }

    public void setHobby(Map<String, TestModelHobby> hobby) {
        this.hobby = hobby;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dept='" + dept + '\'' +
                ", hobby=" + hobby +
                ", age=" + age +
                '}';
    }
}
