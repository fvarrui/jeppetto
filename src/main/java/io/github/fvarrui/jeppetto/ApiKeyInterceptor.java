package io.github.fvarrui.jeppetto;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Interceptor that adds an API key to the request headers.
 */
public class ApiKeyInterceptor implements Interceptor {

    private String apiKey;

    public ApiKeyInterceptor(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Request requestWithApiKey = originalRequest.newBuilder()
                .header("Authorization", "Bearer " + apiKey)
                .build();
        return chain.proceed(requestWithApiKey);
    }
}