package com.example.dabitchezz.materialbusv00;


/**
 * Created by Anthony on 5/14/2016.
 * creates bus objects and retrieves their arrival times for different stops from a URL.
 */
public class Bus {
    private String thisBusURL;
    private String busName;
    private String[] timesAry = {"Error", "Error no network"};

    Bus(int busNumber, int routeNumber) {
        BusURLs URLs = new BusURLs(busNumber, routeNumber);
        busName = URLs.getBusName();
        thisBusURL = URLs.getBusURL();
    }

    protected void setTime(int index, String time){
        timesAry[index] = time;
    }

    protected String getTime1() {
        if(timesAry.length == 0)
            return "Error reading time";
        return timesAry[0];
    }

    protected String getTime2() {
        if(timesAry.length <= 1) {
            return "Error reading time";
        }
        return timesAry[1];
    }

    public String getBusTitle() {
        return busName;
    }
    protected String getBusUrl(){
        return thisBusURL;
    }
}

