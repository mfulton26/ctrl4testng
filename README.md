# CTRL4TestNG: Current Test Result Logger for TestNG

[![Build Status](https://travis-ci.org/mfulton26/ctrl4testng.svg?branch=master)](https://travis-ci.org/mfulton26/ctrl4testng)
[![Coverage Status](https://coveralls.io/repos/mfulton26/ctrl4testng/badge.svg?branch=master)](https://coveralls.io/r/mfulton26/ctrl4testng?branch=master)

CTRL4TestNG provides an SLF4J Logger that can be used from any TestNG method tied to an ITestResult, namely Before, After, and Test annotations. Each separate method will have its own unique Logger and can be used with TestNG's parallel testing support making it clear which logs came from which method even when data-driven.

## Usage

Simply change your [Logger](http://slf4j.org/api/org/slf4j/Logger.html) initializations to use [CurrentTestResultLoggerFactory](https://github.com/mfulton26/ctrl4testng/blob/master/src/main/java/io/github/mfulton26/ctrl4testng/CurrentTestResultLoggerFactory.java) instead of [org.slf4j.LoggerFactory](http://slf4j.org/api/org/slf4j/LoggerFactory.html).
See [CurrentTestResultLoggerExampleTest](https://github.com/mfulton26/ctrl4testng/blob/master/src/test/java/io/github/mfulton26/ctrl4testng/CurrentTestResultLoggerExampleTest.java) for an example including example output.

Alternatively you can also statically import the constant [Logger](http://slf4j.org/api/org/slf4j/Logger.html) field, `LOGGER`, from [CTRL4TestNG](https://github.com/mfulton26/ctrl4testng/blob/master/src/main/java/io/github/mfulton26/ctrl4testng/CTRL4TestNG.java).

### Logger Category Format

CTRL4TestNG forwards logging requests to a unique [Logger](http://slf4j.org/api/org/slf4j/Logger.html) for each Before/After/Test TestNG method. Each method's logger has is named, by default, using the following format:
```
[method-name]{[method-parameters]} on [class-name]{[class-parameters]} in [xml-suite-name]
```

### Example Output

The following example output is from running [CurrentTestResultLoggerExampleTest](https://github.com/mfulton26/ctrl4testng/blob/master/src/test/java/io/github/mfulton26/ctrl4testng/CurrentTestResultLoggerExampleTest.java) with TestNG.
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

## Limitations

### Custom Logger Category Format
CTRL4TestNG does not currently support defining your own format for the category names it uses. ([Known Enhancement](https://github.com/mfulton26/ctrl4testng/issues/1))
