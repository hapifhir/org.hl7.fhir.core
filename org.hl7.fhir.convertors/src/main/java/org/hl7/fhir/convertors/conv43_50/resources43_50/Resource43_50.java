package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_43_50;
import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Id43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Extension43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Meta43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Narrative43_50;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.Arrays;

public class Resource43_50 {

  public final BaseAdvisor_43_50 advisor;

  public Resource43_50(BaseAdvisor_43_50 advisor) {
    this.advisor = advisor;
  }

  public void copyResource(org.hl7.fhir.r4b.model.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id43_50.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta43_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRulesElement(Uri43_50.convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_50.convertCode(src.getLanguageElement()));
  }

  public void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.r4b.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id43_50.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta43_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRulesElement(Uri43_50.convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code43_50.convertCode(src.getLanguageElement()));
  }

  public org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.r4b.model.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.r4b.model.Parameters)
      return Parameters43_50.convertParameters((org.hl7.fhir.r4b.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r4b.model.Account)
      return Account43_50.convertAccount((org.hl7.fhir.r4b.model.Account) src);
    if (src instanceof org.hl7.fhir.r4b.model.ActivityDefinition)
      return ActivityDefinition43_50.convertActivityDefinition((org.hl7.fhir.r4b.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.AllergyIntolerance)
      return AllergyIntolerance43_50.convertAllergyIntolerance((org.hl7.fhir.r4b.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r4b.model.Appointment)
      return Appointment43_50.convertAppointment((org.hl7.fhir.r4b.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r4b.model.AppointmentResponse)
      return AppointmentResponse43_50.convertAppointmentResponse((org.hl7.fhir.r4b.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r4b.model.AuditEvent)
      return AuditEvent43_50.convertAuditEvent((org.hl7.fhir.r4b.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r4b.model.Basic) {
      org.hl7.fhir.r4b.model.Basic basic = (org.hl7.fhir.r4b.model.Basic) src;
      if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "ActorDefinition")) {
        return ActorDefinition43_50.convertActorDefinition((org.hl7.fhir.r4b.model.Basic) src);
      } else if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "Requirements")) {
        return Requirements43_50.convertRequirements((org.hl7.fhir.r4b.model.Basic) src);
      } else {
        return Basic43_50.convertBasic((org.hl7.fhir.r4b.model.Basic) src);
      }
    }
    if (src instanceof org.hl7.fhir.r4b.model.Binary)
      return Binary43_50.convertBinary((org.hl7.fhir.r4b.model.Binary) src);
    if (src instanceof org.hl7.fhir.r4b.model.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct43_50.convertBiologicallyDerivedProduct((org.hl7.fhir.r4b.model.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.r4b.model.BodyStructure)
      return BodyStructure43_50.convertBodyStructure((org.hl7.fhir.r4b.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r4b.model.Bundle)
      return Bundle43_50.convertBundle((org.hl7.fhir.r4b.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r4b.model.CapabilityStatement)
      return CapabilityStatement43_50.convertCapabilityStatement((org.hl7.fhir.r4b.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r4b.model.CarePlan)
      return CarePlan43_50.convertCarePlan((org.hl7.fhir.r4b.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r4b.model.CareTeam)
      return CareTeam43_50.convertCareTeam((org.hl7.fhir.r4b.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r4b.model.ChargeItem)
      return ChargeItem43_50.convertChargeItem((org.hl7.fhir.r4b.model.ChargeItem) src);
    if (src instanceof org.hl7.fhir.r4b.model.ChargeItemDefinition)
      return ChargeItemDefinition43_50.convertChargeItemDefinition((org.hl7.fhir.r4b.model.ChargeItemDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.Claim) return Claim43_50.convertClaim((org.hl7.fhir.r4b.model.Claim) src);
    if (src instanceof org.hl7.fhir.r4b.model.ClaimResponse)
      return ClaimResponse43_50.convertClaimResponse((org.hl7.fhir.r4b.model.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.r4b.model.ClinicalImpression)
      return ClinicalImpression43_50.convertClinicalImpression((org.hl7.fhir.r4b.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.r4b.model.CodeSystem)
      return CodeSystem43_50.convertCodeSystem((org.hl7.fhir.r4b.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r4b.model.Communication)
      return Communication43_50.convertCommunication((org.hl7.fhir.r4b.model.Communication) src);
    if (src instanceof org.hl7.fhir.r4b.model.CommunicationRequest)
      return CommunicationRequest43_50.convertCommunicationRequest((org.hl7.fhir.r4b.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.CompartmentDefinition)
      return CompartmentDefinition43_50.convertCompartmentDefinition((org.hl7.fhir.r4b.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.Composition)
      return Composition43_50.convertComposition((org.hl7.fhir.r4b.model.Composition) src);
    if (src instanceof org.hl7.fhir.r4b.model.ConceptMap)
      return ConceptMap43_50.convertConceptMap((org.hl7.fhir.r4b.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r4b.model.Condition)
      return Condition43_50.convertCondition((org.hl7.fhir.r4b.model.Condition) src);
    if (src instanceof org.hl7.fhir.r4b.model.Consent)
      return Consent43_50.convertConsent((org.hl7.fhir.r4b.model.Consent) src);
    if (src instanceof org.hl7.fhir.r4b.model.Contract)
      return Contract43_50.convertContract((org.hl7.fhir.r4b.model.Contract) src);
    if (src instanceof org.hl7.fhir.r4b.model.Coverage)
      return Coverage43_50.convertCoverage((org.hl7.fhir.r4b.model.Coverage) src);
    if (src instanceof org.hl7.fhir.r4b.model.CoverageEligibilityRequest)
      return CoverageEligibilityRequest43_50.convertCoverageEligibilityRequest((org.hl7.fhir.r4b.model.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.DetectedIssue)
      return DetectedIssue43_50.convertDetectedIssue((org.hl7.fhir.r4b.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r4b.model.Device)
      return Device43_50.convertDevice((org.hl7.fhir.r4b.model.Device) src);
    if (src instanceof org.hl7.fhir.r4b.model.DeviceDefinition)
      return DeviceDefinition43_50.convertDeviceDefinition((org.hl7.fhir.r4b.model.DeviceDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.DeviceMetric)
      return DeviceMetric43_50.convertDeviceMetric((org.hl7.fhir.r4b.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.r4b.model.DeviceRequest)
      return DeviceRequest43_50.convertDeviceRequest((org.hl7.fhir.r4b.model.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.DeviceUseStatement)
      return DeviceUseStatement43_50.convertDeviceUseStatement((org.hl7.fhir.r4b.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.r4b.model.DiagnosticReport)
      return DiagnosticReport43_50.convertDiagnosticReport((org.hl7.fhir.r4b.model.DiagnosticReport) src);
//    if (src instanceof org.hl7.fhir.r4b.model.DocumentManifest)
//      return DocumentManifest43_50.convertDocumentManifest((org.hl7.fhir.r4b.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.r4b.model.DocumentReference)
      return DocumentReference43_50.convertDocumentReference((org.hl7.fhir.r4b.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r4b.model.Encounter)
      return Encounter43_50.convertEncounter((org.hl7.fhir.r4b.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r4b.model.Endpoint)
      return Endpoint43_50.convertEndpoint((org.hl7.fhir.r4b.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r4b.model.EnrollmentRequest)
      return EnrollmentRequest43_50.convertEnrollmentRequest((org.hl7.fhir.r4b.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.EpisodeOfCare)
      return EpisodeOfCare43_50.convertEpisodeOfCare((org.hl7.fhir.r4b.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r4b.model.EventDefinition)
      return EventDefinition43_50.convertEventDefinition((org.hl7.fhir.r4b.model.EventDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.ExampleScenario)
      return ExampleScenario43_50.convertExampleScenario((org.hl7.fhir.r4b.model.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.r4b.model.ExplanationOfBenefit)
      return ExplanationOfBenefit43_50.convertExplanationOfBenefit((org.hl7.fhir.r4b.model.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.r4b.model.FamilyMemberHistory)
      return FamilyMemberHistory43_50.convertFamilyMemberHistory((org.hl7.fhir.r4b.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r4b.model.Flag) return Flag43_50.convertFlag((org.hl7.fhir.r4b.model.Flag) src);
    if (src instanceof org.hl7.fhir.r4b.model.Goal) return Goal43_50.convertGoal((org.hl7.fhir.r4b.model.Goal) src);
    if (src instanceof org.hl7.fhir.r4b.model.GraphDefinition)
      return GraphDefinition43_50.convertGraphDefinition((org.hl7.fhir.r4b.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.Group) return Group43_50.convertGroup((org.hl7.fhir.r4b.model.Group) src);
    if (src instanceof org.hl7.fhir.r4b.model.GuidanceResponse)
      return GuidanceResponse43_50.convertGuidanceResponse((org.hl7.fhir.r4b.model.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.r4b.model.HealthcareService)
      return HealthcareService43_50.convertHealthcareService((org.hl7.fhir.r4b.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r4b.model.ImagingStudy)
      return ImagingStudy43_50.convertImagingStudy((org.hl7.fhir.r4b.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r4b.model.Immunization)
      return Immunization43_50.convertImmunization((org.hl7.fhir.r4b.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r4b.model.ImmunizationEvaluation)
      return ImmunizationEvaluation43_50.convertImmunizationEvaluation((org.hl7.fhir.r4b.model.ImmunizationEvaluation) src);
    if (src instanceof org.hl7.fhir.r4b.model.ImmunizationRecommendation)
      return ImmunizationRecommendation43_50.convertImmunizationRecommendation((org.hl7.fhir.r4b.model.ImmunizationRecommendation) src);
    if (src instanceof org.hl7.fhir.r4b.model.ImplementationGuide)
      return ImplementationGuide43_50.convertImplementationGuide((org.hl7.fhir.r4b.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r4b.model.InsurancePlan)
      return InsurancePlan43_50.convertInsurancePlan((org.hl7.fhir.r4b.model.InsurancePlan) src);
    if (src instanceof org.hl7.fhir.r4b.model.Invoice)
      return Invoice43_50.convertInvoice((org.hl7.fhir.r4b.model.Invoice) src);
    if (src instanceof org.hl7.fhir.r4b.model.Library)
      return Library43_50.convertLibrary((org.hl7.fhir.r4b.model.Library) src);
    if (src instanceof org.hl7.fhir.r4b.model.Linkage)
      return Linkage43_50.convertLinkage((org.hl7.fhir.r4b.model.Linkage) src);
    if (src instanceof org.hl7.fhir.r4b.model.ListResource)
      return ListResource43_50.convertListResource((org.hl7.fhir.r4b.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r4b.model.Location)
      return Location43_50.convertLocation((org.hl7.fhir.r4b.model.Location) src);
    if (src instanceof org.hl7.fhir.r4b.model.Measure)
      return Measure43_50.convertMeasure((org.hl7.fhir.r4b.model.Measure) src);
    if (src instanceof org.hl7.fhir.r4b.model.MeasureReport)
      return MeasureReport43_50.convertMeasureReport((org.hl7.fhir.r4b.model.MeasureReport) src);
    if (src instanceof org.hl7.fhir.r4b.model.Media) return Media43_50.convertMedia((org.hl7.fhir.r4b.model.Media) src);
    if (src instanceof org.hl7.fhir.r4b.model.Medication)
      return Medication43_50.convertMedication((org.hl7.fhir.r4b.model.Medication) src);
    if (src instanceof org.hl7.fhir.r4b.model.MedicationAdministration)
      return MedicationAdministration43_50.convertMedicationAdministration((org.hl7.fhir.r4b.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r4b.model.MedicationDispense)
      return MedicationDispense43_50.convertMedicationDispense((org.hl7.fhir.r4b.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r4b.model.MedicationKnowledge)
      return MedicationKnowledge43_50.convertMedicationKnowledge((org.hl7.fhir.r4b.model.MedicationKnowledge) src);
    if (src instanceof org.hl7.fhir.r4b.model.MedicationRequest)
      return MedicationRequest43_50.convertMedicationRequest((org.hl7.fhir.r4b.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.MedicationStatement)
      return MedicationStatement43_50.convertMedicationStatement((org.hl7.fhir.r4b.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r4b.model.MessageDefinition)
      return MessageDefinition43_50.convertMessageDefinition((org.hl7.fhir.r4b.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.MessageHeader)
      return MessageHeader43_50.convertMessageHeader((org.hl7.fhir.r4b.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r4b.model.NamingSystem)
      return NamingSystem43_50.convertNamingSystem((org.hl7.fhir.r4b.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r4b.model.NutritionOrder)
      return NutritionOrder43_50.convertNutritionOrder((org.hl7.fhir.r4b.model.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.r4b.model.Observation)
      return Observation43_50.convertObservation((org.hl7.fhir.r4b.model.Observation) src);
    if (src instanceof org.hl7.fhir.r4b.model.ObservationDefinition)
      return ObservationDefinition43_50.convertObservationDefinition((org.hl7.fhir.r4b.model.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.OperationDefinition)
      return OperationDefinition43_50.convertOperationDefinition((org.hl7.fhir.r4b.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.OperationOutcome)
      return OperationOutcome43_50.convertOperationOutcome((org.hl7.fhir.r4b.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r4b.model.Organization)
      return Organization43_50.convertOrganization((org.hl7.fhir.r4b.model.Organization) src);
    if (src instanceof org.hl7.fhir.r4b.model.OrganizationAffiliation)
      return OrganizationAffiliation43_50.convertOrganizationAffiliation((org.hl7.fhir.r4b.model.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.r4b.model.Patient)
      return Patient43_50.convertPatient((org.hl7.fhir.r4b.model.Patient) src);
    if (src instanceof org.hl7.fhir.r4b.model.PaymentNotice)
      return PaymentNotice43_50.convertPaymentNotice((org.hl7.fhir.r4b.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r4b.model.Person)
      return Person43_50.convertPerson((org.hl7.fhir.r4b.model.Person) src);
    if (src instanceof org.hl7.fhir.r4b.model.PlanDefinition)
      return PlanDefinition43_50.convertPlanDefinition((org.hl7.fhir.r4b.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.Practitioner)
      return Practitioner43_50.convertPractitioner((org.hl7.fhir.r4b.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r4b.model.PractitionerRole)
      return PractitionerRole43_50.convertPractitionerRole((org.hl7.fhir.r4b.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r4b.model.Procedure)
      return Procedure43_50.convertProcedure((org.hl7.fhir.r4b.model.Procedure) src);
    if (src instanceof org.hl7.fhir.r4b.model.Provenance)
      return Provenance43_50.convertProvenance((org.hl7.fhir.r4b.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r4b.model.Questionnaire)
      return Questionnaire43_50.convertQuestionnaire((org.hl7.fhir.r4b.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r4b.model.QuestionnaireResponse)
      return QuestionnaireResponse43_50.convertQuestionnaireResponse((org.hl7.fhir.r4b.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r4b.model.RelatedPerson)
      return RelatedPerson43_50.convertRelatedPerson((org.hl7.fhir.r4b.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r4b.model.RiskAssessment)
      return RiskAssessment43_50.convertRiskAssessment((org.hl7.fhir.r4b.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r4b.model.Schedule)
      return Schedule43_50.convertSchedule((org.hl7.fhir.r4b.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r4b.model.SearchParameter)
      return SearchParameter43_50.convertSearchParameter((org.hl7.fhir.r4b.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r4b.model.ServiceRequest)
      return ServiceRequest43_50.convertServiceRequest((org.hl7.fhir.r4b.model.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.Slot) return Slot43_50.convertSlot((org.hl7.fhir.r4b.model.Slot) src);
    if (src instanceof org.hl7.fhir.r4b.model.Specimen)
      return Specimen43_50.convertSpecimen((org.hl7.fhir.r4b.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r4b.model.SpecimenDefinition)
      return SpecimenDefinition43_50.convertSpecimenDefinition((org.hl7.fhir.r4b.model.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.StructureDefinition)
      return StructureDefinition43_50.convertStructureDefinition((org.hl7.fhir.r4b.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r4b.model.StructureMap)
      return StructureMap43_50.convertStructureMap((org.hl7.fhir.r4b.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r4b.model.SubscriptionStatus)
      return SubscriptionStatus43_50.convertSubscriptionStatus((org.hl7.fhir.r4b.model.SubscriptionStatus)src);
    if (src instanceof org.hl7.fhir.r4b.model.SubscriptionTopic)
      return SubscriptionTopic43_50.convertSubscriptionTopic((org.hl7.fhir.r4b.model.SubscriptionTopic)src);
    if (src instanceof org.hl7.fhir.r4b.model.Substance)
      return Substance43_50.convertSubstance((org.hl7.fhir.r4b.model.Substance) src);
    if (src instanceof org.hl7.fhir.r4b.model.SupplyDelivery)
      return SupplyDelivery43_50.convertSupplyDelivery((org.hl7.fhir.r4b.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.r4b.model.SupplyRequest)
      return SupplyRequest43_50.convertSupplyRequest((org.hl7.fhir.r4b.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.r4b.model.Task) return Task43_50.convertTask((org.hl7.fhir.r4b.model.Task) src);
    if (src instanceof org.hl7.fhir.r4b.model.TerminologyCapabilities)
      return TerminologyCapabilities43_50.convertTerminologyCapabilities((org.hl7.fhir.r4b.model.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.r4b.model.TestReport)
      return TestReport43_50.convertTestReport((org.hl7.fhir.r4b.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r4b.model.TestScript)
      return TestScript43_50.convertTestScript((org.hl7.fhir.r4b.model.TestScript) src);
    if (src instanceof org.hl7.fhir.r4b.model.ValueSet)
      return ValueSet43_50.convertValueSet((org.hl7.fhir.r4b.model.ValueSet) src);
    if (src instanceof org.hl7.fhir.r4b.model.VerificationResult)
      return VerificationResult43_50.convertVerificationResult((org.hl7.fhir.r4b.model.VerificationResult) src);
    if (src instanceof org.hl7.fhir.r4b.model.VisionPrescription)
      return VisionPrescription43_50.convertVisionPrescription((org.hl7.fhir.r4b.model.VisionPrescription) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R4B to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.r4b.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.r5.model.Parameters)
      return Parameters43_50.convertParameters((org.hl7.fhir.r5.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r5.model.Account)
      return Account43_50.convertAccount((org.hl7.fhir.r5.model.Account) src);
    if (src instanceof org.hl7.fhir.r5.model.ActivityDefinition)
      return ActivityDefinition43_50.convertActivityDefinition((org.hl7.fhir.r5.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.ActorDefinition)
      return ActorDefinition43_50.convertActorDefinition((org.hl7.fhir.r5.model.ActorDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.AllergyIntolerance)
      return AllergyIntolerance43_50.convertAllergyIntolerance((org.hl7.fhir.r5.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r5.model.Appointment)
      return Appointment43_50.convertAppointment((org.hl7.fhir.r5.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r5.model.AppointmentResponse)
      return AppointmentResponse43_50.convertAppointmentResponse((org.hl7.fhir.r5.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.AuditEvent)
      return AuditEvent43_50.convertAuditEvent((org.hl7.fhir.r5.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r5.model.Basic) return Basic43_50.convertBasic((org.hl7.fhir.r5.model.Basic) src);
    if (src instanceof org.hl7.fhir.r5.model.Binary)
      return Binary43_50.convertBinary((org.hl7.fhir.r5.model.Binary) src);
    if (src instanceof org.hl7.fhir.r5.model.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct43_50.convertBiologicallyDerivedProduct((org.hl7.fhir.r5.model.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.r5.model.BodyStructure)
      return BodyStructure43_50.convertBodyStructure((org.hl7.fhir.r5.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r5.model.Bundle)
      return Bundle43_50.convertBundle((org.hl7.fhir.r5.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r5.model.CapabilityStatement)
      return CapabilityStatement43_50.convertCapabilityStatement((org.hl7.fhir.r5.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.CarePlan)
      return CarePlan43_50.convertCarePlan((org.hl7.fhir.r5.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r5.model.CareTeam)
      return CareTeam43_50.convertCareTeam((org.hl7.fhir.r5.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r5.model.ChargeItem)
      return ChargeItem43_50.convertChargeItem((org.hl7.fhir.r5.model.ChargeItem) src);
    if (src instanceof org.hl7.fhir.r5.model.ChargeItemDefinition)
      return ChargeItemDefinition43_50.convertChargeItemDefinition((org.hl7.fhir.r5.model.ChargeItemDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Claim) return Claim43_50.convertClaim((org.hl7.fhir.r5.model.Claim) src);
    if (src instanceof org.hl7.fhir.r5.model.ClaimResponse)
      return ClaimResponse43_50.convertClaimResponse((org.hl7.fhir.r5.model.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.ClinicalImpression)
      return ClinicalImpression43_50.convertClinicalImpression((org.hl7.fhir.r5.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeSystem)
      return CodeSystem43_50.convertCodeSystem((org.hl7.fhir.r5.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.Communication)
      return Communication43_50.convertCommunication((org.hl7.fhir.r5.model.Communication) src);
    if (src instanceof org.hl7.fhir.r5.model.CommunicationRequest)
      return CommunicationRequest43_50.convertCommunicationRequest((org.hl7.fhir.r5.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.CompartmentDefinition)
      return CompartmentDefinition43_50.convertCompartmentDefinition((org.hl7.fhir.r5.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Composition)
      return Composition43_50.convertComposition((org.hl7.fhir.r5.model.Composition) src);
    if (src instanceof org.hl7.fhir.r5.model.ConceptMap)
      return ConceptMap43_50.convertConceptMap((org.hl7.fhir.r5.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r5.model.Condition)
      return Condition43_50.convertCondition((org.hl7.fhir.r5.model.Condition) src);
    if (src instanceof org.hl7.fhir.r5.model.Consent)
      return Consent43_50.convertConsent((org.hl7.fhir.r5.model.Consent) src);
    if (src instanceof org.hl7.fhir.r5.model.Contract)
      return Contract43_50.convertContract((org.hl7.fhir.r5.model.Contract) src);
    if (src instanceof org.hl7.fhir.r5.model.Coverage)
      return Coverage43_50.convertCoverage((org.hl7.fhir.r5.model.Coverage) src);
    if (src instanceof org.hl7.fhir.r5.model.CoverageEligibilityRequest)
      return CoverageEligibilityRequest43_50.convertCoverageEligibilityRequest((org.hl7.fhir.r5.model.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.DetectedIssue)
      return DetectedIssue43_50.convertDetectedIssue((org.hl7.fhir.r5.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r5.model.Device)
      return Device43_50.convertDevice((org.hl7.fhir.r5.model.Device) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceDefinition)
      return DeviceDefinition43_50.convertDeviceDefinition((org.hl7.fhir.r5.model.DeviceDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceMetric)
      return DeviceMetric43_50.convertDeviceMetric((org.hl7.fhir.r5.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceRequest)
      return DeviceRequest43_50.convertDeviceRequest((org.hl7.fhir.r5.model.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceUsage)
      return DeviceUseStatement43_50.convertDeviceUseStatement((org.hl7.fhir.r5.model.DeviceUsage) src);
    if (src instanceof org.hl7.fhir.r5.model.DiagnosticReport)
      return DiagnosticReport43_50.convertDiagnosticReport((org.hl7.fhir.r5.model.DiagnosticReport) src);
//    if (src instanceof org.hl7.fhir.r5.model.DocumentManifest)
//      return DocumentManifest43_50.convertDocumentManifest((org.hl7.fhir.r5.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
      return DocumentReference43_50.convertDocumentReference((org.hl7.fhir.r5.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r5.model.Encounter)
      return Encounter43_50.convertEncounter((org.hl7.fhir.r5.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r5.model.Endpoint)
      return Endpoint43_50.convertEndpoint((org.hl7.fhir.r5.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r5.model.EnrollmentRequest)
      return EnrollmentRequest43_50.convertEnrollmentRequest((org.hl7.fhir.r5.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.EpisodeOfCare)
      return EpisodeOfCare43_50.convertEpisodeOfCare((org.hl7.fhir.r5.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r5.model.EventDefinition)
      return EventDefinition43_50.convertEventDefinition((org.hl7.fhir.r5.model.EventDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.ExampleScenario)
      return ExampleScenario43_50.convertExampleScenario((org.hl7.fhir.r5.model.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.r5.model.ExplanationOfBenefit)
      return ExplanationOfBenefit43_50.convertExplanationOfBenefit((org.hl7.fhir.r5.model.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.r5.model.FamilyMemberHistory)
      return FamilyMemberHistory43_50.convertFamilyMemberHistory((org.hl7.fhir.r5.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r5.model.Flag) return Flag43_50.convertFlag((org.hl7.fhir.r5.model.Flag) src);
    if (src instanceof org.hl7.fhir.r5.model.Goal) return Goal43_50.convertGoal((org.hl7.fhir.r5.model.Goal) src);
    if (src instanceof org.hl7.fhir.r5.model.GraphDefinition)
      return GraphDefinition43_50.convertGraphDefinition((org.hl7.fhir.r5.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Group) return Group43_50.convertGroup((org.hl7.fhir.r5.model.Group) src);
    if (src instanceof org.hl7.fhir.r5.model.GuidanceResponse)
      return GuidanceResponse43_50.convertGuidanceResponse((org.hl7.fhir.r5.model.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.HealthcareService)
      return HealthcareService43_50.convertHealthcareService((org.hl7.fhir.r5.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r5.model.ImagingStudy)
      return ImagingStudy43_50.convertImagingStudy((org.hl7.fhir.r5.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r5.model.Immunization)
      return Immunization43_50.convertImmunization((org.hl7.fhir.r5.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r5.model.ImmunizationEvaluation)
      return ImmunizationEvaluation43_50.convertImmunizationEvaluation((org.hl7.fhir.r5.model.ImmunizationEvaluation) src);
    if (src instanceof org.hl7.fhir.r5.model.ImmunizationRecommendation)
      return ImmunizationRecommendation43_50.convertImmunizationRecommendation((org.hl7.fhir.r5.model.ImmunizationRecommendation) src);
    if (src instanceof org.hl7.fhir.r5.model.ImplementationGuide)
      return ImplementationGuide43_50.convertImplementationGuide((org.hl7.fhir.r5.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r5.model.InsurancePlan)
      return InsurancePlan43_50.convertInsurancePlan((org.hl7.fhir.r5.model.InsurancePlan) src);
    if (src instanceof org.hl7.fhir.r5.model.Invoice)
      return Invoice43_50.convertInvoice((org.hl7.fhir.r5.model.Invoice) src);
    if (src instanceof org.hl7.fhir.r5.model.Library)
      return Library43_50.convertLibrary((org.hl7.fhir.r5.model.Library) src);
    if (src instanceof org.hl7.fhir.r5.model.Linkage)
      return Linkage43_50.convertLinkage((org.hl7.fhir.r5.model.Linkage) src);
    if (src instanceof org.hl7.fhir.r5.model.ListResource)
      return ListResource43_50.convertListResource((org.hl7.fhir.r5.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r5.model.Location)
      return Location43_50.convertLocation((org.hl7.fhir.r5.model.Location) src);
    if (src instanceof org.hl7.fhir.r5.model.Measure)
      return Measure43_50.convertMeasure((org.hl7.fhir.r5.model.Measure) src);
    if (src instanceof org.hl7.fhir.r5.model.MeasureReport)
      return MeasureReport43_50.convertMeasureReport((org.hl7.fhir.r5.model.MeasureReport) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
      return Media43_50.convertMedia((org.hl7.fhir.r5.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r5.model.Medication)
      return Medication43_50.convertMedication((org.hl7.fhir.r5.model.Medication) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationAdministration)
      return MedicationAdministration43_50.convertMedicationAdministration((org.hl7.fhir.r5.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationDispense)
      return MedicationDispense43_50.convertMedicationDispense((org.hl7.fhir.r5.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationKnowledge)
      return MedicationKnowledge43_50.convertMedicationKnowledge((org.hl7.fhir.r5.model.MedicationKnowledge) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationRequest)
      return MedicationRequest43_50.convertMedicationRequest((org.hl7.fhir.r5.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationStatement)
      return MedicationStatement43_50.convertMedicationStatement((org.hl7.fhir.r5.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageDefinition)
      return MessageDefinition43_50.convertMessageDefinition((org.hl7.fhir.r5.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageHeader)
      return MessageHeader43_50.convertMessageHeader((org.hl7.fhir.r5.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r5.model.NamingSystem)
      return NamingSystem43_50.convertNamingSystem((org.hl7.fhir.r5.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.NutritionOrder)
      return NutritionOrder43_50.convertNutritionOrder((org.hl7.fhir.r5.model.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.r5.model.Observation)
      return Observation43_50.convertObservation((org.hl7.fhir.r5.model.Observation) src);
    if (src instanceof org.hl7.fhir.r5.model.ObservationDefinition)
      return ObservationDefinition43_50.convertObservationDefinition((org.hl7.fhir.r5.model.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationDefinition)
      return OperationDefinition43_50.convertOperationDefinition((org.hl7.fhir.r5.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationOutcome)
      return OperationOutcome43_50.convertOperationOutcome((org.hl7.fhir.r5.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r5.model.Organization)
      return Organization43_50.convertOrganization((org.hl7.fhir.r5.model.Organization) src);
    if (src instanceof org.hl7.fhir.r5.model.OrganizationAffiliation)
      return OrganizationAffiliation43_50.convertOrganizationAffiliation((org.hl7.fhir.r5.model.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.r5.model.Patient)
      return Patient43_50.convertPatient((org.hl7.fhir.r5.model.Patient) src);
    if (src instanceof org.hl7.fhir.r5.model.PaymentNotice)
      return PaymentNotice43_50.convertPaymentNotice((org.hl7.fhir.r5.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r5.model.Person)
      return Person43_50.convertPerson((org.hl7.fhir.r5.model.Person) src);
    if (src instanceof org.hl7.fhir.r5.model.PlanDefinition)
      return PlanDefinition43_50.convertPlanDefinition((org.hl7.fhir.r5.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Practitioner)
      return Practitioner43_50.convertPractitioner((org.hl7.fhir.r5.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r5.model.PractitionerRole)
      return PractitionerRole43_50.convertPractitionerRole((org.hl7.fhir.r5.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r5.model.Procedure)
      return Procedure43_50.convertProcedure((org.hl7.fhir.r5.model.Procedure) src);
    if (src instanceof org.hl7.fhir.r5.model.Provenance)
      return Provenance43_50.convertProvenance((org.hl7.fhir.r5.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r5.model.Questionnaire)
      return Questionnaire43_50.convertQuestionnaire((org.hl7.fhir.r5.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r5.model.QuestionnaireResponse)
      return QuestionnaireResponse43_50.convertQuestionnaireResponse((org.hl7.fhir.r5.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.RelatedPerson)
      return RelatedPerson43_50.convertRelatedPerson((org.hl7.fhir.r5.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r5.model.Requirements)
      return Requirements43_50.convertRequirements((org.hl7.fhir.r5.model.Requirements) src);
    if (src instanceof org.hl7.fhir.r5.model.RiskAssessment)
      return RiskAssessment43_50.convertRiskAssessment((org.hl7.fhir.r5.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r5.model.Schedule)
      return Schedule43_50.convertSchedule((org.hl7.fhir.r5.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r5.model.SearchParameter)
      return SearchParameter43_50.convertSearchParameter((org.hl7.fhir.r5.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r5.model.ServiceRequest)
      return ServiceRequest43_50.convertServiceRequest((org.hl7.fhir.r5.model.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.Slot) return Slot43_50.convertSlot((org.hl7.fhir.r5.model.Slot) src);
    if (src instanceof org.hl7.fhir.r5.model.Specimen)
      return Specimen43_50.convertSpecimen((org.hl7.fhir.r5.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r5.model.SpecimenDefinition)
      return SpecimenDefinition43_50.convertSpecimenDefinition((org.hl7.fhir.r5.model.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureDefinition)
      return StructureDefinition43_50.convertStructureDefinition((org.hl7.fhir.r5.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureMap)
      return StructureMap43_50.convertStructureMap((org.hl7.fhir.r5.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r5.model.SubscriptionStatus)
      return SubscriptionStatus43_50.convertSubscriptionStatus((org.hl7.fhir.r5.model.SubscriptionStatus)src);
    if (src instanceof org.hl7.fhir.r5.model.SubscriptionTopic)
      return SubscriptionTopic43_50.convertSubscriptionTopic((org.hl7.fhir.r5.model.SubscriptionTopic)src);
    if (src instanceof org.hl7.fhir.r5.model.Substance)
      return Substance43_50.convertSubstance((org.hl7.fhir.r5.model.Substance) src);
    if (src instanceof org.hl7.fhir.r5.model.SupplyDelivery)
      return SupplyDelivery43_50.convertSupplyDelivery((org.hl7.fhir.r5.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.r5.model.SupplyRequest)
      return SupplyRequest43_50.convertSupplyRequest((org.hl7.fhir.r5.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.Task) return Task43_50.convertTask((org.hl7.fhir.r5.model.Task) src);
    if (src instanceof org.hl7.fhir.r5.model.TerminologyCapabilities)
      return TerminologyCapabilities43_50.convertTerminologyCapabilities((org.hl7.fhir.r5.model.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.r5.model.TestReport)
      return TestReport43_50.convertTestReport((org.hl7.fhir.r5.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r5.model.TestScript)
      return TestScript43_50.convertTestScript((org.hl7.fhir.r5.model.TestScript) src);
    if (src instanceof org.hl7.fhir.r5.model.ValueSet)
      return ValueSet43_50.convertValueSet((org.hl7.fhir.r5.model.ValueSet) src);
    if (src instanceof org.hl7.fhir.r5.model.VerificationResult)
      return VerificationResult43_50.convertVerificationResult((org.hl7.fhir.r5.model.VerificationResult) src);
    if (src instanceof org.hl7.fhir.r5.model.VisionPrescription)
      return VisionPrescription43_50.convertVisionPrescription((org.hl7.fhir.r5.model.VisionPrescription) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R5 to R4B");
    } else {
      return null;
    }
  }

  public void copyDomainResource(org.hl7.fhir.r4b.model.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt, String ... ignoredExtensions) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative43_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext43_50.INSTANCE.path(), extension)) {
        org.hl7.fhir.r5.model.Extension convertExtension = new org.hl7.fhir.r5.model.Extension();
        advisor.handleExtension(ConversionContext43_50.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext43_50.INSTANCE.path(), extension) && !Arrays.asList(ignoredExtensions).contains(extension.getUrl())) {
        tgt.addExtension(Extension43_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext43_50.INSTANCE.path(), extension))
      .map(Extension43_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.r4b.model.DomainResource tgt, String ... ignoredExtensions) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative43_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext43_50.INSTANCE.path(), extension)) {
        org.hl7.fhir.r4b.model.Extension convertExtension = new org.hl7.fhir.r4b.model.Extension();
        advisor.handleExtension(ConversionContext43_50.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext43_50.INSTANCE.path(), extension) && !Arrays.asList(ignoredExtensions).contains(extension.getUrl())) {
        tgt.addExtension(Extension43_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext43_50.INSTANCE.path(), extension))
      .map(Extension43_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }
}
