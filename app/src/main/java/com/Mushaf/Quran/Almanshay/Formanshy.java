package com.Mushaf.Quran.Almanshay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Mushaf.Quran.Model.Ayahs;
import com.Mushaf.Quran.Model.QuranResponse;
import com.Mushaf.Quran.Model.Surahs;
import com.Mushaf.Quran.Rcycel.AdpterForRecycler;
import com.Mushaf.Quran.network.NewsApi;
import com.Mushaf.Quran.network.RetrofitBuilder;
import com.mushaf.quran.R;
import com.Mushaf.Quran.Reading.Reading;
import com.Mushaf.Quran.Rcycel.RecyclerViewClickInterface;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Formanshy extends Fragment implements RecyclerViewClickInterface {

    public Formanshy() {
    }
ArrayList<Ayahs> ayahs;
    RecyclerView rc;
    ArrayList<Surahs> surahs;
RecyclerViewClickInterface recyclerViewClickInterface=new RecyclerViewClickInterface() {
    @Override
    public void onItemClick(int position) {
        opensoundorreading(position);

    }
};




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.all_moshaf,container,false);
        rc=v.findViewById(R.id.my_mushaf_recycler);

       // AdpterForRecycler adpterForRecycler=new AdpterForRecycler(getContext(), theNameOfMushafs,this);
      //  rc.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rc.setAdapter(adpterForRecycler);
        NewsApi newsApi = RetrofitBuilder.getserves();
        newsApi.getquran().enqueue(new Callback<QuranResponse>() {
            @Override
            public void onResponse(Call<QuranResponse> call, Response<QuranResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    surahs = (ArrayList<Surahs>) response.body().getData().getSurahs();
                    AdpterForRecycler adpterForRecycler = new AdpterForRecycler(getContext(), surahs,recyclerViewClickInterface);
                    rc.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rc.setAdapter(adpterForRecycler);
                }
            }

            @Override
            public void onFailure(Call<QuranResponse> call, Throwable t) {
                Toast.makeText(getContext(), "open your internet " + "\n" + "?????? ???????? ?????????? ????????????????", Toast.LENGTH_LONG).show();

            }
        });


        return v;
    }

    @Override
    public void onItemClick(int position) {

    }
/*
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theNameOfMushafs = new ArrayList<>();
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "1", "????????-7 ????????", "1","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/001.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "2", "??????????-286 ??????", "2","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/002.mp3"));
            theNameOfMushafs.add(new TheNameOfMushaf("???? ??????????", "50", "??????????-200 ??????", "3","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/003.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "77", "??????????-176 ??????", "4","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/004.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "106", "??????????-120 ??????", "5","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/005.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "128", "????????-165 ??????", "6","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/006.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "151", "????????-206 ??????", "7","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/007.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "177", "??????????-75??????", "8","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/008.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "187", "??????????-129 ??????", "9","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/009.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????", "208", "????????-109??????", "10","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/010.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????", "221", "????????-123??????", "11","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/011.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????", "235", "????????-111 ??????", "12","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/012.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "249", "??????????-43 ??????", "13","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/013.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "255", "????????-52 ??????", "14","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/014.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "262", "????????-99 ??????", "15","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/015.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "267", "????????-128 ??????", "16","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/016.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "282", "????????-111 ??????", "17","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/017.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "293", "????????-110 ??????", "18","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/018.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????", "305", "????????-98 ??????", "19","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/019.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????", "312", "????????-135 ??????", "20","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/020.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "322", "????????-112 ??????", "21","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/021.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????", "332", "??????????-87 ??????", "22","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/022.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "342", "????????-118", "23","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/023.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "350", "??????????-64 ??????", "24","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/024.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "359", "????????-77 ??????", "25","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/025.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf(" ??????????????", "367", "????????-227 ??????", "26","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/026.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "377", "????????-93 ??????", "27","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/027.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "385", "????????-88 ??????", "28","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/028.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "396", "????????-69 ??????", "29","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/029.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "404", "????????-60 ??????", "30","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/030.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "411", "????????-34 ??????", "31","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/031.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "415", "????????-30", "32","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/032.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "418", "??????????-73 ??????", "33","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/033.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????", "428", "????????-54 ??????", "34","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/034.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????", "434", "????????-45 ??????", "35","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/035.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????", "440", "????????-83 ??????", "36","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/036.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "446", "????????-182 ??????", "37","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/037.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??", "453", "????????-88 ??????", "38","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/038.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "458", "????????-75 ??????", "39","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/039.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????", "467", "????????-85 ??????", "40","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/040.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "477", "????????-54 ??????", "41","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/041.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "483", "????????-53 ??????", "42","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/042.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "489", "????????-89 ??????", "43","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/043.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "496", "????????-59 ??????", "44","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/044.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "499", "????????-37 ??????", "45","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/045.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "502", "????????-35 ??????", "46","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/046.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????", "507", "??????????-38 ??????", "47","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/047.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "511", "??????????-29 ??????", "48","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/048.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "515", "??????????-18 ??????", "49","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/049.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??", "518", "????????-45 ??????", "50","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/050.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "520", "????????-60 ??????", "51","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/051.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "523", "????????-49 ??????", "52","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/052.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "526", "????????-62 ??????", "53","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/053.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "528", "????????-55 ??????", "54","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/054.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "531", "??????????-78 ??????", "55","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/055.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "534", "????????-96 ??????", "56","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/056.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "537", "??????????-29 ??????", "57","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/057.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "542", "??????????-22 ??????", "58","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/058.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "545", "??????????-24 ??????", "59","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/059.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "549", "??????????-13 ??????", "60","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/060.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????", "551", "??????????-14 ??????", "61","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/061.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "553", "??????????-11 ??????", "62","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/062.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????????", "554", "??????????-11 ??????", "63","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/063.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "556", "??????????-18 ??????", "64","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/064.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "558", "??????????-12 ??????", "65","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/065.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "560", "??????????-12 ?????? ", "66","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/066.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "562", "????????-30 ??????", "67","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/067.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "564", "????????-52 ??????", "68","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/068.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "566", "????????-52 ??????", "69","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/069.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "568", "????????-44 ??????", "70","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/070.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????", "570", "????????-28 ??????", "71","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/071.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????", "572", "????????-28 ??????", "72","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/072.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "574", "????????-20 ??????", "73","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/073.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "575", "????????-56 ??????", "74","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/074.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "577", "????????-40 ??????", "75","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/075.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "578", "??????????-31 ??????", "76","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/076.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "580", "????????-50 ??????", "77","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/077.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "582", "????????-40 ??????", "78","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/078.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "583", "????????-46 ??????", "79","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/079.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????", "585", "????????-42 ??????", "80","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/080.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "586", "????????-29 ??????", "81","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/081.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "587", "????????-19 ??????", "82","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/082.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????????", "587", "????????-36 ??????", "83","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/083.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "589", "????????-25 ??????", "84","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/084.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "590", "????????-22 ??????", "85","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/085.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "591", "????????-17 ??????", "86","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/086.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "591", "????????-19 ??????", "87","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/087.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "592", "????????-26 ??????", "88","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/088.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "593", "????????-30 ??????", "89","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/089.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "594", "????????-20 ??????", "90","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/090.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "595", "????????-15 ??????", "91","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/091.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "595", "????????-21 ??????", "92","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/092.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "596", "????????-11 ??????", "93","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/093.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "596", "????????-8 ????????", "94","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/094.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "597", "????????-8 ????????", "95","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/095.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "597", "????????-19 ??????", "96","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/096.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "598", "????????-5 ????????", "97","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/097.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "598", "??????????-8 ????????", "98","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/098.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "599", "??????????-8 ????????", "99","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/099.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "599", "????????-11 ??????", "100","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/100.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "600", "????????-11 ??????", "101","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/101.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "600", "????????-8 ????????", "102","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/102.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "601", "????????-3 ????????", "103","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/103.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "601", "????????-9 ????????", "104","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/104.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "601", "????????-5 ????????", "105","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/105.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????", "602", "????????-4 ????????", "106","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/106.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "602", "????????-7 ????????", "107","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/107.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????", "602", "????????-3 ????????", "108","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/108.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("????????????????", "603", "????????-6 ????????", "109","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/109.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "603", "??????????-3 ????????", "110","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/110.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "603", "????????-5 ????????", "111","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/111.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????????", "604", "????????-4 ????????", "112","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/112.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "604", "????????-5 ????????", "113","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/113.mp3"));
        theNameOfMushafs.add(new TheNameOfMushaf("??????????", "604", "????????-6 ????????", "114","https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/114.mp3"));

    }
    */

    private void opensoundorreading(final int position) {

        final AlertDialog.Builder ab = new AlertDialog.Builder(getContext());
        ab.setNegativeButton("read", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent goforreading = new Intent(getContext().getApplicationContext(), Reading.class);
                Toast.makeText(getActivity(), surahs.get(position).getName(), Toast.LENGTH_SHORT).show();
                goforreading.putExtra("done", (Serializable) surahs.get(position));
                startActivity(goforreading);
            }
        }).setPositiveButton("listening", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getContext().getApplicationContext(), TestFormanshy.class);
                intent.putExtra("play",linksOFsoundes().get(position));
                startActivity(intent);
            }
        }).show();

    }

    private ArrayList<String> linksOFsoundes() {
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/001.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/002.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/003.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/004.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/005.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/006.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/007.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/008.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/009.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/010.mp3");

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/011.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/012.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/013.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/014.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/015.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/016.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/017.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/018.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/019.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/020.mp3");

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/021.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/022.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/023.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/024.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/025.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/026.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/027.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/028.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/029.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/030.mp3");

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/031.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/032.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/033.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/034.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/035.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/036.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/037.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/038.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/039.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/040.mp3");

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/041.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/042.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/043.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/044.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/045.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/046.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/047.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/048.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/049.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/050.mp3");

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/051.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/052.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/053.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/054.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/055.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/056.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/057.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/058.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/059.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/060.mp3");

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/061.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/062.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/063.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/064.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/065.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/066.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/067.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/068.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/069.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/070.mp3");

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/071.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/072.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/073.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/074.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/075.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/076.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/077.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/078.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/079.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/080.mp3");

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/081.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/082.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/083.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/084.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/085.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/086.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/087.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/088.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/089.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/090.mp3");

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/091.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/092.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/093.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/094.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/095.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/096.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/097.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/098.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/099.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/100.mp3");

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/101.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/102.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/103.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/104.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/105.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/106.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/107.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/108.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/109.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/110.mp3");

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/111.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/112.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/113.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Al-Minshawi-Mojawad/114.mp3");

        return arrayList;
    }


}


/*
    @Override
    public void onItemClick(int position) {

        Intent intent=new Intent(getContext(),TestFormanshy.class);
        Toast.makeText(getContext(),""+theNameOfMushafs.get(position).getName_of_sora()+"???" , Toast.LENGTH_SHORT).show();

        intent.putExtra("play",theNameOfMushafs.get(position).getLinks());
        startActivity(intent);
     */
