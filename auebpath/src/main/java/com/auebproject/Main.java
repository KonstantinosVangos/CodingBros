package com.auebproject;

public class Main {
    public static void main(String[] args) {
        var x = new CodeToName();
        var y = new JSONtoString();
        var j = new Location();
        System.out.println(x.getStopName("450028"));
        System.out.println(x.getStopXY("110071")[0]);
        System.out.println(x.getStopXY("110071")[1]);
        System.out.println(x.getLineName("871"));
        System.out.println(x.getRouteName("1881"));
        for (String z : y.getStopInfo("240033")) {
            System.out.println(z);
        }
        System.out.println("37.951596, 23.695745");
        j.location();
    }
}
