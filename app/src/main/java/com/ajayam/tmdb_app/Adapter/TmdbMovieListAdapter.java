package com.ajayam.tmdb_app.Adapter;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ajayam.tmdb_app.R;
import com.ajayam.tmdb_app.model.Movie;
import com.ajayam.tmdb_app.model.MovieResults;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import java.util.List;

public class TmdbMovieListAdapter extends RecyclerView.Adapter<TmdbMovieListAdapter.ViewHolder> {
    private static final String ACCESS_TOKEN = "c76887f44b7a6a72ade4f85b12dd75a1";
    Context context;
    List<MovieResults> list;

    public TmdbMovieListAdapter(Context context, List<MovieResults> List) {
        this.context=context;
        this.list=List;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_list, parent, false);

        return new TmdbMovieListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.movieName.setText(list.get(position).title);

        GlideUrl glideUrl = new GlideUrl(URL, new LazyHeaders.Builder()
                .addHeader("access_token", ACCESS_TOKEN)
                .build());

        Glide.with(context)
                .load(glideUrl)
                .into(holder.movie_poster);

    }

    @Override
    public int getItemCount() {
        if (this.list!=null)
            return this.list.size();
        else
            return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView movieName;
        ImageView movie_poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movieName = itemView.findViewById(R.id.movie_name);
            movie_poster = itemView.findViewById(R.id.movie_poster);

        }
    }
}
