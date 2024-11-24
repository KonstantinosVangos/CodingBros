package com.auebproject;

public class Main {
    public static void main(String[] args) {
            var x = new CodeToName();
            var y = new JSONtoString();
            var j = new Location();
            System.out.println(x.getStopName("400075"));
            System.out.println(x.getStopXY("400075")[0]);
            System.out.println(x.getStopXY("400075")[1]);
            System.out.println(x.getLineName("871"));
            System.out.println(x.getRouteName("1881"));
            for (String z : y.getStopInfo("240071")) {
                System.err.println(z);
            }
            overpassAPI.fetchOverpassAPIData();
            j.location();
    }
}
