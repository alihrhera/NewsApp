package com.alihrhera.NewsApp.inra;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.alihrhera.NewsApp.ConnectToFireBase;
import com.alihrhera.NewsApp.MainActivity;
import com.alihrhera.NewsApp.MoveObj;
import com.alihrhera.NewsApp.MyAdapter;
import com.alihrhera.NewsApp.OneNew;
import com.alihrhera.NewsApp.R;
import com.alihrhera.NewsApp.ShowOneArticle;
import com.alihrhera.NewsApp.StaticKeys;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class IntraFrag extends Fragment {

    private boolean isGrid = false;
    private LinearLayout noDataCon;
    private MyAdapter adapter;
    private ImageButton convert;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.ftrag_intran, container, false);
        final Context co = getContext();
        noDataCon = root.findViewById(R.id.noDataCont);

        recyclerView=root.findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(co));
        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        convert = root.findViewById(R.id.convert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isGrid) {
                    convert.setImageResource(R.drawable.ic_grid);
                    adapter.setmLayout(R.layout.row_artical);
                    recyclerView.setLayoutManager(new LinearLayoutManager(co));
                    recyclerView.setAdapter(adapter);

                    isGrid = false;
                } else {
                    isGrid = true;
                    adapter.setmLayout(R.layout.row_artical_grid);
                    convert.setImageResource(R.drawable.ic_list);
                    recyclerView.setLayoutManager(new GridLayoutManager(co, 2));
                    recyclerView.setAdapter(adapter);

                }

            }
        });

        adapter.setOnItemClick(new MyAdapter.OnItemClick() {
            @Override
            public void onClick(OneNew oneNew) {
                String date=""+android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss a",new Date(oneNew.getTime()));
                MoveObj.getInstance().Start(getContext()).setDateToMove(oneNew.getPhotoPath(),"Intra",date,oneNew.getTitle(),oneNew.getContent());
                MainActivity.attachFrag(new ShowOneArticle());

            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        IntranFargVM mViewModel = ViewModelProviders.of(this).get(IntranFargVM.class);
        ConnectToFireBase.getInstance().setVm(mViewModel);
        mViewModel.setData(StaticKeys.International);
        mViewModel.getData().observe(this, new Observer<List<OneNew>>() {
            @Override
            public void onChanged(List<OneNew> newsList) {
                Log.e("data Size", newsList.size() + "");
                if (newsList.size() > 0) {
                    noDataCon.setVisibility(View.GONE);
                    adapter.setDataList(newsList);
                }
            }
        });

    }


}
