package org.apache.commons.lang3;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtilsManualTest {

    private static int totalTests = 0;
    private static int passedTests = 0;
    private static int failedTests = 0;

    public static void main(String[] args) {
        System.out.println("=== 开始 RandomStringUtils 手动测试 ===");

        testRandomAlphabetic();
        testRandomNumeric();
        testRandomWithCustomChars();
        testNegativeLength();

        System.out.println("\n=== 测试结果摘要 ===");
        System.out.println("总测试数: " + totalTests);
        System.out.println("通过数: " + passedTests);
        System.out.println("失败数: " + failedTests);
    }

    private static void testRandomAlphabetic() {
        System.out.println("\n测试 randomAlphabetic 方法...");

        // 测试用例1
        String result1 = RandomStringUtils.randomAlphabetic(10);
        checkResult("生成长度为10的字母字符串",
                result1.length() == 10 && result1.matches("[a-zA-Z]+"));

        // 测试用例2
        String result2 = RandomStringUtils.randomAlphabetic(0);
        checkResult("生成长度为0的字符串", result2.isEmpty());
    }

    private static void testRandomNumeric() {
        System.out.println("\n测试 randomNumeric 方法...");

        // 测试用例1
        String result1 = RandomStringUtils.randomNumeric(5);
        checkResult("生成长度为5的数字字符串",
                result1.length() == 5 && result1.matches("[0-9]+"));

        // 测试用例2
        String result2 = RandomStringUtils.randomNumeric(1);
        checkResult("生成长度为1的数字字符串",
                result2.length() == 1 && result2.matches("[0-9]"));
    }

    private static void testRandomWithCustomChars() {
        System.out.println("\n测试 random 方法（自定义字符集）...");

        char[] chars = {'a', 'b', 'c', '1', '2', '3'};
        String result = RandomStringUtils.random(8, chars);
        checkResult("使用自定义字符集生成字符串",
                result.length() == 8 && result.matches("[a-c1-3]+"));
    }

    private static void testNegativeLength() {
        System.out.println("\n测试负数字符串长度（注入的缺陷）...");

        try {
            String result = RandomStringUtils.random(-1);
            // 如果执行到这里，说明缺陷存在
            checkResult("传入负长度应该抛出异常", false);
            System.out.println("实际返回: \"" + result + "\"");
        } catch (Exception e) {
            checkResult("传入负长度正确抛出了异常", true);
        }
    }

    private static void checkResult(String description, boolean passed) {
        totalTests++;
        if (passed) {
            passedTests++;
            System.out.println("✓ 测试通过: " + description);
        } else {
            failedTests++;
            System.out.println("✖ 测试失败: " + description);
        }
    }
}