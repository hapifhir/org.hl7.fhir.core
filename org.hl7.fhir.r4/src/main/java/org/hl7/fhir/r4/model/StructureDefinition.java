package org.hl7.fhir.r4.model;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Tue, May 12, 2020 07:26+1000 for FHIR v4.0.1
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.r4.model.Enumerations.FHIRVersion;
import org.hl7.fhir.r4.model.Enumerations.FHIRVersionEnumFactory;
import org.hl7.fhir.r4.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r4.model.Enumerations.PublicationStatusEnumFactory;
import org.hl7.fhir.utilities.Utilities;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;

/**
 * A definition of a FHIR structure. This resource is used to describe the
 * underlying resources, data types defined in FHIR, and also for describing
 * extensions and constraints on resources and data types.
 */
@ResourceDef(name = "StructureDefinition", profile = "http://hl7.org/fhir/StructureDefinition/StructureDefinition")
@ChildOrder(names = { "url", "identifier", "version", "name", "title", "status", "experimental", "date", "publisher",
    "contact", "description", "useContext", "jurisdiction", "purpose", "copyright", "keyword", "fhirVersion", "mapping",
    "kind", "abstract", "context", "contextInvariant", "type", "baseDefinition", "derivation", "snapshot",
    "differential" })
public class StructureDefinition extends MetadataResource {

  public enum StructureDefinitionKind {
    /**
     * A primitive type that has a value and an extension. These can be used
     * throughout complex datatype, Resource and extension definitions. Only the
     * base specification can define primitive types.
     */
    PRIMITIVETYPE,
    /**
     * A complex structure that defines a set of data elements that is suitable for
     * use in 'resources'. The base specification defines a number of complex types,
     * and other specifications can define additional types. These structures do not
     * have a maintained identity.
     */
    COMPLEXTYPE,
    /**
     * A 'resource' - a directed acyclic graph of elements that aggregrates other
     * types into an identifiable entity. The base FHIR resources are defined by the
     * FHIR specification itself but other 'resources' can be defined in additional
     * specifications (though these will not be recognised as 'resources' by the
     * FHIR specification (i.e. they do not get end-points etc, or act as the
     * targets of references in FHIR defined resources - though other specificatiosn
     * can treat them this way).
     */
    RESOURCE,
    /**
     * A pattern or a template that is not intended to be a real resource or complex
     * type.
     */
    LOGICAL,
    /**
     * added to help the parsers with the generic types
     */
    NULL;

    public static StructureDefinitionKind fromCode(String codeString) throws FHIRException {
      if (codeString == null || "".equals(codeString))
        return null;
      if ("primitive-type".equals(codeString))
        return PRIMITIVETYPE;
      if ("complex-type".equals(codeString))
        return COMPLEXTYPE;
      if ("resource".equals(codeString))
        return RESOURCE;
      if ("logical".equals(codeString))
        return LOGICAL;
      if (Configuration.isAcceptInvalidEnums())
        return null;
      else
        throw new FHIRException("Unknown StructureDefinitionKind code '" + codeString + "'");
    }

    public String toCode() {
      switch (this) {
      case PRIMITIVETYPE:
        return "primitive-type";
      case COMPLEXTYPE:
        return "complex-type";
      case RESOURCE:
        return "resource";
      case LOGICAL:
        return "logical";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getSystem() {
      switch (this) {
      case PRIMITIVETYPE:
        return "http://hl7.org/fhir/structure-definition-kind";
      case COMPLEXTYPE:
        return "http://hl7.org/fhir/structure-definition-kind";
      case RESOURCE:
        return "http://hl7.org/fhir/structure-definition-kind";
      case LOGICAL:
        return "http://hl7.org/fhir/structure-definition-kind";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDefinition() {
      switch (this) {
      case PRIMITIVETYPE:
        return "A primitive type that has a value and an extension. These can be used throughout complex datatype, Resource and extension definitions. Only the base specification can define primitive types.";
      case COMPLEXTYPE:
        return "A  complex structure that defines a set of data elements that is suitable for use in 'resources'. The base specification defines a number of complex types, and other specifications can define additional types. These structures do not have a maintained identity.";
      case RESOURCE:
        return "A 'resource' - a directed acyclic graph of elements that aggregrates other types into an identifiable entity. The base FHIR resources are defined by the FHIR specification itself but other 'resources' can be defined in additional specifications (though these will not be recognised as 'resources' by the FHIR specification (i.e. they do not get end-points etc, or act as the targets of references in FHIR defined resources - though other specificatiosn can treat them this way).";
      case LOGICAL:
        return "A pattern or a template that is not intended to be a real resource or complex type.";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDisplay() {
      switch (this) {
      case PRIMITIVETYPE:
        return "Primitive Data Type";
      case COMPLEXTYPE:
        return "Complex Data Type";
      case RESOURCE:
        return "Resource";
      case LOGICAL:
        return "Logical";
      case NULL:
        return null;
      default:
        return "?";
      }
    }
  }

  public static class StructureDefinitionKindEnumFactory implements EnumFactory<StructureDefinitionKind> {
    public StructureDefinitionKind fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
        if (codeString == null || "".equals(codeString))
          return null;
      if ("primitive-type".equals(codeString))
        return StructureDefinitionKind.PRIMITIVETYPE;
      if ("complex-type".equals(codeString))
        return StructureDefinitionKind.COMPLEXTYPE;
      if ("resource".equals(codeString))
        return StructureDefinitionKind.RESOURCE;
      if ("logical".equals(codeString))
        return StructureDefinitionKind.LOGICAL;
      throw new IllegalArgumentException("Unknown StructureDefinitionKind code '" + codeString + "'");
    }

    public Enumeration<StructureDefinitionKind> fromType(PrimitiveType<?> code) throws FHIRException {
      if (code == null)
        return null;
      if (code.isEmpty())
        return new Enumeration<StructureDefinitionKind>(this, StructureDefinitionKind.NULL, code);
      String codeString = code.asStringValue();
      if (codeString == null || "".equals(codeString))
        return new Enumeration<StructureDefinitionKind>(this, StructureDefinitionKind.NULL, code);
      if ("primitive-type".equals(codeString))
        return new Enumeration<StructureDefinitionKind>(this, StructureDefinitionKind.PRIMITIVETYPE, code);
      if ("complex-type".equals(codeString))
        return new Enumeration<StructureDefinitionKind>(this, StructureDefinitionKind.COMPLEXTYPE, code);
      if ("resource".equals(codeString))
        return new Enumeration<StructureDefinitionKind>(this, StructureDefinitionKind.RESOURCE, code);
      if ("logical".equals(codeString))
        return new Enumeration<StructureDefinitionKind>(this, StructureDefinitionKind.LOGICAL, code);
      throw new FHIRException("Unknown StructureDefinitionKind code '" + codeString + "'");
    }

    public String toCode(StructureDefinitionKind code) {
       if (code == StructureDefinitionKind.NULL)
           return null;
       if (code == StructureDefinitionKind.PRIMITIVETYPE)
        return "primitive-type";
      if (code == StructureDefinitionKind.COMPLEXTYPE)
        return "complex-type";
      if (code == StructureDefinitionKind.RESOURCE)
        return "resource";
      if (code == StructureDefinitionKind.LOGICAL)
        return "logical";
      return "?";
   }

    public String toSystem(StructureDefinitionKind code) {
      return code.getSystem();
    }
  }

  public enum ExtensionContextType {
    /**
     * The context is all elements that match the FHIRPath query found in the
     * expression.
     */
    FHIRPATH,
    /**
     * The context is any element that has an ElementDefinition.id that matches that
     * found in the expression. This includes ElementDefinition Ids that have
     * slicing identifiers. The full path for the element is [url]#[elementid]. If
     * there is no #, the Element id is one defined in the base specification.
     */
    ELEMENT,
    /**
     * The context is a particular extension from a particular StructureDefinition,
     * and the expression is just a uri that identifies the extension.
     */
    EXTENSION,
    /**
     * added to help the parsers with the generic types
     */
    NULL;

    public static ExtensionContextType fromCode(String codeString) throws FHIRException {
      if (codeString == null || "".equals(codeString))
        return null;
      if ("fhirpath".equals(codeString))
        return FHIRPATH;
      if ("element".equals(codeString))
        return ELEMENT;
      if ("extension".equals(codeString))
        return EXTENSION;
      if (Configuration.isAcceptInvalidEnums())
        return null;
      else
        throw new FHIRException("Unknown ExtensionContextType code '" + codeString + "'");
    }

    public String toCode() {
      switch (this) {
      case FHIRPATH:
        return "fhirpath";
      case ELEMENT:
        return "element";
      case EXTENSION:
        return "extension";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getSystem() {
      switch (this) {
      case FHIRPATH:
        return "http://hl7.org/fhir/extension-context-type";
      case ELEMENT:
        return "http://hl7.org/fhir/extension-context-type";
      case EXTENSION:
        return "http://hl7.org/fhir/extension-context-type";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDefinition() {
      switch (this) {
      case FHIRPATH:
        return "The context is all elements that match the FHIRPath query found in the expression.";
      case ELEMENT:
        return "The context is any element that has an ElementDefinition.id that matches that found in the expression. This includes ElementDefinition Ids that have slicing identifiers. The full path for the element is [url]#[elementid]. If there is no #, the Element id is one defined in the base specification.";
      case EXTENSION:
        return "The context is a particular extension from a particular StructureDefinition, and the expression is just a uri that identifies the extension.";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDisplay() {
      switch (this) {
      case FHIRPATH:
        return "FHIRPath";
      case ELEMENT:
        return "Element ID";
      case EXTENSION:
        return "Extension URL";
      case NULL:
        return null;
      default:
        return "?";
      }
    }
  }

  public static class ExtensionContextTypeEnumFactory implements EnumFactory<ExtensionContextType> {
    public ExtensionContextType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
        if (codeString == null || "".equals(codeString))
          return null;
      if ("fhirpath".equals(codeString))
        return ExtensionContextType.FHIRPATH;
      if ("element".equals(codeString))
        return ExtensionContextType.ELEMENT;
      if ("extension".equals(codeString))
        return ExtensionContextType.EXTENSION;
      throw new IllegalArgumentException("Unknown ExtensionContextType code '" + codeString + "'");
    }

    public Enumeration<ExtensionContextType> fromType(PrimitiveType<?> code) throws FHIRException {
      if (code == null)
        return null;
      if (code.isEmpty())
        return new Enumeration<ExtensionContextType>(this, ExtensionContextType.NULL, code);
      String codeString = code.asStringValue();
      if (codeString == null || "".equals(codeString))
        return new Enumeration<ExtensionContextType>(this, ExtensionContextType.NULL, code);
      if ("fhirpath".equals(codeString))
        return new Enumeration<ExtensionContextType>(this, ExtensionContextType.FHIRPATH, code);
      if ("element".equals(codeString))
        return new Enumeration<ExtensionContextType>(this, ExtensionContextType.ELEMENT, code);
      if ("extension".equals(codeString))
        return new Enumeration<ExtensionContextType>(this, ExtensionContextType.EXTENSION, code);
      throw new FHIRException("Unknown ExtensionContextType code '" + codeString + "'");
    }

    public String toCode(ExtensionContextType code) {
       if (code == ExtensionContextType.NULL)
           return null;
       if (code == ExtensionContextType.FHIRPATH)
        return "fhirpath";
      if (code == ExtensionContextType.ELEMENT)
        return "element";
      if (code == ExtensionContextType.EXTENSION)
        return "extension";
      return "?";
   }

    public String toSystem(ExtensionContextType code) {
      return code.getSystem();
    }
  }

  public enum TypeDerivationRule {
    /**
     * This definition defines a new type that adds additional elements to the base
     * type.
     */
    SPECIALIZATION,
    /**
     * This definition adds additional rules to an existing concrete type.
     */
    CONSTRAINT,
    /**
     * added to help the parsers with the generic types
     */
    NULL;

    public static TypeDerivationRule fromCode(String codeString) throws FHIRException {
      if (codeString == null || "".equals(codeString))
        return null;
      if ("specialization".equals(codeString))
        return SPECIALIZATION;
      if ("constraint".equals(codeString))
        return CONSTRAINT;
      if (Configuration.isAcceptInvalidEnums())
        return null;
      else
        throw new FHIRException("Unknown TypeDerivationRule code '" + codeString + "'");
    }

    public String toCode() {
      switch (this) {
      case SPECIALIZATION:
        return "specialization";
      case CONSTRAINT:
        return "constraint";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getSystem() {
      switch (this) {
      case SPECIALIZATION:
        return "http://hl7.org/fhir/type-derivation-rule";
      case CONSTRAINT:
        return "http://hl7.org/fhir/type-derivation-rule";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDefinition() {
      switch (this) {
      case SPECIALIZATION:
        return "This definition defines a new type that adds additional elements to the base type.";
      case CONSTRAINT:
        return "This definition adds additional rules to an existing concrete type.";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDisplay() {
      switch (this) {
      case SPECIALIZATION:
        return "Specialization";
      case CONSTRAINT:
        return "Constraint";
      case NULL:
        return null;
      default:
        return "?";
      }
    }
  }

  public static class TypeDerivationRuleEnumFactory implements EnumFactory<TypeDerivationRule> {
    public TypeDerivationRule fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
        if (codeString == null || "".equals(codeString))
          return null;
      if ("specialization".equals(codeString))
        return TypeDerivationRule.SPECIALIZATION;
      if ("constraint".equals(codeString))
        return TypeDerivationRule.CONSTRAINT;
      throw new IllegalArgumentException("Unknown TypeDerivationRule code '" + codeString + "'");
    }

    public Enumeration<TypeDerivationRule> fromType(PrimitiveType<?> code) throws FHIRException {
      if (code == null)
        return null;
      if (code.isEmpty())
        return new Enumeration<TypeDerivationRule>(this, TypeDerivationRule.NULL, code);
      String codeString = code.asStringValue();
      if (codeString == null || "".equals(codeString))
        return new Enumeration<TypeDerivationRule>(this, TypeDerivationRule.NULL, code);
      if ("specialization".equals(codeString))
        return new Enumeration<TypeDerivationRule>(this, TypeDerivationRule.SPECIALIZATION, code);
      if ("constraint".equals(codeString))
        return new Enumeration<TypeDerivationRule>(this, TypeDerivationRule.CONSTRAINT, code);
      throw new FHIRException("Unknown TypeDerivationRule code '" + codeString + "'");
    }

    public String toCode(TypeDerivationRule code) {
       if (code == TypeDerivationRule.NULL)
           return null;
       if (code == TypeDerivationRule.SPECIALIZATION)
        return "specialization";
      if (code == TypeDerivationRule.CONSTRAINT)
        return "constraint";
      return "?";
   }

    public String toSystem(TypeDerivationRule code) {
      return code.getSystem();
    }
  }

  @Block()
  public static class StructureDefinitionMappingComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * An Internal id that is used to identify this mapping set when specific
     * mappings are made.
     */
    @Child(name = "identity", type = { IdType.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Internal id when this mapping is used", formalDefinition = "An Internal id that is used to identify this mapping set when specific mappings are made.")
    protected IdType identity;

    /**
     * An absolute URI that identifies the specification that this mapping is
     * expressed to.
     */
    @Child(name = "uri", type = { UriType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Identifies what this mapping refers to", formalDefinition = "An absolute URI that identifies the specification that this mapping is expressed to.")
    protected UriType uri;

    /**
     * A name for the specification that is being mapped to.
     */
    @Child(name = "name", type = { StringType.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Names what this mapping refers to", formalDefinition = "A name for the specification that is being mapped to.")
    protected StringType name;

    /**
     * Comments about this mapping, including version notes, issues, scope
     * limitations, and other important notes for usage.
     */
    @Child(name = "comment", type = {
        StringType.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Versions, Issues, Scope limitations etc.", formalDefinition = "Comments about this mapping, including version notes, issues, scope limitations, and other important notes for usage.")
    protected StringType comment;

    private static final long serialVersionUID = 9610265L;

    /**
     * Constructor
     */
    public StructureDefinitionMappingComponent() {
      super();
    }

    /**
     * Constructor
     */
    public StructureDefinitionMappingComponent(IdType identity) {
      super();
      this.identity = identity;
    }

    /**
     * @return {@link #identity} (An Internal id that is used to identify this
     *         mapping set when specific mappings are made.). This is the underlying
     *         object with id, value and extensions. The accessor "getIdentity"
     *         gives direct access to the value
     */
    public IdType getIdentityElement() {
      if (this.identity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureDefinitionMappingComponent.identity");
        else if (Configuration.doAutoCreate())
          this.identity = new IdType(); // bb
      return this.identity;
    }

    public boolean hasIdentityElement() {
      return this.identity != null && !this.identity.isEmpty();
    }

    public boolean hasIdentity() {
      return this.identity != null && !this.identity.isEmpty();
    }

    /**
     * @param value {@link #identity} (An Internal id that is used to identify this
     *              mapping set when specific mappings are made.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getIdentity" gives direct access to the value
     */
    public StructureDefinitionMappingComponent setIdentityElement(IdType value) {
      this.identity = value;
      return this;
    }

    /**
     * @return An Internal id that is used to identify this mapping set when
     *         specific mappings are made.
     */
    public String getIdentity() {
      return this.identity == null ? null : this.identity.getValue();
    }

    /**
     * @param value An Internal id that is used to identify this mapping set when
     *              specific mappings are made.
     */
    public StructureDefinitionMappingComponent setIdentity(String value) {
      if (this.identity == null)
        this.identity = new IdType();
      this.identity.setValue(value);
      return this;
    }

    /**
     * @return {@link #uri} (An absolute URI that identifies the specification that
     *         this mapping is expressed to.). This is the underlying object with
     *         id, value and extensions. The accessor "getUri" gives direct access
     *         to the value
     */
    public UriType getUriElement() {
      if (this.uri == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureDefinitionMappingComponent.uri");
        else if (Configuration.doAutoCreate())
          this.uri = new UriType(); // bb
      return this.uri;
    }

    public boolean hasUriElement() {
      return this.uri != null && !this.uri.isEmpty();
    }

    public boolean hasUri() {
      return this.uri != null && !this.uri.isEmpty();
    }

    /**
     * @param value {@link #uri} (An absolute URI that identifies the specification
     *              that this mapping is expressed to.). This is the underlying
     *              object with id, value and extensions. The accessor "getUri"
     *              gives direct access to the value
     */
    public StructureDefinitionMappingComponent setUriElement(UriType value) {
      this.uri = value;
      return this;
    }

    /**
     * @return An absolute URI that identifies the specification that this mapping
     *         is expressed to.
     */
    public String getUri() {
      return this.uri == null ? null : this.uri.getValue();
    }

    /**
     * @param value An absolute URI that identifies the specification that this
     *              mapping is expressed to.
     */
    public StructureDefinitionMappingComponent setUri(String value) {
      if (Utilities.noString(value))
        this.uri = null;
      else {
        if (this.uri == null)
          this.uri = new UriType();
        this.uri.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #name} (A name for the specification that is being mapped
     *         to.). This is the underlying object with id, value and extensions.
     *         The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() {
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureDefinitionMappingComponent.name");
        else if (Configuration.doAutoCreate())
          this.name = new StringType(); // bb
      return this.name;
    }

    public boolean hasNameElement() {
      return this.name != null && !this.name.isEmpty();
    }

    public boolean hasName() {
      return this.name != null && !this.name.isEmpty();
    }

    /**
     * @param value {@link #name} (A name for the specification that is being mapped
     *              to.). This is the underlying object with id, value and
     *              extensions. The accessor "getName" gives direct access to the
     *              value
     */
    public StructureDefinitionMappingComponent setNameElement(StringType value) {
      this.name = value;
      return this;
    }

    /**
     * @return A name for the specification that is being mapped to.
     */
    public String getName() {
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A name for the specification that is being mapped to.
     */
    public StructureDefinitionMappingComponent setName(String value) {
      if (Utilities.noString(value))
        this.name = null;
      else {
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #comment} (Comments about this mapping, including version
     *         notes, issues, scope limitations, and other important notes for
     *         usage.). This is the underlying object with id, value and extensions.
     *         The accessor "getComment" gives direct access to the value
     */
    public StringType getCommentElement() {
      if (this.comment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureDefinitionMappingComponent.comment");
        else if (Configuration.doAutoCreate())
          this.comment = new StringType(); // bb
      return this.comment;
    }

    public boolean hasCommentElement() {
      return this.comment != null && !this.comment.isEmpty();
    }

    public boolean hasComment() {
      return this.comment != null && !this.comment.isEmpty();
    }

    /**
     * @param value {@link #comment} (Comments about this mapping, including version
     *              notes, issues, scope limitations, and other important notes for
     *              usage.). This is the underlying object with id, value and
     *              extensions. The accessor "getComment" gives direct access to the
     *              value
     */
    public StructureDefinitionMappingComponent setCommentElement(StringType value) {
      this.comment = value;
      return this;
    }

    /**
     * @return Comments about this mapping, including version notes, issues, scope
     *         limitations, and other important notes for usage.
     */
    public String getComment() {
      return this.comment == null ? null : this.comment.getValue();
    }

    /**
     * @param value Comments about this mapping, including version notes, issues,
     *              scope limitations, and other important notes for usage.
     */
    public StructureDefinitionMappingComponent setComment(String value) {
      if (Utilities.noString(value))
        this.comment = null;
      else {
        if (this.comment == null)
          this.comment = new StringType();
        this.comment.setValue(value);
      }
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("identity", "id",
          "An Internal id that is used to identify this mapping set when specific mappings are made.", 0, 1, identity));
      children.add(new Property("uri", "uri",
          "An absolute URI that identifies the specification that this mapping is expressed to.", 0, 1, uri));
      children.add(new Property("name", "string", "A name for the specification that is being mapped to.", 0, 1, name));
      children.add(new Property("comment", "string",
          "Comments about this mapping, including version notes, issues, scope limitations, and other important notes for usage.",
          0, 1, comment));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -135761730:
        /* identity */ return new Property("identity", "id",
            "An Internal id that is used to identify this mapping set when specific mappings are made.", 0, 1,
            identity);
      case 116076:
        /* uri */ return new Property("uri", "uri",
            "An absolute URI that identifies the specification that this mapping is expressed to.", 0, 1, uri);
      case 3373707:
        /* name */ return new Property("name", "string", "A name for the specification that is being mapped to.", 0, 1,
            name);
      case 950398559:
        /* comment */ return new Property("comment", "string",
            "Comments about this mapping, including version notes, issues, scope limitations, and other important notes for usage.",
            0, 1, comment);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -135761730:
        /* identity */ return this.identity == null ? new Base[0] : new Base[] { this.identity }; // IdType
      case 116076:
        /* uri */ return this.uri == null ? new Base[0] : new Base[] { this.uri }; // UriType
      case 3373707:
        /* name */ return this.name == null ? new Base[0] : new Base[] { this.name }; // StringType
      case 950398559:
        /* comment */ return this.comment == null ? new Base[0] : new Base[] { this.comment }; // StringType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -135761730: // identity
        this.identity = castToId(value); // IdType
        return value;
      case 116076: // uri
        this.uri = castToUri(value); // UriType
        return value;
      case 3373707: // name
        this.name = castToString(value); // StringType
        return value;
      case 950398559: // comment
        this.comment = castToString(value); // StringType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("identity")) {
        this.identity = castToId(value); // IdType
      } else if (name.equals("uri")) {
        this.uri = castToUri(value); // UriType
      } else if (name.equals("name")) {
        this.name = castToString(value); // StringType
      } else if (name.equals("comment")) {
        this.comment = castToString(value); // StringType
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("identity")) {
        this.identity = null;
      } else if (name.equals("uri")) {
        this.uri = null;
      } else if (name.equals("name")) {
        this.name = null;
      } else if (name.equals("comment")) {
        this.comment = null;
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -135761730:
        return getIdentityElement();
      case 116076:
        return getUriElement();
      case 3373707:
        return getNameElement();
      case 950398559:
        return getCommentElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -135761730:
        /* identity */ return new String[] { "id" };
      case 116076:
        /* uri */ return new String[] { "uri" };
      case 3373707:
        /* name */ return new String[] { "string" };
      case 950398559:
        /* comment */ return new String[] { "string" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("identity")) {
        throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.identity");
      } else if (name.equals("uri")) {
        throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.uri");
      } else if (name.equals("name")) {
        throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.name");
      } else if (name.equals("comment")) {
        throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.comment");
      } else
        return super.addChild(name);
    }

    public StructureDefinitionMappingComponent copy() {
      StructureDefinitionMappingComponent dst = new StructureDefinitionMappingComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(StructureDefinitionMappingComponent dst) {
      super.copyValues(dst);
      dst.identity = identity == null ? null : identity.copy();
      dst.uri = uri == null ? null : uri.copy();
      dst.name = name == null ? null : name.copy();
      dst.comment = comment == null ? null : comment.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof StructureDefinitionMappingComponent))
        return false;
      StructureDefinitionMappingComponent o = (StructureDefinitionMappingComponent) other_;
      return compareDeep(identity, o.identity, true) && compareDeep(uri, o.uri, true) && compareDeep(name, o.name, true)
          && compareDeep(comment, o.comment, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof StructureDefinitionMappingComponent))
        return false;
      StructureDefinitionMappingComponent o = (StructureDefinitionMappingComponent) other_;
      return compareValues(identity, o.identity, true) && compareValues(uri, o.uri, true)
          && compareValues(name, o.name, true) && compareValues(comment, o.comment, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identity, uri, name, comment);
    }

    public String fhirType() {
      return "StructureDefinition.mapping";

    }

  }

  @Block()
  public static class StructureDefinitionContextComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Defines how to interpret the expression that defines what the context of the
     * extension is.
     */
    @Child(name = "type", type = { CodeType.class }, order = 1, min = 1, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "fhirpath | element | extension", formalDefinition = "Defines how to interpret the expression that defines what the context of the extension is.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/extension-context-type")
    protected Enumeration<ExtensionContextType> type;

    /**
     * An expression that defines where an extension can be used in resources.
     */
    @Child(name = "expression", type = {
        StringType.class }, order = 2, min = 1, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Where the extension can be used in instances", formalDefinition = "An expression that defines where an extension can be used in resources.")
    protected StringType expression;

    private static final long serialVersionUID = 1958074856L;

    /**
     * Constructor
     */
    public StructureDefinitionContextComponent() {
      super();
    }

    /**
     * Constructor
     */
    public StructureDefinitionContextComponent(Enumeration<ExtensionContextType> type, StringType expression) {
      super();
      this.type = type;
      this.expression = expression;
    }

    /**
     * @return {@link #type} (Defines how to interpret the expression that defines
     *         what the context of the extension is.). This is the underlying object
     *         with id, value and extensions. The accessor "getType" gives direct
     *         access to the value
     */
    public Enumeration<ExtensionContextType> getTypeElement() {
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureDefinitionContextComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<ExtensionContextType>(new ExtensionContextTypeEnumFactory()); // bb
      return this.type;
    }

    public boolean hasTypeElement() {
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() {
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Defines how to interpret the expression that
     *              defines what the context of the extension is.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getType" gives direct access to the value
     */
    public StructureDefinitionContextComponent setTypeElement(Enumeration<ExtensionContextType> value) {
      this.type = value;
      return this;
    }

    /**
     * @return Defines how to interpret the expression that defines what the context
     *         of the extension is.
     */
    public ExtensionContextType getType() {
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value Defines how to interpret the expression that defines what the
     *              context of the extension is.
     */
    public StructureDefinitionContextComponent setType(ExtensionContextType value) {
      if (this.type == null)
        this.type = new Enumeration<ExtensionContextType>(new ExtensionContextTypeEnumFactory());
      this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #expression} (An expression that defines where an extension
     *         can be used in resources.). This is the underlying object with id,
     *         value and extensions. The accessor "getExpression" gives direct
     *         access to the value
     */
    public StringType getExpressionElement() {
      if (this.expression == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StructureDefinitionContextComponent.expression");
        else if (Configuration.doAutoCreate())
          this.expression = new StringType(); // bb
      return this.expression;
    }

    public boolean hasExpressionElement() {
      return this.expression != null && !this.expression.isEmpty();
    }

    public boolean hasExpression() {
      return this.expression != null && !this.expression.isEmpty();
    }

    /**
     * @param value {@link #expression} (An expression that defines where an
     *              extension can be used in resources.). This is the underlying
     *              object with id, value and extensions. The accessor
     *              "getExpression" gives direct access to the value
     */
    public StructureDefinitionContextComponent setExpressionElement(StringType value) {
      this.expression = value;
      return this;
    }

    /**
     * @return An expression that defines where an extension can be used in
     *         resources.
     */
    public String getExpression() {
      return this.expression == null ? null : this.expression.getValue();
    }

    /**
     * @param value An expression that defines where an extension can be used in
     *              resources.
     */
    public StructureDefinitionContextComponent setExpression(String value) {
      if (this.expression == null)
        this.expression = new StringType();
      this.expression.setValue(value);
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("type", "code",
          "Defines how to interpret the expression that defines what the context of the extension is.", 0, 1, type));
      children.add(new Property("expression", "string",
          "An expression that defines where an extension can be used in resources.", 0, 1, expression));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3575610:
        /* type */ return new Property("type", "code",
            "Defines how to interpret the expression that defines what the context of the extension is.", 0, 1, type);
      case -1795452264:
        /* expression */ return new Property("expression", "string",
            "An expression that defines where an extension can be used in resources.", 0, 1, expression);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // Enumeration<ExtensionContextType>
      case -1795452264:
        /* expression */ return this.expression == null ? new Base[0] : new Base[] { this.expression }; // StringType
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 3575610: // type
        value = new ExtensionContextTypeEnumFactory().fromType(castToCode(value));
        this.type = (Enumeration) value; // Enumeration<ExtensionContextType>
        return value;
      case -1795452264: // expression
        this.expression = castToString(value); // StringType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("type")) {
        value = new ExtensionContextTypeEnumFactory().fromType(castToCode(value));
        this.type = (Enumeration) value; // Enumeration<ExtensionContextType>
      } else if (name.equals("expression")) {
        this.expression = castToString(value); // StringType
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("type")) {
        this.type = null;
      } else if (name.equals("expression")) {
        this.expression = null;
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        return getTypeElement();
      case -1795452264:
        return getExpressionElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3575610:
        /* type */ return new String[] { "code" };
      case -1795452264:
        /* expression */ return new String[] { "string" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("type")) {
        throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.type");
      } else if (name.equals("expression")) {
        throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.expression");
      } else
        return super.addChild(name);
    }

    public StructureDefinitionContextComponent copy() {
      StructureDefinitionContextComponent dst = new StructureDefinitionContextComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(StructureDefinitionContextComponent dst) {
      super.copyValues(dst);
      dst.type = type == null ? null : type.copy();
      dst.expression = expression == null ? null : expression.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof StructureDefinitionContextComponent))
        return false;
      StructureDefinitionContextComponent o = (StructureDefinitionContextComponent) other_;
      return compareDeep(type, o.type, true) && compareDeep(expression, o.expression, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof StructureDefinitionContextComponent))
        return false;
      StructureDefinitionContextComponent o = (StructureDefinitionContextComponent) other_;
      return compareValues(type, o.type, true) && compareValues(expression, o.expression, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, expression);
    }

    public String fhirType() {
      return "StructureDefinition.context";

    }

  }

  @Block()
  public static class StructureDefinitionSnapshotComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Captures constraints on each element within the resource.
     */
    @Child(name = "element", type = {
        ElementDefinition.class }, order = 1, min = 1, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Definition of elements in the resource (if no StructureDefinition)", formalDefinition = "Captures constraints on each element within the resource.")
    protected List<ElementDefinition> element;

    private static final long serialVersionUID = 53896641L;

    /**
     * Constructor
     */
    public StructureDefinitionSnapshotComponent() {
      super();
    }

    /**
     * @return {@link #element} (Captures constraints on each element within the
     *         resource.)
     */
    public List<ElementDefinition> getElement() {
      if (this.element == null)
        this.element = new ArrayList<ElementDefinition>();
      return this.element;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StructureDefinitionSnapshotComponent setElement(List<ElementDefinition> theElement) {
      this.element = theElement;
      return this;
    }

    public boolean hasElement() {
      if (this.element == null)
        return false;
      for (ElementDefinition item : this.element)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ElementDefinition addElement() { // 3
      ElementDefinition t = new ElementDefinition();
      if (this.element == null)
        this.element = new ArrayList<ElementDefinition>();
      this.element.add(t);
      return t;
    }

    public StructureDefinitionSnapshotComponent addElement(ElementDefinition t) { // 3
      if (t == null)
        return this;
      if (this.element == null)
        this.element = new ArrayList<ElementDefinition>();
      this.element.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #element}, creating it
     *         if it does not already exist
     */
    public ElementDefinition getElementFirstRep() {
      if (getElement().isEmpty()) {
        addElement();
      }
      return getElement().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("element", "ElementDefinition",
          "Captures constraints on each element within the resource.", 0, java.lang.Integer.MAX_VALUE, element));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1662836996:
        /* element */ return new Property("element", "ElementDefinition",
            "Captures constraints on each element within the resource.", 0, java.lang.Integer.MAX_VALUE, element);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1662836996:
        /* element */ return this.element == null ? new Base[0] : this.element.toArray(new Base[this.element.size()]); // ElementDefinition
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -1662836996: // element
        this.getElement().add(castToElementDefinition(value)); // ElementDefinition
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("element")) {
        this.getElement().add(castToElementDefinition(value));
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("element")) {
        this.getElement().remove(castToElementDefinition(value));
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1662836996:
        return addElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1662836996:
        /* element */ return new String[] { "ElementDefinition" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("element")) {
        return addElement();
      } else
        return super.addChild(name);
    }

    public StructureDefinitionSnapshotComponent copy() {
      StructureDefinitionSnapshotComponent dst = new StructureDefinitionSnapshotComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(StructureDefinitionSnapshotComponent dst) {
      super.copyValues(dst);
      if (element != null) {
        dst.element = new ArrayList<ElementDefinition>();
        for (ElementDefinition i : element)
          dst.element.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof StructureDefinitionSnapshotComponent))
        return false;
      StructureDefinitionSnapshotComponent o = (StructureDefinitionSnapshotComponent) other_;
      return compareDeep(element, o.element, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof StructureDefinitionSnapshotComponent))
        return false;
      StructureDefinitionSnapshotComponent o = (StructureDefinitionSnapshotComponent) other_;
      return true;
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(element);
    }

    public String fhirType() {
      return "StructureDefinition.snapshot";

    }

    public ElementDefinition getElementByPath(String path) {
      if (path == null) {
        return null;
      }
      for (ElementDefinition ed : getElement()) {
        if (path.equals(ed.getPath()) || (path+"[x]").equals(ed.getPath())) {
          return ed;
        }
      }
      return null;
    }


    public ElementDefinition getElementById(String id) {
      if (id == null) {
        return null;
      }
      for (ElementDefinition ed : getElement()) {
        if (id.equals(ed.getId())) {
          return ed;
        }
      }
      return null;
    }

  }

  @Block()
  public static class StructureDefinitionDifferentialComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Captures constraints on each element within the resource.
     */
    @Child(name = "element", type = {
        ElementDefinition.class }, order = 1, min = 1, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Definition of elements in the resource (if no StructureDefinition)", formalDefinition = "Captures constraints on each element within the resource.")
    protected List<ElementDefinition> element;

    private static final long serialVersionUID = 53896641L;

    /**
     * Constructor
     */
    public StructureDefinitionDifferentialComponent() {
      super();
    }

    /**
     * @return {@link #element} (Captures constraints on each element within the
     *         resource.)
     */
    public List<ElementDefinition> getElement() {
      if (this.element == null)
        this.element = new ArrayList<ElementDefinition>();
      return this.element;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StructureDefinitionDifferentialComponent setElement(List<ElementDefinition> theElement) {
      this.element = theElement;
      return this;
    }

    public boolean hasElement() {
      if (this.element == null)
        return false;
      for (ElementDefinition item : this.element)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ElementDefinition addElement() { // 3
      ElementDefinition t = new ElementDefinition();
      if (this.element == null)
        this.element = new ArrayList<ElementDefinition>();
      this.element.add(t);
      return t;
    }

    public StructureDefinitionDifferentialComponent addElement(ElementDefinition t) { // 3
      if (t == null)
        return this;
      if (this.element == null)
        this.element = new ArrayList<ElementDefinition>();
      this.element.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #element}, creating it
     *         if it does not already exist
     */
    public ElementDefinition getElementFirstRep() {
      if (getElement().isEmpty()) {
        addElement();
      }
      return getElement().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("element", "ElementDefinition",
          "Captures constraints on each element within the resource.", 0, java.lang.Integer.MAX_VALUE, element));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1662836996:
        /* element */ return new Property("element", "ElementDefinition",
            "Captures constraints on each element within the resource.", 0, java.lang.Integer.MAX_VALUE, element);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1662836996:
        /* element */ return this.element == null ? new Base[0] : this.element.toArray(new Base[this.element.size()]); // ElementDefinition
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -1662836996: // element
        this.getElement().add(castToElementDefinition(value)); // ElementDefinition
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("element")) {
        this.getElement().add(castToElementDefinition(value));
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("element")) {
        this.getElement().remove(castToElementDefinition(value));
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1662836996:
        return addElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1662836996:
        /* element */ return new String[] { "ElementDefinition" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("element")) {
        return addElement();
      } else
        return super.addChild(name);
    }

    public StructureDefinitionDifferentialComponent copy() {
      StructureDefinitionDifferentialComponent dst = new StructureDefinitionDifferentialComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(StructureDefinitionDifferentialComponent dst) {
      super.copyValues(dst);
      if (element != null) {
        dst.element = new ArrayList<ElementDefinition>();
        for (ElementDefinition i : element)
          dst.element.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof StructureDefinitionDifferentialComponent))
        return false;
      StructureDefinitionDifferentialComponent o = (StructureDefinitionDifferentialComponent) other_;
      return compareDeep(element, o.element, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof StructureDefinitionDifferentialComponent))
        return false;
      StructureDefinitionDifferentialComponent o = (StructureDefinitionDifferentialComponent) other_;
      return true;
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(element);
    }

    public String fhirType() {
      return "StructureDefinition.differential";

    }

  }

  /**
   * A formal identifier that is used to identify this structure definition when
   * it is represented in other formats, or referenced in a specification, model,
   * design or an instance.
   */
  @Child(name = "identifier", type = {
      Identifier.class }, order = 0, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Additional identifier for the structure definition", formalDefinition = "A formal identifier that is used to identify this structure definition when it is represented in other formats, or referenced in a specification, model, design or an instance.")
  protected List<Identifier> identifier;

  /**
   * Explanation of why this structure definition is needed and why it has been
   * designed as it has.
   */
  @Child(name = "purpose", type = {
      MarkdownType.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Why this structure definition is defined", formalDefinition = "Explanation of why this structure definition is needed and why it has been designed as it has.")
  protected MarkdownType purpose;

  /**
   * A copyright statement relating to the structure definition and/or its
   * contents. Copyright statements are generally legal restrictions on the use
   * and publishing of the structure definition.
   */
  @Child(name = "copyright", type = {
      MarkdownType.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Use and/or publishing restrictions", formalDefinition = "A copyright statement relating to the structure definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the structure definition.")
  protected MarkdownType copyright;

  /**
   * A set of key words or terms from external terminologies that may be used to
   * assist with indexing and searching of templates nby describing the use of
   * this structure definition, or the content it describes.
   */
  @Child(name = "keyword", type = {
      Coding.class }, order = 3, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Assist with indexing and finding", formalDefinition = "A set of key words or terms from external terminologies that may be used to assist with indexing and searching of templates nby describing the use of this structure definition, or the content it describes.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/definition-use")
  protected List<Coding> keyword;

  /**
   * The version of the FHIR specification on which this StructureDefinition is
   * based - this is the formal version of the specification, without the revision
   * number, e.g. [publication].[major].[minor], which is 4.0.1. for this version.
   */
  @Child(name = "fhirVersion", type = { CodeType.class }, order = 4, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "FHIR Version this StructureDefinition targets", formalDefinition = "The version of the FHIR specification on which this StructureDefinition is based - this is the formal version of the specification, without the revision number, e.g. [publication].[major].[minor], which is 4.0.1. for this version.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/FHIR-version")
  protected Enumeration<FHIRVersion> fhirVersion;

  /**
   * An external specification that the content is mapped to.
   */
  @Child(name = "mapping", type = {}, order = 5, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "External specification that the content is mapped to", formalDefinition = "An external specification that the content is mapped to.")
  protected List<StructureDefinitionMappingComponent> mapping;

  /**
   * Defines the kind of structure that this definition is describing.
   */
  @Child(name = "kind", type = { CodeType.class }, order = 6, min = 1, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "primitive-type | complex-type | resource | logical", formalDefinition = "Defines the kind of structure that this definition is describing.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/structure-definition-kind")
  protected Enumeration<StructureDefinitionKind> kind;

  /**
   * Whether structure this definition describes is abstract or not - that is,
   * whether the structure is not intended to be instantiated. For Resources and
   * Data types, abstract types will never be exchanged between systems.
   */
  @Child(name = "abstract", type = { BooleanType.class }, order = 7, min = 1, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Whether the structure is abstract", formalDefinition = "Whether structure this definition describes is abstract or not  - that is, whether the structure is not intended to be instantiated. For Resources and Data types, abstract types will never be exchanged  between systems.")
  protected BooleanType abstract_;

  /**
   * Identifies the types of resource or data type elements to which the extension
   * can be applied.
   */
  @Child(name = "context", type = {}, order = 8, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "If an extension, where it can be used in instances", formalDefinition = "Identifies the types of resource or data type elements to which the extension can be applied.")
  protected List<StructureDefinitionContextComponent> context;

  /**
   * A set of rules as FHIRPath Invariants about when the extension can be used
   * (e.g. co-occurrence variants for the extension). All the rules must be true.
   */
  @Child(name = "contextInvariant", type = {
      StringType.class }, order = 9, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "FHIRPath invariants - when the extension can be used", formalDefinition = "A set of rules as FHIRPath Invariants about when the extension can be used (e.g. co-occurrence variants for the extension). All the rules must be true.")
  protected List<StringType> contextInvariant;

  /**
   * The type this structure describes. If the derivation kind is 'specialization'
   * then this is the master definition for a type, and there is always one of
   * these (a data type, an extension, a resource, including abstract ones).
   * Otherwise the structure definition is a constraint on the stated type (and in
   * this case, the type cannot be an abstract type). References are URLs that are
   * relative to http://hl7.org/fhir/StructureDefinition e.g. "string" is a
   * reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs
   * are only allowed in logical models.
   */
  @Child(name = "type", type = { UriType.class }, order = 10, min = 1, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Type defined or constrained by this structure", formalDefinition = "The type this structure describes. If the derivation kind is 'specialization' then this is the master definition for a type, and there is always one of these (a data type, an extension, a resource, including abstract ones). Otherwise the structure definition is a constraint on the stated type (and in this case, the type cannot be an abstract type).  References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. \"string\" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical models.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/defined-types")
  protected UriType type;

  /**
   * An absolute URI that is the base structure from which this type is derived,
   * either by specialization or constraint.
   */
  @Child(name = "baseDefinition", type = {
      CanonicalType.class }, order = 11, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Definition that this type is constrained/specialized from", formalDefinition = "An absolute URI that is the base structure from which this type is derived, either by specialization or constraint.")
  protected CanonicalType baseDefinition;

  /**
   * How the type relates to the baseDefinition.
   */
  @Child(name = "derivation", type = { CodeType.class }, order = 12, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "specialization | constraint - How relates to base definition", formalDefinition = "How the type relates to the baseDefinition.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/type-derivation-rule")
  protected Enumeration<TypeDerivationRule> derivation;

  /**
   * A snapshot view is expressed in a standalone form that can be used and
   * interpreted without considering the base StructureDefinition.
   */
  @Child(name = "snapshot", type = {}, order = 13, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Snapshot view of the structure", formalDefinition = "A snapshot view is expressed in a standalone form that can be used and interpreted without considering the base StructureDefinition.")
  protected StructureDefinitionSnapshotComponent snapshot;

  /**
   * A differential view is expressed relative to the base StructureDefinition - a
   * statement of differences that it applies.
   */
  @Child(name = "differential", type = {}, order = 14, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Differential view of the structure", formalDefinition = "A differential view is expressed relative to the base StructureDefinition - a statement of differences that it applies.")
  protected StructureDefinitionDifferentialComponent differential;

  private static final long serialVersionUID = 316076774L;

  /**
   * Constructor
   */
  public StructureDefinition() {
    super();
  }

  /**
   * Constructor
   */
  public StructureDefinition(UriType url, StringType name, Enumeration<PublicationStatus> status,
      Enumeration<StructureDefinitionKind> kind, BooleanType abstract_, UriType type) {
    super();
    this.url = url;
    this.name = name;
    this.status = status;
    this.kind = kind;
    this.abstract_ = abstract_;
    this.type = type;
  }

  /**
   * @return {@link #url} (An absolute URI that is used to identify this structure
   *         definition when it is referenced in a specification, model, design or
   *         an instance; also called its canonical identifier. This SHOULD be
   *         globally unique and SHOULD be a literal address at which at which an
   *         authoritative instance of this structure definition is (or will be)
   *         published. This URL can be the target of a canonical reference. It
   *         SHALL remain the same when the structure definition is stored on
   *         different servers.). This is the underlying object with id, value and
   *         extensions. The accessor "getUrl" gives direct access to the value
   */
  public UriType getUrlElement() {
    if (this.url == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.url");
      else if (Configuration.doAutoCreate())
        this.url = new UriType(); // bb
    return this.url;
  }

  public boolean hasUrlElement() {
    return this.url != null && !this.url.isEmpty();
  }

  public boolean hasUrl() {
    return this.url != null && !this.url.isEmpty();
  }

  /**
   * @param value {@link #url} (An absolute URI that is used to identify this
   *              structure definition when it is referenced in a specification,
   *              model, design or an instance; also called its canonical
   *              identifier. This SHOULD be globally unique and SHOULD be a
   *              literal address at which at which an authoritative instance of
   *              this structure definition is (or will be) published. This URL
   *              can be the target of a canonical reference. It SHALL remain the
   *              same when the structure definition is stored on different
   *              servers.). This is the underlying object with id, value and
   *              extensions. The accessor "getUrl" gives direct access to the
   *              value
   */
  public StructureDefinition setUrlElement(UriType value) {
    this.url = value;
    return this;
  }

  /**
   * @return An absolute URI that is used to identify this structure definition
   *         when it is referenced in a specification, model, design or an
   *         instance; also called its canonical identifier. This SHOULD be
   *         globally unique and SHOULD be a literal address at which at which an
   *         authoritative instance of this structure definition is (or will be)
   *         published. This URL can be the target of a canonical reference. It
   *         SHALL remain the same when the structure definition is stored on
   *         different servers.
   */
  public String getUrl() {
    return this.url == null ? null : this.url.getValue();
  }

  /**
   * @param value An absolute URI that is used to identify this structure
   *              definition when it is referenced in a specification, model,
   *              design or an instance; also called its canonical identifier.
   *              This SHOULD be globally unique and SHOULD be a literal address
   *              at which at which an authoritative instance of this structure
   *              definition is (or will be) published. This URL can be the target
   *              of a canonical reference. It SHALL remain the same when the
   *              structure definition is stored on different servers.
   */
  public StructureDefinition setUrl(String value) {
    if (this.url == null)
      this.url = new UriType();
    this.url.setValue(value);
    return this;
  }

  /**
   * @return {@link #identifier} (A formal identifier that is used to identify
   *         this structure definition when it is represented in other formats, or
   *         referenced in a specification, model, design or an instance.)
   */
  public List<Identifier> getIdentifier() {
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    return this.identifier;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public StructureDefinition setIdentifier(List<Identifier> theIdentifier) {
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

  public Identifier addIdentifier() { // 3
    Identifier t = new Identifier();
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    this.identifier.add(t);
    return t;
  }

  public StructureDefinition addIdentifier(Identifier t) { // 3
    if (t == null)
      return this;
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    this.identifier.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #identifier}, creating
   *         it if it does not already exist
   */
  public Identifier getIdentifierFirstRep() {
    if (getIdentifier().isEmpty()) {
      addIdentifier();
    }
    return getIdentifier().get(0);
  }

  /**
   * @return {@link #version} (The identifier that is used to identify this
   *         version of the structure definition when it is referenced in a
   *         specification, model, design or instance. This is an arbitrary value
   *         managed by the structure definition author and is not expected to be
   *         globally unique. For example, it might be a timestamp (e.g. yyyymmdd)
   *         if a managed version is not available. There is also no expectation
   *         that versions can be placed in a lexicographical sequence.). This is
   *         the underlying object with id, value and extensions. The accessor
   *         "getVersion" gives direct access to the value
   */
  public StringType getVersionElement() {
    if (this.version == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.version");
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
   * @param value {@link #version} (The identifier that is used to identify this
   *              version of the structure definition when it is referenced in a
   *              specification, model, design or instance. This is an arbitrary
   *              value managed by the structure definition author and is not
   *              expected to be globally unique. For example, it might be a
   *              timestamp (e.g. yyyymmdd) if a managed version is not available.
   *              There is also no expectation that versions can be placed in a
   *              lexicographical sequence.). This is the underlying object with
   *              id, value and extensions. The accessor "getVersion" gives direct
   *              access to the value
   */
  public StructureDefinition setVersionElement(StringType value) {
    this.version = value;
    return this;
  }

  /**
   * @return The identifier that is used to identify this version of the structure
   *         definition when it is referenced in a specification, model, design or
   *         instance. This is an arbitrary value managed by the structure
   *         definition author and is not expected to be globally unique. For
   *         example, it might be a timestamp (e.g. yyyymmdd) if a managed version
   *         is not available. There is also no expectation that versions can be
   *         placed in a lexicographical sequence.
   */
  public String getVersion() {
    return this.version == null ? null : this.version.getValue();
  }

  /**
   * @param value The identifier that is used to identify this version of the
   *              structure definition when it is referenced in a specification,
   *              model, design or instance. This is an arbitrary value managed by
   *              the structure definition author and is not expected to be
   *              globally unique. For example, it might be a timestamp (e.g.
   *              yyyymmdd) if a managed version is not available. There is also
   *              no expectation that versions can be placed in a lexicographical
   *              sequence.
   */
  public StructureDefinition setVersion(String value) {
    if (Utilities.noString(value))
      this.version = null;
    else {
      if (this.version == null)
        this.version = new StringType();
      this.version.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #name} (A natural language name identifying the structure
   *         definition. This name should be usable as an identifier for the
   *         module by machine processing applications such as code generation.).
   *         This is the underlying object with id, value and extensions. The
   *         accessor "getName" gives direct access to the value
   */
  public StringType getNameElement() {
    if (this.name == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.name");
      else if (Configuration.doAutoCreate())
        this.name = new StringType(); // bb
    return this.name;
  }

  public boolean hasNameElement() {
    return this.name != null && !this.name.isEmpty();
  }

  public boolean hasName() {
    return this.name != null && !this.name.isEmpty();
  }

  /**
   * @param value {@link #name} (A natural language name identifying the structure
   *              definition. This name should be usable as an identifier for the
   *              module by machine processing applications such as code
   *              generation.). This is the underlying object with id, value and
   *              extensions. The accessor "getName" gives direct access to the
   *              value
   */
  public StructureDefinition setNameElement(StringType value) {
    this.name = value;
    return this;
  }

  /**
   * @return A natural language name identifying the structure definition. This
   *         name should be usable as an identifier for the module by machine
   *         processing applications such as code generation.
   */
  public String getName() {
    return this.name == null ? null : this.name.getValue();
  }

  /**
   * @param value A natural language name identifying the structure definition.
   *              This name should be usable as an identifier for the module by
   *              machine processing applications such as code generation.
   */
  public StructureDefinition setName(String value) {
    if (this.name == null)
      this.name = new StringType();
    this.name.setValue(value);
    return this;
  }

  /**
   * @return {@link #title} (A short, descriptive, user-friendly title for the
   *         structure definition.). This is the underlying object with id, value
   *         and extensions. The accessor "getTitle" gives direct access to the
   *         value
   */
  public StringType getTitleElement() {
    if (this.title == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.title");
      else if (Configuration.doAutoCreate())
        this.title = new StringType(); // bb
    return this.title;
  }

  public boolean hasTitleElement() {
    return this.title != null && !this.title.isEmpty();
  }

  public boolean hasTitle() {
    return this.title != null && !this.title.isEmpty();
  }

  /**
   * @param value {@link #title} (A short, descriptive, user-friendly title for
   *              the structure definition.). This is the underlying object with
   *              id, value and extensions. The accessor "getTitle" gives direct
   *              access to the value
   */
  public StructureDefinition setTitleElement(StringType value) {
    this.title = value;
    return this;
  }

  /**
   * @return A short, descriptive, user-friendly title for the structure
   *         definition.
   */
  public String getTitle() {
    return this.title == null ? null : this.title.getValue();
  }

  /**
   * @param value A short, descriptive, user-friendly title for the structure
   *              definition.
   */
  public StructureDefinition setTitle(String value) {
    if (Utilities.noString(value))
      this.title = null;
    else {
      if (this.title == null)
        this.title = new StringType();
      this.title.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #status} (The status of this structure definition. Enables
   *         tracking the life-cycle of the content.). This is the underlying
   *         object with id, value and extensions. The accessor "getStatus" gives
   *         direct access to the value
   */
  public Enumeration<PublicationStatus> getStatusElement() {
    if (this.status == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.status");
      else if (Configuration.doAutoCreate())
        this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
    return this.status;
  }

  public boolean hasStatusElement() {
    return this.status != null && !this.status.isEmpty();
  }

  public boolean hasStatus() {
    return this.status != null && !this.status.isEmpty();
  }

  /**
   * @param value {@link #status} (The status of this structure definition.
   *              Enables tracking the life-cycle of the content.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getStatus" gives direct access to the value
   */
  public StructureDefinition setStatusElement(Enumeration<PublicationStatus> value) {
    this.status = value;
    return this;
  }

  /**
   * @return The status of this structure definition. Enables tracking the
   *         life-cycle of the content.
   */
  public PublicationStatus getStatus() {
    return this.status == null ? null : this.status.getValue();
  }

  /**
   * @param value The status of this structure definition. Enables tracking the
   *              life-cycle of the content.
   */
  public StructureDefinition setStatus(PublicationStatus value) {
    if (this.status == null)
      this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
    this.status.setValue(value);
    return this;
  }

  /**
   * @return {@link #experimental} (A Boolean value to indicate that this
   *         structure definition is authored for testing purposes (or
   *         education/evaluation/marketing) and is not intended to be used for
   *         genuine usage.). This is the underlying object with id, value and
   *         extensions. The accessor "getExperimental" gives direct access to the
   *         value
   */
  public BooleanType getExperimentalElement() {
    if (this.experimental == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.experimental");
      else if (Configuration.doAutoCreate())
        this.experimental = new BooleanType(); // bb
    return this.experimental;
  }

  public boolean hasExperimentalElement() {
    return this.experimental != null && !this.experimental.isEmpty();
  }

  public boolean hasExperimental() {
    return this.experimental != null && !this.experimental.isEmpty();
  }

  /**
   * @param value {@link #experimental} (A Boolean value to indicate that this
   *              structure definition is authored for testing purposes (or
   *              education/evaluation/marketing) and is not intended to be used
   *              for genuine usage.). This is the underlying object with id,
   *              value and extensions. The accessor "getExperimental" gives
   *              direct access to the value
   */
  public StructureDefinition setExperimentalElement(BooleanType value) {
    this.experimental = value;
    return this;
  }

  /**
   * @return A Boolean value to indicate that this structure definition is
   *         authored for testing purposes (or education/evaluation/marketing) and
   *         is not intended to be used for genuine usage.
   */
  public boolean getExperimental() {
    return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
  }

  /**
   * @param value A Boolean value to indicate that this structure definition is
   *              authored for testing purposes (or
   *              education/evaluation/marketing) and is not intended to be used
   *              for genuine usage.
   */
  public StructureDefinition setExperimental(boolean value) {
    if (this.experimental == null)
      this.experimental = new BooleanType();
    this.experimental.setValue(value);
    return this;
  }

  /**
   * @return {@link #date} (The date (and optionally time) when the structure
   *         definition was published. The date must change when the business
   *         version changes and it must change if the status code changes. In
   *         addition, it should change when the substantive content of the
   *         structure definition changes.). This is the underlying object with
   *         id, value and extensions. The accessor "getDate" gives direct access
   *         to the value
   */
  public DateTimeType getDateElement() {
    if (this.date == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.date");
      else if (Configuration.doAutoCreate())
        this.date = new DateTimeType(); // bb
    return this.date;
  }

  public boolean hasDateElement() {
    return this.date != null && !this.date.isEmpty();
  }

  public boolean hasDate() {
    return this.date != null && !this.date.isEmpty();
  }

  /**
   * @param value {@link #date} (The date (and optionally time) when the structure
   *              definition was published. The date must change when the business
   *              version changes and it must change if the status code changes.
   *              In addition, it should change when the substantive content of
   *              the structure definition changes.). This is the underlying
   *              object with id, value and extensions. The accessor "getDate"
   *              gives direct access to the value
   */
  public StructureDefinition setDateElement(DateTimeType value) {
    this.date = value;
    return this;
  }

  /**
   * @return The date (and optionally time) when the structure definition was
   *         published. The date must change when the business version changes and
   *         it must change if the status code changes. In addition, it should
   *         change when the substantive content of the structure definition
   *         changes.
   */
  public Date getDate() {
    return this.date == null ? null : this.date.getValue();
  }

  /**
   * @param value The date (and optionally time) when the structure definition was
   *              published. The date must change when the business version
   *              changes and it must change if the status code changes. In
   *              addition, it should change when the substantive content of the
   *              structure definition changes.
   */
  public StructureDefinition setDate(Date value) {
    if (value == null)
      this.date = null;
    else {
      if (this.date == null)
        this.date = new DateTimeType();
      this.date.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #publisher} (The name of the organization or individual that
   *         published the structure definition.). This is the underlying object
   *         with id, value and extensions. The accessor "getPublisher" gives
   *         direct access to the value
   */
  public StringType getPublisherElement() {
    if (this.publisher == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.publisher");
      else if (Configuration.doAutoCreate())
        this.publisher = new StringType(); // bb
    return this.publisher;
  }

  public boolean hasPublisherElement() {
    return this.publisher != null && !this.publisher.isEmpty();
  }

  public boolean hasPublisher() {
    return this.publisher != null && !this.publisher.isEmpty();
  }

  /**
   * @param value {@link #publisher} (The name of the organization or individual
   *              that published the structure definition.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getPublisher" gives direct access to the value
   */
  public StructureDefinition setPublisherElement(StringType value) {
    this.publisher = value;
    return this;
  }

  /**
   * @return The name of the organization or individual that published the
   *         structure definition.
   */
  public String getPublisher() {
    return this.publisher == null ? null : this.publisher.getValue();
  }

  /**
   * @param value The name of the organization or individual that published the
   *              structure definition.
   */
  public StructureDefinition setPublisher(String value) {
    if (Utilities.noString(value))
      this.publisher = null;
    else {
      if (this.publisher == null)
        this.publisher = new StringType();
      this.publisher.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #contact} (Contact details to assist a user in finding and
   *         communicating with the publisher.)
   */
  public List<ContactDetail> getContact() {
    if (this.contact == null)
      this.contact = new ArrayList<ContactDetail>();
    return this.contact;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public StructureDefinition setContact(List<ContactDetail> theContact) {
    this.contact = theContact;
    return this;
  }

  public boolean hasContact() {
    if (this.contact == null)
      return false;
    for (ContactDetail item : this.contact)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public ContactDetail addContact() { // 3
    ContactDetail t = new ContactDetail();
    if (this.contact == null)
      this.contact = new ArrayList<ContactDetail>();
    this.contact.add(t);
    return t;
  }

  public StructureDefinition addContact(ContactDetail t) { // 3
    if (t == null)
      return this;
    if (this.contact == null)
      this.contact = new ArrayList<ContactDetail>();
    this.contact.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #contact}, creating it
   *         if it does not already exist
   */
  public ContactDetail getContactFirstRep() {
    if (getContact().isEmpty()) {
      addContact();
    }
    return getContact().get(0);
  }

  /**
   * @return {@link #description} (A free text natural language description of the
   *         structure definition from a consumer's perspective.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getDescription" gives direct access to the value
   */
  public MarkdownType getDescriptionElement() {
    if (this.description == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.description");
      else if (Configuration.doAutoCreate())
        this.description = new MarkdownType(); // bb
    return this.description;
  }

  public boolean hasDescriptionElement() {
    return this.description != null && !this.description.isEmpty();
  }

  public boolean hasDescription() {
    return this.description != null && !this.description.isEmpty();
  }

  /**
   * @param value {@link #description} (A free text natural language description
   *              of the structure definition from a consumer's perspective.).
   *              This is the underlying object with id, value and extensions. The
   *              accessor "getDescription" gives direct access to the value
   */
  public StructureDefinition setDescriptionElement(MarkdownType value) {
    this.description = value;
    return this;
  }

  /**
   * @return A free text natural language description of the structure definition
   *         from a consumer's perspective.
   */
  public String getDescription() {
    return this.description == null ? null : this.description.getValue();
  }

  /**
   * @param value A free text natural language description of the structure
   *              definition from a consumer's perspective.
   */
  public StructureDefinition setDescription(String value) {
    if (value == null)
      this.description = null;
    else {
      if (this.description == null)
        this.description = new MarkdownType();
      this.description.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #useContext} (The content was developed with a focus and
   *         intent of supporting the contexts that are listed. These contexts may
   *         be general categories (gender, age, ...) or may be references to
   *         specific programs (insurance plans, studies, ...) and may be used to
   *         assist with indexing and searching for appropriate structure
   *         definition instances.)
   */
  public List<UsageContext> getUseContext() {
    if (this.useContext == null)
      this.useContext = new ArrayList<UsageContext>();
    return this.useContext;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public StructureDefinition setUseContext(List<UsageContext> theUseContext) {
    this.useContext = theUseContext;
    return this;
  }

  public boolean hasUseContext() {
    if (this.useContext == null)
      return false;
    for (UsageContext item : this.useContext)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public UsageContext addUseContext() { // 3
    UsageContext t = new UsageContext();
    if (this.useContext == null)
      this.useContext = new ArrayList<UsageContext>();
    this.useContext.add(t);
    return t;
  }

  public StructureDefinition addUseContext(UsageContext t) { // 3
    if (t == null)
      return this;
    if (this.useContext == null)
      this.useContext = new ArrayList<UsageContext>();
    this.useContext.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #useContext}, creating
   *         it if it does not already exist
   */
  public UsageContext getUseContextFirstRep() {
    if (getUseContext().isEmpty()) {
      addUseContext();
    }
    return getUseContext().get(0);
  }

  /**
   * @return {@link #jurisdiction} (A legal or geographic region in which the
   *         structure definition is intended to be used.)
   */
  public List<CodeableConcept> getJurisdiction() {
    if (this.jurisdiction == null)
      this.jurisdiction = new ArrayList<CodeableConcept>();
    return this.jurisdiction;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public StructureDefinition setJurisdiction(List<CodeableConcept> theJurisdiction) {
    this.jurisdiction = theJurisdiction;
    return this;
  }

  public boolean hasJurisdiction() {
    if (this.jurisdiction == null)
      return false;
    for (CodeableConcept item : this.jurisdiction)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public CodeableConcept addJurisdiction() { // 3
    CodeableConcept t = new CodeableConcept();
    if (this.jurisdiction == null)
      this.jurisdiction = new ArrayList<CodeableConcept>();
    this.jurisdiction.add(t);
    return t;
  }

  public StructureDefinition addJurisdiction(CodeableConcept t) { // 3
    if (t == null)
      return this;
    if (this.jurisdiction == null)
      this.jurisdiction = new ArrayList<CodeableConcept>();
    this.jurisdiction.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #jurisdiction},
   *         creating it if it does not already exist
   */
  public CodeableConcept getJurisdictionFirstRep() {
    if (getJurisdiction().isEmpty()) {
      addJurisdiction();
    }
    return getJurisdiction().get(0);
  }

  /**
   * @return {@link #purpose} (Explanation of why this structure definition is
   *         needed and why it has been designed as it has.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getPurpose" gives direct access to the value
   */
  public MarkdownType getPurposeElement() {
    if (this.purpose == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.purpose");
      else if (Configuration.doAutoCreate())
        this.purpose = new MarkdownType(); // bb
    return this.purpose;
  }

  public boolean hasPurposeElement() {
    return this.purpose != null && !this.purpose.isEmpty();
  }

  public boolean hasPurpose() {
    return this.purpose != null && !this.purpose.isEmpty();
  }

  /**
   * @param value {@link #purpose} (Explanation of why this structure definition
   *              is needed and why it has been designed as it has.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getPurpose" gives direct access to the value
   */
  public StructureDefinition setPurposeElement(MarkdownType value) {
    this.purpose = value;
    return this;
  }

  /**
   * @return Explanation of why this structure definition is needed and why it has
   *         been designed as it has.
   */
  public String getPurpose() {
    return this.purpose == null ? null : this.purpose.getValue();
  }

  /**
   * @param value Explanation of why this structure definition is needed and why
   *              it has been designed as it has.
   */
  public StructureDefinition setPurpose(String value) {
    if (value == null)
      this.purpose = null;
    else {
      if (this.purpose == null)
        this.purpose = new MarkdownType();
      this.purpose.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #copyright} (A copyright statement relating to the structure
   *         definition and/or its contents. Copyright statements are generally
   *         legal restrictions on the use and publishing of the structure
   *         definition.). This is the underlying object with id, value and
   *         extensions. The accessor "getCopyright" gives direct access to the
   *         value
   */
  public MarkdownType getCopyrightElement() {
    if (this.copyright == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.copyright");
      else if (Configuration.doAutoCreate())
        this.copyright = new MarkdownType(); // bb
    return this.copyright;
  }

  public boolean hasCopyrightElement() {
    return this.copyright != null && !this.copyright.isEmpty();
  }

  public boolean hasCopyright() {
    return this.copyright != null && !this.copyright.isEmpty();
  }

  /**
   * @param value {@link #copyright} (A copyright statement relating to the
   *              structure definition and/or its contents. Copyright statements
   *              are generally legal restrictions on the use and publishing of
   *              the structure definition.). This is the underlying object with
   *              id, value and extensions. The accessor "getCopyright" gives
   *              direct access to the value
   */
  public StructureDefinition setCopyrightElement(MarkdownType value) {
    this.copyright = value;
    return this;
  }

  /**
   * @return A copyright statement relating to the structure definition and/or its
   *         contents. Copyright statements are generally legal restrictions on
   *         the use and publishing of the structure definition.
   */
  public String getCopyright() {
    return this.copyright == null ? null : this.copyright.getValue();
  }

  /**
   * @param value A copyright statement relating to the structure definition
   *              and/or its contents. Copyright statements are generally legal
   *              restrictions on the use and publishing of the structure
   *              definition.
   */
  public StructureDefinition setCopyright(String value) {
    if (value == null)
      this.copyright = null;
    else {
      if (this.copyright == null)
        this.copyright = new MarkdownType();
      this.copyright.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #keyword} (A set of key words or terms from external
   *         terminologies that may be used to assist with indexing and searching
   *         of templates nby describing the use of this structure definition, or
   *         the content it describes.)
   */
  public List<Coding> getKeyword() {
    if (this.keyword == null)
      this.keyword = new ArrayList<Coding>();
    return this.keyword;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public StructureDefinition setKeyword(List<Coding> theKeyword) {
    this.keyword = theKeyword;
    return this;
  }

  public boolean hasKeyword() {
    if (this.keyword == null)
      return false;
    for (Coding item : this.keyword)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Coding addKeyword() { // 3
    Coding t = new Coding();
    if (this.keyword == null)
      this.keyword = new ArrayList<Coding>();
    this.keyword.add(t);
    return t;
  }

  public StructureDefinition addKeyword(Coding t) { // 3
    if (t == null)
      return this;
    if (this.keyword == null)
      this.keyword = new ArrayList<Coding>();
    this.keyword.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #keyword}, creating it
   *         if it does not already exist
   */
  public Coding getKeywordFirstRep() {
    if (getKeyword().isEmpty()) {
      addKeyword();
    }
    return getKeyword().get(0);
  }

  /**
   * @return {@link #fhirVersion} (The version of the FHIR specification on which
   *         this StructureDefinition is based - this is the formal version of the
   *         specification, without the revision number, e.g.
   *         [publication].[major].[minor], which is 4.0.1. for this version.).
   *         This is the underlying object with id, value and extensions. The
   *         accessor "getFhirVersion" gives direct access to the value
   */
  public Enumeration<FHIRVersion> getFhirVersionElement() {
    if (this.fhirVersion == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.fhirVersion");
      else if (Configuration.doAutoCreate())
        this.fhirVersion = new Enumeration<FHIRVersion>(new FHIRVersionEnumFactory()); // bb
    return this.fhirVersion;
  }

  public boolean hasFhirVersionElement() {
    return this.fhirVersion != null && !this.fhirVersion.isEmpty();
  }

  public boolean hasFhirVersion() {
    return this.fhirVersion != null && !this.fhirVersion.isEmpty();
  }

  /**
   * @param value {@link #fhirVersion} (The version of the FHIR specification on
   *              which this StructureDefinition is based - this is the formal
   *              version of the specification, without the revision number, e.g.
   *              [publication].[major].[minor], which is 4.0.1. for this
   *              version.). This is the underlying object with id, value and
   *              extensions. The accessor "getFhirVersion" gives direct access to
   *              the value
   */
  public StructureDefinition setFhirVersionElement(Enumeration<FHIRVersion> value) {
    this.fhirVersion = value;
    return this;
  }

  /**
   * @return The version of the FHIR specification on which this
   *         StructureDefinition is based - this is the formal version of the
   *         specification, without the revision number, e.g.
   *         [publication].[major].[minor], which is 4.0.1. for this version.
   */
  public FHIRVersion getFhirVersion() {
    return this.fhirVersion == null ? null : this.fhirVersion.getValue();
  }

  /**
   * @param value The version of the FHIR specification on which this
   *              StructureDefinition is based - this is the formal version of the
   *              specification, without the revision number, e.g.
   *              [publication].[major].[minor], which is 4.0.1. for this version.
   */
  public StructureDefinition setFhirVersion(FHIRVersion value) {
    if (value == null)
      this.fhirVersion = null;
    else {
      if (this.fhirVersion == null)
        this.fhirVersion = new Enumeration<FHIRVersion>(new FHIRVersionEnumFactory());
      this.fhirVersion.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #mapping} (An external specification that the content is
   *         mapped to.)
   */
  public List<StructureDefinitionMappingComponent> getMapping() {
    if (this.mapping == null)
      this.mapping = new ArrayList<StructureDefinitionMappingComponent>();
    return this.mapping;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public StructureDefinition setMapping(List<StructureDefinitionMappingComponent> theMapping) {
    this.mapping = theMapping;
    return this;
  }

  public boolean hasMapping() {
    if (this.mapping == null)
      return false;
    for (StructureDefinitionMappingComponent item : this.mapping)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public StructureDefinitionMappingComponent addMapping() { // 3
    StructureDefinitionMappingComponent t = new StructureDefinitionMappingComponent();
    if (this.mapping == null)
      this.mapping = new ArrayList<StructureDefinitionMappingComponent>();
    this.mapping.add(t);
    return t;
  }

  public StructureDefinition addMapping(StructureDefinitionMappingComponent t) { // 3
    if (t == null)
      return this;
    if (this.mapping == null)
      this.mapping = new ArrayList<StructureDefinitionMappingComponent>();
    this.mapping.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #mapping}, creating it
   *         if it does not already exist
   */
  public StructureDefinitionMappingComponent getMappingFirstRep() {
    if (getMapping().isEmpty()) {
      addMapping();
    }
    return getMapping().get(0);
  }

  /**
   * @return {@link #kind} (Defines the kind of structure that this definition is
   *         describing.). This is the underlying object with id, value and
   *         extensions. The accessor "getKind" gives direct access to the value
   */
  public Enumeration<StructureDefinitionKind> getKindElement() {
    if (this.kind == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.kind");
      else if (Configuration.doAutoCreate())
        this.kind = new Enumeration<StructureDefinitionKind>(new StructureDefinitionKindEnumFactory()); // bb
    return this.kind;
  }

  public boolean hasKindElement() {
    return this.kind != null && !this.kind.isEmpty();
  }

  public boolean hasKind() {
    return this.kind != null && !this.kind.isEmpty();
  }

  /**
   * @param value {@link #kind} (Defines the kind of structure that this
   *              definition is describing.). This is the underlying object with
   *              id, value and extensions. The accessor "getKind" gives direct
   *              access to the value
   */
  public StructureDefinition setKindElement(Enumeration<StructureDefinitionKind> value) {
    this.kind = value;
    return this;
  }

  /**
   * @return Defines the kind of structure that this definition is describing.
   */
  public StructureDefinitionKind getKind() {
    return this.kind == null ? null : this.kind.getValue();
  }

  /**
   * @param value Defines the kind of structure that this definition is
   *              describing.
   */
  public StructureDefinition setKind(StructureDefinitionKind value) {
    if (this.kind == null)
      this.kind = new Enumeration<StructureDefinitionKind>(new StructureDefinitionKindEnumFactory());
    this.kind.setValue(value);
    return this;
  }

  /**
   * @return {@link #abstract_} (Whether structure this definition describes is
   *         abstract or not - that is, whether the structure is not intended to
   *         be instantiated. For Resources and Data types, abstract types will
   *         never be exchanged between systems.). This is the underlying object
   *         with id, value and extensions. The accessor "getAbstract" gives
   *         direct access to the value
   */
  public BooleanType getAbstractElement() {
    if (this.abstract_ == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.abstract_");
      else if (Configuration.doAutoCreate())
        this.abstract_ = new BooleanType(); // bb
    return this.abstract_;
  }

  public boolean hasAbstractElement() {
    return this.abstract_ != null && !this.abstract_.isEmpty();
  }

  public boolean hasAbstract() {
    return this.abstract_ != null && !this.abstract_.isEmpty();
  }

  /**
   * @param value {@link #abstract_} (Whether structure this definition describes
   *              is abstract or not - that is, whether the structure is not
   *              intended to be instantiated. For Resources and Data types,
   *              abstract types will never be exchanged between systems.). This
   *              is the underlying object with id, value and extensions. The
   *              accessor "getAbstract" gives direct access to the value
   */
  public StructureDefinition setAbstractElement(BooleanType value) {
    this.abstract_ = value;
    return this;
  }

  /**
   * @return Whether structure this definition describes is abstract or not - that
   *         is, whether the structure is not intended to be instantiated. For
   *         Resources and Data types, abstract types will never be exchanged
   *         between systems.
   */
  public boolean getAbstract() {
    return this.abstract_ == null || this.abstract_.isEmpty() ? false : this.abstract_.getValue();
  }

  /**
   * @param value Whether structure this definition describes is abstract or not -
   *              that is, whether the structure is not intended to be
   *              instantiated. For Resources and Data types, abstract types will
   *              never be exchanged between systems.
   */
  public StructureDefinition setAbstract(boolean value) {
    if (this.abstract_ == null)
      this.abstract_ = new BooleanType();
    this.abstract_.setValue(value);
    return this;
  }

  /**
   * @return {@link #context} (Identifies the types of resource or data type
   *         elements to which the extension can be applied.)
   */
  public List<StructureDefinitionContextComponent> getContext() {
    if (this.context == null)
      this.context = new ArrayList<StructureDefinitionContextComponent>();
    return this.context;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public StructureDefinition setContext(List<StructureDefinitionContextComponent> theContext) {
    this.context = theContext;
    return this;
  }

  public boolean hasContext() {
    if (this.context == null)
      return false;
    for (StructureDefinitionContextComponent item : this.context)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public StructureDefinitionContextComponent addContext() { // 3
    StructureDefinitionContextComponent t = new StructureDefinitionContextComponent();
    if (this.context == null)
      this.context = new ArrayList<StructureDefinitionContextComponent>();
    this.context.add(t);
    return t;
  }

  public StructureDefinition addContext(StructureDefinitionContextComponent t) { // 3
    if (t == null)
      return this;
    if (this.context == null)
      this.context = new ArrayList<StructureDefinitionContextComponent>();
    this.context.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #context}, creating it
   *         if it does not already exist
   */
  public StructureDefinitionContextComponent getContextFirstRep() {
    if (getContext().isEmpty()) {
      addContext();
    }
    return getContext().get(0);
  }

  /**
   * @return {@link #contextInvariant} (A set of rules as FHIRPath Invariants
   *         about when the extension can be used (e.g. co-occurrence variants for
   *         the extension). All the rules must be true.)
   */
  public List<StringType> getContextInvariant() {
    if (this.contextInvariant == null)
      this.contextInvariant = new ArrayList<StringType>();
    return this.contextInvariant;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public StructureDefinition setContextInvariant(List<StringType> theContextInvariant) {
    this.contextInvariant = theContextInvariant;
    return this;
  }

  public boolean hasContextInvariant() {
    if (this.contextInvariant == null)
      return false;
    for (StringType item : this.contextInvariant)
      if (!item.isEmpty())
        return true;
    return false;
  }

  /**
   * @return {@link #contextInvariant} (A set of rules as FHIRPath Invariants
   *         about when the extension can be used (e.g. co-occurrence variants for
   *         the extension). All the rules must be true.)
   */
  public StringType addContextInvariantElement() {// 2
    StringType t = new StringType();
    if (this.contextInvariant == null)
      this.contextInvariant = new ArrayList<StringType>();
    this.contextInvariant.add(t);
    return t;
  }

  /**
   * @param value {@link #contextInvariant} (A set of rules as FHIRPath Invariants
   *              about when the extension can be used (e.g. co-occurrence
   *              variants for the extension). All the rules must be true.)
   */
  public StructureDefinition addContextInvariant(String value) { // 1
    StringType t = new StringType();
    t.setValue(value);
    if (this.contextInvariant == null)
      this.contextInvariant = new ArrayList<StringType>();
    this.contextInvariant.add(t);
    return this;
  }

  /**
   * @param value {@link #contextInvariant} (A set of rules as FHIRPath Invariants
   *              about when the extension can be used (e.g. co-occurrence
   *              variants for the extension). All the rules must be true.)
   */
  public boolean hasContextInvariant(String value) {
    if (this.contextInvariant == null)
      return false;
    for (StringType v : this.contextInvariant)
      if (v.getValue().equals(value)) // string
        return true;
    return false;
  }

  /**
   * @return {@link #type} (The type this structure describes. If the derivation
   *         kind is 'specialization' then this is the master definition for a
   *         type, and there is always one of these (a data type, an extension, a
   *         resource, including abstract ones). Otherwise the structure
   *         definition is a constraint on the stated type (and in this case, the
   *         type cannot be an abstract type). References are URLs that are
   *         relative to http://hl7.org/fhir/StructureDefinition e.g. "string" is
   *         a reference to http://hl7.org/fhir/StructureDefinition/string.
   *         Absolute URLs are only allowed in logical models.). This is the
   *         underlying object with id, value and extensions. The accessor
   *         "getType" gives direct access to the value
   */
  public UriType getTypeElement() {
    if (this.type == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.type");
      else if (Configuration.doAutoCreate())
        this.type = new UriType(); // bb
    return this.type;
  }

  public boolean hasTypeElement() {
    return this.type != null && !this.type.isEmpty();
  }

  public boolean hasType() {
    return this.type != null && !this.type.isEmpty();
  }

  /**
   * @param value {@link #type} (The type this structure describes. If the
   *              derivation kind is 'specialization' then this is the master
   *              definition for a type, and there is always one of these (a data
   *              type, an extension, a resource, including abstract ones).
   *              Otherwise the structure definition is a constraint on the stated
   *              type (and in this case, the type cannot be an abstract type).
   *              References are URLs that are relative to
   *              http://hl7.org/fhir/StructureDefinition e.g. "string" is a
   *              reference to http://hl7.org/fhir/StructureDefinition/string.
   *              Absolute URLs are only allowed in logical models.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getType" gives direct access to the value
   */
  public StructureDefinition setTypeElement(UriType value) {
    this.type = value;
    return this;
  }

  /**
   * @return The type this structure describes. If the derivation kind is
   *         'specialization' then this is the master definition for a type, and
   *         there is always one of these (a data type, an extension, a resource,
   *         including abstract ones). Otherwise the structure definition is a
   *         constraint on the stated type (and in this case, the type cannot be
   *         an abstract type). References are URLs that are relative to
   *         http://hl7.org/fhir/StructureDefinition e.g. "string" is a reference
   *         to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are
   *         only allowed in logical models.
   */
  public String getType() {
    return this.type == null ? null : this.type.getValue();
  }

  /**
   * @param value The type this structure describes. If the derivation kind is
   *              'specialization' then this is the master definition for a type,
   *              and there is always one of these (a data type, an extension, a
   *              resource, including abstract ones). Otherwise the structure
   *              definition is a constraint on the stated type (and in this case,
   *              the type cannot be an abstract type). References are URLs that
   *              are relative to http://hl7.org/fhir/StructureDefinition e.g.
   *              "string" is a reference to
   *              http://hl7.org/fhir/StructureDefinition/string. Absolute URLs
   *              are only allowed in logical models.
   */
  public StructureDefinition setType(String value) {
    if (this.type == null)
      this.type = new UriType();
    this.type.setValue(value);
    return this;
  }

  /**
   * @return {@link #baseDefinition} (An absolute URI that is the base structure
   *         from which this type is derived, either by specialization or
   *         constraint.). This is the underlying object with id, value and
   *         extensions. The accessor "getBaseDefinition" gives direct access to
   *         the value
   */
  public CanonicalType getBaseDefinitionElement() {
    if (this.baseDefinition == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.baseDefinition");
      else if (Configuration.doAutoCreate())
        this.baseDefinition = new CanonicalType(); // bb
    return this.baseDefinition;
  }

  public boolean hasBaseDefinitionElement() {
    return this.baseDefinition != null && !this.baseDefinition.isEmpty();
  }

  public boolean hasBaseDefinition() {
    return this.baseDefinition != null && !this.baseDefinition.isEmpty();
  }

  /**
   * @param value {@link #baseDefinition} (An absolute URI that is the base
   *              structure from which this type is derived, either by
   *              specialization or constraint.). This is the underlying object
   *              with id, value and extensions. The accessor "getBaseDefinition"
   *              gives direct access to the value
   */
  public StructureDefinition setBaseDefinitionElement(CanonicalType value) {
    this.baseDefinition = value;
    return this;
  }

  /**
   * @return An absolute URI that is the base structure from which this type is
   *         derived, either by specialization or constraint.
   */
  public String getBaseDefinition() {
    return this.baseDefinition == null ? null : this.baseDefinition.getValue();
  }

  /**
   * @param value An absolute URI that is the base structure from which this type
   *              is derived, either by specialization or constraint.
   */
  public StructureDefinition setBaseDefinition(String value) {
    if (Utilities.noString(value))
      this.baseDefinition = null;
    else {
      if (this.baseDefinition == null)
        this.baseDefinition = new CanonicalType();
      this.baseDefinition.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #derivation} (How the type relates to the baseDefinition.).
   *         This is the underlying object with id, value and extensions. The
   *         accessor "getDerivation" gives direct access to the value
   */
  public Enumeration<TypeDerivationRule> getDerivationElement() {
    if (this.derivation == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.derivation");
      else if (Configuration.doAutoCreate())
        this.derivation = new Enumeration<TypeDerivationRule>(new TypeDerivationRuleEnumFactory()); // bb
    return this.derivation;
  }

  public boolean hasDerivationElement() {
    return this.derivation != null && !this.derivation.isEmpty();
  }

  public boolean hasDerivation() {
    return this.derivation != null && !this.derivation.isEmpty();
  }

  /**
   * @param value {@link #derivation} (How the type relates to the
   *              baseDefinition.). This is the underlying object with id, value
   *              and extensions. The accessor "getDerivation" gives direct access
   *              to the value
   */
  public StructureDefinition setDerivationElement(Enumeration<TypeDerivationRule> value) {
    this.derivation = value;
    return this;
  }

  /**
   * @return How the type relates to the baseDefinition.
   */
  public TypeDerivationRule getDerivation() {
    return this.derivation == null ? null : this.derivation.getValue();
  }

  /**
   * @param value How the type relates to the baseDefinition.
   */
  public StructureDefinition setDerivation(TypeDerivationRule value) {
    if (value == null)
      this.derivation = null;
    else {
      if (this.derivation == null)
        this.derivation = new Enumeration<TypeDerivationRule>(new TypeDerivationRuleEnumFactory());
      this.derivation.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #snapshot} (A snapshot view is expressed in a standalone form
   *         that can be used and interpreted without considering the base
   *         StructureDefinition.)
   */
  public StructureDefinitionSnapshotComponent getSnapshot() {
    if (this.snapshot == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.snapshot");
      else if (Configuration.doAutoCreate())
        this.snapshot = new StructureDefinitionSnapshotComponent(); // cc
    return this.snapshot;
  }

  public boolean hasSnapshot() {
    return this.snapshot != null && !this.snapshot.isEmpty();
  }

  /**
   * @param value {@link #snapshot} (A snapshot view is expressed in a standalone
   *              form that can be used and interpreted without considering the
   *              base StructureDefinition.)
   */
  public StructureDefinition setSnapshot(StructureDefinitionSnapshotComponent value) {
    this.snapshot = value;
    return this;
  }

  /**
   * @return {@link #differential} (A differential view is expressed relative to
   *         the base StructureDefinition - a statement of differences that it
   *         applies.)
   */
  public StructureDefinitionDifferentialComponent getDifferential() {
    if (this.differential == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create StructureDefinition.differential");
      else if (Configuration.doAutoCreate())
        this.differential = new StructureDefinitionDifferentialComponent(); // cc
    return this.differential;
  }

  public boolean hasDifferential() {
    return this.differential != null && !this.differential.isEmpty();
  }

  /**
   * @param value {@link #differential} (A differential view is expressed relative
   *              to the base StructureDefinition - a statement of differences
   *              that it applies.)
   */
  public StructureDefinition setDifferential(StructureDefinitionDifferentialComponent value) {
    this.differential = value;
    return this;
  }

  protected void listChildren(List<Property> children) {
    super.listChildren(children);
    children.add(new Property("url", "uri",
        "An absolute URI that is used to identify this structure definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this structure definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the structure definition is stored on different servers.",
        0, 1, url));
    children.add(new Property("identifier", "Identifier",
        "A formal identifier that is used to identify this structure definition when it is represented in other formats, or referenced in a specification, model, design or an instance.",
        0, java.lang.Integer.MAX_VALUE, identifier));
    children.add(new Property("version", "string",
        "The identifier that is used to identify this version of the structure definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the structure definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.",
        0, 1, version));
    children.add(new Property("name", "string",
        "A natural language name identifying the structure definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.",
        0, 1, name));
    children.add(new Property("title", "string",
        "A short, descriptive, user-friendly title for the structure definition.", 0, 1, title));
    children.add(new Property("status", "code",
        "The status of this structure definition. Enables tracking the life-cycle of the content.", 0, 1, status));
    children.add(new Property("experimental", "boolean",
        "A Boolean value to indicate that this structure definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.",
        0, 1, experimental));
    children.add(new Property("date", "dateTime",
        "The date  (and optionally time) when the structure definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the structure definition changes.",
        0, 1, date));
    children.add(new Property("publisher", "string",
        "The name of the organization or individual that published the structure definition.", 0, 1, publisher));
    children.add(new Property("contact", "ContactDetail",
        "Contact details to assist a user in finding and communicating with the publisher.", 0,
        java.lang.Integer.MAX_VALUE, contact));
    children.add(new Property("description", "markdown",
        "A free text natural language description of the structure definition from a consumer's perspective.", 0, 1,
        description));
    children.add(new Property("useContext", "UsageContext",
        "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate structure definition instances.",
        0, java.lang.Integer.MAX_VALUE, useContext));
    children.add(new Property("jurisdiction", "CodeableConcept",
        "A legal or geographic region in which the structure definition is intended to be used.", 0,
        java.lang.Integer.MAX_VALUE, jurisdiction));
    children.add(new Property("purpose", "markdown",
        "Explanation of why this structure definition is needed and why it has been designed as it has.", 0, 1,
        purpose));
    children.add(new Property("copyright", "markdown",
        "A copyright statement relating to the structure definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the structure definition.",
        0, 1, copyright));
    children.add(new Property("keyword", "Coding",
        "A set of key words or terms from external terminologies that may be used to assist with indexing and searching of templates nby describing the use of this structure definition, or the content it describes.",
        0, java.lang.Integer.MAX_VALUE, keyword));
    children.add(new Property("fhirVersion", "code",
        "The version of the FHIR specification on which this StructureDefinition is based - this is the formal version of the specification, without the revision number, e.g. [publication].[major].[minor], which is 4.0.1. for this version.",
        0, 1, fhirVersion));
    children.add(new Property("mapping", "", "An external specification that the content is mapped to.", 0,
        java.lang.Integer.MAX_VALUE, mapping));
    children.add(
        new Property("kind", "code", "Defines the kind of structure that this definition is describing.", 0, 1, kind));
    children.add(new Property("abstract", "boolean",
        "Whether structure this definition describes is abstract or not  - that is, whether the structure is not intended to be instantiated. For Resources and Data types, abstract types will never be exchanged  between systems.",
        0, 1, abstract_));
    children.add(new Property("context", "",
        "Identifies the types of resource or data type elements to which the extension can be applied.", 0,
        java.lang.Integer.MAX_VALUE, context));
    children.add(new Property("contextInvariant", "string",
        "A set of rules as FHIRPath Invariants about when the extension can be used (e.g. co-occurrence variants for the extension). All the rules must be true.",
        0, java.lang.Integer.MAX_VALUE, contextInvariant));
    children.add(new Property("type", "uri",
        "The type this structure describes. If the derivation kind is 'specialization' then this is the master definition for a type, and there is always one of these (a data type, an extension, a resource, including abstract ones). Otherwise the structure definition is a constraint on the stated type (and in this case, the type cannot be an abstract type).  References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. \"string\" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical models.",
        0, 1, type));
    children.add(new Property("baseDefinition", "canonical(StructureDefinition)",
        "An absolute URI that is the base structure from which this type is derived, either by specialization or constraint.",
        0, 1, baseDefinition));
    children.add(new Property("derivation", "code", "How the type relates to the baseDefinition.", 0, 1, derivation));
    children.add(new Property("snapshot", "",
        "A snapshot view is expressed in a standalone form that can be used and interpreted without considering the base StructureDefinition.",
        0, 1, snapshot));
    children.add(new Property("differential", "",
        "A differential view is expressed relative to the base StructureDefinition - a statement of differences that it applies.",
        0, 1, differential));
  }

  @Override
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    switch (_hash) {
    case 116079:
      /* url */ return new Property("url", "uri",
          "An absolute URI that is used to identify this structure definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this structure definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the structure definition is stored on different servers.",
          0, 1, url);
    case -1618432855:
      /* identifier */ return new Property("identifier", "Identifier",
          "A formal identifier that is used to identify this structure definition when it is represented in other formats, or referenced in a specification, model, design or an instance.",
          0, java.lang.Integer.MAX_VALUE, identifier);
    case 351608024:
      /* version */ return new Property("version", "string",
          "The identifier that is used to identify this version of the structure definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the structure definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.",
          0, 1, version);
    case 3373707:
      /* name */ return new Property("name", "string",
          "A natural language name identifying the structure definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.",
          0, 1, name);
    case 110371416:
      /* title */ return new Property("title", "string",
          "A short, descriptive, user-friendly title for the structure definition.", 0, 1, title);
    case -892481550:
      /* status */ return new Property("status", "code",
          "The status of this structure definition. Enables tracking the life-cycle of the content.", 0, 1, status);
    case -404562712:
      /* experimental */ return new Property("experimental", "boolean",
          "A Boolean value to indicate that this structure definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.",
          0, 1, experimental);
    case 3076014:
      /* date */ return new Property("date", "dateTime",
          "The date  (and optionally time) when the structure definition was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the structure definition changes.",
          0, 1, date);
    case 1447404028:
      /* publisher */ return new Property("publisher", "string",
          "The name of the organization or individual that published the structure definition.", 0, 1, publisher);
    case 951526432:
      /* contact */ return new Property("contact", "ContactDetail",
          "Contact details to assist a user in finding and communicating with the publisher.", 0,
          java.lang.Integer.MAX_VALUE, contact);
    case -1724546052:
      /* description */ return new Property("description", "markdown",
          "A free text natural language description of the structure definition from a consumer's perspective.", 0, 1,
          description);
    case -669707736:
      /* useContext */ return new Property("useContext", "UsageContext",
          "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate structure definition instances.",
          0, java.lang.Integer.MAX_VALUE, useContext);
    case -507075711:
      /* jurisdiction */ return new Property("jurisdiction", "CodeableConcept",
          "A legal or geographic region in which the structure definition is intended to be used.", 0,
          java.lang.Integer.MAX_VALUE, jurisdiction);
    case -220463842:
      /* purpose */ return new Property("purpose", "markdown",
          "Explanation of why this structure definition is needed and why it has been designed as it has.", 0, 1,
          purpose);
    case 1522889671:
      /* copyright */ return new Property("copyright", "markdown",
          "A copyright statement relating to the structure definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the structure definition.",
          0, 1, copyright);
    case -814408215:
      /* keyword */ return new Property("keyword", "Coding",
          "A set of key words or terms from external terminologies that may be used to assist with indexing and searching of templates nby describing the use of this structure definition, or the content it describes.",
          0, java.lang.Integer.MAX_VALUE, keyword);
    case 461006061:
      /* fhirVersion */ return new Property("fhirVersion", "code",
          "The version of the FHIR specification on which this StructureDefinition is based - this is the formal version of the specification, without the revision number, e.g. [publication].[major].[minor], which is 4.0.1. for this version.",
          0, 1, fhirVersion);
    case 837556430:
      /* mapping */ return new Property("mapping", "", "An external specification that the content is mapped to.", 0,
          java.lang.Integer.MAX_VALUE, mapping);
    case 3292052:
      /* kind */ return new Property("kind", "code",
          "Defines the kind of structure that this definition is describing.", 0, 1, kind);
    case 1732898850:
      /* abstract */ return new Property("abstract", "boolean",
          "Whether structure this definition describes is abstract or not  - that is, whether the structure is not intended to be instantiated. For Resources and Data types, abstract types will never be exchanged  between systems.",
          0, 1, abstract_);
    case 951530927:
      /* context */ return new Property("context", "",
          "Identifies the types of resource or data type elements to which the extension can be applied.", 0,
          java.lang.Integer.MAX_VALUE, context);
    case -802505007:
      /* contextInvariant */ return new Property("contextInvariant", "string",
          "A set of rules as FHIRPath Invariants about when the extension can be used (e.g. co-occurrence variants for the extension). All the rules must be true.",
          0, java.lang.Integer.MAX_VALUE, contextInvariant);
    case 3575610:
      /* type */ return new Property("type", "uri",
          "The type this structure describes. If the derivation kind is 'specialization' then this is the master definition for a type, and there is always one of these (a data type, an extension, a resource, including abstract ones). Otherwise the structure definition is a constraint on the stated type (and in this case, the type cannot be an abstract type).  References are URLs that are relative to http://hl7.org/fhir/StructureDefinition e.g. \"string\" is a reference to http://hl7.org/fhir/StructureDefinition/string. Absolute URLs are only allowed in logical models.",
          0, 1, type);
    case 1139771140:
      /* baseDefinition */ return new Property("baseDefinition", "canonical(StructureDefinition)",
          "An absolute URI that is the base structure from which this type is derived, either by specialization or constraint.",
          0, 1, baseDefinition);
    case -1353885513:
      /* derivation */ return new Property("derivation", "code", "How the type relates to the baseDefinition.", 0, 1,
          derivation);
    case 284874180:
      /* snapshot */ return new Property("snapshot", "",
          "A snapshot view is expressed in a standalone form that can be used and interpreted without considering the base StructureDefinition.",
          0, 1, snapshot);
    case -1196150917:
      /* differential */ return new Property("differential", "",
          "A differential view is expressed relative to the base StructureDefinition - a statement of differences that it applies.",
          0, 1, differential);
    default:
      return super.getNamedProperty(_hash, _name, _checkValid);
    }

  }

  @Override
  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    switch (hash) {
    case 116079:
      /* url */ return this.url == null ? new Base[0] : new Base[] { this.url }; // UriType
    case -1618432855:
      /* identifier */ return this.identifier == null ? new Base[0]
          : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
    case 351608024:
      /* version */ return this.version == null ? new Base[0] : new Base[] { this.version }; // StringType
    case 3373707:
      /* name */ return this.name == null ? new Base[0] : new Base[] { this.name }; // StringType
    case 110371416:
      /* title */ return this.title == null ? new Base[0] : new Base[] { this.title }; // StringType
    case -892481550:
      /* status */ return this.status == null ? new Base[0] : new Base[] { this.status }; // Enumeration<PublicationStatus>
    case -404562712:
      /* experimental */ return this.experimental == null ? new Base[0] : new Base[] { this.experimental }; // BooleanType
    case 3076014:
      /* date */ return this.date == null ? new Base[0] : new Base[] { this.date }; // DateTimeType
    case 1447404028:
      /* publisher */ return this.publisher == null ? new Base[0] : new Base[] { this.publisher }; // StringType
    case 951526432:
      /* contact */ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
    case -1724546052:
      /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // MarkdownType
    case -669707736:
      /* useContext */ return this.useContext == null ? new Base[0]
          : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
    case -507075711:
      /* jurisdiction */ return this.jurisdiction == null ? new Base[0]
          : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
    case -220463842:
      /* purpose */ return this.purpose == null ? new Base[0] : new Base[] { this.purpose }; // MarkdownType
    case 1522889671:
      /* copyright */ return this.copyright == null ? new Base[0] : new Base[] { this.copyright }; // MarkdownType
    case -814408215:
      /* keyword */ return this.keyword == null ? new Base[0] : this.keyword.toArray(new Base[this.keyword.size()]); // Coding
    case 461006061:
      /* fhirVersion */ return this.fhirVersion == null ? new Base[0] : new Base[] { this.fhirVersion }; // Enumeration<FHIRVersion>
    case 837556430:
      /* mapping */ return this.mapping == null ? new Base[0] : this.mapping.toArray(new Base[this.mapping.size()]); // StructureDefinitionMappingComponent
    case 3292052:
      /* kind */ return this.kind == null ? new Base[0] : new Base[] { this.kind }; // Enumeration<StructureDefinitionKind>
    case 1732898850:
      /* abstract */ return this.abstract_ == null ? new Base[0] : new Base[] { this.abstract_ }; // BooleanType
    case 951530927:
      /* context */ return this.context == null ? new Base[0] : this.context.toArray(new Base[this.context.size()]); // StructureDefinitionContextComponent
    case -802505007:
      /* contextInvariant */ return this.contextInvariant == null ? new Base[0]
          : this.contextInvariant.toArray(new Base[this.contextInvariant.size()]); // StringType
    case 3575610:
      /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // UriType
    case 1139771140:
      /* baseDefinition */ return this.baseDefinition == null ? new Base[0] : new Base[] { this.baseDefinition }; // CanonicalType
    case -1353885513:
      /* derivation */ return this.derivation == null ? new Base[0] : new Base[] { this.derivation }; // Enumeration<TypeDerivationRule>
    case 284874180:
      /* snapshot */ return this.snapshot == null ? new Base[0] : new Base[] { this.snapshot }; // StructureDefinitionSnapshotComponent
    case -1196150917:
      /* differential */ return this.differential == null ? new Base[0] : new Base[] { this.differential }; // StructureDefinitionDifferentialComponent
    default:
      return super.getProperty(hash, name, checkValid);
    }

  }

  @Override
  public Base setProperty(int hash, String name, Base value) throws FHIRException {
    switch (hash) {
    case 116079: // url
      this.url = castToUri(value); // UriType
      return value;
    case -1618432855: // identifier
      this.getIdentifier().add(castToIdentifier(value)); // Identifier
      return value;
    case 351608024: // version
      this.version = castToString(value); // StringType
      return value;
    case 3373707: // name
      this.name = castToString(value); // StringType
      return value;
    case 110371416: // title
      this.title = castToString(value); // StringType
      return value;
    case -892481550: // status
      value = new PublicationStatusEnumFactory().fromType(castToCode(value));
      this.status = (Enumeration) value; // Enumeration<PublicationStatus>
      return value;
    case -404562712: // experimental
      this.experimental = castToBoolean(value); // BooleanType
      return value;
    case 3076014: // date
      this.date = castToDateTime(value); // DateTimeType
      return value;
    case 1447404028: // publisher
      this.publisher = castToString(value); // StringType
      return value;
    case 951526432: // contact
      this.getContact().add(castToContactDetail(value)); // ContactDetail
      return value;
    case -1724546052: // description
      this.description = castToMarkdown(value); // MarkdownType
      return value;
    case -669707736: // useContext
      this.getUseContext().add(castToUsageContext(value)); // UsageContext
      return value;
    case -507075711: // jurisdiction
      this.getJurisdiction().add(castToCodeableConcept(value)); // CodeableConcept
      return value;
    case -220463842: // purpose
      this.purpose = castToMarkdown(value); // MarkdownType
      return value;
    case 1522889671: // copyright
      this.copyright = castToMarkdown(value); // MarkdownType
      return value;
    case -814408215: // keyword
      this.getKeyword().add(castToCoding(value)); // Coding
      return value;
    case 461006061: // fhirVersion
      value = new FHIRVersionEnumFactory().fromType(castToCode(value));
      this.fhirVersion = (Enumeration) value; // Enumeration<FHIRVersion>
      return value;
    case 837556430: // mapping
      this.getMapping().add((StructureDefinitionMappingComponent) value); // StructureDefinitionMappingComponent
      return value;
    case 3292052: // kind
      value = new StructureDefinitionKindEnumFactory().fromType(castToCode(value));
      this.kind = (Enumeration) value; // Enumeration<StructureDefinitionKind>
      return value;
    case 1732898850: // abstract
      this.abstract_ = castToBoolean(value); // BooleanType
      return value;
    case 951530927: // context
      this.getContext().add((StructureDefinitionContextComponent) value); // StructureDefinitionContextComponent
      return value;
    case -802505007: // contextInvariant
      this.getContextInvariant().add(castToString(value)); // StringType
      return value;
    case 3575610: // type
      this.type = castToUri(value); // UriType
      return value;
    case 1139771140: // baseDefinition
      this.baseDefinition = castToCanonical(value); // CanonicalType
      return value;
    case -1353885513: // derivation
      value = new TypeDerivationRuleEnumFactory().fromType(castToCode(value));
      this.derivation = (Enumeration) value; // Enumeration<TypeDerivationRule>
      return value;
    case 284874180: // snapshot
      this.snapshot = (StructureDefinitionSnapshotComponent) value; // StructureDefinitionSnapshotComponent
      return value;
    case -1196150917: // differential
      this.differential = (StructureDefinitionDifferentialComponent) value; // StructureDefinitionDifferentialComponent
      return value;
    default:
      return super.setProperty(hash, name, value);
    }

  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    if (name.equals("url")) {
      this.url = castToUri(value); // UriType
    } else if (name.equals("identifier")) {
      this.getIdentifier().add(castToIdentifier(value));
    } else if (name.equals("version")) {
      this.version = castToString(value); // StringType
    } else if (name.equals("name")) {
      this.name = castToString(value); // StringType
    } else if (name.equals("title")) {
      this.title = castToString(value); // StringType
    } else if (name.equals("status")) {
      value = new PublicationStatusEnumFactory().fromType(castToCode(value));
      this.status = (Enumeration) value; // Enumeration<PublicationStatus>
    } else if (name.equals("experimental")) {
      this.experimental = castToBoolean(value); // BooleanType
    } else if (name.equals("date")) {
      this.date = castToDateTime(value); // DateTimeType
    } else if (name.equals("publisher")) {
      this.publisher = castToString(value); // StringType
    } else if (name.equals("contact")) {
      this.getContact().add(castToContactDetail(value));
    } else if (name.equals("description")) {
      this.description = castToMarkdown(value); // MarkdownType
    } else if (name.equals("useContext")) {
      this.getUseContext().add(castToUsageContext(value));
    } else if (name.equals("jurisdiction")) {
      this.getJurisdiction().add(castToCodeableConcept(value));
    } else if (name.equals("purpose")) {
      this.purpose = castToMarkdown(value); // MarkdownType
    } else if (name.equals("copyright")) {
      this.copyright = castToMarkdown(value); // MarkdownType
    } else if (name.equals("keyword")) {
      this.getKeyword().add(castToCoding(value));
    } else if (name.equals("fhirVersion")) {
      value = new FHIRVersionEnumFactory().fromType(castToCode(value));
      this.fhirVersion = (Enumeration) value; // Enumeration<FHIRVersion>
    } else if (name.equals("mapping")) {
      this.getMapping().add((StructureDefinitionMappingComponent) value);
    } else if (name.equals("kind")) {
      value = new StructureDefinitionKindEnumFactory().fromType(castToCode(value));
      this.kind = (Enumeration) value; // Enumeration<StructureDefinitionKind>
    } else if (name.equals("abstract")) {
      this.abstract_ = castToBoolean(value); // BooleanType
    } else if (name.equals("context")) {
      this.getContext().add((StructureDefinitionContextComponent) value);
    } else if (name.equals("contextInvariant")) {
      this.getContextInvariant().add(castToString(value));
    } else if (name.equals("type")) {
      this.type = castToUri(value); // UriType
    } else if (name.equals("baseDefinition")) {
      this.baseDefinition = castToCanonical(value); // CanonicalType
    } else if (name.equals("derivation")) {
      value = new TypeDerivationRuleEnumFactory().fromType(castToCode(value));
      this.derivation = (Enumeration) value; // Enumeration<TypeDerivationRule>
    } else if (name.equals("snapshot")) {
      this.snapshot = (StructureDefinitionSnapshotComponent) value; // StructureDefinitionSnapshotComponent
    } else if (name.equals("differential")) {
      this.differential = (StructureDefinitionDifferentialComponent) value; // StructureDefinitionDifferentialComponent
    } else
      return super.setProperty(name, value);
    return value;
  }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
    if (name.equals("url")) {
      this.url = null;
    } else if (name.equals("identifier")) {
      this.getIdentifier().remove(castToIdentifier(value));
    } else if (name.equals("version")) {
      this.version = null;
    } else if (name.equals("name")) {
      this.name = null;
    } else if (name.equals("title")) {
      this.title = null;
    } else if (name.equals("status")) {
      this.status = null;
    } else if (name.equals("experimental")) {
      this.experimental = null;
    } else if (name.equals("date")) {
      this.date = null;
    } else if (name.equals("publisher")) {
      this.publisher = null;
    } else if (name.equals("contact")) {
      this.getContact().remove(castToContactDetail(value));
    } else if (name.equals("description")) {
      this.description = null;
    } else if (name.equals("useContext")) {
      this.getUseContext().remove(castToUsageContext(value));
    } else if (name.equals("jurisdiction")) {
      this.getJurisdiction().remove(castToCodeableConcept(value));
    } else if (name.equals("purpose")) {
      this.purpose = null;
    } else if (name.equals("copyright")) {
      this.copyright = null;
    } else if (name.equals("keyword")) {
      this.getKeyword().remove(castToCoding(value));
    } else if (name.equals("fhirVersion")) {
      this.fhirVersion = null;
    } else if (name.equals("mapping")) {
      this.getMapping().remove((StructureDefinitionMappingComponent) value);
    } else if (name.equals("kind")) {
      this.kind = null;
    } else if (name.equals("abstract")) {
      this.abstract_ = null;
    } else if (name.equals("context")) {
      this.getContext().remove((StructureDefinitionContextComponent) value);
    } else if (name.equals("contextInvariant")) {
      this.getContextInvariant().remove(castToString(value));
    } else if (name.equals("type")) {
      this.type = null;
    } else if (name.equals("baseDefinition")) {
      this.baseDefinition = null;
    } else if (name.equals("derivation")) {
      this.derivation = null;
    } else if (name.equals("snapshot")) {
      this.snapshot = (StructureDefinitionSnapshotComponent) value; // StructureDefinitionSnapshotComponent
    } else if (name.equals("differential")) {
      this.differential = (StructureDefinitionDifferentialComponent) value; // StructureDefinitionDifferentialComponent
    } else
      super.removeChild(name, value);
    
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case 116079:
      return getUrlElement();
    case -1618432855:
      return addIdentifier();
    case 351608024:
      return getVersionElement();
    case 3373707:
      return getNameElement();
    case 110371416:
      return getTitleElement();
    case -892481550:
      return getStatusElement();
    case -404562712:
      return getExperimentalElement();
    case 3076014:
      return getDateElement();
    case 1447404028:
      return getPublisherElement();
    case 951526432:
      return addContact();
    case -1724546052:
      return getDescriptionElement();
    case -669707736:
      return addUseContext();
    case -507075711:
      return addJurisdiction();
    case -220463842:
      return getPurposeElement();
    case 1522889671:
      return getCopyrightElement();
    case -814408215:
      return addKeyword();
    case 461006061:
      return getFhirVersionElement();
    case 837556430:
      return addMapping();
    case 3292052:
      return getKindElement();
    case 1732898850:
      return getAbstractElement();
    case 951530927:
      return addContext();
    case -802505007:
      return addContextInvariantElement();
    case 3575610:
      return getTypeElement();
    case 1139771140:
      return getBaseDefinitionElement();
    case -1353885513:
      return getDerivationElement();
    case 284874180:
      return getSnapshot();
    case -1196150917:
      return getDifferential();
    default:
      return super.makeProperty(hash, name);
    }

  }

  @Override
  public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case 116079:
      /* url */ return new String[] { "uri" };
    case -1618432855:
      /* identifier */ return new String[] { "Identifier" };
    case 351608024:
      /* version */ return new String[] { "string" };
    case 3373707:
      /* name */ return new String[] { "string" };
    case 110371416:
      /* title */ return new String[] { "string" };
    case -892481550:
      /* status */ return new String[] { "code" };
    case -404562712:
      /* experimental */ return new String[] { "boolean" };
    case 3076014:
      /* date */ return new String[] { "dateTime" };
    case 1447404028:
      /* publisher */ return new String[] { "string" };
    case 951526432:
      /* contact */ return new String[] { "ContactDetail" };
    case -1724546052:
      /* description */ return new String[] { "markdown" };
    case -669707736:
      /* useContext */ return new String[] { "UsageContext" };
    case -507075711:
      /* jurisdiction */ return new String[] { "CodeableConcept" };
    case -220463842:
      /* purpose */ return new String[] { "markdown" };
    case 1522889671:
      /* copyright */ return new String[] { "markdown" };
    case -814408215:
      /* keyword */ return new String[] { "Coding" };
    case 461006061:
      /* fhirVersion */ return new String[] { "code" };
    case 837556430:
      /* mapping */ return new String[] {};
    case 3292052:
      /* kind */ return new String[] { "code" };
    case 1732898850:
      /* abstract */ return new String[] { "boolean" };
    case 951530927:
      /* context */ return new String[] {};
    case -802505007:
      /* contextInvariant */ return new String[] { "string" };
    case 3575610:
      /* type */ return new String[] { "uri" };
    case 1139771140:
      /* baseDefinition */ return new String[] { "canonical" };
    case -1353885513:
      /* derivation */ return new String[] { "code" };
    case 284874180:
      /* snapshot */ return new String[] {};
    case -1196150917:
      /* differential */ return new String[] {};
    default:
      return super.getTypesForProperty(hash, name);
    }

  }

  @Override
  public Base addChild(String name) throws FHIRException {
    if (name.equals("url")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.url");
    } else if (name.equals("identifier")) {
      return addIdentifier();
    } else if (name.equals("version")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.version");
    } else if (name.equals("name")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.name");
    } else if (name.equals("title")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.title");
    } else if (name.equals("status")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.status");
    } else if (name.equals("experimental")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.experimental");
    } else if (name.equals("date")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.date");
    } else if (name.equals("publisher")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.publisher");
    } else if (name.equals("contact")) {
      return addContact();
    } else if (name.equals("description")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.description");
    } else if (name.equals("useContext")) {
      return addUseContext();
    } else if (name.equals("jurisdiction")) {
      return addJurisdiction();
    } else if (name.equals("purpose")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.purpose");
    } else if (name.equals("copyright")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.copyright");
    } else if (name.equals("keyword")) {
      return addKeyword();
    } else if (name.equals("fhirVersion")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.fhirVersion");
    } else if (name.equals("mapping")) {
      return addMapping();
    } else if (name.equals("kind")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.kind");
    } else if (name.equals("abstract")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.abstract");
    } else if (name.equals("context")) {
      return addContext();
    } else if (name.equals("contextInvariant")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.contextInvariant");
    } else if (name.equals("type")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.type");
    } else if (name.equals("baseDefinition")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.baseDefinition");
    } else if (name.equals("derivation")) {
      throw new FHIRException("Cannot call addChild on a singleton property StructureDefinition.derivation");
    } else if (name.equals("snapshot")) {
      this.snapshot = new StructureDefinitionSnapshotComponent();
      return this.snapshot;
    } else if (name.equals("differential")) {
      this.differential = new StructureDefinitionDifferentialComponent();
      return this.differential;
    } else
      return super.addChild(name);
  }

  public String fhirType() {
    return "StructureDefinition";

  }

  public StructureDefinition copy() {
    StructureDefinition dst = new StructureDefinition();
    copyValues(dst);
    return dst;
  }

  public void copyValues(StructureDefinition dst) {
    super.copyValues(dst);
    dst.url = url == null ? null : url.copy();
    if (identifier != null) {
      dst.identifier = new ArrayList<Identifier>();
      for (Identifier i : identifier)
        dst.identifier.add(i.copy());
    }
    ;
    dst.version = version == null ? null : version.copy();
    dst.name = name == null ? null : name.copy();
    dst.title = title == null ? null : title.copy();
    dst.status = status == null ? null : status.copy();
    dst.experimental = experimental == null ? null : experimental.copy();
    dst.date = date == null ? null : date.copy();
    dst.publisher = publisher == null ? null : publisher.copy();
    if (contact != null) {
      dst.contact = new ArrayList<ContactDetail>();
      for (ContactDetail i : contact)
        dst.contact.add(i.copy());
    }
    ;
    dst.description = description == null ? null : description.copy();
    if (useContext != null) {
      dst.useContext = new ArrayList<UsageContext>();
      for (UsageContext i : useContext)
        dst.useContext.add(i.copy());
    }
    ;
    if (jurisdiction != null) {
      dst.jurisdiction = new ArrayList<CodeableConcept>();
      for (CodeableConcept i : jurisdiction)
        dst.jurisdiction.add(i.copy());
    }
    ;
    dst.purpose = purpose == null ? null : purpose.copy();
    dst.copyright = copyright == null ? null : copyright.copy();
    if (keyword != null) {
      dst.keyword = new ArrayList<Coding>();
      for (Coding i : keyword)
        dst.keyword.add(i.copy());
    }
    ;
    dst.fhirVersion = fhirVersion == null ? null : fhirVersion.copy();
    if (mapping != null) {
      dst.mapping = new ArrayList<StructureDefinitionMappingComponent>();
      for (StructureDefinitionMappingComponent i : mapping)
        dst.mapping.add(i.copy());
    }
    ;
    dst.kind = kind == null ? null : kind.copy();
    dst.abstract_ = abstract_ == null ? null : abstract_.copy();
    if (context != null) {
      dst.context = new ArrayList<StructureDefinitionContextComponent>();
      for (StructureDefinitionContextComponent i : context)
        dst.context.add(i.copy());
    }
    ;
    if (contextInvariant != null) {
      dst.contextInvariant = new ArrayList<StringType>();
      for (StringType i : contextInvariant)
        dst.contextInvariant.add(i.copy());
    }
    ;
    dst.type = type == null ? null : type.copy();
    dst.baseDefinition = baseDefinition == null ? null : baseDefinition.copy();
    dst.derivation = derivation == null ? null : derivation.copy();
    dst.snapshot = snapshot == null ? null : snapshot.copy();
    dst.differential = differential == null ? null : differential.copy();
  }

  protected StructureDefinition typedCopy() {
    return copy();
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_))
      return false;
    if (!(other_ instanceof StructureDefinition))
      return false;
    StructureDefinition o = (StructureDefinition) other_;
    return compareDeep(identifier, o.identifier, true) && compareDeep(purpose, o.purpose, true)
        && compareDeep(copyright, o.copyright, true) && compareDeep(keyword, o.keyword, true)
        && compareDeep(fhirVersion, o.fhirVersion, true) && compareDeep(mapping, o.mapping, true)
        && compareDeep(kind, o.kind, true) && compareDeep(abstract_, o.abstract_, true)
        && compareDeep(context, o.context, true) && compareDeep(contextInvariant, o.contextInvariant, true)
        && compareDeep(type, o.type, true) && compareDeep(baseDefinition, o.baseDefinition, true)
        && compareDeep(derivation, o.derivation, true) && compareDeep(snapshot, o.snapshot, true)
        && compareDeep(differential, o.differential, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_))
      return false;
    if (!(other_ instanceof StructureDefinition))
      return false;
    StructureDefinition o = (StructureDefinition) other_;
    return compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true)
        && compareValues(fhirVersion, o.fhirVersion, true) && compareValues(kind, o.kind, true)
        && compareValues(abstract_, o.abstract_, true) && compareValues(contextInvariant, o.contextInvariant, true)
        && compareValues(type, o.type, true) && compareValues(derivation, o.derivation, true);
  }

  public boolean isEmpty() {
    return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, purpose, copyright, keyword, fhirVersion,
        mapping, kind, abstract_, context, contextInvariant, type, baseDefinition, derivation, snapshot, differential);
  }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.StructureDefinition;
  }

  /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The structure definition publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>StructureDefinition.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "date", path = "StructureDefinition.date", description = "The structure definition publication date", type = "date")
  public static final String SP_DATE = "date";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The structure definition publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>StructureDefinition.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(
      SP_DATE);

  /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the structure
   * definition</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type-value", path = "StructureDefinition.useContext", description = "A use context type and value assigned to the structure definition", type = "composite", compositeOf = {
      "context-type", "context" })
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the structure
   * definition</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(
      SP_CONTEXT_TYPE_VALUE);

  /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the structure definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "jurisdiction", path = "StructureDefinition.jurisdiction", description = "Intended jurisdiction for the structure definition", type = "token")
  public static final String SP_JURISDICTION = "jurisdiction";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the structure definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_JURISDICTION);

  /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>The description of the structure definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>StructureDefinition.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "description", path = "StructureDefinition.description", description = "The description of the structure definition", type = "string")
  public static final String SP_DESCRIPTION = "description";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>The description of the structure definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>StructureDefinition.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_DESCRIPTION);

  /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the structure
   * definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type", path = "StructureDefinition.useContext.code", description = "A type of use context assigned to the structure definition", type = "token")
  public static final String SP_CONTEXT_TYPE = "context-type";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the structure
   * definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CONTEXT_TYPE);

  /**
   * Search parameter: <b>experimental</b>
   * <p>
   * Description: <b>For testing purposes, not real usage</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.experimental</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "experimental", path = "StructureDefinition.experimental", description = "For testing purposes, not real usage", type = "token")
  public static final String SP_EXPERIMENTAL = "experimental";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>experimental</b>
   * <p>
   * Description: <b>For testing purposes, not real usage</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.experimental</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EXPERIMENTAL = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_EXPERIMENTAL);

  /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the structure definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>StructureDefinition.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "title", path = "StructureDefinition.title", description = "The human-friendly name of the structure definition", type = "string")
  public static final String SP_TITLE = "title";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the structure definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>StructureDefinition.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_TITLE);

  /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>Type defined or constrained by this structure</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>StructureDefinition.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "type", path = "StructureDefinition.type", description = "Type defined or constrained by this structure", type = "uri")
  public static final String SP_TYPE = "type";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>Type defined or constrained by this structure</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>StructureDefinition.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam TYPE = new ca.uhn.fhir.rest.gclient.UriClientParam(
      SP_TYPE);

  /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the
   * structure definition</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>StructureDefinition.useContext.valueQuantity,
   * StructureDefinition.useContext.valueRange</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-quantity", path = "(StructureDefinition.useContext.value as Quantity) | (StructureDefinition.useContext.value as Range)", description = "A quantity- or range-valued use context assigned to the structure definition", type = "quantity")
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the
   * structure definition</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>StructureDefinition.useContext.valueQuantity,
   * StructureDefinition.useContext.valueRange</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(
      SP_CONTEXT_QUANTITY);

  /**
   * Search parameter: <b>path</b>
   * <p>
   * Description: <b>A path that is constrained in the StructureDefinition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.snapshot.element.path,
   * StructureDefinition.differential.element.path</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "path", path = "StructureDefinition.snapshot.element.path | StructureDefinition.differential.element.path", description = "A path that is constrained in the StructureDefinition", type = "token")
  public static final String SP_PATH = "path";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>path</b>
   * <p>
   * Description: <b>A path that is constrained in the StructureDefinition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.snapshot.element.path,
   * StructureDefinition.differential.element.path</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PATH = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_PATH);

  /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the structure definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.useContext.valueCodeableConcept</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context", path = "(StructureDefinition.useContext.value as CodeableConcept)", description = "A use context assigned to the structure definition", type = "token")
  public static final String SP_CONTEXT = "context";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the structure definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.useContext.valueCodeableConcept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CONTEXT);

  /**
   * Search parameter: <b>base-path</b>
   * <p>
   * Description: <b>Path that identifies the base element</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.snapshot.element.base.path,
   * StructureDefinition.differential.element.base.path</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "base-path", path = "StructureDefinition.snapshot.element.base.path | StructureDefinition.differential.element.base.path", description = "Path that identifies the base element", type = "token")
  public static final String SP_BASE_PATH = "base-path";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>base-path</b>
   * <p>
   * Description: <b>Path that identifies the base element</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.snapshot.element.base.path,
   * StructureDefinition.differential.element.base.path</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam BASE_PATH = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_BASE_PATH);

  /**
   * Search parameter: <b>keyword</b>
   * <p>
   * Description: <b>A code for the StructureDefinition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.keyword</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "keyword", path = "StructureDefinition.keyword", description = "A code for the StructureDefinition", type = "token")
  public static final String SP_KEYWORD = "keyword";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>keyword</b>
   * <p>
   * Description: <b>A code for the StructureDefinition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.keyword</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam KEYWORD = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_KEYWORD);

  /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value
   * assigned to the structure definition</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context-type-quantity", path = "StructureDefinition.useContext", description = "A use context type and quantity- or range-based value assigned to the structure definition", type = "composite", compositeOf = {
      "context-type", "context-quantity" })
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
  /**
   * <b>Fluent Client</b> search parameter constant for
   * <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value
   * assigned to the structure definition</b><br>
   * Type: <b>composite</b><br>
   * Path: <b></b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(
      SP_CONTEXT_TYPE_QUANTITY);

  /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the structure definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "identifier", path = "StructureDefinition.identifier", description = "External identifier for the structure definition", type = "token")
  public static final String SP_IDENTIFIER = "identifier";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the structure definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_IDENTIFIER);

  /**
   * Search parameter: <b>valueset</b>
   * <p>
   * Description: <b>A vocabulary binding reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>StructureDefinition.snapshot.element.binding.valueSet</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "valueset", path = "StructureDefinition.snapshot.element.binding.valueSet", description = "A vocabulary binding reference", type = "reference", target = {
      ValueSet.class })
  public static final String SP_VALUESET = "valueset";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>valueset</b>
   * <p>
   * Description: <b>A vocabulary binding reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>StructureDefinition.snapshot.element.binding.valueSet</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam VALUESET = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_VALUESET);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>StructureDefinition:valueset</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_VALUESET = new ca.uhn.fhir.model.api.Include(
      "StructureDefinition:valueset").toLocked();

  /**
   * Search parameter: <b>kind</b>
   * <p>
   * Description: <b>primitive-type | complex-type | resource | logical</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.kind</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "kind", path = "StructureDefinition.kind", description = "primitive-type | complex-type | resource | logical", type = "token")
  public static final String SP_KIND = "kind";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>kind</b>
   * <p>
   * Description: <b>primitive-type | complex-type | resource | logical</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.kind</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam KIND = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_KIND);

  /**
   * Search parameter: <b>abstract</b>
   * <p>
   * Description: <b>Whether the structure is abstract</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.abstract</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "abstract", path = "StructureDefinition.abstract", description = "Whether the structure is abstract", type = "token")
  public static final String SP_ABSTRACT = "abstract";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>abstract</b>
   * <p>
   * Description: <b>Whether the structure is abstract</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.abstract</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ABSTRACT = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_ABSTRACT);

  /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version of the structure definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "version", path = "StructureDefinition.version", description = "The business version of the structure definition", type = "token")
  public static final String SP_VERSION = "version";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version of the structure definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_VERSION);

  /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the structure definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>StructureDefinition.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "url", path = "StructureDefinition.url", description = "The uri that identifies the structure definition", type = "uri")
  public static final String SP_URL = "url";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the structure definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>StructureDefinition.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

  /**
   * Search parameter: <b>ext-context</b>
   * <p>
   * Description: <b>The system is the URL for the context-type: e.g.
   * http://hl7.org/fhir/extension-context-type#element|CodeableConcept.text</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.context.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "ext-context", path = "StructureDefinition.context.type", description = "The system is the URL for the context-type: e.g. http://hl7.org/fhir/extension-context-type#element|CodeableConcept.text", type = "token")
  public static final String SP_EXT_CONTEXT = "ext-context";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>ext-context</b>
   * <p>
   * Description: <b>The system is the URL for the context-type: e.g.
   * http://hl7.org/fhir/extension-context-type#element|CodeableConcept.text</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.context.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EXT_CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_EXT_CONTEXT);

  /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the structure
   * definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>StructureDefinition.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "name", path = "StructureDefinition.name", description = "Computationally friendly name of the structure definition", type = "string")
  public static final String SP_NAME = "name";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the structure
   * definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>StructureDefinition.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_NAME);

  /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the structure definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>StructureDefinition.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "publisher", path = "StructureDefinition.publisher", description = "Name of the publisher of the structure definition", type = "string")
  public static final String SP_PUBLISHER = "publisher";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the structure definition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>StructureDefinition.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(
      SP_PUBLISHER);

  /**
   * Search parameter: <b>derivation</b>
   * <p>
   * Description: <b>specialization | constraint - How relates to base
   * definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.derivation</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "derivation", path = "StructureDefinition.derivation", description = "specialization | constraint - How relates to base definition", type = "token")
  public static final String SP_DERIVATION = "derivation";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>derivation</b>
   * <p>
   * Description: <b>specialization | constraint - How relates to base
   * definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.derivation</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DERIVATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_DERIVATION);

  /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the structure definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "status", path = "StructureDefinition.status", description = "The current status of the structure definition", type = "token")
  public static final String SP_STATUS = "status";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the structure definition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>StructureDefinition.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_STATUS);

  /**
   * Search parameter: <b>base</b>
   * <p>
   * Description: <b>Definition that this type is constrained/specialized
   * from</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>StructureDefinition.baseDefinition</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "base", path = "StructureDefinition.baseDefinition", description = "Definition that this type is constrained/specialized from", type = "reference", target = {
      StructureDefinition.class })
  public static final String SP_BASE = "base";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>base</b>
   * <p>
   * Description: <b>Definition that this type is constrained/specialized
   * from</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>StructureDefinition.baseDefinition</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_BASE);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>StructureDefinition:base</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASE = new ca.uhn.fhir.model.api.Include(
      "StructureDefinition:base").toLocked();

  public String getVersionedUrl() {
    return hasVersion() ? getUrl()+"|"+getVersion() : getUrl();
  }


  public String getTypeName() { 
    String t = getType(); 
    return StructureDefinitionKind.LOGICAL.equals(getKind()) && t.contains("/") ? t.substring(t.lastIndexOf("/")+1) : t; 
  } 

  public String getTypeTail() { 
    if (getType().contains("/")) { 
      return getType().substring(getType().lastIndexOf("/")+1); 
    } else { 
      return getType(); 
    } 
  }
}
