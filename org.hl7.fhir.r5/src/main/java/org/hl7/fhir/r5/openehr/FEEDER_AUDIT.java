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
 * The FEEDER_AUDIT class defines the semantics of an audit trail which is constructed to describe the origin of data that have been transformed into openEHR form and committed to the system.
 */
@DatatypeDef(name="FEEDER_AUDIT")
public class FEEDER_AUDIT extends LogicalBase implements ICompositeType {

    /**
     * Identifiers used for the item in the originating system, e.g. filler and placer ids.
     */
    @Child(name = "originating_system_item_ids", type = {DV_IDENTIFIER.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Identifiers used for the item in the originating system", formalDefinition="Identifiers used for the item in the originating system, e.g. filler and placer ids." )
    protected List<DV_IDENTIFIER> originating_system_item_idsList;

    /**
     * Identifiers used for the item in the feeder system, where the feeder system is distinct from the originating system.
     */
    @Child(name = "feeder_system_item_ids", type = {DV_IDENTIFIER.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Identifiers used for the item in the feeder system", formalDefinition="Identifiers used for the item in the feeder system, where the feeder system is distinct from the originating system." )
    protected List<DV_IDENTIFIER> feeder_system_item_idsList;

    /**
     * Optional inline inclusion of or reference to original content corresponding to the openEHR content at this node. Typically a URI reference to a document or message in a persistent store associated with the EHR.
     */
    @Child(name = "original_content", type = {DV_ENCAPSULATED.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional inline inclusion of or reference to original content corresponding to the openEHR content at this node", formalDefinition="Optional inline inclusion of or reference to original content corresponding to the openEHR content at this node. Typically a URI reference to a document or message in a persistent store associated with the EHR." )
    protected DV_ENCAPSULATED original_content;

    /**
     * Any audit information for the information item from the originating system.
     */
    @Child(name = "originating_system_audit", type = {FEEDER_AUDIT_DETAILS.class}, order=3, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Any audit information for the information item from the originating system", formalDefinition="Any audit information for the information item from the originating system." )
    protected FEEDER_AUDIT_DETAILS originating_system_audit;

    /**
     * Any audit information for the information item from the feeder system, if different from the originating system.
     */
    @Child(name = "feeder_system_audit", type = {FEEDER_AUDIT_DETAILS.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Any audit information for the information item from the feeder system", formalDefinition="Any audit information for the information item from the feeder system, if different from the originating system." )
    protected FEEDER_AUDIT_DETAILS feeder_system_audit;

    private static final long serialVersionUID = -345281835L;

  /**
   * Constructor
   */
    public FEEDER_AUDIT() {
      super();
    }

  /**
   * Constructor
   */
    public FEEDER_AUDIT(FEEDER_AUDIT_DETAILS originating_system_audit) {
      super();
      this.setOriginating_system_audit(originating_system_audit);
    }

    /**
     * @return {@link #originating_system_item_ids} (Identifiers used for the item in the originating system, e.g. filler and placer ids.)
     */
    public List<DV_IDENTIFIER> getOriginating_system_item_idsList() { 
      if (this.originating_system_item_idsList == null)
        this.originating_system_item_idsList = new ArrayList<DV_IDENTIFIER>();
      return this.originating_system_item_idsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FEEDER_AUDIT setOriginating_system_item_idsList(List<DV_IDENTIFIER> theOriginating_system_item_ids) { 
      this.originating_system_item_idsList = theOriginating_system_item_ids;
      return this;
    }

    public boolean hasOriginating_system_item_ids() { 
      if (this.originating_system_item_idsList == null)
        return false;
      for (DV_IDENTIFIER item : this.originating_system_item_idsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DV_IDENTIFIER addOriginating_system_item_ids() { //3a
      DV_IDENTIFIER t = new DV_IDENTIFIER();
      if (this.originating_system_item_idsList == null)
        this.originating_system_item_idsList = new ArrayList<DV_IDENTIFIER>();
      this.originating_system_item_idsList.add(t);
      return t;
    }

    public FEEDER_AUDIT addOriginating_system_item_ids(DV_IDENTIFIER t) { //3b
      if (t == null)
        return this;
      if (this.originating_system_item_idsList == null)
        this.originating_system_item_idsList = new ArrayList<DV_IDENTIFIER>();
      this.originating_system_item_idsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #originating_system_item_ids}, creating it if it does not already exist {3}
     */
    public DV_IDENTIFIER getOriginating_system_item_idsFirstRep() { 
      if (getOriginating_system_item_idsList().isEmpty()) {
        addOriginating_system_item_ids();
      }
      return getOriginating_system_item_idsList().get(0);
    }

    /**
     * @return {@link #feeder_system_item_ids} (Identifiers used for the item in the feeder system, where the feeder system is distinct from the originating system.)
     */
    public List<DV_IDENTIFIER> getFeeder_system_item_idsList() { 
      if (this.feeder_system_item_idsList == null)
        this.feeder_system_item_idsList = new ArrayList<DV_IDENTIFIER>();
      return this.feeder_system_item_idsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FEEDER_AUDIT setFeeder_system_item_idsList(List<DV_IDENTIFIER> theFeeder_system_item_ids) { 
      this.feeder_system_item_idsList = theFeeder_system_item_ids;
      return this;
    }

    public boolean hasFeeder_system_item_ids() { 
      if (this.feeder_system_item_idsList == null)
        return false;
      for (DV_IDENTIFIER item : this.feeder_system_item_idsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DV_IDENTIFIER addFeeder_system_item_ids() { //3a
      DV_IDENTIFIER t = new DV_IDENTIFIER();
      if (this.feeder_system_item_idsList == null)
        this.feeder_system_item_idsList = new ArrayList<DV_IDENTIFIER>();
      this.feeder_system_item_idsList.add(t);
      return t;
    }

    public FEEDER_AUDIT addFeeder_system_item_ids(DV_IDENTIFIER t) { //3b
      if (t == null)
        return this;
      if (this.feeder_system_item_idsList == null)
        this.feeder_system_item_idsList = new ArrayList<DV_IDENTIFIER>();
      this.feeder_system_item_idsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #feeder_system_item_ids}, creating it if it does not already exist {3}
     */
    public DV_IDENTIFIER getFeeder_system_item_idsFirstRep() { 
      if (getFeeder_system_item_idsList().isEmpty()) {
        addFeeder_system_item_ids();
      }
      return getFeeder_system_item_idsList().get(0);
    }

    /**
     * @return {@link #original_content} (Optional inline inclusion of or reference to original content corresponding to the openEHR content at this node. Typically a URI reference to a document or message in a persistent store associated with the EHR.)
     */
    public DV_ENCAPSULATED getOriginal_content() { 
      return this.original_content;
    }

    public boolean hasOriginal_content() { 
      return this.original_content != null && !this.original_content.isEmpty();
    }

    /**
     * @param value {@link #original_content} (Optional inline inclusion of or reference to original content corresponding to the openEHR content at this node. Typically a URI reference to a document or message in a persistent store associated with the EHR.)
     */
    public FEEDER_AUDIT setOriginal_content(DV_ENCAPSULATED value) { 
      this.original_content = value;
      return this;
    }

    /**
     * @return {@link #originating_system_audit} (Any audit information for the information item from the originating system.)
     */
    public FEEDER_AUDIT_DETAILS getOriginating_system_audit() { 
      if (this.originating_system_audit == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FEEDER_AUDIT.originating_system_audit");
        else if (Configuration.doAutoCreate())
          this.originating_system_audit = new FEEDER_AUDIT_DETAILS(); // cc
      return this.originating_system_audit;
    }

    public boolean hasOriginating_system_audit() { 
      return this.originating_system_audit != null && !this.originating_system_audit.isEmpty();
    }

    /**
     * @param value {@link #originating_system_audit} (Any audit information for the information item from the originating system.)
     */
    public FEEDER_AUDIT setOriginating_system_audit(FEEDER_AUDIT_DETAILS value) { 
      this.originating_system_audit = value;
      return this;
    }

    /**
     * @return {@link #feeder_system_audit} (Any audit information for the information item from the feeder system, if different from the originating system.)
     */
    public FEEDER_AUDIT_DETAILS getFeeder_system_audit() { 
      if (this.feeder_system_audit == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FEEDER_AUDIT.feeder_system_audit");
        else if (Configuration.doAutoCreate())
          this.feeder_system_audit = new FEEDER_AUDIT_DETAILS(); // cc
      return this.feeder_system_audit;
    }

    public boolean hasFeeder_system_audit() { 
      return this.feeder_system_audit != null && !this.feeder_system_audit.isEmpty();
    }

    /**
     * @param value {@link #feeder_system_audit} (Any audit information for the information item from the feeder system, if different from the originating system.)
     */
    public FEEDER_AUDIT setFeeder_system_audit(FEEDER_AUDIT_DETAILS value) { 
      this.feeder_system_audit = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("originating_system_item_ids", "http://openehr.org/fhir/StructureDefinition/DV-IDENTIFIER", "Identifiers used for the item in the originating system, e.g. filler and placer ids.", 0, java.lang.Integer.MAX_VALUE, originating_system_item_idsList));
        children.add(new Property("feeder_system_item_ids", "http://openehr.org/fhir/StructureDefinition/DV-IDENTIFIER", "Identifiers used for the item in the feeder system, where the feeder system is distinct from the originating system.", 0, java.lang.Integer.MAX_VALUE, feeder_system_item_idsList));
        children.add(new Property("original_content", "http://openehr.org/fhir/StructureDefinition/DV-ENCAPSULATED", "Optional inline inclusion of or reference to original content corresponding to the openEHR content at this node. Typically a URI reference to a document or message in a persistent store associated with the EHR.", 0, 1, original_content));
        children.add(new Property("originating_system_audit", "http://openehr.org/fhir/StructureDefinition/FEEDER-AUDIT-DETAILS", "Any audit information for the information item from the originating system.", 0, 1, originating_system_audit));
        children.add(new Property("feeder_system_audit", "http://openehr.org/fhir/StructureDefinition/FEEDER-AUDIT-DETAILS", "Any audit information for the information item from the feeder system, if different from the originating system.", 0, 1, feeder_system_audit));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 156875462: /*originating_system_item_ids*/  return new Property("originating_system_item_ids", "http://openehr.org/fhir/StructureDefinition/DV-IDENTIFIER", "Identifiers used for the item in the originating system, e.g. filler and placer ids.", 0, java.lang.Integer.MAX_VALUE, originating_system_item_idsList);
        case 1194763816: /*feeder_system_item_ids*/  return new Property("feeder_system_item_ids", "http://openehr.org/fhir/StructureDefinition/DV-IDENTIFIER", "Identifiers used for the item in the feeder system, where the feeder system is distinct from the originating system.", 0, java.lang.Integer.MAX_VALUE, feeder_system_item_idsList);
        case 1891566603: /*original_content*/  return new Property("original_content", "http://openehr.org/fhir/StructureDefinition/DV-ENCAPSULATED", "Optional inline inclusion of or reference to original content corresponding to the openEHR content at this node. Typically a URI reference to a document or message in a persistent store associated with the EHR.", 0, 1, original_content);
        case 1684191969: /*originating_system_audit*/  return new Property("originating_system_audit", "http://openehr.org/fhir/StructureDefinition/FEEDER-AUDIT-DETAILS", "Any audit information for the information item from the originating system.", 0, 1, originating_system_audit);
        case -455976257: /*feeder_system_audit*/  return new Property("feeder_system_audit", "http://openehr.org/fhir/StructureDefinition/FEEDER-AUDIT-DETAILS", "Any audit information for the information item from the feeder system, if different from the originating system.", 0, 1, feeder_system_audit);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 156875462: /*originating_system_item_ids*/ return this.originating_system_item_idsList == null ? new Base[0] : this.originating_system_item_idsList.toArray(new Base[this.originating_system_item_idsList.size()]); // DV_IDENTIFIER
        case 1194763816: /*feeder_system_item_ids*/ return this.feeder_system_item_idsList == null ? new Base[0] : this.feeder_system_item_idsList.toArray(new Base[this.feeder_system_item_idsList.size()]); // DV_IDENTIFIER
        case 1891566603: /*original_content*/ return this.original_content == null ? new Base[0] : new Base[] {this.original_content}; // DV_ENCAPSULATED
        case 1684191969: /*originating_system_audit*/ return this.originating_system_audit == null ? new Base[0] : new Base[] {this.originating_system_audit}; // FEEDER_AUDIT_DETAILS
        case -455976257: /*feeder_system_audit*/ return this.feeder_system_audit == null ? new Base[0] : new Base[] {this.feeder_system_audit}; // FEEDER_AUDIT_DETAILS
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 156875462: // originating_system_item_ids
          this.getOriginating_system_item_idsList().add((DV_IDENTIFIER) value); // DV_IDENTIFIER
          return value;
        case 1194763816: // feeder_system_item_ids
          this.getFeeder_system_item_idsList().add((DV_IDENTIFIER) value); // DV_IDENTIFIER
          return value;
        case 1891566603: // original_content
          this.original_content = (DV_ENCAPSULATED) value; // DV_ENCAPSULATED
          return value;
        case 1684191969: // originating_system_audit
          this.originating_system_audit = (FEEDER_AUDIT_DETAILS) value; // FEEDER_AUDIT_DETAILS
          return value;
        case -455976257: // feeder_system_audit
          this.feeder_system_audit = (FEEDER_AUDIT_DETAILS) value; // FEEDER_AUDIT_DETAILS
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("originating_system_item_ids")) {
          this.getOriginating_system_item_idsList().add((DV_IDENTIFIER) value); // DV_IDENTIFIER
        } else if (name.equals("feeder_system_item_ids")) {
          this.getFeeder_system_item_idsList().add((DV_IDENTIFIER) value); // DV_IDENTIFIER
        } else if (name.equals("original_content")) {
          this.original_content = (DV_ENCAPSULATED) value; // DV_ENCAPSULATED
        } else if (name.equals("originating_system_audit")) {
          this.originating_system_audit = (FEEDER_AUDIT_DETAILS) value; // FEEDER_AUDIT_DETAILS
        } else if (name.equals("feeder_system_audit")) {
          this.feeder_system_audit = (FEEDER_AUDIT_DETAILS) value; // FEEDER_AUDIT_DETAILS
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 156875462:  return addOriginating_system_item_ids(); 
        case 1194763816:  return addFeeder_system_item_ids(); 
        case 1891566603: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'original_content'");
        case 1684191969:  return getOriginating_system_audit();
        case -455976257:  return getFeeder_system_audit();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 156875462: /*originating_system_item_ids*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-IDENTIFIER"};
        case 1194763816: /*feeder_system_item_ids*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-IDENTIFIER"};
        case 1891566603: /*original_content*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-ENCAPSULATED"};
        case 1684191969: /*originating_system_audit*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/FEEDER-AUDIT-DETAILS"};
        case -455976257: /*feeder_system_audit*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/FEEDER-AUDIT-DETAILS"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("originating_system_item_ids")) {
          return addOriginating_system_item_ids();
        }
        else if (name.equals("feeder_system_item_ids")) {
          return addFeeder_system_item_ids();
        }
        else if (name.equals("original_content")) {
          throw new FHIRException("Cannot call addChild on an abstract type FEEDER_AUDIT.original_content");
        }
        else if (name.equals("originating_system_audit")) {
          this.originating_system_audit = new FEEDER_AUDIT_DETAILS();
          return this.originating_system_audit;
        }
        else if (name.equals("feeder_system_audit")) {
          this.feeder_system_audit = new FEEDER_AUDIT_DETAILS();
          return this.feeder_system_audit;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "FEEDER_AUDIT";

  }

      public FEEDER_AUDIT copy() {
        FEEDER_AUDIT dst = new FEEDER_AUDIT();
        copyValues(dst);
        return dst;
      }

      public void copyValues(FEEDER_AUDIT dst) {
        super.copyValues(dst);
        if (originating_system_item_idsList != null) {
          dst.originating_system_item_idsList = new ArrayList<DV_IDENTIFIER>();
          for (DV_IDENTIFIER i : originating_system_item_idsList)
            dst.originating_system_item_idsList.add(i.copy());
        };
        if (feeder_system_item_idsList != null) {
          dst.feeder_system_item_idsList = new ArrayList<DV_IDENTIFIER>();
          for (DV_IDENTIFIER i : feeder_system_item_idsList)
            dst.feeder_system_item_idsList.add(i.copy());
        };
        dst.original_content = original_content == null ? null : original_content.copy();
        dst.originating_system_audit = originating_system_audit == null ? null : originating_system_audit.copy();
        dst.feeder_system_audit = feeder_system_audit == null ? null : feeder_system_audit.copy();
      }

      protected FEEDER_AUDIT typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof FEEDER_AUDIT))
          return false;
        FEEDER_AUDIT o = (FEEDER_AUDIT) other_;
        return compareDeep(originating_system_item_idsList, o.originating_system_item_idsList, true)
           && compareDeep(feeder_system_item_idsList, o.feeder_system_item_idsList, true) && compareDeep(original_content, o.original_content, true)
           && compareDeep(originating_system_audit, o.originating_system_audit, true) && compareDeep(feeder_system_audit, o.feeder_system_audit, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof FEEDER_AUDIT))
          return false;
        FEEDER_AUDIT o = (FEEDER_AUDIT) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(originating_system_item_idsList
          , feeder_system_item_idsList, original_content, originating_system_audit, feeder_system_audit
          );
      }


}

