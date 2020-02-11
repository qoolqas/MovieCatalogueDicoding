package com.qoolqas.moviecatalogue.ui.movie;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qoolqas.moviecatalogue.R;
import com.qoolqas.moviecatalogue.pojo.movie.MovieData;
import com.qoolqas.moviecatalogue.pojo.movie.nowplaying.NowPlayingResultsItem;
import com.qoolqas.moviecatalogue.ui.movie.detail.DetailActivity;

import java.util.List;

public class MovieNowplayingAdapter extends RecyclerView.Adapter<MovieNowplayingAdapter.ViewHolderMovieNp> {
    private List<NowPlayingResultsItem> nowPlaying;
    private Context context;

    MovieNowplayingAdapter(Context context, List<NowPlayingResultsItem> item) {
        this.context = context;
        this.nowPlaying = item;
    }


    @Override
    public void onBindViewHolder(@NonNull MovieNowplayingAdapter.ViewHolderMovieNp holder, int position) {
        Glide.with(context).load("https://image.tmdb.org/t/p/w185" + nowPlaying.get(position).getPosterPath()).into(holder.np_img);
        holder.np_title.setText(nowPlaying.get(position).getTitle());

    }

    @NonNull
    @Override
    public ViewHolderMovieNp onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_nowplaying, parent, false);
        return new ViewHolderMovieNp(view);
    }

    @Override
    public int getItemCount() {
        return nowPlaying.size();
    }

    class ViewHolderMovieNp extends RecyclerView.ViewHolder {
        ImageView np_img;
        TextView np_title;

        ViewHolderMovieNp(@NonNull View itemView) {
            super(itemView);
            itemView.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    // run scale animation and make it bigger
                    Animation anim = AnimationUtils.loadAnimation(context, R.anim.scale_in_tv);
                    itemView.startAnimation(anim);
                    anim.setFillAfter(true);
                } else {
                    // run scale animation and make it smaller
                    Animation anim = AnimationUtils.loadAnimation(context, R.anim.scale_out_tv);
                    itemView.startAnimation(anim);
                    anim.setFillAfter(true);
                }
            });
            np_img = itemView.findViewById(R.id.np_img);
            np_title = itemView.findViewById(R.id.np_title);

            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    NowPlayingResultsItem clickedItem = nowPlaying.get(position);
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("id", clickedItem);
                    context.startActivity(intent);
                }
            });
        }
    }
}
