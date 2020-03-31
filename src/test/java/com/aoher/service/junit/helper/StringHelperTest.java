package com.aoher.service.junit.helper;

import com.aoher.junit.helper.StringHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringHelperTest {

    // AACD => CD ACD => CD CDEF=>CDEF CDAA => CDAA
    private StringHelper helper;

    @Before
    public void before(){
        helper = new StringHelper();
    }

    @Test
    public void testTruncateAInFirst2PositionsAinFirst2Positions() {
        assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    public void testTruncateAInFirst2PositionsAinFirstPosition() {
        assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
    }

    // ABCD => false, ABAB => true, AB => true, A => false
    @Test
    public void testAreFirstAndLastTwoCharactersTheSameBasicNegativeScenario() {
        assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    }

    @Test
    public void testAreFirstAndLastTwoCharactersTheSameBasicPositiveScenario() {
        assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
    }
}
