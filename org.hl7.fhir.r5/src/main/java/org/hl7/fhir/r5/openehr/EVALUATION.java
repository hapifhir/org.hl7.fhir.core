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
 * Entry type for evaluation statements. Used for all kinds of statements which evaluate other information, such as interpretations of observations, diagnoses, differential diagnoses, hypotheses, risk assessments, goals and plans. Should not be used for actionable statements such as medication orders - these are represented using the INSTRUCTION type.
 */
@DatatypeDef(name="EVALUATION")
public class EVALUATION extends CARE_ENTRY implements ICompositeType {

    /**
     * The data of this evaluation, in the form of a spatial data structure.
     */
    @Child(name = "data", type = {ITEM_STRUCTURE.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The data of this evaluation, in the form of a spatial data structure", formalDefinition="The data of this evaluation, in the form of a spatial data structure." )
    protected ITEM_STRUCTURE data;

    private static final long serialVersionUID = 583338983L;

  /**
   * Constructor
   */
    public EVALUATION() {
      super();
    }

  /**
   * Constructor
   */
    public EVALUATION(ITEM_STRUCTURE data) {
      super();
      this.setData(data);
    }

    /**
     * @return {@link #data} (The data of this evaluation, in the form of a spatial data structure.)
     */
    public ITEM_STRUCTURE getData() { 
      return this.data;
    }

    public boolean hasData() { 
      return this.data != null && !this.data.isEmpty();
    }

    /**
     * @param value {@link #data} (The data of this evaluation, in the form of a spatial data structure.)
     */
    public EVALUATION setData(ITEM_STRUCTURE value) { 
      this.data = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("data", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "The data of this evaluation, in the form of a spatial data structure.", 0, 1, data));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3076010: /*data*/  return new Property("data", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "The data of this evaluation, in the form of a spatial data structure.", 0, 1, data);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3076010: /*data*/ return this.data == null ? new Base[0] : new Base[] {this.data}; // ITEM_STRUCTURE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3076010: // data
          this.data = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("data")) {
          this.data = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3076010: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'data'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3076010: /*data*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("data")) {
          throw new FHIRException("Cannot call addChild on an abstract type EVALUATION.data");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "EVALUATION";

  }

      public EVALUATION copy() {
        EVALUATION dst = new EVALUATION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EVALUATION dst) {
        super.copyValues(dst);
        dst.data = data == null ? null : data.copy();
      }

      protected EVALUATION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EVALUATION))
          return false;
        EVALUATION o = (EVALUATION) other_;
        return compareDeep(data, o.data, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EVALUATION))
          return false;
        EVALUATION o = (EVALUATION) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(data);
      }


}

