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
//
//
//    public void refreshTimes() {
//        try {
//            //run AsyncTask and get the times from the url
//            times = new DownloadUrl().execute(new URL(thisBusURL)).get();
//            times = times.replace("&nbsp;", " ");
//            String split = "</div><div> 2nd Arrival   ";
//            if(!times.contains(split))
//                split = "</div><div> 2nd Departure   ";
//            timesAry = times.split(split);
//        } catch (Exception e) {
//            //TODO handle exception
//            e.printStackTrace();
//        }
//    }
//    // gets time from URL and parses it
//
//
//    private class DownloadUrl extends AsyncTask<URL, Integer, String> {
//        @Override
//        protected String doInBackground(URL... urls) {
//            try {
//                BufferedReader buffer = null;
//                StringBuilder builder = new StringBuilder();
//                try {
//                    buffer = new BufferedReader(new InputStreamReader(urls[0].openStream()));
//                    for (String line; (line = buffer.readLine()) != null; ) {
//                        builder.append(line.trim());
//                    }
//
//                } finally {
//                    if (buffer != null) try {
//                        buffer.close();
//                    } catch (IOException e) {
//                        //TODO handle exception
//                        e.printStackTrace();
//                    }
//                }
//                String start = "<div>Next Arrival&nbsp;&nbsp;&nbsp;";
//                String end = "</div><br><form";
//                if(builder.indexOf(start) == -1)
//                    start = "<div>Next Departure&nbsp;&nbsp;&nbsp;";
//                String part = builder.substring(builder.indexOf(start) + start.length());
//                String busTimes = part.substring(0, part.indexOf(end));
//                return busTimes;
//
//            } catch (Exception e) {
//                //TODO handle exception
//                e.printStackTrace();
//                return "ERROR";
//            }
//        }
//
//    }
//}
