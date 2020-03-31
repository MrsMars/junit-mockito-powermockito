package com.aoher.junit.model.type;

import java.util.Collections;
import java.util.List;

public enum ClientType {

    PRIVATE("P"),
    BUSINESS("Z");

    private final String textValue;

    /**
     * List of natural person types.
     */
    public static final List<String> NATURAL_PERSON_TYPES =
            Collections.singletonList(ClientType.PRIVATE.toString());

    /**
     * List of corporate types.
     */
    public static final List<String> CORPORATE_TYPES =
            Collections.singletonList(ClientType.BUSINESS.toString());

    ClientType(final String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return textValue;
    }
}
