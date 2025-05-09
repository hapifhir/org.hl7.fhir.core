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
 * The PATHABLE class defines the pathing capabilities used by nearly all classes in the openEHR reference model, mostly via inheritance of PATHABLE. The defining characteristics of PATHABLE objects are that they can locate child objects using paths, and they know their parent object in a compositional hierarchy. The parent feature is defined as abstract in the model, and may be implemented in any way convenient.
 */
@DatatypeDef(name="PATHABLE")
public abstract class PATHABLE extends Any implements ICompositeType {

    /**
     * This is the term provided via a clinical application or batch process to name this EHR construct: its retention in the EHR faithfully preserves the original label by which this entry was known to end users.
     */
    @Child(name = "name", type = {DV_TEXT.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Runtime name of this fragment, used to build runtime paths", formalDefinition="This is the term provided via a clinical application or batch process to name this EHR construct: its retention in the EHR faithfully preserves the original label by which this entry was known to end users." )
    protected DV_TEXT name;

    /**
     * Design-time archetype identifier of this node taken from its generating archetype; used to build archetype paths. Always in the form of an at-code, e.g. at0005. This value enables a 'standardised' name for this node to be generated, by referring to the generating archetype local terminology.
     */
    @Child(name = "archetype_node_id", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Design-time archetype identifier of this node taken from its generating archetype", formalDefinition="Design-time archetype identifier of this node taken from its generating archetype; used to build archetype paths. Always in the form of an at-code, e.g. at0005. This value enables a 'standardised' name for this node to be generated, by referring to the generating archetype local terminology." )
    protected StringType archetype_node_id;

    /**
     * Optional globally unique object identifier for root points of archetyped structures.
     */
    @Child(name = "uid", type = {UID_BASED_ID.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional globally unique object identifier for root points of archetyped structures", formalDefinition="Optional globally unique object identifier for root points of archetyped structures." )
    protected UID_BASED_ID uid;

    /**
     * Links to other archetyped structures (data whose root object inherits from ARCHETYPED, such as ENTRY, SECTION and so on). Links may be to structures in other compositions.
     */
    @Child(name = "links", type = {LINK.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Links to other archetyped structures", formalDefinition="Links to other archetyped structures (data whose root object inherits from ARCHETYPED, such as ENTRY, SECTION and so on). Links may be to structures in other compositions." )
    protected List<LINK> linksList;

    /**
     * Details of archetyping used on this node.
     */
    @Child(name = "archetype_details", type = {ARCHETYPED.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Details of archetyping used on this node", formalDefinition="Details of archetyping used on this node." )
    protected ARCHETYPED archetype_details;

    /**
     * Audit trail from non-openEHR system of original commit of information forming the content of this node, or from a conversion gateway which has synthesised this node.
     */
    @Child(name = "feeder_audit", type = {FEEDER_AUDIT.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Audit trail from non-openEHR system of original commit of information forming the content of this node", formalDefinition="Audit trail from non-openEHR system of original commit of information forming the content of this node, or from a conversion gateway which has synthesised this node." )
    protected FEEDER_AUDIT feeder_audit;

    private static final long serialVersionUID = 802051356L;

  /**
   * Constructor
   */
    public PATHABLE() {
      super();
    }

  /**
   * Constructor
   */
    public PATHABLE(DV_TEXT name, String archetype_node_id) {
      super();
      this.setName(name);
      this.setArchetype_node_id(archetype_node_id);
    }

    /**
     * @return {@link #name} (This is the term provided via a clinical application or batch process to name this EHR construct: its retention in the EHR faithfully preserves the original label by which this entry was known to end users.)
     */
    public DV_TEXT getName() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PATHABLE.name");
        else if (Configuration.doAutoCreate())
          this.name = new DV_TEXT(); // cc
      return this.name;
    }

    public boolean hasName() { 
      return this.name != null && !this.name.isEmpty();
    }

    /**
     * @param value {@link #name} (This is the term provided via a clinical application or batch process to name this EHR construct: its retention in the EHR faithfully preserves the original label by which this entry was known to end users.)
     */
    public PATHABLE setName(DV_TEXT value) { 
      this.name = value;
      return this;
    }

    /**
     * @return {@link #archetype_node_id} (Design-time archetype identifier of this node taken from its generating archetype; used to build archetype paths. Always in the form of an at-code, e.g. at0005. This value enables a 'standardised' name for this node to be generated, by referring to the generating archetype local terminology.). This is the underlying object with id, value and extensions. The accessor "getArchetype_node_id" gives direct access to the value
     */
    public StringType getArchetype_node_idElement() { 
      if (this.archetype_node_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PATHABLE.archetype_node_id");
        else if (Configuration.doAutoCreate())
          this.archetype_node_id = new StringType(); // bb
      return this.archetype_node_id;
    }

    public boolean hasArchetype_node_idElement() { 
      return this.archetype_node_id != null && !this.archetype_node_id.isEmpty();
    }

    public boolean hasArchetype_node_id() { 
      return this.archetype_node_id != null && !this.archetype_node_id.isEmpty();
    }

    /**
     * @param value {@link #archetype_node_id} (Design-time archetype identifier of this node taken from its generating archetype; used to build archetype paths. Always in the form of an at-code, e.g. at0005. This value enables a 'standardised' name for this node to be generated, by referring to the generating archetype local terminology.). This is the underlying object with id, value and extensions. The accessor "getArchetype_node_id" gives direct access to the value
     */
    public PATHABLE setArchetype_node_idElement(StringType value) { 
      this.archetype_node_id = value;
      return this;
    }

    /**
     * @return Design-time archetype identifier of this node taken from its generating archetype; used to build archetype paths. Always in the form of an at-code, e.g. at0005. This value enables a 'standardised' name for this node to be generated, by referring to the generating archetype local terminology.
     */
    public String getArchetype_node_id() { 
      return this.archetype_node_id == null ? null : this.archetype_node_id.getValue();
    }

    /**
     * @param value Design-time archetype identifier of this node taken from its generating archetype; used to build archetype paths. Always in the form of an at-code, e.g. at0005. This value enables a 'standardised' name for this node to be generated, by referring to the generating archetype local terminology.
     */
    public PATHABLE setArchetype_node_id(String value) { 
        if (this.archetype_node_id == null)
          this.archetype_node_id = new StringType();
        this.archetype_node_id.setValue(value);
      return this;
    }

    /**
     * @return {@link #uid} (Optional globally unique object identifier for root points of archetyped structures.)
     */
    public UID_BASED_ID getUid() { 
      return this.uid;
    }

    public boolean hasUid() { 
      return this.uid != null && !this.uid.isEmpty();
    }

    /**
     * @param value {@link #uid} (Optional globally unique object identifier for root points of archetyped structures.)
     */
    public PATHABLE setUid(UID_BASED_ID value) { 
      this.uid = value;
      return this;
    }

    /**
     * @return {@link #links} (Links to other archetyped structures (data whose root object inherits from ARCHETYPED, such as ENTRY, SECTION and so on). Links may be to structures in other compositions.)
     */
    public List<LINK> getLinksList() { 
      if (this.linksList == null)
        this.linksList = new ArrayList<LINK>();
      return this.linksList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PATHABLE setLinksList(List<LINK> theLinks) { 
      this.linksList = theLinks;
      return this;
    }

    public boolean hasLinks() { 
      if (this.linksList == null)
        return false;
      for (LINK item : this.linksList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public LINK addLinks() { //3a
      LINK t = new LINK();
      if (this.linksList == null)
        this.linksList = new ArrayList<LINK>();
      this.linksList.add(t);
      return t;
    }

    public PATHABLE addLinks(LINK t) { //3b
      if (t == null)
        return this;
      if (this.linksList == null)
        this.linksList = new ArrayList<LINK>();
      this.linksList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #links}, creating it if it does not already exist {3}
     */
    public LINK getLinksFirstRep() { 
      if (getLinksList().isEmpty()) {
        addLinks();
      }
      return getLinksList().get(0);
    }

    /**
     * @return {@link #archetype_details} (Details of archetyping used on this node.)
     */
    public ARCHETYPED getArchetype_details() { 
      if (this.archetype_details == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PATHABLE.archetype_details");
        else if (Configuration.doAutoCreate())
          this.archetype_details = new ARCHETYPED(); // cc
      return this.archetype_details;
    }

    public boolean hasArchetype_details() { 
      return this.archetype_details != null && !this.archetype_details.isEmpty();
    }

    /**
     * @param value {@link #archetype_details} (Details of archetyping used on this node.)
     */
    public PATHABLE setArchetype_details(ARCHETYPED value) { 
      this.archetype_details = value;
      return this;
    }

    /**
     * @return {@link #feeder_audit} (Audit trail from non-openEHR system of original commit of information forming the content of this node, or from a conversion gateway which has synthesised this node.)
     */
    public FEEDER_AUDIT getFeeder_audit() { 
      if (this.feeder_audit == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PATHABLE.feeder_audit");
        else if (Configuration.doAutoCreate())
          this.feeder_audit = new FEEDER_AUDIT(); // cc
      return this.feeder_audit;
    }

    public boolean hasFeeder_audit() { 
      return this.feeder_audit != null && !this.feeder_audit.isEmpty();
    }

    /**
     * @param value {@link #feeder_audit} (Audit trail from non-openEHR system of original commit of information forming the content of this node, or from a conversion gateway which has synthesised this node.)
     */
    public PATHABLE setFeeder_audit(FEEDER_AUDIT value) { 
      this.feeder_audit = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("name", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "This is the term provided via a clinical application or batch process to name this EHR construct: its retention in the EHR faithfully preserves the original label by which this entry was known to end users.", 0, 1, name));
        children.add(new Property("archetype_node_id", "string", "Design-time archetype identifier of this node taken from its generating archetype; used to build archetype paths. Always in the form of an at-code, e.g. at0005. This value enables a 'standardised' name for this node to be generated, by referring to the generating archetype local terminology.", 0, 1, archetype_node_id));
        children.add(new Property("uid", "http://openehr.org/fhir/StructureDefinition/UID-BASED-ID", "Optional globally unique object identifier for root points of archetyped structures.", 0, 1, uid));
        children.add(new Property("links", "http://openehr.org/fhir/StructureDefinition/LINK", "Links to other archetyped structures (data whose root object inherits from ARCHETYPED, such as ENTRY, SECTION and so on). Links may be to structures in other compositions.", 0, java.lang.Integer.MAX_VALUE, linksList));
        children.add(new Property("archetype_details", "http://openehr.org/fhir/StructureDefinition/ARCHETYPED", "Details of archetyping used on this node.", 0, 1, archetype_details));
        children.add(new Property("feeder_audit", "http://openehr.org/fhir/StructureDefinition/FEEDER-AUDIT", "Audit trail from non-openEHR system of original commit of information forming the content of this node, or from a conversion gateway which has synthesised this node.", 0, 1, feeder_audit));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3373707: /*name*/  return new Property("name", "http://openehr.org/fhir/StructureDefinition/DV-TEXT", "This is the term provided via a clinical application or batch process to name this EHR construct: its retention in the EHR faithfully preserves the original label by which this entry was known to end users.", 0, 1, name);
        case -448281406: /*archetype_node_id*/  return new Property("archetype_node_id", "string", "Design-time archetype identifier of this node taken from its generating archetype; used to build archetype paths. Always in the form of an at-code, e.g. at0005. This value enables a 'standardised' name for this node to be generated, by referring to the generating archetype local terminology.", 0, 1, archetype_node_id);
        case 115792: /*uid*/  return new Property("uid", "http://openehr.org/fhir/StructureDefinition/UID-BASED-ID", "Optional globally unique object identifier for root points of archetyped structures.", 0, 1, uid);
        case 102977465: /*links*/  return new Property("links", "http://openehr.org/fhir/StructureDefinition/LINK", "Links to other archetyped structures (data whose root object inherits from ARCHETYPED, such as ENTRY, SECTION and so on). Links may be to structures in other compositions.", 0, java.lang.Integer.MAX_VALUE, linksList);
        case -1005008244: /*archetype_details*/  return new Property("archetype_details", "http://openehr.org/fhir/StructureDefinition/ARCHETYPED", "Details of archetyping used on this node.", 0, 1, archetype_details);
        case 1287552359: /*feeder_audit*/  return new Property("feeder_audit", "http://openehr.org/fhir/StructureDefinition/FEEDER-AUDIT", "Audit trail from non-openEHR system of original commit of information forming the content of this node, or from a conversion gateway which has synthesised this node.", 0, 1, feeder_audit);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // DV_TEXT
        case -448281406: /*archetype_node_id*/ return this.archetype_node_id == null ? new Base[0] : new Base[] {this.archetype_node_id}; // StringType
        case 115792: /*uid*/ return this.uid == null ? new Base[0] : new Base[] {this.uid}; // UID_BASED_ID
        case 102977465: /*links*/ return this.linksList == null ? new Base[0] : this.linksList.toArray(new Base[this.linksList.size()]); // LINK
        case -1005008244: /*archetype_details*/ return this.archetype_details == null ? new Base[0] : new Base[] {this.archetype_details}; // ARCHETYPED
        case 1287552359: /*feeder_audit*/ return this.feeder_audit == null ? new Base[0] : new Base[] {this.feeder_audit}; // FEEDER_AUDIT
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = (DV_TEXT) value; // DV_TEXT
          return value;
        case -448281406: // archetype_node_id
          this.archetype_node_id = TypeConvertor.castToString(value); // StringType
          return value;
        case 115792: // uid
          this.uid = (UID_BASED_ID) value; // UID_BASED_ID
          return value;
        case 102977465: // links
          this.getLinksList().add((LINK) value); // LINK
          return value;
        case -1005008244: // archetype_details
          this.archetype_details = (ARCHETYPED) value; // ARCHETYPED
          return value;
        case 1287552359: // feeder_audit
          this.feeder_audit = (FEEDER_AUDIT) value; // FEEDER_AUDIT
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = (DV_TEXT) value; // DV_TEXT
        } else if (name.equals("archetype_node_id")) {
          this.archetype_node_id = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("uid")) {
          this.uid = (UID_BASED_ID) value; // UID_BASED_ID
        } else if (name.equals("links")) {
          this.getLinksList().add((LINK) value); // LINK
        } else if (name.equals("archetype_details")) {
          this.archetype_details = (ARCHETYPED) value; // ARCHETYPED
        } else if (name.equals("feeder_audit")) {
          this.feeder_audit = (FEEDER_AUDIT) value; // FEEDER_AUDIT
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getName();
        case -448281406:  return getArchetype_node_idElement();
        case 115792: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'uid'");
        case 102977465:  return addLinks(); 
        case -1005008244:  return getArchetype_details();
        case 1287552359:  return getFeeder_audit();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-TEXT"};
        case -448281406: /*archetype_node_id*/ return new String[] {"string"};
        case 115792: /*uid*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/UID-BASED-ID"};
        case 102977465: /*links*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/LINK"};
        case -1005008244: /*archetype_details*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ARCHETYPED"};
        case 1287552359: /*feeder_audit*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/FEEDER-AUDIT"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          this.name = new DV_TEXT();
          return this.name;
        }
        else if (name.equals("archetype_node_id")) {
          throw new FHIRException("Cannot call addChild on a singleton property PATHABLE.archetype_node_id");
        }
        else if (name.equals("uid")) {
          throw new FHIRException("Cannot call addChild on an abstract type PATHABLE.uid");
        }
        else if (name.equals("links")) {
          return addLinks();
        }
        else if (name.equals("archetype_details")) {
          this.archetype_details = new ARCHETYPED();
          return this.archetype_details;
        }
        else if (name.equals("feeder_audit")) {
          this.feeder_audit = new FEEDER_AUDIT();
          return this.feeder_audit;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PATHABLE";

  }

      public abstract PATHABLE copy();

      public void copyValues(PATHABLE dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.archetype_node_id = archetype_node_id == null ? null : archetype_node_id.copy();
        dst.uid = uid == null ? null : uid.copy();
        if (linksList != null) {
          dst.linksList = new ArrayList<LINK>();
          for (LINK i : linksList)
            dst.linksList.add(i.copy());
        };
        dst.archetype_details = archetype_details == null ? null : archetype_details.copy();
        dst.feeder_audit = feeder_audit == null ? null : feeder_audit.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PATHABLE))
          return false;
        PATHABLE o = (PATHABLE) other_;
        return compareDeep(name, o.name, true) && compareDeep(archetype_node_id, o.archetype_node_id, true)
           && compareDeep(uid, o.uid, true) && compareDeep(linksList, o.linksList, true) && compareDeep(archetype_details, o.archetype_details, true)
           && compareDeep(feeder_audit, o.feeder_audit, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PATHABLE))
          return false;
        PATHABLE o = (PATHABLE) other_;
        return compareValues(archetype_node_id, o.archetype_node_id, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, archetype_node_id, uid
          , linksList, archetype_details, feeder_audit);
      }


}

