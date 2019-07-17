package com.example.freshupnew.Api;

import com.example.freshupnew.Model.GetServicesDataModel;
import com.example.freshupnew.Model.ProductListModel;
import com.example.freshupnew.Model.ProductModel;
import com.example.freshupnew.Model.ServicesListModel;
import com.example.freshupnew.Model.ServicesModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @GET("getServices")
    Call<ServicesModel> getServices();

    @GET("getProduct")
    Call<ProductModel> getProduct();

    @FormUrlEncoded
    @POST("getSubServices")
    Call<ServicesListModel> getSubServices(@Field("serviceId") String serviceId);

    @FormUrlEncoded
    @POST("getSubCategoryAndProduct")
    Call<ProductListModel> getProducts(@Field("categoryId") String categoryId);
}
