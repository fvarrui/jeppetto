package io.github.fvarrui.jeppetto.api.chat.completions;

/**
 * Developer-provided instructions that the model should follow, regardless of messages sent by the user.
 * With o1 models and newer, developer messages replace the previous system messages.
 */
public class DeveloperMessage extends Message {

    public DeveloperMessage() {
        this(null);
    }

    public DeveloperMessage(String content) {
        super("developer", content);
    }

    @Override
    public String toString() {
        return "DeveloperMessage{" +
                "role='" + getRole() + '\'' +
                ", content='" + getContent() + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }
}
