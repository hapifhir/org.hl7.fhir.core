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
import org.hl7.fhir.utilities.Utilities;
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
 * Proxy data for an identified party other than the subject of the record, minimally consisting of human-readable identifier(s), such as name, formal (and possibly computable) identifiers such as NHS number, and an optional link to external data. There must be at least one of name, identifier or external_ref present. Used to describe parties where only identifiers may be known, and there is no entry at all in the demographic system (or even no demographic system). Typically for health care providers, e.g. name and provider number of an institution. Should not be used to include patient identifying information.
 */
@DatatypeDef(name="PARTY_IDENTIFIED")
public class PARTY_IDENTIFIED extends PARTY_PROXY implements ICompositeType {

    /**
     * Optional human-readable name (in String form).
     */
    @Child(name = "name", type = {StringType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional human-readable name", formalDefinition="Optional human-readable name (in String form)." )
    protected StringType name;

    /**
     * One or more formal identifiers (possibly computable).
     */
    @Child(name = "identifiers", type = {DV_IDENTIFIER.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="One or more formal identifiers (possibly computable)", formalDefinition="One or more formal identifiers (possibly computable)." )
    protected List<DV_IDENTIFIER> identifiersList;

    private static final long serialVersionUID = 1762655878L;

  /**
   * Constructor
   */
    public PARTY_IDENTIFIED() {
      super();
    }

    /**
     * @return {@link #name} (Optional human-readable name (in String form).). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PARTY_IDENTIFIED.name");
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
     * @param value {@link #name} (Optional human-readable name (in String form).). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public PARTY_IDENTIFIED setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return Optional human-readable name (in String form).
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value Optional human-readable name (in String form).
     */
    public PARTY_IDENTIFIED setName(String value) { 
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
     * @return {@link #identifiers} (One or more formal identifiers (possibly computable).)
     */
    public List<DV_IDENTIFIER> getIdentifiersList() { 
      if (this.identifiersList == null)
        this.identifiersList = new ArrayList<DV_IDENTIFIER>();
      return this.identifiersList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PARTY_IDENTIFIED setIdentifiersList(List<DV_IDENTIFIER> theIdentifiers) { 
      this.identifiersList = theIdentifiers;
      return this;
    }

    public boolean hasIdentifiers() { 
      if (this.identifiersList == null)
        return false;
      for (DV_IDENTIFIER item : this.identifiersList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DV_IDENTIFIER addIdentifiers() { //3a
      DV_IDENTIFIER t = new DV_IDENTIFIER();
      if (this.identifiersList == null)
        this.identifiersList = new ArrayList<DV_IDENTIFIER>();
      this.identifiersList.add(t);
      return t;
    }

    public PARTY_IDENTIFIED addIdentifiers(DV_IDENTIFIER t) { //3b
      if (t == null)
        return this;
      if (this.identifiersList == null)
        this.identifiersList = new ArrayList<DV_IDENTIFIER>();
      this.identifiersList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifiers}, creating it if it does not already exist {3}
     */
    public DV_IDENTIFIER getIdentifiersFirstRep() { 
      if (getIdentifiersList().isEmpty()) {
        addIdentifiers();
      }
      return getIdentifiersList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("name", "string", "Optional human-readable name (in String form).", 0, 1, name));
        children.add(new Property("identifiers", "http://openehr.org/fhir/StructureDefinition/DV-IDENTIFIER", "One or more formal identifiers (possibly computable).", 0, java.lang.Integer.MAX_VALUE, identifiersList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3373707: /*name*/  return new Property("name", "string", "Optional human-readable name (in String form).", 0, 1, name);
        case 1368189162: /*identifiers*/  return new Property("identifiers", "http://openehr.org/fhir/StructureDefinition/DV-IDENTIFIER", "One or more formal identifiers (possibly computable).", 0, java.lang.Integer.MAX_VALUE, identifiersList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 1368189162: /*identifiers*/ return this.identifiersList == null ? new Base[0] : this.identifiersList.toArray(new Base[this.identifiersList.size()]); // DV_IDENTIFIER
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 1368189162: // identifiers
          this.getIdentifiersList().add((DV_IDENTIFIER) value); // DV_IDENTIFIER
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("identifiers")) {
          this.getIdentifiersList().add((DV_IDENTIFIER) value); // DV_IDENTIFIER
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 1368189162:  return addIdentifiers(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 1368189162: /*identifiers*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-IDENTIFIER"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property PARTY_IDENTIFIED.name");
        }
        else if (name.equals("identifiers")) {
          return addIdentifiers();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PARTY_IDENTIFIED";

  }

      public PARTY_IDENTIFIED copy() {
        PARTY_IDENTIFIED dst = new PARTY_IDENTIFIED();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PARTY_IDENTIFIED dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        if (identifiersList != null) {
          dst.identifiersList = new ArrayList<DV_IDENTIFIER>();
          for (DV_IDENTIFIER i : identifiersList)
            dst.identifiersList.add(i.copy());
        };
      }

      protected PARTY_IDENTIFIED typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PARTY_IDENTIFIED))
          return false;
        PARTY_IDENTIFIED o = (PARTY_IDENTIFIED) other_;
        return compareDeep(name, o.name, true) && compareDeep(identifiersList, o.identifiersList, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PARTY_IDENTIFIED))
          return false;
        PARTY_IDENTIFIED o = (PARTY_IDENTIFIED) other_;
        return compareValues(name, o.name, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, identifiersList);
      }


}

