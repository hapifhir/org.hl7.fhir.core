package org.hl7.fhir.convertors.conv30_40.resources30_40;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Extension30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Meta30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Narrative30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Resource30_40 {

  public final BaseAdvisor_30_40 advisor;

  public Resource30_40(BaseAdvisor_30_40 advisor) {
    this.advisor = advisor;
  }

  public void copyResource(org.hl7.fhir.dstu3.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta30_40.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  public void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.dstu3.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta30_40.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  public org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_30_40());
  }

  public org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src, BaseAdvisor_30_40 advisor) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.dstu3.model.Parameters)
      return Parameters30_40.convertParameters((org.hl7.fhir.dstu3.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Account)
      return Account30_40.convertAccount((org.hl7.fhir.dstu3.model.Account) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ActivityDefinition)
      return ActivityDefinition30_40.convertActivityDefinition((org.hl7.fhir.dstu3.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AllergyIntolerance)
      return AllergyIntolerance30_40.convertAllergyIntolerance((org.hl7.fhir.dstu3.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Appointment)
      return Appointment30_40.convertAppointment((org.hl7.fhir.dstu3.model.Appointment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AppointmentResponse)
      return AppointmentResponse30_40.convertAppointmentResponse((org.hl7.fhir.dstu3.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AuditEvent)
      return AuditEvent30_40.convertAuditEvent((org.hl7.fhir.dstu3.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Basic)
      return Basic30_40.convertBasic((org.hl7.fhir.dstu3.model.Basic) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Binary)
      return Binary30_40.convertBinary((org.hl7.fhir.dstu3.model.Binary) src);
    if (src instanceof org.hl7.fhir.dstu3.model.BodySite)
      return BodySite30_40.convertBodySite((org.hl7.fhir.dstu3.model.BodySite) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Bundle)
      return Bundle30_40.convertBundle((org.hl7.fhir.dstu3.model.Bundle) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CapabilityStatement)
      return CapabilityStatement30_40.convertCapabilityStatement((org.hl7.fhir.dstu3.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CarePlan)
      return CarePlan30_40.convertCarePlan((org.hl7.fhir.dstu3.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CareTeam)
      return CareTeam30_40.convertCareTeam((org.hl7.fhir.dstu3.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ClinicalImpression)
      return ClinicalImpression30_40.convertClinicalImpression((org.hl7.fhir.dstu3.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeSystem)
      return CodeSystem30_40.convertCodeSystem((org.hl7.fhir.dstu3.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Communication)
      return Communication30_40.convertCommunication((org.hl7.fhir.dstu3.model.Communication) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CompartmentDefinition)
      return CompartmentDefinition30_40.convertCompartmentDefinition((org.hl7.fhir.dstu3.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Composition)
      return Composition30_40.convertComposition((org.hl7.fhir.dstu3.model.Composition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ConceptMap)
      return ConceptMap30_40.convertConceptMap((org.hl7.fhir.dstu3.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Condition)
      return Condition30_40.convertCondition((org.hl7.fhir.dstu3.model.Condition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Consent)
      return Consent30_40.convertConsent((org.hl7.fhir.dstu3.model.Consent) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Coverage)
      return Coverage30_40.convertCoverage((org.hl7.fhir.dstu3.model.Coverage) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DataElement)
      return DataElement30_40.convertDataElement((org.hl7.fhir.dstu3.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DetectedIssue)
      return DetectedIssue30_40.convertDetectedIssue((org.hl7.fhir.dstu3.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DeviceUseStatement)
      return DeviceUseStatement30_40.convertDeviceUseStatement((org.hl7.fhir.dstu3.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DiagnosticReport)
      return DiagnosticReport30_40.convertDiagnosticReport((org.hl7.fhir.dstu3.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DocumentReference)
      return DocumentReference30_40.convertDocumentReference((org.hl7.fhir.dstu3.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Encounter)
      return Encounter30_40.convertEncounter((org.hl7.fhir.dstu3.model.Encounter) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Endpoint)
      return Endpoint30_40.convertEndpoint((org.hl7.fhir.dstu3.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.dstu3.model.EpisodeOfCare)
      return EpisodeOfCare30_40.convertEpisodeOfCare((org.hl7.fhir.dstu3.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ExpansionProfile)
      return ExpansionProfile30_40.convertExpansionProfile((org.hl7.fhir.dstu3.model.ExpansionProfile) src);
    if (src instanceof org.hl7.fhir.dstu3.model.FamilyMemberHistory)
      return FamilyMemberHistory30_40.convertFamilyMemberHistory((org.hl7.fhir.dstu3.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Flag) return Flag30_40.convertFlag((org.hl7.fhir.dstu3.model.Flag) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Goal) return Goal30_40.convertGoal((org.hl7.fhir.dstu3.model.Goal) src);
    if (src instanceof org.hl7.fhir.dstu3.model.GraphDefinition)
      return GraphDefinition30_40.convertGraphDefinition((org.hl7.fhir.dstu3.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Group)
      return Group30_40.convertGroup((org.hl7.fhir.dstu3.model.Group) src);
    if (src instanceof org.hl7.fhir.dstu3.model.HealthcareService)
      return HealthcareService30_40.convertHealthcareService((org.hl7.fhir.dstu3.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImagingStudy)
      return ImagingStudy30_40.convertImagingStudy((org.hl7.fhir.dstu3.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Immunization)
      return Immunization30_40.convertImmunization((org.hl7.fhir.dstu3.model.Immunization) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImplementationGuide)
      return ImplementationGuide30_40.convertImplementationGuide((org.hl7.fhir.dstu3.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Library)
      return Library30_40.convertLibrary((org.hl7.fhir.dstu3.model.Library) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Linkage)
      return Linkage30_40.convertLinkage((org.hl7.fhir.dstu3.model.Linkage) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ListResource)
      return List30_40.convertList((org.hl7.fhir.dstu3.model.ListResource) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Location)
      return Location30_40.convertLocation((org.hl7.fhir.dstu3.model.Location) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Media)
      return Media30_40.convertMedia((org.hl7.fhir.dstu3.model.Media) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Medication)
      return Medication30_40.convertMedication((org.hl7.fhir.dstu3.model.Medication) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationAdministration)
      return MedicationAdministration30_40.convertMedicationAdministration((org.hl7.fhir.dstu3.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationDispense)
      return MedicationDispense30_40.convertMedicationDispense((org.hl7.fhir.dstu3.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationRequest)
      return MedicationRequest30_40.convertMedicationRequest((org.hl7.fhir.dstu3.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationStatement)
      return MedicationStatement30_40.convertMedicationStatement((org.hl7.fhir.dstu3.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MessageDefinition)
      return MessageDefinition30_40.convertMessageDefinition((org.hl7.fhir.dstu3.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MessageHeader)
      return MessageHeader30_40.convertMessageHeader((org.hl7.fhir.dstu3.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.dstu3.model.NamingSystem)
      return NamingSystem30_40.convertNamingSystem((org.hl7.fhir.dstu3.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Observation)
      return Observation30_40.convertObservation((org.hl7.fhir.dstu3.model.Observation) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationDefinition)
      return OperationDefinition30_40.convertOperationDefinition((org.hl7.fhir.dstu3.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationOutcome)
      return OperationOutcome30_40.convertOperationOutcome((org.hl7.fhir.dstu3.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Organization)
      return Organization30_40.convertOrganization((org.hl7.fhir.dstu3.model.Organization) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Patient)
      return Patient30_40.convertPatient((org.hl7.fhir.dstu3.model.Patient) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PaymentNotice)
      return PaymentNotice30_40.convertPaymentNotice((org.hl7.fhir.dstu3.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Person)
      return Person30_40.convertPerson((org.hl7.fhir.dstu3.model.Person) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PlanDefinition)
      return PlanDefinition30_40.convertPlanDefinition((org.hl7.fhir.dstu3.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Practitioner)
      return Practitioner30_40.convertPractitioner((org.hl7.fhir.dstu3.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PractitionerRole)
      return PractitionerRole30_40.convertPractitionerRole((org.hl7.fhir.dstu3.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Procedure)
      return Procedure30_40.convertProcedure((org.hl7.fhir.dstu3.model.Procedure) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ProcedureRequest)
      return ProcedureRequest30_40.convertProcedureRequest((org.hl7.fhir.dstu3.model.ProcedureRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Provenance)
      return Provenance30_40.convertProvenance((org.hl7.fhir.dstu3.model.Provenance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Questionnaire)
      return Questionnaire30_40.convertQuestionnaire((org.hl7.fhir.dstu3.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu3.model.QuestionnaireResponse)
      return QuestionnaireResponse30_40.convertQuestionnaireResponse((org.hl7.fhir.dstu3.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RelatedPerson)
      return RelatedPerson30_40.convertRelatedPerson((org.hl7.fhir.dstu3.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RiskAssessment)
      return RiskAssessment30_40.convertRiskAssessment((org.hl7.fhir.dstu3.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Schedule)
      return Schedule30_40.convertSchedule((org.hl7.fhir.dstu3.model.Schedule) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SearchParameter)
      return SearchParameter30_40.convertSearchParameter((org.hl7.fhir.dstu3.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Sequence)
      return Sequence30_40.convertSequence((org.hl7.fhir.dstu3.model.Sequence) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Slot) return Slot30_40.convertSlot((org.hl7.fhir.dstu3.model.Slot) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Specimen)
      return Specimen30_40.convertSpecimen((org.hl7.fhir.dstu3.model.Specimen) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StructureDefinition)
      return StructureDefinition30_40.convertStructureDefinition((org.hl7.fhir.dstu3.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StructureMap)
      return StructureMap30_40.convertStructureMap((org.hl7.fhir.dstu3.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Subscription)
      return Subscription30_40.convertSubscription((org.hl7.fhir.dstu3.model.Subscription) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Substance)
      return Substance30_40.convertSubstance((org.hl7.fhir.dstu3.model.Substance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SupplyDelivery)
      return SupplyDelivery30_40.convertSupplyDelivery((org.hl7.fhir.dstu3.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TestReport)
      return TestReport30_40.convertTestReport((org.hl7.fhir.dstu3.model.TestReport) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TestScript)
      return TestScript30_40.convertTestScript((org.hl7.fhir.dstu3.model.TestScript) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ValueSet)
      return ValueSet30_40.convertValueSet((org.hl7.fhir.dstu3.model.ValueSet) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R3 to R4");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_30_40());
  }

  public org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src, BaseAdvisor_30_40 advisor) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.r4.model.Parameters) {
//      if (((org.hl7.fhir.r4.model.Parameters) src).hasParameterValue("profile-url"))
//        return ExpansionProfile30_40.convertExpansionProfile((org.hl7.fhir.r4.model.Parameters) src);
//      else 
        return Parameters30_40.convertParameters((org.hl7.fhir.r4.model.Parameters) src);
    }
    if (src instanceof org.hl7.fhir.r4.model.Account)
      return Account30_40.convertAccount((org.hl7.fhir.r4.model.Account) src);
    if (src instanceof org.hl7.fhir.r4.model.ActivityDefinition)
      return ActivityDefinition30_40.convertActivityDefinition((org.hl7.fhir.r4.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.AllergyIntolerance)
      return AllergyIntolerance30_40.convertAllergyIntolerance((org.hl7.fhir.r4.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r4.model.Appointment)
      return Appointment30_40.convertAppointment((org.hl7.fhir.r4.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r4.model.AppointmentResponse)
      return AppointmentResponse30_40.convertAppointmentResponse((org.hl7.fhir.r4.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.AuditEvent)
      return AuditEvent30_40.convertAuditEvent((org.hl7.fhir.r4.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r4.model.Basic) return Basic30_40.convertBasic((org.hl7.fhir.r4.model.Basic) src);
    if (src instanceof org.hl7.fhir.r4.model.Binary)
      return Binary30_40.convertBinary((org.hl7.fhir.r4.model.Binary) src);
    if (src instanceof org.hl7.fhir.r4.model.BodyStructure)
      return BodySite30_40.convertBodySite((org.hl7.fhir.r4.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r4.model.Bundle)
      return Bundle30_40.convertBundle((org.hl7.fhir.r4.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r4.model.CapabilityStatement)
      return CapabilityStatement30_40.convertCapabilityStatement((org.hl7.fhir.r4.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.CarePlan)
      return CarePlan30_40.convertCarePlan((org.hl7.fhir.r4.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r4.model.CareTeam)
      return CareTeam30_40.convertCareTeam((org.hl7.fhir.r4.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r4.model.ClinicalImpression)
      return ClinicalImpression30_40.convertClinicalImpression((org.hl7.fhir.r4.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.r4.model.CodeSystem)
      return CodeSystem30_40.convertCodeSystem((org.hl7.fhir.r4.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r4.model.Communication)
      return Communication30_40.convertCommunication((org.hl7.fhir.r4.model.Communication) src);
    if (src instanceof org.hl7.fhir.r4.model.CompartmentDefinition)
      return CompartmentDefinition30_40.convertCompartmentDefinition((org.hl7.fhir.r4.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Composition)
      return Composition30_40.convertComposition((org.hl7.fhir.r4.model.Composition) src);
    if (src instanceof org.hl7.fhir.r4.model.ConceptMap)
      return ConceptMap30_40.convertConceptMap((org.hl7.fhir.r4.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r4.model.Condition)
      return Condition30_40.convertCondition((org.hl7.fhir.r4.model.Condition) src);
    if (src instanceof org.hl7.fhir.r4.model.Consent)
      return Consent30_40.convertConsent((org.hl7.fhir.r4.model.Consent) src);
    if (src instanceof org.hl7.fhir.r4.model.Coverage)
      return Coverage30_40.convertCoverage((org.hl7.fhir.r4.model.Coverage) src);
    if (src instanceof org.hl7.fhir.r4.model.DetectedIssue)
      return DetectedIssue30_40.convertDetectedIssue((org.hl7.fhir.r4.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r4.model.Device)
      return Device30_40.convertDevice((org.hl7.fhir.r4.model.Device) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceUseStatement)
      return DeviceUseStatement30_40.convertDeviceUseStatement((org.hl7.fhir.r4.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.DiagnosticReport)
      return DiagnosticReport30_40.convertDiagnosticReport((org.hl7.fhir.r4.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.r4.model.DocumentReference)
      return DocumentReference30_40.convertDocumentReference((org.hl7.fhir.r4.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r4.model.Encounter)
      return Encounter30_40.convertEncounter((org.hl7.fhir.r4.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r4.model.Endpoint)
      return Endpoint30_40.convertEndpoint((org.hl7.fhir.r4.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r4.model.EpisodeOfCare)
      return EpisodeOfCare30_40.convertEpisodeOfCare((org.hl7.fhir.r4.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r4.model.FamilyMemberHistory)
      return FamilyMemberHistory30_40.convertFamilyMemberHistory((org.hl7.fhir.r4.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r4.model.Flag) return Flag30_40.convertFlag((org.hl7.fhir.r4.model.Flag) src);
    if (src instanceof org.hl7.fhir.r4.model.Goal) return Goal30_40.convertGoal((org.hl7.fhir.r4.model.Goal) src);
    if (src instanceof org.hl7.fhir.r4.model.GraphDefinition)
      return GraphDefinition30_40.convertGraphDefinition((org.hl7.fhir.r4.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Group) return Group30_40.convertGroup((org.hl7.fhir.r4.model.Group) src);
    if (src instanceof org.hl7.fhir.r4.model.HealthcareService)
      return HealthcareService30_40.convertHealthcareService((org.hl7.fhir.r4.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r4.model.ImagingStudy)
      return ImagingStudy30_40.convertImagingStudy((org.hl7.fhir.r4.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r4.model.Immunization)
      return Immunization30_40.convertImmunization((org.hl7.fhir.r4.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r4.model.ImplementationGuide)
      return ImplementationGuide30_40.convertImplementationGuide((org.hl7.fhir.r4.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r4.model.Library)
      return Library30_40.convertLibrary((org.hl7.fhir.r4.model.Library) src);
    if (src instanceof org.hl7.fhir.r4.model.Linkage)
      return Linkage30_40.convertLinkage((org.hl7.fhir.r4.model.Linkage) src);
    if (src instanceof org.hl7.fhir.r4.model.ListResource)
      return List30_40.convertList((org.hl7.fhir.r4.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r4.model.Location)
      return Location30_40.convertLocation((org.hl7.fhir.r4.model.Location) src);
    if (src instanceof org.hl7.fhir.r4.model.Media) return Media30_40.convertMedia((org.hl7.fhir.r4.model.Media) src);
    if (src instanceof org.hl7.fhir.r4.model.Medication)
      return Medication30_40.convertMedication((org.hl7.fhir.r4.model.Medication) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationAdministration)
      return MedicationAdministration30_40.convertMedicationAdministration((org.hl7.fhir.r4.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationDispense)
      return MedicationDispense30_40.convertMedicationDispense((org.hl7.fhir.r4.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationRequest)
      return MedicationRequest30_40.convertMedicationRequest((org.hl7.fhir.r4.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationStatement)
      return MedicationStatement30_40.convertMedicationStatement((org.hl7.fhir.r4.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.MessageDefinition)
      return MessageDefinition30_40.convertMessageDefinition((org.hl7.fhir.r4.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.MessageHeader)
      return MessageHeader30_40.convertMessageHeader((org.hl7.fhir.r4.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r4.model.NamingSystem)
      return NamingSystem30_40.convertNamingSystem((org.hl7.fhir.r4.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r4.model.Observation)
      return Observation30_40.convertObservation((org.hl7.fhir.r4.model.Observation) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationDefinition)
      return OperationDefinition30_40.convertOperationDefinition((org.hl7.fhir.r4.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationOutcome)
      return OperationOutcome30_40.convertOperationOutcome((org.hl7.fhir.r4.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r4.model.Organization)
      return Organization30_40.convertOrganization((org.hl7.fhir.r4.model.Organization) src);
    if (src instanceof org.hl7.fhir.r4.model.Patient)
      return Patient30_40.convertPatient((org.hl7.fhir.r4.model.Patient) src);
    if (src instanceof org.hl7.fhir.r4.model.PaymentNotice)
      return PaymentNotice30_40.convertPaymentNotice((org.hl7.fhir.r4.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r4.model.Person)
      return Person30_40.convertPerson((org.hl7.fhir.r4.model.Person) src);
    if (src instanceof org.hl7.fhir.r4.model.PlanDefinition)
      return PlanDefinition30_40.convertPlanDefinition((org.hl7.fhir.r4.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Practitioner)
      return Practitioner30_40.convertPractitioner((org.hl7.fhir.r4.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r4.model.PractitionerRole)
      return PractitionerRole30_40.convertPractitionerRole((org.hl7.fhir.r4.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r4.model.Procedure)
      return Procedure30_40.convertProcedure((org.hl7.fhir.r4.model.Procedure) src);
    if (src instanceof org.hl7.fhir.r4.model.ServiceRequest)
      return ProcedureRequest30_40.convertProcedureRequest((org.hl7.fhir.r4.model.ServiceRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.Provenance)
      return Provenance30_40.convertProvenance((org.hl7.fhir.r4.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r4.model.Questionnaire)
      return Questionnaire30_40.convertQuestionnaire((org.hl7.fhir.r4.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r4.model.QuestionnaireResponse)
      return QuestionnaireResponse30_40.convertQuestionnaireResponse((org.hl7.fhir.r4.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.RelatedPerson)
      return RelatedPerson30_40.convertRelatedPerson((org.hl7.fhir.r4.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r4.model.RiskAssessment)
      return RiskAssessment30_40.convertRiskAssessment((org.hl7.fhir.r4.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r4.model.Schedule)
      return Schedule30_40.convertSchedule((org.hl7.fhir.r4.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r4.model.SearchParameter)
      return SearchParameter30_40.convertSearchParameter((org.hl7.fhir.r4.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r4.model.MolecularSequence)
      return Sequence30_40.convertSequence((org.hl7.fhir.r4.model.MolecularSequence) src);
    if (src instanceof org.hl7.fhir.r4.model.Slot) return Slot30_40.convertSlot((org.hl7.fhir.r4.model.Slot) src);
    if (src instanceof org.hl7.fhir.r4.model.Specimen)
      return Specimen30_40.convertSpecimen((org.hl7.fhir.r4.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r4.model.StructureDefinition)
      return StructureDefinition30_40.convertStructureDefinition((org.hl7.fhir.r4.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.StructureMap)
      return StructureMap30_40.convertStructureMap((org.hl7.fhir.r4.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r4.model.Subscription)
      return Subscription30_40.convertSubscription((org.hl7.fhir.r4.model.Subscription) src);
    if (src instanceof org.hl7.fhir.r4.model.Substance)
      return Substance30_40.convertSubstance((org.hl7.fhir.r4.model.Substance) src);
    if (src instanceof org.hl7.fhir.r4.model.SupplyDelivery)
      return SupplyDelivery30_40.convertSupplyDelivery((org.hl7.fhir.r4.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.r4.model.TestReport)
      return TestReport30_40.convertTestReport((org.hl7.fhir.r4.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r4.model.TestScript)
      return TestScript30_40.convertTestScript((org.hl7.fhir.r4.model.TestScript) src);
    if (src instanceof org.hl7.fhir.r4.model.ValueSet)
      return ValueSet30_40.convertValueSet((org.hl7.fhir.r4.model.ValueSet) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R4 to R3");
    } else {
      return null;
    }
  }

  public void copyDomainResource(org.hl7.fhir.dstu3.model.DomainResource src,
                                 org.hl7.fhir.r4.model.DomainResource tgt,
                                 String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative30_40.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(resource -> convertResource(resource, advisor))
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {

      if (advisor.useAdvisorForExtension(ConversionContext30_40.INSTANCE.path(), extension)) {
        org.hl7.fhir.r4.model.Extension convertExtension = new org.hl7.fhir.r4.model.Extension();
        advisor.handleExtension(ConversionContext30_40.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext30_40.INSTANCE.path(), extension)&& !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension30_40.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext30_40.INSTANCE.path(), extension))
      .map(Extension30_40::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src,
                                 org.hl7.fhir.dstu3.model.DomainResource tgt,
                                 String... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative30_40.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(resource -> convertResource(resource, advisor))
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext30_40.INSTANCE.path(), extension)) {
        org.hl7.fhir.dstu3.model.Extension convertExtension = new org.hl7.fhir.dstu3.model.Extension();
        advisor.handleExtension(ConversionContext30_40.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext30_40.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension30_40.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension("", extension))//TODO add path
      .map(Extension30_40::convertExtension)
      .forEach(tgt::addModifierExtension);
  }
}
