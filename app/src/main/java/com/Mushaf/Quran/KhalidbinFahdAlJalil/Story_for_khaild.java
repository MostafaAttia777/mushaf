package com.Mushaf.Quran.KhalidbinFahdAlJalil;

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


public class Story_for_khaild extends Fragment {
    Button btn_one, btn_two, btn_three, btn_for,link3;
    VideoView v1, v2, v3, v4;
    Uri uri;
    MediaController mediaController;
    public Story_for_khaild() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story_for_khaild, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        link3 = view.findViewById(R.id.links_b_st);
        btn_one = view.findViewById(R.id.play_number_one_b_st);
        btn_two = view.findViewById(R.id.play_number_two_b_st);
        btn_three = view.findViewById(R.id.play_number_three_b_st);
        btn_for = view.findViewById(R.id.play_number_for_b_st);
        v1 = view.findViewById(R.id.video_number_one_b_st);
        v2 = view.findViewById(R.id.video_number_two_b_st);
        v3 = view.findViewById(R.id.video_number_three_b_st);
        v4 = view.findViewById(R.id.video_number_for_b_st);

        String path = "https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/kha1.mp4?alt=media&token=66ff53ce-c804-45de-a253-9bd997aa284e";
        uri = Uri.parse(path);
        v1.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v1);
        v1.setMediaController(mediaController);

        String path2 = "https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/kha2.mp4?alt=media&token=ffce6496-3ed4-4fa8-b5f9-cb372b24174c";
        uri = Uri.parse(path2);
        v2.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v2);
        v2.setMediaController(mediaController);

        String path3 = "https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/kha3.mp4?alt=media&token=db9225a2-1373-450a-bb1b-5648d1ffb5a6";
        uri = Uri.parse(path3);
        v3.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v3);
        v3.setMediaController(mediaController);
        String path4 ="https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/kha4.mp4?alt=media&token=6ae0e40f-5a5a-4dfb-8397-91d0c465bc16";
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
                gotonew4.putExtra("k1","https://www.youtube.com/user/oo2111");
                startActivity(gotonew4);
            }
        });
    }
}
