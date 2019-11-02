package com.alihrhera.NewsApp;

import android.content.Context;
import android.content.SharedPreferences;

public class MoveObj {
   private static MoveObj obj;

   private MoveObj(){}

   public  static MoveObj getInstance() {
       if(obj==null){
           obj=new MoveObj();
       }
       return obj;
   }

   private SharedPreferences sh;
   private SharedPreferences.Editor eSh;
    public MoveObj Start(Context context) {
        sh=context.getSharedPreferences("MoveData",0);
        eSh=sh.edit();
        eSh.apply();
        return obj;
    }



    private String photo ,type ,date,title,content;

    public void setDateToMove(String photo ,String type ,String date,String title,String content ){
        eSh.putString("photo",photo);
        eSh.putString("type",type);
        eSh.putString("date",date);
        eSh.putString("title",title);
        eSh.putString("content",content);
        eSh.apply();

    }

    public String getPhoto() {
        return sh.getString("photo","");
    }

    public String getType() {
        return sh.getString("type","");

    }

    public String getDate() {
        return sh.getString("date","");

    }

    public String getTitle() {
        return sh.getString("title","");
    }

    public String getContent() {
        return sh.getString("content","");
    }
}
