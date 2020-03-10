package com.example.assignment8;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TekstiViewModel extends AndroidViewModel {

    private TekstiRepository mRepository;
    private LiveData<List<Teksti>> mAllTekstit;

    public TekstiViewModel(Application application){
        super(application);
        mRepository = new TekstiRepository(application);
        mAllTekstit = mRepository.getTekstit();
    }

    LiveData<List<Teksti>> getmAllTekstit(){
        return mAllTekstit;
    }

    public void insert(Teksti teksti) {
        mRepository.insert(teksti);
    }
}
