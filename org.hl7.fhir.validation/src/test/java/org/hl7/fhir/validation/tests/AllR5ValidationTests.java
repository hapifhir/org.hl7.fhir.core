package org.hl7.fhir.validation.tests;

import org.hl7.fhir.conversion.tests.SnapShotGenerationTestsX;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
  SnapShotGenerationTestsX.class,
  ValidationTestSuite.class, 
  ValidationEngineTests.class,
  JsonSchemaTests.class,
  NativeHostServiceTester.class,
  // CDAValidationTestCase.class,
  ProfileComparisonTests.class})
public class AllR5ValidationTests {

}
