package com.zaratedev.jonathan.wallpaper.Webservices;

import com.zaratedev.jonathan.wallpaper.Models.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by zaratedev on 06/01/2018.
 */

public interface ApiInterface {
    @GET("photos")
    Call<List<Photo>> getPhotos();
}
