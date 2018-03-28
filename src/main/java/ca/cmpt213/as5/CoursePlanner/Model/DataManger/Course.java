package ca.cmpt213.as5.CoursePlanner.Model.DataManger;

import java.util.ArrayList;

public class Course {
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
}
