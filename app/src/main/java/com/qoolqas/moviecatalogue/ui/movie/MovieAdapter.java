package com.qoolqas.moviecatalogue.ui.movie;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolderMovie> {
    @NonNull
    @Override
    public MovieAdapter.ViewHolderMovie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolderMovie holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderMovie extends RecyclerView.ViewHolder {
        public ViewHolderMovie(@NonNull View itemView) {
            super(itemView);
        }
    }
}
