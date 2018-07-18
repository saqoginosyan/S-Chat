package com.example.sargis.schat;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sargis.schat.adapters.WelcomePagerAdapter;
import com.example.sargis.schat.models.WelcomeModel;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.background_color));
        }

        final Button skipBtn = findViewById(R.id.skip_btn);
        final ViewPager viewPager = findViewById(R.id.view_pager);
        final WelcomePagerAdapter adapter = new WelcomePagerAdapter(this, getList());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<WelcomeModel> getList() {
        final List<WelcomeModel> list = new ArrayList<>();
        list.add(new WelcomeModel(getString(R.string.txt_one), R.drawable.traffic));
        list.add(new WelcomeModel(getString(R.string.txt_two), R.drawable.group));
        list.add(new WelcomeModel(getString(R.string.txt_three), R.drawable.programmer));
        list.add(new WelcomeModel(getString(R.string.txt_four), R.drawable.shield));
        return list;
    }
}
