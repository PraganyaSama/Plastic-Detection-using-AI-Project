package com.example.detect;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.detect.R;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private GalleryPagerAdapter adapter; // Update to use correct package
    private ArrayList<String> uriStringList;
    private int initialPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        viewPager = findViewById(R.id.viewPager);
        Intent intent = getIntent();
        uriStringList = intent.getStringArrayListExtra("photoUris");
        initialPosition = intent.getIntExtra("position", 0);

        adapter = new GalleryPagerAdapter(this, uriStringList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(initialPosition, false);
    }
}
