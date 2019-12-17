import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;

    @Before
    public void setUp() {
        student1 = new Student("miguel", 78737);
        student2 = new Student("Miguel", 78737);
        student3 = new Student("Bob", 91119);
        student4 = new Student("Hilbert", 10001);

        student2.addGrade(100); // 1 grade

        student3.addGrade(100); // many grades
        student3.addGrade(95);
        student3.addGrade(87);
        student3.addGrade(79);


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

    @Test
    public void confirmUpdatedGrade() {
        // verify value
        assertEquals(100, student2.getGrades().get(0), 0.0);
        // update value
        student2.updateGrade(1, 94);
        // verify update
        assertEquals(94, student2.getGrades().get(0), 0.0);

        assertEquals(100, student3.getGrades().get(0), 0.0);
        assertEquals(95, student3.getGrades().get(1), 0.0);
        assertEquals(87, student3.getGrades().get(2), 0.0);
        assertEquals(79, student3.getGrades().get(3), 0.0);
        student3.updateGrade(1, 99);
        student3.updateGrade(2, 98);
        student3.updateGrade(3, 97);
        student3.updateGrade(4, 96);
        assertNotEquals(100, student3.getGrades().get(0), 0.0); // verify grade change
        assertEquals(99, student3.getGrades().get(0), 0.0);
        assertEquals(98, student3.getGrades().get(1), 0.0);
        assertEquals(97, student3.getGrades().get(2), 0.0);
        assertEquals(96, student3.getGrades().get(3), 0.0);

        Student student4 = new Student("Hilbert", 00001);
        assertEquals(0, student4.getGrades().size());
    }

    @Test
    public void confirmDelete() {
        student2.addGrade(80);
        assertEquals(2, student2.getGrades().size());
        assertEquals(80, (double) student2.getGrades().get(1), 0.0);
        student2.deleteGrade(2);
        assertEquals(1, student2.getGrades().size());

        assertEquals(4, student3.getGrades().size());
        assertEquals(79, (double) student3.getGrades().get(3), 0.0);
        student3.deleteGrade(3);
        assertEquals(3, student3.getGrades().size());
    }
}
