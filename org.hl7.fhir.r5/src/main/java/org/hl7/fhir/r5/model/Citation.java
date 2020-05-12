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

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent

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
        @Child(name = "publicationDate", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Date on which the issue of the journal was published", formalDefinition="Date on which the issue of the journal was published." )
        protected StringType publicationDate;

        private static final long serialVersionUID = -1343937439L;

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
         * @return {@link #publicationDate} (Date on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getPublicationDate" gives direct access to the value
         */
        public StringType getPublicationDateElement() { 
          if (this.publicationDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationJournalJournalIssueComponent.publicationDate");
            else if (Configuration.doAutoCreate())
              this.publicationDate = new StringType(); // bb
          return this.publicationDate;
        }

        public boolean hasPublicationDateElement() { 
          return this.publicationDate != null && !this.publicationDate.isEmpty();
        }

        public boolean hasPublicationDate() { 
          return this.publicationDate != null && !this.publicationDate.isEmpty();
        }

        /**
         * @param value {@link #publicationDate} (Date on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getPublicationDate" gives direct access to the value
         */
        public CitationJournalJournalIssueComponent setPublicationDateElement(StringType value) { 
          this.publicationDate = value;
          return this;
        }

        /**
         * @return Date on which the issue of the journal was published.
         */
        public String getPublicationDate() { 
          return this.publicationDate == null ? null : this.publicationDate.getValue();
        }

        /**
         * @param value Date on which the issue of the journal was published.
         */
        public CitationJournalJournalIssueComponent setPublicationDate(String value) { 
          if (Utilities.noString(value))
            this.publicationDate = null;
          else {
            if (this.publicationDate == null)
              this.publicationDate = new StringType();
            this.publicationDate.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("citedMedium", "CodeableConcept", "NLM codes Internet or Print.", 0, 1, citedMedium));
          children.add(new Property("volume", "string", "Volume number of journal in which the article is published.", 0, 1, volume));
          children.add(new Property("issue", "string", "Issue, part or supplement of journal in which the article is published.", 0, 1, issue));
          children.add(new Property("publicationDate", "string", "Date on which the issue of the journal was published.", 0, 1, publicationDate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 612116418: /*citedMedium*/  return new Property("citedMedium", "CodeableConcept", "NLM codes Internet or Print.", 0, 1, citedMedium);
          case -810883302: /*volume*/  return new Property("volume", "string", "Volume number of journal in which the article is published.", 0, 1, volume);
          case 100509913: /*issue*/  return new Property("issue", "string", "Issue, part or supplement of journal in which the article is published.", 0, 1, issue);
          case 1470566394: /*publicationDate*/  return new Property("publicationDate", "string", "Date on which the issue of the journal was published.", 0, 1, publicationDate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 612116418: /*citedMedium*/ return this.citedMedium == null ? new Base[0] : new Base[] {this.citedMedium}; // CodeableConcept
        case -810883302: /*volume*/ return this.volume == null ? new Base[0] : new Base[] {this.volume}; // StringType
        case 100509913: /*issue*/ return this.issue == null ? new Base[0] : new Base[] {this.issue}; // StringType
        case 1470566394: /*publicationDate*/ return this.publicationDate == null ? new Base[0] : new Base[] {this.publicationDate}; // StringType
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
          this.publicationDate = TypeConvertor.castToString(value); // StringType
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
          this.publicationDate = TypeConvertor.castToString(value); // StringType
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
        case 1470566394:  return getPublicationDateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 612116418: /*citedMedium*/ return new String[] {"CodeableConcept"};
        case -810883302: /*volume*/ return new String[] {"string"};
        case 100509913: /*issue*/ return new String[] {"string"};
        case 1470566394: /*publicationDate*/ return new String[] {"string"};
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
          throw new FHIRException("Cannot call addChild on a primitive type Citation.journal.journalIssue.publicationDate");
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
        return compareValues(volume, o.volume, true) && compareValues(issue, o.issue, true) && compareValues(publicationDate, o.publicationDate, true)
          ;
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
    public static class CitationAuthorListComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates if the list includes all authors, else “et al” should be appended for display.
         */
        @Child(name = "complete", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates if the list includes all authors, else “et al” should be appended for display", formalDefinition="Indicates if the list includes all authors, else “et al” should be appended for display." )
        protected BooleanType complete;

        /**
         * An individual entity named in the author list.
         */
        @Child(name = "author", type = {}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="An individual entity named in the author list", formalDefinition="An individual entity named in the author list." )
        protected List<CitationAuthorListAuthorComponent> author;

        private static final long serialVersionUID = -204175482L;

    /**
     * Constructor
     */
      public CitationAuthorListComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationAuthorListComponent(CitationAuthorListAuthorComponent author) {
        super();
        this.addAuthor(author);
      }

        /**
         * @return {@link #complete} (Indicates if the list includes all authors, else “et al” should be appended for display.). This is the underlying object with id, value and extensions. The accessor "getComplete" gives direct access to the value
         */
        public BooleanType getCompleteElement() { 
          if (this.complete == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAuthorListComponent.complete");
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
         * @param value {@link #complete} (Indicates if the list includes all authors, else “et al” should be appended for display.). This is the underlying object with id, value and extensions. The accessor "getComplete" gives direct access to the value
         */
        public CitationAuthorListComponent setCompleteElement(BooleanType value) { 
          this.complete = value;
          return this;
        }

        /**
         * @return Indicates if the list includes all authors, else “et al” should be appended for display.
         */
        public boolean getComplete() { 
          return this.complete == null || this.complete.isEmpty() ? false : this.complete.getValue();
        }

        /**
         * @param value Indicates if the list includes all authors, else “et al” should be appended for display.
         */
        public CitationAuthorListComponent setComplete(boolean value) { 
            if (this.complete == null)
              this.complete = new BooleanType();
            this.complete.setValue(value);
          return this;
        }

        /**
         * @return {@link #author} (An individual entity named in the author list.)
         */
        public List<CitationAuthorListAuthorComponent> getAuthor() { 
          if (this.author == null)
            this.author = new ArrayList<CitationAuthorListAuthorComponent>();
          return this.author;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationAuthorListComponent setAuthor(List<CitationAuthorListAuthorComponent> theAuthor) { 
          this.author = theAuthor;
          return this;
        }

        public boolean hasAuthor() { 
          if (this.author == null)
            return false;
          for (CitationAuthorListAuthorComponent item : this.author)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationAuthorListAuthorComponent addAuthor() { //3
          CitationAuthorListAuthorComponent t = new CitationAuthorListAuthorComponent();
          if (this.author == null)
            this.author = new ArrayList<CitationAuthorListAuthorComponent>();
          this.author.add(t);
          return t;
        }

        public CitationAuthorListComponent addAuthor(CitationAuthorListAuthorComponent t) { //3
          if (t == null)
            return this;
          if (this.author == null)
            this.author = new ArrayList<CitationAuthorListAuthorComponent>();
          this.author.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist {3}
         */
        public CitationAuthorListAuthorComponent getAuthorFirstRep() { 
          if (getAuthor().isEmpty()) {
            addAuthor();
          }
          return getAuthor().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("complete", "boolean", "Indicates if the list includes all authors, else “et al” should be appended for display.", 0, 1, complete));
          children.add(new Property("author", "", "An individual entity named in the author list.", 0, java.lang.Integer.MAX_VALUE, author));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -599445191: /*complete*/  return new Property("complete", "boolean", "Indicates if the list includes all authors, else “et al” should be appended for display.", 0, 1, complete);
          case -1406328437: /*author*/  return new Property("author", "", "An individual entity named in the author list.", 0, java.lang.Integer.MAX_VALUE, author);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -599445191: /*complete*/ return this.complete == null ? new Base[0] : new Base[] {this.complete}; // BooleanType
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // CitationAuthorListAuthorComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -599445191: // complete
          this.complete = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1406328437: // author
          this.getAuthor().add((CitationAuthorListAuthorComponent) value); // CitationAuthorListAuthorComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("complete")) {
          this.complete = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("author")) {
          this.getAuthor().add((CitationAuthorListAuthorComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -599445191:  return getCompleteElement();
        case -1406328437:  return addAuthor(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -599445191: /*complete*/ return new String[] {"boolean"};
        case -1406328437: /*author*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("complete")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorList.complete");
        }
        else if (name.equals("author")) {
          return addAuthor();
        }
        else
          return super.addChild(name);
      }

      public CitationAuthorListComponent copy() {
        CitationAuthorListComponent dst = new CitationAuthorListComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAuthorListComponent dst) {
        super.copyValues(dst);
        dst.complete = complete == null ? null : complete.copy();
        if (author != null) {
          dst.author = new ArrayList<CitationAuthorListAuthorComponent>();
          for (CitationAuthorListAuthorComponent i : author)
            dst.author.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationAuthorListComponent))
          return false;
        CitationAuthorListComponent o = (CitationAuthorListComponent) other_;
        return compareDeep(complete, o.complete, true) && compareDeep(author, o.author, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAuthorListComponent))
          return false;
        CitationAuthorListComponent o = (CitationAuthorListComponent) other_;
        return compareValues(complete, o.complete, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(complete, author);
      }

  public String fhirType() {
    return "Citation.authorList";

  }

  }

    @Block()
    public static class CitationAuthorListAuthorComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Surname or single name.
         */
        @Child(name = "lastName", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Surname or single name", formalDefinition="Surname or single name." )
        protected StringType lastName;

        /**
         * Remainder of name except for suffix.
         */
        @Child(name = "foreName", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Remainder of name except for suffix", formalDefinition="Remainder of name except for suffix." )
        protected StringType foreName;

        /**
         * Eg 2nd, 3rd, Jr, Sr.
         */
        @Child(name = "suffix", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Eg 2nd, 3rd, Jr, Sr", formalDefinition="Eg 2nd, 3rd, Jr, Sr." )
        protected StringType suffix;

        /**
         * Initials for forename.
         */
        @Child(name = "initials", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Initials for forename", formalDefinition="Initials for forename." )
        protected StringType initials;

        /**
         * Used for collective or corporate name as an author.
         */
        @Child(name = "collectiveName", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for collective or corporate name as an author", formalDefinition="Used for collective or corporate name as an author." )
        protected StringType collectiveName;

        /**
         * Author identifier, eg ORCID.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Author identifier, eg ORCID", formalDefinition="Author identifier, eg ORCID." )
        protected List<Identifier> identifier;

        /**
         * Organizational affiliation.
         */
        @Child(name = "affiliationInfo", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Organizational affiliation", formalDefinition="Organizational affiliation." )
        protected List<CitationAuthorListAuthorAffiliationInfoComponent> affiliationInfo;

        /**
         * Physical mailing address for the author.
         */
        @Child(name = "address", type = {StringType.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Physical mailing address for the author", formalDefinition="Physical mailing address for the author." )
        protected List<StringType> address;

        /**
         * Email or telephone contact methods for the author.
         */
        @Child(name = "telecom", type = {ContactPoint.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Email or telephone contact methods for the author", formalDefinition="Email or telephone contact methods for the author." )
        protected List<ContactPoint> telecom;

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

        private static final long serialVersionUID = 1461164632L;

    /**
     * Constructor
     */
      public CitationAuthorListAuthorComponent() {
        super();
      }

        /**
         * @return {@link #lastName} (Surname or single name.). This is the underlying object with id, value and extensions. The accessor "getLastName" gives direct access to the value
         */
        public StringType getLastNameElement() { 
          if (this.lastName == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAuthorListAuthorComponent.lastName");
            else if (Configuration.doAutoCreate())
              this.lastName = new StringType(); // bb
          return this.lastName;
        }

        public boolean hasLastNameElement() { 
          return this.lastName != null && !this.lastName.isEmpty();
        }

        public boolean hasLastName() { 
          return this.lastName != null && !this.lastName.isEmpty();
        }

        /**
         * @param value {@link #lastName} (Surname or single name.). This is the underlying object with id, value and extensions. The accessor "getLastName" gives direct access to the value
         */
        public CitationAuthorListAuthorComponent setLastNameElement(StringType value) { 
          this.lastName = value;
          return this;
        }

        /**
         * @return Surname or single name.
         */
        public String getLastName() { 
          return this.lastName == null ? null : this.lastName.getValue();
        }

        /**
         * @param value Surname or single name.
         */
        public CitationAuthorListAuthorComponent setLastName(String value) { 
          if (Utilities.noString(value))
            this.lastName = null;
          else {
            if (this.lastName == null)
              this.lastName = new StringType();
            this.lastName.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #foreName} (Remainder of name except for suffix.). This is the underlying object with id, value and extensions. The accessor "getForeName" gives direct access to the value
         */
        public StringType getForeNameElement() { 
          if (this.foreName == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAuthorListAuthorComponent.foreName");
            else if (Configuration.doAutoCreate())
              this.foreName = new StringType(); // bb
          return this.foreName;
        }

        public boolean hasForeNameElement() { 
          return this.foreName != null && !this.foreName.isEmpty();
        }

        public boolean hasForeName() { 
          return this.foreName != null && !this.foreName.isEmpty();
        }

        /**
         * @param value {@link #foreName} (Remainder of name except for suffix.). This is the underlying object with id, value and extensions. The accessor "getForeName" gives direct access to the value
         */
        public CitationAuthorListAuthorComponent setForeNameElement(StringType value) { 
          this.foreName = value;
          return this;
        }

        /**
         * @return Remainder of name except for suffix.
         */
        public String getForeName() { 
          return this.foreName == null ? null : this.foreName.getValue();
        }

        /**
         * @param value Remainder of name except for suffix.
         */
        public CitationAuthorListAuthorComponent setForeName(String value) { 
          if (Utilities.noString(value))
            this.foreName = null;
          else {
            if (this.foreName == null)
              this.foreName = new StringType();
            this.foreName.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #suffix} (Eg 2nd, 3rd, Jr, Sr.). This is the underlying object with id, value and extensions. The accessor "getSuffix" gives direct access to the value
         */
        public StringType getSuffixElement() { 
          if (this.suffix == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAuthorListAuthorComponent.suffix");
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
         * @param value {@link #suffix} (Eg 2nd, 3rd, Jr, Sr.). This is the underlying object with id, value and extensions. The accessor "getSuffix" gives direct access to the value
         */
        public CitationAuthorListAuthorComponent setSuffixElement(StringType value) { 
          this.suffix = value;
          return this;
        }

        /**
         * @return Eg 2nd, 3rd, Jr, Sr.
         */
        public String getSuffix() { 
          return this.suffix == null ? null : this.suffix.getValue();
        }

        /**
         * @param value Eg 2nd, 3rd, Jr, Sr.
         */
        public CitationAuthorListAuthorComponent setSuffix(String value) { 
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
         * @return {@link #initials} (Initials for forename.). This is the underlying object with id, value and extensions. The accessor "getInitials" gives direct access to the value
         */
        public StringType getInitialsElement() { 
          if (this.initials == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAuthorListAuthorComponent.initials");
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
        public CitationAuthorListAuthorComponent setInitialsElement(StringType value) { 
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
        public CitationAuthorListAuthorComponent setInitials(String value) { 
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
              throw new Error("Attempt to auto-create CitationAuthorListAuthorComponent.collectiveName");
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
        public CitationAuthorListAuthorComponent setCollectiveNameElement(StringType value) { 
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
        public CitationAuthorListAuthorComponent setCollectiveName(String value) { 
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
         * @return {@link #identifier} (Author identifier, eg ORCID.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationAuthorListAuthorComponent setIdentifier(List<Identifier> theIdentifier) { 
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

        public CitationAuthorListAuthorComponent addIdentifier(Identifier t) { //3
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
         * @return {@link #affiliationInfo} (Organizational affiliation.)
         */
        public List<CitationAuthorListAuthorAffiliationInfoComponent> getAffiliationInfo() { 
          if (this.affiliationInfo == null)
            this.affiliationInfo = new ArrayList<CitationAuthorListAuthorAffiliationInfoComponent>();
          return this.affiliationInfo;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationAuthorListAuthorComponent setAffiliationInfo(List<CitationAuthorListAuthorAffiliationInfoComponent> theAffiliationInfo) { 
          this.affiliationInfo = theAffiliationInfo;
          return this;
        }

        public boolean hasAffiliationInfo() { 
          if (this.affiliationInfo == null)
            return false;
          for (CitationAuthorListAuthorAffiliationInfoComponent item : this.affiliationInfo)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationAuthorListAuthorAffiliationInfoComponent addAffiliationInfo() { //3
          CitationAuthorListAuthorAffiliationInfoComponent t = new CitationAuthorListAuthorAffiliationInfoComponent();
          if (this.affiliationInfo == null)
            this.affiliationInfo = new ArrayList<CitationAuthorListAuthorAffiliationInfoComponent>();
          this.affiliationInfo.add(t);
          return t;
        }

        public CitationAuthorListAuthorComponent addAffiliationInfo(CitationAuthorListAuthorAffiliationInfoComponent t) { //3
          if (t == null)
            return this;
          if (this.affiliationInfo == null)
            this.affiliationInfo = new ArrayList<CitationAuthorListAuthorAffiliationInfoComponent>();
          this.affiliationInfo.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #affiliationInfo}, creating it if it does not already exist {3}
         */
        public CitationAuthorListAuthorAffiliationInfoComponent getAffiliationInfoFirstRep() { 
          if (getAffiliationInfo().isEmpty()) {
            addAffiliationInfo();
          }
          return getAffiliationInfo().get(0);
        }

        /**
         * @return {@link #address} (Physical mailing address for the author.)
         */
        public List<StringType> getAddress() { 
          if (this.address == null)
            this.address = new ArrayList<StringType>();
          return this.address;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationAuthorListAuthorComponent setAddress(List<StringType> theAddress) { 
          this.address = theAddress;
          return this;
        }

        public boolean hasAddress() { 
          if (this.address == null)
            return false;
          for (StringType item : this.address)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #address} (Physical mailing address for the author.)
         */
        public StringType addAddressElement() {//2 
          StringType t = new StringType();
          if (this.address == null)
            this.address = new ArrayList<StringType>();
          this.address.add(t);
          return t;
        }

        /**
         * @param value {@link #address} (Physical mailing address for the author.)
         */
        public CitationAuthorListAuthorComponent addAddress(String value) { //1
          StringType t = new StringType();
          t.setValue(value);
          if (this.address == null)
            this.address = new ArrayList<StringType>();
          this.address.add(t);
          return this;
        }

        /**
         * @param value {@link #address} (Physical mailing address for the author.)
         */
        public boolean hasAddress(String value) { 
          if (this.address == null)
            return false;
          for (StringType v : this.address)
            if (v.getValue().equals(value)) // string
              return true;
          return false;
        }

        /**
         * @return {@link #telecom} (Email or telephone contact methods for the author.)
         */
        public List<ContactPoint> getTelecom() { 
          if (this.telecom == null)
            this.telecom = new ArrayList<ContactPoint>();
          return this.telecom;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationAuthorListAuthorComponent setTelecom(List<ContactPoint> theTelecom) { 
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

        public CitationAuthorListAuthorComponent addTelecom(ContactPoint t) { //3
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
         * @return {@link #correspondingAuthor} (Indication of which author is the corresponding author for the article cited.). This is the underlying object with id, value and extensions. The accessor "getCorrespondingAuthor" gives direct access to the value
         */
        public BooleanType getCorrespondingAuthorElement() { 
          if (this.correspondingAuthor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAuthorListAuthorComponent.correspondingAuthor");
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
        public CitationAuthorListAuthorComponent setCorrespondingAuthorElement(BooleanType value) { 
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
        public CitationAuthorListAuthorComponent setCorrespondingAuthor(boolean value) { 
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
              throw new Error("Attempt to auto-create CitationAuthorListAuthorComponent.listOrder");
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
        public CitationAuthorListAuthorComponent setListOrderElement(PositiveIntType value) { 
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
        public CitationAuthorListAuthorComponent setListOrder(int value) { 
            if (this.listOrder == null)
              this.listOrder = new PositiveIntType();
            this.listOrder.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("lastName", "string", "Surname or single name.", 0, 1, lastName));
          children.add(new Property("foreName", "string", "Remainder of name except for suffix.", 0, 1, foreName));
          children.add(new Property("suffix", "string", "Eg 2nd, 3rd, Jr, Sr.", 0, 1, suffix));
          children.add(new Property("initials", "string", "Initials for forename.", 0, 1, initials));
          children.add(new Property("collectiveName", "string", "Used for collective or corporate name as an author.", 0, 1, collectiveName));
          children.add(new Property("identifier", "Identifier", "Author identifier, eg ORCID.", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("affiliationInfo", "", "Organizational affiliation.", 0, java.lang.Integer.MAX_VALUE, affiliationInfo));
          children.add(new Property("address", "string", "Physical mailing address for the author.", 0, java.lang.Integer.MAX_VALUE, address));
          children.add(new Property("telecom", "ContactPoint", "Email or telephone contact methods for the author.", 0, java.lang.Integer.MAX_VALUE, telecom));
          children.add(new Property("correspondingAuthor", "boolean", "Indication of which author is the corresponding author for the article cited.", 0, 1, correspondingAuthor));
          children.add(new Property("listOrder", "positiveInt", "Used to code order of authors.", 0, 1, listOrder));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1459599807: /*lastName*/  return new Property("lastName", "string", "Surname or single name.", 0, 1, lastName);
          case 466107751: /*foreName*/  return new Property("foreName", "string", "Remainder of name except for suffix.", 0, 1, foreName);
          case -891422895: /*suffix*/  return new Property("suffix", "string", "Eg 2nd, 3rd, Jr, Sr.", 0, 1, suffix);
          case 269062575: /*initials*/  return new Property("initials", "string", "Initials for forename.", 0, 1, initials);
          case 502871833: /*collectiveName*/  return new Property("collectiveName", "string", "Used for collective or corporate name as an author.", 0, 1, collectiveName);
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Author identifier, eg ORCID.", 0, java.lang.Integer.MAX_VALUE, identifier);
          case -215129154: /*affiliationInfo*/  return new Property("affiliationInfo", "", "Organizational affiliation.", 0, java.lang.Integer.MAX_VALUE, affiliationInfo);
          case -1147692044: /*address*/  return new Property("address", "string", "Physical mailing address for the author.", 0, java.lang.Integer.MAX_VALUE, address);
          case -1429363305: /*telecom*/  return new Property("telecom", "ContactPoint", "Email or telephone contact methods for the author.", 0, java.lang.Integer.MAX_VALUE, telecom);
          case 1413890206: /*correspondingAuthor*/  return new Property("correspondingAuthor", "boolean", "Indication of which author is the corresponding author for the article cited.", 0, 1, correspondingAuthor);
          case -1238918832: /*listOrder*/  return new Property("listOrder", "positiveInt", "Used to code order of authors.", 0, 1, listOrder);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1459599807: /*lastName*/ return this.lastName == null ? new Base[0] : new Base[] {this.lastName}; // StringType
        case 466107751: /*foreName*/ return this.foreName == null ? new Base[0] : new Base[] {this.foreName}; // StringType
        case -891422895: /*suffix*/ return this.suffix == null ? new Base[0] : new Base[] {this.suffix}; // StringType
        case 269062575: /*initials*/ return this.initials == null ? new Base[0] : new Base[] {this.initials}; // StringType
        case 502871833: /*collectiveName*/ return this.collectiveName == null ? new Base[0] : new Base[] {this.collectiveName}; // StringType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -215129154: /*affiliationInfo*/ return this.affiliationInfo == null ? new Base[0] : this.affiliationInfo.toArray(new Base[this.affiliationInfo.size()]); // CitationAuthorListAuthorAffiliationInfoComponent
        case -1147692044: /*address*/ return this.address == null ? new Base[0] : this.address.toArray(new Base[this.address.size()]); // StringType
        case -1429363305: /*telecom*/ return this.telecom == null ? new Base[0] : this.telecom.toArray(new Base[this.telecom.size()]); // ContactPoint
        case 1413890206: /*correspondingAuthor*/ return this.correspondingAuthor == null ? new Base[0] : new Base[] {this.correspondingAuthor}; // BooleanType
        case -1238918832: /*listOrder*/ return this.listOrder == null ? new Base[0] : new Base[] {this.listOrder}; // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1459599807: // lastName
          this.lastName = TypeConvertor.castToString(value); // StringType
          return value;
        case 466107751: // foreName
          this.foreName = TypeConvertor.castToString(value); // StringType
          return value;
        case -891422895: // suffix
          this.suffix = TypeConvertor.castToString(value); // StringType
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
          this.getAffiliationInfo().add((CitationAuthorListAuthorAffiliationInfoComponent) value); // CitationAuthorListAuthorAffiliationInfoComponent
          return value;
        case -1147692044: // address
          this.getAddress().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case -1429363305: // telecom
          this.getTelecom().add(TypeConvertor.castToContactPoint(value)); // ContactPoint
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
        if (name.equals("lastName")) {
          this.lastName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("foreName")) {
          this.foreName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("suffix")) {
          this.suffix = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("initials")) {
          this.initials = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("collectiveName")) {
          this.collectiveName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("affiliationInfo")) {
          this.getAffiliationInfo().add((CitationAuthorListAuthorAffiliationInfoComponent) value);
        } else if (name.equals("address")) {
          this.getAddress().add(TypeConvertor.castToString(value));
        } else if (name.equals("telecom")) {
          this.getTelecom().add(TypeConvertor.castToContactPoint(value));
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
        case -1459599807:  return getLastNameElement();
        case 466107751:  return getForeNameElement();
        case -891422895:  return getSuffixElement();
        case 269062575:  return getInitialsElement();
        case 502871833:  return getCollectiveNameElement();
        case -1618432855:  return addIdentifier(); 
        case -215129154:  return addAffiliationInfo(); 
        case -1147692044:  return addAddressElement();
        case -1429363305:  return addTelecom(); 
        case 1413890206:  return getCorrespondingAuthorElement();
        case -1238918832:  return getListOrderElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1459599807: /*lastName*/ return new String[] {"string"};
        case 466107751: /*foreName*/ return new String[] {"string"};
        case -891422895: /*suffix*/ return new String[] {"string"};
        case 269062575: /*initials*/ return new String[] {"string"};
        case 502871833: /*collectiveName*/ return new String[] {"string"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -215129154: /*affiliationInfo*/ return new String[] {};
        case -1147692044: /*address*/ return new String[] {"string"};
        case -1429363305: /*telecom*/ return new String[] {"ContactPoint"};
        case 1413890206: /*correspondingAuthor*/ return new String[] {"boolean"};
        case -1238918832: /*listOrder*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("lastName")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorList.author.lastName");
        }
        else if (name.equals("foreName")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorList.author.foreName");
        }
        else if (name.equals("suffix")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorList.author.suffix");
        }
        else if (name.equals("initials")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorList.author.initials");
        }
        else if (name.equals("collectiveName")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorList.author.collectiveName");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("affiliationInfo")) {
          return addAffiliationInfo();
        }
        else if (name.equals("address")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorList.author.address");
        }
        else if (name.equals("telecom")) {
          return addTelecom();
        }
        else if (name.equals("correspondingAuthor")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorList.author.correspondingAuthor");
        }
        else if (name.equals("listOrder")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorList.author.listOrder");
        }
        else
          return super.addChild(name);
      }

      public CitationAuthorListAuthorComponent copy() {
        CitationAuthorListAuthorComponent dst = new CitationAuthorListAuthorComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAuthorListAuthorComponent dst) {
        super.copyValues(dst);
        dst.lastName = lastName == null ? null : lastName.copy();
        dst.foreName = foreName == null ? null : foreName.copy();
        dst.suffix = suffix == null ? null : suffix.copy();
        dst.initials = initials == null ? null : initials.copy();
        dst.collectiveName = collectiveName == null ? null : collectiveName.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (affiliationInfo != null) {
          dst.affiliationInfo = new ArrayList<CitationAuthorListAuthorAffiliationInfoComponent>();
          for (CitationAuthorListAuthorAffiliationInfoComponent i : affiliationInfo)
            dst.affiliationInfo.add(i.copy());
        };
        if (address != null) {
          dst.address = new ArrayList<StringType>();
          for (StringType i : address)
            dst.address.add(i.copy());
        };
        if (telecom != null) {
          dst.telecom = new ArrayList<ContactPoint>();
          for (ContactPoint i : telecom)
            dst.telecom.add(i.copy());
        };
        dst.correspondingAuthor = correspondingAuthor == null ? null : correspondingAuthor.copy();
        dst.listOrder = listOrder == null ? null : listOrder.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationAuthorListAuthorComponent))
          return false;
        CitationAuthorListAuthorComponent o = (CitationAuthorListAuthorComponent) other_;
        return compareDeep(lastName, o.lastName, true) && compareDeep(foreName, o.foreName, true) && compareDeep(suffix, o.suffix, true)
           && compareDeep(initials, o.initials, true) && compareDeep(collectiveName, o.collectiveName, true)
           && compareDeep(identifier, o.identifier, true) && compareDeep(affiliationInfo, o.affiliationInfo, true)
           && compareDeep(address, o.address, true) && compareDeep(telecom, o.telecom, true) && compareDeep(correspondingAuthor, o.correspondingAuthor, true)
           && compareDeep(listOrder, o.listOrder, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAuthorListAuthorComponent))
          return false;
        CitationAuthorListAuthorComponent o = (CitationAuthorListAuthorComponent) other_;
        return compareValues(lastName, o.lastName, true) && compareValues(foreName, o.foreName, true) && compareValues(suffix, o.suffix, true)
           && compareValues(initials, o.initials, true) && compareValues(collectiveName, o.collectiveName, true)
           && compareValues(address, o.address, true) && compareValues(correspondingAuthor, o.correspondingAuthor, true)
           && compareValues(listOrder, o.listOrder, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(lastName, foreName, suffix
          , initials, collectiveName, identifier, affiliationInfo, address, telecom, correspondingAuthor
          , listOrder);
      }

  public String fhirType() {
    return "Citation.authorList.author";

  }

  }

    @Block()
    public static class CitationAuthorListAuthorAffiliationInfoComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Display for the organization.
         */
        @Child(name = "affiliation", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Display for the organization", formalDefinition="Display for the organization." )
        protected StringType affiliation;

        /**
         * Role.
         */
        @Child(name = "role", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Role", formalDefinition="Role." )
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
      public CitationAuthorListAuthorAffiliationInfoComponent() {
        super();
      }

        /**
         * @return {@link #affiliation} (Display for the organization.). This is the underlying object with id, value and extensions. The accessor "getAffiliation" gives direct access to the value
         */
        public StringType getAffiliationElement() { 
          if (this.affiliation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAuthorListAuthorAffiliationInfoComponent.affiliation");
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
        public CitationAuthorListAuthorAffiliationInfoComponent setAffiliationElement(StringType value) { 
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
        public CitationAuthorListAuthorAffiliationInfoComponent setAffiliation(String value) { 
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
         * @return {@link #role} (Role.). This is the underlying object with id, value and extensions. The accessor "getRole" gives direct access to the value
         */
        public StringType getRoleElement() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAuthorListAuthorAffiliationInfoComponent.role");
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
         * @param value {@link #role} (Role.). This is the underlying object with id, value and extensions. The accessor "getRole" gives direct access to the value
         */
        public CitationAuthorListAuthorAffiliationInfoComponent setRoleElement(StringType value) { 
          this.role = value;
          return this;
        }

        /**
         * @return Role.
         */
        public String getRole() { 
          return this.role == null ? null : this.role.getValue();
        }

        /**
         * @param value Role.
         */
        public CitationAuthorListAuthorAffiliationInfoComponent setRole(String value) { 
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
        public CitationAuthorListAuthorAffiliationInfoComponent setIdentifier(List<Identifier> theIdentifier) { 
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

        public CitationAuthorListAuthorAffiliationInfoComponent addIdentifier(Identifier t) { //3
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
          children.add(new Property("role", "string", "Role.", 0, 1, role));
          children.add(new Property("identifier", "Identifier", "Identifier for the organization.", 0, java.lang.Integer.MAX_VALUE, identifier));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 2019918576: /*affiliation*/  return new Property("affiliation", "string", "Display for the organization.", 0, 1, affiliation);
          case 3506294: /*role*/  return new Property("role", "string", "Role.", 0, 1, role);
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
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorList.author.affiliationInfo.affiliation");
        }
        else if (name.equals("role")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorList.author.affiliationInfo.role");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else
          return super.addChild(name);
      }

      public CitationAuthorListAuthorAffiliationInfoComponent copy() {
        CitationAuthorListAuthorAffiliationInfoComponent dst = new CitationAuthorListAuthorAffiliationInfoComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAuthorListAuthorAffiliationInfoComponent dst) {
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
        if (!(other_ instanceof CitationAuthorListAuthorAffiliationInfoComponent))
          return false;
        CitationAuthorListAuthorAffiliationInfoComponent o = (CitationAuthorListAuthorAffiliationInfoComponent) other_;
        return compareDeep(affiliation, o.affiliation, true) && compareDeep(role, o.role, true) && compareDeep(identifier, o.identifier, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAuthorListAuthorAffiliationInfoComponent))
          return false;
        CitationAuthorListAuthorAffiliationInfoComponent o = (CitationAuthorListAuthorAffiliationInfoComponent) other_;
        return compareValues(affiliation, o.affiliation, true) && compareValues(role, o.role, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(affiliation, role, identifier
          );
      }

  public String fhirType() {
    return "Citation.authorList.author.affiliationInfo";

  }

  }

    @Block()
    public static class CitationAuthorStringComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used to code the producer or rule for creating the display string.
         */
        @Child(name = "source", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to code the producer or rule for creating the display string", formalDefinition="Used to code the producer or rule for creating the display string." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/author-string-source")
        protected CodeableConcept source;

        /**
         * The display string for the author list.
         */
        @Child(name = "value", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The display string for the author list", formalDefinition="The display string for the author list." )
        protected StringType value;

        private static final long serialVersionUID = -1218527170L;

    /**
     * Constructor
     */
      public CitationAuthorStringComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationAuthorStringComponent(String value) {
        super();
        this.setValue(value);
      }

        /**
         * @return {@link #source} (Used to code the producer or rule for creating the display string.)
         */
        public CodeableConcept getSource() { 
          if (this.source == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAuthorStringComponent.source");
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
        public CitationAuthorStringComponent setSource(CodeableConcept value) { 
          this.source = value;
          return this;
        }

        /**
         * @return {@link #value} (The display string for the author list.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAuthorStringComponent.value");
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
         * @param value {@link #value} (The display string for the author list.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public CitationAuthorStringComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The display string for the author list.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The display string for the author list.
         */
        public CitationAuthorStringComponent setValue(String value) { 
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("source", "CodeableConcept", "Used to code the producer or rule for creating the display string.", 0, 1, source));
          children.add(new Property("value", "string", "The display string for the author list.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -896505829: /*source*/  return new Property("source", "CodeableConcept", "Used to code the producer or rule for creating the display string.", 0, 1, source);
          case 111972721: /*value*/  return new Property("value", "string", "The display string for the author list.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -896505829: // source
          this.source = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("source")) {
          this.source = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -896505829:  return getSource();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -896505829: /*source*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("source")) {
          this.source = new CodeableConcept();
          return this.source;
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.authorString.value");
        }
        else
          return super.addChild(name);
      }

      public CitationAuthorStringComponent copy() {
        CitationAuthorStringComponent dst = new CitationAuthorStringComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationAuthorStringComponent dst) {
        super.copyValues(dst);
        dst.source = source == null ? null : source.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationAuthorStringComponent))
          return false;
        CitationAuthorStringComponent o = (CitationAuthorStringComponent) other_;
        return compareDeep(source, o.source, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationAuthorStringComponent))
          return false;
        CitationAuthorStringComponent o = (CitationAuthorStringComponent) other_;
        return compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(source, value);
      }

  public String fhirType() {
    return "Citation.authorString";

  }

  }

    @Block()
    public static class CitationContributorListComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates if the list includes all contributors.
         */
        @Child(name = "complete", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indicates if the list includes all contributors", formalDefinition="Indicates if the list includes all contributors." )
        protected BooleanType complete;

        /**
         * An individual entity named in the contributor list.
         */
        @Child(name = "contributor", type = {}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="An individual entity named in the contributor list", formalDefinition="An individual entity named in the contributor list." )
        protected List<CitationContributorListContributorComponent> contributor;

        private static final long serialVersionUID = 1922271126L;

    /**
     * Constructor
     */
      public CitationContributorListComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CitationContributorListComponent(CitationContributorListContributorComponent contributor) {
        super();
        this.addContributor(contributor);
      }

        /**
         * @return {@link #complete} (Indicates if the list includes all contributors.). This is the underlying object with id, value and extensions. The accessor "getComplete" gives direct access to the value
         */
        public BooleanType getCompleteElement() { 
          if (this.complete == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorListComponent.complete");
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
         * @param value {@link #complete} (Indicates if the list includes all contributors.). This is the underlying object with id, value and extensions. The accessor "getComplete" gives direct access to the value
         */
        public CitationContributorListComponent setCompleteElement(BooleanType value) { 
          this.complete = value;
          return this;
        }

        /**
         * @return Indicates if the list includes all contributors.
         */
        public boolean getComplete() { 
          return this.complete == null || this.complete.isEmpty() ? false : this.complete.getValue();
        }

        /**
         * @param value Indicates if the list includes all contributors.
         */
        public CitationContributorListComponent setComplete(boolean value) { 
            if (this.complete == null)
              this.complete = new BooleanType();
            this.complete.setValue(value);
          return this;
        }

        /**
         * @return {@link #contributor} (An individual entity named in the contributor list.)
         */
        public List<CitationContributorListContributorComponent> getContributor() { 
          if (this.contributor == null)
            this.contributor = new ArrayList<CitationContributorListContributorComponent>();
          return this.contributor;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorListComponent setContributor(List<CitationContributorListContributorComponent> theContributor) { 
          this.contributor = theContributor;
          return this;
        }

        public boolean hasContributor() { 
          if (this.contributor == null)
            return false;
          for (CitationContributorListContributorComponent item : this.contributor)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationContributorListContributorComponent addContributor() { //3
          CitationContributorListContributorComponent t = new CitationContributorListContributorComponent();
          if (this.contributor == null)
            this.contributor = new ArrayList<CitationContributorListContributorComponent>();
          this.contributor.add(t);
          return t;
        }

        public CitationContributorListComponent addContributor(CitationContributorListContributorComponent t) { //3
          if (t == null)
            return this;
          if (this.contributor == null)
            this.contributor = new ArrayList<CitationContributorListContributorComponent>();
          this.contributor.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #contributor}, creating it if it does not already exist {3}
         */
        public CitationContributorListContributorComponent getContributorFirstRep() { 
          if (getContributor().isEmpty()) {
            addContributor();
          }
          return getContributor().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("complete", "boolean", "Indicates if the list includes all contributors.", 0, 1, complete));
          children.add(new Property("contributor", "", "An individual entity named in the contributor list.", 0, java.lang.Integer.MAX_VALUE, contributor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -599445191: /*complete*/  return new Property("complete", "boolean", "Indicates if the list includes all contributors.", 0, 1, complete);
          case -1895276325: /*contributor*/  return new Property("contributor", "", "An individual entity named in the contributor list.", 0, java.lang.Integer.MAX_VALUE, contributor);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -599445191: /*complete*/ return this.complete == null ? new Base[0] : new Base[] {this.complete}; // BooleanType
        case -1895276325: /*contributor*/ return this.contributor == null ? new Base[0] : this.contributor.toArray(new Base[this.contributor.size()]); // CitationContributorListContributorComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -599445191: // complete
          this.complete = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1895276325: // contributor
          this.getContributor().add((CitationContributorListContributorComponent) value); // CitationContributorListContributorComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("complete")) {
          this.complete = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("contributor")) {
          this.getContributor().add((CitationContributorListContributorComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -599445191:  return getCompleteElement();
        case -1895276325:  return addContributor(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -599445191: /*complete*/ return new String[] {"boolean"};
        case -1895276325: /*contributor*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("complete")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorList.complete");
        }
        else if (name.equals("contributor")) {
          return addContributor();
        }
        else
          return super.addChild(name);
      }

      public CitationContributorListComponent copy() {
        CitationContributorListComponent dst = new CitationContributorListComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationContributorListComponent dst) {
        super.copyValues(dst);
        dst.complete = complete == null ? null : complete.copy();
        if (contributor != null) {
          dst.contributor = new ArrayList<CitationContributorListContributorComponent>();
          for (CitationContributorListContributorComponent i : contributor)
            dst.contributor.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationContributorListComponent))
          return false;
        CitationContributorListComponent o = (CitationContributorListComponent) other_;
        return compareDeep(complete, o.complete, true) && compareDeep(contributor, o.contributor, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationContributorListComponent))
          return false;
        CitationContributorListComponent o = (CitationContributorListComponent) other_;
        return compareValues(complete, o.complete, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(complete, contributor);
      }

  public String fhirType() {
    return "Citation.contributorList";

  }

  }

    @Block()
    public static class CitationContributorListContributorComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Surname or single name.
         */
        @Child(name = "lastName", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Surname or single name", formalDefinition="Surname or single name." )
        protected StringType lastName;

        /**
         * Remainder of name except for suffix.
         */
        @Child(name = "foreName", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Remainder of name except for suffix", formalDefinition="Remainder of name except for suffix." )
        protected StringType foreName;

        /**
         * Eg 2nd, 3rd, Jr, Sr.
         */
        @Child(name = "suffix", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Eg 2nd, 3rd, Jr, Sr", formalDefinition="Eg 2nd, 3rd, Jr, Sr." )
        protected StringType suffix;

        /**
         * Initials for forename.
         */
        @Child(name = "initials", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Initials for forename", formalDefinition="Initials for forename." )
        protected StringType initials;

        /**
         * Used for collective or corporate name as a contributor.
         */
        @Child(name = "collectiveName", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used for collective or corporate name as a contributor", formalDefinition="Used for collective or corporate name as a contributor." )
        protected StringType collectiveName;

        /**
         * Contributor identifier, eg ORCID.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Contributor identifier, eg ORCID", formalDefinition="Contributor identifier, eg ORCID." )
        protected List<Identifier> identifier;

        /**
         * The specific contributions.
         */
        @Child(name = "contribution", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The specific contributions", formalDefinition="The specific contributions." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-contribution")
        protected List<CodeableConcept> contribution;

        /**
         * Organizational affiliation.
         */
        @Child(name = "affiliationInfo", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Organizational affiliation", formalDefinition="Organizational affiliation." )
        protected List<CitationContributorListContributorAffiliationInfoComponent> affiliationInfo;

        /**
         * Used to code order of contributors.
         */
        @Child(name = "listOrder", type = {PositiveIntType.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to code order of contributors", formalDefinition="Used to code order of contributors." )
        protected PositiveIntType listOrder;

        private static final long serialVersionUID = 160410057L;

    /**
     * Constructor
     */
      public CitationContributorListContributorComponent() {
        super();
      }

        /**
         * @return {@link #lastName} (Surname or single name.). This is the underlying object with id, value and extensions. The accessor "getLastName" gives direct access to the value
         */
        public StringType getLastNameElement() { 
          if (this.lastName == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorListContributorComponent.lastName");
            else if (Configuration.doAutoCreate())
              this.lastName = new StringType(); // bb
          return this.lastName;
        }

        public boolean hasLastNameElement() { 
          return this.lastName != null && !this.lastName.isEmpty();
        }

        public boolean hasLastName() { 
          return this.lastName != null && !this.lastName.isEmpty();
        }

        /**
         * @param value {@link #lastName} (Surname or single name.). This is the underlying object with id, value and extensions. The accessor "getLastName" gives direct access to the value
         */
        public CitationContributorListContributorComponent setLastNameElement(StringType value) { 
          this.lastName = value;
          return this;
        }

        /**
         * @return Surname or single name.
         */
        public String getLastName() { 
          return this.lastName == null ? null : this.lastName.getValue();
        }

        /**
         * @param value Surname or single name.
         */
        public CitationContributorListContributorComponent setLastName(String value) { 
          if (Utilities.noString(value))
            this.lastName = null;
          else {
            if (this.lastName == null)
              this.lastName = new StringType();
            this.lastName.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #foreName} (Remainder of name except for suffix.). This is the underlying object with id, value and extensions. The accessor "getForeName" gives direct access to the value
         */
        public StringType getForeNameElement() { 
          if (this.foreName == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorListContributorComponent.foreName");
            else if (Configuration.doAutoCreate())
              this.foreName = new StringType(); // bb
          return this.foreName;
        }

        public boolean hasForeNameElement() { 
          return this.foreName != null && !this.foreName.isEmpty();
        }

        public boolean hasForeName() { 
          return this.foreName != null && !this.foreName.isEmpty();
        }

        /**
         * @param value {@link #foreName} (Remainder of name except for suffix.). This is the underlying object with id, value and extensions. The accessor "getForeName" gives direct access to the value
         */
        public CitationContributorListContributorComponent setForeNameElement(StringType value) { 
          this.foreName = value;
          return this;
        }

        /**
         * @return Remainder of name except for suffix.
         */
        public String getForeName() { 
          return this.foreName == null ? null : this.foreName.getValue();
        }

        /**
         * @param value Remainder of name except for suffix.
         */
        public CitationContributorListContributorComponent setForeName(String value) { 
          if (Utilities.noString(value))
            this.foreName = null;
          else {
            if (this.foreName == null)
              this.foreName = new StringType();
            this.foreName.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #suffix} (Eg 2nd, 3rd, Jr, Sr.). This is the underlying object with id, value and extensions. The accessor "getSuffix" gives direct access to the value
         */
        public StringType getSuffixElement() { 
          if (this.suffix == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorListContributorComponent.suffix");
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
         * @param value {@link #suffix} (Eg 2nd, 3rd, Jr, Sr.). This is the underlying object with id, value and extensions. The accessor "getSuffix" gives direct access to the value
         */
        public CitationContributorListContributorComponent setSuffixElement(StringType value) { 
          this.suffix = value;
          return this;
        }

        /**
         * @return Eg 2nd, 3rd, Jr, Sr.
         */
        public String getSuffix() { 
          return this.suffix == null ? null : this.suffix.getValue();
        }

        /**
         * @param value Eg 2nd, 3rd, Jr, Sr.
         */
        public CitationContributorListContributorComponent setSuffix(String value) { 
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
         * @return {@link #initials} (Initials for forename.). This is the underlying object with id, value and extensions. The accessor "getInitials" gives direct access to the value
         */
        public StringType getInitialsElement() { 
          if (this.initials == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorListContributorComponent.initials");
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
        public CitationContributorListContributorComponent setInitialsElement(StringType value) { 
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
        public CitationContributorListContributorComponent setInitials(String value) { 
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
         * @return {@link #collectiveName} (Used for collective or corporate name as a contributor.). This is the underlying object with id, value and extensions. The accessor "getCollectiveName" gives direct access to the value
         */
        public StringType getCollectiveNameElement() { 
          if (this.collectiveName == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorListContributorComponent.collectiveName");
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
         * @param value {@link #collectiveName} (Used for collective or corporate name as a contributor.). This is the underlying object with id, value and extensions. The accessor "getCollectiveName" gives direct access to the value
         */
        public CitationContributorListContributorComponent setCollectiveNameElement(StringType value) { 
          this.collectiveName = value;
          return this;
        }

        /**
         * @return Used for collective or corporate name as a contributor.
         */
        public String getCollectiveName() { 
          return this.collectiveName == null ? null : this.collectiveName.getValue();
        }

        /**
         * @param value Used for collective or corporate name as a contributor.
         */
        public CitationContributorListContributorComponent setCollectiveName(String value) { 
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
         * @return {@link #identifier} (Contributor identifier, eg ORCID.)
         */
        public List<Identifier> getIdentifier() { 
          if (this.identifier == null)
            this.identifier = new ArrayList<Identifier>();
          return this.identifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorListContributorComponent setIdentifier(List<Identifier> theIdentifier) { 
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

        public CitationContributorListContributorComponent addIdentifier(Identifier t) { //3
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
         * @return {@link #contribution} (The specific contributions.)
         */
        public List<CodeableConcept> getContribution() { 
          if (this.contribution == null)
            this.contribution = new ArrayList<CodeableConcept>();
          return this.contribution;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorListContributorComponent setContribution(List<CodeableConcept> theContribution) { 
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

        public CitationContributorListContributorComponent addContribution(CodeableConcept t) { //3
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
         * @return {@link #affiliationInfo} (Organizational affiliation.)
         */
        public List<CitationContributorListContributorAffiliationInfoComponent> getAffiliationInfo() { 
          if (this.affiliationInfo == null)
            this.affiliationInfo = new ArrayList<CitationContributorListContributorAffiliationInfoComponent>();
          return this.affiliationInfo;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CitationContributorListContributorComponent setAffiliationInfo(List<CitationContributorListContributorAffiliationInfoComponent> theAffiliationInfo) { 
          this.affiliationInfo = theAffiliationInfo;
          return this;
        }

        public boolean hasAffiliationInfo() { 
          if (this.affiliationInfo == null)
            return false;
          for (CitationContributorListContributorAffiliationInfoComponent item : this.affiliationInfo)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CitationContributorListContributorAffiliationInfoComponent addAffiliationInfo() { //3
          CitationContributorListContributorAffiliationInfoComponent t = new CitationContributorListContributorAffiliationInfoComponent();
          if (this.affiliationInfo == null)
            this.affiliationInfo = new ArrayList<CitationContributorListContributorAffiliationInfoComponent>();
          this.affiliationInfo.add(t);
          return t;
        }

        public CitationContributorListContributorComponent addAffiliationInfo(CitationContributorListContributorAffiliationInfoComponent t) { //3
          if (t == null)
            return this;
          if (this.affiliationInfo == null)
            this.affiliationInfo = new ArrayList<CitationContributorListContributorAffiliationInfoComponent>();
          this.affiliationInfo.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #affiliationInfo}, creating it if it does not already exist {3}
         */
        public CitationContributorListContributorAffiliationInfoComponent getAffiliationInfoFirstRep() { 
          if (getAffiliationInfo().isEmpty()) {
            addAffiliationInfo();
          }
          return getAffiliationInfo().get(0);
        }

        /**
         * @return {@link #listOrder} (Used to code order of contributors.). This is the underlying object with id, value and extensions. The accessor "getListOrder" gives direct access to the value
         */
        public PositiveIntType getListOrderElement() { 
          if (this.listOrder == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorListContributorComponent.listOrder");
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
         * @param value {@link #listOrder} (Used to code order of contributors.). This is the underlying object with id, value and extensions. The accessor "getListOrder" gives direct access to the value
         */
        public CitationContributorListContributorComponent setListOrderElement(PositiveIntType value) { 
          this.listOrder = value;
          return this;
        }

        /**
         * @return Used to code order of contributors.
         */
        public int getListOrder() { 
          return this.listOrder == null || this.listOrder.isEmpty() ? 0 : this.listOrder.getValue();
        }

        /**
         * @param value Used to code order of contributors.
         */
        public CitationContributorListContributorComponent setListOrder(int value) { 
            if (this.listOrder == null)
              this.listOrder = new PositiveIntType();
            this.listOrder.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("lastName", "string", "Surname or single name.", 0, 1, lastName));
          children.add(new Property("foreName", "string", "Remainder of name except for suffix.", 0, 1, foreName));
          children.add(new Property("suffix", "string", "Eg 2nd, 3rd, Jr, Sr.", 0, 1, suffix));
          children.add(new Property("initials", "string", "Initials for forename.", 0, 1, initials));
          children.add(new Property("collectiveName", "string", "Used for collective or corporate name as a contributor.", 0, 1, collectiveName));
          children.add(new Property("identifier", "Identifier", "Contributor identifier, eg ORCID.", 0, java.lang.Integer.MAX_VALUE, identifier));
          children.add(new Property("contribution", "CodeableConcept", "The specific contributions.", 0, java.lang.Integer.MAX_VALUE, contribution));
          children.add(new Property("affiliationInfo", "", "Organizational affiliation.", 0, java.lang.Integer.MAX_VALUE, affiliationInfo));
          children.add(new Property("listOrder", "positiveInt", "Used to code order of contributors.", 0, 1, listOrder));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1459599807: /*lastName*/  return new Property("lastName", "string", "Surname or single name.", 0, 1, lastName);
          case 466107751: /*foreName*/  return new Property("foreName", "string", "Remainder of name except for suffix.", 0, 1, foreName);
          case -891422895: /*suffix*/  return new Property("suffix", "string", "Eg 2nd, 3rd, Jr, Sr.", 0, 1, suffix);
          case 269062575: /*initials*/  return new Property("initials", "string", "Initials for forename.", 0, 1, initials);
          case 502871833: /*collectiveName*/  return new Property("collectiveName", "string", "Used for collective or corporate name as a contributor.", 0, 1, collectiveName);
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Contributor identifier, eg ORCID.", 0, java.lang.Integer.MAX_VALUE, identifier);
          case 1375970320: /*contribution*/  return new Property("contribution", "CodeableConcept", "The specific contributions.", 0, java.lang.Integer.MAX_VALUE, contribution);
          case -215129154: /*affiliationInfo*/  return new Property("affiliationInfo", "", "Organizational affiliation.", 0, java.lang.Integer.MAX_VALUE, affiliationInfo);
          case -1238918832: /*listOrder*/  return new Property("listOrder", "positiveInt", "Used to code order of contributors.", 0, 1, listOrder);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1459599807: /*lastName*/ return this.lastName == null ? new Base[0] : new Base[] {this.lastName}; // StringType
        case 466107751: /*foreName*/ return this.foreName == null ? new Base[0] : new Base[] {this.foreName}; // StringType
        case -891422895: /*suffix*/ return this.suffix == null ? new Base[0] : new Base[] {this.suffix}; // StringType
        case 269062575: /*initials*/ return this.initials == null ? new Base[0] : new Base[] {this.initials}; // StringType
        case 502871833: /*collectiveName*/ return this.collectiveName == null ? new Base[0] : new Base[] {this.collectiveName}; // StringType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 1375970320: /*contribution*/ return this.contribution == null ? new Base[0] : this.contribution.toArray(new Base[this.contribution.size()]); // CodeableConcept
        case -215129154: /*affiliationInfo*/ return this.affiliationInfo == null ? new Base[0] : this.affiliationInfo.toArray(new Base[this.affiliationInfo.size()]); // CitationContributorListContributorAffiliationInfoComponent
        case -1238918832: /*listOrder*/ return this.listOrder == null ? new Base[0] : new Base[] {this.listOrder}; // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1459599807: // lastName
          this.lastName = TypeConvertor.castToString(value); // StringType
          return value;
        case 466107751: // foreName
          this.foreName = TypeConvertor.castToString(value); // StringType
          return value;
        case -891422895: // suffix
          this.suffix = TypeConvertor.castToString(value); // StringType
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
        case 1375970320: // contribution
          this.getContribution().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -215129154: // affiliationInfo
          this.getAffiliationInfo().add((CitationContributorListContributorAffiliationInfoComponent) value); // CitationContributorListContributorAffiliationInfoComponent
          return value;
        case -1238918832: // listOrder
          this.listOrder = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("lastName")) {
          this.lastName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("foreName")) {
          this.foreName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("suffix")) {
          this.suffix = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("initials")) {
          this.initials = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("collectiveName")) {
          this.collectiveName = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("contribution")) {
          this.getContribution().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("affiliationInfo")) {
          this.getAffiliationInfo().add((CitationContributorListContributorAffiliationInfoComponent) value);
        } else if (name.equals("listOrder")) {
          this.listOrder = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1459599807:  return getLastNameElement();
        case 466107751:  return getForeNameElement();
        case -891422895:  return getSuffixElement();
        case 269062575:  return getInitialsElement();
        case 502871833:  return getCollectiveNameElement();
        case -1618432855:  return addIdentifier(); 
        case 1375970320:  return addContribution(); 
        case -215129154:  return addAffiliationInfo(); 
        case -1238918832:  return getListOrderElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1459599807: /*lastName*/ return new String[] {"string"};
        case 466107751: /*foreName*/ return new String[] {"string"};
        case -891422895: /*suffix*/ return new String[] {"string"};
        case 269062575: /*initials*/ return new String[] {"string"};
        case 502871833: /*collectiveName*/ return new String[] {"string"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 1375970320: /*contribution*/ return new String[] {"CodeableConcept"};
        case -215129154: /*affiliationInfo*/ return new String[] {};
        case -1238918832: /*listOrder*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("lastName")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorList.contributor.lastName");
        }
        else if (name.equals("foreName")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorList.contributor.foreName");
        }
        else if (name.equals("suffix")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorList.contributor.suffix");
        }
        else if (name.equals("initials")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorList.contributor.initials");
        }
        else if (name.equals("collectiveName")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorList.contributor.collectiveName");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("contribution")) {
          return addContribution();
        }
        else if (name.equals("affiliationInfo")) {
          return addAffiliationInfo();
        }
        else if (name.equals("listOrder")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorList.contributor.listOrder");
        }
        else
          return super.addChild(name);
      }

      public CitationContributorListContributorComponent copy() {
        CitationContributorListContributorComponent dst = new CitationContributorListContributorComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationContributorListContributorComponent dst) {
        super.copyValues(dst);
        dst.lastName = lastName == null ? null : lastName.copy();
        dst.foreName = foreName == null ? null : foreName.copy();
        dst.suffix = suffix == null ? null : suffix.copy();
        dst.initials = initials == null ? null : initials.copy();
        dst.collectiveName = collectiveName == null ? null : collectiveName.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (contribution != null) {
          dst.contribution = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : contribution)
            dst.contribution.add(i.copy());
        };
        if (affiliationInfo != null) {
          dst.affiliationInfo = new ArrayList<CitationContributorListContributorAffiliationInfoComponent>();
          for (CitationContributorListContributorAffiliationInfoComponent i : affiliationInfo)
            dst.affiliationInfo.add(i.copy());
        };
        dst.listOrder = listOrder == null ? null : listOrder.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CitationContributorListContributorComponent))
          return false;
        CitationContributorListContributorComponent o = (CitationContributorListContributorComponent) other_;
        return compareDeep(lastName, o.lastName, true) && compareDeep(foreName, o.foreName, true) && compareDeep(suffix, o.suffix, true)
           && compareDeep(initials, o.initials, true) && compareDeep(collectiveName, o.collectiveName, true)
           && compareDeep(identifier, o.identifier, true) && compareDeep(contribution, o.contribution, true)
           && compareDeep(affiliationInfo, o.affiliationInfo, true) && compareDeep(listOrder, o.listOrder, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationContributorListContributorComponent))
          return false;
        CitationContributorListContributorComponent o = (CitationContributorListContributorComponent) other_;
        return compareValues(lastName, o.lastName, true) && compareValues(foreName, o.foreName, true) && compareValues(suffix, o.suffix, true)
           && compareValues(initials, o.initials, true) && compareValues(collectiveName, o.collectiveName, true)
           && compareValues(listOrder, o.listOrder, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(lastName, foreName, suffix
          , initials, collectiveName, identifier, contribution, affiliationInfo, listOrder
          );
      }

  public String fhirType() {
    return "Citation.contributorList.contributor";

  }

  }

    @Block()
    public static class CitationContributorListContributorAffiliationInfoComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Display for the organization.
         */
        @Child(name = "affiliation", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Display for the organization", formalDefinition="Display for the organization." )
        protected StringType affiliation;

        /**
         * Role.
         */
        @Child(name = "role", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Role", formalDefinition="Role." )
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
      public CitationContributorListContributorAffiliationInfoComponent() {
        super();
      }

        /**
         * @return {@link #affiliation} (Display for the organization.). This is the underlying object with id, value and extensions. The accessor "getAffiliation" gives direct access to the value
         */
        public StringType getAffiliationElement() { 
          if (this.affiliation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorListContributorAffiliationInfoComponent.affiliation");
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
        public CitationContributorListContributorAffiliationInfoComponent setAffiliationElement(StringType value) { 
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
        public CitationContributorListContributorAffiliationInfoComponent setAffiliation(String value) { 
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
         * @return {@link #role} (Role.). This is the underlying object with id, value and extensions. The accessor "getRole" gives direct access to the value
         */
        public StringType getRoleElement() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationContributorListContributorAffiliationInfoComponent.role");
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
         * @param value {@link #role} (Role.). This is the underlying object with id, value and extensions. The accessor "getRole" gives direct access to the value
         */
        public CitationContributorListContributorAffiliationInfoComponent setRoleElement(StringType value) { 
          this.role = value;
          return this;
        }

        /**
         * @return Role.
         */
        public String getRole() { 
          return this.role == null ? null : this.role.getValue();
        }

        /**
         * @param value Role.
         */
        public CitationContributorListContributorAffiliationInfoComponent setRole(String value) { 
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
        public CitationContributorListContributorAffiliationInfoComponent setIdentifier(List<Identifier> theIdentifier) { 
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

        public CitationContributorListContributorAffiliationInfoComponent addIdentifier(Identifier t) { //3
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
          children.add(new Property("role", "string", "Role.", 0, 1, role));
          children.add(new Property("identifier", "Identifier", "Identifier for the organization.", 0, java.lang.Integer.MAX_VALUE, identifier));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 2019918576: /*affiliation*/  return new Property("affiliation", "string", "Display for the organization.", 0, 1, affiliation);
          case 3506294: /*role*/  return new Property("role", "string", "Role.", 0, 1, role);
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
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorList.contributor.affiliationInfo.affiliation");
        }
        else if (name.equals("role")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.contributorList.contributor.affiliationInfo.role");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else
          return super.addChild(name);
      }

      public CitationContributorListContributorAffiliationInfoComponent copy() {
        CitationContributorListContributorAffiliationInfoComponent dst = new CitationContributorListContributorAffiliationInfoComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CitationContributorListContributorAffiliationInfoComponent dst) {
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
        if (!(other_ instanceof CitationContributorListContributorAffiliationInfoComponent))
          return false;
        CitationContributorListContributorAffiliationInfoComponent o = (CitationContributorListContributorAffiliationInfoComponent) other_;
        return compareDeep(affiliation, o.affiliation, true) && compareDeep(role, o.role, true) && compareDeep(identifier, o.identifier, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CitationContributorListContributorAffiliationInfoComponent))
          return false;
        CitationContributorListContributorAffiliationInfoComponent o = (CitationContributorListContributorAffiliationInfoComponent) other_;
        return compareValues(affiliation, o.affiliation, true) && compareValues(role, o.role, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(affiliation, role, identifier
          );
      }

  public String fhirType() {
    return "Citation.contributorList.contributor.affiliationInfo";

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
         * Language in which the article is published.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Language in which the article is published", formalDefinition="Language in which the article is published." )
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

        private static final long serialVersionUID = -991805122L;

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
         * @return {@link #language} (Language in which the article is published.)
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
         * @param value {@link #language} (Language in which the article is published.)
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

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("publishingModel", "CodeableConcept", "Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.", 0, 1, publishingModel));
          children.add(new Property("language", "CodeableConcept", "Language in which the article is published.", 0, 1, language));
          children.add(new Property("journalIssue", "", "The specific issue in which the cited article resides.", 0, 1, journalIssue));
          children.add(new Property("pagination", "", "Indicates the inclusive pages for the article cited.", 0, 1, pagination));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 747318902: /*publishingModel*/  return new Property("publishingModel", "CodeableConcept", "Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.", 0, 1, publishingModel);
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "Language in which the article is published.", 0, 1, language);
          case -716835870: /*journalIssue*/  return new Property("journalIssue", "", "The specific issue in which the cited article resides.", 0, 1, journalIssue);
          case 1297692570: /*pagination*/  return new Property("pagination", "", "Indicates the inclusive pages for the article cited.", 0, 1, pagination);
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
          ;
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
          , journalIssue, pagination);
      }

  public String fhirType() {
    return "Citation.alternativeForm";

  }

  }

    @Block()
    public static class CitationAlternativeFormJournalIssueComponent extends BackboneElement implements IBaseBackboneElement {
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
        @Child(name = "publicationDate", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Date on which the issue of the journal was published", formalDefinition="Date on which the issue of the journal was published." )
        protected StringType publicationDate;

        private static final long serialVersionUID = -1343937439L;

    /**
     * Constructor
     */
      public CitationAlternativeFormJournalIssueComponent() {
        super();
      }

        /**
         * @return {@link #citedMedium} (NLM codes Internet or Print.)
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
         * @param value {@link #citedMedium} (NLM codes Internet or Print.)
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
         * @return {@link #publicationDate} (Date on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getPublicationDate" gives direct access to the value
         */
        public StringType getPublicationDateElement() { 
          if (this.publicationDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CitationAlternativeFormJournalIssueComponent.publicationDate");
            else if (Configuration.doAutoCreate())
              this.publicationDate = new StringType(); // bb
          return this.publicationDate;
        }

        public boolean hasPublicationDateElement() { 
          return this.publicationDate != null && !this.publicationDate.isEmpty();
        }

        public boolean hasPublicationDate() { 
          return this.publicationDate != null && !this.publicationDate.isEmpty();
        }

        /**
         * @param value {@link #publicationDate} (Date on which the issue of the journal was published.). This is the underlying object with id, value and extensions. The accessor "getPublicationDate" gives direct access to the value
         */
        public CitationAlternativeFormJournalIssueComponent setPublicationDateElement(StringType value) { 
          this.publicationDate = value;
          return this;
        }

        /**
         * @return Date on which the issue of the journal was published.
         */
        public String getPublicationDate() { 
          return this.publicationDate == null ? null : this.publicationDate.getValue();
        }

        /**
         * @param value Date on which the issue of the journal was published.
         */
        public CitationAlternativeFormJournalIssueComponent setPublicationDate(String value) { 
          if (Utilities.noString(value))
            this.publicationDate = null;
          else {
            if (this.publicationDate == null)
              this.publicationDate = new StringType();
            this.publicationDate.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("citedMedium", "CodeableConcept", "NLM codes Internet or Print.", 0, 1, citedMedium));
          children.add(new Property("volume", "string", "Volume number of journal in which the article is published.", 0, 1, volume));
          children.add(new Property("issue", "string", "Issue, part or supplement of journal in which the article is published.", 0, 1, issue));
          children.add(new Property("publicationDate", "string", "Date on which the issue of the journal was published.", 0, 1, publicationDate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 612116418: /*citedMedium*/  return new Property("citedMedium", "CodeableConcept", "NLM codes Internet or Print.", 0, 1, citedMedium);
          case -810883302: /*volume*/  return new Property("volume", "string", "Volume number of journal in which the article is published.", 0, 1, volume);
          case 100509913: /*issue*/  return new Property("issue", "string", "Issue, part or supplement of journal in which the article is published.", 0, 1, issue);
          case 1470566394: /*publicationDate*/  return new Property("publicationDate", "string", "Date on which the issue of the journal was published.", 0, 1, publicationDate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 612116418: /*citedMedium*/ return this.citedMedium == null ? new Base[0] : new Base[] {this.citedMedium}; // CodeableConcept
        case -810883302: /*volume*/ return this.volume == null ? new Base[0] : new Base[] {this.volume}; // StringType
        case 100509913: /*issue*/ return this.issue == null ? new Base[0] : new Base[] {this.issue}; // StringType
        case 1470566394: /*publicationDate*/ return this.publicationDate == null ? new Base[0] : new Base[] {this.publicationDate}; // StringType
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
          this.publicationDate = TypeConvertor.castToString(value); // StringType
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
          this.publicationDate = TypeConvertor.castToString(value); // StringType
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
        case 1470566394:  return getPublicationDateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 612116418: /*citedMedium*/ return new String[] {"CodeableConcept"};
        case -810883302: /*volume*/ return new String[] {"string"};
        case 100509913: /*issue*/ return new String[] {"string"};
        case 1470566394: /*publicationDate*/ return new String[] {"string"};
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
          throw new FHIRException("Cannot call addChild on a primitive type Citation.alternativeForm.journalIssue.publicationDate");
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
        return compareValues(volume, o.volume, true) && compareValues(issue, o.issue, true) && compareValues(publicationDate, o.publicationDate, true)
          ;
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
     * The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of this summary", formalDefinition="The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * The status of this summary. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this summary. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Use context", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances." )
    protected List<UsageContext> useContext;

    /**
     * A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance. May include DOI, PMID, PMCID, etc.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="May include DOI, PMID, PMCID, etc.", formalDefinition="A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance. May include DOI, PMID, PMCID, etc." )
    protected List<Identifier> identifier;

    /**
     * May include trial registry identifiers.
     */
    @Child(name = "relatedIdentifier", type = {Identifier.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="May include trial registry identifiers", formalDefinition="May include trial registry identifiers." )
    protected List<Identifier> relatedIdentifier;

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
     * Full title of the article.
     */
    @Child(name = "articleTitle", type = {MarkdownType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Full title of the article", formalDefinition="Full title of the article." )
    protected MarkdownType articleTitle;

    /**
     * Used for variant titles, such as translations.
     */
    @Child(name = "alternativeTitle", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for variant titles, such as translations", formalDefinition="Used for variant titles, such as translations." )
    protected List<CitationAlternativeTitleComponent> alternativeTitle;

    /**
     * Indicates the inclusive pages for the article cited.
     */
    @Child(name = "pagination", type = {}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Indicates the inclusive pages for the article cited", formalDefinition="Indicates the inclusive pages for the article cited." )
    protected CitationPaginationComponent pagination;

    /**
     * Used for any URL for the article cited.
     */
    @Child(name = "articleUrl", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for any URL for the article cited", formalDefinition="Used for any URL for the article cited." )
    protected List<CitationArticleUrlComponent> articleUrl;

    /**
     * Abstract text, may include structured labels.
     */
    @Child(name = "abstract", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Abstract text", formalDefinition="Abstract text, may include structured labels." )
    protected MarkdownType abstract_;

    /**
     * Copyright information for the abstract text.
     */
    @Child(name = "abstractCopyright", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Abstract copyright", formalDefinition="Copyright information for the abstract text." )
    protected MarkdownType abstractCopyright;

    /**
     * Used for variant abstracts, such as translations.
     */
    @Child(name = "alternativeAbstract", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for variant abstracts, such as translations", formalDefinition="Used for variant abstracts, such as translations." )
    protected List<CitationAlternativeAbstractComponent> alternativeAbstract;

    /**
     * Personal and collective author names.
     */
    @Child(name = "authorList", type = {}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Personal and collective author names", formalDefinition="Personal and collective author names." )
    protected CitationAuthorListComponent authorList;

    /**
     * Used to record a display of the author list without separate coding for each author.
     */
    @Child(name = "authorString", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used to record a display of the author list without separate coding for each author", formalDefinition="Used to record a display of the author list without separate coding for each author." )
    protected List<CitationAuthorStringComponent> authorString;

    /**
     * Personal and collective contributor names.
     */
    @Child(name = "contributorList", type = {}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Personal and collective contributor names", formalDefinition="Personal and collective contributor names." )
    protected CitationContributorListComponent contributorList;

    /**
     * The language in which the article is published.
     */
    @Child(name = "articleLanguage", type = {CodeableConcept.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The language in which the article is published", formalDefinition="The language in which the article is published." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/languages")
    protected CodeableConcept articleLanguage;

    /**
     * Used to represent alternative forms of the article that are not separate citations.
     */
    @Child(name = "alternativeForm", type = {}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used to represent alternative forms of the article that are not separate citations", formalDefinition="Used to represent alternative forms of the article that are not separate citations." )
    protected List<CitationAlternativeFormComponent> alternativeForm;

    /**
     * Used for many classifiers including PublicationType, CitationSubset, MeshHeading, Chemical.
     */
    @Child(name = "classifier", type = {CodeableConcept.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for many classifiers including PublicationType, CitationSubset, MeshHeading, Chemical", formalDefinition="Used for many classifiers including PublicationType, CitationSubset, MeshHeading, Chemical." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/citation-classifier")
    protected List<CodeableConcept> classifier;

    /**
     * Used for referencing EvidenceReport resource.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Link or citation to artifact associated with the summary", formalDefinition="Used for referencing EvidenceReport resource." )
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

    private static final long serialVersionUID = 1796797816L;

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
     * @return {@link #version} (The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.version");
        else if (Configuration.doAutoCreate())
          this.version = new StringType(); // bb
      return this.version;
    }

    public boolean hasVersionElement() { 
      return this.version != null && !this.version.isEmpty();
    }

    public boolean hasVersion() { 
      return this.version != null && !this.version.isEmpty();
    }

    /**
     * @param value {@link #version} (The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public Citation setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public Citation setVersion(String value) { 
      if (Utilities.noString(value))
        this.version = null;
      else {
        if (this.version == null)
          this.version = new StringType();
        this.version.setValue(value);
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
     * @return {@link #identifier} (A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance. May include DOI, PMID, PMCID, etc.)
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
     * @return {@link #relatedIdentifier} (May include trial registry identifiers.)
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
     * @return {@link #abstract_} (Abstract text, may include structured labels.). This is the underlying object with id, value and extensions. The accessor "getAbstract" gives direct access to the value
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
     * @param value {@link #abstract_} (Abstract text, may include structured labels.). This is the underlying object with id, value and extensions. The accessor "getAbstract" gives direct access to the value
     */
    public Citation setAbstractElement(MarkdownType value) { 
      this.abstract_ = value;
      return this;
    }

    /**
     * @return Abstract text, may include structured labels.
     */
    public String getAbstract() { 
      return this.abstract_ == null ? null : this.abstract_.getValue();
    }

    /**
     * @param value Abstract text, may include structured labels.
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
     * @return {@link #authorList} (Personal and collective author names.)
     */
    public CitationAuthorListComponent getAuthorList() { 
      if (this.authorList == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.authorList");
        else if (Configuration.doAutoCreate())
          this.authorList = new CitationAuthorListComponent(); // cc
      return this.authorList;
    }

    public boolean hasAuthorList() { 
      return this.authorList != null && !this.authorList.isEmpty();
    }

    /**
     * @param value {@link #authorList} (Personal and collective author names.)
     */
    public Citation setAuthorList(CitationAuthorListComponent value) { 
      this.authorList = value;
      return this;
    }

    /**
     * @return {@link #authorString} (Used to record a display of the author list without separate coding for each author.)
     */
    public List<CitationAuthorStringComponent> getAuthorString() { 
      if (this.authorString == null)
        this.authorString = new ArrayList<CitationAuthorStringComponent>();
      return this.authorString;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Citation setAuthorString(List<CitationAuthorStringComponent> theAuthorString) { 
      this.authorString = theAuthorString;
      return this;
    }

    public boolean hasAuthorString() { 
      if (this.authorString == null)
        return false;
      for (CitationAuthorStringComponent item : this.authorString)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CitationAuthorStringComponent addAuthorString() { //3
      CitationAuthorStringComponent t = new CitationAuthorStringComponent();
      if (this.authorString == null)
        this.authorString = new ArrayList<CitationAuthorStringComponent>();
      this.authorString.add(t);
      return t;
    }

    public Citation addAuthorString(CitationAuthorStringComponent t) { //3
      if (t == null)
        return this;
      if (this.authorString == null)
        this.authorString = new ArrayList<CitationAuthorStringComponent>();
      this.authorString.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #authorString}, creating it if it does not already exist {3}
     */
    public CitationAuthorStringComponent getAuthorStringFirstRep() { 
      if (getAuthorString().isEmpty()) {
        addAuthorString();
      }
      return getAuthorString().get(0);
    }

    /**
     * @return {@link #contributorList} (Personal and collective contributor names.)
     */
    public CitationContributorListComponent getContributorList() { 
      if (this.contributorList == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Citation.contributorList");
        else if (Configuration.doAutoCreate())
          this.contributorList = new CitationContributorListComponent(); // cc
      return this.contributorList;
    }

    public boolean hasContributorList() { 
      return this.contributorList != null && !this.contributorList.isEmpty();
    }

    /**
     * @param value {@link #contributorList} (Personal and collective contributor names.)
     */
    public Citation setContributorList(CitationContributorListComponent value) { 
      this.contributorList = value;
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
     * @return {@link #relatedArtifact} (Used for referencing EvidenceReport resource.)
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
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance. May include DOI, PMID, PMCID, etc.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("relatedIdentifier", "Identifier", "May include trial registry identifiers.", 0, java.lang.Integer.MAX_VALUE, relatedIdentifier));
        children.add(new Property("dateCited", "dateTime", "Date Cited.", 0, 1, dateCited));
        children.add(new Property("variantCitation", "", "Variant citation.", 0, 1, variantCitation));
        children.add(new Property("publishingModel", "CodeableConcept", "Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.", 0, 1, publishingModel));
        children.add(new Property("journal", "", "Contains identifiers and classifiers for the journal cited.", 0, 1, journal));
        children.add(new Property("articleTitle", "markdown", "Full title of the article.", 0, 1, articleTitle));
        children.add(new Property("alternativeTitle", "", "Used for variant titles, such as translations.", 0, java.lang.Integer.MAX_VALUE, alternativeTitle));
        children.add(new Property("pagination", "", "Indicates the inclusive pages for the article cited.", 0, 1, pagination));
        children.add(new Property("articleUrl", "", "Used for any URL for the article cited.", 0, java.lang.Integer.MAX_VALUE, articleUrl));
        children.add(new Property("abstract", "markdown", "Abstract text, may include structured labels.", 0, 1, abstract_));
        children.add(new Property("abstractCopyright", "markdown", "Copyright information for the abstract text.", 0, 1, abstractCopyright));
        children.add(new Property("alternativeAbstract", "", "Used for variant abstracts, such as translations.", 0, java.lang.Integer.MAX_VALUE, alternativeAbstract));
        children.add(new Property("authorList", "", "Personal and collective author names.", 0, 1, authorList));
        children.add(new Property("authorString", "", "Used to record a display of the author list without separate coding for each author.", 0, java.lang.Integer.MAX_VALUE, authorString));
        children.add(new Property("contributorList", "", "Personal and collective contributor names.", 0, 1, contributorList));
        children.add(new Property("articleLanguage", "CodeableConcept", "The language in which the article is published.", 0, 1, articleLanguage));
        children.add(new Property("alternativeForm", "", "Used to represent alternative forms of the article that are not separate citations.", 0, java.lang.Integer.MAX_VALUE, alternativeForm));
        children.add(new Property("classifier", "CodeableConcept", "Used for many classifiers including PublicationType, CitationSubset, MeshHeading, Chemical.", 0, java.lang.Integer.MAX_VALUE, classifier));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Used for referencing EvidenceReport resource.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
        children.add(new Property("note", "Annotation", "Used for general notes and annotations not coded elsewhere.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("medlinePubMed", "", "These elements are items with values assigned by MEDLINE or PubMed management.", 0, 1, medlinePubMed));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this citation when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.", 0, 1, url);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate citation instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance. May include DOI, PMID, PMCID, etc.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1007604940: /*relatedIdentifier*/  return new Property("relatedIdentifier", "Identifier", "May include trial registry identifiers.", 0, java.lang.Integer.MAX_VALUE, relatedIdentifier);
        case -275034401: /*dateCited*/  return new Property("dateCited", "dateTime", "Date Cited.", 0, 1, dateCited);
        case -1653134708: /*variantCitation*/  return new Property("variantCitation", "", "Variant citation.", 0, 1, variantCitation);
        case 747318902: /*publishingModel*/  return new Property("publishingModel", "CodeableConcept", "Identify the medium/media in which the cited article is published, eg print, electronic or print-electronic.", 0, 1, publishingModel);
        case -1419464905: /*journal*/  return new Property("journal", "", "Contains identifiers and classifiers for the journal cited.", 0, 1, journal);
        case -404746494: /*articleTitle*/  return new Property("articleTitle", "markdown", "Full title of the article.", 0, 1, articleTitle);
        case -1478308181: /*alternativeTitle*/  return new Property("alternativeTitle", "", "Used for variant titles, such as translations.", 0, java.lang.Integer.MAX_VALUE, alternativeTitle);
        case 1297692570: /*pagination*/  return new Property("pagination", "", "Indicates the inclusive pages for the article cited.", 0, 1, pagination);
        case 164943001: /*articleUrl*/  return new Property("articleUrl", "", "Used for any URL for the article cited.", 0, java.lang.Integer.MAX_VALUE, articleUrl);
        case 1732898850: /*abstract*/  return new Property("abstract", "markdown", "Abstract text, may include structured labels.", 0, 1, abstract_);
        case -656627259: /*abstractCopyright*/  return new Property("abstractCopyright", "markdown", "Copyright information for the abstract text.", 0, 1, abstractCopyright);
        case -376340753: /*alternativeAbstract*/  return new Property("alternativeAbstract", "", "Used for variant abstracts, such as translations.", 0, java.lang.Integer.MAX_VALUE, alternativeAbstract);
        case -1501591351: /*authorList*/  return new Property("authorList", "", "Personal and collective author names.", 0, 1, authorList);
        case 290249084: /*authorString*/  return new Property("authorString", "", "Used to record a display of the author list without separate coding for each author.", 0, java.lang.Integer.MAX_VALUE, authorString);
        case 537567257: /*contributorList*/  return new Property("contributorList", "", "Personal and collective contributor names.", 0, 1, contributorList);
        case -1573097874: /*articleLanguage*/  return new Property("articleLanguage", "CodeableConcept", "The language in which the article is published.", 0, 1, articleLanguage);
        case 2030111249: /*alternativeForm*/  return new Property("alternativeForm", "", "Used to represent alternative forms of the article that are not separate citations.", 0, java.lang.Integer.MAX_VALUE, alternativeForm);
        case -281470431: /*classifier*/  return new Property("classifier", "CodeableConcept", "Used for many classifiers including PublicationType, CitationSubset, MeshHeading, Chemical.", 0, java.lang.Integer.MAX_VALUE, classifier);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Used for referencing EvidenceReport resource.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Used for general notes and annotations not coded elsewhere.", 0, java.lang.Integer.MAX_VALUE, note);
        case -1342445201: /*medlinePubMed*/  return new Property("medlinePubMed", "", "These elements are items with values assigned by MEDLINE or PubMed management.", 0, 1, medlinePubMed);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1007604940: /*relatedIdentifier*/ return this.relatedIdentifier == null ? new Base[0] : this.relatedIdentifier.toArray(new Base[this.relatedIdentifier.size()]); // Identifier
        case -275034401: /*dateCited*/ return this.dateCited == null ? new Base[0] : new Base[] {this.dateCited}; // DateTimeType
        case -1653134708: /*variantCitation*/ return this.variantCitation == null ? new Base[0] : new Base[] {this.variantCitation}; // CitationVariantCitationComponent
        case 747318902: /*publishingModel*/ return this.publishingModel == null ? new Base[0] : new Base[] {this.publishingModel}; // CodeableConcept
        case -1419464905: /*journal*/ return this.journal == null ? new Base[0] : new Base[] {this.journal}; // CitationJournalComponent
        case -404746494: /*articleTitle*/ return this.articleTitle == null ? new Base[0] : new Base[] {this.articleTitle}; // MarkdownType
        case -1478308181: /*alternativeTitle*/ return this.alternativeTitle == null ? new Base[0] : this.alternativeTitle.toArray(new Base[this.alternativeTitle.size()]); // CitationAlternativeTitleComponent
        case 1297692570: /*pagination*/ return this.pagination == null ? new Base[0] : new Base[] {this.pagination}; // CitationPaginationComponent
        case 164943001: /*articleUrl*/ return this.articleUrl == null ? new Base[0] : this.articleUrl.toArray(new Base[this.articleUrl.size()]); // CitationArticleUrlComponent
        case 1732898850: /*abstract*/ return this.abstract_ == null ? new Base[0] : new Base[] {this.abstract_}; // MarkdownType
        case -656627259: /*abstractCopyright*/ return this.abstractCopyright == null ? new Base[0] : new Base[] {this.abstractCopyright}; // MarkdownType
        case -376340753: /*alternativeAbstract*/ return this.alternativeAbstract == null ? new Base[0] : this.alternativeAbstract.toArray(new Base[this.alternativeAbstract.size()]); // CitationAlternativeAbstractComponent
        case -1501591351: /*authorList*/ return this.authorList == null ? new Base[0] : new Base[] {this.authorList}; // CitationAuthorListComponent
        case 290249084: /*authorString*/ return this.authorString == null ? new Base[0] : this.authorString.toArray(new Base[this.authorString.size()]); // CitationAuthorStringComponent
        case 537567257: /*contributorList*/ return this.contributorList == null ? new Base[0] : new Base[] {this.contributorList}; // CitationContributorListComponent
        case -1573097874: /*articleLanguage*/ return this.articleLanguage == null ? new Base[0] : new Base[] {this.articleLanguage}; // CodeableConcept
        case 2030111249: /*alternativeForm*/ return this.alternativeForm == null ? new Base[0] : this.alternativeForm.toArray(new Base[this.alternativeForm.size()]); // CitationAlternativeFormComponent
        case -281470431: /*classifier*/ return this.classifier == null ? new Base[0] : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
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
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
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
        case -1501591351: // authorList
          this.authorList = (CitationAuthorListComponent) value; // CitationAuthorListComponent
          return value;
        case 290249084: // authorString
          this.getAuthorString().add((CitationAuthorStringComponent) value); // CitationAuthorStringComponent
          return value;
        case 537567257: // contributorList
          this.contributorList = (CitationContributorListComponent) value; // CitationContributorListComponent
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
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("relatedIdentifier")) {
          this.getRelatedIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("dateCited")) {
          this.dateCited = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("variantCitation")) {
          this.variantCitation = (CitationVariantCitationComponent) value; // CitationVariantCitationComponent
        } else if (name.equals("publishingModel")) {
          this.publishingModel = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("journal")) {
          this.journal = (CitationJournalComponent) value; // CitationJournalComponent
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
        } else if (name.equals("authorList")) {
          this.authorList = (CitationAuthorListComponent) value; // CitationAuthorListComponent
        } else if (name.equals("authorString")) {
          this.getAuthorString().add((CitationAuthorStringComponent) value);
        } else if (name.equals("contributorList")) {
          this.contributorList = (CitationContributorListComponent) value; // CitationContributorListComponent
        } else if (name.equals("articleLanguage")) {
          this.articleLanguage = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("alternativeForm")) {
          this.getAlternativeForm().add((CitationAlternativeFormComponent) value);
        } else if (name.equals("classifier")) {
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value));
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
        case 351608024:  return getVersionElement();
        case -892481550:  return getStatusElement();
        case -669707736:  return addUseContext(); 
        case -1618432855:  return addIdentifier(); 
        case -1007604940:  return addRelatedIdentifier(); 
        case -275034401:  return getDateCitedElement();
        case -1653134708:  return getVariantCitation();
        case 747318902:  return getPublishingModel();
        case -1419464905:  return getJournal();
        case -404746494:  return getArticleTitleElement();
        case -1478308181:  return addAlternativeTitle(); 
        case 1297692570:  return getPagination();
        case 164943001:  return addArticleUrl(); 
        case 1732898850:  return getAbstractElement();
        case -656627259:  return getAbstractCopyrightElement();
        case -376340753:  return addAlternativeAbstract(); 
        case -1501591351:  return getAuthorList();
        case 290249084:  return addAuthorString(); 
        case 537567257:  return getContributorList();
        case -1573097874:  return getArticleLanguage();
        case 2030111249:  return addAlternativeForm(); 
        case -281470431:  return addClassifier(); 
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
        case 351608024: /*version*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1007604940: /*relatedIdentifier*/ return new String[] {"Identifier"};
        case -275034401: /*dateCited*/ return new String[] {"dateTime"};
        case -1653134708: /*variantCitation*/ return new String[] {};
        case 747318902: /*publishingModel*/ return new String[] {"CodeableConcept"};
        case -1419464905: /*journal*/ return new String[] {};
        case -404746494: /*articleTitle*/ return new String[] {"markdown"};
        case -1478308181: /*alternativeTitle*/ return new String[] {};
        case 1297692570: /*pagination*/ return new String[] {};
        case 164943001: /*articleUrl*/ return new String[] {};
        case 1732898850: /*abstract*/ return new String[] {"markdown"};
        case -656627259: /*abstractCopyright*/ return new String[] {"markdown"};
        case -376340753: /*alternativeAbstract*/ return new String[] {};
        case -1501591351: /*authorList*/ return new String[] {};
        case 290249084: /*authorString*/ return new String[] {};
        case 537567257: /*contributorList*/ return new String[] {};
        case -1573097874: /*articleLanguage*/ return new String[] {"CodeableConcept"};
        case 2030111249: /*alternativeForm*/ return new String[] {};
        case -281470431: /*classifier*/ return new String[] {"CodeableConcept"};
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
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type Citation.version");
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
        else if (name.equals("authorList")) {
          this.authorList = new CitationAuthorListComponent();
          return this.authorList;
        }
        else if (name.equals("authorString")) {
          return addAuthorString();
        }
        else if (name.equals("contributorList")) {
          this.contributorList = new CitationContributorListComponent();
          return this.contributorList;
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
        dst.version = version == null ? null : version.copy();
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
        dst.dateCited = dateCited == null ? null : dateCited.copy();
        dst.variantCitation = variantCitation == null ? null : variantCitation.copy();
        dst.publishingModel = publishingModel == null ? null : publishingModel.copy();
        dst.journal = journal == null ? null : journal.copy();
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
        dst.authorList = authorList == null ? null : authorList.copy();
        if (authorString != null) {
          dst.authorString = new ArrayList<CitationAuthorStringComponent>();
          for (CitationAuthorStringComponent i : authorString)
            dst.authorString.add(i.copy());
        };
        dst.contributorList = contributorList == null ? null : contributorList.copy();
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
        return compareDeep(url, o.url, true) && compareDeep(version, o.version, true) && compareDeep(status, o.status, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(identifier, o.identifier, true) && compareDeep(relatedIdentifier, o.relatedIdentifier, true)
           && compareDeep(dateCited, o.dateCited, true) && compareDeep(variantCitation, o.variantCitation, true)
           && compareDeep(publishingModel, o.publishingModel, true) && compareDeep(journal, o.journal, true)
           && compareDeep(articleTitle, o.articleTitle, true) && compareDeep(alternativeTitle, o.alternativeTitle, true)
           && compareDeep(pagination, o.pagination, true) && compareDeep(articleUrl, o.articleUrl, true) && compareDeep(abstract_, o.abstract_, true)
           && compareDeep(abstractCopyright, o.abstractCopyright, true) && compareDeep(alternativeAbstract, o.alternativeAbstract, true)
           && compareDeep(authorList, o.authorList, true) && compareDeep(authorString, o.authorString, true)
           && compareDeep(contributorList, o.contributorList, true) && compareDeep(articleLanguage, o.articleLanguage, true)
           && compareDeep(alternativeForm, o.alternativeForm, true) && compareDeep(classifier, o.classifier, true)
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
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(status, o.status, true)
           && compareValues(dateCited, o.dateCited, true) && compareValues(articleTitle, o.articleTitle, true)
           && compareValues(abstract_, o.abstract_, true) && compareValues(abstractCopyright, o.abstractCopyright, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, version, status, useContext
          , identifier, relatedIdentifier, dateCited, variantCitation, publishingModel, journal
          , articleTitle, alternativeTitle, pagination, articleUrl, abstract_, abstractCopyright
          , alternativeAbstract, authorList, authorString, contributorList, articleLanguage
          , alternativeForm, classifier, relatedArtifact, note, medlinePubMed);
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

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version of the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="Citation.version", description="The business version of the citation", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version of the citation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Citation.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);


}