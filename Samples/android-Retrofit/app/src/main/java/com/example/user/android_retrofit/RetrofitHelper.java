package com.example.user.android_retrofit;

import com.example.user.android_retrofit.model.SampleJSON;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by singh on 9/1/17.
 */

public class RetrofitHelper {

    private static final String BASE_URL = "http://jsonapi.org/";

    public static final String QUERY_INCLUDE = "include";
    public static final String PARAM_INCLUDE = "author";


    //use factory pattern to return the instances required
    public static Retrofit create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    //return the instance of the call object to make the call
    public static Call<SampleJSON> getSampleJsonResponse(){

        Retrofit retrofit = create();
        SampleJsonService sampleJsonService = retrofit.create(SampleJsonService.class);
        return sampleJsonService.getSampleResponse(PARAM_INCLUDE);


    }


    //Retrofit uses an interface to interact with the REST API using REST verbs
    public interface SampleJsonService{

        //Use the appropriate annotation for each REST verb
        @GET("examples/articles")//pass in the path extension to the verb annotation
        Call<SampleJSON> getSampleResponse(@Query(QUERY_INCLUDE) String include);

        //Using a dynamic URL in Retrofit
        @GET("examples/{pathDirectory}")
        Call<SampleJSON> getSampleResponseDynamic(@Path("articles") String pathDirectory);


    }

}
