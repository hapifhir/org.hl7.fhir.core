package org.hl7.fhir.model.core;

import java.util.AbstractList;
import java.util.List;

public class CoreResourceNameList extends AbstractList<String> {

  private static final List<String> DATA = List.of(
      "Account",
      "ActivityDefinition",
      "ActorDefinition",
      "AdministrableProductDefinition",
      "AdverseEvent",
      "AllergyIntolerance",
      "Appointment",
      "AppointmentResponse",
      "ArtifactAssessment",
      "AuditEvent",
      "Basic",
      "Binary",
      "BiologicallyDerivedProduct",
      "BodyStructure",
      "Bundle",
      "CapabilityStatement",
      "CarePlan",
      "CareTeam",
      "Claim",
      "ClaimResponse",
      "ClinicalUseDefinition",
      "CodeSystem",
      "Communication",
      "CommunicationRequest",
      "CompartmentDefinition",
      "Composition",
      "ConceptMap",
      "Condition",
      "Consent",
      "Coverage",
      "CoverageEligibilityRequest",
      "CoverageEligibilityResponse",
      "DetectedIssue",
      "Device",
      "DeviceAlert",
      "DeviceAssociation",
      "DeviceDefinition",
      "DeviceMetric",
      "DeviceRequest",
      "DiagnosticReport",
      "DocumentReference",
      "Encounter",
      "Endpoint",
      "EpisodeOfCare",
      "EventDefinition",
      "Evidence",
      "EvidenceVariable",
      "ExampleScenario",
      "ExplanationOfBenefit",
      "FamilyMemberHistory",
      "Flag",
      "Goal",
      "Group",
      "GuidanceResponse",
      "HealthcareService",
      "ImagingSelection",
      "ImagingStudy",
      "Immunization",
      "ImplementationGuide",
      "Ingredient",
      "Library",
      "List",
      "Location",
      "ManufacturedItemDefinition",
      "Measure",
      "MeasureReport",
      "Medication",
      "MedicationAdministration",
      "MedicationDispense",
      "MedicationRequest",
      "MedicationStatement",
      "MedicinalProductDefinition",
      "MessageDefinition",
      "MessageHeader",
      "NamingSystem",
      "NutritionIntake",
      "NutritionOrder",
      "NutritionProduct",
      "Observation",
      "ObservationDefinition",
      "OperationDefinition",
      "OperationOutcome",
      "Organization",
      "OrganizationAffiliation",
      "PackagedProductDefinition",
      "Parameters",
      "Patient",
      "PaymentNotice",
      "PaymentReconciliation",
      "Person",
      "PlanDefinition",
      "Practitioner",
      "PractitionerRole",
      "Procedure",
      "Provenance",
      "Questionnaire",
      "QuestionnaireResponse",
      "RegulatedAuthorization",
      "RelatedPerson",
      "RequestOrchestration",
      "Requirements",
      "ResearchStudy",
      "ResearchSubject",
      "RiskAssessment",
      "Schedule",
      "SearchParameter",
      "ServiceRequest",
      "Slot",
      "Specimen",
      "SpecimenDefinition",
      "StructureDefinition",
      "Subscription",
      "SubscriptionStatus",
      "SubscriptionTopic",
      "Substance",
      "SubstanceDefinition",
      "Task",
      "TerminologyCapabilities",
      "ValueSet",
      "VisionPrescription"
  );

  private static final CoreResourceNameList INSTANCE = new CoreResourceNameList();

  private CoreResourceNameList() {
  }

  public static CoreResourceNameList getInstance() {
    return INSTANCE;
  }

  @Override
  public String get(int index) {
    return DATA.get(index);
  }

  @Override
  public int size() {
    return DATA.size();
  }
}
