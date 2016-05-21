package com.example.dabitchezz.materialbusv00;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Anthony on 5/16/2016.
 * Custom adapter for RecyclerView
 */
public class BusAdapter extends RecyclerView.Adapter<BusAdapter.MyViewHolder> {
    private List<Bus> busList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, time1, time2;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            time1 = (TextView) view.findViewById(R.id.time_early);
            time2 = (TextView) view.findViewById(R.id.time_later);
        }
    }

    public BusAdapter(List<Bus> busList) {
        this.busList = busList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bus_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Bus bus = busList.get(position);
        holder.title.setText(bus.getBusTitle());
        holder.time1.setText(bus.getTime1());
        holder.time2.setText(bus.getTime2());
    }

    @Override
    public int getItemCount(){
        return busList.size();
    }
}
