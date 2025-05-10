package org.hl7.fhir.r5.openehr;


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
import org.hl7.fhir.r5.openehr.Enumerations.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Description of a means of contact of a Party. Actual structure is archetyped.
 */
@DatatypeDef(name="CONTACT")
public class CONTACT extends LOCATABLE implements ICompositeType {

    /**
     * A set of address alternatives for this contact purpose and time validity combination.
     */
    @Child(name = "addresses", type = {ADDRESS.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A set of address alternatives for this contact purpose and time validity combination", formalDefinition="A set of address alternatives for this contact purpose and time validity combination." )
    protected List<ADDRESS> addressesList;

    /**
     * Valid time interval for this contact descriptor.
     */
    @Child(name = "time_validity", type = {DV_INTERVAL.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Valid time interval for this contact descriptor", formalDefinition="Valid time interval for this contact descriptor." )
    protected DV_INTERVAL time_validity;

    private static final long serialVersionUID = 1314053334L;

  /**
   * Constructor
   */
    public CONTACT() {
      super();
    }

    /**
     * @return {@link #addresses} (A set of address alternatives for this contact purpose and time validity combination.)
     */
    public List<ADDRESS> getAddressesList() { 
      if (this.addressesList == null)
        this.addressesList = new ArrayList<ADDRESS>();
      return this.addressesList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CONTACT setAddressesList(List<ADDRESS> theAddresses) { 
      this.addressesList = theAddresses;
      return this;
    }

    public boolean hasAddresses() { 
      if (this.addressesList == null)
        return false;
      for (ADDRESS item : this.addressesList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ADDRESS addAddresses() { //3a
      ADDRESS t = new ADDRESS();
      if (this.addressesList == null)
        this.addressesList = new ArrayList<ADDRESS>();
      this.addressesList.add(t);
      return t;
    }

    public CONTACT addAddresses(ADDRESS t) { //3b
      if (t == null)
        return this;
      if (this.addressesList == null)
        this.addressesList = new ArrayList<ADDRESS>();
      this.addressesList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #addresses}, creating it if it does not already exist {3}
     */
    public ADDRESS getAddressesFirstRep() { 
      if (getAddressesList().isEmpty()) {
        addAddresses();
      }
      return getAddressesList().get(0);
    }

    /**
     * @return {@link #time_validity} (Valid time interval for this contact descriptor.)
     */
    public DV_INTERVAL getTime_validity() { 
      if (this.time_validity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CONTACT.time_validity");
        else if (Configuration.doAutoCreate())
          this.time_validity = new DV_INTERVAL(); // cc
      return this.time_validity;
    }

    public boolean hasTime_validity() { 
      return this.time_validity != null && !this.time_validity.isEmpty();
    }

    /**
     * @param value {@link #time_validity} (Valid time interval for this contact descriptor.)
     */
    public CONTACT setTime_validity(DV_INTERVAL value) { 
      this.time_validity = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("addresses", "http://openehr.org/fhir/StructureDefinition/ADDRESS", "A set of address alternatives for this contact purpose and time validity combination.", 0, java.lang.Integer.MAX_VALUE, addressesList));
        children.add(new Property("time_validity", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Valid time interval for this contact descriptor.", 0, 1, time_validity));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 874544034: /*addresses*/  return new Property("addresses", "http://openehr.org/fhir/StructureDefinition/ADDRESS", "A set of address alternatives for this contact purpose and time validity combination.", 0, java.lang.Integer.MAX_VALUE, addressesList);
        case -1304171420: /*time_validity*/  return new Property("time_validity", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "Valid time interval for this contact descriptor.", 0, 1, time_validity);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 874544034: /*addresses*/ return this.addressesList == null ? new Base[0] : this.addressesList.toArray(new Base[this.addressesList.size()]); // ADDRESS
        case -1304171420: /*time_validity*/ return this.time_validity == null ? new Base[0] : new Base[] {this.time_validity}; // DV_INTERVAL
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 874544034: // addresses
          this.getAddressesList().add((ADDRESS) value); // ADDRESS
          return value;
        case -1304171420: // time_validity
          this.time_validity = (DV_INTERVAL) value; // DV_INTERVAL
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("addresses")) {
          this.getAddressesList().add((ADDRESS) value); // ADDRESS
        } else if (name.equals("time_validity")) {
          this.time_validity = (DV_INTERVAL) value; // DV_INTERVAL
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 874544034:  return addAddresses(); 
        case -1304171420:  return getTime_validity();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 874544034: /*addresses*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ADDRESS"};
        case -1304171420: /*time_validity*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-INTERVAL"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("addresses")) {
          return addAddresses();
        }
        else if (name.equals("time_validity")) {
          this.time_validity = new DV_INTERVAL();
          return this.time_validity;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CONTACT";

  }

      public CONTACT copy() {
        CONTACT dst = new CONTACT();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CONTACT dst) {
        super.copyValues(dst);
        if (addressesList != null) {
          dst.addressesList = new ArrayList<ADDRESS>();
          for (ADDRESS i : addressesList)
            dst.addressesList.add(i.copy());
        };
        dst.time_validity = time_validity == null ? null : time_validity.copy();
      }

      protected CONTACT typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CONTACT))
          return false;
        CONTACT o = (CONTACT) other_;
        return compareDeep(addressesList, o.addressesList, true) && compareDeep(time_validity, o.time_validity, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CONTACT))
          return false;
        CONTACT o = (CONTACT) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(addressesList, time_validity
          );
      }


}

