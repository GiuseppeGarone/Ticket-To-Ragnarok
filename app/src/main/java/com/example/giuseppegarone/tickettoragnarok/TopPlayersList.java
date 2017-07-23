package com.example.giuseppegarone.tickettoragnarok;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class TopPlayersList extends ArrayAdapter<Score> {

    private Activity context;

    public Typeface customFont;

    List<Score> scores;

    public TopPlayersList(Activity context, List<Score> scores) {
        super(context, R.layout.top_players_list, scores);
        this.context = context;
        this.scores = scores;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.top_players_list, null, true);

        TextView textViewNickname = (TextView) listViewItem.findViewById(R.id.textViewNickname);
        TextView textViewScore = (TextView) listViewItem.findViewById(R.id.textViewScore);

        AssetManager assetManager = getContext().getAssets();
        customFont = Typeface.createFromAsset(assetManager, "gameplay.ttf");
        textViewNickname.setTypeface(customFont);
        textViewScore.setTypeface(customFont);

        Score punteggio = scores.get(getCount()-1-position);

        textViewNickname.setText(punteggio.getNickname());
        textViewScore.setText(punteggio.getScore());

        return listViewItem;
    }
}