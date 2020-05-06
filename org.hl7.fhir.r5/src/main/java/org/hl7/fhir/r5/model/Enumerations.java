package org.hl7.fhir.r5.model;


/*
 * #%L
 * org.hl7.fhir.r5
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the \"License\");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an \"AS IS\" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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

// Generated on Tue, Dec 31, 2019 12:12+1100 for FHIR vcurrent


import org.hl7.fhir.instance.model.api.*;
import org.hl7.fhir.exceptions.FHIRException;

public class Enumerations {

// In here: 
//   ActionCardinalityBehavior: Defines behavior for an action or a group for how many times that item may be repeated.[PlanDefinition, RequestGroup]
//   ActionConditionKind: Defines the kinds of conditions that can appear on actions.[PlanDefinition, RequestGroup]
//   ActionGroupingBehavior: Defines organization behavior of a group.[PlanDefinition, RequestGroup]
//   ActionParticipantType: The type of participant for the action.[ActivityDefinition, PlanDefinition]
//   ActionPrecheckBehavior: Defines selection frequency behavior for an action or group.[PlanDefinition, RequestGroup]
//   ActionRelationshipType: Defines the types of relationships between actions.[PlanDefinition, RequestGroup]
//   ActionRequiredBehavior: Defines expectations around whether an action or action group is required.[PlanDefinition, RequestGroup]
//   ActionSelectionBehavior: Defines selection behavior of a group.[PlanDefinition, RequestGroup]
//   AdministrativeGender: The gender of a person used for administrative purposes.[ObservationDefinition, Patient, Person, Practitioner, RelatedPerson]
//   BindingStrength: Indication of the degree of conformance expectations associated with a binding.[ElementDefinition, OperationDefinition]
//   CapabilityStatementKind: How a capability statement is intended to be used.[CapabilityStatement, CapabilityStatement2, TerminologyCapabilities]
//   ClaimProcessingCodes: This value set includes Claim Processing Outcome codes.[ClaimResponse, CoverageEligibilityResponse, EnrollmentResponse, ExplanationOfBenefit, PaymentReconciliation]
//   CompartmentType: Which type a compartment definition describes.[CompartmentDefinition, GraphDefinition]
//   CompositionStatus: The workflow/clinical status of the composition.[Composition, DocumentReference]
//   ConceptMapRelationship: The relationship between concepts.[ConceptMap]
//   DaysOfWeek: The days of the week.[HealthcareService, Location, PractitionerRole, Timing]
//   DeviceNameType: The type of name the device is referred by.[Device, DeviceDefinition]
//   DocumentReferenceStatus: The status of the document reference.[DocumentManifest, DocumentReference]
//   DocumentRelationshipType: The type of relationship between documents.[Composition, DocumentReference]
//   EventStatus: Codes identifying the lifecycle stage of an event.[ClinicalImpression, Communication, Procedure]
//   FHIRAllTypes: A list of all the concrete types defined in this version of the FHIR specification - Abstract Types, Data Types and Resource Types.[DataRequirement, OperationDefinition, ParameterDefinition]
//   FHIRVersion: All published FHIR Versions.[CapabilityStatement, CapabilityStatement2, ImplementationGuide, StructureDefinition]
//   FilterOperator: The kind of operation to perform as a part of a property based filter.[CodeSystem, ValueSet]
//   FinancialResourceStatusCodes: This value set includes Status codes.[Claim, ClaimResponse, Coverage, CoverageEligibilityRequest, CoverageEligibilityResponse, EnrollmentRequest, EnrollmentResponse, PaymentNotice, PaymentReconciliation, VisionPrescription]
//   InvoicePriceComponentType: Codes indicating the kind of the price component.[ChargeItemDefinition, Invoice]
//   ListMode: The processing mode that applies to this list.[Composition, List]
//   MeasureImprovementNotation: Observation values that indicate what change in a measurement value or score is indicative of an improvement in the measured item or scored issue.[Measure, MeasureReport]
//   MimeTypes: This value set includes all possible codes from BCP-13 (http://tools.ietf.org/html/bcp13)[Attachment, Binary, CapabilityStatement, CapabilityStatement2, ElementDefinition, Endpoint, Signature, Subscription, TestScript]
//   NoteType: The presentation types of notes.[ClaimResponse, ExplanationOfBenefit, PaymentReconciliation]
//   ObservationStatus: Codes providing the status of an observation.[DetectedIssue, Observation, RiskAssessment]
//   OperationParameterUse: Whether an operation parameter is an input or an output parameter.[OperationDefinition, ParameterDefinition]
//   ParticipationStatus: The Participation status of an appointment.[Appointment, AppointmentResponse]
//   PublicationStatus: The lifecycle status of an artifact.[ActivityDefinition, CanonicalResource, CapabilityStatement, CapabilityStatement2, ChargeItemDefinition, CodeSystem, CompartmentDefinition, ConceptMap, ConditionDefinition, EventDefinition, Evidence, EvidenceVariable, ExampleScenario, GraphDefinition, ImplementationGuide, InsurancePlan, Library, Measure, MessageDefinition, NamingSystem, ObservationDefinition, OperationDefinition, PlanDefinition, Questionnaire, SearchParameter, SpecimenDefinition, StructureDefinition, StructureMap, TerminologyCapabilities, TestScript, Topic, ValueSet]
//   QuantityComparator: How the Quantity should be understood and represented.[Age, Count, Distance, Duration, Quantity]
//   RequestIntent: Codes indicating the degree of authority/intentionality associated with a request.[ActivityDefinition, DeviceRequest, NutritionOrder, RequestGroup, ServiceRequest]
//   RequestPriority: The clinical priority of a diagnostic order.[ActivityDefinition, Communication, CommunicationRequest, DeviceRequest, MedicationRequest, PlanDefinition, RequestGroup, ServiceRequest, SupplyRequest, Task]
//   RequestStatus: Codes identifying the lifecycle stage of a request.[CarePlan, CommunicationRequest, DeviceRequest, NutritionOrder, RequestGroup, ServiceRequest]
//   ResourceTypeEnum: One of the resource types defined as part of this version of FHIR.[CapabilityStatement, CapabilityStatement2, CompartmentDefinition, ExampleScenario, GraphDefinition, ImplementationGuide, MessageDefinition, OperationDefinition, Questionnaire, SearchParameter, Topic]
//   RestfulCapabilityMode: The mode of a RESTful capability statement.[CapabilityStatement, CapabilityStatement2]
//   SearchParamType: Data types allowed to be used for search parameters.[CapabilityStatement, CapabilityStatement2, OperationDefinition, SearchParameter]
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case SINGLE: return "http://hl7.org/fhir/action-cardinality-behavior";
            case MULTIPLE: return "http://hl7.org/fhir/action-cardinality-behavior";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case SINGLE: return "The action may only be selected one time.";
            case MULTIPLE: return "The action may be selected multiple times.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case SINGLE: return "Single";
            case MULTIPLE: return "Multiple";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case APPLICABILITY: return "http://hl7.org/fhir/action-condition-kind";
            case START: return "http://hl7.org/fhir/action-condition-kind";
            case STOP: return "http://hl7.org/fhir/action-condition-kind";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case APPLICABILITY: return "The condition describes whether or not a given action is applicable.";
            case START: return "The condition is a starting condition for the action.";
            case STOP: return "The condition is a stop, or exit condition for the action.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case APPLICABILITY: return "Applicability";
            case START: return "Start";
            case STOP: return "Stop";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case VISUALGROUP: return "http://hl7.org/fhir/action-grouping-behavior";
            case LOGICALGROUP: return "http://hl7.org/fhir/action-grouping-behavior";
            case SENTENCEGROUP: return "http://hl7.org/fhir/action-grouping-behavior";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case VISUALGROUP: return "Any group marked with this behavior should be displayed as a visual group to the end user.";
            case LOGICALGROUP: return "A group with this behavior logically groups its sub-elements, and may be shown as a visual group to the end user, but it is not required to do so.";
            case SENTENCEGROUP: return "A group of related alternative actions is a sentence group if the target referenced by the action is the same in all the actions and each action simply constitutes a different variation on how to specify the details for the target. For example, two actions that could be in a SentenceGroup are \"aspirin, 500 mg, 2 times per day\" and \"aspirin, 300 mg, 3 times per day\". In both cases, aspirin is the target referenced by the action, and the two actions represent different options for how aspirin might be ordered for the patient. Note that a SentenceGroup would almost always have an associated selection behavior of \"AtMostOne\", unless it's a required action, in which case, it would be \"ExactlyOne\".";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case VISUALGROUP: return "Visual Group";
            case LOGICALGROUP: return "Logical Group";
            case SENTENCEGROUP: return "Sentence Group";
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
         * The participant is the patient under evaluation.
         */
        PATIENT, 
        /**
         * The participant is a practitioner involved in the patient's care.
         */
        PRACTITIONER, 
        /**
         * The participant is a person related to the patient.
         */
        RELATEDPERSON, 
        /**
         * The participant is a system or device used in the care of the patient.
         */
        DEVICE, 
        /**
         * added to help the parsers
         */
        NULL;
        public static ActionParticipantType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("patient".equals(codeString))
          return PATIENT;
        if ("practitioner".equals(codeString))
          return PRACTITIONER;
        if ("related-person".equals(codeString))
          return RELATEDPERSON;
        if ("device".equals(codeString))
          return DEVICE;
        throw new FHIRException("Unknown ActionParticipantType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PATIENT: return "patient";
            case PRACTITIONER: return "practitioner";
            case RELATEDPERSON: return "related-person";
            case DEVICE: return "device";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PATIENT: return "http://hl7.org/fhir/action-participant-type";
            case PRACTITIONER: return "http://hl7.org/fhir/action-participant-type";
            case RELATEDPERSON: return "http://hl7.org/fhir/action-participant-type";
            case DEVICE: return "http://hl7.org/fhir/action-participant-type";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PATIENT: return "The participant is the patient under evaluation.";
            case PRACTITIONER: return "The participant is a practitioner involved in the patient's care.";
            case RELATEDPERSON: return "The participant is a person related to the patient.";
            case DEVICE: return "The participant is a system or device used in the care of the patient.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PATIENT: return "Patient";
            case PRACTITIONER: return "Practitioner";
            case RELATEDPERSON: return "Related Person";
            case DEVICE: return "Device";
            default: return "?";
          }
        }
    }

  public static class ActionParticipantTypeEnumFactory implements EnumFactory<ActionParticipantType> {
    public ActionParticipantType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("patient".equals(codeString))
          return ActionParticipantType.PATIENT;
        if ("practitioner".equals(codeString))
          return ActionParticipantType.PRACTITIONER;
        if ("related-person".equals(codeString))
          return ActionParticipantType.RELATEDPERSON;
        if ("device".equals(codeString))
          return ActionParticipantType.DEVICE;
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
        if ("patient".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.PATIENT);
        if ("practitioner".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.PRACTITIONER);
        if ("related-person".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.RELATEDPERSON);
        if ("device".equals(codeString))
          return new Enumeration<ActionParticipantType>(this, ActionParticipantType.DEVICE);
        throw new FHIRException("Unknown ActionParticipantType code '"+codeString+"'");
        }
    public String toCode(ActionParticipantType code) {
      if (code == ActionParticipantType.PATIENT)
        return "patient";
      if (code == ActionParticipantType.PRACTITIONER)
        return "practitioner";
      if (code == ActionParticipantType.RELATEDPERSON)
        return "related-person";
      if (code == ActionParticipantType.DEVICE)
        return "device";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case YES: return "http://hl7.org/fhir/action-precheck-behavior";
            case NO: return "http://hl7.org/fhir/action-precheck-behavior";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case YES: return "An action with this behavior is one of the most frequent action that is, or should be, included by an end user, for the particular context in which the action occurs. The system displaying the action to the end user should consider \"pre-checking\" such an action as a convenience for the user.";
            case NO: return "An action with this behavior is one of the less frequent actions included by the end user, for the particular context in which the action occurs. The system displaying the actions to the end user would typically not \"pre-check\" such an action.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case YES: return "Yes";
            case NO: return "No";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case MUST: return "http://hl7.org/fhir/action-required-behavior";
            case COULD: return "http://hl7.org/fhir/action-required-behavior";
            case MUSTUNLESSDOCUMENTED: return "http://hl7.org/fhir/action-required-behavior";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case MUST: return "An action with this behavior must be included in the actions processed by the end user; the end user SHALL NOT choose not to include this action.";
            case COULD: return "An action with this behavior may be included in the set of actions processed by the end user.";
            case MUSTUNLESSDOCUMENTED: return "An action with this behavior must be included in the set of actions processed by the end user, unless the end user provides documentation as to why the action was not included.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case MUST: return "Must";
            case COULD: return "Could";
            case MUSTUNLESSDOCUMENTED: return "Must Unless Documented";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case MALE: return "http://hl7.org/fhir/administrative-gender";
            case FEMALE: return "http://hl7.org/fhir/administrative-gender";
            case OTHER: return "http://hl7.org/fhir/administrative-gender";
            case UNKNOWN: return "http://hl7.org/fhir/administrative-gender";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case MALE: return "Male.";
            case FEMALE: return "Female.";
            case OTHER: return "Other.";
            case UNKNOWN: return "Unknown.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case MALE: return "Male";
            case FEMALE: return "Female";
            case OTHER: return "Other";
            case UNKNOWN: return "Unknown";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REQUIRED: return "http://hl7.org/fhir/binding-strength";
            case EXTENSIBLE: return "http://hl7.org/fhir/binding-strength";
            case PREFERRED: return "http://hl7.org/fhir/binding-strength";
            case EXAMPLE: return "http://hl7.org/fhir/binding-strength";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REQUIRED: return "To be conformant, the concept in this element SHALL be from the specified value set.";
            case EXTENSIBLE: return "To be conformant, the concept in this element SHALL be from the specified value set if any of the codes within the value set can apply to the concept being communicated.  If the value set does not cover the concept (based on human review), alternate codings (or, data type allowing, text) may be included instead.";
            case PREFERRED: return "Instances are encouraged to draw from the specified codes for interoperability purposes but are not required to do so to be considered conformant.";
            case EXAMPLE: return "Instances are not expected or even encouraged to draw from the specified value set.  The value set merely provides examples of the types of concepts intended to be included.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REQUIRED: return "Required";
            case EXTENSIBLE: return "Extensible";
            case PREFERRED: return "Preferred";
            case EXAMPLE: return "Example";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INSTANCE: return "http://hl7.org/fhir/capability-statement-kind";
            case CAPABILITY: return "http://hl7.org/fhir/capability-statement-kind";
            case REQUIREMENTS: return "http://hl7.org/fhir/capability-statement-kind";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INSTANCE: return "The CapabilityStatement instance represents the present capabilities of a specific system instance.  This is the kind returned by /metadata for a FHIR server end-point.";
            case CAPABILITY: return "The CapabilityStatement instance represents the capabilities of a system or piece of software, independent of a particular installation.";
            case REQUIREMENTS: return "The CapabilityStatement instance represents a set of requirements for other systems to meet; e.g. as part of an implementation guide or 'request for proposal'.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INSTANCE: return "Instance";
            case CAPABILITY: return "Capability";
            case REQUIREMENTS: return "Requirements";
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
         * null
         */
        QUEUED, 
        /**
         * The processing completed without errors.
         */
        COMPLETE, 
        /**
         * The processing identified errors.
         */
        ERROR, 
        /**
         * No errors have been detected and some of the adjudication has been performed.
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case QUEUED: return "http://hl7.org/fhir/remittance-outcome";
            case COMPLETE: return "http://hl7.org/fhir/remittance-outcome";
            case ERROR: return "http://hl7.org/fhir/remittance-outcome";
            case PARTIAL: return "http://hl7.org/fhir/remittance-outcome";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case QUEUED: return "";
            case COMPLETE: return "The processing completed without errors.";
            case ERROR: return "The processing identified errors.";
            case PARTIAL: return "No errors have been detected and some of the adjudication has been performed.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case QUEUED: return "Queued";
            case COMPLETE: return "Processing Complete";
            case ERROR: return "Error";
            case PARTIAL: return "Partial Processing";
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
         * This is a preliminary composition or document (also known as initial or interim). The content may be incomplete or unverified.
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
         * The composition or document was originally created/issued in error, and this is an amendment that marks that the entire series should not be considered as valid.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers
         */
        NULL;
        public static CompositionStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preliminary".equals(codeString))
          return PRELIMINARY;
        if ("final".equals(codeString))
          return FINAL;
        if ("amended".equals(codeString))
          return AMENDED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        throw new FHIRException("Unknown CompositionStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PRELIMINARY: return "preliminary";
            case FINAL: return "final";
            case AMENDED: return "amended";
            case ENTEREDINERROR: return "entered-in-error";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PRELIMINARY: return "http://hl7.org/fhir/composition-status";
            case FINAL: return "http://hl7.org/fhir/composition-status";
            case AMENDED: return "http://hl7.org/fhir/composition-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/composition-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PRELIMINARY: return "This is a preliminary composition or document (also known as initial or interim). The content may be incomplete or unverified.";
            case FINAL: return "This version of the composition is complete and verified by an appropriate person and no further work is planned. Any subsequent updates would be on a new version of the composition.";
            case AMENDED: return "The composition content or the referenced resources have been modified (edited or added to) subsequent to being released as \"final\" and the composition is complete and verified by an authorized person.";
            case ENTEREDINERROR: return "The composition or document was originally created/issued in error, and this is an amendment that marks that the entire series should not be considered as valid.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PRELIMINARY: return "Preliminary";
            case FINAL: return "Final";
            case AMENDED: return "Amended";
            case ENTEREDINERROR: return "Entered in Error";
            default: return "?";
          }
        }
    }

  public static class CompositionStatusEnumFactory implements EnumFactory<CompositionStatus> {
    public CompositionStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preliminary".equals(codeString))
          return CompositionStatus.PRELIMINARY;
        if ("final".equals(codeString))
          return CompositionStatus.FINAL;
        if ("amended".equals(codeString))
          return CompositionStatus.AMENDED;
        if ("entered-in-error".equals(codeString))
          return CompositionStatus.ENTEREDINERROR;
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
        if ("preliminary".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.PRELIMINARY);
        if ("final".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.FINAL);
        if ("amended".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.AMENDED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<CompositionStatus>(this, CompositionStatus.ENTEREDINERROR);
        throw new FHIRException("Unknown CompositionStatus code '"+codeString+"'");
        }
    public String toCode(CompositionStatus code) {
      if (code == CompositionStatus.PRELIMINARY)
        return "preliminary";
      if (code == CompositionStatus.FINAL)
        return "final";
      if (code == CompositionStatus.AMENDED)
        return "amended";
      if (code == CompositionStatus.ENTEREDINERROR)
        return "entered-in-error";
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
        SOURCENARROWERTARGET, 
        /**
         * The source concept is broader in meaning than the target concept.
         */
        SOURCEBROADERTARGET, 
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
          return SOURCENARROWERTARGET;
        if ("source-is-broader-than-target".equals(codeString))
          return SOURCEBROADERTARGET;
        if ("not-related-to".equals(codeString))
          return NOTRELATEDTO;
        throw new FHIRException("Unknown ConceptMapRelationship code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case RELATEDTO: return "related-to";
            case EQUIVALENT: return "equivalent";
            case SOURCENARROWERTARGET: return "source-is-narrower-than-target";
            case SOURCEBROADERTARGET: return "source-is-broader-than-target";
            case NOTRELATEDTO: return "not-related-to";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case RELATEDTO: return "http://hl7.org/fhir/concept-map-relationship";
            case EQUIVALENT: return "http://hl7.org/fhir/concept-map-relationship";
            case SOURCENARROWERTARGET: return "http://hl7.org/fhir/concept-map-relationship";
            case SOURCEBROADERTARGET: return "http://hl7.org/fhir/concept-map-relationship";
            case NOTRELATEDTO: return "http://hl7.org/fhir/concept-map-relationship";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case RELATEDTO: return "The concepts are related to each other, but the exact relationship is not known.";
            case EQUIVALENT: return "The definitions of the concepts mean the same thing.";
            case SOURCENARROWERTARGET: return "The source concept is narrower in meaning than the target concept.";
            case SOURCEBROADERTARGET: return "The source concept is broader in meaning than the target concept.";
            case NOTRELATEDTO: return "This is an explicit assertion that the target concept is not related to the source concept.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case RELATEDTO: return "Related To";
            case EQUIVALENT: return "Equivalent";
            case SOURCENARROWERTARGET: return "Source Is Narrower Than Target";
            case SOURCEBROADERTARGET: return "Source Is Broader Than Target";
            case NOTRELATEDTO: return "Not Related To";
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
          return ConceptMapRelationship.SOURCENARROWERTARGET;
        if ("broader".equals(codeString))
          return ConceptMapRelationship.SOURCENARROWERTARGET;
        if ("source-is-broader-than-target".equals(codeString))
          return ConceptMapRelationship.SOURCEBROADERTARGET;
        if ("narrower".equals(codeString))
          return ConceptMapRelationship.SOURCEBROADERTARGET;
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
          return new Enumeration<ConceptMapRelationship>(this, ConceptMapRelationship.SOURCENARROWERTARGET);
        if ("source-is-broader-than-target".equals(codeString))
          return new Enumeration<ConceptMapRelationship>(this, ConceptMapRelationship.SOURCEBROADERTARGET);
        if ("not-related-to".equals(codeString))
          return new Enumeration<ConceptMapRelationship>(this, ConceptMapRelationship.NOTRELATEDTO);
        throw new FHIRException("Unknown ConceptMapRelationship code '"+codeString+"'");
        }
    public String toCode(ConceptMapRelationship code) {
      if (code == ConceptMapRelationship.RELATEDTO)
        return "related-to";
      if (code == ConceptMapRelationship.EQUIVALENT)
        return "equivalent";
      if (code == ConceptMapRelationship.SOURCENARROWERTARGET)
        return "source-is-narrower-than-target";
      if (code == ConceptMapRelationship.SOURCEBROADERTARGET)
        return "source-is-broader-than-target";
      if (code == ConceptMapRelationship.NOTRELATEDTO)
        return "not-related-to";
      return "?";
      }
    public String toSystem(ConceptMapRelationship code) {
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
         * UDI Label name.
         */
        UDILABELNAME, 
        /**
         * User Friendly name.
         */
        USERFRIENDLYNAME, 
        /**
         * Patient Reported name.
         */
        PATIENTREPORTEDNAME, 
        /**
         * Manufacturer name.
         */
        MANUFACTURERNAME, 
        /**
         * Model name.
         */
        MODELNAME, 
        /**
         * other.
         */
        OTHER, 
        /**
         * added to help the parsers
         */
        NULL;
        public static DeviceNameType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("udi-label-name".equals(codeString))
          return UDILABELNAME;
        if ("user-friendly-name".equals(codeString))
          return USERFRIENDLYNAME;
        if ("patient-reported-name".equals(codeString))
          return PATIENTREPORTEDNAME;
        if ("manufacturer-name".equals(codeString))
          return MANUFACTURERNAME;
        if ("model-name".equals(codeString))
          return MODELNAME;
        if ("other".equals(codeString))
          return OTHER;
        throw new FHIRException("Unknown DeviceNameType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case UDILABELNAME: return "udi-label-name";
            case USERFRIENDLYNAME: return "user-friendly-name";
            case PATIENTREPORTEDNAME: return "patient-reported-name";
            case MANUFACTURERNAME: return "manufacturer-name";
            case MODELNAME: return "model-name";
            case OTHER: return "other";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case UDILABELNAME: return "http://hl7.org/fhir/device-nametype";
            case USERFRIENDLYNAME: return "http://hl7.org/fhir/device-nametype";
            case PATIENTREPORTEDNAME: return "http://hl7.org/fhir/device-nametype";
            case MANUFACTURERNAME: return "http://hl7.org/fhir/device-nametype";
            case MODELNAME: return "http://hl7.org/fhir/device-nametype";
            case OTHER: return "http://hl7.org/fhir/device-nametype";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case UDILABELNAME: return "UDI Label name.";
            case USERFRIENDLYNAME: return "User Friendly name.";
            case PATIENTREPORTEDNAME: return "Patient Reported name.";
            case MANUFACTURERNAME: return "Manufacturer name.";
            case MODELNAME: return "Model name.";
            case OTHER: return "other.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case UDILABELNAME: return "UDI Label name";
            case USERFRIENDLYNAME: return "User Friendly name";
            case PATIENTREPORTEDNAME: return "Patient Reported name";
            case MANUFACTURERNAME: return "Manufacturer name";
            case MODELNAME: return "Model name";
            case OTHER: return "other";
            default: return "?";
          }
        }
    }

  public static class DeviceNameTypeEnumFactory implements EnumFactory<DeviceNameType> {
    public DeviceNameType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("udi-label-name".equals(codeString))
          return DeviceNameType.UDILABELNAME;
        if ("user-friendly-name".equals(codeString))
          return DeviceNameType.USERFRIENDLYNAME;
        if ("patient-reported-name".equals(codeString))
          return DeviceNameType.PATIENTREPORTEDNAME;
        if ("manufacturer-name".equals(codeString))
          return DeviceNameType.MANUFACTURERNAME;
        if ("model-name".equals(codeString))
          return DeviceNameType.MODELNAME;
        if ("other".equals(codeString))
          return DeviceNameType.OTHER;
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
        if ("udi-label-name".equals(codeString))
          return new Enumeration<DeviceNameType>(this, DeviceNameType.UDILABELNAME);
        if ("user-friendly-name".equals(codeString))
          return new Enumeration<DeviceNameType>(this, DeviceNameType.USERFRIENDLYNAME);
        if ("patient-reported-name".equals(codeString))
          return new Enumeration<DeviceNameType>(this, DeviceNameType.PATIENTREPORTEDNAME);
        if ("manufacturer-name".equals(codeString))
          return new Enumeration<DeviceNameType>(this, DeviceNameType.MANUFACTURERNAME);
        if ("model-name".equals(codeString))
          return new Enumeration<DeviceNameType>(this, DeviceNameType.MODELNAME);
        if ("other".equals(codeString))
          return new Enumeration<DeviceNameType>(this, DeviceNameType.OTHER);
        throw new FHIRException("Unknown DeviceNameType code '"+codeString+"'");
        }
    public String toCode(DeviceNameType code) {
      if (code == DeviceNameType.UDILABELNAME)
        return "udi-label-name";
      if (code == DeviceNameType.USERFRIENDLYNAME)
        return "user-friendly-name";
      if (code == DeviceNameType.PATIENTREPORTEDNAME)
        return "patient-reported-name";
      if (code == DeviceNameType.MANUFACTURERNAME)
        return "manufacturer-name";
      if (code == DeviceNameType.MODELNAME)
        return "model-name";
      if (code == DeviceNameType.OTHER)
        return "other";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CURRENT: return "http://hl7.org/fhir/document-reference-status";
            case SUPERSEDED: return "http://hl7.org/fhir/document-reference-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/document-reference-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CURRENT: return "This is the current reference for this document.";
            case SUPERSEDED: return "This reference has been superseded by another reference.";
            case ENTEREDINERROR: return "This reference was created in error.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CURRENT: return "Current";
            case SUPERSEDED: return "Superseded";
            case ENTEREDINERROR: return "Entered in Error";
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

    public enum DocumentRelationshipType {
        /**
         * This document logically replaces or supersedes the target document.
         */
        REPLACES, 
        /**
         * This document was generated by transforming the target document (e.g. format or language conversion).
         */
        TRANSFORMS, 
        /**
         * This document is a signature of the target document.
         */
        SIGNS, 
        /**
         * This document adds additional information to the target document.
         */
        APPENDS, 
        /**
         * added to help the parsers
         */
        NULL;
        public static DocumentRelationshipType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("replaces".equals(codeString))
          return REPLACES;
        if ("transforms".equals(codeString))
          return TRANSFORMS;
        if ("signs".equals(codeString))
          return SIGNS;
        if ("appends".equals(codeString))
          return APPENDS;
        throw new FHIRException("Unknown DocumentRelationshipType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case REPLACES: return "replaces";
            case TRANSFORMS: return "transforms";
            case SIGNS: return "signs";
            case APPENDS: return "appends";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case REPLACES: return "http://hl7.org/fhir/document-relationship-type";
            case TRANSFORMS: return "http://hl7.org/fhir/document-relationship-type";
            case SIGNS: return "http://hl7.org/fhir/document-relationship-type";
            case APPENDS: return "http://hl7.org/fhir/document-relationship-type";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case REPLACES: return "This document logically replaces or supersedes the target document.";
            case TRANSFORMS: return "This document was generated by transforming the target document (e.g. format or language conversion).";
            case SIGNS: return "This document is a signature of the target document.";
            case APPENDS: return "This document adds additional information to the target document.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case REPLACES: return "Replaces";
            case TRANSFORMS: return "Transforms";
            case SIGNS: return "Signs";
            case APPENDS: return "Appends";
            default: return "?";
          }
        }
    }

  public static class DocumentRelationshipTypeEnumFactory implements EnumFactory<DocumentRelationshipType> {
    public DocumentRelationshipType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("replaces".equals(codeString))
          return DocumentRelationshipType.REPLACES;
        if ("transforms".equals(codeString))
          return DocumentRelationshipType.TRANSFORMS;
        if ("signs".equals(codeString))
          return DocumentRelationshipType.SIGNS;
        if ("appends".equals(codeString))
          return DocumentRelationshipType.APPENDS;
        throw new IllegalArgumentException("Unknown DocumentRelationshipType code '"+codeString+"'");
        }
        public Enumeration<DocumentRelationshipType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DocumentRelationshipType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("replaces".equals(codeString))
          return new Enumeration<DocumentRelationshipType>(this, DocumentRelationshipType.REPLACES);
        if ("transforms".equals(codeString))
          return new Enumeration<DocumentRelationshipType>(this, DocumentRelationshipType.TRANSFORMS);
        if ("signs".equals(codeString))
          return new Enumeration<DocumentRelationshipType>(this, DocumentRelationshipType.SIGNS);
        if ("appends".equals(codeString))
          return new Enumeration<DocumentRelationshipType>(this, DocumentRelationshipType.APPENDS);
        throw new FHIRException("Unknown DocumentRelationshipType code '"+codeString+"'");
        }
    public String toCode(DocumentRelationshipType code) {
      if (code == DocumentRelationshipType.REPLACES)
        return "replaces";
      if (code == DocumentRelationshipType.TRANSFORMS)
        return "transforms";
      if (code == DocumentRelationshipType.SIGNS)
        return "signs";
      if (code == DocumentRelationshipType.APPENDS)
        return "appends";
      return "?";
      }
    public String toSystem(DocumentRelationshipType code) {
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

    public enum FHIRAllTypes {
        /**
         * An address expressed using postal conventions (as opposed to GPS or other location definition formats).  This data type may be used to convey addresses for use in delivering mail as well as for visiting locations which might not be valid for mail delivery.  There are a variety of postal address formats defined around the world.
         */
        ADDRESS, 
        /**
         * A duration of time during which an organism (or a process) has existed.
         */
        AGE, 
        /**
         * A  text note which also  contains information about who made the statement and when.
         */
        ANNOTATION, 
        /**
         * For referring to data content defined in other formats.
         */
        ATTACHMENT, 
        /**
         * Base definition for all elements that are defined inside a resource - but not those in a data type.
         */
        BACKBONEELEMENT, 
        /**
         * Base definition for the few data types that are allowed to carry modifier extensions.
         */
        BACKBONETYPE, 
        /**
         * Base definition for all types defined in FHIR type system.
         */
        BASE, 
        /**
         * A concept that may be defined by a formal reference to a terminology or ontology or may be provided by text.
         */
        CODEABLECONCEPT, 
        /**
         * A reference to a resource (by instance), or instead, a reference to a cencept defined in a terminology or ontology (by class).
         */
        CODEABLEREFERENCE, 
        /**
         * A reference to a code defined by a terminology system.
         */
        CODING, 
        /**
         * Specifies contact information for a person or organization.
         */
        CONTACTDETAIL, 
        /**
         * Details for all kinds of technology mediated contact points for a person or organization, including telephone, email, etc.
         */
        CONTACTPOINT, 
        /**
         * A contributor to the content of a knowledge asset, including authors, editors, reviewers, and endorsers.
         */
        CONTRIBUTOR, 
        /**
         * A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.
         */
        COUNT, 
        /**
         * Describes a required data item for evaluation in terms of the type of data, and optional code or date-based filters of the data.
         */
        DATAREQUIREMENT, 
        /**
         * The base class for all re-useable types defined as part of the FHIR Specification.
         */
        DATATYPE, 
        /**
         * A length - a value with a unit that is a physical distance.
         */
        DISTANCE, 
        /**
         * Indicates how the medication is/was taken or should be taken by the patient.
         */
        DOSAGE, 
        /**
         * A length of time.
         */
        DURATION, 
        /**
         * Base definition for all elements in a resource.
         */
        ELEMENT, 
        /**
         * Captures constraints on each element within the resource, profile, or extension.
         */
        ELEMENTDEFINITION, 
        /**
         * A expression that is evaluated in a specified context and returns a value. The context of use of the expression must specify the context in which the expression is evaluated, and how the result of the expression is used.
         */
        EXPRESSION, 
        /**
         * Optional Extension Element - found in all resources.
         */
        EXTENSION, 
        /**
         * A human's name with the ability to identify parts and usage.
         */
        HUMANNAME, 
        /**
         * An identifier - identifies some entity uniquely and unambiguously. Typically this is used for business identifiers.
         */
        IDENTIFIER, 
        /**
         * The marketing status describes the date when a medicinal product is actually put on the market or the date as of which it is no longer available.
         */
        MARKETINGSTATUS, 
        /**
         * The metadata about a resource. This is content in the resource that is maintained by the infrastructure. Changes to the content might not always be associated with version changes to the resource.
         */
        META, 
        /**
         * An amount of economic utility in some recognized currency.
         */
        MONEY, 
        /**
         * null
         */
        MONEYQUANTITY, 
        /**
         * A human-readable summary of the resource conveying the essential clinical and business information for the resource.
         */
        NARRATIVE, 
        /**
         * An ordered list (distribution) of statistics.
         */
        ORDEREDDISTRIBUTION, 
        /**
         * The parameters to the module. This collection specifies both the input and output parameters. Input parameters are provided by the caller as part of the $evaluate operation. Output parameters are included in the GuidanceResponse.
         */
        PARAMETERDEFINITION, 
        /**
         * A time period defined by a start and end date and optionally time.
         */
        PERIOD, 
        /**
         * A populatioof people with some set of grouping criteria.
         */
        POPULATION, 
        /**
         * The base type for all re-useable types defined that have a simple property.
         */
        PRIMITIVETYPE, 
        /**
         * The marketing status describes the date when a medicinal product is actually put on the market or the date as of which it is no longer available.
         */
        PRODCHARACTERISTIC, 
        /**
         * The shelf-life and storage information for a medicinal product item or container can be described using this class.
         */
        PRODUCTSHELFLIFE, 
        /**
         * A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.
         */
        QUANTITY, 
        /**
         * A set of ordered Quantities defined by a low and high limit.
         */
        RANGE, 
        /**
         * A relationship of two Quantity values - expressed as a numerator and a denominator.
         */
        RATIO, 
        /**
         * A reference from one resource to another.
         */
        REFERENCE, 
        /**
         * Related artifacts such as additional documentation, justification, or bibliographic references.
         */
        RELATEDARTIFACT, 
        /**
         * A series of measurements taken by a device, with upper and lower limits. There may be more than one dimension in the data.
         */
        SAMPLEDDATA, 
        /**
         * A signature along with supporting context. The signature may be a digital signature that is cryptographic in nature, or some other signature acceptable to the domain. This other signature may be as simple as a graphical image representing a hand-written signature, or a signature ceremony Different signature approaches have different utilities.
         */
        SIGNATURE, 
        /**
         * null
         */
        SIMPLEQUANTITY, 
        /**
         * A fact or piece of data from a  study of a large quantity of numerical data.  A mathematical or quantified characteristic of a group of observations.
         */
        STATISTIC, 
        /**
         * Chemical substances are a single substance type whose primary defining element is the molecular structure. Chemical substances shall be defined on the basis of their complete covalent molecular structure; the presence of a salt (counter-ion) and/or solvates (water, alcohols) is also captured. Purity, grade, physical form or particle size are not taken into account in the definition of a chemical substance or in the assignment of a Substance ID.
         */
        SUBSTANCEAMOUNT, 
        /**
         * Specifies an event that may occur multiple times. Timing schedules are used to record when things are planned, expected or requested to occur. The most common usage is in dosage instructions for medications. They are also used when planning care of various kinds, and may be used for reporting the schedule to which past regular activities were carried out.
         */
        TIMING, 
        /**
         * A description of a triggering event. Triggering events can be named events, data events, or periodic, as determined by the type element.
         */
        TRIGGERDEFINITION, 
        /**
         * Specifies clinical/business/etc. metadata that can be used to retrieve, index and/or categorize an artifact. This metadata can either be specific to the applicable population (e.g., age category, DRG) or the specific context of care (e.g., venue, care setting, provider of care).
         */
        USAGECONTEXT, 
        /**
         * A stream of bytes
         */
        BASE64BINARY, 
        /**
         * Value of "true" or "false"
         */
        BOOLEAN, 
        /**
         * A URI that is a reference to a canonical URL on a FHIR resource
         */
        CANONICAL, 
        /**
         * A string which has at least one character and no leading or trailing whitespace and where there is no whitespace other than single spaces in the contents
         */
        CODE, 
        /**
         * A date or partial date (e.g. just year or year + month). There is no time zone. The format is a union of the schema types gYear, gYearMonth and date.  Dates SHALL be valid dates.
         */
        DATE, 
        /**
         * A date, date-time or partial date (e.g. just year or year + month).  If hours and minutes are specified, a time zone SHALL be populated. The format is a union of the schema types gYear, gYearMonth, date and dateTime. Seconds must be provided due to schema type constraints but may be zero-filled and may be ignored.                 Dates SHALL be valid dates.
         */
        DATETIME, 
        /**
         * A rational number with implicit precision
         */
        DECIMAL, 
        /**
         * Any combination of letters, numerals, "-" and ".", with a length limit of 64 characters.  (This might be an integer, an unprefixed OID, UUID or any other identifier pattern that meets these constraints.)  Ids are case-insensitive.
         */
        ID, 
        /**
         * An instant in time - known at least to the second
         */
        INSTANT, 
        /**
         * A whole number
         */
        INTEGER, 
        /**
         * A very large whole number
         */
        INTEGER64, 
        /**
         * A string that may contain Github Flavored Markdown syntax for optional processing by a mark down presentation engine
         */
        MARKDOWN, 
        /**
         * An OID represented as a URI
         */
        OID, 
        /**
         * An integer with a value that is positive (e.g. >0)
         */
        POSITIVEINT, 
        /**
         * A sequence of Unicode characters
         */
        STRING, 
        /**
         * A time during the day, with no date specified
         */
        TIME, 
        /**
         * An integer with a value that is not negative (e.g. >= 0)
         */
        UNSIGNEDINT, 
        /**
         * String of characters used to identify a name or a resource
         */
        URI, 
        /**
         * A URI that is a literal reference
         */
        URL, 
        /**
         * A UUID, represented as a URI
         */
        UUID, 
        /**
         * XHTML format, as defined by W3C, but restricted usage (mainly, no active content)
         */
        XHTML, 
        /**
         * A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.
         */
        ACCOUNT, 
        /**
         * This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.
         */
        ACTIVITYDEFINITION, 
        /**
         * A pharmaceutical product described in terms of its composition and dose form.
         */
        ADMINISTRABLEPRODUCTDEFINITION, 
        /**
         * An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject.  The unintended effects may require additional monitoring, treatment or hospitalization or may result in death.  The AdverseEvent resource also extends to potential or avoided events that could have had such effects.
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
         * A material substance originating from a biological entity intended to be transplanted or infused
into another (possibly the same) biological entity.
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
         * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        CAPABILITYSTATEMENT, 
        /**
         * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        CAPABILITYSTATEMENT2, 
        /**
         * Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.
         */
        CAREPLAN, 
        /**
         * The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.
         */
        CARETEAM, 
        /**
         * Catalog entries are wrappers that contextualize items included in a catalog.
         */
        CATALOGENTRY, 
        /**
         * The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.
         */
        CHARGEITEM, 
        /**
         * The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.
         */
        CHARGEITEMDEFINITION, 
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
         * A single usage issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.
         */
        CLINICALUSEISSUE, 
        /**
         * The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.
         */
        CODESYSTEM, 
        /**
         * An occurrence of information being transmitted; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.
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
         * A type of a manufactured item that is used in the provision of healthcare without being substantially changed through that activity. The device may be a medical or non-medical device.
         */
        DEVICE, 
        /**
         * The characteristics, operational status and capabilities of a medical-related component of a medical device.
         */
        DEVICEDEFINITION, 
        /**
         * Describes a measurement, calculation or setting capability of a medical device.
         */
        DEVICEMETRIC, 
        /**
         * Represents a request for a patient to employ a medical device. The device may be an implantable device, or an external assistive device, such as a walker.
         */
        DEVICEREQUEST, 
        /**
         * A record of a device being used by a patient where the record is the result of a report from the patient or another clinician.
         */
        DEVICEUSESTATEMENT, 
        /**
         * The findings and interpretation of diagnostic  tests performed on patients, groups of patients, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting and provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports.
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
         * An interaction between a patient and healthcare provider(s) for the purpose of providing healthcare service(s) or assessing the health status of a patient.
         */
        ENCOUNTER, 
        /**
         * The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b or a REST endpoint for another FHIR server. This may include any security context information.
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
         * This represents statistics, certainty, both the intended and actual population, and evidence variables.
         */
        EVIDENCE, 
        /**
         * The EvidenceVariable resource describes a "PICO" element that knowledge (evidence, assertion, recommendation) is about.
         */
        EVIDENCEVARIABLE, 
        /**
         * Example of workflow instance.
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
         * The details of a healthcare service available at a location.
         */
        HEALTHCARESERVICE, 
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
         * A list is a curated collection of resources.
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
         * This resource is primarily used for the identification and definition of a medication for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.
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
         * Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use).
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
         * Raw data describing a biological sequence.
         */
        MOLECULARSEQUENCE, 
        /**
         * A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a "System" used within the Identifier and Coding data types.
         */
        NAMINGSYSTEM, 
        /**
         * A record of food or fluid that is being consumed by a patient.   A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.
         */
        NUTRITIONINTAKE, 
        /**
         * A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.
         */
        NUTRITIONORDER, 
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
         * Defines an affiliation/assotiation/relationship between 2 distinct oganizations, that is not a part-of relationship/sub-division relationship.
         */
        ORGANIZATIONAFFILIATION, 
        /**
         * A medicinal product in a container or package.
         */
        PACKAGEDPRODUCTDEFINITION, 
        /**
         * This resource is a non-persisted resource used to pass information into and back from an [operation](operations.html). It has no other use, and there is no RESTful endpoint associated with it.
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
         * Demographics and administrative information about a person independent of a specific health-related context.
         */
        PERSON, 
        /**
         * This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical artifacts such as clinical decision support rules, order sets and protocols.
         */
        PLANDEFINITION, 
        /**
         * A person who is directly or indirectly involved in the provisioning of healthcare.
         */
        PRACTITIONER, 
        /**
         * A specific set of Roles/Locations/specialties/services that a practitioner may perform at an organization for a period of time.
         */
        PRACTITIONERROLE, 
        /**
         * An action that is or was performed on or for a patient. This can be a physical intervention like an operation, or less invasive like long term services, counseling, or hypnotherapy.
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
         * The regulatory authorization of a medicinal product.
         */
        REGULATEDAUTHORIZATION, 
        /**
         * Information about a person that is involved in the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.
         */
        RELATEDPERSON, 
        /**
         * A group of related requests that can be used to capture intended activities that have inter-dependencies such as "give this medication after that one".
         */
        REQUESTGROUP, 
        /**
         * A process where a researcher or organization plans and then executes a series of steps intended to increase the field of healthcare-related knowledge.  This includes studies of safety, efficacy, comparative effectiveness and other information about medications, devices, therapies and other interventional and investigative techniques.  A ResearchStudy involves the gathering of information about human or animal subjects.
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
         * The subscription resource describes a particular client's request to be notified about a Topic.
         */
        SUBSCRIPTION, 
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
         * Todo.
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
         * A record of a request for a medication, substance or device used in the healthcare setting.
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
         * Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.
         */
        TOPIC, 
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
         * A place holder that means any kind of data type
         */
        TYPE, 
        /**
         * A place holder that means any kind of resource
         */
        ANY, 
        /**
         * added to help the parsers
         */
        NULL;
        public static FHIRAllTypes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Address".equals(codeString))
          return ADDRESS;
        if ("Age".equals(codeString))
          return AGE;
        if ("Annotation".equals(codeString))
          return ANNOTATION;
        if ("Attachment".equals(codeString))
          return ATTACHMENT;
        if ("BackboneElement".equals(codeString))
          return BACKBONEELEMENT;
        if ("BackboneType".equals(codeString))
          return BACKBONETYPE;
        if ("Base".equals(codeString))
          return BASE;
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
        if ("Count".equals(codeString))
          return COUNT;
        if ("DataRequirement".equals(codeString))
          return DATAREQUIREMENT;
        if ("DataType".equals(codeString))
          return DATATYPE;
        if ("Distance".equals(codeString))
          return DISTANCE;
        if ("Dosage".equals(codeString))
          return DOSAGE;
        if ("Duration".equals(codeString))
          return DURATION;
        if ("Element".equals(codeString))
          return ELEMENT;
        if ("ElementDefinition".equals(codeString))
          return ELEMENTDEFINITION;
        if ("Expression".equals(codeString))
          return EXPRESSION;
        if ("Extension".equals(codeString))
          return EXTENSION;
        if ("HumanName".equals(codeString))
          return HUMANNAME;
        if ("Identifier".equals(codeString))
          return IDENTIFIER;
        if ("MarketingStatus".equals(codeString))
          return MARKETINGSTATUS;
        if ("Meta".equals(codeString))
          return META;
        if ("Money".equals(codeString))
          return MONEY;
        if ("MoneyQuantity".equals(codeString))
          return MONEYQUANTITY;
        if ("Narrative".equals(codeString))
          return NARRATIVE;
        if ("OrderedDistribution".equals(codeString))
          return ORDEREDDISTRIBUTION;
        if ("ParameterDefinition".equals(codeString))
          return PARAMETERDEFINITION;
        if ("Period".equals(codeString))
          return PERIOD;
        if ("Population".equals(codeString))
          return POPULATION;
        if ("PrimitiveType".equals(codeString))
          return PRIMITIVETYPE;
        if ("ProdCharacteristic".equals(codeString))
          return PRODCHARACTERISTIC;
        if ("ProductShelfLife".equals(codeString))
          return PRODUCTSHELFLIFE;
        if ("Quantity".equals(codeString))
          return QUANTITY;
        if ("Range".equals(codeString))
          return RANGE;
        if ("Ratio".equals(codeString))
          return RATIO;
        if ("Reference".equals(codeString))
          return REFERENCE;
        if ("RelatedArtifact".equals(codeString))
          return RELATEDARTIFACT;
        if ("SampledData".equals(codeString))
          return SAMPLEDDATA;
        if ("Signature".equals(codeString))
          return SIGNATURE;
        if ("SimpleQuantity".equals(codeString))
          return SIMPLEQUANTITY;
        if ("Statistic".equals(codeString))
          return STATISTIC;
        if ("SubstanceAmount".equals(codeString))
          return SUBSTANCEAMOUNT;
        if ("Timing".equals(codeString))
          return TIMING;
        if ("TriggerDefinition".equals(codeString))
          return TRIGGERDEFINITION;
        if ("UsageContext".equals(codeString))
          return USAGECONTEXT;
        if ("base64Binary".equals(codeString))
          return BASE64BINARY;
        if ("boolean".equals(codeString))
          return BOOLEAN;
        if ("canonical".equals(codeString))
          return CANONICAL;
        if ("code".equals(codeString))
          return CODE;
        if ("date".equals(codeString))
          return DATE;
        if ("dateTime".equals(codeString))
          return DATETIME;
        if ("decimal".equals(codeString))
          return DECIMAL;
        if ("id".equals(codeString))
          return ID;
        if ("instant".equals(codeString))
          return INSTANT;
        if ("integer".equals(codeString))
          return INTEGER;
        if ("integer64".equals(codeString))
          return INTEGER64;
        if ("markdown".equals(codeString))
          return MARKDOWN;
        if ("oid".equals(codeString))
          return OID;
        if ("positiveInt".equals(codeString))
          return POSITIVEINT;
        if ("string".equals(codeString))
          return STRING;
        if ("time".equals(codeString))
          return TIME;
        if ("unsignedInt".equals(codeString))
          return UNSIGNEDINT;
        if ("uri".equals(codeString))
          return URI;
        if ("url".equals(codeString))
          return URL;
        if ("uuid".equals(codeString))
          return UUID;
        if ("xhtml".equals(codeString))
          return XHTML;
        if ("Account".equals(codeString))
          return ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return ACTIVITYDEFINITION;
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
        if ("CapabilityStatement2".equals(codeString))
          return CAPABILITYSTATEMENT2;
        if ("CarePlan".equals(codeString))
          return CAREPLAN;
        if ("CareTeam".equals(codeString))
          return CARETEAM;
        if ("CatalogEntry".equals(codeString))
          return CATALOGENTRY;
        if ("ChargeItem".equals(codeString))
          return CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return CHARGEITEMDEFINITION;
        if ("Claim".equals(codeString))
          return CLAIM;
        if ("ClaimResponse".equals(codeString))
          return CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return CLINICALIMPRESSION;
        if ("ClinicalUseIssue".equals(codeString))
          return CLINICALUSEISSUE;
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
        if ("DeviceMetric".equals(codeString))
          return DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return DEVICEREQUEST;
        if ("DeviceUseStatement".equals(codeString))
          return DEVICEUSESTATEMENT;
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
        if ("RequestGroup".equals(codeString))
          return REQUESTGROUP;
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
        if ("Topic".equals(codeString))
          return TOPIC;
        if ("ValueSet".equals(codeString))
          return VALUESET;
        if ("VerificationResult".equals(codeString))
          return VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return VISIONPRESCRIPTION;
        if ("Type".equals(codeString))
          return TYPE;
        if ("Any".equals(codeString))
          return ANY;
        throw new FHIRException("Unknown FHIRAllTypes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ADDRESS: return "Address";
            case AGE: return "Age";
            case ANNOTATION: return "Annotation";
            case ATTACHMENT: return "Attachment";
            case BACKBONEELEMENT: return "BackboneElement";
            case BACKBONETYPE: return "BackboneType";
            case BASE: return "Base";
            case CODEABLECONCEPT: return "CodeableConcept";
            case CODEABLEREFERENCE: return "CodeableReference";
            case CODING: return "Coding";
            case CONTACTDETAIL: return "ContactDetail";
            case CONTACTPOINT: return "ContactPoint";
            case CONTRIBUTOR: return "Contributor";
            case COUNT: return "Count";
            case DATAREQUIREMENT: return "DataRequirement";
            case DATATYPE: return "DataType";
            case DISTANCE: return "Distance";
            case DOSAGE: return "Dosage";
            case DURATION: return "Duration";
            case ELEMENT: return "Element";
            case ELEMENTDEFINITION: return "ElementDefinition";
            case EXPRESSION: return "Expression";
            case EXTENSION: return "Extension";
            case HUMANNAME: return "HumanName";
            case IDENTIFIER: return "Identifier";
            case MARKETINGSTATUS: return "MarketingStatus";
            case META: return "Meta";
            case MONEY: return "Money";
            case MONEYQUANTITY: return "MoneyQuantity";
            case NARRATIVE: return "Narrative";
            case ORDEREDDISTRIBUTION: return "OrderedDistribution";
            case PARAMETERDEFINITION: return "ParameterDefinition";
            case PERIOD: return "Period";
            case POPULATION: return "Population";
            case PRIMITIVETYPE: return "PrimitiveType";
            case PRODCHARACTERISTIC: return "ProdCharacteristic";
            case PRODUCTSHELFLIFE: return "ProductShelfLife";
            case QUANTITY: return "Quantity";
            case RANGE: return "Range";
            case RATIO: return "Ratio";
            case REFERENCE: return "Reference";
            case RELATEDARTIFACT: return "RelatedArtifact";
            case SAMPLEDDATA: return "SampledData";
            case SIGNATURE: return "Signature";
            case SIMPLEQUANTITY: return "SimpleQuantity";
            case STATISTIC: return "Statistic";
            case SUBSTANCEAMOUNT: return "SubstanceAmount";
            case TIMING: return "Timing";
            case TRIGGERDEFINITION: return "TriggerDefinition";
            case USAGECONTEXT: return "UsageContext";
            case BASE64BINARY: return "base64Binary";
            case BOOLEAN: return "boolean";
            case CANONICAL: return "canonical";
            case CODE: return "code";
            case DATE: return "date";
            case DATETIME: return "dateTime";
            case DECIMAL: return "decimal";
            case ID: return "id";
            case INSTANT: return "instant";
            case INTEGER: return "integer";
            case INTEGER64: return "integer64";
            case MARKDOWN: return "markdown";
            case OID: return "oid";
            case POSITIVEINT: return "positiveInt";
            case STRING: return "string";
            case TIME: return "time";
            case UNSIGNEDINT: return "unsignedInt";
            case URI: return "uri";
            case URL: return "url";
            case UUID: return "uuid";
            case XHTML: return "xhtml";
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAPABILITYSTATEMENT2: return "CapabilityStatement2";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CATALOGENTRY: return "CatalogEntry";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEISSUE: return "ClinicalUseIssue";
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
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSESTATEMENT: return "DeviceUseStatement";
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
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
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
            case REQUESTGROUP: return "RequestGroup";
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
            case TOPIC: return "Topic";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            case TYPE: return "Type";
            case ANY: return "Any";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ADDRESS: return "http://hl7.org/fhir/data-types";
            case AGE: return "http://hl7.org/fhir/data-types";
            case ANNOTATION: return "http://hl7.org/fhir/data-types";
            case ATTACHMENT: return "http://hl7.org/fhir/data-types";
            case BACKBONEELEMENT: return "http://hl7.org/fhir/data-types";
            case BACKBONETYPE: return "http://hl7.org/fhir/data-types";
            case BASE: return "http://hl7.org/fhir/data-types";
            case CODEABLECONCEPT: return "http://hl7.org/fhir/data-types";
            case CODEABLEREFERENCE: return "http://hl7.org/fhir/data-types";
            case CODING: return "http://hl7.org/fhir/data-types";
            case CONTACTDETAIL: return "http://hl7.org/fhir/data-types";
            case CONTACTPOINT: return "http://hl7.org/fhir/data-types";
            case CONTRIBUTOR: return "http://hl7.org/fhir/data-types";
            case COUNT: return "http://hl7.org/fhir/data-types";
            case DATAREQUIREMENT: return "http://hl7.org/fhir/data-types";
            case DATATYPE: return "http://hl7.org/fhir/data-types";
            case DISTANCE: return "http://hl7.org/fhir/data-types";
            case DOSAGE: return "http://hl7.org/fhir/data-types";
            case DURATION: return "http://hl7.org/fhir/data-types";
            case ELEMENT: return "http://hl7.org/fhir/data-types";
            case ELEMENTDEFINITION: return "http://hl7.org/fhir/data-types";
            case EXPRESSION: return "http://hl7.org/fhir/data-types";
            case EXTENSION: return "http://hl7.org/fhir/data-types";
            case HUMANNAME: return "http://hl7.org/fhir/data-types";
            case IDENTIFIER: return "http://hl7.org/fhir/data-types";
            case MARKETINGSTATUS: return "http://hl7.org/fhir/data-types";
            case META: return "http://hl7.org/fhir/data-types";
            case MONEY: return "http://hl7.org/fhir/data-types";
            case MONEYQUANTITY: return "http://hl7.org/fhir/data-types";
            case NARRATIVE: return "http://hl7.org/fhir/data-types";
            case ORDEREDDISTRIBUTION: return "http://hl7.org/fhir/data-types";
            case PARAMETERDEFINITION: return "http://hl7.org/fhir/data-types";
            case PERIOD: return "http://hl7.org/fhir/data-types";
            case POPULATION: return "http://hl7.org/fhir/data-types";
            case PRIMITIVETYPE: return "http://hl7.org/fhir/data-types";
            case PRODCHARACTERISTIC: return "http://hl7.org/fhir/data-types";
            case PRODUCTSHELFLIFE: return "http://hl7.org/fhir/data-types";
            case QUANTITY: return "http://hl7.org/fhir/data-types";
            case RANGE: return "http://hl7.org/fhir/data-types";
            case RATIO: return "http://hl7.org/fhir/data-types";
            case REFERENCE: return "http://hl7.org/fhir/data-types";
            case RELATEDARTIFACT: return "http://hl7.org/fhir/data-types";
            case SAMPLEDDATA: return "http://hl7.org/fhir/data-types";
            case SIGNATURE: return "http://hl7.org/fhir/data-types";
            case SIMPLEQUANTITY: return "http://hl7.org/fhir/data-types";
            case STATISTIC: return "http://hl7.org/fhir/data-types";
            case SUBSTANCEAMOUNT: return "http://hl7.org/fhir/data-types";
            case TIMING: return "http://hl7.org/fhir/data-types";
            case TRIGGERDEFINITION: return "http://hl7.org/fhir/data-types";
            case USAGECONTEXT: return "http://hl7.org/fhir/data-types";
            case BASE64BINARY: return "http://hl7.org/fhir/data-types";
            case BOOLEAN: return "http://hl7.org/fhir/data-types";
            case CANONICAL: return "http://hl7.org/fhir/data-types";
            case CODE: return "http://hl7.org/fhir/data-types";
            case DATE: return "http://hl7.org/fhir/data-types";
            case DATETIME: return "http://hl7.org/fhir/data-types";
            case DECIMAL: return "http://hl7.org/fhir/data-types";
            case ID: return "http://hl7.org/fhir/data-types";
            case INSTANT: return "http://hl7.org/fhir/data-types";
            case INTEGER: return "http://hl7.org/fhir/data-types";
            case INTEGER64: return "http://hl7.org/fhir/data-types";
            case MARKDOWN: return "http://hl7.org/fhir/data-types";
            case OID: return "http://hl7.org/fhir/data-types";
            case POSITIVEINT: return "http://hl7.org/fhir/data-types";
            case STRING: return "http://hl7.org/fhir/data-types";
            case TIME: return "http://hl7.org/fhir/data-types";
            case UNSIGNEDINT: return "http://hl7.org/fhir/data-types";
            case URI: return "http://hl7.org/fhir/data-types";
            case URL: return "http://hl7.org/fhir/data-types";
            case UUID: return "http://hl7.org/fhir/data-types";
            case XHTML: return "http://hl7.org/fhir/data-types";
            case ACCOUNT: return "http://hl7.org/fhir/resource-types";
            case ACTIVITYDEFINITION: return "http://hl7.org/fhir/resource-types";
            case ADMINISTRABLEPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case ADVERSEEVENT: return "http://hl7.org/fhir/resource-types";
            case ALLERGYINTOLERANCE: return "http://hl7.org/fhir/resource-types";
            case APPOINTMENT: return "http://hl7.org/fhir/resource-types";
            case APPOINTMENTRESPONSE: return "http://hl7.org/fhir/resource-types";
            case AUDITEVENT: return "http://hl7.org/fhir/resource-types";
            case BASIC: return "http://hl7.org/fhir/resource-types";
            case BINARY: return "http://hl7.org/fhir/resource-types";
            case BIOLOGICALLYDERIVEDPRODUCT: return "http://hl7.org/fhir/resource-types";
            case BODYSTRUCTURE: return "http://hl7.org/fhir/resource-types";
            case BUNDLE: return "http://hl7.org/fhir/resource-types";
            case CAPABILITYSTATEMENT: return "http://hl7.org/fhir/resource-types";
            case CAPABILITYSTATEMENT2: return "http://hl7.org/fhir/resource-types";
            case CAREPLAN: return "http://hl7.org/fhir/resource-types";
            case CARETEAM: return "http://hl7.org/fhir/resource-types";
            case CATALOGENTRY: return "http://hl7.org/fhir/resource-types";
            case CHARGEITEM: return "http://hl7.org/fhir/resource-types";
            case CHARGEITEMDEFINITION: return "http://hl7.org/fhir/resource-types";
            case CLAIM: return "http://hl7.org/fhir/resource-types";
            case CLAIMRESPONSE: return "http://hl7.org/fhir/resource-types";
            case CLINICALIMPRESSION: return "http://hl7.org/fhir/resource-types";
            case CLINICALUSEISSUE: return "http://hl7.org/fhir/resource-types";
            case CODESYSTEM: return "http://hl7.org/fhir/resource-types";
            case COMMUNICATION: return "http://hl7.org/fhir/resource-types";
            case COMMUNICATIONREQUEST: return "http://hl7.org/fhir/resource-types";
            case COMPARTMENTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case COMPOSITION: return "http://hl7.org/fhir/resource-types";
            case CONCEPTMAP: return "http://hl7.org/fhir/resource-types";
            case CONDITION: return "http://hl7.org/fhir/resource-types";
            case CONDITIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case CONSENT: return "http://hl7.org/fhir/resource-types";
            case CONTRACT: return "http://hl7.org/fhir/resource-types";
            case COVERAGE: return "http://hl7.org/fhir/resource-types";
            case COVERAGEELIGIBILITYREQUEST: return "http://hl7.org/fhir/resource-types";
            case COVERAGEELIGIBILITYRESPONSE: return "http://hl7.org/fhir/resource-types";
            case DETECTEDISSUE: return "http://hl7.org/fhir/resource-types";
            case DEVICE: return "http://hl7.org/fhir/resource-types";
            case DEVICEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case DEVICEMETRIC: return "http://hl7.org/fhir/resource-types";
            case DEVICEREQUEST: return "http://hl7.org/fhir/resource-types";
            case DEVICEUSESTATEMENT: return "http://hl7.org/fhir/resource-types";
            case DIAGNOSTICREPORT: return "http://hl7.org/fhir/resource-types";
            case DOCUMENTMANIFEST: return "http://hl7.org/fhir/resource-types";
            case DOCUMENTREFERENCE: return "http://hl7.org/fhir/resource-types";
            case DOMAINRESOURCE: return "http://hl7.org/fhir/resource-types";
            case ENCOUNTER: return "http://hl7.org/fhir/resource-types";
            case ENDPOINT: return "http://hl7.org/fhir/resource-types";
            case ENROLLMENTREQUEST: return "http://hl7.org/fhir/resource-types";
            case ENROLLMENTRESPONSE: return "http://hl7.org/fhir/resource-types";
            case EPISODEOFCARE: return "http://hl7.org/fhir/resource-types";
            case EVENTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case EVIDENCE: return "http://hl7.org/fhir/resource-types";
            case EVIDENCEVARIABLE: return "http://hl7.org/fhir/resource-types";
            case EXAMPLESCENARIO: return "http://hl7.org/fhir/resource-types";
            case EXPLANATIONOFBENEFIT: return "http://hl7.org/fhir/resource-types";
            case FAMILYMEMBERHISTORY: return "http://hl7.org/fhir/resource-types";
            case FLAG: return "http://hl7.org/fhir/resource-types";
            case GOAL: return "http://hl7.org/fhir/resource-types";
            case GRAPHDEFINITION: return "http://hl7.org/fhir/resource-types";
            case GROUP: return "http://hl7.org/fhir/resource-types";
            case GUIDANCERESPONSE: return "http://hl7.org/fhir/resource-types";
            case HEALTHCARESERVICE: return "http://hl7.org/fhir/resource-types";
            case IMAGINGSTUDY: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATION: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATIONEVALUATION: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATIONRECOMMENDATION: return "http://hl7.org/fhir/resource-types";
            case IMPLEMENTATIONGUIDE: return "http://hl7.org/fhir/resource-types";
            case INGREDIENT: return "http://hl7.org/fhir/resource-types";
            case INSURANCEPLAN: return "http://hl7.org/fhir/resource-types";
            case INVOICE: return "http://hl7.org/fhir/resource-types";
            case LIBRARY: return "http://hl7.org/fhir/resource-types";
            case LINKAGE: return "http://hl7.org/fhir/resource-types";
            case LIST: return "http://hl7.org/fhir/resource-types";
            case LOCATION: return "http://hl7.org/fhir/resource-types";
            case MANUFACTUREDITEMDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MEASURE: return "http://hl7.org/fhir/resource-types";
            case MEASUREREPORT: return "http://hl7.org/fhir/resource-types";
            case MEDICATION: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONADMINISTRATION: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONDISPENSE: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONKNOWLEDGE: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONREQUEST: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONUSAGE: return "http://hl7.org/fhir/resource-types";
            case MEDICINALPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MESSAGEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MESSAGEHEADER: return "http://hl7.org/fhir/resource-types";
            case MOLECULARSEQUENCE: return "http://hl7.org/fhir/resource-types";
            case NAMINGSYSTEM: return "http://hl7.org/fhir/resource-types";
            case NUTRITIONINTAKE: return "http://hl7.org/fhir/resource-types";
            case NUTRITIONORDER: return "http://hl7.org/fhir/resource-types";
            case OBSERVATION: return "http://hl7.org/fhir/resource-types";
            case OBSERVATIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case OPERATIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case OPERATIONOUTCOME: return "http://hl7.org/fhir/resource-types";
            case ORGANIZATION: return "http://hl7.org/fhir/resource-types";
            case ORGANIZATIONAFFILIATION: return "http://hl7.org/fhir/resource-types";
            case PACKAGEDPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case PARAMETERS: return "http://hl7.org/fhir/resource-types";
            case PATIENT: return "http://hl7.org/fhir/resource-types";
            case PAYMENTNOTICE: return "http://hl7.org/fhir/resource-types";
            case PAYMENTRECONCILIATION: return "http://hl7.org/fhir/resource-types";
            case PERSON: return "http://hl7.org/fhir/resource-types";
            case PLANDEFINITION: return "http://hl7.org/fhir/resource-types";
            case PRACTITIONER: return "http://hl7.org/fhir/resource-types";
            case PRACTITIONERROLE: return "http://hl7.org/fhir/resource-types";
            case PROCEDURE: return "http://hl7.org/fhir/resource-types";
            case PROVENANCE: return "http://hl7.org/fhir/resource-types";
            case QUESTIONNAIRE: return "http://hl7.org/fhir/resource-types";
            case QUESTIONNAIRERESPONSE: return "http://hl7.org/fhir/resource-types";
            case REGULATEDAUTHORIZATION: return "http://hl7.org/fhir/resource-types";
            case RELATEDPERSON: return "http://hl7.org/fhir/resource-types";
            case REQUESTGROUP: return "http://hl7.org/fhir/resource-types";
            case RESEARCHSTUDY: return "http://hl7.org/fhir/resource-types";
            case RESEARCHSUBJECT: return "http://hl7.org/fhir/resource-types";
            case RESOURCE: return "http://hl7.org/fhir/resource-types";
            case RISKASSESSMENT: return "http://hl7.org/fhir/resource-types";
            case SCHEDULE: return "http://hl7.org/fhir/resource-types";
            case SEARCHPARAMETER: return "http://hl7.org/fhir/resource-types";
            case SERVICEREQUEST: return "http://hl7.org/fhir/resource-types";
            case SLOT: return "http://hl7.org/fhir/resource-types";
            case SPECIMEN: return "http://hl7.org/fhir/resource-types";
            case SPECIMENDEFINITION: return "http://hl7.org/fhir/resource-types";
            case STRUCTUREDEFINITION: return "http://hl7.org/fhir/resource-types";
            case STRUCTUREMAP: return "http://hl7.org/fhir/resource-types";
            case SUBSCRIPTION: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCE: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCENUCLEICACID: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEPOLYMER: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEPROTEIN: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEREFERENCEINFORMATION: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCESOURCEMATERIAL: return "http://hl7.org/fhir/resource-types";
            case SUPPLYDELIVERY: return "http://hl7.org/fhir/resource-types";
            case SUPPLYREQUEST: return "http://hl7.org/fhir/resource-types";
            case TASK: return "http://hl7.org/fhir/resource-types";
            case TERMINOLOGYCAPABILITIES: return "http://hl7.org/fhir/resource-types";
            case TESTREPORT: return "http://hl7.org/fhir/resource-types";
            case TESTSCRIPT: return "http://hl7.org/fhir/resource-types";
            case TOPIC: return "http://hl7.org/fhir/resource-types";
            case VALUESET: return "http://hl7.org/fhir/resource-types";
            case VERIFICATIONRESULT: return "http://hl7.org/fhir/resource-types";
            case VISIONPRESCRIPTION: return "http://hl7.org/fhir/resource-types";
            case TYPE: return "http://hl7.org/fhir/abstract-types";
            case ANY: return "http://hl7.org/fhir/abstract-types";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ADDRESS: return "An address expressed using postal conventions (as opposed to GPS or other location definition formats).  This data type may be used to convey addresses for use in delivering mail as well as for visiting locations which might not be valid for mail delivery.  There are a variety of postal address formats defined around the world.";
            case AGE: return "A duration of time during which an organism (or a process) has existed.";
            case ANNOTATION: return "A  text note which also  contains information about who made the statement and when.";
            case ATTACHMENT: return "For referring to data content defined in other formats.";
            case BACKBONEELEMENT: return "Base definition for all elements that are defined inside a resource - but not those in a data type.";
            case BACKBONETYPE: return "Base definition for the few data types that are allowed to carry modifier extensions.";
            case BASE: return "Base definition for all types defined in FHIR type system.";
            case CODEABLECONCEPT: return "A concept that may be defined by a formal reference to a terminology or ontology or may be provided by text.";
            case CODEABLEREFERENCE: return "A reference to a resource (by instance), or instead, a reference to a cencept defined in a terminology or ontology (by class).";
            case CODING: return "A reference to a code defined by a terminology system.";
            case CONTACTDETAIL: return "Specifies contact information for a person or organization.";
            case CONTACTPOINT: return "Details for all kinds of technology mediated contact points for a person or organization, including telephone, email, etc.";
            case CONTRIBUTOR: return "A contributor to the content of a knowledge asset, including authors, editors, reviewers, and endorsers.";
            case COUNT: return "A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.";
            case DATAREQUIREMENT: return "Describes a required data item for evaluation in terms of the type of data, and optional code or date-based filters of the data.";
            case DATATYPE: return "The base class for all re-useable types defined as part of the FHIR Specification.";
            case DISTANCE: return "A length - a value with a unit that is a physical distance.";
            case DOSAGE: return "Indicates how the medication is/was taken or should be taken by the patient.";
            case DURATION: return "A length of time.";
            case ELEMENT: return "Base definition for all elements in a resource.";
            case ELEMENTDEFINITION: return "Captures constraints on each element within the resource, profile, or extension.";
            case EXPRESSION: return "A expression that is evaluated in a specified context and returns a value. The context of use of the expression must specify the context in which the expression is evaluated, and how the result of the expression is used.";
            case EXTENSION: return "Optional Extension Element - found in all resources.";
            case HUMANNAME: return "A human's name with the ability to identify parts and usage.";
            case IDENTIFIER: return "An identifier - identifies some entity uniquely and unambiguously. Typically this is used for business identifiers.";
            case MARKETINGSTATUS: return "The marketing status describes the date when a medicinal product is actually put on the market or the date as of which it is no longer available.";
            case META: return "The metadata about a resource. This is content in the resource that is maintained by the infrastructure. Changes to the content might not always be associated with version changes to the resource.";
            case MONEY: return "An amount of economic utility in some recognized currency.";
            case MONEYQUANTITY: return "";
            case NARRATIVE: return "A human-readable summary of the resource conveying the essential clinical and business information for the resource.";
            case ORDEREDDISTRIBUTION: return "An ordered list (distribution) of statistics.";
            case PARAMETERDEFINITION: return "The parameters to the module. This collection specifies both the input and output parameters. Input parameters are provided by the caller as part of the $evaluate operation. Output parameters are included in the GuidanceResponse.";
            case PERIOD: return "A time period defined by a start and end date and optionally time.";
            case POPULATION: return "A populatioof people with some set of grouping criteria.";
            case PRIMITIVETYPE: return "The base type for all re-useable types defined that have a simple property.";
            case PRODCHARACTERISTIC: return "The marketing status describes the date when a medicinal product is actually put on the market or the date as of which it is no longer available.";
            case PRODUCTSHELFLIFE: return "The shelf-life and storage information for a medicinal product item or container can be described using this class.";
            case QUANTITY: return "A measured amount (or an amount that can potentially be measured). Note that measured amounts include amounts that are not precisely quantified, including amounts involving arbitrary units and floating currencies.";
            case RANGE: return "A set of ordered Quantities defined by a low and high limit.";
            case RATIO: return "A relationship of two Quantity values - expressed as a numerator and a denominator.";
            case REFERENCE: return "A reference from one resource to another.";
            case RELATEDARTIFACT: return "Related artifacts such as additional documentation, justification, or bibliographic references.";
            case SAMPLEDDATA: return "A series of measurements taken by a device, with upper and lower limits. There may be more than one dimension in the data.";
            case SIGNATURE: return "A signature along with supporting context. The signature may be a digital signature that is cryptographic in nature, or some other signature acceptable to the domain. This other signature may be as simple as a graphical image representing a hand-written signature, or a signature ceremony Different signature approaches have different utilities.";
            case SIMPLEQUANTITY: return "";
            case STATISTIC: return "A fact or piece of data from a  study of a large quantity of numerical data.  A mathematical or quantified characteristic of a group of observations.";
            case SUBSTANCEAMOUNT: return "Chemical substances are a single substance type whose primary defining element is the molecular structure. Chemical substances shall be defined on the basis of their complete covalent molecular structure; the presence of a salt (counter-ion) and/or solvates (water, alcohols) is also captured. Purity, grade, physical form or particle size are not taken into account in the definition of a chemical substance or in the assignment of a Substance ID.";
            case TIMING: return "Specifies an event that may occur multiple times. Timing schedules are used to record when things are planned, expected or requested to occur. The most common usage is in dosage instructions for medications. They are also used when planning care of various kinds, and may be used for reporting the schedule to which past regular activities were carried out.";
            case TRIGGERDEFINITION: return "A description of a triggering event. Triggering events can be named events, data events, or periodic, as determined by the type element.";
            case USAGECONTEXT: return "Specifies clinical/business/etc. metadata that can be used to retrieve, index and/or categorize an artifact. This metadata can either be specific to the applicable population (e.g., age category, DRG) or the specific context of care (e.g., venue, care setting, provider of care).";
            case BASE64BINARY: return "A stream of bytes";
            case BOOLEAN: return "Value of \"true\" or \"false\"";
            case CANONICAL: return "A URI that is a reference to a canonical URL on a FHIR resource";
            case CODE: return "A string which has at least one character and no leading or trailing whitespace and where there is no whitespace other than single spaces in the contents";
            case DATE: return "A date or partial date (e.g. just year or year + month). There is no time zone. The format is a union of the schema types gYear, gYearMonth and date.  Dates SHALL be valid dates.";
            case DATETIME: return "A date, date-time or partial date (e.g. just year or year + month).  If hours and minutes are specified, a time zone SHALL be populated. The format is a union of the schema types gYear, gYearMonth, date and dateTime. Seconds must be provided due to schema type constraints but may be zero-filled and may be ignored.                 Dates SHALL be valid dates.";
            case DECIMAL: return "A rational number with implicit precision";
            case ID: return "Any combination of letters, numerals, \"-\" and \".\", with a length limit of 64 characters.  (This might be an integer, an unprefixed OID, UUID or any other identifier pattern that meets these constraints.)  Ids are case-insensitive.";
            case INSTANT: return "An instant in time - known at least to the second";
            case INTEGER: return "A whole number";
            case INTEGER64: return "A very large whole number";
            case MARKDOWN: return "A string that may contain Github Flavored Markdown syntax for optional processing by a mark down presentation engine";
            case OID: return "An OID represented as a URI";
            case POSITIVEINT: return "An integer with a value that is positive (e.g. >0)";
            case STRING: return "A sequence of Unicode characters";
            case TIME: return "A time during the day, with no date specified";
            case UNSIGNEDINT: return "An integer with a value that is not negative (e.g. >= 0)";
            case URI: return "String of characters used to identify a name or a resource";
            case URL: return "A URI that is a literal reference";
            case UUID: return "A UUID, represented as a URI";
            case XHTML: return "XHTML format, as defined by W3C, but restricted usage (mainly, no active content)";
            case ACCOUNT: return "A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.";
            case ACTIVITYDEFINITION: return "This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.";
            case ADMINISTRABLEPRODUCTDEFINITION: return "A pharmaceutical product described in terms of its composition and dose form.";
            case ADVERSEEVENT: return "An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject.  The unintended effects may require additional monitoring, treatment or hospitalization or may result in death.  The AdverseEvent resource also extends to potential or avoided events that could have had such effects.";
            case ALLERGYINTOLERANCE: return "Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.";
            case APPOINTMENT: return "A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).";
            case APPOINTMENTRESPONSE: return "A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.";
            case AUDITEVENT: return "A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.";
            case BASIC: return "Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.";
            case BINARY: return "A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.";
            case BIOLOGICALLYDERIVEDPRODUCT: return "A material substance originating from a biological entity intended to be transplanted or infused\ninto another (possibly the same) biological entity.";
            case BODYSTRUCTURE: return "Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.";
            case BUNDLE: return "A container for a collection of resources.";
            case CAPABILITYSTATEMENT: return "A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case CAPABILITYSTATEMENT2: return "A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case CAREPLAN: return "Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.";
            case CARETEAM: return "The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.";
            case CATALOGENTRY: return "Catalog entries are wrappers that contextualize items included in a catalog.";
            case CHARGEITEM: return "The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.";
            case CHARGEITEMDEFINITION: return "The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.";
            case CLAIM: return "A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.";
            case CLAIMRESPONSE: return "This resource provides the adjudication details from the processing of a Claim resource.";
            case CLINICALIMPRESSION: return "A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called \"ClinicalImpression\" rather than \"ClinicalAssessment\" to avoid confusion with the recording of assessment tools such as Apgar score.";
            case CLINICALUSEISSUE: return "A single usage issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.";
            case CODESYSTEM: return "The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.";
            case COMMUNICATION: return "An occurrence of information being transmitted; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.";
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
            case DEVICE: return "A type of a manufactured item that is used in the provision of healthcare without being substantially changed through that activity. The device may be a medical or non-medical device.";
            case DEVICEDEFINITION: return "The characteristics, operational status and capabilities of a medical-related component of a medical device.";
            case DEVICEMETRIC: return "Describes a measurement, calculation or setting capability of a medical device.";
            case DEVICEREQUEST: return "Represents a request for a patient to employ a medical device. The device may be an implantable device, or an external assistive device, such as a walker.";
            case DEVICEUSESTATEMENT: return "A record of a device being used by a patient where the record is the result of a report from the patient or another clinician.";
            case DIAGNOSTICREPORT: return "The findings and interpretation of diagnostic  tests performed on patients, groups of patients, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting and provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports.";
            case DOCUMENTMANIFEST: return "A collection of documents compiled for a purpose together with metadata that applies to the collection.";
            case DOCUMENTREFERENCE: return "A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this \"document\" encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.";
            case DOMAINRESOURCE: return "A resource that includes narrative, extensions, and contained resources.";
            case ENCOUNTER: return "An interaction between a patient and healthcare provider(s) for the purpose of providing healthcare service(s) or assessing the health status of a patient.";
            case ENDPOINT: return "The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b or a REST endpoint for another FHIR server. This may include any security context information.";
            case ENROLLMENTREQUEST: return "This resource provides the insurance enrollment details to the insurer regarding a specified coverage.";
            case ENROLLMENTRESPONSE: return "This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.";
            case EPISODEOFCARE: return "An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.";
            case EVENTDEFINITION: return "The EventDefinition resource provides a reusable description of when a particular event can occur.";
            case EVIDENCE: return "This represents statistics, certainty, both the intended and actual population, and evidence variables.";
            case EVIDENCEVARIABLE: return "The EvidenceVariable resource describes a \"PICO\" element that knowledge (evidence, assertion, recommendation) is about.";
            case EXAMPLESCENARIO: return "Example of workflow instance.";
            case EXPLANATIONOFBENEFIT: return "This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.";
            case FAMILYMEMBERHISTORY: return "Significant health conditions for a person related to the patient relevant in the context of care for the patient.";
            case FLAG: return "Prospective warnings of potential issues when providing care to the patient.";
            case GOAL: return "Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.";
            case GRAPHDEFINITION: return "A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.";
            case GROUP: return "Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.";
            case GUIDANCERESPONSE: return "A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.";
            case HEALTHCARESERVICE: return "The details of a healthcare service available at a location.";
            case IMAGINGSTUDY: return "Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.";
            case IMMUNIZATION: return "Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.";
            case IMMUNIZATIONEVALUATION: return "Describes a comparison of an immunization event against published recommendations to determine if the administration is \"valid\" in relation to those  recommendations.";
            case IMMUNIZATIONRECOMMENDATION: return "A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.";
            case IMPLEMENTATIONGUIDE: return "A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.";
            case INGREDIENT: return "An ingredient of a manufactured item or pharmaceutical product.";
            case INSURANCEPLAN: return "Details of a Health Insurance product/plan provided by an organization.";
            case INVOICE: return "Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.";
            case LIBRARY: return "The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.";
            case LINKAGE: return "Identifies two or more records (resource instances) that refer to the same real-world \"occurrence\".";
            case LIST: return "A list is a curated collection of resources.";
            case LOCATION: return "Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.";
            case MANUFACTUREDITEMDEFINITION: return "The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.";
            case MEASURE: return "The Measure resource provides the definition of a quality measure.";
            case MEASUREREPORT: return "The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.";
            case MEDICATION: return "This resource is primarily used for the identification and definition of a medication for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.";
            case MEDICATIONADMINISTRATION: return "Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.";
            case MEDICATIONDISPENSE: return "Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.";
            case MEDICATIONKNOWLEDGE: return "Information about a medication that is used to support knowledge.";
            case MEDICATIONREQUEST: return "An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called \"MedicationRequest\" rather than \"MedicationPrescription\" or \"MedicationOrder\" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.";
            case MEDICATIONUSAGE: return "A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. \n\nThe primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.";
            case MEDICINALPRODUCTDEFINITION: return "Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use).";
            case MESSAGEDEFINITION: return "Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.";
            case MESSAGEHEADER: return "The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.";
            case MOLECULARSEQUENCE: return "Raw data describing a biological sequence.";
            case NAMINGSYSTEM: return "A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a \"System\" used within the Identifier and Coding data types.";
            case NUTRITIONINTAKE: return "A record of food or fluid that is being consumed by a patient.   A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.";
            case NUTRITIONORDER: return "A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.";
            case OBSERVATION: return "Measurements and simple assertions made about a patient, device or other subject.";
            case OBSERVATIONDEFINITION: return "Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.";
            case OPERATIONDEFINITION: return "A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).";
            case OPERATIONOUTCOME: return "A collection of error, warning, or information messages that result from a system action.";
            case ORGANIZATION: return "A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.";
            case ORGANIZATIONAFFILIATION: return "Defines an affiliation/assotiation/relationship between 2 distinct oganizations, that is not a part-of relationship/sub-division relationship.";
            case PACKAGEDPRODUCTDEFINITION: return "A medicinal product in a container or package.";
            case PARAMETERS: return "This resource is a non-persisted resource used to pass information into and back from an [operation](operations.html). It has no other use, and there is no RESTful endpoint associated with it.";
            case PATIENT: return "Demographics and other administrative information about an individual or animal receiving care or other health-related services.";
            case PAYMENTNOTICE: return "This resource provides the status of the payment for goods and services rendered, and the request and response resource references.";
            case PAYMENTRECONCILIATION: return "This resource provides the details including amount of a payment and allocates the payment items being paid.";
            case PERSON: return "Demographics and administrative information about a person independent of a specific health-related context.";
            case PLANDEFINITION: return "This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical artifacts such as clinical decision support rules, order sets and protocols.";
            case PRACTITIONER: return "A person who is directly or indirectly involved in the provisioning of healthcare.";
            case PRACTITIONERROLE: return "A specific set of Roles/Locations/specialties/services that a practitioner may perform at an organization for a period of time.";
            case PROCEDURE: return "An action that is or was performed on or for a patient. This can be a physical intervention like an operation, or less invasive like long term services, counseling, or hypnotherapy.";
            case PROVENANCE: return "Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.";
            case QUESTIONNAIRE: return "A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.";
            case QUESTIONNAIRERESPONSE: return "A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.";
            case REGULATEDAUTHORIZATION: return "The regulatory authorization of a medicinal product.";
            case RELATEDPERSON: return "Information about a person that is involved in the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.";
            case REQUESTGROUP: return "A group of related requests that can be used to capture intended activities that have inter-dependencies such as \"give this medication after that one\".";
            case RESEARCHSTUDY: return "A process where a researcher or organization plans and then executes a series of steps intended to increase the field of healthcare-related knowledge.  This includes studies of safety, efficacy, comparative effectiveness and other information about medications, devices, therapies and other interventional and investigative techniques.  A ResearchStudy involves the gathering of information about human or animal subjects.";
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
            case SUBSCRIPTION: return "The subscription resource describes a particular client's request to be notified about a Topic.";
            case SUBSTANCE: return "A homogeneous material with a definite composition.";
            case SUBSTANCEDEFINITION: return "The detailed description of a substance, typically at a level beyond what is used for prescribing.";
            case SUBSTANCENUCLEICACID: return "Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.";
            case SUBSTANCEPOLYMER: return "Todo.";
            case SUBSTANCEPROTEIN: return "A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.";
            case SUBSTANCEREFERENCEINFORMATION: return "Todo.";
            case SUBSTANCESOURCEMATERIAL: return "Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.";
            case SUPPLYDELIVERY: return "Record of delivery of what is supplied.";
            case SUPPLYREQUEST: return "A record of a request for a medication, substance or device used in the healthcare setting.";
            case TASK: return "A task to be performed.";
            case TERMINOLOGYCAPABILITIES: return "A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case TESTREPORT: return "A summary of information based on the results of executing a TestScript.";
            case TESTSCRIPT: return "A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.";
            case TOPIC: return "Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.";
            case VALUESET: return "A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).";
            case VERIFICATIONRESULT: return "Describes validation requirements, source(s), status and dates for one or more elements.";
            case VISIONPRESCRIPTION: return "An authorization for the provision of glasses and/or contact lenses to a patient.";
            case TYPE: return "A place holder that means any kind of data type";
            case ANY: return "A place holder that means any kind of resource";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ADDRESS: return "Address";
            case AGE: return "Age";
            case ANNOTATION: return "Annotation";
            case ATTACHMENT: return "Attachment";
            case BACKBONEELEMENT: return "BackboneElement";
            case BACKBONETYPE: return "BackboneType";
            case BASE: return "Base";
            case CODEABLECONCEPT: return "CodeableConcept";
            case CODEABLEREFERENCE: return "CodeableReference";
            case CODING: return "Coding";
            case CONTACTDETAIL: return "ContactDetail";
            case CONTACTPOINT: return "ContactPoint";
            case CONTRIBUTOR: return "Contributor";
            case COUNT: return "Count";
            case DATAREQUIREMENT: return "DataRequirement";
            case DATATYPE: return "DataType";
            case DISTANCE: return "Distance";
            case DOSAGE: return "Dosage";
            case DURATION: return "Duration";
            case ELEMENT: return "Element";
            case ELEMENTDEFINITION: return "ElementDefinition";
            case EXPRESSION: return "Expression";
            case EXTENSION: return "Extension";
            case HUMANNAME: return "HumanName";
            case IDENTIFIER: return "Identifier";
            case MARKETINGSTATUS: return "MarketingStatus";
            case META: return "Meta";
            case MONEY: return "Money";
            case MONEYQUANTITY: return "MoneyQuantity";
            case NARRATIVE: return "Narrative";
            case ORDEREDDISTRIBUTION: return "OrderedDistribution";
            case PARAMETERDEFINITION: return "ParameterDefinition";
            case PERIOD: return "Period";
            case POPULATION: return "Population";
            case PRIMITIVETYPE: return "PrimitiveType";
            case PRODCHARACTERISTIC: return "ProdCharacteristic";
            case PRODUCTSHELFLIFE: return "ProductShelfLife";
            case QUANTITY: return "Quantity";
            case RANGE: return "Range";
            case RATIO: return "Ratio";
            case REFERENCE: return "Reference";
            case RELATEDARTIFACT: return "RelatedArtifact";
            case SAMPLEDDATA: return "SampledData";
            case SIGNATURE: return "Signature";
            case SIMPLEQUANTITY: return "SimpleQuantity";
            case STATISTIC: return "Statistic";
            case SUBSTANCEAMOUNT: return "SubstanceAmount";
            case TIMING: return "Timing";
            case TRIGGERDEFINITION: return "TriggerDefinition";
            case USAGECONTEXT: return "UsageContext";
            case BASE64BINARY: return "base64Binary";
            case BOOLEAN: return "boolean";
            case CANONICAL: return "canonical";
            case CODE: return "code";
            case DATE: return "date";
            case DATETIME: return "dateTime";
            case DECIMAL: return "decimal";
            case ID: return "id";
            case INSTANT: return "instant";
            case INTEGER: return "integer";
            case INTEGER64: return "integer64";
            case MARKDOWN: return "markdown";
            case OID: return "oid";
            case POSITIVEINT: return "positiveInt";
            case STRING: return "string";
            case TIME: return "time";
            case UNSIGNEDINT: return "unsignedInt";
            case URI: return "uri";
            case URL: return "url";
            case UUID: return "uuid";
            case XHTML: return "XHTML";
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAPABILITYSTATEMENT2: return "CapabilityStatement2";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CATALOGENTRY: return "CatalogEntry";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEISSUE: return "ClinicalUseIssue";
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
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSESTATEMENT: return "DeviceUseStatement";
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
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
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
            case REQUESTGROUP: return "RequestGroup";
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
            case TOPIC: return "Topic";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            case TYPE: return "Type";
            case ANY: return "Any";
            default: return "?";
          }
        }
    }

  public static class FHIRAllTypesEnumFactory implements EnumFactory<FHIRAllTypes> {
    public FHIRAllTypes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Address".equals(codeString))
          return FHIRAllTypes.ADDRESS;
        if ("Age".equals(codeString))
          return FHIRAllTypes.AGE;
        if ("Annotation".equals(codeString))
          return FHIRAllTypes.ANNOTATION;
        if ("Attachment".equals(codeString))
          return FHIRAllTypes.ATTACHMENT;
        if ("BackboneElement".equals(codeString))
          return FHIRAllTypes.BACKBONEELEMENT;
        if ("BackboneType".equals(codeString))
          return FHIRAllTypes.BACKBONETYPE;
        if ("Base".equals(codeString))
          return FHIRAllTypes.BASE;
        if ("CodeableConcept".equals(codeString))
          return FHIRAllTypes.CODEABLECONCEPT;
        if ("CodeableReference".equals(codeString))
          return FHIRAllTypes.CODEABLEREFERENCE;
        if ("Coding".equals(codeString))
          return FHIRAllTypes.CODING;
        if ("ContactDetail".equals(codeString))
          return FHIRAllTypes.CONTACTDETAIL;
        if ("ContactPoint".equals(codeString))
          return FHIRAllTypes.CONTACTPOINT;
        if ("Contributor".equals(codeString))
          return FHIRAllTypes.CONTRIBUTOR;
        if ("Count".equals(codeString))
          return FHIRAllTypes.COUNT;
        if ("DataRequirement".equals(codeString))
          return FHIRAllTypes.DATAREQUIREMENT;
        if ("DataType".equals(codeString))
          return FHIRAllTypes.DATATYPE;
        if ("Distance".equals(codeString))
          return FHIRAllTypes.DISTANCE;
        if ("Dosage".equals(codeString))
          return FHIRAllTypes.DOSAGE;
        if ("Duration".equals(codeString))
          return FHIRAllTypes.DURATION;
        if ("Element".equals(codeString))
          return FHIRAllTypes.ELEMENT;
        if ("ElementDefinition".equals(codeString))
          return FHIRAllTypes.ELEMENTDEFINITION;
        if ("Expression".equals(codeString))
          return FHIRAllTypes.EXPRESSION;
        if ("Extension".equals(codeString))
          return FHIRAllTypes.EXTENSION;
        if ("HumanName".equals(codeString))
          return FHIRAllTypes.HUMANNAME;
        if ("Identifier".equals(codeString))
          return FHIRAllTypes.IDENTIFIER;
        if ("MarketingStatus".equals(codeString))
          return FHIRAllTypes.MARKETINGSTATUS;
        if ("Meta".equals(codeString))
          return FHIRAllTypes.META;
        if ("Money".equals(codeString))
          return FHIRAllTypes.MONEY;
        if ("MoneyQuantity".equals(codeString))
          return FHIRAllTypes.MONEYQUANTITY;
        if ("Narrative".equals(codeString))
          return FHIRAllTypes.NARRATIVE;
        if ("OrderedDistribution".equals(codeString))
          return FHIRAllTypes.ORDEREDDISTRIBUTION;
        if ("ParameterDefinition".equals(codeString))
          return FHIRAllTypes.PARAMETERDEFINITION;
        if ("Period".equals(codeString))
          return FHIRAllTypes.PERIOD;
        if ("Population".equals(codeString))
          return FHIRAllTypes.POPULATION;
        if ("PrimitiveType".equals(codeString))
          return FHIRAllTypes.PRIMITIVETYPE;
        if ("ProdCharacteristic".equals(codeString))
          return FHIRAllTypes.PRODCHARACTERISTIC;
        if ("ProductShelfLife".equals(codeString))
          return FHIRAllTypes.PRODUCTSHELFLIFE;
        if ("Quantity".equals(codeString))
          return FHIRAllTypes.QUANTITY;
        if ("Range".equals(codeString))
          return FHIRAllTypes.RANGE;
        if ("Ratio".equals(codeString))
          return FHIRAllTypes.RATIO;
        if ("Reference".equals(codeString))
          return FHIRAllTypes.REFERENCE;
        if ("RelatedArtifact".equals(codeString))
          return FHIRAllTypes.RELATEDARTIFACT;
        if ("SampledData".equals(codeString))
          return FHIRAllTypes.SAMPLEDDATA;
        if ("Signature".equals(codeString))
          return FHIRAllTypes.SIGNATURE;
        if ("SimpleQuantity".equals(codeString))
          return FHIRAllTypes.SIMPLEQUANTITY;
        if ("Statistic".equals(codeString))
          return FHIRAllTypes.STATISTIC;
        if ("SubstanceAmount".equals(codeString))
          return FHIRAllTypes.SUBSTANCEAMOUNT;
        if ("Timing".equals(codeString))
          return FHIRAllTypes.TIMING;
        if ("TriggerDefinition".equals(codeString))
          return FHIRAllTypes.TRIGGERDEFINITION;
        if ("UsageContext".equals(codeString))
          return FHIRAllTypes.USAGECONTEXT;
        if ("base64Binary".equals(codeString))
          return FHIRAllTypes.BASE64BINARY;
        if ("boolean".equals(codeString))
          return FHIRAllTypes.BOOLEAN;
        if ("canonical".equals(codeString))
          return FHIRAllTypes.CANONICAL;
        if ("code".equals(codeString))
          return FHIRAllTypes.CODE;
        if ("date".equals(codeString))
          return FHIRAllTypes.DATE;
        if ("dateTime".equals(codeString))
          return FHIRAllTypes.DATETIME;
        if ("decimal".equals(codeString))
          return FHIRAllTypes.DECIMAL;
        if ("id".equals(codeString))
          return FHIRAllTypes.ID;
        if ("instant".equals(codeString))
          return FHIRAllTypes.INSTANT;
        if ("integer".equals(codeString))
          return FHIRAllTypes.INTEGER;
        if ("integer64".equals(codeString))
          return FHIRAllTypes.INTEGER64;
        if ("markdown".equals(codeString))
          return FHIRAllTypes.MARKDOWN;
        if ("oid".equals(codeString))
          return FHIRAllTypes.OID;
        if ("positiveInt".equals(codeString))
          return FHIRAllTypes.POSITIVEINT;
        if ("string".equals(codeString))
          return FHIRAllTypes.STRING;
        if ("time".equals(codeString))
          return FHIRAllTypes.TIME;
        if ("unsignedInt".equals(codeString))
          return FHIRAllTypes.UNSIGNEDINT;
        if ("uri".equals(codeString))
          return FHIRAllTypes.URI;
        if ("url".equals(codeString))
          return FHIRAllTypes.URL;
        if ("uuid".equals(codeString))
          return FHIRAllTypes.UUID;
        if ("xhtml".equals(codeString))
          return FHIRAllTypes.XHTML;
        if ("Account".equals(codeString))
          return FHIRAllTypes.ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return FHIRAllTypes.ACTIVITYDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return FHIRAllTypes.ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return FHIRAllTypes.ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return FHIRAllTypes.ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return FHIRAllTypes.APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return FHIRAllTypes.APPOINTMENTRESPONSE;
        if ("AuditEvent".equals(codeString))
          return FHIRAllTypes.AUDITEVENT;
        if ("Basic".equals(codeString))
          return FHIRAllTypes.BASIC;
        if ("Binary".equals(codeString))
          return FHIRAllTypes.BINARY;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return FHIRAllTypes.BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return FHIRAllTypes.BODYSTRUCTURE;
        if ("Bundle".equals(codeString))
          return FHIRAllTypes.BUNDLE;
        if ("CapabilityStatement".equals(codeString))
          return FHIRAllTypes.CAPABILITYSTATEMENT;
        if ("CapabilityStatement2".equals(codeString))
          return FHIRAllTypes.CAPABILITYSTATEMENT2;
        if ("CarePlan".equals(codeString))
          return FHIRAllTypes.CAREPLAN;
        if ("CareTeam".equals(codeString))
          return FHIRAllTypes.CARETEAM;
        if ("CatalogEntry".equals(codeString))
          return FHIRAllTypes.CATALOGENTRY;
        if ("ChargeItem".equals(codeString))
          return FHIRAllTypes.CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return FHIRAllTypes.CHARGEITEMDEFINITION;
        if ("Claim".equals(codeString))
          return FHIRAllTypes.CLAIM;
        if ("ClaimResponse".equals(codeString))
          return FHIRAllTypes.CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return FHIRAllTypes.CLINICALIMPRESSION;
        if ("ClinicalUseIssue".equals(codeString))
          return FHIRAllTypes.CLINICALUSEISSUE;
        if ("CodeSystem".equals(codeString))
          return FHIRAllTypes.CODESYSTEM;
        if ("Communication".equals(codeString))
          return FHIRAllTypes.COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return FHIRAllTypes.COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return FHIRAllTypes.COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return FHIRAllTypes.COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return FHIRAllTypes.CONCEPTMAP;
        if ("Condition".equals(codeString))
          return FHIRAllTypes.CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return FHIRAllTypes.CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return FHIRAllTypes.CONSENT;
        if ("Contract".equals(codeString))
          return FHIRAllTypes.CONTRACT;
        if ("Coverage".equals(codeString))
          return FHIRAllTypes.COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return FHIRAllTypes.COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return FHIRAllTypes.COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return FHIRAllTypes.DETECTEDISSUE;
        if ("Device".equals(codeString))
          return FHIRAllTypes.DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return FHIRAllTypes.DEVICEDEFINITION;
        if ("DeviceMetric".equals(codeString))
          return FHIRAllTypes.DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return FHIRAllTypes.DEVICEREQUEST;
        if ("DeviceUseStatement".equals(codeString))
          return FHIRAllTypes.DEVICEUSESTATEMENT;
        if ("DiagnosticReport".equals(codeString))
          return FHIRAllTypes.DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return FHIRAllTypes.DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return FHIRAllTypes.DOCUMENTREFERENCE;
        if ("DomainResource".equals(codeString))
          return FHIRAllTypes.DOMAINRESOURCE;
        if ("Encounter".equals(codeString))
          return FHIRAllTypes.ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return FHIRAllTypes.ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return FHIRAllTypes.ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return FHIRAllTypes.ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return FHIRAllTypes.EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return FHIRAllTypes.EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return FHIRAllTypes.EVIDENCE;
        if ("EvidenceVariable".equals(codeString))
          return FHIRAllTypes.EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return FHIRAllTypes.EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return FHIRAllTypes.EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return FHIRAllTypes.FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return FHIRAllTypes.FLAG;
        if ("Goal".equals(codeString))
          return FHIRAllTypes.GOAL;
        if ("GraphDefinition".equals(codeString))
          return FHIRAllTypes.GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return FHIRAllTypes.GROUP;
        if ("GuidanceResponse".equals(codeString))
          return FHIRAllTypes.GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return FHIRAllTypes.HEALTHCARESERVICE;
        if ("ImagingStudy".equals(codeString))
          return FHIRAllTypes.IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return FHIRAllTypes.IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return FHIRAllTypes.IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return FHIRAllTypes.IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return FHIRAllTypes.IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return FHIRAllTypes.INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return FHIRAllTypes.INSURANCEPLAN;
        if ("Invoice".equals(codeString))
          return FHIRAllTypes.INVOICE;
        if ("Library".equals(codeString))
          return FHIRAllTypes.LIBRARY;
        if ("Linkage".equals(codeString))
          return FHIRAllTypes.LINKAGE;
        if ("List".equals(codeString))
          return FHIRAllTypes.LIST;
        if ("Location".equals(codeString))
          return FHIRAllTypes.LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return FHIRAllTypes.MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return FHIRAllTypes.MEASURE;
        if ("MeasureReport".equals(codeString))
          return FHIRAllTypes.MEASUREREPORT;
        if ("Medication".equals(codeString))
          return FHIRAllTypes.MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return FHIRAllTypes.MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return FHIRAllTypes.MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return FHIRAllTypes.MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return FHIRAllTypes.MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return FHIRAllTypes.MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return FHIRAllTypes.MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return FHIRAllTypes.MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return FHIRAllTypes.MESSAGEHEADER;
        if ("MolecularSequence".equals(codeString))
          return FHIRAllTypes.MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return FHIRAllTypes.NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return FHIRAllTypes.NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return FHIRAllTypes.NUTRITIONORDER;
        if ("Observation".equals(codeString))
          return FHIRAllTypes.OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return FHIRAllTypes.OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return FHIRAllTypes.OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return FHIRAllTypes.OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return FHIRAllTypes.ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return FHIRAllTypes.ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return FHIRAllTypes.PACKAGEDPRODUCTDEFINITION;
        if ("Parameters".equals(codeString))
          return FHIRAllTypes.PARAMETERS;
        if ("Patient".equals(codeString))
          return FHIRAllTypes.PATIENT;
        if ("PaymentNotice".equals(codeString))
          return FHIRAllTypes.PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return FHIRAllTypes.PAYMENTRECONCILIATION;
        if ("Person".equals(codeString))
          return FHIRAllTypes.PERSON;
        if ("PlanDefinition".equals(codeString))
          return FHIRAllTypes.PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return FHIRAllTypes.PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return FHIRAllTypes.PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return FHIRAllTypes.PROCEDURE;
        if ("Provenance".equals(codeString))
          return FHIRAllTypes.PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return FHIRAllTypes.QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return FHIRAllTypes.QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return FHIRAllTypes.REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return FHIRAllTypes.RELATEDPERSON;
        if ("RequestGroup".equals(codeString))
          return FHIRAllTypes.REQUESTGROUP;
        if ("ResearchStudy".equals(codeString))
          return FHIRAllTypes.RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return FHIRAllTypes.RESEARCHSUBJECT;
        if ("Resource".equals(codeString))
          return FHIRAllTypes.RESOURCE;
        if ("RiskAssessment".equals(codeString))
          return FHIRAllTypes.RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return FHIRAllTypes.SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return FHIRAllTypes.SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return FHIRAllTypes.SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return FHIRAllTypes.SLOT;
        if ("Specimen".equals(codeString))
          return FHIRAllTypes.SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return FHIRAllTypes.SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return FHIRAllTypes.STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return FHIRAllTypes.STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return FHIRAllTypes.SUBSCRIPTION;
        if ("Substance".equals(codeString))
          return FHIRAllTypes.SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return FHIRAllTypes.SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return FHIRAllTypes.SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return FHIRAllTypes.SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return FHIRAllTypes.SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return FHIRAllTypes.SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return FHIRAllTypes.SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return FHIRAllTypes.SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return FHIRAllTypes.SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return FHIRAllTypes.TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return FHIRAllTypes.TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return FHIRAllTypes.TESTREPORT;
        if ("TestScript".equals(codeString))
          return FHIRAllTypes.TESTSCRIPT;
        if ("Topic".equals(codeString))
          return FHIRAllTypes.TOPIC;
        if ("ValueSet".equals(codeString))
          return FHIRAllTypes.VALUESET;
        if ("VerificationResult".equals(codeString))
          return FHIRAllTypes.VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return FHIRAllTypes.VISIONPRESCRIPTION;
        if ("Type".equals(codeString))
          return FHIRAllTypes.TYPE;
        if ("Any".equals(codeString))
          return FHIRAllTypes.ANY;
        throw new IllegalArgumentException("Unknown FHIRAllTypes code '"+codeString+"'");
        }
        public Enumeration<FHIRAllTypes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<FHIRAllTypes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("Address".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ADDRESS);
        if ("Age".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.AGE);
        if ("Annotation".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ANNOTATION);
        if ("Attachment".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ATTACHMENT);
        if ("BackboneElement".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.BACKBONEELEMENT);
        if ("BackboneType".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.BACKBONETYPE);
        if ("Base".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.BASE);
        if ("CodeableConcept".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CODEABLECONCEPT);
        if ("CodeableReference".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CODEABLEREFERENCE);
        if ("Coding".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CODING);
        if ("ContactDetail".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CONTACTDETAIL);
        if ("ContactPoint".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CONTACTPOINT);
        if ("Contributor".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CONTRIBUTOR);
        if ("Count".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.COUNT);
        if ("DataRequirement".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DATAREQUIREMENT);
        if ("DataType".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DATATYPE);
        if ("Distance".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DISTANCE);
        if ("Dosage".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DOSAGE);
        if ("Duration".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DURATION);
        if ("Element".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ELEMENT);
        if ("ElementDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ELEMENTDEFINITION);
        if ("Expression".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.EXPRESSION);
        if ("Extension".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.EXTENSION);
        if ("HumanName".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.HUMANNAME);
        if ("Identifier".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.IDENTIFIER);
        if ("MarketingStatus".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MARKETINGSTATUS);
        if ("Meta".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.META);
        if ("Money".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MONEY);
        if ("MoneyQuantity".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MONEYQUANTITY);
        if ("Narrative".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.NARRATIVE);
        if ("OrderedDistribution".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ORDEREDDISTRIBUTION);
        if ("ParameterDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PARAMETERDEFINITION);
        if ("Period".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PERIOD);
        if ("Population".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.POPULATION);
        if ("PrimitiveType".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PRIMITIVETYPE);
        if ("ProdCharacteristic".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PRODCHARACTERISTIC);
        if ("ProductShelfLife".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PRODUCTSHELFLIFE);
        if ("Quantity".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.QUANTITY);
        if ("Range".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.RANGE);
        if ("Ratio".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.RATIO);
        if ("Reference".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.REFERENCE);
        if ("RelatedArtifact".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.RELATEDARTIFACT);
        if ("SampledData".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SAMPLEDDATA);
        if ("Signature".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SIGNATURE);
        if ("SimpleQuantity".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SIMPLEQUANTITY);
        if ("Statistic".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.STATISTIC);
        if ("SubstanceAmount".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SUBSTANCEAMOUNT);
        if ("Timing".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.TIMING);
        if ("TriggerDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.TRIGGERDEFINITION);
        if ("UsageContext".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.USAGECONTEXT);
        if ("base64Binary".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.BASE64BINARY);
        if ("boolean".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.BOOLEAN);
        if ("canonical".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CANONICAL);
        if ("code".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CODE);
        if ("date".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DATE);
        if ("dateTime".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DATETIME);
        if ("decimal".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DECIMAL);
        if ("id".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ID);
        if ("instant".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.INSTANT);
        if ("integer".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.INTEGER);
        if ("integer64".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.INTEGER64);
        if ("markdown".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MARKDOWN);
        if ("oid".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.OID);
        if ("positiveInt".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.POSITIVEINT);
        if ("string".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.STRING);
        if ("time".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.TIME);
        if ("unsignedInt".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.UNSIGNEDINT);
        if ("uri".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.URI);
        if ("url".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.URL);
        if ("uuid".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.UUID);
        if ("xhtml".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.XHTML);
        if ("Account".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ACCOUNT);
        if ("ActivityDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ACTIVITYDEFINITION);
        if ("AdministrableProductDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ADMINISTRABLEPRODUCTDEFINITION);
        if ("AdverseEvent".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ADVERSEEVENT);
        if ("AllergyIntolerance".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ALLERGYINTOLERANCE);
        if ("Appointment".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.APPOINTMENT);
        if ("AppointmentResponse".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.APPOINTMENTRESPONSE);
        if ("AuditEvent".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.AUDITEVENT);
        if ("Basic".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.BASIC);
        if ("Binary".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.BINARY);
        if ("BiologicallyDerivedProduct".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.BIOLOGICALLYDERIVEDPRODUCT);
        if ("BodyStructure".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.BODYSTRUCTURE);
        if ("Bundle".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.BUNDLE);
        if ("CapabilityStatement".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CAPABILITYSTATEMENT);
        if ("CapabilityStatement2".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CAPABILITYSTATEMENT2);
        if ("CarePlan".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CAREPLAN);
        if ("CareTeam".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CARETEAM);
        if ("CatalogEntry".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CATALOGENTRY);
        if ("ChargeItem".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CHARGEITEM);
        if ("ChargeItemDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CHARGEITEMDEFINITION);
        if ("Claim".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CLAIM);
        if ("ClaimResponse".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CLAIMRESPONSE);
        if ("ClinicalImpression".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CLINICALIMPRESSION);
        if ("ClinicalUseIssue".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CLINICALUSEISSUE);
        if ("CodeSystem".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CODESYSTEM);
        if ("Communication".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.COMMUNICATION);
        if ("CommunicationRequest".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.COMMUNICATIONREQUEST);
        if ("CompartmentDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.COMPARTMENTDEFINITION);
        if ("Composition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.COMPOSITION);
        if ("ConceptMap".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CONCEPTMAP);
        if ("Condition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CONDITION);
        if ("ConditionDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CONDITIONDEFINITION);
        if ("Consent".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CONSENT);
        if ("Contract".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.CONTRACT);
        if ("Coverage".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.COVERAGE);
        if ("CoverageEligibilityRequest".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.COVERAGEELIGIBILITYREQUEST);
        if ("CoverageEligibilityResponse".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.COVERAGEELIGIBILITYRESPONSE);
        if ("DetectedIssue".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DETECTEDISSUE);
        if ("Device".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DEVICE);
        if ("DeviceDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DEVICEDEFINITION);
        if ("DeviceMetric".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DEVICEMETRIC);
        if ("DeviceRequest".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DEVICEREQUEST);
        if ("DeviceUseStatement".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DEVICEUSESTATEMENT);
        if ("DiagnosticReport".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DIAGNOSTICREPORT);
        if ("DocumentManifest".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DOCUMENTMANIFEST);
        if ("DocumentReference".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DOCUMENTREFERENCE);
        if ("DomainResource".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.DOMAINRESOURCE);
        if ("Encounter".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ENCOUNTER);
        if ("Endpoint".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ENDPOINT);
        if ("EnrollmentRequest".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ENROLLMENTREQUEST);
        if ("EnrollmentResponse".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ENROLLMENTRESPONSE);
        if ("EpisodeOfCare".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.EPISODEOFCARE);
        if ("EventDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.EVENTDEFINITION);
        if ("Evidence".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.EVIDENCE);
        if ("EvidenceVariable".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.EVIDENCEVARIABLE);
        if ("ExampleScenario".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.EXAMPLESCENARIO);
        if ("ExplanationOfBenefit".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.EXPLANATIONOFBENEFIT);
        if ("FamilyMemberHistory".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.FAMILYMEMBERHISTORY);
        if ("Flag".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.FLAG);
        if ("Goal".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.GOAL);
        if ("GraphDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.GRAPHDEFINITION);
        if ("Group".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.GROUP);
        if ("GuidanceResponse".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.GUIDANCERESPONSE);
        if ("HealthcareService".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.HEALTHCARESERVICE);
        if ("ImagingStudy".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.IMAGINGSTUDY);
        if ("Immunization".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.IMMUNIZATION);
        if ("ImmunizationEvaluation".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.IMMUNIZATIONEVALUATION);
        if ("ImmunizationRecommendation".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.IMMUNIZATIONRECOMMENDATION);
        if ("ImplementationGuide".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.IMPLEMENTATIONGUIDE);
        if ("Ingredient".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.INGREDIENT);
        if ("InsurancePlan".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.INSURANCEPLAN);
        if ("Invoice".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.INVOICE);
        if ("Library".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.LIBRARY);
        if ("Linkage".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.LINKAGE);
        if ("List".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.LIST);
        if ("Location".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.LOCATION);
        if ("ManufacturedItemDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MANUFACTUREDITEMDEFINITION);
        if ("Measure".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MEASURE);
        if ("MeasureReport".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MEASUREREPORT);
        if ("Medication".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MEDICATION);
        if ("MedicationAdministration".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MEDICATIONADMINISTRATION);
        if ("MedicationDispense".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MEDICATIONDISPENSE);
        if ("MedicationKnowledge".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MEDICATIONKNOWLEDGE);
        if ("MedicationRequest".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MEDICATIONREQUEST);
        if ("MedicationUsage".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MEDICATIONUSAGE);
        if ("MedicinalProductDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MEDICINALPRODUCTDEFINITION);
        if ("MessageDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MESSAGEDEFINITION);
        if ("MessageHeader".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MESSAGEHEADER);
        if ("MolecularSequence".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.MOLECULARSEQUENCE);
        if ("NamingSystem".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.NAMINGSYSTEM);
        if ("NutritionIntake".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.NUTRITIONINTAKE);
        if ("NutritionOrder".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.NUTRITIONORDER);
        if ("Observation".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.OBSERVATION);
        if ("ObservationDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.OBSERVATIONDEFINITION);
        if ("OperationDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.OPERATIONDEFINITION);
        if ("OperationOutcome".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.OPERATIONOUTCOME);
        if ("Organization".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ORGANIZATION);
        if ("OrganizationAffiliation".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ORGANIZATIONAFFILIATION);
        if ("PackagedProductDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PACKAGEDPRODUCTDEFINITION);
        if ("Parameters".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PARAMETERS);
        if ("Patient".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PATIENT);
        if ("PaymentNotice".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PAYMENTNOTICE);
        if ("PaymentReconciliation".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PAYMENTRECONCILIATION);
        if ("Person".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PERSON);
        if ("PlanDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PLANDEFINITION);
        if ("Practitioner".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PRACTITIONER);
        if ("PractitionerRole".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PRACTITIONERROLE);
        if ("Procedure".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PROCEDURE);
        if ("Provenance".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.PROVENANCE);
        if ("Questionnaire".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.QUESTIONNAIRE);
        if ("QuestionnaireResponse".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.QUESTIONNAIRERESPONSE);
        if ("RegulatedAuthorization".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.REGULATEDAUTHORIZATION);
        if ("RelatedPerson".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.RELATEDPERSON);
        if ("RequestGroup".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.REQUESTGROUP);
        if ("ResearchStudy".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.RESEARCHSTUDY);
        if ("ResearchSubject".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.RESEARCHSUBJECT);
        if ("Resource".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.RESOURCE);
        if ("RiskAssessment".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.RISKASSESSMENT);
        if ("Schedule".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SCHEDULE);
        if ("SearchParameter".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SEARCHPARAMETER);
        if ("ServiceRequest".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SERVICEREQUEST);
        if ("Slot".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SLOT);
        if ("Specimen".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SPECIMEN);
        if ("SpecimenDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SPECIMENDEFINITION);
        if ("StructureDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.STRUCTUREDEFINITION);
        if ("StructureMap".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.STRUCTUREMAP);
        if ("Subscription".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SUBSCRIPTION);
        if ("Substance".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SUBSTANCE);
        if ("SubstanceDefinition".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SUBSTANCEDEFINITION);
        if ("SubstanceNucleicAcid".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SUBSTANCENUCLEICACID);
        if ("SubstancePolymer".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SUBSTANCEPOLYMER);
        if ("SubstanceProtein".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SUBSTANCEPROTEIN);
        if ("SubstanceReferenceInformation".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SUBSTANCEREFERENCEINFORMATION);
        if ("SubstanceSourceMaterial".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SUBSTANCESOURCEMATERIAL);
        if ("SupplyDelivery".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SUPPLYDELIVERY);
        if ("SupplyRequest".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.SUPPLYREQUEST);
        if ("Task".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.TASK);
        if ("TerminologyCapabilities".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.TERMINOLOGYCAPABILITIES);
        if ("TestReport".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.TESTREPORT);
        if ("TestScript".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.TESTSCRIPT);
        if ("Topic".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.TOPIC);
        if ("ValueSet".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.VALUESET);
        if ("VerificationResult".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.VERIFICATIONRESULT);
        if ("VisionPrescription".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.VISIONPRESCRIPTION);
        if ("Type".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.TYPE);
        if ("Any".equals(codeString))
          return new Enumeration<FHIRAllTypes>(this, FHIRAllTypes.ANY);
        throw new FHIRException("Unknown FHIRAllTypes code '"+codeString+"'");
        }
    public String toCode(FHIRAllTypes code) {
      if (code == FHIRAllTypes.ADDRESS)
        return "Address";
      if (code == FHIRAllTypes.AGE)
        return "Age";
      if (code == FHIRAllTypes.ANNOTATION)
        return "Annotation";
      if (code == FHIRAllTypes.ATTACHMENT)
        return "Attachment";
      if (code == FHIRAllTypes.BACKBONEELEMENT)
        return "BackboneElement";
      if (code == FHIRAllTypes.BACKBONETYPE)
        return "BackboneType";
      if (code == FHIRAllTypes.BASE)
        return "Base";
      if (code == FHIRAllTypes.CODEABLECONCEPT)
        return "CodeableConcept";
      if (code == FHIRAllTypes.CODEABLEREFERENCE)
        return "CodeableReference";
      if (code == FHIRAllTypes.CODING)
        return "Coding";
      if (code == FHIRAllTypes.CONTACTDETAIL)
        return "ContactDetail";
      if (code == FHIRAllTypes.CONTACTPOINT)
        return "ContactPoint";
      if (code == FHIRAllTypes.CONTRIBUTOR)
        return "Contributor";
      if (code == FHIRAllTypes.COUNT)
        return "Count";
      if (code == FHIRAllTypes.DATAREQUIREMENT)
        return "DataRequirement";
      if (code == FHIRAllTypes.DATATYPE)
        return "DataType";
      if (code == FHIRAllTypes.DISTANCE)
        return "Distance";
      if (code == FHIRAllTypes.DOSAGE)
        return "Dosage";
      if (code == FHIRAllTypes.DURATION)
        return "Duration";
      if (code == FHIRAllTypes.ELEMENT)
        return "Element";
      if (code == FHIRAllTypes.ELEMENTDEFINITION)
        return "ElementDefinition";
      if (code == FHIRAllTypes.EXPRESSION)
        return "Expression";
      if (code == FHIRAllTypes.EXTENSION)
        return "Extension";
      if (code == FHIRAllTypes.HUMANNAME)
        return "HumanName";
      if (code == FHIRAllTypes.IDENTIFIER)
        return "Identifier";
      if (code == FHIRAllTypes.MARKETINGSTATUS)
        return "MarketingStatus";
      if (code == FHIRAllTypes.META)
        return "Meta";
      if (code == FHIRAllTypes.MONEY)
        return "Money";
      if (code == FHIRAllTypes.MONEYQUANTITY)
        return "MoneyQuantity";
      if (code == FHIRAllTypes.NARRATIVE)
        return "Narrative";
      if (code == FHIRAllTypes.ORDEREDDISTRIBUTION)
        return "OrderedDistribution";
      if (code == FHIRAllTypes.PARAMETERDEFINITION)
        return "ParameterDefinition";
      if (code == FHIRAllTypes.PERIOD)
        return "Period";
      if (code == FHIRAllTypes.POPULATION)
        return "Population";
      if (code == FHIRAllTypes.PRIMITIVETYPE)
        return "PrimitiveType";
      if (code == FHIRAllTypes.PRODCHARACTERISTIC)
        return "ProdCharacteristic";
      if (code == FHIRAllTypes.PRODUCTSHELFLIFE)
        return "ProductShelfLife";
      if (code == FHIRAllTypes.QUANTITY)
        return "Quantity";
      if (code == FHIRAllTypes.RANGE)
        return "Range";
      if (code == FHIRAllTypes.RATIO)
        return "Ratio";
      if (code == FHIRAllTypes.REFERENCE)
        return "Reference";
      if (code == FHIRAllTypes.RELATEDARTIFACT)
        return "RelatedArtifact";
      if (code == FHIRAllTypes.SAMPLEDDATA)
        return "SampledData";
      if (code == FHIRAllTypes.SIGNATURE)
        return "Signature";
      if (code == FHIRAllTypes.SIMPLEQUANTITY)
        return "SimpleQuantity";
      if (code == FHIRAllTypes.STATISTIC)
        return "Statistic";
      if (code == FHIRAllTypes.SUBSTANCEAMOUNT)
        return "SubstanceAmount";
      if (code == FHIRAllTypes.TIMING)
        return "Timing";
      if (code == FHIRAllTypes.TRIGGERDEFINITION)
        return "TriggerDefinition";
      if (code == FHIRAllTypes.USAGECONTEXT)
        return "UsageContext";
      if (code == FHIRAllTypes.BASE64BINARY)
        return "base64Binary";
      if (code == FHIRAllTypes.BOOLEAN)
        return "boolean";
      if (code == FHIRAllTypes.CANONICAL)
        return "canonical";
      if (code == FHIRAllTypes.CODE)
        return "code";
      if (code == FHIRAllTypes.DATE)
        return "date";
      if (code == FHIRAllTypes.DATETIME)
        return "dateTime";
      if (code == FHIRAllTypes.DECIMAL)
        return "decimal";
      if (code == FHIRAllTypes.ID)
        return "id";
      if (code == FHIRAllTypes.INSTANT)
        return "instant";
      if (code == FHIRAllTypes.INTEGER)
        return "integer";
      if (code == FHIRAllTypes.INTEGER64)
        return "integer64";
      if (code == FHIRAllTypes.MARKDOWN)
        return "markdown";
      if (code == FHIRAllTypes.OID)
        return "oid";
      if (code == FHIRAllTypes.POSITIVEINT)
        return "positiveInt";
      if (code == FHIRAllTypes.STRING)
        return "string";
      if (code == FHIRAllTypes.TIME)
        return "time";
      if (code == FHIRAllTypes.UNSIGNEDINT)
        return "unsignedInt";
      if (code == FHIRAllTypes.URI)
        return "uri";
      if (code == FHIRAllTypes.URL)
        return "url";
      if (code == FHIRAllTypes.UUID)
        return "uuid";
      if (code == FHIRAllTypes.XHTML)
        return "xhtml";
      if (code == FHIRAllTypes.ACCOUNT)
        return "Account";
      if (code == FHIRAllTypes.ACTIVITYDEFINITION)
        return "ActivityDefinition";
      if (code == FHIRAllTypes.ADMINISTRABLEPRODUCTDEFINITION)
        return "AdministrableProductDefinition";
      if (code == FHIRAllTypes.ADVERSEEVENT)
        return "AdverseEvent";
      if (code == FHIRAllTypes.ALLERGYINTOLERANCE)
        return "AllergyIntolerance";
      if (code == FHIRAllTypes.APPOINTMENT)
        return "Appointment";
      if (code == FHIRAllTypes.APPOINTMENTRESPONSE)
        return "AppointmentResponse";
      if (code == FHIRAllTypes.AUDITEVENT)
        return "AuditEvent";
      if (code == FHIRAllTypes.BASIC)
        return "Basic";
      if (code == FHIRAllTypes.BINARY)
        return "Binary";
      if (code == FHIRAllTypes.BIOLOGICALLYDERIVEDPRODUCT)
        return "BiologicallyDerivedProduct";
      if (code == FHIRAllTypes.BODYSTRUCTURE)
        return "BodyStructure";
      if (code == FHIRAllTypes.BUNDLE)
        return "Bundle";
      if (code == FHIRAllTypes.CAPABILITYSTATEMENT)
        return "CapabilityStatement";
      if (code == FHIRAllTypes.CAPABILITYSTATEMENT2)
        return "CapabilityStatement2";
      if (code == FHIRAllTypes.CAREPLAN)
        return "CarePlan";
      if (code == FHIRAllTypes.CARETEAM)
        return "CareTeam";
      if (code == FHIRAllTypes.CATALOGENTRY)
        return "CatalogEntry";
      if (code == FHIRAllTypes.CHARGEITEM)
        return "ChargeItem";
      if (code == FHIRAllTypes.CHARGEITEMDEFINITION)
        return "ChargeItemDefinition";
      if (code == FHIRAllTypes.CLAIM)
        return "Claim";
      if (code == FHIRAllTypes.CLAIMRESPONSE)
        return "ClaimResponse";
      if (code == FHIRAllTypes.CLINICALIMPRESSION)
        return "ClinicalImpression";
      if (code == FHIRAllTypes.CLINICALUSEISSUE)
        return "ClinicalUseIssue";
      if (code == FHIRAllTypes.CODESYSTEM)
        return "CodeSystem";
      if (code == FHIRAllTypes.COMMUNICATION)
        return "Communication";
      if (code == FHIRAllTypes.COMMUNICATIONREQUEST)
        return "CommunicationRequest";
      if (code == FHIRAllTypes.COMPARTMENTDEFINITION)
        return "CompartmentDefinition";
      if (code == FHIRAllTypes.COMPOSITION)
        return "Composition";
      if (code == FHIRAllTypes.CONCEPTMAP)
        return "ConceptMap";
      if (code == FHIRAllTypes.CONDITION)
        return "Condition";
      if (code == FHIRAllTypes.CONDITIONDEFINITION)
        return "ConditionDefinition";
      if (code == FHIRAllTypes.CONSENT)
        return "Consent";
      if (code == FHIRAllTypes.CONTRACT)
        return "Contract";
      if (code == FHIRAllTypes.COVERAGE)
        return "Coverage";
      if (code == FHIRAllTypes.COVERAGEELIGIBILITYREQUEST)
        return "CoverageEligibilityRequest";
      if (code == FHIRAllTypes.COVERAGEELIGIBILITYRESPONSE)
        return "CoverageEligibilityResponse";
      if (code == FHIRAllTypes.DETECTEDISSUE)
        return "DetectedIssue";
      if (code == FHIRAllTypes.DEVICE)
        return "Device";
      if (code == FHIRAllTypes.DEVICEDEFINITION)
        return "DeviceDefinition";
      if (code == FHIRAllTypes.DEVICEMETRIC)
        return "DeviceMetric";
      if (code == FHIRAllTypes.DEVICEREQUEST)
        return "DeviceRequest";
      if (code == FHIRAllTypes.DEVICEUSESTATEMENT)
        return "DeviceUseStatement";
      if (code == FHIRAllTypes.DIAGNOSTICREPORT)
        return "DiagnosticReport";
      if (code == FHIRAllTypes.DOCUMENTMANIFEST)
        return "DocumentManifest";
      if (code == FHIRAllTypes.DOCUMENTREFERENCE)
        return "DocumentReference";
      if (code == FHIRAllTypes.DOMAINRESOURCE)
        return "DomainResource";
      if (code == FHIRAllTypes.ENCOUNTER)
        return "Encounter";
      if (code == FHIRAllTypes.ENDPOINT)
        return "Endpoint";
      if (code == FHIRAllTypes.ENROLLMENTREQUEST)
        return "EnrollmentRequest";
      if (code == FHIRAllTypes.ENROLLMENTRESPONSE)
        return "EnrollmentResponse";
      if (code == FHIRAllTypes.EPISODEOFCARE)
        return "EpisodeOfCare";
      if (code == FHIRAllTypes.EVENTDEFINITION)
        return "EventDefinition";
      if (code == FHIRAllTypes.EVIDENCE)
        return "Evidence";
      if (code == FHIRAllTypes.EVIDENCEVARIABLE)
        return "EvidenceVariable";
      if (code == FHIRAllTypes.EXAMPLESCENARIO)
        return "ExampleScenario";
      if (code == FHIRAllTypes.EXPLANATIONOFBENEFIT)
        return "ExplanationOfBenefit";
      if (code == FHIRAllTypes.FAMILYMEMBERHISTORY)
        return "FamilyMemberHistory";
      if (code == FHIRAllTypes.FLAG)
        return "Flag";
      if (code == FHIRAllTypes.GOAL)
        return "Goal";
      if (code == FHIRAllTypes.GRAPHDEFINITION)
        return "GraphDefinition";
      if (code == FHIRAllTypes.GROUP)
        return "Group";
      if (code == FHIRAllTypes.GUIDANCERESPONSE)
        return "GuidanceResponse";
      if (code == FHIRAllTypes.HEALTHCARESERVICE)
        return "HealthcareService";
      if (code == FHIRAllTypes.IMAGINGSTUDY)
        return "ImagingStudy";
      if (code == FHIRAllTypes.IMMUNIZATION)
        return "Immunization";
      if (code == FHIRAllTypes.IMMUNIZATIONEVALUATION)
        return "ImmunizationEvaluation";
      if (code == FHIRAllTypes.IMMUNIZATIONRECOMMENDATION)
        return "ImmunizationRecommendation";
      if (code == FHIRAllTypes.IMPLEMENTATIONGUIDE)
        return "ImplementationGuide";
      if (code == FHIRAllTypes.INGREDIENT)
        return "Ingredient";
      if (code == FHIRAllTypes.INSURANCEPLAN)
        return "InsurancePlan";
      if (code == FHIRAllTypes.INVOICE)
        return "Invoice";
      if (code == FHIRAllTypes.LIBRARY)
        return "Library";
      if (code == FHIRAllTypes.LINKAGE)
        return "Linkage";
      if (code == FHIRAllTypes.LIST)
        return "List";
      if (code == FHIRAllTypes.LOCATION)
        return "Location";
      if (code == FHIRAllTypes.MANUFACTUREDITEMDEFINITION)
        return "ManufacturedItemDefinition";
      if (code == FHIRAllTypes.MEASURE)
        return "Measure";
      if (code == FHIRAllTypes.MEASUREREPORT)
        return "MeasureReport";
      if (code == FHIRAllTypes.MEDICATION)
        return "Medication";
      if (code == FHIRAllTypes.MEDICATIONADMINISTRATION)
        return "MedicationAdministration";
      if (code == FHIRAllTypes.MEDICATIONDISPENSE)
        return "MedicationDispense";
      if (code == FHIRAllTypes.MEDICATIONKNOWLEDGE)
        return "MedicationKnowledge";
      if (code == FHIRAllTypes.MEDICATIONREQUEST)
        return "MedicationRequest";
      if (code == FHIRAllTypes.MEDICATIONUSAGE)
        return "MedicationUsage";
      if (code == FHIRAllTypes.MEDICINALPRODUCTDEFINITION)
        return "MedicinalProductDefinition";
      if (code == FHIRAllTypes.MESSAGEDEFINITION)
        return "MessageDefinition";
      if (code == FHIRAllTypes.MESSAGEHEADER)
        return "MessageHeader";
      if (code == FHIRAllTypes.MOLECULARSEQUENCE)
        return "MolecularSequence";
      if (code == FHIRAllTypes.NAMINGSYSTEM)
        return "NamingSystem";
      if (code == FHIRAllTypes.NUTRITIONINTAKE)
        return "NutritionIntake";
      if (code == FHIRAllTypes.NUTRITIONORDER)
        return "NutritionOrder";
      if (code == FHIRAllTypes.OBSERVATION)
        return "Observation";
      if (code == FHIRAllTypes.OBSERVATIONDEFINITION)
        return "ObservationDefinition";
      if (code == FHIRAllTypes.OPERATIONDEFINITION)
        return "OperationDefinition";
      if (code == FHIRAllTypes.OPERATIONOUTCOME)
        return "OperationOutcome";
      if (code == FHIRAllTypes.ORGANIZATION)
        return "Organization";
      if (code == FHIRAllTypes.ORGANIZATIONAFFILIATION)
        return "OrganizationAffiliation";
      if (code == FHIRAllTypes.PACKAGEDPRODUCTDEFINITION)
        return "PackagedProductDefinition";
      if (code == FHIRAllTypes.PARAMETERS)
        return "Parameters";
      if (code == FHIRAllTypes.PATIENT)
        return "Patient";
      if (code == FHIRAllTypes.PAYMENTNOTICE)
        return "PaymentNotice";
      if (code == FHIRAllTypes.PAYMENTRECONCILIATION)
        return "PaymentReconciliation";
      if (code == FHIRAllTypes.PERSON)
        return "Person";
      if (code == FHIRAllTypes.PLANDEFINITION)
        return "PlanDefinition";
      if (code == FHIRAllTypes.PRACTITIONER)
        return "Practitioner";
      if (code == FHIRAllTypes.PRACTITIONERROLE)
        return "PractitionerRole";
      if (code == FHIRAllTypes.PROCEDURE)
        return "Procedure";
      if (code == FHIRAllTypes.PROVENANCE)
        return "Provenance";
      if (code == FHIRAllTypes.QUESTIONNAIRE)
        return "Questionnaire";
      if (code == FHIRAllTypes.QUESTIONNAIRERESPONSE)
        return "QuestionnaireResponse";
      if (code == FHIRAllTypes.REGULATEDAUTHORIZATION)
        return "RegulatedAuthorization";
      if (code == FHIRAllTypes.RELATEDPERSON)
        return "RelatedPerson";
      if (code == FHIRAllTypes.REQUESTGROUP)
        return "RequestGroup";
      if (code == FHIRAllTypes.RESEARCHSTUDY)
        return "ResearchStudy";
      if (code == FHIRAllTypes.RESEARCHSUBJECT)
        return "ResearchSubject";
      if (code == FHIRAllTypes.RESOURCE)
        return "Resource";
      if (code == FHIRAllTypes.RISKASSESSMENT)
        return "RiskAssessment";
      if (code == FHIRAllTypes.SCHEDULE)
        return "Schedule";
      if (code == FHIRAllTypes.SEARCHPARAMETER)
        return "SearchParameter";
      if (code == FHIRAllTypes.SERVICEREQUEST)
        return "ServiceRequest";
      if (code == FHIRAllTypes.SLOT)
        return "Slot";
      if (code == FHIRAllTypes.SPECIMEN)
        return "Specimen";
      if (code == FHIRAllTypes.SPECIMENDEFINITION)
        return "SpecimenDefinition";
      if (code == FHIRAllTypes.STRUCTUREDEFINITION)
        return "StructureDefinition";
      if (code == FHIRAllTypes.STRUCTUREMAP)
        return "StructureMap";
      if (code == FHIRAllTypes.SUBSCRIPTION)
        return "Subscription";
      if (code == FHIRAllTypes.SUBSTANCE)
        return "Substance";
      if (code == FHIRAllTypes.SUBSTANCEDEFINITION)
        return "SubstanceDefinition";
      if (code == FHIRAllTypes.SUBSTANCENUCLEICACID)
        return "SubstanceNucleicAcid";
      if (code == FHIRAllTypes.SUBSTANCEPOLYMER)
        return "SubstancePolymer";
      if (code == FHIRAllTypes.SUBSTANCEPROTEIN)
        return "SubstanceProtein";
      if (code == FHIRAllTypes.SUBSTANCEREFERENCEINFORMATION)
        return "SubstanceReferenceInformation";
      if (code == FHIRAllTypes.SUBSTANCESOURCEMATERIAL)
        return "SubstanceSourceMaterial";
      if (code == FHIRAllTypes.SUPPLYDELIVERY)
        return "SupplyDelivery";
      if (code == FHIRAllTypes.SUPPLYREQUEST)
        return "SupplyRequest";
      if (code == FHIRAllTypes.TASK)
        return "Task";
      if (code == FHIRAllTypes.TERMINOLOGYCAPABILITIES)
        return "TerminologyCapabilities";
      if (code == FHIRAllTypes.TESTREPORT)
        return "TestReport";
      if (code == FHIRAllTypes.TESTSCRIPT)
        return "TestScript";
      if (code == FHIRAllTypes.TOPIC)
        return "Topic";
      if (code == FHIRAllTypes.VALUESET)
        return "ValueSet";
      if (code == FHIRAllTypes.VERIFICATIONRESULT)
        return "VerificationResult";
      if (code == FHIRAllTypes.VISIONPRESCRIPTION)
        return "VisionPrescription";
      if (code == FHIRAllTypes.TYPE)
        return "Type";
      if (code == FHIRAllTypes.ANY)
        return "Any";
      return "?";
      }
    public String toSystem(FHIRAllTypes code) {
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
         * Draft For Comment (January 2015 Ballot).
         */
        _0_4_0, 
        /**
         * DSTU 2 Ballot version (May 2015 Ballot).
         */
        _0_5_0, 
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
         * GAO Ballot + draft changes to main FHIR standard.
         */
        _1_1_0, 
        /**
         * CQF on FHIR Ballot + Connectathon 12 (Montreal).
         */
        _1_4_0, 
        /**
         * FHIR STU3 Ballot + Connectathon 13 (Baltimore).
         */
        _1_6_0, 
        /**
         * FHIR STU3 Candidate + Connectathon 14 (San Antonio).
         */
        _1_8_0, 
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
         * R4 Ballot #1.
         */
        _3_3_0, 
        /**
         * R4 Ballot #2.
         */
        _3_5_0, 
        /**
         * FHIR Release 4 (Normative + STU).
         */
        _4_0_0, 
        /**
         * FHIR Release 4 (Normative + STU) with 1 technical errata.
         */
        _4_0_1, 
        /**
         * R5 Preview #1.
         */
        _4_2_0, 
        /**
         * R5 Preview #2.
         */
        _4_4_0, 
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
        if ("0.0.80".equals(codeString))
          return _0_0_80;
        if ("0.0.81".equals(codeString))
          return _0_0_81;
        if ("0.0.82".equals(codeString))
          return _0_0_82;
        if ("0.4.0".equals(codeString))
          return _0_4_0;
        if ("0.5.0".equals(codeString))
          return _0_5_0;
        if ("1.0.0".equals(codeString))
          return _1_0_0;
        if ("1.0.1".equals(codeString))
          return _1_0_1;
        if ("1.0.2".equals(codeString))
          return _1_0_2;
        if ("1.1.0".equals(codeString))
          return _1_1_0;
        if ("1.4.0".equals(codeString))
          return _1_4_0;
        if ("1.6.0".equals(codeString))
          return _1_6_0;
        if ("1.8.0".equals(codeString))
          return _1_8_0;
        if ("3.0.0".equals(codeString))
          return _3_0_0;
        if ("3.0.1".equals(codeString))
          return _3_0_1;
        if ("3.0.2".equals(codeString))
          return _3_0_2;
        if ("3.3.0".equals(codeString))
          return _3_3_0;
        if ("3.5.0".equals(codeString))
          return _3_5_0;
        if ("4.0.0".equals(codeString))
          return _4_0_0;
        if ("4.0.1".equals(codeString))
          return _4_0_1;
        if ("4.2.0".equals(codeString))
          return _4_2_0;
        if ("4.4.0".equals(codeString))
          return _4_4_0;
        throw new FHIRException("Unknown FHIRVersion code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case _0_01: return "0.01";
            case _0_05: return "0.05";
            case _0_06: return "0.06";
            case _0_11: return "0.11";
            case _0_0_80: return "0.0.80";
            case _0_0_81: return "0.0.81";
            case _0_0_82: return "0.0.82";
            case _0_4_0: return "0.4.0";
            case _0_5_0: return "0.5.0";
            case _1_0_0: return "1.0.0";
            case _1_0_1: return "1.0.1";
            case _1_0_2: return "1.0.2";
            case _1_1_0: return "1.1.0";
            case _1_4_0: return "1.4.0";
            case _1_6_0: return "1.6.0";
            case _1_8_0: return "1.8.0";
            case _3_0_0: return "3.0.0";
            case _3_0_1: return "3.0.1";
            case _3_0_2: return "3.0.2";
            case _3_3_0: return "3.3.0";
            case _3_5_0: return "3.5.0";
            case _4_0_0: return "4.0.0";
            case _4_0_1: return "4.0.1";
            case _4_2_0: return "4.2.0";
            case _4_4_0: return "4.4.0";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case _0_01: return "http://hl7.org/fhir/FHIR-version";
            case _0_05: return "http://hl7.org/fhir/FHIR-version";
            case _0_06: return "http://hl7.org/fhir/FHIR-version";
            case _0_11: return "http://hl7.org/fhir/FHIR-version";
            case _0_0_80: return "http://hl7.org/fhir/FHIR-version";
            case _0_0_81: return "http://hl7.org/fhir/FHIR-version";
            case _0_0_82: return "http://hl7.org/fhir/FHIR-version";
            case _0_4_0: return "http://hl7.org/fhir/FHIR-version";
            case _0_5_0: return "http://hl7.org/fhir/FHIR-version";
            case _1_0_0: return "http://hl7.org/fhir/FHIR-version";
            case _1_0_1: return "http://hl7.org/fhir/FHIR-version";
            case _1_0_2: return "http://hl7.org/fhir/FHIR-version";
            case _1_1_0: return "http://hl7.org/fhir/FHIR-version";
            case _1_4_0: return "http://hl7.org/fhir/FHIR-version";
            case _1_6_0: return "http://hl7.org/fhir/FHIR-version";
            case _1_8_0: return "http://hl7.org/fhir/FHIR-version";
            case _3_0_0: return "http://hl7.org/fhir/FHIR-version";
            case _3_0_1: return "http://hl7.org/fhir/FHIR-version";
            case _3_0_2: return "http://hl7.org/fhir/FHIR-version";
            case _3_3_0: return "http://hl7.org/fhir/FHIR-version";
            case _3_5_0: return "http://hl7.org/fhir/FHIR-version";
            case _4_0_0: return "http://hl7.org/fhir/FHIR-version";
            case _4_0_1: return "http://hl7.org/fhir/FHIR-version";
            case _4_2_0: return "http://hl7.org/fhir/FHIR-version";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case _0_01: return "Oldest archived version of FHIR.";
            case _0_05: return "1st Draft for Comment (Sept 2012 Ballot).";
            case _0_06: return "2nd Draft for Comment (January 2013 Ballot).";
            case _0_11: return "DSTU 1 Ballot version.";
            case _0_0_80: return "DSTU 1 Official version.";
            case _0_0_81: return "DSTU 1 Official version Technical Errata #1.";
            case _0_0_82: return "DSTU 1 Official version Technical Errata #2.";
            case _0_4_0: return "Draft For Comment (January 2015 Ballot).";
            case _0_5_0: return "DSTU 2 Ballot version (May 2015 Ballot).";
            case _1_0_0: return "DSTU 2 QA Preview + CQIF Ballot (Sep 2015).";
            case _1_0_1: return "DSTU 2 (Official version).";
            case _1_0_2: return "DSTU 2 (Official version) with 1 technical errata.";
            case _1_1_0: return "GAO Ballot + draft changes to main FHIR standard.";
            case _1_4_0: return "CQF on FHIR Ballot + Connectathon 12 (Montreal).";
            case _1_6_0: return "FHIR STU3 Ballot + Connectathon 13 (Baltimore).";
            case _1_8_0: return "FHIR STU3 Candidate + Connectathon 14 (San Antonio).";
            case _3_0_0: return "FHIR Release 3 (STU).";
            case _3_0_1: return "FHIR Release 3 (STU) with 1 technical errata.";
            case _3_0_2: return "FHIR Release 3 (STU) with 2 technical errata.";
            case _3_3_0: return "R4 Ballot #1.";
            case _3_5_0: return "R4 Ballot #2.";
            case _4_0_0: return "FHIR Release 4 (Normative + STU).";
            case _4_0_1: return "FHIR Release 4 (Normative + STU) with 1 technical errata.";
            case _4_2_0: return "R5 Preview #1.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case _0_01: return "0.01";
            case _0_05: return "0.05";
            case _0_06: return "0.06";
            case _0_11: return "0.11";
            case _0_0_80: return "0.0.80";
            case _0_0_81: return "0.0.81";
            case _0_0_82: return "0.0.82";
            case _0_4_0: return "0.4.0";
            case _0_5_0: return "0.5.0";
            case _1_0_0: return "1.0.0";
            case _1_0_1: return "1.0.1";
            case _1_0_2: return "1.0.2";
            case _1_1_0: return "1.1.0";
            case _1_4_0: return "1.4.0";
            case _1_6_0: return "1.6.0";
            case _1_8_0: return "1.8.0";
            case _3_0_0: return "3.0.0";
            case _3_0_1: return "3.0.1";
            case _3_0_2: return "3.0.2";
            case _3_3_0: return "3.3.0";
            case _3_5_0: return "3.5.0";
            case _4_0_0: return "4.0.0";
            case _4_0_1: return "4.0.1";
            case _4_2_0: return "4.2.0";
            case _4_4_0: return "4.4.0";
            default: return "?";
          }
        }
// manual code from configuration.txt:
        public String toCode(int len) {
          return toCode().substring(0, len);
        }

        public static boolean isR4Plus(String version) {
           return version != null && (version.startsWith("4.") || version.startsWith("5.") || "current".equals(version));
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
      if ("0.0.80".equals(codeString))
        return true;
      if ("0.0.81".equals(codeString))
        return true;
      if ("0.0.82".equals(codeString))
        return true;
      if ("0.4.0".equals(codeString))
        return true;
      if ("0.5.0".equals(codeString))
        return true;
      if ("1.0.0".equals(codeString))
        return true;
      if ("1.0.1".equals(codeString))
        return true;
      if ("1.0.2".equals(codeString))
        return true;
      if ("1.1.0".equals(codeString))
        return true;
      if ("1.4.0".equals(codeString))
        return true;
      if ("1.6.0".equals(codeString))
        return true;
      if ("1.8.0".equals(codeString))
        return true;
      if ("3.0.0".equals(codeString))
        return true;
      if ("3.0.1".equals(codeString))
        return true;
      if ("3.3.0".equals(codeString))
        return true;
      if ("3.5.0".equals(codeString))
        return true;
      if ("4.0.0".equals(codeString))
        return true;
      if ("4.2.0".equals(codeString))
        return true;
      if ("4.4.0".equals(codeString))
        return true;
      return false;
      }

        @Override
        public String toString() {
          return toCode();
        }        

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
        if ("0.0.80".equals(codeString))
          return FHIRVersion._0_0_80;
        if ("0.0.81".equals(codeString))
          return FHIRVersion._0_0_81;
        if ("0.0.82".equals(codeString))
          return FHIRVersion._0_0_82;
        if ("0.4.0".equals(codeString))
          return FHIRVersion._0_4_0;
        if ("0.5.0".equals(codeString))
          return FHIRVersion._0_5_0;
        if ("1.0.0".equals(codeString))
          return FHIRVersion._1_0_0;
        if ("1.0.1".equals(codeString))
          return FHIRVersion._1_0_1;
        if ("1.0.2".equals(codeString))
          return FHIRVersion._1_0_2;
        if ("1.1.0".equals(codeString))
          return FHIRVersion._1_1_0;
        if ("1.4.0".equals(codeString))
          return FHIRVersion._1_4_0;
        if ("1.6.0".equals(codeString))
          return FHIRVersion._1_6_0;
        if ("1.8.0".equals(codeString))
          return FHIRVersion._1_8_0;
        if ("3.0.0".equals(codeString))
          return FHIRVersion._3_0_0;
        if ("3.0.1".equals(codeString))
          return FHIRVersion._3_0_1;
        if ("3.0.2".equals(codeString))
          return FHIRVersion._3_0_2;
        if ("3.3.0".equals(codeString))
          return FHIRVersion._3_3_0;
        if ("3.5.0".equals(codeString))
          return FHIRVersion._3_5_0;
        if ("4.0.0".equals(codeString))
          return FHIRVersion._4_0_0;
        if ("4.0.1".equals(codeString))
          return FHIRVersion._4_0_1;
        if ("4.2.0".equals(codeString))
          return FHIRVersion._4_2_0;
        if ("4.4.0".equals(codeString))
          return FHIRVersion._4_4_0;
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
        if ("0.0.80".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_0_80);
        if ("0.0.81".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_0_81);
        if ("0.0.82".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_0_82);
        if ("0.4.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_4_0);
        if ("0.5.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._0_5_0);
        if ("1.0.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_0_0);
        if ("1.0.1".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_0_1);
        if ("1.0.2".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_0_2);
        if ("1.1.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_1_0);
        if ("1.4.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_4_0);
        if ("1.6.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_6_0);
        if ("1.8.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._1_8_0);
        if ("3.0.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_0_0);
        if ("3.0.1".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_0_1);
        if ("3.0.2".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_0_2);
        if ("3.3.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_3_0);
        if ("3.5.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._3_5_0);
        if ("4.0.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_0_0);
        if ("4.0.1".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_0_1);
        if ("4.2.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_2_0);
        if ("4.4.0".equals(codeString))
          return new Enumeration<FHIRVersion>(this, FHIRVersion._4_4_0);
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
      if (code == FHIRVersion._0_0_80)
        return "0.0.80";
      if (code == FHIRVersion._0_0_81)
        return "0.0.81";
      if (code == FHIRVersion._0_0_82)
        return "0.0.82";
      if (code == FHIRVersion._0_4_0)
        return "0.4.0";
      if (code == FHIRVersion._0_5_0)
        return "0.5.0";
      if (code == FHIRVersion._1_0_0)
        return "1.0.0";
      if (code == FHIRVersion._1_0_1)
        return "1.0.1";
      if (code == FHIRVersion._1_0_2)
        return "1.0.2";
      if (code == FHIRVersion._1_1_0)
        return "1.1.0";
      if (code == FHIRVersion._1_4_0)
        return "1.4.0";
      if (code == FHIRVersion._1_6_0)
        return "1.6.0";
      if (code == FHIRVersion._1_8_0)
        return "1.8.0";
      if (code == FHIRVersion._3_0_0)
        return "3.0.0";
      if (code == FHIRVersion._3_0_1)
        return "3.0.1";
      if (code == FHIRVersion._3_0_2)
        return "3.0.2";
      if (code == FHIRVersion._3_3_0)
        return "3.3.0";
      if (code == FHIRVersion._3_5_0)
        return "3.5.0";
      if (code == FHIRVersion._4_0_0)
        return "4.0.0";
      if (code == FHIRVersion._4_0_1)
        return "4.0.1";
      if (code == FHIRVersion._4_2_0)
        return "4.2.0";
      if (code == FHIRVersion._4_4_0)
        return "4.4.0";
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
            case EXISTS: return "exists";
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
            case EXISTS: return "http://hl7.org/fhir/filter-operator";
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
            case EXISTS: return "The specified property of the code has at least one value (if the specified value is true; if the specified value is false, then matches when the specified property of the code has no values).";
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
            case EXISTS: return "Exists";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/fm-status";
            case CANCELLED: return "http://hl7.org/fhir/fm-status";
            case DRAFT: return "http://hl7.org/fhir/fm-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/fm-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The instance is currently in-force.";
            case CANCELLED: return "The instance is withdrawn, rescinded or reversed.";
            case DRAFT: return "A new instance the contents of which is not complete.";
            case ENTEREDINERROR: return "The instance was entered in error.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case CANCELLED: return "Cancelled";
            case DRAFT: return "Draft";
            case ENTEREDINERROR: return "Entered in Error";
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

    public enum InvoicePriceComponentType {
        /**
         * the amount is the base price used for calculating the total price before applying surcharges, discount or taxes.
         */
        BASE, 
        /**
         * the amount is a surcharge applied on the base price.
         */
        SURCHARGE, 
        /**
         * the amount is a deduction applied on the base price.
         */
        DEDUCTION, 
        /**
         * the amount is a discount applied on the base price.
         */
        DISCOUNT, 
        /**
         * the amount is the tax component of the total price.
         */
        TAX, 
        /**
         * the amount is of informational character, it has not been applied in the calculation of the total price.
         */
        INFORMATIONAL, 
        /**
         * added to help the parsers
         */
        NULL;
        public static InvoicePriceComponentType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("base".equals(codeString))
          return BASE;
        if ("surcharge".equals(codeString))
          return SURCHARGE;
        if ("deduction".equals(codeString))
          return DEDUCTION;
        if ("discount".equals(codeString))
          return DISCOUNT;
        if ("tax".equals(codeString))
          return TAX;
        if ("informational".equals(codeString))
          return INFORMATIONAL;
        throw new FHIRException("Unknown InvoicePriceComponentType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case BASE: return "base";
            case SURCHARGE: return "surcharge";
            case DEDUCTION: return "deduction";
            case DISCOUNT: return "discount";
            case TAX: return "tax";
            case INFORMATIONAL: return "informational";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case BASE: return "http://hl7.org/fhir/invoice-priceComponentType";
            case SURCHARGE: return "http://hl7.org/fhir/invoice-priceComponentType";
            case DEDUCTION: return "http://hl7.org/fhir/invoice-priceComponentType";
            case DISCOUNT: return "http://hl7.org/fhir/invoice-priceComponentType";
            case TAX: return "http://hl7.org/fhir/invoice-priceComponentType";
            case INFORMATIONAL: return "http://hl7.org/fhir/invoice-priceComponentType";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case BASE: return "the amount is the base price used for calculating the total price before applying surcharges, discount or taxes.";
            case SURCHARGE: return "the amount is a surcharge applied on the base price.";
            case DEDUCTION: return "the amount is a deduction applied on the base price.";
            case DISCOUNT: return "the amount is a discount applied on the base price.";
            case TAX: return "the amount is the tax component of the total price.";
            case INFORMATIONAL: return "the amount is of informational character, it has not been applied in the calculation of the total price.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case BASE: return "base price";
            case SURCHARGE: return "surcharge";
            case DEDUCTION: return "deduction";
            case DISCOUNT: return "discount";
            case TAX: return "tax";
            case INFORMATIONAL: return "informational";
            default: return "?";
          }
        }
    }

  public static class InvoicePriceComponentTypeEnumFactory implements EnumFactory<InvoicePriceComponentType> {
    public InvoicePriceComponentType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("base".equals(codeString))
          return InvoicePriceComponentType.BASE;
        if ("surcharge".equals(codeString))
          return InvoicePriceComponentType.SURCHARGE;
        if ("deduction".equals(codeString))
          return InvoicePriceComponentType.DEDUCTION;
        if ("discount".equals(codeString))
          return InvoicePriceComponentType.DISCOUNT;
        if ("tax".equals(codeString))
          return InvoicePriceComponentType.TAX;
        if ("informational".equals(codeString))
          return InvoicePriceComponentType.INFORMATIONAL;
        throw new IllegalArgumentException("Unknown InvoicePriceComponentType code '"+codeString+"'");
        }
        public Enumeration<InvoicePriceComponentType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<InvoicePriceComponentType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("base".equals(codeString))
          return new Enumeration<InvoicePriceComponentType>(this, InvoicePriceComponentType.BASE);
        if ("surcharge".equals(codeString))
          return new Enumeration<InvoicePriceComponentType>(this, InvoicePriceComponentType.SURCHARGE);
        if ("deduction".equals(codeString))
          return new Enumeration<InvoicePriceComponentType>(this, InvoicePriceComponentType.DEDUCTION);
        if ("discount".equals(codeString))
          return new Enumeration<InvoicePriceComponentType>(this, InvoicePriceComponentType.DISCOUNT);
        if ("tax".equals(codeString))
          return new Enumeration<InvoicePriceComponentType>(this, InvoicePriceComponentType.TAX);
        if ("informational".equals(codeString))
          return new Enumeration<InvoicePriceComponentType>(this, InvoicePriceComponentType.INFORMATIONAL);
        throw new FHIRException("Unknown InvoicePriceComponentType code '"+codeString+"'");
        }
    public String toCode(InvoicePriceComponentType code) {
      if (code == InvoicePriceComponentType.BASE)
        return "base";
      if (code == InvoicePriceComponentType.SURCHARGE)
        return "surcharge";
      if (code == InvoicePriceComponentType.DEDUCTION)
        return "deduction";
      if (code == InvoicePriceComponentType.DISCOUNT)
        return "discount";
      if (code == InvoicePriceComponentType.TAX)
        return "tax";
      if (code == InvoicePriceComponentType.INFORMATIONAL)
        return "informational";
      return "?";
      }
    public String toSystem(InvoicePriceComponentType code) {
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case WORKING: return "http://hl7.org/fhir/list-mode";
            case SNAPSHOT: return "http://hl7.org/fhir/list-mode";
            case CHANGES: return "http://hl7.org/fhir/list-mode";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case WORKING: return "This list is the master list, maintained in an ongoing fashion with regular updates as the real world list it is tracking changes.";
            case SNAPSHOT: return "This list was prepared as a snapshot. It should not be assumed to be current.";
            case CHANGES: return "A point-in-time list that shows what changes have been made or recommended.  E.g. a discharge medication list showing what was added and removed during an encounter.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case WORKING: return "Working List";
            case SNAPSHOT: return "Snapshot List";
            case CHANGES: return "Change List";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INCREASE: return "http://terminology.hl7.org/CodeSystem/measure-improvement-notation";
            case DECREASE: return "http://terminology.hl7.org/CodeSystem/measure-improvement-notation";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INCREASE: return "Improvement is indicated as an increase in the score or measurement (e.g. Higher score indicates better quality).";
            case DECREASE: return "Improvement is indicated as a decrease in the score or measurement (e.g. Lower score indicates better quality).";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INCREASE: return "Increased score indicates improvement";
            case DECREASE: return "Decreased score indicates improvement";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DISPLAY: return "http://hl7.org/fhir/note-type";
            case PRINT: return "http://hl7.org/fhir/note-type";
            case PRINTOPER: return "http://hl7.org/fhir/note-type";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DISPLAY: return "Display the note.";
            case PRINT: return "Print the note on the form.";
            case PRINTOPER: return "Print the note for the operator.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DISPLAY: return "Display";
            case PRINT: return "Print (Form)";
            case PRINTOPER: return "Print (Operator)";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case IN: return "http://hl7.org/fhir/operation-parameter-use";
            case OUT: return "http://hl7.org/fhir/operation-parameter-use";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case IN: return "This is an input parameter.";
            case OUT: return "This is an output parameter.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case IN: return "In";
            case OUT: return "Out";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACCEPTED: return "http://hl7.org/fhir/participationstatus";
            case DECLINED: return "http://hl7.org/fhir/participationstatus";
            case TENTATIVE: return "http://hl7.org/fhir/participationstatus";
            case NEEDSACTION: return "http://hl7.org/fhir/participationstatus";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACCEPTED: return "The participant has accepted the appointment.";
            case DECLINED: return "The participant has declined the appointment and will not participate in the appointment.";
            case TENTATIVE: return "The participant has  tentatively accepted the appointment. This could be automatically created by a system and requires further processing before it can be accepted. There is no commitment that attendance will occur.";
            case NEEDSACTION: return "The participant needs to indicate if they accept the appointment by changing this status to one of the other statuses.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACCEPTED: return "Accepted";
            case DECLINED: return "Declined";
            case TENTATIVE: return "Tentative";
            case NEEDSACTION: return "Needs Action";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DRAFT: return "http://hl7.org/fhir/publication-status";
            case ACTIVE: return "http://hl7.org/fhir/publication-status";
            case RETIRED: return "http://hl7.org/fhir/publication-status";
            case UNKNOWN: return "http://hl7.org/fhir/publication-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DRAFT: return "This resource is still under development and is not yet considered to be ready for normal use.";
            case ACTIVE: return "This resource is ready for normal use.";
            case RETIRED: return "This resource has been withdrawn or superseded and should no longer be used.";
            case UNKNOWN: return "The authoring system does not know which of the status values currently applies for this resource.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, it's just not known which one.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DRAFT: return "Draft";
            case ACTIVE: return "Active";
            case RETIRED: return "Retired";
            case UNKNOWN: return "Unknown";
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
        throw new FHIRException("Unknown QuantityComparator code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case LESS_THAN: return "<";
            case LESS_OR_EQUAL: return "<=";
            case GREATER_OR_EQUAL: return ">=";
            case GREATER_THAN: return ">";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case LESS_THAN: return "http://hl7.org/fhir/quantity-comparator";
            case LESS_OR_EQUAL: return "http://hl7.org/fhir/quantity-comparator";
            case GREATER_OR_EQUAL: return "http://hl7.org/fhir/quantity-comparator";
            case GREATER_THAN: return "http://hl7.org/fhir/quantity-comparator";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case LESS_THAN: return "The actual value is less than the given value.";
            case LESS_OR_EQUAL: return "The actual value is less than or equal to the given value.";
            case GREATER_OR_EQUAL: return "The actual value is greater than or equal to the given value.";
            case GREATER_THAN: return "The actual value is greater than the given value.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case LESS_THAN: return "Less than";
            case LESS_OR_EQUAL: return "Less or Equal to";
            case GREATER_OR_EQUAL: return "Greater or Equal to";
            case GREATER_THAN: return "Greater than";
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
         * The request represents a component or option for a RequestGroup that establishes timing, conditionality and/or other constraints among a set of requests.  Refer to [[[RequestGroup]]] for additional information on how this status is used.
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
            case OPTION: return "The request represents a component or option for a RequestGroup that establishes timing, conditionality and/or other constraints among a set of requests.  Refer to [[[RequestGroup]]] for additional information on how this status is used.";
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ROUTINE: return "http://hl7.org/fhir/request-priority";
            case URGENT: return "http://hl7.org/fhir/request-priority";
            case ASAP: return "http://hl7.org/fhir/request-priority";
            case STAT: return "http://hl7.org/fhir/request-priority";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ROUTINE: return "The request has normal priority.";
            case URGENT: return "The request should be actioned promptly - higher priority than routine.";
            case ASAP: return "The request should be actioned as soon as possible - higher priority than urgent.";
            case STAT: return "The request should be actioned immediately - highest possible priority.  E.g. an emergency.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ROUTINE: return "Routine";
            case URGENT: return "Urgent";
            case ASAP: return "ASAP";
            case STAT: return "STAT";
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

    public enum ResourceTypeEnum {
        /**
         * A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.
         */
        ACCOUNT, 
        /**
         * This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.
         */
        ACTIVITYDEFINITION, 
        /**
         * A pharmaceutical product described in terms of its composition and dose form.
         */
        ADMINISTRABLEPRODUCTDEFINITION, 
        /**
         * An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject.  The unintended effects may require additional monitoring, treatment or hospitalization or may result in death.  The AdverseEvent resource also extends to potential or avoided events that could have had such effects.
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
         * A material substance originating from a biological entity intended to be transplanted or infused
into another (possibly the same) biological entity.
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
         * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        CAPABILITYSTATEMENT, 
        /**
         * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
         */
        CAPABILITYSTATEMENT2, 
        /**
         * Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.
         */
        CAREPLAN, 
        /**
         * The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.
         */
        CARETEAM, 
        /**
         * Catalog entries are wrappers that contextualize items included in a catalog.
         */
        CATALOGENTRY, 
        /**
         * The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.
         */
        CHARGEITEM, 
        /**
         * The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.
         */
        CHARGEITEMDEFINITION, 
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
         * A single usage issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.
         */
        CLINICALUSEISSUE, 
        /**
         * The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.
         */
        CODESYSTEM, 
        /**
         * An occurrence of information being transmitted; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.
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
         * A type of a manufactured item that is used in the provision of healthcare without being substantially changed through that activity. The device may be a medical or non-medical device.
         */
        DEVICE, 
        /**
         * The characteristics, operational status and capabilities of a medical-related component of a medical device.
         */
        DEVICEDEFINITION, 
        /**
         * Describes a measurement, calculation or setting capability of a medical device.
         */
        DEVICEMETRIC, 
        /**
         * Represents a request for a patient to employ a medical device. The device may be an implantable device, or an external assistive device, such as a walker.
         */
        DEVICEREQUEST, 
        /**
         * A record of a device being used by a patient where the record is the result of a report from the patient or another clinician.
         */
        DEVICEUSESTATEMENT, 
        /**
         * The findings and interpretation of diagnostic  tests performed on patients, groups of patients, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting and provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports.
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
         * An interaction between a patient and healthcare provider(s) for the purpose of providing healthcare service(s) or assessing the health status of a patient.
         */
        ENCOUNTER, 
        /**
         * The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b or a REST endpoint for another FHIR server. This may include any security context information.
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
         * This represents statistics, certainty, both the intended and actual population, and evidence variables.
         */
        EVIDENCE, 
        /**
         * The EvidenceVariable resource describes a "PICO" element that knowledge (evidence, assertion, recommendation) is about.
         */
        EVIDENCEVARIABLE, 
        /**
         * Example of workflow instance.
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
         * The details of a healthcare service available at a location.
         */
        HEALTHCARESERVICE, 
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
         * A list is a curated collection of resources.
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
         * This resource is primarily used for the identification and definition of a medication for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.
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
         * Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use).
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
         * Raw data describing a biological sequence.
         */
        MOLECULARSEQUENCE, 
        /**
         * A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a "System" used within the Identifier and Coding data types.
         */
        NAMINGSYSTEM, 
        /**
         * A record of food or fluid that is being consumed by a patient.   A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.
         */
        NUTRITIONINTAKE, 
        /**
         * A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.
         */
        NUTRITIONORDER, 
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
         * Defines an affiliation/assotiation/relationship between 2 distinct oganizations, that is not a part-of relationship/sub-division relationship.
         */
        ORGANIZATIONAFFILIATION, 
        /**
         * A medicinal product in a container or package.
         */
        PACKAGEDPRODUCTDEFINITION, 
        /**
         * This resource is a non-persisted resource used to pass information into and back from an [operation](operations.html). It has no other use, and there is no RESTful endpoint associated with it.
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
         * Demographics and administrative information about a person independent of a specific health-related context.
         */
        PERSON, 
        /**
         * This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical artifacts such as clinical decision support rules, order sets and protocols.
         */
        PLANDEFINITION, 
        /**
         * A person who is directly or indirectly involved in the provisioning of healthcare.
         */
        PRACTITIONER, 
        /**
         * A specific set of Roles/Locations/specialties/services that a practitioner may perform at an organization for a period of time.
         */
        PRACTITIONERROLE, 
        /**
         * An action that is or was performed on or for a patient. This can be a physical intervention like an operation, or less invasive like long term services, counseling, or hypnotherapy.
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
         * The regulatory authorization of a medicinal product.
         */
        REGULATEDAUTHORIZATION, 
        /**
         * Information about a person that is involved in the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.
         */
        RELATEDPERSON, 
        /**
         * A group of related requests that can be used to capture intended activities that have inter-dependencies such as "give this medication after that one".
         */
        REQUESTGROUP, 
        /**
         * A process where a researcher or organization plans and then executes a series of steps intended to increase the field of healthcare-related knowledge.  This includes studies of safety, efficacy, comparative effectiveness and other information about medications, devices, therapies and other interventional and investigative techniques.  A ResearchStudy involves the gathering of information about human or animal subjects.
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
         * The subscription resource describes a particular client's request to be notified about a Topic.
         */
        SUBSCRIPTION, 
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
         * Todo.
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
         * A record of a request for a medication, substance or device used in the healthcare setting.
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
         * Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.
         */
        TOPIC, 
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
        public static ResourceTypeEnum fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Account".equals(codeString))
          return ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return ACTIVITYDEFINITION;
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
        if ("CapabilityStatement2".equals(codeString))
          return CAPABILITYSTATEMENT2;
        if ("CarePlan".equals(codeString))
          return CAREPLAN;
        if ("CareTeam".equals(codeString))
          return CARETEAM;
        if ("CatalogEntry".equals(codeString))
          return CATALOGENTRY;
        if ("ChargeItem".equals(codeString))
          return CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return CHARGEITEMDEFINITION;
        if ("Claim".equals(codeString))
          return CLAIM;
        if ("ClaimResponse".equals(codeString))
          return CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return CLINICALIMPRESSION;
        if ("ClinicalUseIssue".equals(codeString))
          return CLINICALUSEISSUE;
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
        if ("DeviceMetric".equals(codeString))
          return DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return DEVICEREQUEST;
        if ("DeviceUseStatement".equals(codeString))
          return DEVICEUSESTATEMENT;
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
        if ("RequestGroup".equals(codeString))
          return REQUESTGROUP;
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
        if ("Topic".equals(codeString))
          return TOPIC;
        if ("ValueSet".equals(codeString))
          return VALUESET;
        if ("VerificationResult".equals(codeString))
          return VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return VISIONPRESCRIPTION;
        throw new FHIRException("Unknown ResourceTypeEnum code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAPABILITYSTATEMENT2: return "CapabilityStatement2";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CATALOGENTRY: return "CatalogEntry";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEISSUE: return "ClinicalUseIssue";
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
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSESTATEMENT: return "DeviceUseStatement";
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
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
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
            case REQUESTGROUP: return "RequestGroup";
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
            case TOPIC: return "Topic";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACCOUNT: return "http://hl7.org/fhir/resource-types";
            case ACTIVITYDEFINITION: return "http://hl7.org/fhir/resource-types";
            case ADMINISTRABLEPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case ADVERSEEVENT: return "http://hl7.org/fhir/resource-types";
            case ALLERGYINTOLERANCE: return "http://hl7.org/fhir/resource-types";
            case APPOINTMENT: return "http://hl7.org/fhir/resource-types";
            case APPOINTMENTRESPONSE: return "http://hl7.org/fhir/resource-types";
            case AUDITEVENT: return "http://hl7.org/fhir/resource-types";
            case BASIC: return "http://hl7.org/fhir/resource-types";
            case BINARY: return "http://hl7.org/fhir/resource-types";
            case BIOLOGICALLYDERIVEDPRODUCT: return "http://hl7.org/fhir/resource-types";
            case BODYSTRUCTURE: return "http://hl7.org/fhir/resource-types";
            case BUNDLE: return "http://hl7.org/fhir/resource-types";
            case CAPABILITYSTATEMENT: return "http://hl7.org/fhir/resource-types";
            case CAPABILITYSTATEMENT2: return "http://hl7.org/fhir/resource-types";
            case CAREPLAN: return "http://hl7.org/fhir/resource-types";
            case CARETEAM: return "http://hl7.org/fhir/resource-types";
            case CATALOGENTRY: return "http://hl7.org/fhir/resource-types";
            case CHARGEITEM: return "http://hl7.org/fhir/resource-types";
            case CHARGEITEMDEFINITION: return "http://hl7.org/fhir/resource-types";
            case CLAIM: return "http://hl7.org/fhir/resource-types";
            case CLAIMRESPONSE: return "http://hl7.org/fhir/resource-types";
            case CLINICALIMPRESSION: return "http://hl7.org/fhir/resource-types";
            case CLINICALUSEISSUE: return "http://hl7.org/fhir/resource-types";
            case CODESYSTEM: return "http://hl7.org/fhir/resource-types";
            case COMMUNICATION: return "http://hl7.org/fhir/resource-types";
            case COMMUNICATIONREQUEST: return "http://hl7.org/fhir/resource-types";
            case COMPARTMENTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case COMPOSITION: return "http://hl7.org/fhir/resource-types";
            case CONCEPTMAP: return "http://hl7.org/fhir/resource-types";
            case CONDITION: return "http://hl7.org/fhir/resource-types";
            case CONDITIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case CONSENT: return "http://hl7.org/fhir/resource-types";
            case CONTRACT: return "http://hl7.org/fhir/resource-types";
            case COVERAGE: return "http://hl7.org/fhir/resource-types";
            case COVERAGEELIGIBILITYREQUEST: return "http://hl7.org/fhir/resource-types";
            case COVERAGEELIGIBILITYRESPONSE: return "http://hl7.org/fhir/resource-types";
            case DETECTEDISSUE: return "http://hl7.org/fhir/resource-types";
            case DEVICE: return "http://hl7.org/fhir/resource-types";
            case DEVICEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case DEVICEMETRIC: return "http://hl7.org/fhir/resource-types";
            case DEVICEREQUEST: return "http://hl7.org/fhir/resource-types";
            case DEVICEUSESTATEMENT: return "http://hl7.org/fhir/resource-types";
            case DIAGNOSTICREPORT: return "http://hl7.org/fhir/resource-types";
            case DOCUMENTMANIFEST: return "http://hl7.org/fhir/resource-types";
            case DOCUMENTREFERENCE: return "http://hl7.org/fhir/resource-types";
            case DOMAINRESOURCE: return "http://hl7.org/fhir/resource-types";
            case ENCOUNTER: return "http://hl7.org/fhir/resource-types";
            case ENDPOINT: return "http://hl7.org/fhir/resource-types";
            case ENROLLMENTREQUEST: return "http://hl7.org/fhir/resource-types";
            case ENROLLMENTRESPONSE: return "http://hl7.org/fhir/resource-types";
            case EPISODEOFCARE: return "http://hl7.org/fhir/resource-types";
            case EVENTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case EVIDENCE: return "http://hl7.org/fhir/resource-types";
            case EVIDENCEVARIABLE: return "http://hl7.org/fhir/resource-types";
            case EXAMPLESCENARIO: return "http://hl7.org/fhir/resource-types";
            case EXPLANATIONOFBENEFIT: return "http://hl7.org/fhir/resource-types";
            case FAMILYMEMBERHISTORY: return "http://hl7.org/fhir/resource-types";
            case FLAG: return "http://hl7.org/fhir/resource-types";
            case GOAL: return "http://hl7.org/fhir/resource-types";
            case GRAPHDEFINITION: return "http://hl7.org/fhir/resource-types";
            case GROUP: return "http://hl7.org/fhir/resource-types";
            case GUIDANCERESPONSE: return "http://hl7.org/fhir/resource-types";
            case HEALTHCARESERVICE: return "http://hl7.org/fhir/resource-types";
            case IMAGINGSTUDY: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATION: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATIONEVALUATION: return "http://hl7.org/fhir/resource-types";
            case IMMUNIZATIONRECOMMENDATION: return "http://hl7.org/fhir/resource-types";
            case IMPLEMENTATIONGUIDE: return "http://hl7.org/fhir/resource-types";
            case INGREDIENT: return "http://hl7.org/fhir/resource-types";
            case INSURANCEPLAN: return "http://hl7.org/fhir/resource-types";
            case INVOICE: return "http://hl7.org/fhir/resource-types";
            case LIBRARY: return "http://hl7.org/fhir/resource-types";
            case LINKAGE: return "http://hl7.org/fhir/resource-types";
            case LIST: return "http://hl7.org/fhir/resource-types";
            case LOCATION: return "http://hl7.org/fhir/resource-types";
            case MANUFACTUREDITEMDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MEASURE: return "http://hl7.org/fhir/resource-types";
            case MEASUREREPORT: return "http://hl7.org/fhir/resource-types";
            case MEDICATION: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONADMINISTRATION: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONDISPENSE: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONKNOWLEDGE: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONREQUEST: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONUSAGE: return "http://hl7.org/fhir/resource-types";
            case MEDICINALPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MESSAGEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case MESSAGEHEADER: return "http://hl7.org/fhir/resource-types";
            case MOLECULARSEQUENCE: return "http://hl7.org/fhir/resource-types";
            case NAMINGSYSTEM: return "http://hl7.org/fhir/resource-types";
            case NUTRITIONINTAKE: return "http://hl7.org/fhir/resource-types";
            case NUTRITIONORDER: return "http://hl7.org/fhir/resource-types";
            case OBSERVATION: return "http://hl7.org/fhir/resource-types";
            case OBSERVATIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case OPERATIONDEFINITION: return "http://hl7.org/fhir/resource-types";
            case OPERATIONOUTCOME: return "http://hl7.org/fhir/resource-types";
            case ORGANIZATION: return "http://hl7.org/fhir/resource-types";
            case ORGANIZATIONAFFILIATION: return "http://hl7.org/fhir/resource-types";
            case PACKAGEDPRODUCTDEFINITION: return "http://hl7.org/fhir/resource-types";
            case PARAMETERS: return "http://hl7.org/fhir/resource-types";
            case PATIENT: return "http://hl7.org/fhir/resource-types";
            case PAYMENTNOTICE: return "http://hl7.org/fhir/resource-types";
            case PAYMENTRECONCILIATION: return "http://hl7.org/fhir/resource-types";
            case PERSON: return "http://hl7.org/fhir/resource-types";
            case PLANDEFINITION: return "http://hl7.org/fhir/resource-types";
            case PRACTITIONER: return "http://hl7.org/fhir/resource-types";
            case PRACTITIONERROLE: return "http://hl7.org/fhir/resource-types";
            case PROCEDURE: return "http://hl7.org/fhir/resource-types";
            case PROVENANCE: return "http://hl7.org/fhir/resource-types";
            case QUESTIONNAIRE: return "http://hl7.org/fhir/resource-types";
            case QUESTIONNAIRERESPONSE: return "http://hl7.org/fhir/resource-types";
            case REGULATEDAUTHORIZATION: return "http://hl7.org/fhir/resource-types";
            case RELATEDPERSON: return "http://hl7.org/fhir/resource-types";
            case REQUESTGROUP: return "http://hl7.org/fhir/resource-types";
            case RESEARCHSTUDY: return "http://hl7.org/fhir/resource-types";
            case RESEARCHSUBJECT: return "http://hl7.org/fhir/resource-types";
            case RESOURCE: return "http://hl7.org/fhir/resource-types";
            case RISKASSESSMENT: return "http://hl7.org/fhir/resource-types";
            case SCHEDULE: return "http://hl7.org/fhir/resource-types";
            case SEARCHPARAMETER: return "http://hl7.org/fhir/resource-types";
            case SERVICEREQUEST: return "http://hl7.org/fhir/resource-types";
            case SLOT: return "http://hl7.org/fhir/resource-types";
            case SPECIMEN: return "http://hl7.org/fhir/resource-types";
            case SPECIMENDEFINITION: return "http://hl7.org/fhir/resource-types";
            case STRUCTUREDEFINITION: return "http://hl7.org/fhir/resource-types";
            case STRUCTUREMAP: return "http://hl7.org/fhir/resource-types";
            case SUBSCRIPTION: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCE: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEDEFINITION: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCENUCLEICACID: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEPOLYMER: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEPROTEIN: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCEREFERENCEINFORMATION: return "http://hl7.org/fhir/resource-types";
            case SUBSTANCESOURCEMATERIAL: return "http://hl7.org/fhir/resource-types";
            case SUPPLYDELIVERY: return "http://hl7.org/fhir/resource-types";
            case SUPPLYREQUEST: return "http://hl7.org/fhir/resource-types";
            case TASK: return "http://hl7.org/fhir/resource-types";
            case TERMINOLOGYCAPABILITIES: return "http://hl7.org/fhir/resource-types";
            case TESTREPORT: return "http://hl7.org/fhir/resource-types";
            case TESTSCRIPT: return "http://hl7.org/fhir/resource-types";
            case TOPIC: return "http://hl7.org/fhir/resource-types";
            case VALUESET: return "http://hl7.org/fhir/resource-types";
            case VERIFICATIONRESULT: return "http://hl7.org/fhir/resource-types";
            case VISIONPRESCRIPTION: return "http://hl7.org/fhir/resource-types";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACCOUNT: return "A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.";
            case ACTIVITYDEFINITION: return "This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.";
            case ADMINISTRABLEPRODUCTDEFINITION: return "A pharmaceutical product described in terms of its composition and dose form.";
            case ADVERSEEVENT: return "An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject.  The unintended effects may require additional monitoring, treatment or hospitalization or may result in death.  The AdverseEvent resource also extends to potential or avoided events that could have had such effects.";
            case ALLERGYINTOLERANCE: return "Risk of harmful or undesirable, physiological response which is unique to an individual and associated with exposure to a substance.";
            case APPOINTMENT: return "A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).";
            case APPOINTMENTRESPONSE: return "A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.";
            case AUDITEVENT: return "A record of an event relevant for purposes such as operations, privacy, security, maintenance, and performance analysis.";
            case BASIC: return "Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.";
            case BINARY: return "A resource that represents the data of a single raw artifact as digital content accessible in its native format.  A Binary resource can contain any content, whether text, image, pdf, zip archive, etc.";
            case BIOLOGICALLYDERIVEDPRODUCT: return "A material substance originating from a biological entity intended to be transplanted or infused\ninto another (possibly the same) biological entity.";
            case BODYSTRUCTURE: return "Record details about an anatomical structure.  This resource may be used when a coded concept does not provide the necessary detail needed for the use case.";
            case BUNDLE: return "A container for a collection of resources.";
            case CAPABILITYSTATEMENT: return "A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case CAPABILITYSTATEMENT2: return "A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case CAREPLAN: return "Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.";
            case CARETEAM: return "The Care Team includes all the people and organizations who plan to participate in the coordination and delivery of care.";
            case CATALOGENTRY: return "Catalog entries are wrappers that contextualize items included in a catalog.";
            case CHARGEITEM: return "The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.";
            case CHARGEITEMDEFINITION: return "The ChargeItemDefinition resource provides the properties that apply to the (billing) codes necessary to calculate costs and prices. The properties may differ largely depending on type and realm, therefore this resource gives only a rough structure and requires profiling for each type of billing code system.";
            case CLAIM: return "A provider issued list of professional services and products which have been provided, or are to be provided, to a patient which is sent to an insurer for reimbursement.";
            case CLAIMRESPONSE: return "This resource provides the adjudication details from the processing of a Claim resource.";
            case CLINICALIMPRESSION: return "A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called \"ClinicalImpression\" rather than \"ClinicalAssessment\" to avoid confusion with the recording of assessment tools such as Apgar score.";
            case CLINICALUSEISSUE: return "A single usage issue - either an indication, contraindication, interaction or an undesirable effect for a medicinal product, medication, device or procedure.";
            case CODESYSTEM: return "The CodeSystem resource is used to declare the existence of and describe a code system or code system supplement and its key properties, and optionally define a part or all of its content.";
            case COMMUNICATION: return "An occurrence of information being transmitted; e.g. an alert that was sent to a responsible provider, a public health agency communication to a provider/reporter in response to a case report for a reportable condition.";
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
            case DEVICE: return "A type of a manufactured item that is used in the provision of healthcare without being substantially changed through that activity. The device may be a medical or non-medical device.";
            case DEVICEDEFINITION: return "The characteristics, operational status and capabilities of a medical-related component of a medical device.";
            case DEVICEMETRIC: return "Describes a measurement, calculation or setting capability of a medical device.";
            case DEVICEREQUEST: return "Represents a request for a patient to employ a medical device. The device may be an implantable device, or an external assistive device, such as a walker.";
            case DEVICEUSESTATEMENT: return "A record of a device being used by a patient where the record is the result of a report from the patient or another clinician.";
            case DIAGNOSTICREPORT: return "The findings and interpretation of diagnostic  tests performed on patients, groups of patients, devices, and locations, and/or specimens derived from these. The report includes clinical context such as requesting and provider information, and some mix of atomic results, images, textual and coded interpretations, and formatted representation of diagnostic reports.";
            case DOCUMENTMANIFEST: return "A collection of documents compiled for a purpose together with metadata that applies to the collection.";
            case DOCUMENTREFERENCE: return "A reference to a document of any kind for any purpose. While the term “document” implies a more narrow focus, for this resource this \"document\" encompasses *any* serialized object with a mime-type, it includes formal patient-centric documents (CDA), clinical notes, scanned paper, non-patient specific documents like policy text, as well as a photo, video, or audio recording acquired or used in healthcare.  The DocumentReference resource provides metadata about the document so that the document can be discovered and managed.  The actual content may be inline base64 encoded data or provided by direct reference.";
            case DOMAINRESOURCE: return "A resource that includes narrative, extensions, and contained resources.";
            case ENCOUNTER: return "An interaction between a patient and healthcare provider(s) for the purpose of providing healthcare service(s) or assessing the health status of a patient.";
            case ENDPOINT: return "The technical details of an endpoint that can be used for electronic services, such as for web services providing XDS.b or a REST endpoint for another FHIR server. This may include any security context information.";
            case ENROLLMENTREQUEST: return "This resource provides the insurance enrollment details to the insurer regarding a specified coverage.";
            case ENROLLMENTRESPONSE: return "This resource provides enrollment and plan details from the processing of an EnrollmentRequest resource.";
            case EPISODEOFCARE: return "An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.";
            case EVENTDEFINITION: return "The EventDefinition resource provides a reusable description of when a particular event can occur.";
            case EVIDENCE: return "This represents statistics, certainty, both the intended and actual population, and evidence variables.";
            case EVIDENCEVARIABLE: return "The EvidenceVariable resource describes a \"PICO\" element that knowledge (evidence, assertion, recommendation) is about.";
            case EXAMPLESCENARIO: return "Example of workflow instance.";
            case EXPLANATIONOFBENEFIT: return "This resource provides: the claim details; adjudication details from the processing of a Claim; and optionally account balance information, for informing the subscriber of the benefits provided.";
            case FAMILYMEMBERHISTORY: return "Significant health conditions for a person related to the patient relevant in the context of care for the patient.";
            case FLAG: return "Prospective warnings of potential issues when providing care to the patient.";
            case GOAL: return "Describes the intended objective(s) for a patient, group or organization care, for example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, etc.";
            case GRAPHDEFINITION: return "A formal computable definition of a graph of resources - that is, a coherent set of resources that form a graph by following references. The Graph Definition resource defines a set and makes rules about the set.";
            case GROUP: return "Represents a defined collection of entities that may be discussed or acted upon collectively but which are not expected to act collectively, and are not formally or legally recognized; i.e. a collection of entities that isn't an Organization.";
            case GUIDANCERESPONSE: return "A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.";
            case HEALTHCARESERVICE: return "The details of a healthcare service available at a location.";
            case IMAGINGSTUDY: return "Representation of the content produced in a DICOM imaging study. A study comprises a set of series, each of which includes a set of Service-Object Pair Instances (SOP Instances - images or other data) acquired or produced in a common context.  A series is of only one modality (e.g. X-ray, CT, MR, ultrasound), but a study may have multiple series of different modalities.";
            case IMMUNIZATION: return "Describes the event of a patient being administered a vaccine or a record of an immunization as reported by a patient, a clinician or another party.";
            case IMMUNIZATIONEVALUATION: return "Describes a comparison of an immunization event against published recommendations to determine if the administration is \"valid\" in relation to those  recommendations.";
            case IMMUNIZATIONRECOMMENDATION: return "A patient's point-in-time set of recommendations (i.e. forecasting) according to a published schedule with optional supporting justification.";
            case IMPLEMENTATIONGUIDE: return "A set of rules of how a particular interoperability or standards problem is solved - typically through the use of FHIR resources. This resource is used to gather all the parts of an implementation guide into a logical whole and to publish a computable definition of all the parts.";
            case INGREDIENT: return "An ingredient of a manufactured item or pharmaceutical product.";
            case INSURANCEPLAN: return "Details of a Health Insurance product/plan provided by an organization.";
            case INVOICE: return "Invoice containing collected ChargeItems from an Account with calculated individual and total price for Billing purpose.";
            case LIBRARY: return "The Library resource is a general-purpose container for knowledge asset definitions. It can be used to describe and expose existing knowledge assets such as logic libraries and information model descriptions, as well as to describe a collection of knowledge assets.";
            case LINKAGE: return "Identifies two or more records (resource instances) that refer to the same real-world \"occurrence\".";
            case LIST: return "A list is a curated collection of resources.";
            case LOCATION: return "Details and position information for a physical place where services are provided and resources and participants may be stored, found, contained, or accommodated.";
            case MANUFACTUREDITEMDEFINITION: return "The definition and characteristics of a medicinal manufactured item, such as a tablet or capsule, as contained in a packaged medicinal product.";
            case MEASURE: return "The Measure resource provides the definition of a quality measure.";
            case MEASUREREPORT: return "The MeasureReport resource contains the results of the calculation of a measure; and optionally a reference to the resources involved in that calculation.";
            case MEDICATION: return "This resource is primarily used for the identification and definition of a medication for the purposes of prescribing, dispensing, and administering a medication as well as for making statements about medication use.";
            case MEDICATIONADMINISTRATION: return "Describes the event of a patient consuming or otherwise being administered a medication.  This may be as simple as swallowing a tablet or it may be a long running infusion.  Related resources tie this event to the authorizing prescription, and the specific encounter between patient and health care practitioner.";
            case MEDICATIONDISPENSE: return "Indicates that a medication product is to be or has been dispensed for a named person/patient.  This includes a description of the medication product (supply) provided and the instructions for administering the medication.  The medication dispense is the result of a pharmacy system responding to a medication order.";
            case MEDICATIONKNOWLEDGE: return "Information about a medication that is used to support knowledge.";
            case MEDICATIONREQUEST: return "An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called \"MedicationRequest\" rather than \"MedicationPrescription\" or \"MedicationOrder\" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.";
            case MEDICATIONUSAGE: return "A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. \n\nThe primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.";
            case MEDICINALPRODUCTDEFINITION: return "Detailed definition of a medicinal product, typically for uses other than direct patient care (e.g. regulatory use).";
            case MESSAGEDEFINITION: return "Defines the characteristics of a message that can be shared between systems, including the type of event that initiates the message, the content to be transmitted and what response(s), if any, are permitted.";
            case MESSAGEHEADER: return "The header for a message exchange that is either requesting or responding to an action.  The reference(s) that are the subject of the action as well as other information related to the action are typically transmitted in a bundle in which the MessageHeader resource instance is the first resource in the bundle.";
            case MOLECULARSEQUENCE: return "Raw data describing a biological sequence.";
            case NAMINGSYSTEM: return "A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a \"System\" used within the Identifier and Coding data types.";
            case NUTRITIONINTAKE: return "A record of food or fluid that is being consumed by a patient.   A NutritionIntake may indicate that the patient may be consuming the food or fluid now or has consumed the food or fluid in the past.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay or through an app that tracks food or fluids consumed.   The consumption information may come from sources such as the patient's memory, from a nutrition label,  or from a clinician documenting observed intake.";
            case NUTRITIONORDER: return "A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.";
            case OBSERVATION: return "Measurements and simple assertions made about a patient, device or other subject.";
            case OBSERVATIONDEFINITION: return "Set of definitional characteristics for a kind of observation or measurement produced or consumed by an orderable health care service.";
            case OPERATIONDEFINITION: return "A formal computable definition of an operation (on the RESTful interface) or a named query (using the search interaction).";
            case OPERATIONOUTCOME: return "A collection of error, warning, or information messages that result from a system action.";
            case ORGANIZATION: return "A formally or informally recognized grouping of people or organizations formed for the purpose of achieving some form of collective action.  Includes companies, institutions, corporations, departments, community groups, healthcare practice groups, payer/insurer, etc.";
            case ORGANIZATIONAFFILIATION: return "Defines an affiliation/assotiation/relationship between 2 distinct oganizations, that is not a part-of relationship/sub-division relationship.";
            case PACKAGEDPRODUCTDEFINITION: return "A medicinal product in a container or package.";
            case PARAMETERS: return "This resource is a non-persisted resource used to pass information into and back from an [operation](operations.html). It has no other use, and there is no RESTful endpoint associated with it.";
            case PATIENT: return "Demographics and other administrative information about an individual or animal receiving care or other health-related services.";
            case PAYMENTNOTICE: return "This resource provides the status of the payment for goods and services rendered, and the request and response resource references.";
            case PAYMENTRECONCILIATION: return "This resource provides the details including amount of a payment and allocates the payment items being paid.";
            case PERSON: return "Demographics and administrative information about a person independent of a specific health-related context.";
            case PLANDEFINITION: return "This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical artifacts such as clinical decision support rules, order sets and protocols.";
            case PRACTITIONER: return "A person who is directly or indirectly involved in the provisioning of healthcare.";
            case PRACTITIONERROLE: return "A specific set of Roles/Locations/specialties/services that a practitioner may perform at an organization for a period of time.";
            case PROCEDURE: return "An action that is or was performed on or for a patient. This can be a physical intervention like an operation, or less invasive like long term services, counseling, or hypnotherapy.";
            case PROVENANCE: return "Provenance of a resource is a record that describes entities and processes involved in producing and delivering or otherwise influencing that resource. Provenance provides a critical foundation for assessing authenticity, enabling trust, and allowing reproducibility. Provenance assertions are a form of contextual metadata and can themselves become important records with their own provenance. Provenance statement indicates clinical significance in terms of confidence in authenticity, reliability, and trustworthiness, integrity, and stage in lifecycle (e.g. Document Completion - has the artifact been legally authenticated), all of which may impact security, privacy, and trust policies.";
            case QUESTIONNAIRE: return "A structured set of questions intended to guide the collection of answers from end-users. Questionnaires provide detailed control over order, presentation, phraseology and grouping to allow coherent, consistent data collection.";
            case QUESTIONNAIRERESPONSE: return "A structured set of questions and their answers. The questions are ordered and grouped into coherent subsets, corresponding to the structure of the grouping of the questionnaire being responded to.";
            case REGULATEDAUTHORIZATION: return "The regulatory authorization of a medicinal product.";
            case RELATEDPERSON: return "Information about a person that is involved in the care for a patient, but who is not the target of healthcare, nor has a formal responsibility in the care process.";
            case REQUESTGROUP: return "A group of related requests that can be used to capture intended activities that have inter-dependencies such as \"give this medication after that one\".";
            case RESEARCHSTUDY: return "A process where a researcher or organization plans and then executes a series of steps intended to increase the field of healthcare-related knowledge.  This includes studies of safety, efficacy, comparative effectiveness and other information about medications, devices, therapies and other interventional and investigative techniques.  A ResearchStudy involves the gathering of information about human or animal subjects.";
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
            case SUBSCRIPTION: return "The subscription resource describes a particular client's request to be notified about a Topic.";
            case SUBSTANCE: return "A homogeneous material with a definite composition.";
            case SUBSTANCEDEFINITION: return "The detailed description of a substance, typically at a level beyond what is used for prescribing.";
            case SUBSTANCENUCLEICACID: return "Nucleic acids are defined by three distinct elements: the base, sugar and linkage. Individual substance/moiety IDs will be created for each of these elements. The nucleotide sequence will be always entered in the 5’-3’ direction.";
            case SUBSTANCEPOLYMER: return "Todo.";
            case SUBSTANCEPROTEIN: return "A SubstanceProtein is defined as a single unit of a linear amino acid sequence, or a combination of subunits that are either covalently linked or have a defined invariant stoichiometric relationship. This includes all synthetic, recombinant and purified SubstanceProteins of defined sequence, whether the use is therapeutic or prophylactic. This set of elements will be used to describe albumins, coagulation factors, cytokines, growth factors, peptide/SubstanceProtein hormones, enzymes, toxins, toxoids, recombinant vaccines, and immunomodulators.";
            case SUBSTANCEREFERENCEINFORMATION: return "Todo.";
            case SUBSTANCESOURCEMATERIAL: return "Source material shall capture information on the taxonomic and anatomical origins as well as the fraction of a material that can result in or can be modified to form a substance. This set of data elements shall be used to define polymer substances isolated from biological matrices. Taxonomic and anatomical origins shall be described using a controlled vocabulary as required. This information is captured for naturally derived polymers ( . starch) and structurally diverse substances. For Organisms belonging to the Kingdom Plantae the Substance level defines the fresh material of a single species or infraspecies, the Herbal Drug and the Herbal preparation. For Herbal preparations, the fraction information will be captured at the Substance information level and additional information for herbal extracts will be captured at the Specified Substance Group 1 information level. See for further explanation the Substance Class: Structurally Diverse and the herbal annex.";
            case SUPPLYDELIVERY: return "Record of delivery of what is supplied.";
            case SUPPLYREQUEST: return "A record of a request for a medication, substance or device used in the healthcare setting.";
            case TASK: return "A task to be performed.";
            case TERMINOLOGYCAPABILITIES: return "A TerminologyCapabilities resource documents a set of capabilities (behaviors) of a FHIR Terminology Server that may be used as a statement of actual server functionality or a statement of required or desired server implementation.";
            case TESTREPORT: return "A summary of information based on the results of executing a TestScript.";
            case TESTSCRIPT: return "A structured set of tests against a FHIR server or client implementation to determine compliance against the FHIR specification.";
            case TOPIC: return "Describes a stream of resource state changes identified by trigger criteria and annotated with labels useful to filter projections from this topic.";
            case VALUESET: return "A ValueSet resource instance specifies a set of codes drawn from one or more code systems, intended for use in a particular context. Value sets link between [[[CodeSystem]]] definitions and their use in [coded elements](terminologies.html).";
            case VERIFICATIONRESULT: return "Describes validation requirements, source(s), status and dates for one or more elements.";
            case VISIONPRESCRIPTION: return "An authorization for the provision of glasses and/or contact lenses to a patient.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACCOUNT: return "Account";
            case ACTIVITYDEFINITION: return "ActivityDefinition";
            case ADMINISTRABLEPRODUCTDEFINITION: return "AdministrableProductDefinition";
            case ADVERSEEVENT: return "AdverseEvent";
            case ALLERGYINTOLERANCE: return "AllergyIntolerance";
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case AUDITEVENT: return "AuditEvent";
            case BASIC: return "Basic";
            case BINARY: return "Binary";
            case BIOLOGICALLYDERIVEDPRODUCT: return "BiologicallyDerivedProduct";
            case BODYSTRUCTURE: return "BodyStructure";
            case BUNDLE: return "Bundle";
            case CAPABILITYSTATEMENT: return "CapabilityStatement";
            case CAPABILITYSTATEMENT2: return "CapabilityStatement2";
            case CAREPLAN: return "CarePlan";
            case CARETEAM: return "CareTeam";
            case CATALOGENTRY: return "CatalogEntry";
            case CHARGEITEM: return "ChargeItem";
            case CHARGEITEMDEFINITION: return "ChargeItemDefinition";
            case CLAIM: return "Claim";
            case CLAIMRESPONSE: return "ClaimResponse";
            case CLINICALIMPRESSION: return "ClinicalImpression";
            case CLINICALUSEISSUE: return "ClinicalUseIssue";
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
            case DEVICEMETRIC: return "DeviceMetric";
            case DEVICEREQUEST: return "DeviceRequest";
            case DEVICEUSESTATEMENT: return "DeviceUseStatement";
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
            case EVIDENCEVARIABLE: return "EvidenceVariable";
            case EXAMPLESCENARIO: return "ExampleScenario";
            case EXPLANATIONOFBENEFIT: return "ExplanationOfBenefit";
            case FAMILYMEMBERHISTORY: return "FamilyMemberHistory";
            case FLAG: return "Flag";
            case GOAL: return "Goal";
            case GRAPHDEFINITION: return "GraphDefinition";
            case GROUP: return "Group";
            case GUIDANCERESPONSE: return "GuidanceResponse";
            case HEALTHCARESERVICE: return "HealthcareService";
            case IMAGINGSTUDY: return "ImagingStudy";
            case IMMUNIZATION: return "Immunization";
            case IMMUNIZATIONEVALUATION: return "ImmunizationEvaluation";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case IMPLEMENTATIONGUIDE: return "ImplementationGuide";
            case INGREDIENT: return "Ingredient";
            case INSURANCEPLAN: return "InsurancePlan";
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
            case REQUESTGROUP: return "RequestGroup";
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
            case TOPIC: return "Topic";
            case VALUESET: return "ValueSet";
            case VERIFICATIONRESULT: return "VerificationResult";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            default: return "?";
          }
        }
    }

  public static class ResourceTypeEnumEnumFactory implements EnumFactory<ResourceTypeEnum> {
    public ResourceTypeEnum fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Account".equals(codeString))
          return ResourceTypeEnum.ACCOUNT;
        if ("ActivityDefinition".equals(codeString))
          return ResourceTypeEnum.ACTIVITYDEFINITION;
        if ("AdministrableProductDefinition".equals(codeString))
          return ResourceTypeEnum.ADMINISTRABLEPRODUCTDEFINITION;
        if ("AdverseEvent".equals(codeString))
          return ResourceTypeEnum.ADVERSEEVENT;
        if ("AllergyIntolerance".equals(codeString))
          return ResourceTypeEnum.ALLERGYINTOLERANCE;
        if ("Appointment".equals(codeString))
          return ResourceTypeEnum.APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return ResourceTypeEnum.APPOINTMENTRESPONSE;
        if ("AuditEvent".equals(codeString))
          return ResourceTypeEnum.AUDITEVENT;
        if ("Basic".equals(codeString))
          return ResourceTypeEnum.BASIC;
        if ("Binary".equals(codeString))
          return ResourceTypeEnum.BINARY;
        if ("BiologicallyDerivedProduct".equals(codeString))
          return ResourceTypeEnum.BIOLOGICALLYDERIVEDPRODUCT;
        if ("BodyStructure".equals(codeString))
          return ResourceTypeEnum.BODYSTRUCTURE;
        if ("Bundle".equals(codeString))
          return ResourceTypeEnum.BUNDLE;
        if ("CapabilityStatement".equals(codeString))
          return ResourceTypeEnum.CAPABILITYSTATEMENT;
        if ("CapabilityStatement2".equals(codeString))
          return ResourceTypeEnum.CAPABILITYSTATEMENT2;
        if ("CarePlan".equals(codeString))
          return ResourceTypeEnum.CAREPLAN;
        if ("CareTeam".equals(codeString))
          return ResourceTypeEnum.CARETEAM;
        if ("CatalogEntry".equals(codeString))
          return ResourceTypeEnum.CATALOGENTRY;
        if ("ChargeItem".equals(codeString))
          return ResourceTypeEnum.CHARGEITEM;
        if ("ChargeItemDefinition".equals(codeString))
          return ResourceTypeEnum.CHARGEITEMDEFINITION;
        if ("Claim".equals(codeString))
          return ResourceTypeEnum.CLAIM;
        if ("ClaimResponse".equals(codeString))
          return ResourceTypeEnum.CLAIMRESPONSE;
        if ("ClinicalImpression".equals(codeString))
          return ResourceTypeEnum.CLINICALIMPRESSION;
        if ("ClinicalUseIssue".equals(codeString))
          return ResourceTypeEnum.CLINICALUSEISSUE;
        if ("CodeSystem".equals(codeString))
          return ResourceTypeEnum.CODESYSTEM;
        if ("Communication".equals(codeString))
          return ResourceTypeEnum.COMMUNICATION;
        if ("CommunicationRequest".equals(codeString))
          return ResourceTypeEnum.COMMUNICATIONREQUEST;
        if ("CompartmentDefinition".equals(codeString))
          return ResourceTypeEnum.COMPARTMENTDEFINITION;
        if ("Composition".equals(codeString))
          return ResourceTypeEnum.COMPOSITION;
        if ("ConceptMap".equals(codeString))
          return ResourceTypeEnum.CONCEPTMAP;
        if ("Condition".equals(codeString))
          return ResourceTypeEnum.CONDITION;
        if ("ConditionDefinition".equals(codeString))
          return ResourceTypeEnum.CONDITIONDEFINITION;
        if ("Consent".equals(codeString))
          return ResourceTypeEnum.CONSENT;
        if ("Contract".equals(codeString))
          return ResourceTypeEnum.CONTRACT;
        if ("Coverage".equals(codeString))
          return ResourceTypeEnum.COVERAGE;
        if ("CoverageEligibilityRequest".equals(codeString))
          return ResourceTypeEnum.COVERAGEELIGIBILITYREQUEST;
        if ("CoverageEligibilityResponse".equals(codeString))
          return ResourceTypeEnum.COVERAGEELIGIBILITYRESPONSE;
        if ("DetectedIssue".equals(codeString))
          return ResourceTypeEnum.DETECTEDISSUE;
        if ("Device".equals(codeString))
          return ResourceTypeEnum.DEVICE;
        if ("DeviceDefinition".equals(codeString))
          return ResourceTypeEnum.DEVICEDEFINITION;
        if ("DeviceMetric".equals(codeString))
          return ResourceTypeEnum.DEVICEMETRIC;
        if ("DeviceRequest".equals(codeString))
          return ResourceTypeEnum.DEVICEREQUEST;
        if ("DeviceUseStatement".equals(codeString))
          return ResourceTypeEnum.DEVICEUSESTATEMENT;
        if ("DiagnosticReport".equals(codeString))
          return ResourceTypeEnum.DIAGNOSTICREPORT;
        if ("DocumentManifest".equals(codeString))
          return ResourceTypeEnum.DOCUMENTMANIFEST;
        if ("DocumentReference".equals(codeString))
          return ResourceTypeEnum.DOCUMENTREFERENCE;
        if ("DomainResource".equals(codeString))
          return ResourceTypeEnum.DOMAINRESOURCE;
        if ("Encounter".equals(codeString))
          return ResourceTypeEnum.ENCOUNTER;
        if ("Endpoint".equals(codeString))
          return ResourceTypeEnum.ENDPOINT;
        if ("EnrollmentRequest".equals(codeString))
          return ResourceTypeEnum.ENROLLMENTREQUEST;
        if ("EnrollmentResponse".equals(codeString))
          return ResourceTypeEnum.ENROLLMENTRESPONSE;
        if ("EpisodeOfCare".equals(codeString))
          return ResourceTypeEnum.EPISODEOFCARE;
        if ("EventDefinition".equals(codeString))
          return ResourceTypeEnum.EVENTDEFINITION;
        if ("Evidence".equals(codeString))
          return ResourceTypeEnum.EVIDENCE;
        if ("EvidenceVariable".equals(codeString))
          return ResourceTypeEnum.EVIDENCEVARIABLE;
        if ("ExampleScenario".equals(codeString))
          return ResourceTypeEnum.EXAMPLESCENARIO;
        if ("ExplanationOfBenefit".equals(codeString))
          return ResourceTypeEnum.EXPLANATIONOFBENEFIT;
        if ("FamilyMemberHistory".equals(codeString))
          return ResourceTypeEnum.FAMILYMEMBERHISTORY;
        if ("Flag".equals(codeString))
          return ResourceTypeEnum.FLAG;
        if ("Goal".equals(codeString))
          return ResourceTypeEnum.GOAL;
        if ("GraphDefinition".equals(codeString))
          return ResourceTypeEnum.GRAPHDEFINITION;
        if ("Group".equals(codeString))
          return ResourceTypeEnum.GROUP;
        if ("GuidanceResponse".equals(codeString))
          return ResourceTypeEnum.GUIDANCERESPONSE;
        if ("HealthcareService".equals(codeString))
          return ResourceTypeEnum.HEALTHCARESERVICE;
        if ("ImagingStudy".equals(codeString))
          return ResourceTypeEnum.IMAGINGSTUDY;
        if ("Immunization".equals(codeString))
          return ResourceTypeEnum.IMMUNIZATION;
        if ("ImmunizationEvaluation".equals(codeString))
          return ResourceTypeEnum.IMMUNIZATIONEVALUATION;
        if ("ImmunizationRecommendation".equals(codeString))
          return ResourceTypeEnum.IMMUNIZATIONRECOMMENDATION;
        if ("ImplementationGuide".equals(codeString))
          return ResourceTypeEnum.IMPLEMENTATIONGUIDE;
        if ("Ingredient".equals(codeString))
          return ResourceTypeEnum.INGREDIENT;
        if ("InsurancePlan".equals(codeString))
          return ResourceTypeEnum.INSURANCEPLAN;
        if ("Invoice".equals(codeString))
          return ResourceTypeEnum.INVOICE;
        if ("Library".equals(codeString))
          return ResourceTypeEnum.LIBRARY;
        if ("Linkage".equals(codeString))
          return ResourceTypeEnum.LINKAGE;
        if ("List".equals(codeString))
          return ResourceTypeEnum.LIST;
        if ("Location".equals(codeString))
          return ResourceTypeEnum.LOCATION;
        if ("ManufacturedItemDefinition".equals(codeString))
          return ResourceTypeEnum.MANUFACTUREDITEMDEFINITION;
        if ("Measure".equals(codeString))
          return ResourceTypeEnum.MEASURE;
        if ("MeasureReport".equals(codeString))
          return ResourceTypeEnum.MEASUREREPORT;
        if ("Medication".equals(codeString))
          return ResourceTypeEnum.MEDICATION;
        if ("MedicationAdministration".equals(codeString))
          return ResourceTypeEnum.MEDICATIONADMINISTRATION;
        if ("MedicationDispense".equals(codeString))
          return ResourceTypeEnum.MEDICATIONDISPENSE;
        if ("MedicationKnowledge".equals(codeString))
          return ResourceTypeEnum.MEDICATIONKNOWLEDGE;
        if ("MedicationRequest".equals(codeString))
          return ResourceTypeEnum.MEDICATIONREQUEST;
        if ("MedicationUsage".equals(codeString))
          return ResourceTypeEnum.MEDICATIONUSAGE;
        if ("MedicinalProductDefinition".equals(codeString))
          return ResourceTypeEnum.MEDICINALPRODUCTDEFINITION;
        if ("MessageDefinition".equals(codeString))
          return ResourceTypeEnum.MESSAGEDEFINITION;
        if ("MessageHeader".equals(codeString))
          return ResourceTypeEnum.MESSAGEHEADER;
        if ("MolecularSequence".equals(codeString))
          return ResourceTypeEnum.MOLECULARSEQUENCE;
        if ("NamingSystem".equals(codeString))
          return ResourceTypeEnum.NAMINGSYSTEM;
        if ("NutritionIntake".equals(codeString))
          return ResourceTypeEnum.NUTRITIONINTAKE;
        if ("NutritionOrder".equals(codeString))
          return ResourceTypeEnum.NUTRITIONORDER;
        if ("Observation".equals(codeString))
          return ResourceTypeEnum.OBSERVATION;
        if ("ObservationDefinition".equals(codeString))
          return ResourceTypeEnum.OBSERVATIONDEFINITION;
        if ("OperationDefinition".equals(codeString))
          return ResourceTypeEnum.OPERATIONDEFINITION;
        if ("OperationOutcome".equals(codeString))
          return ResourceTypeEnum.OPERATIONOUTCOME;
        if ("Organization".equals(codeString))
          return ResourceTypeEnum.ORGANIZATION;
        if ("OrganizationAffiliation".equals(codeString))
          return ResourceTypeEnum.ORGANIZATIONAFFILIATION;
        if ("PackagedProductDefinition".equals(codeString))
          return ResourceTypeEnum.PACKAGEDPRODUCTDEFINITION;
        if ("Parameters".equals(codeString))
          return ResourceTypeEnum.PARAMETERS;
        if ("Patient".equals(codeString))
          return ResourceTypeEnum.PATIENT;
        if ("PaymentNotice".equals(codeString))
          return ResourceTypeEnum.PAYMENTNOTICE;
        if ("PaymentReconciliation".equals(codeString))
          return ResourceTypeEnum.PAYMENTRECONCILIATION;
        if ("Person".equals(codeString))
          return ResourceTypeEnum.PERSON;
        if ("PlanDefinition".equals(codeString))
          return ResourceTypeEnum.PLANDEFINITION;
        if ("Practitioner".equals(codeString))
          return ResourceTypeEnum.PRACTITIONER;
        if ("PractitionerRole".equals(codeString))
          return ResourceTypeEnum.PRACTITIONERROLE;
        if ("Procedure".equals(codeString))
          return ResourceTypeEnum.PROCEDURE;
        if ("Provenance".equals(codeString))
          return ResourceTypeEnum.PROVENANCE;
        if ("Questionnaire".equals(codeString))
          return ResourceTypeEnum.QUESTIONNAIRE;
        if ("QuestionnaireResponse".equals(codeString))
          return ResourceTypeEnum.QUESTIONNAIRERESPONSE;
        if ("RegulatedAuthorization".equals(codeString))
          return ResourceTypeEnum.REGULATEDAUTHORIZATION;
        if ("RelatedPerson".equals(codeString))
          return ResourceTypeEnum.RELATEDPERSON;
        if ("RequestGroup".equals(codeString))
          return ResourceTypeEnum.REQUESTGROUP;
        if ("ResearchStudy".equals(codeString))
          return ResourceTypeEnum.RESEARCHSTUDY;
        if ("ResearchSubject".equals(codeString))
          return ResourceTypeEnum.RESEARCHSUBJECT;
        if ("Resource".equals(codeString))
          return ResourceTypeEnum.RESOURCE;
        if ("RiskAssessment".equals(codeString))
          return ResourceTypeEnum.RISKASSESSMENT;
        if ("Schedule".equals(codeString))
          return ResourceTypeEnum.SCHEDULE;
        if ("SearchParameter".equals(codeString))
          return ResourceTypeEnum.SEARCHPARAMETER;
        if ("ServiceRequest".equals(codeString))
          return ResourceTypeEnum.SERVICEREQUEST;
        if ("Slot".equals(codeString))
          return ResourceTypeEnum.SLOT;
        if ("Specimen".equals(codeString))
          return ResourceTypeEnum.SPECIMEN;
        if ("SpecimenDefinition".equals(codeString))
          return ResourceTypeEnum.SPECIMENDEFINITION;
        if ("StructureDefinition".equals(codeString))
          return ResourceTypeEnum.STRUCTUREDEFINITION;
        if ("StructureMap".equals(codeString))
          return ResourceTypeEnum.STRUCTUREMAP;
        if ("Subscription".equals(codeString))
          return ResourceTypeEnum.SUBSCRIPTION;
        if ("Substance".equals(codeString))
          return ResourceTypeEnum.SUBSTANCE;
        if ("SubstanceDefinition".equals(codeString))
          return ResourceTypeEnum.SUBSTANCEDEFINITION;
        if ("SubstanceNucleicAcid".equals(codeString))
          return ResourceTypeEnum.SUBSTANCENUCLEICACID;
        if ("SubstancePolymer".equals(codeString))
          return ResourceTypeEnum.SUBSTANCEPOLYMER;
        if ("SubstanceProtein".equals(codeString))
          return ResourceTypeEnum.SUBSTANCEPROTEIN;
        if ("SubstanceReferenceInformation".equals(codeString))
          return ResourceTypeEnum.SUBSTANCEREFERENCEINFORMATION;
        if ("SubstanceSourceMaterial".equals(codeString))
          return ResourceTypeEnum.SUBSTANCESOURCEMATERIAL;
        if ("SupplyDelivery".equals(codeString))
          return ResourceTypeEnum.SUPPLYDELIVERY;
        if ("SupplyRequest".equals(codeString))
          return ResourceTypeEnum.SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return ResourceTypeEnum.TASK;
        if ("TerminologyCapabilities".equals(codeString))
          return ResourceTypeEnum.TERMINOLOGYCAPABILITIES;
        if ("TestReport".equals(codeString))
          return ResourceTypeEnum.TESTREPORT;
        if ("TestScript".equals(codeString))
          return ResourceTypeEnum.TESTSCRIPT;
        if ("Topic".equals(codeString))
          return ResourceTypeEnum.TOPIC;
        if ("ValueSet".equals(codeString))
          return ResourceTypeEnum.VALUESET;
        if ("VerificationResult".equals(codeString))
          return ResourceTypeEnum.VERIFICATIONRESULT;
        if ("VisionPrescription".equals(codeString))
          return ResourceTypeEnum.VISIONPRESCRIPTION;
        throw new IllegalArgumentException("Unknown ResourceTypeEnum code '"+codeString+"'");
        }
        public Enumeration<ResourceTypeEnum> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ResourceTypeEnum>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("Account".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.ACCOUNT);
        if ("ActivityDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.ACTIVITYDEFINITION);
        if ("AdministrableProductDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.ADMINISTRABLEPRODUCTDEFINITION);
        if ("AdverseEvent".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.ADVERSEEVENT);
        if ("AllergyIntolerance".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.ALLERGYINTOLERANCE);
        if ("Appointment".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.APPOINTMENT);
        if ("AppointmentResponse".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.APPOINTMENTRESPONSE);
        if ("AuditEvent".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.AUDITEVENT);
        if ("Basic".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.BASIC);
        if ("Binary".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.BINARY);
        if ("BiologicallyDerivedProduct".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.BIOLOGICALLYDERIVEDPRODUCT);
        if ("BodyStructure".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.BODYSTRUCTURE);
        if ("Bundle".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.BUNDLE);
        if ("CapabilityStatement".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CAPABILITYSTATEMENT);
        if ("CapabilityStatement2".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CAPABILITYSTATEMENT2);
        if ("CarePlan".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CAREPLAN);
        if ("CareTeam".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CARETEAM);
        if ("CatalogEntry".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CATALOGENTRY);
        if ("ChargeItem".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CHARGEITEM);
        if ("ChargeItemDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CHARGEITEMDEFINITION);
        if ("Claim".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CLAIM);
        if ("ClaimResponse".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CLAIMRESPONSE);
        if ("ClinicalImpression".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CLINICALIMPRESSION);
        if ("ClinicalUseIssue".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CLINICALUSEISSUE);
        if ("CodeSystem".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CODESYSTEM);
        if ("Communication".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.COMMUNICATION);
        if ("CommunicationRequest".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.COMMUNICATIONREQUEST);
        if ("CompartmentDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.COMPARTMENTDEFINITION);
        if ("Composition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.COMPOSITION);
        if ("ConceptMap".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CONCEPTMAP);
        if ("Condition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CONDITION);
        if ("ConditionDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CONDITIONDEFINITION);
        if ("Consent".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CONSENT);
        if ("Contract".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.CONTRACT);
        if ("Coverage".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.COVERAGE);
        if ("CoverageEligibilityRequest".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.COVERAGEELIGIBILITYREQUEST);
        if ("CoverageEligibilityResponse".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.COVERAGEELIGIBILITYRESPONSE);
        if ("DetectedIssue".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.DETECTEDISSUE);
        if ("Device".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.DEVICE);
        if ("DeviceDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.DEVICEDEFINITION);
        if ("DeviceMetric".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.DEVICEMETRIC);
        if ("DeviceRequest".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.DEVICEREQUEST);
        if ("DeviceUseStatement".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.DEVICEUSESTATEMENT);
        if ("DiagnosticReport".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.DIAGNOSTICREPORT);
        if ("DocumentManifest".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.DOCUMENTMANIFEST);
        if ("DocumentReference".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.DOCUMENTREFERENCE);
        if ("DomainResource".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.DOMAINRESOURCE);
        if ("Encounter".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.ENCOUNTER);
        if ("Endpoint".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.ENDPOINT);
        if ("EnrollmentRequest".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.ENROLLMENTREQUEST);
        if ("EnrollmentResponse".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.ENROLLMENTRESPONSE);
        if ("EpisodeOfCare".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.EPISODEOFCARE);
        if ("EventDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.EVENTDEFINITION);
        if ("Evidence".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.EVIDENCE);
        if ("EvidenceVariable".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.EVIDENCEVARIABLE);
        if ("ExampleScenario".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.EXAMPLESCENARIO);
        if ("ExplanationOfBenefit".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.EXPLANATIONOFBENEFIT);
        if ("FamilyMemberHistory".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.FAMILYMEMBERHISTORY);
        if ("Flag".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.FLAG);
        if ("Goal".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.GOAL);
        if ("GraphDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.GRAPHDEFINITION);
        if ("Group".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.GROUP);
        if ("GuidanceResponse".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.GUIDANCERESPONSE);
        if ("HealthcareService".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.HEALTHCARESERVICE);
        if ("ImagingStudy".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.IMAGINGSTUDY);
        if ("Immunization".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.IMMUNIZATION);
        if ("ImmunizationEvaluation".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.IMMUNIZATIONEVALUATION);
        if ("ImmunizationRecommendation".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.IMMUNIZATIONRECOMMENDATION);
        if ("ImplementationGuide".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.IMPLEMENTATIONGUIDE);
        if ("Ingredient".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.INGREDIENT);
        if ("InsurancePlan".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.INSURANCEPLAN);
        if ("Invoice".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.INVOICE);
        if ("Library".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.LIBRARY);
        if ("Linkage".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.LINKAGE);
        if ("List".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.LIST);
        if ("Location".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.LOCATION);
        if ("ManufacturedItemDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MANUFACTUREDITEMDEFINITION);
        if ("Measure".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MEASURE);
        if ("MeasureReport".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MEASUREREPORT);
        if ("Medication".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MEDICATION);
        if ("MedicationAdministration".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MEDICATIONADMINISTRATION);
        if ("MedicationDispense".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MEDICATIONDISPENSE);
        if ("MedicationKnowledge".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MEDICATIONKNOWLEDGE);
        if ("MedicationRequest".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MEDICATIONREQUEST);
        if ("MedicationUsage".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MEDICATIONUSAGE);
        if ("MedicinalProductDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MEDICINALPRODUCTDEFINITION);
        if ("MessageDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MESSAGEDEFINITION);
        if ("MessageHeader".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MESSAGEHEADER);
        if ("MolecularSequence".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.MOLECULARSEQUENCE);
        if ("NamingSystem".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.NAMINGSYSTEM);
        if ("NutritionIntake".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.NUTRITIONINTAKE);
        if ("NutritionOrder".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.NUTRITIONORDER);
        if ("Observation".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.OBSERVATION);
        if ("ObservationDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.OBSERVATIONDEFINITION);
        if ("OperationDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.OPERATIONDEFINITION);
        if ("OperationOutcome".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.OPERATIONOUTCOME);
        if ("Organization".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.ORGANIZATION);
        if ("OrganizationAffiliation".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.ORGANIZATIONAFFILIATION);
        if ("PackagedProductDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.PACKAGEDPRODUCTDEFINITION);
        if ("Parameters".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.PARAMETERS);
        if ("Patient".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.PATIENT);
        if ("PaymentNotice".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.PAYMENTNOTICE);
        if ("PaymentReconciliation".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.PAYMENTRECONCILIATION);
        if ("Person".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.PERSON);
        if ("PlanDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.PLANDEFINITION);
        if ("Practitioner".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.PRACTITIONER);
        if ("PractitionerRole".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.PRACTITIONERROLE);
        if ("Procedure".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.PROCEDURE);
        if ("Provenance".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.PROVENANCE);
        if ("Questionnaire".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.QUESTIONNAIRE);
        if ("QuestionnaireResponse".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.QUESTIONNAIRERESPONSE);
        if ("RegulatedAuthorization".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.REGULATEDAUTHORIZATION);
        if ("RelatedPerson".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.RELATEDPERSON);
        if ("RequestGroup".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.REQUESTGROUP);
        if ("ResearchStudy".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.RESEARCHSTUDY);
        if ("ResearchSubject".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.RESEARCHSUBJECT);
        if ("Resource".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.RESOURCE);
        if ("RiskAssessment".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.RISKASSESSMENT);
        if ("Schedule".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SCHEDULE);
        if ("SearchParameter".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SEARCHPARAMETER);
        if ("ServiceRequest".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SERVICEREQUEST);
        if ("Slot".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SLOT);
        if ("Specimen".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SPECIMEN);
        if ("SpecimenDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SPECIMENDEFINITION);
        if ("StructureDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.STRUCTUREDEFINITION);
        if ("StructureMap".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.STRUCTUREMAP);
        if ("Subscription".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SUBSCRIPTION);
        if ("Substance".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SUBSTANCE);
        if ("SubstanceDefinition".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SUBSTANCEDEFINITION);
        if ("SubstanceNucleicAcid".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SUBSTANCENUCLEICACID);
        if ("SubstancePolymer".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SUBSTANCEPOLYMER);
        if ("SubstanceProtein".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SUBSTANCEPROTEIN);
        if ("SubstanceReferenceInformation".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SUBSTANCEREFERENCEINFORMATION);
        if ("SubstanceSourceMaterial".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SUBSTANCESOURCEMATERIAL);
        if ("SupplyDelivery".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SUPPLYDELIVERY);
        if ("SupplyRequest".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.SUPPLYREQUEST);
        if ("Task".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.TASK);
        if ("TerminologyCapabilities".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.TERMINOLOGYCAPABILITIES);
        if ("TestReport".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.TESTREPORT);
        if ("TestScript".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.TESTSCRIPT);
        if ("Topic".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.TOPIC);
        if ("ValueSet".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.VALUESET);
        if ("VerificationResult".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.VERIFICATIONRESULT);
        if ("VisionPrescription".equals(codeString))
          return new Enumeration<ResourceTypeEnum>(this, ResourceTypeEnum.VISIONPRESCRIPTION);
        throw new FHIRException("Unknown ResourceTypeEnum code '"+codeString+"'");
        }
    public String toCode(ResourceTypeEnum code) {
      if (code == ResourceTypeEnum.ACCOUNT)
        return "Account";
      if (code == ResourceTypeEnum.ACTIVITYDEFINITION)
        return "ActivityDefinition";
      if (code == ResourceTypeEnum.ADMINISTRABLEPRODUCTDEFINITION)
        return "AdministrableProductDefinition";
      if (code == ResourceTypeEnum.ADVERSEEVENT)
        return "AdverseEvent";
      if (code == ResourceTypeEnum.ALLERGYINTOLERANCE)
        return "AllergyIntolerance";
      if (code == ResourceTypeEnum.APPOINTMENT)
        return "Appointment";
      if (code == ResourceTypeEnum.APPOINTMENTRESPONSE)
        return "AppointmentResponse";
      if (code == ResourceTypeEnum.AUDITEVENT)
        return "AuditEvent";
      if (code == ResourceTypeEnum.BASIC)
        return "Basic";
      if (code == ResourceTypeEnum.BINARY)
        return "Binary";
      if (code == ResourceTypeEnum.BIOLOGICALLYDERIVEDPRODUCT)
        return "BiologicallyDerivedProduct";
      if (code == ResourceTypeEnum.BODYSTRUCTURE)
        return "BodyStructure";
      if (code == ResourceTypeEnum.BUNDLE)
        return "Bundle";
      if (code == ResourceTypeEnum.CAPABILITYSTATEMENT)
        return "CapabilityStatement";
      if (code == ResourceTypeEnum.CAPABILITYSTATEMENT2)
        return "CapabilityStatement2";
      if (code == ResourceTypeEnum.CAREPLAN)
        return "CarePlan";
      if (code == ResourceTypeEnum.CARETEAM)
        return "CareTeam";
      if (code == ResourceTypeEnum.CATALOGENTRY)
        return "CatalogEntry";
      if (code == ResourceTypeEnum.CHARGEITEM)
        return "ChargeItem";
      if (code == ResourceTypeEnum.CHARGEITEMDEFINITION)
        return "ChargeItemDefinition";
      if (code == ResourceTypeEnum.CLAIM)
        return "Claim";
      if (code == ResourceTypeEnum.CLAIMRESPONSE)
        return "ClaimResponse";
      if (code == ResourceTypeEnum.CLINICALIMPRESSION)
        return "ClinicalImpression";
      if (code == ResourceTypeEnum.CLINICALUSEISSUE)
        return "ClinicalUseIssue";
      if (code == ResourceTypeEnum.CODESYSTEM)
        return "CodeSystem";
      if (code == ResourceTypeEnum.COMMUNICATION)
        return "Communication";
      if (code == ResourceTypeEnum.COMMUNICATIONREQUEST)
        return "CommunicationRequest";
      if (code == ResourceTypeEnum.COMPARTMENTDEFINITION)
        return "CompartmentDefinition";
      if (code == ResourceTypeEnum.COMPOSITION)
        return "Composition";
      if (code == ResourceTypeEnum.CONCEPTMAP)
        return "ConceptMap";
      if (code == ResourceTypeEnum.CONDITION)
        return "Condition";
      if (code == ResourceTypeEnum.CONDITIONDEFINITION)
        return "ConditionDefinition";
      if (code == ResourceTypeEnum.CONSENT)
        return "Consent";
      if (code == ResourceTypeEnum.CONTRACT)
        return "Contract";
      if (code == ResourceTypeEnum.COVERAGE)
        return "Coverage";
      if (code == ResourceTypeEnum.COVERAGEELIGIBILITYREQUEST)
        return "CoverageEligibilityRequest";
      if (code == ResourceTypeEnum.COVERAGEELIGIBILITYRESPONSE)
        return "CoverageEligibilityResponse";
      if (code == ResourceTypeEnum.DETECTEDISSUE)
        return "DetectedIssue";
      if (code == ResourceTypeEnum.DEVICE)
        return "Device";
      if (code == ResourceTypeEnum.DEVICEDEFINITION)
        return "DeviceDefinition";
      if (code == ResourceTypeEnum.DEVICEMETRIC)
        return "DeviceMetric";
      if (code == ResourceTypeEnum.DEVICEREQUEST)
        return "DeviceRequest";
      if (code == ResourceTypeEnum.DEVICEUSESTATEMENT)
        return "DeviceUseStatement";
      if (code == ResourceTypeEnum.DIAGNOSTICREPORT)
        return "DiagnosticReport";
      if (code == ResourceTypeEnum.DOCUMENTMANIFEST)
        return "DocumentManifest";
      if (code == ResourceTypeEnum.DOCUMENTREFERENCE)
        return "DocumentReference";
      if (code == ResourceTypeEnum.DOMAINRESOURCE)
        return "DomainResource";
      if (code == ResourceTypeEnum.ENCOUNTER)
        return "Encounter";
      if (code == ResourceTypeEnum.ENDPOINT)
        return "Endpoint";
      if (code == ResourceTypeEnum.ENROLLMENTREQUEST)
        return "EnrollmentRequest";
      if (code == ResourceTypeEnum.ENROLLMENTRESPONSE)
        return "EnrollmentResponse";
      if (code == ResourceTypeEnum.EPISODEOFCARE)
        return "EpisodeOfCare";
      if (code == ResourceTypeEnum.EVENTDEFINITION)
        return "EventDefinition";
      if (code == ResourceTypeEnum.EVIDENCE)
        return "Evidence";
      if (code == ResourceTypeEnum.EVIDENCEVARIABLE)
        return "EvidenceVariable";
      if (code == ResourceTypeEnum.EXAMPLESCENARIO)
        return "ExampleScenario";
      if (code == ResourceTypeEnum.EXPLANATIONOFBENEFIT)
        return "ExplanationOfBenefit";
      if (code == ResourceTypeEnum.FAMILYMEMBERHISTORY)
        return "FamilyMemberHistory";
      if (code == ResourceTypeEnum.FLAG)
        return "Flag";
      if (code == ResourceTypeEnum.GOAL)
        return "Goal";
      if (code == ResourceTypeEnum.GRAPHDEFINITION)
        return "GraphDefinition";
      if (code == ResourceTypeEnum.GROUP)
        return "Group";
      if (code == ResourceTypeEnum.GUIDANCERESPONSE)
        return "GuidanceResponse";
      if (code == ResourceTypeEnum.HEALTHCARESERVICE)
        return "HealthcareService";
      if (code == ResourceTypeEnum.IMAGINGSTUDY)
        return "ImagingStudy";
      if (code == ResourceTypeEnum.IMMUNIZATION)
        return "Immunization";
      if (code == ResourceTypeEnum.IMMUNIZATIONEVALUATION)
        return "ImmunizationEvaluation";
      if (code == ResourceTypeEnum.IMMUNIZATIONRECOMMENDATION)
        return "ImmunizationRecommendation";
      if (code == ResourceTypeEnum.IMPLEMENTATIONGUIDE)
        return "ImplementationGuide";
      if (code == ResourceTypeEnum.INGREDIENT)
        return "Ingredient";
      if (code == ResourceTypeEnum.INSURANCEPLAN)
        return "InsurancePlan";
      if (code == ResourceTypeEnum.INVOICE)
        return "Invoice";
      if (code == ResourceTypeEnum.LIBRARY)
        return "Library";
      if (code == ResourceTypeEnum.LINKAGE)
        return "Linkage";
      if (code == ResourceTypeEnum.LIST)
        return "List";
      if (code == ResourceTypeEnum.LOCATION)
        return "Location";
      if (code == ResourceTypeEnum.MANUFACTUREDITEMDEFINITION)
        return "ManufacturedItemDefinition";
      if (code == ResourceTypeEnum.MEASURE)
        return "Measure";
      if (code == ResourceTypeEnum.MEASUREREPORT)
        return "MeasureReport";
      if (code == ResourceTypeEnum.MEDICATION)
        return "Medication";
      if (code == ResourceTypeEnum.MEDICATIONADMINISTRATION)
        return "MedicationAdministration";
      if (code == ResourceTypeEnum.MEDICATIONDISPENSE)
        return "MedicationDispense";
      if (code == ResourceTypeEnum.MEDICATIONKNOWLEDGE)
        return "MedicationKnowledge";
      if (code == ResourceTypeEnum.MEDICATIONREQUEST)
        return "MedicationRequest";
      if (code == ResourceTypeEnum.MEDICATIONUSAGE)
        return "MedicationUsage";
      if (code == ResourceTypeEnum.MEDICINALPRODUCTDEFINITION)
        return "MedicinalProductDefinition";
      if (code == ResourceTypeEnum.MESSAGEDEFINITION)
        return "MessageDefinition";
      if (code == ResourceTypeEnum.MESSAGEHEADER)
        return "MessageHeader";
      if (code == ResourceTypeEnum.MOLECULARSEQUENCE)
        return "MolecularSequence";
      if (code == ResourceTypeEnum.NAMINGSYSTEM)
        return "NamingSystem";
      if (code == ResourceTypeEnum.NUTRITIONINTAKE)
        return "NutritionIntake";
      if (code == ResourceTypeEnum.NUTRITIONORDER)
        return "NutritionOrder";
      if (code == ResourceTypeEnum.OBSERVATION)
        return "Observation";
      if (code == ResourceTypeEnum.OBSERVATIONDEFINITION)
        return "ObservationDefinition";
      if (code == ResourceTypeEnum.OPERATIONDEFINITION)
        return "OperationDefinition";
      if (code == ResourceTypeEnum.OPERATIONOUTCOME)
        return "OperationOutcome";
      if (code == ResourceTypeEnum.ORGANIZATION)
        return "Organization";
      if (code == ResourceTypeEnum.ORGANIZATIONAFFILIATION)
        return "OrganizationAffiliation";
      if (code == ResourceTypeEnum.PACKAGEDPRODUCTDEFINITION)
        return "PackagedProductDefinition";
      if (code == ResourceTypeEnum.PARAMETERS)
        return "Parameters";
      if (code == ResourceTypeEnum.PATIENT)
        return "Patient";
      if (code == ResourceTypeEnum.PAYMENTNOTICE)
        return "PaymentNotice";
      if (code == ResourceTypeEnum.PAYMENTRECONCILIATION)
        return "PaymentReconciliation";
      if (code == ResourceTypeEnum.PERSON)
        return "Person";
      if (code == ResourceTypeEnum.PLANDEFINITION)
        return "PlanDefinition";
      if (code == ResourceTypeEnum.PRACTITIONER)
        return "Practitioner";
      if (code == ResourceTypeEnum.PRACTITIONERROLE)
        return "PractitionerRole";
      if (code == ResourceTypeEnum.PROCEDURE)
        return "Procedure";
      if (code == ResourceTypeEnum.PROVENANCE)
        return "Provenance";
      if (code == ResourceTypeEnum.QUESTIONNAIRE)
        return "Questionnaire";
      if (code == ResourceTypeEnum.QUESTIONNAIRERESPONSE)
        return "QuestionnaireResponse";
      if (code == ResourceTypeEnum.REGULATEDAUTHORIZATION)
        return "RegulatedAuthorization";
      if (code == ResourceTypeEnum.RELATEDPERSON)
        return "RelatedPerson";
      if (code == ResourceTypeEnum.REQUESTGROUP)
        return "RequestGroup";
      if (code == ResourceTypeEnum.RESEARCHSTUDY)
        return "ResearchStudy";
      if (code == ResourceTypeEnum.RESEARCHSUBJECT)
        return "ResearchSubject";
      if (code == ResourceTypeEnum.RESOURCE)
        return "Resource";
      if (code == ResourceTypeEnum.RISKASSESSMENT)
        return "RiskAssessment";
      if (code == ResourceTypeEnum.SCHEDULE)
        return "Schedule";
      if (code == ResourceTypeEnum.SEARCHPARAMETER)
        return "SearchParameter";
      if (code == ResourceTypeEnum.SERVICEREQUEST)
        return "ServiceRequest";
      if (code == ResourceTypeEnum.SLOT)
        return "Slot";
      if (code == ResourceTypeEnum.SPECIMEN)
        return "Specimen";
      if (code == ResourceTypeEnum.SPECIMENDEFINITION)
        return "SpecimenDefinition";
      if (code == ResourceTypeEnum.STRUCTUREDEFINITION)
        return "StructureDefinition";
      if (code == ResourceTypeEnum.STRUCTUREMAP)
        return "StructureMap";
      if (code == ResourceTypeEnum.SUBSCRIPTION)
        return "Subscription";
      if (code == ResourceTypeEnum.SUBSTANCE)
        return "Substance";
      if (code == ResourceTypeEnum.SUBSTANCEDEFINITION)
        return "SubstanceDefinition";
      if (code == ResourceTypeEnum.SUBSTANCENUCLEICACID)
        return "SubstanceNucleicAcid";
      if (code == ResourceTypeEnum.SUBSTANCEPOLYMER)
        return "SubstancePolymer";
      if (code == ResourceTypeEnum.SUBSTANCEPROTEIN)
        return "SubstanceProtein";
      if (code == ResourceTypeEnum.SUBSTANCEREFERENCEINFORMATION)
        return "SubstanceReferenceInformation";
      if (code == ResourceTypeEnum.SUBSTANCESOURCEMATERIAL)
        return "SubstanceSourceMaterial";
      if (code == ResourceTypeEnum.SUPPLYDELIVERY)
        return "SupplyDelivery";
      if (code == ResourceTypeEnum.SUPPLYREQUEST)
        return "SupplyRequest";
      if (code == ResourceTypeEnum.TASK)
        return "Task";
      if (code == ResourceTypeEnum.TERMINOLOGYCAPABILITIES)
        return "TerminologyCapabilities";
      if (code == ResourceTypeEnum.TESTREPORT)
        return "TestReport";
      if (code == ResourceTypeEnum.TESTSCRIPT)
        return "TestScript";
      if (code == ResourceTypeEnum.TOPIC)
        return "Topic";
      if (code == ResourceTypeEnum.VALUESET)
        return "ValueSet";
      if (code == ResourceTypeEnum.VERIFICATIONRESULT)
        return "VerificationResult";
      if (code == ResourceTypeEnum.VISIONPRESCRIPTION)
        return "VisionPrescription";
      return "?";
      }
    public String toSystem(ResourceTypeEnum code) {
      return code.getSystem();
      }
    }

    public enum RestfulCapabilityMode {
        /**
         * The application acts as a client for this resource.
         */
        CLIENT, 
        /**
         * The application acts as a server for this resource.
         */
        SERVER, 
        /**
         * added to help the parsers
         */
        NULL;
        public static RestfulCapabilityMode fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("client".equals(codeString))
          return CLIENT;
        if ("server".equals(codeString))
          return SERVER;
        throw new FHIRException("Unknown RestfulCapabilityMode code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CLIENT: return "client";
            case SERVER: return "server";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CLIENT: return "http://hl7.org/fhir/restful-capability-mode";
            case SERVER: return "http://hl7.org/fhir/restful-capability-mode";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CLIENT: return "The application acts as a client for this resource.";
            case SERVER: return "The application acts as a server for this resource.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CLIENT: return "Client";
            case SERVER: return "Server";
            default: return "?";
          }
        }
    }

  public static class RestfulCapabilityModeEnumFactory implements EnumFactory<RestfulCapabilityMode> {
    public RestfulCapabilityMode fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("client".equals(codeString))
          return RestfulCapabilityMode.CLIENT;
        if ("server".equals(codeString))
          return RestfulCapabilityMode.SERVER;
        throw new IllegalArgumentException("Unknown RestfulCapabilityMode code '"+codeString+"'");
        }
        public Enumeration<RestfulCapabilityMode> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RestfulCapabilityMode>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("client".equals(codeString))
          return new Enumeration<RestfulCapabilityMode>(this, RestfulCapabilityMode.CLIENT);
        if ("server".equals(codeString))
          return new Enumeration<RestfulCapabilityMode>(this, RestfulCapabilityMode.SERVER);
        throw new FHIRException("Unknown RestfulCapabilityMode code '"+codeString+"'");
        }
    public String toCode(RestfulCapabilityMode code) {
      if (code == RestfulCapabilityMode.CLIENT)
        return "client";
      if (code == RestfulCapabilityMode.SERVER)
        return "server";
      return "?";
      }
    public String toSystem(RestfulCapabilityMode code) {
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
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CLAIM: return "http://hl7.org/fhir/claim-use";
            case PREAUTHORIZATION: return "http://hl7.org/fhir/claim-use";
            case PREDETERMINATION: return "http://hl7.org/fhir/claim-use";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CLAIM: return "The treatment is complete and this represents a Claim for the services.";
            case PREAUTHORIZATION: return "The treatment is proposed and this represents a Pre-authorization for the services.";
            case PREDETERMINATION: return "The treatment is proposed and this represents a Pre-determination for the services.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CLAIM: return "Claim";
            case PREAUTHORIZATION: return "Preauthorization";
            case PREDETERMINATION: return "Predetermination";
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

