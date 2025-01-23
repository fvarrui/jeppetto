package io.github.fvarrui.jeppetto.api;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse {

    @SerializedName("event_id")
    private String eventId;

    private String type;

    private Error error;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "eventId='" + eventId + '\'' +
                ", type='" + type + '\'' +
                ", error=" + error +
                '}';
    }
}
