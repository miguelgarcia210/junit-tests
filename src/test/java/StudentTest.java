import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private Student student1;

    @Before
    public void setUp() {
        student1 = new Student("miguel", 78737);
    }

    @Test
    public void confirmConstructor() {
        confirmNameGetter();
        confirmIdGetter();
        // confirm grades list is empty upon student instance
        assertEquals(0, student1.getGrades().size());
    }

    @Test
    public void confirmNameGetter() {
        // confirm student name is not null
        assertNotEquals("", student1.getName());
        // confirm student name does not start with a space
        assertNotEquals(" ", student1.getName().startsWith(" "));
    }

    @Test
    public void confirmIdGetter() {
        // confirm id is not <= 0
        assertTrue(student1.getId() > 0);
    }

    @Test
    public void confirmAddedGrade() {
        // add a grade to student1
        student1.addGrade(100);
        // confirm grade was added
        assertTrue(student1.getGrades().size() > 0);
    }

    @Test
    public void confirmGetAverage() {
        assertTrue(student1.getGradeAverage() >= 0 );
    }
}
