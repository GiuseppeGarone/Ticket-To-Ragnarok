package com.example.giuseppegarone.tickettoragnarok;

/**
 * Created by melissacoarezza on 31/08/17.
 */

public class GlobalVariables {
    private static String parsedServerURL = null;

    public static int RAW_PORT = 8080;
    public static String RAW_IP = "192.168.1.32";

    public static String getParsedServerURL(){
        //Log.d(TAG, )
        return parsedServerURL;
    }

    public static void setParsedServerURL(String url){
        parsedServerURL = url;
    }





}
