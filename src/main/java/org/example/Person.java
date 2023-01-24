package org.example;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public Person(String name, String surname, String city) {
        this.name = name;
        this.surname = surname;
        this.city = city;
    }
    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public boolean hasAge() {
        return age >= 0 ? true : false;
    }
    public boolean hasAddress() {
        return city != null ? true : false;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }
    public String getAddress() {
        return hasAddress() ? city : "не задан";
    }

    public void setAddress(String city) {
        this.city = city;
    }
    public void happyBirthday() {
        if (hasAge()) {
            age += 1;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAge(0).setAddress(this.city);
    }

    @Override
    public String toString() {
        if (hasAge()) {
            return name + " " + surname +
                    " (возраст: " + age + ", город: " + getAddress() + ")";
        } else {
            return name + " " + surname +
                    "(город: " + getAddress() + ")";
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode() + 47 * surname.hashCode() + 71 * getAge().hashCode() + getAddress().hashCode();
    }
}
