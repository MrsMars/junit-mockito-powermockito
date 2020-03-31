package com.aoher.junit.model;

import com.aoher.junit.model.type.CollateralType;

public interface Collateral {

    long getId();
    String getName();
    CollateralType getType();
}
