package ca.cmpt213.as5.CoursePlanner.Model;

import java.util.Comparator;

public class SemesterSorter implements Comparator<SFUClass> {

    @Override
    public int compare(SFUClass o1, SFUClass o2) {
        return o1.getSemester()- o2.getSemester();
    }
}
