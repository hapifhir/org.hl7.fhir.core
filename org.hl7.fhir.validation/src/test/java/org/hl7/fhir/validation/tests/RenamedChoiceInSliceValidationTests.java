package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.model.core.ElementDefinition.SlicingRules;
import org.hl7.fhir.model.core.Enumerations.ObservationStatus;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.Observation;
import org.hl7.fhir.model.core.OperationOutcome;
import org.hl7.fhir.model.core.OperationOutcome.IssueSeverity;
import org.hl7.fhir.model.core.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.model.core.Quantity;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.core.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.model.core.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.Test;

/**
 * AU Core blood pressure: the base profile (like the R4 bp profile) narrows component:SystolicBP.value[x] to
 * Quantity and constrains its children, and the derived profile constrains component:SystolicBP.valueQuantity.
 * The snapshot used to get a second component:SystolicBP.value[x] slicer, so validating an instance with a
 * systolic component failed with "Slice encountered midway through set".
 */
class RenamedChoiceInSliceValidationTests {

  private static final String BASE_URL = "http://example.org/StructureDefinition/bp-base";
  private static final String DERIVED_URL = "http://example.org/StructureDefinition/bp-derived";
  private static final String SYSTOLIC = "8480-6";

  @Test
  void instanceValidatesAgainstRenamedChoiceInSlice() throws Exception {
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r5.core#5.0.0", "n/a", FhirPublication.R5, "5.0.0");
    ve.getContext().cacheResource(baseProfile());
    ve.getContext().cacheResource(derivedProfile());

    byte[] obs = new JsonParser(ModelContext.fullCoreContext()).composeBytes(observation());
    OperationOutcome op = ve.validate(FhirFormat.JSON, new ByteArrayInputStream(obs), List.of(DERIVED_URL));

    List<String> errors = new ArrayList<>();
    for (OperationOutcomeIssueComponent issue : op.getIssueList()) {
      if (issue.getSeverity() == IssueSeverity.ERROR || issue.getSeverity() == IssueSeverity.FATAL) {
        errors.add(issue.getDetails().getText());
      }
    }
    assertTrue(errors.isEmpty(), "unexpected errors: " + errors);
  }

  private StructureDefinition baseProfile() {
    StructureDefinition sd = profile("bp-base", BASE_URL, "http://hl7.org/fhir/StructureDefinition/Observation");
    ElementDefinition component = add(sd, "Observation.component", "Observation.component", null);
    component.getSlicing().addDiscriminator().setType(DiscriminatorType.VALUE).setPath("code");
    component.getSlicing().setRules(SlicingRules.OPEN);
    add(sd, "Observation.component:SystolicBP", "Observation.component", "SystolicBP");
    add(sd, "Observation.component:SystolicBP.code", "Observation.component.code", null).setPattern(systolicCode());
    add(sd, "Observation.component:SystolicBP.value[x]", "Observation.component.value[x]", null).addType().setCode("Quantity");
    add(sd, "Observation.component:SystolicBP.value[x].unit", "Observation.component.value[x].unit", null).setMustSupport(true);
    return sd;
  }

  private StructureDefinition derivedProfile() {
    StructureDefinition sd = profile("bp-derived", DERIVED_URL, BASE_URL);
    add(sd, "Observation.component:SystolicBP", "Observation.component", "SystolicBP");
    add(sd, "Observation.component:SystolicBP.valueQuantity", "Observation.component.valueQuantity", null).setMustSupport(true);
    return sd;
  }

  private Observation observation() {
    Observation obs = new Observation();
    obs.setStatus(ObservationStatus.FINAL);
    obs.getCode().setText("Blood pressure");
    obs.addComponent().setCode(systolicCode()).setValue(new Quantity().setValue(120));
    return obs;
  }

  private CodeableConcept systolicCode() {
    return new CodeableConcept(new Coding("http://loinc.org", SYSTOLIC, null));
  }

  private StructureDefinition profile(String name, String url, String baseUrl) {
    StructureDefinition sd = new StructureDefinition();
    sd.setUrl(url);
    sd.setName(name);
    sd.setStatus(PublicationStatus.DRAFT);
    sd.setKind(StructureDefinitionKind.RESOURCE);
    sd.setAbstract(false);
    sd.setType("Observation");
    sd.setDerivation(TypeDerivationRule.CONSTRAINT);
    sd.setBaseDefinition(baseUrl);
    add(sd, "Observation", "Observation", null);
    return sd;
  }

  private ElementDefinition add(StructureDefinition sd, String id, String path, String sliceName) {
    ElementDefinition ed = sd.getDifferential().addElement();
    ed.setId(id);
    ed.setPath(path);
    if (sliceName != null) {
      ed.setSliceName(sliceName);
    }
    return ed;
  }
}
