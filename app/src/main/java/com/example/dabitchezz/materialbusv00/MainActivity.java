package com.example.dabitchezz.materialbusv00;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Bus> busList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BusAdapter busAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        busAdapter = new BusAdapter(busList);
        RecyclerView.LayoutManager bLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(bLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(busAdapter);

        prepareBusData();
    }

    public void prepareBusData() {
        Bus bus = new Bus(14, 1);
        busList.add(bus);
        Bus bus2 = new Bus(14, 2);
        busList.add(bus2);
        Bus bus3 = new Bus(14, 3);
        busList.add(bus3);
        Bus bus4 = new Bus(14, 4);
        busList.add(bus4);
        Bus bus5 = new Bus(14, 32);
        busList.add(bus5);
        busAdapter.notifyDataSetChanged();
    }

}
