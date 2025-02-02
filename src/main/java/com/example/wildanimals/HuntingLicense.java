package com.example.wildanimals;

import java.time.LocalDate;

public class HuntingLicense {
    private String licenseNumber;
    private LocalDate validFrom;
    private LocalDate validTo;
    private WildAnimalSpecies allowedSpecies;

    public HuntingLicense(String licenseNumber, LocalDate validFrom, LocalDate validTo, WildAnimalSpecies allowedSpecies) {
        this.licenseNumber = licenseNumber;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.allowedSpecies = allowedSpecies;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public WildAnimalSpecies getAllowedSpecies() {
        return allowedSpecies;
    }
}