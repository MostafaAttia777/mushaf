package com.Mushaf.Quran.yasserAldoasery;

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

public class ForMyStory extends Fragment {
    Button btn_one, btn_two, btn_three, btn_for,link1;
    VideoView v1, v2, v3, v4;
    Uri uri;
    MediaController mediaController;

    public ForMyStory() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_story, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        link1 = view.findViewById(R.id.links);
        btn_one = view.findViewById(R.id.play_number_one);
        btn_two = view.findViewById(R.id.play_number_two);
        btn_three = view.findViewById(R.id.play_number_three);
        btn_for = view.findViewById(R.id.play_number_for);
        v1 = view.findViewById(R.id.video_number_one);
        v2 = view.findViewById(R.id.video_number_two);
        v3 = view.findViewById(R.id.video_number_three);
        v4 = view.findViewById(R.id.video_number_for);
        String path = "https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/ys1.mp4?alt=media&token=f705fb09-857f-44af-b6f0-7b01d8f0a974";
        uri = Uri.parse(path);
        v1.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v1);
        v1.setMediaController(mediaController);

        String path2 = "https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/ys2.mp4?alt=media&token=44e8f062-779c-4f92-a41f-5f3e09ff9b9e";
        uri = Uri.parse(path2);
        v2.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v2);
        v2.setMediaController(mediaController);

        String path3 = "https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/yas.mp4?alt=media&token=5c487bdf-db09-4a4d-93e9-e42418ef2c30";
        uri = Uri.parse(path3);
        v3.setVideoURI(uri);
        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(v3);
        v3.setMediaController(mediaController);
        String path4 = "https://firebasestorage.googleapis.com/v0/b/mostafa-20cc3.appspot.com/o/ys3.mp4?alt=media&token=7c4df54c-fdb2-4d51-93aa-74abb0446042";
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
                Intent gotonew1 = new Intent(getContext(), web2.class);
                Toast.makeText(getContext(), "opening noew ♥", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "youtube♥", Toast.LENGTH_SHORT).show();
                gotonew1.putExtra("y1","https://www.youtube.com/user/shda1016");
                startActivity(gotonew1);

            }
        });
    }
}

