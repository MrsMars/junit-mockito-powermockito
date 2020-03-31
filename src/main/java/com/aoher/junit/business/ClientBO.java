package com.aoher.junit.business;

import com.aoher.junit.business.exception.DifferentCurrenciesException;
import com.aoher.junit.model.Amount;
import com.aoher.junit.model.Product;

import java.util.List;

public interface ClientBO {

    Amount getClientProductsSum(List<Product> products) throws DifferentCurrenciesException;
}
