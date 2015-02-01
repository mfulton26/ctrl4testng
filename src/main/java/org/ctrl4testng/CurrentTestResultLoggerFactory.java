package org.ctrl4testng;

import com.google.common.base.Supplier;
import org.slf4j.Logger;
import org.testng.Reporter;

/**
 * {@code CurrentTestResultLoggerFactory} is a utility class producing a singleton {@link Logger} for the {@link
 * Reporter#getCurrentTestResult() current test result}.
 *
 * @author Mark Fulton
 * @see #getLogger()
 */
public class CurrentTestResultLoggerFactory {

    private enum LoggerSupplier implements Supplier<Logger> {
        INSTANCE {
            private final Logger logger = new CurrentTestResultLogger();

            @Override
            public Logger get() {
                return logger;
            }
        };
    }

    private CurrentTestResultLoggerFactory() {
    }

    /**
     * Return a logger for the {@link Reporter#getCurrentTestResult() current test result}.
     *
     * @return logger
     */
    public static Logger getLogger() {
        return LoggerSupplier.INSTANCE.get();
    }

}
