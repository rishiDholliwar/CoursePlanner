package ca.cmpt213.as5.CoursePlanner.Model.Sorters;

import ca.cmpt213.as5.CoursePlanner.Model.DataManger.Location;

import java.util.Comparator;

public class LocationSorter implements Comparator<Location> {

    @Override
    public int compare(Location o1, Location o2) {
        return o1.getLocation().compareTo(o2.getLocation());
    }
}
