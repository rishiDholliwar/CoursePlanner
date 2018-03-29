package ca.cmpt213.as5.CoursePlanner.Model.DataManger;

import java.util.ArrayList;

public class Offering implements Comparable<Offering>{
    private int offering;
    private ArrayList<Location> locations = new ArrayList<>();

    public Offering(int offering) {
        this.offering = offering;
    }

    public int getOffering() {
        return offering;
    }

    public void setOffering(int offering) {
        this.offering = offering;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void addLocation(Location location) {
        this.locations.add(location);
    }

    @Override
    public int compareTo(Offering o) {
        return this.getOffering() - o.getOffering();
    }
}
