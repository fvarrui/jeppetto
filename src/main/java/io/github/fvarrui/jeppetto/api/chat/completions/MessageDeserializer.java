package io.github.fvarrui.jeppetto.api.chat.completions;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Deserializes a message based on its role.
 */
public class MessageDeserializer implements JsonDeserializer<Message> {

    @Override
    public Message deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String role = jsonObject.get("role").getAsString();
        switch (role) {
            case "developer":
                return context.deserialize(jsonObject, DeveloperMessage.class);
            case "user":
                return context.deserialize(jsonObject, UserMessage.class);
            case "system":
                return context.deserialize(jsonObject, SystemMessage.class);
            case "assistant":
                return context.deserialize(jsonObject, AssistantMessage.class);
            default:
                throw new IllegalArgumentException("Unknown role: " + role);
        }
    }

}
