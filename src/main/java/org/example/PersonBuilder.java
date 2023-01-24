package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String city;

    public PersonBuilder() {

    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }
    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (age < 0) {
            throw new IllegalArgumentException("Не допустимый возраст");
        } else if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Не хватает обязательных полей (имя и/или фамилия)");
        }
        return new Person(name, surname, age, city);
    }
}
