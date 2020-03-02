package com.example.nytimesmostpopular.models;

public class Article {
    private String published_date;
    private String byline;
    private String article_details;

    public Article(String published_date, String byline, String article_details) {
        this.published_date = published_date;
        this.byline = byline;
        this.article_details = article_details;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getArticle_details() {
        return article_details;
    }

    public void setArticle_details(String article_details) {
        this.article_details = article_details;
    }
}
