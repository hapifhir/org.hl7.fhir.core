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
 * A tag with optional value that is associated with a target information entity identified by a UID.
 */
@DatatypeDef(name="ITEM_TAG")
public class ITEM_TAG extends LogicalBase implements ICompositeType {

    /**
     * The tag key. May not be empty or contain leading or trailing whitespace.
     */
    @Child(name = "key", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The tag key. May not be empty or contain leading or trailing whitespace", formalDefinition="The tag key. May not be empty or contain leading or trailing whitespace." )
    protected StringType key;

    /**
     * The value. If set, may not be empty.
     */
    @Child(name = "value", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The value. If set, may not be empty", formalDefinition="The value. If set, may not be empty." )
    protected StringType value;

    /**
     * Identifier of target, which may be a VERSIONED_OBJECT<T> or a VERSION<T>.
     */
    @Child(name = "target", type = {UID_BASED_ID.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identifier of target, which may be a VERSIONED_OBJECT<T> or a VERSION<T>", formalDefinition="Identifier of target, which may be a VERSIONED_OBJECT<T> or a VERSION<T>." )
    protected UID_BASED_ID target;

    /**
     * Optional archetype (i.e. AQL) or RM path within target, used to tag a fine-grained element.
     */
    @Child(name = "target_path", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional archetype (i.e. AQL) or RM path within target, used to tag a fine-grained element", formalDefinition="Optional archetype (i.e. AQL) or RM path within target, used to tag a fine-grained element." )
    protected StringType target_path;

    /**
     * Identifier of owner object, such as EHR.
     */
    @Child(name = "owner_id", type = {OBJECT_REF.class}, order=4, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identifier of owner object, such as EHR", formalDefinition="Identifier of owner object, such as EHR." )
    protected OBJECT_REF owner_id;

    private static final long serialVersionUID = -1845987839L;

  /**
   * Constructor
   */
    public ITEM_TAG() {
      super();
    }

  /**
   * Constructor
   */
    public ITEM_TAG(String key, UID_BASED_ID target, OBJECT_REF owner_id) {
      super();
      this.setKey(key);
      this.setTarget(target);
      this.setOwner_id(owner_id);
    }

    /**
     * @return {@link #key} (The tag key. May not be empty or contain leading or trailing whitespace.). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
     */
    public StringType getKeyElement() { 
      if (this.key == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ITEM_TAG.key");
        else if (Configuration.doAutoCreate())
          this.key = new StringType(); // bb
      return this.key;
    }

    public boolean hasKeyElement() { 
      return this.key != null && !this.key.isEmpty();
    }

    public boolean hasKey() { 
      return this.key != null && !this.key.isEmpty();
    }

    /**
     * @param value {@link #key} (The tag key. May not be empty or contain leading or trailing whitespace.). This is the underlying object with id, value and extensions. The accessor "getKey" gives direct access to the value
     */
    public ITEM_TAG setKeyElement(StringType value) { 
      this.key = value;
      return this;
    }

    /**
     * @return The tag key. May not be empty or contain leading or trailing whitespace.
     */
    public String getKey() { 
      return this.key == null ? null : this.key.getValue();
    }

    /**
     * @param value The tag key. May not be empty or contain leading or trailing whitespace.
     */
    public ITEM_TAG setKey(String value) { 
        if (this.key == null)
          this.key = new StringType();
        this.key.setValue(value);
      return this;
    }

    /**
     * @return {@link #value} (The value. If set, may not be empty.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public StringType getValueElement() { 
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ITEM_TAG.value");
        else if (Configuration.doAutoCreate())
          this.value = new StringType(); // bb
      return this.value;
    }

    public boolean hasValueElement() { 
      return this.value != null && !this.value.isEmpty();
    }

    public boolean hasValue() { 
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (The value. If set, may not be empty.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public ITEM_TAG setValueElement(StringType value) { 
      this.value = value;
      return this;
    }

    /**
     * @return The value. If set, may not be empty.
     */
    public String getValue() { 
      return this.value == null ? null : this.value.getValue();
    }

    /**
     * @param value The value. If set, may not be empty.
     */
    public ITEM_TAG setValue(String value) { 
      if (Utilities.noString(value))
        this.value = null;
      else {
        if (this.value == null)
          this.value = new StringType();
        this.value.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #target} (Identifier of target, which may be a VERSIONED_OBJECT<T> or a VERSION<T>.)
     */
    public UID_BASED_ID getTarget() { 
      return this.target;
    }

    public boolean hasTarget() { 
      return this.target != null && !this.target.isEmpty();
    }

    /**
     * @param value {@link #target} (Identifier of target, which may be a VERSIONED_OBJECT<T> or a VERSION<T>.)
     */
    public ITEM_TAG setTarget(UID_BASED_ID value) { 
      this.target = value;
      return this;
    }

    /**
     * @return {@link #target_path} (Optional archetype (i.e. AQL) or RM path within target, used to tag a fine-grained element.). This is the underlying object with id, value and extensions. The accessor "getTarget_path" gives direct access to the value
     */
    public StringType getTarget_pathElement() { 
      if (this.target_path == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ITEM_TAG.target_path");
        else if (Configuration.doAutoCreate())
          this.target_path = new StringType(); // bb
      return this.target_path;
    }

    public boolean hasTarget_pathElement() { 
      return this.target_path != null && !this.target_path.isEmpty();
    }

    public boolean hasTarget_path() { 
      return this.target_path != null && !this.target_path.isEmpty();
    }

    /**
     * @param value {@link #target_path} (Optional archetype (i.e. AQL) or RM path within target, used to tag a fine-grained element.). This is the underlying object with id, value and extensions. The accessor "getTarget_path" gives direct access to the value
     */
    public ITEM_TAG setTarget_pathElement(StringType value) { 
      this.target_path = value;
      return this;
    }

    /**
     * @return Optional archetype (i.e. AQL) or RM path within target, used to tag a fine-grained element.
     */
    public String getTarget_path() { 
      return this.target_path == null ? null : this.target_path.getValue();
    }

    /**
     * @param value Optional archetype (i.e. AQL) or RM path within target, used to tag a fine-grained element.
     */
    public ITEM_TAG setTarget_path(String value) { 
      if (Utilities.noString(value))
        this.target_path = null;
      else {
        if (this.target_path == null)
          this.target_path = new StringType();
        this.target_path.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #owner_id} (Identifier of owner object, such as EHR.)
     */
    public OBJECT_REF getOwner_id() { 
      if (this.owner_id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ITEM_TAG.owner_id");
        else if (Configuration.doAutoCreate())
          this.owner_id = new OBJECT_REF(); // cc
      return this.owner_id;
    }

    public boolean hasOwner_id() { 
      return this.owner_id != null && !this.owner_id.isEmpty();
    }

    /**
     * @param value {@link #owner_id} (Identifier of owner object, such as EHR.)
     */
    public ITEM_TAG setOwner_id(OBJECT_REF value) { 
      this.owner_id = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("key", "string", "The tag key. May not be empty or contain leading or trailing whitespace.", 0, 1, key));
        children.add(new Property("value", "string", "The value. If set, may not be empty.", 0, 1, value));
        children.add(new Property("target", "http://openehr.org/fhir/StructureDefinition/UID-BASED-ID", "Identifier of target, which may be a VERSIONED_OBJECT<T> or a VERSION<T>.", 0, 1, target));
        children.add(new Property("target_path", "string", "Optional archetype (i.e. AQL) or RM path within target, used to tag a fine-grained element.", 0, 1, target_path));
        children.add(new Property("owner_id", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Identifier of owner object, such as EHR.", 0, 1, owner_id));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 106079: /*key*/  return new Property("key", "string", "The tag key. May not be empty or contain leading or trailing whitespace.", 0, 1, key);
        case 111972721: /*value*/  return new Property("value", "string", "The value. If set, may not be empty.", 0, 1, value);
        case -880905839: /*target*/  return new Property("target", "http://openehr.org/fhir/StructureDefinition/UID-BASED-ID", "Identifier of target, which may be a VERSIONED_OBJECT<T> or a VERSION<T>.", 0, 1, target);
        case -2084700653: /*target_path*/  return new Property("target_path", "string", "Optional archetype (i.e. AQL) or RM path within target, used to tag a fine-grained element.", 0, 1, target_path);
        case 1663147559: /*owner_id*/  return new Property("owner_id", "http://openehr.org/fhir/StructureDefinition/OBJECT-REF", "Identifier of owner object, such as EHR.", 0, 1, owner_id);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return this.key == null ? new Base[0] : new Base[] {this.key}; // StringType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        case -880905839: /*target*/ return this.target == null ? new Base[0] : new Base[] {this.target}; // UID_BASED_ID
        case -2084700653: /*target_path*/ return this.target_path == null ? new Base[0] : new Base[] {this.target_path}; // StringType
        case 1663147559: /*owner_id*/ return this.owner_id == null ? new Base[0] : new Base[] {this.owner_id}; // OBJECT_REF
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 106079: // key
          this.key = TypeConvertor.castToString(value); // StringType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        case -880905839: // target
          this.target = (UID_BASED_ID) value; // UID_BASED_ID
          return value;
        case -2084700653: // target_path
          this.target_path = TypeConvertor.castToString(value); // StringType
          return value;
        case 1663147559: // owner_id
          this.owner_id = (OBJECT_REF) value; // OBJECT_REF
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("key")) {
          this.key = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("target")) {
          this.target = (UID_BASED_ID) value; // UID_BASED_ID
        } else if (name.equals("target_path")) {
          this.target_path = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("owner_id")) {
          this.owner_id = (OBJECT_REF) value; // OBJECT_REF
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079:  return getKeyElement();
        case 111972721:  return getValueElement();
        case -880905839: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'target'");
        case -2084700653:  return getTarget_pathElement();
        case 1663147559:  return getOwner_id();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106079: /*key*/ return new String[] {"string"};
        case 111972721: /*value*/ return new String[] {"string"};
        case -880905839: /*target*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/UID-BASED-ID"};
        case -2084700653: /*target_path*/ return new String[] {"string"};
        case 1663147559: /*owner_id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-REF"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("key")) {
          throw new FHIRException("Cannot call addChild on a singleton property ITEM_TAG.key");
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property ITEM_TAG.value");
        }
        else if (name.equals("target")) {
          throw new FHIRException("Cannot call addChild on an abstract type ITEM_TAG.target");
        }
        else if (name.equals("target_path")) {
          throw new FHIRException("Cannot call addChild on a singleton property ITEM_TAG.target_path");
        }
        else if (name.equals("owner_id")) {
          this.owner_id = new OBJECT_REF();
          return this.owner_id;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ITEM_TAG";

  }

      public ITEM_TAG copy() {
        ITEM_TAG dst = new ITEM_TAG();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ITEM_TAG dst) {
        super.copyValues(dst);
        dst.key = key == null ? null : key.copy();
        dst.value = value == null ? null : value.copy();
        dst.target = target == null ? null : target.copy();
        dst.target_path = target_path == null ? null : target_path.copy();
        dst.owner_id = owner_id == null ? null : owner_id.copy();
      }

      protected ITEM_TAG typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ITEM_TAG))
          return false;
        ITEM_TAG o = (ITEM_TAG) other_;
        return compareDeep(key, o.key, true) && compareDeep(value, o.value, true) && compareDeep(target, o.target, true)
           && compareDeep(target_path, o.target_path, true) && compareDeep(owner_id, o.owner_id, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ITEM_TAG))
          return false;
        ITEM_TAG o = (ITEM_TAG) other_;
        return compareValues(key, o.key, true) && compareValues(value, o.value, true) && compareValues(target_path, o.target_path, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(key, value, target, target_path
          , owner_id);
      }


}

