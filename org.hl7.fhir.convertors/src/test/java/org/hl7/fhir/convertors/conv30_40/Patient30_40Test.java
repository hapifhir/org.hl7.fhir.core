package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.resources30_40.Patient30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Patient30_40Test {

  @BeforeAll
  public static void setUp() {
    ConversionContext30_40.INSTANCE.init(new VersionConvertor_30_40(new BaseAdvisor_30_40()), "");
  }

  @Test
  public void convertPatientDstu3ToR4() {
    org.hl7.fhir.dstu3.model.Patient input = new org.hl7.fhir.dstu3.model.Patient();
    input.addIdentifier().setValue("12345").setSystem("system");
    input.setActive(true);
    input.addName().setFamily("Awesome");
    input.addTelecom().setValue("123456789");
    input.setGender(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.FEMALE);
    Date birthDate = Date.from(LocalDate.of(1983, 1, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
    input.setBirthDate(birthDate);
    input.setDeceased(new org.hl7.fhir.dstu3.model.BooleanType(true));
    input.addAddress().setCity("Big City");
    input.setMaritalStatus(createDstu3CodeableConcept("Married"));
    input.setMultipleBirth(new org.hl7.fhir.dstu3.model.BooleanType(true));
    input.addPhoto().setTitle("Profile picture");
    input.addContact().addRelationship(createDstu3CodeableConcept("Dad"));
    input.setAnimal(new org.hl7.fhir.dstu3.model.Patient.AnimalComponent(createDstu3CodeableConcept("dog")));
    input.addCommunication().setLanguage(createDstu3CodeableConcept("en"));
    input.addGeneralPractitioner(new org.hl7.fhir.dstu3.model.Reference("Practitioner/12345"));
    input.setManagingOrganization(new org.hl7.fhir.dstu3.model.Reference("Organization/12345"));
    input.addLink().setOther(new org.hl7.fhir.dstu3.model.Reference("Resource/12345"));

    org.hl7.fhir.r4.model.Patient result = (org.hl7.fhir.r4.model.Patient) VersionConvertorFactory_30_40.convertResource(input);

    assertThat(result).isNotNull();
    assertThat(result.getIdentifier()).hasSize(1);
    assertTrue(result.getIdentifier().get(0).equalsDeep(new org.hl7.fhir.r4.model.Identifier().setValue("12345").setSystem("system")));

    assertThat(result.getActive()).isTrue();
    assertThat(result.getName()).hasSize(1);
    assertThat(result.getName().get(0).getFamily()).isEqualTo("Awesome");
    assertThat(result.getTelecom()).hasSize(1);
    assertThat(result.getTelecom().get(0).getValue()).isEqualTo("123456789");
    assertThat(result.getGender()).isEqualTo(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE);
    assertThat(result.getBirthDate()).isEqualTo(birthDate);
    assertThat(result.getDeceasedBooleanType().getValue()).isTrue();
    assertThat(result.getAddress()).hasSize(1);
    assertThat(result.getAddress().get(0).getCity()).isEqualTo("Big City");
    assertTrue(result.getMaritalStatus().equalsDeep(createR4CodeableConcept("Married")));
    assertThat(result.getMultipleBirthBooleanType().getValue()).isTrue();
    assertThat(result.getPhoto()).hasSize(1);
    assertThat(result.getPhoto().get(0).getTitle()).isEqualTo("Profile picture");
    assertThat(result.getContact()).hasSize(1);
    assertThat(result.getContact().get(0).getRelationship()).hasSize(1);
    assertTrue(result.getContact().get(0).getRelationship().get(0).equalsDeep(createR4CodeableConcept("Dad")));
    assertThat(result.getExtension()).hasSize(1);
    assertThat(result.getExtension().get(0).getUrl()).isEqualTo(VersionConvertorConstants.EXT_PAT_ANIMAL);
    assertThat(result.getCommunication()).hasSize(1);
    assertTrue(result.getCommunication().get(0).getLanguage().equalsDeep(createR4CodeableConcept("en")));
    assertThat(result.getGeneralPractitioner()).hasSize(1);
    assertTrue(result.getGeneralPractitioner().get(0).equalsDeep(new org.hl7.fhir.r4.model.Reference("Practitioner/12345")));
    assertTrue(result.getManagingOrganization().equalsDeep(new org.hl7.fhir.r4.model.Reference("Organization/12345")));
    assertThat(result.getLink()).hasSize(1);
    assertTrue(result.getLink().get(0).getOther().equalsDeep(new org.hl7.fhir.r4.model.Reference("Resource/12345")));
  }

  @Test
  public void convertAnimalComponentDstu3ToR4() {
    org.hl7.fhir.dstu3.model.Patient.AnimalComponent input = new org.hl7.fhir.dstu3.model.Patient.AnimalComponent();
    input.setSpecies(createDstu3CodeableConcept("dog"));
    input.setBreed(createDstu3CodeableConcept("labradoodle"));
    input.setGenderStatus(createDstu3CodeableConcept("female"));

    org.hl7.fhir.r4.model.Extension result = Patient30_40.convertAnimalComponent(input);

    assertThat(result).isNotNull();
    assertThat(result.getUrl()).isEqualTo(VersionConvertorConstants.EXT_PAT_ANIMAL);
    assertThat(result.getValue()).isNull();
    assertThat(result.getExtension()).hasSize(3);

    org.hl7.fhir.r4.model.Extension speciesExtension = result.getExtensionByUrl("species");
    assertThat(speciesExtension).isNotNull();
    assertTrue(speciesExtension.getValue().equalsDeep(createR4CodeableConcept("dog")));

    org.hl7.fhir.r4.model.Extension breedExtension = result.getExtensionByUrl("breed");
    assertThat(breedExtension).isNotNull();
    assertTrue(breedExtension.getValue().equalsDeep(createR4CodeableConcept("labradoodle")));

    org.hl7.fhir.r4.model.Extension genderExtension = result.getExtensionByUrl("genderStatus");
    assertThat(genderExtension).isNotNull();
    assertTrue(genderExtension.getValue().equalsDeep(createR4CodeableConcept("female")));
  }


  @Test
  public void convertPatientR4ToDstu3() {
    org.hl7.fhir.r4.model.Patient input = new org.hl7.fhir.r4.model.Patient();
    input.addIdentifier().setValue("12345").setSystem("system");
    input.setActive(true);
    input.addName().setFamily("Awesome");
    input.addTelecom().setValue("123456789");
    input.setGender(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE);
    Date birthDate = Date.from(LocalDate.of(1983, 1, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
    input.setBirthDate(birthDate);
    input.setDeceased(new org.hl7.fhir.r4.model.BooleanType(true));
    input.addAddress().setCity("Big City");
    input.setMaritalStatus(createR4CodeableConcept("Married"));
    input.setMultipleBirth(new org.hl7.fhir.r4.model.BooleanType(true));
    input.addPhoto().setTitle("Profile picture");
    input.addContact().addRelationship(createR4CodeableConcept("Dad"));

    org.hl7.fhir.r4.model.Extension animalExtension = new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_PAT_ANIMAL);
    animalExtension.addExtension("species", createR4CodeableConcept("dog"));
    input.addExtension(animalExtension);
    input.addCommunication().setLanguage(createR4CodeableConcept("en"));
    input.addGeneralPractitioner(new org.hl7.fhir.r4.model.Reference("Practitioner/12345"));
    input.setManagingOrganization(new org.hl7.fhir.r4.model.Reference("Organization/12345"));
    input.addLink().setOther(new org.hl7.fhir.r4.model.Reference("Resource/12345"));

    org.hl7.fhir.dstu3.model.Patient result = (org.hl7.fhir.dstu3.model.Patient) VersionConvertorFactory_30_40.convertResource(input);

    assertThat(result).isNotNull();
    assertThat(result.getIdentifier()).hasSize(1);
    assertTrue(result.getIdentifier().get(0).equalsDeep(new org.hl7.fhir.dstu3.model.Identifier().setValue("12345").setSystem("system")));

    assertThat(result.getActive()).isTrue();
    assertThat(result.getName()).hasSize(1);
    assertThat(result.getName().get(0).getFamily()).isEqualTo("Awesome");
    assertThat(result.getTelecom()).hasSize(1);
    assertThat(result.getTelecom().get(0).getValue()).isEqualTo("123456789");
    assertThat(result.getGender()).isEqualTo(org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender.FEMALE);
    assertThat(result.getBirthDate()).isEqualTo(birthDate);
    assertThat(result.getDeceasedBooleanType().getValue()).isTrue();
    assertThat(result.getAddress()).hasSize(1);
    assertThat(result.getAddress().get(0).getCity()).isEqualTo("Big City");
    assertTrue(result.getMaritalStatus().equalsDeep(createDstu3CodeableConcept("Married")));
    assertThat(result.getMultipleBirthBooleanType().getValue()).isTrue();
    assertThat(result.getPhoto()).hasSize(1);
    assertThat(result.getPhoto().get(0).getTitle()).isEqualTo("Profile picture");
    assertThat(result.getContact()).hasSize(1);
    assertThat(result.getContact().get(0).getRelationship()).hasSize(1);
    assertTrue(result.getContact().get(0).getRelationship().get(0).equalsDeep(createDstu3CodeableConcept("Dad")));
    assertThat(result.getExtensionByUrl(VersionConvertorConstants.EXT_PAT_ANIMAL)).isNull();
    assertTrue(result.getAnimal().getSpecies().equalsDeep(createDstu3CodeableConcept("dog")));
    assertThat(result.getCommunication()).hasSize(1);
    assertTrue(result.getCommunication().get(0).getLanguage().equalsDeep(createDstu3CodeableConcept("en")));
    assertThat(result.getGeneralPractitioner()).hasSize(1);
    assertTrue(result.getGeneralPractitioner().get(0).equalsDeep(new org.hl7.fhir.dstu3.model.Reference("Practitioner/12345")));
    assertTrue(result.getManagingOrganization().equalsDeep(new org.hl7.fhir.dstu3.model.Reference("Organization/12345")));
    assertThat(result.getLink()).hasSize(1);
    assertTrue(result.getLink().get(0).getOther().equalsDeep(new org.hl7.fhir.dstu3.model.Reference("Resource/12345")));
  }

  @Test
  public void convertAnimalComponentR4ToDstu3() {
    org.hl7.fhir.r4.model.Extension input = new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.EXT_PAT_ANIMAL);
    input.addExtension(new org.hl7.fhir.r4.model.Extension("species", createR4CodeableConcept("dog")));
    input.addExtension(new org.hl7.fhir.r4.model.Extension("breed", createR4CodeableConcept("labradoodle")));
    input.addExtension(new org.hl7.fhir.r4.model.Extension("genderStatus", createR4CodeableConcept("female")));

    org.hl7.fhir.dstu3.model.Patient.AnimalComponent result = Patient30_40.convertAnimalComponent(input);
    assertThat(result).isNotNull();
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
