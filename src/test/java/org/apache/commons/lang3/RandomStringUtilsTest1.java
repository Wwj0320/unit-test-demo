package org.apache.commons.lang3;

import junit.framework.TestCase;
import java.util.regex.Pattern;

public class RandomStringUtilsTest1 extends TestCase {

    // 测试随机字母字符串生成
    public void testRandomAlphabetic() {
        int length = 10;
        String result = RandomStringUtils.randomAlphabetic(length);

        assertEquals("生成的字符串长度不正确", length, result.length());
        assertTrue("生成的字符串应只包含字母", Pattern.matches("[a-zA-Z]+", result));
    }

    // 测试随机数字字符串生成
    public void testRandomNumeric() {
        int length = 5;
        String result = RandomStringUtils.randomNumeric(length);

        assertEquals("生成的字符串长度不正确", length, result.length());
        assertTrue("生成的字符串应只包含数字", Pattern.matches("[0-9]+", result));
    }

    // 测试自定义字符集的随机字符串生成
    public void testRandomWithCustomChars() {
        int length = 8;
        char[] chars = {'a', 'b', 'c', '1', '2', '3'};
        String result = RandomStringUtils.random(length, chars);

        assertEquals("生成的字符串长度不正确", length, result.length());
        assertTrue("生成的字符串应只包含指定字符", Pattern.matches("[a-c1-3]+", result));
    }

    // 测试长度为0的情况
    public void testRandomWithZeroLength() {
        String result = RandomStringUtils.random(0);
        assertEquals("长度0应返回空字符串", "", result);
    }

    // 测试负长度（应抛出异常）
    public void testRandomWithNegativeLength() {
        try {
            RandomStringUtils.random(-1);
            fail("应该抛出IllegalArgumentException异常");
        } catch (IllegalArgumentException e) {
            // 这是预期的行为
            assertTrue("异常消息应包含'negative'", e.getMessage().contains("negative"));
        }
    }

    // 测试固定随机种子生成可预测结果
    public void testRandomWithFixedSeed() {
        long seed = 12345L;
        String result1 = RandomStringUtils.random(5, 0, 0, true, true, null, new java.util.Random(seed));
        String result2 = RandomStringUtils.random(5, 0, 0, true, true, null, new java.util.Random(seed));

        assertEquals("相同种子应生成相同字符串", result1, result2);
    }

    // 测试只包含字母的随机字符串
    public void testRandomAlphabeticOnly() {
        int length = 7;
        String result = RandomStringUtils.random(length, true, false);

        assertEquals("生成的字符串长度不正确", length, result.length());
        assertTrue("生成的字符串应只包含字母", Pattern.matches("[a-zA-Z]+", result));
    }

    // 测试只包含数字的随机字符串
    public void testRandomNumericOnly() {
        int length = 4;
        String result = RandomStringUtils.random(length, false, true);

        assertEquals("生成的字符串长度不正确", length, result.length());
        assertTrue("生成的字符串应只包含数字", Pattern.matches("[0-9]+", result));
    }
}