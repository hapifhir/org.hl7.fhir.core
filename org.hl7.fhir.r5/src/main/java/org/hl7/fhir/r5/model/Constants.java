package org.hl7.fhir.r5.model;

// generated



/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR v4.4.0



public class Constants {

  public final static String LOCAL_REF_REGEX = "(Account|ActivityDefinition|AdministrableProductDefinition|AdverseEvent|AllergyIntolerance|Appointment|AppointmentResponse|AuditEvent|Basic|Binary|BiologicallyDerivedProduct|BodyStructure|Bundle|CapabilityStatement|CapabilityStatement2|CarePlan|CareTeam|CatalogEntry|ChargeItem|ChargeItemDefinition|Citation|Claim|ClaimResponse|ClinicalImpression|ClinicalUseIssue|CodeSystem|Communication|CommunicationRequest|CompartmentDefinition|Composition|ConceptMap|Condition|ConditionDefinition|Consent|Contract|Coverage|CoverageEligibilityRequest|CoverageEligibilityResponse|DetectedIssue|Device|DeviceDefinition|DeviceMetric|DeviceRequest|DeviceUseStatement|DiagnosticReport|DocumentManifest|DocumentReference|Encounter|Endpoint|EnrollmentRequest|EnrollmentResponse|EpisodeOfCare|EventDefinition|Evidence|EvidenceFocus|EvidenceVariable|ExampleScenario|ExplanationOfBenefit|FamilyMemberHistory|Flag|Goal|GraphDefinition|Group|GuidanceResponse|HealthcareService|ImagingStudy|Immunization|ImmunizationEvaluation|ImmunizationRecommendation|ImplementationGuide|Ingredient|InsurancePlan|Invoice|Library|Linkage|List|Location|ManufacturedItemDefinition|Measure|MeasureReport|Medication|MedicationAdministration|MedicationDispense|MedicationKnowledge|MedicationRequest|MedicationUsage|MedicinalProductDefinition|MessageDefinition|MessageHeader|MolecularSequence|NamingSystem|NutritionIntake|NutritionOrder|NutritionProduct|Observation|ObservationDefinition|OperationDefinition|OperationOutcome|Organization|OrganizationAffiliation|PackagedProductDefinition|Parameters|Patient|PaymentNotice|PaymentReconciliation|Permission|Person|PlanDefinition|Practitioner|PractitionerRole|Procedure|Provenance|Questionnaire|QuestionnaireResponse|RegulatedAuthorization|RelatedPerson|RequestGroup|ResearchStudy|ResearchSubject|RiskAssessment|Schedule|SearchParameter|ServiceRequest|Slot|Specimen|SpecimenDefinition|StructureDefinition|StructureMap|Subscription|SubscriptionStatus|SubscriptionTopic|Substance|SubstanceDefinition|SubstanceNucleicAcid|SubstancePolymer|SubstanceProtein|SubstanceReferenceInformation|SubstanceSourceMaterial|SupplyDelivery|SupplyRequest|Task|TerminologyCapabilities|TestReport|TestScript|ValueSet|VerificationResult|VisionPrescription)\\\\/[A-Za-z0-9\\\\-\\\\.]{1,64}";
  public final static String NS_SYSTEM_TYPE = "http://hl7.org/fhirpath/System.";

  public final static String VERSION = "4.4.0";
  public final static String VERSION_MM = "4.4";
  public final static String DATE = "Mon, May 11, 2020 09:58+1000";
  public final static String URI_REGEX = "((http|https)://([A-Za-z0-9\\\\\\.\\:\\%\\$]*\\/)*)?(Account|ActivityDefinition|AdministrableProductDefinition|AdverseEvent|AllergyIntolerance|Appointment|AppointmentResponse|AuditEvent|Basic|Binary|BiologicallyDerivedProduct|BodyStructure|Bundle|CapabilityStatement|CapabilityStatement2|CarePlan|CareTeam|CatalogEntry|ChargeItem|ChargeItemDefinition|Citation|Claim|ClaimResponse|ClinicalImpression|ClinicalUseIssue|CodeSystem|Communication|CommunicationRequest|CompartmentDefinition|Composition|ConceptMap|Condition|ConditionDefinition|Consent|Contract|Coverage|CoverageEligibilityRequest|CoverageEligibilityResponse|DetectedIssue|Device|DeviceDefinition|DeviceMetric|DeviceRequest|DeviceUseStatement|DiagnosticReport|DocumentManifest|DocumentReference|Encounter|Endpoint|EnrollmentRequest|EnrollmentResponse|EpisodeOfCare|EventDefinition|Evidence|EvidenceFocus|EvidenceVariable|ExampleScenario|ExplanationOfBenefit|FamilyMemberHistory|Flag|Goal|GraphDefinition|Group|GuidanceResponse|HealthcareService|ImagingStudy|Immunization|ImmunizationEvaluation|ImmunizationRecommendation|ImplementationGuide|Ingredient|InsurancePlan|Invoice|Library|Linkage|List|Location|ManufacturedItemDefinition|Measure|MeasureReport|Medication|MedicationAdministration|MedicationDispense|MedicationKnowledge|MedicationRequest|MedicationUsage|MedicinalProductDefinition|MessageDefinition|MessageHeader|MolecularSequence|NamingSystem|NutritionIntake|NutritionOrder|NutritionProduct|Observation|ObservationDefinition|OperationDefinition|OperationOutcome|Organization|OrganizationAffiliation|PackagedProductDefinition|Parameters|Patient|PaymentNotice|PaymentReconciliation|Permission|Person|PlanDefinition|Practitioner|PractitionerRole|Procedure|Provenance|Questionnaire|QuestionnaireResponse|RegulatedAuthorization|RelatedPerson|RequestGroup|ResearchStudy|ResearchSubject|RiskAssessment|Schedule|SearchParameter|ServiceRequest|Slot|Specimen|SpecimenDefinition|StructureDefinition|StructureMap|Subscription|SubscriptionStatus|SubscriptionTopic|Substance|SubstanceDefinition|SubstanceNucleicAcid|SubstancePolymer|SubstanceProtein|SubstanceReferenceInformation|SubstanceSourceMaterial|SupplyDelivery|SupplyRequest|Task|TerminologyCapabilities|TestReport|TestScript|ValueSet|VerificationResult|VisionPrescription)\\/[A-Za-z0-9\\-\\.]{1,64}(\\/_history\\/[A-Za-z0-9\\-\\.]{1,64})?";
}