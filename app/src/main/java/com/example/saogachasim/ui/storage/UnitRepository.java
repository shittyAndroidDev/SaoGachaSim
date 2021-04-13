package com.example.saogachasim.ui.storage;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class UnitRepository {
    private UserDao userDao;
    private LiveData<List<UnitEntity>> allUnits;
    UnitRepository(Application application){
        AppDatabase db = AppDatabase.getInstance(application);
        userDao = db.userDao();
        allUnits = userDao.getAllSorted();
    }
    LiveData<List<UnitEntity>> getAllUnits(){
        return allUnits;
    }
    public void insert(UnitEntity...unitEntity){
        new insertAsyncTask(userDao).execute(unitEntity);
    }
    private static class insertAsyncTask extends AsyncTask<UnitEntity,Void,Void>{
        private UserDao mAsyncTaskDao;
        insertAsyncTask(UserDao dao){
            mAsyncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final UnitEntity...params){
            mAsyncTaskDao.insertAll(params);
            return null;
        }
    }
}
