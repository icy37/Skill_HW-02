package utils;

import model.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XLSXWriter {

    private static final Logger logger = Logger.getLogger(XLSXWriter.class.getName());

    private XLSXWriter() {
    }

    public static void writeXlsStatistics(List<Statistics> statisticsList,
                                          String filePath) {

        logger.log(Level.INFO, "Создание файла Excel запущено");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statisticsSheet = workbook.createSheet("Статистика");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        int rowNumber = 0;
        Row headerRow = statisticsSheet.createRow(rowNumber++);
        Cell profileCellHeader = headerRow.createCell(0);
        profileCellHeader.setCellValue("Профиль обучения");
        profileCellHeader.setCellStyle(headerStyle);
        Cell avgScoreCellHeader = headerRow.createCell(1);
        avgScoreCellHeader.setCellValue("Средний балл за экзамены по профилю");
        avgScoreCellHeader.setCellStyle(headerStyle);
        Cell numberOfStudentsCellHeader = headerRow.createCell(2);
        numberOfStudentsCellHeader.setCellValue("Количество студентов по профилю");
        numberOfStudentsCellHeader.setCellStyle(headerStyle);
        Cell numberOfUniversitiesCellHeader = headerRow.createCell(3);
        numberOfUniversitiesCellHeader.setCellValue("Количество университетов по профилю");
        numberOfUniversitiesCellHeader.setCellStyle(headerStyle);
        Cell universitiesCellHeader = headerRow.createCell(4);
        universitiesCellHeader.setCellValue("Университеты");
        universitiesCellHeader.setCellStyle(headerStyle);

        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle numberCellStyle = workbook.createCellStyle();
        short numberFormat = createHelper.createDataFormat().getFormat("0.00");
        numberCellStyle.setDataFormat(numberFormat);

        for (Statistics statistics : statisticsList) {
            Row dataRow = statisticsSheet.createRow(rowNumber++);
            Cell profileCell = dataRow.createCell(0);
            profileCell.setCellValue(statistics.getProfile().getProfileName());
            Cell avgScoreCell = dataRow.createCell(1);
            avgScoreCell.setCellValue(statistics.getAvgExamScore());
            avgScoreCell.setCellStyle(numberCellStyle);
            Cell numberOfStudentsCell = dataRow.createCell(2);
            numberOfStudentsCell.setCellValue(statistics.getNumberOfStudents());
            Cell numberOfUniversitiesCell = dataRow.createCell(3);
            numberOfUniversitiesCell.setCellValue(statistics.getNumberOfUniversities());
            Cell universitiesCell = dataRow.createCell(4);
            universitiesCell.setCellValue(statistics.getUniversityNames());
        }


        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Не удалось создать файл Excel", e);
            return;
        }
        logger.log(Level.INFO, "Файл статистики успешно создан " + filePath);
    }
}
