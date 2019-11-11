package com.alihrhera.NewsApp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alihrhera.NewsApp.my_database.MyDataBaseConn;
import com.alihrhera.NewsApp.my_database.OfflineOneNew;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<?> dataList=new ArrayList<>();

    private int mLayout=R.layout.row_artical;
    private OnItemClick onItemClick;
    private boolean isSaved;
    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    public void setDataList(List<OneNew> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }
    public void setOffLineList(List<OfflineOneNew> dataList) {
        this.dataList = dataList;
        isSaved=true;
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
    private MyDataBaseConn db=MyDataBaseConn.getInstance();
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        OneNew data=(OneNew) dataList.get(position);
        if(dataList instanceof OfflineOneNew){
            data=(OfflineOneNew) dataList.get(position);
        }

        if (isSaved){
            holder.save.setVisibility(View.GONE);
        }


        holder.title.setText(data.getTitle());
        holder.content.setText(data.getContent());
        Picasso.get().load(data.getPhotoPath()).fit().centerCrop().into(holder.image);
        db.Connect(holder.itemView.getContext());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick((OneNew) dataList.get(holder.getAdapterPosition()));
            }
        });
        final OneNew finalData = data;
        holder.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OfflineOneNew n=new OfflineOneNew();
                n.setPhotoPath(finalData.getPhotoPath());
                n.setTitle(finalData.getTitle());
                n.setTime(finalData.getTime());
                n.setContent(finalData.getContent());
                n.setType(finalData.getType());
                if (db.insertToDataBase(n)){
                    Toast.makeText(holder.itemView.getContext(), "Done", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
     TextView title,content,save;
     ImageView image;

      MyViewHolder(@NonNull View view) {
         super(view);
         title=view.findViewById(R.id.row_title);
         content=view.findViewById(R.id.row_content);
         image=view.findViewById(R.id.row_image);
         save=view.findViewById(R.id.save_to_read);

     }
 }

 public interface OnItemClick{
        void onClick(OneNew oneNew);
 }








}
