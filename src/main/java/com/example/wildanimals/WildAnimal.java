package com.example.wildanimals;

import java.util.ArrayList;
import java.util.List;

public class WildAnimal extends Animal {
    private WildAnimalSpecies species;
    private Feed feed;

    public WildAnimal(int id, String name, int age, double weight, WildAnimalSpecies species, Feed feed) {
        super(id, name, age, weight);
        this.species = species;
        this.feed = feed;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Species: " + species.getName() + ", Feed Type: " + feed.getType());
    }

    public WildAnimalSpecies getSpecies() {
        return species;
    }

    public Feed getFeed() {
        return feed;
    }
}