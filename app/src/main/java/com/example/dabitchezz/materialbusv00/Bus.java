package com.example.dabitchezz.materialbusv00;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Anthony on 5/14/2016.
 * creates bus objects and retrieves their arrival times for different stops from a URL.
 */
public class Bus {
    private String thisBusURL;
    private String busName;
    private String times;
    private String [] timesAry;

    Bus(int busNumber, int routeNumber) {
        BusURLs URLs = new BusURLs(busNumber, routeNumber);
        busName = URLs.getBusName();
        thisBusURL = URLs.getBusURL();
        refreshTimes();
    }

    public String getBusTitle() {
        return busName;
    }

    public void refreshTimes() {
        try {
            //run AsyncTask and get the times from the url
            times = new DownloadUrl().execute(new URL(thisBusURL)).get();
            times = times.replace("&nbsp;", " ");
            String split = "</div><div> 2nd Arrival   ";
            if(!times.contains(split))
                split = "</div><div> 2nd Departure   ";
            timesAry = times.split(split);
        } catch (Exception e) {
            //TODO handle exception
            e.printStackTrace();
        }
    }
    // gets time from URL and parses it
    public String getTime1() {
        return "First arrival: " + timesAry[0];
    }
    public String getTime2 () {
        if(timesAry.length == 1)
            return "Error reading time";
        return "Next: " + timesAry[1];
    }

    private class DownloadUrl extends AsyncTask<URL, Integer, String> {
        @Override
        protected String doInBackground(URL... urls) {
            try {
                BufferedReader buffer = null;
                StringBuilder builder = new StringBuilder();
                try {
                    buffer = new BufferedReader(new InputStreamReader(urls[0].openStream()));
                    for (String line; (line = buffer.readLine()) != null; ) {
                        builder.append(line.trim());
                    }

                } finally {
                    if (buffer != null) try {
                        buffer.close();
                    } catch (IOException e) {
                        //TODO handle exception
                        e.printStackTrace();
                    }
                }
                String start = "<div>Next Arrival&nbsp;&nbsp;&nbsp;";
                String end = "</div><br><form";
                if(builder.indexOf(start) == -1)
                    start = "<div>Next Departure&nbsp;&nbsp;&nbsp;";
                String part = builder.substring(builder.indexOf(start) + start.length());
                String busTimes = part.substring(0, part.indexOf(end));
                return busTimes;

            } catch (Exception e) {
                //TODO handle exception
                e.printStackTrace();
                return "ERROR";
            }
        }

    }
}
