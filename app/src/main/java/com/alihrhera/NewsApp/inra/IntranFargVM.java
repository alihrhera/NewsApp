package com.alihrhera.NewsApp.inra;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;


import com.alihrhera.NewsApp.OneNew;
import com.alihrhera.NewsApp.StaticKeys;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class IntranFargVM extends AndroidViewModel {

    private MediatorLiveData<List<OneNew>>getData= new MediatorLiveData<>();

    public IntranFargVM(@NonNull Application application) {
        super(application);
    }

    private List<OneNew> list = new ArrayList<>();

     void setData(int type) {
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference("NewsData");
        Query query=ref.orderByChild(StaticKeys.Type).equalTo(type);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              if (dataSnapshot.exists()){
                for (DataSnapshot data:dataSnapshot.getChildren() ){
                    OneNew oneNew=data.getValue(OneNew.class);
                    Log.e("TestData",oneNew.getTitle()+" ");
                    list.add(oneNew);
                }
                  getData.postValue(list);

              }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        getData.postValue(list);
    }

     public void setDataList( List<OneNew> list ) {
      //  List<OneNew> list = ConnectToFireBase.getInstance().getNewsByType(type);
        getData.postValue(list);
        Log.e("Data",list.size()+" ");

    }

    LiveData<List<OneNew>> getData(){
        return getData;
    }

}
