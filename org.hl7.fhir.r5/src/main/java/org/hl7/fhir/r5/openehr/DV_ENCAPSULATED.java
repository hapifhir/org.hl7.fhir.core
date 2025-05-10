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
 * Abstract class defining the common meta-data of all types of encapsulated data.
 */
@DatatypeDef(name="DV_ENCAPSULATED")
public abstract class DV_ENCAPSULATED extends DV_AMOUNT implements ICompositeType {

    /**
     * Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions.
     */
    @Child(name = "charset", type = {CODE_PHRASE.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets", formalDefinition="Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="https://specifications.openehr.org/fhir/valueset-character_sets")
    protected CODE_PHRASE charset;

    /**
     * Optional indicator of the localised language in which the data is written, if relevant. Coded from openEHR Code Set languages.
     */
    @Child(name = "language", type = {CODE_PHRASE.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional indicator of the localised language in which the data is written, if relevant", formalDefinition="Optional indicator of the localised language in which the data is written, if relevant. Coded from openEHR Code Set languages." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/all-languages")
    protected CODE_PHRASE language;

    private static final long serialVersionUID = 379442662L;

  /**
   * Constructor
   */
    public DV_ENCAPSULATED() {
      super();
    }

    /**
     * @return {@link #charset} (Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions.)
     */
    public CODE_PHRASE getCharset() { 
      if (this.charset == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_ENCAPSULATED.charset");
        else if (Configuration.doAutoCreate())
          this.charset = new CODE_PHRASE(); // cc
      return this.charset;
    }

    public boolean hasCharset() { 
      return this.charset != null && !this.charset.isEmpty();
    }

    /**
     * @param value {@link #charset} (Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions.)
     */
    public DV_ENCAPSULATED setCharset(CODE_PHRASE value) { 
      this.charset = value;
      return this;
    }

    /**
     * @return {@link #language} (Optional indicator of the localised language in which the data is written, if relevant. Coded from openEHR Code Set languages.)
     */
    public CODE_PHRASE getLanguage() { 
      if (this.language == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DV_ENCAPSULATED.language");
        else if (Configuration.doAutoCreate())
          this.language = new CODE_PHRASE(); // cc
      return this.language;
    }

    public boolean hasLanguage() { 
      return this.language != null && !this.language.isEmpty();
    }

    /**
     * @param value {@link #language} (Optional indicator of the localised language in which the data is written, if relevant. Coded from openEHR Code Set languages.)
     */
    public DV_ENCAPSULATED setLanguage(CODE_PHRASE value) { 
      this.language = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("charset", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions.", 0, 1, charset));
        children.add(new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Optional indicator of the localised language in which the data is written, if relevant. Coded from openEHR Code Set languages.", 0, 1, language));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 739074380: /*charset*/  return new Property("charset", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Name of character encoding scheme in which this value is encoded. Coded from openEHR Code Set character sets . Unicode is the default assumption in openEHR, with UTF-8 being the assumed encoding. This attribute allows for variations from these assumptions.", 0, 1, charset);
        case -1613589672: /*language*/  return new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Optional indicator of the localised language in which the data is written, if relevant. Coded from openEHR Code Set languages.", 0, 1, language);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 739074380: /*charset*/ return this.charset == null ? new Base[0] : new Base[] {this.charset}; // CODE_PHRASE
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CODE_PHRASE
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 739074380: // charset
          this.charset = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case -1613589672: // language
          this.language = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("charset")) {
          this.charset = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("language")) {
          this.language = (CODE_PHRASE) value; // CODE_PHRASE
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 739074380:  return getCharset();
        case -1613589672:  return getLanguage();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 739074380: /*charset*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case -1613589672: /*language*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("charset")) {
          this.charset = new CODE_PHRASE();
          return this.charset;
        }
        else if (name.equals("language")) {
          this.language = new CODE_PHRASE();
          return this.language;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DV_ENCAPSULATED";

  }

      public abstract DV_ENCAPSULATED copy();

      public void copyValues(DV_ENCAPSULATED dst) {
        super.copyValues(dst);
        dst.charset = charset == null ? null : charset.copy();
        dst.language = language == null ? null : language.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DV_ENCAPSULATED))
          return false;
        DV_ENCAPSULATED o = (DV_ENCAPSULATED) other_;
        return compareDeep(charset, o.charset, true) && compareDeep(language, o.language, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DV_ENCAPSULATED))
          return false;
        DV_ENCAPSULATED o = (DV_ENCAPSULATED) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(charset, language);
      }


}

