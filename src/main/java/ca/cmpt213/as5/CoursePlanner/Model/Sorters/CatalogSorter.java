package ca.cmpt213.as5.CoursePlanner.Model.Sorters;

import ca.cmpt213.as5.CoursePlanner.Model.DataManger.Course;

import java.util.Comparator;

public class CatalogSorter implements Comparator<Course> {


    @Override
    public int compare(Course o1, Course o2) {
        return o1.getCatalogNumber().compareTo(o2.getCatalogNumber());
    }
}
