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
 * Defines a named range to be associated with any DV_ORDERED datum. Each such range is particular to the patient and context, e.g. sex, age, and any other factor which affects ranges. May be used to represent normal, therapeutic, dangerous, critical etc ranges.
 */
@DatatypeDef(name="REFERENCE_RANGE")
public class REFERENCE_RANGE extends LogicalBase implements ICompositeType {

    /**
     * Term whose value indicates the meaning of this range, e.g. normal, critical, therapeutic etc.
     */
    @Child(name = "meaning", type = {DV_TEXT.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Term whose value indicates the meaning of this range, e.g. normal, critical, therapeutic etc", formalDefinition="Term whose value indicates the meaning of this range, e.g. normal, critical, therapeutic etc." )
    protected DV_TEXT meaning;

    /**
     * The data range for this meaning, e.g. critical etc.
     */
    @Child(name = "range", type = {DV_INTERVAL.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The data range for this meaning, e.g. critical etc", formalDefinition="The data range for this meaning, e.g. critical etc." )
    protected DV_INTERVAL range;

    private static final long serialVersionUID = 610983054L;

  /**
   * Constructor
   */
    public REFERENCE_RANGE() {
      super();
    }

  /**
   * Constructor
   */
    public REFERENCE_RANGE(DV_TEXT meaning, DV_INTERVAL range) {
      super();
      this.setMeaning(meaning);
      this.setRange(range);
    }

    /**
     * @return {@link #meaning} (Term whose value indicates the meaning of this range, e.g. normal, critical, therapeutic etc.)
     */
    public DV_TEXT getMeaning() { 
      if (this.meaning == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create REFERENCE_RANGE.meaning");
        else if (Configuration.doAutoCreate())
          this.meaning = new DV_TEXT(); // cc
      return this.meaning;
    }

    public boolean hasMeaning() { 
      return this.meaning != null && !this.meaning.isEmpty();
    }

    /**
     * @param value {@link #meaning} (Term whose value indicates the meaning of this range, e.g. normal, critical, therapeutic etc.)
     */
    public REFERENCE_RANGE setMeaning(DV_TEXT value) { 
      this.meaning = value;
      return this;
    }

    /**
     * @return {@link #range} (The data range for this meaning, e.g. critical etc.)
     */
    public DV_INTERVAL getRange() { 
      if (this.range == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create REFERENCE_RANGE.range");
        else if (Configuration.doAutoCreate())
          this.range = new DV_INTERVAL(); // cc
      return this.range;
    }

    public boolean hasRange() { 
      return this.range != null && !this.range.isEmpty();
    }

    /**
     * @param value {@link #range} (The data range for this meaning, e.g. critical etc.)
     */
    public REFERENCE_RANGE setRange(DV_INTERVAL value) { 
      this.range = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("meaning", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Term whose value indicates the meaning of this range, e.g. normal, critical, therapeutic etc.", 0, 1, meaning));
        children.add(new Property("range", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "The data range for this meaning, e.g. critical etc.", 0, 1, range));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 938160637: /*meaning*/  return new Property("meaning", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Term whose value indicates the meaning of this range, e.g. normal, critical, therapeutic etc.", 0, 1, meaning);
        case 108280125: /*range*/  return new Property("range", "http://openehr.org/fhir/StructureDefinition/DV-INTERVAL", "The data range for this meaning, e.g. critical etc.", 0, 1, range);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 938160637: /*meaning*/ return this.meaning == null ? new Base[0] : new Base[] {this.meaning}; // DV_TEXT
        case 108280125: /*range*/ return this.range == null ? new Base[0] : new Base[] {this.range}; // DV_INTERVAL
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 938160637: // meaning
          this.meaning = (DV_TEXT) value; // DV_TEXT
          return value;
        case 108280125: // range
          this.range = (DV_INTERVAL) value; // DV_INTERVAL
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("meaning")) {
          this.meaning = (DV_TEXT) value; // DV_TEXT
        } else if (name.equals("range")) {
          this.range = (DV_INTERVAL) value; // DV_INTERVAL
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 938160637:  return getMeaning();
        case 108280125:  return getRange();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 938160637: /*meaning*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        case 108280125: /*range*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-INTERVAL"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("meaning")) {
          this.meaning = new DV_TEXT();
          return this.meaning;
        }
        else if (name.equals("range")) {
          this.range = new DV_INTERVAL();
          return this.range;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "REFERENCE_RANGE";

  }

      public REFERENCE_RANGE copy() {
        REFERENCE_RANGE dst = new REFERENCE_RANGE();
        copyValues(dst);
        return dst;
      }

      public void copyValues(REFERENCE_RANGE dst) {
        super.copyValues(dst);
        dst.meaning = meaning == null ? null : meaning.copy();
        dst.range = range == null ? null : range.copy();
      }

      protected REFERENCE_RANGE typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof REFERENCE_RANGE))
          return false;
        REFERENCE_RANGE o = (REFERENCE_RANGE) other_;
        return compareDeep(meaning, o.meaning, true) && compareDeep(range, o.range, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof REFERENCE_RANGE))
          return false;
        REFERENCE_RANGE o = (REFERENCE_RANGE) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(meaning, range);
      }


}

