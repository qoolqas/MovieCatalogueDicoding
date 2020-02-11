package com.qoolqas.moviecatalogue.ui.movie;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.qoolqas.moviecatalogue.connection.Client;
import com.qoolqas.moviecatalogue.connection.Service;
import com.qoolqas.moviecatalogue.pojo.movie.MovieResponse;
import com.qoolqas.moviecatalogue.pojo.movie.nowplaying.NowPlayingMovieResponse;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    private MutableLiveData<MovieResponse> getMovie;
    private MutableLiveData<NowPlayingMovieResponse> getNowplayingMovie;
    private final static String api = Client.getApiKey();

    private void loadMovie() {
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

    public LiveData<MovieResponse> liveMovie() {
        Log.d("gdjagd", "dadad");
        if (getMovie == null) {
            getMovie = new MutableLiveData<>();
            loadMovie();
        }
        return getMovie;
    }


    private void loadNowplayingMovie() {
        Service service = Client.getClient().create(Service.class);
        Call<NowPlayingMovieResponse> call = service.getNowplayingMovie(api);
        call.enqueue(new Callback<NowPlayingMovieResponse>() {

            @Override
            public void onResponse(@NotNull Call<NowPlayingMovieResponse> call, @NotNull Response<NowPlayingMovieResponse> response) {
                getNowplayingMovie.setValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<NowPlayingMovieResponse> call, @NotNull Throwable t) {
                Log.e("failure", t.toString());

            }
        });
    }

    LiveData<NowPlayingMovieResponse> liveNowplayingMovie() {
        if (getNowplayingMovie == null) {
            getNowplayingMovie = new MutableLiveData<>();
            loadNowplayingMovie();
        }
        return getNowplayingMovie;
    }
}