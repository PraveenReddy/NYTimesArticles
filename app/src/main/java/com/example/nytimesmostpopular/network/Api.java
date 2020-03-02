package com.example.nytimesmostpopular.network;

import com.example.nytimesmostpopular.models.Article;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://api.nytimes.com/svc/mostpopular/";

    @GET("v2/viewed/7.json?api-key=mEIisEWr6D3ePJgGr4QeXyPOhPW2NyAJp")
    Call<List<Article>> getArticles();
}
