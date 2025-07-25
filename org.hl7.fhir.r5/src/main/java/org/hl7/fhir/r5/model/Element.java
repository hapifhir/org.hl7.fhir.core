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
import java.util.List;

import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.exceptions.FHIRException;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;

import org.hl7.fhir.instance.model.api.IBaseElement;
import  org.hl7.fhir.instance.model.api.IBaseHasExtensions;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.FhirPublication;
import  org.hl7.fhir.utilities.StandardsStatus;
/**
 * Element Type: Base definition for all elements in a resource.
 */
@DatatypeDef(name="Element")
public abstract class Element extends Base implements IBaseHasExtensions, IBaseElement {

    /**
     * Unique id for the element within a resource (for internal references). This may be any string value that does not contain spaces.
     */
    @Child(name = "id", type = {StringType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Unique id for inter-element referencing", formalDefinition="Unique id for the element within a resource (for internal references). This may be any string value that does not contain spaces." )
    protected StringType id;

    /**
     * May be used to represent additional information that is not part of the basic definition of the element. To make the use of extensions safe and managable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.
     */
    @Child(name = "extension", type = {Extension.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional content defined by implementations", formalDefinition="May be used to represent additional information that is not part of the basic definition of the element. To make the use of extensions safe and managable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension." )
    protected List<Extension> extension;

    private static final long serialVersionUID = -1452745816L;

  /**
   * Constructor
   */
    public Element() {
      super();
    }

    /**
     * @return {@link #id} (Unique id for the element within a resource (for internal references). This may be any string value that does not contain spaces.). This is the underlying object with id, value and extensions. The accessor "getId" gives direct access to the value
     */
    public StringType getIdElement() { 
      if (this.id == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Element.id");
        else if (Configuration.doAutoCreate())
          this.id = new StringType(); // bb
      return this.id;
    }

    public boolean hasIdElement() { 
      return this.id != null && !this.id.isEmpty();
    }

    public boolean hasId() { 
      return this.id != null && !this.id.isEmpty();
    }

    /**
     * @param value {@link #id} (Unique id for the element within a resource (for internal references). This may be any string value that does not contain spaces.). This is the underlying object with id, value and extensions. The accessor "getId" gives direct access to the value
     */
    public Element setIdElement(StringType value) { 
      this.id = value;
      return this;
    }

    /**
     * @return Unique id for the element within a resource (for internal references). This may be any string value that does not contain spaces.
     */
    public String getId() { 
      return this.id == null ? null : this.id.getValue();
    }

    /**
     * @param value Unique id for the element within a resource (for internal references). This may be any string value that does not contain spaces.
     */
    public Element setId(String value) { 
      if (Utilities.noString(value))
        this.id = null;
      else {
        if (this.id == null)
          this.id = new StringType();
        this.id.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #extension} (May be used to represent additional information that is not part of the basic definition of the element. To make the use of extensions safe and managable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.)
     */
    public List<Extension> getExtension() { 
      if (this.extension == null)
        this.extension = new ArrayList<Extension>();
      return this.extension;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Element setExtension(List<Extension> theExtension) { 
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

    public Element addExtension(Extension t) { //3
      if (t == null)
        return this;
      if (this.extension == null)
        this.extension = new ArrayList<Extension>();
      this.extension.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #extension}, creating it if it does not already exist {3}
     */
    public Extension getExtensionFirstRep() { 
      if (getExtension().isEmpty()) {
        addExtension();
      }
      return getExtension().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("id", "string", "Unique id for the element within a resource (for internal references). This may be any string value that does not contain spaces.", 0, 1, id));
        children.add(new Property("extension", "Extension", "May be used to represent additional information that is not part of the basic definition of the element. To make the use of extensions safe and managable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.", 0, java.lang.Integer.MAX_VALUE, extension));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 3355: /*id*/  return new Property("id", "string", "Unique id for the element within a resource (for internal references). This may be any string value that does not contain spaces.", 0, 1, id);
        case -612557761: /*extension*/  return new Property("extension", "Extension", "May be used to represent additional information that is not part of the basic definition of the element. To make the use of extensions safe and managable, there is a strict set of governance  applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension.", 0, java.lang.Integer.MAX_VALUE, extension);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3355: /*id*/ return this.id == null ? new Base[0] : new Base[] {this.id}; // StringType
        case -612557761: /*extension*/ return this.extension == null ? new Base[0] : this.extension.toArray(new Base[this.extension.size()]); // Extension
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3355: // id
          this.id = TypeConvertor.castToString(value); // StringType
          return value;
        case -612557761: // extension
          this.getExtension().add(TypeConvertor.castToExtension(value)); // Extension
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("id")) {
          this.id = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("extension")) {
          this.getExtension().add(TypeConvertor.castToExtension(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("id")) {
          this.id = null;
        } else if (name.equals("extension")) {
          this.getExtension().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3355:  return getIdElement();
        case -612557761:  return addExtension(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3355: /*id*/ return new String[] {"string"};
        case -612557761: /*extension*/ return new String[] {"Extension"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("id")) {
          throw new FHIRException("Cannot call addChild on a singleton property Element.id");
        }
        else if (name.equals("extension")) {
          return addExtension();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Element";

  }

      public abstract Element copy();

      public void copyValues(Element dst) {
        super.copyValues(dst);
        dst.id = id == null ? null : id.copy();
        if (extension != null) {
          dst.extension = new ArrayList<Extension>();
          for (Extension i : extension)
            dst.extension.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Element))
          return false;
        Element o = (Element) other_;
        return compareDeep(id, o.id, true) && compareDeep(extension, o.extension, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Element))
          return false;
        Element o = (Element) other_;
        return compareValues(id, o.id, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(id, extension);
      }

// Manual code (from Configuration.txt):
 @Override
  public String getIdBase() {
    return getId();
  }
  
  @Override
  public void setIdBase(String value) {
    setId(value);
  }
  
  public void addExtension(String url, DataType value) {
    if (disallowExtensions)
      throw new Error("Extensions are not allowed in this context");
    Extension ex = new Extension();
    ex.setUrl(url);
    ex.setValue(value);
    getExtension().add(ex);    
  }

 
  /**
   * Returns an extension if one (and only one) matches the given URL.
   * 
   * Note: BackboneElements override this to look in matching Modifier Extensions too
   * 
   * @param theUrl The URL. Must not be blank or null.
   * @return the matching extension, or null
   */
   public Extension getExtensionByUrl(String theUrl) {
     org.apache.commons.lang3.Validate.notBlank(theUrl, "theUrl must not be blank or null");
     ArrayList<Extension> retVal = new ArrayList<Extension>();
     for (Extension next : getExtension()) {
       if (theUrl.equals(next.getUrl())) {
         retVal.add(next);
       }
     }
     if (retVal.size() == 0)
       return null;
     else {
       org.apache.commons.lang3.Validate.isTrue(retVal.size() == 1, "Url "+theUrl+" must have only one match");
       return retVal.get(0);
     }
   }
  
   /**
    * Returns an extension if one (and only one) matches the given URL.
    * 
    * Note: BackboneElements override this to look in matching Modifier Extensions too
    * 
    * @param theUrls One or more URLs to match. Must not be blank or null.
    * @return the matching extension, or null
    */
    public Extension getExtensionByUrl(String... theUrls) {
      ArrayList<Extension> retVal = new ArrayList<Extension>();
      for (Extension next : getExtension()) {
        if (Utilities.existsInList(next.getUrl(), theUrls)) {
          retVal.add(next);
        }
      }
      if (retVal.size() == 0)
        return null;
      else {
        org.apache.commons.lang3.Validate.isTrue(retVal.size() == 1, "Url "+CommaSeparatedStringBuilder.join(",", theUrls)+" must have only one match");
        return retVal.get(0);
      }
    }
   
   /**
    * Remove any extensions that match (by given URL).
    * 
    * Note: BackboneElements override this to remove from Modifier Extensions too
    * 
    * @param theUrl The URL. Must not be blank or null.
    */
   public void removeExtension(String theUrl) {
     for (int i = getExtension().size()-1; i >= 0; i--) {
       if (theUrl.equals(getExtension().get(i).getUrl()))
         getExtension().remove(i);
     }
   }
   
   /**
    * This is used in the FHIRPath engine to record that no extensions are allowed for this item in the context in which it is used.
    * todo: enforce this....
    */
    private boolean disallowExtensions;

    public boolean isDisallowExtensions() {
      return disallowExtensions;
    }

    public Element setDisallowExtensions(boolean disallowExtensions) {
      this.disallowExtensions = disallowExtensions;
      return this;
    }

    public Element noExtensions() {
      this.disallowExtensions = true;
      return this;
    }
  
   /**
    * Returns an unmodifiable list containing all extensions on this element which 
    * match the given URL.
    * 
    * Note: BackboneElements override this to add matching Modifier Extensions too
    * 
    * @param theUrl The URL. Must not be blank or null.
    * @return an unmodifiable list containing all extensions on this element which match the given URL
    */
   public List<Extension> getExtensionsByUrl(String theUrl) {
     if (theUrl == null) {
       throw new NullPointerException("theUrl must not be null");
     } else if (theUrl.length() == 0) {
       throw new IllegalArgumentException("theUrl must not be empty");
     }
     ArrayList<Extension> retVal = new ArrayList<>();
     for (Extension next : getExtension()) {
       if (theUrl.equals(next.getUrl())) {
         retVal.add(next);
       }
     }
     return java.util.Collections.unmodifiableList(retVal);
   }
   
   public List<Extension> getExtensionsByUrl(String... theUrls) {
     
     ArrayList<Extension> retVal = new ArrayList<>();
     for (Extension next : getExtension()) {
       if (Utilities.existsInList(next.getUrl(), theUrls)) {
         retVal.add(next);
       }
     }
     return java.util.Collections.unmodifiableList(retVal);
   }
   

   public boolean hasExtension(String... theUrls) {
     for (Extension next : getExtension()) {
       if (Utilities.existsInList(next.getUrl(), theUrls)) {
         return true;
       }
     }
     return false;
   }

   public Base getExtensionValue(String... theUrls) {
     
     for (Extension next : getExtension()) {
       if (Utilities.existsInList(next.getUrl(), theUrls)) {
         return next.getValue();
       }
     }
     return null;
   }

   /**
    * Returns an true if this element has an extension that matchs the given URL.
    * 
    * Note: BackboneElements override this to check Modifier Extensions too
    * 
    * @param theUrl The URL. Must not be blank or null.
    */
   public boolean hasExtension(String theUrl) {
     if (extension == null || extension.size() == 0) {
       return false;
     }

     for (Extension ext : extension) {
       if (theUrl.equals(ext.getUrl())) {
         return true;
       }
     }

     return false;
   }

   /**
    * Returns the value as a string if this element has only one extension that matches the given URL, and that can be converted to a string.
    * 
    * Note: BackboneElements override this to check Modifier Extensions too
    * 
    * @param theUrl The URL. Must not be blank or null.
    */
   public String getExtensionString(String theUrl) throws FHIRException {
     List<Extension> ext = getExtensionsByUrl(theUrl); 
     if (ext.isEmpty()) 
       return null; 
     if (ext.size() > 1) 
       throw new FHIRException("Multiple matching extensions found for extension '"+theUrl+"'");
     if (!ext.get(0).hasValue())
       return null;
     if (!ext.get(0).getValue().isPrimitive())
       throw new FHIRException("Extension '"+theUrl+"' could not be converted to a string");
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


  public StandardsStatus getStandardsStatus() {
    return ExtensionUtilities.getStandardsStatus(this);
  }
  
  public void setStandardsStatus(StandardsStatus status) {
    ExtensionUtilities.setStandardsStatus(this, status, null);
  }

  public boolean hasExtension(Extension ext) {
    if (hasExtension()) {
      for (Extension t : getExtension()) {
        if (Base.compareDeep(t, ext, false)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void copyExtensions(org.hl7.fhir.r5.model.Element src, String... urls) {
    for (Extension e : src.getExtension()) {
      if (Utilities.existsInList(e.getUrl(), urls)) {
        addExtension(e.copy());
      }
    }    
  }

  public void copyNewExtensions(org.hl7.fhir.r5.model.Element src, String... urls) {
    for (Extension e : src.getExtension()) {
      if (Utilities.existsInList(e.getUrl(), urls) && !!hasExtension(e.getUrl())) {
        addExtension(e.copy());
      }
    }    
  }
  

  public FhirPublication getFHIRPublicationVersion() {
    return FhirPublication.R5;
  }
// end addition

}

