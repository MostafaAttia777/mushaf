package com.Mushaf.Quran.Rcycel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


public class AdpterForPager extends FragmentStatePagerAdapter {
ArrayList<Fragment> fragments=new ArrayList<>();
ArrayList<String> tabname=new ArrayList<>();

    public AdpterForPager(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabname.get(position);
    }

    @Override
    public int getCount() {
        return tabname.size();
    }

    public void addfragment(Fragment fragment,String name){
        this.fragments.add(fragment);
        this.tabname.add(name);

    }
}
