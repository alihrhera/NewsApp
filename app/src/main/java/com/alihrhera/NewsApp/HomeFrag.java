package com.alihrhera.NewsApp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alihrhera.NewsApp.inra.IntraFrag;

public class HomeFrag extends Fragment {


    public HomeFrag() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        TextView intrn=view.findViewById(R.id.intra);
        TextView sports=view.findViewById(R.id.sports);
        TextView search =view.findViewById(R.id.search);
        TextView you=view.findViewById(R.id.you);
        TextView star=view.findViewById(R.id.star);
        intrn .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Intar", Toast.LENGTH_SHORT).show();
                MyStaticFun.getInstance().attachFrag((MainActivity)getActivity(),new IntraFrag());

            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }

}
