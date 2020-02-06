package com.qoolqas.moviecatalogue.ui.movie;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.qoolqas.moviecatalogue.connection.Client;
import com.qoolqas.moviecatalogue.connection.Service;
import com.qoolqas.moviecatalogue.pojo.movie.MovieResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<MovieResponse> getMovie;
    private final static String api = Client.getApiKey();

    public void loadMovie() {
        Service service = Client.getClient().create(Service.class);
        Call<MovieResponse> call = service.getMovie(api);
        call.enqueue(new Callback<MovieResponse>() {

            @Override
            public void onResponse(@NotNull Call<MovieResponse> call, @NotNull Response<MovieResponse> response) {
                getMovie.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<MovieResponse> call, @NotNull Throwable t) {
                Log.e("failure", t.toString());

            }
        });
    }

    public LiveData<MovieResponse> liveGet() {
        if (getMovie == null) {
            getMovie = new MutableLiveData<>();
            loadMovie();
        }
        return getMovie;
    }
}