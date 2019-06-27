package com.gradpro.home_automation.smarthomeautomation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class leds extends AppCompatActivity {


    FirebaseDatabase database=FirebaseDatabase.getInstance();
    ToggleButton ledtoggle;
    DatabaseReference ledref=FirebaseDatabase.getInstance().getReference().child("Leds");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leds);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ledtoggle= (ToggleButton) findViewById(R.id.toggleleds);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart ()
    {

        super.onStart();
        ledref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String val = dataSnapshot.getValue(String.class);

                if(val.equals("1")) ledtoggle.setChecked(true);
                else    ledtoggle.setChecked(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        ledtoggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ledref.setValue("1");
                } else {
                   ledref.setValue("0");
                }
            }
        });

    }
}



