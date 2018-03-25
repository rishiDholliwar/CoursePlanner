package ca.cmpt213.as5.CoursePlanner.Model;

import java.util.ArrayList;

public class SFUCourse {

    private String subject;
    private String catalogNumber;
    private ArrayList<SFUClass> sfu_classes = new ArrayList<>();

    public SFUCourse(String subject, String catalogNumber) {
        this.subject = subject;
        this.catalogNumber = catalogNumber;
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

    public ArrayList<SFUClass> getSfu_classes() {
        return sfu_classes;
    }

    public void addSfu_classes(SFUClass sfu_class) {
        this.sfu_classes.add(sfu_class);
    }
}
