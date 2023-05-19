package com.example.tabfragmentviewpager.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tabfragmentviewpager.Fragment.CallFragment;
import com.example.tabfragmentviewpager.Fragment.ChatFragment;
import com.example.tabfragmentviewpager.Fragment.FavoriteFragment;
import com.example.tabfragmentviewpager.Fragment.InfoFragment;
import com.example.tabfragmentviewpager.Fragment.LiveFragment;
import com.example.tabfragmentviewpager.Fragment.StatusFragment;
import com.example.tabfragmentviewpager.Fragment.VideocallFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();


    public ViewpagerAdapter(@NonNull FragmentManager fm) {
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
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addfragment(Fragment fragment,String title){
        fragments.add(fragment);
        titles.add(title);
    }
}
