import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import interfaces.StudentComparator;
import interfaces.UniversityComparator;
import utils.ComparatorUtil;
import utils.XLSXReader;
import model.Student;
import model.University;

import java.io.IOException;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        List<University> universities =
                XLSXReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);


        List<Student> students =
                XLSXReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}