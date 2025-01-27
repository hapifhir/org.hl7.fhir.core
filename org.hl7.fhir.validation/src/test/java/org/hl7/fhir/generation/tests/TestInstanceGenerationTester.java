package org.hl7.fhir.generation.tests;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.hl7.fhir.convertors.loaders.loaderR5.NullLoaderKnowledgeProviderR5;
import org.hl7.fhir.convertors.loaders.loaderR5.R4ToR5Loader;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext.SimpleWorkerContextBuilder;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.liquid.BaseTableWrapper;
import org.hl7.fhir.r5.liquid.LiquidEngine;
import org.hl7.fhir.r5.liquid.GlobalObject.GlobalObjectRandomFunction;
import org.hl7.fhir.r5.model.DateTimeType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientR5.TerminologyClientR5Factory;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.testfactory.ProfileBasedFactory;
import org.hl7.fhir.r5.testfactory.TestDataFactory;
import org.hl7.fhir.r5.testfactory.TestDataHostServices;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestInstanceGenerationTester {

  @Test
  public void testDataFactory() throws IOException, FHIRException, SQLException {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    SimpleWorkerContext context = new SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).withDefaultParams().fromPackage(pcm.loadPackage("hl7.fhir.r4.core"));
    context.connectToTSServer(new TerminologyClientR5Factory(), "http://tx-dev.fhir.org/r4", "Instance-Generator", Utilities.path("[tmp]", "tx-log.log"), true);
    context.loadFromPackage(pcm.loadPackage("us.nlm.vsac#0.21.0"), new R4ToR5Loader(Utilities.strings("CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire","ConceptMap","StructureMap", "NamingSystem"),
        new NullLoaderKnowledgeProviderR5(), context.getVersion()));
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.us.core#6.0.0"), new R4ToR5Loader(Utilities.strings("CapabilityStatement", "StructureDefinition", "ValueSet", "CodeSystem", "SearchParameter", "OperationDefinition", "Questionnaire","ConceptMap","StructureMap", "NamingSystem"),
        new NullLoaderKnowledgeProviderR5(), context.getVersion()));
            
    FHIRPathEngine fpe = new FHIRPathEngine(context);
    TestDataHostServices hs = new TestDataHostServices(context, new DateTimeType("2024-12-24T09:01:00+11:00"), new StringType("http://hl7.org/fhir"));
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
    Utilities.createDirectory(path);
    Utilities.clearDirectory(path);

    String log = Utilities.path(path, "log");
    Utilities.createDirectory(log);

    String output = Utilities.path(path, "output");
    Utilities.createDirectory(output);

    String expected = Utilities.path(path, "expected");
    Utilities.createDirectory(expected);
          
    
    for (String name : Utilities.strings("countries.csv", "data.csv", "encounter.liquid", "factories.json", "patient-cases.xlsx", "patient-genders.csv", "patient.liquid", "test-cases.liquid")) {
      byte[] fsrc = TestingUtilities.loadTestResourceBytes("rX", "instance-generation", "factories", name);
      TextFile.bytesToFile(fsrc, Utilities.path(path, name));
    }
    for (String name : Utilities.strings("Patient-1.json","Patient2-1.json", "Encounter-1.json", "MedicationStatement-1.json", "Observation-bp-1.json", "Observation-weight-1.json")) {
      byte[] fsrc = TestingUtilities.loadTestResourceBytes("rX", "instance-generation", "expected", name);
      TextFile.bytesToFile(fsrc, Utilities.path(path, "expected", name));
    }
    JsonObject json = JsonParser.parseObjectFromFile(Utilities.path(path, "factories.json"));
    for (JsonObject fact : json.forceArray("factories").asJsonObjects()) {
      TestDataFactory tdf = new TestDataFactory(context, fact, liquid, fpe, "http://hl7.org/fhir/test", path, log);
      tdf.setTesting(true); // no randomness
      System.out.println("Execute Test Data Factory '"+tdf.getName()+"'. Log in "+tdf.statedLog());
      tdf.execute();
      System.out.println(TextFile.fileToString(Utilities.path(log, tdf.statedLog())));
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
      String diff = new CompareUtilities(null, null, null).checkJsonSrcIsSame(name, TextFile.fileToString(Utilities.path(expected, name)), TextFile.fileToString(Utilities.path(output, name)), false);
      Assertions.assertNull(diff, "unexpected difference for "+name);
    }
  }
}
