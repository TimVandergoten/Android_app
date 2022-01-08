package com.timvandergoten.beercollect.Models;

public class Beer {
    public Beer() {
    }
    private String name;
    private String tagline;
    private String firstBrewed;
    private String description;
    private String imageUrl;

    public Beer(String name, String tagLine, String firstBrewed, String description, String imageUrl) {
        this.name = name;
        this.tagline = tagLine;
        this.firstBrewed = firstBrewed;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
