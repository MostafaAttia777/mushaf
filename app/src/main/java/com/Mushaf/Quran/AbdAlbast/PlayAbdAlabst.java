package com.Mushaf.Quran.AbdAlbast;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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

public class PlayAbdAlabst extends Fragment {


    public PlayAbdAlabst() {
    }

    //   String[] strings= new String[]{"", "https://download.tvquran.com/download/TvQuran.com__Yasser/002.mp3"};
    //public static final String link="https://download.tvquran.com/download/TvQuran.com__Yasser/001.mp3";
    RecyclerView rc;
    ArrayList<Surahs> surahs;
    ProgressBar progressBar;

    RecyclerViewClickInterface recyclerViewClickInterface = new RecyclerViewClickInterface() {
        @Override
        public void onItemClick(final int position) {
            chooce(position);

        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.all_moshaf, container, false);
        rc = v.findViewById(R.id.my_mushaf_recycler);
        progressBar = v.findViewById(R.id.my_pp);

//        MobileAds.initialize(getActivity(),
//                "ca-app-pub-9585993475666915~8941796348");
//        interstitial = new InterstitialAd(getActivity());
//        interstitial.setAdUnitId("ca-app-pub-9585993475666915/2246178449");
//        interstitial.loadAd(new AdRequest.Builder().build());
//
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
            public void onResponse(Call<QuranResponse> call, final Response<QuranResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    surahs = (ArrayList<Surahs>) response.body().getData().getSurahs();
                    AdpterForRecycler adpterForRecycler = new AdpterForRecycler(getContext(), surahs, recyclerViewClickInterface);
                    progressBar.setVisibility(View.GONE);
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

    public void chooce(final int position) {
        AlertDialog.Builder ab = new AlertDialog.Builder(getContext());
        ab.setNegativeButton("read", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent goforreading = new Intent(getContext().getApplicationContext(), Reading.class);
                Toast.makeText(getActivity(), surahs.get(position).getName(), Toast.LENGTH_SHORT).show();
              //  prepareAd();
                goforreading.putExtra("done", (Serializable) surahs.get(position));
                startActivity(goforreading);
            }
        }).setPositiveButton("listening", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getContext().getApplicationContext(), TestForAbdAlBAST.class);
                intent.putExtra("bast", linksOFsoundes().get(position));
               // prepareAd();
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

    public ArrayList<String> linksOFsoundes() {

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/001.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/002.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/003.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/004.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/005.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/006.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/007.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/008.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/009.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/010.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/011.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/012.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/013.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/014.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/015.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/016.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/017.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/018.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/019.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/020.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/021.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/022.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/023.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/024.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/025.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/026.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/027.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/028.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/029.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/030.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/031.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/032.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/033.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/034.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/035.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/036.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/037.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/038.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/039.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/040.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/041.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/042.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/043.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/044.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/045.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/046.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/047.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/048.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/049.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/050.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/051.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/052.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/053.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/054.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/055.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/056.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/057.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/058.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/059.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/060.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/061.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/062.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/063.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/064.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/065.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/066.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/067.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/068.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/069.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/070.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/071.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/072.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/073.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/074.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/075.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/076.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/077.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/078.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/079.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/080.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/081.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/082.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/083.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/084.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/085.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/086.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/087.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/088.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/089.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/090.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/091.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/092.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/093.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/094.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/095.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/096.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/097.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/098.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/099.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/100.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/101.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/102.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/103.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/104.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/105.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/106.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/107.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/108.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/109.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/110.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/111.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/112.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/113.mp3");
        arrayList.add("https://download.tvquran.com/download/TvQuran.com__Abdulbasit_Warsh/114.mp3");
        return arrayList;
    }

}