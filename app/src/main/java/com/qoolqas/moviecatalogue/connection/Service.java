package com.qoolqas.moviecatalogue.connection;

import com.qoolqas.moviecatalogue.pojo.movie.credit.CreditMovieResponse;
import com.qoolqas.moviecatalogue.pojo.movie.image.ImageMovieResponse;
import com.qoolqas.moviecatalogue.pojo.movie.MovieResponse;

import com.qoolqas.moviecatalogue.pojo.movie.detail.DetailMovieResponse;
import com.qoolqas.moviecatalogue.pojo.movie.nowplaying.NowPlayingMovieResponse;
import com.qoolqas.moviecatalogue.pojo.tv.TvResponse;
import com.qoolqas.moviecatalogue.pojo.movie.videos.VideoMovieResponse;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {

    @GET("discover/movie")
    Call<MovieResponse> getMovie(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<NowPlayingMovieResponse> getNowplayingMovie(@Query("api_key") String apiKey);


    @GET("movie/{movie_id}")
    Call<DetailMovieResponse> getDetailMovie(@Path("movie_id") int id,
                                             @Query("api_key") String apiKey
    );

    @GET("movie/{movie_id}/videos")
    Call<VideoMovieResponse> getVideoMovie(@Query("api_key") String apiKey,
                                           @Path("movie_id") int id);

    @GET("movie/{movie_id}/credits")
    Call<CreditMovieResponse> getCreditsMovie(@Query("api_key") String apiKey,
                                              @Path("movie_id") int id);

    @GET("movie/{movie_id}/images")
    Call<ImageMovieResponse> getImagesMovie(
            @Path("movie_id") int id,
            @Query("api_key") String apiKey);


    @GET("movie/{movie_id}/similar")
    Call<DetailMovieResponse> getSimiliarMovie(@Query("api_key") String apiKey,
                                               @Path("movie_id") int id);


    @GET("discover/tv")
    Call<TvResponse> getShow(@Query("api_key") String apiKey);

    @GET("tv/{tv_id}")
    Call<DetailMovieResponse> getDetailTv(@Query("api_key") String apiKey,
                                          @Path("tv_id") int id);


}
