package io.github.fvarrui.jeppetto.api.chat.completions;

/**
 * Developer-provided instructions that the model should follow, regardless of messages sent by the user.
 * With o1 models and newer, use developer messages for this purpose instead.
 */
public class SystemMessage extends Message {

    public SystemMessage() {
        this(null);
    }

    public SystemMessage(String content) {
        super("system", content);
    }

    @Override
    public String toString() {
        return "SystemMessage{" +
                "role='" + getRole() + '\'' +
                ", content='" + getContent() + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }
}
