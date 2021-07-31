package com.Mushaf.Quran.Almanshay;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class Story_for_manshay extends Fragment {

    Button btn_one, btn_two, btn_three, btn_for,link1;
    VideoView v1, v2, v3, v4;
    Uri uri;
    MediaController mediaController;

    public Story_for_manshay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_story_for_manshay, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        link1 = view.findViewById(R.id.links_m);
        btn_one = view.findViewById(R.id.play_number_one_m);
        btn_two = view.findViewById(R.id.play_number_two_m);
        btn_three = view.findViewById(R.id.play_number_three_m);
        btn_for = view.findViewById(R.id.play_number_for_m);
        v1 = view.findViewById(R.id.video_number_one_m);
        v2 = view.findViewById(R.id.video_number_two_m);
        v3 = view.findViewById(R.id.video_number_three_m);
        v4 = view.findViewById(R.id.video_number_for_m);


        String path = "https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/video1.mp4?alt=media&token=b5a82bf8-ad85-4224-a16b-bf032cf6e11b";
        uri = Uri.parse(path);
        v1.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v1);
        v1.setMediaController(mediaController);

        String path2 = "https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/video2.mp4?alt=media&token=aafb4d9b-fe10-4155-bb56-c72319aa5814";
        uri = Uri.parse(path2);
        v2.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v2);
        v2.setMediaController(mediaController);

        String path3 = "https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/video3.webm?alt=media&token=e69d9c4f-54bb-43be-9ec9-1523c4b74ec0";
        uri = Uri.parse(path3);
        v3.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v3);
        v3.setMediaController(mediaController);
        String path4 = "https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/video4.mp4?alt=media&token=de3d8ec6-a595-4792-9d84-777095e7a38e";
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
                Intent gotonew2 = new Intent(getContext(), web2.class);
                Toast.makeText(getContext(), "opening now ♥", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "youtube♥", Toast.LENGTH_SHORT).show();
                gotonew2.putExtra("man","https://www.youtube.com/channel/UCIvXGNH3LIEeTzABesUq-gg");
                startActivity(gotonew2);
            }
        });
    }
    }
