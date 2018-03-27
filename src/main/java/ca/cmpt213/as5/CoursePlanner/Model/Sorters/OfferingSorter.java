package ca.cmpt213.as5.CoursePlanner.Model.Sorters;

import ca.cmpt213.as5.CoursePlanner.Model.DataManger.Offering;
import ca.cmpt213.as5.CoursePlanner.Model.SFUClass;

import java.util.Comparator;

public class OfferingSorter implements Comparator<Offering> {


    @Override
    public int compare(Offering o1, Offering o2) {
        return o1.getOffering() - o2.getOffering();
    }
}
