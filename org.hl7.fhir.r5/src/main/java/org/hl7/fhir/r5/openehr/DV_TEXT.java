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
 * A text item, which may contain any amount of legal characters arranged as e.g. words, sentences etc (i.e. one DV_TEXT may be more than one word). Visual formatting and hyperlinks may be included via markdown.
 */
@DatatypeDef(name="DV_TEXT")
public class DV_TEXT extends DATA_VALUE implements ICompositeType {

    /**
     * Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.
     */
    @Child(name = "value", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Displayable rendition of the item, regardless of its underlying structure", formalDefinition="Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service." )
    protected StringType value;

    /**
     * DEPRECATED: this field is deprecated; use markdown link/text in the value attribute, and 'markdown' as the value of the formatting field.
     */
    @Child(name = "hyperlink", type = {DV_URI.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="DEPRECATED: this field is deprecated; use markdown", formalDefinition="DEPRECATED: this field is deprecated; use markdown link/text in the value attribute, and 'markdown' as the value of the formatting field." )
    protected DV_URI hyperlink;

    /**
     * If set, contains one of the following values:

'plain': use for plain text, possibly containing newlines, but otherwise unformatted (same as Void);
* 'plain_no_newlines': use for text containing no newlines or other formatting;
* 'markdown': use for markdown formatted text, strongly recommended in the format of the CommonMark specification.

DEPRECATED usage: contains a string of the form ```'name:value; name:value…​'``` , e.g. ```'font-weight : bold; font-family : Arial; font-size : 12pt;'```. Values taken from W3C CSS2 properties lists for background and font
     */
    @Child(name = "formatting", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="plain | plain_no_newlines | markdown", formalDefinition="If set, contains one of the following values:\n\n'plain': use for plain text, possibly containing newlines, but otherwise unformatted (same as Void);\n* 'plain_no_newlines': use for text containing no newlines or other formatting;\n* 'markdown': use for markdown formatted text, strongly recommended in the format of the CommonMark specification.\n\nDEPRECATED usage: contains a string of the form ```'name:value; name:value…​'``` , e.g. ```'font-weight : bold; font-family : Arial; font-size : 12pt;'```. Values taken from W3C CSS2 properties lists for background and font" )
    protected StringType formatting;

    /**
     * Terms from other terminologies most closely matching this term, typically used where the originator (e.g. pathology lab) of information uses a local terminology but also supplies one or more equivalents from well known terminologies (e.g. LOINC).
     */
    @Child(name = "mappings", type = {TERM_MAPPING.class}, order=3, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Terms from other terminologies most closely matching this term", formalDefinition="Terms from other terminologies most closely matching this term, typically used where the originator (e.g. pathology lab) of information uses a local terminology but also supplies one or more equivalents from well known terminologies (e.g. LOINC)." )
    protected List<TERM_MAPPING> mappingsList;

    /**
     * Optional indicator of the localised language in which the value is written. Coded from openEHR Code Set languages . Only used when either the text object is in a different language from the enclosing ENTRY, or else the text object is being used outside of an ENTRY or other enclosing structure which indicates the language.
     */
    @Child(name = "language", type = {CODE_PHRASE.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional indicator of the localised language in which the value is written", formalDefinition="Optional indicator of the localised language in which the value is written. Coded from openEHR Code Set languages . Only used when either the text object is in a different language from the enclosing ENTRY, or else the text object is being used outside of an ENTRY or other enclosing structure which indicates the language." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/all-languages")
    protected CODE_PHRASE language;

    /**
     * Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions.
     */
    @Child(name = "encoding", type = {CODE_PHRASE.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Name of character encoding scheme in which this value is encoded", formalDefinition="Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-character_sets")
    protected CODE_PHRASE encoding;

    private static final long serialVersionUID = 1126979256L;

  /**
   * Constructor
   */
    public DV_TEXT() {
      super();
    }

  /**
   * Constructor
   */
    public DV_TEXT(String value, TERM_MAPPING mappings) {
      super();
      this.setValue(value);
      this.addMappings(mappings);
    }

    /**
     * @return {@link #value} (Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public StringType getValueElement() { 
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_TEXT.value");
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
     * @param value {@link #value} (Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
     */
    public DV_TEXT setValueElement(StringType value) { 
      this.value = value;
      return this;
    }

    /**
     * @return Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.
     */
    public String getValue() { 
      return this.value == null ? null : this.value.getValue();
    }

    /**
     * @param value Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.
     */
    public DV_TEXT setValue(String value) { 
        if (this.value == null)
          this.value = new StringType();
        this.value.setValue(value);
      return this;
    }

    /**
     * @return {@link #hyperlink} (DEPRECATED: this field is deprecated; use markdown link/text in the value attribute, and 'markdown' as the value of the formatting field.)
     */
    public DV_URI getHyperlink() { 
      if (this.hyperlink == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_TEXT.hyperlink");
        else if (Configuration.doAutoCreate())
          this.hyperlink = new DV_URI(); // cc
      return this.hyperlink;
    }

    public boolean hasHyperlink() { 
      return this.hyperlink != null && !this.hyperlink.isEmpty();
    }

    /**
     * @param value {@link #hyperlink} (DEPRECATED: this field is deprecated; use markdown link/text in the value attribute, and 'markdown' as the value of the formatting field.)
     */
    public DV_TEXT setHyperlink(DV_URI value) { 
      this.hyperlink = value;
      return this;
    }

    /**
     * @return {@link #formatting} (If set, contains one of the following values:

'plain': use for plain text, possibly containing newlines, but otherwise unformatted (same as Void);
* 'plain_no_newlines': use for text containing no newlines or other formatting;
* 'markdown': use for markdown formatted text, strongly recommended in the format of the CommonMark specification.

DEPRECATED usage: contains a string of the form ```'name:value; name:value…​'``` , e.g. ```'font-weight : bold; font-family : Arial; font-size : 12pt;'```. Values taken from W3C CSS2 properties lists for background and font). This is the underlying object with id, value and extensions. The accessor "getFormatting" gives direct access to the value
     */
    public StringType getFormattingElement() { 
      if (this.formatting == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_TEXT.formatting");
        else if (Configuration.doAutoCreate())
          this.formatting = new StringType(); // bb
      return this.formatting;
    }

    public boolean hasFormattingElement() { 
      return this.formatting != null && !this.formatting.isEmpty();
    }

    public boolean hasFormatting() { 
      return this.formatting != null && !this.formatting.isEmpty();
    }

    /**
     * @param value {@link #formatting} (If set, contains one of the following values:

'plain': use for plain text, possibly containing newlines, but otherwise unformatted (same as Void);
* 'plain_no_newlines': use for text containing no newlines or other formatting;
* 'markdown': use for markdown formatted text, strongly recommended in the format of the CommonMark specification.

DEPRECATED usage: contains a string of the form ```'name:value; name:value…​'``` , e.g. ```'font-weight : bold; font-family : Arial; font-size : 12pt;'```. Values taken from W3C CSS2 properties lists for background and font). This is the underlying object with id, value and extensions. The accessor "getFormatting" gives direct access to the value
     */
    public DV_TEXT setFormattingElement(StringType value) { 
      this.formatting = value;
      return this;
    }

    /**
     * @return If set, contains one of the following values:

'plain': use for plain text, possibly containing newlines, but otherwise unformatted (same as Void);
* 'plain_no_newlines': use for text containing no newlines or other formatting;
* 'markdown': use for markdown formatted text, strongly recommended in the format of the CommonMark specification.

DEPRECATED usage: contains a string of the form ```'name:value; name:value…​'``` , e.g. ```'font-weight : bold; font-family : Arial; font-size : 12pt;'```. Values taken from W3C CSS2 properties lists for background and font
     */
    public String getFormatting() { 
      return this.formatting == null ? null : this.formatting.getValue();
    }

    /**
     * @param value If set, contains one of the following values:

'plain': use for plain text, possibly containing newlines, but otherwise unformatted (same as Void);
* 'plain_no_newlines': use for text containing no newlines or other formatting;
* 'markdown': use for markdown formatted text, strongly recommended in the format of the CommonMark specification.

DEPRECATED usage: contains a string of the form ```'name:value; name:value…​'``` , e.g. ```'font-weight : bold; font-family : Arial; font-size : 12pt;'```. Values taken from W3C CSS2 properties lists for background and font
     */
    public DV_TEXT setFormatting(String value) { 
      if (Utilities.noString(value))
        this.formatting = null;
      else {
        if (this.formatting == null)
          this.formatting = new StringType();
        this.formatting.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #mappings} (Terms from other terminologies most closely matching this term, typically used where the originator (e.g. pathology lab) of information uses a local terminology but also supplies one or more equivalents from well known terminologies (e.g. LOINC).)
     */
    public List<TERM_MAPPING> getMappingsList() { 
      if (this.mappingsList == null)
        this.mappingsList = new ArrayList<TERM_MAPPING>();
      return this.mappingsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DV_TEXT setMappingsList(List<TERM_MAPPING> theMappings) { 
      this.mappingsList = theMappings;
      return this;
    }

    public boolean hasMappings() { 
      if (this.mappingsList == null)
        return false;
      for (TERM_MAPPING item : this.mappingsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TERM_MAPPING addMappings() { //3a
      TERM_MAPPING t = new TERM_MAPPING();
      if (this.mappingsList == null)
        this.mappingsList = new ArrayList<TERM_MAPPING>();
      this.mappingsList.add(t);
      return t;
    }

    public DV_TEXT addMappings(TERM_MAPPING t) { //3b
      if (t == null)
        return this;
      if (this.mappingsList == null)
        this.mappingsList = new ArrayList<TERM_MAPPING>();
      this.mappingsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #mappings}, creating it if it does not already exist {3}
     */
    public TERM_MAPPING getMappingsFirstRep() { 
      if (getMappingsList().isEmpty()) {
        addMappings();
      }
      return getMappingsList().get(0);
    }

    /**
     * @return {@link #language} (Optional indicator of the localised language in which the value is written. Coded from openEHR Code Set languages . Only used when either the text object is in a different language from the enclosing ENTRY, or else the text object is being used outside of an ENTRY or other enclosing structure which indicates the language.)
     */
    public CODE_PHRASE getLanguage() { 
      if (this.language == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_TEXT.language");
        else if (Configuration.doAutoCreate())
          this.language = new CODE_PHRASE(); // cc
      return this.language;
    }

    public boolean hasLanguage() { 
      return this.language != null && !this.language.isEmpty();
    }

    /**
     * @param value {@link #language} (Optional indicator of the localised language in which the value is written. Coded from openEHR Code Set languages . Only used when either the text object is in a different language from the enclosing ENTRY, or else the text object is being used outside of an ENTRY or other enclosing structure which indicates the language.)
     */
    public DV_TEXT setLanguage(CODE_PHRASE value) { 
      this.language = value;
      return this;
    }

    /**
     * @return {@link #encoding} (Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions.)
     */
    public CODE_PHRASE getEncoding() { 
      if (this.encoding == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_TEXT.encoding");
        else if (Configuration.doAutoCreate())
          this.encoding = new CODE_PHRASE(); // cc
      return this.encoding;
    }

    public boolean hasEncoding() { 
      return this.encoding != null && !this.encoding.isEmpty();
    }

    /**
     * @param value {@link #encoding} (Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions.)
     */
    public DV_TEXT setEncoding(CODE_PHRASE value) { 
      this.encoding = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("value", "string", "Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.", 0, 1, value));
        children.add(new Property("hyperlink", "http://openehr.org/fhir/StructureDefinition/DV-URI", "DEPRECATED: this field is deprecated; use markdown link/text in the value attribute, and 'markdown' as the value of the formatting field.", 0, 1, hyperlink));
        children.add(new Property("formatting", "string", "If set, contains one of the following values:\n\n'plain': use for plain text, possibly containing newlines, but otherwise unformatted (same as Void);\n* 'plain_no_newlines': use for text containing no newlines or other formatting;\n* 'markdown': use for markdown formatted text, strongly recommended in the format of the CommonMark specification.\n\nDEPRECATED usage: contains a string of the form ```'name:value; name:value…​'``` , e.g. ```'font-weight : bold; font-family : Arial; font-size : 12pt;'```. Values taken from W3C CSS2 properties lists for background and font", 0, 1, formatting));
        children.add(new Property("mappings", "http://openehr.org/fhir/StructureDefinition/TERM-MAPPING", "Terms from other terminologies most closely matching this term, typically used where the originator (e.g. pathology lab) of information uses a local terminology but also supplies one or more equivalents from well known terminologies (e.g. LOINC).", 0, java.lang.Integer.MAX_VALUE, mappingsList));
        children.add(new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Optional indicator of the localised language in which the value is written. Coded from openEHR Code Set languages . Only used when either the text object is in a different language from the enclosing ENTRY, or else the text object is being used outside of an ENTRY or other enclosing structure which indicates the language.", 0, 1, language));
        children.add(new Property("encoding", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions.", 0, 1, encoding));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 111972721: /*value*/  return new Property("value", "string", "Displayable rendition of the item, regardless of its underlying structure. For DV_CODED_TEXT, this is the rubric of the complete term as provided by the terminology service.", 0, 1, value);
        case 751294566: /*hyperlink*/  return new Property("hyperlink", "http://openehr.org/fhir/StructureDefinition/DV-URI", "DEPRECATED: this field is deprecated; use markdown link/text in the value attribute, and 'markdown' as the value of the formatting field.", 0, 1, hyperlink);
        case 324761445: /*formatting*/  return new Property("formatting", "string", "If set, contains one of the following values:\n\n'plain': use for plain text, possibly containing newlines, but otherwise unformatted (same as Void);\n* 'plain_no_newlines': use for text containing no newlines or other formatting;\n* 'markdown': use for markdown formatted text, strongly recommended in the format of the CommonMark specification.\n\nDEPRECATED usage: contains a string of the form ```'name:value; name:value…​'``` , e.g. ```'font-weight : bold; font-family : Arial; font-size : 12pt;'```. Values taken from W3C CSS2 properties lists for background and font", 0, 1, formatting);
        case 194445669: /*mappings*/  return new Property("mappings", "http://openehr.org/fhir/StructureDefinition/TERM-MAPPING", "Terms from other terminologies most closely matching this term, typically used where the originator (e.g. pathology lab) of information uses a local terminology but also supplies one or more equivalents from well known terminologies (e.g. LOINC).", 0, java.lang.Integer.MAX_VALUE, mappingsList);
        case -1613589672: /*language*/  return new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Optional indicator of the localised language in which the value is written. Coded from openEHR Code Set languages . Only used when either the text object is in a different language from the enclosing ENTRY, or else the text object is being used outside of an ENTRY or other enclosing structure which indicates the language.", 0, 1, language);
        case 1711222099: /*encoding*/  return new Property("encoding", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions.", 0, 1, encoding);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        case 751294566: /*hyperlink*/ return this.hyperlink == null ? new Base[0] : new Base[] {this.hyperlink}; // DV_URI
        case 324761445: /*formatting*/ return this.formatting == null ? new Base[0] : new Base[] {this.formatting}; // StringType
        case 194445669: /*mappings*/ return this.mappingsList == null ? new Base[0] : this.mappingsList.toArray(new Base[this.mappingsList.size()]); // TERM_MAPPING
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CODE_PHRASE
        case 1711222099: /*encoding*/ return this.encoding == null ? new Base[0] : new Base[] {this.encoding}; // CODE_PHRASE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        case 751294566: // hyperlink
          this.hyperlink = (DV_URI) value; // DV_URI
          return value;
        case 324761445: // formatting
          this.formatting = TypeConvertor.castToString(value); // StringType
          return value;
        case 194445669: // mappings
          this.getMappingsList().add((TERM_MAPPING) value); // TERM_MAPPING
          return value;
        case -1613589672: // language
          this.language = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case 1711222099: // encoding
          this.encoding = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("hyperlink")) {
          this.hyperlink = (DV_URI) value; // DV_URI
        } else if (name.equals("formatting")) {
          this.formatting = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("mappings")) {
          this.getMappingsList().add((TERM_MAPPING) value); // TERM_MAPPING
        } else if (name.equals("language")) {
          this.language = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("encoding")) {
          this.encoding = (CODE_PHRASE) value; // CODE_PHRASE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721:  return getValueElement();
        case 751294566:  return getHyperlink();
        case 324761445:  return getFormattingElement();
        case 194445669:  return addMappings(); 
        case -1613589672:  return getLanguage();
        case 1711222099:  return getEncoding();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 111972721: /*value*/ return new String[] {"string"};
        case 751294566: /*hyperlink*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/DV-URI"};
        case 324761445: /*formatting*/ return new String[] {"string"};
        case 194445669: /*mappings*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/TERM-MAPPING"};
        case -1613589672: /*language*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case 1711222099: /*encoding*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_TEXT.value");
        }
        else if (name.equals("hyperlink")) {
          this.hyperlink = new DV_URI();
          return this.hyperlink;
        }
        else if (name.equals("formatting")) {
          throw new FHIRException("Cannot call addChild on a singleton property DV_TEXT.formatting");
        }
        else if (name.equals("mappings")) {
          return addMappings();
        }
        else if (name.equals("language")) {
          this.language = new CODE_PHRASE();
          return this.language;
        }
        else if (name.equals("encoding")) {
          this.encoding = new CODE_PHRASE();
          return this.encoding;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_TEXT";

  }

      public DV_TEXT copy() {
        DV_TEXT dst = new DV_TEXT();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DV_TEXT dst) {
        super.copyValues(dst);
        dst.value = value == null ? null : value.copy();
        dst.hyperlink = hyperlink == null ? null : hyperlink.copy();
        dst.formatting = formatting == null ? null : formatting.copy();
        if (mappingsList != null) {
          dst.mappingsList = new ArrayList<TERM_MAPPING>();
          for (TERM_MAPPING i : mappingsList)
            dst.mappingsList.add(i.copy());
        };
        dst.language = language == null ? null : language.copy();
        dst.encoding = encoding == null ? null : encoding.copy();
      }

      protected DV_TEXT typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_TEXT))
          return false;
        DV_TEXT o = (DV_TEXT) other_;
        return compareDeep(value, o.value, true) && compareDeep(hyperlink, o.hyperlink, true) && compareDeep(formatting, o.formatting, true)
           && compareDeep(mappingsList, o.mappingsList, true) && compareDeep(language, o.language, true) && compareDeep(encoding, o.encoding, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_TEXT))
          return false;
        DV_TEXT o = (DV_TEXT) other_;
        return compareValues(value, o.value, true) && compareValues(formatting, o.formatting, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(value, hyperlink, formatting
          , mappingsList, language, encoding);
      }


}

