package com.aoher.junit.business.impl;

import com.aoher.junit.business.ClientBO;
import com.aoher.junit.business.exception.DifferentCurrenciesException;
import com.aoher.junit.model.Amount;
import com.aoher.junit.model.Product;
import com.aoher.junit.model.impl.AmountImpl;
import com.aoher.junit.model.impl.ProductImpl;
import com.aoher.junit.model.type.CurrencyType;
import com.aoher.junit.model.type.ProductType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ClientBOImplTest {

    private static ClientBO clientBO;
    private static Product product1;
    private static Product product2;
    private static Product product3;

    @BeforeClass
    public static void setUp() {
        clientBO = new ClientBOImpl();

        product1 = new ProductImpl(100, "Product 15",
                ProductType.BANK_GUARANTEE, new AmountImpl(
                new BigDecimal("5.0"), CurrencyType.EURO));

        product2 = new ProductImpl(120, "Product 20",
                ProductType.BANK_GUARANTEE, new AmountImpl(
                new BigDecimal("6.0"), CurrencyType.EURO));

        product3 = new ProductImpl(100, "Product 15",
                ProductType.BANK_GUARANTEE, new AmountImpl(
                new BigDecimal("5.0"), CurrencyType.INDIAN_RUPEE));
    }

    @Test
    public void testClientProductSum() throws DifferentCurrenciesException {
        List<Product> products = Arrays.asList(product1, product2);

        Amount temp = clientBO.getClientProductsSum(products);

        assertEquals(CurrencyType.EURO, temp.getCurrencyType());
        assertEquals(new BigDecimal("11.0"), temp.getValue());
    }

    @Test(expected = DifferentCurrenciesException.class)
    public void testClientProductSum1() throws DifferentCurrenciesException {
        List<Product> products = new ArrayList<>();

        products.add(product1);
        products.add(product3);

        clientBO.getClientProductsSum(products);
    }

    @Test
    public void testClientProductSum2() throws DifferentCurrenciesException {
        List<Product> products = new ArrayList<>();

        Amount temp = clientBO.getClientProductsSum(products);

        assertEquals(CurrencyType.EURO, temp.getCurrencyType());
        assertEquals(BigDecimal.ZERO, temp.getValue());
    }
}