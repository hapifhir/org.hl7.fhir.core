package org.hl7.fhir.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * The document functions (section(), entry(), entryIn(), resources(), resourcesIn()) in the R6 engine,
 * on an R4 document parsed into the element model - as the validator does it. R4 and R5+ differ in
 * where a medication's code is (medicationCodeableConcept vs medication.concept, a CodeableReference).
 * sameSubject() reads subject or patient, and R4 Composition.subject is a single Reference.
 * The FHIRPath test suite (tests-fhir-r6.xml, group documentFunctions) covers the R6 content.
 */
class DocumentFunctionsR4ElementTests {

  private static SimpleWorkerContext context;
  private static FHIRPathEngine fp;
  private static Base document;

  @BeforeAll
  static void setUp() throws Exception {
    context = TestingUtilities.getSharedWorkerContext("4.0.1");
    fp = new FHIRPathEngine(context);
    document = Manager.parse(context, TestingUtilities.loadTestResourceStream("r4", "bundle-document-ips.json"), FhirFormat.JSON).get(0).getElement();
  }

  static Stream<Arguments> data() {
    return Stream.of(
      Arguments.of("Bundle.section('http://loinc.org', '11450-4').entry('http://snomed.info/sct', '38341003').id", "c1"),
      // relative, and the Composition's fullUrl is a urn:uuid, so it doesn't resolve (as BaseValidator.resolveInBundle)
      Arguments.of("Bundle.section('http://loinc.org', '11450-4').entry('http://snomed.info/sct', '44054006').empty()", "true"),
      Arguments.of("Bundle.section('http://loinc.org', '10160-0').entry('http://snomed.info/sct', '108774000').id", "m1"),
      Arguments.of("Bundle.section('http://loinc.org', '10160-0').entry('http://snomed.info/sct', '387207008').id", "med2"),
      Arguments.of("Bundle.section('http://loinc.org', '8716-3').entry('http://loinc.org', '8480-6').id", "o1"),
      Arguments.of("Bundle.section('http://loinc.org', '11369-6').entry('http://snomed.info/sct', '871875004', 1, 1).id", "i1"),
      Arguments.of("Bundle.resources('http://snomed.info/sct', '108774000', 'MedicationStatement').id", "m1"),
      Arguments.of("Bundle.resources('http://snomed.info/sct', '195967001').id", "c3"),
      Arguments.of("Bundle.section('http://loinc.org', '11450-4').entryIn('http://hl7.org/fhir/ValueSet/data-absent-reason').id", "c4"),
      Arguments.of("Bundle.resourcesIn('http://hl7.org/fhir/ValueSet/data-absent-reason').id", "c4"),
      Arguments.of("Bundle.section('http://loinc.org', '11450-4', 2, '*').exists()", "false"),
      Arguments.of("Bundle.entry.resource.ofType(Condition).where(id = 'c1').sameSubject()", "true"),
      Arguments.of("Bundle.entry.resource.ofType(Condition).where(id = 'c5').sameSubject()", "false"),
      Arguments.of("Bundle.entry.resource.ofType(AllergyIntolerance).sameSubject()", "true"),
      Arguments.of("Bundle.entry.resource.ofType(Observation).where(id = 'o2').sameSubject(%resource.entry.resource.ofType(Observation).where(id = 'o3'))", "true"),
      Arguments.of("Bundle.entry.resource.ofType(Observation).where(id = 'o2').sameSubject()", "false")
    );
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("data")
  void test(String expression, String expected) {
    List<String> values = new ArrayList<>();
    for (Base b : fp.evaluate(document, expression)) {
      values.add(b.primitiveValue());
    }
    assertEquals(List.of(expected), values, expression);
  }
}
