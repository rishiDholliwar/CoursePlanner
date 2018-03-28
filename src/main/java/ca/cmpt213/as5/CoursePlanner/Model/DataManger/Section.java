package ca.cmpt213.as5.CoursePlanner.Model.DataManger;


public class Section {
    private String section;
    private int totalEnrollmentCapacity;
    private int totalEnrollmentTotal;

    public Section(String section) {
        this.section = section;
    }

    public String getSection() {
        return section;
    }

    public int getTotalEnrollmentCapacity() {
        return totalEnrollmentCapacity;
    }

    public void accumulateEnrollmentCapacity(int totalEnrollmentCapacity) {
        this.totalEnrollmentCapacity += totalEnrollmentCapacity;
    }

    public int getTotalEnrollmentTotal() {
        return totalEnrollmentTotal;
    }

    public void accumulateEnrollmentTotal(int totalEnrollmentTotal) {
        this.totalEnrollmentTotal += totalEnrollmentTotal;
    }
}
