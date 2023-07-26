package org.hl7.fhir.convertors.conv30_50;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_50;
import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Extension30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Meta30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Narrative30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Code30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Id30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.ActivityDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.ActorDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.AllergyIntolerance30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Appointment30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.AppointmentResponse30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.AuditEvent30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Basic30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Binary30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.BodySite30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Bundle30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.CapabilityStatement30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.CarePlan30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.CareTeam30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.ClinicalImpression30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.CodeSystem30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Communication30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.CompartmentDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Composition30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.ConceptMap30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Condition30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Consent30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.DataElement30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.DetectedIssue30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.DeviceUseStatement30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.DiagnosticReport30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.DocumentReference30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Encounter30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Endpoint30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.EpisodeOfCare30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.ExpansionProfile30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.FamilyMemberHistory30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Flag30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Goal30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.GraphDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Group30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.HealthcareService30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.ImagingStudy30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Immunization30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.ImplementationGuide30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Library30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Linkage30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.List30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Location30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Measure30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Media30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Medication30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.MedicationAdministration30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.MedicationDispense30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.MedicationRequest30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.MedicationStatement30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.MessageDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.MessageHeader30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.NamingSystem30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Observation30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.OperationDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.OperationOutcome30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Organization30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Parameters30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Patient30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.PaymentNotice30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Person30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.PlanDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Practitioner30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.PractitionerRole30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Provenance30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Questionnaire30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.QuestionnaireResponse30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.RelatedPerson30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Requirements30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.RiskAssessment30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Schedule30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.SearchParameter30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Slot30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Specimen30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.StructureDefinition30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.StructureMap30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.Substance30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.SupplyDelivery30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.TestPlan30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.TestReport30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.TestScript30_50;
import org.hl7.fhir.convertors.conv30_50.resources30_50.ValueSet30_50;
import org.hl7.fhir.dstu3.model.Basic;
import org.hl7.fhir.exceptions.FHIRException;

public class Resource30_50 {

  public final BaseAdvisor_30_50 advisor;

  public Resource30_50(BaseAdvisor_30_50 advisor) {
    this.advisor = advisor;
  }

  public void copyResource(org.hl7.fhir.dstu3.model.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id30_50.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta30_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguageElement(Code30_50.convertCode(src.getLanguageElement()));
  }

  public void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.dstu3.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id30_50.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta30_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguageElement(Code30_50.convertCode(src.getLanguageElement()));
  }

  public org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.dstu3.model.Parameters)
      return Parameters30_50.convertParameters((org.hl7.fhir.dstu3.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ActivityDefinition)
      return ActivityDefinition30_50.convertActivityDefinition((org.hl7.fhir.dstu3.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AllergyIntolerance)
      return AllergyIntolerance30_50.convertAllergyIntolerance((org.hl7.fhir.dstu3.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Appointment)
      return Appointment30_50.convertAppointment((org.hl7.fhir.dstu3.model.Appointment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AppointmentResponse)
      return AppointmentResponse30_50.convertAppointmentResponse((org.hl7.fhir.dstu3.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AuditEvent)
      return AuditEvent30_50.convertAuditEvent((org.hl7.fhir.dstu3.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Basic) {
      org.hl7.fhir.dstu3.model.Basic basic = (Basic) src;
      if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "ActorDefinition")) {
        return ActorDefinition30_50.convertActorDefinition((org.hl7.fhir.dstu3.model.Basic) src);
      } else if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "Requirements")) {
        return Requirements30_50.convertRequirements((org.hl7.fhir.dstu3.model.Basic) src);
      } else if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "TestPlan")) {
        return TestPlan30_50.convertTestPlan((org.hl7.fhir.dstu3.model.Basic) src);
      } else {
        return Basic30_50.convertBasic((org.hl7.fhir.dstu3.model.Basic) src);
      }
    }
    if (src instanceof org.hl7.fhir.dstu3.model.Binary)
      return Binary30_50.convertBinary((org.hl7.fhir.dstu3.model.Binary) src);
    if (src instanceof org.hl7.fhir.dstu3.model.BodySite)
      return BodySite30_50.convertBodySite((org.hl7.fhir.dstu3.model.BodySite) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Bundle)
      return Bundle30_50.convertBundle((org.hl7.fhir.dstu3.model.Bundle) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CapabilityStatement)
      return CapabilityStatement30_50.convertCapabilityStatement((org.hl7.fhir.dstu3.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CarePlan)
      return CarePlan30_50.convertCarePlan((org.hl7.fhir.dstu3.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CareTeam)
      return CareTeam30_50.convertCareTeam((org.hl7.fhir.dstu3.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ClinicalImpression)
      return ClinicalImpression30_50.convertClinicalImpression((org.hl7.fhir.dstu3.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeSystem)
      return CodeSystem30_50.convertCodeSystem((org.hl7.fhir.dstu3.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Communication)
      return Communication30_50.convertCommunication((org.hl7.fhir.dstu3.model.Communication) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CompartmentDefinition)
      return CompartmentDefinition30_50.convertCompartmentDefinition((org.hl7.fhir.dstu3.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Composition)
      return Composition30_50.convertComposition((org.hl7.fhir.dstu3.model.Composition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ConceptMap)
      return ConceptMap30_50.convertConceptMap((org.hl7.fhir.dstu3.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Condition)
      return Condition30_50.convertCondition((org.hl7.fhir.dstu3.model.Condition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Consent)
      return Consent30_50.convertConsent((org.hl7.fhir.dstu3.model.Consent) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DataElement)
      return DataElement30_50.convertDataElement((org.hl7.fhir.dstu3.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DetectedIssue)
      return DetectedIssue30_50.convertDetectedIssue((org.hl7.fhir.dstu3.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DeviceUseStatement)
      return DeviceUseStatement30_50.convertDeviceUseStatement((org.hl7.fhir.dstu3.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DiagnosticReport)
      return DiagnosticReport30_50.convertDiagnosticReport((org.hl7.fhir.dstu3.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DocumentReference)
      return DocumentReference30_50.convertDocumentReference((org.hl7.fhir.dstu3.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Encounter)
      return Encounter30_50.convertEncounter((org.hl7.fhir.dstu3.model.Encounter) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Endpoint)
      return Endpoint30_50.convertEndpoint((org.hl7.fhir.dstu3.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.dstu3.model.EpisodeOfCare)
      return EpisodeOfCare30_50.convertEpisodeOfCare((org.hl7.fhir.dstu3.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ExpansionProfile)
      return ExpansionProfile30_50.convertExpansionProfile((org.hl7.fhir.dstu3.model.ExpansionProfile) src);
    if (src instanceof org.hl7.fhir.dstu3.model.FamilyMemberHistory)
      return FamilyMemberHistory30_50.convertFamilyMemberHistory((org.hl7.fhir.dstu3.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Flag) return Flag30_50.convertFlag((org.hl7.fhir.dstu3.model.Flag) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Goal) return Goal30_50.convertGoal((org.hl7.fhir.dstu3.model.Goal) src);
    if (src instanceof org.hl7.fhir.dstu3.model.GraphDefinition)
      return GraphDefinition30_50.convertGraphDefinition((org.hl7.fhir.dstu3.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Group)
      return Group30_50.convertGroup((org.hl7.fhir.dstu3.model.Group) src);
    if (src instanceof org.hl7.fhir.dstu3.model.HealthcareService)
      return HealthcareService30_50.convertHealthcareService((org.hl7.fhir.dstu3.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImagingStudy)
      return ImagingStudy30_50.convertImagingStudy((org.hl7.fhir.dstu3.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Immunization)
      return Immunization30_50.convertImmunization((org.hl7.fhir.dstu3.model.Immunization) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImplementationGuide)
      return ImplementationGuide30_50.convertImplementationGuide((org.hl7.fhir.dstu3.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Library)
      return Library30_50.convertLibrary((org.hl7.fhir.dstu3.model.Library) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Linkage)
      return Linkage30_50.convertLinkage((org.hl7.fhir.dstu3.model.Linkage) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ListResource)
      return List30_50.convertList((org.hl7.fhir.dstu3.model.ListResource) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Location)
      return Location30_50.convertLocation((org.hl7.fhir.dstu3.model.Location) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Measure)
      return Measure30_50.convertMeasure((org.hl7.fhir.dstu3.model.Measure) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Media)
      return Media30_50.convertMedia((org.hl7.fhir.dstu3.model.Media) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Medication)
      return Medication30_50.convertMedication((org.hl7.fhir.dstu3.model.Medication) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationAdministration)
      return MedicationAdministration30_50.convertMedicationAdministration((org.hl7.fhir.dstu3.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationDispense)
      return MedicationDispense30_50.convertMedicationDispense((org.hl7.fhir.dstu3.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationRequest)
      return MedicationRequest30_50.convertMedicationRequest((org.hl7.fhir.dstu3.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationStatement)
      return MedicationStatement30_50.convertMedicationStatement((org.hl7.fhir.dstu3.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MessageDefinition)
      return MessageDefinition30_50.convertMessageDefinition((org.hl7.fhir.dstu3.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MessageHeader)
      return MessageHeader30_50.convertMessageHeader((org.hl7.fhir.dstu3.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.dstu3.model.NamingSystem)
      return NamingSystem30_50.convertNamingSystem((org.hl7.fhir.dstu3.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Observation)
      return Observation30_50.convertObservation((org.hl7.fhir.dstu3.model.Observation) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationDefinition)
      return OperationDefinition30_50.convertOperationDefinition((org.hl7.fhir.dstu3.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationOutcome)
      return OperationOutcome30_50.convertOperationOutcome((org.hl7.fhir.dstu3.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Organization)
      return Organization30_50.convertOrganization((org.hl7.fhir.dstu3.model.Organization) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Patient)
      return Patient30_50.convertPatient((org.hl7.fhir.dstu3.model.Patient) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PaymentNotice)
      return PaymentNotice30_50.convertPaymentNotice((org.hl7.fhir.dstu3.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Person)
      return Person30_50.convertPerson((org.hl7.fhir.dstu3.model.Person) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PlanDefinition)
      return PlanDefinition30_50.convertPlanDefinition((org.hl7.fhir.dstu3.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Practitioner)
      return Practitioner30_50.convertPractitioner((org.hl7.fhir.dstu3.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PractitionerRole)
      return PractitionerRole30_50.convertPractitionerRole((org.hl7.fhir.dstu3.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Provenance)
      return Provenance30_50.convertProvenance((org.hl7.fhir.dstu3.model.Provenance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Questionnaire)
      return Questionnaire30_50.convertQuestionnaire((org.hl7.fhir.dstu3.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu3.model.QuestionnaireResponse)
      return QuestionnaireResponse30_50.convertQuestionnaireResponse((org.hl7.fhir.dstu3.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RelatedPerson)
      return RelatedPerson30_50.convertRelatedPerson((org.hl7.fhir.dstu3.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RiskAssessment)
      return RiskAssessment30_50.convertRiskAssessment((org.hl7.fhir.dstu3.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Schedule)
      return Schedule30_50.convertSchedule((org.hl7.fhir.dstu3.model.Schedule) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SearchParameter)
      return SearchParameter30_50.convertSearchParameter((org.hl7.fhir.dstu3.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Slot) return Slot30_50.convertSlot((org.hl7.fhir.dstu3.model.Slot) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Specimen)
      return Specimen30_50.convertSpecimen((org.hl7.fhir.dstu3.model.Specimen) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StructureDefinition)
      return StructureDefinition30_50.convertStructureDefinition((org.hl7.fhir.dstu3.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StructureMap)
      return StructureMap30_50.convertStructureMap((org.hl7.fhir.dstu3.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Substance)
      return Substance30_50.convertSubstance((org.hl7.fhir.dstu3.model.Substance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SupplyDelivery)
      return SupplyDelivery30_50.convertSupplyDelivery((org.hl7.fhir.dstu3.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TestReport)
      return TestReport30_50.convertTestReport((org.hl7.fhir.dstu3.model.TestReport) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TestScript)
      return TestScript30_50.convertTestScript((org.hl7.fhir.dstu3.model.TestScript) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ValueSet)
      return ValueSet30_50.convertValueSet((org.hl7.fhir.dstu3.model.ValueSet) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R3 to R5");
    }
    else return null;
  }

  public org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.r5.model.Parameters) {
      if (((org.hl7.fhir.r5.model.Parameters) src).hasParameterValue("profile-url"))
        return ExpansionProfile30_50.convertExpansionProfile((org.hl7.fhir.r5.model.Parameters) src);
      else return Parameters30_50.convertParameters((org.hl7.fhir.r5.model.Parameters) src);
    }
    if (src instanceof org.hl7.fhir.r5.model.ActivityDefinition)
      return ActivityDefinition30_50.convertActivityDefinition((org.hl7.fhir.r5.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.ActorDefinition)
      return ActorDefinition30_50.convertActorDefinition((org.hl7.fhir.r5.model.ActorDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.AllergyIntolerance)
      return AllergyIntolerance30_50.convertAllergyIntolerance((org.hl7.fhir.r5.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r5.model.Appointment)
      return Appointment30_50.convertAppointment((org.hl7.fhir.r5.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r5.model.AppointmentResponse)
      return AppointmentResponse30_50.convertAppointmentResponse((org.hl7.fhir.r5.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.AuditEvent)
      return AuditEvent30_50.convertAuditEvent((org.hl7.fhir.r5.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r5.model.Basic)
      return Basic30_50.convertBasic((org.hl7.fhir.r5.model.Basic) src);
    if (src instanceof org.hl7.fhir.r5.model.Binary)
      return Binary30_50.convertBinary((org.hl7.fhir.r5.model.Binary) src);
    if (src instanceof org.hl7.fhir.r5.model.BodyStructure)
      return BodySite30_50.convertBodySite((org.hl7.fhir.r5.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r5.model.Bundle)
      return Bundle30_50.convertBundle((org.hl7.fhir.r5.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r5.model.CapabilityStatement)
      return CapabilityStatement30_50.convertCapabilityStatement((org.hl7.fhir.r5.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.CarePlan)
      return CarePlan30_50.convertCarePlan((org.hl7.fhir.r5.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r5.model.CareTeam)
      return CareTeam30_50.convertCareTeam((org.hl7.fhir.r5.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r5.model.ClinicalImpression)
      return ClinicalImpression30_50.convertClinicalImpression((org.hl7.fhir.r5.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeSystem)
      return CodeSystem30_50.convertCodeSystem((org.hl7.fhir.r5.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.Communication)
      return Communication30_50.convertCommunication((org.hl7.fhir.r5.model.Communication) src);
    if (src instanceof org.hl7.fhir.r5.model.CompartmentDefinition)
      return CompartmentDefinition30_50.convertCompartmentDefinition((org.hl7.fhir.r5.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Composition)
      return Composition30_50.convertComposition((org.hl7.fhir.r5.model.Composition) src);
    if (src instanceof org.hl7.fhir.r5.model.ConceptMap)
      return ConceptMap30_50.convertConceptMap((org.hl7.fhir.r5.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r5.model.Condition)
      return Condition30_50.convertCondition((org.hl7.fhir.r5.model.Condition) src);
    if (src instanceof org.hl7.fhir.r5.model.Consent)
      return Consent30_50.convertConsent((org.hl7.fhir.r5.model.Consent) src);
    if (src instanceof org.hl7.fhir.r5.model.DetectedIssue)
      return DetectedIssue30_50.convertDetectedIssue((org.hl7.fhir.r5.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceUsage)
      return DeviceUseStatement30_50.convertDeviceUseStatement((org.hl7.fhir.r5.model.DeviceUsage) src);
    if (src instanceof org.hl7.fhir.r5.model.DiagnosticReport)
      return DiagnosticReport30_50.convertDiagnosticReport((org.hl7.fhir.r5.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
      return DocumentReference30_50.convertDocumentReference((org.hl7.fhir.r5.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r5.model.Encounter)
      return Encounter30_50.convertEncounter((org.hl7.fhir.r5.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r5.model.Endpoint)
      return Endpoint30_50.convertEndpoint((org.hl7.fhir.r5.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r5.model.EpisodeOfCare)
      return EpisodeOfCare30_50.convertEpisodeOfCare((org.hl7.fhir.r5.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r5.model.FamilyMemberHistory)
      return FamilyMemberHistory30_50.convertFamilyMemberHistory((org.hl7.fhir.r5.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r5.model.Flag) return Flag30_50.convertFlag((org.hl7.fhir.r5.model.Flag) src);
    if (src instanceof org.hl7.fhir.r5.model.Goal) return Goal30_50.convertGoal((org.hl7.fhir.r5.model.Goal) src);
    if (src instanceof org.hl7.fhir.r5.model.GraphDefinition)
      return GraphDefinition30_50.convertGraphDefinition((org.hl7.fhir.r5.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Group) return Group30_50.convertGroup((org.hl7.fhir.r5.model.Group) src);
    if (src instanceof org.hl7.fhir.r5.model.HealthcareService)
      return HealthcareService30_50.convertHealthcareService((org.hl7.fhir.r5.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r5.model.ImagingStudy)
      return ImagingStudy30_50.convertImagingStudy((org.hl7.fhir.r5.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r5.model.Immunization)
      return Immunization30_50.convertImmunization((org.hl7.fhir.r5.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r5.model.ImplementationGuide)
      return ImplementationGuide30_50.convertImplementationGuide((org.hl7.fhir.r5.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r5.model.Library)
      return Library30_50.convertLibrary((org.hl7.fhir.r5.model.Library) src);
    if (src instanceof org.hl7.fhir.r5.model.Linkage)
      return Linkage30_50.convertLinkage((org.hl7.fhir.r5.model.Linkage) src);
    if (src instanceof org.hl7.fhir.r5.model.ListResource)
      return List30_50.convertList((org.hl7.fhir.r5.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r5.model.Location)
      return Location30_50.convertLocation((org.hl7.fhir.r5.model.Location) src);
    if (src instanceof org.hl7.fhir.r5.model.Measure)
      return Measure30_50.convertMeasure((org.hl7.fhir.r5.model.Measure) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
      return Media30_50.convertMedia((org.hl7.fhir.r5.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r5.model.Medication)
      return Medication30_50.convertMedication((org.hl7.fhir.r5.model.Medication) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationAdministration)
      return MedicationAdministration30_50.convertMedicationAdministration((org.hl7.fhir.r5.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationDispense)
      return MedicationDispense30_50.convertMedicationDispense((org.hl7.fhir.r5.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationRequest)
      return MedicationRequest30_50.convertMedicationRequest((org.hl7.fhir.r5.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationStatement)
      return MedicationStatement30_50.convertMedicationStatement((org.hl7.fhir.r5.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageDefinition)
      return MessageDefinition30_50.convertMessageDefinition((org.hl7.fhir.r5.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageHeader)
      return MessageHeader30_50.convertMessageHeader((org.hl7.fhir.r5.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r5.model.NamingSystem)
      return NamingSystem30_50.convertNamingSystem((org.hl7.fhir.r5.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.Observation)
      return Observation30_50.convertObservation((org.hl7.fhir.r5.model.Observation) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationDefinition)
      return OperationDefinition30_50.convertOperationDefinition((org.hl7.fhir.r5.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationOutcome)
      return OperationOutcome30_50.convertOperationOutcome((org.hl7.fhir.r5.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r5.model.Organization)
      return Organization30_50.convertOrganization((org.hl7.fhir.r5.model.Organization) src);
    if (src instanceof org.hl7.fhir.r5.model.Patient)
      return Patient30_50.convertPatient((org.hl7.fhir.r5.model.Patient) src);
    if (src instanceof org.hl7.fhir.r5.model.PaymentNotice)
      return PaymentNotice30_50.convertPaymentNotice((org.hl7.fhir.r5.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r5.model.Person)
      return Person30_50.convertPerson((org.hl7.fhir.r5.model.Person) src);
    if (src instanceof org.hl7.fhir.r5.model.PlanDefinition)
      return PlanDefinition30_50.convertPlanDefinition((org.hl7.fhir.r5.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Practitioner)
      return Practitioner30_50.convertPractitioner((org.hl7.fhir.r5.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r5.model.PractitionerRole)
      return PractitionerRole30_50.convertPractitionerRole((org.hl7.fhir.r5.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r5.model.Provenance)
      return Provenance30_50.convertProvenance((org.hl7.fhir.r5.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r5.model.Questionnaire)
      return Questionnaire30_50.convertQuestionnaire((org.hl7.fhir.r5.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r5.model.QuestionnaireResponse)
      return QuestionnaireResponse30_50.convertQuestionnaireResponse((org.hl7.fhir.r5.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.RelatedPerson)
      return RelatedPerson30_50.convertRelatedPerson((org.hl7.fhir.r5.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r5.model.Requirements)
      return Requirements30_50.convertRequirements((org.hl7.fhir.r5.model.Requirements) src);
    if (src instanceof org.hl7.fhir.r5.model.RiskAssessment)
      return RiskAssessment30_50.convertRiskAssessment((org.hl7.fhir.r5.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r5.model.Schedule)
      return Schedule30_50.convertSchedule((org.hl7.fhir.r5.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r5.model.SearchParameter)
      return SearchParameter30_50.convertSearchParameter((org.hl7.fhir.r5.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r5.model.Slot) return Slot30_50.convertSlot((org.hl7.fhir.r5.model.Slot) src);
    if (src instanceof org.hl7.fhir.r5.model.Specimen)
      return Specimen30_50.convertSpecimen((org.hl7.fhir.r5.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureDefinition)
      return StructureDefinition30_50.convertStructureDefinition((org.hl7.fhir.r5.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureMap)
      return StructureMap30_50.convertStructureMap((org.hl7.fhir.r5.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r5.model.Substance)
      return Substance30_50.convertSubstance((org.hl7.fhir.r5.model.Substance) src);
    if (src instanceof org.hl7.fhir.r5.model.SupplyDelivery)
      return SupplyDelivery30_50.convertSupplyDelivery((org.hl7.fhir.r5.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.r5.model.TestPlan)
      return TestPlan30_50.convertTestPlan((org.hl7.fhir.r5.model.TestPlan) src);
    if (src instanceof org.hl7.fhir.r5.model.TestReport)
      return TestReport30_50.convertTestReport((org.hl7.fhir.r5.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r5.model.TestScript)
      return TestScript30_50.convertTestScript((org.hl7.fhir.r5.model.TestScript) src);
    if (src instanceof org.hl7.fhir.r5.model.ValueSet)
      return ValueSet30_50.convertValueSet((org.hl7.fhir.r5.model.ValueSet) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R5 to R3");
    } else {
      return null;
    }
  }

  public void copyDomainResource(org.hl7.fhir.dstu3.model.DomainResource src,
                                 org.hl7.fhir.r5.model.DomainResource tgt, String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative30_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext30_50.INSTANCE.path(), extension)) {
        org.hl7.fhir.r5.model.Extension convertExtension = new org.hl7.fhir.r5.model.Extension();
        advisor.handleExtension(ConversionContext30_50.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext30_50.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension30_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext30_50.INSTANCE.path(), extension))
      .map(Extension30_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src,
                                 org.hl7.fhir.dstu3.model.DomainResource tgt, String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative30_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext30_50.INSTANCE.path(), extension)) {
        org.hl7.fhir.dstu3.model.Extension convertExtension = new org.hl7.fhir.dstu3.model.Extension();
        advisor.handleExtension(ConversionContext30_50.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext30_50.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension30_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext30_50.INSTANCE.path(), extension))
      .map(Extension30_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }
}
