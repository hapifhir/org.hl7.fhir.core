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
 * Archetypes act as the configuration basis for the particular structures of instances defined by the reference model. To enable archetypes to be used to create valid data, key classes in the reference model act as root points for archetyping; accordingly, these classes have the archetype_details attribute set. An instance of the class ARCHETYPED contains the relevant archetype identification information, allowing generating archetypes to be matched up with data instances.
 */
@DatatypeDef(name="ARCHETYPED")
public class ARCHETYPED extends LogicalBase implements ICompositeType {

    /**
     * Globally unique archetype identifier.
     */
    @Child(name = "archetype_id", type = {ARCHETYPE_ID.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Globally unique archetype identifier", formalDefinition="Globally unique archetype identifier." )
    protected ARCHETYPE_ID archetype_id;

    /**
     * Globally unique template identifier, if a template was active at this point in the structure. Normally, a template would only be used at the top of a top-level structure, but the possibility exists for templates at lower levels.
     */
    @Child(name = "template_id", type = {TEMPLATE_ID.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Globally unique template identifier, if a template was active", formalDefinition="Globally unique template identifier, if a template was active at this point in the structure. Normally, a template would only be used at the top of a top-level structure, but the possibility exists for templates at lower levels." )
    protected TEMPLATE_ID template_id;

    /**
     * Version of the openEHR reference model used to create this object. Expressed in terms of the release version string, e.g. 1.0 , 1.2.4 .
     */
    @Child(name = "rm_version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Version of the openEHR reference model used to create this object", formalDefinition="Version of the openEHR reference model used to create this object. Expressed in terms of the release version string, e.g. 1.0 , 1.2.4 ." )
    protected StringType rm_version;

    private static final long serialVersionUID = 155490869L;

  /**
   * Constructor
   */
    public ARCHETYPED() {
      super();
    }

  /**
   * Constructor
   */
    public ARCHETYPED(ARCHETYPE_ID archetype_id) {
      super();
      this.setArchetype_id(archetype_id);
    }

    /**
     * @return {@link #archetype_id} (Globally unique archetype identifier.)
     */
    public ARCHETYPE_ID getArchetype_id() { 
      if (this.archetype_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ARCHETYPED.archetype_id");
        else if (Configuration.doAutoCreate())
          this.archetype_id = new ARCHETYPE_ID(); // cc
      return this.archetype_id;
    }

    public boolean hasArchetype_id() { 
      return this.archetype_id != null && !this.archetype_id.isEmpty();
    }

    /**
     * @param value {@link #archetype_id} (Globally unique archetype identifier.)
     */
    public ARCHETYPED setArchetype_id(ARCHETYPE_ID value) { 
      this.archetype_id = value;
      return this;
    }

    /**
     * @return {@link #template_id} (Globally unique template identifier, if a template was active at this point in the structure. Normally, a template would only be used at the top of a top-level structure, but the possibility exists for templates at lower levels.)
     */
    public TEMPLATE_ID getTemplate_id() { 
      if (this.template_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ARCHETYPED.template_id");
        else if (Configuration.doAutoCreate())
          this.template_id = new TEMPLATE_ID(); // cc
      return this.template_id;
    }

    public boolean hasTemplate_id() { 
      return this.template_id != null && !this.template_id.isEmpty();
    }

    /**
     * @param value {@link #template_id} (Globally unique template identifier, if a template was active at this point in the structure. Normally, a template would only be used at the top of a top-level structure, but the possibility exists for templates at lower levels.)
     */
    public ARCHETYPED setTemplate_id(TEMPLATE_ID value) { 
      this.template_id = value;
      return this;
    }

    /**
     * @return {@link #rm_version} (Version of the openEHR reference model used to create this object. Expressed in terms of the release version string, e.g. 1.0 , 1.2.4 .). This is the underlying object with id, value and extensions. The accessor "getRm_version" gives direct access to the value
     */
    public StringType getRm_versionElement() { 
      if (this.rm_version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ARCHETYPED.rm_version");
        else if (Configuration.doAutoCreate())
          this.rm_version = new StringType(); // bb
      return this.rm_version;
    }

    public boolean hasRm_versionElement() { 
      return this.rm_version != null && !this.rm_version.isEmpty();
    }

    public boolean hasRm_version() { 
      return this.rm_version != null && !this.rm_version.isEmpty();
    }

    /**
     * @param value {@link #rm_version} (Version of the openEHR reference model used to create this object. Expressed in terms of the release version string, e.g. 1.0 , 1.2.4 .). This is the underlying object with id, value and extensions. The accessor "getRm_version" gives direct access to the value
     */
    public ARCHETYPED setRm_versionElement(StringType value) { 
      this.rm_version = value;
      return this;
    }

    /**
     * @return Version of the openEHR reference model used to create this object. Expressed in terms of the release version string, e.g. 1.0 , 1.2.4 .
     */
    public String getRm_version() { 
      return this.rm_version == null ? null : this.rm_version.getValue();
    }

    /**
     * @param value Version of the openEHR reference model used to create this object. Expressed in terms of the release version string, e.g. 1.0 , 1.2.4 .
     */
    public ARCHETYPED setRm_version(String value) { 
      if (Utilities.noString(value))
        this.rm_version = null;
      else {
        if (this.rm_version == null)
          this.rm_version = new StringType();
        this.rm_version.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("archetype_id", "http://openehr.org/fhir/StructureDefinition/ARCHETYPE-ID", "Globally unique archetype identifier.", 0, 1, archetype_id));
        children.add(new Property("template_id", "http://openehr.org/fhir/StructureDefinition/TEMPLATE-ID", "Globally unique template identifier, if a template was active at this point in the structure. Normally, a template would only be used at the top of a top-level structure, but the possibility exists for templates at lower levels.", 0, 1, template_id));
        children.add(new Property("rm_version", "string", "Version of the openEHR reference model used to create this object. Expressed in terms of the release version string, e.g. 1.0 , 1.2.4 .", 0, 1, rm_version));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1252479343: /*archetype_id*/  return new Property("archetype_id", "http://openehr.org/fhir/StructureDefinition/ARCHETYPE-ID", "Globally unique archetype identifier.", 0, 1, archetype_id);
        case 1769642752: /*template_id*/  return new Property("template_id", "http://openehr.org/fhir/StructureDefinition/TEMPLATE-ID", "Globally unique template identifier, if a template was active at this point in the structure. Normally, a template would only be used at the top of a top-level structure, but the possibility exists for templates at lower levels.", 0, 1, template_id);
        case -1956878636: /*rm_version*/  return new Property("rm_version", "string", "Version of the openEHR reference model used to create this object. Expressed in terms of the release version string, e.g. 1.0 , 1.2.4 .", 0, 1, rm_version);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1252479343: /*archetype_id*/ return this.archetype_id == null ? new Base[0] : new Base[] {this.archetype_id}; // ARCHETYPE_ID
        case 1769642752: /*template_id*/ return this.template_id == null ? new Base[0] : new Base[] {this.template_id}; // TEMPLATE_ID
        case -1956878636: /*rm_version*/ return this.rm_version == null ? new Base[0] : new Base[] {this.rm_version}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1252479343: // archetype_id
          this.archetype_id = (ARCHETYPE_ID) value; // ARCHETYPE_ID
          return value;
        case 1769642752: // template_id
          this.template_id = (TEMPLATE_ID) value; // TEMPLATE_ID
          return value;
        case -1956878636: // rm_version
          this.rm_version = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("archetype_id")) {
          this.archetype_id = (ARCHETYPE_ID) value; // ARCHETYPE_ID
        } else if (name.equals("template_id")) {
          this.template_id = (TEMPLATE_ID) value; // TEMPLATE_ID
        } else if (name.equals("rm_version")) {
          this.rm_version = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1252479343:  return getArchetype_id();
        case 1769642752:  return getTemplate_id();
        case -1956878636:  return getRm_versionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1252479343: /*archetype_id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/ARCHETYPE-ID"};
        case 1769642752: /*template_id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/TEMPLATE-ID"};
        case -1956878636: /*rm_version*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("archetype_id")) {
          this.archetype_id = new ARCHETYPE_ID();
          return this.archetype_id;
        }
        else if (name.equals("template_id")) {
          this.template_id = new TEMPLATE_ID();
          return this.template_id;
        }
        else if (name.equals("rm_version")) {
          throw new FHIRException("Cannot call addChild on a singleton property ARCHETYPED.rm_version");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ARCHETYPED";

  }

      public ARCHETYPED copy() {
        ARCHETYPED dst = new ARCHETYPED();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ARCHETYPED dst) {
        super.copyValues(dst);
        dst.archetype_id = archetype_id == null ? null : archetype_id.copy();
        dst.template_id = template_id == null ? null : template_id.copy();
        dst.rm_version = rm_version == null ? null : rm_version.copy();
      }

      protected ARCHETYPED typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ARCHETYPED))
          return false;
        ARCHETYPED o = (ARCHETYPED) other_;
        return compareDeep(archetype_id, o.archetype_id, true) && compareDeep(template_id, o.template_id, true)
           && compareDeep(rm_version, o.rm_version, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ARCHETYPED))
          return false;
        ARCHETYPED o = (ARCHETYPED) other_;
        return compareValues(rm_version, o.rm_version, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(archetype_id, template_id
          , rm_version);
      }


}

