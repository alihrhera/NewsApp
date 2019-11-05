package com.alihrhera.NewsApp.my_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.alihrhera.NewsApp.StaticKeys;

import java.util.ArrayList;
import java.util.List;

public class MyDataBaseConn {
    private static  MyDataBaseConn obj;

    public static synchronized MyDataBaseConn getInstance() {
        if (obj==null){
             obj= new MyDataBaseConn();
        }

        return obj;
    }

    private MyDataBaseConn() {
    }

    SQLiteDatabase db;
    public  MyDataBaseConn Connect(Context context) {
        MyHelper helper=new MyHelper(context);
        db=helper.getReadableDatabase();
        return obj;
    }


    public boolean insertToDataBase(OfflineOneNew news){
        ContentValues values=new ContentValues();
        values.put(StaticKeys._title,news.getTitle());
        values.put(StaticKeys._content,news.getContent());
        values.put(StaticKeys._time,news.getTime());
        values.put(StaticKeys._photoPath,news.getPhotoPath());
        values.put(StaticKeys._type,news.getType());
        return db.insert(StaticKeys.TableName,null,values)>-1;
    }


    public List<OfflineOneNew> getAllOffLineNews(){
        List<OfflineOneNew> ret=new ArrayList<>();
            String SQl="Select * From "+ StaticKeys.TableName;
           Cursor cursor= db.rawQuery(SQl,null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                OfflineOneNew data=new OfflineOneNew();
                data.setId(cursor.getInt(cursor.getColumnIndex(StaticKeys._id)));
                data.setType(cursor.getInt(cursor.getColumnIndex(StaticKeys._type)));
                data.setTime(cursor.getInt(cursor.getColumnIndex(StaticKeys._time)));
                data.setContent(cursor.getString(cursor.getColumnIndex(StaticKeys._content)));
                data.setTitle(cursor.getString(cursor.getColumnIndex(StaticKeys._title)));
                data.setPhotoPath(cursor.getString(cursor.getColumnIndex(StaticKeys._photoPath)));
                ret.add(data);
            }


            cursor.close();
        return ret;
    };






}
