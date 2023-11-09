package model.comparator;

import interfaces.StudentComparator;
import model.Student;


public class StudentCourseNumberComparator implements StudentComparator {
    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student2.getCurrentCourseNumber(), student1.getCurrentCourseNumber());
    }
}
