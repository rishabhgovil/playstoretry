package com.example.rishabh.trial.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rishabh.trial.OnItemClickListener;
import com.example.rishabh.trial.POJOs.News;
import com.example.rishabh.trial.POJOs.education;
import com.example.rishabh.trial.R;

import java.util.ArrayList;

/**
 * Created by RISHABH on 17-07-2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;
    ArrayList<News> NewsArrayList;
    private OnItemClickListener onItemClickListener;

    public NewsAdapter(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public NewsAdapter(Context context, ArrayList<News> newsArrayList) {

        this.context = context;
        NewsArrayList = newsArrayList;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.news,parent,false);
        return new NewsViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        final News news = NewsArrayList.get(position);
        holder.news.setText(news.getNews());
        holder.iv2.setImageResource(news.getIv2());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(news.getNews());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return NewsArrayList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView news;
        ImageView iv2;
        public NewsViewHolder(View itemView) {
            super(itemView);
            news  = (TextView)itemView.findViewById(R.id.news);
            iv2 = (ImageView)itemView.findViewById(R.id.iv2);
        }
    }
}
