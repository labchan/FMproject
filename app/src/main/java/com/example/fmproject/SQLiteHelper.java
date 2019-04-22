package com.example.fmproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.sql.Statement;

/**
 *create the database model
 *
 */

public class SQLiteHelper extends SQLiteOpenHelper{
    public SQLiteHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

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




    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){

    }
}


