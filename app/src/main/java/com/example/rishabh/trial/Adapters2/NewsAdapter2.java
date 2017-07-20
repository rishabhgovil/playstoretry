package com.example.rishabh.trial.Adapters2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rishabh.trial.OnItemClickListener;
import com.example.rishabh.trial.POJOs.TOI.articles;
import com.example.rishabh.trial.R;

import java.util.ArrayList;

/**
 * Created by RISHABH on 17-07-2017.
 */

public class NewsAdapter2 extends RecyclerView.Adapter<NewsAdapter2.NewsViewHolder> {

    Context context;
    ArrayList<articles> Articles;
    private OnItemClickListener onItemClickListener;

    public static final String TAG = "hello";

    public NewsAdapter2(Context context, ArrayList<articles> articles) {
        this.context = context;
        this.Articles = articles;
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void updatenews(ArrayList<articles> articlesArrayList) {
        this.Articles = articlesArrayList;
        notifyDataSetChanged();

    }


    @Override
    public NewsAdapter2.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.newslayout, parent, false);
        return new NewsViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final NewsAdapter2.NewsViewHolder holder, int position) {
        final articles A = Articles.get(position);

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
        return Articles.size();
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
