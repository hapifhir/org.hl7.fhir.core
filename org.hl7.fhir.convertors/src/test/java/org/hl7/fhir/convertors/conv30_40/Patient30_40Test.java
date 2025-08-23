package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.resources30_40.Patient30_40;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Patient30_40Test {

  @BeforeAll
  public static void setUp() {
    ConversionContext30_40.INSTANCE.init(new VersionConvertor_30_40(new BaseAdvisor_30_40()), "");
  }

  @Test
  public void convertAnimalComponentdstu3ToR4() {
    org.hl7.fhir.dstu3.model.Patient.AnimalComponent input = new org.hl7.fhir.dstu3.model.Patient.AnimalComponent();
    input.setSpecies(createDstu3CodeableConcept("dog"));
    input.setBreed(createDstu3CodeableConcept("labradoodle"));
    input.setGenderStatus(createDstu3CodeableConcept("female"));

    org.hl7.fhir.r4.model.Extension result = Patient30_40.convertAnimalComponent(input);

    assertThat(result, is(not(nullValue())));
    assertThat(result.getUrl(), is(VersionConvertorConstants.EXT_PAT_ANIMAL));
    assertThat(result.getValue(), is(nullValue()));
    assertThat(result.getExtension(), hasSize(3));

    org.hl7.fhir.r4.model.Extension speciesExtension = result.getExtensionByUrl("species");
    assertThat(speciesExtension, is(not(nullValue())));
    assertTrue(speciesExtension.getValue().equalsDeep(createR4CodeableConcept("dog")));

    org.hl7.fhir.r4.model.Extension breedExtension = result.getExtensionByUrl("breed");
    assertThat(breedExtension, is(not(nullValue())));
    assertTrue(breedExtension.getValue().equalsDeep(createR4CodeableConcept("labradoodle")));

    org.hl7.fhir.r4.model.Extension genderExtension = result.getExtensionByUrl("genderStatus");
    assertThat(genderExtension, is(not(nullValue())));
    assertTrue(genderExtension.getValue().equalsDeep(createR4CodeableConcept("female")));
  }

  @Test
  public void convertAnimalComponentR4ToDstu3() {
    org.hl7.fhir.r4.model.Extension input = new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_PAT_ANIMAL);
    input.addExtension(new org.hl7.fhir.r4.model.Extension("species", createR4CodeableConcept("dog")));
    input.addExtension(new org.hl7.fhir.r4.model.Extension("breed", createR4CodeableConcept("labradoodle")));
    input.addExtension(new org.hl7.fhir.r4.model.Extension("genderStatus", createR4CodeableConcept("female")));

    org.hl7.fhir.dstu3.model.Patient.AnimalComponent result = Patient30_40.convertAnimalComponent(input);
    assertThat(result, is(not(nullValue())));
    assertTrue(result.getSpecies().equalsDeep(createDstu3CodeableConcept("dog")));
    assertTrue(result.getBreed().equalsDeep(createDstu3CodeableConcept("labradoodle")));
    assertTrue(result.getGenderStatus().equalsDeep(createDstu3CodeableConcept("female")));
  }

  private org.hl7.fhir.dstu3.model.CodeableConcept createDstu3CodeableConcept(String coding) {
    return new org.hl7.fhir.dstu3.model.CodeableConcept(new org.hl7.fhir.dstu3.model.Coding(coding, coding, coding));
  }

  private org.hl7.fhir.r4.model.CodeableConcept createR4CodeableConcept(String coding) {
    return new org.hl7.fhir.r4.model.CodeableConcept(new org.hl7.fhir.r4.model.Coding(coding, coding, coding));
  }
}
