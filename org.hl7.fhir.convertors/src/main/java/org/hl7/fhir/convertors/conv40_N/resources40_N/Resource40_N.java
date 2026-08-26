package org.hl7.fhir.convertors.conv40_N.resources40_N;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_N;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Id40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Extension40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Meta40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Narrative40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Basic;

public class Resource40_N {

  public final BaseAdvisor_40_N advisor;

  public Resource40_N(BaseAdvisor_40_N advisor) {
    this.advisor = advisor;
  }

  public void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.model.core.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id40_N.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta40_N.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRulesElement(Uri40_N.convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_N.convertCode(src.getLanguageElement()));
  }

  public void copyResource(org.hl7.fhir.model.core.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id40_N.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta40_N.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRulesElement(Uri40_N.convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_N.convertCode(src.getLanguageElement()));
  }

  public org.hl7.fhir.model.core.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.r4.model.Parameters)
      return Parameters40_N.convertParameters((org.hl7.fhir.r4.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r4.model.Account)
      return Account40_N.convertAccount((org.hl7.fhir.r4.model.Account) src);
    if (src instanceof org.hl7.fhir.r4.model.ActivityDefinition)
      return ActivityDefinition40_N.convertActivityDefinition((org.hl7.fhir.r4.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.AllergyIntolerance)
      return AllergyIntolerance40_N.convertAllergyIntolerance((org.hl7.fhir.r4.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r4.model.Appointment)
      return Appointment40_N.convertAppointment((org.hl7.fhir.r4.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r4.model.AppointmentResponse)
      return AppointmentResponse40_N.convertAppointmentResponse((org.hl7.fhir.r4.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.AuditEvent)
      return AuditEvent40_N.convertAuditEvent((org.hl7.fhir.r4.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r4.model.Basic) {
      org.hl7.fhir.r4.model.Basic basic = (Basic) src;
      if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "ActorDefinition")) {
        return ActorDefinition40_N.convertActorDefinition((org.hl7.fhir.r4.model.Basic) src);
      } else if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "Requirements")) {
        return Requirements40_N.convertRequirements((org.hl7.fhir.r4.model.Basic) src);
      } else if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "SubscriptionTopic")) {
        return SubscriptionTopic40_N.convertSubscriptionTopic((org.hl7.fhir.r4.model.Basic) src);
      } else if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "TestPlan")) {
        return TestPlan40_N.convertTestPlan((org.hl7.fhir.r4.model.Basic) src);
      } else {
        return Basic40_N.convertBasic((org.hl7.fhir.r4.model.Basic) src);
      }
    }
    if (src instanceof org.hl7.fhir.r4.model.Binary)
      return Binary40_N.convertBinary((org.hl7.fhir.r4.model.Binary) src);
    if (src instanceof org.hl7.fhir.r4.model.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct40_N.convertBiologicallyDerivedProduct((org.hl7.fhir.r4.model.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.r4.model.BodyStructure)
      return BodyStructure40_N.convertBodyStructure((org.hl7.fhir.r4.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r4.model.Bundle)
      return Bundle40_N.convertBundle((org.hl7.fhir.r4.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r4.model.CapabilityStatement)
      return CapabilityStatement40_N.convertCapabilityStatement((org.hl7.fhir.r4.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.CarePlan)
      return CarePlan40_N.convertCarePlan((org.hl7.fhir.r4.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r4.model.CareTeam)
      return CareTeam40_N.convertCareTeam((org.hl7.fhir.r4.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r4.model.Claim) return Claim40_N.convertClaim((org.hl7.fhir.r4.model.Claim) src);
    if (src instanceof org.hl7.fhir.r4.model.ClaimResponse)
      return ClaimResponse40_N.convertClaimResponse((org.hl7.fhir.r4.model.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeSystem)
      return CodeSystem40_N.convertCodeSystem((org.hl7.fhir.r4.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r4.model.Communication)
      return Communication40_N.convertCommunication((org.hl7.fhir.r4.model.Communication) src);
    if (src instanceof org.hl7.fhir.r4.model.CommunicationRequest)
      return CommunicationRequest40_N.convertCommunicationRequest((org.hl7.fhir.r4.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.CompartmentDefinition)
      return CompartmentDefinition40_N.convertCompartmentDefinition((org.hl7.fhir.r4.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Composition)
      return Composition40_N.convertComposition((org.hl7.fhir.r4.model.Composition) src);
    if (src instanceof org.hl7.fhir.r4.model.ConceptMap)
      return ConceptMap40_N.convertConceptMap((org.hl7.fhir.r4.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r4.model.Condition)
      return Condition40_N.convertCondition((org.hl7.fhir.r4.model.Condition) src);
    if (src instanceof org.hl7.fhir.r4.model.Consent)
      return Consent40_N.convertConsent((org.hl7.fhir.r4.model.Consent) src);
    if (src instanceof org.hl7.fhir.r4.model.Coverage)
      return Coverage40_N.convertCoverage((org.hl7.fhir.r4.model.Coverage) src);
    if (src instanceof org.hl7.fhir.r4.model.CoverageEligibilityRequest)
      return CoverageEligibilityRequest40_N.convertCoverageEligibilityRequest((org.hl7.fhir.r4.model.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.DetectedIssue)
      return DetectedIssue40_N.convertDetectedIssue((org.hl7.fhir.r4.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r4.model.Device)
      return Device40_N.convertDevice((org.hl7.fhir.r4.model.Device) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceMetric)
      return DeviceMetric40_N.convertDeviceMetric((org.hl7.fhir.r4.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceRequest)
      return DeviceRequest40_N.convertDeviceRequest((org.hl7.fhir.r4.model.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.DiagnosticReport)
      return DiagnosticReport40_N.convertDiagnosticReport((org.hl7.fhir.r4.model.DiagnosticReport) src);
//    if (src instanceof org.hl7.fhir.r4.model.DocumentManifest)
//      return DocumentManifest40_N.convertDocumentManifest((org.hl7.fhir.r4.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.r4.model.DocumentReference)
      return DocumentReference40_N.convertDocumentReference((org.hl7.fhir.r4.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r4.model.Encounter)
      return Encounter40_N.convertEncounter((org.hl7.fhir.r4.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r4.model.Endpoint)
      return Endpoint40_N.convertEndpoint((org.hl7.fhir.r4.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r4.model.EpisodeOfCare)
      return EpisodeOfCare40_N.convertEpisodeOfCare((org.hl7.fhir.r4.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r4.model.EventDefinition)
      return EventDefinition40_N.convertEventDefinition((org.hl7.fhir.r4.model.EventDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.ExampleScenario)
      return ExampleScenario40_N.convertExampleScenario((org.hl7.fhir.r4.model.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.r4.model.ExplanationOfBenefit)
      return ExplanationOfBenefit40_N.convertExplanationOfBenefit((org.hl7.fhir.r4.model.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.r4.model.FamilyMemberHistory)
      return FamilyMemberHistory40_N.convertFamilyMemberHistory((org.hl7.fhir.r4.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r4.model.Flag) return Flag40_N.convertFlag((org.hl7.fhir.r4.model.Flag) src);
    if (src instanceof org.hl7.fhir.r4.model.Goal) return Goal40_N.convertGoal((org.hl7.fhir.r4.model.Goal) src);
    if (src instanceof org.hl7.fhir.r4.model.Group) return Group40_N.convertGroup((org.hl7.fhir.r4.model.Group) src);
    if (src instanceof org.hl7.fhir.r4.model.GuidanceResponse)
      return GuidanceResponse40_N.convertGuidanceResponse((org.hl7.fhir.r4.model.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.HealthcareService)
      return HealthcareService40_N.convertHealthcareService((org.hl7.fhir.r4.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r4.model.ImagingStudy)
      return ImagingStudy40_N.convertImagingStudy((org.hl7.fhir.r4.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r4.model.Immunization)
      return Immunization40_N.convertImmunization((org.hl7.fhir.r4.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r4.model.ImplementationGuide)
      return ImplementationGuide40_N.convertImplementationGuide((org.hl7.fhir.r4.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r4.model.Library)
      return Library40_N.convertLibrary((org.hl7.fhir.r4.model.Library) src);
    if (src instanceof org.hl7.fhir.r4.model.ListResource)
      return ListResource40_N.convertListResource((org.hl7.fhir.r4.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r4.model.Location)
      return Location40_N.convertLocation((org.hl7.fhir.r4.model.Location) src);
    if (src instanceof org.hl7.fhir.r4.model.Measure)
      return Measure40_N.convertMeasure((org.hl7.fhir.r4.model.Measure) src);
    if (src instanceof org.hl7.fhir.r4.model.MeasureReport)
      return MeasureReport40_N.convertMeasureReport((org.hl7.fhir.r4.model.MeasureReport) src);
    if (src instanceof org.hl7.fhir.r4.model.Media) return Media40_N.convertMedia((org.hl7.fhir.r4.model.Media) src);
    if (src instanceof org.hl7.fhir.r4.model.Medication)
      return Medication40_N.convertMedication((org.hl7.fhir.r4.model.Medication) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationAdministration)
      return MedicationAdministration40_N.convertMedicationAdministration((org.hl7.fhir.r4.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationDispense)
      return MedicationDispense40_N.convertMedicationDispense((org.hl7.fhir.r4.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationRequest)
      return MedicationRequest40_N.convertMedicationRequest((org.hl7.fhir.r4.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationStatement)
      return MedicationStatement40_N.convertMedicationStatement((org.hl7.fhir.r4.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.MessageDefinition)
      return MessageDefinition40_N.convertMessageDefinition((org.hl7.fhir.r4.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.MessageHeader)
      return MessageHeader40_N.convertMessageHeader((org.hl7.fhir.r4.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r4.model.NamingSystem)
      return NamingSystem40_N.convertNamingSystem((org.hl7.fhir.r4.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r4.model.NutritionOrder)
      return NutritionOrder40_N.convertNutritionOrder((org.hl7.fhir.r4.model.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.r4.model.Observation)
      return Observation40_N.convertObservation((org.hl7.fhir.r4.model.Observation) src);
    if (src instanceof org.hl7.fhir.r4.model.ObservationDefinition)
      return ObservationDefinition40_N.convertObservationDefinition((org.hl7.fhir.r4.model.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationDefinition)
      return OperationDefinition40_N.convertOperationDefinition((org.hl7.fhir.r4.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationOutcome)
      return OperationOutcome40_N.convertOperationOutcome((org.hl7.fhir.r4.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r4.model.Organization)
      return Organization40_N.convertOrganization((org.hl7.fhir.r4.model.Organization) src);
    if (src instanceof org.hl7.fhir.r4.model.OrganizationAffiliation)
      return OrganizationAffiliation40_N.convertOrganizationAffiliation((org.hl7.fhir.r4.model.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.r4.model.Patient)
      return Patient40_N.convertPatient((org.hl7.fhir.r4.model.Patient) src);
    if (src instanceof org.hl7.fhir.r4.model.PaymentNotice)
      return PaymentNotice40_N.convertPaymentNotice((org.hl7.fhir.r4.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r4.model.Person)
      return Person40_N.convertPerson((org.hl7.fhir.r4.model.Person) src);
    if (src instanceof org.hl7.fhir.r4.model.PlanDefinition)
      return PlanDefinition40_N.convertPlanDefinition((org.hl7.fhir.r4.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Practitioner)
      return Practitioner40_N.convertPractitioner((org.hl7.fhir.r4.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r4.model.PractitionerRole)
      return PractitionerRole40_N.convertPractitionerRole((org.hl7.fhir.r4.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r4.model.Procedure)
      return Procedure40_N.convertProcedure((org.hl7.fhir.r4.model.Procedure) src);
    if (src instanceof org.hl7.fhir.r4.model.Provenance)
      return Provenance40_N.convertProvenance((org.hl7.fhir.r4.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r4.model.Questionnaire)
      return Questionnaire40_N.convertQuestionnaire((org.hl7.fhir.r4.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r4.model.QuestionnaireResponse)
      return QuestionnaireResponse40_N.convertQuestionnaireResponse((org.hl7.fhir.r4.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.RelatedPerson)
      return RelatedPerson40_N.convertRelatedPerson((org.hl7.fhir.r4.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r4.model.RiskAssessment)
      return RiskAssessment40_N.convertRiskAssessment((org.hl7.fhir.r4.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r4.model.Schedule)
      return Schedule40_N.convertSchedule((org.hl7.fhir.r4.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r4.model.SearchParameter)
      return SearchParameter40_N.convertSearchParameter((org.hl7.fhir.r4.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r4.model.ServiceRequest)
      return ServiceRequest40_N.convertServiceRequest((org.hl7.fhir.r4.model.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.Slot) return Slot40_N.convertSlot((org.hl7.fhir.r4.model.Slot) src);
    if (src instanceof org.hl7.fhir.r4.model.Specimen)
      return Specimen40_N.convertSpecimen((org.hl7.fhir.r4.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r4.model.SpecimenDefinition)
      return SpecimenDefinition40_N.convertSpecimenDefinition((org.hl7.fhir.r4.model.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.StructureDefinition)
      return StructureDefinition40_N.convertStructureDefinition((org.hl7.fhir.r4.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Substance)
      return Substance40_N.convertSubstance((org.hl7.fhir.r4.model.Substance) src);
    if (src instanceof org.hl7.fhir.r4.model.Task) return Task40_N.convertTask((org.hl7.fhir.r4.model.Task) src);
    if (src instanceof org.hl7.fhir.r4.model.TerminologyCapabilities)
      return TerminologyCapabilities40_N.convertTerminologyCapabilities((org.hl7.fhir.r4.model.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.r4.model.ValueSet)
      return ValueSet40_N.convertValueSet((org.hl7.fhir.r4.model.ValueSet) src);
    if (src instanceof org.hl7.fhir.r4.model.VisionPrescription)
      return VisionPrescription40_N.convertVisionPrescription((org.hl7.fhir.r4.model.VisionPrescription) src);
    if (src instanceof org.hl7.fhir.r4.model.Subscription)
      return Subscription40_N.convertSubscription((org.hl7.fhir.r4.model.Subscription) src);

    if (src instanceof org.hl7.fhir.r4.model.GraphDefinition)
      return GraphDefinition40_N.convertGraphDefinition((org.hl7.fhir.r4.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.StructureMap)
      return StructureMap40_N.convertStructureMap((org.hl7.fhir.r4.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r4.model.TestReport)
      return TestReport40_N.convertTestReport((org.hl7.fhir.r4.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r4.model.TestScript)
      return TestScript40_N.convertTestScript((org.hl7.fhir.r4.model.TestScript) src);

    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R4 to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.model.core.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.model.core.Parameters)
      return Parameters40_N.convertParameters((org.hl7.fhir.model.core.Parameters) src);
    if (src instanceof org.hl7.fhir.model.core.Account)
      return Account40_N.convertAccount((org.hl7.fhir.model.core.Account) src);
    if (src instanceof org.hl7.fhir.model.core.ActivityDefinition)
      return ActivityDefinition40_N.convertActivityDefinition((org.hl7.fhir.model.core.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.AllergyIntolerance)
      return AllergyIntolerance40_N.convertAllergyIntolerance((org.hl7.fhir.model.core.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.model.core.ActorDefinition)
      return ActorDefinition40_N.convertActorDefinition((org.hl7.fhir.model.core.ActorDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.Appointment)
      return Appointment40_N.convertAppointment((org.hl7.fhir.model.core.Appointment) src);
    if (src instanceof org.hl7.fhir.model.core.AppointmentResponse)
      return AppointmentResponse40_N.convertAppointmentResponse((org.hl7.fhir.model.core.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.model.core.AuditEvent)
      return AuditEvent40_N.convertAuditEvent((org.hl7.fhir.model.core.AuditEvent) src);
    if (src instanceof org.hl7.fhir.model.core.Basic) return Basic40_N.convertBasic((org.hl7.fhir.model.core.Basic) src);
    if (src instanceof org.hl7.fhir.model.core.Binary)
      return Binary40_N.convertBinary((org.hl7.fhir.model.core.Binary) src);
    if (src instanceof org.hl7.fhir.model.core.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct40_N.convertBiologicallyDerivedProduct((org.hl7.fhir.model.core.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.model.core.BodyStructure)
      return BodyStructure40_N.convertBodyStructure((org.hl7.fhir.model.core.BodyStructure) src);
    if (src instanceof org.hl7.fhir.model.core.Bundle)
      return Bundle40_N.convertBundle((org.hl7.fhir.model.core.Bundle) src);
    if (src instanceof org.hl7.fhir.model.core.CapabilityStatement)
      return CapabilityStatement40_N.convertCapabilityStatement((org.hl7.fhir.model.core.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.model.core.CarePlan)
      return CarePlan40_N.convertCarePlan((org.hl7.fhir.model.core.CarePlan) src);
    if (src instanceof org.hl7.fhir.model.core.CareTeam)
      return CareTeam40_N.convertCareTeam((org.hl7.fhir.model.core.CareTeam) src);
    if (src instanceof org.hl7.fhir.model.core.Claim) return Claim40_N.convertClaim((org.hl7.fhir.model.core.Claim) src);
    if (src instanceof org.hl7.fhir.model.core.ClaimResponse)
      return ClaimResponse40_N.convertClaimResponse((org.hl7.fhir.model.core.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.model.core.CodeSystem)
      return CodeSystem40_N.convertCodeSystem((org.hl7.fhir.model.core.CodeSystem) src);
    if (src instanceof org.hl7.fhir.model.core.Communication)
      return Communication40_N.convertCommunication((org.hl7.fhir.model.core.Communication) src);
    if (src instanceof org.hl7.fhir.model.core.CommunicationRequest)
      return CommunicationRequest40_N.convertCommunicationRequest((org.hl7.fhir.model.core.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.model.core.CompartmentDefinition)
      return CompartmentDefinition40_N.convertCompartmentDefinition((org.hl7.fhir.model.core.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.Composition)
      return Composition40_N.convertComposition((org.hl7.fhir.model.core.Composition) src);
    if (src instanceof org.hl7.fhir.model.core.ConceptMap)
      return ConceptMap40_N.convertConceptMap((org.hl7.fhir.model.core.ConceptMap) src);
    if (src instanceof org.hl7.fhir.model.core.Condition)
      return Condition40_N.convertCondition((org.hl7.fhir.model.core.Condition) src);
    if (src instanceof org.hl7.fhir.model.core.Consent)
      return Consent40_N.convertConsent((org.hl7.fhir.model.core.Consent) src);
    if (src instanceof org.hl7.fhir.model.core.Coverage)
      return Coverage40_N.convertCoverage((org.hl7.fhir.model.core.Coverage) src);
    if (src instanceof org.hl7.fhir.model.core.CoverageEligibilityRequest)
      return CoverageEligibilityRequest40_N.convertCoverageEligibilityRequest((org.hl7.fhir.model.core.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.model.core.DetectedIssue)
      return DetectedIssue40_N.convertDetectedIssue((org.hl7.fhir.model.core.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.model.core.Device)
      return Device40_N.convertDevice((org.hl7.fhir.model.core.Device) src);
    if (src instanceof org.hl7.fhir.model.core.DeviceMetric)
      return DeviceMetric40_N.convertDeviceMetric((org.hl7.fhir.model.core.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.model.core.DeviceRequest)
      return DeviceRequest40_N.convertDeviceRequest((org.hl7.fhir.model.core.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.model.core.DiagnosticReport)
      return DiagnosticReport40_N.convertDiagnosticReport((org.hl7.fhir.model.core.DiagnosticReport) src);
//    if (src instanceof org.hl7.fhir.model.core.DocumentManifest)
//      return DocumentManifest40_N.convertDocumentManifest((org.hl7.fhir.model.core.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.model.core.DocumentReference)
      return DocumentReference40_N.convertDocumentReference((org.hl7.fhir.model.core.DocumentReference) src);
    if (src instanceof org.hl7.fhir.model.core.Encounter)
      return Encounter40_N.convertEncounter((org.hl7.fhir.model.core.Encounter) src);
    if (src instanceof org.hl7.fhir.model.core.Endpoint)
      return Endpoint40_N.convertEndpoint((org.hl7.fhir.model.core.Endpoint) src);
    if (src instanceof org.hl7.fhir.model.core.EpisodeOfCare)
      return EpisodeOfCare40_N.convertEpisodeOfCare((org.hl7.fhir.model.core.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.model.core.EventDefinition)
      return EventDefinition40_N.convertEventDefinition((org.hl7.fhir.model.core.EventDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.ExampleScenario)
      return ExampleScenario40_N.convertExampleScenario((org.hl7.fhir.model.core.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.model.core.ExplanationOfBenefit)
      return ExplanationOfBenefit40_N.convertExplanationOfBenefit((org.hl7.fhir.model.core.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.model.core.FamilyMemberHistory)
      return FamilyMemberHistory40_N.convertFamilyMemberHistory((org.hl7.fhir.model.core.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.model.core.Flag) return Flag40_N.convertFlag((org.hl7.fhir.model.core.Flag) src);
    if (src instanceof org.hl7.fhir.model.core.Goal) return Goal40_N.convertGoal((org.hl7.fhir.model.core.Goal) src);
    if (src instanceof org.hl7.fhir.model.core.Group) return Group40_N.convertGroup((org.hl7.fhir.model.core.Group) src);
    if (src instanceof org.hl7.fhir.model.core.GuidanceResponse)
      return GuidanceResponse40_N.convertGuidanceResponse((org.hl7.fhir.model.core.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.model.core.HealthcareService)
      return HealthcareService40_N.convertHealthcareService((org.hl7.fhir.model.core.HealthcareService) src);
    if (src instanceof org.hl7.fhir.model.core.ImagingStudy)
      return ImagingStudy40_N.convertImagingStudy((org.hl7.fhir.model.core.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.model.core.Immunization)
      return Immunization40_N.convertImmunization((org.hl7.fhir.model.core.Immunization) src);
    if (src instanceof org.hl7.fhir.model.core.ImplementationGuide)
      return ImplementationGuide40_N.convertImplementationGuide((org.hl7.fhir.model.core.ImplementationGuide) src, advisor.produceIllegalParameters());
    if (src instanceof org.hl7.fhir.model.core.Library)
      return Library40_N.convertLibrary((org.hl7.fhir.model.core.Library) src);
    if (src instanceof org.hl7.fhir.model.core.ListResource)
      return ListResource40_N.convertListResource((org.hl7.fhir.model.core.ListResource) src);
    if (src instanceof org.hl7.fhir.model.core.Location)
      return Location40_N.convertLocation((org.hl7.fhir.model.core.Location) src);
    if (src instanceof org.hl7.fhir.model.core.Measure)
      return Measure40_N.convertMeasure((org.hl7.fhir.model.core.Measure) src);
    if (src instanceof org.hl7.fhir.model.core.MeasureReport)
      return MeasureReport40_N.convertMeasureReport((org.hl7.fhir.model.core.MeasureReport) src);
    if (src instanceof org.hl7.fhir.model.core.DocumentReference)
      return Media40_N.convertMedia((org.hl7.fhir.model.core.DocumentReference) src);
    if (src instanceof org.hl7.fhir.model.core.Medication)
      return Medication40_N.convertMedication((org.hl7.fhir.model.core.Medication) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationAdministration)
      return MedicationAdministration40_N.convertMedicationAdministration((org.hl7.fhir.model.core.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationDispense)
      return MedicationDispense40_N.convertMedicationDispense((org.hl7.fhir.model.core.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationRequest)
      return MedicationRequest40_N.convertMedicationRequest((org.hl7.fhir.model.core.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationStatement)
      return MedicationStatement40_N.convertMedicationStatement((org.hl7.fhir.model.core.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.model.core.MessageDefinition)
      return MessageDefinition40_N.convertMessageDefinition((org.hl7.fhir.model.core.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.MessageHeader)
      return MessageHeader40_N.convertMessageHeader((org.hl7.fhir.model.core.MessageHeader) src);
    if (src instanceof org.hl7.fhir.model.core.NamingSystem)
      return NamingSystem40_N.convertNamingSystem((org.hl7.fhir.model.core.NamingSystem) src);
    if (src instanceof org.hl7.fhir.model.core.NutritionOrder)
      return NutritionOrder40_N.convertNutritionOrder((org.hl7.fhir.model.core.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.model.core.Observation)
      return Observation40_N.convertObservation((org.hl7.fhir.model.core.Observation) src);
    if (src instanceof org.hl7.fhir.model.core.ObservationDefinition)
      return ObservationDefinition40_N.convertObservationDefinition((org.hl7.fhir.model.core.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.OperationDefinition)
      return OperationDefinition40_N.convertOperationDefinition((org.hl7.fhir.model.core.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.OperationOutcome)
      return OperationOutcome40_N.convertOperationOutcome((org.hl7.fhir.model.core.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.model.core.Organization)
      return Organization40_N.convertOrganization((org.hl7.fhir.model.core.Organization) src);
    if (src instanceof org.hl7.fhir.model.core.OrganizationAffiliation)
      return OrganizationAffiliation40_N.convertOrganizationAffiliation((org.hl7.fhir.model.core.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.model.core.Patient)
      return Patient40_N.convertPatient((org.hl7.fhir.model.core.Patient) src);
    if (src instanceof org.hl7.fhir.model.core.PaymentNotice)
      return PaymentNotice40_N.convertPaymentNotice((org.hl7.fhir.model.core.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.model.core.Person)
      return Person40_N.convertPerson((org.hl7.fhir.model.core.Person) src);
    if (src instanceof org.hl7.fhir.model.core.PlanDefinition)
      return PlanDefinition40_N.convertPlanDefinition((org.hl7.fhir.model.core.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.Practitioner)
      return Practitioner40_N.convertPractitioner((org.hl7.fhir.model.core.Practitioner) src);
    if (src instanceof org.hl7.fhir.model.core.PractitionerRole)
      return PractitionerRole40_N.convertPractitionerRole((org.hl7.fhir.model.core.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.model.core.Procedure)
      return Procedure40_N.convertProcedure((org.hl7.fhir.model.core.Procedure) src);
    if (src instanceof org.hl7.fhir.model.core.Provenance)
      return Provenance40_N.convertProvenance((org.hl7.fhir.model.core.Provenance) src);
    if (src instanceof org.hl7.fhir.model.core.Questionnaire)
      return Questionnaire40_N.convertQuestionnaire((org.hl7.fhir.model.core.Questionnaire) src);
    if (src instanceof org.hl7.fhir.model.core.QuestionnaireResponse)
      return QuestionnaireResponse40_N.convertQuestionnaireResponse((org.hl7.fhir.model.core.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.model.core.RelatedPerson)
      return RelatedPerson40_N.convertRelatedPerson((org.hl7.fhir.model.core.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.model.core.Requirements)
      return Requirements40_N.convertRequirements((org.hl7.fhir.model.core.Requirements) src);
    if (src instanceof org.hl7.fhir.model.core.RiskAssessment)
      return RiskAssessment40_N.convertRiskAssessment((org.hl7.fhir.model.core.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.model.core.Schedule)
      return Schedule40_N.convertSchedule((org.hl7.fhir.model.core.Schedule) src);
    if (src instanceof org.hl7.fhir.model.core.SearchParameter)
      return SearchParameter40_N.convertSearchParameter((org.hl7.fhir.model.core.SearchParameter) src);
    if (src instanceof org.hl7.fhir.model.core.ServiceRequest)
      return ServiceRequest40_N.convertServiceRequest((org.hl7.fhir.model.core.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.model.core.Slot) return Slot40_N.convertSlot((org.hl7.fhir.model.core.Slot) src);
    if (src instanceof org.hl7.fhir.model.core.Specimen)
      return Specimen40_N.convertSpecimen((org.hl7.fhir.model.core.Specimen) src);
    if (src instanceof org.hl7.fhir.model.core.SpecimenDefinition)
      return SpecimenDefinition40_N.convertSpecimenDefinition((org.hl7.fhir.model.core.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.StructureDefinition)
      return StructureDefinition40_N.convertStructureDefinition((org.hl7.fhir.model.core.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.SubscriptionTopic)
      return SubscriptionTopic40_N.convertSubscriptionTopic((org.hl7.fhir.model.core.SubscriptionTopic) src);
    if (src instanceof org.hl7.fhir.model.core.Substance)
      return Substance40_N.convertSubstance((org.hl7.fhir.model.core.Substance) src);
    if (src instanceof org.hl7.fhir.model.core.Task) return Task40_N.convertTask((org.hl7.fhir.model.core.Task) src);
    if (src instanceof org.hl7.fhir.model.core.TerminologyCapabilities)
      return TerminologyCapabilities40_N.convertTerminologyCapabilities((org.hl7.fhir.model.core.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.model.core.ValueSet)
      return ValueSet40_N.convertValueSet((org.hl7.fhir.model.core.ValueSet) src);
    if (src instanceof org.hl7.fhir.model.core.VisionPrescription)
      return VisionPrescription40_N.convertVisionPrescription((org.hl7.fhir.model.core.VisionPrescription) src);
    if (src instanceof org.hl7.fhir.model.core.Subscription)
      return Subscription40_N.convertSubscription((org.hl7.fhir.model.core.Subscription) src);

    if (src instanceof org.hl7.fhir.model.api.GraphDefinition)
      return GraphDefinition40_N.convertGraphDefinition((org.hl7.fhir.model.api.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.model.fml.StructureMap)
      return StructureMap40_N.convertStructureMap((org.hl7.fhir.model.fml.StructureMap) src);
    if (src instanceof org.hl7.fhir.model.testing.TestPlan)
      return TestPlan40_N.convertTestPlan((org.hl7.fhir.model.testing.TestPlan) src);
    if (src instanceof org.hl7.fhir.model.testing.TestReport)
      return TestReport40_N.convertTestReport((org.hl7.fhir.model.testing.TestReport) src);
    if (src instanceof org.hl7.fhir.model.testing.TestScript)
      return TestScript40_N.convertTestScript((org.hl7.fhir.model.testing.TestScript) src);

    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R5 to R4");
    } else {
      return null;
    }
  }

  public void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.model.core.DomainResource tgt, String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative40_N.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext40_N.INSTANCE.path(), extension)) {
        org.hl7.fhir.model.core.Extension convertExtension = new org.hl7.fhir.model.core.Extension();
        advisor.handleExtension(ConversionContext40_N.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext40_N.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension40_N.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext40_N.INSTANCE.path(), extension))
      .map(Extension40_N::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public void copyDomainResource(org.hl7.fhir.model.core.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt,  String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative40_N.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext40_N.INSTANCE.path(), extension)) {
        org.hl7.fhir.r4.model.Extension convertExtension = new org.hl7.fhir.r4.model.Extension();
        advisor.handleExtension(ConversionContext40_N.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext40_N.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension40_N.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext40_N.INSTANCE.path(), extension))
      .map(Extension40_N::convertExtension)
      .forEach(tgt::addModifierExtension);
  }
}
