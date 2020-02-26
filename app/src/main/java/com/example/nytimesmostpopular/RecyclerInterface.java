package com.example.nytimesmostpopular;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecyclerInterface {

    String JSONURL = "https://api.nytimes.com/svc/mostpopular/v2/viewed/";

    @GET("7.json?api-key=mEIisEWr6D3ePJgGr4QeXyPOhPW2NyAJp")
    Call<String> getString();
}
