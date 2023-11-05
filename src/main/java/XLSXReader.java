import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XLSXReader {
    private XLSXReader() {
        // Приватный конструктор, чтобы предотвратить создание экземпляров класса.
    }

    public static List<Student> readStudentsFromInputStream(InputStream inputStream) throws IOException {
        List<Student> students = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheet("Студенты"); // Имя листа "Студенты"

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell firstCell = row.getCell(0); // Проверяем первую ячейку
                    if (firstCell != null && firstCell.getCellType() != CellType.BLANK) {
                        String universityId = getStringValue(firstCell);
                        String fullName = getStringValue(row.getCell(1));
                        int currentCourseNumber = (int) getNumericValue(row.getCell(2));
                        float avgExamScore = (float) getNumericValue(row.getCell(3));
                        String gender = getStringValue(row.getCell(4));
                        String address = getStringValue(row.getCell(5));
                        String admissionDate = getStringValue(row.getCell(6));
                        String phoneNumber = getStringValue(row.getCell(7));

                        Student student = new Student(fullName, universityId, currentCourseNumber, avgExamScore, gender, address, admissionDate, phoneNumber);
                        students.add(student);
                    }
                }
            }
        }
        return students;
    }


    public static List<University> readUniversitiesFromInputStream(InputStream inputStream) throws IOException {
        List<University> universities = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheet("Университеты"); // Имя листа "Университеты"

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell firstCell = row.getCell(0); // Проверяем первую ячейку
                    if (firstCell != null && firstCell.getCellType() != CellType.BLANK) {
                        String id = getStringValue(firstCell);
                        String fullName = getStringValue(row.getCell(1));
                        String shortName = getStringValue(row.getCell(2));
                        int yearOfFoundation = (int) getNumericValue(row.getCell(3));
                        String profileName = row.getCell(4).getStringCellValue();

                        // Преобразование текстового поля в элемент enum StudyProfile
                        StudyProfile profile = StudyProfile.valueOf(profileName);

                        String address = getStringValue(row.getCell(5));
                        String phoneNumber = getStringValue(row.getCell(6));
                        String email = getStringValue(row.getCell(7));
                        String website = getStringValue(row.getCell(8));

                        University university = new University(id, fullName, shortName, yearOfFoundation, profile, address, phoneNumber, email, website);
                        universities.add(university);
                    }
                }
            }
        }
        return universities;
    }


    private static String getStringValue(Cell cell) {
        return cell != null ? cell.getStringCellValue() : "";
    }

    private static double getNumericValue(Cell cell) {
        return cell != null ? cell.getNumericCellValue() : 0.0;
    }
}