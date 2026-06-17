package org.hl7.fhir.generation.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.convertors.loaders.loaderR5.NullLoaderKnowledgeProviderR5;
import org.hl7.fhir.convertors.loaders.loaderR5.R4ToR5Loader;
import org.hl7.fhir.convertors.txClient.TerminologyClientR4;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext.SimpleWorkerContextBuilder;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.liquid.BaseTableWrapper;
import org.hl7.fhir.r5.liquid.GlobalObject.GlobalObjectRandomFunction;
import org.hl7.fhir.r5.liquid.LiquidEngine;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.DateType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.testfactory.TestDataFactory;
import org.hl7.fhir.r5.testfactory.TestDataHostServices;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class TestInstanceGenerationTester {

  @Test
  void testDataFactory() throws IOException, FHIRException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    SimpleWorkerContext context = new SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).withDefaultParams().fromPackage(pcm.loadPackage("hl7.fhir.r4.core"));
    context.connectToTSServer(new TerminologyClientR4.TerminologyClientR4Factory(), "https://tx-dev.fhir.org", "Instance-Generator", Utilities.path("[tmp]", "tx-log.html"), true);
    context.loadFromPackage(pcm.loadPackage("us.nlm.vsac#0.21.0"), new R4ToR5Loader(Utilities.stringSet("CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire","ConceptMap","StructureMap", "NamingSystem"),
        new NullLoaderKnowledgeProviderR5(), context.getVersion()));
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.us.core#6.0.0"), new R4ToR5Loader(Utilities.stringSet("CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire","ConceptMap","StructureMap", "NamingSystem"),
        new NullLoaderKnowledgeProviderR5(), context.getVersion()));
            
    // DEBUG: the generated code.text is copied verbatim from the bp profile's Observation.code
    // pattern (ProfileBasedFactory.populateElementFromDataType); the factory never writes a
    // CodeableConcept.text itself. Log the pattern as loaded to see whether terminology completion
    // against tx-dev.fhir.org injected a text into the fixed value (which would then propagate into
    // every generated instance, and differ between CI and local depending on tx-dev responses).
    StructureDefinition bp = context.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/bp");
    if (bp != null && bp.hasSnapshot()) {
      for (org.hl7.fhir.r5.model.ElementDefinition ed : bp.getSnapshot().getElement()) {
        if ("Observation.code".equals(ed.getPath()) && ed.hasPattern()) {
          TestInstanceGenerationTester.log.info("bp Observation.code pattern as loaded: {}",
            new org.hl7.fhir.r5.formats.JsonParser().setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.NORMAL)
              .composeString((org.hl7.fhir.r5.model.DataType) ed.getPattern(), "pattern"));
        }
      }
    }

    FHIRPathEngine fpe = new FHIRPathEngine(context);
    TestDataHostServices hs = new TestDataHostServices(context, new DateTimeType("2024-12-24T09:01:00+11:00"),
      new DateType("2024-12-24"), new StringType("https://www.hl7.org/fhir"));
    hs.registerFunction(new GlobalObjectRandomFunction());
    hs.registerFunction(new BaseTableWrapper.TableColumnFunction());
    hs.registerFunction(new BaseTableWrapper.TableDateColumnFunction());
    hs.registerFunction(new TestDataFactory.CellLookupFunction());
    hs.registerFunction(new TestDataFactory.TableLookupFunction());
    fpe.setHostServices(hs);
    LiquidEngine liquid = new LiquidEngine(context, hs);
    
    StructureDefinition sd = (StructureDefinition) new org.hl7.fhir.r5.formats.JsonParser().parse(TestingUtilities.loadTestResourceBytes("rX", "instance-generation", "collateral", "StructureDefinition-test-patient-profile.json"));
    context.cacheResource(sd);
    
    // set up the space
    String path = Utilities.path("[tmp]", "instance-generation");
    FileUtilities.createDirectory(path);
    FileUtilities.clearDirectory(path);

    String log = Utilities.path(path, "log");
    FileUtilities.createDirectory(log);

    String output = Utilities.path(path, "output");
    FileUtilities.createDirectory(output);

    String expected = Utilities.path(path, "expected");
    FileUtilities.createDirectory(expected);
          
    
    for (String name : Utilities.strings("countries.csv", "data.csv", "encounter.liquid", "factories.json", "patient-cases.xlsx", "patient-genders.csv", "patient.liquid", "test-cases.liquid")) {
      byte[] fsrc = TestingUtilities.loadTestResourceBytes("rX", "instance-generation", "factories", name);
      FileUtilities.bytesToFile(fsrc, Utilities.path(path, name));
    }
    for (String name : Utilities.strings("Patient-1.json","Patient2-1.json", "Encounter-1.json", "MedicationStatement-1.json", "Observation-bp-1.json", "Observation-weight-1.json")) {
      byte[] fsrc = TestingUtilities.loadTestResourceBytes("rX", "instance-generation", "expected", name);
      FileUtilities.bytesToFile(fsrc, Utilities.path(path, "expected", name));
    }
    JsonObject json = JsonParser.parseObjectFromFile(Utilities.path(path, "factories.json"));
    for (JsonObject fact : json.forceArray("factories").asJsonObjects()) {
      TestDataFactory tdf = new TestDataFactory(context, fact, liquid, fpe, "http://hl7.org/fhir/test", path, log, new HashMap<>(), new Locale("us"));
      tdf.setTesting(true); // no randomness
      TestInstanceGenerationTester.log.info("Execute Test Data Factory '"+tdf.getName()+"'. Log in "+tdf.statedLog());
      tdf.execute();
      TestInstanceGenerationTester.log.info(FileUtilities.fileToString(Utilities.path(log, tdf.statedLog())));
    }
    
    // now, check output
    for (String name : Utilities.strings("Bundle-patients.json", "Encounter-1.json", "Encounter-2.json", "Encounter-3.json", "Encounter-4.json", "MedicationStatement-1.json", 
        "MedicationStatement-2.json", "MedicationStatement-4.json", "Observation-bp-1.json", "Observation-bp-2.json", "Observation-bp-3.json", 
        "Observation-bp-4.json", "Observation-weight-1.json", "Observation-weight-2.json", "Observation-weight-3.json", "Observation-weight-4.json", 
        "Patient-1.json", "Patient-2.json", "Patient-3.json", "Patient-4.json", "Patient2-1.json", "Patient2-2.json", "Patient2-3.json")) {
      File f = new File(Utilities.path(output, name));
      Assertions.assertTrue(f.exists());
    }
    
    for (String name : Utilities.strings("Patient-1.json", "Patient2-1.json", "Encounter-1.json", "MedicationStatement-1.json", "Observation-bp-1.json", "Observation-weight-1.json")) {
      String expectedSrc = FileUtilities.fileToString(Utilities.path(expected, name));
      String actualSrc = FileUtilities.fileToString(Utilities.path(output, name));
      String diff = new CompareUtilities(null, null, null).checkJsonSrcIsSame(name, expectedSrc, actualSrc, false);
      if (diff != null) {
        // Debugging for non-reproducible CI failures: this test depends on the live tx server
        // (tx-dev.fhir.org) and on the -SNAPSHOT fhir-test-cases templates/fixtures, both of which
        // can differ between CI and local. Dump both sides so the divergence is visible in the log.
        TestInstanceGenerationTester.log.error("Difference for {}: {}", name, diff);
        TestInstanceGenerationTester.log.error("EXPECTED {} (from fhir-test-cases):\n{}", name, expectedSrc);
        TestInstanceGenerationTester.log.error("ACTUAL {} (generated):\n{}", name, actualSrc);
      }
      Assertions.assertNull(diff, "unexpected difference for "+name);
    }
  }
}
