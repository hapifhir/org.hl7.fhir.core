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
@DatatypeDef(name="WebTemplate")
public class WebTemplate extends LogicalBase implements ICompositeType {

    /**
     * 
     */
    @Child(name = "templateId", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Operational template ID", formalDefinition="" )
    protected StringType templateId;

    /**
     * 
     */
    @Child(name = "version", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Web template structure version", formalDefinition="" )
    protected StringType version;

    /**
     * 
     */
    @Child(name = "semver", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The semantic version number of the openEHR template", formalDefinition="" )
    protected StringType semver;

    /**
     * 
     */
    @Child(name = "defaultLanguage", type = {StringType.class}, order=3, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Default labels for fields will be in this language", formalDefinition="" )
    protected StringType defaultLanguage;

    /**
     * 
     */
    @Child(name = "languages", type = {StringType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Array of additional languages. Labels for fields and coded texts will also be available in these additional languages, provided that the operational template has them", formalDefinition="" )
    protected List<StringType> languagesList;

    /**
     * 
     */
    @Child(name = "tree", type = {WebTemplateItem.class}, order=5, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Hierarchical structure of nodes each one potentially having further children", formalDefinition="" )
    protected WebTemplateItem tree;

    private static final long serialVersionUID = 1714233507L;

  /**
   * Constructor
   */
    public WebTemplate() {
      super();
    }

  /**
   * Constructor
   */
    public WebTemplate(String templateId, String version, String defaultLanguage, WebTemplateItem tree) {
      super();
      this.setTemplateId(templateId);
      this.setVersion(version);
      this.setDefaultLanguage(defaultLanguage);
      this.setTree(tree);
    }

    /**
     * @return {@link #templateId} (). This is the underlying object with id, value and extensions. The accessor "getTemplateId" gives direct access to the value
     */
    public StringType getTemplateIdElement() { 
      if (this.templateId == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplate.templateId");
        else if (Configuration.doAutoCreate())
          this.templateId = new StringType(); // bb
      return this.templateId;
    }

    public boolean hasTemplateIdElement() { 
      return this.templateId != null && !this.templateId.isEmpty();
    }

    public boolean hasTemplateId() { 
      return this.templateId != null && !this.templateId.isEmpty();
    }

    /**
     * @param value {@link #templateId} (). This is the underlying object with id, value and extensions. The accessor "getTemplateId" gives direct access to the value
     */
    public WebTemplate setTemplateIdElement(StringType value) { 
      this.templateId = value;
      return this;
    }

    /**
     * @return 
     */
    public String getTemplateId() { 
      return this.templateId == null ? null : this.templateId.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplate setTemplateId(String value) { 
        if (this.templateId == null)
          this.templateId = new StringType();
        this.templateId.setValue(value);
      return this;
    }

    /**
     * @return {@link #version} (). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplate.version");
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
     * @param value {@link #version} (). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public WebTemplate setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return 
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplate setVersion(String value) { 
        if (this.version == null)
          this.version = new StringType();
        this.version.setValue(value);
      return this;
    }

    /**
     * @return {@link #semver} (). This is the underlying object with id, value and extensions. The accessor "getSemver" gives direct access to the value
     */
    public StringType getSemverElement() { 
      if (this.semver == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplate.semver");
        else if (Configuration.doAutoCreate())
          this.semver = new StringType(); // bb
      return this.semver;
    }

    public boolean hasSemverElement() { 
      return this.semver != null && !this.semver.isEmpty();
    }

    public boolean hasSemver() { 
      return this.semver != null && !this.semver.isEmpty();
    }

    /**
     * @param value {@link #semver} (). This is the underlying object with id, value and extensions. The accessor "getSemver" gives direct access to the value
     */
    public WebTemplate setSemverElement(StringType value) { 
      this.semver = value;
      return this;
    }

    /**
     * @return 
     */
    public String getSemver() { 
      return this.semver == null ? null : this.semver.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplate setSemver(String value) { 
      if (Utilities.noString(value))
        this.semver = null;
      else {
        if (this.semver == null)
          this.semver = new StringType();
        this.semver.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #defaultLanguage} (). This is the underlying object with id, value and extensions. The accessor "getDefaultLanguage" gives direct access to the value
     */
    public StringType getDefaultLanguageElement() { 
      if (this.defaultLanguage == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplate.defaultLanguage");
        else if (Configuration.doAutoCreate())
          this.defaultLanguage = new StringType(); // bb
      return this.defaultLanguage;
    }

    public boolean hasDefaultLanguageElement() { 
      return this.defaultLanguage != null && !this.defaultLanguage.isEmpty();
    }

    public boolean hasDefaultLanguage() { 
      return this.defaultLanguage != null && !this.defaultLanguage.isEmpty();
    }

    /**
     * @param value {@link #defaultLanguage} (). This is the underlying object with id, value and extensions. The accessor "getDefaultLanguage" gives direct access to the value
     */
    public WebTemplate setDefaultLanguageElement(StringType value) { 
      this.defaultLanguage = value;
      return this;
    }

    /**
     * @return 
     */
    public String getDefaultLanguage() { 
      return this.defaultLanguage == null ? null : this.defaultLanguage.getValue();
    }

    /**
     * @param value 
     */
    public WebTemplate setDefaultLanguage(String value) { 
        if (this.defaultLanguage == null)
          this.defaultLanguage = new StringType();
        this.defaultLanguage.setValue(value);
      return this;
    }

    /**
     * @return {@link #languages} ()
     */
    public List<StringType> getLanguagesList() { 
      if (this.languagesList == null)
        this.languagesList = new ArrayList<StringType>();
      return this.languagesList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public WebTemplate setLanguagesList(List<StringType> theLanguages) { 
      this.languagesList = theLanguages;
      return this;
    }

    public boolean hasLanguages() { 
      if (this.languagesList == null)
        return false;
      for (StringType item : this.languagesList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #languages} ()
     */
    public StringType addLanguagesElement() {//2 
      StringType t = new StringType();
      if (this.languagesList == null)
        this.languagesList = new ArrayList<StringType>();
      this.languagesList.add(t);
      return t;
    }

    /**
     * @param value {@link #languages} ()
     */
    public WebTemplate addLanguages(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.languagesList == null)
        this.languagesList = new ArrayList<StringType>();
      this.languagesList.add(t);
      return this;
    }

    /**
     * @param value {@link #languages} ()
     */
    public boolean hasLanguages(String value) { 
      if (this.languagesList == null)
        return false;
      for (StringType v : this.languagesList)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #tree} ()
     */
    public WebTemplateItem getTree() { 
      if (this.tree == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create WebTemplate.tree");
        else if (Configuration.doAutoCreate())
          this.tree = new WebTemplateItem(); // cc
      return this.tree;
    }

    public boolean hasTree() { 
      return this.tree != null && !this.tree.isEmpty();
    }

    /**
     * @param value {@link #tree} ()
     */
    public WebTemplate setTree(WebTemplateItem value) { 
      this.tree = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("templateId", "string", "", 0, 1, templateId));
        children.add(new Property("version", "string", "", 0, 1, version));
        children.add(new Property("semver", "string", "", 0, 1, semver));
        children.add(new Property("defaultLanguage", "string", "", 0, 1, defaultLanguage));
        children.add(new Property("languages", "string", "", 0, java.lang.Integer.MAX_VALUE, languagesList));
        children.add(new Property("tree", "http://openehr.org/fhir/StructureDefinition/WebTemplateItem", "", 0, 1, tree));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1304010549: /*templateId*/  return new Property("templateId", "string", "", 0, 1, templateId);
        case 351608024: /*version*/  return new Property("version", "string", "", 0, 1, version);
        case -905975448: /*semver*/  return new Property("semver", "string", "", 0, 1, semver);
        case 384498873: /*defaultLanguage*/  return new Property("defaultLanguage", "string", "", 0, 1, defaultLanguage);
        case 1518327835: /*languages*/  return new Property("languages", "string", "", 0, java.lang.Integer.MAX_VALUE, languagesList);
        case 3568542: /*tree*/  return new Property("tree", "http://openehr.org/fhir/StructureDefinition/WebTemplateItem", "", 0, 1, tree);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1304010549: /*templateId*/ return this.templateId == null ? new Base[0] : new Base[] {this.templateId}; // StringType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case -905975448: /*semver*/ return this.semver == null ? new Base[0] : new Base[] {this.semver}; // StringType
        case 384498873: /*defaultLanguage*/ return this.defaultLanguage == null ? new Base[0] : new Base[] {this.defaultLanguage}; // StringType
        case 1518327835: /*languages*/ return this.languagesList == null ? new Base[0] : this.languagesList.toArray(new Base[this.languagesList.size()]); // StringType
        case 3568542: /*tree*/ return this.tree == null ? new Base[0] : new Base[] {this.tree}; // WebTemplateItem
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1304010549: // templateId
          this.templateId = TypeConvertor.castToString(value); // StringType
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case -905975448: // semver
          this.semver = TypeConvertor.castToString(value); // StringType
          return value;
        case 384498873: // defaultLanguage
          this.defaultLanguage = TypeConvertor.castToString(value); // StringType
          return value;
        case 1518327835: // languages
          this.getLanguagesList().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 3568542: // tree
          this.tree = (WebTemplateItem) value; // WebTemplateItem
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("templateId")) {
          this.templateId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("semver")) {
          this.semver = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("defaultLanguage")) {
          this.defaultLanguage = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("languages")) {
          this.getLanguagesList().add(TypeConvertor.castToString(value)); // StringType
        } else if (name.equals("tree")) {
          this.tree = (WebTemplateItem) value; // WebTemplateItem
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1304010549:  return getTemplateIdElement();
        case 351608024:  return getVersionElement();
        case -905975448:  return getSemverElement();
        case 384498873:  return getDefaultLanguageElement();
        case 1518327835:  return addLanguagesElement();
        case 3568542:  return getTree();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1304010549: /*templateId*/ return new String[] {"string"};
        case 351608024: /*version*/ return new String[] {"string"};
        case -905975448: /*semver*/ return new String[] {"string"};
        case 384498873: /*defaultLanguage*/ return new String[] {"string"};
        case 1518327835: /*languages*/ return new String[] {"string"};
        case 3568542: /*tree*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/WebTemplateItem"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("templateId")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplate.templateId");
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplate.version");
        }
        else if (name.equals("semver")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplate.semver");
        }
        else if (name.equals("defaultLanguage")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplate.defaultLanguage");
        }
        else if (name.equals("languages")) {
          throw new FHIRException("Cannot call addChild on a singleton property WebTemplate.languages");
        }
        else if (name.equals("tree")) {
          this.tree = new WebTemplateItem();
          return this.tree;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "WebTemplate";

  }

      public WebTemplate copy() {
        WebTemplate dst = new WebTemplate();
        copyValues(dst);
        return dst;
      }

      public void copyValues(WebTemplate dst) {
        super.copyValues(dst);
        dst.templateId = templateId == null ? null : templateId.copy();
        dst.version = version == null ? null : version.copy();
        dst.semver = semver == null ? null : semver.copy();
        dst.defaultLanguage = defaultLanguage == null ? null : defaultLanguage.copy();
        if (languagesList != null) {
          dst.languagesList = new ArrayList<StringType>();
          for (StringType i : languagesList)
            dst.languagesList.add(i.copy());
        };
        dst.tree = tree == null ? null : tree.copy();
      }

      protected WebTemplate typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof WebTemplate))
          return false;
        WebTemplate o = (WebTemplate) other_;
        return compareDeep(templateId, o.templateId, true) && compareDeep(version, o.version, true) && compareDeep(semver, o.semver, true)
           && compareDeep(defaultLanguage, o.defaultLanguage, true) && compareDeep(languagesList, o.languagesList, true)
           && compareDeep(tree, o.tree, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof WebTemplate))
          return false;
        WebTemplate o = (WebTemplate) other_;
        return compareValues(templateId, o.templateId, true) && compareValues(version, o.version, true) && compareValues(semver, o.semver, true)
           && compareValues(defaultLanguage, o.defaultLanguage, true) && compareValues(languagesList, o.languagesList, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(templateId, version, semver
          , defaultLanguage, languagesList, tree);
      }


}

