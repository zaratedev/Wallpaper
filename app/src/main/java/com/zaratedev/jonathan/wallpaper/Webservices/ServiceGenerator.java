package com.zaratedev.jonathan.wallpaper.Webservices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zaratedev.jonathan.wallpaper.Utils.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zaratedev on 06/01/2018.
 */

public class ServiceGenerator {

    // Variable static retrofit
    private static Retrofit retrofit = null;
    // Variable static gson
    private static Gson gson = new GsonBuilder().create();

    // Definition hhtpLogginInterceptor
    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    // Use OkHTTP
    private static OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder()
                            .addHeader("Authorization", "Client-ID " + Constants.APPLICATION_ID)
                            .build();
                    return chain.proceed(request);
                }
            });

    private static OkHttpClient okHttpClient = okHttpClientBuilder.build();

    public static <T> T createService(Class<T> serviceClass ) {

        if ( retrofit == null ) {
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constants.BASE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit.create(serviceClass);
    }
}
