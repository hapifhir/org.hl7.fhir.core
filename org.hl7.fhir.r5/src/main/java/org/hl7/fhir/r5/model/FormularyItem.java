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

// Generated on Wed, Mar 1, 2023 15:32+1100 for FHIR v5.0.0-draft-final

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
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
 * This resource describes a product or service that is available through a program and includes the conditions and constraints of availability.  All of the information in this resource is specific to the inclusion of the item in the formulary and is not inherent to the item itself.
 */
@ResourceDef(name="FormularyItem", profile="http://hl7.org/fhir/StructureDefinition/FormularyItem")
public class FormularyItem extends DomainResource {

    public enum FormularyItemStatusCodes {
        /**
         * The service or product referred to by this FormularyItem is in active use within the drug database or inventory system.
         */
        ACTIVE, 
        /**
         * The service or product referred to by this FormularyItem was entered in error within the drug database or inventory system.
         */
        ENTEREDINERROR, 
        /**
         * The service or product referred to by this FormularyItem is not in active use within the drug database or inventory system.
         */
        INACTIVE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static FormularyItemStatusCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("inactive".equals(codeString))
          return INACTIVE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown FormularyItemStatusCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case ENTEREDINERROR: return "entered-in-error";
            case INACTIVE: return "inactive";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/CodeSystem/formularyitem-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/CodeSystem/formularyitem-status";
            case INACTIVE: return "http://hl7.org/fhir/CodeSystem/formularyitem-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The service or product referred to by this FormularyItem is in active use within the drug database or inventory system.";
            case ENTEREDINERROR: return "The service or product referred to by this FormularyItem was entered in error within the drug database or inventory system.";
            case INACTIVE: return "The service or product referred to by this FormularyItem is not in active use within the drug database or inventory system.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case ENTEREDINERROR: return "Entered in Error";
            case INACTIVE: return "Inactive";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class FormularyItemStatusCodesEnumFactory implements EnumFactory<FormularyItemStatusCodes> {
    public FormularyItemStatusCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return FormularyItemStatusCodes.ACTIVE;
        if ("entered-in-error".equals(codeString))
          return FormularyItemStatusCodes.ENTEREDINERROR;
        if ("inactive".equals(codeString))
          return FormularyItemStatusCodes.INACTIVE;
        throw new IllegalArgumentException("Unknown FormularyItemStatusCodes code '"+codeString+"'");
        }
        public Enumeration<FormularyItemStatusCodes> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<FormularyItemStatusCodes>(this, FormularyItemStatusCodes.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<FormularyItemStatusCodes>(this, FormularyItemStatusCodes.NULL, code);
        if ("active".equals(codeString))
          return new Enumeration<FormularyItemStatusCodes>(this, FormularyItemStatusCodes.ACTIVE, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<FormularyItemStatusCodes>(this, FormularyItemStatusCodes.ENTEREDINERROR, code);
        if ("inactive".equals(codeString))
          return new Enumeration<FormularyItemStatusCodes>(this, FormularyItemStatusCodes.INACTIVE, code);
        throw new FHIRException("Unknown FormularyItemStatusCodes code '"+codeString+"'");
        }
    public String toCode(FormularyItemStatusCodes code) {
      if (code == FormularyItemStatusCodes.ACTIVE)
        return "active";
      if (code == FormularyItemStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      if (code == FormularyItemStatusCodes.INACTIVE)
        return "inactive";
      return "?";
      }
    public String toSystem(FormularyItemStatusCodes code) {
      return code.getSystem();
      }
    }

    /**
     * Business identifier for this formulary item.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for this formulary item", formalDefinition="Business identifier for this formulary item." )
    protected List<Identifier> identifier;

    /**
     * A code (or set of codes) that specify the product or service that is identified by this formulary item.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Codes that identify this formulary item", formalDefinition="A code (or set of codes) that specify the product or service that is identified by this formulary item." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-codes")
    protected CodeableConcept code;

    /**
     * The validity about the information of the formulary item and not of the underlying product or service itself.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | entered-in-error | inactive", formalDefinition="The validity about the information of the formulary item and not of the underlying product or service itself." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/formularyitem-status")
    protected Enumeration<FormularyItemStatusCodes> status;

    private static final long serialVersionUID = 601026823L;

  /**
   * Constructor
   */
    public FormularyItem() {
      super();
    }

    /**
     * @return {@link #identifier} (Business identifier for this formulary item.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public FormularyItem setIdentifier(List<Identifier> theIdentifier) { 
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

    public FormularyItem addIdentifier(Identifier t) { //3
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
     * @return {@link #code} (A code (or set of codes) that specify the product or service that is identified by this formulary item.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FormularyItem.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A code (or set of codes) that specify the product or service that is identified by this formulary item.)
     */
    public FormularyItem setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #status} (The validity about the information of the formulary item and not of the underlying product or service itself.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<FormularyItemStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create FormularyItem.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<FormularyItemStatusCodes>(new FormularyItemStatusCodesEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The validity about the information of the formulary item and not of the underlying product or service itself.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public FormularyItem setStatusElement(Enumeration<FormularyItemStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The validity about the information of the formulary item and not of the underlying product or service itself.
     */
    public FormularyItemStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The validity about the information of the formulary item and not of the underlying product or service itself.
     */
    public FormularyItem setStatus(FormularyItemStatusCodes value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<FormularyItemStatusCodes>(new FormularyItemStatusCodesEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for this formulary item.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("code", "CodeableConcept", "A code (or set of codes) that specify the product or service that is identified by this formulary item.", 0, 1, code));
        children.add(new Property("status", "code", "The validity about the information of the formulary item and not of the underlying product or service itself.", 0, 1, status));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for this formulary item.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code (or set of codes) that specify the product or service that is identified by this formulary item.", 0, 1, code);
        case -892481550: /*status*/  return new Property("status", "code", "The validity about the information of the formulary item and not of the underlying product or service itself.", 0, 1, status);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<FormularyItemStatusCodes>
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
        case -892481550: // status
          value = new FormularyItemStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FormularyItemStatusCodes>
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
        } else if (name.equals("status")) {
          value = new FormularyItemStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FormularyItemStatusCodes>
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3059181:  return getCode();
        case -892481550:  return getStatusElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"code"};
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
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type FormularyItem.status");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "FormularyItem";

  }

      public FormularyItem copy() {
        FormularyItem dst = new FormularyItem();
        copyValues(dst);
        return dst;
      }

      public void copyValues(FormularyItem dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.status = status == null ? null : status.copy();
      }

      protected FormularyItem typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof FormularyItem))
          return false;
        FormularyItem o = (FormularyItem) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(code, o.code, true) && compareDeep(status, o.status, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof FormularyItem))
          return false;
        FormularyItem o = (FormularyItem) other_;
        return compareValues(status, o.status, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, code, status
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.FormularyItem;
   }

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Returns formulary items for a specific code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>FormularyItem.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="FormularyItem.code", description="Returns formulary items for a specific code", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Returns formulary items for a specific code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>FormularyItem.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Returns formulary items with this external identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>FormularyItem.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="FormularyItem.identifier", description="Returns formulary items with this external identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Returns formulary items with this external identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>FormularyItem.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);


}

