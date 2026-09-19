package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_50;
import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public final class VersionConvertorFactory_10_N extends VersionConvertorFactory {

  public static org.hl7.fhir.model.core.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_10_50());
  }

  public static org.hl7.fhir.model.core.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src, BaseAdvisor_10_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? VersionConvertorFactory_50_N.convertResource(new VersionConvertor_10_50(advisor).convertResource(src)) : null;
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.model.core.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_10_50());
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.model.core.Resource src, BaseAdvisor_10_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_10_50(advisor).convertResource(VersionConvertorFactory_50_N.convertResource(src)) : null;
  }

  public static org.hl7.fhir.model.core.DataType convertType(org.hl7.fhir.dstu2.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_10_50());
  }

  public static org.hl7.fhir.model.core.DataType convertType(org.hl7.fhir.dstu2.model.Type src, BaseAdvisor_10_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? VersionConvertorFactory_50_N.convertType(new VersionConvertor_10_50(advisor).convertType(src)) : null;
  }

  public static org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.model.core.DataType src) throws FHIRException {
    return convertType(src, new BaseAdvisor_10_50());
  }

  public static org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.model.core.DataType src, BaseAdvisor_10_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_10_50(advisor).convertType(VersionConvertorFactory_50_N.convertType(src)) : null;
  }

  public static boolean convertsResource(String rt) {
    return Utilities.existsInList(rt, "Parameters", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "Bundle", "CarePlan", "Communication", "CommunicationRequest", "Composition", "ConceptMap", "Condition", "CapabilityStatement", "DetectedIssue", "DeviceMetric", "DeviceUseStatement", "DiagnosticReport", "DocumentReference", "Encounter", "EnrollmentRequest", "EnrollmentResponse", "EpisodeOfCare", "FamilyMemberHistory", "Flag", "Group", "HealthcareService", "ImplementationGuide", "ListResource", "Location", "MedicationDispense", "MedicationStatement", "MessageHeader", "NamingSystem", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Patient", "Person", "Practitioner", "Questionnaire", "QuestionnaireResponse", "RiskAssessment", "Schedule", "SearchParameter", "Slot", "StructureDefinition", "Subscription", "Substance", "SupplyDelivery", "SupplyRequest", "TestScript", "ValueSet");
  }
}