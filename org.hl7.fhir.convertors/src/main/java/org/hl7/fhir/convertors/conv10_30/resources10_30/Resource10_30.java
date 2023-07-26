package org.hl7.fhir.convertors.conv10_30.resources10_30;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Extension10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Meta10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Narrative10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Resource10_30 {

  public final BaseAdvisor_10_30 advisor;

  public Resource10_30(BaseAdvisor_10_30 advisor) {
    this.advisor = advisor;
  }

  public void copyDomainResource(
    org.hl7.fhir.dstu2.model.DomainResource src,
    org.hl7.fhir.dstu3.model.DomainResource tgt,
    String ... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    tgt.setText(Narrative10_30.convertNarrative(src.getText()));
    for (org.hl7.fhir.dstu2.model.Resource containedResource : src.getContained()) tgt.addContained(convertResource(containedResource));
    for (org.hl7.fhir.dstu2.model.Extension extension : src.getExtension())
      if (!Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl()))
        tgt.addExtension(Extension10_30.convertExtension(extension));

    for (org.hl7.fhir.dstu2.model.Extension modifierExtension : src.getModifierExtension())
      tgt.addModifierExtension(Extension10_30.convertExtension(modifierExtension));
  }

  public void copyDomainResource(
    org.hl7.fhir.dstu3.model.DomainResource src,
    org.hl7.fhir.dstu2.model.DomainResource tgt,
    String ... extensionUrlsToIgnore
    ) throws FHIRException {
    copyResource(src, tgt);
    tgt.setText(Narrative10_30.convertNarrative(src.getText()));
    for (org.hl7.fhir.dstu3.model.Resource containedResource : src.getContained()) tgt.addContained(convertResource(containedResource));
    for (org.hl7.fhir.dstu3.model.Extension extension : src.getExtension())
      if (!Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl()))
      tgt.addExtension(Extension10_30.convertExtension(extension));
    for (org.hl7.fhir.dstu3.model.Extension modifierExtension : src.getModifierExtension())
      tgt.addModifierExtension(Extension10_30.convertExtension(modifierExtension));
  }

  public void copyResource(org.hl7.fhir.dstu2.model.Resource src, org.hl7.fhir.dstu3.model.Resource tgt) throws FHIRException {
    tgt.setId(src.getId());
    tgt.setMeta(Meta10_30.convertMeta(src.getMeta()));
    tgt.setImplicitRules(src.getImplicitRules());
    tgt.setLanguage(src.getLanguage());
  }

  public void copyResource(org.hl7.fhir.dstu3.model.Resource src, org.hl7.fhir.dstu2.model.Resource tgt) throws FHIRException {
    tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta10_30.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  public org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu2.model.Parameters)
      return Parameters10_30.convertParameters((org.hl7.fhir.dstu2.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Account)
      return Account10_30.convertAccount((org.hl7.fhir.dstu2.model.Account) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Appointment)
      return Appointment10_30.convertAppointment((org.hl7.fhir.dstu2.model.Appointment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.AppointmentResponse)
      return AppointmentResponse10_30.convertAppointmentResponse((org.hl7.fhir.dstu2.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.AllergyIntolerance)
      return AllergyIntolerance10_30.convertAllergyIntolerance((org.hl7.fhir.dstu2.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.AuditEvent)
      return AuditEvent10_30.convertAuditEvent((org.hl7.fhir.dstu2.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Basic)
      return Basic10_30.convertBasic((org.hl7.fhir.dstu2.model.Basic) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Binary)
      return Binary10_30.convertBinary((org.hl7.fhir.dstu2.model.Binary) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Bundle)
      return Bundle10_30.convertBundle((org.hl7.fhir.dstu2.model.Bundle) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CarePlan)
      return CarePlan10_30.convertCarePlan((org.hl7.fhir.dstu2.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ClinicalImpression)
      return ClinicalImpression10_30.convertClinicalImpression((org.hl7.fhir.dstu2.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Communication)
      return Communication10_30.convertCommunication((org.hl7.fhir.dstu2.model.Communication) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CommunicationRequest)
      return CommunicationRequest10_30.convertCommunicationRequest((org.hl7.fhir.dstu2.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Composition)
      return Composition10_30.convertComposition((org.hl7.fhir.dstu2.model.Composition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ConceptMap)
      return ConceptMap10_30.convertConceptMap((org.hl7.fhir.dstu2.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Condition)
      return Condition10_30.convertCondition((org.hl7.fhir.dstu2.model.Condition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Conformance)
      return Conformance10_30.convertConformance((org.hl7.fhir.dstu2.model.Conformance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Contract)
      return Contract10_30.convertContract((org.hl7.fhir.dstu2.model.Contract) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DataElement)
      return DataElement10_30.convertDataElement((org.hl7.fhir.dstu2.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DetectedIssue)
      return DetectedIssue10_30.convertDetectedIssue((org.hl7.fhir.dstu2.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Device)
      return Device10_30.convertDevice((org.hl7.fhir.dstu2.model.Device) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DeviceComponent)
      return DeviceComponent10_30.convertDeviceComponent((org.hl7.fhir.dstu2.model.DeviceComponent) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DeviceMetric)
      return DeviceMetric10_30.convertDeviceMetric((org.hl7.fhir.dstu2.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DeviceUseStatement)
      return DeviceUseStatement10_30.convertDeviceUseStatement((org.hl7.fhir.dstu2.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DiagnosticReport)
      return DiagnosticReport10_30.convertDiagnosticReport((org.hl7.fhir.dstu2.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DocumentManifest)
      return DocumentManifest10_30.convertDocumentManifest((org.hl7.fhir.dstu2.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DocumentReference)
      return DocumentReference10_30.convertDocumentReference((org.hl7.fhir.dstu2.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Encounter)
      return Encounter10_30.convertEncounter((org.hl7.fhir.dstu2.model.Encounter) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentRequest)
      return EnrollmentRequest10_30.convertEnrollmentRequest((org.hl7.fhir.dstu2.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentResponse)
      return EnrollmentResponse10_30.convertEnrollmentResponse((org.hl7.fhir.dstu2.model.EnrollmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EpisodeOfCare)
      return EpisodeOfCare10_30.convertEpisodeOfCare((org.hl7.fhir.dstu2.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.dstu2.model.FamilyMemberHistory)
      return FamilyMemberHistory10_30.convertFamilyMemberHistory((org.hl7.fhir.dstu2.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Flag)
      return Flag10_30.convertFlag((org.hl7.fhir.dstu2.model.Flag) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Group)
      return Group10_30.convertGroup((org.hl7.fhir.dstu2.model.Group) src);
    if (src instanceof org.hl7.fhir.dstu2.model.HealthcareService)
      return HealthcareService10_30.convertHealthcareService((org.hl7.fhir.dstu2.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ImagingStudy)
      return ImagingStudy10_30.convertImagingStudy((org.hl7.fhir.dstu2.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Immunization)
      return Immunization10_30.convertImmunization((org.hl7.fhir.dstu2.model.Immunization) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ImmunizationRecommendation)
      return ImmunizationRecommendation10_30.convertImmunizationRecommendation((org.hl7.fhir.dstu2.model.ImmunizationRecommendation) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ImplementationGuide)
      return ImplementationGuide10_30.convertImplementationGuide((org.hl7.fhir.dstu2.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu2.model.List_)
      return List10_30.convertList((org.hl7.fhir.dstu2.model.List_) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Location)
      return Location10_30.convertLocation((org.hl7.fhir.dstu2.model.Location) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Media)
      return Media10_30.convertMedia((org.hl7.fhir.dstu2.model.Media) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Medication)
      return Medication10_30.convertMedication((org.hl7.fhir.dstu2.model.Medication) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MedicationDispense)
      return MedicationDispense10_30.convertMedicationDispense((org.hl7.fhir.dstu2.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MedicationOrder)
      return MedicationRequest10_30.convertMedicationOrder((org.hl7.fhir.dstu2.model.MedicationOrder) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MedicationStatement)
      return MedicationStatement10_30.convertMedicationStatement((org.hl7.fhir.dstu2.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MessageHeader)
      return MessageHeader10_30.convertMessageHeader((org.hl7.fhir.dstu2.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.dstu2.model.NamingSystem)
      return NamingSystem10_30.convertNamingSystem((org.hl7.fhir.dstu2.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Observation)
      return Observation10_30.convertObservation((org.hl7.fhir.dstu2.model.Observation) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OperationDefinition)
      return OperationDefinition10_30.convertOperationDefinition((org.hl7.fhir.dstu2.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OperationOutcome)
      return OperationOutcome10_30.convertOperationOutcome((org.hl7.fhir.dstu2.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Organization)
      return Organization10_30.convertOrganization((org.hl7.fhir.dstu2.model.Organization) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Patient)
      return Patient10_30.convertPatient((org.hl7.fhir.dstu2.model.Patient) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Person)
      return Person10_30.convertPerson((org.hl7.fhir.dstu2.model.Person) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Practitioner)
      return Practitioner10_30.convertPractitioner((org.hl7.fhir.dstu2.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Procedure)
      return Procedure10_30.convertProcedure((org.hl7.fhir.dstu2.model.Procedure) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ProcedureRequest)
      return ProcedureRequest10_30.convertProcedureRequest((org.hl7.fhir.dstu2.model.ProcedureRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Provenance)
      return Provenance10_30.convertProvenance((org.hl7.fhir.dstu2.model.Provenance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Questionnaire)
      return Questionnaire10_30.convertQuestionnaire((org.hl7.fhir.dstu2.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu2.model.QuestionnaireResponse)
      return QuestionnaireResponse10_30.convertQuestionnaireResponse((org.hl7.fhir.dstu2.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ReferralRequest)
      return ReferralRequest10_30.convertReferralRequest((org.hl7.fhir.dstu2.model.ReferralRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.RelatedPerson)
      return RelatedPerson10_30.convertRelatedPerson((org.hl7.fhir.dstu2.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.dstu2.model.RiskAssessment)
      return RiskAssessment10_30.convertRiskAssessment((org.hl7.fhir.dstu2.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Schedule)
      return Schedule10_30.convertSchedule((org.hl7.fhir.dstu2.model.Schedule) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SearchParameter)
      return SearchParameter10_30.convertSearchParameter((org.hl7.fhir.dstu2.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Slot)
      return Slot10_30.convertSlot((org.hl7.fhir.dstu2.model.Slot) src);
    if (src instanceof org.hl7.fhir.dstu2.model.StructureDefinition)
      return StructureDefinition10_30.convertStructureDefinition((org.hl7.fhir.dstu2.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Subscription)
      return Subscription10_30.convertSubscription((org.hl7.fhir.dstu2.model.Subscription) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Substance)
      return Substance10_30.convertSubstance((org.hl7.fhir.dstu2.model.Substance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SupplyDelivery)
      return SupplyDelivery10_30.convertSupplyDelivery((org.hl7.fhir.dstu2.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SupplyRequest)
      return SupplyRequest10_30.convertSupplyRequest((org.hl7.fhir.dstu2.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.TestScript)
      return TestScript10_30.convertTestScript((org.hl7.fhir.dstu2.model.TestScript) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ValueSet)
      return ValueSet10_30.convertValueSet((org.hl7.fhir.dstu2.model.ValueSet) src, advisor);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R2 to R3");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu3.model.Parameters)
      return Parameters10_30.convertParameters((org.hl7.fhir.dstu3.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Appointment)
      return Appointment10_30.convertAppointment((org.hl7.fhir.dstu3.model.Appointment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AppointmentResponse)
      return AppointmentResponse10_30.convertAppointmentResponse((org.hl7.fhir.dstu3.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AuditEvent)
      return AuditEvent10_30.convertAuditEvent((org.hl7.fhir.dstu3.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Basic)
      return Basic10_30.convertBasic((org.hl7.fhir.dstu3.model.Basic) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Binary)
      return Binary10_30.convertBinary((org.hl7.fhir.dstu3.model.Binary) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Bundle)
      return Bundle10_30.convertBundle((org.hl7.fhir.dstu3.model.Bundle) src, advisor);
    if (src instanceof org.hl7.fhir.dstu3.model.CarePlan)
      return CarePlan10_30.convertCarePlan((org.hl7.fhir.dstu3.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ClinicalImpression)
      return ClinicalImpression10_30.convertClinicalImpression((org.hl7.fhir.dstu3.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Communication)
      return Communication10_30.convertCommunication((org.hl7.fhir.dstu3.model.Communication) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CommunicationRequest)
      return CommunicationRequest10_30.convertCommunicationRequest((org.hl7.fhir.dstu3.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Composition)
      return Composition10_30.convertComposition((org.hl7.fhir.dstu3.model.Composition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ConceptMap)
      return ConceptMap10_30.convertConceptMap((org.hl7.fhir.dstu3.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Condition)
      return Condition10_30.convertCondition((org.hl7.fhir.dstu3.model.Condition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CapabilityStatement)
      return Conformance10_30.convertConformance((org.hl7.fhir.dstu3.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Contract)
      return Contract10_30.convertContract((org.hl7.fhir.dstu3.model.Contract) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DataElement)
      return DataElement10_30.convertDataElement((org.hl7.fhir.dstu3.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DetectedIssue)
      return DetectedIssue10_30.convertDetectedIssue((org.hl7.fhir.dstu3.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Device)
      return Device10_30.convertDevice((org.hl7.fhir.dstu3.model.Device) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DeviceComponent)
      return DeviceComponent10_30.convertDeviceComponent((org.hl7.fhir.dstu3.model.DeviceComponent) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DeviceMetric)
      return DeviceMetric10_30.convertDeviceMetric((org.hl7.fhir.dstu3.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DeviceUseStatement)
      return DeviceUseStatement10_30.convertDeviceUseStatement((org.hl7.fhir.dstu3.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DiagnosticReport)
      return DiagnosticReport10_30.convertDiagnosticReport((org.hl7.fhir.dstu3.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DocumentManifest)
      return DocumentManifest10_30.convertDocumentManifest((org.hl7.fhir.dstu3.model.DocumentManifest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DocumentReference)
      return DocumentReference10_30.convertDocumentReference((org.hl7.fhir.dstu3.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Encounter)
      return Encounter10_30.convertEncounter((org.hl7.fhir.dstu3.model.Encounter) src);
    if (src instanceof org.hl7.fhir.dstu3.model.EnrollmentRequest)
      return EnrollmentRequest10_30.convertEnrollmentRequest((org.hl7.fhir.dstu3.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.EnrollmentResponse)
      return EnrollmentResponse10_30.convertEnrollmentResponse((org.hl7.fhir.dstu3.model.EnrollmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.EpisodeOfCare)
      return EpisodeOfCare10_30.convertEpisodeOfCare((org.hl7.fhir.dstu3.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.dstu3.model.FamilyMemberHistory)
      return FamilyMemberHistory10_30.convertFamilyMemberHistory((org.hl7.fhir.dstu3.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Flag)
      return Flag10_30.convertFlag((org.hl7.fhir.dstu3.model.Flag) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Group)
      return Group10_30.convertGroup((org.hl7.fhir.dstu3.model.Group) src);
    if (src instanceof org.hl7.fhir.dstu3.model.HealthcareService)
      return HealthcareService10_30.convertHealthcareService((org.hl7.fhir.dstu3.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImagingStudy)
      return ImagingStudy10_30.convertImagingStudy((org.hl7.fhir.dstu3.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Immunization)
      return Immunization10_30.convertImmunization((org.hl7.fhir.dstu3.model.Immunization) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImmunizationRecommendation)
      return ImmunizationRecommendation10_30.convertImmunizationRecommendation((org.hl7.fhir.dstu3.model.ImmunizationRecommendation) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImplementationGuide)
      return ImplementationGuide10_30.convertImplementationGuide((org.hl7.fhir.dstu3.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ListResource)
      return List10_30.convertList((org.hl7.fhir.dstu3.model.ListResource) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Location)
      return Location10_30.convertLocation((org.hl7.fhir.dstu3.model.Location) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Media)
      return Media10_30.convertMedia((org.hl7.fhir.dstu3.model.Media) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Medication)
      return Medication10_30.convertMedication((org.hl7.fhir.dstu3.model.Medication) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationDispense)
      return MedicationDispense10_30.convertMedicationDispense((org.hl7.fhir.dstu3.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationStatement)
      return MedicationStatement10_30.convertMedicationStatement((org.hl7.fhir.dstu3.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MessageHeader)
      return MessageHeader10_30.convertMessageHeader((org.hl7.fhir.dstu3.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.dstu3.model.NamingSystem)
      return NamingSystem10_30.convertNamingSystem((org.hl7.fhir.dstu3.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Observation)
      return Observation10_30.convertObservation((org.hl7.fhir.dstu3.model.Observation) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationDefinition)
      return OperationDefinition10_30.convertOperationDefinition((org.hl7.fhir.dstu3.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationOutcome)
      return OperationOutcome10_30.convertOperationOutcome((org.hl7.fhir.dstu3.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Organization)
      return Organization10_30.convertOrganization((org.hl7.fhir.dstu3.model.Organization) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Patient)
      return Patient10_30.convertPatient((org.hl7.fhir.dstu3.model.Patient) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Person)
      return Person10_30.convertPerson((org.hl7.fhir.dstu3.model.Person) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Practitioner)
      return Practitioner10_30.convertPractitioner((org.hl7.fhir.dstu3.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Procedure)
      return Procedure10_30.convertProcedure((org.hl7.fhir.dstu3.model.Procedure) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ProcedureRequest)
      return ProcedureRequest10_30.convertProcedureRequest((org.hl7.fhir.dstu3.model.ProcedureRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Provenance)
      return Provenance10_30.convertProvenance((org.hl7.fhir.dstu3.model.Provenance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Questionnaire)
      return Questionnaire10_30.convertQuestionnaire((org.hl7.fhir.dstu3.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu3.model.QuestionnaireResponse)
      return QuestionnaireResponse10_30.convertQuestionnaireResponse((org.hl7.fhir.dstu3.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ReferralRequest)
      return ReferralRequest10_30.convertReferralRequest((org.hl7.fhir.dstu3.model.ReferralRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RelatedPerson)
      return RelatedPerson10_30.convertRelatedPerson((org.hl7.fhir.dstu3.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RiskAssessment)
      return RiskAssessment10_30.convertRiskAssessment((org.hl7.fhir.dstu3.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Schedule)
      return Schedule10_30.convertSchedule((org.hl7.fhir.dstu3.model.Schedule) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SearchParameter)
      return SearchParameter10_30.convertSearchParameter((org.hl7.fhir.dstu3.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Slot)
      return Slot10_30.convertSlot((org.hl7.fhir.dstu3.model.Slot) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Specimen)
      return Specimen10_30.convertSpecimen((org.hl7.fhir.dstu3.model.Specimen) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StructureDefinition)
      return StructureDefinition10_30.convertStructureDefinition((org.hl7.fhir.dstu3.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Subscription)
      return Subscription10_30.convertSubscription((org.hl7.fhir.dstu3.model.Subscription) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Substance)
      return Substance10_30.convertSubstance((org.hl7.fhir.dstu3.model.Substance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SupplyDelivery)
      return SupplyDelivery10_30.convertSupplyDelivery((org.hl7.fhir.dstu3.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SupplyRequest)
      return SupplyRequest10_30.convertSupplyRequest((org.hl7.fhir.dstu3.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TestScript)
      return TestScript10_30.convertTestScript((org.hl7.fhir.dstu3.model.TestScript) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ValueSet)
      return ValueSet10_30.convertValueSet((org.hl7.fhir.dstu3.model.ValueSet) src, advisor);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R3 to R2");
    } else {
      return null;
    }
  }
}
