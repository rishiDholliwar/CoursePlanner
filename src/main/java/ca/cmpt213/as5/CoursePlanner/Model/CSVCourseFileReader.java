package ca.cmpt213.as5.CoursePlanner.Model;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVCourseFileReader {
    private static final String EMPTY_SPACE = "";
    private static final String SINGLE_SPACE = " ";
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
    private ArrayList<SFUCourse> sfuCourses = new ArrayList<>();

    public CSVCourseFileReader(String file) {
        this.file = file;
    }

    public List<SFUCourse> getCoursesFromCSVFile() throws IOException {
        System.out.println("----------------------------------------");
        System.out.println("Printing Classes:");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); //skip first line

            while ((line = br.readLine()) != null) {
                readLine(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        return sfuCourses;
    }

    public void printCourses() {
        System.out.println();
        System.out.println();
        System.out.println("Printing Courses:");
        for (SFUCourse course : sfuCourses) {

            System.out.println(course.getSubject() + SINGLE_SPACE + course.getCatalogNumber());

            for (SFUClass sfu_class : course.getSfu_classes()) {
                System.out.print("\t");
                sfu_class.printClass();
                System.out.println();
            }

            System.out.println();

        }
    }

    private void readLine(String line) {
        SFUClass sfuClass = new SFUClass();
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
                addNextColumn(word, column, sfuClass, instructors, isMultipleInstructors);
            }

            column++;
        }

        sfuClass.setInstructors(instructors);

        sfuClass.printClass();
        System.out.println();
        updateCourses(sfuClass);

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

    private void addNextColumn(String word, int column, SFUClass sfuClass, ArrayList<String> instructors
            , boolean isMultipleInstructors) {

        if (column == SEMESTER) {
            sfuClass.setSemester(Integer.parseInt(word));
        }

        if (column == SUBJECT) {
            sfuClass.setSubject(StringUtils.trimWhitespace(word));
        }

        if (column == CATALOG_NUMBER) {
            sfuClass.setCatalogNumber(StringUtils.trimWhitespace(word));
        }

        if (column == LOCATION) {
            sfuClass.setLocation(StringUtils.trimWhitespace(word));
        }

        if (column == ENROLMENT_CAPACITY) {
            sfuClass.setEnrollmentCapacity(Integer.parseInt(word));
        }

        if (column == ENROLMENT_TOTAL) {
            sfuClass.setEnrollmentTotal(Integer.parseInt(word));
        }

        if (column == INSTRUCTOR) {
            if (!isMultipleInstructors) {
                instructors.add(StringUtils.trimWhitespace(word));
            }
        }

        if (column == COMPONENT_CODE + (instructors.size() - 1)) {
            sfuClass.setComponentCode(StringUtils.trimWhitespace(word));
        }
    }

    private void updateCourses(SFUClass sfu_class) {

        boolean isNewCourse = true;

        for (SFUCourse course : sfuCourses) {
            if (course.getSubject().equals(sfu_class.getSubject())
                    && course.getCatalogNumber().equals(sfu_class.getCatalogNumber())) {
                course.addSfu_classes(sfu_class);
                isNewCourse = false;
                break;
            }
        }

        if (isNewCourse) {
            SFUCourse sfu_course = new SFUCourse(sfu_class.getSubject(), sfu_class.getCatalogNumber());
            sfu_course.addSfu_classes(sfu_class);
            sfuCourses.add(sfu_course);
        }

    }
}
