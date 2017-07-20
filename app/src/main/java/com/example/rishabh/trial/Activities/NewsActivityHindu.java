package com.example.rishabh.trial.Activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.rishabh.trial.Adapters2.NewsAdapter2;
import com.example.rishabh.trial.Adapters2.NewsAdapter3;
import com.example.rishabh.trial.Api.newsApi;
import com.example.rishabh.trial.Api.newsApi2;
import com.example.rishabh.trial.OnItemClickListener;
import com.example.rishabh.trial.POJOs.Hindu.newsclass1;

import com.example.rishabh.trial.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsActivityHindu extends AppCompatActivity {

    RecyclerView rvnews2;
    NewsAdapter3 newsadapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_hindu);

        rvnews2=(RecyclerView)findViewById(R.id.rvnews2);
        LinearLayoutManager li = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rvnews2.setLayoutManager(li);
        newsadapter3 = new NewsAdapter3(this,new ArrayList<com.example.rishabh.trial.POJOs.Hindu.articles>());

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final newsApi2 newsapi2=retrofit.create(newsApi2.class);

        newsapi2.getnewshindu().enqueue(new Callback<newsclass1>() {


            @Override
            public void onResponse(Call<newsclass1> call, Response<newsclass1> response) {
                newsadapter3 = new NewsAdapter3(NewsActivityHindu.this,response.body().getArticles());
                rvnews2.setAdapter(newsadapter3);
                newsadapter3.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(String itemid) {
                        try{
                            Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse(itemid));
                            startActivity(web);
                        }
                        catch(ActivityNotFoundException ae)
                        {
                            Toast.makeText(NewsActivityHindu.this, "activity not found", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<newsclass1> call, Throwable t) {
                Toast.makeText(NewsActivityHindu.this, "Poor Internet Connection", Toast.LENGTH_SHORT).show();
            }

            });
        }
}
