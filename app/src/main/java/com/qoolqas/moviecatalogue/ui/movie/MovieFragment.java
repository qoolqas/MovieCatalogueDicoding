package com.qoolqas.moviecatalogue.ui.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qoolqas.moviecatalogue.R;
import com.qoolqas.moviecatalogue.pojo.movie.nowplaying.NowPlayingMovieResponse;

public class MovieFragment extends Fragment {
    private RecyclerView rvNowplaying;
    private MovieViewModel movieViewModel;
    private MovieAdapter movieAdapter;
    private MovieNowplayingAdapter movieNowplayingAdapter;
    LinearLayoutManager layoutManagerHor
            = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_movie, container, false);
        rvNowplaying = v.findViewById(R.id.rv_nowplaying);
        rvNowplaying.setHasFixedSize(true);
        rvNowplaying.setLayoutManager(layoutManagerHor);
        setHasOptionsMenu(true);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.liveNowplayingMovie().observe(getViewLifecycleOwner(), new Observer<NowPlayingMovieResponse>() {
            @Override
            public void onChanged(NowPlayingMovieResponse nowPlayingMovieResponse) {
                movieNowplayingAdapter = new MovieNowplayingAdapter(getContext(), nowPlayingMovieResponse.getResults());
                rvNowplaying.setAdapter(movieNowplayingAdapter);
            }
        });

        return v;
    }
}