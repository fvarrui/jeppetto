package io.github.fvarrui.jeppetto.api.chat.completions;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Chat completion request.
 */
public class RequestCompletion {

    /**
     * A list of messages comprising the conversation so far. Depending on the model you use, different message
     * types (modalities) are supported, like text, images, and audio.
     */
    private List<Message> messages = new ArrayList<>();

    /**
     * ID of the model to use.
     */
    private String model;

    /**
     * Constrains effort on reasoning for reasoning models. Currently supported values are low, medium, and high.
     * Reducing reasoning effort can result in faster responses and fewer tokens used on reasoning in a response.
     * [ o1 models only ]
     */
    @SerializedName("reasoning_effort")
    private ReasoningEffort reasoningEffort;

    /**
     * An upper bound for the number of tokens that can be generated for a completion, including visible output
     * tokens and reasoning tokens.
     */
    @SerializedName("max_completion_tokens")
    private Integer maxCompletionTokens;

    /**
     * How many chat completion choices to generate for each input message. Note that you will be charged based on
     * the number of generated tokens across all the choices. Keep n as 1 to minimize costs.
     */
    private Integer n = 1;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ReasoningEffort getReasoningEffort() {
        return reasoningEffort;
    }

    public void setReasoningEffort(ReasoningEffort reasoningEffort) {
        this.reasoningEffort = reasoningEffort;
    }

    public Integer getMaxCompletionTokens() {
        return maxCompletionTokens;
    }

    public void setMaxCompletionTokens(Integer maxCompletionTokens) {
        this.maxCompletionTokens = maxCompletionTokens;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "RequestCompletion{" +
                "messages=" + messages +
                ", model='" + model + '\'' +
                ", reasoningEffort=" + reasoningEffort +
                ", maxCompletionTokens=" + maxCompletionTokens +
                ", n=" + n +
                '}';
    }
}
