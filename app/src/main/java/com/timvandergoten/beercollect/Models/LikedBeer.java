package com.timvandergoten.beercollect.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LikedBeer extends Beer implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    private String comment;

    public LikedBeer() {
    }

    public LikedBeer(int beerId ,String name, String tagLine, String description, String imageUrl,String comment) {
        super(beerId, name, tagLine, description, imageUrl);
        this.comment = comment;
    }

    public LikedBeer(Parcel in) {
        super(in);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(super.getName());
        parcel.writeString(super.getTagline());
        parcel.writeString(super.getDescription());
        parcel.writeString(super.getImageUrl());
        parcel.writeString(comment);
    }
    public static final Creator<LikedBeer> CREATOR = new Creator<LikedBeer>() {
        @Override
        public LikedBeer createFromParcel(Parcel in) {
            return new LikedBeer(in);
        }

        @Override
        public LikedBeer[] newArray(int size) {
            return new LikedBeer[size];
        }
    };
}
