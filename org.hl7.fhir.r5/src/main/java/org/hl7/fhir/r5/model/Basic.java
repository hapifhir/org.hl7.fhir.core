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

// Generated on Fri, Jul 15, 2022 11:20+1000 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Basic is used for handling concepts not yet defined in FHIR, narrative-only resources that don't map to an existing resource, and custom resources not appropriate for inclusion in the FHIR specification.
 */
@ResourceDef(name="Basic", profile="http://hl7.org/fhir/StructureDefinition/Basic")
public class Basic extends DomainResource {

    /**
     * Identifier assigned to the resource for business purposes, outside the context of FHIR.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier", formalDefinition="Identifier assigned to the resource for business purposes, outside the context of FHIR." )
    protected List<Identifier> identifier;

    /**
     * Identifies the 'type' of resource - equivalent to the resource name for other resources.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="Kind of Resource", formalDefinition="Identifies the 'type' of resource - equivalent to the resource name for other resources." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/basic-resource-type")
    protected CodeableConcept code;

    /**
     * Identifies the patient, practitioner, device or any other resource that is the "focus" of this resource.
     */
    @Child(name = "subject", type = {Reference.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Identifies the focus of this resource", formalDefinition="Identifies the patient, practitioner, device or any other resource that is the \"focus\" of this resource." )
    protected Reference subject;

    /**
     * Identifies when the resource was first created.
     */
    @Child(name = "created", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When created", formalDefinition="Identifies when the resource was first created." )
    protected DateTimeType created;

    /**
     * Indicates who was responsible for creating the resource instance.
     */
    @Child(name = "author", type = {Practitioner.class, PractitionerRole.class, Patient.class, RelatedPerson.class, Organization.class, Device.class, CareTeam.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who created", formalDefinition="Indicates who was responsible for creating the resource instance." )
    protected Reference author;

    private static final long serialVersionUID = -1635508686L;

  /**
   * Constructor
   */
    public Basic() {
      super();
    }

  /**
   * Constructor
   */
    public Basic(CodeableConcept code) {
      super();
      this.setCode(code);
    }

    /**
     * @return {@link #identifier} (Identifier assigned to the resource for business purposes, outside the context of FHIR.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Basic setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public Basic addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #code} (Identifies the 'type' of resource - equivalent to the resource name for other resources.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Basic.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Identifies the 'type' of resource - equivalent to the resource name for other resources.)
     */
    public Basic setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #subject} (Identifies the patient, practitioner, device or any other resource that is the "focus" of this resource.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Basic.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Identifies the patient, practitioner, device or any other resource that is the "focus" of this resource.)
     */
    public Basic setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #created} (Identifies when the resource was first created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public DateTimeType getCreatedElement() { 
      if (this.created == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Basic.created");
        else if (Configuration.doAutoCreate())
          this.created = new DateTimeType(); // bb
      return this.created;
    }

    public boolean hasCreatedElement() { 
      return this.created != null && !this.created.isEmpty();
    }

    public boolean hasCreated() { 
      return this.created != null && !this.created.isEmpty();
    }

    /**
     * @param value {@link #created} (Identifies when the resource was first created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public Basic setCreatedElement(DateTimeType value) { 
      this.created = value;
      return this;
    }

    /**
     * @return Identifies when the resource was first created.
     */
    public Date getCreated() { 
      return this.created == null ? null : this.created.getValue();
    }

    /**
     * @param value Identifies when the resource was first created.
     */
    public Basic setCreated(Date value) { 
      if (value == null)
        this.created = null;
      else {
        if (this.created == null)
          this.created = new DateTimeType();
        this.created.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #author} (Indicates who was responsible for creating the resource instance.)
     */
    public Reference getAuthor() { 
      if (this.author == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Basic.author");
        else if (Configuration.doAutoCreate())
          this.author = new Reference(); // cc
      return this.author;
    }

    public boolean hasAuthor() { 
      return this.author != null && !this.author.isEmpty();
    }

    /**
     * @param value {@link #author} (Indicates who was responsible for creating the resource instance.)
     */
    public Basic setAuthor(Reference value) { 
      this.author = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifier assigned to the resource for business purposes, outside the context of FHIR.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("code", "CodeableConcept", "Identifies the 'type' of resource - equivalent to the resource name for other resources.", 0, 1, code));
        children.add(new Property("subject", "Reference(Any)", "Identifies the patient, practitioner, device or any other resource that is the \"focus\" of this resource.", 0, 1, subject));
        children.add(new Property("created", "dateTime", "Identifies when the resource was first created.", 0, 1, created));
        children.add(new Property("author", "Reference(Practitioner|PractitionerRole|Patient|RelatedPerson|Organization|Device|CareTeam)", "Indicates who was responsible for creating the resource instance.", 0, 1, author));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier assigned to the resource for business purposes, outside the context of FHIR.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Identifies the 'type' of resource - equivalent to the resource name for other resources.", 0, 1, code);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Any)", "Identifies the patient, practitioner, device or any other resource that is the \"focus\" of this resource.", 0, 1, subject);
        case 1028554472: /*created*/  return new Property("created", "dateTime", "Identifies when the resource was first created.", 0, 1, created);
        case -1406328437: /*author*/  return new Property("author", "Reference(Practitioner|PractitionerRole|Patient|RelatedPerson|Organization|Device|CareTeam)", "Indicates who was responsible for creating the resource instance.", 0, 1, author);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1028554472: /*created*/ return this.created == null ? new Base[0] : new Base[] {this.created}; // DateTimeType
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : new Base[] {this.author}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1028554472: // created
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1406328437: // author
          this.author = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("created")) {
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("author")) {
          this.author = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3059181:  return getCode();
        case -1867885268:  return getSubject();
        case 1028554472:  return getCreatedElement();
        case -1406328437:  return getAuthor();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1028554472: /*created*/ return new String[] {"dateTime"};
        case -1406328437: /*author*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("created")) {
          throw new FHIRException("Cannot call addChild on a primitive type Basic.created");
        }
        else if (name.equals("author")) {
          this.author = new Reference();
          return this.author;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Basic";

  }

      public Basic copy() {
        Basic dst = new Basic();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Basic dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.created = created == null ? null : created.copy();
        dst.author = author == null ? null : author.copy();
      }

      protected Basic typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Basic))
          return false;
        Basic o = (Basic) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(code, o.code, true) && compareDeep(subject, o.subject, true)
           && compareDeep(created, o.created, true) && compareDeep(author, o.author, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Basic))
          return false;
        Basic o = (Basic) other_;
        return compareValues(created, o.created, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, code, subject
          , created, author);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Basic;
   }


}

