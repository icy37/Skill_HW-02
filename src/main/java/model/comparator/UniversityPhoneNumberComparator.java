package model.comparator;

import interfaces.UniversityComparator;
import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityPhoneNumberComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getPhoneNumber(), o2.getPhoneNumber());
    }
}
