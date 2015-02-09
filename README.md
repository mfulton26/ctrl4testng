# CTRL4TestNG: Current Test Result Logger for TestNG

[![Build Status](https://travis-ci.org/mfulton26/ctrl4testng.svg?branch=master)](https://travis-ci.org/mfulton26/ctrl4testng)
[![Coverage Status](https://coveralls.io/repos/mfulton26/ctrl4testng/badge.svg?branch=master)](https://coveralls.io/r/mfulton26/ctrl4testng?branch=master)

The [Current Test Result Logger for TestNG (CTRL4TestNG)](https://mfulton26.github.io/ctrl4testng/) provides an [SLF4J](http://www.slf4j.org/) [Logger](http://slf4j.org/api/org/slf4j/Logger.html) that can be used from any [TestNG](http://testng.org/) method tied to an [ITestResult](http://testng.org/javadoc/org/testng/ITestResult.html) (i.e. methods annotated as [Test](http://testng.org/javadoc/org/testng/annotations/Test.html), [BeforeClass](http://testng.org/javadoc/org/testng/annotations/BeforeClass.html), [AfterClass](http://testng.org/javadoc/org/testng/annotations/AfterClass.html), etc.). Each separate method will have its own unique Logger and can be used with TestNG's [parallel testing support](http://testng.org/doc/documentation-main.html#parallel-running) making it clear which logs came from which method even when [data-driven](http://en.wikipedia.org/wiki/Data-driven_testing) by means of [DataProviders](http://testng.org/doc/documentation-main.html#parameters-dataproviders) and/or [Factories](http://testng.org/doc/documentation-main.html#factories).

## Usage

Simply change your [SLF4J](http://www.slf4j.org/) [Logger](http://slf4j.org/api/org/slf4j/Logger.html) initializations in your code to use [CTRL4TestNG](https://github.com/mfulton26/ctrl4testng/blob/master/src/main/java/io/github/mfulton26/ctrl4testng/CTRL4TestNG.java)'s `LOGGER` constant instead of [SLF4J](http://www.slf4j.org/)'s [LoggerFactory](http://slf4j.org/api/org/slf4j/LoggerFactory.html).
See [CTRL4TestNGExampleTest](https://github.com/mfulton26/ctrl4testng/blob/master/src/test/java/io/github/mfulton26/ctrl4testng/CTRL4TestNGExampleTest.java) for an example including example output.

As [CTRL4TestNG](https://github.com/mfulton26/ctrl4testng/blob/master/src/main/java/io/github/mfulton26/ctrl4testng/CTRL4TestNG.java)'s `LOGGER` constant is a `public static` you can also use it through [static import](http://en.wikipedia.org/wiki/Static_import).

### Logger Category Format

[CTRL4TestNG](https://github.com/mfulton26/ctrl4testng/blob/master/src/main/java/io/github/mfulton26/ctrl4testng/CTRL4TestNG.java) forwards logging requests to a unique [Logger](http://slf4j.org/api/org/slf4j/Logger.html) for each Before/After/Test TestNG method. Each method's logger is named using the following format:
```
[method-name]{[method-parameters]} on [class-instance-string] in [xml-suite-name]
```

The *class-instance-string* is either the test class's [`toString()`](http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#toString()) return value, if overriden, or the test class's [simple name](http://docs.oracle.com/javase/7/docs/api/java/lang/Class.html#getSimpleName()).

### Example Output

The following example output is from running [CTRL4TestNGExampleTest](https://github.com/mfulton26/ctrl4testng/blob/master/src/test/java/io/github/mfulton26/ctrl4testng/CTRL4TestNGExampleTest.java) with [TestNG](http://testng.org/).
```
11:11:09.335 [main] INFO  log{} on DataDrivenClass{message=message 1} in ctrl4testng - message 1
11:11:09.339 [main] INFO  log{} on DataDrivenClass{message=message 2} in ctrl4testng - message 2
11:11:09.342 [main] INFO  info{message 1} on DataDrivenMethod{} in ctrl4testng - message 1
11:11:09.342 [main] INFO  info{message 2} on DataDrivenMethod{} in ctrl4testng - message 2
11:11:09.344 [main] ERROR error{} on Simple{} in ctrl4testng - this is an error log message
11:11:09.346 [main] INFO  info{} on Simple{} in ctrl4testng - this is an informational log message
11:11:09.347 [main] WARN  warn{} on Simple{} in ctrl4testng - this is a warning log message
11:11:09.349 [main] INFO  tearDownMethod{} on Simple{} in ctrl4testng - supports before and after methods too
```
