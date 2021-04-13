package com.example.saogachasim.ui.storage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    LiveData<List<UnitEntity>> getAll();

    /*@Query("SELECT * FROM user WHERE c_name LIKE :name")
    LiveData<List<UnitEntity>> findByName(String name);*/

    @Query("SELECT * FROM user WHERE star LIKE :st")
    LiveData<List<UnitEntity>> findByStar(int st);

    @Query("SELECT * FROM user ORDER BY star")
    LiveData<List<UnitEntity>> getAllSorted();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(UnitEntity... users);

    @Delete
    void delete(UnitEntity user);
}
