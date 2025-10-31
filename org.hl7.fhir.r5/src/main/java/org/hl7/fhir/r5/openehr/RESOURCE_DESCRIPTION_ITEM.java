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
 * Language-specific detail of resource description. When a resource is translated for use in another language environment, each RESOURCE_DESCRIPTION_ITEM needs to be copied and translated into the new language.
 */
@DatatypeDef(name="RESOURCE_DESCRIPTION_ITEM")
public class RESOURCE_DESCRIPTION_ITEM extends LogicalBase implements ICompositeType {

    /**
     * The localised language in which the items in this description item are written. Coded from openEHR code set languages.
     */
    @Child(name = "language", type = {CODE_PHRASE.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The localised language in which the items in this description item are written", formalDefinition="The localised language in which the items in this description item are written. Coded from openEHR code set languages." )
    protected CODE_PHRASE language;

    /**
     * Purpose of the resource.
     */
    @Child(name = "purpose", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Purpose of the resource", formalDefinition="Purpose of the resource." )
    protected StringType purpose;

    /**
     * Keywords which characterise this resource, used e.g. for indexing and searching.
     */
    @Child(name = "keywords", type = {StringType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Keywords which characterise this resource, used e.g. for indexing and searching", formalDefinition="Keywords which characterise this resource, used e.g. for indexing and searching." )
    protected List<StringType> keywordsList;

    /**
     * Description of the uses of the resource, i.e. contexts in which it could be used.
     */
    @Child(name = "use", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Description of the uses of the resource, i.e. contexts in which it could be used", formalDefinition="Description of the uses of the resource, i.e. contexts in which it could be used." )
    protected StringType use;

    /**
     * Description of any misuses of the resource, i.e. contexts in which it should not be used.
     */
    @Child(name = "misuse", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Description of any misuses of the resource, i.e. contexts in which it should not be used", formalDefinition="Description of any misuses of the resource, i.e. contexts in which it should not be used." )
    protected StringType misuse;

    /**
     * Optional copyright statement for the resource as a knowledge resource.
     */
    @Child(name = "copyright", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Optional copyright statement for the resource as a knowledge resource", formalDefinition="Optional copyright statement for the resource as a knowledge resource." )
    protected StringType copyright;

    /**
     * URIs of original clinical document(s) or description of which resource is a formalisation, in the language of this description item; keyed by meaning.
     */
    @Child(name = "original_resource_uri", type = {StringType.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="URIs of original clinical document(s) or description of which resource is a formalisation", formalDefinition="URIs of original clinical document(s) or description of which resource is a formalisation, in the language of this description item; keyed by meaning." )
    protected List<StringType> original_resource_uriList;

    /**
     * Additional language-senstive resource metadata, as a list of name/value pairs.
     */
    @Child(name = "other_details", type = {StringType.class}, order=7, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional language-senstive resource metadata, as a list of name/value pairs", formalDefinition="Additional language-senstive resource metadata, as a list of name/value pairs." )
    protected List<StringType> other_detailsList;

    private static final long serialVersionUID = -1123991092L;

  /**
   * Constructor
   */
    public RESOURCE_DESCRIPTION_ITEM() {
      super();
    }

  /**
   * Constructor
   */
    public RESOURCE_DESCRIPTION_ITEM(CODE_PHRASE language, String purpose, String other_details) {
      super();
      this.setLanguage(language);
      this.setPurpose(purpose);
      this.addOther_details(other_details);
    }

    /**
     * @return {@link #language} (The localised language in which the items in this description item are written. Coded from openEHR code set languages.)
     */
    public CODE_PHRASE getLanguage() { 
      if (this.language == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RESOURCE_DESCRIPTION_ITEM.language");
        else if (Configuration.doAutoCreate())
          this.language = new CODE_PHRASE(); // cc
      return this.language;
    }

    public boolean hasLanguage() { 
      return this.language != null && !this.language.isEmpty();
    }

    /**
     * @param value {@link #language} (The localised language in which the items in this description item are written. Coded from openEHR code set languages.)
     */
    public RESOURCE_DESCRIPTION_ITEM setLanguage(CODE_PHRASE value) { 
      this.language = value;
      return this;
    }

    /**
     * @return {@link #purpose} (Purpose of the resource.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public StringType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RESOURCE_DESCRIPTION_ITEM.purpose");
        else if (Configuration.doAutoCreate())
          this.purpose = new StringType(); // bb
      return this.purpose;
    }

    public boolean hasPurposeElement() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    public boolean hasPurpose() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    /**
     * @param value {@link #purpose} (Purpose of the resource.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public RESOURCE_DESCRIPTION_ITEM setPurposeElement(StringType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Purpose of the resource.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Purpose of the resource.
     */
    public RESOURCE_DESCRIPTION_ITEM setPurpose(String value) { 
        if (this.purpose == null)
          this.purpose = new StringType();
        this.purpose.setValue(value);
      return this;
    }

    /**
     * @return {@link #keywords} (Keywords which characterise this resource, used e.g. for indexing and searching.)
     */
    public List<StringType> getKeywordsList() { 
      if (this.keywordsList == null)
        this.keywordsList = new ArrayList<StringType>();
      return this.keywordsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RESOURCE_DESCRIPTION_ITEM setKeywordsList(List<StringType> theKeywords) { 
      this.keywordsList = theKeywords;
      return this;
    }

    public boolean hasKeywords() { 
      if (this.keywordsList == null)
        return false;
      for (StringType item : this.keywordsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #keywords} (Keywords which characterise this resource, used e.g. for indexing and searching.)
     */
    public StringType addKeywordsElement() {//2 
      StringType t = new StringType();
      if (this.keywordsList == null)
        this.keywordsList = new ArrayList<StringType>();
      this.keywordsList.add(t);
      return t;
    }

    /**
     * @param value {@link #keywords} (Keywords which characterise this resource, used e.g. for indexing and searching.)
     */
    public RESOURCE_DESCRIPTION_ITEM addKeywords(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.keywordsList == null)
        this.keywordsList = new ArrayList<StringType>();
      this.keywordsList.add(t);
      return this;
    }

    /**
     * @param value {@link #keywords} (Keywords which characterise this resource, used e.g. for indexing and searching.)
     */
    public boolean hasKeywords(String value) { 
      if (this.keywordsList == null)
        return false;
      for (StringType v : this.keywordsList)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #use} (Description of the uses of the resource, i.e. contexts in which it could be used.). This is the underlying object with id, value and extensions. The accessor "getUse" gives direct access to the value
     */
    public StringType getUseElement() { 
      if (this.use == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RESOURCE_DESCRIPTION_ITEM.use");
        else if (Configuration.doAutoCreate())
          this.use = new StringType(); // bb
      return this.use;
    }

    public boolean hasUseElement() { 
      return this.use != null && !this.use.isEmpty();
    }

    public boolean hasUse() { 
      return this.use != null && !this.use.isEmpty();
    }

    /**
     * @param value {@link #use} (Description of the uses of the resource, i.e. contexts in which it could be used.). This is the underlying object with id, value and extensions. The accessor "getUse" gives direct access to the value
     */
    public RESOURCE_DESCRIPTION_ITEM setUseElement(StringType value) { 
      this.use = value;
      return this;
    }

    /**
     * @return Description of the uses of the resource, i.e. contexts in which it could be used.
     */
    public String getUse() { 
      return this.use == null ? null : this.use.getValue();
    }

    /**
     * @param value Description of the uses of the resource, i.e. contexts in which it could be used.
     */
    public RESOURCE_DESCRIPTION_ITEM setUse(String value) { 
      if (Utilities.noString(value))
        this.use = null;
      else {
        if (this.use == null)
          this.use = new StringType();
        this.use.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #misuse} (Description of any misuses of the resource, i.e. contexts in which it should not be used.). This is the underlying object with id, value and extensions. The accessor "getMisuse" gives direct access to the value
     */
    public StringType getMisuseElement() { 
      if (this.misuse == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RESOURCE_DESCRIPTION_ITEM.misuse");
        else if (Configuration.doAutoCreate())
          this.misuse = new StringType(); // bb
      return this.misuse;
    }

    public boolean hasMisuseElement() { 
      return this.misuse != null && !this.misuse.isEmpty();
    }

    public boolean hasMisuse() { 
      return this.misuse != null && !this.misuse.isEmpty();
    }

    /**
     * @param value {@link #misuse} (Description of any misuses of the resource, i.e. contexts in which it should not be used.). This is the underlying object with id, value and extensions. The accessor "getMisuse" gives direct access to the value
     */
    public RESOURCE_DESCRIPTION_ITEM setMisuseElement(StringType value) { 
      this.misuse = value;
      return this;
    }

    /**
     * @return Description of any misuses of the resource, i.e. contexts in which it should not be used.
     */
    public String getMisuse() { 
      return this.misuse == null ? null : this.misuse.getValue();
    }

    /**
     * @param value Description of any misuses of the resource, i.e. contexts in which it should not be used.
     */
    public RESOURCE_DESCRIPTION_ITEM setMisuse(String value) { 
      if (Utilities.noString(value))
        this.misuse = null;
      else {
        if (this.misuse == null)
          this.misuse = new StringType();
        this.misuse.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (Optional copyright statement for the resource as a knowledge resource.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public StringType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RESOURCE_DESCRIPTION_ITEM.copyright");
        else if (Configuration.doAutoCreate())
          this.copyright = new StringType(); // bb
      return this.copyright;
    }

    public boolean hasCopyrightElement() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    public boolean hasCopyright() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    /**
     * @param value {@link #copyright} (Optional copyright statement for the resource as a knowledge resource.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public RESOURCE_DESCRIPTION_ITEM setCopyrightElement(StringType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return Optional copyright statement for the resource as a knowledge resource.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value Optional copyright statement for the resource as a knowledge resource.
     */
    public RESOURCE_DESCRIPTION_ITEM setCopyright(String value) { 
      if (Utilities.noString(value))
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new StringType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #original_resource_uri} (URIs of original clinical document(s) or description of which resource is a formalisation, in the language of this description item; keyed by meaning.)
     */
    public List<StringType> getOriginal_resource_uriList() { 
      if (this.original_resource_uriList == null)
        this.original_resource_uriList = new ArrayList<StringType>();
      return this.original_resource_uriList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RESOURCE_DESCRIPTION_ITEM setOriginal_resource_uriList(List<StringType> theOriginal_resource_uri) { 
      this.original_resource_uriList = theOriginal_resource_uri;
      return this;
    }

    public boolean hasOriginal_resource_uri() { 
      if (this.original_resource_uriList == null)
        return false;
      for (StringType item : this.original_resource_uriList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #original_resource_uri} (URIs of original clinical document(s) or description of which resource is a formalisation, in the language of this description item; keyed by meaning.)
     */
    public StringType addOriginal_resource_uriElement() {//2 
      StringType t = new StringType();
      if (this.original_resource_uriList == null)
        this.original_resource_uriList = new ArrayList<StringType>();
      this.original_resource_uriList.add(t);
      return t;
    }

    /**
     * @param value {@link #original_resource_uri} (URIs of original clinical document(s) or description of which resource is a formalisation, in the language of this description item; keyed by meaning.)
     */
    public RESOURCE_DESCRIPTION_ITEM addOriginal_resource_uri(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.original_resource_uriList == null)
        this.original_resource_uriList = new ArrayList<StringType>();
      this.original_resource_uriList.add(t);
      return this;
    }

    /**
     * @param value {@link #original_resource_uri} (URIs of original clinical document(s) or description of which resource is a formalisation, in the language of this description item; keyed by meaning.)
     */
    public boolean hasOriginal_resource_uri(String value) { 
      if (this.original_resource_uriList == null)
        return false;
      for (StringType v : this.original_resource_uriList)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #other_details} (Additional language-senstive resource metadata, as a list of name/value pairs.)
     */
    public List<StringType> getOther_detailsList() { 
      if (this.other_detailsList == null)
        this.other_detailsList = new ArrayList<StringType>();
      return this.other_detailsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RESOURCE_DESCRIPTION_ITEM setOther_detailsList(List<StringType> theOther_details) { 
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
     * @return {@link #other_details} (Additional language-senstive resource metadata, as a list of name/value pairs.)
     */
    public StringType addOther_detailsElement() {//2 
      StringType t = new StringType();
      if (this.other_detailsList == null)
        this.other_detailsList = new ArrayList<StringType>();
      this.other_detailsList.add(t);
      return t;
    }

    /**
     * @param value {@link #other_details} (Additional language-senstive resource metadata, as a list of name/value pairs.)
     */
    public RESOURCE_DESCRIPTION_ITEM addOther_details(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.other_detailsList == null)
        this.other_detailsList = new ArrayList<StringType>();
      this.other_detailsList.add(t);
      return this;
    }

    /**
     * @param value {@link #other_details} (Additional language-senstive resource metadata, as a list of name/value pairs.)
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
        children.add(new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "The localised language in which the items in this description item are written. Coded from openEHR code set languages.", 0, 1, language));
        children.add(new Property("purpose", "string", "Purpose of the resource.", 0, 1, purpose));
        children.add(new Property("keywords", "string", "Keywords which characterise this resource, used e.g. for indexing and searching.", 0, java.lang.Integer.MAX_VALUE, keywordsList));
        children.add(new Property("use", "string", "Description of the uses of the resource, i.e. contexts in which it could be used.", 0, 1, use));
        children.add(new Property("misuse", "string", "Description of any misuses of the resource, i.e. contexts in which it should not be used.", 0, 1, misuse));
        children.add(new Property("copyright", "string", "Optional copyright statement for the resource as a knowledge resource.", 0, 1, copyright));
        children.add(new Property("original_resource_uri", "string", "URIs of original clinical document(s) or description of which resource is a formalisation, in the language of this description item; keyed by meaning.", 0, java.lang.Integer.MAX_VALUE, original_resource_uriList));
        children.add(new Property("other_details", "string", "Additional language-senstive resource metadata, as a list of name/value pairs.", 0, java.lang.Integer.MAX_VALUE, other_detailsList));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1613589672: /*language*/  return new Property("language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "The localised language in which the items in this description item are written. Coded from openEHR code set languages.", 0, 1, language);
        case -220463842: /*purpose*/  return new Property("purpose", "string", "Purpose of the resource.", 0, 1, purpose);
        case 523149226: /*keywords*/  return new Property("keywords", "string", "Keywords which characterise this resource, used e.g. for indexing and searching.", 0, java.lang.Integer.MAX_VALUE, keywordsList);
        case 116103: /*use*/  return new Property("use", "string", "Description of the uses of the resource, i.e. contexts in which it could be used.", 0, 1, use);
        case -1073878064: /*misuse*/  return new Property("misuse", "string", "Description of any misuses of the resource, i.e. contexts in which it should not be used.", 0, 1, misuse);
        case 1522889671: /*copyright*/  return new Property("copyright", "string", "Optional copyright statement for the resource as a knowledge resource.", 0, 1, copyright);
        case -775873175: /*original_resource_uri*/  return new Property("original_resource_uri", "string", "URIs of original clinical document(s) or description of which resource is a formalisation, in the language of this description item; keyed by meaning.", 0, java.lang.Integer.MAX_VALUE, original_resource_uriList);
        case -1257043949: /*other_details*/  return new Property("other_details", "string", "Additional language-senstive resource metadata, as a list of name/value pairs.", 0, java.lang.Integer.MAX_VALUE, other_detailsList);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : new Base[] {this.language}; // CODE_PHRASE
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // StringType
        case 523149226: /*keywords*/ return this.keywordsList == null ? new Base[0] : this.keywordsList.toArray(new Base[this.keywordsList.size()]); // StringType
        case 116103: /*use*/ return this.use == null ? new Base[0] : new Base[] {this.use}; // StringType
        case -1073878064: /*misuse*/ return this.misuse == null ? new Base[0] : new Base[] {this.misuse}; // StringType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // StringType
        case -775873175: /*original_resource_uri*/ return this.original_resource_uriList == null ? new Base[0] : this.original_resource_uriList.toArray(new Base[this.original_resource_uriList.size()]); // StringType
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
        case -220463842: // purpose
          this.purpose = TypeConvertor.castToString(value); // StringType
          return value;
        case 523149226: // keywords
          this.getKeywordsList().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 116103: // use
          this.use = TypeConvertor.castToString(value); // StringType
          return value;
        case -1073878064: // misuse
          this.misuse = TypeConvertor.castToString(value); // StringType
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToString(value); // StringType
          return value;
        case -775873175: // original_resource_uri
          this.getOriginal_resource_uriList().add(TypeConvertor.castToString(value)); // StringType
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
        } else if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("keywords")) {
          this.getKeywordsList().add(TypeConvertor.castToString(value)); // StringType
        } else if (name.equals("use")) {
          this.use = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("misuse")) {
          this.misuse = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("original_resource_uri")) {
          this.getOriginal_resource_uriList().add(TypeConvertor.castToString(value)); // StringType
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
        case -220463842:  return getPurposeElement();
        case 523149226:  return addKeywordsElement();
        case 116103:  return getUseElement();
        case -1073878064:  return getMisuseElement();
        case 1522889671:  return getCopyrightElement();
        case -775873175:  return addOriginal_resource_uriElement();
        case -1257043949:  return addOther_detailsElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1613589672: /*language*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case -220463842: /*purpose*/ return new String[] {"string"};
        case 523149226: /*keywords*/ return new String[] {"string"};
        case 116103: /*use*/ return new String[] {"string"};
        case -1073878064: /*misuse*/ return new String[] {"string"};
        case 1522889671: /*copyright*/ return new String[] {"string"};
        case -775873175: /*original_resource_uri*/ return new String[] {"string"};
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
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a singleton property RESOURCE_DESCRIPTION_ITEM.purpose");
        }
        else if (name.equals("keywords")) {
          throw new FHIRException("Cannot call addChild on a singleton property RESOURCE_DESCRIPTION_ITEM.keywords");
        }
        else if (name.equals("use")) {
          throw new FHIRException("Cannot call addChild on a singleton property RESOURCE_DESCRIPTION_ITEM.use");
        }
        else if (name.equals("misuse")) {
          throw new FHIRException("Cannot call addChild on a singleton property RESOURCE_DESCRIPTION_ITEM.misuse");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a singleton property RESOURCE_DESCRIPTION_ITEM.copyright");
        }
        else if (name.equals("original_resource_uri")) {
          throw new FHIRException("Cannot call addChild on a singleton property RESOURCE_DESCRIPTION_ITEM.original_resource_uri");
        }
        else if (name.equals("other_details")) {
          throw new FHIRException("Cannot call addChild on a singleton property RESOURCE_DESCRIPTION_ITEM.other_details");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "RESOURCE_DESCRIPTION_ITEM";

  }

      public RESOURCE_DESCRIPTION_ITEM copy() {
        RESOURCE_DESCRIPTION_ITEM dst = new RESOURCE_DESCRIPTION_ITEM();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RESOURCE_DESCRIPTION_ITEM dst) {
        super.copyValues(dst);
        dst.language = language == null ? null : language.copy();
        dst.purpose = purpose == null ? null : purpose.copy();
        if (keywordsList != null) {
          dst.keywordsList = new ArrayList<StringType>();
          for (StringType i : keywordsList)
            dst.keywordsList.add(i.copy());
        };
        dst.use = use == null ? null : use.copy();
        dst.misuse = misuse == null ? null : misuse.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        if (original_resource_uriList != null) {
          dst.original_resource_uriList = new ArrayList<StringType>();
          for (StringType i : original_resource_uriList)
            dst.original_resource_uriList.add(i.copy());
        };
        if (other_detailsList != null) {
          dst.other_detailsList = new ArrayList<StringType>();
          for (StringType i : other_detailsList)
            dst.other_detailsList.add(i.copy());
        };
      }

      protected RESOURCE_DESCRIPTION_ITEM typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RESOURCE_DESCRIPTION_ITEM))
          return false;
        RESOURCE_DESCRIPTION_ITEM o = (RESOURCE_DESCRIPTION_ITEM) other_;
        return compareDeep(language, o.language, true) && compareDeep(purpose, o.purpose, true) && compareDeep(keywordsList, o.keywordsList, true)
           && compareDeep(use, o.use, true) && compareDeep(misuse, o.misuse, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(original_resource_uriList, o.original_resource_uriList, true) && compareDeep(other_detailsList, o.other_detailsList, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RESOURCE_DESCRIPTION_ITEM))
          return false;
        RESOURCE_DESCRIPTION_ITEM o = (RESOURCE_DESCRIPTION_ITEM) other_;
        return compareValues(purpose, o.purpose, true) && compareValues(keywordsList, o.keywordsList, true)
           && compareValues(use, o.use, true) && compareValues(misuse, o.misuse, true) && compareValues(copyright, o.copyright, true)
           && compareValues(original_resource_uriList, o.original_resource_uriList, true) && compareValues(other_detailsList, o.other_detailsList, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(language, purpose, keywordsList
          , use, misuse, copyright, original_resource_uriList, other_detailsList);
      }


}

