package io.github.fvarrui.jeppetto.api.chat.completions;

/**
 * Represents a message that the model should respond to or sends to the user.
 */
public class Message {

    /**
     * The role of the message. Can be "user", "assistant", "developer", or "system".
     */
    private String role;

    /**
     * The content of the message.
     */
    private String content;

    /**
     * The name of the message.
     */
    private String name;

    public Message() {}

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Message{" +
                "role='" + role + '\'' +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
