package com.alihrhera.NewsApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SplashAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // FirebaseDatabase database = FirebaseDatabase.getInstance();
       // DatabaseReference myRef = database.getReference("NewsData");
       // //myRef.setValue("New Set1");
       // OneNew obj=new OneNew();
       // obj.setTitle("11الخبر الاول ");
       // obj.setContent("هذا الخبر لافتاتح قاعده البيانات");
       // obj.setPhotoPath("https://i.pinimg.com/236x/c2/a9/c9/c2a9c9621175a6f04804d0d192a787b0--neon-logo-sg-logo.jpg");
       // obj.setType(StaticKeys.International);
       // obj.setTime(Calendar.getInstance().getTimeInMillis());
       // myRef.push().setValue(obj);
       // obj.setTitle("11الخبر الثانى ");
       // obj.setContent("هذا خبر محلى ");
       // obj.setPhotoPath("https://i.pinimg.com/236x/c2/a9/c9/c2a9c9621175a6f04804d0d192a787b0--neon-logo-sg-logo.jpg");
       // obj.setType(StaticKeys.LocalNews);
       // obj.setTime(Calendar.getInstance().getTimeInMillis());
       // myRef.push().setValue(obj);


        ImageView splashImage=findViewById(R.id.splash_image);

        TranslateAnimation anmait=new TranslateAnimation(0,-1000,0,0,
                0,0,0,0);
         anmait.setDuration(3000);
         splashImage.startAnimation(anmait);

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(4000);
                    startActivity(new Intent(SplashAct.this,MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();




    }
}
