package com.aoher.service.junit.suite;

import com.aoher.service.junit.helper.ArraysTest;
import com.aoher.service.junit.helper.StringHelperTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ArraysTest.class, StringHelperTest.class})
public class DummyTestSuite {

}