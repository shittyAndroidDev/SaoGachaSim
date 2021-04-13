package com.example.saogachasim.ui.storage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UnitEntity.class}, version = 2,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    private static AppDatabase db;

    public static AppDatabase getInstance(Context context){
        if(db == null) {
            return db = buildDatabase(context);
        }else
            return db;
    }
    private static AppDatabase buildDatabase(Context context){
        return Room.databaseBuilder(context,
                AppDatabase.class, "storage_database").fallbackToDestructiveMigration().build();
    }
}