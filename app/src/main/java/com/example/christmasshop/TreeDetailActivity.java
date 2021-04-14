package com.example.christmasshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TreeDetailActivity extends AppCompatActivity {
    private TextView textViewTitle;
    private TextView textViewInfo;
    private ImageView imageViewTree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        textViewInfo = findViewById(R.id.textViewInfo);
        textViewTitle = findViewById(R.id.textViewTitle);
        imageViewTree = findViewById(R.id.imageViewRedTree);
        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId", -1);
            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewTree.setImageResource(resId);
        } else {
            Intent backToCategory = new Intent(this, NYTreeActivity.class);
            startActivity(backToCategory);
        }
    }
}