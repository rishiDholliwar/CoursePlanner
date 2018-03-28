package ca.cmpt213.as5.CoursePlanner.Model.Sorters;


import ca.cmpt213.as5.CoursePlanner.Model.DataManger.Section;

import java.util.Comparator;

public class SectionSorter implements Comparator<Section> {

    @Override
    public int compare(Section o1, Section o2) {
        return o1.getSection().compareTo(o2.getSection());
    }
}
