package com.example.user.android_retrofit;

import com.example.user.android_retrofit.model.SampleJSON;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by singh on 9/1/17.
 */

public class RetrofitHelper {

    private static final String BASE_URL = "http://jsonapi.org/";

    public static final String QUERY_INCLUDE = "include";
    public static final String query_Include_Paramenter = "author";


    public static Retrofit create(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public static Call<SampleJSON> getSampleJsonResponse(){

        Retrofit retrofit = create();
        SampleJsonService sampleJsonService = retrofit.create(SampleJsonService.class);
        return sampleJsonService.getSampleResponse(query_Include_Paramenter);


    }

    public interface SampleJsonService{

        @GET("examples/articles")
        Call<SampleJSON> getSampleResponse(@Query(QUERY_INCLUDE) String include);


    }

}
