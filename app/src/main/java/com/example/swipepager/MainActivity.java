package com.example.swipepager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        List<String> list = new ArrayList<>();
        list.add("First Screen");
        list.add("Second Screen");
        list.add("Third Screen");
        list.add("Fourth Screen");

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, list, viewPager);
        viewPager.setAdapter(recyclerViewAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("OBJECT" + (position + 1))
        ).attach();
    }
}
