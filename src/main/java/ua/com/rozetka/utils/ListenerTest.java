package ua.com.rozetka.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

    @Override
    public void onFinish(ITestContext result) {
        System.out.println("This is onFinish method" +result.getPassedTests());
        System.out.println("This is onFinish method" +result.getFailedTests());
    }

    @Override
    public void onStart(ITestContext result) {
        System.out.println("This is onStart method" +result.getOutputDirectory());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage" +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("The name of the testcase failed is :" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("The name of the testcase Skipped is :" + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " test case started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The name of the testcase passed is :" + result.getName());
    }
}
