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

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 * A specific set of Roles/Locations/specialties/services that a practitioner may perform, or has performed at an organization during a period of time.
 */
@ResourceDef(name="PractitionerRole", profile="http://hl7.org/fhir/StructureDefinition/PractitionerRole")
public class PractitionerRole extends DomainResource {

    /**
     * Business Identifiers that are specific to a role/location.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Identifiers for a role/location", formalDefinition="Business Identifiers that are specific to a role/location." )
    protected List<Identifier> identifier;

    /**
     *  Whether this practitioner role record is in active use. Some systems may use this property to mark non-active practitioners, such as those that are not currently employed.
     */
    @Child(name = "active", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Whether this practitioner role record is in active use", formalDefinition=" Whether this practitioner role record is in active use. Some systems may use this property to mark non-active practitioners, such as those that are not currently employed." )
    protected BooleanType active;

    /**
     * The period during which the person is authorized to act as a practitioner in these role(s) for the organization.
     */
    @Child(name = "period", type = {Period.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The period during which the practitioner is authorized to perform in these role(s)", formalDefinition="The period during which the person is authorized to act as a practitioner in these role(s) for the organization." )
    protected Period period;

    /**
     * Practitioner that is able to provide the defined services for the organization.
     */
    @Child(name = "practitioner", type = {Practitioner.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Practitioner that provides services for the organization", formalDefinition="Practitioner that is able to provide the defined services for the organization." )
    protected Reference practitioner;

    /**
     * The organization where the Practitioner performs the roles associated.
     */
    @Child(name = "organization", type = {Organization.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Organization where the roles are available", formalDefinition="The organization where the Practitioner performs the roles associated." )
    protected Reference organization;

    /**
     * Roles which this practitioner is authorized to perform for the organization.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Roles which this practitioner may perform", formalDefinition="Roles which this practitioner is authorized to perform for the organization." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/practitioner-role")
    protected List<CodeableConcept> code;

    /**
     * The specialty of a practitioner that describes the functional role they are practicing at a given organization or location.
     */
    @Child(name = "specialty", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Specific specialty of the practitioner", formalDefinition="The specialty of a practitioner that describes the functional role they are practicing at a given organization or location." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/c80-practice-codes")
    protected List<CodeableConcept> specialty;

    /**
     * The location(s) at which this practitioner provides care.
     */
    @Child(name = "location", type = {Location.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Location(s) where the practitioner provides care", formalDefinition="The location(s) at which this practitioner provides care." )
    protected List<Reference> location;

    /**
     * The list of healthcare services that this worker provides for this role's Organization/Location(s).
     */
    @Child(name = "healthcareService", type = {HealthcareService.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Healthcare services provided for this role's Organization/Location(s)", formalDefinition="The list of healthcare services that this worker provides for this role's Organization/Location(s)." )
    protected List<Reference> healthcareService;

    /**
     * The contact details of communication devices available relevant to the specific PractitionerRole. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.
     */
    @Child(name = "contact", type = {ExtendedContactDetail.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Official contact details relating to this PractitionerRole", formalDefinition="The contact details of communication devices available relevant to the specific PractitionerRole. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites." )
    protected List<ExtendedContactDetail> contact;

    /**
     * Collection of characteristics (attributes).
     */
    @Child(name = "characteristic", type = {CodeableConcept.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Collection of characteristics (attributes)", formalDefinition="Collection of characteristics (attributes)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-mode")
    protected List<CodeableConcept> characteristic;

    /**
     * A language the practitioner can use in patient communication. The practitioner may know several languages (listed in practitioner.communication), however these are the languages that could be advertised in a directory for a patient to search.
     */
    @Child(name = "communication", type = {CodeableConcept.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A language the practitioner (in this role) can use in patient communication", formalDefinition="A language the practitioner can use in patient communication. The practitioner may know several languages (listed in practitioner.communication), however these are the languages that could be advertised in a directory for a patient to search." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/all-languages")
    protected List<CodeableConcept> communication;

    /**
     * A collection of times the practitioner is available or performing this role at the location and/or healthcareservice.
     */
    @Child(name = "availability", type = {Availability.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Times the Practitioner is available at this location and/or healthcare service (including exceptions)", formalDefinition="A collection of times the practitioner is available or performing this role at the location and/or healthcareservice." )
    protected List<Availability> availability;

    /**
     *  Technical endpoints providing access to services operated for the practitioner with this role. Commonly used for locating scheduling services, or identifying where to send referrals electronically.
     */
    @Child(name = "endpoint", type = {Endpoint.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Endpoints for interacting with the practitioner in this role", formalDefinition=" Technical endpoints providing access to services operated for the practitioner with this role. Commonly used for locating scheduling services, or identifying where to send referrals electronically." )
    protected List<Reference> endpoint;

    private static final long serialVersionUID = 1286634270L;

  /**
   * Constructor
   */
    public PractitionerRole() {
      super();
    }

    /**
     * @return {@link #identifier} (Business Identifiers that are specific to a role/location.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PractitionerRole setIdentifier(List<Identifier> theIdentifier) { 
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

    public PractitionerRole addIdentifier(Identifier t) { //3
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
     * @return {@link #active} ( Whether this practitioner role record is in active use. Some systems may use this property to mark non-active practitioners, such as those that are not currently employed.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public BooleanType getActiveElement() { 
      if (this.active == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PractitionerRole.active");
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
     * @param value {@link #active} ( Whether this practitioner role record is in active use. Some systems may use this property to mark non-active practitioners, such as those that are not currently employed.). This is the underlying object with id, value and extensions. The accessor "getActive" gives direct access to the value
     */
    public PractitionerRole setActiveElement(BooleanType value) { 
      this.active = value;
      return this;
    }

    /**
     * @return  Whether this practitioner role record is in active use. Some systems may use this property to mark non-active practitioners, such as those that are not currently employed.
     */
    public boolean getActive() { 
      return this.active == null || this.active.isEmpty() ? false : this.active.getValue();
    }

    /**
     * @param value  Whether this practitioner role record is in active use. Some systems may use this property to mark non-active practitioners, such as those that are not currently employed.
     */
    public PractitionerRole setActive(boolean value) { 
        if (this.active == null)
          this.active = new BooleanType();
        this.active.setValue(value);
      return this;
    }

    /**
     * @return {@link #period} (The period during which the person is authorized to act as a practitioner in these role(s) for the organization.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PractitionerRole.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (The period during which the person is authorized to act as a practitioner in these role(s) for the organization.)
     */
    public PractitionerRole setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #practitioner} (Practitioner that is able to provide the defined services for the organization.)
     */
    public Reference getPractitioner() { 
      if (this.practitioner == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PractitionerRole.practitioner");
        else if (Configuration.doAutoCreate())
          this.practitioner = new Reference(); // cc
      return this.practitioner;
    }

    public boolean hasPractitioner() { 
      return this.practitioner != null && !this.practitioner.isEmpty();
    }

    /**
     * @param value {@link #practitioner} (Practitioner that is able to provide the defined services for the organization.)
     */
    public PractitionerRole setPractitioner(Reference value) { 
      this.practitioner = value;
      return this;
    }

    /**
     * @return {@link #organization} (The organization where the Practitioner performs the roles associated.)
     */
    public Reference getOrganization() { 
      if (this.organization == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PractitionerRole.organization");
        else if (Configuration.doAutoCreate())
          this.organization = new Reference(); // cc
      return this.organization;
    }

    public boolean hasOrganization() { 
      return this.organization != null && !this.organization.isEmpty();
    }

    /**
     * @param value {@link #organization} (The organization where the Practitioner performs the roles associated.)
     */
    public PractitionerRole setOrganization(Reference value) { 
      this.organization = value;
      return this;
    }

    /**
     * @return {@link #code} (Roles which this practitioner is authorized to perform for the organization.)
     */
    public List<CodeableConcept> getCode() { 
      if (this.code == null)
        this.code = new ArrayList<CodeableConcept>();
      return this.code;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PractitionerRole setCode(List<CodeableConcept> theCode) { 
      this.code = theCode;
      return this;
    }

    public boolean hasCode() { 
      if (this.code == null)
        return false;
      for (CodeableConcept item : this.code)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCode() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.code == null)
        this.code = new ArrayList<CodeableConcept>();
      this.code.add(t);
      return t;
    }

    public PractitionerRole addCode(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.code == null)
        this.code = new ArrayList<CodeableConcept>();
      this.code.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #code}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCodeFirstRep() { 
      if (getCode().isEmpty()) {
        addCode();
      }
      return getCode().get(0);
    }

    /**
     * @return {@link #specialty} (The specialty of a practitioner that describes the functional role they are practicing at a given organization or location.)
     */
    public List<CodeableConcept> getSpecialty() { 
      if (this.specialty == null)
        this.specialty = new ArrayList<CodeableConcept>();
      return this.specialty;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PractitionerRole setSpecialty(List<CodeableConcept> theSpecialty) { 
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

    public PractitionerRole addSpecialty(CodeableConcept t) { //3
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
     * @return {@link #location} (The location(s) at which this practitioner provides care.)
     */
    public List<Reference> getLocation() { 
      if (this.location == null)
        this.location = new ArrayList<Reference>();
      return this.location;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PractitionerRole setLocation(List<Reference> theLocation) { 
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

    public PractitionerRole addLocation(Reference t) { //3
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
     * @return {@link #healthcareService} (The list of healthcare services that this worker provides for this role's Organization/Location(s).)
     */
    public List<Reference> getHealthcareService() { 
      if (this.healthcareService == null)
        this.healthcareService = new ArrayList<Reference>();
      return this.healthcareService;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PractitionerRole setHealthcareService(List<Reference> theHealthcareService) { 
      this.healthcareService = theHealthcareService;
      return this;
    }

    public boolean hasHealthcareService() { 
      if (this.healthcareService == null)
        return false;
      for (Reference item : this.healthcareService)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addHealthcareService() { //3
      Reference t = new Reference();
      if (this.healthcareService == null)
        this.healthcareService = new ArrayList<Reference>();
      this.healthcareService.add(t);
      return t;
    }

    public PractitionerRole addHealthcareService(Reference t) { //3
      if (t == null)
        return this;
      if (this.healthcareService == null)
        this.healthcareService = new ArrayList<Reference>();
      this.healthcareService.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #healthcareService}, creating it if it does not already exist {3}
     */
    public Reference getHealthcareServiceFirstRep() { 
      if (getHealthcareService().isEmpty()) {
        addHealthcareService();
      }
      return getHealthcareService().get(0);
    }

    /**
     * @return {@link #contact} (The contact details of communication devices available relevant to the specific PractitionerRole. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.)
     */
    public List<ExtendedContactDetail> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ExtendedContactDetail>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PractitionerRole setContact(List<ExtendedContactDetail> theContact) { 
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

    public PractitionerRole addContact(ExtendedContactDetail t) { //3
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
    public PractitionerRole setCharacteristic(List<CodeableConcept> theCharacteristic) { 
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

    public PractitionerRole addCharacteristic(CodeableConcept t) { //3
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
     * @return {@link #communication} (A language the practitioner can use in patient communication. The practitioner may know several languages (listed in practitioner.communication), however these are the languages that could be advertised in a directory for a patient to search.)
     */
    public List<CodeableConcept> getCommunication() { 
      if (this.communication == null)
        this.communication = new ArrayList<CodeableConcept>();
      return this.communication;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PractitionerRole setCommunication(List<CodeableConcept> theCommunication) { 
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

    public PractitionerRole addCommunication(CodeableConcept t) { //3
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
     * @return {@link #availability} (A collection of times the practitioner is available or performing this role at the location and/or healthcareservice.)
     */
    public List<Availability> getAvailability() { 
      if (this.availability == null)
        this.availability = new ArrayList<Availability>();
      return this.availability;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PractitionerRole setAvailability(List<Availability> theAvailability) { 
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

    public PractitionerRole addAvailability(Availability t) { //3
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
     * @return {@link #endpoint} ( Technical endpoints providing access to services operated for the practitioner with this role. Commonly used for locating scheduling services, or identifying where to send referrals electronically.)
     */
    public List<Reference> getEndpoint() { 
      if (this.endpoint == null)
        this.endpoint = new ArrayList<Reference>();
      return this.endpoint;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PractitionerRole setEndpoint(List<Reference> theEndpoint) { 
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

    public PractitionerRole addEndpoint(Reference t) { //3
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
        children.add(new Property("identifier", "Identifier", "Business Identifiers that are specific to a role/location.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("active", "boolean", " Whether this practitioner role record is in active use. Some systems may use this property to mark non-active practitioners, such as those that are not currently employed.", 0, 1, active));
        children.add(new Property("period", "Period", "The period during which the person is authorized to act as a practitioner in these role(s) for the organization.", 0, 1, period));
        children.add(new Property("practitioner", "Reference(Practitioner)", "Practitioner that is able to provide the defined services for the organization.", 0, 1, practitioner));
        children.add(new Property("organization", "Reference(Organization)", "The organization where the Practitioner performs the roles associated.", 0, 1, organization));
        children.add(new Property("code", "CodeableConcept", "Roles which this practitioner is authorized to perform for the organization.", 0, java.lang.Integer.MAX_VALUE, code));
        children.add(new Property("specialty", "CodeableConcept", "The specialty of a practitioner that describes the functional role they are practicing at a given organization or location.", 0, java.lang.Integer.MAX_VALUE, specialty));
        children.add(new Property("location", "Reference(Location)", "The location(s) at which this practitioner provides care.", 0, java.lang.Integer.MAX_VALUE, location));
        children.add(new Property("healthcareService", "Reference(HealthcareService)", "The list of healthcare services that this worker provides for this role's Organization/Location(s).", 0, java.lang.Integer.MAX_VALUE, healthcareService));
        children.add(new Property("contact", "ExtendedContactDetail", "The contact details of communication devices available relevant to the specific PractitionerRole. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("characteristic", "CodeableConcept", "Collection of characteristics (attributes).", 0, java.lang.Integer.MAX_VALUE, characteristic));
        children.add(new Property("communication", "CodeableConcept", "A language the practitioner can use in patient communication. The practitioner may know several languages (listed in practitioner.communication), however these are the languages that could be advertised in a directory for a patient to search.", 0, java.lang.Integer.MAX_VALUE, communication));
        children.add(new Property("availability", "Availability", "A collection of times the practitioner is available or performing this role at the location and/or healthcareservice.", 0, java.lang.Integer.MAX_VALUE, availability));
        children.add(new Property("endpoint", "Reference(Endpoint)", " Technical endpoints providing access to services operated for the practitioner with this role. Commonly used for locating scheduling services, or identifying where to send referrals electronically.", 0, java.lang.Integer.MAX_VALUE, endpoint));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business Identifiers that are specific to a role/location.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1422950650: /*active*/  return new Property("active", "boolean", " Whether this practitioner role record is in active use. Some systems may use this property to mark non-active practitioners, such as those that are not currently employed.", 0, 1, active);
        case -991726143: /*period*/  return new Property("period", "Period", "The period during which the person is authorized to act as a practitioner in these role(s) for the organization.", 0, 1, period);
        case 574573338: /*practitioner*/  return new Property("practitioner", "Reference(Practitioner)", "Practitioner that is able to provide the defined services for the organization.", 0, 1, practitioner);
        case 1178922291: /*organization*/  return new Property("organization", "Reference(Organization)", "The organization where the Practitioner performs the roles associated.", 0, 1, organization);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Roles which this practitioner is authorized to perform for the organization.", 0, java.lang.Integer.MAX_VALUE, code);
        case -1694759682: /*specialty*/  return new Property("specialty", "CodeableConcept", "The specialty of a practitioner that describes the functional role they are practicing at a given organization or location.", 0, java.lang.Integer.MAX_VALUE, specialty);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The location(s) at which this practitioner provides care.", 0, java.lang.Integer.MAX_VALUE, location);
        case 1289661064: /*healthcareService*/  return new Property("healthcareService", "Reference(HealthcareService)", "The list of healthcare services that this worker provides for this role's Organization/Location(s).", 0, java.lang.Integer.MAX_VALUE, healthcareService);
        case 951526432: /*contact*/  return new Property("contact", "ExtendedContactDetail", "The contact details of communication devices available relevant to the specific PractitionerRole. This can include addresses, phone numbers, fax numbers, mobile numbers, email addresses and web sites.", 0, java.lang.Integer.MAX_VALUE, contact);
        case 366313883: /*characteristic*/  return new Property("characteristic", "CodeableConcept", "Collection of characteristics (attributes).", 0, java.lang.Integer.MAX_VALUE, characteristic);
        case -1035284522: /*communication*/  return new Property("communication", "CodeableConcept", "A language the practitioner can use in patient communication. The practitioner may know several languages (listed in practitioner.communication), however these are the languages that could be advertised in a directory for a patient to search.", 0, java.lang.Integer.MAX_VALUE, communication);
        case 1997542747: /*availability*/  return new Property("availability", "Availability", "A collection of times the practitioner is available or performing this role at the location and/or healthcareservice.", 0, java.lang.Integer.MAX_VALUE, availability);
        case 1741102485: /*endpoint*/  return new Property("endpoint", "Reference(Endpoint)", " Technical endpoints providing access to services operated for the practitioner with this role. Commonly used for locating scheduling services, or identifying where to send referrals electronically.", 0, java.lang.Integer.MAX_VALUE, endpoint);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1422950650: /*active*/ return this.active == null ? new Base[0] : new Base[] {this.active}; // BooleanType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 574573338: /*practitioner*/ return this.practitioner == null ? new Base[0] : new Base[] {this.practitioner}; // Reference
        case 1178922291: /*organization*/ return this.organization == null ? new Base[0] : new Base[] {this.organization}; // Reference
        case 3059181: /*code*/ return this.code == null ? new Base[0] : this.code.toArray(new Base[this.code.size()]); // CodeableConcept
        case -1694759682: /*specialty*/ return this.specialty == null ? new Base[0] : this.specialty.toArray(new Base[this.specialty.size()]); // CodeableConcept
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : this.location.toArray(new Base[this.location.size()]); // Reference
        case 1289661064: /*healthcareService*/ return this.healthcareService == null ? new Base[0] : this.healthcareService.toArray(new Base[this.healthcareService.size()]); // Reference
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ExtendedContactDetail
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // CodeableConcept
        case -1035284522: /*communication*/ return this.communication == null ? new Base[0] : this.communication.toArray(new Base[this.communication.size()]); // CodeableConcept
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
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 574573338: // practitioner
          this.practitioner = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1178922291: // organization
          this.organization = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3059181: // code
          this.getCode().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1694759682: // specialty
          this.getSpecialty().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1901043637: // location
          this.getLocation().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1289661064: // healthcareService
          this.getHealthcareService().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToExtendedContactDetail(value)); // ExtendedContactDetail
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1035284522: // communication
          this.getCommunication().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
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
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("practitioner")) {
          this.practitioner = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("organization")) {
          this.organization = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("code")) {
          this.getCode().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("specialty")) {
          this.getSpecialty().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("location")) {
          this.getLocation().add(TypeConvertor.castToReference(value));
        } else if (name.equals("healthcareService")) {
          this.getHealthcareService().add(TypeConvertor.castToReference(value));
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToExtendedContactDetail(value));
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("communication")) {
          this.getCommunication().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("availability")) {
          this.getAvailability().add(TypeConvertor.castToAvailability(value));
        } else if (name.equals("endpoint")) {
          this.getEndpoint().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("active")) {
          this.active = null;
        } else if (name.equals("period")) {
          this.period = null;
        } else if (name.equals("practitioner")) {
          this.practitioner = null;
        } else if (name.equals("organization")) {
          this.organization = null;
        } else if (name.equals("code")) {
          this.getCode().remove(value);
        } else if (name.equals("specialty")) {
          this.getSpecialty().remove(value);
        } else if (name.equals("location")) {
          this.getLocation().remove(value);
        } else if (name.equals("healthcareService")) {
          this.getHealthcareService().remove(value);
        } else if (name.equals("contact")) {
          this.getContact().remove(value);
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().remove(value);
        } else if (name.equals("communication")) {
          this.getCommunication().remove(value);
        } else if (name.equals("availability")) {
          this.getAvailability().remove(value);
        } else if (name.equals("endpoint")) {
          this.getEndpoint().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1422950650:  return getActiveElement();
        case -991726143:  return getPeriod();
        case 574573338:  return getPractitioner();
        case 1178922291:  return getOrganization();
        case 3059181:  return addCode(); 
        case -1694759682:  return addSpecialty(); 
        case 1901043637:  return addLocation(); 
        case 1289661064:  return addHealthcareService(); 
        case 951526432:  return addContact(); 
        case 366313883:  return addCharacteristic(); 
        case -1035284522:  return addCommunication(); 
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
        case -991726143: /*period*/ return new String[] {"Period"};
        case 574573338: /*practitioner*/ return new String[] {"Reference"};
        case 1178922291: /*organization*/ return new String[] {"Reference"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1694759682: /*specialty*/ return new String[] {"CodeableConcept"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case 1289661064: /*healthcareService*/ return new String[] {"Reference"};
        case 951526432: /*contact*/ return new String[] {"ExtendedContactDetail"};
        case 366313883: /*characteristic*/ return new String[] {"CodeableConcept"};
        case -1035284522: /*communication*/ return new String[] {"CodeableConcept"};
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
          throw new FHIRException("Cannot call addChild on a singleton property PractitionerRole.active");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("practitioner")) {
          this.practitioner = new Reference();
          return this.practitioner;
        }
        else if (name.equals("organization")) {
          this.organization = new Reference();
          return this.organization;
        }
        else if (name.equals("code")) {
          return addCode();
        }
        else if (name.equals("specialty")) {
          return addSpecialty();
        }
        else if (name.equals("location")) {
          return addLocation();
        }
        else if (name.equals("healthcareService")) {
          return addHealthcareService();
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
        }
        else if (name.equals("communication")) {
          return addCommunication();
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
    return "PractitionerRole";

  }

      public PractitionerRole copy() {
        PractitionerRole dst = new PractitionerRole();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PractitionerRole dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.active = active == null ? null : active.copy();
        dst.period = period == null ? null : period.copy();
        dst.practitioner = practitioner == null ? null : practitioner.copy();
        dst.organization = organization == null ? null : organization.copy();
        if (code != null) {
          dst.code = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : code)
            dst.code.add(i.copy());
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
        if (healthcareService != null) {
          dst.healthcareService = new ArrayList<Reference>();
          for (Reference i : healthcareService)
            dst.healthcareService.add(i.copy());
        };
        if (contact != null) {
          dst.contact = new ArrayList<ExtendedContactDetail>();
          for (ExtendedContactDetail i : contact)
            dst.contact.add(i.copy());
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

      protected PractitionerRole typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PractitionerRole))
          return false;
        PractitionerRole o = (PractitionerRole) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(active, o.active, true) && compareDeep(period, o.period, true)
           && compareDeep(practitioner, o.practitioner, true) && compareDeep(organization, o.organization, true)
           && compareDeep(code, o.code, true) && compareDeep(specialty, o.specialty, true) && compareDeep(location, o.location, true)
           && compareDeep(healthcareService, o.healthcareService, true) && compareDeep(contact, o.contact, true)
           && compareDeep(characteristic, o.characteristic, true) && compareDeep(communication, o.communication, true)
           && compareDeep(availability, o.availability, true) && compareDeep(endpoint, o.endpoint, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PractitionerRole))
          return false;
        PractitionerRole o = (PractitionerRole) other_;
        return compareValues(active, o.active, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, active, period
          , practitioner, organization, code, specialty, location, healthcareService, contact
          , characteristic, communication, availability, endpoint);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.PractitionerRole;
   }

 /**
   * Search parameter: <b>active</b>
   * <p>
   * Description: <b>Whether this practitioner role record is in active use</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.active</b><br>
   * </p>
   */
  @SearchParamDefinition(name="active", path="PractitionerRole.active", description="Whether this practitioner role record is in active use", type="token" )
  public static final String SP_ACTIVE = "active";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>active</b>
   * <p>
   * Description: <b>Whether this practitioner role record is in active use</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.active</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ACTIVE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ACTIVE);

 /**
   * Search parameter: <b>characteristic</b>
   * <p>
   * Description: <b>One of the PractitionerRole's characteristics</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.characteristic</b><br>
   * </p>
   */
  @SearchParamDefinition(name="characteristic", path="PractitionerRole.characteristic", description="One of the PractitionerRole's characteristics", type="token" )
  public static final String SP_CHARACTERISTIC = "characteristic";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>characteristic</b>
   * <p>
   * Description: <b>One of the PractitionerRole's characteristics</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.characteristic</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CHARACTERISTIC = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CHARACTERISTIC);

 /**
   * Search parameter: <b>communication</b>
   * <p>
   * Description: <b>One of the languages that the practitioner can communicate with</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.communication</b><br>
   * </p>
   */
  @SearchParamDefinition(name="communication", path="PractitionerRole.communication", description="One of the languages that the practitioner can communicate with", type="token" )
  public static final String SP_COMMUNICATION = "communication";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>communication</b>
   * <p>
   * Description: <b>One of the languages that the practitioner can communicate with</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.communication</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam COMMUNICATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_COMMUNICATION);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The period during which the practitioner is authorized to perform in these role(s)</b><br>
   * Type: <b>date</b><br>
   * Path: <b>PractitionerRole.period</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="PractitionerRole.period", description="The period during which the practitioner is authorized to perform in these role(s)", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The period during which the practitioner is authorized to perform in these role(s)</b><br>
   * Type: <b>date</b><br>
   * Path: <b>PractitionerRole.period</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>endpoint</b>
   * <p>
   * Description: <b>Technical endpoints providing access to services operated for the practitioner with this role</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PractitionerRole.endpoint</b><br>
   * </p>
   */
  @SearchParamDefinition(name="endpoint", path="PractitionerRole.endpoint", description="Technical endpoints providing access to services operated for the practitioner with this role", type="reference", target={Endpoint.class } )
  public static final String SP_ENDPOINT = "endpoint";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>endpoint</b>
   * <p>
   * Description: <b>Technical endpoints providing access to services operated for the practitioner with this role</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PractitionerRole.endpoint</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENDPOINT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENDPOINT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PractitionerRole:endpoint</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENDPOINT = new ca.uhn.fhir.model.api.Include("PractitionerRole:endpoint").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>A practitioner's Identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="PractitionerRole.identifier", description="A practitioner's Identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>A practitioner's Identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>One of the locations at which this practitioner provides care</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PractitionerRole.location</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="PractitionerRole.location", description="One of the locations at which this practitioner provides care", type="reference", target={Location.class } )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>One of the locations at which this practitioner provides care</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PractitionerRole.location</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam LOCATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_LOCATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PractitionerRole:location</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_LOCATION = new ca.uhn.fhir.model.api.Include("PractitionerRole:location").toLocked();

 /**
   * Search parameter: <b>organization</b>
   * <p>
   * Description: <b>The identity of the organization the practitioner represents / acts on behalf of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PractitionerRole.organization</b><br>
   * </p>
   */
  @SearchParamDefinition(name="organization", path="PractitionerRole.organization", description="The identity of the organization the practitioner represents / acts on behalf of", type="reference", target={Organization.class } )
  public static final String SP_ORGANIZATION = "organization";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>organization</b>
   * <p>
   * Description: <b>The identity of the organization the practitioner represents / acts on behalf of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PractitionerRole.organization</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ORGANIZATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ORGANIZATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PractitionerRole:organization</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ORGANIZATION = new ca.uhn.fhir.model.api.Include("PractitionerRole:organization").toLocked();

 /**
   * Search parameter: <b>practitioner</b>
   * <p>
   * Description: <b>Practitioner that is able to provide the defined services for the organization</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PractitionerRole.practitioner</b><br>
   * </p>
   */
  @SearchParamDefinition(name="practitioner", path="PractitionerRole.practitioner", description="Practitioner that is able to provide the defined services for the organization", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Practitioner.class } )
  public static final String SP_PRACTITIONER = "practitioner";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>practitioner</b>
   * <p>
   * Description: <b>Practitioner that is able to provide the defined services for the organization</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PractitionerRole.practitioner</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRACTITIONER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PRACTITIONER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PractitionerRole:practitioner</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRACTITIONER = new ca.uhn.fhir.model.api.Include("PractitionerRole:practitioner").toLocked();

 /**
   * Search parameter: <b>role</b>
   * <p>
   * Description: <b>The practitioner can perform this role at for the organization</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="role", path="PractitionerRole.code", description="The practitioner can perform this role at for the organization", type="token" )
  public static final String SP_ROLE = "role";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>role</b>
   * <p>
   * Description: <b>The practitioner can perform this role at for the organization</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ROLE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ROLE);

 /**
   * Search parameter: <b>service</b>
   * <p>
   * Description: <b>The list of healthcare services that this worker provides for this role's Organization/Location(s)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PractitionerRole.healthcareService</b><br>
   * </p>
   */
  @SearchParamDefinition(name="service", path="PractitionerRole.healthcareService", description="The list of healthcare services that this worker provides for this role's Organization/Location(s)", type="reference", target={HealthcareService.class } )
  public static final String SP_SERVICE = "service";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>service</b>
   * <p>
   * Description: <b>The list of healthcare services that this worker provides for this role's Organization/Location(s)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PractitionerRole.healthcareService</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SERVICE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SERVICE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PractitionerRole:service</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SERVICE = new ca.uhn.fhir.model.api.Include("PractitionerRole:service").toLocked();

 /**
   * Search parameter: <b>specialty</b>
   * <p>
   * Description: <b>The practitioner has this specialty at an organization</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.specialty</b><br>
   * </p>
   */
  @SearchParamDefinition(name="specialty", path="PractitionerRole.specialty", description="The practitioner has this specialty at an organization", type="token" )
  public static final String SP_SPECIALTY = "specialty";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>specialty</b>
   * <p>
   * Description: <b>The practitioner has this specialty at an organization</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PractitionerRole.specialty</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SPECIALTY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SPECIALTY);

 /**
   * Search parameter: <b>email</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A value in an email contact
* [Person](person.html): A value in an email contact
* [Practitioner](practitioner.html): A value in an email contact
* [PractitionerRole](practitionerrole.html): A value in an email contact
* [RelatedPerson](relatedperson.html): A value in an email contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom.where(system='email') | Person.telecom.where(system='email') | Practitioner.telecom.where(system='email') | PractitionerRole.contact.telecom.where(system='email') | RelatedPerson.telecom.where(system='email')</b><br>
   * </p>
   */
  @SearchParamDefinition(name="email", path="Patient.telecom.where(system='email') | Person.telecom.where(system='email') | Practitioner.telecom.where(system='email') | PractitionerRole.contact.telecom.where(system='email') | RelatedPerson.telecom.where(system='email')", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A value in an email contact\r\n* [Person](person.html): A value in an email contact\r\n* [Practitioner](practitioner.html): A value in an email contact\r\n* [PractitionerRole](practitionerrole.html): A value in an email contact\r\n* [RelatedPerson](relatedperson.html): A value in an email contact\r\n", type="token" )
  public static final String SP_EMAIL = "email";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>email</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A value in an email contact
* [Person](person.html): A value in an email contact
* [Practitioner](practitioner.html): A value in an email contact
* [PractitionerRole](practitionerrole.html): A value in an email contact
* [RelatedPerson](relatedperson.html): A value in an email contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom.where(system='email') | Person.telecom.where(system='email') | Practitioner.telecom.where(system='email') | PractitionerRole.contact.telecom.where(system='email') | RelatedPerson.telecom.where(system='email')</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EMAIL = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_EMAIL);

 /**
   * Search parameter: <b>phone</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A value in a phone contact
* [Person](person.html): A value in a phone contact
* [Practitioner](practitioner.html): A value in a phone contact
* [PractitionerRole](practitionerrole.html): A value in a phone contact
* [RelatedPerson](relatedperson.html): A value in a phone contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom.where(system='phone') | Person.telecom.where(system='phone') | Practitioner.telecom.where(system='phone') | PractitionerRole.contact.telecom.where(system='phone') | RelatedPerson.telecom.where(system='phone')</b><br>
   * </p>
   */
  @SearchParamDefinition(name="phone", path="Patient.telecom.where(system='phone') | Person.telecom.where(system='phone') | Practitioner.telecom.where(system='phone') | PractitionerRole.contact.telecom.where(system='phone') | RelatedPerson.telecom.where(system='phone')", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): A value in a phone contact\r\n* [Person](person.html): A value in a phone contact\r\n* [Practitioner](practitioner.html): A value in a phone contact\r\n* [PractitionerRole](practitionerrole.html): A value in a phone contact\r\n* [RelatedPerson](relatedperson.html): A value in a phone contact\r\n", type="token" )
  public static final String SP_PHONE = "phone";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>phone</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): A value in a phone contact
* [Person](person.html): A value in a phone contact
* [Practitioner](practitioner.html): A value in a phone contact
* [PractitionerRole](practitionerrole.html): A value in a phone contact
* [RelatedPerson](relatedperson.html): A value in a phone contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom.where(system='phone') | Person.telecom.where(system='phone') | Practitioner.telecom.where(system='phone') | PractitionerRole.contact.telecom.where(system='phone') | RelatedPerson.telecom.where(system='phone')</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PHONE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PHONE);

 /**
   * Search parameter: <b>telecom</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): The value in any kind of telecom details of the patient
* [Person](person.html): The value in any kind of contact
* [Practitioner](practitioner.html): The value in any kind of contact
* [PractitionerRole](practitionerrole.html): The value in any kind of contact
* [RelatedPerson](relatedperson.html): The value in any kind of contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom | Person.telecom | Practitioner.telecom | PractitionerRole.contact.telecom | RelatedPerson.telecom</b><br>
   * </p>
   */
  @SearchParamDefinition(name="telecom", path="Patient.telecom | Person.telecom | Practitioner.telecom | PractitionerRole.contact.telecom | RelatedPerson.telecom", description="Multiple Resources: \r\n\r\n* [Patient](patient.html): The value in any kind of telecom details of the patient\r\n* [Person](person.html): The value in any kind of contact\r\n* [Practitioner](practitioner.html): The value in any kind of contact\r\n* [PractitionerRole](practitionerrole.html): The value in any kind of contact\r\n* [RelatedPerson](relatedperson.html): The value in any kind of contact\r\n", type="token" )
  public static final String SP_TELECOM = "telecom";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>telecom</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Patient](patient.html): The value in any kind of telecom details of the patient
* [Person](person.html): The value in any kind of contact
* [Practitioner](practitioner.html): The value in any kind of contact
* [PractitionerRole](practitionerrole.html): The value in any kind of contact
* [RelatedPerson](relatedperson.html): The value in any kind of contact
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Patient.telecom | Person.telecom | Practitioner.telecom | PractitionerRole.contact.telecom | RelatedPerson.telecom</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TELECOM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TELECOM);


}

