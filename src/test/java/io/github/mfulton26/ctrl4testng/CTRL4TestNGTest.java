package io.github.mfulton26.ctrl4testng;

import org.testng.annotations.Test;

import static com.google.common.truth.Truth.ASSERT;
import static io.github.mfulton26.ctrl4testng.CTRL4TestNG.LOGGER;

/**
 * @author Mark Fulton (mfulton@familysearch.org)
 */
public class CTRL4TestNGTest {

    @Test
    public void instance() {
        ASSERT.that(LOGGER).isSameAs(LOGGER);
    }

}
