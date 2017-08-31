package com.example.giuseppegarone.tickettoragnarok;

/**
 * Created by melissacoarezza on 31/08/17.
 */

public class GlobalVariables {
    private static String serverURL = null;

    public static String getServerURL(){
        //Log.d(TAG, )
        return serverURL;
    }

    public static void setServerURL(String url){
        serverURL = url;
    }

}
