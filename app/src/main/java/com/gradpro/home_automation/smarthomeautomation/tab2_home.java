package com.gradpro.home_automation.smarthomeautomation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Button;


public class tab2_home extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2_home, container, false);
        LinearLayout ledsb =(LinearLayout) rootView.findViewById(R.id.led_button);
        LinearLayout lockb =(LinearLayout) rootView.findViewById(R.id.lock_button);
        LinearLayout settingsb =(LinearLayout) rootView.findViewById(R.id.settings_button);

       ledsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), leds.class);
                startActivity(i);
            }
        });
        lockb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kl = new Intent(getActivity(), lock.class);
                startActivity(kl);
            }
        });
        settingsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(getActivity(), settings.class);
                startActivity(m);
            }
        });

        return rootView;
    }

}
