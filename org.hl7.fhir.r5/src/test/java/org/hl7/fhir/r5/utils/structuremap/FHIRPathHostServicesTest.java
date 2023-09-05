package org.hl7.fhir.r5.utils.structuremap;

import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FHIRPathHostServicesTest {
  static private SimpleWorkerContext context;

  @BeforeAll
  static public void setUp() throws Exception {
    FilesystemPackageCacheManager pcm = new org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager(false);
    context = TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r4.core", "4.0.1"));
  }

  @Test
  public void testrResolveValueSet() throws IOException, FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context);
    FHIRPathHostServices fphs = new FHIRPathHostServices(scu);
    ValueSet v = fphs.resolveValueSet(null, "http://hl7.org/fhir/ValueSet/FHIR-version");
    Assertions.assertNotNull(v);
    Assertions.assertEquals("http://hl7.org/fhir/ValueSet/FHIR-version", v.getUrl());
  }
}
