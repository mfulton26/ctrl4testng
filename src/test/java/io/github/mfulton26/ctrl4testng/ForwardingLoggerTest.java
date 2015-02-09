package io.github.mfulton26.ctrl4testng;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.NoInjection;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * This test class is simply here to document the fact that no unit testing is done for {@link ForwardingLogger} herein
 * as the class was generated using delegate methods in IntelliJ IDEA 14.
 *
 * @author Mark Fulton
 */
public class ForwardingLoggerTest {

    @DataProvider
    public static Iterator<Object[]> methods() {
        return FluentIterable.from(Arrays.asList(Logger.class.getDeclaredMethods()))
            .transform(new Function<Method, Object[]>() {
                @Override
                public Object[] apply(Method method) {
                    return new Object[]{ method };
                }
            })
            .iterator();
    }

    private final Logger mockedLogger = mock(Logger.class);
    private final Logger forwardingLogger = new ForwardingLogger() {
        @Override
        protected Logger delegate() {
            return mockedLogger;
        }
    };

    @Test(dataProvider = "methods")
    public void forwarding(@NoInjection Method method) throws InvocationTargetException, IllegalAccessException {
        final Object[] args = argsFor(method);
        method.invoke(forwardingLogger, args);
        method.invoke(verify(mockedLogger), args);
    }

    private static Object[] argsFor(Method method) {
        return FluentIterable.from(Arrays.asList(method.getParameterTypes()))
            .transform(new Function<Class<?>, Object>() {
                @Override
                public Object apply(Class<?> input) {
                    if (Marker.class.equals(input)) {
                        return MarkerFactory.getMarker("");
                    }
                    if (String.class.equals(input)) {
                        return "";
                    }
                    if (Throwable.class.equals(input)) {
                        return new Exception();
                    }
                    if (Object[].class.equals(input)) {
                        return new Object[0];
                    }
                    return new Object();
                }
            })
            .toArray(Object.class);
    }

}
