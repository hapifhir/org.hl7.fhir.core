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
 * Abstract idea of an online resource created by a human author.
 */
@DatatypeDef(name="AUTHORED_RESOURCE")
public abstract class AUTHORED_RESOURCE extends LogicalBase implements ICompositeType {

    /**
     * Language in which this resource was initially authored. Although there is no language primacy of resources overall, the language of original authoring is required to ensure natural language translations can preserve quality. Language is relevant in both the description and ontology sections.
     */
    @Child(name = "original_language", type = {CODE_PHRASE.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Language in which this resource was initially authored", formalDefinition="Language in which this resource was initially authored. Although there is no language primacy of resources overall, the language of original authoring is required to ensure natural language translations can preserve quality. Language is relevant in both the description and ontology sections." )
    protected CODE_PHRASE original_language;

    /**
     * True if this resource is under any kind of change control (even file copying), in which case revision history is created.
     */
    @Child(name = "is_controlled", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="True if this resource is under any kind of change control (even file copying), in which case revision history is created", formalDefinition="True if this resource is under any kind of change control (even file copying), in which case revision history is created." )
    protected BooleanType is_controlled;

    /**
     * List of details for each natural-language translation made of this resource, keyed by language. For each translation listed here, there must be corresponding sections in all language-dependent parts of the resource. The original_language does not appear in this list.
     */
    @Child(name = "translations", type = {TRANSLATION_DETAILS.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="List of details for each natural-language translation made of this resource, keyed by language", formalDefinition="List of details for each natural-language translation made of this resource, keyed by language. For each translation listed here, there must be corresponding sections in all language-dependent parts of the resource. The original_language does not appear in this list." )
    protected List<TRANSLATION_DETAILS> translationsList;

    /**
     * Description and lifecycle information of the resource.
     */
    @Child(name = "description", type = {RESOURCE_DESCRIPTION.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Description and lifecycle information of the resource", formalDefinition="Description and lifecycle information of the resource." )
    protected RESOURCE_DESCRIPTION description;

    /**
     * The revision history of the resource. Only required if is_controlled = True (avoids large revision histories for informal or private editing situations).
     */
    @Child(name = "revision_history", type = {REVISION_HISTORY.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The revision history of the resource. Only required if is_controlled = True", formalDefinition="The revision history of the resource. Only required if is_controlled = True (avoids large revision histories for informal or private editing situations)." )
    protected REVISION_HISTORY revision_history;

    private static final long serialVersionUID = 673004665L;

  /**
   * Constructor
   */
    public AUTHORED_RESOURCE() {
      super();
    }

  /**
   * Constructor
   */
    public AUTHORED_RESOURCE(CODE_PHRASE original_language) {
      super();
      this.setOriginal_language(original_language);
    }

    /**
     * @return {@link #original_language} (Language in which this resource was initially authored. Although there is no language primacy of resources overall, the language of original authoring is required to ensure natural language translations can preserve quality. Language is relevant in both the description and ontology sections.)
     */
    public CODE_PHRASE getOriginal_language() { 
      if (this.original_language == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AUTHORED_RESOURCE.original_language");
        else if (Configuration.doAutoCreate())
          this.original_language = new CODE_PHRASE(); // cc
      return this.original_language;
    }

    public boolean hasOriginal_language() { 
      return this.original_language != null && !this.original_language.isEmpty();
    }

    /**
     * @param value {@link #original_language} (Language in which this resource was initially authored. Although there is no language primacy of resources overall, the language of original authoring is required to ensure natural language translations can preserve quality. Language is relevant in both the description and ontology sections.)
     */
    public AUTHORED_RESOURCE setOriginal_language(CODE_PHRASE value) { 
      this.original_language = value;
      return this;
    }

    /**
     * @return {@link #is_controlled} (True if this resource is under any kind of change control (even file copying), in which case revision history is created.). This is the underlying object with id, value and extensions. The accessor "getIs_controlled" gives direct access to the value
     */
    public BooleanType getIs_controlledElement() { 
      if (this.is_controlled == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AUTHORED_RESOURCE.is_controlled");
        else if (Configuration.doAutoCreate())
          this.is_controlled = new BooleanType(); // bb
      return this.is_controlled;
    }

    public boolean hasIs_controlledElement() { 
      return this.is_controlled != null && !this.is_controlled.isEmpty();
    }

    public boolean hasIs_controlled() { 
      return this.is_controlled != null && !this.is_controlled.isEmpty();
    }

    /**
     * @param value {@link #is_controlled} (True if this resource is under any kind of change control (even file copying), in which case revision history is created.). This is the underlying object with id, value and extensions. The accessor "getIs_controlled" gives direct access to the value
     */
    public AUTHORED_RESOURCE setIs_controlledElement(BooleanType value) { 
      this.is_controlled = value;
      return this;
    }

    /**
     * @return True if this resource is under any kind of change control (even file copying), in which case revision history is created.
     */
    public boolean getIs_controlled() { 
      return this.is_controlled == null || this.is_controlled.isEmpty() ? false : this.is_controlled.getValue();
    }

    /**
     * @param value True if this resource is under any kind of change control (even file copying), in which case revision history is created.
     */
    public AUTHORED_RESOURCE setIs_controlled(boolean value) { 
        if (this.is_controlled == null)
          this.is_controlled = new BooleanType();
        this.is_controlled.setValue(value);
      return this;
    }

    /**
     * @return {@link #translations} (List of details for each natural-language translation made of this resource, keyed by language. For each translation listed here, there must be corresponding sections in all language-dependent parts of the resource. The original_language does not appear in this list.)
     */
    public List<TRANSLATION_DETAILS> getTranslationsList() { 
      if (this.translationsList == null)
        this.translationsList = new ArrayList<TRANSLATION_DETAILS>();
      return this.translationsList;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AUTHORED_RESOURCE setTranslationsList(List<TRANSLATION_DETAILS> theTranslations) { 
      this.translationsList = theTranslations;
      return this;
    }

    public boolean hasTranslations() { 
      if (this.translationsList == null)
        return false;
      for (TRANSLATION_DETAILS item : this.translationsList)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public TRANSLATION_DETAILS addTranslations() { //3a
      TRANSLATION_DETAILS t = new TRANSLATION_DETAILS();
      if (this.translationsList == null)
        this.translationsList = new ArrayList<TRANSLATION_DETAILS>();
      this.translationsList.add(t);
      return t;
    }

    public AUTHORED_RESOURCE addTranslations(TRANSLATION_DETAILS t) { //3b
      if (t == null)
        return this;
      if (this.translationsList == null)
        this.translationsList = new ArrayList<TRANSLATION_DETAILS>();
      this.translationsList.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #translations}, creating it if it does not already exist {3}
     */
    public TRANSLATION_DETAILS getTranslationsFirstRep() { 
      if (getTranslationsList().isEmpty()) {
        addTranslations();
      }
      return getTranslationsList().get(0);
    }

    /**
     * @return {@link #description} (Description and lifecycle information of the resource.)
     */
    public RESOURCE_DESCRIPTION getDescription() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AUTHORED_RESOURCE.description");
        else if (Configuration.doAutoCreate())
          this.description = new RESOURCE_DESCRIPTION(); // cc
      return this.description;
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (Description and lifecycle information of the resource.)
     */
    public AUTHORED_RESOURCE setDescription(RESOURCE_DESCRIPTION value) { 
      this.description = value;
      return this;
    }

    /**
     * @return {@link #revision_history} (The revision history of the resource. Only required if is_controlled = True (avoids large revision histories for informal or private editing situations).)
     */
    public REVISION_HISTORY getRevision_history() { 
      if (this.revision_history == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AUTHORED_RESOURCE.revision_history");
        else if (Configuration.doAutoCreate())
          this.revision_history = new REVISION_HISTORY(); // cc
      return this.revision_history;
    }

    public boolean hasRevision_history() { 
      return this.revision_history != null && !this.revision_history.isEmpty();
    }

    /**
     * @param value {@link #revision_history} (The revision history of the resource. Only required if is_controlled = True (avoids large revision histories for informal or private editing situations).)
     */
    public AUTHORED_RESOURCE setRevision_history(REVISION_HISTORY value) { 
      this.revision_history = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("original_language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Language in which this resource was initially authored. Although there is no language primacy of resources overall, the language of original authoring is required to ensure natural language translations can preserve quality. Language is relevant in both the description and ontology sections.", 0, 1, original_language));
        children.add(new Property("is_controlled", "boolean", "True if this resource is under any kind of change control (even file copying), in which case revision history is created.", 0, 1, is_controlled));
        children.add(new Property("translations", "http://openehr.org/fhir/StructureDefinition/TRANSLATION-DETAILS", "List of details for each natural-language translation made of this resource, keyed by language. For each translation listed here, there must be corresponding sections in all language-dependent parts of the resource. The original_language does not appear in this list.", 0, java.lang.Integer.MAX_VALUE, translationsList));
        children.add(new Property("description", "http://openehr.org/fhir/StructureDefinition/RESOURCE-DESCRIPTION", "Description and lifecycle information of the resource.", 0, 1, description));
        children.add(new Property("revision_history", "http://openehr.org/fhir/StructureDefinition/REVISION-HISTORY", "The revision history of the resource. Only required if is_controlled = True (avoids large revision histories for informal or private editing situations).", 0, 1, revision_history));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1757722118: /*original_language*/  return new Property("original_language", "http://openehr.org/fhir/StructureDefinition/CODE-PHRASE", "Language in which this resource was initially authored. Although there is no language primacy of resources overall, the language of original authoring is required to ensure natural language translations can preserve quality. Language is relevant in both the description and ontology sections.", 0, 1, original_language);
        case -1352159805: /*is_controlled*/  return new Property("is_controlled", "boolean", "True if this resource is under any kind of change control (even file copying), in which case revision history is created.", 0, 1, is_controlled);
        case -1225497630: /*translations*/  return new Property("translations", "http://openehr.org/fhir/StructureDefinition/TRANSLATION-DETAILS", "List of details for each natural-language translation made of this resource, keyed by language. For each translation listed here, there must be corresponding sections in all language-dependent parts of the resource. The original_language does not appear in this list.", 0, java.lang.Integer.MAX_VALUE, translationsList);
        case -1724546052: /*description*/  return new Property("description", "http://openehr.org/fhir/StructureDefinition/RESOURCE-DESCRIPTION", "Description and lifecycle information of the resource.", 0, 1, description);
        case -1037551568: /*revision_history*/  return new Property("revision_history", "http://openehr.org/fhir/StructureDefinition/REVISION-HISTORY", "The revision history of the resource. Only required if is_controlled = True (avoids large revision histories for informal or private editing situations).", 0, 1, revision_history);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1757722118: /*original_language*/ return this.original_language == null ? new Base[0] : new Base[] {this.original_language}; // CODE_PHRASE
        case -1352159805: /*is_controlled*/ return this.is_controlled == null ? new Base[0] : new Base[] {this.is_controlled}; // BooleanType
        case -1225497630: /*translations*/ return this.translationsList == null ? new Base[0] : this.translationsList.toArray(new Base[this.translationsList.size()]); // TRANSLATION_DETAILS
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // RESOURCE_DESCRIPTION
        case -1037551568: /*revision_history*/ return this.revision_history == null ? new Base[0] : new Base[] {this.revision_history}; // REVISION_HISTORY
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1757722118: // original_language
          this.original_language = (CODE_PHRASE) value; // CODE_PHRASE
          return value;
        case -1352159805: // is_controlled
          this.is_controlled = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1225497630: // translations
          this.getTranslationsList().add((TRANSLATION_DETAILS) value); // TRANSLATION_DETAILS
          return value;
        case -1724546052: // description
          this.description = (RESOURCE_DESCRIPTION) value; // RESOURCE_DESCRIPTION
          return value;
        case -1037551568: // revision_history
          this.revision_history = (REVISION_HISTORY) value; // REVISION_HISTORY
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("original_language")) {
          this.original_language = (CODE_PHRASE) value; // CODE_PHRASE
        } else if (name.equals("is_controlled")) {
          this.is_controlled = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("translations")) {
          this.getTranslationsList().add((TRANSLATION_DETAILS) value); // TRANSLATION_DETAILS
        } else if (name.equals("description")) {
          this.description = (RESOURCE_DESCRIPTION) value; // RESOURCE_DESCRIPTION
        } else if (name.equals("revision_history")) {
          this.revision_history = (REVISION_HISTORY) value; // REVISION_HISTORY
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1757722118:  return getOriginal_language();
        case -1352159805:  return getIs_controlledElement();
        case -1225497630:  return addTranslations(); 
        case -1724546052:  return getDescription();
        case -1037551568:  return getRevision_history();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1757722118: /*original_language*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/CODE-PHRASE"};
        case -1352159805: /*is_controlled*/ return new String[] {"boolean"};
        case -1225497630: /*translations*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/TRANSLATION-DETAILS"};
        case -1724546052: /*description*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/RESOURCE-DESCRIPTION"};
        case -1037551568: /*revision_history*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/REVISION-HISTORY"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("original_language")) {
          this.original_language = new CODE_PHRASE();
          return this.original_language;
        }
        else if (name.equals("is_controlled")) {
          throw new FHIRException("Cannot call addChild on a singleton property AUTHORED_RESOURCE.is_controlled");
        }
        else if (name.equals("translations")) {
          return addTranslations();
        }
        else if (name.equals("description")) {
          this.description = new RESOURCE_DESCRIPTION();
          return this.description;
        }
        else if (name.equals("revision_history")) {
          this.revision_history = new REVISION_HISTORY();
          return this.revision_history;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "AUTHORED_RESOURCE";

  }

      public abstract AUTHORED_RESOURCE copy();

      public void copyValues(AUTHORED_RESOURCE dst) {
        super.copyValues(dst);
        dst.original_language = original_language == null ? null : original_language.copy();
        dst.is_controlled = is_controlled == null ? null : is_controlled.copy();
        if (translationsList != null) {
          dst.translationsList = new ArrayList<TRANSLATION_DETAILS>();
          for (TRANSLATION_DETAILS i : translationsList)
            dst.translationsList.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        dst.revision_history = revision_history == null ? null : revision_history.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AUTHORED_RESOURCE))
          return false;
        AUTHORED_RESOURCE o = (AUTHORED_RESOURCE) other_;
        return compareDeep(original_language, o.original_language, true) && compareDeep(is_controlled, o.is_controlled, true)
           && compareDeep(translationsList, o.translationsList, true) && compareDeep(description, o.description, true)
           && compareDeep(revision_history, o.revision_history, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AUTHORED_RESOURCE))
          return false;
        AUTHORED_RESOURCE o = (AUTHORED_RESOURCE) other_;
        return compareValues(is_controlled, o.is_controlled, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(original_language, is_controlled
          , translationsList, description, revision_history);
      }


}

