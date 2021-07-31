package com.Mushaf.Quran.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.Mushaf.Quran.Reader.MainActivity;
import com.mushaf.quran.R;

public class Mysplash_screen extends AppCompatActivity {
Animation top_animtion,bottom_animtion;
LottieAnimationView lo;
TextView logo;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysplash_screen);
        top_animtion= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottom_animtion= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        lo=findViewById(R.id.myi);
       logo=findViewById(R.id.my_quran);
      lo.setAnimation(top_animtion);
       logo.setAnimation(bottom_animtion);


    MediaPlayer  dp= MediaPlayer.create(Mysplash_screen.this,R.raw.k);

    dp.start();

   Thread thread=new Thread(new Runnable() {
       @Override
       public void run() {
           try {

               Thread.sleep(6000);
               Intent intent=new Intent(getBaseContext(), MainActivity.class);
               startActivity(intent);
               finish();

           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   });
   thread.start();

}

}
