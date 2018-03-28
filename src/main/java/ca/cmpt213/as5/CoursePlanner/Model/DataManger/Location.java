package ca.cmpt213.as5.CoursePlanner.Model.DataManger;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Location {
    private String location;
    private ArrayList<Section> sections = new ArrayList<>();
    private ArrayList<String> instructors = new ArrayList<>();

    public Location(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }

    public void addInstructors(ArrayList<String> instructors) {
        for (String instructor : instructors) {
            if (!instructor.equals("(null)")) {
                if (!this.instructors.contains(instructor)) {
                    this.instructors.add(instructor);
                }
            }
        }
    }

    public void printInstructors() {
        int isLast = 0;
        for (String instructor : instructors) {
            isLast++;
            if ((instructors.size()) != isLast) {
                System.out.print(instructor + ", ");
            } else {
                System.out.print(instructor);
            }

        }
    }
}
