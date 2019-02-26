package com.example.p.pro_cao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Home extends Fragment {
    List<NewsForRecycler> news = new ArrayList<>();    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        setInitialData();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.list);
        recyclerView.setLayoutManager(layoutManager);
        // создаем адаптер
        DataAdapter adapter = new DataAdapter(getContext(), news);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        return rootView;
    }
    private void setInitialData(){

        news.add(new NewsForRecycler ("Какая-то новость",  R.mipmap.ic_launcher,getActivity()));
        news.add(new NewsForRecycler ("Elite z3",  R.mipmap.ic_launcher,getActivity()));
        news.add(new NewsForRecycler ("Galaxy S8", R.mipmap.ic_launcher,getActivity()));
        news.add(new NewsForRecycler ("LG G 5",  R.mipmap.ic_launcher,getActivity()));
        news.add(new NewsForRecycler ("Elite z3", R.mipmap.ic_launcher,getActivity()));
        news.add(new NewsForRecycler ("Elite z3",  R.mipmap.ic_launcher,getActivity()));
        news.add(new NewsForRecycler ("Elite z3",  R.mipmap.ic_launcher,getActivity()));
    }
}
