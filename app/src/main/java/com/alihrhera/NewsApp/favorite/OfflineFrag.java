package com.alihrhera.NewsApp.favorite;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alihrhera.NewsApp.MainActivity;
import com.alihrhera.NewsApp.MoveObj;
import com.alihrhera.NewsApp.MyAdapter;
import com.alihrhera.NewsApp.OneNew;
import com.alihrhera.NewsApp.R;
import com.alihrhera.NewsApp.ShowOneArticle;
import com.alihrhera.NewsApp.my_database.MyDataBaseConn;

import java.util.Date;


public class OfflineFrag extends Fragment {
   public OfflineFrag(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragment_offlaine, container, false);
        RecyclerView offline=v.findViewById(R.id.offline);
        offline.setLayoutManager(new GridLayoutManager(getContext(),2));
        MyAdapter adapter=new MyAdapter();
        adapter.setmLayout(R.layout.row_artical_grid);
        adapter.setOffLineList(MyDataBaseConn.getInstance().Connect(getContext()).getAllOffLineNews());
        offline.setAdapter(adapter);
     adapter.setOnItemClick(new MyAdapter.OnItemClick() {
      @Override
      public void onClick(OneNew oneNew) {
       String date=""+android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss a",new Date(oneNew.getTime()));
       MoveObj.getInstance().Start(getContext()).setDateToMove(oneNew.getPhotoPath(),"Intra",date,oneNew.getTitle(),oneNew.getContent());
       MainActivity.attachFrag(new ShowOneArticle());

      }
     });





        return v;
    }

}
