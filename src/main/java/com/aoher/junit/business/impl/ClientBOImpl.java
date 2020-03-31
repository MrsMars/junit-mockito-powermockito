package com.aoher.junit.business.impl;

import com.aoher.junit.business.ClientBO;
import com.aoher.junit.business.exception.DifferentCurrenciesException;
import com.aoher.junit.model.Amount;
import com.aoher.junit.model.Product;
import com.aoher.junit.model.impl.AmountImpl;
import com.aoher.junit.model.type.CurrencyType;

import java.math.BigDecimal;
import java.util.List;

public class ClientBOImpl implements ClientBO {

    public Amount getClientProductsSum(List<Product> products)
            throws DifferentCurrenciesException {

        if (products.isEmpty())
            return new AmountImpl(BigDecimal.ZERO, CurrencyType.EURO);

        if (!isCurrencySameForAllProducts(products)) {
            throw new DifferentCurrenciesException();
        }

        BigDecimal productSum = calculateProductSum(products);

        CurrencyType firstProductCurrency = products.get(0).getAmount()
                .getCurrencyType();

        return new AmountImpl(productSum, firstProductCurrency);
    }

    private BigDecimal calculateProductSum(List<Product> products) {
        BigDecimal sum = BigDecimal.ZERO;

        for (Product product : products) {
            sum = sum.add(product.getAmount().getValue());
        }
        return sum;
    }

    private boolean isCurrencySameForAllProducts(List<Product> products) {

        CurrencyType firstProductCurrency = products.get(0).getAmount()
                .getCurrencyType();

        for (Product product : products) {
            boolean currencySameAsFirstProduct = product.getAmount()
                    .getCurrencyType().equals(firstProductCurrency);
            if (!currencySameAsFirstProduct) {
                return false;
            }
        }
        return true;
    }
}
