package com.Mushaf.Quran.yasserAldoasery;

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
import com.Mushaf.Quran.BookmarkYasser;
import com.mushaf.quran.R;
import com.Mushaf.Quran.RoOm.BuildTableOFpersones;
import com.Mushaf.Quran.RoOm.Tableforpersons;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class info_yasser extends AppCompatActivity {
RatingBar ratingBar;
VideoView vv;
AdpterForPager adpterForPager;
ViewPager viewPager;
TabLayout tabLayout;
///////////////////////////////////

    String paht="https://i1.sndcdn.com/artworks-000145401866-wf5w9n-t500x500.jpg";
    String name="Yasser bin Rashid Al-Dossary";
    String job="reader";
    BuildTableOFpersones buildTableOFpersones;
    ArrayList<Tableforpersons> tableforpersons1;
    float rat=0;

    // float rat=1;/////////////////////////////////////////////////////////////////
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_yasser);
        ratingBar=findViewById(R.id.myritng);
        vv=findViewById(R.id.my_first_video);
        viewPager=findViewById(R.id.my_tv_pager);
        tabLayout=findViewById(R.id.my_tab);
        buildTableOFpersones= BuildTableOFpersones.getInstance(getBaseContext());
      //  rat=ratingBar.getRating();//////////////////////////////////////////////////////
        adpterForPager=new AdpterForPager(getSupportFragmentManager());
        adpterForPager.addfragment(new ForAllMoshaf(),"Mushaf");
        adpterForPager.addfragment(new ForMyStory(),"status");
        adpterForPager.addfragment(new BookmarkYasser(),"Bookmark");
         viewPager.setAdapter(adpterForPager);
         tabLayout.setupWithViewPager(viewPager);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(info_yasser.this, "your rating"+rating, Toast.LENGTH_SHORT).show();
                rat=rating;


            }
        });
        final LottieAnimationView mylot=findViewById(R.id.animation_view1);
        mylot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mylot.isPressed()){
                    mylot.playAnimation();
                    Toast.makeText(info_yasser.this, "add to Favorite", Toast.LENGTH_SHORT).show();
                    tableforpersons1 =new ArrayList<>();
                    tableforpersons1.add(new Tableforpersons(name,job,paht,rat));
                    buildTableOFpersones.tableDao().insertdata(tableforpersons1);
                }


            }
        });

        String path="android.resource://"+getPackageName()+"/"+R.raw.ys4;
        Uri uri=Uri.parse(path);
        vv.setVideoURI(uri);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(vv);
        vv.setMediaController(mediaController);
        vv.start();




    }
}
