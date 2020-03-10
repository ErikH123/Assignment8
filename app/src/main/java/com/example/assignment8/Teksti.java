package com.example.assignment8;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Teksti{

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String teksti;

    public Teksti() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTeksti() {
        return teksti;
    }

    public void setTeksti(String teksti) {
        this.teksti = teksti;
    }
}
