package com.Mushaf.Quran.Rcycel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Mushaf.Quran.Model.Surahs;
import com.mushaf.quran.R;

import java.util.ArrayList;

public class AdpterForRecycler extends RecyclerView.Adapter<AdpterForRecycler.My_View_Holder>  {
Context contexts;
ArrayList<Surahs> theNameOfMushafs;

private RecyclerViewClickInterface recyclerViewClickInterface;

    public AdpterForRecycler(Context contexts, ArrayList<Surahs> theNameOfMushafs, RecyclerViewClickInterface recyclerViewClickInterface) {
        this.contexts = contexts;
        this.theNameOfMushafs = theNameOfMushafs;
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    @NonNull
    @Override
    public My_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(contexts).inflate(R.layout.my_dsigen,parent,false);
        return new My_View_Holder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull My_View_Holder holder, int position) {
        final Surahs c=theNameOfMushafs.get(position);
        holder.tv_naem_of_sora.setText(c.getName());
        holder.tv_kind_of_sora.setText(c.getRevelationType()+"-"+c.getAyahs().size()+"");
        holder.tv_totle_of_page.setText(c.getAyahs().get(0).getPage()+"");
        holder.tv_order_of_mushaf.setText(c.getNumber());

    }

    @Override
    public int getItemCount() {
        return theNameOfMushafs.size();
    }
    class My_View_Holder extends RecyclerView.ViewHolder {
        TextView tv_naem_of_sora;
        TextView tv_kind_of_sora;
        TextView tv_totle_of_page;
        TextView tv_order_of_mushaf;
        public My_View_Holder(@NonNull View itemView) {
            super(itemView);
            tv_naem_of_sora = itemView.findViewById(R.id.name_of_sora);
            tv_kind_of_sora = itemView.findViewById(R.id.kind_of_sora);
            tv_totle_of_page = itemView.findViewById(R.id.number_of_peppr);
            tv_order_of_mushaf = itemView.findViewById(R.id.number);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    recyclerViewClickInterface.onItemClick(getAdapterPosition());

                }
            });


        }


    }


}
