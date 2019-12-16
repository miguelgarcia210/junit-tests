import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Before
    public void setUp() {
        Student student1 = new Student();
    }

    @Test
    public void confirmConstructor() {
        // confirm name is not null
        assertNotNull(student1.name);
        // confirm name does not start with a space
        assertNotEquals(" ", student.name.startsWith(" "));
        // confirm id is not null
        assertNotNull(student1.id);
        // confirm grades list is empty
        assertEquals(0, student1.grades.size());
    }
}
