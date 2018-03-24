package ca.cmpt213.as5.CoursePlanner.Model;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.util.ArrayList;


public class CSV_Reader {

    private final int SEMESTER = 0;
    private final int SUBJECT = 1;
    private final int CATALOG_NUMBER = 2;
    private final int LOCATION = 3;
    private final int ENROLMENT_CAPACITY = 4;
    private final int ENROLMENT_TOTAL = 5;
    private final int INSTRUCTOR = 6;
    private final int COMPONENT_CODE = 7;


    public void readData() throws IOException {

        String file = "data/test_data_2016.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); //skip first line
            while ((line = br.readLine()) != null) {
                readLine(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public void readLine(String line) {
        ArrayList<String> instructors = new ArrayList<>();
        SFU_Class sfu_class = new SFU_Class();
        int i = 0;
        boolean isAddingInstructor = false;
        boolean isMultipleInstructors = false;

        for (String word : line.split(",")) {

            if (word.startsWith("\"")) {
                isAddingInstructor = true;
                isMultipleInstructors = true;
                instructors.add(word.substring(1));

            } else if (isAddingInstructor) {
                if (word.endsWith("\"")) {
                    isAddingInstructor = false;
                    instructors.add(StringUtils.trimWhitespace(word.replaceAll(" ", "").replaceAll("\"", "")));
                } else {
                    instructors.add(word);
                }
            } else {

                if (i == SEMESTER) {
                    sfu_class.setSemester(Integer.parseInt(word));
                }

                if (i == SUBJECT) {
                    sfu_class.setSubject(word);
                }

                if (i == CATALOG_NUMBER) {
                    sfu_class.setCatalogNumber(StringUtils.trimWhitespace(word));
                }

                if (i == LOCATION) {
                    sfu_class.setLocation(word);
                }

                if (i == ENROLMENT_CAPACITY) {
                    sfu_class.setEnrolementCapacity(Integer.parseInt(word));
                }

                if (i == ENROLMENT_TOTAL) {
                    sfu_class.setEnrolementTotal(Integer.parseInt(word));
                }

                if (i == INSTRUCTOR) {
                    if (!isMultipleInstructors) {
                        instructors.add(StringUtils.trimWhitespace(word));
                    }
                }

                if (i == COMPONENT_CODE + (instructors.size() - 1)) {
                    sfu_class.setComponentCode(StringUtils.trimWhitespace(word));
                }


            }

            i++;
        }
        sfu_class.setInstructors(instructors);
        sfu_class.printClass();
        System.out.println();


    }


}
