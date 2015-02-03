package io.github.mfulton26.ctrl4testng;

import com.google.common.base.MoreObjects;
import org.slf4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Example output:
 * <pre>
 *     10:45:12.258 [main] INFO  log{} on DataDrivenClass{message=message 1} in ctrl4testng - message 1
 *     10:45:12.263 [main] INFO  log{} on DataDrivenClass{message=message 2} in ctrl4testng - message 2
 *     10:45:12.266 [main] INFO  info{message 1} on DataDrivenMethod{} in ctrl4testng - message 1
 *     10:45:12.266 [main] INFO  info{message 2} on DataDrivenMethod{} in ctrl4testng - message 2
 *     10:45:12.269 [main] ERROR error{} on Simple{} in ctrl4testng - this is an error log message
 *     10:45:12.270 [main] INFO  info{} on Simple{} in ctrl4testng - this is an informational log message
 *     10:45:12.272 [main] WARN  warn{} on Simple{} in ctrl4testng - this is a warning log message
 * </pre>
 *
 * @author Mark Fulton
 */
public class CurrentTestResultLoggerExampleTest {

    private static final Logger LOGGER = CurrentTestResultLoggerFactory.getLogger();

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
