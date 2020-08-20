package org.hl7.fhir.r5.model;


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

// Generated on Thu, Aug 20, 2020 19:42+1000 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * The Citation.
 */
@ResourceDef(name="Citation", profile="http://hl7.org/fhir/StructureDefinition/Citation")
public class Citation extends MetadataResource {

    @Block()
    public static class CitationSummaryComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Format for display of the citation.
         */
        @Child(name = "style", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Format for display of the citation", formalDefinition="Format for display of the citation." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-summary-style")
        protected CodeableConcept style;

        /**
         * The human-readable display of the citation.
         */
        @Child(name = "text", type = {MarkdownType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The human-readable display of the citation", formalDefinition="The human-readable display of the citation." )
        protected MarkdownType text;

        private static final long serialVersionUID = 123416446L;

    /**
     * Constructor
     */
      public CitationSummaryComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationSummaryComponent(String text) {
        super();
        this.setText(text);
      }

        /**
         * @return {@link #style} (Format for display of the citation.)
         */
        public CodeableConcept getStyle() { 
          if (this.style == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationSummaryComponent.style");
            else if (Configuration.doAutoCreate())
              this.style = new CodeableConcept(); // cc
          return this.style;
        }

        public boolean hasStyle() { 
          return this.style != null && !this.style.isEmpty();
        }

        /**
         * @param value {@link #style} (Format for display of the citation.)
         */
        public CitationSummaryComponent setStyle(CodeableConcept value) { 
          this.style = value;
          return this;
        }

        /**
         * @return {@link #text} (The human-readable display of the citation.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public MarkdownType getTextElement() { 
          if (this.text == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationSummaryComponent.text");
            else if (Configuration.doAutoCreate())
              this.text = new MarkdownType(); // bb
          return this.text;
        }

        public boolean hasTextElement() { 
          return this.text != null && !this.text.isEmpty();
        }

        public boolean hasText() { 
          return this.text != null && !this.text.isEmpty();
        }

        /**
         * @param value {@link #text} (The human-readable display of the citation.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public CitationSummaryComponent setTextElement(MarkdownType value) { 
          this.text = value;
          return this;
        }

        /**
         * @return The human-readable display of the citation.
         */
        public String getText() { 
          return this.text == null ? null : this.text.getValue();
        }

        /**
         * @param value The human-readable display of the citation.
         */
        public CitationSummaryComponent setText(String value) { 
            if (this.text == null)
              this.text = new MarkdownType();
            this.text.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("style", "CodeableConcept", "Format for display of the citation.", 0, 1, style));
          children.add(new Property("text", "markdown", "The human-readable display of the citation.", 0, 1, text));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 109780401: /*style*/  return new Property("style", "CodeableConcept", "Format for display of the citation.", 0, 1, style);
          case 3556653: /*text*/  return new Property("text", "markdown", "The human-readable display of the citation.", 0, 1, text);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 109780401: /*style*/ return this.style == null ? new Base[0] : new Base[] {this.style}; // CodeableConcept
        case 3556653: /*text*/ return this.text == null ? new Base[0] : new Base[] {this.text}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 109780401: // style
          this.style = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3556653: // text
          this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("style")) {
          this.style = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("text")) {
          this.text = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 109780401:  return getStyle();
        case 3556653:  return getTextElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 109780401: /*style*/ return new String[] {"CodeableConcept"};
        case 3556653: /*text*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("style")) {
          this.style = new CodeableConcept();
          return this.style;
        }
        else if (name.equals("text")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.summary.text");
        }
        else
          return super.addChild(name);
      }

      public CitationSummaryComponent copy() {
        CitationSummaryComponent dst = new CitationSummaryComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationSummaryComponent dst) {
        super.copyValues(dst);
        dst.style = style == null ? null : style.copy();
        dst.text = text == null ? null : text.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationSummaryComponent))
          return false;
        CitationSummaryComponent o = (CitationSummaryComponent) other_;
        return compareDeep(style, o.style, true) && compareDeep(text, o.text, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationSummaryComponent))
          return false;
        CitationSummaryComponent o = (CitationSummaryComponent) other_;
        return compareValues(text, o.text, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(style, text);
      }

  public String fhirType() {
    return "Citation.summary";

  }

  }

    @Block()
    public static class CitationVariantCitationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used to describe the reason for the variant citation, such as version or subpart specification.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to describe the reason for the variant citation, such as version or subpart specification", formalDefinition="Used to describe the reason for the variant citation, such as version or subpart specification." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-variant-type")
        protected CodeableConcept type;

        /**
         * Used to describe the specific variation, such as version number or subpart specification.
         */
        @Child(name = "value", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to describe the specific variation, such as version number or subpart specification", formalDefinition="Used to describe the specific variation, such as version number or subpart specification." )
        protected StringType value;

        /**
         * Base citation.
         */
        @Child(name = "baseCitation", type = {Citation.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Base citation", formalDefinition="Base citation." )
        protected Reference baseCitation;

        private static final long serialVersionUID = -765350500L;

    /**
     * Constructor
     */
      public CitationVariantCitationComponent() {
        super();
      }

        /**
         * @return {@link #type} (Used to describe the reason for the variant citation, such as version or subpart specification.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationVariantCitationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Used to describe the reason for the variant citation, such as version or subpart specification.)
         */
        public CitationVariantCitationComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (Used to describe the specific variation, such as version number or subpart specification.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationVariantCitationComponent.value");
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
         * @param value {@link #value} (Used to describe the specific variation, such as version number or subpart specification.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public CitationVariantCitationComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return Used to describe the specific variation, such as version number or subpart specification.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value Used to describe the specific variation, such as version number or subpart specification.
         */
        public CitationVariantCitationComponent setValue(String value) { 
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
         * @return {@link #baseCitation} (Base citation.)
         */
        public Reference getBaseCitation() { 
          if (this.baseCitation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationVariantCitationComponent.baseCitation");
            else if (Configuration.doAutoCreate())
              this.baseCitation = new Reference(); // cc
          return this.baseCitation;
        }

        public boolean hasBaseCitation() { 
          return this.baseCitation != null && !this.baseCitation.isEmpty();
        }

        /**
         * @param value {@link #baseCitation} (Base citation.)
         */
        public CitationVariantCitationComponent setBaseCitation(Reference value) { 
          this.baseCitation = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Used to describe the reason for the variant citation, such as version or subpart specification.", 0, 1, type));
          children.add(new Property("value", "string", "Used to describe the specific variation, such as version number or subpart specification.", 0, 1, value));
          children.add(new Property("baseCitation", "Reference(Citation)", "Base citation.", 0, 1, baseCitation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Used to describe the reason for the variant citation, such as version or subpart specification.", 0, 1, type);
          case 111972721: /*value*/  return new Property("value", "string", "Used to describe the specific variation, such as version number or subpart specification.", 0, 1, value);
          case 1182995672: /*baseCitation*/  return new Property("baseCitation", "Reference(Citation)", "Base citation.", 0, 1, baseCitation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        case 1182995672: /*baseCitation*/ return this.baseCitation == null ? new Base[0] : new Base[] {this.baseCitation}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        case 1182995672: // baseCitation
          this.baseCitation = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("baseCitation")) {
          this.baseCitation = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 111972721:  return getValueElement();
        case 1182995672:  return getBaseCitation();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"string"};
        case 1182995672: /*baseCitation*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.variantCitation.value");
        }
        else if (name.equals("baseCitation")) {
          this.baseCitation = new Reference();
          return this.baseCitation;
        }
        else
          return super.addChild(name);
      }

      public CitationVariantCitationComponent copy() {
        CitationVariantCitationComponent dst = new CitationVariantCitationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationVariantCitationComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
        dst.baseCitation = baseCitation == null ? null : baseCitation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationVariantCitationComponent))
          return false;
        CitationVariantCitationComponent o = (CitationVariantCitationComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true) && compareDeep(baseCitation, o.baseCitation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationVariantCitationComponent))
          return false;
        CitationVariantCitationComponent o = (CitationVariantCitationComponent) other_;
        return compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value, baseCitation
          );
      }

  public String fhirType() {
    return "Citation.variantCitation";

  }

  }

    @Block()
    public static class CitationJournalComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID", formalDefinition="Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID." )
        protected List<Identifier> identifier;

        /**
         * Place of publication of the journal.
         */
        @Child(name = "country", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Place of publication of the journal", formalDefinition="Place of publication of the journal." )
        protected StringType country;

        /**
         * The specific issue in which the cited article resides.
         */
        @Child(name = "journalIssue", type = {}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The specific issue in which the cited article resides", formalDefinition="The specific issue in which the cited article resides." )
        protected CitationJournalJournalIssueComponent journalIssue;

        /**
         * Journal title.
         */
        @Child(name = "title", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Journal title", formalDefinition="Journal title." )
        protected StringType title;

        private static final long serialVersionUID = 565129283L;

    /**
     * Constructor
     */
      public CitationJournalComponent() {
        super();
      }

        /**
         * @return {@link #identifier} (Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationJournalComponent setIdentifier(List<Identifier> theIdentifier) { 
          this.identifier = theIdentifier;
          return this;
        }

        public boolean hasIdentifier() { 
          if (this.identifier == null)
            return false;
          for (Identifier item : this.identifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Identifier addIdentifier() { //3
          Identifier t = new Identifier();
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return t;
        }

        public CitationJournalComponent addIdentifier(Identifier t) { //3
          if (t == null)
            return this;
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
         */
        public Identifier getIdentifierFirstRep() { 
          if (getIdentifier().isEmpty()) {
            addIdentifier();
          }
          return getIdentifier().get(0);
        }

        /**
         * @return {@link #country} (Place of publication of the journal.). This is the underlying object with id, value and extensions. The accessor "getCountry" gives direct access to the value
         */
        public StringType getCountryElement() { 
          if (this.country == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalComponent.country");
            else if (Configuration.doAutoCreate())
              this.country = new StringType(); // bb
          return this.country;
        }

        public boolean hasCountryElement() { 
          return this.country != null && !this.country.isEmpty();
        }

        public boolean hasCountry() { 
          return this.country != null && !this.country.isEmpty();
        }

        /**
         * @param value {@link #country} (Place of publication of the journal.). This is the underlying object with id, value and extensions. The accessor "getCountry" gives direct access to the value
         */
        public CitationJournalComponent setCountryElement(StringType value) { 
          this.country = value;
          return this;
        }

        /**
         * @return Place of publication of the journal.
         */
        public String getCountry() { 
          return this.country == null ? null : this.country.getValue();
        }

        /**
         * @param value Place of publication of the journal.
         */
        public CitationJournalComponent setCountry(String value) { 
          if (Utilities.noString(value))
            this.country = null;
          else {
            if (this.country == null)
              this.country = new StringType();
            this.country.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #journalIssue} (The specific issue in which the cited article resides.)
         */
        public CitationJournalJournalIssueComponent getJournalIssue() { 
          if (this.journalIssue == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalComponent.journalIssue");
            else if (Configuration.doAutoCreate())
              this.journalIssue = new CitationJournalJournalIssueComponent(); // cc
          return this.journalIssue;
        }

        public boolean hasJournalIssue() { 
          return this.journalIssue != null && !this.journalIssue.isEmpty();
        }

        /**
         * @param value {@link #journalIssue} (The specific issue in which the cited article resides.)
         */
        public CitationJournalComponent setJournalIssue(CitationJournalJournalIssueComponent value) { 
          this.journalIssue = value;
          return this;
        }

        /**
         * @return {@link #title} (Journal title.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalComponent.title");
            else if (Configuration.doAutoCreate())
              this.title = new StringType(); // bb
          return this.title;
        }

        public boolean hasTitleElement() { 
          return this.title != null && !this.title.isEmpty();
        }

        public boolean hasTitle() { 
          return this.title != null && !this.title.isEmpty();
        }

        /**
         * @param value {@link #title} (Journal title.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public CitationJournalComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return Journal title.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value Journal title.
         */
        public CitationJournalComponent setTitle(String value) { 
          if (Utilities.noString(value))
            this.title = null;
          else {
            if (this.title == null)
              this.title = new StringType();
            this.title.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID.", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("country", "string", "Place of publication of the journal.", 0, 1, country));
          children.add(new Property("journalIssue", "", "The specific issue in which the cited article resides.", 0, 1, journalIssue));
          children.add(new Property("title", "string", "Journal title.", 0, 1, title));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Journal identifiers include ISSN, ISO Abbreviation and NLMuniqueID.", 0, java.lang.Integer.MAX_VALUE, identifier);
          case 957831062: /*country*/  return new Property("country", "string", "Place of publication of the journal.", 0, 1, country);
          case -716835870: /*journalIssue*/  return new Property("journalIssue", "", "The specific issue in which the cited article resides.", 0, 1, journalIssue);
          case 110371416: /*title*/  return new Property("title", "string", "Journal title.", 0, 1, title);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 957831062: /*country*/ return this.country == null ? new Base[0] : new Base[] {this.country}; // StringType
        case -716835870: /*journalIssue*/ return this.journalIssue == null ? new Base[0] : new Base[] {this.journalIssue}; // CitationJournalJournalIssueComponent
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 957831062: // country
          this.country = TypeConvertor.castToString(value); // StringType
          return value;
        case -716835870: // journalIssue
          this.journalIssue = (CitationJournalJournalIssueComponent) value; // CitationJournalJournalIssueComponent
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("country")) {
          this.country = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("journalIssue")) {
          this.journalIssue = (CitationJournalJournalIssueComponent) value; // CitationJournalJournalIssueComponent
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 957831062:  return getCountryElement();
        case -716835870:  return getJournalIssue();
        case 110371416:  return getTitleElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 957831062: /*country*/ return new String[] {"string"};
        case -716835870: /*journalIssue*/ return new String[] {};
        case 110371416: /*title*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("country")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.journal.country");
        }
        else if (name.equals("journalIssue")) {
          this.journalIssue = new CitationJournalJournalIssueComponent();
          return this.journalIssue;
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.journal.title");
        }
        else
          return super.addChild(name);
      }

      public CitationJournalComponent copy() {
        CitationJournalComponent dst = new CitationJournalComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationJournalComponent dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.country = country == null ? null : country.copy();
        dst.journalIssue = journalIssue == null ? null : journalIssue.copy();
        dst.title = title == null ? null : title.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationJournalComponent))
          return false;
        CitationJournalComponent o = (CitationJournalComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(country, o.country, true) && compareDeep(journalIssue, o.journalIssue, true)
           && compareDeep(title, o.title, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationJournalComponent))
          return false;
        CitationJournalComponent o = (CitationJournalComponent) other_;
        return compareValues(country, o.country, true) && compareValues(title, o.title, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, country, journalIssue
          , title);
      }

  public String fhirType() {
    return "Citation.journal";

  }

  }

    @Block()
    public static class CitationJournalJournalIssueComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * NLM codes Internet or Print.
         */
        @Child(name = "citedMedium", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="NLM codes Internet or Print", formalDefinition="NLM codes Internet or Print." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/journal-issue-medium")
        protected CodeableConcept citedMedium;

        /**
         * Volume number of journal in which the article is published.
         */
        @Child(name = "volume", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Volume number of journal in which the article is published", formalDefinition="Volume number of journal in which the article is published." )
        protected StringType volume;

        /**
         * Issue, part or supplement of journal in which the article is published.
         */
        @Child(name = "issue", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Issue, part or supplement of journal in which the article is published", formalDefinition="Issue, part or supplement of journal in which the article is published." )
        protected StringType issue;

        /**
         * Date on which the issue of the journal was published.
         */
        @Child(name = "publicationDate", type = {}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Date on which the issue of the journal was published", formalDefinition="Date on which the issue of the journal was published." )
        protected CitationJournalJournalIssuePublicationDateComponent publicationDate;

        private static final long serialVersionUID = 933986267L;

    /**
     * Constructor
     */
      public CitationJournalJournalIssueComponent() {
        super();
      }

        /**
         * @return {@link #citedMedium} (NLM codes Internet or Print.)
         */
        public CodeableConcept getCitedMedium() { 
          if (this.citedMedium == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalJournalIssueComponent.citedMedium");
            else if (Configuration.doAutoCreate())
              this.citedMedium = new CodeableConcept(); // cc
          return this.citedMedium;
        }

        public boolean hasCitedMedium() { 
          return this.citedMedium != null && !this.citedMedium.isEmpty();
        }

        /**
         * @param value {@link #citedMedium} (NLM codes Internet or Print.)
         */
        public CitationJournalJournalIssueComponent setCitedMedium(CodeableConcept value) { 
          this.citedMedium = value;
          return this;
        }

        /**
         * @return {@link #volume} (Volume number of journal in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getVolume" gives direct access to the value
         */
        public StringType getVolumeElement() { 
          if (this.volume == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalJournalIssueComponent.volume");
            else if (Configuration.doAutoCreate())
              this.volume = new StringType(); // bb
          return this.volume;
        }

        public boolean hasVolumeElement() { 
          return this.volume != null && !this.volume.isEmpty();
        }

        public boolean hasVolume() { 
          return this.volume != null && !this.volume.isEmpty();
        }

        /**
         * @param value {@link #volume} (Volume number of journal in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getVolume" gives direct access to the value
         */
        public CitationJournalJournalIssueComponent setVolumeElement(StringType value) { 
          this.volume = value;
          return this;
        }

        /**
         * @return Volume number of journal in which the article is published.
         */
        public String getVolume() { 
          return this.volume == null ? null : this.volume.getValue();
        }

        /**
         * @param value Volume number of journal in which the article is published.
         */
        public CitationJournalJournalIssueComponent setVolume(String value) { 
          if (Utilities.noString(value))
            this.volume = null;
          else {
            if (this.volume == null)
              this.volume = new StringType();
            this.volume.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #issue} (Issue, part or supplement of journal in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getIssue" gives direct access to the value
         */
        public StringType getIssueElement() { 
          if (this.issue == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalJournalIssueComponent.issue");
            else if (Configuration.doAutoCreate())
              this.issue = new StringType(); // bb
          return this.issue;
        }

        public boolean hasIssueElement() { 
          return this.issue != null && !this.issue.isEmpty();
        }

        public boolean hasIssue() { 
          return this.issue != null && !this.issue.isEmpty();
        }

        /**
         * @param value {@link #issue} (Issue, part or supplement of journal in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getIssue" gives direct access to the value
         */
        public CitationJournalJournalIssueComponent setIssueElement(StringType value) { 
          this.issue = value;
          return this;
        }

        /**
         * @return Issue, part or supplement of journal in which the article is published.
         */
        public String getIssue() { 
          return this.issue == null ? null : this.issue.getValue();
        }

        /**
         * @param value Issue, part or supplement of journal in which the article is published.
         */
        public CitationJournalJournalIssueComponent setIssue(String value) { 
          if (Utilities.noString(value))
            this.issue = null;
          else {
            if (this.issue == null)
              this.issue = new StringType();
            this.issue.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #publicationDate} (Date on which the issue of the journal was published.)
         */
        public CitationJournalJournalIssuePublicationDateComponent getPublicationDate() { 
          if (this.publicationDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalJournalIssueComponent.publicationDate");
            else if (Configuration.doAutoCreate())
              this.publicationDate = new CitationJournalJournalIssuePublicationDateComponent(); // cc
          return this.publicationDate;
        }

        public boolean hasPublicationDate() { 
          return this.publicationDate != null && !this.publicationDate.isEmpty();
        }

        /**
         * @param value {@link #publicationDate} (Date on which the issue of the journal was published.)
         */
        public CitationJournalJournalIssueComponent setPublicationDate(CitationJournalJournalIssuePublicationDateComponent value) { 
          this.publicationDate = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("citedMedium", "CodeableConcept", "NLM codes Internet or Print.", 0, 1, citedMedium));
          children.add(new Property("volume", "string", "Volume number of journal in which the article is published.", 0, 1, volume));
          children.add(new Property("issue", "string", "Issue, part or supplement of journal in which the article is published.", 0, 1, issue));
          children.add(new Property("publicationDate", "", "Date on which the issue of the journal was published.", 0, 1, publicationDate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 612116418: /*citedMedium*/  return new Property("citedMedium", "CodeableConcept", "NLM codes Internet or Print.", 0, 1, citedMedium);
          case -810883302: /*volume*/  return new Property("volume", "string", "Volume number of journal in which the article is published.", 0, 1, volume);
          case 100509913: /*issue*/  return new Property("issue", "string", "Issue, part or supplement of journal in which the article is published.", 0, 1, issue);
          case 1470566394: /*publicationDate*/  return new Property("publicationDate", "", "Date on which the issue of the journal was published.", 0, 1, publicationDate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 612116418: /*citedMedium*/ return this.citedMedium == null ? new Base[0] : new Base[] {this.citedMedium}; // CodeableConcept
        case -810883302: /*volume*/ return this.volume == null ? new Base[0] : new Base[] {this.volume}; // StringType
        case 100509913: /*issue*/ return this.issue == null ? new Base[0] : new Base[] {this.issue}; // StringType
        case 1470566394: /*publicationDate*/ return this.publicationDate == null ? new Base[0] : new Base[] {this.publicationDate}; // CitationJournalJournalIssuePublicationDateComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 612116418: // citedMedium
          this.citedMedium = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -810883302: // volume
          this.volume = TypeConvertor.castToString(value); // StringType
          return value;
        case 100509913: // issue
          this.issue = TypeConvertor.castToString(value); // StringType
          return value;
        case 1470566394: // publicationDate
          this.publicationDate = (CitationJournalJournalIssuePublicationDateComponent) value; // CitationJournalJournalIssuePublicationDateComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("citedMedium")) {
          this.citedMedium = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("volume")) {
          this.volume = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("issue")) {
          this.issue = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("publicationDate")) {
          this.publicationDate = (CitationJournalJournalIssuePublicationDateComponent) value; // CitationJournalJournalIssuePublicationDateComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 612116418:  return getCitedMedium();
        case -810883302:  return getVolumeElement();
        case 100509913:  return getIssueElement();
        case 1470566394:  return getPublicationDate();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 612116418: /*citedMedium*/ return new String[] {"CodeableConcept"};
        case -810883302: /*volume*/ return new String[] {"string"};
        case 100509913: /*issue*/ return new String[] {"string"};
        case 1470566394: /*publicationDate*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("citedMedium")) {
          this.citedMedium = new CodeableConcept();
          return this.citedMedium;
        }
        else if (name.equals("volume")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.journal.journalIssue.volume");
        }
        else if (name.equals("issue")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.journal.journalIssue.issue");
        }
        else if (name.equals("publicationDate")) {
          this.publicationDate = new CitationJournalJournalIssuePublicationDateComponent();
          return this.publicationDate;
        }
        else
          return super.addChild(name);
      }

      public CitationJournalJournalIssueComponent copy() {
        CitationJournalJournalIssueComponent dst = new CitationJournalJournalIssueComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationJournalJournalIssueComponent dst) {
        super.copyValues(dst);
        dst.citedMedium = citedMedium == null ? null : citedMedium.copy();
        dst.volume = volume == null ? null : volume.copy();
        dst.issue = issue == null ? null : issue.copy();
        dst.publicationDate = publicationDate == null ? null : publicationDate.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationJournalJournalIssueComponent))
          return false;
        CitationJournalJournalIssueComponent o = (CitationJournalJournalIssueComponent) other_;
        return compareDeep(citedMedium, o.citedMedium, true) && compareDeep(volume, o.volume, true) && compareDeep(issue, o.issue, true)
           && compareDeep(publicationDate, o.publicationDate, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationJournalJournalIssueComponent))
          return false;
        CitationJournalJournalIssueComponent o = (CitationJournalJournalIssueComponent) other_;
        return compareValues(volume, o.volume, true) && compareValues(issue, o.issue, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(citedMedium, volume, issue
          , publicationDate);
      }

  public String fhirType() {
    return "Citation.journal.journalIssue";

  }

  }

    @Block()
    public static class CitationJournalJournalIssuePublicationDateComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Defining the date on which the issue of the joutnal was published.
         */
        @Child(name = "date", type = {DateType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Defining the date on which the issue of the joutnal was published", formalDefinition="Defining the date on which the issue of the joutnal was published." )
        protected DateType date;

        /**
         * Year on which the issue of the journal was published.
         */
        @Child(name = "year", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Year on which the issue of the journal was published", formalDefinition="Year on which the issue of the journal was published." )
        protected StringType year;

        /**
         * Month on which the issue of the journal was published.
         */
        @Child(name = "month", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Month on which the issue of the journal was published", formalDefinition="Month on which the issue of the journal was published." )
        protected StringType month;

        /**
         * Day on which the issue of the journal was published.
         */
        @Child(name = "day", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Day on which the issue of the journal was published", formalDefinition="Day on which the issue of the journal was published." )
        protected StringType day;

        /**
         * Spring, Summer, Fall/Autumn, Winter.
         */
        @Child(name = "season", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Season on which the issue of the jornal was published", formalDefinition="Spring, Summer, Fall/Autumn, Winter." )
        protected StringType season;

        /**
         * Text representation of the date of which the issue of the journal was published.
         */
        @Child(name = "text", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Text representation of the date of which the issue of the journal was published", formalDefinition="Text representation of the date of which the issue of the journal was published." )
        protected StringType text;

        private static final long serialVersionUID = 1585589146L;

    /**
     * Constructor
     */
      public CitationJournalJournalIssuePublicationDateComponent() {
        super();
      }

        /**
         * @return {@link #date} (Defining the date on which the issue of the joutnal was published.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public DateType getDateElement() { 
          if (this.date == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalJournalIssuePublicationDateComponent.date");
            else if (Configuration.doAutoCreate())
              this.date = new DateType(); // bb
          return this.date;
        }

        public boolean hasDateElement() { 
          return this.date != null && !this.date.isEmpty();
        }

        public boolean hasDate() { 
          return this.date != null && !this.date.isEmpty();
        }

        /**
         * @param value {@link #date} (Defining the date on which the issue of the joutnal was published.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public CitationJournalJournalIssuePublicationDateComponent setDateElement(DateType value) { 
          this.date = value;
          return this;
        }

        /**
         * @return Defining the date on which the issue of the joutnal was published.
         */
        public Date getDate() { 
          return this.date == null ? null : this.date.getValue();
        }

        /**
         * @param value Defining the date on which the issue of the joutnal was published.
         */
        public CitationJournalJournalIssuePublicationDateComponent setDate(Date value) { 
          if (value == null)
            this.date = null;
          else {
            if (this.date == null)
              this.date = new DateType();
            this.date.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #year} (Year on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getYear" gives direct access to the value
         */
        public StringType getYearElement() { 
          if (this.year == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalJournalIssuePublicationDateComponent.year");
            else if (Configuration.doAutoCreate())
              this.year = new StringType(); // bb
          return this.year;
        }

        public boolean hasYearElement() { 
          return this.year != null && !this.year.isEmpty();
        }

        public boolean hasYear() { 
          return this.year != null && !this.year.isEmpty();
        }

        /**
         * @param value {@link #year} (Year on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getYear" gives direct access to the value
         */
        public CitationJournalJournalIssuePublicationDateComponent setYearElement(StringType value) { 
          this.year = value;
          return this;
        }

        /**
         * @return Year on which the issue of the journal was published.
         */
        public String getYear() { 
          return this.year == null ? null : this.year.getValue();
        }

        /**
         * @param value Year on which the issue of the journal was published.
         */
        public CitationJournalJournalIssuePublicationDateComponent setYear(String value) { 
          if (Utilities.noString(value))
            this.year = null;
          else {
            if (this.year == null)
              this.year = new StringType();
            this.year.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #month} (Month on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getMonth" gives direct access to the value
         */
        public StringType getMonthElement() { 
          if (this.month == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalJournalIssuePublicationDateComponent.month");
            else if (Configuration.doAutoCreate())
              this.month = new StringType(); // bb
          return this.month;
        }

        public boolean hasMonthElement() { 
          return this.month != null && !this.month.isEmpty();
        }

        public boolean hasMonth() { 
          return this.month != null && !this.month.isEmpty();
        }

        /**
         * @param value {@link #month} (Month on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getMonth" gives direct access to the value
         */
        public CitationJournalJournalIssuePublicationDateComponent setMonthElement(StringType value) { 
          this.month = value;
          return this;
        }

        /**
         * @return Month on which the issue of the journal was published.
         */
        public String getMonth() { 
          return this.month == null ? null : this.month.getValue();
        }

        /**
         * @param value Month on which the issue of the journal was published.
         */
        public CitationJournalJournalIssuePublicationDateComponent setMonth(String value) { 
          if (Utilities.noString(value))
            this.month = null;
          else {
            if (this.month == null)
              this.month = new StringType();
            this.month.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #day} (Day on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getDay" gives direct access to the value
         */
        public StringType getDayElement() { 
          if (this.day == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalJournalIssuePublicationDateComponent.day");
            else if (Configuration.doAutoCreate())
              this.day = new StringType(); // bb
          return this.day;
        }

        public boolean hasDayElement() { 
          return this.day != null && !this.day.isEmpty();
        }

        public boolean hasDay() { 
          return this.day != null && !this.day.isEmpty();
        }

        /**
         * @param value {@link #day} (Day on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getDay" gives direct access to the value
         */
        public CitationJournalJournalIssuePublicationDateComponent setDayElement(StringType value) { 
          this.day = value;
          return this;
        }

        /**
         * @return Day on which the issue of the journal was published.
         */
        public String getDay() { 
          return this.day == null ? null : this.day.getValue();
        }

        /**
         * @param value Day on which the issue of the journal was published.
         */
        public CitationJournalJournalIssuePublicationDateComponent setDay(String value) { 
          if (Utilities.noString(value))
            this.day = null;
          else {
            if (this.day == null)
              this.day = new StringType();
            this.day.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #season} (Spring, Summer, Fall/Autumn, Winter.). This is the underlying object with id, value and extensions. The accessor "getSeason" gives direct access to the value
         */
        public StringType getSeasonElement() { 
          if (this.season == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalJournalIssuePublicationDateComponent.season");
            else if (Configuration.doAutoCreate())
              this.season = new StringType(); // bb
          return this.season;
        }

        public boolean hasSeasonElement() { 
          return this.season != null && !this.season.isEmpty();
        }

        public boolean hasSeason() { 
          return this.season != null && !this.season.isEmpty();
        }

        /**
         * @param value {@link #season} (Spring, Summer, Fall/Autumn, Winter.). This is the underlying object with id, value and extensions. The accessor "getSeason" gives direct access to the value
         */
        public CitationJournalJournalIssuePublicationDateComponent setSeasonElement(StringType value) { 
          this.season = value;
          return this;
        }

        /**
         * @return Spring, Summer, Fall/Autumn, Winter.
         */
        public String getSeason() { 
          return this.season == null ? null : this.season.getValue();
        }

        /**
         * @param value Spring, Summer, Fall/Autumn, Winter.
         */
        public CitationJournalJournalIssuePublicationDateComponent setSeason(String value) { 
          if (Utilities.noString(value))
            this.season = null;
          else {
            if (this.season == null)
              this.season = new StringType();
            this.season.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #text} (Text representation of the date of which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public StringType getTextElement() { 
          if (this.text == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalJournalIssuePublicationDateComponent.text");
            else if (Configuration.doAutoCreate())
              this.text = new StringType(); // bb
          return this.text;
        }

        public boolean hasTextElement() { 
          return this.text != null && !this.text.isEmpty();
        }

        public boolean hasText() { 
          return this.text != null && !this.text.isEmpty();
        }

        /**
         * @param value {@link #text} (Text representation of the date of which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public CitationJournalJournalIssuePublicationDateComponent setTextElement(StringType value) { 
          this.text = value;
          return this;
        }

        /**
         * @return Text representation of the date of which the issue of the journal was published.
         */
        public String getText() { 
          return this.text == null ? null : this.text.getValue();
        }

        /**
         * @param value Text representation of the date of which the issue of the journal was published.
         */
        public CitationJournalJournalIssuePublicationDateComponent setText(String value) { 
          if (Utilities.noString(value))
            this.text = null;
          else {
            if (this.text == null)
              this.text = new StringType();
            this.text.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("date", "date", "Defining the date on which the issue of the joutnal was published.", 0, 1, date));
          children.add(new Property("year", "string", "Year on which the issue of the journal was published.", 0, 1, year));
          children.add(new Property("month", "string", "Month on which the issue of the journal was published.", 0, 1, month));
          children.add(new Property("day", "string", "Day on which the issue of the journal was published.", 0, 1, day));
          children.add(new Property("season", "string", "Spring, Summer, Fall/Autumn, Winter.", 0, 1, season));
          children.add(new Property("text", "string", "Text representation of the date of which the issue of the journal was published.", 0, 1, text));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3076014: /*date*/  return new Property("date", "date", "Defining the date on which the issue of the joutnal was published.", 0, 1, date);
          case 3704893: /*year*/  return new Property("year", "string", "Year on which the issue of the journal was published.", 0, 1, year);
          case 104080000: /*month*/  return new Property("month", "string", "Month on which the issue of the journal was published.", 0, 1, month);
          case 99228: /*day*/  return new Property("day", "string", "Day on which the issue of the journal was published.", 0, 1, day);
          case -906335517: /*season*/  return new Property("season", "string", "Spring, Summer, Fall/Autumn, Winter.", 0, 1, season);
          case 3556653: /*text*/  return new Property("text", "string", "Text representation of the date of which the issue of the journal was published.", 0, 1, text);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateType
        case 3704893: /*year*/ return this.year == null ? new Base[0] : new Base[] {this.year}; // StringType
        case 104080000: /*month*/ return this.month == null ? new Base[0] : new Base[] {this.month}; // StringType
        case 99228: /*day*/ return this.day == null ? new Base[0] : new Base[] {this.day}; // StringType
        case -906335517: /*season*/ return this.season == null ? new Base[0] : new Base[] {this.season}; // StringType
        case 3556653: /*text*/ return this.text == null ? new Base[0] : new Base[] {this.text}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3076014: // date
          this.date = TypeConvertor.castToDate(value); // DateType
          return value;
        case 3704893: // year
          this.year = TypeConvertor.castToString(value); // StringType
          return value;
        case 104080000: // month
          this.month = TypeConvertor.castToString(value); // StringType
          return value;
        case 99228: // day
          this.day = TypeConvertor.castToString(value); // StringType
          return value;
        case -906335517: // season
          this.season = TypeConvertor.castToString(value); // StringType
          return value;
        case 3556653: // text
          this.text = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("date")) {
          this.date = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("year")) {
          this.year = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("month")) {
          this.month = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("day")) {
          this.day = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("season")) {
          this.season = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("text")) {
          this.text = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3076014:  return getDateElement();
        case 3704893:  return getYearElement();
        case 104080000:  return getMonthElement();
        case 99228:  return getDayElement();
        case -906335517:  return getSeasonElement();
        case 3556653:  return getTextElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3076014: /*date*/ return new String[] {"date"};
        case 3704893: /*year*/ return new String[] {"string"};
        case 104080000: /*month*/ return new String[] {"string"};
        case 99228: /*day*/ return new String[] {"string"};
        case -906335517: /*season*/ return new String[] {"string"};
        case 3556653: /*text*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.journal.journalIssue.publicationDate.date");
        }
        else if (name.equals("year")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.journal.journalIssue.publicationDate.year");
        }
        else if (name.equals("month")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.journal.journalIssue.publicationDate.month");
        }
        else if (name.equals("day")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.journal.journalIssue.publicationDate.day");
        }
        else if (name.equals("season")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.journal.journalIssue.publicationDate.season");
        }
        else if (name.equals("text")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.journal.journalIssue.publicationDate.text");
        }
        else
          return super.addChild(name);
      }

      public CitationJournalJournalIssuePublicationDateComponent copy() {
        CitationJournalJournalIssuePublicationDateComponent dst = new CitationJournalJournalIssuePublicationDateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationJournalJournalIssuePublicationDateComponent dst) {
        super.copyValues(dst);
        dst.date = date == null ? null : date.copy();
        dst.year = year == null ? null : year.copy();
        dst.month = month == null ? null : month.copy();
        dst.day = day == null ? null : day.copy();
        dst.season = season == null ? null : season.copy();
        dst.text = text == null ? null : text.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationJournalJournalIssuePublicationDateComponent))
          return false;
        CitationJournalJournalIssuePublicationDateComponent o = (CitationJournalJournalIssuePublicationDateComponent) other_;
        return compareDeep(date, o.date, true) && compareDeep(year, o.year, true) && compareDeep(month, o.month, true)
           && compareDeep(day, o.day, true) && compareDeep(season, o.season, true) && compareDeep(text, o.text, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationJournalJournalIssuePublicationDateComponent))
          return false;
        CitationJournalJournalIssuePublicationDateComponent o = (CitationJournalJournalIssuePublicationDateComponent) other_;
        return compareValues(date, o.date, true) && compareValues(year, o.year, true) && compareValues(month, o.month, true)
           && compareValues(day, o.day, true) && compareValues(season, o.season, true) && compareValues(text, o.text, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(date, year, month, day
          , season, text);
      }

  public String fhirType() {
    return "Citation.journal.journalIssue.publicationDate";

  }

  }

    @Block()
    public static class CitationPublicationInfoComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The collection the cited article is published in.
         */
        @Child(name = "publishedIn", type = {}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The collection the cited article is published in", formalDefinition="The collection the cited article is published in." )
        protected CitationPublicationInfoPublishedInComponent publishedIn;

        /**
         * The date the article was added to the database.
         */
        @Child(name = "entryDate", type = {DateTimeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The date the article was added to the database", formalDefinition="The date the article was added to the database." )
        protected DateTimeType entryDate;

        /**
         * The date the article was last revised or updated in the database.
         */
        @Child(name = "revisionDate", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The date the article was last revised or updated in the database", formalDefinition="The date the article was last revised or updated in the database." )
        protected DateTimeType revisionDate;

        /**
         * Actual or Approximate number of pages or screens.
         */
        @Child(name = "pageCount", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Number of pages or screens", formalDefinition="Actual or Approximate number of pages or screens." )
        protected StringType pageCount;

        private static final long serialVersionUID = -223356914L;

    /**
     * Constructor
     */
      public CitationPublicationInfoComponent() {
        super();
      }

        /**
         * @return {@link #publishedIn} (The collection the cited article is published in.)
         */
        public CitationPublicationInfoPublishedInComponent getPublishedIn() { 
          if (this.publishedIn == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPublicationInfoComponent.publishedIn");
            else if (Configuration.doAutoCreate())
              this.publishedIn = new CitationPublicationInfoPublishedInComponent(); // cc
          return this.publishedIn;
        }

        public boolean hasPublishedIn() { 
          return this.publishedIn != null && !this.publishedIn.isEmpty();
        }

        /**
         * @param value {@link #publishedIn} (The collection the cited article is published in.)
         */
        public CitationPublicationInfoComponent setPublishedIn(CitationPublicationInfoPublishedInComponent value) { 
          this.publishedIn = value;
          return this;
        }

        /**
         * @return {@link #entryDate} (The date the article was added to the database.). This is the underlying object with id, value and extensions. The accessor "getEntryDate" gives direct access to the value
         */
        public DateTimeType getEntryDateElement() { 
          if (this.entryDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPublicationInfoComponent.entryDate");
            else if (Configuration.doAutoCreate())
              this.entryDate = new DateTimeType(); // bb
          return this.entryDate;
        }

        public boolean hasEntryDateElement() { 
          return this.entryDate != null && !this.entryDate.isEmpty();
        }

        public boolean hasEntryDate() { 
          return this.entryDate != null && !this.entryDate.isEmpty();
        }

        /**
         * @param value {@link #entryDate} (The date the article was added to the database.). This is the underlying object with id, value and extensions. The accessor "getEntryDate" gives direct access to the value
         */
        public CitationPublicationInfoComponent setEntryDateElement(DateTimeType value) { 
          this.entryDate = value;
          return this;
        }

        /**
         * @return The date the article was added to the database.
         */
        public Date getEntryDate() { 
          return this.entryDate == null ? null : this.entryDate.getValue();
        }

        /**
         * @param value The date the article was added to the database.
         */
        public CitationPublicationInfoComponent setEntryDate(Date value) { 
          if (value == null)
            this.entryDate = null;
          else {
            if (this.entryDate == null)
              this.entryDate = new DateTimeType();
            this.entryDate.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #revisionDate} (The date the article was last revised or updated in the database.). This is the underlying object with id, value and extensions. The accessor "getRevisionDate" gives direct access to the value
         */
        public DateTimeType getRevisionDateElement() { 
          if (this.revisionDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPublicationInfoComponent.revisionDate");
            else if (Configuration.doAutoCreate())
              this.revisionDate = new DateTimeType(); // bb
          return this.revisionDate;
        }

        public boolean hasRevisionDateElement() { 
          return this.revisionDate != null && !this.revisionDate.isEmpty();
        }

        public boolean hasRevisionDate() { 
          return this.revisionDate != null && !this.revisionDate.isEmpty();
        }

        /**
         * @param value {@link #revisionDate} (The date the article was last revised or updated in the database.). This is the underlying object with id, value and extensions. The accessor "getRevisionDate" gives direct access to the value
         */
        public CitationPublicationInfoComponent setRevisionDateElement(DateTimeType value) { 
          this.revisionDate = value;
          return this;
        }

        /**
         * @return The date the article was last revised or updated in the database.
         */
        public Date getRevisionDate() { 
          return this.revisionDate == null ? null : this.revisionDate.getValue();
        }

        /**
         * @param value The date the article was last revised or updated in the database.
         */
        public CitationPublicationInfoComponent setRevisionDate(Date value) { 
          if (value == null)
            this.revisionDate = null;
          else {
            if (this.revisionDate == null)
              this.revisionDate = new DateTimeType();
            this.revisionDate.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #pageCount} (Actual or Approximate number of pages or screens.). This is the underlying object with id, value and extensions. The accessor "getPageCount" gives direct access to the value
         */
        public StringType getPageCountElement() { 
          if (this.pageCount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPublicationInfoComponent.pageCount");
            else if (Configuration.doAutoCreate())
              this.pageCount = new StringType(); // bb
          return this.pageCount;
        }

        public boolean hasPageCountElement() { 
          return this.pageCount != null && !this.pageCount.isEmpty();
        }

        public boolean hasPageCount() { 
          return this.pageCount != null && !this.pageCount.isEmpty();
        }

        /**
         * @param value {@link #pageCount} (Actual or Approximate number of pages or screens.). This is the underlying object with id, value and extensions. The accessor "getPageCount" gives direct access to the value
         */
        public CitationPublicationInfoComponent setPageCountElement(StringType value) { 
          this.pageCount = value;
          return this;
        }

        /**
         * @return Actual or Approximate number of pages or screens.
         */
        public String getPageCount() { 
          return this.pageCount == null ? null : this.pageCount.getValue();
        }

        /**
         * @param value Actual or Approximate number of pages or screens.
         */
        public CitationPublicationInfoComponent setPageCount(String value) { 
          if (Utilities.noString(value))
            this.pageCount = null;
          else {
            if (this.pageCount == null)
              this.pageCount = new StringType();
            this.pageCount.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("publishedIn", "", "The collection the cited article is published in.", 0, 1, publishedIn));
          children.add(new Property("entryDate", "dateTime", "The date the article was added to the database.", 0, 1, entryDate));
          children.add(new Property("revisionDate", "dateTime", "The date the article was last revised or updated in the database.", 0, 1, revisionDate));
          children.add(new Property("pageCount", "string", "Actual or Approximate number of pages or screens.", 0, 1, pageCount));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -614144077: /*publishedIn*/  return new Property("publishedIn", "", "The collection the cited article is published in.", 0, 1, publishedIn);
          case -479861952: /*entryDate*/  return new Property("entryDate", "dateTime", "The date the article was added to the database.", 0, 1, entryDate);
          case -1250970071: /*revisionDate*/  return new Property("revisionDate", "dateTime", "The date the article was last revised or updated in the database.", 0, 1, revisionDate);
          case 857882560: /*pageCount*/  return new Property("pageCount", "string", "Actual or Approximate number of pages or screens.", 0, 1, pageCount);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -614144077: /*publishedIn*/ return this.publishedIn == null ? new Base[0] : new Base[] {this.publishedIn}; // CitationPublicationInfoPublishedInComponent
        case -479861952: /*entryDate*/ return this.entryDate == null ? new Base[0] : new Base[] {this.entryDate}; // DateTimeType
        case -1250970071: /*revisionDate*/ return this.revisionDate == null ? new Base[0] : new Base[] {this.revisionDate}; // DateTimeType
        case 857882560: /*pageCount*/ return this.pageCount == null ? new Base[0] : new Base[] {this.pageCount}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -614144077: // publishedIn
          this.publishedIn = (CitationPublicationInfoPublishedInComponent) value; // CitationPublicationInfoPublishedInComponent
          return value;
        case -479861952: // entryDate
          this.entryDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1250970071: // revisionDate
          this.revisionDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 857882560: // pageCount
          this.pageCount = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("publishedIn")) {
          this.publishedIn = (CitationPublicationInfoPublishedInComponent) value; // CitationPublicationInfoPublishedInComponent
        } else if (name.equals("entryDate")) {
          this.entryDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("revisionDate")) {
          this.revisionDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("pageCount")) {
          this.pageCount = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -614144077:  return getPublishedIn();
        case -479861952:  return getEntryDateElement();
        case -1250970071:  return getRevisionDateElement();
        case 857882560:  return getPageCountElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -614144077: /*publishedIn*/ return new String[] {};
        case -479861952: /*entryDate*/ return new String[] {"dateTime"};
        case -1250970071: /*revisionDate*/ return new String[] {"dateTime"};
        case 857882560: /*pageCount*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("publishedIn")) {
          this.publishedIn = new CitationPublicationInfoPublishedInComponent();
          return this.publishedIn;
        }
        else if (name.equals("entryDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.publicationInfo.entryDate");
        }
        else if (name.equals("revisionDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.publicationInfo.revisionDate");
        }
        else if (name.equals("pageCount")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.publicationInfo.pageCount");
        }
        else
          return super.addChild(name);
      }

      public CitationPublicationInfoComponent copy() {
        CitationPublicationInfoComponent dst = new CitationPublicationInfoComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationPublicationInfoComponent dst) {
        super.copyValues(dst);
        dst.publishedIn = publishedIn == null ? null : publishedIn.copy();
        dst.entryDate = entryDate == null ? null : entryDate.copy();
        dst.revisionDate = revisionDate == null ? null : revisionDate.copy();
        dst.pageCount = pageCount == null ? null : pageCount.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationPublicationInfoComponent))
          return false;
        CitationPublicationInfoComponent o = (CitationPublicationInfoComponent) other_;
        return compareDeep(publishedIn, o.publishedIn, true) && compareDeep(entryDate, o.entryDate, true)
           && compareDeep(revisionDate, o.revisionDate, true) && compareDeep(pageCount, o.pageCount, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationPublicationInfoComponent))
          return false;
        CitationPublicationInfoComponent o = (CitationPublicationInfoComponent) other_;
        return compareValues(entryDate, o.entryDate, true) && compareValues(revisionDate, o.revisionDate, true)
           && compareValues(pageCount, o.pageCount, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(publishedIn, entryDate, revisionDate
          , pageCount);
      }

  public String fhirType() {
    return "Citation.publicationInfo";

  }

  }

    @Block()
    public static class CitationPublicationInfoPublishedInComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Database or book.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Database or book", formalDefinition="Database or book." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/published-in-type")
        protected CodeableConcept type;

        /**
         * Identifiers may include ISBN (International Standard Book Number) for books.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Identifiers may include ISBN for books", formalDefinition="Identifiers may include ISBN (International Standard Book Number) for books." )
        protected List<Identifier> identifier;

        /**
         * Name of the database or title of the book.
         */
        @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of the database or title of the book", formalDefinition="Name of the database or title of the book." )
        protected StringType name;

        /**
         * Name of the publisher.
         */
        @Child(name = "publisher", type = {Organization.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of the publisher", formalDefinition="Name of the publisher." )
        protected Reference publisher;

        /**
         * Geographic location of the publisher.
         */
        @Child(name = "publisherLocation", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Geographic location of the publisher", formalDefinition="Geographic location of the publisher." )
        protected StringType publisherLocation;

        /**
         * When the database was first available or when the book was published.
         */
        @Child(name = "startDate", type = {DateType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When the database was first available or when the book was published", formalDefinition="When the database was first available or when the book was published." )
        protected DateType startDate;

        private static final long serialVersionUID = -618673226L;

    /**
     * Constructor
     */
      public CitationPublicationInfoPublishedInComponent() {
        super();
      }

        /**
         * @return {@link #type} (Database or book.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPublicationInfoPublishedInComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Database or book.)
         */
        public CitationPublicationInfoPublishedInComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #identifier} (Identifiers may include ISBN (International Standard Book Number) for books.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationPublicationInfoPublishedInComponent setIdentifier(List<Identifier> theIdentifier) { 
          this.identifier = theIdentifier;
          return this;
        }

        public boolean hasIdentifier() { 
          if (this.identifier == null)
            return false;
          for (Identifier item : this.identifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Identifier addIdentifier() { //3
          Identifier t = new Identifier();
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return t;
        }

        public CitationPublicationInfoPublishedInComponent addIdentifier(Identifier t) { //3
          if (t == null)
            return this;
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
         */
        public Identifier getIdentifierFirstRep() { 
          if (getIdentifier().isEmpty()) {
            addIdentifier();
          }
          return getIdentifier().get(0);
        }

        /**
         * @return {@link #name} (Name of the database or title of the book.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPublicationInfoPublishedInComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new StringType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (Name of the database or title of the book.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public CitationPublicationInfoPublishedInComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name of the database or title of the book.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name of the database or title of the book.
         */
        public CitationPublicationInfoPublishedInComponent setName(String value) { 
          if (Utilities.noString(value))
            this.name = null;
          else {
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #publisher} (Name of the publisher.)
         */
        public Reference getPublisher() { 
          if (this.publisher == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPublicationInfoPublishedInComponent.publisher");
            else if (Configuration.doAutoCreate())
              this.publisher = new Reference(); // cc
          return this.publisher;
        }

        public boolean hasPublisher() { 
          return this.publisher != null && !this.publisher.isEmpty();
        }

        /**
         * @param value {@link #publisher} (Name of the publisher.)
         */
        public CitationPublicationInfoPublishedInComponent setPublisher(Reference value) { 
          this.publisher = value;
          return this;
        }

        /**
         * @return {@link #publisherLocation} (Geographic location of the publisher.). This is the underlying object with id, value and extensions. The accessor "getPublisherLocation" gives direct access to the value
         */
        public StringType getPublisherLocationElement() { 
          if (this.publisherLocation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPublicationInfoPublishedInComponent.publisherLocation");
            else if (Configuration.doAutoCreate())
              this.publisherLocation = new StringType(); // bb
          return this.publisherLocation;
        }

        public boolean hasPublisherLocationElement() { 
          return this.publisherLocation != null && !this.publisherLocation.isEmpty();
        }

        public boolean hasPublisherLocation() { 
          return this.publisherLocation != null && !this.publisherLocation.isEmpty();
        }

        /**
         * @param value {@link #publisherLocation} (Geographic location of the publisher.). This is the underlying object with id, value and extensions. The accessor "getPublisherLocation" gives direct access to the value
         */
        public CitationPublicationInfoPublishedInComponent setPublisherLocationElement(StringType value) { 
          this.publisherLocation = value;
          return this;
        }

        /**
         * @return Geographic location of the publisher.
         */
        public String getPublisherLocation() { 
          return this.publisherLocation == null ? null : this.publisherLocation.getValue();
        }

        /**
         * @param value Geographic location of the publisher.
         */
        public CitationPublicationInfoPublishedInComponent setPublisherLocation(String value) { 
          if (Utilities.noString(value))
            this.publisherLocation = null;
          else {
            if (this.publisherLocation == null)
              this.publisherLocation = new StringType();
            this.publisherLocation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #startDate} (When the database was first available or when the book was published.). This is the underlying object with id, value and extensions. The accessor "getStartDate" gives direct access to the value
         */
        public DateType getStartDateElement() { 
          if (this.startDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPublicationInfoPublishedInComponent.startDate");
            else if (Configuration.doAutoCreate())
              this.startDate = new DateType(); // bb
          return this.startDate;
        }

        public boolean hasStartDateElement() { 
          return this.startDate != null && !this.startDate.isEmpty();
        }

        public boolean hasStartDate() { 
          return this.startDate != null && !this.startDate.isEmpty();
        }

        /**
         * @param value {@link #startDate} (When the database was first available or when the book was published.). This is the underlying object with id, value and extensions. The accessor "getStartDate" gives direct access to the value
         */
        public CitationPublicationInfoPublishedInComponent setStartDateElement(DateType value) { 
          this.startDate = value;
          return this;
        }

        /**
         * @return When the database was first available or when the book was published.
         */
        public Date getStartDate() { 
          return this.startDate == null ? null : this.startDate.getValue();
        }

        /**
         * @param value When the database was first available or when the book was published.
         */
        public CitationPublicationInfoPublishedInComponent setStartDate(Date value) { 
          if (value == null)
            this.startDate = null;
          else {
            if (this.startDate == null)
              this.startDate = new DateType();
            this.startDate.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Database or book.", 0, 1, type));
          children.add(new Property("identifier", "Identifier", "Identifiers may include ISBN (International Standard Book Number) for books.", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("name", "string", "Name of the database or title of the book.", 0, 1, name));
          children.add(new Property("publisher", "Reference(Organization)", "Name of the publisher.", 0, 1, publisher));
          children.add(new Property("publisherLocation", "string", "Geographic location of the publisher.", 0, 1, publisherLocation));
          children.add(new Property("startDate", "date", "When the database was first available or when the book was published.", 0, 1, startDate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Database or book.", 0, 1, type);
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers may include ISBN (International Standard Book Number) for books.", 0, java.lang.Integer.MAX_VALUE, identifier);
          case 3373707: /*name*/  return new Property("name", "string", "Name of the database or title of the book.", 0, 1, name);
          case 1447404028: /*publisher*/  return new Property("publisher", "Reference(Organization)", "Name of the publisher.", 0, 1, publisher);
          case -1281627695: /*publisherLocation*/  return new Property("publisherLocation", "string", "Geographic location of the publisher.", 0, 1, publisherLocation);
          case -2129778896: /*startDate*/  return new Property("startDate", "date", "When the database was first available or when the book was published.", 0, 1, startDate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // Reference
        case -1281627695: /*publisherLocation*/ return this.publisherLocation == null ? new Base[0] : new Base[] {this.publisherLocation}; // StringType
        case -2129778896: /*startDate*/ return this.startDate == null ? new Base[0] : new Base[] {this.startDate}; // DateType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 1447404028: // publisher
          this.publisher = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1281627695: // publisherLocation
          this.publisherLocation = TypeConvertor.castToString(value); // StringType
          return value;
        case -2129778896: // startDate
          this.startDate = TypeConvertor.castToDate(value); // DateType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("publisherLocation")) {
          this.publisherLocation = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("startDate")) {
          this.startDate = TypeConvertor.castToDate(value); // DateType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1618432855:  return addIdentifier(); 
        case 3373707:  return getNameElement();
        case 1447404028:  return getPublisher();
        case -1281627695:  return getPublisherLocationElement();
        case -2129778896:  return getStartDateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 1447404028: /*publisher*/ return new String[] {"Reference"};
        case -1281627695: /*publisherLocation*/ return new String[] {"string"};
        case -2129778896: /*startDate*/ return new String[] {"date"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.publicationInfo.publishedIn.name");
        }
        else if (name.equals("publisher")) {
          this.publisher = new Reference();
          return this.publisher;
        }
        else if (name.equals("publisherLocation")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.publicationInfo.publishedIn.publisherLocation");
        }
        else if (name.equals("startDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.publicationInfo.publishedIn.startDate");
        }
        else
          return super.addChild(name);
      }

      public CitationPublicationInfoPublishedInComponent copy() {
        CitationPublicationInfoPublishedInComponent dst = new CitationPublicationInfoPublishedInComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationPublicationInfoPublishedInComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.name = name == null ? null : name.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        dst.publisherLocation = publisherLocation == null ? null : publisherLocation.copy();
        dst.startDate = startDate == null ? null : startDate.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationPublicationInfoPublishedInComponent))
          return false;
        CitationPublicationInfoPublishedInComponent o = (CitationPublicationInfoPublishedInComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(identifier, o.identifier, true) && compareDeep(name, o.name, true)
           && compareDeep(publisher, o.publisher, true) && compareDeep(publisherLocation, o.publisherLocation, true)
           && compareDeep(startDate, o.startDate, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationPublicationInfoPublishedInComponent))
          return false;
        CitationPublicationInfoPublishedInComponent o = (CitationPublicationInfoPublishedInComponent) other_;
        return compareValues(name, o.name, true) && compareValues(publisherLocation, o.publisherLocation, true)
           && compareValues(startDate, o.startDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, identifier, name, publisher
          , publisherLocation, startDate);
      }

  public String fhirType() {
    return "Citation.publicationInfo.publishedIn";

  }

  }

    @Block()
    public static class CitationAlternativeTitleComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used to express the reason and specific aspect for the variant title, such as language and specific language.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to express the reason and specific aspect for the variant title, such as language", formalDefinition="Used to express the reason and specific aspect for the variant title, such as language and specific language." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/alternative-title-type")
        protected CodeableConcept type;

        /**
         * Used to express the specific language.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to express the specific language", formalDefinition="Used to express the specific language." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
        protected CodeableConcept language;

        /**
         * Full variant title of the article.
         */
        @Child(name = "title", type = {MarkdownType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Full variant title of the article", formalDefinition="Full variant title of the article." )
        protected MarkdownType title;

        private static final long serialVersionUID = -552795869L;

    /**
     * Constructor
     */
      public CitationAlternativeTitleComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationAlternativeTitleComponent(String title) {
        super();
        this.setTitle(title);
      }

        /**
         * @return {@link #type} (Used to express the reason and specific aspect for the variant title, such as language and specific language.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeTitleComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Used to express the reason and specific aspect for the variant title, such as language and specific language.)
         */
        public CitationAlternativeTitleComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #language} (Used to express the specific language.)
         */
        public CodeableConcept getLanguage() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeTitleComponent.language");
            else if (Configuration.doAutoCreate())
              this.language = new CodeableConcept(); // cc
          return this.language;
        }

        public boolean hasLanguage() { 
          return this.language != null && !this.language.isEmpty();
        }

        /**
         * @param value {@link #language} (Used to express the specific language.)
         */
        public CitationAlternativeTitleComponent setLanguage(CodeableConcept value) { 
          this.language = value;
          return this;
        }

        /**
         * @return {@link #title} (Full variant title of the article.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public MarkdownType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeTitleComponent.title");
            else if (Configuration.doAutoCreate())
              this.title = new MarkdownType(); // bb
          return this.title;
        }

        public boolean hasTitleElement() { 
          return this.title != null && !this.title.isEmpty();
        }

        public boolean hasTitle() { 
          return this.title != null && !this.title.isEmpty();
        }

        /**
         * @param value {@link #title} (Full variant title of the article.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public CitationAlternativeTitleComponent setTitleElement(MarkdownType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return Full variant title of the article.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value Full variant title of the article.
         */
        public CitationAlternativeTitleComponent setTitle(String value) { 
            if (this.title == null)
              this.title = new MarkdownType();
            this.title.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Used to express the reason and specific aspect for the variant title, such as language and specific language.", 0, 1, type));
          children.add(new Property("language", "CodeableConcept", "Used to express the specific language.", 0, 1, language));
          children.add(new Property("title", "markdown", "Full variant title of the article.", 0, 1, title));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Used to express the reason and specific aspect for the variant title, such as language and specific language.", 0, 1, type);
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "Used to express the specific language.", 0, 1, language);
          case 110371416: /*title*/  return new Property("title", "markdown", "Full variant title of the article.", 0, 1, title);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CodeableConcept
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1613589672: // language
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("language")) {
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1613589672:  return getLanguage();
        case 110371416:  return getTitleElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1613589672: /*language*/ return new String[] {"CodeableConcept"};
        case 110371416: /*title*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("language")) {
          this.language = new CodeableConcept();
          return this.language;
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeTitle.title");
        }
        else
          return super.addChild(name);
      }

      public CitationAlternativeTitleComponent copy() {
        CitationAlternativeTitleComponent dst = new CitationAlternativeTitleComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAlternativeTitleComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.language = language == null ? null : language.copy();
        dst.title = title == null ? null : title.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeTitleComponent))
          return false;
        CitationAlternativeTitleComponent o = (CitationAlternativeTitleComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(language, o.language, true) && compareDeep(title, o.title, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeTitleComponent))
          return false;
        CitationAlternativeTitleComponent o = (CitationAlternativeTitleComponent) other_;
        return compareValues(title, o.title, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, language, title);
      }

  public String fhirType() {
    return "Citation.alternativeTitle";

  }

  }

    @Block()
    public static class CitationPaginationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used for full display of pagination.
         */
        @Child(name = "pageString", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for full display of pagination", formalDefinition="Used for full display of pagination." )
        protected StringType pageString;

        /**
         * Used for isolated representation of first page.
         */
        @Child(name = "firstPage", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for isolated representation of first page", formalDefinition="Used for isolated representation of first page." )
        protected StringType firstPage;

        /**
         * Used for isolated representation of last page.
         */
        @Child(name = "lastPage", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for isolated representation of last page", formalDefinition="Used for isolated representation of last page." )
        protected StringType lastPage;

        private static final long serialVersionUID = -690699049L;

    /**
     * Constructor
     */
      public CitationPaginationComponent() {
        super();
      }

        /**
         * @return {@link #pageString} (Used for full display of pagination.). This is the underlying object with id, value and extensions. The accessor "getPageString" gives direct access to the value
         */
        public StringType getPageStringElement() { 
          if (this.pageString == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPaginationComponent.pageString");
            else if (Configuration.doAutoCreate())
              this.pageString = new StringType(); // bb
          return this.pageString;
        }

        public boolean hasPageStringElement() { 
          return this.pageString != null && !this.pageString.isEmpty();
        }

        public boolean hasPageString() { 
          return this.pageString != null && !this.pageString.isEmpty();
        }

        /**
         * @param value {@link #pageString} (Used for full display of pagination.). This is the underlying object with id, value and extensions. The accessor "getPageString" gives direct access to the value
         */
        public CitationPaginationComponent setPageStringElement(StringType value) { 
          this.pageString = value;
          return this;
        }

        /**
         * @return Used for full display of pagination.
         */
        public String getPageString() { 
          return this.pageString == null ? null : this.pageString.getValue();
        }

        /**
         * @param value Used for full display of pagination.
         */
        public CitationPaginationComponent setPageString(String value) { 
          if (Utilities.noString(value))
            this.pageString = null;
          else {
            if (this.pageString == null)
              this.pageString = new StringType();
            this.pageString.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #firstPage} (Used for isolated representation of first page.). This is the underlying object with id, value and extensions. The accessor "getFirstPage" gives direct access to the value
         */
        public StringType getFirstPageElement() { 
          if (this.firstPage == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPaginationComponent.firstPage");
            else if (Configuration.doAutoCreate())
              this.firstPage = new StringType(); // bb
          return this.firstPage;
        }

        public boolean hasFirstPageElement() { 
          return this.firstPage != null && !this.firstPage.isEmpty();
        }

        public boolean hasFirstPage() { 
          return this.firstPage != null && !this.firstPage.isEmpty();
        }

        /**
         * @param value {@link #firstPage} (Used for isolated representation of first page.). This is the underlying object with id, value and extensions. The accessor "getFirstPage" gives direct access to the value
         */
        public CitationPaginationComponent setFirstPageElement(StringType value) { 
          this.firstPage = value;
          return this;
        }

        /**
         * @return Used for isolated representation of first page.
         */
        public String getFirstPage() { 
          return this.firstPage == null ? null : this.firstPage.getValue();
        }

        /**
         * @param value Used for isolated representation of first page.
         */
        public CitationPaginationComponent setFirstPage(String value) { 
          if (Utilities.noString(value))
            this.firstPage = null;
          else {
            if (this.firstPage == null)
              this.firstPage = new StringType();
            this.firstPage.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #lastPage} (Used for isolated representation of last page.). This is the underlying object with id, value and extensions. The accessor "getLastPage" gives direct access to the value
         */
        public StringType getLastPageElement() { 
          if (this.lastPage == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationPaginationComponent.lastPage");
            else if (Configuration.doAutoCreate())
              this.lastPage = new StringType(); // bb
          return this.lastPage;
        }

        public boolean hasLastPageElement() { 
          return this.lastPage != null && !this.lastPage.isEmpty();
        }

        public boolean hasLastPage() { 
          return this.lastPage != null && !this.lastPage.isEmpty();
        }

        /**
         * @param value {@link #lastPage} (Used for isolated representation of last page.). This is the underlying object with id, value and extensions. The accessor "getLastPage" gives direct access to the value
         */
        public CitationPaginationComponent setLastPageElement(StringType value) { 
          this.lastPage = value;
          return this;
        }

        /**
         * @return Used for isolated representation of last page.
         */
        public String getLastPage() { 
          return this.lastPage == null ? null : this.lastPage.getValue();
        }

        /**
         * @param value Used for isolated representation of last page.
         */
        public CitationPaginationComponent setLastPage(String value) { 
          if (Utilities.noString(value))
            this.lastPage = null;
          else {
            if (this.lastPage == null)
              this.lastPage = new StringType();
            this.lastPage.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("pageString", "string", "Used for full display of pagination.", 0, 1, pageString));
          children.add(new Property("firstPage", "string", "Used for isolated representation of first page.", 0, 1, firstPage));
          children.add(new Property("lastPage", "string", "Used for isolated representation of last page.", 0, 1, lastPage));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1287145344: /*pageString*/  return new Property("pageString", "string", "Used for full display of pagination.", 0, 1, pageString);
          case 132895071: /*firstPage*/  return new Property("firstPage", "string", "Used for isolated representation of first page.", 0, 1, firstPage);
          case -1459540411: /*lastPage*/  return new Property("lastPage", "string", "Used for isolated representation of last page.", 0, 1, lastPage);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1287145344: /*pageString*/ return this.pageString == null ? new Base[0] : new Base[] {this.pageString}; // StringType
        case 132895071: /*firstPage*/ return this.firstPage == null ? new Base[0] : new Base[] {this.firstPage}; // StringType
        case -1459540411: /*lastPage*/ return this.lastPage == null ? new Base[0] : new Base[] {this.lastPage}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1287145344: // pageString
          this.pageString = TypeConvertor.castToString(value); // StringType
          return value;
        case 132895071: // firstPage
          this.firstPage = TypeConvertor.castToString(value); // StringType
          return value;
        case -1459540411: // lastPage
          this.lastPage = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("pageString")) {
          this.pageString = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("firstPage")) {
          this.firstPage = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("lastPage")) {
          this.lastPage = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1287145344:  return getPageStringElement();
        case 132895071:  return getFirstPageElement();
        case -1459540411:  return getLastPageElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1287145344: /*pageString*/ return new String[] {"string"};
        case 132895071: /*firstPage*/ return new String[] {"string"};
        case -1459540411: /*lastPage*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("pageString")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.pagination.pageString");
        }
        else if (name.equals("firstPage")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.pagination.firstPage");
        }
        else if (name.equals("lastPage")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.pagination.lastPage");
        }
        else
          return super.addChild(name);
      }

      public CitationPaginationComponent copy() {
        CitationPaginationComponent dst = new CitationPaginationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationPaginationComponent dst) {
        super.copyValues(dst);
        dst.pageString = pageString == null ? null : pageString.copy();
        dst.firstPage = firstPage == null ? null : firstPage.copy();
        dst.lastPage = lastPage == null ? null : lastPage.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationPaginationComponent))
          return false;
        CitationPaginationComponent o = (CitationPaginationComponent) other_;
        return compareDeep(pageString, o.pageString, true) && compareDeep(firstPage, o.firstPage, true)
           && compareDeep(lastPage, o.lastPage, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationPaginationComponent))
          return false;
        CitationPaginationComponent o = (CitationPaginationComponent) other_;
        return compareValues(pageString, o.pageString, true) && compareValues(firstPage, o.firstPage, true)
           && compareValues(lastPage, o.lastPage, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(pageString, firstPage, lastPage
          );
      }

  public String fhirType() {
    return "Citation.pagination";

  }

  }

    @Block()
    public static class CitationArticleUrlComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Code the reason for different URLs, eg abstract and full-text.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code the reason for different URLs, eg abstract and full-text", formalDefinition="Code the reason for different URLs, eg abstract and full-text." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/article-url-type")
        protected CodeableConcept type;

        /**
         * The specific URL.
         */
        @Child(name = "url", type = {UriType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The specific URL", formalDefinition="The specific URL." )
        protected UriType url;

        private static final long serialVersionUID = 397204034L;

    /**
     * Constructor
     */
      public CitationArticleUrlComponent() {
        super();
      }

        /**
         * @return {@link #type} (Code the reason for different URLs, eg abstract and full-text.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationArticleUrlComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Code the reason for different URLs, eg abstract and full-text.)
         */
        public CitationArticleUrlComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #url} (The specific URL.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public UriType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationArticleUrlComponent.url");
            else if (Configuration.doAutoCreate())
              this.url = new UriType(); // bb
          return this.url;
        }

        public boolean hasUrlElement() { 
          return this.url != null && !this.url.isEmpty();
        }

        public boolean hasUrl() { 
          return this.url != null && !this.url.isEmpty();
        }

        /**
         * @param value {@link #url} (The specific URL.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public CitationArticleUrlComponent setUrlElement(UriType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return The specific URL.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value The specific URL.
         */
        public CitationArticleUrlComponent setUrl(String value) { 
          if (Utilities.noString(value))
            this.url = null;
          else {
            if (this.url == null)
              this.url = new UriType();
            this.url.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Code the reason for different URLs, eg abstract and full-text.", 0, 1, type));
          children.add(new Property("url", "uri", "The specific URL.", 0, 1, url));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Code the reason for different URLs, eg abstract and full-text.", 0, 1, type);
          case 116079: /*url*/  return new Property("url", "uri", "The specific URL.", 0, 1, url);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 116079:  return getUrlElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 116079: /*url*/ return new String[] {"uri"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.articleUrl.url");
        }
        else
          return super.addChild(name);
      }

      public CitationArticleUrlComponent copy() {
        CitationArticleUrlComponent dst = new CitationArticleUrlComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationArticleUrlComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.url = url == null ? null : url.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationArticleUrlComponent))
          return false;
        CitationArticleUrlComponent o = (CitationArticleUrlComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(url, o.url, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationArticleUrlComponent))
          return false;
        CitationArticleUrlComponent o = (CitationArticleUrlComponent) other_;
        return compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, url);
      }

  public String fhirType() {
    return "Citation.articleUrl";

  }

  }

    @Block()
    public static class CitationAlternativeAbstractComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used to express the reason for the variant abstract, such as language.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to express the reason for the variant abstract, such as language", formalDefinition="Used to express the reason for the variant abstract, such as language." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/alternative-title-type")
        protected CodeableConcept type;

        /**
         * Used to express the specific language.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to express the specific language", formalDefinition="Used to express the specific language." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
        protected CodeableConcept language;

        /**
         * Full variant abstract of the article.
         */
        @Child(name = "abstract", type = {MarkdownType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Full variant abstract of the article", formalDefinition="Full variant abstract of the article." )
        protected MarkdownType abstract_;

        /**
         * Copyright information for the abstract text.
         */
        @Child(name = "abstractCopyright", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Variant abstract copyright", formalDefinition="Copyright information for the abstract text." )
        protected MarkdownType abstractCopyright;

        private static final long serialVersionUID = 1805874682L;

    /**
     * Constructor
     */
      public CitationAlternativeAbstractComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationAlternativeAbstractComponent(String abstract_) {
        super();
        this.setAbstract(abstract_);
      }

        /**
         * @return {@link #type} (Used to express the reason for the variant abstract, such as language.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeAbstractComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Used to express the reason for the variant abstract, such as language.)
         */
        public CitationAlternativeAbstractComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #language} (Used to express the specific language.)
         */
        public CodeableConcept getLanguage() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeAbstractComponent.language");
            else if (Configuration.doAutoCreate())
              this.language = new CodeableConcept(); // cc
          return this.language;
        }

        public boolean hasLanguage() { 
          return this.language != null && !this.language.isEmpty();
        }

        /**
         * @param value {@link #language} (Used to express the specific language.)
         */
        public CitationAlternativeAbstractComponent setLanguage(CodeableConcept value) { 
          this.language = value;
          return this;
        }

        /**
         * @return {@link #abstract_} (Full variant abstract of the article.). This is the underlying object with id, value and extensions. The accessor "getAbstract" gives direct access to the value
         */
        public MarkdownType getAbstractElement() { 
          if (this.abstract_ == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeAbstractComponent.abstract_");
            else if (Configuration.doAutoCreate())
              this.abstract_ = new MarkdownType(); // bb
          return this.abstract_;
        }

        public boolean hasAbstractElement() { 
          return this.abstract_ != null && !this.abstract_.isEmpty();
        }

        public boolean hasAbstract() { 
          return this.abstract_ != null && !this.abstract_.isEmpty();
        }

        /**
         * @param value {@link #abstract_} (Full variant abstract of the article.). This is the underlying object with id, value and extensions. The accessor "getAbstract" gives direct access to the value
         */
        public CitationAlternativeAbstractComponent setAbstractElement(MarkdownType value) { 
          this.abstract_ = value;
          return this;
        }

        /**
         * @return Full variant abstract of the article.
         */
        public String getAbstract() { 
          return this.abstract_ == null ? null : this.abstract_.getValue();
        }

        /**
         * @param value Full variant abstract of the article.
         */
        public CitationAlternativeAbstractComponent setAbstract(String value) { 
            if (this.abstract_ == null)
              this.abstract_ = new MarkdownType();
            this.abstract_.setValue(value);
          return this;
        }

        /**
         * @return {@link #abstractCopyright} (Copyright information for the abstract text.). This is the underlying object with id, value and extensions. The accessor "getAbstractCopyright" gives direct access to the value
         */
        public MarkdownType getAbstractCopyrightElement() { 
          if (this.abstractCopyright == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeAbstractComponent.abstractCopyright");
            else if (Configuration.doAutoCreate())
              this.abstractCopyright = new MarkdownType(); // bb
          return this.abstractCopyright;
        }

        public boolean hasAbstractCopyrightElement() { 
          return this.abstractCopyright != null && !this.abstractCopyright.isEmpty();
        }

        public boolean hasAbstractCopyright() { 
          return this.abstractCopyright != null && !this.abstractCopyright.isEmpty();
        }

        /**
         * @param value {@link #abstractCopyright} (Copyright information for the abstract text.). This is the underlying object with id, value and extensions. The accessor "getAbstractCopyright" gives direct access to the value
         */
        public CitationAlternativeAbstractComponent setAbstractCopyrightElement(MarkdownType value) { 
          this.abstractCopyright = value;
          return this;
        }

        /**
         * @return Copyright information for the abstract text.
         */
        public String getAbstractCopyright() { 
          return this.abstractCopyright == null ? null : this.abstractCopyright.getValue();
        }

        /**
         * @param value Copyright information for the abstract text.
         */
        public CitationAlternativeAbstractComponent setAbstractCopyright(String value) { 
          if (value == null)
            this.abstractCopyright = null;
          else {
            if (this.abstractCopyright == null)
              this.abstractCopyright = new MarkdownType();
            this.abstractCopyright.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Used to express the reason for the variant abstract, such as language.", 0, 1, type));
          children.add(new Property("language", "CodeableConcept", "Used to express the specific language.", 0, 1, language));
          children.add(new Property("abstract", "markdown", "Full variant abstract of the article.", 0, 1, abstract_));
          children.add(new Property("abstractCopyright", "markdown", "Copyright information for the abstract text.", 0, 1, abstractCopyright));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Used to express the reason for the variant abstract, such as language.", 0, 1, type);
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "Used to express the specific language.", 0, 1, language);
          case 1732898850: /*abstract*/  return new Property("abstract", "markdown", "Full variant abstract of the article.", 0, 1, abstract_);
          case -656627259: /*abstractCopyright*/  return new Property("abstractCopyright", "markdown", "Copyright information for the abstract text.", 0, 1, abstractCopyright);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CodeableConcept
        case 1732898850: /*abstract*/ return this.abstract_ == null ? new Base[0] : new Base[] {this.abstract_}; // MarkdownType
        case -656627259: /*abstractCopyright*/ return this.abstractCopyright == null ? new Base[0] : new Base[] {this.abstractCopyright}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1613589672: // language
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1732898850: // abstract
          this.abstract_ = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -656627259: // abstractCopyright
          this.abstractCopyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("language")) {
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("abstract")) {
          this.abstract_ = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("abstractCopyright")) {
          this.abstractCopyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1613589672:  return getLanguage();
        case 1732898850:  return getAbstractElement();
        case -656627259:  return getAbstractCopyrightElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1613589672: /*language*/ return new String[] {"CodeableConcept"};
        case 1732898850: /*abstract*/ return new String[] {"markdown"};
        case -656627259: /*abstractCopyright*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("language")) {
          this.language = new CodeableConcept();
          return this.language;
        }
        else if (name.equals("abstract")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeAbstract.abstract");
        }
        else if (name.equals("abstractCopyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeAbstract.abstractCopyright");
        }
        else
          return super.addChild(name);
      }

      public CitationAlternativeAbstractComponent copy() {
        CitationAlternativeAbstractComponent dst = new CitationAlternativeAbstractComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAlternativeAbstractComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.language = language == null ? null : language.copy();
        dst.abstract_ = abstract_ == null ? null : abstract_.copy();
        dst.abstractCopyright = abstractCopyright == null ? null : abstractCopyright.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeAbstractComponent))
          return false;
        CitationAlternativeAbstractComponent o = (CitationAlternativeAbstractComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(language, o.language, true) && compareDeep(abstract_, o.abstract_, true)
           && compareDeep(abstractCopyright, o.abstractCopyright, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeAbstractComponent))
          return false;
        CitationAlternativeAbstractComponent o = (CitationAlternativeAbstractComponent) other_;
        return compareValues(abstract_, o.abstract_, true) && compareValues(abstractCopyright, o.abstractCopyright, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, language, abstract_
          , abstractCopyright);
      }

  public String fhirType() {
    return "Citation.alternativeAbstract";

  }

  }

    @Block()
    public static class CitationContributorshipComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates if the list includes all authors and/or contributors.
         */
        @Child(name = "complete", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates if the list includes all authors and/or contributors", formalDefinition="Indicates if the list includes all authors and/or contributors." )
        protected BooleanType complete;

        /**
         * An individual entity named in the author list or contributor list.
         */
        @Child(name = "entry", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="An individual entity named in the list", formalDefinition="An individual entity named in the author list or contributor list." )
        protected List<CitationContributorshipEntryComponent> entry;

        /**
         * Used to record a display of the author/contributor list without separate coding for each list member.
         */
        @Child(name = "summary", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Used to record a display of the author/contributor list without separate coding for each list member", formalDefinition="Used to record a display of the author/contributor list without separate coding for each list member." )
        protected List<CitationContributorshipSummaryComponent> summary;

        private static final long serialVersionUID = -1399349675L;

    /**
     * Constructor
     */
      public CitationContributorshipComponent() {
        super();
      }

        /**
         * @return {@link #complete} (Indicates if the list includes all authors and/or contributors.). This is the underlying object with id, value and extensions. The accessor "getComplete" gives direct access to the value
         */
        public BooleanType getCompleteElement() { 
          if (this.complete == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipComponent.complete");
            else if (Configuration.doAutoCreate())
              this.complete = new BooleanType(); // bb
          return this.complete;
        }

        public boolean hasCompleteElement() { 
          return this.complete != null && !this.complete.isEmpty();
        }

        public boolean hasComplete() { 
          return this.complete != null && !this.complete.isEmpty();
        }

        /**
         * @param value {@link #complete} (Indicates if the list includes all authors and/or contributors.). This is the underlying object with id, value and extensions. The accessor "getComplete" gives direct access to the value
         */
        public CitationContributorshipComponent setCompleteElement(BooleanType value) { 
          this.complete = value;
          return this;
        }

        /**
         * @return Indicates if the list includes all authors and/or contributors.
         */
        public boolean getComplete() { 
          return this.complete == null || this.complete.isEmpty() ? false : this.complete.getValue();
        }

        /**
         * @param value Indicates if the list includes all authors and/or contributors.
         */
        public CitationContributorshipComponent setComplete(boolean value) { 
            if (this.complete == null)
              this.complete = new BooleanType();
            this.complete.setValue(value);
          return this;
        }

        /**
         * @return {@link #entry} (An individual entity named in the author list or contributor list.)
         */
        public List<CitationContributorshipEntryComponent> getEntry() { 
          if (this.entry == null)
            this.entry = new ArrayList<CitationContributorshipEntryComponent>();
          return this.entry;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorshipComponent setEntry(List<CitationContributorshipEntryComponent> theEntry) { 
          this.entry = theEntry;
          return this;
        }

        public boolean hasEntry() { 
          if (this.entry == null)
            return false;
          for (CitationContributorshipEntryComponent item : this.entry)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationContributorshipEntryComponent addEntry() { //3
          CitationContributorshipEntryComponent t = new CitationContributorshipEntryComponent();
          if (this.entry == null)
            this.entry = new ArrayList<CitationContributorshipEntryComponent>();
          this.entry.add(t);
          return t;
        }

        public CitationContributorshipComponent addEntry(CitationContributorshipEntryComponent t) { //3
          if (t == null)
            return this;
          if (this.entry == null)
            this.entry = new ArrayList<CitationContributorshipEntryComponent>();
          this.entry.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #entry}, creating it if it does not already exist {3}
         */
        public CitationContributorshipEntryComponent getEntryFirstRep() { 
          if (getEntry().isEmpty()) {
            addEntry();
          }
          return getEntry().get(0);
        }

        /**
         * @return {@link #summary} (Used to record a display of the author/contributor list without separate coding for each list member.)
         */
        public List<CitationContributorshipSummaryComponent> getSummary() { 
          if (this.summary == null)
            this.summary = new ArrayList<CitationContributorshipSummaryComponent>();
          return this.summary;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorshipComponent setSummary(List<CitationContributorshipSummaryComponent> theSummary) { 
          this.summary = theSummary;
          return this;
        }

        public boolean hasSummary() { 
          if (this.summary == null)
            return false;
          for (CitationContributorshipSummaryComponent item : this.summary)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationContributorshipSummaryComponent addSummary() { //3
          CitationContributorshipSummaryComponent t = new CitationContributorshipSummaryComponent();
          if (this.summary == null)
            this.summary = new ArrayList<CitationContributorshipSummaryComponent>();
          this.summary.add(t);
          return t;
        }

        public CitationContributorshipComponent addSummary(CitationContributorshipSummaryComponent t) { //3
          if (t == null)
            return this;
          if (this.summary == null)
            this.summary = new ArrayList<CitationContributorshipSummaryComponent>();
          this.summary.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #summary}, creating it if it does not already exist {3}
         */
        public CitationContributorshipSummaryComponent getSummaryFirstRep() { 
          if (getSummary().isEmpty()) {
            addSummary();
          }
          return getSummary().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("complete", "boolean", "Indicates if the list includes all authors and/or contributors.", 0, 1, complete));
          children.add(new Property("entry", "", "An individual entity named in the author list or contributor list.", 0, java.lang.Integer.MAX_VALUE, entry));
          children.add(new Property("summary", "", "Used to record a display of the author/contributor list without separate coding for each list member.", 0, java.lang.Integer.MAX_VALUE, summary));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -599445191: /*complete*/  return new Property("complete", "boolean", "Indicates if the list includes all authors and/or contributors.", 0, 1, complete);
          case 96667762: /*entry*/  return new Property("entry", "", "An individual entity named in the author list or contributor list.", 0, java.lang.Integer.MAX_VALUE, entry);
          case -1857640538: /*summary*/  return new Property("summary", "", "Used to record a display of the author/contributor list without separate coding for each list member.", 0, java.lang.Integer.MAX_VALUE, summary);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -599445191: /*complete*/ return this.complete == null ? new Base[0] : new Base[] {this.complete}; // BooleanType
        case 96667762: /*entry*/ return this.entry == null ? new Base[0] : this.entry.toArray(new Base[this.entry.size()]); // CitationContributorshipEntryComponent
        case -1857640538: /*summary*/ return this.summary == null ? new Base[0] : this.summary.toArray(new Base[this.summary.size()]); // CitationContributorshipSummaryComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -599445191: // complete
          this.complete = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 96667762: // entry
          this.getEntry().add((CitationContributorshipEntryComponent) value); // CitationContributorshipEntryComponent
          return value;
        case -1857640538: // summary
          this.getSummary().add((CitationContributorshipSummaryComponent) value); // CitationContributorshipSummaryComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("complete")) {
          this.complete = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("entry")) {
          this.getEntry().add((CitationContributorshipEntryComponent) value);
        } else if (name.equals("summary")) {
          this.getSummary().add((CitationContributorshipSummaryComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -599445191:  return getCompleteElement();
        case 96667762:  return addEntry(); 
        case -1857640538:  return addSummary(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -599445191: /*complete*/ return new String[] {"boolean"};
        case 96667762: /*entry*/ return new String[] {};
        case -1857640538: /*summary*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("complete")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorship.complete");
        }
        else if (name.equals("entry")) {
          return addEntry();
        }
        else if (name.equals("summary")) {
          return addSummary();
        }
        else
          return super.addChild(name);
      }

      public CitationContributorshipComponent copy() {
        CitationContributorshipComponent dst = new CitationContributorshipComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationContributorshipComponent dst) {
        super.copyValues(dst);
        dst.complete = complete == null ? null : complete.copy();
        if (entry != null) {
          dst.entry = new ArrayList<CitationContributorshipEntryComponent>();
          for (CitationContributorshipEntryComponent i : entry)
            dst.entry.add(i.copy());
        };
        if (summary != null) {
          dst.summary = new ArrayList<CitationContributorshipSummaryComponent>();
          for (CitationContributorshipSummaryComponent i : summary)
            dst.summary.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationContributorshipComponent))
          return false;
        CitationContributorshipComponent o = (CitationContributorshipComponent) other_;
        return compareDeep(complete, o.complete, true) && compareDeep(entry, o.entry, true) && compareDeep(summary, o.summary, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationContributorshipComponent))
          return false;
        CitationContributorshipComponent o = (CitationContributorshipComponent) other_;
        return compareValues(complete, o.complete, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(complete, entry, summary
          );
      }

  public String fhirType() {
    return "Citation.contributorship";

  }

  }

    @Block()
    public static class CitationContributorshipEntryComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A name associated with the individual.
         */
        @Child(name = "name", type = {HumanName.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A name associated with the person", formalDefinition="A name associated with the individual." )
        protected HumanName name;

        /**
         * Initials for forename.
         */
        @Child(name = "initials", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Initials for forename", formalDefinition="Initials for forename." )
        protected StringType initials;

        /**
         * Used for collective or corporate name as an author.
         */
        @Child(name = "collectiveName", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for collective or corporate name as an author", formalDefinition="Used for collective or corporate name as an author." )
        protected StringType collectiveName;

        /**
         * Unique person identifier.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Author identifier, eg ORCID", formalDefinition="Unique person identifier." )
        protected List<Identifier> identifier;

        /**
         * Organization affiliated with the entity.
         */
        @Child(name = "affiliationInfo", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Organizational affiliation", formalDefinition="Organization affiliated with the entity." )
        protected List<CitationContributorshipEntryAffiliationInfoComponent> affiliationInfo;

        /**
         * Physical mailing address for the author or contributor.
         */
        @Child(name = "address", type = {Address.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Physical mailing address", formalDefinition="Physical mailing address for the author or contributor." )
        protected List<Address> address;

        /**
         * Email or telephone contact methods for the author or contributor.
         */
        @Child(name = "telecom", type = {ContactPoint.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Email or telephone contact methods for", formalDefinition="Email or telephone contact methods for the author or contributor." )
        protected List<ContactPoint> telecom;

        /**
         * This element identifies the specific nature of an individual’s contribution with respect to the cited work.
         */
        @Child(name = "contribution", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The specific contributions", formalDefinition="This element identifies the specific nature of an individual’s contribution with respect to the cited work." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-contribution")
        protected List<CodeableConcept> contribution;

        /**
         * False, missing, or empty elements implies authorship.
         */
        @Child(name = "notAnAuthor", type = {BooleanType.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to identify non-author contributors", formalDefinition="False, missing, or empty elements implies authorship." )
        protected BooleanType notAnAuthor;

        /**
         * Indication of which author is the corresponding author for the article cited.
         */
        @Child(name = "correspondingAuthor", type = {BooleanType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indication of which author is the corresponding author for the article cited", formalDefinition="Indication of which author is the corresponding author for the article cited." )
        protected BooleanType correspondingAuthor;

        /**
         * Used to code order of authors.
         */
        @Child(name = "listOrder", type = {PositiveIntType.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to code order of authors", formalDefinition="Used to code order of authors." )
        protected PositiveIntType listOrder;

        private static final long serialVersionUID = -298558035L;

    /**
     * Constructor
     */
      public CitationContributorshipEntryComponent() {
        super();
      }

        /**
         * @return {@link #name} (A name associated with the individual.)
         */
        public HumanName getName() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipEntryComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new HumanName(); // cc
          return this.name;
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (A name associated with the individual.)
         */
        public CitationContributorshipEntryComponent setName(HumanName value) { 
          this.name = value;
          return this;
        }

        /**
         * @return {@link #initials} (Initials for forename.). This is the underlying object with id, value and extensions. The accessor "getInitials" gives direct access to the value
         */
        public StringType getInitialsElement() { 
          if (this.initials == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipEntryComponent.initials");
            else if (Configuration.doAutoCreate())
              this.initials = new StringType(); // bb
          return this.initials;
        }

        public boolean hasInitialsElement() { 
          return this.initials != null && !this.initials.isEmpty();
        }

        public boolean hasInitials() { 
          return this.initials != null && !this.initials.isEmpty();
        }

        /**
         * @param value {@link #initials} (Initials for forename.). This is the underlying object with id, value and extensions. The accessor "getInitials" gives direct access to the value
         */
        public CitationContributorshipEntryComponent setInitialsElement(StringType value) { 
          this.initials = value;
          return this;
        }

        /**
         * @return Initials for forename.
         */
        public String getInitials() { 
          return this.initials == null ? null : this.initials.getValue();
        }

        /**
         * @param value Initials for forename.
         */
        public CitationContributorshipEntryComponent setInitials(String value) { 
          if (Utilities.noString(value))
            this.initials = null;
          else {
            if (this.initials == null)
              this.initials = new StringType();
            this.initials.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #collectiveName} (Used for collective or corporate name as an author.). This is the underlying object with id, value and extensions. The accessor "getCollectiveName" gives direct access to the value
         */
        public StringType getCollectiveNameElement() { 
          if (this.collectiveName == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipEntryComponent.collectiveName");
            else if (Configuration.doAutoCreate())
              this.collectiveName = new StringType(); // bb
          return this.collectiveName;
        }

        public boolean hasCollectiveNameElement() { 
          return this.collectiveName != null && !this.collectiveName.isEmpty();
        }

        public boolean hasCollectiveName() { 
          return this.collectiveName != null && !this.collectiveName.isEmpty();
        }

        /**
         * @param value {@link #collectiveName} (Used for collective or corporate name as an author.). This is the underlying object with id, value and extensions. The accessor "getCollectiveName" gives direct access to the value
         */
        public CitationContributorshipEntryComponent setCollectiveNameElement(StringType value) { 
          this.collectiveName = value;
          return this;
        }

        /**
         * @return Used for collective or corporate name as an author.
         */
        public String getCollectiveName() { 
          return this.collectiveName == null ? null : this.collectiveName.getValue();
        }

        /**
         * @param value Used for collective or corporate name as an author.
         */
        public CitationContributorshipEntryComponent setCollectiveName(String value) { 
          if (Utilities.noString(value))
            this.collectiveName = null;
          else {
            if (this.collectiveName == null)
              this.collectiveName = new StringType();
            this.collectiveName.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #identifier} (Unique person identifier.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorshipEntryComponent setIdentifier(List<Identifier> theIdentifier) { 
          this.identifier = theIdentifier;
          return this;
        }

        public boolean hasIdentifier() { 
          if (this.identifier == null)
            return false;
          for (Identifier item : this.identifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Identifier addIdentifier() { //3
          Identifier t = new Identifier();
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return t;
        }

        public CitationContributorshipEntryComponent addIdentifier(Identifier t) { //3
          if (t == null)
            return this;
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
         */
        public Identifier getIdentifierFirstRep() { 
          if (getIdentifier().isEmpty()) {
            addIdentifier();
          }
          return getIdentifier().get(0);
        }

        /**
         * @return {@link #affiliationInfo} (Organization affiliated with the entity.)
         */
        public List<CitationContributorshipEntryAffiliationInfoComponent> getAffiliationInfo() { 
          if (this.affiliationInfo == null)
            this.affiliationInfo = new ArrayList<CitationContributorshipEntryAffiliationInfoComponent>();
          return this.affiliationInfo;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorshipEntryComponent setAffiliationInfo(List<CitationContributorshipEntryAffiliationInfoComponent> theAffiliationInfo) { 
          this.affiliationInfo = theAffiliationInfo;
          return this;
        }

        public boolean hasAffiliationInfo() { 
          if (this.affiliationInfo == null)
            return false;
          for (CitationContributorshipEntryAffiliationInfoComponent item : this.affiliationInfo)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationContributorshipEntryAffiliationInfoComponent addAffiliationInfo() { //3
          CitationContributorshipEntryAffiliationInfoComponent t = new CitationContributorshipEntryAffiliationInfoComponent();
          if (this.affiliationInfo == null)
            this.affiliationInfo = new ArrayList<CitationContributorshipEntryAffiliationInfoComponent>();
          this.affiliationInfo.add(t);
          return t;
        }

        public CitationContributorshipEntryComponent addAffiliationInfo(CitationContributorshipEntryAffiliationInfoComponent t) { //3
          if (t == null)
            return this;
          if (this.affiliationInfo == null)
            this.affiliationInfo = new ArrayList<CitationContributorshipEntryAffiliationInfoComponent>();
          this.affiliationInfo.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #affiliationInfo}, creating it if it does not already exist {3}
         */
        public CitationContributorshipEntryAffiliationInfoComponent getAffiliationInfoFirstRep() { 
          if (getAffiliationInfo().isEmpty()) {
            addAffiliationInfo();
          }
          return getAffiliationInfo().get(0);
        }

        /**
         * @return {@link #address} (Physical mailing address for the author or contributor.)
         */
        public List<Address> getAddress() { 
          if (this.address == null)
            this.address = new ArrayList<Address>();
          return this.address;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorshipEntryComponent setAddress(List<Address> theAddress) { 
          this.address = theAddress;
          return this;
        }

        public boolean hasAddress() { 
          if (this.address == null)
            return false;
          for (Address item : this.address)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Address addAddress() { //3
          Address t = new Address();
          if (this.address == null)
            this.address = new ArrayList<Address>();
          this.address.add(t);
          return t;
        }

        public CitationContributorshipEntryComponent addAddress(Address t) { //3
          if (t == null)
            return this;
          if (this.address == null)
            this.address = new ArrayList<Address>();
          this.address.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #address}, creating it if it does not already exist {3}
         */
        public Address getAddressFirstRep() { 
          if (getAddress().isEmpty()) {
            addAddress();
          }
          return getAddress().get(0);
        }

        /**
         * @return {@link #telecom} (Email or telephone contact methods for the author or contributor.)
         */
        public List<ContactPoint> getTelecom() { 
          if (this.telecom == null)
            this.telecom = new ArrayList<ContactPoint>();
          return this.telecom;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorshipEntryComponent setTelecom(List<ContactPoint> theTelecom) { 
          this.telecom = theTelecom;
          return this;
        }

        public boolean hasTelecom() { 
          if (this.telecom == null)
            return false;
          for (ContactPoint item : this.telecom)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ContactPoint addTelecom() { //3
          ContactPoint t = new ContactPoint();
          if (this.telecom == null)
            this.telecom = new ArrayList<ContactPoint>();
          this.telecom.add(t);
          return t;
        }

        public CitationContributorshipEntryComponent addTelecom(ContactPoint t) { //3
          if (t == null)
            return this;
          if (this.telecom == null)
            this.telecom = new ArrayList<ContactPoint>();
          this.telecom.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #telecom}, creating it if it does not already exist {3}
         */
        public ContactPoint getTelecomFirstRep() { 
          if (getTelecom().isEmpty()) {
            addTelecom();
          }
          return getTelecom().get(0);
        }

        /**
         * @return {@link #contribution} (This element identifies the specific nature of an individual’s contribution with respect to the cited work.)
         */
        public List<CodeableConcept> getContribution() { 
          if (this.contribution == null)
            this.contribution = new ArrayList<CodeableConcept>();
          return this.contribution;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorshipEntryComponent setContribution(List<CodeableConcept> theContribution) { 
          this.contribution = theContribution;
          return this;
        }

        public boolean hasContribution() { 
          if (this.contribution == null)
            return false;
          for (CodeableConcept item : this.contribution)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addContribution() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.contribution == null)
            this.contribution = new ArrayList<CodeableConcept>();
          this.contribution.add(t);
          return t;
        }

        public CitationContributorshipEntryComponent addContribution(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.contribution == null)
            this.contribution = new ArrayList<CodeableConcept>();
          this.contribution.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #contribution}, creating it if it does not already exist {3}
         */
        public CodeableConcept getContributionFirstRep() { 
          if (getContribution().isEmpty()) {
            addContribution();
          }
          return getContribution().get(0);
        }

        /**
         * @return {@link #notAnAuthor} (False, missing, or empty elements implies authorship.). This is the underlying object with id, value and extensions. The accessor "getNotAnAuthor" gives direct access to the value
         */
        public BooleanType getNotAnAuthorElement() { 
          if (this.notAnAuthor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipEntryComponent.notAnAuthor");
            else if (Configuration.doAutoCreate())
              this.notAnAuthor = new BooleanType(); // bb
          return this.notAnAuthor;
        }

        public boolean hasNotAnAuthorElement() { 
          return this.notAnAuthor != null && !this.notAnAuthor.isEmpty();
        }

        public boolean hasNotAnAuthor() { 
          return this.notAnAuthor != null && !this.notAnAuthor.isEmpty();
        }

        /**
         * @param value {@link #notAnAuthor} (False, missing, or empty elements implies authorship.). This is the underlying object with id, value and extensions. The accessor "getNotAnAuthor" gives direct access to the value
         */
        public CitationContributorshipEntryComponent setNotAnAuthorElement(BooleanType value) { 
          this.notAnAuthor = value;
          return this;
        }

        /**
         * @return False, missing, or empty elements implies authorship.
         */
        public boolean getNotAnAuthor() { 
          return this.notAnAuthor == null || this.notAnAuthor.isEmpty() ? false : this.notAnAuthor.getValue();
        }

        /**
         * @param value False, missing, or empty elements implies authorship.
         */
        public CitationContributorshipEntryComponent setNotAnAuthor(boolean value) { 
            if (this.notAnAuthor == null)
              this.notAnAuthor = new BooleanType();
            this.notAnAuthor.setValue(value);
          return this;
        }

        /**
         * @return {@link #correspondingAuthor} (Indication of which author is the corresponding author for the article cited.). This is the underlying object with id, value and extensions. The accessor "getCorrespondingAuthor" gives direct access to the value
         */
        public BooleanType getCorrespondingAuthorElement() { 
          if (this.correspondingAuthor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipEntryComponent.correspondingAuthor");
            else if (Configuration.doAutoCreate())
              this.correspondingAuthor = new BooleanType(); // bb
          return this.correspondingAuthor;
        }

        public boolean hasCorrespondingAuthorElement() { 
          return this.correspondingAuthor != null && !this.correspondingAuthor.isEmpty();
        }

        public boolean hasCorrespondingAuthor() { 
          return this.correspondingAuthor != null && !this.correspondingAuthor.isEmpty();
        }

        /**
         * @param value {@link #correspondingAuthor} (Indication of which author is the corresponding author for the article cited.). This is the underlying object with id, value and extensions. The accessor "getCorrespondingAuthor" gives direct access to the value
         */
        public CitationContributorshipEntryComponent setCorrespondingAuthorElement(BooleanType value) { 
          this.correspondingAuthor = value;
          return this;
        }

        /**
         * @return Indication of which author is the corresponding author for the article cited.
         */
        public boolean getCorrespondingAuthor() { 
          return this.correspondingAuthor == null || this.correspondingAuthor.isEmpty() ? false : this.correspondingAuthor.getValue();
        }

        /**
         * @param value Indication of which author is the corresponding author for the article cited.
         */
        public CitationContributorshipEntryComponent setCorrespondingAuthor(boolean value) { 
            if (this.correspondingAuthor == null)
              this.correspondingAuthor = new BooleanType();
            this.correspondingAuthor.setValue(value);
          return this;
        }

        /**
         * @return {@link #listOrder} (Used to code order of authors.). This is the underlying object with id, value and extensions. The accessor "getListOrder" gives direct access to the value
         */
        public PositiveIntType getListOrderElement() { 
          if (this.listOrder == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipEntryComponent.listOrder");
            else if (Configuration.doAutoCreate())
              this.listOrder = new PositiveIntType(); // bb
          return this.listOrder;
        }

        public boolean hasListOrderElement() { 
          return this.listOrder != null && !this.listOrder.isEmpty();
        }

        public boolean hasListOrder() { 
          return this.listOrder != null && !this.listOrder.isEmpty();
        }

        /**
         * @param value {@link #listOrder} (Used to code order of authors.). This is the underlying object with id, value and extensions. The accessor "getListOrder" gives direct access to the value
         */
        public CitationContributorshipEntryComponent setListOrderElement(PositiveIntType value) { 
          this.listOrder = value;
          return this;
        }

        /**
         * @return Used to code order of authors.
         */
        public int getListOrder() { 
          return this.listOrder == null || this.listOrder.isEmpty() ? 0 : this.listOrder.getValue();
        }

        /**
         * @param value Used to code order of authors.
         */
        public CitationContributorshipEntryComponent setListOrder(int value) { 
            if (this.listOrder == null)
              this.listOrder = new PositiveIntType();
            this.listOrder.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "HumanName", "A name associated with the individual.", 0, 1, name));
          children.add(new Property("initials", "string", "Initials for forename.", 0, 1, initials));
          children.add(new Property("collectiveName", "string", "Used for collective or corporate name as an author.", 0, 1, collectiveName));
          children.add(new Property("identifier", "Identifier", "Unique person identifier.", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("affiliationInfo", "", "Organization affiliated with the entity.", 0, java.lang.Integer.MAX_VALUE, affiliationInfo));
          children.add(new Property("address", "Address", "Physical mailing address for the author or contributor.", 0, java.lang.Integer.MAX_VALUE, address));
          children.add(new Property("telecom", "ContactPoint", "Email or telephone contact methods for the author or contributor.", 0, java.lang.Integer.MAX_VALUE, telecom));
          children.add(new Property("contribution", "CodeableConcept", "This element identifies the specific nature of an individual’s contribution with respect to the cited work.", 0, java.lang.Integer.MAX_VALUE, contribution));
          children.add(new Property("notAnAuthor", "boolean", "False, missing, or empty elements implies authorship.", 0, 1, notAnAuthor));
          children.add(new Property("correspondingAuthor", "boolean", "Indication of which author is the corresponding author for the article cited.", 0, 1, correspondingAuthor));
          children.add(new Property("listOrder", "positiveInt", "Used to code order of authors.", 0, 1, listOrder));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "HumanName", "A name associated with the individual.", 0, 1, name);
          case 269062575: /*initials*/  return new Property("initials", "string", "Initials for forename.", 0, 1, initials);
          case 502871833: /*collectiveName*/  return new Property("collectiveName", "string", "Used for collective or corporate name as an author.", 0, 1, collectiveName);
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique person identifier.", 0, java.lang.Integer.MAX_VALUE, identifier);
          case -215129154: /*affiliationInfo*/  return new Property("affiliationInfo", "", "Organization affiliated with the entity.", 0, java.lang.Integer.MAX_VALUE, affiliationInfo);
          case -1147692044: /*address*/  return new Property("address", "Address", "Physical mailing address for the author or contributor.", 0, java.lang.Integer.MAX_VALUE, address);
          case -1429363305: /*telecom*/  return new Property("telecom", "ContactPoint", "Email or telephone contact methods for the author or contributor.", 0, java.lang.Integer.MAX_VALUE, telecom);
          case 1375970320: /*contribution*/  return new Property("contribution", "CodeableConcept", "This element identifies the specific nature of an individual’s contribution with respect to the cited work.", 0, java.lang.Integer.MAX_VALUE, contribution);
          case -1513418741: /*notAnAuthor*/  return new Property("notAnAuthor", "boolean", "False, missing, or empty elements implies authorship.", 0, 1, notAnAuthor);
          case 1413890206: /*correspondingAuthor*/  return new Property("correspondingAuthor", "boolean", "Indication of which author is the corresponding author for the article cited.", 0, 1, correspondingAuthor);
          case -1238918832: /*listOrder*/  return new Property("listOrder", "positiveInt", "Used to code order of authors.", 0, 1, listOrder);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // HumanName
        case 269062575: /*initials*/ return this.initials == null ? new Base[0] : new Base[] {this.initials}; // StringType
        case 502871833: /*collectiveName*/ return this.collectiveName == null ? new Base[0] : new Base[] {this.collectiveName}; // StringType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -215129154: /*affiliationInfo*/ return this.affiliationInfo == null ? new Base[0] : this.affiliationInfo.toArray(new Base[this.affiliationInfo.size()]); // CitationContributorshipEntryAffiliationInfoComponent
        case -1147692044: /*address*/ return this.address == null ? new Base[0] : this.address.toArray(new Base[this.address.size()]); // Address
        case -1429363305: /*telecom*/ return this.telecom == null ? new Base[0] : this.telecom.toArray(new Base[this.telecom.size()]); // ContactPoint
        case 1375970320: /*contribution*/ return this.contribution == null ? new Base[0] : this.contribution.toArray(new Base[this.contribution.size()]); // CodeableConcept
        case -1513418741: /*notAnAuthor*/ return this.notAnAuthor == null ? new Base[0] : new Base[] {this.notAnAuthor}; // BooleanType
        case 1413890206: /*correspondingAuthor*/ return this.correspondingAuthor == null ? new Base[0] : new Base[] {this.correspondingAuthor}; // BooleanType
        case -1238918832: /*listOrder*/ return this.listOrder == null ? new Base[0] : new Base[] {this.listOrder}; // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToHumanName(value); // HumanName
          return value;
        case 269062575: // initials
          this.initials = TypeConvertor.castToString(value); // StringType
          return value;
        case 502871833: // collectiveName
          this.collectiveName = TypeConvertor.castToString(value); // StringType
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -215129154: // affiliationInfo
          this.getAffiliationInfo().add((CitationContributorshipEntryAffiliationInfoComponent) value); // CitationContributorshipEntryAffiliationInfoComponent
          return value;
        case -1147692044: // address
          this.getAddress().add(TypeConvertor.castToAddress(value)); // Address
          return value;
        case -1429363305: // telecom
          this.getTelecom().add(TypeConvertor.castToContactPoint(value)); // ContactPoint
          return value;
        case 1375970320: // contribution
          this.getContribution().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1513418741: // notAnAuthor
          this.notAnAuthor = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1413890206: // correspondingAuthor
          this.correspondingAuthor = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1238918832: // listOrder
          this.listOrder = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToHumanName(value); // HumanName
        } else if (name.equals("initials")) {
          this.initials = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("collectiveName")) {
          this.collectiveName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("affiliationInfo")) {
          this.getAffiliationInfo().add((CitationContributorshipEntryAffiliationInfoComponent) value);
        } else if (name.equals("address")) {
          this.getAddress().add(TypeConvertor.castToAddress(value));
        } else if (name.equals("telecom")) {
          this.getTelecom().add(TypeConvertor.castToContactPoint(value));
        } else if (name.equals("contribution")) {
          this.getContribution().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("notAnAuthor")) {
          this.notAnAuthor = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("correspondingAuthor")) {
          this.correspondingAuthor = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("listOrder")) {
          this.listOrder = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getName();
        case 269062575:  return getInitialsElement();
        case 502871833:  return getCollectiveNameElement();
        case -1618432855:  return addIdentifier(); 
        case -215129154:  return addAffiliationInfo(); 
        case -1147692044:  return addAddress(); 
        case -1429363305:  return addTelecom(); 
        case 1375970320:  return addContribution(); 
        case -1513418741:  return getNotAnAuthorElement();
        case 1413890206:  return getCorrespondingAuthorElement();
        case -1238918832:  return getListOrderElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"HumanName"};
        case 269062575: /*initials*/ return new String[] {"string"};
        case 502871833: /*collectiveName*/ return new String[] {"string"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -215129154: /*affiliationInfo*/ return new String[] {};
        case -1147692044: /*address*/ return new String[] {"Address"};
        case -1429363305: /*telecom*/ return new String[] {"ContactPoint"};
        case 1375970320: /*contribution*/ return new String[] {"CodeableConcept"};
        case -1513418741: /*notAnAuthor*/ return new String[] {"boolean"};
        case 1413890206: /*correspondingAuthor*/ return new String[] {"boolean"};
        case -1238918832: /*listOrder*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          this.name = new HumanName();
          return this.name;
        }
        else if (name.equals("initials")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorship.entry.initials");
        }
        else if (name.equals("collectiveName")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorship.entry.collectiveName");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("affiliationInfo")) {
          return addAffiliationInfo();
        }
        else if (name.equals("address")) {
          return addAddress();
        }
        else if (name.equals("telecom")) {
          return addTelecom();
        }
        else if (name.equals("contribution")) {
          return addContribution();
        }
        else if (name.equals("notAnAuthor")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorship.entry.notAnAuthor");
        }
        else if (name.equals("correspondingAuthor")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorship.entry.correspondingAuthor");
        }
        else if (name.equals("listOrder")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorship.entry.listOrder");
        }
        else
          return super.addChild(name);
      }

      public CitationContributorshipEntryComponent copy() {
        CitationContributorshipEntryComponent dst = new CitationContributorshipEntryComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationContributorshipEntryComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.initials = initials == null ? null : initials.copy();
        dst.collectiveName = collectiveName == null ? null : collectiveName.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (affiliationInfo != null) {
          dst.affiliationInfo = new ArrayList<CitationContributorshipEntryAffiliationInfoComponent>();
          for (CitationContributorshipEntryAffiliationInfoComponent i : affiliationInfo)
            dst.affiliationInfo.add(i.copy());
        };
        if (address != null) {
          dst.address = new ArrayList<Address>();
          for (Address i : address)
            dst.address.add(i.copy());
        };
        if (telecom != null) {
          dst.telecom = new ArrayList<ContactPoint>();
          for (ContactPoint i : telecom)
            dst.telecom.add(i.copy());
        };
        if (contribution != null) {
          dst.contribution = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : contribution)
            dst.contribution.add(i.copy());
        };
        dst.notAnAuthor = notAnAuthor == null ? null : notAnAuthor.copy();
        dst.correspondingAuthor = correspondingAuthor == null ? null : correspondingAuthor.copy();
        dst.listOrder = listOrder == null ? null : listOrder.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationContributorshipEntryComponent))
          return false;
        CitationContributorshipEntryComponent o = (CitationContributorshipEntryComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(initials, o.initials, true) && compareDeep(collectiveName, o.collectiveName, true)
           && compareDeep(identifier, o.identifier, true) && compareDeep(affiliationInfo, o.affiliationInfo, true)
           && compareDeep(address, o.address, true) && compareDeep(telecom, o.telecom, true) && compareDeep(contribution, o.contribution, true)
           && compareDeep(notAnAuthor, o.notAnAuthor, true) && compareDeep(correspondingAuthor, o.correspondingAuthor, true)
           && compareDeep(listOrder, o.listOrder, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationContributorshipEntryComponent))
          return false;
        CitationContributorshipEntryComponent o = (CitationContributorshipEntryComponent) other_;
        return compareValues(initials, o.initials, true) && compareValues(collectiveName, o.collectiveName, true)
           && compareValues(notAnAuthor, o.notAnAuthor, true) && compareValues(correspondingAuthor, o.correspondingAuthor, true)
           && compareValues(listOrder, o.listOrder, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, initials, collectiveName
          , identifier, affiliationInfo, address, telecom, contribution, notAnAuthor, correspondingAuthor
          , listOrder);
      }

  public String fhirType() {
    return "Citation.contributorship.entry";

  }

  }

    @Block()
    public static class CitationContributorshipEntryAffiliationInfoComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Display for the organization.
         */
        @Child(name = "affiliation", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Display for the organization", formalDefinition="Display for the organization." )
        protected StringType affiliation;

        /**
         * Role within the organization, such as professional title.
         */
        @Child(name = "role", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Role within the organization, such as professional title", formalDefinition="Role within the organization, such as professional title." )
        protected StringType role;

        /**
         * Identifier for the organization.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Identifier for the organization", formalDefinition="Identifier for the organization." )
        protected List<Identifier> identifier;

        private static final long serialVersionUID = 548335522L;

    /**
     * Constructor
     */
      public CitationContributorshipEntryAffiliationInfoComponent() {
        super();
      }

        /**
         * @return {@link #affiliation} (Display for the organization.). This is the underlying object with id, value and extensions. The accessor "getAffiliation" gives direct access to the value
         */
        public StringType getAffiliationElement() { 
          if (this.affiliation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipEntryAffiliationInfoComponent.affiliation");
            else if (Configuration.doAutoCreate())
              this.affiliation = new StringType(); // bb
          return this.affiliation;
        }

        public boolean hasAffiliationElement() { 
          return this.affiliation != null && !this.affiliation.isEmpty();
        }

        public boolean hasAffiliation() { 
          return this.affiliation != null && !this.affiliation.isEmpty();
        }

        /**
         * @param value {@link #affiliation} (Display for the organization.). This is the underlying object with id, value and extensions. The accessor "getAffiliation" gives direct access to the value
         */
        public CitationContributorshipEntryAffiliationInfoComponent setAffiliationElement(StringType value) { 
          this.affiliation = value;
          return this;
        }

        /**
         * @return Display for the organization.
         */
        public String getAffiliation() { 
          return this.affiliation == null ? null : this.affiliation.getValue();
        }

        /**
         * @param value Display for the organization.
         */
        public CitationContributorshipEntryAffiliationInfoComponent setAffiliation(String value) { 
          if (Utilities.noString(value))
            this.affiliation = null;
          else {
            if (this.affiliation == null)
              this.affiliation = new StringType();
            this.affiliation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #role} (Role within the organization, such as professional title.). This is the underlying object with id, value and extensions. The accessor "getRole" gives direct access to the value
         */
        public StringType getRoleElement() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipEntryAffiliationInfoComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new StringType(); // bb
          return this.role;
        }

        public boolean hasRoleElement() { 
          return this.role != null && !this.role.isEmpty();
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (Role within the organization, such as professional title.). This is the underlying object with id, value and extensions. The accessor "getRole" gives direct access to the value
         */
        public CitationContributorshipEntryAffiliationInfoComponent setRoleElement(StringType value) { 
          this.role = value;
          return this;
        }

        /**
         * @return Role within the organization, such as professional title.
         */
        public String getRole() { 
          return this.role == null ? null : this.role.getValue();
        }

        /**
         * @param value Role within the organization, such as professional title.
         */
        public CitationContributorshipEntryAffiliationInfoComponent setRole(String value) { 
          if (Utilities.noString(value))
            this.role = null;
          else {
            if (this.role == null)
              this.role = new StringType();
            this.role.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #identifier} (Identifier for the organization.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorshipEntryAffiliationInfoComponent setIdentifier(List<Identifier> theIdentifier) { 
          this.identifier = theIdentifier;
          return this;
        }

        public boolean hasIdentifier() { 
          if (this.identifier == null)
            return false;
          for (Identifier item : this.identifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Identifier addIdentifier() { //3
          Identifier t = new Identifier();
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return t;
        }

        public CitationContributorshipEntryAffiliationInfoComponent addIdentifier(Identifier t) { //3
          if (t == null)
            return this;
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
         */
        public Identifier getIdentifierFirstRep() { 
          if (getIdentifier().isEmpty()) {
            addIdentifier();
          }
          return getIdentifier().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("affiliation", "string", "Display for the organization.", 0, 1, affiliation));
          children.add(new Property("role", "string", "Role within the organization, such as professional title.", 0, 1, role));
          children.add(new Property("identifier", "Identifier", "Identifier for the organization.", 0, java.lang.Integer.MAX_VALUE, identifier));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 2019918576: /*affiliation*/  return new Property("affiliation", "string", "Display for the organization.", 0, 1, affiliation);
          case 3506294: /*role*/  return new Property("role", "string", "Role within the organization, such as professional title.", 0, 1, role);
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier for the organization.", 0, java.lang.Integer.MAX_VALUE, identifier);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 2019918576: /*affiliation*/ return this.affiliation == null ? new Base[0] : new Base[] {this.affiliation}; // StringType
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // StringType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 2019918576: // affiliation
          this.affiliation = TypeConvertor.castToString(value); // StringType
          return value;
        case 3506294: // role
          this.role = TypeConvertor.castToString(value); // StringType
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("affiliation")) {
          this.affiliation = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("role")) {
          this.role = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 2019918576:  return getAffiliationElement();
        case 3506294:  return getRoleElement();
        case -1618432855:  return addIdentifier(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 2019918576: /*affiliation*/ return new String[] {"string"};
        case 3506294: /*role*/ return new String[] {"string"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("affiliation")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorship.entry.affiliationInfo.affiliation");
        }
        else if (name.equals("role")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorship.entry.affiliationInfo.role");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else
          return super.addChild(name);
      }

      public CitationContributorshipEntryAffiliationInfoComponent copy() {
        CitationContributorshipEntryAffiliationInfoComponent dst = new CitationContributorshipEntryAffiliationInfoComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationContributorshipEntryAffiliationInfoComponent dst) {
        super.copyValues(dst);
        dst.affiliation = affiliation == null ? null : affiliation.copy();
        dst.role = role == null ? null : role.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationContributorshipEntryAffiliationInfoComponent))
          return false;
        CitationContributorshipEntryAffiliationInfoComponent o = (CitationContributorshipEntryAffiliationInfoComponent) other_;
        return compareDeep(affiliation, o.affiliation, true) && compareDeep(role, o.role, true) && compareDeep(identifier, o.identifier, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationContributorshipEntryAffiliationInfoComponent))
          return false;
        CitationContributorshipEntryAffiliationInfoComponent o = (CitationContributorshipEntryAffiliationInfoComponent) other_;
        return compareValues(affiliation, o.affiliation, true) && compareValues(role, o.role, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(affiliation, role, identifier
          );
      }

  public String fhirType() {
    return "Citation.contributorship.entry.affiliationInfo";

  }

  }

    @Block()
    public static class CitationContributorshipSummaryComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used most commonly to express an author list or a contributorship statement.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Either authorList or contributorshipStatement", formalDefinition="Used most commonly to express an author list or a contributorship statement." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/contributor-summary-type")
        protected CodeableConcept type;

        /**
         * The format for the display string.
         */
        @Child(name = "style", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The format for the display string", formalDefinition="The format for the display string." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/contributor-summary-style")
        protected CodeableConcept style;

        /**
         * Used to code the producer or rule for creating the display string.
         */
        @Child(name = "source", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to code the producer or rule for creating the display string", formalDefinition="Used to code the producer or rule for creating the display string." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/contributor-summary-source")
        protected CodeableConcept source;

        /**
         * The display string for the author list, contributor list, or contributorship statement.
         */
        @Child(name = "value", type = {MarkdownType.class}, order=4, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The display string for the author list, contributor list, or contributorship statement", formalDefinition="The display string for the author list, contributor list, or contributorship statement." )
        protected MarkdownType value;

        private static final long serialVersionUID = 1353383781L;

    /**
     * Constructor
     */
      public CitationContributorshipSummaryComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationContributorshipSummaryComponent(String value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #type} (Used most commonly to express an author list or a contributorship statement.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipSummaryComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Used most commonly to express an author list or a contributorship statement.)
         */
        public CitationContributorshipSummaryComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #style} (The format for the display string.)
         */
        public CodeableConcept getStyle() { 
          if (this.style == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipSummaryComponent.style");
            else if (Configuration.doAutoCreate())
              this.style = new CodeableConcept(); // cc
          return this.style;
        }

        public boolean hasStyle() { 
          return this.style != null && !this.style.isEmpty();
        }

        /**
         * @param value {@link #style} (The format for the display string.)
         */
        public CitationContributorshipSummaryComponent setStyle(CodeableConcept value) { 
          this.style = value;
          return this;
        }

        /**
         * @return {@link #source} (Used to code the producer or rule for creating the display string.)
         */
        public CodeableConcept getSource() { 
          if (this.source == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipSummaryComponent.source");
            else if (Configuration.doAutoCreate())
              this.source = new CodeableConcept(); // cc
          return this.source;
        }

        public boolean hasSource() { 
          return this.source != null && !this.source.isEmpty();
        }

        /**
         * @param value {@link #source} (Used to code the producer or rule for creating the display string.)
         */
        public CitationContributorshipSummaryComponent setSource(CodeableConcept value) { 
          this.source = value;
          return this;
        }

        /**
         * @return {@link #value} (The display string for the author list, contributor list, or contributorship statement.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public MarkdownType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorshipSummaryComponent.value");
            else if (Configuration.doAutoCreate())
              this.value = new MarkdownType(); // bb
          return this.value;
        }

        public boolean hasValueElement() { 
          return this.value != null && !this.value.isEmpty();
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The display string for the author list, contributor list, or contributorship statement.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public CitationContributorshipSummaryComponent setValueElement(MarkdownType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The display string for the author list, contributor list, or contributorship statement.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The display string for the author list, contributor list, or contributorship statement.
         */
        public CitationContributorshipSummaryComponent setValue(String value) { 
            if (this.value == null)
              this.value = new MarkdownType();
            this.value.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Used most commonly to express an author list or a contributorship statement.", 0, 1, type));
          children.add(new Property("style", "CodeableConcept", "The format for the display string.", 0, 1, style));
          children.add(new Property("source", "CodeableConcept", "Used to code the producer or rule for creating the display string.", 0, 1, source));
          children.add(new Property("value", "markdown", "The display string for the author list, contributor list, or contributorship statement.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Used most commonly to express an author list or a contributorship statement.", 0, 1, type);
          case 109780401: /*style*/  return new Property("style", "CodeableConcept", "The format for the display string.", 0, 1, style);
          case -896505829: /*source*/  return new Property("source", "CodeableConcept", "Used to code the producer or rule for creating the display string.", 0, 1, source);
          case 111972721: /*value*/  return new Property("value", "markdown", "The display string for the author list, contributor list, or contributorship statement.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 109780401: /*style*/ return this.style == null ? new Base[0] : new Base[] {this.style}; // CodeableConcept
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 109780401: // style
          this.style = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -896505829: // source
          this.source = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("style")) {
          this.style = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("source")) {
          this.source = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 109780401:  return getStyle();
        case -896505829:  return getSource();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 109780401: /*style*/ return new String[] {"CodeableConcept"};
        case -896505829: /*source*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("style")) {
          this.style = new CodeableConcept();
          return this.style;
        }
        else if (name.equals("source")) {
          this.source = new CodeableConcept();
          return this.source;
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorship.summary.value");
        }
        else
          return super.addChild(name);
      }

      public CitationContributorshipSummaryComponent copy() {
        CitationContributorshipSummaryComponent dst = new CitationContributorshipSummaryComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationContributorshipSummaryComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.style = style == null ? null : style.copy();
        dst.source = source == null ? null : source.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationContributorshipSummaryComponent))
          return false;
        CitationContributorshipSummaryComponent o = (CitationContributorshipSummaryComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(style, o.style, true) && compareDeep(source, o.source, true)
           && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationContributorshipSummaryComponent))
          return false;
        CitationContributorshipSummaryComponent o = (CitationContributorshipSummaryComponent) other_;
        return compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, style, source, value
          );
      }

  public String fhirType() {
    return "Citation.contributorship.summary";

  }

  }

    @Block()
    public static class CitationAlternativeFormComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.
         */
        @Child(name = "publishingModel", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic", formalDefinition="Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publishing-model-type")
        protected CodeableConcept publishingModel;

        /**
         * Language in which this form of the article is published.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Language in which this form of the article is published", formalDefinition="Language in which this form of the article is published." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
        protected CodeableConcept language;

        /**
         * The specific issue in which the cited article resides.
         */
        @Child(name = "journalIssue", type = {}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The specific issue in which the cited article resides", formalDefinition="The specific issue in which the cited article resides." )
        protected CitationAlternativeFormJournalIssueComponent journalIssue;

        /**
         * Indicates the inclusive pages for the article cited.
         */
        @Child(name = "pagination", type = {}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates the inclusive pages for the article cited", formalDefinition="Indicates the inclusive pages for the article cited." )
        protected CitationAlternativeFormPaginationComponent pagination;

        /**
         * Citation detail for sources other than journals such as books and databases.
         */
        @Child(name = "publicationInfo", type = {}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Citation detail for sources other than journals", formalDefinition="Citation detail for sources other than journals such as books and databases." )
        protected CitationAlternativeFormPublicationInfoComponent publicationInfo;

        private static final long serialVersionUID = 1567425409L;

    /**
     * Constructor
     */
      public CitationAlternativeFormComponent() {
        super();
      }

        /**
         * @return {@link #publishingModel} (Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.)
         */
        public CodeableConcept getPublishingModel() { 
          if (this.publishingModel == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormComponent.publishingModel");
            else if (Configuration.doAutoCreate())
              this.publishingModel = new CodeableConcept(); // cc
          return this.publishingModel;
        }

        public boolean hasPublishingModel() { 
          return this.publishingModel != null && !this.publishingModel.isEmpty();
        }

        /**
         * @param value {@link #publishingModel} (Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.)
         */
        public CitationAlternativeFormComponent setPublishingModel(CodeableConcept value) { 
          this.publishingModel = value;
          return this;
        }

        /**
         * @return {@link #language} (Language in which this form of the article is published.)
         */
        public CodeableConcept getLanguage() { 
          if (this.language == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormComponent.language");
            else if (Configuration.doAutoCreate())
              this.language = new CodeableConcept(); // cc
          return this.language;
        }

        public boolean hasLanguage() { 
          return this.language != null && !this.language.isEmpty();
        }

        /**
         * @param value {@link #language} (Language in which this form of the article is published.)
         */
        public CitationAlternativeFormComponent setLanguage(CodeableConcept value) { 
          this.language = value;
          return this;
        }

        /**
         * @return {@link #journalIssue} (The specific issue in which the cited article resides.)
         */
        public CitationAlternativeFormJournalIssueComponent getJournalIssue() { 
          if (this.journalIssue == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormComponent.journalIssue");
            else if (Configuration.doAutoCreate())
              this.journalIssue = new CitationAlternativeFormJournalIssueComponent(); // cc
          return this.journalIssue;
        }

        public boolean hasJournalIssue() { 
          return this.journalIssue != null && !this.journalIssue.isEmpty();
        }

        /**
         * @param value {@link #journalIssue} (The specific issue in which the cited article resides.)
         */
        public CitationAlternativeFormComponent setJournalIssue(CitationAlternativeFormJournalIssueComponent value) { 
          this.journalIssue = value;
          return this;
        }

        /**
         * @return {@link #pagination} (Indicates the inclusive pages for the article cited.)
         */
        public CitationAlternativeFormPaginationComponent getPagination() { 
          if (this.pagination == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormComponent.pagination");
            else if (Configuration.doAutoCreate())
              this.pagination = new CitationAlternativeFormPaginationComponent(); // cc
          return this.pagination;
        }

        public boolean hasPagination() { 
          return this.pagination != null && !this.pagination.isEmpty();
        }

        /**
         * @param value {@link #pagination} (Indicates the inclusive pages for the article cited.)
         */
        public CitationAlternativeFormComponent setPagination(CitationAlternativeFormPaginationComponent value) { 
          this.pagination = value;
          return this;
        }

        /**
         * @return {@link #publicationInfo} (Citation detail for sources other than journals such as books and databases.)
         */
        public CitationAlternativeFormPublicationInfoComponent getPublicationInfo() { 
          if (this.publicationInfo == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormComponent.publicationInfo");
            else if (Configuration.doAutoCreate())
              this.publicationInfo = new CitationAlternativeFormPublicationInfoComponent(); // cc
          return this.publicationInfo;
        }

        public boolean hasPublicationInfo() { 
          return this.publicationInfo != null && !this.publicationInfo.isEmpty();
        }

        /**
         * @param value {@link #publicationInfo} (Citation detail for sources other than journals such as books and databases.)
         */
        public CitationAlternativeFormComponent setPublicationInfo(CitationAlternativeFormPublicationInfoComponent value) { 
          this.publicationInfo = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("publishingModel", "CodeableConcept", "Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.", 0, 1, publishingModel));
          children.add(new Property("language", "CodeableConcept", "Language in which this form of the article is published.", 0, 1, language));
          children.add(new Property("journalIssue", "", "The specific issue in which the cited article resides.", 0, 1, journalIssue));
          children.add(new Property("pagination", "", "Indicates the inclusive pages for the article cited.", 0, 1, pagination));
          children.add(new Property("publicationInfo", "", "Citation detail for sources other than journals such as books and databases.", 0, 1, publicationInfo));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 747318902: /*publishingModel*/  return new Property("publishingModel", "CodeableConcept", "Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.", 0, 1, publishingModel);
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "Language in which this form of the article is published.", 0, 1, language);
          case -716835870: /*journalIssue*/  return new Property("journalIssue", "", "The specific issue in which the cited article resides.", 0, 1, journalIssue);
          case 1297692570: /*pagination*/  return new Property("pagination", "", "Indicates the inclusive pages for the article cited.", 0, 1, pagination);
          case 1470727418: /*publicationInfo*/  return new Property("publicationInfo", "", "Citation detail for sources other than journals such as books and databases.", 0, 1, publicationInfo);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 747318902: /*publishingModel*/ return this.publishingModel == null ? new Base[0] : new Base[] {this.publishingModel}; // CodeableConcept
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CodeableConcept
        case -716835870: /*journalIssue*/ return this.journalIssue == null ? new Base[0] : new Base[] {this.journalIssue}; // CitationAlternativeFormJournalIssueComponent
        case 1297692570: /*pagination*/ return this.pagination == null ? new Base[0] : new Base[] {this.pagination}; // CitationAlternativeFormPaginationComponent
        case 1470727418: /*publicationInfo*/ return this.publicationInfo == null ? new Base[0] : new Base[] {this.publicationInfo}; // CitationAlternativeFormPublicationInfoComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 747318902: // publishingModel
          this.publishingModel = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1613589672: // language
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -716835870: // journalIssue
          this.journalIssue = (CitationAlternativeFormJournalIssueComponent) value; // CitationAlternativeFormJournalIssueComponent
          return value;
        case 1297692570: // pagination
          this.pagination = (CitationAlternativeFormPaginationComponent) value; // CitationAlternativeFormPaginationComponent
          return value;
        case 1470727418: // publicationInfo
          this.publicationInfo = (CitationAlternativeFormPublicationInfoComponent) value; // CitationAlternativeFormPublicationInfoComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("publishingModel")) {
          this.publishingModel = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("language")) {
          this.language = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("journalIssue")) {
          this.journalIssue = (CitationAlternativeFormJournalIssueComponent) value; // CitationAlternativeFormJournalIssueComponent
        } else if (name.equals("pagination")) {
          this.pagination = (CitationAlternativeFormPaginationComponent) value; // CitationAlternativeFormPaginationComponent
        } else if (name.equals("publicationInfo")) {
          this.publicationInfo = (CitationAlternativeFormPublicationInfoComponent) value; // CitationAlternativeFormPublicationInfoComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 747318902:  return getPublishingModel();
        case -1613589672:  return getLanguage();
        case -716835870:  return getJournalIssue();
        case 1297692570:  return getPagination();
        case 1470727418:  return getPublicationInfo();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 747318902: /*publishingModel*/ return new String[] {"CodeableConcept"};
        case -1613589672: /*language*/ return new String[] {"CodeableConcept"};
        case -716835870: /*journalIssue*/ return new String[] {};
        case 1297692570: /*pagination*/ return new String[] {};
        case 1470727418: /*publicationInfo*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("publishingModel")) {
          this.publishingModel = new CodeableConcept();
          return this.publishingModel;
        }
        else if (name.equals("language")) {
          this.language = new CodeableConcept();
          return this.language;
        }
        else if (name.equals("journalIssue")) {
          this.journalIssue = new CitationAlternativeFormJournalIssueComponent();
          return this.journalIssue;
        }
        else if (name.equals("pagination")) {
          this.pagination = new CitationAlternativeFormPaginationComponent();
          return this.pagination;
        }
        else if (name.equals("publicationInfo")) {
          this.publicationInfo = new CitationAlternativeFormPublicationInfoComponent();
          return this.publicationInfo;
        }
        else
          return super.addChild(name);
      }

      public CitationAlternativeFormComponent copy() {
        CitationAlternativeFormComponent dst = new CitationAlternativeFormComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAlternativeFormComponent dst) {
        super.copyValues(dst);
        dst.publishingModel = publishingModel == null ? null : publishingModel.copy();
        dst.language = language == null ? null : language.copy();
        dst.journalIssue = journalIssue == null ? null : journalIssue.copy();
        dst.pagination = pagination == null ? null : pagination.copy();
        dst.publicationInfo = publicationInfo == null ? null : publicationInfo.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormComponent))
          return false;
        CitationAlternativeFormComponent o = (CitationAlternativeFormComponent) other_;
        return compareDeep(publishingModel, o.publishingModel, true) && compareDeep(language, o.language, true)
           && compareDeep(journalIssue, o.journalIssue, true) && compareDeep(pagination, o.pagination, true)
           && compareDeep(publicationInfo, o.publicationInfo, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormComponent))
          return false;
        CitationAlternativeFormComponent o = (CitationAlternativeFormComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(publishingModel, language
          , journalIssue, pagination, publicationInfo);
      }

  public String fhirType() {
    return "Citation.alternativeForm";

  }

  }

    @Block()
    public static class CitationAlternativeFormJournalIssueComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Describes the form of the medium cited. Common codes are "Internet" or "Print.".
         */
        @Child(name = "citedMedium", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Internet or Print", formalDefinition="Describes the form of the medium cited. Common codes are \"Internet\" or \"Print.\"." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/journal-issue-medium")
        protected CodeableConcept citedMedium;

        /**
         * Volume number of journal in which the article is published.
         */
        @Child(name = "volume", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Volume number of journal in which the article is published", formalDefinition="Volume number of journal in which the article is published." )
        protected StringType volume;

        /**
         * Issue, part or supplement of journal in which the article is published.
         */
        @Child(name = "issue", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Issue, part or supplement of journal in which the article is published", formalDefinition="Issue, part or supplement of journal in which the article is published." )
        protected StringType issue;

        /**
         * Defining the date on which the issue of the joutnal was published.
         */
        @Child(name = "publicationDate", type = {}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Defining the date on which the issue of the joutnal was published", formalDefinition="Defining the date on which the issue of the joutnal was published." )
        protected CitationAlternativeFormJournalIssuePublicationDateComponent publicationDate;

        private static final long serialVersionUID = 2080837313L;

    /**
     * Constructor
     */
      public CitationAlternativeFormJournalIssueComponent() {
        super();
      }

        /**
         * @return {@link #citedMedium} (Describes the form of the medium cited. Common codes are "Internet" or "Print.".)
         */
        public CodeableConcept getCitedMedium() { 
          if (this.citedMedium == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormJournalIssueComponent.citedMedium");
            else if (Configuration.doAutoCreate())
              this.citedMedium = new CodeableConcept(); // cc
          return this.citedMedium;
        }

        public boolean hasCitedMedium() { 
          return this.citedMedium != null && !this.citedMedium.isEmpty();
        }

        /**
         * @param value {@link #citedMedium} (Describes the form of the medium cited. Common codes are "Internet" or "Print.".)
         */
        public CitationAlternativeFormJournalIssueComponent setCitedMedium(CodeableConcept value) { 
          this.citedMedium = value;
          return this;
        }

        /**
         * @return {@link #volume} (Volume number of journal in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getVolume" gives direct access to the value
         */
        public StringType getVolumeElement() { 
          if (this.volume == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormJournalIssueComponent.volume");
            else if (Configuration.doAutoCreate())
              this.volume = new StringType(); // bb
          return this.volume;
        }

        public boolean hasVolumeElement() { 
          return this.volume != null && !this.volume.isEmpty();
        }

        public boolean hasVolume() { 
          return this.volume != null && !this.volume.isEmpty();
        }

        /**
         * @param value {@link #volume} (Volume number of journal in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getVolume" gives direct access to the value
         */
        public CitationAlternativeFormJournalIssueComponent setVolumeElement(StringType value) { 
          this.volume = value;
          return this;
        }

        /**
         * @return Volume number of journal in which the article is published.
         */
        public String getVolume() { 
          return this.volume == null ? null : this.volume.getValue();
        }

        /**
         * @param value Volume number of journal in which the article is published.
         */
        public CitationAlternativeFormJournalIssueComponent setVolume(String value) { 
          if (Utilities.noString(value))
            this.volume = null;
          else {
            if (this.volume == null)
              this.volume = new StringType();
            this.volume.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #issue} (Issue, part or supplement of journal in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getIssue" gives direct access to the value
         */
        public StringType getIssueElement() { 
          if (this.issue == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormJournalIssueComponent.issue");
            else if (Configuration.doAutoCreate())
              this.issue = new StringType(); // bb
          return this.issue;
        }

        public boolean hasIssueElement() { 
          return this.issue != null && !this.issue.isEmpty();
        }

        public boolean hasIssue() { 
          return this.issue != null && !this.issue.isEmpty();
        }

        /**
         * @param value {@link #issue} (Issue, part or supplement of journal in which the article is published.). This is the underlying object with id, value and extensions. The accessor "getIssue" gives direct access to the value
         */
        public CitationAlternativeFormJournalIssueComponent setIssueElement(StringType value) { 
          this.issue = value;
          return this;
        }

        /**
         * @return Issue, part or supplement of journal in which the article is published.
         */
        public String getIssue() { 
          return this.issue == null ? null : this.issue.getValue();
        }

        /**
         * @param value Issue, part or supplement of journal in which the article is published.
         */
        public CitationAlternativeFormJournalIssueComponent setIssue(String value) { 
          if (Utilities.noString(value))
            this.issue = null;
          else {
            if (this.issue == null)
              this.issue = new StringType();
            this.issue.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #publicationDate} (Defining the date on which the issue of the joutnal was published.)
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent getPublicationDate() { 
          if (this.publicationDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormJournalIssueComponent.publicationDate");
            else if (Configuration.doAutoCreate())
              this.publicationDate = new CitationAlternativeFormJournalIssuePublicationDateComponent(); // cc
          return this.publicationDate;
        }

        public boolean hasPublicationDate() { 
          return this.publicationDate != null && !this.publicationDate.isEmpty();
        }

        /**
         * @param value {@link #publicationDate} (Defining the date on which the issue of the joutnal was published.)
         */
        public CitationAlternativeFormJournalIssueComponent setPublicationDate(CitationAlternativeFormJournalIssuePublicationDateComponent value) { 
          this.publicationDate = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("citedMedium", "CodeableConcept", "Describes the form of the medium cited. Common codes are \"Internet\" or \"Print.\".", 0, 1, citedMedium));
          children.add(new Property("volume", "string", "Volume number of journal in which the article is published.", 0, 1, volume));
          children.add(new Property("issue", "string", "Issue, part or supplement of journal in which the article is published.", 0, 1, issue));
          children.add(new Property("publicationDate", "", "Defining the date on which the issue of the joutnal was published.", 0, 1, publicationDate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 612116418: /*citedMedium*/  return new Property("citedMedium", "CodeableConcept", "Describes the form of the medium cited. Common codes are \"Internet\" or \"Print.\".", 0, 1, citedMedium);
          case -810883302: /*volume*/  return new Property("volume", "string", "Volume number of journal in which the article is published.", 0, 1, volume);
          case 100509913: /*issue*/  return new Property("issue", "string", "Issue, part or supplement of journal in which the article is published.", 0, 1, issue);
          case 1470566394: /*publicationDate*/  return new Property("publicationDate", "", "Defining the date on which the issue of the joutnal was published.", 0, 1, publicationDate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 612116418: /*citedMedium*/ return this.citedMedium == null ? new Base[0] : new Base[] {this.citedMedium}; // CodeableConcept
        case -810883302: /*volume*/ return this.volume == null ? new Base[0] : new Base[] {this.volume}; // StringType
        case 100509913: /*issue*/ return this.issue == null ? new Base[0] : new Base[] {this.issue}; // StringType
        case 1470566394: /*publicationDate*/ return this.publicationDate == null ? new Base[0] : new Base[] {this.publicationDate}; // CitationAlternativeFormJournalIssuePublicationDateComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 612116418: // citedMedium
          this.citedMedium = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -810883302: // volume
          this.volume = TypeConvertor.castToString(value); // StringType
          return value;
        case 100509913: // issue
          this.issue = TypeConvertor.castToString(value); // StringType
          return value;
        case 1470566394: // publicationDate
          this.publicationDate = (CitationAlternativeFormJournalIssuePublicationDateComponent) value; // CitationAlternativeFormJournalIssuePublicationDateComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("citedMedium")) {
          this.citedMedium = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("volume")) {
          this.volume = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("issue")) {
          this.issue = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("publicationDate")) {
          this.publicationDate = (CitationAlternativeFormJournalIssuePublicationDateComponent) value; // CitationAlternativeFormJournalIssuePublicationDateComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 612116418:  return getCitedMedium();
        case -810883302:  return getVolumeElement();
        case 100509913:  return getIssueElement();
        case 1470566394:  return getPublicationDate();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 612116418: /*citedMedium*/ return new String[] {"CodeableConcept"};
        case -810883302: /*volume*/ return new String[] {"string"};
        case 100509913: /*issue*/ return new String[] {"string"};
        case 1470566394: /*publicationDate*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("citedMedium")) {
          this.citedMedium = new CodeableConcept();
          return this.citedMedium;
        }
        else if (name.equals("volume")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.journalIssue.volume");
        }
        else if (name.equals("issue")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.journalIssue.issue");
        }
        else if (name.equals("publicationDate")) {
          this.publicationDate = new CitationAlternativeFormJournalIssuePublicationDateComponent();
          return this.publicationDate;
        }
        else
          return super.addChild(name);
      }

      public CitationAlternativeFormJournalIssueComponent copy() {
        CitationAlternativeFormJournalIssueComponent dst = new CitationAlternativeFormJournalIssueComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAlternativeFormJournalIssueComponent dst) {
        super.copyValues(dst);
        dst.citedMedium = citedMedium == null ? null : citedMedium.copy();
        dst.volume = volume == null ? null : volume.copy();
        dst.issue = issue == null ? null : issue.copy();
        dst.publicationDate = publicationDate == null ? null : publicationDate.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormJournalIssueComponent))
          return false;
        CitationAlternativeFormJournalIssueComponent o = (CitationAlternativeFormJournalIssueComponent) other_;
        return compareDeep(citedMedium, o.citedMedium, true) && compareDeep(volume, o.volume, true) && compareDeep(issue, o.issue, true)
           && compareDeep(publicationDate, o.publicationDate, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormJournalIssueComponent))
          return false;
        CitationAlternativeFormJournalIssueComponent o = (CitationAlternativeFormJournalIssueComponent) other_;
        return compareValues(volume, o.volume, true) && compareValues(issue, o.issue, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(citedMedium, volume, issue
          , publicationDate);
      }

  public String fhirType() {
    return "Citation.alternativeForm.journalIssue";

  }

  }

    @Block()
    public static class CitationAlternativeFormJournalIssuePublicationDateComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Date on which the issue of the journal was published.
         */
        @Child(name = "date", type = {DateType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Date on which the issue of the journal was published", formalDefinition="Date on which the issue of the journal was published." )
        protected DateType date;

        /**
         * Year on which the issue of the journal was published.
         */
        @Child(name = "year", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Year on which the issue of the journal was published", formalDefinition="Year on which the issue of the journal was published." )
        protected StringType year;

        /**
         * Month on which the issue of the journal was published.
         */
        @Child(name = "month", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Month on which the issue of the journal was published", formalDefinition="Month on which the issue of the journal was published." )
        protected StringType month;

        /**
         * Day on which the issue of the journal was published.
         */
        @Child(name = "day", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Day on which the issue of the journal was published", formalDefinition="Day on which the issue of the journal was published." )
        protected StringType day;

        /**
         * Spring, Summer, Fall/Autumn, Winter.
         */
        @Child(name = "season", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Season on which the issue of the jornal was published", formalDefinition="Spring, Summer, Fall/Autumn, Winter." )
        protected StringType season;

        /**
         * Text representation of the date of which the issue of the journal was published.
         */
        @Child(name = "text", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Text representation of the date of which the issue of the journal was published", formalDefinition="Text representation of the date of which the issue of the journal was published." )
        protected StringType text;

        private static final long serialVersionUID = 1585589146L;

    /**
     * Constructor
     */
      public CitationAlternativeFormJournalIssuePublicationDateComponent() {
        super();
      }

        /**
         * @return {@link #date} (Date on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public DateType getDateElement() { 
          if (this.date == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormJournalIssuePublicationDateComponent.date");
            else if (Configuration.doAutoCreate())
              this.date = new DateType(); // bb
          return this.date;
        }

        public boolean hasDateElement() { 
          return this.date != null && !this.date.isEmpty();
        }

        public boolean hasDate() { 
          return this.date != null && !this.date.isEmpty();
        }

        /**
         * @param value {@link #date} (Date on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setDateElement(DateType value) { 
          this.date = value;
          return this;
        }

        /**
         * @return Date on which the issue of the journal was published.
         */
        public Date getDate() { 
          return this.date == null ? null : this.date.getValue();
        }

        /**
         * @param value Date on which the issue of the journal was published.
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setDate(Date value) { 
          if (value == null)
            this.date = null;
          else {
            if (this.date == null)
              this.date = new DateType();
            this.date.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #year} (Year on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getYear" gives direct access to the value
         */
        public StringType getYearElement() { 
          if (this.year == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormJournalIssuePublicationDateComponent.year");
            else if (Configuration.doAutoCreate())
              this.year = new StringType(); // bb
          return this.year;
        }

        public boolean hasYearElement() { 
          return this.year != null && !this.year.isEmpty();
        }

        public boolean hasYear() { 
          return this.year != null && !this.year.isEmpty();
        }

        /**
         * @param value {@link #year} (Year on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getYear" gives direct access to the value
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setYearElement(StringType value) { 
          this.year = value;
          return this;
        }

        /**
         * @return Year on which the issue of the journal was published.
         */
        public String getYear() { 
          return this.year == null ? null : this.year.getValue();
        }

        /**
         * @param value Year on which the issue of the journal was published.
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setYear(String value) { 
          if (Utilities.noString(value))
            this.year = null;
          else {
            if (this.year == null)
              this.year = new StringType();
            this.year.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #month} (Month on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getMonth" gives direct access to the value
         */
        public StringType getMonthElement() { 
          if (this.month == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormJournalIssuePublicationDateComponent.month");
            else if (Configuration.doAutoCreate())
              this.month = new StringType(); // bb
          return this.month;
        }

        public boolean hasMonthElement() { 
          return this.month != null && !this.month.isEmpty();
        }

        public boolean hasMonth() { 
          return this.month != null && !this.month.isEmpty();
        }

        /**
         * @param value {@link #month} (Month on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getMonth" gives direct access to the value
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setMonthElement(StringType value) { 
          this.month = value;
          return this;
        }

        /**
         * @return Month on which the issue of the journal was published.
         */
        public String getMonth() { 
          return this.month == null ? null : this.month.getValue();
        }

        /**
         * @param value Month on which the issue of the journal was published.
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setMonth(String value) { 
          if (Utilities.noString(value))
            this.month = null;
          else {
            if (this.month == null)
              this.month = new StringType();
            this.month.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #day} (Day on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getDay" gives direct access to the value
         */
        public StringType getDayElement() { 
          if (this.day == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormJournalIssuePublicationDateComponent.day");
            else if (Configuration.doAutoCreate())
              this.day = new StringType(); // bb
          return this.day;
        }

        public boolean hasDayElement() { 
          return this.day != null && !this.day.isEmpty();
        }

        public boolean hasDay() { 
          return this.day != null && !this.day.isEmpty();
        }

        /**
         * @param value {@link #day} (Day on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getDay" gives direct access to the value
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setDayElement(StringType value) { 
          this.day = value;
          return this;
        }

        /**
         * @return Day on which the issue of the journal was published.
         */
        public String getDay() { 
          return this.day == null ? null : this.day.getValue();
        }

        /**
         * @param value Day on which the issue of the journal was published.
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setDay(String value) { 
          if (Utilities.noString(value))
            this.day = null;
          else {
            if (this.day == null)
              this.day = new StringType();
            this.day.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #season} (Spring, Summer, Fall/Autumn, Winter.). This is the underlying object with id, value and extensions. The accessor "getSeason" gives direct access to the value
         */
        public StringType getSeasonElement() { 
          if (this.season == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormJournalIssuePublicationDateComponent.season");
            else if (Configuration.doAutoCreate())
              this.season = new StringType(); // bb
          return this.season;
        }

        public boolean hasSeasonElement() { 
          return this.season != null && !this.season.isEmpty();
        }

        public boolean hasSeason() { 
          return this.season != null && !this.season.isEmpty();
        }

        /**
         * @param value {@link #season} (Spring, Summer, Fall/Autumn, Winter.). This is the underlying object with id, value and extensions. The accessor "getSeason" gives direct access to the value
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setSeasonElement(StringType value) { 
          this.season = value;
          return this;
        }

        /**
         * @return Spring, Summer, Fall/Autumn, Winter.
         */
        public String getSeason() { 
          return this.season == null ? null : this.season.getValue();
        }

        /**
         * @param value Spring, Summer, Fall/Autumn, Winter.
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setSeason(String value) { 
          if (Utilities.noString(value))
            this.season = null;
          else {
            if (this.season == null)
              this.season = new StringType();
            this.season.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #text} (Text representation of the date of which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public StringType getTextElement() { 
          if (this.text == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormJournalIssuePublicationDateComponent.text");
            else if (Configuration.doAutoCreate())
              this.text = new StringType(); // bb
          return this.text;
        }

        public boolean hasTextElement() { 
          return this.text != null && !this.text.isEmpty();
        }

        public boolean hasText() { 
          return this.text != null && !this.text.isEmpty();
        }

        /**
         * @param value {@link #text} (Text representation of the date of which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setTextElement(StringType value) { 
          this.text = value;
          return this;
        }

        /**
         * @return Text representation of the date of which the issue of the journal was published.
         */
        public String getText() { 
          return this.text == null ? null : this.text.getValue();
        }

        /**
         * @param value Text representation of the date of which the issue of the journal was published.
         */
        public CitationAlternativeFormJournalIssuePublicationDateComponent setText(String value) { 
          if (Utilities.noString(value))
            this.text = null;
          else {
            if (this.text == null)
              this.text = new StringType();
            this.text.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("date", "date", "Date on which the issue of the journal was published.", 0, 1, date));
          children.add(new Property("year", "string", "Year on which the issue of the journal was published.", 0, 1, year));
          children.add(new Property("month", "string", "Month on which the issue of the journal was published.", 0, 1, month));
          children.add(new Property("day", "string", "Day on which the issue of the journal was published.", 0, 1, day));
          children.add(new Property("season", "string", "Spring, Summer, Fall/Autumn, Winter.", 0, 1, season));
          children.add(new Property("text", "string", "Text representation of the date of which the issue of the journal was published.", 0, 1, text));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3076014: /*date*/  return new Property("date", "date", "Date on which the issue of the journal was published.", 0, 1, date);
          case 3704893: /*year*/  return new Property("year", "string", "Year on which the issue of the journal was published.", 0, 1, year);
          case 104080000: /*month*/  return new Property("month", "string", "Month on which the issue of the journal was published.", 0, 1, month);
          case 99228: /*day*/  return new Property("day", "string", "Day on which the issue of the journal was published.", 0, 1, day);
          case -906335517: /*season*/  return new Property("season", "string", "Spring, Summer, Fall/Autumn, Winter.", 0, 1, season);
          case 3556653: /*text*/  return new Property("text", "string", "Text representation of the date of which the issue of the journal was published.", 0, 1, text);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateType
        case 3704893: /*year*/ return this.year == null ? new Base[0] : new Base[] {this.year}; // StringType
        case 104080000: /*month*/ return this.month == null ? new Base[0] : new Base[] {this.month}; // StringType
        case 99228: /*day*/ return this.day == null ? new Base[0] : new Base[] {this.day}; // StringType
        case -906335517: /*season*/ return this.season == null ? new Base[0] : new Base[] {this.season}; // StringType
        case 3556653: /*text*/ return this.text == null ? new Base[0] : new Base[] {this.text}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3076014: // date
          this.date = TypeConvertor.castToDate(value); // DateType
          return value;
        case 3704893: // year
          this.year = TypeConvertor.castToString(value); // StringType
          return value;
        case 104080000: // month
          this.month = TypeConvertor.castToString(value); // StringType
          return value;
        case 99228: // day
          this.day = TypeConvertor.castToString(value); // StringType
          return value;
        case -906335517: // season
          this.season = TypeConvertor.castToString(value); // StringType
          return value;
        case 3556653: // text
          this.text = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("date")) {
          this.date = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("year")) {
          this.year = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("month")) {
          this.month = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("day")) {
          this.day = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("season")) {
          this.season = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("text")) {
          this.text = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3076014:  return getDateElement();
        case 3704893:  return getYearElement();
        case 104080000:  return getMonthElement();
        case 99228:  return getDayElement();
        case -906335517:  return getSeasonElement();
        case 3556653:  return getTextElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3076014: /*date*/ return new String[] {"date"};
        case 3704893: /*year*/ return new String[] {"string"};
        case 104080000: /*month*/ return new String[] {"string"};
        case 99228: /*day*/ return new String[] {"string"};
        case -906335517: /*season*/ return new String[] {"string"};
        case 3556653: /*text*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.journalIssue.publicationDate.date");
        }
        else if (name.equals("year")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.journalIssue.publicationDate.year");
        }
        else if (name.equals("month")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.journalIssue.publicationDate.month");
        }
        else if (name.equals("day")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.journalIssue.publicationDate.day");
        }
        else if (name.equals("season")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.journalIssue.publicationDate.season");
        }
        else if (name.equals("text")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.journalIssue.publicationDate.text");
        }
        else
          return super.addChild(name);
      }

      public CitationAlternativeFormJournalIssuePublicationDateComponent copy() {
        CitationAlternativeFormJournalIssuePublicationDateComponent dst = new CitationAlternativeFormJournalIssuePublicationDateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAlternativeFormJournalIssuePublicationDateComponent dst) {
        super.copyValues(dst);
        dst.date = date == null ? null : date.copy();
        dst.year = year == null ? null : year.copy();
        dst.month = month == null ? null : month.copy();
        dst.day = day == null ? null : day.copy();
        dst.season = season == null ? null : season.copy();
        dst.text = text == null ? null : text.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormJournalIssuePublicationDateComponent))
          return false;
        CitationAlternativeFormJournalIssuePublicationDateComponent o = (CitationAlternativeFormJournalIssuePublicationDateComponent) other_;
        return compareDeep(date, o.date, true) && compareDeep(year, o.year, true) && compareDeep(month, o.month, true)
           && compareDeep(day, o.day, true) && compareDeep(season, o.season, true) && compareDeep(text, o.text, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormJournalIssuePublicationDateComponent))
          return false;
        CitationAlternativeFormJournalIssuePublicationDateComponent o = (CitationAlternativeFormJournalIssuePublicationDateComponent) other_;
        return compareValues(date, o.date, true) && compareValues(year, o.year, true) && compareValues(month, o.month, true)
           && compareValues(day, o.day, true) && compareValues(season, o.season, true) && compareValues(text, o.text, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(date, year, month, day
          , season, text);
      }

  public String fhirType() {
    return "Citation.alternativeForm.journalIssue.publicationDate";

  }

  }

    @Block()
    public static class CitationAlternativeFormPaginationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used for full display of pagination.
         */
        @Child(name = "pageString", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for full display of pagination", formalDefinition="Used for full display of pagination." )
        protected StringType pageString;

        /**
         * Used for isolated representation of first page.
         */
        @Child(name = "firstPage", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for isolated representation of first page", formalDefinition="Used for isolated representation of first page." )
        protected StringType firstPage;

        /**
         * Used for isolated representation of last page.
         */
        @Child(name = "lastPage", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for isolated representation of last page", formalDefinition="Used for isolated representation of last page." )
        protected StringType lastPage;

        private static final long serialVersionUID = -690699049L;

    /**
     * Constructor
     */
      public CitationAlternativeFormPaginationComponent() {
        super();
      }

        /**
         * @return {@link #pageString} (Used for full display of pagination.). This is the underlying object with id, value and extensions. The accessor "getPageString" gives direct access to the value
         */
        public StringType getPageStringElement() { 
          if (this.pageString == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPaginationComponent.pageString");
            else if (Configuration.doAutoCreate())
              this.pageString = new StringType(); // bb
          return this.pageString;
        }

        public boolean hasPageStringElement() { 
          return this.pageString != null && !this.pageString.isEmpty();
        }

        public boolean hasPageString() { 
          return this.pageString != null && !this.pageString.isEmpty();
        }

        /**
         * @param value {@link #pageString} (Used for full display of pagination.). This is the underlying object with id, value and extensions. The accessor "getPageString" gives direct access to the value
         */
        public CitationAlternativeFormPaginationComponent setPageStringElement(StringType value) { 
          this.pageString = value;
          return this;
        }

        /**
         * @return Used for full display of pagination.
         */
        public String getPageString() { 
          return this.pageString == null ? null : this.pageString.getValue();
        }

        /**
         * @param value Used for full display of pagination.
         */
        public CitationAlternativeFormPaginationComponent setPageString(String value) { 
          if (Utilities.noString(value))
            this.pageString = null;
          else {
            if (this.pageString == null)
              this.pageString = new StringType();
            this.pageString.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #firstPage} (Used for isolated representation of first page.). This is the underlying object with id, value and extensions. The accessor "getFirstPage" gives direct access to the value
         */
        public StringType getFirstPageElement() { 
          if (this.firstPage == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPaginationComponent.firstPage");
            else if (Configuration.doAutoCreate())
              this.firstPage = new StringType(); // bb
          return this.firstPage;
        }

        public boolean hasFirstPageElement() { 
          return this.firstPage != null && !this.firstPage.isEmpty();
        }

        public boolean hasFirstPage() { 
          return this.firstPage != null && !this.firstPage.isEmpty();
        }

        /**
         * @param value {@link #firstPage} (Used for isolated representation of first page.). This is the underlying object with id, value and extensions. The accessor "getFirstPage" gives direct access to the value
         */
        public CitationAlternativeFormPaginationComponent setFirstPageElement(StringType value) { 
          this.firstPage = value;
          return this;
        }

        /**
         * @return Used for isolated representation of first page.
         */
        public String getFirstPage() { 
          return this.firstPage == null ? null : this.firstPage.getValue();
        }

        /**
         * @param value Used for isolated representation of first page.
         */
        public CitationAlternativeFormPaginationComponent setFirstPage(String value) { 
          if (Utilities.noString(value))
            this.firstPage = null;
          else {
            if (this.firstPage == null)
              this.firstPage = new StringType();
            this.firstPage.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #lastPage} (Used for isolated representation of last page.). This is the underlying object with id, value and extensions. The accessor "getLastPage" gives direct access to the value
         */
        public StringType getLastPageElement() { 
          if (this.lastPage == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPaginationComponent.lastPage");
            else if (Configuration.doAutoCreate())
              this.lastPage = new StringType(); // bb
          return this.lastPage;
        }

        public boolean hasLastPageElement() { 
          return this.lastPage != null && !this.lastPage.isEmpty();
        }

        public boolean hasLastPage() { 
          return this.lastPage != null && !this.lastPage.isEmpty();
        }

        /**
         * @param value {@link #lastPage} (Used for isolated representation of last page.). This is the underlying object with id, value and extensions. The accessor "getLastPage" gives direct access to the value
         */
        public CitationAlternativeFormPaginationComponent setLastPageElement(StringType value) { 
          this.lastPage = value;
          return this;
        }

        /**
         * @return Used for isolated representation of last page.
         */
        public String getLastPage() { 
          return this.lastPage == null ? null : this.lastPage.getValue();
        }

        /**
         * @param value Used for isolated representation of last page.
         */
        public CitationAlternativeFormPaginationComponent setLastPage(String value) { 
          if (Utilities.noString(value))
            this.lastPage = null;
          else {
            if (this.lastPage == null)
              this.lastPage = new StringType();
            this.lastPage.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("pageString", "string", "Used for full display of pagination.", 0, 1, pageString));
          children.add(new Property("firstPage", "string", "Used for isolated representation of first page.", 0, 1, firstPage));
          children.add(new Property("lastPage", "string", "Used for isolated representation of last page.", 0, 1, lastPage));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1287145344: /*pageString*/  return new Property("pageString", "string", "Used for full display of pagination.", 0, 1, pageString);
          case 132895071: /*firstPage*/  return new Property("firstPage", "string", "Used for isolated representation of first page.", 0, 1, firstPage);
          case -1459540411: /*lastPage*/  return new Property("lastPage", "string", "Used for isolated representation of last page.", 0, 1, lastPage);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1287145344: /*pageString*/ return this.pageString == null ? new Base[0] : new Base[] {this.pageString}; // StringType
        case 132895071: /*firstPage*/ return this.firstPage == null ? new Base[0] : new Base[] {this.firstPage}; // StringType
        case -1459540411: /*lastPage*/ return this.lastPage == null ? new Base[0] : new Base[] {this.lastPage}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1287145344: // pageString
          this.pageString = TypeConvertor.castToString(value); // StringType
          return value;
        case 132895071: // firstPage
          this.firstPage = TypeConvertor.castToString(value); // StringType
          return value;
        case -1459540411: // lastPage
          this.lastPage = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("pageString")) {
          this.pageString = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("firstPage")) {
          this.firstPage = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("lastPage")) {
          this.lastPage = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1287145344:  return getPageStringElement();
        case 132895071:  return getFirstPageElement();
        case -1459540411:  return getLastPageElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1287145344: /*pageString*/ return new String[] {"string"};
        case 132895071: /*firstPage*/ return new String[] {"string"};
        case -1459540411: /*lastPage*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("pageString")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.pagination.pageString");
        }
        else if (name.equals("firstPage")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.pagination.firstPage");
        }
        else if (name.equals("lastPage")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.pagination.lastPage");
        }
        else
          return super.addChild(name);
      }

      public CitationAlternativeFormPaginationComponent copy() {
        CitationAlternativeFormPaginationComponent dst = new CitationAlternativeFormPaginationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAlternativeFormPaginationComponent dst) {
        super.copyValues(dst);
        dst.pageString = pageString == null ? null : pageString.copy();
        dst.firstPage = firstPage == null ? null : firstPage.copy();
        dst.lastPage = lastPage == null ? null : lastPage.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormPaginationComponent))
          return false;
        CitationAlternativeFormPaginationComponent o = (CitationAlternativeFormPaginationComponent) other_;
        return compareDeep(pageString, o.pageString, true) && compareDeep(firstPage, o.firstPage, true)
           && compareDeep(lastPage, o.lastPage, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormPaginationComponent))
          return false;
        CitationAlternativeFormPaginationComponent o = (CitationAlternativeFormPaginationComponent) other_;
        return compareValues(pageString, o.pageString, true) && compareValues(firstPage, o.firstPage, true)
           && compareValues(lastPage, o.lastPage, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(pageString, firstPage, lastPage
          );
      }

  public String fhirType() {
    return "Citation.alternativeForm.pagination";

  }

  }

    @Block()
    public static class CitationAlternativeFormPublicationInfoComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The collection the cited article is published in.
         */
        @Child(name = "publishedIn", type = {}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The collection the cited article is published in", formalDefinition="The collection the cited article is published in." )
        protected CitationAlternativeFormPublicationInfoPublishedInComponent publishedIn;

        /**
         * The date the article was added to the database.
         */
        @Child(name = "entryDate", type = {DateTimeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The date the article was added to the database", formalDefinition="The date the article was added to the database." )
        protected DateTimeType entryDate;

        /**
         * The date the article was last revised or updated in the database.
         */
        @Child(name = "revisionDate", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The date the article was last revised or updated in the database", formalDefinition="The date the article was last revised or updated in the database." )
        protected DateTimeType revisionDate;

        /**
         * Actual or Approximate number of pages or screens.
         */
        @Child(name = "pageCount", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Number of pages or screens", formalDefinition="Actual or Approximate number of pages or screens." )
        protected StringType pageCount;

        private static final long serialVersionUID = -1109876499L;

    /**
     * Constructor
     */
      public CitationAlternativeFormPublicationInfoComponent() {
        super();
      }

        /**
         * @return {@link #publishedIn} (The collection the cited article is published in.)
         */
        public CitationAlternativeFormPublicationInfoPublishedInComponent getPublishedIn() { 
          if (this.publishedIn == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPublicationInfoComponent.publishedIn");
            else if (Configuration.doAutoCreate())
              this.publishedIn = new CitationAlternativeFormPublicationInfoPublishedInComponent(); // cc
          return this.publishedIn;
        }

        public boolean hasPublishedIn() { 
          return this.publishedIn != null && !this.publishedIn.isEmpty();
        }

        /**
         * @param value {@link #publishedIn} (The collection the cited article is published in.)
         */
        public CitationAlternativeFormPublicationInfoComponent setPublishedIn(CitationAlternativeFormPublicationInfoPublishedInComponent value) { 
          this.publishedIn = value;
          return this;
        }

        /**
         * @return {@link #entryDate} (The date the article was added to the database.). This is the underlying object with id, value and extensions. The accessor "getEntryDate" gives direct access to the value
         */
        public DateTimeType getEntryDateElement() { 
          if (this.entryDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPublicationInfoComponent.entryDate");
            else if (Configuration.doAutoCreate())
              this.entryDate = new DateTimeType(); // bb
          return this.entryDate;
        }

        public boolean hasEntryDateElement() { 
          return this.entryDate != null && !this.entryDate.isEmpty();
        }

        public boolean hasEntryDate() { 
          return this.entryDate != null && !this.entryDate.isEmpty();
        }

        /**
         * @param value {@link #entryDate} (The date the article was added to the database.). This is the underlying object with id, value and extensions. The accessor "getEntryDate" gives direct access to the value
         */
        public CitationAlternativeFormPublicationInfoComponent setEntryDateElement(DateTimeType value) { 
          this.entryDate = value;
          return this;
        }

        /**
         * @return The date the article was added to the database.
         */
        public Date getEntryDate() { 
          return this.entryDate == null ? null : this.entryDate.getValue();
        }

        /**
         * @param value The date the article was added to the database.
         */
        public CitationAlternativeFormPublicationInfoComponent setEntryDate(Date value) { 
          if (value == null)
            this.entryDate = null;
          else {
            if (this.entryDate == null)
              this.entryDate = new DateTimeType();
            this.entryDate.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #revisionDate} (The date the article was last revised or updated in the database.). This is the underlying object with id, value and extensions. The accessor "getRevisionDate" gives direct access to the value
         */
        public DateTimeType getRevisionDateElement() { 
          if (this.revisionDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPublicationInfoComponent.revisionDate");
            else if (Configuration.doAutoCreate())
              this.revisionDate = new DateTimeType(); // bb
          return this.revisionDate;
        }

        public boolean hasRevisionDateElement() { 
          return this.revisionDate != null && !this.revisionDate.isEmpty();
        }

        public boolean hasRevisionDate() { 
          return this.revisionDate != null && !this.revisionDate.isEmpty();
        }

        /**
         * @param value {@link #revisionDate} (The date the article was last revised or updated in the database.). This is the underlying object with id, value and extensions. The accessor "getRevisionDate" gives direct access to the value
         */
        public CitationAlternativeFormPublicationInfoComponent setRevisionDateElement(DateTimeType value) { 
          this.revisionDate = value;
          return this;
        }

        /**
         * @return The date the article was last revised or updated in the database.
         */
        public Date getRevisionDate() { 
          return this.revisionDate == null ? null : this.revisionDate.getValue();
        }

        /**
         * @param value The date the article was last revised or updated in the database.
         */
        public CitationAlternativeFormPublicationInfoComponent setRevisionDate(Date value) { 
          if (value == null)
            this.revisionDate = null;
          else {
            if (this.revisionDate == null)
              this.revisionDate = new DateTimeType();
            this.revisionDate.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #pageCount} (Actual or Approximate number of pages or screens.). This is the underlying object with id, value and extensions. The accessor "getPageCount" gives direct access to the value
         */
        public StringType getPageCountElement() { 
          if (this.pageCount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPublicationInfoComponent.pageCount");
            else if (Configuration.doAutoCreate())
              this.pageCount = new StringType(); // bb
          return this.pageCount;
        }

        public boolean hasPageCountElement() { 
          return this.pageCount != null && !this.pageCount.isEmpty();
        }

        public boolean hasPageCount() { 
          return this.pageCount != null && !this.pageCount.isEmpty();
        }

        /**
         * @param value {@link #pageCount} (Actual or Approximate number of pages or screens.). This is the underlying object with id, value and extensions. The accessor "getPageCount" gives direct access to the value
         */
        public CitationAlternativeFormPublicationInfoComponent setPageCountElement(StringType value) { 
          this.pageCount = value;
          return this;
        }

        /**
         * @return Actual or Approximate number of pages or screens.
         */
        public String getPageCount() { 
          return this.pageCount == null ? null : this.pageCount.getValue();
        }

        /**
         * @param value Actual or Approximate number of pages or screens.
         */
        public CitationAlternativeFormPublicationInfoComponent setPageCount(String value) { 
          if (Utilities.noString(value))
            this.pageCount = null;
          else {
            if (this.pageCount == null)
              this.pageCount = new StringType();
            this.pageCount.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("publishedIn", "", "The collection the cited article is published in.", 0, 1, publishedIn));
          children.add(new Property("entryDate", "dateTime", "The date the article was added to the database.", 0, 1, entryDate));
          children.add(new Property("revisionDate", "dateTime", "The date the article was last revised or updated in the database.", 0, 1, revisionDate));
          children.add(new Property("pageCount", "string", "Actual or Approximate number of pages or screens.", 0, 1, pageCount));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -614144077: /*publishedIn*/  return new Property("publishedIn", "", "The collection the cited article is published in.", 0, 1, publishedIn);
          case -479861952: /*entryDate*/  return new Property("entryDate", "dateTime", "The date the article was added to the database.", 0, 1, entryDate);
          case -1250970071: /*revisionDate*/  return new Property("revisionDate", "dateTime", "The date the article was last revised or updated in the database.", 0, 1, revisionDate);
          case 857882560: /*pageCount*/  return new Property("pageCount", "string", "Actual or Approximate number of pages or screens.", 0, 1, pageCount);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -614144077: /*publishedIn*/ return this.publishedIn == null ? new Base[0] : new Base[] {this.publishedIn}; // CitationAlternativeFormPublicationInfoPublishedInComponent
        case -479861952: /*entryDate*/ return this.entryDate == null ? new Base[0] : new Base[] {this.entryDate}; // DateTimeType
        case -1250970071: /*revisionDate*/ return this.revisionDate == null ? new Base[0] : new Base[] {this.revisionDate}; // DateTimeType
        case 857882560: /*pageCount*/ return this.pageCount == null ? new Base[0] : new Base[] {this.pageCount}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -614144077: // publishedIn
          this.publishedIn = (CitationAlternativeFormPublicationInfoPublishedInComponent) value; // CitationAlternativeFormPublicationInfoPublishedInComponent
          return value;
        case -479861952: // entryDate
          this.entryDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1250970071: // revisionDate
          this.revisionDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 857882560: // pageCount
          this.pageCount = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("publishedIn")) {
          this.publishedIn = (CitationAlternativeFormPublicationInfoPublishedInComponent) value; // CitationAlternativeFormPublicationInfoPublishedInComponent
        } else if (name.equals("entryDate")) {
          this.entryDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("revisionDate")) {
          this.revisionDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("pageCount")) {
          this.pageCount = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -614144077:  return getPublishedIn();
        case -479861952:  return getEntryDateElement();
        case -1250970071:  return getRevisionDateElement();
        case 857882560:  return getPageCountElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -614144077: /*publishedIn*/ return new String[] {};
        case -479861952: /*entryDate*/ return new String[] {"dateTime"};
        case -1250970071: /*revisionDate*/ return new String[] {"dateTime"};
        case 857882560: /*pageCount*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("publishedIn")) {
          this.publishedIn = new CitationAlternativeFormPublicationInfoPublishedInComponent();
          return this.publishedIn;
        }
        else if (name.equals("entryDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.publicationInfo.entryDate");
        }
        else if (name.equals("revisionDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.publicationInfo.revisionDate");
        }
        else if (name.equals("pageCount")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.publicationInfo.pageCount");
        }
        else
          return super.addChild(name);
      }

      public CitationAlternativeFormPublicationInfoComponent copy() {
        CitationAlternativeFormPublicationInfoComponent dst = new CitationAlternativeFormPublicationInfoComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAlternativeFormPublicationInfoComponent dst) {
        super.copyValues(dst);
        dst.publishedIn = publishedIn == null ? null : publishedIn.copy();
        dst.entryDate = entryDate == null ? null : entryDate.copy();
        dst.revisionDate = revisionDate == null ? null : revisionDate.copy();
        dst.pageCount = pageCount == null ? null : pageCount.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormPublicationInfoComponent))
          return false;
        CitationAlternativeFormPublicationInfoComponent o = (CitationAlternativeFormPublicationInfoComponent) other_;
        return compareDeep(publishedIn, o.publishedIn, true) && compareDeep(entryDate, o.entryDate, true)
           && compareDeep(revisionDate, o.revisionDate, true) && compareDeep(pageCount, o.pageCount, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormPublicationInfoComponent))
          return false;
        CitationAlternativeFormPublicationInfoComponent o = (CitationAlternativeFormPublicationInfoComponent) other_;
        return compareValues(entryDate, o.entryDate, true) && compareValues(revisionDate, o.revisionDate, true)
           && compareValues(pageCount, o.pageCount, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(publishedIn, entryDate, revisionDate
          , pageCount);
      }

  public String fhirType() {
    return "Citation.alternativeForm.publicationInfo";

  }

  }

    @Block()
    public static class CitationAlternativeFormPublicationInfoPublishedInComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Database or book.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Database or book", formalDefinition="Database or book." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/published-in-type")
        protected CodeableConcept type;

        /**
         * Name of the database or title of the book.
         */
        @Child(name = "name", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of the database or title of the book", formalDefinition="Name of the database or title of the book." )
        protected StringType name;

        /**
         * Name of the publisher.
         */
        @Child(name = "publisher", type = {Organization.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of the publisher", formalDefinition="Name of the publisher." )
        protected Reference publisher;

        /**
         * Geographic location of the publisher.
         */
        @Child(name = "publisherLocation", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Geographic location of the publisher", formalDefinition="Geographic location of the publisher." )
        protected StringType publisherLocation;

        /**
         * When the database was first available or when the book was published.
         */
        @Child(name = "startDate", type = {DateType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When the database was first available or when the book was published", formalDefinition="When the database was first available or when the book was published." )
        protected DateType startDate;

        private static final long serialVersionUID = 17141502L;

    /**
     * Constructor
     */
      public CitationAlternativeFormPublicationInfoPublishedInComponent() {
        super();
      }

        /**
         * @return {@link #type} (Database or book.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPublicationInfoPublishedInComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Database or book.)
         */
        public CitationAlternativeFormPublicationInfoPublishedInComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #name} (Name of the database or title of the book.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPublicationInfoPublishedInComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new StringType(); // bb
          return this.name;
        }

        public boolean hasNameElement() { 
          return this.name != null && !this.name.isEmpty();
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (Name of the database or title of the book.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public CitationAlternativeFormPublicationInfoPublishedInComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name of the database or title of the book.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name of the database or title of the book.
         */
        public CitationAlternativeFormPublicationInfoPublishedInComponent setName(String value) { 
          if (Utilities.noString(value))
            this.name = null;
          else {
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #publisher} (Name of the publisher.)
         */
        public Reference getPublisher() { 
          if (this.publisher == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPublicationInfoPublishedInComponent.publisher");
            else if (Configuration.doAutoCreate())
              this.publisher = new Reference(); // cc
          return this.publisher;
        }

        public boolean hasPublisher() { 
          return this.publisher != null && !this.publisher.isEmpty();
        }

        /**
         * @param value {@link #publisher} (Name of the publisher.)
         */
        public CitationAlternativeFormPublicationInfoPublishedInComponent setPublisher(Reference value) { 
          this.publisher = value;
          return this;
        }

        /**
         * @return {@link #publisherLocation} (Geographic location of the publisher.). This is the underlying object with id, value and extensions. The accessor "getPublisherLocation" gives direct access to the value
         */
        public StringType getPublisherLocationElement() { 
          if (this.publisherLocation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPublicationInfoPublishedInComponent.publisherLocation");
            else if (Configuration.doAutoCreate())
              this.publisherLocation = new StringType(); // bb
          return this.publisherLocation;
        }

        public boolean hasPublisherLocationElement() { 
          return this.publisherLocation != null && !this.publisherLocation.isEmpty();
        }

        public boolean hasPublisherLocation() { 
          return this.publisherLocation != null && !this.publisherLocation.isEmpty();
        }

        /**
         * @param value {@link #publisherLocation} (Geographic location of the publisher.). This is the underlying object with id, value and extensions. The accessor "getPublisherLocation" gives direct access to the value
         */
        public CitationAlternativeFormPublicationInfoPublishedInComponent setPublisherLocationElement(StringType value) { 
          this.publisherLocation = value;
          return this;
        }

        /**
         * @return Geographic location of the publisher.
         */
        public String getPublisherLocation() { 
          return this.publisherLocation == null ? null : this.publisherLocation.getValue();
        }

        /**
         * @param value Geographic location of the publisher.
         */
        public CitationAlternativeFormPublicationInfoPublishedInComponent setPublisherLocation(String value) { 
          if (Utilities.noString(value))
            this.publisherLocation = null;
          else {
            if (this.publisherLocation == null)
              this.publisherLocation = new StringType();
            this.publisherLocation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #startDate} (When the database was first available or when the book was published.). This is the underlying object with id, value and extensions. The accessor "getStartDate" gives direct access to the value
         */
        public DateType getStartDateElement() { 
          if (this.startDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormPublicationInfoPublishedInComponent.startDate");
            else if (Configuration.doAutoCreate())
              this.startDate = new DateType(); // bb
          return this.startDate;
        }

        public boolean hasStartDateElement() { 
          return this.startDate != null && !this.startDate.isEmpty();
        }

        public boolean hasStartDate() { 
          return this.startDate != null && !this.startDate.isEmpty();
        }

        /**
         * @param value {@link #startDate} (When the database was first available or when the book was published.). This is the underlying object with id, value and extensions. The accessor "getStartDate" gives direct access to the value
         */
        public CitationAlternativeFormPublicationInfoPublishedInComponent setStartDateElement(DateType value) { 
          this.startDate = value;
          return this;
        }

        /**
         * @return When the database was first available or when the book was published.
         */
        public Date getStartDate() { 
          return this.startDate == null ? null : this.startDate.getValue();
        }

        /**
         * @param value When the database was first available or when the book was published.
         */
        public CitationAlternativeFormPublicationInfoPublishedInComponent setStartDate(Date value) { 
          if (value == null)
            this.startDate = null;
          else {
            if (this.startDate == null)
              this.startDate = new DateType();
            this.startDate.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Database or book.", 0, 1, type));
          children.add(new Property("name", "string", "Name of the database or title of the book.", 0, 1, name));
          children.add(new Property("publisher", "Reference(Organization)", "Name of the publisher.", 0, 1, publisher));
          children.add(new Property("publisherLocation", "string", "Geographic location of the publisher.", 0, 1, publisherLocation));
          children.add(new Property("startDate", "date", "When the database was first available or when the book was published.", 0, 1, startDate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Database or book.", 0, 1, type);
          case 3373707: /*name*/  return new Property("name", "string", "Name of the database or title of the book.", 0, 1, name);
          case 1447404028: /*publisher*/  return new Property("publisher", "Reference(Organization)", "Name of the publisher.", 0, 1, publisher);
          case -1281627695: /*publisherLocation*/  return new Property("publisherLocation", "string", "Geographic location of the publisher.", 0, 1, publisherLocation);
          case -2129778896: /*startDate*/  return new Property("startDate", "date", "When the database was first available or when the book was published.", 0, 1, startDate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // Reference
        case -1281627695: /*publisherLocation*/ return this.publisherLocation == null ? new Base[0] : new Base[] {this.publisherLocation}; // StringType
        case -2129778896: /*startDate*/ return this.startDate == null ? new Base[0] : new Base[] {this.startDate}; // DateType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 1447404028: // publisher
          this.publisher = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1281627695: // publisherLocation
          this.publisherLocation = TypeConvertor.castToString(value); // StringType
          return value;
        case -2129778896: // startDate
          this.startDate = TypeConvertor.castToDate(value); // DateType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("publisherLocation")) {
          this.publisherLocation = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("startDate")) {
          this.startDate = TypeConvertor.castToDate(value); // DateType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 3373707:  return getNameElement();
        case 1447404028:  return getPublisher();
        case -1281627695:  return getPublisherLocationElement();
        case -2129778896:  return getStartDateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 1447404028: /*publisher*/ return new String[] {"Reference"};
        case -1281627695: /*publisherLocation*/ return new String[] {"string"};
        case -2129778896: /*startDate*/ return new String[] {"date"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.publicationInfo.publishedIn.name");
        }
        else if (name.equals("publisher")) {
          this.publisher = new Reference();
          return this.publisher;
        }
        else if (name.equals("publisherLocation")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.publicationInfo.publishedIn.publisherLocation");
        }
        else if (name.equals("startDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.publicationInfo.publishedIn.startDate");
        }
        else
          return super.addChild(name);
      }

      public CitationAlternativeFormPublicationInfoPublishedInComponent copy() {
        CitationAlternativeFormPublicationInfoPublishedInComponent dst = new CitationAlternativeFormPublicationInfoPublishedInComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAlternativeFormPublicationInfoPublishedInComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.name = name == null ? null : name.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        dst.publisherLocation = publisherLocation == null ? null : publisherLocation.copy();
        dst.startDate = startDate == null ? null : startDate.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormPublicationInfoPublishedInComponent))
          return false;
        CitationAlternativeFormPublicationInfoPublishedInComponent o = (CitationAlternativeFormPublicationInfoPublishedInComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(name, o.name, true) && compareDeep(publisher, o.publisher, true)
           && compareDeep(publisherLocation, o.publisherLocation, true) && compareDeep(startDate, o.startDate, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAlternativeFormPublicationInfoPublishedInComponent))
          return false;
        CitationAlternativeFormPublicationInfoPublishedInComponent o = (CitationAlternativeFormPublicationInfoPublishedInComponent) other_;
        return compareValues(name, o.name, true) && compareValues(publisherLocation, o.publisherLocation, true)
           && compareValues(startDate, o.startDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, name, publisher, publisherLocation
          , startDate);
      }

  public String fhirType() {
    return "Citation.alternativeForm.publicationInfo.publishedIn";

  }

  }

    @Block()
    public static class CitationKeywordListComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The entity responsible for the creation or maintenance of this keyword list.
         */
        @Child(name = "owner", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Author, publisher, or custodian of the keyword list", formalDefinition="The entity responsible for the creation or maintenance of this keyword list." )
        protected StringType owner;

        /**
         * For each keyword in the keyword list.
         */
        @Child(name = "keyword", type = {}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="For each keyword in the keyword list", formalDefinition="For each keyword in the keyword list." )
        protected List<CitationKeywordListKeywordComponent> keyword;

        private static final long serialVersionUID = -1638002879L;

    /**
     * Constructor
     */
      public CitationKeywordListComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationKeywordListComponent(CitationKeywordListKeywordComponent keyword) {
        super();
        this.addKeyword(keyword);
      }

        /**
         * @return {@link #owner} (The entity responsible for the creation or maintenance of this keyword list.). This is the underlying object with id, value and extensions. The accessor "getOwner" gives direct access to the value
         */
        public StringType getOwnerElement() { 
          if (this.owner == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationKeywordListComponent.owner");
            else if (Configuration.doAutoCreate())
              this.owner = new StringType(); // bb
          return this.owner;
        }

        public boolean hasOwnerElement() { 
          return this.owner != null && !this.owner.isEmpty();
        }

        public boolean hasOwner() { 
          return this.owner != null && !this.owner.isEmpty();
        }

        /**
         * @param value {@link #owner} (The entity responsible for the creation or maintenance of this keyword list.). This is the underlying object with id, value and extensions. The accessor "getOwner" gives direct access to the value
         */
        public CitationKeywordListComponent setOwnerElement(StringType value) { 
          this.owner = value;
          return this;
        }

        /**
         * @return The entity responsible for the creation or maintenance of this keyword list.
         */
        public String getOwner() { 
          return this.owner == null ? null : this.owner.getValue();
        }

        /**
         * @param value The entity responsible for the creation or maintenance of this keyword list.
         */
        public CitationKeywordListComponent setOwner(String value) { 
          if (Utilities.noString(value))
            this.owner = null;
          else {
            if (this.owner == null)
              this.owner = new StringType();
            this.owner.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #keyword} (For each keyword in the keyword list.)
         */
        public List<CitationKeywordListKeywordComponent> getKeyword() { 
          if (this.keyword == null)
            this.keyword = new ArrayList<CitationKeywordListKeywordComponent>();
          return this.keyword;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationKeywordListComponent setKeyword(List<CitationKeywordListKeywordComponent> theKeyword) { 
          this.keyword = theKeyword;
          return this;
        }

        public boolean hasKeyword() { 
          if (this.keyword == null)
            return false;
          for (CitationKeywordListKeywordComponent item : this.keyword)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationKeywordListKeywordComponent addKeyword() { //3
          CitationKeywordListKeywordComponent t = new CitationKeywordListKeywordComponent();
          if (this.keyword == null)
            this.keyword = new ArrayList<CitationKeywordListKeywordComponent>();
          this.keyword.add(t);
          return t;
        }

        public CitationKeywordListComponent addKeyword(CitationKeywordListKeywordComponent t) { //3
          if (t == null)
            return this;
          if (this.keyword == null)
            this.keyword = new ArrayList<CitationKeywordListKeywordComponent>();
          this.keyword.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #keyword}, creating it if it does not already exist {3}
         */
        public CitationKeywordListKeywordComponent getKeywordFirstRep() { 
          if (getKeyword().isEmpty()) {
            addKeyword();
          }
          return getKeyword().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("owner", "string", "The entity responsible for the creation or maintenance of this keyword list.", 0, 1, owner));
          children.add(new Property("keyword", "", "For each keyword in the keyword list.", 0, java.lang.Integer.MAX_VALUE, keyword));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 106164915: /*owner*/  return new Property("owner", "string", "The entity responsible for the creation or maintenance of this keyword list.", 0, 1, owner);
          case -814408215: /*keyword*/  return new Property("keyword", "", "For each keyword in the keyword list.", 0, java.lang.Integer.MAX_VALUE, keyword);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 106164915: /*owner*/ return this.owner == null ? new Base[0] : new Base[] {this.owner}; // StringType
        case -814408215: /*keyword*/ return this.keyword == null ? new Base[0] : this.keyword.toArray(new Base[this.keyword.size()]); // CitationKeywordListKeywordComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 106164915: // owner
          this.owner = TypeConvertor.castToString(value); // StringType
          return value;
        case -814408215: // keyword
          this.getKeyword().add((CitationKeywordListKeywordComponent) value); // CitationKeywordListKeywordComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("owner")) {
          this.owner = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("keyword")) {
          this.getKeyword().add((CitationKeywordListKeywordComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106164915:  return getOwnerElement();
        case -814408215:  return addKeyword(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106164915: /*owner*/ return new String[] {"string"};
        case -814408215: /*keyword*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("owner")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.keywordList.owner");
        }
        else if (name.equals("keyword")) {
          return addKeyword();
        }
        else
          return super.addChild(name);
      }

      public CitationKeywordListComponent copy() {
        CitationKeywordListComponent dst = new CitationKeywordListComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationKeywordListComponent dst) {
        super.copyValues(dst);
        dst.owner = owner == null ? null : owner.copy();
        if (keyword != null) {
          dst.keyword = new ArrayList<CitationKeywordListKeywordComponent>();
          for (CitationKeywordListKeywordComponent i : keyword)
            dst.keyword.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationKeywordListComponent))
          return false;
        CitationKeywordListComponent o = (CitationKeywordListComponent) other_;
        return compareDeep(owner, o.owner, true) && compareDeep(keyword, o.keyword, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationKeywordListComponent))
          return false;
        CitationKeywordListComponent o = (CitationKeywordListComponent) other_;
        return compareValues(owner, o.owner, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(owner, keyword);
      }

  public String fhirType() {
    return "Citation.keywordList";

  }

  }

    @Block()
    public static class CitationKeywordListKeywordComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Whether or not it is a major topic.
         */
        @Child(name = "majorTopic", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether or not it is a major topic", formalDefinition="Whether or not it is a major topic." )
        protected BooleanType majorTopic;

        /**
         * The actual keyword.
         */
        @Child(name = "value", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The actual keyword", formalDefinition="The actual keyword." )
        protected StringType value;

        private static final long serialVersionUID = 853626648L;

    /**
     * Constructor
     */
      public CitationKeywordListKeywordComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationKeywordListKeywordComponent(String value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #majorTopic} (Whether or not it is a major topic.). This is the underlying object with id, value and extensions. The accessor "getMajorTopic" gives direct access to the value
         */
        public BooleanType getMajorTopicElement() { 
          if (this.majorTopic == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationKeywordListKeywordComponent.majorTopic");
            else if (Configuration.doAutoCreate())
              this.majorTopic = new BooleanType(); // bb
          return this.majorTopic;
        }

        public boolean hasMajorTopicElement() { 
          return this.majorTopic != null && !this.majorTopic.isEmpty();
        }

        public boolean hasMajorTopic() { 
          return this.majorTopic != null && !this.majorTopic.isEmpty();
        }

        /**
         * @param value {@link #majorTopic} (Whether or not it is a major topic.). This is the underlying object with id, value and extensions. The accessor "getMajorTopic" gives direct access to the value
         */
        public CitationKeywordListKeywordComponent setMajorTopicElement(BooleanType value) { 
          this.majorTopic = value;
          return this;
        }

        /**
         * @return Whether or not it is a major topic.
         */
        public boolean getMajorTopic() { 
          return this.majorTopic == null || this.majorTopic.isEmpty() ? false : this.majorTopic.getValue();
        }

        /**
         * @param value Whether or not it is a major topic.
         */
        public CitationKeywordListKeywordComponent setMajorTopic(boolean value) { 
            if (this.majorTopic == null)
              this.majorTopic = new BooleanType();
            this.majorTopic.setValue(value);
          return this;
        }

        /**
         * @return {@link #value} (The actual keyword.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationKeywordListKeywordComponent.value");
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
         * @param value {@link #value} (The actual keyword.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public CitationKeywordListKeywordComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The actual keyword.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The actual keyword.
         */
        public CitationKeywordListKeywordComponent setValue(String value) { 
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("majorTopic", "boolean", "Whether or not it is a major topic.", 0, 1, majorTopic));
          children.add(new Property("value", "string", "The actual keyword.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -341847306: /*majorTopic*/  return new Property("majorTopic", "boolean", "Whether or not it is a major topic.", 0, 1, majorTopic);
          case 111972721: /*value*/  return new Property("value", "string", "The actual keyword.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -341847306: /*majorTopic*/ return this.majorTopic == null ? new Base[0] : new Base[] {this.majorTopic}; // BooleanType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -341847306: // majorTopic
          this.majorTopic = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("majorTopic")) {
          this.majorTopic = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -341847306:  return getMajorTopicElement();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -341847306: /*majorTopic*/ return new String[] {"boolean"};
        case 111972721: /*value*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("majorTopic")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.keywordList.keyword.majorTopic");
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.keywordList.keyword.value");
        }
        else
          return super.addChild(name);
      }

      public CitationKeywordListKeywordComponent copy() {
        CitationKeywordListKeywordComponent dst = new CitationKeywordListKeywordComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationKeywordListKeywordComponent dst) {
        super.copyValues(dst);
        dst.majorTopic = majorTopic == null ? null : majorTopic.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationKeywordListKeywordComponent))
          return false;
        CitationKeywordListKeywordComponent o = (CitationKeywordListKeywordComponent) other_;
        return compareDeep(majorTopic, o.majorTopic, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationKeywordListKeywordComponent))
          return false;
        CitationKeywordListKeywordComponent o = (CitationKeywordListKeywordComponent) other_;
        return compareValues(majorTopic, o.majorTopic, true) && compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(majorTopic, value);
      }

  public String fhirType() {
    return "Citation.keywordList.keyword";

  }

  }

    @Block()
    public static class CitationMedlinePubMedComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used for status.
         */
        @Child(name = "medlineState", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Completed | In-Process | PubMed-not-MEDLINE | In-Data-Review | Publisher | MEDLINE | OLDMEDLINE", formalDefinition="Used for status." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medline-pubmed-status")
        protected CodeableConcept medlineState;

        /**
         * Used for owner.
         */
        @Child(name = "owner", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="NLM | NASA | PIP | KIE | HSR | HMD | SIS | NOTNLM", formalDefinition="Used for owner." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medline-pubmed-owner")
        protected CodeableConcept owner;

        /**
         * PubMed ID.
         */
        @Child(name = "pmid", type = {PositiveIntType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="PubMed ID", formalDefinition="PubMed ID." )
        protected PositiveIntType pmid;

        /**
         * PubMed ID Version.
         */
        @Child(name = "pmidVersion", type = {PositiveIntType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="PubMed ID Version", formalDefinition="PubMed ID Version." )
        protected PositiveIntType pmidVersion;

        /**
         * Creation date.
         */
        @Child(name = "dateCreated", type = {DateType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Creation date", formalDefinition="Creation date." )
        protected DateType dateCreated;

        /**
         * Completion date.
         */
        @Child(name = "dateCompleted", type = {DateType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Completion date", formalDefinition="Completion date." )
        protected DateType dateCompleted;

        /**
         * Revision date.
         */
        @Child(name = "dateRevised", type = {DateType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Revision date", formalDefinition="Revision date." )
        protected DateType dateRevised;

        /**
         * Subcomponent of certainty.
         */
        @Child(name = "pubMedPubDate", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Subcomponent of certainty", formalDefinition="Subcomponent of certainty." )
        protected List<CitationMedlinePubMedPubMedPubDateComponent> pubMedPubDate;

        /**
         * Publication Status.
         */
        @Child(name = "publicationState", type = {CodeableConcept.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Publication Status", formalDefinition="Publication Status." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/pubmed-pubstatus")
        protected CodeableConcept publicationState;

        /**
         * Related article.
         */
        @Child(name = "relatedArticle", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Related article", formalDefinition="Related article." )
        protected List<CitationMedlinePubMedRelatedArticleComponent> relatedArticle;

        private static final long serialVersionUID = -455295099L;

    /**
     * Constructor
     */
      public CitationMedlinePubMedComponent() {
        super();
      }

        /**
         * @return {@link #medlineState} (Used for status.)
         */
        public CodeableConcept getMedlineState() { 
          if (this.medlineState == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedComponent.medlineState");
            else if (Configuration.doAutoCreate())
              this.medlineState = new CodeableConcept(); // cc
          return this.medlineState;
        }

        public boolean hasMedlineState() { 
          return this.medlineState != null && !this.medlineState.isEmpty();
        }

        /**
         * @param value {@link #medlineState} (Used for status.)
         */
        public CitationMedlinePubMedComponent setMedlineState(CodeableConcept value) { 
          this.medlineState = value;
          return this;
        }

        /**
         * @return {@link #owner} (Used for owner.)
         */
        public CodeableConcept getOwner() { 
          if (this.owner == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedComponent.owner");
            else if (Configuration.doAutoCreate())
              this.owner = new CodeableConcept(); // cc
          return this.owner;
        }

        public boolean hasOwner() { 
          return this.owner != null && !this.owner.isEmpty();
        }

        /**
         * @param value {@link #owner} (Used for owner.)
         */
        public CitationMedlinePubMedComponent setOwner(CodeableConcept value) { 
          this.owner = value;
          return this;
        }

        /**
         * @return {@link #pmid} (PubMed ID.). This is the underlying object with id, value and extensions. The accessor "getPmid" gives direct access to the value
         */
        public PositiveIntType getPmidElement() { 
          if (this.pmid == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedComponent.pmid");
            else if (Configuration.doAutoCreate())
              this.pmid = new PositiveIntType(); // bb
          return this.pmid;
        }

        public boolean hasPmidElement() { 
          return this.pmid != null && !this.pmid.isEmpty();
        }

        public boolean hasPmid() { 
          return this.pmid != null && !this.pmid.isEmpty();
        }

        /**
         * @param value {@link #pmid} (PubMed ID.). This is the underlying object with id, value and extensions. The accessor "getPmid" gives direct access to the value
         */
        public CitationMedlinePubMedComponent setPmidElement(PositiveIntType value) { 
          this.pmid = value;
          return this;
        }

        /**
         * @return PubMed ID.
         */
        public int getPmid() { 
          return this.pmid == null || this.pmid.isEmpty() ? 0 : this.pmid.getValue();
        }

        /**
         * @param value PubMed ID.
         */
        public CitationMedlinePubMedComponent setPmid(int value) { 
            if (this.pmid == null)
              this.pmid = new PositiveIntType();
            this.pmid.setValue(value);
          return this;
        }

        /**
         * @return {@link #pmidVersion} (PubMed ID Version.). This is the underlying object with id, value and extensions. The accessor "getPmidVersion" gives direct access to the value
         */
        public PositiveIntType getPmidVersionElement() { 
          if (this.pmidVersion == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedComponent.pmidVersion");
            else if (Configuration.doAutoCreate())
              this.pmidVersion = new PositiveIntType(); // bb
          return this.pmidVersion;
        }

        public boolean hasPmidVersionElement() { 
          return this.pmidVersion != null && !this.pmidVersion.isEmpty();
        }

        public boolean hasPmidVersion() { 
          return this.pmidVersion != null && !this.pmidVersion.isEmpty();
        }

        /**
         * @param value {@link #pmidVersion} (PubMed ID Version.). This is the underlying object with id, value and extensions. The accessor "getPmidVersion" gives direct access to the value
         */
        public CitationMedlinePubMedComponent setPmidVersionElement(PositiveIntType value) { 
          this.pmidVersion = value;
          return this;
        }

        /**
         * @return PubMed ID Version.
         */
        public int getPmidVersion() { 
          return this.pmidVersion == null || this.pmidVersion.isEmpty() ? 0 : this.pmidVersion.getValue();
        }

        /**
         * @param value PubMed ID Version.
         */
        public CitationMedlinePubMedComponent setPmidVersion(int value) { 
            if (this.pmidVersion == null)
              this.pmidVersion = new PositiveIntType();
            this.pmidVersion.setValue(value);
          return this;
        }

        /**
         * @return {@link #dateCreated} (Creation date.). This is the underlying object with id, value and extensions. The accessor "getDateCreated" gives direct access to the value
         */
        public DateType getDateCreatedElement() { 
          if (this.dateCreated == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedComponent.dateCreated");
            else if (Configuration.doAutoCreate())
              this.dateCreated = new DateType(); // bb
          return this.dateCreated;
        }

        public boolean hasDateCreatedElement() { 
          return this.dateCreated != null && !this.dateCreated.isEmpty();
        }

        public boolean hasDateCreated() { 
          return this.dateCreated != null && !this.dateCreated.isEmpty();
        }

        /**
         * @param value {@link #dateCreated} (Creation date.). This is the underlying object with id, value and extensions. The accessor "getDateCreated" gives direct access to the value
         */
        public CitationMedlinePubMedComponent setDateCreatedElement(DateType value) { 
          this.dateCreated = value;
          return this;
        }

        /**
         * @return Creation date.
         */
        public Date getDateCreated() { 
          return this.dateCreated == null ? null : this.dateCreated.getValue();
        }

        /**
         * @param value Creation date.
         */
        public CitationMedlinePubMedComponent setDateCreated(Date value) { 
          if (value == null)
            this.dateCreated = null;
          else {
            if (this.dateCreated == null)
              this.dateCreated = new DateType();
            this.dateCreated.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #dateCompleted} (Completion date.). This is the underlying object with id, value and extensions. The accessor "getDateCompleted" gives direct access to the value
         */
        public DateType getDateCompletedElement() { 
          if (this.dateCompleted == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedComponent.dateCompleted");
            else if (Configuration.doAutoCreate())
              this.dateCompleted = new DateType(); // bb
          return this.dateCompleted;
        }

        public boolean hasDateCompletedElement() { 
          return this.dateCompleted != null && !this.dateCompleted.isEmpty();
        }

        public boolean hasDateCompleted() { 
          return this.dateCompleted != null && !this.dateCompleted.isEmpty();
        }

        /**
         * @param value {@link #dateCompleted} (Completion date.). This is the underlying object with id, value and extensions. The accessor "getDateCompleted" gives direct access to the value
         */
        public CitationMedlinePubMedComponent setDateCompletedElement(DateType value) { 
          this.dateCompleted = value;
          return this;
        }

        /**
         * @return Completion date.
         */
        public Date getDateCompleted() { 
          return this.dateCompleted == null ? null : this.dateCompleted.getValue();
        }

        /**
         * @param value Completion date.
         */
        public CitationMedlinePubMedComponent setDateCompleted(Date value) { 
          if (value == null)
            this.dateCompleted = null;
          else {
            if (this.dateCompleted == null)
              this.dateCompleted = new DateType();
            this.dateCompleted.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #dateRevised} (Revision date.). This is the underlying object with id, value and extensions. The accessor "getDateRevised" gives direct access to the value
         */
        public DateType getDateRevisedElement() { 
          if (this.dateRevised == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedComponent.dateRevised");
            else if (Configuration.doAutoCreate())
              this.dateRevised = new DateType(); // bb
          return this.dateRevised;
        }

        public boolean hasDateRevisedElement() { 
          return this.dateRevised != null && !this.dateRevised.isEmpty();
        }

        public boolean hasDateRevised() { 
          return this.dateRevised != null && !this.dateRevised.isEmpty();
        }

        /**
         * @param value {@link #dateRevised} (Revision date.). This is the underlying object with id, value and extensions. The accessor "getDateRevised" gives direct access to the value
         */
        public CitationMedlinePubMedComponent setDateRevisedElement(DateType value) { 
          this.dateRevised = value;
          return this;
        }

        /**
         * @return Revision date.
         */
        public Date getDateRevised() { 
          return this.dateRevised == null ? null : this.dateRevised.getValue();
        }

        /**
         * @param value Revision date.
         */
        public CitationMedlinePubMedComponent setDateRevised(Date value) { 
          if (value == null)
            this.dateRevised = null;
          else {
            if (this.dateRevised == null)
              this.dateRevised = new DateType();
            this.dateRevised.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #pubMedPubDate} (Subcomponent of certainty.)
         */
        public List<CitationMedlinePubMedPubMedPubDateComponent> getPubMedPubDate() { 
          if (this.pubMedPubDate == null)
            this.pubMedPubDate = new ArrayList<CitationMedlinePubMedPubMedPubDateComponent>();
          return this.pubMedPubDate;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationMedlinePubMedComponent setPubMedPubDate(List<CitationMedlinePubMedPubMedPubDateComponent> thePubMedPubDate) { 
          this.pubMedPubDate = thePubMedPubDate;
          return this;
        }

        public boolean hasPubMedPubDate() { 
          if (this.pubMedPubDate == null)
            return false;
          for (CitationMedlinePubMedPubMedPubDateComponent item : this.pubMedPubDate)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationMedlinePubMedPubMedPubDateComponent addPubMedPubDate() { //3
          CitationMedlinePubMedPubMedPubDateComponent t = new CitationMedlinePubMedPubMedPubDateComponent();
          if (this.pubMedPubDate == null)
            this.pubMedPubDate = new ArrayList<CitationMedlinePubMedPubMedPubDateComponent>();
          this.pubMedPubDate.add(t);
          return t;
        }

        public CitationMedlinePubMedComponent addPubMedPubDate(CitationMedlinePubMedPubMedPubDateComponent t) { //3
          if (t == null)
            return this;
          if (this.pubMedPubDate == null)
            this.pubMedPubDate = new ArrayList<CitationMedlinePubMedPubMedPubDateComponent>();
          this.pubMedPubDate.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #pubMedPubDate}, creating it if it does not already exist {3}
         */
        public CitationMedlinePubMedPubMedPubDateComponent getPubMedPubDateFirstRep() { 
          if (getPubMedPubDate().isEmpty()) {
            addPubMedPubDate();
          }
          return getPubMedPubDate().get(0);
        }

        /**
         * @return {@link #publicationState} (Publication Status.)
         */
        public CodeableConcept getPublicationState() { 
          if (this.publicationState == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedComponent.publicationState");
            else if (Configuration.doAutoCreate())
              this.publicationState = new CodeableConcept(); // cc
          return this.publicationState;
        }

        public boolean hasPublicationState() { 
          return this.publicationState != null && !this.publicationState.isEmpty();
        }

        /**
         * @param value {@link #publicationState} (Publication Status.)
         */
        public CitationMedlinePubMedComponent setPublicationState(CodeableConcept value) { 
          this.publicationState = value;
          return this;
        }

        /**
         * @return {@link #relatedArticle} (Related article.)
         */
        public List<CitationMedlinePubMedRelatedArticleComponent> getRelatedArticle() { 
          if (this.relatedArticle == null)
            this.relatedArticle = new ArrayList<CitationMedlinePubMedRelatedArticleComponent>();
          return this.relatedArticle;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationMedlinePubMedComponent setRelatedArticle(List<CitationMedlinePubMedRelatedArticleComponent> theRelatedArticle) { 
          this.relatedArticle = theRelatedArticle;
          return this;
        }

        public boolean hasRelatedArticle() { 
          if (this.relatedArticle == null)
            return false;
          for (CitationMedlinePubMedRelatedArticleComponent item : this.relatedArticle)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationMedlinePubMedRelatedArticleComponent addRelatedArticle() { //3
          CitationMedlinePubMedRelatedArticleComponent t = new CitationMedlinePubMedRelatedArticleComponent();
          if (this.relatedArticle == null)
            this.relatedArticle = new ArrayList<CitationMedlinePubMedRelatedArticleComponent>();
          this.relatedArticle.add(t);
          return t;
        }

        public CitationMedlinePubMedComponent addRelatedArticle(CitationMedlinePubMedRelatedArticleComponent t) { //3
          if (t == null)
            return this;
          if (this.relatedArticle == null)
            this.relatedArticle = new ArrayList<CitationMedlinePubMedRelatedArticleComponent>();
          this.relatedArticle.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #relatedArticle}, creating it if it does not already exist {3}
         */
        public CitationMedlinePubMedRelatedArticleComponent getRelatedArticleFirstRep() { 
          if (getRelatedArticle().isEmpty()) {
            addRelatedArticle();
          }
          return getRelatedArticle().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("medlineState", "CodeableConcept", "Used for status.", 0, 1, medlineState));
          children.add(new Property("owner", "CodeableConcept", "Used for owner.", 0, 1, owner));
          children.add(new Property("pmid", "positiveInt", "PubMed ID.", 0, 1, pmid));
          children.add(new Property("pmidVersion", "positiveInt", "PubMed ID Version.", 0, 1, pmidVersion));
          children.add(new Property("dateCreated", "date", "Creation date.", 0, 1, dateCreated));
          children.add(new Property("dateCompleted", "date", "Completion date.", 0, 1, dateCompleted));
          children.add(new Property("dateRevised", "date", "Revision date.", 0, 1, dateRevised));
          children.add(new Property("pubMedPubDate", "", "Subcomponent of certainty.", 0, java.lang.Integer.MAX_VALUE, pubMedPubDate));
          children.add(new Property("publicationState", "CodeableConcept", "Publication Status.", 0, 1, publicationState));
          children.add(new Property("relatedArticle", "", "Related article.", 0, java.lang.Integer.MAX_VALUE, relatedArticle));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 97983665: /*medlineState*/  return new Property("medlineState", "CodeableConcept", "Used for status.", 0, 1, medlineState);
          case 106164915: /*owner*/  return new Property("owner", "CodeableConcept", "Used for owner.", 0, 1, owner);
          case 3444696: /*pmid*/  return new Property("pmid", "positiveInt", "PubMed ID.", 0, 1, pmid);
          case 59253216: /*pmidVersion*/  return new Property("pmidVersion", "positiveInt", "PubMed ID Version.", 0, 1, pmidVersion);
          case -2071345318: /*dateCreated*/  return new Property("dateCreated", "date", "Creation date.", 0, 1, dateCreated);
          case 300673597: /*dateCompleted*/  return new Property("dateCompleted", "date", "Completion date.", 0, 1, dateCompleted);
          case -1999933730: /*dateRevised*/  return new Property("dateRevised", "date", "Revision date.", 0, 1, dateRevised);
          case -1086645316: /*pubMedPubDate*/  return new Property("pubMedPubDate", "", "Subcomponent of certainty.", 0, java.lang.Integer.MAX_VALUE, pubMedPubDate);
          case -1642680891: /*publicationState*/  return new Property("publicationState", "CodeableConcept", "Publication Status.", 0, 1, publicationState);
          case 1406980683: /*relatedArticle*/  return new Property("relatedArticle", "", "Related article.", 0, java.lang.Integer.MAX_VALUE, relatedArticle);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 97983665: /*medlineState*/ return this.medlineState == null ? new Base[0] : new Base[] {this.medlineState}; // CodeableConcept
        case 106164915: /*owner*/ return this.owner == null ? new Base[0] : new Base[] {this.owner}; // CodeableConcept
        case 3444696: /*pmid*/ return this.pmid == null ? new Base[0] : new Base[] {this.pmid}; // PositiveIntType
        case 59253216: /*pmidVersion*/ return this.pmidVersion == null ? new Base[0] : new Base[] {this.pmidVersion}; // PositiveIntType
        case -2071345318: /*dateCreated*/ return this.dateCreated == null ? new Base[0] : new Base[] {this.dateCreated}; // DateType
        case 300673597: /*dateCompleted*/ return this.dateCompleted == null ? new Base[0] : new Base[] {this.dateCompleted}; // DateType
        case -1999933730: /*dateRevised*/ return this.dateRevised == null ? new Base[0] : new Base[] {this.dateRevised}; // DateType
        case -1086645316: /*pubMedPubDate*/ return this.pubMedPubDate == null ? new Base[0] : this.pubMedPubDate.toArray(new Base[this.pubMedPubDate.size()]); // CitationMedlinePubMedPubMedPubDateComponent
        case -1642680891: /*publicationState*/ return this.publicationState == null ? new Base[0] : new Base[] {this.publicationState}; // CodeableConcept
        case 1406980683: /*relatedArticle*/ return this.relatedArticle == null ? new Base[0] : this.relatedArticle.toArray(new Base[this.relatedArticle.size()]); // CitationMedlinePubMedRelatedArticleComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 97983665: // medlineState
          this.medlineState = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 106164915: // owner
          this.owner = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3444696: // pmid
          this.pmid = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case 59253216: // pmidVersion
          this.pmidVersion = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case -2071345318: // dateCreated
          this.dateCreated = TypeConvertor.castToDate(value); // DateType
          return value;
        case 300673597: // dateCompleted
          this.dateCompleted = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1999933730: // dateRevised
          this.dateRevised = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1086645316: // pubMedPubDate
          this.getPubMedPubDate().add((CitationMedlinePubMedPubMedPubDateComponent) value); // CitationMedlinePubMedPubMedPubDateComponent
          return value;
        case -1642680891: // publicationState
          this.publicationState = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1406980683: // relatedArticle
          this.getRelatedArticle().add((CitationMedlinePubMedRelatedArticleComponent) value); // CitationMedlinePubMedRelatedArticleComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("medlineState")) {
          this.medlineState = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("owner")) {
          this.owner = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("pmid")) {
          this.pmid = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("pmidVersion")) {
          this.pmidVersion = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("dateCreated")) {
          this.dateCreated = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("dateCompleted")) {
          this.dateCompleted = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("dateRevised")) {
          this.dateRevised = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("pubMedPubDate")) {
          this.getPubMedPubDate().add((CitationMedlinePubMedPubMedPubDateComponent) value);
        } else if (name.equals("publicationState")) {
          this.publicationState = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("relatedArticle")) {
          this.getRelatedArticle().add((CitationMedlinePubMedRelatedArticleComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 97983665:  return getMedlineState();
        case 106164915:  return getOwner();
        case 3444696:  return getPmidElement();
        case 59253216:  return getPmidVersionElement();
        case -2071345318:  return getDateCreatedElement();
        case 300673597:  return getDateCompletedElement();
        case -1999933730:  return getDateRevisedElement();
        case -1086645316:  return addPubMedPubDate(); 
        case -1642680891:  return getPublicationState();
        case 1406980683:  return addRelatedArticle(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 97983665: /*medlineState*/ return new String[] {"CodeableConcept"};
        case 106164915: /*owner*/ return new String[] {"CodeableConcept"};
        case 3444696: /*pmid*/ return new String[] {"positiveInt"};
        case 59253216: /*pmidVersion*/ return new String[] {"positiveInt"};
        case -2071345318: /*dateCreated*/ return new String[] {"date"};
        case 300673597: /*dateCompleted*/ return new String[] {"date"};
        case -1999933730: /*dateRevised*/ return new String[] {"date"};
        case -1086645316: /*pubMedPubDate*/ return new String[] {};
        case -1642680891: /*publicationState*/ return new String[] {"CodeableConcept"};
        case 1406980683: /*relatedArticle*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("medlineState")) {
          this.medlineState = new CodeableConcept();
          return this.medlineState;
        }
        else if (name.equals("owner")) {
          this.owner = new CodeableConcept();
          return this.owner;
        }
        else if (name.equals("pmid")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.medlinePubMed.pmid");
        }
        else if (name.equals("pmidVersion")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.medlinePubMed.pmidVersion");
        }
        else if (name.equals("dateCreated")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.medlinePubMed.dateCreated");
        }
        else if (name.equals("dateCompleted")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.medlinePubMed.dateCompleted");
        }
        else if (name.equals("dateRevised")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.medlinePubMed.dateRevised");
        }
        else if (name.equals("pubMedPubDate")) {
          return addPubMedPubDate();
        }
        else if (name.equals("publicationState")) {
          this.publicationState = new CodeableConcept();
          return this.publicationState;
        }
        else if (name.equals("relatedArticle")) {
          return addRelatedArticle();
        }
        else
          return super.addChild(name);
      }

      public CitationMedlinePubMedComponent copy() {
        CitationMedlinePubMedComponent dst = new CitationMedlinePubMedComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationMedlinePubMedComponent dst) {
        super.copyValues(dst);
        dst.medlineState = medlineState == null ? null : medlineState.copy();
        dst.owner = owner == null ? null : owner.copy();
        dst.pmid = pmid == null ? null : pmid.copy();
        dst.pmidVersion = pmidVersion == null ? null : pmidVersion.copy();
        dst.dateCreated = dateCreated == null ? null : dateCreated.copy();
        dst.dateCompleted = dateCompleted == null ? null : dateCompleted.copy();
        dst.dateRevised = dateRevised == null ? null : dateRevised.copy();
        if (pubMedPubDate != null) {
          dst.pubMedPubDate = new ArrayList<CitationMedlinePubMedPubMedPubDateComponent>();
          for (CitationMedlinePubMedPubMedPubDateComponent i : pubMedPubDate)
            dst.pubMedPubDate.add(i.copy());
        };
        dst.publicationState = publicationState == null ? null : publicationState.copy();
        if (relatedArticle != null) {
          dst.relatedArticle = new ArrayList<CitationMedlinePubMedRelatedArticleComponent>();
          for (CitationMedlinePubMedRelatedArticleComponent i : relatedArticle)
            dst.relatedArticle.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationMedlinePubMedComponent))
          return false;
        CitationMedlinePubMedComponent o = (CitationMedlinePubMedComponent) other_;
        return compareDeep(medlineState, o.medlineState, true) && compareDeep(owner, o.owner, true) && compareDeep(pmid, o.pmid, true)
           && compareDeep(pmidVersion, o.pmidVersion, true) && compareDeep(dateCreated, o.dateCreated, true)
           && compareDeep(dateCompleted, o.dateCompleted, true) && compareDeep(dateRevised, o.dateRevised, true)
           && compareDeep(pubMedPubDate, o.pubMedPubDate, true) && compareDeep(publicationState, o.publicationState, true)
           && compareDeep(relatedArticle, o.relatedArticle, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationMedlinePubMedComponent))
          return false;
        CitationMedlinePubMedComponent o = (CitationMedlinePubMedComponent) other_;
        return compareValues(pmid, o.pmid, true) && compareValues(pmidVersion, o.pmidVersion, true) && compareValues(dateCreated, o.dateCreated, true)
           && compareValues(dateCompleted, o.dateCompleted, true) && compareValues(dateRevised, o.dateRevised, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(medlineState, owner, pmid
          , pmidVersion, dateCreated, dateCompleted, dateRevised, pubMedPubDate, publicationState
          , relatedArticle);
      }

  public String fhirType() {
    return "Citation.medlinePubMed";

  }

  }

    @Block()
    public static class CitationMedlinePubMedPubMedPubDateComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * PubMed Publication Status.
         */
        @Child(name = "publicationState", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="PubMed Publication Status", formalDefinition="PubMed Publication Status." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/pubmed-pubstatus")
        protected CodeableConcept publicationState;

        /**
         * PubMed Publication Date.
         */
        @Child(name = "date", type = {DateTimeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="PubMed Publication Date", formalDefinition="PubMed Publication Date." )
        protected DateTimeType date;

        private static final long serialVersionUID = 1620940147L;

    /**
     * Constructor
     */
      public CitationMedlinePubMedPubMedPubDateComponent() {
        super();
      }

        /**
         * @return {@link #publicationState} (PubMed Publication Status.)
         */
        public CodeableConcept getPublicationState() { 
          if (this.publicationState == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedPubMedPubDateComponent.publicationState");
            else if (Configuration.doAutoCreate())
              this.publicationState = new CodeableConcept(); // cc
          return this.publicationState;
        }

        public boolean hasPublicationState() { 
          return this.publicationState != null && !this.publicationState.isEmpty();
        }

        /**
         * @param value {@link #publicationState} (PubMed Publication Status.)
         */
        public CitationMedlinePubMedPubMedPubDateComponent setPublicationState(CodeableConcept value) { 
          this.publicationState = value;
          return this;
        }

        /**
         * @return {@link #date} (PubMed Publication Date.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public DateTimeType getDateElement() { 
          if (this.date == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedPubMedPubDateComponent.date");
            else if (Configuration.doAutoCreate())
              this.date = new DateTimeType(); // bb
          return this.date;
        }

        public boolean hasDateElement() { 
          return this.date != null && !this.date.isEmpty();
        }

        public boolean hasDate() { 
          return this.date != null && !this.date.isEmpty();
        }

        /**
         * @param value {@link #date} (PubMed Publication Date.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public CitationMedlinePubMedPubMedPubDateComponent setDateElement(DateTimeType value) { 
          this.date = value;
          return this;
        }

        /**
         * @return PubMed Publication Date.
         */
        public Date getDate() { 
          return this.date == null ? null : this.date.getValue();
        }

        /**
         * @param value PubMed Publication Date.
         */
        public CitationMedlinePubMedPubMedPubDateComponent setDate(Date value) { 
          if (value == null)
            this.date = null;
          else {
            if (this.date == null)
              this.date = new DateTimeType();
            this.date.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("publicationState", "CodeableConcept", "PubMed Publication Status.", 0, 1, publicationState));
          children.add(new Property("date", "dateTime", "PubMed Publication Date.", 0, 1, date));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1642680891: /*publicationState*/  return new Property("publicationState", "CodeableConcept", "PubMed Publication Status.", 0, 1, publicationState);
          case 3076014: /*date*/  return new Property("date", "dateTime", "PubMed Publication Date.", 0, 1, date);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1642680891: /*publicationState*/ return this.publicationState == null ? new Base[0] : new Base[] {this.publicationState}; // CodeableConcept
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1642680891: // publicationState
          this.publicationState = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("publicationState")) {
          this.publicationState = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1642680891:  return getPublicationState();
        case 3076014:  return getDateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1642680891: /*publicationState*/ return new String[] {"CodeableConcept"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("publicationState")) {
          this.publicationState = new CodeableConcept();
          return this.publicationState;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.medlinePubMed.pubMedPubDate.date");
        }
        else
          return super.addChild(name);
      }

      public CitationMedlinePubMedPubMedPubDateComponent copy() {
        CitationMedlinePubMedPubMedPubDateComponent dst = new CitationMedlinePubMedPubMedPubDateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationMedlinePubMedPubMedPubDateComponent dst) {
        super.copyValues(dst);
        dst.publicationState = publicationState == null ? null : publicationState.copy();
        dst.date = date == null ? null : date.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationMedlinePubMedPubMedPubDateComponent))
          return false;
        CitationMedlinePubMedPubMedPubDateComponent o = (CitationMedlinePubMedPubMedPubDateComponent) other_;
        return compareDeep(publicationState, o.publicationState, true) && compareDeep(date, o.date, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationMedlinePubMedPubMedPubDateComponent))
          return false;
        CitationMedlinePubMedPubMedPubDateComponent o = (CitationMedlinePubMedPubMedPubDateComponent) other_;
        return compareValues(date, o.date, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(publicationState, date);
      }

  public String fhirType() {
    return "Citation.medlinePubMed.pubMedPubDate";

  }

  }

    @Block()
    public static class CitationMedlinePubMedRelatedArticleComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Citation Resource for related article.
         */
        @Child(name = "citationReference", type = {Citation.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Citation Resource for related article", formalDefinition="Citation Resource for related article." )
        protected Reference citationReference;

        /**
         * Citation string for related article.
         */
        @Child(name = "citationMarkdown", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Citation string for related article", formalDefinition="Citation string for related article." )
        protected MarkdownType citationMarkdown;

        /**
         * Identifier for related article.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Identifier for related article", formalDefinition="Identifier for related article." )
        protected List<Identifier> identifier;

        private static final long serialVersionUID = -704722480L;

    /**
     * Constructor
     */
      public CitationMedlinePubMedRelatedArticleComponent() {
        super();
      }

        /**
         * @return {@link #citationReference} (Citation Resource for related article.)
         */
        public Reference getCitationReference() { 
          if (this.citationReference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedRelatedArticleComponent.citationReference");
            else if (Configuration.doAutoCreate())
              this.citationReference = new Reference(); // cc
          return this.citationReference;
        }

        public boolean hasCitationReference() { 
          return this.citationReference != null && !this.citationReference.isEmpty();
        }

        /**
         * @param value {@link #citationReference} (Citation Resource for related article.)
         */
        public CitationMedlinePubMedRelatedArticleComponent setCitationReference(Reference value) { 
          this.citationReference = value;
          return this;
        }

        /**
         * @return {@link #citationMarkdown} (Citation string for related article.). This is the underlying object with id, value and extensions. The accessor "getCitationMarkdown" gives direct access to the value
         */
        public MarkdownType getCitationMarkdownElement() { 
          if (this.citationMarkdown == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationMedlinePubMedRelatedArticleComponent.citationMarkdown");
            else if (Configuration.doAutoCreate())
              this.citationMarkdown = new MarkdownType(); // bb
          return this.citationMarkdown;
        }

        public boolean hasCitationMarkdownElement() { 
          return this.citationMarkdown != null && !this.citationMarkdown.isEmpty();
        }

        public boolean hasCitationMarkdown() { 
          return this.citationMarkdown != null && !this.citationMarkdown.isEmpty();
        }

        /**
         * @param value {@link #citationMarkdown} (Citation string for related article.). This is the underlying object with id, value and extensions. The accessor "getCitationMarkdown" gives direct access to the value
         */
        public CitationMedlinePubMedRelatedArticleComponent setCitationMarkdownElement(MarkdownType value) { 
          this.citationMarkdown = value;
          return this;
        }

        /**
         * @return Citation string for related article.
         */
        public String getCitationMarkdown() { 
          return this.citationMarkdown == null ? null : this.citationMarkdown.getValue();
        }

        /**
         * @param value Citation string for related article.
         */
        public CitationMedlinePubMedRelatedArticleComponent setCitationMarkdown(String value) { 
          if (value == null)
            this.citationMarkdown = null;
          else {
            if (this.citationMarkdown == null)
              this.citationMarkdown = new MarkdownType();
            this.citationMarkdown.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #identifier} (Identifier for related article.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationMedlinePubMedRelatedArticleComponent setIdentifier(List<Identifier> theIdentifier) { 
          this.identifier = theIdentifier;
          return this;
        }

        public boolean hasIdentifier() { 
          if (this.identifier == null)
            return false;
          for (Identifier item : this.identifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Identifier addIdentifier() { //3
          Identifier t = new Identifier();
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return t;
        }

        public CitationMedlinePubMedRelatedArticleComponent addIdentifier(Identifier t) { //3
          if (t == null)
            return this;
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          this.identifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
         */
        public Identifier getIdentifierFirstRep() { 
          if (getIdentifier().isEmpty()) {
            addIdentifier();
          }
          return getIdentifier().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("citationReference", "Reference(Citation)", "Citation Resource for related article.", 0, 1, citationReference));
          children.add(new Property("citationMarkdown", "markdown", "Citation string for related article.", 0, 1, citationMarkdown));
          children.add(new Property("identifier", "Identifier", "Identifier for related article.", 0, java.lang.Integer.MAX_VALUE, identifier));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 87795748: /*citationReference*/  return new Property("citationReference", "Reference(Citation)", "Citation Resource for related article.", 0, 1, citationReference);
          case 279614710: /*citationMarkdown*/  return new Property("citationMarkdown", "markdown", "Citation string for related article.", 0, 1, citationMarkdown);
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier for related article.", 0, java.lang.Integer.MAX_VALUE, identifier);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 87795748: /*citationReference*/ return this.citationReference == null ? new Base[0] : new Base[] {this.citationReference}; // Reference
        case 279614710: /*citationMarkdown*/ return this.citationMarkdown == null ? new Base[0] : new Base[] {this.citationMarkdown}; // MarkdownType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 87795748: // citationReference
          this.citationReference = TypeConvertor.castToReference(value); // Reference
          return value;
        case 279614710: // citationMarkdown
          this.citationMarkdown = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("citationReference")) {
          this.citationReference = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("citationMarkdown")) {
          this.citationMarkdown = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 87795748:  return getCitationReference();
        case 279614710:  return getCitationMarkdownElement();
        case -1618432855:  return addIdentifier(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 87795748: /*citationReference*/ return new String[] {"Reference"};
        case 279614710: /*citationMarkdown*/ return new String[] {"markdown"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("citationReference")) {
          this.citationReference = new Reference();
          return this.citationReference;
        }
        else if (name.equals("citationMarkdown")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.medlinePubMed.relatedArticle.citationMarkdown");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else
          return super.addChild(name);
      }

      public CitationMedlinePubMedRelatedArticleComponent copy() {
        CitationMedlinePubMedRelatedArticleComponent dst = new CitationMedlinePubMedRelatedArticleComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationMedlinePubMedRelatedArticleComponent dst) {
        super.copyValues(dst);
        dst.citationReference = citationReference == null ? null : citationReference.copy();
        dst.citationMarkdown = citationMarkdown == null ? null : citationMarkdown.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationMedlinePubMedRelatedArticleComponent))
          return false;
        CitationMedlinePubMedRelatedArticleComponent o = (CitationMedlinePubMedRelatedArticleComponent) other_;
        return compareDeep(citationReference, o.citationReference, true) && compareDeep(citationMarkdown, o.citationMarkdown, true)
           && compareDeep(identifier, o.identifier, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationMedlinePubMedRelatedArticleComponent))
          return false;
        CitationMedlinePubMedRelatedArticleComponent o = (CitationMedlinePubMedRelatedArticleComponent) other_;
        return compareValues(citationMarkdown, o.citationMarkdown, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(citationReference, citationMarkdown
          , identifier);
      }

  public String fhirType() {
    return "Citation.medlinePubMed.relatedArticle";

  }

  }

    /**
     * An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this citation, represented as a globally unique URI", formalDefinition="An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers." )
    protected UriType url;

    /**
     * The status of this summary. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this summary. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Use context", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances." )
    protected List<UsageContext> useContext;

    /**
     * A formal identifier that is used to identify this citation when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="May include DOI, PMID, PMCID, etc.", formalDefinition="A formal identifier that is used to identify this citation when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * A formal identifier that is used to identify things closely related to this citation.
     */
    @Child(name = "relatedIdentifier", type = {Identifier.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="May include trial registry identifiers", formalDefinition="A formal identifier that is used to identify things closely related to this citation." )
    protected List<Identifier> relatedIdentifier;

    /**
     * A human-readable display of the citation.
     */
    @Child(name = "summary", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A human-readable display of the citation", formalDefinition="A human-readable display of the citation." )
    protected List<CitationSummaryComponent> summary;

    /**
     * Date Cited.
     */
    @Child(name = "dateCited", type = {DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date Cited", formalDefinition="Date Cited." )
    protected DateTimeType dateCited;

    /**
     * Variant citation.
     */
    @Child(name = "variantCitation", type = {}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Variant citation", formalDefinition="Variant citation." )
    protected CitationVariantCitationComponent variantCitation;

    /**
     * Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.
     */
    @Child(name = "publishingModel", type = {CodeableConcept.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic", formalDefinition="Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publishing-model-type")
    protected CodeableConcept publishingModel;

    /**
     * Contains identifiers and classifiers for the journal cited.
     */
    @Child(name = "journal", type = {}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Contains identifiers and classifiers for the journal cited", formalDefinition="Contains identifiers and classifiers for the journal cited." )
    protected CitationJournalComponent journal;

    /**
     * Citation detail for sources other than journals such as books and databases.
     */
    @Child(name = "publicationInfo", type = {}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Citation detail for sources other than journals", formalDefinition="Citation detail for sources other than journals such as books and databases." )
    protected CitationPublicationInfoComponent publicationInfo;

    /**
     * Full title of the article.
     */
    @Child(name = "articleTitle", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Full title of the article", formalDefinition="Full title of the article." )
    protected MarkdownType articleTitle;

    /**
     * Used for variant titles, such as translations.
     */
    @Child(name = "alternativeTitle", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for variant titles, such as translations", formalDefinition="Used for variant titles, such as translations." )
    protected List<CitationAlternativeTitleComponent> alternativeTitle;

    /**
     * Indicates the inclusive pages for the article cited.
     */
    @Child(name = "pagination", type = {}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Indicates the inclusive pages for the article cited", formalDefinition="Indicates the inclusive pages for the article cited." )
    protected CitationPaginationComponent pagination;

    /**
     * Used for any URL for the article cited.
     */
    @Child(name = "articleUrl", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for any URL for the article cited", formalDefinition="Used for any URL for the article cited." )
    protected List<CitationArticleUrlComponent> articleUrl;

    /**
     * Abstract text, as published; may include structured labels.
     */
    @Child(name = "abstract", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Abstract text", formalDefinition="Abstract text, as published; may include structured labels." )
    protected MarkdownType abstract_;

    /**
     * Copyright information for the abstract text.
     */
    @Child(name = "abstractCopyright", type = {MarkdownType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Abstract copyright", formalDefinition="Copyright information for the abstract text." )
    protected MarkdownType abstractCopyright;

    /**
     * Used for variant abstracts, such as translations.
     */
    @Child(name = "alternativeAbstract", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for variant abstracts, such as translations", formalDefinition="Used for variant abstracts, such as translations." )
    protected List<CitationAlternativeAbstractComponent> alternativeAbstract;

    /**
     * This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.
     */
    @Child(name = "contributorship", type = {}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Attribution of authors and other contributors", formalDefinition="This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements." )
    protected CitationContributorshipComponent contributorship;

    /**
     * The language in which the article is published.
     */
    @Child(name = "articleLanguage", type = {CodeableConcept.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The language in which the article is published", formalDefinition="The language in which the article is published." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
    protected CodeableConcept articleLanguage;

    /**
     * Used to represent alternative forms of the article that are not separate citations.
     */
    @Child(name = "alternativeForm", type = {}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used to represent alternative forms of the article that are not separate citations", formalDefinition="Used to represent alternative forms of the article that are not separate citations." )
    protected List<CitationAlternativeFormComponent> alternativeForm;

    /**
     * Used for many classifiers including PublicationType, CitationSubset, MeshHeading, Chemical.
     */
    @Child(name = "classifier", type = {CodeableConcept.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for many classifiers including PublicationType, CitationSubset, MeshHeading, Chemical", formalDefinition="Used for many classifiers including PublicationType, CitationSubset, MeshHeading, Chemical." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-classifier")
    protected List<CodeableConcept> classifier;

    /**
     * A list of words classified as keywords for specific use in search functions.
     */
    @Child(name = "keywordList", type = {}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used to support keyword searches", formalDefinition="A list of words classified as keywords for specific use in search functions." )
    protected List<CitationKeywordListComponent> keywordList;

    /**
     * Link or citation to artifact associated with the referenced material.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Link or citation to artifact associated with the referenced material", formalDefinition="Link or citation to artifact associated with the referenced material." )
    protected List<RelatedArtifact> relatedArtifact;

    /**
     * Used for general notes and annotations not coded elsewhere.
     */
    @Child(name = "note", type = {Annotation.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for general notes and annotations not coded elsewhere", formalDefinition="Used for general notes and annotations not coded elsewhere." )
    protected List<Annotation> note;

    /**
     * These elements are items with values assigned by MEDLINE or PubMed management.
     */
    @Child(name = "medlinePubMed", type = {}, order=25, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="These elements are items with values assigned by MEDLINE or PubMed management", formalDefinition="These elements are items with values assigned by MEDLINE or PubMed management." )
    protected CitationMedlinePubMedComponent medlinePubMed;

    private static final long serialVersionUID = -3279077L;

  /**
   * Constructor
   */
    public Citation() {
      super();
    }

  /**
   * Constructor
   */
    public Citation(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.url");
        else if (Configuration.doAutoCreate())
          this.url = new UriType(); // bb
      return this.url;
    }

    public boolean hasUrlElement() { 
      return this.url != null && !this.url.isEmpty();
    }

    public boolean hasUrl() { 
      return this.url != null && !this.url.isEmpty();
    }

    /**
     * @param value {@link #url} (An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Citation setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    public Citation setUrl(String value) { 
      if (Utilities.noString(value))
        this.url = null;
      else {
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #status} (The status of this summary. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of this summary. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Citation setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this summary. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this summary. Enables tracking the life-cycle of the content.
     */
    public Citation setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setUseContext(List<UsageContext> theUseContext) { 
      this.useContext = theUseContext;
      return this;
    }

    public boolean hasUseContext() { 
      if (this.useContext == null)
        return false;
      for (UsageContext item : this.useContext)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public UsageContext addUseContext() { //3
      UsageContext t = new UsageContext();
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return t;
    }

    public Citation addUseContext(UsageContext t) { //3
      if (t == null)
        return this;
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist {3}
     */
    public UsageContext getUseContextFirstRep() { 
      if (getUseContext().isEmpty()) {
        addUseContext();
      }
      return getUseContext().get(0);
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this citation when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public Citation addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #relatedIdentifier} (A formal identifier that is used to identify things closely related to this citation.)
     */
    public List<Identifier> getRelatedIdentifier() { 
      if (this.relatedIdentifier == null)
        this.relatedIdentifier = new ArrayList<Identifier>();
      return this.relatedIdentifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setRelatedIdentifier(List<Identifier> theRelatedIdentifier) { 
      this.relatedIdentifier = theRelatedIdentifier;
      return this;
    }

    public boolean hasRelatedIdentifier() { 
      if (this.relatedIdentifier == null)
        return false;
      for (Identifier item : this.relatedIdentifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addRelatedIdentifier() { //3
      Identifier t = new Identifier();
      if (this.relatedIdentifier == null)
        this.relatedIdentifier = new ArrayList<Identifier>();
      this.relatedIdentifier.add(t);
      return t;
    }

    public Citation addRelatedIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.relatedIdentifier == null)
        this.relatedIdentifier = new ArrayList<Identifier>();
      this.relatedIdentifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedIdentifier}, creating it if it does not already exist {3}
     */
    public Identifier getRelatedIdentifierFirstRep() { 
      if (getRelatedIdentifier().isEmpty()) {
        addRelatedIdentifier();
      }
      return getRelatedIdentifier().get(0);
    }

    /**
     * @return {@link #summary} (A human-readable display of the citation.)
     */
    public List<CitationSummaryComponent> getSummary() { 
      if (this.summary == null)
        this.summary = new ArrayList<CitationSummaryComponent>();
      return this.summary;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setSummary(List<CitationSummaryComponent> theSummary) { 
      this.summary = theSummary;
      return this;
    }

    public boolean hasSummary() { 
      if (this.summary == null)
        return false;
      for (CitationSummaryComponent item : this.summary)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationSummaryComponent addSummary() { //3
      CitationSummaryComponent t = new CitationSummaryComponent();
      if (this.summary == null)
        this.summary = new ArrayList<CitationSummaryComponent>();
      this.summary.add(t);
      return t;
    }

    public Citation addSummary(CitationSummaryComponent t) { //3
      if (t == null)
        return this;
      if (this.summary == null)
        this.summary = new ArrayList<CitationSummaryComponent>();
      this.summary.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #summary}, creating it if it does not already exist {3}
     */
    public CitationSummaryComponent getSummaryFirstRep() { 
      if (getSummary().isEmpty()) {
        addSummary();
      }
      return getSummary().get(0);
    }

    /**
     * @return {@link #dateCited} (Date Cited.). This is the underlying object with id, value and extensions. The accessor "getDateCited" gives direct access to the value
     */
    public DateTimeType getDateCitedElement() { 
      if (this.dateCited == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.dateCited");
        else if (Configuration.doAutoCreate())
          this.dateCited = new DateTimeType(); // bb
      return this.dateCited;
    }

    public boolean hasDateCitedElement() { 
      return this.dateCited != null && !this.dateCited.isEmpty();
    }

    public boolean hasDateCited() { 
      return this.dateCited != null && !this.dateCited.isEmpty();
    }

    /**
     * @param value {@link #dateCited} (Date Cited.). This is the underlying object with id, value and extensions. The accessor "getDateCited" gives direct access to the value
     */
    public Citation setDateCitedElement(DateTimeType value) { 
      this.dateCited = value;
      return this;
    }

    /**
     * @return Date Cited.
     */
    public Date getDateCited() { 
      return this.dateCited == null ? null : this.dateCited.getValue();
    }

    /**
     * @param value Date Cited.
     */
    public Citation setDateCited(Date value) { 
      if (value == null)
        this.dateCited = null;
      else {
        if (this.dateCited == null)
          this.dateCited = new DateTimeType();
        this.dateCited.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #variantCitation} (Variant citation.)
     */
    public CitationVariantCitationComponent getVariantCitation() { 
      if (this.variantCitation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.variantCitation");
        else if (Configuration.doAutoCreate())
          this.variantCitation = new CitationVariantCitationComponent(); // cc
      return this.variantCitation;
    }

    public boolean hasVariantCitation() { 
      return this.variantCitation != null && !this.variantCitation.isEmpty();
    }

    /**
     * @param value {@link #variantCitation} (Variant citation.)
     */
    public Citation setVariantCitation(CitationVariantCitationComponent value) { 
      this.variantCitation = value;
      return this;
    }

    /**
     * @return {@link #publishingModel} (Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.)
     */
    public CodeableConcept getPublishingModel() { 
      if (this.publishingModel == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.publishingModel");
        else if (Configuration.doAutoCreate())
          this.publishingModel = new CodeableConcept(); // cc
      return this.publishingModel;
    }

    public boolean hasPublishingModel() { 
      return this.publishingModel != null && !this.publishingModel.isEmpty();
    }

    /**
     * @param value {@link #publishingModel} (Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.)
     */
    public Citation setPublishingModel(CodeableConcept value) { 
      this.publishingModel = value;
      return this;
    }

    /**
     * @return {@link #journal} (Contains identifiers and classifiers for the journal cited.)
     */
    public CitationJournalComponent getJournal() { 
      if (this.journal == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.journal");
        else if (Configuration.doAutoCreate())
          this.journal = new CitationJournalComponent(); // cc
      return this.journal;
    }

    public boolean hasJournal() { 
      return this.journal != null && !this.journal.isEmpty();
    }

    /**
     * @param value {@link #journal} (Contains identifiers and classifiers for the journal cited.)
     */
    public Citation setJournal(CitationJournalComponent value) { 
      this.journal = value;
      return this;
    }

    /**
     * @return {@link #publicationInfo} (Citation detail for sources other than journals such as books and databases.)
     */
    public CitationPublicationInfoComponent getPublicationInfo() { 
      if (this.publicationInfo == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.publicationInfo");
        else if (Configuration.doAutoCreate())
          this.publicationInfo = new CitationPublicationInfoComponent(); // cc
      return this.publicationInfo;
    }

    public boolean hasPublicationInfo() { 
      return this.publicationInfo != null && !this.publicationInfo.isEmpty();
    }

    /**
     * @param value {@link #publicationInfo} (Citation detail for sources other than journals such as books and databases.)
     */
    public Citation setPublicationInfo(CitationPublicationInfoComponent value) { 
      this.publicationInfo = value;
      return this;
    }

    /**
     * @return {@link #articleTitle} (Full title of the article.). This is the underlying object with id, value and extensions. The accessor "getArticleTitle" gives direct access to the value
     */
    public MarkdownType getArticleTitleElement() { 
      if (this.articleTitle == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.articleTitle");
        else if (Configuration.doAutoCreate())
          this.articleTitle = new MarkdownType(); // bb
      return this.articleTitle;
    }

    public boolean hasArticleTitleElement() { 
      return this.articleTitle != null && !this.articleTitle.isEmpty();
    }

    public boolean hasArticleTitle() { 
      return this.articleTitle != null && !this.articleTitle.isEmpty();
    }

    /**
     * @param value {@link #articleTitle} (Full title of the article.). This is the underlying object with id, value and extensions. The accessor "getArticleTitle" gives direct access to the value
     */
    public Citation setArticleTitleElement(MarkdownType value) { 
      this.articleTitle = value;
      return this;
    }

    /**
     * @return Full title of the article.
     */
    public String getArticleTitle() { 
      return this.articleTitle == null ? null : this.articleTitle.getValue();
    }

    /**
     * @param value Full title of the article.
     */
    public Citation setArticleTitle(String value) { 
      if (value == null)
        this.articleTitle = null;
      else {
        if (this.articleTitle == null)
          this.articleTitle = new MarkdownType();
        this.articleTitle.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #alternativeTitle} (Used for variant titles, such as translations.)
     */
    public List<CitationAlternativeTitleComponent> getAlternativeTitle() { 
      if (this.alternativeTitle == null)
        this.alternativeTitle = new ArrayList<CitationAlternativeTitleComponent>();
      return this.alternativeTitle;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setAlternativeTitle(List<CitationAlternativeTitleComponent> theAlternativeTitle) { 
      this.alternativeTitle = theAlternativeTitle;
      return this;
    }

    public boolean hasAlternativeTitle() { 
      if (this.alternativeTitle == null)
        return false;
      for (CitationAlternativeTitleComponent item : this.alternativeTitle)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationAlternativeTitleComponent addAlternativeTitle() { //3
      CitationAlternativeTitleComponent t = new CitationAlternativeTitleComponent();
      if (this.alternativeTitle == null)
        this.alternativeTitle = new ArrayList<CitationAlternativeTitleComponent>();
      this.alternativeTitle.add(t);
      return t;
    }

    public Citation addAlternativeTitle(CitationAlternativeTitleComponent t) { //3
      if (t == null)
        return this;
      if (this.alternativeTitle == null)
        this.alternativeTitle = new ArrayList<CitationAlternativeTitleComponent>();
      this.alternativeTitle.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #alternativeTitle}, creating it if it does not already exist {3}
     */
    public CitationAlternativeTitleComponent getAlternativeTitleFirstRep() { 
      if (getAlternativeTitle().isEmpty()) {
        addAlternativeTitle();
      }
      return getAlternativeTitle().get(0);
    }

    /**
     * @return {@link #pagination} (Indicates the inclusive pages for the article cited.)
     */
    public CitationPaginationComponent getPagination() { 
      if (this.pagination == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.pagination");
        else if (Configuration.doAutoCreate())
          this.pagination = new CitationPaginationComponent(); // cc
      return this.pagination;
    }

    public boolean hasPagination() { 
      return this.pagination != null && !this.pagination.isEmpty();
    }

    /**
     * @param value {@link #pagination} (Indicates the inclusive pages for the article cited.)
     */
    public Citation setPagination(CitationPaginationComponent value) { 
      this.pagination = value;
      return this;
    }

    /**
     * @return {@link #articleUrl} (Used for any URL for the article cited.)
     */
    public List<CitationArticleUrlComponent> getArticleUrl() { 
      if (this.articleUrl == null)
        this.articleUrl = new ArrayList<CitationArticleUrlComponent>();
      return this.articleUrl;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setArticleUrl(List<CitationArticleUrlComponent> theArticleUrl) { 
      this.articleUrl = theArticleUrl;
      return this;
    }

    public boolean hasArticleUrl() { 
      if (this.articleUrl == null)
        return false;
      for (CitationArticleUrlComponent item : this.articleUrl)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationArticleUrlComponent addArticleUrl() { //3
      CitationArticleUrlComponent t = new CitationArticleUrlComponent();
      if (this.articleUrl == null)
        this.articleUrl = new ArrayList<CitationArticleUrlComponent>();
      this.articleUrl.add(t);
      return t;
    }

    public Citation addArticleUrl(CitationArticleUrlComponent t) { //3
      if (t == null)
        return this;
      if (this.articleUrl == null)
        this.articleUrl = new ArrayList<CitationArticleUrlComponent>();
      this.articleUrl.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #articleUrl}, creating it if it does not already exist {3}
     */
    public CitationArticleUrlComponent getArticleUrlFirstRep() { 
      if (getArticleUrl().isEmpty()) {
        addArticleUrl();
      }
      return getArticleUrl().get(0);
    }

    /**
     * @return {@link #abstract_} (Abstract text, as published; may include structured labels.). This is the underlying object with id, value and extensions. The accessor "getAbstract" gives direct access to the value
     */
    public MarkdownType getAbstractElement() { 
      if (this.abstract_ == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.abstract_");
        else if (Configuration.doAutoCreate())
          this.abstract_ = new MarkdownType(); // bb
      return this.abstract_;
    }

    public boolean hasAbstractElement() { 
      return this.abstract_ != null && !this.abstract_.isEmpty();
    }

    public boolean hasAbstract() { 
      return this.abstract_ != null && !this.abstract_.isEmpty();
    }

    /**
     * @param value {@link #abstract_} (Abstract text, as published; may include structured labels.). This is the underlying object with id, value and extensions. The accessor "getAbstract" gives direct access to the value
     */
    public Citation setAbstractElement(MarkdownType value) { 
      this.abstract_ = value;
      return this;
    }

    /**
     * @return Abstract text, as published; may include structured labels.
     */
    public String getAbstract() { 
      return this.abstract_ == null ? null : this.abstract_.getValue();
    }

    /**
     * @param value Abstract text, as published; may include structured labels.
     */
    public Citation setAbstract(String value) { 
      if (value == null)
        this.abstract_ = null;
      else {
        if (this.abstract_ == null)
          this.abstract_ = new MarkdownType();
        this.abstract_.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #abstractCopyright} (Copyright information for the abstract text.). This is the underlying object with id, value and extensions. The accessor "getAbstractCopyright" gives direct access to the value
     */
    public MarkdownType getAbstractCopyrightElement() { 
      if (this.abstractCopyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.abstractCopyright");
        else if (Configuration.doAutoCreate())
          this.abstractCopyright = new MarkdownType(); // bb
      return this.abstractCopyright;
    }

    public boolean hasAbstractCopyrightElement() { 
      return this.abstractCopyright != null && !this.abstractCopyright.isEmpty();
    }

    public boolean hasAbstractCopyright() { 
      return this.abstractCopyright != null && !this.abstractCopyright.isEmpty();
    }

    /**
     * @param value {@link #abstractCopyright} (Copyright information for the abstract text.). This is the underlying object with id, value and extensions. The accessor "getAbstractCopyright" gives direct access to the value
     */
    public Citation setAbstractCopyrightElement(MarkdownType value) { 
      this.abstractCopyright = value;
      return this;
    }

    /**
     * @return Copyright information for the abstract text.
     */
    public String getAbstractCopyright() { 
      return this.abstractCopyright == null ? null : this.abstractCopyright.getValue();
    }

    /**
     * @param value Copyright information for the abstract text.
     */
    public Citation setAbstractCopyright(String value) { 
      if (value == null)
        this.abstractCopyright = null;
      else {
        if (this.abstractCopyright == null)
          this.abstractCopyright = new MarkdownType();
        this.abstractCopyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #alternativeAbstract} (Used for variant abstracts, such as translations.)
     */
    public List<CitationAlternativeAbstractComponent> getAlternativeAbstract() { 
      if (this.alternativeAbstract == null)
        this.alternativeAbstract = new ArrayList<CitationAlternativeAbstractComponent>();
      return this.alternativeAbstract;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setAlternativeAbstract(List<CitationAlternativeAbstractComponent> theAlternativeAbstract) { 
      this.alternativeAbstract = theAlternativeAbstract;
      return this;
    }

    public boolean hasAlternativeAbstract() { 
      if (this.alternativeAbstract == null)
        return false;
      for (CitationAlternativeAbstractComponent item : this.alternativeAbstract)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationAlternativeAbstractComponent addAlternativeAbstract() { //3
      CitationAlternativeAbstractComponent t = new CitationAlternativeAbstractComponent();
      if (this.alternativeAbstract == null)
        this.alternativeAbstract = new ArrayList<CitationAlternativeAbstractComponent>();
      this.alternativeAbstract.add(t);
      return t;
    }

    public Citation addAlternativeAbstract(CitationAlternativeAbstractComponent t) { //3
      if (t == null)
        return this;
      if (this.alternativeAbstract == null)
        this.alternativeAbstract = new ArrayList<CitationAlternativeAbstractComponent>();
      this.alternativeAbstract.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #alternativeAbstract}, creating it if it does not already exist {3}
     */
    public CitationAlternativeAbstractComponent getAlternativeAbstractFirstRep() { 
      if (getAlternativeAbstract().isEmpty()) {
        addAlternativeAbstract();
      }
      return getAlternativeAbstract().get(0);
    }

    /**
     * @return {@link #contributorship} (This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.)
     */
    public CitationContributorshipComponent getContributorship() { 
      if (this.contributorship == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.contributorship");
        else if (Configuration.doAutoCreate())
          this.contributorship = new CitationContributorshipComponent(); // cc
      return this.contributorship;
    }

    public boolean hasContributorship() { 
      return this.contributorship != null && !this.contributorship.isEmpty();
    }

    /**
     * @param value {@link #contributorship} (This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.)
     */
    public Citation setContributorship(CitationContributorshipComponent value) { 
      this.contributorship = value;
      return this;
    }

    /**
     * @return {@link #articleLanguage} (The language in which the article is published.)
     */
    public CodeableConcept getArticleLanguage() { 
      if (this.articleLanguage == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.articleLanguage");
        else if (Configuration.doAutoCreate())
          this.articleLanguage = new CodeableConcept(); // cc
      return this.articleLanguage;
    }

    public boolean hasArticleLanguage() { 
      return this.articleLanguage != null && !this.articleLanguage.isEmpty();
    }

    /**
     * @param value {@link #articleLanguage} (The language in which the article is published.)
     */
    public Citation setArticleLanguage(CodeableConcept value) { 
      this.articleLanguage = value;
      return this;
    }

    /**
     * @return {@link #alternativeForm} (Used to represent alternative forms of the article that are not separate citations.)
     */
    public List<CitationAlternativeFormComponent> getAlternativeForm() { 
      if (this.alternativeForm == null)
        this.alternativeForm = new ArrayList<CitationAlternativeFormComponent>();
      return this.alternativeForm;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setAlternativeForm(List<CitationAlternativeFormComponent> theAlternativeForm) { 
      this.alternativeForm = theAlternativeForm;
      return this;
    }

    public boolean hasAlternativeForm() { 
      if (this.alternativeForm == null)
        return false;
      for (CitationAlternativeFormComponent item : this.alternativeForm)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationAlternativeFormComponent addAlternativeForm() { //3
      CitationAlternativeFormComponent t = new CitationAlternativeFormComponent();
      if (this.alternativeForm == null)
        this.alternativeForm = new ArrayList<CitationAlternativeFormComponent>();
      this.alternativeForm.add(t);
      return t;
    }

    public Citation addAlternativeForm(CitationAlternativeFormComponent t) { //3
      if (t == null)
        return this;
      if (this.alternativeForm == null)
        this.alternativeForm = new ArrayList<CitationAlternativeFormComponent>();
      this.alternativeForm.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #alternativeForm}, creating it if it does not already exist {3}
     */
    public CitationAlternativeFormComponent getAlternativeFormFirstRep() { 
      if (getAlternativeForm().isEmpty()) {
        addAlternativeForm();
      }
      return getAlternativeForm().get(0);
    }

    /**
     * @return {@link #classifier} (Used for many classifiers including PublicationType, CitationSubset, MeshHeading, Chemical.)
     */
    public List<CodeableConcept> getClassifier() { 
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      return this.classifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setClassifier(List<CodeableConcept> theClassifier) { 
      this.classifier = theClassifier;
      return this;
    }

    public boolean hasClassifier() { 
      if (this.classifier == null)
        return false;
      for (CodeableConcept item : this.classifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addClassifier() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      this.classifier.add(t);
      return t;
    }

    public Citation addClassifier(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      this.classifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #classifier}, creating it if it does not already exist {3}
     */
    public CodeableConcept getClassifierFirstRep() { 
      if (getClassifier().isEmpty()) {
        addClassifier();
      }
      return getClassifier().get(0);
    }

    /**
     * @return {@link #keywordList} (A list of words classified as keywords for specific use in search functions.)
     */
    public List<CitationKeywordListComponent> getKeywordList() { 
      if (this.keywordList == null)
        this.keywordList = new ArrayList<CitationKeywordListComponent>();
      return this.keywordList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setKeywordList(List<CitationKeywordListComponent> theKeywordList) { 
      this.keywordList = theKeywordList;
      return this;
    }

    public boolean hasKeywordList() { 
      if (this.keywordList == null)
        return false;
      for (CitationKeywordListComponent item : this.keywordList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationKeywordListComponent addKeywordList() { //3
      CitationKeywordListComponent t = new CitationKeywordListComponent();
      if (this.keywordList == null)
        this.keywordList = new ArrayList<CitationKeywordListComponent>();
      this.keywordList.add(t);
      return t;
    }

    public Citation addKeywordList(CitationKeywordListComponent t) { //3
      if (t == null)
        return this;
      if (this.keywordList == null)
        this.keywordList = new ArrayList<CitationKeywordListComponent>();
      this.keywordList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #keywordList}, creating it if it does not already exist {3}
     */
    public CitationKeywordListComponent getKeywordListFirstRep() { 
      if (getKeywordList().isEmpty()) {
        addKeywordList();
      }
      return getKeywordList().get(0);
    }

    /**
     * @return {@link #relatedArtifact} (Link or citation to artifact associated with the referenced material.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      return this.relatedArtifact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
      this.relatedArtifact = theRelatedArtifact;
      return this;
    }

    public boolean hasRelatedArtifact() { 
      if (this.relatedArtifact == null)
        return false;
      for (RelatedArtifact item : this.relatedArtifact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RelatedArtifact addRelatedArtifact() { //3
      RelatedArtifact t = new RelatedArtifact();
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return t;
    }

    public Citation addRelatedArtifact(RelatedArtifact t) { //3
      if (t == null)
        return this;
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {3}
     */
    public RelatedArtifact getRelatedArtifactFirstRep() { 
      if (getRelatedArtifact().isEmpty()) {
        addRelatedArtifact();
      }
      return getRelatedArtifact().get(0);
    }

    /**
     * @return {@link #note} (Used for general notes and annotations not coded elsewhere.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setNote(List<Annotation> theNote) { 
      this.note = theNote;
      return this;
    }

    public boolean hasNote() { 
      if (this.note == null)
        return false;
      for (Annotation item : this.note)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Annotation addNote() { //3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public Citation addNote(Annotation t) { //3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
     */
    public Annotation getNoteFirstRep() { 
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

    /**
     * @return {@link #medlinePubMed} (These elements are items with values assigned by MEDLINE or PubMed management.)
     */
    public CitationMedlinePubMedComponent getMedlinePubMed() { 
      if (this.medlinePubMed == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.medlinePubMed");
        else if (Configuration.doAutoCreate())
          this.medlinePubMed = new CitationMedlinePubMedComponent(); // cc
      return this.medlinePubMed;
    }

    public boolean hasMedlinePubMed() { 
      return this.medlinePubMed != null && !this.medlinePubMed.isEmpty();
    }

    /**
     * @param value {@link #medlinePubMed} (These elements are items with values assigned by MEDLINE or PubMed management.)
     */
    public Citation setMedlinePubMed(CitationMedlinePubMedComponent value) { 
      this.medlinePubMed = value;
      return this;
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getVersionMax() { 
      return 0;
    }
    /**
     * @return {@link #version} (The identifier that is used to identify this version of the citation when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"version\"");
    }

    public boolean hasVersionElement() { 
      return false;
    }
    public boolean hasVersion() {
      return false;
    }

    /**
     * @param value {@link #version} (The identifier that is used to identify this version of the citation when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public Citation setVersionElement(StringType value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"version\"");
    }
    public String getVersion() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"version\"");
    }
    /**
     * @param value The identifier that is used to identify this version of the citation when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the citation author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public Citation setVersion(String value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"version\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getNameMax() { 
      return 0;
    }
    /**
     * @return {@link #name} (A natural language name identifying the citation. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"name\"");
    }

    public boolean hasNameElement() { 
      return false;
    }
    public boolean hasName() {
      return false;
    }

    /**
     * @param value {@link #name} (A natural language name identifying the citation. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public Citation setNameElement(StringType value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"name\"");
    }
    public String getName() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"name\"");
    }
    /**
     * @param value A natural language name identifying the citation. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public Citation setName(String value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"name\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getTitleMax() { 
      return 0;
    }
    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the citation.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"title\"");
    }

    public boolean hasTitleElement() { 
      return false;
    }
    public boolean hasTitle() {
      return false;
    }

    /**
     * @param value {@link #title} (A short, descriptive, user-friendly title for the citation.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public Citation setTitleElement(StringType value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"title\"");
    }
    public String getTitle() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"title\"");
    }
    /**
     * @param value A short, descriptive, user-friendly title for the citation.
     */
    public Citation setTitle(String value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"title\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getExperimentalMax() { 
      return 0;
    }
    /**
     * @return {@link #experimental} (A Boolean value to indicate that this citation is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"experimental\"");
    }

    public boolean hasExperimentalElement() { 
      return false;
    }
    public boolean hasExperimental() {
      return false;
    }

    /**
     * @param value {@link #experimental} (A Boolean value to indicate that this citation is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public Citation setExperimentalElement(BooleanType value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"experimental\"");
    }
    public boolean getExperimental() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"experimental\"");
    }
    /**
     * @param value A Boolean value to indicate that this citation is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public Citation setExperimental(boolean value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"experimental\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getDateMax() { 
      return 0;
    }
    /**
     * @return {@link #date} (The date  (and optionally time) when the citation was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"date\"");
    }

    public boolean hasDateElement() { 
      return false;
    }
    public boolean hasDate() {
      return false;
    }

    /**
     * @param value {@link #date} (The date  (and optionally time) when the citation was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public Citation setDateElement(DateTimeType value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"date\"");
    }
    public Date getDate() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"date\"");
    }
    /**
     * @param value The date  (and optionally time) when the citation was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the citation changes.
     */
    public Citation setDate(Date value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"date\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getPublisherMax() { 
      return 0;
    }
    /**
     * @return {@link #publisher} (The name of the organization or individual that published the citation.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"publisher\"");
    }

    public boolean hasPublisherElement() { 
      return false;
    }
    public boolean hasPublisher() {
      return false;
    }

    /**
     * @param value {@link #publisher} (The name of the organization or individual that published the citation.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public Citation setPublisherElement(StringType value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"publisher\"");
    }
    public String getPublisher() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"publisher\"");
    }
    /**
     * @param value The name of the organization or individual that published the citation.
     */
    public Citation setPublisher(String value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"publisher\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getContactMax() { 
      return 0;
    }
    /**
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public List<ContactDetail> getContact() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setContact(List<ContactDetail> theContact) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"contact\"");
    }
    public boolean hasContact() { 
      return false;
    }

    public ContactDetail addContact() { //3
      throw new Error("The resource type \"Citation\" does not implement the property \"contact\"");
    }
    public Citation addContact(ContactDetail t) { //3
      throw new Error("The resource type \"Citation\" does not implement the property \"contact\"");
    }
    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {2}
     */
    public ContactDetail getContactFirstRep() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"contact\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getDescriptionMax() { 
      return 0;
    }
    /**
     * @return {@link #description} (A free text natural language description of the citation from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"description\"");
    }

    public boolean hasDescriptionElement() { 
      return false;
    }
    public boolean hasDescription() {
      return false;
    }

    /**
     * @param value {@link #description} (A free text natural language description of the citation from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Citation setDescriptionElement(MarkdownType value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"description\"");
    }
    public String getDescription() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"description\"");
    }
    /**
     * @param value A free text natural language description of the citation from a consumer's perspective.
     */
    public Citation setDescription(String value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"description\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getJurisdictionMax() { 
      return 0;
    }
    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the citation is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setJurisdiction(List<CodeableConcept> theJurisdiction) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"jurisdiction\"");
    }
    public boolean hasJurisdiction() { 
      return false;
    }

    public CodeableConcept addJurisdiction() { //3
      throw new Error("The resource type \"Citation\" does not implement the property \"jurisdiction\"");
    }
    public Citation addJurisdiction(CodeableConcept t) { //3
      throw new Error("The resource type \"Citation\" does not implement the property \"jurisdiction\"");
    }
    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {2}
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"jurisdiction\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getPurposeMax() { 
      return 0;
    }
    /**
     * @return {@link #purpose} (Explanation of why this citation is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"purpose\"");
    }

    public boolean hasPurposeElement() { 
      return false;
    }
    public boolean hasPurpose() {
      return false;
    }

    /**
     * @param value {@link #purpose} (Explanation of why this citation is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public Citation setPurposeElement(MarkdownType value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"purpose\"");
    }
    public String getPurpose() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"purpose\"");
    }
    /**
     * @param value Explanation of why this citation is needed and why it has been designed as it has.
     */
    public Citation setPurpose(String value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"purpose\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getCopyrightMax() { 
      return 0;
    }
    /**
     * @return {@link #copyright} (A copyright statement relating to the citation and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the citation.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"copyright\"");
    }

    public boolean hasCopyrightElement() { 
      return false;
    }
    public boolean hasCopyright() {
      return false;
    }

    /**
     * @param value {@link #copyright} (A copyright statement relating to the citation and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the citation.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public Citation setCopyrightElement(MarkdownType value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"copyright\"");
    }
    public String getCopyright() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"copyright\"");
    }
    /**
     * @param value A copyright statement relating to the citation and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the citation.
     */
    public Citation setCopyright(String value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"copyright\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getApprovalDateMax() { 
      return 0;
    }
    /**
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"approvalDate\"");
    }

    public boolean hasApprovalDateElement() { 
      return false;
    }
    public boolean hasApprovalDate() {
      return false;
    }

    /**
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public Citation setApprovalDateElement(DateType value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"approvalDate\"");
    }
    public Date getApprovalDate() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"approvalDate\"");
    }
    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Citation setApprovalDate(Date value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"approvalDate\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getLastReviewDateMax() { 
      return 0;
    }
    /**
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"lastReviewDate\"");
    }

    public boolean hasLastReviewDateElement() { 
      return false;
    }
    public boolean hasLastReviewDate() {
      return false;
    }

    /**
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public Citation setLastReviewDateElement(DateType value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"lastReviewDate\"");
    }
    public Date getLastReviewDate() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"lastReviewDate\"");
    }
    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public Citation setLastReviewDate(Date value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"lastReviewDate\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getEffectivePeriodMax() { 
      return 0;
    }
    /**
     * @return {@link #effectivePeriod} (The period during which the citation content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      throw new Error("The resource type \"Citation\" does not implement the property \"effectivePeriod\"");
    }
    public boolean hasEffectivePeriod() { 
      return false;
    }
    /**
     * @param value {@link #effectivePeriod} (The period during which the citation content was or is planned to be in active use.)
     */
    public Citation setEffectivePeriod(Period value) { 
      throw new Error("The resource type \"Citation\" does not implement the property \"effectivePeriod\"");
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.", 0, 1, url));
        children.add(new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this citation when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("relatedIdentifier", "Identifier", "A formal identifier that is used to identify things closely related to this citation.", 0, java.lang.Integer.MAX_VALUE, relatedIdentifier));
        children.add(new Property("summary", "", "A human-readable display of the citation.", 0, java.lang.Integer.MAX_VALUE, summary));
        children.add(new Property("dateCited", "dateTime", "Date Cited.", 0, 1, dateCited));
        children.add(new Property("variantCitation", "", "Variant citation.", 0, 1, variantCitation));
        children.add(new Property("publishingModel", "CodeableConcept", "Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.", 0, 1, publishingModel));
        children.add(new Property("journal", "", "Contains identifiers and classifiers for the journal cited.", 0, 1, journal));
        children.add(new Property("publicationInfo", "", "Citation detail for sources other than journals such as books and databases.", 0, 1, publicationInfo));
        children.add(new Property("articleTitle", "markdown", "Full title of the article.", 0, 1, articleTitle));
        children.add(new Property("alternativeTitle", "", "Used for variant titles, such as translations.", 0, java.lang.Integer.MAX_VALUE, alternativeTitle));
        children.add(new Property("pagination", "", "Indicates the inclusive pages for the article cited.", 0, 1, pagination));
        children.add(new Property("articleUrl", "", "Used for any URL for the article cited.", 0, java.lang.Integer.MAX_VALUE, articleUrl));
        children.add(new Property("abstract", "markdown", "Abstract text, as published; may include structured labels.", 0, 1, abstract_));
        children.add(new Property("abstractCopyright", "markdown", "Copyright information for the abstract text.", 0, 1, abstractCopyright));
        children.add(new Property("alternativeAbstract", "", "Used for variant abstracts, such as translations.", 0, java.lang.Integer.MAX_VALUE, alternativeAbstract));
        children.add(new Property("contributorship", "", "This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.", 0, 1, contributorship));
        children.add(new Property("articleLanguage", "CodeableConcept", "The language in which the article is published.", 0, 1, articleLanguage));
        children.add(new Property("alternativeForm", "", "Used to represent alternative forms of the article that are not separate citations.", 0, java.lang.Integer.MAX_VALUE, alternativeForm));
        children.add(new Property("classifier", "CodeableConcept", "Used for many classifiers including PublicationType, CitationSubset, MeshHeading, Chemical.", 0, java.lang.Integer.MAX_VALUE, classifier));
        children.add(new Property("keywordList", "", "A list of words classified as keywords for specific use in search functions.", 0, java.lang.Integer.MAX_VALUE, keywordList));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Link or citation to artifact associated with the referenced material.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
        children.add(new Property("note", "Annotation", "Used for general notes and annotations not coded elsewhere.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("medlinePubMed", "", "These elements are items with values assigned by MEDLINE or PubMed management.", 0, 1, medlinePubMed));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.", 0, 1, url);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this citation when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1007604940: /*relatedIdentifier*/  return new Property("relatedIdentifier", "Identifier", "A formal identifier that is used to identify things closely related to this citation.", 0, java.lang.Integer.MAX_VALUE, relatedIdentifier);
        case -1857640538: /*summary*/  return new Property("summary", "", "A human-readable display of the citation.", 0, java.lang.Integer.MAX_VALUE, summary);
        case -275034401: /*dateCited*/  return new Property("dateCited", "dateTime", "Date Cited.", 0, 1, dateCited);
        case -1653134708: /*variantCitation*/  return new Property("variantCitation", "", "Variant citation.", 0, 1, variantCitation);
        case 747318902: /*publishingModel*/  return new Property("publishingModel", "CodeableConcept", "Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.", 0, 1, publishingModel);
        case -1419464905: /*journal*/  return new Property("journal", "", "Contains identifiers and classifiers for the journal cited.", 0, 1, journal);
        case 1470727418: /*publicationInfo*/  return new Property("publicationInfo", "", "Citation detail for sources other than journals such as books and databases.", 0, 1, publicationInfo);
        case -404746494: /*articleTitle*/  return new Property("articleTitle", "markdown", "Full title of the article.", 0, 1, articleTitle);
        case -1478308181: /*alternativeTitle*/  return new Property("alternativeTitle", "", "Used for variant titles, such as translations.", 0, java.lang.Integer.MAX_VALUE, alternativeTitle);
        case 1297692570: /*pagination*/  return new Property("pagination", "", "Indicates the inclusive pages for the article cited.", 0, 1, pagination);
        case 164943001: /*articleUrl*/  return new Property("articleUrl", "", "Used for any URL for the article cited.", 0, java.lang.Integer.MAX_VALUE, articleUrl);
        case 1732898850: /*abstract*/  return new Property("abstract", "markdown", "Abstract text, as published; may include structured labels.", 0, 1, abstract_);
        case -656627259: /*abstractCopyright*/  return new Property("abstractCopyright", "markdown", "Copyright information for the abstract text.", 0, 1, abstractCopyright);
        case -376340753: /*alternativeAbstract*/  return new Property("alternativeAbstract", "", "Used for variant abstracts, such as translations.", 0, java.lang.Integer.MAX_VALUE, alternativeAbstract);
        case 538727831: /*contributorship*/  return new Property("contributorship", "", "This element is used to list authors and other contributors, their contact information, specific contributions, and summary statements.", 0, 1, contributorship);
        case -1573097874: /*articleLanguage*/  return new Property("articleLanguage", "CodeableConcept", "The language in which the article is published.", 0, 1, articleLanguage);
        case 2030111249: /*alternativeForm*/  return new Property("alternativeForm", "", "Used to represent alternative forms of the article that are not separate citations.", 0, java.lang.Integer.MAX_VALUE, alternativeForm);
        case -281470431: /*classifier*/  return new Property("classifier", "CodeableConcept", "Used for many classifiers including PublicationType, CitationSubset, MeshHeading, Chemical.", 0, java.lang.Integer.MAX_VALUE, classifier);
        case -1298782681: /*keywordList*/  return new Property("keywordList", "", "A list of words classified as keywords for specific use in search functions.", 0, java.lang.Integer.MAX_VALUE, keywordList);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Link or citation to artifact associated with the referenced material.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Used for general notes and annotations not coded elsewhere.", 0, java.lang.Integer.MAX_VALUE, note);
        case -1342445201: /*medlinePubMed*/  return new Property("medlinePubMed", "", "These elements are items with values assigned by MEDLINE or PubMed management.", 0, 1, medlinePubMed);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1007604940: /*relatedIdentifier*/ return this.relatedIdentifier == null ? new Base[0] : this.relatedIdentifier.toArray(new Base[this.relatedIdentifier.size()]); // Identifier
        case -1857640538: /*summary*/ return this.summary == null ? new Base[0] : this.summary.toArray(new Base[this.summary.size()]); // CitationSummaryComponent
        case -275034401: /*dateCited*/ return this.dateCited == null ? new Base[0] : new Base[] {this.dateCited}; // DateTimeType
        case -1653134708: /*variantCitation*/ return this.variantCitation == null ? new Base[0] : new Base[] {this.variantCitation}; // CitationVariantCitationComponent
        case 747318902: /*publishingModel*/ return this.publishingModel == null ? new Base[0] : new Base[] {this.publishingModel}; // CodeableConcept
        case -1419464905: /*journal*/ return this.journal == null ? new Base[0] : new Base[] {this.journal}; // CitationJournalComponent
        case 1470727418: /*publicationInfo*/ return this.publicationInfo == null ? new Base[0] : new Base[] {this.publicationInfo}; // CitationPublicationInfoComponent
        case -404746494: /*articleTitle*/ return this.articleTitle == null ? new Base[0] : new Base[] {this.articleTitle}; // MarkdownType
        case -1478308181: /*alternativeTitle*/ return this.alternativeTitle == null ? new Base[0] : this.alternativeTitle.toArray(new Base[this.alternativeTitle.size()]); // CitationAlternativeTitleComponent
        case 1297692570: /*pagination*/ return this.pagination == null ? new Base[0] : new Base[] {this.pagination}; // CitationPaginationComponent
        case 164943001: /*articleUrl*/ return this.articleUrl == null ? new Base[0] : this.articleUrl.toArray(new Base[this.articleUrl.size()]); // CitationArticleUrlComponent
        case 1732898850: /*abstract*/ return this.abstract_ == null ? new Base[0] : new Base[] {this.abstract_}; // MarkdownType
        case -656627259: /*abstractCopyright*/ return this.abstractCopyright == null ? new Base[0] : new Base[] {this.abstractCopyright}; // MarkdownType
        case -376340753: /*alternativeAbstract*/ return this.alternativeAbstract == null ? new Base[0] : this.alternativeAbstract.toArray(new Base[this.alternativeAbstract.size()]); // CitationAlternativeAbstractComponent
        case 538727831: /*contributorship*/ return this.contributorship == null ? new Base[0] : new Base[] {this.contributorship}; // CitationContributorshipComponent
        case -1573097874: /*articleLanguage*/ return this.articleLanguage == null ? new Base[0] : new Base[] {this.articleLanguage}; // CodeableConcept
        case 2030111249: /*alternativeForm*/ return this.alternativeForm == null ? new Base[0] : this.alternativeForm.toArray(new Base[this.alternativeForm.size()]); // CitationAlternativeFormComponent
        case -281470431: /*classifier*/ return this.classifier == null ? new Base[0] : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
        case -1298782681: /*keywordList*/ return this.keywordList == null ? new Base[0] : this.keywordList.toArray(new Base[this.keywordList.size()]); // CitationKeywordListComponent
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1342445201: /*medlinePubMed*/ return this.medlinePubMed == null ? new Base[0] : new Base[] {this.medlinePubMed}; // CitationMedlinePubMedComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1007604940: // relatedIdentifier
          this.getRelatedIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1857640538: // summary
          this.getSummary().add((CitationSummaryComponent) value); // CitationSummaryComponent
          return value;
        case -275034401: // dateCited
          this.dateCited = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1653134708: // variantCitation
          this.variantCitation = (CitationVariantCitationComponent) value; // CitationVariantCitationComponent
          return value;
        case 747318902: // publishingModel
          this.publishingModel = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1419464905: // journal
          this.journal = (CitationJournalComponent) value; // CitationJournalComponent
          return value;
        case 1470727418: // publicationInfo
          this.publicationInfo = (CitationPublicationInfoComponent) value; // CitationPublicationInfoComponent
          return value;
        case -404746494: // articleTitle
          this.articleTitle = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1478308181: // alternativeTitle
          this.getAlternativeTitle().add((CitationAlternativeTitleComponent) value); // CitationAlternativeTitleComponent
          return value;
        case 1297692570: // pagination
          this.pagination = (CitationPaginationComponent) value; // CitationPaginationComponent
          return value;
        case 164943001: // articleUrl
          this.getArticleUrl().add((CitationArticleUrlComponent) value); // CitationArticleUrlComponent
          return value;
        case 1732898850: // abstract
          this.abstract_ = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -656627259: // abstractCopyright
          this.abstractCopyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -376340753: // alternativeAbstract
          this.getAlternativeAbstract().add((CitationAlternativeAbstractComponent) value); // CitationAlternativeAbstractComponent
          return value;
        case 538727831: // contributorship
          this.contributorship = (CitationContributorshipComponent) value; // CitationContributorshipComponent
          return value;
        case -1573097874: // articleLanguage
          this.articleLanguage = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 2030111249: // alternativeForm
          this.getAlternativeForm().add((CitationAlternativeFormComponent) value); // CitationAlternativeFormComponent
          return value;
        case -281470431: // classifier
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1298782681: // keywordList
          this.getKeywordList().add((CitationKeywordListComponent) value); // CitationKeywordListComponent
          return value;
        case 666807069: // relatedArtifact
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1342445201: // medlinePubMed
          this.medlinePubMed = (CitationMedlinePubMedComponent) value; // CitationMedlinePubMedComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("relatedIdentifier")) {
          this.getRelatedIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("summary")) {
          this.getSummary().add((CitationSummaryComponent) value);
        } else if (name.equals("dateCited")) {
          this.dateCited = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("variantCitation")) {
          this.variantCitation = (CitationVariantCitationComponent) value; // CitationVariantCitationComponent
        } else if (name.equals("publishingModel")) {
          this.publishingModel = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("journal")) {
          this.journal = (CitationJournalComponent) value; // CitationJournalComponent
        } else if (name.equals("publicationInfo")) {
          this.publicationInfo = (CitationPublicationInfoComponent) value; // CitationPublicationInfoComponent
        } else if (name.equals("articleTitle")) {
          this.articleTitle = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("alternativeTitle")) {
          this.getAlternativeTitle().add((CitationAlternativeTitleComponent) value);
        } else if (name.equals("pagination")) {
          this.pagination = (CitationPaginationComponent) value; // CitationPaginationComponent
        } else if (name.equals("articleUrl")) {
          this.getArticleUrl().add((CitationArticleUrlComponent) value);
        } else if (name.equals("abstract")) {
          this.abstract_ = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("abstractCopyright")) {
          this.abstractCopyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("alternativeAbstract")) {
          this.getAlternativeAbstract().add((CitationAlternativeAbstractComponent) value);
        } else if (name.equals("contributorship")) {
          this.contributorship = (CitationContributorshipComponent) value; // CitationContributorshipComponent
        } else if (name.equals("articleLanguage")) {
          this.articleLanguage = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("alternativeForm")) {
          this.getAlternativeForm().add((CitationAlternativeFormComponent) value);
        } else if (name.equals("classifier")) {
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("keywordList")) {
          this.getKeywordList().add((CitationKeywordListComponent) value);
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("medlinePubMed")) {
          this.medlinePubMed = (CitationMedlinePubMedComponent) value; // CitationMedlinePubMedComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -892481550:  return getStatusElement();
        case -669707736:  return addUseContext(); 
        case -1618432855:  return addIdentifier(); 
        case -1007604940:  return addRelatedIdentifier(); 
        case -1857640538:  return addSummary(); 
        case -275034401:  return getDateCitedElement();
        case -1653134708:  return getVariantCitation();
        case 747318902:  return getPublishingModel();
        case -1419464905:  return getJournal();
        case 1470727418:  return getPublicationInfo();
        case -404746494:  return getArticleTitleElement();
        case -1478308181:  return addAlternativeTitle(); 
        case 1297692570:  return getPagination();
        case 164943001:  return addArticleUrl(); 
        case 1732898850:  return getAbstractElement();
        case -656627259:  return getAbstractCopyrightElement();
        case -376340753:  return addAlternativeAbstract(); 
        case 538727831:  return getContributorship();
        case -1573097874:  return getArticleLanguage();
        case 2030111249:  return addAlternativeForm(); 
        case -281470431:  return addClassifier(); 
        case -1298782681:  return addKeywordList(); 
        case 666807069:  return addRelatedArtifact(); 
        case 3387378:  return addNote(); 
        case -1342445201:  return getMedlinePubMed();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1007604940: /*relatedIdentifier*/ return new String[] {"Identifier"};
        case -1857640538: /*summary*/ return new String[] {};
        case -275034401: /*dateCited*/ return new String[] {"dateTime"};
        case -1653134708: /*variantCitation*/ return new String[] {};
        case 747318902: /*publishingModel*/ return new String[] {"CodeableConcept"};
        case -1419464905: /*journal*/ return new String[] {};
        case 1470727418: /*publicationInfo*/ return new String[] {};
        case -404746494: /*articleTitle*/ return new String[] {"markdown"};
        case -1478308181: /*alternativeTitle*/ return new String[] {};
        case 1297692570: /*pagination*/ return new String[] {};
        case 164943001: /*articleUrl*/ return new String[] {};
        case 1732898850: /*abstract*/ return new String[] {"markdown"};
        case -656627259: /*abstractCopyright*/ return new String[] {"markdown"};
        case -376340753: /*alternativeAbstract*/ return new String[] {};
        case 538727831: /*contributorship*/ return new String[] {};
        case -1573097874: /*articleLanguage*/ return new String[] {"CodeableConcept"};
        case 2030111249: /*alternativeForm*/ return new String[] {};
        case -281470431: /*classifier*/ return new String[] {"CodeableConcept"};
        case -1298782681: /*keywordList*/ return new String[] {};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -1342445201: /*medlinePubMed*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.url");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.status");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("relatedIdentifier")) {
          return addRelatedIdentifier();
        }
        else if (name.equals("summary")) {
          return addSummary();
        }
        else if (name.equals("dateCited")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.dateCited");
        }
        else if (name.equals("variantCitation")) {
          this.variantCitation = new CitationVariantCitationComponent();
          return this.variantCitation;
        }
        else if (name.equals("publishingModel")) {
          this.publishingModel = new CodeableConcept();
          return this.publishingModel;
        }
        else if (name.equals("journal")) {
          this.journal = new CitationJournalComponent();
          return this.journal;
        }
        else if (name.equals("publicationInfo")) {
          this.publicationInfo = new CitationPublicationInfoComponent();
          return this.publicationInfo;
        }
        else if (name.equals("articleTitle")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.articleTitle");
        }
        else if (name.equals("alternativeTitle")) {
          return addAlternativeTitle();
        }
        else if (name.equals("pagination")) {
          this.pagination = new CitationPaginationComponent();
          return this.pagination;
        }
        else if (name.equals("articleUrl")) {
          return addArticleUrl();
        }
        else if (name.equals("abstract")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.abstract");
        }
        else if (name.equals("abstractCopyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.abstractCopyright");
        }
        else if (name.equals("alternativeAbstract")) {
          return addAlternativeAbstract();
        }
        else if (name.equals("contributorship")) {
          this.contributorship = new CitationContributorshipComponent();
          return this.contributorship;
        }
        else if (name.equals("articleLanguage")) {
          this.articleLanguage = new CodeableConcept();
          return this.articleLanguage;
        }
        else if (name.equals("alternativeForm")) {
          return addAlternativeForm();
        }
        else if (name.equals("classifier")) {
          return addClassifier();
        }
        else if (name.equals("keywordList")) {
          return addKeywordList();
        }
        else if (name.equals("relatedArtifact")) {
          return addRelatedArtifact();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("medlinePubMed")) {
          this.medlinePubMed = new CitationMedlinePubMedComponent();
          return this.medlinePubMed;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Citation";

  }

      public Citation copy() {
        Citation dst = new Citation();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Citation dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        dst.status = status == null ? null : status.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (relatedIdentifier != null) {
          dst.relatedIdentifier = new ArrayList<Identifier>();
          for (Identifier i : relatedIdentifier)
            dst.relatedIdentifier.add(i.copy());
        };
        if (summary != null) {
          dst.summary = new ArrayList<CitationSummaryComponent>();
          for (CitationSummaryComponent i : summary)
            dst.summary.add(i.copy());
        };
        dst.dateCited = dateCited == null ? null : dateCited.copy();
        dst.variantCitation = variantCitation == null ? null : variantCitation.copy();
        dst.publishingModel = publishingModel == null ? null : publishingModel.copy();
        dst.journal = journal == null ? null : journal.copy();
        dst.publicationInfo = publicationInfo == null ? null : publicationInfo.copy();
        dst.articleTitle = articleTitle == null ? null : articleTitle.copy();
        if (alternativeTitle != null) {
          dst.alternativeTitle = new ArrayList<CitationAlternativeTitleComponent>();
          for (CitationAlternativeTitleComponent i : alternativeTitle)
            dst.alternativeTitle.add(i.copy());
        };
        dst.pagination = pagination == null ? null : pagination.copy();
        if (articleUrl != null) {
          dst.articleUrl = new ArrayList<CitationArticleUrlComponent>();
          for (CitationArticleUrlComponent i : articleUrl)
            dst.articleUrl.add(i.copy());
        };
        dst.abstract_ = abstract_ == null ? null : abstract_.copy();
        dst.abstractCopyright = abstractCopyright == null ? null : abstractCopyright.copy();
        if (alternativeAbstract != null) {
          dst.alternativeAbstract = new ArrayList<CitationAlternativeAbstractComponent>();
          for (CitationAlternativeAbstractComponent i : alternativeAbstract)
            dst.alternativeAbstract.add(i.copy());
        };
        dst.contributorship = contributorship == null ? null : contributorship.copy();
        dst.articleLanguage = articleLanguage == null ? null : articleLanguage.copy();
        if (alternativeForm != null) {
          dst.alternativeForm = new ArrayList<CitationAlternativeFormComponent>();
          for (CitationAlternativeFormComponent i : alternativeForm)
            dst.alternativeForm.add(i.copy());
        };
        if (classifier != null) {
          dst.classifier = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : classifier)
            dst.classifier.add(i.copy());
        };
        if (keywordList != null) {
          dst.keywordList = new ArrayList<CitationKeywordListComponent>();
          for (CitationKeywordListComponent i : keywordList)
            dst.keywordList.add(i.copy());
        };
        if (relatedArtifact != null) {
          dst.relatedArtifact = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : relatedArtifact)
            dst.relatedArtifact.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.medlinePubMed = medlinePubMed == null ? null : medlinePubMed.copy();
      }

      protected Citation typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Citation))
          return false;
        Citation o = (Citation) other_;
        return compareDeep(url, o.url, true) && compareDeep(status, o.status, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(identifier, o.identifier, true) && compareDeep(relatedIdentifier, o.relatedIdentifier, true)
           && compareDeep(summary, o.summary, true) && compareDeep(dateCited, o.dateCited, true) && compareDeep(variantCitation, o.variantCitation, true)
           && compareDeep(publishingModel, o.publishingModel, true) && compareDeep(journal, o.journal, true)
           && compareDeep(publicationInfo, o.publicationInfo, true) && compareDeep(articleTitle, o.articleTitle, true)
           && compareDeep(alternativeTitle, o.alternativeTitle, true) && compareDeep(pagination, o.pagination, true)
           && compareDeep(articleUrl, o.articleUrl, true) && compareDeep(abstract_, o.abstract_, true) && compareDeep(abstractCopyright, o.abstractCopyright, true)
           && compareDeep(alternativeAbstract, o.alternativeAbstract, true) && compareDeep(contributorship, o.contributorship, true)
           && compareDeep(articleLanguage, o.articleLanguage, true) && compareDeep(alternativeForm, o.alternativeForm, true)
           && compareDeep(classifier, o.classifier, true) && compareDeep(keywordList, o.keywordList, true)
           && compareDeep(relatedArtifact, o.relatedArtifact, true) && compareDeep(note, o.note, true) && compareDeep(medlinePubMed, o.medlinePubMed, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Citation))
          return false;
        Citation o = (Citation) other_;
        return compareValues(url, o.url, true) && compareValues(status, o.status, true) && compareValues(dateCited, o.dateCited, true)
           && compareValues(articleTitle, o.articleTitle, true) && compareValues(abstract_, o.abstract_, true)
           && compareValues(abstractCopyright, o.abstractCopyright, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, status, useContext
          , identifier, relatedIdentifier, summary, dateCited, variantCitation, publishingModel
          , journal, publicationInfo, articleTitle, alternativeTitle, pagination, articleUrl
          , abstract_, abstractCopyright, alternativeAbstract, contributorship, articleLanguage
          , alternativeForm, classifier, keywordList, relatedArtifact, note, medlinePubMed
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Citation;
   }

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the citation</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(Citation.useContext.value as Quantity) | (Citation.useContext.value as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(Citation.useContext.value as Quantity) | (Citation.useContext.value as Range)", description="A quantity- or range-valued use context assigned to the citation", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the citation</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(Citation.useContext.value as Quantity) | (Citation.useContext.value as Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the citation</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Citation.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="Citation.useContext", description="A use context type and quantity- or range-based value assigned to the citation", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the citation</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Citation.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the citation</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Citation.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="Citation.useContext", description="A use context type and value assigned to the citation", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the citation</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Citation.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="Citation.useContext.code", description="A type of use context assigned to the citation", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Citation.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(Citation.useContext.value as CodeableConcept)", description="A use context assigned to the citation", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Citation.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Citation.identifier", description="External identifier for the citation", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Citation.status", description="The current status of the citation", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the citation</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Citation.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="Citation.url", description="The uri that identifies the citation", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the citation</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Citation.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);


}

