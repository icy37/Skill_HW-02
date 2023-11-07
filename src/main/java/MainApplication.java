import lib.XLSXReader;
import model.Student;
import model.University;

import java.io.IOException;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        List<University> universities =
                XLSXReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        for(University university : universities) {
            System.out.println(university);
        }

        List<Student> students =
                XLSXReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        for(Student student : students) {
            System.out.println(student);
        }
    }
}