package com.example.appsambongrejo.API;


import com.example.appsambongrejo.ResponseModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {
    @GET("retrieve.php")
    Call<ResponseModel> ardRetrieveData();

    @FormUrlEncoded
    @POST("create.php")
    Call<ResponseModel> ardCreateData(
            @Field("paket1") String paket1,
            @Field("paket2") String paket2,
            @Field("paket3") String paket3,
            @Field("paket4") String paket4,
            @Field("paket5") String paket5,
            @Field("paket6") String paket6,
            @Field("total") String total,
            @Field("harga") String harga
    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseModel> ardDeleteData(
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("get.php")
    Call<ResponseModel> ardGetData(
            @Field("id") int id
    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseModel> ardUpdateData(
            @Field("id") int id,
            @Field("paket1") String paket1,
            @Field("paket2") String paket2,
            @Field("paket3") String paket3,
            @Field("paket4") String paket4,
            @Field("paket5") String paket5,
            @Field("paket6") String paket6,
            @Field("total") String total,
            @Field("harga") String harga
    );
}

