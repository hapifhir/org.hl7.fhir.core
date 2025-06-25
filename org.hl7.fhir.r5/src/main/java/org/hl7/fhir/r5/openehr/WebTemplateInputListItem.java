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
@DatatypeDef(name="WebTemplateInputListItem")
public class WebTemplateInputListItem extends LogicalBase implements ICompositeType {

    /**
     * 
     */
    @Child(name = "value", type = {CodeType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="at-code of the specified item", formalDefinition="" )
    protected CodeType value;

    /**
     * 
     */
    @Child(name = "label", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="label of the item in the default language", formalDefinition="" )
    protected StringType label;

    /**
     * 
     */
    @Child(name = "ordinal", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType ordinal;

    /**
     * 
     */
    @Child(name = "localizedLabels", type = {TranslatedString.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="labels in all specified languages", formalDefinition="" )
    protected List<TranslatedString> localizedLabelsList;

    /**
     * 
     */
    @Child(name = "localizedDescriptions", type = {TranslatedString.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected List<TranslatedString> localizedDescriptionsList;

    /**
     * 
     */
    @Child(name = "currentStates", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType currentStates;

    /**
     * 
     */
    @Child(name = "range", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType range;

    /**
     * 
     */
    @Child(name = "precision", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected StringType precision;

    /**
     * 
     */
    @Child(name = "termBindings", type = {WebTemplateTermBinding.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="todo", formalDefinition="" )
    protected List<WebTemplateTermBinding> termBindingsList;

    private static final long serialVersionUID = 598072749L;

  /**
   * Constructor
   */
    public WebTemplateInputListItem() {
      super();
    }

  /**
   * Constructor
   */
    public WebTemplateInputListItem(String value) {
      super();
      this.setValue(value);
    }

    /**
     * @return {@link #value} (). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public CodeType getValueElement() { 
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputListItem.value");
        else if (Configuration.doAutoCreate())
          this.value = new CodeType(); // bb
      return this.value;
    }

    public boolean hasValueElement() { 
      return this.value != null && !this.value.isEmpty();
    }

    public boolean hasValue() { 
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public WebTemplateInputListItem setValueElement(CodeType value) { 
      this.value = value;
      return this;
    }

    /**
     * @return 
     */
    public String getValue() { 
      return this.value == null ? null : this.value.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInputListItem setValue(String value) { 
        if (this.value == null)
          this.value = new CodeType();
        this.value.setValue(value);
      return this;
    }

    /**
     * @return {@link #label} (). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
     */
    public StringType getLabelElement() { 
      if (this.label == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputListItem.label");
        else if (Configuration.doAutoCreate())
          this.label = new StringType(); // bb
      return this.label;
    }

    public boolean hasLabelElement() { 
      return this.label != null && !this.label.isEmpty();
    }

    public boolean hasLabel() { 
      return this.label != null && !this.label.isEmpty();
    }

    /**
     * @param value {@link #label} (). This is the underlying object with id, value and extensions. The accessor "getLabel" gives direct access to the value
     */
    public WebTemplateInputListItem setLabelElement(StringType value) { 
      this.label = value;
      return this;
    }

    /**
     * @return 
     */
    public String getLabel() { 
      return this.label == null ? null : this.label.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInputListItem setLabel(String value) { 
      if (Utilities.noString(value))
        this.label = null;
      else {
        if (this.label == null)
          this.label = new StringType();
        this.label.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #ordinal} (). This is the underlying object with id, value and extensions. The accessor "getOrdinal" gives direct access to the value
     */
    public StringType getOrdinalElement() { 
      if (this.ordinal == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputListItem.ordinal");
        else if (Configuration.doAutoCreate())
          this.ordinal = new StringType(); // bb
      return this.ordinal;
    }

    public boolean hasOrdinalElement() { 
      return this.ordinal != null && !this.ordinal.isEmpty();
    }

    public boolean hasOrdinal() { 
      return this.ordinal != null && !this.ordinal.isEmpty();
    }

    /**
     * @param value {@link #ordinal} (). This is the underlying object with id, value and extensions. The accessor "getOrdinal" gives direct access to the value
     */
    public WebTemplateInputListItem setOrdinalElement(StringType value) { 
      this.ordinal = value;
      return this;
    }

    /**
     * @return 
     */
    public String getOrdinal() { 
      return this.ordinal == null ? null : this.ordinal.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInputListItem setOrdinal(String value) { 
      if (Utilities.noString(value))
        this.ordinal = null;
      else {
        if (this.ordinal == null)
          this.ordinal = new StringType();
        this.ordinal.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #localizedLabels} ()
     */
    public List<TranslatedString> getLocalizedLabelsList() { 
      if (this.localizedLabelsList == null)
        this.localizedLabelsList = new ArrayList<TranslatedString>();
      return this.localizedLabelsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public WebTemplateInputListItem setLocalizedLabelsList(List<TranslatedString> theLocalizedLabels) { 
      this.localizedLabelsList = theLocalizedLabels;
      return this;
    }

    public boolean hasLocalizedLabels() { 
      if (this.localizedLabelsList == null)
        return false;
      for (TranslatedString item : this.localizedLabelsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TranslatedString addLocalizedLabels() { //3a
      TranslatedString t = new TranslatedString();
      if (this.localizedLabelsList == null)
        this.localizedLabelsList = new ArrayList<TranslatedString>();
      this.localizedLabelsList.add(t);
      return t;
    }

    public WebTemplateInputListItem addLocalizedLabels(TranslatedString t) { //3b
      if (t == null)
        return this;
      if (this.localizedLabelsList == null)
        this.localizedLabelsList = new ArrayList<TranslatedString>();
      this.localizedLabelsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #localizedLabels}, creating it if it does not already exist {3}
     */
    public TranslatedString getLocalizedLabelsFirstRep() { 
      if (getLocalizedLabelsList().isEmpty()) {
        addLocalizedLabels();
      }
      return getLocalizedLabelsList().get(0);
    }

    /**
     * @return {@link #localizedDescriptions} ()
     */
    public List<TranslatedString> getLocalizedDescriptionsList() { 
      if (this.localizedDescriptionsList == null)
        this.localizedDescriptionsList = new ArrayList<TranslatedString>();
      return this.localizedDescriptionsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public WebTemplateInputListItem setLocalizedDescriptionsList(List<TranslatedString> theLocalizedDescriptions) { 
      this.localizedDescriptionsList = theLocalizedDescriptions;
      return this;
    }

    public boolean hasLocalizedDescriptions() { 
      if (this.localizedDescriptionsList == null)
        return false;
      for (TranslatedString item : this.localizedDescriptionsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TranslatedString addLocalizedDescriptions() { //3a
      TranslatedString t = new TranslatedString();
      if (this.localizedDescriptionsList == null)
        this.localizedDescriptionsList = new ArrayList<TranslatedString>();
      this.localizedDescriptionsList.add(t);
      return t;
    }

    public WebTemplateInputListItem addLocalizedDescriptions(TranslatedString t) { //3b
      if (t == null)
        return this;
      if (this.localizedDescriptionsList == null)
        this.localizedDescriptionsList = new ArrayList<TranslatedString>();
      this.localizedDescriptionsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #localizedDescriptions}, creating it if it does not already exist {3}
     */
    public TranslatedString getLocalizedDescriptionsFirstRep() { 
      if (getLocalizedDescriptionsList().isEmpty()) {
        addLocalizedDescriptions();
      }
      return getLocalizedDescriptionsList().get(0);
    }

    /**
     * @return {@link #currentStates} (). This is the underlying object with id, value and extensions. The accessor "getCurrentStates" gives direct access to the value
     */
    public StringType getCurrentStatesElement() { 
      if (this.currentStates == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputListItem.currentStates");
        else if (Configuration.doAutoCreate())
          this.currentStates = new StringType(); // bb
      return this.currentStates;
    }

    public boolean hasCurrentStatesElement() { 
      return this.currentStates != null && !this.currentStates.isEmpty();
    }

    public boolean hasCurrentStates() { 
      return this.currentStates != null && !this.currentStates.isEmpty();
    }

    /**
     * @param value {@link #currentStates} (). This is the underlying object with id, value and extensions. The accessor "getCurrentStates" gives direct access to the value
     */
    public WebTemplateInputListItem setCurrentStatesElement(StringType value) { 
      this.currentStates = value;
      return this;
    }

    /**
     * @return 
     */
    public String getCurrentStates() { 
      return this.currentStates == null ? null : this.currentStates.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInputListItem setCurrentStates(String value) { 
      if (Utilities.noString(value))
        this.currentStates = null;
      else {
        if (this.currentStates == null)
          this.currentStates = new StringType();
        this.currentStates.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #range} (). This is the underlying object with id, value and extensions. The accessor "getRange" gives direct access to the value
     */
    public StringType getRangeElement() { 
      if (this.range == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputListItem.range");
        else if (Configuration.doAutoCreate())
          this.range = new StringType(); // bb
      return this.range;
    }

    public boolean hasRangeElement() { 
      return this.range != null && !this.range.isEmpty();
    }

    public boolean hasRange() { 
      return this.range != null && !this.range.isEmpty();
    }

    /**
     * @param value {@link #range} (). This is the underlying object with id, value and extensions. The accessor "getRange" gives direct access to the value
     */
    public WebTemplateInputListItem setRangeElement(StringType value) { 
      this.range = value;
      return this;
    }

    /**
     * @return 
     */
    public String getRange() { 
      return this.range == null ? null : this.range.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInputListItem setRange(String value) { 
      if (Utilities.noString(value))
        this.range = null;
      else {
        if (this.range == null)
          this.range = new StringType();
        this.range.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #precision} (). This is the underlying object with id, value and extensions. The accessor "getPrecision" gives direct access to the value
     */
    public StringType getPrecisionElement() { 
      if (this.precision == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplateInputListItem.precision");
        else if (Configuration.doAutoCreate())
          this.precision = new StringType(); // bb
      return this.precision;
    }

    public boolean hasPrecisionElement() { 
      return this.precision != null && !this.precision.isEmpty();
    }

    public boolean hasPrecision() { 
      return this.precision != null && !this.precision.isEmpty();
    }

    /**
     * @param value {@link #precision} (). This is the underlying object with id, value and extensions. The accessor "getPrecision" gives direct access to the value
     */
    public WebTemplateInputListItem setPrecisionElement(StringType value) { 
      this.precision = value;
      return this;
    }

    /**
     * @return 
     */
    public String getPrecision() { 
      return this.precision == null ? null : this.precision.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplateInputListItem setPrecision(String value) { 
      if (Utilities.noString(value))
        this.precision = null;
      else {
        if (this.precision == null)
          this.precision = new StringType();
        this.precision.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #termBindings} ()
     */
    public List<WebTemplateTermBinding> getTermBindingsList() { 
      if (this.termBindingsList == null)
        this.termBindingsList = new ArrayList<WebTemplateTermBinding>();
      return this.termBindingsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public WebTemplateInputListItem setTermBindingsList(List<WebTemplateTermBinding> theTermBindings) { 
      this.termBindingsList = theTermBindings;
      return this;
    }

    public boolean hasTermBindings() { 
      if (this.termBindingsList == null)
        return false;
      for (WebTemplateTermBinding item : this.termBindingsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public WebTemplateTermBinding addTermBindings() { //3a
      WebTemplateTermBinding t = new WebTemplateTermBinding();
      if (this.termBindingsList == null)
        this.termBindingsList = new ArrayList<WebTemplateTermBinding>();
      this.termBindingsList.add(t);
      return t;
    }

    public WebTemplateInputListItem addTermBindings(WebTemplateTermBinding t) { //3b
      if (t == null)
        return this;
      if (this.termBindingsList == null)
        this.termBindingsList = new ArrayList<WebTemplateTermBinding>();
      this.termBindingsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #termBindings}, creating it if it does not already exist {3}
     */
    public WebTemplateTermBinding getTermBindingsFirstRep() { 
      if (getTermBindingsList().isEmpty()) {
        addTermBindings();
      }
      return getTermBindingsList().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("value", "code", "", 0, 1, value));
        children.add(new Property("label", "string", "", 0, 1, label));
        children.add(new Property("ordinal", "string", "", 0, 1, ordinal));
        children.add(new Property("localizedLabels", "http://openehr.org/fhir/StructureDefinition/TranslatedString", "", 0, java.lang.Integer.MAX_VALUE, localizedLabelsList));
        children.add(new Property("localizedDescriptions", "http://openehr.org/fhir/StructureDefinition/TranslatedString", "", 0, java.lang.Integer.MAX_VALUE, localizedDescriptionsList));
        children.add(new Property("currentStates", "string", "", 0, 1, currentStates));
        children.add(new Property("range", "string", "", 0, 1, range));
        children.add(new Property("precision", "string", "", 0, 1, precision));
        children.add(new Property("termBindings", "http://openehr.org/fhir/StructureDefinition/WebTemplateTermBinding", "", 0, java.lang.Integer.MAX_VALUE, termBindingsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 111972721: /*value*/  return new Property("value", "code", "", 0, 1, value);
        case 102727412: /*label*/  return new Property("label", "string", "", 0, 1, label);
        case -1206994319: /*ordinal*/  return new Property("ordinal", "string", "", 0, 1, ordinal);
        case -689354918: /*localizedLabels*/  return new Property("localizedLabels", "http://openehr.org/fhir/StructureDefinition/TranslatedString", "", 0, java.lang.Integer.MAX_VALUE, localizedLabelsList);
        case 31568658: /*localizedDescriptions*/  return new Property("localizedDescriptions", "http://openehr.org/fhir/StructureDefinition/TranslatedString", "", 0, java.lang.Integer.MAX_VALUE, localizedDescriptionsList);
        case -2052146981: /*currentStates*/  return new Property("currentStates", "string", "", 0, 1, currentStates);
        case 108280125: /*range*/  return new Property("range", "string", "", 0, 1, range);
        case -1376177026: /*precision*/  return new Property("precision", "string", "", 0, 1, precision);
        case 1618255642: /*termBindings*/  return new Property("termBindings", "http://openehr.org/fhir/StructureDefinition/WebTemplateTermBinding", "", 0, java.lang.Integer.MAX_VALUE, termBindingsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // CodeType
        case 102727412: /*label*/ return this.label == null ? new Base[0] : new Base[] {this.label}; // StringType
        case -1206994319: /*ordinal*/ return this.ordinal == null ? new Base[0] : new Base[] {this.ordinal}; // StringType
        case -689354918: /*localizedLabels*/ return this.localizedLabelsList == null ? new Base[0] : this.localizedLabelsList.toArray(new Base[this.localizedLabelsList.size()]); // TranslatedString
        case 31568658: /*localizedDescriptions*/ return this.localizedDescriptionsList == null ? new Base[0] : this.localizedDescriptionsList.toArray(new Base[this.localizedDescriptionsList.size()]); // TranslatedString
        case -2052146981: /*currentStates*/ return this.currentStates == null ? new Base[0] : new Base[] {this.currentStates}; // StringType
        case 108280125: /*range*/ return this.range == null ? new Base[0] : new Base[] {this.range}; // StringType
        case -1376177026: /*precision*/ return this.precision == null ? new Base[0] : new Base[] {this.precision}; // StringType
        case 1618255642: /*termBindings*/ return this.termBindingsList == null ? new Base[0] : this.termBindingsList.toArray(new Base[this.termBindingsList.size()]); // WebTemplateTermBinding
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToCode(value); // CodeType
          return value;
        case 102727412: // label
          this.label = TypeConvertor.castToString(value); // StringType
          return value;
        case -1206994319: // ordinal
          this.ordinal = TypeConvertor.castToString(value); // StringType
          return value;
        case -689354918: // localizedLabels
          this.getLocalizedLabelsList().add((TranslatedString) value); // TranslatedString
          return value;
        case 31568658: // localizedDescriptions
          this.getLocalizedDescriptionsList().add((TranslatedString) value); // TranslatedString
          return value;
        case -2052146981: // currentStates
          this.currentStates = TypeConvertor.castToString(value); // StringType
          return value;
        case 108280125: // range
          this.range = TypeConvertor.castToString(value); // StringType
          return value;
        case -1376177026: // precision
          this.precision = TypeConvertor.castToString(value); // StringType
          return value;
        case 1618255642: // termBindings
          this.getTermBindingsList().add((WebTemplateTermBinding) value); // WebTemplateTermBinding
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value")) {
          this.value = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("label")) {
          this.label = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("ordinal")) {
          this.ordinal = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("localizedLabels")) {
          this.getLocalizedLabelsList().add((TranslatedString) value); // TranslatedString
        } else if (name.equals("localizedDescriptions")) {
          this.getLocalizedDescriptionsList().add((TranslatedString) value); // TranslatedString
        } else if (name.equals("currentStates")) {
          this.currentStates = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("range")) {
          this.range = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("precision")) {
          this.precision = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("termBindings")) {
          this.getTermBindingsList().add((WebTemplateTermBinding) value); // WebTemplateTermBinding
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721:  return getValueElement();
        case 102727412:  return getLabelElement();
        case -1206994319:  return getOrdinalElement();
        case -689354918:  return addLocalizedLabels(); 
        case 31568658:  return addLocalizedDescriptions(); 
        case -2052146981:  return getCurrentStatesElement();
        case 108280125:  return getRangeElement();
        case -1376177026:  return getPrecisionElement();
        case 1618255642:  return addTermBindings(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"code"};
        case 102727412: /*label*/ return new String[] {"string"};
        case -1206994319: /*ordinal*/ return new String[] {"string"};
        case -689354918: /*localizedLabels*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/TranslatedString"};
        case 31568658: /*localizedDescriptions*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/TranslatedString"};
        case -2052146981: /*currentStates*/ return new String[] {"string"};
        case 108280125: /*range*/ return new String[] {"string"};
        case -1376177026: /*precision*/ return new String[] {"string"};
        case 1618255642: /*termBindings*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/WebTemplateTermBinding"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInputListItem.value");
        }
        else if (name.equals("label")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInputListItem.label");
        }
        else if (name.equals("ordinal")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInputListItem.ordinal");
        }
        else if (name.equals("localizedLabels")) {
          return addLocalizedLabels();
        }
        else if (name.equals("localizedDescriptions")) {
          return addLocalizedDescriptions();
        }
        else if (name.equals("currentStates")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInputListItem.currentStates");
        }
        else if (name.equals("range")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInputListItem.range");
        }
        else if (name.equals("precision")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplateInputListItem.precision");
        }
        else if (name.equals("termBindings")) {
          return addTermBindings();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "WebTemplateInputListItem";

  }

      public WebTemplateInputListItem copy() {
        WebTemplateInputListItem dst = new WebTemplateInputListItem();
        copyValues(dst);
        return dst;
      }

      public void copyValues(WebTemplateInputListItem dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
        dst.label = label == null ? null : label.copy();
        dst.ordinal = ordinal == null ? null : ordinal.copy();
        if (localizedLabelsList != null) {
          dst.localizedLabelsList = new ArrayList<TranslatedString>();
          for (TranslatedString i : localizedLabelsList)
            dst.localizedLabelsList.add(i.copy());
        };
        if (localizedDescriptionsList != null) {
          dst.localizedDescriptionsList = new ArrayList<TranslatedString>();
          for (TranslatedString i : localizedDescriptionsList)
            dst.localizedDescriptionsList.add(i.copy());
        };
        dst.currentStates = currentStates == null ? null : currentStates.copy();
        dst.range = range == null ? null : range.copy();
        dst.precision = precision == null ? null : precision.copy();
        if (termBindingsList != null) {
          dst.termBindingsList = new ArrayList<WebTemplateTermBinding>();
          for (WebTemplateTermBinding i : termBindingsList)
            dst.termBindingsList.add(i.copy());
        };
      }

      protected WebTemplateInputListItem typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof WebTemplateInputListItem))
          return false;
        WebTemplateInputListItem o = (WebTemplateInputListItem) other_;
        return compareDeep(value, o.value, true) && compareDeep(label, o.label, true) && compareDeep(ordinal, o.ordinal, true)
           && compareDeep(localizedLabelsList, o.localizedLabelsList, true) && compareDeep(localizedDescriptionsList, o.localizedDescriptionsList, true)
           && compareDeep(currentStates, o.currentStates, true) && compareDeep(range, o.range, true) && compareDeep(precision, o.precision, true)
           && compareDeep(termBindingsList, o.termBindingsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof WebTemplateInputListItem))
          return false;
        WebTemplateInputListItem o = (WebTemplateInputListItem) other_;
        return compareValues(value, o.value, true) && compareValues(label, o.label, true) && compareValues(ordinal, o.ordinal, true)
           && compareValues(currentStates, o.currentStates, true) && compareValues(range, o.range, true) && compareValues(precision, o.precision, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value, label, ordinal, localizedLabelsList
          , localizedDescriptionsList, currentStates, range, precision, termBindingsList);
      }


}

