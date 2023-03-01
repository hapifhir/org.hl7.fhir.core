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
 * The details of a healthcare service available at a location or in a catalog.  In the case where there is a hierarchy of services (for example, Lab -> Pathology -> Wound Cultures), this can be represented using a set of linked HealthcareServices.
 */
@ResourceDef(name="HealthcareService", profile="http://hl7.org/fhir/StructureDefinition/HealthcareService")
public class HealthcareService extends DomainResource {

    @Block()
    public static class HealthcareServiceEligibilityComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Coded value for the eligibility.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Coded value for the eligibility", formalDefinition="Coded value for the eligibility." )
        protected CodeableConcept code;

        /**
         * Describes the eligibility conditions for the service.
         */
        @Child(name = "comment", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Describes the eligibility conditions for the service", formalDefinition="Describes the eligibility conditions for the service." )
        protected MarkdownType comment;

        private static final long serialVersionUID = 1078065348L;

    /**
     * Constructor
     */
      public HealthcareServiceEligibilityComponent() {
        super();
      }

        /**
         * @return {@link #code} (Coded value for the eligibility.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create HealthcareServiceEligibilityComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Coded value for the eligibility.)
         */
        public HealthcareServiceEligibilityComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #comment} (Describes the eligibility conditions for the service.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
         */
        public MarkdownType getCommentElement() { 
          if (this.comment == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create HealthcareServiceEligibilityComponent.comment");
            else if (Configuration.doAutoCreate())
              this.comment = new MarkdownType(); // bb
          return this.comment;
        }

        public boolean hasCommentElement() { 
          return this.comment != null && !this.comment.isEmpty();
        }

        public boolean hasComment() { 
          return this.comment != null && !this.comment.isEmpty();
        }

        /**
         * @param value {@link #comment} (Describes the eligibility conditions for the service.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
         */
        public HealthcareServiceEligibilityComponent setCommentElement(MarkdownType value) { 
          this.comment = value;
          return this;
        }

        /**
         * @return Describes the eligibility conditions for the service.
         */
        public String getComment() { 
          return this.comment == null ? null : this.comment.getValue();
        }

        /**
         * @param value Describes the eligibility conditions for the service.
         */
        public HealthcareServiceEligibilityComponent setComment(String value) { 
          if (Utilities.noString(value))
            this.comment = null;
          else {
            if (this.comment == null)
              this.comment = new MarkdownType();
            this.comment.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "Coded value for the eligibility.", 0, 1, code));
          children.add(new Property("comment", "markdown", "Describes the eligibility conditions for the service.", 0, 1, comment));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Coded value for the eligibility.", 0, 1, code);
          case 950398559: /*comment*/  return new Property("comment", "markdown", "Describes the eligibility conditions for the service.", 0, 1, comment);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 950398559: // comment
          this.comment = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("comment")) {
          this.comment = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case 950398559:  return getCommentElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 950398559: /*comment*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a primitive type HealthcareService.eligibility.comment");
        }
        else
          return super.addChild(name);
      }

      public HealthcareServiceEligibilityComponent copy() {
        HealthcareServiceEligibilityComponent dst = new HealthcareServiceEligibilityComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(HealthcareServiceEligibilityComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.comment = comment == null ? null : comment.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof HealthcareServiceEligibilityComponent))
          return false;
        HealthcareServiceEligibilityComponent o = (HealthcareServiceEligibilityComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(comment, o.comment, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof HealthcareServiceEligibilityComponent))
          return false;
        HealthcareServiceEligibilityComponent o = (HealthcareServiceEligibilityComponent) other_;
        return compareValues(comment, o.comment, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, comment);
      }

  public String fhirType() {
    return "HealthcareService.eligibility";

  }

  }

    /**
     * External identifiers for this item.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External identifiers for this item", formalDefinition="External identifiers for this item." )
    protected List<Identifier> identifier;

    /**
     * This flag is used to mark the record to not be used. This is not used when a center is closed for maintenance, or for holidays, the notAvailable period is to be used for this.
     */
    @Child(name = "active", type = {BooleanType.class}, order=1, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="Whether this HealthcareService record is in active use", formalDefinition="This flag is used to mark the record to not be used. This is not used when a center is closed for maintenance, or for holidays, the notAvailable period is to be used for this." )
    protected BooleanType active;

    /**
     * The organization that provides this healthcare service.
     */
    @Child(name = "providedBy", type = {Organization.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Organization that provides this service", formalDefinition="The organization that provides this healthcare service." )
    protected Reference providedBy;

    /**
     * When the HealthcareService is representing a specific, schedulable service, the availableIn property can refer to a generic service.
     */
    @Child(name = "offeredIn", type = {HealthcareService.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The service within which this service is offered", formalDefinition="When the HealthcareService is representing a specific, schedulable service, the availableIn property can refer to a generic service." )
    protected List<Reference> offeredIn;

    /**
     * Identifies the broad category of service being performed or delivered.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Broad category of service being performed or delivered", formalDefinition="Identifies the broad category of service being performed or delivered." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-category")
    protected List<CodeableConcept> category;

    /**
     * The specific type of service that may be delivered or performed.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Type of service that may be delivered or performed", formalDefinition="The specific type of service that may be delivered or performed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-type")
    protected List<CodeableConcept> type;

    /**
     * Collection of specialties handled by the Healthcare service. This is more of a medical term.
     */
    @Child(name = "specialty", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Specialties handled by the HealthcareService", formalDefinition="Collection of specialties handled by the Healthcare service. This is more of a medical term." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-practice-codes")
    protected List<CodeableConcept> specialty;

    /**
     * The location(s) where this healthcare service may be provided.
     */
    @Child(name = "location", type = {Location.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Location(s) where service may be provided", formalDefinition="The location(s) where this healthcare service may be provided." )
    protected List<Reference> location;

    /**
     * Further description of the service as it would be presented to a consumer while searching.
     */
    @Child(name = "name", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Description of service as presented to a consumer while searching", formalDefinition="Further description of the service as it would be presented to a consumer while searching." )
    protected StringType name;

    /**
     * Any additional description of the service and/or any specific issues not covered by the other attributes, which can be displayed as further detail under the serviceName.
     */
    @Child(name = "comment", type = {MarkdownType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Additional description and/or any specific issues not covered elsewhere", formalDefinition="Any additional description of the service and/or any specific issues not covered by the other attributes, which can be displayed as further detail under the serviceName." )
    protected MarkdownType comment;

    /**
     * Extra details about the service that can't be placed in the other fields.
     */
    @Child(name = "extraDetails", type = {MarkdownType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Extra details about the service that can't be placed in the other fields", formalDefinition="Extra details about the service that can't be placed in the other fields." )
    protected MarkdownType extraDetails;

    /**
     * If there is a photo/symbol associated with this HealthcareService, it may be included here to facilitate quick identification of the service in a list.
     */
    @Child(name = "photo", type = {Attachment.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Facilitates quick identification of the service", formalDefinition="If there is a photo/symbol associated with this HealthcareService, it may be included here to facilitate quick identification of the service in a list." )
    protected Attachment photo;

    /**
     * The contact details of communication devices available relevant to the specific HealthcareService. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.
     */
    @Child(name = "contact", type = {ExtendedContactDetail.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Official contact details for the HealthcareService", formalDefinition="The contact details of communication devices available relevant to the specific HealthcareService. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites." )
    protected List<ExtendedContactDetail> contact;

    /**
     * The location(s) that this service is available to (not where the service is provided).
     */
    @Child(name = "coverageArea", type = {Location.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Location(s) service is intended for/available to", formalDefinition="The location(s) that this service is available to (not where the service is provided)." )
    protected List<Reference> coverageArea;

    /**
     * The code(s) that detail the conditions under which the healthcare service is available/offered.
     */
    @Child(name = "serviceProvisionCode", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Conditions under which service is available/offered", formalDefinition="The code(s) that detail the conditions under which the healthcare service is available/offered." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-provision-conditions")
    protected List<CodeableConcept> serviceProvisionCode;

    /**
     * Does this service have specific eligibility requirements that need to be met in order to use the service?
     */
    @Child(name = "eligibility", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Specific eligibility requirements required to use the service", formalDefinition="Does this service have specific eligibility requirements that need to be met in order to use the service?" )
    protected List<HealthcareServiceEligibilityComponent> eligibility;

    /**
     * Programs that this service is applicable to.
     */
    @Child(name = "program", type = {CodeableConcept.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Programs that this service is applicable to", formalDefinition="Programs that this service is applicable to." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/program")
    protected List<CodeableConcept> program;

    /**
     * Collection of characteristics (attributes).
     */
    @Child(name = "characteristic", type = {CodeableConcept.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Collection of characteristics (attributes)", formalDefinition="Collection of characteristics (attributes)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-mode")
    protected List<CodeableConcept> characteristic;

    /**
     * Some services are specifically made available in multiple languages, this property permits a directory to declare the languages this is offered in. Typically this is only provided where a service operates in communities with mixed languages used.
     */
    @Child(name = "communication", type = {CodeableConcept.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The language that this service is offered in", formalDefinition="Some services are specifically made available in multiple languages, this property permits a directory to declare the languages this is offered in. Typically this is only provided where a service operates in communities with mixed languages used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/all-languages")
    protected List<CodeableConcept> communication;

    /**
     * Ways that the service accepts referrals, if this is not provided then it is implied that no referral is required.
     */
    @Child(name = "referralMethod", type = {CodeableConcept.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Ways that the service accepts referrals", formalDefinition="Ways that the service accepts referrals, if this is not provided then it is implied that no referral is required." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-referral-method")
    protected List<CodeableConcept> referralMethod;

    /**
     * Indicates whether or not a prospective consumer will require an appointment for a particular service at a site to be provided by the Organization. Indicates if an appointment is required for access to this service.
     */
    @Child(name = "appointmentRequired", type = {BooleanType.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="If an appointment is required for access to this service", formalDefinition="Indicates whether or not a prospective consumer will require an appointment for a particular service at a site to be provided by the Organization. Indicates if an appointment is required for access to this service." )
    protected BooleanType appointmentRequired;

    /**
     * A collection of times that the healthcare service is available.
     */
    @Child(name = "availability", type = {Availability.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Times the healthcare service is available (including exceptions)", formalDefinition="A collection of times that the healthcare service is available." )
    protected List<Availability> availability;

    /**
     * Technical endpoints providing access to services operated for the specific healthcare services defined at this resource.
     */
    @Child(name = "endpoint", type = {Endpoint.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Technical endpoints providing access to electronic services operated for the healthcare service", formalDefinition="Technical endpoints providing access to services operated for the specific healthcare services defined at this resource." )
    protected List<Reference> endpoint;

    private static final long serialVersionUID = -438716159L;

  /**
   * Constructor
   */
    public HealthcareService() {
      super();
    }

    /**
     * @return {@link #identifier} (External identifiers for this item.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setIdentifier(List<Identifier> theIdentifier) { 
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

    public HealthcareService addIdentifier(Identifier t) { //3
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
     * @return {@link #active} (This flag is used to mark the record to not be used. This is not used when a center is closed for maintenance, or for holidays, the notAvailable period is to be used for this.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public BooleanType getActiveElement() { 
      if (this.active == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create HealthcareService.active");
        else if (Configuration.doAutoCreate())
          this.active = new BooleanType(); // bb
      return this.active;
    }

    public boolean hasActiveElement() { 
      return this.active != null && !this.active.isEmpty();
    }

    public boolean hasActive() { 
      return this.active != null && !this.active.isEmpty();
    }

    /**
     * @param value {@link #active} (This flag is used to mark the record to not be used. This is not used when a center is closed for maintenance, or for holidays, the notAvailable period is to be used for this.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public HealthcareService setActiveElement(BooleanType value) { 
      this.active = value;
      return this;
    }

    /**
     * @return This flag is used to mark the record to not be used. This is not used when a center is closed for maintenance, or for holidays, the notAvailable period is to be used for this.
     */
    public boolean getActive() { 
      return this.active == null || this.active.isEmpty() ? false : this.active.getValue();
    }

    /**
     * @param value This flag is used to mark the record to not be used. This is not used when a center is closed for maintenance, or for holidays, the notAvailable period is to be used for this.
     */
    public HealthcareService setActive(boolean value) { 
        if (this.active == null)
          this.active = new BooleanType();
        this.active.setValue(value);
      return this;
    }

    /**
     * @return {@link #providedBy} (The organization that provides this healthcare service.)
     */
    public Reference getProvidedBy() { 
      if (this.providedBy == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create HealthcareService.providedBy");
        else if (Configuration.doAutoCreate())
          this.providedBy = new Reference(); // cc
      return this.providedBy;
    }

    public boolean hasProvidedBy() { 
      return this.providedBy != null && !this.providedBy.isEmpty();
    }

    /**
     * @param value {@link #providedBy} (The organization that provides this healthcare service.)
     */
    public HealthcareService setProvidedBy(Reference value) { 
      this.providedBy = value;
      return this;
    }

    /**
     * @return {@link #offeredIn} (When the HealthcareService is representing a specific, schedulable service, the availableIn property can refer to a generic service.)
     */
    public List<Reference> getOfferedIn() { 
      if (this.offeredIn == null)
        this.offeredIn = new ArrayList<Reference>();
      return this.offeredIn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setOfferedIn(List<Reference> theOfferedIn) { 
      this.offeredIn = theOfferedIn;
      return this;
    }

    public boolean hasOfferedIn() { 
      if (this.offeredIn == null)
        return false;
      for (Reference item : this.offeredIn)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addOfferedIn() { //3
      Reference t = new Reference();
      if (this.offeredIn == null)
        this.offeredIn = new ArrayList<Reference>();
      this.offeredIn.add(t);
      return t;
    }

    public HealthcareService addOfferedIn(Reference t) { //3
      if (t == null)
        return this;
      if (this.offeredIn == null)
        this.offeredIn = new ArrayList<Reference>();
      this.offeredIn.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #offeredIn}, creating it if it does not already exist {3}
     */
    public Reference getOfferedInFirstRep() { 
      if (getOfferedIn().isEmpty()) {
        addOfferedIn();
      }
      return getOfferedIn().get(0);
    }

    /**
     * @return {@link #category} (Identifies the broad category of service being performed or delivered.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setCategory(List<CodeableConcept> theCategory) { 
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

    public HealthcareService addCategory(CodeableConcept t) { //3
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
     * @return {@link #type} (The specific type of service that may be delivered or performed.)
     */
    public List<CodeableConcept> getType() { 
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      return this.type;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setType(List<CodeableConcept> theType) { 
      this.type = theType;
      return this;
    }

    public boolean hasType() { 
      if (this.type == null)
        return false;
      for (CodeableConcept item : this.type)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addType() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return t;
    }

    public HealthcareService addType(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist {3}
     */
    public CodeableConcept getTypeFirstRep() { 
      if (getType().isEmpty()) {
        addType();
      }
      return getType().get(0);
    }

    /**
     * @return {@link #specialty} (Collection of specialties handled by the Healthcare service. This is more of a medical term.)
     */
    public List<CodeableConcept> getSpecialty() { 
      if (this.specialty == null)
        this.specialty = new ArrayList<CodeableConcept>();
      return this.specialty;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setSpecialty(List<CodeableConcept> theSpecialty) { 
      this.specialty = theSpecialty;
      return this;
    }

    public boolean hasSpecialty() { 
      if (this.specialty == null)
        return false;
      for (CodeableConcept item : this.specialty)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addSpecialty() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.specialty == null)
        this.specialty = new ArrayList<CodeableConcept>();
      this.specialty.add(t);
      return t;
    }

    public HealthcareService addSpecialty(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.specialty == null)
        this.specialty = new ArrayList<CodeableConcept>();
      this.specialty.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #specialty}, creating it if it does not already exist {3}
     */
    public CodeableConcept getSpecialtyFirstRep() { 
      if (getSpecialty().isEmpty()) {
        addSpecialty();
      }
      return getSpecialty().get(0);
    }

    /**
     * @return {@link #location} (The location(s) where this healthcare service may be provided.)
     */
    public List<Reference> getLocation() { 
      if (this.location == null)
        this.location = new ArrayList<Reference>();
      return this.location;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setLocation(List<Reference> theLocation) { 
      this.location = theLocation;
      return this;
    }

    public boolean hasLocation() { 
      if (this.location == null)
        return false;
      for (Reference item : this.location)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addLocation() { //3
      Reference t = new Reference();
      if (this.location == null)
        this.location = new ArrayList<Reference>();
      this.location.add(t);
      return t;
    }

    public HealthcareService addLocation(Reference t) { //3
      if (t == null)
        return this;
      if (this.location == null)
        this.location = new ArrayList<Reference>();
      this.location.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #location}, creating it if it does not already exist {3}
     */
    public Reference getLocationFirstRep() { 
      if (getLocation().isEmpty()) {
        addLocation();
      }
      return getLocation().get(0);
    }

    /**
     * @return {@link #name} (Further description of the service as it would be presented to a consumer while searching.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create HealthcareService.name");
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
     * @param value {@link #name} (Further description of the service as it would be presented to a consumer while searching.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public HealthcareService setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return Further description of the service as it would be presented to a consumer while searching.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value Further description of the service as it would be presented to a consumer while searching.
     */
    public HealthcareService setName(String value) { 
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
     * @return {@link #comment} (Any additional description of the service and/or any specific issues not covered by the other attributes, which can be displayed as further detail under the serviceName.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public MarkdownType getCommentElement() { 
      if (this.comment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create HealthcareService.comment");
        else if (Configuration.doAutoCreate())
          this.comment = new MarkdownType(); // bb
      return this.comment;
    }

    public boolean hasCommentElement() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    public boolean hasComment() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    /**
     * @param value {@link #comment} (Any additional description of the service and/or any specific issues not covered by the other attributes, which can be displayed as further detail under the serviceName.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public HealthcareService setCommentElement(MarkdownType value) { 
      this.comment = value;
      return this;
    }

    /**
     * @return Any additional description of the service and/or any specific issues not covered by the other attributes, which can be displayed as further detail under the serviceName.
     */
    public String getComment() { 
      return this.comment == null ? null : this.comment.getValue();
    }

    /**
     * @param value Any additional description of the service and/or any specific issues not covered by the other attributes, which can be displayed as further detail under the serviceName.
     */
    public HealthcareService setComment(String value) { 
      if (Utilities.noString(value))
        this.comment = null;
      else {
        if (this.comment == null)
          this.comment = new MarkdownType();
        this.comment.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #extraDetails} (Extra details about the service that can't be placed in the other fields.). This is the underlying object with id, value and extensions. The accessor "getExtraDetails" gives direct access to the value
     */
    public MarkdownType getExtraDetailsElement() { 
      if (this.extraDetails == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create HealthcareService.extraDetails");
        else if (Configuration.doAutoCreate())
          this.extraDetails = new MarkdownType(); // bb
      return this.extraDetails;
    }

    public boolean hasExtraDetailsElement() { 
      return this.extraDetails != null && !this.extraDetails.isEmpty();
    }

    public boolean hasExtraDetails() { 
      return this.extraDetails != null && !this.extraDetails.isEmpty();
    }

    /**
     * @param value {@link #extraDetails} (Extra details about the service that can't be placed in the other fields.). This is the underlying object with id, value and extensions. The accessor "getExtraDetails" gives direct access to the value
     */
    public HealthcareService setExtraDetailsElement(MarkdownType value) { 
      this.extraDetails = value;
      return this;
    }

    /**
     * @return Extra details about the service that can't be placed in the other fields.
     */
    public String getExtraDetails() { 
      return this.extraDetails == null ? null : this.extraDetails.getValue();
    }

    /**
     * @param value Extra details about the service that can't be placed in the other fields.
     */
    public HealthcareService setExtraDetails(String value) { 
      if (Utilities.noString(value))
        this.extraDetails = null;
      else {
        if (this.extraDetails == null)
          this.extraDetails = new MarkdownType();
        this.extraDetails.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #photo} (If there is a photo/symbol associated with this HealthcareService, it may be included here to facilitate quick identification of the service in a list.)
     */
    public Attachment getPhoto() { 
      if (this.photo == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create HealthcareService.photo");
        else if (Configuration.doAutoCreate())
          this.photo = new Attachment(); // cc
      return this.photo;
    }

    public boolean hasPhoto() { 
      return this.photo != null && !this.photo.isEmpty();
    }

    /**
     * @param value {@link #photo} (If there is a photo/symbol associated with this HealthcareService, it may be included here to facilitate quick identification of the service in a list.)
     */
    public HealthcareService setPhoto(Attachment value) { 
      this.photo = value;
      return this;
    }

    /**
     * @return {@link #contact} (The contact details of communication devices available relevant to the specific HealthcareService. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.)
     */
    public List<ExtendedContactDetail> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ExtendedContactDetail>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setContact(List<ExtendedContactDetail> theContact) { 
      this.contact = theContact;
      return this;
    }

    public boolean hasContact() { 
      if (this.contact == null)
        return false;
      for (ExtendedContactDetail item : this.contact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ExtendedContactDetail addContact() { //3
      ExtendedContactDetail t = new ExtendedContactDetail();
      if (this.contact == null)
        this.contact = new ArrayList<ExtendedContactDetail>();
      this.contact.add(t);
      return t;
    }

    public HealthcareService addContact(ExtendedContactDetail t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ExtendedContactDetail>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ExtendedContactDetail getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #coverageArea} (The location(s) that this service is available to (not where the service is provided).)
     */
    public List<Reference> getCoverageArea() { 
      if (this.coverageArea == null)
        this.coverageArea = new ArrayList<Reference>();
      return this.coverageArea;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setCoverageArea(List<Reference> theCoverageArea) { 
      this.coverageArea = theCoverageArea;
      return this;
    }

    public boolean hasCoverageArea() { 
      if (this.coverageArea == null)
        return false;
      for (Reference item : this.coverageArea)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addCoverageArea() { //3
      Reference t = new Reference();
      if (this.coverageArea == null)
        this.coverageArea = new ArrayList<Reference>();
      this.coverageArea.add(t);
      return t;
    }

    public HealthcareService addCoverageArea(Reference t) { //3
      if (t == null)
        return this;
      if (this.coverageArea == null)
        this.coverageArea = new ArrayList<Reference>();
      this.coverageArea.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #coverageArea}, creating it if it does not already exist {3}
     */
    public Reference getCoverageAreaFirstRep() { 
      if (getCoverageArea().isEmpty()) {
        addCoverageArea();
      }
      return getCoverageArea().get(0);
    }

    /**
     * @return {@link #serviceProvisionCode} (The code(s) that detail the conditions under which the healthcare service is available/offered.)
     */
    public List<CodeableConcept> getServiceProvisionCode() { 
      if (this.serviceProvisionCode == null)
        this.serviceProvisionCode = new ArrayList<CodeableConcept>();
      return this.serviceProvisionCode;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setServiceProvisionCode(List<CodeableConcept> theServiceProvisionCode) { 
      this.serviceProvisionCode = theServiceProvisionCode;
      return this;
    }

    public boolean hasServiceProvisionCode() { 
      if (this.serviceProvisionCode == null)
        return false;
      for (CodeableConcept item : this.serviceProvisionCode)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addServiceProvisionCode() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.serviceProvisionCode == null)
        this.serviceProvisionCode = new ArrayList<CodeableConcept>();
      this.serviceProvisionCode.add(t);
      return t;
    }

    public HealthcareService addServiceProvisionCode(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.serviceProvisionCode == null)
        this.serviceProvisionCode = new ArrayList<CodeableConcept>();
      this.serviceProvisionCode.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #serviceProvisionCode}, creating it if it does not already exist {3}
     */
    public CodeableConcept getServiceProvisionCodeFirstRep() { 
      if (getServiceProvisionCode().isEmpty()) {
        addServiceProvisionCode();
      }
      return getServiceProvisionCode().get(0);
    }

    /**
     * @return {@link #eligibility} (Does this service have specific eligibility requirements that need to be met in order to use the service?)
     */
    public List<HealthcareServiceEligibilityComponent> getEligibility() { 
      if (this.eligibility == null)
        this.eligibility = new ArrayList<HealthcareServiceEligibilityComponent>();
      return this.eligibility;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setEligibility(List<HealthcareServiceEligibilityComponent> theEligibility) { 
      this.eligibility = theEligibility;
      return this;
    }

    public boolean hasEligibility() { 
      if (this.eligibility == null)
        return false;
      for (HealthcareServiceEligibilityComponent item : this.eligibility)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public HealthcareServiceEligibilityComponent addEligibility() { //3
      HealthcareServiceEligibilityComponent t = new HealthcareServiceEligibilityComponent();
      if (this.eligibility == null)
        this.eligibility = new ArrayList<HealthcareServiceEligibilityComponent>();
      this.eligibility.add(t);
      return t;
    }

    public HealthcareService addEligibility(HealthcareServiceEligibilityComponent t) { //3
      if (t == null)
        return this;
      if (this.eligibility == null)
        this.eligibility = new ArrayList<HealthcareServiceEligibilityComponent>();
      this.eligibility.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #eligibility}, creating it if it does not already exist {3}
     */
    public HealthcareServiceEligibilityComponent getEligibilityFirstRep() { 
      if (getEligibility().isEmpty()) {
        addEligibility();
      }
      return getEligibility().get(0);
    }

    /**
     * @return {@link #program} (Programs that this service is applicable to.)
     */
    public List<CodeableConcept> getProgram() { 
      if (this.program == null)
        this.program = new ArrayList<CodeableConcept>();
      return this.program;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setProgram(List<CodeableConcept> theProgram) { 
      this.program = theProgram;
      return this;
    }

    public boolean hasProgram() { 
      if (this.program == null)
        return false;
      for (CodeableConcept item : this.program)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addProgram() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.program == null)
        this.program = new ArrayList<CodeableConcept>();
      this.program.add(t);
      return t;
    }

    public HealthcareService addProgram(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.program == null)
        this.program = new ArrayList<CodeableConcept>();
      this.program.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #program}, creating it if it does not already exist {3}
     */
    public CodeableConcept getProgramFirstRep() { 
      if (getProgram().isEmpty()) {
        addProgram();
      }
      return getProgram().get(0);
    }

    /**
     * @return {@link #characteristic} (Collection of characteristics (attributes).)
     */
    public List<CodeableConcept> getCharacteristic() { 
      if (this.characteristic == null)
        this.characteristic = new ArrayList<CodeableConcept>();
      return this.characteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setCharacteristic(List<CodeableConcept> theCharacteristic) { 
      this.characteristic = theCharacteristic;
      return this;
    }

    public boolean hasCharacteristic() { 
      if (this.characteristic == null)
        return false;
      for (CodeableConcept item : this.characteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCharacteristic() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.characteristic == null)
        this.characteristic = new ArrayList<CodeableConcept>();
      this.characteristic.add(t);
      return t;
    }

    public HealthcareService addCharacteristic(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.characteristic == null)
        this.characteristic = new ArrayList<CodeableConcept>();
      this.characteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCharacteristicFirstRep() { 
      if (getCharacteristic().isEmpty()) {
        addCharacteristic();
      }
      return getCharacteristic().get(0);
    }

    /**
     * @return {@link #communication} (Some services are specifically made available in multiple languages, this property permits a directory to declare the languages this is offered in. Typically this is only provided where a service operates in communities with mixed languages used.)
     */
    public List<CodeableConcept> getCommunication() { 
      if (this.communication == null)
        this.communication = new ArrayList<CodeableConcept>();
      return this.communication;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setCommunication(List<CodeableConcept> theCommunication) { 
      this.communication = theCommunication;
      return this;
    }

    public boolean hasCommunication() { 
      if (this.communication == null)
        return false;
      for (CodeableConcept item : this.communication)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCommunication() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.communication == null)
        this.communication = new ArrayList<CodeableConcept>();
      this.communication.add(t);
      return t;
    }

    public HealthcareService addCommunication(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.communication == null)
        this.communication = new ArrayList<CodeableConcept>();
      this.communication.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #communication}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCommunicationFirstRep() { 
      if (getCommunication().isEmpty()) {
        addCommunication();
      }
      return getCommunication().get(0);
    }

    /**
     * @return {@link #referralMethod} (Ways that the service accepts referrals, if this is not provided then it is implied that no referral is required.)
     */
    public List<CodeableConcept> getReferralMethod() { 
      if (this.referralMethod == null)
        this.referralMethod = new ArrayList<CodeableConcept>();
      return this.referralMethod;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setReferralMethod(List<CodeableConcept> theReferralMethod) { 
      this.referralMethod = theReferralMethod;
      return this;
    }

    public boolean hasReferralMethod() { 
      if (this.referralMethod == null)
        return false;
      for (CodeableConcept item : this.referralMethod)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addReferralMethod() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.referralMethod == null)
        this.referralMethod = new ArrayList<CodeableConcept>();
      this.referralMethod.add(t);
      return t;
    }

    public HealthcareService addReferralMethod(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.referralMethod == null)
        this.referralMethod = new ArrayList<CodeableConcept>();
      this.referralMethod.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #referralMethod}, creating it if it does not already exist {3}
     */
    public CodeableConcept getReferralMethodFirstRep() { 
      if (getReferralMethod().isEmpty()) {
        addReferralMethod();
      }
      return getReferralMethod().get(0);
    }

    /**
     * @return {@link #appointmentRequired} (Indicates whether or not a prospective consumer will require an appointment for a particular service at a site to be provided by the Organization. Indicates if an appointment is required for access to this service.). This is the underlying object with id, value and extensions. The accessor "getAppointmentRequired" gives direct access to the value
     */
    public BooleanType getAppointmentRequiredElement() { 
      if (this.appointmentRequired == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create HealthcareService.appointmentRequired");
        else if (Configuration.doAutoCreate())
          this.appointmentRequired = new BooleanType(); // bb
      return this.appointmentRequired;
    }

    public boolean hasAppointmentRequiredElement() { 
      return this.appointmentRequired != null && !this.appointmentRequired.isEmpty();
    }

    public boolean hasAppointmentRequired() { 
      return this.appointmentRequired != null && !this.appointmentRequired.isEmpty();
    }

    /**
     * @param value {@link #appointmentRequired} (Indicates whether or not a prospective consumer will require an appointment for a particular service at a site to be provided by the Organization. Indicates if an appointment is required for access to this service.). This is the underlying object with id, value and extensions. The accessor "getAppointmentRequired" gives direct access to the value
     */
    public HealthcareService setAppointmentRequiredElement(BooleanType value) { 
      this.appointmentRequired = value;
      return this;
    }

    /**
     * @return Indicates whether or not a prospective consumer will require an appointment for a particular service at a site to be provided by the Organization. Indicates if an appointment is required for access to this service.
     */
    public boolean getAppointmentRequired() { 
      return this.appointmentRequired == null || this.appointmentRequired.isEmpty() ? false : this.appointmentRequired.getValue();
    }

    /**
     * @param value Indicates whether or not a prospective consumer will require an appointment for a particular service at a site to be provided by the Organization. Indicates if an appointment is required for access to this service.
     */
    public HealthcareService setAppointmentRequired(boolean value) { 
        if (this.appointmentRequired == null)
          this.appointmentRequired = new BooleanType();
        this.appointmentRequired.setValue(value);
      return this;
    }

    /**
     * @return {@link #availability} (A collection of times that the healthcare service is available.)
     */
    public List<Availability> getAvailability() { 
      if (this.availability == null)
        this.availability = new ArrayList<Availability>();
      return this.availability;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setAvailability(List<Availability> theAvailability) { 
      this.availability = theAvailability;
      return this;
    }

    public boolean hasAvailability() { 
      if (this.availability == null)
        return false;
      for (Availability item : this.availability)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Availability addAvailability() { //3
      Availability t = new Availability();
      if (this.availability == null)
        this.availability = new ArrayList<Availability>();
      this.availability.add(t);
      return t;
    }

    public HealthcareService addAvailability(Availability t) { //3
      if (t == null)
        return this;
      if (this.availability == null)
        this.availability = new ArrayList<Availability>();
      this.availability.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #availability}, creating it if it does not already exist {3}
     */
    public Availability getAvailabilityFirstRep() { 
      if (getAvailability().isEmpty()) {
        addAvailability();
      }
      return getAvailability().get(0);
    }

    /**
     * @return {@link #endpoint} (Technical endpoints providing access to services operated for the specific healthcare services defined at this resource.)
     */
    public List<Reference> getEndpoint() { 
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      return this.endpoint;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public HealthcareService setEndpoint(List<Reference> theEndpoint) { 
      this.endpoint = theEndpoint;
      return this;
    }

    public boolean hasEndpoint() { 
      if (this.endpoint == null)
        return false;
      for (Reference item : this.endpoint)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addEndpoint() { //3
      Reference t = new Reference();
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      this.endpoint.add(t);
      return t;
    }

    public HealthcareService addEndpoint(Reference t) { //3
      if (t == null)
        return this;
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      this.endpoint.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #endpoint}, creating it if it does not already exist {3}
     */
    public Reference getEndpointFirstRep() { 
      if (getEndpoint().isEmpty()) {
        addEndpoint();
      }
      return getEndpoint().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "External identifiers for this item.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("active", "boolean", "This flag is used to mark the record to not be used. This is not used when a center is closed for maintenance, or for holidays, the notAvailable period is to be used for this.", 0, 1, active));
        children.add(new Property("providedBy", "Reference(Organization)", "The organization that provides this healthcare service.", 0, 1, providedBy));
        children.add(new Property("offeredIn", "Reference(HealthcareService)", "When the HealthcareService is representing a specific, schedulable service, the availableIn property can refer to a generic service.", 0, java.lang.Integer.MAX_VALUE, offeredIn));
        children.add(new Property("category", "CodeableConcept", "Identifies the broad category of service being performed or delivered.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("type", "CodeableConcept", "The specific type of service that may be delivered or performed.", 0, java.lang.Integer.MAX_VALUE, type));
        children.add(new Property("specialty", "CodeableConcept", "Collection of specialties handled by the Healthcare service. This is more of a medical term.", 0, java.lang.Integer.MAX_VALUE, specialty));
        children.add(new Property("location", "Reference(Location)", "The location(s) where this healthcare service may be provided.", 0, java.lang.Integer.MAX_VALUE, location));
        children.add(new Property("name", "string", "Further description of the service as it would be presented to a consumer while searching.", 0, 1, name));
        children.add(new Property("comment", "markdown", "Any additional description of the service and/or any specific issues not covered by the other attributes, which can be displayed as further detail under the serviceName.", 0, 1, comment));
        children.add(new Property("extraDetails", "markdown", "Extra details about the service that can't be placed in the other fields.", 0, 1, extraDetails));
        children.add(new Property("photo", "Attachment", "If there is a photo/symbol associated with this HealthcareService, it may be included here to facilitate quick identification of the service in a list.", 0, 1, photo));
        children.add(new Property("contact", "ExtendedContactDetail", "The contact details of communication devices available relevant to the specific HealthcareService. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("coverageArea", "Reference(Location)", "The location(s) that this service is available to (not where the service is provided).", 0, java.lang.Integer.MAX_VALUE, coverageArea));
        children.add(new Property("serviceProvisionCode", "CodeableConcept", "The code(s) that detail the conditions under which the healthcare service is available/offered.", 0, java.lang.Integer.MAX_VALUE, serviceProvisionCode));
        children.add(new Property("eligibility", "", "Does this service have specific eligibility requirements that need to be met in order to use the service?", 0, java.lang.Integer.MAX_VALUE, eligibility));
        children.add(new Property("program", "CodeableConcept", "Programs that this service is applicable to.", 0, java.lang.Integer.MAX_VALUE, program));
        children.add(new Property("characteristic", "CodeableConcept", "Collection of characteristics (attributes).", 0, java.lang.Integer.MAX_VALUE, characteristic));
        children.add(new Property("communication", "CodeableConcept", "Some services are specifically made available in multiple languages, this property permits a directory to declare the languages this is offered in. Typically this is only provided where a service operates in communities with mixed languages used.", 0, java.lang.Integer.MAX_VALUE, communication));
        children.add(new Property("referralMethod", "CodeableConcept", "Ways that the service accepts referrals, if this is not provided then it is implied that no referral is required.", 0, java.lang.Integer.MAX_VALUE, referralMethod));
        children.add(new Property("appointmentRequired", "boolean", "Indicates whether or not a prospective consumer will require an appointment for a particular service at a site to be provided by the Organization. Indicates if an appointment is required for access to this service.", 0, 1, appointmentRequired));
        children.add(new Property("availability", "Availability", "A collection of times that the healthcare service is available.", 0, java.lang.Integer.MAX_VALUE, availability));
        children.add(new Property("endpoint", "Reference(Endpoint)", "Technical endpoints providing access to services operated for the specific healthcare services defined at this resource.", 0, java.lang.Integer.MAX_VALUE, endpoint));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "External identifiers for this item.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1422950650: /*active*/  return new Property("active", "boolean", "This flag is used to mark the record to not be used. This is not used when a center is closed for maintenance, or for holidays, the notAvailable period is to be used for this.", 0, 1, active);
        case 205136282: /*providedBy*/  return new Property("providedBy", "Reference(Organization)", "The organization that provides this healthcare service.", 0, 1, providedBy);
        case 1945040512: /*offeredIn*/  return new Property("offeredIn", "Reference(HealthcareService)", "When the HealthcareService is representing a specific, schedulable service, the availableIn property can refer to a generic service.", 0, java.lang.Integer.MAX_VALUE, offeredIn);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Identifies the broad category of service being performed or delivered.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The specific type of service that may be delivered or performed.", 0, java.lang.Integer.MAX_VALUE, type);
        case -1694759682: /*specialty*/  return new Property("specialty", "CodeableConcept", "Collection of specialties handled by the Healthcare service. This is more of a medical term.", 0, java.lang.Integer.MAX_VALUE, specialty);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The location(s) where this healthcare service may be provided.", 0, java.lang.Integer.MAX_VALUE, location);
        case 3373707: /*name*/  return new Property("name", "string", "Further description of the service as it would be presented to a consumer while searching.", 0, 1, name);
        case 950398559: /*comment*/  return new Property("comment", "markdown", "Any additional description of the service and/or any specific issues not covered by the other attributes, which can be displayed as further detail under the serviceName.", 0, 1, comment);
        case -1469168622: /*extraDetails*/  return new Property("extraDetails", "markdown", "Extra details about the service that can't be placed in the other fields.", 0, 1, extraDetails);
        case 106642994: /*photo*/  return new Property("photo", "Attachment", "If there is a photo/symbol associated with this HealthcareService, it may be included here to facilitate quick identification of the service in a list.", 0, 1, photo);
        case 951526432: /*contact*/  return new Property("contact", "ExtendedContactDetail", "The contact details of communication devices available relevant to the specific HealthcareService. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1532328299: /*coverageArea*/  return new Property("coverageArea", "Reference(Location)", "The location(s) that this service is available to (not where the service is provided).", 0, java.lang.Integer.MAX_VALUE, coverageArea);
        case 1504575405: /*serviceProvisionCode*/  return new Property("serviceProvisionCode", "CodeableConcept", "The code(s) that detail the conditions under which the healthcare service is available/offered.", 0, java.lang.Integer.MAX_VALUE, serviceProvisionCode);
        case -930847859: /*eligibility*/  return new Property("eligibility", "", "Does this service have specific eligibility requirements that need to be met in order to use the service?", 0, java.lang.Integer.MAX_VALUE, eligibility);
        case -309387644: /*program*/  return new Property("program", "CodeableConcept", "Programs that this service is applicable to.", 0, java.lang.Integer.MAX_VALUE, program);
        case 366313883: /*characteristic*/  return new Property("characteristic", "CodeableConcept", "Collection of characteristics (attributes).", 0, java.lang.Integer.MAX_VALUE, characteristic);
        case -1035284522: /*communication*/  return new Property("communication", "CodeableConcept", "Some services are specifically made available in multiple languages, this property permits a directory to declare the languages this is offered in. Typically this is only provided where a service operates in communities with mixed languages used.", 0, java.lang.Integer.MAX_VALUE, communication);
        case -2092740898: /*referralMethod*/  return new Property("referralMethod", "CodeableConcept", "Ways that the service accepts referrals, if this is not provided then it is implied that no referral is required.", 0, java.lang.Integer.MAX_VALUE, referralMethod);
        case 427220062: /*appointmentRequired*/  return new Property("appointmentRequired", "boolean", "Indicates whether or not a prospective consumer will require an appointment for a particular service at a site to be provided by the Organization. Indicates if an appointment is required for access to this service.", 0, 1, appointmentRequired);
        case 1997542747: /*availability*/  return new Property("availability", "Availability", "A collection of times that the healthcare service is available.", 0, java.lang.Integer.MAX_VALUE, availability);
        case 1741102485: /*endpoint*/  return new Property("endpoint", "Reference(Endpoint)", "Technical endpoints providing access to services operated for the specific healthcare services defined at this resource.", 0, java.lang.Integer.MAX_VALUE, endpoint);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1422950650: /*active*/ return this.active == null ? new Base[0] : new Base[] {this.active}; // BooleanType
        case 205136282: /*providedBy*/ return this.providedBy == null ? new Base[0] : new Base[] {this.providedBy}; // Reference
        case 1945040512: /*offeredIn*/ return this.offeredIn == null ? new Base[0] : this.offeredIn.toArray(new Base[this.offeredIn.size()]); // Reference
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case -1694759682: /*specialty*/ return this.specialty == null ? new Base[0] : this.specialty.toArray(new Base[this.specialty.size()]); // CodeableConcept
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : this.location.toArray(new Base[this.location.size()]); // Reference
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // MarkdownType
        case -1469168622: /*extraDetails*/ return this.extraDetails == null ? new Base[0] : new Base[] {this.extraDetails}; // MarkdownType
        case 106642994: /*photo*/ return this.photo == null ? new Base[0] : new Base[] {this.photo}; // Attachment
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ExtendedContactDetail
        case -1532328299: /*coverageArea*/ return this.coverageArea == null ? new Base[0] : this.coverageArea.toArray(new Base[this.coverageArea.size()]); // Reference
        case 1504575405: /*serviceProvisionCode*/ return this.serviceProvisionCode == null ? new Base[0] : this.serviceProvisionCode.toArray(new Base[this.serviceProvisionCode.size()]); // CodeableConcept
        case -930847859: /*eligibility*/ return this.eligibility == null ? new Base[0] : this.eligibility.toArray(new Base[this.eligibility.size()]); // HealthcareServiceEligibilityComponent
        case -309387644: /*program*/ return this.program == null ? new Base[0] : this.program.toArray(new Base[this.program.size()]); // CodeableConcept
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // CodeableConcept
        case -1035284522: /*communication*/ return this.communication == null ? new Base[0] : this.communication.toArray(new Base[this.communication.size()]); // CodeableConcept
        case -2092740898: /*referralMethod*/ return this.referralMethod == null ? new Base[0] : this.referralMethod.toArray(new Base[this.referralMethod.size()]); // CodeableConcept
        case 427220062: /*appointmentRequired*/ return this.appointmentRequired == null ? new Base[0] : new Base[] {this.appointmentRequired}; // BooleanType
        case 1997542747: /*availability*/ return this.availability == null ? new Base[0] : this.availability.toArray(new Base[this.availability.size()]); // Availability
        case 1741102485: /*endpoint*/ return this.endpoint == null ? new Base[0] : this.endpoint.toArray(new Base[this.endpoint.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1422950650: // active
          this.active = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 205136282: // providedBy
          this.providedBy = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1945040512: // offeredIn
          this.getOfferedIn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1694759682: // specialty
          this.getSpecialty().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1901043637: // location
          this.getLocation().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 950398559: // comment
          this.comment = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1469168622: // extraDetails
          this.extraDetails = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 106642994: // photo
          this.photo = TypeConvertor.castToAttachment(value); // Attachment
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToExtendedContactDetail(value)); // ExtendedContactDetail
          return value;
        case -1532328299: // coverageArea
          this.getCoverageArea().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1504575405: // serviceProvisionCode
          this.getServiceProvisionCode().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -930847859: // eligibility
          this.getEligibility().add((HealthcareServiceEligibilityComponent) value); // HealthcareServiceEligibilityComponent
          return value;
        case -309387644: // program
          this.getProgram().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1035284522: // communication
          this.getCommunication().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -2092740898: // referralMethod
          this.getReferralMethod().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 427220062: // appointmentRequired
          this.appointmentRequired = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1997542747: // availability
          this.getAvailability().add(TypeConvertor.castToAvailability(value)); // Availability
          return value;
        case 1741102485: // endpoint
          this.getEndpoint().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("active")) {
          this.active = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("providedBy")) {
          this.providedBy = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("offeredIn")) {
          this.getOfferedIn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("specialty")) {
          this.getSpecialty().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("location")) {
          this.getLocation().add(TypeConvertor.castToReference(value));
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("comment")) {
          this.comment = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("extraDetails")) {
          this.extraDetails = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("photo")) {
          this.photo = TypeConvertor.castToAttachment(value); // Attachment
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToExtendedContactDetail(value));
        } else if (name.equals("coverageArea")) {
          this.getCoverageArea().add(TypeConvertor.castToReference(value));
        } else if (name.equals("serviceProvisionCode")) {
          this.getServiceProvisionCode().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("eligibility")) {
          this.getEligibility().add((HealthcareServiceEligibilityComponent) value);
        } else if (name.equals("program")) {
          this.getProgram().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("communication")) {
          this.getCommunication().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("referralMethod")) {
          this.getReferralMethod().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("appointmentRequired")) {
          this.appointmentRequired = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("availability")) {
          this.getAvailability().add(TypeConvertor.castToAvailability(value));
        } else if (name.equals("endpoint")) {
          this.getEndpoint().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1422950650:  return getActiveElement();
        case 205136282:  return getProvidedBy();
        case 1945040512:  return addOfferedIn(); 
        case 50511102:  return addCategory(); 
        case 3575610:  return addType(); 
        case -1694759682:  return addSpecialty(); 
        case 1901043637:  return addLocation(); 
        case 3373707:  return getNameElement();
        case 950398559:  return getCommentElement();
        case -1469168622:  return getExtraDetailsElement();
        case 106642994:  return getPhoto();
        case 951526432:  return addContact(); 
        case -1532328299:  return addCoverageArea(); 
        case 1504575405:  return addServiceProvisionCode(); 
        case -930847859:  return addEligibility(); 
        case -309387644:  return addProgram(); 
        case 366313883:  return addCharacteristic(); 
        case -1035284522:  return addCommunication(); 
        case -2092740898:  return addReferralMethod(); 
        case 427220062:  return getAppointmentRequiredElement();
        case 1997542747:  return addAvailability(); 
        case 1741102485:  return addEndpoint(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1422950650: /*active*/ return new String[] {"boolean"};
        case 205136282: /*providedBy*/ return new String[] {"Reference"};
        case 1945040512: /*offeredIn*/ return new String[] {"Reference"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1694759682: /*specialty*/ return new String[] {"CodeableConcept"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 950398559: /*comment*/ return new String[] {"markdown"};
        case -1469168622: /*extraDetails*/ return new String[] {"markdown"};
        case 106642994: /*photo*/ return new String[] {"Attachment"};
        case 951526432: /*contact*/ return new String[] {"ExtendedContactDetail"};
        case -1532328299: /*coverageArea*/ return new String[] {"Reference"};
        case 1504575405: /*serviceProvisionCode*/ return new String[] {"CodeableConcept"};
        case -930847859: /*eligibility*/ return new String[] {};
        case -309387644: /*program*/ return new String[] {"CodeableConcept"};
        case 366313883: /*characteristic*/ return new String[] {"CodeableConcept"};
        case -1035284522: /*communication*/ return new String[] {"CodeableConcept"};
        case -2092740898: /*referralMethod*/ return new String[] {"CodeableConcept"};
        case 427220062: /*appointmentRequired*/ return new String[] {"boolean"};
        case 1997542747: /*availability*/ return new String[] {"Availability"};
        case 1741102485: /*endpoint*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("active")) {
          throw new FHIRException("Cannot call addChild on a primitive type HealthcareService.active");
        }
        else if (name.equals("providedBy")) {
          this.providedBy = new Reference();
          return this.providedBy;
        }
        else if (name.equals("offeredIn")) {
          return addOfferedIn();
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("specialty")) {
          return addSpecialty();
        }
        else if (name.equals("location")) {
          return addLocation();
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type HealthcareService.name");
        }
        else if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a primitive type HealthcareService.comment");
        }
        else if (name.equals("extraDetails")) {
          throw new FHIRException("Cannot call addChild on a primitive type HealthcareService.extraDetails");
        }
        else if (name.equals("photo")) {
          this.photo = new Attachment();
          return this.photo;
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("coverageArea")) {
          return addCoverageArea();
        }
        else if (name.equals("serviceProvisionCode")) {
          return addServiceProvisionCode();
        }
        else if (name.equals("eligibility")) {
          return addEligibility();
        }
        else if (name.equals("program")) {
          return addProgram();
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
        }
        else if (name.equals("communication")) {
          return addCommunication();
        }
        else if (name.equals("referralMethod")) {
          return addReferralMethod();
        }
        else if (name.equals("appointmentRequired")) {
          throw new FHIRException("Cannot call addChild on a primitive type HealthcareService.appointmentRequired");
        }
        else if (name.equals("availability")) {
          return addAvailability();
        }
        else if (name.equals("endpoint")) {
          return addEndpoint();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "HealthcareService";

  }

      public HealthcareService copy() {
        HealthcareService dst = new HealthcareService();
        copyValues(dst);
        return dst;
      }

      public void copyValues(HealthcareService dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.active = active == null ? null : active.copy();
        dst.providedBy = providedBy == null ? null : providedBy.copy();
        if (offeredIn != null) {
          dst.offeredIn = new ArrayList<Reference>();
          for (Reference i : offeredIn)
            dst.offeredIn.add(i.copy());
        };
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        if (specialty != null) {
          dst.specialty = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : specialty)
            dst.specialty.add(i.copy());
        };
        if (location != null) {
          dst.location = new ArrayList<Reference>();
          for (Reference i : location)
            dst.location.add(i.copy());
        };
        dst.name = name == null ? null : name.copy();
        dst.comment = comment == null ? null : comment.copy();
        dst.extraDetails = extraDetails == null ? null : extraDetails.copy();
        dst.photo = photo == null ? null : photo.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ExtendedContactDetail>();
          for (ExtendedContactDetail i : contact)
            dst.contact.add(i.copy());
        };
        if (coverageArea != null) {
          dst.coverageArea = new ArrayList<Reference>();
          for (Reference i : coverageArea)
            dst.coverageArea.add(i.copy());
        };
        if (serviceProvisionCode != null) {
          dst.serviceProvisionCode = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : serviceProvisionCode)
            dst.serviceProvisionCode.add(i.copy());
        };
        if (eligibility != null) {
          dst.eligibility = new ArrayList<HealthcareServiceEligibilityComponent>();
          for (HealthcareServiceEligibilityComponent i : eligibility)
            dst.eligibility.add(i.copy());
        };
        if (program != null) {
          dst.program = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : program)
            dst.program.add(i.copy());
        };
        if (characteristic != null) {
          dst.characteristic = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : characteristic)
            dst.characteristic.add(i.copy());
        };
        if (communication != null) {
          dst.communication = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : communication)
            dst.communication.add(i.copy());
        };
        if (referralMethod != null) {
          dst.referralMethod = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : referralMethod)
            dst.referralMethod.add(i.copy());
        };
        dst.appointmentRequired = appointmentRequired == null ? null : appointmentRequired.copy();
        if (availability != null) {
          dst.availability = new ArrayList<Availability>();
          for (Availability i : availability)
            dst.availability.add(i.copy());
        };
        if (endpoint != null) {
          dst.endpoint = new ArrayList<Reference>();
          for (Reference i : endpoint)
            dst.endpoint.add(i.copy());
        };
      }

      protected HealthcareService typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof HealthcareService))
          return false;
        HealthcareService o = (HealthcareService) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(active, o.active, true) && compareDeep(providedBy, o.providedBy, true)
           && compareDeep(offeredIn, o.offeredIn, true) && compareDeep(category, o.category, true) && compareDeep(type, o.type, true)
           && compareDeep(specialty, o.specialty, true) && compareDeep(location, o.location, true) && compareDeep(name, o.name, true)
           && compareDeep(comment, o.comment, true) && compareDeep(extraDetails, o.extraDetails, true) && compareDeep(photo, o.photo, true)
           && compareDeep(contact, o.contact, true) && compareDeep(coverageArea, o.coverageArea, true) && compareDeep(serviceProvisionCode, o.serviceProvisionCode, true)
           && compareDeep(eligibility, o.eligibility, true) && compareDeep(program, o.program, true) && compareDeep(characteristic, o.characteristic, true)
           && compareDeep(communication, o.communication, true) && compareDeep(referralMethod, o.referralMethod, true)
           && compareDeep(appointmentRequired, o.appointmentRequired, true) && compareDeep(availability, o.availability, true)
           && compareDeep(endpoint, o.endpoint, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof HealthcareService))
          return false;
        HealthcareService o = (HealthcareService) other_;
        return compareValues(active, o.active, true) && compareValues(name, o.name, true) && compareValues(comment, o.comment, true)
           && compareValues(extraDetails, o.extraDetails, true) && compareValues(appointmentRequired, o.appointmentRequired, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, active, providedBy
          , offeredIn, category, type, specialty, location, name, comment, extraDetails
          , photo, contact, coverageArea, serviceProvisionCode, eligibility, program, characteristic
          , communication, referralMethod, appointmentRequired, availability, endpoint);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.HealthcareService;
   }

 /**
   * Search parameter: <b>active</b>
   * <p>
   * Description: <b>The Healthcare Service is currently marked as active</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.active</b><br>
   * </p>
   */
  @SearchParamDefinition(name="active", path="HealthcareService.active", description="The Healthcare Service is currently marked as active", type="token" )
  public static final String SP_ACTIVE = "active";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>active</b>
   * <p>
   * Description: <b>The Healthcare Service is currently marked as active</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.active</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ACTIVE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ACTIVE);

 /**
   * Search parameter: <b>characteristic</b>
   * <p>
   * Description: <b>One of the HealthcareService's characteristics</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.characteristic</b><br>
   * </p>
   */
  @SearchParamDefinition(name="characteristic", path="HealthcareService.characteristic", description="One of the HealthcareService's characteristics", type="token" )
  public static final String SP_CHARACTERISTIC = "characteristic";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>characteristic</b>
   * <p>
   * Description: <b>One of the HealthcareService's characteristics</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.characteristic</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CHARACTERISTIC = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CHARACTERISTIC);

 /**
   * Search parameter: <b>communication</b>
   * <p>
   * Description: <b>Languages that are available at this service</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.communication</b><br>
   * </p>
   */
  @SearchParamDefinition(name="communication", path="HealthcareService.communication", description="Languages that are available at this service", type="token" )
  public static final String SP_COMMUNICATION = "communication";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>communication</b>
   * <p>
   * Description: <b>Languages that are available at this service</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.communication</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam COMMUNICATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_COMMUNICATION);

 /**
   * Search parameter: <b>coverage-area</b>
   * <p>
   * Description: <b>Location(s) service is intended for/available to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>HealthcareService.coverageArea</b><br>
   * </p>
   */
  @SearchParamDefinition(name="coverage-area", path="HealthcareService.coverageArea", description="Location(s) service is intended for/available to", type="reference", target={Location.class } )
  public static final String SP_COVERAGE_AREA = "coverage-area";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>coverage-area</b>
   * <p>
   * Description: <b>Location(s) service is intended for/available to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>HealthcareService.coverageArea</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam COVERAGE_AREA = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_COVERAGE_AREA);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>HealthcareService:coverage-area</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_COVERAGE_AREA = new ca.uhn.fhir.model.api.Include("HealthcareService:coverage-area").toLocked();

 /**
   * Search parameter: <b>eligibility</b>
   * <p>
   * Description: <b>One of the HealthcareService's eligibility requirements</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.eligibility.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="eligibility", path="HealthcareService.eligibility.code", description="One of the HealthcareService's eligibility requirements", type="token" )
  public static final String SP_ELIGIBILITY = "eligibility";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>eligibility</b>
   * <p>
   * Description: <b>One of the HealthcareService's eligibility requirements</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.eligibility.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ELIGIBILITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ELIGIBILITY);

 /**
   * Search parameter: <b>endpoint</b>
   * <p>
   * Description: <b>Technical endpoints providing access to electronic services operated for the healthcare service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>HealthcareService.endpoint</b><br>
   * </p>
   */
  @SearchParamDefinition(name="endpoint", path="HealthcareService.endpoint", description="Technical endpoints providing access to electronic services operated for the healthcare service", type="reference", target={Endpoint.class } )
  public static final String SP_ENDPOINT = "endpoint";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>endpoint</b>
   * <p>
   * Description: <b>Technical endpoints providing access to electronic services operated for the healthcare service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>HealthcareService.endpoint</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENDPOINT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENDPOINT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>HealthcareService:endpoint</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENDPOINT = new ca.uhn.fhir.model.api.Include("HealthcareService:endpoint").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifiers for this item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="HealthcareService.identifier", description="External identifiers for this item", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifiers for this item</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>The location of the Healthcare Service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>HealthcareService.location</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="HealthcareService.location", description="The location of the Healthcare Service", type="reference", target={Location.class } )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>The location of the Healthcare Service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>HealthcareService.location</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam LOCATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_LOCATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>HealthcareService:location</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_LOCATION = new ca.uhn.fhir.model.api.Include("HealthcareService:location").toLocked();

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>A portion of the Healthcare service name</b><br>
   * Type: <b>string</b><br>
   * Path: <b>HealthcareService.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="HealthcareService.name", description="A portion of the Healthcare service name", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>A portion of the Healthcare service name</b><br>
   * Type: <b>string</b><br>
   * Path: <b>HealthcareService.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>offered-in</b>
   * <p>
   * Description: <b>The service within which this service is offered</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>HealthcareService.offeredIn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="offered-in", path="HealthcareService.offeredIn", description="The service within which this service is offered", type="reference", target={HealthcareService.class } )
  public static final String SP_OFFERED_IN = "offered-in";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>offered-in</b>
   * <p>
   * Description: <b>The service within which this service is offered</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>HealthcareService.offeredIn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam OFFERED_IN = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_OFFERED_IN);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>HealthcareService:offered-in</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_OFFERED_IN = new ca.uhn.fhir.model.api.Include("HealthcareService:offered-in").toLocked();

 /**
   * Search parameter: <b>organization</b>
   * <p>
   * Description: <b>The organization that provides this Healthcare Service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>HealthcareService.providedBy</b><br>
   * </p>
   */
  @SearchParamDefinition(name="organization", path="HealthcareService.providedBy", description="The organization that provides this Healthcare Service", type="reference", target={Organization.class } )
  public static final String SP_ORGANIZATION = "organization";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>organization</b>
   * <p>
   * Description: <b>The organization that provides this Healthcare Service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>HealthcareService.providedBy</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ORGANIZATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ORGANIZATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>HealthcareService:organization</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ORGANIZATION = new ca.uhn.fhir.model.api.Include("HealthcareService:organization").toLocked();

 /**
   * Search parameter: <b>program</b>
   * <p>
   * Description: <b>One of the Programs supported by this HealthcareService</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.program</b><br>
   * </p>
   */
  @SearchParamDefinition(name="program", path="HealthcareService.program", description="One of the Programs supported by this HealthcareService", type="token" )
  public static final String SP_PROGRAM = "program";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>program</b>
   * <p>
   * Description: <b>One of the Programs supported by this HealthcareService</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.program</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PROGRAM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PROGRAM);

 /**
   * Search parameter: <b>service-category</b>
   * <p>
   * Description: <b>Service Category of the Healthcare Service</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="service-category", path="HealthcareService.category", description="Service Category of the Healthcare Service", type="token" )
  public static final String SP_SERVICE_CATEGORY = "service-category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>service-category</b>
   * <p>
   * Description: <b>Service Category of the Healthcare Service</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SERVICE_CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SERVICE_CATEGORY);

 /**
   * Search parameter: <b>service-type</b>
   * <p>
   * Description: <b>The type of service provided by this healthcare service</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="service-type", path="HealthcareService.type", description="The type of service provided by this healthcare service", type="token" )
  public static final String SP_SERVICE_TYPE = "service-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>service-type</b>
   * <p>
   * Description: <b>The type of service provided by this healthcare service</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SERVICE_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SERVICE_TYPE);

 /**
   * Search parameter: <b>specialty</b>
   * <p>
   * Description: <b>The specialty of the service provided by this healthcare service</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.specialty</b><br>
   * </p>
   */
  @SearchParamDefinition(name="specialty", path="HealthcareService.specialty", description="The specialty of the service provided by this healthcare service", type="token" )
  public static final String SP_SPECIALTY = "specialty";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>specialty</b>
   * <p>
   * Description: <b>The specialty of the service provided by this healthcare service</b><br>
   * Type: <b>token</b><br>
   * Path: <b>HealthcareService.specialty</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SPECIALTY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SPECIALTY);


}

