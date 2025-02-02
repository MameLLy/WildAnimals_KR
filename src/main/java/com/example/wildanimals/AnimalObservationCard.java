package com.example.wildanimals;

public class AnimalObservationCard {

    private String location;
    private String observerName;
    private String notes;

    public AnimalObservationCard( String location, String observerName, String notes) {

        this.location = location;
        this.observerName = observerName;
        this.notes = notes;
    }


    public String getLocation() {
        return location;
    }

    public String getObserverName() {
        return observerName;
    }

    public String getNotes() {
        return notes;
    }
}