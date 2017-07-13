package com.example.rishabh.trial.POJOs;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RISHABH on 13-07-2017.
 */

public class games {
    String game;
    Integer iv;

    public games(String game, Integer iv) {
        this.game = game;
        this.iv = iv;
    }

    public String getGame() {
        return game;
    }

    public Integer getIv() {
        return iv;
    }
}
