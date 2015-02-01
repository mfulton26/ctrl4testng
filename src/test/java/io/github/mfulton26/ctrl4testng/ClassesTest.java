package io.github.mfulton26.ctrl4testng;

import com.google.common.util.concurrent.UncheckedExecutionException;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.ASSERT;

/**
 * @author Mark Fulton
 */
public class ClassesTest {

    @Test
    public static void uncheckedForKnownName() {
        ASSERT.that(Classes.uncheckedForName("java.lang.String")).isEqualTo(String.class);
    }

    @Test(expectedExceptions = { UncheckedExecutionException.class })
    public static void uncheckedForUnknownName() {
        Classes.uncheckedForName("java.unknown.Unknown");
    }

}
