package com.aoher.service.junit.helper;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickBeforeAfterTest {

    private static final Logger log = LoggerFactory.getLogger(QuickBeforeAfterTest.class);

    @BeforeClass
    public static void beforeClass(){
        log.info("Before Class");
    }

    @Before
    public void setup(){
        log.info("Before Test");
    }

    @Test
    public void test1() {
        log.info("test1 executed");
    }

    @Test
    public void test2() {
        log.info("test2 executed");
    }

    @After
    public void tearDown() {
        log.info("After test");
    }

    @AfterClass
    public static void afterClass(){
        log.info("After Class");
    }
}
