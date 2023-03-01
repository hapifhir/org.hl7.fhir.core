package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_50;
import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Extension10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Meta10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Narrative10_50;
import org.hl7.fhir.dstu2.model.Extension;
import org.hl7.fhir.exceptions.FHIRException;

public class Resource10_50 {

  public final BaseAdvisor_10_50 advisor;

  public Resource10_50(BaseAdvisor_10_50 advisor) {
    this.advisor = advisor;
  }

  public void copyResource(org.hl7.fhir.dstu2.model.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta10_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  public void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.dstu2.model.Resource tgt) throws FHIRException {
    tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta10_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  public org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.dstu2.model.Parameters)
      return Parameters10_50.convertParameters((org.hl7.fhir.dstu2.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Appointment)
      return Appointment10_50.convertAppointment((org.hl7.fhir.dstu2.model.Appointment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.AppointmentResponse)
      return AppointmentResponse10_50.convertAppointmentResponse((org.hl7.fhir.dstu2.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.AuditEvent)
      return AuditEvent10_50.convertAuditEvent((org.hl7.fhir.dstu2.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Basic)
      return Basic10_50.convertBasic((org.hl7.fhir.dstu2.model.Basic) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Binary)
      return Binary10_50.convertBinary((org.hl7.fhir.dstu2.model.Binary) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Bundle)
      return Bundle10_50.convertBundle((org.hl7.fhir.dstu2.model.Bundle) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CarePlan)
      return CarePlan10_50.convertCarePlan((org.hl7.fhir.dstu2.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Communication)
      return Communication10_50.convertCommunication((org.hl7.fhir.dstu2.model.Communication) src);
    if (src instanceof org.hl7.fhir.dstu2.model.CommunicationRequest)
      return CommunicationRequest10_50.convertCommunicationRequest((org.hl7.fhir.dstu2.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Composition)
      return Composition10_50.convertComposition((org.hl7.fhir.dstu2.model.Composition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ConceptMap)
      return ConceptMap10_50.convertConceptMap((org.hl7.fhir.dstu2.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Condition)
      return Condition10_50.convertCondition((org.hl7.fhir.dstu2.model.Condition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Conformance)
      return Conformance10_50.convertConformance((org.hl7.fhir.dstu2.model.Conformance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DataElement)
      return DataElement10_50.convertDataElement((org.hl7.fhir.dstu2.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DetectedIssue)
      return DetectedIssue10_50.convertDetectedIssue((org.hl7.fhir.dstu2.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DeviceMetric)
      return DeviceMetric10_50.convertDeviceMetric((org.hl7.fhir.dstu2.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DeviceUseStatement)
      return DeviceUseStatement10_50.convertDeviceUseStatement((org.hl7.fhir.dstu2.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DiagnosticReport)
      return DiagnosticReport10_50.convertDiagnosticReport((org.hl7.fhir.dstu2.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.dstu2.model.DocumentReference)
      return DocumentReference10_50.convertDocumentReference((org.hl7.fhir.dstu2.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Encounter)
      return Encounter10_50.convertEncounter((org.hl7.fhir.dstu2.model.Encounter) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentRequest)
      return EnrollmentRequest10_50.convertEnrollmentRequest((org.hl7.fhir.dstu2.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentResponse)
      return EnrollmentResponse10_50.convertEnrollmentResponse((org.hl7.fhir.dstu2.model.EnrollmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.EpisodeOfCare)
      return EpisodeOfCare10_50.convertEpisodeOfCare((org.hl7.fhir.dstu2.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.dstu2.model.FamilyMemberHistory)
      return FamilyMemberHistory10_50.convertFamilyMemberHistory((org.hl7.fhir.dstu2.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Flag)
      return Flag10_50.convertFlag((org.hl7.fhir.dstu2.model.Flag) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Group)
      return Group10_50.convertGroup((org.hl7.fhir.dstu2.model.Group) src);
    if (src instanceof org.hl7.fhir.dstu2.model.HealthcareService)
      return HealthcareService10_50.convertHealthcareService((org.hl7.fhir.dstu2.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ImplementationGuide)
      return ImplementationGuide10_50.convertImplementationGuide((org.hl7.fhir.dstu2.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu2.model.List_)
      return List10_50.convertList((org.hl7.fhir.dstu2.model.List_) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Location)
      return Location10_50.convertLocation((org.hl7.fhir.dstu2.model.Location) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MedicationDispense)
      return MedicationDispense10_50.convertMedicationDispense((org.hl7.fhir.dstu2.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MedicationStatement)
      return MedicationStatement10_50.convertMedicationStatement((org.hl7.fhir.dstu2.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.dstu2.model.MessageHeader)
      return MessageHeader10_50.convertMessageHeader((org.hl7.fhir.dstu2.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.dstu2.model.NamingSystem)
      return NamingSystem10_50.convertNamingSystem((org.hl7.fhir.dstu2.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Observation)
      return Observation10_50.convertObservation((org.hl7.fhir.dstu2.model.Observation) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OperationDefinition)
      return OperationDefinition10_50.convertOperationDefinition((org.hl7.fhir.dstu2.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.OperationOutcome)
      return OperationOutcome10_50.convertOperationOutcome((org.hl7.fhir.dstu2.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Organization)
      return Organization10_50.convertOrganization((org.hl7.fhir.dstu2.model.Organization) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Patient)
      return Patient10_50.convertPatient((org.hl7.fhir.dstu2.model.Patient) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Person)
      return Person10_50.convertPerson((org.hl7.fhir.dstu2.model.Person) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Practitioner)
      return Practitioner10_50.convertPractitioner((org.hl7.fhir.dstu2.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Provenance)
      return Provenance10_50.convertProvenance((org.hl7.fhir.dstu2.model.Provenance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Questionnaire)
      return Questionnaire10_50.convertQuestionnaire((org.hl7.fhir.dstu2.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu2.model.QuestionnaireResponse)
      return QuestionnaireResponse10_50.convertQuestionnaireResponse((org.hl7.fhir.dstu2.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu2.model.RiskAssessment)
      return RiskAssessment10_50.convertRiskAssessment((org.hl7.fhir.dstu2.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Schedule)
      return Schedule10_50.convertSchedule((org.hl7.fhir.dstu2.model.Schedule) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SearchParameter)
      return SearchParameter10_50.convertSearchParameter((org.hl7.fhir.dstu2.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Slot)
      return Slot10_50.convertSlot((org.hl7.fhir.dstu2.model.Slot) src);
    if (src instanceof org.hl7.fhir.dstu2.model.StructureDefinition)
      return StructureDefinition10_50.convertStructureDefinition((org.hl7.fhir.dstu2.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu2.model.Substance)
      return Substance10_50.convertSubstance((org.hl7.fhir.dstu2.model.Substance) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SupplyDelivery)
      return SupplyDelivery10_50.convertSupplyDelivery((org.hl7.fhir.dstu2.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.dstu2.model.SupplyRequest)
      return SupplyRequest10_50.convertSupplyRequest((org.hl7.fhir.dstu2.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.dstu2.model.TestScript)
      return TestScript10_50.convertTestScript((org.hl7.fhir.dstu2.model.TestScript) src);
    if (src instanceof org.hl7.fhir.dstu2.model.ValueSet)
      return ValueSet10_50.convertValueSet((org.hl7.fhir.dstu2.model.ValueSet) src, advisor);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("Unknown resource " + src.fhirType());
    } else {
      return null;
    }
  }

  public org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    if (src instanceof org.hl7.fhir.r5.model.Parameters)
      return Parameters10_50.convertParameters((org.hl7.fhir.r5.model.Parameters) src);
    if (src instanceof org.hl7.fhir.r5.model.Appointment)
      return Appointment10_50.convertAppointment((org.hl7.fhir.r5.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r5.model.AppointmentResponse)
      return AppointmentResponse10_50.convertAppointmentResponse((org.hl7.fhir.r5.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.AuditEvent)
      return AuditEvent10_50.convertAuditEvent((org.hl7.fhir.r5.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r5.model.Basic)
      return Basic10_50.convertBasic((org.hl7.fhir.r5.model.Basic) src);
    if (src instanceof org.hl7.fhir.r5.model.Binary)
      return Binary10_50.convertBinary((org.hl7.fhir.r5.model.Binary) src);
    if (src instanceof org.hl7.fhir.r5.model.Bundle)
      return Bundle10_50.convertBundle((org.hl7.fhir.r5.model.Bundle) src, advisor);
    if (src instanceof org.hl7.fhir.r5.model.CarePlan)
      return CarePlan10_50.convertCarePlan((org.hl7.fhir.r5.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r5.model.Communication)
      return Communication10_50.convertCommunication((org.hl7.fhir.r5.model.Communication) src);
    if (src instanceof org.hl7.fhir.r5.model.CommunicationRequest)
      return CommunicationRequest10_50.convertCommunicationRequest((org.hl7.fhir.r5.model.CommunicationRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.Composition)
      return Composition10_50.convertComposition((org.hl7.fhir.r5.model.Composition) src);
    if (src instanceof org.hl7.fhir.r5.model.ConceptMap)
      return ConceptMap10_50.convertConceptMap((org.hl7.fhir.r5.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r5.model.Condition)
      return Condition10_50.convertCondition((org.hl7.fhir.r5.model.Condition) src);
    if (src instanceof org.hl7.fhir.r5.model.CapabilityStatement)
      return Conformance10_50.convertConformance((org.hl7.fhir.r5.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.DetectedIssue)
      return DetectedIssue10_50.convertDetectedIssue((org.hl7.fhir.r5.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceMetric)
      return DeviceMetric10_50.convertDeviceMetric((org.hl7.fhir.r5.model.DeviceMetric) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceUsage)
      return DeviceUseStatement10_50.convertDeviceUseStatement((org.hl7.fhir.r5.model.DeviceUsage) src);
    if (src instanceof org.hl7.fhir.r5.model.DiagnosticReport)
      return DiagnosticReport10_50.convertDiagnosticReport((org.hl7.fhir.r5.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
      return DocumentReference10_50.convertDocumentReference((org.hl7.fhir.r5.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r5.model.Encounter)
      return Encounter10_50.convertEncounter((org.hl7.fhir.r5.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r5.model.EnrollmentRequest)
      return EnrollmentRequest10_50.convertEnrollmentRequest((org.hl7.fhir.r5.model.EnrollmentRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.EnrollmentResponse)
      return EnrollmentResponse10_50.convertEnrollmentResponse((org.hl7.fhir.r5.model.EnrollmentResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.EpisodeOfCare)
      return EpisodeOfCare10_50.convertEpisodeOfCare((org.hl7.fhir.r5.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r5.model.FamilyMemberHistory)
      return FamilyMemberHistory10_50.convertFamilyMemberHistory((org.hl7.fhir.r5.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r5.model.Flag) return Flag10_50.convertFlag((org.hl7.fhir.r5.model.Flag) src);
    if (src instanceof org.hl7.fhir.r5.model.Group)
      return Group10_50.convertGroup((org.hl7.fhir.r5.model.Group) src);
    if (src instanceof org.hl7.fhir.r5.model.HealthcareService)
      return HealthcareService10_50.convertHealthcareService((org.hl7.fhir.r5.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r5.model.ImplementationGuide)
      return ImplementationGuide10_50.convertImplementationGuide((org.hl7.fhir.r5.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r5.model.ListResource)
      return List10_50.convertList((org.hl7.fhir.r5.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r5.model.Location)
      return Location10_50.convertLocation((org.hl7.fhir.r5.model.Location) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationDispense)
      return MedicationDispense10_50.convertMedicationDispense((org.hl7.fhir.r5.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationStatement)
      return MedicationStatement10_50.convertMedicationStatement((org.hl7.fhir.r5.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageHeader)
      return MessageHeader10_50.convertMessageHeader((org.hl7.fhir.r5.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r5.model.NamingSystem)
      return NamingSystem10_50.convertNamingSystem((org.hl7.fhir.r5.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.Observation)
      return Observation10_50.convertObservation((org.hl7.fhir.r5.model.Observation) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationDefinition)
      return OperationDefinition10_50.convertOperationDefinition((org.hl7.fhir.r5.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationOutcome)
      return OperationOutcome10_50.convertOperationOutcome((org.hl7.fhir.r5.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r5.model.Organization)
      return Organization10_50.convertOrganization((org.hl7.fhir.r5.model.Organization) src);
    if (src instanceof org.hl7.fhir.r5.model.Patient)
      return Patient10_50.convertPatient((org.hl7.fhir.r5.model.Patient) src);
    if (src instanceof org.hl7.fhir.r5.model.Person)
      return Person10_50.convertPerson((org.hl7.fhir.r5.model.Person) src);
    if (src instanceof org.hl7.fhir.r5.model.Practitioner)
      return Practitioner10_50.convertPractitioner((org.hl7.fhir.r5.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r5.model.Provenance)
      return Provenance10_50.convertProvenance((org.hl7.fhir.r5.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r5.model.Questionnaire)
      return Questionnaire10_50.convertQuestionnaire((org.hl7.fhir.r5.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r5.model.QuestionnaireResponse)
      return QuestionnaireResponse10_50.convertQuestionnaireResponse((org.hl7.fhir.r5.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.RiskAssessment)
      return RiskAssessment10_50.convertRiskAssessment((org.hl7.fhir.r5.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r5.model.Schedule)
      return Schedule10_50.convertSchedule((org.hl7.fhir.r5.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r5.model.SearchParameter)
      return SearchParameter10_50.convertSearchParameter((org.hl7.fhir.r5.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r5.model.Slot) return Slot10_50.convertSlot((org.hl7.fhir.r5.model.Slot) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureDefinition)
      return StructureDefinition10_50.convertStructureDefinition((org.hl7.fhir.r5.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Substance)
      return Substance10_50.convertSubstance((org.hl7.fhir.r5.model.Substance) src);
    if (src instanceof org.hl7.fhir.r5.model.SupplyDelivery)
      return SupplyDelivery10_50.convertSupplyDelivery((org.hl7.fhir.r5.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.r5.model.SupplyRequest)
      return SupplyRequest10_50.convertSupplyRequest((org.hl7.fhir.r5.model.SupplyRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.TestScript)
      return TestScript10_50.convertTestScript((org.hl7.fhir.r5.model.TestScript) src);
    if (src instanceof org.hl7.fhir.r5.model.ValueSet)
      return ValueSet10_50.convertValueSet((org.hl7.fhir.r5.model.ValueSet) src, advisor);
    if (advisor.failFastOnNullOrUnknownEntry()) {
      throw new FHIRException("Unknown resource " + src.fhirType());
    } else {
      return null;
    }
  }

  public void copyDomainResource(org.hl7.fhir.dstu2.model.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative10_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext10_50.INSTANCE.path(), extension)) {
        org.hl7.fhir.r5.model.Extension convertExtension = new org.hl7.fhir.r5.model.Extension();
        advisor.handleExtension(ConversionContext10_50.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext10_50.INSTANCE.path(), extension)) {
        tgt.addExtension(Extension10_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext10_50.INSTANCE.path(), extension))
      .map(Extension10_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.dstu2.model.DomainResource tgt) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative10_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(this::convertResource)
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension(ConversionContext10_50.INSTANCE.path(), extension)) {
        Extension convertExtension = new Extension();
        advisor.handleExtension(ConversionContext10_50.INSTANCE.path(), extension, convertExtension);
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension(ConversionContext10_50.INSTANCE.path(), extension)) {
        tgt.addExtension(Extension10_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension(ConversionContext10_50.INSTANCE.path(), extension))
      .map(Extension10_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }
}
