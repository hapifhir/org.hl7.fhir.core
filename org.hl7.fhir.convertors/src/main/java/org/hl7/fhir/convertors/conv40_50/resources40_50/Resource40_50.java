package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_50;
import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Id40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Extension40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Meta40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Narrative40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Basic;

import java.util.Arrays;

public class Resource40_50 {

  public final BaseAdvisor_40_50 advisor;

  public Resource40_50(BaseAdvisor_40_50 advisor) {
    this.advisor = advisor;
  }

  public void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id40_50.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta40_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRulesElement(Uri40_50.convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_50.convertCode(src.getLanguageElement()));
  }

  public void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id40_50.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta40_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRulesElement(Uri40_50.convertUri(src.getImplicitRulesElement()));
    if (src.hasLanguage()) tgt.setLanguageElement(Code40_50.convertCode(src.getLanguageElement()));
  }

  public org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.r4.model.Parameters)
      return Parameters40_50.convertParameters((org.hl7.fhir.r4.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r4.model.Account)
      return Account40_50.convertAccount((org.hl7.fhir.r4.model.Account) src);
    if (src instanceof org.hl7.fhir.r4.model.ActivityDefinition)
      return ActivityDefinition40_50.convertActivityDefinition((org.hl7.fhir.r4.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.AllergyIntolerance)
      return AllergyIntolerance40_50.convertAllergyIntolerance((org.hl7.fhir.r4.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r4.model.Appointment)
      return Appointment40_50.convertAppointment((org.hl7.fhir.r4.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r4.model.AppointmentResponse)
      return AppointmentResponse40_50.convertAppointmentResponse((org.hl7.fhir.r4.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.AuditEvent)
      return AuditEvent40_50.convertAuditEvent((org.hl7.fhir.r4.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r4.model.Basic) {
      org.hl7.fhir.r4.model.Basic basic = (Basic) src;
      if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "ActorDefinition")) {
        return ActorDefinition40_50.convertActorDefinition((org.hl7.fhir.r4.model.Basic) src);
      } else if (basic.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "Requirements")) {
        return Requirements40_50.convertRequirements((org.hl7.fhir.r4.model.Basic) src);
      } else {
        return Basic40_50.convertBasic((org.hl7.fhir.r4.model.Basic) src);
      }
    }
    if (src instanceof org.hl7.fhir.r4.model.Binary)
      return Binary40_50.convertBinary((org.hl7.fhir.r4.model.Binary) src);
    if (src instanceof org.hl7.fhir.r4.model.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct40_50.convertBiologicallyDerivedProduct((org.hl7.fhir.r4.model.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.r4.model.BodyStructure)
      return BodyStructure40_50.convertBodyStructure((org.hl7.fhir.r4.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r4.model.Bundle)
      return Bundle40_50.convertBundle((org.hl7.fhir.r4.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r4.model.CapabilityStatement)
      return CapabilityStatement40_50.convertCapabilityStatement((org.hl7.fhir.r4.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.CarePlan)
      return CarePlan40_50.convertCarePlan((org.hl7.fhir.r4.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r4.model.CareTeam)
      return CareTeam40_50.convertCareTeam((org.hl7.fhir.r4.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r4.model.ChargeItem)
      return ChargeItem40_50.convertChargeItem((org.hl7.fhir.r4.model.ChargeItem) src);
    if (src instanceof org.hl7.fhir.r4.model.ChargeItemDefinition)
      return ChargeItemDefinition40_50.convertChargeItemDefinition((org.hl7.fhir.r4.model.ChargeItemDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Claim) return Claim40_50.convertClaim((org.hl7.fhir.r4.model.Claim) src);
    if (src instanceof org.hl7.fhir.r4.model.ClaimResponse)
      return ClaimResponse40_50.convertClaimResponse((org.hl7.fhir.r4.model.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.ClinicalImpression)
      return ClinicalImpression40_50.convertClinicalImpression((org.hl7.fhir.r4.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeSystem)
      return CodeSystem40_50.convertCodeSystem((org.hl7.fhir.r4.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r4.model.Communication)
      return Communication40_50.convertCommunication((org.hl7.fhir.r4.model.Communication) src);
    if (src instanceof org.hl7.fhir.r4.model.CommunicationRequest)
      return CommunicationRequest40_50.convertCommunicationRequest((org.hl7.fhir.r4.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.CompartmentDefinition)
      return CompartmentDefinition40_50.convertCompartmentDefinition((org.hl7.fhir.r4.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Composition)
      return Composition40_50.convertComposition((org.hl7.fhir.r4.model.Composition) src);
    if (src instanceof org.hl7.fhir.r4.model.ConceptMap)
      return ConceptMap40_50.convertConceptMap((org.hl7.fhir.r4.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r4.model.Condition)
      return Condition40_50.convertCondition((org.hl7.fhir.r4.model.Condition) src);
    if (src instanceof org.hl7.fhir.r4.model.Consent)
      return Consent40_50.convertConsent((org.hl7.fhir.r4.model.Consent) src);
    if (src instanceof org.hl7.fhir.r4.model.Contract)
      return Contract40_50.convertContract((org.hl7.fhir.r4.model.Contract) src);
    if (src instanceof org.hl7.fhir.r4.model.Coverage)
      return Coverage40_50.convertCoverage((org.hl7.fhir.r4.model.Coverage) src);
    if (src instanceof org.hl7.fhir.r4.model.CoverageEligibilityRequest)
      return CoverageEligibilityRequest40_50.convertCoverageEligibilityRequest((org.hl7.fhir.r4.model.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.DetectedIssue)
      return DetectedIssue40_50.convertDetectedIssue((org.hl7.fhir.r4.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r4.model.Device)
      return Device40_50.convertDevice((org.hl7.fhir.r4.model.Device) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceDefinition)
      return DeviceDefinition40_50.convertDeviceDefinition((org.hl7.fhir.r4.model.DeviceDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceMetric)
      return DeviceMetric40_50.convertDeviceMetric((org.hl7.fhir.r4.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceRequest)
      return DeviceRequest40_50.convertDeviceRequest((org.hl7.fhir.r4.model.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceUseStatement)
      return DeviceUseStatement40_50.convertDeviceUseStatement((org.hl7.fhir.r4.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.DiagnosticReport)
      return DiagnosticReport40_50.convertDiagnosticReport((org.hl7.fhir.r4.model.DiagnosticReport) src);
//    if (src instanceof org.hl7.fhir.r4.model.DocumentManifest)
//      return DocumentManifest40_50.convertDocumentManifest((org.hl7.fhir.r4.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.r4.model.DocumentReference)
      return DocumentReference40_50.convertDocumentReference((org.hl7.fhir.r4.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r4.model.Encounter)
      return Encounter40_50.convertEncounter((org.hl7.fhir.r4.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r4.model.Endpoint)
      return Endpoint40_50.convertEndpoint((org.hl7.fhir.r4.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r4.model.EnrollmentRequest)
      return EnrollmentRequest40_50.convertEnrollmentRequest((org.hl7.fhir.r4.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.EpisodeOfCare)
      return EpisodeOfCare40_50.convertEpisodeOfCare((org.hl7.fhir.r4.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r4.model.EventDefinition)
      return EventDefinition40_50.convertEventDefinition((org.hl7.fhir.r4.model.EventDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.ExampleScenario)
      return ExampleScenario40_50.convertExampleScenario((org.hl7.fhir.r4.model.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.r4.model.ExplanationOfBenefit)
      return ExplanationOfBenefit40_50.convertExplanationOfBenefit((org.hl7.fhir.r4.model.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.r4.model.FamilyMemberHistory)
      return FamilyMemberHistory40_50.convertFamilyMemberHistory((org.hl7.fhir.r4.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r4.model.Flag) return Flag40_50.convertFlag((org.hl7.fhir.r4.model.Flag) src);
    if (src instanceof org.hl7.fhir.r4.model.Goal) return Goal40_50.convertGoal((org.hl7.fhir.r4.model.Goal) src);
    if (src instanceof org.hl7.fhir.r4.model.GraphDefinition)
      return GraphDefinition40_50.convertGraphDefinition((org.hl7.fhir.r4.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Group) return Group40_50.convertGroup((org.hl7.fhir.r4.model.Group) src);
    if (src instanceof org.hl7.fhir.r4.model.GuidanceResponse)
      return GuidanceResponse40_50.convertGuidanceResponse((org.hl7.fhir.r4.model.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.HealthcareService)
      return HealthcareService40_50.convertHealthcareService((org.hl7.fhir.r4.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r4.model.ImagingStudy)
      return ImagingStudy40_50.convertImagingStudy((org.hl7.fhir.r4.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r4.model.Immunization)
      return Immunization40_50.convertImmunization((org.hl7.fhir.r4.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r4.model.ImmunizationEvaluation)
      return ImmunizationEvaluation40_50.convertImmunizationEvaluation((org.hl7.fhir.r4.model.ImmunizationEvaluation) src);
    if (src instanceof org.hl7.fhir.r4.model.ImmunizationRecommendation)
      return ImmunizationRecommendation40_50.convertImmunizationRecommendation((org.hl7.fhir.r4.model.ImmunizationRecommendation) src);
    if (src instanceof org.hl7.fhir.r4.model.ImplementationGuide)
      return ImplementationGuide40_50.convertImplementationGuide((org.hl7.fhir.r4.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r4.model.InsurancePlan)
      return InsurancePlan40_50.convertInsurancePlan((org.hl7.fhir.r4.model.InsurancePlan) src);
    if (src instanceof org.hl7.fhir.r4.model.Invoice)
      return Invoice40_50.convertInvoice((org.hl7.fhir.r4.model.Invoice) src);
    if (src instanceof org.hl7.fhir.r4.model.Library)
      return Library40_50.convertLibrary((org.hl7.fhir.r4.model.Library) src);
    if (src instanceof org.hl7.fhir.r4.model.Linkage)
      return Linkage40_50.convertLinkage((org.hl7.fhir.r4.model.Linkage) src);
    if (src instanceof org.hl7.fhir.r4.model.ListResource)
      return ListResource40_50.convertListResource((org.hl7.fhir.r4.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r4.model.Location)
      return Location40_50.convertLocation((org.hl7.fhir.r4.model.Location) src);
    if (src instanceof org.hl7.fhir.r4.model.Measure)
      return Measure40_50.convertMeasure((org.hl7.fhir.r4.model.Measure) src);
    if (src instanceof org.hl7.fhir.r4.model.MeasureReport)
      return MeasureReport40_50.convertMeasureReport((org.hl7.fhir.r4.model.MeasureReport) src);
    if (src instanceof org.hl7.fhir.r4.model.Media) return Media40_50.convertMedia((org.hl7.fhir.r4.model.Media) src);
    if (src instanceof org.hl7.fhir.r4.model.Medication)
      return Medication40_50.convertMedication((org.hl7.fhir.r4.model.Medication) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationAdministration)
      return MedicationAdministration40_50.convertMedicationAdministration((org.hl7.fhir.r4.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationDispense)
      return MedicationDispense40_50.convertMedicationDispense((org.hl7.fhir.r4.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationKnowledge)
      return MedicationKnowledge40_50.convertMedicationKnowledge((org.hl7.fhir.r4.model.MedicationKnowledge) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationRequest)
      return MedicationRequest40_50.convertMedicationRequest((org.hl7.fhir.r4.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationStatement)
      return MedicationStatement40_50.convertMedicationStatement((org.hl7.fhir.r4.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.MessageDefinition)
      return MessageDefinition40_50.convertMessageDefinition((org.hl7.fhir.r4.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.MessageHeader)
      return MessageHeader40_50.convertMessageHeader((org.hl7.fhir.r4.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r4.model.NamingSystem)
      return NamingSystem40_50.convertNamingSystem((org.hl7.fhir.r4.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r4.model.NutritionOrder)
      return NutritionOrder40_50.convertNutritionOrder((org.hl7.fhir.r4.model.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.r4.model.Observation)
      return Observation40_50.convertObservation((org.hl7.fhir.r4.model.Observation) src);
    if (src instanceof org.hl7.fhir.r4.model.ObservationDefinition)
      return ObservationDefinition40_50.convertObservationDefinition((org.hl7.fhir.r4.model.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationDefinition)
      return OperationDefinition40_50.convertOperationDefinition((org.hl7.fhir.r4.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationOutcome)
      return OperationOutcome40_50.convertOperationOutcome((org.hl7.fhir.r4.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r4.model.Organization)
      return Organization40_50.convertOrganization((org.hl7.fhir.r4.model.Organization) src);
    if (src instanceof org.hl7.fhir.r4.model.OrganizationAffiliation)
      return OrganizationAffiliation40_50.convertOrganizationAffiliation((org.hl7.fhir.r4.model.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.r4.model.Patient)
      return Patient40_50.convertPatient((org.hl7.fhir.r4.model.Patient) src);
    if (src instanceof org.hl7.fhir.r4.model.PaymentNotice)
      return PaymentNotice40_50.convertPaymentNotice((org.hl7.fhir.r4.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r4.model.Person)
      return Person40_50.convertPerson((org.hl7.fhir.r4.model.Person) src);
    if (src instanceof org.hl7.fhir.r4.model.PlanDefinition)
      return PlanDefinition40_50.convertPlanDefinition((org.hl7.fhir.r4.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Practitioner)
      return Practitioner40_50.convertPractitioner((org.hl7.fhir.r4.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r4.model.PractitionerRole)
      return PractitionerRole40_50.convertPractitionerRole((org.hl7.fhir.r4.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r4.model.Procedure)
      return Procedure40_50.convertProcedure((org.hl7.fhir.r4.model.Procedure) src);
    if (src instanceof org.hl7.fhir.r4.model.Provenance)
      return Provenance40_50.convertProvenance((org.hl7.fhir.r4.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r4.model.Questionnaire)
      return Questionnaire40_50.convertQuestionnaire((org.hl7.fhir.r4.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r4.model.QuestionnaireResponse)
      return QuestionnaireResponse40_50.convertQuestionnaireResponse((org.hl7.fhir.r4.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.RelatedPerson)
      return RelatedPerson40_50.convertRelatedPerson((org.hl7.fhir.r4.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r4.model.RiskAssessment)
      return RiskAssessment40_50.convertRiskAssessment((org.hl7.fhir.r4.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r4.model.Schedule)
      return Schedule40_50.convertSchedule((org.hl7.fhir.r4.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r4.model.SearchParameter)
      return SearchParameter40_50.convertSearchParameter((org.hl7.fhir.r4.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r4.model.ServiceRequest)
      return ServiceRequest40_50.convertServiceRequest((org.hl7.fhir.r4.model.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.Slot) return Slot40_50.convertSlot((org.hl7.fhir.r4.model.Slot) src);
    if (src instanceof org.hl7.fhir.r4.model.Specimen)
      return Specimen40_50.convertSpecimen((org.hl7.fhir.r4.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r4.model.SpecimenDefinition)
      return SpecimenDefinition40_50.convertSpecimenDefinition((org.hl7.fhir.r4.model.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.StructureDefinition)
      return StructureDefinition40_50.convertStructureDefinition((org.hl7.fhir.r4.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.StructureMap)
      return StructureMap40_50.convertStructureMap((org.hl7.fhir.r4.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r4.model.Substance)
      return Substance40_50.convertSubstance((org.hl7.fhir.r4.model.Substance) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstanceNucleicAcid)
      return SubstanceNucleicAcid40_50.convertSubstanceNucleicAcid((org.hl7.fhir.r4.model.SubstanceNucleicAcid) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstancePolymer)
      return SubstancePolymer40_50.convertSubstancePolymer((org.hl7.fhir.r4.model.SubstancePolymer) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstanceProtein)
      return SubstanceProtein40_50.convertSubstanceProtein((org.hl7.fhir.r4.model.SubstanceProtein) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstanceReferenceInformation)
      return SubstanceReferenceInformation40_50.convertSubstanceReferenceInformation((org.hl7.fhir.r4.model.SubstanceReferenceInformation) src);
    if (src instanceof org.hl7.fhir.r4.model.SubstanceSourceMaterial)
      return SubstanceSourceMaterial40_50.convertSubstanceSourceMaterial((org.hl7.fhir.r4.model.SubstanceSourceMaterial) src);
    if (src instanceof org.hl7.fhir.r4.model.SupplyDelivery)
      return SupplyDelivery40_50.convertSupplyDelivery((org.hl7.fhir.r4.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.r4.model.SupplyRequest)
      return SupplyRequest40_50.convertSupplyRequest((org.hl7.fhir.r4.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.Task) return Task40_50.convertTask((org.hl7.fhir.r4.model.Task) src);
    if (src instanceof org.hl7.fhir.r4.model.TerminologyCapabilities)
      return TerminologyCapabilities40_50.convertTerminologyCapabilities((org.hl7.fhir.r4.model.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.r4.model.TestReport)
      return TestReport40_50.convertTestReport((org.hl7.fhir.r4.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r4.model.TestScript)
      return TestScript40_50.convertTestScript((org.hl7.fhir.r4.model.TestScript) src);
    if (src instanceof org.hl7.fhir.r4.model.ValueSet)
      return ValueSet40_50.convertValueSet((org.hl7.fhir.r4.model.ValueSet) src);
    if (src instanceof org.hl7.fhir.r4.model.VerificationResult)
      return VerificationResult40_50.convertVerificationResult((org.hl7.fhir.r4.model.VerificationResult) src);
    if (src instanceof org.hl7.fhir.r4.model.VisionPrescription)
      return VisionPrescription40_50.convertVisionPrescription((org.hl7.fhir.r4.model.VisionPrescription) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R4 to R5");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.r5.model.Parameters)
      return Parameters40_50.convertParameters((org.hl7.fhir.r5.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r5.model.Account)
      return Account40_50.convertAccount((org.hl7.fhir.r5.model.Account) src);
    if (src instanceof org.hl7.fhir.r5.model.ActivityDefinition)
      return ActivityDefinition40_50.convertActivityDefinition((org.hl7.fhir.r5.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.AllergyIntolerance)
      return AllergyIntolerance40_50.convertAllergyIntolerance((org.hl7.fhir.r5.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r5.model.ActorDefinition)
      return ActorDefinition40_50.convertActorDefinition((org.hl7.fhir.r5.model.ActorDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Appointment)
      return Appointment40_50.convertAppointment((org.hl7.fhir.r5.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r5.model.AppointmentResponse)
      return AppointmentResponse40_50.convertAppointmentResponse((org.hl7.fhir.r5.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.AuditEvent)
      return AuditEvent40_50.convertAuditEvent((org.hl7.fhir.r5.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r5.model.Basic) return Basic40_50.convertBasic((org.hl7.fhir.r5.model.Basic) src);
    if (src instanceof org.hl7.fhir.r5.model.Binary)
      return Binary40_50.convertBinary((org.hl7.fhir.r5.model.Binary) src);
    if (src instanceof org.hl7.fhir.r5.model.BiologicallyDerivedProduct)
      return BiologicallyDerivedProduct40_50.convertBiologicallyDerivedProduct((org.hl7.fhir.r5.model.BiologicallyDerivedProduct) src);
    if (src instanceof org.hl7.fhir.r5.model.BodyStructure)
      return BodyStructure40_50.convertBodyStructure((org.hl7.fhir.r5.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r5.model.Bundle)
      return Bundle40_50.convertBundle((org.hl7.fhir.r5.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r5.model.CapabilityStatement)
      return CapabilityStatement40_50.convertCapabilityStatement((org.hl7.fhir.r5.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.CarePlan)
      return CarePlan40_50.convertCarePlan((org.hl7.fhir.r5.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r5.model.CareTeam)
      return CareTeam40_50.convertCareTeam((org.hl7.fhir.r5.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r5.model.ChargeItem)
      return ChargeItem40_50.convertChargeItem((org.hl7.fhir.r5.model.ChargeItem) src);
    if (src instanceof org.hl7.fhir.r5.model.ChargeItemDefinition)
      return ChargeItemDefinition40_50.convertChargeItemDefinition((org.hl7.fhir.r5.model.ChargeItemDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Claim) return Claim40_50.convertClaim((org.hl7.fhir.r5.model.Claim) src);
    if (src instanceof org.hl7.fhir.r5.model.ClaimResponse)
      return ClaimResponse40_50.convertClaimResponse((org.hl7.fhir.r5.model.ClaimResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.ClinicalImpression)
      return ClinicalImpression40_50.convertClinicalImpression((org.hl7.fhir.r5.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeSystem)
      return CodeSystem40_50.convertCodeSystem((org.hl7.fhir.r5.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.Communication)
      return Communication40_50.convertCommunication((org.hl7.fhir.r5.model.Communication) src);
    if (src instanceof org.hl7.fhir.r5.model.CommunicationRequest)
      return CommunicationRequest40_50.convertCommunicationRequest((org.hl7.fhir.r5.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.CompartmentDefinition)
      return CompartmentDefinition40_50.convertCompartmentDefinition((org.hl7.fhir.r5.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Composition)
      return Composition40_50.convertComposition((org.hl7.fhir.r5.model.Composition) src);
    if (src instanceof org.hl7.fhir.r5.model.ConceptMap)
      return ConceptMap40_50.convertConceptMap((org.hl7.fhir.r5.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r5.model.Condition)
      return Condition40_50.convertCondition((org.hl7.fhir.r5.model.Condition) src);
    if (src instanceof org.hl7.fhir.r5.model.Consent)
      return Consent40_50.convertConsent((org.hl7.fhir.r5.model.Consent) src);
    if (src instanceof org.hl7.fhir.r5.model.Contract)
      return Contract40_50.convertContract((org.hl7.fhir.r5.model.Contract) src);
    if (src instanceof org.hl7.fhir.r5.model.Coverage)
      return Coverage40_50.convertCoverage((org.hl7.fhir.r5.model.Coverage) src);
    if (src instanceof org.hl7.fhir.r5.model.CoverageEligibilityRequest)
      return CoverageEligibilityRequest40_50.convertCoverageEligibilityRequest((org.hl7.fhir.r5.model.CoverageEligibilityRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.DetectedIssue)
      return DetectedIssue40_50.convertDetectedIssue((org.hl7.fhir.r5.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r5.model.Device)
      return Device40_50.convertDevice((org.hl7.fhir.r5.model.Device) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceDefinition)
      return DeviceDefinition40_50.convertDeviceDefinition((org.hl7.fhir.r5.model.DeviceDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceMetric)
      return DeviceMetric40_50.convertDeviceMetric((org.hl7.fhir.r5.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceRequest)
      return DeviceRequest40_50.convertDeviceRequest((org.hl7.fhir.r5.model.DeviceRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceUsage)
      return DeviceUseStatement40_50.convertDeviceUseStatement((org.hl7.fhir.r5.model.DeviceUsage) src);
    if (src instanceof org.hl7.fhir.r5.model.DiagnosticReport)
      return DiagnosticReport40_50.convertDiagnosticReport((org.hl7.fhir.r5.model.DiagnosticReport) src);
//    if (src instanceof org.hl7.fhir.r5.model.DocumentManifest)
//      return DocumentManifest40_50.convertDocumentManifest((org.hl7.fhir.r5.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
      return DocumentReference40_50.convertDocumentReference((org.hl7.fhir.r5.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r5.model.Encounter)
      return Encounter40_50.convertEncounter((org.hl7.fhir.r5.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r5.model.Endpoint)
      return Endpoint40_50.convertEndpoint((org.hl7.fhir.r5.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r5.model.EnrollmentRequest)
      return EnrollmentRequest40_50.convertEnrollmentRequest((org.hl7.fhir.r5.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.EpisodeOfCare)
      return EpisodeOfCare40_50.convertEpisodeOfCare((org.hl7.fhir.r5.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r5.model.EventDefinition)
      return EventDefinition40_50.convertEventDefinition((org.hl7.fhir.r5.model.EventDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.ExampleScenario)
      return ExampleScenario40_50.convertExampleScenario((org.hl7.fhir.r5.model.ExampleScenario) src);
    if (src instanceof org.hl7.fhir.r5.model.ExplanationOfBenefit)
      return ExplanationOfBenefit40_50.convertExplanationOfBenefit((org.hl7.fhir.r5.model.ExplanationOfBenefit) src);
    if (src instanceof org.hl7.fhir.r5.model.FamilyMemberHistory)
      return FamilyMemberHistory40_50.convertFamilyMemberHistory((org.hl7.fhir.r5.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r5.model.Flag) return Flag40_50.convertFlag((org.hl7.fhir.r5.model.Flag) src);
    if (src instanceof org.hl7.fhir.r5.model.Goal) return Goal40_50.convertGoal((org.hl7.fhir.r5.model.Goal) src);
    if (src instanceof org.hl7.fhir.r5.model.GraphDefinition)
      return GraphDefinition40_50.convertGraphDefinition((org.hl7.fhir.r5.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Group) return Group40_50.convertGroup((org.hl7.fhir.r5.model.Group) src);
    if (src instanceof org.hl7.fhir.r5.model.GuidanceResponse)
      return GuidanceResponse40_50.convertGuidanceResponse((org.hl7.fhir.r5.model.GuidanceResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.HealthcareService)
      return HealthcareService40_50.convertHealthcareService((org.hl7.fhir.r5.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r5.model.ImagingStudy)
      return ImagingStudy40_50.convertImagingStudy((org.hl7.fhir.r5.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r5.model.Immunization)
      return Immunization40_50.convertImmunization((org.hl7.fhir.r5.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r5.model.ImmunizationEvaluation)
      return ImmunizationEvaluation40_50.convertImmunizationEvaluation((org.hl7.fhir.r5.model.ImmunizationEvaluation) src);
    if (src instanceof org.hl7.fhir.r5.model.ImmunizationRecommendation)
      return ImmunizationRecommendation40_50.convertImmunizationRecommendation((org.hl7.fhir.r5.model.ImmunizationRecommendation) src);
    if (src instanceof org.hl7.fhir.r5.model.ImplementationGuide)
      return ImplementationGuide40_50.convertImplementationGuide((org.hl7.fhir.r5.model.ImplementationGuide) src, advisor.produceIllegalParameters());
    if (src instanceof org.hl7.fhir.r5.model.InsurancePlan)
      return InsurancePlan40_50.convertInsurancePlan((org.hl7.fhir.r5.model.InsurancePlan) src);
    if (src instanceof org.hl7.fhir.r5.model.Invoice)
      return Invoice40_50.convertInvoice((org.hl7.fhir.r5.model.Invoice) src);
    if (src instanceof org.hl7.fhir.r5.model.Library)
      return Library40_50.convertLibrary((org.hl7.fhir.r5.model.Library) src);
    if (src instanceof org.hl7.fhir.r5.model.Linkage)
      return Linkage40_50.convertLinkage((org.hl7.fhir.r5.model.Linkage) src);
    if (src instanceof org.hl7.fhir.r5.model.ListResource)
      return ListResource40_50.convertListResource((org.hl7.fhir.r5.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r5.model.Location)
      return Location40_50.convertLocation((org.hl7.fhir.r5.model.Location) src);
    if (src instanceof org.hl7.fhir.r5.model.Measure)
      return Measure40_50.convertMeasure((org.hl7.fhir.r5.model.Measure) src);
    if (src instanceof org.hl7.fhir.r5.model.MeasureReport)
      return MeasureReport40_50.convertMeasureReport((org.hl7.fhir.r5.model.MeasureReport) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
      return Media40_50.convertMedia((org.hl7.fhir.r5.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r5.model.Medication)
      return Medication40_50.convertMedication((org.hl7.fhir.r5.model.Medication) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationAdministration)
      return MedicationAdministration40_50.convertMedicationAdministration((org.hl7.fhir.r5.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationDispense)
      return MedicationDispense40_50.convertMedicationDispense((org.hl7.fhir.r5.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationKnowledge)
      return MedicationKnowledge40_50.convertMedicationKnowledge((org.hl7.fhir.r5.model.MedicationKnowledge) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationRequest)
      return MedicationRequest40_50.convertMedicationRequest((org.hl7.fhir.r5.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationStatement)
      return MedicationStatement40_50.convertMedicationStatement((org.hl7.fhir.r5.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageDefinition)
      return MessageDefinition40_50.convertMessageDefinition((org.hl7.fhir.r5.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageHeader)
      return MessageHeader40_50.convertMessageHeader((org.hl7.fhir.r5.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r5.model.NamingSystem)
      return NamingSystem40_50.convertNamingSystem((org.hl7.fhir.r5.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.NutritionOrder)
      return NutritionOrder40_50.convertNutritionOrder((org.hl7.fhir.r5.model.NutritionOrder) src);
    if (src instanceof org.hl7.fhir.r5.model.Observation)
      return Observation40_50.convertObservation((org.hl7.fhir.r5.model.Observation) src);
    if (src instanceof org.hl7.fhir.r5.model.ObservationDefinition)
      return ObservationDefinition40_50.convertObservationDefinition((org.hl7.fhir.r5.model.ObservationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationDefinition)
      return OperationDefinition40_50.convertOperationDefinition((org.hl7.fhir.r5.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationOutcome)
      return OperationOutcome40_50.convertOperationOutcome((org.hl7.fhir.r5.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r5.model.Organization)
      return Organization40_50.convertOrganization((org.hl7.fhir.r5.model.Organization) src);
    if (src instanceof org.hl7.fhir.r5.model.OrganizationAffiliation)
      return OrganizationAffiliation40_50.convertOrganizationAffiliation((org.hl7.fhir.r5.model.OrganizationAffiliation) src);
    if (src instanceof org.hl7.fhir.r5.model.Patient)
      return Patient40_50.convertPatient((org.hl7.fhir.r5.model.Patient) src);
    if (src instanceof org.hl7.fhir.r5.model.PaymentNotice)
      return PaymentNotice40_50.convertPaymentNotice((org.hl7.fhir.r5.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r5.model.Person)
      return Person40_50.convertPerson((org.hl7.fhir.r5.model.Person) src);
    if (src instanceof org.hl7.fhir.r5.model.PlanDefinition)
      return PlanDefinition40_50.convertPlanDefinition((org.hl7.fhir.r5.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Practitioner)
      return Practitioner40_50.convertPractitioner((org.hl7.fhir.r5.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r5.model.PractitionerRole)
      return PractitionerRole40_50.convertPractitionerRole((org.hl7.fhir.r5.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r5.model.Procedure)
      return Procedure40_50.convertProcedure((org.hl7.fhir.r5.model.Procedure) src);
    if (src instanceof org.hl7.fhir.r5.model.Provenance)
      return Provenance40_50.convertProvenance((org.hl7.fhir.r5.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r5.model.Questionnaire)
      return Questionnaire40_50.convertQuestionnaire((org.hl7.fhir.r5.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r5.model.QuestionnaireResponse)
      return QuestionnaireResponse40_50.convertQuestionnaireResponse((org.hl7.fhir.r5.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.RelatedPerson)
      return RelatedPerson40_50.convertRelatedPerson((org.hl7.fhir.r5.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r5.model.Requirements)
      return Requirements40_50.convertRequirements((org.hl7.fhir.r5.model.Requirements) src);
    if (src instanceof org.hl7.fhir.r5.model.RiskAssessment)
      return RiskAssessment40_50.convertRiskAssessment((org.hl7.fhir.r5.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r5.model.Schedule)
      return Schedule40_50.convertSchedule((org.hl7.fhir.r5.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r5.model.SearchParameter)
      return SearchParameter40_50.convertSearchParameter((org.hl7.fhir.r5.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r5.model.ServiceRequest)
      return ServiceRequest40_50.convertServiceRequest((org.hl7.fhir.r5.model.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.Slot) return Slot40_50.convertSlot((org.hl7.fhir.r5.model.Slot) src);
    if (src instanceof org.hl7.fhir.r5.model.Specimen)
      return Specimen40_50.convertSpecimen((org.hl7.fhir.r5.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r5.model.SpecimenDefinition)
      return SpecimenDefinition40_50.convertSpecimenDefinition((org.hl7.fhir.r5.model.SpecimenDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureDefinition)
      return StructureDefinition40_50.convertStructureDefinition((org.hl7.fhir.r5.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureMap)
      return StructureMap40_50.convertStructureMap((org.hl7.fhir.r5.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r5.model.Substance)
      return Substance40_50.convertSubstance((org.hl7.fhir.r5.model.Substance) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceNucleicAcid)
      return SubstanceNucleicAcid40_50.convertSubstanceNucleicAcid((org.hl7.fhir.r5.model.SubstanceNucleicAcid) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstancePolymer)
      return SubstancePolymer40_50.convertSubstancePolymer((org.hl7.fhir.r5.model.SubstancePolymer) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceProtein)
      return SubstanceProtein40_50.convertSubstanceProtein((org.hl7.fhir.r5.model.SubstanceProtein) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceReferenceInformation)
      return SubstanceReferenceInformation40_50.convertSubstanceReferenceInformation((org.hl7.fhir.r5.model.SubstanceReferenceInformation) src);
    if (src instanceof org.hl7.fhir.r5.model.SubstanceSourceMaterial)
      return SubstanceSourceMaterial40_50.convertSubstanceSourceMaterial((org.hl7.fhir.r5.model.SubstanceSourceMaterial) src);
    if (src instanceof org.hl7.fhir.r5.model.SupplyDelivery)
      return SupplyDelivery40_50.convertSupplyDelivery((org.hl7.fhir.r5.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.r5.model.SupplyRequest)
      return SupplyRequest40_50.convertSupplyRequest((org.hl7.fhir.r5.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.Task) return Task40_50.convertTask((org.hl7.fhir.r5.model.Task) src);
    if (src instanceof org.hl7.fhir.r5.model.TerminologyCapabilities)
      return TerminologyCapabilities40_50.convertTerminologyCapabilities((org.hl7.fhir.r5.model.TerminologyCapabilities) src);
    if (src instanceof org.hl7.fhir.r5.model.TestReport)
      return TestReport40_50.convertTestReport((org.hl7.fhir.r5.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r5.model.TestScript)
      return TestScript40_50.convertTestScript((org.hl7.fhir.r5.model.TestScript) src);
    if (src instanceof org.hl7.fhir.r5.model.ValueSet)
      return ValueSet40_50.convertValueSet((org.hl7.fhir.r5.model.ValueSet) src);
    if (src instanceof org.hl7.fhir.r5.model.VerificationResult)
      return VerificationResult40_50.convertVerificationResult((org.hl7.fhir.r5.model.VerificationResult) src);
    if (src instanceof org.hl7.fhir.r5.model.VisionPrescription)
      return VisionPrescription40_50.convertVisionPrescription((org.hl7.fhir.r5.model.VisionPrescription) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R5 to R4");
    } else {
      return null;
    }
  }

  public void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt, String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative40_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext40_50.INSTANCE.path(), extension)) {
        org.hl7.fhir.r5.model.Extension convertExtension = new org.hl7.fhir.r5.model.Extension();
        advisor.handleExtension(ConversionContext40_50.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext40_50.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension40_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext40_50.INSTANCE.path(), extension))
      .map(Extension40_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt,  String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative40_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext40_50.INSTANCE.path(), extension)) {
        org.hl7.fhir.r4.model.Extension convertExtension = new org.hl7.fhir.r4.model.Extension();
        advisor.handleExtension(ConversionContext40_50.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext40_50.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension40_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext40_50.INSTANCE.path(), extension))
      .map(Extension40_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }
}
