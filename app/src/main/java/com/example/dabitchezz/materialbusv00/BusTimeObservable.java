package com.example.dabitchezz.materialbusv00;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by anthony on 10/26/2016.
 */

public class BusTimeObservable {
    private static String thisBusURL;
    protected BusTimeObservable(String url) {
        thisBusURL = url;
    }

    @NonNull
    protected static Observable<List<String>> getBusTimeObservable(Bus bus){
        return Observable.defer(() -> {
                    try {
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url(bus.getBusUrl())
                                .build();
                        Response response = client.newCall(request).execute();

                        List<String> temp = new ArrayList<>();
                        temp.add("working1");
                        temp.add("working2");
                        return Observable.just(temp);
                    } catch (Exception e) {
                        return Observable.error(e);
                    }


                }
        );
    }
}
