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
 * Class describing a reference to another object, which may exist locally or be maintained outside the current namespace, e.g. in another service. Services are usually external, e.g. available in a LAN (including on the same host) or the internet via Corba, SOAP, or some other distributed protocol. However, in small systems they may be part of the same executable as the data containing the Id.
 */
@DatatypeDef(name="OBJECT_REF")
public class OBJECT_REF extends LogicalBase implements ICompositeType {

    /**
     * Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment) e.g. terminology , demographic . These names are not yet standardised. Legal values for namespace are: 'local', 'unknown', or a string matching the standard regex [a-zA-Z][a-zA-Z0-9_.:/&?=+-]*. Note that the first two are just special values of the regex, and will be matched by it.
     */
    @Child(name = "namespace", type = {StringType.class}, order=0, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment)", formalDefinition="Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment) e.g. terminology , demographic . These names are not yet standardised. Legal values for namespace are: 'local', 'unknown', or a string matching the standard regex [a-zA-Z][a-zA-Z0-9_.:/&?=+-]*. Note that the first two are just special values of the regex, and will be matched by it." )
    protected StringType namespace;

    /**
     * Name of the class (concrete or abstract) of object to which this identifier type refers, e.g. PARTY, PERSON, GUIDELINE etc. These class names are from the relevant reference model. The type name ANY can be used to indicate that any type is accepted (e.g. if the type is unknown).
     */
    @Child(name = "type", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Name of the class (concrete or abstract) of object to which this identifier type refers. These class names are from the relevant reference model", formalDefinition="Name of the class (concrete or abstract) of object to which this identifier type refers, e.g. PARTY, PERSON, GUIDELINE etc. These class names are from the relevant reference model. The type name ANY can be used to indicate that any type is accepted (e.g. if the type is unknown)." )
    protected StringType type;

    /**
     * Globally unique id of an object, regardless of where it is stored.
     */
    @Child(name = "id", type = {OBJECT_ID.class}, order=2, min=1, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Globally unique id of an object, regardless of where it is stored", formalDefinition="Globally unique id of an object, regardless of where it is stored." )
    protected OBJECT_ID id;

    private static final long serialVersionUID = 1415979947L;

  /**
   * Constructor
   */
    public OBJECT_REF() {
      super();
    }

  /**
   * Constructor
   */
    public OBJECT_REF(String namespace, String type, OBJECT_ID id) {
      super();
      this.setNamespace(namespace);
      this.setType(type);
      this.setId(id);
    }

    /**
     * @return {@link #namespace} (Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment) e.g. terminology , demographic . These names are not yet standardised. Legal values for namespace are: 'local', 'unknown', or a string matching the standard regex [a-zA-Z][a-zA-Z0-9_.:/&?=+-]*. Note that the first two are just special values of the regex, and will be matched by it.). This is the underlying object with id, value and extensions. The accessor "getNamespace" gives direct access to the value
     */
    public StringType getNamespaceElement() { 
      if (this.namespace == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OBJECT_REF.namespace");
        else if (Configuration.doAutoCreate())
          this.namespace = new StringType(); // bb
      return this.namespace;
    }

    public boolean hasNamespaceElement() { 
      return this.namespace != null && !this.namespace.isEmpty();
    }

    public boolean hasNamespace() { 
      return this.namespace != null && !this.namespace.isEmpty();
    }

    /**
     * @param value {@link #namespace} (Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment) e.g. terminology , demographic . These names are not yet standardised. Legal values for namespace are: 'local', 'unknown', or a string matching the standard regex [a-zA-Z][a-zA-Z0-9_.:/&?=+-]*. Note that the first two are just special values of the regex, and will be matched by it.). This is the underlying object with id, value and extensions. The accessor "getNamespace" gives direct access to the value
     */
    public OBJECT_REF setNamespaceElement(StringType value) { 
      this.namespace = value;
      return this;
    }

    /**
     * @return Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment) e.g. terminology , demographic . These names are not yet standardised. Legal values for namespace are: 'local', 'unknown', or a string matching the standard regex [a-zA-Z][a-zA-Z0-9_.:/&?=+-]*. Note that the first two are just special values of the regex, and will be matched by it.
     */
    public String getNamespace() { 
      return this.namespace == null ? null : this.namespace.getValue();
    }

    /**
     * @param value Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment) e.g. terminology , demographic . These names are not yet standardised. Legal values for namespace are: 'local', 'unknown', or a string matching the standard regex [a-zA-Z][a-zA-Z0-9_.:/&?=+-]*. Note that the first two are just special values of the regex, and will be matched by it.
     */
    public OBJECT_REF setNamespace(String value) { 
        if (this.namespace == null)
          this.namespace = new StringType();
        this.namespace.setValue(value);
      return this;
    }

    /**
     * @return {@link #type} (Name of the class (concrete or abstract) of object to which this identifier type refers, e.g. PARTY, PERSON, GUIDELINE etc. These class names are from the relevant reference model. The type name ANY can be used to indicate that any type is accepted (e.g. if the type is unknown).). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public StringType getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create OBJECT_REF.type");
        else if (Configuration.doAutoCreate())
          this.type = new StringType(); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Name of the class (concrete or abstract) of object to which this identifier type refers, e.g. PARTY, PERSON, GUIDELINE etc. These class names are from the relevant reference model. The type name ANY can be used to indicate that any type is accepted (e.g. if the type is unknown).). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public OBJECT_REF setTypeElement(StringType value) { 
      this.type = value;
      return this;
    }

    /**
     * @return Name of the class (concrete or abstract) of object to which this identifier type refers, e.g. PARTY, PERSON, GUIDELINE etc. These class names are from the relevant reference model. The type name ANY can be used to indicate that any type is accepted (e.g. if the type is unknown).
     */
    public String getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value Name of the class (concrete or abstract) of object to which this identifier type refers, e.g. PARTY, PERSON, GUIDELINE etc. These class names are from the relevant reference model. The type name ANY can be used to indicate that any type is accepted (e.g. if the type is unknown).
     */
    public OBJECT_REF setType(String value) { 
        if (this.type == null)
          this.type = new StringType();
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #id} (Globally unique id of an object, regardless of where it is stored.)
     */
    public OBJECT_ID getId() { 
      return this.id;
    }

    public boolean hasId() { 
      return this.id != null && !this.id.isEmpty();
    }

    /**
     * @param value {@link #id} (Globally unique id of an object, regardless of where it is stored.)
     */
    public OBJECT_REF setId(OBJECT_ID value) { 
      this.id = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("namespace", "string", "Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment) e.g. terminology , demographic . These names are not yet standardised. Legal values for namespace are: 'local', 'unknown', or a string matching the standard regex [a-zA-Z][a-zA-Z0-9_.:/&?=+-]*. Note that the first two are just special values of the regex, and will be matched by it.", 0, 1, namespace));
        children.add(new Property("type", "string", "Name of the class (concrete or abstract) of object to which this identifier type refers, e.g. PARTY, PERSON, GUIDELINE etc. These class names are from the relevant reference model. The type name ANY can be used to indicate that any type is accepted (e.g. if the type is unknown).", 0, 1, type));
        children.add(new Property("id", "http://openehr.org/fhir/StructureDefinition/OBJECT-ID", "Globally unique id of an object, regardless of where it is stored.", 0, 1, id));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1252218203: /*namespace*/  return new Property("namespace", "string", "Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment) e.g. terminology , demographic . These names are not yet standardised. Legal values for namespace are: 'local', 'unknown', or a string matching the standard regex [a-zA-Z][a-zA-Z0-9_.:/&?=+-]*. Note that the first two are just special values of the regex, and will be matched by it.", 0, 1, namespace);
        case 3575610: /*type*/  return new Property("type", "string", "Name of the class (concrete or abstract) of object to which this identifier type refers, e.g. PARTY, PERSON, GUIDELINE etc. These class names are from the relevant reference model. The type name ANY can be used to indicate that any type is accepted (e.g. if the type is unknown).", 0, 1, type);
        case 3355: /*id*/  return new Property("id", "http://openehr.org/fhir/StructureDefinition/OBJECT-ID", "Globally unique id of an object, regardless of where it is stored.", 0, 1, id);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1252218203: /*namespace*/ return this.namespace == null ? new Base[0] : new Base[] {this.namespace}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // StringType
        case 3355: /*id*/ return this.id == null ? new Base[0] : new Base[] {this.id}; // OBJECT_ID
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1252218203: // namespace
          this.namespace = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToString(value); // StringType
          return value;
        case 3355: // id
          this.id = (OBJECT_ID) value; // OBJECT_ID
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("namespace")) {
          this.namespace = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("id")) {
          this.id = (OBJECT_ID) value; // OBJECT_ID
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1252218203:  return getNamespaceElement();
        case 3575610:  return getTypeElement();
        case 3355: /*div*/
          throw new Error("Unable to make an instance of the abstract property 'id'");
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1252218203: /*namespace*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"string"};
        case 3355: /*id*/ return new String[] {"http://openehr.org/fhir/StructureDefinition/OBJECT-ID"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("namespace")) {
          throw new FHIRException("Cannot call addChild on a singleton property OBJECT_REF.namespace");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property OBJECT_REF.type");
        }
        else if (name.equals("id")) {
          throw new FHIRException("Cannot call addChild on an abstract type OBJECT_REF.id");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "OBJECT_REF";

  }

      public OBJECT_REF copy() {
        OBJECT_REF dst = new OBJECT_REF();
        copyValues(dst);
        return dst;
      }

      public void copyValues(OBJECT_REF dst) {
        super.copyValues(dst);
        dst.namespace = namespace == null ? null : namespace.copy();
        dst.type = type == null ? null : type.copy();
        dst.id = id == null ? null : id.copy();
      }

      protected OBJECT_REF typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof OBJECT_REF))
          return false;
        OBJECT_REF o = (OBJECT_REF) other_;
        return compareDeep(namespace, o.namespace, true) && compareDeep(type, o.type, true) && compareDeep(id, o.id, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof OBJECT_REF))
          return false;
        OBJECT_REF o = (OBJECT_REF) other_;
        return compareValues(namespace, o.namespace, true) && compareValues(type, o.type, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(namespace, type, id);
      }


}

