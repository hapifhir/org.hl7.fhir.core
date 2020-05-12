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

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent

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
 * This resource allows for the definition of some activity to be performed, independent of a particular patient, practitioner, or other performance context.
 */
@ResourceDef(name="ActivityDefinition", profile="http://hl7.org/fhir/StructureDefinition/ActivityDefinition")
public class ActivityDefinition extends MetadataResource {

    public enum RequestResourceType {
        /**
         * A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).
         */
        APPOINTMENT, 
        /**
         * A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.
         */
        APPOINTMENTRESPONSE, 
        /**
         * Healthcare plan for patient or group.
         */
        CAREPLAN, 
        /**
         * Claim, Pre-determination or Pre-authorization.
         */
        CLAIM, 
        /**
         * A request for information to be sent to a receiver.
         */
        COMMUNICATIONREQUEST, 
        /**
         * Legal Agreement.
         */
        CONTRACT, 
        /**
         * Medical device request.
         */
        DEVICEREQUEST, 
        /**
         * Enrollment request.
         */
        ENROLLMENTREQUEST, 
        /**
         * Guidance or advice relating to an immunization.
         */
        IMMUNIZATIONRECOMMENDATION, 
        /**
         * Ordering of medication for patient or group.
         */
        MEDICATIONREQUEST, 
        /**
         * Diet, formula or nutritional supplement request.
         */
        NUTRITIONORDER, 
        /**
         * A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.
         */
        SERVICEREQUEST, 
        /**
         * Request for a medication, substance or device.
         */
        SUPPLYREQUEST, 
        /**
         * A task to be performed.
         */
        TASK, 
        /**
         * Prescription for vision correction products for a patient.
         */
        VISIONPRESCRIPTION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static RequestResourceType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Appointment".equals(codeString))
          return APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return APPOINTMENTRESPONSE;
        if ("CarePlan".equals(codeString))
          return CAREPLAN;
        if ("Claim".equals(codeString))
          return CLAIM;
        if ("CommunicationRequest".equals(codeString))
          return COMMUNICATIONREQUEST;
        if ("Contract".equals(codeString))
          return CONTRACT;
        if ("DeviceRequest".equals(codeString))
          return DEVICEREQUEST;
        if ("EnrollmentRequest".equals(codeString))
          return ENROLLMENTREQUEST;
        if ("ImmunizationRecommendation".equals(codeString))
          return IMMUNIZATIONRECOMMENDATION;
        if ("MedicationRequest".equals(codeString))
          return MEDICATIONREQUEST;
        if ("NutritionOrder".equals(codeString))
          return NUTRITIONORDER;
        if ("ServiceRequest".equals(codeString))
          return SERVICEREQUEST;
        if ("SupplyRequest".equals(codeString))
          return SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return TASK;
        if ("VisionPrescription".equals(codeString))
          return VISIONPRESCRIPTION;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown RequestResourceType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case CAREPLAN: return "CarePlan";
            case CLAIM: return "Claim";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case CONTRACT: return "Contract";
            case DEVICEREQUEST: return "DeviceRequest";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case NUTRITIONORDER: return "NutritionOrder";
            case SERVICEREQUEST: return "ServiceRequest";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case APPOINTMENT: return "http://hl7.org/fhir/request-resource-types";
            case APPOINTMENTRESPONSE: return "http://hl7.org/fhir/request-resource-types";
            case CAREPLAN: return "http://hl7.org/fhir/request-resource-types";
            case CLAIM: return "http://hl7.org/fhir/request-resource-types";
            case COMMUNICATIONREQUEST: return "http://hl7.org/fhir/request-resource-types";
            case CONTRACT: return "http://hl7.org/fhir/request-resource-types";
            case DEVICEREQUEST: return "http://hl7.org/fhir/request-resource-types";
            case ENROLLMENTREQUEST: return "http://hl7.org/fhir/request-resource-types";
            case IMMUNIZATIONRECOMMENDATION: return "http://hl7.org/fhir/request-resource-types";
            case MEDICATIONREQUEST: return "http://hl7.org/fhir/request-resource-types";
            case NUTRITIONORDER: return "http://hl7.org/fhir/request-resource-types";
            case SERVICEREQUEST: return "http://hl7.org/fhir/request-resource-types";
            case SUPPLYREQUEST: return "http://hl7.org/fhir/request-resource-types";
            case TASK: return "http://hl7.org/fhir/request-resource-types";
            case VISIONPRESCRIPTION: return "http://hl7.org/fhir/request-resource-types";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case APPOINTMENT: return "A booking of a healthcare event among patient(s), practitioner(s), related person(s) and/or device(s) for a specific date/time. This may result in one or more Encounter(s).";
            case APPOINTMENTRESPONSE: return "A reply to an appointment request for a patient and/or practitioner(s), such as a confirmation or rejection.";
            case CAREPLAN: return "Healthcare plan for patient or group.";
            case CLAIM: return "Claim, Pre-determination or Pre-authorization.";
            case COMMUNICATIONREQUEST: return "A request for information to be sent to a receiver.";
            case CONTRACT: return "Legal Agreement.";
            case DEVICEREQUEST: return "Medical device request.";
            case ENROLLMENTREQUEST: return "Enrollment request.";
            case IMMUNIZATIONRECOMMENDATION: return "Guidance or advice relating to an immunization.";
            case MEDICATIONREQUEST: return "Ordering of medication for patient or group.";
            case NUTRITIONORDER: return "Diet, formula or nutritional supplement request.";
            case SERVICEREQUEST: return "A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.";
            case SUPPLYREQUEST: return "Request for a medication, substance or device.";
            case TASK: return "A task to be performed.";
            case VISIONPRESCRIPTION: return "Prescription for vision correction products for a patient.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case APPOINTMENT: return "Appointment";
            case APPOINTMENTRESPONSE: return "AppointmentResponse";
            case CAREPLAN: return "CarePlan";
            case CLAIM: return "Claim";
            case COMMUNICATIONREQUEST: return "CommunicationRequest";
            case CONTRACT: return "Contract";
            case DEVICEREQUEST: return "DeviceRequest";
            case ENROLLMENTREQUEST: return "EnrollmentRequest";
            case IMMUNIZATIONRECOMMENDATION: return "ImmunizationRecommendation";
            case MEDICATIONREQUEST: return "MedicationRequest";
            case NUTRITIONORDER: return "NutritionOrder";
            case SERVICEREQUEST: return "ServiceRequest";
            case SUPPLYREQUEST: return "SupplyRequest";
            case TASK: return "Task";
            case VISIONPRESCRIPTION: return "VisionPrescription";
            default: return "?";
          }
        }
    }

  public static class RequestResourceTypeEnumFactory implements EnumFactory<RequestResourceType> {
    public RequestResourceType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("Appointment".equals(codeString))
          return RequestResourceType.APPOINTMENT;
        if ("AppointmentResponse".equals(codeString))
          return RequestResourceType.APPOINTMENTRESPONSE;
        if ("CarePlan".equals(codeString))
          return RequestResourceType.CAREPLAN;
        if ("Claim".equals(codeString))
          return RequestResourceType.CLAIM;
        if ("CommunicationRequest".equals(codeString))
          return RequestResourceType.COMMUNICATIONREQUEST;
        if ("Contract".equals(codeString))
          return RequestResourceType.CONTRACT;
        if ("DeviceRequest".equals(codeString))
          return RequestResourceType.DEVICEREQUEST;
        if ("EnrollmentRequest".equals(codeString))
          return RequestResourceType.ENROLLMENTREQUEST;
        if ("ImmunizationRecommendation".equals(codeString))
          return RequestResourceType.IMMUNIZATIONRECOMMENDATION;
        if ("MedicationRequest".equals(codeString))
          return RequestResourceType.MEDICATIONREQUEST;
        if ("NutritionOrder".equals(codeString))
          return RequestResourceType.NUTRITIONORDER;
        if ("ServiceRequest".equals(codeString))
          return RequestResourceType.SERVICEREQUEST;
        if ("SupplyRequest".equals(codeString))
          return RequestResourceType.SUPPLYREQUEST;
        if ("Task".equals(codeString))
          return RequestResourceType.TASK;
        if ("VisionPrescription".equals(codeString))
          return RequestResourceType.VISIONPRESCRIPTION;
        throw new IllegalArgumentException("Unknown RequestResourceType code '"+codeString+"'");
        }
        public Enumeration<RequestResourceType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<RequestResourceType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("Appointment".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.APPOINTMENT);
        if ("AppointmentResponse".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.APPOINTMENTRESPONSE);
        if ("CarePlan".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.CAREPLAN);
        if ("Claim".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.CLAIM);
        if ("CommunicationRequest".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.COMMUNICATIONREQUEST);
        if ("Contract".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.CONTRACT);
        if ("DeviceRequest".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.DEVICEREQUEST);
        if ("EnrollmentRequest".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.ENROLLMENTREQUEST);
        if ("ImmunizationRecommendation".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.IMMUNIZATIONRECOMMENDATION);
        if ("MedicationRequest".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.MEDICATIONREQUEST);
        if ("NutritionOrder".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.NUTRITIONORDER);
        if ("ServiceRequest".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.SERVICEREQUEST);
        if ("SupplyRequest".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.SUPPLYREQUEST);
        if ("Task".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.TASK);
        if ("VisionPrescription".equals(codeString))
          return new Enumeration<RequestResourceType>(this, RequestResourceType.VISIONPRESCRIPTION);
        throw new FHIRException("Unknown RequestResourceType code '"+codeString+"'");
        }
    public String toCode(RequestResourceType code) {
      if (code == RequestResourceType.APPOINTMENT)
        return "Appointment";
      if (code == RequestResourceType.APPOINTMENTRESPONSE)
        return "AppointmentResponse";
      if (code == RequestResourceType.CAREPLAN)
        return "CarePlan";
      if (code == RequestResourceType.CLAIM)
        return "Claim";
      if (code == RequestResourceType.COMMUNICATIONREQUEST)
        return "CommunicationRequest";
      if (code == RequestResourceType.CONTRACT)
        return "Contract";
      if (code == RequestResourceType.DEVICEREQUEST)
        return "DeviceRequest";
      if (code == RequestResourceType.ENROLLMENTREQUEST)
        return "EnrollmentRequest";
      if (code == RequestResourceType.IMMUNIZATIONRECOMMENDATION)
        return "ImmunizationRecommendation";
      if (code == RequestResourceType.MEDICATIONREQUEST)
        return "MedicationRequest";
      if (code == RequestResourceType.NUTRITIONORDER)
        return "NutritionOrder";
      if (code == RequestResourceType.SERVICEREQUEST)
        return "ServiceRequest";
      if (code == RequestResourceType.SUPPLYREQUEST)
        return "SupplyRequest";
      if (code == RequestResourceType.TASK)
        return "Task";
      if (code == RequestResourceType.VISIONPRESCRIPTION)
        return "VisionPrescription";
      return "?";
      }
    public String toSystem(RequestResourceType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ActivityDefinitionParticipantComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of participant in the action.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="patient | practitioner | related-person | device", formalDefinition="The type of participant in the action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-participant-type")
        protected Enumeration<ActionParticipantType> type;

        /**
         * The role the participant should play in performing the described action.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="E.g. Nurse, Surgeon, Parent, etc.", formalDefinition="The role the participant should play in performing the described action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-participant-role")
        protected CodeableConcept role;

        private static final long serialVersionUID = -1152013659L;

    /**
     * Constructor
     */
      public ActivityDefinitionParticipantComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ActivityDefinitionParticipantComponent(ActionParticipantType type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (The type of participant in the action.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<ActionParticipantType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ActivityDefinitionParticipantComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<ActionParticipantType>(new ActionParticipantTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of participant in the action.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public ActivityDefinitionParticipantComponent setTypeElement(Enumeration<ActionParticipantType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of participant in the action.
         */
        public ActionParticipantType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of participant in the action.
         */
        public ActivityDefinitionParticipantComponent setType(ActionParticipantType value) { 
            if (this.type == null)
              this.type = new Enumeration<ActionParticipantType>(new ActionParticipantTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #role} (The role the participant should play in performing the described action.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ActivityDefinitionParticipantComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (The role the participant should play in performing the described action.)
         */
        public ActivityDefinitionParticipantComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "The type of participant in the action.", 0, 1, type));
          children.add(new Property("role", "CodeableConcept", "The role the participant should play in performing the described action.", 0, 1, role));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "The type of participant in the action.", 0, 1, type);
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "The role the participant should play in performing the described action.", 0, 1, role);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<ActionParticipantType>
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new ActionParticipantTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ActionParticipantType>
          return value;
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new ActionParticipantTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ActionParticipantType>
        } else if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case 3506294:  return getRole();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.participant.type");
        }
        else if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else
          return super.addChild(name);
      }

      public ActivityDefinitionParticipantComponent copy() {
        ActivityDefinitionParticipantComponent dst = new ActivityDefinitionParticipantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ActivityDefinitionParticipantComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.role = role == null ? null : role.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ActivityDefinitionParticipantComponent))
          return false;
        ActivityDefinitionParticipantComponent o = (ActivityDefinitionParticipantComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(role, o.role, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ActivityDefinitionParticipantComponent))
          return false;
        ActivityDefinitionParticipantComponent o = (ActivityDefinitionParticipantComponent) other_;
        return compareValues(type, o.type, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, role);
      }

  public String fhirType() {
    return "ActivityDefinition.participant";

  }

  }

    @Block()
    public static class ActivityDefinitionDynamicValueComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolveable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).
         */
        @Child(name = "path", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The path to the element to be set dynamically", formalDefinition="The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolveable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details)." )
        protected StringType path;

        /**
         * An expression specifying the value of the customized element.
         */
        @Child(name = "expression", type = {Expression.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="An expression that provides the dynamic value for the customization", formalDefinition="An expression specifying the value of the customized element." )
        protected Expression expression;

        private static final long serialVersionUID = 1064529082L;

    /**
     * Constructor
     */
      public ActivityDefinitionDynamicValueComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ActivityDefinitionDynamicValueComponent(String path, Expression expression) {
        super();
        this.setPath(path);
        this.setExpression(expression);
      }

        /**
         * @return {@link #path} (The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolveable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public StringType getPathElement() { 
          if (this.path == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ActivityDefinitionDynamicValueComponent.path");
            else if (Configuration.doAutoCreate())
              this.path = new StringType(); // bb
          return this.path;
        }

        public boolean hasPathElement() { 
          return this.path != null && !this.path.isEmpty();
        }

        public boolean hasPath() { 
          return this.path != null && !this.path.isEmpty();
        }

        /**
         * @param value {@link #path} (The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolveable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public ActivityDefinitionDynamicValueComponent setPathElement(StringType value) { 
          this.path = value;
          return this;
        }

        /**
         * @return The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolveable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).
         */
        public String getPath() { 
          return this.path == null ? null : this.path.getValue();
        }

        /**
         * @param value The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolveable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).
         */
        public ActivityDefinitionDynamicValueComponent setPath(String value) { 
            if (this.path == null)
              this.path = new StringType();
            this.path.setValue(value);
          return this;
        }

        /**
         * @return {@link #expression} (An expression specifying the value of the customized element.)
         */
        public Expression getExpression() { 
          if (this.expression == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ActivityDefinitionDynamicValueComponent.expression");
            else if (Configuration.doAutoCreate())
              this.expression = new Expression(); // cc
          return this.expression;
        }

        public boolean hasExpression() { 
          return this.expression != null && !this.expression.isEmpty();
        }

        /**
         * @param value {@link #expression} (An expression specifying the value of the customized element.)
         */
        public ActivityDefinitionDynamicValueComponent setExpression(Expression value) { 
          this.expression = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("path", "string", "The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolveable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).", 0, 1, path));
          children.add(new Property("expression", "Expression", "An expression specifying the value of the customized element.", 0, 1, expression));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3433509: /*path*/  return new Property("path", "string", "The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolveable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).", 0, 1, path);
          case -1795452264: /*expression*/  return new Property("expression", "Expression", "An expression specifying the value of the customized element.", 0, 1, expression);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        case -1795452264: /*expression*/ return this.expression == null ? new Base[0] : new Base[] {this.expression}; // Expression
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        case -1795452264: // expression
          this.expression = TypeConvertor.castToExpression(value); // Expression
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("expression")) {
          this.expression = TypeConvertor.castToExpression(value); // Expression
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509:  return getPathElement();
        case -1795452264:  return getExpression();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return new String[] {"string"};
        case -1795452264: /*expression*/ return new String[] {"Expression"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.dynamicValue.path");
        }
        else if (name.equals("expression")) {
          this.expression = new Expression();
          return this.expression;
        }
        else
          return super.addChild(name);
      }

      public ActivityDefinitionDynamicValueComponent copy() {
        ActivityDefinitionDynamicValueComponent dst = new ActivityDefinitionDynamicValueComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ActivityDefinitionDynamicValueComponent dst) {
        super.copyValues(dst);
        dst.path = path == null ? null : path.copy();
        dst.expression = expression == null ? null : expression.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ActivityDefinitionDynamicValueComponent))
          return false;
        ActivityDefinitionDynamicValueComponent o = (ActivityDefinitionDynamicValueComponent) other_;
        return compareDeep(path, o.path, true) && compareDeep(expression, o.expression, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ActivityDefinitionDynamicValueComponent))
          return false;
        ActivityDefinitionDynamicValueComponent o = (ActivityDefinitionDynamicValueComponent) other_;
        return compareValues(path, o.path, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(path, expression);
      }

  public String fhirType() {
    return "ActivityDefinition.dynamicValue";

  }

  }

    /**
     * An absolute URI that is used to identify this activity definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this activity definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the activity definition is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this activity definition, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this activity definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this activity definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the activity definition is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this activity definition when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the activity definition", formalDefinition="A formal identifier that is used to identify this activity definition when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the activity definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the activity definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active assets.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the activity definition", formalDefinition="The identifier that is used to identify this version of the activity definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the activity definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active assets." )
    protected StringType version;

    /**
     * A natural language name identifying the activity definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this activity definition (computer friendly)", formalDefinition="A natural language name identifying the activity definition. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the activity definition.
     */
    @Child(name = "title", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this activity definition (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the activity definition." )
    protected StringType title;

    /**
     * An explanatory or alternate title for the activity definition giving additional information about its content.
     */
    @Child(name = "subtitle", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Subordinate title of the activity definition", formalDefinition="An explanatory or alternate title for the activity definition giving additional information about its content." )
    protected StringType subtitle;

    /**
     * The status of this activity definition. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this activity definition. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this activity definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this activity definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * A code or group definition that describes the intended subject of the activity being defined.
     */
    @Child(name = "subject", type = {CodeableConcept.class, Group.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Type of individual the activity definition is intended for", formalDefinition="A code or group definition that describes the intended subject of the activity being defined." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subject-type")
    protected DataType subject;

    /**
     * The date  (and optionally time) when the activity definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the activity definition changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the activity definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the activity definition changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual that published the activity definition.
     */
    @Child(name = "publisher", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher (organization or individual)", formalDefinition="The name of the organization or individual that published the activity definition." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the activity definition from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Natural language description of the activity definition", formalDefinition="A free text natural language description of the activity definition from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate activity definition instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate activity definition instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the activity definition is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for activity definition (if applicable)", formalDefinition="A legal or geographic region in which the activity definition is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this activity definition is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this activity definition is defined", formalDefinition="Explanation of why this activity definition is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A detailed description of how the activity definition is used from a clinical perspective.
     */
    @Child(name = "usage", type = {StringType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Describes the clinical usage of the activity definition", formalDefinition="A detailed description of how the activity definition is used from a clinical perspective." )
    protected StringType usage;

    /**
     * A copyright statement relating to the activity definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the activity definition.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the activity definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the activity definition." )
    protected MarkdownType copyright;

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the activity definition was approved by publisher", formalDefinition="The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the activity definition was last reviewed", formalDefinition="The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the activity definition content was or is planned to be in active use.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=20, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the activity definition is expected to be used", formalDefinition="The period during which the activity definition content was or is planned to be in active use." )
    protected Period effectivePeriod;

    /**
     * Descriptive topics related to the content of the activity. Topics provide a high-level categorization of the activity that can be useful for filtering and searching.
     */
    @Child(name = "topic", type = {CodeableConcept.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="E.g. Education, Treatment, Assessment, etc.", formalDefinition="Descriptive topics related to the content of the activity. Topics provide a high-level categorization of the activity that can be useful for filtering and searching." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/definition-topic")
    protected List<CodeableConcept> topic;

    /**
     * An individiual or organization primarily involved in the creation and maintenance of the content.
     */
    @Child(name = "author", type = {ContactDetail.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who authored the content", formalDefinition="An individiual or organization primarily involved in the creation and maintenance of the content." )
    protected List<ContactDetail> author;

    /**
     * An individual or organization primarily responsible for internal coherence of the content.
     */
    @Child(name = "editor", type = {ContactDetail.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who edited the content", formalDefinition="An individual or organization primarily responsible for internal coherence of the content." )
    protected List<ContactDetail> editor;

    /**
     * An individual or organization primarily responsible for review of some aspect of the content.
     */
    @Child(name = "reviewer", type = {ContactDetail.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who reviewed the content", formalDefinition="An individual or organization primarily responsible for review of some aspect of the content." )
    protected List<ContactDetail> reviewer;

    /**
     * An individual or organization responsible for officially endorsing the content for use in some setting.
     */
    @Child(name = "endorser", type = {ContactDetail.class}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who endorsed the content", formalDefinition="An individual or organization responsible for officially endorsing the content for use in some setting." )
    protected List<ContactDetail> endorser;

    /**
     * Related artifacts such as additional documentation, justification, or bibliographic references.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional documentation, citations, etc.", formalDefinition="Related artifacts such as additional documentation, justification, or bibliographic references." )
    protected List<RelatedArtifact> relatedArtifact;

    /**
     * A reference to a Library resource containing any formal logic used by the activity definition.
     */
    @Child(name = "library", type = {CanonicalType.class}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Logic used by the activity definition", formalDefinition="A reference to a Library resource containing any formal logic used by the activity definition." )
    protected List<CanonicalType> library;

    /**
     * A description of the kind of resource the activity definition is representing. For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest. Typically, but not always, this is a Request resource.
     */
    @Child(name = "kind", type = {CodeType.class}, order=28, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Kind of resource", formalDefinition="A description of the kind of resource the activity definition is representing. For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest. Typically, but not always, this is a Request resource." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-resource-types")
    protected Enumeration<RequestResourceType> kind;

    /**
     * A profile to which the target of the activity definition is expected to conform.
     */
    @Child(name = "profile", type = {CanonicalType.class}, order=29, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="What profile the resource needs to conform to", formalDefinition="A profile to which the target of the activity definition is expected to conform." )
    protected CanonicalType profile;

    /**
     * Detailed description of the type of activity; e.g. What lab test, what procedure, what kind of encounter.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=30, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Detail type of activity", formalDefinition="Detailed description of the type of activity; e.g. What lab test, what procedure, what kind of encounter." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-code")
    protected CodeableConcept code;

    /**
     * Indicates the level of authority/intentionality associated with the activity and where the request should fit into the workflow chain.
     */
    @Child(name = "intent", type = {CodeType.class}, order=31, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="proposal | plan | directive | order | original-order | reflex-order | filler-order | instance-order | option", formalDefinition="Indicates the level of authority/intentionality associated with the activity and where the request should fit into the workflow chain." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-intent")
    protected Enumeration<RequestIntent> intent;

    /**
     * Indicates how quickly the activity  should be addressed with respect to other requests.
     */
    @Child(name = "priority", type = {CodeType.class}, order=32, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="routine | urgent | asap | stat", formalDefinition="Indicates how quickly the activity  should be addressed with respect to other requests." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-priority")
    protected Enumeration<RequestPriority> priority;

    /**
     * Set this to true if the definition is to indicate that a particular activity should NOT be performed. If true, this element should be interpreted to reinforce a negative coding. For example NPO as a code with a doNotPerform of true would still indicate to NOT perform the action.
     */
    @Child(name = "doNotPerform", type = {BooleanType.class}, order=33, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="True if the activity should not be performed", formalDefinition="Set this to true if the definition is to indicate that a particular activity should NOT be performed. If true, this element should be interpreted to reinforce a negative coding. For example NPO as a code with a doNotPerform of true would still indicate to NOT perform the action." )
    protected BooleanType doNotPerform;

    /**
     * The period, timing or frequency upon which the described activity is to occur.
     */
    @Child(name = "timing", type = {Timing.class, DateTimeType.class, Age.class, Period.class, Range.class, Duration.class}, order=34, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When activity is to occur", formalDefinition="The period, timing or frequency upon which the described activity is to occur." )
    protected DataType timing;

    /**
     * Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc.
     */
    @Child(name = "location", type = {Location.class}, order=35, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Where it should happen", formalDefinition="Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc." )
    protected Reference location;

    /**
     * Indicates who should participate in performing the action described.
     */
    @Child(name = "participant", type = {}, order=36, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who should participate in the action", formalDefinition="Indicates who should participate in performing the action described." )
    protected List<ActivityDefinitionParticipantComponent> participant;

    /**
     * Identifies the food, drug or other product being consumed or supplied in the activity.
     */
    @Child(name = "product", type = {Medication.class, Substance.class, CodeableConcept.class}, order=37, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="What's administered/supplied", formalDefinition="Identifies the food, drug or other product being consumed or supplied in the activity." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-codes")
    protected DataType product;

    /**
     * Identifies the quantity expected to be consumed at once (per dose, per meal, etc.).
     */
    @Child(name = "quantity", type = {Quantity.class}, order=38, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="How much is administered/consumed/supplied", formalDefinition="Identifies the quantity expected to be consumed at once (per dose, per meal, etc.)." )
    protected Quantity quantity;

    /**
     * Provides detailed dosage instructions in the same way that they are described for MedicationRequest resources.
     */
    @Child(name = "dosage", type = {Dosage.class}, order=39, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Detailed dosage instructions", formalDefinition="Provides detailed dosage instructions in the same way that they are described for MedicationRequest resources." )
    protected List<Dosage> dosage;

    /**
     * Indicates the sites on the subject's body where the procedure should be performed (I.e. the target sites).
     */
    @Child(name = "bodySite", type = {CodeableConcept.class}, order=40, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What part of body to perform on", formalDefinition="Indicates the sites on the subject's body where the procedure should be performed (I.e. the target sites)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected List<CodeableConcept> bodySite;

    /**
     * Defines specimen requirements for the action to be performed, such as required specimens for a lab test.
     */
    @Child(name = "specimenRequirement", type = {SpecimenDefinition.class}, order=41, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What specimens are required to perform this action", formalDefinition="Defines specimen requirements for the action to be performed, such as required specimens for a lab test." )
    protected List<Reference> specimenRequirement;

    /**
     * Defines observation requirements for the action to be performed, such as body weight or surface area.
     */
    @Child(name = "observationRequirement", type = {ObservationDefinition.class}, order=42, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What observations are required to perform this action", formalDefinition="Defines observation requirements for the action to be performed, such as body weight or surface area." )
    protected List<Reference> observationRequirement;

    /**
     * Defines the observations that are expected to be produced by the action.
     */
    @Child(name = "observationResultRequirement", type = {ObservationDefinition.class}, order=43, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What observations must be produced by this action", formalDefinition="Defines the observations that are expected to be produced by the action." )
    protected List<Reference> observationResultRequirement;

    /**
     * A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.
     */
    @Child(name = "transform", type = {CanonicalType.class}, order=44, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Transform to apply the template", formalDefinition="A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input." )
    protected CanonicalType transform;

    /**
     * Dynamic values that will be evaluated to produce values for elements of the resulting resource. For example, if the dosage of a medication must be computed based on the patient's weight, a dynamic value would be used to specify an expression that calculated the weight, and the path on the request resource that would contain the result.
     */
    @Child(name = "dynamicValue", type = {}, order=45, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Dynamic aspects of the definition", formalDefinition="Dynamic values that will be evaluated to produce values for elements of the resulting resource. For example, if the dosage of a medication must be computed based on the patient's weight, a dynamic value would be used to specify an expression that calculated the weight, and the path on the request resource that would contain the result." )
    protected List<ActivityDefinitionDynamicValueComponent> dynamicValue;

    private static final long serialVersionUID = 1615489416L;

  /**
   * Constructor
   */
    public ActivityDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public ActivityDefinition(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this activity definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this activity definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the activity definition is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.url");
        else if (Configuration.doAutoCreate())
          this.url = new UriType(); // bb
      return this.url;
    }

    public boolean hasUrlElement() { 
      return this.url != null && !this.url.isEmpty();
    }

    public boolean hasUrl() { 
      return this.url != null && !this.url.isEmpty();
    }

    /**
     * @param value {@link #url} (An absolute URI that is used to identify this activity definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this activity definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the activity definition is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public ActivityDefinition setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this activity definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this activity definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the activity definition is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this activity definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this activity definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the activity definition is stored on different servers.
     */
    public ActivityDefinition setUrl(String value) { 
      if (Utilities.noString(value))
        this.url = null;
      else {
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this activity definition when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setIdentifier(List<Identifier> theIdentifier) { 
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

    public ActivityDefinition addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the activity definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the activity definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active assets.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.version");
        else if (Configuration.doAutoCreate())
          this.version = new StringType(); // bb
      return this.version;
    }

    public boolean hasVersionElement() { 
      return this.version != null && !this.version.isEmpty();
    }

    public boolean hasVersion() { 
      return this.version != null && !this.version.isEmpty();
    }

    /**
     * @param value {@link #version} (The identifier that is used to identify this version of the activity definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the activity definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active assets.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public ActivityDefinition setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the activity definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the activity definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active assets.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the activity definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the activity definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active assets.
     */
    public ActivityDefinition setVersion(String value) { 
      if (Utilities.noString(value))
        this.version = null;
      else {
        if (this.version == null)
          this.version = new StringType();
        this.version.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #name} (A natural language name identifying the activity definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.name");
        else if (Configuration.doAutoCreate())
          this.name = new StringType(); // bb
      return this.name;
    }

    public boolean hasNameElement() { 
      return this.name != null && !this.name.isEmpty();
    }

    public boolean hasName() { 
      return this.name != null && !this.name.isEmpty();
    }

    /**
     * @param value {@link #name} (A natural language name identifying the activity definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public ActivityDefinition setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the activity definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the activity definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public ActivityDefinition setName(String value) { 
      if (Utilities.noString(value))
        this.name = null;
      else {
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the activity definition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the activity definition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public ActivityDefinition setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the activity definition.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the activity definition.
     */
    public ActivityDefinition setTitle(String value) { 
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
     * @return {@link #subtitle} (An explanatory or alternate title for the activity definition giving additional information about its content.). This is the underlying object with id, value and extensions. The accessor "getSubtitle" gives direct access to the value
     */
    public StringType getSubtitleElement() { 
      if (this.subtitle == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.subtitle");
        else if (Configuration.doAutoCreate())
          this.subtitle = new StringType(); // bb
      return this.subtitle;
    }

    public boolean hasSubtitleElement() { 
      return this.subtitle != null && !this.subtitle.isEmpty();
    }

    public boolean hasSubtitle() { 
      return this.subtitle != null && !this.subtitle.isEmpty();
    }

    /**
     * @param value {@link #subtitle} (An explanatory or alternate title for the activity definition giving additional information about its content.). This is the underlying object with id, value and extensions. The accessor "getSubtitle" gives direct access to the value
     */
    public ActivityDefinition setSubtitleElement(StringType value) { 
      this.subtitle = value;
      return this;
    }

    /**
     * @return An explanatory or alternate title for the activity definition giving additional information about its content.
     */
    public String getSubtitle() { 
      return this.subtitle == null ? null : this.subtitle.getValue();
    }

    /**
     * @param value An explanatory or alternate title for the activity definition giving additional information about its content.
     */
    public ActivityDefinition setSubtitle(String value) { 
      if (Utilities.noString(value))
        this.subtitle = null;
      else {
        if (this.subtitle == null)
          this.subtitle = new StringType();
        this.subtitle.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #status} (The status of this activity definition. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of this activity definition. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ActivityDefinition setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this activity definition. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this activity definition. Enables tracking the life-cycle of the content.
     */
    public ActivityDefinition setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this activity definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.experimental");
        else if (Configuration.doAutoCreate())
          this.experimental = new BooleanType(); // bb
      return this.experimental;
    }

    public boolean hasExperimentalElement() { 
      return this.experimental != null && !this.experimental.isEmpty();
    }

    public boolean hasExperimental() { 
      return this.experimental != null && !this.experimental.isEmpty();
    }

    /**
     * @param value {@link #experimental} (A Boolean value to indicate that this activity definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public ActivityDefinition setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this activity definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this activity definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public ActivityDefinition setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #subject} (A code or group definition that describes the intended subject of the activity being defined.)
     */
    public DataType getSubject() { 
      return this.subject;
    }

    /**
     * @return {@link #subject} (A code or group definition that describes the intended subject of the activity being defined.)
     */
    public CodeableConcept getSubjectCodeableConcept() throws FHIRException { 
      if (this.subject == null)
        this.subject = new CodeableConcept();
      if (!(this.subject instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.subject.getClass().getName()+" was encountered");
      return (CodeableConcept) this.subject;
    }

    public boolean hasSubjectCodeableConcept() { 
      return this != null && this.subject instanceof CodeableConcept;
    }

    /**
     * @return {@link #subject} (A code or group definition that describes the intended subject of the activity being defined.)
     */
    public Reference getSubjectReference() throws FHIRException { 
      if (this.subject == null)
        this.subject = new Reference();
      if (!(this.subject instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.subject.getClass().getName()+" was encountered");
      return (Reference) this.subject;
    }

    public boolean hasSubjectReference() { 
      return this != null && this.subject instanceof Reference;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (A code or group definition that describes the intended subject of the activity being defined.)
     */
    public ActivityDefinition setSubject(DataType value) { 
      if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
        throw new Error("Not the right type for ActivityDefinition.subject[x]: "+value.fhirType());
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the activity definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the activity definition changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.date");
        else if (Configuration.doAutoCreate())
          this.date = new DateTimeType(); // bb
      return this.date;
    }

    public boolean hasDateElement() { 
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() { 
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (The date  (and optionally time) when the activity definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the activity definition changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public ActivityDefinition setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the activity definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the activity definition changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the activity definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the activity definition changes.
     */
    public ActivityDefinition setDate(Date value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #publisher} (The name of the organization or individual that published the activity definition.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.publisher");
        else if (Configuration.doAutoCreate())
          this.publisher = new StringType(); // bb
      return this.publisher;
    }

    public boolean hasPublisherElement() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    public boolean hasPublisher() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    /**
     * @param value {@link #publisher} (The name of the organization or individual that published the activity definition.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public ActivityDefinition setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual that published the activity definition.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual that published the activity definition.
     */
    public ActivityDefinition setPublisher(String value) { 
      if (Utilities.noString(value))
        this.publisher = null;
      else {
        if (this.publisher == null)
          this.publisher = new StringType();
        this.publisher.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public List<ContactDetail> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setContact(List<ContactDetail> theContact) { 
      this.contact = theContact;
      return this;
    }

    public boolean hasContact() { 
      if (this.contact == null)
        return false;
      for (ContactDetail item : this.contact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addContact() { //3
      ContactDetail t = new ContactDetail();
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return t;
    }

    public ActivityDefinition addContact(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ContactDetail getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #description} (A free text natural language description of the activity definition from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.description");
        else if (Configuration.doAutoCreate())
          this.description = new MarkdownType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (A free text natural language description of the activity definition from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public ActivityDefinition setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the activity definition from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the activity definition from a consumer's perspective.
     */
    public ActivityDefinition setDescription(String value) { 
      if (value == null)
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate activity definition instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setUseContext(List<UsageContext> theUseContext) { 
      this.useContext = theUseContext;
      return this;
    }

    public boolean hasUseContext() { 
      if (this.useContext == null)
        return false;
      for (UsageContext item : this.useContext)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public UsageContext addUseContext() { //3
      UsageContext t = new UsageContext();
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return t;
    }

    public ActivityDefinition addUseContext(UsageContext t) { //3
      if (t == null)
        return this;
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist {3}
     */
    public UsageContext getUseContextFirstRep() { 
      if (getUseContext().isEmpty()) {
        addUseContext();
      }
      return getUseContext().get(0);
    }

    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the activity definition is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setJurisdiction(List<CodeableConcept> theJurisdiction) { 
      this.jurisdiction = theJurisdiction;
      return this;
    }

    public boolean hasJurisdiction() { 
      if (this.jurisdiction == null)
        return false;
      for (CodeableConcept item : this.jurisdiction)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addJurisdiction() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return t;
    }

    public ActivityDefinition addJurisdiction(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {3}
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      if (getJurisdiction().isEmpty()) {
        addJurisdiction();
      }
      return getJurisdiction().get(0);
    }

    /**
     * @return {@link #purpose} (Explanation of why this activity definition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.purpose");
        else if (Configuration.doAutoCreate())
          this.purpose = new MarkdownType(); // bb
      return this.purpose;
    }

    public boolean hasPurposeElement() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    public boolean hasPurpose() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    /**
     * @param value {@link #purpose} (Explanation of why this activity definition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public ActivityDefinition setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this activity definition is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this activity definition is needed and why it has been designed as it has.
     */
    public ActivityDefinition setPurpose(String value) { 
      if (value == null)
        this.purpose = null;
      else {
        if (this.purpose == null)
          this.purpose = new MarkdownType();
        this.purpose.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #usage} (A detailed description of how the activity definition is used from a clinical perspective.). This is the underlying object with id, value and extensions. The accessor "getUsage" gives direct access to the value
     */
    public StringType getUsageElement() { 
      if (this.usage == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.usage");
        else if (Configuration.doAutoCreate())
          this.usage = new StringType(); // bb
      return this.usage;
    }

    public boolean hasUsageElement() { 
      return this.usage != null && !this.usage.isEmpty();
    }

    public boolean hasUsage() { 
      return this.usage != null && !this.usage.isEmpty();
    }

    /**
     * @param value {@link #usage} (A detailed description of how the activity definition is used from a clinical perspective.). This is the underlying object with id, value and extensions. The accessor "getUsage" gives direct access to the value
     */
    public ActivityDefinition setUsageElement(StringType value) { 
      this.usage = value;
      return this;
    }

    /**
     * @return A detailed description of how the activity definition is used from a clinical perspective.
     */
    public String getUsage() { 
      return this.usage == null ? null : this.usage.getValue();
    }

    /**
     * @param value A detailed description of how the activity definition is used from a clinical perspective.
     */
    public ActivityDefinition setUsage(String value) { 
      if (Utilities.noString(value))
        this.usage = null;
      else {
        if (this.usage == null)
          this.usage = new StringType();
        this.usage.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (A copyright statement relating to the activity definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the activity definition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.copyright");
        else if (Configuration.doAutoCreate())
          this.copyright = new MarkdownType(); // bb
      return this.copyright;
    }

    public boolean hasCopyrightElement() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    public boolean hasCopyright() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    /**
     * @param value {@link #copyright} (A copyright statement relating to the activity definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the activity definition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public ActivityDefinition setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the activity definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the activity definition.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the activity definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the activity definition.
     */
    public ActivityDefinition setCopyright(String value) { 
      if (value == null)
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.approvalDate");
        else if (Configuration.doAutoCreate())
          this.approvalDate = new DateType(); // bb
      return this.approvalDate;
    }

    public boolean hasApprovalDateElement() { 
      return this.approvalDate != null && !this.approvalDate.isEmpty();
    }

    public boolean hasApprovalDate() { 
      return this.approvalDate != null && !this.approvalDate.isEmpty();
    }

    /**
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public ActivityDefinition setApprovalDateElement(DateType value) { 
      this.approvalDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Date getApprovalDate() { 
      return this.approvalDate == null ? null : this.approvalDate.getValue();
    }

    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public ActivityDefinition setApprovalDate(Date value) { 
      if (value == null)
        this.approvalDate = null;
      else {
        if (this.approvalDate == null)
          this.approvalDate = new DateType();
        this.approvalDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      if (this.lastReviewDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.lastReviewDate");
        else if (Configuration.doAutoCreate())
          this.lastReviewDate = new DateType(); // bb
      return this.lastReviewDate;
    }

    public boolean hasLastReviewDateElement() { 
      return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
    }

    public boolean hasLastReviewDate() { 
      return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
    }

    /**
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public ActivityDefinition setLastReviewDateElement(DateType value) { 
      this.lastReviewDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public Date getLastReviewDate() { 
      return this.lastReviewDate == null ? null : this.lastReviewDate.getValue();
    }

    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public ActivityDefinition setLastReviewDate(Date value) { 
      if (value == null)
        this.lastReviewDate = null;
      else {
        if (this.lastReviewDate == null)
          this.lastReviewDate = new DateType();
        this.lastReviewDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #effectivePeriod} (The period during which the activity definition content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the activity definition content was or is planned to be in active use.)
     */
    public ActivityDefinition setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #topic} (Descriptive topics related to the content of the activity. Topics provide a high-level categorization of the activity that can be useful for filtering and searching.)
     */
    public List<CodeableConcept> getTopic() { 
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      return this.topic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setTopic(List<CodeableConcept> theTopic) { 
      this.topic = theTopic;
      return this;
    }

    public boolean hasTopic() { 
      if (this.topic == null)
        return false;
      for (CodeableConcept item : this.topic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addTopic() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      this.topic.add(t);
      return t;
    }

    public ActivityDefinition addTopic(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      this.topic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #topic}, creating it if it does not already exist {3}
     */
    public CodeableConcept getTopicFirstRep() { 
      if (getTopic().isEmpty()) {
        addTopic();
      }
      return getTopic().get(0);
    }

    /**
     * @return {@link #author} (An individiual or organization primarily involved in the creation and maintenance of the content.)
     */
    public List<ContactDetail> getAuthor() { 
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      return this.author;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setAuthor(List<ContactDetail> theAuthor) { 
      this.author = theAuthor;
      return this;
    }

    public boolean hasAuthor() { 
      if (this.author == null)
        return false;
      for (ContactDetail item : this.author)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addAuthor() { //3
      ContactDetail t = new ContactDetail();
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      this.author.add(t);
      return t;
    }

    public ActivityDefinition addAuthor(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      this.author.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist {3}
     */
    public ContactDetail getAuthorFirstRep() { 
      if (getAuthor().isEmpty()) {
        addAuthor();
      }
      return getAuthor().get(0);
    }

    /**
     * @return {@link #editor} (An individual or organization primarily responsible for internal coherence of the content.)
     */
    public List<ContactDetail> getEditor() { 
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      return this.editor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setEditor(List<ContactDetail> theEditor) { 
      this.editor = theEditor;
      return this;
    }

    public boolean hasEditor() { 
      if (this.editor == null)
        return false;
      for (ContactDetail item : this.editor)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addEditor() { //3
      ContactDetail t = new ContactDetail();
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      this.editor.add(t);
      return t;
    }

    public ActivityDefinition addEditor(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      this.editor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #editor}, creating it if it does not already exist {3}
     */
    public ContactDetail getEditorFirstRep() { 
      if (getEditor().isEmpty()) {
        addEditor();
      }
      return getEditor().get(0);
    }

    /**
     * @return {@link #reviewer} (An individual or organization primarily responsible for review of some aspect of the content.)
     */
    public List<ContactDetail> getReviewer() { 
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      return this.reviewer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setReviewer(List<ContactDetail> theReviewer) { 
      this.reviewer = theReviewer;
      return this;
    }

    public boolean hasReviewer() { 
      if (this.reviewer == null)
        return false;
      for (ContactDetail item : this.reviewer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addReviewer() { //3
      ContactDetail t = new ContactDetail();
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      this.reviewer.add(t);
      return t;
    }

    public ActivityDefinition addReviewer(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      this.reviewer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reviewer}, creating it if it does not already exist {3}
     */
    public ContactDetail getReviewerFirstRep() { 
      if (getReviewer().isEmpty()) {
        addReviewer();
      }
      return getReviewer().get(0);
    }

    /**
     * @return {@link #endorser} (An individual or organization responsible for officially endorsing the content for use in some setting.)
     */
    public List<ContactDetail> getEndorser() { 
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      return this.endorser;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setEndorser(List<ContactDetail> theEndorser) { 
      this.endorser = theEndorser;
      return this;
    }

    public boolean hasEndorser() { 
      if (this.endorser == null)
        return false;
      for (ContactDetail item : this.endorser)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addEndorser() { //3
      ContactDetail t = new ContactDetail();
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      this.endorser.add(t);
      return t;
    }

    public ActivityDefinition addEndorser(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      this.endorser.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #endorser}, creating it if it does not already exist {3}
     */
    public ContactDetail getEndorserFirstRep() { 
      if (getEndorser().isEmpty()) {
        addEndorser();
      }
      return getEndorser().get(0);
    }

    /**
     * @return {@link #relatedArtifact} (Related artifacts such as additional documentation, justification, or bibliographic references.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      return this.relatedArtifact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
      this.relatedArtifact = theRelatedArtifact;
      return this;
    }

    public boolean hasRelatedArtifact() { 
      if (this.relatedArtifact == null)
        return false;
      for (RelatedArtifact item : this.relatedArtifact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RelatedArtifact addRelatedArtifact() { //3
      RelatedArtifact t = new RelatedArtifact();
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return t;
    }

    public ActivityDefinition addRelatedArtifact(RelatedArtifact t) { //3
      if (t == null)
        return this;
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {3}
     */
    public RelatedArtifact getRelatedArtifactFirstRep() { 
      if (getRelatedArtifact().isEmpty()) {
        addRelatedArtifact();
      }
      return getRelatedArtifact().get(0);
    }

    /**
     * @return {@link #library} (A reference to a Library resource containing any formal logic used by the activity definition.)
     */
    public List<CanonicalType> getLibrary() { 
      if (this.library == null)
        this.library = new ArrayList<CanonicalType>();
      return this.library;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setLibrary(List<CanonicalType> theLibrary) { 
      this.library = theLibrary;
      return this;
    }

    public boolean hasLibrary() { 
      if (this.library == null)
        return false;
      for (CanonicalType item : this.library)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #library} (A reference to a Library resource containing any formal logic used by the activity definition.)
     */
    public CanonicalType addLibraryElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.library == null)
        this.library = new ArrayList<CanonicalType>();
      this.library.add(t);
      return t;
    }

    /**
     * @param value {@link #library} (A reference to a Library resource containing any formal logic used by the activity definition.)
     */
    public ActivityDefinition addLibrary(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.library == null)
        this.library = new ArrayList<CanonicalType>();
      this.library.add(t);
      return this;
    }

    /**
     * @param value {@link #library} (A reference to a Library resource containing any formal logic used by the activity definition.)
     */
    public boolean hasLibrary(String value) { 
      if (this.library == null)
        return false;
      for (CanonicalType v : this.library)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #kind} (A description of the kind of resource the activity definition is representing. For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest. Typically, but not always, this is a Request resource.). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public Enumeration<RequestResourceType> getKindElement() { 
      if (this.kind == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.kind");
        else if (Configuration.doAutoCreate())
          this.kind = new Enumeration<RequestResourceType>(new RequestResourceTypeEnumFactory()); // bb
      return this.kind;
    }

    public boolean hasKindElement() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    public boolean hasKind() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    /**
     * @param value {@link #kind} (A description of the kind of resource the activity definition is representing. For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest. Typically, but not always, this is a Request resource.). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public ActivityDefinition setKindElement(Enumeration<RequestResourceType> value) { 
      this.kind = value;
      return this;
    }

    /**
     * @return A description of the kind of resource the activity definition is representing. For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest. Typically, but not always, this is a Request resource.
     */
    public RequestResourceType getKind() { 
      return this.kind == null ? null : this.kind.getValue();
    }

    /**
     * @param value A description of the kind of resource the activity definition is representing. For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest. Typically, but not always, this is a Request resource.
     */
    public ActivityDefinition setKind(RequestResourceType value) { 
      if (value == null)
        this.kind = null;
      else {
        if (this.kind == null)
          this.kind = new Enumeration<RequestResourceType>(new RequestResourceTypeEnumFactory());
        this.kind.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #profile} (A profile to which the target of the activity definition is expected to conform.). This is the underlying object with id, value and extensions. The accessor "getProfile" gives direct access to the value
     */
    public CanonicalType getProfileElement() { 
      if (this.profile == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.profile");
        else if (Configuration.doAutoCreate())
          this.profile = new CanonicalType(); // bb
      return this.profile;
    }

    public boolean hasProfileElement() { 
      return this.profile != null && !this.profile.isEmpty();
    }

    public boolean hasProfile() { 
      return this.profile != null && !this.profile.isEmpty();
    }

    /**
     * @param value {@link #profile} (A profile to which the target of the activity definition is expected to conform.). This is the underlying object with id, value and extensions. The accessor "getProfile" gives direct access to the value
     */
    public ActivityDefinition setProfileElement(CanonicalType value) { 
      this.profile = value;
      return this;
    }

    /**
     * @return A profile to which the target of the activity definition is expected to conform.
     */
    public String getProfile() { 
      return this.profile == null ? null : this.profile.getValue();
    }

    /**
     * @param value A profile to which the target of the activity definition is expected to conform.
     */
    public ActivityDefinition setProfile(String value) { 
      if (Utilities.noString(value))
        this.profile = null;
      else {
        if (this.profile == null)
          this.profile = new CanonicalType();
        this.profile.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #code} (Detailed description of the type of activity; e.g. What lab test, what procedure, what kind of encounter.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Detailed description of the type of activity; e.g. What lab test, what procedure, what kind of encounter.)
     */
    public ActivityDefinition setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #intent} (Indicates the level of authority/intentionality associated with the activity and where the request should fit into the workflow chain.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public Enumeration<RequestIntent> getIntentElement() { 
      if (this.intent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.intent");
        else if (Configuration.doAutoCreate())
          this.intent = new Enumeration<RequestIntent>(new RequestIntentEnumFactory()); // bb
      return this.intent;
    }

    public boolean hasIntentElement() { 
      return this.intent != null && !this.intent.isEmpty();
    }

    public boolean hasIntent() { 
      return this.intent != null && !this.intent.isEmpty();
    }

    /**
     * @param value {@link #intent} (Indicates the level of authority/intentionality associated with the activity and where the request should fit into the workflow chain.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public ActivityDefinition setIntentElement(Enumeration<RequestIntent> value) { 
      this.intent = value;
      return this;
    }

    /**
     * @return Indicates the level of authority/intentionality associated with the activity and where the request should fit into the workflow chain.
     */
    public RequestIntent getIntent() { 
      return this.intent == null ? null : this.intent.getValue();
    }

    /**
     * @param value Indicates the level of authority/intentionality associated with the activity and where the request should fit into the workflow chain.
     */
    public ActivityDefinition setIntent(RequestIntent value) { 
      if (value == null)
        this.intent = null;
      else {
        if (this.intent == null)
          this.intent = new Enumeration<RequestIntent>(new RequestIntentEnumFactory());
        this.intent.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #priority} (Indicates how quickly the activity  should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Enumeration<RequestPriority> getPriorityElement() { 
      if (this.priority == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.priority");
        else if (Configuration.doAutoCreate())
          this.priority = new Enumeration<RequestPriority>(new RequestPriorityEnumFactory()); // bb
      return this.priority;
    }

    public boolean hasPriorityElement() { 
      return this.priority != null && !this.priority.isEmpty();
    }

    public boolean hasPriority() { 
      return this.priority != null && !this.priority.isEmpty();
    }

    /**
     * @param value {@link #priority} (Indicates how quickly the activity  should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public ActivityDefinition setPriorityElement(Enumeration<RequestPriority> value) { 
      this.priority = value;
      return this;
    }

    /**
     * @return Indicates how quickly the activity  should be addressed with respect to other requests.
     */
    public RequestPriority getPriority() { 
      return this.priority == null ? null : this.priority.getValue();
    }

    /**
     * @param value Indicates how quickly the activity  should be addressed with respect to other requests.
     */
    public ActivityDefinition setPriority(RequestPriority value) { 
      if (value == null)
        this.priority = null;
      else {
        if (this.priority == null)
          this.priority = new Enumeration<RequestPriority>(new RequestPriorityEnumFactory());
        this.priority.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #doNotPerform} (Set this to true if the definition is to indicate that a particular activity should NOT be performed. If true, this element should be interpreted to reinforce a negative coding. For example NPO as a code with a doNotPerform of true would still indicate to NOT perform the action.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
     */
    public BooleanType getDoNotPerformElement() { 
      if (this.doNotPerform == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.doNotPerform");
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
     * @param value {@link #doNotPerform} (Set this to true if the definition is to indicate that a particular activity should NOT be performed. If true, this element should be interpreted to reinforce a negative coding. For example NPO as a code with a doNotPerform of true would still indicate to NOT perform the action.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
     */
    public ActivityDefinition setDoNotPerformElement(BooleanType value) { 
      this.doNotPerform = value;
      return this;
    }

    /**
     * @return Set this to true if the definition is to indicate that a particular activity should NOT be performed. If true, this element should be interpreted to reinforce a negative coding. For example NPO as a code with a doNotPerform of true would still indicate to NOT perform the action.
     */
    public boolean getDoNotPerform() { 
      return this.doNotPerform == null || this.doNotPerform.isEmpty() ? false : this.doNotPerform.getValue();
    }

    /**
     * @param value Set this to true if the definition is to indicate that a particular activity should NOT be performed. If true, this element should be interpreted to reinforce a negative coding. For example NPO as a code with a doNotPerform of true would still indicate to NOT perform the action.
     */
    public ActivityDefinition setDoNotPerform(boolean value) { 
        if (this.doNotPerform == null)
          this.doNotPerform = new BooleanType();
        this.doNotPerform.setValue(value);
      return this;
    }

    /**
     * @return {@link #timing} (The period, timing or frequency upon which the described activity is to occur.)
     */
    public DataType getTiming() { 
      return this.timing;
    }

    /**
     * @return {@link #timing} (The period, timing or frequency upon which the described activity is to occur.)
     */
    public Timing getTimingTiming() throws FHIRException { 
      if (this.timing == null)
        this.timing = new Timing();
      if (!(this.timing instanceof Timing))
        throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.timing.getClass().getName()+" was encountered");
      return (Timing) this.timing;
    }

    public boolean hasTimingTiming() { 
      return this != null && this.timing instanceof Timing;
    }

    /**
     * @return {@link #timing} (The period, timing or frequency upon which the described activity is to occur.)
     */
    public DateTimeType getTimingDateTimeType() throws FHIRException { 
      if (this.timing == null)
        this.timing = new DateTimeType();
      if (!(this.timing instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.timing.getClass().getName()+" was encountered");
      return (DateTimeType) this.timing;
    }

    public boolean hasTimingDateTimeType() { 
      return this != null && this.timing instanceof DateTimeType;
    }

    /**
     * @return {@link #timing} (The period, timing or frequency upon which the described activity is to occur.)
     */
    public Age getTimingAge() throws FHIRException { 
      if (this.timing == null)
        this.timing = new Age();
      if (!(this.timing instanceof Age))
        throw new FHIRException("Type mismatch: the type Age was expected, but "+this.timing.getClass().getName()+" was encountered");
      return (Age) this.timing;
    }

    public boolean hasTimingAge() { 
      return this != null && this.timing instanceof Age;
    }

    /**
     * @return {@link #timing} (The period, timing or frequency upon which the described activity is to occur.)
     */
    public Period getTimingPeriod() throws FHIRException { 
      if (this.timing == null)
        this.timing = new Period();
      if (!(this.timing instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.timing.getClass().getName()+" was encountered");
      return (Period) this.timing;
    }

    public boolean hasTimingPeriod() { 
      return this != null && this.timing instanceof Period;
    }

    /**
     * @return {@link #timing} (The period, timing or frequency upon which the described activity is to occur.)
     */
    public Range getTimingRange() throws FHIRException { 
      if (this.timing == null)
        this.timing = new Range();
      if (!(this.timing instanceof Range))
        throw new FHIRException("Type mismatch: the type Range was expected, but "+this.timing.getClass().getName()+" was encountered");
      return (Range) this.timing;
    }

    public boolean hasTimingRange() { 
      return this != null && this.timing instanceof Range;
    }

    /**
     * @return {@link #timing} (The period, timing or frequency upon which the described activity is to occur.)
     */
    public Duration getTimingDuration() throws FHIRException { 
      if (this.timing == null)
        this.timing = new Duration();
      if (!(this.timing instanceof Duration))
        throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.timing.getClass().getName()+" was encountered");
      return (Duration) this.timing;
    }

    public boolean hasTimingDuration() { 
      return this != null && this.timing instanceof Duration;
    }

    public boolean hasTiming() { 
      return this.timing != null && !this.timing.isEmpty();
    }

    /**
     * @param value {@link #timing} (The period, timing or frequency upon which the described activity is to occur.)
     */
    public ActivityDefinition setTiming(DataType value) { 
      if (value != null && !(value instanceof Timing || value instanceof DateTimeType || value instanceof Age || value instanceof Period || value instanceof Range || value instanceof Duration))
        throw new Error("Not the right type for ActivityDefinition.timing[x]: "+value.fhirType());
      this.timing = value;
      return this;
    }

    /**
     * @return {@link #location} (Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc.)
     */
    public ActivityDefinition setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #participant} (Indicates who should participate in performing the action described.)
     */
    public List<ActivityDefinitionParticipantComponent> getParticipant() { 
      if (this.participant == null)
        this.participant = new ArrayList<ActivityDefinitionParticipantComponent>();
      return this.participant;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setParticipant(List<ActivityDefinitionParticipantComponent> theParticipant) { 
      this.participant = theParticipant;
      return this;
    }

    public boolean hasParticipant() { 
      if (this.participant == null)
        return false;
      for (ActivityDefinitionParticipantComponent item : this.participant)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ActivityDefinitionParticipantComponent addParticipant() { //3
      ActivityDefinitionParticipantComponent t = new ActivityDefinitionParticipantComponent();
      if (this.participant == null)
        this.participant = new ArrayList<ActivityDefinitionParticipantComponent>();
      this.participant.add(t);
      return t;
    }

    public ActivityDefinition addParticipant(ActivityDefinitionParticipantComponent t) { //3
      if (t == null)
        return this;
      if (this.participant == null)
        this.participant = new ArrayList<ActivityDefinitionParticipantComponent>();
      this.participant.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #participant}, creating it if it does not already exist {3}
     */
    public ActivityDefinitionParticipantComponent getParticipantFirstRep() { 
      if (getParticipant().isEmpty()) {
        addParticipant();
      }
      return getParticipant().get(0);
    }

    /**
     * @return {@link #product} (Identifies the food, drug or other product being consumed or supplied in the activity.)
     */
    public DataType getProduct() { 
      return this.product;
    }

    /**
     * @return {@link #product} (Identifies the food, drug or other product being consumed or supplied in the activity.)
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

    /**
     * @return {@link #product} (Identifies the food, drug or other product being consumed or supplied in the activity.)
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

    public boolean hasProduct() { 
      return this.product != null && !this.product.isEmpty();
    }

    /**
     * @param value {@link #product} (Identifies the food, drug or other product being consumed or supplied in the activity.)
     */
    public ActivityDefinition setProduct(DataType value) { 
      if (value != null && !(value instanceof Reference || value instanceof CodeableConcept))
        throw new Error("Not the right type for ActivityDefinition.product[x]: "+value.fhirType());
      this.product = value;
      return this;
    }

    /**
     * @return {@link #quantity} (Identifies the quantity expected to be consumed at once (per dose, per meal, etc.).)
     */
    public Quantity getQuantity() { 
      if (this.quantity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.quantity");
        else if (Configuration.doAutoCreate())
          this.quantity = new Quantity(); // cc
      return this.quantity;
    }

    public boolean hasQuantity() { 
      return this.quantity != null && !this.quantity.isEmpty();
    }

    /**
     * @param value {@link #quantity} (Identifies the quantity expected to be consumed at once (per dose, per meal, etc.).)
     */
    public ActivityDefinition setQuantity(Quantity value) { 
      this.quantity = value;
      return this;
    }

    /**
     * @return {@link #dosage} (Provides detailed dosage instructions in the same way that they are described for MedicationRequest resources.)
     */
    public List<Dosage> getDosage() { 
      if (this.dosage == null)
        this.dosage = new ArrayList<Dosage>();
      return this.dosage;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setDosage(List<Dosage> theDosage) { 
      this.dosage = theDosage;
      return this;
    }

    public boolean hasDosage() { 
      if (this.dosage == null)
        return false;
      for (Dosage item : this.dosage)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Dosage addDosage() { //3
      Dosage t = new Dosage();
      if (this.dosage == null)
        this.dosage = new ArrayList<Dosage>();
      this.dosage.add(t);
      return t;
    }

    public ActivityDefinition addDosage(Dosage t) { //3
      if (t == null)
        return this;
      if (this.dosage == null)
        this.dosage = new ArrayList<Dosage>();
      this.dosage.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dosage}, creating it if it does not already exist {3}
     */
    public Dosage getDosageFirstRep() { 
      if (getDosage().isEmpty()) {
        addDosage();
      }
      return getDosage().get(0);
    }

    /**
     * @return {@link #bodySite} (Indicates the sites on the subject's body where the procedure should be performed (I.e. the target sites).)
     */
    public List<CodeableConcept> getBodySite() { 
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableConcept>();
      return this.bodySite;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setBodySite(List<CodeableConcept> theBodySite) { 
      this.bodySite = theBodySite;
      return this;
    }

    public boolean hasBodySite() { 
      if (this.bodySite == null)
        return false;
      for (CodeableConcept item : this.bodySite)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addBodySite() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableConcept>();
      this.bodySite.add(t);
      return t;
    }

    public ActivityDefinition addBodySite(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableConcept>();
      this.bodySite.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #bodySite}, creating it if it does not already exist {3}
     */
    public CodeableConcept getBodySiteFirstRep() { 
      if (getBodySite().isEmpty()) {
        addBodySite();
      }
      return getBodySite().get(0);
    }

    /**
     * @return {@link #specimenRequirement} (Defines specimen requirements for the action to be performed, such as required specimens for a lab test.)
     */
    public List<Reference> getSpecimenRequirement() { 
      if (this.specimenRequirement == null)
        this.specimenRequirement = new ArrayList<Reference>();
      return this.specimenRequirement;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setSpecimenRequirement(List<Reference> theSpecimenRequirement) { 
      this.specimenRequirement = theSpecimenRequirement;
      return this;
    }

    public boolean hasSpecimenRequirement() { 
      if (this.specimenRequirement == null)
        return false;
      for (Reference item : this.specimenRequirement)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSpecimenRequirement() { //3
      Reference t = new Reference();
      if (this.specimenRequirement == null)
        this.specimenRequirement = new ArrayList<Reference>();
      this.specimenRequirement.add(t);
      return t;
    }

    public ActivityDefinition addSpecimenRequirement(Reference t) { //3
      if (t == null)
        return this;
      if (this.specimenRequirement == null)
        this.specimenRequirement = new ArrayList<Reference>();
      this.specimenRequirement.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #specimenRequirement}, creating it if it does not already exist {3}
     */
    public Reference getSpecimenRequirementFirstRep() { 
      if (getSpecimenRequirement().isEmpty()) {
        addSpecimenRequirement();
      }
      return getSpecimenRequirement().get(0);
    }

    /**
     * @return {@link #observationRequirement} (Defines observation requirements for the action to be performed, such as body weight or surface area.)
     */
    public List<Reference> getObservationRequirement() { 
      if (this.observationRequirement == null)
        this.observationRequirement = new ArrayList<Reference>();
      return this.observationRequirement;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setObservationRequirement(List<Reference> theObservationRequirement) { 
      this.observationRequirement = theObservationRequirement;
      return this;
    }

    public boolean hasObservationRequirement() { 
      if (this.observationRequirement == null)
        return false;
      for (Reference item : this.observationRequirement)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addObservationRequirement() { //3
      Reference t = new Reference();
      if (this.observationRequirement == null)
        this.observationRequirement = new ArrayList<Reference>();
      this.observationRequirement.add(t);
      return t;
    }

    public ActivityDefinition addObservationRequirement(Reference t) { //3
      if (t == null)
        return this;
      if (this.observationRequirement == null)
        this.observationRequirement = new ArrayList<Reference>();
      this.observationRequirement.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #observationRequirement}, creating it if it does not already exist {3}
     */
    public Reference getObservationRequirementFirstRep() { 
      if (getObservationRequirement().isEmpty()) {
        addObservationRequirement();
      }
      return getObservationRequirement().get(0);
    }

    /**
     * @return {@link #observationResultRequirement} (Defines the observations that are expected to be produced by the action.)
     */
    public List<Reference> getObservationResultRequirement() { 
      if (this.observationResultRequirement == null)
        this.observationResultRequirement = new ArrayList<Reference>();
      return this.observationResultRequirement;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setObservationResultRequirement(List<Reference> theObservationResultRequirement) { 
      this.observationResultRequirement = theObservationResultRequirement;
      return this;
    }

    public boolean hasObservationResultRequirement() { 
      if (this.observationResultRequirement == null)
        return false;
      for (Reference item : this.observationResultRequirement)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addObservationResultRequirement() { //3
      Reference t = new Reference();
      if (this.observationResultRequirement == null)
        this.observationResultRequirement = new ArrayList<Reference>();
      this.observationResultRequirement.add(t);
      return t;
    }

    public ActivityDefinition addObservationResultRequirement(Reference t) { //3
      if (t == null)
        return this;
      if (this.observationResultRequirement == null)
        this.observationResultRequirement = new ArrayList<Reference>();
      this.observationResultRequirement.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #observationResultRequirement}, creating it if it does not already exist {3}
     */
    public Reference getObservationResultRequirementFirstRep() { 
      if (getObservationResultRequirement().isEmpty()) {
        addObservationResultRequirement();
      }
      return getObservationResultRequirement().get(0);
    }

    /**
     * @return {@link #transform} (A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.). This is the underlying object with id, value and extensions. The accessor "getTransform" gives direct access to the value
     */
    public CanonicalType getTransformElement() { 
      if (this.transform == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ActivityDefinition.transform");
        else if (Configuration.doAutoCreate())
          this.transform = new CanonicalType(); // bb
      return this.transform;
    }

    public boolean hasTransformElement() { 
      return this.transform != null && !this.transform.isEmpty();
    }

    public boolean hasTransform() { 
      return this.transform != null && !this.transform.isEmpty();
    }

    /**
     * @param value {@link #transform} (A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.). This is the underlying object with id, value and extensions. The accessor "getTransform" gives direct access to the value
     */
    public ActivityDefinition setTransformElement(CanonicalType value) { 
      this.transform = value;
      return this;
    }

    /**
     * @return A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.
     */
    public String getTransform() { 
      return this.transform == null ? null : this.transform.getValue();
    }

    /**
     * @param value A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.
     */
    public ActivityDefinition setTransform(String value) { 
      if (Utilities.noString(value))
        this.transform = null;
      else {
        if (this.transform == null)
          this.transform = new CanonicalType();
        this.transform.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #dynamicValue} (Dynamic values that will be evaluated to produce values for elements of the resulting resource. For example, if the dosage of a medication must be computed based on the patient's weight, a dynamic value would be used to specify an expression that calculated the weight, and the path on the request resource that would contain the result.)
     */
    public List<ActivityDefinitionDynamicValueComponent> getDynamicValue() { 
      if (this.dynamicValue == null)
        this.dynamicValue = new ArrayList<ActivityDefinitionDynamicValueComponent>();
      return this.dynamicValue;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ActivityDefinition setDynamicValue(List<ActivityDefinitionDynamicValueComponent> theDynamicValue) { 
      this.dynamicValue = theDynamicValue;
      return this;
    }

    public boolean hasDynamicValue() { 
      if (this.dynamicValue == null)
        return false;
      for (ActivityDefinitionDynamicValueComponent item : this.dynamicValue)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ActivityDefinitionDynamicValueComponent addDynamicValue() { //3
      ActivityDefinitionDynamicValueComponent t = new ActivityDefinitionDynamicValueComponent();
      if (this.dynamicValue == null)
        this.dynamicValue = new ArrayList<ActivityDefinitionDynamicValueComponent>();
      this.dynamicValue.add(t);
      return t;
    }

    public ActivityDefinition addDynamicValue(ActivityDefinitionDynamicValueComponent t) { //3
      if (t == null)
        return this;
      if (this.dynamicValue == null)
        this.dynamicValue = new ArrayList<ActivityDefinitionDynamicValueComponent>();
      this.dynamicValue.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dynamicValue}, creating it if it does not already exist {3}
     */
    public ActivityDefinitionDynamicValueComponent getDynamicValueFirstRep() { 
      if (getDynamicValue().isEmpty()) {
        addDynamicValue();
      }
      return getDynamicValue().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this activity definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this activity definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the activity definition is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this activity definition when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the activity definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the activity definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active assets.", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the activity definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the activity definition.", 0, 1, title));
        children.add(new Property("subtitle", "string", "An explanatory or alternate title for the activity definition giving additional information about its content.", 0, 1, subtitle));
        children.add(new Property("status", "code", "The status of this activity definition. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this activity definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("subject[x]", "CodeableConcept|Reference(Group)", "A code or group definition that describes the intended subject of the activity being defined.", 0, 1, subject));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the activity definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the activity definition changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual that published the activity definition.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the activity definition from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate activity definition instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the activity definition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this activity definition is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("usage", "string", "A detailed description of how the activity definition is used from a clinical perspective.", 0, 1, usage));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the activity definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the activity definition.", 0, 1, copyright));
        children.add(new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the activity definition content was or is planned to be in active use.", 0, 1, effectivePeriod));
        children.add(new Property("topic", "CodeableConcept", "Descriptive topics related to the content of the activity. Topics provide a high-level categorization of the activity that can be useful for filtering and searching.", 0, java.lang.Integer.MAX_VALUE, topic));
        children.add(new Property("author", "ContactDetail", "An individiual or organization primarily involved in the creation and maintenance of the content.", 0, java.lang.Integer.MAX_VALUE, author));
        children.add(new Property("editor", "ContactDetail", "An individual or organization primarily responsible for internal coherence of the content.", 0, java.lang.Integer.MAX_VALUE, editor));
        children.add(new Property("reviewer", "ContactDetail", "An individual or organization primarily responsible for review of some aspect of the content.", 0, java.lang.Integer.MAX_VALUE, reviewer));
        children.add(new Property("endorser", "ContactDetail", "An individual or organization responsible for officially endorsing the content for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Related artifacts such as additional documentation, justification, or bibliographic references.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
        children.add(new Property("library", "canonical(Library)", "A reference to a Library resource containing any formal logic used by the activity definition.", 0, java.lang.Integer.MAX_VALUE, library));
        children.add(new Property("kind", "code", "A description of the kind of resource the activity definition is representing. For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest. Typically, but not always, this is a Request resource.", 0, 1, kind));
        children.add(new Property("profile", "canonical(StructureDefinition)", "A profile to which the target of the activity definition is expected to conform.", 0, 1, profile));
        children.add(new Property("code", "CodeableConcept", "Detailed description of the type of activity; e.g. What lab test, what procedure, what kind of encounter.", 0, 1, code));
        children.add(new Property("intent", "code", "Indicates the level of authority/intentionality associated with the activity and where the request should fit into the workflow chain.", 0, 1, intent));
        children.add(new Property("priority", "code", "Indicates how quickly the activity  should be addressed with respect to other requests.", 0, 1, priority));
        children.add(new Property("doNotPerform", "boolean", "Set this to true if the definition is to indicate that a particular activity should NOT be performed. If true, this element should be interpreted to reinforce a negative coding. For example NPO as a code with a doNotPerform of true would still indicate to NOT perform the action.", 0, 1, doNotPerform));
        children.add(new Property("timing[x]", "Timing|dateTime|Age|Period|Range|Duration", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, timing));
        children.add(new Property("location", "Reference(Location)", "Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc.", 0, 1, location));
        children.add(new Property("participant", "", "Indicates who should participate in performing the action described.", 0, java.lang.Integer.MAX_VALUE, participant));
        children.add(new Property("product[x]", "Reference(Medication|Substance)|CodeableConcept", "Identifies the food, drug or other product being consumed or supplied in the activity.", 0, 1, product));
        children.add(new Property("quantity", "Quantity", "Identifies the quantity expected to be consumed at once (per dose, per meal, etc.).", 0, 1, quantity));
        children.add(new Property("dosage", "Dosage", "Provides detailed dosage instructions in the same way that they are described for MedicationRequest resources.", 0, java.lang.Integer.MAX_VALUE, dosage));
        children.add(new Property("bodySite", "CodeableConcept", "Indicates the sites on the subject's body where the procedure should be performed (I.e. the target sites).", 0, java.lang.Integer.MAX_VALUE, bodySite));
        children.add(new Property("specimenRequirement", "Reference(SpecimenDefinition)", "Defines specimen requirements for the action to be performed, such as required specimens for a lab test.", 0, java.lang.Integer.MAX_VALUE, specimenRequirement));
        children.add(new Property("observationRequirement", "Reference(ObservationDefinition)", "Defines observation requirements for the action to be performed, such as body weight or surface area.", 0, java.lang.Integer.MAX_VALUE, observationRequirement));
        children.add(new Property("observationResultRequirement", "Reference(ObservationDefinition)", "Defines the observations that are expected to be produced by the action.", 0, java.lang.Integer.MAX_VALUE, observationResultRequirement));
        children.add(new Property("transform", "canonical(StructureMap)", "A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.", 0, 1, transform));
        children.add(new Property("dynamicValue", "", "Dynamic values that will be evaluated to produce values for elements of the resulting resource. For example, if the dosage of a medication must be computed based on the patient's weight, a dynamic value would be used to specify an expression that calculated the weight, and the path on the request resource that would contain the result.", 0, java.lang.Integer.MAX_VALUE, dynamicValue));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this activity definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this activity definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the activity definition is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this activity definition when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the activity definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the activity definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active assets.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the activity definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the activity definition.", 0, 1, title);
        case -2060497896: /*subtitle*/  return new Property("subtitle", "string", "An explanatory or alternate title for the activity definition giving additional information about its content.", 0, 1, subtitle);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this activity definition. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this activity definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case -573640748: /*subject[x]*/  return new Property("subject[x]", "CodeableConcept|Reference(Group)", "A code or group definition that describes the intended subject of the activity being defined.", 0, 1, subject);
        case -1867885268: /*subject*/  return new Property("subject[x]", "CodeableConcept|Reference(Group)", "A code or group definition that describes the intended subject of the activity being defined.", 0, 1, subject);
        case -1257122603: /*subjectCodeableConcept*/  return new Property("subject[x]", "CodeableConcept", "A code or group definition that describes the intended subject of the activity being defined.", 0, 1, subject);
        case 772938623: /*subjectReference*/  return new Property("subject[x]", "Reference(Group)", "A code or group definition that describes the intended subject of the activity being defined.", 0, 1, subject);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the activity definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the activity definition changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual that published the activity definition.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the activity definition from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate activity definition instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the activity definition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this activity definition is needed and why it has been designed as it has.", 0, 1, purpose);
        case 111574433: /*usage*/  return new Property("usage", "string", "A detailed description of how the activity definition is used from a clinical perspective.", 0, 1, usage);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the activity definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the activity definition.", 0, 1, copyright);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the activity definition content was or is planned to be in active use.", 0, 1, effectivePeriod);
        case 110546223: /*topic*/  return new Property("topic", "CodeableConcept", "Descriptive topics related to the content of the activity. Topics provide a high-level categorization of the activity that can be useful for filtering and searching.", 0, java.lang.Integer.MAX_VALUE, topic);
        case -1406328437: /*author*/  return new Property("author", "ContactDetail", "An individiual or organization primarily involved in the creation and maintenance of the content.", 0, java.lang.Integer.MAX_VALUE, author);
        case -1307827859: /*editor*/  return new Property("editor", "ContactDetail", "An individual or organization primarily responsible for internal coherence of the content.", 0, java.lang.Integer.MAX_VALUE, editor);
        case -261190139: /*reviewer*/  return new Property("reviewer", "ContactDetail", "An individual or organization primarily responsible for review of some aspect of the content.", 0, java.lang.Integer.MAX_VALUE, reviewer);
        case 1740277666: /*endorser*/  return new Property("endorser", "ContactDetail", "An individual or organization responsible for officially endorsing the content for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Related artifacts such as additional documentation, justification, or bibliographic references.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        case 166208699: /*library*/  return new Property("library", "canonical(Library)", "A reference to a Library resource containing any formal logic used by the activity definition.", 0, java.lang.Integer.MAX_VALUE, library);
        case 3292052: /*kind*/  return new Property("kind", "code", "A description of the kind of resource the activity definition is representing. For example, a MedicationRequest, a ServiceRequest, or a CommunicationRequest. Typically, but not always, this is a Request resource.", 0, 1, kind);
        case -309425751: /*profile*/  return new Property("profile", "canonical(StructureDefinition)", "A profile to which the target of the activity definition is expected to conform.", 0, 1, profile);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Detailed description of the type of activity; e.g. What lab test, what procedure, what kind of encounter.", 0, 1, code);
        case -1183762788: /*intent*/  return new Property("intent", "code", "Indicates the level of authority/intentionality associated with the activity and where the request should fit into the workflow chain.", 0, 1, intent);
        case -1165461084: /*priority*/  return new Property("priority", "code", "Indicates how quickly the activity  should be addressed with respect to other requests.", 0, 1, priority);
        case -1788508167: /*doNotPerform*/  return new Property("doNotPerform", "boolean", "Set this to true if the definition is to indicate that a particular activity should NOT be performed. If true, this element should be interpreted to reinforce a negative coding. For example NPO as a code with a doNotPerform of true would still indicate to NOT perform the action.", 0, 1, doNotPerform);
        case 164632566: /*timing[x]*/  return new Property("timing[x]", "Timing|dateTime|Age|Period|Range|Duration", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, timing);
        case -873664438: /*timing*/  return new Property("timing[x]", "Timing|dateTime|Age|Period|Range|Duration", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, timing);
        case -497554124: /*timingTiming*/  return new Property("timing[x]", "Timing", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, timing);
        case -1837458939: /*timingDateTime*/  return new Property("timing[x]", "dateTime", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, timing);
        case 164607061: /*timingAge*/  return new Property("timing[x]", "Age", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, timing);
        case -615615829: /*timingPeriod*/  return new Property("timing[x]", "Period", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, timing);
        case -710871277: /*timingRange*/  return new Property("timing[x]", "Range", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, timing);
        case -1327253506: /*timingDuration*/  return new Property("timing[x]", "Duration", "The period, timing or frequency upon which the described activity is to occur.", 0, 1, timing);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "Identifies the facility where the activity will occur; e.g. home, hospital, specific clinic, etc.", 0, 1, location);
        case 767422259: /*participant*/  return new Property("participant", "", "Indicates who should participate in performing the action described.", 0, java.lang.Integer.MAX_VALUE, participant);
        case 1753005361: /*product[x]*/  return new Property("product[x]", "Reference(Medication|Substance)|CodeableConcept", "Identifies the food, drug or other product being consumed or supplied in the activity.", 0, 1, product);
        case -309474065: /*product*/  return new Property("product[x]", "Reference(Medication|Substance)|CodeableConcept", "Identifies the food, drug or other product being consumed or supplied in the activity.", 0, 1, product);
        case -669667556: /*productReference*/  return new Property("product[x]", "Reference(Medication|Substance)", "Identifies the food, drug or other product being consumed or supplied in the activity.", 0, 1, product);
        case 906854066: /*productCodeableConcept*/  return new Property("product[x]", "CodeableConcept", "Identifies the food, drug or other product being consumed or supplied in the activity.", 0, 1, product);
        case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "Identifies the quantity expected to be consumed at once (per dose, per meal, etc.).", 0, 1, quantity);
        case -1326018889: /*dosage*/  return new Property("dosage", "Dosage", "Provides detailed dosage instructions in the same way that they are described for MedicationRequest resources.", 0, java.lang.Integer.MAX_VALUE, dosage);
        case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableConcept", "Indicates the sites on the subject's body where the procedure should be performed (I.e. the target sites).", 0, java.lang.Integer.MAX_VALUE, bodySite);
        case 1498467355: /*specimenRequirement*/  return new Property("specimenRequirement", "Reference(SpecimenDefinition)", "Defines specimen requirements for the action to be performed, such as required specimens for a lab test.", 0, java.lang.Integer.MAX_VALUE, specimenRequirement);
        case 362354807: /*observationRequirement*/  return new Property("observationRequirement", "Reference(ObservationDefinition)", "Defines observation requirements for the action to be performed, such as body weight or surface area.", 0, java.lang.Integer.MAX_VALUE, observationRequirement);
        case 395230490: /*observationResultRequirement*/  return new Property("observationResultRequirement", "Reference(ObservationDefinition)", "Defines the observations that are expected to be produced by the action.", 0, java.lang.Integer.MAX_VALUE, observationResultRequirement);
        case 1052666732: /*transform*/  return new Property("transform", "canonical(StructureMap)", "A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.", 0, 1, transform);
        case 572625010: /*dynamicValue*/  return new Property("dynamicValue", "", "Dynamic values that will be evaluated to produce values for elements of the resulting resource. For example, if the dosage of a medication must be computed based on the patient's weight, a dynamic value would be used to specify an expression that calculated the weight, and the path on the request resource that would contain the result.", 0, java.lang.Integer.MAX_VALUE, dynamicValue);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -2060497896: /*subtitle*/ return this.subtitle == null ? new Base[0] : new Base[] {this.subtitle}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // DataType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 111574433: /*usage*/ return this.usage == null ? new Base[0] : new Base[] {this.usage}; // StringType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case 110546223: /*topic*/ return this.topic == null ? new Base[0] : this.topic.toArray(new Base[this.topic.size()]); // CodeableConcept
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // ContactDetail
        case -1307827859: /*editor*/ return this.editor == null ? new Base[0] : this.editor.toArray(new Base[this.editor.size()]); // ContactDetail
        case -261190139: /*reviewer*/ return this.reviewer == null ? new Base[0] : this.reviewer.toArray(new Base[this.reviewer.size()]); // ContactDetail
        case 1740277666: /*endorser*/ return this.endorser == null ? new Base[0] : this.endorser.toArray(new Base[this.endorser.size()]); // ContactDetail
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case 166208699: /*library*/ return this.library == null ? new Base[0] : this.library.toArray(new Base[this.library.size()]); // CanonicalType
        case 3292052: /*kind*/ return this.kind == null ? new Base[0] : new Base[] {this.kind}; // Enumeration<RequestResourceType>
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : new Base[] {this.profile}; // CanonicalType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1183762788: /*intent*/ return this.intent == null ? new Base[0] : new Base[] {this.intent}; // Enumeration<RequestIntent>
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // Enumeration<RequestPriority>
        case -1788508167: /*doNotPerform*/ return this.doNotPerform == null ? new Base[0] : new Base[] {this.doNotPerform}; // BooleanType
        case -873664438: /*timing*/ return this.timing == null ? new Base[0] : new Base[] {this.timing}; // DataType
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // ActivityDefinitionParticipantComponent
        case -309474065: /*product*/ return this.product == null ? new Base[0] : new Base[] {this.product}; // DataType
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case -1326018889: /*dosage*/ return this.dosage == null ? new Base[0] : this.dosage.toArray(new Base[this.dosage.size()]); // Dosage
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : this.bodySite.toArray(new Base[this.bodySite.size()]); // CodeableConcept
        case 1498467355: /*specimenRequirement*/ return this.specimenRequirement == null ? new Base[0] : this.specimenRequirement.toArray(new Base[this.specimenRequirement.size()]); // Reference
        case 362354807: /*observationRequirement*/ return this.observationRequirement == null ? new Base[0] : this.observationRequirement.toArray(new Base[this.observationRequirement.size()]); // Reference
        case 395230490: /*observationResultRequirement*/ return this.observationResultRequirement == null ? new Base[0] : this.observationResultRequirement.toArray(new Base[this.observationResultRequirement.size()]); // Reference
        case 1052666732: /*transform*/ return this.transform == null ? new Base[0] : new Base[] {this.transform}; // CanonicalType
        case 572625010: /*dynamicValue*/ return this.dynamicValue == null ? new Base[0] : this.dynamicValue.toArray(new Base[this.dynamicValue.size()]); // ActivityDefinitionDynamicValueComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -2060497896: // subtitle
          this.subtitle = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -404562712: // experimental
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToType(value); // DataType
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1447404028: // publisher
          this.publisher = TypeConvertor.castToString(value); // StringType
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        case -507075711: // jurisdiction
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -220463842: // purpose
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 111574433: // usage
          this.usage = TypeConvertor.castToString(value); // StringType
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 223539345: // approvalDate
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1687512484: // lastReviewDate
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -403934648: // effectivePeriod
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 110546223: // topic
          this.getTopic().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1406328437: // author
          this.getAuthor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -1307827859: // editor
          this.getEditor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -261190139: // reviewer
          this.getReviewer().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case 1740277666: // endorser
          this.getEndorser().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case 666807069: // relatedArtifact
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case 166208699: // library
          this.getLibrary().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 3292052: // kind
          value = new RequestResourceTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<RequestResourceType>
          return value;
        case -309425751: // profile
          this.profile = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1183762788: // intent
          value = new RequestIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<RequestIntent>
          return value;
        case -1165461084: // priority
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
          return value;
        case -1788508167: // doNotPerform
          this.doNotPerform = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -873664438: // timing
          this.timing = TypeConvertor.castToType(value); // DataType
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case 767422259: // participant
          this.getParticipant().add((ActivityDefinitionParticipantComponent) value); // ActivityDefinitionParticipantComponent
          return value;
        case -309474065: // product
          this.product = TypeConvertor.castToType(value); // DataType
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -1326018889: // dosage
          this.getDosage().add(TypeConvertor.castToDosage(value)); // Dosage
          return value;
        case 1702620169: // bodySite
          this.getBodySite().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1498467355: // specimenRequirement
          this.getSpecimenRequirement().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 362354807: // observationRequirement
          this.getObservationRequirement().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 395230490: // observationResultRequirement
          this.getObservationResultRequirement().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1052666732: // transform
          this.transform = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 572625010: // dynamicValue
          this.getDynamicValue().add((ActivityDefinitionDynamicValueComponent) value); // ActivityDefinitionDynamicValueComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("subtitle")) {
          this.subtitle = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("subject[x]")) {
          this.subject = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("usage")) {
          this.usage = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("approvalDate")) {
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("topic")) {
          this.getTopic().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("author")) {
          this.getAuthor().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("editor")) {
          this.getEditor().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("reviewer")) {
          this.getReviewer().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("endorser")) {
          this.getEndorser().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("library")) {
          this.getLibrary().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("kind")) {
          value = new RequestResourceTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<RequestResourceType>
        } else if (name.equals("profile")) {
          this.profile = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("intent")) {
          value = new RequestIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<RequestIntent>
        } else if (name.equals("priority")) {
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
        } else if (name.equals("doNotPerform")) {
          this.doNotPerform = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("timing[x]")) {
          this.timing = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("participant")) {
          this.getParticipant().add((ActivityDefinitionParticipantComponent) value);
        } else if (name.equals("product[x]")) {
          this.product = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("dosage")) {
          this.getDosage().add(TypeConvertor.castToDosage(value));
        } else if (name.equals("bodySite")) {
          this.getBodySite().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("specimenRequirement")) {
          this.getSpecimenRequirement().add(TypeConvertor.castToReference(value));
        } else if (name.equals("observationRequirement")) {
          this.getObservationRequirement().add(TypeConvertor.castToReference(value));
        } else if (name.equals("observationResultRequirement")) {
          this.getObservationResultRequirement().add(TypeConvertor.castToReference(value));
        } else if (name.equals("transform")) {
          this.transform = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("dynamicValue")) {
          this.getDynamicValue().add((ActivityDefinitionDynamicValueComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return getVersionElement();
        case 3373707:  return getNameElement();
        case 110371416:  return getTitleElement();
        case -2060497896:  return getSubtitleElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case -573640748:  return getSubject();
        case -1867885268:  return getSubject();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 111574433:  return getUsageElement();
        case 1522889671:  return getCopyrightElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -403934648:  return getEffectivePeriod();
        case 110546223:  return addTopic(); 
        case -1406328437:  return addAuthor(); 
        case -1307827859:  return addEditor(); 
        case -261190139:  return addReviewer(); 
        case 1740277666:  return addEndorser(); 
        case 666807069:  return addRelatedArtifact(); 
        case 166208699:  return addLibraryElement();
        case 3292052:  return getKindElement();
        case -309425751:  return getProfileElement();
        case 3059181:  return getCode();
        case -1183762788:  return getIntentElement();
        case -1165461084:  return getPriorityElement();
        case -1788508167:  return getDoNotPerformElement();
        case 164632566:  return getTiming();
        case -873664438:  return getTiming();
        case 1901043637:  return getLocation();
        case 767422259:  return addParticipant(); 
        case 1753005361:  return getProduct();
        case -309474065:  return getProduct();
        case -1285004149:  return getQuantity();
        case -1326018889:  return addDosage(); 
        case 1702620169:  return addBodySite(); 
        case 1498467355:  return addSpecimenRequirement(); 
        case 362354807:  return addObservationRequirement(); 
        case 395230490:  return addObservationResultRequirement(); 
        case 1052666732:  return getTransformElement();
        case 572625010:  return addDynamicValue(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -2060497896: /*subtitle*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case -1867885268: /*subject*/ return new String[] {"CodeableConcept", "Reference"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 111574433: /*usage*/ return new String[] {"string"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case 110546223: /*topic*/ return new String[] {"CodeableConcept"};
        case -1406328437: /*author*/ return new String[] {"ContactDetail"};
        case -1307827859: /*editor*/ return new String[] {"ContactDetail"};
        case -261190139: /*reviewer*/ return new String[] {"ContactDetail"};
        case 1740277666: /*endorser*/ return new String[] {"ContactDetail"};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case 166208699: /*library*/ return new String[] {"canonical"};
        case 3292052: /*kind*/ return new String[] {"code"};
        case -309425751: /*profile*/ return new String[] {"canonical"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1183762788: /*intent*/ return new String[] {"code"};
        case -1165461084: /*priority*/ return new String[] {"code"};
        case -1788508167: /*doNotPerform*/ return new String[] {"boolean"};
        case -873664438: /*timing*/ return new String[] {"Timing", "dateTime", "Age", "Period", "Range", "Duration"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case 767422259: /*participant*/ return new String[] {};
        case -309474065: /*product*/ return new String[] {"Reference", "CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case -1326018889: /*dosage*/ return new String[] {"Dosage"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableConcept"};
        case 1498467355: /*specimenRequirement*/ return new String[] {"Reference"};
        case 362354807: /*observationRequirement*/ return new String[] {"Reference"};
        case 395230490: /*observationResultRequirement*/ return new String[] {"Reference"};
        case 1052666732: /*transform*/ return new String[] {"canonical"};
        case 572625010: /*dynamicValue*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.title");
        }
        else if (name.equals("subtitle")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.subtitle");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.experimental");
        }
        else if (name.equals("subjectCodeableConcept")) {
          this.subject = new CodeableConcept();
          return this.subject;
        }
        else if (name.equals("subjectReference")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.purpose");
        }
        else if (name.equals("usage")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.usage");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.copyright");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("topic")) {
          return addTopic();
        }
        else if (name.equals("author")) {
          return addAuthor();
        }
        else if (name.equals("editor")) {
          return addEditor();
        }
        else if (name.equals("reviewer")) {
          return addReviewer();
        }
        else if (name.equals("endorser")) {
          return addEndorser();
        }
        else if (name.equals("relatedArtifact")) {
          return addRelatedArtifact();
        }
        else if (name.equals("library")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.library");
        }
        else if (name.equals("kind")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.kind");
        }
        else if (name.equals("profile")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.profile");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("intent")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.intent");
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.priority");
        }
        else if (name.equals("doNotPerform")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.doNotPerform");
        }
        else if (name.equals("timingTiming")) {
          this.timing = new Timing();
          return this.timing;
        }
        else if (name.equals("timingDateTime")) {
          this.timing = new DateTimeType();
          return this.timing;
        }
        else if (name.equals("timingAge")) {
          this.timing = new Age();
          return this.timing;
        }
        else if (name.equals("timingPeriod")) {
          this.timing = new Period();
          return this.timing;
        }
        else if (name.equals("timingRange")) {
          this.timing = new Range();
          return this.timing;
        }
        else if (name.equals("timingDuration")) {
          this.timing = new Duration();
          return this.timing;
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("participant")) {
          return addParticipant();
        }
        else if (name.equals("productReference")) {
          this.product = new Reference();
          return this.product;
        }
        else if (name.equals("productCodeableConcept")) {
          this.product = new CodeableConcept();
          return this.product;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("dosage")) {
          return addDosage();
        }
        else if (name.equals("bodySite")) {
          return addBodySite();
        }
        else if (name.equals("specimenRequirement")) {
          return addSpecimenRequirement();
        }
        else if (name.equals("observationRequirement")) {
          return addObservationRequirement();
        }
        else if (name.equals("observationResultRequirement")) {
          return addObservationResultRequirement();
        }
        else if (name.equals("transform")) {
          throw new FHIRException("Cannot call addChild on a primitive type ActivityDefinition.transform");
        }
        else if (name.equals("dynamicValue")) {
          return addDynamicValue();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ActivityDefinition";

  }

      public ActivityDefinition copy() {
        ActivityDefinition dst = new ActivityDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ActivityDefinition dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.name = name == null ? null : name.copy();
        dst.title = title == null ? null : title.copy();
        dst.subtitle = subtitle == null ? null : subtitle.copy();
        dst.status = status == null ? null : status.copy();
        dst.experimental = experimental == null ? null : experimental.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.date = date == null ? null : date.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactDetail>();
          for (ContactDetail i : contact)
            dst.contact.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        if (jurisdiction != null) {
          dst.jurisdiction = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : jurisdiction)
            dst.jurisdiction.add(i.copy());
        };
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.usage = usage == null ? null : usage.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        if (topic != null) {
          dst.topic = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : topic)
            dst.topic.add(i.copy());
        };
        if (author != null) {
          dst.author = new ArrayList<ContactDetail>();
          for (ContactDetail i : author)
            dst.author.add(i.copy());
        };
        if (editor != null) {
          dst.editor = new ArrayList<ContactDetail>();
          for (ContactDetail i : editor)
            dst.editor.add(i.copy());
        };
        if (reviewer != null) {
          dst.reviewer = new ArrayList<ContactDetail>();
          for (ContactDetail i : reviewer)
            dst.reviewer.add(i.copy());
        };
        if (endorser != null) {
          dst.endorser = new ArrayList<ContactDetail>();
          for (ContactDetail i : endorser)
            dst.endorser.add(i.copy());
        };
        if (relatedArtifact != null) {
          dst.relatedArtifact = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : relatedArtifact)
            dst.relatedArtifact.add(i.copy());
        };
        if (library != null) {
          dst.library = new ArrayList<CanonicalType>();
          for (CanonicalType i : library)
            dst.library.add(i.copy());
        };
        dst.kind = kind == null ? null : kind.copy();
        dst.profile = profile == null ? null : profile.copy();
        dst.code = code == null ? null : code.copy();
        dst.intent = intent == null ? null : intent.copy();
        dst.priority = priority == null ? null : priority.copy();
        dst.doNotPerform = doNotPerform == null ? null : doNotPerform.copy();
        dst.timing = timing == null ? null : timing.copy();
        dst.location = location == null ? null : location.copy();
        if (participant != null) {
          dst.participant = new ArrayList<ActivityDefinitionParticipantComponent>();
          for (ActivityDefinitionParticipantComponent i : participant)
            dst.participant.add(i.copy());
        };
        dst.product = product == null ? null : product.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        if (dosage != null) {
          dst.dosage = new ArrayList<Dosage>();
          for (Dosage i : dosage)
            dst.dosage.add(i.copy());
        };
        if (bodySite != null) {
          dst.bodySite = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : bodySite)
            dst.bodySite.add(i.copy());
        };
        if (specimenRequirement != null) {
          dst.specimenRequirement = new ArrayList<Reference>();
          for (Reference i : specimenRequirement)
            dst.specimenRequirement.add(i.copy());
        };
        if (observationRequirement != null) {
          dst.observationRequirement = new ArrayList<Reference>();
          for (Reference i : observationRequirement)
            dst.observationRequirement.add(i.copy());
        };
        if (observationResultRequirement != null) {
          dst.observationResultRequirement = new ArrayList<Reference>();
          for (Reference i : observationResultRequirement)
            dst.observationResultRequirement.add(i.copy());
        };
        dst.transform = transform == null ? null : transform.copy();
        if (dynamicValue != null) {
          dst.dynamicValue = new ArrayList<ActivityDefinitionDynamicValueComponent>();
          for (ActivityDefinitionDynamicValueComponent i : dynamicValue)
            dst.dynamicValue.add(i.copy());
        };
      }

      protected ActivityDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ActivityDefinition))
          return false;
        ActivityDefinition o = (ActivityDefinition) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(name, o.name, true) && compareDeep(title, o.title, true) && compareDeep(subtitle, o.subtitle, true)
           && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true) && compareDeep(subject, o.subject, true)
           && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true)
           && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(usage, o.usage, true)
           && compareDeep(copyright, o.copyright, true) && compareDeep(approvalDate, o.approvalDate, true)
           && compareDeep(lastReviewDate, o.lastReviewDate, true) && compareDeep(effectivePeriod, o.effectivePeriod, true)
           && compareDeep(topic, o.topic, true) && compareDeep(author, o.author, true) && compareDeep(editor, o.editor, true)
           && compareDeep(reviewer, o.reviewer, true) && compareDeep(endorser, o.endorser, true) && compareDeep(relatedArtifact, o.relatedArtifact, true)
           && compareDeep(library, o.library, true) && compareDeep(kind, o.kind, true) && compareDeep(profile, o.profile, true)
           && compareDeep(code, o.code, true) && compareDeep(intent, o.intent, true) && compareDeep(priority, o.priority, true)
           && compareDeep(doNotPerform, o.doNotPerform, true) && compareDeep(timing, o.timing, true) && compareDeep(location, o.location, true)
           && compareDeep(participant, o.participant, true) && compareDeep(product, o.product, true) && compareDeep(quantity, o.quantity, true)
           && compareDeep(dosage, o.dosage, true) && compareDeep(bodySite, o.bodySite, true) && compareDeep(specimenRequirement, o.specimenRequirement, true)
           && compareDeep(observationRequirement, o.observationRequirement, true) && compareDeep(observationResultRequirement, o.observationResultRequirement, true)
           && compareDeep(transform, o.transform, true) && compareDeep(dynamicValue, o.dynamicValue, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ActivityDefinition))
          return false;
        ActivityDefinition o = (ActivityDefinition) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(subtitle, o.subtitle, true) && compareValues(status, o.status, true)
           && compareValues(experimental, o.experimental, true) && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true)
           && compareValues(description, o.description, true) && compareValues(purpose, o.purpose, true) && compareValues(usage, o.usage, true)
           && compareValues(copyright, o.copyright, true) && compareValues(approvalDate, o.approvalDate, true)
           && compareValues(lastReviewDate, o.lastReviewDate, true) && compareValues(library, o.library, true)
           && compareValues(kind, o.kind, true) && compareValues(profile, o.profile, true) && compareValues(intent, o.intent, true)
           && compareValues(priority, o.priority, true) && compareValues(doNotPerform, o.doNotPerform, true) && compareValues(transform, o.transform, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , name, title, subtitle, status, experimental, subject, date, publisher, contact
          , description, useContext, jurisdiction, purpose, usage, copyright, approvalDate
          , lastReviewDate, effectivePeriod, topic, author, editor, reviewer, endorser, relatedArtifact
          , library, kind, profile, code, intent, priority, doNotPerform, timing, location
          , participant, product, quantity, dosage, bodySite, specimenRequirement, observationRequirement
          , observationResultRequirement, transform, dynamicValue);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ActivityDefinition;
   }

 /**
   * Search parameter: <b>composed-of</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='composed-of').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="composed-of", path="ActivityDefinition.relatedArtifact.where(type='composed-of').resource", description="What resource is being referenced", type="reference", target={Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CapabilityStatement2.class, CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseIssue.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class, DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceFocus.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_COMPOSED_OF = "composed-of";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>composed-of</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='composed-of').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam COMPOSED_OF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_COMPOSED_OF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ActivityDefinition:composed-of</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_COMPOSED_OF = new ca.uhn.fhir.model.api.Include("ActivityDefinition:composed-of").toLocked();

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the activity definition</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value as Quantity) | (ActivityDefinition.useContext.value as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(ActivityDefinition.useContext.value as Quantity) | (ActivityDefinition.useContext.value as Range)", description="A quantity- or range-valued use context assigned to the activity definition", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the activity definition</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value as Quantity) | (ActivityDefinition.useContext.value as Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the activity definition</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="ActivityDefinition.useContext", description="A use context type and quantity- or range-based value assigned to the activity definition", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the activity definition</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the activity definition</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="ActivityDefinition.useContext", description="A use context type and value assigned to the activity definition", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the activity definition</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="ActivityDefinition.useContext.code", description="A type of use context assigned to the activity definition", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(ActivityDefinition.useContext.value as CodeableConcept)", description="A use context assigned to the activity definition", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The activity definition publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="ActivityDefinition.date", description="The activity definition publication date", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The activity definition publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>depends-on</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='depends-on').resource | ActivityDefinition.library</b><br>
   * </p>
   */
  @SearchParamDefinition(name="depends-on", path="ActivityDefinition.relatedArtifact.where(type='depends-on').resource | ActivityDefinition.library", description="What resource is being referenced", type="reference", target={Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CapabilityStatement2.class, CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseIssue.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class, DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceFocus.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_DEPENDS_ON = "depends-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>depends-on</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='depends-on').resource | ActivityDefinition.library</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DEPENDS_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DEPENDS_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ActivityDefinition:depends-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DEPENDS_ON = new ca.uhn.fhir.model.api.Include("ActivityDefinition:depends-on").toLocked();

 /**
   * Search parameter: <b>derived-from</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='derived-from').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="derived-from", path="ActivityDefinition.relatedArtifact.where(type='derived-from').resource", description="What resource is being referenced", type="reference", target={Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CapabilityStatement2.class, CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseIssue.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class, DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceFocus.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_DERIVED_FROM = "derived-from";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>derived-from</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='derived-from').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DERIVED_FROM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DERIVED_FROM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ActivityDefinition:derived-from</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DERIVED_FROM = new ca.uhn.fhir.model.api.Include("ActivityDefinition:derived-from").toLocked();

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>The description of the activity definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="ActivityDefinition.description", description="The description of the activity definition", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>The description of the activity definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>effective</b>
   * <p>
   * Description: <b>The time during which the activity definition is intended to be in use</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.effectivePeriod</b><br>
   * </p>
   */
  @SearchParamDefinition(name="effective", path="ActivityDefinition.effectivePeriod", description="The time during which the activity definition is intended to be in use", type="date" )
  public static final String SP_EFFECTIVE = "effective";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>effective</b>
   * <p>
   * Description: <b>The time during which the activity definition is intended to be in use</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.effectivePeriod</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EFFECTIVE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_EFFECTIVE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ActivityDefinition.identifier", description="External identifier for the activity definition", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name="jurisdiction", path="ActivityDefinition.jurisdiction", description="Intended jurisdiction for the activity definition", type="token" )
  public static final String SP_JURISDICTION = "jurisdiction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_JURISDICTION);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the activity definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="ActivityDefinition.name", description="Computationally friendly name of the activity definition", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the activity definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>predecessor</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='predecessor').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="predecessor", path="ActivityDefinition.relatedArtifact.where(type='predecessor').resource", description="What resource is being referenced", type="reference", target={Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CapabilityStatement2.class, CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseIssue.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class, DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceFocus.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_PREDECESSOR = "predecessor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>predecessor</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='predecessor').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PREDECESSOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PREDECESSOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ActivityDefinition:predecessor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PREDECESSOR = new ca.uhn.fhir.model.api.Include("ActivityDefinition:predecessor").toLocked();

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the activity definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="ActivityDefinition.publisher", description="Name of the publisher of the activity definition", type="string" )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the activity definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PUBLISHER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ActivityDefinition.status", description="The current status of the activity definition", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>successor</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='successor').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="successor", path="ActivityDefinition.relatedArtifact.where(type='successor').resource", description="What resource is being referenced", type="reference", target={Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CapabilityStatement2.class, CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseIssue.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class, DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceFocus.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_SUCCESSOR = "successor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>successor</b>
   * <p>
   * Description: <b>What resource is being referenced</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='successor').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUCCESSOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUCCESSOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ActivityDefinition:successor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUCCESSOR = new ca.uhn.fhir.model.api.Include("ActivityDefinition:successor").toLocked();

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the activity definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="ActivityDefinition.title", description="The human-friendly name of the activity definition", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the activity definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>topic</b>
   * <p>
   * Description: <b>Topics associated with the module</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.topic</b><br>
   * </p>
   */
  @SearchParamDefinition(name="topic", path="ActivityDefinition.topic", description="Topics associated with the module", type="token" )
  public static final String SP_TOPIC = "topic";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>topic</b>
   * <p>
   * Description: <b>Topics associated with the module</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.topic</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TOPIC = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TOPIC);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the activity definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="ActivityDefinition.url", description="The uri that identifies the activity definition", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the activity definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version of the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="ActivityDefinition.version", description="The business version of the activity definition", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version of the activity definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);


}