package com.example.dabitchezz.materialbusv00;

/**
 * Created by Anthony on 5/20/2016.
 * Stores the URLs for each bus
 */
public class BusURLs {
    private String busURL;
    private String busName;
    public BusURLs(int busNumber, int routeNumber) {
        switch(busNumber) {
            case 1:
                busURL = "";
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                switch (routeNumber) {
                    case 1:
                        busName = "Bus 14: Aderhold inbound";
                        busURL = "http://acctransit.athensclarkecounty.com/mobile/predictions.htm?route=433&stop=355&view=All%20Routes";
                        break;
                    case 2:
                        busName = "Bus 14: Aderhold outbound";
                        busURL = "http://acctransit.athensclarkecounty.com/mobile/predictions.htm?route=433&stop=162&view=All%20Routes";
                        break;
                    case 3:
                        busName = "Bus 14: Coliseum outbound";
                        busURL = "http://acctransit.athensclarkecounty.com/mobile/predictions.htm?route=433&stop=161&view=All%20Routes";
                        break;
                    case 4:
                        busName = "Bus 14: D.W. Brooks Drive inbound";
                        busURL = "http://acctransit.athensclarkecounty.com/mobile/predictions.htm?route=433&stop=196&view=All%20Routes";
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;
                    case 16:
                        break;
                    case 17:
                        break;
                    case 18:
                        break;
                    case 19:
                        break;
                    case 20:
                        break;
                    case 21:
                        break;
                    case 22:
                        break;
                    case 23:
                        break;
                    case 24:
                        break;
                    case 25:
                        break;
                    case 26:
                        break;
                    case 27:
                        break;
                    case 28:
                        break;
                    case 29:
                        break;
                    case 30:
                        break;
                    case 31:
                        break;
                    case 32:
                        busName = "Bus 14: Soule Hall outbound";
                        busURL = "http://acctransit.athensclarkecounty.com/mobile/predictions.htm?route=433&stop=159&view=All%20Routes";
                        break;
                    case 33:
                        break;
                    case 34:
                        break;
                    case 35:
                        break;
                    case 36:
                        break;
                }
                break;
            case 15:
                break;
        }

    }

    // getter for busURL
    public String getBusURL() {
        return busURL;
    }

    // getter for busName
    public String getBusName() {
        return busName;
    }
}
