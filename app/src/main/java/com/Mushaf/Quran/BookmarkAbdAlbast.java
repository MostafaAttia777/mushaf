package com.Mushaf.Quran;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.mushaf.quran.R;


public class BookmarkAbdAlbast extends Fragment {

  //  ArrayList<Surahs> surahs;
//    RecyclerView recyclerView;

    public BookmarkAbdAlbast() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  View view=LayoutInflater.from(getContext()).inflate(R.layout.custome_for_store_in_database,)
             View v=  inflater.inflate(R.layout.fragment_bookmark_abd_albast, container, false);
          //   recyclerView=v.findViewById(R.id.rc_for_store_in_database);

//        Intent intent=getActivity().getIntent();

     //   ArrayList<Surahs> surahs= (ArrayList<Surahs>) intent.getSerializableExtra("store");

       // Serializable surahs=intent.getSerializableExtra("datax");
                  //  adpter_for_store_data =new Adpter_for_store_data(surahs);
                 //   recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
               //    recyclerView.setAdapter(adpter_for_store_data);

        return v;
    }
}
