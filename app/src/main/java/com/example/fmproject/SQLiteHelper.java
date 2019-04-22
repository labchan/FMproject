package com.example.fmproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.sql.Statement;

/**
 *create the database model
 *
 */

public class SQLiteHelper extends SQLiteOpenHelper{

    public static final String Database_Name="FM.db";
    public static final String Table_Name="repairRecord";
    public static final String col_1="id";
    public static final String col_2="location";
    public static final String col_3="site";
    public static final String col_4="contact";
    public static final String col_5="tel";
    public static final String col_6="description";

    // constructor
    public SQLiteHelper(Context context) {
        super(context, Database_Name, null, 1);

    }



    // create table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(" create table "+Table_Name+ "(id INTEGER PRIMARY KEY AUTOINCREMENT, location TEXT, site TEXT, contact TEXT, tel TEXT, description TEXT)");
    }

    // checking table to be create if not create it
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("drop table if exists " +Table_Name);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String location, String site, String contact, String tel, String description){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contenValues=new ContentValues();
        contenValues.put(col_2, location);
        contenValues.put(col_3, site);
        contenValues.put(col_4, contact);
        contenValues.put(col_5, tel);
        contenValues.put(col_6, description);

        // checking any record be insert
        long result = sqLiteDatabase.insert(Table_Name, null, contenValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res=sqLiteDatabase.rawQuery("select * from " +Table_Name, null);
        return res;

    }
    /*
    public void queryData (String sql){
        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData (String location, String site, String contact, String tel, String description, byte[] image){
        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO repair_order (NULL,?,?,?,?,?,?)";
        SQLiteStatement statement=database.compileStatement(sql);

        statement.clearBindings();
        statement.bindString(1, location);
        statement.bindString(2, site);
        statement.bindString(3, contact);
        statement.bindString(4, tel);
        statement.bindString(5 , description);
        statement.bindBlob(6, image);
    } */

}


