package com.Mushaf.Quran.yasserAldoasery;

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

import com.Mushaf.Quran.Model.QuranResponse;
import com.Mushaf.Quran.Model.Surahs;
import com.Mushaf.Quran.Rcycel.AdpterForRecycler;
import com.Mushaf.Quran.Rcycel.RecyclerViewClickInterface;
import com.Mushaf.Quran.Reading.Reading;
import com.Mushaf.Quran.network.NewsApi;
import com.Mushaf.Quran.network.RetrofitBuilder;
import com.mushaf.quran.R;

import java.io.Serializable;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForAllMoshaf extends Fragment implements RecyclerViewClickInterface {

    public ForAllMoshaf() {
    }


    RecyclerView rc;
    ArrayList<Surahs> surahs;
  //  private InterstitialAd interstitial;

    RecyclerViewClickInterface recyclerViewClickInterface=new RecyclerViewClickInterface() {
    @Override
    public void onItemClick(int position) {
        soundorread(position);
    }
};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.all_moshaf, container, false);
        rc = v.findViewById(R.id.my_mushaf_recycler);
        //  AdpterForRecycler adpterForRecycler=new AdpterForRecycler(getContext(), theNameOfMushafs,this);
        // rc.setLayoutManager(new LinearLayoutManager(getActivity()));
        //rc.setAdapter(adpterForRecycler);

//        MobileAds.initialize(getActivity(),
//                "ca-app-pub-9585993475666915~8941796348");
//        interstitial = new InterstitialAd(getActivity());
//        interstitial.setAdUnitId("ca-app-pub-9585993475666915/2246178449");
//        interstitial.loadAd(new AdRequest.Builder().build());
//        interstitial.setAdListener(new AdListener() {
//            @Override
//            public void onAdClosed() {
//                // Load the next interstitial.
//                interstitial.loadAd(new AdRequest.Builder().build());
//            }
//
//        });
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
                Toast.makeText(getContext(), "open your internet " + "\n" + "يجب عليك تشغيل الانترنت", Toast.LENGTH_LONG).show();

            }
        });


        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /*      theNameOfMushafs = new ArrayList<>();
             theNameOfMushafs.add(new TheNameOfMushaf("الفاتحة", "1", "مكيه-7 ايات", "1","https://download.tvquran.com/download/TvQuran.com__Yasser/001.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("البقرة", "2", "مدنيه-286 اية", "2","https://download.tvquran.com/download/TvQuran.com__Yasser/002.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("ال عمران", "50", "مدنية-200 اية", "3","https://download.tvquran.com/download/TvQuran.com__Yasser/003.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("النساء", "77", "مدنية-176 اية", "4","https://download.tvquran.com/download/TvQuran.com__Yasser/004.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("المائدة", "106", "مدنية-120 اية", "5","https://download.tvquran.com/download/TvQuran.com__Yasser/005.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الانعام", "128", "مكية-165 اية", "6","https://download.tvquran.com/download/TvQuran.com__Yasser/006.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الأعراف", "151", "مكيه-206 اية", "7","https://download.tvquran.com/download/TvQuran.com__Yasser/007.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الأنفال", "177", "مدنية-75اية", "8","https://download.tvquran.com/download/TvQuran.com__Yasser/008.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("التوبة", "187", "مدنية-129 اية", "9","https://download.tvquran.com/download/TvQuran.com__Yasser/009.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("يونس", "208", "مكية-109اية", "10","https://download.tvquran.com/download/TvQuran.com__Yasser/010.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("هود", "221", "مكية-123اية", "11","https://download.tvquran.com/download/TvQuran.com__Yasser/011.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("يوسف", "235", "مكية-111 اية", "12","https://download.tvquran.com/download/TvQuran.com__Yasser/012.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الرعد", "249", "مدنية-43 اية", "13","https://download.tvquran.com/download/TvQuran.com__Yasser/013.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("إبراهيم", "255", "مكية-52 اية", "14","https://download.tvquran.com/download/TvQuran.com__Yasser/014.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الحجر", "262", "مكية-99 اية", "15","https://download.tvquran.com/download/TvQuran.com__Yasser/015.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("النحل", "267", "مكية-128 اية", "16","https://download.tvquran.com/download/TvQuran.com__Yasser/016.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الإسراء", "282", "مكيه-111 اية", "17","https://download.tvquran.com/download/TvQuran.com__Yasser/017.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الكهف", "293", "مكية-110 اية", "18","https://download.tvquran.com/download/TvQuran.com__Yasser/018.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("مريم", "305", "مكية-98 اية", "19","https://download.tvquran.com/download/TvQuran.com__Yasser/019.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("طه", "312", "مكية-135 اية", "20","https://download.tvquran.com/download/TvQuran.com__Yasser/020.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الأنبياء", "322", "مكيه-112 اية", "21","https://download.tvquran.com/download/TvQuran.com__Yasser/021.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الحج", "332", "مدنية-87 اية", "22","https://download.tvquran.com/download/TvQuran.com__Yasser/022.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("المؤمنون", "342", "مكية-118", "23","https://download.tvquran.com/download/TvQuran.com__Yasser/022.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("النور", "350", "مدنية-64 اية", "24","https://download.tvquran.com/download/TvQuran.com__Yasser/024.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الفرقان", "359", "مكية-77 اية", "25","https://download.tvquran.com/download/TvQuran.com__Yasser/025.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf(" الشعراء", "367", "مكية-227 اية", "26","https://download.tvquran.com/download/TvQuran.com__Yasser/026.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("النمل", "377", "مكية-93 اية", "27","https://download.tvquran.com/download/TvQuran.com__Yasser/027.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("القصص", "385", "مكية-88 اية", "28","https://download.tvquran.com/download/TvQuran.com__Yasser/028.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("العنكبوت", "396", "مكية-69 اية", "29","https://download.tvquran.com/download/TvQuran.com__Yasser/029.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الرّوم", "404", "مكية-60 اية", "30","https://download.tvquran.com/download/TvQuran.com__Yasser/030.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("لقمان", "411", "مكية-34 اية", "31","https://download.tvquran.com/download/TvQuran.com__Yasser/031.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("السجدة", "415", "مكية-30", "32","https://download.tvquran.com/download/TvQuran.com__Yasser/032.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الأحزاب", "418", "مدنية-73 اية", "33","https://download.tvquran.com/download/TvQuran.com__Yasser/033.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("سبأ", "428", "مكية-54 اية", "34","https://download.tvquran.com/download/TvQuran.com__Yasser/034.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("فاطر", "434", "مكية-45 اية", "35","https://download.tvquran.com/download/TvQuran.com__Yasser/035.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("يس", "440", "مكية-83 اية", "36","https://download.tvquran.com/download/TvQuran.com__Yasser/036.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الصافات", "446", "مكيه-182 اية", "37","https://download.tvquran.com/download/TvQuran.com__Yasser/037.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("ص", "453", "مكية-88 اية", "38","https://download.tvquran.com/download/TvQuran.com__Yasser/038.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الزمر", "458", "مكية-75 اية", "39","https://download.tvquran.com/download/TvQuran.com__Yasser/039.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("غافر", "467", "مكية-85 اية", "40","https://download.tvquran.com/download/TvQuran.com__Yasser/040.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("فصّلت", "477", "مكية-54 اية", "41","https://download.tvquran.com/download/TvQuran.com__Yasser/041.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الشوري", "483", "مكية-53 اية", "42","https://download.tvquran.com/download/TvQuran.com__Yasser/042.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الزخرف", "489", "مكية-89 اية", "43","https://download.tvquran.com/download/TvQuran.com__Yasser/043.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الدّخان", "496", "مكية-59 اية", "44","https://download.tvquran.com/download/TvQuran.com__Yasser/044.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الجاثية", "499", "مكية-37 اية", "45","https://download.tvquran.com/download/TvQuran.com__Yasser/045.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الاحقاف", "502", "مكية-35 اية", "46","https://download.tvquran.com/download/TvQuran.com__Yasser/046.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("محمد", "507", "مدنية-38 اية", "47","https://download.tvquran.com/download/TvQuran.com__Yasser/047.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الفتح", "511", "مدنية-29 اية", "48","https://download.tvquran.com/download/TvQuran.com__Yasser/048.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الحجرات", "515", "مدنية-18 اية", "49","https://download.tvquran.com/download/TvQuran.com__Yasser/049.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("ق", "518", "مكية-45 اية", "50","https://download.tvquran.com/download/TvQuran.com__Yasser/050.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الذاريات", "520", "مكية-60 اية", "51","https://download.tvquran.com/download/TvQuran.com__Yasser/051.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الطور", "523", "مكية-49 اية", "52","https://download.tvquran.com/download/TvQuran.com__Yasser/052.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("النجم", "526", "مكية-62 اية", "53","https://download.tvquran.com/download/TvQuran.com__Yasser/053.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("القمر", "528", "مكية-55 اية", "54","https://download.tvquran.com/download/TvQuran.com__Yasser/054.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الرحمن", "531", "مدنية-78 اية", "55","https://download.tvquran.com/download/TvQuran.com__Yasser/055.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الواقعه", "534", "مكية-96 اية", "56","https://download.tvquran.com/download/TvQuran.com__Yasser/056.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الحديد", "537", "مدنية-29 اية", "57","https://download.tvquran.com/download/TvQuran.com__Yasser/057.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("المجادلة", "542", "مدنية-22 اية", "58","https://download.tvquran.com/download/TvQuran.com__Yasser/058.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الحشر", "545", "مدنية-24 اية", "59","https://download.tvquran.com/download/TvQuran.com__Yasser/059.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الممتحنة", "549", "مدنية-13 اية", "60","https://download.tvquran.com/download/TvQuran.com__Yasser/060.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الصف", "551", "مدنية-14 اية", "61","https://download.tvquran.com/download/TvQuran.com__Yasser/061.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الجمعة", "553", "مدنية-11 اية", "62","https://download.tvquran.com/download/TvQuran.com__Yasser/062.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("المنافقون", "554", "مدنية-11 اية", "63","https://download.tvquran.com/download/TvQuran.com__Yasser/063.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("التغابن", "556", "مدنية-18 اية", "64","https://download.tvquran.com/download/TvQuran.com__Yasser/064.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الطلاق", "558", "مدنية-12 اية", "65","https://download.tvquran.com/download/TvQuran.com__Yasser/065.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("التحريم", "560", "مدنية-12 اية ", "66","https://download.tvquran.com/download/TvQuran.com__Yasser/066.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الملك", "562", "مكية-30 اية", "67","https://download.tvquran.com/download/TvQuran.com__Yasser/067.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("القلم", "564", "مكية-52 اية", "68","https://download.tvquran.com/download/TvQuran.com__Yasser/068.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الحاقة", "566", "مكية-52 اية", "69","https://download.tvquran.com/download/TvQuran.com__Yasser/069.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("المعارج", "568", "مكية-44 اية", "70","https://download.tvquran.com/download/TvQuran.com__Yasser/070.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("نوح", "570", "مكية-28 اية", "71","https://download.tvquran.com/download/TvQuran.com__Yasser/071.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الجن", "572", "مكية-28 اية", "72","https://download.tvquran.com/download/TvQuran.com__Yasser/072.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("المزّمّل", "574", "مكية-20 اية", "73","https://download.tvquran.com/download/TvQuran.com__Yasser/073.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("المدّثر", "575", "مكية-56 اية", "74","https://download.tvquran.com/download/TvQuran.com__Yasser/074.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("القيامة", "577", "مكية-40 اية", "75","https://download.tvquran.com/download/TvQuran.com__Yasser/075.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الانسان", "578", "مدنية-31 اية", "76","https://download.tvquran.com/download/TvQuran.com__Yasser/076.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("المرسلات", "580", "مكية-50 اية", "77","https://download.tvquran.com/download/TvQuran.com__Yasser/077.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("النبأ", "582", "مكية-40 اية", "78","https://download.tvquran.com/download/TvQuran.com__Yasser/078.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("النازعات", "583", "مكية-46 اية", "79","https://download.tvquran.com/download/TvQuran.com__Yasser/079.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("عبس", "585", "مكية-42 اية", "80","https://download.tvquran.com/download/TvQuran.com__Yasser/080.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("التكوير", "586", "مكية-29 اية", "81","https://download.tvquran.com/download/TvQuran.com__Yasser/081.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الانفطار", "587", "مكية-19 اية", "82","https://download.tvquran.com/download/TvQuran.com__Yasser/082.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("المطفّفين", "587", "مكية-36 اية", "83","https://download.tvquran.com/download/TvQuran.com__Yasser/083.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الإنشقاق", "589", "مكية-25 اية", "84","https://download.tvquran.com/download/TvQuran.com__Yasser/084.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("البروج", "590", "مكية-22 اية", "85","https://download.tvquran.com/download/TvQuran.com__Yasser/085.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الطارق", "591", "مكية-17 اية", "86","https://download.tvquran.com/download/TvQuran.com__Yasser/086.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الاعلي", "591", "مكية-19 اية", "87","https://download.tvquran.com/download/TvQuran.com__Yasser/087.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الغاشية", "592", "مكية-26 اية", "88","https://download.tvquran.com/download/TvQuran.com__Yasser/088.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الفجر", "593", "مكية-30 اية", "89","https://download.tvquran.com/download/TvQuran.com__Yasser/089.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("البلد", "594", "مكية-20 اية", "90","https://download.tvquran.com/download/TvQuran.com__Yasser/090.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الشمس", "595", "مكية-15 اية", "91","https://download.tvquran.com/download/TvQuran.com__Yasser/091.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الليل", "595", "مكية-21 اية", "92","https://download.tvquran.com/download/TvQuran.com__Yasser/092.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الضحي", "596", "مكية-11 اية", "93","https://download.tvquran.com/download/TvQuran.com__Yasser/093.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الشرح", "596", "مكية-8 ايات", "94","https://download.tvquran.com/download/TvQuran.com__Yasser/094.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("التين", "597", "مكية-8 ايات", "95","https://download.tvquran.com/download/TvQuran.com__Yasser/095.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("العلق", "597", "مكية-19 اية", "96","https://download.tvquran.com/download/TvQuran.com__Yasser/096.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("القدر", "598", "مكية-5 ايات", "97","https://download.tvquran.com/download/TvQuran.com__Yasser/097.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("البينة", "598", "مدنية-8 ايات", "98","https://download.tvquran.com/download/TvQuran.com__Yasser/098.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الزلزلة", "599", "مدنية-8 ايات", "99","https://download.tvquran.com/download/TvQuran.com__Yasser/099.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("العاديات", "599", "مكية-11 اية", "100","https://download.tvquran.com/download/TvQuran.com__Yasser/100.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("القارعة", "600", "مكية-11 اية", "101","https://download.tvquran.com/download/TvQuran.com__Yasser/101.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("التكاثر", "600", "مكية-8 ايات", "102","https://download.tvquran.com/download/TvQuran.com__Yasser/102.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("العصر", "601", "مكية-3 ايات", "103","https://download.tvquran.com/download/TvQuran.com__Yasser/103.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الهمزة", "601", "مكية-9 ايات", "104","https://download.tvquran.com/download/TvQuran.com__Yasser/104.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الفيل", "601", "مكية-5 ايات", "105","https://download.tvquran.com/download/TvQuran.com__Yasser/105.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("قريش", "602", "مكية-4 ايات", "106","https://download.tvquran.com/download/TvQuran.com__Yasser/106.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الماعون", "602", "مكية-7 ايات", "107","https://download.tvquran.com/download/TvQuran.com__Yasser/107.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الكوثر", "602", "مكية-3 ايات", "108","https://download.tvquran.com/download/TvQuran.com__Yasser/108.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الكافرون", "603", "مكية-6 ايات", "109","https://download.tvquran.com/download/TvQuran.com__Yasser/109.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("النصر", "603", "مدنية-3 ايات", "110","https://download.tvquran.com/download/TvQuran.com__Yasser/110.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("المسد", "603", "مكية-5 ايات", "111","https://download.tvquran.com/download/TvQuran.com__Yasser/111.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الاخلاص", "604", "مكية-4 ايات", "112","https://download.tvquran.com/download/TvQuran.com__Yasser/112.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الفلق", "604", "مكية-5 ايات", "113","https://download.tvquran.com/download/TvQuran.com__Yasser/113.mp3"));
             theNameOfMushafs.add(new TheNameOfMushaf("الناس", "604", "مكية-6 ايات", "114","https://download.tvquran.com/download/TvQuran.com__Yasser/114.mp3"));

 */


    }


    @Override
    public void onItemClick(int position) {

    }


    private void soundorread(final int position) {
        AlertDialog.Builder ab = new AlertDialog.Builder(getContext());
        ab.setNegativeButton("read", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent goforreading = new Intent(getContext().getApplicationContext(), Reading.class);
                Toast.makeText(getActivity(), surahs.get(position).getName(), Toast.LENGTH_SHORT).show();
                goforreading.putExtra("done", (Serializable) surahs.get(position));
             //   prepareAd();

                startActivity(goforreading);
            }
        }).setPositiveButton("listening", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getContext().getApplicationContext(), test.class);
                intent.putExtra("all",linksOFsoundes().get(position));
             //   prepareAd();

                startActivity(intent);
            }
        }).show();

    }

//    private void prepareAd() {
//        if (interstitial.isLoaded()) {
//            interstitial.show();
//        } else {
//            Log.d("TAG", "The interstitial wasn't loaded yet.");
//        }
//    }

    private ArrayList<String> linksOFsoundes() {

        ArrayList<String> arrayList=new ArrayList<>();
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/001.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/002.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/003.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/004.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/005.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/006.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/007.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/008.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/009.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/010.mp3");
  arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/011.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/012.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/013.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/014.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/015.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/016.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/017.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/018.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/019.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/020.mp3");
  arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/021.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/022.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/023.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/024.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/025.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/026.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/027.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/028.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/029.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/030.mp3");
             arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/031.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/032.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/033.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/034.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/035.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/036.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/037.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/038.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/039.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/030.mp3");
       arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/040.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/041.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/042.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/043.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/044.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/045.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/046.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/047.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/048.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/049.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/050.mp3");
       arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/051.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/052.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/053.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/0%4.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/055.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/0%6.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/057.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/058.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/059.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/060.mp3");
       arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/061.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/062.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/063.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/064.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/065.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/066.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/067.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/068.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/069.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/070.mp3");
       arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/071.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/072.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/073.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/074.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/075.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/076.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/077.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/078.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/079.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/080.mp3");
       arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/081.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/082.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/083.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/084.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/085.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/086.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/087.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/088.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/089.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/090.mp3");
       arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/091.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/092.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/093.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/094.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/095.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/096.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/097.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/098.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/099.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/100.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/101.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/102.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/103.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/104.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/105.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/106.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/107.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/108.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/109.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/110.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/111.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/112.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/113.mp3");
            arrayList.add("https://download.tvquran.com/download/TvQuran.com__Yasser/114.mp3");



        return arrayList;
    }
}


