package com.example.rest_test2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitMethod {


    @GET("{user}")
    Call<List<Post_data>> Posts_listData(@Path("user") String user);
}
