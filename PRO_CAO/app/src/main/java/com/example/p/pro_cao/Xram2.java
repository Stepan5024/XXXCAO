package com.example.p.pro_cao;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Xram2 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xram2, container, false);
        TextView texttest = view.findViewById(R.id.textVie4);
        texttest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Uri adress= Uri.parse("https://yandex.ru/map-widget/v1/?um=constructor%3A1b8db2fc970323850bd81cbc1d6ee28424b7ac11da10654c43e1c4e10e9f8a78&amp;source=constructor");
                Intent browser= new Intent(Intent.ACTION_VIEW, adress);
                startActivity(browser);
            }

        });
        Button but = view.findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new ParkGrach();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });

        return view;


    }

}
