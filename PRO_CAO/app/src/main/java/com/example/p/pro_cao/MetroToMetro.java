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

public class MetroToMetro extends Fragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_metro_tour, container, false);
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new HouseLebedi();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        TextView texttest = view.findViewById(R.id.textVie4);
        texttest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                Uri adress= Uri.parse("https://yandex.ru/map-widget/v1/?um=constructor%3A3a909013d076d72f93b35d5975945b893f9e1842727f7bd26de1595609240ba1&amp;source=constructor");
                Intent browser= new Intent(Intent.ACTION_VIEW, adress);
                startActivity(browser);
            }

        });
        Button button2 = view.findViewById(R.id.button_return);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Tour();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        return view;
    }
}
