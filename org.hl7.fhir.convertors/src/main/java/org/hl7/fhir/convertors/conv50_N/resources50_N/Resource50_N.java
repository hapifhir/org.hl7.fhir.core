package org.hl7.fhir.convertors.conv50_N.resources50_N;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_50_N;
import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N;
import org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N;
import org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N;
import org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Extension50_N;
import org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Meta50_N;
import org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Narrative50_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Basic;

public class Resource50_N {

  public final BaseAdvisor_50_N advisor;

  public Resource50_N(BaseAdvisor_50_N advisor) {
    this.advisor = advisor;
  }

  public void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.model.core.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id50_N.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta50_N.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRulesElement(Uri50_N.convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code50_N.convertCode(src.getLanguageElement()));
  }

  public void copyResource(org.hl7.fhir.model.core.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id50_N.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta50_N.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRulesElement(Uri50_N.convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code50_N.convertCode(src.getLanguageElement()));
  }

  public org.hl7.fhir.model.core.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.r5.model.Parameters)
      return Parameters50_N.convertParameters((org.hl7.fhir.r5.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r5.model.Account)
      return Account50_N.convertAccount((org.hl7.fhir.r5.model.Account) src);
    if (src instanceof org.hl7.fhir.r5.model.ActivityDefinition)
      return ActivityDefinition50_N.convertActivityDefinition((org.hl7.fhir.r5.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.AllergyIntolerance)
      return AllergyIntolerance50_N.convertAllergyIntolerance((org.hl7.fhir.r5.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r5.model.Appointment)
      return Appointment50_N.convertAppointment((org.hl7.fhir.r5.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r5.model.AppointmentResponse)
      return AppointmentResponse50_N.convertAppointmentResponse((org.hl7.fhir.r5.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.AuditEvent)
      return AuditEvent50_N.convertAuditEvent((org.hl7.fhir.r5.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r5.model.ActorDefinition)
      return ActorDefinition50_N.convertActorDefinition((org.hl7.fhir.r5.model.ActorDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Requirements)
      return Requirements50_N.convertRequirements((org.hl7.fhir.r5.model.Requirements) src);
    if (src instanceof org.hl7.fhir.r5.model.SubscriptionTopic)
      return SubscriptionTopic50_N.convertSubscriptionTopic((org.hl7.fhir.r5.model.SubscriptionTopic) src);
//    if (src instanceof org.hl7.fhir.r5.model.TestPlan)
//      return TestPlan50_N.convertTestPlan((org.hl7.fhir.r5.model.TestPlan) src);
    if (src instanceof org.hl7.fhir.r5.model.Binary)
      return Binary50_N.convertBinary((org.hl7.fhir.r5.model.Binary) src);
    if (src instanceof org.hl7.fhir.r5.model.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct50_N.convertBiologicallyDerivedProduct((org.hl7.fhir.r5.model.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.r5.model.BodyStructure)
      return BodyStructure50_N.convertBodyStructure((org.hl7.fhir.r5.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r5.model.Bundle)
      return Bundle50_N.convertBundle((org.hl7.fhir.r5.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r5.model.CapabilityStatement)
      return CapabilityStatement50_N.convertCapabilityStatement((org.hl7.fhir.r5.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.CarePlan)
      return CarePlan50_N.convertCarePlan((org.hl7.fhir.r5.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r5.model.CareTeam)
      return CareTeam50_N.convertCareTeam((org.hl7.fhir.r5.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r5.model.Claim) return Claim50_N.convertClaim((org.hl7.fhir.r5.model.Claim) src);
    if (src instanceof org.hl7.fhir.r5.model.ClaimResponse)
      return ClaimResponse50_N.convertClaimResponse((org.hl7.fhir.r5.model.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeSystem)
      return CodeSystem50_N.convertCodeSystem((org.hl7.fhir.r5.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.Communication)
      return Communication50_N.convertCommunication((org.hl7.fhir.r5.model.Communication) src);
    if (src instanceof org.hl7.fhir.r5.model.CommunicationRequest)
      return CommunicationRequest50_N.convertCommunicationRequest((org.hl7.fhir.r5.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.CompartmentDefinition)
      return CompartmentDefinition50_N.convertCompartmentDefinition((org.hl7.fhir.r5.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Composition)
      return Composition50_N.convertComposition((org.hl7.fhir.r5.model.Composition) src);
    if (src instanceof org.hl7.fhir.r5.model.ConceptMap)
      return ConceptMap50_N.convertConceptMap((org.hl7.fhir.r5.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r5.model.Condition)
      return Condition50_N.convertCondition((org.hl7.fhir.r5.model.Condition) src);
    if (src instanceof org.hl7.fhir.r5.model.Consent)
      return Consent50_N.convertConsent((org.hl7.fhir.r5.model.Consent) src);
    if (src instanceof org.hl7.fhir.r5.model.Coverage)
      return Coverage50_N.convertCoverage((org.hl7.fhir.r5.model.Coverage) src);
    if (src instanceof org.hl7.fhir.r5.model.CoverageEligibilityRequest)
      return CoverageEligibilityRequest50_N.convertCoverageEligibilityRequest((org.hl7.fhir.r5.model.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.DetectedIssue)
      return DetectedIssue50_N.convertDetectedIssue((org.hl7.fhir.r5.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r5.model.Device)
      return Device50_N.convertDevice((org.hl7.fhir.r5.model.Device) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceMetric)
      return DeviceMetric50_N.convertDeviceMetric((org.hl7.fhir.r5.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceRequest)
      return DeviceRequest50_N.convertDeviceRequest((org.hl7.fhir.r5.model.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.DiagnosticReport)
      return DiagnosticReport50_N.convertDiagnosticReport((org.hl7.fhir.r5.model.DiagnosticReport) src);
//    if (src instanceof org.hl7.fhir.r5.model.DocumentManifest)
//      return DocumentManifest50_N.convertDocumentManifest((org.hl7.fhir.r5.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
      return DocumentReference50_N.convertDocumentReference((org.hl7.fhir.r5.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r5.model.Encounter)
      return Encounter50_N.convertEncounter((org.hl7.fhir.r5.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r5.model.Endpoint)
      return Endpoint50_N.convertEndpoint((org.hl7.fhir.r5.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r5.model.EpisodeOfCare)
      return EpisodeOfCare50_N.convertEpisodeOfCare((org.hl7.fhir.r5.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r5.model.EventDefinition)
      return EventDefinition50_N.convertEventDefinition((org.hl7.fhir.r5.model.EventDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.ExampleScenario)
      return ExampleScenario50_N.convertExampleScenario((org.hl7.fhir.r5.model.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.r5.model.ExplanationOfBenefit)
      return ExplanationOfBenefit50_N.convertExplanationOfBenefit((org.hl7.fhir.r5.model.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.r5.model.FamilyMemberHistory)
      return FamilyMemberHistory50_N.convertFamilyMemberHistory((org.hl7.fhir.r5.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r5.model.Flag) return Flag50_N.convertFlag((org.hl7.fhir.r5.model.Flag) src);
    if (src instanceof org.hl7.fhir.r5.model.Goal) return Goal50_N.convertGoal((org.hl7.fhir.r5.model.Goal) src);
    if (src instanceof org.hl7.fhir.r5.model.Group) return Group50_N.convertGroup((org.hl7.fhir.r5.model.Group) src);
    if (src instanceof org.hl7.fhir.r5.model.GuidanceResponse)
      return GuidanceResponse50_N.convertGuidanceResponse((org.hl7.fhir.r5.model.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.HealthcareService)
      return HealthcareService50_N.convertHealthcareService((org.hl7.fhir.r5.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r5.model.ImagingStudy)
      return ImagingStudy50_N.convertImagingStudy((org.hl7.fhir.r5.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r5.model.Immunization)
      return Immunization50_N.convertImmunization((org.hl7.fhir.r5.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r5.model.ImplementationGuide)
      return ImplementationGuide50_N.convertImplementationGuide((org.hl7.fhir.r5.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r5.model.Library)
      return Library50_N.convertLibrary((org.hl7.fhir.r5.model.Library) src);
    if (src instanceof org.hl7.fhir.r5.model.ListResource)
      return List50_N.convertList((org.hl7.fhir.r5.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r5.model.Location)
      return Location50_N.convertLocation((org.hl7.fhir.r5.model.Location) src);
    if (src instanceof org.hl7.fhir.r5.model.Measure)
      return Measure50_N.convertMeasure((org.hl7.fhir.r5.model.Measure) src);
    if (src instanceof org.hl7.fhir.r5.model.MeasureReport)
      return MeasureReport50_N.convertMeasureReport((org.hl7.fhir.r5.model.MeasureReport) src);
    if (src instanceof org.hl7.fhir.r5.model.Medication)
      return Medication50_N.convertMedication((org.hl7.fhir.r5.model.Medication) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationAdministration)
      return MedicationAdministration50_N.convertMedicationAdministration((org.hl7.fhir.r5.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationDispense)
      return MedicationDispense50_N.convertMedicationDispense((org.hl7.fhir.r5.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationRequest)
      return MedicationRequest50_N.convertMedicationRequest((org.hl7.fhir.r5.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationStatement)
      return MedicationStatement50_N.convertMedicationStatement((org.hl7.fhir.r5.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageDefinition)
      return MessageDefinition50_N.convertMessageDefinition((org.hl7.fhir.r5.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageHeader)
      return MessageHeader50_N.convertMessageHeader((org.hl7.fhir.r5.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r5.model.NamingSystem)
      return NamingSystem50_N.convertNamingSystem((org.hl7.fhir.r5.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.NutritionOrder)
      return NutritionOrder50_N.convertNutritionOrder((org.hl7.fhir.r5.model.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.r5.model.Observation)
      return Observation50_N.convertObservation((org.hl7.fhir.r5.model.Observation) src);
    if (src instanceof org.hl7.fhir.r5.model.ObservationDefinition)
      return ObservationDefinition50_N.convertObservationDefinition((org.hl7.fhir.r5.model.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationDefinition)
      return OperationDefinition50_N.convertOperationDefinition((org.hl7.fhir.r5.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationOutcome)
      return OperationOutcome50_N.convertOperationOutcome((org.hl7.fhir.r5.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r5.model.Organization)
      return Organization50_N.convertOrganization((org.hl7.fhir.r5.model.Organization) src);
    if (src instanceof org.hl7.fhir.r5.model.OrganizationAffiliation)
      return OrganizationAffiliation50_N.convertOrganizationAffiliation((org.hl7.fhir.r5.model.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.r5.model.Patient)
      return Patient50_N.convertPatient((org.hl7.fhir.r5.model.Patient) src);
    if (src instanceof org.hl7.fhir.r5.model.PaymentNotice)
      return PaymentNotice50_N.convertPaymentNotice((org.hl7.fhir.r5.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r5.model.Person)
      return Person50_N.convertPerson((org.hl7.fhir.r5.model.Person) src);
    if (src instanceof org.hl7.fhir.r5.model.PlanDefinition)
      return PlanDefinition50_N.convertPlanDefinition((org.hl7.fhir.r5.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Practitioner)
      return Practitioner50_N.convertPractitioner((org.hl7.fhir.r5.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r5.model.PractitionerRole)
      return PractitionerRole50_N.convertPractitionerRole((org.hl7.fhir.r5.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r5.model.Procedure)
      return Procedure50_N.convertProcedure((org.hl7.fhir.r5.model.Procedure) src);
    if (src instanceof org.hl7.fhir.r5.model.Provenance)
      return Provenance50_N.convertProvenance((org.hl7.fhir.r5.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r5.model.Questionnaire)
      return Questionnaire50_N.convertQuestionnaire((org.hl7.fhir.r5.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r5.model.QuestionnaireResponse)
      return QuestionnaireResponse50_N.convertQuestionnaireResponse((org.hl7.fhir.r5.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.RelatedPerson)
      return RelatedPerson50_N.convertRelatedPerson((org.hl7.fhir.r5.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r5.model.RiskAssessment)
      return RiskAssessment50_N.convertRiskAssessment((org.hl7.fhir.r5.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r5.model.Schedule)
      return Schedule50_N.convertSchedule((org.hl7.fhir.r5.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r5.model.SearchParameter)
      return SearchParameter50_N.convertSearchParameter((org.hl7.fhir.r5.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r5.model.ServiceRequest)
      return ServiceRequest50_N.convertServiceRequest((org.hl7.fhir.r5.model.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.Slot) return Slot50_N.convertSlot((org.hl7.fhir.r5.model.Slot) src);
    if (src instanceof org.hl7.fhir.r5.model.Specimen)
      return Specimen50_N.convertSpecimen((org.hl7.fhir.r5.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r5.model.SpecimenDefinition)
      return SpecimenDefinition50_N.convertSpecimenDefinition((org.hl7.fhir.r5.model.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureDefinition)
      return StructureDefinition50_N.convertStructureDefinition((org.hl7.fhir.r5.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Substance)
      return Substance50_N.convertSubstance((org.hl7.fhir.r5.model.Substance) src);
    if (src instanceof org.hl7.fhir.r5.model.Task) return Task50_N.convertTask((org.hl7.fhir.r5.model.Task) src);
    if (src instanceof org.hl7.fhir.r5.model.TerminologyCapabilities)
      return TerminologyCapabilities50_N.convertTerminologyCapabilities((org.hl7.fhir.r5.model.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.r5.model.ValueSet)
      return ValueSet50_N.convertValueSet((org.hl7.fhir.r5.model.ValueSet) src);
    if (src instanceof org.hl7.fhir.r5.model.VisionPrescription)
      return VisionPrescription50_N.convertVisionPrescription((org.hl7.fhir.r5.model.VisionPrescription) src);
    if (src instanceof org.hl7.fhir.r5.model.Subscription)
      return Subscription50_N.convertSubscription((org.hl7.fhir.r5.model.Subscription) src);

    if (src instanceof org.hl7.fhir.r5.model.GraphDefinition)
      return GraphDefinition50_N.convertGraphDefinition((org.hl7.fhir.r5.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureMap)
      return StructureMap50_N.convertStructureMap((org.hl7.fhir.r5.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r5.model.TestReport)
      return TestReport50_N.convertTestReport((org.hl7.fhir.r5.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r5.model.TestScript)
      return TestScript50_N.convertTestScript((org.hl7.fhir.r5.model.TestScript) src);

    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R4 to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.model.core.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.model.core.Parameters)
      return Parameters50_N.convertParameters((org.hl7.fhir.model.core.Parameters) src);
    if (src instanceof org.hl7.fhir.model.core.Account)
      return Account50_N.convertAccount((org.hl7.fhir.model.core.Account) src);
    if (src instanceof org.hl7.fhir.model.core.ActivityDefinition)
      return ActivityDefinition50_N.convertActivityDefinition((org.hl7.fhir.model.core.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.AllergyIntolerance)
      return AllergyIntolerance50_N.convertAllergyIntolerance((org.hl7.fhir.model.core.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.model.core.ActorDefinition)
      return ActorDefinition50_N.convertActorDefinition((org.hl7.fhir.model.core.ActorDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.Appointment)
      return Appointment50_N.convertAppointment((org.hl7.fhir.model.core.Appointment) src);
    if (src instanceof org.hl7.fhir.model.core.AppointmentResponse)
      return AppointmentResponse50_N.convertAppointmentResponse((org.hl7.fhir.model.core.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.model.core.AuditEvent)
      return AuditEvent50_N.convertAuditEvent((org.hl7.fhir.model.core.AuditEvent) src);
    if (src instanceof org.hl7.fhir.model.core.Basic) return Basic50_N.convertBasic((org.hl7.fhir.model.core.Basic) src);
    if (src instanceof org.hl7.fhir.model.core.Binary)
      return Binary50_N.convertBinary((org.hl7.fhir.model.core.Binary) src);
    if (src instanceof org.hl7.fhir.model.core.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct50_N.convertBiologicallyDerivedProduct((org.hl7.fhir.model.core.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.model.core.BodyStructure)
      return BodyStructure50_N.convertBodyStructure((org.hl7.fhir.model.core.BodyStructure) src);
    if (src instanceof org.hl7.fhir.model.core.Bundle)
      return Bundle50_N.convertBundle((org.hl7.fhir.model.core.Bundle) src);
    if (src instanceof org.hl7.fhir.model.core.CapabilityStatement)
      return CapabilityStatement50_N.convertCapabilityStatement((org.hl7.fhir.model.core.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.model.core.CarePlan)
      return CarePlan50_N.convertCarePlan((org.hl7.fhir.model.core.CarePlan) src);
    if (src instanceof org.hl7.fhir.model.core.CareTeam)
      return CareTeam50_N.convertCareTeam((org.hl7.fhir.model.core.CareTeam) src);
    if (src instanceof org.hl7.fhir.model.core.Claim) return Claim50_N.convertClaim((org.hl7.fhir.model.core.Claim) src);
    if (src instanceof org.hl7.fhir.model.core.ClaimResponse)
      return ClaimResponse50_N.convertClaimResponse((org.hl7.fhir.model.core.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.model.core.CodeSystem)
      return CodeSystem50_N.convertCodeSystem((org.hl7.fhir.model.core.CodeSystem) src);
    if (src instanceof org.hl7.fhir.model.core.Communication)
      return Communication50_N.convertCommunication((org.hl7.fhir.model.core.Communication) src);
    if (src instanceof org.hl7.fhir.model.core.CommunicationRequest)
      return CommunicationRequest50_N.convertCommunicationRequest((org.hl7.fhir.model.core.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.model.core.CompartmentDefinition)
      return CompartmentDefinition50_N.convertCompartmentDefinition((org.hl7.fhir.model.core.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.Composition)
      return Composition50_N.convertComposition((org.hl7.fhir.model.core.Composition) src);
    if (src instanceof org.hl7.fhir.model.core.ConceptMap)
      return ConceptMap50_N.convertConceptMap((org.hl7.fhir.model.core.ConceptMap) src);
    if (src instanceof org.hl7.fhir.model.core.Condition)
      return Condition50_N.convertCondition((org.hl7.fhir.model.core.Condition) src);
    if (src instanceof org.hl7.fhir.model.core.Consent)
      return Consent50_N.convertConsent((org.hl7.fhir.model.core.Consent) src);
    if (src instanceof org.hl7.fhir.model.core.Coverage)
      return Coverage50_N.convertCoverage((org.hl7.fhir.model.core.Coverage) src);
    if (src instanceof org.hl7.fhir.model.core.CoverageEligibilityRequest)
      return CoverageEligibilityRequest50_N.convertCoverageEligibilityRequest((org.hl7.fhir.model.core.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.model.core.DetectedIssue)
      return DetectedIssue50_N.convertDetectedIssue((org.hl7.fhir.model.core.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.model.core.Device)
      return Device50_N.convertDevice((org.hl7.fhir.model.core.Device) src);
    if (src instanceof org.hl7.fhir.model.core.DeviceMetric)
      return DeviceMetric50_N.convertDeviceMetric((org.hl7.fhir.model.core.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.model.core.DeviceRequest)
      return DeviceRequest50_N.convertDeviceRequest((org.hl7.fhir.model.core.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.model.core.DiagnosticReport)
      return DiagnosticReport50_N.convertDiagnosticReport((org.hl7.fhir.model.core.DiagnosticReport) src);
//    if (src instanceof org.hl7.fhir.model.core.DocumentManifest)
//      return DocumentManifest50_N.convertDocumentManifest((org.hl7.fhir.model.core.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.model.core.DocumentReference)
      return DocumentReference50_N.convertDocumentReference((org.hl7.fhir.model.core.DocumentReference) src);
    if (src instanceof org.hl7.fhir.model.core.Encounter)
      return Encounter50_N.convertEncounter((org.hl7.fhir.model.core.Encounter) src);
    if (src instanceof org.hl7.fhir.model.core.Endpoint)
      return Endpoint50_N.convertEndpoint((org.hl7.fhir.model.core.Endpoint) src);
    if (src instanceof org.hl7.fhir.model.core.EpisodeOfCare)
      return EpisodeOfCare50_N.convertEpisodeOfCare((org.hl7.fhir.model.core.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.model.core.EventDefinition)
      return EventDefinition50_N.convertEventDefinition((org.hl7.fhir.model.core.EventDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.ExampleScenario)
      return ExampleScenario50_N.convertExampleScenario((org.hl7.fhir.model.core.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.model.core.ExplanationOfBenefit)
      return ExplanationOfBenefit50_N.convertExplanationOfBenefit((org.hl7.fhir.model.core.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.model.core.FamilyMemberHistory)
      return FamilyMemberHistory50_N.convertFamilyMemberHistory((org.hl7.fhir.model.core.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.model.core.Flag) return Flag50_N.convertFlag((org.hl7.fhir.model.core.Flag) src);
    if (src instanceof org.hl7.fhir.model.core.Goal) return Goal50_N.convertGoal((org.hl7.fhir.model.core.Goal) src);
    if (src instanceof org.hl7.fhir.model.core.Group) return Group50_N.convertGroup((org.hl7.fhir.model.core.Group) src);
    if (src instanceof org.hl7.fhir.model.core.GuidanceResponse)
      return GuidanceResponse50_N.convertGuidanceResponse((org.hl7.fhir.model.core.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.model.core.HealthcareService)
      return HealthcareService50_N.convertHealthcareService((org.hl7.fhir.model.core.HealthcareService) src);
    if (src instanceof org.hl7.fhir.model.core.ImagingStudy)
      return ImagingStudy50_N.convertImagingStudy((org.hl7.fhir.model.core.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.model.core.Immunization)
      return Immunization50_N.convertImmunization((org.hl7.fhir.model.core.Immunization) src);
    if (src instanceof org.hl7.fhir.model.core.ImplementationGuide)
      return ImplementationGuide50_N.convertImplementationGuide((org.hl7.fhir.model.core.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.model.core.Library)
      return Library50_N.convertLibrary((org.hl7.fhir.model.core.Library) src);
    if (src instanceof org.hl7.fhir.model.core.ListResource)
      return List50_N.convertList((org.hl7.fhir.model.core.ListResource) src);
    if (src instanceof org.hl7.fhir.model.core.Location)
      return Location50_N.convertLocation((org.hl7.fhir.model.core.Location) src);
    if (src instanceof org.hl7.fhir.model.core.Measure)
      return Measure50_N.convertMeasure((org.hl7.fhir.model.core.Measure) src);
    if (src instanceof org.hl7.fhir.model.core.MeasureReport)
      return MeasureReport50_N.convertMeasureReport((org.hl7.fhir.model.core.MeasureReport) src);
    if (src instanceof org.hl7.fhir.model.core.DocumentReference)
      return DocumentReference50_N.convertDocumentReference((org.hl7.fhir.model.core.DocumentReference) src);
    if (src instanceof org.hl7.fhir.model.core.Medication)
      return Medication50_N.convertMedication((org.hl7.fhir.model.core.Medication) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationAdministration)
      return MedicationAdministration50_N.convertMedicationAdministration((org.hl7.fhir.model.core.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationDispense)
      return MedicationDispense50_N.convertMedicationDispense((org.hl7.fhir.model.core.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationRequest)
      return MedicationRequest50_N.convertMedicationRequest((org.hl7.fhir.model.core.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.model.core.MedicationStatement)
      return MedicationStatement50_N.convertMedicationStatement((org.hl7.fhir.model.core.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.model.core.MessageDefinition)
      return MessageDefinition50_N.convertMessageDefinition((org.hl7.fhir.model.core.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.MessageHeader)
      return MessageHeader50_N.convertMessageHeader((org.hl7.fhir.model.core.MessageHeader) src);
    if (src instanceof org.hl7.fhir.model.core.NamingSystem)
      return NamingSystem50_N.convertNamingSystem((org.hl7.fhir.model.core.NamingSystem) src);
    if (src instanceof org.hl7.fhir.model.core.NutritionOrder)
      return NutritionOrder50_N.convertNutritionOrder((org.hl7.fhir.model.core.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.model.core.Observation)
      return Observation50_N.convertObservation((org.hl7.fhir.model.core.Observation) src);
    if (src instanceof org.hl7.fhir.model.core.ObservationDefinition)
      return ObservationDefinition50_N.convertObservationDefinition((org.hl7.fhir.model.core.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.OperationDefinition)
      return OperationDefinition50_N.convertOperationDefinition((org.hl7.fhir.model.core.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.OperationOutcome)
      return OperationOutcome50_N.convertOperationOutcome((org.hl7.fhir.model.core.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.model.core.Organization)
      return Organization50_N.convertOrganization((org.hl7.fhir.model.core.Organization) src);
    if (src instanceof org.hl7.fhir.model.core.OrganizationAffiliation)
      return OrganizationAffiliation50_N.convertOrganizationAffiliation((org.hl7.fhir.model.core.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.model.core.Patient)
      return Patient50_N.convertPatient((org.hl7.fhir.model.core.Patient) src);
    if (src instanceof org.hl7.fhir.model.core.PaymentNotice)
      return PaymentNotice50_N.convertPaymentNotice((org.hl7.fhir.model.core.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.model.core.Person)
      return Person50_N.convertPerson((org.hl7.fhir.model.core.Person) src);
    if (src instanceof org.hl7.fhir.model.core.PlanDefinition)
      return PlanDefinition50_N.convertPlanDefinition((org.hl7.fhir.model.core.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.Practitioner)
      return Practitioner50_N.convertPractitioner((org.hl7.fhir.model.core.Practitioner) src);
    if (src instanceof org.hl7.fhir.model.core.PractitionerRole)
      return PractitionerRole50_N.convertPractitionerRole((org.hl7.fhir.model.core.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.model.core.Procedure)
      return Procedure50_N.convertProcedure((org.hl7.fhir.model.core.Procedure) src);
    if (src instanceof org.hl7.fhir.model.core.Provenance)
      return Provenance50_N.convertProvenance((org.hl7.fhir.model.core.Provenance) src);
    if (src instanceof org.hl7.fhir.model.core.Questionnaire)
      return Questionnaire50_N.convertQuestionnaire((org.hl7.fhir.model.core.Questionnaire) src);
    if (src instanceof org.hl7.fhir.model.core.QuestionnaireResponse)
      return QuestionnaireResponse50_N.convertQuestionnaireResponse((org.hl7.fhir.model.core.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.model.core.RelatedPerson)
      return RelatedPerson50_N.convertRelatedPerson((org.hl7.fhir.model.core.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.model.core.Requirements)
      return Requirements50_N.convertRequirements((org.hl7.fhir.model.core.Requirements) src);
    if (src instanceof org.hl7.fhir.model.core.RiskAssessment)
      return RiskAssessment50_N.convertRiskAssessment((org.hl7.fhir.model.core.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.model.core.Schedule)
      return Schedule50_N.convertSchedule((org.hl7.fhir.model.core.Schedule) src);
    if (src instanceof org.hl7.fhir.model.core.SearchParameter)
      return SearchParameter50_N.convertSearchParameter((org.hl7.fhir.model.core.SearchParameter) src);
    if (src instanceof org.hl7.fhir.model.core.ServiceRequest)
      return ServiceRequest50_N.convertServiceRequest((org.hl7.fhir.model.core.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.model.core.Slot) return Slot50_N.convertSlot((org.hl7.fhir.model.core.Slot) src);
    if (src instanceof org.hl7.fhir.model.core.Specimen)
      return Specimen50_N.convertSpecimen((org.hl7.fhir.model.core.Specimen) src);
    if (src instanceof org.hl7.fhir.model.core.SpecimenDefinition)
      return SpecimenDefinition50_N.convertSpecimenDefinition((org.hl7.fhir.model.core.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.StructureDefinition)
      return StructureDefinition50_N.convertStructureDefinition((org.hl7.fhir.model.core.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.model.core.SubscriptionTopic)
      return SubscriptionTopic50_N.convertSubscriptionTopic((org.hl7.fhir.model.core.SubscriptionTopic) src);
    if (src instanceof org.hl7.fhir.model.core.Substance)
      return Substance50_N.convertSubstance((org.hl7.fhir.model.core.Substance) src);
    if (src instanceof org.hl7.fhir.model.core.Task) return Task50_N.convertTask((org.hl7.fhir.model.core.Task) src);
    if (src instanceof org.hl7.fhir.model.core.TerminologyCapabilities)
      return TerminologyCapabilities50_N.convertTerminologyCapabilities((org.hl7.fhir.model.core.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.model.core.ValueSet)
      return ValueSet50_N.convertValueSet((org.hl7.fhir.model.core.ValueSet) src);
    if (src instanceof org.hl7.fhir.model.core.VisionPrescription)
      return VisionPrescription50_N.convertVisionPrescription((org.hl7.fhir.model.core.VisionPrescription) src);
    if (src instanceof org.hl7.fhir.model.core.Subscription)
      return Subscription50_N.convertSubscription((org.hl7.fhir.model.core.Subscription) src);

    if (src instanceof org.hl7.fhir.model.api.GraphDefinition)
      return GraphDefinition50_N.convertGraphDefinition((org.hl7.fhir.model.api.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.model.fml.StructureMap)
      return StructureMap50_N.convertStructureMap((org.hl7.fhir.model.fml.StructureMap) src);
//    if (src instanceof org.hl7.fhir.model.testing.TestPlan)
//      return TestPlan50_N.convertTestPlan((org.hl7.fhir.model.testing.TestPlan) src);
    if (src instanceof org.hl7.fhir.model.testing.TestReport)
      return TestReport50_N.convertTestReport((org.hl7.fhir.model.testing.TestReport) src);
    if (src instanceof org.hl7.fhir.model.testing.TestScript)
      return TestScript50_N.convertTestScript((org.hl7.fhir.model.testing.TestScript) src);

    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R5 to R4");
    } else {
      return null;
    }
  }

  public void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.model.core.DomainResource tgt, String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative50_N.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext50_N.INSTANCE.path(), extension)) {
        org.hl7.fhir.model.core.Extension convertExtension = new org.hl7.fhir.model.core.Extension();
        advisor.handleExtension(ConversionContext50_N.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext50_N.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension50_N.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext50_N.INSTANCE.path(), extension))
      .map(Extension50_N::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public void copyDomainResource(org.hl7.fhir.model.core.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt,  String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative50_N.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext50_N.INSTANCE.path(), extension)) {
        org.hl7.fhir.r5.model.Extension convertExtension = new org.hl7.fhir.r5.model.Extension();
        advisor.handleExtension(ConversionContext50_N.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext50_N.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension50_N.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext50_N.INSTANCE.path(), extension))
      .map(Extension50_N::convertExtension)
      .forEach(tgt::addModifierExtension);
  }
}
