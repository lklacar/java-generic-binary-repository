import com.lukaklacar.binaryrepository.example.Student;
import com.lukaklacar.binaryrepository.example.Subject;
import com.lukaklacar.binaryrepository.query.Query;
import com.lukaklacar.binaryrepository.repository.GenericRepository;
import com.lukaklacar.binaryrepository.settings.BinaryRepositorySettings;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GenericRepositoryTest {

    private BinaryRepositorySettings settings;

    @Before
    public void setup() {
        settings = BinaryRepositorySettings.builder().dataLocation("test").build();

        // Clear test directory
        File index = new File("test");
        String[] entries = index.list();
        for (String s : entries) {
            File currentFile = new File(index.getPath(), s);
            currentFile.delete();
        }
    }

    @Test
    public void testRepository() {
        Subject subject = new Subject("Programming");
        Student student = new Student("Luka", "Klacar", new CopyOnWriteArrayList<>(new Subject[]{subject}));

        GenericRepository<Student> repository = new GenericRepository<Student>(Student.class, settings);

        repository.add(student);
        List<Student> students = repository.all();
        Student firstStudent = students.get(0);

        assertEquals(firstStudent.getFirstName(), "Luka");
        assertEquals(firstStudent.getLastName(), "Klacar");
        assertEquals(firstStudent.getSubjects().get(0).getName(), "Programming");

        List<Student> students1 = repository.find(new Query<Student>() {
            @Override
            public boolean isValid(Student model) {
                return model.getFirstName().startsWith("L");
            }
        });

        assertEquals(students1.get(0).getFirstName(), "Luka");
    }
}
