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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * AU Core blood pressure: the base profile (like the R4 bp profile) narrows component:SystolicBP.value[x] to
 * Quantity and constrains its children, and the derived profile constrains component:SystolicBP.valueQuantity.
 * The snapshot used to get a second component:SystolicBP.value[x] slicer, so validating an instance with a
 * systolic component failed with "Slice encountered midway through set". The same applies to
 * Observation.valueQuantity at the root.
 */
class RenamedChoiceValidationTests {

  private static final String BASE_URL = "http://example.org/StructureDefinition/bp-base";
  private static final String DERIVED_URL = "http://example.org/StructureDefinition/bp-derived";
  private static final String SYSTOLIC = "8480-6";

  @ParameterizedTest
  @ValueSource(booleans = {false, true})
  void instanceValidatesAgainstRenamedChoice(boolean inSlice) throws Exception {
    ValidationEngine ve = TestUtilities.getValidationEngine("hl7.fhir.r5.core#5.0.0", "n/a", FhirPublication.R5, "5.0.0");
    ve.getContext().cacheResource(baseProfile(inSlice));
    ve.getContext().cacheResource(derivedProfile(inSlice));

    byte[] obs = new JsonParser(ModelContext.fullCoreContext()).composeBytes(observation(inSlice));
    OperationOutcome op = ve.validate(FhirFormat.JSON, new ByteArrayInputStream(obs), List.of(DERIVED_URL));

    List<String> errors = new ArrayList<>();
    for (OperationOutcomeIssueComponent issue : op.getIssueList()) {
      if (issue.getSeverity() == IssueSeverity.ERROR || issue.getSeverity() == IssueSeverity.FATAL) {
        errors.add(issue.getDetails().getText());
      }
    }
    assertTrue(errors.isEmpty(), "unexpected errors: " + errors);
  }

  private StructureDefinition baseProfile(boolean inSlice) {
    StructureDefinition sd = profile("bp-base", BASE_URL, "http://hl7.org/fhir/StructureDefinition/Observation");
    String id = parentId(inSlice);
    String path = parentPath(inSlice);
    if (inSlice) {
      ElementDefinition component = add(sd, "Observation.component", "Observation.component", null);
      component.getSlicing().addDiscriminator().setType(DiscriminatorType.VALUE).setPath("code");
      component.getSlicing().setRules(SlicingRules.OPEN);
      add(sd, id, path, "SystolicBP");
      add(sd, id + ".code", path + ".code", null).setPattern(systolicCode());
    }
    add(sd, id + ".value[x]", path + ".value[x]", null).addType().setCode("Quantity");
    add(sd, id + ".value[x].unit", path + ".value[x].unit", null).setMustSupport(true);
    return sd;
  }

  private StructureDefinition derivedProfile(boolean inSlice) {
    StructureDefinition sd = profile("bp-derived", DERIVED_URL, BASE_URL);
    String id = parentId(inSlice);
    String path = parentPath(inSlice);
    if (inSlice) {
      add(sd, id, path, "SystolicBP");
    }
    add(sd, id + ".valueQuantity", path + ".valueQuantity", null).setMustSupport(true);
    return sd;
  }

  private Observation observation(boolean inSlice) {
    Observation obs = new Observation();
    obs.setStatus(ObservationStatus.FINAL);
    obs.getCode().setText("Blood pressure");
    if (inSlice) {
      obs.addComponent().setCode(systolicCode()).setValue(new Quantity().setValue(120));
    } else {
      obs.setValue(new Quantity().setValue(120));
    }
    return obs;
  }

  private String parentId(boolean inSlice) {
    return inSlice ? "Observation.component:SystolicBP" : "Observation";
  }

  private String parentPath(boolean inSlice) {
    return inSlice ? "Observation.component" : "Observation";
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
