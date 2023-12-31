package utils;

import enums.StudyProfile;
import model.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XLSXReader {

    private static final Logger logger = Logger.getLogger(XLSXReader.class.getName());

    private XLSXReader() {
        // Приватный конструктор, чтобы предотвратить создание экземпляров класса.
    }

    public static List<Student> readXlsStudents(String filePath) {
        List<Student> students = new ArrayList<>();

        try (
                FileInputStream inputStream = new FileInputStream(filePath);
                XSSFWorkbook workbook = new XSSFWorkbook(inputStream)
        ) {
            logger.log(Level.INFO, "Чтение информации по студентам из файла Excel" + filePath);
            XSSFSheet sheet = workbook.getSheet("Студенты");
            Iterator<Row> rows = sheet.iterator();
            rows.next(); // Пропускаем заголовок

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                if (isEmptyRow(currentRow)) {
                    // Пропускаем пустую строку
                    continue;
                }
                Student student = new Student(
                        currentRow.getCell(0).getStringCellValue(),
                        currentRow.getCell(1).getStringCellValue(),
                        (int) currentRow.getCell(2).getNumericCellValue(),
                        (float) currentRow.getCell(3).getNumericCellValue(),
                        currentRow.getCell(4).getStringCellValue(),
                        currentRow.getCell(5).getStringCellValue(),
                        currentRow.getCell(6).getStringCellValue(),
                        currentRow.getCell(7).getStringCellValue()
                );
                students.add(student);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка в чтение файла Excel - студенты", e);
            return students;
        }

        logger.log(Level.INFO, "Чтение информации по студентам из файла Excel выполнено успешно");
        return students;
    }


    public static List<University> readXlsUniversities(String filePath) {
        List<University> universities = new ArrayList<>();

        try (
                FileInputStream inputStream = new FileInputStream(filePath);
                XSSFWorkbook workbook = new XSSFWorkbook(inputStream)
        ) {
            logger.log(Level.INFO, "Чтение информации по университетам из файла Excel" + filePath);
            XSSFSheet sheet = workbook.getSheet("Университеты");
            Iterator<Row> rows = sheet.iterator();
            rows.next(); // Пропускаем заголовок

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                if (isEmptyRow(currentRow)) {
                    // Пропускаем пустую строку
                    continue;
                }
                University university = new University(
                        currentRow.getCell(0).getStringCellValue(),
                        currentRow.getCell(1).getStringCellValue(),
                        currentRow.getCell(2).getStringCellValue(),
                        (int) currentRow.getCell(3).getNumericCellValue(),
                        StudyProfile.valueOf(currentRow.getCell(4).getStringCellValue()),
                        currentRow.getCell(5).getStringCellValue(),
                        currentRow.getCell(6).getStringCellValue(),
                        currentRow.getCell(7).getStringCellValue(),
                        currentRow.getCell(8).getStringCellValue()
                );
                universities.add(university);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка в чтение файла Excel - университеты", e);
            return universities;
        }

        logger.log(Level.INFO, "Чтение информации по университетам из файла Excel выполнено успешно");
        return universities;
    }

    private static boolean isEmptyRow(Row row) {
        for (Cell cell : row) {
            if (cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

}