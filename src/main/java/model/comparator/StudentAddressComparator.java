package model.comparator;

import interfaces.StudentComparator;
import model.Student;
import org.apache.commons.lang3.StringUtils;

public class StudentAddressComparator implements StudentComparator {
    @Override
    public int compare(Student student1, Student student2) {
        return StringUtils.compare(student1.getAddress(), student2.getAddress());
    }
}
