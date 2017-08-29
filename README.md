# Generic Binary Repository for Java

## Usage


- Create settings
```java
BinaryRepositorySettings settings = BinaryRepositorySettings
                                   .builder()
                                   .dataLocation("test")
                                   .build();
```

- Create models

```java
public class Subject extends AbstractModel {
    private String name;
}

public class Student extends AbstractModel {
    private String firstName, lastName;
    private CopyOnWriteArrayList<Subject> subjects;
}
```

- Save entity
```java
GenericRepository<Student> repository = new GenericRepository<Student>(Student.class, settings);
repository.add(student);
```
- Fetch all entities
```java
GenericRepository<Student> repository = new GenericRepository<Student>(Student.class, settings);
List<Student> allStudents = repository.all();
```

- Search for entities
```java
List<Student> students1 = repository.find(new Query<Student>() {
            @Override
            public boolean isValid(Student model) {
                return model.getFirstName().startsWith("L");
            }
        });
```