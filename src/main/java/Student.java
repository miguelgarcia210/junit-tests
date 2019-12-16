import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String name;
    private long id;
    private ArrayList<Double> grades;

    public Student(String name, long id) {
        this.name = name.trim();
        this.id = id;
        grades = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    public ArrayList<Double> getGrades() {
        return this.grades;
    }

    public void addGrade(double grade) {
        this.grades.add(grade);
    }

    public int getGradeAverage() {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return (int) (sum / grades.size());
    }

    public static void main(String[] args) {
        Student student1 = new Student("miguel", 78737);
        System.out.println(student1.getGradeAverage());
    }
}
