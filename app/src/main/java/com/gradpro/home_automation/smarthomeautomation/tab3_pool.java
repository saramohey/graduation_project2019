package com.gradpro.home_automation.smarthomeautomation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class tab3_pool extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3_pool, container, false);
        Button manr =(Button) rootView.findViewById(R.id.manual_button);
        Button autr =(Button) rootView.findViewById(R.id.auto_button);

        manr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), manualrobot.class);
                startActivity(i);
            }
        });
        autr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kl = new Intent(getActivity(), autorobot.class);
                startActivity(kl);
            }
        });
        return rootView;
    }
}
