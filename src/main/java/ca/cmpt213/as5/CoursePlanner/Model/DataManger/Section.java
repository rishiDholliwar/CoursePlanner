package ca.cmpt213.as5.CoursePlanner.Model.DataManger;

import java.util.ArrayList;

public class Section {

    private String section;
    private int totalEnrollmentCapacity;
    private int totalEnrollmentTotal;
    //private ArrayList<> departments = new ArrayList<>();

    public Section(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public int getTotalEnrollmentCapacity() {
        return totalEnrollmentCapacity;
    }

    public void accumalateTotalEnrollmentCapacity(int totalEnrollmentCapacity) {
        this.totalEnrollmentCapacity += totalEnrollmentCapacity;
    }

    public int getTotalEnrollmentTotal() {
        return totalEnrollmentTotal;
    }

    public void accumalateTotalEnrollmentTotal(int totalEnrollmentTotal) {
        this.totalEnrollmentTotal += totalEnrollmentTotal;
    }
}
