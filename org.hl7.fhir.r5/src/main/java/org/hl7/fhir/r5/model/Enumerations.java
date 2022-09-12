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

// Generated on Mon, Sep 5, 2022 20:11+1000 for FHIR vcurrent


import org.hl7.fhir.instance.model.api.*;
import org.hl7.fhir.exceptions.FHIRException;

public class Enumerations {

// In here: 
//   ActionCardinalityBehavior: Defines behavior for an action or a group for how many times that item may be repeated.[PlanDefinition, RequestOrchestration]
//   ActionConditionKind: Defines the kinds of conditions that can appear on actions.[PlanDefinition, RequestOrchestration]
//   ActionGroupingBehavior: Defines organization behavior of a group.[PlanDefinition, RequestOrchestration]
//   ActionParticipantType: The type of participant for the action.[ActivityDefinition, PlanDefinition, RequestOrchestration]
//   ActionPrecheckBehavior: Defines selection frequency behavior for an action or group.[PlanDefinition, RequestOrchestration]
//   ActionRelationshipType: Defines the types of relationships between actions.[PlanDefinition, RequestOrchestration]
//   ActionRequiredBehavior: Defines expectations around whether an action or action group is required.[PlanDefinition, RequestOrchestration]
//   ActionSelectionBehavior: Defines selection behavior of a group.[PlanDefinition, RequestOrchestration]
//   AdministrativeGender: The gender of a person used for administrative purposes.[ObservationDefinition, Patient, Person, Practitioner, RelatedPerson]
//   AllResourceTypes: All fhir data types (including abstract resources)[GraphDefinition, SearchParameter]
//   BindingStrength: Indication of the degree of conformance expectations associated with a binding.[ElementDefinition, OperationDefinition]
//   CapabilityStatementKind: How a capability statement is intended to be used.[CapabilityStatement, TerminologyCapabilities]
//   ClaimProcessingCodes: This value set includes Claim Processing Outcome codes.[ClaimResponse, ExplanationOfBenefit]
//   CompartmentType: Which type a compartment definition describes.[CompartmentDefinition, GraphDefinition]
//   CompositionStatus: The workflow/clinical status of the composition.[Composition, DocumentReference]
//   ConceptMapRelationship: The relationship between concepts.[ConceptMap]
//   ConsentDataMeaning: How a resource reference is interpreted when testing consent restrictions.[Consent, Permission]
//   ConsentProvisionType: How a rule statement is applied, such as adding additional consent or removing consent.[Consent, Permission]
//   Currencies: Currency codes from ISO 4217 (see https://www.iso.org/iso-4217-currency-codes.html)[Account, Money]
//   DaysOfWeek: The days of the week.[Appointment, Availability, Timing]
//   DeviceNameType: The type of name the device is referred by.[Device, DeviceDefinition]
//   DocumentReferenceStatus: The status of the document reference.[DocumentManifest, DocumentReference]
//   EventStatus: Codes identifying the lifecycle stage of an event.[ClinicalImpression, Communication, NutritionIntake, Procedure]
//   EvidenceVariableHandling: The handling of the variable in statistical analysis for exposures or outcomes (E.g. Dichotomous, Continuous, Descriptive).[Evidence, EvidenceVariable]
//   ExampleScenarioActorType: The type of actor - system or human.[ActorDefinition, ExampleScenario]
//   FHIRTypes: All FHIR types[DataRequirement, Measure, OperationDefinition, ParameterDefinition]
//   FHIRVersion: All published FHIR Versions.[CapabilityStatement, ImplementationGuide, StructureDefinition]
//   FilterOperator: The kind of operation to perform as a part of a property based filter.[CodeSystem, ValueSet]
//   FinancialResourceStatusCodes: This value set includes Status codes.[Claim, ClaimResponse, Coverage, CoverageEligibilityRequest, CoverageEligibilityResponse, EnrollmentRequest, EnrollmentResponse, PaymentNotice, PaymentReconciliation, VisionPrescription]
//   ListMode: The processing mode that applies to this list.[Composition, EvidenceReport, List]
//   MeasureImprovementNotation: Observation values that indicate what change in a measurement value or score is indicative of an improvement in the measured item or scored issue.[Measure, MeasureReport]
//   MimeTypes: This value set includes all possible codes from BCP-13 (http://tools.ietf.org/html/bcp13)[Attachment, Binary, CapabilityStatement, ElementDefinition, Endpoint, Signature, Subscription, TestScript]
//   NoteType: The presentation types of notes.[ClaimResponse, ExplanationOfBenefit, PaymentReconciliation]
//   ObservationStatus: Codes providing the status of an observation.[Observation, RiskAssessment]
//   OperationParameterUse: Whether an operation parameter is an input or an output parameter.[OperationDefinition, ParameterDefinition]
//   ParticipationStatus: The Participation status of an appointment.[Appointment, AppointmentResponse]
//   PublicationStatus: The lifecycle status of an artifact.[ActivityDefinition, ActorDefinition, AdministrableProductDefinition, CanonicalResource, CapabilityStatement, ChargeItemDefinition, Citation, CodeSystem, CompartmentDefinition, ConceptMap, ConditionDefinition, EventDefinition, Evidence, EvidenceReport, EvidenceVariable, ExampleScenario, GraphDefinition, ImplementationGuide, Ingredient, InsurancePlan, Library, ManufacturedItemDefinition, Measure, MessageDefinition, MetadataResource, NamingSystem, ObservationDefinition, OperationDefinition, PlanDefinition, Questionnaire, RelatedArtifact, Requirements, ResearchStudy, ResearchSubject, SearchParameter, SpecimenDefinition, StructureDefinition, StructureMap, SubscriptionTopic, TerminologyCapabilities, TestScript, ValueSet]
//   QuantityComparator: How the Quantity should be understood and represented.[Age, Count, Distance, Duration, Quantity]
//   RequestIntent: Codes indicating the degree of authority/intentionality associated with a request.[ActivityDefinition, CommunicationRequest, DeviceRequest, NutritionOrder, RequestOrchestration, ServiceRequest]
//   RequestPriority: Identifies the level of importance to be assigned to actioning the request.[ActivityDefinition, Communication, CommunicationRequest, DeviceRequest, MedicationRequest, NutritionOrder, PlanDefinition, RequestOrchestration, ServiceRequest, SupplyRequest, Task, Transport]
//   RequestStatus: Codes identifying the lifecycle stage of a request.[CarePlan, CommunicationRequest, DeviceRequest, NutritionOrder, RequestOrchestration, ServiceRequest]
//   ResourceTypes: All fhir data types[CapabilityStatement, CompartmentDefinition, GraphDefinition, ImplementationGuide, MessageDefinition, OperationDefinition, Questionnaire, SearchParameter]
//   SearchParamType: Data types allowed to be used for search parameters.[CapabilityStatement, OperationDefinition, SearchParameter]
//   SubscriptionSearchModifier: FHIR search modifiers allowed for use in Subscriptions and SubscriptionTopics.[Subscription, SubscriptionTopic]
//   SubscriptionStatusCodes: State values for FHIR Subscriptions.[Subscription, SubscriptionStatus]
//   Use: The purpose of the Claim: predetermination, preauthorization, claim.[Claim, ClaimResponse, ExplanationOfBenefit]


    public enum ActionCardinalityBehavior {
        /**
         * The action may only be selected one time.
         */
        SINGLE, 
        /**
         * The action may be selected multiple times.
         */
        MULTIPLE, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ActionCardinalityBehavior fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("single".equals(codeString))
          return SINGLE;
        if ("multiple".equals(codeString))
          return MULTIPLE;
        throw new FHIRException("Unknown ActionCardinalityBehavior code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case SINGLE: return "single";
            case MULTIPLE: return "multiple";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case SINGLE: return "http://hl7.org/fhir/action-cardinality-behavior";
            case MULTIPLE: return "http://hl7.org/fhir/action-cardinality-behavior";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case SINGLE: return "The action may only be selected one time.";
            case MULTIPLE: return "The action may be selected multiple times.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case SINGLE: return "Single";
            case MULTIPLE: return "Multiple";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ActionCardinalityBehaviorEnumFactory implements EnumFactory<ActionCardinalityBehavior> {
    public ActionCardinalityBehavior fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("single".equals(codeString))
          return ActionCardinalityBehavior.SINGLE;
        if ("multiple".equals(codeString))
          return ActionCardinalityBehavior.MULTIPLE;
        throw new IllegalArgumentException("Unknown ActionCardinalityBehavior code '"+codeString+"'");
        }
        public Enumeration<ActionCardinalityBehavior> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ActionCardinalityBehavior>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("single".equals(codeString))
          return new Enumeration<ActionCardinalityBehavior>(this, ActionCardinalityBehavior.SINGLE);
        if ("multiple".equals(codeString))
          return new Enumeration<ActionCardinalityBehavior>(this, ActionCardinalityBehavior.MULTIPLE);
        throw new FHIRException("Unknown ActionCardinalityBehavior code '"+codeString+"'");
        }
    public String toCode(ActionCardinalityBehavior code) {
      if (code == ActionCardinalityBehavior.SINGLE)
        return "single";
      if (code == ActionCardinalityBehavior.MULTIPLE)
        return "multiple";
      return "?";
      }
    public String toSystem(ActionCardinalityBehavior code) {
      return code.getSystem();
      }
    }

    public enum ActionConditionKind {
        /**
         * The condition describes whether or not a given action is applicable.
         */
        APPLICABILITY, 
        /**
         * The condition is a starting condition for the action.
         */
        START, 
        /**
         * The condition is a stop, or exit condition for the action.
         */
        STOP, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ActionConditionKind fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("applicability".equals(codeString))
          return APPLICABILITY;
        if ("start".equals(codeString))
          return START;
        if ("stop".equals(codeString))
          return STOP;
        throw new FHIRException("Unknown ActionConditionKind code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case APPLICABILITY: return "applicability";
            case START: return "start";
            case STOP: return "stop";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case APPLICABILITY: return "http://hl7.org/fhir/action-condition-kind";
            case START: return "http://hl7.org/fhir/action-condition-kind";
            case STOP: return "http://hl7.org/fhir/action-condition-kind";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case APPLICABILITY: return "The condition describes whether or not a given action is applicable.";
            case START: return "The condition is a starting condition for the action.";
            case STOP: return "The condition is a stop, or exit condition for the action.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case APPLICABILITY: return "Applicability";
            case START: return "Start";
            case STOP: return "Stop";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ActionConditionKindEnumFactory implements EnumFactory<ActionConditionKind> {
    public ActionConditionKind fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("applicability".equals(codeString))
          return ActionConditionKind.APPLICABILITY;
        if ("start".equals(codeString))
          return ActionConditionKind.START;
        if ("stop".equals(codeString))
          return ActionConditionKind.STOP;
        throw new IllegalArgumentException("Unknown ActionConditionKind code '"+codeString+"'");
        }
        public Enumeration<ActionConditionKind> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ActionConditionKind>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("applicability".equals(codeString))
          return new Enumeration<ActionConditionKind>(this, ActionConditionKind.APPLICABILITY);
        if ("start".equals(codeString))
          return new Enumeration<ActionConditionKind>(this, ActionConditionKind.START);
        if ("stop".equals(codeString))
          return new Enumeration<ActionConditionKind>(this, ActionConditionKind.STOP);
        throw new FHIRException("Unknown ActionConditionKind code '"+codeString+"'");
        }
    public String toCode(ActionConditionKind code) {
      if (code == ActionConditionKind.APPLICABILITY)
        return "applicability";
      if (code == ActionConditionKind.START)
        return "start";
      if (code == ActionConditionKind.STOP)
        return "stop";
      return "?";
      }
    public String toSystem(ActionConditionKind code) {
      return code.getSystem();
      }
    }

    public enum ActionGroupingBehavior {
        /**
         * Any group marked with this behavior should be displayed as a visual group to the end user.
         */
        VISUALGROUP, 
        /**
         * A group with this behavior logically groups its sub-elements, and may be shown as a visual group to the end user, but it is not required to do so.
         */
        LOGICALGROUP, 
        /**
         * A group of related alternative actions is a sentence group if the target referenced by the action is the same in all the actions and each action simply constitutes a different variation on how to specify the details for the target. For example, two actions that could be in a SentenceGroup are "aspirin, 500 mg, 2 times per day" and "aspirin, 300 mg, 3 times per day". In both cases, aspirin is the target referenced by the action, and the two actions represent different options for how aspirin might be ordered for the patient. Note that a SentenceGroup would almost always have an associated selection behavior of "AtMostOne", unless it's a required action, in which case, it would be "ExactlyOne".
         */
        SENTENCEGROUP, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ActionGroupingBehavior fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("visual-group".equals(codeString))
          return VISUALGROUP;
        if ("logical-group".equals(codeString))
          return LOGICALGROUP;
        if ("sentence-group".equals(codeString))
          return SENTENCEGROUP;
        throw new FHIRException("Unknown ActionGroupingBehavior code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case VISUALGROUP: return "visual-group";
            case LOGICALGROUP: return "logical-group";
            case SENTENCEGROUP: return "sentence-group";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case VISUALGROUP: return "http://hl7.org/fhir/action-grouping-behavior";
            case LOGICALGROUP: return "http://hl7.org/fhir/action-grouping-behavior";
            case SENTENCEGROUP: return "http://hl7.org/fhir/action-grouping-behavior";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case VISUALGROUP: return "Any group marked with this behavior should be displayed as a visual group to the end user.";
            case LOGICALGROUP: return "A group with this behavior logically groups its sub-elements, and may be shown as a visual group to the end user, but it is not required to do so.";
            case SENTENCEGROUP: return "A group of related alternative actions is a sentence group if the target referenced by the action is the same in all the actions and each action simply constitutes a different variation on how to specify the details for the target. For example, two actions that could be in a SentenceGroup are \"aspirin, 500 mg, 2 times per day\" and \"aspirin, 300 mg, 3 times per day\". In both cases, aspirin is the target referenced by the action, and the two actions represent different options for how aspirin might be ordered for the patient. Note that a SentenceGroup would almost always have an associated selection behavior of \"AtMostOne\", unless it's a required action, in which case, it would be \"ExactlyOne\".";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case VISUALGROUP: return "Visual Group";
            case LOGICALGROUP: return "Logical Group";
            case SENTENCEGROUP: return "Sentence Group";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ActionGroupingBehaviorEnumFactory implements EnumFactory<ActionGroupingBehavior> {
    public ActionGroupingBehavior fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("visual-group".equals(codeString))
          return ActionGroupingBehavior.VISUALGROUP;
        if ("logical-group".equals(codeString))
          return ActionGroupingBehavior.LOGICALGROUP;
        if ("sentence-group".equals(codeString))
          return ActionGroupingBehavior.SENTENCEGROUP;
        throw new IllegalArgumentException("Unknown ActionGroupingBehavior code '"+codeString+"'");
        }
        public Enumeration<ActionGroupingBehavior> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ActionGroupingBehavior>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("visual-group".equals(codeString))
          return new Enumeration<ActionGroupingBehavior>(this, ActionGroupingBehavior.VISUALGROUP);
        if ("logical-group".equals(codeString))
          return new Enumeration<ActionGroupingBehavior>(this, ActionGroupingBehavior.LOGICALGROUP);
        if ("sentence-group".equals(codeString))
          return new Enumeration<ActionGroupingBehavior>(this, ActionGroupingBehavior.SENTENCEGROUP);
        throw new FHIRException("Unknown ActionGroupingBehavior code '"+codeString+"'");
        }
    public String toCode(ActionGroupingBehavior code) {
      if (code == ActionGroupingBehavior.VISUALGROUP)
        return "visual-group";
      if (code == ActionGroupingBehavior.LOGICALGROUP)
        return "logical-group";
      if (code == ActionGroupingBehavior.SENTENCEGROUP)
        return "sentence-group";
      return "?";
      }
    public String toSystem(ActionGroupingBehavior code) {
      return code.getSystem();
      }
    }

    public enum ActionParticipantType {
        /**
         * The participant is a care team caring for the patient under evaluation.
         */
        CARETEAM, 
        /**
         * The participant is a system or device used in the care of the patient.
         */
        DEVICE, 
        /**
         * The participant is a group of participants involved in the care of the patient.
         */
        GROUP, 
        /**
         * The participant is an institution that can provide the given healthcare service used in the care of the patient.
         */
        HEALTHCARESERVICE, 
        /**
         * The participant is a location involved in the care of the patient.
         */
        LOCATION, 
        /**
         * The participant is an organization involved in the care of the patient.
         */
        ORGANIZATION, 
        /**
         * The participant is the patient under evaluation.
         */
        PATIENT, 
        /**
         * The participant is a practitioner involved in the patient's care.
         */
        PRACTITIONER, 
        /**
         * The participant is a particular practitioner role involved in the patient's care.
         */
        PRACTITIONERROLE, 
        /**
         * The participant is a person related to the patient.
         */
        RELATEDPERSON, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ActionParticipantType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("careteam".equals(codeString))
          return CARETEAM;
        if ("device".equals(codeString))
          return DEVICE;
        if ("group".equals(codeString))
          return GROUP;
        if ("healthcareservice".equals(codeString))
          return HEALTHCARESERVICE;
        if ("location".equals(codeString))
          return LOCATION;
        if ("organization".equals(codeString))
          return ORGANIZATION;
        if ("patient".equals(codeString))
          return PATIENT;
        if ("practitioner".equals(codeString))
          return PRACTITIONER;
        if ("practitionerrole".equals(codeString))
          return PRACTITIONERROLE;
        if ("relatedperson".equals(codeString))
          return RELATEDPERSON;
        throw new FHIRException("Unknown ActionParticipantType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CARETEAM: return "careteam";
            case DEVICE: return "device";
            case GROUP: return "group";
            case HEALTHCARESERVICE: return "healthcareservice";
            case LOCATION: return "location";
            case ORGANIZATION: return "organization";
            case PATIENT: return "patient";
            case PRACTITIONER: return "practitioner";
            case PRACTITIONERROLE: return "practitionerrole";
            case RELATEDPERSON: return "relatedperson";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CARETEAM: return "http://hl7.org/fhir/action-participant-type";
            case DEVICE: return "http://hl7.org/fhir/action-participant-type";
            case GROUP: return "http://hl7.org/fhir/action-participant-type";
            case HEALTHCARESERVICE: return "http://hl7.org/fhir/action-participant-type";
            case LOCATION: return "http://hl7.org/fhir/action-participant-type";
            case ORGANIZATION: return "http://hl7.org/fhir/action-participant-type";
            case PATIENT: return "http://hl7.org/fhir/action-participant-type";
            case PRACTITIONER: return "http://hl7.org/fhir/action-participant-type";
            case PRACTITIONERROLE: return "http://hl7.org/fhir/action-participant-type";
            case RELATEDPERSON: return "http://hl7.org/fhir/action-participant-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CARETEAM: return "The participant is a care team caring for the patient under evaluation.";
            case DEVICE: return "The participant is a system or device used in the care of the patient.";
            case GROUP: return "The participant is a group of participants involved in the care of the patient.";
            case HEALTHCARESERVICE: return "The participant is an institution that can provide the given healthcare service used in the care of the patient.";
            case LOCATION: return "The participant is a location involved in the care of the patient.";
            case ORGANIZATION: return "The participant is an organization involved in the care of the patient.";
            case PATIENT: return "The participant is the patient under evaluation.";
            case PRACTITIONER: return "The participant is a practitioner involved in the patient's care.";
            case PRACTITIONERROLE: return "The participant is a particular practitioner role involved in the patient's care.";
            case RELATEDPERSON: return "The participant is a person related to the patient.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CARETEAM: return "CareTeam";
            case DEVICE: return "Device";
            case GROUP: return "Group";
            case HEALTHCARESERVICE: return "HealthcareService";
            case LOCATION: return "Location";
            case ORGANIZATION: return "Organization";
            case PATIENT: return "Patient";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case RELATEDPERSON: return "RelatedPerson";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ActionParticipantTypeEnumFactory implements EnumFactory<ActionParticipantType> {
    public ActionParticipantType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("careteam".equals(codeString))
          return ActionParticipantType.CARETEAM;
        if ("device".equals(codeString))
          return ActionParticipantType.DEVICE;
        if ("group".equals(codeString))
          return ActionParticipantType.GROUP;
        if ("healthcareservice".equals(codeString))
          return ActionParticipantType.HEALTHCARESERVICE;
        if ("location".equals(codeString))
          return ActionParticipantType.LOCATION;
        if ("organization".equals(codeString))
          return ActionParticipantType.ORGANIZATION;
        if ("patient".equals(codeString))
          return ActionParticipantType.PATIENT;
        if ("practitioner".equals(codeString))
          return ActionParticipantType.PRACTITIONER;
        if ("practitionerrole".equals(codeString))
          return ActionParticipantType.PRACTITIONERROLE;
        if ("relatedperson".equals(codeString))
          return ActionParticipantType.RELATEDPERSON;
        throw new IllegalArgumentException("Unknown ActionParticipantType code '"+codeString+"'");
        }
        public Enumeration<ActionParticipantType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ActionParticipantType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("careteam".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.CARETEAM);
        if ("device".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.DEVICE);
        if ("group".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.GROUP);
        if ("healthcareservice".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.HEALTHCARESERVICE);
        if ("location".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.LOCATION);
        if ("organization".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.ORGANIZATION);
        if ("patient".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.PATIENT);
        if ("practitioner".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.PRACTITIONER);
        if ("practitionerrole".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.PRACTITIONERROLE);
        if ("relatedperson".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.RELATEDPERSON);
        throw new FHIRException("Unknown ActionParticipantType code '"+codeString+"'");
        }
    public String toCode(ActionParticipantType code) {
      if (code == ActionParticipantType.CARETEAM)
        return "careteam";
      if (code == ActionParticipantType.DEVICE)
        return "device";
      if (code == ActionParticipantType.GROUP)
        return "group";
      if (code == ActionParticipantType.HEALTHCARESERVICE)
        return "healthcareservice";
      if (code == ActionParticipantType.LOCATION)
        return "location";
      if (code == ActionParticipantType.ORGANIZATION)
        return "organization";
      if (code == ActionParticipantType.PATIENT)
        return "patient";
      if (code == ActionParticipantType.PRACTITIONER)
        return "practitioner";
      if (code == ActionParticipantType.PRACTITIONERROLE)
        return "practitionerrole";
      if (code == ActionParticipantType.RELATEDPERSON)
        return "relatedperson";
      return "?";
      }
    public String toSystem(ActionParticipantType code) {
      return code.getSystem();
      }
    }

    public enum ActionPrecheckBehavior {
        /**
         * An action with this behavior is one of the most frequent action that is, or should be, included by an end user, for the particular context in which the action occurs. The system displaying the action to the end user should consider "pre-checking" such an action as a convenience for the user.
         */
        YES, 
        /**
         * An action with this behavior is one of the less frequent actions included by the end user, for the particular context in which the action occurs. The system displaying the actions to the end user would typically not "pre-check" such an action.
         */
        NO, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ActionPrecheckBehavior fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("yes".equals(codeString))
          return YES;
        if ("no".equals(codeString))
          return NO;
        throw new FHIRException("Unknown ActionPrecheckBehavior code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case YES: return "yes";
            case NO: return "no";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case YES: return "http://hl7.org/fhir/action-precheck-behavior";
            case NO: return "http://hl7.org/fhir/action-precheck-behavior";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case YES: return "An action with this behavior is one of the most frequent action that is, or should be, included by an end user, for the particular context in which the action occurs. The system displaying the action to the end user should consider \"pre-checking\" such an action as a convenience for the user.";
            case NO: return "An action with this behavior is one of the less frequent actions included by the end user, for the particular context in which the action occurs. The system displaying the actions to the end user would typically not \"pre-check\" such an action.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case YES: return "Yes";
            case NO: return "No";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ActionPrecheckBehaviorEnumFactory implements EnumFactory<ActionPrecheckBehavior> {
    public ActionPrecheckBehavior fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("yes".equals(codeString))
          return ActionPrecheckBehavior.YES;
        if ("no".equals(codeString))
          return ActionPrecheckBehavior.NO;
        throw new IllegalArgumentException("Unknown ActionPrecheckBehavior code '"+codeString+"'");
        }
        public Enumeration<ActionPrecheckBehavior> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ActionPrecheckBehavior>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("yes".equals(codeString))
          return new Enumeration<ActionPrecheckBehavior>(this, ActionPrecheckBehavior.YES);
        if ("no".equals(codeString))
          return new Enumeration<ActionPrecheckBehavior>(this, ActionPrecheckBehavior.NO);
        throw new FHIRException("Unknown ActionPrecheckBehavior code '"+codeString+"'");
        }
    public String toCode(ActionPrecheckBehavior code) {
      if (code == ActionPrecheckBehavior.YES)
        return "yes";
      if (code == ActionPrecheckBehavior.NO)
        return "no";
      return "?";
      }
    public String toSystem(ActionPrecheckBehavior code) {
      return code.getSystem();
      }
    }

    public enum ActionRelationshipType {
        /**
         * The action must be performed before the start of the related action.
         */
        BEFORESTART, 
        /**
         * The action must be performed before the related action.
         */
        BEFORE, 
        /**
         * The action must be performed before the end of the related action.
         */
        BEFOREEND, 
        /**
         * The action must be performed concurrent with the start of the related action.
         */
        CONCURRENTWITHSTART, 
        /**
         * The action must be performed concurrent with the related action.
         */
        CONCURRENT, 
        /**
         * The action must be performed concurrent with the end of the related action.
         */
        CONCURRENTWITHEND, 
        /**
         * The action must be performed after the start of the related action.
         */
        AFTERSTART, 
        /**
         * The action must be performed after the related action.
         */
        AFTER, 
        /**
         * The action must be performed after the end of the related action.
         */
        AFTEREND, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ActionRelationshipType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("before-start".equals(codeString))
          return BEFORESTART;
        if ("before".equals(codeString))
          return BEFORE;
        if ("before-end".equals(codeString))
          return BEFOREEND;
        if ("concurrent-with-start".equals(codeString))
          return CONCURRENTWITHSTART;
        if ("concurrent".equals(codeString))
          return CONCURRENT;
        if ("concurrent-with-end".equals(codeString))
          return CONCURRENTWITHEND;
        if ("after-start".equals(codeString))
          return AFTERSTART;
        if ("after".equals(codeString))
          return AFTER;
        if ("after-end".equals(codeString))
          return AFTEREND;
        throw new FHIRException("Unknown ActionRelationshipType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case BEFORESTART: return "before-start";
            case BEFORE: return "before";
            case BEFOREEND: return "before-end";
            case CONCURRENTWITHSTART: return "concurrent-with-start";
            case CONCURRENT: return "concurrent";
            case CONCURRENTWITHEND: return "concurrent-with-end";
            case AFTERSTART: return "after-start";
            case AFTER: return "after";
            case AFTEREND: return "after-end";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case BEFORESTART: return "http://hl7.org/fhir/action-relationship-type";
            case BEFORE: return "http://hl7.org/fhir/action-relationship-type";
            case BEFOREEND: return "http://hl7.org/fhir/action-relationship-type";
            case CONCURRENTWITHSTART: return "http://hl7.org/fhir/action-relationship-type";
            case CONCURRENT: return "http://hl7.org/fhir/action-relationship-type";
            case CONCURRENTWITHEND: return "http://hl7.org/fhir/action-relationship-type";
            case AFTERSTART: return "http://hl7.org/fhir/action-relationship-type";
            case AFTER: return "http://hl7.org/fhir/action-relationship-type";
            case AFTEREND: return "http://hl7.org/fhir/action-relationship-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case BEFORESTART: return "The action must be performed before the start of the related action.";
            case BEFORE: return "The action must be performed before the related action.";
            case BEFOREEND: return "The action must be performed before the end of the related action.";
            case CONCURRENTWITHSTART: return "The action must be performed concurrent with the start of the related action.";
            case CONCURRENT: return "The action must be performed concurrent with the related action.";
            case CONCURRENTWITHEND: return "The action must be performed concurrent with the end of the related action.";
            case AFTERSTART: return "The action must be performed after the start of the related action.";
            case AFTER: return "The action must be performed after the related action.";
            case AFTEREND: return "The action must be performed after the end of the related action.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case BEFORESTART: return "Before Start";
            case BEFORE: return "Before";
            case BEFOREEND: return "Before End";
            case CONCURRENTWITHSTART: return "Concurrent With Start";
            case CONCURRENT: return "Concurrent";
            case CONCURRENTWITHEND: return "Concurrent With End";
            case AFTERSTART: return "After Start";
            case AFTER: return "After";
            case AFTEREND: return "After End";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ActionRelationshipTypeEnumFactory implements EnumFactory<ActionRelationshipType> {
    public ActionRelationshipType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("before-start".equals(codeString))
          return ActionRelationshipType.BEFORESTART;
        if ("before".equals(codeString))
          return ActionRelationshipType.BEFORE;
        if ("before-end".equals(codeString))
          return ActionRelationshipType.BEFOREEND;
        if ("concurrent-with-start".equals(codeString))
          return ActionRelationshipType.CONCURRENTWITHSTART;
        if ("concurrent".equals(codeString))
          return ActionRelationshipType.CONCURRENT;
        if ("concurrent-with-end".equals(codeString))
          return ActionRelationshipType.CONCURRENTWITHEND;
        if ("after-start".equals(codeString))
          return ActionRelationshipType.AFTERSTART;
        if ("after".equals(codeString))
          return ActionRelationshipType.AFTER;
        if ("after-end".equals(codeString))
          return ActionRelationshipType.AFTEREND;
        throw new IllegalArgumentException("Unknown ActionRelationshipType code '"+codeString+"'");
        }
        public Enumeration<ActionRelationshipType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ActionRelationshipType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("before-start".equals(codeString))
          return new Enumeration<ActionRelationshipType>(this, ActionRelationshipType.BEFORESTART);
        if ("before".equals(codeString))
          return new Enumeration<ActionRelationshipType>(this, ActionRelationshipType.BEFORE);
        if ("before-end".equals(codeString))
          return new Enumeration<ActionRelationshipType>(this, ActionRelationshipType.BEFOREEND);
        if ("concurrent-with-start".equals(codeString))
          return new Enumeration<ActionRelationshipType>(this, ActionRelationshipType.CONCURRENTWITHSTART);
        if ("concurrent".equals(codeString))
          return new Enumeration<ActionRelationshipType>(this, ActionRelationshipType.CONCURRENT);
        if ("concurrent-with-end".equals(codeString))
          return new Enumeration<ActionRelationshipType>(this, ActionRelationshipType.CONCURRENTWITHEND);
        if ("after-start".equals(codeString))
          return new Enumeration<ActionRelationshipType>(this, ActionRelationshipType.AFTERSTART);
        if ("after".equals(codeString))
          return new Enumeration<ActionRelationshipType>(this, ActionRelationshipType.AFTER);
        if ("after-end".equals(codeString))
          return new Enumeration<ActionRelationshipType>(this, ActionRelationshipType.AFTEREND);
        throw new FHIRException("Unknown ActionRelationshipType code '"+codeString+"'");
        }
    public String toCode(ActionRelationshipType code) {
      if (code == ActionRelationshipType.BEFORESTART)
        return "before-start";
      if (code == ActionRelationshipType.BEFORE)
        return "before";
      if (code == ActionRelationshipType.BEFOREEND)
        return "before-end";
      if (code == ActionRelationshipType.CONCURRENTWITHSTART)
        return "concurrent-with-start";
      if (code == ActionRelationshipType.CONCURRENT)
        return "concurrent";
      if (code == ActionRelationshipType.CONCURRENTWITHEND)
        return "concurrent-with-end";
      if (code == ActionRelationshipType.AFTERSTART)
        return "after-start";
      if (code == ActionRelationshipType.AFTER)
        return "after";
      if (code == ActionRelationshipType.AFTEREND)
        return "after-end";
      return "?";
      }
    public String toSystem(ActionRelationshipType code) {
      return code.getSystem();
      }
    }

    public enum ActionRequiredBehavior {
        /**
         * An action with this behavior must be included in the actions processed by the end user; the end user SHALL NOT choose not to include this action.
         */
        MUST, 
        /**
         * An action with this behavior may be included in the set of actions processed by the end user.
         */
        COULD, 
        /**
         * An action with this behavior must be included in the set of actions processed by the end user, unless the end user provides documentation as to why the action was not included.
         */
        MUSTUNLESSDOCUMENTED, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ActionRequiredBehavior fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("must".equals(codeString))
          return MUST;
        if ("could".equals(codeString))
          return COULD;
        if ("must-unless-documented".equals(codeString))
          return MUSTUNLESSDOCUMENTED;
        throw new FHIRException("Unknown ActionRequiredBehavior code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case MUST: return "must";
            case COULD: return "could";
            case MUSTUNLESSDOCUMENTED: return "must-unless-documented";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case MUST: return "http://hl7.org/fhir/action-required-behavior";
            case COULD: return "http://hl7.org/fhir/action-required-behavior";
            case MUSTUNLESSDOCUMENTED: return "http://hl7.org/fhir/action-required-behavior";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case MUST: return "An action with this behavior must be included in the actions processed by the end user; the end user SHALL NOT choose not to include this action.";
            case COULD: return "An action with this behavior may be included in the set of actions processed by the end user.";
            case MUSTUNLESSDOCUMENTED: return "An action with this behavior must be included in the set of actions processed by the end user, unless the end user provides documentation as to why the action was not included.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case MUST: return "Must";
            case COULD: return "Could";
            case MUSTUNLESSDOCUMENTED: return "Must Unless Documented";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ActionRequiredBehaviorEnumFactory implements EnumFactory<ActionRequiredBehavior> {
    public ActionRequiredBehavior fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("must".equals(codeString))
          return ActionRequiredBehavior.MUST;
        if ("could".equals(codeString))
          return ActionRequiredBehavior.COULD;
        if ("must-unless-documented".equals(codeString))
          return ActionRequiredBehavior.MUSTUNLESSDOCUMENTED;
        throw new IllegalArgumentException("Unknown ActionRequiredBehavior code '"+codeString+"'");
        }
        public Enumeration<ActionRequiredBehavior> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ActionRequiredBehavior>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("must".equals(codeString))
          return new Enumeration<ActionRequiredBehavior>(this, ActionRequiredBehavior.MUST);
        if ("could".equals(codeString))
          return new Enumeration<ActionRequiredBehavior>(this, ActionRequiredBehavior.COULD);
        if ("must-unless-documented".equals(codeString))
          return new Enumeration<ActionRequiredBehavior>(this, ActionRequiredBehavior.MUSTUNLESSDOCUMENTED);
        throw new FHIRException("Unknown ActionRequiredBehavior code '"+codeString+"'");
        }
    public String toCode(ActionRequiredBehavior code) {
      if (code == ActionRequiredBehavior.MUST)
        return "must";
      if (code == ActionRequiredBehavior.COULD)
        return "could";
      if (code == ActionRequiredBehavior.MUSTUNLESSDOCUMENTED)
        return "must-unless-documented";
      return "?";
      }
    public String toSystem(ActionRequiredBehavior code) {
      return code.getSystem();
      }
    }

    public enum ActionSelectionBehavior {
        /**
         * Any number of the actions in the group may be chosen, from zero to all.
         */
        ANY, 
        /**
         * All the actions in the group must be selected as a single unit.
         */
        ALL, 
        /**
         * All the actions in the group are meant to be chosen as a single unit: either all must be selected by the end user, or none may be selected.
         */
        ALLORNONE, 
        /**
         * The end user must choose one and only one of the selectable actions in the group. The user SHALL NOT choose none of the actions in the group.
         */
        EXACTLYONE, 
        /**
         * The end user may choose zero or at most one of the actions in the group.
         */
        ATMOSTONE, 
        /**
         * The end user must choose a minimum of one, and as many additional as desired.
         */
        ONEORMORE, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ActionSelectionBehavior fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("any".equals(codeString))
          return ANY;
        if ("all".equals(codeString))
          return ALL;
        if ("all-or-none".equals(codeString))
          return ALLORNONE;
        if ("exactly-one".equals(codeString))
          return EXACTLYONE;
        if ("at-most-one".equals(codeString))
          return ATMOSTONE;
        if ("one-or-more".equals(codeString))
          return ONEORMORE;
        throw new FHIRException("Unknown ActionSelectionBehavior code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ANY: return "any";
            case ALL: return "all";
            case ALLORNONE: return "all-or-none";
            case EXACTLYONE: return "exactly-one";
            case ATMOSTONE: return "at-most-one";
            case ONEORMORE: return "one-or-more";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ANY: return "http://hl7.org/fhir/action-selection-behavior";
            case ALL: return "http://hl7.org/fhir/action-selection-behavior";
            case ALLORNONE: return "http://hl7.org/fhir/action-selection-behavior";
            case EXACTLYONE: return "http://hl7.org/fhir/action-selection-behavior";
            case ATMOSTONE: return "http://hl7.org/fhir/action-selection-behavior";
            case ONEORMORE: return "http://hl7.org/fhir/action-selection-behavior";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ANY: return "Any number of the actions in the group may be chosen, from zero to all.";
            case ALL: return "All the actions in the group must be selected as a single unit.";
            case ALLORNONE: return "All the actions in the group are meant to be chosen as a single unit: either all must be selected by the end user, or none may be selected.";
            case EXACTLYONE: return "The end user must choose one and only one of the selectable actions in the group. The user SHALL NOT choose none of the actions in the group.";
            case ATMOSTONE: return "The end user may choose zero or at most one of the actions in the group.";
            case ONEORMORE: return "The end user must choose a minimum of one, and as many additional as desired.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ANY: return "Any";
            case ALL: return "All";
            case ALLORNONE: return "All Or None";
            case EXACTLYONE: return "Exactly One";
            case ATMOSTONE: return "At Most One";
            case ONEORMORE: return "One Or More";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ActionSelectionBehaviorEnumFactory implements EnumFactory<ActionSelectionBehavior> {
    public ActionSelectionBehavior fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("any".equals(codeString))
          return ActionSelectionBehavior.ANY;
        if ("all".equals(codeString))
          return ActionSelectionBehavior.ALL;
        if ("all-or-none".equals(codeString))
          return ActionSelectionBehavior.ALLORNONE;
        if ("exactly-one".equals(codeString))
          return ActionSelectionBehavior.EXACTLYONE;
        if ("at-most-one".equals(codeString))
          return ActionSelectionBehavior.ATMOSTONE;
        if ("one-or-more".equals(codeString))
          return ActionSelectionBehavior.ONEORMORE;
        throw new IllegalArgumentException("Unknown ActionSelectionBehavior code '"+codeString+"'");
        }
        public Enumeration<ActionSelectionBehavior> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ActionSelectionBehavior>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("any".equals(codeString))
          return new Enumeration<ActionSelectionBehavior>(this, ActionSelectionBehavior.ANY);
        if ("all".equals(codeString))
          return new Enumeration<ActionSelectionBehavior>(this, ActionSelectionBehavior.ALL);
        if ("all-or-none".equals(codeString))
          return new Enumeration<ActionSelectionBehavior>(this, ActionSelectionBehavior.ALLORNONE);
        if ("exactly-one".equals(codeString))
          return new Enumeration<ActionSelectionBehavior>(this, ActionSelectionBehavior.EXACTLYONE);
        if ("at-most-one".equals(codeString))
          return new Enumeration<ActionSelectionBehavior>(this, ActionSelectionBehavior.ATMOSTONE);
        if ("one-or-more".equals(codeString))
          return new Enumeration<ActionSelectionBehavior>(this, ActionSelectionBehavior.ONEORMORE);
        throw new FHIRException("Unknown ActionSelectionBehavior code '"+codeString+"'");
        }
    public String toCode(ActionSelectionBehavior code) {
      if (code == ActionSelectionBehavior.ANY)
        return "any";
      if (code == ActionSelectionBehavior.ALL)
        return "all";
      if (code == ActionSelectionBehavior.ALLORNONE)
        return "all-or-none";
      if (code == ActionSelectionBehavior.EXACTLYONE)
        return "exactly-one";
      if (code == ActionSelectionBehavior.ATMOSTONE)
        return "at-most-one";
      if (code == ActionSelectionBehavior.ONEORMORE)
        return "one-or-more";
      return "?";
      }
    public String toSystem(ActionSelectionBehavior code) {
      return code.getSystem();
      }
    }

    public enum AdministrativeGender {
        /**
         * Male.
         */
        MALE, 
        /**
         * Female.
         */
        FEMALE, 
        /**
         * Other.
         */
        OTHER, 
        /**
         * Unknown.
         */
        UNKNOWN, 
        /**
         * added to help the parsers
         */
        NULL;
        public static AdministrativeGender fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("male".equals(codeString))
          return MALE;
        if ("female".equals(codeString))
          return FEMALE;
        if ("other".equals(codeString))
          return OTHER;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        throw new FHIRException("Unknown AdministrativeGender code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case MALE: return "male";
            case FEMALE: return "female";
            case OTHER: return "other";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case MALE: return "http://hl7.org/fhir/administrative-gender";
            case FEMALE: return "http://hl7.org/fhir/administrative-gender";
            case OTHER: return "http://hl7.org/fhir/administrative-gender";
            case UNKNOWN: return "http://hl7.org/fhir/administrative-gender";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case MALE: return "Male.";
            case FEMALE: return "Female.";
            case OTHER: return "Other.";
            case UNKNOWN: return "Unknown.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case MALE: return "Male";
            case FEMALE: return "Female";
            case OTHER: return "Other";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class AdministrativeGenderEnumFactory implements EnumFactory<AdministrativeGender> {
    public AdministrativeGender fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("male".equals(codeString))
          return AdministrativeGender.MALE;
        if ("female".equals(codeString))
          return AdministrativeGender.FEMALE;
        if ("other".equals(codeString))
          return AdministrativeGender.OTHER;
        if ("unknown".equals(codeString))
          return AdministrativeGender.UNKNOWN;
        throw new IllegalArgumentException("Unknown AdministrativeGender code '"+codeString+"'");
        }
        public Enumeration<AdministrativeGender> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AdministrativeGender>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("male".equals(codeString))
          return new Enumeration<AdministrativeGender>(this, AdministrativeGender.MALE);
        if ("female".equals(codeString))
          return new Enumeration<AdministrativeGender>(this, AdministrativeGender.FEMALE);
        if ("other".equals(codeString))
          return new Enumeration<AdministrativeGender>(this, AdministrativeGender.OTHER);
        if ("unknown".equals(codeString))
          return new Enumeration<AdministrativeGender>(this, AdministrativeGender.UNKNOWN);
        throw new FHIRException("Unknown AdministrativeGender code '"+codeString+"'");
        }
    public String toCode(AdministrativeGender code) {
      if (code == AdministrativeGender.MALE)
        return "male";
      if (code == AdministrativeGender.FEMALE)
        return "female";
      if (code == AdministrativeGender.OTHER)
        return "other";
      if (code == AdministrativeGender.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(AdministrativeGender code) {
      return code.getSystem();
      }
    }

    public enum AllResourceTypes {
        /**
         * A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.
         */
        ACCOUNT, 
        /**
         * This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.
         */
        ACTIVITYDEFINITION, 
        /**
         * The ActorDefinition resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.
         */
        ACTORDEFINITION, 
        /**
         * A medicinal product in the final form which is suitable for administering to a patient (after any mixing of multiple components, dissolution etc. has been performed).
         */
        ADMINISTRABLEPRODUCTDEFINITION, 
        /**
         * An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject. The unintended effects may require additional monitoring, treatment, hospitalization, or may result in death. The AdverseEvent resource also extends to potential or avoided events that could have had such effects. There are two major domains where the AdverseEvent resource is expected to be used. One is in clinical care reported adverse events and the other is in reporting adverse events in clinical  research trial management. Given the differences between these two arenas, we recommend consulting the domain specific implementation guides when implementing the AdverseEvent Resource. The implementation guides include specific extensions, value sets and constraints.
         */
        ADVERSEEVENT, 
        /**
         * Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.
         */
        ALLERGYINTOLERANCE, 
        /**
         * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).
         */
        APPOINTMENT, 
        /**
         * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
         */
        APPOINTMENTRESPONSE, 
        /**
         * This Resource provides one or more comments, classifiers or ratings about a Resource and supports attribution and rights management metadata for the added content.
         */
        ARTIFACTASSESSMENT, 
        /**
         * A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.
         */
        AUDITEVENT, 
        /**
         * Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.
         */
        BASIC, 
        /**
         * A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.
         */
        BINARY, 
        /**
         * A biological material originating from a biological entity intended to be transplanted or infused into another (possibly the same) biological entity.
         */
        BIOLOGICALLYDERIVEDPRODUCT, 
        /**
         * Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.
         */
        BODYSTRUCTURE, 
        /**
         * A container for a collection of resources.
         */
        BUNDLE, 
        /**
         * Common Interface declaration for conformance and knowledge artifact resources.
         */
        CANONICALRESOURCE, 
        /**
         * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server or Client for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        CAPABILITYSTATEMENT, 
        /**
         * Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.
         */
        CAREPLAN, 
        /**
         * The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.
         */
        CARETEAM, 
        /**
         * The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.
         */
        CHARGEITEM, 
        /**
         * The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.
         */
        CHARGEITEMDEFINITION, 
        /**
         * The Citation Resource enables reference to any knowledge artifact for purposes of identification and attribution. The Citation Resource supports existing reference structures and developing publication practices such as versioning, expressing complex contributorship roles, and referencing computable resources.
         */
        CITATION, 
        /**
         * A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.
         */
        CLAIM, 
        /**
         * This resource provides the adjudication details from the processing of a Claim resource.
         */
        CLAIMRESPONSE, 
        /**
         * A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called "ClinicalImpression" rather than "ClinicalAssessment" to avoid confusion with the recording of assessment tools such as Apgar score.
         */
        CLINICALIMPRESSION, 
        /**
         * A single issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.
         */
        CLINICALUSEDEFINITION, 
        /**
         * The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.
         */
        CODESYSTEM, 
        /**
         * A clinical or business level record of information being transmitted or shared; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.
         */
        COMMUNICATION, 
        /**
         * A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.
         */
        COMMUNICATIONREQUEST, 
        /**
         * A compartment definition that defines how resources are accessed on a server.
         */
        COMPARTMENTDEFINITION, 
        /**
         * A set of healthcare-related information that is assembled together into a single logical package that provides a single coherent statement of meaning, establishes its own context and that has clinical attestation with regard to who is making the statement. A Composition defines the structure and narrative content necessary for a document. However, a Composition alone does not constitute a document. Rather, the Composition must be the first entry in a Bundle where Bundle.type=document, and any other resources referenced from Composition must be included as subsequent entries in the Bundle (for example Patient, Practitioner, Encounter, etc.).
         */
        COMPOSITION, 
        /**
         * A statement of relationships from one set of concepts to one or more other concepts - either concepts in code systems, or data element/data element concepts, or classes in class models.
         */
        CONCEPTMAP, 
        /**
         * A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a level of concern.
         */
        CONDITION, 
        /**
         * A definition of a condition and information relevant to managing it.
         */
        CONDITIONDEFINITION, 
        /**
         * A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.
         */
        CONSENT, 
        /**
         * Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement.
         */
        CONTRACT, 
        /**
         * Financial instrument which may be used to reimburse or pay for health care products and services. Includes both insurance and self-payment.
         */
        COVERAGE, 
        /**
         * The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage is valid and in-force and optionally to provide the insurance details of the policy.
         */
        COVERAGEELIGIBILITYREQUEST, 
        /**
         * This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.
         */
        COVERAGEELIGIBILITYRESPONSE, 
        /**
         * Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, etc.
         */
        DETECTEDISSUE, 
        /**
         * This resource describes the properties (regulated, has real time clock, etc.), adminstrative (manufacturer name, model number, serial number, firmware, etc), and type (knee replacement, blood pressure cuff, MRI, etc.) of a physical unit (these values do not change much within a given module, for example the serail number, manufacturer name, and model number). An actual unit may consist of several modules in a distinct hierarchy and these are represented by multiple Device resources and bound through the 'parent' element.
         */
        DEVICE, 
        /**
         * This is a specialized resource that defines the characteristics and capabilities of a device.
         */
        DEVICEDEFINITION, 
        /**
         * Indicates that a device is to be or has been dispensed for a named person/patient.  This includes a description of the product (supply) provided and the instructions for using the device.
         */
        DEVICEDISPENSE, 
        /**
         * Describes a measurement, calculation or setting capability of a medical device.
         */
        DEVICEMETRIC, 
        /**
         * Represents a request a device to be provided to a specific patient. The device may be an implantable device to be subsequently implanted, or an external assistive device, such as a walker, to be delivered and subsequently be used.
         */
        DEVICEREQUEST, 
        /**
         * A record of a device being used by a patient where the record is the result of a report from the patient or a clinician.
         */
        DEVICEUSAGE, 
        /**
         * The findings and interpretation of diagnostic tests performed on patients, groups of patients, products, substances, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports. The report also includes non-clinical context such as batch analysis and stability reporting of products and substances.
         */
        DIAGNOSTICREPORT, 
        /**
         * A collection of documents compiled for a purpose together with metadata that applies to the collection.
         */
        DOCUMENTMANIFEST, 
        /**
         * A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this "document" encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.
         */
        DOCUMENTREFERENCE, 
        /**
         * A resource that includes narrative, extensions, and contained resources.
         */
        DOMAINRESOURCE, 
        /**
         * An interaction between healthcare provider(s), and/or patient(s) for the purpose of providing healthcare service(s) or assessing the health status of patient(s).
         */
        ENCOUNTER, 
        /**
         * The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b, a REST endpoint for another FHIR server, or a s/Mime email address. This may include any security context information.
         */
        ENDPOINT, 
        /**
         * This resource provides the insurance enrollment details to the insurer regarding a specified coverage.
         */
        ENROLLMENTREQUEST, 
        /**
         * This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.
         */
        ENROLLMENTRESPONSE, 
        /**
         * An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.
         */
        EPISODEOFCARE, 
        /**
         * The EventDefinition resource provides a reusable description of when a particular event can occur.
         */
        EVENTDEFINITION, 
        /**
         * The Evidence Resource provides a machine-interpretable expression of an evidence concept including the evidence variables (e.g., population, exposures/interventions, comparators, outcomes, measured variables, confounding variables), the statistics, and the certainty of this evidence.
         */
        EVIDENCE, 
        /**
         * The EvidenceReport Resource is a specialized container for a collection of resources and codeable concepts, adapted to support compositions of Evidence, EvidenceVariable, and Citation resources and related concepts.
         */
        EVIDENCEREPORT, 
        /**
         * The EvidenceVariable resource describes an element that knowledge (Evidence) is about.
         */
        EVIDENCEVARIABLE, 
        /**
         * A walkthrough of a workflow showing the interaction between systems and the instances shared, possibly including the evolution of instances over time.
         */
        EXAMPLESCENARIO, 
        /**
         * This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.
         */
        EXPLANATIONOFBENEFIT, 
        /**
         * Significant health conditions for a person related to the patient relevant in the context of care for the patient.
         */
        FAMILYMEMBERHISTORY, 
        /**
         * Prospective warnings of potential issues when providing care to the patient.
         */
        FLAG, 
        /**
         * This resource describes a product or service that is available through a program and includes the conditions and constraints of availability.  All of the information in this resource is specific to the inclusion of the item in the formulary and is not inherent to the item itself.
         */
        FORMULARYITEM, 
        /**
         * A Genomic Study is a set of analysis performed to analyze and generate genomic data.
         */
        GENOMICSTUDY, 
        /**
         * Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.
         */
        GOAL, 
        /**
         * A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.
         */
        GRAPHDEFINITION, 
        /**
         * Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.
         */
        GROUP, 
        /**
         * A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.
         */
        GUIDANCERESPONSE, 
        /**
         * The details of a healthcare service available at a location or in a catalog.  In the case where there is a hierarchy of services (for example, Lab -> Pathology -> Wound Cultures), this can be represented using a set of linked HealthcareServices.
         */
        HEALTHCARESERVICE, 
        /**
         * A selection of DICOM SOP instances and/or frames within a single Study and Series. This might include additional specifics such as an image region, an Observation UID or a Segmentation Number, allowing linkage to an Observation Resource or transferring this information along with the ImagingStudy Resource.
         */
        IMAGINGSELECTION, 
        /**
         * Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.
         */
        IMAGINGSTUDY, 
        /**
         * Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.
         */
        IMMUNIZATION, 
        /**
         * Describes a comparison of an immunization event against published recommendations to determine if the administration is "valid" in relation to those  recommendations.
         */
        IMMUNIZATIONEVALUATION, 
        /**
         * A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.
         */
        IMMUNIZATIONRECOMMENDATION, 
        /**
         * A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.
         */
        IMPLEMENTATIONGUIDE, 
        /**
         * An ingredient of a manufactured item or pharmaceutical product.
         */
        INGREDIENT, 
        /**
         * Details of a Health Insurance product/plan provided by an organization.
         */
        INSURANCEPLAN, 
        /**
         * A report of inventory or stock items.
         */
        INVENTORYREPORT, 
        /**
         * Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.
         */
        INVOICE, 
        /**
         * The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.
         */
        LIBRARY, 
        /**
         * Identifies two or more records (resource instances) that refer to the same real-world "occurrence".
         */
        LINKAGE, 
        /**
         * A List is a curated collection of resources, for things such as problem lists, allergy lists, facility list, organization list, etc.
         */
        LIST, 
        /**
         * Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.
         */
        LOCATION, 
        /**
         * The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.
         */
        MANUFACTUREDITEMDEFINITION, 
        /**
         * The Measure resource provides the definition of a quality measure.
         */
        MEASURE, 
        /**
         * The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.
         */
        MEASUREREPORT, 
        /**
         * This resource is primarily used for the identification and definition of a medication, including ingredients, for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.
         */
        MEDICATION, 
        /**
         * Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.
         */
        MEDICATIONADMINISTRATION, 
        /**
         * Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.
         */
        MEDICATIONDISPENSE, 
        /**
         * Information about a medication that is used to support knowledge.
         */
        MEDICATIONKNOWLEDGE, 
        /**
         * An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called "MedicationRequest" rather than "MedicationPrescription" or "MedicationOrder" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.
         */
        MEDICATIONREQUEST, 
        /**
         * A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. 

The primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.
         */
        MEDICATIONUSAGE, 
        /**
         * Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use, drug catalogs, to support prescribing, adverse events management etc.).
         */
        MEDICINALPRODUCTDEFINITION, 
        /**
         * Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.
         */
        MESSAGEDEFINITION, 
        /**
         * The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.
         */
        MESSAGEHEADER, 
        /**
         * Common Interface declaration for conformance and knowledge artifact resources.
         */
        METADATARESOURCE, 
        /**
         * Representation of a molecular sequence.
         */
        MOLECULARSEQUENCE, 
        /**
         * A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a "System" used within the Identifier and Coding data types.
         */
        NAMINGSYSTEM, 
        /**
         * A record of food or fluid that is being consumed by a patient.  A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.
         */
        NUTRITIONINTAKE, 
        /**
         * A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.
         */
        NUTRITIONORDER, 
        /**
         * A food or supplement that is consumed by patients.
         */
        NUTRITIONPRODUCT, 
        /**
         * Measurements and simple assertions made about a patient, device or other subject.
         */
        OBSERVATION, 
        /**
         * Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.
         */
        OBSERVATIONDEFINITION, 
        /**
         * A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).
         */
        OPERATIONDEFINITION, 
        /**
         * A collection of error, warning, or information messages that result from a system action.
         */
        OPERATIONOUTCOME, 
        /**
         * A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.
         */
        ORGANIZATION, 
        /**
         * Defines an affiliation/assotiation/relationship between 2 distinct organizations, that is not a part-of relationship/sub-division relationship.
         */
        ORGANIZATIONAFFILIATION, 
        /**
         * A medically related item or items, in a container or package.
         */
        PACKAGEDPRODUCTDEFINITION, 
        /**
         * This resource is used to pass information into and back from an operation (whether invoked directly from REST or within a messaging environment).  It is not persisted or allowed to be referenced by other resources except as described in the definition of the Parameters resource.
         */
        PARAMETERS, 
        /**
         * Demographics and other administrative information about an individual or animal receiving care or other health-related services.
         */
        PATIENT, 
        /**
         * This resource provides the status of the payment for goods and services rendered, and the request and response resource references.
         */
        PAYMENTNOTICE, 
        /**
         * This resource provides the details including amount of a payment and allocates the payment items being paid.
         */
        PAYMENTRECONCILIATION, 
        /**
         * Permission resource holds access rules for a given data and context.
         */
        PERMISSION, 
        /**
         * Demographics and administrative information about a person independent of a specific health-related context.
         */
        PERSON, 
        /**
         * This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical and non-clinical artifacts such as clinical decision support rules, order sets, protocols, and drug quality specifications.
         */
        PLANDEFINITION, 
        /**
         * A person who is directly or indirectly involved in the provisioning of healthcare or related services.
         */
        PRACTITIONER, 
        /**
         * A specific set of Roles/Locations/specialties/services that a practitioner may perform, or has performed at an organization during a period of time.
         */
        PRACTITIONERROLE, 
        /**
         * An action that is or was performed on or for a patient, practitioner, device, organization, or location. For example, this can be a physical intervention on a patient like an operation, or less invasive like long term services, counseling, or hypnotherapy.  This can be a quality or safety inspection for a location, organization, or device.  This can be an accreditation procedure on a practitioner for licensing.
         */
        PROCEDURE, 
        /**
         * Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.
         */
        PROVENANCE, 
        /**
         * A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.
         */
        QUESTIONNAIRE, 
        /**
         * A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.
         */
        QUESTIONNAIRERESPONSE, 
        /**
         * Regulatory approval, clearance or licencing related to a regulated product, treatment, facility or activity that is cited in a guidance, regulation, rule or legislative act. An example is Market Authorization relating to a Medicinal Product.
         */
        REGULATEDAUTHORIZATION, 
        /**
         * Information about a person that is involved in a patient's health or the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.
         */
        RELATEDPERSON, 
        /**
         * A set of related requests that can be used to capture intended activities that have inter-dependencies such as "give this medication after that one".
         */
        REQUESTORCHESTRATION, 
        /**
         * The Requirements resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.
         */
        REQUIREMENTS, 
        /**
         * A scientific study of nature that sometimes includes processes involved in health and disease. For example, clinical trials are research studies that involve people. These studies may be related to new ways to screen, prevent, diagnose, and treat disease. They may also study certain outcomes and certain groups of people by looking at data collected in the past or future.
         */
        RESEARCHSTUDY, 
        /**
         * A physical entity which is the primary unit of operational and/or administrative interest in a study.
         */
        RESEARCHSUBJECT, 
        /**
         * This is the base resource type for everything.
         */
        RESOURCE, 
        /**
         * An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.
         */
        RISKASSESSMENT, 
        /**
         * A container for slots of time that may be available for booking appointments.
         */
        SCHEDULE, 
        /**
         * A search parameter that defines a named search item that can be used to search/filter on a resource.
         */
        SEARCHPARAMETER, 
        /**
         * A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.
         */
        SERVICEREQUEST, 
        /**
         * A slot of time on a schedule that may be available for booking appointments.
         */
        SLOT, 
        /**
         * A sample to be used for analysis.
         */
        SPECIMEN, 
        /**
         * A kind of specimen with associated set of requirements.
         */
        SPECIMENDEFINITION, 
        /**
         * A definition of a FHIR structure. This resource is used to describe the underlying resources, data types defined in FHIR, and also for describing extensions and constraints on resources and data types.
         */
        STRUCTUREDEFINITION, 
        /**
         * A Map of relationships between 2 structures that can be used to transform data.
         */
        STRUCTUREMAP, 
        /**
         * The subscription resource describes a particular client's request to be notified about a SubscriptionTopic.
         */
        SUBSCRIPTION, 
        /**
         * The SubscriptionStatus resource describes the state of a Subscription during notifications. It is not persisted.
         */
        SUBSCRIPTIONSTATUS, 
        /**
         * Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.
         */
        SUBSCRIPTIONTOPIC, 
        /**
         * A homogeneous material with a definite composition.
         */
        SUBSTANCE, 
        /**
         * The detailed description of a substance, typically at a level beyond what is used for prescribing.
         */
        SUBSTANCEDEFINITION, 
        /**
         * Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.
         */
        SUBSTANCENUCLEICACID, 
        /**
         * Properties of a substance specific to it being a polymer.
         */
        SUBSTANCEPOLYMER, 
        /**
         * A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.
         */
        SUBSTANCEPROTEIN, 
        /**
         * Todo.
         */
        SUBSTANCEREFERENCEINFORMATION, 
        /**
         * Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.
         */
        SUBSTANCESOURCEMATERIAL, 
        /**
         * Record of delivery of what is supplied.
         */
        SUPPLYDELIVERY, 
        /**
         * A record of a non-patient specific request for a medication, substance, device, certain types of biologically derived product, and nutrition product used in the healthcare setting.
         */
        SUPPLYREQUEST, 
        /**
         * A task to be performed.
         */
        TASK, 
        /**
         * A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        TERMINOLOGYCAPABILITIES, 
        /**
         * A summary of information based on the results of executing a TestScript.
         */
        TESTREPORT, 
        /**
         * A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.
         */
        TESTSCRIPT, 
        /**
         * Record of transport.
         */
        TRANSPORT, 
        /**
         * A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).
         */
        VALUESET, 
        /**
         * Describes validation requirements, source(s), status and dates for one or more elements.
         */
        VERIFICATIONRESULT, 
        /**
         * An authorization for the provision of glasses and/or contact lenses to a patient.
         */
        VISIONPRESCRIPTION, 
        /**
         * added to help the parsers
         */
        NULL;
        public static AllResourceTypes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Account".equals(codeString))
          return ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return ACTIVITYDEFINITION;
        if ("ActorDefinition".equals(codeString))
          return ACTORDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return APPOINTMENTRESPONSE;
        if ("ArtifactAssessment".equals(codeString))
          return ARTIFACTASSESSMENT;
        if ("AuditEvent".equals(codeString))
          return AUDITEVENT;
        if ("Basic".equals(codeString))
          return BASIC;
        if ("Binary".equals(codeString))
          return BINARY;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return BODYSTRUCTURE;
        if ("Bundle".equals(codeString))
          return BUNDLE;
        if ("CanonicalResource".equals(codeString))
          return CANONICALRESOURCE;
        if ("CapabilityStatement".equals(codeString))
          return CAPABILITYSTATEMENT;
        if ("CarePlan".equals(codeString))
          return CAREPLAN;
        if ("CareTeam".equals(codeString))
          return CARETEAM;
        if ("ChargeItem".equals(codeString))
          return CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return CHARGEITEMDEFINITION;
        if ("Citation".equals(codeString))
          return CITATION;
        if ("Claim".equals(codeString))
          return CLAIM;
        if ("ClaimResponse".equals(codeString))
          return CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return CLINICALIMPRESSION;
        if ("ClinicalUseDefinition".equals(codeString))
          return CLINICALUSEDEFINITION;
        if ("CodeSystem".equals(codeString))
          return CODESYSTEM;
        if ("Communication".equals(codeString))
          return COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return CONCEPTMAP;
        if ("Condition".equals(codeString))
          return CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return CONSENT;
        if ("Contract".equals(codeString))
          return CONTRACT;
        if ("Coverage".equals(codeString))
          return COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return DETECTEDISSUE;
        if ("Device".equals(codeString))
          return DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return DEVICEDEFINITION;
        if ("DeviceDispense".equals(codeString))
          return DEVICEDISPENSE;
        if ("DeviceMetric".equals(codeString))
          return DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return DEVICEREQUEST;
        if ("DeviceUsage".equals(codeString))
          return DEVICEUSAGE;
        if ("DiagnosticReport".equals(codeString))
          return DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return DOCUMENTREFERENCE;
        if ("DomainResource".equals(codeString))
          return DOMAINRESOURCE;
        if ("Encounter".equals(codeString))
          return ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return EVIDENCE;
        if ("EvidenceReport".equals(codeString))
          return EVIDENCEREPORT;
        if ("EvidenceVariable".equals(codeString))
          return EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return FLAG;
        if ("FormularyItem".equals(codeString))
          return FORMULARYITEM;
        if ("GenomicStudy".equals(codeString))
          return GENOMICSTUDY;
        if ("Goal".equals(codeString))
          return GOAL;
        if ("GraphDefinition".equals(codeString))
          return GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return GROUP;
        if ("GuidanceResponse".equals(codeString))
          return GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return HEALTHCARESERVICE;
        if ("ImagingSelection".equals(codeString))
          return IMAGINGSELECTION;
        if ("ImagingStudy".equals(codeString))
          return IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return INSURANCEPLAN;
        if ("InventoryReport".equals(codeString))
          return INVENTORYREPORT;
        if ("Invoice".equals(codeString))
          return INVOICE;
        if ("Library".equals(codeString))
          return LIBRARY;
        if ("Linkage".equals(codeString))
          return LINKAGE;
        if ("List".equals(codeString))
          return LIST;
        if ("Location".equals(codeString))
          return LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return MEASURE;
        if ("MeasureReport".equals(codeString))
          return MEASUREREPORT;
        if ("Medication".equals(codeString))
          return MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return MESSAGEHEADER;
        if ("MetadataResource".equals(codeString))
          return METADATARESOURCE;
        if ("MolecularSequence".equals(codeString))
          return MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return NUTRITIONORDER;
        if ("NutritionProduct".equals(codeString))
          return NUTRITIONPRODUCT;
        if ("Observation".equals(codeString))
          return OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return PACKAGEDPRODUCTDEFINITION;
        if ("Parameters".equals(codeString))
          return PARAMETERS;
        if ("Patient".equals(codeString))
          return PATIENT;
        if ("PaymentNotice".equals(codeString))
          return PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return PAYMENTRECONCILIATION;
        if ("Permission".equals(codeString))
          return PERMISSION;
        if ("Person".equals(codeString))
          return PERSON;
        if ("PlanDefinition".equals(codeString))
          return PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return PROCEDURE;
        if ("Provenance".equals(codeString))
          return PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return RELATEDPERSON;
        if ("RequestOrchestration".equals(codeString))
          return REQUESTORCHESTRATION;
        if ("Requirements".equals(codeString))
          return REQUIREMENTS;
        if ("ResearchStudy".equals(codeString))
          return RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return RESEARCHSUBJECT;
        if ("Resource".equals(codeString))
          return RESOURCE;
        if ("RiskAssessment".equals(codeString))
          return RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return SLOT;
        if ("Specimen".equals(codeString))
          return SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return SUBSCRIPTION;
        if ("SubscriptionStatus".equals(codeString))
          return SUBSCRIPTIONSTATUS;
        if ("SubscriptionTopic".equals(codeString))
          return SUBSCRIPTIONTOPIC;
        if ("Substance".equals(codeString))
          return SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return TESTREPORT;
        if ("TestScript".equals(codeString))
          return TESTSCRIPT;
        if ("Transport".equals(codeString))
          return TRANSPORT;
        if ("ValueSet".equals(codeString))
          return VALUESET;
        if ("VerificationResult".equals(codeString))
          return VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return VISIONPRESCRIPTION;
        throw new FHIRException("Unknown AllResourceTypes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ACTORDEFINITION: return "ActorDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case ARTIFACTASSESSMENT: return "ArtifactAssessment";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CANONICALRESOURCE: return "CanonicalResource";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CITATION: return "Citation";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEDEFINITION: return "ClinicalUseDefinition";
            case CODESYSTEM: return "CodeSystem";
            case COMMUNICATION: return "Communication";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case COMPARTMENTDEFINITION: return "CompartmentDefinition";
            case COMPOSITION: return "Composition";
            case CONCEPTMAP: return "ConceptMap";
            case CONDITION: return "Condition";
            case CONDITIONDEFINITION: return "ConditionDefinition";
            case CONSENT: return "Consent";
            case CONTRACT: return "Contract";
            case COVERAGE: return "Coverage";
            case COVERAGEELIGIBILITYREQUEST: return "CoverageEligibilityRequest";
            case COVERAGEELIGIBILITYRESPONSE: return "CoverageEligibilityResponse";
            case DETECTEDISSUE: return "DetectedIssue";
            case DEVICE: return "Device";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case DEVICEDISPENSE: return "DeviceDispense";
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSAGE: return "DeviceUsage";
            case DIAGNOSTICREPORT: return "DiagnosticReport";
            case DOCUMENTMANIFEST: return "DocumentManifest";
            case DOCUMENTREFERENCE: return "DocumentReference";
            case DOMAINRESOURCE: return "DomainResource";
            case ENCOUNTER: return "Encounter";
            case ENDPOINT: return "Endpoint";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case ENROLLMENTRESPONSE: return "EnrollmentResponse";
            case EPISODEOFCARE: return "EpisodeOfCare";
            case EVENTDEFINITION: return "EventDefinition";
            case EVIDENCE: return "Evidence";
            case EVIDENCEREPORT: return "EvidenceReport";
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case FORMULARYITEM: return "FormularyItem";
            case GENOMICSTUDY: return "GenomicStudy";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSELECTION: return "ImagingSelection";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
            case INVENTORYREPORT: return "InventoryReport";
            case INVOICE: return "Invoice";
            case LIBRARY: return "Library";
            case LINKAGE: return "Linkage";
            case LIST: return "List";
            case LOCATION: return "Location";
            case MANUFACTUREDITEMDEFINITION: return "ManufacturedItemDefinition";
            case MEASURE: return "Measure";
            case MEASUREREPORT: return "MeasureReport";
            case MEDICATION: return "Medication";
            case MEDICATIONADMINISTRATION: return "MedicationAdministration";
            case MEDICATIONDISPENSE: return "MedicationDispense";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case MEDICATIONUSAGE: return "MedicationUsage";
            case MEDICINALPRODUCTDEFINITION: return "MedicinalProductDefinition";
            case MESSAGEDEFINITION: return "MessageDefinition";
            case MESSAGEHEADER: return "MessageHeader";
            case METADATARESOURCE: return "MetadataResource";
            case MOLECULARSEQUENCE: return "MolecularSequence";
            case NAMINGSYSTEM: return "NamingSystem";
            case NUTRITIONINTAKE: return "NutritionIntake";
            case NUTRITIONORDER: return "NutritionOrder";
            case NUTRITIONPRODUCT: return "NutritionProduct";
            case OBSERVATION: return "Observation";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case OPERATIONDEFINITION: return "OperationDefinition";
            case OPERATIONOUTCOME: return "OperationOutcome";
            case ORGANIZATION: return "Organization";
            case ORGANIZATIONAFFILIATION: return "OrganizationAffiliation";
            case PACKAGEDPRODUCTDEFINITION: return "PackagedProductDefinition";
            case PARAMETERS: return "Parameters";
            case PATIENT: return "Patient";
            case PAYMENTNOTICE: return "PaymentNotice";
            case PAYMENTRECONCILIATION: return "PaymentReconciliation";
            case PERMISSION: return "Permission";
            case PERSON: return "Person";
            case PLANDEFINITION: return "PlanDefinition";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case PROCEDURE: return "Procedure";
            case PROVENANCE: return "Provenance";
            case QUESTIONNAIRE: return "Questionnaire";
            case QUESTIONNAIRERESPONSE: return "QuestionnaireResponse";
            case REGULATEDAUTHORIZATION: return "RegulatedAuthorization";
            case RELATEDPERSON: return "RelatedPerson";
            case REQUESTORCHESTRATION: return "RequestOrchestration";
            case REQUIREMENTS: return "Requirements";
            case RESEARCHSTUDY: return "ResearchStudy";
            case RESEARCHSUBJECT: return "ResearchSubject";
            case RESOURCE: return "Resource";
            case RISKASSESSMENT: return "RiskAssessment";
            case SCHEDULE: return "Schedule";
            case SEARCHPARAMETER: return "SearchParameter";
            case SERVICEREQUEST: return "ServiceRequest";
            case SLOT: return "Slot";
            case SPECIMEN: return "Specimen";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case STRUCTUREDEFINITION: return "StructureDefinition";
            case STRUCTUREMAP: return "StructureMap";
            case SUBSCRIPTION: return "Subscription";
            case SUBSCRIPTIONSTATUS: return "SubscriptionStatus";
            case SUBSCRIPTIONTOPIC: return "SubscriptionTopic";
            case SUBSTANCE: return "Substance";
            case SUBSTANCEDEFINITION: return "SubstanceDefinition";
            case SUBSTANCENUCLEICACID: return "SubstanceNucleicAcid";
            case SUBSTANCEPOLYMER: return "SubstancePolymer";
            case SUBSTANCEPROTEIN: return "SubstanceProtein";
            case SUBSTANCEREFERENCEINFORMATION: return "SubstanceReferenceInformation";
            case SUBSTANCESOURCEMATERIAL: return "SubstanceSourceMaterial";
            case SUPPLYDELIVERY: return "SupplyDelivery";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case TERMINOLOGYCAPABILITIES: return "TerminologyCapabilities";
            case TESTREPORT: return "TestReport";
            case TESTSCRIPT: return "TestScript";
            case TRANSPORT: return "Transport";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACCOUNT: return "http://hl7.org/fhir/fhir-types";
            case ACTIVITYDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case ACTORDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case ADMINISTRABLEPRODUCTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case ADVERSEEVENT: return "http://hl7.org/fhir/fhir-types";
            case ALLERGYINTOLERANCE: return "http://hl7.org/fhir/fhir-types";
            case APPOINTMENT: return "http://hl7.org/fhir/fhir-types";
            case APPOINTMENTRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case ARTIFACTASSESSMENT: return "http://hl7.org/fhir/fhir-types";
            case AUDITEVENT: return "http://hl7.org/fhir/fhir-types";
            case BASIC: return "http://hl7.org/fhir/fhir-types";
            case BINARY: return "http://hl7.org/fhir/fhir-types";
            case BIOLOGICALLYDERIVEDPRODUCT: return "http://hl7.org/fhir/fhir-types";
            case BODYSTRUCTURE: return "http://hl7.org/fhir/fhir-types";
            case BUNDLE: return "http://hl7.org/fhir/fhir-types";
            case CANONICALRESOURCE: return "http://hl7.org/fhir/fhir-types";
            case CAPABILITYSTATEMENT: return "http://hl7.org/fhir/fhir-types";
            case CAREPLAN: return "http://hl7.org/fhir/fhir-types";
            case CARETEAM: return "http://hl7.org/fhir/fhir-types";
            case CHARGEITEM: return "http://hl7.org/fhir/fhir-types";
            case CHARGEITEMDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case CITATION: return "http://hl7.org/fhir/fhir-types";
            case CLAIM: return "http://hl7.org/fhir/fhir-types";
            case CLAIMRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case CLINICALIMPRESSION: return "http://hl7.org/fhir/fhir-types";
            case CLINICALUSEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case CODESYSTEM: return "http://hl7.org/fhir/fhir-types";
            case COMMUNICATION: return "http://hl7.org/fhir/fhir-types";
            case COMMUNICATIONREQUEST: return "http://hl7.org/fhir/fhir-types";
            case COMPARTMENTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case COMPOSITION: return "http://hl7.org/fhir/fhir-types";
            case CONCEPTMAP: return "http://hl7.org/fhir/fhir-types";
            case CONDITION: return "http://hl7.org/fhir/fhir-types";
            case CONDITIONDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case CONSENT: return "http://hl7.org/fhir/fhir-types";
            case CONTRACT: return "http://hl7.org/fhir/fhir-types";
            case COVERAGE: return "http://hl7.org/fhir/fhir-types";
            case COVERAGEELIGIBILITYREQUEST: return "http://hl7.org/fhir/fhir-types";
            case COVERAGEELIGIBILITYRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case DETECTEDISSUE: return "http://hl7.org/fhir/fhir-types";
            case DEVICE: return "http://hl7.org/fhir/fhir-types";
            case DEVICEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case DEVICEDISPENSE: return "http://hl7.org/fhir/fhir-types";
            case DEVICEMETRIC: return "http://hl7.org/fhir/fhir-types";
            case DEVICEREQUEST: return "http://hl7.org/fhir/fhir-types";
            case DEVICEUSAGE: return "http://hl7.org/fhir/fhir-types";
            case DIAGNOSTICREPORT: return "http://hl7.org/fhir/fhir-types";
            case DOCUMENTMANIFEST: return "http://hl7.org/fhir/fhir-types";
            case DOCUMENTREFERENCE: return "http://hl7.org/fhir/fhir-types";
            case DOMAINRESOURCE: return "http://hl7.org/fhir/fhir-types";
            case ENCOUNTER: return "http://hl7.org/fhir/fhir-types";
            case ENDPOINT: return "http://hl7.org/fhir/fhir-types";
            case ENROLLMENTREQUEST: return "http://hl7.org/fhir/fhir-types";
            case ENROLLMENTRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case EPISODEOFCARE: return "http://hl7.org/fhir/fhir-types";
            case EVENTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case EVIDENCE: return "http://hl7.org/fhir/fhir-types";
            case EVIDENCEREPORT: return "http://hl7.org/fhir/fhir-types";
            case EVIDENCEVARIABLE: return "http://hl7.org/fhir/fhir-types";
            case EXAMPLESCENARIO: return "http://hl7.org/fhir/fhir-types";
            case EXPLANATIONOFBENEFIT: return "http://hl7.org/fhir/fhir-types";
            case FAMILYMEMBERHISTORY: return "http://hl7.org/fhir/fhir-types";
            case FLAG: return "http://hl7.org/fhir/fhir-types";
            case FORMULARYITEM: return "http://hl7.org/fhir/fhir-types";
            case GENOMICSTUDY: return "http://hl7.org/fhir/fhir-types";
            case GOAL: return "http://hl7.org/fhir/fhir-types";
            case GRAPHDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case GROUP: return "http://hl7.org/fhir/fhir-types";
            case GUIDANCERESPONSE: return "http://hl7.org/fhir/fhir-types";
            case HEALTHCARESERVICE: return "http://hl7.org/fhir/fhir-types";
            case IMAGINGSELECTION: return "http://hl7.org/fhir/fhir-types";
            case IMAGINGSTUDY: return "http://hl7.org/fhir/fhir-types";
            case IMMUNIZATION: return "http://hl7.org/fhir/fhir-types";
            case IMMUNIZATIONEVALUATION: return "http://hl7.org/fhir/fhir-types";
            case IMMUNIZATIONRECOMMENDATION: return "http://hl7.org/fhir/fhir-types";
            case IMPLEMENTATIONGUIDE: return "http://hl7.org/fhir/fhir-types";
            case INGREDIENT: return "http://hl7.org/fhir/fhir-types";
            case INSURANCEPLAN: return "http://hl7.org/fhir/fhir-types";
            case INVENTORYREPORT: return "http://hl7.org/fhir/fhir-types";
            case INVOICE: return "http://hl7.org/fhir/fhir-types";
            case LIBRARY: return "http://hl7.org/fhir/fhir-types";
            case LINKAGE: return "http://hl7.org/fhir/fhir-types";
            case LIST: return "http://hl7.org/fhir/fhir-types";
            case LOCATION: return "http://hl7.org/fhir/fhir-types";
            case MANUFACTUREDITEMDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case MEASURE: return "http://hl7.org/fhir/fhir-types";
            case MEASUREREPORT: return "http://hl7.org/fhir/fhir-types";
            case MEDICATION: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONADMINISTRATION: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONDISPENSE: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONKNOWLEDGE: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONREQUEST: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONUSAGE: return "http://hl7.org/fhir/fhir-types";
            case MEDICINALPRODUCTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case MESSAGEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case MESSAGEHEADER: return "http://hl7.org/fhir/fhir-types";
            case METADATARESOURCE: return "http://hl7.org/fhir/fhir-types";
            case MOLECULARSEQUENCE: return "http://hl7.org/fhir/fhir-types";
            case NAMINGSYSTEM: return "http://hl7.org/fhir/fhir-types";
            case NUTRITIONINTAKE: return "http://hl7.org/fhir/fhir-types";
            case NUTRITIONORDER: return "http://hl7.org/fhir/fhir-types";
            case NUTRITIONPRODUCT: return "http://hl7.org/fhir/fhir-types";
            case OBSERVATION: return "http://hl7.org/fhir/fhir-types";
            case OBSERVATIONDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case OPERATIONDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case OPERATIONOUTCOME: return "http://hl7.org/fhir/fhir-types";
            case ORGANIZATION: return "http://hl7.org/fhir/fhir-types";
            case ORGANIZATIONAFFILIATION: return "http://hl7.org/fhir/fhir-types";
            case PACKAGEDPRODUCTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case PARAMETERS: return "http://hl7.org/fhir/fhir-types";
            case PATIENT: return "http://hl7.org/fhir/fhir-types";
            case PAYMENTNOTICE: return "http://hl7.org/fhir/fhir-types";
            case PAYMENTRECONCILIATION: return "http://hl7.org/fhir/fhir-types";
            case PERMISSION: return "http://hl7.org/fhir/fhir-types";
            case PERSON: return "http://hl7.org/fhir/fhir-types";
            case PLANDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case PRACTITIONER: return "http://hl7.org/fhir/fhir-types";
            case PRACTITIONERROLE: return "http://hl7.org/fhir/fhir-types";
            case PROCEDURE: return "http://hl7.org/fhir/fhir-types";
            case PROVENANCE: return "http://hl7.org/fhir/fhir-types";
            case QUESTIONNAIRE: return "http://hl7.org/fhir/fhir-types";
            case QUESTIONNAIRERESPONSE: return "http://hl7.org/fhir/fhir-types";
            case REGULATEDAUTHORIZATION: return "http://hl7.org/fhir/fhir-types";
            case RELATEDPERSON: return "http://hl7.org/fhir/fhir-types";
            case REQUESTORCHESTRATION: return "http://hl7.org/fhir/fhir-types";
            case REQUIREMENTS: return "http://hl7.org/fhir/fhir-types";
            case RESEARCHSTUDY: return "http://hl7.org/fhir/fhir-types";
            case RESEARCHSUBJECT: return "http://hl7.org/fhir/fhir-types";
            case RESOURCE: return "http://hl7.org/fhir/fhir-types";
            case RISKASSESSMENT: return "http://hl7.org/fhir/fhir-types";
            case SCHEDULE: return "http://hl7.org/fhir/fhir-types";
            case SEARCHPARAMETER: return "http://hl7.org/fhir/fhir-types";
            case SERVICEREQUEST: return "http://hl7.org/fhir/fhir-types";
            case SLOT: return "http://hl7.org/fhir/fhir-types";
            case SPECIMEN: return "http://hl7.org/fhir/fhir-types";
            case SPECIMENDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case STRUCTUREDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case STRUCTUREMAP: return "http://hl7.org/fhir/fhir-types";
            case SUBSCRIPTION: return "http://hl7.org/fhir/fhir-types";
            case SUBSCRIPTIONSTATUS: return "http://hl7.org/fhir/fhir-types";
            case SUBSCRIPTIONTOPIC: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCE: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCENUCLEICACID: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEPOLYMER: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEPROTEIN: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEREFERENCEINFORMATION: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCESOURCEMATERIAL: return "http://hl7.org/fhir/fhir-types";
            case SUPPLYDELIVERY: return "http://hl7.org/fhir/fhir-types";
            case SUPPLYREQUEST: return "http://hl7.org/fhir/fhir-types";
            case TASK: return "http://hl7.org/fhir/fhir-types";
            case TERMINOLOGYCAPABILITIES: return "http://hl7.org/fhir/fhir-types";
            case TESTREPORT: return "http://hl7.org/fhir/fhir-types";
            case TESTSCRIPT: return "http://hl7.org/fhir/fhir-types";
            case TRANSPORT: return "http://hl7.org/fhir/fhir-types";
            case VALUESET: return "http://hl7.org/fhir/fhir-types";
            case VERIFICATIONRESULT: return "http://hl7.org/fhir/fhir-types";
            case VISIONPRESCRIPTION: return "http://hl7.org/fhir/fhir-types";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACCOUNT: return "A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.";
            case ACTIVITYDEFINITION: return "This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.";
            case ACTORDEFINITION: return "The ActorDefinition resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.";
            case ADMINISTRABLEPRODUCTDEFINITION: return "A medicinal product in the final form which is suitable for administering to a patient (after any mixing of multiple components, dissolution etc. has been performed).";
            case ADVERSEEVENT: return "An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject. The unintended effects may require additional monitoring, treatment, hospitalization, or may result in death. The AdverseEvent resource also extends to potential or avoided events that could have had such effects. There are two major domains where the AdverseEvent resource is expected to be used. One is in clinical care reported adverse events and the other is in reporting adverse events in clinical  research trial management. Given the differences between these two arenas, we recommend consulting the domain specific implementation guides when implementing the AdverseEvent Resource. The implementation guides include specific extensions, value sets and constraints.";
            case ALLERGYINTOLERANCE: return "Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.";
            case APPOINTMENT: return "A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).";
            case APPOINTMENTRESPONSE: return "A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.";
            case ARTIFACTASSESSMENT: return "This Resource provides one or more comments, classifiers or ratings about a Resource and supports attribution and rights management metadata for the added content.";
            case AUDITEVENT: return "A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.";
            case BASIC: return "Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.";
            case BINARY: return "A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.";
            case BIOLOGICALLYDERIVEDPRODUCT: return "A biological material originating from a biological entity intended to be transplanted or infused into another (possibly the same) biological entity.";
            case BODYSTRUCTURE: return "Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.";
            case BUNDLE: return "A container for a collection of resources.";
            case CANONICALRESOURCE: return "Common Interface declaration for conformance and knowledge artifact resources.";
            case CAPABILITYSTATEMENT: return "A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server or Client for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case CAREPLAN: return "Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.";
            case CARETEAM: return "The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.";
            case CHARGEITEM: return "The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.";
            case CHARGEITEMDEFINITION: return "The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.";
            case CITATION: return "The Citation Resource enables reference to any knowledge artifact for purposes of identification and attribution. The Citation Resource supports existing reference structures and developing publication practices such as versioning, expressing complex contributorship roles, and referencing computable resources.";
            case CLAIM: return "A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.";
            case CLAIMRESPONSE: return "This resource provides the adjudication details from the processing of a Claim resource.";
            case CLINICALIMPRESSION: return "A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called \"ClinicalImpression\" rather than \"ClinicalAssessment\" to avoid confusion with the recording of assessment tools such as Apgar score.";
            case CLINICALUSEDEFINITION: return "A single issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.";
            case CODESYSTEM: return "The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.";
            case COMMUNICATION: return "A clinical or business level record of information being transmitted or shared; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.";
            case COMMUNICATIONREQUEST: return "A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.";
            case COMPARTMENTDEFINITION: return "A compartment definition that defines how resources are accessed on a server.";
            case COMPOSITION: return "A set of healthcare-related information that is assembled together into a single logical package that provides a single coherent statement of meaning, establishes its own context and that has clinical attestation with regard to who is making the statement. A Composition defines the structure and narrative content necessary for a document. However, a Composition alone does not constitute a document. Rather, the Composition must be the first entry in a Bundle where Bundle.type=document, and any other resources referenced from Composition must be included as subsequent entries in the Bundle (for example Patient, Practitioner, Encounter, etc.).";
            case CONCEPTMAP: return "A statement of relationships from one set of concepts to one or more other concepts - either concepts in code systems, or data element/data element concepts, or classes in class models.";
            case CONDITION: return "A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a level of concern.";
            case CONDITIONDEFINITION: return "A definition of a condition and information relevant to managing it.";
            case CONSENT: return "A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.";
            case CONTRACT: return "Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement.";
            case COVERAGE: return "Financial instrument which may be used to reimburse or pay for health care products and services. Includes both insurance and self-payment.";
            case COVERAGEELIGIBILITYREQUEST: return "The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage is valid and in-force and optionally to provide the insurance details of the policy.";
            case COVERAGEELIGIBILITYRESPONSE: return "This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.";
            case DETECTEDISSUE: return "Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, etc.";
            case DEVICE: return "This resource describes the properties (regulated, has real time clock, etc.), adminstrative (manufacturer name, model number, serial number, firmware, etc), and type (knee replacement, blood pressure cuff, MRI, etc.) of a physical unit (these values do not change much within a given module, for example the serail number, manufacturer name, and model number). An actual unit may consist of several modules in a distinct hierarchy and these are represented by multiple Device resources and bound through the 'parent' element.";
            case DEVICEDEFINITION: return "This is a specialized resource that defines the characteristics and capabilities of a device.";
            case DEVICEDISPENSE: return "Indicates that a device is to be or has been dispensed for a named person/patient.  This includes a description of the product (supply) provided and the instructions for using the device.";
            case DEVICEMETRIC: return "Describes a measurement, calculation or setting capability of a medical device.";
            case DEVICEREQUEST: return "Represents a request a device to be provided to a specific patient. The device may be an implantable device to be subsequently implanted, or an external assistive device, such as a walker, to be delivered and subsequently be used.";
            case DEVICEUSAGE: return "A record of a device being used by a patient where the record is the result of a report from the patient or a clinician.";
            case DIAGNOSTICREPORT: return "The findings and interpretation of diagnostic tests performed on patients, groups of patients, products, substances, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports. The report also includes non-clinical context such as batch analysis and stability reporting of products and substances.";
            case DOCUMENTMANIFEST: return "A collection of documents compiled for a purpose together with metadata that applies to the collection.";
            case DOCUMENTREFERENCE: return "A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this \"document\" encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.";
            case DOMAINRESOURCE: return "A resource that includes narrative, extensions, and contained resources.";
            case ENCOUNTER: return "An interaction between healthcare provider(s), and/or patient(s) for the purpose of providing healthcare service(s) or assessing the health status of patient(s).";
            case ENDPOINT: return "The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b, a REST endpoint for another FHIR server, or a s/Mime email address. This may include any security context information.";
            case ENROLLMENTREQUEST: return "This resource provides the insurance enrollment details to the insurer regarding a specified coverage.";
            case ENROLLMENTRESPONSE: return "This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.";
            case EPISODEOFCARE: return "An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.";
            case EVENTDEFINITION: return "The EventDefinition resource provides a reusable description of when a particular event can occur.";
            case EVIDENCE: return "The Evidence Resource provides a machine-interpretable expression of an evidence concept including the evidence variables (e.g., population, exposures/interventions, comparators, outcomes, measured variables, confounding variables), the statistics, and the certainty of this evidence.";
            case EVIDENCEREPORT: return "The EvidenceReport Resource is a specialized container for a collection of resources and codeable concepts, adapted to support compositions of Evidence, EvidenceVariable, and Citation resources and related concepts.";
            case EVIDENCEVARIABLE: return "The EvidenceVariable resource describes an element that knowledge (Evidence) is about.";
            case EXAMPLESCENARIO: return "A walkthrough of a workflow showing the interaction between systems and the instances shared, possibly including the evolution of instances over time.";
            case EXPLANATIONOFBENEFIT: return "This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.";
            case FAMILYMEMBERHISTORY: return "Significant health conditions for a person related to the patient relevant in the context of care for the patient.";
            case FLAG: return "Prospective warnings of potential issues when providing care to the patient.";
            case FORMULARYITEM: return "This resource describes a product or service that is available through a program and includes the conditions and constraints of availability.  All of the information in this resource is specific to the inclusion of the item in the formulary and is not inherent to the item itself.";
            case GENOMICSTUDY: return "A Genomic Study is a set of analysis performed to analyze and generate genomic data.";
            case GOAL: return "Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.";
            case GRAPHDEFINITION: return "A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.";
            case GROUP: return "Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.";
            case GUIDANCERESPONSE: return "A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.";
            case HEALTHCARESERVICE: return "The details of a healthcare service available at a location or in a catalog.  In the case where there is a hierarchy of services (for example, Lab -> Pathology -> Wound Cultures), this can be represented using a set of linked HealthcareServices.";
            case IMAGINGSELECTION: return "A selection of DICOM SOP instances and/or frames within a single Study and Series. This might include additional specifics such as an image region, an Observation UID or a Segmentation Number, allowing linkage to an Observation Resource or transferring this information along with the ImagingStudy Resource.";
            case IMAGINGSTUDY: return "Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.";
            case IMMUNIZATION: return "Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.";
            case IMMUNIZATIONEVALUATION: return "Describes a comparison of an immunization event against published recommendations to determine if the administration is \"valid\" in relation to those  recommendations.";
            case IMMUNIZATIONRECOMMENDATION: return "A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.";
            case IMPLEMENTATIONGUIDE: return "A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.";
            case INGREDIENT: return "An ingredient of a manufactured item or pharmaceutical product.";
            case INSURANCEPLAN: return "Details of a Health Insurance product/plan provided by an organization.";
            case INVENTORYREPORT: return "A report of inventory or stock items.";
            case INVOICE: return "Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.";
            case LIBRARY: return "The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.";
            case LINKAGE: return "Identifies two or more records (resource instances) that refer to the same real-world \"occurrence\".";
            case LIST: return "A List is a curated collection of resources, for things such as problem lists, allergy lists, facility list, organization list, etc.";
            case LOCATION: return "Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.";
            case MANUFACTUREDITEMDEFINITION: return "The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.";
            case MEASURE: return "The Measure resource provides the definition of a quality measure.";
            case MEASUREREPORT: return "The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.";
            case MEDICATION: return "This resource is primarily used for the identification and definition of a medication, including ingredients, for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.";
            case MEDICATIONADMINISTRATION: return "Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.";
            case MEDICATIONDISPENSE: return "Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.";
            case MEDICATIONKNOWLEDGE: return "Information about a medication that is used to support knowledge.";
            case MEDICATIONREQUEST: return "An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called \"MedicationRequest\" rather than \"MedicationPrescription\" or \"MedicationOrder\" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.";
            case MEDICATIONUSAGE: return "A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. \n\nThe primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.";
            case MEDICINALPRODUCTDEFINITION: return "Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use, drug catalogs, to support prescribing, adverse events management etc.).";
            case MESSAGEDEFINITION: return "Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.";
            case MESSAGEHEADER: return "The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.";
            case METADATARESOURCE: return "Common Interface declaration for conformance and knowledge artifact resources.";
            case MOLECULARSEQUENCE: return "Representation of a molecular sequence.";
            case NAMINGSYSTEM: return "A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a \"System\" used within the Identifier and Coding data types.";
            case NUTRITIONINTAKE: return "A record of food or fluid that is being consumed by a patient.  A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.";
            case NUTRITIONORDER: return "A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.";
            case NUTRITIONPRODUCT: return "A food or supplement that is consumed by patients.";
            case OBSERVATION: return "Measurements and simple assertions made about a patient, device or other subject.";
            case OBSERVATIONDEFINITION: return "Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.";
            case OPERATIONDEFINITION: return "A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).";
            case OPERATIONOUTCOME: return "A collection of error, warning, or information messages that result from a system action.";
            case ORGANIZATION: return "A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.";
            case ORGANIZATIONAFFILIATION: return "Defines an affiliation/assotiation/relationship between 2 distinct organizations, that is not a part-of relationship/sub-division relationship.";
            case PACKAGEDPRODUCTDEFINITION: return "A medically related item or items, in a container or package.";
            case PARAMETERS: return "This resource is used to pass information into and back from an operation (whether invoked directly from REST or within a messaging environment).  It is not persisted or allowed to be referenced by other resources except as described in the definition of the Parameters resource.";
            case PATIENT: return "Demographics and other administrative information about an individual or animal receiving care or other health-related services.";
            case PAYMENTNOTICE: return "This resource provides the status of the payment for goods and services rendered, and the request and response resource references.";
            case PAYMENTRECONCILIATION: return "This resource provides the details including amount of a payment and allocates the payment items being paid.";
            case PERMISSION: return "Permission resource holds access rules for a given data and context.";
            case PERSON: return "Demographics and administrative information about a person independent of a specific health-related context.";
            case PLANDEFINITION: return "This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical and non-clinical artifacts such as clinical decision support rules, order sets, protocols, and drug quality specifications.";
            case PRACTITIONER: return "A person who is directly or indirectly involved in the provisioning of healthcare or related services.";
            case PRACTITIONERROLE: return "A specific set of Roles/Locations/specialties/services that a practitioner may perform, or has performed at an organization during a period of time.";
            case PROCEDURE: return "An action that is or was performed on or for a patient, practitioner, device, organization, or location. For example, this can be a physical intervention on a patient like an operation, or less invasive like long term services, counseling, or hypnotherapy.  This can be a quality or safety inspection for a location, organization, or device.  This can be an accreditation procedure on a practitioner for licensing.";
            case PROVENANCE: return "Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.";
            case QUESTIONNAIRE: return "A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.";
            case QUESTIONNAIRERESPONSE: return "A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.";
            case REGULATEDAUTHORIZATION: return "Regulatory approval, clearance or licencing related to a regulated product, treatment, facility or activity that is cited in a guidance, regulation, rule or legislative act. An example is Market Authorization relating to a Medicinal Product.";
            case RELATEDPERSON: return "Information about a person that is involved in a patient's health or the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.";
            case REQUESTORCHESTRATION: return "A set of related requests that can be used to capture intended activities that have inter-dependencies such as \"give this medication after that one\".";
            case REQUIREMENTS: return "The Requirements resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.";
            case RESEARCHSTUDY: return "A scientific study of nature that sometimes includes processes involved in health and disease. For example, clinical trials are research studies that involve people. These studies may be related to new ways to screen, prevent, diagnose, and treat disease. They may also study certain outcomes and certain groups of people by looking at data collected in the past or future.";
            case RESEARCHSUBJECT: return "A physical entity which is the primary unit of operational and/or administrative interest in a study.";
            case RESOURCE: return "This is the base resource type for everything.";
            case RISKASSESSMENT: return "An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.";
            case SCHEDULE: return "A container for slots of time that may be available for booking appointments.";
            case SEARCHPARAMETER: return "A search parameter that defines a named search item that can be used to search/filter on a resource.";
            case SERVICEREQUEST: return "A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.";
            case SLOT: return "A slot of time on a schedule that may be available for booking appointments.";
            case SPECIMEN: return "A sample to be used for analysis.";
            case SPECIMENDEFINITION: return "A kind of specimen with associated set of requirements.";
            case STRUCTUREDEFINITION: return "A definition of a FHIR structure. This resource is used to describe the underlying resources, data types defined in FHIR, and also for describing extensions and constraints on resources and data types.";
            case STRUCTUREMAP: return "A Map of relationships between 2 structures that can be used to transform data.";
            case SUBSCRIPTION: return "The subscription resource describes a particular client's request to be notified about a SubscriptionTopic.";
            case SUBSCRIPTIONSTATUS: return "The SubscriptionStatus resource describes the state of a Subscription during notifications. It is not persisted.";
            case SUBSCRIPTIONTOPIC: return "Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.";
            case SUBSTANCE: return "A homogeneous material with a definite composition.";
            case SUBSTANCEDEFINITION: return "The detailed description of a substance, typically at a level beyond what is used for prescribing.";
            case SUBSTANCENUCLEICACID: return "Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.";
            case SUBSTANCEPOLYMER: return "Properties of a substance specific to it being a polymer.";
            case SUBSTANCEPROTEIN: return "A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.";
            case SUBSTANCEREFERENCEINFORMATION: return "Todo.";
            case SUBSTANCESOURCEMATERIAL: return "Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.";
            case SUPPLYDELIVERY: return "Record of delivery of what is supplied.";
            case SUPPLYREQUEST: return "A record of a non-patient specific request for a medication, substance, device, certain types of biologically derived product, and nutrition product used in the healthcare setting.";
            case TASK: return "A task to be performed.";
            case TERMINOLOGYCAPABILITIES: return "A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case TESTREPORT: return "A summary of information based on the results of executing a TestScript.";
            case TESTSCRIPT: return "A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.";
            case TRANSPORT: return "Record of transport.";
            case VALUESET: return "A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).";
            case VERIFICATIONRESULT: return "Describes validation requirements, source(s), status and dates for one or more elements.";
            case VISIONPRESCRIPTION: return "An authorization for the provision of glasses and/or contact lenses to a patient.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ACTORDEFINITION: return "ActorDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case ARTIFACTASSESSMENT: return "ArtifactAssessment";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CANONICALRESOURCE: return "CanonicalResource";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CITATION: return "Citation";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEDEFINITION: return "ClinicalUseDefinition";
            case CODESYSTEM: return "CodeSystem";
            case COMMUNICATION: return "Communication";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case COMPARTMENTDEFINITION: return "CompartmentDefinition";
            case COMPOSITION: return "Composition";
            case CONCEPTMAP: return "ConceptMap";
            case CONDITION: return "Condition";
            case CONDITIONDEFINITION: return "ConditionDefinition";
            case CONSENT: return "Consent";
            case CONTRACT: return "Contract";
            case COVERAGE: return "Coverage";
            case COVERAGEELIGIBILITYREQUEST: return "CoverageEligibilityRequest";
            case COVERAGEELIGIBILITYRESPONSE: return "CoverageEligibilityResponse";
            case DETECTEDISSUE: return "DetectedIssue";
            case DEVICE: return "Device";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case DEVICEDISPENSE: return "DeviceDispense";
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSAGE: return "DeviceUsage";
            case DIAGNOSTICREPORT: return "DiagnosticReport";
            case DOCUMENTMANIFEST: return "DocumentManifest";
            case DOCUMENTREFERENCE: return "DocumentReference";
            case DOMAINRESOURCE: return "DomainResource";
            case ENCOUNTER: return "Encounter";
            case ENDPOINT: return "Endpoint";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case ENROLLMENTRESPONSE: return "EnrollmentResponse";
            case EPISODEOFCARE: return "EpisodeOfCare";
            case EVENTDEFINITION: return "EventDefinition";
            case EVIDENCE: return "Evidence";
            case EVIDENCEREPORT: return "EvidenceReport";
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case FORMULARYITEM: return "FormularyItem";
            case GENOMICSTUDY: return "GenomicStudy";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSELECTION: return "ImagingSelection";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
            case INVENTORYREPORT: return "InventoryReport";
            case INVOICE: return "Invoice";
            case LIBRARY: return "Library";
            case LINKAGE: return "Linkage";
            case LIST: return "List";
            case LOCATION: return "Location";
            case MANUFACTUREDITEMDEFINITION: return "ManufacturedItemDefinition";
            case MEASURE: return "Measure";
            case MEASUREREPORT: return "MeasureReport";
            case MEDICATION: return "Medication";
            case MEDICATIONADMINISTRATION: return "MedicationAdministration";
            case MEDICATIONDISPENSE: return "MedicationDispense";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case MEDICATIONUSAGE: return "MedicationUsage";
            case MEDICINALPRODUCTDEFINITION: return "MedicinalProductDefinition";
            case MESSAGEDEFINITION: return "MessageDefinition";
            case MESSAGEHEADER: return "MessageHeader";
            case METADATARESOURCE: return "MetadataResource";
            case MOLECULARSEQUENCE: return "MolecularSequence";
            case NAMINGSYSTEM: return "NamingSystem";
            case NUTRITIONINTAKE: return "NutritionIntake";
            case NUTRITIONORDER: return "NutritionOrder";
            case NUTRITIONPRODUCT: return "NutritionProduct";
            case OBSERVATION: return "Observation";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case OPERATIONDEFINITION: return "OperationDefinition";
            case OPERATIONOUTCOME: return "OperationOutcome";
            case ORGANIZATION: return "Organization";
            case ORGANIZATIONAFFILIATION: return "OrganizationAffiliation";
            case PACKAGEDPRODUCTDEFINITION: return "PackagedProductDefinition";
            case PARAMETERS: return "Parameters";
            case PATIENT: return "Patient";
            case PAYMENTNOTICE: return "PaymentNotice";
            case PAYMENTRECONCILIATION: return "PaymentReconciliation";
            case PERMISSION: return "Permission";
            case PERSON: return "Person";
            case PLANDEFINITION: return "PlanDefinition";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case PROCEDURE: return "Procedure";
            case PROVENANCE: return "Provenance";
            case QUESTIONNAIRE: return "Questionnaire";
            case QUESTIONNAIRERESPONSE: return "QuestionnaireResponse";
            case REGULATEDAUTHORIZATION: return "RegulatedAuthorization";
            case RELATEDPERSON: return "RelatedPerson";
            case REQUESTORCHESTRATION: return "RequestOrchestration";
            case REQUIREMENTS: return "Requirements";
            case RESEARCHSTUDY: return "ResearchStudy";
            case RESEARCHSUBJECT: return "ResearchSubject";
            case RESOURCE: return "Resource";
            case RISKASSESSMENT: return "RiskAssessment";
            case SCHEDULE: return "Schedule";
            case SEARCHPARAMETER: return "SearchParameter";
            case SERVICEREQUEST: return "ServiceRequest";
            case SLOT: return "Slot";
            case SPECIMEN: return "Specimen";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case STRUCTUREDEFINITION: return "StructureDefinition";
            case STRUCTUREMAP: return "StructureMap";
            case SUBSCRIPTION: return "Subscription";
            case SUBSCRIPTIONSTATUS: return "SubscriptionStatus";
            case SUBSCRIPTIONTOPIC: return "SubscriptionTopic";
            case SUBSTANCE: return "Substance";
            case SUBSTANCEDEFINITION: return "SubstanceDefinition";
            case SUBSTANCENUCLEICACID: return "SubstanceNucleicAcid";
            case SUBSTANCEPOLYMER: return "SubstancePolymer";
            case SUBSTANCEPROTEIN: return "SubstanceProtein";
            case SUBSTANCEREFERENCEINFORMATION: return "SubstanceReferenceInformation";
            case SUBSTANCESOURCEMATERIAL: return "SubstanceSourceMaterial";
            case SUPPLYDELIVERY: return "SupplyDelivery";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case TERMINOLOGYCAPABILITIES: return "TerminologyCapabilities";
            case TESTREPORT: return "TestReport";
            case TESTSCRIPT: return "TestScript";
            case TRANSPORT: return "Transport";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class AllResourceTypesEnumFactory implements EnumFactory<AllResourceTypes> {
    public AllResourceTypes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Account".equals(codeString))
          return AllResourceTypes.ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return AllResourceTypes.ACTIVITYDEFINITION;
        if ("ActorDefinition".equals(codeString))
          return AllResourceTypes.ACTORDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return AllResourceTypes.ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return AllResourceTypes.ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return AllResourceTypes.ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return AllResourceTypes.APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return AllResourceTypes.APPOINTMENTRESPONSE;
        if ("ArtifactAssessment".equals(codeString))
          return AllResourceTypes.ARTIFACTASSESSMENT;
        if ("AuditEvent".equals(codeString))
          return AllResourceTypes.AUDITEVENT;
        if ("Basic".equals(codeString))
          return AllResourceTypes.BASIC;
        if ("Binary".equals(codeString))
          return AllResourceTypes.BINARY;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return AllResourceTypes.BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return AllResourceTypes.BODYSTRUCTURE;
        if ("Bundle".equals(codeString))
          return AllResourceTypes.BUNDLE;
        if ("CanonicalResource".equals(codeString))
          return AllResourceTypes.CANONICALRESOURCE;
        if ("CapabilityStatement".equals(codeString))
          return AllResourceTypes.CAPABILITYSTATEMENT;
        if ("CarePlan".equals(codeString))
          return AllResourceTypes.CAREPLAN;
        if ("CareTeam".equals(codeString))
          return AllResourceTypes.CARETEAM;
        if ("ChargeItem".equals(codeString))
          return AllResourceTypes.CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return AllResourceTypes.CHARGEITEMDEFINITION;
        if ("Citation".equals(codeString))
          return AllResourceTypes.CITATION;
        if ("Claim".equals(codeString))
          return AllResourceTypes.CLAIM;
        if ("ClaimResponse".equals(codeString))
          return AllResourceTypes.CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return AllResourceTypes.CLINICALIMPRESSION;
        if ("ClinicalUseDefinition".equals(codeString))
          return AllResourceTypes.CLINICALUSEDEFINITION;
        if ("CodeSystem".equals(codeString))
          return AllResourceTypes.CODESYSTEM;
        if ("Communication".equals(codeString))
          return AllResourceTypes.COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return AllResourceTypes.COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return AllResourceTypes.COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return AllResourceTypes.COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return AllResourceTypes.CONCEPTMAP;
        if ("Condition".equals(codeString))
          return AllResourceTypes.CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return AllResourceTypes.CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return AllResourceTypes.CONSENT;
        if ("Contract".equals(codeString))
          return AllResourceTypes.CONTRACT;
        if ("Coverage".equals(codeString))
          return AllResourceTypes.COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return AllResourceTypes.COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return AllResourceTypes.COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return AllResourceTypes.DETECTEDISSUE;
        if ("Device".equals(codeString))
          return AllResourceTypes.DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return AllResourceTypes.DEVICEDEFINITION;
        if ("DeviceDispense".equals(codeString))
          return AllResourceTypes.DEVICEDISPENSE;
        if ("DeviceMetric".equals(codeString))
          return AllResourceTypes.DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return AllResourceTypes.DEVICEREQUEST;
        if ("DeviceUsage".equals(codeString))
          return AllResourceTypes.DEVICEUSAGE;
        if ("DiagnosticReport".equals(codeString))
          return AllResourceTypes.DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return AllResourceTypes.DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return AllResourceTypes.DOCUMENTREFERENCE;
        if ("DomainResource".equals(codeString))
          return AllResourceTypes.DOMAINRESOURCE;
        if ("Encounter".equals(codeString))
          return AllResourceTypes.ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return AllResourceTypes.ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return AllResourceTypes.ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return AllResourceTypes.ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return AllResourceTypes.EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return AllResourceTypes.EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return AllResourceTypes.EVIDENCE;
        if ("EvidenceReport".equals(codeString))
          return AllResourceTypes.EVIDENCEREPORT;
        if ("EvidenceVariable".equals(codeString))
          return AllResourceTypes.EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return AllResourceTypes.EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return AllResourceTypes.EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return AllResourceTypes.FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return AllResourceTypes.FLAG;
        if ("FormularyItem".equals(codeString))
          return AllResourceTypes.FORMULARYITEM;
        if ("GenomicStudy".equals(codeString))
          return AllResourceTypes.GENOMICSTUDY;
        if ("Goal".equals(codeString))
          return AllResourceTypes.GOAL;
        if ("GraphDefinition".equals(codeString))
          return AllResourceTypes.GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return AllResourceTypes.GROUP;
        if ("GuidanceResponse".equals(codeString))
          return AllResourceTypes.GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return AllResourceTypes.HEALTHCARESERVICE;
        if ("ImagingSelection".equals(codeString))
          return AllResourceTypes.IMAGINGSELECTION;
        if ("ImagingStudy".equals(codeString))
          return AllResourceTypes.IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return AllResourceTypes.IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return AllResourceTypes.IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return AllResourceTypes.IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return AllResourceTypes.IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return AllResourceTypes.INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return AllResourceTypes.INSURANCEPLAN;
        if ("InventoryReport".equals(codeString))
          return AllResourceTypes.INVENTORYREPORT;
        if ("Invoice".equals(codeString))
          return AllResourceTypes.INVOICE;
        if ("Library".equals(codeString))
          return AllResourceTypes.LIBRARY;
        if ("Linkage".equals(codeString))
          return AllResourceTypes.LINKAGE;
        if ("List".equals(codeString))
          return AllResourceTypes.LIST;
        if ("Location".equals(codeString))
          return AllResourceTypes.LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return AllResourceTypes.MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return AllResourceTypes.MEASURE;
        if ("MeasureReport".equals(codeString))
          return AllResourceTypes.MEASUREREPORT;
        if ("Medication".equals(codeString))
          return AllResourceTypes.MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return AllResourceTypes.MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return AllResourceTypes.MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return AllResourceTypes.MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return AllResourceTypes.MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return AllResourceTypes.MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return AllResourceTypes.MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return AllResourceTypes.MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return AllResourceTypes.MESSAGEHEADER;
        if ("MetadataResource".equals(codeString))
          return AllResourceTypes.METADATARESOURCE;
        if ("MolecularSequence".equals(codeString))
          return AllResourceTypes.MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return AllResourceTypes.NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return AllResourceTypes.NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return AllResourceTypes.NUTRITIONORDER;
        if ("NutritionProduct".equals(codeString))
          return AllResourceTypes.NUTRITIONPRODUCT;
        if ("Observation".equals(codeString))
          return AllResourceTypes.OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return AllResourceTypes.OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return AllResourceTypes.OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return AllResourceTypes.OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return AllResourceTypes.ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return AllResourceTypes.ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return AllResourceTypes.PACKAGEDPRODUCTDEFINITION;
        if ("Parameters".equals(codeString))
          return AllResourceTypes.PARAMETERS;
        if ("Patient".equals(codeString))
          return AllResourceTypes.PATIENT;
        if ("PaymentNotice".equals(codeString))
          return AllResourceTypes.PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return AllResourceTypes.PAYMENTRECONCILIATION;
        if ("Permission".equals(codeString))
          return AllResourceTypes.PERMISSION;
        if ("Person".equals(codeString))
          return AllResourceTypes.PERSON;
        if ("PlanDefinition".equals(codeString))
          return AllResourceTypes.PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return AllResourceTypes.PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return AllResourceTypes.PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return AllResourceTypes.PROCEDURE;
        if ("Provenance".equals(codeString))
          return AllResourceTypes.PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return AllResourceTypes.QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return AllResourceTypes.QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return AllResourceTypes.REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return AllResourceTypes.RELATEDPERSON;
        if ("RequestOrchestration".equals(codeString))
          return AllResourceTypes.REQUESTORCHESTRATION;
        if ("Requirements".equals(codeString))
          return AllResourceTypes.REQUIREMENTS;
        if ("ResearchStudy".equals(codeString))
          return AllResourceTypes.RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return AllResourceTypes.RESEARCHSUBJECT;
        if ("Resource".equals(codeString))
          return AllResourceTypes.RESOURCE;
        if ("RiskAssessment".equals(codeString))
          return AllResourceTypes.RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return AllResourceTypes.SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return AllResourceTypes.SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return AllResourceTypes.SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return AllResourceTypes.SLOT;
        if ("Specimen".equals(codeString))
          return AllResourceTypes.SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return AllResourceTypes.SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return AllResourceTypes.STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return AllResourceTypes.STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return AllResourceTypes.SUBSCRIPTION;
        if ("SubscriptionStatus".equals(codeString))
          return AllResourceTypes.SUBSCRIPTIONSTATUS;
        if ("SubscriptionTopic".equals(codeString))
          return AllResourceTypes.SUBSCRIPTIONTOPIC;
        if ("Substance".equals(codeString))
          return AllResourceTypes.SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return AllResourceTypes.SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return AllResourceTypes.SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return AllResourceTypes.SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return AllResourceTypes.SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return AllResourceTypes.SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return AllResourceTypes.SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return AllResourceTypes.SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return AllResourceTypes.SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return AllResourceTypes.TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return AllResourceTypes.TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return AllResourceTypes.TESTREPORT;
        if ("TestScript".equals(codeString))
          return AllResourceTypes.TESTSCRIPT;
        if ("Transport".equals(codeString))
          return AllResourceTypes.TRANSPORT;
        if ("ValueSet".equals(codeString))
          return AllResourceTypes.VALUESET;
        if ("VerificationResult".equals(codeString))
          return AllResourceTypes.VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return AllResourceTypes.VISIONPRESCRIPTION;
        throw new IllegalArgumentException("Unknown AllResourceTypes code '"+codeString+"'");
        }
        public Enumeration<AllResourceTypes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AllResourceTypes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("Account".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ACCOUNT);
        if ("ActivityDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ACTIVITYDEFINITION);
        if ("ActorDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ACTORDEFINITION);
        if ("AdministrableProductDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ADMINISTRABLEPRODUCTDEFINITION);
        if ("AdverseEvent".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ADVERSEEVENT);
        if ("AllergyIntolerance".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ALLERGYINTOLERANCE);
        if ("Appointment".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.APPOINTMENT);
        if ("AppointmentResponse".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.APPOINTMENTRESPONSE);
        if ("ArtifactAssessment".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ARTIFACTASSESSMENT);
        if ("AuditEvent".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.AUDITEVENT);
        if ("Basic".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.BASIC);
        if ("Binary".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.BINARY);
        if ("BiologicallyDerivedProduct".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.BIOLOGICALLYDERIVEDPRODUCT);
        if ("BodyStructure".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.BODYSTRUCTURE);
        if ("Bundle".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.BUNDLE);
        if ("CanonicalResource".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CANONICALRESOURCE);
        if ("CapabilityStatement".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CAPABILITYSTATEMENT);
        if ("CarePlan".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CAREPLAN);
        if ("CareTeam".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CARETEAM);
        if ("ChargeItem".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CHARGEITEM);
        if ("ChargeItemDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CHARGEITEMDEFINITION);
        if ("Citation".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CITATION);
        if ("Claim".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CLAIM);
        if ("ClaimResponse".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CLAIMRESPONSE);
        if ("ClinicalImpression".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CLINICALIMPRESSION);
        if ("ClinicalUseDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CLINICALUSEDEFINITION);
        if ("CodeSystem".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CODESYSTEM);
        if ("Communication".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.COMMUNICATION);
        if ("CommunicationRequest".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.COMMUNICATIONREQUEST);
        if ("CompartmentDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.COMPARTMENTDEFINITION);
        if ("Composition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.COMPOSITION);
        if ("ConceptMap".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CONCEPTMAP);
        if ("Condition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CONDITION);
        if ("ConditionDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CONDITIONDEFINITION);
        if ("Consent".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CONSENT);
        if ("Contract".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.CONTRACT);
        if ("Coverage".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.COVERAGE);
        if ("CoverageEligibilityRequest".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.COVERAGEELIGIBILITYREQUEST);
        if ("CoverageEligibilityResponse".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.COVERAGEELIGIBILITYRESPONSE);
        if ("DetectedIssue".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.DETECTEDISSUE);
        if ("Device".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.DEVICE);
        if ("DeviceDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.DEVICEDEFINITION);
        if ("DeviceDispense".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.DEVICEDISPENSE);
        if ("DeviceMetric".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.DEVICEMETRIC);
        if ("DeviceRequest".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.DEVICEREQUEST);
        if ("DeviceUsage".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.DEVICEUSAGE);
        if ("DiagnosticReport".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.DIAGNOSTICREPORT);
        if ("DocumentManifest".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.DOCUMENTMANIFEST);
        if ("DocumentReference".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.DOCUMENTREFERENCE);
        if ("DomainResource".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.DOMAINRESOURCE);
        if ("Encounter".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ENCOUNTER);
        if ("Endpoint".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ENDPOINT);
        if ("EnrollmentRequest".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ENROLLMENTREQUEST);
        if ("EnrollmentResponse".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ENROLLMENTRESPONSE);
        if ("EpisodeOfCare".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.EPISODEOFCARE);
        if ("EventDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.EVENTDEFINITION);
        if ("Evidence".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.EVIDENCE);
        if ("EvidenceReport".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.EVIDENCEREPORT);
        if ("EvidenceVariable".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.EVIDENCEVARIABLE);
        if ("ExampleScenario".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.EXAMPLESCENARIO);
        if ("ExplanationOfBenefit".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.EXPLANATIONOFBENEFIT);
        if ("FamilyMemberHistory".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.FAMILYMEMBERHISTORY);
        if ("Flag".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.FLAG);
        if ("FormularyItem".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.FORMULARYITEM);
        if ("GenomicStudy".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.GENOMICSTUDY);
        if ("Goal".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.GOAL);
        if ("GraphDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.GRAPHDEFINITION);
        if ("Group".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.GROUP);
        if ("GuidanceResponse".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.GUIDANCERESPONSE);
        if ("HealthcareService".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.HEALTHCARESERVICE);
        if ("ImagingSelection".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.IMAGINGSELECTION);
        if ("ImagingStudy".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.IMAGINGSTUDY);
        if ("Immunization".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.IMMUNIZATION);
        if ("ImmunizationEvaluation".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.IMMUNIZATIONEVALUATION);
        if ("ImmunizationRecommendation".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.IMMUNIZATIONRECOMMENDATION);
        if ("ImplementationGuide".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.IMPLEMENTATIONGUIDE);
        if ("Ingredient".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.INGREDIENT);
        if ("InsurancePlan".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.INSURANCEPLAN);
        if ("InventoryReport".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.INVENTORYREPORT);
        if ("Invoice".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.INVOICE);
        if ("Library".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.LIBRARY);
        if ("Linkage".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.LINKAGE);
        if ("List".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.LIST);
        if ("Location".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.LOCATION);
        if ("ManufacturedItemDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MANUFACTUREDITEMDEFINITION);
        if ("Measure".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MEASURE);
        if ("MeasureReport".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MEASUREREPORT);
        if ("Medication".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MEDICATION);
        if ("MedicationAdministration".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MEDICATIONADMINISTRATION);
        if ("MedicationDispense".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MEDICATIONDISPENSE);
        if ("MedicationKnowledge".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MEDICATIONKNOWLEDGE);
        if ("MedicationRequest".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MEDICATIONREQUEST);
        if ("MedicationUsage".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MEDICATIONUSAGE);
        if ("MedicinalProductDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MEDICINALPRODUCTDEFINITION);
        if ("MessageDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MESSAGEDEFINITION);
        if ("MessageHeader".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MESSAGEHEADER);
        if ("MetadataResource".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.METADATARESOURCE);
        if ("MolecularSequence".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.MOLECULARSEQUENCE);
        if ("NamingSystem".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.NAMINGSYSTEM);
        if ("NutritionIntake".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.NUTRITIONINTAKE);
        if ("NutritionOrder".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.NUTRITIONORDER);
        if ("NutritionProduct".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.NUTRITIONPRODUCT);
        if ("Observation".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.OBSERVATION);
        if ("ObservationDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.OBSERVATIONDEFINITION);
        if ("OperationDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.OPERATIONDEFINITION);
        if ("OperationOutcome".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.OPERATIONOUTCOME);
        if ("Organization".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ORGANIZATION);
        if ("OrganizationAffiliation".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.ORGANIZATIONAFFILIATION);
        if ("PackagedProductDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PACKAGEDPRODUCTDEFINITION);
        if ("Parameters".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PARAMETERS);
        if ("Patient".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PATIENT);
        if ("PaymentNotice".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PAYMENTNOTICE);
        if ("PaymentReconciliation".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PAYMENTRECONCILIATION);
        if ("Permission".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PERMISSION);
        if ("Person".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PERSON);
        if ("PlanDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PLANDEFINITION);
        if ("Practitioner".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PRACTITIONER);
        if ("PractitionerRole".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PRACTITIONERROLE);
        if ("Procedure".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PROCEDURE);
        if ("Provenance".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.PROVENANCE);
        if ("Questionnaire".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.QUESTIONNAIRE);
        if ("QuestionnaireResponse".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.QUESTIONNAIRERESPONSE);
        if ("RegulatedAuthorization".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.REGULATEDAUTHORIZATION);
        if ("RelatedPerson".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.RELATEDPERSON);
        if ("RequestOrchestration".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.REQUESTORCHESTRATION);
        if ("Requirements".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.REQUIREMENTS);
        if ("ResearchStudy".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.RESEARCHSTUDY);
        if ("ResearchSubject".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.RESEARCHSUBJECT);
        if ("Resource".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.RESOURCE);
        if ("RiskAssessment".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.RISKASSESSMENT);
        if ("Schedule".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SCHEDULE);
        if ("SearchParameter".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SEARCHPARAMETER);
        if ("ServiceRequest".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SERVICEREQUEST);
        if ("Slot".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SLOT);
        if ("Specimen".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SPECIMEN);
        if ("SpecimenDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SPECIMENDEFINITION);
        if ("StructureDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.STRUCTUREDEFINITION);
        if ("StructureMap".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.STRUCTUREMAP);
        if ("Subscription".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUBSCRIPTION);
        if ("SubscriptionStatus".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUBSCRIPTIONSTATUS);
        if ("SubscriptionTopic".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUBSCRIPTIONTOPIC);
        if ("Substance".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUBSTANCE);
        if ("SubstanceDefinition".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUBSTANCEDEFINITION);
        if ("SubstanceNucleicAcid".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUBSTANCENUCLEICACID);
        if ("SubstancePolymer".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUBSTANCEPOLYMER);
        if ("SubstanceProtein".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUBSTANCEPROTEIN);
        if ("SubstanceReferenceInformation".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUBSTANCEREFERENCEINFORMATION);
        if ("SubstanceSourceMaterial".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUBSTANCESOURCEMATERIAL);
        if ("SupplyDelivery".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUPPLYDELIVERY);
        if ("SupplyRequest".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.SUPPLYREQUEST);
        if ("Task".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.TASK);
        if ("TerminologyCapabilities".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.TERMINOLOGYCAPABILITIES);
        if ("TestReport".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.TESTREPORT);
        if ("TestScript".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.TESTSCRIPT);
        if ("Transport".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.TRANSPORT);
        if ("ValueSet".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.VALUESET);
        if ("VerificationResult".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.VERIFICATIONRESULT);
        if ("VisionPrescription".equals(codeString))
          return new Enumeration<AllResourceTypes>(this, AllResourceTypes.VISIONPRESCRIPTION);
        throw new FHIRException("Unknown AllResourceTypes code '"+codeString+"'");
        }
    public String toCode(AllResourceTypes code) {
      if (code == AllResourceTypes.ACCOUNT)
        return "Account";
      if (code == AllResourceTypes.ACTIVITYDEFINITION)
        return "ActivityDefinition";
      if (code == AllResourceTypes.ACTORDEFINITION)
        return "ActorDefinition";
      if (code == AllResourceTypes.ADMINISTRABLEPRODUCTDEFINITION)
        return "AdministrableProductDefinition";
      if (code == AllResourceTypes.ADVERSEEVENT)
        return "AdverseEvent";
      if (code == AllResourceTypes.ALLERGYINTOLERANCE)
        return "AllergyIntolerance";
      if (code == AllResourceTypes.APPOINTMENT)
        return "Appointment";
      if (code == AllResourceTypes.APPOINTMENTRESPONSE)
        return "AppointmentResponse";
      if (code == AllResourceTypes.ARTIFACTASSESSMENT)
        return "ArtifactAssessment";
      if (code == AllResourceTypes.AUDITEVENT)
        return "AuditEvent";
      if (code == AllResourceTypes.BASIC)
        return "Basic";
      if (code == AllResourceTypes.BINARY)
        return "Binary";
      if (code == AllResourceTypes.BIOLOGICALLYDERIVEDPRODUCT)
        return "BiologicallyDerivedProduct";
      if (code == AllResourceTypes.BODYSTRUCTURE)
        return "BodyStructure";
      if (code == AllResourceTypes.BUNDLE)
        return "Bundle";
      if (code == AllResourceTypes.CANONICALRESOURCE)
        return "CanonicalResource";
      if (code == AllResourceTypes.CAPABILITYSTATEMENT)
        return "CapabilityStatement";
      if (code == AllResourceTypes.CAREPLAN)
        return "CarePlan";
      if (code == AllResourceTypes.CARETEAM)
        return "CareTeam";
      if (code == AllResourceTypes.CHARGEITEM)
        return "ChargeItem";
      if (code == AllResourceTypes.CHARGEITEMDEFINITION)
        return "ChargeItemDefinition";
      if (code == AllResourceTypes.CITATION)
        return "Citation";
      if (code == AllResourceTypes.CLAIM)
        return "Claim";
      if (code == AllResourceTypes.CLAIMRESPONSE)
        return "ClaimResponse";
      if (code == AllResourceTypes.CLINICALIMPRESSION)
        return "ClinicalImpression";
      if (code == AllResourceTypes.CLINICALUSEDEFINITION)
        return "ClinicalUseDefinition";
      if (code == AllResourceTypes.CODESYSTEM)
        return "CodeSystem";
      if (code == AllResourceTypes.COMMUNICATION)
        return "Communication";
      if (code == AllResourceTypes.COMMUNICATIONREQUEST)
        return "CommunicationRequest";
      if (code == AllResourceTypes.COMPARTMENTDEFINITION)
        return "CompartmentDefinition";
      if (code == AllResourceTypes.COMPOSITION)
        return "Composition";
      if (code == AllResourceTypes.CONCEPTMAP)
        return "ConceptMap";
      if (code == AllResourceTypes.CONDITION)
        return "Condition";
      if (code == AllResourceTypes.CONDITIONDEFINITION)
        return "ConditionDefinition";
      if (code == AllResourceTypes.CONSENT)
        return "Consent";
      if (code == AllResourceTypes.CONTRACT)
        return "Contract";
      if (code == AllResourceTypes.COVERAGE)
        return "Coverage";
      if (code == AllResourceTypes.COVERAGEELIGIBILITYREQUEST)
        return "CoverageEligibilityRequest";
      if (code == AllResourceTypes.COVERAGEELIGIBILITYRESPONSE)
        return "CoverageEligibilityResponse";
      if (code == AllResourceTypes.DETECTEDISSUE)
        return "DetectedIssue";
      if (code == AllResourceTypes.DEVICE)
        return "Device";
      if (code == AllResourceTypes.DEVICEDEFINITION)
        return "DeviceDefinition";
      if (code == AllResourceTypes.DEVICEDISPENSE)
        return "DeviceDispense";
      if (code == AllResourceTypes.DEVICEMETRIC)
        return "DeviceMetric";
      if (code == AllResourceTypes.DEVICEREQUEST)
        return "DeviceRequest";
      if (code == AllResourceTypes.DEVICEUSAGE)
        return "DeviceUsage";
      if (code == AllResourceTypes.DIAGNOSTICREPORT)
        return "DiagnosticReport";
      if (code == AllResourceTypes.DOCUMENTMANIFEST)
        return "DocumentManifest";
      if (code == AllResourceTypes.DOCUMENTREFERENCE)
        return "DocumentReference";
      if (code == AllResourceTypes.DOMAINRESOURCE)
        return "DomainResource";
      if (code == AllResourceTypes.ENCOUNTER)
        return "Encounter";
      if (code == AllResourceTypes.ENDPOINT)
        return "Endpoint";
      if (code == AllResourceTypes.ENROLLMENTREQUEST)
        return "EnrollmentRequest";
      if (code == AllResourceTypes.ENROLLMENTRESPONSE)
        return "EnrollmentResponse";
      if (code == AllResourceTypes.EPISODEOFCARE)
        return "EpisodeOfCare";
      if (code == AllResourceTypes.EVENTDEFINITION)
        return "EventDefinition";
      if (code == AllResourceTypes.EVIDENCE)
        return "Evidence";
      if (code == AllResourceTypes.EVIDENCEREPORT)
        return "EvidenceReport";
      if (code == AllResourceTypes.EVIDENCEVARIABLE)
        return "EvidenceVariable";
      if (code == AllResourceTypes.EXAMPLESCENARIO)
        return "ExampleScenario";
      if (code == AllResourceTypes.EXPLANATIONOFBENEFIT)
        return "ExplanationOfBenefit";
      if (code == AllResourceTypes.FAMILYMEMBERHISTORY)
        return "FamilyMemberHistory";
      if (code == AllResourceTypes.FLAG)
        return "Flag";
      if (code == AllResourceTypes.FORMULARYITEM)
        return "FormularyItem";
      if (code == AllResourceTypes.GENOMICSTUDY)
        return "GenomicStudy";
      if (code == AllResourceTypes.GOAL)
        return "Goal";
      if (code == AllResourceTypes.GRAPHDEFINITION)
        return "GraphDefinition";
      if (code == AllResourceTypes.GROUP)
        return "Group";
      if (code == AllResourceTypes.GUIDANCERESPONSE)
        return "GuidanceResponse";
      if (code == AllResourceTypes.HEALTHCARESERVICE)
        return "HealthcareService";
      if (code == AllResourceTypes.IMAGINGSELECTION)
        return "ImagingSelection";
      if (code == AllResourceTypes.IMAGINGSTUDY)
        return "ImagingStudy";
      if (code == AllResourceTypes.IMMUNIZATION)
        return "Immunization";
      if (code == AllResourceTypes.IMMUNIZATIONEVALUATION)
        return "ImmunizationEvaluation";
      if (code == AllResourceTypes.IMMUNIZATIONRECOMMENDATION)
        return "ImmunizationRecommendation";
      if (code == AllResourceTypes.IMPLEMENTATIONGUIDE)
        return "ImplementationGuide";
      if (code == AllResourceTypes.INGREDIENT)
        return "Ingredient";
      if (code == AllResourceTypes.INSURANCEPLAN)
        return "InsurancePlan";
      if (code == AllResourceTypes.INVENTORYREPORT)
        return "InventoryReport";
      if (code == AllResourceTypes.INVOICE)
        return "Invoice";
      if (code == AllResourceTypes.LIBRARY)
        return "Library";
      if (code == AllResourceTypes.LINKAGE)
        return "Linkage";
      if (code == AllResourceTypes.LIST)
        return "List";
      if (code == AllResourceTypes.LOCATION)
        return "Location";
      if (code == AllResourceTypes.MANUFACTUREDITEMDEFINITION)
        return "ManufacturedItemDefinition";
      if (code == AllResourceTypes.MEASURE)
        return "Measure";
      if (code == AllResourceTypes.MEASUREREPORT)
        return "MeasureReport";
      if (code == AllResourceTypes.MEDICATION)
        return "Medication";
      if (code == AllResourceTypes.MEDICATIONADMINISTRATION)
        return "MedicationAdministration";
      if (code == AllResourceTypes.MEDICATIONDISPENSE)
        return "MedicationDispense";
      if (code == AllResourceTypes.MEDICATIONKNOWLEDGE)
        return "MedicationKnowledge";
      if (code == AllResourceTypes.MEDICATIONREQUEST)
        return "MedicationRequest";
      if (code == AllResourceTypes.MEDICATIONUSAGE)
        return "MedicationUsage";
      if (code == AllResourceTypes.MEDICINALPRODUCTDEFINITION)
        return "MedicinalProductDefinition";
      if (code == AllResourceTypes.MESSAGEDEFINITION)
        return "MessageDefinition";
      if (code == AllResourceTypes.MESSAGEHEADER)
        return "MessageHeader";
      if (code == AllResourceTypes.METADATARESOURCE)
        return "MetadataResource";
      if (code == AllResourceTypes.MOLECULARSEQUENCE)
        return "MolecularSequence";
      if (code == AllResourceTypes.NAMINGSYSTEM)
        return "NamingSystem";
      if (code == AllResourceTypes.NUTRITIONINTAKE)
        return "NutritionIntake";
      if (code == AllResourceTypes.NUTRITIONORDER)
        return "NutritionOrder";
      if (code == AllResourceTypes.NUTRITIONPRODUCT)
        return "NutritionProduct";
      if (code == AllResourceTypes.OBSERVATION)
        return "Observation";
      if (code == AllResourceTypes.OBSERVATIONDEFINITION)
        return "ObservationDefinition";
      if (code == AllResourceTypes.OPERATIONDEFINITION)
        return "OperationDefinition";
      if (code == AllResourceTypes.OPERATIONOUTCOME)
        return "OperationOutcome";
      if (code == AllResourceTypes.ORGANIZATION)
        return "Organization";
      if (code == AllResourceTypes.ORGANIZATIONAFFILIATION)
        return "OrganizationAffiliation";
      if (code == AllResourceTypes.PACKAGEDPRODUCTDEFINITION)
        return "PackagedProductDefinition";
      if (code == AllResourceTypes.PARAMETERS)
        return "Parameters";
      if (code == AllResourceTypes.PATIENT)
        return "Patient";
      if (code == AllResourceTypes.PAYMENTNOTICE)
        return "PaymentNotice";
      if (code == AllResourceTypes.PAYMENTRECONCILIATION)
        return "PaymentReconciliation";
      if (code == AllResourceTypes.PERMISSION)
        return "Permission";
      if (code == AllResourceTypes.PERSON)
        return "Person";
      if (code == AllResourceTypes.PLANDEFINITION)
        return "PlanDefinition";
      if (code == AllResourceTypes.PRACTITIONER)
        return "Practitioner";
      if (code == AllResourceTypes.PRACTITIONERROLE)
        return "PractitionerRole";
      if (code == AllResourceTypes.PROCEDURE)
        return "Procedure";
      if (code == AllResourceTypes.PROVENANCE)
        return "Provenance";
      if (code == AllResourceTypes.QUESTIONNAIRE)
        return "Questionnaire";
      if (code == AllResourceTypes.QUESTIONNAIRERESPONSE)
        return "QuestionnaireResponse";
      if (code == AllResourceTypes.REGULATEDAUTHORIZATION)
        return "RegulatedAuthorization";
      if (code == AllResourceTypes.RELATEDPERSON)
        return "RelatedPerson";
      if (code == AllResourceTypes.REQUESTORCHESTRATION)
        return "RequestOrchestration";
      if (code == AllResourceTypes.REQUIREMENTS)
        return "Requirements";
      if (code == AllResourceTypes.RESEARCHSTUDY)
        return "ResearchStudy";
      if (code == AllResourceTypes.RESEARCHSUBJECT)
        return "ResearchSubject";
      if (code == AllResourceTypes.RESOURCE)
        return "Resource";
      if (code == AllResourceTypes.RISKASSESSMENT)
        return "RiskAssessment";
      if (code == AllResourceTypes.SCHEDULE)
        return "Schedule";
      if (code == AllResourceTypes.SEARCHPARAMETER)
        return "SearchParameter";
      if (code == AllResourceTypes.SERVICEREQUEST)
        return "ServiceRequest";
      if (code == AllResourceTypes.SLOT)
        return "Slot";
      if (code == AllResourceTypes.SPECIMEN)
        return "Specimen";
      if (code == AllResourceTypes.SPECIMENDEFINITION)
        return "SpecimenDefinition";
      if (code == AllResourceTypes.STRUCTUREDEFINITION)
        return "StructureDefinition";
      if (code == AllResourceTypes.STRUCTUREMAP)
        return "StructureMap";
      if (code == AllResourceTypes.SUBSCRIPTION)
        return "Subscription";
      if (code == AllResourceTypes.SUBSCRIPTIONSTATUS)
        return "SubscriptionStatus";
      if (code == AllResourceTypes.SUBSCRIPTIONTOPIC)
        return "SubscriptionTopic";
      if (code == AllResourceTypes.SUBSTANCE)
        return "Substance";
      if (code == AllResourceTypes.SUBSTANCEDEFINITION)
        return "SubstanceDefinition";
      if (code == AllResourceTypes.SUBSTANCENUCLEICACID)
        return "SubstanceNucleicAcid";
      if (code == AllResourceTypes.SUBSTANCEPOLYMER)
        return "SubstancePolymer";
      if (code == AllResourceTypes.SUBSTANCEPROTEIN)
        return "SubstanceProtein";
      if (code == AllResourceTypes.SUBSTANCEREFERENCEINFORMATION)
        return "SubstanceReferenceInformation";
      if (code == AllResourceTypes.SUBSTANCESOURCEMATERIAL)
        return "SubstanceSourceMaterial";
      if (code == AllResourceTypes.SUPPLYDELIVERY)
        return "SupplyDelivery";
      if (code == AllResourceTypes.SUPPLYREQUEST)
        return "SupplyRequest";
      if (code == AllResourceTypes.TASK)
        return "Task";
      if (code == AllResourceTypes.TERMINOLOGYCAPABILITIES)
        return "TerminologyCapabilities";
      if (code == AllResourceTypes.TESTREPORT)
        return "TestReport";
      if (code == AllResourceTypes.TESTSCRIPT)
        return "TestScript";
      if (code == AllResourceTypes.TRANSPORT)
        return "Transport";
      if (code == AllResourceTypes.VALUESET)
        return "ValueSet";
      if (code == AllResourceTypes.VERIFICATIONRESULT)
        return "VerificationResult";
      if (code == AllResourceTypes.VISIONPRESCRIPTION)
        return "VisionPrescription";
      return "?";
      }
    public String toSystem(AllResourceTypes code) {
      return code.getSystem();
      }
    }

    public enum BindingStrength {
        /**
         * To be conformant, the concept in this element SHALL be from the specified value set.
         */
        REQUIRED, 
        /**
         * To be conformant, the concept in this element SHALL be from the specified value set if any of the codes within the value set can apply to the concept being communicated.  If the value set does not cover the concept (based on human review), alternate codings (or, data type allowing, text) may be included instead.
         */
        EXTENSIBLE, 
        /**
         * Instances are encouraged to draw from the specified codes for interoperability purposes but are not required to do so to be considered conformant.
         */
        PREFERRED, 
        /**
         * Instances are not expected or even encouraged to draw from the specified value set.  The value set merely provides examples of the types of concepts intended to be included.
         */
        EXAMPLE, 
        /**
         * added to help the parsers
         */
        NULL;
        public static BindingStrength fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("required".equals(codeString))
          return REQUIRED;
        if ("extensible".equals(codeString))
          return EXTENSIBLE;
        if ("preferred".equals(codeString))
          return PREFERRED;
        if ("example".equals(codeString))
          return EXAMPLE;
        throw new FHIRException("Unknown BindingStrength code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REQUIRED: return "required";
            case EXTENSIBLE: return "extensible";
            case PREFERRED: return "preferred";
            case EXAMPLE: return "example";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REQUIRED: return "http://hl7.org/fhir/binding-strength";
            case EXTENSIBLE: return "http://hl7.org/fhir/binding-strength";
            case PREFERRED: return "http://hl7.org/fhir/binding-strength";
            case EXAMPLE: return "http://hl7.org/fhir/binding-strength";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REQUIRED: return "To be conformant, the concept in this element SHALL be from the specified value set.";
            case EXTENSIBLE: return "To be conformant, the concept in this element SHALL be from the specified value set if any of the codes within the value set can apply to the concept being communicated.  If the value set does not cover the concept (based on human review), alternate codings (or, data type allowing, text) may be included instead.";
            case PREFERRED: return "Instances are encouraged to draw from the specified codes for interoperability purposes but are not required to do so to be considered conformant.";
            case EXAMPLE: return "Instances are not expected or even encouraged to draw from the specified value set.  The value set merely provides examples of the types of concepts intended to be included.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REQUIRED: return "Required";
            case EXTENSIBLE: return "Extensible";
            case PREFERRED: return "Preferred";
            case EXAMPLE: return "Example";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class BindingStrengthEnumFactory implements EnumFactory<BindingStrength> {
    public BindingStrength fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("required".equals(codeString))
          return BindingStrength.REQUIRED;
        if ("extensible".equals(codeString))
          return BindingStrength.EXTENSIBLE;
        if ("preferred".equals(codeString))
          return BindingStrength.PREFERRED;
        if ("example".equals(codeString))
          return BindingStrength.EXAMPLE;
        throw new IllegalArgumentException("Unknown BindingStrength code '"+codeString+"'");
        }
        public Enumeration<BindingStrength> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<BindingStrength>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("required".equals(codeString))
          return new Enumeration<BindingStrength>(this, BindingStrength.REQUIRED);
        if ("extensible".equals(codeString))
          return new Enumeration<BindingStrength>(this, BindingStrength.EXTENSIBLE);
        if ("preferred".equals(codeString))
          return new Enumeration<BindingStrength>(this, BindingStrength.PREFERRED);
        if ("example".equals(codeString))
          return new Enumeration<BindingStrength>(this, BindingStrength.EXAMPLE);
        throw new FHIRException("Unknown BindingStrength code '"+codeString+"'");
        }
    public String toCode(BindingStrength code) {
      if (code == BindingStrength.REQUIRED)
        return "required";
      if (code == BindingStrength.EXTENSIBLE)
        return "extensible";
      if (code == BindingStrength.PREFERRED)
        return "preferred";
      if (code == BindingStrength.EXAMPLE)
        return "example";
      return "?";
      }
    public String toSystem(BindingStrength code) {
      return code.getSystem();
      }
    }

    public enum CapabilityStatementKind {
        /**
         * The CapabilityStatement instance represents the present capabilities of a specific system instance.  This is the kind returned by /metadata for a FHIR server end-point.
         */
        INSTANCE, 
        /**
         * The CapabilityStatement instance represents the capabilities of a system or piece of software, independent of a particular installation.
         */
        CAPABILITY, 
        /**
         * The CapabilityStatement instance represents a set of requirements for other systems to meet; e.g. as part of an implementation guide or 'request for proposal'.
         */
        REQUIREMENTS, 
        /**
         * added to help the parsers
         */
        NULL;
        public static CapabilityStatementKind fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("instance".equals(codeString))
          return INSTANCE;
        if ("capability".equals(codeString))
          return CAPABILITY;
        if ("requirements".equals(codeString))
          return REQUIREMENTS;
        throw new FHIRException("Unknown CapabilityStatementKind code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INSTANCE: return "instance";
            case CAPABILITY: return "capability";
            case REQUIREMENTS: return "requirements";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INSTANCE: return "http://hl7.org/fhir/capability-statement-kind";
            case CAPABILITY: return "http://hl7.org/fhir/capability-statement-kind";
            case REQUIREMENTS: return "http://hl7.org/fhir/capability-statement-kind";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INSTANCE: return "The CapabilityStatement instance represents the present capabilities of a specific system instance.  This is the kind returned by /metadata for a FHIR server end-point.";
            case CAPABILITY: return "The CapabilityStatement instance represents the capabilities of a system or piece of software, independent of a particular installation.";
            case REQUIREMENTS: return "The CapabilityStatement instance represents a set of requirements for other systems to meet; e.g. as part of an implementation guide or 'request for proposal'.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INSTANCE: return "Instance";
            case CAPABILITY: return "Capability";
            case REQUIREMENTS: return "Requirements";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CapabilityStatementKindEnumFactory implements EnumFactory<CapabilityStatementKind> {
    public CapabilityStatementKind fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("instance".equals(codeString))
          return CapabilityStatementKind.INSTANCE;
        if ("capability".equals(codeString))
          return CapabilityStatementKind.CAPABILITY;
        if ("requirements".equals(codeString))
          return CapabilityStatementKind.REQUIREMENTS;
        throw new IllegalArgumentException("Unknown CapabilityStatementKind code '"+codeString+"'");
        }
        public Enumeration<CapabilityStatementKind> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CapabilityStatementKind>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("instance".equals(codeString))
          return new Enumeration<CapabilityStatementKind>(this, CapabilityStatementKind.INSTANCE);
        if ("capability".equals(codeString))
          return new Enumeration<CapabilityStatementKind>(this, CapabilityStatementKind.CAPABILITY);
        if ("requirements".equals(codeString))
          return new Enumeration<CapabilityStatementKind>(this, CapabilityStatementKind.REQUIREMENTS);
        throw new FHIRException("Unknown CapabilityStatementKind code '"+codeString+"'");
        }
    public String toCode(CapabilityStatementKind code) {
      if (code == CapabilityStatementKind.INSTANCE)
        return "instance";
      if (code == CapabilityStatementKind.CAPABILITY)
        return "capability";
      if (code == CapabilityStatementKind.REQUIREMENTS)
        return "requirements";
      return "?";
      }
    public String toSystem(CapabilityStatementKind code) {
      return code.getSystem();
      }
    }

    public enum ClaimProcessingCodes {
        /**
         * The Claim/Pre-authorization/Pre-determination has been received but processing has not begun.
         */
        QUEUED, 
        /**
         * The processing has completed without errors
         */
        COMPLETE, 
        /**
         * One or more errors have been detected in the Claim
         */
        ERROR, 
        /**
         * No errors have been detected in the Claim and some of the adjudication has been performed.
         */
        PARTIAL, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ClaimProcessingCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("queued".equals(codeString))
          return QUEUED;
        if ("complete".equals(codeString))
          return COMPLETE;
        if ("error".equals(codeString))
          return ERROR;
        if ("partial".equals(codeString))
          return PARTIAL;
        throw new FHIRException("Unknown ClaimProcessingCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case QUEUED: return "queued";
            case COMPLETE: return "complete";
            case ERROR: return "error";
            case PARTIAL: return "partial";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case QUEUED: return "http://hl7.org/fhir/claim-outcome";
            case COMPLETE: return "http://hl7.org/fhir/claim-outcome";
            case ERROR: return "http://hl7.org/fhir/claim-outcome";
            case PARTIAL: return "http://hl7.org/fhir/claim-outcome";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case QUEUED: return "The Claim/Pre-authorization/Pre-determination has been received but processing has not begun.";
            case COMPLETE: return "The processing has completed without errors";
            case ERROR: return "One or more errors have been detected in the Claim";
            case PARTIAL: return "No errors have been detected in the Claim and some of the adjudication has been performed.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case QUEUED: return "Queued";
            case COMPLETE: return "Processing Complete";
            case ERROR: return "Error";
            case PARTIAL: return "Partial Processing";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ClaimProcessingCodesEnumFactory implements EnumFactory<ClaimProcessingCodes> {
    public ClaimProcessingCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("queued".equals(codeString))
          return ClaimProcessingCodes.QUEUED;
        if ("complete".equals(codeString))
          return ClaimProcessingCodes.COMPLETE;
        if ("error".equals(codeString))
          return ClaimProcessingCodes.ERROR;
        if ("partial".equals(codeString))
          return ClaimProcessingCodes.PARTIAL;
        throw new IllegalArgumentException("Unknown ClaimProcessingCodes code '"+codeString+"'");
        }
        public Enumeration<ClaimProcessingCodes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ClaimProcessingCodes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("queued".equals(codeString))
          return new Enumeration<ClaimProcessingCodes>(this, ClaimProcessingCodes.QUEUED);
        if ("complete".equals(codeString))
          return new Enumeration<ClaimProcessingCodes>(this, ClaimProcessingCodes.COMPLETE);
        if ("error".equals(codeString))
          return new Enumeration<ClaimProcessingCodes>(this, ClaimProcessingCodes.ERROR);
        if ("partial".equals(codeString))
          return new Enumeration<ClaimProcessingCodes>(this, ClaimProcessingCodes.PARTIAL);
        throw new FHIRException("Unknown ClaimProcessingCodes code '"+codeString+"'");
        }
    public String toCode(ClaimProcessingCodes code) {
      if (code == ClaimProcessingCodes.QUEUED)
        return "queued";
      if (code == ClaimProcessingCodes.COMPLETE)
        return "complete";
      if (code == ClaimProcessingCodes.ERROR)
        return "error";
      if (code == ClaimProcessingCodes.PARTIAL)
        return "partial";
      return "?";
      }
    public String toSystem(ClaimProcessingCodes code) {
      return code.getSystem();
      }
    }

    public enum CompartmentType {
        /**
         * The compartment definition is for the patient compartment.
         */
        PATIENT, 
        /**
         * The compartment definition is for the encounter compartment.
         */
        ENCOUNTER, 
        /**
         * The compartment definition is for the related-person compartment.
         */
        RELATEDPERSON, 
        /**
         * The compartment definition is for the practitioner compartment.
         */
        PRACTITIONER, 
        /**
         * The compartment definition is for the device compartment.
         */
        DEVICE, 
        /**
         * added to help the parsers
         */
        NULL;
        public static CompartmentType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Patient".equals(codeString))
          return PATIENT;
        if ("Encounter".equals(codeString))
          return ENCOUNTER;
        if ("RelatedPerson".equals(codeString))
          return RELATEDPERSON;
        if ("Practitioner".equals(codeString))
          return PRACTITIONER;
        if ("Device".equals(codeString))
          return DEVICE;
        throw new FHIRException("Unknown CompartmentType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PATIENT: return "Patient";
            case ENCOUNTER: return "Encounter";
            case RELATEDPERSON: return "RelatedPerson";
            case PRACTITIONER: return "Practitioner";
            case DEVICE: return "Device";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PATIENT: return "http://hl7.org/fhir/compartment-type";
            case ENCOUNTER: return "http://hl7.org/fhir/compartment-type";
            case RELATEDPERSON: return "http://hl7.org/fhir/compartment-type";
            case PRACTITIONER: return "http://hl7.org/fhir/compartment-type";
            case DEVICE: return "http://hl7.org/fhir/compartment-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PATIENT: return "The compartment definition is for the patient compartment.";
            case ENCOUNTER: return "The compartment definition is for the encounter compartment.";
            case RELATEDPERSON: return "The compartment definition is for the related-person compartment.";
            case PRACTITIONER: return "The compartment definition is for the practitioner compartment.";
            case DEVICE: return "The compartment definition is for the device compartment.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PATIENT: return "Patient";
            case ENCOUNTER: return "Encounter";
            case RELATEDPERSON: return "RelatedPerson";
            case PRACTITIONER: return "Practitioner";
            case DEVICE: return "Device";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CompartmentTypeEnumFactory implements EnumFactory<CompartmentType> {
    public CompartmentType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Patient".equals(codeString))
          return CompartmentType.PATIENT;
        if ("Encounter".equals(codeString))
          return CompartmentType.ENCOUNTER;
        if ("RelatedPerson".equals(codeString))
          return CompartmentType.RELATEDPERSON;
        if ("Practitioner".equals(codeString))
          return CompartmentType.PRACTITIONER;
        if ("Device".equals(codeString))
          return CompartmentType.DEVICE;
        throw new IllegalArgumentException("Unknown CompartmentType code '"+codeString+"'");
        }
        public Enumeration<CompartmentType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CompartmentType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("Patient".equals(codeString))
          return new Enumeration<CompartmentType>(this, CompartmentType.PATIENT);
        if ("Encounter".equals(codeString))
          return new Enumeration<CompartmentType>(this, CompartmentType.ENCOUNTER);
        if ("RelatedPerson".equals(codeString))
          return new Enumeration<CompartmentType>(this, CompartmentType.RELATEDPERSON);
        if ("Practitioner".equals(codeString))
          return new Enumeration<CompartmentType>(this, CompartmentType.PRACTITIONER);
        if ("Device".equals(codeString))
          return new Enumeration<CompartmentType>(this, CompartmentType.DEVICE);
        throw new FHIRException("Unknown CompartmentType code '"+codeString+"'");
        }
    public String toCode(CompartmentType code) {
      if (code == CompartmentType.PATIENT)
        return "Patient";
      if (code == CompartmentType.ENCOUNTER)
        return "Encounter";
      if (code == CompartmentType.RELATEDPERSON)
        return "RelatedPerson";
      if (code == CompartmentType.PRACTITIONER)
        return "Practitioner";
      if (code == CompartmentType.DEVICE)
        return "Device";
      return "?";
      }
    public String toSystem(CompartmentType code) {
      return code.getSystem();
      }
    }

    public enum CompositionStatus {
        /**
         * The existence of the report is registered, but there is nothing yet available.
         */
        REGISTERED, 
        /**
         * This is a partial (e.g. initial, interim or preliminary) report: data in the report may be incomplete or unverified.
         */
        PARTIAL, 
        /**
         * Verified early results are available, but not all results are final.
         */
        PRELIMINARY, 
        /**
         * This version of the composition is complete and verified by an appropriate person and no further work is planned. Any subsequent updates would be on a new version of the composition.
         */
        FINAL, 
        /**
         * The composition content or the referenced resources have been modified (edited or added to) subsequent to being released as "final" and the composition is complete and verified by an authorized person.
         */
        AMENDED, 
        /**
         * Subsequent to being final, the composition content has been modified to correct an error in the report or referenced results.
         */
        CORRECTED, 
        /**
         * Subsequent to being final, the composition content has been modified by adding new content. The existing content is unchanged.
         */
        APPENDED, 
        /**
         * The composition is unavailable because the measurement was not started or not completed (also sometimes called "aborted").
         */
        CANCELLED, 
        /**
         * The composition or document was originally created/issued in error, and this is an amendment that marks that the entire series should not be considered as valid.
         */
        ENTEREDINERROR, 
        /**
         * This composition has been withdrawn or superseded and should no longer be used.
         */
        DEPRECATED, 
        /**
         * The authoring/source system does not know which of the status values currently applies for this observation. Note: This concept is not to be used for "other" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which.
         */
        UNKNOWN, 
        /**
         * added to help the parsers
         */
        NULL;
        public static CompositionStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered".equals(codeString))
          return REGISTERED;
        if ("partial".equals(codeString))
          return PARTIAL;
        if ("preliminary".equals(codeString))
          return PRELIMINARY;
        if ("final".equals(codeString))
          return FINAL;
        if ("amended".equals(codeString))
          return AMENDED;
        if ("corrected".equals(codeString))
          return CORRECTED;
        if ("appended".equals(codeString))
          return APPENDED;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("deprecated".equals(codeString))
          return DEPRECATED;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        throw new FHIRException("Unknown CompositionStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REGISTERED: return "registered";
            case PARTIAL: return "partial";
            case PRELIMINARY: return "preliminary";
            case FINAL: return "final";
            case AMENDED: return "amended";
            case CORRECTED: return "corrected";
            case APPENDED: return "appended";
            case CANCELLED: return "cancelled";
            case ENTEREDINERROR: return "entered-in-error";
            case DEPRECATED: return "deprecated";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REGISTERED: return "http://hl7.org/fhir/composition-status";
            case PARTIAL: return "http://hl7.org/fhir/composition-status";
            case PRELIMINARY: return "http://hl7.org/fhir/composition-status";
            case FINAL: return "http://hl7.org/fhir/composition-status";
            case AMENDED: return "http://hl7.org/fhir/composition-status";
            case CORRECTED: return "http://hl7.org/fhir/composition-status";
            case APPENDED: return "http://hl7.org/fhir/composition-status";
            case CANCELLED: return "http://hl7.org/fhir/composition-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/composition-status";
            case DEPRECATED: return "http://hl7.org/fhir/composition-status";
            case UNKNOWN: return "http://hl7.org/fhir/composition-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REGISTERED: return "The existence of the report is registered, but there is nothing yet available.";
            case PARTIAL: return "This is a partial (e.g. initial, interim or preliminary) report: data in the report may be incomplete or unverified.";
            case PRELIMINARY: return "Verified early results are available, but not all results are final.";
            case FINAL: return "This version of the composition is complete and verified by an appropriate person and no further work is planned. Any subsequent updates would be on a new version of the composition.";
            case AMENDED: return "The composition content or the referenced resources have been modified (edited or added to) subsequent to being released as \"final\" and the composition is complete and verified by an authorized person.";
            case CORRECTED: return "Subsequent to being final, the composition content has been modified to correct an error in the report or referenced results.";
            case APPENDED: return "Subsequent to being final, the composition content has been modified by adding new content. The existing content is unchanged.";
            case CANCELLED: return "The composition is unavailable because the measurement was not started or not completed (also sometimes called \"aborted\").";
            case ENTEREDINERROR: return "The composition or document was originally created/issued in error, and this is an amendment that marks that the entire series should not be considered as valid.";
            case DEPRECATED: return "This composition has been withdrawn or superseded and should no longer be used.";
            case UNKNOWN: return "The authoring/source system does not know which of the status values currently applies for this observation. Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REGISTERED: return "Registered";
            case PARTIAL: return "Partial";
            case PRELIMINARY: return "Preliminary";
            case FINAL: return "Final";
            case AMENDED: return "Amended";
            case CORRECTED: return "Corrected";
            case APPENDED: return "Appended";
            case CANCELLED: return "Cancelled";
            case ENTEREDINERROR: return "Entered in Error";
            case DEPRECATED: return "Deprecated";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CompositionStatusEnumFactory implements EnumFactory<CompositionStatus> {
    public CompositionStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered".equals(codeString))
          return CompositionStatus.REGISTERED;
        if ("partial".equals(codeString))
          return CompositionStatus.PARTIAL;
        if ("preliminary".equals(codeString))
          return CompositionStatus.PRELIMINARY;
        if ("final".equals(codeString))
          return CompositionStatus.FINAL;
        if ("amended".equals(codeString))
          return CompositionStatus.AMENDED;
        if ("corrected".equals(codeString))
          return CompositionStatus.CORRECTED;
        if ("appended".equals(codeString))
          return CompositionStatus.APPENDED;
        if ("cancelled".equals(codeString))
          return CompositionStatus.CANCELLED;
        if ("entered-in-error".equals(codeString))
          return CompositionStatus.ENTEREDINERROR;
        if ("deprecated".equals(codeString))
          return CompositionStatus.DEPRECATED;
        if ("unknown".equals(codeString))
          return CompositionStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown CompositionStatus code '"+codeString+"'");
        }
        public Enumeration<CompositionStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CompositionStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("registered".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.REGISTERED);
        if ("partial".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.PARTIAL);
        if ("preliminary".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.PRELIMINARY);
        if ("final".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.FINAL);
        if ("amended".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.AMENDED);
        if ("corrected".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.CORRECTED);
        if ("appended".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.APPENDED);
        if ("cancelled".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.CANCELLED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.ENTEREDINERROR);
        if ("deprecated".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.DEPRECATED);
        if ("unknown".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.UNKNOWN);
        throw new FHIRException("Unknown CompositionStatus code '"+codeString+"'");
        }
    public String toCode(CompositionStatus code) {
      if (code == CompositionStatus.REGISTERED)
        return "registered";
      if (code == CompositionStatus.PARTIAL)
        return "partial";
      if (code == CompositionStatus.PRELIMINARY)
        return "preliminary";
      if (code == CompositionStatus.FINAL)
        return "final";
      if (code == CompositionStatus.AMENDED)
        return "amended";
      if (code == CompositionStatus.CORRECTED)
        return "corrected";
      if (code == CompositionStatus.APPENDED)
        return "appended";
      if (code == CompositionStatus.CANCELLED)
        return "cancelled";
      if (code == CompositionStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == CompositionStatus.DEPRECATED)
        return "deprecated";
      if (code == CompositionStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(CompositionStatus code) {
      return code.getSystem();
      }
    }

    public enum ConceptMapRelationship {
        /**
         * The concepts are related to each other, but the exact relationship is not known.
         */
        RELATEDTO, 
        /**
         * The definitions of the concepts mean the same thing.
         */
        EQUIVALENT, 
        /**
         * The source concept is narrower in meaning than the target concept.
         */
        SOURCEISNARROWERTHANTARGET, 
        /**
         * The source concept is broader in meaning than the target concept.
         */
        SOURCEISBROADERTHANTARGET, 
        /**
         * This is an explicit assertion that the target concept is not related to the source concept.
         */
        NOTRELATEDTO, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ConceptMapRelationship fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("related-to".equals(codeString))
          return RELATEDTO;
        if ("equivalent".equals(codeString))
          return EQUIVALENT;
        if ("source-is-narrower-than-target".equals(codeString))
          return SOURCEISNARROWERTHANTARGET;
        if ("source-is-broader-than-target".equals(codeString))
          return SOURCEISBROADERTHANTARGET;
        if ("not-related-to".equals(codeString))
          return NOTRELATEDTO;
        throw new FHIRException("Unknown ConceptMapRelationship code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case RELATEDTO: return "related-to";
            case EQUIVALENT: return "equivalent";
            case SOURCEISNARROWERTHANTARGET: return "source-is-narrower-than-target";
            case SOURCEISBROADERTHANTARGET: return "source-is-broader-than-target";
            case NOTRELATEDTO: return "not-related-to";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case RELATEDTO: return "http://hl7.org/fhir/concept-map-relationship";
            case EQUIVALENT: return "http://hl7.org/fhir/concept-map-relationship";
            case SOURCEISNARROWERTHANTARGET: return "http://hl7.org/fhir/concept-map-relationship";
            case SOURCEISBROADERTHANTARGET: return "http://hl7.org/fhir/concept-map-relationship";
            case NOTRELATEDTO: return "http://hl7.org/fhir/concept-map-relationship";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case RELATEDTO: return "The concepts are related to each other, but the exact relationship is not known.";
            case EQUIVALENT: return "The definitions of the concepts mean the same thing.";
            case SOURCEISNARROWERTHANTARGET: return "The source concept is narrower in meaning than the target concept.";
            case SOURCEISBROADERTHANTARGET: return "The source concept is broader in meaning than the target concept.";
            case NOTRELATEDTO: return "This is an explicit assertion that the target concept is not related to the source concept.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case RELATEDTO: return "Related To";
            case EQUIVALENT: return "Equivalent";
            case SOURCEISNARROWERTHANTARGET: return "Source Is Narrower Than Target";
            case SOURCEISBROADERTHANTARGET: return "Source Is Broader Than Target";
            case NOTRELATEDTO: return "Not Related To";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ConceptMapRelationshipEnumFactory implements EnumFactory<ConceptMapRelationship> {
    public ConceptMapRelationship fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("related-to".equals(codeString))
          return ConceptMapRelationship.RELATEDTO;
        if ("equivalent".equals(codeString))
          return ConceptMapRelationship.EQUIVALENT;
        if ("source-is-narrower-than-target".equals(codeString))
          return ConceptMapRelationship.SOURCEISNARROWERTHANTARGET;
        if ("source-is-broader-than-target".equals(codeString))
          return ConceptMapRelationship.SOURCEISBROADERTHANTARGET;
        if ("not-related-to".equals(codeString))
          return ConceptMapRelationship.NOTRELATEDTO;
        throw new IllegalArgumentException("Unknown ConceptMapRelationship code '"+codeString+"'");
        }
        public Enumeration<ConceptMapRelationship> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConceptMapRelationship>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("related-to".equals(codeString))
          return new Enumeration<ConceptMapRelationship>(this, ConceptMapRelationship.RELATEDTO);
        if ("equivalent".equals(codeString))
          return new Enumeration<ConceptMapRelationship>(this, ConceptMapRelationship.EQUIVALENT);
        if ("source-is-narrower-than-target".equals(codeString))
          return new Enumeration<ConceptMapRelationship>(this, ConceptMapRelationship.SOURCEISNARROWERTHANTARGET);
        if ("source-is-broader-than-target".equals(codeString))
          return new Enumeration<ConceptMapRelationship>(this, ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
        if ("not-related-to".equals(codeString))
          return new Enumeration<ConceptMapRelationship>(this, ConceptMapRelationship.NOTRELATEDTO);
        throw new FHIRException("Unknown ConceptMapRelationship code '"+codeString+"'");
        }
    public String toCode(ConceptMapRelationship code) {
      if (code == ConceptMapRelationship.RELATEDTO)
        return "related-to";
      if (code == ConceptMapRelationship.EQUIVALENT)
        return "equivalent";
      if (code == ConceptMapRelationship.SOURCEISNARROWERTHANTARGET)
        return "source-is-narrower-than-target";
      if (code == ConceptMapRelationship.SOURCEISBROADERTHANTARGET)
        return "source-is-broader-than-target";
      if (code == ConceptMapRelationship.NOTRELATEDTO)
        return "not-related-to";
      return "?";
      }
    public String toSystem(ConceptMapRelationship code) {
      return code.getSystem();
      }
    }

    public enum ConsentDataMeaning {
        /**
         * The consent applies directly to the instance of the resource.
         */
        INSTANCE, 
        /**
         * The consent applies directly to the instance of the resource and instances it refers to.
         */
        RELATED, 
        /**
         * The consent applies directly to the instance of the resource and instances that refer to it.
         */
        DEPENDENTS, 
        /**
         * The consent applies to instances of resources that are authored by.
         */
        AUTHOREDBY, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ConsentDataMeaning fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("instance".equals(codeString))
          return INSTANCE;
        if ("related".equals(codeString))
          return RELATED;
        if ("dependents".equals(codeString))
          return DEPENDENTS;
        if ("authoredby".equals(codeString))
          return AUTHOREDBY;
        throw new FHIRException("Unknown ConsentDataMeaning code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INSTANCE: return "instance";
            case RELATED: return "related";
            case DEPENDENTS: return "dependents";
            case AUTHOREDBY: return "authoredby";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INSTANCE: return "http://hl7.org/fhir/consent-data-meaning";
            case RELATED: return "http://hl7.org/fhir/consent-data-meaning";
            case DEPENDENTS: return "http://hl7.org/fhir/consent-data-meaning";
            case AUTHOREDBY: return "http://hl7.org/fhir/consent-data-meaning";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INSTANCE: return "The consent applies directly to the instance of the resource.";
            case RELATED: return "The consent applies directly to the instance of the resource and instances it refers to.";
            case DEPENDENTS: return "The consent applies directly to the instance of the resource and instances that refer to it.";
            case AUTHOREDBY: return "The consent applies to instances of resources that are authored by.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INSTANCE: return "Instance";
            case RELATED: return "Related";
            case DEPENDENTS: return "Dependents";
            case AUTHOREDBY: return "AuthoredBy";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ConsentDataMeaningEnumFactory implements EnumFactory<ConsentDataMeaning> {
    public ConsentDataMeaning fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("instance".equals(codeString))
          return ConsentDataMeaning.INSTANCE;
        if ("related".equals(codeString))
          return ConsentDataMeaning.RELATED;
        if ("dependents".equals(codeString))
          return ConsentDataMeaning.DEPENDENTS;
        if ("authoredby".equals(codeString))
          return ConsentDataMeaning.AUTHOREDBY;
        throw new IllegalArgumentException("Unknown ConsentDataMeaning code '"+codeString+"'");
        }
        public Enumeration<ConsentDataMeaning> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConsentDataMeaning>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("instance".equals(codeString))
          return new Enumeration<ConsentDataMeaning>(this, ConsentDataMeaning.INSTANCE);
        if ("related".equals(codeString))
          return new Enumeration<ConsentDataMeaning>(this, ConsentDataMeaning.RELATED);
        if ("dependents".equals(codeString))
          return new Enumeration<ConsentDataMeaning>(this, ConsentDataMeaning.DEPENDENTS);
        if ("authoredby".equals(codeString))
          return new Enumeration<ConsentDataMeaning>(this, ConsentDataMeaning.AUTHOREDBY);
        throw new FHIRException("Unknown ConsentDataMeaning code '"+codeString+"'");
        }
    public String toCode(ConsentDataMeaning code) {
      if (code == ConsentDataMeaning.INSTANCE)
        return "instance";
      if (code == ConsentDataMeaning.RELATED)
        return "related";
      if (code == ConsentDataMeaning.DEPENDENTS)
        return "dependents";
      if (code == ConsentDataMeaning.AUTHOREDBY)
        return "authoredby";
      return "?";
      }
    public String toSystem(ConsentDataMeaning code) {
      return code.getSystem();
      }
    }

    public enum ConsentProvisionType {
        /**
         * Consent is denied for actions meeting these rules.
         */
        DENY, 
        /**
         * Consent is provided for actions meeting these rules.
         */
        PERMIT, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ConsentProvisionType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("deny".equals(codeString))
          return DENY;
        if ("permit".equals(codeString))
          return PERMIT;
        throw new FHIRException("Unknown ConsentProvisionType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DENY: return "deny";
            case PERMIT: return "permit";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DENY: return "http://hl7.org/fhir/consent-provision-type";
            case PERMIT: return "http://hl7.org/fhir/consent-provision-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DENY: return "Consent is denied for actions meeting these rules.";
            case PERMIT: return "Consent is provided for actions meeting these rules.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DENY: return "Deny";
            case PERMIT: return "Permit";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ConsentProvisionTypeEnumFactory implements EnumFactory<ConsentProvisionType> {
    public ConsentProvisionType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("deny".equals(codeString))
          return ConsentProvisionType.DENY;
        if ("permit".equals(codeString))
          return ConsentProvisionType.PERMIT;
        throw new IllegalArgumentException("Unknown ConsentProvisionType code '"+codeString+"'");
        }
        public Enumeration<ConsentProvisionType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConsentProvisionType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("deny".equals(codeString))
          return new Enumeration<ConsentProvisionType>(this, ConsentProvisionType.DENY);
        if ("permit".equals(codeString))
          return new Enumeration<ConsentProvisionType>(this, ConsentProvisionType.PERMIT);
        throw new FHIRException("Unknown ConsentProvisionType code '"+codeString+"'");
        }
    public String toCode(ConsentProvisionType code) {
      if (code == ConsentProvisionType.DENY)
        return "deny";
      if (code == ConsentProvisionType.PERMIT)
        return "permit";
      return "?";
      }
    public String toSystem(ConsentProvisionType code) {
      return code.getSystem();
      }
    }

    public enum Currencies {
        /**
         * null
         */
        AED, 
        /**
         * null
         */
        AFN, 
        /**
         * null
         */
        ALL, 
        /**
         * null
         */
        AMD, 
        /**
         * null
         */
        ANG, 
        /**
         * null
         */
        AOA, 
        /**
         * null
         */
        ARS, 
        /**
         * null
         */
        AUD, 
        /**
         * null
         */
        AWG, 
        /**
         * null
         */
        AZN, 
        /**
         * null
         */
        BAM, 
        /**
         * null
         */
        BBD, 
        /**
         * null
         */
        BDT, 
        /**
         * null
         */
        BGN, 
        /**
         * null
         */
        BHD, 
        /**
         * null
         */
        BIF, 
        /**
         * null
         */
        BMD, 
        /**
         * null
         */
        BND, 
        /**
         * null
         */
        BOB, 
        /**
         * null
         */
        BOV, 
        /**
         * null
         */
        BRL, 
        /**
         * null
         */
        BSD, 
        /**
         * null
         */
        BTN, 
        /**
         * null
         */
        BWP, 
        /**
         * null
         */
        BYN, 
        /**
         * null
         */
        BZD, 
        /**
         * null
         */
        CAD, 
        /**
         * null
         */
        CDF, 
        /**
         * null
         */
        CHE, 
        /**
         * null
         */
        CHF, 
        /**
         * null
         */
        CHW, 
        /**
         * null
         */
        CLF, 
        /**
         * null
         */
        CLP, 
        /**
         * null
         */
        CNY, 
        /**
         * null
         */
        COP, 
        /**
         * null
         */
        COU, 
        /**
         * null
         */
        CRC, 
        /**
         * null
         */
        CUC, 
        /**
         * null
         */
        CUP, 
        /**
         * null
         */
        CVE, 
        /**
         * null
         */
        CZK, 
        /**
         * null
         */
        DJF, 
        /**
         * null
         */
        DKK, 
        /**
         * null
         */
        DOP, 
        /**
         * null
         */
        DZD, 
        /**
         * null
         */
        EGP, 
        /**
         * null
         */
        ERN, 
        /**
         * null
         */
        ETB, 
        /**
         * null
         */
        EUR, 
        /**
         * null
         */
        FJD, 
        /**
         * null
         */
        FKP, 
        /**
         * null
         */
        GBP, 
        /**
         * null
         */
        GEL, 
        /**
         * null
         */
        GGP, 
        /**
         * null
         */
        GHS, 
        /**
         * null
         */
        GIP, 
        /**
         * null
         */
        GMD, 
        /**
         * null
         */
        GNF, 
        /**
         * null
         */
        GTQ, 
        /**
         * null
         */
        GYD, 
        /**
         * null
         */
        HKD, 
        /**
         * null
         */
        HNL, 
        /**
         * null
         */
        HRK, 
        /**
         * null
         */
        HTG, 
        /**
         * null
         */
        HUF, 
        /**
         * null
         */
        IDR, 
        /**
         * null
         */
        ILS, 
        /**
         * null
         */
        IMP, 
        /**
         * null
         */
        INR, 
        /**
         * null
         */
        IQD, 
        /**
         * null
         */
        IRR, 
        /**
         * null
         */
        ISK, 
        /**
         * null
         */
        JEP, 
        /**
         * null
         */
        JMD, 
        /**
         * null
         */
        JOD, 
        /**
         * null
         */
        JPY, 
        /**
         * null
         */
        KES, 
        /**
         * null
         */
        KGS, 
        /**
         * null
         */
        KHR, 
        /**
         * null
         */
        KMF, 
        /**
         * null
         */
        KPW, 
        /**
         * null
         */
        KRW, 
        /**
         * null
         */
        KWD, 
        /**
         * null
         */
        KYD, 
        /**
         * null
         */
        KZT, 
        /**
         * null
         */
        LAK, 
        /**
         * null
         */
        LBP, 
        /**
         * null
         */
        LKR, 
        /**
         * null
         */
        LRD, 
        /**
         * null
         */
        LSL, 
        /**
         * null
         */
        LYD, 
        /**
         * null
         */
        MAD, 
        /**
         * null
         */
        MDL, 
        /**
         * null
         */
        MGA, 
        /**
         * null
         */
        MKD, 
        /**
         * null
         */
        MMK, 
        /**
         * null
         */
        MNT, 
        /**
         * null
         */
        MOP, 
        /**
         * null
         */
        MRU, 
        /**
         * null
         */
        MUR, 
        /**
         * null
         */
        MVR, 
        /**
         * null
         */
        MWK, 
        /**
         * null
         */
        MXN, 
        /**
         * null
         */
        MXV, 
        /**
         * null
         */
        MYR, 
        /**
         * null
         */
        MZN, 
        /**
         * null
         */
        NAD, 
        /**
         * null
         */
        NGN, 
        /**
         * null
         */
        NIO, 
        /**
         * null
         */
        NOK, 
        /**
         * null
         */
        NPR, 
        /**
         * null
         */
        NZD, 
        /**
         * null
         */
        OMR, 
        /**
         * null
         */
        PAB, 
        /**
         * null
         */
        PEN, 
        /**
         * null
         */
        PGK, 
        /**
         * null
         */
        PHP, 
        /**
         * null
         */
        PKR, 
        /**
         * null
         */
        PLN, 
        /**
         * null
         */
        PYG, 
        /**
         * null
         */
        QAR, 
        /**
         * null
         */
        RON, 
        /**
         * null
         */
        RSD, 
        /**
         * null
         */
        RUB, 
        /**
         * null
         */
        RWF, 
        /**
         * null
         */
        SAR, 
        /**
         * null
         */
        SBD, 
        /**
         * null
         */
        SCR, 
        /**
         * null
         */
        SDG, 
        /**
         * null
         */
        SEK, 
        /**
         * null
         */
        SGD, 
        /**
         * null
         */
        SHP, 
        /**
         * null
         */
        SLL, 
        /**
         * null
         */
        SOS, 
        /**
         * null
         */
        SRD, 
        /**
         * null
         */
        SSP, 
        /**
         * null
         */
        STN, 
        /**
         * null
         */
        SVC, 
        /**
         * null
         */
        SYP, 
        /**
         * null
         */
        SZL, 
        /**
         * null
         */
        THB, 
        /**
         * null
         */
        TJS, 
        /**
         * null
         */
        TMT, 
        /**
         * null
         */
        TND, 
        /**
         * null
         */
        TOP, 
        /**
         * null
         */
        TRY, 
        /**
         * null
         */
        TTD, 
        /**
         * null
         */
        TVD, 
        /**
         * null
         */
        TWD, 
        /**
         * null
         */
        TZS, 
        /**
         * null
         */
        UAH, 
        /**
         * null
         */
        UGX, 
        /**
         * null
         */
        USD, 
        /**
         * null
         */
        USN, 
        /**
         * null
         */
        UYI, 
        /**
         * null
         */
        UYU, 
        /**
         * null
         */
        UZS, 
        /**
         * null
         */
        VEF, 
        /**
         * null
         */
        VND, 
        /**
         * null
         */
        VUV, 
        /**
         * null
         */
        WST, 
        /**
         * null
         */
        XAF, 
        /**
         * null
         */
        XAG, 
        /**
         * null
         */
        XAU, 
        /**
         * null
         */
        XBA, 
        /**
         * null
         */
        XBB, 
        /**
         * null
         */
        XBC, 
        /**
         * null
         */
        XBD, 
        /**
         * null
         */
        XCD, 
        /**
         * null
         */
        XDR, 
        /**
         * null
         */
        XOF, 
        /**
         * null
         */
        XPD, 
        /**
         * null
         */
        XPF, 
        /**
         * null
         */
        XPT, 
        /**
         * null
         */
        XSU, 
        /**
         * null
         */
        XTS, 
        /**
         * null
         */
        XUA, 
        /**
         * null
         */
        XXX, 
        /**
         * null
         */
        YER, 
        /**
         * null
         */
        ZAR, 
        /**
         * null
         */
        ZMW, 
        /**
         * null
         */
        ZWL, 
        /**
         * added to help the parsers
         */
        NULL;
        public static Currencies fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("AED".equals(codeString))
          return AED;
        if ("AFN".equals(codeString))
          return AFN;
        if ("ALL".equals(codeString))
          return ALL;
        if ("AMD".equals(codeString))
          return AMD;
        if ("ANG".equals(codeString))
          return ANG;
        if ("AOA".equals(codeString))
          return AOA;
        if ("ARS".equals(codeString))
          return ARS;
        if ("AUD".equals(codeString))
          return AUD;
        if ("AWG".equals(codeString))
          return AWG;
        if ("AZN".equals(codeString))
          return AZN;
        if ("BAM".equals(codeString))
          return BAM;
        if ("BBD".equals(codeString))
          return BBD;
        if ("BDT".equals(codeString))
          return BDT;
        if ("BGN".equals(codeString))
          return BGN;
        if ("BHD".equals(codeString))
          return BHD;
        if ("BIF".equals(codeString))
          return BIF;
        if ("BMD".equals(codeString))
          return BMD;
        if ("BND".equals(codeString))
          return BND;
        if ("BOB".equals(codeString))
          return BOB;
        if ("BOV".equals(codeString))
          return BOV;
        if ("BRL".equals(codeString))
          return BRL;
        if ("BSD".equals(codeString))
          return BSD;
        if ("BTN".equals(codeString))
          return BTN;
        if ("BWP".equals(codeString))
          return BWP;
        if ("BYN".equals(codeString))
          return BYN;
        if ("BZD".equals(codeString))
          return BZD;
        if ("CAD".equals(codeString))
          return CAD;
        if ("CDF".equals(codeString))
          return CDF;
        if ("CHE".equals(codeString))
          return CHE;
        if ("CHF".equals(codeString))
          return CHF;
        if ("CHW".equals(codeString))
          return CHW;
        if ("CLF".equals(codeString))
          return CLF;
        if ("CLP".equals(codeString))
          return CLP;
        if ("CNY".equals(codeString))
          return CNY;
        if ("COP".equals(codeString))
          return COP;
        if ("COU".equals(codeString))
          return COU;
        if ("CRC".equals(codeString))
          return CRC;
        if ("CUC".equals(codeString))
          return CUC;
        if ("CUP".equals(codeString))
          return CUP;
        if ("CVE".equals(codeString))
          return CVE;
        if ("CZK".equals(codeString))
          return CZK;
        if ("DJF".equals(codeString))
          return DJF;
        if ("DKK".equals(codeString))
          return DKK;
        if ("DOP".equals(codeString))
          return DOP;
        if ("DZD".equals(codeString))
          return DZD;
        if ("EGP".equals(codeString))
          return EGP;
        if ("ERN".equals(codeString))
          return ERN;
        if ("ETB".equals(codeString))
          return ETB;
        if ("EUR".equals(codeString))
          return EUR;
        if ("FJD".equals(codeString))
          return FJD;
        if ("FKP".equals(codeString))
          return FKP;
        if ("GBP".equals(codeString))
          return GBP;
        if ("GEL".equals(codeString))
          return GEL;
        if ("GGP".equals(codeString))
          return GGP;
        if ("GHS".equals(codeString))
          return GHS;
        if ("GIP".equals(codeString))
          return GIP;
        if ("GMD".equals(codeString))
          return GMD;
        if ("GNF".equals(codeString))
          return GNF;
        if ("GTQ".equals(codeString))
          return GTQ;
        if ("GYD".equals(codeString))
          return GYD;
        if ("HKD".equals(codeString))
          return HKD;
        if ("HNL".equals(codeString))
          return HNL;
        if ("HRK".equals(codeString))
          return HRK;
        if ("HTG".equals(codeString))
          return HTG;
        if ("HUF".equals(codeString))
          return HUF;
        if ("IDR".equals(codeString))
          return IDR;
        if ("ILS".equals(codeString))
          return ILS;
        if ("IMP".equals(codeString))
          return IMP;
        if ("INR".equals(codeString))
          return INR;
        if ("IQD".equals(codeString))
          return IQD;
        if ("IRR".equals(codeString))
          return IRR;
        if ("ISK".equals(codeString))
          return ISK;
        if ("JEP".equals(codeString))
          return JEP;
        if ("JMD".equals(codeString))
          return JMD;
        if ("JOD".equals(codeString))
          return JOD;
        if ("JPY".equals(codeString))
          return JPY;
        if ("KES".equals(codeString))
          return KES;
        if ("KGS".equals(codeString))
          return KGS;
        if ("KHR".equals(codeString))
          return KHR;
        if ("KMF".equals(codeString))
          return KMF;
        if ("KPW".equals(codeString))
          return KPW;
        if ("KRW".equals(codeString))
          return KRW;
        if ("KWD".equals(codeString))
          return KWD;
        if ("KYD".equals(codeString))
          return KYD;
        if ("KZT".equals(codeString))
          return KZT;
        if ("LAK".equals(codeString))
          return LAK;
        if ("LBP".equals(codeString))
          return LBP;
        if ("LKR".equals(codeString))
          return LKR;
        if ("LRD".equals(codeString))
          return LRD;
        if ("LSL".equals(codeString))
          return LSL;
        if ("LYD".equals(codeString))
          return LYD;
        if ("MAD".equals(codeString))
          return MAD;
        if ("MDL".equals(codeString))
          return MDL;
        if ("MGA".equals(codeString))
          return MGA;
        if ("MKD".equals(codeString))
          return MKD;
        if ("MMK".equals(codeString))
          return MMK;
        if ("MNT".equals(codeString))
          return MNT;
        if ("MOP".equals(codeString))
          return MOP;
        if ("MRU".equals(codeString))
          return MRU;
        if ("MUR".equals(codeString))
          return MUR;
        if ("MVR".equals(codeString))
          return MVR;
        if ("MWK".equals(codeString))
          return MWK;
        if ("MXN".equals(codeString))
          return MXN;
        if ("MXV".equals(codeString))
          return MXV;
        if ("MYR".equals(codeString))
          return MYR;
        if ("MZN".equals(codeString))
          return MZN;
        if ("NAD".equals(codeString))
          return NAD;
        if ("NGN".equals(codeString))
          return NGN;
        if ("NIO".equals(codeString))
          return NIO;
        if ("NOK".equals(codeString))
          return NOK;
        if ("NPR".equals(codeString))
          return NPR;
        if ("NZD".equals(codeString))
          return NZD;
        if ("OMR".equals(codeString))
          return OMR;
        if ("PAB".equals(codeString))
          return PAB;
        if ("PEN".equals(codeString))
          return PEN;
        if ("PGK".equals(codeString))
          return PGK;
        if ("PHP".equals(codeString))
          return PHP;
        if ("PKR".equals(codeString))
          return PKR;
        if ("PLN".equals(codeString))
          return PLN;
        if ("PYG".equals(codeString))
          return PYG;
        if ("QAR".equals(codeString))
          return QAR;
        if ("RON".equals(codeString))
          return RON;
        if ("RSD".equals(codeString))
          return RSD;
        if ("RUB".equals(codeString))
          return RUB;
        if ("RWF".equals(codeString))
          return RWF;
        if ("SAR".equals(codeString))
          return SAR;
        if ("SBD".equals(codeString))
          return SBD;
        if ("SCR".equals(codeString))
          return SCR;
        if ("SDG".equals(codeString))
          return SDG;
        if ("SEK".equals(codeString))
          return SEK;
        if ("SGD".equals(codeString))
          return SGD;
        if ("SHP".equals(codeString))
          return SHP;
        if ("SLL".equals(codeString))
          return SLL;
        if ("SOS".equals(codeString))
          return SOS;
        if ("SRD".equals(codeString))
          return SRD;
        if ("SSP".equals(codeString))
          return SSP;
        if ("STN".equals(codeString))
          return STN;
        if ("SVC".equals(codeString))
          return SVC;
        if ("SYP".equals(codeString))
          return SYP;
        if ("SZL".equals(codeString))
          return SZL;
        if ("THB".equals(codeString))
          return THB;
        if ("TJS".equals(codeString))
          return TJS;
        if ("TMT".equals(codeString))
          return TMT;
        if ("TND".equals(codeString))
          return TND;
        if ("TOP".equals(codeString))
          return TOP;
        if ("TRY".equals(codeString))
          return TRY;
        if ("TTD".equals(codeString))
          return TTD;
        if ("TVD".equals(codeString))
          return TVD;
        if ("TWD".equals(codeString))
          return TWD;
        if ("TZS".equals(codeString))
          return TZS;
        if ("UAH".equals(codeString))
          return UAH;
        if ("UGX".equals(codeString))
          return UGX;
        if ("USD".equals(codeString))
          return USD;
        if ("USN".equals(codeString))
          return USN;
        if ("UYI".equals(codeString))
          return UYI;
        if ("UYU".equals(codeString))
          return UYU;
        if ("UZS".equals(codeString))
          return UZS;
        if ("VEF".equals(codeString))
          return VEF;
        if ("VND".equals(codeString))
          return VND;
        if ("VUV".equals(codeString))
          return VUV;
        if ("WST".equals(codeString))
          return WST;
        if ("XAF".equals(codeString))
          return XAF;
        if ("XAG".equals(codeString))
          return XAG;
        if ("XAU".equals(codeString))
          return XAU;
        if ("XBA".equals(codeString))
          return XBA;
        if ("XBB".equals(codeString))
          return XBB;
        if ("XBC".equals(codeString))
          return XBC;
        if ("XBD".equals(codeString))
          return XBD;
        if ("XCD".equals(codeString))
          return XCD;
        if ("XDR".equals(codeString))
          return XDR;
        if ("XOF".equals(codeString))
          return XOF;
        if ("XPD".equals(codeString))
          return XPD;
        if ("XPF".equals(codeString))
          return XPF;
        if ("XPT".equals(codeString))
          return XPT;
        if ("XSU".equals(codeString))
          return XSU;
        if ("XTS".equals(codeString))
          return XTS;
        if ("XUA".equals(codeString))
          return XUA;
        if ("XXX".equals(codeString))
          return XXX;
        if ("YER".equals(codeString))
          return YER;
        if ("ZAR".equals(codeString))
          return ZAR;
        if ("ZMW".equals(codeString))
          return ZMW;
        if ("ZWL".equals(codeString))
          return ZWL;
        throw new FHIRException("Unknown Currencies code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case AED: return "AED";
            case AFN: return "AFN";
            case ALL: return "ALL";
            case AMD: return "AMD";
            case ANG: return "ANG";
            case AOA: return "AOA";
            case ARS: return "ARS";
            case AUD: return "AUD";
            case AWG: return "AWG";
            case AZN: return "AZN";
            case BAM: return "BAM";
            case BBD: return "BBD";
            case BDT: return "BDT";
            case BGN: return "BGN";
            case BHD: return "BHD";
            case BIF: return "BIF";
            case BMD: return "BMD";
            case BND: return "BND";
            case BOB: return "BOB";
            case BOV: return "BOV";
            case BRL: return "BRL";
            case BSD: return "BSD";
            case BTN: return "BTN";
            case BWP: return "BWP";
            case BYN: return "BYN";
            case BZD: return "BZD";
            case CAD: return "CAD";
            case CDF: return "CDF";
            case CHE: return "CHE";
            case CHF: return "CHF";
            case CHW: return "CHW";
            case CLF: return "CLF";
            case CLP: return "CLP";
            case CNY: return "CNY";
            case COP: return "COP";
            case COU: return "COU";
            case CRC: return "CRC";
            case CUC: return "CUC";
            case CUP: return "CUP";
            case CVE: return "CVE";
            case CZK: return "CZK";
            case DJF: return "DJF";
            case DKK: return "DKK";
            case DOP: return "DOP";
            case DZD: return "DZD";
            case EGP: return "EGP";
            case ERN: return "ERN";
            case ETB: return "ETB";
            case EUR: return "EUR";
            case FJD: return "FJD";
            case FKP: return "FKP";
            case GBP: return "GBP";
            case GEL: return "GEL";
            case GGP: return "GGP";
            case GHS: return "GHS";
            case GIP: return "GIP";
            case GMD: return "GMD";
            case GNF: return "GNF";
            case GTQ: return "GTQ";
            case GYD: return "GYD";
            case HKD: return "HKD";
            case HNL: return "HNL";
            case HRK: return "HRK";
            case HTG: return "HTG";
            case HUF: return "HUF";
            case IDR: return "IDR";
            case ILS: return "ILS";
            case IMP: return "IMP";
            case INR: return "INR";
            case IQD: return "IQD";
            case IRR: return "IRR";
            case ISK: return "ISK";
            case JEP: return "JEP";
            case JMD: return "JMD";
            case JOD: return "JOD";
            case JPY: return "JPY";
            case KES: return "KES";
            case KGS: return "KGS";
            case KHR: return "KHR";
            case KMF: return "KMF";
            case KPW: return "KPW";
            case KRW: return "KRW";
            case KWD: return "KWD";
            case KYD: return "KYD";
            case KZT: return "KZT";
            case LAK: return "LAK";
            case LBP: return "LBP";
            case LKR: return "LKR";
            case LRD: return "LRD";
            case LSL: return "LSL";
            case LYD: return "LYD";
            case MAD: return "MAD";
            case MDL: return "MDL";
            case MGA: return "MGA";
            case MKD: return "MKD";
            case MMK: return "MMK";
            case MNT: return "MNT";
            case MOP: return "MOP";
            case MRU: return "MRU";
            case MUR: return "MUR";
            case MVR: return "MVR";
            case MWK: return "MWK";
            case MXN: return "MXN";
            case MXV: return "MXV";
            case MYR: return "MYR";
            case MZN: return "MZN";
            case NAD: return "NAD";
            case NGN: return "NGN";
            case NIO: return "NIO";
            case NOK: return "NOK";
            case NPR: return "NPR";
            case NZD: return "NZD";
            case OMR: return "OMR";
            case PAB: return "PAB";
            case PEN: return "PEN";
            case PGK: return "PGK";
            case PHP: return "PHP";
            case PKR: return "PKR";
            case PLN: return "PLN";
            case PYG: return "PYG";
            case QAR: return "QAR";
            case RON: return "RON";
            case RSD: return "RSD";
            case RUB: return "RUB";
            case RWF: return "RWF";
            case SAR: return "SAR";
            case SBD: return "SBD";
            case SCR: return "SCR";
            case SDG: return "SDG";
            case SEK: return "SEK";
            case SGD: return "SGD";
            case SHP: return "SHP";
            case SLL: return "SLL";
            case SOS: return "SOS";
            case SRD: return "SRD";
            case SSP: return "SSP";
            case STN: return "STN";
            case SVC: return "SVC";
            case SYP: return "SYP";
            case SZL: return "SZL";
            case THB: return "THB";
            case TJS: return "TJS";
            case TMT: return "TMT";
            case TND: return "TND";
            case TOP: return "TOP";
            case TRY: return "TRY";
            case TTD: return "TTD";
            case TVD: return "TVD";
            case TWD: return "TWD";
            case TZS: return "TZS";
            case UAH: return "UAH";
            case UGX: return "UGX";
            case USD: return "USD";
            case USN: return "USN";
            case UYI: return "UYI";
            case UYU: return "UYU";
            case UZS: return "UZS";
            case VEF: return "VEF";
            case VND: return "VND";
            case VUV: return "VUV";
            case WST: return "WST";
            case XAF: return "XAF";
            case XAG: return "XAG";
            case XAU: return "XAU";
            case XBA: return "XBA";
            case XBB: return "XBB";
            case XBC: return "XBC";
            case XBD: return "XBD";
            case XCD: return "XCD";
            case XDR: return "XDR";
            case XOF: return "XOF";
            case XPD: return "XPD";
            case XPF: return "XPF";
            case XPT: return "XPT";
            case XSU: return "XSU";
            case XTS: return "XTS";
            case XUA: return "XUA";
            case XXX: return "XXX";
            case YER: return "YER";
            case ZAR: return "ZAR";
            case ZMW: return "ZMW";
            case ZWL: return "ZWL";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case AED: return "urn:iso:std:iso:4217";
            case AFN: return "urn:iso:std:iso:4217";
            case ALL: return "urn:iso:std:iso:4217";
            case AMD: return "urn:iso:std:iso:4217";
            case ANG: return "urn:iso:std:iso:4217";
            case AOA: return "urn:iso:std:iso:4217";
            case ARS: return "urn:iso:std:iso:4217";
            case AUD: return "urn:iso:std:iso:4217";
            case AWG: return "urn:iso:std:iso:4217";
            case AZN: return "urn:iso:std:iso:4217";
            case BAM: return "urn:iso:std:iso:4217";
            case BBD: return "urn:iso:std:iso:4217";
            case BDT: return "urn:iso:std:iso:4217";
            case BGN: return "urn:iso:std:iso:4217";
            case BHD: return "urn:iso:std:iso:4217";
            case BIF: return "urn:iso:std:iso:4217";
            case BMD: return "urn:iso:std:iso:4217";
            case BND: return "urn:iso:std:iso:4217";
            case BOB: return "urn:iso:std:iso:4217";
            case BOV: return "urn:iso:std:iso:4217";
            case BRL: return "urn:iso:std:iso:4217";
            case BSD: return "urn:iso:std:iso:4217";
            case BTN: return "urn:iso:std:iso:4217";
            case BWP: return "urn:iso:std:iso:4217";
            case BYN: return "urn:iso:std:iso:4217";
            case BZD: return "urn:iso:std:iso:4217";
            case CAD: return "urn:iso:std:iso:4217";
            case CDF: return "urn:iso:std:iso:4217";
            case CHE: return "urn:iso:std:iso:4217";
            case CHF: return "urn:iso:std:iso:4217";
            case CHW: return "urn:iso:std:iso:4217";
            case CLF: return "urn:iso:std:iso:4217";
            case CLP: return "urn:iso:std:iso:4217";
            case CNY: return "urn:iso:std:iso:4217";
            case COP: return "urn:iso:std:iso:4217";
            case COU: return "urn:iso:std:iso:4217";
            case CRC: return "urn:iso:std:iso:4217";
            case CUC: return "urn:iso:std:iso:4217";
            case CUP: return "urn:iso:std:iso:4217";
            case CVE: return "urn:iso:std:iso:4217";
            case CZK: return "urn:iso:std:iso:4217";
            case DJF: return "urn:iso:std:iso:4217";
            case DKK: return "urn:iso:std:iso:4217";
            case DOP: return "urn:iso:std:iso:4217";
            case DZD: return "urn:iso:std:iso:4217";
            case EGP: return "urn:iso:std:iso:4217";
            case ERN: return "urn:iso:std:iso:4217";
            case ETB: return "urn:iso:std:iso:4217";
            case EUR: return "urn:iso:std:iso:4217";
            case FJD: return "urn:iso:std:iso:4217";
            case FKP: return "urn:iso:std:iso:4217";
            case GBP: return "urn:iso:std:iso:4217";
            case GEL: return "urn:iso:std:iso:4217";
            case GGP: return "urn:iso:std:iso:4217";
            case GHS: return "urn:iso:std:iso:4217";
            case GIP: return "urn:iso:std:iso:4217";
            case GMD: return "urn:iso:std:iso:4217";
            case GNF: return "urn:iso:std:iso:4217";
            case GTQ: return "urn:iso:std:iso:4217";
            case GYD: return "urn:iso:std:iso:4217";
            case HKD: return "urn:iso:std:iso:4217";
            case HNL: return "urn:iso:std:iso:4217";
            case HRK: return "urn:iso:std:iso:4217";
            case HTG: return "urn:iso:std:iso:4217";
            case HUF: return "urn:iso:std:iso:4217";
            case IDR: return "urn:iso:std:iso:4217";
            case ILS: return "urn:iso:std:iso:4217";
            case IMP: return "urn:iso:std:iso:4217";
            case INR: return "urn:iso:std:iso:4217";
            case IQD: return "urn:iso:std:iso:4217";
            case IRR: return "urn:iso:std:iso:4217";
            case ISK: return "urn:iso:std:iso:4217";
            case JEP: return "urn:iso:std:iso:4217";
            case JMD: return "urn:iso:std:iso:4217";
            case JOD: return "urn:iso:std:iso:4217";
            case JPY: return "urn:iso:std:iso:4217";
            case KES: return "urn:iso:std:iso:4217";
            case KGS: return "urn:iso:std:iso:4217";
            case KHR: return "urn:iso:std:iso:4217";
            case KMF: return "urn:iso:std:iso:4217";
            case KPW: return "urn:iso:std:iso:4217";
            case KRW: return "urn:iso:std:iso:4217";
            case KWD: return "urn:iso:std:iso:4217";
            case KYD: return "urn:iso:std:iso:4217";
            case KZT: return "urn:iso:std:iso:4217";
            case LAK: return "urn:iso:std:iso:4217";
            case LBP: return "urn:iso:std:iso:4217";
            case LKR: return "urn:iso:std:iso:4217";
            case LRD: return "urn:iso:std:iso:4217";
            case LSL: return "urn:iso:std:iso:4217";
            case LYD: return "urn:iso:std:iso:4217";
            case MAD: return "urn:iso:std:iso:4217";
            case MDL: return "urn:iso:std:iso:4217";
            case MGA: return "urn:iso:std:iso:4217";
            case MKD: return "urn:iso:std:iso:4217";
            case MMK: return "urn:iso:std:iso:4217";
            case MNT: return "urn:iso:std:iso:4217";
            case MOP: return "urn:iso:std:iso:4217";
            case MRU: return "urn:iso:std:iso:4217";
            case MUR: return "urn:iso:std:iso:4217";
            case MVR: return "urn:iso:std:iso:4217";
            case MWK: return "urn:iso:std:iso:4217";
            case MXN: return "urn:iso:std:iso:4217";
            case MXV: return "urn:iso:std:iso:4217";
            case MYR: return "urn:iso:std:iso:4217";
            case MZN: return "urn:iso:std:iso:4217";
            case NAD: return "urn:iso:std:iso:4217";
            case NGN: return "urn:iso:std:iso:4217";
            case NIO: return "urn:iso:std:iso:4217";
            case NOK: return "urn:iso:std:iso:4217";
            case NPR: return "urn:iso:std:iso:4217";
            case NZD: return "urn:iso:std:iso:4217";
            case OMR: return "urn:iso:std:iso:4217";
            case PAB: return "urn:iso:std:iso:4217";
            case PEN: return "urn:iso:std:iso:4217";
            case PGK: return "urn:iso:std:iso:4217";
            case PHP: return "urn:iso:std:iso:4217";
            case PKR: return "urn:iso:std:iso:4217";
            case PLN: return "urn:iso:std:iso:4217";
            case PYG: return "urn:iso:std:iso:4217";
            case QAR: return "urn:iso:std:iso:4217";
            case RON: return "urn:iso:std:iso:4217";
            case RSD: return "urn:iso:std:iso:4217";
            case RUB: return "urn:iso:std:iso:4217";
            case RWF: return "urn:iso:std:iso:4217";
            case SAR: return "urn:iso:std:iso:4217";
            case SBD: return "urn:iso:std:iso:4217";
            case SCR: return "urn:iso:std:iso:4217";
            case SDG: return "urn:iso:std:iso:4217";
            case SEK: return "urn:iso:std:iso:4217";
            case SGD: return "urn:iso:std:iso:4217";
            case SHP: return "urn:iso:std:iso:4217";
            case SLL: return "urn:iso:std:iso:4217";
            case SOS: return "urn:iso:std:iso:4217";
            case SRD: return "urn:iso:std:iso:4217";
            case SSP: return "urn:iso:std:iso:4217";
            case STN: return "urn:iso:std:iso:4217";
            case SVC: return "urn:iso:std:iso:4217";
            case SYP: return "urn:iso:std:iso:4217";
            case SZL: return "urn:iso:std:iso:4217";
            case THB: return "urn:iso:std:iso:4217";
            case TJS: return "urn:iso:std:iso:4217";
            case TMT: return "urn:iso:std:iso:4217";
            case TND: return "urn:iso:std:iso:4217";
            case TOP: return "urn:iso:std:iso:4217";
            case TRY: return "urn:iso:std:iso:4217";
            case TTD: return "urn:iso:std:iso:4217";
            case TVD: return "urn:iso:std:iso:4217";
            case TWD: return "urn:iso:std:iso:4217";
            case TZS: return "urn:iso:std:iso:4217";
            case UAH: return "urn:iso:std:iso:4217";
            case UGX: return "urn:iso:std:iso:4217";
            case USD: return "urn:iso:std:iso:4217";
            case USN: return "urn:iso:std:iso:4217";
            case UYI: return "urn:iso:std:iso:4217";
            case UYU: return "urn:iso:std:iso:4217";
            case UZS: return "urn:iso:std:iso:4217";
            case VEF: return "urn:iso:std:iso:4217";
            case VND: return "urn:iso:std:iso:4217";
            case VUV: return "urn:iso:std:iso:4217";
            case WST: return "urn:iso:std:iso:4217";
            case XAF: return "urn:iso:std:iso:4217";
            case XAG: return "urn:iso:std:iso:4217";
            case XAU: return "urn:iso:std:iso:4217";
            case XBA: return "urn:iso:std:iso:4217";
            case XBB: return "urn:iso:std:iso:4217";
            case XBC: return "urn:iso:std:iso:4217";
            case XBD: return "urn:iso:std:iso:4217";
            case XCD: return "urn:iso:std:iso:4217";
            case XDR: return "urn:iso:std:iso:4217";
            case XOF: return "urn:iso:std:iso:4217";
            case XPD: return "urn:iso:std:iso:4217";
            case XPF: return "urn:iso:std:iso:4217";
            case XPT: return "urn:iso:std:iso:4217";
            case XSU: return "urn:iso:std:iso:4217";
            case XTS: return "urn:iso:std:iso:4217";
            case XUA: return "urn:iso:std:iso:4217";
            case XXX: return "urn:iso:std:iso:4217";
            case YER: return "urn:iso:std:iso:4217";
            case ZAR: return "urn:iso:std:iso:4217";
            case ZMW: return "urn:iso:std:iso:4217";
            case ZWL: return "urn:iso:std:iso:4217";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case AED: return "";
            case AFN: return "";
            case ALL: return "";
            case AMD: return "";
            case ANG: return "";
            case AOA: return "";
            case ARS: return "";
            case AUD: return "";
            case AWG: return "";
            case AZN: return "";
            case BAM: return "";
            case BBD: return "";
            case BDT: return "";
            case BGN: return "";
            case BHD: return "";
            case BIF: return "";
            case BMD: return "";
            case BND: return "";
            case BOB: return "";
            case BOV: return "";
            case BRL: return "";
            case BSD: return "";
            case BTN: return "";
            case BWP: return "";
            case BYN: return "";
            case BZD: return "";
            case CAD: return "";
            case CDF: return "";
            case CHE: return "";
            case CHF: return "";
            case CHW: return "";
            case CLF: return "";
            case CLP: return "";
            case CNY: return "";
            case COP: return "";
            case COU: return "";
            case CRC: return "";
            case CUC: return "";
            case CUP: return "";
            case CVE: return "";
            case CZK: return "";
            case DJF: return "";
            case DKK: return "";
            case DOP: return "";
            case DZD: return "";
            case EGP: return "";
            case ERN: return "";
            case ETB: return "";
            case EUR: return "";
            case FJD: return "";
            case FKP: return "";
            case GBP: return "";
            case GEL: return "";
            case GGP: return "";
            case GHS: return "";
            case GIP: return "";
            case GMD: return "";
            case GNF: return "";
            case GTQ: return "";
            case GYD: return "";
            case HKD: return "";
            case HNL: return "";
            case HRK: return "";
            case HTG: return "";
            case HUF: return "";
            case IDR: return "";
            case ILS: return "";
            case IMP: return "";
            case INR: return "";
            case IQD: return "";
            case IRR: return "";
            case ISK: return "";
            case JEP: return "";
            case JMD: return "";
            case JOD: return "";
            case JPY: return "";
            case KES: return "";
            case KGS: return "";
            case KHR: return "";
            case KMF: return "";
            case KPW: return "";
            case KRW: return "";
            case KWD: return "";
            case KYD: return "";
            case KZT: return "";
            case LAK: return "";
            case LBP: return "";
            case LKR: return "";
            case LRD: return "";
            case LSL: return "";
            case LYD: return "";
            case MAD: return "";
            case MDL: return "";
            case MGA: return "";
            case MKD: return "";
            case MMK: return "";
            case MNT: return "";
            case MOP: return "";
            case MRU: return "";
            case MUR: return "";
            case MVR: return "";
            case MWK: return "";
            case MXN: return "";
            case MXV: return "";
            case MYR: return "";
            case MZN: return "";
            case NAD: return "";
            case NGN: return "";
            case NIO: return "";
            case NOK: return "";
            case NPR: return "";
            case NZD: return "";
            case OMR: return "";
            case PAB: return "";
            case PEN: return "";
            case PGK: return "";
            case PHP: return "";
            case PKR: return "";
            case PLN: return "";
            case PYG: return "";
            case QAR: return "";
            case RON: return "";
            case RSD: return "";
            case RUB: return "";
            case RWF: return "";
            case SAR: return "";
            case SBD: return "";
            case SCR: return "";
            case SDG: return "";
            case SEK: return "";
            case SGD: return "";
            case SHP: return "";
            case SLL: return "";
            case SOS: return "";
            case SRD: return "";
            case SSP: return "";
            case STN: return "";
            case SVC: return "";
            case SYP: return "";
            case SZL: return "";
            case THB: return "";
            case TJS: return "";
            case TMT: return "";
            case TND: return "";
            case TOP: return "";
            case TRY: return "";
            case TTD: return "";
            case TVD: return "";
            case TWD: return "";
            case TZS: return "";
            case UAH: return "";
            case UGX: return "";
            case USD: return "";
            case USN: return "";
            case UYI: return "";
            case UYU: return "";
            case UZS: return "";
            case VEF: return "";
            case VND: return "";
            case VUV: return "";
            case WST: return "";
            case XAF: return "";
            case XAG: return "";
            case XAU: return "";
            case XBA: return "";
            case XBB: return "";
            case XBC: return "";
            case XBD: return "";
            case XCD: return "";
            case XDR: return "";
            case XOF: return "";
            case XPD: return "";
            case XPF: return "";
            case XPT: return "";
            case XSU: return "";
            case XTS: return "";
            case XUA: return "";
            case XXX: return "";
            case YER: return "";
            case ZAR: return "";
            case ZMW: return "";
            case ZWL: return "";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case AED: return "United Arab Emirates dirham";
            case AFN: return "Afghan afghani";
            case ALL: return "Albanian lek";
            case AMD: return "Armenian dram";
            case ANG: return "Netherlands Antillean guilder";
            case AOA: return "Angolan kwanza";
            case ARS: return "Argentine peso";
            case AUD: return "Australian dollar";
            case AWG: return "Aruban florin";
            case AZN: return "Azerbaijani manat";
            case BAM: return "Bosnia and Herzegovina convertible mark";
            case BBD: return "Barbados dollar";
            case BDT: return "Bangladeshi taka";
            case BGN: return "Bulgarian lev";
            case BHD: return "Bahraini dinar";
            case BIF: return "Burundian franc";
            case BMD: return "Bermudian dollar";
            case BND: return "Brunei dollar";
            case BOB: return "Boliviano";
            case BOV: return "Bolivian Mvdol (funds code)";
            case BRL: return "Brazilian real";
            case BSD: return "Bahamian dollar";
            case BTN: return "Bhutanese ngultrum";
            case BWP: return "Botswana pula";
            case BYN: return "Belarusian ruble";
            case BZD: return "Belize dollar";
            case CAD: return "Canadian dollar";
            case CDF: return "Congolese franc";
            case CHE: return "WIR Euro (complementary currency)";
            case CHF: return "Swiss franc";
            case CHW: return "WIR Franc (complementary currency)";
            case CLF: return "Unidad de Fomento (funds code)";
            case CLP: return "Chilean peso";
            case CNY: return "Renminbi (Chinese) yuan[8]";
            case COP: return "Colombian peso";
            case COU: return "Unidad de Valor Real (UVR) (funds code)[9]";
            case CRC: return "Costa Rican colon";
            case CUC: return "Cuban convertible peso";
            case CUP: return "Cuban peso";
            case CVE: return "Cape Verde escudo";
            case CZK: return "Czech koruna";
            case DJF: return "Djiboutian franc";
            case DKK: return "Danish krone";
            case DOP: return "Dominican peso";
            case DZD: return "Algerian dinar";
            case EGP: return "Egyptian pound";
            case ERN: return "Eritrean nakfa";
            case ETB: return "Ethiopian birr";
            case EUR: return "Euro";
            case FJD: return "Fiji dollar";
            case FKP: return "Falkland Islands pound";
            case GBP: return "Pound sterling";
            case GEL: return "Georgian lari";
            case GGP: return "Guernsey Pound";
            case GHS: return "Ghanaian cedi";
            case GIP: return "Gibraltar pound";
            case GMD: return "Gambian dalasi";
            case GNF: return "Guinean franc";
            case GTQ: return "Guatemalan quetzal";
            case GYD: return "Guyanese dollar";
            case HKD: return "Hong Kong dollar";
            case HNL: return "Honduran lempira";
            case HRK: return "Croatian kuna";
            case HTG: return "Haitian gourde";
            case HUF: return "Hungarian forint";
            case IDR: return "Indonesian rupiah";
            case ILS: return "Israeli new shekel";
            case IMP: return "Isle of Man Pound";
            case INR: return "Indian rupee";
            case IQD: return "Iraqi dinar";
            case IRR: return "Iranian rial";
            case ISK: return "Icelandic króna";
            case JEP: return "Jersey Pound";
            case JMD: return "Jamaican dollar";
            case JOD: return "Jordanian dinar";
            case JPY: return "Japanese yen";
            case KES: return "Kenyan shilling";
            case KGS: return "Kyrgyzstani som";
            case KHR: return "Cambodian riel";
            case KMF: return "Comoro franc";
            case KPW: return "North Korean won";
            case KRW: return "South Korean won";
            case KWD: return "Kuwaiti dinar";
            case KYD: return "Cayman Islands dollar";
            case KZT: return "Kazakhstani tenge";
            case LAK: return "Lao kip";
            case LBP: return "Lebanese pound";
            case LKR: return "Sri Lankan rupee";
            case LRD: return "Liberian dollar";
            case LSL: return "Lesotho loti";
            case LYD: return "Libyan dinar";
            case MAD: return "Moroccan dirham";
            case MDL: return "Moldovan leu";
            case MGA: return "Malagasy ariary";
            case MKD: return "Macedonian denar";
            case MMK: return "Myanmar kyat";
            case MNT: return "Mongolian tögrög";
            case MOP: return "Macanese pataca";
            case MRU: return "Mauritanian ouguiya";
            case MUR: return "Mauritian rupee";
            case MVR: return "Maldivian rufiyaa";
            case MWK: return "Malawian kwacha";
            case MXN: return "Mexican peso";
            case MXV: return "Mexican Unidad de Inversion (UDI) (funds code)";
            case MYR: return "Malaysian ringgit";
            case MZN: return "Mozambican metical";
            case NAD: return "Namibian dollar";
            case NGN: return "Nigerian naira";
            case NIO: return "Nicaraguan córdoba";
            case NOK: return "Norwegian krone";
            case NPR: return "Nepalese rupee";
            case NZD: return "New Zealand dollar";
            case OMR: return "Omani rial";
            case PAB: return "Panamanian balboa";
            case PEN: return "Peruvian Sol";
            case PGK: return "Papua New Guinean kina";
            case PHP: return "Philippine piso[13]";
            case PKR: return "Pakistani rupee";
            case PLN: return "Polish złoty";
            case PYG: return "Paraguayan guaraní";
            case QAR: return "Qatari riyal";
            case RON: return "Romanian leu";
            case RSD: return "Serbian dinar";
            case RUB: return "Russian ruble";
            case RWF: return "Rwandan franc";
            case SAR: return "Saudi riyal";
            case SBD: return "Solomon Islands dollar";
            case SCR: return "Seychelles rupee";
            case SDG: return "Sudanese pound";
            case SEK: return "Swedish krona/kronor";
            case SGD: return "Singapore dollar";
            case SHP: return "Saint Helena pound";
            case SLL: return "Sierra Leonean leone";
            case SOS: return "Somali shilling";
            case SRD: return "Surinamese dollar";
            case SSP: return "South Sudanese pound";
            case STN: return "São Tomé and Príncipe dobra";
            case SVC: return "Salvadoran colón";
            case SYP: return "Syrian pound";
            case SZL: return "Swazi lilangeni";
            case THB: return "Thai baht";
            case TJS: return "Tajikistani somoni";
            case TMT: return "Turkmenistan manat";
            case TND: return "Tunisian dinar";
            case TOP: return "Tongan paʻanga";
            case TRY: return "Turkish lira";
            case TTD: return "Trinidad and Tobago dollar";
            case TVD: return "Tuvalu Dollar";
            case TWD: return "New Taiwan dollar";
            case TZS: return "Tanzanian shilling";
            case UAH: return "Ukrainian hryvnia";
            case UGX: return "Ugandan shilling";
            case USD: return "United States dollar";
            case USN: return "United States dollar (next day) (funds code)";
            case UYI: return "Uruguay Peso en Unidades Indexadas (URUIURUI) (funds code)";
            case UYU: return "Uruguayan peso";
            case UZS: return "Uzbekistan som";
            case VEF: return "Venezuelan bolívar";
            case VND: return "Vietnamese đồng";
            case VUV: return "Vanuatu vatu";
            case WST: return "Samoan tala";
            case XAF: return "CFA franc BEAC";
            case XAG: return "Silver (one troy ounce)";
            case XAU: return "Gold (one troy ounce)";
            case XBA: return "European Composite Unit (EURCO) (bond market unit)";
            case XBB: return "European Monetary Unit (E.M.U.-6) (bond market unit)";
            case XBC: return "European Unit of Account 9 (E.U.A.-9) (bond market unit)";
            case XBD: return "European Unit of Account 17 (E.U.A.-17) (bond market unit)";
            case XCD: return "East Caribbean dollar";
            case XDR: return "Special drawing rights";
            case XOF: return "CFA franc BCEAO";
            case XPD: return "Palladium (one troy ounce)";
            case XPF: return "CFP franc (franc Pacifique)";
            case XPT: return "Platinum (one troy ounce)";
            case XSU: return "SUCRE";
            case XTS: return "Code reserved for testing purposes";
            case XUA: return "ADB Unit of Account";
            case XXX: return "No currency";
            case YER: return "Yemeni rial";
            case ZAR: return "South African rand";
            case ZMW: return "Zambian kwacha";
            case ZWL: return "Zimbabwean dollar A/10";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CurrenciesEnumFactory implements EnumFactory<Currencies> {
    public Currencies fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("AED".equals(codeString))
          return Currencies.AED;
        if ("AFN".equals(codeString))
          return Currencies.AFN;
        if ("ALL".equals(codeString))
          return Currencies.ALL;
        if ("AMD".equals(codeString))
          return Currencies.AMD;
        if ("ANG".equals(codeString))
          return Currencies.ANG;
        if ("AOA".equals(codeString))
          return Currencies.AOA;
        if ("ARS".equals(codeString))
          return Currencies.ARS;
        if ("AUD".equals(codeString))
          return Currencies.AUD;
        if ("AWG".equals(codeString))
          return Currencies.AWG;
        if ("AZN".equals(codeString))
          return Currencies.AZN;
        if ("BAM".equals(codeString))
          return Currencies.BAM;
        if ("BBD".equals(codeString))
          return Currencies.BBD;
        if ("BDT".equals(codeString))
          return Currencies.BDT;
        if ("BGN".equals(codeString))
          return Currencies.BGN;
        if ("BHD".equals(codeString))
          return Currencies.BHD;
        if ("BIF".equals(codeString))
          return Currencies.BIF;
        if ("BMD".equals(codeString))
          return Currencies.BMD;
        if ("BND".equals(codeString))
          return Currencies.BND;
        if ("BOB".equals(codeString))
          return Currencies.BOB;
        if ("BOV".equals(codeString))
          return Currencies.BOV;
        if ("BRL".equals(codeString))
          return Currencies.BRL;
        if ("BSD".equals(codeString))
          return Currencies.BSD;
        if ("BTN".equals(codeString))
          return Currencies.BTN;
        if ("BWP".equals(codeString))
          return Currencies.BWP;
        if ("BYN".equals(codeString))
          return Currencies.BYN;
        if ("BZD".equals(codeString))
          return Currencies.BZD;
        if ("CAD".equals(codeString))
          return Currencies.CAD;
        if ("CDF".equals(codeString))
          return Currencies.CDF;
        if ("CHE".equals(codeString))
          return Currencies.CHE;
        if ("CHF".equals(codeString))
          return Currencies.CHF;
        if ("CHW".equals(codeString))
          return Currencies.CHW;
        if ("CLF".equals(codeString))
          return Currencies.CLF;
        if ("CLP".equals(codeString))
          return Currencies.CLP;
        if ("CNY".equals(codeString))
          return Currencies.CNY;
        if ("COP".equals(codeString))
          return Currencies.COP;
        if ("COU".equals(codeString))
          return Currencies.COU;
        if ("CRC".equals(codeString))
          return Currencies.CRC;
        if ("CUC".equals(codeString))
          return Currencies.CUC;
        if ("CUP".equals(codeString))
          return Currencies.CUP;
        if ("CVE".equals(codeString))
          return Currencies.CVE;
        if ("CZK".equals(codeString))
          return Currencies.CZK;
        if ("DJF".equals(codeString))
          return Currencies.DJF;
        if ("DKK".equals(codeString))
          return Currencies.DKK;
        if ("DOP".equals(codeString))
          return Currencies.DOP;
        if ("DZD".equals(codeString))
          return Currencies.DZD;
        if ("EGP".equals(codeString))
          return Currencies.EGP;
        if ("ERN".equals(codeString))
          return Currencies.ERN;
        if ("ETB".equals(codeString))
          return Currencies.ETB;
        if ("EUR".equals(codeString))
          return Currencies.EUR;
        if ("FJD".equals(codeString))
          return Currencies.FJD;
        if ("FKP".equals(codeString))
          return Currencies.FKP;
        if ("GBP".equals(codeString))
          return Currencies.GBP;
        if ("GEL".equals(codeString))
          return Currencies.GEL;
        if ("GGP".equals(codeString))
          return Currencies.GGP;
        if ("GHS".equals(codeString))
          return Currencies.GHS;
        if ("GIP".equals(codeString))
          return Currencies.GIP;
        if ("GMD".equals(codeString))
          return Currencies.GMD;
        if ("GNF".equals(codeString))
          return Currencies.GNF;
        if ("GTQ".equals(codeString))
          return Currencies.GTQ;
        if ("GYD".equals(codeString))
          return Currencies.GYD;
        if ("HKD".equals(codeString))
          return Currencies.HKD;
        if ("HNL".equals(codeString))
          return Currencies.HNL;
        if ("HRK".equals(codeString))
          return Currencies.HRK;
        if ("HTG".equals(codeString))
          return Currencies.HTG;
        if ("HUF".equals(codeString))
          return Currencies.HUF;
        if ("IDR".equals(codeString))
          return Currencies.IDR;
        if ("ILS".equals(codeString))
          return Currencies.ILS;
        if ("IMP".equals(codeString))
          return Currencies.IMP;
        if ("INR".equals(codeString))
          return Currencies.INR;
        if ("IQD".equals(codeString))
          return Currencies.IQD;
        if ("IRR".equals(codeString))
          return Currencies.IRR;
        if ("ISK".equals(codeString))
          return Currencies.ISK;
        if ("JEP".equals(codeString))
          return Currencies.JEP;
        if ("JMD".equals(codeString))
          return Currencies.JMD;
        if ("JOD".equals(codeString))
          return Currencies.JOD;
        if ("JPY".equals(codeString))
          return Currencies.JPY;
        if ("KES".equals(codeString))
          return Currencies.KES;
        if ("KGS".equals(codeString))
          return Currencies.KGS;
        if ("KHR".equals(codeString))
          return Currencies.KHR;
        if ("KMF".equals(codeString))
          return Currencies.KMF;
        if ("KPW".equals(codeString))
          return Currencies.KPW;
        if ("KRW".equals(codeString))
          return Currencies.KRW;
        if ("KWD".equals(codeString))
          return Currencies.KWD;
        if ("KYD".equals(codeString))
          return Currencies.KYD;
        if ("KZT".equals(codeString))
          return Currencies.KZT;
        if ("LAK".equals(codeString))
          return Currencies.LAK;
        if ("LBP".equals(codeString))
          return Currencies.LBP;
        if ("LKR".equals(codeString))
          return Currencies.LKR;
        if ("LRD".equals(codeString))
          return Currencies.LRD;
        if ("LSL".equals(codeString))
          return Currencies.LSL;
        if ("LYD".equals(codeString))
          return Currencies.LYD;
        if ("MAD".equals(codeString))
          return Currencies.MAD;
        if ("MDL".equals(codeString))
          return Currencies.MDL;
        if ("MGA".equals(codeString))
          return Currencies.MGA;
        if ("MKD".equals(codeString))
          return Currencies.MKD;
        if ("MMK".equals(codeString))
          return Currencies.MMK;
        if ("MNT".equals(codeString))
          return Currencies.MNT;
        if ("MOP".equals(codeString))
          return Currencies.MOP;
        if ("MRU".equals(codeString))
          return Currencies.MRU;
        if ("MUR".equals(codeString))
          return Currencies.MUR;
        if ("MVR".equals(codeString))
          return Currencies.MVR;
        if ("MWK".equals(codeString))
          return Currencies.MWK;
        if ("MXN".equals(codeString))
          return Currencies.MXN;
        if ("MXV".equals(codeString))
          return Currencies.MXV;
        if ("MYR".equals(codeString))
          return Currencies.MYR;
        if ("MZN".equals(codeString))
          return Currencies.MZN;
        if ("NAD".equals(codeString))
          return Currencies.NAD;
        if ("NGN".equals(codeString))
          return Currencies.NGN;
        if ("NIO".equals(codeString))
          return Currencies.NIO;
        if ("NOK".equals(codeString))
          return Currencies.NOK;
        if ("NPR".equals(codeString))
          return Currencies.NPR;
        if ("NZD".equals(codeString))
          return Currencies.NZD;
        if ("OMR".equals(codeString))
          return Currencies.OMR;
        if ("PAB".equals(codeString))
          return Currencies.PAB;
        if ("PEN".equals(codeString))
          return Currencies.PEN;
        if ("PGK".equals(codeString))
          return Currencies.PGK;
        if ("PHP".equals(codeString))
          return Currencies.PHP;
        if ("PKR".equals(codeString))
          return Currencies.PKR;
        if ("PLN".equals(codeString))
          return Currencies.PLN;
        if ("PYG".equals(codeString))
          return Currencies.PYG;
        if ("QAR".equals(codeString))
          return Currencies.QAR;
        if ("RON".equals(codeString))
          return Currencies.RON;
        if ("RSD".equals(codeString))
          return Currencies.RSD;
        if ("RUB".equals(codeString))
          return Currencies.RUB;
        if ("RWF".equals(codeString))
          return Currencies.RWF;
        if ("SAR".equals(codeString))
          return Currencies.SAR;
        if ("SBD".equals(codeString))
          return Currencies.SBD;
        if ("SCR".equals(codeString))
          return Currencies.SCR;
        if ("SDG".equals(codeString))
          return Currencies.SDG;
        if ("SEK".equals(codeString))
          return Currencies.SEK;
        if ("SGD".equals(codeString))
          return Currencies.SGD;
        if ("SHP".equals(codeString))
          return Currencies.SHP;
        if ("SLL".equals(codeString))
          return Currencies.SLL;
        if ("SOS".equals(codeString))
          return Currencies.SOS;
        if ("SRD".equals(codeString))
          return Currencies.SRD;
        if ("SSP".equals(codeString))
          return Currencies.SSP;
        if ("STN".equals(codeString))
          return Currencies.STN;
        if ("SVC".equals(codeString))
          return Currencies.SVC;
        if ("SYP".equals(codeString))
          return Currencies.SYP;
        if ("SZL".equals(codeString))
          return Currencies.SZL;
        if ("THB".equals(codeString))
          return Currencies.THB;
        if ("TJS".equals(codeString))
          return Currencies.TJS;
        if ("TMT".equals(codeString))
          return Currencies.TMT;
        if ("TND".equals(codeString))
          return Currencies.TND;
        if ("TOP".equals(codeString))
          return Currencies.TOP;
        if ("TRY".equals(codeString))
          return Currencies.TRY;
        if ("TTD".equals(codeString))
          return Currencies.TTD;
        if ("TVD".equals(codeString))
          return Currencies.TVD;
        if ("TWD".equals(codeString))
          return Currencies.TWD;
        if ("TZS".equals(codeString))
          return Currencies.TZS;
        if ("UAH".equals(codeString))
          return Currencies.UAH;
        if ("UGX".equals(codeString))
          return Currencies.UGX;
        if ("USD".equals(codeString))
          return Currencies.USD;
        if ("USN".equals(codeString))
          return Currencies.USN;
        if ("UYI".equals(codeString))
          return Currencies.UYI;
        if ("UYU".equals(codeString))
          return Currencies.UYU;
        if ("UZS".equals(codeString))
          return Currencies.UZS;
        if ("VEF".equals(codeString))
          return Currencies.VEF;
        if ("VND".equals(codeString))
          return Currencies.VND;
        if ("VUV".equals(codeString))
          return Currencies.VUV;
        if ("WST".equals(codeString))
          return Currencies.WST;
        if ("XAF".equals(codeString))
          return Currencies.XAF;
        if ("XAG".equals(codeString))
          return Currencies.XAG;
        if ("XAU".equals(codeString))
          return Currencies.XAU;
        if ("XBA".equals(codeString))
          return Currencies.XBA;
        if ("XBB".equals(codeString))
          return Currencies.XBB;
        if ("XBC".equals(codeString))
          return Currencies.XBC;
        if ("XBD".equals(codeString))
          return Currencies.XBD;
        if ("XCD".equals(codeString))
          return Currencies.XCD;
        if ("XDR".equals(codeString))
          return Currencies.XDR;
        if ("XOF".equals(codeString))
          return Currencies.XOF;
        if ("XPD".equals(codeString))
          return Currencies.XPD;
        if ("XPF".equals(codeString))
          return Currencies.XPF;
        if ("XPT".equals(codeString))
          return Currencies.XPT;
        if ("XSU".equals(codeString))
          return Currencies.XSU;
        if ("XTS".equals(codeString))
          return Currencies.XTS;
        if ("XUA".equals(codeString))
          return Currencies.XUA;
        if ("XXX".equals(codeString))
          return Currencies.XXX;
        if ("YER".equals(codeString))
          return Currencies.YER;
        if ("ZAR".equals(codeString))
          return Currencies.ZAR;
        if ("ZMW".equals(codeString))
          return Currencies.ZMW;
        if ("ZWL".equals(codeString))
          return Currencies.ZWL;
        throw new IllegalArgumentException("Unknown Currencies code '"+codeString+"'");
        }
        public Enumeration<Currencies> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<Currencies>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("AED".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.AED);
        if ("AFN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.AFN);
        if ("ALL".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.ALL);
        if ("AMD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.AMD);
        if ("ANG".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.ANG);
        if ("AOA".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.AOA);
        if ("ARS".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.ARS);
        if ("AUD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.AUD);
        if ("AWG".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.AWG);
        if ("AZN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.AZN);
        if ("BAM".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BAM);
        if ("BBD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BBD);
        if ("BDT".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BDT);
        if ("BGN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BGN);
        if ("BHD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BHD);
        if ("BIF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BIF);
        if ("BMD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BMD);
        if ("BND".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BND);
        if ("BOB".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BOB);
        if ("BOV".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BOV);
        if ("BRL".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BRL);
        if ("BSD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BSD);
        if ("BTN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BTN);
        if ("BWP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BWP);
        if ("BYN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BYN);
        if ("BZD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.BZD);
        if ("CAD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CAD);
        if ("CDF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CDF);
        if ("CHE".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CHE);
        if ("CHF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CHF);
        if ("CHW".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CHW);
        if ("CLF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CLF);
        if ("CLP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CLP);
        if ("CNY".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CNY);
        if ("COP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.COP);
        if ("COU".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.COU);
        if ("CRC".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CRC);
        if ("CUC".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CUC);
        if ("CUP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CUP);
        if ("CVE".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CVE);
        if ("CZK".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.CZK);
        if ("DJF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.DJF);
        if ("DKK".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.DKK);
        if ("DOP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.DOP);
        if ("DZD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.DZD);
        if ("EGP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.EGP);
        if ("ERN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.ERN);
        if ("ETB".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.ETB);
        if ("EUR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.EUR);
        if ("FJD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.FJD);
        if ("FKP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.FKP);
        if ("GBP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.GBP);
        if ("GEL".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.GEL);
        if ("GGP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.GGP);
        if ("GHS".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.GHS);
        if ("GIP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.GIP);
        if ("GMD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.GMD);
        if ("GNF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.GNF);
        if ("GTQ".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.GTQ);
        if ("GYD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.GYD);
        if ("HKD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.HKD);
        if ("HNL".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.HNL);
        if ("HRK".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.HRK);
        if ("HTG".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.HTG);
        if ("HUF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.HUF);
        if ("IDR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.IDR);
        if ("ILS".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.ILS);
        if ("IMP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.IMP);
        if ("INR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.INR);
        if ("IQD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.IQD);
        if ("IRR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.IRR);
        if ("ISK".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.ISK);
        if ("JEP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.JEP);
        if ("JMD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.JMD);
        if ("JOD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.JOD);
        if ("JPY".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.JPY);
        if ("KES".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.KES);
        if ("KGS".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.KGS);
        if ("KHR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.KHR);
        if ("KMF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.KMF);
        if ("KPW".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.KPW);
        if ("KRW".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.KRW);
        if ("KWD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.KWD);
        if ("KYD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.KYD);
        if ("KZT".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.KZT);
        if ("LAK".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.LAK);
        if ("LBP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.LBP);
        if ("LKR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.LKR);
        if ("LRD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.LRD);
        if ("LSL".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.LSL);
        if ("LYD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.LYD);
        if ("MAD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MAD);
        if ("MDL".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MDL);
        if ("MGA".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MGA);
        if ("MKD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MKD);
        if ("MMK".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MMK);
        if ("MNT".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MNT);
        if ("MOP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MOP);
        if ("MRU".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MRU);
        if ("MUR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MUR);
        if ("MVR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MVR);
        if ("MWK".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MWK);
        if ("MXN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MXN);
        if ("MXV".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MXV);
        if ("MYR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MYR);
        if ("MZN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.MZN);
        if ("NAD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.NAD);
        if ("NGN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.NGN);
        if ("NIO".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.NIO);
        if ("NOK".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.NOK);
        if ("NPR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.NPR);
        if ("NZD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.NZD);
        if ("OMR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.OMR);
        if ("PAB".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.PAB);
        if ("PEN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.PEN);
        if ("PGK".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.PGK);
        if ("PHP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.PHP);
        if ("PKR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.PKR);
        if ("PLN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.PLN);
        if ("PYG".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.PYG);
        if ("QAR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.QAR);
        if ("RON".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.RON);
        if ("RSD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.RSD);
        if ("RUB".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.RUB);
        if ("RWF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.RWF);
        if ("SAR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SAR);
        if ("SBD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SBD);
        if ("SCR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SCR);
        if ("SDG".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SDG);
        if ("SEK".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SEK);
        if ("SGD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SGD);
        if ("SHP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SHP);
        if ("SLL".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SLL);
        if ("SOS".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SOS);
        if ("SRD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SRD);
        if ("SSP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SSP);
        if ("STN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.STN);
        if ("SVC".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SVC);
        if ("SYP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SYP);
        if ("SZL".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.SZL);
        if ("THB".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.THB);
        if ("TJS".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.TJS);
        if ("TMT".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.TMT);
        if ("TND".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.TND);
        if ("TOP".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.TOP);
        if ("TRY".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.TRY);
        if ("TTD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.TTD);
        if ("TVD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.TVD);
        if ("TWD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.TWD);
        if ("TZS".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.TZS);
        if ("UAH".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.UAH);
        if ("UGX".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.UGX);
        if ("USD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.USD);
        if ("USN".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.USN);
        if ("UYI".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.UYI);
        if ("UYU".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.UYU);
        if ("UZS".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.UZS);
        if ("VEF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.VEF);
        if ("VND".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.VND);
        if ("VUV".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.VUV);
        if ("WST".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.WST);
        if ("XAF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XAF);
        if ("XAG".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XAG);
        if ("XAU".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XAU);
        if ("XBA".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XBA);
        if ("XBB".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XBB);
        if ("XBC".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XBC);
        if ("XBD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XBD);
        if ("XCD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XCD);
        if ("XDR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XDR);
        if ("XOF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XOF);
        if ("XPD".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XPD);
        if ("XPF".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XPF);
        if ("XPT".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XPT);
        if ("XSU".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XSU);
        if ("XTS".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XTS);
        if ("XUA".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XUA);
        if ("XXX".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.XXX);
        if ("YER".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.YER);
        if ("ZAR".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.ZAR);
        if ("ZMW".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.ZMW);
        if ("ZWL".equals(codeString))
          return new Enumeration<Currencies>(this, Currencies.ZWL);
        throw new FHIRException("Unknown Currencies code '"+codeString+"'");
        }
    public String toCode(Currencies code) {
      if (code == Currencies.AED)
        return "AED";
      if (code == Currencies.AFN)
        return "AFN";
      if (code == Currencies.ALL)
        return "ALL";
      if (code == Currencies.AMD)
        return "AMD";
      if (code == Currencies.ANG)
        return "ANG";
      if (code == Currencies.AOA)
        return "AOA";
      if (code == Currencies.ARS)
        return "ARS";
      if (code == Currencies.AUD)
        return "AUD";
      if (code == Currencies.AWG)
        return "AWG";
      if (code == Currencies.AZN)
        return "AZN";
      if (code == Currencies.BAM)
        return "BAM";
      if (code == Currencies.BBD)
        return "BBD";
      if (code == Currencies.BDT)
        return "BDT";
      if (code == Currencies.BGN)
        return "BGN";
      if (code == Currencies.BHD)
        return "BHD";
      if (code == Currencies.BIF)
        return "BIF";
      if (code == Currencies.BMD)
        return "BMD";
      if (code == Currencies.BND)
        return "BND";
      if (code == Currencies.BOB)
        return "BOB";
      if (code == Currencies.BOV)
        return "BOV";
      if (code == Currencies.BRL)
        return "BRL";
      if (code == Currencies.BSD)
        return "BSD";
      if (code == Currencies.BTN)
        return "BTN";
      if (code == Currencies.BWP)
        return "BWP";
      if (code == Currencies.BYN)
        return "BYN";
      if (code == Currencies.BZD)
        return "BZD";
      if (code == Currencies.CAD)
        return "CAD";
      if (code == Currencies.CDF)
        return "CDF";
      if (code == Currencies.CHE)
        return "CHE";
      if (code == Currencies.CHF)
        return "CHF";
      if (code == Currencies.CHW)
        return "CHW";
      if (code == Currencies.CLF)
        return "CLF";
      if (code == Currencies.CLP)
        return "CLP";
      if (code == Currencies.CNY)
        return "CNY";
      if (code == Currencies.COP)
        return "COP";
      if (code == Currencies.COU)
        return "COU";
      if (code == Currencies.CRC)
        return "CRC";
      if (code == Currencies.CUC)
        return "CUC";
      if (code == Currencies.CUP)
        return "CUP";
      if (code == Currencies.CVE)
        return "CVE";
      if (code == Currencies.CZK)
        return "CZK";
      if (code == Currencies.DJF)
        return "DJF";
      if (code == Currencies.DKK)
        return "DKK";
      if (code == Currencies.DOP)
        return "DOP";
      if (code == Currencies.DZD)
        return "DZD";
      if (code == Currencies.EGP)
        return "EGP";
      if (code == Currencies.ERN)
        return "ERN";
      if (code == Currencies.ETB)
        return "ETB";
      if (code == Currencies.EUR)
        return "EUR";
      if (code == Currencies.FJD)
        return "FJD";
      if (code == Currencies.FKP)
        return "FKP";
      if (code == Currencies.GBP)
        return "GBP";
      if (code == Currencies.GEL)
        return "GEL";
      if (code == Currencies.GGP)
        return "GGP";
      if (code == Currencies.GHS)
        return "GHS";
      if (code == Currencies.GIP)
        return "GIP";
      if (code == Currencies.GMD)
        return "GMD";
      if (code == Currencies.GNF)
        return "GNF";
      if (code == Currencies.GTQ)
        return "GTQ";
      if (code == Currencies.GYD)
        return "GYD";
      if (code == Currencies.HKD)
        return "HKD";
      if (code == Currencies.HNL)
        return "HNL";
      if (code == Currencies.HRK)
        return "HRK";
      if (code == Currencies.HTG)
        return "HTG";
      if (code == Currencies.HUF)
        return "HUF";
      if (code == Currencies.IDR)
        return "IDR";
      if (code == Currencies.ILS)
        return "ILS";
      if (code == Currencies.IMP)
        return "IMP";
      if (code == Currencies.INR)
        return "INR";
      if (code == Currencies.IQD)
        return "IQD";
      if (code == Currencies.IRR)
        return "IRR";
      if (code == Currencies.ISK)
        return "ISK";
      if (code == Currencies.JEP)
        return "JEP";
      if (code == Currencies.JMD)
        return "JMD";
      if (code == Currencies.JOD)
        return "JOD";
      if (code == Currencies.JPY)
        return "JPY";
      if (code == Currencies.KES)
        return "KES";
      if (code == Currencies.KGS)
        return "KGS";
      if (code == Currencies.KHR)
        return "KHR";
      if (code == Currencies.KMF)
        return "KMF";
      if (code == Currencies.KPW)
        return "KPW";
      if (code == Currencies.KRW)
        return "KRW";
      if (code == Currencies.KWD)
        return "KWD";
      if (code == Currencies.KYD)
        return "KYD";
      if (code == Currencies.KZT)
        return "KZT";
      if (code == Currencies.LAK)
        return "LAK";
      if (code == Currencies.LBP)
        return "LBP";
      if (code == Currencies.LKR)
        return "LKR";
      if (code == Currencies.LRD)
        return "LRD";
      if (code == Currencies.LSL)
        return "LSL";
      if (code == Currencies.LYD)
        return "LYD";
      if (code == Currencies.MAD)
        return "MAD";
      if (code == Currencies.MDL)
        return "MDL";
      if (code == Currencies.MGA)
        return "MGA";
      if (code == Currencies.MKD)
        return "MKD";
      if (code == Currencies.MMK)
        return "MMK";
      if (code == Currencies.MNT)
        return "MNT";
      if (code == Currencies.MOP)
        return "MOP";
      if (code == Currencies.MRU)
        return "MRU";
      if (code == Currencies.MUR)
        return "MUR";
      if (code == Currencies.MVR)
        return "MVR";
      if (code == Currencies.MWK)
        return "MWK";
      if (code == Currencies.MXN)
        return "MXN";
      if (code == Currencies.MXV)
        return "MXV";
      if (code == Currencies.MYR)
        return "MYR";
      if (code == Currencies.MZN)
        return "MZN";
      if (code == Currencies.NAD)
        return "NAD";
      if (code == Currencies.NGN)
        return "NGN";
      if (code == Currencies.NIO)
        return "NIO";
      if (code == Currencies.NOK)
        return "NOK";
      if (code == Currencies.NPR)
        return "NPR";
      if (code == Currencies.NZD)
        return "NZD";
      if (code == Currencies.OMR)
        return "OMR";
      if (code == Currencies.PAB)
        return "PAB";
      if (code == Currencies.PEN)
        return "PEN";
      if (code == Currencies.PGK)
        return "PGK";
      if (code == Currencies.PHP)
        return "PHP";
      if (code == Currencies.PKR)
        return "PKR";
      if (code == Currencies.PLN)
        return "PLN";
      if (code == Currencies.PYG)
        return "PYG";
      if (code == Currencies.QAR)
        return "QAR";
      if (code == Currencies.RON)
        return "RON";
      if (code == Currencies.RSD)
        return "RSD";
      if (code == Currencies.RUB)
        return "RUB";
      if (code == Currencies.RWF)
        return "RWF";
      if (code == Currencies.SAR)
        return "SAR";
      if (code == Currencies.SBD)
        return "SBD";
      if (code == Currencies.SCR)
        return "SCR";
      if (code == Currencies.SDG)
        return "SDG";
      if (code == Currencies.SEK)
        return "SEK";
      if (code == Currencies.SGD)
        return "SGD";
      if (code == Currencies.SHP)
        return "SHP";
      if (code == Currencies.SLL)
        return "SLL";
      if (code == Currencies.SOS)
        return "SOS";
      if (code == Currencies.SRD)
        return "SRD";
      if (code == Currencies.SSP)
        return "SSP";
      if (code == Currencies.STN)
        return "STN";
      if (code == Currencies.SVC)
        return "SVC";
      if (code == Currencies.SYP)
        return "SYP";
      if (code == Currencies.SZL)
        return "SZL";
      if (code == Currencies.THB)
        return "THB";
      if (code == Currencies.TJS)
        return "TJS";
      if (code == Currencies.TMT)
        return "TMT";
      if (code == Currencies.TND)
        return "TND";
      if (code == Currencies.TOP)
        return "TOP";
      if (code == Currencies.TRY)
        return "TRY";
      if (code == Currencies.TTD)
        return "TTD";
      if (code == Currencies.TVD)
        return "TVD";
      if (code == Currencies.TWD)
        return "TWD";
      if (code == Currencies.TZS)
        return "TZS";
      if (code == Currencies.UAH)
        return "UAH";
      if (code == Currencies.UGX)
        return "UGX";
      if (code == Currencies.USD)
        return "USD";
      if (code == Currencies.USN)
        return "USN";
      if (code == Currencies.UYI)
        return "UYI";
      if (code == Currencies.UYU)
        return "UYU";
      if (code == Currencies.UZS)
        return "UZS";
      if (code == Currencies.VEF)
        return "VEF";
      if (code == Currencies.VND)
        return "VND";
      if (code == Currencies.VUV)
        return "VUV";
      if (code == Currencies.WST)
        return "WST";
      if (code == Currencies.XAF)
        return "XAF";
      if (code == Currencies.XAG)
        return "XAG";
      if (code == Currencies.XAU)
        return "XAU";
      if (code == Currencies.XBA)
        return "XBA";
      if (code == Currencies.XBB)
        return "XBB";
      if (code == Currencies.XBC)
        return "XBC";
      if (code == Currencies.XBD)
        return "XBD";
      if (code == Currencies.XCD)
        return "XCD";
      if (code == Currencies.XDR)
        return "XDR";
      if (code == Currencies.XOF)
        return "XOF";
      if (code == Currencies.XPD)
        return "XPD";
      if (code == Currencies.XPF)
        return "XPF";
      if (code == Currencies.XPT)
        return "XPT";
      if (code == Currencies.XSU)
        return "XSU";
      if (code == Currencies.XTS)
        return "XTS";
      if (code == Currencies.XUA)
        return "XUA";
      if (code == Currencies.XXX)
        return "XXX";
      if (code == Currencies.YER)
        return "YER";
      if (code == Currencies.ZAR)
        return "ZAR";
      if (code == Currencies.ZMW)
        return "ZMW";
      if (code == Currencies.ZWL)
        return "ZWL";
      return "?";
      }
    public String toSystem(Currencies code) {
      return code.getSystem();
      }
    }

    public enum DaysOfWeek {
        /**
         * Monday.
         */
        MON, 
        /**
         * Tuesday.
         */
        TUE, 
        /**
         * Wednesday.
         */
        WED, 
        /**
         * Thursday.
         */
        THU, 
        /**
         * Friday.
         */
        FRI, 
        /**
         * Saturday.
         */
        SAT, 
        /**
         * Sunday.
         */
        SUN, 
        /**
         * added to help the parsers
         */
        NULL;
        public static DaysOfWeek fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("mon".equals(codeString))
          return MON;
        if ("tue".equals(codeString))
          return TUE;
        if ("wed".equals(codeString))
          return WED;
        if ("thu".equals(codeString))
          return THU;
        if ("fri".equals(codeString))
          return FRI;
        if ("sat".equals(codeString))
          return SAT;
        if ("sun".equals(codeString))
          return SUN;
        throw new FHIRException("Unknown DaysOfWeek code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case MON: return "mon";
            case TUE: return "tue";
            case WED: return "wed";
            case THU: return "thu";
            case FRI: return "fri";
            case SAT: return "sat";
            case SUN: return "sun";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case MON: return "http://hl7.org/fhir/days-of-week";
            case TUE: return "http://hl7.org/fhir/days-of-week";
            case WED: return "http://hl7.org/fhir/days-of-week";
            case THU: return "http://hl7.org/fhir/days-of-week";
            case FRI: return "http://hl7.org/fhir/days-of-week";
            case SAT: return "http://hl7.org/fhir/days-of-week";
            case SUN: return "http://hl7.org/fhir/days-of-week";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case MON: return "Monday.";
            case TUE: return "Tuesday.";
            case WED: return "Wednesday.";
            case THU: return "Thursday.";
            case FRI: return "Friday.";
            case SAT: return "Saturday.";
            case SUN: return "Sunday.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case MON: return "Monday";
            case TUE: return "Tuesday";
            case WED: return "Wednesday";
            case THU: return "Thursday";
            case FRI: return "Friday";
            case SAT: return "Saturday";
            case SUN: return "Sunday";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DaysOfWeekEnumFactory implements EnumFactory<DaysOfWeek> {
    public DaysOfWeek fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("mon".equals(codeString))
          return DaysOfWeek.MON;
        if ("tue".equals(codeString))
          return DaysOfWeek.TUE;
        if ("wed".equals(codeString))
          return DaysOfWeek.WED;
        if ("thu".equals(codeString))
          return DaysOfWeek.THU;
        if ("fri".equals(codeString))
          return DaysOfWeek.FRI;
        if ("sat".equals(codeString))
          return DaysOfWeek.SAT;
        if ("sun".equals(codeString))
          return DaysOfWeek.SUN;
        throw new IllegalArgumentException("Unknown DaysOfWeek code '"+codeString+"'");
        }
        public Enumeration<DaysOfWeek> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DaysOfWeek>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("mon".equals(codeString))
          return new Enumeration<DaysOfWeek>(this, DaysOfWeek.MON);
        if ("tue".equals(codeString))
          return new Enumeration<DaysOfWeek>(this, DaysOfWeek.TUE);
        if ("wed".equals(codeString))
          return new Enumeration<DaysOfWeek>(this, DaysOfWeek.WED);
        if ("thu".equals(codeString))
          return new Enumeration<DaysOfWeek>(this, DaysOfWeek.THU);
        if ("fri".equals(codeString))
          return new Enumeration<DaysOfWeek>(this, DaysOfWeek.FRI);
        if ("sat".equals(codeString))
          return new Enumeration<DaysOfWeek>(this, DaysOfWeek.SAT);
        if ("sun".equals(codeString))
          return new Enumeration<DaysOfWeek>(this, DaysOfWeek.SUN);
        throw new FHIRException("Unknown DaysOfWeek code '"+codeString+"'");
        }
    public String toCode(DaysOfWeek code) {
      if (code == DaysOfWeek.MON)
        return "mon";
      if (code == DaysOfWeek.TUE)
        return "tue";
      if (code == DaysOfWeek.WED)
        return "wed";
      if (code == DaysOfWeek.THU)
        return "thu";
      if (code == DaysOfWeek.FRI)
        return "fri";
      if (code == DaysOfWeek.SAT)
        return "sat";
      if (code == DaysOfWeek.SUN)
        return "sun";
      return "?";
      }
    public String toSystem(DaysOfWeek code) {
      return code.getSystem();
      }
    }

    public enum DeviceNameType {
        /**
         * The term assigned to a medical device by the entity who registers or submits information about it to a jurisdiction or its databases. This may be considered the manufacturer assigned name (e.g., brand name assigned by the labeler or manufacturer in US, or device name assigned by the manufacturer in EU) and may also be synonymous with proprietary name or trade name of the device.
         */
        REGISTEREDNAME, 
        /**
         * The term that generically describes the device by a name as assigned by the manufacturer that is recognized by lay person.  This common or generic name may be printed on the package it came in or some combination of that name with the model number, serial number, or other attribute that makes the name easy to understand for the user of that device. It is often exposed in communicating devices transport protocols. It is provided to help users identify the device when reported in discovery operations.
         */
        USERFRIENDLYNAME, 
        /**
         * the term used by the patient associated with the device when describing the device, for example 'knee implant', when documented as a self-reported device.
         */
        PATIENTREPORTEDNAME, 
        /**
         * added to help the parsers
         */
        NULL;
        public static DeviceNameType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered-name".equals(codeString))
          return REGISTEREDNAME;
        if ("user-friendly-name".equals(codeString))
          return USERFRIENDLYNAME;
        if ("patient-reported-name".equals(codeString))
          return PATIENTREPORTEDNAME;
        throw new FHIRException("Unknown DeviceNameType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REGISTEREDNAME: return "registered-name";
            case USERFRIENDLYNAME: return "user-friendly-name";
            case PATIENTREPORTEDNAME: return "patient-reported-name";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REGISTEREDNAME: return "http://hl7.org/fhir/device-nametype";
            case USERFRIENDLYNAME: return "http://hl7.org/fhir/device-nametype";
            case PATIENTREPORTEDNAME: return "http://hl7.org/fhir/device-nametype";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REGISTEREDNAME: return "The term assigned to a medical device by the entity who registers or submits information about it to a jurisdiction or its databases. This may be considered the manufacturer assigned name (e.g., brand name assigned by the labeler or manufacturer in US, or device name assigned by the manufacturer in EU) and may also be synonymous with proprietary name or trade name of the device.";
            case USERFRIENDLYNAME: return "The term that generically describes the device by a name as assigned by the manufacturer that is recognized by lay person.  This common or generic name may be printed on the package it came in or some combination of that name with the model number, serial number, or other attribute that makes the name easy to understand for the user of that device. It is often exposed in communicating devices transport protocols. It is provided to help users identify the device when reported in discovery operations.";
            case PATIENTREPORTEDNAME: return "the term used by the patient associated with the device when describing the device, for example 'knee implant', when documented as a self-reported device.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REGISTEREDNAME: return "Registered name";
            case USERFRIENDLYNAME: return "User Friendly name";
            case PATIENTREPORTEDNAME: return "Patient Reported name";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DeviceNameTypeEnumFactory implements EnumFactory<DeviceNameType> {
    public DeviceNameType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered-name".equals(codeString))
          return DeviceNameType.REGISTEREDNAME;
        if ("user-friendly-name".equals(codeString))
          return DeviceNameType.USERFRIENDLYNAME;
        if ("patient-reported-name".equals(codeString))
          return DeviceNameType.PATIENTREPORTEDNAME;
        throw new IllegalArgumentException("Unknown DeviceNameType code '"+codeString+"'");
        }
        public Enumeration<DeviceNameType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DeviceNameType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("registered-name".equals(codeString))
          return new Enumeration<DeviceNameType>(this, DeviceNameType.REGISTEREDNAME);
        if ("user-friendly-name".equals(codeString))
          return new Enumeration<DeviceNameType>(this, DeviceNameType.USERFRIENDLYNAME);
        if ("patient-reported-name".equals(codeString))
          return new Enumeration<DeviceNameType>(this, DeviceNameType.PATIENTREPORTEDNAME);
        throw new FHIRException("Unknown DeviceNameType code '"+codeString+"'");
        }
    public String toCode(DeviceNameType code) {
      if (code == DeviceNameType.REGISTEREDNAME)
        return "registered-name";
      if (code == DeviceNameType.USERFRIENDLYNAME)
        return "user-friendly-name";
      if (code == DeviceNameType.PATIENTREPORTEDNAME)
        return "patient-reported-name";
      return "?";
      }
    public String toSystem(DeviceNameType code) {
      return code.getSystem();
      }
    }

    public enum DocumentReferenceStatus {
        /**
         * This is the current reference for this document.
         */
        CURRENT, 
        /**
         * This reference has been superseded by another reference.
         */
        SUPERSEDED, 
        /**
         * This reference was created in error.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers
         */
        NULL;
        public static DocumentReferenceStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("current".equals(codeString))
          return CURRENT;
        if ("superseded".equals(codeString))
          return SUPERSEDED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        throw new FHIRException("Unknown DocumentReferenceStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CURRENT: return "current";
            case SUPERSEDED: return "superseded";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CURRENT: return "http://hl7.org/fhir/document-reference-status";
            case SUPERSEDED: return "http://hl7.org/fhir/document-reference-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/document-reference-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CURRENT: return "This is the current reference for this document.";
            case SUPERSEDED: return "This reference has been superseded by another reference.";
            case ENTEREDINERROR: return "This reference was created in error.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CURRENT: return "Current";
            case SUPERSEDED: return "Superseded";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DocumentReferenceStatusEnumFactory implements EnumFactory<DocumentReferenceStatus> {
    public DocumentReferenceStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("current".equals(codeString))
          return DocumentReferenceStatus.CURRENT;
        if ("superseded".equals(codeString))
          return DocumentReferenceStatus.SUPERSEDED;
        if ("entered-in-error".equals(codeString))
          return DocumentReferenceStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown DocumentReferenceStatus code '"+codeString+"'");
        }
        public Enumeration<DocumentReferenceStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DocumentReferenceStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("current".equals(codeString))
          return new Enumeration<DocumentReferenceStatus>(this, DocumentReferenceStatus.CURRENT);
        if ("superseded".equals(codeString))
          return new Enumeration<DocumentReferenceStatus>(this, DocumentReferenceStatus.SUPERSEDED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<DocumentReferenceStatus>(this, DocumentReferenceStatus.ENTEREDINERROR);
        throw new FHIRException("Unknown DocumentReferenceStatus code '"+codeString+"'");
        }
    public String toCode(DocumentReferenceStatus code) {
      if (code == DocumentReferenceStatus.CURRENT)
        return "current";
      if (code == DocumentReferenceStatus.SUPERSEDED)
        return "superseded";
      if (code == DocumentReferenceStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(DocumentReferenceStatus code) {
      return code.getSystem();
      }
    }

    public enum EventStatus {
        /**
         * The core event has not started yet, but some staging activities have begun (e.g. surgical suite preparation).  Preparation stages may be tracked for billing purposes.
         */
        PREPARATION, 
        /**
         * The event is currently occurring.
         */
        INPROGRESS, 
        /**
         * The event was terminated prior to any activity beyond preparation.  I.e. The 'main' activity has not yet begun.  The boundary between preparatory and the 'main' activity is context-specific.
         */
        NOTDONE, 
        /**
         * The event has been temporarily stopped but is expected to resume in the future.
         */
        ONHOLD, 
        /**
         * The event was terminated prior to the full completion of the intended activity but after at least some of the 'main' activity (beyond preparation) has occurred.
         */
        STOPPED, 
        /**
         * The event has now concluded.
         */
        COMPLETED, 
        /**
         * This electronic record should never have existed, though it is possible that real-world decisions were based on it.  (If real-world activity has occurred, the status should be "stopped" rather than "entered-in-error".).
         */
        ENTEREDINERROR, 
        /**
         * The authoring/source system does not know which of the status values currently applies for this event.  Note: This concept is not to be used for "other" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.
         */
        UNKNOWN, 
        /**
         * added to help the parsers
         */
        NULL;
        public static EventStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preparation".equals(codeString))
          return PREPARATION;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("not-done".equals(codeString))
          return NOTDONE;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if ("stopped".equals(codeString))
          return STOPPED;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        throw new FHIRException("Unknown EventStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PREPARATION: return "preparation";
            case INPROGRESS: return "in-progress";
            case NOTDONE: return "not-done";
            case ONHOLD: return "on-hold";
            case STOPPED: return "stopped";
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PREPARATION: return "http://hl7.org/fhir/event-status";
            case INPROGRESS: return "http://hl7.org/fhir/event-status";
            case NOTDONE: return "http://hl7.org/fhir/event-status";
            case ONHOLD: return "http://hl7.org/fhir/event-status";
            case STOPPED: return "http://hl7.org/fhir/event-status";
            case COMPLETED: return "http://hl7.org/fhir/event-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/event-status";
            case UNKNOWN: return "http://hl7.org/fhir/event-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PREPARATION: return "The core event has not started yet, but some staging activities have begun (e.g. surgical suite preparation).  Preparation stages may be tracked for billing purposes.";
            case INPROGRESS: return "The event is currently occurring.";
            case NOTDONE: return "The event was terminated prior to any activity beyond preparation.  I.e. The 'main' activity has not yet begun.  The boundary between preparatory and the 'main' activity is context-specific.";
            case ONHOLD: return "The event has been temporarily stopped but is expected to resume in the future.";
            case STOPPED: return "The event was terminated prior to the full completion of the intended activity but after at least some of the 'main' activity (beyond preparation) has occurred.";
            case COMPLETED: return "The event has now concluded.";
            case ENTEREDINERROR: return "This electronic record should never have existed, though it is possible that real-world decisions were based on it.  (If real-world activity has occurred, the status should be \"stopped\" rather than \"entered-in-error\".).";
            case UNKNOWN: return "The authoring/source system does not know which of the status values currently applies for this event.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PREPARATION: return "Preparation";
            case INPROGRESS: return "In Progress";
            case NOTDONE: return "Not Done";
            case ONHOLD: return "On Hold";
            case STOPPED: return "Stopped";
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class EventStatusEnumFactory implements EnumFactory<EventStatus> {
    public EventStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preparation".equals(codeString))
          return EventStatus.PREPARATION;
        if ("in-progress".equals(codeString))
          return EventStatus.INPROGRESS;
        if ("not-done".equals(codeString))
          return EventStatus.NOTDONE;
        if ("on-hold".equals(codeString))
          return EventStatus.ONHOLD;
        if ("stopped".equals(codeString))
          return EventStatus.STOPPED;
        if ("completed".equals(codeString))
          return EventStatus.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return EventStatus.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return EventStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown EventStatus code '"+codeString+"'");
        }
        public Enumeration<EventStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<EventStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("preparation".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.PREPARATION);
        if ("in-progress".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.INPROGRESS);
        if ("not-done".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.NOTDONE);
        if ("on-hold".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.ONHOLD);
        if ("stopped".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.STOPPED);
        if ("completed".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.COMPLETED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.ENTEREDINERROR);
        if ("unknown".equals(codeString))
          return new Enumeration<EventStatus>(this, EventStatus.UNKNOWN);
        throw new FHIRException("Unknown EventStatus code '"+codeString+"'");
        }
    public String toCode(EventStatus code) {
      if (code == EventStatus.PREPARATION)
        return "preparation";
      if (code == EventStatus.INPROGRESS)
        return "in-progress";
      if (code == EventStatus.NOTDONE)
        return "not-done";
      if (code == EventStatus.ONHOLD)
        return "on-hold";
      if (code == EventStatus.STOPPED)
        return "stopped";
      if (code == EventStatus.COMPLETED)
        return "completed";
      if (code == EventStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == EventStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(EventStatus code) {
      return code.getSystem();
      }
    }

    public enum EvidenceVariableHandling {
        /**
         * A continuous variable is one for which, within the limits the variable ranges, any value is possible (from STATO http://purl.obolibrary.org/obo/STATO_0000251).
         */
        CONTINUOUS, 
        /**
         * A dichotomous variable is a categorical variable which is defined to have only 2 categories or possible values (from STATO http://purl.obolibrary.org/obo/STATO_0000090).
         */
        DICHOTOMOUS, 
        /**
         * An ordinal variable is a categorical variable where the discrete possible values are ordered or correspond to an implicit ranking (from STATO http://purl.obolibrary.org/obo/STATO_0000228).
         */
        ORDINAL, 
        /**
         * A polychotomous variable is a categorical variable which is defined to have minimally 2 categories or possible values. (from STATO  http://purl.obolibrary.org/obo/STATO_0000087).  Suggestion to limit code use to situations when neither dichotomous nor ordinal variables apply.
         */
        POLYCHOTOMOUS, 
        /**
         * added to help the parsers
         */
        NULL;
        public static EvidenceVariableHandling fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("continuous".equals(codeString))
          return CONTINUOUS;
        if ("dichotomous".equals(codeString))
          return DICHOTOMOUS;
        if ("ordinal".equals(codeString))
          return ORDINAL;
        if ("polychotomous".equals(codeString))
          return POLYCHOTOMOUS;
        throw new FHIRException("Unknown EvidenceVariableHandling code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CONTINUOUS: return "continuous";
            case DICHOTOMOUS: return "dichotomous";
            case ORDINAL: return "ordinal";
            case POLYCHOTOMOUS: return "polychotomous";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CONTINUOUS: return "http://hl7.org/fhir/variable-handling";
            case DICHOTOMOUS: return "http://hl7.org/fhir/variable-handling";
            case ORDINAL: return "http://hl7.org/fhir/variable-handling";
            case POLYCHOTOMOUS: return "http://hl7.org/fhir/variable-handling";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CONTINUOUS: return "A continuous variable is one for which, within the limits the variable ranges, any value is possible (from STATO http://purl.obolibrary.org/obo/STATO_0000251).";
            case DICHOTOMOUS: return "A dichotomous variable is a categorical variable which is defined to have only 2 categories or possible values (from STATO http://purl.obolibrary.org/obo/STATO_0000090).";
            case ORDINAL: return "An ordinal variable is a categorical variable where the discrete possible values are ordered or correspond to an implicit ranking (from STATO http://purl.obolibrary.org/obo/STATO_0000228).";
            case POLYCHOTOMOUS: return "A polychotomous variable is a categorical variable which is defined to have minimally 2 categories or possible values. (from STATO  http://purl.obolibrary.org/obo/STATO_0000087).  Suggestion to limit code use to situations when neither dichotomous nor ordinal variables apply.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CONTINUOUS: return "continuous variable";
            case DICHOTOMOUS: return "dichotomous variable";
            case ORDINAL: return "ordinal variable";
            case POLYCHOTOMOUS: return "polychotomous variable";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class EvidenceVariableHandlingEnumFactory implements EnumFactory<EvidenceVariableHandling> {
    public EvidenceVariableHandling fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("continuous".equals(codeString))
          return EvidenceVariableHandling.CONTINUOUS;
        if ("dichotomous".equals(codeString))
          return EvidenceVariableHandling.DICHOTOMOUS;
        if ("ordinal".equals(codeString))
          return EvidenceVariableHandling.ORDINAL;
        if ("polychotomous".equals(codeString))
          return EvidenceVariableHandling.POLYCHOTOMOUS;
        throw new IllegalArgumentException("Unknown EvidenceVariableHandling code '"+codeString+"'");
        }
        public Enumeration<EvidenceVariableHandling> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<EvidenceVariableHandling>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("continuous".equals(codeString))
          return new Enumeration<EvidenceVariableHandling>(this, EvidenceVariableHandling.CONTINUOUS);
        if ("dichotomous".equals(codeString))
          return new Enumeration<EvidenceVariableHandling>(this, EvidenceVariableHandling.DICHOTOMOUS);
        if ("ordinal".equals(codeString))
          return new Enumeration<EvidenceVariableHandling>(this, EvidenceVariableHandling.ORDINAL);
        if ("polychotomous".equals(codeString))
          return new Enumeration<EvidenceVariableHandling>(this, EvidenceVariableHandling.POLYCHOTOMOUS);
        throw new FHIRException("Unknown EvidenceVariableHandling code '"+codeString+"'");
        }
    public String toCode(EvidenceVariableHandling code) {
      if (code == EvidenceVariableHandling.CONTINUOUS)
        return "continuous";
      if (code == EvidenceVariableHandling.DICHOTOMOUS)
        return "dichotomous";
      if (code == EvidenceVariableHandling.ORDINAL)
        return "ordinal";
      if (code == EvidenceVariableHandling.POLYCHOTOMOUS)
        return "polychotomous";
      return "?";
      }
    public String toSystem(EvidenceVariableHandling code) {
      return code.getSystem();
      }
    }

    public enum ExampleScenarioActorType {
        /**
         * A human actor
         */
        PERSON, 
        /**
         * A software application or other system
         */
        SYSTEM, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ExampleScenarioActorType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("person".equals(codeString))
          return PERSON;
        if ("system".equals(codeString))
          return SYSTEM;
        throw new FHIRException("Unknown ExampleScenarioActorType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PERSON: return "person";
            case SYSTEM: return "system";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PERSON: return "http://hl7.org/fhir/examplescenario-actor-type";
            case SYSTEM: return "http://hl7.org/fhir/examplescenario-actor-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PERSON: return "A human actor";
            case SYSTEM: return "A software application or other system";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PERSON: return "Person";
            case SYSTEM: return "System";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ExampleScenarioActorTypeEnumFactory implements EnumFactory<ExampleScenarioActorType> {
    public ExampleScenarioActorType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("person".equals(codeString))
          return ExampleScenarioActorType.PERSON;
        if ("system".equals(codeString))
          return ExampleScenarioActorType.SYSTEM;
        throw new IllegalArgumentException("Unknown ExampleScenarioActorType code '"+codeString+"'");
        }
        public Enumeration<ExampleScenarioActorType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ExampleScenarioActorType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("person".equals(codeString))
          return new Enumeration<ExampleScenarioActorType>(this, ExampleScenarioActorType.PERSON);
        if ("system".equals(codeString))
          return new Enumeration<ExampleScenarioActorType>(this, ExampleScenarioActorType.SYSTEM);
        throw new FHIRException("Unknown ExampleScenarioActorType code '"+codeString+"'");
        }
    public String toCode(ExampleScenarioActorType code) {
      if (code == ExampleScenarioActorType.PERSON)
        return "person";
      if (code == ExampleScenarioActorType.SYSTEM)
        return "system";
      return "?";
      }
    public String toSystem(ExampleScenarioActorType code) {
      return code.getSystem();
      }
    }

    public enum FHIRTypes {
        /**
         * Base Type: Base definition for all types defined in FHIR type system.
         */
        BASE, 
        /**
         * Element Type: Base definition for all elements in a resource.
         */
        ELEMENT, 
        /**
         * BackboneElement Type: Base definition for all elements that are defined inside a resource - but not those in a data type.
         */
        BACKBONEELEMENT, 
        /**
         * DataType Type: The base class for all re-useable types defined as part of the FHIR Specification.
         */
        DATATYPE, 
        /**
         * Address Type: An address expressed using postal conventions (as opposed to GPS or other location definition formats).  This data type may be used to convey addresses for use in delivering mail as well as for visiting locations which might not be valid for mail delivery.  There are a variety of postal address formats defined around the world.
The ISO21090-codedString may be used to provide a coded representation of the contents of strings in an Address.
         */
        ADDRESS, 
        /**
         * Annotation Type: A  text note which also  contains information about who made the statement and when.
         */
        ANNOTATION, 
        /**
         * Attachment Type: For referring to data content defined in other formats.
         */
        ATTACHMENT, 
        /**
         * Availability Type: Availability data for an {item}.
         */
        AVAILABILITY, 
        /**
         * BackboneType Type: Base definition for the few data types that are allowed to carry modifier extensions.
         */
        BACKBONETYPE, 
        /**
         * Dosage Type: Indicates how the medication is/was taken or should be taken by the patient.
         */
        DOSAGE, 
        /**
         * ElementDefinition Type: Captures constraints on each element within the resource, profile, or extension.
         */
        ELEMENTDEFINITION, 
        /**
         * MarketingStatus Type: The marketing status describes the date when a medicinal product is actually put on the market or the date as of which it is no longer available.
         */
        MARKETINGSTATUS, 
        /**
         * Population Type: A populatioof people with some set of grouping criteria.
         */
        POPULATION, 
        /**
         * ProductShelfLife Type: The shelf-life and storage information for a medicinal product item or container can be described using this class.
         */
        PRODUCTSHELFLIFE, 
        /**
         * Timing Type: Specifies an event that may occur multiple times. Timing schedules are used to record when things are planned, expected or requested to occur. The most common usage is in dosage instructions for medications. They are also used when planning care of various kinds, and may be used for reporting the schedule to which past regular activities were carried out.
         */
        TIMING, 
        /**
         * CodeableConcept Type: A concept that may be defined by a formal reference to a terminology or ontology or may be provided by text.
         */
        CODEABLECONCEPT, 
        /**
         * CodeableReference Type: A reference to a resource (by instance), or instead, a reference to a concept defined in a terminology or ontology (by class).
         */
        CODEABLEREFERENCE, 
        /**
         * Coding Type: A reference to a code defined by a terminology system.
         */
        CODING, 
        /**
         * ContactDetail Type: Specifies contact information for a person or organization.
         */
        CONTACTDETAIL, 
        /**
         * ContactPoint Type: Details for all kinds of technology mediated contact points for a person or organization, including telephone, email, etc.
         */
        CONTACTPOINT, 
        /**
         * Contributor Type: A contributor to the content of a knowledge asset, including authors, editors, reviewers, and endorsers.
         */
        CONTRIBUTOR, 
        /**
         * DataRequirement Type: Describes a required data item for evaluation in terms of the type of data, and optional code or date-based filters of the data.
         */
        DATAREQUIREMENT, 
        /**
         * Expression Type: A expression that is evaluated in a specified context and returns a value. The context of use of the expression must specify the context in which the expression is evaluated, and how the result of the expression is used.
         */
        EXPRESSION, 
        /**
         * ExtendedContactDetail Type: Specifies contact information for a specific purpose over a period of time, might be handled/monitored by a specific named person or organization.
         */
        EXTENDEDCONTACTDETAIL, 
        /**
         * Extension Type: Optional Extension Element - found in all resources.
         */
        EXTENSION, 
        /**
         * HumanName Type: A name, normally of a human, that can be used for other living entities (eg. animals but not organizations) that have been assigned names by a human and may need the use of name parts or the need for usage information.
         */
        HUMANNAME, 
        /**
         * Identifier Type: An identifier - identifies some entity uniquely and unambiguously. Typically this is used for business identifiers.
         */
        IDENTIFIER, 
        /**
         * Meta Type: The metadata about a resource. This is content in the resource that is maintained by the infrastructure. Changes to the content might not always be associated with version changes to the resource.
         */
        META, 
        /**
         * MonetaryComponent Type: Availability data for an {item}.
         */
        MONETARYCOMPONENT, 
        /**
         * Money Type: An amount of economic utility in some recognized currency.
         */
        MONEY, 
        /**
         * Narrative Type: A human-readable summary of the resource conveying the essential clinical and business information for the resource.
         */
        NARRATIVE, 
        /**
         * ParameterDefinition Type: The parameters to the module. This collection specifies both the input and output parameters. Input parameters are provided by the caller as part of the $evaluate operation. Output parameters are included in the GuidanceResponse.
         */
        PARAMETERDEFINITION, 
        /**
         * Period Type: A time period defined by a start and end date and optionally time.
         */
        PERIOD, 
        /**
         * PrimitiveType Type: The base type for all re-useable types defined that have a simple property.
         */
        PRIMITIVETYPE, 
        /**
         * base64Binary Type: A stream of bytes
         */
        BASE64BINARY, 
        /**
         * boolean Type: Value of "true" or "false"
         */
        BOOLEAN, 
        /**
         * date Type: A date or partial date (e.g. just year or year + month). There is no UTC offset. The format is a union of the schema types gYear, gYearMonth and date.  Dates SHALL be valid dates.
         */
        DATE, 
        /**
         * dateTime Type: A date, date-time or partial date (e.g. just year or year + month).  If hours and minutes are specified, a UTC offset SHALL be populated. The format is a union of the schema types gYear, gYearMonth, date and dateTime. Seconds must be provided due to schema type constraints but may be zero-filled and may be ignored.                 Dates SHALL be valid dates.
         */
        DATETIME, 
        /**
         * decimal Type: A rational number with implicit precision
         */
        DECIMAL, 
        /**
         * instant Type: An instant in time - known at least to the second
         */
        INSTANT, 
        /**
         * integer Type: A whole number
         */
        INTEGER, 
        /**
         * positiveInt type: An integer with a value that is positive (e.g. >0)
         */
        POSITIVEINT, 
        /**
         * unsignedInt type: An integer with a value that is not negative (e.g. >= 0)
         */
        UNSIGNEDINT, 
        /**
         * integer64 Type: A very large whole number
         */
        INTEGER64, 
        /**
         * string Type: A sequence of Unicode characters
         */
        STRING, 
        /**
         * code type: A string which has at least one character and no leading or trailing whitespace and where there is no whitespace other than single spaces in the contents
         */
        CODE, 
        /**
         * id type: Any combination of letters, numerals, "-" and ".", with a length limit of 64 characters.  (This might be an integer, an unprefixed OID, UUID or any other identifier pattern that meets these constraints.)  Ids are case-insensitive.
         */
        ID, 
        /**
         * markdown type: A string that may contain Github Flavored Markdown syntax for optional processing by a mark down presentation engine
         */
        MARKDOWN, 
        /**
         * time Type: A time during the day, with no date specified
         */
        TIME, 
        /**
         * uri Type: String of characters used to identify a name or a resource
         */
        URI, 
        /**
         * canonical type: A URI that is a reference to a canonical URL on a FHIR resource
         */
        CANONICAL, 
        /**
         * oid type: An OID represented as a URI
         */
        OID, 
        /**
         * url type: A URI that is a literal reference
         */
        URL, 
        /**
         * uuid type: A UUID, represented as a URI
         */
        UUID, 
        /**
         * Quantity Type: A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.
         */
        QUANTITY, 
        /**
         * Age Type: A duration of time during which an organism (or a process) has existed.
         */
        AGE, 
        /**
         * Count Type: A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.
         */
        COUNT, 
        /**
         * Distance Type: A length - a value with a unit that is a physical distance.
         */
        DISTANCE, 
        /**
         * Duration Type: A length of time.
         */
        DURATION, 
        /**
         * Range Type: A set of ordered Quantities defined by a low and high limit.
         */
        RANGE, 
        /**
         * Ratio Type: A relationship of two Quantity values - expressed as a numerator and a denominator.
         */
        RATIO, 
        /**
         * RatioRange Type: A range of ratios expressed as a low and high numerator and a denominator.
         */
        RATIORANGE, 
        /**
         * Reference Type: A reference from one resource to another.
         */
        REFERENCE, 
        /**
         * RelatedArtifact Type: Related artifacts such as additional documentation, justification, or bibliographic references.
         */
        RELATEDARTIFACT, 
        /**
         * SampledData Type: A series of measurements taken by a device, with upper and lower limits. There may be more than one dimension in the data.
         */
        SAMPLEDDATA, 
        /**
         * Signature Type: A signature along with supporting context. The signature may be a digital signature that is cryptographic in nature, or some other signature acceptable to the domain. This other signature may be as simple as a graphical image representing a hand-written signature, or a signature ceremony Different signature approaches have different utilities.
         */
        SIGNATURE, 
        /**
         * TriggerDefinition Type: A description of a triggering event. Triggering events can be named events, data events, or periodic, as determined by the type element.
         */
        TRIGGERDEFINITION, 
        /**
         * UsageContext Type: Specifies clinical/business/etc. metadata that can be used to retrieve, index and/or categorize an artifact. This metadata can either be specific to the applicable population (e.g., age category, DRG) or the specific context of care (e.g., venue, care setting, provider of care).
         */
        USAGECONTEXT, 
        /**
         * VirtualServiceDetail Type: Virtual Service Contact Details.
         */
        VIRTUALSERVICEDETAIL, 
        /**
         * xhtml Type definition
         */
        XHTML, 
        /**
         * This is the base resource type for everything.
         */
        RESOURCE, 
        /**
         * A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.
         */
        BINARY, 
        /**
         * A container for a collection of resources.
         */
        BUNDLE, 
        /**
         * A resource that includes narrative, extensions, and contained resources.
         */
        DOMAINRESOURCE, 
        /**
         * A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.
         */
        ACCOUNT, 
        /**
         * This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.
         */
        ACTIVITYDEFINITION, 
        /**
         * The ActorDefinition resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.
         */
        ACTORDEFINITION, 
        /**
         * A medicinal product in the final form which is suitable for administering to a patient (after any mixing of multiple components, dissolution etc. has been performed).
         */
        ADMINISTRABLEPRODUCTDEFINITION, 
        /**
         * An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject. The unintended effects may require additional monitoring, treatment, hospitalization, or may result in death. The AdverseEvent resource also extends to potential or avoided events that could have had such effects. There are two major domains where the AdverseEvent resource is expected to be used. One is in clinical care reported adverse events and the other is in reporting adverse events in clinical  research trial management. Given the differences between these two arenas, we recommend consulting the domain specific implementation guides when implementing the AdverseEvent Resource. The implementation guides include specific extensions, value sets and constraints.
         */
        ADVERSEEVENT, 
        /**
         * Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.
         */
        ALLERGYINTOLERANCE, 
        /**
         * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).
         */
        APPOINTMENT, 
        /**
         * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
         */
        APPOINTMENTRESPONSE, 
        /**
         * This Resource provides one or more comments, classifiers or ratings about a Resource and supports attribution and rights management metadata for the added content.
         */
        ARTIFACTASSESSMENT, 
        /**
         * A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.
         */
        AUDITEVENT, 
        /**
         * Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.
         */
        BASIC, 
        /**
         * A biological material originating from a biological entity intended to be transplanted or infused into another (possibly the same) biological entity.
         */
        BIOLOGICALLYDERIVEDPRODUCT, 
        /**
         * Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.
         */
        BODYSTRUCTURE, 
        /**
         * Common Interface declaration for conformance and knowledge artifact resources.
         */
        CANONICALRESOURCE, 
        /**
         * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server or Client for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        CAPABILITYSTATEMENT, 
        /**
         * Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.
         */
        CAREPLAN, 
        /**
         * The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.
         */
        CARETEAM, 
        /**
         * The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.
         */
        CHARGEITEM, 
        /**
         * The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.
         */
        CHARGEITEMDEFINITION, 
        /**
         * The Citation Resource enables reference to any knowledge artifact for purposes of identification and attribution. The Citation Resource supports existing reference structures and developing publication practices such as versioning, expressing complex contributorship roles, and referencing computable resources.
         */
        CITATION, 
        /**
         * A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.
         */
        CLAIM, 
        /**
         * This resource provides the adjudication details from the processing of a Claim resource.
         */
        CLAIMRESPONSE, 
        /**
         * A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called "ClinicalImpression" rather than "ClinicalAssessment" to avoid confusion with the recording of assessment tools such as Apgar score.
         */
        CLINICALIMPRESSION, 
        /**
         * A single issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.
         */
        CLINICALUSEDEFINITION, 
        /**
         * The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.
         */
        CODESYSTEM, 
        /**
         * A clinical or business level record of information being transmitted or shared; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.
         */
        COMMUNICATION, 
        /**
         * A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.
         */
        COMMUNICATIONREQUEST, 
        /**
         * A compartment definition that defines how resources are accessed on a server.
         */
        COMPARTMENTDEFINITION, 
        /**
         * A set of healthcare-related information that is assembled together into a single logical package that provides a single coherent statement of meaning, establishes its own context and that has clinical attestation with regard to who is making the statement. A Composition defines the structure and narrative content necessary for a document. However, a Composition alone does not constitute a document. Rather, the Composition must be the first entry in a Bundle where Bundle.type=document, and any other resources referenced from Composition must be included as subsequent entries in the Bundle (for example Patient, Practitioner, Encounter, etc.).
         */
        COMPOSITION, 
        /**
         * A statement of relationships from one set of concepts to one or more other concepts - either concepts in code systems, or data element/data element concepts, or classes in class models.
         */
        CONCEPTMAP, 
        /**
         * A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a level of concern.
         */
        CONDITION, 
        /**
         * A definition of a condition and information relevant to managing it.
         */
        CONDITIONDEFINITION, 
        /**
         * A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.
         */
        CONSENT, 
        /**
         * Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement.
         */
        CONTRACT, 
        /**
         * Financial instrument which may be used to reimburse or pay for health care products and services. Includes both insurance and self-payment.
         */
        COVERAGE, 
        /**
         * The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage is valid and in-force and optionally to provide the insurance details of the policy.
         */
        COVERAGEELIGIBILITYREQUEST, 
        /**
         * This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.
         */
        COVERAGEELIGIBILITYRESPONSE, 
        /**
         * Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, etc.
         */
        DETECTEDISSUE, 
        /**
         * This resource describes the properties (regulated, has real time clock, etc.), adminstrative (manufacturer name, model number, serial number, firmware, etc), and type (knee replacement, blood pressure cuff, MRI, etc.) of a physical unit (these values do not change much within a given module, for example the serail number, manufacturer name, and model number). An actual unit may consist of several modules in a distinct hierarchy and these are represented by multiple Device resources and bound through the 'parent' element.
         */
        DEVICE, 
        /**
         * This is a specialized resource that defines the characteristics and capabilities of a device.
         */
        DEVICEDEFINITION, 
        /**
         * Indicates that a device is to be or has been dispensed for a named person/patient.  This includes a description of the product (supply) provided and the instructions for using the device.
         */
        DEVICEDISPENSE, 
        /**
         * Describes a measurement, calculation or setting capability of a medical device.
         */
        DEVICEMETRIC, 
        /**
         * Represents a request a device to be provided to a specific patient. The device may be an implantable device to be subsequently implanted, or an external assistive device, such as a walker, to be delivered and subsequently be used.
         */
        DEVICEREQUEST, 
        /**
         * A record of a device being used by a patient where the record is the result of a report from the patient or a clinician.
         */
        DEVICEUSAGE, 
        /**
         * The findings and interpretation of diagnostic tests performed on patients, groups of patients, products, substances, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports. The report also includes non-clinical context such as batch analysis and stability reporting of products and substances.
         */
        DIAGNOSTICREPORT, 
        /**
         * A collection of documents compiled for a purpose together with metadata that applies to the collection.
         */
        DOCUMENTMANIFEST, 
        /**
         * A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this "document" encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.
         */
        DOCUMENTREFERENCE, 
        /**
         * An interaction between healthcare provider(s), and/or patient(s) for the purpose of providing healthcare service(s) or assessing the health status of patient(s).
         */
        ENCOUNTER, 
        /**
         * The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b, a REST endpoint for another FHIR server, or a s/Mime email address. This may include any security context information.
         */
        ENDPOINT, 
        /**
         * This resource provides the insurance enrollment details to the insurer regarding a specified coverage.
         */
        ENROLLMENTREQUEST, 
        /**
         * This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.
         */
        ENROLLMENTRESPONSE, 
        /**
         * An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.
         */
        EPISODEOFCARE, 
        /**
         * The EventDefinition resource provides a reusable description of when a particular event can occur.
         */
        EVENTDEFINITION, 
        /**
         * The Evidence Resource provides a machine-interpretable expression of an evidence concept including the evidence variables (e.g., population, exposures/interventions, comparators, outcomes, measured variables, confounding variables), the statistics, and the certainty of this evidence.
         */
        EVIDENCE, 
        /**
         * The EvidenceReport Resource is a specialized container for a collection of resources and codeable concepts, adapted to support compositions of Evidence, EvidenceVariable, and Citation resources and related concepts.
         */
        EVIDENCEREPORT, 
        /**
         * The EvidenceVariable resource describes an element that knowledge (Evidence) is about.
         */
        EVIDENCEVARIABLE, 
        /**
         * A walkthrough of a workflow showing the interaction between systems and the instances shared, possibly including the evolution of instances over time.
         */
        EXAMPLESCENARIO, 
        /**
         * This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.
         */
        EXPLANATIONOFBENEFIT, 
        /**
         * Significant health conditions for a person related to the patient relevant in the context of care for the patient.
         */
        FAMILYMEMBERHISTORY, 
        /**
         * Prospective warnings of potential issues when providing care to the patient.
         */
        FLAG, 
        /**
         * This resource describes a product or service that is available through a program and includes the conditions and constraints of availability.  All of the information in this resource is specific to the inclusion of the item in the formulary and is not inherent to the item itself.
         */
        FORMULARYITEM, 
        /**
         * A Genomic Study is a set of analysis performed to analyze and generate genomic data.
         */
        GENOMICSTUDY, 
        /**
         * Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.
         */
        GOAL, 
        /**
         * A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.
         */
        GRAPHDEFINITION, 
        /**
         * Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.
         */
        GROUP, 
        /**
         * A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.
         */
        GUIDANCERESPONSE, 
        /**
         * The details of a healthcare service available at a location or in a catalog.  In the case where there is a hierarchy of services (for example, Lab -> Pathology -> Wound Cultures), this can be represented using a set of linked HealthcareServices.
         */
        HEALTHCARESERVICE, 
        /**
         * A selection of DICOM SOP instances and/or frames within a single Study and Series. This might include additional specifics such as an image region, an Observation UID or a Segmentation Number, allowing linkage to an Observation Resource or transferring this information along with the ImagingStudy Resource.
         */
        IMAGINGSELECTION, 
        /**
         * Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.
         */
        IMAGINGSTUDY, 
        /**
         * Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.
         */
        IMMUNIZATION, 
        /**
         * Describes a comparison of an immunization event against published recommendations to determine if the administration is "valid" in relation to those  recommendations.
         */
        IMMUNIZATIONEVALUATION, 
        /**
         * A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.
         */
        IMMUNIZATIONRECOMMENDATION, 
        /**
         * A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.
         */
        IMPLEMENTATIONGUIDE, 
        /**
         * An ingredient of a manufactured item or pharmaceutical product.
         */
        INGREDIENT, 
        /**
         * Details of a Health Insurance product/plan provided by an organization.
         */
        INSURANCEPLAN, 
        /**
         * A report of inventory or stock items.
         */
        INVENTORYREPORT, 
        /**
         * Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.
         */
        INVOICE, 
        /**
         * The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.
         */
        LIBRARY, 
        /**
         * Identifies two or more records (resource instances) that refer to the same real-world "occurrence".
         */
        LINKAGE, 
        /**
         * A List is a curated collection of resources, for things such as problem lists, allergy lists, facility list, organization list, etc.
         */
        LIST, 
        /**
         * Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.
         */
        LOCATION, 
        /**
         * The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.
         */
        MANUFACTUREDITEMDEFINITION, 
        /**
         * The Measure resource provides the definition of a quality measure.
         */
        MEASURE, 
        /**
         * The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.
         */
        MEASUREREPORT, 
        /**
         * This resource is primarily used for the identification and definition of a medication, including ingredients, for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.
         */
        MEDICATION, 
        /**
         * Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.
         */
        MEDICATIONADMINISTRATION, 
        /**
         * Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.
         */
        MEDICATIONDISPENSE, 
        /**
         * Information about a medication that is used to support knowledge.
         */
        MEDICATIONKNOWLEDGE, 
        /**
         * An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called "MedicationRequest" rather than "MedicationPrescription" or "MedicationOrder" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.
         */
        MEDICATIONREQUEST, 
        /**
         * A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. 

The primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.
         */
        MEDICATIONUSAGE, 
        /**
         * Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use, drug catalogs, to support prescribing, adverse events management etc.).
         */
        MEDICINALPRODUCTDEFINITION, 
        /**
         * Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.
         */
        MESSAGEDEFINITION, 
        /**
         * The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.
         */
        MESSAGEHEADER, 
        /**
         * Common Interface declaration for conformance and knowledge artifact resources.
         */
        METADATARESOURCE, 
        /**
         * Representation of a molecular sequence.
         */
        MOLECULARSEQUENCE, 
        /**
         * A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a "System" used within the Identifier and Coding data types.
         */
        NAMINGSYSTEM, 
        /**
         * A record of food or fluid that is being consumed by a patient.  A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.
         */
        NUTRITIONINTAKE, 
        /**
         * A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.
         */
        NUTRITIONORDER, 
        /**
         * A food or supplement that is consumed by patients.
         */
        NUTRITIONPRODUCT, 
        /**
         * Measurements and simple assertions made about a patient, device or other subject.
         */
        OBSERVATION, 
        /**
         * Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.
         */
        OBSERVATIONDEFINITION, 
        /**
         * A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).
         */
        OPERATIONDEFINITION, 
        /**
         * A collection of error, warning, or information messages that result from a system action.
         */
        OPERATIONOUTCOME, 
        /**
         * A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.
         */
        ORGANIZATION, 
        /**
         * Defines an affiliation/assotiation/relationship between 2 distinct organizations, that is not a part-of relationship/sub-division relationship.
         */
        ORGANIZATIONAFFILIATION, 
        /**
         * A medically related item or items, in a container or package.
         */
        PACKAGEDPRODUCTDEFINITION, 
        /**
         * Demographics and other administrative information about an individual or animal receiving care or other health-related services.
         */
        PATIENT, 
        /**
         * This resource provides the status of the payment for goods and services rendered, and the request and response resource references.
         */
        PAYMENTNOTICE, 
        /**
         * This resource provides the details including amount of a payment and allocates the payment items being paid.
         */
        PAYMENTRECONCILIATION, 
        /**
         * Permission resource holds access rules for a given data and context.
         */
        PERMISSION, 
        /**
         * Demographics and administrative information about a person independent of a specific health-related context.
         */
        PERSON, 
        /**
         * This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical and non-clinical artifacts such as clinical decision support rules, order sets, protocols, and drug quality specifications.
         */
        PLANDEFINITION, 
        /**
         * A person who is directly or indirectly involved in the provisioning of healthcare or related services.
         */
        PRACTITIONER, 
        /**
         * A specific set of Roles/Locations/specialties/services that a practitioner may perform, or has performed at an organization during a period of time.
         */
        PRACTITIONERROLE, 
        /**
         * An action that is or was performed on or for a patient, practitioner, device, organization, or location. For example, this can be a physical intervention on a patient like an operation, or less invasive like long term services, counseling, or hypnotherapy.  This can be a quality or safety inspection for a location, organization, or device.  This can be an accreditation procedure on a practitioner for licensing.
         */
        PROCEDURE, 
        /**
         * Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.
         */
        PROVENANCE, 
        /**
         * A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.
         */
        QUESTIONNAIRE, 
        /**
         * A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.
         */
        QUESTIONNAIRERESPONSE, 
        /**
         * Regulatory approval, clearance or licencing related to a regulated product, treatment, facility or activity that is cited in a guidance, regulation, rule or legislative act. An example is Market Authorization relating to a Medicinal Product.
         */
        REGULATEDAUTHORIZATION, 
        /**
         * Information about a person that is involved in a patient's health or the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.
         */
        RELATEDPERSON, 
        /**
         * A set of related requests that can be used to capture intended activities that have inter-dependencies such as "give this medication after that one".
         */
        REQUESTORCHESTRATION, 
        /**
         * The Requirements resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.
         */
        REQUIREMENTS, 
        /**
         * A scientific study of nature that sometimes includes processes involved in health and disease. For example, clinical trials are research studies that involve people. These studies may be related to new ways to screen, prevent, diagnose, and treat disease. They may also study certain outcomes and certain groups of people by looking at data collected in the past or future.
         */
        RESEARCHSTUDY, 
        /**
         * A physical entity which is the primary unit of operational and/or administrative interest in a study.
         */
        RESEARCHSUBJECT, 
        /**
         * An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.
         */
        RISKASSESSMENT, 
        /**
         * A container for slots of time that may be available for booking appointments.
         */
        SCHEDULE, 
        /**
         * A search parameter that defines a named search item that can be used to search/filter on a resource.
         */
        SEARCHPARAMETER, 
        /**
         * A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.
         */
        SERVICEREQUEST, 
        /**
         * A slot of time on a schedule that may be available for booking appointments.
         */
        SLOT, 
        /**
         * A sample to be used for analysis.
         */
        SPECIMEN, 
        /**
         * A kind of specimen with associated set of requirements.
         */
        SPECIMENDEFINITION, 
        /**
         * A definition of a FHIR structure. This resource is used to describe the underlying resources, data types defined in FHIR, and also for describing extensions and constraints on resources and data types.
         */
        STRUCTUREDEFINITION, 
        /**
         * A Map of relationships between 2 structures that can be used to transform data.
         */
        STRUCTUREMAP, 
        /**
         * The subscription resource describes a particular client's request to be notified about a SubscriptionTopic.
         */
        SUBSCRIPTION, 
        /**
         * The SubscriptionStatus resource describes the state of a Subscription during notifications. It is not persisted.
         */
        SUBSCRIPTIONSTATUS, 
        /**
         * Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.
         */
        SUBSCRIPTIONTOPIC, 
        /**
         * A homogeneous material with a definite composition.
         */
        SUBSTANCE, 
        /**
         * The detailed description of a substance, typically at a level beyond what is used for prescribing.
         */
        SUBSTANCEDEFINITION, 
        /**
         * Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.
         */
        SUBSTANCENUCLEICACID, 
        /**
         * Properties of a substance specific to it being a polymer.
         */
        SUBSTANCEPOLYMER, 
        /**
         * A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.
         */
        SUBSTANCEPROTEIN, 
        /**
         * Todo.
         */
        SUBSTANCEREFERENCEINFORMATION, 
        /**
         * Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.
         */
        SUBSTANCESOURCEMATERIAL, 
        /**
         * Record of delivery of what is supplied.
         */
        SUPPLYDELIVERY, 
        /**
         * A record of a non-patient specific request for a medication, substance, device, certain types of biologically derived product, and nutrition product used in the healthcare setting.
         */
        SUPPLYREQUEST, 
        /**
         * A task to be performed.
         */
        TASK, 
        /**
         * A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        TERMINOLOGYCAPABILITIES, 
        /**
         * A summary of information based on the results of executing a TestScript.
         */
        TESTREPORT, 
        /**
         * A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.
         */
        TESTSCRIPT, 
        /**
         * Record of transport.
         */
        TRANSPORT, 
        /**
         * A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).
         */
        VALUESET, 
        /**
         * Describes validation requirements, source(s), status and dates for one or more elements.
         */
        VERIFICATIONRESULT, 
        /**
         * An authorization for the provision of glasses and/or contact lenses to a patient.
         */
        VISIONPRESCRIPTION, 
        /**
         * This resource is used to pass information into and back from an operation (whether invoked directly from REST or within a messaging environment).  It is not persisted or allowed to be referenced by other resources except as described in the definition of the Parameters resource.
         */
        PARAMETERS, 
        /**
         * added to help the parsers
         */
        NULL;
        public static FHIRTypes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Base".equals(codeString))
          return BASE;
        if ("Element".equals(codeString))
          return ELEMENT;
        if ("BackboneElement".equals(codeString))
          return BACKBONEELEMENT;
        if ("DataType".equals(codeString))
          return DATATYPE;
        if ("Address".equals(codeString))
          return ADDRESS;
        if ("Annotation".equals(codeString))
          return ANNOTATION;
        if ("Attachment".equals(codeString))
          return ATTACHMENT;
        if ("Availability".equals(codeString))
          return AVAILABILITY;
        if ("BackboneType".equals(codeString))
          return BACKBONETYPE;
        if ("Dosage".equals(codeString))
          return DOSAGE;
        if ("ElementDefinition".equals(codeString))
          return ELEMENTDEFINITION;
        if ("MarketingStatus".equals(codeString))
          return MARKETINGSTATUS;
        if ("Population".equals(codeString))
          return POPULATION;
        if ("ProductShelfLife".equals(codeString))
          return PRODUCTSHELFLIFE;
        if ("Timing".equals(codeString))
          return TIMING;
        if ("CodeableConcept".equals(codeString))
          return CODEABLECONCEPT;
        if ("CodeableReference".equals(codeString))
          return CODEABLEREFERENCE;
        if ("Coding".equals(codeString))
          return CODING;
        if ("ContactDetail".equals(codeString))
          return CONTACTDETAIL;
        if ("ContactPoint".equals(codeString))
          return CONTACTPOINT;
        if ("Contributor".equals(codeString))
          return CONTRIBUTOR;
        if ("DataRequirement".equals(codeString))
          return DATAREQUIREMENT;
        if ("Expression".equals(codeString))
          return EXPRESSION;
        if ("ExtendedContactDetail".equals(codeString))
          return EXTENDEDCONTACTDETAIL;
        if ("Extension".equals(codeString))
          return EXTENSION;
        if ("HumanName".equals(codeString))
          return HUMANNAME;
        if ("Identifier".equals(codeString))
          return IDENTIFIER;
        if ("Meta".equals(codeString))
          return META;
        if ("MonetaryComponent".equals(codeString))
          return MONETARYCOMPONENT;
        if ("Money".equals(codeString))
          return MONEY;
        if ("Narrative".equals(codeString))
          return NARRATIVE;
        if ("ParameterDefinition".equals(codeString))
          return PARAMETERDEFINITION;
        if ("Period".equals(codeString))
          return PERIOD;
        if ("PrimitiveType".equals(codeString))
          return PRIMITIVETYPE;
        if ("base64Binary".equals(codeString))
          return BASE64BINARY;
        if ("boolean".equals(codeString))
          return BOOLEAN;
        if ("date".equals(codeString))
          return DATE;
        if ("dateTime".equals(codeString))
          return DATETIME;
        if ("decimal".equals(codeString))
          return DECIMAL;
        if ("instant".equals(codeString))
          return INSTANT;
        if ("integer".equals(codeString))
          return INTEGER;
        if ("positiveInt".equals(codeString))
          return POSITIVEINT;
        if ("unsignedInt".equals(codeString))
          return UNSIGNEDINT;
        if ("integer64".equals(codeString))
          return INTEGER64;
        if ("string".equals(codeString))
          return STRING;
        if ("code".equals(codeString))
          return CODE;
        if ("id".equals(codeString))
          return ID;
        if ("markdown".equals(codeString))
          return MARKDOWN;
        if ("time".equals(codeString))
          return TIME;
        if ("uri".equals(codeString))
          return URI;
        if ("canonical".equals(codeString))
          return CANONICAL;
        if ("oid".equals(codeString))
          return OID;
        if ("url".equals(codeString))
          return URL;
        if ("uuid".equals(codeString))
          return UUID;
        if ("Quantity".equals(codeString))
          return QUANTITY;
        if ("Age".equals(codeString))
          return AGE;
        if ("Count".equals(codeString))
          return COUNT;
        if ("Distance".equals(codeString))
          return DISTANCE;
        if ("Duration".equals(codeString))
          return DURATION;
        if ("Range".equals(codeString))
          return RANGE;
        if ("Ratio".equals(codeString))
          return RATIO;
        if ("RatioRange".equals(codeString))
          return RATIORANGE;
        if ("Reference".equals(codeString))
          return REFERENCE;
        if ("RelatedArtifact".equals(codeString))
          return RELATEDARTIFACT;
        if ("SampledData".equals(codeString))
          return SAMPLEDDATA;
        if ("Signature".equals(codeString))
          return SIGNATURE;
        if ("TriggerDefinition".equals(codeString))
          return TRIGGERDEFINITION;
        if ("UsageContext".equals(codeString))
          return USAGECONTEXT;
        if ("VirtualServiceDetail".equals(codeString))
          return VIRTUALSERVICEDETAIL;
        if ("xhtml".equals(codeString))
          return XHTML;
        if ("Resource".equals(codeString))
          return RESOURCE;
        if ("Binary".equals(codeString))
          return BINARY;
        if ("Bundle".equals(codeString))
          return BUNDLE;
        if ("DomainResource".equals(codeString))
          return DOMAINRESOURCE;
        if ("Account".equals(codeString))
          return ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return ACTIVITYDEFINITION;
        if ("ActorDefinition".equals(codeString))
          return ACTORDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return APPOINTMENTRESPONSE;
        if ("ArtifactAssessment".equals(codeString))
          return ARTIFACTASSESSMENT;
        if ("AuditEvent".equals(codeString))
          return AUDITEVENT;
        if ("Basic".equals(codeString))
          return BASIC;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return BODYSTRUCTURE;
        if ("CanonicalResource".equals(codeString))
          return CANONICALRESOURCE;
        if ("CapabilityStatement".equals(codeString))
          return CAPABILITYSTATEMENT;
        if ("CarePlan".equals(codeString))
          return CAREPLAN;
        if ("CareTeam".equals(codeString))
          return CARETEAM;
        if ("ChargeItem".equals(codeString))
          return CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return CHARGEITEMDEFINITION;
        if ("Citation".equals(codeString))
          return CITATION;
        if ("Claim".equals(codeString))
          return CLAIM;
        if ("ClaimResponse".equals(codeString))
          return CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return CLINICALIMPRESSION;
        if ("ClinicalUseDefinition".equals(codeString))
          return CLINICALUSEDEFINITION;
        if ("CodeSystem".equals(codeString))
          return CODESYSTEM;
        if ("Communication".equals(codeString))
          return COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return CONCEPTMAP;
        if ("Condition".equals(codeString))
          return CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return CONSENT;
        if ("Contract".equals(codeString))
          return CONTRACT;
        if ("Coverage".equals(codeString))
          return COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return DETECTEDISSUE;
        if ("Device".equals(codeString))
          return DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return DEVICEDEFINITION;
        if ("DeviceDispense".equals(codeString))
          return DEVICEDISPENSE;
        if ("DeviceMetric".equals(codeString))
          return DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return DEVICEREQUEST;
        if ("DeviceUsage".equals(codeString))
          return DEVICEUSAGE;
        if ("DiagnosticReport".equals(codeString))
          return DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return DOCUMENTREFERENCE;
        if ("Encounter".equals(codeString))
          return ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return EVIDENCE;
        if ("EvidenceReport".equals(codeString))
          return EVIDENCEREPORT;
        if ("EvidenceVariable".equals(codeString))
          return EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return FLAG;
        if ("FormularyItem".equals(codeString))
          return FORMULARYITEM;
        if ("GenomicStudy".equals(codeString))
          return GENOMICSTUDY;
        if ("Goal".equals(codeString))
          return GOAL;
        if ("GraphDefinition".equals(codeString))
          return GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return GROUP;
        if ("GuidanceResponse".equals(codeString))
          return GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return HEALTHCARESERVICE;
        if ("ImagingSelection".equals(codeString))
          return IMAGINGSELECTION;
        if ("ImagingStudy".equals(codeString))
          return IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return INSURANCEPLAN;
        if ("InventoryReport".equals(codeString))
          return INVENTORYREPORT;
        if ("Invoice".equals(codeString))
          return INVOICE;
        if ("Library".equals(codeString))
          return LIBRARY;
        if ("Linkage".equals(codeString))
          return LINKAGE;
        if ("List".equals(codeString))
          return LIST;
        if ("Location".equals(codeString))
          return LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return MEASURE;
        if ("MeasureReport".equals(codeString))
          return MEASUREREPORT;
        if ("Medication".equals(codeString))
          return MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return MESSAGEHEADER;
        if ("MetadataResource".equals(codeString))
          return METADATARESOURCE;
        if ("MolecularSequence".equals(codeString))
          return MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return NUTRITIONORDER;
        if ("NutritionProduct".equals(codeString))
          return NUTRITIONPRODUCT;
        if ("Observation".equals(codeString))
          return OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return PACKAGEDPRODUCTDEFINITION;
        if ("Patient".equals(codeString))
          return PATIENT;
        if ("PaymentNotice".equals(codeString))
          return PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return PAYMENTRECONCILIATION;
        if ("Permission".equals(codeString))
          return PERMISSION;
        if ("Person".equals(codeString))
          return PERSON;
        if ("PlanDefinition".equals(codeString))
          return PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return PROCEDURE;
        if ("Provenance".equals(codeString))
          return PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return RELATEDPERSON;
        if ("RequestOrchestration".equals(codeString))
          return REQUESTORCHESTRATION;
        if ("Requirements".equals(codeString))
          return REQUIREMENTS;
        if ("ResearchStudy".equals(codeString))
          return RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return RESEARCHSUBJECT;
        if ("RiskAssessment".equals(codeString))
          return RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return SLOT;
        if ("Specimen".equals(codeString))
          return SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return SUBSCRIPTION;
        if ("SubscriptionStatus".equals(codeString))
          return SUBSCRIPTIONSTATUS;
        if ("SubscriptionTopic".equals(codeString))
          return SUBSCRIPTIONTOPIC;
        if ("Substance".equals(codeString))
          return SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return TESTREPORT;
        if ("TestScript".equals(codeString))
          return TESTSCRIPT;
        if ("Transport".equals(codeString))
          return TRANSPORT;
        if ("ValueSet".equals(codeString))
          return VALUESET;
        if ("VerificationResult".equals(codeString))
          return VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return VISIONPRESCRIPTION;
        if ("Parameters".equals(codeString))
          return PARAMETERS;
        if ("Any".equals(codeString))
          return RESOURCE;
        throw new FHIRException("Unknown FHIRTypes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case BASE: return "Base";
            case ELEMENT: return "Element";
            case BACKBONEELEMENT: return "BackboneElement";
            case DATATYPE: return "DataType";
            case ADDRESS: return "Address";
            case ANNOTATION: return "Annotation";
            case ATTACHMENT: return "Attachment";
            case AVAILABILITY: return "Availability";
            case BACKBONETYPE: return "BackboneType";
            case DOSAGE: return "Dosage";
            case ELEMENTDEFINITION: return "ElementDefinition";
            case MARKETINGSTATUS: return "MarketingStatus";
            case POPULATION: return "Population";
            case PRODUCTSHELFLIFE: return "ProductShelfLife";
            case TIMING: return "Timing";
            case CODEABLECONCEPT: return "CodeableConcept";
            case CODEABLEREFERENCE: return "CodeableReference";
            case CODING: return "Coding";
            case CONTACTDETAIL: return "ContactDetail";
            case CONTACTPOINT: return "ContactPoint";
            case CONTRIBUTOR: return "Contributor";
            case DATAREQUIREMENT: return "DataRequirement";
            case EXPRESSION: return "Expression";
            case EXTENDEDCONTACTDETAIL: return "ExtendedContactDetail";
            case EXTENSION: return "Extension";
            case HUMANNAME: return "HumanName";
            case IDENTIFIER: return "Identifier";
            case META: return "Meta";
            case MONETARYCOMPONENT: return "MonetaryComponent";
            case MONEY: return "Money";
            case NARRATIVE: return "Narrative";
            case PARAMETERDEFINITION: return "ParameterDefinition";
            case PERIOD: return "Period";
            case PRIMITIVETYPE: return "PrimitiveType";
            case BASE64BINARY: return "base64Binary";
            case BOOLEAN: return "boolean";
            case DATE: return "date";
            case DATETIME: return "dateTime";
            case DECIMAL: return "decimal";
            case INSTANT: return "instant";
            case INTEGER: return "integer";
            case POSITIVEINT: return "positiveInt";
            case UNSIGNEDINT: return "unsignedInt";
            case INTEGER64: return "integer64";
            case STRING: return "string";
            case CODE: return "code";
            case ID: return "id";
            case MARKDOWN: return "markdown";
            case TIME: return "time";
            case URI: return "uri";
            case CANONICAL: return "canonical";
            case OID: return "oid";
            case URL: return "url";
            case UUID: return "uuid";
            case QUANTITY: return "Quantity";
            case AGE: return "Age";
            case COUNT: return "Count";
            case DISTANCE: return "Distance";
            case DURATION: return "Duration";
            case RANGE: return "Range";
            case RATIO: return "Ratio";
            case RATIORANGE: return "RatioRange";
            case REFERENCE: return "Reference";
            case RELATEDARTIFACT: return "RelatedArtifact";
            case SAMPLEDDATA: return "SampledData";
            case SIGNATURE: return "Signature";
            case TRIGGERDEFINITION: return "TriggerDefinition";
            case USAGECONTEXT: return "UsageContext";
            case VIRTUALSERVICEDETAIL: return "VirtualServiceDetail";
            case XHTML: return "xhtml";
            case RESOURCE: return "Resource";
            case BINARY: return "Binary";
            case BUNDLE: return "Bundle";
            case DOMAINRESOURCE: return "DomainResource";
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ACTORDEFINITION: return "ActorDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case ARTIFACTASSESSMENT: return "ArtifactAssessment";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case CANONICALRESOURCE: return "CanonicalResource";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CITATION: return "Citation";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEDEFINITION: return "ClinicalUseDefinition";
            case CODESYSTEM: return "CodeSystem";
            case COMMUNICATION: return "Communication";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case COMPARTMENTDEFINITION: return "CompartmentDefinition";
            case COMPOSITION: return "Composition";
            case CONCEPTMAP: return "ConceptMap";
            case CONDITION: return "Condition";
            case CONDITIONDEFINITION: return "ConditionDefinition";
            case CONSENT: return "Consent";
            case CONTRACT: return "Contract";
            case COVERAGE: return "Coverage";
            case COVERAGEELIGIBILITYREQUEST: return "CoverageEligibilityRequest";
            case COVERAGEELIGIBILITYRESPONSE: return "CoverageEligibilityResponse";
            case DETECTEDISSUE: return "DetectedIssue";
            case DEVICE: return "Device";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case DEVICEDISPENSE: return "DeviceDispense";
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSAGE: return "DeviceUsage";
            case DIAGNOSTICREPORT: return "DiagnosticReport";
            case DOCUMENTMANIFEST: return "DocumentManifest";
            case DOCUMENTREFERENCE: return "DocumentReference";
            case ENCOUNTER: return "Encounter";
            case ENDPOINT: return "Endpoint";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case ENROLLMENTRESPONSE: return "EnrollmentResponse";
            case EPISODEOFCARE: return "EpisodeOfCare";
            case EVENTDEFINITION: return "EventDefinition";
            case EVIDENCE: return "Evidence";
            case EVIDENCEREPORT: return "EvidenceReport";
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case FORMULARYITEM: return "FormularyItem";
            case GENOMICSTUDY: return "GenomicStudy";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSELECTION: return "ImagingSelection";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
            case INVENTORYREPORT: return "InventoryReport";
            case INVOICE: return "Invoice";
            case LIBRARY: return "Library";
            case LINKAGE: return "Linkage";
            case LIST: return "List";
            case LOCATION: return "Location";
            case MANUFACTUREDITEMDEFINITION: return "ManufacturedItemDefinition";
            case MEASURE: return "Measure";
            case MEASUREREPORT: return "MeasureReport";
            case MEDICATION: return "Medication";
            case MEDICATIONADMINISTRATION: return "MedicationAdministration";
            case MEDICATIONDISPENSE: return "MedicationDispense";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case MEDICATIONUSAGE: return "MedicationUsage";
            case MEDICINALPRODUCTDEFINITION: return "MedicinalProductDefinition";
            case MESSAGEDEFINITION: return "MessageDefinition";
            case MESSAGEHEADER: return "MessageHeader";
            case METADATARESOURCE: return "MetadataResource";
            case MOLECULARSEQUENCE: return "MolecularSequence";
            case NAMINGSYSTEM: return "NamingSystem";
            case NUTRITIONINTAKE: return "NutritionIntake";
            case NUTRITIONORDER: return "NutritionOrder";
            case NUTRITIONPRODUCT: return "NutritionProduct";
            case OBSERVATION: return "Observation";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case OPERATIONDEFINITION: return "OperationDefinition";
            case OPERATIONOUTCOME: return "OperationOutcome";
            case ORGANIZATION: return "Organization";
            case ORGANIZATIONAFFILIATION: return "OrganizationAffiliation";
            case PACKAGEDPRODUCTDEFINITION: return "PackagedProductDefinition";
            case PATIENT: return "Patient";
            case PAYMENTNOTICE: return "PaymentNotice";
            case PAYMENTRECONCILIATION: return "PaymentReconciliation";
            case PERMISSION: return "Permission";
            case PERSON: return "Person";
            case PLANDEFINITION: return "PlanDefinition";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case PROCEDURE: return "Procedure";
            case PROVENANCE: return "Provenance";
            case QUESTIONNAIRE: return "Questionnaire";
            case QUESTIONNAIRERESPONSE: return "QuestionnaireResponse";
            case REGULATEDAUTHORIZATION: return "RegulatedAuthorization";
            case RELATEDPERSON: return "RelatedPerson";
            case REQUESTORCHESTRATION: return "RequestOrchestration";
            case REQUIREMENTS: return "Requirements";
            case RESEARCHSTUDY: return "ResearchStudy";
            case RESEARCHSUBJECT: return "ResearchSubject";
            case RISKASSESSMENT: return "RiskAssessment";
            case SCHEDULE: return "Schedule";
            case SEARCHPARAMETER: return "SearchParameter";
            case SERVICEREQUEST: return "ServiceRequest";
            case SLOT: return "Slot";
            case SPECIMEN: return "Specimen";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case STRUCTUREDEFINITION: return "StructureDefinition";
            case STRUCTUREMAP: return "StructureMap";
            case SUBSCRIPTION: return "Subscription";
            case SUBSCRIPTIONSTATUS: return "SubscriptionStatus";
            case SUBSCRIPTIONTOPIC: return "SubscriptionTopic";
            case SUBSTANCE: return "Substance";
            case SUBSTANCEDEFINITION: return "SubstanceDefinition";
            case SUBSTANCENUCLEICACID: return "SubstanceNucleicAcid";
            case SUBSTANCEPOLYMER: return "SubstancePolymer";
            case SUBSTANCEPROTEIN: return "SubstanceProtein";
            case SUBSTANCEREFERENCEINFORMATION: return "SubstanceReferenceInformation";
            case SUBSTANCESOURCEMATERIAL: return "SubstanceSourceMaterial";
            case SUPPLYDELIVERY: return "SupplyDelivery";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case TERMINOLOGYCAPABILITIES: return "TerminologyCapabilities";
            case TESTREPORT: return "TestReport";
            case TESTSCRIPT: return "TestScript";
            case TRANSPORT: return "Transport";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            case PARAMETERS: return "Parameters";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case BASE: return "http://hl7.org/fhir/fhir-types";
            case ELEMENT: return "http://hl7.org/fhir/fhir-types";
            case BACKBONEELEMENT: return "http://hl7.org/fhir/fhir-types";
            case DATATYPE: return "http://hl7.org/fhir/fhir-types";
            case ADDRESS: return "http://hl7.org/fhir/fhir-types";
            case ANNOTATION: return "http://hl7.org/fhir/fhir-types";
            case ATTACHMENT: return "http://hl7.org/fhir/fhir-types";
            case AVAILABILITY: return "http://hl7.org/fhir/fhir-types";
            case BACKBONETYPE: return "http://hl7.org/fhir/fhir-types";
            case DOSAGE: return "http://hl7.org/fhir/fhir-types";
            case ELEMENTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case MARKETINGSTATUS: return "http://hl7.org/fhir/fhir-types";
            case POPULATION: return "http://hl7.org/fhir/fhir-types";
            case PRODUCTSHELFLIFE: return "http://hl7.org/fhir/fhir-types";
            case TIMING: return "http://hl7.org/fhir/fhir-types";
            case CODEABLECONCEPT: return "http://hl7.org/fhir/fhir-types";
            case CODEABLEREFERENCE: return "http://hl7.org/fhir/fhir-types";
            case CODING: return "http://hl7.org/fhir/fhir-types";
            case CONTACTDETAIL: return "http://hl7.org/fhir/fhir-types";
            case CONTACTPOINT: return "http://hl7.org/fhir/fhir-types";
            case CONTRIBUTOR: return "http://hl7.org/fhir/fhir-types";
            case DATAREQUIREMENT: return "http://hl7.org/fhir/fhir-types";
            case EXPRESSION: return "http://hl7.org/fhir/fhir-types";
            case EXTENDEDCONTACTDETAIL: return "http://hl7.org/fhir/fhir-types";
            case EXTENSION: return "http://hl7.org/fhir/fhir-types";
            case HUMANNAME: return "http://hl7.org/fhir/fhir-types";
            case IDENTIFIER: return "http://hl7.org/fhir/fhir-types";
            case META: return "http://hl7.org/fhir/fhir-types";
            case MONETARYCOMPONENT: return "http://hl7.org/fhir/fhir-types";
            case MONEY: return "http://hl7.org/fhir/fhir-types";
            case NARRATIVE: return "http://hl7.org/fhir/fhir-types";
            case PARAMETERDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case PERIOD: return "http://hl7.org/fhir/fhir-types";
            case PRIMITIVETYPE: return "http://hl7.org/fhir/fhir-types";
            case BASE64BINARY: return "http://hl7.org/fhir/fhir-types";
            case BOOLEAN: return "http://hl7.org/fhir/fhir-types";
            case DATE: return "http://hl7.org/fhir/fhir-types";
            case DATETIME: return "http://hl7.org/fhir/fhir-types";
            case DECIMAL: return "http://hl7.org/fhir/fhir-types";
            case INSTANT: return "http://hl7.org/fhir/fhir-types";
            case INTEGER: return "http://hl7.org/fhir/fhir-types";
            case POSITIVEINT: return "http://hl7.org/fhir/fhir-types";
            case UNSIGNEDINT: return "http://hl7.org/fhir/fhir-types";
            case INTEGER64: return "http://hl7.org/fhir/fhir-types";
            case STRING: return "http://hl7.org/fhir/fhir-types";
            case CODE: return "http://hl7.org/fhir/fhir-types";
            case ID: return "http://hl7.org/fhir/fhir-types";
            case MARKDOWN: return "http://hl7.org/fhir/fhir-types";
            case TIME: return "http://hl7.org/fhir/fhir-types";
            case URI: return "http://hl7.org/fhir/fhir-types";
            case CANONICAL: return "http://hl7.org/fhir/fhir-types";
            case OID: return "http://hl7.org/fhir/fhir-types";
            case URL: return "http://hl7.org/fhir/fhir-types";
            case UUID: return "http://hl7.org/fhir/fhir-types";
            case QUANTITY: return "http://hl7.org/fhir/fhir-types";
            case AGE: return "http://hl7.org/fhir/fhir-types";
            case COUNT: return "http://hl7.org/fhir/fhir-types";
            case DISTANCE: return "http://hl7.org/fhir/fhir-types";
            case DURATION: return "http://hl7.org/fhir/fhir-types";
            case RANGE: return "http://hl7.org/fhir/fhir-types";
            case RATIO: return "http://hl7.org/fhir/fhir-types";
            case RATIORANGE: return "http://hl7.org/fhir/fhir-types";
            case REFERENCE: return "http://hl7.org/fhir/fhir-types";
            case RELATEDARTIFACT: return "http://hl7.org/fhir/fhir-types";
            case SAMPLEDDATA: return "http://hl7.org/fhir/fhir-types";
            case SIGNATURE: return "http://hl7.org/fhir/fhir-types";
            case TRIGGERDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case USAGECONTEXT: return "http://hl7.org/fhir/fhir-types";
            case VIRTUALSERVICEDETAIL: return "http://hl7.org/fhir/fhir-types";
            case XHTML: return "http://hl7.org/fhir/fhir-types";
            case RESOURCE: return "http://hl7.org/fhir/fhir-types";
            case BINARY: return "http://hl7.org/fhir/fhir-types";
            case BUNDLE: return "http://hl7.org/fhir/fhir-types";
            case DOMAINRESOURCE: return "http://hl7.org/fhir/fhir-types";
            case ACCOUNT: return "http://hl7.org/fhir/fhir-types";
            case ACTIVITYDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case ACTORDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case ADMINISTRABLEPRODUCTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case ADVERSEEVENT: return "http://hl7.org/fhir/fhir-types";
            case ALLERGYINTOLERANCE: return "http://hl7.org/fhir/fhir-types";
            case APPOINTMENT: return "http://hl7.org/fhir/fhir-types";
            case APPOINTMENTRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case ARTIFACTASSESSMENT: return "http://hl7.org/fhir/fhir-types";
            case AUDITEVENT: return "http://hl7.org/fhir/fhir-types";
            case BASIC: return "http://hl7.org/fhir/fhir-types";
            case BIOLOGICALLYDERIVEDPRODUCT: return "http://hl7.org/fhir/fhir-types";
            case BODYSTRUCTURE: return "http://hl7.org/fhir/fhir-types";
            case CANONICALRESOURCE: return "http://hl7.org/fhir/fhir-types";
            case CAPABILITYSTATEMENT: return "http://hl7.org/fhir/fhir-types";
            case CAREPLAN: return "http://hl7.org/fhir/fhir-types";
            case CARETEAM: return "http://hl7.org/fhir/fhir-types";
            case CHARGEITEM: return "http://hl7.org/fhir/fhir-types";
            case CHARGEITEMDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case CITATION: return "http://hl7.org/fhir/fhir-types";
            case CLAIM: return "http://hl7.org/fhir/fhir-types";
            case CLAIMRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case CLINICALIMPRESSION: return "http://hl7.org/fhir/fhir-types";
            case CLINICALUSEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case CODESYSTEM: return "http://hl7.org/fhir/fhir-types";
            case COMMUNICATION: return "http://hl7.org/fhir/fhir-types";
            case COMMUNICATIONREQUEST: return "http://hl7.org/fhir/fhir-types";
            case COMPARTMENTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case COMPOSITION: return "http://hl7.org/fhir/fhir-types";
            case CONCEPTMAP: return "http://hl7.org/fhir/fhir-types";
            case CONDITION: return "http://hl7.org/fhir/fhir-types";
            case CONDITIONDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case CONSENT: return "http://hl7.org/fhir/fhir-types";
            case CONTRACT: return "http://hl7.org/fhir/fhir-types";
            case COVERAGE: return "http://hl7.org/fhir/fhir-types";
            case COVERAGEELIGIBILITYREQUEST: return "http://hl7.org/fhir/fhir-types";
            case COVERAGEELIGIBILITYRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case DETECTEDISSUE: return "http://hl7.org/fhir/fhir-types";
            case DEVICE: return "http://hl7.org/fhir/fhir-types";
            case DEVICEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case DEVICEDISPENSE: return "http://hl7.org/fhir/fhir-types";
            case DEVICEMETRIC: return "http://hl7.org/fhir/fhir-types";
            case DEVICEREQUEST: return "http://hl7.org/fhir/fhir-types";
            case DEVICEUSAGE: return "http://hl7.org/fhir/fhir-types";
            case DIAGNOSTICREPORT: return "http://hl7.org/fhir/fhir-types";
            case DOCUMENTMANIFEST: return "http://hl7.org/fhir/fhir-types";
            case DOCUMENTREFERENCE: return "http://hl7.org/fhir/fhir-types";
            case ENCOUNTER: return "http://hl7.org/fhir/fhir-types";
            case ENDPOINT: return "http://hl7.org/fhir/fhir-types";
            case ENROLLMENTREQUEST: return "http://hl7.org/fhir/fhir-types";
            case ENROLLMENTRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case EPISODEOFCARE: return "http://hl7.org/fhir/fhir-types";
            case EVENTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case EVIDENCE: return "http://hl7.org/fhir/fhir-types";
            case EVIDENCEREPORT: return "http://hl7.org/fhir/fhir-types";
            case EVIDENCEVARIABLE: return "http://hl7.org/fhir/fhir-types";
            case EXAMPLESCENARIO: return "http://hl7.org/fhir/fhir-types";
            case EXPLANATIONOFBENEFIT: return "http://hl7.org/fhir/fhir-types";
            case FAMILYMEMBERHISTORY: return "http://hl7.org/fhir/fhir-types";
            case FLAG: return "http://hl7.org/fhir/fhir-types";
            case FORMULARYITEM: return "http://hl7.org/fhir/fhir-types";
            case GENOMICSTUDY: return "http://hl7.org/fhir/fhir-types";
            case GOAL: return "http://hl7.org/fhir/fhir-types";
            case GRAPHDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case GROUP: return "http://hl7.org/fhir/fhir-types";
            case GUIDANCERESPONSE: return "http://hl7.org/fhir/fhir-types";
            case HEALTHCARESERVICE: return "http://hl7.org/fhir/fhir-types";
            case IMAGINGSELECTION: return "http://hl7.org/fhir/fhir-types";
            case IMAGINGSTUDY: return "http://hl7.org/fhir/fhir-types";
            case IMMUNIZATION: return "http://hl7.org/fhir/fhir-types";
            case IMMUNIZATIONEVALUATION: return "http://hl7.org/fhir/fhir-types";
            case IMMUNIZATIONRECOMMENDATION: return "http://hl7.org/fhir/fhir-types";
            case IMPLEMENTATIONGUIDE: return "http://hl7.org/fhir/fhir-types";
            case INGREDIENT: return "http://hl7.org/fhir/fhir-types";
            case INSURANCEPLAN: return "http://hl7.org/fhir/fhir-types";
            case INVENTORYREPORT: return "http://hl7.org/fhir/fhir-types";
            case INVOICE: return "http://hl7.org/fhir/fhir-types";
            case LIBRARY: return "http://hl7.org/fhir/fhir-types";
            case LINKAGE: return "http://hl7.org/fhir/fhir-types";
            case LIST: return "http://hl7.org/fhir/fhir-types";
            case LOCATION: return "http://hl7.org/fhir/fhir-types";
            case MANUFACTUREDITEMDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case MEASURE: return "http://hl7.org/fhir/fhir-types";
            case MEASUREREPORT: return "http://hl7.org/fhir/fhir-types";
            case MEDICATION: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONADMINISTRATION: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONDISPENSE: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONKNOWLEDGE: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONREQUEST: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONUSAGE: return "http://hl7.org/fhir/fhir-types";
            case MEDICINALPRODUCTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case MESSAGEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case MESSAGEHEADER: return "http://hl7.org/fhir/fhir-types";
            case METADATARESOURCE: return "http://hl7.org/fhir/fhir-types";
            case MOLECULARSEQUENCE: return "http://hl7.org/fhir/fhir-types";
            case NAMINGSYSTEM: return "http://hl7.org/fhir/fhir-types";
            case NUTRITIONINTAKE: return "http://hl7.org/fhir/fhir-types";
            case NUTRITIONORDER: return "http://hl7.org/fhir/fhir-types";
            case NUTRITIONPRODUCT: return "http://hl7.org/fhir/fhir-types";
            case OBSERVATION: return "http://hl7.org/fhir/fhir-types";
            case OBSERVATIONDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case OPERATIONDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case OPERATIONOUTCOME: return "http://hl7.org/fhir/fhir-types";
            case ORGANIZATION: return "http://hl7.org/fhir/fhir-types";
            case ORGANIZATIONAFFILIATION: return "http://hl7.org/fhir/fhir-types";
            case PACKAGEDPRODUCTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case PATIENT: return "http://hl7.org/fhir/fhir-types";
            case PAYMENTNOTICE: return "http://hl7.org/fhir/fhir-types";
            case PAYMENTRECONCILIATION: return "http://hl7.org/fhir/fhir-types";
            case PERMISSION: return "http://hl7.org/fhir/fhir-types";
            case PERSON: return "http://hl7.org/fhir/fhir-types";
            case PLANDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case PRACTITIONER: return "http://hl7.org/fhir/fhir-types";
            case PRACTITIONERROLE: return "http://hl7.org/fhir/fhir-types";
            case PROCEDURE: return "http://hl7.org/fhir/fhir-types";
            case PROVENANCE: return "http://hl7.org/fhir/fhir-types";
            case QUESTIONNAIRE: return "http://hl7.org/fhir/fhir-types";
            case QUESTIONNAIRERESPONSE: return "http://hl7.org/fhir/fhir-types";
            case REGULATEDAUTHORIZATION: return "http://hl7.org/fhir/fhir-types";
            case RELATEDPERSON: return "http://hl7.org/fhir/fhir-types";
            case REQUESTORCHESTRATION: return "http://hl7.org/fhir/fhir-types";
            case REQUIREMENTS: return "http://hl7.org/fhir/fhir-types";
            case RESEARCHSTUDY: return "http://hl7.org/fhir/fhir-types";
            case RESEARCHSUBJECT: return "http://hl7.org/fhir/fhir-types";
            case RISKASSESSMENT: return "http://hl7.org/fhir/fhir-types";
            case SCHEDULE: return "http://hl7.org/fhir/fhir-types";
            case SEARCHPARAMETER: return "http://hl7.org/fhir/fhir-types";
            case SERVICEREQUEST: return "http://hl7.org/fhir/fhir-types";
            case SLOT: return "http://hl7.org/fhir/fhir-types";
            case SPECIMEN: return "http://hl7.org/fhir/fhir-types";
            case SPECIMENDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case STRUCTUREDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case STRUCTUREMAP: return "http://hl7.org/fhir/fhir-types";
            case SUBSCRIPTION: return "http://hl7.org/fhir/fhir-types";
            case SUBSCRIPTIONSTATUS: return "http://hl7.org/fhir/fhir-types";
            case SUBSCRIPTIONTOPIC: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCE: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCENUCLEICACID: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEPOLYMER: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEPROTEIN: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEREFERENCEINFORMATION: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCESOURCEMATERIAL: return "http://hl7.org/fhir/fhir-types";
            case SUPPLYDELIVERY: return "http://hl7.org/fhir/fhir-types";
            case SUPPLYREQUEST: return "http://hl7.org/fhir/fhir-types";
            case TASK: return "http://hl7.org/fhir/fhir-types";
            case TERMINOLOGYCAPABILITIES: return "http://hl7.org/fhir/fhir-types";
            case TESTREPORT: return "http://hl7.org/fhir/fhir-types";
            case TESTSCRIPT: return "http://hl7.org/fhir/fhir-types";
            case TRANSPORT: return "http://hl7.org/fhir/fhir-types";
            case VALUESET: return "http://hl7.org/fhir/fhir-types";
            case VERIFICATIONRESULT: return "http://hl7.org/fhir/fhir-types";
            case VISIONPRESCRIPTION: return "http://hl7.org/fhir/fhir-types";
            case PARAMETERS: return "http://hl7.org/fhir/fhir-types";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case BASE: return "Base Type: Base definition for all types defined in FHIR type system.";
            case ELEMENT: return "Element Type: Base definition for all elements in a resource.";
            case BACKBONEELEMENT: return "BackboneElement Type: Base definition for all elements that are defined inside a resource - but not those in a data type.";
            case DATATYPE: return "DataType Type: The base class for all re-useable types defined as part of the FHIR Specification.";
            case ADDRESS: return "Address Type: An address expressed using postal conventions (as opposed to GPS or other location definition formats).  This data type may be used to convey addresses for use in delivering mail as well as for visiting locations which might not be valid for mail delivery.  There are a variety of postal address formats defined around the world.\nThe ISO21090-codedString may be used to provide a coded representation of the contents of strings in an Address.";
            case ANNOTATION: return "Annotation Type: A  text note which also  contains information about who made the statement and when.";
            case ATTACHMENT: return "Attachment Type: For referring to data content defined in other formats.";
            case AVAILABILITY: return "Availability Type: Availability data for an {item}.";
            case BACKBONETYPE: return "BackboneType Type: Base definition for the few data types that are allowed to carry modifier extensions.";
            case DOSAGE: return "Dosage Type: Indicates how the medication is/was taken or should be taken by the patient.";
            case ELEMENTDEFINITION: return "ElementDefinition Type: Captures constraints on each element within the resource, profile, or extension.";
            case MARKETINGSTATUS: return "MarketingStatus Type: The marketing status describes the date when a medicinal product is actually put on the market or the date as of which it is no longer available.";
            case POPULATION: return "Population Type: A populatioof people with some set of grouping criteria.";
            case PRODUCTSHELFLIFE: return "ProductShelfLife Type: The shelf-life and storage information for a medicinal product item or container can be described using this class.";
            case TIMING: return "Timing Type: Specifies an event that may occur multiple times. Timing schedules are used to record when things are planned, expected or requested to occur. The most common usage is in dosage instructions for medications. They are also used when planning care of various kinds, and may be used for reporting the schedule to which past regular activities were carried out.";
            case CODEABLECONCEPT: return "CodeableConcept Type: A concept that may be defined by a formal reference to a terminology or ontology or may be provided by text.";
            case CODEABLEREFERENCE: return "CodeableReference Type: A reference to a resource (by instance), or instead, a reference to a concept defined in a terminology or ontology (by class).";
            case CODING: return "Coding Type: A reference to a code defined by a terminology system.";
            case CONTACTDETAIL: return "ContactDetail Type: Specifies contact information for a person or organization.";
            case CONTACTPOINT: return "ContactPoint Type: Details for all kinds of technology mediated contact points for a person or organization, including telephone, email, etc.";
            case CONTRIBUTOR: return "Contributor Type: A contributor to the content of a knowledge asset, including authors, editors, reviewers, and endorsers.";
            case DATAREQUIREMENT: return "DataRequirement Type: Describes a required data item for evaluation in terms of the type of data, and optional code or date-based filters of the data.";
            case EXPRESSION: return "Expression Type: A expression that is evaluated in a specified context and returns a value. The context of use of the expression must specify the context in which the expression is evaluated, and how the result of the expression is used.";
            case EXTENDEDCONTACTDETAIL: return "ExtendedContactDetail Type: Specifies contact information for a specific purpose over a period of time, might be handled/monitored by a specific named person or organization.";
            case EXTENSION: return "Extension Type: Optional Extension Element - found in all resources.";
            case HUMANNAME: return "HumanName Type: A name, normally of a human, that can be used for other living entities (eg. animals but not organizations) that have been assigned names by a human and may need the use of name parts or the need for usage information.";
            case IDENTIFIER: return "Identifier Type: An identifier - identifies some entity uniquely and unambiguously. Typically this is used for business identifiers.";
            case META: return "Meta Type: The metadata about a resource. This is content in the resource that is maintained by the infrastructure. Changes to the content might not always be associated with version changes to the resource.";
            case MONETARYCOMPONENT: return "MonetaryComponent Type: Availability data for an {item}.";
            case MONEY: return "Money Type: An amount of economic utility in some recognized currency.";
            case NARRATIVE: return "Narrative Type: A human-readable summary of the resource conveying the essential clinical and business information for the resource.";
            case PARAMETERDEFINITION: return "ParameterDefinition Type: The parameters to the module. This collection specifies both the input and output parameters. Input parameters are provided by the caller as part of the $evaluate operation. Output parameters are included in the GuidanceResponse.";
            case PERIOD: return "Period Type: A time period defined by a start and end date and optionally time.";
            case PRIMITIVETYPE: return "PrimitiveType Type: The base type for all re-useable types defined that have a simple property.";
            case BASE64BINARY: return "base64Binary Type: A stream of bytes";
            case BOOLEAN: return "boolean Type: Value of \"true\" or \"false\"";
            case DATE: return "date Type: A date or partial date (e.g. just year or year + month). There is no UTC offset. The format is a union of the schema types gYear, gYearMonth and date.  Dates SHALL be valid dates.";
            case DATETIME: return "dateTime Type: A date, date-time or partial date (e.g. just year or year + month).  If hours and minutes are specified, a UTC offset SHALL be populated. The format is a union of the schema types gYear, gYearMonth, date and dateTime. Seconds must be provided due to schema type constraints but may be zero-filled and may be ignored.                 Dates SHALL be valid dates.";
            case DECIMAL: return "decimal Type: A rational number with implicit precision";
            case INSTANT: return "instant Type: An instant in time - known at least to the second";
            case INTEGER: return "integer Type: A whole number";
            case POSITIVEINT: return "positiveInt type: An integer with a value that is positive (e.g. >0)";
            case UNSIGNEDINT: return "unsignedInt type: An integer with a value that is not negative (e.g. >= 0)";
            case INTEGER64: return "integer64 Type: A very large whole number";
            case STRING: return "string Type: A sequence of Unicode characters";
            case CODE: return "code type: A string which has at least one character and no leading or trailing whitespace and where there is no whitespace other than single spaces in the contents";
            case ID: return "id type: Any combination of letters, numerals, \"-\" and \".\", with a length limit of 64 characters.  (This might be an integer, an unprefixed OID, UUID or any other identifier pattern that meets these constraints.)  Ids are case-insensitive.";
            case MARKDOWN: return "markdown type: A string that may contain Github Flavored Markdown syntax for optional processing by a mark down presentation engine";
            case TIME: return "time Type: A time during the day, with no date specified";
            case URI: return "uri Type: String of characters used to identify a name or a resource";
            case CANONICAL: return "canonical type: A URI that is a reference to a canonical URL on a FHIR resource";
            case OID: return "oid type: An OID represented as a URI";
            case URL: return "url type: A URI that is a literal reference";
            case UUID: return "uuid type: A UUID, represented as a URI";
            case QUANTITY: return "Quantity Type: A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.";
            case AGE: return "Age Type: A duration of time during which an organism (or a process) has existed.";
            case COUNT: return "Count Type: A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.";
            case DISTANCE: return "Distance Type: A length - a value with a unit that is a physical distance.";
            case DURATION: return "Duration Type: A length of time.";
            case RANGE: return "Range Type: A set of ordered Quantities defined by a low and high limit.";
            case RATIO: return "Ratio Type: A relationship of two Quantity values - expressed as a numerator and a denominator.";
            case RATIORANGE: return "RatioRange Type: A range of ratios expressed as a low and high numerator and a denominator.";
            case REFERENCE: return "Reference Type: A reference from one resource to another.";
            case RELATEDARTIFACT: return "RelatedArtifact Type: Related artifacts such as additional documentation, justification, or bibliographic references.";
            case SAMPLEDDATA: return "SampledData Type: A series of measurements taken by a device, with upper and lower limits. There may be more than one dimension in the data.";
            case SIGNATURE: return "Signature Type: A signature along with supporting context. The signature may be a digital signature that is cryptographic in nature, or some other signature acceptable to the domain. This other signature may be as simple as a graphical image representing a hand-written signature, or a signature ceremony Different signature approaches have different utilities.";
            case TRIGGERDEFINITION: return "TriggerDefinition Type: A description of a triggering event. Triggering events can be named events, data events, or periodic, as determined by the type element.";
            case USAGECONTEXT: return "UsageContext Type: Specifies clinical/business/etc. metadata that can be used to retrieve, index and/or categorize an artifact. This metadata can either be specific to the applicable population (e.g., age category, DRG) or the specific context of care (e.g., venue, care setting, provider of care).";
            case VIRTUALSERVICEDETAIL: return "VirtualServiceDetail Type: Virtual Service Contact Details.";
            case XHTML: return "xhtml Type definition";
            case RESOURCE: return "This is the base resource type for everything.";
            case BINARY: return "A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.";
            case BUNDLE: return "A container for a collection of resources.";
            case DOMAINRESOURCE: return "A resource that includes narrative, extensions, and contained resources.";
            case ACCOUNT: return "A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.";
            case ACTIVITYDEFINITION: return "This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.";
            case ACTORDEFINITION: return "The ActorDefinition resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.";
            case ADMINISTRABLEPRODUCTDEFINITION: return "A medicinal product in the final form which is suitable for administering to a patient (after any mixing of multiple components, dissolution etc. has been performed).";
            case ADVERSEEVENT: return "An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject. The unintended effects may require additional monitoring, treatment, hospitalization, or may result in death. The AdverseEvent resource also extends to potential or avoided events that could have had such effects. There are two major domains where the AdverseEvent resource is expected to be used. One is in clinical care reported adverse events and the other is in reporting adverse events in clinical  research trial management. Given the differences between these two arenas, we recommend consulting the domain specific implementation guides when implementing the AdverseEvent Resource. The implementation guides include specific extensions, value sets and constraints.";
            case ALLERGYINTOLERANCE: return "Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.";
            case APPOINTMENT: return "A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).";
            case APPOINTMENTRESPONSE: return "A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.";
            case ARTIFACTASSESSMENT: return "This Resource provides one or more comments, classifiers or ratings about a Resource and supports attribution and rights management metadata for the added content.";
            case AUDITEVENT: return "A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.";
            case BASIC: return "Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.";
            case BIOLOGICALLYDERIVEDPRODUCT: return "A biological material originating from a biological entity intended to be transplanted or infused into another (possibly the same) biological entity.";
            case BODYSTRUCTURE: return "Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.";
            case CANONICALRESOURCE: return "Common Interface declaration for conformance and knowledge artifact resources.";
            case CAPABILITYSTATEMENT: return "A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server or Client for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case CAREPLAN: return "Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.";
            case CARETEAM: return "The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.";
            case CHARGEITEM: return "The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.";
            case CHARGEITEMDEFINITION: return "The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.";
            case CITATION: return "The Citation Resource enables reference to any knowledge artifact for purposes of identification and attribution. The Citation Resource supports existing reference structures and developing publication practices such as versioning, expressing complex contributorship roles, and referencing computable resources.";
            case CLAIM: return "A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.";
            case CLAIMRESPONSE: return "This resource provides the adjudication details from the processing of a Claim resource.";
            case CLINICALIMPRESSION: return "A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called \"ClinicalImpression\" rather than \"ClinicalAssessment\" to avoid confusion with the recording of assessment tools such as Apgar score.";
            case CLINICALUSEDEFINITION: return "A single issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.";
            case CODESYSTEM: return "The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.";
            case COMMUNICATION: return "A clinical or business level record of information being transmitted or shared; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.";
            case COMMUNICATIONREQUEST: return "A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.";
            case COMPARTMENTDEFINITION: return "A compartment definition that defines how resources are accessed on a server.";
            case COMPOSITION: return "A set of healthcare-related information that is assembled together into a single logical package that provides a single coherent statement of meaning, establishes its own context and that has clinical attestation with regard to who is making the statement. A Composition defines the structure and narrative content necessary for a document. However, a Composition alone does not constitute a document. Rather, the Composition must be the first entry in a Bundle where Bundle.type=document, and any other resources referenced from Composition must be included as subsequent entries in the Bundle (for example Patient, Practitioner, Encounter, etc.).";
            case CONCEPTMAP: return "A statement of relationships from one set of concepts to one or more other concepts - either concepts in code systems, or data element/data element concepts, or classes in class models.";
            case CONDITION: return "A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a level of concern.";
            case CONDITIONDEFINITION: return "A definition of a condition and information relevant to managing it.";
            case CONSENT: return "A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.";
            case CONTRACT: return "Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement.";
            case COVERAGE: return "Financial instrument which may be used to reimburse or pay for health care products and services. Includes both insurance and self-payment.";
            case COVERAGEELIGIBILITYREQUEST: return "The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage is valid and in-force and optionally to provide the insurance details of the policy.";
            case COVERAGEELIGIBILITYRESPONSE: return "This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.";
            case DETECTEDISSUE: return "Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, etc.";
            case DEVICE: return "This resource describes the properties (regulated, has real time clock, etc.), adminstrative (manufacturer name, model number, serial number, firmware, etc), and type (knee replacement, blood pressure cuff, MRI, etc.) of a physical unit (these values do not change much within a given module, for example the serail number, manufacturer name, and model number). An actual unit may consist of several modules in a distinct hierarchy and these are represented by multiple Device resources and bound through the 'parent' element.";
            case DEVICEDEFINITION: return "This is a specialized resource that defines the characteristics and capabilities of a device.";
            case DEVICEDISPENSE: return "Indicates that a device is to be or has been dispensed for a named person/patient.  This includes a description of the product (supply) provided and the instructions for using the device.";
            case DEVICEMETRIC: return "Describes a measurement, calculation or setting capability of a medical device.";
            case DEVICEREQUEST: return "Represents a request a device to be provided to a specific patient. The device may be an implantable device to be subsequently implanted, or an external assistive device, such as a walker, to be delivered and subsequently be used.";
            case DEVICEUSAGE: return "A record of a device being used by a patient where the record is the result of a report from the patient or a clinician.";
            case DIAGNOSTICREPORT: return "The findings and interpretation of diagnostic tests performed on patients, groups of patients, products, substances, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports. The report also includes non-clinical context such as batch analysis and stability reporting of products and substances.";
            case DOCUMENTMANIFEST: return "A collection of documents compiled for a purpose together with metadata that applies to the collection.";
            case DOCUMENTREFERENCE: return "A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this \"document\" encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.";
            case ENCOUNTER: return "An interaction between healthcare provider(s), and/or patient(s) for the purpose of providing healthcare service(s) or assessing the health status of patient(s).";
            case ENDPOINT: return "The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b, a REST endpoint for another FHIR server, or a s/Mime email address. This may include any security context information.";
            case ENROLLMENTREQUEST: return "This resource provides the insurance enrollment details to the insurer regarding a specified coverage.";
            case ENROLLMENTRESPONSE: return "This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.";
            case EPISODEOFCARE: return "An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.";
            case EVENTDEFINITION: return "The EventDefinition resource provides a reusable description of when a particular event can occur.";
            case EVIDENCE: return "The Evidence Resource provides a machine-interpretable expression of an evidence concept including the evidence variables (e.g., population, exposures/interventions, comparators, outcomes, measured variables, confounding variables), the statistics, and the certainty of this evidence.";
            case EVIDENCEREPORT: return "The EvidenceReport Resource is a specialized container for a collection of resources and codeable concepts, adapted to support compositions of Evidence, EvidenceVariable, and Citation resources and related concepts.";
            case EVIDENCEVARIABLE: return "The EvidenceVariable resource describes an element that knowledge (Evidence) is about.";
            case EXAMPLESCENARIO: return "A walkthrough of a workflow showing the interaction between systems and the instances shared, possibly including the evolution of instances over time.";
            case EXPLANATIONOFBENEFIT: return "This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.";
            case FAMILYMEMBERHISTORY: return "Significant health conditions for a person related to the patient relevant in the context of care for the patient.";
            case FLAG: return "Prospective warnings of potential issues when providing care to the patient.";
            case FORMULARYITEM: return "This resource describes a product or service that is available through a program and includes the conditions and constraints of availability.  All of the information in this resource is specific to the inclusion of the item in the formulary and is not inherent to the item itself.";
            case GENOMICSTUDY: return "A Genomic Study is a set of analysis performed to analyze and generate genomic data.";
            case GOAL: return "Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.";
            case GRAPHDEFINITION: return "A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.";
            case GROUP: return "Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.";
            case GUIDANCERESPONSE: return "A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.";
            case HEALTHCARESERVICE: return "The details of a healthcare service available at a location or in a catalog.  In the case where there is a hierarchy of services (for example, Lab -> Pathology -> Wound Cultures), this can be represented using a set of linked HealthcareServices.";
            case IMAGINGSELECTION: return "A selection of DICOM SOP instances and/or frames within a single Study and Series. This might include additional specifics such as an image region, an Observation UID or a Segmentation Number, allowing linkage to an Observation Resource or transferring this information along with the ImagingStudy Resource.";
            case IMAGINGSTUDY: return "Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.";
            case IMMUNIZATION: return "Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.";
            case IMMUNIZATIONEVALUATION: return "Describes a comparison of an immunization event against published recommendations to determine if the administration is \"valid\" in relation to those  recommendations.";
            case IMMUNIZATIONRECOMMENDATION: return "A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.";
            case IMPLEMENTATIONGUIDE: return "A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.";
            case INGREDIENT: return "An ingredient of a manufactured item or pharmaceutical product.";
            case INSURANCEPLAN: return "Details of a Health Insurance product/plan provided by an organization.";
            case INVENTORYREPORT: return "A report of inventory or stock items.";
            case INVOICE: return "Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.";
            case LIBRARY: return "The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.";
            case LINKAGE: return "Identifies two or more records (resource instances) that refer to the same real-world \"occurrence\".";
            case LIST: return "A List is a curated collection of resources, for things such as problem lists, allergy lists, facility list, organization list, etc.";
            case LOCATION: return "Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.";
            case MANUFACTUREDITEMDEFINITION: return "The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.";
            case MEASURE: return "The Measure resource provides the definition of a quality measure.";
            case MEASUREREPORT: return "The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.";
            case MEDICATION: return "This resource is primarily used for the identification and definition of a medication, including ingredients, for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.";
            case MEDICATIONADMINISTRATION: return "Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.";
            case MEDICATIONDISPENSE: return "Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.";
            case MEDICATIONKNOWLEDGE: return "Information about a medication that is used to support knowledge.";
            case MEDICATIONREQUEST: return "An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called \"MedicationRequest\" rather than \"MedicationPrescription\" or \"MedicationOrder\" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.";
            case MEDICATIONUSAGE: return "A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. \n\nThe primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.";
            case MEDICINALPRODUCTDEFINITION: return "Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use, drug catalogs, to support prescribing, adverse events management etc.).";
            case MESSAGEDEFINITION: return "Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.";
            case MESSAGEHEADER: return "The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.";
            case METADATARESOURCE: return "Common Interface declaration for conformance and knowledge artifact resources.";
            case MOLECULARSEQUENCE: return "Representation of a molecular sequence.";
            case NAMINGSYSTEM: return "A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a \"System\" used within the Identifier and Coding data types.";
            case NUTRITIONINTAKE: return "A record of food or fluid that is being consumed by a patient.  A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.";
            case NUTRITIONORDER: return "A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.";
            case NUTRITIONPRODUCT: return "A food or supplement that is consumed by patients.";
            case OBSERVATION: return "Measurements and simple assertions made about a patient, device or other subject.";
            case OBSERVATIONDEFINITION: return "Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.";
            case OPERATIONDEFINITION: return "A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).";
            case OPERATIONOUTCOME: return "A collection of error, warning, or information messages that result from a system action.";
            case ORGANIZATION: return "A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.";
            case ORGANIZATIONAFFILIATION: return "Defines an affiliation/assotiation/relationship between 2 distinct organizations, that is not a part-of relationship/sub-division relationship.";
            case PACKAGEDPRODUCTDEFINITION: return "A medically related item or items, in a container or package.";
            case PATIENT: return "Demographics and other administrative information about an individual or animal receiving care or other health-related services.";
            case PAYMENTNOTICE: return "This resource provides the status of the payment for goods and services rendered, and the request and response resource references.";
            case PAYMENTRECONCILIATION: return "This resource provides the details including amount of a payment and allocates the payment items being paid.";
            case PERMISSION: return "Permission resource holds access rules for a given data and context.";
            case PERSON: return "Demographics and administrative information about a person independent of a specific health-related context.";
            case PLANDEFINITION: return "This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical and non-clinical artifacts such as clinical decision support rules, order sets, protocols, and drug quality specifications.";
            case PRACTITIONER: return "A person who is directly or indirectly involved in the provisioning of healthcare or related services.";
            case PRACTITIONERROLE: return "A specific set of Roles/Locations/specialties/services that a practitioner may perform, or has performed at an organization during a period of time.";
            case PROCEDURE: return "An action that is or was performed on or for a patient, practitioner, device, organization, or location. For example, this can be a physical intervention on a patient like an operation, or less invasive like long term services, counseling, or hypnotherapy.  This can be a quality or safety inspection for a location, organization, or device.  This can be an accreditation procedure on a practitioner for licensing.";
            case PROVENANCE: return "Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.";
            case QUESTIONNAIRE: return "A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.";
            case QUESTIONNAIRERESPONSE: return "A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.";
            case REGULATEDAUTHORIZATION: return "Regulatory approval, clearance or licencing related to a regulated product, treatment, facility or activity that is cited in a guidance, regulation, rule or legislative act. An example is Market Authorization relating to a Medicinal Product.";
            case RELATEDPERSON: return "Information about a person that is involved in a patient's health or the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.";
            case REQUESTORCHESTRATION: return "A set of related requests that can be used to capture intended activities that have inter-dependencies such as \"give this medication after that one\".";
            case REQUIREMENTS: return "The Requirements resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.";
            case RESEARCHSTUDY: return "A scientific study of nature that sometimes includes processes involved in health and disease. For example, clinical trials are research studies that involve people. These studies may be related to new ways to screen, prevent, diagnose, and treat disease. They may also study certain outcomes and certain groups of people by looking at data collected in the past or future.";
            case RESEARCHSUBJECT: return "A physical entity which is the primary unit of operational and/or administrative interest in a study.";
            case RISKASSESSMENT: return "An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.";
            case SCHEDULE: return "A container for slots of time that may be available for booking appointments.";
            case SEARCHPARAMETER: return "A search parameter that defines a named search item that can be used to search/filter on a resource.";
            case SERVICEREQUEST: return "A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.";
            case SLOT: return "A slot of time on a schedule that may be available for booking appointments.";
            case SPECIMEN: return "A sample to be used for analysis.";
            case SPECIMENDEFINITION: return "A kind of specimen with associated set of requirements.";
            case STRUCTUREDEFINITION: return "A definition of a FHIR structure. This resource is used to describe the underlying resources, data types defined in FHIR, and also for describing extensions and constraints on resources and data types.";
            case STRUCTUREMAP: return "A Map of relationships between 2 structures that can be used to transform data.";
            case SUBSCRIPTION: return "The subscription resource describes a particular client's request to be notified about a SubscriptionTopic.";
            case SUBSCRIPTIONSTATUS: return "The SubscriptionStatus resource describes the state of a Subscription during notifications. It is not persisted.";
            case SUBSCRIPTIONTOPIC: return "Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.";
            case SUBSTANCE: return "A homogeneous material with a definite composition.";
            case SUBSTANCEDEFINITION: return "The detailed description of a substance, typically at a level beyond what is used for prescribing.";
            case SUBSTANCENUCLEICACID: return "Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.";
            case SUBSTANCEPOLYMER: return "Properties of a substance specific to it being a polymer.";
            case SUBSTANCEPROTEIN: return "A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.";
            case SUBSTANCEREFERENCEINFORMATION: return "Todo.";
            case SUBSTANCESOURCEMATERIAL: return "Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.";
            case SUPPLYDELIVERY: return "Record of delivery of what is supplied.";
            case SUPPLYREQUEST: return "A record of a non-patient specific request for a medication, substance, device, certain types of biologically derived product, and nutrition product used in the healthcare setting.";
            case TASK: return "A task to be performed.";
            case TERMINOLOGYCAPABILITIES: return "A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case TESTREPORT: return "A summary of information based on the results of executing a TestScript.";
            case TESTSCRIPT: return "A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.";
            case TRANSPORT: return "Record of transport.";
            case VALUESET: return "A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).";
            case VERIFICATIONRESULT: return "Describes validation requirements, source(s), status and dates for one or more elements.";
            case VISIONPRESCRIPTION: return "An authorization for the provision of glasses and/or contact lenses to a patient.";
            case PARAMETERS: return "This resource is used to pass information into and back from an operation (whether invoked directly from REST or within a messaging environment).  It is not persisted or allowed to be referenced by other resources except as described in the definition of the Parameters resource.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case BASE: return "Base";
            case ELEMENT: return "Element";
            case BACKBONEELEMENT: return "BackboneElement";
            case DATATYPE: return "DataType";
            case ADDRESS: return "Address";
            case ANNOTATION: return "Annotation";
            case ATTACHMENT: return "Attachment";
            case AVAILABILITY: return "Availability";
            case BACKBONETYPE: return "BackboneType";
            case DOSAGE: return "Dosage";
            case ELEMENTDEFINITION: return "ElementDefinition";
            case MARKETINGSTATUS: return "MarketingStatus";
            case POPULATION: return "Population";
            case PRODUCTSHELFLIFE: return "ProductShelfLife";
            case TIMING: return "Timing";
            case CODEABLECONCEPT: return "CodeableConcept";
            case CODEABLEREFERENCE: return "CodeableReference";
            case CODING: return "Coding";
            case CONTACTDETAIL: return "ContactDetail";
            case CONTACTPOINT: return "ContactPoint";
            case CONTRIBUTOR: return "Contributor";
            case DATAREQUIREMENT: return "DataRequirement";
            case EXPRESSION: return "Expression";
            case EXTENDEDCONTACTDETAIL: return "ExtendedContactDetail";
            case EXTENSION: return "Extension";
            case HUMANNAME: return "HumanName";
            case IDENTIFIER: return "Identifier";
            case META: return "Meta";
            case MONETARYCOMPONENT: return "MonetaryComponent";
            case MONEY: return "Money";
            case NARRATIVE: return "Narrative";
            case PARAMETERDEFINITION: return "ParameterDefinition";
            case PERIOD: return "Period";
            case PRIMITIVETYPE: return "PrimitiveType";
            case BASE64BINARY: return "base64Binary";
            case BOOLEAN: return "boolean";
            case DATE: return "date";
            case DATETIME: return "dateTime";
            case DECIMAL: return "decimal";
            case INSTANT: return "instant";
            case INTEGER: return "integer";
            case POSITIVEINT: return "positiveInt";
            case UNSIGNEDINT: return "unsignedInt";
            case INTEGER64: return "integer64";
            case STRING: return "string";
            case CODE: return "code";
            case ID: return "id";
            case MARKDOWN: return "markdown";
            case TIME: return "time";
            case URI: return "uri";
            case CANONICAL: return "canonical";
            case OID: return "oid";
            case URL: return "url";
            case UUID: return "uuid";
            case QUANTITY: return "Quantity";
            case AGE: return "Age";
            case COUNT: return "Count";
            case DISTANCE: return "Distance";
            case DURATION: return "Duration";
            case RANGE: return "Range";
            case RATIO: return "Ratio";
            case RATIORANGE: return "RatioRange";
            case REFERENCE: return "Reference";
            case RELATEDARTIFACT: return "RelatedArtifact";
            case SAMPLEDDATA: return "SampledData";
            case SIGNATURE: return "Signature";
            case TRIGGERDEFINITION: return "TriggerDefinition";
            case USAGECONTEXT: return "UsageContext";
            case VIRTUALSERVICEDETAIL: return "VirtualServiceDetail";
            case XHTML: return "xhtml";
            case RESOURCE: return "Resource";
            case BINARY: return "Binary";
            case BUNDLE: return "Bundle";
            case DOMAINRESOURCE: return "DomainResource";
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ACTORDEFINITION: return "ActorDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case ARTIFACTASSESSMENT: return "ArtifactAssessment";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case CANONICALRESOURCE: return "CanonicalResource";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CITATION: return "Citation";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEDEFINITION: return "ClinicalUseDefinition";
            case CODESYSTEM: return "CodeSystem";
            case COMMUNICATION: return "Communication";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case COMPARTMENTDEFINITION: return "CompartmentDefinition";
            case COMPOSITION: return "Composition";
            case CONCEPTMAP: return "ConceptMap";
            case CONDITION: return "Condition";
            case CONDITIONDEFINITION: return "ConditionDefinition";
            case CONSENT: return "Consent";
            case CONTRACT: return "Contract";
            case COVERAGE: return "Coverage";
            case COVERAGEELIGIBILITYREQUEST: return "CoverageEligibilityRequest";
            case COVERAGEELIGIBILITYRESPONSE: return "CoverageEligibilityResponse";
            case DETECTEDISSUE: return "DetectedIssue";
            case DEVICE: return "Device";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case DEVICEDISPENSE: return "DeviceDispense";
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSAGE: return "DeviceUsage";
            case DIAGNOSTICREPORT: return "DiagnosticReport";
            case DOCUMENTMANIFEST: return "DocumentManifest";
            case DOCUMENTREFERENCE: return "DocumentReference";
            case ENCOUNTER: return "Encounter";
            case ENDPOINT: return "Endpoint";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case ENROLLMENTRESPONSE: return "EnrollmentResponse";
            case EPISODEOFCARE: return "EpisodeOfCare";
            case EVENTDEFINITION: return "EventDefinition";
            case EVIDENCE: return "Evidence";
            case EVIDENCEREPORT: return "EvidenceReport";
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case FORMULARYITEM: return "FormularyItem";
            case GENOMICSTUDY: return "GenomicStudy";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSELECTION: return "ImagingSelection";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
            case INVENTORYREPORT: return "InventoryReport";
            case INVOICE: return "Invoice";
            case LIBRARY: return "Library";
            case LINKAGE: return "Linkage";
            case LIST: return "List";
            case LOCATION: return "Location";
            case MANUFACTUREDITEMDEFINITION: return "ManufacturedItemDefinition";
            case MEASURE: return "Measure";
            case MEASUREREPORT: return "MeasureReport";
            case MEDICATION: return "Medication";
            case MEDICATIONADMINISTRATION: return "MedicationAdministration";
            case MEDICATIONDISPENSE: return "MedicationDispense";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case MEDICATIONUSAGE: return "MedicationUsage";
            case MEDICINALPRODUCTDEFINITION: return "MedicinalProductDefinition";
            case MESSAGEDEFINITION: return "MessageDefinition";
            case MESSAGEHEADER: return "MessageHeader";
            case METADATARESOURCE: return "MetadataResource";
            case MOLECULARSEQUENCE: return "MolecularSequence";
            case NAMINGSYSTEM: return "NamingSystem";
            case NUTRITIONINTAKE: return "NutritionIntake";
            case NUTRITIONORDER: return "NutritionOrder";
            case NUTRITIONPRODUCT: return "NutritionProduct";
            case OBSERVATION: return "Observation";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case OPERATIONDEFINITION: return "OperationDefinition";
            case OPERATIONOUTCOME: return "OperationOutcome";
            case ORGANIZATION: return "Organization";
            case ORGANIZATIONAFFILIATION: return "OrganizationAffiliation";
            case PACKAGEDPRODUCTDEFINITION: return "PackagedProductDefinition";
            case PATIENT: return "Patient";
            case PAYMENTNOTICE: return "PaymentNotice";
            case PAYMENTRECONCILIATION: return "PaymentReconciliation";
            case PERMISSION: return "Permission";
            case PERSON: return "Person";
            case PLANDEFINITION: return "PlanDefinition";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case PROCEDURE: return "Procedure";
            case PROVENANCE: return "Provenance";
            case QUESTIONNAIRE: return "Questionnaire";
            case QUESTIONNAIRERESPONSE: return "QuestionnaireResponse";
            case REGULATEDAUTHORIZATION: return "RegulatedAuthorization";
            case RELATEDPERSON: return "RelatedPerson";
            case REQUESTORCHESTRATION: return "RequestOrchestration";
            case REQUIREMENTS: return "Requirements";
            case RESEARCHSTUDY: return "ResearchStudy";
            case RESEARCHSUBJECT: return "ResearchSubject";
            case RISKASSESSMENT: return "RiskAssessment";
            case SCHEDULE: return "Schedule";
            case SEARCHPARAMETER: return "SearchParameter";
            case SERVICEREQUEST: return "ServiceRequest";
            case SLOT: return "Slot";
            case SPECIMEN: return "Specimen";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case STRUCTUREDEFINITION: return "StructureDefinition";
            case STRUCTUREMAP: return "StructureMap";
            case SUBSCRIPTION: return "Subscription";
            case SUBSCRIPTIONSTATUS: return "SubscriptionStatus";
            case SUBSCRIPTIONTOPIC: return "SubscriptionTopic";
            case SUBSTANCE: return "Substance";
            case SUBSTANCEDEFINITION: return "SubstanceDefinition";
            case SUBSTANCENUCLEICACID: return "SubstanceNucleicAcid";
            case SUBSTANCEPOLYMER: return "SubstancePolymer";
            case SUBSTANCEPROTEIN: return "SubstanceProtein";
            case SUBSTANCEREFERENCEINFORMATION: return "SubstanceReferenceInformation";
            case SUBSTANCESOURCEMATERIAL: return "SubstanceSourceMaterial";
            case SUPPLYDELIVERY: return "SupplyDelivery";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case TERMINOLOGYCAPABILITIES: return "TerminologyCapabilities";
            case TESTREPORT: return "TestReport";
            case TESTSCRIPT: return "TestScript";
            case TRANSPORT: return "Transport";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            case PARAMETERS: return "Parameters";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class FHIRTypesEnumFactory implements EnumFactory<FHIRTypes> {
    public FHIRTypes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Base".equals(codeString))
          return FHIRTypes.BASE;
        if ("Element".equals(codeString))
          return FHIRTypes.ELEMENT;
        if ("BackboneElement".equals(codeString))
          return FHIRTypes.BACKBONEELEMENT;
        if ("DataType".equals(codeString))
          return FHIRTypes.DATATYPE;
        if ("Address".equals(codeString))
          return FHIRTypes.ADDRESS;
        if ("Annotation".equals(codeString))
          return FHIRTypes.ANNOTATION;
        if ("Attachment".equals(codeString))
          return FHIRTypes.ATTACHMENT;
        if ("Availability".equals(codeString))
          return FHIRTypes.AVAILABILITY;
        if ("BackboneType".equals(codeString))
          return FHIRTypes.BACKBONETYPE;
        if ("Dosage".equals(codeString))
          return FHIRTypes.DOSAGE;
        if ("ElementDefinition".equals(codeString))
          return FHIRTypes.ELEMENTDEFINITION;
        if ("MarketingStatus".equals(codeString))
          return FHIRTypes.MARKETINGSTATUS;
        if ("Population".equals(codeString))
          return FHIRTypes.POPULATION;
        if ("ProductShelfLife".equals(codeString))
          return FHIRTypes.PRODUCTSHELFLIFE;
        if ("Timing".equals(codeString))
          return FHIRTypes.TIMING;
        if ("CodeableConcept".equals(codeString))
          return FHIRTypes.CODEABLECONCEPT;
        if ("CodeableReference".equals(codeString))
          return FHIRTypes.CODEABLEREFERENCE;
        if ("Coding".equals(codeString))
          return FHIRTypes.CODING;
        if ("ContactDetail".equals(codeString))
          return FHIRTypes.CONTACTDETAIL;
        if ("ContactPoint".equals(codeString))
          return FHIRTypes.CONTACTPOINT;
        if ("Contributor".equals(codeString))
          return FHIRTypes.CONTRIBUTOR;
        if ("DataRequirement".equals(codeString))
          return FHIRTypes.DATAREQUIREMENT;
        if ("Expression".equals(codeString))
          return FHIRTypes.EXPRESSION;
        if ("ExtendedContactDetail".equals(codeString))
          return FHIRTypes.EXTENDEDCONTACTDETAIL;
        if ("Extension".equals(codeString))
          return FHIRTypes.EXTENSION;
        if ("HumanName".equals(codeString))
          return FHIRTypes.HUMANNAME;
        if ("Identifier".equals(codeString))
          return FHIRTypes.IDENTIFIER;
        if ("Meta".equals(codeString))
          return FHIRTypes.META;
        if ("MonetaryComponent".equals(codeString))
          return FHIRTypes.MONETARYCOMPONENT;
        if ("Money".equals(codeString))
          return FHIRTypes.MONEY;
        if ("Narrative".equals(codeString))
          return FHIRTypes.NARRATIVE;
        if ("ParameterDefinition".equals(codeString))
          return FHIRTypes.PARAMETERDEFINITION;
        if ("Period".equals(codeString))
          return FHIRTypes.PERIOD;
        if ("PrimitiveType".equals(codeString))
          return FHIRTypes.PRIMITIVETYPE;
        if ("base64Binary".equals(codeString))
          return FHIRTypes.BASE64BINARY;
        if ("boolean".equals(codeString))
          return FHIRTypes.BOOLEAN;
        if ("date".equals(codeString))
          return FHIRTypes.DATE;
        if ("dateTime".equals(codeString))
          return FHIRTypes.DATETIME;
        if ("decimal".equals(codeString))
          return FHIRTypes.DECIMAL;
        if ("instant".equals(codeString))
          return FHIRTypes.INSTANT;
        if ("integer".equals(codeString))
          return FHIRTypes.INTEGER;
        if ("positiveInt".equals(codeString))
          return FHIRTypes.POSITIVEINT;
        if ("unsignedInt".equals(codeString))
          return FHIRTypes.UNSIGNEDINT;
        if ("integer64".equals(codeString))
          return FHIRTypes.INTEGER64;
        if ("string".equals(codeString))
          return FHIRTypes.STRING;
        if ("code".equals(codeString))
          return FHIRTypes.CODE;
        if ("id".equals(codeString))
          return FHIRTypes.ID;
        if ("markdown".equals(codeString))
          return FHIRTypes.MARKDOWN;
        if ("time".equals(codeString))
          return FHIRTypes.TIME;
        if ("uri".equals(codeString))
          return FHIRTypes.URI;
        if ("canonical".equals(codeString))
          return FHIRTypes.CANONICAL;
        if ("oid".equals(codeString))
          return FHIRTypes.OID;
        if ("url".equals(codeString))
          return FHIRTypes.URL;
        if ("uuid".equals(codeString))
          return FHIRTypes.UUID;
        if ("Quantity".equals(codeString))
          return FHIRTypes.QUANTITY;
        if ("Age".equals(codeString))
          return FHIRTypes.AGE;
        if ("Count".equals(codeString))
          return FHIRTypes.COUNT;
        if ("Distance".equals(codeString))
          return FHIRTypes.DISTANCE;
        if ("Duration".equals(codeString))
          return FHIRTypes.DURATION;
        if ("Range".equals(codeString))
          return FHIRTypes.RANGE;
        if ("Ratio".equals(codeString))
          return FHIRTypes.RATIO;
        if ("RatioRange".equals(codeString))
          return FHIRTypes.RATIORANGE;
        if ("Reference".equals(codeString))
          return FHIRTypes.REFERENCE;
        if ("RelatedArtifact".equals(codeString))
          return FHIRTypes.RELATEDARTIFACT;
        if ("SampledData".equals(codeString))
          return FHIRTypes.SAMPLEDDATA;
        if ("Signature".equals(codeString))
          return FHIRTypes.SIGNATURE;
        if ("TriggerDefinition".equals(codeString))
          return FHIRTypes.TRIGGERDEFINITION;
        if ("UsageContext".equals(codeString))
          return FHIRTypes.USAGECONTEXT;
        if ("VirtualServiceDetail".equals(codeString))
          return FHIRTypes.VIRTUALSERVICEDETAIL;
        if ("xhtml".equals(codeString))
          return FHIRTypes.XHTML;
        if ("Resource".equals(codeString))
          return FHIRTypes.RESOURCE;
        if ("Binary".equals(codeString))
          return FHIRTypes.BINARY;
        if ("Bundle".equals(codeString))
          return FHIRTypes.BUNDLE;
        if ("DomainResource".equals(codeString))
          return FHIRTypes.DOMAINRESOURCE;
        if ("Account".equals(codeString))
          return FHIRTypes.ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return FHIRTypes.ACTIVITYDEFINITION;
        if ("ActorDefinition".equals(codeString))
          return FHIRTypes.ACTORDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return FHIRTypes.ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return FHIRTypes.ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return FHIRTypes.ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return FHIRTypes.APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return FHIRTypes.APPOINTMENTRESPONSE;
        if ("ArtifactAssessment".equals(codeString))
          return FHIRTypes.ARTIFACTASSESSMENT;
        if ("AuditEvent".equals(codeString))
          return FHIRTypes.AUDITEVENT;
        if ("Basic".equals(codeString))
          return FHIRTypes.BASIC;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return FHIRTypes.BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return FHIRTypes.BODYSTRUCTURE;
        if ("CanonicalResource".equals(codeString))
          return FHIRTypes.CANONICALRESOURCE;
        if ("CapabilityStatement".equals(codeString))
          return FHIRTypes.CAPABILITYSTATEMENT;
        if ("CarePlan".equals(codeString))
          return FHIRTypes.CAREPLAN;
        if ("CareTeam".equals(codeString))
          return FHIRTypes.CARETEAM;
        if ("ChargeItem".equals(codeString))
          return FHIRTypes.CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return FHIRTypes.CHARGEITEMDEFINITION;
        if ("Citation".equals(codeString))
          return FHIRTypes.CITATION;
        if ("Claim".equals(codeString))
          return FHIRTypes.CLAIM;
        if ("ClaimResponse".equals(codeString))
          return FHIRTypes.CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return FHIRTypes.CLINICALIMPRESSION;
        if ("ClinicalUseDefinition".equals(codeString))
          return FHIRTypes.CLINICALUSEDEFINITION;
        if ("CodeSystem".equals(codeString))
          return FHIRTypes.CODESYSTEM;
        if ("Communication".equals(codeString))
          return FHIRTypes.COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return FHIRTypes.COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return FHIRTypes.COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return FHIRTypes.COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return FHIRTypes.CONCEPTMAP;
        if ("Condition".equals(codeString))
          return FHIRTypes.CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return FHIRTypes.CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return FHIRTypes.CONSENT;
        if ("Contract".equals(codeString))
          return FHIRTypes.CONTRACT;
        if ("Coverage".equals(codeString))
          return FHIRTypes.COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return FHIRTypes.COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return FHIRTypes.COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return FHIRTypes.DETECTEDISSUE;
        if ("Device".equals(codeString))
          return FHIRTypes.DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return FHIRTypes.DEVICEDEFINITION;
        if ("DeviceDispense".equals(codeString))
          return FHIRTypes.DEVICEDISPENSE;
        if ("DeviceMetric".equals(codeString))
          return FHIRTypes.DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return FHIRTypes.DEVICEREQUEST;
        if ("DeviceUsage".equals(codeString))
          return FHIRTypes.DEVICEUSAGE;
        if ("DiagnosticReport".equals(codeString))
          return FHIRTypes.DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return FHIRTypes.DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return FHIRTypes.DOCUMENTREFERENCE;
        if ("Encounter".equals(codeString))
          return FHIRTypes.ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return FHIRTypes.ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return FHIRTypes.ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return FHIRTypes.ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return FHIRTypes.EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return FHIRTypes.EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return FHIRTypes.EVIDENCE;
        if ("EvidenceReport".equals(codeString))
          return FHIRTypes.EVIDENCEREPORT;
        if ("EvidenceVariable".equals(codeString))
          return FHIRTypes.EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return FHIRTypes.EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return FHIRTypes.EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return FHIRTypes.FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return FHIRTypes.FLAG;
        if ("FormularyItem".equals(codeString))
          return FHIRTypes.FORMULARYITEM;
        if ("GenomicStudy".equals(codeString))
          return FHIRTypes.GENOMICSTUDY;
        if ("Goal".equals(codeString))
          return FHIRTypes.GOAL;
        if ("GraphDefinition".equals(codeString))
          return FHIRTypes.GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return FHIRTypes.GROUP;
        if ("GuidanceResponse".equals(codeString))
          return FHIRTypes.GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return FHIRTypes.HEALTHCARESERVICE;
        if ("ImagingSelection".equals(codeString))
          return FHIRTypes.IMAGINGSELECTION;
        if ("ImagingStudy".equals(codeString))
          return FHIRTypes.IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return FHIRTypes.IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return FHIRTypes.IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return FHIRTypes.IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return FHIRTypes.IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return FHIRTypes.INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return FHIRTypes.INSURANCEPLAN;
        if ("InventoryReport".equals(codeString))
          return FHIRTypes.INVENTORYREPORT;
        if ("Invoice".equals(codeString))
          return FHIRTypes.INVOICE;
        if ("Library".equals(codeString))
          return FHIRTypes.LIBRARY;
        if ("Linkage".equals(codeString))
          return FHIRTypes.LINKAGE;
        if ("List".equals(codeString))
          return FHIRTypes.LIST;
        if ("Location".equals(codeString))
          return FHIRTypes.LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return FHIRTypes.MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return FHIRTypes.MEASURE;
        if ("MeasureReport".equals(codeString))
          return FHIRTypes.MEASUREREPORT;
        if ("Medication".equals(codeString))
          return FHIRTypes.MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return FHIRTypes.MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return FHIRTypes.MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return FHIRTypes.MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return FHIRTypes.MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return FHIRTypes.MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return FHIRTypes.MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return FHIRTypes.MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return FHIRTypes.MESSAGEHEADER;
        if ("MetadataResource".equals(codeString))
          return FHIRTypes.METADATARESOURCE;
        if ("MolecularSequence".equals(codeString))
          return FHIRTypes.MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return FHIRTypes.NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return FHIRTypes.NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return FHIRTypes.NUTRITIONORDER;
        if ("NutritionProduct".equals(codeString))
          return FHIRTypes.NUTRITIONPRODUCT;
        if ("Observation".equals(codeString))
          return FHIRTypes.OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return FHIRTypes.OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return FHIRTypes.OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return FHIRTypes.OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return FHIRTypes.ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return FHIRTypes.ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return FHIRTypes.PACKAGEDPRODUCTDEFINITION;
        if ("Patient".equals(codeString))
          return FHIRTypes.PATIENT;
        if ("PaymentNotice".equals(codeString))
          return FHIRTypes.PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return FHIRTypes.PAYMENTRECONCILIATION;
        if ("Permission".equals(codeString))
          return FHIRTypes.PERMISSION;
        if ("Person".equals(codeString))
          return FHIRTypes.PERSON;
        if ("PlanDefinition".equals(codeString))
          return FHIRTypes.PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return FHIRTypes.PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return FHIRTypes.PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return FHIRTypes.PROCEDURE;
        if ("Provenance".equals(codeString))
          return FHIRTypes.PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return FHIRTypes.QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return FHIRTypes.QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return FHIRTypes.REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return FHIRTypes.RELATEDPERSON;
        if ("RequestOrchestration".equals(codeString))
          return FHIRTypes.REQUESTORCHESTRATION;
        if ("Requirements".equals(codeString))
          return FHIRTypes.REQUIREMENTS;
        if ("ResearchStudy".equals(codeString))
          return FHIRTypes.RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return FHIRTypes.RESEARCHSUBJECT;
        if ("RiskAssessment".equals(codeString))
          return FHIRTypes.RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return FHIRTypes.SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return FHIRTypes.SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return FHIRTypes.SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return FHIRTypes.SLOT;
        if ("Specimen".equals(codeString))
          return FHIRTypes.SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return FHIRTypes.SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return FHIRTypes.STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return FHIRTypes.STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return FHIRTypes.SUBSCRIPTION;
        if ("SubscriptionStatus".equals(codeString))
          return FHIRTypes.SUBSCRIPTIONSTATUS;
        if ("SubscriptionTopic".equals(codeString))
          return FHIRTypes.SUBSCRIPTIONTOPIC;
        if ("Substance".equals(codeString))
          return FHIRTypes.SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return FHIRTypes.SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return FHIRTypes.SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return FHIRTypes.SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return FHIRTypes.SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return FHIRTypes.SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return FHIRTypes.SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return FHIRTypes.SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return FHIRTypes.SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return FHIRTypes.TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return FHIRTypes.TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return FHIRTypes.TESTREPORT;
        if ("TestScript".equals(codeString))
          return FHIRTypes.TESTSCRIPT;
        if ("Transport".equals(codeString))
          return FHIRTypes.TRANSPORT;
        if ("ValueSet".equals(codeString))
          return FHIRTypes.VALUESET;
        if ("VerificationResult".equals(codeString))
          return FHIRTypes.VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return FHIRTypes.VISIONPRESCRIPTION;
        if ("Parameters".equals(codeString))
          return FHIRTypes.PARAMETERS;
        throw new IllegalArgumentException("Unknown FHIRTypes code '"+codeString+"'");
        }
        public Enumeration<FHIRTypes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<FHIRTypes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("Base".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.BASE);
        if ("Element".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ELEMENT);
        if ("BackboneElement".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.BACKBONEELEMENT);
        if ("DataType".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DATATYPE);
        if ("Address".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ADDRESS);
        if ("Annotation".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ANNOTATION);
        if ("Attachment".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ATTACHMENT);
        if ("Availability".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.AVAILABILITY);
        if ("BackboneType".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.BACKBONETYPE);
        if ("Dosage".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DOSAGE);
        if ("ElementDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ELEMENTDEFINITION);
        if ("MarketingStatus".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MARKETINGSTATUS);
        if ("Population".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.POPULATION);
        if ("ProductShelfLife".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PRODUCTSHELFLIFE);
        if ("Timing".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.TIMING);
        if ("CodeableConcept".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CODEABLECONCEPT);
        if ("CodeableReference".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CODEABLEREFERENCE);
        if ("Coding".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CODING);
        if ("ContactDetail".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CONTACTDETAIL);
        if ("ContactPoint".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CONTACTPOINT);
        if ("Contributor".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CONTRIBUTOR);
        if ("DataRequirement".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DATAREQUIREMENT);
        if ("Expression".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.EXPRESSION);
        if ("ExtendedContactDetail".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.EXTENDEDCONTACTDETAIL);
        if ("Extension".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.EXTENSION);
        if ("HumanName".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.HUMANNAME);
        if ("Identifier".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.IDENTIFIER);
        if ("Meta".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.META);
        if ("MonetaryComponent".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MONETARYCOMPONENT);
        if ("Money".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MONEY);
        if ("Narrative".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.NARRATIVE);
        if ("ParameterDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PARAMETERDEFINITION);
        if ("Period".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PERIOD);
        if ("PrimitiveType".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PRIMITIVETYPE);
        if ("base64Binary".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.BASE64BINARY);
        if ("boolean".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.BOOLEAN);
        if ("date".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DATE);
        if ("dateTime".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DATETIME);
        if ("decimal".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DECIMAL);
        if ("instant".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.INSTANT);
        if ("integer".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.INTEGER);
        if ("positiveInt".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.POSITIVEINT);
        if ("unsignedInt".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.UNSIGNEDINT);
        if ("integer64".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.INTEGER64);
        if ("string".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.STRING);
        if ("code".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CODE);
        if ("id".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ID);
        if ("markdown".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MARKDOWN);
        if ("time".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.TIME);
        if ("uri".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.URI);
        if ("canonical".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CANONICAL);
        if ("oid".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.OID);
        if ("url".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.URL);
        if ("uuid".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.UUID);
        if ("Quantity".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.QUANTITY);
        if ("Age".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.AGE);
        if ("Count".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.COUNT);
        if ("Distance".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DISTANCE);
        if ("Duration".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DURATION);
        if ("Range".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.RANGE);
        if ("Ratio".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.RATIO);
        if ("RatioRange".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.RATIORANGE);
        if ("Reference".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.REFERENCE);
        if ("RelatedArtifact".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.RELATEDARTIFACT);
        if ("SampledData".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SAMPLEDDATA);
        if ("Signature".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SIGNATURE);
        if ("TriggerDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.TRIGGERDEFINITION);
        if ("UsageContext".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.USAGECONTEXT);
        if ("VirtualServiceDetail".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.VIRTUALSERVICEDETAIL);
        if ("xhtml".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.XHTML);
        if ("Resource".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.RESOURCE);
        if ("Binary".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.BINARY);
        if ("Bundle".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.BUNDLE);
        if ("DomainResource".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DOMAINRESOURCE);
        if ("Account".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ACCOUNT);
        if ("ActivityDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ACTIVITYDEFINITION);
        if ("ActorDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ACTORDEFINITION);
        if ("AdministrableProductDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ADMINISTRABLEPRODUCTDEFINITION);
        if ("AdverseEvent".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ADVERSEEVENT);
        if ("AllergyIntolerance".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ALLERGYINTOLERANCE);
        if ("Appointment".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.APPOINTMENT);
        if ("AppointmentResponse".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.APPOINTMENTRESPONSE);
        if ("ArtifactAssessment".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ARTIFACTASSESSMENT);
        if ("AuditEvent".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.AUDITEVENT);
        if ("Basic".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.BASIC);
        if ("BiologicallyDerivedProduct".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.BIOLOGICALLYDERIVEDPRODUCT);
        if ("BodyStructure".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.BODYSTRUCTURE);
        if ("CanonicalResource".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CANONICALRESOURCE);
        if ("CapabilityStatement".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CAPABILITYSTATEMENT);
        if ("CarePlan".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CAREPLAN);
        if ("CareTeam".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CARETEAM);
        if ("ChargeItem".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CHARGEITEM);
        if ("ChargeItemDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CHARGEITEMDEFINITION);
        if ("Citation".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CITATION);
        if ("Claim".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CLAIM);
        if ("ClaimResponse".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CLAIMRESPONSE);
        if ("ClinicalImpression".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CLINICALIMPRESSION);
        if ("ClinicalUseDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CLINICALUSEDEFINITION);
        if ("CodeSystem".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CODESYSTEM);
        if ("Communication".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.COMMUNICATION);
        if ("CommunicationRequest".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.COMMUNICATIONREQUEST);
        if ("CompartmentDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.COMPARTMENTDEFINITION);
        if ("Composition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.COMPOSITION);
        if ("ConceptMap".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CONCEPTMAP);
        if ("Condition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CONDITION);
        if ("ConditionDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CONDITIONDEFINITION);
        if ("Consent".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CONSENT);
        if ("Contract".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.CONTRACT);
        if ("Coverage".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.COVERAGE);
        if ("CoverageEligibilityRequest".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.COVERAGEELIGIBILITYREQUEST);
        if ("CoverageEligibilityResponse".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.COVERAGEELIGIBILITYRESPONSE);
        if ("DetectedIssue".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DETECTEDISSUE);
        if ("Device".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DEVICE);
        if ("DeviceDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DEVICEDEFINITION);
        if ("DeviceDispense".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DEVICEDISPENSE);
        if ("DeviceMetric".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DEVICEMETRIC);
        if ("DeviceRequest".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DEVICEREQUEST);
        if ("DeviceUsage".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DEVICEUSAGE);
        if ("DiagnosticReport".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DIAGNOSTICREPORT);
        if ("DocumentManifest".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DOCUMENTMANIFEST);
        if ("DocumentReference".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.DOCUMENTREFERENCE);
        if ("Encounter".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ENCOUNTER);
        if ("Endpoint".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ENDPOINT);
        if ("EnrollmentRequest".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ENROLLMENTREQUEST);
        if ("EnrollmentResponse".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ENROLLMENTRESPONSE);
        if ("EpisodeOfCare".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.EPISODEOFCARE);
        if ("EventDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.EVENTDEFINITION);
        if ("Evidence".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.EVIDENCE);
        if ("EvidenceReport".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.EVIDENCEREPORT);
        if ("EvidenceVariable".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.EVIDENCEVARIABLE);
        if ("ExampleScenario".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.EXAMPLESCENARIO);
        if ("ExplanationOfBenefit".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.EXPLANATIONOFBENEFIT);
        if ("FamilyMemberHistory".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.FAMILYMEMBERHISTORY);
        if ("Flag".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.FLAG);
        if ("FormularyItem".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.FORMULARYITEM);
        if ("GenomicStudy".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.GENOMICSTUDY);
        if ("Goal".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.GOAL);
        if ("GraphDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.GRAPHDEFINITION);
        if ("Group".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.GROUP);
        if ("GuidanceResponse".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.GUIDANCERESPONSE);
        if ("HealthcareService".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.HEALTHCARESERVICE);
        if ("ImagingSelection".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.IMAGINGSELECTION);
        if ("ImagingStudy".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.IMAGINGSTUDY);
        if ("Immunization".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.IMMUNIZATION);
        if ("ImmunizationEvaluation".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.IMMUNIZATIONEVALUATION);
        if ("ImmunizationRecommendation".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.IMMUNIZATIONRECOMMENDATION);
        if ("ImplementationGuide".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.IMPLEMENTATIONGUIDE);
        if ("Ingredient".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.INGREDIENT);
        if ("InsurancePlan".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.INSURANCEPLAN);
        if ("InventoryReport".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.INVENTORYREPORT);
        if ("Invoice".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.INVOICE);
        if ("Library".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.LIBRARY);
        if ("Linkage".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.LINKAGE);
        if ("List".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.LIST);
        if ("Location".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.LOCATION);
        if ("ManufacturedItemDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MANUFACTUREDITEMDEFINITION);
        if ("Measure".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MEASURE);
        if ("MeasureReport".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MEASUREREPORT);
        if ("Medication".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MEDICATION);
        if ("MedicationAdministration".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MEDICATIONADMINISTRATION);
        if ("MedicationDispense".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MEDICATIONDISPENSE);
        if ("MedicationKnowledge".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MEDICATIONKNOWLEDGE);
        if ("MedicationRequest".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MEDICATIONREQUEST);
        if ("MedicationUsage".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MEDICATIONUSAGE);
        if ("MedicinalProductDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MEDICINALPRODUCTDEFINITION);
        if ("MessageDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MESSAGEDEFINITION);
        if ("MessageHeader".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MESSAGEHEADER);
        if ("MetadataResource".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.METADATARESOURCE);
        if ("MolecularSequence".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.MOLECULARSEQUENCE);
        if ("NamingSystem".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.NAMINGSYSTEM);
        if ("NutritionIntake".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.NUTRITIONINTAKE);
        if ("NutritionOrder".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.NUTRITIONORDER);
        if ("NutritionProduct".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.NUTRITIONPRODUCT);
        if ("Observation".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.OBSERVATION);
        if ("ObservationDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.OBSERVATIONDEFINITION);
        if ("OperationDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.OPERATIONDEFINITION);
        if ("OperationOutcome".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.OPERATIONOUTCOME);
        if ("Organization".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ORGANIZATION);
        if ("OrganizationAffiliation".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.ORGANIZATIONAFFILIATION);
        if ("PackagedProductDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PACKAGEDPRODUCTDEFINITION);
        if ("Patient".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PATIENT);
        if ("PaymentNotice".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PAYMENTNOTICE);
        if ("PaymentReconciliation".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PAYMENTRECONCILIATION);
        if ("Permission".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PERMISSION);
        if ("Person".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PERSON);
        if ("PlanDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PLANDEFINITION);
        if ("Practitioner".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PRACTITIONER);
        if ("PractitionerRole".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PRACTITIONERROLE);
        if ("Procedure".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PROCEDURE);
        if ("Provenance".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PROVENANCE);
        if ("Questionnaire".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.QUESTIONNAIRE);
        if ("QuestionnaireResponse".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.QUESTIONNAIRERESPONSE);
        if ("RegulatedAuthorization".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.REGULATEDAUTHORIZATION);
        if ("RelatedPerson".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.RELATEDPERSON);
        if ("RequestOrchestration".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.REQUESTORCHESTRATION);
        if ("Requirements".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.REQUIREMENTS);
        if ("ResearchStudy".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.RESEARCHSTUDY);
        if ("ResearchSubject".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.RESEARCHSUBJECT);
        if ("RiskAssessment".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.RISKASSESSMENT);
        if ("Schedule".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SCHEDULE);
        if ("SearchParameter".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SEARCHPARAMETER);
        if ("ServiceRequest".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SERVICEREQUEST);
        if ("Slot".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SLOT);
        if ("Specimen".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SPECIMEN);
        if ("SpecimenDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SPECIMENDEFINITION);
        if ("StructureDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.STRUCTUREDEFINITION);
        if ("StructureMap".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.STRUCTUREMAP);
        if ("Subscription".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUBSCRIPTION);
        if ("SubscriptionStatus".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUBSCRIPTIONSTATUS);
        if ("SubscriptionTopic".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUBSCRIPTIONTOPIC);
        if ("Substance".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUBSTANCE);
        if ("SubstanceDefinition".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUBSTANCEDEFINITION);
        if ("SubstanceNucleicAcid".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUBSTANCENUCLEICACID);
        if ("SubstancePolymer".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUBSTANCEPOLYMER);
        if ("SubstanceProtein".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUBSTANCEPROTEIN);
        if ("SubstanceReferenceInformation".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUBSTANCEREFERENCEINFORMATION);
        if ("SubstanceSourceMaterial".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUBSTANCESOURCEMATERIAL);
        if ("SupplyDelivery".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUPPLYDELIVERY);
        if ("SupplyRequest".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.SUPPLYREQUEST);
        if ("Task".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.TASK);
        if ("TerminologyCapabilities".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.TERMINOLOGYCAPABILITIES);
        if ("TestReport".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.TESTREPORT);
        if ("TestScript".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.TESTSCRIPT);
        if ("Transport".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.TRANSPORT);
        if ("ValueSet".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.VALUESET);
        if ("VerificationResult".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.VERIFICATIONRESULT);
        if ("VisionPrescription".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.VISIONPRESCRIPTION);
        if ("Parameters".equals(codeString))
          return new Enumeration<FHIRTypes>(this, FHIRTypes.PARAMETERS);
        throw new FHIRException("Unknown FHIRTypes code '"+codeString+"'");
        }
    public String toCode(FHIRTypes code) {
      if (code == FHIRTypes.BASE)
        return "Base";
      if (code == FHIRTypes.ELEMENT)
        return "Element";
      if (code == FHIRTypes.BACKBONEELEMENT)
        return "BackboneElement";
      if (code == FHIRTypes.DATATYPE)
        return "DataType";
      if (code == FHIRTypes.ADDRESS)
        return "Address";
      if (code == FHIRTypes.ANNOTATION)
        return "Annotation";
      if (code == FHIRTypes.ATTACHMENT)
        return "Attachment";
      if (code == FHIRTypes.AVAILABILITY)
        return "Availability";
      if (code == FHIRTypes.BACKBONETYPE)
        return "BackboneType";
      if (code == FHIRTypes.DOSAGE)
        return "Dosage";
      if (code == FHIRTypes.ELEMENTDEFINITION)
        return "ElementDefinition";
      if (code == FHIRTypes.MARKETINGSTATUS)
        return "MarketingStatus";
      if (code == FHIRTypes.POPULATION)
        return "Population";
      if (code == FHIRTypes.PRODUCTSHELFLIFE)
        return "ProductShelfLife";
      if (code == FHIRTypes.TIMING)
        return "Timing";
      if (code == FHIRTypes.CODEABLECONCEPT)
        return "CodeableConcept";
      if (code == FHIRTypes.CODEABLEREFERENCE)
        return "CodeableReference";
      if (code == FHIRTypes.CODING)
        return "Coding";
      if (code == FHIRTypes.CONTACTDETAIL)
        return "ContactDetail";
      if (code == FHIRTypes.CONTACTPOINT)
        return "ContactPoint";
      if (code == FHIRTypes.CONTRIBUTOR)
        return "Contributor";
      if (code == FHIRTypes.DATAREQUIREMENT)
        return "DataRequirement";
      if (code == FHIRTypes.EXPRESSION)
        return "Expression";
      if (code == FHIRTypes.EXTENDEDCONTACTDETAIL)
        return "ExtendedContactDetail";
      if (code == FHIRTypes.EXTENSION)
        return "Extension";
      if (code == FHIRTypes.HUMANNAME)
        return "HumanName";
      if (code == FHIRTypes.IDENTIFIER)
        return "Identifier";
      if (code == FHIRTypes.META)
        return "Meta";
      if (code == FHIRTypes.MONETARYCOMPONENT)
        return "MonetaryComponent";
      if (code == FHIRTypes.MONEY)
        return "Money";
      if (code == FHIRTypes.NARRATIVE)
        return "Narrative";
      if (code == FHIRTypes.PARAMETERDEFINITION)
        return "ParameterDefinition";
      if (code == FHIRTypes.PERIOD)
        return "Period";
      if (code == FHIRTypes.PRIMITIVETYPE)
        return "PrimitiveType";
      if (code == FHIRTypes.BASE64BINARY)
        return "base64Binary";
      if (code == FHIRTypes.BOOLEAN)
        return "boolean";
      if (code == FHIRTypes.DATE)
        return "date";
      if (code == FHIRTypes.DATETIME)
        return "dateTime";
      if (code == FHIRTypes.DECIMAL)
        return "decimal";
      if (code == FHIRTypes.INSTANT)
        return "instant";
      if (code == FHIRTypes.INTEGER)
        return "integer";
      if (code == FHIRTypes.POSITIVEINT)
        return "positiveInt";
      if (code == FHIRTypes.UNSIGNEDINT)
        return "unsignedInt";
      if (code == FHIRTypes.INTEGER64)
        return "integer64";
      if (code == FHIRTypes.STRING)
        return "string";
      if (code == FHIRTypes.CODE)
        return "code";
      if (code == FHIRTypes.ID)
        return "id";
      if (code == FHIRTypes.MARKDOWN)
        return "markdown";
      if (code == FHIRTypes.TIME)
        return "time";
      if (code == FHIRTypes.URI)
        return "uri";
      if (code == FHIRTypes.CANONICAL)
        return "canonical";
      if (code == FHIRTypes.OID)
        return "oid";
      if (code == FHIRTypes.URL)
        return "url";
      if (code == FHIRTypes.UUID)
        return "uuid";
      if (code == FHIRTypes.QUANTITY)
        return "Quantity";
      if (code == FHIRTypes.AGE)
        return "Age";
      if (code == FHIRTypes.COUNT)
        return "Count";
      if (code == FHIRTypes.DISTANCE)
        return "Distance";
      if (code == FHIRTypes.DURATION)
        return "Duration";
      if (code == FHIRTypes.RANGE)
        return "Range";
      if (code == FHIRTypes.RATIO)
        return "Ratio";
      if (code == FHIRTypes.RATIORANGE)
        return "RatioRange";
      if (code == FHIRTypes.REFERENCE)
        return "Reference";
      if (code == FHIRTypes.RELATEDARTIFACT)
        return "RelatedArtifact";
      if (code == FHIRTypes.SAMPLEDDATA)
        return "SampledData";
      if (code == FHIRTypes.SIGNATURE)
        return "Signature";
      if (code == FHIRTypes.TRIGGERDEFINITION)
        return "TriggerDefinition";
      if (code == FHIRTypes.USAGECONTEXT)
        return "UsageContext";
      if (code == FHIRTypes.VIRTUALSERVICEDETAIL)
        return "VirtualServiceDetail";
      if (code == FHIRTypes.XHTML)
        return "xhtml";
      if (code == FHIRTypes.RESOURCE)
        return "Resource";
      if (code == FHIRTypes.BINARY)
        return "Binary";
      if (code == FHIRTypes.BUNDLE)
        return "Bundle";
      if (code == FHIRTypes.DOMAINRESOURCE)
        return "DomainResource";
      if (code == FHIRTypes.ACCOUNT)
        return "Account";
      if (code == FHIRTypes.ACTIVITYDEFINITION)
        return "ActivityDefinition";
      if (code == FHIRTypes.ACTORDEFINITION)
        return "ActorDefinition";
      if (code == FHIRTypes.ADMINISTRABLEPRODUCTDEFINITION)
        return "AdministrableProductDefinition";
      if (code == FHIRTypes.ADVERSEEVENT)
        return "AdverseEvent";
      if (code == FHIRTypes.ALLERGYINTOLERANCE)
        return "AllergyIntolerance";
      if (code == FHIRTypes.APPOINTMENT)
        return "Appointment";
      if (code == FHIRTypes.APPOINTMENTRESPONSE)
        return "AppointmentResponse";
      if (code == FHIRTypes.ARTIFACTASSESSMENT)
        return "ArtifactAssessment";
      if (code == FHIRTypes.AUDITEVENT)
        return "AuditEvent";
      if (code == FHIRTypes.BASIC)
        return "Basic";
      if (code == FHIRTypes.BIOLOGICALLYDERIVEDPRODUCT)
        return "BiologicallyDerivedProduct";
      if (code == FHIRTypes.BODYSTRUCTURE)
        return "BodyStructure";
      if (code == FHIRTypes.CANONICALRESOURCE)
        return "CanonicalResource";
      if (code == FHIRTypes.CAPABILITYSTATEMENT)
        return "CapabilityStatement";
      if (code == FHIRTypes.CAREPLAN)
        return "CarePlan";
      if (code == FHIRTypes.CARETEAM)
        return "CareTeam";
      if (code == FHIRTypes.CHARGEITEM)
        return "ChargeItem";
      if (code == FHIRTypes.CHARGEITEMDEFINITION)
        return "ChargeItemDefinition";
      if (code == FHIRTypes.CITATION)
        return "Citation";
      if (code == FHIRTypes.CLAIM)
        return "Claim";
      if (code == FHIRTypes.CLAIMRESPONSE)
        return "ClaimResponse";
      if (code == FHIRTypes.CLINICALIMPRESSION)
        return "ClinicalImpression";
      if (code == FHIRTypes.CLINICALUSEDEFINITION)
        return "ClinicalUseDefinition";
      if (code == FHIRTypes.CODESYSTEM)
        return "CodeSystem";
      if (code == FHIRTypes.COMMUNICATION)
        return "Communication";
      if (code == FHIRTypes.COMMUNICATIONREQUEST)
        return "CommunicationRequest";
      if (code == FHIRTypes.COMPARTMENTDEFINITION)
        return "CompartmentDefinition";
      if (code == FHIRTypes.COMPOSITION)
        return "Composition";
      if (code == FHIRTypes.CONCEPTMAP)
        return "ConceptMap";
      if (code == FHIRTypes.CONDITION)
        return "Condition";
      if (code == FHIRTypes.CONDITIONDEFINITION)
        return "ConditionDefinition";
      if (code == FHIRTypes.CONSENT)
        return "Consent";
      if (code == FHIRTypes.CONTRACT)
        return "Contract";
      if (code == FHIRTypes.COVERAGE)
        return "Coverage";
      if (code == FHIRTypes.COVERAGEELIGIBILITYREQUEST)
        return "CoverageEligibilityRequest";
      if (code == FHIRTypes.COVERAGEELIGIBILITYRESPONSE)
        return "CoverageEligibilityResponse";
      if (code == FHIRTypes.DETECTEDISSUE)
        return "DetectedIssue";
      if (code == FHIRTypes.DEVICE)
        return "Device";
      if (code == FHIRTypes.DEVICEDEFINITION)
        return "DeviceDefinition";
      if (code == FHIRTypes.DEVICEDISPENSE)
        return "DeviceDispense";
      if (code == FHIRTypes.DEVICEMETRIC)
        return "DeviceMetric";
      if (code == FHIRTypes.DEVICEREQUEST)
        return "DeviceRequest";
      if (code == FHIRTypes.DEVICEUSAGE)
        return "DeviceUsage";
      if (code == FHIRTypes.DIAGNOSTICREPORT)
        return "DiagnosticReport";
      if (code == FHIRTypes.DOCUMENTMANIFEST)
        return "DocumentManifest";
      if (code == FHIRTypes.DOCUMENTREFERENCE)
        return "DocumentReference";
      if (code == FHIRTypes.ENCOUNTER)
        return "Encounter";
      if (code == FHIRTypes.ENDPOINT)
        return "Endpoint";
      if (code == FHIRTypes.ENROLLMENTREQUEST)
        return "EnrollmentRequest";
      if (code == FHIRTypes.ENROLLMENTRESPONSE)
        return "EnrollmentResponse";
      if (code == FHIRTypes.EPISODEOFCARE)
        return "EpisodeOfCare";
      if (code == FHIRTypes.EVENTDEFINITION)
        return "EventDefinition";
      if (code == FHIRTypes.EVIDENCE)
        return "Evidence";
      if (code == FHIRTypes.EVIDENCEREPORT)
        return "EvidenceReport";
      if (code == FHIRTypes.EVIDENCEVARIABLE)
        return "EvidenceVariable";
      if (code == FHIRTypes.EXAMPLESCENARIO)
        return "ExampleScenario";
      if (code == FHIRTypes.EXPLANATIONOFBENEFIT)
        return "ExplanationOfBenefit";
      if (code == FHIRTypes.FAMILYMEMBERHISTORY)
        return "FamilyMemberHistory";
      if (code == FHIRTypes.FLAG)
        return "Flag";
      if (code == FHIRTypes.FORMULARYITEM)
        return "FormularyItem";
      if (code == FHIRTypes.GENOMICSTUDY)
        return "GenomicStudy";
      if (code == FHIRTypes.GOAL)
        return "Goal";
      if (code == FHIRTypes.GRAPHDEFINITION)
        return "GraphDefinition";
      if (code == FHIRTypes.GROUP)
        return "Group";
      if (code == FHIRTypes.GUIDANCERESPONSE)
        return "GuidanceResponse";
      if (code == FHIRTypes.HEALTHCARESERVICE)
        return "HealthcareService";
      if (code == FHIRTypes.IMAGINGSELECTION)
        return "ImagingSelection";
      if (code == FHIRTypes.IMAGINGSTUDY)
        return "ImagingStudy";
      if (code == FHIRTypes.IMMUNIZATION)
        return "Immunization";
      if (code == FHIRTypes.IMMUNIZATIONEVALUATION)
        return "ImmunizationEvaluation";
      if (code == FHIRTypes.IMMUNIZATIONRECOMMENDATION)
        return "ImmunizationRecommendation";
      if (code == FHIRTypes.IMPLEMENTATIONGUIDE)
        return "ImplementationGuide";
      if (code == FHIRTypes.INGREDIENT)
        return "Ingredient";
      if (code == FHIRTypes.INSURANCEPLAN)
        return "InsurancePlan";
      if (code == FHIRTypes.INVENTORYREPORT)
        return "InventoryReport";
      if (code == FHIRTypes.INVOICE)
        return "Invoice";
      if (code == FHIRTypes.LIBRARY)
        return "Library";
      if (code == FHIRTypes.LINKAGE)
        return "Linkage";
      if (code == FHIRTypes.LIST)
        return "List";
      if (code == FHIRTypes.LOCATION)
        return "Location";
      if (code == FHIRTypes.MANUFACTUREDITEMDEFINITION)
        return "ManufacturedItemDefinition";
      if (code == FHIRTypes.MEASURE)
        return "Measure";
      if (code == FHIRTypes.MEASUREREPORT)
        return "MeasureReport";
      if (code == FHIRTypes.MEDICATION)
        return "Medication";
      if (code == FHIRTypes.MEDICATIONADMINISTRATION)
        return "MedicationAdministration";
      if (code == FHIRTypes.MEDICATIONDISPENSE)
        return "MedicationDispense";
      if (code == FHIRTypes.MEDICATIONKNOWLEDGE)
        return "MedicationKnowledge";
      if (code == FHIRTypes.MEDICATIONREQUEST)
        return "MedicationRequest";
      if (code == FHIRTypes.MEDICATIONUSAGE)
        return "MedicationUsage";
      if (code == FHIRTypes.MEDICINALPRODUCTDEFINITION)
        return "MedicinalProductDefinition";
      if (code == FHIRTypes.MESSAGEDEFINITION)
        return "MessageDefinition";
      if (code == FHIRTypes.MESSAGEHEADER)
        return "MessageHeader";
      if (code == FHIRTypes.METADATARESOURCE)
        return "MetadataResource";
      if (code == FHIRTypes.MOLECULARSEQUENCE)
        return "MolecularSequence";
      if (code == FHIRTypes.NAMINGSYSTEM)
        return "NamingSystem";
      if (code == FHIRTypes.NUTRITIONINTAKE)
        return "NutritionIntake";
      if (code == FHIRTypes.NUTRITIONORDER)
        return "NutritionOrder";
      if (code == FHIRTypes.NUTRITIONPRODUCT)
        return "NutritionProduct";
      if (code == FHIRTypes.OBSERVATION)
        return "Observation";
      if (code == FHIRTypes.OBSERVATIONDEFINITION)
        return "ObservationDefinition";
      if (code == FHIRTypes.OPERATIONDEFINITION)
        return "OperationDefinition";
      if (code == FHIRTypes.OPERATIONOUTCOME)
        return "OperationOutcome";
      if (code == FHIRTypes.ORGANIZATION)
        return "Organization";
      if (code == FHIRTypes.ORGANIZATIONAFFILIATION)
        return "OrganizationAffiliation";
      if (code == FHIRTypes.PACKAGEDPRODUCTDEFINITION)
        return "PackagedProductDefinition";
      if (code == FHIRTypes.PATIENT)
        return "Patient";
      if (code == FHIRTypes.PAYMENTNOTICE)
        return "PaymentNotice";
      if (code == FHIRTypes.PAYMENTRECONCILIATION)
        return "PaymentReconciliation";
      if (code == FHIRTypes.PERMISSION)
        return "Permission";
      if (code == FHIRTypes.PERSON)
        return "Person";
      if (code == FHIRTypes.PLANDEFINITION)
        return "PlanDefinition";
      if (code == FHIRTypes.PRACTITIONER)
        return "Practitioner";
      if (code == FHIRTypes.PRACTITIONERROLE)
        return "PractitionerRole";
      if (code == FHIRTypes.PROCEDURE)
        return "Procedure";
      if (code == FHIRTypes.PROVENANCE)
        return "Provenance";
      if (code == FHIRTypes.QUESTIONNAIRE)
        return "Questionnaire";
      if (code == FHIRTypes.QUESTIONNAIRERESPONSE)
        return "QuestionnaireResponse";
      if (code == FHIRTypes.REGULATEDAUTHORIZATION)
        return "RegulatedAuthorization";
      if (code == FHIRTypes.RELATEDPERSON)
        return "RelatedPerson";
      if (code == FHIRTypes.REQUESTORCHESTRATION)
        return "RequestOrchestration";
      if (code == FHIRTypes.REQUIREMENTS)
        return "Requirements";
      if (code == FHIRTypes.RESEARCHSTUDY)
        return "ResearchStudy";
      if (code == FHIRTypes.RESEARCHSUBJECT)
        return "ResearchSubject";
      if (code == FHIRTypes.RISKASSESSMENT)
        return "RiskAssessment";
      if (code == FHIRTypes.SCHEDULE)
        return "Schedule";
      if (code == FHIRTypes.SEARCHPARAMETER)
        return "SearchParameter";
      if (code == FHIRTypes.SERVICEREQUEST)
        return "ServiceRequest";
      if (code == FHIRTypes.SLOT)
        return "Slot";
      if (code == FHIRTypes.SPECIMEN)
        return "Specimen";
      if (code == FHIRTypes.SPECIMENDEFINITION)
        return "SpecimenDefinition";
      if (code == FHIRTypes.STRUCTUREDEFINITION)
        return "StructureDefinition";
      if (code == FHIRTypes.STRUCTUREMAP)
        return "StructureMap";
      if (code == FHIRTypes.SUBSCRIPTION)
        return "Subscription";
      if (code == FHIRTypes.SUBSCRIPTIONSTATUS)
        return "SubscriptionStatus";
      if (code == FHIRTypes.SUBSCRIPTIONTOPIC)
        return "SubscriptionTopic";
      if (code == FHIRTypes.SUBSTANCE)
        return "Substance";
      if (code == FHIRTypes.SUBSTANCEDEFINITION)
        return "SubstanceDefinition";
      if (code == FHIRTypes.SUBSTANCENUCLEICACID)
        return "SubstanceNucleicAcid";
      if (code == FHIRTypes.SUBSTANCEPOLYMER)
        return "SubstancePolymer";
      if (code == FHIRTypes.SUBSTANCEPROTEIN)
        return "SubstanceProtein";
      if (code == FHIRTypes.SUBSTANCEREFERENCEINFORMATION)
        return "SubstanceReferenceInformation";
      if (code == FHIRTypes.SUBSTANCESOURCEMATERIAL)
        return "SubstanceSourceMaterial";
      if (code == FHIRTypes.SUPPLYDELIVERY)
        return "SupplyDelivery";
      if (code == FHIRTypes.SUPPLYREQUEST)
        return "SupplyRequest";
      if (code == FHIRTypes.TASK)
        return "Task";
      if (code == FHIRTypes.TERMINOLOGYCAPABILITIES)
        return "TerminologyCapabilities";
      if (code == FHIRTypes.TESTREPORT)
        return "TestReport";
      if (code == FHIRTypes.TESTSCRIPT)
        return "TestScript";
      if (code == FHIRTypes.TRANSPORT)
        return "Transport";
      if (code == FHIRTypes.VALUESET)
        return "ValueSet";
      if (code == FHIRTypes.VERIFICATIONRESULT)
        return "VerificationResult";
      if (code == FHIRTypes.VISIONPRESCRIPTION)
        return "VisionPrescription";
      if (code == FHIRTypes.PARAMETERS)
        return "Parameters";
      return "?";
      }
    public String toSystem(FHIRTypes code) {
      return code.getSystem();
      }
    }

    public enum FHIRVersion {
        /**
         * Oldest archived version of FHIR.
         */
        _0_01, 
        /**
         * 1st Draft for Comment (Sept 2012 Ballot).
         */
        _0_05, 
        /**
         * 2nd Draft for Comment (January 2013 Ballot).
         */
        _0_06, 
        /**
         * DSTU 1 Ballot version.
         */
        _0_11, 
        /**
         * DSTU 1 version.
         */
        _0_0, 
        /**
         * DSTU 1 Official version.
         */
        _0_0_80, 
        /**
         * DSTU 1 Official version Technical Errata #1.
         */
        _0_0_81, 
        /**
         * DSTU 1 Official version Technical Errata #2.
         */
        _0_0_82, 
        /**
         * January 2015 Ballot.
         */
        _0_4, 
        /**
         * Draft For Comment (January 2015 Ballot).
         */
        _0_4_0, 
        /**
         * May 2015 Ballot.
         */
        _0_5, 
        /**
         * DSTU 2 Ballot version (May 2015 Ballot).
         */
        _0_5_0, 
        /**
         * DSTU 2 version.
         */
        _1_0, 
        /**
         * DSTU 2 QA Preview + CQIF Ballot (Sep 2015).
         */
        _1_0_0, 
        /**
         * DSTU 2 (Official version).
         */
        _1_0_1, 
        /**
         * DSTU 2 (Official version) with 1 technical errata.
         */
        _1_0_2, 
        /**
         * GAO Ballot version.
         */
        _1_1, 
        /**
         * GAO Ballot + draft changes to main FHIR standard.
         */
        _1_1_0, 
        /**
         * Connectathon 12 (Montreal) version.
         */
        _1_4, 
        /**
         * CQF on FHIR Ballot + Connectathon 12 (Montreal).
         */
        _1_4_0, 
        /**
         * Connectathon 13 (Baltimore) version.
         */
        _1_6, 
        /**
         * FHIR STU3 Ballot + Connectathon 13 (Baltimore).
         */
        _1_6_0, 
        /**
         * Connectathon 14 (San Antonio) version.
         */
        _1_8, 
        /**
         * FHIR STU3 Candidate + Connectathon 14 (San Antonio).
         */
        _1_8_0, 
        /**
         * STU3 version.
         */
        _3_0, 
        /**
         * FHIR Release 3 (STU).
         */
        _3_0_0, 
        /**
         * FHIR Release 3 (STU) with 1 technical errata.
         */
        _3_0_1, 
        /**
         * FHIR Release 3 (STU) with 2 technical errata.
         */
        _3_0_2, 
        /**
         * R4 Ballot #1 version.
         */
        _3_3, 
        /**
         * R4 Ballot #1 + Connectaton 18 (Cologne).
         */
        _3_3_0, 
        /**
         * R4 Ballot #2 version.
         */
        _3_5, 
        /**
         * R4 Ballot #2 + Connectathon 19 (Baltimore).
         */
        _3_5_0, 
        /**
         * R4 version.
         */
        _4_0, 
        /**
         * FHIR Release 4 (Normative + STU).
         */
        _4_0_0, 
        /**
         * FHIR Release 4 (Normative + STU) with 1 technical errata.
         */
        _4_0_1, 
        /**
         * R4B Ballot #1 version.
         */
        _4_1, 
        /**
         * R4B Ballot #1 + Connectathon 27 (Virtual).
         */
        _4_1_0, 
        /**
         * R5 Preview #1 version.
         */
        _4_2, 
        /**
         * R5 Preview #1 + Connectathon 23 (Sydney).
         */
        _4_2_0, 
        /**
         * R4B version.
         */
        _4_3, 
        /**
         * FHIR Release 4B (Normative + STU).
         */
        _4_3_0, 
        /**
         * R5 Preview #2 version.
         */
        _4_4, 
        /**
         * R5 Preview #2 + Connectathon 24 (Virtual).
         */
        _4_4_0, 
        /**
         * R5 Preview #3 version.
         */
        _4_5, 
        /**
         * R5 Preview #3 + Connectathon 25 (Virtual).
         */
        _4_5_0, 
        /**
         * R5 Draft Ballot version.
         */
        _4_6, 
        /**
         * R5 Draft Ballot + Connectathon 27 (Virtual).
         */
        _4_6_0, 
        /**
         * R5 Versions.
         */
        _5_0, 
        /**
         * R5 Final Version.
         */
        _5_0_0, 
        /**
         * R5 Rolling ci-build.
         */
        _5_0_0CIBUILD, 
        /**
         * R5 Preview #2.
         */
        _5_0_0SNAPSHOT1, 
        /**
         * R5 Interim tooling stage.
         */
        _5_0_0SNAPSHOT2, 
        /**
         * R5 Ballot.
         */
        _5_0_0BALLOT, 
        /**
         * added to help the parsers
         */
        NULL;
        public static FHIRVersion fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("0.01".equals(codeString))
          return _0_01;
        if ("0.05".equals(codeString))
          return _0_05;
        if ("0.06".equals(codeString))
          return _0_06;
        if ("0.11".equals(codeString))
          return _0_11;
        if ("0.0".equals(codeString))
          return _0_0;
        if ("0.0.80".equals(codeString))
          return _0_0_80;
        if ("0.0.81".equals(codeString))
          return _0_0_81;
        if ("0.0.82".equals(codeString))
          return _0_0_82;
        if ("0.4".equals(codeString))
          return _0_4;
        if ("0.4.0".equals(codeString))
          return _0_4_0;
        if ("0.5".equals(codeString))
          return _0_5;
        if ("0.5.0".equals(codeString))
          return _0_5_0;
        if ("1.0".equals(codeString))
          return _1_0;
        if ("1.0.0".equals(codeString))
          return _1_0_0;
        if ("1.0.1".equals(codeString))
          return _1_0_1;
        if ("1.0.2".equals(codeString))
          return _1_0_2;
        if ("1.1".equals(codeString))
          return _1_1;
        if ("1.1.0".equals(codeString))
          return _1_1_0;
        if ("1.4".equals(codeString))
          return _1_4;
        if ("1.4.0".equals(codeString))
          return _1_4_0;
        if ("1.6".equals(codeString))
          return _1_6;
        if ("1.6.0".equals(codeString))
          return _1_6_0;
        if ("1.8".equals(codeString))
          return _1_8;
        if ("1.8.0".equals(codeString))
          return _1_8_0;
        if ("3.0".equals(codeString))
          return _3_0;
        if ("3.0.0".equals(codeString))
          return _3_0_0;
        if ("3.0.1".equals(codeString))
          return _3_0_1;
        if ("3.0.2".equals(codeString))
          return _3_0_2;
        if ("3.3".equals(codeString))
          return _3_3;
        if ("3.3.0".equals(codeString))
          return _3_3_0;
        if ("3.5".equals(codeString))
          return _3_5;
        if ("3.5.0".equals(codeString))
          return _3_5_0;
        if ("4.0".equals(codeString))
          return _4_0;
        if ("4.0.0".equals(codeString))
          return _4_0_0;
        if ("4.0.1".equals(codeString))
          return _4_0_1;
        if ("4.1".equals(codeString))
          return _4_1;
        if ("4.1.0".equals(codeString))
          return _4_1_0;
        if ("4.2".equals(codeString))
          return _4_2;
        if ("4.2.0".equals(codeString))
          return _4_2_0;
        if ("4.3".equals(codeString))
          return _4_3;
        if ("4.3.0".equals(codeString))
          return _4_3_0;
        if ("4.4".equals(codeString))
          return _4_4;
        if ("4.4.0".equals(codeString))
          return _4_4_0;
        if ("4.5".equals(codeString))
          return _4_5;
        if ("4.5.0".equals(codeString))
          return _4_5_0;
        if ("4.6".equals(codeString))
          return _4_6;
        if ("4.6.0".equals(codeString))
          return _4_6_0;
        if ("5.0".equals(codeString))
          return _5_0;
        if ("5.0.0".equals(codeString))
          return _5_0_0;
        if ("5.0.0-cibuild".equals(codeString))
          return _5_0_0CIBUILD;
        if ("5.0.0-snapshot1".equals(codeString))
          return _5_0_0SNAPSHOT1;
        if ("5.0.0-snapshot2".equals(codeString))
          return _5_0_0SNAPSHOT2;
        if ("5.0.0-ballot".equals(codeString))
          return _5_0_0BALLOT;
        throw new FHIRException("Unknown FHIRVersion code '"+codeString+"'");
        }
        public static boolean isValidCode(String codeString) {
          if (codeString == null || "".equals(codeString))
              return false;
      if ("0.01".equals(codeString))
        return true;
      if ("0.05".equals(codeString))
        return true;
      if ("0.06".equals(codeString))
        return true;
      if ("0.11".equals(codeString))
        return true;
      if ("0.0".equals(codeString))
        return true;
      if ("0.0.80".equals(codeString))
        return true;
      if ("0.0.81".equals(codeString))
        return true;
      if ("0.0.82".equals(codeString))
        return true;
      if ("0.4".equals(codeString))
        return true;
      if ("0.4.0".equals(codeString))
        return true;
      if ("0.5".equals(codeString))
        return true;
      if ("0.5.0".equals(codeString))
        return true;
      if ("1.0".equals(codeString))
        return true;
      if ("1.0.0".equals(codeString))
        return true;
      if ("1.0.1".equals(codeString))
        return true;
      if ("1.0.2".equals(codeString))
        return true;
      if ("1.1".equals(codeString))
        return true;
      if ("1.1.0".equals(codeString))
        return true;
      if ("1.4".equals(codeString))
        return true;
      if ("1.4.0".equals(codeString))
        return true;
      if ("1.6".equals(codeString))
        return true;
      if ("1.6.0".equals(codeString))
        return true;
      if ("1.8".equals(codeString))
        return true;
      if ("1.8.0".equals(codeString))
        return true;
      if ("3.0".equals(codeString))
        return true;
      if ("3.0.0".equals(codeString))
        return true;
      if ("3.0.1".equals(codeString))
        return true;
      if ("3.0.2".equals(codeString))
        return true;
      if ("3.3".equals(codeString))
        return true;
      if ("3.3.0".equals(codeString))
        return true;
      if ("3.5".equals(codeString))
        return true;
      if ("3.5.0".equals(codeString))
        return true;
      if ("4.0".equals(codeString))
        return true;
      if ("4.0.0".equals(codeString))
        return true;
      if ("4.0.1".equals(codeString))
        return true;
      if ("4.1".equals(codeString))
        return true;
      if ("4.1.0".equals(codeString))
        return true;
      if ("4.2".equals(codeString))
        return true;
      if ("4.2.0".equals(codeString))
        return true;
      if ("4.3".equals(codeString))
        return true;
      if ("4.3.0".equals(codeString))
        return true;
      if ("4.4".equals(codeString))
        return true;
      if ("4.4.0".equals(codeString))
        return true;
      if ("4.5".equals(codeString))
        return true;
      if ("4.5.0".equals(codeString))
        return true;
      if ("4.6".equals(codeString))
        return true;
      if ("4.6.0".equals(codeString))
        return true;
      if ("5.0".equals(codeString))
        return true;
      if ("5.0.0".equals(codeString))
        return true;
      if ("5.0.0-cibuild".equals(codeString))
        return true;
      if ("5.0.0-snapshot1".equals(codeString))
        return true;
      if ("5.0.0-snapshot2".equals(codeString))
        return true;
      if ("5.0.0-ballot".equals(codeString))
        return true;
      return false;
      }

        public String toCode() {
          switch (this) {
            case _0_01: return "0.01";
            case _0_05: return "0.05";
            case _0_06: return "0.06";
            case _0_11: return "0.11";
            case _0_0: return "0.0";
            case _0_0_80: return "0.0.80";
            case _0_0_81: return "0.0.81";
            case _0_0_82: return "0.0.82";
            case _0_4: return "0.4";
            case _0_4_0: return "0.4.0";
            case _0_5: return "0.5";
            case _0_5_0: return "0.5.0";
            case _1_0: return "1.0";
            case _1_0_0: return "1.0.0";
            case _1_0_1: return "1.0.1";
            case _1_0_2: return "1.0.2";
            case _1_1: return "1.1";
            case _1_1_0: return "1.1.0";
            case _1_4: return "1.4";
            case _1_4_0: return "1.4.0";
            case _1_6: return "1.6";
            case _1_6_0: return "1.6.0";
            case _1_8: return "1.8";
            case _1_8_0: return "1.8.0";
            case _3_0: return "3.0";
            case _3_0_0: return "3.0.0";
            case _3_0_1: return "3.0.1";
            case _3_0_2: return "3.0.2";
            case _3_3: return "3.3";
            case _3_3_0: return "3.3.0";
            case _3_5: return "3.5";
            case _3_5_0: return "3.5.0";
            case _4_0: return "4.0";
            case _4_0_0: return "4.0.0";
            case _4_0_1: return "4.0.1";
            case _4_1: return "4.1";
            case _4_1_0: return "4.1.0";
            case _4_2: return "4.2";
            case _4_2_0: return "4.2.0";
            case _4_3: return "4.3";
            case _4_3_0: return "4.3.0";
            case _4_4: return "4.4";
            case _4_4_0: return "4.4.0";
            case _4_5: return "4.5";
            case _4_5_0: return "4.5.0";
            case _4_6: return "4.6";
            case _4_6_0: return "4.6.0";
            case _5_0: return "5.0";
            case _5_0_0: return "5.0.0";
            case _5_0_0CIBUILD: return "5.0.0-cibuild";
            case _5_0_0SNAPSHOT1: return "5.0.0-snapshot1";
            case _5_0_0SNAPSHOT2: return "5.0.0-snapshot2";
            case _5_0_0BALLOT: return "5.0.0-ballot";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case _0_01: return "http://hl7.org/fhir/FHIR-version";
            case _0_05: return "http://hl7.org/fhir/FHIR-version";
            case _0_06: return "http://hl7.org/fhir/FHIR-version";
            case _0_11: return "http://hl7.org/fhir/FHIR-version";
            case _0_0: return "http://hl7.org/fhir/FHIR-version";
            case _0_0_80: return "http://hl7.org/fhir/FHIR-version";
            case _0_0_81: return "http://hl7.org/fhir/FHIR-version";
            case _0_0_82: return "http://hl7.org/fhir/FHIR-version";
            case _0_4: return "http://hl7.org/fhir/FHIR-version";
            case _0_4_0: return "http://hl7.org/fhir/FHIR-version";
            case _0_5: return "http://hl7.org/fhir/FHIR-version";
            case _0_5_0: return "http://hl7.org/fhir/FHIR-version";
            case _1_0: return "http://hl7.org/fhir/FHIR-version";
            case _1_0_0: return "http://hl7.org/fhir/FHIR-version";
            case _1_0_1: return "http://hl7.org/fhir/FHIR-version";
            case _1_0_2: return "http://hl7.org/fhir/FHIR-version";
            case _1_1: return "http://hl7.org/fhir/FHIR-version";
            case _1_1_0: return "http://hl7.org/fhir/FHIR-version";
            case _1_4: return "http://hl7.org/fhir/FHIR-version";
            case _1_4_0: return "http://hl7.org/fhir/FHIR-version";
            case _1_6: return "http://hl7.org/fhir/FHIR-version";
            case _1_6_0: return "http://hl7.org/fhir/FHIR-version";
            case _1_8: return "http://hl7.org/fhir/FHIR-version";
            case _1_8_0: return "http://hl7.org/fhir/FHIR-version";
            case _3_0: return "http://hl7.org/fhir/FHIR-version";
            case _3_0_0: return "http://hl7.org/fhir/FHIR-version";
            case _3_0_1: return "http://hl7.org/fhir/FHIR-version";
            case _3_0_2: return "http://hl7.org/fhir/FHIR-version";
            case _3_3: return "http://hl7.org/fhir/FHIR-version";
            case _3_3_0: return "http://hl7.org/fhir/FHIR-version";
            case _3_5: return "http://hl7.org/fhir/FHIR-version";
            case _3_5_0: return "http://hl7.org/fhir/FHIR-version";
            case _4_0: return "http://hl7.org/fhir/FHIR-version";
            case _4_0_0: return "http://hl7.org/fhir/FHIR-version";
            case _4_0_1: return "http://hl7.org/fhir/FHIR-version";
            case _4_1: return "http://hl7.org/fhir/FHIR-version";
            case _4_1_0: return "http://hl7.org/fhir/FHIR-version";
            case _4_2: return "http://hl7.org/fhir/FHIR-version";
            case _4_2_0: return "http://hl7.org/fhir/FHIR-version";
            case _4_3: return "http://hl7.org/fhir/FHIR-version";
            case _4_3_0: return "http://hl7.org/fhir/FHIR-version";
            case _4_4: return "http://hl7.org/fhir/FHIR-version";
            case _4_4_0: return "http://hl7.org/fhir/FHIR-version";
            case _4_5: return "http://hl7.org/fhir/FHIR-version";
            case _4_5_0: return "http://hl7.org/fhir/FHIR-version";
            case _4_6: return "http://hl7.org/fhir/FHIR-version";
            case _4_6_0: return "http://hl7.org/fhir/FHIR-version";
            case _5_0: return "http://hl7.org/fhir/FHIR-version";
            case _5_0_0: return "http://hl7.org/fhir/FHIR-version";
            case _5_0_0CIBUILD: return "http://hl7.org/fhir/FHIR-version";
            case _5_0_0SNAPSHOT1: return "http://hl7.org/fhir/FHIR-version";
            case _5_0_0SNAPSHOT2: return "http://hl7.org/fhir/FHIR-version";
            case _5_0_0BALLOT: return "http://hl7.org/fhir/FHIR-version";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case _0_01: return "Oldest archived version of FHIR.";
            case _0_05: return "1st Draft for Comment (Sept 2012 Ballot).";
            case _0_06: return "2nd Draft for Comment (January 2013 Ballot).";
            case _0_11: return "DSTU 1 Ballot version.";
            case _0_0: return "DSTU 1 version.";
            case _0_0_80: return "DSTU 1 Official version.";
            case _0_0_81: return "DSTU 1 Official version Technical Errata #1.";
            case _0_0_82: return "DSTU 1 Official version Technical Errata #2.";
            case _0_4: return "January 2015 Ballot.";
            case _0_4_0: return "Draft For Comment (January 2015 Ballot).";
            case _0_5: return "May 2015 Ballot.";
            case _0_5_0: return "DSTU 2 Ballot version (May 2015 Ballot).";
            case _1_0: return "DSTU 2 version.";
            case _1_0_0: return "DSTU 2 QA Preview + CQIF Ballot (Sep 2015).";
            case _1_0_1: return "DSTU 2 (Official version).";
            case _1_0_2: return "DSTU 2 (Official version) with 1 technical errata.";
            case _1_1: return "GAO Ballot version.";
            case _1_1_0: return "GAO Ballot + draft changes to main FHIR standard.";
            case _1_4: return "Connectathon 12 (Montreal) version.";
            case _1_4_0: return "CQF on FHIR Ballot + Connectathon 12 (Montreal).";
            case _1_6: return "Connectathon 13 (Baltimore) version.";
            case _1_6_0: return "FHIR STU3 Ballot + Connectathon 13 (Baltimore).";
            case _1_8: return "Connectathon 14 (San Antonio) version.";
            case _1_8_0: return "FHIR STU3 Candidate + Connectathon 14 (San Antonio).";
            case _3_0: return "STU3 version.";
            case _3_0_0: return "FHIR Release 3 (STU).";
            case _3_0_1: return "FHIR Release 3 (STU) with 1 technical errata.";
            case _3_0_2: return "FHIR Release 3 (STU) with 2 technical errata.";
            case _3_3: return "R4 Ballot #1 version.";
            case _3_3_0: return "R4 Ballot #1 + Connectaton 18 (Cologne).";
            case _3_5: return "R4 Ballot #2 version.";
            case _3_5_0: return "R4 Ballot #2 + Connectathon 19 (Baltimore).";
            case _4_0: return "R4 version.";
            case _4_0_0: return "FHIR Release 4 (Normative + STU).";
            case _4_0_1: return "FHIR Release 4 (Normative + STU) with 1 technical errata.";
            case _4_1: return "R4B Ballot #1 version.";
            case _4_1_0: return "R4B Ballot #1 + Connectathon 27 (Virtual).";
            case _4_2: return "R5 Preview #1 version.";
            case _4_2_0: return "R5 Preview #1 + Connectathon 23 (Sydney).";
            case _4_3: return "R4B version.";
            case _4_3_0: return "FHIR Release 4B (Normative + STU).";
            case _4_4: return "R5 Preview #2 version.";
            case _4_4_0: return "R5 Preview #2 + Connectathon 24 (Virtual).";
            case _4_5: return "R5 Preview #3 version.";
            case _4_5_0: return "R5 Preview #3 + Connectathon 25 (Virtual).";
            case _4_6: return "R5 Draft Ballot version.";
            case _4_6_0: return "R5 Draft Ballot + Connectathon 27 (Virtual).";
            case _5_0: return "R5 Versions.";
            case _5_0_0: return "R5 Final Version.";
            case _5_0_0CIBUILD: return "R5 Rolling ci-build.";
            case _5_0_0SNAPSHOT1: return "R5 Preview #2.";
            case _5_0_0SNAPSHOT2: return "R5 Interim tooling stage.";
            case _5_0_0BALLOT: return "R5 Ballot.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case _0_01: return "0.01";
            case _0_05: return "0.05";
            case _0_06: return "0.06";
            case _0_11: return "0.11";
            case _0_0: return "0.0";
            case _0_0_80: return "0.0.80";
            case _0_0_81: return "0.0.81";
            case _0_0_82: return "0.0.82";
            case _0_4: return "0.4";
            case _0_4_0: return "0.4.0";
            case _0_5: return "0.5";
            case _0_5_0: return "0.5.0";
            case _1_0: return "1.0";
            case _1_0_0: return "1.0.0";
            case _1_0_1: return "1.0.1";
            case _1_0_2: return "1.0.2";
            case _1_1: return "1.1";
            case _1_1_0: return "1.1.0";
            case _1_4: return "1.4";
            case _1_4_0: return "1.4.0";
            case _1_6: return "1.6";
            case _1_6_0: return "1.6.0";
            case _1_8: return "1.8";
            case _1_8_0: return "1.8.0";
            case _3_0: return "3.0";
            case _3_0_0: return "3.0.0";
            case _3_0_1: return "3.0.1";
            case _3_0_2: return "3.0.2";
            case _3_3: return "3.3";
            case _3_3_0: return "3.3.0";
            case _3_5: return "3.5";
            case _3_5_0: return "3.5.0";
            case _4_0: return "4.0";
            case _4_0_0: return "4.0.0";
            case _4_0_1: return "4.0.1";
            case _4_1: return "4.1";
            case _4_1_0: return "4.1.0";
            case _4_2: return "4.2";
            case _4_2_0: return "4.2.0";
            case _4_3: return "4.3";
            case _4_3_0: return "4.3.0";
            case _4_4: return "4.4";
            case _4_4_0: return "4.4.0";
            case _4_5: return "4.5";
            case _4_5_0: return "4.5.0";
            case _4_6: return "4.6";
            case _4_6_0: return "4.6.0";
            case _5_0: return "5.0";
            case _5_0_0: return "5.0.0";
            case _5_0_0CIBUILD: return "5.0.0-cibuild";
            case _5_0_0SNAPSHOT1: return "5.0.0-snapshot1";
            case _5_0_0SNAPSHOT2: return "5.0.0-snapshot2";
            case _5_0_0BALLOT: return "5.0.0-ballot";
            case NULL: return null;
            default: return "?";
          }
        }
// manual code from configuration.txt:
//public String toCode(int len) {
//          return toCode().substring(0, len);
//        }
//
//     
//        @Override
//        public String toString() {
//          return toCode();
//        }
//        
//        
//        public boolean isR4B() {
//          return toCode().startsWith("4.1");
//        }
//        
// end addition
    }

  public static class FHIRVersionEnumFactory implements EnumFactory<FHIRVersion> {
    public FHIRVersion fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("0.01".equals(codeString))
          return FHIRVersion._0_01;
        if ("0.05".equals(codeString))
          return FHIRVersion._0_05;
        if ("0.06".equals(codeString))
          return FHIRVersion._0_06;
        if ("0.11".equals(codeString))
          return FHIRVersion._0_11;
        if ("0.0".equals(codeString))
          return FHIRVersion._0_0;
        if ("0.0.80".equals(codeString))
          return FHIRVersion._0_0_80;
        if ("0.0.81".equals(codeString))
          return FHIRVersion._0_0_81;
        if ("0.0.82".equals(codeString))
          return FHIRVersion._0_0_82;
        if ("0.4".equals(codeString))
          return FHIRVersion._0_4;
        if ("0.4.0".equals(codeString))
          return FHIRVersion._0_4_0;
        if ("0.5".equals(codeString))
          return FHIRVersion._0_5;
        if ("0.5.0".equals(codeString))
          return FHIRVersion._0_5_0;
        if ("1.0".equals(codeString))
          return FHIRVersion._1_0;
        if ("1.0.0".equals(codeString))
          return FHIRVersion._1_0_0;
        if ("1.0.1".equals(codeString))
          return FHIRVersion._1_0_1;
        if ("1.0.2".equals(codeString))
          return FHIRVersion._1_0_2;
        if ("1.1".equals(codeString))
          return FHIRVersion._1_1;
        if ("1.1.0".equals(codeString))
          return FHIRVersion._1_1_0;
        if ("1.4".equals(codeString))
          return FHIRVersion._1_4;
        if ("1.4.0".equals(codeString))
          return FHIRVersion._1_4_0;
        if ("1.6".equals(codeString))
          return FHIRVersion._1_6;
        if ("1.6.0".equals(codeString))
          return FHIRVersion._1_6_0;
        if ("1.8".equals(codeString))
          return FHIRVersion._1_8;
        if ("1.8.0".equals(codeString))
          return FHIRVersion._1_8_0;
        if ("3.0".equals(codeString))
          return FHIRVersion._3_0;
        if ("3.0.0".equals(codeString))
          return FHIRVersion._3_0_0;
        if ("3.0.1".equals(codeString))
          return FHIRVersion._3_0_1;
        if ("3.0.2".equals(codeString))
          return FHIRVersion._3_0_2;
        if ("3.3".equals(codeString))
          return FHIRVersion._3_3;
        if ("3.3.0".equals(codeString))
          return FHIRVersion._3_3_0;
        if ("3.5".equals(codeString))
          return FHIRVersion._3_5;
        if ("3.5.0".equals(codeString))
          return FHIRVersion._3_5_0;
        if ("4.0".equals(codeString))
          return FHIRVersion._4_0;
        if ("4.0.0".equals(codeString))
          return FHIRVersion._4_0_0;
        if ("4.0.1".equals(codeString))
          return FHIRVersion._4_0_1;
        if ("4.1".equals(codeString))
          return FHIRVersion._4_1;
        if ("4.1.0".equals(codeString))
          return FHIRVersion._4_1_0;
        if ("4.2".equals(codeString))
          return FHIRVersion._4_2;
        if ("4.2.0".equals(codeString))
          return FHIRVersion._4_2_0;
        if ("4.3".equals(codeString))
          return FHIRVersion._4_3;
        if ("4.3.0".equals(codeString))
          return FHIRVersion._4_3_0;
        if ("4.4".equals(codeString))
          return FHIRVersion._4_4;
        if ("4.4.0".equals(codeString))
          return FHIRVersion._4_4_0;
        if ("4.5".equals(codeString))
          return FHIRVersion._4_5;
        if ("4.5.0".equals(codeString))
          return FHIRVersion._4_5_0;
        if ("4.6".equals(codeString))
          return FHIRVersion._4_6;
        if ("4.6.0".equals(codeString))
          return FHIRVersion._4_6_0;
        if ("5.0".equals(codeString))
          return FHIRVersion._5_0;
        if ("5.0.0".equals(codeString))
          return FHIRVersion._5_0_0;
        if ("5.0.0-cibuild".equals(codeString))
          return FHIRVersion._5_0_0CIBUILD;
        if ("5.0.0-snapshot1".equals(codeString))
          return FHIRVersion._5_0_0SNAPSHOT1;
        if ("5.0.0-snapshot2".equals(codeString))
          return FHIRVersion._5_0_0SNAPSHOT2;
        if ("5.0.0-ballot".equals(codeString))
          return FHIRVersion._5_0_0BALLOT;
        throw new IllegalArgumentException("Unknown FHIRVersion code '"+codeString+"'");
        }
        public Enumeration<FHIRVersion> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<FHIRVersion>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("0.01".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_01);
        if ("0.05".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_05);
        if ("0.06".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_06);
        if ("0.11".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_11);
        if ("0.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_0);
        if ("0.0.80".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_0_80);
        if ("0.0.81".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_0_81);
        if ("0.0.82".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_0_82);
        if ("0.4".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_4);
        if ("0.4.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_4_0);
        if ("0.5".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_5);
        if ("0.5.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_5_0);
        if ("1.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_0);
        if ("1.0.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_0_0);
        if ("1.0.1".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_0_1);
        if ("1.0.2".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_0_2);
        if ("1.1".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_1);
        if ("1.1.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_1_0);
        if ("1.4".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_4);
        if ("1.4.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_4_0);
        if ("1.6".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_6);
        if ("1.6.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_6_0);
        if ("1.8".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_8);
        if ("1.8.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_8_0);
        if ("3.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_0);
        if ("3.0.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_0_0);
        if ("3.0.1".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_0_1);
        if ("3.0.2".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_0_2);
        if ("3.3".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_3);
        if ("3.3.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_3_0);
        if ("3.5".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_5);
        if ("3.5.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_5_0);
        if ("4.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_0);
        if ("4.0.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_0_0);
        if ("4.0.1".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_0_1);
        if ("4.1".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_1);
        if ("4.1.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_1_0);
        if ("4.2".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_2);
        if ("4.2.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_2_0);
        if ("4.3".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_3);
        if ("4.3.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_3_0);
        if ("4.4".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_4);
        if ("4.4.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_4_0);
        if ("4.5".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_5);
        if ("4.5.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_5_0);
        if ("4.6".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_6);
        if ("4.6.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_6_0);
        if ("5.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._5_0);
        if ("5.0.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._5_0_0);
        if ("5.0.0-cibuild".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._5_0_0CIBUILD);
        if ("5.0.0-snapshot1".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._5_0_0SNAPSHOT1);
        if ("5.0.0-snapshot2".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._5_0_0SNAPSHOT2);
        if ("5.0.0-ballot".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._5_0_0BALLOT);
        throw new FHIRException("Unknown FHIRVersion code '"+codeString+"'");
        }
    public String toCode(FHIRVersion code) {
      if (code == FHIRVersion._0_01)
        return "0.01";
      if (code == FHIRVersion._0_05)
        return "0.05";
      if (code == FHIRVersion._0_06)
        return "0.06";
      if (code == FHIRVersion._0_11)
        return "0.11";
      if (code == FHIRVersion._0_0)
        return "0.0";
      if (code == FHIRVersion._0_0_80)
        return "0.0.80";
      if (code == FHIRVersion._0_0_81)
        return "0.0.81";
      if (code == FHIRVersion._0_0_82)
        return "0.0.82";
      if (code == FHIRVersion._0_4)
        return "0.4";
      if (code == FHIRVersion._0_4_0)
        return "0.4.0";
      if (code == FHIRVersion._0_5)
        return "0.5";
      if (code == FHIRVersion._0_5_0)
        return "0.5.0";
      if (code == FHIRVersion._1_0)
        return "1.0";
      if (code == FHIRVersion._1_0_0)
        return "1.0.0";
      if (code == FHIRVersion._1_0_1)
        return "1.0.1";
      if (code == FHIRVersion._1_0_2)
        return "1.0.2";
      if (code == FHIRVersion._1_1)
        return "1.1";
      if (code == FHIRVersion._1_1_0)
        return "1.1.0";
      if (code == FHIRVersion._1_4)
        return "1.4";
      if (code == FHIRVersion._1_4_0)
        return "1.4.0";
      if (code == FHIRVersion._1_6)
        return "1.6";
      if (code == FHIRVersion._1_6_0)
        return "1.6.0";
      if (code == FHIRVersion._1_8)
        return "1.8";
      if (code == FHIRVersion._1_8_0)
        return "1.8.0";
      if (code == FHIRVersion._3_0)
        return "3.0";
      if (code == FHIRVersion._3_0_0)
        return "3.0.0";
      if (code == FHIRVersion._3_0_1)
        return "3.0.1";
      if (code == FHIRVersion._3_0_2)
        return "3.0.2";
      if (code == FHIRVersion._3_3)
        return "3.3";
      if (code == FHIRVersion._3_3_0)
        return "3.3.0";
      if (code == FHIRVersion._3_5)
        return "3.5";
      if (code == FHIRVersion._3_5_0)
        return "3.5.0";
      if (code == FHIRVersion._4_0)
        return "4.0";
      if (code == FHIRVersion._4_0_0)
        return "4.0.0";
      if (code == FHIRVersion._4_0_1)
        return "4.0.1";
      if (code == FHIRVersion._4_1)
        return "4.1";
      if (code == FHIRVersion._4_1_0)
        return "4.1.0";
      if (code == FHIRVersion._4_2)
        return "4.2";
      if (code == FHIRVersion._4_2_0)
        return "4.2.0";
      if (code == FHIRVersion._4_3)
        return "4.3";
      if (code == FHIRVersion._4_3_0)
        return "4.3.0";
      if (code == FHIRVersion._4_4)
        return "4.4";
      if (code == FHIRVersion._4_4_0)
        return "4.4.0";
      if (code == FHIRVersion._4_5)
        return "4.5";
      if (code == FHIRVersion._4_5_0)
        return "4.5.0";
      if (code == FHIRVersion._4_6)
        return "4.6";
      if (code == FHIRVersion._4_6_0)
        return "4.6.0";
      if (code == FHIRVersion._5_0)
        return "5.0";
      if (code == FHIRVersion._5_0_0)
        return "5.0.0";
      if (code == FHIRVersion._5_0_0CIBUILD)
        return "5.0.0-cibuild";
      if (code == FHIRVersion._5_0_0SNAPSHOT1)
        return "5.0.0-snapshot1";
      if (code == FHIRVersion._5_0_0SNAPSHOT2)
        return "5.0.0-snapshot2";
      if (code == FHIRVersion._5_0_0BALLOT)
        return "5.0.0-ballot";
      return "?";
      }
    public String toSystem(FHIRVersion code) {
      return code.getSystem();
      }
    }

    public enum FilterOperator {
        /**
         * The specified property of the code equals the provided value.
         */
        EQUAL, 
        /**
         * Includes all concept ids that have a transitive is-a relationship with the concept Id provided as the value, including the provided concept itself (include descendant codes and self).
         */
        ISA, 
        /**
         * Includes all concept ids that have a transitive is-a relationship with the concept Id provided as the value, excluding the provided concept itself i.e. include descendant codes only).
         */
        DESCENDENTOF, 
        /**
         * The specified property of the code does not have an is-a relationship with the provided value.
         */
        ISNOTA, 
        /**
         * The specified property of the code  matches the regex specified in the provided value.
         */
        REGEX, 
        /**
         * The specified property of the code is in the set of codes or concepts specified in the provided value (comma separated list).
         */
        IN, 
        /**
         * The specified property of the code is not in the set of codes or concepts specified in the provided value (comma separated list).
         */
        NOTIN, 
        /**
         * Includes all concept ids that have a transitive is-a relationship from the concept Id provided as the value, including the provided concept itself (i.e. include ancestor codes and self).
         */
        GENERALIZES, 
        /**
         * Only concepts with a direct hierarchical relationship to the index code and no other concepts. This does not include the index code in the output.
         */
        CHILDOF, 
        /**
         * Includes concept ids that have a transitive is-a relationship with the concept Id provided as the value, but which do not have any concept ids with transitive is-a relationships with themselves.
         */
        DESCENDENTLEAF, 
        /**
         * The specified property of the code has at least one value (if the specified value is true; if the specified value is false, then matches when the specified property of the code has no values).
         */
        EXISTS, 
        /**
         * added to help the parsers
         */
        NULL;
        public static FilterOperator fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("=".equals(codeString))
          return EQUAL;
        if ("is-a".equals(codeString))
          return ISA;
        if ("descendent-of".equals(codeString))
          return DESCENDENTOF;
        if ("is-not-a".equals(codeString))
          return ISNOTA;
        if ("regex".equals(codeString))
          return REGEX;
        if ("in".equals(codeString))
          return IN;
        if ("not-in".equals(codeString))
          return NOTIN;
        if ("generalizes".equals(codeString))
          return GENERALIZES;
        if ("child-of".equals(codeString))
          return CHILDOF;
        if ("descendent-leaf".equals(codeString))
          return DESCENDENTLEAF;
        if ("exists".equals(codeString))
          return EXISTS;
        throw new FHIRException("Unknown FilterOperator code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case EQUAL: return "=";
            case ISA: return "is-a";
            case DESCENDENTOF: return "descendent-of";
            case ISNOTA: return "is-not-a";
            case REGEX: return "regex";
            case IN: return "in";
            case NOTIN: return "not-in";
            case GENERALIZES: return "generalizes";
            case CHILDOF: return "child-of";
            case DESCENDENTLEAF: return "descendent-leaf";
            case EXISTS: return "exists";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case EQUAL: return "http://hl7.org/fhir/filter-operator";
            case ISA: return "http://hl7.org/fhir/filter-operator";
            case DESCENDENTOF: return "http://hl7.org/fhir/filter-operator";
            case ISNOTA: return "http://hl7.org/fhir/filter-operator";
            case REGEX: return "http://hl7.org/fhir/filter-operator";
            case IN: return "http://hl7.org/fhir/filter-operator";
            case NOTIN: return "http://hl7.org/fhir/filter-operator";
            case GENERALIZES: return "http://hl7.org/fhir/filter-operator";
            case CHILDOF: return "http://hl7.org/fhir/filter-operator";
            case DESCENDENTLEAF: return "http://hl7.org/fhir/filter-operator";
            case EXISTS: return "http://hl7.org/fhir/filter-operator";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case EQUAL: return "The specified property of the code equals the provided value.";
            case ISA: return "Includes all concept ids that have a transitive is-a relationship with the concept Id provided as the value, including the provided concept itself (include descendant codes and self).";
            case DESCENDENTOF: return "Includes all concept ids that have a transitive is-a relationship with the concept Id provided as the value, excluding the provided concept itself i.e. include descendant codes only).";
            case ISNOTA: return "The specified property of the code does not have an is-a relationship with the provided value.";
            case REGEX: return "The specified property of the code  matches the regex specified in the provided value.";
            case IN: return "The specified property of the code is in the set of codes or concepts specified in the provided value (comma separated list).";
            case NOTIN: return "The specified property of the code is not in the set of codes or concepts specified in the provided value (comma separated list).";
            case GENERALIZES: return "Includes all concept ids that have a transitive is-a relationship from the concept Id provided as the value, including the provided concept itself (i.e. include ancestor codes and self).";
            case CHILDOF: return "Only concepts with a direct hierarchical relationship to the index code and no other concepts. This does not include the index code in the output.";
            case DESCENDENTLEAF: return "Includes concept ids that have a transitive is-a relationship with the concept Id provided as the value, but which do not have any concept ids with transitive is-a relationships with themselves.";
            case EXISTS: return "The specified property of the code has at least one value (if the specified value is true; if the specified value is false, then matches when the specified property of the code has no values).";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EQUAL: return "Equals";
            case ISA: return "Is A (by subsumption)";
            case DESCENDENTOF: return "Descendent Of (by subsumption)";
            case ISNOTA: return "Not (Is A) (by subsumption)";
            case REGEX: return "Regular Expression";
            case IN: return "In Set";
            case NOTIN: return "Not in Set";
            case GENERALIZES: return "Generalizes (by Subsumption)";
            case CHILDOF: return "Child Of";
            case DESCENDENTLEAF: return "Descendent Leaf";
            case EXISTS: return "Exists";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class FilterOperatorEnumFactory implements EnumFactory<FilterOperator> {
    public FilterOperator fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("=".equals(codeString))
          return FilterOperator.EQUAL;
        if ("is-a".equals(codeString))
          return FilterOperator.ISA;
        if ("descendent-of".equals(codeString))
          return FilterOperator.DESCENDENTOF;
        if ("is-not-a".equals(codeString))
          return FilterOperator.ISNOTA;
        if ("regex".equals(codeString))
          return FilterOperator.REGEX;
        if ("in".equals(codeString))
          return FilterOperator.IN;
        if ("not-in".equals(codeString))
          return FilterOperator.NOTIN;
        if ("generalizes".equals(codeString))
          return FilterOperator.GENERALIZES;
        if ("child-of".equals(codeString))
          return FilterOperator.CHILDOF;
        if ("descendent-leaf".equals(codeString))
          return FilterOperator.DESCENDENTLEAF;
        if ("exists".equals(codeString))
          return FilterOperator.EXISTS;
        throw new IllegalArgumentException("Unknown FilterOperator code '"+codeString+"'");
        }
        public Enumeration<FilterOperator> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<FilterOperator>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("=".equals(codeString))
          return new Enumeration<FilterOperator>(this, FilterOperator.EQUAL);
        if ("is-a".equals(codeString))
          return new Enumeration<FilterOperator>(this, FilterOperator.ISA);
        if ("descendent-of".equals(codeString))
          return new Enumeration<FilterOperator>(this, FilterOperator.DESCENDENTOF);
        if ("is-not-a".equals(codeString))
          return new Enumeration<FilterOperator>(this, FilterOperator.ISNOTA);
        if ("regex".equals(codeString))
          return new Enumeration<FilterOperator>(this, FilterOperator.REGEX);
        if ("in".equals(codeString))
          return new Enumeration<FilterOperator>(this, FilterOperator.IN);
        if ("not-in".equals(codeString))
          return new Enumeration<FilterOperator>(this, FilterOperator.NOTIN);
        if ("generalizes".equals(codeString))
          return new Enumeration<FilterOperator>(this, FilterOperator.GENERALIZES);
        if ("child-of".equals(codeString))
          return new Enumeration<FilterOperator>(this, FilterOperator.CHILDOF);
        if ("descendent-leaf".equals(codeString))
          return new Enumeration<FilterOperator>(this, FilterOperator.DESCENDENTLEAF);
        if ("exists".equals(codeString))
          return new Enumeration<FilterOperator>(this, FilterOperator.EXISTS);
        throw new FHIRException("Unknown FilterOperator code '"+codeString+"'");
        }
    public String toCode(FilterOperator code) {
      if (code == FilterOperator.EQUAL)
        return "=";
      if (code == FilterOperator.ISA)
        return "is-a";
      if (code == FilterOperator.DESCENDENTOF)
        return "descendent-of";
      if (code == FilterOperator.ISNOTA)
        return "is-not-a";
      if (code == FilterOperator.REGEX)
        return "regex";
      if (code == FilterOperator.IN)
        return "in";
      if (code == FilterOperator.NOTIN)
        return "not-in";
      if (code == FilterOperator.GENERALIZES)
        return "generalizes";
      if (code == FilterOperator.CHILDOF)
        return "child-of";
      if (code == FilterOperator.DESCENDENTLEAF)
        return "descendent-leaf";
      if (code == FilterOperator.EXISTS)
        return "exists";
      return "?";
      }
    public String toSystem(FilterOperator code) {
      return code.getSystem();
      }
    }

    public enum FinancialResourceStatusCodes {
        /**
         * The instance is currently in-force.
         */
        ACTIVE, 
        /**
         * The instance is withdrawn, rescinded or reversed.
         */
        CANCELLED, 
        /**
         * A new instance the contents of which is not complete.
         */
        DRAFT, 
        /**
         * The instance was entered in error.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers
         */
        NULL;
        public static FinancialResourceStatusCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        throw new FHIRException("Unknown FinancialResourceStatusCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case CANCELLED: return "cancelled";
            case DRAFT: return "draft";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/fm-status";
            case CANCELLED: return "http://hl7.org/fhir/fm-status";
            case DRAFT: return "http://hl7.org/fhir/fm-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/fm-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The instance is currently in-force.";
            case CANCELLED: return "The instance is withdrawn, rescinded or reversed.";
            case DRAFT: return "A new instance the contents of which is not complete.";
            case ENTEREDINERROR: return "The instance was entered in error.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case CANCELLED: return "Cancelled";
            case DRAFT: return "Draft";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class FinancialResourceStatusCodesEnumFactory implements EnumFactory<FinancialResourceStatusCodes> {
    public FinancialResourceStatusCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return FinancialResourceStatusCodes.ACTIVE;
        if ("cancelled".equals(codeString))
          return FinancialResourceStatusCodes.CANCELLED;
        if ("draft".equals(codeString))
          return FinancialResourceStatusCodes.DRAFT;
        if ("entered-in-error".equals(codeString))
          return FinancialResourceStatusCodes.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown FinancialResourceStatusCodes code '"+codeString+"'");
        }
        public Enumeration<FinancialResourceStatusCodes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<FinancialResourceStatusCodes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("active".equals(codeString))
          return new Enumeration<FinancialResourceStatusCodes>(this, FinancialResourceStatusCodes.ACTIVE);
        if ("cancelled".equals(codeString))
          return new Enumeration<FinancialResourceStatusCodes>(this, FinancialResourceStatusCodes.CANCELLED);
        if ("draft".equals(codeString))
          return new Enumeration<FinancialResourceStatusCodes>(this, FinancialResourceStatusCodes.DRAFT);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<FinancialResourceStatusCodes>(this, FinancialResourceStatusCodes.ENTEREDINERROR);
        throw new FHIRException("Unknown FinancialResourceStatusCodes code '"+codeString+"'");
        }
    public String toCode(FinancialResourceStatusCodes code) {
      if (code == FinancialResourceStatusCodes.ACTIVE)
        return "active";
      if (code == FinancialResourceStatusCodes.CANCELLED)
        return "cancelled";
      if (code == FinancialResourceStatusCodes.DRAFT)
        return "draft";
      if (code == FinancialResourceStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(FinancialResourceStatusCodes code) {
      return code.getSystem();
      }
    }

    public enum ListMode {
        /**
         * This list is the master list, maintained in an ongoing fashion with regular updates as the real world list it is tracking changes.
         */
        WORKING, 
        /**
         * This list was prepared as a snapshot. It should not be assumed to be current.
         */
        SNAPSHOT, 
        /**
         * A point-in-time list that shows what changes have been made or recommended.  E.g. a discharge medication list showing what was added and removed during an encounter.
         */
        CHANGES, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ListMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("working".equals(codeString))
          return WORKING;
        if ("snapshot".equals(codeString))
          return SNAPSHOT;
        if ("changes".equals(codeString))
          return CHANGES;
        throw new FHIRException("Unknown ListMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case WORKING: return "working";
            case SNAPSHOT: return "snapshot";
            case CHANGES: return "changes";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case WORKING: return "http://hl7.org/fhir/list-mode";
            case SNAPSHOT: return "http://hl7.org/fhir/list-mode";
            case CHANGES: return "http://hl7.org/fhir/list-mode";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case WORKING: return "This list is the master list, maintained in an ongoing fashion with regular updates as the real world list it is tracking changes.";
            case SNAPSHOT: return "This list was prepared as a snapshot. It should not be assumed to be current.";
            case CHANGES: return "A point-in-time list that shows what changes have been made or recommended.  E.g. a discharge medication list showing what was added and removed during an encounter.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case WORKING: return "Working List";
            case SNAPSHOT: return "Snapshot List";
            case CHANGES: return "Change List";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ListModeEnumFactory implements EnumFactory<ListMode> {
    public ListMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("working".equals(codeString))
          return ListMode.WORKING;
        if ("snapshot".equals(codeString))
          return ListMode.SNAPSHOT;
        if ("changes".equals(codeString))
          return ListMode.CHANGES;
        throw new IllegalArgumentException("Unknown ListMode code '"+codeString+"'");
        }
        public Enumeration<ListMode> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ListMode>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("working".equals(codeString))
          return new Enumeration<ListMode>(this, ListMode.WORKING);
        if ("snapshot".equals(codeString))
          return new Enumeration<ListMode>(this, ListMode.SNAPSHOT);
        if ("changes".equals(codeString))
          return new Enumeration<ListMode>(this, ListMode.CHANGES);
        throw new FHIRException("Unknown ListMode code '"+codeString+"'");
        }
    public String toCode(ListMode code) {
      if (code == ListMode.WORKING)
        return "working";
      if (code == ListMode.SNAPSHOT)
        return "snapshot";
      if (code == ListMode.CHANGES)
        return "changes";
      return "?";
      }
    public String toSystem(ListMode code) {
      return code.getSystem();
      }
    }

    public enum MeasureImprovementNotation {
        /**
         * Improvement is indicated as an increase in the score or measurement (e.g. Higher score indicates better quality).
         */
        INCREASE, 
        /**
         * Improvement is indicated as a decrease in the score or measurement (e.g. Lower score indicates better quality).
         */
        DECREASE, 
        /**
         * added to help the parsers
         */
        NULL;
        public static MeasureImprovementNotation fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("increase".equals(codeString))
          return INCREASE;
        if ("decrease".equals(codeString))
          return DECREASE;
        throw new FHIRException("Unknown MeasureImprovementNotation code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INCREASE: return "increase";
            case DECREASE: return "decrease";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INCREASE: return "http://terminology.hl7.org/CodeSystem/measure-improvement-notation";
            case DECREASE: return "http://terminology.hl7.org/CodeSystem/measure-improvement-notation";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INCREASE: return "Improvement is indicated as an increase in the score or measurement (e.g. Higher score indicates better quality).";
            case DECREASE: return "Improvement is indicated as a decrease in the score or measurement (e.g. Lower score indicates better quality).";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INCREASE: return "Increased score indicates improvement";
            case DECREASE: return "Decreased score indicates improvement";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class MeasureImprovementNotationEnumFactory implements EnumFactory<MeasureImprovementNotation> {
    public MeasureImprovementNotation fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("increase".equals(codeString))
          return MeasureImprovementNotation.INCREASE;
        if ("decrease".equals(codeString))
          return MeasureImprovementNotation.DECREASE;
        throw new IllegalArgumentException("Unknown MeasureImprovementNotation code '"+codeString+"'");
        }
        public Enumeration<MeasureImprovementNotation> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<MeasureImprovementNotation>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("increase".equals(codeString))
          return new Enumeration<MeasureImprovementNotation>(this, MeasureImprovementNotation.INCREASE);
        if ("decrease".equals(codeString))
          return new Enumeration<MeasureImprovementNotation>(this, MeasureImprovementNotation.DECREASE);
        throw new FHIRException("Unknown MeasureImprovementNotation code '"+codeString+"'");
        }
    public String toCode(MeasureImprovementNotation code) {
      if (code == MeasureImprovementNotation.INCREASE)
        return "increase";
      if (code == MeasureImprovementNotation.DECREASE)
        return "decrease";
      return "?";
      }
    public String toSystem(MeasureImprovementNotation code) {
      return code.getSystem();
      }
    }

    public enum MimeTypes {
        /**
         * added to help the parsers
         */
        NULL;
        public static MimeTypes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        throw new FHIRException("Unknown MimeTypes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class MimeTypesEnumFactory implements EnumFactory<MimeTypes> {
    public MimeTypes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        throw new IllegalArgumentException("Unknown MimeTypes code '"+codeString+"'");
        }
        public Enumeration<MimeTypes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<MimeTypes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        throw new FHIRException("Unknown MimeTypes code '"+codeString+"'");
        }
    public String toCode(MimeTypes code) {
      return "?";
      }
    public String toSystem(MimeTypes code) {
      return code.getSystem();
      }
    }

    public enum NoteType {
        /**
         * Display the note.
         */
        DISPLAY, 
        /**
         * Print the note on the form.
         */
        PRINT, 
        /**
         * Print the note for the operator.
         */
        PRINTOPER, 
        /**
         * added to help the parsers
         */
        NULL;
        public static NoteType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("display".equals(codeString))
          return DISPLAY;
        if ("print".equals(codeString))
          return PRINT;
        if ("printoper".equals(codeString))
          return PRINTOPER;
        throw new FHIRException("Unknown NoteType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DISPLAY: return "display";
            case PRINT: return "print";
            case PRINTOPER: return "printoper";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DISPLAY: return "http://hl7.org/fhir/note-type";
            case PRINT: return "http://hl7.org/fhir/note-type";
            case PRINTOPER: return "http://hl7.org/fhir/note-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DISPLAY: return "Display the note.";
            case PRINT: return "Print the note on the form.";
            case PRINTOPER: return "Print the note for the operator.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DISPLAY: return "Display";
            case PRINT: return "Print (Form)";
            case PRINTOPER: return "Print (Operator)";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class NoteTypeEnumFactory implements EnumFactory<NoteType> {
    public NoteType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("display".equals(codeString))
          return NoteType.DISPLAY;
        if ("print".equals(codeString))
          return NoteType.PRINT;
        if ("printoper".equals(codeString))
          return NoteType.PRINTOPER;
        throw new IllegalArgumentException("Unknown NoteType code '"+codeString+"'");
        }
        public Enumeration<NoteType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<NoteType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("display".equals(codeString))
          return new Enumeration<NoteType>(this, NoteType.DISPLAY);
        if ("print".equals(codeString))
          return new Enumeration<NoteType>(this, NoteType.PRINT);
        if ("printoper".equals(codeString))
          return new Enumeration<NoteType>(this, NoteType.PRINTOPER);
        throw new FHIRException("Unknown NoteType code '"+codeString+"'");
        }
    public String toCode(NoteType code) {
      if (code == NoteType.DISPLAY)
        return "display";
      if (code == NoteType.PRINT)
        return "print";
      if (code == NoteType.PRINTOPER)
        return "printoper";
      return "?";
      }
    public String toSystem(NoteType code) {
      return code.getSystem();
      }
    }

    public enum ObservationStatus {
        /**
         * The existence of the observation is registered, but there is no result yet available.
         */
        REGISTERED, 
        /**
         * This is an initial or interim observation: data may be incomplete or unverified.
         */
        PRELIMINARY, 
        /**
         * The observation is complete and there are no further actions needed. Additional information such "released", "signed", etc would be represented using [Provenance](provenance.html) which provides not only the act but also the actors and dates and other related data. These act states would be associated with an observation status of `preliminary` until they are all completed and then a status of `final` would be applied.
         */
        FINAL, 
        /**
         * Subsequent to being Final, the observation has been modified subsequent.  This includes updates/new information and corrections.
         */
        AMENDED, 
        /**
         * Subsequent to being Final, the observation has been modified to correct an error in the test result.
         */
        CORRECTED, 
        /**
         * The observation is unavailable because the measurement was not started or not completed (also sometimes called "aborted").
         */
        CANCELLED, 
        /**
         * The observation has been withdrawn following previous final release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be "cancelled" rather than "entered-in-error".).
         */
        ENTEREDINERROR, 
        /**
         * The authoring/source system does not know which of the status values currently applies for this observation. Note: This concept is not to be used for "other" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which.
         */
        UNKNOWN, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ObservationStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered".equals(codeString))
          return REGISTERED;
        if ("preliminary".equals(codeString))
          return PRELIMINARY;
        if ("final".equals(codeString))
          return FINAL;
        if ("amended".equals(codeString))
          return AMENDED;
        if ("corrected".equals(codeString))
          return CORRECTED;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        throw new FHIRException("Unknown ObservationStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REGISTERED: return "registered";
            case PRELIMINARY: return "preliminary";
            case FINAL: return "final";
            case AMENDED: return "amended";
            case CORRECTED: return "corrected";
            case CANCELLED: return "cancelled";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REGISTERED: return "http://hl7.org/fhir/observation-status";
            case PRELIMINARY: return "http://hl7.org/fhir/observation-status";
            case FINAL: return "http://hl7.org/fhir/observation-status";
            case AMENDED: return "http://hl7.org/fhir/observation-status";
            case CORRECTED: return "http://hl7.org/fhir/observation-status";
            case CANCELLED: return "http://hl7.org/fhir/observation-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/observation-status";
            case UNKNOWN: return "http://hl7.org/fhir/observation-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REGISTERED: return "The existence of the observation is registered, but there is no result yet available.";
            case PRELIMINARY: return "This is an initial or interim observation: data may be incomplete or unverified.";
            case FINAL: return "The observation is complete and there are no further actions needed. Additional information such \"released\", \"signed\", etc would be represented using [Provenance](provenance.html) which provides not only the act but also the actors and dates and other related data. These act states would be associated with an observation status of `preliminary` until they are all completed and then a status of `final` would be applied.";
            case AMENDED: return "Subsequent to being Final, the observation has been modified subsequent.  This includes updates/new information and corrections.";
            case CORRECTED: return "Subsequent to being Final, the observation has been modified to correct an error in the test result.";
            case CANCELLED: return "The observation is unavailable because the measurement was not started or not completed (also sometimes called \"aborted\").";
            case ENTEREDINERROR: return "The observation has been withdrawn following previous final release.  This electronic record should never have existed, though it is possible that real-world decisions were based on it. (If real-world activity has occurred, the status should be \"cancelled\" rather than \"entered-in-error\".).";
            case UNKNOWN: return "The authoring/source system does not know which of the status values currently applies for this observation. Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REGISTERED: return "Registered";
            case PRELIMINARY: return "Preliminary";
            case FINAL: return "Final";
            case AMENDED: return "Amended";
            case CORRECTED: return "Corrected";
            case CANCELLED: return "Cancelled";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ObservationStatusEnumFactory implements EnumFactory<ObservationStatus> {
    public ObservationStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("registered".equals(codeString))
          return ObservationStatus.REGISTERED;
        if ("preliminary".equals(codeString))
          return ObservationStatus.PRELIMINARY;
        if ("final".equals(codeString))
          return ObservationStatus.FINAL;
        if ("amended".equals(codeString))
          return ObservationStatus.AMENDED;
        if ("corrected".equals(codeString))
          return ObservationStatus.CORRECTED;
        if ("cancelled".equals(codeString))
          return ObservationStatus.CANCELLED;
        if ("entered-in-error".equals(codeString))
          return ObservationStatus.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return ObservationStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown ObservationStatus code '"+codeString+"'");
        }
        public Enumeration<ObservationStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ObservationStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("registered".equals(codeString))
          return new Enumeration<ObservationStatus>(this, ObservationStatus.REGISTERED);
        if ("preliminary".equals(codeString))
          return new Enumeration<ObservationStatus>(this, ObservationStatus.PRELIMINARY);
        if ("final".equals(codeString))
          return new Enumeration<ObservationStatus>(this, ObservationStatus.FINAL);
        if ("amended".equals(codeString))
          return new Enumeration<ObservationStatus>(this, ObservationStatus.AMENDED);
        if ("corrected".equals(codeString))
          return new Enumeration<ObservationStatus>(this, ObservationStatus.CORRECTED);
        if ("cancelled".equals(codeString))
          return new Enumeration<ObservationStatus>(this, ObservationStatus.CANCELLED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<ObservationStatus>(this, ObservationStatus.ENTEREDINERROR);
        if ("unknown".equals(codeString))
          return new Enumeration<ObservationStatus>(this, ObservationStatus.UNKNOWN);
        throw new FHIRException("Unknown ObservationStatus code '"+codeString+"'");
        }
    public String toCode(ObservationStatus code) {
      if (code == ObservationStatus.REGISTERED)
        return "registered";
      if (code == ObservationStatus.PRELIMINARY)
        return "preliminary";
      if (code == ObservationStatus.FINAL)
        return "final";
      if (code == ObservationStatus.AMENDED)
        return "amended";
      if (code == ObservationStatus.CORRECTED)
        return "corrected";
      if (code == ObservationStatus.CANCELLED)
        return "cancelled";
      if (code == ObservationStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == ObservationStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(ObservationStatus code) {
      return code.getSystem();
      }
    }

    public enum OperationParameterUse {
        /**
         * This is an input parameter.
         */
        IN, 
        /**
         * This is an output parameter.
         */
        OUT, 
        /**
         * added to help the parsers
         */
        NULL;
        public static OperationParameterUse fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in".equals(codeString))
          return IN;
        if ("out".equals(codeString))
          return OUT;
        throw new FHIRException("Unknown OperationParameterUse code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case IN: return "in";
            case OUT: return "out";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case IN: return "http://hl7.org/fhir/operation-parameter-use";
            case OUT: return "http://hl7.org/fhir/operation-parameter-use";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case IN: return "This is an input parameter.";
            case OUT: return "This is an output parameter.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case IN: return "In";
            case OUT: return "Out";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class OperationParameterUseEnumFactory implements EnumFactory<OperationParameterUse> {
    public OperationParameterUse fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in".equals(codeString))
          return OperationParameterUse.IN;
        if ("out".equals(codeString))
          return OperationParameterUse.OUT;
        throw new IllegalArgumentException("Unknown OperationParameterUse code '"+codeString+"'");
        }
        public Enumeration<OperationParameterUse> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<OperationParameterUse>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("in".equals(codeString))
          return new Enumeration<OperationParameterUse>(this, OperationParameterUse.IN);
        if ("out".equals(codeString))
          return new Enumeration<OperationParameterUse>(this, OperationParameterUse.OUT);
        throw new FHIRException("Unknown OperationParameterUse code '"+codeString+"'");
        }
    public String toCode(OperationParameterUse code) {
      if (code == OperationParameterUse.IN)
        return "in";
      if (code == OperationParameterUse.OUT)
        return "out";
      return "?";
      }
    public String toSystem(OperationParameterUse code) {
      return code.getSystem();
      }
    }

    public enum ParticipationStatus {
        /**
         * The participant has accepted the appointment.
         */
        ACCEPTED, 
        /**
         * The participant has declined the appointment and will not participate in the appointment.
         */
        DECLINED, 
        /**
         * The participant has  tentatively accepted the appointment. This could be automatically created by a system and requires further processing before it can be accepted. There is no commitment that attendance will occur.
         */
        TENTATIVE, 
        /**
         * The participant needs to indicate if they accept the appointment by changing this status to one of the other statuses.
         */
        NEEDSACTION, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ParticipationStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("accepted".equals(codeString))
          return ACCEPTED;
        if ("declined".equals(codeString))
          return DECLINED;
        if ("tentative".equals(codeString))
          return TENTATIVE;
        if ("needs-action".equals(codeString))
          return NEEDSACTION;
        throw new FHIRException("Unknown ParticipationStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACCEPTED: return "accepted";
            case DECLINED: return "declined";
            case TENTATIVE: return "tentative";
            case NEEDSACTION: return "needs-action";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACCEPTED: return "http://hl7.org/fhir/participationstatus";
            case DECLINED: return "http://hl7.org/fhir/participationstatus";
            case TENTATIVE: return "http://hl7.org/fhir/participationstatus";
            case NEEDSACTION: return "http://hl7.org/fhir/participationstatus";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACCEPTED: return "The participant has accepted the appointment.";
            case DECLINED: return "The participant has declined the appointment and will not participate in the appointment.";
            case TENTATIVE: return "The participant has  tentatively accepted the appointment. This could be automatically created by a system and requires further processing before it can be accepted. There is no commitment that attendance will occur.";
            case NEEDSACTION: return "The participant needs to indicate if they accept the appointment by changing this status to one of the other statuses.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACCEPTED: return "Accepted";
            case DECLINED: return "Declined";
            case TENTATIVE: return "Tentative";
            case NEEDSACTION: return "Needs Action";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ParticipationStatusEnumFactory implements EnumFactory<ParticipationStatus> {
    public ParticipationStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("accepted".equals(codeString))
          return ParticipationStatus.ACCEPTED;
        if ("declined".equals(codeString))
          return ParticipationStatus.DECLINED;
        if ("tentative".equals(codeString))
          return ParticipationStatus.TENTATIVE;
        if ("needs-action".equals(codeString))
          return ParticipationStatus.NEEDSACTION;
        throw new IllegalArgumentException("Unknown ParticipationStatus code '"+codeString+"'");
        }
        public Enumeration<ParticipationStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ParticipationStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("accepted".equals(codeString))
          return new Enumeration<ParticipationStatus>(this, ParticipationStatus.ACCEPTED);
        if ("declined".equals(codeString))
          return new Enumeration<ParticipationStatus>(this, ParticipationStatus.DECLINED);
        if ("tentative".equals(codeString))
          return new Enumeration<ParticipationStatus>(this, ParticipationStatus.TENTATIVE);
        if ("needs-action".equals(codeString))
          return new Enumeration<ParticipationStatus>(this, ParticipationStatus.NEEDSACTION);
        throw new FHIRException("Unknown ParticipationStatus code '"+codeString+"'");
        }
    public String toCode(ParticipationStatus code) {
      if (code == ParticipationStatus.ACCEPTED)
        return "accepted";
      if (code == ParticipationStatus.DECLINED)
        return "declined";
      if (code == ParticipationStatus.TENTATIVE)
        return "tentative";
      if (code == ParticipationStatus.NEEDSACTION)
        return "needs-action";
      return "?";
      }
    public String toSystem(ParticipationStatus code) {
      return code.getSystem();
      }
    }

    public enum PublicationStatus {
        /**
         * This resource is still under development and is not yet considered to be ready for normal use.
         */
        DRAFT, 
        /**
         * This resource is ready for normal use.
         */
        ACTIVE, 
        /**
         * This resource has been withdrawn or superseded and should no longer be used.
         */
        RETIRED, 
        /**
         * The authoring system does not know which of the status values currently applies for this resource.  Note: This concept is not to be used for "other" - one of the listed statuses is presumed to apply, it's just not known which one.
         */
        UNKNOWN, 
        /**
         * added to help the parsers
         */
        NULL;
        public static PublicationStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("retired".equals(codeString))
          return RETIRED;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        throw new FHIRException("Unknown PublicationStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DRAFT: return "draft";
            case ACTIVE: return "active";
            case RETIRED: return "retired";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DRAFT: return "http://hl7.org/fhir/publication-status";
            case ACTIVE: return "http://hl7.org/fhir/publication-status";
            case RETIRED: return "http://hl7.org/fhir/publication-status";
            case UNKNOWN: return "http://hl7.org/fhir/publication-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DRAFT: return "This resource is still under development and is not yet considered to be ready for normal use.";
            case ACTIVE: return "This resource is ready for normal use.";
            case RETIRED: return "This resource has been withdrawn or superseded and should no longer be used.";
            case UNKNOWN: return "The authoring system does not know which of the status values currently applies for this resource.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, it's just not known which one.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DRAFT: return "Draft";
            case ACTIVE: return "Active";
            case RETIRED: return "Retired";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class PublicationStatusEnumFactory implements EnumFactory<PublicationStatus> {
    public PublicationStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return PublicationStatus.DRAFT;
        if ("active".equals(codeString))
          return PublicationStatus.ACTIVE;
        if ("retired".equals(codeString))
          return PublicationStatus.RETIRED;
        if ("unknown".equals(codeString))
          return PublicationStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown PublicationStatus code '"+codeString+"'");
        }
        public Enumeration<PublicationStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<PublicationStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("draft".equals(codeString))
          return new Enumeration<PublicationStatus>(this, PublicationStatus.DRAFT);
        if ("active".equals(codeString))
          return new Enumeration<PublicationStatus>(this, PublicationStatus.ACTIVE);
        if ("retired".equals(codeString))
          return new Enumeration<PublicationStatus>(this, PublicationStatus.RETIRED);
        if ("unknown".equals(codeString))
          return new Enumeration<PublicationStatus>(this, PublicationStatus.UNKNOWN);
        throw new FHIRException("Unknown PublicationStatus code '"+codeString+"'");
        }
    public String toCode(PublicationStatus code) {
      if (code == PublicationStatus.DRAFT)
        return "draft";
      if (code == PublicationStatus.ACTIVE)
        return "active";
      if (code == PublicationStatus.RETIRED)
        return "retired";
      if (code == PublicationStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(PublicationStatus code) {
      return code.getSystem();
      }
    }

    public enum QuantityComparator {
        /**
         * The actual value is less than the given value.
         */
        LESS_THAN, 
        /**
         * The actual value is less than or equal to the given value.
         */
        LESS_OR_EQUAL, 
        /**
         * The actual value is greater than or equal to the given value.
         */
        GREATER_OR_EQUAL, 
        /**
         * The actual value is greater than the given value.
         */
        GREATER_THAN, 
        /**
         * The actual value is sufficient for the total quantity to equal the given value.
         */
        AD, 
        /**
         * added to help the parsers
         */
        NULL;
        public static QuantityComparator fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("<".equals(codeString))
          return LESS_THAN;
        if ("<=".equals(codeString))
          return LESS_OR_EQUAL;
        if (">=".equals(codeString))
          return GREATER_OR_EQUAL;
        if (">".equals(codeString))
          return GREATER_THAN;
        if ("ad".equals(codeString))
          return AD;
        throw new FHIRException("Unknown QuantityComparator code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case LESS_THAN: return "<";
            case LESS_OR_EQUAL: return "<=";
            case GREATER_OR_EQUAL: return ">=";
            case GREATER_THAN: return ">";
            case AD: return "ad";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case LESS_THAN: return "http://hl7.org/fhir/quantity-comparator";
            case LESS_OR_EQUAL: return "http://hl7.org/fhir/quantity-comparator";
            case GREATER_OR_EQUAL: return "http://hl7.org/fhir/quantity-comparator";
            case GREATER_THAN: return "http://hl7.org/fhir/quantity-comparator";
            case AD: return "http://hl7.org/fhir/quantity-comparator";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case LESS_THAN: return "The actual value is less than the given value.";
            case LESS_OR_EQUAL: return "The actual value is less than or equal to the given value.";
            case GREATER_OR_EQUAL: return "The actual value is greater than or equal to the given value.";
            case GREATER_THAN: return "The actual value is greater than the given value.";
            case AD: return "The actual value is sufficient for the total quantity to equal the given value.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case LESS_THAN: return "Less than";
            case LESS_OR_EQUAL: return "Less or Equal to";
            case GREATER_OR_EQUAL: return "Greater or Equal to";
            case GREATER_THAN: return "Greater than";
            case AD: return "Sufficient to achieve this total quantity";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class QuantityComparatorEnumFactory implements EnumFactory<QuantityComparator> {
    public QuantityComparator fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("<".equals(codeString))
          return QuantityComparator.LESS_THAN;
        if ("<=".equals(codeString))
          return QuantityComparator.LESS_OR_EQUAL;
        if (">=".equals(codeString))
          return QuantityComparator.GREATER_OR_EQUAL;
        if (">".equals(codeString))
          return QuantityComparator.GREATER_THAN;
        if ("ad".equals(codeString))
          return QuantityComparator.AD;
        throw new IllegalArgumentException("Unknown QuantityComparator code '"+codeString+"'");
        }
        public Enumeration<QuantityComparator> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<QuantityComparator>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("<".equals(codeString))
          return new Enumeration<QuantityComparator>(this, QuantityComparator.LESS_THAN);
        if ("<=".equals(codeString))
          return new Enumeration<QuantityComparator>(this, QuantityComparator.LESS_OR_EQUAL);
        if (">=".equals(codeString))
          return new Enumeration<QuantityComparator>(this, QuantityComparator.GREATER_OR_EQUAL);
        if (">".equals(codeString))
          return new Enumeration<QuantityComparator>(this, QuantityComparator.GREATER_THAN);
        if ("ad".equals(codeString))
          return new Enumeration<QuantityComparator>(this, QuantityComparator.AD);
        throw new FHIRException("Unknown QuantityComparator code '"+codeString+"'");
        }
    public String toCode(QuantityComparator code) {
      if (code == QuantityComparator.LESS_THAN)
        return "<";
      if (code == QuantityComparator.LESS_OR_EQUAL)
        return "<=";
      if (code == QuantityComparator.GREATER_OR_EQUAL)
        return ">=";
      if (code == QuantityComparator.GREATER_THAN)
        return ">";
      if (code == QuantityComparator.AD)
        return "ad";
      return "?";
      }
    public String toSystem(QuantityComparator code) {
      return code.getSystem();
      }
    }

    public enum RequestIntent {
        /**
         * The request is a suggestion made by someone/something that does not have an intention to ensure it occurs and without providing an authorization to act.
         */
        PROPOSAL, 
        /**
         * The request represents an intention to ensure something occurs without providing an authorization for others to act.
         */
        PLAN, 
        /**
         * The request represents a legally binding instruction authored by a Patient or RelatedPerson.
         */
        DIRECTIVE, 
        /**
         * The request represents a request/demand and authorization for action by a Practitioner.
         */
        ORDER, 
        /**
         * The request represents an original authorization for action.
         */
        ORIGINALORDER, 
        /**
         * The request represents an automatically generated supplemental authorization for action based on a parent authorization together with initial results of the action taken against that parent authorization.
         */
        REFLEXORDER, 
        /**
         * The request represents the view of an authorization instantiated by a fulfilling system representing the details of the fulfiller's intention to act upon a submitted order.
         */
        FILLERORDER, 
        /**
         * An order created in fulfillment of a broader order that represents the authorization for a single activity occurrence.  E.g. The administration of a single dose of a drug.
         */
        INSTANCEORDER, 
        /**
         * The request represents a component or option for a RequestOrchestration that establishes timing, conditionality and/or other constraints among a set of requests.  Refer to [[[RequestOrchestration]]] for additional information on how this status is used.
         */
        OPTION, 
        /**
         * added to help the parsers
         */
        NULL;
        public static RequestIntent fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("proposal".equals(codeString))
          return PROPOSAL;
        if ("plan".equals(codeString))
          return PLAN;
        if ("directive".equals(codeString))
          return DIRECTIVE;
        if ("order".equals(codeString))
          return ORDER;
        if ("original-order".equals(codeString))
          return ORIGINALORDER;
        if ("reflex-order".equals(codeString))
          return REFLEXORDER;
        if ("filler-order".equals(codeString))
          return FILLERORDER;
        if ("instance-order".equals(codeString))
          return INSTANCEORDER;
        if ("option".equals(codeString))
          return OPTION;
        throw new FHIRException("Unknown RequestIntent code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PROPOSAL: return "proposal";
            case PLAN: return "plan";
            case DIRECTIVE: return "directive";
            case ORDER: return "order";
            case ORIGINALORDER: return "original-order";
            case REFLEXORDER: return "reflex-order";
            case FILLERORDER: return "filler-order";
            case INSTANCEORDER: return "instance-order";
            case OPTION: return "option";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PROPOSAL: return "http://hl7.org/fhir/request-intent";
            case PLAN: return "http://hl7.org/fhir/request-intent";
            case DIRECTIVE: return "http://hl7.org/fhir/request-intent";
            case ORDER: return "http://hl7.org/fhir/request-intent";
            case ORIGINALORDER: return "http://hl7.org/fhir/request-intent";
            case REFLEXORDER: return "http://hl7.org/fhir/request-intent";
            case FILLERORDER: return "http://hl7.org/fhir/request-intent";
            case INSTANCEORDER: return "http://hl7.org/fhir/request-intent";
            case OPTION: return "http://hl7.org/fhir/request-intent";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PROPOSAL: return "The request is a suggestion made by someone/something that does not have an intention to ensure it occurs and without providing an authorization to act.";
            case PLAN: return "The request represents an intention to ensure something occurs without providing an authorization for others to act.";
            case DIRECTIVE: return "The request represents a legally binding instruction authored by a Patient or RelatedPerson.";
            case ORDER: return "The request represents a request/demand and authorization for action by a Practitioner.";
            case ORIGINALORDER: return "The request represents an original authorization for action.";
            case REFLEXORDER: return "The request represents an automatically generated supplemental authorization for action based on a parent authorization together with initial results of the action taken against that parent authorization.";
            case FILLERORDER: return "The request represents the view of an authorization instantiated by a fulfilling system representing the details of the fulfiller's intention to act upon a submitted order.";
            case INSTANCEORDER: return "An order created in fulfillment of a broader order that represents the authorization for a single activity occurrence.  E.g. The administration of a single dose of a drug.";
            case OPTION: return "The request represents a component or option for a RequestOrchestration that establishes timing, conditionality and/or other constraints among a set of requests.  Refer to [[[RequestOrchestration]]] for additional information on how this status is used.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PROPOSAL: return "Proposal";
            case PLAN: return "Plan";
            case DIRECTIVE: return "Directive";
            case ORDER: return "Order";
            case ORIGINALORDER: return "Original Order";
            case REFLEXORDER: return "Reflex Order";
            case FILLERORDER: return "Filler Order";
            case INSTANCEORDER: return "Instance Order";
            case OPTION: return "Option";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class RequestIntentEnumFactory implements EnumFactory<RequestIntent> {
    public RequestIntent fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("proposal".equals(codeString))
          return RequestIntent.PROPOSAL;
        if ("plan".equals(codeString))
          return RequestIntent.PLAN;
        if ("directive".equals(codeString))
          return RequestIntent.DIRECTIVE;
        if ("order".equals(codeString))
          return RequestIntent.ORDER;
        if ("original-order".equals(codeString))
          return RequestIntent.ORIGINALORDER;
        if ("reflex-order".equals(codeString))
          return RequestIntent.REFLEXORDER;
        if ("filler-order".equals(codeString))
          return RequestIntent.FILLERORDER;
        if ("instance-order".equals(codeString))
          return RequestIntent.INSTANCEORDER;
        if ("option".equals(codeString))
          return RequestIntent.OPTION;
        throw new IllegalArgumentException("Unknown RequestIntent code '"+codeString+"'");
        }
        public Enumeration<RequestIntent> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RequestIntent>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("proposal".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.PROPOSAL);
        if ("plan".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.PLAN);
        if ("directive".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.DIRECTIVE);
        if ("order".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.ORDER);
        if ("original-order".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.ORIGINALORDER);
        if ("reflex-order".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.REFLEXORDER);
        if ("filler-order".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.FILLERORDER);
        if ("instance-order".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.INSTANCEORDER);
        if ("option".equals(codeString))
          return new Enumeration<RequestIntent>(this, RequestIntent.OPTION);
        throw new FHIRException("Unknown RequestIntent code '"+codeString+"'");
        }
    public String toCode(RequestIntent code) {
      if (code == RequestIntent.PROPOSAL)
        return "proposal";
      if (code == RequestIntent.PLAN)
        return "plan";
      if (code == RequestIntent.DIRECTIVE)
        return "directive";
      if (code == RequestIntent.ORDER)
        return "order";
      if (code == RequestIntent.ORIGINALORDER)
        return "original-order";
      if (code == RequestIntent.REFLEXORDER)
        return "reflex-order";
      if (code == RequestIntent.FILLERORDER)
        return "filler-order";
      if (code == RequestIntent.INSTANCEORDER)
        return "instance-order";
      if (code == RequestIntent.OPTION)
        return "option";
      return "?";
      }
    public String toSystem(RequestIntent code) {
      return code.getSystem();
      }
    }

    public enum RequestPriority {
        /**
         * The request has normal priority.
         */
        ROUTINE, 
        /**
         * The request should be actioned promptly - higher priority than routine.
         */
        URGENT, 
        /**
         * The request should be actioned as soon as possible - higher priority than urgent.
         */
        ASAP, 
        /**
         * The request should be actioned immediately - highest possible priority.  E.g. an emergency.
         */
        STAT, 
        /**
         * added to help the parsers
         */
        NULL;
        public static RequestPriority fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("routine".equals(codeString))
          return ROUTINE;
        if ("urgent".equals(codeString))
          return URGENT;
        if ("asap".equals(codeString))
          return ASAP;
        if ("stat".equals(codeString))
          return STAT;
        throw new FHIRException("Unknown RequestPriority code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ROUTINE: return "routine";
            case URGENT: return "urgent";
            case ASAP: return "asap";
            case STAT: return "stat";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ROUTINE: return "http://hl7.org/fhir/request-priority";
            case URGENT: return "http://hl7.org/fhir/request-priority";
            case ASAP: return "http://hl7.org/fhir/request-priority";
            case STAT: return "http://hl7.org/fhir/request-priority";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ROUTINE: return "The request has normal priority.";
            case URGENT: return "The request should be actioned promptly - higher priority than routine.";
            case ASAP: return "The request should be actioned as soon as possible - higher priority than urgent.";
            case STAT: return "The request should be actioned immediately - highest possible priority.  E.g. an emergency.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ROUTINE: return "Routine";
            case URGENT: return "Urgent";
            case ASAP: return "ASAP";
            case STAT: return "STAT";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class RequestPriorityEnumFactory implements EnumFactory<RequestPriority> {
    public RequestPriority fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("routine".equals(codeString))
          return RequestPriority.ROUTINE;
        if ("urgent".equals(codeString))
          return RequestPriority.URGENT;
        if ("asap".equals(codeString))
          return RequestPriority.ASAP;
        if ("stat".equals(codeString))
          return RequestPriority.STAT;
        throw new IllegalArgumentException("Unknown RequestPriority code '"+codeString+"'");
        }
        public Enumeration<RequestPriority> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RequestPriority>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("routine".equals(codeString))
          return new Enumeration<RequestPriority>(this, RequestPriority.ROUTINE);
        if ("urgent".equals(codeString))
          return new Enumeration<RequestPriority>(this, RequestPriority.URGENT);
        if ("asap".equals(codeString))
          return new Enumeration<RequestPriority>(this, RequestPriority.ASAP);
        if ("stat".equals(codeString))
          return new Enumeration<RequestPriority>(this, RequestPriority.STAT);
        throw new FHIRException("Unknown RequestPriority code '"+codeString+"'");
        }
    public String toCode(RequestPriority code) {
      if (code == RequestPriority.ROUTINE)
        return "routine";
      if (code == RequestPriority.URGENT)
        return "urgent";
      if (code == RequestPriority.ASAP)
        return "asap";
      if (code == RequestPriority.STAT)
        return "stat";
      return "?";
      }
    public String toSystem(RequestPriority code) {
      return code.getSystem();
      }
    }

    public enum RequestStatus {
        /**
         * The request has been created but is not yet complete or ready for action.
         */
        DRAFT, 
        /**
         * The request is in force and ready to be acted upon.
         */
        ACTIVE, 
        /**
         * The request (and any implicit authorization to act) has been temporarily withdrawn but is expected to resume in the future.
         */
        ONHOLD, 
        /**
         * The request (and any implicit authorization to act) has been terminated prior to the known full completion of the intended actions.  No further activity should occur.
         */
        REVOKED, 
        /**
         * The activity described by the request has been fully performed.  No further activity will occur.
         */
        COMPLETED, 
        /**
         * This request should never have existed and should be considered 'void'.  (It is possible that real-world decisions were based on it.  If real-world activity has occurred, the status should be "revoked" rather than "entered-in-error".).
         */
        ENTEREDINERROR, 
        /**
         * The authoring/source system does not know which of the status values currently applies for this request.  Note: This concept is not to be used for "other" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.
         */
        UNKNOWN, 
        /**
         * added to help the parsers
         */
        NULL;
        public static RequestStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if ("revoked".equals(codeString))
          return REVOKED;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        throw new FHIRException("Unknown RequestStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DRAFT: return "draft";
            case ACTIVE: return "active";
            case ONHOLD: return "on-hold";
            case REVOKED: return "revoked";
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DRAFT: return "http://hl7.org/fhir/request-status";
            case ACTIVE: return "http://hl7.org/fhir/request-status";
            case ONHOLD: return "http://hl7.org/fhir/request-status";
            case REVOKED: return "http://hl7.org/fhir/request-status";
            case COMPLETED: return "http://hl7.org/fhir/request-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/request-status";
            case UNKNOWN: return "http://hl7.org/fhir/request-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DRAFT: return "The request has been created but is not yet complete or ready for action.";
            case ACTIVE: return "The request is in force and ready to be acted upon.";
            case ONHOLD: return "The request (and any implicit authorization to act) has been temporarily withdrawn but is expected to resume in the future.";
            case REVOKED: return "The request (and any implicit authorization to act) has been terminated prior to the known full completion of the intended actions.  No further activity should occur.";
            case COMPLETED: return "The activity described by the request has been fully performed.  No further activity will occur.";
            case ENTEREDINERROR: return "This request should never have existed and should be considered 'void'.  (It is possible that real-world decisions were based on it.  If real-world activity has occurred, the status should be \"revoked\" rather than \"entered-in-error\".).";
            case UNKNOWN: return "The authoring/source system does not know which of the status values currently applies for this request.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DRAFT: return "Draft";
            case ACTIVE: return "Active";
            case ONHOLD: return "On Hold";
            case REVOKED: return "Revoked";
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class RequestStatusEnumFactory implements EnumFactory<RequestStatus> {
    public RequestStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("draft".equals(codeString))
          return RequestStatus.DRAFT;
        if ("active".equals(codeString))
          return RequestStatus.ACTIVE;
        if ("on-hold".equals(codeString))
          return RequestStatus.ONHOLD;
        if ("revoked".equals(codeString))
          return RequestStatus.REVOKED;
        if ("completed".equals(codeString))
          return RequestStatus.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return RequestStatus.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return RequestStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown RequestStatus code '"+codeString+"'");
        }
        public Enumeration<RequestStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RequestStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("draft".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.DRAFT);
        if ("active".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.ACTIVE);
        if ("on-hold".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.ONHOLD);
        if ("revoked".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.REVOKED);
        if ("completed".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.COMPLETED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.ENTEREDINERROR);
        if ("unknown".equals(codeString))
          return new Enumeration<RequestStatus>(this, RequestStatus.UNKNOWN);
        throw new FHIRException("Unknown RequestStatus code '"+codeString+"'");
        }
    public String toCode(RequestStatus code) {
      if (code == RequestStatus.DRAFT)
        return "draft";
      if (code == RequestStatus.ACTIVE)
        return "active";
      if (code == RequestStatus.ONHOLD)
        return "on-hold";
      if (code == RequestStatus.REVOKED)
        return "revoked";
      if (code == RequestStatus.COMPLETED)
        return "completed";
      if (code == RequestStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == RequestStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(RequestStatus code) {
      return code.getSystem();
      }
    }

    public enum ResourceTypes {
        /**
         * A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.
         */
        ACCOUNT, 
        /**
         * This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.
         */
        ACTIVITYDEFINITION, 
        /**
         * The ActorDefinition resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.
         */
        ACTORDEFINITION, 
        /**
         * A medicinal product in the final form which is suitable for administering to a patient (after any mixing of multiple components, dissolution etc. has been performed).
         */
        ADMINISTRABLEPRODUCTDEFINITION, 
        /**
         * An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject. The unintended effects may require additional monitoring, treatment, hospitalization, or may result in death. The AdverseEvent resource also extends to potential or avoided events that could have had such effects. There are two major domains where the AdverseEvent resource is expected to be used. One is in clinical care reported adverse events and the other is in reporting adverse events in clinical  research trial management. Given the differences between these two arenas, we recommend consulting the domain specific implementation guides when implementing the AdverseEvent Resource. The implementation guides include specific extensions, value sets and constraints.
         */
        ADVERSEEVENT, 
        /**
         * Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.
         */
        ALLERGYINTOLERANCE, 
        /**
         * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).
         */
        APPOINTMENT, 
        /**
         * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
         */
        APPOINTMENTRESPONSE, 
        /**
         * This Resource provides one or more comments, classifiers or ratings about a Resource and supports attribution and rights management metadata for the added content.
         */
        ARTIFACTASSESSMENT, 
        /**
         * A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.
         */
        AUDITEVENT, 
        /**
         * Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.
         */
        BASIC, 
        /**
         * A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.
         */
        BINARY, 
        /**
         * A biological material originating from a biological entity intended to be transplanted or infused into another (possibly the same) biological entity.
         */
        BIOLOGICALLYDERIVEDPRODUCT, 
        /**
         * Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.
         */
        BODYSTRUCTURE, 
        /**
         * A container for a collection of resources.
         */
        BUNDLE, 
        /**
         * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server or Client for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        CAPABILITYSTATEMENT, 
        /**
         * Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.
         */
        CAREPLAN, 
        /**
         * The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.
         */
        CARETEAM, 
        /**
         * The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.
         */
        CHARGEITEM, 
        /**
         * The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.
         */
        CHARGEITEMDEFINITION, 
        /**
         * The Citation Resource enables reference to any knowledge artifact for purposes of identification and attribution. The Citation Resource supports existing reference structures and developing publication practices such as versioning, expressing complex contributorship roles, and referencing computable resources.
         */
        CITATION, 
        /**
         * A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.
         */
        CLAIM, 
        /**
         * This resource provides the adjudication details from the processing of a Claim resource.
         */
        CLAIMRESPONSE, 
        /**
         * A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called "ClinicalImpression" rather than "ClinicalAssessment" to avoid confusion with the recording of assessment tools such as Apgar score.
         */
        CLINICALIMPRESSION, 
        /**
         * A single issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.
         */
        CLINICALUSEDEFINITION, 
        /**
         * The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.
         */
        CODESYSTEM, 
        /**
         * A clinical or business level record of information being transmitted or shared; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.
         */
        COMMUNICATION, 
        /**
         * A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.
         */
        COMMUNICATIONREQUEST, 
        /**
         * A compartment definition that defines how resources are accessed on a server.
         */
        COMPARTMENTDEFINITION, 
        /**
         * A set of healthcare-related information that is assembled together into a single logical package that provides a single coherent statement of meaning, establishes its own context and that has clinical attestation with regard to who is making the statement. A Composition defines the structure and narrative content necessary for a document. However, a Composition alone does not constitute a document. Rather, the Composition must be the first entry in a Bundle where Bundle.type=document, and any other resources referenced from Composition must be included as subsequent entries in the Bundle (for example Patient, Practitioner, Encounter, etc.).
         */
        COMPOSITION, 
        /**
         * A statement of relationships from one set of concepts to one or more other concepts - either concepts in code systems, or data element/data element concepts, or classes in class models.
         */
        CONCEPTMAP, 
        /**
         * A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a level of concern.
         */
        CONDITION, 
        /**
         * A definition of a condition and information relevant to managing it.
         */
        CONDITIONDEFINITION, 
        /**
         * A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.
         */
        CONSENT, 
        /**
         * Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement.
         */
        CONTRACT, 
        /**
         * Financial instrument which may be used to reimburse or pay for health care products and services. Includes both insurance and self-payment.
         */
        COVERAGE, 
        /**
         * The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage is valid and in-force and optionally to provide the insurance details of the policy.
         */
        COVERAGEELIGIBILITYREQUEST, 
        /**
         * This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.
         */
        COVERAGEELIGIBILITYRESPONSE, 
        /**
         * Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, etc.
         */
        DETECTEDISSUE, 
        /**
         * This resource describes the properties (regulated, has real time clock, etc.), adminstrative (manufacturer name, model number, serial number, firmware, etc), and type (knee replacement, blood pressure cuff, MRI, etc.) of a physical unit (these values do not change much within a given module, for example the serail number, manufacturer name, and model number). An actual unit may consist of several modules in a distinct hierarchy and these are represented by multiple Device resources and bound through the 'parent' element.
         */
        DEVICE, 
        /**
         * This is a specialized resource that defines the characteristics and capabilities of a device.
         */
        DEVICEDEFINITION, 
        /**
         * Indicates that a device is to be or has been dispensed for a named person/patient.  This includes a description of the product (supply) provided and the instructions for using the device.
         */
        DEVICEDISPENSE, 
        /**
         * Describes a measurement, calculation or setting capability of a medical device.
         */
        DEVICEMETRIC, 
        /**
         * Represents a request a device to be provided to a specific patient. The device may be an implantable device to be subsequently implanted, or an external assistive device, such as a walker, to be delivered and subsequently be used.
         */
        DEVICEREQUEST, 
        /**
         * A record of a device being used by a patient where the record is the result of a report from the patient or a clinician.
         */
        DEVICEUSAGE, 
        /**
         * The findings and interpretation of diagnostic tests performed on patients, groups of patients, products, substances, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports. The report also includes non-clinical context such as batch analysis and stability reporting of products and substances.
         */
        DIAGNOSTICREPORT, 
        /**
         * A collection of documents compiled for a purpose together with metadata that applies to the collection.
         */
        DOCUMENTMANIFEST, 
        /**
         * A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this "document" encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.
         */
        DOCUMENTREFERENCE, 
        /**
         * An interaction between healthcare provider(s), and/or patient(s) for the purpose of providing healthcare service(s) or assessing the health status of patient(s).
         */
        ENCOUNTER, 
        /**
         * The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b, a REST endpoint for another FHIR server, or a s/Mime email address. This may include any security context information.
         */
        ENDPOINT, 
        /**
         * This resource provides the insurance enrollment details to the insurer regarding a specified coverage.
         */
        ENROLLMENTREQUEST, 
        /**
         * This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.
         */
        ENROLLMENTRESPONSE, 
        /**
         * An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.
         */
        EPISODEOFCARE, 
        /**
         * The EventDefinition resource provides a reusable description of when a particular event can occur.
         */
        EVENTDEFINITION, 
        /**
         * The Evidence Resource provides a machine-interpretable expression of an evidence concept including the evidence variables (e.g., population, exposures/interventions, comparators, outcomes, measured variables, confounding variables), the statistics, and the certainty of this evidence.
         */
        EVIDENCE, 
        /**
         * The EvidenceReport Resource is a specialized container for a collection of resources and codeable concepts, adapted to support compositions of Evidence, EvidenceVariable, and Citation resources and related concepts.
         */
        EVIDENCEREPORT, 
        /**
         * The EvidenceVariable resource describes an element that knowledge (Evidence) is about.
         */
        EVIDENCEVARIABLE, 
        /**
         * A walkthrough of a workflow showing the interaction between systems and the instances shared, possibly including the evolution of instances over time.
         */
        EXAMPLESCENARIO, 
        /**
         * This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.
         */
        EXPLANATIONOFBENEFIT, 
        /**
         * Significant health conditions for a person related to the patient relevant in the context of care for the patient.
         */
        FAMILYMEMBERHISTORY, 
        /**
         * Prospective warnings of potential issues when providing care to the patient.
         */
        FLAG, 
        /**
         * This resource describes a product or service that is available through a program and includes the conditions and constraints of availability.  All of the information in this resource is specific to the inclusion of the item in the formulary and is not inherent to the item itself.
         */
        FORMULARYITEM, 
        /**
         * A Genomic Study is a set of analysis performed to analyze and generate genomic data.
         */
        GENOMICSTUDY, 
        /**
         * Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.
         */
        GOAL, 
        /**
         * A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.
         */
        GRAPHDEFINITION, 
        /**
         * Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.
         */
        GROUP, 
        /**
         * A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.
         */
        GUIDANCERESPONSE, 
        /**
         * The details of a healthcare service available at a location or in a catalog.  In the case where there is a hierarchy of services (for example, Lab -> Pathology -> Wound Cultures), this can be represented using a set of linked HealthcareServices.
         */
        HEALTHCARESERVICE, 
        /**
         * A selection of DICOM SOP instances and/or frames within a single Study and Series. This might include additional specifics such as an image region, an Observation UID or a Segmentation Number, allowing linkage to an Observation Resource or transferring this information along with the ImagingStudy Resource.
         */
        IMAGINGSELECTION, 
        /**
         * Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.
         */
        IMAGINGSTUDY, 
        /**
         * Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.
         */
        IMMUNIZATION, 
        /**
         * Describes a comparison of an immunization event against published recommendations to determine if the administration is "valid" in relation to those  recommendations.
         */
        IMMUNIZATIONEVALUATION, 
        /**
         * A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.
         */
        IMMUNIZATIONRECOMMENDATION, 
        /**
         * A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.
         */
        IMPLEMENTATIONGUIDE, 
        /**
         * An ingredient of a manufactured item or pharmaceutical product.
         */
        INGREDIENT, 
        /**
         * Details of a Health Insurance product/plan provided by an organization.
         */
        INSURANCEPLAN, 
        /**
         * A report of inventory or stock items.
         */
        INVENTORYREPORT, 
        /**
         * Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.
         */
        INVOICE, 
        /**
         * The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.
         */
        LIBRARY, 
        /**
         * Identifies two or more records (resource instances) that refer to the same real-world "occurrence".
         */
        LINKAGE, 
        /**
         * A List is a curated collection of resources, for things such as problem lists, allergy lists, facility list, organization list, etc.
         */
        LIST, 
        /**
         * Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.
         */
        LOCATION, 
        /**
         * The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.
         */
        MANUFACTUREDITEMDEFINITION, 
        /**
         * The Measure resource provides the definition of a quality measure.
         */
        MEASURE, 
        /**
         * The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.
         */
        MEASUREREPORT, 
        /**
         * This resource is primarily used for the identification and definition of a medication, including ingredients, for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.
         */
        MEDICATION, 
        /**
         * Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.
         */
        MEDICATIONADMINISTRATION, 
        /**
         * Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.
         */
        MEDICATIONDISPENSE, 
        /**
         * Information about a medication that is used to support knowledge.
         */
        MEDICATIONKNOWLEDGE, 
        /**
         * An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called "MedicationRequest" rather than "MedicationPrescription" or "MedicationOrder" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.
         */
        MEDICATIONREQUEST, 
        /**
         * A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. 

The primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.
         */
        MEDICATIONUSAGE, 
        /**
         * Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use, drug catalogs, to support prescribing, adverse events management etc.).
         */
        MEDICINALPRODUCTDEFINITION, 
        /**
         * Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.
         */
        MESSAGEDEFINITION, 
        /**
         * The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.
         */
        MESSAGEHEADER, 
        /**
         * Representation of a molecular sequence.
         */
        MOLECULARSEQUENCE, 
        /**
         * A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a "System" used within the Identifier and Coding data types.
         */
        NAMINGSYSTEM, 
        /**
         * A record of food or fluid that is being consumed by a patient.  A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.
         */
        NUTRITIONINTAKE, 
        /**
         * A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.
         */
        NUTRITIONORDER, 
        /**
         * A food or supplement that is consumed by patients.
         */
        NUTRITIONPRODUCT, 
        /**
         * Measurements and simple assertions made about a patient, device or other subject.
         */
        OBSERVATION, 
        /**
         * Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.
         */
        OBSERVATIONDEFINITION, 
        /**
         * A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).
         */
        OPERATIONDEFINITION, 
        /**
         * A collection of error, warning, or information messages that result from a system action.
         */
        OPERATIONOUTCOME, 
        /**
         * A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.
         */
        ORGANIZATION, 
        /**
         * Defines an affiliation/assotiation/relationship between 2 distinct organizations, that is not a part-of relationship/sub-division relationship.
         */
        ORGANIZATIONAFFILIATION, 
        /**
         * A medically related item or items, in a container or package.
         */
        PACKAGEDPRODUCTDEFINITION, 
        /**
         * This resource is used to pass information into and back from an operation (whether invoked directly from REST or within a messaging environment).  It is not persisted or allowed to be referenced by other resources except as described in the definition of the Parameters resource.
         */
        PARAMETERS, 
        /**
         * Demographics and other administrative information about an individual or animal receiving care or other health-related services.
         */
        PATIENT, 
        /**
         * This resource provides the status of the payment for goods and services rendered, and the request and response resource references.
         */
        PAYMENTNOTICE, 
        /**
         * This resource provides the details including amount of a payment and allocates the payment items being paid.
         */
        PAYMENTRECONCILIATION, 
        /**
         * Permission resource holds access rules for a given data and context.
         */
        PERMISSION, 
        /**
         * Demographics and administrative information about a person independent of a specific health-related context.
         */
        PERSON, 
        /**
         * This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical and non-clinical artifacts such as clinical decision support rules, order sets, protocols, and drug quality specifications.
         */
        PLANDEFINITION, 
        /**
         * A person who is directly or indirectly involved in the provisioning of healthcare or related services.
         */
        PRACTITIONER, 
        /**
         * A specific set of Roles/Locations/specialties/services that a practitioner may perform, or has performed at an organization during a period of time.
         */
        PRACTITIONERROLE, 
        /**
         * An action that is or was performed on or for a patient, practitioner, device, organization, or location. For example, this can be a physical intervention on a patient like an operation, or less invasive like long term services, counseling, or hypnotherapy.  This can be a quality or safety inspection for a location, organization, or device.  This can be an accreditation procedure on a practitioner for licensing.
         */
        PROCEDURE, 
        /**
         * Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.
         */
        PROVENANCE, 
        /**
         * A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.
         */
        QUESTIONNAIRE, 
        /**
         * A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.
         */
        QUESTIONNAIRERESPONSE, 
        /**
         * Regulatory approval, clearance or licencing related to a regulated product, treatment, facility or activity that is cited in a guidance, regulation, rule or legislative act. An example is Market Authorization relating to a Medicinal Product.
         */
        REGULATEDAUTHORIZATION, 
        /**
         * Information about a person that is involved in a patient's health or the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.
         */
        RELATEDPERSON, 
        /**
         * A set of related requests that can be used to capture intended activities that have inter-dependencies such as "give this medication after that one".
         */
        REQUESTORCHESTRATION, 
        /**
         * The Requirements resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.
         */
        REQUIREMENTS, 
        /**
         * A scientific study of nature that sometimes includes processes involved in health and disease. For example, clinical trials are research studies that involve people. These studies may be related to new ways to screen, prevent, diagnose, and treat disease. They may also study certain outcomes and certain groups of people by looking at data collected in the past or future.
         */
        RESEARCHSTUDY, 
        /**
         * A physical entity which is the primary unit of operational and/or administrative interest in a study.
         */
        RESEARCHSUBJECT, 
        /**
         * An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.
         */
        RISKASSESSMENT, 
        /**
         * A container for slots of time that may be available for booking appointments.
         */
        SCHEDULE, 
        /**
         * A search parameter that defines a named search item that can be used to search/filter on a resource.
         */
        SEARCHPARAMETER, 
        /**
         * A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.
         */
        SERVICEREQUEST, 
        /**
         * A slot of time on a schedule that may be available for booking appointments.
         */
        SLOT, 
        /**
         * A sample to be used for analysis.
         */
        SPECIMEN, 
        /**
         * A kind of specimen with associated set of requirements.
         */
        SPECIMENDEFINITION, 
        /**
         * A definition of a FHIR structure. This resource is used to describe the underlying resources, data types defined in FHIR, and also for describing extensions and constraints on resources and data types.
         */
        STRUCTUREDEFINITION, 
        /**
         * A Map of relationships between 2 structures that can be used to transform data.
         */
        STRUCTUREMAP, 
        /**
         * The subscription resource describes a particular client's request to be notified about a SubscriptionTopic.
         */
        SUBSCRIPTION, 
        /**
         * The SubscriptionStatus resource describes the state of a Subscription during notifications. It is not persisted.
         */
        SUBSCRIPTIONSTATUS, 
        /**
         * Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.
         */
        SUBSCRIPTIONTOPIC, 
        /**
         * A homogeneous material with a definite composition.
         */
        SUBSTANCE, 
        /**
         * The detailed description of a substance, typically at a level beyond what is used for prescribing.
         */
        SUBSTANCEDEFINITION, 
        /**
         * Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.
         */
        SUBSTANCENUCLEICACID, 
        /**
         * Properties of a substance specific to it being a polymer.
         */
        SUBSTANCEPOLYMER, 
        /**
         * A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.
         */
        SUBSTANCEPROTEIN, 
        /**
         * Todo.
         */
        SUBSTANCEREFERENCEINFORMATION, 
        /**
         * Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.
         */
        SUBSTANCESOURCEMATERIAL, 
        /**
         * Record of delivery of what is supplied.
         */
        SUPPLYDELIVERY, 
        /**
         * A record of a non-patient specific request for a medication, substance, device, certain types of biologically derived product, and nutrition product used in the healthcare setting.
         */
        SUPPLYREQUEST, 
        /**
         * A task to be performed.
         */
        TASK, 
        /**
         * A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        TERMINOLOGYCAPABILITIES, 
        /**
         * A summary of information based on the results of executing a TestScript.
         */
        TESTREPORT, 
        /**
         * A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.
         */
        TESTSCRIPT, 
        /**
         * Record of transport.
         */
        TRANSPORT, 
        /**
         * A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).
         */
        VALUESET, 
        /**
         * Describes validation requirements, source(s), status and dates for one or more elements.
         */
        VERIFICATIONRESULT, 
        /**
         * An authorization for the provision of glasses and/or contact lenses to a patient.
         */
        VISIONPRESCRIPTION, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ResourceTypes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Account".equals(codeString))
          return ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return ACTIVITYDEFINITION;
        if ("ActorDefinition".equals(codeString))
          return ACTORDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return APPOINTMENTRESPONSE;
        if ("ArtifactAssessment".equals(codeString))
          return ARTIFACTASSESSMENT;
        if ("AuditEvent".equals(codeString))
          return AUDITEVENT;
        if ("Basic".equals(codeString))
          return BASIC;
        if ("Binary".equals(codeString))
          return BINARY;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return BODYSTRUCTURE;
        if ("Bundle".equals(codeString))
          return BUNDLE;
        if ("CapabilityStatement".equals(codeString))
          return CAPABILITYSTATEMENT;
        if ("CarePlan".equals(codeString))
          return CAREPLAN;
        if ("CareTeam".equals(codeString))
          return CARETEAM;
        if ("ChargeItem".equals(codeString))
          return CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return CHARGEITEMDEFINITION;
        if ("Citation".equals(codeString))
          return CITATION;
        if ("Claim".equals(codeString))
          return CLAIM;
        if ("ClaimResponse".equals(codeString))
          return CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return CLINICALIMPRESSION;
        if ("ClinicalUseDefinition".equals(codeString))
          return CLINICALUSEDEFINITION;
        if ("CodeSystem".equals(codeString))
          return CODESYSTEM;
        if ("Communication".equals(codeString))
          return COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return CONCEPTMAP;
        if ("Condition".equals(codeString))
          return CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return CONSENT;
        if ("Contract".equals(codeString))
          return CONTRACT;
        if ("Coverage".equals(codeString))
          return COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return DETECTEDISSUE;
        if ("Device".equals(codeString))
          return DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return DEVICEDEFINITION;
        if ("DeviceDispense".equals(codeString))
          return DEVICEDISPENSE;
        if ("DeviceMetric".equals(codeString))
          return DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return DEVICEREQUEST;
        if ("DeviceUsage".equals(codeString))
          return DEVICEUSAGE;
        if ("DiagnosticReport".equals(codeString))
          return DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return DOCUMENTREFERENCE;
        if ("Encounter".equals(codeString))
          return ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return EVIDENCE;
        if ("EvidenceReport".equals(codeString))
          return EVIDENCEREPORT;
        if ("EvidenceVariable".equals(codeString))
          return EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return FLAG;
        if ("FormularyItem".equals(codeString))
          return FORMULARYITEM;
        if ("GenomicStudy".equals(codeString))
          return GENOMICSTUDY;
        if ("Goal".equals(codeString))
          return GOAL;
        if ("GraphDefinition".equals(codeString))
          return GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return GROUP;
        if ("GuidanceResponse".equals(codeString))
          return GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return HEALTHCARESERVICE;
        if ("ImagingSelection".equals(codeString))
          return IMAGINGSELECTION;
        if ("ImagingStudy".equals(codeString))
          return IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return INSURANCEPLAN;
        if ("InventoryReport".equals(codeString))
          return INVENTORYREPORT;
        if ("Invoice".equals(codeString))
          return INVOICE;
        if ("Library".equals(codeString))
          return LIBRARY;
        if ("Linkage".equals(codeString))
          return LINKAGE;
        if ("List".equals(codeString))
          return LIST;
        if ("Location".equals(codeString))
          return LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return MEASURE;
        if ("MeasureReport".equals(codeString))
          return MEASUREREPORT;
        if ("Medication".equals(codeString))
          return MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return MESSAGEHEADER;
        if ("MolecularSequence".equals(codeString))
          return MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return NUTRITIONORDER;
        if ("NutritionProduct".equals(codeString))
          return NUTRITIONPRODUCT;
        if ("Observation".equals(codeString))
          return OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return PACKAGEDPRODUCTDEFINITION;
        if ("Parameters".equals(codeString))
          return PARAMETERS;
        if ("Patient".equals(codeString))
          return PATIENT;
        if ("PaymentNotice".equals(codeString))
          return PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return PAYMENTRECONCILIATION;
        if ("Permission".equals(codeString))
          return PERMISSION;
        if ("Person".equals(codeString))
          return PERSON;
        if ("PlanDefinition".equals(codeString))
          return PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return PROCEDURE;
        if ("Provenance".equals(codeString))
          return PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return RELATEDPERSON;
        if ("RequestOrchestration".equals(codeString))
          return REQUESTORCHESTRATION;
        if ("Requirements".equals(codeString))
          return REQUIREMENTS;
        if ("ResearchStudy".equals(codeString))
          return RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return RESEARCHSUBJECT;
        if ("RiskAssessment".equals(codeString))
          return RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return SLOT;
        if ("Specimen".equals(codeString))
          return SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return SUBSCRIPTION;
        if ("SubscriptionStatus".equals(codeString))
          return SUBSCRIPTIONSTATUS;
        if ("SubscriptionTopic".equals(codeString))
          return SUBSCRIPTIONTOPIC;
        if ("Substance".equals(codeString))
          return SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return TESTREPORT;
        if ("TestScript".equals(codeString))
          return TESTSCRIPT;
        if ("Transport".equals(codeString))
          return TRANSPORT;
        if ("ValueSet".equals(codeString))
          return VALUESET;
        if ("VerificationResult".equals(codeString))
          return VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return VISIONPRESCRIPTION;
        throw new FHIRException("Unknown ResourceTypes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ACTORDEFINITION: return "ActorDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case ARTIFACTASSESSMENT: return "ArtifactAssessment";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CITATION: return "Citation";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEDEFINITION: return "ClinicalUseDefinition";
            case CODESYSTEM: return "CodeSystem";
            case COMMUNICATION: return "Communication";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case COMPARTMENTDEFINITION: return "CompartmentDefinition";
            case COMPOSITION: return "Composition";
            case CONCEPTMAP: return "ConceptMap";
            case CONDITION: return "Condition";
            case CONDITIONDEFINITION: return "ConditionDefinition";
            case CONSENT: return "Consent";
            case CONTRACT: return "Contract";
            case COVERAGE: return "Coverage";
            case COVERAGEELIGIBILITYREQUEST: return "CoverageEligibilityRequest";
            case COVERAGEELIGIBILITYRESPONSE: return "CoverageEligibilityResponse";
            case DETECTEDISSUE: return "DetectedIssue";
            case DEVICE: return "Device";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case DEVICEDISPENSE: return "DeviceDispense";
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSAGE: return "DeviceUsage";
            case DIAGNOSTICREPORT: return "DiagnosticReport";
            case DOCUMENTMANIFEST: return "DocumentManifest";
            case DOCUMENTREFERENCE: return "DocumentReference";
            case ENCOUNTER: return "Encounter";
            case ENDPOINT: return "Endpoint";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case ENROLLMENTRESPONSE: return "EnrollmentResponse";
            case EPISODEOFCARE: return "EpisodeOfCare";
            case EVENTDEFINITION: return "EventDefinition";
            case EVIDENCE: return "Evidence";
            case EVIDENCEREPORT: return "EvidenceReport";
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case FORMULARYITEM: return "FormularyItem";
            case GENOMICSTUDY: return "GenomicStudy";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSELECTION: return "ImagingSelection";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
            case INVENTORYREPORT: return "InventoryReport";
            case INVOICE: return "Invoice";
            case LIBRARY: return "Library";
            case LINKAGE: return "Linkage";
            case LIST: return "List";
            case LOCATION: return "Location";
            case MANUFACTUREDITEMDEFINITION: return "ManufacturedItemDefinition";
            case MEASURE: return "Measure";
            case MEASUREREPORT: return "MeasureReport";
            case MEDICATION: return "Medication";
            case MEDICATIONADMINISTRATION: return "MedicationAdministration";
            case MEDICATIONDISPENSE: return "MedicationDispense";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case MEDICATIONUSAGE: return "MedicationUsage";
            case MEDICINALPRODUCTDEFINITION: return "MedicinalProductDefinition";
            case MESSAGEDEFINITION: return "MessageDefinition";
            case MESSAGEHEADER: return "MessageHeader";
            case MOLECULARSEQUENCE: return "MolecularSequence";
            case NAMINGSYSTEM: return "NamingSystem";
            case NUTRITIONINTAKE: return "NutritionIntake";
            case NUTRITIONORDER: return "NutritionOrder";
            case NUTRITIONPRODUCT: return "NutritionProduct";
            case OBSERVATION: return "Observation";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case OPERATIONDEFINITION: return "OperationDefinition";
            case OPERATIONOUTCOME: return "OperationOutcome";
            case ORGANIZATION: return "Organization";
            case ORGANIZATIONAFFILIATION: return "OrganizationAffiliation";
            case PACKAGEDPRODUCTDEFINITION: return "PackagedProductDefinition";
            case PARAMETERS: return "Parameters";
            case PATIENT: return "Patient";
            case PAYMENTNOTICE: return "PaymentNotice";
            case PAYMENTRECONCILIATION: return "PaymentReconciliation";
            case PERMISSION: return "Permission";
            case PERSON: return "Person";
            case PLANDEFINITION: return "PlanDefinition";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case PROCEDURE: return "Procedure";
            case PROVENANCE: return "Provenance";
            case QUESTIONNAIRE: return "Questionnaire";
            case QUESTIONNAIRERESPONSE: return "QuestionnaireResponse";
            case REGULATEDAUTHORIZATION: return "RegulatedAuthorization";
            case RELATEDPERSON: return "RelatedPerson";
            case REQUESTORCHESTRATION: return "RequestOrchestration";
            case REQUIREMENTS: return "Requirements";
            case RESEARCHSTUDY: return "ResearchStudy";
            case RESEARCHSUBJECT: return "ResearchSubject";
            case RISKASSESSMENT: return "RiskAssessment";
            case SCHEDULE: return "Schedule";
            case SEARCHPARAMETER: return "SearchParameter";
            case SERVICEREQUEST: return "ServiceRequest";
            case SLOT: return "Slot";
            case SPECIMEN: return "Specimen";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case STRUCTUREDEFINITION: return "StructureDefinition";
            case STRUCTUREMAP: return "StructureMap";
            case SUBSCRIPTION: return "Subscription";
            case SUBSCRIPTIONSTATUS: return "SubscriptionStatus";
            case SUBSCRIPTIONTOPIC: return "SubscriptionTopic";
            case SUBSTANCE: return "Substance";
            case SUBSTANCEDEFINITION: return "SubstanceDefinition";
            case SUBSTANCENUCLEICACID: return "SubstanceNucleicAcid";
            case SUBSTANCEPOLYMER: return "SubstancePolymer";
            case SUBSTANCEPROTEIN: return "SubstanceProtein";
            case SUBSTANCEREFERENCEINFORMATION: return "SubstanceReferenceInformation";
            case SUBSTANCESOURCEMATERIAL: return "SubstanceSourceMaterial";
            case SUPPLYDELIVERY: return "SupplyDelivery";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case TERMINOLOGYCAPABILITIES: return "TerminologyCapabilities";
            case TESTREPORT: return "TestReport";
            case TESTSCRIPT: return "TestScript";
            case TRANSPORT: return "Transport";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACCOUNT: return "http://hl7.org/fhir/fhir-types";
            case ACTIVITYDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case ACTORDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case ADMINISTRABLEPRODUCTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case ADVERSEEVENT: return "http://hl7.org/fhir/fhir-types";
            case ALLERGYINTOLERANCE: return "http://hl7.org/fhir/fhir-types";
            case APPOINTMENT: return "http://hl7.org/fhir/fhir-types";
            case APPOINTMENTRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case ARTIFACTASSESSMENT: return "http://hl7.org/fhir/fhir-types";
            case AUDITEVENT: return "http://hl7.org/fhir/fhir-types";
            case BASIC: return "http://hl7.org/fhir/fhir-types";
            case BINARY: return "http://hl7.org/fhir/fhir-types";
            case BIOLOGICALLYDERIVEDPRODUCT: return "http://hl7.org/fhir/fhir-types";
            case BODYSTRUCTURE: return "http://hl7.org/fhir/fhir-types";
            case BUNDLE: return "http://hl7.org/fhir/fhir-types";
            case CAPABILITYSTATEMENT: return "http://hl7.org/fhir/fhir-types";
            case CAREPLAN: return "http://hl7.org/fhir/fhir-types";
            case CARETEAM: return "http://hl7.org/fhir/fhir-types";
            case CHARGEITEM: return "http://hl7.org/fhir/fhir-types";
            case CHARGEITEMDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case CITATION: return "http://hl7.org/fhir/fhir-types";
            case CLAIM: return "http://hl7.org/fhir/fhir-types";
            case CLAIMRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case CLINICALIMPRESSION: return "http://hl7.org/fhir/fhir-types";
            case CLINICALUSEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case CODESYSTEM: return "http://hl7.org/fhir/fhir-types";
            case COMMUNICATION: return "http://hl7.org/fhir/fhir-types";
            case COMMUNICATIONREQUEST: return "http://hl7.org/fhir/fhir-types";
            case COMPARTMENTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case COMPOSITION: return "http://hl7.org/fhir/fhir-types";
            case CONCEPTMAP: return "http://hl7.org/fhir/fhir-types";
            case CONDITION: return "http://hl7.org/fhir/fhir-types";
            case CONDITIONDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case CONSENT: return "http://hl7.org/fhir/fhir-types";
            case CONTRACT: return "http://hl7.org/fhir/fhir-types";
            case COVERAGE: return "http://hl7.org/fhir/fhir-types";
            case COVERAGEELIGIBILITYREQUEST: return "http://hl7.org/fhir/fhir-types";
            case COVERAGEELIGIBILITYRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case DETECTEDISSUE: return "http://hl7.org/fhir/fhir-types";
            case DEVICE: return "http://hl7.org/fhir/fhir-types";
            case DEVICEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case DEVICEDISPENSE: return "http://hl7.org/fhir/fhir-types";
            case DEVICEMETRIC: return "http://hl7.org/fhir/fhir-types";
            case DEVICEREQUEST: return "http://hl7.org/fhir/fhir-types";
            case DEVICEUSAGE: return "http://hl7.org/fhir/fhir-types";
            case DIAGNOSTICREPORT: return "http://hl7.org/fhir/fhir-types";
            case DOCUMENTMANIFEST: return "http://hl7.org/fhir/fhir-types";
            case DOCUMENTREFERENCE: return "http://hl7.org/fhir/fhir-types";
            case ENCOUNTER: return "http://hl7.org/fhir/fhir-types";
            case ENDPOINT: return "http://hl7.org/fhir/fhir-types";
            case ENROLLMENTREQUEST: return "http://hl7.org/fhir/fhir-types";
            case ENROLLMENTRESPONSE: return "http://hl7.org/fhir/fhir-types";
            case EPISODEOFCARE: return "http://hl7.org/fhir/fhir-types";
            case EVENTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case EVIDENCE: return "http://hl7.org/fhir/fhir-types";
            case EVIDENCEREPORT: return "http://hl7.org/fhir/fhir-types";
            case EVIDENCEVARIABLE: return "http://hl7.org/fhir/fhir-types";
            case EXAMPLESCENARIO: return "http://hl7.org/fhir/fhir-types";
            case EXPLANATIONOFBENEFIT: return "http://hl7.org/fhir/fhir-types";
            case FAMILYMEMBERHISTORY: return "http://hl7.org/fhir/fhir-types";
            case FLAG: return "http://hl7.org/fhir/fhir-types";
            case FORMULARYITEM: return "http://hl7.org/fhir/fhir-types";
            case GENOMICSTUDY: return "http://hl7.org/fhir/fhir-types";
            case GOAL: return "http://hl7.org/fhir/fhir-types";
            case GRAPHDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case GROUP: return "http://hl7.org/fhir/fhir-types";
            case GUIDANCERESPONSE: return "http://hl7.org/fhir/fhir-types";
            case HEALTHCARESERVICE: return "http://hl7.org/fhir/fhir-types";
            case IMAGINGSELECTION: return "http://hl7.org/fhir/fhir-types";
            case IMAGINGSTUDY: return "http://hl7.org/fhir/fhir-types";
            case IMMUNIZATION: return "http://hl7.org/fhir/fhir-types";
            case IMMUNIZATIONEVALUATION: return "http://hl7.org/fhir/fhir-types";
            case IMMUNIZATIONRECOMMENDATION: return "http://hl7.org/fhir/fhir-types";
            case IMPLEMENTATIONGUIDE: return "http://hl7.org/fhir/fhir-types";
            case INGREDIENT: return "http://hl7.org/fhir/fhir-types";
            case INSURANCEPLAN: return "http://hl7.org/fhir/fhir-types";
            case INVENTORYREPORT: return "http://hl7.org/fhir/fhir-types";
            case INVOICE: return "http://hl7.org/fhir/fhir-types";
            case LIBRARY: return "http://hl7.org/fhir/fhir-types";
            case LINKAGE: return "http://hl7.org/fhir/fhir-types";
            case LIST: return "http://hl7.org/fhir/fhir-types";
            case LOCATION: return "http://hl7.org/fhir/fhir-types";
            case MANUFACTUREDITEMDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case MEASURE: return "http://hl7.org/fhir/fhir-types";
            case MEASUREREPORT: return "http://hl7.org/fhir/fhir-types";
            case MEDICATION: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONADMINISTRATION: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONDISPENSE: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONKNOWLEDGE: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONREQUEST: return "http://hl7.org/fhir/fhir-types";
            case MEDICATIONUSAGE: return "http://hl7.org/fhir/fhir-types";
            case MEDICINALPRODUCTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case MESSAGEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case MESSAGEHEADER: return "http://hl7.org/fhir/fhir-types";
            case MOLECULARSEQUENCE: return "http://hl7.org/fhir/fhir-types";
            case NAMINGSYSTEM: return "http://hl7.org/fhir/fhir-types";
            case NUTRITIONINTAKE: return "http://hl7.org/fhir/fhir-types";
            case NUTRITIONORDER: return "http://hl7.org/fhir/fhir-types";
            case NUTRITIONPRODUCT: return "http://hl7.org/fhir/fhir-types";
            case OBSERVATION: return "http://hl7.org/fhir/fhir-types";
            case OBSERVATIONDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case OPERATIONDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case OPERATIONOUTCOME: return "http://hl7.org/fhir/fhir-types";
            case ORGANIZATION: return "http://hl7.org/fhir/fhir-types";
            case ORGANIZATIONAFFILIATION: return "http://hl7.org/fhir/fhir-types";
            case PACKAGEDPRODUCTDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case PARAMETERS: return "http://hl7.org/fhir/fhir-types";
            case PATIENT: return "http://hl7.org/fhir/fhir-types";
            case PAYMENTNOTICE: return "http://hl7.org/fhir/fhir-types";
            case PAYMENTRECONCILIATION: return "http://hl7.org/fhir/fhir-types";
            case PERMISSION: return "http://hl7.org/fhir/fhir-types";
            case PERSON: return "http://hl7.org/fhir/fhir-types";
            case PLANDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case PRACTITIONER: return "http://hl7.org/fhir/fhir-types";
            case PRACTITIONERROLE: return "http://hl7.org/fhir/fhir-types";
            case PROCEDURE: return "http://hl7.org/fhir/fhir-types";
            case PROVENANCE: return "http://hl7.org/fhir/fhir-types";
            case QUESTIONNAIRE: return "http://hl7.org/fhir/fhir-types";
            case QUESTIONNAIRERESPONSE: return "http://hl7.org/fhir/fhir-types";
            case REGULATEDAUTHORIZATION: return "http://hl7.org/fhir/fhir-types";
            case RELATEDPERSON: return "http://hl7.org/fhir/fhir-types";
            case REQUESTORCHESTRATION: return "http://hl7.org/fhir/fhir-types";
            case REQUIREMENTS: return "http://hl7.org/fhir/fhir-types";
            case RESEARCHSTUDY: return "http://hl7.org/fhir/fhir-types";
            case RESEARCHSUBJECT: return "http://hl7.org/fhir/fhir-types";
            case RISKASSESSMENT: return "http://hl7.org/fhir/fhir-types";
            case SCHEDULE: return "http://hl7.org/fhir/fhir-types";
            case SEARCHPARAMETER: return "http://hl7.org/fhir/fhir-types";
            case SERVICEREQUEST: return "http://hl7.org/fhir/fhir-types";
            case SLOT: return "http://hl7.org/fhir/fhir-types";
            case SPECIMEN: return "http://hl7.org/fhir/fhir-types";
            case SPECIMENDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case STRUCTUREDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case STRUCTUREMAP: return "http://hl7.org/fhir/fhir-types";
            case SUBSCRIPTION: return "http://hl7.org/fhir/fhir-types";
            case SUBSCRIPTIONSTATUS: return "http://hl7.org/fhir/fhir-types";
            case SUBSCRIPTIONTOPIC: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCE: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEDEFINITION: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCENUCLEICACID: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEPOLYMER: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEPROTEIN: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCEREFERENCEINFORMATION: return "http://hl7.org/fhir/fhir-types";
            case SUBSTANCESOURCEMATERIAL: return "http://hl7.org/fhir/fhir-types";
            case SUPPLYDELIVERY: return "http://hl7.org/fhir/fhir-types";
            case SUPPLYREQUEST: return "http://hl7.org/fhir/fhir-types";
            case TASK: return "http://hl7.org/fhir/fhir-types";
            case TERMINOLOGYCAPABILITIES: return "http://hl7.org/fhir/fhir-types";
            case TESTREPORT: return "http://hl7.org/fhir/fhir-types";
            case TESTSCRIPT: return "http://hl7.org/fhir/fhir-types";
            case TRANSPORT: return "http://hl7.org/fhir/fhir-types";
            case VALUESET: return "http://hl7.org/fhir/fhir-types";
            case VERIFICATIONRESULT: return "http://hl7.org/fhir/fhir-types";
            case VISIONPRESCRIPTION: return "http://hl7.org/fhir/fhir-types";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACCOUNT: return "A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.";
            case ACTIVITYDEFINITION: return "This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.";
            case ACTORDEFINITION: return "The ActorDefinition resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.";
            case ADMINISTRABLEPRODUCTDEFINITION: return "A medicinal product in the final form which is suitable for administering to a patient (after any mixing of multiple components, dissolution etc. has been performed).";
            case ADVERSEEVENT: return "An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject. The unintended effects may require additional monitoring, treatment, hospitalization, or may result in death. The AdverseEvent resource also extends to potential or avoided events that could have had such effects. There are two major domains where the AdverseEvent resource is expected to be used. One is in clinical care reported adverse events and the other is in reporting adverse events in clinical  research trial management. Given the differences between these two arenas, we recommend consulting the domain specific implementation guides when implementing the AdverseEvent Resource. The implementation guides include specific extensions, value sets and constraints.";
            case ALLERGYINTOLERANCE: return "Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.";
            case APPOINTMENT: return "A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).";
            case APPOINTMENTRESPONSE: return "A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.";
            case ARTIFACTASSESSMENT: return "This Resource provides one or more comments, classifiers or ratings about a Resource and supports attribution and rights management metadata for the added content.";
            case AUDITEVENT: return "A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.";
            case BASIC: return "Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.";
            case BINARY: return "A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.";
            case BIOLOGICALLYDERIVEDPRODUCT: return "A biological material originating from a biological entity intended to be transplanted or infused into another (possibly the same) biological entity.";
            case BODYSTRUCTURE: return "Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.";
            case BUNDLE: return "A container for a collection of resources.";
            case CAPABILITYSTATEMENT: return "A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server or Client for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case CAREPLAN: return "Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.";
            case CARETEAM: return "The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.";
            case CHARGEITEM: return "The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.";
            case CHARGEITEMDEFINITION: return "The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.";
            case CITATION: return "The Citation Resource enables reference to any knowledge artifact for purposes of identification and attribution. The Citation Resource supports existing reference structures and developing publication practices such as versioning, expressing complex contributorship roles, and referencing computable resources.";
            case CLAIM: return "A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.";
            case CLAIMRESPONSE: return "This resource provides the adjudication details from the processing of a Claim resource.";
            case CLINICALIMPRESSION: return "A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called \"ClinicalImpression\" rather than \"ClinicalAssessment\" to avoid confusion with the recording of assessment tools such as Apgar score.";
            case CLINICALUSEDEFINITION: return "A single issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.";
            case CODESYSTEM: return "The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.";
            case COMMUNICATION: return "A clinical or business level record of information being transmitted or shared; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.";
            case COMMUNICATIONREQUEST: return "A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.";
            case COMPARTMENTDEFINITION: return "A compartment definition that defines how resources are accessed on a server.";
            case COMPOSITION: return "A set of healthcare-related information that is assembled together into a single logical package that provides a single coherent statement of meaning, establishes its own context and that has clinical attestation with regard to who is making the statement. A Composition defines the structure and narrative content necessary for a document. However, a Composition alone does not constitute a document. Rather, the Composition must be the first entry in a Bundle where Bundle.type=document, and any other resources referenced from Composition must be included as subsequent entries in the Bundle (for example Patient, Practitioner, Encounter, etc.).";
            case CONCEPTMAP: return "A statement of relationships from one set of concepts to one or more other concepts - either concepts in code systems, or data element/data element concepts, or classes in class models.";
            case CONDITION: return "A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a level of concern.";
            case CONDITIONDEFINITION: return "A definition of a condition and information relevant to managing it.";
            case CONSENT: return "A record of a healthcare consumer’s  choices  or choices made on their behalf by a third party, which permits or denies identified recipient(s) or recipient role(s) to perform one or more actions within a given policy context, for specific purposes and periods of time.";
            case CONTRACT: return "Legally enforceable, formally recorded unilateral or bilateral directive i.e., a policy or agreement.";
            case COVERAGE: return "Financial instrument which may be used to reimburse or pay for health care products and services. Includes both insurance and self-payment.";
            case COVERAGEELIGIBILITYREQUEST: return "The CoverageEligibilityRequest provides patient and insurance coverage information to an insurer for them to respond, in the form of an CoverageEligibilityResponse, with information regarding whether the stated coverage is valid and in-force and optionally to provide the insurance details of the policy.";
            case COVERAGEELIGIBILITYRESPONSE: return "This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.";
            case DETECTEDISSUE: return "Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. Drug-drug interaction, Ineffective treatment frequency, Procedure-condition conflict, etc.";
            case DEVICE: return "This resource describes the properties (regulated, has real time clock, etc.), adminstrative (manufacturer name, model number, serial number, firmware, etc), and type (knee replacement, blood pressure cuff, MRI, etc.) of a physical unit (these values do not change much within a given module, for example the serail number, manufacturer name, and model number). An actual unit may consist of several modules in a distinct hierarchy and these are represented by multiple Device resources and bound through the 'parent' element.";
            case DEVICEDEFINITION: return "This is a specialized resource that defines the characteristics and capabilities of a device.";
            case DEVICEDISPENSE: return "Indicates that a device is to be or has been dispensed for a named person/patient.  This includes a description of the product (supply) provided and the instructions for using the device.";
            case DEVICEMETRIC: return "Describes a measurement, calculation or setting capability of a medical device.";
            case DEVICEREQUEST: return "Represents a request a device to be provided to a specific patient. The device may be an implantable device to be subsequently implanted, or an external assistive device, such as a walker, to be delivered and subsequently be used.";
            case DEVICEUSAGE: return "A record of a device being used by a patient where the record is the result of a report from the patient or a clinician.";
            case DIAGNOSTICREPORT: return "The findings and interpretation of diagnostic tests performed on patients, groups of patients, products, substances, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports. The report also includes non-clinical context such as batch analysis and stability reporting of products and substances.";
            case DOCUMENTMANIFEST: return "A collection of documents compiled for a purpose together with metadata that applies to the collection.";
            case DOCUMENTREFERENCE: return "A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this \"document\" encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.";
            case ENCOUNTER: return "An interaction between healthcare provider(s), and/or patient(s) for the purpose of providing healthcare service(s) or assessing the health status of patient(s).";
            case ENDPOINT: return "The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b, a REST endpoint for another FHIR server, or a s/Mime email address. This may include any security context information.";
            case ENROLLMENTREQUEST: return "This resource provides the insurance enrollment details to the insurer regarding a specified coverage.";
            case ENROLLMENTRESPONSE: return "This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.";
            case EPISODEOFCARE: return "An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.";
            case EVENTDEFINITION: return "The EventDefinition resource provides a reusable description of when a particular event can occur.";
            case EVIDENCE: return "The Evidence Resource provides a machine-interpretable expression of an evidence concept including the evidence variables (e.g., population, exposures/interventions, comparators, outcomes, measured variables, confounding variables), the statistics, and the certainty of this evidence.";
            case EVIDENCEREPORT: return "The EvidenceReport Resource is a specialized container for a collection of resources and codeable concepts, adapted to support compositions of Evidence, EvidenceVariable, and Citation resources and related concepts.";
            case EVIDENCEVARIABLE: return "The EvidenceVariable resource describes an element that knowledge (Evidence) is about.";
            case EXAMPLESCENARIO: return "A walkthrough of a workflow showing the interaction between systems and the instances shared, possibly including the evolution of instances over time.";
            case EXPLANATIONOFBENEFIT: return "This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.";
            case FAMILYMEMBERHISTORY: return "Significant health conditions for a person related to the patient relevant in the context of care for the patient.";
            case FLAG: return "Prospective warnings of potential issues when providing care to the patient.";
            case FORMULARYITEM: return "This resource describes a product or service that is available through a program and includes the conditions and constraints of availability.  All of the information in this resource is specific to the inclusion of the item in the formulary and is not inherent to the item itself.";
            case GENOMICSTUDY: return "A Genomic Study is a set of analysis performed to analyze and generate genomic data.";
            case GOAL: return "Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.";
            case GRAPHDEFINITION: return "A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.";
            case GROUP: return "Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.";
            case GUIDANCERESPONSE: return "A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.";
            case HEALTHCARESERVICE: return "The details of a healthcare service available at a location or in a catalog.  In the case where there is a hierarchy of services (for example, Lab -> Pathology -> Wound Cultures), this can be represented using a set of linked HealthcareServices.";
            case IMAGINGSELECTION: return "A selection of DICOM SOP instances and/or frames within a single Study and Series. This might include additional specifics such as an image region, an Observation UID or a Segmentation Number, allowing linkage to an Observation Resource or transferring this information along with the ImagingStudy Resource.";
            case IMAGINGSTUDY: return "Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.";
            case IMMUNIZATION: return "Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.";
            case IMMUNIZATIONEVALUATION: return "Describes a comparison of an immunization event against published recommendations to determine if the administration is \"valid\" in relation to those  recommendations.";
            case IMMUNIZATIONRECOMMENDATION: return "A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.";
            case IMPLEMENTATIONGUIDE: return "A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.";
            case INGREDIENT: return "An ingredient of a manufactured item or pharmaceutical product.";
            case INSURANCEPLAN: return "Details of a Health Insurance product/plan provided by an organization.";
            case INVENTORYREPORT: return "A report of inventory or stock items.";
            case INVOICE: return "Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.";
            case LIBRARY: return "The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.";
            case LINKAGE: return "Identifies two or more records (resource instances) that refer to the same real-world \"occurrence\".";
            case LIST: return "A List is a curated collection of resources, for things such as problem lists, allergy lists, facility list, organization list, etc.";
            case LOCATION: return "Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.";
            case MANUFACTUREDITEMDEFINITION: return "The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.";
            case MEASURE: return "The Measure resource provides the definition of a quality measure.";
            case MEASUREREPORT: return "The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.";
            case MEDICATION: return "This resource is primarily used for the identification and definition of a medication, including ingredients, for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.";
            case MEDICATIONADMINISTRATION: return "Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.";
            case MEDICATIONDISPENSE: return "Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.";
            case MEDICATIONKNOWLEDGE: return "Information about a medication that is used to support knowledge.";
            case MEDICATIONREQUEST: return "An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called \"MedicationRequest\" rather than \"MedicationPrescription\" or \"MedicationOrder\" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.";
            case MEDICATIONUSAGE: return "A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. \n\nThe primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.";
            case MEDICINALPRODUCTDEFINITION: return "Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use, drug catalogs, to support prescribing, adverse events management etc.).";
            case MESSAGEDEFINITION: return "Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.";
            case MESSAGEHEADER: return "The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.";
            case MOLECULARSEQUENCE: return "Representation of a molecular sequence.";
            case NAMINGSYSTEM: return "A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a \"System\" used within the Identifier and Coding data types.";
            case NUTRITIONINTAKE: return "A record of food or fluid that is being consumed by a patient.  A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.";
            case NUTRITIONORDER: return "A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.";
            case NUTRITIONPRODUCT: return "A food or supplement that is consumed by patients.";
            case OBSERVATION: return "Measurements and simple assertions made about a patient, device or other subject.";
            case OBSERVATIONDEFINITION: return "Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.";
            case OPERATIONDEFINITION: return "A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).";
            case OPERATIONOUTCOME: return "A collection of error, warning, or information messages that result from a system action.";
            case ORGANIZATION: return "A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.";
            case ORGANIZATIONAFFILIATION: return "Defines an affiliation/assotiation/relationship between 2 distinct organizations, that is not a part-of relationship/sub-division relationship.";
            case PACKAGEDPRODUCTDEFINITION: return "A medically related item or items, in a container or package.";
            case PARAMETERS: return "This resource is used to pass information into and back from an operation (whether invoked directly from REST or within a messaging environment).  It is not persisted or allowed to be referenced by other resources except as described in the definition of the Parameters resource.";
            case PATIENT: return "Demographics and other administrative information about an individual or animal receiving care or other health-related services.";
            case PAYMENTNOTICE: return "This resource provides the status of the payment for goods and services rendered, and the request and response resource references.";
            case PAYMENTRECONCILIATION: return "This resource provides the details including amount of a payment and allocates the payment items being paid.";
            case PERMISSION: return "Permission resource holds access rules for a given data and context.";
            case PERSON: return "Demographics and administrative information about a person independent of a specific health-related context.";
            case PLANDEFINITION: return "This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical and non-clinical artifacts such as clinical decision support rules, order sets, protocols, and drug quality specifications.";
            case PRACTITIONER: return "A person who is directly or indirectly involved in the provisioning of healthcare or related services.";
            case PRACTITIONERROLE: return "A specific set of Roles/Locations/specialties/services that a practitioner may perform, or has performed at an organization during a period of time.";
            case PROCEDURE: return "An action that is or was performed on or for a patient, practitioner, device, organization, or location. For example, this can be a physical intervention on a patient like an operation, or less invasive like long term services, counseling, or hypnotherapy.  This can be a quality or safety inspection for a location, organization, or device.  This can be an accreditation procedure on a practitioner for licensing.";
            case PROVENANCE: return "Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.";
            case QUESTIONNAIRE: return "A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.";
            case QUESTIONNAIRERESPONSE: return "A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.";
            case REGULATEDAUTHORIZATION: return "Regulatory approval, clearance or licencing related to a regulated product, treatment, facility or activity that is cited in a guidance, regulation, rule or legislative act. An example is Market Authorization relating to a Medicinal Product.";
            case RELATEDPERSON: return "Information about a person that is involved in a patient's health or the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.";
            case REQUESTORCHESTRATION: return "A set of related requests that can be used to capture intended activities that have inter-dependencies such as \"give this medication after that one\".";
            case REQUIREMENTS: return "The Requirements resource is used to describe an actor - a human or an application that plays a role in data exchange, and that may have obligations associated with the role the actor plays.";
            case RESEARCHSTUDY: return "A scientific study of nature that sometimes includes processes involved in health and disease. For example, clinical trials are research studies that involve people. These studies may be related to new ways to screen, prevent, diagnose, and treat disease. They may also study certain outcomes and certain groups of people by looking at data collected in the past or future.";
            case RESEARCHSUBJECT: return "A physical entity which is the primary unit of operational and/or administrative interest in a study.";
            case RISKASSESSMENT: return "An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.";
            case SCHEDULE: return "A container for slots of time that may be available for booking appointments.";
            case SEARCHPARAMETER: return "A search parameter that defines a named search item that can be used to search/filter on a resource.";
            case SERVICEREQUEST: return "A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.";
            case SLOT: return "A slot of time on a schedule that may be available for booking appointments.";
            case SPECIMEN: return "A sample to be used for analysis.";
            case SPECIMENDEFINITION: return "A kind of specimen with associated set of requirements.";
            case STRUCTUREDEFINITION: return "A definition of a FHIR structure. This resource is used to describe the underlying resources, data types defined in FHIR, and also for describing extensions and constraints on resources and data types.";
            case STRUCTUREMAP: return "A Map of relationships between 2 structures that can be used to transform data.";
            case SUBSCRIPTION: return "The subscription resource describes a particular client's request to be notified about a SubscriptionTopic.";
            case SUBSCRIPTIONSTATUS: return "The SubscriptionStatus resource describes the state of a Subscription during notifications. It is not persisted.";
            case SUBSCRIPTIONTOPIC: return "Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.";
            case SUBSTANCE: return "A homogeneous material with a definite composition.";
            case SUBSTANCEDEFINITION: return "The detailed description of a substance, typically at a level beyond what is used for prescribing.";
            case SUBSTANCENUCLEICACID: return "Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.";
            case SUBSTANCEPOLYMER: return "Properties of a substance specific to it being a polymer.";
            case SUBSTANCEPROTEIN: return "A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.";
            case SUBSTANCEREFERENCEINFORMATION: return "Todo.";
            case SUBSTANCESOURCEMATERIAL: return "Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.";
            case SUPPLYDELIVERY: return "Record of delivery of what is supplied.";
            case SUPPLYREQUEST: return "A record of a non-patient specific request for a medication, substance, device, certain types of biologically derived product, and nutrition product used in the healthcare setting.";
            case TASK: return "A task to be performed.";
            case TERMINOLOGYCAPABILITIES: return "A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case TESTREPORT: return "A summary of information based on the results of executing a TestScript.";
            case TESTSCRIPT: return "A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.";
            case TRANSPORT: return "Record of transport.";
            case VALUESET: return "A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).";
            case VERIFICATIONRESULT: return "Describes validation requirements, source(s), status and dates for one or more elements.";
            case VISIONPRESCRIPTION: return "An authorization for the provision of glasses and/or contact lenses to a patient.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ACTORDEFINITION: return "ActorDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case ARTIFACTASSESSMENT: return "ArtifactAssessment";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CITATION: return "Citation";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEDEFINITION: return "ClinicalUseDefinition";
            case CODESYSTEM: return "CodeSystem";
            case COMMUNICATION: return "Communication";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case COMPARTMENTDEFINITION: return "CompartmentDefinition";
            case COMPOSITION: return "Composition";
            case CONCEPTMAP: return "ConceptMap";
            case CONDITION: return "Condition";
            case CONDITIONDEFINITION: return "ConditionDefinition";
            case CONSENT: return "Consent";
            case CONTRACT: return "Contract";
            case COVERAGE: return "Coverage";
            case COVERAGEELIGIBILITYREQUEST: return "CoverageEligibilityRequest";
            case COVERAGEELIGIBILITYRESPONSE: return "CoverageEligibilityResponse";
            case DETECTEDISSUE: return "DetectedIssue";
            case DEVICE: return "Device";
            case DEVICEDEFINITION: return "DeviceDefinition";
            case DEVICEDISPENSE: return "DeviceDispense";
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSAGE: return "DeviceUsage";
            case DIAGNOSTICREPORT: return "DiagnosticReport";
            case DOCUMENTMANIFEST: return "DocumentManifest";
            case DOCUMENTREFERENCE: return "DocumentReference";
            case ENCOUNTER: return "Encounter";
            case ENDPOINT: return "Endpoint";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case ENROLLMENTRESPONSE: return "EnrollmentResponse";
            case EPISODEOFCARE: return "EpisodeOfCare";
            case EVENTDEFINITION: return "EventDefinition";
            case EVIDENCE: return "Evidence";
            case EVIDENCEREPORT: return "EvidenceReport";
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case FORMULARYITEM: return "FormularyItem";
            case GENOMICSTUDY: return "GenomicStudy";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSELECTION: return "ImagingSelection";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
            case INVENTORYREPORT: return "InventoryReport";
            case INVOICE: return "Invoice";
            case LIBRARY: return "Library";
            case LINKAGE: return "Linkage";
            case LIST: return "List";
            case LOCATION: return "Location";
            case MANUFACTUREDITEMDEFINITION: return "ManufacturedItemDefinition";
            case MEASURE: return "Measure";
            case MEASUREREPORT: return "MeasureReport";
            case MEDICATION: return "Medication";
            case MEDICATIONADMINISTRATION: return "MedicationAdministration";
            case MEDICATIONDISPENSE: return "MedicationDispense";
            case MEDICATIONKNOWLEDGE: return "MedicationKnowledge";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case MEDICATIONUSAGE: return "MedicationUsage";
            case MEDICINALPRODUCTDEFINITION: return "MedicinalProductDefinition";
            case MESSAGEDEFINITION: return "MessageDefinition";
            case MESSAGEHEADER: return "MessageHeader";
            case MOLECULARSEQUENCE: return "MolecularSequence";
            case NAMINGSYSTEM: return "NamingSystem";
            case NUTRITIONINTAKE: return "NutritionIntake";
            case NUTRITIONORDER: return "NutritionOrder";
            case NUTRITIONPRODUCT: return "NutritionProduct";
            case OBSERVATION: return "Observation";
            case OBSERVATIONDEFINITION: return "ObservationDefinition";
            case OPERATIONDEFINITION: return "OperationDefinition";
            case OPERATIONOUTCOME: return "OperationOutcome";
            case ORGANIZATION: return "Organization";
            case ORGANIZATIONAFFILIATION: return "OrganizationAffiliation";
            case PACKAGEDPRODUCTDEFINITION: return "PackagedProductDefinition";
            case PARAMETERS: return "Parameters";
            case PATIENT: return "Patient";
            case PAYMENTNOTICE: return "PaymentNotice";
            case PAYMENTRECONCILIATION: return "PaymentReconciliation";
            case PERMISSION: return "Permission";
            case PERSON: return "Person";
            case PLANDEFINITION: return "PlanDefinition";
            case PRACTITIONER: return "Practitioner";
            case PRACTITIONERROLE: return "PractitionerRole";
            case PROCEDURE: return "Procedure";
            case PROVENANCE: return "Provenance";
            case QUESTIONNAIRE: return "Questionnaire";
            case QUESTIONNAIRERESPONSE: return "QuestionnaireResponse";
            case REGULATEDAUTHORIZATION: return "RegulatedAuthorization";
            case RELATEDPERSON: return "RelatedPerson";
            case REQUESTORCHESTRATION: return "RequestOrchestration";
            case REQUIREMENTS: return "Requirements";
            case RESEARCHSTUDY: return "ResearchStudy";
            case RESEARCHSUBJECT: return "ResearchSubject";
            case RISKASSESSMENT: return "RiskAssessment";
            case SCHEDULE: return "Schedule";
            case SEARCHPARAMETER: return "SearchParameter";
            case SERVICEREQUEST: return "ServiceRequest";
            case SLOT: return "Slot";
            case SPECIMEN: return "Specimen";
            case SPECIMENDEFINITION: return "SpecimenDefinition";
            case STRUCTUREDEFINITION: return "StructureDefinition";
            case STRUCTUREMAP: return "StructureMap";
            case SUBSCRIPTION: return "Subscription";
            case SUBSCRIPTIONSTATUS: return "SubscriptionStatus";
            case SUBSCRIPTIONTOPIC: return "SubscriptionTopic";
            case SUBSTANCE: return "Substance";
            case SUBSTANCEDEFINITION: return "SubstanceDefinition";
            case SUBSTANCENUCLEICACID: return "SubstanceNucleicAcid";
            case SUBSTANCEPOLYMER: return "SubstancePolymer";
            case SUBSTANCEPROTEIN: return "SubstanceProtein";
            case SUBSTANCEREFERENCEINFORMATION: return "SubstanceReferenceInformation";
            case SUBSTANCESOURCEMATERIAL: return "SubstanceSourceMaterial";
            case SUPPLYDELIVERY: return "SupplyDelivery";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case TERMINOLOGYCAPABILITIES: return "TerminologyCapabilities";
            case TESTREPORT: return "TestReport";
            case TESTSCRIPT: return "TestScript";
            case TRANSPORT: return "Transport";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ResourceTypesEnumFactory implements EnumFactory<ResourceTypes> {
    public ResourceTypes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Account".equals(codeString))
          return ResourceTypes.ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return ResourceTypes.ACTIVITYDEFINITION;
        if ("ActorDefinition".equals(codeString))
          return ResourceTypes.ACTORDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return ResourceTypes.ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return ResourceTypes.ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return ResourceTypes.ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return ResourceTypes.APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return ResourceTypes.APPOINTMENTRESPONSE;
        if ("ArtifactAssessment".equals(codeString))
          return ResourceTypes.ARTIFACTASSESSMENT;
        if ("AuditEvent".equals(codeString))
          return ResourceTypes.AUDITEVENT;
        if ("Basic".equals(codeString))
          return ResourceTypes.BASIC;
        if ("Binary".equals(codeString))
          return ResourceTypes.BINARY;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return ResourceTypes.BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return ResourceTypes.BODYSTRUCTURE;
        if ("Bundle".equals(codeString))
          return ResourceTypes.BUNDLE;
        if ("CapabilityStatement".equals(codeString))
          return ResourceTypes.CAPABILITYSTATEMENT;
        if ("CarePlan".equals(codeString))
          return ResourceTypes.CAREPLAN;
        if ("CareTeam".equals(codeString))
          return ResourceTypes.CARETEAM;
        if ("ChargeItem".equals(codeString))
          return ResourceTypes.CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return ResourceTypes.CHARGEITEMDEFINITION;
        if ("Citation".equals(codeString))
          return ResourceTypes.CITATION;
        if ("Claim".equals(codeString))
          return ResourceTypes.CLAIM;
        if ("ClaimResponse".equals(codeString))
          return ResourceTypes.CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return ResourceTypes.CLINICALIMPRESSION;
        if ("ClinicalUseDefinition".equals(codeString))
          return ResourceTypes.CLINICALUSEDEFINITION;
        if ("CodeSystem".equals(codeString))
          return ResourceTypes.CODESYSTEM;
        if ("Communication".equals(codeString))
          return ResourceTypes.COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return ResourceTypes.COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return ResourceTypes.COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return ResourceTypes.COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return ResourceTypes.CONCEPTMAP;
        if ("Condition".equals(codeString))
          return ResourceTypes.CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return ResourceTypes.CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return ResourceTypes.CONSENT;
        if ("Contract".equals(codeString))
          return ResourceTypes.CONTRACT;
        if ("Coverage".equals(codeString))
          return ResourceTypes.COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return ResourceTypes.COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return ResourceTypes.COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return ResourceTypes.DETECTEDISSUE;
        if ("Device".equals(codeString))
          return ResourceTypes.DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return ResourceTypes.DEVICEDEFINITION;
        if ("DeviceDispense".equals(codeString))
          return ResourceTypes.DEVICEDISPENSE;
        if ("DeviceMetric".equals(codeString))
          return ResourceTypes.DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return ResourceTypes.DEVICEREQUEST;
        if ("DeviceUsage".equals(codeString))
          return ResourceTypes.DEVICEUSAGE;
        if ("DiagnosticReport".equals(codeString))
          return ResourceTypes.DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return ResourceTypes.DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return ResourceTypes.DOCUMENTREFERENCE;
        if ("Encounter".equals(codeString))
          return ResourceTypes.ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return ResourceTypes.ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return ResourceTypes.ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return ResourceTypes.ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return ResourceTypes.EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return ResourceTypes.EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return ResourceTypes.EVIDENCE;
        if ("EvidenceReport".equals(codeString))
          return ResourceTypes.EVIDENCEREPORT;
        if ("EvidenceVariable".equals(codeString))
          return ResourceTypes.EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return ResourceTypes.EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return ResourceTypes.EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return ResourceTypes.FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return ResourceTypes.FLAG;
        if ("FormularyItem".equals(codeString))
          return ResourceTypes.FORMULARYITEM;
        if ("GenomicStudy".equals(codeString))
          return ResourceTypes.GENOMICSTUDY;
        if ("Goal".equals(codeString))
          return ResourceTypes.GOAL;
        if ("GraphDefinition".equals(codeString))
          return ResourceTypes.GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return ResourceTypes.GROUP;
        if ("GuidanceResponse".equals(codeString))
          return ResourceTypes.GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return ResourceTypes.HEALTHCARESERVICE;
        if ("ImagingSelection".equals(codeString))
          return ResourceTypes.IMAGINGSELECTION;
        if ("ImagingStudy".equals(codeString))
          return ResourceTypes.IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return ResourceTypes.IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return ResourceTypes.IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return ResourceTypes.IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return ResourceTypes.IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return ResourceTypes.INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return ResourceTypes.INSURANCEPLAN;
        if ("InventoryReport".equals(codeString))
          return ResourceTypes.INVENTORYREPORT;
        if ("Invoice".equals(codeString))
          return ResourceTypes.INVOICE;
        if ("Library".equals(codeString))
          return ResourceTypes.LIBRARY;
        if ("Linkage".equals(codeString))
          return ResourceTypes.LINKAGE;
        if ("List".equals(codeString))
          return ResourceTypes.LIST;
        if ("Location".equals(codeString))
          return ResourceTypes.LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return ResourceTypes.MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return ResourceTypes.MEASURE;
        if ("MeasureReport".equals(codeString))
          return ResourceTypes.MEASUREREPORT;
        if ("Medication".equals(codeString))
          return ResourceTypes.MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return ResourceTypes.MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return ResourceTypes.MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return ResourceTypes.MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return ResourceTypes.MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return ResourceTypes.MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return ResourceTypes.MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return ResourceTypes.MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return ResourceTypes.MESSAGEHEADER;
        if ("MolecularSequence".equals(codeString))
          return ResourceTypes.MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return ResourceTypes.NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return ResourceTypes.NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return ResourceTypes.NUTRITIONORDER;
        if ("NutritionProduct".equals(codeString))
          return ResourceTypes.NUTRITIONPRODUCT;
        if ("Observation".equals(codeString))
          return ResourceTypes.OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return ResourceTypes.OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return ResourceTypes.OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return ResourceTypes.OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return ResourceTypes.ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return ResourceTypes.ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return ResourceTypes.PACKAGEDPRODUCTDEFINITION;
        if ("Parameters".equals(codeString))
          return ResourceTypes.PARAMETERS;
        if ("Patient".equals(codeString))
          return ResourceTypes.PATIENT;
        if ("PaymentNotice".equals(codeString))
          return ResourceTypes.PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return ResourceTypes.PAYMENTRECONCILIATION;
        if ("Permission".equals(codeString))
          return ResourceTypes.PERMISSION;
        if ("Person".equals(codeString))
          return ResourceTypes.PERSON;
        if ("PlanDefinition".equals(codeString))
          return ResourceTypes.PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return ResourceTypes.PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return ResourceTypes.PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return ResourceTypes.PROCEDURE;
        if ("Provenance".equals(codeString))
          return ResourceTypes.PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return ResourceTypes.QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return ResourceTypes.QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return ResourceTypes.REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return ResourceTypes.RELATEDPERSON;
        if ("RequestOrchestration".equals(codeString))
          return ResourceTypes.REQUESTORCHESTRATION;
        if ("Requirements".equals(codeString))
          return ResourceTypes.REQUIREMENTS;
        if ("ResearchStudy".equals(codeString))
          return ResourceTypes.RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return ResourceTypes.RESEARCHSUBJECT;
        if ("RiskAssessment".equals(codeString))
          return ResourceTypes.RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return ResourceTypes.SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return ResourceTypes.SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return ResourceTypes.SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return ResourceTypes.SLOT;
        if ("Specimen".equals(codeString))
          return ResourceTypes.SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return ResourceTypes.SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return ResourceTypes.STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return ResourceTypes.STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return ResourceTypes.SUBSCRIPTION;
        if ("SubscriptionStatus".equals(codeString))
          return ResourceTypes.SUBSCRIPTIONSTATUS;
        if ("SubscriptionTopic".equals(codeString))
          return ResourceTypes.SUBSCRIPTIONTOPIC;
        if ("Substance".equals(codeString))
          return ResourceTypes.SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return ResourceTypes.SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return ResourceTypes.SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return ResourceTypes.SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return ResourceTypes.SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return ResourceTypes.SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return ResourceTypes.SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return ResourceTypes.SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return ResourceTypes.SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return ResourceTypes.TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return ResourceTypes.TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return ResourceTypes.TESTREPORT;
        if ("TestScript".equals(codeString))
          return ResourceTypes.TESTSCRIPT;
        if ("Transport".equals(codeString))
          return ResourceTypes.TRANSPORT;
        if ("ValueSet".equals(codeString))
          return ResourceTypes.VALUESET;
        if ("VerificationResult".equals(codeString))
          return ResourceTypes.VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return ResourceTypes.VISIONPRESCRIPTION;
        throw new IllegalArgumentException("Unknown ResourceTypes code '"+codeString+"'");
        }
        public Enumeration<ResourceTypes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ResourceTypes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("Account".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ACCOUNT);
        if ("ActivityDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ACTIVITYDEFINITION);
        if ("ActorDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ACTORDEFINITION);
        if ("AdministrableProductDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ADMINISTRABLEPRODUCTDEFINITION);
        if ("AdverseEvent".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ADVERSEEVENT);
        if ("AllergyIntolerance".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ALLERGYINTOLERANCE);
        if ("Appointment".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.APPOINTMENT);
        if ("AppointmentResponse".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.APPOINTMENTRESPONSE);
        if ("ArtifactAssessment".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ARTIFACTASSESSMENT);
        if ("AuditEvent".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.AUDITEVENT);
        if ("Basic".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.BASIC);
        if ("Binary".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.BINARY);
        if ("BiologicallyDerivedProduct".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.BIOLOGICALLYDERIVEDPRODUCT);
        if ("BodyStructure".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.BODYSTRUCTURE);
        if ("Bundle".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.BUNDLE);
        if ("CapabilityStatement".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CAPABILITYSTATEMENT);
        if ("CarePlan".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CAREPLAN);
        if ("CareTeam".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CARETEAM);
        if ("ChargeItem".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CHARGEITEM);
        if ("ChargeItemDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CHARGEITEMDEFINITION);
        if ("Citation".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CITATION);
        if ("Claim".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CLAIM);
        if ("ClaimResponse".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CLAIMRESPONSE);
        if ("ClinicalImpression".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CLINICALIMPRESSION);
        if ("ClinicalUseDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CLINICALUSEDEFINITION);
        if ("CodeSystem".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CODESYSTEM);
        if ("Communication".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.COMMUNICATION);
        if ("CommunicationRequest".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.COMMUNICATIONREQUEST);
        if ("CompartmentDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.COMPARTMENTDEFINITION);
        if ("Composition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.COMPOSITION);
        if ("ConceptMap".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CONCEPTMAP);
        if ("Condition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CONDITION);
        if ("ConditionDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CONDITIONDEFINITION);
        if ("Consent".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CONSENT);
        if ("Contract".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.CONTRACT);
        if ("Coverage".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.COVERAGE);
        if ("CoverageEligibilityRequest".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.COVERAGEELIGIBILITYREQUEST);
        if ("CoverageEligibilityResponse".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.COVERAGEELIGIBILITYRESPONSE);
        if ("DetectedIssue".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.DETECTEDISSUE);
        if ("Device".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.DEVICE);
        if ("DeviceDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.DEVICEDEFINITION);
        if ("DeviceDispense".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.DEVICEDISPENSE);
        if ("DeviceMetric".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.DEVICEMETRIC);
        if ("DeviceRequest".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.DEVICEREQUEST);
        if ("DeviceUsage".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.DEVICEUSAGE);
        if ("DiagnosticReport".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.DIAGNOSTICREPORT);
        if ("DocumentManifest".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.DOCUMENTMANIFEST);
        if ("DocumentReference".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.DOCUMENTREFERENCE);
        if ("Encounter".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ENCOUNTER);
        if ("Endpoint".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ENDPOINT);
        if ("EnrollmentRequest".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ENROLLMENTREQUEST);
        if ("EnrollmentResponse".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ENROLLMENTRESPONSE);
        if ("EpisodeOfCare".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.EPISODEOFCARE);
        if ("EventDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.EVENTDEFINITION);
        if ("Evidence".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.EVIDENCE);
        if ("EvidenceReport".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.EVIDENCEREPORT);
        if ("EvidenceVariable".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.EVIDENCEVARIABLE);
        if ("ExampleScenario".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.EXAMPLESCENARIO);
        if ("ExplanationOfBenefit".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.EXPLANATIONOFBENEFIT);
        if ("FamilyMemberHistory".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.FAMILYMEMBERHISTORY);
        if ("Flag".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.FLAG);
        if ("FormularyItem".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.FORMULARYITEM);
        if ("GenomicStudy".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.GENOMICSTUDY);
        if ("Goal".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.GOAL);
        if ("GraphDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.GRAPHDEFINITION);
        if ("Group".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.GROUP);
        if ("GuidanceResponse".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.GUIDANCERESPONSE);
        if ("HealthcareService".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.HEALTHCARESERVICE);
        if ("ImagingSelection".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.IMAGINGSELECTION);
        if ("ImagingStudy".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.IMAGINGSTUDY);
        if ("Immunization".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.IMMUNIZATION);
        if ("ImmunizationEvaluation".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.IMMUNIZATIONEVALUATION);
        if ("ImmunizationRecommendation".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.IMMUNIZATIONRECOMMENDATION);
        if ("ImplementationGuide".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.IMPLEMENTATIONGUIDE);
        if ("Ingredient".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.INGREDIENT);
        if ("InsurancePlan".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.INSURANCEPLAN);
        if ("InventoryReport".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.INVENTORYREPORT);
        if ("Invoice".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.INVOICE);
        if ("Library".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.LIBRARY);
        if ("Linkage".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.LINKAGE);
        if ("List".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.LIST);
        if ("Location".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.LOCATION);
        if ("ManufacturedItemDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MANUFACTUREDITEMDEFINITION);
        if ("Measure".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MEASURE);
        if ("MeasureReport".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MEASUREREPORT);
        if ("Medication".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MEDICATION);
        if ("MedicationAdministration".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MEDICATIONADMINISTRATION);
        if ("MedicationDispense".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MEDICATIONDISPENSE);
        if ("MedicationKnowledge".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MEDICATIONKNOWLEDGE);
        if ("MedicationRequest".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MEDICATIONREQUEST);
        if ("MedicationUsage".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MEDICATIONUSAGE);
        if ("MedicinalProductDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MEDICINALPRODUCTDEFINITION);
        if ("MessageDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MESSAGEDEFINITION);
        if ("MessageHeader".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MESSAGEHEADER);
        if ("MolecularSequence".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.MOLECULARSEQUENCE);
        if ("NamingSystem".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.NAMINGSYSTEM);
        if ("NutritionIntake".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.NUTRITIONINTAKE);
        if ("NutritionOrder".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.NUTRITIONORDER);
        if ("NutritionProduct".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.NUTRITIONPRODUCT);
        if ("Observation".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.OBSERVATION);
        if ("ObservationDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.OBSERVATIONDEFINITION);
        if ("OperationDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.OPERATIONDEFINITION);
        if ("OperationOutcome".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.OPERATIONOUTCOME);
        if ("Organization".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ORGANIZATION);
        if ("OrganizationAffiliation".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.ORGANIZATIONAFFILIATION);
        if ("PackagedProductDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PACKAGEDPRODUCTDEFINITION);
        if ("Parameters".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PARAMETERS);
        if ("Patient".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PATIENT);
        if ("PaymentNotice".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PAYMENTNOTICE);
        if ("PaymentReconciliation".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PAYMENTRECONCILIATION);
        if ("Permission".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PERMISSION);
        if ("Person".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PERSON);
        if ("PlanDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PLANDEFINITION);
        if ("Practitioner".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PRACTITIONER);
        if ("PractitionerRole".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PRACTITIONERROLE);
        if ("Procedure".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PROCEDURE);
        if ("Provenance".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.PROVENANCE);
        if ("Questionnaire".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.QUESTIONNAIRE);
        if ("QuestionnaireResponse".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.QUESTIONNAIRERESPONSE);
        if ("RegulatedAuthorization".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.REGULATEDAUTHORIZATION);
        if ("RelatedPerson".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.RELATEDPERSON);
        if ("RequestOrchestration".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.REQUESTORCHESTRATION);
        if ("Requirements".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.REQUIREMENTS);
        if ("ResearchStudy".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.RESEARCHSTUDY);
        if ("ResearchSubject".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.RESEARCHSUBJECT);
        if ("RiskAssessment".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.RISKASSESSMENT);
        if ("Schedule".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SCHEDULE);
        if ("SearchParameter".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SEARCHPARAMETER);
        if ("ServiceRequest".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SERVICEREQUEST);
        if ("Slot".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SLOT);
        if ("Specimen".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SPECIMEN);
        if ("SpecimenDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SPECIMENDEFINITION);
        if ("StructureDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.STRUCTUREDEFINITION);
        if ("StructureMap".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.STRUCTUREMAP);
        if ("Subscription".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUBSCRIPTION);
        if ("SubscriptionStatus".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUBSCRIPTIONSTATUS);
        if ("SubscriptionTopic".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUBSCRIPTIONTOPIC);
        if ("Substance".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUBSTANCE);
        if ("SubstanceDefinition".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUBSTANCEDEFINITION);
        if ("SubstanceNucleicAcid".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUBSTANCENUCLEICACID);
        if ("SubstancePolymer".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUBSTANCEPOLYMER);
        if ("SubstanceProtein".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUBSTANCEPROTEIN);
        if ("SubstanceReferenceInformation".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUBSTANCEREFERENCEINFORMATION);
        if ("SubstanceSourceMaterial".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUBSTANCESOURCEMATERIAL);
        if ("SupplyDelivery".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUPPLYDELIVERY);
        if ("SupplyRequest".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.SUPPLYREQUEST);
        if ("Task".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.TASK);
        if ("TerminologyCapabilities".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.TERMINOLOGYCAPABILITIES);
        if ("TestReport".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.TESTREPORT);
        if ("TestScript".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.TESTSCRIPT);
        if ("Transport".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.TRANSPORT);
        if ("ValueSet".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.VALUESET);
        if ("VerificationResult".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.VERIFICATIONRESULT);
        if ("VisionPrescription".equals(codeString))
          return new Enumeration<ResourceTypes>(this, ResourceTypes.VISIONPRESCRIPTION);
        throw new FHIRException("Unknown ResourceTypes code '"+codeString+"'");
        }
    public String toCode(ResourceTypes code) {
      if (code == ResourceTypes.ACCOUNT)
        return "Account";
      if (code == ResourceTypes.ACTIVITYDEFINITION)
        return "ActivityDefinition";
      if (code == ResourceTypes.ACTORDEFINITION)
        return "ActorDefinition";
      if (code == ResourceTypes.ADMINISTRABLEPRODUCTDEFINITION)
        return "AdministrableProductDefinition";
      if (code == ResourceTypes.ADVERSEEVENT)
        return "AdverseEvent";
      if (code == ResourceTypes.ALLERGYINTOLERANCE)
        return "AllergyIntolerance";
      if (code == ResourceTypes.APPOINTMENT)
        return "Appointment";
      if (code == ResourceTypes.APPOINTMENTRESPONSE)
        return "AppointmentResponse";
      if (code == ResourceTypes.ARTIFACTASSESSMENT)
        return "ArtifactAssessment";
      if (code == ResourceTypes.AUDITEVENT)
        return "AuditEvent";
      if (code == ResourceTypes.BASIC)
        return "Basic";
      if (code == ResourceTypes.BINARY)
        return "Binary";
      if (code == ResourceTypes.BIOLOGICALLYDERIVEDPRODUCT)
        return "BiologicallyDerivedProduct";
      if (code == ResourceTypes.BODYSTRUCTURE)
        return "BodyStructure";
      if (code == ResourceTypes.BUNDLE)
        return "Bundle";
      if (code == ResourceTypes.CAPABILITYSTATEMENT)
        return "CapabilityStatement";
      if (code == ResourceTypes.CAREPLAN)
        return "CarePlan";
      if (code == ResourceTypes.CARETEAM)
        return "CareTeam";
      if (code == ResourceTypes.CHARGEITEM)
        return "ChargeItem";
      if (code == ResourceTypes.CHARGEITEMDEFINITION)
        return "ChargeItemDefinition";
      if (code == ResourceTypes.CITATION)
        return "Citation";
      if (code == ResourceTypes.CLAIM)
        return "Claim";
      if (code == ResourceTypes.CLAIMRESPONSE)
        return "ClaimResponse";
      if (code == ResourceTypes.CLINICALIMPRESSION)
        return "ClinicalImpression";
      if (code == ResourceTypes.CLINICALUSEDEFINITION)
        return "ClinicalUseDefinition";
      if (code == ResourceTypes.CODESYSTEM)
        return "CodeSystem";
      if (code == ResourceTypes.COMMUNICATION)
        return "Communication";
      if (code == ResourceTypes.COMMUNICATIONREQUEST)
        return "CommunicationRequest";
      if (code == ResourceTypes.COMPARTMENTDEFINITION)
        return "CompartmentDefinition";
      if (code == ResourceTypes.COMPOSITION)
        return "Composition";
      if (code == ResourceTypes.CONCEPTMAP)
        return "ConceptMap";
      if (code == ResourceTypes.CONDITION)
        return "Condition";
      if (code == ResourceTypes.CONDITIONDEFINITION)
        return "ConditionDefinition";
      if (code == ResourceTypes.CONSENT)
        return "Consent";
      if (code == ResourceTypes.CONTRACT)
        return "Contract";
      if (code == ResourceTypes.COVERAGE)
        return "Coverage";
      if (code == ResourceTypes.COVERAGEELIGIBILITYREQUEST)
        return "CoverageEligibilityRequest";
      if (code == ResourceTypes.COVERAGEELIGIBILITYRESPONSE)
        return "CoverageEligibilityResponse";
      if (code == ResourceTypes.DETECTEDISSUE)
        return "DetectedIssue";
      if (code == ResourceTypes.DEVICE)
        return "Device";
      if (code == ResourceTypes.DEVICEDEFINITION)
        return "DeviceDefinition";
      if (code == ResourceTypes.DEVICEDISPENSE)
        return "DeviceDispense";
      if (code == ResourceTypes.DEVICEMETRIC)
        return "DeviceMetric";
      if (code == ResourceTypes.DEVICEREQUEST)
        return "DeviceRequest";
      if (code == ResourceTypes.DEVICEUSAGE)
        return "DeviceUsage";
      if (code == ResourceTypes.DIAGNOSTICREPORT)
        return "DiagnosticReport";
      if (code == ResourceTypes.DOCUMENTMANIFEST)
        return "DocumentManifest";
      if (code == ResourceTypes.DOCUMENTREFERENCE)
        return "DocumentReference";
      if (code == ResourceTypes.ENCOUNTER)
        return "Encounter";
      if (code == ResourceTypes.ENDPOINT)
        return "Endpoint";
      if (code == ResourceTypes.ENROLLMENTREQUEST)
        return "EnrollmentRequest";
      if (code == ResourceTypes.ENROLLMENTRESPONSE)
        return "EnrollmentResponse";
      if (code == ResourceTypes.EPISODEOFCARE)
        return "EpisodeOfCare";
      if (code == ResourceTypes.EVENTDEFINITION)
        return "EventDefinition";
      if (code == ResourceTypes.EVIDENCE)
        return "Evidence";
      if (code == ResourceTypes.EVIDENCEREPORT)
        return "EvidenceReport";
      if (code == ResourceTypes.EVIDENCEVARIABLE)
        return "EvidenceVariable";
      if (code == ResourceTypes.EXAMPLESCENARIO)
        return "ExampleScenario";
      if (code == ResourceTypes.EXPLANATIONOFBENEFIT)
        return "ExplanationOfBenefit";
      if (code == ResourceTypes.FAMILYMEMBERHISTORY)
        return "FamilyMemberHistory";
      if (code == ResourceTypes.FLAG)
        return "Flag";
      if (code == ResourceTypes.FORMULARYITEM)
        return "FormularyItem";
      if (code == ResourceTypes.GENOMICSTUDY)
        return "GenomicStudy";
      if (code == ResourceTypes.GOAL)
        return "Goal";
      if (code == ResourceTypes.GRAPHDEFINITION)
        return "GraphDefinition";
      if (code == ResourceTypes.GROUP)
        return "Group";
      if (code == ResourceTypes.GUIDANCERESPONSE)
        return "GuidanceResponse";
      if (code == ResourceTypes.HEALTHCARESERVICE)
        return "HealthcareService";
      if (code == ResourceTypes.IMAGINGSELECTION)
        return "ImagingSelection";
      if (code == ResourceTypes.IMAGINGSTUDY)
        return "ImagingStudy";
      if (code == ResourceTypes.IMMUNIZATION)
        return "Immunization";
      if (code == ResourceTypes.IMMUNIZATIONEVALUATION)
        return "ImmunizationEvaluation";
      if (code == ResourceTypes.IMMUNIZATIONRECOMMENDATION)
        return "ImmunizationRecommendation";
      if (code == ResourceTypes.IMPLEMENTATIONGUIDE)
        return "ImplementationGuide";
      if (code == ResourceTypes.INGREDIENT)
        return "Ingredient";
      if (code == ResourceTypes.INSURANCEPLAN)
        return "InsurancePlan";
      if (code == ResourceTypes.INVENTORYREPORT)
        return "InventoryReport";
      if (code == ResourceTypes.INVOICE)
        return "Invoice";
      if (code == ResourceTypes.LIBRARY)
        return "Library";
      if (code == ResourceTypes.LINKAGE)
        return "Linkage";
      if (code == ResourceTypes.LIST)
        return "List";
      if (code == ResourceTypes.LOCATION)
        return "Location";
      if (code == ResourceTypes.MANUFACTUREDITEMDEFINITION)
        return "ManufacturedItemDefinition";
      if (code == ResourceTypes.MEASURE)
        return "Measure";
      if (code == ResourceTypes.MEASUREREPORT)
        return "MeasureReport";
      if (code == ResourceTypes.MEDICATION)
        return "Medication";
      if (code == ResourceTypes.MEDICATIONADMINISTRATION)
        return "MedicationAdministration";
      if (code == ResourceTypes.MEDICATIONDISPENSE)
        return "MedicationDispense";
      if (code == ResourceTypes.MEDICATIONKNOWLEDGE)
        return "MedicationKnowledge";
      if (code == ResourceTypes.MEDICATIONREQUEST)
        return "MedicationRequest";
      if (code == ResourceTypes.MEDICATIONUSAGE)
        return "MedicationUsage";
      if (code == ResourceTypes.MEDICINALPRODUCTDEFINITION)
        return "MedicinalProductDefinition";
      if (code == ResourceTypes.MESSAGEDEFINITION)
        return "MessageDefinition";
      if (code == ResourceTypes.MESSAGEHEADER)
        return "MessageHeader";
      if (code == ResourceTypes.MOLECULARSEQUENCE)
        return "MolecularSequence";
      if (code == ResourceTypes.NAMINGSYSTEM)
        return "NamingSystem";
      if (code == ResourceTypes.NUTRITIONINTAKE)
        return "NutritionIntake";
      if (code == ResourceTypes.NUTRITIONORDER)
        return "NutritionOrder";
      if (code == ResourceTypes.NUTRITIONPRODUCT)
        return "NutritionProduct";
      if (code == ResourceTypes.OBSERVATION)
        return "Observation";
      if (code == ResourceTypes.OBSERVATIONDEFINITION)
        return "ObservationDefinition";
      if (code == ResourceTypes.OPERATIONDEFINITION)
        return "OperationDefinition";
      if (code == ResourceTypes.OPERATIONOUTCOME)
        return "OperationOutcome";
      if (code == ResourceTypes.ORGANIZATION)
        return "Organization";
      if (code == ResourceTypes.ORGANIZATIONAFFILIATION)
        return "OrganizationAffiliation";
      if (code == ResourceTypes.PACKAGEDPRODUCTDEFINITION)
        return "PackagedProductDefinition";
      if (code == ResourceTypes.PARAMETERS)
        return "Parameters";
      if (code == ResourceTypes.PATIENT)
        return "Patient";
      if (code == ResourceTypes.PAYMENTNOTICE)
        return "PaymentNotice";
      if (code == ResourceTypes.PAYMENTRECONCILIATION)
        return "PaymentReconciliation";
      if (code == ResourceTypes.PERMISSION)
        return "Permission";
      if (code == ResourceTypes.PERSON)
        return "Person";
      if (code == ResourceTypes.PLANDEFINITION)
        return "PlanDefinition";
      if (code == ResourceTypes.PRACTITIONER)
        return "Practitioner";
      if (code == ResourceTypes.PRACTITIONERROLE)
        return "PractitionerRole";
      if (code == ResourceTypes.PROCEDURE)
        return "Procedure";
      if (code == ResourceTypes.PROVENANCE)
        return "Provenance";
      if (code == ResourceTypes.QUESTIONNAIRE)
        return "Questionnaire";
      if (code == ResourceTypes.QUESTIONNAIRERESPONSE)
        return "QuestionnaireResponse";
      if (code == ResourceTypes.REGULATEDAUTHORIZATION)
        return "RegulatedAuthorization";
      if (code == ResourceTypes.RELATEDPERSON)
        return "RelatedPerson";
      if (code == ResourceTypes.REQUESTORCHESTRATION)
        return "RequestOrchestration";
      if (code == ResourceTypes.REQUIREMENTS)
        return "Requirements";
      if (code == ResourceTypes.RESEARCHSTUDY)
        return "ResearchStudy";
      if (code == ResourceTypes.RESEARCHSUBJECT)
        return "ResearchSubject";
      if (code == ResourceTypes.RISKASSESSMENT)
        return "RiskAssessment";
      if (code == ResourceTypes.SCHEDULE)
        return "Schedule";
      if (code == ResourceTypes.SEARCHPARAMETER)
        return "SearchParameter";
      if (code == ResourceTypes.SERVICEREQUEST)
        return "ServiceRequest";
      if (code == ResourceTypes.SLOT)
        return "Slot";
      if (code == ResourceTypes.SPECIMEN)
        return "Specimen";
      if (code == ResourceTypes.SPECIMENDEFINITION)
        return "SpecimenDefinition";
      if (code == ResourceTypes.STRUCTUREDEFINITION)
        return "StructureDefinition";
      if (code == ResourceTypes.STRUCTUREMAP)
        return "StructureMap";
      if (code == ResourceTypes.SUBSCRIPTION)
        return "Subscription";
      if (code == ResourceTypes.SUBSCRIPTIONSTATUS)
        return "SubscriptionStatus";
      if (code == ResourceTypes.SUBSCRIPTIONTOPIC)
        return "SubscriptionTopic";
      if (code == ResourceTypes.SUBSTANCE)
        return "Substance";
      if (code == ResourceTypes.SUBSTANCEDEFINITION)
        return "SubstanceDefinition";
      if (code == ResourceTypes.SUBSTANCENUCLEICACID)
        return "SubstanceNucleicAcid";
      if (code == ResourceTypes.SUBSTANCEPOLYMER)
        return "SubstancePolymer";
      if (code == ResourceTypes.SUBSTANCEPROTEIN)
        return "SubstanceProtein";
      if (code == ResourceTypes.SUBSTANCEREFERENCEINFORMATION)
        return "SubstanceReferenceInformation";
      if (code == ResourceTypes.SUBSTANCESOURCEMATERIAL)
        return "SubstanceSourceMaterial";
      if (code == ResourceTypes.SUPPLYDELIVERY)
        return "SupplyDelivery";
      if (code == ResourceTypes.SUPPLYREQUEST)
        return "SupplyRequest";
      if (code == ResourceTypes.TASK)
        return "Task";
      if (code == ResourceTypes.TERMINOLOGYCAPABILITIES)
        return "TerminologyCapabilities";
      if (code == ResourceTypes.TESTREPORT)
        return "TestReport";
      if (code == ResourceTypes.TESTSCRIPT)
        return "TestScript";
      if (code == ResourceTypes.TRANSPORT)
        return "Transport";
      if (code == ResourceTypes.VALUESET)
        return "ValueSet";
      if (code == ResourceTypes.VERIFICATIONRESULT)
        return "VerificationResult";
      if (code == ResourceTypes.VISIONPRESCRIPTION)
        return "VisionPrescription";
      return "?";
      }
    public String toSystem(ResourceTypes code) {
      return code.getSystem();
      }
    }

    public enum SearchParamType {
        /**
         * Search parameter SHALL be a number (a whole number, or a decimal).
         */
        NUMBER, 
        /**
         * Search parameter is on a date/time. The date format is the standard XML format, though other formats may be supported.
         */
        DATE, 
        /**
         * Search parameter is a simple string, like a name part. Search is case-insensitive and accent-insensitive. May match just the start of a string. String parameters may contain spaces.
         */
        STRING, 
        /**
         * Search parameter on a coded element or identifier. May be used to search through the text, display, code and code/codesystem (for codes) and label, system and key (for identifier). Its value is either a string or a pair of namespace and value, separated by a "|", depending on the modifier used.
         */
        TOKEN, 
        /**
         * A reference to another resource (Reference or canonical).
         */
        REFERENCE, 
        /**
         * A composite search parameter that combines a search on two values together.
         */
        COMPOSITE, 
        /**
         * A search parameter that searches on a quantity.
         */
        QUANTITY, 
        /**
         * A search parameter that searches on a URI (RFC 3986).
         */
        URI, 
        /**
         * Special logic applies to this parameter per the description of the search parameter.
         */
        SPECIAL, 
        /**
         * added to help the parsers
         */
        NULL;
        public static SearchParamType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("number".equals(codeString))
          return NUMBER;
        if ("date".equals(codeString))
          return DATE;
        if ("string".equals(codeString))
          return STRING;
        if ("token".equals(codeString))
          return TOKEN;
        if ("reference".equals(codeString))
          return REFERENCE;
        if ("composite".equals(codeString))
          return COMPOSITE;
        if ("quantity".equals(codeString))
          return QUANTITY;
        if ("uri".equals(codeString))
          return URI;
        if ("special".equals(codeString))
          return SPECIAL;
        throw new FHIRException("Unknown SearchParamType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case NUMBER: return "number";
            case DATE: return "date";
            case STRING: return "string";
            case TOKEN: return "token";
            case REFERENCE: return "reference";
            case COMPOSITE: return "composite";
            case QUANTITY: return "quantity";
            case URI: return "uri";
            case SPECIAL: return "special";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case NUMBER: return "http://hl7.org/fhir/search-param-type";
            case DATE: return "http://hl7.org/fhir/search-param-type";
            case STRING: return "http://hl7.org/fhir/search-param-type";
            case TOKEN: return "http://hl7.org/fhir/search-param-type";
            case REFERENCE: return "http://hl7.org/fhir/search-param-type";
            case COMPOSITE: return "http://hl7.org/fhir/search-param-type";
            case QUANTITY: return "http://hl7.org/fhir/search-param-type";
            case URI: return "http://hl7.org/fhir/search-param-type";
            case SPECIAL: return "http://hl7.org/fhir/search-param-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case NUMBER: return "Search parameter SHALL be a number (a whole number, or a decimal).";
            case DATE: return "Search parameter is on a date/time. The date format is the standard XML format, though other formats may be supported.";
            case STRING: return "Search parameter is a simple string, like a name part. Search is case-insensitive and accent-insensitive. May match just the start of a string. String parameters may contain spaces.";
            case TOKEN: return "Search parameter on a coded element or identifier. May be used to search through the text, display, code and code/codesystem (for codes) and label, system and key (for identifier). Its value is either a string or a pair of namespace and value, separated by a \"|\", depending on the modifier used.";
            case REFERENCE: return "A reference to another resource (Reference or canonical).";
            case COMPOSITE: return "A composite search parameter that combines a search on two values together.";
            case QUANTITY: return "A search parameter that searches on a quantity.";
            case URI: return "A search parameter that searches on a URI (RFC 3986).";
            case SPECIAL: return "Special logic applies to this parameter per the description of the search parameter.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case NUMBER: return "Number";
            case DATE: return "Date/DateTime";
            case STRING: return "String";
            case TOKEN: return "Token";
            case REFERENCE: return "Reference";
            case COMPOSITE: return "Composite";
            case QUANTITY: return "Quantity";
            case URI: return "URI";
            case SPECIAL: return "Special";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class SearchParamTypeEnumFactory implements EnumFactory<SearchParamType> {
    public SearchParamType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("number".equals(codeString))
          return SearchParamType.NUMBER;
        if ("date".equals(codeString))
          return SearchParamType.DATE;
        if ("string".equals(codeString))
          return SearchParamType.STRING;
        if ("token".equals(codeString))
          return SearchParamType.TOKEN;
        if ("reference".equals(codeString))
          return SearchParamType.REFERENCE;
        if ("composite".equals(codeString))
          return SearchParamType.COMPOSITE;
        if ("quantity".equals(codeString))
          return SearchParamType.QUANTITY;
        if ("uri".equals(codeString))
          return SearchParamType.URI;
        if ("special".equals(codeString))
          return SearchParamType.SPECIAL;
        throw new IllegalArgumentException("Unknown SearchParamType code '"+codeString+"'");
        }
        public Enumeration<SearchParamType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SearchParamType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("number".equals(codeString))
          return new Enumeration<SearchParamType>(this, SearchParamType.NUMBER);
        if ("date".equals(codeString))
          return new Enumeration<SearchParamType>(this, SearchParamType.DATE);
        if ("string".equals(codeString))
          return new Enumeration<SearchParamType>(this, SearchParamType.STRING);
        if ("token".equals(codeString))
          return new Enumeration<SearchParamType>(this, SearchParamType.TOKEN);
        if ("reference".equals(codeString))
          return new Enumeration<SearchParamType>(this, SearchParamType.REFERENCE);
        if ("composite".equals(codeString))
          return new Enumeration<SearchParamType>(this, SearchParamType.COMPOSITE);
        if ("quantity".equals(codeString))
          return new Enumeration<SearchParamType>(this, SearchParamType.QUANTITY);
        if ("uri".equals(codeString))
          return new Enumeration<SearchParamType>(this, SearchParamType.URI);
        if ("special".equals(codeString))
          return new Enumeration<SearchParamType>(this, SearchParamType.SPECIAL);
        throw new FHIRException("Unknown SearchParamType code '"+codeString+"'");
        }
    public String toCode(SearchParamType code) {
      if (code == SearchParamType.NUMBER)
        return "number";
      if (code == SearchParamType.DATE)
        return "date";
      if (code == SearchParamType.STRING)
        return "string";
      if (code == SearchParamType.TOKEN)
        return "token";
      if (code == SearchParamType.REFERENCE)
        return "reference";
      if (code == SearchParamType.COMPOSITE)
        return "composite";
      if (code == SearchParamType.QUANTITY)
        return "quantity";
      if (code == SearchParamType.URI)
        return "uri";
      if (code == SearchParamType.SPECIAL)
        return "special";
      return "?";
      }
    public String toSystem(SearchParamType code) {
      return code.getSystem();
      }
    }

    public enum SubscriptionSearchModifier {
        /**
         * Used to match a value according to FHIR Search rules (e.g., Patient/123, Encounter/2002).
         */
        EQUAL, 
        /**
         * The value for the parameter in the resource is equal to the provided value.
         */
        EQ, 
        /**
         * The value for the parameter in the resource is not equal to the provided value.
         */
        NE, 
        /**
         * The value for the parameter in the resource is greater than the provided value.
         */
        GT, 
        /**
         * The value for the parameter in the resource is less than the provided value.
         */
        LT, 
        /**
         * The value for the parameter in the resource is greater or equal to the provided value.
         */
        GE, 
        /**
         * The value for the parameter in the resource is less or equal to the provided value.
         */
        LE, 
        /**
         * The value for the parameter in the resource starts after the provided value.
         */
        SA, 
        /**
         * The value for the parameter in the resource ends before the provided value.
         */
        EB, 
        /**
         * The value for the parameter in the resource is approximately the same to the provided value. Note that the recommended value for the approximation is 10% of the stated value (or for a date, 10% of the gap between now and the date), but systems may choose other values where appropriate.
         */
        AP, 
        /**
         * The search parameter is a concept with the form [system]|[code], and the search parameter tests whether the coding in a resource subsumes the specified search code.
         */
        ABOVE, 
        /**
         * The search parameter is a concept with the form [system]|[code], and the search parameter tests whether the coding in a resource is subsumed by the specified search code.
         */
        BELOW, 
        /**
         * The search parameter is a member of a Group or List, or the search parameter is a URI (relative or absolute) that identifies a value set, and the search parameter tests whether the value is present in the specified Group, List, or Value Set.
         */
        IN, 
        /**
         * The search parameter is a member of a Group or List, or the search parameter is a URI (relative or absolute) that identifies a value set, and the search parameter tests whether the value is NOT present in the specified Group, List, or Value Set.
         */
        NOTIN, 
        /**
         * The search parameter has the format system|code|value, where the system and code refer to a Identifier.type.coding.system and .code, and match if any of the type codes match. All 3 parts must be present.
         */
        OFTYPE, 
        /**
         * added to help the parsers
         */
        NULL;
        public static SubscriptionSearchModifier fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("=".equals(codeString))
          return EQUAL;
        if ("eq".equals(codeString))
          return EQ;
        if ("ne".equals(codeString))
          return NE;
        if ("gt".equals(codeString))
          return GT;
        if ("lt".equals(codeString))
          return LT;
        if ("ge".equals(codeString))
          return GE;
        if ("le".equals(codeString))
          return LE;
        if ("sa".equals(codeString))
          return SA;
        if ("eb".equals(codeString))
          return EB;
        if ("ap".equals(codeString))
          return AP;
        if ("above".equals(codeString))
          return ABOVE;
        if ("below".equals(codeString))
          return BELOW;
        if ("in".equals(codeString))
          return IN;
        if ("not-in".equals(codeString))
          return NOTIN;
        if ("of-type".equals(codeString))
          return OFTYPE;
        throw new FHIRException("Unknown SubscriptionSearchModifier code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case EQUAL: return "=";
            case EQ: return "eq";
            case NE: return "ne";
            case GT: return "gt";
            case LT: return "lt";
            case GE: return "ge";
            case LE: return "le";
            case SA: return "sa";
            case EB: return "eb";
            case AP: return "ap";
            case ABOVE: return "above";
            case BELOW: return "below";
            case IN: return "in";
            case NOTIN: return "not-in";
            case OFTYPE: return "of-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case EQUAL: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case EQ: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case NE: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case GT: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case LT: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case GE: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case LE: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case SA: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case EB: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case AP: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case ABOVE: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case BELOW: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case IN: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case NOTIN: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case OFTYPE: return "http://terminology.hl7.org/CodeSystem/subscription-search-modifier";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case EQUAL: return "Used to match a value according to FHIR Search rules (e.g., Patient/123, Encounter/2002).";
            case EQ: return "The value for the parameter in the resource is equal to the provided value.";
            case NE: return "The value for the parameter in the resource is not equal to the provided value.";
            case GT: return "The value for the parameter in the resource is greater than the provided value.";
            case LT: return "The value for the parameter in the resource is less than the provided value.";
            case GE: return "The value for the parameter in the resource is greater or equal to the provided value.";
            case LE: return "The value for the parameter in the resource is less or equal to the provided value.";
            case SA: return "The value for the parameter in the resource starts after the provided value.";
            case EB: return "The value for the parameter in the resource ends before the provided value.";
            case AP: return "The value for the parameter in the resource is approximately the same to the provided value. Note that the recommended value for the approximation is 10% of the stated value (or for a date, 10% of the gap between now and the date), but systems may choose other values where appropriate.";
            case ABOVE: return "The search parameter is a concept with the form [system]|[code], and the search parameter tests whether the coding in a resource subsumes the specified search code.";
            case BELOW: return "The search parameter is a concept with the form [system]|[code], and the search parameter tests whether the coding in a resource is subsumed by the specified search code.";
            case IN: return "The search parameter is a member of a Group or List, or the search parameter is a URI (relative or absolute) that identifies a value set, and the search parameter tests whether the value is present in the specified Group, List, or Value Set.";
            case NOTIN: return "The search parameter is a member of a Group or List, or the search parameter is a URI (relative or absolute) that identifies a value set, and the search parameter tests whether the value is NOT present in the specified Group, List, or Value Set.";
            case OFTYPE: return "The search parameter has the format system|code|value, where the system and code refer to a Identifier.type.coding.system and .code, and match if any of the type codes match. All 3 parts must be present.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case EQUAL: return "=";
            case EQ: return "Equal";
            case NE: return "Not Equal";
            case GT: return "Greater Than";
            case LT: return "Less Than";
            case GE: return "Greater Than or Equal";
            case LE: return "Less Than or Equal";
            case SA: return "Starts After";
            case EB: return "Ends Before";
            case AP: return "Approximately";
            case ABOVE: return "Above";
            case BELOW: return "Below";
            case IN: return "In";
            case NOTIN: return "Not In";
            case OFTYPE: return "Of Type";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class SubscriptionSearchModifierEnumFactory implements EnumFactory<SubscriptionSearchModifier> {
    public SubscriptionSearchModifier fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("=".equals(codeString))
          return SubscriptionSearchModifier.EQUAL;
        if ("eq".equals(codeString))
          return SubscriptionSearchModifier.EQ;
        if ("ne".equals(codeString))
          return SubscriptionSearchModifier.NE;
        if ("gt".equals(codeString))
          return SubscriptionSearchModifier.GT;
        if ("lt".equals(codeString))
          return SubscriptionSearchModifier.LT;
        if ("ge".equals(codeString))
          return SubscriptionSearchModifier.GE;
        if ("le".equals(codeString))
          return SubscriptionSearchModifier.LE;
        if ("sa".equals(codeString))
          return SubscriptionSearchModifier.SA;
        if ("eb".equals(codeString))
          return SubscriptionSearchModifier.EB;
        if ("ap".equals(codeString))
          return SubscriptionSearchModifier.AP;
        if ("above".equals(codeString))
          return SubscriptionSearchModifier.ABOVE;
        if ("below".equals(codeString))
          return SubscriptionSearchModifier.BELOW;
        if ("in".equals(codeString))
          return SubscriptionSearchModifier.IN;
        if ("not-in".equals(codeString))
          return SubscriptionSearchModifier.NOTIN;
        if ("of-type".equals(codeString))
          return SubscriptionSearchModifier.OFTYPE;
        throw new IllegalArgumentException("Unknown SubscriptionSearchModifier code '"+codeString+"'");
        }
        public Enumeration<SubscriptionSearchModifier> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SubscriptionSearchModifier>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("=".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.EQUAL);
        if ("eq".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.EQ);
        if ("ne".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.NE);
        if ("gt".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.GT);
        if ("lt".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.LT);
        if ("ge".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.GE);
        if ("le".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.LE);
        if ("sa".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.SA);
        if ("eb".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.EB);
        if ("ap".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.AP);
        if ("above".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.ABOVE);
        if ("below".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.BELOW);
        if ("in".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.IN);
        if ("not-in".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.NOTIN);
        if ("of-type".equals(codeString))
          return new Enumeration<SubscriptionSearchModifier>(this, SubscriptionSearchModifier.OFTYPE);
        throw new FHIRException("Unknown SubscriptionSearchModifier code '"+codeString+"'");
        }
    public String toCode(SubscriptionSearchModifier code) {
      if (code == SubscriptionSearchModifier.EQUAL)
        return "=";
      if (code == SubscriptionSearchModifier.EQ)
        return "eq";
      if (code == SubscriptionSearchModifier.NE)
        return "ne";
      if (code == SubscriptionSearchModifier.GT)
        return "gt";
      if (code == SubscriptionSearchModifier.LT)
        return "lt";
      if (code == SubscriptionSearchModifier.GE)
        return "ge";
      if (code == SubscriptionSearchModifier.LE)
        return "le";
      if (code == SubscriptionSearchModifier.SA)
        return "sa";
      if (code == SubscriptionSearchModifier.EB)
        return "eb";
      if (code == SubscriptionSearchModifier.AP)
        return "ap";
      if (code == SubscriptionSearchModifier.ABOVE)
        return "above";
      if (code == SubscriptionSearchModifier.BELOW)
        return "below";
      if (code == SubscriptionSearchModifier.IN)
        return "in";
      if (code == SubscriptionSearchModifier.NOTIN)
        return "not-in";
      if (code == SubscriptionSearchModifier.OFTYPE)
        return "of-type";
      return "?";
      }
    public String toSystem(SubscriptionSearchModifier code) {
      return code.getSystem();
      }
    }

    public enum SubscriptionStatusCodes {
        /**
         * The client has requested the subscription, and the server has not yet set it up.
         */
        REQUESTED, 
        /**
         * The subscription is active.
         */
        ACTIVE, 
        /**
         * The server has an error executing the notification.
         */
        ERROR, 
        /**
         * Too many errors have occurred or the subscription has expired.
         */
        OFF, 
        /**
         * This subscription has been flagged as incorrect.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers
         */
        NULL;
        public static SubscriptionStatusCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("requested".equals(codeString))
          return REQUESTED;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("error".equals(codeString))
          return ERROR;
        if ("off".equals(codeString))
          return OFF;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        throw new FHIRException("Unknown SubscriptionStatusCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REQUESTED: return "requested";
            case ACTIVE: return "active";
            case ERROR: return "error";
            case OFF: return "off";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REQUESTED: return "http://terminology.hl7.org/CodeSystem/subscription-status";
            case ACTIVE: return "http://terminology.hl7.org/CodeSystem/subscription-status";
            case ERROR: return "http://terminology.hl7.org/CodeSystem/subscription-status";
            case OFF: return "http://terminology.hl7.org/CodeSystem/subscription-status";
            case ENTEREDINERROR: return "http://terminology.hl7.org/CodeSystem/subscription-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REQUESTED: return "The client has requested the subscription, and the server has not yet set it up.";
            case ACTIVE: return "The subscription is active.";
            case ERROR: return "The server has an error executing the notification.";
            case OFF: return "Too many errors have occurred or the subscription has expired.";
            case ENTEREDINERROR: return "This subscription has been flagged as incorrect.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REQUESTED: return "Requested";
            case ACTIVE: return "Active";
            case ERROR: return "Error";
            case OFF: return "Off";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class SubscriptionStatusCodesEnumFactory implements EnumFactory<SubscriptionStatusCodes> {
    public SubscriptionStatusCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("requested".equals(codeString))
          return SubscriptionStatusCodes.REQUESTED;
        if ("active".equals(codeString))
          return SubscriptionStatusCodes.ACTIVE;
        if ("error".equals(codeString))
          return SubscriptionStatusCodes.ERROR;
        if ("off".equals(codeString))
          return SubscriptionStatusCodes.OFF;
        if ("entered-in-error".equals(codeString))
          return SubscriptionStatusCodes.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown SubscriptionStatusCodes code '"+codeString+"'");
        }
        public Enumeration<SubscriptionStatusCodes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SubscriptionStatusCodes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("requested".equals(codeString))
          return new Enumeration<SubscriptionStatusCodes>(this, SubscriptionStatusCodes.REQUESTED);
        if ("active".equals(codeString))
          return new Enumeration<SubscriptionStatusCodes>(this, SubscriptionStatusCodes.ACTIVE);
        if ("error".equals(codeString))
          return new Enumeration<SubscriptionStatusCodes>(this, SubscriptionStatusCodes.ERROR);
        if ("off".equals(codeString))
          return new Enumeration<SubscriptionStatusCodes>(this, SubscriptionStatusCodes.OFF);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<SubscriptionStatusCodes>(this, SubscriptionStatusCodes.ENTEREDINERROR);
        throw new FHIRException("Unknown SubscriptionStatusCodes code '"+codeString+"'");
        }
    public String toCode(SubscriptionStatusCodes code) {
      if (code == SubscriptionStatusCodes.REQUESTED)
        return "requested";
      if (code == SubscriptionStatusCodes.ACTIVE)
        return "active";
      if (code == SubscriptionStatusCodes.ERROR)
        return "error";
      if (code == SubscriptionStatusCodes.OFF)
        return "off";
      if (code == SubscriptionStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(SubscriptionStatusCodes code) {
      return code.getSystem();
      }
    }

    public enum Use {
        /**
         * The treatment is complete and this represents a Claim for the services.
         */
        CLAIM, 
        /**
         * The treatment is proposed and this represents a Pre-authorization for the services.
         */
        PREAUTHORIZATION, 
        /**
         * The treatment is proposed and this represents a Pre-determination for the services.
         */
        PREDETERMINATION, 
        /**
         * added to help the parsers
         */
        NULL;
        public static Use fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("claim".equals(codeString))
          return CLAIM;
        if ("preauthorization".equals(codeString))
          return PREAUTHORIZATION;
        if ("predetermination".equals(codeString))
          return PREDETERMINATION;
        throw new FHIRException("Unknown Use code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CLAIM: return "claim";
            case PREAUTHORIZATION: return "preauthorization";
            case PREDETERMINATION: return "predetermination";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CLAIM: return "http://hl7.org/fhir/claim-use";
            case PREAUTHORIZATION: return "http://hl7.org/fhir/claim-use";
            case PREDETERMINATION: return "http://hl7.org/fhir/claim-use";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CLAIM: return "The treatment is complete and this represents a Claim for the services.";
            case PREAUTHORIZATION: return "The treatment is proposed and this represents a Pre-authorization for the services.";
            case PREDETERMINATION: return "The treatment is proposed and this represents a Pre-determination for the services.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CLAIM: return "Claim";
            case PREAUTHORIZATION: return "Preauthorization";
            case PREDETERMINATION: return "Predetermination";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class UseEnumFactory implements EnumFactory<Use> {
    public Use fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("claim".equals(codeString))
          return Use.CLAIM;
        if ("preauthorization".equals(codeString))
          return Use.PREAUTHORIZATION;
        if ("predetermination".equals(codeString))
          return Use.PREDETERMINATION;
        throw new IllegalArgumentException("Unknown Use code '"+codeString+"'");
        }
        public Enumeration<Use> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<Use>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("claim".equals(codeString))
          return new Enumeration<Use>(this, Use.CLAIM);
        if ("preauthorization".equals(codeString))
          return new Enumeration<Use>(this, Use.PREAUTHORIZATION);
        if ("predetermination".equals(codeString))
          return new Enumeration<Use>(this, Use.PREDETERMINATION);
        throw new FHIRException("Unknown Use code '"+codeString+"'");
        }
    public String toCode(Use code) {
      if (code == Use.CLAIM)
        return "claim";
      if (code == Use.PREAUTHORIZATION)
        return "preauthorization";
      if (code == Use.PREDETERMINATION)
        return "predetermination";
      return "?";
      }
    public String toSystem(Use code) {
      return code.getSystem();
      }
    }


}

