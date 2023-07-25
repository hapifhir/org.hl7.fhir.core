package org.hl7.fhir.convertors.conv10_40.resources10_40;

import java.util.Arrays;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_40;
import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Extension10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Meta10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Narrative10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Extension;

public class Resource10_40 {

  public final BaseAdvisor_10_40 advisor;

  public Resource10_40(BaseAdvisor_10_40 advisor) {
    this.advisor = advisor;
  }

  public void copyResource(org.hl7.fhir.dstu2.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    tgt.setId(src.getId());
    tgt.setMeta(Meta10_40.convertMeta(src.getMeta()));
    tgt.setImplicitRules(src.getImplicitRules());
    tgt.setLanguage(src.getLanguage());
  }

  public void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.dstu2.model.Resource tgt) throws FHIRException {
    tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta10_40.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  public org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu2.model.Parameters)
      return Parameters10_40.convertParameters((org.hl7.fhir.dstu2.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Appointment)
      return Appointment10_40.convertAppointment((org.hl7.fhir.dstu2.model.Appointment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.AllergyIntolerance)
      return AllergyIntolerance10_40.convertAllergyIntolerance((org.hl7.fhir.dstu2.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.AppointmentResponse)
      return AppointmentResponse10_40.convertAppointmentResponse((org.hl7.fhir.dstu2.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.AuditEvent)
      return AuditEvent10_40.convertAuditEvent((org.hl7.fhir.dstu2.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Basic)
      return Basic10_40.convertBasic((org.hl7.fhir.dstu2.model.Basic) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Binary)
      return Binary10_40.convertBinary((org.hl7.fhir.dstu2.model.Binary) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Bundle)
      return Bundle10_40.convertBundle((org.hl7.fhir.dstu2.model.Bundle) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CarePlan)
      return CarePlan10_40.convertCarePlan((org.hl7.fhir.dstu2.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Communication)
      return Communication10_40.convertCommunication((org.hl7.fhir.dstu2.model.Communication) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CommunicationRequest)
      return CommunicationRequest10_40.convertCommunicationRequest((org.hl7.fhir.dstu2.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Composition)
      return Composition10_40.convertComposition((org.hl7.fhir.dstu2.model.Composition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ConceptMap)
      return ConceptMap10_40.convertConceptMap((org.hl7.fhir.dstu2.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Condition)
      return Condition10_40.convertCondition((org.hl7.fhir.dstu2.model.Condition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Conformance)
      return Conformance10_40.convertConformance((org.hl7.fhir.dstu2.model.Conformance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DataElement)
      return DataElement10_40.convertDataElement((org.hl7.fhir.dstu2.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DetectedIssue)
      return DetectedIssue10_40.convertDetectedIssue((org.hl7.fhir.dstu2.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DeviceMetric)
      return DeviceMetric10_40.convertDeviceMetric((org.hl7.fhir.dstu2.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DeviceUseStatement)
      return DeviceUseStatement10_40.convertDeviceUseStatement((org.hl7.fhir.dstu2.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DiagnosticReport)
      return DiagnosticReport10_40.convertDiagnosticReport((org.hl7.fhir.dstu2.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DocumentReference)
      return DocumentReference10_40.convertDocumentReference((org.hl7.fhir.dstu2.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Encounter)
      return Encounter10_40.convertEncounter((org.hl7.fhir.dstu2.model.Encounter) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentRequest)
      return EnrollmentRequest10_40.convertEnrollmentRequest((org.hl7.fhir.dstu2.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentResponse)
      return EnrollmentResponse10_40.convertEnrollmentResponse((org.hl7.fhir.dstu2.model.EnrollmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EpisodeOfCare)
      return EpisodeOfCare10_40.convertEpisodeOfCare((org.hl7.fhir.dstu2.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.dstu2.model.FamilyMemberHistory)
      return FamilyMemberHistory10_40.convertFamilyMemberHistory((org.hl7.fhir.dstu2.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Flag)
      return Flag10_40.convertFlag((org.hl7.fhir.dstu2.model.Flag) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Group)
      return Group10_40.convertGroup((org.hl7.fhir.dstu2.model.Group) src);
    if (src instanceof org.hl7.fhir.dstu2.model.HealthcareService)
      return HealthcareService10_40.convertHealthcareService((org.hl7.fhir.dstu2.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ImplementationGuide)
      return ImplementationGuide10_40.convertImplementationGuide((org.hl7.fhir.dstu2.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu2.model.List_)
      return List10_40.convertList((org.hl7.fhir.dstu2.model.List_) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Location)
      return Location10_40.convertLocation((org.hl7.fhir.dstu2.model.Location) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MedicationDispense)
      return MedicationDispense10_40.convertMedicationDispense((org.hl7.fhir.dstu2.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MedicationStatement)
      return MedicationStatement10_40.convertMedicationStatement((org.hl7.fhir.dstu2.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MedicationOrder)
      return MedicationRequest10_40.convertMedicationRequest((org.hl7.fhir.dstu2.model.MedicationOrder) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MessageHeader)
      return MessageHeader10_40.convertMessageHeader((org.hl7.fhir.dstu2.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.dstu2.model.NamingSystem)
      return NamingSystem10_40.convertNamingSystem((org.hl7.fhir.dstu2.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Observation)
      return Observation10_40.convertObservation((org.hl7.fhir.dstu2.model.Observation) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OperationDefinition)
      return OperationDefinition10_40.convertOperationDefinition((org.hl7.fhir.dstu2.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OperationOutcome)
      return OperationOutcome10_40.convertOperationOutcome((org.hl7.fhir.dstu2.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Organization)
      return Organization10_40.convertOrganization((org.hl7.fhir.dstu2.model.Organization) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Patient)
      return Patient10_40.convertPatient((org.hl7.fhir.dstu2.model.Patient) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Person)
      return Person10_40.convertPerson((org.hl7.fhir.dstu2.model.Person) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Practitioner)
      return Practitioner10_40.convertPractitioner((org.hl7.fhir.dstu2.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Questionnaire)
      return Questionnaire10_40.convertQuestionnaire((org.hl7.fhir.dstu2.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu2.model.QuestionnaireResponse)
      return QuestionnaireResponse10_40.convertQuestionnaireResponse((org.hl7.fhir.dstu2.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.RiskAssessment)
      return RiskAssessment10_40.convertRiskAssessment((org.hl7.fhir.dstu2.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Schedule)
      return Schedule10_40.convertSchedule((org.hl7.fhir.dstu2.model.Schedule) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SearchParameter)
      return SearchParameter10_40.convertSearchParameter((org.hl7.fhir.dstu2.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Slot)
      return Slot10_40.convertSlot((org.hl7.fhir.dstu2.model.Slot) src);
    if (src instanceof org.hl7.fhir.dstu2.model.StructureDefinition)
      return StructureDefinition10_40.convertStructureDefinition((org.hl7.fhir.dstu2.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Subscription)
      return Subscription10_40.convertSubscription((org.hl7.fhir.dstu2.model.Subscription) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Substance)
      return Substance10_40.convertSubstance((org.hl7.fhir.dstu2.model.Substance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SupplyDelivery)
      return SupplyDelivery10_40.convertSupplyDelivery((org.hl7.fhir.dstu2.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SupplyRequest)
      return SupplyRequest10_40.convertSupplyRequest((org.hl7.fhir.dstu2.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.TestScript)
      return TestScript10_40.convertTestScript((org.hl7.fhir.dstu2.model.TestScript) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ValueSet)
      return ValueSet10_40.convertValueSet((org.hl7.fhir.dstu2.model.ValueSet) src, advisor);
    if (src instanceof org.hl7.fhir.dstu2.model.Procedure)
      return Procedure10_40.convertProcedure((org.hl7.fhir.dstu2.model.Procedure) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Medication)
      return Medication10_40.convertMedication((org.hl7.fhir.dstu2.model.Medication) src);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R2 to R4");
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r4.model.Parameters)
      return Parameters10_40.convertParameters((org.hl7.fhir.r4.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r4.model.Appointment)
      return Appointment10_40.convertAppointment((org.hl7.fhir.r4.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r4.model.AppointmentResponse)
      return AppointmentResponse10_40.convertAppointmentResponse((org.hl7.fhir.r4.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.AuditEvent)
      return AuditEvent10_40.convertAuditEvent((org.hl7.fhir.r4.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r4.model.Basic)
      return Basic10_40.convertBasic((org.hl7.fhir.r4.model.Basic) src);
    if (src instanceof org.hl7.fhir.r4.model.Binary)
      return Binary10_40.convertBinary((org.hl7.fhir.r4.model.Binary) src);
    if (src instanceof org.hl7.fhir.r4.model.Bundle)
      return Bundle10_40.convertBundle((org.hl7.fhir.r4.model.Bundle) src, advisor);
    if (src instanceof org.hl7.fhir.r4.model.CarePlan)
      return CarePlan10_40.convertCarePlan((org.hl7.fhir.r4.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r4.model.Communication)
      return Communication10_40.convertCommunication((org.hl7.fhir.r4.model.Communication) src);
    if (src instanceof org.hl7.fhir.r4.model.CommunicationRequest)
      return CommunicationRequest10_40.convertCommunicationRequest((org.hl7.fhir.r4.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.Composition)
      return Composition10_40.convertComposition((org.hl7.fhir.r4.model.Composition) src);
    if (src instanceof org.hl7.fhir.r4.model.ConceptMap)
      return ConceptMap10_40.convertConceptMap((org.hl7.fhir.r4.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r4.model.Condition)
      return Condition10_40.convertCondition((org.hl7.fhir.r4.model.Condition) src);
    if (src instanceof org.hl7.fhir.r4.model.CapabilityStatement)
      return Conformance10_40.convertConformance((org.hl7.fhir.r4.model.CapabilityStatement) src, advisor);
    if (src instanceof org.hl7.fhir.r4.model.DetectedIssue)
      return DetectedIssue10_40.convertDetectedIssue((org.hl7.fhir.r4.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceMetric)
      return DeviceMetric10_40.convertDeviceMetric((org.hl7.fhir.r4.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.r4.model.DeviceUseStatement)
      return DeviceUseStatement10_40.convertDeviceUseStatement((org.hl7.fhir.r4.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.DiagnosticReport)
      return DiagnosticReport10_40.convertDiagnosticReport((org.hl7.fhir.r4.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.r4.model.DocumentReference)
      return DocumentReference10_40.convertDocumentReference((org.hl7.fhir.r4.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r4.model.Encounter)
      return Encounter10_40.convertEncounter((org.hl7.fhir.r4.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r4.model.EnrollmentRequest)
      return EnrollmentRequest10_40.convertEnrollmentRequest((org.hl7.fhir.r4.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.EnrollmentResponse)
      return EnrollmentResponse10_40.convertEnrollmentResponse((org.hl7.fhir.r4.model.EnrollmentResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.EpisodeOfCare)
      return EpisodeOfCare10_40.convertEpisodeOfCare((org.hl7.fhir.r4.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r4.model.FamilyMemberHistory)
      return FamilyMemberHistory10_40.convertFamilyMemberHistory((org.hl7.fhir.r4.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r4.model.Flag) return Flag10_40.convertFlag((org.hl7.fhir.r4.model.Flag) src);
    if (src instanceof org.hl7.fhir.r4.model.Group)
      return Group10_40.convertGroup((org.hl7.fhir.r4.model.Group) src);
    if (src instanceof org.hl7.fhir.r4.model.HealthcareService)
      return HealthcareService10_40.convertHealthcareService((org.hl7.fhir.r4.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r4.model.ImplementationGuide)
      return ImplementationGuide10_40.convertImplementationGuide((org.hl7.fhir.r4.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r4.model.ListResource)
      return List10_40.convertList((org.hl7.fhir.r4.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r4.model.Location)
      return Location10_40.convertLocation((org.hl7.fhir.r4.model.Location) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationDispense)
      return MedicationDispense10_40.convertMedicationDispense((org.hl7.fhir.r4.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r4.model.MedicationStatement)
      return MedicationStatement10_40.convertMedicationStatement((org.hl7.fhir.r4.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r4.model.MessageHeader)
      return MessageHeader10_40.convertMessageHeader((org.hl7.fhir.r4.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r4.model.NamingSystem)
      return NamingSystem10_40.convertNamingSystem((org.hl7.fhir.r4.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r4.model.Observation)
      return Observation10_40.convertObservation((org.hl7.fhir.r4.model.Observation) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationDefinition)
      return OperationDefinition10_40.convertOperationDefinition((org.hl7.fhir.r4.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.OperationOutcome)
      return OperationOutcome10_40.convertOperationOutcome((org.hl7.fhir.r4.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r4.model.Organization)
      return Organization10_40.convertOrganization((org.hl7.fhir.r4.model.Organization) src);
    if (src instanceof org.hl7.fhir.r4.model.Patient)
      return Patient10_40.convertPatient((org.hl7.fhir.r4.model.Patient) src);
    if (src instanceof org.hl7.fhir.r4.model.Person)
      return Person10_40.convertPerson((org.hl7.fhir.r4.model.Person) src);
    if (src instanceof org.hl7.fhir.r4.model.Practitioner)
      return Practitioner10_40.convertPractitioner((org.hl7.fhir.r4.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r4.model.Questionnaire)
      return Questionnaire10_40.convertQuestionnaire((org.hl7.fhir.r4.model.Questionnaire) src, advisor);
    if (src instanceof org.hl7.fhir.r4.model.QuestionnaireResponse)
      return QuestionnaireResponse10_40.convertQuestionnaireResponse((org.hl7.fhir.r4.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r4.model.RiskAssessment)
      return RiskAssessment10_40.convertRiskAssessment((org.hl7.fhir.r4.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r4.model.Schedule)
      return Schedule10_40.convertSchedule((org.hl7.fhir.r4.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r4.model.SearchParameter)
      return SearchParameter10_40.convertSearchParameter((org.hl7.fhir.r4.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r4.model.Slot) return Slot10_40.convertSlot((org.hl7.fhir.r4.model.Slot) src);
    if (src instanceof org.hl7.fhir.r4.model.StructureDefinition)
      return StructureDefinition10_40.convertStructureDefinition((org.hl7.fhir.r4.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r4.model.Subscription)
      return Subscription10_40.convertSubscription((org.hl7.fhir.r4.model.Subscription) src);
    if (src instanceof org.hl7.fhir.r4.model.Substance)
      return Substance10_40.convertSubstance((org.hl7.fhir.r4.model.Substance) src);
    if (src instanceof org.hl7.fhir.r4.model.SupplyDelivery)
      return SupplyDelivery10_40.convertSupplyDelivery((org.hl7.fhir.r4.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.r4.model.SupplyRequest)
      return SupplyRequest10_40.convertSupplyRequest((org.hl7.fhir.r4.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.r4.model.TestScript)
      return TestScript10_40.convertTestScript((org.hl7.fhir.r4.model.TestScript) src);
    if (src instanceof org.hl7.fhir.r4.model.ValueSet)
      return ValueSet10_40.convertValueSet((org.hl7.fhir.r4.model.ValueSet) src, advisor);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("The resource " + src.fhirType()+" cannot be converted from R4 to R2");
    } else {
      return null;
    }
  }

  public void copyDomainResource(
  org.hl7.fhir.dstu2.model.DomainResource src,
  org.hl7.fhir.r4.model.DomainResource tgt,
  String ... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative10_40.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext10_40.INSTANCE.path(), extension)) {
        Extension convertExtension = new Extension();
        advisor.handleExtension(ConversionContext10_40.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext10_40.INSTANCE.path(), extension) && !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension10_40.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext10_40.INSTANCE.path(), extension))
      .map(Extension10_40::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public void copyDomainResource(
    org.hl7.fhir.r4.model.DomainResource src,
    org.hl7.fhir.dstu2.model.DomainResource tgt,
    String ... extensionUrlsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative10_40.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext10_40.INSTANCE.path(), extension)) {
        org.hl7.fhir.dstu2.model.Extension convertExtension = new org.hl7.fhir.dstu2.model.Extension();
        advisor.handleExtension(ConversionContext10_40.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext10_40.INSTANCE.path(), extension)&& !Arrays.asList(extensionUrlsToIgnore).contains(extension.getUrl())) {
        tgt.addExtension(Extension10_40.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext10_40.INSTANCE.path(), extension))
      .map(Extension10_40::convertExtension)
      .forEach(tgt::addModifierExtension);
  }
}
