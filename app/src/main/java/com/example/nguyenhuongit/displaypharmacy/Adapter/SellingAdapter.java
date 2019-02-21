package com.example.nguyenhuongit.displaypharmacy.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyenhuongit.displaypharmacy.Data.Selling;
import com.example.nguyenhuongit.displaypharmacy.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SellingAdapter extends RecyclerView.Adapter<SellingAdapter.MyViewHolder> {

    Context context;
    int layout;
    LayoutInflater layoutInflater;
    List<Selling> sellingList;

    public SellingAdapter(Context context, int layout, List<Selling> sellingList){
        this.context = context;
        this.layout = layout;
        this.sellingList = sellingList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.item_recycleview_selling, viewGroup, false);
        return new SellingAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Selling selling = sellingList.get(i);
        myViewHolder.textView.setText(selling.getString_data2());
        Picasso.with(context).load(selling.getImage_data2()).into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return sellingList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_recycleview_2);
            textView = itemView.findViewById(R.id.txt_recycleview_2);
        }
    }
}
