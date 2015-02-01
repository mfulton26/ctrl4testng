package org.ctrl4testng;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.google.common.base.Function;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.ASSERT;

/**
 * @author Mark Fulton
 */
public class CurrentTestResultLoggerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentTestResultLoggerTest.class);
    private static final CurrentTestResultLogger CURRENT_TEST_RESULT_LOGGER =
        (CurrentTestResultLogger) CurrentTestResultLoggerFactory.getLogger();
    private static final int PARALLEL_TEST_COUNT = 10;

    private final Set<Logger> loggers = Collections.newSetFromMap(new ConcurrentHashMap<Logger, Boolean>());
    private final CountDownLatch countDownLatch = new CountDownLatch(PARALLEL_TEST_COUNT);

    @DataProvider(parallel = true)
    public Iterator<Object[]> idsForUniqueLoggers() {
        return testDataForIdsFrom(Range.closedOpen(0, PARALLEL_TEST_COUNT));
    }

    /**
     * Confirm that each parallel test method gets its own delegated {@link Logger}.
     *
     * @param id an identifier used in the {@link Logger}'s name.
     * @throws InterruptedException if synchronizing ending all the parallel tests together fails.
     */
    @Test(dataProvider = "idsForUniqueLoggers")
    public void getLogger(String id) throws InterruptedException {
        try {
            LOGGER.info("checking for unique logger for current parallel test");
            Logger logger = CURRENT_TEST_RESULT_LOGGER.getLogger();
            ASSERT.that(loggers.add(logger)).isTrue();
            ASSERT.that(logger.getName()).contains(id);
        }
        finally {
            LOGGER.debug("waiting for other parallel test methods to synchronize return");
            countDownLatch.countDown();
            countDownLatch.await();
        }
    }

    private static Iterator<Object[]> testDataForIdsFrom(Range<Integer> range) {
        return FluentIterable.from(ContiguousSet.create(range, DiscreteDomain.integers()))
            .transform(new Function<Integer, Object[]>() {
                @Override
                public Object[] apply(Integer input) {
                    return new Object[]{ input.toString() };
                }
            })
            .iterator();
    }

}
