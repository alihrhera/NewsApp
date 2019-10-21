package com.alihrhera.NewsApp;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ConnectToFireBase {
    private AndroidViewModel vm;

    public void setVm(AndroidViewModel vm) {
        this.vm = vm;
    }

    private  ConnectToFireBase(){}
    private final static  ConnectToFireBase obj=new ConnectToFireBase();

     public static synchronized ConnectToFireBase getInstance(){

         return obj;
     }

     private List<OneNew> list=new ArrayList<>();
     public List<OneNew> getNewsByType(int  type ){
         FirebaseDatabase database = FirebaseDatabase.getInstance();
         DatabaseReference myRef = database.getReference("NewsData");
         Query query=myRef.child(StaticKeys.Type).equalTo(type);
         query.addListenerForSingleValueEvent(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 if (dataSnapshot.exists()){
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        OneNew oneNew=data.getValue(OneNew.class);
                        assert oneNew != null;
                        Log.e("Data",oneNew.getTime()+" ");
                        list.add(oneNew);
                     }
                 }

             }
             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });

    return list;
     }


}
