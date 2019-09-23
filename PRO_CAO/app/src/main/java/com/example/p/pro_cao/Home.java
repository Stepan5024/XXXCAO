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

        news.add(new NewsForRecycler("В САО покажут спектакль по стихам Бёрнса", R.drawable.news1,getActivity()));
        news.add(new NewsForRecycler("На Смольной появится новый жилой комплекс",  R.drawable.festivalpark_foto1,getActivity()));
        news.add(new NewsForRecycler("Мастер-класс о загадках лета прошёл на Зеленоградской", R.drawable.leto,getActivity()));
        news.add(new NewsForRecycler("Вблизи Ховрино пройдёт \"Медовый Спас\" для детей",  R.drawable.tesr,getActivity()));

    }
}
