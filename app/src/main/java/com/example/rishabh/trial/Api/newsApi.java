package com.example.rishabh.trial.Api;

import com.example.rishabh.trial.POJOs.TOI.newsclass;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RISHABH on 17-07-2017.
 */

public interface newsApi {

    @GET("articles?source=the-times-of-india&sortBy=top&apiKey=d43874e411d74a719490520d7297d028")
    Call<newsclass> getnews();
}