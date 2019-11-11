package com.alihrhera.NewsApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

class MyStaticFun {

    private static  MyStaticFun ourInstance ;

    static MyStaticFun getInstance() {
        if (ourInstance==null){
            ourInstance  = new MyStaticFun();
        }
        return ourInstance;
    }

    private MyStaticFun() {
    }


    private Fragment fragment;

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    void attachFrag(AppCompatActivity activity, Fragment fragment){
        if (fragment!=null) {
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragments_cont,fragment);
            fragmentTransaction.commit();
        }


    }


}
