package org.hl7.fhir.r5.test;

import org.hl7.fhir.r5.model.BaseDateTimeTypeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
    NpmPackageTests.class,
    SnomedExpressionsTests.class, 
    GraphQLParserTests.class,
    TurtleTests.class,
    ProfileUtilitiesTests.class,
    ResourceRoundTripTests.class, 
    GraphQLEngineTests.class,
    LiquidEngineTests.class,
    FHIRPathTests.class,
    NarrativeGenerationTests.class,
    NarrativeGeneratorTests.class,
    ShexGeneratorTests.class,
    BaseDateTimeTypeTest.class,
    OpenApiGeneratorTest.class,
    MetadataResourceManagerTester.class,
    UtilitiesTests.class,
    SnapShotGenerationTests.class})

public class AllR5Tests {

}
