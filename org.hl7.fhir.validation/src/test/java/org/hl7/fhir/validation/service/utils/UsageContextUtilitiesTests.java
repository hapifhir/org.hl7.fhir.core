package org.hl7.fhir.validation.service.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Quantity;
import org.hl7.fhir.r5.model.Reference;
import org.hl7.fhir.r5.model.UsageContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UsageContextUtilitiesTests {

  private static final String GENDER = "http://terminology.hl7.org/CodeSystem/usage-context-type#gender";

  private UsageContext parse(String value) {
    return UsageContextUtilities.parseUsageContext(GENDER + "=" + value);
  }

  @Test
  void testTheCodeIsAlwaysACoding() {
    UsageContext usage = parse("Coding:http://hl7.org/fhir/administrative-gender#female");
    assertThat(usage.getCode().getSystem()).isEqualTo("http://terminology.hl7.org/CodeSystem/usage-context-type");
    assertThat(usage.getCode().getCode()).isEqualTo("gender");
  }

  @Test
  void testCodingBecomesACodeableConcept() {
    // UsageContext.value[x] has no Coding choice, so a coding is carried as a CodeableConcept
    UsageContext usage = parse("Coding:http://hl7.org/fhir/administrative-gender#female");
    assertThat(usage.getValue()).isInstanceOf(CodeableConcept.class);
    assertThat(usage.getValueCodeableConcept().getCoding()).hasSize(1);
    assertThat(usage.getValueCodeableConcept().getCodingFirstRep().getSystem()).isEqualTo("http://hl7.org/fhir/administrative-gender");
    assertThat(usage.getValueCodeableConcept().getCodingFirstRep().getCode()).isEqualTo("female");
  }

  @Test
  void testUntypedValueIsACoding() {
    UsageContext usage = parse("http://hl7.org/fhir/administrative-gender#female");
    assertThat(usage.getValue()).isInstanceOf(CodeableConcept.class);
    assertThat(usage.getValueCodeableConcept().getCodingFirstRep().getSystem()).isEqualTo("http://hl7.org/fhir/administrative-gender");
    assertThat(usage.getValueCodeableConcept().getCodingFirstRep().getCode()).isEqualTo("female");
  }

  @Test
  void testTypePrefixIsCaseInsensitive() {
    assertThat(parse("coding:http://hl7.org/fhir/administrative-gender#female").getValue()).isInstanceOf(CodeableConcept.class);
    assertThat(parse("QUANTITY:65:http://unitsofmeasure.org#kg").getValue()).isInstanceOf(Quantity.class);
    assertThat(parse("reference:http://example.org/fhir/Patient/1").getValue()).isInstanceOf(Reference.class);
  }

  @Test
  void testQuantity() {
    UsageContext usage = parse("Quantity:65:http://unitsofmeasure.org#kg");
    assertThat(usage.getValue()).isInstanceOf(Quantity.class);
    Quantity q = usage.getValueQuantity();
    assertThat(q.getValue().toPlainString()).isEqualTo("65");
    assertThat(q.getSystem()).isEqualTo("http://unitsofmeasure.org");
    assertThat(q.getCode()).isEqualTo("kg");
  }

  @Test
  void testQuantityWithADecimalAndANegative() {
    assertThat(parse("Quantity:1.5:http://unitsofmeasure.org#mg").getValueQuantity().getValue().toPlainString()).isEqualTo("1.5");
    assertThat(parse("Quantity:-2:http://unitsofmeasure.org#Cel").getValueQuantity().getValue().toPlainString()).isEqualTo("-2");
  }

  @Test
  void testReference() {
    UsageContext usage = parse("Reference:http://example.org/fhir/Patient/1");
    assertThat(usage.getValue()).isInstanceOf(Reference.class);
    assertThat(usage.getValueReference().getReference()).isEqualTo("http://example.org/fhir/Patient/1");
  }

  @Test
  void testSplitsOnTheFirstEqualsOnly() {
    // '=' is legal in a URL, and the value half is where one turns up
    UsageContext usage = parse("Reference:http://example.org/fhir/Patient?identifier=a|b");
    assertThat(usage.getValueReference().getReference()).isEqualTo("http://example.org/fhir/Patient?identifier=a|b");
  }

  @ParameterizedTest(name = "{index}: rejects \"{0}\"")
  @ValueSource(strings = {
    "",
    "Coding:gender",
    "Coding:#female",
    "Coding:http://hl7.org/fhir/administrative-gender#",
    "Coding:",
    "Quantity:http://unitsofmeasure.org#kg",
    "Quantity:heavy:http://unitsofmeasure.org#kg",
    "Quantity:65:kg",
    "Quantity:65:",
    "Reference:Patient/1",
    "Reference:"
  })
  void testRejectsMalformedValues(String value) {
    assertThatThrownBy(() -> parse(value)).isInstanceOf(FHIRException.class);
  }

  @ParameterizedTest(name = "{index}: rejects \"{0}\"")
  @ValueSource(strings = {
    "",
    "gender",
    "=",
    "=Coding:http://hl7.org/fhir/administrative-gender#female",
    "http://terminology.hl7.org/CodeSystem/usage-context-type#gender=",
    "gender=Coding:http://hl7.org/fhir/administrative-gender#female",
    "http://terminology.hl7.org/CodeSystem/usage-context-type#=Coding:http://hl7.org/fhir/administrative-gender#female"
  })
  void testRejectsMalformedPairs(String src) {
    assertThatThrownBy(() -> UsageContextUtilities.parseUsageContext(src)).isInstanceOf(FHIRException.class);
  }

  @Test
  void testRejectsNull() {
    assertThatThrownBy(() -> UsageContextUtilities.parseUsageContext(null)).isInstanceOf(FHIRException.class);
  }
}
