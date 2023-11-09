package utils;

import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import interfaces.StudentComparator;
import interfaces.UniversityComparator;
import model.comparator.*;

public class ComparatorUtil {

    private ComparatorUtil() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {
        switch (studentComparatorType) {
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case FULL_NAME:
                return new StudentFullNameComparator();
            case CURRENT_COURSE_NUMBER:
                return new StudentCourseNumberComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            case GENDER:
                return new StudentGenderComparator();
            case ADDRESS:
                return new StudentAddressComparator();
            case ADMISSION_DATE:
                return new StudentAdmissionDateComparator();
            case PHONE_NUMBER:
                return new StudentPhoneNumberComparator();
            default:
                return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType) {
        switch (universityComparatorType) {
            case ID:
                return new UniversityIdComparator();
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case PROFILE:
                return new UniversityProfileComparator();
            case YEAR:
                return new UniversityYearComparator();
            case ADDRESS:
                return new UniversityAddressComparator();
            case PHONE_NUMBER:
                return new UniversityPhoneNumberComparator();
            case EMAIL:
                return new UniversityEmailComparator();
            case WEBSITE:
                return new UniversityWebsiteComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
}

