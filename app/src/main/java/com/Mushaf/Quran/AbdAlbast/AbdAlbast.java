package com.Mushaf.Quran.AbdAlbast;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.Mushaf.Quran.Rcycel.AdpterForPager;
import com.airbnb.lottie.LottieAnimationView;
import com.Mushaf.Quran.BookmarkAbdAlbast;
import com.mushaf.quran.R;
import com.Mushaf.Quran.RoOm.BuildTableOFpersones;
import com.Mushaf.Quran.RoOm.Tableforpersons;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class AbdAlbast extends AppCompatActivity {
    RatingBar ratingBar2;
    VideoView vv2;
    AdpterForPager adpterForPager2;
    ViewPager viewPager2;
    TabLayout tabLayout2;
    ////////////////////////////////////////////////////////
  //  byte[] data=R.mipmap.r1;
//    byte[] bitmap={(byte) R.drawable.r1};
//String paht="https://lh3.googleusercontent.com/proxy/TXSHYeAZHr6gb1YHASVgADpPLnI8Ph9qUAtC3N9iwc7WOcIM1PdV3a1l2P4sT6YVzGP7H9EfOa0mPfv3rwARzg0Ew63aBb7gy_KAXIbEesBAzXIoV_GcOX65KEfVBvvmeFCJeblyaUy-OJDUmlstodGdTYDnGtA7VmjsjJyFz7h72ouX3P6l9g";
  String paht="https://i1.sndcdn.com/avatars-000314777026-tllzw6-t500x500.jpg";
    //  float rat=1;
    String name="Abdul Basit Abdul Samad";
    String job="reader";
    BuildTableOFpersones buildTableOFpersones;
    ArrayList<Tableforpersons> tableforpersons1;
    float rat=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abd_albast);
        ratingBar2=findViewById(R.id.myritnga);
        vv2=findViewById(R.id.my_first_videoa);
        viewPager2=findViewById(R.id.my_tv_pageraa);
        tabLayout2=findViewById(R.id.my_taba);
        adpterForPager2=new AdpterForPager(getSupportFragmentManager());
        adpterForPager2.addfragment(new PlayAbdAlabst(),"Mushaf");
        adpterForPager2.addfragment(new Story_for_Abd_albast(),"status");
        adpterForPager2.addfragment(new BookmarkAbdAlbast(),"Bookmark");
        viewPager2.setAdapter(adpterForPager2);
        tabLayout2.setupWithViewPager(viewPager2);

       // rat=ratingBar2.getRating();
        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(AbdAlbast.this, "your rating"+rating, Toast.LENGTH_SHORT).show();
                 rat=rating;
            }
        });
        buildTableOFpersones= BuildTableOFpersones.getInstance(getBaseContext());
        final LottieAnimationView mylot=findViewById(R.id.animation_view1);
        mylot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mylot.isPressed()){
                    mylot.playAnimation();
                   Toast.makeText(AbdAlbast.this, "add to Favorite", Toast.LENGTH_SHORT).show();
                   //////////////////////////////////////////////////////////////
                    tableforpersons1 =new ArrayList<>();
                    tableforpersons1.add(new Tableforpersons(name,job,paht,rat));
                    buildTableOFpersones.tableDao().insertdata(tableforpersons1);

                  //  final List<Tableforpersons> show=buildTableOFpersones.tableDao().getall();
                    //Toast.makeText(AbdAlbast.this, show.get(1).getJob(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        String path="android.resource://"+getPackageName()+"/"+R.raw.h;
        Uri uri=Uri.parse(path);
        vv2.setVideoURI(uri);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(vv2);
        vv2.setMediaController(mediaController);
        vv2.start();



    }

    }

