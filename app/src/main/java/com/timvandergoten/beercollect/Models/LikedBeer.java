package com.timvandergoten.beercollect.Models;

import android.os.Parcel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LikedBeer extends Beer{
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

}
