package com.timvandergoten.beercollect.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;

import java.util.Objects;
public class Beer implements Parcelable {
    public Beer() {
    }

    private int beerId;
    private String name;
    private String tagline;
    private String description;
    private String imageUrl;

    public Beer(int beerID,String name, String tagLine, String description, String imageUrl) {
        this.beerId = beerID;
        this.name = name;
        this.tagline = tagLine;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getBeerId() {
        return beerId;
    }

    public void setBeerId(int beerId) {
        this.beerId = beerId;
    }

    protected Beer(Parcel in) {
        name = in.readString();
        tagline = in.readString();
        description = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Beer> CREATOR = new Creator<Beer>() {
        @Override
        public Beer createFromParcel(Parcel in) {
            return new Beer(in);
        }

        @Override
        public Beer[] newArray(int size) {
            return new Beer[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(tagline);
        parcel.writeString(description);
        parcel.writeString(imageUrl);
    }
}
