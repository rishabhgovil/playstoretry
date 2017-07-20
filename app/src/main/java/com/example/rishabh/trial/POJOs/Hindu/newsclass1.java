package com.example.rishabh.trial.POJOs.Hindu;

import com.example.rishabh.trial.POJOs.TOI.articles;

import java.util.ArrayList;

/**
 * Created by RISHABH on 19-07-2017.
 */

public class newsclass1 {
    String status;
    String source;
    String sortBy;
    ArrayList<com.example.rishabh.trial.POJOs.Hindu.articles> articles;

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public ArrayList<com.example.rishabh.trial.POJOs.Hindu.articles> getArticles() {
        return articles;
    }

    public newsclass1(String status, String source, String sortBy, ArrayList<com.example.rishabh.trial.POJOs.Hindu.articles> articles) {

        this.status = status;
        this.source = source;
        this.sortBy = sortBy;
        this.articles = articles;
    }
}
