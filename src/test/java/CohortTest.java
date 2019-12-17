import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CohortTest {

    Cohort deimos;
    Cohort ceres;
    Student trent;
    Student bob;
    Student terrel;

    @Before
    public void setUp() {
        deimos = new Cohort();
        ceres = new Cohort();
        trent = new Student(78737,"Trent");
        bob = new Student(91119,"Bob");
        terrel = new Student(89898, "Terrel");
    }

    @Test
    public void testAddStudents() {
        assertEquals(0, deimos.getStudents().size());
        deimos.addStudent(trent);
        assertEquals(1, deimos.getStudents().size());
        deimos.addStudent(trent);
        assertEquals(2, deimos.getStudents().size());
    }

    @Test
    public void testGetStudentsList() {
        assertEquals(0, deimos.getStudents().size());
        deimos.addStudent(trent);
        deimos.addStudent(bob);
        assertEquals(2, deimos.getStudents().size());
    }

    @Test
    public void testGetAverage() {
        assertEquals(0, deimos.getStudents().size());
        deimos.addStudent(trent);
        deimos.addStudent(bob);
        deimos.addStudent(new Student(89898, "Terrel"));
        assertEquals(3, deimos.getStudents().size());
        trent.addGrade(100);
        bob.addGrade(50);
        deimos.getStudents().get(2).addGrade(75);
        assertEquals(75, deimos.getCohortAverage(), 0.0);
    }
}
