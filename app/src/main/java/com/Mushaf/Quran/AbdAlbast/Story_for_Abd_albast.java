package com.Mushaf.Quran.AbdAlbast;


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

import com.mushaf.quran.R;
import com.Mushaf.Quran.Online.web2;


public class Story_for_Abd_albast extends Fragment {
    Button btn_one, btn_two, btn_three, btn_for,link3;
    VideoView v1, v2, v3, v4;
    Uri uri;
    MediaController mediaController;



    public Story_for_Abd_albast() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        link3 = view.findViewById(R.id.links_b);
        btn_one = view.findViewById(R.id.play_number_one_b);
        btn_two = view.findViewById(R.id.play_number_two_b);
        btn_three = view.findViewById(R.id.play_number_three_b);
        btn_for = view.findViewById(R.id.play_number_for_b);
        v1 = view.findViewById(R.id.video_number_one_b);
        v2 = view.findViewById(R.id.video_number_two_b);
        v3 = view.findViewById(R.id.video_number_three_b);
        v4 = view.findViewById(R.id.video_number_for_b);



        String path = "android.resource://" + getContext().getPackageName() + "/" + R.raw.past4;
        uri = Uri.parse(path);
        v1.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v1);
        v1.setMediaController(mediaController);

        String path2 = "android.resource://" + getContext().getPackageName() + "/" + R.raw.past1;
        uri = Uri.parse(path2);
        v2.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v2);
        v2.setMediaController(mediaController);

        String path3 = "android.resource://" + getContext().getPackageName() + "/" + R.raw.past2;
        uri = Uri.parse(path3);
        v3.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v3);
        v3.setMediaController(mediaController);
        String path4 = "android.resource://" + getContext().getPackageName() + "/" + R.raw.past3;
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


        link3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotonew4 = new Intent(getContext(), web2.class);
                Toast.makeText(getContext(), "opening now ♥", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "youtube♥", Toast.LENGTH_SHORT).show();
                gotonew4.putExtra("b1","https://www.youtube.com/user/AbdulbasitOfficial");
                startActivity(gotonew4);
            }
        });
    }
}

