package com.example.giuseppegarone.tickettoragnarok;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by melissacoarezza on 21/07/17.
 */


@IgnoreExtraProperties
public class Score {
    private String nickname;
    private Integer score;

    public Score() {

    }

    public Score(String nickname, Integer score) {
        this.nickname = nickname;
        this.score  = score;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getScore() {
        return score;
    }
}