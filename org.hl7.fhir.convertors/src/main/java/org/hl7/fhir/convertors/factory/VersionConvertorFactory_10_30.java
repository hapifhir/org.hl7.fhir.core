package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_30;
import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public final class VersionConvertorFactory_10_30 extends VersionConvertorFactory {

  public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_10_30());
  }

  public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src, BaseAdvisor_10_30 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_10_30(advisor).convertResource(src) : null;
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_10_30());
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src, BaseAdvisor_10_30 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_10_30(advisor).convertResource(src) : null;
  }

  public static org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.dstu2.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_10_30());
  }

  public static org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.dstu2.model.Type src, BaseAdvisor_10_30 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_10_30(advisor).convertType(src) : null;
  }

  public static org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_10_30());
  }

  public static org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.dstu3.model.Type src, BaseAdvisor_10_30 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_10_30(advisor).convertType(src) : null;
  }

  public static boolean convertsResource(String rt) {
    return Utilities.existsInList(rt, "Parameters", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "Bundle", "CarePlan", "ClinicalImpression", "Communication", "CommunicationRequest", "Composition", "ConceptMap", "Condition", "CapabilityStatement", "Contract", "DataElement", "DetectedIssue", "Device", "DeviceComponent", "DeviceMetric", "DeviceUseStatement", "DiagnosticReport", "DocumentManifest", "DocumentReference", "Encounter", "EnrollmentRequest", "EnrollmentResponse", "EpisodeOfCare", "FamilyMemberHistory", "Flag", "Group", "HealthcareService", "ImagingStudy", "Immunization", "ImmunizationRecommendation", "ImplementationGuide", "ListResource", "Location", "Media", "Medication", "MedicationDispense", "MedicationStatement", "MessageHeader", "NamingSystem", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Patient", "Person", "Practitioner", "Procedure", "ProcedureRequest", "Provenance", "Questionnaire", "QuestionnaireResponse", "ReferralRequest", "RelatedPerson", "RiskAssessment", "Schedule", "SearchParameter", "Slot", "StructureDefinition", "Subscription", "Substance", "SupplyDelivery", "SupplyRequest", "TestScript", "ValueSet");
  }
}