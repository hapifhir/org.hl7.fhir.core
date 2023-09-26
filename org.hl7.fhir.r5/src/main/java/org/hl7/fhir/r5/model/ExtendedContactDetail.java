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
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * ExtendedContactDetail Type: Specifies contact information for a specific purpose over a period of time, might be handled/monitored by a specific named person or organization.
 */
@DatatypeDef(name="ExtendedContactDetail")
public class ExtendedContactDetail extends DataType implements ICompositeType {

    /**
     * The purpose/type of contact.
     */
    @Child(name = "purpose", type = {CodeableConcept.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The type of contact", formalDefinition="The purpose/type of contact." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/contactentity-type")
    protected CodeableConcept purpose;

    /**
     * The name of an individual to contact, some types of contact detail are usually blank.
     */
    @Child(name = "name", type = {HumanName.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Name of an individual to contact", formalDefinition="The name of an individual to contact, some types of contact detail are usually blank." )
    protected List<HumanName> name;

    /**
     * The contact details application for the purpose defined.
     */
    @Child(name = "telecom", type = {ContactPoint.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details (e.g.phone/fax/url)", formalDefinition="The contact details application for the purpose defined." )
    protected List<ContactPoint> telecom;

    /**
     * Address for the contact.
     */
    @Child(name = "address", type = {Address.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Address for the contact", formalDefinition="Address for the contact." )
    protected Address address;

    /**
     * This contact detail is handled/monitored by a specific organization. If the name is provided in the contact, then it is referring to the named individual within this organization.
     */
    @Child(name = "organization", type = {Organization.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="This contact detail is handled/monitored by a specific organization", formalDefinition="This contact detail is handled/monitored by a specific organization. If the name is provided in the contact, then it is referring to the named individual within this organization." )
    protected Reference organization;

    /**
     * Period that this contact was valid for usage.
     */
    @Child(name = "period", type = {Period.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Period that this contact was valid for usage", formalDefinition="Period that this contact was valid for usage." )
    protected Period period;

    private static final long serialVersionUID = 154672475L;

  /**
   * Constructor
   */
    public ExtendedContactDetail() {
      super();
    }

    /**
     * @return {@link #purpose} (The purpose/type of contact.)
     */
    public CodeableConcept getPurpose() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExtendedContactDetail.purpose");
        else if (Configuration.doAutoCreate())
          this.purpose = new CodeableConcept(); // cc
      return this.purpose;
    }

    public boolean hasPurpose() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    /**
     * @param value {@link #purpose} (The purpose/type of contact.)
     */
    public ExtendedContactDetail setPurpose(CodeableConcept value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return {@link #name} (The name of an individual to contact, some types of contact detail are usually blank.)
     */
    public List<HumanName> getName() { 
      if (this.name == null)
        this.name = new ArrayList<HumanName>();
      return this.name;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ExtendedContactDetail setName(List<HumanName> theName) { 
      this.name = theName;
      return this;
    }

    public boolean hasName() { 
      if (this.name == null)
        return false;
      for (HumanName item : this.name)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public HumanName addName() { //3
      HumanName t = new HumanName();
      if (this.name == null)
        this.name = new ArrayList<HumanName>();
      this.name.add(t);
      return t;
    }

    public ExtendedContactDetail addName(HumanName t) { //3
      if (t == null)
        return this;
      if (this.name == null)
        this.name = new ArrayList<HumanName>();
      this.name.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #name}, creating it if it does not already exist {3}
     */
    public HumanName getNameFirstRep() { 
      if (getName().isEmpty()) {
        addName();
      }
      return getName().get(0);
    }

    /**
     * @return {@link #telecom} (The contact details application for the purpose defined.)
     */
    public List<ContactPoint> getTelecom() { 
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      return this.telecom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ExtendedContactDetail setTelecom(List<ContactPoint> theTelecom) { 
      this.telecom = theTelecom;
      return this;
    }

    public boolean hasTelecom() { 
      if (this.telecom == null)
        return false;
      for (ContactPoint item : this.telecom)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactPoint addTelecom() { //3
      ContactPoint t = new ContactPoint();
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      this.telecom.add(t);
      return t;
    }

    public ExtendedContactDetail addTelecom(ContactPoint t) { //3
      if (t == null)
        return this;
      if (this.telecom == null)
        this.telecom = new ArrayList<ContactPoint>();
      this.telecom.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #telecom}, creating it if it does not already exist {3}
     */
    public ContactPoint getTelecomFirstRep() { 
      if (getTelecom().isEmpty()) {
        addTelecom();
      }
      return getTelecom().get(0);
    }

    /**
     * @return {@link #address} (Address for the contact.)
     */
    public Address getAddress() { 
      if (this.address == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExtendedContactDetail.address");
        else if (Configuration.doAutoCreate())
          this.address = new Address(); // cc
      return this.address;
    }

    public boolean hasAddress() { 
      return this.address != null && !this.address.isEmpty();
    }

    /**
     * @param value {@link #address} (Address for the contact.)
     */
    public ExtendedContactDetail setAddress(Address value) { 
      this.address = value;
      return this;
    }

    /**
     * @return {@link #organization} (This contact detail is handled/monitored by a specific organization. If the name is provided in the contact, then it is referring to the named individual within this organization.)
     */
    public Reference getOrganization() { 
      if (this.organization == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExtendedContactDetail.organization");
        else if (Configuration.doAutoCreate())
          this.organization = new Reference(); // cc
      return this.organization;
    }

    public boolean hasOrganization() { 
      return this.organization != null && !this.organization.isEmpty();
    }

    /**
     * @param value {@link #organization} (This contact detail is handled/monitored by a specific organization. If the name is provided in the contact, then it is referring to the named individual within this organization.)
     */
    public ExtendedContactDetail setOrganization(Reference value) { 
      this.organization = value;
      return this;
    }

    /**
     * @return {@link #period} (Period that this contact was valid for usage.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ExtendedContactDetail.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (Period that this contact was valid for usage.)
     */
    public ExtendedContactDetail setPeriod(Period value) { 
      this.period = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("purpose", "CodeableConcept", "The purpose/type of contact.", 0, 1, purpose));
        children.add(new Property("name", "HumanName", "The name of an individual to contact, some types of contact detail are usually blank.", 0, java.lang.Integer.MAX_VALUE, name));
        children.add(new Property("telecom", "ContactPoint", "The contact details application for the purpose defined.", 0, java.lang.Integer.MAX_VALUE, telecom));
        children.add(new Property("address", "Address", "Address for the contact.", 0, 1, address));
        children.add(new Property("organization", "Reference(Organization)", "This contact detail is handled/monitored by a specific organization. If the name is provided in the contact, then it is referring to the named individual within this organization.", 0, 1, organization));
        children.add(new Property("period", "Period", "Period that this contact was valid for usage.", 0, 1, period));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -220463842: /*purpose*/  return new Property("purpose", "CodeableConcept", "The purpose/type of contact.", 0, 1, purpose);
        case 3373707: /*name*/  return new Property("name", "HumanName", "The name of an individual to contact, some types of contact detail are usually blank.", 0, java.lang.Integer.MAX_VALUE, name);
        case -1429363305: /*telecom*/  return new Property("telecom", "ContactPoint", "The contact details application for the purpose defined.", 0, java.lang.Integer.MAX_VALUE, telecom);
        case -1147692044: /*address*/  return new Property("address", "Address", "Address for the contact.", 0, 1, address);
        case 1178922291: /*organization*/  return new Property("organization", "Reference(Organization)", "This contact detail is handled/monitored by a specific organization. If the name is provided in the contact, then it is referring to the named individual within this organization.", 0, 1, organization);
        case -991726143: /*period*/  return new Property("period", "Period", "Period that this contact was valid for usage.", 0, 1, period);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // CodeableConcept
        case 3373707: /*name*/ return this.name == null ? new Base[0] : this.name.toArray(new Base[this.name.size()]); // HumanName
        case -1429363305: /*telecom*/ return this.telecom == null ? new Base[0] : this.telecom.toArray(new Base[this.telecom.size()]); // ContactPoint
        case -1147692044: /*address*/ return this.address == null ? new Base[0] : new Base[] {this.address}; // Address
        case 1178922291: /*organization*/ return this.organization == null ? new Base[0] : new Base[] {this.organization}; // Reference
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -220463842: // purpose
          this.purpose = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3373707: // name
          this.getName().add(TypeConvertor.castToHumanName(value)); // HumanName
          return value;
        case -1429363305: // telecom
          this.getTelecom().add(TypeConvertor.castToContactPoint(value)); // ContactPoint
          return value;
        case -1147692044: // address
          this.address = TypeConvertor.castToAddress(value); // Address
          return value;
        case 1178922291: // organization
          this.organization = TypeConvertor.castToReference(value); // Reference
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("name")) {
          this.getName().add(TypeConvertor.castToHumanName(value));
        } else if (name.equals("telecom")) {
          this.getTelecom().add(TypeConvertor.castToContactPoint(value));
        } else if (name.equals("address")) {
          this.address = TypeConvertor.castToAddress(value); // Address
        } else if (name.equals("organization")) {
          this.organization = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("purpose")) {
          this.purpose = null;
        } else if (name.equals("name")) {
          this.getName().remove(value);
        } else if (name.equals("telecom")) {
          this.getTelecom().remove(value);
        } else if (name.equals("address")) {
          this.address = null;
        } else if (name.equals("organization")) {
          this.organization = null;
        } else if (name.equals("period")) {
          this.period = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -220463842:  return getPurpose();
        case 3373707:  return addName(); 
        case -1429363305:  return addTelecom(); 
        case -1147692044:  return getAddress();
        case 1178922291:  return getOrganization();
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -220463842: /*purpose*/ return new String[] {"CodeableConcept"};
        case 3373707: /*name*/ return new String[] {"HumanName"};
        case -1429363305: /*telecom*/ return new String[] {"ContactPoint"};
        case -1147692044: /*address*/ return new String[] {"Address"};
        case 1178922291: /*organization*/ return new String[] {"Reference"};
        case -991726143: /*period*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("purpose")) {
          this.purpose = new CodeableConcept();
          return this.purpose;
        }
        else if (name.equals("name")) {
          return addName();
        }
        else if (name.equals("telecom")) {
          return addTelecom();
        }
        else if (name.equals("address")) {
          this.address = new Address();
          return this.address;
        }
        else if (name.equals("organization")) {
          this.organization = new Reference();
          return this.organization;
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ExtendedContactDetail";

  }

      public ExtendedContactDetail copy() {
        ExtendedContactDetail dst = new ExtendedContactDetail();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ExtendedContactDetail dst) {
        super.copyValues(dst);
        dst.purpose = purpose == null ? null : purpose.copy();
        if (name != null) {
          dst.name = new ArrayList<HumanName>();
          for (HumanName i : name)
            dst.name.add(i.copy());
        };
        if (telecom != null) {
          dst.telecom = new ArrayList<ContactPoint>();
          for (ContactPoint i : telecom)
            dst.telecom.add(i.copy());
        };
        dst.address = address == null ? null : address.copy();
        dst.organization = organization == null ? null : organization.copy();
        dst.period = period == null ? null : period.copy();
      }

      protected ExtendedContactDetail typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ExtendedContactDetail))
          return false;
        ExtendedContactDetail o = (ExtendedContactDetail) other_;
        return compareDeep(purpose, o.purpose, true) && compareDeep(name, o.name, true) && compareDeep(telecom, o.telecom, true)
           && compareDeep(address, o.address, true) && compareDeep(organization, o.organization, true) && compareDeep(period, o.period, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ExtendedContactDetail))
          return false;
        ExtendedContactDetail o = (ExtendedContactDetail) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(purpose, name, telecom, address
          , organization, period);
      }


}

