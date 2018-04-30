package com.example.duyqu.comp710group2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserProfileActivity extends AppCompatActivity {
    EditText emailBox, occupationBox, ageBox, nameBox;

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        emailBox = (EditText) findViewById(R.id.editTextEmail);
        occupationBox = (EditText) findViewById(R.id.editTextOccupation);
        ageBox = (EditText) findViewById(R.id.editTextAge);
        nameBox = (EditText) findViewById(R.id.editTextName);
    }

    public void submit(View view) {


        final Intent SelectIntent = new Intent(this, SelectValueActivity.class);
        SelectIntent.putExtra("email",emailBox.getText().toString());
        SelectIntent.putExtra("occupation",occupationBox.getText().toString());
        SelectIntent.putExtra("age",Integer.parseInt(ageBox.getText().toString()));
        SelectIntent.putExtra("name",nameBox.getText().toString());


        startActivity(SelectIntent);

    }
}
