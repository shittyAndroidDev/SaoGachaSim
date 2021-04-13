package com.example.saogachasim.ui.storage;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class StorageViewModel extends AndroidViewModel {
    private UnitRepository unitRepository;
    private LiveData<List<UnitEntity>> units;

    public StorageViewModel(@NonNull Application application){
        super(application);
        unitRepository = new UnitRepository(application);
        units = unitRepository.getAllUnits();
    }
    public LiveData<List<UnitEntity>> getAllUnits(){
        return units;
    }
    public void insert(UnitEntity...units){
        unitRepository.insert(units);
    }
}
