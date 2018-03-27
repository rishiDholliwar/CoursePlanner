package ca.cmpt213.as5.CoursePlanner.Model.DataManger;

import java.util.ArrayList;

public class DataManager {

    private ArrayList<Department> departments = new ArrayList<>();

    public void addDepartment(Department department){
        this.departments.add(department);
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
