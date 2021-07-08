package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Extension30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Meta30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Narrative30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.*;
import org.hl7.fhir.convertors.conv30_50.resources30_50.*;
import org.hl7.fhir.exceptions.FHIRException;
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

public class VersionConvertor_30_50 {
  static final public String EXT_SRC_TYPE = "http://hl7.org/fhir/StructureDefinition/structuredefinition-fhir-type";
  static public List<String> CANONICAL_URLS = new ArrayList<>();

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

  static public void copyDomainResource(org.hl7.fhir.dstu3.model.DomainResource src,
                                        org.hl7.fhir.r5.model.DomainResource tgt,
                                        String... extensionsToIgnore) throws FHIRException {
    copyDomainResource(src, tgt, new BaseAdvisor_30_50(), extensionsToIgnore);
  }

  static public void copyDomainResource(org.hl7.fhir.dstu3.model.DomainResource src,
                                        org.hl7.fhir.r5.model.DomainResource tgt,
                                        BaseAdvisor_30_50 advisor,
                                        String... extensionsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative30_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(resource -> convertResource(resource, advisor))
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension("", extension)) {//TODO add path
        org.hl7.fhir.r5.model.Extension convertExtension = new org.hl7.fhir.r5.model.Extension();
        advisor.handleExtension("", extension, convertExtension);//TODO add path
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension("", extension) && !Arrays.asList(extensionsToIgnore).contains(extension.getUrl())) {//TODO add path
        tgt.addExtension(Extension30_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension("", extension) && !Arrays.asList(extensionsToIgnore).contains(extension.getUrl()))//TODO add path
      .map(Extension30_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  static public void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src,
                                        org.hl7.fhir.dstu3.model.DomainResource tgt,
                                        String... extensionsToIgnore) throws FHIRException {
    copyDomainResource(src, tgt, new BaseAdvisor_30_50(), extensionsToIgnore);
  }

  static public void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src,
                                        org.hl7.fhir.dstu3.model.DomainResource tgt,
                                        BaseAdvisor_30_50 advisor,
                                        String... extensionsToIgnore) throws FHIRException {
    copyResource(src, tgt);
    if (src.hasText()) tgt.setText(Narrative30_50.convertNarrative(src.getText()));
    src.getContained().stream()
      .map(resource -> convertResource(resource, advisor))
      .forEach(tgt::addContained);
    src.getExtension().forEach(extension -> {
      if (advisor.useAdvisorForExtension("", extension)) {//TODO add path
        org.hl7.fhir.dstu3.model.Extension convertExtension = new org.hl7.fhir.dstu3.model.Extension();
        advisor.handleExtension("", extension, convertExtension);//TODO add path
        tgt.addExtension(convertExtension);
      } else if (!advisor.ignoreExtension("", extension) && !Arrays.asList(extensionsToIgnore).contains(extension.getUrl())) {//TODO add path
        tgt.addExtension(Extension30_50.convertExtension(extension));
      }
    });
    src.getModifierExtension().stream()
      .filter(extension -> !advisor.ignoreExtension("", extension) && !Arrays.asList(extensionsToIgnore).contains(extension.getUrl()))
      .map(Extension30_50::convertExtension)
      .forEach(tgt::addModifierExtension);
  }

  static public void copyResource(org.hl7.fhir.dstu3.model.Resource src, org.hl7.fhir.r5.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id30_50.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta30_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguageElement(Code30_50.convertCode(src.getLanguageElement()));
  }

  static public void copyResource(org.hl7.fhir.r5.model.Resource src, org.hl7.fhir.dstu3.model.Resource tgt) throws FHIRException {
    if (src.hasId()) tgt.setIdElement(Id30_50.convertId(src.getIdElement()));
    if (src.hasMeta()) tgt.setMeta(Meta30_50.convertMeta(src.getMeta()));
    if (src.hasImplicitRules()) tgt.setImplicitRules(src.getImplicitRules());
    if (src.hasLanguage()) tgt.setLanguageElement(Code30_50.convertCode(src.getLanguageElement()));
  }

  private static final String CODE_SYSTEM_MEDIA_TYPE = "http://terminology.hl7.org/CodeSystem/media-type";

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_30_50());
  }

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src, BaseAdvisor_30_50 advisor) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.dstu3.model.Parameters)
      return Parameters30_50.convertParameters((org.hl7.fhir.dstu3.model.Parameters) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ActivityDefinition)
      return ActivityDefinition30_50.convertActivityDefinition((org.hl7.fhir.dstu3.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AllergyIntolerance)
      return AllergyIntolerance30_50.convertAllergyIntolerance((org.hl7.fhir.dstu3.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Appointment)
      return Appointment30_50.convertAppointment((org.hl7.fhir.dstu3.model.Appointment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AppointmentResponse)
      return AppointmentResponse30_50.convertAppointmentResponse((org.hl7.fhir.dstu3.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.AuditEvent)
      return AuditEvent30_50.convertAuditEvent((org.hl7.fhir.dstu3.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Basic)
      return Basic30_50.convertBasic((org.hl7.fhir.dstu3.model.Basic) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Binary)
      return Binary30_50.convertBinary((org.hl7.fhir.dstu3.model.Binary) src);
    if (src instanceof org.hl7.fhir.dstu3.model.BodySite)
      return BodySite30_50.convertBodySite((org.hl7.fhir.dstu3.model.BodySite) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Bundle)
      return Bundle30_50.convertBundle((org.hl7.fhir.dstu3.model.Bundle) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CapabilityStatement)
      return CapabilityStatement30_50.convertCapabilityStatement((org.hl7.fhir.dstu3.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CarePlan)
      return CarePlan30_50.convertCarePlan((org.hl7.fhir.dstu3.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CareTeam)
      return CareTeam30_50.convertCareTeam((org.hl7.fhir.dstu3.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ClinicalImpression)
      return ClinicalImpression30_50.convertClinicalImpression((org.hl7.fhir.dstu3.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CodeSystem)
      return CodeSystem30_50.convertCodeSystem((org.hl7.fhir.dstu3.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Communication)
      return Communication30_50.convertCommunication((org.hl7.fhir.dstu3.model.Communication) src);
    if (src instanceof org.hl7.fhir.dstu3.model.CompartmentDefinition)
      return CompartmentDefinition30_50.convertCompartmentDefinition((org.hl7.fhir.dstu3.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Composition)
      return Composition30_50.convertComposition((org.hl7.fhir.dstu3.model.Composition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ConceptMap)
      return ConceptMap30_50.convertConceptMap((org.hl7.fhir.dstu3.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Condition)
      return Condition30_50.convertCondition((org.hl7.fhir.dstu3.model.Condition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Consent)
      return Consent30_50.convertConsent((org.hl7.fhir.dstu3.model.Consent) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DataElement)
      return DataElement30_50.convertDataElement((org.hl7.fhir.dstu3.model.DataElement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DetectedIssue)
      return DetectedIssue30_50.convertDetectedIssue((org.hl7.fhir.dstu3.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DeviceUseStatement)
      return DeviceUseStatement30_50.convertDeviceUseStatement((org.hl7.fhir.dstu3.model.DeviceUseStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DiagnosticReport)
      return DiagnosticReport30_50.convertDiagnosticReport((org.hl7.fhir.dstu3.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.dstu3.model.DocumentReference)
      return DocumentReference30_50.convertDocumentReference((org.hl7.fhir.dstu3.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Encounter)
      return Encounter30_50.convertEncounter((org.hl7.fhir.dstu3.model.Encounter) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Endpoint)
      return Endpoint30_50.convertEndpoint((org.hl7.fhir.dstu3.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.dstu3.model.EpisodeOfCare)
      return EpisodeOfCare30_50.convertEpisodeOfCare((org.hl7.fhir.dstu3.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ExpansionProfile)
      return ExpansionProfile30_50.convertExpansionProfile((org.hl7.fhir.dstu3.model.ExpansionProfile) src);
    if (src instanceof org.hl7.fhir.dstu3.model.FamilyMemberHistory)
      return FamilyMemberHistory30_50.convertFamilyMemberHistory((org.hl7.fhir.dstu3.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Flag) return Flag30_50.convertFlag((org.hl7.fhir.dstu3.model.Flag) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Goal) return Goal30_50.convertGoal((org.hl7.fhir.dstu3.model.Goal) src);
    if (src instanceof org.hl7.fhir.dstu3.model.GraphDefinition)
      return GraphDefinition30_50.convertGraphDefinition((org.hl7.fhir.dstu3.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Group)
      return Group30_50.convertGroup((org.hl7.fhir.dstu3.model.Group) src);
    if (src instanceof org.hl7.fhir.dstu3.model.HealthcareService)
      return HealthcareService30_50.convertHealthcareService((org.hl7.fhir.dstu3.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImagingStudy)
      return ImagingStudy30_50.convertImagingStudy((org.hl7.fhir.dstu3.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Immunization)
      return Immunization30_50.convertImmunization((org.hl7.fhir.dstu3.model.Immunization) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ImplementationGuide)
      return ImplementationGuide30_50.convertImplementationGuide((org.hl7.fhir.dstu3.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Library)
      return Library30_50.convertLibrary((org.hl7.fhir.dstu3.model.Library) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Linkage)
      return Linkage30_50.convertLinkage((org.hl7.fhir.dstu3.model.Linkage) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ListResource)
      return List30_50.convertList((org.hl7.fhir.dstu3.model.ListResource) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Location)
      return Location30_50.convertLocation((org.hl7.fhir.dstu3.model.Location) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Measure)
      return Measure30_50.convertMeasure((org.hl7.fhir.dstu3.model.Measure) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Media)
      return Media30_50.convertMedia((org.hl7.fhir.dstu3.model.Media) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Medication)
      return Medication30_50.convertMedication((org.hl7.fhir.dstu3.model.Medication) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationAdministration)
      return MedicationAdministration30_50.convertMedicationAdministration((org.hl7.fhir.dstu3.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationDispense)
      return MedicationDispense30_50.convertMedicationDispense((org.hl7.fhir.dstu3.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationRequest)
      return MedicationRequest30_50.convertMedicationRequest((org.hl7.fhir.dstu3.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MedicationStatement)
      return MedicationStatement30_50.convertMedicationStatement((org.hl7.fhir.dstu3.model.MedicationStatement) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MessageDefinition)
      return MessageDefinition30_50.convertMessageDefinition((org.hl7.fhir.dstu3.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.MessageHeader)
      return MessageHeader30_50.convertMessageHeader((org.hl7.fhir.dstu3.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.dstu3.model.NamingSystem)
      return NamingSystem30_50.convertNamingSystem((org.hl7.fhir.dstu3.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Observation)
      return Observation30_50.convertObservation((org.hl7.fhir.dstu3.model.Observation) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationDefinition)
      return OperationDefinition30_50.convertOperationDefinition((org.hl7.fhir.dstu3.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.OperationOutcome)
      return OperationOutcome30_50.convertOperationOutcome((org.hl7.fhir.dstu3.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Organization)
      return Organization30_50.convertOrganization((org.hl7.fhir.dstu3.model.Organization) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Patient)
      return Patient30_50.convertPatient((org.hl7.fhir.dstu3.model.Patient) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PaymentNotice)
      return PaymentNotice30_50.convertPaymentNotice((org.hl7.fhir.dstu3.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Person)
      return Person30_50.convertPerson((org.hl7.fhir.dstu3.model.Person) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PlanDefinition)
      return PlanDefinition30_50.convertPlanDefinition((org.hl7.fhir.dstu3.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Practitioner)
      return Practitioner30_50.convertPractitioner((org.hl7.fhir.dstu3.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.dstu3.model.PractitionerRole)
      return PractitionerRole30_50.convertPractitionerRole((org.hl7.fhir.dstu3.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Provenance)
      return Provenance30_50.convertProvenance((org.hl7.fhir.dstu3.model.Provenance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Questionnaire)
      return Questionnaire30_50.convertQuestionnaire((org.hl7.fhir.dstu3.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.dstu3.model.QuestionnaireResponse)
      return QuestionnaireResponse30_50.convertQuestionnaireResponse((org.hl7.fhir.dstu3.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RelatedPerson)
      return RelatedPerson30_50.convertRelatedPerson((org.hl7.fhir.dstu3.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.dstu3.model.RiskAssessment)
      return RiskAssessment30_50.convertRiskAssessment((org.hl7.fhir.dstu3.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Schedule)
      return Schedule30_50.convertSchedule((org.hl7.fhir.dstu3.model.Schedule) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SearchParameter)
      return SearchParameter30_50.convertSearchParameter((org.hl7.fhir.dstu3.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Sequence)
      return Sequence30_50.convertSequence((org.hl7.fhir.dstu3.model.Sequence) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Slot) return Slot30_50.convertSlot((org.hl7.fhir.dstu3.model.Slot) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Specimen)
      return Specimen30_50.convertSpecimen((org.hl7.fhir.dstu3.model.Specimen) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StructureDefinition)
      return StructureDefinition30_50.convertStructureDefinition((org.hl7.fhir.dstu3.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.dstu3.model.StructureMap)
      return StructureMap30_50.convertStructureMap((org.hl7.fhir.dstu3.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.dstu3.model.Substance)
      return Substance30_50.convertSubstance((org.hl7.fhir.dstu3.model.Substance) src);
    if (src instanceof org.hl7.fhir.dstu3.model.SupplyDelivery)
      return SupplyDelivery30_50.convertSupplyDelivery((org.hl7.fhir.dstu3.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TestReport)
      return TestReport30_50.convertTestReport((org.hl7.fhir.dstu3.model.TestReport) src);
    if (src instanceof org.hl7.fhir.dstu3.model.TestScript)
      return TestScript30_50.convertTestScript((org.hl7.fhir.dstu3.model.TestScript) src);
    if (src instanceof org.hl7.fhir.dstu3.model.ValueSet)
      return ValueSet30_50.convertValueSet((org.hl7.fhir.dstu3.model.ValueSet) src);
    if (advisor.failFastOnNullOrUnknownEntry()) throw new FHIRException("Unknown resource " + src.fhirType());
    else return null;
  }

  public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_30_50());
  }

  public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src, BaseAdvisor_30_50 advisor) throws FHIRException {
    if (src == null) return null;
    if (src instanceof org.hl7.fhir.r5.model.Parameters) {
      if (((org.hl7.fhir.r5.model.Parameters) src).hasParameter("profile-url"))
        return ExpansionProfile30_50.convertExpansionProfile((org.hl7.fhir.r5.model.Parameters) src);
      else return Parameters30_50.convertParameters((org.hl7.fhir.r5.model.Parameters) src);
    }
    if (src instanceof org.hl7.fhir.r5.model.ActivityDefinition)
      return ActivityDefinition30_50.convertActivityDefinition((org.hl7.fhir.r5.model.ActivityDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.AllergyIntolerance)
      return AllergyIntolerance30_50.convertAllergyIntolerance((org.hl7.fhir.r5.model.AllergyIntolerance) src);
    if (src instanceof org.hl7.fhir.r5.model.Appointment)
      return Appointment30_50.convertAppointment((org.hl7.fhir.r5.model.Appointment) src);
    if (src instanceof org.hl7.fhir.r5.model.AppointmentResponse)
      return AppointmentResponse30_50.convertAppointmentResponse((org.hl7.fhir.r5.model.AppointmentResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.AuditEvent)
      return AuditEvent30_50.convertAuditEvent((org.hl7.fhir.r5.model.AuditEvent) src);
    if (src instanceof org.hl7.fhir.r5.model.Basic) return Basic30_50.convertBasic((org.hl7.fhir.r5.model.Basic) src);
    if (src instanceof org.hl7.fhir.r5.model.Binary)
      return Binary30_50.convertBinary((org.hl7.fhir.r5.model.Binary) src);
    if (src instanceof org.hl7.fhir.r5.model.BodyStructure)
      return BodySite30_50.convertBodySite((org.hl7.fhir.r5.model.BodyStructure) src);
    if (src instanceof org.hl7.fhir.r5.model.Bundle)
      return Bundle30_50.convertBundle((org.hl7.fhir.r5.model.Bundle) src);
    if (src instanceof org.hl7.fhir.r5.model.CapabilityStatement)
      return CapabilityStatement30_50.convertCapabilityStatement((org.hl7.fhir.r5.model.CapabilityStatement) src);
    if (src instanceof org.hl7.fhir.r5.model.CarePlan)
      return CarePlan30_50.convertCarePlan((org.hl7.fhir.r5.model.CarePlan) src);
    if (src instanceof org.hl7.fhir.r5.model.CareTeam)
      return CareTeam30_50.convertCareTeam((org.hl7.fhir.r5.model.CareTeam) src);
    if (src instanceof org.hl7.fhir.r5.model.ClinicalImpression)
      return ClinicalImpression30_50.convertClinicalImpression((org.hl7.fhir.r5.model.ClinicalImpression) src);
    if (src instanceof org.hl7.fhir.r5.model.CodeSystem)
      return CodeSystem30_50.convertCodeSystem((org.hl7.fhir.r5.model.CodeSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.Communication)
      return Communication30_50.convertCommunication((org.hl7.fhir.r5.model.Communication) src);
    if (src instanceof org.hl7.fhir.r5.model.CompartmentDefinition)
      return CompartmentDefinition30_50.convertCompartmentDefinition((org.hl7.fhir.r5.model.CompartmentDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Composition)
      return Composition30_50.convertComposition((org.hl7.fhir.r5.model.Composition) src);
    if (src instanceof org.hl7.fhir.r5.model.ConceptMap)
      return ConceptMap30_50.convertConceptMap((org.hl7.fhir.r5.model.ConceptMap) src);
    if (src instanceof org.hl7.fhir.r5.model.Condition)
      return Condition30_50.convertCondition((org.hl7.fhir.r5.model.Condition) src);
    if (src instanceof org.hl7.fhir.r5.model.Consent)
      return Consent30_50.convertConsent((org.hl7.fhir.r5.model.Consent) src);
    if (src instanceof org.hl7.fhir.r5.model.DetectedIssue)
      return DetectedIssue30_50.convertDetectedIssue((org.hl7.fhir.r5.model.DetectedIssue) src);
    if (src instanceof org.hl7.fhir.r5.model.DeviceUsage)
      return DeviceUseStatement30_50.convertDeviceUseStatement((org.hl7.fhir.r5.model.DeviceUsage) src);
    if (src instanceof org.hl7.fhir.r5.model.DiagnosticReport)
      return DiagnosticReport30_50.convertDiagnosticReport((org.hl7.fhir.r5.model.DiagnosticReport) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
      return DocumentReference30_50.convertDocumentReference((org.hl7.fhir.r5.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r5.model.Encounter)
      return Encounter30_50.convertEncounter((org.hl7.fhir.r5.model.Encounter) src);
    if (src instanceof org.hl7.fhir.r5.model.Endpoint)
      return Endpoint30_50.convertEndpoint((org.hl7.fhir.r5.model.Endpoint) src);
    if (src instanceof org.hl7.fhir.r5.model.EpisodeOfCare)
      return EpisodeOfCare30_50.convertEpisodeOfCare((org.hl7.fhir.r5.model.EpisodeOfCare) src);
    if (src instanceof org.hl7.fhir.r5.model.FamilyMemberHistory)
      return FamilyMemberHistory30_50.convertFamilyMemberHistory((org.hl7.fhir.r5.model.FamilyMemberHistory) src);
    if (src instanceof org.hl7.fhir.r5.model.Flag) return Flag30_50.convertFlag((org.hl7.fhir.r5.model.Flag) src);
    if (src instanceof org.hl7.fhir.r5.model.Goal) return Goal30_50.convertGoal((org.hl7.fhir.r5.model.Goal) src);
    if (src instanceof org.hl7.fhir.r5.model.GraphDefinition)
      return GraphDefinition30_50.convertGraphDefinition((org.hl7.fhir.r5.model.GraphDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Group) return Group30_50.convertGroup((org.hl7.fhir.r5.model.Group) src);
    if (src instanceof org.hl7.fhir.r5.model.HealthcareService)
      return HealthcareService30_50.convertHealthcareService((org.hl7.fhir.r5.model.HealthcareService) src);
    if (src instanceof org.hl7.fhir.r5.model.ImagingStudy)
      return ImagingStudy30_50.convertImagingStudy((org.hl7.fhir.r5.model.ImagingStudy) src);
    if (src instanceof org.hl7.fhir.r5.model.Immunization)
      return Immunization30_50.convertImmunization((org.hl7.fhir.r5.model.Immunization) src);
    if (src instanceof org.hl7.fhir.r5.model.ImplementationGuide)
      return ImplementationGuide30_50.convertImplementationGuide((org.hl7.fhir.r5.model.ImplementationGuide) src);
    if (src instanceof org.hl7.fhir.r5.model.Library)
      return Library30_50.convertLibrary((org.hl7.fhir.r5.model.Library) src);
    if (src instanceof org.hl7.fhir.r5.model.Linkage)
      return Linkage30_50.convertLinkage((org.hl7.fhir.r5.model.Linkage) src);
    if (src instanceof org.hl7.fhir.r5.model.ListResource)
      return List30_50.convertList((org.hl7.fhir.r5.model.ListResource) src);
    if (src instanceof org.hl7.fhir.r5.model.Location)
      return Location30_50.convertLocation((org.hl7.fhir.r5.model.Location) src);
    if (src instanceof org.hl7.fhir.r5.model.Measure)
      return Measure30_50.convertMeasure((org.hl7.fhir.r5.model.Measure) src);
    if (src instanceof org.hl7.fhir.r5.model.DocumentReference)
      return Media30_50.convertMedia((org.hl7.fhir.r5.model.DocumentReference) src);
    if (src instanceof org.hl7.fhir.r5.model.Medication)
      return Medication30_50.convertMedication((org.hl7.fhir.r5.model.Medication) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationAdministration)
      return MedicationAdministration30_50.convertMedicationAdministration((org.hl7.fhir.r5.model.MedicationAdministration) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationDispense)
      return MedicationDispense30_50.convertMedicationDispense((org.hl7.fhir.r5.model.MedicationDispense) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationRequest)
      return MedicationRequest30_50.convertMedicationRequest((org.hl7.fhir.r5.model.MedicationRequest) src);
    if (src instanceof org.hl7.fhir.r5.model.MedicationUsage)
      return MedicationStatement30_50.convertMedicationStatement((org.hl7.fhir.r5.model.MedicationUsage) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageDefinition)
      return MessageDefinition30_50.convertMessageDefinition((org.hl7.fhir.r5.model.MessageDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.MessageHeader)
      return MessageHeader30_50.convertMessageHeader((org.hl7.fhir.r5.model.MessageHeader) src);
    if (src instanceof org.hl7.fhir.r5.model.NamingSystem)
      return NamingSystem30_50.convertNamingSystem((org.hl7.fhir.r5.model.NamingSystem) src);
    if (src instanceof org.hl7.fhir.r5.model.Observation)
      return Observation30_50.convertObservation((org.hl7.fhir.r5.model.Observation) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationDefinition)
      return OperationDefinition30_50.convertOperationDefinition((org.hl7.fhir.r5.model.OperationDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.OperationOutcome)
      return OperationOutcome30_50.convertOperationOutcome((org.hl7.fhir.r5.model.OperationOutcome) src);
    if (src instanceof org.hl7.fhir.r5.model.Organization)
      return Organization30_50.convertOrganization((org.hl7.fhir.r5.model.Organization) src);
    if (src instanceof org.hl7.fhir.r5.model.Patient)
      return Patient30_50.convertPatient((org.hl7.fhir.r5.model.Patient) src);
    if (src instanceof org.hl7.fhir.r5.model.PaymentNotice)
      return PaymentNotice30_50.convertPaymentNotice((org.hl7.fhir.r5.model.PaymentNotice) src);
    if (src instanceof org.hl7.fhir.r5.model.Person)
      return Person30_50.convertPerson((org.hl7.fhir.r5.model.Person) src);
    if (src instanceof org.hl7.fhir.r5.model.PlanDefinition)
      return PlanDefinition30_50.convertPlanDefinition((org.hl7.fhir.r5.model.PlanDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.Practitioner)
      return Practitioner30_50.convertPractitioner((org.hl7.fhir.r5.model.Practitioner) src);
    if (src instanceof org.hl7.fhir.r5.model.PractitionerRole)
      return PractitionerRole30_50.convertPractitionerRole((org.hl7.fhir.r5.model.PractitionerRole) src);
    if (src instanceof org.hl7.fhir.r5.model.Provenance)
      return Provenance30_50.convertProvenance((org.hl7.fhir.r5.model.Provenance) src);
    if (src instanceof org.hl7.fhir.r5.model.Questionnaire)
      return Questionnaire30_50.convertQuestionnaire((org.hl7.fhir.r5.model.Questionnaire) src);
    if (src instanceof org.hl7.fhir.r5.model.QuestionnaireResponse)
      return QuestionnaireResponse30_50.convertQuestionnaireResponse((org.hl7.fhir.r5.model.QuestionnaireResponse) src);
    if (src instanceof org.hl7.fhir.r5.model.RelatedPerson)
      return RelatedPerson30_50.convertRelatedPerson((org.hl7.fhir.r5.model.RelatedPerson) src);
    if (src instanceof org.hl7.fhir.r5.model.RiskAssessment)
      return RiskAssessment30_50.convertRiskAssessment((org.hl7.fhir.r5.model.RiskAssessment) src);
    if (src instanceof org.hl7.fhir.r5.model.Schedule)
      return Schedule30_50.convertSchedule((org.hl7.fhir.r5.model.Schedule) src);
    if (src instanceof org.hl7.fhir.r5.model.SearchParameter)
      return SearchParameter30_50.convertSearchParameter((org.hl7.fhir.r5.model.SearchParameter) src);
    if (src instanceof org.hl7.fhir.r5.model.MolecularSequence)
      return Sequence30_50.convertSequence((org.hl7.fhir.r5.model.MolecularSequence) src);
    if (src instanceof org.hl7.fhir.r5.model.Slot) return Slot30_50.convertSlot((org.hl7.fhir.r5.model.Slot) src);
    if (src instanceof org.hl7.fhir.r5.model.Specimen)
      return Specimen30_50.convertSpecimen((org.hl7.fhir.r5.model.Specimen) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureDefinition)
      return StructureDefinition30_50.convertStructureDefinition((org.hl7.fhir.r5.model.StructureDefinition) src);
    if (src instanceof org.hl7.fhir.r5.model.StructureMap)
      return StructureMap30_50.convertStructureMap((org.hl7.fhir.r5.model.StructureMap) src);
    if (src instanceof org.hl7.fhir.r5.model.Substance)
      return Substance30_50.convertSubstance((org.hl7.fhir.r5.model.Substance) src);
    if (src instanceof org.hl7.fhir.r5.model.SupplyDelivery)
      return SupplyDelivery30_50.convertSupplyDelivery((org.hl7.fhir.r5.model.SupplyDelivery) src);
    if (src instanceof org.hl7.fhir.r5.model.TestReport)
      return TestReport30_50.convertTestReport((org.hl7.fhir.r5.model.TestReport) src);
    if (src instanceof org.hl7.fhir.r5.model.TestScript)
      return TestScript30_50.convertTestScript((org.hl7.fhir.r5.model.TestScript) src);
    if (src instanceof org.hl7.fhir.r5.model.ValueSet)
      return ValueSet30_50.convertValueSet((org.hl7.fhir.r5.model.ValueSet) src);
    if (advisor.failFastOnNullOrUnknownEntry()) throw new FHIRException("Unknown resource " + src.fhirType());
    else return null;
  }

  public static boolean convertsResource(String rt) {
    return Utilities.existsInList(rt, "Parameters", "ActivityDefinition", "AllergyIntolerance", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "BodyStructure", "Bundle", "CapabilityStatement", "CarePlan", "CareTeam", "ClinicalImpression", "CodeSystem", "Communication", "CompartmentDefinition", "Composition", "ConceptMap", "Condition", "Consent", "DetectedIssue", "DeviceUseStatement", "DiagnosticReport", "DocumentReference", "Encounter", "Endpoint", "EpisodeOfCare", "FamilyMemberHistory", "Flag", "Goal", "GraphDefinition", "Group", "HealthcareService", "ImagingStudy", "Immunization", "ImplementationGuide", "Library", "Linkage", "ListResource", "Location", "Media", "Medication", "MedicationAdministration", "MedicationDispense", "MedicationRequest", "MedicationStatement", "MessageDefinition", "MessageHeader", "NamingSystem", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Patient", "PaymentNotice", "Person", "PlanDefinition", "Practitioner", "PractitionerRole", "ProcessRequest", "Questionnaire", "QuestionnaireResponse", "RelatedPerson", "RiskAssessment", "Schedule", "SearchParameter", "Sequence", "Slot", "Specimen", "StructureDefinition", "StructureMap", "Subscription", "Substance", "SupplyDelivery", "TestReport", "TestScript", "ValueSet");
  }
}