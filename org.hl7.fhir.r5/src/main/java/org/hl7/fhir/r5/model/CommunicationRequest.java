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
 * A request to convey information; e.g. the CDS system proposes that an alert be sent to a responsible provider, the CDS system proposes that the public health agency be notified about a reportable condition.
 */
@ResourceDef(name="CommunicationRequest", profile="http://hl7.org/fhir/StructureDefinition/CommunicationRequest")
public class CommunicationRequest extends DomainResource {

    @Block()
    public static class CommunicationRequestPayloadComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The communicated content (or for multi-part communications, one portion of the communication).
         */
        @Child(name = "content", type = {Attachment.class, Reference.class, CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Message part content", formalDefinition="The communicated content (or for multi-part communications, one portion of the communication)." )
        protected DataType content;

        private static final long serialVersionUID = -1954179063L;

    /**
     * Constructor
     */
      public CommunicationRequestPayloadComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CommunicationRequestPayloadComponent(DataType content) {
        super();
        this.setContent(content);
      }

        /**
         * @return {@link #content} (The communicated content (or for multi-part communications, one portion of the communication).)
         */
        public DataType getContent() { 
          return this.content;
        }

        /**
         * @return {@link #content} (The communicated content (or for multi-part communications, one portion of the communication).)
         */
        public Attachment getContentAttachment() throws FHIRException { 
          if (this.content == null)
            this.content = new Attachment();
          if (!(this.content instanceof Attachment))
            throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.content.getClass().getName()+" was encountered");
          return (Attachment) this.content;
        }

        public boolean hasContentAttachment() { 
          return this != null && this.content instanceof Attachment;
        }

        /**
         * @return {@link #content} (The communicated content (or for multi-part communications, one portion of the communication).)
         */
        public Reference getContentReference() throws FHIRException { 
          if (this.content == null)
            this.content = new Reference();
          if (!(this.content instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.content.getClass().getName()+" was encountered");
          return (Reference) this.content;
        }

        public boolean hasContentReference() { 
          return this != null && this.content instanceof Reference;
        }

        /**
         * @return {@link #content} (The communicated content (or for multi-part communications, one portion of the communication).)
         */
        public CodeableConcept getContentCodeableConcept() throws FHIRException { 
          if (this.content == null)
            this.content = new CodeableConcept();
          if (!(this.content instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.content.getClass().getName()+" was encountered");
          return (CodeableConcept) this.content;
        }

        public boolean hasContentCodeableConcept() { 
          return this != null && this.content instanceof CodeableConcept;
        }

        public boolean hasContent() { 
          return this.content != null && !this.content.isEmpty();
        }

        /**
         * @param value {@link #content} (The communicated content (or for multi-part communications, one portion of the communication).)
         */
        public CommunicationRequestPayloadComponent setContent(DataType value) { 
          if (value != null && !(value instanceof Attachment || value instanceof Reference || value instanceof CodeableConcept))
            throw new Error("Not the right type for CommunicationRequest.payload.content[x]: "+value.fhirType());
          this.content = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("content[x]", "Attachment|Reference(Any)|CodeableConcept", "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1, content));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 264548711: /*content[x]*/  return new Property("content[x]", "Attachment|Reference(Any)|CodeableConcept", "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1, content);
          case 951530617: /*content*/  return new Property("content[x]", "Attachment|Reference(Any)|CodeableConcept", "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1, content);
          case -702028164: /*contentAttachment*/  return new Property("content[x]", "Attachment", "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1, content);
          case 1193747154: /*contentReference*/  return new Property("content[x]", "Reference(Any)", "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1, content);
          case 1554698728: /*contentCodeableConcept*/  return new Property("content[x]", "CodeableConcept", "The communicated content (or for multi-part communications, one portion of the communication).", 0, 1, content);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 951530617: /*content*/ return this.content == null ? new Base[0] : new Base[] {this.content}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 951530617: // content
          this.content = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("content[x]")) {
          this.content = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 264548711:  return getContent();
        case 951530617:  return getContent();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 951530617: /*content*/ return new String[] {"Attachment", "Reference", "CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("contentAttachment")) {
          this.content = new Attachment();
          return this.content;
        }
        else if (name.equals("contentReference")) {
          this.content = new Reference();
          return this.content;
        }
        else if (name.equals("contentCodeableConcept")) {
          this.content = new CodeableConcept();
          return this.content;
        }
        else
          return super.addChild(name);
      }

      public CommunicationRequestPayloadComponent copy() {
        CommunicationRequestPayloadComponent dst = new CommunicationRequestPayloadComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CommunicationRequestPayloadComponent dst) {
        super.copyValues(dst);
        dst.content = content == null ? null : content.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CommunicationRequestPayloadComponent))
          return false;
        CommunicationRequestPayloadComponent o = (CommunicationRequestPayloadComponent) other_;
        return compareDeep(content, o.content, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CommunicationRequestPayloadComponent))
          return false;
        CommunicationRequestPayloadComponent o = (CommunicationRequestPayloadComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(content);
      }

  public String fhirType() {
    return "CommunicationRequest.payload";

  }

  }

    /**
     * Business identifiers assigned to this communication request by the performer or other systems which remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique identifier", formalDefinition="Business identifiers assigned to this communication request by the performer or other systems which remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * A plan or proposal that is fulfilled in whole or in part by this request.
     */
    @Child(name = "basedOn", type = {Reference.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Fulfills plan or proposal", formalDefinition="A plan or proposal that is fulfilled in whole or in part by this request." )
    protected List<Reference> basedOn;

    /**
     * Completed or terminated request(s) whose function is taken by this new request.
     */
    @Child(name = "replaces", type = {CommunicationRequest.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Request(s) replaced by this request", formalDefinition="Completed or terminated request(s) whose function is taken by this new request." )
    protected List<Reference> replaces;

    /**
     * A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.
     */
    @Child(name = "groupIdentifier", type = {Identifier.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Composite request this is part of", formalDefinition="A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form." )
    protected Identifier groupIdentifier;

    /**
     * The status of the proposal or order.
     */
    @Child(name = "status", type = {CodeType.class}, order=4, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | on-hold | revoked | completed | entered-in-error | unknown", formalDefinition="The status of the proposal or order." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-status")
    protected Enumeration<RequestStatus> status;

    /**
     * Captures the reason for the current state of the CommunicationRequest.
     */
    @Child(name = "statusReason", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reason for current status", formalDefinition="Captures the reason for the current state of the CommunicationRequest." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/communication-request-status-reason")
    protected CodeableConcept statusReason;

    /**
     * The type of message to be sent such as alert, notification, reminder, instruction, etc.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Message category", formalDefinition="The type of message to be sent such as alert, notification, reminder, instruction, etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/communication-category")
    protected List<CodeableConcept> category;

    /**
     * Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat, urgent, routine.
     */
    @Child(name = "priority", type = {CodeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="routine | urgent | asap | stat", formalDefinition="Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat, urgent, routine." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-priority")
    protected Enumeration<RequestPriority> priority;

    /**
     * If true indicates that the CommunicationRequest is asking for the specified action to *not* occur.
     */
    @Child(name = "doNotPerform", type = {BooleanType.class}, order=8, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="True if request is prohibiting action", formalDefinition="If true indicates that the CommunicationRequest is asking for the specified action to *not* occur." )
    protected BooleanType doNotPerform;

    /**
     * A channel that was used for this communication (e.g. email, fax).
     */
    @Child(name = "medium", type = {CodeableConcept.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A channel of communication", formalDefinition="A channel that was used for this communication (e.g. email, fax)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ParticipationMode")
    protected List<CodeableConcept> medium;

    /**
     * The patient or group that is the focus of this communication request.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Focus of message", formalDefinition="The patient or group that is the focus of this communication request." )
    protected Reference subject;

    /**
     * Other resources that pertain to this communication request and to which this communication request should be associated.
     */
    @Child(name = "about", type = {Reference.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Resources that pertain to this communication request", formalDefinition="Other resources that pertain to this communication request and to which this communication request should be associated." )
    protected List<Reference> about;

    /**
     * The Encounter during which this CommunicationRequest was created or to which the creation of this record is tightly associated.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The Encounter during which this CommunicationRequest was created", formalDefinition="The Encounter during which this CommunicationRequest was created or to which the creation of this record is tightly associated." )
    protected Reference encounter;

    /**
     * Text, attachment(s), or resource(s) to be communicated to the recipient.
     */
    @Child(name = "payload", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Message payload", formalDefinition="Text, attachment(s), or resource(s) to be communicated to the recipient." )
    protected List<CommunicationRequestPayloadComponent> payload;

    /**
     * The time when this communication is to occur.
     */
    @Child(name = "occurrence", type = {DateTimeType.class, Period.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When scheduled", formalDefinition="The time when this communication is to occur." )
    protected DataType occurrence;

    /**
     * For draft requests, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.
     */
    @Child(name = "authoredOn", type = {DateTimeType.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When request transitioned to being actionable", formalDefinition="For draft requests, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation." )
    protected DateTimeType authoredOn;

    /**
     * The device, individual, or organization who asks for the information to be shared.
     */
    @Child(name = "requester", type = {Practitioner.class, PractitionerRole.class, Organization.class, Patient.class, RelatedPerson.class, Device.class}, order=16, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who asks for the information to be shared", formalDefinition="The device, individual, or organization who asks for the information to be shared." )
    protected Reference requester;

    /**
     * The entity (e.g. person, organization, clinical information system, device, group, or care team) which is the intended target of the communication.
     */
    @Child(name = "recipient", type = {Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, Group.class, CareTeam.class, HealthcareService.class, Endpoint.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who to share the information with", formalDefinition="The entity (e.g. person, organization, clinical information system, device, group, or care team) which is the intended target of the communication." )
    protected List<Reference> recipient;

    /**
     * The entity (e.g. person, organization, clinical information system, or device) which is to be the source of the communication.
     */
    @Child(name = "informationProvider", type = {Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, HealthcareService.class, Endpoint.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who should share the information", formalDefinition="The entity (e.g. person, organization, clinical information system, or device) which is to be the source of the communication." )
    protected List<Reference> informationProvider;

    /**
     * Describes why the request is being made in coded or textual form.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Why is communication needed?", formalDefinition="Describes why the request is being made in coded or textual form." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ActReason")
    protected List<CodeableReference> reason;

    /**
     * Comments made about the request by the requester, sender, recipient, subject or other participants.
     */
    @Child(name = "note", type = {Annotation.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments made about communication request", formalDefinition="Comments made about the request by the requester, sender, recipient, subject or other participants." )
    protected List<Annotation> note;

    private static final long serialVersionUID = 239948247L;

  /**
   * Constructor
   */
    public CommunicationRequest() {
      super();
    }

  /**
   * Constructor
   */
    public CommunicationRequest(RequestStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this communication request by the performer or other systems which remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CommunicationRequest setIdentifier(List<Identifier> theIdentifier) { 
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

    public CommunicationRequest addIdentifier(Identifier t) { //3
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
     * @return {@link #basedOn} (A plan or proposal that is fulfilled in whole or in part by this request.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CommunicationRequest setBasedOn(List<Reference> theBasedOn) { 
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

    public CommunicationRequest addBasedOn(Reference t) { //3
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
     * @return {@link #replaces} (Completed or terminated request(s) whose function is taken by this new request.)
     */
    public List<Reference> getReplaces() { 
      if (this.replaces == null)
        this.replaces = new ArrayList<Reference>();
      return this.replaces;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CommunicationRequest setReplaces(List<Reference> theReplaces) { 
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

    public CommunicationRequest addReplaces(Reference t) { //3
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
     * @return {@link #groupIdentifier} (A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.)
     */
    public Identifier getGroupIdentifier() { 
      if (this.groupIdentifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CommunicationRequest.groupIdentifier");
        else if (Configuration.doAutoCreate())
          this.groupIdentifier = new Identifier(); // cc
      return this.groupIdentifier;
    }

    public boolean hasGroupIdentifier() { 
      return this.groupIdentifier != null && !this.groupIdentifier.isEmpty();
    }

    /**
     * @param value {@link #groupIdentifier} (A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.)
     */
    public CommunicationRequest setGroupIdentifier(Identifier value) { 
      this.groupIdentifier = value;
      return this;
    }

    /**
     * @return {@link #status} (The status of the proposal or order.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<RequestStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CommunicationRequest.status");
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
     * @param value {@link #status} (The status of the proposal or order.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public CommunicationRequest setStatusElement(Enumeration<RequestStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the proposal or order.
     */
    public RequestStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the proposal or order.
     */
    public CommunicationRequest setStatus(RequestStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<RequestStatus>(new RequestStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #statusReason} (Captures the reason for the current state of the CommunicationRequest.)
     */
    public CodeableConcept getStatusReason() { 
      if (this.statusReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CommunicationRequest.statusReason");
        else if (Configuration.doAutoCreate())
          this.statusReason = new CodeableConcept(); // cc
      return this.statusReason;
    }

    public boolean hasStatusReason() { 
      return this.statusReason != null && !this.statusReason.isEmpty();
    }

    /**
     * @param value {@link #statusReason} (Captures the reason for the current state of the CommunicationRequest.)
     */
    public CommunicationRequest setStatusReason(CodeableConcept value) { 
      this.statusReason = value;
      return this;
    }

    /**
     * @return {@link #category} (The type of message to be sent such as alert, notification, reminder, instruction, etc.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CommunicationRequest setCategory(List<CodeableConcept> theCategory) { 
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

    public CommunicationRequest addCategory(CodeableConcept t) { //3
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
     * @return {@link #priority} (Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat, urgent, routine.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Enumeration<RequestPriority> getPriorityElement() { 
      if (this.priority == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CommunicationRequest.priority");
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
     * @param value {@link #priority} (Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat, urgent, routine.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public CommunicationRequest setPriorityElement(Enumeration<RequestPriority> value) { 
      this.priority = value;
      return this;
    }

    /**
     * @return Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat, urgent, routine.
     */
    public RequestPriority getPriority() { 
      return this.priority == null ? null : this.priority.getValue();
    }

    /**
     * @param value Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat, urgent, routine.
     */
    public CommunicationRequest setPriority(RequestPriority value) { 
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
     * @return {@link #doNotPerform} (If true indicates that the CommunicationRequest is asking for the specified action to *not* occur.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
     */
    public BooleanType getDoNotPerformElement() { 
      if (this.doNotPerform == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CommunicationRequest.doNotPerform");
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
     * @param value {@link #doNotPerform} (If true indicates that the CommunicationRequest is asking for the specified action to *not* occur.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
     */
    public CommunicationRequest setDoNotPerformElement(BooleanType value) { 
      this.doNotPerform = value;
      return this;
    }

    /**
     * @return If true indicates that the CommunicationRequest is asking for the specified action to *not* occur.
     */
    public boolean getDoNotPerform() { 
      return this.doNotPerform == null || this.doNotPerform.isEmpty() ? false : this.doNotPerform.getValue();
    }

    /**
     * @param value If true indicates that the CommunicationRequest is asking for the specified action to *not* occur.
     */
    public CommunicationRequest setDoNotPerform(boolean value) { 
        if (this.doNotPerform == null)
          this.doNotPerform = new BooleanType();
        this.doNotPerform.setValue(value);
      return this;
    }

    /**
     * @return {@link #medium} (A channel that was used for this communication (e.g. email, fax).)
     */
    public List<CodeableConcept> getMedium() { 
      if (this.medium == null)
        this.medium = new ArrayList<CodeableConcept>();
      return this.medium;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CommunicationRequest setMedium(List<CodeableConcept> theMedium) { 
      this.medium = theMedium;
      return this;
    }

    public boolean hasMedium() { 
      if (this.medium == null)
        return false;
      for (CodeableConcept item : this.medium)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addMedium() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.medium == null)
        this.medium = new ArrayList<CodeableConcept>();
      this.medium.add(t);
      return t;
    }

    public CommunicationRequest addMedium(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.medium == null)
        this.medium = new ArrayList<CodeableConcept>();
      this.medium.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #medium}, creating it if it does not already exist {3}
     */
    public CodeableConcept getMediumFirstRep() { 
      if (getMedium().isEmpty()) {
        addMedium();
      }
      return getMedium().get(0);
    }

    /**
     * @return {@link #subject} (The patient or group that is the focus of this communication request.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CommunicationRequest.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The patient or group that is the focus of this communication request.)
     */
    public CommunicationRequest setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #about} (Other resources that pertain to this communication request and to which this communication request should be associated.)
     */
    public List<Reference> getAbout() { 
      if (this.about == null)
        this.about = new ArrayList<Reference>();
      return this.about;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CommunicationRequest setAbout(List<Reference> theAbout) { 
      this.about = theAbout;
      return this;
    }

    public boolean hasAbout() { 
      if (this.about == null)
        return false;
      for (Reference item : this.about)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addAbout() { //3
      Reference t = new Reference();
      if (this.about == null)
        this.about = new ArrayList<Reference>();
      this.about.add(t);
      return t;
    }

    public CommunicationRequest addAbout(Reference t) { //3
      if (t == null)
        return this;
      if (this.about == null)
        this.about = new ArrayList<Reference>();
      this.about.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #about}, creating it if it does not already exist {3}
     */
    public Reference getAboutFirstRep() { 
      if (getAbout().isEmpty()) {
        addAbout();
      }
      return getAbout().get(0);
    }

    /**
     * @return {@link #encounter} (The Encounter during which this CommunicationRequest was created or to which the creation of this record is tightly associated.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CommunicationRequest.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The Encounter during which this CommunicationRequest was created or to which the creation of this record is tightly associated.)
     */
    public CommunicationRequest setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #payload} (Text, attachment(s), or resource(s) to be communicated to the recipient.)
     */
    public List<CommunicationRequestPayloadComponent> getPayload() { 
      if (this.payload == null)
        this.payload = new ArrayList<CommunicationRequestPayloadComponent>();
      return this.payload;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CommunicationRequest setPayload(List<CommunicationRequestPayloadComponent> thePayload) { 
      this.payload = thePayload;
      return this;
    }

    public boolean hasPayload() { 
      if (this.payload == null)
        return false;
      for (CommunicationRequestPayloadComponent item : this.payload)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CommunicationRequestPayloadComponent addPayload() { //3
      CommunicationRequestPayloadComponent t = new CommunicationRequestPayloadComponent();
      if (this.payload == null)
        this.payload = new ArrayList<CommunicationRequestPayloadComponent>();
      this.payload.add(t);
      return t;
    }

    public CommunicationRequest addPayload(CommunicationRequestPayloadComponent t) { //3
      if (t == null)
        return this;
      if (this.payload == null)
        this.payload = new ArrayList<CommunicationRequestPayloadComponent>();
      this.payload.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #payload}, creating it if it does not already exist {3}
     */
    public CommunicationRequestPayloadComponent getPayloadFirstRep() { 
      if (getPayload().isEmpty()) {
        addPayload();
      }
      return getPayload().get(0);
    }

    /**
     * @return {@link #occurrence} (The time when this communication is to occur.)
     */
    public DataType getOccurrence() { 
      return this.occurrence;
    }

    /**
     * @return {@link #occurrence} (The time when this communication is to occur.)
     */
    public DateTimeType getOccurrenceDateTimeType() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new DateTimeType();
      if (!(this.occurrence instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (DateTimeType) this.occurrence;
    }

    public boolean hasOccurrenceDateTimeType() { 
      return this != null && this.occurrence instanceof DateTimeType;
    }

    /**
     * @return {@link #occurrence} (The time when this communication is to occur.)
     */
    public Period getOccurrencePeriod() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Period();
      if (!(this.occurrence instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Period) this.occurrence;
    }

    public boolean hasOccurrencePeriod() { 
      return this != null && this.occurrence instanceof Period;
    }

    public boolean hasOccurrence() { 
      return this.occurrence != null && !this.occurrence.isEmpty();
    }

    /**
     * @param value {@link #occurrence} (The time when this communication is to occur.)
     */
    public CommunicationRequest setOccurrence(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period))
        throw new Error("Not the right type for CommunicationRequest.occurrence[x]: "+value.fhirType());
      this.occurrence = value;
      return this;
    }

    /**
     * @return {@link #authoredOn} (For draft requests, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public DateTimeType getAuthoredOnElement() { 
      if (this.authoredOn == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CommunicationRequest.authoredOn");
        else if (Configuration.doAutoCreate())
          this.authoredOn = new DateTimeType(); // bb
      return this.authoredOn;
    }

    public boolean hasAuthoredOnElement() { 
      return this.authoredOn != null && !this.authoredOn.isEmpty();
    }

    public boolean hasAuthoredOn() { 
      return this.authoredOn != null && !this.authoredOn.isEmpty();
    }

    /**
     * @param value {@link #authoredOn} (For draft requests, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public CommunicationRequest setAuthoredOnElement(DateTimeType value) { 
      this.authoredOn = value;
      return this;
    }

    /**
     * @return For draft requests, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.
     */
    public Date getAuthoredOn() { 
      return this.authoredOn == null ? null : this.authoredOn.getValue();
    }

    /**
     * @param value For draft requests, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.
     */
    public CommunicationRequest setAuthoredOn(Date value) { 
      if (value == null)
        this.authoredOn = null;
      else {
        if (this.authoredOn == null)
          this.authoredOn = new DateTimeType();
        this.authoredOn.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #requester} (The device, individual, or organization who asks for the information to be shared.)
     */
    public Reference getRequester() { 
      if (this.requester == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CommunicationRequest.requester");
        else if (Configuration.doAutoCreate())
          this.requester = new Reference(); // cc
      return this.requester;
    }

    public boolean hasRequester() { 
      return this.requester != null && !this.requester.isEmpty();
    }

    /**
     * @param value {@link #requester} (The device, individual, or organization who asks for the information to be shared.)
     */
    public CommunicationRequest setRequester(Reference value) { 
      this.requester = value;
      return this;
    }

    /**
     * @return {@link #recipient} (The entity (e.g. person, organization, clinical information system, device, group, or care team) which is the intended target of the communication.)
     */
    public List<Reference> getRecipient() { 
      if (this.recipient == null)
        this.recipient = new ArrayList<Reference>();
      return this.recipient;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CommunicationRequest setRecipient(List<Reference> theRecipient) { 
      this.recipient = theRecipient;
      return this;
    }

    public boolean hasRecipient() { 
      if (this.recipient == null)
        return false;
      for (Reference item : this.recipient)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addRecipient() { //3
      Reference t = new Reference();
      if (this.recipient == null)
        this.recipient = new ArrayList<Reference>();
      this.recipient.add(t);
      return t;
    }

    public CommunicationRequest addRecipient(Reference t) { //3
      if (t == null)
        return this;
      if (this.recipient == null)
        this.recipient = new ArrayList<Reference>();
      this.recipient.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #recipient}, creating it if it does not already exist {3}
     */
    public Reference getRecipientFirstRep() { 
      if (getRecipient().isEmpty()) {
        addRecipient();
      }
      return getRecipient().get(0);
    }

    /**
     * @return {@link #informationProvider} (The entity (e.g. person, organization, clinical information system, or device) which is to be the source of the communication.)
     */
    public List<Reference> getInformationProvider() { 
      if (this.informationProvider == null)
        this.informationProvider = new ArrayList<Reference>();
      return this.informationProvider;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CommunicationRequest setInformationProvider(List<Reference> theInformationProvider) { 
      this.informationProvider = theInformationProvider;
      return this;
    }

    public boolean hasInformationProvider() { 
      if (this.informationProvider == null)
        return false;
      for (Reference item : this.informationProvider)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addInformationProvider() { //3
      Reference t = new Reference();
      if (this.informationProvider == null)
        this.informationProvider = new ArrayList<Reference>();
      this.informationProvider.add(t);
      return t;
    }

    public CommunicationRequest addInformationProvider(Reference t) { //3
      if (t == null)
        return this;
      if (this.informationProvider == null)
        this.informationProvider = new ArrayList<Reference>();
      this.informationProvider.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #informationProvider}, creating it if it does not already exist {3}
     */
    public Reference getInformationProviderFirstRep() { 
      if (getInformationProvider().isEmpty()) {
        addInformationProvider();
      }
      return getInformationProvider().get(0);
    }

    /**
     * @return {@link #reason} (Describes why the request is being made in coded or textual form.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CommunicationRequest setReason(List<CodeableReference> theReason) { 
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

    public CommunicationRequest addReason(CodeableReference t) { //3
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
     * @return {@link #note} (Comments made about the request by the requester, sender, recipient, subject or other participants.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CommunicationRequest setNote(List<Annotation> theNote) { 
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

    public CommunicationRequest addNote(Annotation t) { //3
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
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this communication request by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(Any)", "A plan or proposal that is fulfilled in whole or in part by this request.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("replaces", "Reference(CommunicationRequest)", "Completed or terminated request(s) whose function is taken by this new request.", 0, java.lang.Integer.MAX_VALUE, replaces));
        children.add(new Property("groupIdentifier", "Identifier", "A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.", 0, 1, groupIdentifier));
        children.add(new Property("status", "code", "The status of the proposal or order.", 0, 1, status));
        children.add(new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the CommunicationRequest.", 0, 1, statusReason));
        children.add(new Property("category", "CodeableConcept", "The type of message to be sent such as alert, notification, reminder, instruction, etc.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("priority", "code", "Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat, urgent, routine.", 0, 1, priority));
        children.add(new Property("doNotPerform", "boolean", "If true indicates that the CommunicationRequest is asking for the specified action to *not* occur.", 0, 1, doNotPerform));
        children.add(new Property("medium", "CodeableConcept", "A channel that was used for this communication (e.g. email, fax).", 0, java.lang.Integer.MAX_VALUE, medium));
        children.add(new Property("subject", "Reference(Patient|Group)", "The patient or group that is the focus of this communication request.", 0, 1, subject));
        children.add(new Property("about", "Reference(Any)", "Other resources that pertain to this communication request and to which this communication request should be associated.", 0, java.lang.Integer.MAX_VALUE, about));
        children.add(new Property("encounter", "Reference(Encounter)", "The Encounter during which this CommunicationRequest was created or to which the creation of this record is tightly associated.", 0, 1, encounter));
        children.add(new Property("payload", "", "Text, attachment(s), or resource(s) to be communicated to the recipient.", 0, java.lang.Integer.MAX_VALUE, payload));
        children.add(new Property("occurrence[x]", "dateTime|Period", "The time when this communication is to occur.", 0, 1, occurrence));
        children.add(new Property("authoredOn", "dateTime", "For draft requests, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.", 0, 1, authoredOn));
        children.add(new Property("requester", "Reference(Practitioner|PractitionerRole|Organization|Patient|RelatedPerson|Device)", "The device, individual, or organization who asks for the information to be shared.", 0, 1, requester));
        children.add(new Property("recipient", "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson|Group|CareTeam|HealthcareService|Endpoint)", "The entity (e.g. person, organization, clinical information system, device, group, or care team) which is the intended target of the communication.", 0, java.lang.Integer.MAX_VALUE, recipient));
        children.add(new Property("informationProvider", "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson|HealthcareService|Endpoint)", "The entity (e.g. person, organization, clinical information system, or device) which is to be the source of the communication.", 0, java.lang.Integer.MAX_VALUE, informationProvider));
        children.add(new Property("reason", "CodeableReference(Any)", "Describes why the request is being made in coded or textual form.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("note", "Annotation", "Comments made about the request by the requester, sender, recipient, subject or other participants.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this communication request by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(Any)", "A plan or proposal that is fulfilled in whole or in part by this request.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -430332865: /*replaces*/  return new Property("replaces", "Reference(CommunicationRequest)", "Completed or terminated request(s) whose function is taken by this new request.", 0, java.lang.Integer.MAX_VALUE, replaces);
        case -445338488: /*groupIdentifier*/  return new Property("groupIdentifier", "Identifier", "A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.", 0, 1, groupIdentifier);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the proposal or order.", 0, 1, status);
        case 2051346646: /*statusReason*/  return new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the CommunicationRequest.", 0, 1, statusReason);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "The type of message to be sent such as alert, notification, reminder, instruction, etc.", 0, java.lang.Integer.MAX_VALUE, category);
        case -1165461084: /*priority*/  return new Property("priority", "code", "Characterizes how quickly the proposed act must be initiated. Includes concepts such as stat, urgent, routine.", 0, 1, priority);
        case -1788508167: /*doNotPerform*/  return new Property("doNotPerform", "boolean", "If true indicates that the CommunicationRequest is asking for the specified action to *not* occur.", 0, 1, doNotPerform);
        case -1078030475: /*medium*/  return new Property("medium", "CodeableConcept", "A channel that was used for this communication (e.g. email, fax).", 0, java.lang.Integer.MAX_VALUE, medium);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The patient or group that is the focus of this communication request.", 0, 1, subject);
        case 92611469: /*about*/  return new Property("about", "Reference(Any)", "Other resources that pertain to this communication request and to which this communication request should be associated.", 0, java.lang.Integer.MAX_VALUE, about);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The Encounter during which this CommunicationRequest was created or to which the creation of this record is tightly associated.", 0, 1, encounter);
        case -786701938: /*payload*/  return new Property("payload", "", "Text, attachment(s), or resource(s) to be communicated to the recipient.", 0, java.lang.Integer.MAX_VALUE, payload);
        case -2022646513: /*occurrence[x]*/  return new Property("occurrence[x]", "dateTime|Period", "The time when this communication is to occur.", 0, 1, occurrence);
        case 1687874001: /*occurrence*/  return new Property("occurrence[x]", "dateTime|Period", "The time when this communication is to occur.", 0, 1, occurrence);
        case -298443636: /*occurrenceDateTime*/  return new Property("occurrence[x]", "dateTime", "The time when this communication is to occur.", 0, 1, occurrence);
        case 1397156594: /*occurrencePeriod*/  return new Property("occurrence[x]", "Period", "The time when this communication is to occur.", 0, 1, occurrence);
        case -1500852503: /*authoredOn*/  return new Property("authoredOn", "dateTime", "For draft requests, indicates the date of initial creation.  For requests with other statuses, indicates the date of activation.", 0, 1, authoredOn);
        case 693933948: /*requester*/  return new Property("requester", "Reference(Practitioner|PractitionerRole|Organization|Patient|RelatedPerson|Device)", "The device, individual, or organization who asks for the information to be shared.", 0, 1, requester);
        case 820081177: /*recipient*/  return new Property("recipient", "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson|Group|CareTeam|HealthcareService|Endpoint)", "The entity (e.g. person, organization, clinical information system, device, group, or care team) which is the intended target of the communication.", 0, java.lang.Integer.MAX_VALUE, recipient);
        case 1255338813: /*informationProvider*/  return new Property("informationProvider", "Reference(Device|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson|HealthcareService|Endpoint)", "The entity (e.g. person, organization, clinical information system, or device) which is to be the source of the communication.", 0, java.lang.Integer.MAX_VALUE, informationProvider);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Any)", "Describes why the request is being made in coded or textual form.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Comments made about the request by the requester, sender, recipient, subject or other participants.", 0, java.lang.Integer.MAX_VALUE, note);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -430332865: /*replaces*/ return this.replaces == null ? new Base[0] : this.replaces.toArray(new Base[this.replaces.size()]); // Reference
        case -445338488: /*groupIdentifier*/ return this.groupIdentifier == null ? new Base[0] : new Base[] {this.groupIdentifier}; // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<RequestStatus>
        case 2051346646: /*statusReason*/ return this.statusReason == null ? new Base[0] : new Base[] {this.statusReason}; // CodeableConcept
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // Enumeration<RequestPriority>
        case -1788508167: /*doNotPerform*/ return this.doNotPerform == null ? new Base[0] : new Base[] {this.doNotPerform}; // BooleanType
        case -1078030475: /*medium*/ return this.medium == null ? new Base[0] : this.medium.toArray(new Base[this.medium.size()]); // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 92611469: /*about*/ return this.about == null ? new Base[0] : this.about.toArray(new Base[this.about.size()]); // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -786701938: /*payload*/ return this.payload == null ? new Base[0] : this.payload.toArray(new Base[this.payload.size()]); // CommunicationRequestPayloadComponent
        case 1687874001: /*occurrence*/ return this.occurrence == null ? new Base[0] : new Base[] {this.occurrence}; // DataType
        case -1500852503: /*authoredOn*/ return this.authoredOn == null ? new Base[0] : new Base[] {this.authoredOn}; // DateTimeType
        case 693933948: /*requester*/ return this.requester == null ? new Base[0] : new Base[] {this.requester}; // Reference
        case 820081177: /*recipient*/ return this.recipient == null ? new Base[0] : this.recipient.toArray(new Base[this.recipient.size()]); // Reference
        case 1255338813: /*informationProvider*/ return this.informationProvider == null ? new Base[0] : this.informationProvider.toArray(new Base[this.informationProvider.size()]); // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
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
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -430332865: // replaces
          this.getReplaces().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -445338488: // groupIdentifier
          this.groupIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -892481550: // status
          value = new RequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<RequestStatus>
          return value;
        case 2051346646: // statusReason
          this.statusReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1165461084: // priority
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
          return value;
        case -1788508167: // doNotPerform
          this.doNotPerform = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1078030475: // medium
          this.getMedium().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 92611469: // about
          this.getAbout().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -786701938: // payload
          this.getPayload().add((CommunicationRequestPayloadComponent) value); // CommunicationRequestPayloadComponent
          return value;
        case 1687874001: // occurrence
          this.occurrence = TypeConvertor.castToType(value); // DataType
          return value;
        case -1500852503: // authoredOn
          this.authoredOn = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 693933948: // requester
          this.requester = TypeConvertor.castToReference(value); // Reference
          return value;
        case 820081177: // recipient
          this.getRecipient().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1255338813: // informationProvider
          this.getInformationProvider().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
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
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("replaces")) {
          this.getReplaces().add(TypeConvertor.castToReference(value));
        } else if (name.equals("groupIdentifier")) {
          this.groupIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("status")) {
          value = new RequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<RequestStatus>
        } else if (name.equals("statusReason")) {
          this.statusReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("priority")) {
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
        } else if (name.equals("doNotPerform")) {
          this.doNotPerform = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("medium")) {
          this.getMedium().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("about")) {
          this.getAbout().add(TypeConvertor.castToReference(value));
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("payload")) {
          this.getPayload().add((CommunicationRequestPayloadComponent) value);
        } else if (name.equals("occurrence[x]")) {
          this.occurrence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("authoredOn")) {
          this.authoredOn = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("requester")) {
          this.requester = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("recipient")) {
          this.getRecipient().add(TypeConvertor.castToReference(value));
        } else if (name.equals("informationProvider")) {
          this.getInformationProvider().add(TypeConvertor.castToReference(value));
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
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
        case -332612366:  return addBasedOn(); 
        case -430332865:  return addReplaces(); 
        case -445338488:  return getGroupIdentifier();
        case -892481550:  return getStatusElement();
        case 2051346646:  return getStatusReason();
        case 50511102:  return addCategory(); 
        case -1165461084:  return getPriorityElement();
        case -1788508167:  return getDoNotPerformElement();
        case -1078030475:  return addMedium(); 
        case -1867885268:  return getSubject();
        case 92611469:  return addAbout(); 
        case 1524132147:  return getEncounter();
        case -786701938:  return addPayload(); 
        case -2022646513:  return getOccurrence();
        case 1687874001:  return getOccurrence();
        case -1500852503:  return getAuthoredOnElement();
        case 693933948:  return getRequester();
        case 820081177:  return addRecipient(); 
        case 1255338813:  return addInformationProvider(); 
        case -934964668:  return addReason(); 
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -430332865: /*replaces*/ return new String[] {"Reference"};
        case -445338488: /*groupIdentifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 2051346646: /*statusReason*/ return new String[] {"CodeableConcept"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1165461084: /*priority*/ return new String[] {"code"};
        case -1788508167: /*doNotPerform*/ return new String[] {"boolean"};
        case -1078030475: /*medium*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 92611469: /*about*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -786701938: /*payload*/ return new String[] {};
        case 1687874001: /*occurrence*/ return new String[] {"dateTime", "Period"};
        case -1500852503: /*authoredOn*/ return new String[] {"dateTime"};
        case 693933948: /*requester*/ return new String[] {"Reference"};
        case 820081177: /*recipient*/ return new String[] {"Reference"};
        case 1255338813: /*informationProvider*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("replaces")) {
          return addReplaces();
        }
        else if (name.equals("groupIdentifier")) {
          this.groupIdentifier = new Identifier();
          return this.groupIdentifier;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type CommunicationRequest.status");
        }
        else if (name.equals("statusReason")) {
          this.statusReason = new CodeableConcept();
          return this.statusReason;
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a primitive type CommunicationRequest.priority");
        }
        else if (name.equals("doNotPerform")) {
          throw new FHIRException("Cannot call addChild on a primitive type CommunicationRequest.doNotPerform");
        }
        else if (name.equals("medium")) {
          return addMedium();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("about")) {
          return addAbout();
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("payload")) {
          return addPayload();
        }
        else if (name.equals("occurrenceDateTime")) {
          this.occurrence = new DateTimeType();
          return this.occurrence;
        }
        else if (name.equals("occurrencePeriod")) {
          this.occurrence = new Period();
          return this.occurrence;
        }
        else if (name.equals("authoredOn")) {
          throw new FHIRException("Cannot call addChild on a primitive type CommunicationRequest.authoredOn");
        }
        else if (name.equals("requester")) {
          this.requester = new Reference();
          return this.requester;
        }
        else if (name.equals("recipient")) {
          return addRecipient();
        }
        else if (name.equals("informationProvider")) {
          return addInformationProvider();
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CommunicationRequest";

  }

      public CommunicationRequest copy() {
        CommunicationRequest dst = new CommunicationRequest();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CommunicationRequest dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
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
        dst.groupIdentifier = groupIdentifier == null ? null : groupIdentifier.copy();
        dst.status = status == null ? null : status.copy();
        dst.statusReason = statusReason == null ? null : statusReason.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.priority = priority == null ? null : priority.copy();
        dst.doNotPerform = doNotPerform == null ? null : doNotPerform.copy();
        if (medium != null) {
          dst.medium = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : medium)
            dst.medium.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        if (about != null) {
          dst.about = new ArrayList<Reference>();
          for (Reference i : about)
            dst.about.add(i.copy());
        };
        dst.encounter = encounter == null ? null : encounter.copy();
        if (payload != null) {
          dst.payload = new ArrayList<CommunicationRequestPayloadComponent>();
          for (CommunicationRequestPayloadComponent i : payload)
            dst.payload.add(i.copy());
        };
        dst.occurrence = occurrence == null ? null : occurrence.copy();
        dst.authoredOn = authoredOn == null ? null : authoredOn.copy();
        dst.requester = requester == null ? null : requester.copy();
        if (recipient != null) {
          dst.recipient = new ArrayList<Reference>();
          for (Reference i : recipient)
            dst.recipient.add(i.copy());
        };
        if (informationProvider != null) {
          dst.informationProvider = new ArrayList<Reference>();
          for (Reference i : informationProvider)
            dst.informationProvider.add(i.copy());
        };
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
      }

      protected CommunicationRequest typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CommunicationRequest))
          return false;
        CommunicationRequest o = (CommunicationRequest) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(replaces, o.replaces, true)
           && compareDeep(groupIdentifier, o.groupIdentifier, true) && compareDeep(status, o.status, true)
           && compareDeep(statusReason, o.statusReason, true) && compareDeep(category, o.category, true) && compareDeep(priority, o.priority, true)
           && compareDeep(doNotPerform, o.doNotPerform, true) && compareDeep(medium, o.medium, true) && compareDeep(subject, o.subject, true)
           && compareDeep(about, o.about, true) && compareDeep(encounter, o.encounter, true) && compareDeep(payload, o.payload, true)
           && compareDeep(occurrence, o.occurrence, true) && compareDeep(authoredOn, o.authoredOn, true) && compareDeep(requester, o.requester, true)
           && compareDeep(recipient, o.recipient, true) && compareDeep(informationProvider, o.informationProvider, true)
           && compareDeep(reason, o.reason, true) && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CommunicationRequest))
          return false;
        CommunicationRequest o = (CommunicationRequest) other_;
        return compareValues(status, o.status, true) && compareValues(priority, o.priority, true) && compareValues(doNotPerform, o.doNotPerform, true)
           && compareValues(authoredOn, o.authoredOn, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, replaces
          , groupIdentifier, status, statusReason, category, priority, doNotPerform, medium
          , subject, about, encounter, payload, occurrence, authoredOn, requester, recipient
          , informationProvider, reason, note);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.CommunicationRequest;
   }

 /**
   * Search parameter: <b>authored</b>
   * <p>
   * Description: <b>When request transitioned to being actionable</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CommunicationRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="authored", path="CommunicationRequest.authoredOn", description="When request transitioned to being actionable", type="date" )
  public static final String SP_AUTHORED = "authored";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>authored</b>
   * <p>
   * Description: <b>When request transitioned to being actionable</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CommunicationRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam AUTHORED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_AUTHORED);

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>Fulfills plan or proposal</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="CommunicationRequest.basedOn", description="Fulfills plan or proposal", type="reference", target={Account.class, ActivityDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CapabilityStatement2.class, CarePlan.class, CareTeam.class, CatalogEntry.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseIssue.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceMetric.class, DeviceRequest.class, DeviceUseStatement.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceFocus.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestGroup.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>Fulfills plan or proposal</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("CommunicationRequest:based-on").toLocked();

 /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>Message category</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="CommunicationRequest.category", description="Message category", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>Message category</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>The Encounter during which this CommunicationRequest was created</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="CommunicationRequest.encounter", description="The Encounter during which this CommunicationRequest was created", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>The Encounter during which this CommunicationRequest was created</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("CommunicationRequest:encounter").toLocked();

 /**
   * Search parameter: <b>group-identifier</b>
   * <p>
   * Description: <b>Composite request this is part of</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.groupIdentifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="group-identifier", path="CommunicationRequest.groupIdentifier", description="Composite request this is part of", type="token" )
  public static final String SP_GROUP_IDENTIFIER = "group-identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>group-identifier</b>
   * <p>
   * Description: <b>Composite request this is part of</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.groupIdentifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam GROUP_IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_GROUP_IDENTIFIER);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Unique identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="CommunicationRequest.identifier", description="Unique identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Unique identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>information-provider</b>
   * <p>
   * Description: <b>Who should share the information</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.informationProvider</b><br>
   * </p>
   */
  @SearchParamDefinition(name="information-provider", path="CommunicationRequest.informationProvider", description="Who should share the information", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Device.class, Endpoint.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_INFORMATION_PROVIDER = "information-provider";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>information-provider</b>
   * <p>
   * Description: <b>Who should share the information</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.informationProvider</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INFORMATION_PROVIDER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INFORMATION_PROVIDER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:information-provider</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INFORMATION_PROVIDER = new ca.uhn.fhir.model.api.Include("CommunicationRequest:information-provider").toLocked();

 /**
   * Search parameter: <b>medium</b>
   * <p>
   * Description: <b>A channel of communication</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.medium</b><br>
   * </p>
   */
  @SearchParamDefinition(name="medium", path="CommunicationRequest.medium", description="A channel of communication", type="token" )
  public static final String SP_MEDIUM = "medium";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>medium</b>
   * <p>
   * Description: <b>A channel of communication</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.medium</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam MEDIUM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_MEDIUM);

 /**
   * Search parameter: <b>occurrence</b>
   * <p>
   * Description: <b>When scheduled</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CommunicationRequest.occurrence.as(dateTime) | CommunicationRequest.occurrence.as(Period)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="occurrence", path="CommunicationRequest.occurrence.as(dateTime) | CommunicationRequest.occurrence.as(Period)", description="When scheduled", type="date" )
  public static final String SP_OCCURRENCE = "occurrence";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>occurrence</b>
   * <p>
   * Description: <b>When scheduled</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CommunicationRequest.occurrence.as(dateTime) | CommunicationRequest.occurrence.as(Period)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam OCCURRENCE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_OCCURRENCE);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Focus of message</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="CommunicationRequest.subject.where(resolve() is Patient)", description="Focus of message", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Focus of message</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("CommunicationRequest:patient").toLocked();

 /**
   * Search parameter: <b>priority</b>
   * <p>
   * Description: <b>routine | urgent | asap | stat</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.priority</b><br>
   * </p>
   */
  @SearchParamDefinition(name="priority", path="CommunicationRequest.priority", description="routine | urgent | asap | stat", type="token" )
  public static final String SP_PRIORITY = "priority";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>priority</b>
   * <p>
   * Description: <b>routine | urgent | asap | stat</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.priority</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PRIORITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PRIORITY);

 /**
   * Search parameter: <b>recipient</b>
   * <p>
   * Description: <b>Who to share the information with</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.recipient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="recipient", path="CommunicationRequest.recipient", description="Who to share the information with", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson"), @ca.uhn.fhir.model.api.annotation.Compartment(name="EXAMPLE") }, target={CareTeam.class, Device.class, Endpoint.class, Group.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_RECIPIENT = "recipient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>recipient</b>
   * <p>
   * Description: <b>Who to share the information with</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.recipient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RECIPIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RECIPIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:recipient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RECIPIENT = new ca.uhn.fhir.model.api.Include("CommunicationRequest:recipient").toLocked();

 /**
   * Search parameter: <b>replaces</b>
   * <p>
   * Description: <b>Request(s) replaced by this request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.replaces</b><br>
   * </p>
   */
  @SearchParamDefinition(name="replaces", path="CommunicationRequest.replaces", description="Request(s) replaced by this request", type="reference", target={CommunicationRequest.class } )
  public static final String SP_REPLACES = "replaces";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>replaces</b>
   * <p>
   * Description: <b>Request(s) replaced by this request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.replaces</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REPLACES = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REPLACES);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:replaces</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REPLACES = new ca.uhn.fhir.model.api.Include("CommunicationRequest:replaces").toLocked();

 /**
   * Search parameter: <b>requester</b>
   * <p>
   * Description: <b>Who asks for the information to be shared</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.requester</b><br>
   * </p>
   */
  @SearchParamDefinition(name="requester", path="CommunicationRequest.requester", description="Who asks for the information to be shared", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_REQUESTER = "requester";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>requester</b>
   * <p>
   * Description: <b>Who asks for the information to be shared</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.requester</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REQUESTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REQUESTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:requester</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REQUESTER = new ca.uhn.fhir.model.api.Include("CommunicationRequest:requester").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>draft | active | on-hold | revoked | completed | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="CommunicationRequest.status", description="draft | active | on-hold | revoked | completed | entered-in-error | unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>draft | active | on-hold | revoked | completed | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CommunicationRequest.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Focus of message</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="CommunicationRequest.subject", description="Focus of message", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Focus of message</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CommunicationRequest.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CommunicationRequest:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("CommunicationRequest:subject").toLocked();


}