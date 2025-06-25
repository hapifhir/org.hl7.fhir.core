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
 * The abstract parent of all clinical ENTRY subtypes. A CARE_ENTRY defines protocol and guideline attributes for all clinical Entry subtypes.
 */
@DatatypeDef(name="CARE_ENTRY")
public abstract class CARE_ENTRY extends ENTRY implements ICompositeType {

    /**
     * Description of the method (i.e. how) the information in this entry was arrived at. For OBSERVATIONs, this is a description of the method or instrument used. For EVALUATIONs, how the evaluation was arrived at. For INSTRUCTIONs, how to execute the Instruction. This may take the form of references to guidelines, including manually followed and executable; knowledge references such as a paper in Medline; clinical reasons within a larger care process.
     */
    @Child(name = "protocol", type = {ITEM_STRUCTURE.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Description of the method (i.e. how) the information in this entry was arrived at", formalDefinition="Description of the method (i.e. how) the information in this entry was arrived at. For OBSERVATIONs, this is a description of the method or instrument used. For EVALUATIONs, how the evaluation was arrived at. For INSTRUCTIONs, how to execute the Instruction. This may take the form of references to guidelines, including manually followed and executable; knowledge references such as a paper in Medline; clinical reasons within a larger care process." )
    protected ITEM_STRUCTURE protocol;

    /**
     * Optional external identifier of guideline creating this Entry if relevant.
     */
    @Child(name = "guideline_id", type = {OBJECT_REF.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional external identifier of guideline creating this Entry if relevant", formalDefinition="Optional external identifier of guideline creating this Entry if relevant." )
    protected OBJECT_REF guideline_id;

    private static final long serialVersionUID = 1019967948L;

  /**
   * Constructor
   */
    public CARE_ENTRY() {
      super();
    }

    /**
     * @return {@link #protocol} (Description of the method (i.e. how) the information in this entry was arrived at. For OBSERVATIONs, this is a description of the method or instrument used. For EVALUATIONs, how the evaluation was arrived at. For INSTRUCTIONs, how to execute the Instruction. This may take the form of references to guidelines, including manually followed and executable; knowledge references such as a paper in Medline; clinical reasons within a larger care process.)
     */
    public ITEM_STRUCTURE getProtocol() { 
      return this.protocol;
    }

    public boolean hasProtocol() { 
      return this.protocol != null && !this.protocol.isEmpty();
    }

    /**
     * @param value {@link #protocol} (Description of the method (i.e. how) the information in this entry was arrived at. For OBSERVATIONs, this is a description of the method or instrument used. For EVALUATIONs, how the evaluation was arrived at. For INSTRUCTIONs, how to execute the Instruction. This may take the form of references to guidelines, including manually followed and executable; knowledge references such as a paper in Medline; clinical reasons within a larger care process.)
     */
    public CARE_ENTRY setProtocol(ITEM_STRUCTURE value) { 
      this.protocol = value;
      return this;
    }

    /**
     * @return {@link #guideline_id} (Optional external identifier of guideline creating this Entry if relevant.)
     */
    public OBJECT_REF getGuideline_id() { 
      if (this.guideline_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CARE_ENTRY.guideline_id");
        else if (Configuration.doAutoCreate())
          this.guideline_id = new OBJECT_REF(); // cc
      return this.guideline_id;
    }

    public boolean hasGuideline_id() { 
      return this.guideline_id != null && !this.guideline_id.isEmpty();
    }

    /**
     * @param value {@link #guideline_id} (Optional external identifier of guideline creating this Entry if relevant.)
     */
    public CARE_ENTRY setGuideline_id(OBJECT_REF value) { 
      this.guideline_id = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("protocol", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Description of the method (i.e. how) the information in this entry was arrived at. For OBSERVATIONs, this is a description of the method or instrument used. For EVALUATIONs, how the evaluation was arrived at. For INSTRUCTIONs, how to execute the Instruction. This may take the form of references to guidelines, including manually followed and executable; knowledge references such as a paper in Medline; clinical reasons within a larger care process.", 0, 1, protocol));
        children.add(new Property("guideline_id", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Optional external identifier of guideline creating this Entry if relevant.", 0, 1, guideline_id));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -989163880: /*protocol*/  return new Property("protocol", "http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE", "Description of the method (i.e. how) the information in this entry was arrived at. For OBSERVATIONs, this is a description of the method or instrument used. For EVALUATIONs, how the evaluation was arrived at. For INSTRUCTIONs, how to execute the Instruction. This may take the form of references to guidelines, including manually followed and executable; knowledge references such as a paper in Medline; clinical reasons within a larger care process.", 0, 1, protocol);
        case 1211891402: /*guideline_id*/  return new Property("guideline_id", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Optional external identifier of guideline creating this Entry if relevant.", 0, 1, guideline_id);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -989163880: /*protocol*/ return this.protocol == null ? new Base[0] : new Base[] {this.protocol}; // ITEM_STRUCTURE
        case 1211891402: /*guideline_id*/ return this.guideline_id == null ? new Base[0] : new Base[] {this.guideline_id}; // OBJECT_REF
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -989163880: // protocol
          this.protocol = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
          return value;
        case 1211891402: // guideline_id
          this.guideline_id = (OBJECT_REF) value; // OBJECT_REF
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("protocol")) {
          this.protocol = (ITEM_STRUCTURE) value; // ITEM_STRUCTURE
        } else if (name.equals("guideline_id")) {
          this.guideline_id = (OBJECT_REF) value; // OBJECT_REF
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -989163880: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'protocol'");
        case 1211891402:  return getGuideline_id();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -989163880: /*protocol*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ITEM-STRUCTURE"};
        case 1211891402: /*guideline_id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("protocol")) {
          throw new FHIRException("Cannot call addChild on an abstract type CARE_ENTRY.protocol");
        }
        else if (name.equals("guideline_id")) {
          this.guideline_id = new OBJECT_REF();
          return this.guideline_id;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CARE_ENTRY";

  }

      public abstract CARE_ENTRY copy();

      public void copyValues(CARE_ENTRY dst) {
        super.copyValues(dst);
        dst.protocol = protocol == null ? null : protocol.copy();
        dst.guideline_id = guideline_id == null ? null : guideline_id.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CARE_ENTRY))
          return false;
        CARE_ENTRY o = (CARE_ENTRY) other_;
        return compareDeep(protocol, o.protocol, true) && compareDeep(guideline_id, o.guideline_id, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CARE_ENTRY))
          return false;
        CARE_ENTRY o = (CARE_ENTRY) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(protocol, guideline_id);
      }


}

