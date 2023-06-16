package com.ajayam.tmdb_app.ApiInstanse;

import com.ajayam.tmdb_app.model.Movie;
import com.ajayam.tmdb_app.model.MovieResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

//    BASE URL
    public static String BASE_URL = "https://api.themoviedb.org/3/movie/";


//    API CALLING
    @GET("popular")
    Call<Movie> getTMDBmovieList(
            @Query("api_key") String api_key
    );
}
