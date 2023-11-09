package model.comparator;

import interfaces.StudentComparator;
import model.Student;

public class StudentAvgExamScoreComparator implements StudentComparator {
    @Override
    public int compare(Student student1, Student student2) {
        return Float.compare(student2.getAvgExamScore(), student1.getAvgExamScore());
    }
}
