package com.example.first.hackeruhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


public class LaunchingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (checkLoggedIn()) {
            sendToContacts();
        } else {
            sendToSignUp();
        }
    }

    private boolean checkLoggedIn(){
        //check shared preferences if log in information
        SharedPreferences preferences = getSharedPreferences(Constants.LOGIN_PREF_NAME, MODE_PRIVATE);
        String name = preferences.getString(Constants.LOGIN_NAME_KEY, Constants.NOT_FOUND);
        String password = preferences.getString(Constants.LOGIN_PASSWORD_KEY, Constants.NOT_FOUND);
        return (!(name.equals(Constants.NOT_FOUND) || password.equals(Constants.NOT_FOUND)));
    }

//    private void send(){
//        Intent intent;
//        if(checkLoggedIn()) intent = new Intent(LaunchingActivity.this, null);
//        else intent = new Intent(LaunchingActivity.this, null);
//        startActivity(intent);//sends user to set activity in intent
//        finish();//deletes activity from stack
//    }

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
