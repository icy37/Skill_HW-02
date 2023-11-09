package model.comparator;

import interfaces.UniversityComparator;
import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityEmailComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getEmail(), o2.getEmail());
    }
}
