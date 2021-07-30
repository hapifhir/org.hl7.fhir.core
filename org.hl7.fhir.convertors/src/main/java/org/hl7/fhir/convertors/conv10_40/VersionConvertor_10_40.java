package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Extension10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Meta10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Narrative10_40;
import org.hl7.fhir.convertors.conv10_40.resources10_40.*;
import org.hl7.fhir.dstu2.model.CodeableConcept;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.utilities.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification,
  are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this
     list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
     this list of conditions and the following disclaimer in the documentation
     and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to
     endorse or promote products derived from this software without specific
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
  POSSIBILITY OF SUCH DAMAGE.
 */

public class VersionConvertor_10_40 {
  static public List<String> CANONICAL_URLS = new ArrayList<String>();

  static {
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-conceptmap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-valueset");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/codesystem-map");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/cqif-library");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-allowedUnits");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-inheritedExtensibleValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-maxValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-minValueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/event-instantiatesCanonical");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-allowedProfile");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-deMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-sourceStructureMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-targetStructureMap");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-unit-valueSet");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-map");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-supplement");
    CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-system");
  }

  static public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    boolean ok = false;
    for (String s : extensionsToIgnore) if (s.equals(url)) ok = true;
    return ok;
  }

  public static void copyDomainResource(org.hl7.fhir.dstu2.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
    copyDomainResource(src, tgt, new BaseAdvisor_10_40(), extensionsToIgnore);
  }

  public static void copyDomainResource(org.hl7.fhir.dstu2.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt, BaseAdvisor_10_40 advisor, String... extensionsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative10_40.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(resource -> convertResource(resource, advisor))
      .forEach(tgt::addContained);
    src.getExtension().forEach(ext -> {
      if (advisor.useAdvisorForExtension("", ext)) {//TODO add path
        Extension convertExtension = new Extension();
        advisor.handleExtension("", ext, convertExtension);//TODO add path
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension("", ext) && !Arrays.asList(extensionsToIgnore).contains(ext.getUrl())) {//TODO add path
        tgt.addExtension(Extension10_40.convertExtension(ext));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension("", extension) && !Arrays.asList(extensionsToIgnore).contains(extension.getUrl()))//TODO add path
      .map(Extension10_40::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public static void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.dstu2.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
    copyDomainResource(src, tgt, new BaseAdvisor_10_40(), extensionsToIgnore);
  }

  public static void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.dstu2.model.DomainResource tgt, BaseAdvisor_10_40 advisor, String... extensionsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative10_40.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(resource -> convertResource(resource, advisor))
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension("", extension)) {//TODO add path
        org.hl7.fhir.dstu2.model.Extension convertExtension = new org.hl7.fhir.dstu2.model.Extension();
        advisor.handleExtension("", extension, convertExtension);//TODO add path
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension("", extension) && !Arrays.asList(extensionsToIgnore).contains(extension.getUrl())) {//TODO add path
        tgt.addExtension(Extension10_40.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension("", extension) && !Arrays.asList(extensionsToIgnore).contains(extension.getUrl()))//TODO add path
      .map(Extension10_40::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  public static void copyResource(org.hl7.fhir.dstu2.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
    tgt.setId(src.getId());
    tgt.setMeta(Meta10_40.convertMeta(src.getMeta()));
    tgt.setImplicitRules(src.getImplicitRules());
    tgt.setLanguage(src.getLanguage());
  }

  public static void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.dstu2.model.Resource tgt) throws FHIRException {
    tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(Meta10_40.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguage(src.getLanguage());
  }

  static public boolean isJurisdiction(CodeableConcept t) {
    return t.hasCoding() && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem()) || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem()) || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src, BaseAdvisor_10_40 advisor) throws FHIRException {
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
    throw new FHIRException("Unknown resource " + src.fhirType());
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_10_40());
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src, BaseAdvisor_10_40 advisor) throws FHIRException {
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
    throw new FHIRException("Unknown resource " + src.fhirType());
  }

  public static boolean convertsResource(String rt) {
    return Utilities.existsInList(rt, "Parameters", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "Bundle", "CarePlan", "Communication", "CommunicationRequest", "Composition", "ConceptMap", "Condition", "CapabilityStatement", "DetectedIssue", "DeviceMetric", "DeviceUseStatement", "DiagnosticReport", "DocumentReference", "Encounter", "EnrollmentRequest", "EnrollmentResponse", "EpisodeOfCare", "FamilyMemberHistory", "Flag", "Group", "HealthcareService", "ImplementationGuide", "ListResource", "Location", "MedicationDispense", "MedicationStatement", "MessageHeader", "NamingSystem", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Patient", "Person", "Practitioner", "Questionnaire", "QuestionnaireResponse", "RiskAssessment", "Schedule", "SearchParameter", "Slot", "StructureDefinition", "Subscription", "Substance", "SupplyDelivery", "SupplyRequest", "TestScript", "ValueSet");
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
    return convertResource(src, null);
  }

}
