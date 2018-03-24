package ca.cmpt213.as5.CoursePlanner.Model;

import java.util.ArrayList;

public class SFU_Class {

    private int semester;
    private String subject;
    private String catalogNumber;
    private String location;
    private int enrolementCapacity;
    private int enrolementTotal;
    private ArrayList<String> instructors;
    private String componentCode;

    public SFU_Class(){

    }

    public SFU_Class(int semester, String subject, String catalogNumber, String location, int enrolementCapacity, int enrolementTotal, ArrayList<String> instructor, String componentCode) {
        this.semester = semester;
        this.subject = subject;
        this.catalogNumber = catalogNumber;
        this.location = location;
        this.enrolementCapacity = enrolementCapacity;
        this.enrolementTotal = enrolementTotal;
        this.instructors = instructor;
        this.componentCode = componentCode;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEnrolementCapacity() {
        return enrolementCapacity;
    }

    public void setEnrolementCapacity(int enrolementCapacity) {
        this.enrolementCapacity = enrolementCapacity;
    }

    public int getEnrolementTotal() {
        return enrolementTotal;
    }

    public void setEnrolementTotal(int enrolementTotal) {
        this.enrolementTotal = enrolementTotal;
    }

    public ArrayList<String> getInstructors() {
        return instructors;
    }

    public void setInstructors(ArrayList<String> instructors) {
        this.instructors = instructors;
    }

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode.replaceAll(" ", "");;
    }

    public void printClass() {
        System.out.print(semester + " "
                + subject + " "
                + catalogNumber + " "
                + location + " "
                + enrolementCapacity + " "
                + enrolementTotal + " ");
        printInstructors();
        System.out.print(componentCode + " ");
    }

    private void printInstructors() {

        for(String instructor: instructors){
            System.out.print(instructor + " ");
        }


    }


}
