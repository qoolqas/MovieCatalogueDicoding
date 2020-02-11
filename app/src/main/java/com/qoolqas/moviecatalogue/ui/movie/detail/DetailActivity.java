package com.qoolqas.moviecatalogue.ui.movie.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qoolqas.moviecatalogue.R;
import com.qoolqas.moviecatalogue.connection.Client;
import com.qoolqas.moviecatalogue.connection.Service;
import com.qoolqas.moviecatalogue.pojo.movie.detail.DetailMovieResponse;
import com.qoolqas.moviecatalogue.pojo.movie.nowplaying.NowPlayingResultsItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    DetailMovieResponse detailMovieResponse;
    NowPlayingResultsItem nowPlayingResultsItem;
    ImageView backdrop, poster;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        nowPlayingResultsItem = getIntent().getParcelableExtra("id");

        backdrop = findViewById(R.id.backdrop);
        poster = findViewById(R.id.poster);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);


        collapsingToolbarLayout.setCollapsedTitleTextColor(
                ContextCompat.getColor(this, R.color.colorAccent));
        collapsingToolbarLayout.setExpandedTitleColor(
                ContextCompat.getColor(this, R.color.transparent));


        Service service = Client.getClient().create(Service.class);
        String api = Client.getApiKey();
        int id = nowPlayingResultsItem.getId();
        Call<DetailMovieResponse> getMovieDetail = service.getDetailMovie(id, api);
        getMovieDetail.enqueue(new Callback<DetailMovieResponse>() {
            @Override
            public void onResponse(Call<DetailMovieResponse> call, Response<DetailMovieResponse> response) {
                DetailMovieResponse detailMovieResponse = response.body();
                try {
                    collapsingToolbarLayout.setTitle(detailMovieResponse.getTitle());
                    Glide.with(context).load("https://image.tmdb.org/t/p/w185" + detailMovieResponse.getPosterPath()).into(poster);
                    Glide.with(context).load("https://image.tmdb.org/t/p/original" + detailMovieResponse.getBackdropPath()).into(backdrop);
                } catch (Exception e) {

                }


            }

            @Override
            public void onFailure(Call<DetailMovieResponse> call, Throwable t) {

            }
        });

    }
}
