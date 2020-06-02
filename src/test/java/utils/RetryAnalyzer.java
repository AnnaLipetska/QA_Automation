package test.java.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int currentCount = 1;
    private final int MAX = 2;   // Максимальное к-во раз, которые можно прогонять тест

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentCount < MAX) {
            currentCount++;
            return true; // Мы хотим перезапустить тест
        }
        return false;
    }
}
