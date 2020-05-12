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
 * A record of a request for service such as diagnostic investigations, treatments, or operations to be performed.
 */
@ResourceDef(name="ServiceRequest", profile="http://hl7.org/fhir/StructureDefinition/ServiceRequest")
public class ServiceRequest extends DomainResource {

    /**
     * Identifiers assigned to this order instance by the orderer and/or the receiver and/or order fulfiller.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Identifiers assigned to this order", formalDefinition="Identifiers assigned to this order instance by the orderer and/or the receiver and/or order fulfiller." )
    protected List<Identifier> identifier;

    /**
     * The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.
     */
    @Child(name = "instantiatesCanonical", type = {CanonicalType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates FHIR protocol or definition", formalDefinition="The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest." )
    protected List<CanonicalType> instantiatesCanonical;

    /**
     * The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.
     */
    @Child(name = "instantiatesUri", type = {UriType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates external protocol or definition", formalDefinition="The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest." )
    protected List<UriType> instantiatesUri;

    /**
     * Plan/proposal/order fulfilled by this request.
     */
    @Child(name = "basedOn", type = {CarePlan.class, ServiceRequest.class, MedicationRequest.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What request fulfills", formalDefinition="Plan/proposal/order fulfilled by this request." )
    protected List<Reference> basedOn;

    /**
     * The request takes the place of the referenced completed or terminated request(s).
     */
    @Child(name = "replaces", type = {ServiceRequest.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What request replaces", formalDefinition="The request takes the place of the referenced completed or terminated request(s)." )
    protected List<Reference> replaces;

    /**
     * A shared identifier common to all service requests that were authorized more or less simultaneously by a single author, representing the composite or group identifier.
     */
    @Child(name = "requisition", type = {Identifier.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Composite Request ID", formalDefinition="A shared identifier common to all service requests that were authorized more or less simultaneously by a single author, representing the composite or group identifier." )
    protected Identifier requisition;

    /**
     * The status of the order.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | on-hold | revoked | completed | entered-in-error | unknown", formalDefinition="The status of the order." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-status")
    protected Enumeration<RequestStatus> status;

    /**
     * Whether the request is a proposal, plan, an original order or a reflex order.
     */
    @Child(name = "intent", type = {CodeType.class}, order=7, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="proposal | plan | directive | order +", formalDefinition="Whether the request is a proposal, plan, an original order or a reflex order." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-intent")
    protected Enumeration<RequestIntent> intent;

    /**
     * A code that classifies the service for searching, sorting and display purposes (e.g. "Surgical Procedure").
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Classification of service", formalDefinition="A code that classifies the service for searching, sorting and display purposes (e.g. \"Surgical Procedure\")." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/servicerequest-category")
    protected List<CodeableConcept> category;

    /**
     * Indicates how quickly the ServiceRequest should be addressed with respect to other requests.
     */
    @Child(name = "priority", type = {CodeType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="routine | urgent | asap | stat", formalDefinition="Indicates how quickly the ServiceRequest should be addressed with respect to other requests." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-priority")
    protected Enumeration<RequestPriority> priority;

    /**
     * Set this to true if the record is saying that the service/procedure should NOT be performed.
     */
    @Child(name = "doNotPerform", type = {BooleanType.class}, order=10, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="True if service/procedure should not be performed", formalDefinition="Set this to true if the record is saying that the service/procedure should NOT be performed." )
    protected BooleanType doNotPerform;

    /**
     * A code that identifies a particular service (i.e., procedure, diagnostic investigation, or panel of investigations) that have been requested.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What is being requested/ordered", formalDefinition="A code that identifies a particular service (i.e., procedure, diagnostic investigation, or panel of investigations) that have been requested." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-code")
    protected CodeableConcept code;

    /**
     * Additional details and instructions about the how the services are to be delivered.   For example, and order for a urinary catheter may have an order detail for an external or indwelling catheter, or an order for a bandage may require additional instructions specifying how the bandage should be applied.
     */
    @Child(name = "orderDetail", type = {CodeableConcept.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional order information", formalDefinition="Additional details and instructions about the how the services are to be delivered.   For example, and order for a urinary catheter may have an order detail for an external or indwelling catheter, or an order for a bandage may require additional instructions specifying how the bandage should be applied." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/servicerequest-orderdetail")
    protected List<CodeableConcept> orderDetail;

    /**
     * An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).
     */
    @Child(name = "quantity", type = {Quantity.class, Ratio.class, Range.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Service amount", formalDefinition="An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction)." )
    protected DataType quantity;

    /**
     * On whom or what the service is to be performed. This is usually a human patient, but can also be requested on animals, groups of humans or animals, devices such as dialysis machines, or even locations (typically for environmental scans).
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Location.class, Device.class}, order=14, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Individual or Entity the service is ordered for", formalDefinition="On whom or what the service is to be performed. This is usually a human patient, but can also be requested on animals, groups of humans or animals, devices such as dialysis machines, or even locations (typically for environmental scans)." )
    protected Reference subject;

    /**
     * An encounter that provides additional information about the healthcare context in which this request is made.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Encounter in which the request was created", formalDefinition="An encounter that provides additional information about the healthcare context in which this request is made." )
    protected Reference encounter;

    /**
     * The date/time at which the requested service should occur.
     */
    @Child(name = "occurrence", type = {DateTimeType.class, Period.class, Timing.class}, order=16, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When service should occur", formalDefinition="The date/time at which the requested service should occur." )
    protected DataType occurrence;

    /**
     * If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example "pain", "on flare-up", etc.
     */
    @Child(name = "asNeeded", type = {BooleanType.class, CodeableConcept.class}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Preconditions for service", formalDefinition="If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-as-needed-reason")
    protected DataType asNeeded;

    /**
     * When the request transitioned to being actionable.
     */
    @Child(name = "authoredOn", type = {DateTimeType.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date request signed", formalDefinition="When the request transitioned to being actionable." )
    protected DateTimeType authoredOn;

    /**
     * The individual who initiated the request and has responsibility for its activation.
     */
    @Child(name = "requester", type = {Practitioner.class, PractitionerRole.class, Organization.class, Patient.class, RelatedPerson.class, Device.class}, order=19, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who/what is requesting service", formalDefinition="The individual who initiated the request and has responsibility for its activation." )
    protected Reference requester;

    /**
     * Desired type of performer for doing the requested service.
     */
    @Child(name = "performerType", type = {CodeableConcept.class}, order=20, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Performer role", formalDefinition="Desired type of performer for doing the requested service." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participant-role")
    protected CodeableConcept performerType;

    /**
     * The desired performer for doing the requested service.  For example, the surgeon, dermatopathologist, endoscopist, etc.
     */
    @Child(name = "performer", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, HealthcareService.class, Patient.class, Device.class, RelatedPerson.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Requested performer", formalDefinition="The desired performer for doing the requested service.  For example, the surgeon, dermatopathologist, endoscopist, etc." )
    protected List<Reference> performer;

    /**
     * The preferred location(s) where the procedure should actually happen in coded or free text form. E.g. at home or nursing day care center.
     */
    @Child(name = "location", type = {CodeableReference.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Requested location", formalDefinition="The preferred location(s) where the procedure should actually happen in coded or free text form. E.g. at home or nursing day care center." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ServiceDeliveryLocationRoleType")
    protected List<CodeableReference> location;

    /**
     * An explanation or justification for why this service is being requested in coded or textual form.   This is often for billing purposes.  May relate to the resources referred to in `supportingInfo`.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Explanation/Justification for procedure or service", formalDefinition="An explanation or justification for why this service is being requested in coded or textual form.   This is often for billing purposes.  May relate to the resources referred to in `supportingInfo`." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/procedure-reason")
    protected List<CodeableReference> reason;

    /**
     * Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be needed for delivering the requested service.
     */
    @Child(name = "insurance", type = {Coverage.class, ClaimResponse.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Associated insurance coverage", formalDefinition="Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be needed for delivering the requested service." )
    protected List<Reference> insurance;

    /**
     * Additional clinical information about the patient or specimen that may influence the services or their interpretations.     This information includes diagnosis, clinical findings and other observations.  In laboratory ordering these are typically referred to as "ask at order entry questions (AOEs)".  This includes observations explicitly requested by the producer (filler) to provide context or supporting information needed to complete the order. For example,  reporting the amount of inspired oxygen for blood gas measurements.
     */
    @Child(name = "supportingInfo", type = {Reference.class}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional clinical information", formalDefinition="Additional clinical information about the patient or specimen that may influence the services or their interpretations.     This information includes diagnosis, clinical findings and other observations.  In laboratory ordering these are typically referred to as \"ask at order entry questions (AOEs)\".  This includes observations explicitly requested by the producer (filler) to provide context or supporting information needed to complete the order. For example,  reporting the amount of inspired oxygen for blood gas measurements." )
    protected List<Reference> supportingInfo;

    /**
     * One or more specimens that the laboratory procedure will use.
     */
    @Child(name = "specimen", type = {Specimen.class}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Procedure Samples", formalDefinition="One or more specimens that the laboratory procedure will use." )
    protected List<Reference> specimen;

    /**
     * Anatomic location where the procedure should be performed. This is the target site.
     */
    @Child(name = "bodySite", type = {CodeableConcept.class}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Location on Body", formalDefinition="Anatomic location where the procedure should be performed. This is the target site." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected List<CodeableConcept> bodySite;

    /**
     * Any other notes and comments made about the service request. For example, internal billing notes.
     */
    @Child(name = "note", type = {Annotation.class}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments", formalDefinition="Any other notes and comments made about the service request. For example, internal billing notes." )
    protected List<Annotation> note;

    /**
     * Instructions in terms that are understood by the patient or consumer.
     */
    @Child(name = "patientInstruction", type = {StringType.class}, order=29, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Patient or consumer-oriented instructions", formalDefinition="Instructions in terms that are understood by the patient or consumer." )
    protected StringType patientInstruction;

    /**
     * Key events in the history of the request.
     */
    @Child(name = "relevantHistory", type = {Provenance.class}, order=30, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Request provenance", formalDefinition="Key events in the history of the request." )
    protected List<Reference> relevantHistory;

    private static final long serialVersionUID = -578395935L;

  /**
   * Constructor
   */
    public ServiceRequest() {
      super();
    }

  /**
   * Constructor
   */
    public ServiceRequest(RequestStatus status, RequestIntent intent, Reference subject) {
      super();
      this.setStatus(status);
      this.setIntent(intent);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Identifiers assigned to this order instance by the orderer and/or the receiver and/or order fulfiller.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setIdentifier(List<Identifier> theIdentifier) { 
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

    public ServiceRequest addIdentifier(Identifier t) { //3
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
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.)
     */
    public List<CanonicalType> getInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      return this.instantiatesCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical) { 
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
     * @return {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.)
     */
    public CanonicalType addInstantiatesCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.)
     */
    public ServiceRequest addInstantiatesCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesCanonical} (The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.)
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
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.)
     */
    public List<UriType> getInstantiatesUri() { 
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      return this.instantiatesUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setInstantiatesUri(List<UriType> theInstantiatesUri) { 
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
     * @return {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.)
     */
    public UriType addInstantiatesUriElement() {//2 
      UriType t = new UriType();
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.)
     */
    public ServiceRequest addInstantiatesUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesUri} (The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.)
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
     * @return {@link #basedOn} (Plan/proposal/order fulfilled by this request.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setBasedOn(List<Reference> theBasedOn) { 
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

    public ServiceRequest addBasedOn(Reference t) { //3
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
     * @return {@link #replaces} (The request takes the place of the referenced completed or terminated request(s).)
     */
    public List<Reference> getReplaces() { 
      if (this.replaces == null)
        this.replaces = new ArrayList<Reference>();
      return this.replaces;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setReplaces(List<Reference> theReplaces) { 
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

    public ServiceRequest addReplaces(Reference t) { //3
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
     * @return {@link #requisition} (A shared identifier common to all service requests that were authorized more or less simultaneously by a single author, representing the composite or group identifier.)
     */
    public Identifier getRequisition() { 
      if (this.requisition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.requisition");
        else if (Configuration.doAutoCreate())
          this.requisition = new Identifier(); // cc
      return this.requisition;
    }

    public boolean hasRequisition() { 
      return this.requisition != null && !this.requisition.isEmpty();
    }

    /**
     * @param value {@link #requisition} (A shared identifier common to all service requests that were authorized more or less simultaneously by a single author, representing the composite or group identifier.)
     */
    public ServiceRequest setRequisition(Identifier value) { 
      this.requisition = value;
      return this;
    }

    /**
     * @return {@link #status} (The status of the order.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<RequestStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.status");
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
     * @param value {@link #status} (The status of the order.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ServiceRequest setStatusElement(Enumeration<RequestStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the order.
     */
    public RequestStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the order.
     */
    public ServiceRequest setStatus(RequestStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<RequestStatus>(new RequestStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #intent} (Whether the request is a proposal, plan, an original order or a reflex order.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public Enumeration<RequestIntent> getIntentElement() { 
      if (this.intent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.intent");
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
     * @param value {@link #intent} (Whether the request is a proposal, plan, an original order or a reflex order.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public ServiceRequest setIntentElement(Enumeration<RequestIntent> value) { 
      this.intent = value;
      return this;
    }

    /**
     * @return Whether the request is a proposal, plan, an original order or a reflex order.
     */
    public RequestIntent getIntent() { 
      return this.intent == null ? null : this.intent.getValue();
    }

    /**
     * @param value Whether the request is a proposal, plan, an original order or a reflex order.
     */
    public ServiceRequest setIntent(RequestIntent value) { 
        if (this.intent == null)
          this.intent = new Enumeration<RequestIntent>(new RequestIntentEnumFactory());
        this.intent.setValue(value);
      return this;
    }

    /**
     * @return {@link #category} (A code that classifies the service for searching, sorting and display purposes (e.g. "Surgical Procedure").)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setCategory(List<CodeableConcept> theCategory) { 
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

    public ServiceRequest addCategory(CodeableConcept t) { //3
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
     * @return {@link #priority} (Indicates how quickly the ServiceRequest should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Enumeration<RequestPriority> getPriorityElement() { 
      if (this.priority == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.priority");
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
     * @param value {@link #priority} (Indicates how quickly the ServiceRequest should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public ServiceRequest setPriorityElement(Enumeration<RequestPriority> value) { 
      this.priority = value;
      return this;
    }

    /**
     * @return Indicates how quickly the ServiceRequest should be addressed with respect to other requests.
     */
    public RequestPriority getPriority() { 
      return this.priority == null ? null : this.priority.getValue();
    }

    /**
     * @param value Indicates how quickly the ServiceRequest should be addressed with respect to other requests.
     */
    public ServiceRequest setPriority(RequestPriority value) { 
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
     * @return {@link #doNotPerform} (Set this to true if the record is saying that the service/procedure should NOT be performed.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
     */
    public BooleanType getDoNotPerformElement() { 
      if (this.doNotPerform == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.doNotPerform");
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
     * @param value {@link #doNotPerform} (Set this to true if the record is saying that the service/procedure should NOT be performed.). This is the underlying object with id, value and extensions. The accessor "getDoNotPerform" gives direct access to the value
     */
    public ServiceRequest setDoNotPerformElement(BooleanType value) { 
      this.doNotPerform = value;
      return this;
    }

    /**
     * @return Set this to true if the record is saying that the service/procedure should NOT be performed.
     */
    public boolean getDoNotPerform() { 
      return this.doNotPerform == null || this.doNotPerform.isEmpty() ? false : this.doNotPerform.getValue();
    }

    /**
     * @param value Set this to true if the record is saying that the service/procedure should NOT be performed.
     */
    public ServiceRequest setDoNotPerform(boolean value) { 
        if (this.doNotPerform == null)
          this.doNotPerform = new BooleanType();
        this.doNotPerform.setValue(value);
      return this;
    }

    /**
     * @return {@link #code} (A code that identifies a particular service (i.e., procedure, diagnostic investigation, or panel of investigations) that have been requested.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A code that identifies a particular service (i.e., procedure, diagnostic investigation, or panel of investigations) that have been requested.)
     */
    public ServiceRequest setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #orderDetail} (Additional details and instructions about the how the services are to be delivered.   For example, and order for a urinary catheter may have an order detail for an external or indwelling catheter, or an order for a bandage may require additional instructions specifying how the bandage should be applied.)
     */
    public List<CodeableConcept> getOrderDetail() { 
      if (this.orderDetail == null)
        this.orderDetail = new ArrayList<CodeableConcept>();
      return this.orderDetail;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setOrderDetail(List<CodeableConcept> theOrderDetail) { 
      this.orderDetail = theOrderDetail;
      return this;
    }

    public boolean hasOrderDetail() { 
      if (this.orderDetail == null)
        return false;
      for (CodeableConcept item : this.orderDetail)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addOrderDetail() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.orderDetail == null)
        this.orderDetail = new ArrayList<CodeableConcept>();
      this.orderDetail.add(t);
      return t;
    }

    public ServiceRequest addOrderDetail(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.orderDetail == null)
        this.orderDetail = new ArrayList<CodeableConcept>();
      this.orderDetail.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #orderDetail}, creating it if it does not already exist {3}
     */
    public CodeableConcept getOrderDetailFirstRep() { 
      if (getOrderDetail().isEmpty()) {
        addOrderDetail();
      }
      return getOrderDetail().get(0);
    }

    /**
     * @return {@link #quantity} (An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).)
     */
    public DataType getQuantity() { 
      return this.quantity;
    }

    /**
     * @return {@link #quantity} (An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).)
     */
    public Quantity getQuantityQuantity() throws FHIRException { 
      if (this.quantity == null)
        this.quantity = new Quantity();
      if (!(this.quantity instanceof Quantity))
        throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.quantity.getClass().getName()+" was encountered");
      return (Quantity) this.quantity;
    }

    public boolean hasQuantityQuantity() { 
      return this != null && this.quantity instanceof Quantity;
    }

    /**
     * @return {@link #quantity} (An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).)
     */
    public Ratio getQuantityRatio() throws FHIRException { 
      if (this.quantity == null)
        this.quantity = new Ratio();
      if (!(this.quantity instanceof Ratio))
        throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.quantity.getClass().getName()+" was encountered");
      return (Ratio) this.quantity;
    }

    public boolean hasQuantityRatio() { 
      return this != null && this.quantity instanceof Ratio;
    }

    /**
     * @return {@link #quantity} (An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).)
     */
    public Range getQuantityRange() throws FHIRException { 
      if (this.quantity == null)
        this.quantity = new Range();
      if (!(this.quantity instanceof Range))
        throw new FHIRException("Type mismatch: the type Range was expected, but "+this.quantity.getClass().getName()+" was encountered");
      return (Range) this.quantity;
    }

    public boolean hasQuantityRange() { 
      return this != null && this.quantity instanceof Range;
    }

    public boolean hasQuantity() { 
      return this.quantity != null && !this.quantity.isEmpty();
    }

    /**
     * @param value {@link #quantity} (An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).)
     */
    public ServiceRequest setQuantity(DataType value) { 
      if (value != null && !(value instanceof Quantity || value instanceof Ratio || value instanceof Range))
        throw new Error("Not the right type for ServiceRequest.quantity[x]: "+value.fhirType());
      this.quantity = value;
      return this;
    }

    /**
     * @return {@link #subject} (On whom or what the service is to be performed. This is usually a human patient, but can also be requested on animals, groups of humans or animals, devices such as dialysis machines, or even locations (typically for environmental scans).)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (On whom or what the service is to be performed. This is usually a human patient, but can also be requested on animals, groups of humans or animals, devices such as dialysis machines, or even locations (typically for environmental scans).)
     */
    public ServiceRequest setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (An encounter that provides additional information about the healthcare context in which this request is made.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (An encounter that provides additional information about the healthcare context in which this request is made.)
     */
    public ServiceRequest setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #occurrence} (The date/time at which the requested service should occur.)
     */
    public DataType getOccurrence() { 
      return this.occurrence;
    }

    /**
     * @return {@link #occurrence} (The date/time at which the requested service should occur.)
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
     * @return {@link #occurrence} (The date/time at which the requested service should occur.)
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

    /**
     * @return {@link #occurrence} (The date/time at which the requested service should occur.)
     */
    public Timing getOccurrenceTiming() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Timing();
      if (!(this.occurrence instanceof Timing))
        throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Timing) this.occurrence;
    }

    public boolean hasOccurrenceTiming() { 
      return this != null && this.occurrence instanceof Timing;
    }

    public boolean hasOccurrence() { 
      return this.occurrence != null && !this.occurrence.isEmpty();
    }

    /**
     * @param value {@link #occurrence} (The date/time at which the requested service should occur.)
     */
    public ServiceRequest setOccurrence(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period || value instanceof Timing))
        throw new Error("Not the right type for ServiceRequest.occurrence[x]: "+value.fhirType());
      this.occurrence = value;
      return this;
    }

    /**
     * @return {@link #asNeeded} (If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example "pain", "on flare-up", etc.)
     */
    public DataType getAsNeeded() { 
      return this.asNeeded;
    }

    /**
     * @return {@link #asNeeded} (If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example "pain", "on flare-up", etc.)
     */
    public BooleanType getAsNeededBooleanType() throws FHIRException { 
      if (this.asNeeded == null)
        this.asNeeded = new BooleanType();
      if (!(this.asNeeded instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.asNeeded.getClass().getName()+" was encountered");
      return (BooleanType) this.asNeeded;
    }

    public boolean hasAsNeededBooleanType() { 
      return this != null && this.asNeeded instanceof BooleanType;
    }

    /**
     * @return {@link #asNeeded} (If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example "pain", "on flare-up", etc.)
     */
    public CodeableConcept getAsNeededCodeableConcept() throws FHIRException { 
      if (this.asNeeded == null)
        this.asNeeded = new CodeableConcept();
      if (!(this.asNeeded instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.asNeeded.getClass().getName()+" was encountered");
      return (CodeableConcept) this.asNeeded;
    }

    public boolean hasAsNeededCodeableConcept() { 
      return this != null && this.asNeeded instanceof CodeableConcept;
    }

    public boolean hasAsNeeded() { 
      return this.asNeeded != null && !this.asNeeded.isEmpty();
    }

    /**
     * @param value {@link #asNeeded} (If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example "pain", "on flare-up", etc.)
     */
    public ServiceRequest setAsNeeded(DataType value) { 
      if (value != null && !(value instanceof BooleanType || value instanceof CodeableConcept))
        throw new Error("Not the right type for ServiceRequest.asNeeded[x]: "+value.fhirType());
      this.asNeeded = value;
      return this;
    }

    /**
     * @return {@link #authoredOn} (When the request transitioned to being actionable.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public DateTimeType getAuthoredOnElement() { 
      if (this.authoredOn == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.authoredOn");
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
     * @param value {@link #authoredOn} (When the request transitioned to being actionable.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public ServiceRequest setAuthoredOnElement(DateTimeType value) { 
      this.authoredOn = value;
      return this;
    }

    /**
     * @return When the request transitioned to being actionable.
     */
    public Date getAuthoredOn() { 
      return this.authoredOn == null ? null : this.authoredOn.getValue();
    }

    /**
     * @param value When the request transitioned to being actionable.
     */
    public ServiceRequest setAuthoredOn(Date value) { 
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
     * @return {@link #requester} (The individual who initiated the request and has responsibility for its activation.)
     */
    public Reference getRequester() { 
      if (this.requester == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.requester");
        else if (Configuration.doAutoCreate())
          this.requester = new Reference(); // cc
      return this.requester;
    }

    public boolean hasRequester() { 
      return this.requester != null && !this.requester.isEmpty();
    }

    /**
     * @param value {@link #requester} (The individual who initiated the request and has responsibility for its activation.)
     */
    public ServiceRequest setRequester(Reference value) { 
      this.requester = value;
      return this;
    }

    /**
     * @return {@link #performerType} (Desired type of performer for doing the requested service.)
     */
    public CodeableConcept getPerformerType() { 
      if (this.performerType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.performerType");
        else if (Configuration.doAutoCreate())
          this.performerType = new CodeableConcept(); // cc
      return this.performerType;
    }

    public boolean hasPerformerType() { 
      return this.performerType != null && !this.performerType.isEmpty();
    }

    /**
     * @param value {@link #performerType} (Desired type of performer for doing the requested service.)
     */
    public ServiceRequest setPerformerType(CodeableConcept value) { 
      this.performerType = value;
      return this;
    }

    /**
     * @return {@link #performer} (The desired performer for doing the requested service.  For example, the surgeon, dermatopathologist, endoscopist, etc.)
     */
    public List<Reference> getPerformer() { 
      if (this.performer == null)
        this.performer = new ArrayList<Reference>();
      return this.performer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setPerformer(List<Reference> thePerformer) { 
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

    public ServiceRequest addPerformer(Reference t) { //3
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
     * @return {@link #location} (The preferred location(s) where the procedure should actually happen in coded or free text form. E.g. at home or nursing day care center.)
     */
    public List<CodeableReference> getLocation() { 
      if (this.location == null)
        this.location = new ArrayList<CodeableReference>();
      return this.location;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setLocation(List<CodeableReference> theLocation) { 
      this.location = theLocation;
      return this;
    }

    public boolean hasLocation() { 
      if (this.location == null)
        return false;
      for (CodeableReference item : this.location)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addLocation() { //3
      CodeableReference t = new CodeableReference();
      if (this.location == null)
        this.location = new ArrayList<CodeableReference>();
      this.location.add(t);
      return t;
    }

    public ServiceRequest addLocation(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.location == null)
        this.location = new ArrayList<CodeableReference>();
      this.location.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #location}, creating it if it does not already exist {3}
     */
    public CodeableReference getLocationFirstRep() { 
      if (getLocation().isEmpty()) {
        addLocation();
      }
      return getLocation().get(0);
    }

    /**
     * @return {@link #reason} (An explanation or justification for why this service is being requested in coded or textual form.   This is often for billing purposes.  May relate to the resources referred to in `supportingInfo`.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setReason(List<CodeableReference> theReason) { 
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

    public ServiceRequest addReason(CodeableReference t) { //3
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
     * @return {@link #insurance} (Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be needed for delivering the requested service.)
     */
    public List<Reference> getInsurance() { 
      if (this.insurance == null)
        this.insurance = new ArrayList<Reference>();
      return this.insurance;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setInsurance(List<Reference> theInsurance) { 
      this.insurance = theInsurance;
      return this;
    }

    public boolean hasInsurance() { 
      if (this.insurance == null)
        return false;
      for (Reference item : this.insurance)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addInsurance() { //3
      Reference t = new Reference();
      if (this.insurance == null)
        this.insurance = new ArrayList<Reference>();
      this.insurance.add(t);
      return t;
    }

    public ServiceRequest addInsurance(Reference t) { //3
      if (t == null)
        return this;
      if (this.insurance == null)
        this.insurance = new ArrayList<Reference>();
      this.insurance.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #insurance}, creating it if it does not already exist {3}
     */
    public Reference getInsuranceFirstRep() { 
      if (getInsurance().isEmpty()) {
        addInsurance();
      }
      return getInsurance().get(0);
    }

    /**
     * @return {@link #supportingInfo} (Additional clinical information about the patient or specimen that may influence the services or their interpretations.     This information includes diagnosis, clinical findings and other observations.  In laboratory ordering these are typically referred to as "ask at order entry questions (AOEs)".  This includes observations explicitly requested by the producer (filler) to provide context or supporting information needed to complete the order. For example,  reporting the amount of inspired oxygen for blood gas measurements.)
     */
    public List<Reference> getSupportingInfo() { 
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      return this.supportingInfo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setSupportingInfo(List<Reference> theSupportingInfo) { 
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

    public ServiceRequest addSupportingInfo(Reference t) { //3
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
     * @return {@link #specimen} (One or more specimens that the laboratory procedure will use.)
     */
    public List<Reference> getSpecimen() { 
      if (this.specimen == null)
        this.specimen = new ArrayList<Reference>();
      return this.specimen;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setSpecimen(List<Reference> theSpecimen) { 
      this.specimen = theSpecimen;
      return this;
    }

    public boolean hasSpecimen() { 
      if (this.specimen == null)
        return false;
      for (Reference item : this.specimen)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSpecimen() { //3
      Reference t = new Reference();
      if (this.specimen == null)
        this.specimen = new ArrayList<Reference>();
      this.specimen.add(t);
      return t;
    }

    public ServiceRequest addSpecimen(Reference t) { //3
      if (t == null)
        return this;
      if (this.specimen == null)
        this.specimen = new ArrayList<Reference>();
      this.specimen.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #specimen}, creating it if it does not already exist {3}
     */
    public Reference getSpecimenFirstRep() { 
      if (getSpecimen().isEmpty()) {
        addSpecimen();
      }
      return getSpecimen().get(0);
    }

    /**
     * @return {@link #bodySite} (Anatomic location where the procedure should be performed. This is the target site.)
     */
    public List<CodeableConcept> getBodySite() { 
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableConcept>();
      return this.bodySite;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setBodySite(List<CodeableConcept> theBodySite) { 
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

    public ServiceRequest addBodySite(CodeableConcept t) { //3
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
     * @return {@link #note} (Any other notes and comments made about the service request. For example, internal billing notes.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setNote(List<Annotation> theNote) { 
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

    public ServiceRequest addNote(Annotation t) { //3
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
     * @return {@link #patientInstruction} (Instructions in terms that are understood by the patient or consumer.). This is the underlying object with id, value and extensions. The accessor "getPatientInstruction" gives direct access to the value
     */
    public StringType getPatientInstructionElement() { 
      if (this.patientInstruction == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ServiceRequest.patientInstruction");
        else if (Configuration.doAutoCreate())
          this.patientInstruction = new StringType(); // bb
      return this.patientInstruction;
    }

    public boolean hasPatientInstructionElement() { 
      return this.patientInstruction != null && !this.patientInstruction.isEmpty();
    }

    public boolean hasPatientInstruction() { 
      return this.patientInstruction != null && !this.patientInstruction.isEmpty();
    }

    /**
     * @param value {@link #patientInstruction} (Instructions in terms that are understood by the patient or consumer.). This is the underlying object with id, value and extensions. The accessor "getPatientInstruction" gives direct access to the value
     */
    public ServiceRequest setPatientInstructionElement(StringType value) { 
      this.patientInstruction = value;
      return this;
    }

    /**
     * @return Instructions in terms that are understood by the patient or consumer.
     */
    public String getPatientInstruction() { 
      return this.patientInstruction == null ? null : this.patientInstruction.getValue();
    }

    /**
     * @param value Instructions in terms that are understood by the patient or consumer.
     */
    public ServiceRequest setPatientInstruction(String value) { 
      if (Utilities.noString(value))
        this.patientInstruction = null;
      else {
        if (this.patientInstruction == null)
          this.patientInstruction = new StringType();
        this.patientInstruction.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #relevantHistory} (Key events in the history of the request.)
     */
    public List<Reference> getRelevantHistory() { 
      if (this.relevantHistory == null)
        this.relevantHistory = new ArrayList<Reference>();
      return this.relevantHistory;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ServiceRequest setRelevantHistory(List<Reference> theRelevantHistory) { 
      this.relevantHistory = theRelevantHistory;
      return this;
    }

    public boolean hasRelevantHistory() { 
      if (this.relevantHistory == null)
        return false;
      for (Reference item : this.relevantHistory)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addRelevantHistory() { //3
      Reference t = new Reference();
      if (this.relevantHistory == null)
        this.relevantHistory = new ArrayList<Reference>();
      this.relevantHistory.add(t);
      return t;
    }

    public ServiceRequest addRelevantHistory(Reference t) { //3
      if (t == null)
        return this;
      if (this.relevantHistory == null)
        this.relevantHistory = new ArrayList<Reference>();
      this.relevantHistory.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relevantHistory}, creating it if it does not already exist {3}
     */
    public Reference getRelevantHistoryFirstRep() { 
      if (getRelevantHistory().isEmpty()) {
        addRelevantHistory();
      }
      return getRelevantHistory().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers assigned to this order instance by the orderer and/or the receiver and/or order fulfiller.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("instantiatesCanonical", "canonical(ActivityDefinition|PlanDefinition)", "The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical));
        children.add(new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri));
        children.add(new Property("basedOn", "Reference(CarePlan|ServiceRequest|MedicationRequest)", "Plan/proposal/order fulfilled by this request.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("replaces", "Reference(ServiceRequest)", "The request takes the place of the referenced completed or terminated request(s).", 0, java.lang.Integer.MAX_VALUE, replaces));
        children.add(new Property("requisition", "Identifier", "A shared identifier common to all service requests that were authorized more or less simultaneously by a single author, representing the composite or group identifier.", 0, 1, requisition));
        children.add(new Property("status", "code", "The status of the order.", 0, 1, status));
        children.add(new Property("intent", "code", "Whether the request is a proposal, plan, an original order or a reflex order.", 0, 1, intent));
        children.add(new Property("category", "CodeableConcept", "A code that classifies the service for searching, sorting and display purposes (e.g. \"Surgical Procedure\").", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("priority", "code", "Indicates how quickly the ServiceRequest should be addressed with respect to other requests.", 0, 1, priority));
        children.add(new Property("doNotPerform", "boolean", "Set this to true if the record is saying that the service/procedure should NOT be performed.", 0, 1, doNotPerform));
        children.add(new Property("code", "CodeableConcept", "A code that identifies a particular service (i.e., procedure, diagnostic investigation, or panel of investigations) that have been requested.", 0, 1, code));
        children.add(new Property("orderDetail", "CodeableConcept", "Additional details and instructions about the how the services are to be delivered.   For example, and order for a urinary catheter may have an order detail for an external or indwelling catheter, or an order for a bandage may require additional instructions specifying how the bandage should be applied.", 0, java.lang.Integer.MAX_VALUE, orderDetail));
        children.add(new Property("quantity[x]", "Quantity|Ratio|Range", "An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).", 0, 1, quantity));
        children.add(new Property("subject", "Reference(Patient|Group|Location|Device)", "On whom or what the service is to be performed. This is usually a human patient, but can also be requested on animals, groups of humans or animals, devices such as dialysis machines, or even locations (typically for environmental scans).", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "An encounter that provides additional information about the healthcare context in which this request is made.", 0, 1, encounter));
        children.add(new Property("occurrence[x]", "dateTime|Period|Timing", "The date/time at which the requested service should occur.", 0, 1, occurrence));
        children.add(new Property("asNeeded[x]", "boolean|CodeableConcept", "If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc.", 0, 1, asNeeded));
        children.add(new Property("authoredOn", "dateTime", "When the request transitioned to being actionable.", 0, 1, authoredOn));
        children.add(new Property("requester", "Reference(Practitioner|PractitionerRole|Organization|Patient|RelatedPerson|Device)", "The individual who initiated the request and has responsibility for its activation.", 0, 1, requester));
        children.add(new Property("performerType", "CodeableConcept", "Desired type of performer for doing the requested service.", 0, 1, performerType));
        children.add(new Property("performer", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|HealthcareService|Patient|Device|RelatedPerson)", "The desired performer for doing the requested service.  For example, the surgeon, dermatopathologist, endoscopist, etc.", 0, java.lang.Integer.MAX_VALUE, performer));
        children.add(new Property("location", "CodeableReference(Location)", "The preferred location(s) where the procedure should actually happen in coded or free text form. E.g. at home or nursing day care center.", 0, java.lang.Integer.MAX_VALUE, location));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "An explanation or justification for why this service is being requested in coded or textual form.   This is often for billing purposes.  May relate to the resources referred to in `supportingInfo`.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("insurance", "Reference(Coverage|ClaimResponse)", "Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be needed for delivering the requested service.", 0, java.lang.Integer.MAX_VALUE, insurance));
        children.add(new Property("supportingInfo", "Reference(Any)", "Additional clinical information about the patient or specimen that may influence the services or their interpretations.     This information includes diagnosis, clinical findings and other observations.  In laboratory ordering these are typically referred to as \"ask at order entry questions (AOEs)\".  This includes observations explicitly requested by the producer (filler) to provide context or supporting information needed to complete the order. For example,  reporting the amount of inspired oxygen for blood gas measurements.", 0, java.lang.Integer.MAX_VALUE, supportingInfo));
        children.add(new Property("specimen", "Reference(Specimen)", "One or more specimens that the laboratory procedure will use.", 0, java.lang.Integer.MAX_VALUE, specimen));
        children.add(new Property("bodySite", "CodeableConcept", "Anatomic location where the procedure should be performed. This is the target site.", 0, java.lang.Integer.MAX_VALUE, bodySite));
        children.add(new Property("note", "Annotation", "Any other notes and comments made about the service request. For example, internal billing notes.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("patientInstruction", "string", "Instructions in terms that are understood by the patient or consumer.", 0, 1, patientInstruction));
        children.add(new Property("relevantHistory", "Reference(Provenance)", "Key events in the history of the request.", 0, java.lang.Integer.MAX_VALUE, relevantHistory));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers assigned to this order instance by the orderer and/or the receiver and/or order fulfiller.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 8911915: /*instantiatesCanonical*/  return new Property("instantiatesCanonical", "canonical(ActivityDefinition|PlanDefinition)", "The URL pointing to a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical);
        case -1926393373: /*instantiatesUri*/  return new Property("instantiatesUri", "uri", "The URL pointing to an externally maintained protocol, guideline, orderset or other definition that is adhered to in whole or in part by this ServiceRequest.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|ServiceRequest|MedicationRequest)", "Plan/proposal/order fulfilled by this request.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -430332865: /*replaces*/  return new Property("replaces", "Reference(ServiceRequest)", "The request takes the place of the referenced completed or terminated request(s).", 0, java.lang.Integer.MAX_VALUE, replaces);
        case 395923612: /*requisition*/  return new Property("requisition", "Identifier", "A shared identifier common to all service requests that were authorized more or less simultaneously by a single author, representing the composite or group identifier.", 0, 1, requisition);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the order.", 0, 1, status);
        case -1183762788: /*intent*/  return new Property("intent", "code", "Whether the request is a proposal, plan, an original order or a reflex order.", 0, 1, intent);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A code that classifies the service for searching, sorting and display purposes (e.g. \"Surgical Procedure\").", 0, java.lang.Integer.MAX_VALUE, category);
        case -1165461084: /*priority*/  return new Property("priority", "code", "Indicates how quickly the ServiceRequest should be addressed with respect to other requests.", 0, 1, priority);
        case -1788508167: /*doNotPerform*/  return new Property("doNotPerform", "boolean", "Set this to true if the record is saying that the service/procedure should NOT be performed.", 0, 1, doNotPerform);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code that identifies a particular service (i.e., procedure, diagnostic investigation, or panel of investigations) that have been requested.", 0, 1, code);
        case 1187338559: /*orderDetail*/  return new Property("orderDetail", "CodeableConcept", "Additional details and instructions about the how the services are to be delivered.   For example, and order for a urinary catheter may have an order detail for an external or indwelling catheter, or an order for a bandage may require additional instructions specifying how the bandage should be applied.", 0, java.lang.Integer.MAX_VALUE, orderDetail);
        case -515002347: /*quantity[x]*/  return new Property("quantity[x]", "Quantity|Ratio|Range", "An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).", 0, 1, quantity);
        case -1285004149: /*quantity*/  return new Property("quantity[x]", "Quantity|Ratio|Range", "An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).", 0, 1, quantity);
        case -1087409610: /*quantityQuantity*/  return new Property("quantity[x]", "Quantity", "An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).", 0, 1, quantity);
        case -1004987840: /*quantityRatio*/  return new Property("quantity[x]", "Ratio", "An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).", 0, 1, quantity);
        case -1004993678: /*quantityRange*/  return new Property("quantity[x]", "Range", "An amount of service being requested which can be a quantity ( for example $1,500 home modification), a ratio ( for example, 20 half day visits per month), or a range (2.0 to 1.8 Gy per fraction).", 0, 1, quantity);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Location|Device)", "On whom or what the service is to be performed. This is usually a human patient, but can also be requested on animals, groups of humans or animals, devices such as dialysis machines, or even locations (typically for environmental scans).", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "An encounter that provides additional information about the healthcare context in which this request is made.", 0, 1, encounter);
        case -2022646513: /*occurrence[x]*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "The date/time at which the requested service should occur.", 0, 1, occurrence);
        case 1687874001: /*occurrence*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "The date/time at which the requested service should occur.", 0, 1, occurrence);
        case -298443636: /*occurrenceDateTime*/  return new Property("occurrence[x]", "dateTime", "The date/time at which the requested service should occur.", 0, 1, occurrence);
        case 1397156594: /*occurrencePeriod*/  return new Property("occurrence[x]", "Period", "The date/time at which the requested service should occur.", 0, 1, occurrence);
        case 1515218299: /*occurrenceTiming*/  return new Property("occurrence[x]", "Timing", "The date/time at which the requested service should occur.", 0, 1, occurrence);
        case -544329575: /*asNeeded[x]*/  return new Property("asNeeded[x]", "boolean|CodeableConcept", "If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc.", 0, 1, asNeeded);
        case -1432923513: /*asNeeded*/  return new Property("asNeeded[x]", "boolean|CodeableConcept", "If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc.", 0, 1, asNeeded);
        case -591717471: /*asNeededBoolean*/  return new Property("asNeeded[x]", "boolean", "If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc.", 0, 1, asNeeded);
        case 1556420122: /*asNeededCodeableConcept*/  return new Property("asNeeded[x]", "CodeableConcept", "If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc.", 0, 1, asNeeded);
        case -1500852503: /*authoredOn*/  return new Property("authoredOn", "dateTime", "When the request transitioned to being actionable.", 0, 1, authoredOn);
        case 693933948: /*requester*/  return new Property("requester", "Reference(Practitioner|PractitionerRole|Organization|Patient|RelatedPerson|Device)", "The individual who initiated the request and has responsibility for its activation.", 0, 1, requester);
        case -901444568: /*performerType*/  return new Property("performerType", "CodeableConcept", "Desired type of performer for doing the requested service.", 0, 1, performerType);
        case 481140686: /*performer*/  return new Property("performer", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|HealthcareService|Patient|Device|RelatedPerson)", "The desired performer for doing the requested service.  For example, the surgeon, dermatopathologist, endoscopist, etc.", 0, java.lang.Integer.MAX_VALUE, performer);
        case 1901043637: /*location*/  return new Property("location", "CodeableReference(Location)", "The preferred location(s) where the procedure should actually happen in coded or free text form. E.g. at home or nursing day care center.", 0, java.lang.Integer.MAX_VALUE, location);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "An explanation or justification for why this service is being requested in coded or textual form.   This is often for billing purposes.  May relate to the resources referred to in `supportingInfo`.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 73049818: /*insurance*/  return new Property("insurance", "Reference(Coverage|ClaimResponse)", "Insurance plans, coverage extensions, pre-authorizations and/or pre-determinations that may be needed for delivering the requested service.", 0, java.lang.Integer.MAX_VALUE, insurance);
        case 1922406657: /*supportingInfo*/  return new Property("supportingInfo", "Reference(Any)", "Additional clinical information about the patient or specimen that may influence the services or their interpretations.     This information includes diagnosis, clinical findings and other observations.  In laboratory ordering these are typically referred to as \"ask at order entry questions (AOEs)\".  This includes observations explicitly requested by the producer (filler) to provide context or supporting information needed to complete the order. For example,  reporting the amount of inspired oxygen for blood gas measurements.", 0, java.lang.Integer.MAX_VALUE, supportingInfo);
        case -2132868344: /*specimen*/  return new Property("specimen", "Reference(Specimen)", "One or more specimens that the laboratory procedure will use.", 0, java.lang.Integer.MAX_VALUE, specimen);
        case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableConcept", "Anatomic location where the procedure should be performed. This is the target site.", 0, java.lang.Integer.MAX_VALUE, bodySite);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Any other notes and comments made about the service request. For example, internal billing notes.", 0, java.lang.Integer.MAX_VALUE, note);
        case 737543241: /*patientInstruction*/  return new Property("patientInstruction", "string", "Instructions in terms that are understood by the patient or consumer.", 0, 1, patientInstruction);
        case 1538891575: /*relevantHistory*/  return new Property("relevantHistory", "Reference(Provenance)", "Key events in the history of the request.", 0, java.lang.Integer.MAX_VALUE, relevantHistory);
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
        case 395923612: /*requisition*/ return this.requisition == null ? new Base[0] : new Base[] {this.requisition}; // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<RequestStatus>
        case -1183762788: /*intent*/ return this.intent == null ? new Base[0] : new Base[] {this.intent}; // Enumeration<RequestIntent>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // Enumeration<RequestPriority>
        case -1788508167: /*doNotPerform*/ return this.doNotPerform == null ? new Base[0] : new Base[] {this.doNotPerform}; // BooleanType
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 1187338559: /*orderDetail*/ return this.orderDetail == null ? new Base[0] : this.orderDetail.toArray(new Base[this.orderDetail.size()]); // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // DataType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 1687874001: /*occurrence*/ return this.occurrence == null ? new Base[0] : new Base[] {this.occurrence}; // DataType
        case -1432923513: /*asNeeded*/ return this.asNeeded == null ? new Base[0] : new Base[] {this.asNeeded}; // DataType
        case -1500852503: /*authoredOn*/ return this.authoredOn == null ? new Base[0] : new Base[] {this.authoredOn}; // DateTimeType
        case 693933948: /*requester*/ return this.requester == null ? new Base[0] : new Base[] {this.requester}; // Reference
        case -901444568: /*performerType*/ return this.performerType == null ? new Base[0] : new Base[] {this.performerType}; // CodeableConcept
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // Reference
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : this.location.toArray(new Base[this.location.size()]); // CodeableReference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 73049818: /*insurance*/ return this.insurance == null ? new Base[0] : this.insurance.toArray(new Base[this.insurance.size()]); // Reference
        case 1922406657: /*supportingInfo*/ return this.supportingInfo == null ? new Base[0] : this.supportingInfo.toArray(new Base[this.supportingInfo.size()]); // Reference
        case -2132868344: /*specimen*/ return this.specimen == null ? new Base[0] : this.specimen.toArray(new Base[this.specimen.size()]); // Reference
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : this.bodySite.toArray(new Base[this.bodySite.size()]); // CodeableConcept
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 737543241: /*patientInstruction*/ return this.patientInstruction == null ? new Base[0] : new Base[] {this.patientInstruction}; // StringType
        case 1538891575: /*relevantHistory*/ return this.relevantHistory == null ? new Base[0] : this.relevantHistory.toArray(new Base[this.relevantHistory.size()]); // Reference
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
        case 395923612: // requisition
          this.requisition = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -892481550: // status
          value = new RequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<RequestStatus>
          return value;
        case -1183762788: // intent
          value = new RequestIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<RequestIntent>
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
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1187338559: // orderDetail
          this.getOrderDetail().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToType(value); // DataType
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1687874001: // occurrence
          this.occurrence = TypeConvertor.castToType(value); // DataType
          return value;
        case -1432923513: // asNeeded
          this.asNeeded = TypeConvertor.castToType(value); // DataType
          return value;
        case -1500852503: // authoredOn
          this.authoredOn = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 693933948: // requester
          this.requester = TypeConvertor.castToReference(value); // Reference
          return value;
        case -901444568: // performerType
          this.performerType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 481140686: // performer
          this.getPerformer().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1901043637: // location
          this.getLocation().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 73049818: // insurance
          this.getInsurance().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1922406657: // supportingInfo
          this.getSupportingInfo().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -2132868344: // specimen
          this.getSpecimen().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1702620169: // bodySite
          this.getBodySite().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 737543241: // patientInstruction
          this.patientInstruction = TypeConvertor.castToString(value); // StringType
          return value;
        case 1538891575: // relevantHistory
          this.getRelevantHistory().add(TypeConvertor.castToReference(value)); // Reference
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
        } else if (name.equals("requisition")) {
          this.requisition = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("status")) {
          value = new RequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<RequestStatus>
        } else if (name.equals("intent")) {
          value = new RequestIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<RequestIntent>
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("priority")) {
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
        } else if (name.equals("doNotPerform")) {
          this.doNotPerform = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("orderDetail")) {
          this.getOrderDetail().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("quantity[x]")) {
          this.quantity = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("occurrence[x]")) {
          this.occurrence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("asNeeded[x]")) {
          this.asNeeded = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("authoredOn")) {
          this.authoredOn = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("requester")) {
          this.requester = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("performerType")) {
          this.performerType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("performer")) {
          this.getPerformer().add(TypeConvertor.castToReference(value));
        } else if (name.equals("location")) {
          this.getLocation().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("insurance")) {
          this.getInsurance().add(TypeConvertor.castToReference(value));
        } else if (name.equals("supportingInfo")) {
          this.getSupportingInfo().add(TypeConvertor.castToReference(value));
        } else if (name.equals("specimen")) {
          this.getSpecimen().add(TypeConvertor.castToReference(value));
        } else if (name.equals("bodySite")) {
          this.getBodySite().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("patientInstruction")) {
          this.patientInstruction = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("relevantHistory")) {
          this.getRelevantHistory().add(TypeConvertor.castToReference(value));
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
        case 395923612:  return getRequisition();
        case -892481550:  return getStatusElement();
        case -1183762788:  return getIntentElement();
        case 50511102:  return addCategory(); 
        case -1165461084:  return getPriorityElement();
        case -1788508167:  return getDoNotPerformElement();
        case 3059181:  return getCode();
        case 1187338559:  return addOrderDetail(); 
        case -515002347:  return getQuantity();
        case -1285004149:  return getQuantity();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -2022646513:  return getOccurrence();
        case 1687874001:  return getOccurrence();
        case -544329575:  return getAsNeeded();
        case -1432923513:  return getAsNeeded();
        case -1500852503:  return getAuthoredOnElement();
        case 693933948:  return getRequester();
        case -901444568:  return getPerformerType();
        case 481140686:  return addPerformer(); 
        case 1901043637:  return addLocation(); 
        case -934964668:  return addReason(); 
        case 73049818:  return addInsurance(); 
        case 1922406657:  return addSupportingInfo(); 
        case -2132868344:  return addSpecimen(); 
        case 1702620169:  return addBodySite(); 
        case 3387378:  return addNote(); 
        case 737543241:  return getPatientInstructionElement();
        case 1538891575:  return addRelevantHistory(); 
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
        case 395923612: /*requisition*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1183762788: /*intent*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1165461084: /*priority*/ return new String[] {"code"};
        case -1788508167: /*doNotPerform*/ return new String[] {"boolean"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 1187338559: /*orderDetail*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity", "Ratio", "Range"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 1687874001: /*occurrence*/ return new String[] {"dateTime", "Period", "Timing"};
        case -1432923513: /*asNeeded*/ return new String[] {"boolean", "CodeableConcept"};
        case -1500852503: /*authoredOn*/ return new String[] {"dateTime"};
        case 693933948: /*requester*/ return new String[] {"Reference"};
        case -901444568: /*performerType*/ return new String[] {"CodeableConcept"};
        case 481140686: /*performer*/ return new String[] {"Reference"};
        case 1901043637: /*location*/ return new String[] {"CodeableReference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 73049818: /*insurance*/ return new String[] {"Reference"};
        case 1922406657: /*supportingInfo*/ return new String[] {"Reference"};
        case -2132868344: /*specimen*/ return new String[] {"Reference"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableConcept"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 737543241: /*patientInstruction*/ return new String[] {"string"};
        case 1538891575: /*relevantHistory*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("instantiatesCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type ServiceRequest.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type ServiceRequest.instantiatesUri");
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("replaces")) {
          return addReplaces();
        }
        else if (name.equals("requisition")) {
          this.requisition = new Identifier();
          return this.requisition;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type ServiceRequest.status");
        }
        else if (name.equals("intent")) {
          throw new FHIRException("Cannot call addChild on a primitive type ServiceRequest.intent");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a primitive type ServiceRequest.priority");
        }
        else if (name.equals("doNotPerform")) {
          throw new FHIRException("Cannot call addChild on a primitive type ServiceRequest.doNotPerform");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("orderDetail")) {
          return addOrderDetail();
        }
        else if (name.equals("quantityQuantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("quantityRatio")) {
          this.quantity = new Ratio();
          return this.quantity;
        }
        else if (name.equals("quantityRange")) {
          this.quantity = new Range();
          return this.quantity;
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
          this.occurrence = new DateTimeType();
          return this.occurrence;
        }
        else if (name.equals("occurrencePeriod")) {
          this.occurrence = new Period();
          return this.occurrence;
        }
        else if (name.equals("occurrenceTiming")) {
          this.occurrence = new Timing();
          return this.occurrence;
        }
        else if (name.equals("asNeededBoolean")) {
          this.asNeeded = new BooleanType();
          return this.asNeeded;
        }
        else if (name.equals("asNeededCodeableConcept")) {
          this.asNeeded = new CodeableConcept();
          return this.asNeeded;
        }
        else if (name.equals("authoredOn")) {
          throw new FHIRException("Cannot call addChild on a primitive type ServiceRequest.authoredOn");
        }
        else if (name.equals("requester")) {
          this.requester = new Reference();
          return this.requester;
        }
        else if (name.equals("performerType")) {
          this.performerType = new CodeableConcept();
          return this.performerType;
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("location")) {
          return addLocation();
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("insurance")) {
          return addInsurance();
        }
        else if (name.equals("supportingInfo")) {
          return addSupportingInfo();
        }
        else if (name.equals("specimen")) {
          return addSpecimen();
        }
        else if (name.equals("bodySite")) {
          return addBodySite();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("patientInstruction")) {
          throw new FHIRException("Cannot call addChild on a primitive type ServiceRequest.patientInstruction");
        }
        else if (name.equals("relevantHistory")) {
          return addRelevantHistory();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ServiceRequest";

  }

      public ServiceRequest copy() {
        ServiceRequest dst = new ServiceRequest();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ServiceRequest dst) {
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
        dst.requisition = requisition == null ? null : requisition.copy();
        dst.status = status == null ? null : status.copy();
        dst.intent = intent == null ? null : intent.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.priority = priority == null ? null : priority.copy();
        dst.doNotPerform = doNotPerform == null ? null : doNotPerform.copy();
        dst.code = code == null ? null : code.copy();
        if (orderDetail != null) {
          dst.orderDetail = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : orderDetail)
            dst.orderDetail.add(i.copy());
        };
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.occurrence = occurrence == null ? null : occurrence.copy();
        dst.asNeeded = asNeeded == null ? null : asNeeded.copy();
        dst.authoredOn = authoredOn == null ? null : authoredOn.copy();
        dst.requester = requester == null ? null : requester.copy();
        dst.performerType = performerType == null ? null : performerType.copy();
        if (performer != null) {
          dst.performer = new ArrayList<Reference>();
          for (Reference i : performer)
            dst.performer.add(i.copy());
        };
        if (location != null) {
          dst.location = new ArrayList<CodeableReference>();
          for (CodeableReference i : location)
            dst.location.add(i.copy());
        };
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        if (insurance != null) {
          dst.insurance = new ArrayList<Reference>();
          for (Reference i : insurance)
            dst.insurance.add(i.copy());
        };
        if (supportingInfo != null) {
          dst.supportingInfo = new ArrayList<Reference>();
          for (Reference i : supportingInfo)
            dst.supportingInfo.add(i.copy());
        };
        if (specimen != null) {
          dst.specimen = new ArrayList<Reference>();
          for (Reference i : specimen)
            dst.specimen.add(i.copy());
        };
        if (bodySite != null) {
          dst.bodySite = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : bodySite)
            dst.bodySite.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.patientInstruction = patientInstruction == null ? null : patientInstruction.copy();
        if (relevantHistory != null) {
          dst.relevantHistory = new ArrayList<Reference>();
          for (Reference i : relevantHistory)
            dst.relevantHistory.add(i.copy());
        };
      }

      protected ServiceRequest typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ServiceRequest))
          return false;
        ServiceRequest o = (ServiceRequest) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareDeep(instantiatesUri, o.instantiatesUri, true) && compareDeep(basedOn, o.basedOn, true)
           && compareDeep(replaces, o.replaces, true) && compareDeep(requisition, o.requisition, true) && compareDeep(status, o.status, true)
           && compareDeep(intent, o.intent, true) && compareDeep(category, o.category, true) && compareDeep(priority, o.priority, true)
           && compareDeep(doNotPerform, o.doNotPerform, true) && compareDeep(code, o.code, true) && compareDeep(orderDetail, o.orderDetail, true)
           && compareDeep(quantity, o.quantity, true) && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true)
           && compareDeep(occurrence, o.occurrence, true) && compareDeep(asNeeded, o.asNeeded, true) && compareDeep(authoredOn, o.authoredOn, true)
           && compareDeep(requester, o.requester, true) && compareDeep(performerType, o.performerType, true)
           && compareDeep(performer, o.performer, true) && compareDeep(location, o.location, true) && compareDeep(reason, o.reason, true)
           && compareDeep(insurance, o.insurance, true) && compareDeep(supportingInfo, o.supportingInfo, true)
           && compareDeep(specimen, o.specimen, true) && compareDeep(bodySite, o.bodySite, true) && compareDeep(note, o.note, true)
           && compareDeep(patientInstruction, o.patientInstruction, true) && compareDeep(relevantHistory, o.relevantHistory, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ServiceRequest))
          return false;
        ServiceRequest o = (ServiceRequest) other_;
        return compareValues(instantiatesCanonical, o.instantiatesCanonical, true) && compareValues(instantiatesUri, o.instantiatesUri, true)
           && compareValues(status, o.status, true) && compareValues(intent, o.intent, true) && compareValues(priority, o.priority, true)
           && compareValues(doNotPerform, o.doNotPerform, true) && compareValues(authoredOn, o.authoredOn, true)
           && compareValues(patientInstruction, o.patientInstruction, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, instantiatesCanonical
          , instantiatesUri, basedOn, replaces, requisition, status, intent, category, priority
          , doNotPerform, code, orderDetail, quantity, subject, encounter, occurrence, asNeeded
          , authoredOn, requester, performerType, performer, location, reason, insurance
          , supportingInfo, specimen, bodySite, note, patientInstruction, relevantHistory
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ServiceRequest;
   }

 /**
   * Search parameter: <b>authored</b>
   * <p>
   * Description: <b>Date request signed</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ServiceRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="authored", path="ServiceRequest.authoredOn", description="Date request signed", type="date" )
  public static final String SP_AUTHORED = "authored";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>authored</b>
   * <p>
   * Description: <b>Date request signed</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ServiceRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam AUTHORED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_AUTHORED);

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>What request fulfills</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="ServiceRequest.basedOn", description="What request fulfills", type="reference", target={CarePlan.class, MedicationRequest.class, ServiceRequest.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>What request fulfills</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ServiceRequest:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("ServiceRequest:based-on").toLocked();

 /**
   * Search parameter: <b>body-site</b>
   * <p>
   * Description: <b>Where procedure is going to be done</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.bodySite</b><br>
   * </p>
   */
  @SearchParamDefinition(name="body-site", path="ServiceRequest.bodySite", description="Where procedure is going to be done", type="token" )
  public static final String SP_BODY_SITE = "body-site";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>body-site</b>
   * <p>
   * Description: <b>Where procedure is going to be done</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.bodySite</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam BODY_SITE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_BODY_SITE);

 /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>Classification of service</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="ServiceRequest.category", description="Classification of service", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>Classification of service</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>instantiates-canonical</b>
   * <p>
   * Description: <b>Instantiates FHIR protocol or definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.instantiatesCanonical</b><br>
   * </p>
   */
  @SearchParamDefinition(name="instantiates-canonical", path="ServiceRequest.instantiatesCanonical", description="Instantiates FHIR protocol or definition", type="reference", target={ActivityDefinition.class, PlanDefinition.class } )
  public static final String SP_INSTANTIATES_CANONICAL = "instantiates-canonical";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>instantiates-canonical</b>
   * <p>
   * Description: <b>Instantiates FHIR protocol or definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.instantiatesCanonical</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INSTANTIATES_CANONICAL = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INSTANTIATES_CANONICAL);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ServiceRequest:instantiates-canonical</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INSTANTIATES_CANONICAL = new ca.uhn.fhir.model.api.Include("ServiceRequest:instantiates-canonical").toLocked();

 /**
   * Search parameter: <b>instantiates-uri</b>
   * <p>
   * Description: <b>Instantiates external protocol or definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ServiceRequest.instantiatesUri</b><br>
   * </p>
   */
  @SearchParamDefinition(name="instantiates-uri", path="ServiceRequest.instantiatesUri", description="Instantiates external protocol or definition", type="uri" )
  public static final String SP_INSTANTIATES_URI = "instantiates-uri";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>instantiates-uri</b>
   * <p>
   * Description: <b>Instantiates external protocol or definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ServiceRequest.instantiatesUri</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam INSTANTIATES_URI = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_INSTANTIATES_URI);

 /**
   * Search parameter: <b>intent</b>
   * <p>
   * Description: <b>proposal | plan | directive | order +</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.intent</b><br>
   * </p>
   */
  @SearchParamDefinition(name="intent", path="ServiceRequest.intent", description="proposal | plan | directive | order +", type="token" )
  public static final String SP_INTENT = "intent";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>intent</b>
   * <p>
   * Description: <b>proposal | plan | directive | order +</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.intent</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INTENT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INTENT);

 /**
   * Search parameter: <b>occurrence</b>
   * <p>
   * Description: <b>When service should occur</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ServiceRequest.occurrence</b><br>
   * </p>
   */
  @SearchParamDefinition(name="occurrence", path="ServiceRequest.occurrence", description="When service should occur", type="date" )
  public static final String SP_OCCURRENCE = "occurrence";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>occurrence</b>
   * <p>
   * Description: <b>When service should occur</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ServiceRequest.occurrence</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam OCCURRENCE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_OCCURRENCE);

 /**
   * Search parameter: <b>performer-type</b>
   * <p>
   * Description: <b>Performer role</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.performerType</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performer-type", path="ServiceRequest.performerType", description="Performer role", type="token" )
  public static final String SP_PERFORMER_TYPE = "performer-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>performer-type</b>
   * <p>
   * Description: <b>Performer role</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.performerType</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PERFORMER_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PERFORMER_TYPE);

 /**
   * Search parameter: <b>performer</b>
   * <p>
   * Description: <b>Requested performer</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.performer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performer", path="ServiceRequest.performer", description="Requested performer", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={CareTeam.class, Device.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_PERFORMER = "performer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>performer</b>
   * <p>
   * Description: <b>Requested performer</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.performer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PERFORMER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PERFORMER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ServiceRequest:performer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PERFORMER = new ca.uhn.fhir.model.api.Include("ServiceRequest:performer").toLocked();

 /**
   * Search parameter: <b>priority</b>
   * <p>
   * Description: <b>routine | urgent | asap | stat</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.priority</b><br>
   * </p>
   */
  @SearchParamDefinition(name="priority", path="ServiceRequest.priority", description="routine | urgent | asap | stat", type="token" )
  public static final String SP_PRIORITY = "priority";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>priority</b>
   * <p>
   * Description: <b>routine | urgent | asap | stat</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.priority</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PRIORITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PRIORITY);

 /**
   * Search parameter: <b>replaces</b>
   * <p>
   * Description: <b>What request replaces</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.replaces</b><br>
   * </p>
   */
  @SearchParamDefinition(name="replaces", path="ServiceRequest.replaces", description="What request replaces", type="reference", target={ServiceRequest.class } )
  public static final String SP_REPLACES = "replaces";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>replaces</b>
   * <p>
   * Description: <b>What request replaces</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.replaces</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REPLACES = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REPLACES);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ServiceRequest:replaces</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REPLACES = new ca.uhn.fhir.model.api.Include("ServiceRequest:replaces").toLocked();

 /**
   * Search parameter: <b>requester</b>
   * <p>
   * Description: <b>Who/what is requesting service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.requester</b><br>
   * </p>
   */
  @SearchParamDefinition(name="requester", path="ServiceRequest.requester", description="Who/what is requesting service", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_REQUESTER = "requester";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>requester</b>
   * <p>
   * Description: <b>Who/what is requesting service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.requester</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REQUESTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REQUESTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ServiceRequest:requester</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REQUESTER = new ca.uhn.fhir.model.api.Include("ServiceRequest:requester").toLocked();

 /**
   * Search parameter: <b>requisition</b>
   * <p>
   * Description: <b>Composite Request ID</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.requisition</b><br>
   * </p>
   */
  @SearchParamDefinition(name="requisition", path="ServiceRequest.requisition", description="Composite Request ID", type="token" )
  public static final String SP_REQUISITION = "requisition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>requisition</b>
   * <p>
   * Description: <b>Composite Request ID</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.requisition</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam REQUISITION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_REQUISITION);

 /**
   * Search parameter: <b>specimen</b>
   * <p>
   * Description: <b>Specimen to be tested</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.specimen</b><br>
   * </p>
   */
  @SearchParamDefinition(name="specimen", path="ServiceRequest.specimen", description="Specimen to be tested", type="reference", target={Specimen.class } )
  public static final String SP_SPECIMEN = "specimen";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>specimen</b>
   * <p>
   * Description: <b>Specimen to be tested</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.specimen</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SPECIMEN = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SPECIMEN);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ServiceRequest:specimen</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SPECIMEN = new ca.uhn.fhir.model.api.Include("ServiceRequest:specimen").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>draft | active | on-hold | revoked | completed | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ServiceRequest.status", description="draft | active | on-hold | revoked | completed | entered-in-error | unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>draft | active | on-hold | revoked | completed | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ServiceRequest.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Search by subject</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="ServiceRequest.subject", description="Search by subject", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Device.class, Group.class, Location.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Search by subject</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ServiceRequest.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ServiceRequest:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("ServiceRequest:subject").toLocked();

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [Condition](condition.html): Code for the condition
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationUsage](medicationusage.html): Return statements of this medication code
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [ServiceRequest](servicerequest.html): What is being requested/ordered
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code | ServiceRequest.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code | ServiceRequest.code", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance\r\n* [Condition](condition.html): Code for the condition\r\n* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered\r\n* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code\r\n* [List](list.html): What the purpose of this list is\r\n* [Medication](medication.html): Returns medications for a specific code\r\n* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code\r\n* [MedicationUsage](medicationusage.html): Return statements of this medication code\r\n* [Observation](observation.html): The code of the observation type\r\n* [Procedure](procedure.html): A code to identify a  procedure\r\n* [ServiceRequest](servicerequest.html): What is being requested/ordered\r\n", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [Condition](condition.html): Code for the condition
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationUsage](medicationusage.html): Return statements of this medication code
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [ServiceRequest](servicerequest.html): What is being requested/ordered
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code | ServiceRequest.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Composition](composition.html): Context of the Composition
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [DocumentReference](documentreference.html): Context of the document  content
* [Flag](flag.html): Alert relevant during encounter
* [List](list.html): Context in which list created
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Composition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | DocumentReference.context.encounter | Flag.encounter | List.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | RiskAssessment.encounter | ServiceRequest.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="Composition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | DocumentReference.context.encounter | Flag.encounter | List.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | RiskAssessment.encounter | ServiceRequest.encounter | VisionPrescription.encounter", description="Multiple Resources: \r\n\r\n* [Composition](composition.html): Context of the Composition\r\n* [DeviceRequest](devicerequest.html): Encounter during which request was created\r\n* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made\r\n* [DocumentReference](documentreference.html): Context of the document  content\r\n* [Flag](flag.html): Alert relevant during encounter\r\n* [List](list.html): Context in which list created\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier\r\n* [Observation](observation.html): Encounter related to the observation\r\n* [Procedure](procedure.html): The Encounter during which this Procedure was created\r\n* [RiskAssessment](riskassessment.html): Where was assessment performed?\r\n* [ServiceRequest](servicerequest.html): An encounter in which this request is made\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Composition](composition.html): Context of the Composition
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [DocumentReference](documentreference.html): Context of the document  content
* [Flag](flag.html): Alert relevant during encounter
* [List](list.html): Context in which list created
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Composition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | DocumentReference.context.encounter | Flag.encounter | List.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | RiskAssessment.encounter | ServiceRequest.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ServiceRequest:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("ServiceRequest:encounter").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents
* [DocumentReference](documentreference.html): Master Version Specific Identifier
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number
* [Immunization](immunization.html): Business identifier
* [List](list.html): Business identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationUsage](medicationusage.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Procedure](procedure.html): A unique identifier for a procedure
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents\r\n* [DocumentReference](documentreference.html): Master Version Specific Identifier\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number\r\n* [Immunization](immunization.html): Business identifier\r\n* [List](list.html): Business identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationUsage](medicationusage.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents
* [DocumentReference](documentreference.html): Master Version Specific Identifier
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number
* [Immunization](immunization.html): Business identifier
* [List](list.html): Business identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationUsage](medicationusage.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Procedure](procedure.html): A unique identifier for a procedure
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient or group assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient or group present at the encounter
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [List](list.html): If all resources have the same subject
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ClinicalImpression](clinicalimpression.html): Patient or group assessed\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentManifest](documentmanifest.html): The subject of the set of documents\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient or group present at the encounter\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [List](list.html): If all resources have the same subject\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", target={Group.class, Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient or group assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient or group present at the encounter
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [List](list.html): If all resources have the same subject
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ServiceRequest:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("ServiceRequest:patient").toLocked();


}