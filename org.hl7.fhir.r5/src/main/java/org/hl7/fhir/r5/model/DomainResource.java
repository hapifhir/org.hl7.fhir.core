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

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseHasExtensions;
import org.hl7.fhir.instance.model.api.IBaseHasModifierExtensions;
import org.hl7.fhir.instance.model.api.IDomainResource;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;

import org.hl7.fhir.utilities.StandardsStatus;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
/**
 * A resource that includes narrative, extensions, and contained resources.
 */
public abstract class DomainResource extends Resource implements IBaseHasExtensions, IBaseHasModifierExtensions, IDomainResource {

    /**
     * A human-readable narrative that contains a summary of the resource and can be used to represent the content of the resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient detail to make it "clinically safe" for a human to just read the narrative. Resource definitions may define what content should be represented in the narrative to ensure clinical safety.
     */
    @Child(name = "text", type = {Narrative.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Text summary of the resource, for human interpretation", formalDefinition="A human-readable narrative that contains a summary of the resource and can be used to represent the content of the resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient detail to make it \"clinically safe\" for a human to just read the narrative. Resource definitions may define what content should be represented in the narrative to ensure clinical safety." )
    protected Narrative text;

    /**
     * These resources do not have an independent existence apart from the resource that contains them - they cannot be identified independently, nor can they have their own independent transaction scope. This is allowed to be a Parameters resource if and only if it is referenced by a resource that provides context/meaning.
     */
    @Child(name = "contained", type = {Resource.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Contained, inline Resources", formalDefinition="These resources do not have an independent existence apart from the resource that contains them - they cannot be identified independently, nor can they have their own independent transaction scope. This is allowed to be a Parameters resource if and only if it is referenced by a resource that provides context/meaning." )
    protected List<Resource> contained;

    /**
     * May be used to represent additional information that is not part of the basic definition of the resource. To make the use of extensions safe and managable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.
     */
    @Child(name = "extension", type = {Extension.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional content defined by implementations", formalDefinition="May be used to represent additional information that is not part of the basic definition of the resource. To make the use of extensions safe and managable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension." )
    protected List<Extension> extension;

    /**
     * May be used to represent additional information that is not part of the basic definition of the resource and that modifies the understanding of the element that contains it and/or the understanding of the containing element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and managable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension. Applications processing a resource are required to check for modifier extensions.

Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot change the meaning of modifierExtension itself).
     */
    @Child(name = "modifierExtension", type = {Extension.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=true, summary=true)
    @Description(shortDefinition="Extensions that cannot be ignored", formalDefinition="May be used to represent additional information that is not part of the basic definition of the resource and that modifies the understanding of the element that contains it and/or the understanding of the containing element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and managable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension. Applications processing a resource are required to check for modifier extensions.\n\nModifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot change the meaning of modifierExtension itself)." )
    protected List<Extension> modifierExtension;

    private static final long serialVersionUID = -970285559L;

  /**
   * Constructor
   */
    public DomainResource() {
      super();
    }

    /**
     * @return {@link #text} (A human-readable narrative that contains a summary of the resource and can be used to represent the content of the resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient detail to make it "clinically safe" for a human to just read the narrative. Resource definitions may define what content should be represented in the narrative to ensure clinical safety.)
     */
    public Narrative getText() { 
      if (this.text == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DomainResource.text");
        else if (Configuration.doAutoCreate())
          this.text = new Narrative(); // cc
      return this.text;
    }

    public boolean hasText() { 
      return this.text != null && !this.text.isEmpty();
    }

    /**
     * @param value {@link #text} (A human-readable narrative that contains a summary of the resource and can be used to represent the content of the resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient detail to make it "clinically safe" for a human to just read the narrative. Resource definitions may define what content should be represented in the narrative to ensure clinical safety.)
     */
    public DomainResource setText(Narrative value) { 
      this.text = value;
      return this;
    }

    /**
     * @return {@link #contained} (These resources do not have an independent existence apart from the resource that contains them - they cannot be identified independently, nor can they have their own independent transaction scope. This is allowed to be a Parameters resource if and only if it is referenced by a resource that provides context/meaning.)
     */
    public List<Resource> getContained() { 
      if (this.contained == null)
        this.contained = new ArrayList<Resource>();
      return this.contained;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DomainResource setContained(List<Resource> theContained) { 
      this.contained = theContained;
      return this;
    }

    public boolean hasContained() { 
      if (this.contained == null)
        return false;
      for (Resource item : this.contained)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DomainResource addContained(Resource t) { //3
      if (t == null)
        return this;
      if (this.contained == null)
        this.contained = new ArrayList<Resource>();
      this.contained.add(t);
      return this;
    }

    /**
     * @return {@link #extension} (May be used to represent additional information that is not part of the basic definition of the resource. To make the use of extensions safe and managable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.)
     */
    public List<Extension> getExtension() { 
      if (this.extension == null)
        this.extension = new ArrayList<Extension>();
      return this.extension;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DomainResource setExtension(List<Extension> theExtension) { 
      this.extension = theExtension;
      return this;
    }

    public boolean hasExtension() {
      if (this.extension == null)
        return false;
      for (Extension item : this.extension)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Extension addExtension() { //3
      Extension t = new Extension();
      if (this.extension == null)
        this.extension = new ArrayList<Extension>();
      this.extension.add(t);
      return t;
    }

    public DomainResource addExtension(Extension t) { //3
      if (t == null)
        return this;
      if (this.extension == null)
        this.extension = new ArrayList<Extension>();
      this.extension.add(t);
      return this;
    }

    /**
     * @return {@link #modifierExtension} (May be used to represent additional information that is not part of the basic definition of the resource and that modifies the understanding of the element that contains it and/or the understanding of the containing element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and managable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension. Applications processing a resource are required to check for modifier extensions.

Modifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot change the meaning of modifierExtension itself).)
     */
    public List<Extension> getModifierExtension() { 
      if (this.modifierExtension == null)
        this.modifierExtension = new ArrayList<Extension>();
      return this.modifierExtension;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DomainResource setModifierExtension(List<Extension> theModifierExtension) { 
      this.modifierExtension = theModifierExtension;
      return this;
    }

    public boolean hasModifierExtension() { 
      if (this.modifierExtension == null)
        return false;
      for (Extension item : this.modifierExtension)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Extension addModifierExtension() { //3
      Extension t = new Extension();
      if (this.modifierExtension == null)
        this.modifierExtension = new ArrayList<Extension>();
      this.modifierExtension.add(t);
      return t;
    }

    public DomainResource addModifierExtension(Extension t) { //3
      if (t == null)
        return this;
      if (this.modifierExtension == null)
        this.modifierExtension = new ArrayList<Extension>();
      this.modifierExtension.add(t);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("text", "Narrative", "A human-readable narrative that contains a summary of the resource and can be used to represent the content of the resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient detail to make it \"clinically safe\" for a human to just read the narrative. Resource definitions may define what content should be represented in the narrative to ensure clinical safety.", 0, 1, text));
        children.add(new Property("contained", "Resource", "These resources do not have an independent existence apart from the resource that contains them - they cannot be identified independently, nor can they have their own independent transaction scope. This is allowed to be a Parameters resource if and only if it is referenced by a resource that provides context/meaning.", 0, java.lang.Integer.MAX_VALUE, contained));
        children.add(new Property("extension", "Extension", "May be used to represent additional information that is not part of the basic definition of the resource. To make the use of extensions safe and managable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.", 0, java.lang.Integer.MAX_VALUE, extension));
        children.add(new Property("modifierExtension", "Extension", "May be used to represent additional information that is not part of the basic definition of the resource and that modifies the understanding of the element that contains it and/or the understanding of the containing element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and managable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension. Applications processing a resource are required to check for modifier extensions.\n\nModifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot change the meaning of modifierExtension itself).", 0, java.lang.Integer.MAX_VALUE, modifierExtension));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3556653: /*text*/  return new Property("text", "Narrative", "A human-readable narrative that contains a summary of the resource and can be used to represent the content of the resource to a human. The narrative need not encode all the structured data, but is required to contain sufficient detail to make it \"clinically safe\" for a human to just read the narrative. Resource definitions may define what content should be represented in the narrative to ensure clinical safety.", 0, 1, text);
        case -410956685: /*contained*/  return new Property("contained", "Resource", "These resources do not have an independent existence apart from the resource that contains them - they cannot be identified independently, nor can they have their own independent transaction scope. This is allowed to be a Parameters resource if and only if it is referenced by a resource that provides context/meaning.", 0, java.lang.Integer.MAX_VALUE, contained);
        case -612557761: /*extension*/  return new Property("extension", "Extension", "May be used to represent additional information that is not part of the basic definition of the resource. To make the use of extensions safe and managable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.", 0, java.lang.Integer.MAX_VALUE, extension);
        case -298878168: /*modifierExtension*/  return new Property("modifierExtension", "Extension", "May be used to represent additional information that is not part of the basic definition of the resource and that modifies the understanding of the element that contains it and/or the understanding of the containing element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and managable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer is allowed to define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension. Applications processing a resource are required to check for modifier extensions.\n\nModifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot change the meaning of modifierExtension itself).", 0, java.lang.Integer.MAX_VALUE, modifierExtension);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3556653: /*text*/ return this.text == null ? new Base[0] : new Base[] {this.text}; // Narrative
        case -410956685: /*contained*/ return this.contained == null ? new Base[0] : this.contained.toArray(new Base[this.contained.size()]); // Resource
        case -612557761: /*extension*/ return this.extension == null ? new Base[0] : this.extension.toArray(new Base[this.extension.size()]); // Extension
        case -298878168: /*modifierExtension*/ return this.modifierExtension == null ? new Base[0] : this.modifierExtension.toArray(new Base[this.modifierExtension.size()]); // Extension
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3556653: // text
          this.text = TypeConvertor.castToNarrative(value); // Narrative
          return value;
        case -410956685: // contained
          this.getContained().add(TypeConvertor.castToResource(value)); // Resource
          return value;
        case -612557761: // extension
          this.getExtension().add(TypeConvertor.castToExtension(value)); // Extension
          return value;
        case -298878168: // modifierExtension
          this.getModifierExtension().add(TypeConvertor.castToExtension(value)); // Extension
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("text")) {
          this.text = TypeConvertor.castToNarrative(value); // Narrative
        } else if (name.equals("contained")) {
          this.getContained().add(TypeConvertor.castToResource(value));
        } else if (name.equals("extension")) {
          this.getExtension().add(TypeConvertor.castToExtension(value));
        } else if (name.equals("modifierExtension")) {
          this.getModifierExtension().add(TypeConvertor.castToExtension(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("text")) {
          this.text = null;
        } else if (name.equals("contained")) {
          this.getContained().remove(value);
        } else if (name.equals("extension")) {
          this.getExtension().remove(value);
        } else if (name.equals("modifierExtension")) {
          this.getModifierExtension().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3556653:  return getText();
        case -410956685: throw new FHIRException("Cannot make property contained as it is not a complex type"); // Resource
        case -612557761:  return addExtension(); 
        case -298878168:  return addModifierExtension(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3556653: /*text*/ return new String[] {"Narrative"};
        case -410956685: /*contained*/ return new String[] {"Resource"};
        case -612557761: /*extension*/ return new String[] {"Extension"};
        case -298878168: /*modifierExtension*/ return new String[] {"Extension"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("text")) {
          this.text = new Narrative();
          return this.text;
        }
        else if (name.equals("contained")) {
          throw new FHIRException("Cannot call addChild on an abstract type DomainResource.contained");
        }
        else if (name.equals("extension")) {
          return addExtension();
        }
        else if (name.equals("modifierExtension")) {
          return addModifierExtension();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DomainResource";

  }

      public abstract DomainResource copy();

      public void copyValues(DomainResource dst) {
        super.copyValues(dst);
        dst.text = text == null ? null : text.copy();
        if (contained != null) {
          dst.contained = new ArrayList<Resource>();
          for (Resource i : contained)
            dst.contained.add(i.copy());
        };
        if (extension != null) {
          dst.extension = new ArrayList<Extension>();
          for (Extension i : extension)
            dst.extension.add(i.copy());
        };
        if (modifierExtension != null) {
          dst.modifierExtension = new ArrayList<Extension>();
          for (Extension i : modifierExtension)
            dst.modifierExtension.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DomainResource))
          return false;
        DomainResource o = (DomainResource) other_;
        return compareDeep(text, o.text, true) && compareDeep(contained, o.contained, true) && compareDeep(extension, o.extension, true)
           && compareDeep(modifierExtension, o.modifierExtension, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DomainResource))
          return false;
        DomainResource o = (DomainResource) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(text, contained, extension
          , modifierExtension);
      }

 /**
   * Search parameter: <b>_text</b>
   * <p>
   * Description: <b>Search on the narrative of the resource</b><br>
   * Type: <b>special</b><br>
   * Path: <b>null</b><br>
   * </p>
   */
  @SearchParamDefinition(name="_text", path="", description="Search on the narrative of the resource", type="special" )
  public static final String SP_TEXT = "_text";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>_text</b>
   * <p>
   * Description: <b>Search on the narrative of the resource</b><br>
   * Type: <b>special</b><br>
   * Path: <b>null</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.SpecialClientParam TEXT = new ca.uhn.fhir.rest.gclient.SpecialClientParam(SP_TEXT);

// Manual code (from Configuration.txt):
public void checkNoModifiers(String noun, String verb) throws FHIRException {
  if (hasModifierExtension()) {
    throw new FHIRException("Found unknown Modifier Exceptions on " + noun + " doing " + verb);
  }

}

  public void addExtension(String url, DataType value) {
    Extension ex = new Extension();
    ex.setUrl(url);
    ex.setValue(value);
    getExtension().add(ex);
  }

  public boolean hasExtension(String... theUrls) {
    for (Extension next : getModifierExtension()) {
      if (Utilities.existsInList(next.getUrl(), theUrls)) {
        return true;
      }
    }
    for (Extension next : getExtension()) {
      if (Utilities.existsInList(next.getUrl(), theUrls)) {
        return true;
      }
    }
    return false;
  }

  public boolean hasExtension(String url) {
    for (Extension next : getModifierExtension()) {
      if (url.equals(next.getUrl())) {
        return true;
      }
    }
    for (Extension e : getExtension())
      if (url.equals(e.getUrl()))
        return true;
    return false;
  }

  public Extension getExtensionByUrl(String theUrl) {
    org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must not be blank or null");
    ArrayList<Extension> retVal = new ArrayList<Extension>();

    for (Extension next : getExtension()) {
      if (theUrl.equals(next.getUrl())) {
        retVal.add(next);
      }
    }

    for (Extension next : getModifierExtension()) {
      if (theUrl.equals(next.getUrl())) {
        retVal.add(next);
      }
    }
    if (retVal.size() == 0)
      return null;
    else {
      org.apache.commons.lang3.Validate.isTrue(retVal.size() == 1, "Url " + theUrl + " must have only one match");
      return retVal.get(0);
    }
  }


  /**
   * Returns the value as a string if this element has only one extension that matches the given URL, and that can be converted to a string.
   * <p>
   * Note: BackboneElements override this to check Modifier Extensions too
   *
   * @param theUrl The URL. Must not be blank or null.
   */
  public String getExtensionString(String theUrl) throws FHIRException {
    List<Extension> ext = getExtensionsByUrl(theUrl);
    if (ext.isEmpty())
      return null;
    if (ext.size() > 1)
      throw new FHIRException("Multiple matching extensions found for extension '" + theUrl + "'");
    if (!ext.get(0).hasValue())
      return null;
    if (!ext.get(0).getValue().isPrimitive())
      throw new FHIRException("Extension '" + theUrl + "' could not be converted to a string");
    return ext.get(0).getValue().primitiveValue();
  }

  public String getExtensionString(String... theUrls) throws FHIRException {
    for (String url : theUrls) {
      if (hasExtension(url)) {
        return getExtensionString(url);
      }
    }
    return null;
  }


  public Resource getContained(String ref) {
    if (ref == null)
      return null;

    if (ref.startsWith("#"))
      ref = ref.substring(1);
    for (Resource r : getContained()) {
      if (r.getId().equals(ref))
        return r;
    }
    return null;
  }

  /**
   * Returns a list of extensions from this element which have the given URL. Note that
   * this list may not be modified (you can not add or remove elements from it)
   */
  public List<Extension> getExtensionsByUrl(String theUrl) {
    org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must be provided with a value");
    ArrayList<Extension> retVal = new ArrayList<Extension>();
    for (Extension next : getExtension()) {
      if (theUrl.equals(next.getUrl())) {
        retVal.add(next);
      }
    }
    for (Extension next : getModifierExtension()) {
      if (theUrl.equals(next.getUrl())) {
        retVal.add(next);
      }
    }
    return Collections.unmodifiableList(retVal);
  }


  public List<Extension> getExtensionsByUrl(String... theUrls) {
    ArrayList<Extension> retVal = new ArrayList<>();

    for (Extension next : getExtension()) {
      if (Utilities.existsInList(next.getUrl(), theUrls)) {
        retVal.add(next);
      }
    }
    for (Extension next : getModifierExtension()) {
      if (Utilities.existsInList(next.getUrl(), theUrls)) {
        retVal.add(next);
      }
    }
    return java.util.Collections.unmodifiableList(retVal);
  }

  /**
   * Returns a list of modifier extensions from this element which have the given URL. Note that
   * this list may not be modified (you can not add or remove elements from it)
   */
  public List<Extension> getModifierExtensionsByUrl(String theUrl) {
    org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must be provided with a value");
    ArrayList<Extension> retVal = new ArrayList<Extension>();
    for (Extension next : getModifierExtension()) {
      if (theUrl.equals(next.getUrl())) {
        retVal.add(next);
      }
    }
    return Collections.unmodifiableList(retVal);
  }


  public StandardsStatus getStandardsStatus() {
    return ExtensionUtilities.getStandardsStatus(this);
  }

  public void setStandardsStatus(StandardsStatus status) {
    ExtensionUtilities.setStandardsStatus(this, status, null);
  }

    
// end addition

}

