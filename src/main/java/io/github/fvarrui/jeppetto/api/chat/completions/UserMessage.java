package io.github.fvarrui.jeppetto.api.chat.completions;

public class UserMessage extends Message {

    public UserMessage() {
        this(null);
    }

    public UserMessage(String content) {
        super("user", content);
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "role='" + getRole() + '\'' +
                ", content='" + getContent() + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }
}
