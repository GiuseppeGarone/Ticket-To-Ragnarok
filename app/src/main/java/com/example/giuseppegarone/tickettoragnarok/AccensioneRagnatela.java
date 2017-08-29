package com.example.giuseppegarone.tickettoragnarok;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AccensioneRagnatela extends Activity {

    private JSONArray pixels_array;

    List<SegmentoRagnatelaFisica> possibiliSegmenti = new ArrayList<SegmentoRagnatelaFisica>();
    public int k;
    private NetworkThread mNetworkThread = null;
    private Handler mNetworkHandler, mMainHandler;

    SegmentoRagnatelaFisica segmento1 = new SegmentoRagnatelaFisica();
    boolean bho1 = segmento1.setPartenzaArrivo(906, 973);
    SegmentoRagnatelaFisica segmento2 = new SegmentoRagnatelaFisica();
    boolean bho2 = segmento2.setPartenzaArrivo(976, 1031);
    SegmentoRagnatelaFisica segmento3 = new SegmentoRagnatelaFisica();
    boolean bho3 = segmento3.setPartenzaArrivo(1034, 1070);
    SegmentoRagnatelaFisica segmento4 = new SegmentoRagnatelaFisica();
    boolean bho4 = segmento4.setPartenzaArrivo(791, 842);
    SegmentoRagnatelaFisica segmento5 = new SegmentoRagnatelaFisica();
    boolean bho5 = segmento5.setPartenzaArrivo(844, 902);

    SegmentoRagnatelaFisica segmento6 = new SegmentoRagnatelaFisica();
    boolean bho6 = segmento6.setPartenzaArrivo(686, 727);
    SegmentoRagnatelaFisica segmento7 = new SegmentoRagnatelaFisica();
    boolean bho7 = segmento7.setPartenzaArrivo(729, 764);
    SegmentoRagnatelaFisica segmento8 = new SegmentoRagnatelaFisica();
    boolean bho8 = segmento8.setPartenzaArrivo(765, 789);
    SegmentoRagnatelaFisica segmento9 = new SegmentoRagnatelaFisica();
    boolean bho9 = segmento9.setPartenzaArrivo(613, 649);
    SegmentoRagnatelaFisica segmento10 = new SegmentoRagnatelaFisica();
    boolean bho10 = segmento10.setPartenzaArrivo(653, 685);

    SegmentoRagnatelaFisica segmento11 = new SegmentoRagnatelaFisica();
    boolean bho11 = segmento11.setPartenzaArrivo(560, 576);
    SegmentoRagnatelaFisica segmento12 = new SegmentoRagnatelaFisica();
    boolean bho12 = segmento12.setPartenzaArrivo(578, 597);
    SegmentoRagnatelaFisica segmento13 = new SegmentoRagnatelaFisica();
    boolean bho13 = segmento13.setPartenzaArrivo(599, 611);
    SegmentoRagnatelaFisica segmento14 = new SegmentoRagnatelaFisica();
    boolean bho14 = segmento14.setPartenzaArrivo(524, 541);
    SegmentoRagnatelaFisica segmento15 = new SegmentoRagnatelaFisica();
    boolean bho15 = segmento15.setPartenzaArrivo(544, 557);

    SegmentoRagnatelaFisica segmento16 = new SegmentoRagnatelaFisica();
    boolean bho16 = segmento16.setPartenzaArrivo(333, 343);
    SegmentoRagnatelaFisica segmento17 = new SegmentoRagnatelaFisica();
    boolean bho17 = segmento17.setPartenzaArrivo(348, 357);
    SegmentoRagnatelaFisica segmento18 = new SegmentoRagnatelaFisica();
    boolean bho18 = segmento18.setPartenzaArrivo(436, 444);
    SegmentoRagnatelaFisica segmento19 = new SegmentoRagnatelaFisica();
    boolean bho19 = segmento19.setPartenzaArrivo(449, 460);
    SegmentoRagnatelaFisica segmento20 = new SegmentoRagnatelaFisica();
    boolean bho20 = segmento20.setPartenzaArrivo(7, 13);

    SegmentoRagnatelaFisica segmento21 = new SegmentoRagnatelaFisica();
    boolean bho21 = segmento21.setPartenzaArrivo(17, 21);
    SegmentoRagnatelaFisica segmento22 = new SegmentoRagnatelaFisica();
    boolean bho22 = segmento22.setPartenzaArrivo(68, 84);
    SegmentoRagnatelaFisica segmento23 = new SegmentoRagnatelaFisica();
    boolean bho23 = segmento23.setPartenzaArrivo(89, 106);
    SegmentoRagnatelaFisica segmento24 = new SegmentoRagnatelaFisica();
    boolean bho24 = segmento24.setPartenzaArrivo(204, 216);
    SegmentoRagnatelaFisica segmento25 = new SegmentoRagnatelaFisica();
    boolean bho25 = segmento25.setPartenzaArrivo(221, 231);

    public void popola() {
        possibiliSegmenti.add(segmento1);
        possibiliSegmenti.add(segmento2);
        possibiliSegmenti.add(segmento3);
        possibiliSegmenti.add(segmento4);
        possibiliSegmenti.add(segmento5);
        possibiliSegmenti.add(segmento6);
        possibiliSegmenti.add(segmento7);
        possibiliSegmenti.add(segmento8);
        possibiliSegmenti.add(segmento9);
        possibiliSegmenti.add(segmento10);
        possibiliSegmenti.add(segmento11);
        possibiliSegmenti.add(segmento12);
        possibiliSegmenti.add(segmento13);
        possibiliSegmenti.add(segmento14);
        possibiliSegmenti.add(segmento15);
        possibiliSegmenti.add(segmento16);
        possibiliSegmenti.add(segmento17);
        possibiliSegmenti.add(segmento18);
        possibiliSegmenti.add(segmento19);
        possibiliSegmenti.add(segmento20);
        possibiliSegmenti.add(segmento21);
        possibiliSegmenti.add(segmento22);
        possibiliSegmenti.add(segmento23);
        possibiliSegmenti.add(segmento24);
        possibiliSegmenti.add(segmento25);
    }

    public void accendere(int i) {

        SegmentoRagnatelaFisica daAccendere = possibiliSegmenti.get(i);

        int da = daAccendere.partenza;
        int a = daAccendere.arrivo;

        try {
            JSONArray pixels_array = new JSONArray();
            JSONObject tmp;
            try {
                for (int j = 0; j < 1072; j++) {
                    tmp = new JSONObject();
                    tmp.put("a", 0);
                    if (j < da || j > a) {
                        tmp.put("g", 0);
                        tmp.put("popupButton", 0);
                        tmp.put("r", 0);
                    } else if (j < a && j > da) {
                        tmp.put("r", 255);
                        tmp.put("g", 0);
                        tmp.put("popupButton", 0);
                    }
                    pixels_array.put(tmp);
                }
            } catch (JSONException exception) {
                // No errors expected here
            }


            handleNetworkRequest(NetworkThread.SET_PIXELS, pixels_array, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void handleNetworkRequest(int what, Object payload, int arg1, int arg2) {
        Message msg = mNetworkHandler.obtainMessage();
        msg.what = what;
        msg.obj = payload;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.sendToTarget();
    }

}
