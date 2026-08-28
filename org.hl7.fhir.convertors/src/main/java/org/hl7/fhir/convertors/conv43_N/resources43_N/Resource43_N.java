package org.hl7.fhir.convertors.conv43_N.resources43_N;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_43_N;
import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Id43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Extension43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Meta43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Narrative43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Basic;

public class Resource43_N {

  public final BaseAdvisor_43_N advisor;

  public Resource43_N(BaseAdvisor_43_N advisor) {
    this.advisor = advisor;
  }

  public void copyResource(org.hl7.fhir.r4b.model.Resource src, org.hl7.fhir.model.core.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id43_N.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta43_N.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRulesElement(Uri43_N.convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
  }

  public void copyResource(org.hl7.fhir.model.core.Resource src, org.hl7.fhir.r4b.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id43_N.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta43_N.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRulesElement(Uri43_N.convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_N.convertCode(src.getLanguageElement()));
  }

  public org.hl7.fhir.model.core.Resource convertResource(org.hl7.fhir.r4b.model.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.r4b.model.Parameters)
      return Parameters43_N.convertParameters((org.hl7.fhir.r4b.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r4b.model.Account)
      return Account43_N.convertAccount((org.hl7.fhir.r4b.model.Account) src);
    if (src instanceof org.hl7.fhir.r4b.model.ActivityDefinition)
      return ActivityDefinition43_N.convertActivityDefinition((org.hl7.fhir.r4b.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.AllergyIntolerance)
      return AllergyIntolerance43_N.convertAllergyIntolerance((org.hl7.fhir.r4b.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r4b.model.Appointment)
      return Appointment43_N.convertAppointment((org.hl7.fhir.r4b.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r4b.model.AppointmentResponse)
      return AppointmentResponse43_N.convertAppointmentResponse((org.hl7.fhir.r4b.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r4b.model.AuditEvent)
      return AuditEvent43_N.convertAuditEvent((org.hl7.fhir.r4b.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r4b.model.Basic) {
      org.hl7.fhir.r4b.model.Basic basic = (Basic) src;
      if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "ActorDefinition")) {
        return ActorDefinition43_N.convertActorDefinition((org.hl7.fhir.r4b.model.Basic) src);
      } else if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "Requirements")) {
        return Requirements43_N.convertRequirements((org.hl7.fhir.r4b.model.Basic) src);
      } else if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "SubscriptionTopic")) {
        return SubscriptionTopic43_N.convertSubscriptionTopic((org.hl7.fhir.r4b.model.Basic) src);
      } else if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "TestPlan")) {
        return TestPlan43_N.convertTestPlan((org.hl7.fhir.r4b.model.Basic) src);
      } else {
        return Basic43_N.convertBasic((org.hl7.fhir.r4b.model.Basic) src);
      }
    }
    if (src instanceof org.hl7.fhir.r4b.model.Binary)
      return Binary43_N.convertBinary((org.hl7.fhir.r4b.model.Binary) src);
    if (src instanceof org.hl7.fhir.r4b.model.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct43_N.convertBiologicallyDerivedProduct((org.hl7.fhir.r4b.model.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.r4b.model.BodyStructure)
      return BodyStructure43_N.convertBodyStructure((org.hl7.fhir.r4b.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r4b.model.Bundle)
      return Bundle43_N.convertBundle((org.hl7.fhir.r4b.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r4b.model.CapabilityStatement)
      return CapabilityStatement43_N.convertCapabilityStatement((org.hl7.fhir.r4b.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r4b.model.CarePlan)
      return CarePlan43_N.convertCarePlan((org.hl7.fhir.r4b.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r4b.model.CareTeam)
      return CareTeam43_N.convertCareTeam((org.hl7.fhir.r4b.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r4b.model.Claim) return Claim43_N.convertClaim((org.hl7.fhir.r4b.model.Claim) src);
    if (src instanceof org.hl7.fhir.r4b.model.ClaimResponse)
      return ClaimResponse43_N.convertClaimResponse((org.hl7.fhir.r4b.model.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.r4b.model.CodeSystem)
      return CodeSystem43_N.convertCodeSystem((org.hl7.fhir.r4b.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r4b.model.Communication)
      return Communication43_N.convertCommunication((org.hl7.fhir.r4b.model.Communication) src);
    if (src instanceof org.hl7.fhir.r4b.model.CommunicationRequest)
      return CommunicationRequest43_N.convertCommunicationRequest((org.hl7.fhir.r4b.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.CompartmentDefinition)
      return CompartmentDefinition43_N.convertCompartmentDefinition((org.hl7.fhir.r4b.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.Composition)
      return Composition43_N.convertComposition((org.hl7.fhir.r4b.model.Composition) src);
    if (src instanceof org.hl7.fhir.r4b.model.ConceptMap)
      return ConceptMap43_N.convertConceptMap((org.hl7.fhir.r4b.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r4b.model.Condition)
      return Condition43_N.convertCondition((org.hl7.fhir.r4b.model.Condition) src);
    if (src instanceof org.hl7.fhir.r4b.model.Consent)
      return Consent43_N.convertConsent((org.hl7.fhir.r4b.model.Consent) src);
    if (src instanceof org.hl7.fhir.r4b.model.Coverage)
      return Coverage43_N.convertCoverage((org.hl7.fhir.r4b.model.Coverage) src);
    if (src instanceof org.hl7.fhir.r4b.model.CoverageEligibilityRequest)
      return CoverageEligibilityRequest43_N.convertCoverageEligibilityRequest((org.hl7.fhir.r4b.model.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.DetectedIssue)
      return DetectedIssue43_N.convertDetectedIssue((org.hl7.fhir.r4b.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r4b.model.Device)
      return Device43_N.convertDevice((org.hl7.fhir.r4b.model.Device) src);
    if (src instanceof org.hl7.fhir.r4b.model.DeviceMetric)
      return DeviceMetric43_N.convertDeviceMetric((org.hl7.fhir.r4b.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.r4b.model.DeviceRequest)
      return DeviceRequest43_N.convertDeviceRequest((org.hl7.fhir.r4b.model.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.DiagnosticReport)
      return DiagnosticReport43_N.convertDiagnosticReport((org.hl7.fhir.r4b.model.DiagnosticReport) src);
//    if (src instanceof org.hl7.fhir.r4b.model.DocumentManifest)
//      return DocumentManifest43_N.convertDocumentManifest((org.hl7.fhir.r4b.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.r4b.model.DocumentReference)
      return DocumentReference43_N.convertDocumentReference((org.hl7.fhir.r4b.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r4b.model.Encounter)
      return Encounter43_N.convertEncounter((org.hl7.fhir.r4b.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r4b.model.Endpoint)
      return Endpoint43_N.convertEndpoint((org.hl7.fhir.r4b.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r4b.model.EpisodeOfCare)
      return EpisodeOfCare43_N.convertEpisodeOfCare((org.hl7.fhir.r4b.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r4b.model.EventDefinition)
      return EventDefinition43_N.convertEventDefinition((org.hl7.fhir.r4b.model.EventDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.ExampleScenario)
      return ExampleScenario43_N.convertExampleScenario((org.hl7.fhir.r4b.model.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.r4b.model.ExplanationOfBenefit)
      return ExplanationOfBenefit43_N.convertExplanationOfBenefit((org.hl7.fhir.r4b.model.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.r4b.model.FamilyMemberHistory)
      return FamilyMemberHistory43_N.convertFamilyMemberHistory((org.hl7.fhir.r4b.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r4b.model.Flag) return Flag43_N.convertFlag((org.hl7.fhir.r4b.model.Flag) src);
    if (src instanceof org.hl7.fhir.r4b.model.Goal) return Goal43_N.convertGoal((org.hl7.fhir.r4b.model.Goal) src);
    if (src instanceof org.hl7.fhir.r4b.model.Group) return Group43_N.convertGroup((org.hl7.fhir.r4b.model.Group) src);
    if (src instanceof org.hl7.fhir.r4b.model.GuidanceResponse)
      return GuidanceResponse43_N.convertGuidanceResponse((org.hl7.fhir.r4b.model.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.r4b.model.HealthcareService)
      return HealthcareService43_N.convertHealthcareService((org.hl7.fhir.r4b.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r4b.model.ImagingStudy)
      return ImagingStudy43_N.convertImagingStudy((org.hl7.fhir.r4b.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r4b.model.Immunization)
      return Immunization43_N.convertImmunization((org.hl7.fhir.r4b.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r4b.model.ImplementationGuide)
      return ImplementationGuide43_N.convertImplementationGuide((org.hl7.fhir.r4b.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r4b.model.Library)
      return Library43_N.convertLibrary((org.hl7.fhir.r4b.model.Library) src);
    if (src instanceof org.hl7.fhir.r4b.model.ListResource)
      return ListResource43_N.convertListResource((org.hl7.fhir.r4b.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r4b.model.Location)
      return Location43_N.convertLocation((org.hl7.fhir.r4b.model.Location) src);
    if (src instanceof org.hl7.fhir.r4b.model.Measure)
      return Measure43_N.convertMeasure((org.hl7.fhir.r4b.model.Measure) src);
    if (src instanceof org.hl7.fhir.r4b.model.MeasureReport)
      return MeasureReport43_N.convertMeasureReport((org.hl7.fhir.r4b.model.MeasureReport) src);
    if (src instanceof org.hl7.fhir.r4b.model.Media) return Media43_N.convertMedia((org.hl7.fhir.r4b.model.Media) src);
    if (src instanceof org.hl7.fhir.r4b.model.Medication)
      return Medication43_N.convertMedication((org.hl7.fhir.r4b.model.Medication) src);
    if (src instanceof org.hl7.fhir.r4b.model.MedicationAdministration)
      return MedicationAdministration43_N.convertMedicationAdministration((org.hl7.fhir.r4b.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r4b.model.MedicationDispense)
      return MedicationDispense43_N.convertMedicationDispense((org.hl7.fhir.r4b.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r4b.model.MedicationRequest)
      return MedicationRequest43_N.convertMedicationRequest((org.hl7.fhir.r4b.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.MedicationStatement)
      return MedicationStatement43_N.convertMedicationStatement((org.hl7.fhir.r4b.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r4b.model.MessageDefinition)
      return MessageDefinition43_N.convertMessageDefinition((org.hl7.fhir.r4b.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.MessageHeader)
      return MessageHeader43_N.convertMessageHeader((org.hl7.fhir.r4b.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r4b.model.NamingSystem)
      return NamingSystem43_N.convertNamingSystem((org.hl7.fhir.r4b.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r4b.model.NutritionOrder)
      return NutritionOrder43_N.convertNutritionOrder((org.hl7.fhir.r4b.model.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.r4b.model.Observation)
      return Observation43_N.convertObservation((org.hl7.fhir.r4b.model.Observation) src);
    if (src instanceof org.hl7.fhir.r4b.model.ObservationDefinition)
      return ObservationDefinition43_N.convertObservationDefinition((org.hl7.fhir.r4b.model.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.OperationDefinition)
      return OperationDefinition43_N.convertOperationDefinition((org.hl7.fhir.r4b.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.OperationOutcome)
      return OperationOutcome43_N.convertOperationOutcome((org.hl7.fhir.r4b.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r4b.model.Organization)
      return Organization43_N.convertOrganization((org.hl7.fhir.r4b.model.Organization) src);
    if (src instanceof org.hl7.fhir.r4b.model.OrganizationAffiliation)
      return OrganizationAffiliation43_N.convertOrganizationAffiliation((org.hl7.fhir.r4b.model.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.r4b.model.Patient)
      return Patient43_N.convertPatient((org.hl7.fhir.r4b.model.Patient) src);
    if (src instanceof org.hl7.fhir.r4b.model.PaymentNotice)
      return PaymentNotice43_N.convertPaymentNotice((org.hl7.fhir.r4b.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r4b.model.Person)
      return Person43_N.convertPerson((org.hl7.fhir.r4b.model.Person) src);
    if (src instanceof org.hl7.fhir.r4b.model.PlanDefinition)
      return PlanDefinition43_N.convertPlanDefinition((org.hl7.fhir.r4b.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.Practitioner)
      return Practitioner43_N.convertPractitioner((org.hl7.fhir.r4b.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r4b.model.PractitionerRole)
      return PractitionerRole43_N.convertPractitionerRole((org.hl7.fhir.r4b.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r4b.model.Procedure)
      return Procedure43_N.convertProcedure((org.hl7.fhir.r4b.model.Procedure) src);
    if (src instanceof org.hl7.fhir.r4b.model.Provenance)
      return Provenance43_N.convertProvenance((org.hl7.fhir.r4b.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r4b.model.Questionnaire)
      return Questionnaire43_N.convertQuestionnaire((org.hl7.fhir.r4b.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r4b.model.QuestionnaireResponse)
      return QuestionnaireResponse43_N.convertQuestionnaireResponse((org.hl7.fhir.r4b.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r4b.model.RelatedPerson)
      return RelatedPerson43_N.convertRelatedPerson((org.hl7.fhir.r4b.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r4b.model.RiskAssessment)
      return RiskAssessment43_N.convertRiskAssessment((org.hl7.fhir.r4b.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r4b.model.Schedule)
      return Schedule43_N.convertSchedule((org.hl7.fhir.r4b.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r4b.model.SearchParameter)
      return SearchParameter43_N.convertSearchParameter((org.hl7.fhir.r4b.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r4b.model.ServiceRequest)
      return ServiceRequest43_N.convertServiceRequest((org.hl7.fhir.r4b.model.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.Slot) return Slot43_N.convertSlot((org.hl7.fhir.r4b.model.Slot) src);
    if (src instanceof org.hl7.fhir.r4b.model.Specimen)
      return Specimen43_N.convertSpecimen((org.hl7.fhir.r4b.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r4b.model.SpecimenDefinition)
      return SpecimenDefinition43_N.convertSpecimenDefinition((org.hl7.fhir.r4b.model.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.StructureDefinition)
      return StructureDefinition43_N.convertStructureDefinition((org.hl7.fhir.r4b.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.Substance)
      return Substance43_N.convertSubstance((org.hl7.fhir.r4b.model.Substance) src);
    if (src instanceof org.hl7.fhir.r4b.model.Task) return Task43_N.convertTask((org.hl7.fhir.r4b.model.Task) src);
    if (src instanceof org.hl7.fhir.r4b.model.TerminologyCapabilities)
      return TerminologyCapabilities43_N.convertTerminologyCapabilities((org.hl7.fhir.r4b.model.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.r4b.model.ValueSet)
      return ValueSet43_N.convertValueSet((org.hl7.fhir.r4b.model.ValueSet) src);
    if (src instanceof org.hl7.fhir.r4b.model.VisionPrescription)
      return VisionPrescription43_N.convertVisionPrescription((org.hl7.fhir.r4b.model.VisionPrescription) src);
    if (src instanceof org.hl7.fhir.r4b.model.Subscription)
      return Subscription43_N.convertSubscription((org.hl7.fhir.r4b.model.Subscription) src);

    if (src instanceof org.hl7.fhir.r4b.model.GraphDefinition)
      return GraphDefinition43_N.convertGraphDefinition((org.hl7.fhir.r4b.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.StructureMap)
      return StructureMap43_N.convertStructureMap((org.hl7.fhir.r4b.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r4b.model.TestReport)
      return TestReport43_N.convertTestReport((org.hl7.fhir.r4b.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r4b.model.TestScript)
      return TestScript43_N.convertTestScript((org.hl7.fhir.r4b.model.TestScript) src);

    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R4 to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.r4b.model.Resource convertResource(org.hl7.fhir.model.core.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.model.core.Parameters)
      return Parameters43_N.convertParameters((org.hl7.fhir.model.core.Parameters) src);
    if (src instanceof org.hl7.fhir.model.core.Account)
      return Account43_N.convertAccount((org.hl7.fhir.model.core.Account) src);
    if (src instanceof org.hl7.fhir.model.core.ActivityDefinition)
      return ActivityDefinition43_N.convertActivityDefinition((org.hl7.fhir.model.core.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.AllergyIntolerance)
      return AllergyIntolerance43_N.convertAllergyIntolerance((org.hl7.fhir.model.core.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.model.core.ActorDefinition)
      return ActorDefinition43_N.convertActorDefinition((org.hl7.fhir.model.core.ActorDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.Appointment)
      return Appointment43_N.convertAppointment((org.hl7.fhir.model.core.Appointment) src);
    if (src instanceof org.hl7.fhir.model.core.AppointmentResponse)
      return AppointmentResponse43_N.convertAppointmentResponse((org.hl7.fhir.model.core.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.model.core.AuditEvent)
      return AuditEvent43_N.convertAuditEvent((org.hl7.fhir.model.core.AuditEvent) src);
    if (src instanceof org.hl7.fhir.model.core.Basic) return Basic43_N.convertBasic((org.hl7.fhir.model.core.Basic) src);
    if (src instanceof org.hl7.fhir.model.core.Binary)
      return Binary43_N.convertBinary((org.hl7.fhir.model.core.Binary) src);
    if (src instanceof org.hl7.fhir.model.core.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct43_N.convertBiologicallyDerivedProduct((org.hl7.fhir.model.core.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.model.core.BodyStructure)
      return BodyStructure43_N.convertBodyStructure((org.hl7.fhir.model.core.BodyStructure) src);
    if (src instanceof org.hl7.fhir.model.core.Bundle)
      return Bundle43_N.convertBundle((org.hl7.fhir.model.core.Bundle) src);
    if (src instanceof org.hl7.fhir.model.core.CapabilityStatement)
      return CapabilityStatement43_N.convertCapabilityStatement((org.hl7.fhir.model.core.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.model.core.CarePlan)
      return CarePlan43_N.convertCarePlan((org.hl7.fhir.model.core.CarePlan) src);
    if (src instanceof org.hl7.fhir.model.core.CareTeam)
      return CareTeam43_N.convertCareTeam((org.hl7.fhir.model.core.CareTeam) src);
    if (src instanceof org.hl7.fhir.model.core.Claim) return Claim43_N.convertClaim((org.hl7.fhir.model.core.Claim) src);
    if (src instanceof org.hl7.fhir.model.core.ClaimResponse)
      return ClaimResponse43_N.convertClaimResponse((org.hl7.fhir.model.core.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.model.core.CodeSystem)
      return CodeSystem43_N.convertCodeSystem((org.hl7.fhir.model.core.CodeSystem) src);
    if (src instanceof org.hl7.fhir.model.core.Communication)
      return Communication43_N.convertCommunication((org.hl7.fhir.model.core.Communication) src);
    if (src instanceof org.hl7.fhir.model.core.CommunicationRequest)
      return CommunicationRequest43_N.convertCommunicationRequest((org.hl7.fhir.model.core.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.model.core.CompartmentDefinition)
      return CompartmentDefinition43_N.convertCompartmentDefinition((org.hl7.fhir.model.core.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.Composition)
      return Composition43_N.convertComposition((org.hl7.fhir.model.core.Composition) src);
    if (src instanceof org.hl7.fhir.model.core.ConceptMap)
      return ConceptMap43_N.convertConceptMap((org.hl7.fhir.model.core.ConceptMap) src);
    if (src instanceof org.hl7.fhir.model.core.Condition)
      return Condition43_N.convertCondition((org.hl7.fhir.model.core.Condition) src);
    if (src instanceof org.hl7.fhir.model.core.Consent)
      return Consent43_N.convertConsent((org.hl7.fhir.model.core.Consent) src);
    if (src instanceof org.hl7.fhir.model.core.Coverage)
      return Coverage43_N.convertCoverage((org.hl7.fhir.model.core.Coverage) src);
    if (src instanceof org.hl7.fhir.model.core.CoverageEligibilityRequest)
      return CoverageEligibilityRequest43_N.convertCoverageEligibilityRequest((org.hl7.fhir.model.core.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.model.core.DetectedIssue)
      return DetectedIssue43_N.convertDetectedIssue((org.hl7.fhir.model.core.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.model.core.Device)
      return Device43_N.convertDevice((org.hl7.fhir.model.core.Device) src);
    if (src instanceof org.hl7.fhir.model.core.DeviceMetric)
      return DeviceMetric43_N.convertDeviceMetric((org.hl7.fhir.model.core.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.model.core.DeviceRequest)
      return DeviceRequest43_N.convertDeviceRequest((org.hl7.fhir.model.core.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.model.core.DiagnosticReport)
      return DiagnosticReport43_N.convertDiagnosticReport((org.hl7.fhir.model.core.DiagnosticReport) src);
//    if (src instanceof org.hl7.fhir.model.core.DocumentManifest)
//      return DocumentManifest43_N.convertDocumentManifest((org.hl7.fhir.model.core.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.model.core.DocumentReference)
      return DocumentReference43_N.convertDocumentReference((org.hl7.fhir.model.core.DocumentReference) src);
    if (src instanceof org.hl7.fhir.model.core.Encounter)
      return Encounter43_N.convertEncounter((org.hl7.fhir.model.core.Encounter) src);
    if (src instanceof org.hl7.fhir.model.core.Endpoint)
      return Endpoint43_N.convertEndpoint((org.hl7.fhir.model.core.Endpoint) src);
    if (src instanceof org.hl7.fhir.model.core.EpisodeOfCare)
      return EpisodeOfCare43_N.convertEpisodeOfCare((org.hl7.fhir.model.core.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.model.core.EventDefinition)
      return EventDefinition43_N.convertEventDefinition((org.hl7.fhir.model.core.EventDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.ExampleScenario)
      return ExampleScenario43_N.convertExampleScenario((org.hl7.fhir.model.core.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.model.core.ExplanationOfBenefit)
      return ExplanationOfBenefit43_N.convertExplanationOfBenefit((org.hl7.fhir.model.core.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.model.core.FamilyMemberHistory)
      return FamilyMemberHistory43_N.convertFamilyMemberHistory((org.hl7.fhir.model.core.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.model.core.Flag) return Flag43_N.convertFlag((org.hl7.fhir.model.core.Flag) src);
    if (src instanceof org.hl7.fhir.model.core.Goal) return Goal43_N.convertGoal((org.hl7.fhir.model.core.Goal) src);
    if (src instanceof org.hl7.fhir.model.core.Group) return Group43_N.convertGroup((org.hl7.fhir.model.core.Group) src);
    if (src instanceof org.hl7.fhir.model.core.GuidanceResponse)
      return GuidanceResponse43_N.convertGuidanceResponse((org.hl7.fhir.model.core.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.model.core.HealthcareService)
      return HealthcareService43_N.convertHealthcareService((org.hl7.fhir.model.core.HealthcareService) src);
    if (src instanceof org.hl7.fhir.model.core.ImagingStudy)
      return ImagingStudy43_N.convertImagingStudy((org.hl7.fhir.model.core.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.model.core.Immunization)
      return Immunization43_N.convertImmunization((org.hl7.fhir.model.core.Immunization) src);
    if (src instanceof org.hl7.fhir.model.core.ImplementationGuide)
      return ImplementationGuide43_N.convertImplementationGuide((org.hl7.fhir.model.core.ImplementationGuide) src, advisor.produceIllegalParameters());
    if (src instanceof org.hl7.fhir.model.core.Library)
      return Library43_N.convertLibrary((org.hl7.fhir.model.core.Library) src);
    if (src instanceof org.hl7.fhir.model.core.ListResource)
      return ListResource43_N.convertListResource((org.hl7.fhir.model.core.ListResource) src);
    if (src instanceof org.hl7.fhir.model.core.Location)
      return Location43_N.convertLocation((org.hl7.fhir.model.core.Location) src);
    if (src instanceof org.hl7.fhir.model.core.Measure)
      return Measure43_N.convertMeasure((org.hl7.fhir.model.core.Measure) src);
    if (src instanceof org.hl7.fhir.model.core.MeasureReport)
      return MeasureReport43_N.convertMeasureReport((org.hl7.fhir.model.core.MeasureReport) src);
    if (src instanceof org.hl7.fhir.model.core.DocumentReference)
      return Media43_N.convertMedia((org.hl7.fhir.model.core.DocumentReference) src);
    if (src instanceof org.hl7.fhir.model.core.Medication)
      return Medication43_N.convertMedication((org.hl7.fhir.model.core.Medication) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationAdministration)
      return MedicationAdministration43_N.convertMedicationAdministration((org.hl7.fhir.model.core.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationDispense)
      return MedicationDispense43_N.convertMedicationDispense((org.hl7.fhir.model.core.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationRequest)
      return MedicationRequest43_N.convertMedicationRequest((org.hl7.fhir.model.core.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationStatement)
      return MedicationStatement43_N.convertMedicationStatement((org.hl7.fhir.model.core.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.model.core.MessageDefinition)
      return MessageDefinition43_N.convertMessageDefinition((org.hl7.fhir.model.core.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.MessageHeader)
      return MessageHeader43_N.convertMessageHeader((org.hl7.fhir.model.core.MessageHeader) src);
    if (src instanceof org.hl7.fhir.model.core.NamingSystem)
      return NamingSystem43_N.convertNamingSystem((org.hl7.fhir.model.core.NamingSystem) src);
    if (src instanceof org.hl7.fhir.model.core.NutritionOrder)
      return NutritionOrder43_N.convertNutritionOrder((org.hl7.fhir.model.core.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.model.core.Observation)
      return Observation43_N.convertObservation((org.hl7.fhir.model.core.Observation) src);
    if (src instanceof org.hl7.fhir.model.core.ObservationDefinition)
      return ObservationDefinition43_N.convertObservationDefinition((org.hl7.fhir.model.core.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.OperationDefinition)
      return OperationDefinition43_N.convertOperationDefinition((org.hl7.fhir.model.core.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.OperationOutcome)
      return OperationOutcome43_N.convertOperationOutcome((org.hl7.fhir.model.core.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.model.core.Organization)
      return Organization43_N.convertOrganization((org.hl7.fhir.model.core.Organization) src);
    if (src instanceof org.hl7.fhir.model.core.OrganizationAffiliation)
      return OrganizationAffiliation43_N.convertOrganizationAffiliation((org.hl7.fhir.model.core.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.model.core.Patient)
      return Patient43_N.convertPatient((org.hl7.fhir.model.core.Patient) src);
    if (src instanceof org.hl7.fhir.model.core.PaymentNotice)
      return PaymentNotice43_N.convertPaymentNotice((org.hl7.fhir.model.core.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.model.core.Person)
      return Person43_N.convertPerson((org.hl7.fhir.model.core.Person) src);
    if (src instanceof org.hl7.fhir.model.core.PlanDefinition)
      return PlanDefinition43_N.convertPlanDefinition((org.hl7.fhir.model.core.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.Practitioner)
      return Practitioner43_N.convertPractitioner((org.hl7.fhir.model.core.Practitioner) src);
    if (src instanceof org.hl7.fhir.model.core.PractitionerRole)
      return PractitionerRole43_N.convertPractitionerRole((org.hl7.fhir.model.core.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.model.core.Procedure)
      return Procedure43_N.convertProcedure((org.hl7.fhir.model.core.Procedure) src);
    if (src instanceof org.hl7.fhir.model.core.Provenance)
      return Provenance43_N.convertProvenance((org.hl7.fhir.model.core.Provenance) src);
    if (src instanceof org.hl7.fhir.model.core.Questionnaire)
      return Questionnaire43_N.convertQuestionnaire((org.hl7.fhir.model.core.Questionnaire) src);
    if (src instanceof org.hl7.fhir.model.core.QuestionnaireResponse)
      return QuestionnaireResponse43_N.convertQuestionnaireResponse((org.hl7.fhir.model.core.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.model.core.RelatedPerson)
      return RelatedPerson43_N.convertRelatedPerson((org.hl7.fhir.model.core.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.model.core.Requirements)
      return Requirements43_N.convertRequirements((org.hl7.fhir.model.core.Requirements) src);
    if (src instanceof org.hl7.fhir.model.core.RiskAssessment)
      return RiskAssessment43_N.convertRiskAssessment((org.hl7.fhir.model.core.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.model.core.Schedule)
      return Schedule43_N.convertSchedule((org.hl7.fhir.model.core.Schedule) src);
    if (src instanceof org.hl7.fhir.model.core.SearchParameter)
      return SearchParameter43_N.convertSearchParameter((org.hl7.fhir.model.core.SearchParameter) src);
    if (src instanceof org.hl7.fhir.model.core.ServiceRequest)
      return ServiceRequest43_N.convertServiceRequest((org.hl7.fhir.model.core.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.model.core.Slot) return Slot43_N.convertSlot((org.hl7.fhir.model.core.Slot) src);
    if (src instanceof org.hl7.fhir.model.core.Specimen)
      return Specimen43_N.convertSpecimen((org.hl7.fhir.model.core.Specimen) src);
    if (src instanceof org.hl7.fhir.model.core.SpecimenDefinition)
      return SpecimenDefinition43_N.convertSpecimenDefinition((org.hl7.fhir.model.core.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.StructureDefinition)
      return StructureDefinition43_N.convertStructureDefinition((org.hl7.fhir.model.core.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.SubscriptionTopic)
      return SubscriptionTopic43_N.convertSubscriptionTopic((org.hl7.fhir.model.core.SubscriptionTopic) src);
    if (src instanceof org.hl7.fhir.model.core.Substance)
      return Substance43_N.convertSubstance((org.hl7.fhir.model.core.Substance) src);
    if (src instanceof org.hl7.fhir.model.core.Task) return Task43_N.convertTask((org.hl7.fhir.model.core.Task) src);
    if (src instanceof org.hl7.fhir.model.core.TerminologyCapabilities)
      return TerminologyCapabilities43_N.convertTerminologyCapabilities((org.hl7.fhir.model.core.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.model.core.ValueSet)
      return ValueSet43_N.convertValueSet((org.hl7.fhir.model.core.ValueSet) src);
    if (src instanceof org.hl7.fhir.model.core.VisionPrescription)
      return VisionPrescription43_N.convertVisionPrescription((org.hl7.fhir.model.core.VisionPrescription) src);
    if (src instanceof org.hl7.fhir.model.core.Subscription)
      return Subscription43_N.convertSubscription((org.hl7.fhir.model.core.Subscription) src);

    if (src instanceof org.hl7.fhir.model.api.GraphDefinition)
      return GraphDefinition43_N.convertGraphDefinition((org.hl7.fhir.model.api.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.model.fml.StructureMap)
      return StructureMap43_N.convertStructureMap((org.hl7.fhir.model.fml.StructureMap) src);
    if (src instanceof org.hl7.fhir.model.testing.TestPlan)
      return TestPlan43_N.convertTestPlan((org.hl7.fhir.model.testing.TestPlan) src);
    if (src instanceof org.hl7.fhir.model.testing.TestReport)
      return TestReport43_N.convertTestReport((org.hl7.fhir.model.testing.TestReport) src);
    if (src instanceof org.hl7.fhir.model.testing.TestScript)
      return TestScript43_N.convertTestScript((org.hl7.fhir.model.testing.TestScript) src);

    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R5 to R4");
    } else {
      return null;
    }
  }

  public void copyDomainResource(org.hl7.fhir.r4b.model.DomainResource src, org.hl7.fhir.model.core.DomainResource tgt, String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative43_N.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext43_N.INSTANCE.path(), extension)) {
        org.hl7.fhir.model.core.Extension convertExtension = new org.hl7.fhir.model.core.Extension();
        advisor.handleExtension(ConversionContext43_N.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext43_N.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension43_N.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext43_N.INSTANCE.path(), extension))
      .map(Extension43_N::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public void copyDomainResource(org.hl7.fhir.model.core.DomainResource src, org.hl7.fhir.r4b.model.DomainResource tgt,  String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative43_N.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext43_N.INSTANCE.path(), extension)) {
        org.hl7.fhir.r4b.model.Extension convertExtension = new org.hl7.fhir.r4b.model.Extension();
        advisor.handleExtension(ConversionContext43_N.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext43_N.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension43_N.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext43_N.INSTANCE.path(), extension))
      .map(Extension43_N::convertExtension)
      .forEach(tgt::addModifierExtension);
  }
}
