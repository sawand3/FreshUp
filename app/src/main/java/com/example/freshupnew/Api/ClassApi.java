package com.example.freshupnew.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClassApi {


    public static String BASE_URL="http://52.25.90.159/app/index.php/api/user/";
    public static Retrofit retrofit=null;

    public static Retrofit apiclient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;
    }
}
