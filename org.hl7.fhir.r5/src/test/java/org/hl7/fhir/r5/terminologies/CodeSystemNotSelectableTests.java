package org.hl7.fhir.r5.terminologies;

import org.hl7.fhir.r5.model.BooleanType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * isNotSelectable (which isAbstract was folded into): a concept is not selectable if it has a boolean property
 * with the value true that is the code system's notSelectable property
 */
class CodeSystemNotSelectableTests {

  private static final String NS_URI = "http://hl7.org/fhir/concept-properties#notSelectable";

  private static ConceptDefinitionComponent concept(CodeSystem cs, String code, Object... props) {
    ConceptDefinitionComponent cd = cs.addConcept().setCode(code);
    for (int i = 0; i < props.length; i += 2) {
      cd.addProperty().setCode((String) props[i]).setValue(props[i+1] instanceof Boolean ? new BooleanType((Boolean) props[i+1]) : new CodeType((String) props[i+1]));
    }
    return cd;
  }

  @Test
  void noPropertiesIsSelectable() {
    CodeSystem cs = new CodeSystem();
    Assertions.assertFalse(CodeSystemUtilities.isNotSelectable(cs, concept(cs, "a")));
  }

  @ParameterizedTest
  @ValueSource(strings = {"notSelectable", "abstract", "not-selectable"})
  void undeclaredStandardCodesAreRecognised(String code) {
    CodeSystem cs = new CodeSystem();
    Assertions.assertTrue(CodeSystemUtilities.isNotSelectable(cs, concept(cs, "a", code, true)));
    Assertions.assertFalse(CodeSystemUtilities.isNotSelectable(cs, concept(cs, "b", code, false)));
  }

  @Test
  void otherBooleanPropertiesDontCount() {
    CodeSystem cs = new CodeSystem();
    Assertions.assertFalse(CodeSystemUtilities.isNotSelectable(cs, concept(cs, "a", "deprecated", true)));
  }

  @Test
  void nonBooleanValueDoesntCount() {
    CodeSystem cs = new CodeSystem();
    Assertions.assertFalse(CodeSystemUtilities.isNotSelectable(cs, concept(cs, "a", "notSelectable", "true")));
  }

  @Test
  void anyTruePropertyMakesItNotSelectable() {
    // a false notSelectable doesn't hide a true abstract
    CodeSystem cs = new CodeSystem();
    Assertions.assertTrue(CodeSystemUtilities.isNotSelectable(cs, concept(cs, "a", "notSelectable", false, "abstract", true)));
  }

  @Test
  void standardUriCountsWhateverTheCode() {
    CodeSystem cs = new CodeSystem();
    cs.addProperty().setCode("ns").setUri(NS_URI);
    Assertions.assertTrue(CodeSystemUtilities.isNotSelectable(cs, concept(cs, "a", "ns", true)));
  }

  @Test
  void standardCodeDeclaredWithAnotherUriDoesntCount() {
    CodeSystem cs = new CodeSystem();
    cs.addProperty().setCode("notSelectable").setUri("http://example.org/something-else");
    Assertions.assertFalse(CodeSystemUtilities.isNotSelectable(cs, concept(cs, "a", "notSelectable", true)));
  }

  @Test
  void standardCodeDeclaredWithNoUriCounts() {
    CodeSystem cs = new CodeSystem();
    cs.addProperty().setCode("abstract");
    Assertions.assertTrue(CodeSystemUtilities.isNotSelectable(cs, concept(cs, "a", "abstract", true)));
  }

  @Test
  void byCode() {
    CodeSystem cs = new CodeSystem();
    concept(cs, "a", "notSelectable", true);
    concept(cs, "b");
    Assertions.assertTrue(CodeSystemUtilities.isNotSelectable(cs, "a"));
    Assertions.assertFalse(CodeSystemUtilities.isNotSelectable(cs, "b"));
    Assertions.assertFalse(CodeSystemUtilities.isNotSelectable(cs, "c"));
  }
}
