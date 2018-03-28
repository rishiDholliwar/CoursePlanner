package ca.cmpt213.as5.CoursePlanner.Model.Sorters;

import java.util.Comparator;

public class EnrollementCapacitySorter implements Comparator<SFUClass> {
    @Override
    public int compare(SFUClass o1, SFUClass o2) {
        return o2.getEnrollmentCapacity()- o1.getEnrollmentCapacity();
    }
}
