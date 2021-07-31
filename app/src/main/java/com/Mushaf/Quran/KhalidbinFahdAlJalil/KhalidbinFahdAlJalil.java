package com.Mushaf.Quran.KhalidbinFahdAlJalil;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.Mushaf.Quran.BookmarkKhaild;
import com.Mushaf.Quran.Rcycel.AdpterForPager;
import com.Mushaf.Quran.RoOm.BuildTableOFpersones;
import com.Mushaf.Quran.RoOm.Tableforpersons;
import com.airbnb.lottie.LottieAnimationView;
import com.mushaf.quran.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class KhalidbinFahdAlJalil extends AppCompatActivity {
    RatingBar ratingBar6;
    VideoView vv6;
    AdpterForPager adpterForPager6;
    ViewPager viewPager6;
    TabLayout tabLayout6;
    String paht="https://static10.tgstat.ru/channels/_0/50/5013d488738c5218de7e223c7df207cb.jpg";
    //  float rat=1;
    String name="khalid bin fahd al jalil";
    String job="reader";
    BuildTableOFpersones buildTableOFpersones;
    ArrayList<Tableforpersons> tableforpersons1;
    float rat=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khalidbin_fahd_al_jalil);

        ratingBar6=findViewById(R.id.myritnga_kh);
        vv6=findViewById(R.id.my_first_videoa_kh);
        viewPager6=findViewById(R.id.my_tv_pageraa_kh);
        tabLayout6=findViewById(R.id.my_taba_kh);
        adpterForPager6=new AdpterForPager(getSupportFragmentManager());
        adpterForPager6.addfragment(new play_khalidbin(),"Mushaf");
        adpterForPager6.addfragment(new Story_for_khaild(),"status");
        adpterForPager6.addfragment(new BookmarkKhaild(),"Bookmark");
        viewPager6.setAdapter(adpterForPager6);
        tabLayout6.setupWithViewPager(viewPager6);

         rat=ratingBar6.getRating();
        ratingBar6.setOnRatingBarChangeListener( new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getBaseContext(), "your rating"+rating, Toast.LENGTH_SHORT).show();
                rat=rating;
            }
        });
       buildTableOFpersones= BuildTableOFpersones.getInstance(getBaseContext());
        final LottieAnimationView mylot=findViewById(R.id.animation_view1_kh);
        mylot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mylot.isPressed()){
                    mylot.playAnimation();
                    Toast.makeText(getBaseContext(), "add to Favorite", Toast.LENGTH_SHORT).show();
                    //////////////////////////////////////////////////////////////
                    tableforpersons1 =new ArrayList<>();
                    tableforpersons1.add(new Tableforpersons(name,job,paht,rat));
                    buildTableOFpersones.tableDao().insertdata(tableforpersons1);
                    //  final List<Tableforpersons> show=buildTableOFpersones.tableDao().getall();
                  //  Toast.makeText(getBaseContext(), show.get(1).getJob(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        String path="android.resource://"+getPackageName()+"/"+R.raw.kh1;
        Uri uri=Uri.parse(path);
        vv6.setVideoURI(uri);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(vv6);
        vv6.setMediaController(mediaController);
        vv6.start();


    }
}
