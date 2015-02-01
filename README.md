CTRL4TestNG: Current Test Result Logger for TestNG
=====================================

[![Build Status](https://travis-ci.org/mfulton26/ctrl4testng.svg?branch=master)](https://travis-ci.org/mfulton26/ctrl4testng)
[![Coverage Status](https://coveralls.io/repos/mfulton26/ctrl4testng/badge.svg?branch=master)](https://coveralls.io/r/mfulton26/ctrl4testng?branch=master)

CTRL4TestNG provides an SLF4J Logger that can be used from any TestNG method tied to an ITestResult, namely Before, After, and Test annotations. Each separate method will have its own unique Logger and can be used with TestNG's parallel testing support making it clear which logs came from which method even when data-driven.
