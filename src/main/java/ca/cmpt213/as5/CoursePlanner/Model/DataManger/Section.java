package ca.cmpt213.as5.CoursePlanner.Model.DataManger;

/**
 * Holds the tpye of section for a course and also
 * has the total enrollment capacity and total
 */
public class Section implements Comparable<Section> {
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

    @Override
    public int compareTo(Section o) {
        return this.getSection().compareTo(o.getSection());
    }
}
