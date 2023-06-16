package com.ajayam.tmdb_app.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ajayam.tmdb_app.ApiInstanse.Api;
import com.ajayam.tmdb_app.RectroClient.TMDBretroClient;
import com.ajayam.tmdb_app.model.Movie;
import com.ajayam.tmdb_app.model.MovieResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TMDBviewModel extends ViewModel
{
    private MutableLiveData<List<MovieResults>> movieList;

    public TMDBviewModel() { movieList=new MutableLiveData<>();}

    public MutableLiveData<List<MovieResults>> getMovieObserver() { return movieList;}

    public void makeApiCall()
    {
        Api apiServices = TMDBretroClient.getRetrofitClient().create(Api.class);
//        Call<List<Movie>> call = apiServices.getTMDBmovieList("c76887f44b7a6a72ade4f85b12dd75a1");
        Call<Movie> call = apiServices.getTMDBmovieList("c76887f44b7a6a72ade4f85b12dd75a1");

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                movieList.postValue(response.body().getMovieResults());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                movieList.postValue(null);
                Log.e("Error_401", t.getMessage().toString());
            }
        });

    }
}
