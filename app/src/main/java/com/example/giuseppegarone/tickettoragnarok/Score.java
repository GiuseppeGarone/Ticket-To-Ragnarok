package com.example.giuseppegarone.tickettoragnarok;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by melissacoarezza on 21/07/17.
 */


@IgnoreExtraProperties
public class Score {
    private String nickname;
    private String score;

    public Score() {

    }

    public Score(String nickname, String score) {
        this.nickname = nickname;
        this.score  = score;
    }

    public String getNickname() {
        return nickname;
    }

    public String getScore() {
        return score;
    }
}