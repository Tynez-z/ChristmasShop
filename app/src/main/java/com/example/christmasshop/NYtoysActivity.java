package com.example.christmasshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class NYtoysActivity extends AppCompatActivity {
    private ListView listViewToys;
    private ArrayList<Toys> toys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_ytoys);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        toys = new ArrayList<>();
        toys.add(new Toys(getString(R.string.red_toys_title), getString(R.string.red_toys_info), R.drawable.redtoys));
        toys.add(new Toys(getString(R.string.white_toys_title), getString(R.string.white_toys_info), R.drawable.whitetoys));
        toys.add(new Toys(getString(R.string.silver_toys_title), getString(R.string.silver_toys_info), R.drawable.silvertoys));
        listViewToys = findViewById(R.id.ListViewToys);
        ArrayAdapter<Toys> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, toys);
        listViewToys.setAdapter(adapter);
        listViewToys.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toys toy = toys.get(position);
                Intent intent = new Intent(getApplicationContext(), ToysDetailActivity.class);
                intent.putExtra("title", toy.getTitle());
                intent.putExtra("info", toy.getInfo());
                intent.putExtra("resId", toy.getImageResourceId());
                startActivity(intent);
            }
        });
    }
}