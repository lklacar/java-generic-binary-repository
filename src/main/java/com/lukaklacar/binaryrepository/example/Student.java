package com.lukaklacar.binaryrepository.example;

import com.lukaklacar.binaryrepository.model.AbstractModel;

import java.util.concurrent.CopyOnWriteArrayList;

public class Student extends AbstractModel {

    private String firstName, lastName;

    private CopyOnWriteArrayList<Subject> subjects;

    public Student(String firstName, String lastName, CopyOnWriteArrayList<Subject> subjects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CopyOnWriteArrayList<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
