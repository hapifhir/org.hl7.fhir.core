package org.hl7.fhir.r4.test;

import org.hl7.fhir.r4.model.BaseDateTimeTypeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
    SnomedExpressionsTests.class, 
    GraphQLParserTests.class,
    TurtleTests.class,
    ProfileUtilitiesTests.class,
    ResourceRoundTripTests.class, 
    GraphQLEngineTests.class,
    LiquidEngineTests.class,
    FHIRPathTests.class,
    NarrativeGeneratorTests.class,
    ShexGeneratorTests.class,
    BaseDateTimeTypeTest.class,
    SnapShotGenerationTests.class,
    FHIRMappingLanguageTests.class})
public class AllTests {

}
