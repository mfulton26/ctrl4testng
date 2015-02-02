package io.github.mfulton26.ctrl4testng;

import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * This {@link Logger} simply loads {@link Logger}s associated with {@link ITestResult}s using a {@link CacheLoader} and
 * then delegates calls to the loaded {@link Logger}.
 *
 * @author Mark Fulton
 */
class CurrentTestResultLogger extends ForwardingLogger {

    private final LoadingCache<ITestResult, Logger> loadingCache = CacheBuilder.newBuilder()
        .build(CacheLoader.from(new Function<ITestResult, Logger>() {
            private final TestResultToLoggerNameFunction testResultToLoggerNameFunction =
                new TestResultToLoggerNameFunction();

            @Override
            public Logger apply(ITestResult input) {
                return LoggerFactory.getLogger(testResultToLoggerNameFunction.apply(input));
            }
        }));

    @Override
    protected Logger getLogger() {
        return loadingCache.getUnchecked(Reporter.getCurrentTestResult());
    }

}
