package io.github.fvarrui.jeppetto.api.model;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.github.fvarrui.jeppetto.api.TimestampAdapter;

import java.sql.Timestamp;

public class Model {

    private String id;

    private String object;

    @JsonAdapter(TimestampAdapter.class)
    private Timestamp created;

    @SerializedName("owned_by")
    private String ownedBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(String ownedBy) {
        this.ownedBy = ownedBy;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
