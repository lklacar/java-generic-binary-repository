package com.lukaklacar.binaryrepository;

import com.lukaklacar.binaryrepository.example.Student;
import com.lukaklacar.binaryrepository.example.Subject;
import com.lukaklacar.binaryrepository.repository.GenericRepository;
import com.lukaklacar.binaryrepository.settings.BinaryRepositorySettings;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    public static void main(String[] args) {

        BinaryRepositorySettings settings = BinaryRepositorySettings
                .builder()
                .dataLocation("data")
                .build();

        Subject subject = new Subject("Programming");
        Student student = new Student("Luka", "Klacar", new CopyOnWriteArrayList<>(new Subject[]{subject}));

        GenericRepository<Student> repository = new GenericRepository<Student>(Student.class, settings);

        System.out.println(repository.all());
        repository.add(student);
        System.out.println(repository.all());

    }
}