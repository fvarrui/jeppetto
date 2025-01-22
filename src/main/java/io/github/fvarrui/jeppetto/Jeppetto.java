package io.github.fvarrui.jeppetto;


import com.google.gson.Gson;
import io.github.fvarrui.jeppetto.api.ApiKeyInterceptor;
import io.github.fvarrui.jeppetto.api.JeppettoInterface;
import io.github.fvarrui.jeppetto.api.model.ErrorResponse;
import io.github.fvarrui.jeppetto.api.model.Model;
import io.github.fvarrui.jeppetto.api.model.Models;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Jeppetto {

    private static final String BASE_URL = "https://api.openai.com/v1/";

    private final JeppettoInterface api;
    private final Gson gson = new Gson();

    public Jeppetto(String apiKey) {

        ConnectionPool pool = new ConnectionPool(1, 5, TimeUnit.SECONDS);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectionPool(pool)
                .addInterceptor(new ApiKeyInterceptor(apiKey))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        api = retrofit.create(JeppettoInterface.class);
    }

    public List<Model> getModels() throws IOException {
        Response<Models> response = api
                .getModels()
                .execute();
        if (response.isSuccessful()) {
            assert response.body() != null;
            return response.body().getModels();
        } else {
            assert response.errorBody() != null;
            ErrorResponse errorResponse = gson.fromJson(response.errorBody().string(), ErrorResponse.class);
            throw new IOException("Error occurred while fetching models: " + errorResponse.getError().getMessage());
        }
    }

}
