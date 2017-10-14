package com.example.singh.android_rxjava2.RxAndroid.data.remote;



import com.example.singh.android_rxjava2.RxAndroid.model.Repo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by singh on 10/12/17.
 */

public class RemoteDataSource {


    public static final String BASE_URL = "https://api.github.com/";

    public static Retrofit create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }


    public static Observable<List<Repo>> getRepos(String username){
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getRepos(username);
    }


}
