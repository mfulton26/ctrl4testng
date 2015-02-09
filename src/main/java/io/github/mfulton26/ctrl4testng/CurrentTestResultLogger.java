package io.github.mfulton26.ctrl4testng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * This {@link Logger} simply loads {@link Logger}s associated with {@link ITestResult}s and then delegates calls to the
 * loaded {@link Logger}.
 *
 * @author Mark Fulton
 */
class CurrentTestResultLogger extends ForwardingLogger {

    public static final String LOGGER_ATTRIBUTE_NAME = "ctrl4testng.logger";

    private final TestResultToLoggerNameFunction testResultToLoggerNameFunction =
        new TestResultToLoggerNameFunction();

    @Override
    protected Logger getLogger() {
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
