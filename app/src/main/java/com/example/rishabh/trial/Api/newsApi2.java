package com.example.rishabh.trial.Api;

import com.example.rishabh.trial.POJOs.Hindu.newsclass1;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by RISHABH on 19-07-2017.
 */

public interface newsApi2 {
    @GET("articles?source=the-hindu&sortBy=latest&apiKey=d43874e411d74a719490520d7297d028")
    Call<newsclass1> getnewshindu();
}
