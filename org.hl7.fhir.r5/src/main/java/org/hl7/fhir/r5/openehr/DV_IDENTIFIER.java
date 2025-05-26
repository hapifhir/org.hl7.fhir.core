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
 * Type for representing identifiers of real-world entities. Typical identifiers include drivers licence number, social security number, veterans affairs number, prescription id, order id, and so on. DV_IDENTIFIER is used to represent any identifier of a real thing, issued by some authority or agency.
 */
@DatatypeDef(name="DV_IDENTIFIER")
public class DV_IDENTIFIER extends DATA_VALUE implements ICompositeType {

    /**
     * Optional authority which issues the kind of id used in the id field of this object.
     */
    @Child(name = "issuer", type = {StringType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional authority which issues the kind of id used in the id field of this object", formalDefinition="Optional authority which issues the kind of id used in the id field of this object." )
    protected StringType issuer;

    /**
     * Optional organisation that assigned the id to the item being identified.
     */
    @Child(name = "assigner", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional organisation that assigned the id to the item being identified", formalDefinition="Optional organisation that assigned the id to the item being identified." )
    protected StringType assigner;

    /**
     * The identifier value. Often structured, according to the definition of the issuing authority’s rules.
     */
    @Child(name = "id", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The identifier value", formalDefinition="The identifier value. Often structured, according to the definition of the issuing authority’s rules." )
    protected StringType id;

    /**
     * Optional identifier type, such as prescription, or Social Security Number. One day a controlled vocabulary might be possible for this.
     */
    @Child(name = "type", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional identifier type, such as prescription, or Social Security Number", formalDefinition="Optional identifier type, such as prescription, or Social Security Number. One day a controlled vocabulary might be possible for this." )
    protected StringType type;

    private static final long serialVersionUID = -1346721174L;

  /**
   * Constructor
   */
    public DV_IDENTIFIER() {
      super();
    }

  /**
   * Constructor
   */
    public DV_IDENTIFIER(String id) {
      super();
      this.setId(id);
    }

    /**
     * @return {@link #issuer} (Optional authority which issues the kind of id used in the id field of this object.). This is the underlying object with id, value and extensions. The accessor "getIssuer" gives direct access to the value
     */
    public StringType getIssuerElement() { 
      if (this.issuer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_IDENTIFIER.issuer");
        else if (Configuration.doAutoCreate())
          this.issuer = new StringType(); // bb
      return this.issuer;
    }

    public boolean hasIssuerElement() { 
      return this.issuer != null && !this.issuer.isEmpty();
    }

    public boolean hasIssuer() { 
      return this.issuer != null && !this.issuer.isEmpty();
    }

    /**
     * @param value {@link #issuer} (Optional authority which issues the kind of id used in the id field of this object.). This is the underlying object with id, value and extensions. The accessor "getIssuer" gives direct access to the value
     */
    public DV_IDENTIFIER setIssuerElement(StringType value) { 
      this.issuer = value;
      return this;
    }

    /**
     * @return Optional authority which issues the kind of id used in the id field of this object.
     */
    public String getIssuer() { 
      return this.issuer == null ? null : this.issuer.getValue();
    }

    /**
     * @param value Optional authority which issues the kind of id used in the id field of this object.
     */
    public DV_IDENTIFIER setIssuer(String value) { 
      if (Utilities.noString(value))
        this.issuer = null;
      else {
        if (this.issuer == null)
          this.issuer = new StringType();
        this.issuer.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #assigner} (Optional organisation that assigned the id to the item being identified.). This is the underlying object with id, value and extensions. The accessor "getAssigner" gives direct access to the value
     */
    public StringType getAssignerElement() { 
      if (this.assigner == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_IDENTIFIER.assigner");
        else if (Configuration.doAutoCreate())
          this.assigner = new StringType(); // bb
      return this.assigner;
    }

    public boolean hasAssignerElement() { 
      return this.assigner != null && !this.assigner.isEmpty();
    }

    public boolean hasAssigner() { 
      return this.assigner != null && !this.assigner.isEmpty();
    }

    /**
     * @param value {@link #assigner} (Optional organisation that assigned the id to the item being identified.). This is the underlying object with id, value and extensions. The accessor "getAssigner" gives direct access to the value
     */
    public DV_IDENTIFIER setAssignerElement(StringType value) { 
      this.assigner = value;
      return this;
    }

    /**
     * @return Optional organisation that assigned the id to the item being identified.
     */
    public String getAssigner() { 
      return this.assigner == null ? null : this.assigner.getValue();
    }

    /**
     * @param value Optional organisation that assigned the id to the item being identified.
     */
    public DV_IDENTIFIER setAssigner(String value) { 
      if (Utilities.noString(value))
        this.assigner = null;
      else {
        if (this.assigner == null)
          this.assigner = new StringType();
        this.assigner.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #id} (The identifier value. Often structured, according to the definition of the issuing authority’s rules.). This is the underlying object with id, value and extensions. The accessor "getId" gives direct access to the value
     */
    public StringType getIdElement() { 
      if (this.id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_IDENTIFIER.id");
        else if (Configuration.doAutoCreate())
          this.id = new StringType(); // bb
      return this.id;
    }

    public boolean hasIdElement() { 
      return this.id != null && !this.id.isEmpty();
    }

    public boolean hasId() { 
      return this.id != null && !this.id.isEmpty();
    }

    /**
     * @param value {@link #id} (The identifier value. Often structured, according to the definition of the issuing authority’s rules.). This is the underlying object with id, value and extensions. The accessor "getId" gives direct access to the value
     */
    public DV_IDENTIFIER setIdElement(StringType value) { 
      this.id = value;
      return this;
    }

    /**
     * @return The identifier value. Often structured, according to the definition of the issuing authority’s rules.
     */
    public String getId() { 
      return this.id == null ? null : this.id.getValue();
    }

    /**
     * @param value The identifier value. Often structured, according to the definition of the issuing authority’s rules.
     */
    public DV_IDENTIFIER setId(String value) { 
        if (this.id == null)
          this.id = new StringType();
        this.id.setValue(value);
      return this;
    }

    /**
     * @return {@link #type} (Optional identifier type, such as prescription, or Social Security Number. One day a controlled vocabulary might be possible for this.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public StringType getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_IDENTIFIER.type");
        else if (Configuration.doAutoCreate())
          this.type = new StringType(); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Optional identifier type, such as prescription, or Social Security Number. One day a controlled vocabulary might be possible for this.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public DV_IDENTIFIER setTypeElement(StringType value) { 
      this.type = value;
      return this;
    }

    /**
     * @return Optional identifier type, such as prescription, or Social Security Number. One day a controlled vocabulary might be possible for this.
     */
    public String getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value Optional identifier type, such as prescription, or Social Security Number. One day a controlled vocabulary might be possible for this.
     */
    public DV_IDENTIFIER setType(String value) { 
      if (Utilities.noString(value))
        this.type = null;
      else {
        if (this.type == null)
          this.type = new StringType();
        this.type.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("issuer", "string", "Optional authority which issues the kind of id used in the id field of this object.", 0, 1, issuer));
        children.add(new Property("assigner", "string", "Optional organisation that assigned the id to the item being identified.", 0, 1, assigner));
        children.add(new Property("id", "string", "The identifier value. Often structured, according to the definition of the issuing authority’s rules.", 0, 1, id));
        children.add(new Property("type", "string", "Optional identifier type, such as prescription, or Social Security Number. One day a controlled vocabulary might be possible for this.", 0, 1, type));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1179159879: /*issuer*/  return new Property("issuer", "string", "Optional authority which issues the kind of id used in the id field of this object.", 0, 1, issuer);
        case -369881636: /*assigner*/  return new Property("assigner", "string", "Optional organisation that assigned the id to the item being identified.", 0, 1, assigner);
        case 3355: /*id*/  return new Property("id", "string", "The identifier value. Often structured, according to the definition of the issuing authority’s rules.", 0, 1, id);
        case 3575610: /*type*/  return new Property("type", "string", "Optional identifier type, such as prescription, or Social Security Number. One day a controlled vocabulary might be possible for this.", 0, 1, type);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1179159879: /*issuer*/ return this.issuer == null ? new Base[0] : new Base[] {this.issuer}; // StringType
        case -369881636: /*assigner*/ return this.assigner == null ? new Base[0] : new Base[] {this.assigner}; // StringType
        case 3355: /*id*/ return this.id == null ? new Base[0] : new Base[] {this.id}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1179159879: // issuer
          this.issuer = TypeConvertor.castToString(value); // StringType
          return value;
        case -369881636: // assigner
          this.assigner = TypeConvertor.castToString(value); // StringType
          return value;
        case 3355: // id
          this.id = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("issuer")) {
          this.issuer = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("assigner")) {
          this.assigner = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("id")) {
          this.id = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1179159879:  return getIssuerElement();
        case -369881636:  return getAssignerElement();
        case 3355:  return getIdElement();
        case 3575610:  return getTypeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1179159879: /*issuer*/ return new String[] {"string"};
        case -369881636: /*assigner*/ return new String[] {"string"};
        case 3355: /*id*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("issuer")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_IDENTIFIER.issuer");
        }
        else if (name.equals("assigner")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_IDENTIFIER.assigner");
        }
        else if (name.equals("id")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_IDENTIFIER.id");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_IDENTIFIER.type");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_IDENTIFIER";

  }

      public DV_IDENTIFIER copy() {
        DV_IDENTIFIER dst = new DV_IDENTIFIER();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_IDENTIFIER dst) {
        super.copyValues(dst);
        dst.issuer = issuer == null ? null : issuer.copy();
        dst.assigner = assigner == null ? null : assigner.copy();
        dst.id = id == null ? null : id.copy();
        dst.type = type == null ? null : type.copy();
      }

      protected DV_IDENTIFIER typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_IDENTIFIER))
          return false;
        DV_IDENTIFIER o = (DV_IDENTIFIER) other_;
        return compareDeep(issuer, o.issuer, true) && compareDeep(assigner, o.assigner, true) && compareDeep(id, o.id, true)
           && compareDeep(type, o.type, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_IDENTIFIER))
          return false;
        DV_IDENTIFIER o = (DV_IDENTIFIER) other_;
        return compareValues(issuer, o.issuer, true) && compareValues(assigner, o.assigner, true) && compareValues(id, o.id, true)
           && compareValues(type, o.type, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(issuer, assigner, id, type
          );
      }


}

