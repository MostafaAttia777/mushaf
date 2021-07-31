package com.Mushaf.Quran.Reader;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.Mushaf.Quran.AbdAlbast.AbdAlbast;
import com.Mushaf.Quran.Almanshay.ALmanshay;
import com.Mushaf.Quran.KhalidbinFahdAlJalil.KhalidbinFahdAlJalil;
import com.Mushaf.Quran.MyFviv;
import com.Mushaf.Quran.NetworkConnactivityrecever;
import com.Mushaf.Quran.Rcycel.Language;
import com.Mushaf.Quran.Tblway.Tablawy;
import com.Mushaf.Quran.yasserAldoasery.info_yasser;
import com.mushaf.quran.R;

public class MainActivity extends AppCompatActivity {
    Button yasser;
    Button almanshoy;
    Button AlTablawy;
    Button bast;
    Button KhalidJalil;
    NetworkConnactivityrecever networkConnactivityrecever;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        networkConnactivityrecever = new NetworkConnactivityrecever();
        registerReceiver(networkConnactivityrecever, intentFilter);

        yasser = findViewById(R.id.btn_number_one);
        almanshoy = findViewById(R.id.btn_number_two);
        AlTablawy = findViewById(R.id.btn_number_three);
        bast = findViewById(R.id.btn_number_for);
        KhalidJalil = findViewById(R.id.btn_number_six);


        yasser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), info_yasser.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "yasser Al doassry ♥", Toast.LENGTH_SHORT).show();

            }
        });
        almanshoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ALmanshay.class);
                Toast.makeText(MainActivity.this, "ALmanshay ♥", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


        AlTablawy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tablawy.class);
                Toast.makeText(MainActivity.this, "AlTablawy ♥", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        bast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AbdAlbast.class);
                Toast.makeText(MainActivity.this, "Abdul Basit AbdulSamad ♥", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        KhalidJalil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, KhalidbinFahdAlJalil.class);
                Toast.makeText(MainActivity.this, "Khalid bin Fahd Al Jalil ♥", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


        Toolbar toolbar = findViewById(R.id.usebar);

        toolbar.setTitle(getResources().getString(R.string.app_name));

        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.mymenue, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.my_setting:
                Intent intent = new Intent(MainActivity.this, Language.class);
                startActivity(intent);
                return true;
            case R.id.my_Favorite:
                Intent intent1fivf = new Intent(getBaseContext(), MyFviv.class);
                startActivity(intent1fivf);
                return true;
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "سبحان الله وبحمده سبحان الله العظيم", Toast.LENGTH_SHORT).show();
    }


}
