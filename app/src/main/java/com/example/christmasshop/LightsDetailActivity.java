package com.example.christmasshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LightsDetailActivity extends AppCompatActivity {
    private TextView textViewTitleGarl;
    private TextView textViewInfoGarl;
    private ImageView imageViewGarl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        textViewInfoGarl = findViewById(R.id.textViewInfoLights);
        textViewTitleGarl = findViewById(R.id.textViewTitleLights);
        imageViewGarl = findViewById(R.id.imageViewGarl);
        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);
            textViewTitleGarl.setText(title);
            textViewInfoGarl.setText(info);
            imageViewGarl.setImageResource(resId);
        } else {
            Intent backToCategory = new Intent(this, NYlightsActivity.class);
            startActivity(backToCategory);
        }

    }
}