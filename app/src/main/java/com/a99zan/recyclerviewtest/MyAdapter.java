package com.a99zan.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 99zan on 2018/3/13.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private List<Test> data;
    private Context context;
    private MyOnItemClickListener listener = null;

    public MyAdapter(Context context, List<Test> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.imageView.setImageResource(R.mipmap.ic_launcher);
        holder.textView.setText(data.get(position).getText());
        if(listener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnItemClickListener(MyOnItemClickListener listener){
        this.listener = listener;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.text);
        }
    }

}
