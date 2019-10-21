package com.alihrhera.NewsApp.inra;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alihrhera.NewsApp.ConnectToFireBase;
import com.alihrhera.NewsApp.OneNew;
import com.alihrhera.NewsApp.R;
import com.alihrhera.NewsApp.StaticKeys;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class IntranFarg extends Fragment {

    private IntranFargVM mViewModel;

    public static IntranFarg newInstance() {
        return new IntranFarg();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.ftrag_intran, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(IntranFargVM.class);
        ConnectToFireBase.getInstance().setVm(mViewModel);
        mViewModel.setData(StaticKeys.International);
        mViewModel.getData().observe(this, new Observer<List<OneNew>>() {
            @Override
            public void onChanged(List<OneNew> oneNews) {
                Log.e("data Size",oneNews.size()+"");
             //   Toast.makeText(getActivity(), oneNews.size()+"", Toast.LENGTH_SHORT).show();
            }
        });

    }



}
