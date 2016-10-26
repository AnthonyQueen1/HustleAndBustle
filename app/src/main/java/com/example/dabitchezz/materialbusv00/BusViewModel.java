package com.example.dabitchezz.materialbusv00;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by anthony on 10/26/2016.
 */

public class BusViewModel {
    private Subscription subscription;
    private BusAdapter busAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int counter = 0;
    List<Bus> busList;

    protected BusViewModel(List<Bus> list, BusAdapter busAdapt, SwipeRefreshLayout swipeRefreshL) {
        busList = list;
        getTimes(list);
        busAdapter = busAdapt;
        swipeRefreshLayout = swipeRefreshL;
    }

    protected void getTimes(List<Bus> busList) {
        for(Bus bus: busList) {
            getBusTime(bus);
        }
    }

    protected void getBusTime(final Bus bus) {
        subscription = BusTimeObservable.getBusTimeObservable(bus)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<String>>() {
                               @Override
                               public void onCompleted() {
                                   counter++;
                                   if(counter >= busList.size()){
                                       swipeRefreshLayout.setRefreshing(false);
                                       busAdapter.notifyDataSetChanged();
                                       counter = 0;
                                   }

                               }

                               @Override
                               public void onError(Throwable e) {
                                   Log.e("Bus.java", e.getMessage(), e);
                                   swipeRefreshLayout.setRefreshing(false);
                               }

                               @Override
                               public void onNext(List<String> strings) {
                                   for (int i = 0; i < 2; i++) {
                                       bus.setTime(i,  strings.get(i));
                                   }
                               }
                           }

                );
    }
}
