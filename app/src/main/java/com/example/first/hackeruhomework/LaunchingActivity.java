package com.example.first.hackeruhomework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;


public class LaunchingActivity extends AppCompatActivity {
    Runnable runnable2;
    int counter = 0;
    int count = 0;
    Runnable runnable;
    View view1, view2, view3, view4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        final Handler handler = new Handler();


        runnable = new Runnable() {
            @Override
            public void run() {
                count++;
                if (count <= 30){
                    updateViewColors();
                    handler.postDelayed(runnable, 1000);
                } else {
                    if (checkLoggedIn()) {
                        sendToContacts();
                    } else {
                        sendToSignUp();
                    }
                }
            }
        };
        
        handler.postDelayed(runnable, 1000);

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                if (checkLoggedIn()) {
//                    sendToContacts();
//                } else {
//                    sendToSignUp();
//                }
//            }
//        };
//
//        handler.postDelayed(runnable, 4000);

       // handler.removeCallbacks(runnable);
    }

    private void updateViewColors(){
        view1.setBackgroundColor(getResources().getColor(getRandomColor()));
        view2.setBackgroundColor(getResources().getColor(getRandomColor()));
        view3.setBackgroundColor(getResources().getColor(getRandomColor()));
        view4.setBackgroundColor(getResources().getColor(getRandomColor()));
    }

    private int getRandomColor(){
        ArrayList<Integer> color = new ArrayList<>();
        color.add(R.color.colorAccent);
        color.add(R.color.colorPrimary);
        color.add(R.color.yellow);
        color.add(R.color.red);
        color.add(R.color.green);
        //add colors
        Random random = new Random();
        int pointer = random.nextInt(color.size());
        return color.get(pointer);
    }

    private boolean checkLoggedIn(){
        //check shared preferences if log in information
        SharedPreferences preferences = getSharedPreferences(Constants.LOGIN_PREF_NAME, MODE_PRIVATE);
        String name = preferences.getString(Constants.LOGIN_NAME_KEY, Constants.NOT_FOUND);
        String password = preferences.getString(Constants.LOGIN_PASSWORD_KEY, Constants.NOT_FOUND);
        return (!(name.equals(Constants.NOT_FOUND) || password.equals(Constants.NOT_FOUND)));
    }

    private void sendToSignUp(){
        Intent intent = new Intent(LaunchingActivity.this, SignupActivity.class);
        startActivity(intent);//sends user to set activity in intent
        finish();//deletes activity from stack
    }

    private void sendToContacts(){
        Intent intent = new Intent(LaunchingActivity.this, ContactsActivity.class);
        startActivity(intent);
        finish();
    }
}
