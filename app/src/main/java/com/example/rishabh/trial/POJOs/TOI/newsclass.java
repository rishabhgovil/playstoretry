package com.example.rishabh.trial.POJOs.TOI;

import java.util.ArrayList;

/**
 * Created by RISHABH on 17-07-2017.
 */

public class newsclass {
    String status;
    String source;
    String sortBy;
    ArrayList<com.example.rishabh.trial.POJOs.TOI.articles> articles;

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public ArrayList<articles> getArticles() {
        return articles;
    }

    public newsclass(String status, String source, String sortBy, ArrayList<articles> articles) {

        this.status = status;
        this.source = source;
        this.sortBy = sortBy;
        this.articles = articles;
    }
}
