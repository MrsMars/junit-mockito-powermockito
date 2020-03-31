package com.aoher.junit.model;

import com.aoher.junit.model.type.ProductType;

public interface Product {

    long getId();
    String getName();
    ProductType getType();
    Amount getAmount();
}
