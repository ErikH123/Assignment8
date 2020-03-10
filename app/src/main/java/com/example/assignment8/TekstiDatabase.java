package com.example.assignment8;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Teksti.class}, version = 3, exportSchema = false)
public abstract class TekstiDatabase extends RoomDatabase {

    private static final String NIMI = "TEKSTI_DATABASE";
    public abstract TekstiDao tekstiDao();

    private static volatile TekstiDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static TekstiDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (TekstiDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TekstiDatabase.class, NIMI)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
