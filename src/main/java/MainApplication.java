import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        try (InputStream inputStream = MainApplication.class.getResourceAsStream("/universityInfo.xlsx")) {
            if (inputStream != null) {
                Path tempFile = Files.createTempFile("universityInfo", ".xlsx");
                Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

                InputStream studentsInputStream = Files.newInputStream(tempFile);
                InputStream universitiesInputStream = Files.newInputStream(tempFile);

                List<Student> students = XLSXReader.readStudentsFromInputStream(studentsInputStream);
                List<University> universities = XLSXReader.readUniversitiesFromInputStream(universitiesInputStream);

                // Вывод полученных элементов в консоль
                System.out.println("Студенты:");
                for (Student student : students) {
                    System.out.println(student);
                }

                System.out.println("\nУниверситеты:");
                for (University university : universities) {
                    System.out.println(university);
                }
            } else {
                System.out.println("Файл universityInfo.xlsx не найден.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Обработка исключения IOException
        }
    }
}