package io.github.mfulton26.ctrl4testng;

import java.util.Iterator;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.slf4j.Logger;
import org.testng.ITestResult;

/**
 * A {@link Function} that takes an {@link ITestResult} as input and returns a {@link String} intended for the name of a
 * {@link Logger}.
 *
 * @author Mark Fulton
 */
class TestResultToLoggerNameFunction implements Function<ITestResult, String> {

    @Override
    public String apply(ITestResult input) {
        String currentXmlTestName = input.getTestContext().getCurrentXmlTest().getName();
        String currentTestResultName = input.getName();
        Iterator<String> iterator = Splitter.on(" on ").limit(2).split(currentTestResultName).iterator();
        String methodName = iterator.next();
        String instanceString = iterator.hasNext()
            ? iterator.next()
            : Classes.uncheckedForName(input.getInstanceName()).getSimpleName() + "{}";
        String parametersString = Joiner.on(", ").useForNull("null").join(input.getParameters());
        return String.format("%s{%s} on %s in %s", methodName, parametersString, instanceString,
                             currentXmlTestName);
    }

}
