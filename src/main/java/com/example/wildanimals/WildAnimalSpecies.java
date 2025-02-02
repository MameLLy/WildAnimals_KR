package com.example.wildanimals;

public class WildAnimalSpecies {
    private String name;
    private AnimalClass animalClass;

    public WildAnimalSpecies(String name, AnimalClass animalClass) {
        this.name = name;
        this.animalClass = animalClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalClass getAnimalClass() {
        return animalClass;
    }
}

