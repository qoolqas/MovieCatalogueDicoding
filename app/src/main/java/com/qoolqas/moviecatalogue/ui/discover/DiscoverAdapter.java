package com.qoolqas.moviecatalogue.ui.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qoolqas.moviecatalogue.R;
import com.qoolqas.moviecatalogue.pojo.movie.MovieData;

import java.util.List;

public class DiscoverAdapter extends RecyclerView.Adapter<DiscoverAdapter.ViewHolderMovie> {
    private List<MovieData> movieData;
    private Context context;

    DiscoverAdapter(Context context, List<MovieData> item) {
        this.context = context;
        this.movieData = item;
    }


    @Override
    public void onBindViewHolder(@NonNull DiscoverAdapter.ViewHolderMovie holder, int position) {
        holder.title.setText(movieData.get(position).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w185" + movieData.get(position).getPosterPath()).into(holder.poster);

    }

    @NonNull
    @Override
    public ViewHolderMovie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_main, parent, false);
        return new ViewHolderMovie(view);
    }


    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public class ViewHolderMovie extends RecyclerView.ViewHolder {
        TextView title;
        ImageView poster;

        public ViewHolderMovie(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            poster = itemView.findViewById(R.id.img);
        }
    }
}
