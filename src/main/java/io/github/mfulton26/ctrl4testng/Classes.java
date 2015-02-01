package io.github.mfulton26.ctrl4testng;

import com.google.common.util.concurrent.UncheckedExecutionException;

/**
 * Simple helper class for working with {@link Class}.
 *
 * @author Mark Fulton
 */
class Classes {

    private Classes() {
    }

    /**
     * Similar to {@link Class#forName(String)} except does not throw a checked exception.
     *
     * @param className the fully qualified name of the desired class.
     * @return the {@code Class} object for the class with the specified name.
     *
     * @throws UncheckedExecutionException if an exception was thrown upon calling {@link Class#forName(String)}.
     */
    public static Class uncheckedForName(String className) {
        try {
            return Class.forName(className);
        }
        catch (ClassNotFoundException e) {
            throw new UncheckedExecutionException(e);
        }
    }

}
