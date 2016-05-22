package com.example.dabitchezz.materialbusv00;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Anthony Queen on 5/22/2016.
 * custom AsyncTask to download BusbusTimesfrom URLs.
 */

//TODO finish this (hopefully fixes the refresh animation freezing)
public class DownloadBusTime extends AsyncTask<URL, Integer, String> {
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
           busTimes =busTimes.replace("&nbsp;", " ");
            String split = "</div><div> 2nd Arrival   ";
            if(!busTimes.contains(split))
                split = "</div><div> 2nd Departure   ";
            String [] timesAry = busTimes.split(split);
            return "First arrival: " + timesAry[1] + "?" + "Next: " + timesAry[1];

        } catch (Exception e) {
            //TODO handle exception
            e.printStackTrace();
            return "ERROR";
        }
    }

    @Override
    protected void onPostExecute(String string){

    }

}
