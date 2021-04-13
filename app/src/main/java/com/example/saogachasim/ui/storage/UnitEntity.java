package com.example.saogachasim.ui.storage;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "user")
public class UnitEntity implements Serializable {

    /*@ColumnInfo(name = "c_name")
    public String c_name;*/

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "thumbnail")
    public String thumbnail;

    @ColumnInfo(name = "full_Image")
    public String full_Image;

    @ColumnInfo(name = "star")
    public int star;

    public UnitEntity(@NonNull String thumbnail, String full_Image, int star){
        this.thumbnail = thumbnail;
        this.full_Image = full_Image;
        this.star = star;
    }



}
