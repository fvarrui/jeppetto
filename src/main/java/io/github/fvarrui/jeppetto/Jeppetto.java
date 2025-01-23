package io.github.fvarrui.jeppetto;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.fvarrui.jeppetto.api.ErrorResponse;
import io.github.fvarrui.jeppetto.api.chat.completions.*;
import io.github.fvarrui.jeppetto.api.models.Model;
import io.github.fvarrui.jeppetto.api.models.Models;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Jeppetto is a Java client for the OpenAI API.
 */
public class Jeppetto {

    private static final String BASE_URL = "https://api.openai.com/v1/";

    private final JeppettoInterface api;
    private final Gson gson;

    /**
     * Create a new Jeppetto instance.
     * @param apiKey OpenAI API key
     */
    public Jeppetto(String apiKey) {

        ConnectionPool pool = new ConnectionPool(1, 5, TimeUnit.SECONDS);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectionPool(pool)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new ApiKeyInterceptor(apiKey))
                .build();

        gson = new GsonBuilder()
                .registerTypeAdapter(Timestamp.class, new TimestampAdapter())
                .registerTypeAdapter(Message.class, new MessageDeserializer())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        api = retrofit.create(JeppettoInterface.class);
    }

    /**
     * Assert that the response is successful, otherwise throw an exception.
     * @param response Response to assert
     * @throws Exception if the response is not successful
     */
    private void assertResponse(Response<?> response) throws Exception {
        if (!response.isSuccessful()) {
            try {
                assert response.errorBody() != null;
                ErrorResponse errorResponse = gson.fromJson(response.errorBody().string(), ErrorResponse.class);
                throw new JeppettoException(errorResponse.getError());
            } catch (IOException e) {
                throw new Exception("Failed to parse error response", e);
            }
        }
    }

    /**
     * Get a list of models available for use.
     * @return List of models
     * @throws Exception if the request fails
     */
    public List<Model> getModels() throws Exception {
        Response<Models> response = api
                .getModels()
                .execute();
        assertResponse(response);
        assert response.body() != null;
        return response.body().getModels();
    }

    /**
     * Request a chat completion.
     * @param request Chat completion request
     * @return Chat completion response
     * @throws Exception if the request fails
     */
    public ChatCompletion chatCompletion(RequestCompletion request) throws Exception {
        Response<ChatCompletion> response = api
                .chatCompletion(request)
                .execute();
        assertResponse(response);
        return response.body();
    }

    /**
     * Start a new chat.
     * @param model Model to use
     * @param developerMessage Developer message
     * @return Chat instance
     * @throws Exception if the request fails
     */
    public Chat startChat(String model, String developerMessage) throws Exception {
        return new Chat(this, model, developerMessage);
    }

}
