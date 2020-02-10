package com.qoolqas.moviecatalogue.ui.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.qoolqas.moviecatalogue.CenterZoomLayoutManager;
import com.qoolqas.moviecatalogue.R;

public class MovieFragment extends Fragment {
    private RecyclerView rvNowplaying;
    private MovieAdapter movieAdapter;
    private MovieNowplayingAdapter movieNowplayingAdapter;
    private CenterZoomLayoutManager centerZoomLayoutManager = new CenterZoomLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
    private SnapHelper snapHelper = new PagerSnapHelper();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_movie, container, false);
        rvNowplaying = v.findViewById(R.id.rv_nowplaying);
        rvNowplaying.setHasFixedSize(true);
        rvNowplaying.setLayoutManager(centerZoomLayoutManager);
        snapHelper.attachToRecyclerView(rvNowplaying);
        setHasOptionsMenu(true);

        MovieViewModel movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.liveNowplayingMovie().observe(getViewLifecycleOwner(), nowPlayingMovieResponse -> {
            movieNowplayingAdapter = new MovieNowplayingAdapter(getContext(), nowPlayingMovieResponse.getResults());
            rvNowplaying.setAdapter(movieNowplayingAdapter);
        });

        return v;
    }
}