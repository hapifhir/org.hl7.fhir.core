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
 * Content of one version in a VERSIONED_COMPOSITION. A Composition is considered the unit of modification of the record, the unit of transmission in record Extracts, and the unit of attestation by authorising clinicians. In this latter sense, it may be considered equivalent to a signed document. NOTE: It is strongly recommended that the inherited attribute uid be populated in Compositions, using the UID copied from the object_id() of the uid field of the enclosing VERSION object. For example, the ORIGINAL_VERSION.uid 87284370-2D4B-4e3d-A3F3-F303D2F4F34B::uk.nhs.ehr1::2 would be copied to the uid field of the Composition.
 */
@DatatypeDef(name="COMPOSITION")
public class COMPOSITION extends LOCATABLE implements ICompositeType {

    /**
     * Mandatory indicator of the localised language in which this Composition is written. Coded from openEHR Code Set languages. The language of an Entry if different from the Composition is indicated in ENTRY.language.
     */
    @Child(name = "language", type = {CODE_PHRASE.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Mandatory indicator of the localised language in which this Composition is written. Coded from openEHR Code Set languages", formalDefinition="Mandatory indicator of the localised language in which this Composition is written. Coded from openEHR Code Set languages. The language of an Entry if different from the Composition is indicated in ENTRY.language." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/all-languages")
    protected CODE_PHRASE language;

    /**
     * Name of territory in which this Composition was written. Coded from openEHR countries code set, which is an expression of the ISO 3166 standard.
     */
    @Child(name = "territory", type = {CODE_PHRASE.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Name of territory in which this Composition was written. Coded from the ISO 3166 standard", formalDefinition="Name of territory in which this Composition was written. Coded from openEHR countries code set, which is an expression of the ISO 3166 standard." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-territories")
    protected CODE_PHRASE territory;

    /**
     * Temporal category of this Composition, i.e.

* 431|persistent| - of potential life-time validity;* 451|episodic| - valid over the life of a care episode;* 433|event| - valid at the time of recording (long-term validity requires subsequent clinical assessment).

or any other code defined in the openEHR terminology group 'category'.
     */
    @Child(name = "category", type = {DV_CODED_TEXT.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Temporal category of this Composition, e.g. * 431|persistent|, 451|episodic|, or 433|event|", formalDefinition="Temporal category of this Composition, i.e.\r\n\r\n* 431|persistent| - of potential life-time validity;* 451|episodic| - valid over the life of a care episode;* 433|event| - valid at the time of recording (long-term validity requires subsequent clinical assessment).\r\n\r\nor any other code defined in the openEHR terminology group 'category'." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-composition_category")
    protected DV_CODED_TEXT category;

    /**
     * The clinical session context of this Composition, i.e. the contextual attributes of the clinical session.
     */
    @Child(name = "context", type = {EVENT_CONTEXT.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The clinical session context of this Composition, i.e. the contextual attributes of the clinical session", formalDefinition="The clinical session context of this Composition, i.e. the contextual attributes of the clinical session." )
    protected EVENT_CONTEXT context;

    /**
     * The person primarily responsible for the content of the Composition (but not necessarily its committal into the EHR system). This is the identifier which should appear on the screen. It may or may not be the person who entered the data. When it is the patient, the special self instance of PARTY_PROXY will be used.
     */
    @Child(name = "composer", type = {PARTY_PROXY.class}, order=4, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The person primarily responsible for the content of the Composition. This is the identifier which should appear on the screen", formalDefinition="The person primarily responsible for the content of the Composition (but not necessarily its committal into the EHR system). This is the identifier which should appear on the screen. It may or may not be the person who entered the data. When it is the patient, the special self instance of PARTY_PROXY will be used." )
    protected PARTY_PROXY composer;

    /**
     * The content of this Composition.
     */
    @Child(name = "content", type = {CONTENT_ITEM.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The content of this Composition", formalDefinition="The content of this Composition." )
    protected List<CONTENT_ITEM> contentList;

    private static final long serialVersionUID = -520355958L;

  /**
   * Constructor
   */
    public COMPOSITION() {
      super();
    }

  /**
   * Constructor
   */
    public COMPOSITION(CODE_PHRASE language, CODE_PHRASE territory, DV_CODED_TEXT category, PARTY_PROXY composer) {
      super();
      this.setLanguage(language);
      this.setTerritory(territory);
      this.setCategory(category);
      this.setComposer(composer);
    }

    /**
     * @return {@link #language} (Mandatory indicator of the localised language in which this Composition is written. Coded from openEHR Code Set languages. The language of an Entry if different from the Composition is indicated in ENTRY.language.)
     */
    public CODE_PHRASE getLanguage() { 
      if (this.language == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create COMPOSITION.language");
        else if (Configuration.doAutoCreate())
          this.language = new CODE_PHRASE(); // cc
      return this.language;
    }

    public boolean hasLanguage() { 
      return this.language != null && !this.language.isEmpty();
    }

    /**
     * @param value {@link #language} (Mandatory indicator of the localised language in which this Composition is written. Coded from openEHR Code Set languages. The language of an Entry if different from the Composition is indicated in ENTRY.language.)
     */
    public COMPOSITION setLanguage(CODE_PHRASE value) { 
      this.language = value;
      return this;
    }

    /**
     * @return {@link #territory} (Name of territory in which this Composition was written. Coded from openEHR countries code set, which is an expression of the ISO 3166 standard.)
     */
    public CODE_PHRASE getTerritory() { 
      if (this.territory == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create COMPOSITION.territory");
        else if (Configuration.doAutoCreate())
          this.territory = new CODE_PHRASE(); // cc
      return this.territory;
    }

    public boolean hasTerritory() { 
      return this.territory != null && !this.territory.isEmpty();
    }

    /**
     * @param value {@link #territory} (Name of territory in which this Composition was written. Coded from openEHR countries code set, which is an expression of the ISO 3166 standard.)
     */
    public COMPOSITION setTerritory(CODE_PHRASE value) { 
      this.territory = value;
      return this;
    }

    /**
     * @return {@link #category} (Temporal category of this Composition, i.e.

* 431|persistent| - of potential life-time validity;* 451|episodic| - valid over the life of a care episode;* 433|event| - valid at the time of recording (long-term validity requires subsequent clinical assessment).

or any other code defined in the openEHR terminology group 'category'.)
     */
    public DV_CODED_TEXT getCategory() { 
      if (this.category == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create COMPOSITION.category");
        else if (Configuration.doAutoCreate())
          this.category = new DV_CODED_TEXT(); // cc
      return this.category;
    }

    public boolean hasCategory() { 
      return this.category != null && !this.category.isEmpty();
    }

    /**
     * @param value {@link #category} (Temporal category of this Composition, i.e.

* 431|persistent| - of potential life-time validity;* 451|episodic| - valid over the life of a care episode;* 433|event| - valid at the time of recording (long-term validity requires subsequent clinical assessment).

or any other code defined in the openEHR terminology group 'category'.)
     */
    public COMPOSITION setCategory(DV_CODED_TEXT value) { 
      this.category = value;
      return this;
    }

    /**
     * @return {@link #context} (The clinical session context of this Composition, i.e. the contextual attributes of the clinical session.)
     */
    public EVENT_CONTEXT getContext() { 
      if (this.context == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create COMPOSITION.context");
        else if (Configuration.doAutoCreate())
          this.context = new EVENT_CONTEXT(); // cc
      return this.context;
    }

    public boolean hasContext() { 
      return this.context != null && !this.context.isEmpty();
    }

    /**
     * @param value {@link #context} (The clinical session context of this Composition, i.e. the contextual attributes of the clinical session.)
     */
    public COMPOSITION setContext(EVENT_CONTEXT value) { 
      this.context = value;
      return this;
    }

    /**
     * @return {@link #composer} (The person primarily responsible for the content of the Composition (but not necessarily its committal into the EHR system). This is the identifier which should appear on the screen. It may or may not be the person who entered the data. When it is the patient, the special self instance of PARTY_PROXY will be used.)
     */
    public PARTY_PROXY getComposer() { 
      return this.composer;
    }

    public boolean hasComposer() { 
      return this.composer != null && !this.composer.isEmpty();
    }

    /**
     * @param value {@link #composer} (The person primarily responsible for the content of the Composition (but not necessarily its committal into the EHR system). This is the identifier which should appear on the screen. It may or may not be the person who entered the data. When it is the patient, the special self instance of PARTY_PROXY will be used.)
     */
    public COMPOSITION setComposer(PARTY_PROXY value) { 
      this.composer = value;
      return this;
    }

    /**
     * @return {@link #content} (The content of this Composition.)
     */
    public List<CONTENT_ITEM> getContentList() { 
      if (this.contentList == null)
        this.contentList = new ArrayList<CONTENT_ITEM>();
      return this.contentList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public COMPOSITION setContentList(List<CONTENT_ITEM> theContent) { 
      this.contentList = theContent;
      return this;
    }

    public boolean hasContent() { 
      if (this.contentList == null)
        return false;
      for (CONTENT_ITEM item : this.contentList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public COMPOSITION addContent(CONTENT_ITEM t) { //3b
      if (t == null)
        return this;
      if (this.contentList == null)
        this.contentList = new ArrayList<CONTENT_ITEM>();
      this.contentList.add(t);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Mandatory indicator of the localised language in which this Composition is written. Coded from openEHR Code Set languages. The language of an Entry if different from the Composition is indicated in ENTRY.language.", 0, 1, language));
        children.add(new Property("territory", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Name of territory in which this Composition was written. Coded from openEHR countries code set, which is an expression of the ISO 3166 standard.", 0, 1, territory));
        children.add(new Property("category", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Temporal category of this Composition, i.e.\r\n\r\n* 431|persistent| - of potential life-time validity;* 451|episodic| - valid over the life of a care episode;* 433|event| - valid at the time of recording (long-term validity requires subsequent clinical assessment).\r\n\r\nor any other code defined in the openEHR terminology group 'category'.", 0, 1, category));
        children.add(new Property("context", "http://openehr.org/fhir/StructureDefinition/EVENT-CONTEXT", "The clinical session context of this Composition, i.e. the contextual attributes of the clinical session.", 0, 1, context));
        children.add(new Property("composer", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "The person primarily responsible for the content of the Composition (but not necessarily its committal into the EHR system). This is the identifier which should appear on the screen. It may or may not be the person who entered the data. When it is the patient, the special self instance of PARTY_PROXY will be used.", 0, 1, composer));
        children.add(new Property("content", "http://openehr.org/fhir/StructureDefinition/CONTENT-ITEM", "The content of this Composition.", 0, java.lang.Integer.MAX_VALUE, contentList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1613589672: /*language*/  return new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Mandatory indicator of the localised language in which this Composition is written. Coded from openEHR Code Set languages. The language of an Entry if different from the Composition is indicated in ENTRY.language.", 0, 1, language);
        case -2115639270: /*territory*/  return new Property("territory", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Name of territory in which this Composition was written. Coded from openEHR countries code set, which is an expression of the ISO 3166 standard.", 0, 1, territory);
        case 50511102: /*category*/  return new Property("category", "http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT", "Temporal category of this Composition, i.e.\r\n\r\n* 431|persistent| - of potential life-time validity;* 451|episodic| - valid over the life of a care episode;* 433|event| - valid at the time of recording (long-term validity requires subsequent clinical assessment).\r\n\r\nor any other code defined in the openEHR terminology group 'category'.", 0, 1, category);
        case 951530927: /*context*/  return new Property("context", "http://openehr.org/fhir/StructureDefinition/EVENT-CONTEXT", "The clinical session context of this Composition, i.e. the contextual attributes of the clinical session.", 0, 1, context);
        case -599342816: /*composer*/  return new Property("composer", "http://openehr.org/fhir/StructureDefinition/PARTY-PROXY", "The person primarily responsible for the content of the Composition (but not necessarily its committal into the EHR system). This is the identifier which should appear on the screen. It may or may not be the person who entered the data. When it is the patient, the special self instance of PARTY_PROXY will be used.", 0, 1, composer);
        case 951530617: /*content*/  return new Property("content", "http://openehr.org/fhir/StructureDefinition/CONTENT-ITEM", "The content of this Composition.", 0, java.lang.Integer.MAX_VALUE, contentList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CODE_PHRASE
        case -2115639270: /*territory*/ return this.territory == null ? new Base[0] : new Base[] {this.territory}; // CODE_PHRASE
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // DV_CODED_TEXT
        case 951530927: /*context*/ return this.context == null ? new Base[0] : new Base[] {this.context}; // EVENT_CONTEXT
        case -599342816: /*composer*/ return this.composer == null ? new Base[0] : new Base[] {this.composer}; // PARTY_PROXY
        case 951530617: /*content*/ return this.contentList == null ? new Base[0] : this.contentList.toArray(new Base[this.contentList.size()]); // CONTENT_ITEM
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1613589672: // language
          this.language = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case -2115639270: // territory
          this.territory = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case 50511102: // category
          this.category = (DV_CODED_TEXT) value; // DV_CODED_TEXT
          return value;
        case 951530927: // context
          this.context = (EVENT_CONTEXT) value; // EVENT_CONTEXT
          return value;
        case -599342816: // composer
          this.composer = (PARTY_PROXY) value; // PARTY_PROXY
          return value;
        case 951530617: // content
          this.getContentList().add((CONTENT_ITEM) value); // CONTENT_ITEM
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("language")) {
          this.language = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("territory")) {
          this.territory = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("category")) {
          this.category = (DV_CODED_TEXT) value; // DV_CODED_TEXT
        } else if (name.equals("context")) {
          this.context = (EVENT_CONTEXT) value; // EVENT_CONTEXT
        } else if (name.equals("composer")) {
          this.composer = (PARTY_PROXY) value; // PARTY_PROXY
        } else if (name.equals("content")) {
          this.getContentList().add((CONTENT_ITEM) value); // CONTENT_ITEM
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672:  return getLanguage();
        case -2115639270:  return getTerritory();
        case 50511102:  return getCategory();
        case 951530927:  return getContext();
        case -599342816: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'composer'");
        case 951530617: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'content'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case -2115639270: /*territory*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case 50511102: /*category*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-CODED-TEXT"};
        case 951530927: /*context*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/EVENT-CONTEXT"};
        case -599342816: /*composer*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/PARTY-PROXY"};
        case 951530617: /*content*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CONTENT-ITEM"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("language")) {
          this.language = new CODE_PHRASE();
          return this.language;
        }
        else if (name.equals("territory")) {
          this.territory = new CODE_PHRASE();
          return this.territory;
        }
        else if (name.equals("category")) {
          this.category = new DV_CODED_TEXT();
          return this.category;
        }
        else if (name.equals("context")) {
          this.context = new EVENT_CONTEXT();
          return this.context;
        }
        else if (name.equals("composer")) {
          throw new FHIRException("Cannot call addChild on an abstract type COMPOSITION.composer");
        }
        else if (name.equals("content")) {
          throw new FHIRException("Cannot call addChild on an abstract type COMPOSITION.content");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "COMPOSITION";

  }

      public COMPOSITION copy() {
        COMPOSITION dst = new COMPOSITION();
        copyValues(dst);
        return dst;
      }

      public void copyValues(COMPOSITION dst) {
        super.copyValues(dst);
        dst.language = language == null ? null : language.copy();
        dst.territory = territory == null ? null : territory.copy();
        dst.category = category == null ? null : category.copy();
        dst.context = context == null ? null : context.copy();
        dst.composer = composer == null ? null : composer.copy();
        if (contentList != null) {
          dst.contentList = new ArrayList<CONTENT_ITEM>();
          for (CONTENT_ITEM i : contentList)
            dst.contentList.add(i.copy());
        };
      }

      protected COMPOSITION typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof COMPOSITION))
          return false;
        COMPOSITION o = (COMPOSITION) other_;
        return compareDeep(language, o.language, true) && compareDeep(territory, o.territory, true) && compareDeep(category, o.category, true)
           && compareDeep(context, o.context, true) && compareDeep(composer, o.composer, true) && compareDeep(contentList, o.contentList, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof COMPOSITION))
          return false;
        COMPOSITION o = (COMPOSITION) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(language, territory, category
          , context, composer, contentList);
      }


}

