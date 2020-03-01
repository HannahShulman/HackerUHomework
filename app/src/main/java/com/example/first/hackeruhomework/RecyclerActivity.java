package com.example.first.hackeruhomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView rv = findViewById(R.id.rv);
        final PersonAdapter adapter = new PersonAdapter();
        rv.setAdapter(adapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Person newPerson = new Person("Barak", "LoNora");
                newPerson.setAge(23);
                newPerson.setGender('M');
                adapter.addPerson(newPerson);
            }
        }, 5000);
    }
}
