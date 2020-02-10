package com.qoolqas.moviecatalogue.ui.discover;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qoolqas.moviecatalogue.R;
import com.qoolqas.moviecatalogue.ui.movie.MovieViewModel;

public class DiscoverFragment extends Fragment {
    private RecyclerView recyclerView;
    private DiscoverAdapter discoverAdapter;
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_discover, container, false);
        recyclerView = v.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        setHasOptionsMenu(true);


        MovieViewModel movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.liveMovie().observe(getViewLifecycleOwner(), movieResponse -> {
            discoverAdapter = new DiscoverAdapter(getContext(), movieResponse.getResults());
            recyclerView.setAdapter(discoverAdapter);
        });
        return v;
    }
}