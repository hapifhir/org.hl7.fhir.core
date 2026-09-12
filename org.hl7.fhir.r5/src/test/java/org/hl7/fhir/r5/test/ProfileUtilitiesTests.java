package org.hl7.fhir.r5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.Test;

public class ProfileUtilitiesTests {

  private static final String RESOURCE_ID_PATH = "Resource.id";
  private static final String TEST_USER_DATA_KEY = "profile-utilities-test";

  @Test
  public void generateSnapshotDoesNotMutateBase() throws IOException {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext("5.0.0");
    StructureDefinition base =
        context
            .fetchResource(
                StructureDefinition.class,
                "http://hl7.org/fhir/StructureDefinition/Patient")
            .copy();
    ElementDefinition baseResourceId = getResourceId(base);
    TypeRefComponent baseResourceIdType = baseResourceId.getTypeFirstRep();
    baseResourceIdType.setCode("id");
    baseResourceIdType.removeExtension(ExtensionDefinitions.EXT_FHIR_TYPE);
    ExtensionUtilities.addUrlExtension(
        baseResourceIdType, ExtensionDefinitions.EXT_FHIR_TYPE, "original-id");
    Object userData = new Object();
    baseResourceId.setUserData(TEST_USER_DATA_KEY, userData);
    StructureDefinition originalBase = base.copy();

    StructureDefinition derived = patientProfile();
    new ProfileUtilities(context, null, null)
        .generateSnapshot(base, derived, derived.getUrl(), "http://example.org", derived.getName());

    assertTrue(base.equalsDeep(originalBase), "Snapshot generation mutated the supplied base");
    ElementDefinition derivedResourceId = getResourceId(derived);
    TypeRefComponent derivedResourceIdType = derivedResourceId.getTypeFirstRep();
    assertEquals("http://hl7.org/fhirpath/System.String", derivedResourceIdType.getCode());
    assertEquals(
        "id",
        ExtensionUtilities.readStringExtension(
            derivedResourceIdType, ExtensionDefinitions.EXT_FHIR_TYPE));
    assertSame(userData, derivedResourceId.getUserData(TEST_USER_DATA_KEY));
  }

  private static ElementDefinition getResourceId(StructureDefinition structureDefinition) {
    return structureDefinition.getSnapshot().getElement().stream()
        .filter(
            element ->
                element.hasBase() && RESOURCE_ID_PATH.equals(element.getBase().getPath()))
        .findFirst()
        .orElseThrow();
  }

  private static StructureDefinition patientProfile() {
    StructureDefinition profile = new StructureDefinition();
    profile.setId("patient-profile");
    profile.setUrl("http://example.org/StructureDefinition/patient-profile");
    profile.setName("PatientProfile");
    profile.setStatus(PublicationStatus.ACTIVE);
    profile.setType("Patient");
    profile.setKind(StructureDefinitionKind.RESOURCE);
    profile.setAbstract(false);
    profile.setDerivation(TypeDerivationRule.CONSTRAINT);
    profile.setBaseDefinition("http://hl7.org/fhir/StructureDefinition/Patient");
    ElementDefinition root = profile.getDifferential().addElement();
    root.setId("Patient");
    root.setPath("Patient");
    return profile;
  }
}
