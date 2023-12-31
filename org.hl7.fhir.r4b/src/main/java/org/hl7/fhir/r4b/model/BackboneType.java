package org.hl7.fhir.r4b.model;

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

// Generated on Tue, Dec 28, 2021 07:16+1100 for FHIR v5.0.0-snapshot1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.r4b.model.Enumerations.*;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Base StructureDefinition for BackboneType Type: Base definition for the few
 * data types that are allowed to carry modifier extensions.
 */
@DatatypeDef(name = "BackboneType")
public abstract class BackboneType extends DataType implements IBaseBackboneElement {

  /**
   * May be used to represent additional information that is not part of the basic
   * definition of the element and that modifies the understanding of the element
   * in which it is contained and/or the understanding of the containing element's
   * descendants. Usually modifier elements provide negation or qualification. To
   * make the use of extensions safe and manageable, there is a strict set of
   * governance applied to the definition and use of extensions. Though any
   * implementer can define an extension, there is a set of requirements that
   * SHALL be met as part of the definition of the extension. Applications
   * processing a resource are required to check for modifier extensions.
   * 
   * Modifier extensions SHALL NOT change the meaning of any elements on Resource
   * or DomainResource (including cannot change the meaning of modifierExtension
   * itself).
   */
  @Child(name = "modifierExtension", type = {
      Extension.class }, order = 0, min = 0, max = Child.MAX_UNLIMITED, modifier = true, summary = true)
  @Description(shortDefinition = "Extensions that cannot be ignored even if unrecognized", formalDefinition = "May be used to represent additional information that is not part of the basic definition of the element and that modifies the understanding of the element in which it is contained and/or the understanding of the containing element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension. Applications processing a resource are required to check for modifier extensions.\n\nModifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot change the meaning of modifierExtension itself).")
  protected List<Extension> modifierExtension;

  private static final long serialVersionUID = -1431673179L;

  /**
   * Constructor
   */
  public BackboneType() {
    super();
  }

  /**
   * @return {@link #modifierExtension} (May be used to represent additional
   *         information that is not part of the basic definition of the element
   *         and that modifies the understanding of the element in which it is
   *         contained and/or the understanding of the containing element's
   *         descendants. Usually modifier elements provide negation or
   *         qualification. To make the use of extensions safe and manageable,
   *         there is a strict set of governance applied to the definition and use
   *         of extensions. Though any implementer can define an extension, there
   *         is a set of requirements that SHALL be met as part of the definition
   *         of the extension. Applications processing a resource are required to
   *         check for modifier extensions.
   * 
   *         Modifier extensions SHALL NOT change the meaning of any elements on
   *         Resource or DomainResource (including cannot change the meaning of
   *         modifierExtension itself).)
   */
  public List<Extension> getModifierExtension() {
    if (this.modifierExtension == null)
      this.modifierExtension = new ArrayList<Extension>();
    return this.modifierExtension;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public BackboneType setModifierExtension(List<Extension> theModifierExtension) {
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

  public Extension addModifierExtension() { // 3
    Extension t = new Extension();
    if (this.modifierExtension == null)
      this.modifierExtension = new ArrayList<Extension>();
    this.modifierExtension.add(t);
    return t;
  }

  public BackboneType addModifierExtension(Extension t) { // 3
    if (t == null)
      return this;
    if (this.modifierExtension == null)
      this.modifierExtension = new ArrayList<Extension>();
    this.modifierExtension.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #modifierExtension},
   *         creating it if it does not already exist {3}
   */
  public Extension getModifierExtensionFirstRep() {
    if (getModifierExtension().isEmpty()) {
      addModifierExtension();
    }
    return getModifierExtension().get(0);
  }

  protected void listChildren(List<Property> children) {
    super.listChildren(children);
    children.add(new Property("modifierExtension", "Extension",
        "May be used to represent additional information that is not part of the basic definition of the element and that modifies the understanding of the element in which it is contained and/or the understanding of the containing element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension. Applications processing a resource are required to check for modifier extensions.\n\nModifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot change the meaning of modifierExtension itself).",
        0, java.lang.Integer.MAX_VALUE, modifierExtension));
  }

  @Override
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    switch (_hash) {
    case -298878168:
      /* modifierExtension */ return new Property("modifierExtension", "Extension",
          "May be used to represent additional information that is not part of the basic definition of the element and that modifies the understanding of the element in which it is contained and/or the understanding of the containing element's descendants. Usually modifier elements provide negation or qualification. To make the use of extensions safe and manageable, there is a strict set of governance applied to the definition and use of extensions. Though any implementer can define an extension, there is a set of requirements that SHALL be met as part of the definition of the extension. Applications processing a resource are required to check for modifier extensions.\n\nModifier extensions SHALL NOT change the meaning of any elements on Resource or DomainResource (including cannot change the meaning of modifierExtension itself).",
          0, java.lang.Integer.MAX_VALUE, modifierExtension);
    default:
      return super.getNamedProperty(_hash, _name, _checkValid);
    }

  }

  @Override
  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    switch (hash) {
    case -298878168:
      /* modifierExtension */ return this.modifierExtension == null ? new Base[0]
          : this.modifierExtension.toArray(new Base[this.modifierExtension.size()]); // Extension
    default:
      return super.getProperty(hash, name, checkValid);
    }

  }

  @Override
  public Base setProperty(int hash, String name, Base value) throws FHIRException {
    switch (hash) {
    case -298878168: // modifierExtension
      this.getModifierExtension().add(TypeConvertor.castToExtension(value)); // Extension
      return value;
    default:
      return super.setProperty(hash, name, value);
    }

  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    if (name.equals("modifierExtension")) {
      this.getModifierExtension().add(TypeConvertor.castToExtension(value));
    } else
      return super.setProperty(name, value);
    return value;
  }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
    if (name.equals("modifierExtension")) {
      this.getModifierExtension().remove(value);
    } else
      super.removeChild(name, value);
    
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case -298878168:
      return addModifierExtension();
    default:
      return super.makeProperty(hash, name);
    }

  }

  @Override
  public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case -298878168:
      /* modifierExtension */ return new String[] { "Extension" };
    default:
      return super.getTypesForProperty(hash, name);
    }

  }

  @Override
  public Base addChild(String name) throws FHIRException {
    if (name.equals("modifierExtension")) {
      return addModifierExtension();
    } else
      return super.addChild(name);
  }

  public String fhirType() {
    return "BackboneType";

  }

  public abstract BackboneType copy();

  public void copyValues(BackboneType dst) {
    super.copyValues(dst);
    if (modifierExtension != null) {
      dst.modifierExtension = new ArrayList<Extension>();
      for (Extension i : modifierExtension)
        dst.modifierExtension.add(i.copy());
    }
    ;
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_))
      return false;
    if (!(other_ instanceof BackboneType))
      return false;
    BackboneType o = (BackboneType) other_;
    return compareDeep(modifierExtension, o.modifierExtension, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_))
      return false;
    if (!(other_ instanceof BackboneType))
      return false;
    BackboneType o = (BackboneType) other_;
    return true;
  }

  public boolean isEmpty() {
    return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(modifierExtension);
  }

// Manual code (from Configuration.txt):
  public void checkNoModifiers(String noun, String verb) throws FHIRException {
    if (hasModifierExtension()) {
      throw new FHIRException("Found unknown Modifier Exceptions on " + noun + " doing " + verb);
    }

  }

   public void copyExtensions(org.hl7.fhir.r4b.model.BackboneElement src, String... urls) {
     super.copyExtensions(src,urls);
     for (Extension e : src.getModifierExtension()) {
       if (Utilities.existsInList(e.getUrl(), urls)) {
         addModifierExtension(e.copy());
       }
     }    
   }

   public List<Extension> getExtensionsByUrl(String... theUrls) {

     ArrayList<Extension> retVal = new ArrayList<>();
     for (Extension next : getModifierExtension()) {
       if (Utilities.existsInList(next.getUrl(), theUrls)) {
         retVal.add(next);
       }
     }
     retVal.addAll(super.getExtensionsByUrl(theUrls));
     return java.util.Collections.unmodifiableList(retVal);
   }
   

   public boolean hasExtension(String... theUrls) {
     for (Extension next : getModifierExtension()) {
       if (Utilities.existsInList(next.getUrl(), theUrls)) {
         return true;
       }
     }
     return super.hasExtension(theUrls);
   }


   public boolean hasExtension(String theUrl) {
     for (Extension ext : getModifierExtension()) {
       if (theUrl.equals(ext.getUrl())) {
         return true;
       }
     }

     return super.hasExtension(theUrl);
   }


   public void copyNewExtensions(org.hl7.fhir.r4b.model.BackboneElement src, String... urls) {
     for (Extension e : src.getModifierExtension()) {
       if (Utilities.existsInList(e.getUrl(), urls) && !!hasExtension(e.getUrl())) {
         addExtension(e.copy());
       }
     }    
     super.copyNewExtensions(src, urls);
   }
// end addition

}
