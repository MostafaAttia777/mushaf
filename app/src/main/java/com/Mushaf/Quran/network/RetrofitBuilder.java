package com.Mushaf.Quran.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

private static Retrofit retrofit;

private  static  String BASE_URL="https://raw.githubusercontent.com/";


  public static NewsApi  getserves(){

if (retrofit == null){

    retrofit=new Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();



}
return retrofit.create(NewsApi.class);

}
}
