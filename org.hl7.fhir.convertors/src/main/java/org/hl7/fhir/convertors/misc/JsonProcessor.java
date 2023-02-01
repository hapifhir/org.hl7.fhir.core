package org.hl7.fhir.convertors.misc;

import java.io.FileOutputStream;
import java.io.IOException;

import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;


public class JsonProcessor {
  public static void main(String[] args) throws Exception {
    new JsonProcessor().process(args[0]);
  }

  private void process(String source) throws IOException {
    JsonObject json = JsonParser.parseObjectFromFile(source);
    process(json);
    JsonParser.compose(json, new FileOutputStream(source), true);
    
  }

  private void process(JsonObject json) {
    process(json, "ActivityDefinition.status");
    process(json, "CapabilityStatement.status");
    process(json, "CodeSystem.status");
    process(json, "CompartmentDefinition.status");
    process(json, "ConceptMap.status");
    process(json, "DataElement.status");
    process(json, "ExpansionProfile.status");
    process(json, "GraphDefinition.status");
    process(json, "ImplementationGuide.status");
    process(json, "Library.status");
    process(json, "Measure.status");
    process(json, "MessageDefinition.status");
    process(json, "OperationDefinition.status");
    process(json, "PlanDefinition.status");
    process(json, "Questionnaire.status");
    process(json, "SearchParameter.status");
    process(json, "ServiceDefinition.status");
    process(json, "StructureDefinition.status");
    process(json, "StructureMap.status");
    process(json, "TestScript.status");
    process(json, "ValueSet.status");
    process(json, "ActivityDefinition.experimental");
    process(json, "CapabilityStatement.experimental");
    process(json, "CodeSystem.experimental");
    process(json, "CompartmentDefinition.experimental");
    process(json, "ConceptMap.experimental");
    process(json, "DataElement.experimental");
    process(json, "ExpansionProfile.experimental");
    process(json, "GraphDefinition.experimental");
    process(json, "ImplementationGuide.experimental");
    process(json, "Library.experimental");
    process(json, "Measure.experimental");
    process(json, "MessageDefinition.experimental");
    process(json, "OperationDefinition.experimental");
    process(json, "PlanDefinition.experimental");
    process(json, "Questionnaire.experimental");
    process(json, "SearchParameter.experimental");
    process(json, "ServiceDefinition.experimental");
    process(json, "StructureDefinition.experimental");
    process(json, "StructureMap.experimental");
    process(json, "TestScript.experimental");
    process(json, "ValueSet.experimental");
    process(json, "Identifier.use");
    process(json, "Quantity.comparator");
    process(json, "Address.use");
    process(json, "ContactPoint.use");
    process(json, "HumanName.use");
    process(json, "BackboneElement.modifierExtension");
    process(json, "DomainResource.modifierExtension");
    process(json, "Resource.implicitRules");
    process(json, "Account.status");
    process(json, "AllergyIntolerance.clinicalStatus");
    process(json, "AllergyIntolerance.verificationStatus");
    process(json, "Appointment.status");
    process(json, "AppointmentResponse.participantStatus");
    process(json, "Basic.code");
    process(json, "BodySite.active");
    process(json, "CarePlan.status");
    process(json, "CarePlan.intent");
    process(json, "CarePlan.activity.detail.status");
    process(json, "CarePlan.activity.detail.prohibited");
    process(json, "CareTeam.status");
    process(json, "ChargeItem.status");
    process(json, "Claim.status");
    process(json, "ClaimResponse.status");
    process(json, "ClinicalImpression.status");
    process(json, "Communication.status");
    process(json, "Communication.notDone");
    process(json, "CommunicationRequest.status");
    process(json, "Composition.status");
    process(json, "Composition.confidentiality");
    process(json, "Composition.section.mode");
    process(json, "ConceptMap.group.element.target.equivalence");
    process(json, "Condition.clinicalStatus");
    process(json, "Condition.verificationStatus");
    process(json, "Consent.status");
    process(json, "Contract.status");
    process(json, "Coverage.status");
    process(json, "DetectedIssue.status");
    process(json, "Device.status");
    process(json, "DeviceRequest.status");
    process(json, "DeviceRequest.intent");
    process(json, "DeviceUseStatement.status");
    process(json, "DiagnosticReport.status");
    process(json, "DocumentManifest.status");
    process(json, "DocumentReference.status");
    process(json, "DocumentReference.relatesTo");
    process(json, "EligibilityRequest.status");
    process(json, "EligibilityResponse.status");
    process(json, "Encounter.status");
    process(json, "Endpoint.status");
    process(json, "EnrollmentRequest.status");
    process(json, "EnrollmentResponse.status");
    process(json, "EpisodeOfCare.status");
    process(json, "ExplanationOfBenefit.status");
    process(json, "FamilyMemberHistory.status");
    process(json, "FamilyMemberHistory.notDone");
    process(json, "FamilyMemberHistory.estimatedAge");
    process(json, "Flag.status");
    process(json, "Goal.status");
    process(json, "Group.characteristic.exclude");
    process(json, "GuidanceResponse.status");
    process(json, "HealthcareService.active");
    process(json, "Immunization.status");
    process(json, "Immunization.notGiven");
    process(json, "List.status");
    process(json, "List.mode");
    process(json, "List.entry.deleted");
    process(json, "Location.status");
    process(json, "Location.mode");
    process(json, "MeasureReport.status");
    process(json, "MedicationAdministration.status");
    process(json, "MedicationAdministration.notGiven");
    process(json, "MedicationDispense.status");
    process(json, "MedicationRequest.status");
    process(json, "MedicationRequest.intent");
    process(json, "MedicationRequest.substitution.allowed");
    process(json, "MedicationStatement.status");
    process(json, "MedicationStatement.taken");
    process(json, "NamingSystem.status");
    process(json, "NutritionOrder.status");
    process(json, "Observation.status");
    process(json, "OperationOutcome.issue.severity");
    process(json, "Organization.active");
    process(json, "Patient.active");
    process(json, "Patient.deceased[x]");
    process(json, "Patient.animal");
    process(json, "Patient.link");
    process(json, "PaymentNotice.status");
    process(json, "PaymentReconciliation.status");
    process(json, "Person.active");
    process(json, "Procedure.status");
    process(json, "Procedure.notDone");
    process(json, "ProcedureRequest.status");
    process(json, "ProcedureRequest.intent");
    process(json, "ProcedureRequest.doNotPerform");
    process(json, "ProcessRequest.status");
    process(json, "ProcessResponse.status");
    process(json, "Questionnaire.item.enableWhen");
    process(json, "QuestionnaireResponse.status");
    process(json, "ReferralRequest.status");
    process(json, "ReferralRequest.intent");
    process(json, "RelatedPerson.active");
    process(json, "RequestGroup.status");
    process(json, "RequestGroup.intent");
    process(json, "ResearchStudy.status");
    process(json, "ResearchSubject.status");
    process(json, "Schedule.active");
    process(json, "Specimen.status");
    process(json, "Subscription.status");
    process(json, "SupplyDelivery.status");
    process(json, "SupplyRequest.status");
    process(json, "TestReport.status");
    process(json, "ValueSet.compose.include.filter");
    process(json, "VisionPrescription.status");
  }

  private void process(JsonObject json, String name) {
    JsonObject j = json.getJsonObject(name);
    if (j == null) {
      System.out.println("Can't find "+name);
    } else {
      j.add("modifier", true);
    }
    
  }
}
