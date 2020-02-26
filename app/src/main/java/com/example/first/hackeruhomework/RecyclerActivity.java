package com.example.first.hackeruhomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView rv = findViewById(R.id.rv);
        PersonAdapter adapter = new PersonAdapter();
        rv.setAdapter(adapter);
    }
}
