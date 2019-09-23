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
import android.widget.ImageView;
import android.widget.TextView;


public class Xrams extends Fragment{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.welcome_xrams, container, false);
        TextView texttest = view.findViewById(R.id.textVie4);
        texttest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Uri adress= Uri.parse("https://yandex.ru/map-widget/v1/?um=constructor%3Acf179b2341f8f9e002d2d3dabc32eb9a3870f44346605da7be763e16f763465a&amp;source=constructor");
                Intent browser= new Intent(Intent.ACTION_VIEW, adress);
                startActivity(browser);
            }

        });
        Button but = view.findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Xram2();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });

        return view;


    }

}
