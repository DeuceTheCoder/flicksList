package com.deucecoded.flickslist.models;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final String POSTER_PATH_KEY = "poster_path";
    private static final String ORIGINAL_TITLE_KEY = "original_title";
    private static final String OVERVIEW_KEY = "overview";
    private static final String BACKDROP_PATH_KEY = "backdrop_path";
    private String posterPath = "";
    private String backdropPath = "";
    private String originalTitle = "";
    private String overview = "";
    private static final String POSTER_PATH_PREFIX = "https://image.tmdb.org/t/p/w342";
    private static final String BACKDROP_PATH_PREFIX = "https://image.tmdb.org/t/p/w780";

    private Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString(POSTER_PATH_KEY);
        this.originalTitle = jsonObject.getString(ORIGINAL_TITLE_KEY);
        this.overview = jsonObject.getString(OVERVIEW_KEY);
        this.backdropPath = jsonObject.getString(BACKDROP_PATH_KEY);
    }

    public static List<Movie> moviesFromJsonArray(JSONArray jsonArray) throws JSONException {
        ArrayList<Movie> movies = new ArrayList<>();

        for(int x=0; x < jsonArray.length(); x++) {
            Movie movie = new Movie(jsonArray.getJSONObject(x));
            movies.add(movie);
        }

        return movies;
    }

    public String getImagePath(boolean isLandscape) {
        if(isLandscape) {
            return String.format("%s%s", BACKDROP_PATH_PREFIX, backdropPath);
        } else {
            return String.format("%s%s", POSTER_PATH_PREFIX, posterPath);
        }
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }
}
