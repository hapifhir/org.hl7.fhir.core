package org.hl7.fhir.r5.conformance.profile;

import java.util.List;

import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DecimalType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionBindingAdditionalComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionConstraintComponent;
import org.hl7.fhir.r5.model.ElementDefinition.ElementDefinitionSlicingComponent;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.ElementDefinition.AdditionalBindingPurposeVS;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the rules TypeProfileRootMerger applies when a data type profile's root is merged into the element
 * that uses it. The snapshot-generation l-series tests (l1-l12) cover the same rules end to end.
 */
class TypeProfileRootMergerTests {

  private static final String URL = "http://example.org/fhir/StructureDefinition/tp";
  private static IWorkerContext context;

  @BeforeAll
  static void setUp() {
    context = TestingUtilities.getSharedWorkerContext();
  }

  private List<ValidationMessage> merge(ElementDefinition element, ElementDefinition typeRoot) {
    return merge(element, typeRoot, coreRoot());
  }

  private List<ValidationMessage> merge(ElementDefinition element, ElementDefinition typeRoot, ElementDefinition coreRoot) {
    return new TypeProfileRootMerger(context).merge(element, typeRoot, coreRoot, URL, element.getPath());
  }

  private ElementDefinition element() {
    return new ElementDefinition().setPath("Observation.category").setMin(0).setMax("*");
  }

  private ElementDefinition typeRoot() {
    return new ElementDefinition().setPath("CodeableConcept");
  }

  private ElementDefinition coreRoot() {
    ElementDefinition ed = new ElementDefinition().setPath("CodeableConcept").setMin(0).setMax("*");
    ed.addConstraint().setKey("ele-1").setExpression("hasValue() or (children().count() > id.count())");
    ed.addMapping().setIdentity("rim").setMap("n/a,CD");
    return ed;
  }

  private long errors(List<ValidationMessage> msgs) {
    return msgs.stream().filter(m -> m.getLevel() == IssueSeverity.ERROR).count();
  }

  @Test
  void testCardinality() {
    ElementDefinition e = element().setMax("5");
    Assertions.assertTrue(merge(e, typeRoot().setMin(1).setMax("*")).isEmpty());
    Assertions.assertEquals(1, e.getMin(), "min: the highest");
    Assertions.assertEquals("5", e.getMax(), "max: the lowest");

    e = element();
    merge(e, typeRoot().setMin(0).setMax("1"));
    Assertions.assertEquals(0, e.getMin());
    Assertions.assertEquals("1", e.getMax());
  }

  @Test
  void testDocumentationNeverMerged() {
    ElementDefinition e = element().setShort("element short").setDefinition("element definition");
    ElementDefinition t = typeRoot().setShort("type short").setDefinition("type definition").setComment("type comment")
        .setRequirements("type requirements").setMeaningWhenMissing("type mwm").setOrderMeaning("type order");
    t.addAlias("type alias");
    t.addExample().setLabel("x").setValue(new StringType("y"));
    merge(e, t);
    Assertions.assertEquals("element short", e.getShort());
    Assertions.assertEquals("element definition", e.getDefinition());
    Assertions.assertFalse(e.hasComment());
    Assertions.assertFalse(e.hasRequirements());
    Assertions.assertFalse(e.hasAlias());
    Assertions.assertFalse(e.hasExample());
    Assertions.assertFalse(e.hasMeaningWhenMissing());
    Assertions.assertFalse(e.hasOrderMeaning());
  }

  @Test
  void testIgnored() {
    ElementDefinition e = element();
    ElementDefinition t = typeRoot().setIsModifier(true).setIsModifierReason("because").setIsSummary(true).setContentReference("#X");
    t.addCondition("t1");
    merge(e, t);
    Assertions.assertFalse(e.hasIsModifier());
    Assertions.assertFalse(e.hasIsModifierReason());
    Assertions.assertFalse(e.hasIsSummary());
    Assertions.assertFalse(e.hasContentReference());
    Assertions.assertFalse(e.hasCondition());
  }

  @Test
  void testSlicingIsAnError() {
    ElementDefinition t = typeRoot();
    t.setSlicing(new ElementDefinitionSlicingComponent().setRules(SlicingRules.OPEN));
    Assertions.assertEquals(1, errors(merge(element(), t)));
  }

  @Test
  void testCodesMerged() {
    ElementDefinition e = element();
    e.addCode(new Coding("http://example.org", "a", null));
    ElementDefinition t = typeRoot();
    t.addCode(new Coding("http://example.org", "a", null));
    t.addCode(new Coding("http://example.org", "b", null));
    merge(e, t);
    Assertions.assertEquals(2, e.getCode().size());
  }

  @Test
  void testConstraints() {
    ElementDefinition e = element();
    e.addConstraint().setKey("shared").setExpression("text.exists()");
    ElementDefinition t = typeRoot();
    t.addConstraint().setKey("ele-1").setExpression("hasValue() or (children().count() > id.count())");
    t.addConstraint().setKey("shared").setExpression("text.exists()");
    t.addConstraint().setKey("t1").setExpression("coding.exists()");
    Assertions.assertEquals(0, errors(merge(e, t)));
    Assertions.assertEquals(2, e.getConstraint().size(), "ele-1 is the core type's, and shared is already there");
    ElementDefinitionConstraintComponent t1 = e.getConstraint().get(1);
    Assertions.assertEquals("t1", t1.getKey());
    Assertions.assertEquals(URL, t1.getSource(), "migrated constraints are stamped with the type profile");

    t = typeRoot();
    t.addConstraint().setKey("shared").setExpression("coding.exists()");
    Assertions.assertEquals(1, errors(merge(e, t)), "same key, different expression");
  }

  @Test
  void testFixedAndPattern() {
    ElementDefinition e = element();
    merge(e, typeRoot().setPattern(new CodeableConcept().setText("x")));
    Assertions.assertTrue(e.hasPattern(), "copied when the element has none");

    e = element().setPattern(new CodeableConcept().setText("x"));
    Assertions.assertEquals(0, errors(merge(e, typeRoot().setPattern(new CodeableConcept().setText("x")))));

    e = element().setPattern(new CodeableConcept().setText("x"));
    Assertions.assertEquals(1, errors(merge(e, typeRoot().setPattern(new CodeableConcept().setText("y")))));

    e = element().setFixed(new CodeableConcept().setText("x"));
    Assertions.assertEquals(1, errors(merge(e, typeRoot().setFixed(new CodeableConcept().setText("y")))));

    e = element().setPattern(new CodeableConcept().setText("x"));
    Assertions.assertEquals(0, errors(merge(e, typeRoot().setFixed(new CodeableConcept().setText("x")))));
    Assertions.assertTrue(e.hasFixed() && !e.hasPattern(), "they agree, and fixed is the stronger statement");
  }

  @Test
  void testDefaultValue() {
    ElementDefinition e = element().setDefaultValue(new StringType("a"));
    Assertions.assertEquals(0, errors(merge(e, typeRoot().setDefaultValue(new StringType("a")))));
    Assertions.assertEquals(1, errors(merge(e, typeRoot().setDefaultValue(new StringType("b")))));
  }

  @Test
  void testRanges() {
    ElementDefinition e = element().setMinValue(new DecimalType("5.0")).setMaxValue(new DecimalType("50.0")).setMaxLength(100);
    merge(e, typeRoot().setMinValue(new DecimalType("3.0")).setMaxValue(new DecimalType("20.0")).setMaxLength(40));
    Assertions.assertEquals("5.0", e.getMinValue().primitiveValue(), "minValue: the highest");
    Assertions.assertEquals("20.0", e.getMaxValue().primitiveValue(), "maxValue: the lowest");
    Assertions.assertEquals(40, e.getMaxLength(), "maxLength: the lowest");

    e = element().setMinValue(new IntegerType(2));
    merge(e, typeRoot().setMinValue(new IntegerType(7)));
    Assertions.assertEquals("7", e.getMinValue().primitiveValue());

    e = element().setMinValue(new Quantity().setValue(5).setSystem("http://unitsofmeasure.org").setCode("mg"));
    merge(e, typeRoot().setMinValue(new Quantity().setValue(7).setSystem("http://unitsofmeasure.org").setCode("mg")));
    Assertions.assertEquals("7", ((Quantity) e.getMinValue()).getValueElement().primitiveValue());

    e = element().setMinValue(new Quantity().setValue(5).setSystem("http://unitsofmeasure.org").setCode("mg"));
    List<ValidationMessage> msgs = merge(e, typeRoot().setMinValue(new Quantity().setValue(7).setSystem("http://unitsofmeasure.org").setCode("g")));
    Assertions.assertEquals(1, msgs.size());
    Assertions.assertEquals(IssueSeverity.WARNING, msgs.get(0).getLevel(), "different units can't be compared");
    Assertions.assertEquals("5", ((Quantity) e.getMinValue()).getValueElement().primitiveValue(), "and the element's value is kept");
  }

  @Test
  void testFlags() {
    ElementDefinition e = element().setMustSupport(false);
    merge(e, typeRoot().setMustSupport(true).setMustHaveValue(true));
    Assertions.assertTrue(e.getMustSupport());
    Assertions.assertTrue(e.getMustHaveValue());

    e = element().setMustSupport(true).setMustHaveValue(true);
    merge(e, typeRoot().setMustSupport(false));
    Assertions.assertTrue(e.getMustSupport(), "true if either is true");
    Assertions.assertTrue(e.getMustHaveValue());
  }

  @Test
  void testValueAlternatives() {
    ElementDefinition e = element();
    e.addValueAlternatives("http://a");
    e.addValueAlternatives("http://b");
    ElementDefinition t = typeRoot();
    t.addValueAlternatives("http://b");
    t.addValueAlternatives("http://c");
    merge(e, t);
    Assertions.assertEquals(1, e.getValueAlternatives().size());
    Assertions.assertEquals("http://b", e.getValueAlternatives().get(0).getValue());

    e = element();
    merge(e, t);
    Assertions.assertEquals(2, e.getValueAlternatives().size(), "copied when the element has none");
  }

  @Test
  void testMappings() {
    ElementDefinition e = element();
    e.addMapping().setIdentity("m1").setMap("base");
    ElementDefinition t = typeRoot();
    t.addMapping().setIdentity("m1").setMap("base");
    t.addMapping().setIdentity("m2").setMap("type");
    t.addMapping().setIdentity("rim").setMap("n/a,CD");
    merge(e, t);
    Assertions.assertEquals(2, e.getMapping().size(), "duplicates and the core type's mappings are not added");
    Assertions.assertEquals("m2", e.getMapping().get(1).getIdentity());

    e = element();
    t = typeRoot();
    t.addMapping().setIdentity("rim").setMap("n/a,CD,added");
    merge(e, t);
    Assertions.assertEquals(1, e.getMapping().size());
    Assertions.assertEquals("added", e.getMapping().get(0).getMap(), "only what the type profile appended to the core map");
  }

  @Test
  void testBinding() {
    ElementDefinition e = element();
    e.getBinding().setStrength(BindingStrength.EXTENSIBLE).setValueSet("http://base").setDescription("base description");
    additional(e, AdditionalBindingPurposeVS.CANDIDATE, "http://a1", "from the element");
    additional(e, AdditionalBindingPurposeVS.CANDIDATE, "http://a2", null);
    ElementDefinition t = typeRoot();
    t.getBinding().setStrength(BindingStrength.REQUIRED).setValueSet("http://type");
    additional(t, AdditionalBindingPurposeVS.CANDIDATE, "http://a1", "from the type");
    additional(t, AdditionalBindingPurposeVS.MAXIMUM, "http://a3", null);
    merge(e, t);
    Assertions.assertEquals(BindingStrength.REQUIRED, e.getBinding().getStrength());
    Assertions.assertEquals("http://type", e.getBinding().getValueSet());
    Assertions.assertFalse(e.getBinding().hasDescription());
    Assertions.assertEquals(3, e.getBinding().getAdditional().size(), "additional bindings merged by purpose + value set (R5 has no key)");
    Assertions.assertEquals("from the type", e.getBinding().getAdditional().get(0).getDocumentation());
    Assertions.assertEquals("http://a2", e.getBinding().getAdditional().get(1).getValueSet());
    Assertions.assertEquals("http://a3", e.getBinding().getAdditional().get(2).getValueSet());
  }

  private void additional(ElementDefinition ed, AdditionalBindingPurposeVS purpose, String vs, String doco) {
    ElementDefinitionBindingAdditionalComponent ab = ed.getBinding().addAdditional();
    ab.setPurpose(purpose);
    ab.setValueSet(vs);
    if (doco != null) {
      ab.setDocumentation(doco);
    }
  }
}
