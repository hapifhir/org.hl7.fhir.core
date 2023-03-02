package org.hl7.fhir.r5.model;

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

// Generated on Wed, Mar 1, 2023 15:32+1100 for FHIR v5.0.0-draft-final



import org.hl7.fhir.exceptions.FHIRException;

public enum ResourceType {
Account,
    ActivityDefinition,
    ActorDefinition,
    AdministrableProductDefinition,
    AdverseEvent,
    AllergyIntolerance,
    Appointment,
    AppointmentResponse,
    ArtifactAssessment,
    AuditEvent,
    Basic,
    Binary,
    BiologicallyDerivedProduct,
    BiologicallyDerivedProductDispense,
    BodyStructure,
    Bundle,
    CapabilityStatement,
    CarePlan,
    CareTeam,
    ChargeItem,
    ChargeItemDefinition,
    Citation,
    Claim,
    ClaimResponse,
    ClinicalImpression,
    ClinicalUseDefinition,
    CodeSystem,
    Communication,
    CommunicationRequest,
    CompartmentDefinition,
    Composition,
    ConceptMap,
    Condition,
    ConditionDefinition,
    Consent,
    Contract,
    Coverage,
    CoverageEligibilityRequest,
    CoverageEligibilityResponse,
    DetectedIssue,
    Device,
    DeviceAssociation,
    DeviceDefinition,
    DeviceDispense,
    DeviceMetric,
    DeviceRequest,
    DeviceUsage,
    DiagnosticReport,
    DocumentReference,
    Encounter,
    EncounterHistory,
    Endpoint,
    EnrollmentRequest,
    EnrollmentResponse,
    EpisodeOfCare,
    EventDefinition,
    Evidence,
    EvidenceReport,
    EvidenceVariable,
    ExampleScenario,
    ExplanationOfBenefit,
    FamilyMemberHistory,
    Flag,
    FormularyItem,
    GenomicStudy,
    Goal,
    GraphDefinition,
    Group,
    GuidanceResponse,
    HealthcareService,
    ImagingSelection,
    ImagingStudy,
    Immunization,
    ImmunizationEvaluation,
    ImmunizationRecommendation,
    ImplementationGuide,
    Ingredient,
    InsurancePlan,
    InventoryItem,
    InventoryReport,
    Invoice,
    Library,
    Linkage,
    List,
    Location,
    ManufacturedItemDefinition,
    Measure,
    MeasureReport,
    Medication,
    MedicationAdministration,
    MedicationDispense,
    MedicationKnowledge,
    MedicationRequest,
    MedicationStatement,
    MedicinalProductDefinition,
    MessageDefinition,
    MessageHeader,
    MolecularSequence,
    NamingSystem,
    NutritionIntake,
    NutritionOrder,
    NutritionProduct,
    Observation,
    ObservationDefinition,
    OperationDefinition,
    OperationOutcome,
    Organization,
    OrganizationAffiliation,
    PackagedProductDefinition,
    Parameters,
    Patient,
    PaymentNotice,
    PaymentReconciliation,
    Permission,
    Person,
    PlanDefinition,
    Practitioner,
    PractitionerRole,
    Procedure,
    Provenance,
    Questionnaire,
    QuestionnaireResponse,
    RegulatedAuthorization,
    RelatedPerson,
    RequestOrchestration,
    Requirements,
    ResearchStudy,
    ResearchSubject,
    RiskAssessment,
    Schedule,
    SearchParameter,
    ServiceRequest,
    Slot,
    Specimen,
    SpecimenDefinition,
    StructureDefinition,
    StructureMap,
    Subscription,
    SubscriptionStatus,
    SubscriptionTopic,
    Substance,
    SubstanceDefinition,
    SubstanceNucleicAcid,
    SubstancePolymer,
    SubstanceProtein,
    SubstanceReferenceInformation,
    SubstanceSourceMaterial,
    SupplyDelivery,
    SupplyRequest,
    Task,
    TerminologyCapabilities,
    TestPlan,
    TestReport,
    TestScript,
    Transport,
    ValueSet,
    VerificationResult,
    VisionPrescription;


    public String getPath() {;
      switch (this) {
    case Account:
      return "account";
    case ActivityDefinition:
      return "activitydefinition";
    case ActorDefinition:
      return "actordefinition";
    case AdministrableProductDefinition:
      return "administrableproductdefinition";
    case AdverseEvent:
      return "adverseevent";
    case AllergyIntolerance:
      return "allergyintolerance";
    case Appointment:
      return "appointment";
    case AppointmentResponse:
      return "appointmentresponse";
    case ArtifactAssessment:
      return "artifactassessment";
    case AuditEvent:
      return "auditevent";
    case Basic:
      return "basic";
    case Binary:
      return "binary";
    case BiologicallyDerivedProduct:
      return "biologicallyderivedproduct";
    case BiologicallyDerivedProductDispense:
      return "biologicallyderivedproductdispense";
    case BodyStructure:
      return "bodystructure";
    case Bundle:
      return "bundle";
    case CapabilityStatement:
      return "capabilitystatement";
    case CarePlan:
      return "careplan";
    case CareTeam:
      return "careteam";
    case ChargeItem:
      return "chargeitem";
    case ChargeItemDefinition:
      return "chargeitemdefinition";
    case Citation:
      return "citation";
    case Claim:
      return "claim";
    case ClaimResponse:
      return "claimresponse";
    case ClinicalImpression:
      return "clinicalimpression";
    case ClinicalUseDefinition:
      return "clinicalusedefinition";
    case CodeSystem:
      return "codesystem";
    case Communication:
      return "communication";
    case CommunicationRequest:
      return "communicationrequest";
    case CompartmentDefinition:
      return "compartmentdefinition";
    case Composition:
      return "composition";
    case ConceptMap:
      return "conceptmap";
    case Condition:
      return "condition";
    case ConditionDefinition:
      return "conditiondefinition";
    case Consent:
      return "consent";
    case Contract:
      return "contract";
    case Coverage:
      return "coverage";
    case CoverageEligibilityRequest:
      return "coverageeligibilityrequest";
    case CoverageEligibilityResponse:
      return "coverageeligibilityresponse";
    case DetectedIssue:
      return "detectedissue";
    case Device:
      return "device";
    case DeviceAssociation:
      return "deviceassociation";
    case DeviceDefinition:
      return "devicedefinition";
    case DeviceDispense:
      return "devicedispense";
    case DeviceMetric:
      return "devicemetric";
    case DeviceRequest:
      return "devicerequest";
    case DeviceUsage:
      return "deviceusage";
    case DiagnosticReport:
      return "diagnosticreport";
    case DocumentReference:
      return "documentreference";
    case Encounter:
      return "encounter";
    case EncounterHistory:
      return "encounterhistory";
    case Endpoint:
      return "endpoint";
    case EnrollmentRequest:
      return "enrollmentrequest";
    case EnrollmentResponse:
      return "enrollmentresponse";
    case EpisodeOfCare:
      return "episodeofcare";
    case EventDefinition:
      return "eventdefinition";
    case Evidence:
      return "evidence";
    case EvidenceReport:
      return "evidencereport";
    case EvidenceVariable:
      return "evidencevariable";
    case ExampleScenario:
      return "examplescenario";
    case ExplanationOfBenefit:
      return "explanationofbenefit";
    case FamilyMemberHistory:
      return "familymemberhistory";
    case Flag:
      return "flag";
    case FormularyItem:
      return "formularyitem";
    case GenomicStudy:
      return "genomicstudy";
    case Goal:
      return "goal";
    case GraphDefinition:
      return "graphdefinition";
    case Group:
      return "group";
    case GuidanceResponse:
      return "guidanceresponse";
    case HealthcareService:
      return "healthcareservice";
    case ImagingSelection:
      return "imagingselection";
    case ImagingStudy:
      return "imagingstudy";
    case Immunization:
      return "immunization";
    case ImmunizationEvaluation:
      return "immunizationevaluation";
    case ImmunizationRecommendation:
      return "immunizationrecommendation";
    case ImplementationGuide:
      return "implementationguide";
    case Ingredient:
      return "ingredient";
    case InsurancePlan:
      return "insuranceplan";
    case InventoryItem:
      return "inventoryitem";
    case InventoryReport:
      return "inventoryreport";
    case Invoice:
      return "invoice";
    case Library:
      return "library";
    case Linkage:
      return "linkage";
    case List:
      return "list";
    case Location:
      return "location";
    case ManufacturedItemDefinition:
      return "manufactureditemdefinition";
    case Measure:
      return "measure";
    case MeasureReport:
      return "measurereport";
    case Medication:
      return "medication";
    case MedicationAdministration:
      return "medicationadministration";
    case MedicationDispense:
      return "medicationdispense";
    case MedicationKnowledge:
      return "medicationknowledge";
    case MedicationRequest:
      return "medicationrequest";
    case MedicationStatement:
      return "medicationstatement";
    case MedicinalProductDefinition:
      return "medicinalproductdefinition";
    case MessageDefinition:
      return "messagedefinition";
    case MessageHeader:
      return "messageheader";
    case MolecularSequence:
      return "molecularsequence";
    case NamingSystem:
      return "namingsystem";
    case NutritionIntake:
      return "nutritionintake";
    case NutritionOrder:
      return "nutritionorder";
    case NutritionProduct:
      return "nutritionproduct";
    case Observation:
      return "observation";
    case ObservationDefinition:
      return "observationdefinition";
    case OperationDefinition:
      return "operationdefinition";
    case OperationOutcome:
      return "operationoutcome";
    case Organization:
      return "organization";
    case OrganizationAffiliation:
      return "organizationaffiliation";
    case PackagedProductDefinition:
      return "packagedproductdefinition";
    case Parameters:
      return "parameters";
    case Patient:
      return "patient";
    case PaymentNotice:
      return "paymentnotice";
    case PaymentReconciliation:
      return "paymentreconciliation";
    case Permission:
      return "permission";
    case Person:
      return "person";
    case PlanDefinition:
      return "plandefinition";
    case Practitioner:
      return "practitioner";
    case PractitionerRole:
      return "practitionerrole";
    case Procedure:
      return "procedure";
    case Provenance:
      return "provenance";
    case Questionnaire:
      return "questionnaire";
    case QuestionnaireResponse:
      return "questionnaireresponse";
    case RegulatedAuthorization:
      return "regulatedauthorization";
    case RelatedPerson:
      return "relatedperson";
    case RequestOrchestration:
      return "requestorchestration";
    case Requirements:
      return "requirements";
    case ResearchStudy:
      return "researchstudy";
    case ResearchSubject:
      return "researchsubject";
    case RiskAssessment:
      return "riskassessment";
    case Schedule:
      return "schedule";
    case SearchParameter:
      return "searchparameter";
    case ServiceRequest:
      return "servicerequest";
    case Slot:
      return "slot";
    case Specimen:
      return "specimen";
    case SpecimenDefinition:
      return "specimendefinition";
    case StructureDefinition:
      return "structuredefinition";
    case StructureMap:
      return "structuremap";
    case Subscription:
      return "subscription";
    case SubscriptionStatus:
      return "subscriptionstatus";
    case SubscriptionTopic:
      return "subscriptiontopic";
    case Substance:
      return "substance";
    case SubstanceDefinition:
      return "substancedefinition";
    case SubstanceNucleicAcid:
      return "substancenucleicacid";
    case SubstancePolymer:
      return "substancepolymer";
    case SubstanceProtein:
      return "substanceprotein";
    case SubstanceReferenceInformation:
      return "substancereferenceinformation";
    case SubstanceSourceMaterial:
      return "substancesourcematerial";
    case SupplyDelivery:
      return "supplydelivery";
    case SupplyRequest:
      return "supplyrequest";
    case Task:
      return "task";
    case TerminologyCapabilities:
      return "terminologycapabilities";
    case TestPlan:
      return "testplan";
    case TestReport:
      return "testreport";
    case TestScript:
      return "testscript";
    case Transport:
      return "transport";
    case ValueSet:
      return "valueset";
    case VerificationResult:
      return "verificationresult";
    case VisionPrescription:
      return "visionprescription";

    }
    return null;
  }


    public static ResourceType fromCode(String code) throws FHIRException {;
    if ("Account".equals(code))
      return Account;
    if ("ActivityDefinition".equals(code))
      return ActivityDefinition;
    if ("ActorDefinition".equals(code))
      return ActorDefinition;
    if ("AdministrableProductDefinition".equals(code))
      return AdministrableProductDefinition;
    if ("AdverseEvent".equals(code))
      return AdverseEvent;
    if ("AllergyIntolerance".equals(code))
      return AllergyIntolerance;
    if ("Appointment".equals(code))
      return Appointment;
    if ("AppointmentResponse".equals(code))
      return AppointmentResponse;
    if ("ArtifactAssessment".equals(code))
      return ArtifactAssessment;
    if ("AuditEvent".equals(code))
      return AuditEvent;
    if ("Basic".equals(code))
      return Basic;
    if ("Binary".equals(code))
      return Binary;
    if ("BiologicallyDerivedProduct".equals(code))
      return BiologicallyDerivedProduct;
    if ("BiologicallyDerivedProductDispense".equals(code))
      return BiologicallyDerivedProductDispense;
    if ("BodyStructure".equals(code))
      return BodyStructure;
    if ("Bundle".equals(code))
      return Bundle;
    if ("CapabilityStatement".equals(code))
      return CapabilityStatement;
    if ("CarePlan".equals(code))
      return CarePlan;
    if ("CareTeam".equals(code))
      return CareTeam;
    if ("ChargeItem".equals(code))
      return ChargeItem;
    if ("ChargeItemDefinition".equals(code))
      return ChargeItemDefinition;
    if ("Citation".equals(code))
      return Citation;
    if ("Claim".equals(code))
      return Claim;
    if ("ClaimResponse".equals(code))
      return ClaimResponse;
    if ("ClinicalImpression".equals(code))
      return ClinicalImpression;
    if ("ClinicalUseDefinition".equals(code))
      return ClinicalUseDefinition;
    if ("CodeSystem".equals(code))
      return CodeSystem;
    if ("Communication".equals(code))
      return Communication;
    if ("CommunicationRequest".equals(code))
      return CommunicationRequest;
    if ("CompartmentDefinition".equals(code))
      return CompartmentDefinition;
    if ("Composition".equals(code))
      return Composition;
    if ("ConceptMap".equals(code))
      return ConceptMap;
    if ("Condition".equals(code))
      return Condition;
    if ("ConditionDefinition".equals(code))
      return ConditionDefinition;
    if ("Consent".equals(code))
      return Consent;
    if ("Contract".equals(code))
      return Contract;
    if ("Coverage".equals(code))
      return Coverage;
    if ("CoverageEligibilityRequest".equals(code))
      return CoverageEligibilityRequest;
    if ("CoverageEligibilityResponse".equals(code))
      return CoverageEligibilityResponse;
    if ("DetectedIssue".equals(code))
      return DetectedIssue;
    if ("Device".equals(code))
      return Device;
    if ("DeviceAssociation".equals(code))
      return DeviceAssociation;
    if ("DeviceDefinition".equals(code))
      return DeviceDefinition;
    if ("DeviceDispense".equals(code))
      return DeviceDispense;
    if ("DeviceMetric".equals(code))
      return DeviceMetric;
    if ("DeviceRequest".equals(code))
      return DeviceRequest;
    if ("DeviceUsage".equals(code))
      return DeviceUsage;
    if ("DiagnosticReport".equals(code))
      return DiagnosticReport;
    if ("DocumentReference".equals(code))
      return DocumentReference;
    if ("Encounter".equals(code))
      return Encounter;
    if ("EncounterHistory".equals(code))
      return EncounterHistory;
    if ("Endpoint".equals(code))
      return Endpoint;
    if ("EnrollmentRequest".equals(code))
      return EnrollmentRequest;
    if ("EnrollmentResponse".equals(code))
      return EnrollmentResponse;
    if ("EpisodeOfCare".equals(code))
      return EpisodeOfCare;
    if ("EventDefinition".equals(code))
      return EventDefinition;
    if ("Evidence".equals(code))
      return Evidence;
    if ("EvidenceReport".equals(code))
      return EvidenceReport;
    if ("EvidenceVariable".equals(code))
      return EvidenceVariable;
    if ("ExampleScenario".equals(code))
      return ExampleScenario;
    if ("ExplanationOfBenefit".equals(code))
      return ExplanationOfBenefit;
    if ("FamilyMemberHistory".equals(code))
      return FamilyMemberHistory;
    if ("Flag".equals(code))
      return Flag;
    if ("FormularyItem".equals(code))
      return FormularyItem;
    if ("GenomicStudy".equals(code))
      return GenomicStudy;
    if ("Goal".equals(code))
      return Goal;
    if ("GraphDefinition".equals(code))
      return GraphDefinition;
    if ("Group".equals(code))
      return Group;
    if ("GuidanceResponse".equals(code))
      return GuidanceResponse;
    if ("HealthcareService".equals(code))
      return HealthcareService;
    if ("ImagingSelection".equals(code))
      return ImagingSelection;
    if ("ImagingStudy".equals(code))
      return ImagingStudy;
    if ("Immunization".equals(code))
      return Immunization;
    if ("ImmunizationEvaluation".equals(code))
      return ImmunizationEvaluation;
    if ("ImmunizationRecommendation".equals(code))
      return ImmunizationRecommendation;
    if ("ImplementationGuide".equals(code))
      return ImplementationGuide;
    if ("Ingredient".equals(code))
      return Ingredient;
    if ("InsurancePlan".equals(code))
      return InsurancePlan;
    if ("InventoryItem".equals(code))
      return InventoryItem;
    if ("InventoryReport".equals(code))
      return InventoryReport;
    if ("Invoice".equals(code))
      return Invoice;
    if ("Library".equals(code))
      return Library;
    if ("Linkage".equals(code))
      return Linkage;
    if ("List".equals(code))
      return List;
    if ("Location".equals(code))
      return Location;
    if ("ManufacturedItemDefinition".equals(code))
      return ManufacturedItemDefinition;
    if ("Measure".equals(code))
      return Measure;
    if ("MeasureReport".equals(code))
      return MeasureReport;
    if ("Medication".equals(code))
      return Medication;
    if ("MedicationAdministration".equals(code))
      return MedicationAdministration;
    if ("MedicationDispense".equals(code))
      return MedicationDispense;
    if ("MedicationKnowledge".equals(code))
      return MedicationKnowledge;
    if ("MedicationRequest".equals(code))
      return MedicationRequest;
    if ("MedicationStatement".equals(code))
      return MedicationStatement;
    if ("MedicinalProductDefinition".equals(code))
      return MedicinalProductDefinition;
    if ("MessageDefinition".equals(code))
      return MessageDefinition;
    if ("MessageHeader".equals(code))
      return MessageHeader;
    if ("MolecularSequence".equals(code))
      return MolecularSequence;
    if ("NamingSystem".equals(code))
      return NamingSystem;
    if ("NutritionIntake".equals(code))
      return NutritionIntake;
    if ("NutritionOrder".equals(code))
      return NutritionOrder;
    if ("NutritionProduct".equals(code))
      return NutritionProduct;
    if ("Observation".equals(code))
      return Observation;
    if ("ObservationDefinition".equals(code))
      return ObservationDefinition;
    if ("OperationDefinition".equals(code))
      return OperationDefinition;
    if ("OperationOutcome".equals(code))
      return OperationOutcome;
    if ("Organization".equals(code))
      return Organization;
    if ("OrganizationAffiliation".equals(code))
      return OrganizationAffiliation;
    if ("PackagedProductDefinition".equals(code))
      return PackagedProductDefinition;
    if ("Parameters".equals(code))
      return Parameters;
    if ("Patient".equals(code))
      return Patient;
    if ("PaymentNotice".equals(code))
      return PaymentNotice;
    if ("PaymentReconciliation".equals(code))
      return PaymentReconciliation;
    if ("Permission".equals(code))
      return Permission;
    if ("Person".equals(code))
      return Person;
    if ("PlanDefinition".equals(code))
      return PlanDefinition;
    if ("Practitioner".equals(code))
      return Practitioner;
    if ("PractitionerRole".equals(code))
      return PractitionerRole;
    if ("Procedure".equals(code))
      return Procedure;
    if ("Provenance".equals(code))
      return Provenance;
    if ("Questionnaire".equals(code))
      return Questionnaire;
    if ("QuestionnaireResponse".equals(code))
      return QuestionnaireResponse;
    if ("RegulatedAuthorization".equals(code))
      return RegulatedAuthorization;
    if ("RelatedPerson".equals(code))
      return RelatedPerson;
    if ("RequestOrchestration".equals(code))
      return RequestOrchestration;
    if ("Requirements".equals(code))
      return Requirements;
    if ("ResearchStudy".equals(code))
      return ResearchStudy;
    if ("ResearchSubject".equals(code))
      return ResearchSubject;
    if ("RiskAssessment".equals(code))
      return RiskAssessment;
    if ("Schedule".equals(code))
      return Schedule;
    if ("SearchParameter".equals(code))
      return SearchParameter;
    if ("ServiceRequest".equals(code))
      return ServiceRequest;
    if ("Slot".equals(code))
      return Slot;
    if ("Specimen".equals(code))
      return Specimen;
    if ("SpecimenDefinition".equals(code))
      return SpecimenDefinition;
    if ("StructureDefinition".equals(code))
      return StructureDefinition;
    if ("StructureMap".equals(code))
      return StructureMap;
    if ("Subscription".equals(code))
      return Subscription;
    if ("SubscriptionStatus".equals(code))
      return SubscriptionStatus;
    if ("SubscriptionTopic".equals(code))
      return SubscriptionTopic;
    if ("Substance".equals(code))
      return Substance;
    if ("SubstanceDefinition".equals(code))
      return SubstanceDefinition;
    if ("SubstanceNucleicAcid".equals(code))
      return SubstanceNucleicAcid;
    if ("SubstancePolymer".equals(code))
      return SubstancePolymer;
    if ("SubstanceProtein".equals(code))
      return SubstanceProtein;
    if ("SubstanceReferenceInformation".equals(code))
      return SubstanceReferenceInformation;
    if ("SubstanceSourceMaterial".equals(code))
      return SubstanceSourceMaterial;
    if ("SupplyDelivery".equals(code))
      return SupplyDelivery;
    if ("SupplyRequest".equals(code))
      return SupplyRequest;
    if ("Task".equals(code))
      return Task;
    if ("TerminologyCapabilities".equals(code))
      return TerminologyCapabilities;
    if ("TestPlan".equals(code))
      return TestPlan;
    if ("TestReport".equals(code))
      return TestReport;
    if ("TestScript".equals(code))
      return TestScript;
    if ("Transport".equals(code))
      return Transport;
    if ("ValueSet".equals(code))
      return ValueSet;
    if ("VerificationResult".equals(code))
      return VerificationResult;
    if ("VisionPrescription".equals(code))
      return VisionPrescription;

    throw new FHIRException("Unknown resource type "+code);
  }

}