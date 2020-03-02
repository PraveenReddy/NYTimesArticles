package com.example.nytimesmostpopular.repositories;

import com.example.nytimesmostpopular.models.Article;
import com.example.nytimesmostpopular.network.Api;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticlesRepository {

    private static ArticlesRepository instance;

    public static ArticlesRepository getInstance(){
        if(instance == null){
            instance = new ArticlesRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Article>> getArticles(){
        final MutableLiveData<List<Article>> data = new MutableLiveData<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<Article>> call = api.getArticles();

        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> call, Response<List<Article>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {

            }
        });
        return data;
    }
}
