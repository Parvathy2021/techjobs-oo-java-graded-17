package org.launchcode.techjobs.oo;

import com.sun.source.tree.BreakTree;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
// TASK 3

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
// TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {

//TASK 5: #4
        if(name== null && employer == null && location == null && positionType == null && coreCompetency == null){
            return "OOPS! This job does not seem to exist.";
        }

//TASK 5: #3
        String Name =(name.isEmpty() ? "Data not available" : name);
        String Employer =(employer.getValue().isEmpty() ? "Data not available" : employer.getValue());
        String Location =(location.getValue().isEmpty() ? "Data not available" : location.getValue());
        String PositionType = (positionType.getValue().isEmpty() ? "Data not available" : positionType.getValue());
        String  CoreCompetency = (coreCompetency.getValue().isEmpty()? "Data not available": coreCompetency.getValue());

// TASK 5: 1 & 2
        return System.lineSeparator() +
                "ID: " + getId() + System.lineSeparator() +
                "Name: " + Name + System.lineSeparator() +
                "Employer: " + Employer + System.lineSeparator() +
                "Location: " + Location + System.lineSeparator() +
                "Position Type: " + PositionType + System.lineSeparator() +
                "Core Competency: " + CoreCompetency + System.lineSeparator();

    }
}
