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
 * 
 */
@DatatypeDef(name="Annotations")
public class Annotations extends LogicalBase implements ICompositeType {

    /**
     * 
     */
    @Child(name = "comment", type = {StringType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType comment;

    /**
     * 
     */
    @Child(name = "fhir_mapping", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType fhir_mapping;

    /**
     * 
     */
    @Child(name = "vset_description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType vset_description;

    /**
     * 
     */
    @Child(name = "hl7v2_mapping", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType hl7v2_mapping;

    /**
     * 
     */
    @Child(name = "visibleInView", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType visibleInView;

    private static final long serialVersionUID = 1193300325L;

  /**
   * Constructor
   */
    public Annotations() {
      super();
    }

    /**
     * @return {@link #comment} (). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public StringType getCommentElement() { 
      if (this.comment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Annotations.comment");
        else if (Configuration.doAutoCreate())
          this.comment = new StringType(); // bb
      return this.comment;
    }

    public boolean hasCommentElement() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    public boolean hasComment() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    /**
     * @param value {@link #comment} (). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public Annotations setCommentElement(StringType value) { 
      this.comment = value;
      return this;
    }

    /**
     * @return 
     */
    public String getComment() { 
      return this.comment == null ? null : this.comment.getValue();
    }

    /**
     * @param value 
     */
    public Annotations setComment(String value) { 
      if (Utilities.noString(value))
        this.comment = null;
      else {
        if (this.comment == null)
          this.comment = new StringType();
        this.comment.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #fhir_mapping} (). This is the underlying object with id, value and extensions. The accessor "getFhir_mapping" gives direct access to the value
     */
    public StringType getFhir_mappingElement() { 
      if (this.fhir_mapping == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Annotations.fhir_mapping");
        else if (Configuration.doAutoCreate())
          this.fhir_mapping = new StringType(); // bb
      return this.fhir_mapping;
    }

    public boolean hasFhir_mappingElement() { 
      return this.fhir_mapping != null && !this.fhir_mapping.isEmpty();
    }

    public boolean hasFhir_mapping() { 
      return this.fhir_mapping != null && !this.fhir_mapping.isEmpty();
    }

    /**
     * @param value {@link #fhir_mapping} (). This is the underlying object with id, value and extensions. The accessor "getFhir_mapping" gives direct access to the value
     */
    public Annotations setFhir_mappingElement(StringType value) { 
      this.fhir_mapping = value;
      return this;
    }

    /**
     * @return 
     */
    public String getFhir_mapping() { 
      return this.fhir_mapping == null ? null : this.fhir_mapping.getValue();
    }

    /**
     * @param value 
     */
    public Annotations setFhir_mapping(String value) { 
      if (Utilities.noString(value))
        this.fhir_mapping = null;
      else {
        if (this.fhir_mapping == null)
          this.fhir_mapping = new StringType();
        this.fhir_mapping.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #vset_description} (). This is the underlying object with id, value and extensions. The accessor "getVset_description" gives direct access to the value
     */
    public StringType getVset_descriptionElement() { 
      if (this.vset_description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Annotations.vset_description");
        else if (Configuration.doAutoCreate())
          this.vset_description = new StringType(); // bb
      return this.vset_description;
    }

    public boolean hasVset_descriptionElement() { 
      return this.vset_description != null && !this.vset_description.isEmpty();
    }

    public boolean hasVset_description() { 
      return this.vset_description != null && !this.vset_description.isEmpty();
    }

    /**
     * @param value {@link #vset_description} (). This is the underlying object with id, value and extensions. The accessor "getVset_description" gives direct access to the value
     */
    public Annotations setVset_descriptionElement(StringType value) { 
      this.vset_description = value;
      return this;
    }

    /**
     * @return 
     */
    public String getVset_description() { 
      return this.vset_description == null ? null : this.vset_description.getValue();
    }

    /**
     * @param value 
     */
    public Annotations setVset_description(String value) { 
      if (Utilities.noString(value))
        this.vset_description = null;
      else {
        if (this.vset_description == null)
          this.vset_description = new StringType();
        this.vset_description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #hl7v2_mapping} (). This is the underlying object with id, value and extensions. The accessor "getHl7v2_mapping" gives direct access to the value
     */
    public StringType getHl7v2_mappingElement() { 
      if (this.hl7v2_mapping == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Annotations.hl7v2_mapping");
        else if (Configuration.doAutoCreate())
          this.hl7v2_mapping = new StringType(); // bb
      return this.hl7v2_mapping;
    }

    public boolean hasHl7v2_mappingElement() { 
      return this.hl7v2_mapping != null && !this.hl7v2_mapping.isEmpty();
    }

    public boolean hasHl7v2_mapping() { 
      return this.hl7v2_mapping != null && !this.hl7v2_mapping.isEmpty();
    }

    /**
     * @param value {@link #hl7v2_mapping} (). This is the underlying object with id, value and extensions. The accessor "getHl7v2_mapping" gives direct access to the value
     */
    public Annotations setHl7v2_mappingElement(StringType value) { 
      this.hl7v2_mapping = value;
      return this;
    }

    /**
     * @return 
     */
    public String getHl7v2_mapping() { 
      return this.hl7v2_mapping == null ? null : this.hl7v2_mapping.getValue();
    }

    /**
     * @param value 
     */
    public Annotations setHl7v2_mapping(String value) { 
      if (Utilities.noString(value))
        this.hl7v2_mapping = null;
      else {
        if (this.hl7v2_mapping == null)
          this.hl7v2_mapping = new StringType();
        this.hl7v2_mapping.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #visibleInView} (). This is the underlying object with id, value and extensions. The accessor "getVisibleInView" gives direct access to the value
     */
    public StringType getVisibleInViewElement() { 
      if (this.visibleInView == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Annotations.visibleInView");
        else if (Configuration.doAutoCreate())
          this.visibleInView = new StringType(); // bb
      return this.visibleInView;
    }

    public boolean hasVisibleInViewElement() { 
      return this.visibleInView != null && !this.visibleInView.isEmpty();
    }

    public boolean hasVisibleInView() { 
      return this.visibleInView != null && !this.visibleInView.isEmpty();
    }

    /**
     * @param value {@link #visibleInView} (). This is the underlying object with id, value and extensions. The accessor "getVisibleInView" gives direct access to the value
     */
    public Annotations setVisibleInViewElement(StringType value) { 
      this.visibleInView = value;
      return this;
    }

    /**
     * @return 
     */
    public String getVisibleInView() { 
      return this.visibleInView == null ? null : this.visibleInView.getValue();
    }

    /**
     * @param value 
     */
    public Annotations setVisibleInView(String value) { 
      if (Utilities.noString(value))
        this.visibleInView = null;
      else {
        if (this.visibleInView == null)
          this.visibleInView = new StringType();
        this.visibleInView.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("comment", "string", "", 0, 1, comment));
        children.add(new Property("fhir_mapping", "string", "", 0, 1, fhir_mapping));
        children.add(new Property("vset_description", "string", "", 0, 1, vset_description));
        children.add(new Property("hl7v2_mapping", "string", "", 0, 1, hl7v2_mapping));
        children.add(new Property("visibleInView", "string", "", 0, 1, visibleInView));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 950398559: /*comment*/  return new Property("comment", "string", "", 0, 1, comment);
        case -2067458566: /*fhir_mapping*/  return new Property("fhir_mapping", "string", "", 0, 1, fhir_mapping);
        case -87138199: /*vset_description*/  return new Property("vset_description", "string", "", 0, 1, vset_description);
        case 1862427134: /*hl7v2_mapping*/  return new Property("hl7v2_mapping", "string", "", 0, 1, hl7v2_mapping);
        case 602726524: /*visibleInView*/  return new Property("visibleInView", "string", "", 0, 1, visibleInView);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // StringType
        case -2067458566: /*fhir_mapping*/ return this.fhir_mapping == null ? new Base[0] : new Base[] {this.fhir_mapping}; // StringType
        case -87138199: /*vset_description*/ return this.vset_description == null ? new Base[0] : new Base[] {this.vset_description}; // StringType
        case 1862427134: /*hl7v2_mapping*/ return this.hl7v2_mapping == null ? new Base[0] : new Base[] {this.hl7v2_mapping}; // StringType
        case 602726524: /*visibleInView*/ return this.visibleInView == null ? new Base[0] : new Base[] {this.visibleInView}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 950398559: // comment
          this.comment = TypeConvertor.castToString(value); // StringType
          return value;
        case -2067458566: // fhir_mapping
          this.fhir_mapping = TypeConvertor.castToString(value); // StringType
          return value;
        case -87138199: // vset_description
          this.vset_description = TypeConvertor.castToString(value); // StringType
          return value;
        case 1862427134: // hl7v2_mapping
          this.hl7v2_mapping = TypeConvertor.castToString(value); // StringType
          return value;
        case 602726524: // visibleInView
          this.visibleInView = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("comment")) {
          this.comment = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("fhir_mapping")) {
          this.fhir_mapping = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("vset_description")) {
          this.vset_description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("hl7v2_mapping")) {
          this.hl7v2_mapping = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("visibleInView")) {
          this.visibleInView = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 950398559:  return getCommentElement();
        case -2067458566:  return getFhir_mappingElement();
        case -87138199:  return getVset_descriptionElement();
        case 1862427134:  return getHl7v2_mappingElement();
        case 602726524:  return getVisibleInViewElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 950398559: /*comment*/ return new String[] {"string"};
        case -2067458566: /*fhir_mapping*/ return new String[] {"string"};
        case -87138199: /*vset_description*/ return new String[] {"string"};
        case 1862427134: /*hl7v2_mapping*/ return new String[] {"string"};
        case 602726524: /*visibleInView*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a singleton property Annotations.comment");
        }
        else if (name.equals("fhir_mapping")) {
          throw new FHIRException("Cannot call addChild on a singleton property Annotations.fhir_mapping");
        }
        else if (name.equals("vset_description")) {
          throw new FHIRException("Cannot call addChild on a singleton property Annotations.vset_description");
        }
        else if (name.equals("hl7v2_mapping")) {
          throw new FHIRException("Cannot call addChild on a singleton property Annotations.hl7v2_mapping");
        }
        else if (name.equals("visibleInView")) {
          throw new FHIRException("Cannot call addChild on a singleton property Annotations.visibleInView");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Annotations";

  }

      public Annotations copy() {
        Annotations dst = new Annotations();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Annotations dst) {
        super.copyValues(dst);
        dst.comment = comment == null ? null : comment.copy();
        dst.fhir_mapping = fhir_mapping == null ? null : fhir_mapping.copy();
        dst.vset_description = vset_description == null ? null : vset_description.copy();
        dst.hl7v2_mapping = hl7v2_mapping == null ? null : hl7v2_mapping.copy();
        dst.visibleInView = visibleInView == null ? null : visibleInView.copy();
      }

      protected Annotations typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Annotations))
          return false;
        Annotations o = (Annotations) other_;
        return compareDeep(comment, o.comment, true) && compareDeep(fhir_mapping, o.fhir_mapping, true)
           && compareDeep(vset_description, o.vset_description, true) && compareDeep(hl7v2_mapping, o.hl7v2_mapping, true)
           && compareDeep(visibleInView, o.visibleInView, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Annotations))
          return false;
        Annotations o = (Annotations) other_;
        return compareValues(comment, o.comment, true) && compareValues(fhir_mapping, o.fhir_mapping, true)
           && compareValues(vset_description, o.vset_description, true) && compareValues(hl7v2_mapping, o.hl7v2_mapping, true)
           && compareValues(visibleInView, o.visibleInView, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(comment, fhir_mapping, vset_description
          , hl7v2_mapping, visibleInView);
      }


}

