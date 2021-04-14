package com.example.christmasshop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class NYlightsActivity extends AppCompatActivity {
    private ListView listViewGarlands;
    private ArrayList<Garlends> garlands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_ylights);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        garlands = new ArrayList<>();
        garlands.add(new Garlends(getString(R.string.blue_garland_title), getString(R.string.blue_garland_info), R.drawable.bluegarlend));
        garlands.add(new Garlends(getString(R.string.multi_garland_title), getString(R.string.multi_garland_info), R.drawable.mixgarlend));
        garlands.add(new Garlends(getString(R.string.chameleon_garland_title), getString(R.string.chameleon_garland_info), R.drawable.multigarlend));
        listViewGarlands = findViewById(R.id.ListViewGarlend);
        ArrayAdapter<Garlends> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, garlands);
        listViewGarlands.setAdapter(adapter);
        listViewGarlands.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Garlends garlend = garlands.get(position);
                Intent intent = new Intent(getApplicationContext(), LightsDetailActivity.class);
                intent.putExtra("title", garlend.getTitle());
                intent.putExtra("info", garlend.getInfo());
                intent.putExtra("resId", garlend.getImageResourseId());
                startActivity(intent);
            }
        });

    }
}