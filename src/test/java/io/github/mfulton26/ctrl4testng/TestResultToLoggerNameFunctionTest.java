package io.github.mfulton26.ctrl4testng;

import io.github.mfulton26.ctrl4testng.mock.MockedTestResultBuilder;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.ASSERT;

/**
 * @author Mark Fulton
 */
public class TestResultToLoggerNameFunctionTest {

    private static final TestResultToLoggerNameFunction TEST_RESULT_TO_LOGGER_NAME_FUNCTION =
        new TestResultToLoggerNameFunction();

    @DataProvider
    public static Object[][] testResultsWithExpectedLoggerNames() {
        return new Object[][]{
            {
                new MockedTestResultBuilder()
                    .currentXmlTestName("some test name")
                    .name("toString")
                    .instanceName("java.lang.Object")
                    .build(),
                "toString{} on Object{} in some test name"
            },
            {
                new MockedTestResultBuilder()
                    .currentXmlTestName("some test name")
                    .name("equals")
                    .instanceName("java.lang.Object")
                    .parameters("something")
                    .build(),
                "equals{something} on Object{} in some test name"
            },
            {
                new MockedTestResultBuilder()
                    .currentXmlTestName("some test name")
                    .name("methodName")
                    .instanceName("java.lang.Object")
                    .parameters("foo", "bar", "baz")
                    .build(),
                "methodName{foo, bar, baz} on Object{} in some test name"
            },
            {
                new MockedTestResultBuilder()
                    .currentXmlTestName("some test name")
                    .name("equals")
                    .instanceName("java.lang.String")
                    .parameters("something")
                    .build(),
                "equals{something} on String{} in some test name"
            },
            {
                new MockedTestResultBuilder()
                    .currentXmlTestName("some test name")
                    .name("equals on String{something else}")
                    .parameters("something")
                    .build(),
                "equals{something} on String{something else} in some test name"
            },
            {
                new MockedTestResultBuilder()
                    .currentXmlTestName("some test name")
                    .name("methodName on instance{blah, blah, blah}")
                    .parameters("foo", "bar", "baz")
                    .build(),
                "methodName{foo, bar, baz} on instance{blah, blah, blah} in some test name"
            },
            {
                new MockedTestResultBuilder()
                    .currentXmlTestName("some test name")
                    .name("methodName on instance{blah, blah, blah} on fire")
                    .parameters("foo", "bar", "baz")
                    .build(),
                "methodName{foo, bar, baz} on instance{blah, blah, blah} on fire in some test name"
            },
            {
                new MockedTestResultBuilder()
                    .currentXmlTestName("some other test name")
                    .name("toString")
                    .instanceName("java.lang.Object")
                    .build(),
                "toString{} on Object{} in some other test name"
            },
            {
                new MockedTestResultBuilder()
                    .currentXmlTestName("yet another test name")
                    .name("equals")
                    .instanceName("java.lang.Object")
                    .parameters(new Object[]{ null })
                    .build(),
                "equals{null} on Object{} in yet another test name"
            }
        };
    }

    @Test(dataProvider = "testResultsWithExpectedLoggerNames")
    public void from(ITestResult testResult, String expected) {
        ASSERT.that(TEST_RESULT_TO_LOGGER_NAME_FUNCTION.apply(testResult)).isEqualTo(expected);
    }

}
