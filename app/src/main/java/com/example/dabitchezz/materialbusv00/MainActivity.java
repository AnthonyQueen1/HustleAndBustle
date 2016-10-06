package com.example.dabitchezz.materialbusv00;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Bus> busList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BusAdapter busAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
       // swipeRefreshLayout.setColorSchemeResources(R.color.orange, R.color.green, R.color.blue);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //TODO smooth animation for swiping to refresh
                swipeRefreshLayout.setRefreshing(true);
                refreshTimes();
            }
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
        for(int i=1; i<36; i++) {
            Bus bus = new Bus(14, i);
            busList.add(bus);
        }
        busAdapter.notifyDataSetChanged();
    }

    // refreshes times for buses in bus list.
    public void refreshTimes() {
        for(Bus bus: busList) {
            bus.refreshTimes();
            TextView textView1 = (TextView) findViewById(R.id.time_early);
            TextView textView2 = (TextView) findViewById(R.id.time_later);
            try {
                textView1.setText(bus.getTime1());
                textView2.setText(bus.getTime2());
            } catch (Exception e) {
                // TODO add exception handler
                e.printStackTrace();
            }
        }
        busAdapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);

    }
}
