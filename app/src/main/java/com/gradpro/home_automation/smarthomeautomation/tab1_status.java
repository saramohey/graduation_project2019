package com.gradpro.home_automation.smarthomeautomation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class tab1_status extends Fragment {
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    TextView temp;
    TextView hum;
    DatabaseReference senreff=FirebaseDatabase.getInstance().getReference().child("Sensors");
    DatabaseReference tref=senreff.child("Temperature");
    DatabaseReference href=senreff.child("Humidity");
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_status, container, false);
        temp= (TextView) rootView.findViewById(R.id.texttemp);
        hum= (TextView) rootView.findViewById(R.id.texthum);
        return rootView;
    }

    @Override
    public void onStart()
    {

        super.onStart();
        tref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String valt = dataSnapshot.getValue(String.class);
                temp.setText(valt);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        href.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String valh = dataSnapshot.getValue(String.class);
                hum.setText(valh);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
