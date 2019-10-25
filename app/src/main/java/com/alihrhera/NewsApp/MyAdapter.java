package com.alihrhera.NewsApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<OneNew> dataList=new ArrayList<>();
    private int mLayout=R.layout.row_artical;

    public void setDataList(List<OneNew> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void setmLayout(int mLayout) {
        this.mLayout = mLayout;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(mLayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OneNew data=dataList.get(position);
        holder.title.setText(data.getTitle());
        holder.content.setText(data.getContent());
        Picasso.get().load(data.getPhotoPath()).fit().centerCrop().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
     TextView title,content;
     ImageView image;

     public MyViewHolder(@NonNull View view) {
         super(view);
         title=view.findViewById(R.id.row_title);
         content=view.findViewById(R.id.row_content);
         image=view.findViewById(R.id.row_image);


     }
 }

}
