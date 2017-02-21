package com.example.masato.insumaapisample.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by masato on 17/02/21.
 */

public class InsumaServiceHolder {

    private static InsumaService INSTANCE;

    public static InsumaService get() {
        if (INSTANCE == null) {
            INSTANCE = createInstance();
        }
        return INSTANCE;
    }

    private static InsumaService createInstance() {
        return retrofit().create(InsumaService.class);
    }

    private static Retrofit retrofit() {
        final String ENDPOINT = "http://e4480f6c.ngrok.io/";
        return new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
