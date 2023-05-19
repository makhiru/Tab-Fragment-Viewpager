package com.example.tabfragmentviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.tabfragmentviewpager.Adapter.ViewpagerAdapter;
import com.example.tabfragmentviewpager.Fragment.BChatFragment;
import com.example.tabfragmentviewpager.Fragment.BHomeFragment;
import com.example.tabfragmentviewpager.Fragment.BProfileFragment;
import com.example.tabfragmentviewpager.Fragment.BRealFragment;
import com.example.tabfragmentviewpager.Fragment.BSearchFragment;
import com.example.tabfragmentviewpager.Fragment.CallFragment;
import com.example.tabfragmentviewpager.Fragment.ChatFragment;
import com.example.tabfragmentviewpager.Fragment.FavoriteFragment;
import com.example.tabfragmentviewpager.Fragment.InfoFragment;
import com.example.tabfragmentviewpager.Fragment.LiveFragment;
import com.example.tabfragmentviewpager.Fragment.StatusFragment;
import com.example.tabfragmentviewpager.Fragment.VideocallFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    FrameLayout frameLayout;
    ViewPager viewPager;
    ViewpagerAdapter adapter;
    BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        frameLayout = findViewById(R.id.framelayout);
        bottomNavigationView = findViewById(R.id.bottombar);
        viewPager = findViewById(R.id.viewpager);

        adapter = new ViewpagerAdapter(getSupportFragmentManager());
        adapter.addfragment(new ChatFragment(), "Chat");
        adapter.addfragment(new StatusFragment(), "Status");
        adapter.addfragment(new CallFragment(), "Call");
        adapter.addfragment(new VideocallFragment(), "Videocall");
        adapter.addfragment(new FavoriteFragment(), "Favorite");
        adapter.addfragment(new InfoFragment(), "Info");
        adapter.addfragment(new LiveFragment(), "Live");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                frameLayout.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.GONE);
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.framelayout, new BHomeFragment()).commit();
                        return true;

                    case R.id.chat:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.framelayout, new BChatFragment()).commit();
                        return true;

                    case R.id.reels:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.framelayout, new BRealFragment()).commit();
                        return true;

                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.framelayout, new BSearchFragment()).commit();
                        return true;

                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().
                                replace(R.id.framelayout, new BProfileFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }
}