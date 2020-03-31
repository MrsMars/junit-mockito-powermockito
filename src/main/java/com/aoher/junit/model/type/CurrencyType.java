package com.aoher.junit.model.type;

public enum CurrencyType {

    EURO("EUR"),
    UNITED_STATES_DOLLAR("USD"),
    INDIAN_RUPEE("INR");

    private final String textValue;

    CurrencyType(final String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return textValue;
    }
}
