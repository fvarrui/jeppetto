package io.github.fvarrui.jeppetto.api.chat.completions;

/**
 * Messages sent by the model in response to user messages.
 */
public class AssistantMessage extends Message {

    /**
     * The refusal message by the assistant.
     */
    private String refusal;

    public AssistantMessage() {
        super();
        setRole("assistant");
    }

    public void setRefusal(String refusal) {
        this.refusal = refusal;
    }

    public String getRefusal() {
        return refusal;
    }

}
