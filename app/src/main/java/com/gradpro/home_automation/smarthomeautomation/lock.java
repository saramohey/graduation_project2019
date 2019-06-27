package com.gradpro.home_automation.smarthomeautomation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class lock extends AppCompatActivity {

    FirebaseDatabase database=FirebaseDatabase.getInstance();
    ToggleButton wintog;
    ToggleButton dotog;

    DatabaseReference winref=FirebaseDatabase.getInstance().getReference().child("Windows");
    DatabaseReference doref=FirebaseDatabase.getInstance().getReference().child("Doors");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        wintog= (ToggleButton) findViewById(R.id.windowtoggle);
        dotog= (ToggleButton) findViewById(R.id.doortoggle);
        setSupportActionBar(toolbar);

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        winref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String valw = dataSnapshot.getValue(String.class);

                    if(valw.equals("1")) wintog.setChecked(true);
                    else    wintog.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            wintog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        winref.setValue("1");
                    } else {
                        winref.setValue("0");
                    }
                }
            });
            doref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String vald = dataSnapshot.getValue(String.class);

                    if(vald.equals("1")) dotog.setChecked(true);
                    else    dotog.setChecked(false);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            dotog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        doref.setValue("1");
                    } else {
                        doref.setValue("0");
                    }
                }
            });

        }
    }

