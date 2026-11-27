package org.hl7.fhir.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.hl7.fhir.model.utilities.CodeSystemUtilities;

import org.hl7.fhir.model.core.BooleanType;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.DataType;
import org.hl7.fhir.model.core.DateTimeType;
import org.hl7.fhir.model.core.Enumerations.FilterOperator;
import org.hl7.fhir.model.core.ValueSet.ConceptSetFilterComponent;
import org.hl7.fhir.standalone.terminology.expansion.KnownProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The status of a concept - isInactive, isDeprecated, getStatus - and the value set filters on the
 * built-in properties (KnownProperties) that use them. FHIRsmith has the same tests
 * (tests/cs/cs-cs-status.test.js): keep the two in step
 */
class CodeSystemStatusTests {

  private static final String SS = "http://hl7.org/fhir/StructureDefinition/structuredefinition-standards-status";
  private static final String CP = "http://hl7.org/fhir/concept-properties#";

  private CodeSystem cs;

  private ConceptDefinitionComponent concept(String code, Object... props) {
    ConceptDefinitionComponent cd = cs.addConcept().setCode(code);
    for (int i = 0; i < props.length; i += 2) {
      cd.addProperty().setCode((String) props[i]).setValue((DataType) props[i+1]);
    }
    return cd;
  }

  private ConceptDefinitionComponent standardsStatus(String code, String value) {
    ConceptDefinitionComponent cd = cs.addConcept().setCode(code);
    if (value == null) {
      cd.addExtension().setUrl(SS);
    } else {
      cd.addExtension(SS, new CodeType(value));
    }
    return cd;
  }

  @BeforeEach
  void setUp() {
    cs = new CodeSystem();
    concept("plain");
    concept("active", "status", new CodeType("active"));
    // the order of the properties makes no difference
    concept("active-then-inactive", "status", new CodeType("active"), "inactive", new BooleanType(true));
    concept("not-inactive-but-retired", "inactive", new BooleanType(false), "status", new CodeType("retired"));
    concept("retired", "status", new CodeType("retired"));
    concept("past-deprecation", "deprecationDate", new DateTimeType("2001-01-01"));
    concept("future-deprecation", "deprecationDate", new DateTimeType("2999-01-01"), "status", new CodeType("deprecated"));
    concept("deprecated-flag", "deprecated", new BooleanType(true));
    standardsStatus("ss-deprecated", "deprecated");
    standardsStatus("ss-withdrawn", "withdrawn");
    standardsStatus("ss-trial-use", "trial-use");
    standardsStatus("ss-no-value", null);
    concept("inactive-and-deprecated", "deprecationDate", new DateTimeType("2001-01-01"), "inactive", new BooleanType(true));
  }

  private List<String> codes(Predicate<ConceptDefinitionComponent> test) {
    List<String> res = new ArrayList<>();
    for (ConceptDefinitionComponent cd : cs.getConceptList()) {
      if (test.test(cd)) {
        res.add(cd.getCode());
      }
    }
    return res;
  }

  private List<String> filter(String property, FilterOperator op, String value) {
    ConceptSetFilterComponent f = new ConceptSetFilterComponent().setProperty(property).setOp(op).setValue(value);
    return codes(cd -> KnownProperties.selects(f, KnownProperties.getValue(cs, cd, property)));
  }

  @Test
  void isInactive() {
    Assertions.assertEquals(List.of("active-then-inactive", "not-inactive-but-retired", "retired", "ss-withdrawn", "inactive-and-deprecated"),
      codes(cd -> CodeSystemUtilities.isInactive(cs, cd)));
  }

  @Test
  void isDeprecatedButNotRetired() {
    // status, a passed deprecationDate, the legacy flag, standards-status - not retired
    Assertions.assertEquals(List.of("future-deprecation", "past-deprecation", "deprecated-flag", "ss-deprecated", "inactive-and-deprecated").stream().sorted().toList(),
      codes(cd -> CodeSystemUtilities.isDeprecated(cs, cd, false)).stream().sorted().toList());
  }

  @Test
  void getStatus() {
    List<String> res = new ArrayList<>();
    for (ConceptDefinitionComponent cd : cs.getConceptList()) {
      res.add(cd.getCode() + "=" + CodeSystemUtilities.getStatus(cs, cd));
    }
    Assertions.assertEquals(List.of("plain=null", "active=active", "active-then-inactive=active", "not-inactive-but-retired=retired",
      "retired=retired", "past-deprecation=deprecated", "future-deprecation=deprecated", "deprecated-flag=deprecated",
      "ss-deprecated=deprecated", "ss-withdrawn=withdrawn", "ss-trial-use=trial-use", "ss-no-value=null",
      "inactive-and-deprecated=inactive"), res);
  }

  @Test
  void theFiltersAgreeWithTheConcept() {
    Assertions.assertEquals(codes(cd -> CodeSystemUtilities.isDeprecated(cs, cd, false)), filter("deprecated", FilterOperator.EQUAL, "true"));
    Assertions.assertEquals(codes(cd -> CodeSystemUtilities.isInactive(cs, cd)), filter("inactive", FilterOperator.EQUAL, "true"));
    Assertions.assertEquals(List.of("past-deprecation", "future-deprecation", "deprecated-flag", "ss-deprecated"), filter("status", FilterOperator.EQUAL, "deprecated"));
  }

  @Test
  void regex() {
    Assertions.assertEquals(List.of("not-inactive-but-retired", "retired"), filter("status", FilterOperator.REGEX, "ret.*"));
    Assertions.assertEquals(List.of(), filter("status", FilterOperator.REGEX, "trial")); // the whole value has to match
  }

  @Test
  void inAndNotInWithNoValue() {
    Assertions.assertEquals(List.of(), filter("status", FilterOperator.IN, null));
    Assertions.assertEquals(cs.getConceptList().size(), filter("status", FilterOperator.NOTIN, null).size());
  }

  @Test
  void statusUnderACodeOfItsOwnWithTheStandardUri() {
    cs = new CodeSystem();
    cs.addProperty().setCode("conceptStatus").setUri(CP + "status");
    ConceptDefinitionComponent a = concept("a", "conceptStatus", new CodeType("retired"));
    concept("b");
    Assertions.assertEquals("retired", CodeSystemUtilities.getStatus(cs, a));
    Assertions.assertTrue(CodeSystemUtilities.isInactive(cs, a));
    Assertions.assertEquals(List.of("a"), filter("status", FilterOperator.EQUAL, "retired"));
  }

  @Test
  void statusOfItsOwnIsNotTheStandardOne() {
    cs = new CodeSystem();
    cs.addProperty().setCode("status").setUri("http://example.org/my-status");
    cs.addProperty().setCode("conceptStatus").setUri(CP + "status");
    ConceptDefinitionComponent a = concept("a", "status", new CodeType("retired"), "conceptStatus", new CodeType("active"));
    Assertions.assertEquals("active", CodeSystemUtilities.getStatus(cs, a));
    Assertions.assertFalse(CodeSystemUtilities.isInactive(cs, a));
    Assertions.assertFalse(KnownProperties.isKnownProperty(cs, "status"));
    // a filter on status is a filter on the code system's own property, not on conceptStatus
    Assertions.assertEquals("status", CodeSystemUtilities.getPropertyDefinition(cs, "status").getCode());
  }
}
