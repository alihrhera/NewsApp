package com.alihrhera.NewsApp.my_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alihrhera.NewsApp.StaticKeys;

public class MyHelper extends SQLiteOpenHelper {
    public MyHelper(Context context){
        super(context, StaticKeys.DataBaseName,null,StaticKeys.DataBaseV);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String Sql = "CREATE TABLE IF NOT EXISTS " + StaticKeys.TableName + "(" + StaticKeys._id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + StaticKeys._title + " text," + StaticKeys._content + " text , " + StaticKeys._time + " Real ,"+StaticKeys._photoPath+" text , "+
                StaticKeys._type +" INTEGER )";
        db.execSQL(Sql);    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
