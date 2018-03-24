package ca.cmpt213.as5.CoursePlanner.Model;

import java.util.ArrayList;

public class SFU_Course {

    private String subject;
    private String catalogNumber;
    private ArrayList<SFU_Class> sfu_classes = new ArrayList<>();

    public SFU_Course(String subject, String catalogNumber) {
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

    public ArrayList<SFU_Class> getSfu_classes() {
        return sfu_classes;
    }

    public void addSfu_classes(SFU_Class sfu_class) {
        this.sfu_classes.add(sfu_class);
    }
}
