package com.example.duyqu.comp710group2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MatchActivity extends AppCompatActivity {
    ArrayList<Profile> profiles ;
    int group;

    EditText emailBox, occupationBox, ageBox, nameBox;
    int matchNumber = 0;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

       ProfileDB dbHandler = new ProfileDB(this, null, null, 1);

        Bundle extras = getIntent().getExtras();
        group = extras.getInt("group");


        profiles = dbHandler.findMatch(group);

        Profile temp ;

        temp = profiles.get(matchNumber);


        occupationBox = (EditText) findViewById(R.id.editTextOccupation);
        ageBox = (EditText) findViewById(R.id.editTextAge);
        nameBox = (EditText) findViewById(R.id.editTextName);

        occupationBox.setText("Computer Science ");
        ageBox.setText(Integer.toString(temp.getAge()));
        nameBox.setText(temp.getName());


    }

    public void nextMatch(View view){
        matchNumber ++;
        Profile temp;

        temp = profiles.get(matchNumber);

        occupationBox.setText(temp.getOccupation());
        ageBox.setText(Integer.toString(temp.getAge()));
        nameBox.setText(temp.getName());
    }
}
