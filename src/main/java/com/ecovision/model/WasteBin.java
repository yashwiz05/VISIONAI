package com.ecovision.model;

import jakarta.persistence.*;

@Entity
@Table(name = "waste_bins")
public class WasteBin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private double fillLevel; // Percentage 0 - 100
    private String wasteCategory; // Organic, Plastic, E-Waste
    private String status; // NORMAL, WARNING, CRITICAL

    public WasteBin() {}

    public WasteBin(String location, double fillLevel, String wasteCategory, String status) {
        this.location = location;
        this.fillLevel = fillLevel;
        this.wasteCategory = wasteCategory;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public double getFillLevel() { return fillLevel; }
    public void setFillLevel(double fillLevel) { this.fillLevel = fillLevel; }
    public String getWasteCategory() { return wasteCategory; }
    public void setWasteCategory(String wasteCategory) { this.wasteCategory = wasteCategory; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}