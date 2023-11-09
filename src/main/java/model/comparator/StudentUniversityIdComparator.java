package model.comparator;

import interfaces.StudentComparator;
import model.Student;


public class StudentUniversityIdComparator implements StudentComparator {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getUniversityId().compareTo(student2.getUniversityId());
    }
}
