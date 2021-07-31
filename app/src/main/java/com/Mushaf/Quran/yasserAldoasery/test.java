package com.Mushaf.Quran.yasserAldoasery;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mushaf.quran.R;

import java.io.IOException;
public class test extends AppCompatActivity {
    ImageView btn;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;
TextView elasedtimelable;
TextView reminigtimelable;
    Handler handler=new Handler();
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    elasedtimelable =findViewById(R.id.start_music);
    btn = findViewById(R.id.ply);
    seekBar=findViewById(R.id.myseek);
    reminigtimelable =findViewById(R.id.end_music);
    mediaPlayer = new MediaPlayer();

    seekBar.setMax(110);


    Intent intent = getIntent();
    String all = intent.getStringExtra("all");
    try {
        mediaPlayer.setDataSource(all);
        mediaPlayer.prepare();
        elasedtimelable.setText(milliSecndsToTime(Long.valueOf(mediaPlayer.getDuration())));


    } catch (IOException e) {
        e.printStackTrace();
    }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {

                    mediaPlayer.start();
                    btn.setImageResource(R.drawable.ic_pause_black_24dp);
                    Toast.makeText(test.this, "playinig ♥ ", Toast.LENGTH_SHORT).show();
updataseekbar();
                } else {
handler.removeCallbacks(updatar);
                    mediaPlayer.pause();
                    btn.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    Toast.makeText(test.this, "pause", Toast.LENGTH_SHORT).show();
                }
            }
        });

seekBar.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        SeekBar seekBar=(SeekBar)v;
        int  playposition=(mediaPlayer.getDuration()/110)*seekBar.getProgress();
        mediaPlayer.seekTo(playposition);
        elasedtimelable.setText(milliSecndsToTime(Long.valueOf(mediaPlayer.getCurrentPosition())));
        return false;
    }
});
}

private Runnable updatar=new Runnable() {
    @Override
    public void run() {
  updataseekbar();
  long currentp=mediaPlayer.getCurrentPosition();
  elasedtimelable.setText(milliSecndsToTime(currentp));
    }
};
    private void updataseekbar(){
if (mediaPlayer.isPlaying()){
    seekBar.setProgress((int)(((float)mediaPlayer.getCurrentPosition()/mediaPlayer.getDuration()) *100));
    handler.postDelayed(updatar,1000);
}
}
    private  String milliSecndsToTime(Long milliSeconds) {

        String timerstring = "";
        String secondesstring = "";

        int hours = (int) (milliSeconds / (1000 * 60 * 60));
        int minutes = (int) (milliSeconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) (milliSeconds % (1000 * 60 * 60)) % (1000 * 60) / 1000;
        if (hours > 0) {

            timerstring = hours + ":";
        } else if (seconds < 10) {
            secondesstring = "0" + seconds;
        } else {
            secondesstring = "" + seconds;
        }
        timerstring = timerstring + minutes + ":" + secondesstring;
        return timerstring;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.start();
    }


}