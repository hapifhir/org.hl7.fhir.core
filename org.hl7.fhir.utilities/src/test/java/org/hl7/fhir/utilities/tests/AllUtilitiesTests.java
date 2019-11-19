package org.hl7.fhir.utilities.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@SuiteClasses({ 
  JsonParserTests.class,
  XhtmlNodeTest.class,
    XLSXmlNormaliserTests.class})

public class AllUtilitiesTests {

}
