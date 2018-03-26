package ca.cmpt213.as5.CoursePlanner.Model.Sorters;

import ca.cmpt213.as5.CoursePlanner.Model.SFUClass;

import java.util.Comparator;

public class EnrollementTotalSorter implements Comparator<SFUClass> {

    @Override
    public int compare(SFUClass o1, SFUClass o2) {
        return o2.getEnrollmentTotal()- o1.getEnrollmentTotal();
    }
}
