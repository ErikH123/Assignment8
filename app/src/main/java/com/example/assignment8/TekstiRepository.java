package com.example.assignment8;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TekstiRepository {
    private TekstiDao mTekstiDao;
    private LiveData<List<Teksti>> mTekstit;

    TekstiRepository(Application application){
        TekstiDatabase db = TekstiDatabase.getDatabase(application);
        mTekstiDao = db.tekstiDao();
        mTekstit = mTekstiDao.getAll();
    }

    LiveData<List<Teksti>> getTekstit(){
        return mTekstit;
    }

    void insert(final Teksti teksti){
        TekstiDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                mTekstiDao.insert(teksti);
            }
        });
    }
}
