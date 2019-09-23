package com.example.p.pro_cao;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DataAdaptermy extends RecyclerView.Adapter<DataAdaptermy.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<TaskForRecyclerView> tasks;
    View view;

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tasksView;
        LinearLayout linearLayout;

        ViewHolder(View view) {
            super(view);
            tasksView = view.findViewById(R.id.TaskName);
            linearLayout = view.findViewById((R.id.linLayout));
        }
    }

    public DataAdaptermy(Context context, ArrayList<TaskForRecyclerView> phones) {
        this.tasks = phones;
        this.inflater = LayoutInflater.from(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    public DataAdaptermy.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = inflater.inflate(R.layout.view_recycler, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull final DataAdaptermy.ViewHolder viewHolder, final int position) {
        final TaskForRecyclerView new1 = tasks.get(position);

        viewHolder.tasksView.setText(new1.getName());
        //проверка на заставку

        viewHolder.linearLayout.setBackgroundResource(R.drawable.velik);

        // обработчик нажатия
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(new1.getActivity(), MapTourMetro.class);
//                startActivity(intent);
//                Fragment fragment = new MapTourMetro();
//                FragmentTransaction fragmentManager = new1.getActivity().getSupportFragmentManager().beginTransaction();
//                fragmentManager.replace(R.id.container, fragment).commit();

            }
        });
    }

    public void restoreItem(TaskForRecyclerView task, int position) {
        tasks.add(position, task);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        tasks.remove(position);
        notifyItemRemoved(position);
    }

    public List<TaskForRecyclerView> getData() {
        return tasks;
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

}

