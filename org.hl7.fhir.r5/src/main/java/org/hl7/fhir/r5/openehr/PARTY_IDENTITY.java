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
 * An identity owned by a Party, such as a person name or company name, and which is used by the Party to identify itself. Actual structure is archetyped.
 */
@DatatypeDef(name="PARTY_IDENTITY")
public class PARTY_IDENTITY extends LOCATABLE implements ICompositeType {

    /**
     * The value of the identity. This will often taken the form of a parseable string or a small structure of strings.
     */
    @Child(name = "details", type = {ITEM_STRUCTURE.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The value of the identity. This will often taken the form of a parseable string or a small structure of strings", formalDefinition="The value of the identity. This will often taken the form of a parseable string or a small structure of strings." )
    protected ITEM_STRUCTURE details;

    private static final long serialVersionUID = -713027011L;

  /**
   * Constructor
   */
    public PARTY_IDENTITY() {
      super();
    }

    /**
     * @return {@link #details} (The value of the identity. This will often taken the form of a parseable string or a small structure of strings.)
     */
    public ITEM_STRUCTURE getDetails() { 
      return this.details;
    }

    public boolean hasDetails() { 
      return this.details != null && !this.details.isEmpty();
    }

    /**
     * @param value {@link #details} (The value of the identity. This will often taken the form of a parseable string or a small structure of strings.)
     */
    public PARTY_IDENTITY setDetails(ITEM_STRUCTURE value) { 
      this.details = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "The value of the identity. This will often taken the form of a parseable string or a small structure of strings.", 0, 1, details));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1557721666: /*details*/  return new Property("details", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "The value of the identity. This will often taken the form of a parseable string or a small structure of strings.", 0, 1, details);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1557721666: /*details*/ return this.details == null ? new Base[0] : new Base[] {this.details}; // ITEM_STRUCTURE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1557721666: // details
          this.details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("details")) {
          this.details = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1557721666: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'details'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1557721666: /*details*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("details")) {
          throw new FHIRException("Cannot call addChild on an abstract type PARTY_IDENTITY.details");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PARTY_IDENTITY";

  }

      public PARTY_IDENTITY copy() {
        PARTY_IDENTITY dst = new PARTY_IDENTITY();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PARTY_IDENTITY dst) {
        super.copyValues(dst);
        dst.details = details == null ? null : details.copy();
      }

      protected PARTY_IDENTITY typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PARTY_IDENTITY))
          return false;
        PARTY_IDENTITY o = (PARTY_IDENTITY) other_;
        return compareDeep(details, o.details, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PARTY_IDENTITY))
          return false;
        PARTY_IDENTITY o = (PARTY_IDENTITY) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(details);
      }


}

