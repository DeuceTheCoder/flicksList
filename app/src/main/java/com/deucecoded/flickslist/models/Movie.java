package com.deucecoded.flickslist.models;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    public static final String POSTER_PATH_KEY = "poster_path";
    public static final String ORIGINAL_TITLE_KEY = "original_title";
    public static final String OVERVIEW_KEY = "overview";
    String posterPath;
    String originalTitle;
    String overview;
    final String POSTER_PATH_PREFIX = "https://image.tmdb.org/t/p/w342";

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString(POSTER_PATH_KEY);
        originalTitle = jsonObject.getString(ORIGINAL_TITLE_KEY);
        this.overview = jsonObject.getString(OVERVIEW_KEY);
    }

    public static List<Movie> moviesFromJsonArray(JSONArray jsonArray) throws JSONException {
        ArrayList<Movie> movies = new ArrayList<>();

        for(int x=0; x < jsonArray.length(); x++) {
            Movie movie = new Movie(jsonArray.getJSONObject(x));
            movies.add(movie);
        }

        return movies;
    }

    public String getPosterPath() {
        return String.format("%s%s", POSTER_PATH_PREFIX, posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }
}
