package org.hl7.fhir.utils.formats;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.AggregationMode;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.utilities.CSVWriter;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.junit.jupiter.api.Test;

/** the cells that list things: one item a line, and a type's profiles as their urls */
class CSVWriterTests {

  private static String csv(ElementDefinition ed) throws Exception {
    StructureDefinition sd = new StructureDefinition(TestingUtilities.getSharedWorkerContext().getModelContext());
    sd.setId("test");
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    CSVWriter csv = new CSVWriter(bs, TestingUtilities.getSharedWorkerContext(), false);
    csv.processElement(sd, ed);
    csv.dump();
    csv.close();
    return bs.toString(StandardCharsets.UTF_8);
  }

  @Test
  void eachItemIsOnItsOwnLine() throws Exception {
    ElementDefinition ed = new ElementDefinition(TestingUtilities.getSharedWorkerContext().getModelContext(), "Observation.value[x]");
    ed.addAlias("one");
    ed.addAlias("two");
    ed.addAlias("three");
    String out = csv(ed);
    assertTrue(out.contains("\"one\ntwo\nthree\""), out);
  }

  @Test
  void typesListTheirProfilesAndSkipEmptyTypes() throws Exception {
    ElementDefinition ed = new ElementDefinition(TestingUtilities.getSharedWorkerContext().getModelContext(), "Observation.subject");
    ed.addType(); // an empty type: left out, and doesn't swallow the line break
    ed.addType().setCode("Reference").addTargetProfile("http://hl7.org/fhir/StructureDefinition/Patient")
      .addTargetProfile("http://hl7.org/fhir/StructureDefinition/Group").addAggregation(AggregationMode.CONTAINED).addAggregation(AggregationMode.BUNDLED);
    ed.addType().setCode("string").addProfile("http://example.org/StructureDefinition/s");
    String out = csv(ed);
    assertTrue(out.contains("\"Reference {http://hl7.org/fhir/StructureDefinition/Patient|http://hl7.org/fhir/StructureDefinition/Group} (contained, bundled)\nstring {http://example.org/StructureDefinition/s}\""), out);
    assertFalse(out.contains("CanonicalType"), out);
  }
}
