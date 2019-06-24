package com.gradpro.home_automation.smarthomeautomation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button userb =(Button) findViewById(R.id.change_username_but);
        Button passb =(Button) findViewById(R.id.change_pass_but);
        Button signout =(Button) findViewById(R.id.signoutbutt);

        userb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(settings.this, changeusername.class);
                startActivity(ii);
            }
        });
        passb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kk = new Intent(settings.this, changepassword.class);
                startActivity(kk);
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ll = new Intent(settings.this, MainActivity.class);
                startActivity(ll);
            }
        });

    }
}
