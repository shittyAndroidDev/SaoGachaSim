package com.example.saogachasim;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

    private static final String TAG = "dbHelper";
    private static final String TABLE_NAME = "imgID";
    private static final String COL0 = "ID";
    private static final String COL1 = "THUMBNAIL";
    private static final String COL2 = "FULLIMAGE";
    private static final String COL3 = "STAR";

    public dbHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null,4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 + " TEXT, " +
                COL2 + " TEXT, " +
                COL3 + " INTEGER) ";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String s = "DROP TABLE IF EXISTS " + TABLE_NAME;
       /* if (newVersion > oldVersion) {
            db.execSQL("ALTER TABLE "+ TABLE_NAME +" ADD COLUMN "+ COL1 +" TEXT");
            db.execSQL("ALTER TABLE "+ TABLE_NAME +" ADD COLUMN "+ COL2 +" TEXT");
            db.execSQL("ALTER TABLE "+ TABLE_NAME +" ADD COLUMN "+ COL3 +" INTEGER");
        }*/
        db.execSQL(s);
        onCreate(db);

    }
    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        //String s = "DROP TABLE IF EXISTS " + TABLE_NAME;
        String del = "DELETE FROM " + TABLE_NAME;
        db.execSQL(del);
        //db.execSQL(s);
        //onCreate(db);
    }
    public boolean addData(String th,String full,int star){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
                contentValues.put(COL1,th);
                contentValues.put(COL2,full);
                contentValues.put(COL3,star);
       //Log.d(TAG,"addData: adding" + th + " to " + TABLE_NAME );
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }else {
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL3;
        return db.rawQuery(query,null);
    }
    public Cursor contains(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String s = "SELECT " + COL0 + " FROM " + TABLE_NAME +" WHERE " + COL1 + " = '" +name+"'";
        return db.rawQuery(s,null);
    }
}
