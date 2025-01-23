package io.github.fvarrui.jeppetto.api.chat.completions;

/**
 * The reasoning effort required to generate the completion.
 */
public enum ReasoningEffort {
    LOW,
    MEDIUM,
    HIGH;

    private final String value;

    ReasoningEffort() {
        this.value = this.name().toLowerCase();
    }

    public String getValue() {
        return value;
    }

    public static ReasoningEffort fromValue(String value) {
        for (ReasoningEffort reasoningEffort : ReasoningEffort.values()) {
            if (reasoningEffort.getValue().equals(value)) {
                return reasoningEffort;
            }
        }
        throw new IllegalArgumentException("Invalid reasoning effort value: " + value);
    }
    
}
