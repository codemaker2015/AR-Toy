package com.tcs.artoy.network;

import com.tcs.artoy.model.Response;
import com.tcs.artoy.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface GetDataService {

    @GET("/account/list")
    Call<List<User>> getBooks();

    @POST("/account/validate")
    Call<Response> validateUser(@Body User user);
}