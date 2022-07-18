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

// Generated on Fri, Jul 15, 2022 11:20+1000 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Describes the intention of how one or more practitioners intend to deliver care for a particular patient, group or community for a period of time, possibly limited to care for a specific condition or set of conditions.
 */
@ResourceDef(name="CarePlan", profile="http://hl7.org/fhir/StructureDefinition/CarePlan")
public class CarePlan extends DomainResource {

    public enum CarePlanActivityKind {
        /**
         * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).
         */
        APPOINTMENT, 
        /**
         * A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.
         */
        COMMUNICATIONREQUEST, 
        /**
         * Represents a request a device to be provided to a specific patient. The device may be an implantable device to be subsequently implanted, or an external assistive device, such as a walker, to be delivered and subsequently be used.
         */
        DEVICEREQUEST, 
        /**
         * An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called \"MedicationRequest\" rather than \"MedicationPrescription\" or \"MedicationOrder\" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.
         */
        MEDICATIONREQUEST, 
        /**
         * A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.
         */
        NUTRITIONORDER, 
        /**
         * A task to be performed.
         */
        TASK, 
        /**
         * A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.
         */
        SERVICEREQUEST, 
        /**
         * An authorization for the provision of glasses and/or contact lenses to a patient.
         */
        VISIONPRESCRIPTION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CarePlanActivityKind fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Appointment".equals(codeString))
          return APPOINTMENT;
        if ("CommunicationRequest".equals(codeString))
          return COMMUNICATIONREQUEST;
        if ("DeviceRequest".equals(codeString))
          return DEVICEREQUEST;
        if ("MedicationRequest".equals(codeString))
          return MEDICATIONREQUEST;
        if ("NutritionOrder".equals(codeString))
          return NUTRITIONORDER;
        if ("Task".equals(codeString))
          return TASK;
        if ("ServiceRequest".equals(codeString))
          return SERVICEREQUEST;
        if ("VisionPrescription".equals(codeString))
          return VISIONPRESCRIPTION;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CarePlanActivityKind code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case APPOINTMENT: return "Appointment";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case DEVICEREQUEST: return "DeviceRequest";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case NUTRITIONORDER: return "NutritionOrder";
            case TASK: return "Task";
            case SERVICEREQUEST: return "ServiceRequest";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case APPOINTMENT: return "http://hl7.org/fhir/resource-types";
            case COMMUNICATIONREQUEST: return "http://hl7.org/fhir/resource-types";
            case DEVICEREQUEST: return "http://hl7.org/fhir/resource-types";
            case MEDICATIONREQUEST: return "http://hl7.org/fhir/resource-types";
            case NUTRITIONORDER: return "http://hl7.org/fhir/resource-types";
            case TASK: return "http://hl7.org/fhir/resource-types";
            case SERVICEREQUEST: return "http://hl7.org/fhir/resource-types";
            case VISIONPRESCRIPTION: return "http://hl7.org/fhir/resource-types";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case APPOINTMENT: return "A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).";
            case COMMUNICATIONREQUEST: return "A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.";
            case DEVICEREQUEST: return "Represents a request a device to be provided to a specific patient. The device may be an implantable device to be subsequently implanted, or an external assistive device, such as a walker, to be delivered and subsequently be used.";
            case MEDICATIONREQUEST: return "An order or request for both supply of the medication and the instructions for administration of the medication to a patient. The resource is called \"MedicationRequest\" rather than \"MedicationPrescription\" or \"MedicationOrder\" to generalize the use across inpatient and outpatient settings, including care plans, etc., and to harmonize with workflow patterns.";
            case NUTRITIONORDER: return "A request to supply a diet, formula feeding (enteral) or oral nutritional supplement to a patient/resident.";
            case TASK: return "A task to be performed.";
            case SERVICEREQUEST: return "A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.";
            case VISIONPRESCRIPTION: return "An authorization for the provision of glasses and/or contact lenses to a patient.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case APPOINTMENT: return "Appointment";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case DEVICEREQUEST: return "DeviceRequest";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case NUTRITIONORDER: return "NutritionOrder";
            case TASK: return "Task";
            case SERVICEREQUEST: return "ServiceRequest";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CarePlanActivityKindEnumFactory implements EnumFactory<CarePlanActivityKind> {
    public CarePlanActivityKind fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Appointment".equals(codeString))
          return CarePlanActivityKind.APPOINTMENT;
        if ("CommunicationRequest".equals(codeString))
          return CarePlanActivityKind.COMMUNICATIONREQUEST;
        if ("DeviceRequest".equals(codeString))
          return CarePlanActivityKind.DEVICEREQUEST;
        if ("MedicationRequest".equals(codeString))
          return CarePlanActivityKind.MEDICATIONREQUEST;
        if ("NutritionOrder".equals(codeString))
          return CarePlanActivityKind.NUTRITIONORDER;
        if ("Task".equals(codeString))
          return CarePlanActivityKind.TASK;
        if ("ServiceRequest".equals(codeString))
          return CarePlanActivityKind.SERVICEREQUEST;
        if ("VisionPrescription".equals(codeString))
          return CarePlanActivityKind.VISIONPRESCRIPTION;
        throw new IllegalArgumentException("Unknown CarePlanActivityKind code '"+codeString+"'");
        }
        public Enumeration<CarePlanActivityKind> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CarePlanActivityKind>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("Appointment".equals(codeString))
          return new Enumeration<CarePlanActivityKind>(this, CarePlanActivityKind.APPOINTMENT);
        if ("CommunicationRequest".equals(codeString))
          return new Enumeration<CarePlanActivityKind>(this, CarePlanActivityKind.COMMUNICATIONREQUEST);
        if ("DeviceRequest".equals(codeString))
          return new Enumeration<CarePlanActivityKind>(this, CarePlanActivityKind.DEVICEREQUEST);
        if ("MedicationRequest".equals(codeString))
          return new Enumeration<CarePlanActivityKind>(this, CarePlanActivityKind.MEDICATIONREQUEST);
        if ("NutritionOrder".equals(codeString))
          return new Enumeration<CarePlanActivityKind>(this, CarePlanActivityKind.NUTRITIONORDER);
        if ("Task".equals(codeString))
          return new Enumeration<CarePlanActivityKind>(this, CarePlanActivityKind.TASK);
        if ("ServiceRequest".equals(codeString))
          return new Enumeration<CarePlanActivityKind>(this, CarePlanActivityKind.SERVICEREQUEST);
        if ("VisionPrescription".equals(codeString))
          return new Enumeration<CarePlanActivityKind>(this, CarePlanActivityKind.VISIONPRESCRIPTION);
        throw new FHIRException("Unknown CarePlanActivityKind code '"+codeString+"'");
        }
    public String toCode(CarePlanActivityKind code) {
      if (code == CarePlanActivityKind.APPOINTMENT)
        return "Appointment";
      if (code == CarePlanActivityKind.COMMUNICATIONREQUEST)
        return "CommunicationRequest";
      if (code == CarePlanActivityKind.DEVICEREQUEST)
        return "DeviceRequest";
      if (code == CarePlanActivityKind.MEDICATIONREQUEST)
        return "MedicationRequest";
      if (code == CarePlanActivityKind.NUTRITIONORDER)
        return "NutritionOrder";
      if (code == CarePlanActivityKind.TASK)
        return "Task";
      if (code == CarePlanActivityKind.SERVICEREQUEST)
        return "ServiceRequest";
      if (code == CarePlanActivityKind.VISIONPRESCRIPTION)
        return "VisionPrescription";
      return "?";
      }
    public String toSystem(CarePlanActivityKind code) {
      return code.getSystem();
      }
    }

    public enum CarePlanActivityStatus {
        /**
         * Care plan activity is planned but no action has yet been taken.
         */
        NOTSTARTED, 
        /**
         * Appointment or other booking has occurred but activity has not yet begun.
         */
        SCHEDULED, 
        /**
         * Care plan activity has been started but is not yet complete.
         */
        INPROGRESS, 
        /**
         * Care plan activity was started but has temporarily ceased with an expectation of resumption at a future time.
         */
        ONHOLD, 
        /**
         * Care plan activity has been completed (more or less) as planned.
         */
        COMPLETED, 
        /**
         * The planned care plan activity has been withdrawn.
         */
        CANCELLED, 
        /**
         * The planned care plan activity has been ended prior to completion after the activity was started.
         */
        STOPPED, 
        /**
         * The current state of the care plan activity is not known.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which one.
         */
        UNKNOWN, 
        /**
         * Care plan activity was entered in error and voided.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CarePlanActivityStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("not-started".equals(codeString))
          return NOTSTARTED;
        if ("scheduled".equals(codeString))
          return SCHEDULED;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("stopped".equals(codeString))
          return STOPPED;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CarePlanActivityStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case NOTSTARTED: return "not-started";
            case SCHEDULED: return "scheduled";
            case INPROGRESS: return "in-progress";
            case ONHOLD: return "on-hold";
            case COMPLETED: return "completed";
            case CANCELLED: return "cancelled";
            case STOPPED: return "stopped";
            case UNKNOWN: return "unknown";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case NOTSTARTED: return "http://hl7.org/fhir/care-plan-activity-status";
            case SCHEDULED: return "http://hl7.org/fhir/care-plan-activity-status";
            case INPROGRESS: return "http://hl7.org/fhir/care-plan-activity-status";
            case ONHOLD: return "http://hl7.org/fhir/care-plan-activity-status";
            case COMPLETED: return "http://hl7.org/fhir/care-plan-activity-status";
            case CANCELLED: return "http://hl7.org/fhir/care-plan-activity-status";
            case STOPPED: return "http://hl7.org/fhir/care-plan-activity-status";
            case UNKNOWN: return "http://hl7.org/fhir/care-plan-activity-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/care-plan-activity-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case NOTSTARTED: return "Care plan activity is planned but no action has yet been taken.";
            case SCHEDULED: return "Appointment or other booking has occurred but activity has not yet begun.";
            case INPROGRESS: return "Care plan activity has been started but is not yet complete.";
            case ONHOLD: return "Care plan activity was started but has temporarily ceased with an expectation of resumption at a future time.";
            case COMPLETED: return "Care plan activity has been completed (more or less) as planned.";
            case CANCELLED: return "The planned care plan activity has been withdrawn.";
            case STOPPED: return "The planned care plan activity has been ended prior to completion after the activity was started.";
            case UNKNOWN: return "The current state of the care plan activity is not known.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, but the authoring/source system does not know which one.";
            case ENTEREDINERROR: return "Care plan activity was entered in error and voided.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case NOTSTARTED: return "Not Started";
            case SCHEDULED: return "Scheduled";
            case INPROGRESS: return "In Progress";
            case ONHOLD: return "On Hold";
            case COMPLETED: return "Completed";
            case CANCELLED: return "Cancelled";
            case STOPPED: return "Stopped";
            case UNKNOWN: return "Unknown";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CarePlanActivityStatusEnumFactory implements EnumFactory<CarePlanActivityStatus> {
    public CarePlanActivityStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("not-started".equals(codeString))
          return CarePlanActivityStatus.NOTSTARTED;
        if ("scheduled".equals(codeString))
          return CarePlanActivityStatus.SCHEDULED;
        if ("in-progress".equals(codeString))
          return CarePlanActivityStatus.INPROGRESS;
        if ("on-hold".equals(codeString))
          return CarePlanActivityStatus.ONHOLD;
        if ("completed".equals(codeString))
          return CarePlanActivityStatus.COMPLETED;
        if ("cancelled".equals(codeString))
          return CarePlanActivityStatus.CANCELLED;
        if ("stopped".equals(codeString))
          return CarePlanActivityStatus.STOPPED;
        if ("unknown".equals(codeString))
          return CarePlanActivityStatus.UNKNOWN;
        if ("entered-in-error".equals(codeString))
          return CarePlanActivityStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown CarePlanActivityStatus code '"+codeString+"'");
        }
        public Enumeration<CarePlanActivityStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CarePlanActivityStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("not-started".equals(codeString))
          return new Enumeration<CarePlanActivityStatus>(this, CarePlanActivityStatus.NOTSTARTED);
        if ("scheduled".equals(codeString))
          return new Enumeration<CarePlanActivityStatus>(this, CarePlanActivityStatus.SCHEDULED);
        if ("in-progress".equals(codeString))
          return new Enumeration<CarePlanActivityStatus>(this, CarePlanActivityStatus.INPROGRESS);
        if ("on-hold".equals(codeString))
          return new Enumeration<CarePlanActivityStatus>(this, CarePlanActivityStatus.ONHOLD);
        if ("completed".equals(codeString))
          return new Enumeration<CarePlanActivityStatus>(this, CarePlanActivityStatus.COMPLETED);
        if ("cancelled".equals(codeString))
          return new Enumeration<CarePlanActivityStatus>(this, CarePlanActivityStatus.CANCELLED);
        if ("stopped".equals(codeString))
          return new Enumeration<CarePlanActivityStatus>(this, CarePlanActivityStatus.STOPPED);
        if ("unknown".equals(codeString))
          return new Enumeration<CarePlanActivityStatus>(this, CarePlanActivityStatus.UNKNOWN);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<CarePlanActivityStatus>(this, CarePlanActivityStatus.ENTEREDINERROR);
        throw new FHIRException("Unknown CarePlanActivityStatus code '"+codeString+"'");
        }
    public String toCode(CarePlanActivityStatus code) {
      if (code == CarePlanActivityStatus.NOTSTARTED)
        return "not-started";
      if (code == CarePlanActivityStatus.SCHEDULED)
        return "scheduled";
      if (code == CarePlanActivityStatus.INPROGRESS)
        return "in-progress";
      if (code == CarePlanActivityStatus.ONHOLD)
        return "on-hold";
      if (code == CarePlanActivityStatus.COMPLETED)
        return "completed";
      if (code == CarePlanActivityStatus.CANCELLED)
        return "cancelled";
      if (code == CarePlanActivityStatus.STOPPED)
        return "stopped";
      if (code == CarePlanActivityStatus.UNKNOWN)
        return "unknown";
      if (code == CarePlanActivityStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(CarePlanActivityStatus code) {
      return code.getSystem();
      }
    }

    public enum CarePlanIntent {
        /**
         * The request is a suggestion made by someone/something that does not have an intention to ensure it occurs and without providing an authorization to act.
         */
        PROPOSAL, 
        /**
         * The request represents an intention to ensure something occurs without providing an authorization for others to act.
         */
        PLAN, 
        /**
         * The request represents a request/demand and authorization for action by a Practitioner.
         */
        ORDER, 
        /**
         * The request represents a component or option for a RequestGroup that establishes timing, conditionality and/or other constraints among a set of requests.  Refer to [[[RequestGroup]]] for additional information on how this status is used.
         */
        OPTION, 
        /**
         * The request represents a legally binding instruction authored by a Patient or RelatedPerson.
         */
        DIRECTIVE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CarePlanIntent fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("proposal".equals(codeString))
          return PROPOSAL;
        if ("plan".equals(codeString))
          return PLAN;
        if ("order".equals(codeString))
          return ORDER;
        if ("option".equals(codeString))
          return OPTION;
        if ("directive".equals(codeString))
          return DIRECTIVE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CarePlanIntent code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PROPOSAL: return "proposal";
            case PLAN: return "plan";
            case ORDER: return "order";
            case OPTION: return "option";
            case DIRECTIVE: return "directive";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PROPOSAL: return "http://hl7.org/fhir/request-intent";
            case PLAN: return "http://hl7.org/fhir/request-intent";
            case ORDER: return "http://hl7.org/fhir/request-intent";
            case OPTION: return "http://hl7.org/fhir/request-intent";
            case DIRECTIVE: return "http://hl7.org/fhir/request-intent";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PROPOSAL: return "The request is a suggestion made by someone/something that does not have an intention to ensure it occurs and without providing an authorization to act.";
            case PLAN: return "The request represents an intention to ensure something occurs without providing an authorization for others to act.";
            case ORDER: return "The request represents a request/demand and authorization for action by a Practitioner.";
            case OPTION: return "The request represents a component or option for a RequestGroup that establishes timing, conditionality and/or other constraints among a set of requests.  Refer to [[[RequestGroup]]] for additional information on how this status is used.";
            case DIRECTIVE: return "The request represents a legally binding instruction authored by a Patient or RelatedPerson.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PROPOSAL: return "Proposal";
            case PLAN: return "Plan";
            case ORDER: return "Order";
            case OPTION: return "Option";
            case DIRECTIVE: return "Directive";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CarePlanIntentEnumFactory implements EnumFactory<CarePlanIntent> {
    public CarePlanIntent fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("proposal".equals(codeString))
          return CarePlanIntent.PROPOSAL;
        if ("plan".equals(codeString))
          return CarePlanIntent.PLAN;
        if ("order".equals(codeString))
          return CarePlanIntent.ORDER;
        if ("option".equals(codeString))
          return CarePlanIntent.OPTION;
        if ("directive".equals(codeString))
          return CarePlanIntent.DIRECTIVE;
        throw new IllegalArgumentException("Unknown CarePlanIntent code '"+codeString+"'");
        }
        public Enumeration<CarePlanIntent> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CarePlanIntent>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("proposal".equals(codeString))
          return new Enumeration<CarePlanIntent>(this, CarePlanIntent.PROPOSAL);
        if ("plan".equals(codeString))
          return new Enumeration<CarePlanIntent>(this, CarePlanIntent.PLAN);
        if ("order".equals(codeString))
          return new Enumeration<CarePlanIntent>(this, CarePlanIntent.ORDER);
        if ("option".equals(codeString))
          return new Enumeration<CarePlanIntent>(this, CarePlanIntent.OPTION);
        if ("directive".equals(codeString))
          return new Enumeration<CarePlanIntent>(this, CarePlanIntent.DIRECTIVE);
        throw new FHIRException("Unknown CarePlanIntent code '"+codeString+"'");
        }
    public String toCode(CarePlanIntent code) {
      if (code == CarePlanIntent.PROPOSAL)
        return "proposal";
      if (code == CarePlanIntent.PLAN)
        return "plan";
      if (code == CarePlanIntent.ORDER)
        return "order";
      if (code == CarePlanIntent.OPTION)
        return "option";
      if (code == CarePlanIntent.DIRECTIVE)
        return "directive";
      return "?";
      }
    public String toSystem(CarePlanIntent code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class CarePlanActivityComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifies the activity that was performed. For example, an activity could be patient education, exercise, or a medication administration. The reference to an "event" resource, such as Procedure or Encounter or Observation, represents the activity that was performed. The requested activity can be conveyed using CarePlan.activity.plannedActivityDetail OR using the CarePlan.activity.plannedActivityReference (a reference to a “request” resource).
         */
        @Child(name = "performedActivity", type = {CodeableReference.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Results of the activity (concept, or Appointment, Encounter, Procedure, etc)", formalDefinition="Identifies the activity that was performed. For example, an activity could be patient education, exercise, or a medication administration. The reference to an \"event\" resource, such as Procedure or Encounter or Observation, represents the activity that was performed. The requested activity can be conveyed using CarePlan.activity.plannedActivityDetail OR using the CarePlan.activity.plannedActivityReference (a reference to a “request” resource)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/care-plan-activity-performed")
        protected List<CodeableReference> performedActivity;

        /**
         * Notes about the adherence/status/progress of the activity.
         */
        @Child(name = "progress", type = {Annotation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Comments about the activity status/progress", formalDefinition="Notes about the adherence/status/progress of the activity." )
        protected List<Annotation> progress;

        /**
         * The details of the proposed activity represented in a specific resource.
         */
        @Child(name = "plannedActivityReference", type = {Appointment.class, CommunicationRequest.class, DeviceRequest.class, MedicationRequest.class, NutritionOrder.class, Task.class, ServiceRequest.class, VisionPrescription.class, RequestGroup.class, ImmunizationRecommendation.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Activity that is intended to be part of the care plan", formalDefinition="The details of the proposed activity represented in a specific resource." )
        protected Reference plannedActivityReference;

        /**
         * A simple summary of a planned activity suitable for a general care plan system (e.g. form driven) that doesn't know about specific resources such as procedure etc.
         */
        @Child(name = "plannedActivityDetail", type = {}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="In-line definition of activity", formalDefinition="A simple summary of a planned activity suitable for a general care plan system (e.g. form driven) that doesn't know about specific resources such as procedure etc." )
        protected CarePlanActivityPlannedActivityDetailComponent plannedActivityDetail;

        private static final long serialVersionUID = 1513409624L;

    /**
     * Constructor
     */
      public CarePlanActivityComponent() {
        super();
      }

        /**
         * @return {@link #performedActivity} (Identifies the activity that was performed. For example, an activity could be patient education, exercise, or a medication administration. The reference to an "event" resource, such as Procedure or Encounter or Observation, represents the activity that was performed. The requested activity can be conveyed using CarePlan.activity.plannedActivityDetail OR using the CarePlan.activity.plannedActivityReference (a reference to a “request” resource).)
         */
        public List<CodeableReference> getPerformedActivity() { 
          if (this.performedActivity == null)
            this.performedActivity = new ArrayList<CodeableReference>();
          return this.performedActivity;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CarePlanActivityComponent setPerformedActivity(List<CodeableReference> thePerformedActivity) { 
          this.performedActivity = thePerformedActivity;
          return this;
        }

        public boolean hasPerformedActivity() { 
          if (this.performedActivity == null)
            return false;
          for (CodeableReference item : this.performedActivity)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableReference addPerformedActivity() { //3
          CodeableReference t = new CodeableReference();
          if (this.performedActivity == null)
            this.performedActivity = new ArrayList<CodeableReference>();
          this.performedActivity.add(t);
          return t;
        }

        public CarePlanActivityComponent addPerformedActivity(CodeableReference t) { //3
          if (t == null)
            return this;
          if (this.performedActivity == null)
            this.performedActivity = new ArrayList<CodeableReference>();
          this.performedActivity.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #performedActivity}, creating it if it does not already exist {3}
         */
        public CodeableReference getPerformedActivityFirstRep() { 
          if (getPerformedActivity().isEmpty()) {
            addPerformedActivity();
          }
          return getPerformedActivity().get(0);
        }

        /**
         * @return {@link #progress} (Notes about the adherence/status/progress of the activity.)
         */
        public List<Annotation> getProgress() { 
          if (this.progress == null)
            this.progress = new ArrayList<Annotation>();
          return this.progress;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CarePlanActivityComponent setProgress(List<Annotation> theProgress) { 
          this.progress = theProgress;
          return this;
        }

        public boolean hasProgress() { 
          if (this.progress == null)
            return false;
          for (Annotation item : this.progress)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Annotation addProgress() { //3
          Annotation t = new Annotation();
          if (this.progress == null)
            this.progress = new ArrayList<Annotation>();
          this.progress.add(t);
          return t;
        }

        public CarePlanActivityComponent addProgress(Annotation t) { //3
          if (t == null)
            return this;
          if (this.progress == null)
            this.progress = new ArrayList<Annotation>();
          this.progress.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #progress}, creating it if it does not already exist {3}
         */
        public Annotation getProgressFirstRep() { 
          if (getProgress().isEmpty()) {
            addProgress();
          }
          return getProgress().get(0);
        }

        /**
         * @return {@link #plannedActivityReference} (The details of the proposed activity represented in a specific resource.)
         */
        public Reference getPlannedActivityReference() { 
          if (this.plannedActivityReference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CarePlanActivityComponent.plannedActivityReference");
            else if (Configuration.doAutoCreate())
              this.plannedActivityReference = new Reference(); // cc
          return this.plannedActivityReference;
        }

        public boolean hasPlannedActivityReference() { 
          return this.plannedActivityReference != null && !this.plannedActivityReference.isEmpty();
        }

        /**
         * @param value {@link #plannedActivityReference} (The details of the proposed activity represented in a specific resource.)
         */
        public CarePlanActivityComponent setPlannedActivityReference(Reference value) { 
          this.plannedActivityReference = value;
          return this;
        }

        /**
         * @return {@link #plannedActivityDetail} (A simple summary of a planned activity suitable for a general care plan system (e.g. form driven) that doesn't know about specific resources such as procedure etc.)
         */
        public CarePlanActivityPlannedActivityDetailComponent getPlannedActivityDetail() { 
          if (this.plannedActivityDetail == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CarePlanActivityComponent.plannedActivityDetail");
            else if (Configuration.doAutoCreate())
              this.plannedActivityDetail = new CarePlanActivityPlannedActivityDetailComponent(); // cc
          return this.plannedActivityDetail;
        }

        public boolean hasPlannedActivityDetail() { 
          return this.plannedActivityDetail != null && !this.plannedActivityDetail.isEmpty();
        }

        /**
         * @param value {@link #plannedActivityDetail} (A simple summary of a planned activity suitable for a general care plan system (e.g. form driven) that doesn't know about specific resources such as procedure etc.)
         */
        public CarePlanActivityComponent setPlannedActivityDetail(CarePlanActivityPlannedActivityDetailComponent value) { 
          this.plannedActivityDetail = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("performedActivity", "CodeableReference(Any)", "Identifies the activity that was performed. For example, an activity could be patient education, exercise, or a medication administration. The reference to an \"event\" resource, such as Procedure or Encounter or Observation, represents the activity that was performed. The requested activity can be conveyed using CarePlan.activity.plannedActivityDetail OR using the CarePlan.activity.plannedActivityReference (a reference to a “request” resource).", 0, java.lang.Integer.MAX_VALUE, performedActivity));
          children.add(new Property("progress", "Annotation", "Notes about the adherence/status/progress of the activity.", 0, java.lang.Integer.MAX_VALUE, progress));
          children.add(new Property("plannedActivityReference", "Reference(Appointment|CommunicationRequest|DeviceRequest|MedicationRequest|NutritionOrder|Task|ServiceRequest|VisionPrescription|RequestGroup|ImmunizationRecommendation)", "The details of the proposed activity represented in a specific resource.", 0, 1, plannedActivityReference));
          children.add(new Property("plannedActivityDetail", "", "A simple summary of a planned activity suitable for a general care plan system (e.g. form driven) that doesn't know about specific resources such as procedure etc.", 0, 1, plannedActivityDetail));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1964521199: /*performedActivity*/  return new Property("performedActivity", "CodeableReference(Any)", "Identifies the activity that was performed. For example, an activity could be patient education, exercise, or a medication administration. The reference to an \"event\" resource, such as Procedure or Encounter or Observation, represents the activity that was performed. The requested activity can be conveyed using CarePlan.activity.plannedActivityDetail OR using the CarePlan.activity.plannedActivityReference (a reference to a “request” resource).", 0, java.lang.Integer.MAX_VALUE, performedActivity);
          case -1001078227: /*progress*/  return new Property("progress", "Annotation", "Notes about the adherence/status/progress of the activity.", 0, java.lang.Integer.MAX_VALUE, progress);
          case -1114371176: /*plannedActivityReference*/  return new Property("plannedActivityReference", "Reference(Appointment|CommunicationRequest|DeviceRequest|MedicationRequest|NutritionOrder|Task|ServiceRequest|VisionPrescription|RequestGroup|ImmunizationRecommendation)", "The details of the proposed activity represented in a specific resource.", 0, 1, plannedActivityReference);
          case 2072803108: /*plannedActivityDetail*/  return new Property("plannedActivityDetail", "", "A simple summary of a planned activity suitable for a general care plan system (e.g. form driven) that doesn't know about specific resources such as procedure etc.", 0, 1, plannedActivityDetail);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1964521199: /*performedActivity*/ return this.performedActivity == null ? new Base[0] : this.performedActivity.toArray(new Base[this.performedActivity.size()]); // CodeableReference
        case -1001078227: /*progress*/ return this.progress == null ? new Base[0] : this.progress.toArray(new Base[this.progress.size()]); // Annotation
        case -1114371176: /*plannedActivityReference*/ return this.plannedActivityReference == null ? new Base[0] : new Base[] {this.plannedActivityReference}; // Reference
        case 2072803108: /*plannedActivityDetail*/ return this.plannedActivityDetail == null ? new Base[0] : new Base[] {this.plannedActivityDetail}; // CarePlanActivityPlannedActivityDetailComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1964521199: // performedActivity
          this.getPerformedActivity().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -1001078227: // progress
          this.getProgress().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1114371176: // plannedActivityReference
          this.plannedActivityReference = TypeConvertor.castToReference(value); // Reference
          return value;
        case 2072803108: // plannedActivityDetail
          this.plannedActivityDetail = (CarePlanActivityPlannedActivityDetailComponent) value; // CarePlanActivityPlannedActivityDetailComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("performedActivity")) {
          this.getPerformedActivity().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("progress")) {
          this.getProgress().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("plannedActivityReference")) {
          this.plannedActivityReference = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("plannedActivityDetail")) {
          this.plannedActivityDetail = (CarePlanActivityPlannedActivityDetailComponent) value; // CarePlanActivityPlannedActivityDetailComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1964521199:  return addPerformedActivity(); 
        case -1001078227:  return addProgress(); 
        case -1114371176:  return getPlannedActivityReference();
        case 2072803108:  return getPlannedActivityDetail();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1964521199: /*performedActivity*/ return new String[] {"CodeableReference"};
        case -1001078227: /*progress*/ return new String[] {"Annotation"};
        case -1114371176: /*plannedActivityReference*/ return new String[] {"Reference"};
        case 2072803108: /*plannedActivityDetail*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("performedActivity")) {
          return addPerformedActivity();
        }
        else if (name.equals("progress")) {
          return addProgress();
        }
        else if (name.equals("plannedActivityReference")) {
          this.plannedActivityReference = new Reference();
          return this.plannedActivityReference;
        }
        else if (name.equals("plannedActivityDetail")) {
          this.plannedActivityDetail = new CarePlanActivityPlannedActivityDetailComponent();
          return this.plannedActivityDetail;
        }
        else
          return super.addChild(name);
      }

      public CarePlanActivityComponent copy() {
        CarePlanActivityComponent dst = new CarePlanActivityComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CarePlanActivityComponent dst) {
        super.copyValues(dst);
        if (performedActivity != null) {
          dst.performedActivity = new ArrayList<CodeableReference>();
          for (CodeableReference i : performedActivity)
            dst.performedActivity.add(i.copy());
        };
        if (progress != null) {
          dst.progress = new ArrayList<Annotation>();
          for (Annotation i : progress)
            dst.progress.add(i.copy());
        };
        dst.plannedActivityReference = plannedActivityReference == null ? null : plannedActivityReference.copy();
        dst.plannedActivityDetail = plannedActivityDetail == null ? null : plannedActivityDetail.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CarePlanActivityComponent))
          return false;
        CarePlanActivityComponent o = (CarePlanActivityComponent) other_;
        return compareDeep(performedActivity, o.performedActivity, true) && compareDeep(progress, o.progress, true)
           && compareDeep(plannedActivityReference, o.plannedActivityReference, true) && compareDeep(plannedActivityDetail, o.plannedActivityDetail, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CarePlanActivityComponent))
          return false;
        CarePlanActivityComponent o = (CarePlanActivityComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(performedActivity, progress
          , plannedActivityReference, plannedActivityDetail);
      }

  public String fhirType() {
    return "CarePlan.activity";

  }

  }

    @Block()
    public static class CarePlanActivityPlannedActivityDetailComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A description of the kind of resource the in-line definition of a care plan activity is representing.  The CarePlan.activity.detail is an in-line definition when a resource is not referenced using CarePlan.activity.reference.  For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest.
         */
        @Child(name = "kind", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Appointment | CommunicationRequest | DeviceRequest | MedicationRequest | NutritionOrder | Task | ServiceRequest | VisionPrescription", formalDefinition="A description of the kind of resource the in-line definition of a care plan activity is representing.  The CarePlan.activity.detail is an in-line definition when a resource is not referenced using CarePlan.activity.reference.  For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/care-plan-activity-kind")
        protected Enumeration<CarePlanActivityKind> kind;

        /**
         * The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.
         */
        @Child(name = "instantiatesCanonical", type = {CanonicalType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Instantiates FHIR protocol or definition", formalDefinition="The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity." )
        protected List<CanonicalType> instantiatesCanonical;

        /**
         * The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.
         */
        @Child(name = "instantiatesUri", type = {UriType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Instantiates external protocol or definition", formalDefinition="The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity." )
        protected List<UriType> instantiatesUri;

        /**
         * Detailed description of the type of planned activity; e.g. what lab test, what procedure, what kind of encounter.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Detail type of activity", formalDefinition="Detailed description of the type of planned activity; e.g. what lab test, what procedure, what kind of encounter." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-code")
        protected CodeableConcept code;

        /**
         * Provides the rationale that drove the inclusion of this particular activity as part of the plan or the reason why the activity was prohibited - either a coded concept, or another resource, such as the health condition(s), whose existence justifies this request and drove the inclusion of this particular activity as part of the plan.
         */
        @Child(name = "reason", type = {CodeableReference.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Why activity should be done or why activity was prohibited", formalDefinition="Provides the rationale that drove the inclusion of this particular activity as part of the plan or the reason why the activity was prohibited - either a coded concept, or another resource, such as the health condition(s), whose existence justifies this request and drove the inclusion of this particular activity as part of the plan." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinical-findings")
        protected List<CodeableReference> reason;

        /**
         * Internal reference that identifies the goals that this activity is intended to contribute towards meeting.
         */
        @Child(name = "goal", type = {Goal.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Goals this activity relates to", formalDefinition="Internal reference that identifies the goals that this activity is intended to contribute towards meeting." )
        protected List<Reference> goal;

        /**
         * Identifies what progress is being made for the specific activity.
         */
        @Child(name = "status", type = {CodeType.class}, order=7, min=1, max=1, modifier=true, summary=false)
        @Description(shortDefinition="not-started | scheduled | in-progress | on-hold | completed | cancelled | stopped | unknown | entered-in-error", formalDefinition="Identifies what progress is being made for the specific activity." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/care-plan-activity-status")
        protected Enumeration<CarePlanActivityStatus> status;

        /**
         * Provides reason why the activity isn't yet started, is on hold, was cancelled, etc.
         */
        @Child(name = "statusReason", type = {CodeableConcept.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reason for current status", formalDefinition="Provides reason why the activity isn't yet started, is on hold, was cancelled, etc." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/care-plan-activity-status-reason")
        protected CodeableConcept statusReason;

        /**
         * If true, indicates that the described activity is one that must NOT be engaged in when following the plan.  If false, or missing, indicates that the described activity is one that should be engaged in when following the plan.
         */
        @Child(name = "doNotPerform", type = {BooleanType.class}, order=9, min=0, max=1, modifier=true, summary=false)
        @Description(shortDefinition="If true, activity is prohibiting action", formalDefinition="If true, indicates that the described activity is one that must NOT be engaged in when following the plan.  If false, or missing, indicates that the described activity is one that should be engaged in when following the plan." )
        protected BooleanType doNotPerform;

        /**
         * The period, timing or frequency upon which the described activity is to occur.
         */
        @Child(name = "scheduled", type = {Timing.class, Period.class, StringType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When activity is to occur", formalDefinition="The period, timing or frequency upon which the described activity is to occur." )
        protected DataType scheduled;

        /**
         * Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc.
         */
        @Child(name = "location", type = {CodeableReference.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Where it should happen", formalDefinition="Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ServiceDeliveryLocationRoleType")
        protected CodeableReference location;

        /**
         * Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.
         */
        @Child(name = "reported", type = {BooleanType.class, Patient.class, RelatedPerson.class, Practitioner.class, PractitionerRole.class, Organization.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reported rather than primary record", formalDefinition="Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report." )
        protected DataType reported;

        /**
         * Identifies who's expected to be involved in the activity.
         */
        @Child(name = "performer", type = {Practitioner.class, PractitionerRole.class, Organization.class, RelatedPerson.class, Patient.class, CareTeam.class, HealthcareService.class, Device.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Who will be responsible?", formalDefinition="Identifies who's expected to be involved in the activity." )
        protected List<Reference> performer;

        /**
         * Identifies the food, drug or other product to be consumed or supplied in the activity.
         */
        @Child(name = "product", type = {CodeableConcept.class, Medication.class, Substance.class}, order=14, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What is to be administered/supplied", formalDefinition="Identifies the food, drug or other product to be consumed or supplied in the activity." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-codes")
        protected DataType product;

        /**
         * Identifies the quantity expected to be consumed in a given day.
         */
        @Child(name = "dailyAmount", type = {Quantity.class}, order=15, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="How to consume/day?", formalDefinition="Identifies the quantity expected to be consumed in a given day." )
        protected Quantity dailyAmount;

        /**
         * Identifies the quantity expected to be supplied, administered or consumed by the subject.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=16, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="How much to administer/supply/consume", formalDefinition="Identifies the quantity expected to be supplied, administered or consumed by the subject." )
        protected Quantity quantity;

        /**
         * This provides a textual description of constraints on the intended activity occurrence, including relation to other activities.  It may also include objectives, pre-conditions and end-conditions.  Finally, it may convey specifics about the activity such as body site, method, route, etc.
         */
        @Child(name = "description", type = {StringType.class}, order=17, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Extra info describing activity to perform", formalDefinition="This provides a textual description of constraints on the intended activity occurrence, including relation to other activities.  It may also include objectives, pre-conditions and end-conditions.  Finally, it may convey specifics about the activity such as body site, method, route, etc." )
        protected StringType description;

        private static final long serialVersionUID = -1258570436L;

    /**
     * Constructor
     */
      public CarePlanActivityPlannedActivityDetailComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CarePlanActivityPlannedActivityDetailComponent(CarePlanActivityStatus status) {
        super();
        this.setStatus(status);
      }

        /**
         * @return {@link #kind} (A description of the kind of resource the in-line definition of a care plan activity is representing.  The CarePlan.activity.detail is an in-line definition when a resource is not referenced using CarePlan.activity.reference.  For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest.). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
         */
        public Enumeration<CarePlanActivityKind> getKindElement() { 
          if (this.kind == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CarePlanActivityPlannedActivityDetailComponent.kind");
            else if (Configuration.doAutoCreate())
              this.kind = new Enumeration<CarePlanActivityKind>(new CarePlanActivityKindEnumFactory()); // bb
          return this.kind;
        }

        public boolean hasKindElement() { 
          return this.kind != null && !this.kind.isEmpty();
        }

        public boolean hasKind() { 
          return this.kind != null && !this.kind.isEmpty();
        }

        /**
         * @param value {@link #kind} (A description of the kind of resource the in-line definition of a care plan activity is representing.  The CarePlan.activity.detail is an in-line definition when a resource is not referenced using CarePlan.activity.reference.  For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest.). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
         */
        public CarePlanActivityPlannedActivityDetailComponent setKindElement(Enumeration<CarePlanActivityKind> value) { 
          this.kind = value;
          return this;
        }

        /**
         * @return A description of the kind of resource the in-line definition of a care plan activity is representing.  The CarePlan.activity.detail is an in-line definition when a resource is not referenced using CarePlan.activity.reference.  For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest.
         */
        public CarePlanActivityKind getKind() { 
          return this.kind == null ? null : this.kind.getValue();
        }

        /**
         * @param value A description of the kind of resource the in-line definition of a care plan activity is representing.  The CarePlan.activity.detail is an in-line definition when a resource is not referenced using CarePlan.activity.reference.  For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest.
         */
        public CarePlanActivityPlannedActivityDetailComponent setKind(CarePlanActivityKind value) { 
          if (value == null)
            this.kind = null;
          else {
            if (this.kind == null)
              this.kind = new Enumeration<CarePlanActivityKind>(new CarePlanActivityKindEnumFactory());
            this.kind.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.)
         */
        public List<CanonicalType> getInstantiatesCanonical() { 
          if (this.instantiatesCanonical == null)
            this.instantiatesCanonical = new ArrayList<CanonicalType>();
          return this.instantiatesCanonical;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CarePlanActivityPlannedActivityDetailComponent setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical) { 
          this.instantiatesCanonical = theInstantiatesCanonical;
          return this;
        }

        public boolean hasInstantiatesCanonical() { 
          if (this.instantiatesCanonical == null)
            return false;
          for (CanonicalType item : this.instantiatesCanonical)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.)
         */
        public CanonicalType addInstantiatesCanonicalElement() {//2 
          CanonicalType t = new CanonicalType();
          if (this.instantiatesCanonical == null)
            this.instantiatesCanonical = new ArrayList<CanonicalType>();
          this.instantiatesCanonical.add(t);
          return t;
        }

        /**
         * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.)
         */
        public CarePlanActivityPlannedActivityDetailComponent addInstantiatesCanonical(String value) { //1
          CanonicalType t = new CanonicalType();
          t.setValue(value);
          if (this.instantiatesCanonical == null)
            this.instantiatesCanonical = new ArrayList<CanonicalType>();
          this.instantiatesCanonical.add(t);
          return this;
        }

        /**
         * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.)
         */
        public boolean hasInstantiatesCanonical(String value) { 
          if (this.instantiatesCanonical == null)
            return false;
          for (CanonicalType v : this.instantiatesCanonical)
            if (v.getValue().equals(value)) // canonical
              return true;
          return false;
        }

        /**
         * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.)
         */
        public List<UriType> getInstantiatesUri() { 
          if (this.instantiatesUri == null)
            this.instantiatesUri = new ArrayList<UriType>();
          return this.instantiatesUri;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CarePlanActivityPlannedActivityDetailComponent setInstantiatesUri(List<UriType> theInstantiatesUri) { 
          this.instantiatesUri = theInstantiatesUri;
          return this;
        }

        public boolean hasInstantiatesUri() { 
          if (this.instantiatesUri == null)
            return false;
          for (UriType item : this.instantiatesUri)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.)
         */
        public UriType addInstantiatesUriElement() {//2 
          UriType t = new UriType();
          if (this.instantiatesUri == null)
            this.instantiatesUri = new ArrayList<UriType>();
          this.instantiatesUri.add(t);
          return t;
        }

        /**
         * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.)
         */
        public CarePlanActivityPlannedActivityDetailComponent addInstantiatesUri(String value) { //1
          UriType t = new UriType();
          t.setValue(value);
          if (this.instantiatesUri == null)
            this.instantiatesUri = new ArrayList<UriType>();
          this.instantiatesUri.add(t);
          return this;
        }

        /**
         * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.)
         */
        public boolean hasInstantiatesUri(String value) { 
          if (this.instantiatesUri == null)
            return false;
          for (UriType v : this.instantiatesUri)
            if (v.getValue().equals(value)) // uri
              return true;
          return false;
        }

        /**
         * @return {@link #code} (Detailed description of the type of planned activity; e.g. what lab test, what procedure, what kind of encounter.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CarePlanActivityPlannedActivityDetailComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Detailed description of the type of planned activity; e.g. what lab test, what procedure, what kind of encounter.)
         */
        public CarePlanActivityPlannedActivityDetailComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #reason} (Provides the rationale that drove the inclusion of this particular activity as part of the plan or the reason why the activity was prohibited - either a coded concept, or another resource, such as the health condition(s), whose existence justifies this request and drove the inclusion of this particular activity as part of the plan.)
         */
        public List<CodeableReference> getReason() { 
          if (this.reason == null)
            this.reason = new ArrayList<CodeableReference>();
          return this.reason;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CarePlanActivityPlannedActivityDetailComponent setReason(List<CodeableReference> theReason) { 
          this.reason = theReason;
          return this;
        }

        public boolean hasReason() { 
          if (this.reason == null)
            return false;
          for (CodeableReference item : this.reason)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableReference addReason() { //3
          CodeableReference t = new CodeableReference();
          if (this.reason == null)
            this.reason = new ArrayList<CodeableReference>();
          this.reason.add(t);
          return t;
        }

        public CarePlanActivityPlannedActivityDetailComponent addReason(CodeableReference t) { //3
          if (t == null)
            return this;
          if (this.reason == null)
            this.reason = new ArrayList<CodeableReference>();
          this.reason.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
         */
        public CodeableReference getReasonFirstRep() { 
          if (getReason().isEmpty()) {
            addReason();
          }
          return getReason().get(0);
        }

        /**
         * @return {@link #goal} (Internal reference that identifies the goals that this activity is intended to contribute towards meeting.)
         */
        public List<Reference> getGoal() { 
          if (this.goal == null)
            this.goal = new ArrayList<Reference>();
          return this.goal;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CarePlanActivityPlannedActivityDetailComponent setGoal(List<Reference> theGoal) { 
          this.goal = theGoal;
          return this;
        }

        public boolean hasGoal() { 
          if (this.goal == null)
            return false;
          for (Reference item : this.goal)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addGoal() { //3
          Reference t = new Reference();
          if (this.goal == null)
            this.goal = new ArrayList<Reference>();
          this.goal.add(t);
          return t;
        }

        public CarePlanActivityPlannedActivityDetailComponent addGoal(Reference t) { //3
          if (t == null)
            return this;
          if (this.goal == null)
            this.goal = new ArrayList<Reference>();
          this.goal.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #goal}, creating it if it does not already exist {3}
         */
        public Reference getGoalFirstRep() { 
          if (getGoal().isEmpty()) {
            addGoal();
          }
          return getGoal().get(0);
        }

        /**
         * @return {@link #status} (Identifies what progress is being made for the specific activity.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
         */
        public Enumeration<CarePlanActivityStatus> getStatusElement() { 
          if (this.status == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CarePlanActivityPlannedActivityDetailComponent.status");
            else if (Configuration.doAutoCreate())
              this.status = new Enumeration<CarePlanActivityStatus>(new CarePlanActivityStatusEnumFactory()); // bb
          return this.status;
        }

        public boolean hasStatusElement() { 
          return this.status != null && !this.status.isEmpty();
        }

        public boolean hasStatus() { 
          return this.status != null && !this.status.isEmpty();
        }

        /**
         * @param value {@link #status} (Identifies what progress is being made for the specific activity.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
         */
        public CarePlanActivityPlannedActivityDetailComponent setStatusElement(Enumeration<CarePlanActivityStatus> value) { 
          this.status = value;
          return this;
        }

        /**
         * @return Identifies what progress is being made for the specific activity.
         */
        public CarePlanActivityStatus getStatus() { 
          return this.status == null ? null : this.status.getValue();
        }

        /**
         * @param value Identifies what progress is being made for the specific activity.
         */
        public CarePlanActivityPlannedActivityDetailComponent setStatus(CarePlanActivityStatus value) { 
            if (this.status == null)
              this.status = new Enumeration<CarePlanActivityStatus>(new CarePlanActivityStatusEnumFactory());
            this.status.setValue(value);
          return this;
        }

        /**
         * @return {@link #statusReason} (Provides reason why the activity isn't yet started, is on hold, was cancelled, etc.)
         */
        public CodeableConcept getStatusReason() { 
          if (this.statusReason == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CarePlanActivityPlannedActivityDetailComponent.statusReason");
            else if (Configuration.doAutoCreate())
              this.statusReason = new CodeableConcept(); // cc
          return this.statusReason;
        }

        public boolean hasStatusReason() { 
          return this.statusReason != null && !this.statusReason.isEmpty();
        }

        /**
         * @param value {@link #statusReason} (Provides reason why the activity isn't yet started, is on hold, was cancelled, etc.)
         */
        public CarePlanActivityPlannedActivityDetailComponent setStatusReason(CodeableConcept value) { 
          this.statusReason = value;
          return this;
        }

        /**
         * @return {@link #doNotPerform} (If true, indicates that the described activity is one that must NOT be engaged in when following the plan.  If false, or missing, indicates that the described activity is one that should be engaged in when following the plan.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
         */
        public BooleanType getDoNotPerformElement() { 
          if (this.doNotPerform == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CarePlanActivityPlannedActivityDetailComponent.doNotPerform");
            else if (Configuration.doAutoCreate())
              this.doNotPerform = new BooleanType(); // bb
          return this.doNotPerform;
        }

        public boolean hasDoNotPerformElement() { 
          return this.doNotPerform != null && !this.doNotPerform.isEmpty();
        }

        public boolean hasDoNotPerform() { 
          return this.doNotPerform != null && !this.doNotPerform.isEmpty();
        }

        /**
         * @param value {@link #doNotPerform} (If true, indicates that the described activity is one that must NOT be engaged in when following the plan.  If false, or missing, indicates that the described activity is one that should be engaged in when following the plan.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
         */
        public CarePlanActivityPlannedActivityDetailComponent setDoNotPerformElement(BooleanType value) { 
          this.doNotPerform = value;
          return this;
        }

        /**
         * @return If true, indicates that the described activity is one that must NOT be engaged in when following the plan.  If false, or missing, indicates that the described activity is one that should be engaged in when following the plan.
         */
        public boolean getDoNotPerform() { 
          return this.doNotPerform == null || this.doNotPerform.isEmpty() ? false : this.doNotPerform.getValue();
        }

        /**
         * @param value If true, indicates that the described activity is one that must NOT be engaged in when following the plan.  If false, or missing, indicates that the described activity is one that should be engaged in when following the plan.
         */
        public CarePlanActivityPlannedActivityDetailComponent setDoNotPerform(boolean value) { 
            if (this.doNotPerform == null)
              this.doNotPerform = new BooleanType();
            this.doNotPerform.setValue(value);
          return this;
        }

        /**
         * @return {@link #scheduled} (The period, timing or frequency upon which the described activity is to occur.)
         */
        public DataType getScheduled() { 
          return this.scheduled;
        }

        /**
         * @return {@link #scheduled} (The period, timing or frequency upon which the described activity is to occur.)
         */
        public Timing getScheduledTiming() throws FHIRException { 
          if (this.scheduled == null)
            this.scheduled = new Timing();
          if (!(this.scheduled instanceof Timing))
            throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.scheduled.getClass().getName()+" was encountered");
          return (Timing) this.scheduled;
        }

        public boolean hasScheduledTiming() { 
          return this != null && this.scheduled instanceof Timing;
        }

        /**
         * @return {@link #scheduled} (The period, timing or frequency upon which the described activity is to occur.)
         */
        public Period getScheduledPeriod() throws FHIRException { 
          if (this.scheduled == null)
            this.scheduled = new Period();
          if (!(this.scheduled instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.scheduled.getClass().getName()+" was encountered");
          return (Period) this.scheduled;
        }

        public boolean hasScheduledPeriod() { 
          return this != null && this.scheduled instanceof Period;
        }

        /**
         * @return {@link #scheduled} (The period, timing or frequency upon which the described activity is to occur.)
         */
        public StringType getScheduledStringType() throws FHIRException { 
          if (this.scheduled == null)
            this.scheduled = new StringType();
          if (!(this.scheduled instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.scheduled.getClass().getName()+" was encountered");
          return (StringType) this.scheduled;
        }

        public boolean hasScheduledStringType() { 
          return this != null && this.scheduled instanceof StringType;
        }

        public boolean hasScheduled() { 
          return this.scheduled != null && !this.scheduled.isEmpty();
        }

        /**
         * @param value {@link #scheduled} (The period, timing or frequency upon which the described activity is to occur.)
         */
        public CarePlanActivityPlannedActivityDetailComponent setScheduled(DataType value) { 
          if (value != null && !(value instanceof Timing || value instanceof Period || value instanceof StringType))
            throw new Error("Not the right type for CarePlan.activity.plannedActivityDetail.scheduled[x]: "+value.fhirType());
          this.scheduled = value;
          return this;
        }

        /**
         * @return {@link #location} (Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc.)
         */
        public CodeableReference getLocation() { 
          if (this.location == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CarePlanActivityPlannedActivityDetailComponent.location");
            else if (Configuration.doAutoCreate())
              this.location = new CodeableReference(); // cc
          return this.location;
        }

        public boolean hasLocation() { 
          return this.location != null && !this.location.isEmpty();
        }

        /**
         * @param value {@link #location} (Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc.)
         */
        public CarePlanActivityPlannedActivityDetailComponent setLocation(CodeableReference value) { 
          this.location = value;
          return this;
        }

        /**
         * @return {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
         */
        public DataType getReported() { 
          return this.reported;
        }

        /**
         * @return {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
         */
        public BooleanType getReportedBooleanType() throws FHIRException { 
          if (this.reported == null)
            this.reported = new BooleanType();
          if (!(this.reported instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.reported.getClass().getName()+" was encountered");
          return (BooleanType) this.reported;
        }

        public boolean hasReportedBooleanType() { 
          return this != null && this.reported instanceof BooleanType;
        }

        /**
         * @return {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
         */
        public Reference getReportedReference() throws FHIRException { 
          if (this.reported == null)
            this.reported = new Reference();
          if (!(this.reported instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.reported.getClass().getName()+" was encountered");
          return (Reference) this.reported;
        }

        public boolean hasReportedReference() { 
          return this != null && this.reported instanceof Reference;
        }

        public boolean hasReported() { 
          return this.reported != null && !this.reported.isEmpty();
        }

        /**
         * @param value {@link #reported} (Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.)
         */
        public CarePlanActivityPlannedActivityDetailComponent setReported(DataType value) { 
          if (value != null && !(value instanceof BooleanType || value instanceof Reference))
            throw new Error("Not the right type for CarePlan.activity.plannedActivityDetail.reported[x]: "+value.fhirType());
          this.reported = value;
          return this;
        }

        /**
         * @return {@link #performer} (Identifies who's expected to be involved in the activity.)
         */
        public List<Reference> getPerformer() { 
          if (this.performer == null)
            this.performer = new ArrayList<Reference>();
          return this.performer;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CarePlanActivityPlannedActivityDetailComponent setPerformer(List<Reference> thePerformer) { 
          this.performer = thePerformer;
          return this;
        }

        public boolean hasPerformer() { 
          if (this.performer == null)
            return false;
          for (Reference item : this.performer)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addPerformer() { //3
          Reference t = new Reference();
          if (this.performer == null)
            this.performer = new ArrayList<Reference>();
          this.performer.add(t);
          return t;
        }

        public CarePlanActivityPlannedActivityDetailComponent addPerformer(Reference t) { //3
          if (t == null)
            return this;
          if (this.performer == null)
            this.performer = new ArrayList<Reference>();
          this.performer.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
         */
        public Reference getPerformerFirstRep() { 
          if (getPerformer().isEmpty()) {
            addPerformer();
          }
          return getPerformer().get(0);
        }

        /**
         * @return {@link #product} (Identifies the food, drug or other product to be consumed or supplied in the activity.)
         */
        public DataType getProduct() { 
          return this.product;
        }

        /**
         * @return {@link #product} (Identifies the food, drug or other product to be consumed or supplied in the activity.)
         */
        public CodeableConcept getProductCodeableConcept() throws FHIRException { 
          if (this.product == null)
            this.product = new CodeableConcept();
          if (!(this.product instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.product.getClass().getName()+" was encountered");
          return (CodeableConcept) this.product;
        }

        public boolean hasProductCodeableConcept() { 
          return this != null && this.product instanceof CodeableConcept;
        }

        /**
         * @return {@link #product} (Identifies the food, drug or other product to be consumed or supplied in the activity.)
         */
        public Reference getProductReference() throws FHIRException { 
          if (this.product == null)
            this.product = new Reference();
          if (!(this.product instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.product.getClass().getName()+" was encountered");
          return (Reference) this.product;
        }

        public boolean hasProductReference() { 
          return this != null && this.product instanceof Reference;
        }

        public boolean hasProduct() { 
          return this.product != null && !this.product.isEmpty();
        }

        /**
         * @param value {@link #product} (Identifies the food, drug or other product to be consumed or supplied in the activity.)
         */
        public CarePlanActivityPlannedActivityDetailComponent setProduct(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
            throw new Error("Not the right type for CarePlan.activity.plannedActivityDetail.product[x]: "+value.fhirType());
          this.product = value;
          return this;
        }

        /**
         * @return {@link #dailyAmount} (Identifies the quantity expected to be consumed in a given day.)
         */
        public Quantity getDailyAmount() { 
          if (this.dailyAmount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CarePlanActivityPlannedActivityDetailComponent.dailyAmount");
            else if (Configuration.doAutoCreate())
              this.dailyAmount = new Quantity(); // cc
          return this.dailyAmount;
        }

        public boolean hasDailyAmount() { 
          return this.dailyAmount != null && !this.dailyAmount.isEmpty();
        }

        /**
         * @param value {@link #dailyAmount} (Identifies the quantity expected to be consumed in a given day.)
         */
        public CarePlanActivityPlannedActivityDetailComponent setDailyAmount(Quantity value) { 
          this.dailyAmount = value;
          return this;
        }

        /**
         * @return {@link #quantity} (Identifies the quantity expected to be supplied, administered or consumed by the subject.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CarePlanActivityPlannedActivityDetailComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (Identifies the quantity expected to be supplied, administered or consumed by the subject.)
         */
        public CarePlanActivityPlannedActivityDetailComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #description} (This provides a textual description of constraints on the intended activity occurrence, including relation to other activities.  It may also include objectives, pre-conditions and end-conditions.  Finally, it may convey specifics about the activity such as body site, method, route, etc.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CarePlanActivityPlannedActivityDetailComponent.description");
            else if (Configuration.doAutoCreate())
              this.description = new StringType(); // bb
          return this.description;
        }

        public boolean hasDescriptionElement() { 
          return this.description != null && !this.description.isEmpty();
        }

        public boolean hasDescription() { 
          return this.description != null && !this.description.isEmpty();
        }

        /**
         * @param value {@link #description} (This provides a textual description of constraints on the intended activity occurrence, including relation to other activities.  It may also include objectives, pre-conditions and end-conditions.  Finally, it may convey specifics about the activity such as body site, method, route, etc.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public CarePlanActivityPlannedActivityDetailComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return This provides a textual description of constraints on the intended activity occurrence, including relation to other activities.  It may also include objectives, pre-conditions and end-conditions.  Finally, it may convey specifics about the activity such as body site, method, route, etc.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value This provides a textual description of constraints on the intended activity occurrence, including relation to other activities.  It may also include objectives, pre-conditions and end-conditions.  Finally, it may convey specifics about the activity such as body site, method, route, etc.
         */
        public CarePlanActivityPlannedActivityDetailComponent setDescription(String value) { 
          if (Utilities.noString(value))
            this.description = null;
          else {
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("kind", "code", "A description of the kind of resource the in-line definition of a care plan activity is representing.  The CarePlan.activity.detail is an in-line definition when a resource is not referenced using CarePlan.activity.reference.  For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest.", 0, 1, kind));
          children.add(new Property("instantiatesCanonical", "canonical(PlanDefinition|ActivityDefinition|Questionnaire|Measure|OperationDefinition)", "The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical));
          children.add(new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri));
          children.add(new Property("code", "CodeableConcept", "Detailed description of the type of planned activity; e.g. what lab test, what procedure, what kind of encounter.", 0, 1, code));
          children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Provides the rationale that drove the inclusion of this particular activity as part of the plan or the reason why the activity was prohibited - either a coded concept, or another resource, such as the health condition(s), whose existence justifies this request and drove the inclusion of this particular activity as part of the plan.", 0, java.lang.Integer.MAX_VALUE, reason));
          children.add(new Property("goal", "Reference(Goal)", "Internal reference that identifies the goals that this activity is intended to contribute towards meeting.", 0, java.lang.Integer.MAX_VALUE, goal));
          children.add(new Property("status", "code", "Identifies what progress is being made for the specific activity.", 0, 1, status));
          children.add(new Property("statusReason", "CodeableConcept", "Provides reason why the activity isn't yet started, is on hold, was cancelled, etc.", 0, 1, statusReason));
          children.add(new Property("doNotPerform", "boolean", "If true, indicates that the described activity is one that must NOT be engaged in when following the plan.  If false, or missing, indicates that the described activity is one that should be engaged in when following the plan.", 0, 1, doNotPerform));
          children.add(new Property("scheduled[x]", "Timing|Period|string", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, scheduled));
          children.add(new Property("location", "CodeableReference(Location)", "Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc.", 0, 1, location));
          children.add(new Property("reported[x]", "boolean|Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.", 0, 1, reported));
          children.add(new Property("performer", "Reference(Practitioner|PractitionerRole|Organization|RelatedPerson|Patient|CareTeam|HealthcareService|Device)", "Identifies who's expected to be involved in the activity.", 0, java.lang.Integer.MAX_VALUE, performer));
          children.add(new Property("product[x]", "CodeableConcept|Reference(Medication|Substance)", "Identifies the food, drug or other product to be consumed or supplied in the activity.", 0, 1, product));
          children.add(new Property("dailyAmount", "Quantity", "Identifies the quantity expected to be consumed in a given day.", 0, 1, dailyAmount));
          children.add(new Property("quantity", "Quantity", "Identifies the quantity expected to be supplied, administered or consumed by the subject.", 0, 1, quantity));
          children.add(new Property("description", "string", "This provides a textual description of constraints on the intended activity occurrence, including relation to other activities.  It may also include objectives, pre-conditions and end-conditions.  Finally, it may convey specifics about the activity such as body site, method, route, etc.", 0, 1, description));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3292052: /*kind*/  return new Property("kind", "code", "A description of the kind of resource the in-line definition of a care plan activity is representing.  The CarePlan.activity.detail is an in-line definition when a resource is not referenced using CarePlan.activity.reference.  For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest.", 0, 1, kind);
          case 8911915: /*instantiatesCanonical*/  return new Property("instantiatesCanonical", "canonical(PlanDefinition|ActivityDefinition|Questionnaire|Measure|OperationDefinition)", "The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical);
          case -1926393373: /*instantiatesUri*/  return new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan activity.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Detailed description of the type of planned activity; e.g. what lab test, what procedure, what kind of encounter.", 0, 1, code);
          case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Provides the rationale that drove the inclusion of this particular activity as part of the plan or the reason why the activity was prohibited - either a coded concept, or another resource, such as the health condition(s), whose existence justifies this request and drove the inclusion of this particular activity as part of the plan.", 0, java.lang.Integer.MAX_VALUE, reason);
          case 3178259: /*goal*/  return new Property("goal", "Reference(Goal)", "Internal reference that identifies the goals that this activity is intended to contribute towards meeting.", 0, java.lang.Integer.MAX_VALUE, goal);
          case -892481550: /*status*/  return new Property("status", "code", "Identifies what progress is being made for the specific activity.", 0, 1, status);
          case 2051346646: /*statusReason*/  return new Property("statusReason", "CodeableConcept", "Provides reason why the activity isn't yet started, is on hold, was cancelled, etc.", 0, 1, statusReason);
          case -1788508167: /*doNotPerform*/  return new Property("doNotPerform", "boolean", "If true, indicates that the described activity is one that must NOT be engaged in when following the plan.  If false, or missing, indicates that the described activity is one that should be engaged in when following the plan.", 0, 1, doNotPerform);
          case 1162627251: /*scheduled[x]*/  return new Property("scheduled[x]", "Timing|Period|string", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, scheduled);
          case -160710483: /*scheduled*/  return new Property("scheduled[x]", "Timing|Period|string", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, scheduled);
          case 998483799: /*scheduledTiming*/  return new Property("scheduled[x]", "Timing", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, scheduled);
          case 880422094: /*scheduledPeriod*/  return new Property("scheduled[x]", "Period", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, scheduled);
          case 980162334: /*scheduledString*/  return new Property("scheduled[x]", "string", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, scheduled);
          case 1901043637: /*location*/  return new Property("location", "CodeableReference(Location)", "Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc.", 0, 1, location);
          case -241505587: /*reported[x]*/  return new Property("reported[x]", "boolean|Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.", 0, 1, reported);
          case -427039533: /*reported*/  return new Property("reported[x]", "boolean|Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.", 0, 1, reported);
          case 1219992533: /*reportedBoolean*/  return new Property("reported[x]", "boolean", "Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.", 0, 1, reported);
          case 1198143416: /*reportedReference*/  return new Property("reported[x]", "Reference(Patient|RelatedPerson|Practitioner|PractitionerRole|Organization)", "Indicates if this record was captured as a secondary 'reported' record rather than as an original primary source-of-truth record.  It may also indicate the source of the report.", 0, 1, reported);
          case 481140686: /*performer*/  return new Property("performer", "Reference(Practitioner|PractitionerRole|Organization|RelatedPerson|Patient|CareTeam|HealthcareService|Device)", "Identifies who's expected to be involved in the activity.", 0, java.lang.Integer.MAX_VALUE, performer);
          case 1753005361: /*product[x]*/  return new Property("product[x]", "CodeableConcept|Reference(Medication|Substance)", "Identifies the food, drug or other product to be consumed or supplied in the activity.", 0, 1, product);
          case -309474065: /*product*/  return new Property("product[x]", "CodeableConcept|Reference(Medication|Substance)", "Identifies the food, drug or other product to be consumed or supplied in the activity.", 0, 1, product);
          case 906854066: /*productCodeableConcept*/  return new Property("product[x]", "CodeableConcept", "Identifies the food, drug or other product to be consumed or supplied in the activity.", 0, 1, product);
          case -669667556: /*productReference*/  return new Property("product[x]", "Reference(Medication|Substance)", "Identifies the food, drug or other product to be consumed or supplied in the activity.", 0, 1, product);
          case -768908335: /*dailyAmount*/  return new Property("dailyAmount", "Quantity", "Identifies the quantity expected to be consumed in a given day.", 0, 1, dailyAmount);
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "Identifies the quantity expected to be supplied, administered or consumed by the subject.", 0, 1, quantity);
          case -1724546052: /*description*/  return new Property("description", "string", "This provides a textual description of constraints on the intended activity occurrence, including relation to other activities.  It may also include objectives, pre-conditions and end-conditions.  Finally, it may convey specifics about the activity such as body site, method, route, etc.", 0, 1, description);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3292052: /*kind*/ return this.kind == null ? new Base[0] : new Base[] {this.kind}; // Enumeration<CarePlanActivityKind>
        case 8911915: /*instantiatesCanonical*/ return this.instantiatesCanonical == null ? new Base[0] : this.instantiatesCanonical.toArray(new Base[this.instantiatesCanonical.size()]); // CanonicalType
        case -1926393373: /*instantiatesUri*/ return this.instantiatesUri == null ? new Base[0] : this.instantiatesUri.toArray(new Base[this.instantiatesUri.size()]); // UriType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 3178259: /*goal*/ return this.goal == null ? new Base[0] : this.goal.toArray(new Base[this.goal.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<CarePlanActivityStatus>
        case 2051346646: /*statusReason*/ return this.statusReason == null ? new Base[0] : new Base[] {this.statusReason}; // CodeableConcept
        case -1788508167: /*doNotPerform*/ return this.doNotPerform == null ? new Base[0] : new Base[] {this.doNotPerform}; // BooleanType
        case -160710483: /*scheduled*/ return this.scheduled == null ? new Base[0] : new Base[] {this.scheduled}; // DataType
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // CodeableReference
        case -427039533: /*reported*/ return this.reported == null ? new Base[0] : new Base[] {this.reported}; // DataType
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // Reference
        case -309474065: /*product*/ return this.product == null ? new Base[0] : new Base[] {this.product}; // DataType
        case -768908335: /*dailyAmount*/ return this.dailyAmount == null ? new Base[0] : new Base[] {this.dailyAmount}; // Quantity
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3292052: // kind
          value = new CarePlanActivityKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<CarePlanActivityKind>
          return value;
        case 8911915: // instantiatesCanonical
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -1926393373: // instantiatesUri
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 3178259: // goal
          this.getGoal().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new CarePlanActivityStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<CarePlanActivityStatus>
          return value;
        case 2051346646: // statusReason
          this.statusReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1788508167: // doNotPerform
          this.doNotPerform = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -160710483: // scheduled
          this.scheduled = TypeConvertor.castToType(value); // DataType
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -427039533: // reported
          this.reported = TypeConvertor.castToType(value); // DataType
          return value;
        case 481140686: // performer
          this.getPerformer().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -309474065: // product
          this.product = TypeConvertor.castToType(value); // DataType
          return value;
        case -768908335: // dailyAmount
          this.dailyAmount = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("kind")) {
          value = new CarePlanActivityKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<CarePlanActivityKind>
        } else if (name.equals("instantiatesCanonical")) {
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("instantiatesUri")) {
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("goal")) {
          this.getGoal().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new CarePlanActivityStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<CarePlanActivityStatus>
        } else if (name.equals("statusReason")) {
          this.statusReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("doNotPerform")) {
          this.doNotPerform = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("scheduled[x]")) {
          this.scheduled = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("reported[x]")) {
          this.reported = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("performer")) {
          this.getPerformer().add(TypeConvertor.castToReference(value));
        } else if (name.equals("product[x]")) {
          this.product = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("dailyAmount")) {
          this.dailyAmount = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3292052:  return getKindElement();
        case 8911915:  return addInstantiatesCanonicalElement();
        case -1926393373:  return addInstantiatesUriElement();
        case 3059181:  return getCode();
        case -934964668:  return addReason(); 
        case 3178259:  return addGoal(); 
        case -892481550:  return getStatusElement();
        case 2051346646:  return getStatusReason();
        case -1788508167:  return getDoNotPerformElement();
        case 1162627251:  return getScheduled();
        case -160710483:  return getScheduled();
        case 1901043637:  return getLocation();
        case -241505587:  return getReported();
        case -427039533:  return getReported();
        case 481140686:  return addPerformer(); 
        case 1753005361:  return getProduct();
        case -309474065:  return getProduct();
        case -768908335:  return getDailyAmount();
        case -1285004149:  return getQuantity();
        case -1724546052:  return getDescriptionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3292052: /*kind*/ return new String[] {"code"};
        case 8911915: /*instantiatesCanonical*/ return new String[] {"canonical"};
        case -1926393373: /*instantiatesUri*/ return new String[] {"uri"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 3178259: /*goal*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 2051346646: /*statusReason*/ return new String[] {"CodeableConcept"};
        case -1788508167: /*doNotPerform*/ return new String[] {"boolean"};
        case -160710483: /*scheduled*/ return new String[] {"Timing", "Period", "string"};
        case 1901043637: /*location*/ return new String[] {"CodeableReference"};
        case -427039533: /*reported*/ return new String[] {"boolean", "Reference"};
        case 481140686: /*performer*/ return new String[] {"Reference"};
        case -309474065: /*product*/ return new String[] {"CodeableConcept", "Reference"};
        case -768908335: /*dailyAmount*/ return new String[] {"Quantity"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case -1724546052: /*description*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("kind")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.activity.plannedActivityDetail.kind");
        }
        else if (name.equals("instantiatesCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.activity.plannedActivityDetail.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.activity.plannedActivityDetail.instantiatesUri");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("goal")) {
          return addGoal();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.activity.plannedActivityDetail.status");
        }
        else if (name.equals("statusReason")) {
          this.statusReason = new CodeableConcept();
          return this.statusReason;
        }
        else if (name.equals("doNotPerform")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.activity.plannedActivityDetail.doNotPerform");
        }
        else if (name.equals("scheduledTiming")) {
          this.scheduled = new Timing();
          return this.scheduled;
        }
        else if (name.equals("scheduledPeriod")) {
          this.scheduled = new Period();
          return this.scheduled;
        }
        else if (name.equals("scheduledString")) {
          this.scheduled = new StringType();
          return this.scheduled;
        }
        else if (name.equals("location")) {
          this.location = new CodeableReference();
          return this.location;
        }
        else if (name.equals("reportedBoolean")) {
          this.reported = new BooleanType();
          return this.reported;
        }
        else if (name.equals("reportedReference")) {
          this.reported = new Reference();
          return this.reported;
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("productCodeableConcept")) {
          this.product = new CodeableConcept();
          return this.product;
        }
        else if (name.equals("productReference")) {
          this.product = new Reference();
          return this.product;
        }
        else if (name.equals("dailyAmount")) {
          this.dailyAmount = new Quantity();
          return this.dailyAmount;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.activity.plannedActivityDetail.description");
        }
        else
          return super.addChild(name);
      }

      public CarePlanActivityPlannedActivityDetailComponent copy() {
        CarePlanActivityPlannedActivityDetailComponent dst = new CarePlanActivityPlannedActivityDetailComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CarePlanActivityPlannedActivityDetailComponent dst) {
        super.copyValues(dst);
        dst.kind = kind == null ? null : kind.copy();
        if (instantiatesCanonical != null) {
          dst.instantiatesCanonical = new ArrayList<CanonicalType>();
          for (CanonicalType i : instantiatesCanonical)
            dst.instantiatesCanonical.add(i.copy());
        };
        if (instantiatesUri != null) {
          dst.instantiatesUri = new ArrayList<UriType>();
          for (UriType i : instantiatesUri)
            dst.instantiatesUri.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        if (goal != null) {
          dst.goal = new ArrayList<Reference>();
          for (Reference i : goal)
            dst.goal.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.statusReason = statusReason == null ? null : statusReason.copy();
        dst.doNotPerform = doNotPerform == null ? null : doNotPerform.copy();
        dst.scheduled = scheduled == null ? null : scheduled.copy();
        dst.location = location == null ? null : location.copy();
        dst.reported = reported == null ? null : reported.copy();
        if (performer != null) {
          dst.performer = new ArrayList<Reference>();
          for (Reference i : performer)
            dst.performer.add(i.copy());
        };
        dst.product = product == null ? null : product.copy();
        dst.dailyAmount = dailyAmount == null ? null : dailyAmount.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.description = description == null ? null : description.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CarePlanActivityPlannedActivityDetailComponent))
          return false;
        CarePlanActivityPlannedActivityDetailComponent o = (CarePlanActivityPlannedActivityDetailComponent) other_;
        return compareDeep(kind, o.kind, true) && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareDeep(instantiatesUri, o.instantiatesUri, true) && compareDeep(code, o.code, true) && compareDeep(reason, o.reason, true)
           && compareDeep(goal, o.goal, true) && compareDeep(status, o.status, true) && compareDeep(statusReason, o.statusReason, true)
           && compareDeep(doNotPerform, o.doNotPerform, true) && compareDeep(scheduled, o.scheduled, true)
           && compareDeep(location, o.location, true) && compareDeep(reported, o.reported, true) && compareDeep(performer, o.performer, true)
           && compareDeep(product, o.product, true) && compareDeep(dailyAmount, o.dailyAmount, true) && compareDeep(quantity, o.quantity, true)
           && compareDeep(description, o.description, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CarePlanActivityPlannedActivityDetailComponent))
          return false;
        CarePlanActivityPlannedActivityDetailComponent o = (CarePlanActivityPlannedActivityDetailComponent) other_;
        return compareValues(kind, o.kind, true) && compareValues(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareValues(instantiatesUri, o.instantiatesUri, true) && compareValues(status, o.status, true)
           && compareValues(doNotPerform, o.doNotPerform, true) && compareValues(description, o.description, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(kind, instantiatesCanonical
          , instantiatesUri, code, reason, goal, status, statusReason, doNotPerform, scheduled
          , location, reported, performer, product, dailyAmount, quantity, description);
      }

  public String fhirType() {
    return "CarePlan.activity.plannedActivityDetail";

  }

  }

    /**
     * Business identifiers assigned to this care plan by the performer or other systems which remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External Ids for this plan", formalDefinition="Business identifiers assigned to this care plan by the performer or other systems which remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.
     */
    @Child(name = "instantiatesCanonical", type = {CanonicalType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates FHIR protocol or definition", formalDefinition="The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan." )
    protected List<CanonicalType> instantiatesCanonical;

    /**
     * The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.
     */
    @Child(name = "instantiatesUri", type = {UriType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates external protocol or definition", formalDefinition="The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan." )
    protected List<UriType> instantiatesUri;

    /**
     * A care plan that is fulfilled in whole or in part by this care plan.
     */
    @Child(name = "basedOn", type = {CarePlan.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Fulfills CarePlan", formalDefinition="A care plan that is fulfilled in whole or in part by this care plan." )
    protected List<Reference> basedOn;

    /**
     * Completed or terminated care plan whose function is taken by this new care plan.
     */
    @Child(name = "replaces", type = {CarePlan.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="CarePlan replaced by this CarePlan", formalDefinition="Completed or terminated care plan whose function is taken by this new care plan." )
    protected List<Reference> replaces;

    /**
     * A larger care plan of which this particular care plan is a component or step.
     */
    @Child(name = "partOf", type = {CarePlan.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Part of referenced CarePlan", formalDefinition="A larger care plan of which this particular care plan is a component or step." )
    protected List<Reference> partOf;

    /**
     * Indicates whether the plan is currently being acted upon, represents future intentions or is now a historical record.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | on-hold | revoked | completed | entered-in-error | unknown", formalDefinition="Indicates whether the plan is currently being acted upon, represents future intentions or is now a historical record." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-status")
    protected Enumeration<RequestStatus> status;

    /**
     * Indicates the level of authority/intentionality associated with the care plan and where the care plan fits into the workflow chain.
     */
    @Child(name = "intent", type = {CodeType.class}, order=7, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="proposal | plan | order | option | directive", formalDefinition="Indicates the level of authority/intentionality associated with the care plan and where the care plan fits into the workflow chain." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/care-plan-intent")
    protected Enumeration<CarePlanIntent> intent;

    /**
     * Identifies what "kind" of plan this is to support differentiation between multiple co-existing plans; e.g. "Home health", "psychiatric", "asthma", "disease management", "wellness plan", etc.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Type of plan", formalDefinition="Identifies what \"kind\" of plan this is to support differentiation between multiple co-existing plans; e.g. \"Home health\", \"psychiatric\", \"asthma\", \"disease management\", \"wellness plan\", etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/care-plan-category")
    protected List<CodeableConcept> category;

    /**
     * Human-friendly name for the care plan.
     */
    @Child(name = "title", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Human-friendly name for the care plan", formalDefinition="Human-friendly name for the care plan." )
    protected StringType title;

    /**
     * A description of the scope and nature of the plan.
     */
    @Child(name = "description", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Summary of nature of plan", formalDefinition="A description of the scope and nature of the plan." )
    protected StringType description;

    /**
     * Identifies the patient or group whose intended care is described by the plan.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=11, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who the care plan is for", formalDefinition="Identifies the patient or group whose intended care is described by the plan." )
    protected Reference subject;

    /**
     * The Encounter during which this CarePlan was created or to which the creation of this record is tightly associated.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The Encounter during which this CarePlan was created", formalDefinition="The Encounter during which this CarePlan was created or to which the creation of this record is tightly associated." )
    protected Reference encounter;

    /**
     * Indicates when the plan did (or is intended to) come into effect and end.
     */
    @Child(name = "period", type = {Period.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Time period plan covers", formalDefinition="Indicates when the plan did (or is intended to) come into effect and end." )
    protected Period period;

    /**
     * Represents when this particular CarePlan record was created in the system, which is often a system-generated date.
     */
    @Child(name = "created", type = {DateTimeType.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date record was first recorded", formalDefinition="Represents when this particular CarePlan record was created in the system, which is often a system-generated date." )
    protected DateTimeType created;

    /**
     * When populated, the custodian is responsible for the care plan. The care plan is attributed to the custodian.
     */
    @Child(name = "custodian", type = {Patient.class, Practitioner.class, PractitionerRole.class, Device.class, RelatedPerson.class, Organization.class, CareTeam.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who is the designated responsible party", formalDefinition="When populated, the custodian is responsible for the care plan. The care plan is attributed to the custodian." )
    protected Reference custodian;

    /**
     * Identifies the individual(s), organization or device who provided the contents of the care plan.
     */
    @Child(name = "contributor", type = {Patient.class, Practitioner.class, PractitionerRole.class, Device.class, RelatedPerson.class, Organization.class, CareTeam.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who provided the content of the care plan", formalDefinition="Identifies the individual(s), organization or device who provided the contents of the care plan." )
    protected List<Reference> contributor;

    /**
     * Identifies all people and organizations who are expected to be involved in the care envisioned by this plan.
     */
    @Child(name = "careTeam", type = {CareTeam.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who's involved in plan?", formalDefinition="Identifies all people and organizations who are expected to be involved in the care envisioned by this plan." )
    protected List<Reference> careTeam;

    /**
     * Identifies the conditions/problems/concerns/diagnoses/etc. whose management and/or mitigation are handled by this plan.
     */
    @Child(name = "addresses", type = {CodeableReference.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Health issues this plan addresses", formalDefinition="Identifies the conditions/problems/concerns/diagnoses/etc. whose management and/or mitigation are handled by this plan." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinical-findings")
    protected List<CodeableReference> addresses;

    /**
     * Identifies portions of the patient's record that specifically influenced the formation of the plan.  These might include comorbidities, recent procedures, limitations, recent assessments, etc.
     */
    @Child(name = "supportingInfo", type = {Reference.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Information considered as part of plan", formalDefinition="Identifies portions of the patient's record that specifically influenced the formation of the plan.  These might include comorbidities, recent procedures, limitations, recent assessments, etc." )
    protected List<Reference> supportingInfo;

    /**
     * Describes the intended objective(s) of carrying out the care plan.
     */
    @Child(name = "goal", type = {Goal.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Desired outcome of plan", formalDefinition="Describes the intended objective(s) of carrying out the care plan." )
    protected List<Reference> goal;

    /**
     * Identifies an action that has occurred or is a planned action to occur as part of the plan. For example, a medication to be used, lab tests to perform, self-monitoring that has occurred, education etc.
     */
    @Child(name = "activity", type = {}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Action to occur or has occurred as part of plan", formalDefinition="Identifies an action that has occurred or is a planned action to occur as part of the plan. For example, a medication to be used, lab tests to perform, self-monitoring that has occurred, education etc." )
    protected List<CarePlanActivityComponent> activity;

    /**
     * General notes about the care plan not covered elsewhere.
     */
    @Child(name = "note", type = {Annotation.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments about the plan", formalDefinition="General notes about the care plan not covered elsewhere." )
    protected List<Annotation> note;

    private static final long serialVersionUID = -700769298L;

  /**
   * Constructor
   */
    public CarePlan() {
      super();
    }

  /**
   * Constructor
   */
    public CarePlan(RequestStatus status, CarePlanIntent intent, Reference subject) {
      super();
      this.setStatus(status);
      this.setIntent(intent);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this care plan by the performer or other systems which remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public CarePlan addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.)
     */
    public List<CanonicalType> getInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      return this.instantiatesCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical) { 
      this.instantiatesCanonical = theInstantiatesCanonical;
      return this;
    }

    public boolean hasInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        return false;
      for (CanonicalType item : this.instantiatesCanonical)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.)
     */
    public CanonicalType addInstantiatesCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.)
     */
    public CarePlan addInstantiatesCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.)
     */
    public boolean hasInstantiatesCanonical(String value) { 
      if (this.instantiatesCanonical == null)
        return false;
      for (CanonicalType v : this.instantiatesCanonical)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.)
     */
    public List<UriType> getInstantiatesUri() { 
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      return this.instantiatesUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setInstantiatesUri(List<UriType> theInstantiatesUri) { 
      this.instantiatesUri = theInstantiatesUri;
      return this;
    }

    public boolean hasInstantiatesUri() { 
      if (this.instantiatesUri == null)
        return false;
      for (UriType item : this.instantiatesUri)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.)
     */
    public UriType addInstantiatesUriElement() {//2 
      UriType t = new UriType();
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.)
     */
    public CarePlan addInstantiatesUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.)
     */
    public boolean hasInstantiatesUri(String value) { 
      if (this.instantiatesUri == null)
        return false;
      for (UriType v : this.instantiatesUri)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #basedOn} (A care plan that is fulfilled in whole or in part by this care plan.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setBasedOn(List<Reference> theBasedOn) { 
      this.basedOn = theBasedOn;
      return this;
    }

    public boolean hasBasedOn() { 
      if (this.basedOn == null)
        return false;
      for (Reference item : this.basedOn)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addBasedOn() { //3
      Reference t = new Reference();
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return t;
    }

    public CarePlan addBasedOn(Reference t) { //3
      if (t == null)
        return this;
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist {3}
     */
    public Reference getBasedOnFirstRep() { 
      if (getBasedOn().isEmpty()) {
        addBasedOn();
      }
      return getBasedOn().get(0);
    }

    /**
     * @return {@link #replaces} (Completed or terminated care plan whose function is taken by this new care plan.)
     */
    public List<Reference> getReplaces() { 
      if (this.replaces == null)
        this.replaces = new ArrayList<Reference>();
      return this.replaces;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setReplaces(List<Reference> theReplaces) { 
      this.replaces = theReplaces;
      return this;
    }

    public boolean hasReplaces() { 
      if (this.replaces == null)
        return false;
      for (Reference item : this.replaces)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addReplaces() { //3
      Reference t = new Reference();
      if (this.replaces == null)
        this.replaces = new ArrayList<Reference>();
      this.replaces.add(t);
      return t;
    }

    public CarePlan addReplaces(Reference t) { //3
      if (t == null)
        return this;
      if (this.replaces == null)
        this.replaces = new ArrayList<Reference>();
      this.replaces.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #replaces}, creating it if it does not already exist {3}
     */
    public Reference getReplacesFirstRep() { 
      if (getReplaces().isEmpty()) {
        addReplaces();
      }
      return getReplaces().get(0);
    }

    /**
     * @return {@link #partOf} (A larger care plan of which this particular care plan is a component or step.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setPartOf(List<Reference> thePartOf) { 
      this.partOf = thePartOf;
      return this;
    }

    public boolean hasPartOf() { 
      if (this.partOf == null)
        return false;
      for (Reference item : this.partOf)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPartOf() { //3
      Reference t = new Reference();
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return t;
    }

    public CarePlan addPartOf(Reference t) { //3
      if (t == null)
        return this;
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #partOf}, creating it if it does not already exist {3}
     */
    public Reference getPartOfFirstRep() { 
      if (getPartOf().isEmpty()) {
        addPartOf();
      }
      return getPartOf().get(0);
    }

    /**
     * @return {@link #status} (Indicates whether the plan is currently being acted upon, represents future intentions or is now a historical record.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<RequestStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CarePlan.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<RequestStatus>(new RequestStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Indicates whether the plan is currently being acted upon, represents future intentions or is now a historical record.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public CarePlan setStatusElement(Enumeration<RequestStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return Indicates whether the plan is currently being acted upon, represents future intentions or is now a historical record.
     */
    public RequestStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value Indicates whether the plan is currently being acted upon, represents future intentions or is now a historical record.
     */
    public CarePlan setStatus(RequestStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<RequestStatus>(new RequestStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #intent} (Indicates the level of authority/intentionality associated with the care plan and where the care plan fits into the workflow chain.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public Enumeration<CarePlanIntent> getIntentElement() { 
      if (this.intent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CarePlan.intent");
        else if (Configuration.doAutoCreate())
          this.intent = new Enumeration<CarePlanIntent>(new CarePlanIntentEnumFactory()); // bb
      return this.intent;
    }

    public boolean hasIntentElement() { 
      return this.intent != null && !this.intent.isEmpty();
    }

    public boolean hasIntent() { 
      return this.intent != null && !this.intent.isEmpty();
    }

    /**
     * @param value {@link #intent} (Indicates the level of authority/intentionality associated with the care plan and where the care plan fits into the workflow chain.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public CarePlan setIntentElement(Enumeration<CarePlanIntent> value) { 
      this.intent = value;
      return this;
    }

    /**
     * @return Indicates the level of authority/intentionality associated with the care plan and where the care plan fits into the workflow chain.
     */
    public CarePlanIntent getIntent() { 
      return this.intent == null ? null : this.intent.getValue();
    }

    /**
     * @param value Indicates the level of authority/intentionality associated with the care plan and where the care plan fits into the workflow chain.
     */
    public CarePlan setIntent(CarePlanIntent value) { 
        if (this.intent == null)
          this.intent = new Enumeration<CarePlanIntent>(new CarePlanIntentEnumFactory());
        this.intent.setValue(value);
      return this;
    }

    /**
     * @return {@link #category} (Identifies what "kind" of plan this is to support differentiation between multiple co-existing plans; e.g. "Home health", "psychiatric", "asthma", "disease management", "wellness plan", etc.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public CarePlan addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #title} (Human-friendly name for the care plan.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CarePlan.title");
        else if (Configuration.doAutoCreate())
          this.title = new StringType(); // bb
      return this.title;
    }

    public boolean hasTitleElement() { 
      return this.title != null && !this.title.isEmpty();
    }

    public boolean hasTitle() { 
      return this.title != null && !this.title.isEmpty();
    }

    /**
     * @param value {@link #title} (Human-friendly name for the care plan.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public CarePlan setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return Human-friendly name for the care plan.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value Human-friendly name for the care plan.
     */
    public CarePlan setTitle(String value) { 
      if (Utilities.noString(value))
        this.title = null;
      else {
        if (this.title == null)
          this.title = new StringType();
        this.title.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #description} (A description of the scope and nature of the plan.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CarePlan.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (A description of the scope and nature of the plan.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public CarePlan setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A description of the scope and nature of the plan.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A description of the scope and nature of the plan.
     */
    public CarePlan setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #subject} (Identifies the patient or group whose intended care is described by the plan.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CarePlan.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Identifies the patient or group whose intended care is described by the plan.)
     */
    public CarePlan setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The Encounter during which this CarePlan was created or to which the creation of this record is tightly associated.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CarePlan.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The Encounter during which this CarePlan was created or to which the creation of this record is tightly associated.)
     */
    public CarePlan setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #period} (Indicates when the plan did (or is intended to) come into effect and end.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CarePlan.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (Indicates when the plan did (or is intended to) come into effect and end.)
     */
    public CarePlan setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #created} (Represents when this particular CarePlan record was created in the system, which is often a system-generated date.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public DateTimeType getCreatedElement() { 
      if (this.created == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CarePlan.created");
        else if (Configuration.doAutoCreate())
          this.created = new DateTimeType(); // bb
      return this.created;
    }

    public boolean hasCreatedElement() { 
      return this.created != null && !this.created.isEmpty();
    }

    public boolean hasCreated() { 
      return this.created != null && !this.created.isEmpty();
    }

    /**
     * @param value {@link #created} (Represents when this particular CarePlan record was created in the system, which is often a system-generated date.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public CarePlan setCreatedElement(DateTimeType value) { 
      this.created = value;
      return this;
    }

    /**
     * @return Represents when this particular CarePlan record was created in the system, which is often a system-generated date.
     */
    public Date getCreated() { 
      return this.created == null ? null : this.created.getValue();
    }

    /**
     * @param value Represents when this particular CarePlan record was created in the system, which is often a system-generated date.
     */
    public CarePlan setCreated(Date value) { 
      if (value == null)
        this.created = null;
      else {
        if (this.created == null)
          this.created = new DateTimeType();
        this.created.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #custodian} (When populated, the custodian is responsible for the care plan. The care plan is attributed to the custodian.)
     */
    public Reference getCustodian() { 
      if (this.custodian == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CarePlan.custodian");
        else if (Configuration.doAutoCreate())
          this.custodian = new Reference(); // cc
      return this.custodian;
    }

    public boolean hasCustodian() { 
      return this.custodian != null && !this.custodian.isEmpty();
    }

    /**
     * @param value {@link #custodian} (When populated, the custodian is responsible for the care plan. The care plan is attributed to the custodian.)
     */
    public CarePlan setCustodian(Reference value) { 
      this.custodian = value;
      return this;
    }

    /**
     * @return {@link #contributor} (Identifies the individual(s), organization or device who provided the contents of the care plan.)
     */
    public List<Reference> getContributor() { 
      if (this.contributor == null)
        this.contributor = new ArrayList<Reference>();
      return this.contributor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setContributor(List<Reference> theContributor) { 
      this.contributor = theContributor;
      return this;
    }

    public boolean hasContributor() { 
      if (this.contributor == null)
        return false;
      for (Reference item : this.contributor)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addContributor() { //3
      Reference t = new Reference();
      if (this.contributor == null)
        this.contributor = new ArrayList<Reference>();
      this.contributor.add(t);
      return t;
    }

    public CarePlan addContributor(Reference t) { //3
      if (t == null)
        return this;
      if (this.contributor == null)
        this.contributor = new ArrayList<Reference>();
      this.contributor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contributor}, creating it if it does not already exist {3}
     */
    public Reference getContributorFirstRep() { 
      if (getContributor().isEmpty()) {
        addContributor();
      }
      return getContributor().get(0);
    }

    /**
     * @return {@link #careTeam} (Identifies all people and organizations who are expected to be involved in the care envisioned by this plan.)
     */
    public List<Reference> getCareTeam() { 
      if (this.careTeam == null)
        this.careTeam = new ArrayList<Reference>();
      return this.careTeam;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setCareTeam(List<Reference> theCareTeam) { 
      this.careTeam = theCareTeam;
      return this;
    }

    public boolean hasCareTeam() { 
      if (this.careTeam == null)
        return false;
      for (Reference item : this.careTeam)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addCareTeam() { //3
      Reference t = new Reference();
      if (this.careTeam == null)
        this.careTeam = new ArrayList<Reference>();
      this.careTeam.add(t);
      return t;
    }

    public CarePlan addCareTeam(Reference t) { //3
      if (t == null)
        return this;
      if (this.careTeam == null)
        this.careTeam = new ArrayList<Reference>();
      this.careTeam.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #careTeam}, creating it if it does not already exist {3}
     */
    public Reference getCareTeamFirstRep() { 
      if (getCareTeam().isEmpty()) {
        addCareTeam();
      }
      return getCareTeam().get(0);
    }

    /**
     * @return {@link #addresses} (Identifies the conditions/problems/concerns/diagnoses/etc. whose management and/or mitigation are handled by this plan.)
     */
    public List<CodeableReference> getAddresses() { 
      if (this.addresses == null)
        this.addresses = new ArrayList<CodeableReference>();
      return this.addresses;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setAddresses(List<CodeableReference> theAddresses) { 
      this.addresses = theAddresses;
      return this;
    }

    public boolean hasAddresses() { 
      if (this.addresses == null)
        return false;
      for (CodeableReference item : this.addresses)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addAddresses() { //3
      CodeableReference t = new CodeableReference();
      if (this.addresses == null)
        this.addresses = new ArrayList<CodeableReference>();
      this.addresses.add(t);
      return t;
    }

    public CarePlan addAddresses(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.addresses == null)
        this.addresses = new ArrayList<CodeableReference>();
      this.addresses.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #addresses}, creating it if it does not already exist {3}
     */
    public CodeableReference getAddressesFirstRep() { 
      if (getAddresses().isEmpty()) {
        addAddresses();
      }
      return getAddresses().get(0);
    }

    /**
     * @return {@link #supportingInfo} (Identifies portions of the patient's record that specifically influenced the formation of the plan.  These might include comorbidities, recent procedures, limitations, recent assessments, etc.)
     */
    public List<Reference> getSupportingInfo() { 
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      return this.supportingInfo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setSupportingInfo(List<Reference> theSupportingInfo) { 
      this.supportingInfo = theSupportingInfo;
      return this;
    }

    public boolean hasSupportingInfo() { 
      if (this.supportingInfo == null)
        return false;
      for (Reference item : this.supportingInfo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSupportingInfo() { //3
      Reference t = new Reference();
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      this.supportingInfo.add(t);
      return t;
    }

    public CarePlan addSupportingInfo(Reference t) { //3
      if (t == null)
        return this;
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      this.supportingInfo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #supportingInfo}, creating it if it does not already exist {3}
     */
    public Reference getSupportingInfoFirstRep() { 
      if (getSupportingInfo().isEmpty()) {
        addSupportingInfo();
      }
      return getSupportingInfo().get(0);
    }

    /**
     * @return {@link #goal} (Describes the intended objective(s) of carrying out the care plan.)
     */
    public List<Reference> getGoal() { 
      if (this.goal == null)
        this.goal = new ArrayList<Reference>();
      return this.goal;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setGoal(List<Reference> theGoal) { 
      this.goal = theGoal;
      return this;
    }

    public boolean hasGoal() { 
      if (this.goal == null)
        return false;
      for (Reference item : this.goal)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addGoal() { //3
      Reference t = new Reference();
      if (this.goal == null)
        this.goal = new ArrayList<Reference>();
      this.goal.add(t);
      return t;
    }

    public CarePlan addGoal(Reference t) { //3
      if (t == null)
        return this;
      if (this.goal == null)
        this.goal = new ArrayList<Reference>();
      this.goal.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #goal}, creating it if it does not already exist {3}
     */
    public Reference getGoalFirstRep() { 
      if (getGoal().isEmpty()) {
        addGoal();
      }
      return getGoal().get(0);
    }

    /**
     * @return {@link #activity} (Identifies an action that has occurred or is a planned action to occur as part of the plan. For example, a medication to be used, lab tests to perform, self-monitoring that has occurred, education etc.)
     */
    public List<CarePlanActivityComponent> getActivity() { 
      if (this.activity == null)
        this.activity = new ArrayList<CarePlanActivityComponent>();
      return this.activity;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setActivity(List<CarePlanActivityComponent> theActivity) { 
      this.activity = theActivity;
      return this;
    }

    public boolean hasActivity() { 
      if (this.activity == null)
        return false;
      for (CarePlanActivityComponent item : this.activity)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CarePlanActivityComponent addActivity() { //3
      CarePlanActivityComponent t = new CarePlanActivityComponent();
      if (this.activity == null)
        this.activity = new ArrayList<CarePlanActivityComponent>();
      this.activity.add(t);
      return t;
    }

    public CarePlan addActivity(CarePlanActivityComponent t) { //3
      if (t == null)
        return this;
      if (this.activity == null)
        this.activity = new ArrayList<CarePlanActivityComponent>();
      this.activity.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #activity}, creating it if it does not already exist {3}
     */
    public CarePlanActivityComponent getActivityFirstRep() { 
      if (getActivity().isEmpty()) {
        addActivity();
      }
      return getActivity().get(0);
    }

    /**
     * @return {@link #note} (General notes about the care plan not covered elsewhere.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CarePlan setNote(List<Annotation> theNote) { 
      this.note = theNote;
      return this;
    }

    public boolean hasNote() { 
      if (this.note == null)
        return false;
      for (Annotation item : this.note)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Annotation addNote() { //3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public CarePlan addNote(Annotation t) { //3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
     */
    public Annotation getNoteFirstRep() { 
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this care plan by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("instantiatesCanonical", "canonical(PlanDefinition|Questionnaire|Measure|ActivityDefinition|OperationDefinition)", "The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical));
        children.add(new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri));
        children.add(new Property("basedOn", "Reference(CarePlan)", "A care plan that is fulfilled in whole or in part by this care plan.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("replaces", "Reference(CarePlan)", "Completed or terminated care plan whose function is taken by this new care plan.", 0, java.lang.Integer.MAX_VALUE, replaces));
        children.add(new Property("partOf", "Reference(CarePlan)", "A larger care plan of which this particular care plan is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "Indicates whether the plan is currently being acted upon, represents future intentions or is now a historical record.", 0, 1, status));
        children.add(new Property("intent", "code", "Indicates the level of authority/intentionality associated with the care plan and where the care plan fits into the workflow chain.", 0, 1, intent));
        children.add(new Property("category", "CodeableConcept", "Identifies what \"kind\" of plan this is to support differentiation between multiple co-existing plans; e.g. \"Home health\", \"psychiatric\", \"asthma\", \"disease management\", \"wellness plan\", etc.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("title", "string", "Human-friendly name for the care plan.", 0, 1, title));
        children.add(new Property("description", "string", "A description of the scope and nature of the plan.", 0, 1, description));
        children.add(new Property("subject", "Reference(Patient|Group)", "Identifies the patient or group whose intended care is described by the plan.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The Encounter during which this CarePlan was created or to which the creation of this record is tightly associated.", 0, 1, encounter));
        children.add(new Property("period", "Period", "Indicates when the plan did (or is intended to) come into effect and end.", 0, 1, period));
        children.add(new Property("created", "dateTime", "Represents when this particular CarePlan record was created in the system, which is often a system-generated date.", 0, 1, created));
        children.add(new Property("custodian", "Reference(Patient|Practitioner|PractitionerRole|Device|RelatedPerson|Organization|CareTeam)", "When populated, the custodian is responsible for the care plan. The care plan is attributed to the custodian.", 0, 1, custodian));
        children.add(new Property("contributor", "Reference(Patient|Practitioner|PractitionerRole|Device|RelatedPerson|Organization|CareTeam)", "Identifies the individual(s), organization or device who provided the contents of the care plan.", 0, java.lang.Integer.MAX_VALUE, contributor));
        children.add(new Property("careTeam", "Reference(CareTeam)", "Identifies all people and organizations who are expected to be involved in the care envisioned by this plan.", 0, java.lang.Integer.MAX_VALUE, careTeam));
        children.add(new Property("addresses", "CodeableReference(Condition)", "Identifies the conditions/problems/concerns/diagnoses/etc. whose management and/or mitigation are handled by this plan.", 0, java.lang.Integer.MAX_VALUE, addresses));
        children.add(new Property("supportingInfo", "Reference(Any)", "Identifies portions of the patient's record that specifically influenced the formation of the plan.  These might include comorbidities, recent procedures, limitations, recent assessments, etc.", 0, java.lang.Integer.MAX_VALUE, supportingInfo));
        children.add(new Property("goal", "Reference(Goal)", "Describes the intended objective(s) of carrying out the care plan.", 0, java.lang.Integer.MAX_VALUE, goal));
        children.add(new Property("activity", "", "Identifies an action that has occurred or is a planned action to occur as part of the plan. For example, a medication to be used, lab tests to perform, self-monitoring that has occurred, education etc.", 0, java.lang.Integer.MAX_VALUE, activity));
        children.add(new Property("note", "Annotation", "General notes about the care plan not covered elsewhere.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this care plan by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 8911915: /*instantiatesCanonical*/  return new Property("instantiatesCanonical", "canonical(PlanDefinition|Questionnaire|Measure|ActivityDefinition|OperationDefinition)", "The URL pointing to a FHIR-defined protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical);
        case -1926393373: /*instantiatesUri*/  return new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, questionnaire or other definition that is adhered to in whole or in part by this CarePlan.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan)", "A care plan that is fulfilled in whole or in part by this care plan.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -430332865: /*replaces*/  return new Property("replaces", "Reference(CarePlan)", "Completed or terminated care plan whose function is taken by this new care plan.", 0, java.lang.Integer.MAX_VALUE, replaces);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(CarePlan)", "A larger care plan of which this particular care plan is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "Indicates whether the plan is currently being acted upon, represents future intentions or is now a historical record.", 0, 1, status);
        case -1183762788: /*intent*/  return new Property("intent", "code", "Indicates the level of authority/intentionality associated with the care plan and where the care plan fits into the workflow chain.", 0, 1, intent);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Identifies what \"kind\" of plan this is to support differentiation between multiple co-existing plans; e.g. \"Home health\", \"psychiatric\", \"asthma\", \"disease management\", \"wellness plan\", etc.", 0, java.lang.Integer.MAX_VALUE, category);
        case 110371416: /*title*/  return new Property("title", "string", "Human-friendly name for the care plan.", 0, 1, title);
        case -1724546052: /*description*/  return new Property("description", "string", "A description of the scope and nature of the plan.", 0, 1, description);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "Identifies the patient or group whose intended care is described by the plan.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The Encounter during which this CarePlan was created or to which the creation of this record is tightly associated.", 0, 1, encounter);
        case -991726143: /*period*/  return new Property("period", "Period", "Indicates when the plan did (or is intended to) come into effect and end.", 0, 1, period);
        case 1028554472: /*created*/  return new Property("created", "dateTime", "Represents when this particular CarePlan record was created in the system, which is often a system-generated date.", 0, 1, created);
        case 1611297262: /*custodian*/  return new Property("custodian", "Reference(Patient|Practitioner|PractitionerRole|Device|RelatedPerson|Organization|CareTeam)", "When populated, the custodian is responsible for the care plan. The care plan is attributed to the custodian.", 0, 1, custodian);
        case -1895276325: /*contributor*/  return new Property("contributor", "Reference(Patient|Practitioner|PractitionerRole|Device|RelatedPerson|Organization|CareTeam)", "Identifies the individual(s), organization or device who provided the contents of the care plan.", 0, java.lang.Integer.MAX_VALUE, contributor);
        case -7323378: /*careTeam*/  return new Property("careTeam", "Reference(CareTeam)", "Identifies all people and organizations who are expected to be involved in the care envisioned by this plan.", 0, java.lang.Integer.MAX_VALUE, careTeam);
        case 874544034: /*addresses*/  return new Property("addresses", "CodeableReference(Condition)", "Identifies the conditions/problems/concerns/diagnoses/etc. whose management and/or mitigation are handled by this plan.", 0, java.lang.Integer.MAX_VALUE, addresses);
        case 1922406657: /*supportingInfo*/  return new Property("supportingInfo", "Reference(Any)", "Identifies portions of the patient's record that specifically influenced the formation of the plan.  These might include comorbidities, recent procedures, limitations, recent assessments, etc.", 0, java.lang.Integer.MAX_VALUE, supportingInfo);
        case 3178259: /*goal*/  return new Property("goal", "Reference(Goal)", "Describes the intended objective(s) of carrying out the care plan.", 0, java.lang.Integer.MAX_VALUE, goal);
        case -1655966961: /*activity*/  return new Property("activity", "", "Identifies an action that has occurred or is a planned action to occur as part of the plan. For example, a medication to be used, lab tests to perform, self-monitoring that has occurred, education etc.", 0, java.lang.Integer.MAX_VALUE, activity);
        case 3387378: /*note*/  return new Property("note", "Annotation", "General notes about the care plan not covered elsewhere.", 0, java.lang.Integer.MAX_VALUE, note);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 8911915: /*instantiatesCanonical*/ return this.instantiatesCanonical == null ? new Base[0] : this.instantiatesCanonical.toArray(new Base[this.instantiatesCanonical.size()]); // CanonicalType
        case -1926393373: /*instantiatesUri*/ return this.instantiatesUri == null ? new Base[0] : this.instantiatesUri.toArray(new Base[this.instantiatesUri.size()]); // UriType
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -430332865: /*replaces*/ return this.replaces == null ? new Base[0] : this.replaces.toArray(new Base[this.replaces.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<RequestStatus>
        case -1183762788: /*intent*/ return this.intent == null ? new Base[0] : new Base[] {this.intent}; // Enumeration<CarePlanIntent>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 1028554472: /*created*/ return this.created == null ? new Base[0] : new Base[] {this.created}; // DateTimeType
        case 1611297262: /*custodian*/ return this.custodian == null ? new Base[0] : new Base[] {this.custodian}; // Reference
        case -1895276325: /*contributor*/ return this.contributor == null ? new Base[0] : this.contributor.toArray(new Base[this.contributor.size()]); // Reference
        case -7323378: /*careTeam*/ return this.careTeam == null ? new Base[0] : this.careTeam.toArray(new Base[this.careTeam.size()]); // Reference
        case 874544034: /*addresses*/ return this.addresses == null ? new Base[0] : this.addresses.toArray(new Base[this.addresses.size()]); // CodeableReference
        case 1922406657: /*supportingInfo*/ return this.supportingInfo == null ? new Base[0] : this.supportingInfo.toArray(new Base[this.supportingInfo.size()]); // Reference
        case 3178259: /*goal*/ return this.goal == null ? new Base[0] : this.goal.toArray(new Base[this.goal.size()]); // Reference
        case -1655966961: /*activity*/ return this.activity == null ? new Base[0] : this.activity.toArray(new Base[this.activity.size()]); // CarePlanActivityComponent
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 8911915: // instantiatesCanonical
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -1926393373: // instantiatesUri
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -430332865: // replaces
          this.getReplaces().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new RequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<RequestStatus>
          return value;
        case -1183762788: // intent
          value = new CarePlanIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<CarePlanIntent>
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 1028554472: // created
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1611297262: // custodian
          this.custodian = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1895276325: // contributor
          this.getContributor().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -7323378: // careTeam
          this.getCareTeam().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 874544034: // addresses
          this.getAddresses().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 1922406657: // supportingInfo
          this.getSupportingInfo().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3178259: // goal
          this.getGoal().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1655966961: // activity
          this.getActivity().add((CarePlanActivityComponent) value); // CarePlanActivityComponent
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("instantiatesCanonical")) {
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("instantiatesUri")) {
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("replaces")) {
          this.getReplaces().add(TypeConvertor.castToReference(value));
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new RequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<RequestStatus>
        } else if (name.equals("intent")) {
          value = new CarePlanIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<CarePlanIntent>
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("created")) {
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("custodian")) {
          this.custodian = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("contributor")) {
          this.getContributor().add(TypeConvertor.castToReference(value));
        } else if (name.equals("careTeam")) {
          this.getCareTeam().add(TypeConvertor.castToReference(value));
        } else if (name.equals("addresses")) {
          this.getAddresses().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("supportingInfo")) {
          this.getSupportingInfo().add(TypeConvertor.castToReference(value));
        } else if (name.equals("goal")) {
          this.getGoal().add(TypeConvertor.castToReference(value));
        } else if (name.equals("activity")) {
          this.getActivity().add((CarePlanActivityComponent) value);
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 8911915:  return addInstantiatesCanonicalElement();
        case -1926393373:  return addInstantiatesUriElement();
        case -332612366:  return addBasedOn(); 
        case -430332865:  return addReplaces(); 
        case -995410646:  return addPartOf(); 
        case -892481550:  return getStatusElement();
        case -1183762788:  return getIntentElement();
        case 50511102:  return addCategory(); 
        case 110371416:  return getTitleElement();
        case -1724546052:  return getDescriptionElement();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -991726143:  return getPeriod();
        case 1028554472:  return getCreatedElement();
        case 1611297262:  return getCustodian();
        case -1895276325:  return addContributor(); 
        case -7323378:  return addCareTeam(); 
        case 874544034:  return addAddresses(); 
        case 1922406657:  return addSupportingInfo(); 
        case 3178259:  return addGoal(); 
        case -1655966961:  return addActivity(); 
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 8911915: /*instantiatesCanonical*/ return new String[] {"canonical"};
        case -1926393373: /*instantiatesUri*/ return new String[] {"uri"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -430332865: /*replaces*/ return new String[] {"Reference"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1183762788: /*intent*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 1028554472: /*created*/ return new String[] {"dateTime"};
        case 1611297262: /*custodian*/ return new String[] {"Reference"};
        case -1895276325: /*contributor*/ return new String[] {"Reference"};
        case -7323378: /*careTeam*/ return new String[] {"Reference"};
        case 874544034: /*addresses*/ return new String[] {"CodeableReference"};
        case 1922406657: /*supportingInfo*/ return new String[] {"Reference"};
        case 3178259: /*goal*/ return new String[] {"Reference"};
        case -1655966961: /*activity*/ return new String[] {};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("instantiatesCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.instantiatesUri");
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("replaces")) {
          return addReplaces();
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.status");
        }
        else if (name.equals("intent")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.intent");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.description");
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("created")) {
          throw new FHIRException("Cannot call addChild on a primitive type CarePlan.created");
        }
        else if (name.equals("custodian")) {
          this.custodian = new Reference();
          return this.custodian;
        }
        else if (name.equals("contributor")) {
          return addContributor();
        }
        else if (name.equals("careTeam")) {
          return addCareTeam();
        }
        else if (name.equals("addresses")) {
          return addAddresses();
        }
        else if (name.equals("supportingInfo")) {
          return addSupportingInfo();
        }
        else if (name.equals("goal")) {
          return addGoal();
        }
        else if (name.equals("activity")) {
          return addActivity();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CarePlan";

  }

      public CarePlan copy() {
        CarePlan dst = new CarePlan();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CarePlan dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (instantiatesCanonical != null) {
          dst.instantiatesCanonical = new ArrayList<CanonicalType>();
          for (CanonicalType i : instantiatesCanonical)
            dst.instantiatesCanonical.add(i.copy());
        };
        if (instantiatesUri != null) {
          dst.instantiatesUri = new ArrayList<UriType>();
          for (UriType i : instantiatesUri)
            dst.instantiatesUri.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        if (replaces != null) {
          dst.replaces = new ArrayList<Reference>();
          for (Reference i : replaces)
            dst.replaces.add(i.copy());
        };
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.intent = intent == null ? null : intent.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.title = title == null ? null : title.copy();
        dst.description = description == null ? null : description.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.period = period == null ? null : period.copy();
        dst.created = created == null ? null : created.copy();
        dst.custodian = custodian == null ? null : custodian.copy();
        if (contributor != null) {
          dst.contributor = new ArrayList<Reference>();
          for (Reference i : contributor)
            dst.contributor.add(i.copy());
        };
        if (careTeam != null) {
          dst.careTeam = new ArrayList<Reference>();
          for (Reference i : careTeam)
            dst.careTeam.add(i.copy());
        };
        if (addresses != null) {
          dst.addresses = new ArrayList<CodeableReference>();
          for (CodeableReference i : addresses)
            dst.addresses.add(i.copy());
        };
        if (supportingInfo != null) {
          dst.supportingInfo = new ArrayList<Reference>();
          for (Reference i : supportingInfo)
            dst.supportingInfo.add(i.copy());
        };
        if (goal != null) {
          dst.goal = new ArrayList<Reference>();
          for (Reference i : goal)
            dst.goal.add(i.copy());
        };
        if (activity != null) {
          dst.activity = new ArrayList<CarePlanActivityComponent>();
          for (CarePlanActivityComponent i : activity)
            dst.activity.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      protected CarePlan typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CarePlan))
          return false;
        CarePlan o = (CarePlan) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareDeep(instantiatesUri, o.instantiatesUri, true) && compareDeep(basedOn, o.basedOn, true)
           && compareDeep(replaces, o.replaces, true) && compareDeep(partOf, o.partOf, true) && compareDeep(status, o.status, true)
           && compareDeep(intent, o.intent, true) && compareDeep(category, o.category, true) && compareDeep(title, o.title, true)
           && compareDeep(description, o.description, true) && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true)
           && compareDeep(period, o.period, true) && compareDeep(created, o.created, true) && compareDeep(custodian, o.custodian, true)
           && compareDeep(contributor, o.contributor, true) && compareDeep(careTeam, o.careTeam, true) && compareDeep(addresses, o.addresses, true)
           && compareDeep(supportingInfo, o.supportingInfo, true) && compareDeep(goal, o.goal, true) && compareDeep(activity, o.activity, true)
           && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CarePlan))
          return false;
        CarePlan o = (CarePlan) other_;
        return compareValues(instantiatesCanonical, o.instantiatesCanonical, true) && compareValues(instantiatesUri, o.instantiatesUri, true)
           && compareValues(status, o.status, true) && compareValues(intent, o.intent, true) && compareValues(title, o.title, true)
           && compareValues(description, o.description, true) && compareValues(created, o.created, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, instantiatesCanonical
          , instantiatesUri, basedOn, replaces, partOf, status, intent, category, title
          , description, subject, encounter, period, created, custodian, contributor, careTeam
          , addresses, supportingInfo, goal, activity, note);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.CarePlan;
   }


}

