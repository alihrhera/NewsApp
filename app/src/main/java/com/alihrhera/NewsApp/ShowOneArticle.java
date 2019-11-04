package com.alihrhera.NewsApp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowOneArticle extends Fragment {


    public ShowOneArticle() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.frag_show_one_article, container, false);
         TextView title=v.findViewById(R.id.title);
        TextView type=v.findViewById(R.id.type);
        TextView date=v.findViewById(R.id.date);
         TextView content=v.findViewById(R.id.content);
        ImageView photo=v.findViewById(R.id.articlePhoto);

        MoveObj data=MoveObj.getInstance().Start(Objects.requireNonNull(getContext()));

        final String sTitle=data.getTitle();
        String sType=data.getType();
        String sDate=data.getDate();
        final String sContent=data.getContent();

        Picasso.get().load(data.getPhoto()).centerCrop().fit().into(photo);
        title.setText(sTitle);
        type.setText(sType);
        date.setText(sDate);
        content.setText(sContent);
        v.findViewById(R.id.shareBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share(sTitle+"\n"+sContent);
            }
        });

        return v;
    }

    private void share(String msg){
            msg+="\n تمت المشاركه باستخدام تطبيق اخبارى ";
            msg+="https://play.google.com/store/apps/details?id="+getActivity().getPackageName()+"";
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        //sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, msg);
        startActivity(Intent.createChooser(sharingIntent, "ارسال ب استخدام "));


    }

}
