package io.github.fvarrui.jeppetto.api;

import com.google.gson.annotations.SerializedName;

/**
 * Error response
 */
public class Error {

    /**
     * Error type
     */
    private String type;

    /**
     * Error code
     */
    private String code;

    /**
     * Error message
     */
    private String message;

    /**
     * Error parameter
     */
    private String param;

    /**
     * Event id
     */
    @SerializedName("event_id")
    private String eventId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Error{" +
                "type='" + type + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", param='" + param + '\'' +
                ", eventId='" + eventId + '\'' +
                '}';
    }
}
