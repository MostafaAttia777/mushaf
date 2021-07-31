package com.Mushaf.Quran.network;

import com.Mushaf.Quran.Model.QuranResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {


     @GET("MahmoudMabrok/QuranyApp/master/app/src/main/assets/quran.json")
     Call<QuranResponse> getquran();

}
