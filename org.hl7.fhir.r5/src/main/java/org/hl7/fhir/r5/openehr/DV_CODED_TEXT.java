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
 * A text item whose value must be the rubric from a controlled terminology, the key (i.e. the 'code') of which is the defining_code attribute. In other words: a DV_CODED_TEXT is a combination of a CODE_PHRASE (effectively a code) and the rubric of that term, from a terminology service, in the language in which the data were authored.
 */
@DatatypeDef(name="DV_CODED_TEXT")
public class DV_CODED_TEXT extends DV_TEXT implements ICompositeType {

    /**
     * Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.
     */
    @Child(name = "defining_code", type = {CODE_PHRASE.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Displayable rendition of the item, regardless of its underlying structure", formalDefinition="Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service." )
    protected CODE_PHRASE defining_code;

    private static final long serialVersionUID = 599862763L;

  /**
   * Constructor
   */
    public DV_CODED_TEXT() {
      super();
    }

  /**
   * Constructor
   */
    public DV_CODED_TEXT(CODE_PHRASE defining_code) {
      super();
      this.setDefining_code(defining_code);
    }

    /**
     * @return {@link #defining_code} (Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.)
     */
    public CODE_PHRASE getDefining_code() { 
      if (this.defining_code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_CODED_TEXT.defining_code");
        else if (Configuration.doAutoCreate())
          this.defining_code = new CODE_PHRASE(); // cc
      return this.defining_code;
    }

    public boolean hasDefining_code() { 
      return this.defining_code != null && !this.defining_code.isEmpty();
    }

    /**
     * @param value {@link #defining_code} (Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.)
     */
    public DV_CODED_TEXT setDefining_code(CODE_PHRASE value) { 
      this.defining_code = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("defining_code", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.", 0, 1, defining_code));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 2053146132: /*defining_code*/  return new Property("defining_code", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.", 0, 1, defining_code);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 2053146132: /*defining_code*/ return this.defining_code == null ? new Base[0] : new Base[] {this.defining_code}; // CODE_PHRASE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 2053146132: // defining_code
          this.defining_code = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("defining_code")) {
          this.defining_code = (CODE_PHRASE) value; // CODE_PHRASE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 2053146132:  return getDefining_code();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 2053146132: /*defining_code*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("defining_code")) {
          this.defining_code = new CODE_PHRASE();
          return this.defining_code;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_CODED_TEXT";

  }

      public DV_CODED_TEXT copy() {
        DV_CODED_TEXT dst = new DV_CODED_TEXT();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_CODED_TEXT dst) {
        super.copyValues(dst);
        dst.defining_code = defining_code == null ? null : defining_code.copy();
      }

      protected DV_CODED_TEXT typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_CODED_TEXT))
          return false;
        DV_CODED_TEXT o = (DV_CODED_TEXT) other_;
        return compareDeep(defining_code, o.defining_code, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_CODED_TEXT))
          return false;
        DV_CODED_TEXT o = (DV_CODED_TEXT) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(defining_code);
      }


}

