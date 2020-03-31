package com.aoher.junit.model;

import com.aoher.junit.model.type.CurrencyType;

import java.math.BigDecimal;

public interface Amount {

    BigDecimal getValue();
    CurrencyType getCurrencyType();
}
