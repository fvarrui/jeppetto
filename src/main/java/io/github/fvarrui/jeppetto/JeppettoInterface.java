package io.github.fvarrui.jeppetto;

import io.github.fvarrui.jeppetto.api.chat.completions.ChatCompletion;
import io.github.fvarrui.jeppetto.api.chat.completions.RequestCompletion;
import io.github.fvarrui.jeppetto.api.models.Models;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JeppettoInterface {

    @GET("models")
    public Call<Models> getModels();

    @POST("chat/completions")
    public Call<ChatCompletion> chatCompletion(@Body RequestCompletion body);

}
