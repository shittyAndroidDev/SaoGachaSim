package com.example.saogachasim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    private static final String TAG = "dbHelper";
    private static final String TABLE_NAME = "imgID";
    private static final String COL0 = "ID";
    private static final String COL1 = "imgT";
    private static final String COL2 = "imgF";
    public dbHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null,3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 + " TEXT, " +  COL2 + " TEXT" + ")";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String s = "DROP TABLE IF EXISTS " + TABLE_NAME;
        if (newVersion > oldVersion) {
            db.execSQL("ALTER TABLE "+ TABLE_NAME +" ADD COLUMN "+ COL2 +" TEXT");
        }
        db.execSQL(s);
        onCreate(db);

    }
    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        String del = "DELETE FROM " + TABLE_NAME;
        db.execSQL(del);
    }
    public boolean addData(String th,String full){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,th);
        contentValues.put(COL2,full);
       Log.d(TAG,"addData: adding" + th + " to " + TABLE_NAME );

        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
}
