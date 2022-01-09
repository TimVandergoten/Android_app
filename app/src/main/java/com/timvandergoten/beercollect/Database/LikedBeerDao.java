package com.timvandergoten.beercollect.Database;

import android.widget.LinearLayout;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.timvandergoten.beercollect.Models.LikedBeer;

import java.util.List;
@Dao
public interface LikedBeerDao {
    @Query("Select * from likedBeer")
    List<LikedBeer> getAll();

    @Query("SELECT * FROM likedBeer WHERE id IN (:beerIds)")
    List<LikedBeer> loadAllByIds(int[] beerIds);

    @Query("SELECT * FROM likedBeer WHERE beerId IN (:beerId)")
    List<LikedBeer> loadByBeerId(int beerId);

    @Query("SELECT * FROM likedbeer WHERE name LIKE :beerName LIMIT 1")
    LikedBeer findByName(String beerName);

    @Insert
    void insertAll(LikedBeer... beers);

    @Delete
    void delete(LikedBeer beer);
}
