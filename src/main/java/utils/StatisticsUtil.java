package utils;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatisticsUtil {

    private static final Logger logger = Logger.getLogger(StatisticsUtil.class.getName());

    private StatisticsUtil() {
    }

    public static List<Statistics> createStatistics(List<Student> students,
                                                    List<University> universities) {

        logger.log(Level.INFO, "Модуль статистики запущен");

        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setProfile(profile);

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setNumberOfUniversities(profileUniversityIds.size());
            statistics.setUniversityNames(StringUtils.EMPTY);
            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityNames(
                            statistics.getUniversityNames() + fullNameUniversity + ";"));
            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setNumberOfStudents(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
            System.out.println(statistics.getAvgExamScore());
        });

        logger.log(Level.INFO,
                String.format("Модуль статистики завершил работу %s количество объектов", statisticsList.size()));

        return statisticsList;
    }
}
