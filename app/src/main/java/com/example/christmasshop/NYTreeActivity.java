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

public class NYTreeActivity extends AppCompatActivity {
    private ListView listViewTree;
    private ArrayList<Tree> trees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_y_tree);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        trees = new ArrayList<>();
        trees.add(new Tree(getString(R.string.tree_red_title), getString(R.string.tree_red_info), R.drawable.redel));
        trees.add(new Tree(getString(R.string.tree_sosna_title), getString(R.string.tree_sosna_info), R.drawable.sosna));
        trees.add(new Tree(getString(R.string.tree_sneg_title), getString(R.string.tree_sneg_info), R.drawable.vsnegyel));
        listViewTree = findViewById(R.id.ListViewTree);
        ArrayAdapter<Tree> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, trees);
        listViewTree.setAdapter(adapter);
        listViewTree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tree tree = trees.get(position);
                Intent intent = new Intent(getApplicationContext(), TreeDetailActivity.class);
                intent.putExtra("title", tree.getTitle());
                intent.putExtra("info", tree.getInfo());
                intent.putExtra("resId", tree.getImageResourseId());
                startActivity(intent);
            }
        });

    }
}