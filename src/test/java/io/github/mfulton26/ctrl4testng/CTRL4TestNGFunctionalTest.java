package io.github.mfulton26.ctrl4testng;

import com.google.common.base.MoreObjects;
import org.slf4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Logger category format: [method-name]{[method-parameters]} on [class-name]{[class-parameters]} in [xml-suite-name]
 * Example output:
 * <pre>
 *     11:11:09.335 [main] INFO  log{} on DataDrivenClass{message=message 1} in ctrl4testng - message 1
 *     11:11:09.339 [main] INFO  log{} on DataDrivenClass{message=message 2} in ctrl4testng - message 2
 *     11:11:09.342 [main] INFO  info{message 1} on DataDrivenMethod{} in ctrl4testng - message 1
 *     11:11:09.342 [main] INFO  info{message 2} on DataDrivenMethod{} in ctrl4testng - message 2
 *     11:11:09.344 [main] ERROR error{} on Simple{} in ctrl4testng - this is an error log message
 *     11:11:09.346 [main] INFO  info{} on Simple{} in ctrl4testng - this is an informational log message
 *     11:11:09.347 [main] WARN  warn{} on Simple{} in ctrl4testng - this is a warning log message
 *     11:11:09.349 [main] INFO  tearDownMethod{} on Simple{} in ctrl4testng - supports before and after methods too
 * </pre>
 *
 * @author Mark Fulton
 */
@Test
public class CTRL4TestNGFunctionalTest {

    private static final Logger LOGGER = CTRL4TestNG.LOGGER;

    public static class Simple {

        @Test
        public void info() {
            LOGGER.info("this is an informational log message");
        }

        @Test
        public void warn() {
            LOGGER.warn("this is a warning log message");
        }

        @Test
        public void error() {
            LOGGER.error("this is an error log message");
        }

        @AfterClass
        public void tearDownMethod() {
            LOGGER.info("supports before and after methods too");
        }

    }

    public static abstract class DataDriven {

        @DataProvider
        public static Object[][] messages() {
            return new Object[][]{
                { "message 1" },
                { "message 2" }
            };
        }

    }

    public static class DataDrivenMethod extends DataDriven {

        @Test(dataProvider = "messages")
        public void info(String message) {
            LOGGER.info(message);
        }

    }

    public static class DataDrivenClass extends DataDriven {

        private final String message;

        @Factory(dataProvider = "messages")
        public DataDrivenClass(String message) {
            this.message = message;
        }

        @Test
        public void log() {
            LOGGER.info(message);
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this)
                .add("message", message)
                .toString();
        }

    }

}
