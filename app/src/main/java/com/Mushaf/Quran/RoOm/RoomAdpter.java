package com.Mushaf.Quran.RoOm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mushaf.quran.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RoomAdpter extends RecyclerView.Adapter<RoomAdpter.Boxvh> {


    public RoomAdpter(ArrayList<Tableforpersons> tableforpersons) {
        this.tableforpersons = tableforpersons;
    }

    RoomAdpter roomAdpter;
    BuildTableOFpersones buildTableOFpersones;
    ArrayList<Tableforpersons> tableforpersons;


    @NonNull
    @Override
    public Boxvh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_for_fivi_men, parent, false);
        buildTableOFpersones = BuildTableOFpersones.getInstance(v.getContext());

        return new Boxvh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final Boxvh holder, final int position) {
        final Tableforpersons objectfromtable = tableforpersons.get(position);

        holder.job.setText(objectfromtable.getJob());
        holder.name.setText(objectfromtable.getName());
        Picasso.get().load(String.valueOf(objectfromtable.getPhoto())).into(holder.imageView);
        holder.ratingBar.setRating(objectfromtable.getRat());

    }

    @Override
    public int getItemCount() {
        return tableforpersons.size();
    }

    public class Boxvh extends RecyclerView.ViewHolder {

        TextView name;
        TextView job;
        ImageView imageView;
        RatingBar ratingBar;

        public Boxvh(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_only);
            imageView = itemView.findViewById(R.id.test_photo);
            job = itemView.findViewById(R.id.job_only);
            ratingBar = itemView.findViewById(R.id.rta_db);


        }
    }
}

