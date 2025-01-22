package io.github.fvarrui.jeppetto.api;

import io.github.fvarrui.jeppetto.api.model.Models;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JeppettoInterface {

    @GET("models")
    public Call<Models> getModels();

}
