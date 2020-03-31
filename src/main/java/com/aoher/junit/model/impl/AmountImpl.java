package com.aoher.junit.model.impl;

import com.aoher.junit.model.Amount;
import com.aoher.junit.model.type.CurrencyType;

import java.math.BigDecimal;

public class AmountImpl implements Amount {

    private BigDecimal value;
    private CurrencyType currencyType;

    public AmountImpl(BigDecimal value, CurrencyType currencyType) {
        super();
        this.value = value;
        this.currencyType = currencyType;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public CurrencyType getCurrencyType() {
        return currencyType;
    }
}
