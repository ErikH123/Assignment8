package com.example.assignment8;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TekstiDao {

    @Insert
    void insert(Teksti teksti);

    @Query("SELECT * FROM teksti")
    LiveData<List<Teksti>> getAll();

}
