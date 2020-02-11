package com.qoolqas.moviecatalogue.ui.discover;

import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qoolqas.moviecatalogue.R;
import com.qoolqas.moviecatalogue.pojo.movie.MovieData;
import com.qoolqas.moviecatalogue.pojo.movie.MovieResponse;
import com.qoolqas.moviecatalogue.ui.movie.MovieAdapter;
import com.qoolqas.moviecatalogue.ui.movie.MovieViewModel;

public class DiscoverFragment extends Fragment {
    private RecyclerView recyclerView;
    private DiscoverAdapter discoverAdapter;
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_discover, container, false);
        recyclerView = v.findViewById(R.id.rv);
        ProgressBar progressBar = v.findViewById(R.id.pb);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        setHasOptionsMenu(true);
        MovieViewModel movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.liveMovie().observe(getViewLifecycleOwner(), movie -> {
            discoverAdapter = new DiscoverAdapter(getContext(), movie.getResults());
            recyclerView.setAdapter(discoverAdapter);
            Toast.makeText(getActivity(), movie.getResults().toString(), Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
        });
        progressBar.setVisibility(View.VISIBLE);
        return v;


//        MovieViewModel movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
//        movieViewModel.liveMovie().observe(getViewLifecycleOwner(), movieResponse -> {
//            discoverAdapter = new DiscoverAdapter(getContext(), movieResponse.getResults());
//            recyclerView.setAdapter(discoverAdapter);
//            Log.d("testt", "rahman");
//            progressBar.setVisibility(View.GONE);
//        });

    }
}