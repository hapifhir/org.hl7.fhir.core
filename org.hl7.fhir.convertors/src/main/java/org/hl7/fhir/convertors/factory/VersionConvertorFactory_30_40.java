package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public final class VersionConvertorFactory_30_40 {

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_30_40());
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src, BaseAdvisor_30_40 advisor) throws FHIRException {
    return new VersionConvertor_30_40(advisor).convertResource(src);
  }

  public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_30_40());
  }

  public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src, BaseAdvisor_30_40 advisor) throws FHIRException {
    return new VersionConvertor_30_40(advisor).convertResource(src);
  }

  public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_30_40());
  }

  public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.dstu3.model.Type src, BaseAdvisor_30_40 advisor) throws FHIRException {
    return new VersionConvertor_30_40(advisor).convertType(src);
  }

  public static org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_30_40());
  }

  public static org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.r4.model.Type src, BaseAdvisor_30_40 advisor) throws FHIRException {
    return new VersionConvertor_30_40(advisor).convertType(src);
  }

  public static boolean convertsResource(String rt) {
    return Utilities.existsInList(rt, "Parameters", "ActivityDefinition", "AllergyIntolerance", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "BodyStructure", "Bundle", "CapabilityStatement", "CarePlan", "CareTeam", "ClinicalImpression", "CodeSystem", "Communication", "CompartmentDefinition", "Composition", "ConceptMap", "Condition", "Consent", "DetectedIssue", "DeviceUseStatement", "DiagnosticReport", "DocumentReference", "Encounter", "Endpoint", "EpisodeOfCare", "FamilyMemberHistory", "Flag", "Goal", "GraphDefinition", "Group", "HealthcareService", "ImagingStudy", "Immunization", "ImplementationGuide", "Library", "Linkage", "ListResource", "Location", "Media", "Medication", "MedicationAdministration", "MedicationDispense", "MedicationRequest", "MedicationStatement", "MessageDefinition", "MessageHeader", "NamingSystem", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Patient", "PaymentNotice", "Person", "PlanDefinition", "Practitioner", "PractitionerRole", "Procedure", "ProcedureRequest", "ProcessRequest", "Provenance", "Questionnaire", "QuestionnaireResponse", "RelatedPerson", "RiskAssessment", "Schedule", "SearchParameter", "Sequence", "Slot", "Specimen", "StructureDefinition", "StructureMap", "Subscription", "Substance", "SupplyDelivery", "TestReport", "TestScript", "ValueSet");
  }
}