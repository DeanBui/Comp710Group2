package com.example.duyqu.comp710group2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText userNameBox, passwordBox, statusBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameBox = (EditText) findViewById(R.id.editTextUserName);
        passwordBox = (EditText) findViewById(R.id.editTextPassword);
        statusBox = (EditText) findViewById(R.id.editTextOccupation);
    }


    public void register(View view) {
        LoginDB dbHandler = new LoginDB(this, null, null, 1);
        Account account = new Account(userNameBox.getText().toString(), passwordBox.getText().toString());
        dbHandler.addPassword(account);
        statusBox.setText("Success Register");

    }



    public void login(View view){
        LoginDB dbHandler = new LoginDB(this, null, null, 1);
        boolean result = false;

        result = dbHandler.loginCheck(userNameBox.getText().toString(), passwordBox.getText().toString());

        if(result){
            final Intent ProfileIntent = new Intent(this, UserProfileActivity.class);
            startActivity(ProfileIntent);


        }
        else{

            statusBox.setText("Login False");
        }

    }

}



