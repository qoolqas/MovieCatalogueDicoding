package com.qoolqas.moviecatalogue.ui.movie.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.qoolqas.moviecatalogue.CenterZoomLayoutManager;
import com.qoolqas.moviecatalogue.R;
import com.qoolqas.moviecatalogue.connection.Client;
import com.qoolqas.moviecatalogue.connection.Service;
import com.qoolqas.moviecatalogue.pojo.movie.detail.DetailMovieResponse;
import com.qoolqas.moviecatalogue.pojo.movie.image.ImageMovieResponse;
import com.qoolqas.moviecatalogue.pojo.movie.image.PostersItem;
import com.qoolqas.moviecatalogue.pojo.movie.nowplaying.NowPlayingResultsItem;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    NowPlayingResultsItem nowPlayingResultsItem;
    ImageView backdrop, poster;
    Context context = this;
    RecyclerView rvImage;
    private CenterZoomLayoutManager centerZoomLayoutManager = new CenterZoomLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    private SnapHelper snapHelper = new PagerSnapHelper();
    ImageDetailAdapter imageDetailAdapter;


    @BindView(R.id.detail_title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        nowPlayingResultsItem = getIntent().getParcelableExtra("id");
        ButterKnife.bind(this);
        backdrop = findViewById(R.id.backdrop);
        poster = findViewById(R.id.poster);
        rvImage = findViewById(R.id.list_image);
        rvImage.setHasFixedSize(true);
        rvImage.setLayoutManager(centerZoomLayoutManager);
        snapHelper.attachToRecyclerView(rvImage);

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
                    assert detailMovieResponse != null;
                    collapsingToolbarLayout.setTitle(detailMovieResponse.getTitle());
                    title.setText(detailMovieResponse.getTitle());
                    Glide.with(context).load("https://image.tmdb.org/t/p/w185" + detailMovieResponse.getPosterPath()).into(poster);
                    Glide.with(context).load("https://image.tmdb.org/t/p/original" + detailMovieResponse.getBackdropPath()).into(backdrop);
                } catch (Exception e) {
                    Log.d("failure", "gagal");
                }


            }

            @Override
            public void onFailure(Call<DetailMovieResponse> call, Throwable t) {

            }
        });

        Service serviceImage = Client.getClient().create(Service.class);
        Call<ImageMovieResponse> call = serviceImage.getImagesMovie(id, api);
        call.enqueue(new Callback<ImageMovieResponse>() {

            @Override
            public void onResponse(@NotNull Call<ImageMovieResponse> call, @NotNull Response<ImageMovieResponse> response) {
                ImageMovieResponse imageMovieResponse = response.body();
                rvImage.setAdapter(imageDetailAdapter);
            }

            @Override
            public void onFailure(@NotNull Call<ImageMovieResponse> call, @NotNull Throwable t) {
                Log.e("failure", t.toString());

            }
        });
    }


}
