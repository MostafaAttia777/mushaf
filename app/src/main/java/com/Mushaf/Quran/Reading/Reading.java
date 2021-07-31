package com.Mushaf.Quran.Reading;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Mushaf.Quran.Model.Ayahs;
import com.Mushaf.Quran.Model.Surahs;
import com.Mushaf.Quran.Rcycel.AhahsAdpter;
import com.mushaf.quran.R;

import java.util.List;

public class Reading extends AppCompatActivity {
    Intent income_data;
    RecyclerView recyclerView;
    AhahsAdpter ahahsAdpter;
    List<Ayahs> ayahs;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        recyclerView = findViewById(R.id.my_rv_rv);
        imageButton=findViewById(R.id.btn_save);
      //  final LottieAnimationView mylot = findViewById(R.id.animation_view1_for_read);
        income_data = getIntent();
        final Surahs surahs = (Surahs) income_data.getSerializableExtra("done");
         ayahs = surahs.getAyahs();
        ahahsAdpter = new AhahsAdpter(ayahs);
        recyclerView.setAdapter(ahahsAdpter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
 imageButton.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {

         Toast.makeText(Reading.this, "saved", Toast.LENGTH_SHORT).show();
     }
 });

      /*  mylot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mylot.isPressed()){
                    mylot.playAnimation();
                    Toast.makeText(getApplicationContext(), "add to favort", Toast.LENGTH_SHORT).show();
                } }
        });
       */
    }
}

