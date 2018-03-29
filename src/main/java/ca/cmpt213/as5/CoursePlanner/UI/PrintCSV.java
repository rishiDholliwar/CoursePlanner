package ca.cmpt213.as5.CoursePlanner.UI;

import ca.cmpt213.as5.CoursePlanner.Model.DataManger.*;

/**
 * Used to print a formatted CSV file
 */
public class PrintCSV {
    private String file = null;
    private DataManager dm;

    public PrintCSV(String file, DataManager dm) {
        this.file = file;
        this.dm = dm;
    }

    public void print() {
        System.out.println();
        System.out.println();
        System.out.println("Model Dump from '" + file + "' file");
        System.out.println();
        for (Department dept : dm.getDepartments()) {
            printCourse(dept);
        }
    }

    private void printCourse(Department dept) {
        for (Course course : dept.getCourses()) {
            System.out.println(dept.getDepartment() + " " + course.getCatalogNumber());
            printOffering(course);
        }
    }

    private void printOffering(Course course) {
        for (Offering offering : course.getOfferings()) {
            printLocationAndTeacher(offering);
        }
    }

    private void printLocationAndTeacher(Offering offering) {
        for (Location location : offering.getLocations()) {
            System.out.print("\t\t");
            System.out.print(offering.getOffering() + " in ");
            System.out.print(location.getLocation() + " by ");
            location.printInstructors();
            System.out.println();
            printSection(location);
        }
    }

    private void printSection(Location location) {
        for (Section section : location.getSections()) {
            System.out.print("\t\t\t");
            System.out.print("Type=" + section.getSection()
                    + ", "
                    + "Enrollment="
                    + section.getTotalEnrollmentTotal()
                    + "/" +
                    section.getTotalEnrollmentCapacity());
            System.out.println();
        }
    }
}
