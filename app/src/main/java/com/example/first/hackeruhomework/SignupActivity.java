package com.example.first.hackeruhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    Button signupBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

       signupBtn = findViewById(R.id.signup_btn);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save information
                boolean successful = saveUserInfo();
                if (successful){//if successful-> move
                    moveToContacts();
                } else{ //if not -> show toast
                    Toast.makeText(SignupActivity.this, "Something went wrong!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean saveUserInfo(){
        //get information to save
        EditText nameET = findViewById(R.id.editTextName);
        EditText password = findViewById(R.id.editTextPassword);

        //saveInformation
        SharedPreferences preferences = getSharedPreferences(Constants.LOGIN_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constants.LOGIN_NAME_KEY, nameET.getText().toString());
        editor.putString(Constants.LOGIN_PASSWORD_KEY, password.getText().toString());
        return editor.commit();
    }

    private void moveToContacts(){
        Intent intent = new Intent(SignupActivity.this, ContactsActivity.class);
        startActivity(intent);
        finish();
    }
}
