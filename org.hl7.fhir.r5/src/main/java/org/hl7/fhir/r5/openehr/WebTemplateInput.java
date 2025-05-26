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
@DatatypeDef(name="WebTemplateInput")
public class WebTemplateInput extends LogicalBase implements ICompositeType {

    /**
     * 
     */
    @Child(name = "suffix", type = {StringType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType suffix;

    /**
     * 
     */
    @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-input-type")
    protected CodeType type;

    /**
     * 
     */
    @Child(name = "defaultValue", type = {StringType.class, IntegerType.class, DecimalType.class, BooleanType.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected DataType defaultValue;

    /**
     * 
     */
    @Child(name = "terminology", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected CodeType terminology;

    /**
     * 
     */
    @Child(name = "validation", type = {WebTemplateInputValidation.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected WebTemplateInputValidation validation;

    /**
     * 
     */
    @Child(name = "list", type = {WebTemplateInputListItem.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected List<WebTemplateInputListItem> listList;

    /**
     * 
     */
    @Child(name = "listOpen", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected BooleanType listOpen;

    private static final long serialVersionUID = 1893964326L;

  /**
   * Constructor
   */
    public WebTemplateInput() {
      super();
    }

  /**
   * Constructor
   */
    public WebTemplateInput(String type, DataType defaultValue) {
      super();
      this.setType(type);
      this.setDefaultValue(defaultValue);
    }

    /**
     * @return {@link #suffix} (). This is the underlying object with id, value and extensions. The accessor "getSuffix" gives direct access to the value
     */
    public StringType getSuffixElement() { 
      if (this.suffix == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInput.suffix");
        else if (Configuration.doAutoCreate())
          this.suffix = new StringType(); // bb
      return this.suffix;
    }

    public boolean hasSuffixElement() { 
      return this.suffix != null && !this.suffix.isEmpty();
    }

    public boolean hasSuffix() { 
      return this.suffix != null && !this.suffix.isEmpty();
    }

    /**
     * @param value {@link #suffix} (). This is the underlying object with id, value and extensions. The accessor "getSuffix" gives direct access to the value
     */
    public WebTemplateInput setSuffixElement(StringType value) { 
      this.suffix = value;
      return this;
    }

    /**
     * @return 
     */
    public String getSuffix() { 
      return this.suffix == null ? null : this.suffix.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInput setSuffix(String value) { 
      if (Utilities.noString(value))
        this.suffix = null;
      else {
        if (this.suffix == null)
          this.suffix = new StringType();
        this.suffix.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #type} (). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public CodeType getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInput.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeType(); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public WebTemplateInput setTypeElement(CodeType value) { 
      this.type = value;
      return this;
    }

    /**
     * @return 
     */
    public String getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInput setType(String value) { 
        if (this.type == null)
          this.type = new CodeType();
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #defaultValue} ()
     */
    public DataType getDefaultValue() { 
      return this.defaultValue;
    }

    /**
     * @return {@link #defaultValue} ()
     */
    public StringType getDefaultValueStringType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new StringType();
      if (!(this.defaultValue instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (StringType) this.defaultValue;
    }

    public boolean hasDefaultValueStringType() {
        return this.defaultValue instanceof StringType;
    }

    /**
     * @return {@link #defaultValue} ()
     */
    public IntegerType getDefaultValueIntegerType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new IntegerType();
      if (!(this.defaultValue instanceof IntegerType))
        throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (IntegerType) this.defaultValue;
    }

    public boolean hasDefaultValueIntegerType() {
        return this.defaultValue instanceof IntegerType;
    }

    /**
     * @return {@link #defaultValue} ()
     */
    public DecimalType getDefaultValueDecimalType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new DecimalType();
      if (!(this.defaultValue instanceof DecimalType))
        throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (DecimalType) this.defaultValue;
    }

    public boolean hasDefaultValueDecimalType() {
        return this.defaultValue instanceof DecimalType;
    }

    /**
     * @return {@link #defaultValue} ()
     */
    public BooleanType getDefaultValueBooleanType() throws FHIRException { 
      if (this.defaultValue == null)
        this.defaultValue = new BooleanType();
      if (!(this.defaultValue instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.defaultValue.getClass().getName()+" was encountered");
      return (BooleanType) this.defaultValue;
    }

    public boolean hasDefaultValueBooleanType() {
        return this.defaultValue instanceof BooleanType;
    }

    public boolean hasDefaultValue() { 
      return this.defaultValue != null && !this.defaultValue.isEmpty();
    }

    /**
     * @param value {@link #defaultValue} ()
     */
    public WebTemplateInput setDefaultValue(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof IntegerType || value instanceof DecimalType || value instanceof BooleanType))
        throw new FHIRException("Not the right type for WebTemplateInput.defaultValue: "+value.fhirType());
      this.defaultValue = value;
      return this;
    }

    /**
     * @return {@link #terminology} (). This is the underlying object with id, value and extensions. The accessor "getTerminology" gives direct access to the value
     */
    public CodeType getTerminologyElement() { 
      if (this.terminology == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInput.terminology");
        else if (Configuration.doAutoCreate())
          this.terminology = new CodeType(); // bb
      return this.terminology;
    }

    public boolean hasTerminologyElement() { 
      return this.terminology != null && !this.terminology.isEmpty();
    }

    public boolean hasTerminology() { 
      return this.terminology != null && !this.terminology.isEmpty();
    }

    /**
     * @param value {@link #terminology} (). This is the underlying object with id, value and extensions. The accessor "getTerminology" gives direct access to the value
     */
    public WebTemplateInput setTerminologyElement(CodeType value) { 
      this.terminology = value;
      return this;
    }

    /**
     * @return 
     */
    public String getTerminology() { 
      return this.terminology == null ? null : this.terminology.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInput setTerminology(String value) { 
      if (Utilities.noString(value))
        this.terminology = null;
      else {
        if (this.terminology == null)
          this.terminology = new CodeType();
        this.terminology.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #validation} ()
     */
    public WebTemplateInputValidation getValidation() { 
      if (this.validation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInput.validation");
        else if (Configuration.doAutoCreate())
          this.validation = new WebTemplateInputValidation(); // cc
      return this.validation;
    }

    public boolean hasValidation() { 
      return this.validation != null && !this.validation.isEmpty();
    }

    /**
     * @param value {@link #validation} ()
     */
    public WebTemplateInput setValidation(WebTemplateInputValidation value) { 
      this.validation = value;
      return this;
    }

    /**
     * @return {@link #list} ()
     */
    public List<WebTemplateInputListItem> getListList() { 
      if (this.listList == null)
        this.listList = new ArrayList<WebTemplateInputListItem>();
      return this.listList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public WebTemplateInput setListList(List<WebTemplateInputListItem> theList) { 
      this.listList = theList;
      return this;
    }

    public boolean hasList() { 
      if (this.listList == null)
        return false;
      for (WebTemplateInputListItem item : this.listList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public WebTemplateInputListItem addList() { //3a
      WebTemplateInputListItem t = new WebTemplateInputListItem();
      if (this.listList == null)
        this.listList = new ArrayList<WebTemplateInputListItem>();
      this.listList.add(t);
      return t;
    }

    public WebTemplateInput addList(WebTemplateInputListItem t) { //3b
      if (t == null)
        return this;
      if (this.listList == null)
        this.listList = new ArrayList<WebTemplateInputListItem>();
      this.listList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #list}, creating it if it does not already exist {3}
     */
    public WebTemplateInputListItem getListFirstRep() { 
      if (getListList().isEmpty()) {
        addList();
      }
      return getListList().get(0);
    }

    /**
     * @return {@link #listOpen} (). This is the underlying object with id, value and extensions. The accessor "getListOpen" gives direct access to the value
     */
    public BooleanType getListOpenElement() { 
      if (this.listOpen == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInput.listOpen");
        else if (Configuration.doAutoCreate())
          this.listOpen = new BooleanType(); // bb
      return this.listOpen;
    }

    public boolean hasListOpenElement() { 
      return this.listOpen != null && !this.listOpen.isEmpty();
    }

    public boolean hasListOpen() { 
      return this.listOpen != null && !this.listOpen.isEmpty();
    }

    /**
     * @param value {@link #listOpen} (). This is the underlying object with id, value and extensions. The accessor "getListOpen" gives direct access to the value
     */
    public WebTemplateInput setListOpenElement(BooleanType value) { 
      this.listOpen = value;
      return this;
    }

    /**
     * @return 
     */
    public boolean getListOpen() { 
      return this.listOpen == null || this.listOpen.isEmpty() ? false : this.listOpen.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInput setListOpen(boolean value) { 
        if (this.listOpen == null)
          this.listOpen = new BooleanType();
        this.listOpen.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("suffix", "string", "", 0, 1, suffix));
        children.add(new Property("type", "code", "", 0, 1, type));
        children.add(new Property("defaultValue", "string|integer|decimal|boolean", "", 0, 1, defaultValue));
        children.add(new Property("terminology", "code", "", 0, 1, terminology));
        children.add(new Property("validation", "http://openehr.org/fhir/StructureDefinition/WebTemplateInputValidation", "", 0, 1, validation));
        children.add(new Property("list", "http://openehr.org/fhir/StructureDefinition/WebTemplateInputListItem", "", 0, java.lang.Integer.MAX_VALUE, listList));
        children.add(new Property("listOpen", "boolean", "", 0, 1, listOpen));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -891422895: /*suffix*/  return new Property("suffix", "string", "", 0, 1, suffix);
        case 3575610: /*type*/  return new Property("type", "code", "", 0, 1, type);
        case -659125328: /*defaultValue*/  return new Property("defaultValue", "string|integer|decimal|boolean", "", 0, 1, defaultValue);
        case -1905884493: /*terminology*/  return new Property("terminology", "code", "", 0, 1, terminology);
        case -43562887: /*validation*/  return new Property("validation", "http://openehr.org/fhir/StructureDefinition/WebTemplateInputValidation", "", 0, 1, validation);
        case 3322014: /*list*/  return new Property("list", "http://openehr.org/fhir/StructureDefinition/WebTemplateInputListItem", "", 0, java.lang.Integer.MAX_VALUE, listList);
        case 1345506312: /*listOpen*/  return new Property("listOpen", "boolean", "", 0, 1, listOpen);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -891422895: /*suffix*/ return this.suffix == null ? new Base[0] : new Base[] {this.suffix}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeType
        case -659125328: /*defaultValue*/ return this.defaultValue == null ? new Base[0] : new Base[] {this.defaultValue}; // DataType
        case -1905884493: /*terminology*/ return this.terminology == null ? new Base[0] : new Base[] {this.terminology}; // CodeType
        case -43562887: /*validation*/ return this.validation == null ? new Base[0] : new Base[] {this.validation}; // WebTemplateInputValidation
        case 3322014: /*list*/ return this.listList == null ? new Base[0] : this.listList.toArray(new Base[this.listList.size()]); // WebTemplateInputListItem
        case 1345506312: /*listOpen*/ return this.listOpen == null ? new Base[0] : new Base[] {this.listOpen}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -891422895: // suffix
          this.suffix = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -659125328: // defaultValue
          this.defaultValue = TypeConvertor.castToType(value); // DataType
          return value;
        case -1905884493: // terminology
          this.terminology = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -43562887: // validation
          this.validation = (WebTemplateInputValidation) value; // WebTemplateInputValidation
          return value;
        case 3322014: // list
          this.getListList().add((WebTemplateInputListItem) value); // WebTemplateInputListItem
          return value;
        case 1345506312: // listOpen
          this.listOpen = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("suffix")) {
          this.suffix = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("defaultValue")) {
          this.defaultValue = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("terminology")) {
          this.terminology = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("validation")) {
          this.validation = (WebTemplateInputValidation) value; // WebTemplateInputValidation
        } else if (name.equals("list")) {
          this.getListList().add((WebTemplateInputListItem) value); // WebTemplateInputListItem
        } else if (name.equals("listOpen")) {
          this.listOpen = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -891422895:  return getSuffixElement();
        case 3575610:  return getTypeElement();
        case -659125328:  return getDefaultValue();
        case -1905884493:  return getTerminologyElement();
        case -43562887:  return getValidation();
        case 3322014:  return addList(); 
        case 1345506312:  return getListOpenElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -891422895: /*suffix*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"code"};
        case -659125328: /*defaultValue*/ return new String[] {"string", "integer", "decimal", "boolean"};
        case -1905884493: /*terminology*/ return new String[] {"code"};
        case -43562887: /*validation*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/WebTemplateInputValidation"};
        case 3322014: /*list*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/WebTemplateInputListItem"};
        case 1345506312: /*listOpen*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("suffix")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInput.suffix");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInput.type");
        }
        else if (name.equals("defaultValue")) {
          this.defaultValue = new StringType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValue")) {
          this.defaultValue = new IntegerType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValue")) {
          this.defaultValue = new DecimalType();
          return this.defaultValue;
        }
        else if (name.equals("defaultValue")) {
          this.defaultValue = new BooleanType();
          return this.defaultValue;
        }
        else if (name.equals("terminology")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInput.terminology");
        }
        else if (name.equals("validation")) {
          this.validation = new WebTemplateInputValidation();
          return this.validation;
        }
        else if (name.equals("list")) {
          return addList();
        }
        else if (name.equals("listOpen")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInput.listOpen");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "WebTemplateInput";

  }

      public WebTemplateInput copy() {
        WebTemplateInput dst = new WebTemplateInput();
        copyValues(dst);
        return dst;
      }

      public void copyValues(WebTemplateInput dst) {
        super.copyValues(dst);
        dst.suffix = suffix == null ? null : suffix.copy();
        dst.type = type == null ? null : type.copy();
        dst.defaultValue = defaultValue == null ? null : defaultValue.copy();
        dst.terminology = terminology == null ? null : terminology.copy();
        dst.validation = validation == null ? null : validation.copy();
        if (listList != null) {
          dst.listList = new ArrayList<WebTemplateInputListItem>();
          for (WebTemplateInputListItem i : listList)
            dst.listList.add(i.copy());
        };
        dst.listOpen = listOpen == null ? null : listOpen.copy();
      }

      protected WebTemplateInput typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof WebTemplateInput))
          return false;
        WebTemplateInput o = (WebTemplateInput) other_;
        return compareDeep(suffix, o.suffix, true) && compareDeep(type, o.type, true) && compareDeep(defaultValue, o.defaultValue, true)
           && compareDeep(terminology, o.terminology, true) && compareDeep(validation, o.validation, true)
           && compareDeep(listList, o.listList, true) && compareDeep(listOpen, o.listOpen, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof WebTemplateInput))
          return false;
        WebTemplateInput o = (WebTemplateInput) other_;
        return compareValues(suffix, o.suffix, true) && compareValues(type, o.type, true) && compareValues(terminology, o.terminology, true)
           && compareValues(listOpen, o.listOpen, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(suffix, type, defaultValue
          , terminology, validation, listList, listOpen);
      }


}

