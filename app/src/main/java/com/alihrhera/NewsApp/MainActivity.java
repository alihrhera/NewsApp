package com.alihrhera.NewsApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  static   FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        attachFrag(new HomeFrag());

    }



    public static void attachFrag(Fragment frag){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragments_cont,frag);
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        attachFrag(MyStaticFun.getInstance().getFragment());
    }
}
