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
 * Class providing details of a natural language translation.
 */
@DatatypeDef(name="TRANSLATION_DETAILS")
public class TRANSLATION_DETAILS extends LogicalBase implements ICompositeType {

    /**
     * Language of the translation.
     */
    @Child(name = "language", type = {CODE_PHRASE.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Language of the translation", formalDefinition="Language of the translation." )
    protected CODE_PHRASE language;

    /**
     * Translator name and other demographic details.
     */
    @Child(name = "author", type = {StringType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Translator name and other demographic details", formalDefinition="Translator name and other demographic details." )
    protected List<StringType> authorList;

    /**
     * Accreditation of translator, usually a national translator’s registration or association membership id.
     */
    @Child(name = "accreditation", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Accreditation of translator, usually a national translator’s registration or association membership id", formalDefinition="Accreditation of translator, usually a national translator’s registration or association membership id." )
    protected StringType accreditation;

    /**
     * Any other meta-data.
     */
    @Child(name = "other_details", type = {StringType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Any other meta-data", formalDefinition="Any other meta-data." )
    protected List<StringType> other_detailsList;

    private static final long serialVersionUID = -1093734482L;

  /**
   * Constructor
   */
    public TRANSLATION_DETAILS() {
      super();
    }

  /**
   * Constructor
   */
    public TRANSLATION_DETAILS(CODE_PHRASE language, String accreditation) {
      super();
      this.setLanguage(language);
      this.setAccreditation(accreditation);
    }

    /**
     * @return {@link #language} (Language of the translation.)
     */
    public CODE_PHRASE getLanguage() { 
      if (this.language == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TRANSLATION_DETAILS.language");
        else if (Configuration.doAutoCreate())
          this.language = new CODE_PHRASE(); // cc
      return this.language;
    }

    public boolean hasLanguage() { 
      return this.language != null && !this.language.isEmpty();
    }

    /**
     * @param value {@link #language} (Language of the translation.)
     */
    public TRANSLATION_DETAILS setLanguage(CODE_PHRASE value) { 
      this.language = value;
      return this;
    }

    /**
     * @return {@link #author} (Translator name and other demographic details.)
     */
    public List<StringType> getAuthorList() { 
      if (this.authorList == null)
        this.authorList = new ArrayList<StringType>();
      return this.authorList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TRANSLATION_DETAILS setAuthorList(List<StringType> theAuthor) { 
      this.authorList = theAuthor;
      return this;
    }

    public boolean hasAuthor() { 
      if (this.authorList == null)
        return false;
      for (StringType item : this.authorList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #author} (Translator name and other demographic details.)
     */
    public StringType addAuthorElement() {//2 
      StringType t = new StringType();
      if (this.authorList == null)
        this.authorList = new ArrayList<StringType>();
      this.authorList.add(t);
      return t;
    }

    /**
     * @param value {@link #author} (Translator name and other demographic details.)
     */
    public TRANSLATION_DETAILS addAuthor(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.authorList == null)
        this.authorList = new ArrayList<StringType>();
      this.authorList.add(t);
      return this;
    }

    /**
     * @param value {@link #author} (Translator name and other demographic details.)
     */
    public boolean hasAuthor(String value) { 
      if (this.authorList == null)
        return false;
      for (StringType v : this.authorList)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #accreditation} (Accreditation of translator, usually a national translator’s registration or association membership id.). This is the underlying object with id, value and extensions. The accessor "getAccreditation" gives direct access to the value
     */
    public StringType getAccreditationElement() { 
      if (this.accreditation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create TRANSLATION_DETAILS.accreditation");
        else if (Configuration.doAutoCreate())
          this.accreditation = new StringType(); // bb
      return this.accreditation;
    }

    public boolean hasAccreditationElement() { 
      return this.accreditation != null && !this.accreditation.isEmpty();
    }

    public boolean hasAccreditation() { 
      return this.accreditation != null && !this.accreditation.isEmpty();
    }

    /**
     * @param value {@link #accreditation} (Accreditation of translator, usually a national translator’s registration or association membership id.). This is the underlying object with id, value and extensions. The accessor "getAccreditation" gives direct access to the value
     */
    public TRANSLATION_DETAILS setAccreditationElement(StringType value) { 
      this.accreditation = value;
      return this;
    }

    /**
     * @return Accreditation of translator, usually a national translator’s registration or association membership id.
     */
    public String getAccreditation() { 
      return this.accreditation == null ? null : this.accreditation.getValue();
    }

    /**
     * @param value Accreditation of translator, usually a national translator’s registration or association membership id.
     */
    public TRANSLATION_DETAILS setAccreditation(String value) { 
        if (this.accreditation == null)
          this.accreditation = new StringType();
        this.accreditation.setValue(value);
      return this;
    }

    /**
     * @return {@link #other_details} (Any other meta-data.)
     */
    public List<StringType> getOther_detailsList() { 
      if (this.other_detailsList == null)
        this.other_detailsList = new ArrayList<StringType>();
      return this.other_detailsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public TRANSLATION_DETAILS setOther_detailsList(List<StringType> theOther_details) { 
      this.other_detailsList = theOther_details;
      return this;
    }

    public boolean hasOther_details() { 
      if (this.other_detailsList == null)
        return false;
      for (StringType item : this.other_detailsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #other_details} (Any other meta-data.)
     */
    public StringType addOther_detailsElement() {//2 
      StringType t = new StringType();
      if (this.other_detailsList == null)
        this.other_detailsList = new ArrayList<StringType>();
      this.other_detailsList.add(t);
      return t;
    }

    /**
     * @param value {@link #other_details} (Any other meta-data.)
     */
    public TRANSLATION_DETAILS addOther_details(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.other_detailsList == null)
        this.other_detailsList = new ArrayList<StringType>();
      this.other_detailsList.add(t);
      return this;
    }

    /**
     * @param value {@link #other_details} (Any other meta-data.)
     */
    public boolean hasOther_details(String value) { 
      if (this.other_detailsList == null)
        return false;
      for (StringType v : this.other_detailsList)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Language of the translation.", 0, 1, language));
        children.add(new Property("author", "string", "Translator name and other demographic details.", 0, java.lang.Integer.MAX_VALUE, authorList));
        children.add(new Property("accreditation", "string", "Accreditation of translator, usually a national translator’s registration or association membership id.", 0, 1, accreditation));
        children.add(new Property("other_details", "string", "Any other meta-data.", 0, java.lang.Integer.MAX_VALUE, other_detailsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1613589672: /*language*/  return new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Language of the translation.", 0, 1, language);
        case -1406328437: /*author*/  return new Property("author", "string", "Translator name and other demographic details.", 0, java.lang.Integer.MAX_VALUE, authorList);
        case 1197534778: /*accreditation*/  return new Property("accreditation", "string", "Accreditation of translator, usually a national translator’s registration or association membership id.", 0, 1, accreditation);
        case -1257043949: /*other_details*/  return new Property("other_details", "string", "Any other meta-data.", 0, java.lang.Integer.MAX_VALUE, other_detailsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CODE_PHRASE
        case -1406328437: /*author*/ return this.authorList == null ? new Base[0] : this.authorList.toArray(new Base[this.authorList.size()]); // StringType
        case 1197534778: /*accreditation*/ return this.accreditation == null ? new Base[0] : new Base[] {this.accreditation}; // StringType
        case -1257043949: /*other_details*/ return this.other_detailsList == null ? new Base[0] : this.other_detailsList.toArray(new Base[this.other_detailsList.size()]); // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1613589672: // language
          this.language = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case -1406328437: // author
          this.getAuthorList().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 1197534778: // accreditation
          this.accreditation = TypeConvertor.castToString(value); // StringType
          return value;
        case -1257043949: // other_details
          this.getOther_detailsList().add(TypeConvertor.castToString(value)); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("language")) {
          this.language = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("author")) {
          this.getAuthorList().add(TypeConvertor.castToString(value)); // StringType
        } else if (name.equals("accreditation")) {
          this.accreditation = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("other_details")) {
          this.getOther_detailsList().add(TypeConvertor.castToString(value)); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672:  return getLanguage();
        case -1406328437:  return addAuthorElement();
        case 1197534778:  return getAccreditationElement();
        case -1257043949:  return addOther_detailsElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case -1406328437: /*author*/ return new String[] {"string"};
        case 1197534778: /*accreditation*/ return new String[] {"string"};
        case -1257043949: /*other_details*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("language")) {
          this.language = new CODE_PHRASE();
          return this.language;
        }
        else if (name.equals("author")) {
          throw new FHIRException("Cannot call addChild on a singleton property TRANSLATION_DETAILS.author");
        }
        else if (name.equals("accreditation")) {
          throw new FHIRException("Cannot call addChild on a singleton property TRANSLATION_DETAILS.accreditation");
        }
        else if (name.equals("other_details")) {
          throw new FHIRException("Cannot call addChild on a singleton property TRANSLATION_DETAILS.other_details");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "TRANSLATION_DETAILS";

  }

      public TRANSLATION_DETAILS copy() {
        TRANSLATION_DETAILS dst = new TRANSLATION_DETAILS();
        copyValues(dst);
        return dst;
      }

      public void copyValues(TRANSLATION_DETAILS dst) {
        super.copyValues(dst);
        dst.language = language == null ? null : language.copy();
        if (authorList != null) {
          dst.authorList = new ArrayList<StringType>();
          for (StringType i : authorList)
            dst.authorList.add(i.copy());
        };
        dst.accreditation = accreditation == null ? null : accreditation.copy();
        if (other_detailsList != null) {
          dst.other_detailsList = new ArrayList<StringType>();
          for (StringType i : other_detailsList)
            dst.other_detailsList.add(i.copy());
        };
      }

      protected TRANSLATION_DETAILS typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof TRANSLATION_DETAILS))
          return false;
        TRANSLATION_DETAILS o = (TRANSLATION_DETAILS) other_;
        return compareDeep(language, o.language, true) && compareDeep(authorList, o.authorList, true) && compareDeep(accreditation, o.accreditation, true)
           && compareDeep(other_detailsList, o.other_detailsList, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof TRANSLATION_DETAILS))
          return false;
        TRANSLATION_DETAILS o = (TRANSLATION_DETAILS) other_;
        return compareValues(authorList, o.authorList, true) && compareValues(accreditation, o.accreditation, true)
           && compareValues(other_detailsList, o.other_detailsList, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(language, authorList, accreditation
          , other_detailsList);
      }


}

