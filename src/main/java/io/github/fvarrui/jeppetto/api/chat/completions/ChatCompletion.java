package io.github.fvarrui.jeppetto.api.chat.completions;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a chat completion response returned by model, based on the provided input.
 */
public class ChatCompletion {

    /**
     * A unique identifier for the chat completion.
     */
    private String id;

    /**
     * A list of chat completion choices. Can be more than one if n is greater than 1.
     */
    private List<Choice> choices = new ArrayList<>();

    /**
     * The Unix timestamp (in seconds) of when the chat completion was created.
     */
    private Timestamp created;

    /**
     * The model used for the chat completion.
     */
    private String model;

    /**
     * The service tier used for processing the request.
     */
    @SerializedName("service_tier")
    private String serviceTier;

    /**
     * This fingerprint represents the backend configuration that the model runs with.
     * Can be used in conjunction with the seed request parameter to understand when backend changes have been made that might impact determinism.
     */
    @SerializedName("system_fingerprint")
    private String systemFingerprint;

    /**
     * The object type, which is always chat.completion.
     */
    private String object;

    /**
     * Usage statistics for the completion request.
     */
    private Usage usage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getServiceTier() {
        return serviceTier;
    }

    public void setServiceTier(String serviceTier) {
        this.serviceTier = serviceTier;
    }

    public String getSystemFingerprint() {
        return systemFingerprint;
    }

    public void setSystemFingerprint(String systemFingerprint) {
        this.systemFingerprint = systemFingerprint;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    @Override
    public String toString() {
        return "ChatCompletion{" +
                "id='" + id + '\'' +
                ", choices=" + choices +
                ", created=" + created +
                ", model='" + model + '\'' +
                ", serviceTier='" + serviceTier + '\'' +
                ", systemFingerprint='" + systemFingerprint + '\'' +
                ", object='" + object + '\'' +
                ", usage=" + usage +
                '}';
    }
}
