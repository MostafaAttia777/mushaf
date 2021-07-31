package com.Mushaf.Quran.Rcycel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Mushaf.Quran.Model.Ayahs;
import com.Mushaf.Quran.Model.Surahs;
import com.mushaf.quran.R;

import java.util.ArrayList;
import java.util.List;

public class AhahsAdpter extends RecyclerView.Adapter<AhahsAdpter.ahaysVH> {

List<Ayahs> ayahs;
ArrayList<Surahs> surahsArrayList;
    public AhahsAdpter(List<Ayahs> ayahs) {
        this.ayahs = ayahs;
    }

    @NonNull
    @Override
    public ahaysVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.ncg_custom_ahya,parent,false);
        return new ahaysVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ahaysVH holder, int position) {
      Ayahs a=ayahs.get(position);
        holder.tv_text_cs.setText(a.getText()+"\n"+"");
        holder.tv_number.setText(String.valueOf(a.getNumberInSurah()));


    }

    @Override
    public int getItemCount() {
        return ayahs.size();
    }

    class  ahaysVH extends RecyclerView.ViewHolder{
        TextView tv_text_cs;
        TextView tv_number;

        public ahaysVH(@NonNull View itemView) {
            super(itemView);
            tv_text_cs=itemView.findViewById(R.id.text_sss);
            tv_number=itemView.findViewById(R.id.just_number_of_ayas);
        }
    }

}
