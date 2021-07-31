package com.Mushaf.Quran.Tblway;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.Mushaf.Quran.Online.web2;
import com.mushaf.quran.R;


public class My_Story_Tablway extends Fragment {
    Button btn_one, btn_two, btn_three, btn_for,link1;
    VideoView v1, v2, v3, v4;
    Uri uri;
    MediaController mediaController;



    public My_Story_Tablway() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View v=inflater.inflate(R.layout.fragment_my__story__tablway,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        link1 = view.findViewById(R.id.links_t);
        btn_one = view.findViewById(R.id.play_number_one_t);
        btn_two = view.findViewById(R.id.play_number_two_t);
        btn_three = view.findViewById(R.id.play_number_three_t);
        btn_for = view.findViewById(R.id.play_number_for_t);
        v1 = view.findViewById(R.id.video_number_one_t);
        v2 = view.findViewById(R.id.video_number_two_t);
        v3 = view.findViewById(R.id.video_number_three_t);
        v4 = view.findViewById(R.id.video_number_for_t);


        String path = "https://firebasestorage.googleapis.com/v0/b/fristdatabase-2e1d9.appspot.com/o/tab1.mp4?alt=media&token=aae6d57b-942c-44fd-b4f0-cd30a81a80d4";
        uri = Uri.parse(path);
        v1.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v1);
        v1.setMediaController(mediaController);

        String path2 = "https://firebasestorage.googleapis.com/v0/b/fristdatabase-2e1d9.appspot.com/o/tab2.mp4?alt=media&token=d28e1840-560c-471a-a72d-093ca1584af4";
        uri = Uri.parse(path2);
        v2.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v2);
        v2.setMediaController(mediaController);

        String path3 = "https://firebasestorage.googleapis.com/v0/b/fristdatabase-2e1d9.appspot.com/o/tab3.mp4?alt=media&token=5ced445d-b1bc-4d81-a4f4-f2d1f8c5d438";
        uri = Uri.parse(path3);
        v3.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v3);
        v3.setMediaController(mediaController);
        String path4 = "https://firebasestorage.googleapis.com/v0/b/fristdatabase-2e1d9.appspot.com/o/tab4.mp4?alt=media&token=85763cfd-7c12-4d3e-bd28-a862d2e51a1d";
        uri = Uri.parse(path4);
        v4.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v4);
        v4.setMediaController(mediaController);

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.start();
            }
        });

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v2.start();
            }
        });
        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v3.start();
            }
        });
        btn_for.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v4.start();
            }
        });


    link1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent gotonew3 = new Intent(getContext(), web2.class);
            Toast.makeText(getContext(), "opening noew ♥", Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), "youtube♥", Toast.LENGTH_SHORT).show();
            gotonew3.putExtra("t3","https://www.youtube.com/results?search_query=%D8%AD%D8%A7%D9%84%D8%A7%D8%AA+%D9%88%D8%A7%D8%AA%D8%B3+%D8%A7%D9%84%D8%B7%D8%A8%D9%84%D8%A7%D9%88%D9%8A");
            startActivity(gotonew3);
        }
    });



}


    }

