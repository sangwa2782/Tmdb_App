package com.ajayam.tmdb_app.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {
//    model class
    public int page;

//    We need to make object of class Results
    private List<MovieResults> results = new ArrayList<>();
    public int total_pages;
    public int total_results;




//    Constructor

    public Movie(int page, List<MovieResults> movieResults, int total_pages, int total_results) {
        this.page = page;
        this.results = movieResults;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }


//    Getter & Setters

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieResults> getMovieResults() {
        return results;
    }

    public void setMovieResults(List<MovieResults> movieResults) {
        this.results = movieResults;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}
