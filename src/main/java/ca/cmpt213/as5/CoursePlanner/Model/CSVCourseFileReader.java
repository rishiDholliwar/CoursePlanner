package ca.cmpt213.as5.CoursePlanner.Model;

import ca.cmpt213.as5.CoursePlanner.Model.DataManger.*;
import ca.cmpt213.as5.CoursePlanner.Model.Sorters.CatalogSorter;
import ca.cmpt213.as5.CoursePlanner.Model.Sorters.LocationSorter;
import ca.cmpt213.as5.CoursePlanner.Model.Sorters.OfferingSorter;
import ca.cmpt213.as5.CoursePlanner.Model.Sorters.SectionSorter;
import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;

public class CSVCourseFileReader {
    private static final String EMPTY_SPACE = "";
    private static final String DELIMITER = ",";
    private final String FIRST_MULTIPLE_INSTRUCTOR_SYMBOL = "\"";
    private final String LAST_MULTIPLE_INSTRUCTOR_SYMBOL = "\"";

    private final int SEMESTER = 0;
    private final int SUBJECT = 1;
    private final int CATALOG_NUMBER = 2;
    private final int LOCATION = 3;
    private final int ENROLMENT_CAPACITY = 4;
    private final int ENROLMENT_TOTAL = 5;
    private final int INSTRUCTOR = 6;
    private final int COMPONENT_CODE = 7;

    private String file = null;
    private DataManager dm = new DataManager();

    public CSVCourseFileReader(String file) {
        this.file = file;
    }

    public DataManager getCoursesFromCSVFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); //skip first line

            while ((line = br.readLine()) != null) {
                readLine(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        return dm;
    }

    public void print() {
        System.out.println();
        System.out.println();
        System.out.println("Printing CSV File:");
        for (Department dept : dm.getDepartments()) {
            System.out.print(dept.getDepartment() + " ");
            printCourse(dept);
        }
    }

    private void printCourse(Department dept) {
        for (Course course : dept.getCourses()) {
            System.out.println(course.getCatalogNumber());
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
            System.out.print("\t");
            System.out.print(offering.getOffering() + " in ");
            System.out.print(location.getLocation() + " by ");
            location.printInstructors();
            System.out.println();
            printSection(location);
        }
    }

    private void printSection(Location location) {
        for (Section section : location.getSections()) {
            System.out.print("\t\t");
            System.out.print("Type=" + section.getSection()
                    + ", "
                    + "Enrollment="
                    + section.getTotalEnrollmentTotal()
                    + "/" +
                    section.getTotalEnrollmentCapacity());
            System.out.println();
        }
    }

    private void readLine(String line) {
        CSVRow row = new CSVRow();
        ArrayList<String> instructors = new ArrayList<>();

        int column = 0;
        boolean isAddingMultipleInstructor = false;
        boolean isMultipleInstructors = false;

        for (String word : line.split(DELIMITER)) {
            if (isMultipleInstructorsColumn(word)) {
                isAddingMultipleInstructor = true;
                isMultipleInstructors = true;
                instructors.add(word.replaceAll(FIRST_MULTIPLE_INSTRUCTOR_SYMBOL, EMPTY_SPACE));
            } else if (isAddingMultipleInstructor) {
                if (word.endsWith(LAST_MULTIPLE_INSTRUCTOR_SYMBOL)) {
                    isAddingMultipleInstructor = false;
                    instructors.add(addLastMultipleInstructor(word));
                } else {
                    instructors.add(word);
                }
            } else {
                addNextColumn(word, column, row, instructors, isMultipleInstructors);
            }

            column++;
        }

        row.setInstructors(instructors);
        updateDataManager(row);
    }

    private boolean isMultipleInstructorsColumn(String word) {
        if (word.startsWith(FIRST_MULTIPLE_INSTRUCTOR_SYMBOL)) {
            return true;
        } else {
            return false;
        }
    }

    private String addLastMultipleInstructor(String word) {
        return StringUtils.trimWhitespace(word.replaceAll(LAST_MULTIPLE_INSTRUCTOR_SYMBOL, EMPTY_SPACE));
    }

    private void addNextColumn(String word, int column, CSVRow row, ArrayList<String> instructors
            , boolean isMultipleInstructors) {

        if (column == SEMESTER) {
            row.setSemester(Integer.parseInt(word));
        }

        if (column == SUBJECT) {
            row.setSubject(StringUtils.trimWhitespace(word));
        }

        if (column == CATALOG_NUMBER) {
            row.setCatalogNumber(StringUtils.trimWhitespace(word));
        }

        if (column == LOCATION) {
            row.setLocation(StringUtils.trimWhitespace(word));
        }

        if (column == ENROLMENT_CAPACITY) {
            row.setEnrollmentCapacity(Integer.parseInt(word));
        }

        if (column == ENROLMENT_TOTAL) {
            row.setEnrollmentTotal(Integer.parseInt(word));
        }

        if (column == INSTRUCTOR) {
            if (!isMultipleInstructors) {
                instructors.add(StringUtils.trimWhitespace(word));
            }
        }

        if (column == COMPONENT_CODE + (instructors.size() - 1)) {
            row.setComponentCode(StringUtils.trimWhitespace(word));
        }
    }


    private void updateDataManager(CSVRow row) {
        boolean isNewDept = true;

        for (Department dept : dm.getDepartments()) {
            if (dept.getDepartment().equals(row.getSubject())) {
                addCourse(dept, row);
                isNewDept = false;
                break;
            }
        }

        if (isNewDept) {
            Department department = new Department(row.getSubject());
            dm.addDepartment(department);
            addCourse(department, row);
        }
    }

    public void addCourse(Department dept, CSVRow row) {
        boolean isNewCourse = true;

        for (Course course : dept.getCourses()) {
            if (course.getCatalogNumber().equals(row.getCatalogNumber())) {
                addOffering(course, row);
                isNewCourse = false;
                java.util.Collections.sort(dept.getCourses(), new CatalogSorter());
                break;
            }
        }

        if (isNewCourse) {
            Course course = new Course(row.getCatalogNumber());
            dept.addCourses(course);
            addOffering(course, row);
            java.util.Collections.sort(dept.getCourses(), new CatalogSorter());
        }
    }

    private void addOffering(Course course, CSVRow row) {
        boolean isNewOffering = true;

        for (Offering offering : course.getOfferings()) {
            if (offering.getOffering() == row.getSemester()) {
                addLocation(offering, row);
                isNewOffering = false;
                java.util.Collections.sort(course.getOfferings(), new OfferingSorter());
                break;
            }
        }

        if (isNewOffering) {
            Offering offering = new Offering(row.getSemester());
            course.addOffering(offering);
            addLocation(offering, row);
            java.util.Collections.sort(course.getOfferings(), new OfferingSorter());
        }

    }

    private void addLocation(Offering offering, CSVRow row) {
        boolean isNewLocation = true;

        for (Location location : offering.getLocations()) {
            if (location.getLocation().equals(row.getLocation())) {

                addSection(location, row);
                isNewLocation = false;
                java.util.Collections.sort(offering.getLocations(), new LocationSorter());
                break;
            }
        }

        if (isNewLocation) {
            Location location = new Location(row.getLocation());
            offering.addLocation(location);
            addSection(location, row);
            java.util.Collections.sort(offering.getLocations(), new LocationSorter());
        }

    }

    private void addSection(Location location, CSVRow row) {
        location.addInstructors(row.getInstructors());
        boolean isNewSection = true;

        for (Section section : location.getSections()) {
            if (section.getSection().equals(row.getComponentCode())) {
                section.accumalateTotalEnrollmentCapacity(row.getEnrollmentCapacity());
                section.accumalateTotalEnrollmentTotal(row.getEnrollmentTotal());
                isNewSection = false;
                java.util.Collections.sort(location.getSections(), new SectionSorter());
                break;
            }
        }

        if (isNewSection) {
            Section section = new Section(row.getComponentCode());
            location.addSection(section);
            section.accumalateTotalEnrollmentCapacity(row.getEnrollmentCapacity());
            section.accumalateTotalEnrollmentTotal(row.getEnrollmentTotal());
            java.util.Collections.sort(location.getSections(), new SectionSorter());
        }

    }
}
