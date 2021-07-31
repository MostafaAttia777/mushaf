package com.Mushaf.Quran.KhalidbinFahdAlJalil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

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


public class play_khalidbin extends Fragment {
    ArrayList<Surahs> surahs;
    RecyclerView rc;
    ProgressBar progressBar;
    //private InterstitialAd interstitial;

    RecyclerViewClickInterface recyclerViewClickInterface = new RecyclerViewClickInterface() {
        @Override
        public void onItemClick(final int position) {
            chooce(position);

        }
    };

    public play_khalidbin() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_play_khalidbin, container, false);
        rc = v.findViewById(R.id.my_mushaf_recycler_kh);
        progressBar = v.findViewById(R.id.my_pp_kh);

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

    private void chooce(final int position) {
        AlertDialog.Builder ab = new AlertDialog.Builder(getContext());
        ab.setNegativeButton("read", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent goforreading = new Intent(getContext().getApplicationContext(), Reading.class);

                Toast.makeText(getActivity(), surahs.get(position).getName(), Toast.LENGTH_SHORT).show();
         //       prepareAd();

                goforreading.putExtra("done", (Serializable) surahs.get(position));
                startActivity(goforreading);
            }
        }).setPositiveButton("listening", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getContext().getApplicationContext(), Test_for_khaild.class);
                intent.putExtra("khh", linksOFsoundes().get(position));
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
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/001.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/002.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/003.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/004.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/005.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/006.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/007.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/008.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/009.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/010.mp3");

        arrayList.add("https://download.tvquran.com/download/recitations/21/252/011.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/012.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/013.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/014.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/015.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/016.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/017.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/018.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/019.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/020.mp3");

        arrayList.add("https://download.tvquran.com/download/recitations/21/252/021.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/022.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/023.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/024.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/025.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/026.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/027.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/028.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/029.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/030.mp3");

        arrayList.add("https://download.tvquran.com/download/recitations/21/252/031.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/032.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/033.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/034.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/035.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/036.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/037.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/038.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/039.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/040.mp3");

        arrayList.add("https://download.tvquran.com/download/recitations/21/252/041.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/042.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/043.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/044.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/045.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/046.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/047.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/048.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/049.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/050.mp3");

        arrayList.add("https://download.tvquran.com/download/recitations/21/252/051.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/052.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/053.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/054.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/055.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/056.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/057.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/058.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/059.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/060.mp3");

        arrayList.add("https://download.tvquran.com/download/recitations/21/252/061.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/062.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/063.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/064.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/065.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/066.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/067.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/068.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/069.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/070.mp3");

        arrayList.add("https://download.tvquran.com/download/recitations/21/252/071.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/072.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/073.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/074.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/075.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/076.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/077.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/078.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/079.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/080.mp3");

        arrayList.add("https://download.tvquran.com/download/recitations/21/252/081.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/082.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/083.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/084.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/085.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/086.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/087.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/088.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/089.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/090.mp3");

        arrayList.add("https://download.tvquran.com/download/recitations/21/252/091.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/092.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/093.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/094.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/095.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/096.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/097.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/098.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/099.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/100.mp3");

        arrayList.add("https://download.tvquran.com/download/recitations/21/252/101.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/102.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/103.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/104.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/105.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/106.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/107.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/108.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/109.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/110.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/111.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/112.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/113.mp3");
        arrayList.add("https://download.tvquran.com/download/recitations/21/252/114.mp3");

        return arrayList;
    }


}
