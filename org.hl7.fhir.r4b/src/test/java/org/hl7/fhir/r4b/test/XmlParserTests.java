package org.hl7.fhir.r4b.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.hl7.fhir.r4b.context.SimpleWorkerContext;
import org.hl7.fhir.r4b.elementmodel.Element;
import org.hl7.fhir.r4b.elementmodel.Manager;
import org.hl7.fhir.r4b.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r4b.formats.IParser.OutputStyle;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.test.utils.TestingUtilities;
import org.hl7.fhir.r4b.utils.FHIRPathEngine;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class XmlParserTests {

  private static SimpleWorkerContext context;
  private static FHIRPathEngine fp;

  @BeforeAll
  public static void setUp() throws Exception {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager(
        org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.FilesystemPackageCacheMode.USER);
    context = SimpleWorkerContext.fromPackage(pcm.loadPackage("hl7.fhir.r4.core", "4.0.1"));
    fp = new FHIRPathEngine(context);

    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "any.xml"), "any.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ii.xml"), "ii.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "cd.xml"), "cd.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ce.xml"), "ce.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "ed.xml"), "ed.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "st.xml"), "st.xml", null);
    context.loadFromFile(TestingUtilities.loadTestResourceStream("validator", "cda", "cda.xml"), "cda.xml", null);
    for (StructureDefinition sd : context.getStructures()) {
      if (!sd.hasSnapshot()) {
        System.out.println("generate snapshot for " + sd.getUrl());
        context.generateSnapshot(sd, true);
      }
    }
  }

}