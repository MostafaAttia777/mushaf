package com.Mushaf.Quran;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mushaf.quran.R;
import com.Mushaf.Quran.RoOm.BuildTableOFpersones;
import com.Mushaf.Quran.RoOm.RoomAdpter;
import com.Mushaf.Quran.RoOm.TableDao;
import com.Mushaf.Quran.RoOm.Tableforpersons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyFviv extends AppCompatActivity implements Serializable {

    RecyclerView recyclerView;
    RoomAdpter roomAdpter;
    BuildTableOFpersones buildTableOFpersones;
    Button button;
    TableDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fviv);
        recyclerView = findViewById(R.id.my_fiv_rc);
        buildTableOFpersones= BuildTableOFpersones.getInstance(getBaseContext());
final List<Tableforpersons> show = buildTableOFpersones.tableDao().getall();

        button =findViewById(R.id.my_delete_btn);

          dao=buildTableOFpersones.tableDao();
        roomAdpter = new RoomAdpter((ArrayList<Tableforpersons>) show);
        recyclerView.setAdapter(roomAdpter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                buildTableOFpersones.tableDao().deleteAll();
                //buildTableOFpersones.tableDao().deletetdata(objectfromtable.get(position));
            }
        });

    }

}
