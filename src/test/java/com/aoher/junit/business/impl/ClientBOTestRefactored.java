package com.aoher.junit.business.impl;

import com.aoher.junit.business.ClientBO;
import com.aoher.junit.business.exception.DifferentCurrenciesException;
import com.aoher.junit.model.Amount;
import com.aoher.junit.model.Product;
import com.aoher.junit.model.impl.AmountImpl;
import com.aoher.junit.model.impl.ProductImpl;
import com.aoher.junit.model.type.CurrencyType;
import com.aoher.junit.model.type.ProductType;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ClientBOTestRefactored {

    private ClientBO clientBO = new ClientBOImpl();

    @Test
    public void testClientProductSum_AllProductsSameCurrency() throws DifferentCurrenciesException {

        Amount[] amounts = {
                new AmountImpl(new BigDecimal("5.0"), CurrencyType.EURO),
                new AmountImpl(new BigDecimal("6.0"), CurrencyType.EURO)
        };

        Amount expected = new AmountImpl(new BigDecimal("11.0"), CurrencyType.EURO);

        List<Product> products = createProductListWithAmounts(amounts);
        Amount actual = clientBO.getClientProductsSum(products);

        assertAmount(actual, expected);
    }

    @Test(expected = DifferentCurrenciesException.class)
    public void testClientProductSum_DifferentCurrencies_ThrowsException()
            throws DifferentCurrenciesException {

        Amount[] amounts = {
                new AmountImpl(new BigDecimal("5.0"), CurrencyType.EURO),
                new AmountImpl(new BigDecimal("6.0"), CurrencyType.INDIAN_RUPEE)
        };
        List<Product> products = createProductListWithAmounts(amounts);

        clientBO.getClientProductsSum(products);
    }

    @Test
    public void testClientProductSum_NoProducts() throws DifferentCurrenciesException {
        Amount[] amounts = {};
        Amount expected = new AmountImpl(BigDecimal.ZERO, CurrencyType.EURO);

        List<Product> products = createProductListWithAmounts(amounts);
        Amount actual = clientBO.getClientProductsSum(products);

        assertAmount(actual, expected);
    }

    private void assertAmount(Amount actual, Amount expected) {
        assertEquals(expected.getCurrencyType(), actual.getCurrencyType());
        assertEquals(expected.getValue(), actual.getValue());
    }

    private List<Product> createProductListWithAmounts(Amount[] amounts) {
        return Arrays.stream(amounts)
                .map(amount -> new ProductImpl(100, "Product 15",
                        ProductType.BANK_GUARANTEE, amount))
                .collect(Collectors.toList());
    }
}
