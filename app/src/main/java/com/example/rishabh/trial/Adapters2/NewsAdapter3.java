package com.example.rishabh.trial.Adapters2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.trial.Activities.NewsActivityHindu;
import com.example.rishabh.trial.OnItemClickListener;
import com.example.rishabh.trial.POJOs.Hindu.articles;
import com.example.rishabh.trial.R;

import java.util.ArrayList;

/**
 * Created by RISHABH on 19-07-2017.
 */

public class NewsAdapter3 extends RecyclerView.Adapter<NewsAdapter3.NewsViewHolder> {

    Context context;
    ArrayList<articles> articlesArrayList;
    private OnItemClickListener onItemClickListener;


    public NewsAdapter3(NewsActivityHindu context, ArrayList<articles> articlesArrayList) {
        this.context = context;
        this.articlesArrayList = articlesArrayList;
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.newslayout, parent, false);
        return new NewsAdapter3.NewsViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        final articles A = articlesArrayList.get(position);
        holder.newsauthor.setText(A.getAuthor());
        holder.newstitle.setText(A.getTitle());
        holder.newsdescription.setText(A.getDescription());
        holder.newsurl.setText(A.getUrl());
        holder.newspublished.setText(A.getPublishedAt());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(A.getUrl());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView newstitle, newsdescription, newsurl, newspicurl, newspublished, newsauthor;

        public NewsViewHolder(View itemView) {
            super(itemView);
            newsauthor = (TextView) itemView.findViewById(R.id.newsauthor);
            newstitle = (TextView) itemView.findViewById(R.id.newstitle);
            newsdescription = (TextView) itemView.findViewById(R.id.newsdescription);
            newsurl = (TextView) itemView.findViewById(R.id.newsurl);
            newspublished = (TextView) itemView.findViewById(R.id.newspublished);
        }
    }
}
