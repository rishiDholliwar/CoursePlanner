package ca.cmpt213.as5.CoursePlanner.Model.DataManger;

import java.util.ArrayList;

/**
 * The course “number”. May be a number like 213, or a string like 105W or 1XX
 */
public class Course implements Comparable<Course>{
    private String catalogNumber;
    private ArrayList<Offering> offerings = new ArrayList<>();

    public Course(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void addOffering(Offering offering){
        this.offerings.add(offering);
    }

    public ArrayList<Offering> getOfferings() {
        return offerings;
    }

    @Override
    public int compareTo(Course o) {
        return this.getCatalogNumber().compareTo(o.getCatalogNumber());
    }
}
