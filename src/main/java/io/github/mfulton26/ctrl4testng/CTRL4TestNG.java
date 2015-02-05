package io.github.mfulton26.ctrl4testng;

import org.slf4j.Logger;

/**
 * This class can be used as the main entry point to CTRL4TestNG.
 *
 * @author Mark Fulton
 * @see #LOGGER
 */
public class CTRL4TestNG {

    private CTRL4TestNG() {
    }

    /**
     * Convenience access to {@link CurrentTestResultLoggerFactory#getLogger()}. e.g. You can statically import this
     * constant field into your test class and start logging:
     * <pre>
     *     import static io.github.mfulton26.ctrl4testng.CTRL4TestNG.LOGGER;
     * </pre>
     */
    public static final Logger LOGGER = CurrentTestResultLoggerFactory.getLogger();

}
