import com.lukaklacar.binaryrepository.example.Student;
import com.lukaklacar.binaryrepository.example.Subject;
import com.lukaklacar.binaryrepository.repository.GenericRepository;
import com.lukaklacar.binaryrepository.settings.BinaryRepositorySettings;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;

public class GenericRepositoryTest {


    private BinaryRepositorySettings settings;

    @Before
    public void setup() {
        settings = BinaryRepositorySettings.builder().dataLocation("test").build();
    }

    @Test
    public void testRepository() {
        // Clear test directory
        File index = new File("test");
        String[] entries = index.list();
        for (String s : entries) {
            File currentFile = new File(index.getPath(), s);
            currentFile.delete();
        }


        Subject subject = new Subject("Programming");
        Student student = new Student("Luka", "Klacar", new CopyOnWriteArrayList<>(new Subject[]{subject}));

        GenericRepository<Student> repository = new GenericRepository<Student>(Student.class, settings);

        repository.add(student);
        List<Student> students = repository.all();
        Student firstStudent = students.get(0);

        assertEquals(firstStudent.getFirstName(), "Luka");
        assertEquals(firstStudent.getLastName(), "Klacar");
        assertEquals(firstStudent.getSubjects().get(0).getName(), "Programming");


    }
}
