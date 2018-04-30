package com.example.duyqu.comp710group2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class SelectValueActivity extends AppCompatActivity {
    CheckBox BoxCommunication,BoxHonestly, BoxFamily, BoxMobogamy, BoxReligion,BoxStability,BoxSuccess,BoxWealth,BoxAdventure,BoxLove;

    CheckBox BoxHumor,BoxLeadership, BoxIntimacy, BoxSecurity , BoxRespect,BoxDependability, BoxCleanliness, BoxPhysical,BoxThoughtfulness ,BoxUniqueness;

    Button findMatchButton;

    private int group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_value);

        BoxCommunication= (CheckBox)findViewById(R.id.checkBoxCommunication);
        BoxHonestly= (CheckBox)findViewById(R.id.checkBoxHonestly);
        BoxMobogamy= (CheckBox)findViewById(R.id.checkBoxMobogamy);
        BoxFamily= (CheckBox)findViewById(R.id.checkBoxFamily);
        BoxReligion= (CheckBox)findViewById(R.id.checkBoxReligion);
        BoxStability= (CheckBox)findViewById(R.id.checkBoxStability);
        BoxSuccess= (CheckBox)findViewById(R.id.checkBoxSuccess);
        BoxWealth= (CheckBox)findViewById(R.id.checkBoxWealth);
        BoxAdventure= (CheckBox)findViewById(R.id.checkBoxAdventure);
        BoxLove= (CheckBox)findViewById(R.id.checkBoxLove);


        BoxHumor= (CheckBox)findViewById(R.id.checkBoxHumor);
        BoxLeadership= (CheckBox)findViewById(R.id.checkBoxLeadership);
        BoxIntimacy= (CheckBox)findViewById(R.id.checkBoxIntimacy);
        BoxSecurity= (CheckBox)findViewById(R.id.checkBoxSecurity);
        BoxRespect= (CheckBox)findViewById(R.id.checkBoxRespect);
        BoxDependability= (CheckBox)findViewById(R.id.checkBoxDependability);
        BoxCleanliness= (CheckBox)findViewById(R.id.checkBoxCleanliness);
        BoxPhysical= (CheckBox)findViewById(R.id.checkBoxPhysical);
        BoxThoughtfulness= (CheckBox)findViewById(R.id.checkBoxThoughtfulness);
        BoxUniqueness= (CheckBox)findViewById(R.id.checkBoxUniqueness);

        findMatchButton = (Button) findViewById(R.id.buttonMatch);
    }

    public void submit(View view){
        int group1 = 0 , group2 =0 ;

        if(BoxCommunication.isChecked()){
            group1 ++;
        }
        if(BoxHonestly.isChecked()){
            group1 ++;
        }
        if(BoxMobogamy.isChecked()){
            group1 ++;
        }
        if(BoxReligion.isChecked()){
            group1 ++;
        }
        if(BoxStability.isChecked()){
            group1 ++;
        }
        if(BoxSuccess.isChecked()){
            group1 ++;
        }
        if(BoxWealth.isChecked()){
            group1 ++;
        }
        if(BoxAdventure.isChecked()){
            group1 ++;
        }
        if(BoxLove.isChecked()){
            group1 ++;
        }
        if(BoxFamily.isChecked()){
            group1 ++;
        }




        if( BoxHumor.isChecked()){
            group2 ++;
        }
        if(BoxLeadership.isChecked()){
            group2 ++;
        }
        if(BoxIntimacy.isChecked()){
            group2 ++;
        }
        if(BoxSecurity.isChecked()){
            group2 ++;
        }
        if(BoxRespect.isChecked()){
            group2 ++;
        }
        if(BoxDependability.isChecked()){
            group2 ++;
        }
        if( BoxCleanliness.isChecked()){
            group2 ++;
        }
        if(BoxPhysical.isChecked()){
            group2 ++;
        }
        if(BoxThoughtfulness.isChecked()){
            group2 ++;
        }
        if(BoxUniqueness.isChecked()){
            group2 ++;
        }




        if(group1 >= group2){
            group = 1;
        }
        else{
            group = 2;

        }

        String Email, Occupation, name;
        int age;

        Bundle extras = getIntent().getExtras();

        Email = extras.getString("email");
        Occupation =extras.getString("occupation");
        age = extras.getInt("age");
        name = extras.getString("name");
        //The key argument here must match that used in the other activity


        Profile userProfile = new Profile(Email,age,Occupation,group,name);

        ProfileDB dbHandler = new ProfileDB(this, null, null, 1);
        dbHandler.addProfile(userProfile);
        System.out.print("This is email:" + Email);
        findMatchButton.setVisibility(View.VISIBLE);
    }

    public void findMatch(View view){
        final Intent SelectIntent = new Intent(this, MatchActivity.class);
        SelectIntent.putExtra("group",group);
        startActivity(SelectIntent);
    }
}
