package io.github.mfulton26.ctrl4testng;

import org.slf4j.Logger;
import org.testng.Reporter;

/**
 * This class is the main entry point to CTRL4TestNG.
 *
 * @author Mark Fulton
 * @see #LOGGER
 */
public class CTRL4TestNG {

    private CTRL4TestNG() {
    }

    /**
     * The {@link Reporter#getCurrentTestResult() current test result} {@link Logger logger}.
     */
    public static final Logger LOGGER = new CurrentTestResultLogger();

}
