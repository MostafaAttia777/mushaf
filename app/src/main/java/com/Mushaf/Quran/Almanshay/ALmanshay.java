package com.Mushaf.Quran.Almanshay;

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
import com.Mushaf.Quran.RoOm.BuildTableOFpersones;
import com.Mushaf.Quran.RoOm.Tableforpersons;
import com.airbnb.lottie.LottieAnimationView;
import com.mushaf.quran.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ALmanshay extends AppCompatActivity {

    //String paht="https://lh3.googleusercontent.com/proxy/TXSHYeAZHr6gb1YHASVgADpPLnI8Ph9qUAtC3N9iwc7WOcIM1PdV3a1l2P4sT6YVzGP7H9EfOa0mPfv3rwARzg0Ew63aBb7gy_KAXIbEesBAzXIoV_GcOX65KEfVBvvmeFCJeblyaUy-OJDUmlstodGdTYDnGtA7VmjsjJyFz7h72ouX3P6l9g";
String paht="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ-wpnAMvydip-w2BKVIn105W0B8YiWuFIkQg&usqp=CAU";
        String name="Muhammad Siddiq Al-Minshawi";
    String job="reader";
    BuildTableOFpersones buildTableOFpersones;
    ArrayList<Tableforpersons> tableforpersons1;
    RatingBar ratingBar2;
    VideoView vv2;
    AdpterForPager adpterForPager2;
    ViewPager viewPager2;
    TabLayout tabLayout2;
    //float rat=1;
    float rat=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almanshay);
       ratingBar2=findViewById(R.id.myritng);
       vv2=findViewById(R.id.my_first_video);
       viewPager2=findViewById(R.id.my_tv_pager2);
       tabLayout2=findViewById(R.id.my_tab2);

        adpterForPager2=new AdpterForPager(getSupportFragmentManager());
        adpterForPager2.addfragment(new Formanshy(),"Mushaf");
        adpterForPager2.addfragment(new Story_for_manshay(),"status");
        adpterForPager2.addfragment(new Bookmark(),"Bookmark");

        viewPager2.setAdapter(adpterForPager2);
        tabLayout2.setupWithViewPager(viewPager2);
        buildTableOFpersones= BuildTableOFpersones.getInstance(getBaseContext());
      //  rat=ratingBar2.getRating();
        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(ALmanshay.this, "your rating"+rating, Toast.LENGTH_SHORT).show();
                rat=rating;
            }
        });
        final LottieAnimationView mylot=findViewById(R.id.animation_view1);
        mylot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mylot.isPressed()){
                    mylot.playAnimation();
                    Toast.makeText(ALmanshay.this, "add to Favorite", Toast.LENGTH_SHORT).show();
                    tableforpersons1 =new ArrayList<>();
                    tableforpersons1.add(new Tableforpersons(name,job,paht,rat));
                    buildTableOFpersones.tableDao().insertdata(tableforpersons1);
                }


            }
        });

        String path="android.resource://"+getPackageName()+"/"+R.raw.masn;
        Uri uri=Uri.parse(path);
        vv2.setVideoURI(uri);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(vv2);
        vv2.setMediaController(mediaController);
        vv2.start();



    }
}
