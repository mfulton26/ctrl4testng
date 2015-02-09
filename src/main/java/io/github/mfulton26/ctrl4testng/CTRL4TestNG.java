package io.github.mfulton26.ctrl4testng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * This class is the main entry point to CTRL4TestNG.
 *
 * @author Mark Fulton
 * @see #LOGGER
 */
public class CTRL4TestNG extends ForwardingLogger {

    /**
     * The {@link Reporter#getCurrentTestResult() current test result} {@link Logger logger}.
     */
    public static final Logger LOGGER = new CTRL4TestNG();

    /**
     * The {@link ITestResult} attribute name used to store each respective test result's delegate {@link Logger}
     * instance.
     */
    public static final String LOGGER_ATTRIBUTE_NAME = "ctrl4testng.logger";

    private CTRL4TestNG() {
    }

    private final TestResultToLoggerNameFunction testResultToLoggerNameFunction =
        new TestResultToLoggerNameFunction();

    @Override
    protected Logger delegate() {
        Logger logger;
        ITestResult testResult = Reporter.getCurrentTestResult();
        Object attributeValue = testResult.getAttribute(LOGGER_ATTRIBUTE_NAME);
        if (attributeValue instanceof Logger) {
            logger = (Logger) attributeValue;
        }
        else {
            logger = LoggerFactory.getLogger(testResultToLoggerNameFunction.apply(testResult));
            testResult.setAttribute(LOGGER_ATTRIBUTE_NAME, logger);
        }
        return logger;
    }

}
