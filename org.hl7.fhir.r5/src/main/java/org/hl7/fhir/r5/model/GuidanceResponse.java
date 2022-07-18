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
 * A guidance response is the formal response to a guidance request, including any output parameters returned by the evaluation, as well as the description of any proposed actions to be taken.
 */
@ResourceDef(name="GuidanceResponse", profile="http://hl7.org/fhir/StructureDefinition/GuidanceResponse")
public class GuidanceResponse extends DomainResource {

    public enum GuidanceResponseStatus {
        /**
         * The request was processed successfully.
         */
        SUCCESS, 
        /**
         * The request was processed successfully, but more data may result in a more complete evaluation.
         */
        DATAREQUESTED, 
        /**
         * The request was processed, but more data is required to complete the evaluation.
         */
        DATAREQUIRED, 
        /**
         * The request is currently being processed.
         */
        INPROGRESS, 
        /**
         * The request was not processed successfully.
         */
        FAILURE, 
        /**
         * The response was entered in error.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static GuidanceResponseStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("success".equals(codeString))
          return SUCCESS;
        if ("data-requested".equals(codeString))
          return DATAREQUESTED;
        if ("data-required".equals(codeString))
          return DATAREQUIRED;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("failure".equals(codeString))
          return FAILURE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown GuidanceResponseStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case SUCCESS: return "success";
            case DATAREQUESTED: return "data-requested";
            case DATAREQUIRED: return "data-required";
            case INPROGRESS: return "in-progress";
            case FAILURE: return "failure";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case SUCCESS: return "http://hl7.org/fhir/guidance-response-status";
            case DATAREQUESTED: return "http://hl7.org/fhir/guidance-response-status";
            case DATAREQUIRED: return "http://hl7.org/fhir/guidance-response-status";
            case INPROGRESS: return "http://hl7.org/fhir/guidance-response-status";
            case FAILURE: return "http://hl7.org/fhir/guidance-response-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/guidance-response-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case SUCCESS: return "The request was processed successfully.";
            case DATAREQUESTED: return "The request was processed successfully, but more data may result in a more complete evaluation.";
            case DATAREQUIRED: return "The request was processed, but more data is required to complete the evaluation.";
            case INPROGRESS: return "The request is currently being processed.";
            case FAILURE: return "The request was not processed successfully.";
            case ENTEREDINERROR: return "The response was entered in error.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case SUCCESS: return "Success";
            case DATAREQUESTED: return "Data Requested";
            case DATAREQUIRED: return "Data Required";
            case INPROGRESS: return "In Progress";
            case FAILURE: return "Failure";
            case ENTEREDINERROR: return "Entered In Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class GuidanceResponseStatusEnumFactory implements EnumFactory<GuidanceResponseStatus> {
    public GuidanceResponseStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("success".equals(codeString))
          return GuidanceResponseStatus.SUCCESS;
        if ("data-requested".equals(codeString))
          return GuidanceResponseStatus.DATAREQUESTED;
        if ("data-required".equals(codeString))
          return GuidanceResponseStatus.DATAREQUIRED;
        if ("in-progress".equals(codeString))
          return GuidanceResponseStatus.INPROGRESS;
        if ("failure".equals(codeString))
          return GuidanceResponseStatus.FAILURE;
        if ("entered-in-error".equals(codeString))
          return GuidanceResponseStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown GuidanceResponseStatus code '"+codeString+"'");
        }
        public Enumeration<GuidanceResponseStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<GuidanceResponseStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("success".equals(codeString))
          return new Enumeration<GuidanceResponseStatus>(this, GuidanceResponseStatus.SUCCESS);
        if ("data-requested".equals(codeString))
          return new Enumeration<GuidanceResponseStatus>(this, GuidanceResponseStatus.DATAREQUESTED);
        if ("data-required".equals(codeString))
          return new Enumeration<GuidanceResponseStatus>(this, GuidanceResponseStatus.DATAREQUIRED);
        if ("in-progress".equals(codeString))
          return new Enumeration<GuidanceResponseStatus>(this, GuidanceResponseStatus.INPROGRESS);
        if ("failure".equals(codeString))
          return new Enumeration<GuidanceResponseStatus>(this, GuidanceResponseStatus.FAILURE);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<GuidanceResponseStatus>(this, GuidanceResponseStatus.ENTEREDINERROR);
        throw new FHIRException("Unknown GuidanceResponseStatus code '"+codeString+"'");
        }
    public String toCode(GuidanceResponseStatus code) {
      if (code == GuidanceResponseStatus.SUCCESS)
        return "success";
      if (code == GuidanceResponseStatus.DATAREQUESTED)
        return "data-requested";
      if (code == GuidanceResponseStatus.DATAREQUIRED)
        return "data-required";
      if (code == GuidanceResponseStatus.INPROGRESS)
        return "in-progress";
      if (code == GuidanceResponseStatus.FAILURE)
        return "failure";
      if (code == GuidanceResponseStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(GuidanceResponseStatus code) {
      return code.getSystem();
      }
    }

    /**
     * The identifier of the request associated with this response. If an identifier was given as part of the request, it will be reproduced here to enable the requester to more easily identify the response in a multi-request scenario.
     */
    @Child(name = "requestIdentifier", type = {Identifier.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The identifier of the request associated with this response, if any", formalDefinition="The identifier of the request associated with this response. If an identifier was given as part of the request, it will be reproduced here to enable the requester to more easily identify the response in a multi-request scenario." )
    protected Identifier requestIdentifier;

    /**
     * Allows a service to provide  unique, business identifiers for the response.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier", formalDefinition="Allows a service to provide  unique, business identifiers for the response." )
    protected List<Identifier> identifier;

    /**
     * An identifier, CodeableConcept or canonical reference to the guidance that was requested.
     */
    @Child(name = "module", type = {UriType.class, CanonicalType.class, CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What guidance was requested", formalDefinition="An identifier, CodeableConcept or canonical reference to the guidance that was requested." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/guidance-module-code")
    protected DataType module;

    /**
     * The status of the response. If the evaluation is completed successfully, the status will indicate success. However, in order to complete the evaluation, the engine may require more information. In this case, the status will be data-required, and the response will contain a description of the additional required information. If the evaluation completed successfully, but the engine determines that a potentially more accurate response could be provided if more data was available, the status will be data-requested, and the response will contain a description of the additional requested information.
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="success | data-requested | data-required | in-progress | failure | entered-in-error", formalDefinition="The status of the response. If the evaluation is completed successfully, the status will indicate success. However, in order to complete the evaluation, the engine may require more information. In this case, the status will be data-required, and the response will contain a description of the additional required information. If the evaluation completed successfully, but the engine determines that a potentially more accurate response could be provided if more data was available, the status will be data-requested, and the response will contain a description of the additional requested information." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/guidance-response-status")
    protected Enumeration<GuidanceResponseStatus> status;

    /**
     * The patient for which the request was processed.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Patient the request was performed for", formalDefinition="The patient for which the request was processed." )
    protected Reference subject;

    /**
     * The encounter during which this response was created or to which the creation of this record is tightly associated.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Encounter during which the response was returned", formalDefinition="The encounter during which this response was created or to which the creation of this record is tightly associated." )
    protected Reference encounter;

    /**
     * Indicates when the guidance response was processed.
     */
    @Child(name = "occurrenceDateTime", type = {DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the guidance response was processed", formalDefinition="Indicates when the guidance response was processed." )
    protected DateTimeType occurrenceDateTime;

    /**
     * Provides a reference to the device that performed the guidance.
     */
    @Child(name = "performer", type = {Device.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Device returning the guidance", formalDefinition="Provides a reference to the device that performed the guidance." )
    protected Reference performer;

    /**
     * Describes the reason for the guidance response in coded or textual form, or Indicates the reason the request was initiated. This is typically provided as a parameter to the evaluation and echoed by the service, although for some use cases, such as subscription- or event-based scenarios, it may provide an indication of the cause for the response.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Why guidance is needed", formalDefinition="Describes the reason for the guidance response in coded or textual form, or Indicates the reason the request was initiated. This is typically provided as a parameter to the evaluation and echoed by the service, although for some use cases, such as subscription- or event-based scenarios, it may provide an indication of the cause for the response." )
    protected List<CodeableReference> reason;

    /**
     * Provides a mechanism to communicate additional information about the response.
     */
    @Child(name = "note", type = {Annotation.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional notes about the response", formalDefinition="Provides a mechanism to communicate additional information about the response." )
    protected List<Annotation> note;

    /**
     * Messages resulting from the evaluation of the artifact or artifacts. As part of evaluating the request, the engine may produce informational or warning messages. These messages will be provided by this element.
     */
    @Child(name = "evaluationMessage", type = {OperationOutcome.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Messages resulting from the evaluation of the artifact or artifacts", formalDefinition="Messages resulting from the evaluation of the artifact or artifacts. As part of evaluating the request, the engine may produce informational or warning messages. These messages will be provided by this element." )
    protected List<Reference> evaluationMessage;

    /**
     * The output parameters of the evaluation, if any. Many modules will result in the return of specific resources such as procedure or communication requests that are returned as part of the operation result. However, modules may define specific outputs that would be returned as the result of the evaluation, and these would be returned in this element.
     */
    @Child(name = "outputParameters", type = {Parameters.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The output parameters of the evaluation, if any", formalDefinition="The output parameters of the evaluation, if any. Many modules will result in the return of specific resources such as procedure or communication requests that are returned as part of the operation result. However, modules may define specific outputs that would be returned as the result of the evaluation, and these would be returned in this element." )
    protected Reference outputParameters;

    /**
     * The actions, if any, produced by the evaluation of the artifact.
     */
    @Child(name = "result", type = {CarePlan.class, RequestGroup.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Proposed actions, if any", formalDefinition="The actions, if any, produced by the evaluation of the artifact." )
    protected Reference result;

    /**
     * If the evaluation could not be completed due to lack of information, or additional information would potentially result in a more accurate response, this element will a description of the data required in order to proceed with the evaluation. A subsequent request to the service should include this data.
     */
    @Child(name = "dataRequirement", type = {DataRequirement.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional required data", formalDefinition="If the evaluation could not be completed due to lack of information, or additional information would potentially result in a more accurate response, this element will a description of the data required in order to proceed with the evaluation. A subsequent request to the service should include this data." )
    protected List<DataRequirement> dataRequirement;

    private static final long serialVersionUID = -1204912553L;

  /**
   * Constructor
   */
    public GuidanceResponse() {
      super();
    }

  /**
   * Constructor
   */
    public GuidanceResponse(DataType module, GuidanceResponseStatus status) {
      super();
      this.setModule(module);
      this.setStatus(status);
    }

    /**
     * @return {@link #requestIdentifier} (The identifier of the request associated with this response. If an identifier was given as part of the request, it will be reproduced here to enable the requester to more easily identify the response in a multi-request scenario.)
     */
    public Identifier getRequestIdentifier() { 
      if (this.requestIdentifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GuidanceResponse.requestIdentifier");
        else if (Configuration.doAutoCreate())
          this.requestIdentifier = new Identifier(); // cc
      return this.requestIdentifier;
    }

    public boolean hasRequestIdentifier() { 
      return this.requestIdentifier != null && !this.requestIdentifier.isEmpty();
    }

    /**
     * @param value {@link #requestIdentifier} (The identifier of the request associated with this response. If an identifier was given as part of the request, it will be reproduced here to enable the requester to more easily identify the response in a multi-request scenario.)
     */
    public GuidanceResponse setRequestIdentifier(Identifier value) { 
      this.requestIdentifier = value;
      return this;
    }

    /**
     * @return {@link #identifier} (Allows a service to provide  unique, business identifiers for the response.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GuidanceResponse setIdentifier(List<Identifier> theIdentifier) { 
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

    public GuidanceResponse addIdentifier(Identifier t) { //3
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
     * @return {@link #module} (An identifier, CodeableConcept or canonical reference to the guidance that was requested.)
     */
    public DataType getModule() { 
      return this.module;
    }

    /**
     * @return {@link #module} (An identifier, CodeableConcept or canonical reference to the guidance that was requested.)
     */
    public UriType getModuleUriType() throws FHIRException { 
      if (this.module == null)
        this.module = new UriType();
      if (!(this.module instanceof UriType))
        throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.module.getClass().getName()+" was encountered");
      return (UriType) this.module;
    }

    public boolean hasModuleUriType() { 
      return this != null && this.module instanceof UriType;
    }

    /**
     * @return {@link #module} (An identifier, CodeableConcept or canonical reference to the guidance that was requested.)
     */
    public CanonicalType getModuleCanonicalType() throws FHIRException { 
      if (this.module == null)
        this.module = new CanonicalType();
      if (!(this.module instanceof CanonicalType))
        throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.module.getClass().getName()+" was encountered");
      return (CanonicalType) this.module;
    }

    public boolean hasModuleCanonicalType() { 
      return this != null && this.module instanceof CanonicalType;
    }

    /**
     * @return {@link #module} (An identifier, CodeableConcept or canonical reference to the guidance that was requested.)
     */
    public CodeableConcept getModuleCodeableConcept() throws FHIRException { 
      if (this.module == null)
        this.module = new CodeableConcept();
      if (!(this.module instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.module.getClass().getName()+" was encountered");
      return (CodeableConcept) this.module;
    }

    public boolean hasModuleCodeableConcept() { 
      return this != null && this.module instanceof CodeableConcept;
    }

    public boolean hasModule() { 
      return this.module != null && !this.module.isEmpty();
    }

    /**
     * @param value {@link #module} (An identifier, CodeableConcept or canonical reference to the guidance that was requested.)
     */
    public GuidanceResponse setModule(DataType value) { 
      if (value != null && !(value instanceof UriType || value instanceof CanonicalType || value instanceof CodeableConcept))
        throw new Error("Not the right type for GuidanceResponse.module[x]: "+value.fhirType());
      this.module = value;
      return this;
    }

    /**
     * @return {@link #status} (The status of the response. If the evaluation is completed successfully, the status will indicate success. However, in order to complete the evaluation, the engine may require more information. In this case, the status will be data-required, and the response will contain a description of the additional required information. If the evaluation completed successfully, but the engine determines that a potentially more accurate response could be provided if more data was available, the status will be data-requested, and the response will contain a description of the additional requested information.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<GuidanceResponseStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GuidanceResponse.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<GuidanceResponseStatus>(new GuidanceResponseStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the response. If the evaluation is completed successfully, the status will indicate success. However, in order to complete the evaluation, the engine may require more information. In this case, the status will be data-required, and the response will contain a description of the additional required information. If the evaluation completed successfully, but the engine determines that a potentially more accurate response could be provided if more data was available, the status will be data-requested, and the response will contain a description of the additional requested information.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public GuidanceResponse setStatusElement(Enumeration<GuidanceResponseStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the response. If the evaluation is completed successfully, the status will indicate success. However, in order to complete the evaluation, the engine may require more information. In this case, the status will be data-required, and the response will contain a description of the additional required information. If the evaluation completed successfully, but the engine determines that a potentially more accurate response could be provided if more data was available, the status will be data-requested, and the response will contain a description of the additional requested information.
     */
    public GuidanceResponseStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the response. If the evaluation is completed successfully, the status will indicate success. However, in order to complete the evaluation, the engine may require more information. In this case, the status will be data-required, and the response will contain a description of the additional required information. If the evaluation completed successfully, but the engine determines that a potentially more accurate response could be provided if more data was available, the status will be data-requested, and the response will contain a description of the additional requested information.
     */
    public GuidanceResponse setStatus(GuidanceResponseStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<GuidanceResponseStatus>(new GuidanceResponseStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #subject} (The patient for which the request was processed.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GuidanceResponse.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The patient for which the request was processed.)
     */
    public GuidanceResponse setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The encounter during which this response was created or to which the creation of this record is tightly associated.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GuidanceResponse.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The encounter during which this response was created or to which the creation of this record is tightly associated.)
     */
    public GuidanceResponse setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #occurrenceDateTime} (Indicates when the guidance response was processed.). This is the underlying object with id, value and extensions. The accessor "getOccurrenceDateTime" gives direct access to the value
     */
    public DateTimeType getOccurrenceDateTimeElement() { 
      if (this.occurrenceDateTime == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GuidanceResponse.occurrenceDateTime");
        else if (Configuration.doAutoCreate())
          this.occurrenceDateTime = new DateTimeType(); // bb
      return this.occurrenceDateTime;
    }

    public boolean hasOccurrenceDateTimeElement() { 
      return this.occurrenceDateTime != null && !this.occurrenceDateTime.isEmpty();
    }

    public boolean hasOccurrenceDateTime() { 
      return this.occurrenceDateTime != null && !this.occurrenceDateTime.isEmpty();
    }

    /**
     * @param value {@link #occurrenceDateTime} (Indicates when the guidance response was processed.). This is the underlying object with id, value and extensions. The accessor "getOccurrenceDateTime" gives direct access to the value
     */
    public GuidanceResponse setOccurrenceDateTimeElement(DateTimeType value) { 
      this.occurrenceDateTime = value;
      return this;
    }

    /**
     * @return Indicates when the guidance response was processed.
     */
    public Date getOccurrenceDateTime() { 
      return this.occurrenceDateTime == null ? null : this.occurrenceDateTime.getValue();
    }

    /**
     * @param value Indicates when the guidance response was processed.
     */
    public GuidanceResponse setOccurrenceDateTime(Date value) { 
      if (value == null)
        this.occurrenceDateTime = null;
      else {
        if (this.occurrenceDateTime == null)
          this.occurrenceDateTime = new DateTimeType();
        this.occurrenceDateTime.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #performer} (Provides a reference to the device that performed the guidance.)
     */
    public Reference getPerformer() { 
      if (this.performer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GuidanceResponse.performer");
        else if (Configuration.doAutoCreate())
          this.performer = new Reference(); // cc
      return this.performer;
    }

    public boolean hasPerformer() { 
      return this.performer != null && !this.performer.isEmpty();
    }

    /**
     * @param value {@link #performer} (Provides a reference to the device that performed the guidance.)
     */
    public GuidanceResponse setPerformer(Reference value) { 
      this.performer = value;
      return this;
    }

    /**
     * @return {@link #reason} (Describes the reason for the guidance response in coded or textual form, or Indicates the reason the request was initiated. This is typically provided as a parameter to the evaluation and echoed by the service, although for some use cases, such as subscription- or event-based scenarios, it may provide an indication of the cause for the response.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GuidanceResponse setReason(List<CodeableReference> theReason) { 
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

    public GuidanceResponse addReason(CodeableReference t) { //3
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
     * @return {@link #note} (Provides a mechanism to communicate additional information about the response.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GuidanceResponse setNote(List<Annotation> theNote) { 
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

    public GuidanceResponse addNote(Annotation t) { //3
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

    /**
     * @return {@link #evaluationMessage} (Messages resulting from the evaluation of the artifact or artifacts. As part of evaluating the request, the engine may produce informational or warning messages. These messages will be provided by this element.)
     */
    public List<Reference> getEvaluationMessage() { 
      if (this.evaluationMessage == null)
        this.evaluationMessage = new ArrayList<Reference>();
      return this.evaluationMessage;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GuidanceResponse setEvaluationMessage(List<Reference> theEvaluationMessage) { 
      this.evaluationMessage = theEvaluationMessage;
      return this;
    }

    public boolean hasEvaluationMessage() { 
      if (this.evaluationMessage == null)
        return false;
      for (Reference item : this.evaluationMessage)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addEvaluationMessage() { //3
      Reference t = new Reference();
      if (this.evaluationMessage == null)
        this.evaluationMessage = new ArrayList<Reference>();
      this.evaluationMessage.add(t);
      return t;
    }

    public GuidanceResponse addEvaluationMessage(Reference t) { //3
      if (t == null)
        return this;
      if (this.evaluationMessage == null)
        this.evaluationMessage = new ArrayList<Reference>();
      this.evaluationMessage.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #evaluationMessage}, creating it if it does not already exist {3}
     */
    public Reference getEvaluationMessageFirstRep() { 
      if (getEvaluationMessage().isEmpty()) {
        addEvaluationMessage();
      }
      return getEvaluationMessage().get(0);
    }

    /**
     * @return {@link #outputParameters} (The output parameters of the evaluation, if any. Many modules will result in the return of specific resources such as procedure or communication requests that are returned as part of the operation result. However, modules may define specific outputs that would be returned as the result of the evaluation, and these would be returned in this element.)
     */
    public Reference getOutputParameters() { 
      if (this.outputParameters == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GuidanceResponse.outputParameters");
        else if (Configuration.doAutoCreate())
          this.outputParameters = new Reference(); // cc
      return this.outputParameters;
    }

    public boolean hasOutputParameters() { 
      return this.outputParameters != null && !this.outputParameters.isEmpty();
    }

    /**
     * @param value {@link #outputParameters} (The output parameters of the evaluation, if any. Many modules will result in the return of specific resources such as procedure or communication requests that are returned as part of the operation result. However, modules may define specific outputs that would be returned as the result of the evaluation, and these would be returned in this element.)
     */
    public GuidanceResponse setOutputParameters(Reference value) { 
      this.outputParameters = value;
      return this;
    }

    /**
     * @return {@link #result} (The actions, if any, produced by the evaluation of the artifact.)
     */
    public Reference getResult() { 
      if (this.result == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create GuidanceResponse.result");
        else if (Configuration.doAutoCreate())
          this.result = new Reference(); // cc
      return this.result;
    }

    public boolean hasResult() { 
      return this.result != null && !this.result.isEmpty();
    }

    /**
     * @param value {@link #result} (The actions, if any, produced by the evaluation of the artifact.)
     */
    public GuidanceResponse setResult(Reference value) { 
      this.result = value;
      return this;
    }

    /**
     * @return {@link #dataRequirement} (If the evaluation could not be completed due to lack of information, or additional information would potentially result in a more accurate response, this element will a description of the data required in order to proceed with the evaluation. A subsequent request to the service should include this data.)
     */
    public List<DataRequirement> getDataRequirement() { 
      if (this.dataRequirement == null)
        this.dataRequirement = new ArrayList<DataRequirement>();
      return this.dataRequirement;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public GuidanceResponse setDataRequirement(List<DataRequirement> theDataRequirement) { 
      this.dataRequirement = theDataRequirement;
      return this;
    }

    public boolean hasDataRequirement() { 
      if (this.dataRequirement == null)
        return false;
      for (DataRequirement item : this.dataRequirement)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DataRequirement addDataRequirement() { //3
      DataRequirement t = new DataRequirement();
      if (this.dataRequirement == null)
        this.dataRequirement = new ArrayList<DataRequirement>();
      this.dataRequirement.add(t);
      return t;
    }

    public GuidanceResponse addDataRequirement(DataRequirement t) { //3
      if (t == null)
        return this;
      if (this.dataRequirement == null)
        this.dataRequirement = new ArrayList<DataRequirement>();
      this.dataRequirement.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dataRequirement}, creating it if it does not already exist {3}
     */
    public DataRequirement getDataRequirementFirstRep() { 
      if (getDataRequirement().isEmpty()) {
        addDataRequirement();
      }
      return getDataRequirement().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("requestIdentifier", "Identifier", "The identifier of the request associated with this response. If an identifier was given as part of the request, it will be reproduced here to enable the requester to more easily identify the response in a multi-request scenario.", 0, 1, requestIdentifier));
        children.add(new Property("identifier", "Identifier", "Allows a service to provide  unique, business identifiers for the response.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("module[x]", "uri|canonical|CodeableConcept", "An identifier, CodeableConcept or canonical reference to the guidance that was requested.", 0, 1, module));
        children.add(new Property("status", "code", "The status of the response. If the evaluation is completed successfully, the status will indicate success. However, in order to complete the evaluation, the engine may require more information. In this case, the status will be data-required, and the response will contain a description of the additional required information. If the evaluation completed successfully, but the engine determines that a potentially more accurate response could be provided if more data was available, the status will be data-requested, and the response will contain a description of the additional requested information.", 0, 1, status));
        children.add(new Property("subject", "Reference(Patient|Group)", "The patient for which the request was processed.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The encounter during which this response was created or to which the creation of this record is tightly associated.", 0, 1, encounter));
        children.add(new Property("occurrenceDateTime", "dateTime", "Indicates when the guidance response was processed.", 0, 1, occurrenceDateTime));
        children.add(new Property("performer", "Reference(Device)", "Provides a reference to the device that performed the guidance.", 0, 1, performer));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Describes the reason for the guidance response in coded or textual form, or Indicates the reason the request was initiated. This is typically provided as a parameter to the evaluation and echoed by the service, although for some use cases, such as subscription- or event-based scenarios, it may provide an indication of the cause for the response.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("note", "Annotation", "Provides a mechanism to communicate additional information about the response.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("evaluationMessage", "Reference(OperationOutcome)", "Messages resulting from the evaluation of the artifact or artifacts. As part of evaluating the request, the engine may produce informational or warning messages. These messages will be provided by this element.", 0, java.lang.Integer.MAX_VALUE, evaluationMessage));
        children.add(new Property("outputParameters", "Reference(Parameters)", "The output parameters of the evaluation, if any. Many modules will result in the return of specific resources such as procedure or communication requests that are returned as part of the operation result. However, modules may define specific outputs that would be returned as the result of the evaluation, and these would be returned in this element.", 0, 1, outputParameters));
        children.add(new Property("result", "Reference(CarePlan|RequestGroup)", "The actions, if any, produced by the evaluation of the artifact.", 0, 1, result));
        children.add(new Property("dataRequirement", "DataRequirement", "If the evaluation could not be completed due to lack of information, or additional information would potentially result in a more accurate response, this element will a description of the data required in order to proceed with the evaluation. A subsequent request to the service should include this data.", 0, java.lang.Integer.MAX_VALUE, dataRequirement));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -354233192: /*requestIdentifier*/  return new Property("requestIdentifier", "Identifier", "The identifier of the request associated with this response. If an identifier was given as part of the request, it will be reproduced here to enable the requester to more easily identify the response in a multi-request scenario.", 0, 1, requestIdentifier);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Allows a service to provide  unique, business identifiers for the response.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1552083308: /*module[x]*/  return new Property("module[x]", "uri|canonical|CodeableConcept", "An identifier, CodeableConcept or canonical reference to the guidance that was requested.", 0, 1, module);
        case -1068784020: /*module*/  return new Property("module[x]", "uri|canonical|CodeableConcept", "An identifier, CodeableConcept or canonical reference to the guidance that was requested.", 0, 1, module);
        case -1552089248: /*moduleUri*/  return new Property("module[x]", "uri", "An identifier, CodeableConcept or canonical reference to the guidance that was requested.", 0, 1, module);
        case -1153656856: /*moduleCanonical*/  return new Property("module[x]", "canonical", "An identifier, CodeableConcept or canonical reference to the guidance that was requested.", 0, 1, module);
        case -1157899371: /*moduleCodeableConcept*/  return new Property("module[x]", "CodeableConcept", "An identifier, CodeableConcept or canonical reference to the guidance that was requested.", 0, 1, module);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the response. If the evaluation is completed successfully, the status will indicate success. However, in order to complete the evaluation, the engine may require more information. In this case, the status will be data-required, and the response will contain a description of the additional required information. If the evaluation completed successfully, but the engine determines that a potentially more accurate response could be provided if more data was available, the status will be data-requested, and the response will contain a description of the additional requested information.", 0, 1, status);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The patient for which the request was processed.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The encounter during which this response was created or to which the creation of this record is tightly associated.", 0, 1, encounter);
        case -298443636: /*occurrenceDateTime*/  return new Property("occurrenceDateTime", "dateTime", "Indicates when the guidance response was processed.", 0, 1, occurrenceDateTime);
        case 481140686: /*performer*/  return new Property("performer", "Reference(Device)", "Provides a reference to the device that performed the guidance.", 0, 1, performer);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Describes the reason for the guidance response in coded or textual form, or Indicates the reason the request was initiated. This is typically provided as a parameter to the evaluation and echoed by the service, although for some use cases, such as subscription- or event-based scenarios, it may provide an indication of the cause for the response.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Provides a mechanism to communicate additional information about the response.", 0, java.lang.Integer.MAX_VALUE, note);
        case 1081619755: /*evaluationMessage*/  return new Property("evaluationMessage", "Reference(OperationOutcome)", "Messages resulting from the evaluation of the artifact or artifacts. As part of evaluating the request, the engine may produce informational or warning messages. These messages will be provided by this element.", 0, java.lang.Integer.MAX_VALUE, evaluationMessage);
        case 525609419: /*outputParameters*/  return new Property("outputParameters", "Reference(Parameters)", "The output parameters of the evaluation, if any. Many modules will result in the return of specific resources such as procedure or communication requests that are returned as part of the operation result. However, modules may define specific outputs that would be returned as the result of the evaluation, and these would be returned in this element.", 0, 1, outputParameters);
        case -934426595: /*result*/  return new Property("result", "Reference(CarePlan|RequestGroup)", "The actions, if any, produced by the evaluation of the artifact.", 0, 1, result);
        case 629147193: /*dataRequirement*/  return new Property("dataRequirement", "DataRequirement", "If the evaluation could not be completed due to lack of information, or additional information would potentially result in a more accurate response, this element will a description of the data required in order to proceed with the evaluation. A subsequent request to the service should include this data.", 0, java.lang.Integer.MAX_VALUE, dataRequirement);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -354233192: /*requestIdentifier*/ return this.requestIdentifier == null ? new Base[0] : new Base[] {this.requestIdentifier}; // Identifier
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1068784020: /*module*/ return this.module == null ? new Base[0] : new Base[] {this.module}; // DataType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<GuidanceResponseStatus>
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -298443636: /*occurrenceDateTime*/ return this.occurrenceDateTime == null ? new Base[0] : new Base[] {this.occurrenceDateTime}; // DateTimeType
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : new Base[] {this.performer}; // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 1081619755: /*evaluationMessage*/ return this.evaluationMessage == null ? new Base[0] : this.evaluationMessage.toArray(new Base[this.evaluationMessage.size()]); // Reference
        case 525609419: /*outputParameters*/ return this.outputParameters == null ? new Base[0] : new Base[] {this.outputParameters}; // Reference
        case -934426595: /*result*/ return this.result == null ? new Base[0] : new Base[] {this.result}; // Reference
        case 629147193: /*dataRequirement*/ return this.dataRequirement == null ? new Base[0] : this.dataRequirement.toArray(new Base[this.dataRequirement.size()]); // DataRequirement
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -354233192: // requestIdentifier
          this.requestIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1068784020: // module
          this.module = TypeConvertor.castToType(value); // DataType
          return value;
        case -892481550: // status
          value = new GuidanceResponseStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<GuidanceResponseStatus>
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -298443636: // occurrenceDateTime
          this.occurrenceDateTime = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 481140686: // performer
          this.performer = TypeConvertor.castToReference(value); // Reference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 1081619755: // evaluationMessage
          this.getEvaluationMessage().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 525609419: // outputParameters
          this.outputParameters = TypeConvertor.castToReference(value); // Reference
          return value;
        case -934426595: // result
          this.result = TypeConvertor.castToReference(value); // Reference
          return value;
        case 629147193: // dataRequirement
          this.getDataRequirement().add(TypeConvertor.castToDataRequirement(value)); // DataRequirement
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("requestIdentifier")) {
          this.requestIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("module[x]")) {
          this.module = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("status")) {
          value = new GuidanceResponseStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<GuidanceResponseStatus>
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("occurrenceDateTime")) {
          this.occurrenceDateTime = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("performer")) {
          this.performer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("evaluationMessage")) {
          this.getEvaluationMessage().add(TypeConvertor.castToReference(value));
        } else if (name.equals("outputParameters")) {
          this.outputParameters = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("result")) {
          this.result = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("dataRequirement")) {
          this.getDataRequirement().add(TypeConvertor.castToDataRequirement(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -354233192:  return getRequestIdentifier();
        case -1618432855:  return addIdentifier(); 
        case -1552083308:  return getModule();
        case -1068784020:  return getModule();
        case -892481550:  return getStatusElement();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -298443636:  return getOccurrenceDateTimeElement();
        case 481140686:  return getPerformer();
        case -934964668:  return addReason(); 
        case 3387378:  return addNote(); 
        case 1081619755:  return addEvaluationMessage(); 
        case 525609419:  return getOutputParameters();
        case -934426595:  return getResult();
        case 629147193:  return addDataRequirement(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -354233192: /*requestIdentifier*/ return new String[] {"Identifier"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1068784020: /*module*/ return new String[] {"uri", "canonical", "CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -298443636: /*occurrenceDateTime*/ return new String[] {"dateTime"};
        case 481140686: /*performer*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 1081619755: /*evaluationMessage*/ return new String[] {"Reference"};
        case 525609419: /*outputParameters*/ return new String[] {"Reference"};
        case -934426595: /*result*/ return new String[] {"Reference"};
        case 629147193: /*dataRequirement*/ return new String[] {"DataRequirement"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("requestIdentifier")) {
          this.requestIdentifier = new Identifier();
          return this.requestIdentifier;
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("moduleUri")) {
          this.module = new UriType();
          return this.module;
        }
        else if (name.equals("moduleCanonical")) {
          this.module = new CanonicalType();
          return this.module;
        }
        else if (name.equals("moduleCodeableConcept")) {
          this.module = new CodeableConcept();
          return this.module;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type GuidanceResponse.status");
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("occurrenceDateTime")) {
          throw new FHIRException("Cannot call addChild on a primitive type GuidanceResponse.occurrenceDateTime");
        }
        else if (name.equals("performer")) {
          this.performer = new Reference();
          return this.performer;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("evaluationMessage")) {
          return addEvaluationMessage();
        }
        else if (name.equals("outputParameters")) {
          this.outputParameters = new Reference();
          return this.outputParameters;
        }
        else if (name.equals("result")) {
          this.result = new Reference();
          return this.result;
        }
        else if (name.equals("dataRequirement")) {
          return addDataRequirement();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "GuidanceResponse";

  }

      public GuidanceResponse copy() {
        GuidanceResponse dst = new GuidanceResponse();
        copyValues(dst);
        return dst;
      }

      public void copyValues(GuidanceResponse dst) {
        super.copyValues(dst);
        dst.requestIdentifier = requestIdentifier == null ? null : requestIdentifier.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.module = module == null ? null : module.copy();
        dst.status = status == null ? null : status.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.occurrenceDateTime = occurrenceDateTime == null ? null : occurrenceDateTime.copy();
        dst.performer = performer == null ? null : performer.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (evaluationMessage != null) {
          dst.evaluationMessage = new ArrayList<Reference>();
          for (Reference i : evaluationMessage)
            dst.evaluationMessage.add(i.copy());
        };
        dst.outputParameters = outputParameters == null ? null : outputParameters.copy();
        dst.result = result == null ? null : result.copy();
        if (dataRequirement != null) {
          dst.dataRequirement = new ArrayList<DataRequirement>();
          for (DataRequirement i : dataRequirement)
            dst.dataRequirement.add(i.copy());
        };
      }

      protected GuidanceResponse typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof GuidanceResponse))
          return false;
        GuidanceResponse o = (GuidanceResponse) other_;
        return compareDeep(requestIdentifier, o.requestIdentifier, true) && compareDeep(identifier, o.identifier, true)
           && compareDeep(module, o.module, true) && compareDeep(status, o.status, true) && compareDeep(subject, o.subject, true)
           && compareDeep(encounter, o.encounter, true) && compareDeep(occurrenceDateTime, o.occurrenceDateTime, true)
           && compareDeep(performer, o.performer, true) && compareDeep(reason, o.reason, true) && compareDeep(note, o.note, true)
           && compareDeep(evaluationMessage, o.evaluationMessage, true) && compareDeep(outputParameters, o.outputParameters, true)
           && compareDeep(result, o.result, true) && compareDeep(dataRequirement, o.dataRequirement, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof GuidanceResponse))
          return false;
        GuidanceResponse o = (GuidanceResponse) other_;
        return compareValues(status, o.status, true) && compareValues(occurrenceDateTime, o.occurrenceDateTime, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(requestIdentifier, identifier
          , module, status, subject, encounter, occurrenceDateTime, performer, reason, note
          , evaluationMessage, outputParameters, result, dataRequirement);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.GuidanceResponse;
   }


}

