package io.github.fvarrui.jeppetto;

import io.github.fvarrui.jeppetto.api.chat.completions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chat {

    private final String model;
    private final Jeppetto jeppetto;
    private final List<Message> context = new ArrayList<>();

    public Chat(Jeppetto jeppetto, String model, String config) {
        this.model = model;
        this.jeppetto = jeppetto;
        this.context.add(new DeveloperMessage(config));
    }

    public Chat(String apikey, String model, String config) {
        this(new Jeppetto(apikey), model, config);
    }

    public AssistantMessage send(Message ... messages) throws Exception {
        RequestCompletion requestCompletion = new RequestCompletion();
        requestCompletion.setModel(model);
        requestCompletion.setN(1);
        // requestCompletion.setMaxCompletionTokens(500);
        requestCompletion.getMessages().addAll(context);
        requestCompletion.getMessages().addAll(Arrays.asList(messages));
        ChatCompletion completion = jeppetto.chatCompletion(requestCompletion);
        if (completion.getChoices().isEmpty()) {
            throw new Exception("No choices returned");
        }
        AssistantMessage response = completion.getChoices().get(0).getMessage();
        context.add(response);
        return response;
    }

    public AssistantMessage send(String message) throws Exception {
        System.out.println("User: " + message);
        return send(new UserMessage(message));
    }

}
