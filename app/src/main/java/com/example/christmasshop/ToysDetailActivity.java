package com.example.christmasshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ToysDetailActivity extends AppCompatActivity {
    private TextView textViewToysTitle;
    private TextView textViewToysInfo;
    private ImageView imageViewToys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toys_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        textViewToysInfo = findViewById(R.id.textViewInfoToys);
        textViewToysTitle = findViewById(R.id.textViewTitleToys);
        imageViewToys = findViewById(R.id.imageViewRedtoy);
        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);
            textViewToysTitle.setText(title);
            textViewToysInfo.setText(info);
            imageViewToys.setImageResource(resId);
        } else {
            Intent backToCategory = new Intent(this, NYtoysActivity.class);
            startActivity(backToCategory);
        }
    }
}