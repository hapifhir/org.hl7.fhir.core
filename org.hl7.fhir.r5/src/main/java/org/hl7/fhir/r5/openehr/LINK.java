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
 * The LINK type defines a logical relationship between two items, such as two ENTRYs or an ENTRY and a COMPOSITION. Links can be used across compositions, and across EHRs. Links can potentially be used between interior (i.e. non archetype root) nodes, although this probably should be prevented in archetypes. Multiple LINKs can be attached to the root object of any LINK structure to give the effect of a 1→N link. 1:1 and 1:N relationships between LINK content elements (e.g. ENTRYs) can be expressed by using one, or more than one, respectively, LINKs. Chains of links can be used to see problem threads or other logical groupings of items. Links should be between LINK structures only, i.e. between objects representing complete domain concepts because relationships between sub-elements of whole concepts are not necessarily meaningful, and may be downright confusing. Sensible links only exist between whole ENTRYs, SECTIONs, COMPOSITIONs and so on.
 */
@DatatypeDef(name="LINK")
public class LINK extends LogicalBase implements ICompositeType {

    /**
     * Used to describe the relationship, usually in clinical terms, such as in response to (the relationship between test results and an order), follow-up to and so on. Such relationships can represent any clinically meaningful connection between pieces of information. Values for meaning include those described in Annex C, ENV 13606 pt 2 under the categories of generic , documenting and reporting , organisational , clinical , circumstancial , and view management .
     */
    @Child(name = "meaning", type = {DV_TEXT.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Used to describe the relationship, usually in clinical terms", formalDefinition="Used to describe the relationship, usually in clinical terms, such as in response to (the relationship between test results and an order), follow-up to and so on. Such relationships can represent any clinically meaningful connection between pieces of information. Values for meaning include those described in Annex C, ENV 13606 pt 2 under the categories of generic , documenting and reporting , organisational , clinical , circumstancial , and view management ." )
    protected DV_TEXT meaning;

    /**
     * The type attribute is used to indicate a clinical or domain-level meaning for the kind of link, for example problem or issue . If type values are designed appropriately, they can be used by the requestor of EHR extracts to categorise links which must be followed and which can be broken when the extract is created.
     */
    @Child(name = "type", type = {DV_TEXT.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The type attribute is used to indicate a clinical or domain-level meaning for the kind of link", formalDefinition="The type attribute is used to indicate a clinical or domain-level meaning for the kind of link, for example problem or issue . If type values are designed appropriately, they can be used by the requestor of EHR extracts to categorise links which must be followed and which can be broken when the extract is created." )
    protected DV_TEXT type;

    /**
     * The logical to object in the link relation, as per the linguistic sense of the meaning attribute.
     */
    @Child(name = "target", type = {DV_EHR_URI.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The logical to object in the link relation", formalDefinition="The logical to object in the link relation, as per the linguistic sense of the meaning attribute." )
    protected DV_EHR_URI target;

    private static final long serialVersionUID = -611201093L;

  /**
   * Constructor
   */
    public LINK() {
      super();
    }

  /**
   * Constructor
   */
    public LINK(DV_TEXT meaning, DV_TEXT type, DV_EHR_URI target) {
      super();
      this.setMeaning(meaning);
      this.setType(type);
      this.setTarget(target);
    }

    /**
     * @return {@link #meaning} (Used to describe the relationship, usually in clinical terms, such as in response to (the relationship between test results and an order), follow-up to and so on. Such relationships can represent any clinically meaningful connection between pieces of information. Values for meaning include those described in Annex C, ENV 13606 pt 2 under the categories of generic , documenting and reporting , organisational , clinical , circumstancial , and view management .)
     */
    public DV_TEXT getMeaning() { 
      if (this.meaning == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create LINK.meaning");
        else if (Configuration.doAutoCreate())
          this.meaning = new DV_TEXT(); // cc
      return this.meaning;
    }

    public boolean hasMeaning() { 
      return this.meaning != null && !this.meaning.isEmpty();
    }

    /**
     * @param value {@link #meaning} (Used to describe the relationship, usually in clinical terms, such as in response to (the relationship between test results and an order), follow-up to and so on. Such relationships can represent any clinically meaningful connection between pieces of information. Values for meaning include those described in Annex C, ENV 13606 pt 2 under the categories of generic , documenting and reporting , organisational , clinical , circumstancial , and view management .)
     */
    public LINK setMeaning(DV_TEXT value) { 
      this.meaning = value;
      return this;
    }

    /**
     * @return {@link #type} (The type attribute is used to indicate a clinical or domain-level meaning for the kind of link, for example problem or issue . If type values are designed appropriately, they can be used by the requestor of EHR extracts to categorise links which must be followed and which can be broken when the extract is created.)
     */
    public DV_TEXT getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create LINK.type");
        else if (Configuration.doAutoCreate())
          this.type = new DV_TEXT(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The type attribute is used to indicate a clinical or domain-level meaning for the kind of link, for example problem or issue . If type values are designed appropriately, they can be used by the requestor of EHR extracts to categorise links which must be followed and which can be broken when the extract is created.)
     */
    public LINK setType(DV_TEXT value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #target} (The logical to object in the link relation, as per the linguistic sense of the meaning attribute.)
     */
    public DV_EHR_URI getTarget() { 
      if (this.target == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create LINK.target");
        else if (Configuration.doAutoCreate())
          this.target = new DV_EHR_URI(); // cc
      return this.target;
    }

    public boolean hasTarget() { 
      return this.target != null && !this.target.isEmpty();
    }

    /**
     * @param value {@link #target} (The logical to object in the link relation, as per the linguistic sense of the meaning attribute.)
     */
    public LINK setTarget(DV_EHR_URI value) { 
      this.target = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("meaning", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Used to describe the relationship, usually in clinical terms, such as in response to (the relationship between test results and an order), follow-up to and so on. Such relationships can represent any clinically meaningful connection between pieces of information. Values for meaning include those described in Annex C, ENV 13606 pt 2 under the categories of generic , documenting and reporting , organisational , clinical , circumstancial , and view management .", 0, 1, meaning));
        children.add(new Property("type", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "The type attribute is used to indicate a clinical or domain-level meaning for the kind of link, for example problem or issue . If type values are designed appropriately, they can be used by the requestor of EHR extracts to categorise links which must be followed and which can be broken when the extract is created.", 0, 1, type));
        children.add(new Property("target", "http://openehr.org/fhir/StructureDefinition/DV-EHR-URI", "The logical to object in the link relation, as per the linguistic sense of the meaning attribute.", 0, 1, target));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 938160637: /*meaning*/  return new Property("meaning", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "Used to describe the relationship, usually in clinical terms, such as in response to (the relationship between test results and an order), follow-up to and so on. Such relationships can represent any clinically meaningful connection between pieces of information. Values for meaning include those described in Annex C, ENV 13606 pt 2 under the categories of generic , documenting and reporting , organisational , clinical , circumstancial , and view management .", 0, 1, meaning);
        case 3575610: /*type*/  return new Property("type", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "The type attribute is used to indicate a clinical or domain-level meaning for the kind of link, for example problem or issue . If type values are designed appropriately, they can be used by the requestor of EHR extracts to categorise links which must be followed and which can be broken when the extract is created.", 0, 1, type);
        case -880905839: /*target*/  return new Property("target", "http://openehr.org/fhir/StructureDefinition/DV-EHR-URI", "The logical to object in the link relation, as per the linguistic sense of the meaning attribute.", 0, 1, target);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 938160637: /*meaning*/ return this.meaning == null ? new Base[0] : new Base[] {this.meaning}; // DV_TEXT
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // DV_TEXT
        case -880905839: /*target*/ return this.target == null ? new Base[0] : new Base[] {this.target}; // DV_EHR_URI
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 938160637: // meaning
          this.meaning = (DV_TEXT) value; // DV_TEXT
          return value;
        case 3575610: // type
          this.type = (DV_TEXT) value; // DV_TEXT
          return value;
        case -880905839: // target
          this.target = (DV_EHR_URI) value; // DV_EHR_URI
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("meaning")) {
          this.meaning = (DV_TEXT) value; // DV_TEXT
        } else if (name.equals("type")) {
          this.type = (DV_TEXT) value; // DV_TEXT
        } else if (name.equals("target")) {
          this.target = (DV_EHR_URI) value; // DV_EHR_URI
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 938160637:  return getMeaning();
        case 3575610:  return getType();
        case -880905839:  return getTarget();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 938160637: /*meaning*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        case 3575610: /*type*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        case -880905839: /*target*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-EHR-URI"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("meaning")) {
          this.meaning = new DV_TEXT();
          return this.meaning;
        }
        else if (name.equals("type")) {
          this.type = new DV_TEXT();
          return this.type;
        }
        else if (name.equals("target")) {
          this.target = new DV_EHR_URI();
          return this.target;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "LINK";

  }

      public LINK copy() {
        LINK dst = new LINK();
        copyValues(dst);
        return dst;
      }

      public void copyValues(LINK dst) {
        super.copyValues(dst);
        dst.meaning = meaning == null ? null : meaning.copy();
        dst.type = type == null ? null : type.copy();
        dst.target = target == null ? null : target.copy();
      }

      protected LINK typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof LINK))
          return false;
        LINK o = (LINK) other_;
        return compareDeep(meaning, o.meaning, true) && compareDeep(type, o.type, true) && compareDeep(target, o.target, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof LINK))
          return false;
        LINK o = (LINK) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(meaning, type, target);
      }


}

