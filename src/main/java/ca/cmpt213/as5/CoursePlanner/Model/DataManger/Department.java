package ca.cmpt213.as5.CoursePlanner.Model.DataManger;

import java.util.ArrayList;

public class Department {

    private String department;
    private ArrayList<Course> courses = new ArrayList<>();

    public Department(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void addCourses(Course course){
        this.courses.add(course);
    }

    public void printCourses(){
        for (Course course : courses){

        }
    }
}
