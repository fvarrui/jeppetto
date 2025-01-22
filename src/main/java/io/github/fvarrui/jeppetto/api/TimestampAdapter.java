package io.github.fvarrui.jeppetto.api;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.sql.Timestamp;

public class TimestampAdapter extends TypeAdapter<Timestamp> {

    private static final int TO_MILLIS = 1000;

    @Override
    public void write(JsonWriter out, Timestamp value) throws IOException {
        out.value(value.getTime() / TO_MILLIS);
    }

    @Override
    public Timestamp read(JsonReader in) throws IOException {
        return new Timestamp(Long.parseLong(in.nextString()) * TO_MILLIS);
    }

}