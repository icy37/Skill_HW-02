import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import interfaces.StudentComparator;
import interfaces.UniversityComparator;
import model.Statistics;
import model.XMLModels;
import utils.*;
import model.Student;
import model.University;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import static java.util.logging.Level.INFO;

public class MainApplication {

    private static final Logger logger = Logger.getLogger(MainApplication.class.getName());

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(
                    MainApplication.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Не удалось настроить конфигурацию логирования: " + e.toString());
        }

        logger.log(INFO, "Приложение запущено, Логирование настроено");

        List<University> universities =
                XLSXReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.sort(universityComparator);

        List<Student> students =
                XLSXReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XLSXWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");

        XMLModels xmlModels = new XMLModels()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XMLWriter.generateXmlReq(xmlModels);
        JsonWriter.writeJsonReq(xmlModels);

        logger.log(INFO, "Приложение закрыто");
    }
}