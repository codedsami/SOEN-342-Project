package Lesson;

import Users.Instructor;

public class Offering {

    private int offeringID;
    private String lessonType;
    private Location location; 
    private Schedule schedule;
    private Availability availability;
    private boolean isVisibleToPublic;
    private boolean isInstructorSelected;
    private Instructor instructor;

    public Offering(int id, String type, Location location, Schedule schedule) {
        this.offeringID = id;
        this.lessonType = type;
        this.location = location;
        this.schedule = schedule;
        this.isVisibleToPublic = false;
        this.isInstructorSelected = false;
        //instructor is appointed once an Instructor browse the list of offerings and choose one;
    }

    public Offering(int id, String type, Location location, Schedule schedule, boolean isVisibleToPublic, boolean isInstructorSelected) {
        this.offeringID = id;
        this.lessonType = type;
        this.location = location;
        this.schedule = schedule;
        this.isVisibleToPublic = isVisibleToPublic;
        this.isInstructorSelected = isInstructorSelected;
        //instructor is appointed once an Instructor browse the list of offerings and choose one;
    }

    public int getOfferingID() {
        return offeringID;
    }

    public void setOfferingID(int offeringID) {
        this.offeringID = offeringID;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public boolean getVisibility() {
        return isVisibleToPublic;
    }

    public void setVisibility(boolean isVisibleToPublic) {
        this.isVisibleToPublic = isVisibleToPublic;
    }


    public boolean isInstructorSelected() {
        return isInstructorSelected;
    }

    public void setInstructorSelected(boolean isInstructorSelected) {
        this.isInstructorSelected = isInstructorSelected;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        this.isInstructorSelected = true;
    }

    public void setLocation(Location newLocation) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLocation'");
    }

    public void setSchedule(Schedule newSchedule) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSchedule'");
    }
}
