package ca.cmpt213.as5.CoursePlanner.Model.DataManger;


import java.util.ArrayList;

/**
 * The department. Will be a short string
 */
public class Department implements Comparable<Department> {
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

    public void addCourses(Course course) {
        this.courses.add(course);
    }

    @Override
    public int compareTo(Department o) {
        return this.getDepartment().compareTo(o.getDepartment());
    }
}
