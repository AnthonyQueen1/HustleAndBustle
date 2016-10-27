package com.example.dabitchezz.materialbusv00;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Bus> busList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BusAdapter busAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private BusViewModel busmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(()->{
                //TODO smooth animation for swiping to refresh
                swipeRefreshLayout.setRefreshing(true);
                refreshTimes();
            });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        busAdapter = new BusAdapter(busList);
        RecyclerView.LayoutManager bLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(bLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(busAdapter);

        prepareBusData();
    }

    // initialize some bus data so list is not empty when app is created.
    public void prepareBusData() {
        swipeRefreshLayout.setRefreshing(true);
        for(int i=1; i<36; i++) {
            Bus bus = new Bus(14, i);
            busList.add(bus);
        }
        busmodel = new BusViewModel(busList, busAdapter, swipeRefreshLayout);
        busmodel.getTimes(busList);
    }

    // refreshes times for buses in bus list.
    public void refreshTimes() {
        busmodel.getTimes(busList);
        busAdapter.notifyDataSetChanged();
    }

}
