package io.github.fvarrui.jeppetto.api.chat.completions;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Usage statistics for the completion request.
 */
public class Usage {

    /**
     * Number of tokens in the generated completion.
     */
    @SerializedName("completion_tokens")
    private Integer completionTokens;

    /**
     * Number of tokens in the prompt.
     */
    @SerializedName("prompt_tokens")
    private Integer promptTokens;

    /**
     * Total number of tokens used in the request (prompt + completion).
     */
    @SerializedName("total_tokens")
    private Integer totalTokens;

    /**
     * Breakdown of tokens used in a completion.
     */
    @SerializedName("completion_tokens_details")
    private Map<String, Integer> completionTokensDetails = new HashMap<>();

    /**
     * Breakdown of tokens used in the prompt.
     */
    @SerializedName("prompt_tokens_details")
    private Map<String, Integer> promptTokenDetails = new HashMap<>();

    public Integer getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(Integer completionTokens) {
        this.completionTokens = completionTokens;
    }

    public Integer getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(Integer promptTokens) {
        this.promptTokens = promptTokens;
    }

    public Integer getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(Integer totalTokens) {
        this.totalTokens = totalTokens;
    }

    public Map<String, Integer> getCompletionTokensDetails() {
        return completionTokensDetails;
    }

    public void setCompletionTokensDetails(Map<String, Integer> completionTokensDetails) {
        this.completionTokensDetails = completionTokensDetails;
    }

    public Map<String, Integer> getPromptTokenDetails() {
        return promptTokenDetails;
    }

    public void setPromptTokenDetails(Map<String, Integer> promptTokenDetails) {
        this.promptTokenDetails = promptTokenDetails;
    }

    @Override
    public String toString() {
        return "Usage{" +
                "completionTokens=" + completionTokens +
                ", promptTokens=" + promptTokens +
                ", totalTokens=" + totalTokens +
                ", completionTokensDetails=" + completionTokensDetails +
                ", promptTokenDetails=" + promptTokenDetails +
                '}';
    }
}
