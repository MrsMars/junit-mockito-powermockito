package com.aoher.junit.model.type;

public enum ProductType {

    LOAN("LN"),
    KREDIT("KRD"),
    BANK_GUARANTEE("BG");

    private final String textValue;

    ProductType(String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return textValue;
    }
}
