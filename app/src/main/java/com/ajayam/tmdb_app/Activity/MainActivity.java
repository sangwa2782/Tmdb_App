package com.ajayam.tmdb_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ajayam.tmdb_app.Adapter.TmdbMovieListAdapter;
import com.ajayam.tmdb_app.R;
import com.ajayam.tmdb_app.ViewModel.TMDBviewModel;
import com.ajayam.tmdb_app.model.Movie;
import com.ajayam.tmdb_app.model.MovieResults;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

//    Creating instances
    RecyclerView movieRecycler;

    List<MovieResults> movieDetails;

    TMDBviewModel tmdBviewModel;

    TmdbMovieListAdapter listAdapter;

    TextView NoreplyFound;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRecycler=findViewById(R.id.movieRecycler);
        NoreplyFound= findViewById(R.id.NoreplyFound);

        tmdBviewModel= ViewModelProviders.of(this).get(TMDBviewModel.class);

        tmdBviewModel.getMovieObserver().observe(this, new Observer<List<MovieResults>>() {
            @Override
            public void onChanged(List<MovieResults> movieResults) {
                if (movieResults!=null) {
                    movieDetails=movieResults;
                    NoreplyFound.setVisibility(View.GONE);
                    Log.e("TAG", "onChanged: "+new Gson().toJson(movieResults));
                    setAdapterData(movieDetails);
                }
                if (movieResults==null)
                {
                    movieRecycler.setVisibility(View.GONE);
                    NoreplyFound.setVisibility(View.VISIBLE);
                }
            }
        });

        tmdBviewModel.makeApiCall();


    }
    public void setAdapterData(List<MovieResults> movieDetails) {
        movieRecycler.setLayoutManager(new GridLayoutManager(this,3));
        listAdapter=new TmdbMovieListAdapter(this,movieDetails);
        movieRecycler.setAdapter(listAdapter);
    }
}