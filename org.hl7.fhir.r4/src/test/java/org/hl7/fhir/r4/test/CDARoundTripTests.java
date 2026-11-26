package org.hl7.fhir.r4.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.context.SimpleWorkerContext;
import org.hl7.fhir.r4.elementmodel.Element;
import org.hl7.fhir.r4.elementmodel.Manager;
import org.hl7.fhir.r4.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Disabled
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CDARoundTripTests {

  private SimpleWorkerContext context;

  @BeforeAll
  public void setUp() throws Exception {
    context = new SimpleWorkerContext();
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.core", "current"), null, "StructureDefinition");
    context.loadFromPackage(pcm.loadPackage("hl7.fhir.cda", "current"), null, "StructureDefinition");
  }

  @Test
  void testDCI() throws FHIRException {
    assertDoesNotThrow(() -> {
        Element e;
        try (InputStream stream = ManagedFileAccess.inStream("C:\\work\\org.hl7.fhir.us\\ccda-to-fhir-maps\\cda\\IAT2-Discharge_Summary-DCI.xml")) {
          e = Manager.parse(context, stream, FhirFormat.XML);
        }
        try (OutputStream stream = ManagedFileAccess.outStream(Utilities.path("[tmp]", "ccda.xml"))) {
          Manager.compose(context, e, stream, FhirFormat.XML, OutputStyle.PRETTY, null);
        }
//    Manager.compose(context, e, ManagedFileAccess.outStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge_Summary-DCI.out.json"), FhirFormat.JSON, OutputStyle.PRETTY, null);
//    Manager.compose(context, e, ManagedFileAccess.outStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge_Summary-DCI.out.ttl"), FhirFormat.TURTLE, OutputStyle.PRETTY, null);
    });
  }

  @Test
  void testEpic() throws FHIRException {
    assertDoesNotThrow(() -> {
      Element e;
      try (InputStream stream = ManagedFileAccess.inStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.xml")) {
        e = Manager.parse(context, stream, FhirFormat.XML);
      }
      try (OutputStream stream = ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.xml")) {
        Manager.compose(context, e, stream, FhirFormat.XML, OutputStyle.PRETTY, null);
      }
      try (OutputStream stream = ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.json")) {
        Manager.compose(context, e, stream, FhirFormat.JSON, OutputStyle.PRETTY, null);
      }
      try (OutputStream stream = ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-Discharge-Homework-Epic.out.ttl")) {
        Manager.compose(context, e, stream, FhirFormat.TURTLE, OutputStyle.PRETTY, null);
      }
    });
  }

  @Test
  void testDHIT() throws FHIRException {
    assertDoesNotThrow(() -> {
      Element e;
      try (InputStream stream = ManagedFileAccess.inStream("C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.xml")) {
        e = Manager.parse(context, stream, FhirFormat.XML);
      }
      try (OutputStream stream = ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.xml")) {
        Manager.compose(context, e, stream, FhirFormat.XML, OutputStyle.PRETTY, null);
      }
      try (OutputStream stream = ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.json")) {
        Manager.compose(context, e, stream, FhirFormat.JSON, OutputStyle.PRETTY, null);
      }
      try (OutputStream stream = ManagedFileAccess.outStream(
              "C:\\work\\org.hl7.fhir.test\\ccda-to-fhir-maps\\testdocuments\\IAT2-DS-Homework-DHIT.out.ttl")) {
        Manager.compose(context, e, stream, FhirFormat.TURTLE, OutputStyle.PRETTY, null);
      }
    });
  }

}