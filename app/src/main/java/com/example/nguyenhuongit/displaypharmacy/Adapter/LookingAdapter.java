package com.example.nguyenhuongit.displaypharmacy.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenhuongit.displaypharmacy.Data.Looking;
import com.example.nguyenhuongit.displaypharmacy.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LookingAdapter extends RecyclerView.Adapter<LookingAdapter.MyViewHolder> {

    List<Looking> lookingList;
    Context context;
    LayoutInflater layoutInflater;
    int layout;

    public LookingAdapter(Context context, int layout, List<Looking> lookingList){
        this.context = context;
        this.layout = layout;
        this.lookingList = lookingList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item_recycleview_looking, viewGroup, false);
        return new LookingAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Looking looking = lookingList.get(i);
        myViewHolder.textView.setText(looking.getString_data1());
        Picasso.with(context).load(looking.getImage_data1()).into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return lookingList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_recycleview_1);
            textView = itemView.findViewById(R.id.txt_recycleview_1);
        }
    }
}
