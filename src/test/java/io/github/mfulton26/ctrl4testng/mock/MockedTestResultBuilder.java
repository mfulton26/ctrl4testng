package io.github.mfulton26.ctrl4testng.mock;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Mark Fulton
 */
public class MockedTestResultBuilder {

    private ITestContext testContext;
    private String name;
    private String instanceName;
    private Object[] parameters = new Object[0];

    public MockedTestResultBuilder testContext(ITestContext testContext) {
        this.testContext = testContext;
        return this;
    }

    public MockedTestResultBuilder currentXmlTestName(String currentXmlTestName) {
        XmlTest mockedXmlTest = mock(XmlTest.class);
        when(mockedXmlTest.getName()).thenReturn(currentXmlTestName);
        ITestContext mockedTestContext = mock(ITestContext.class);
        when(mockedTestContext.getCurrentXmlTest()).thenReturn(mockedXmlTest);
        return testContext(mockedTestContext);
    }

    public MockedTestResultBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MockedTestResultBuilder instanceName(String instanceName) {
        this.instanceName = instanceName;
        return this;
    }

    public MockedTestResultBuilder parameters(Object... parameters) {
        this.parameters = parameters;
        return this;
    }

    public ITestResult build() {
        ITestResult mockedTestResult;
        mockedTestResult = mock(ITestResult.class);
        when(mockedTestResult.getTestContext()).thenReturn(testContext);
        when(mockedTestResult.getName()).thenReturn(name);
        when(mockedTestResult.getInstanceName()).thenReturn(instanceName);
        when(mockedTestResult.getParameters()).thenReturn(parameters);
        return mockedTestResult;
    }

}
