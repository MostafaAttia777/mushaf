package com.Mushaf.Quran.Rcycel;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.mushaf.quran.R;

import java.util.Locale;

public class Language extends AppCompatActivity {
    Button lang1;
    Button lang2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        lang1= findViewById(R.id.changelanguage);
        lang2= findViewById(R.id.changelanguage2);

        lang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,0);
                startActivity(getIntent());
                overridePendingTransition(0,0);
                setAppLocale("ar");


            }
        });
        lang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0,0);
                startActivity(getIntent());
                overridePendingTransition(0,0);
                setAppLocale("en");



            }
        });
    }

    private void setAppLocale(String language){


        Locale locale=new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.activity_language);
recreate();


    }


}