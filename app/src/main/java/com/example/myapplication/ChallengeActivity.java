package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ChallengeActivity extends AppCompatActivity {
    private myDb db;
    private goalAdapter goalAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        db = new myDb(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        goalAdapter = new goalAdapter(this,db.getAllGoal());
        recyclerView.setAdapter(goalAdapter);
        goalAdapter.notifyDataSetChanged();
    }
    public void ADD(View e){
        Intent intent = new Intent(this, setgoal.class);
        startActivity(intent);


       /*LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_main, null);
        ViewGroup parent = findViewById(R.id.linearLayout1);
        parent.addView(view, 0);*/

    }
}