package com.example.standardtablayoutwithviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.standardtablayoutwithviewpager.fragment.First;
import com.example.standardtablayoutwithviewpager.fragment.Snd;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_launcher_round).setText("First"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_launcher_round).setText("Snd"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { //when you select a tab
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //below inside fragment we use getChildFragmentManager()
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new First();
                    case 1:
                        return new Snd();
                }
                return null;
            }

            @Override
            public int getCount() {//how much fragment you want
                return 2;
            }
        };
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));//atar mane hosse fragment scroll er sathe tab o change hobe.
        //if you want to change something new below this is the function
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //if you want to change something new
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
