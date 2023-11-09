package model.comparator;

import interfaces.UniversityComparator;
import model.University;
import org.apache.commons.lang3.StringUtils;

public class UniversityAddressComparator implements UniversityComparator {
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getAddress(),o2.getAddress());
    }
}
