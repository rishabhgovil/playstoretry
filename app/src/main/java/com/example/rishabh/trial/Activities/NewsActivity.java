package com.example.rishabh.trial.Activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rishabh.trial.Adapters2.NewsAdapter2;
import com.example.rishabh.trial.Api.newsApi;
import com.example.rishabh.trial.OnItemClickListener;
import com.example.rishabh.trial.POJOs.TOI.articles;
import com.example.rishabh.trial.POJOs.TOI.newsclass;
import com.example.rishabh.trial.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsActivity extends AppCompatActivity {
    RecyclerView rvnews1;
    NewsAdapter2 newsadapter2;
    TextView newsurl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        rvnews1=(RecyclerView)findViewById(R.id.rvnews1);
        newsurl=(TextView)findViewById(R.id.newsurl);
        LinearLayoutManager li = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvnews1.setLayoutManager(li);
        newsadapter2 = new NewsAdapter2(this,new ArrayList<articles>());

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        final newsApi newsapi=retrofit.create(newsApi.class);

        newsapi.getnews().enqueue(new Callback<newsclass>() {
            @Override
            public void onResponse(Call<newsclass> call, Response<newsclass> response) {

                newsadapter2=new NewsAdapter2(NewsActivity.this,response.body().getArticles());
                rvnews1.setAdapter(newsadapter2);
                newsadapter2.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(String itemid) {
                        try{
                            Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse(itemid));
                            startActivity(web);
                        }
                        catch(ActivityNotFoundException ae)
                        {
                            Toast.makeText(NewsActivity.this, "activity not found", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<newsclass> call, Throwable t) {
                Toast.makeText(NewsActivity.this, "Poor Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
