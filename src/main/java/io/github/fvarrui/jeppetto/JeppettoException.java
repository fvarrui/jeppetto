package io.github.fvarrui.jeppetto;

import com.google.gson.annotations.SerializedName;
import io.github.fvarrui.jeppetto.api.Error;

public class JeppettoException extends Exception {

    private final Error error;

    public JeppettoException(Error error) {
        super(error.getMessage());
        this.error = error;
    }

    public String getType() {
        return error.getType();
    }

    public String getCode() {
        return error.getCode();
    }

    public String getParam() {
        return error.getParam();
    }

    public String getEventId() {
        return error.getEventId();
    }

}
