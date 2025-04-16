package org.apache.commons.lang3;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomStringUtilsTest {
    @Test
    public void testRandomAlphabetic() {
        String result = RandomStringUtils.randomAlphabetic(10);
        assertEquals(10, result.length());
        assertTrue(result.matches("[a-zA-Z]+"));
    }

    @Test
    public void testRandomNumeric() {
        String result = RandomStringUtils.randomNumeric(5);
        assertEquals(5, result.length());
        assertTrue(result.matches("[0-9]+"));
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void testRandomWithNegativeLength() {
//        RandomStringUtils.random(-1);
//    }

}
