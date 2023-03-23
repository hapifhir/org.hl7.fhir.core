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
 * A curated namespace that issues unique symbols within that namespace for the identification of concepts, people, devices, etc.  Represents a "System" used within the Identifier and Coding data types.
 */
@ResourceDef(name="NamingSystem", profile="http://hl7.org/fhir/StructureDefinition/NamingSystem")
public class NamingSystem extends MetadataResource {

    public enum NamingSystemIdentifierType {
        /**
         * An ISO object identifier; e.g. 1.2.3.4.5.
         */
        OID, 
        /**
         * A universally unique identifier of the form a5afddf4-e880-459b-876e-e4591b0acc11.
         */
        UUID, 
        /**
         * A uniform resource identifier (ideally a URL - uniform resource locator); e.g. http://unitsofmeasure.org.
         */
        URI, 
        /**
         * An IRI string that can be prepended to the code to obtain a concept IRI for RDF applications. This should be a valid, absolute IRI as defined in RFC 3987. See rdf.html#iri-stem for details on how this value may be used.
         */
        IRISTEM, 
        /**
         * A short string published by HL7 for use in the V2 family of standsrds to idenfify a code system in the V12 coded data types CWE, CNE, and CF. The code values are also published by HL7 at http://www.hl7.org/Special/committees/vocab/table_0396/index.cfm
         */
        V2CSMNEMONIC, 
        /**
         * Some other type of unique identifier; e.g. HL7-assigned reserved string such as LN for LOINC.
         */
        OTHER, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static NamingSystemIdentifierType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("oid".equals(codeString))
          return OID;
        if ("uuid".equals(codeString))
          return UUID;
        if ("uri".equals(codeString))
          return URI;
        if ("iri-stem".equals(codeString))
          return IRISTEM;
        if ("v2csmnemonic".equals(codeString))
          return V2CSMNEMONIC;
        if ("other".equals(codeString))
          return OTHER;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown NamingSystemIdentifierType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case OID: return "oid";
            case UUID: return "uuid";
            case URI: return "uri";
            case IRISTEM: return "iri-stem";
            case V2CSMNEMONIC: return "v2csmnemonic";
            case OTHER: return "other";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case OID: return "http://hl7.org/fhir/namingsystem-identifier-type";
            case UUID: return "http://hl7.org/fhir/namingsystem-identifier-type";
            case URI: return "http://hl7.org/fhir/namingsystem-identifier-type";
            case IRISTEM: return "http://hl7.org/fhir/namingsystem-identifier-type";
            case V2CSMNEMONIC: return "http://hl7.org/fhir/namingsystem-identifier-type";
            case OTHER: return "http://hl7.org/fhir/namingsystem-identifier-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case OID: return "An ISO object identifier; e.g. 1.2.3.4.5.";
            case UUID: return "A universally unique identifier of the form a5afddf4-e880-459b-876e-e4591b0acc11.";
            case URI: return "A uniform resource identifier (ideally a URL - uniform resource locator); e.g. http://unitsofmeasure.org.";
            case IRISTEM: return "An IRI string that can be prepended to the code to obtain a concept IRI for RDF applications. This should be a valid, absolute IRI as defined in RFC 3987. See rdf.html#iri-stem for details on how this value may be used.";
            case V2CSMNEMONIC: return "A short string published by HL7 for use in the V2 family of standsrds to idenfify a code system in the V12 coded data types CWE, CNE, and CF. The code values are also published by HL7 at http://www.hl7.org/Special/committees/vocab/table_0396/index.cfm";
            case OTHER: return "Some other type of unique identifier; e.g. HL7-assigned reserved string such as LN for LOINC.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case OID: return "OID";
            case UUID: return "UUID";
            case URI: return "URI";
            case IRISTEM: return "IRI stem";
            case V2CSMNEMONIC: return "V2CSMNemonic";
            case OTHER: return "Other";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class NamingSystemIdentifierTypeEnumFactory implements EnumFactory<NamingSystemIdentifierType> {
    public NamingSystemIdentifierType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("oid".equals(codeString))
          return NamingSystemIdentifierType.OID;
        if ("uuid".equals(codeString))
          return NamingSystemIdentifierType.UUID;
        if ("uri".equals(codeString))
          return NamingSystemIdentifierType.URI;
        if ("iri-stem".equals(codeString))
          return NamingSystemIdentifierType.IRISTEM;
        if ("v2csmnemonic".equals(codeString))
          return NamingSystemIdentifierType.V2CSMNEMONIC;
        if ("other".equals(codeString))
          return NamingSystemIdentifierType.OTHER;
        throw new IllegalArgumentException("Unknown NamingSystemIdentifierType code '"+codeString+"'");
        }
        public Enumeration<NamingSystemIdentifierType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.NULL, code);
        if ("oid".equals(codeString))
          return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.OID, code);
        if ("uuid".equals(codeString))
          return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.UUID, code);
        if ("uri".equals(codeString))
          return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.URI, code);
        if ("iri-stem".equals(codeString))
          return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.IRISTEM, code);
        if ("v2csmnemonic".equals(codeString))
          return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.V2CSMNEMONIC, code);
        if ("other".equals(codeString))
          return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.OTHER, code);
        throw new FHIRException("Unknown NamingSystemIdentifierType code '"+codeString+"'");
        }
    public String toCode(NamingSystemIdentifierType code) {
      if (code == NamingSystemIdentifierType.OID)
        return "oid";
      if (code == NamingSystemIdentifierType.UUID)
        return "uuid";
      if (code == NamingSystemIdentifierType.URI)
        return "uri";
      if (code == NamingSystemIdentifierType.IRISTEM)
        return "iri-stem";
      if (code == NamingSystemIdentifierType.V2CSMNEMONIC)
        return "v2csmnemonic";
      if (code == NamingSystemIdentifierType.OTHER)
        return "other";
      return "?";
      }
    public String toSystem(NamingSystemIdentifierType code) {
      return code.getSystem();
      }
    }

    public enum NamingSystemType {
        /**
         * The naming system is used to define concepts and symbols to represent those concepts; e.g. UCUM, LOINC, NDC code, local lab codes, etc.
         */
        CODESYSTEM, 
        /**
         * The naming system is used to manage identifiers (e.g. license numbers, order numbers, etc.).
         */
        IDENTIFIER, 
        /**
         * The naming system is used as the root for other identifiers and naming systems.
         */
        ROOT, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static NamingSystemType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("codesystem".equals(codeString))
          return CODESYSTEM;
        if ("identifier".equals(codeString))
          return IDENTIFIER;
        if ("root".equals(codeString))
          return ROOT;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown NamingSystemType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case CODESYSTEM: return "codesystem";
            case IDENTIFIER: return "identifier";
            case ROOT: return "root";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case CODESYSTEM: return "http://hl7.org/fhir/namingsystem-type";
            case IDENTIFIER: return "http://hl7.org/fhir/namingsystem-type";
            case ROOT: return "http://hl7.org/fhir/namingsystem-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case CODESYSTEM: return "The naming system is used to define concepts and symbols to represent those concepts; e.g. UCUM, LOINC, NDC code, local lab codes, etc.";
            case IDENTIFIER: return "The naming system is used to manage identifiers (e.g. license numbers, order numbers, etc.).";
            case ROOT: return "The naming system is used as the root for other identifiers and naming systems.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case CODESYSTEM: return "Code System";
            case IDENTIFIER: return "Identifier";
            case ROOT: return "Root";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class NamingSystemTypeEnumFactory implements EnumFactory<NamingSystemType> {
    public NamingSystemType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("codesystem".equals(codeString))
          return NamingSystemType.CODESYSTEM;
        if ("identifier".equals(codeString))
          return NamingSystemType.IDENTIFIER;
        if ("root".equals(codeString))
          return NamingSystemType.ROOT;
        throw new IllegalArgumentException("Unknown NamingSystemType code '"+codeString+"'");
        }
        public Enumeration<NamingSystemType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<NamingSystemType>(this, NamingSystemType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<NamingSystemType>(this, NamingSystemType.NULL, code);
        if ("codesystem".equals(codeString))
          return new Enumeration<NamingSystemType>(this, NamingSystemType.CODESYSTEM, code);
        if ("identifier".equals(codeString))
          return new Enumeration<NamingSystemType>(this, NamingSystemType.IDENTIFIER, code);
        if ("root".equals(codeString))
          return new Enumeration<NamingSystemType>(this, NamingSystemType.ROOT, code);
        throw new FHIRException("Unknown NamingSystemType code '"+codeString+"'");
        }
    public String toCode(NamingSystemType code) {
      if (code == NamingSystemType.CODESYSTEM)
        return "codesystem";
      if (code == NamingSystemType.IDENTIFIER)
        return "identifier";
      if (code == NamingSystemType.ROOT)
        return "root";
      return "?";
      }
    public String toSystem(NamingSystemType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class NamingSystemUniqueIdComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifies the unique identifier scheme used for this particular identifier.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="oid | uuid | uri | iri-stem | v2csmnemonic | other", formalDefinition="Identifies the unique identifier scheme used for this particular identifier." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/namingsystem-identifier-type")
        protected Enumeration<NamingSystemIdentifierType> type;

        /**
         * The string that should be sent over the wire to identify the code system or identifier system.
         */
        @Child(name = "value", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The unique identifier", formalDefinition="The string that should be sent over the wire to identify the code system or identifier system." )
        protected StringType value;

        /**
         * Indicates whether this identifier is the "preferred" identifier of this type.
         */
        @Child(name = "preferred", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Is this the id that should be used for this type", formalDefinition="Indicates whether this identifier is the \"preferred\" identifier of this type." )
        protected BooleanType preferred;

        /**
         * Notes about the past or intended usage of this identifier.
         */
        @Child(name = "comment", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Notes about identifier usage", formalDefinition="Notes about the past or intended usage of this identifier." )
        protected StringType comment;

        /**
         * Identifies the period of time over which this identifier is considered appropriate to refer to the naming system.  Outside of this window, the identifier might be non-deterministic.
         */
        @Child(name = "period", type = {Period.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When is identifier valid?", formalDefinition="Identifies the period of time over which this identifier is considered appropriate to refer to the naming system.  Outside of this window, the identifier might be non-deterministic." )
        protected Period period;

        /**
         * Indicates whether this identifier ie endorsed by the official owner of the associated naming system.
         */
        @Child(name = "authoritative", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the identifier is authoritative", formalDefinition="Indicates whether this identifier ie endorsed by the official owner of the associated naming system." )
        protected BooleanType authoritative;

        private static final long serialVersionUID = -166953751L;

    /**
     * Constructor
     */
      public NamingSystemUniqueIdComponent() {
        super();
      }

    /**
     * Constructor
     */
      public NamingSystemUniqueIdComponent(NamingSystemIdentifierType type, String value) {
        super();
        this.setType(type);
        this.setValue(value);
      }

        /**
         * @return {@link #type} (Identifies the unique identifier scheme used for this particular identifier.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<NamingSystemIdentifierType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NamingSystemUniqueIdComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<NamingSystemIdentifierType>(new NamingSystemIdentifierTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Identifies the unique identifier scheme used for this particular identifier.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public NamingSystemUniqueIdComponent setTypeElement(Enumeration<NamingSystemIdentifierType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return Identifies the unique identifier scheme used for this particular identifier.
         */
        public NamingSystemIdentifierType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value Identifies the unique identifier scheme used for this particular identifier.
         */
        public NamingSystemUniqueIdComponent setType(NamingSystemIdentifierType value) { 
            if (this.type == null)
              this.type = new Enumeration<NamingSystemIdentifierType>(new NamingSystemIdentifierTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #value} (The string that should be sent over the wire to identify the code system or identifier system.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NamingSystemUniqueIdComponent.value");
            else if (Configuration.doAutoCreate())
              this.value = new StringType(); // bb
          return this.value;
        }

        public boolean hasValueElement() { 
          return this.value != null && !this.value.isEmpty();
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The string that should be sent over the wire to identify the code system or identifier system.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public NamingSystemUniqueIdComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The string that should be sent over the wire to identify the code system or identifier system.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The string that should be sent over the wire to identify the code system or identifier system.
         */
        public NamingSystemUniqueIdComponent setValue(String value) { 
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          return this;
        }

        /**
         * @return {@link #preferred} (Indicates whether this identifier is the "preferred" identifier of this type.). This is the underlying object with id, value and extensions. The accessor "getPreferred" gives direct access to the value
         */
        public BooleanType getPreferredElement() { 
          if (this.preferred == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NamingSystemUniqueIdComponent.preferred");
            else if (Configuration.doAutoCreate())
              this.preferred = new BooleanType(); // bb
          return this.preferred;
        }

        public boolean hasPreferredElement() { 
          return this.preferred != null && !this.preferred.isEmpty();
        }

        public boolean hasPreferred() { 
          return this.preferred != null && !this.preferred.isEmpty();
        }

        /**
         * @param value {@link #preferred} (Indicates whether this identifier is the "preferred" identifier of this type.). This is the underlying object with id, value and extensions. The accessor "getPreferred" gives direct access to the value
         */
        public NamingSystemUniqueIdComponent setPreferredElement(BooleanType value) { 
          this.preferred = value;
          return this;
        }

        /**
         * @return Indicates whether this identifier is the "preferred" identifier of this type.
         */
        public boolean getPreferred() { 
          return this.preferred == null || this.preferred.isEmpty() ? false : this.preferred.getValue();
        }

        /**
         * @param value Indicates whether this identifier is the "preferred" identifier of this type.
         */
        public NamingSystemUniqueIdComponent setPreferred(boolean value) { 
            if (this.preferred == null)
              this.preferred = new BooleanType();
            this.preferred.setValue(value);
          return this;
        }

        /**
         * @return {@link #comment} (Notes about the past or intended usage of this identifier.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
         */
        public StringType getCommentElement() { 
          if (this.comment == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NamingSystemUniqueIdComponent.comment");
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
         * @param value {@link #comment} (Notes about the past or intended usage of this identifier.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
         */
        public NamingSystemUniqueIdComponent setCommentElement(StringType value) { 
          this.comment = value;
          return this;
        }

        /**
         * @return Notes about the past or intended usage of this identifier.
         */
        public String getComment() { 
          return this.comment == null ? null : this.comment.getValue();
        }

        /**
         * @param value Notes about the past or intended usage of this identifier.
         */
        public NamingSystemUniqueIdComponent setComment(String value) { 
          if (Utilities.noString(value))
            this.comment = null;
          else {
            if (this.comment == null)
              this.comment = new StringType();
            this.comment.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #period} (Identifies the period of time over which this identifier is considered appropriate to refer to the naming system.  Outside of this window, the identifier might be non-deterministic.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NamingSystemUniqueIdComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (Identifies the period of time over which this identifier is considered appropriate to refer to the naming system.  Outside of this window, the identifier might be non-deterministic.)
         */
        public NamingSystemUniqueIdComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        /**
         * @return {@link #authoritative} (Indicates whether this identifier ie endorsed by the official owner of the associated naming system.). This is the underlying object with id, value and extensions. The accessor "getAuthoritative" gives direct access to the value
         */
        public BooleanType getAuthoritativeElement() { 
          if (this.authoritative == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NamingSystemUniqueIdComponent.authoritative");
            else if (Configuration.doAutoCreate())
              this.authoritative = new BooleanType(); // bb
          return this.authoritative;
        }

        public boolean hasAuthoritativeElement() { 
          return this.authoritative != null && !this.authoritative.isEmpty();
        }

        public boolean hasAuthoritative() { 
          return this.authoritative != null && !this.authoritative.isEmpty();
        }

        /**
         * @param value {@link #authoritative} (Indicates whether this identifier ie endorsed by the official owner of the associated naming system.). This is the underlying object with id, value and extensions. The accessor "getAuthoritative" gives direct access to the value
         */
        public NamingSystemUniqueIdComponent setAuthoritativeElement(BooleanType value) { 
          this.authoritative = value;
          return this;
        }

        /**
         * @return Indicates whether this identifier ie endorsed by the official owner of the associated naming system.
         */
        public boolean getAuthoritative() { 
          return this.authoritative == null || this.authoritative.isEmpty() ? false : this.authoritative.getValue();
        }

        /**
         * @param value Indicates whether this identifier ie endorsed by the official owner of the associated naming system.
         */
        public NamingSystemUniqueIdComponent setAuthoritative(boolean value) { 
            if (this.authoritative == null)
              this.authoritative = new BooleanType();
            this.authoritative.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "Identifies the unique identifier scheme used for this particular identifier.", 0, 1, type));
          children.add(new Property("value", "string", "The string that should be sent over the wire to identify the code system or identifier system.", 0, 1, value));
          children.add(new Property("preferred", "boolean", "Indicates whether this identifier is the \"preferred\" identifier of this type.", 0, 1, preferred));
          children.add(new Property("comment", "string", "Notes about the past or intended usage of this identifier.", 0, 1, comment));
          children.add(new Property("period", "Period", "Identifies the period of time over which this identifier is considered appropriate to refer to the naming system.  Outside of this window, the identifier might be non-deterministic.", 0, 1, period));
          children.add(new Property("authoritative", "boolean", "Indicates whether this identifier ie endorsed by the official owner of the associated naming system.", 0, 1, authoritative));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "Identifies the unique identifier scheme used for this particular identifier.", 0, 1, type);
          case 111972721: /*value*/  return new Property("value", "string", "The string that should be sent over the wire to identify the code system or identifier system.", 0, 1, value);
          case -1294005119: /*preferred*/  return new Property("preferred", "boolean", "Indicates whether this identifier is the \"preferred\" identifier of this type.", 0, 1, preferred);
          case 950398559: /*comment*/  return new Property("comment", "string", "Notes about the past or intended usage of this identifier.", 0, 1, comment);
          case -991726143: /*period*/  return new Property("period", "Period", "Identifies the period of time over which this identifier is considered appropriate to refer to the naming system.  Outside of this window, the identifier might be non-deterministic.", 0, 1, period);
          case -1557344881: /*authoritative*/  return new Property("authoritative", "boolean", "Indicates whether this identifier ie endorsed by the official owner of the associated naming system.", 0, 1, authoritative);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<NamingSystemIdentifierType>
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        case -1294005119: /*preferred*/ return this.preferred == null ? new Base[0] : new Base[] {this.preferred}; // BooleanType
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // StringType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case -1557344881: /*authoritative*/ return this.authoritative == null ? new Base[0] : new Base[] {this.authoritative}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new NamingSystemIdentifierTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<NamingSystemIdentifierType>
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        case -1294005119: // preferred
          this.preferred = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 950398559: // comment
          this.comment = TypeConvertor.castToString(value); // StringType
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -1557344881: // authoritative
          this.authoritative = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new NamingSystemIdentifierTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<NamingSystemIdentifierType>
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("preferred")) {
          this.preferred = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("comment")) {
          this.comment = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("authoritative")) {
          this.authoritative = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case 111972721:  return getValueElement();
        case -1294005119:  return getPreferredElement();
        case 950398559:  return getCommentElement();
        case -991726143:  return getPeriod();
        case -1557344881:  return getAuthoritativeElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case 111972721: /*value*/ return new String[] {"string"};
        case -1294005119: /*preferred*/ return new String[] {"boolean"};
        case 950398559: /*comment*/ return new String[] {"string"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case -1557344881: /*authoritative*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.uniqueId.type");
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.uniqueId.value");
        }
        else if (name.equals("preferred")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.uniqueId.preferred");
        }
        else if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.uniqueId.comment");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("authoritative")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.uniqueId.authoritative");
        }
        else
          return super.addChild(name);
      }

      public NamingSystemUniqueIdComponent copy() {
        NamingSystemUniqueIdComponent dst = new NamingSystemUniqueIdComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(NamingSystemUniqueIdComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
        dst.preferred = preferred == null ? null : preferred.copy();
        dst.comment = comment == null ? null : comment.copy();
        dst.period = period == null ? null : period.copy();
        dst.authoritative = authoritative == null ? null : authoritative.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof NamingSystemUniqueIdComponent))
          return false;
        NamingSystemUniqueIdComponent o = (NamingSystemUniqueIdComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true) && compareDeep(preferred, o.preferred, true)
           && compareDeep(comment, o.comment, true) && compareDeep(period, o.period, true) && compareDeep(authoritative, o.authoritative, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof NamingSystemUniqueIdComponent))
          return false;
        NamingSystemUniqueIdComponent o = (NamingSystemUniqueIdComponent) other_;
        return compareValues(type, o.type, true) && compareValues(value, o.value, true) && compareValues(preferred, o.preferred, true)
           && compareValues(comment, o.comment, true) && compareValues(authoritative, o.authoritative, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value, preferred, comment
          , period, authoritative);
      }

  public String fhirType() {
    return "NamingSystem.uniqueId";

  }

  }

    /**
     * An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this naming system, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this naming system when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the naming system (business identifier)", formalDefinition="A formal identifier that is used to identify this naming system when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the naming system", formalDefinition="The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * Indicates the mechanism used to compare versions to determine which NamingSystem is more current.
     */
    @Child(name = "versionAlgorithm", type = {StringType.class, Coding.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How to compare versions", formalDefinition="Indicates the mechanism used to compare versions to determine which NamingSystem is more current." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/version-algorithm")
    protected DataType versionAlgorithm;

    /**
     * A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this naming system (computer friendly)", formalDefinition="A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the naming system.
     */
    @Child(name = "title", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Title for this naming system (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the naming system." )
    protected StringType title;

    /**
     * The status of this naming system. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this naming system. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * Indicates the purpose for the naming system - what kinds of things does it make unique?
     */
    @Child(name = "kind", type = {CodeType.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="codesystem | identifier | root", formalDefinition="Indicates the purpose for the naming system - what kinds of things does it make unique?" )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/namingsystem-type")
    protected Enumeration<NamingSystemType> kind;

    /**
     * A Boolean value to indicate that this naming system is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this naming system is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the naming system was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=9, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the naming system was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the naming system.
     */
    @Child(name = "publisher", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the naming system." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision.
     */
    @Child(name = "responsible", type = {StringType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Who maintains system namespace?", formalDefinition="The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision." )
    protected StringType responsible;

    /**
     * Categorizes a naming system for easier search by grouping related naming systems.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="e.g. driver,  provider,  patient, bank etc", formalDefinition="Categorizes a naming system for easier search by grouping related naming systems." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/namingsystem-identifier-system-type")
    protected CodeableConcept type;

    /**
     * A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the naming system", formalDefinition="A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate naming system instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate naming system instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the naming system is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for naming system (if applicable)", formalDefinition="A legal or geographic region in which the naming system is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this naming system is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this naming system is defined", formalDefinition="Explanation of why this naming system is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the naming system and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the naming system.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the naming system and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the naming system." )
    protected MarkdownType copyright;

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    @Child(name = "copyrightLabel", type = {StringType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright holder and year(s)", formalDefinition="A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved')." )
    protected StringType copyrightLabel;

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the NamingSystem was approved by publisher", formalDefinition="The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the NamingSystem was last reviewed by the publisher", formalDefinition="The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the NamingSystem content was or is planned to be in active use.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=22, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the NamingSystem is expected to be used", formalDefinition="The period during which the NamingSystem content was or is planned to be in active use." )
    protected Period effectivePeriod;

    /**
     * Descriptions related to the content of the NamingSystem. Topics provide a high-level categorization as well as keywords for the NamingSystem that can be useful for filtering and searching.
     */
    @Child(name = "topic", type = {CodeableConcept.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="E.g. Education, Treatment, Assessment, etc", formalDefinition="Descriptions related to the content of the NamingSystem. Topics provide a high-level categorization as well as keywords for the NamingSystem that can be useful for filtering and searching." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/definition-topic")
    protected List<CodeableConcept> topic;

    /**
     * An individiual or organization primarily involved in the creation and maintenance of the NamingSystem.
     */
    @Child(name = "author", type = {ContactDetail.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who authored the CodeSystem", formalDefinition="An individiual or organization primarily involved in the creation and maintenance of the NamingSystem." )
    protected List<ContactDetail> author;

    /**
     * An individual or organization primarily responsible for internal coherence of the NamingSystem.
     */
    @Child(name = "editor", type = {ContactDetail.class}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who edited the NamingSystem", formalDefinition="An individual or organization primarily responsible for internal coherence of the NamingSystem." )
    protected List<ContactDetail> editor;

    /**
     * An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the NamingSystem.
     */
    @Child(name = "reviewer", type = {ContactDetail.class}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who reviewed the NamingSystem", formalDefinition="An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the NamingSystem." )
    protected List<ContactDetail> reviewer;

    /**
     * An individual or organization asserted by the publisher to be responsible for officially endorsing the NamingSystem for use in some setting.
     */
    @Child(name = "endorser", type = {ContactDetail.class}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who endorsed the NamingSystem", formalDefinition="An individual or organization asserted by the publisher to be responsible for officially endorsing the NamingSystem for use in some setting." )
    protected List<ContactDetail> endorser;

    /**
     * Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional documentation, citations, etc", formalDefinition="Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts." )
    protected List<RelatedArtifact> relatedArtifact;

    /**
     * Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc.
     */
    @Child(name = "usage", type = {StringType.class}, order=29, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="How/where is it used", formalDefinition="Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc." )
    protected StringType usage;

    /**
     * Indicates how the system may be identified when referenced in electronic exchange.
     */
    @Child(name = "uniqueId", type = {}, order=30, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique identifiers used for system", formalDefinition="Indicates how the system may be identified when referenced in electronic exchange." )
    protected List<NamingSystemUniqueIdComponent> uniqueId;

    private static final long serialVersionUID = -1403308569L;

  /**
   * Constructor
   */
    public NamingSystem() {
      super();
    }

  /**
   * Constructor
   */
    public NamingSystem(String name, PublicationStatus status, NamingSystemType kind, Date date, NamingSystemUniqueIdComponent uniqueId) {
      super();
      this.setName(name);
      this.setStatus(status);
      this.setKind(kind);
      this.setDate(date);
      this.addUniqueId(uniqueId);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public NamingSystem setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.
     */
    public NamingSystem setUrl(String value) { 
      if (Utilities.noString(value))
        this.url = null;
      else {
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this naming system when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setIdentifier(List<Identifier> theIdentifier) { 
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

    public NamingSystem addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public NamingSystem setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public NamingSystem setVersion(String value) { 
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
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which NamingSystem is more current.)
     */
    public DataType getVersionAlgorithm() { 
      return this.versionAlgorithm;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which NamingSystem is more current.)
     */
    public StringType getVersionAlgorithmStringType() throws FHIRException { 
      if (this.versionAlgorithm == null)
        this.versionAlgorithm = new StringType();
      if (!(this.versionAlgorithm instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.versionAlgorithm.getClass().getName()+" was encountered");
      return (StringType) this.versionAlgorithm;
    }

    public boolean hasVersionAlgorithmStringType() { 
      return this != null && this.versionAlgorithm instanceof StringType;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which NamingSystem is more current.)
     */
    public Coding getVersionAlgorithmCoding() throws FHIRException { 
      if (this.versionAlgorithm == null)
        this.versionAlgorithm = new Coding();
      if (!(this.versionAlgorithm instanceof Coding))
        throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.versionAlgorithm.getClass().getName()+" was encountered");
      return (Coding) this.versionAlgorithm;
    }

    public boolean hasVersionAlgorithmCoding() { 
      return this != null && this.versionAlgorithm instanceof Coding;
    }

    public boolean hasVersionAlgorithm() { 
      return this.versionAlgorithm != null && !this.versionAlgorithm.isEmpty();
    }

    /**
     * @param value {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which NamingSystem is more current.)
     */
    public NamingSystem setVersionAlgorithm(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof Coding))
        throw new FHIRException("Not the right type for NamingSystem.versionAlgorithm[x]: "+value.fhirType());
      this.versionAlgorithm = value;
      return this;
    }

    /**
     * @return {@link #name} (A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.name");
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
     * @param value {@link #name} (A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public NamingSystem setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public NamingSystem setName(String value) { 
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      return this;
    }

    /**
     * @return {@link #title} (A short, descriptive, user-friendly title for the naming system.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the naming system.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public NamingSystem setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the naming system.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the naming system.
     */
    public NamingSystem setTitle(String value) { 
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
     * @return {@link #status} (The status of this naming system. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.status");
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
     * @param value {@link #status} (The status of this naming system. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public NamingSystem setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this naming system. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this naming system. Enables tracking the life-cycle of the content.
     */
    public NamingSystem setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #kind} (Indicates the purpose for the naming system - what kinds of things does it make unique?). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public Enumeration<NamingSystemType> getKindElement() { 
      if (this.kind == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.kind");
        else if (Configuration.doAutoCreate())
          this.kind = new Enumeration<NamingSystemType>(new NamingSystemTypeEnumFactory()); // bb
      return this.kind;
    }

    public boolean hasKindElement() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    public boolean hasKind() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    /**
     * @param value {@link #kind} (Indicates the purpose for the naming system - what kinds of things does it make unique?). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public NamingSystem setKindElement(Enumeration<NamingSystemType> value) { 
      this.kind = value;
      return this;
    }

    /**
     * @return Indicates the purpose for the naming system - what kinds of things does it make unique?
     */
    public NamingSystemType getKind() { 
      return this.kind == null ? null : this.kind.getValue();
    }

    /**
     * @param value Indicates the purpose for the naming system - what kinds of things does it make unique?
     */
    public NamingSystem setKind(NamingSystemType value) { 
        if (this.kind == null)
          this.kind = new Enumeration<NamingSystemType>(new NamingSystemTypeEnumFactory());
        this.kind.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this naming system is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.experimental");
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
     * @param value {@link #experimental} (A Boolean value to indicate that this naming system is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public NamingSystem setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this naming system is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this naming system is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public NamingSystem setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the naming system was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the naming system was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public NamingSystem setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the naming system was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the naming system was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.
     */
    public NamingSystem setDate(Date value) { 
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      return this;
    }

    /**
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the naming system.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.publisher");
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
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the naming system.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public NamingSystem setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the naming system.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the naming system.
     */
    public NamingSystem setPublisher(String value) { 
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
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public List<ContactDetail> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setContact(List<ContactDetail> theContact) { 
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

    public ContactDetail addContact() { //3
      ContactDetail t = new ContactDetail();
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return t;
    }

    public NamingSystem addContact(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ContactDetail getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #responsible} (The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision.). This is the underlying object with id, value and extensions. The accessor "getResponsible" gives direct access to the value
     */
    public StringType getResponsibleElement() { 
      if (this.responsible == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.responsible");
        else if (Configuration.doAutoCreate())
          this.responsible = new StringType(); // bb
      return this.responsible;
    }

    public boolean hasResponsibleElement() { 
      return this.responsible != null && !this.responsible.isEmpty();
    }

    public boolean hasResponsible() { 
      return this.responsible != null && !this.responsible.isEmpty();
    }

    /**
     * @param value {@link #responsible} (The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision.). This is the underlying object with id, value and extensions. The accessor "getResponsible" gives direct access to the value
     */
    public NamingSystem setResponsibleElement(StringType value) { 
      this.responsible = value;
      return this;
    }

    /**
     * @return The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision.
     */
    public String getResponsible() { 
      return this.responsible == null ? null : this.responsible.getValue();
    }

    /**
     * @param value The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision.
     */
    public NamingSystem setResponsible(String value) { 
      if (Utilities.noString(value))
        this.responsible = null;
      else {
        if (this.responsible == null)
          this.responsible = new StringType();
        this.responsible.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #type} (Categorizes a naming system for easier search by grouping related naming systems.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Categorizes a naming system for easier search by grouping related naming systems.)
     */
    public NamingSystem setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #description} (A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.description");
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
     * @param value {@link #description} (A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public NamingSystem setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc.
     */
    public NamingSystem setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate naming system instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setUseContext(List<UsageContext> theUseContext) { 
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

    public UsageContext addUseContext() { //3
      UsageContext t = new UsageContext();
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return t;
    }

    public NamingSystem addUseContext(UsageContext t) { //3
      if (t == null)
        return this;
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist {3}
     */
    public UsageContext getUseContextFirstRep() { 
      if (getUseContext().isEmpty()) {
        addUseContext();
      }
      return getUseContext().get(0);
    }

    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the naming system is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public CodeableConcept addJurisdiction() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return t;
    }

    public NamingSystem addJurisdiction(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      this.jurisdiction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {3}
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      if (getJurisdiction().isEmpty()) {
        addJurisdiction();
      }
      return getJurisdiction().get(0);
    }

    /**
     * @return {@link #purpose} (Explanation of why this naming system is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.purpose");
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
     * @param value {@link #purpose} (Explanation of why this naming system is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public NamingSystem setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this naming system is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this naming system is needed and why it has been designed as it has.
     */
    public NamingSystem setPurpose(String value) { 
      if (Utilities.noString(value))
        this.purpose = null;
      else {
        if (this.purpose == null)
          this.purpose = new MarkdownType();
        this.purpose.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (A copyright statement relating to the naming system and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the naming system.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the naming system and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the naming system.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public NamingSystem setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the naming system and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the naming system.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the naming system and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the naming system.
     */
    public NamingSystem setCopyright(String value) { 
      if (Utilities.noString(value))
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StringType getCopyrightLabelElement() { 
      if (this.copyrightLabel == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.copyrightLabel");
        else if (Configuration.doAutoCreate())
          this.copyrightLabel = new StringType(); // bb
      return this.copyrightLabel;
    }

    public boolean hasCopyrightLabelElement() { 
      return this.copyrightLabel != null && !this.copyrightLabel.isEmpty();
    }

    public boolean hasCopyrightLabel() { 
      return this.copyrightLabel != null && !this.copyrightLabel.isEmpty();
    }

    /**
     * @param value {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public NamingSystem setCopyrightLabelElement(StringType value) { 
      this.copyrightLabel = value;
      return this;
    }

    /**
     * @return A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public String getCopyrightLabel() { 
      return this.copyrightLabel == null ? null : this.copyrightLabel.getValue();
    }

    /**
     * @param value A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public NamingSystem setCopyrightLabel(String value) { 
      if (Utilities.noString(value))
        this.copyrightLabel = null;
      else {
        if (this.copyrightLabel == null)
          this.copyrightLabel = new StringType();
        this.copyrightLabel.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.approvalDate");
        else if (Configuration.doAutoCreate())
          this.approvalDate = new DateType(); // bb
      return this.approvalDate;
    }

    public boolean hasApprovalDateElement() { 
      return this.approvalDate != null && !this.approvalDate.isEmpty();
    }

    public boolean hasApprovalDate() { 
      return this.approvalDate != null && !this.approvalDate.isEmpty();
    }

    /**
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public NamingSystem setApprovalDateElement(DateType value) { 
      this.approvalDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Date getApprovalDate() { 
      return this.approvalDate == null ? null : this.approvalDate.getValue();
    }

    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public NamingSystem setApprovalDate(Date value) { 
      if (value == null)
        this.approvalDate = null;
      else {
        if (this.approvalDate == null)
          this.approvalDate = new DateType();
        this.approvalDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      if (this.lastReviewDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.lastReviewDate");
        else if (Configuration.doAutoCreate())
          this.lastReviewDate = new DateType(); // bb
      return this.lastReviewDate;
    }

    public boolean hasLastReviewDateElement() { 
      return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
    }

    public boolean hasLastReviewDate() { 
      return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
    }

    /**
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public NamingSystem setLastReviewDateElement(DateType value) { 
      this.lastReviewDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public Date getLastReviewDate() { 
      return this.lastReviewDate == null ? null : this.lastReviewDate.getValue();
    }

    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public NamingSystem setLastReviewDate(Date value) { 
      if (value == null)
        this.lastReviewDate = null;
      else {
        if (this.lastReviewDate == null)
          this.lastReviewDate = new DateType();
        this.lastReviewDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #effectivePeriod} (The period during which the NamingSystem content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the NamingSystem content was or is planned to be in active use.)
     */
    public NamingSystem setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #topic} (Descriptions related to the content of the NamingSystem. Topics provide a high-level categorization as well as keywords for the NamingSystem that can be useful for filtering and searching.)
     */
    public List<CodeableConcept> getTopic() { 
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      return this.topic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setTopic(List<CodeableConcept> theTopic) { 
      this.topic = theTopic;
      return this;
    }

    public boolean hasTopic() { 
      if (this.topic == null)
        return false;
      for (CodeableConcept item : this.topic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addTopic() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      this.topic.add(t);
      return t;
    }

    public NamingSystem addTopic(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      this.topic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #topic}, creating it if it does not already exist {3}
     */
    public CodeableConcept getTopicFirstRep() { 
      if (getTopic().isEmpty()) {
        addTopic();
      }
      return getTopic().get(0);
    }

    /**
     * @return {@link #author} (An individiual or organization primarily involved in the creation and maintenance of the NamingSystem.)
     */
    public List<ContactDetail> getAuthor() { 
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      return this.author;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setAuthor(List<ContactDetail> theAuthor) { 
      this.author = theAuthor;
      return this;
    }

    public boolean hasAuthor() { 
      if (this.author == null)
        return false;
      for (ContactDetail item : this.author)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addAuthor() { //3
      ContactDetail t = new ContactDetail();
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      this.author.add(t);
      return t;
    }

    public NamingSystem addAuthor(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      this.author.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist {3}
     */
    public ContactDetail getAuthorFirstRep() { 
      if (getAuthor().isEmpty()) {
        addAuthor();
      }
      return getAuthor().get(0);
    }

    /**
     * @return {@link #editor} (An individual or organization primarily responsible for internal coherence of the NamingSystem.)
     */
    public List<ContactDetail> getEditor() { 
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      return this.editor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setEditor(List<ContactDetail> theEditor) { 
      this.editor = theEditor;
      return this;
    }

    public boolean hasEditor() { 
      if (this.editor == null)
        return false;
      for (ContactDetail item : this.editor)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addEditor() { //3
      ContactDetail t = new ContactDetail();
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      this.editor.add(t);
      return t;
    }

    public NamingSystem addEditor(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      this.editor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #editor}, creating it if it does not already exist {3}
     */
    public ContactDetail getEditorFirstRep() { 
      if (getEditor().isEmpty()) {
        addEditor();
      }
      return getEditor().get(0);
    }

    /**
     * @return {@link #reviewer} (An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the NamingSystem.)
     */
    public List<ContactDetail> getReviewer() { 
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      return this.reviewer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setReviewer(List<ContactDetail> theReviewer) { 
      this.reviewer = theReviewer;
      return this;
    }

    public boolean hasReviewer() { 
      if (this.reviewer == null)
        return false;
      for (ContactDetail item : this.reviewer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addReviewer() { //3
      ContactDetail t = new ContactDetail();
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      this.reviewer.add(t);
      return t;
    }

    public NamingSystem addReviewer(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      this.reviewer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reviewer}, creating it if it does not already exist {3}
     */
    public ContactDetail getReviewerFirstRep() { 
      if (getReviewer().isEmpty()) {
        addReviewer();
      }
      return getReviewer().get(0);
    }

    /**
     * @return {@link #endorser} (An individual or organization asserted by the publisher to be responsible for officially endorsing the NamingSystem for use in some setting.)
     */
    public List<ContactDetail> getEndorser() { 
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      return this.endorser;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setEndorser(List<ContactDetail> theEndorser) { 
      this.endorser = theEndorser;
      return this;
    }

    public boolean hasEndorser() { 
      if (this.endorser == null)
        return false;
      for (ContactDetail item : this.endorser)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addEndorser() { //3
      ContactDetail t = new ContactDetail();
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      this.endorser.add(t);
      return t;
    }

    public NamingSystem addEndorser(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      this.endorser.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #endorser}, creating it if it does not already exist {3}
     */
    public ContactDetail getEndorserFirstRep() { 
      if (getEndorser().isEmpty()) {
        addEndorser();
      }
      return getEndorser().get(0);
    }

    /**
     * @return {@link #relatedArtifact} (Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      return this.relatedArtifact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
      this.relatedArtifact = theRelatedArtifact;
      return this;
    }

    public boolean hasRelatedArtifact() { 
      if (this.relatedArtifact == null)
        return false;
      for (RelatedArtifact item : this.relatedArtifact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RelatedArtifact addRelatedArtifact() { //3
      RelatedArtifact t = new RelatedArtifact();
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return t;
    }

    public NamingSystem addRelatedArtifact(RelatedArtifact t) { //3
      if (t == null)
        return this;
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {3}
     */
    public RelatedArtifact getRelatedArtifactFirstRep() { 
      if (getRelatedArtifact().isEmpty()) {
        addRelatedArtifact();
      }
      return getRelatedArtifact().get(0);
    }

    /**
     * @return {@link #usage} (Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc.). This is the underlying object with id, value and extensions. The accessor "getUsage" gives direct access to the value
     */
    public StringType getUsageElement() { 
      if (this.usage == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create NamingSystem.usage");
        else if (Configuration.doAutoCreate())
          this.usage = new StringType(); // bb
      return this.usage;
    }

    public boolean hasUsageElement() { 
      return this.usage != null && !this.usage.isEmpty();
    }

    public boolean hasUsage() { 
      return this.usage != null && !this.usage.isEmpty();
    }

    /**
     * @param value {@link #usage} (Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc.). This is the underlying object with id, value and extensions. The accessor "getUsage" gives direct access to the value
     */
    public NamingSystem setUsageElement(StringType value) { 
      this.usage = value;
      return this;
    }

    /**
     * @return Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc.
     */
    public String getUsage() { 
      return this.usage == null ? null : this.usage.getValue();
    }

    /**
     * @param value Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc.
     */
    public NamingSystem setUsage(String value) { 
      if (Utilities.noString(value))
        this.usage = null;
      else {
        if (this.usage == null)
          this.usage = new StringType();
        this.usage.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #uniqueId} (Indicates how the system may be identified when referenced in electronic exchange.)
     */
    public List<NamingSystemUniqueIdComponent> getUniqueId() { 
      if (this.uniqueId == null)
        this.uniqueId = new ArrayList<NamingSystemUniqueIdComponent>();
      return this.uniqueId;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setUniqueId(List<NamingSystemUniqueIdComponent> theUniqueId) { 
      this.uniqueId = theUniqueId;
      return this;
    }

    public boolean hasUniqueId() { 
      if (this.uniqueId == null)
        return false;
      for (NamingSystemUniqueIdComponent item : this.uniqueId)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public NamingSystemUniqueIdComponent addUniqueId() { //3
      NamingSystemUniqueIdComponent t = new NamingSystemUniqueIdComponent();
      if (this.uniqueId == null)
        this.uniqueId = new ArrayList<NamingSystemUniqueIdComponent>();
      this.uniqueId.add(t);
      return t;
    }

    public NamingSystem addUniqueId(NamingSystemUniqueIdComponent t) { //3
      if (t == null)
        return this;
      if (this.uniqueId == null)
        this.uniqueId = new ArrayList<NamingSystemUniqueIdComponent>();
      this.uniqueId.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #uniqueId}, creating it if it does not already exist {3}
     */
    public NamingSystemUniqueIdComponent getUniqueIdFirstRep() { 
      if (getUniqueId().isEmpty()) {
        addUniqueId();
      }
      return getUniqueId().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this naming system when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which NamingSystem is more current.", 0, 1, versionAlgorithm));
        children.add(new Property("name", "string", "A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the naming system.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this naming system. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("kind", "code", "Indicates the purpose for the naming system - what kinds of things does it make unique?", 0, 1, kind));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this naming system is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the naming system was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the naming system.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("responsible", "string", "The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision.", 0, 1, responsible));
        children.add(new Property("type", "CodeableConcept", "Categorizes a naming system for easier search by grouping related naming systems.", 0, 1, type));
        children.add(new Property("description", "markdown", "A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate naming system instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the naming system is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this naming system is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the naming system and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the naming system.", 0, 1, copyright));
        children.add(new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel));
        children.add(new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the NamingSystem content was or is planned to be in active use.", 0, 1, effectivePeriod));
        children.add(new Property("topic", "CodeableConcept", "Descriptions related to the content of the NamingSystem. Topics provide a high-level categorization as well as keywords for the NamingSystem that can be useful for filtering and searching.", 0, java.lang.Integer.MAX_VALUE, topic));
        children.add(new Property("author", "ContactDetail", "An individiual or organization primarily involved in the creation and maintenance of the NamingSystem.", 0, java.lang.Integer.MAX_VALUE, author));
        children.add(new Property("editor", "ContactDetail", "An individual or organization primarily responsible for internal coherence of the NamingSystem.", 0, java.lang.Integer.MAX_VALUE, editor));
        children.add(new Property("reviewer", "ContactDetail", "An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the NamingSystem.", 0, java.lang.Integer.MAX_VALUE, reviewer));
        children.add(new Property("endorser", "ContactDetail", "An individual or organization asserted by the publisher to be responsible for officially endorsing the NamingSystem for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
        children.add(new Property("usage", "string", "Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc.", 0, 1, usage));
        children.add(new Property("uniqueId", "", "Indicates how the system may be identified when referenced in electronic exchange.", 0, java.lang.Integer.MAX_VALUE, uniqueId));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this naming system when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case -115699031: /*versionAlgorithm[x]*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which NamingSystem is more current.", 0, 1, versionAlgorithm);
        case 1508158071: /*versionAlgorithm*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which NamingSystem is more current.", 0, 1, versionAlgorithm);
        case 1836908904: /*versionAlgorithmString*/  return new Property("versionAlgorithm[x]", "string", "Indicates the mechanism used to compare versions to determine which NamingSystem is more current.", 0, 1, versionAlgorithm);
        case 1373807809: /*versionAlgorithmCoding*/  return new Property("versionAlgorithm[x]", "Coding", "Indicates the mechanism used to compare versions to determine which NamingSystem is more current.", 0, 1, versionAlgorithm);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the naming system.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this naming system. Enables tracking the life-cycle of the content.", 0, 1, status);
        case 3292052: /*kind*/  return new Property("kind", "code", "Indicates the purpose for the naming system - what kinds of things does it make unique?", 0, 1, kind);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this naming system is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the naming system was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the naming system.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case 1847674614: /*responsible*/  return new Property("responsible", "string", "The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision.", 0, 1, responsible);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Categorizes a naming system for easier search by grouping related naming systems.", 0, 1, type);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate naming system instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the naming system is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this naming system is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the naming system and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the naming system.", 0, 1, copyright);
        case 765157229: /*copyrightLabel*/  return new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the NamingSystem content was or is planned to be in active use.", 0, 1, effectivePeriod);
        case 110546223: /*topic*/  return new Property("topic", "CodeableConcept", "Descriptions related to the content of the NamingSystem. Topics provide a high-level categorization as well as keywords for the NamingSystem that can be useful for filtering and searching.", 0, java.lang.Integer.MAX_VALUE, topic);
        case -1406328437: /*author*/  return new Property("author", "ContactDetail", "An individiual or organization primarily involved in the creation and maintenance of the NamingSystem.", 0, java.lang.Integer.MAX_VALUE, author);
        case -1307827859: /*editor*/  return new Property("editor", "ContactDetail", "An individual or organization primarily responsible for internal coherence of the NamingSystem.", 0, java.lang.Integer.MAX_VALUE, editor);
        case -261190139: /*reviewer*/  return new Property("reviewer", "ContactDetail", "An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the NamingSystem.", 0, java.lang.Integer.MAX_VALUE, reviewer);
        case 1740277666: /*endorser*/  return new Property("endorser", "ContactDetail", "An individual or organization asserted by the publisher to be responsible for officially endorsing the NamingSystem for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        case 111574433: /*usage*/  return new Property("usage", "string", "Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc.", 0, 1, usage);
        case -294460212: /*uniqueId*/  return new Property("uniqueId", "", "Indicates how the system may be identified when referenced in electronic exchange.", 0, java.lang.Integer.MAX_VALUE, uniqueId);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 1508158071: /*versionAlgorithm*/ return this.versionAlgorithm == null ? new Base[0] : new Base[] {this.versionAlgorithm}; // DataType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case 3292052: /*kind*/ return this.kind == null ? new Base[0] : new Base[] {this.kind}; // Enumeration<NamingSystemType>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case 1847674614: /*responsible*/ return this.responsible == null ? new Base[0] : new Base[] {this.responsible}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 765157229: /*copyrightLabel*/ return this.copyrightLabel == null ? new Base[0] : new Base[] {this.copyrightLabel}; // StringType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case 110546223: /*topic*/ return this.topic == null ? new Base[0] : this.topic.toArray(new Base[this.topic.size()]); // CodeableConcept
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // ContactDetail
        case -1307827859: /*editor*/ return this.editor == null ? new Base[0] : this.editor.toArray(new Base[this.editor.size()]); // ContactDetail
        case -261190139: /*reviewer*/ return this.reviewer == null ? new Base[0] : this.reviewer.toArray(new Base[this.reviewer.size()]); // ContactDetail
        case 1740277666: /*endorser*/ return this.endorser == null ? new Base[0] : this.endorser.toArray(new Base[this.endorser.size()]); // ContactDetail
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case 111574433: /*usage*/ return this.usage == null ? new Base[0] : new Base[] {this.usage}; // StringType
        case -294460212: /*uniqueId*/ return this.uniqueId == null ? new Base[0] : this.uniqueId.toArray(new Base[this.uniqueId.size()]); // NamingSystemUniqueIdComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 1508158071: // versionAlgorithm
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case 3292052: // kind
          value = new NamingSystemTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<NamingSystemType>
          return value;
        case -404562712: // experimental
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1447404028: // publisher
          this.publisher = TypeConvertor.castToString(value); // StringType
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case 1847674614: // responsible
          this.responsible = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        case -507075711: // jurisdiction
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -220463842: // purpose
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 765157229: // copyrightLabel
          this.copyrightLabel = TypeConvertor.castToString(value); // StringType
          return value;
        case 223539345: // approvalDate
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1687512484: // lastReviewDate
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -403934648: // effectivePeriod
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 110546223: // topic
          this.getTopic().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1406328437: // author
          this.getAuthor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -1307827859: // editor
          this.getEditor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -261190139: // reviewer
          this.getReviewer().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case 1740277666: // endorser
          this.getEndorser().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case 666807069: // relatedArtifact
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case 111574433: // usage
          this.usage = TypeConvertor.castToString(value); // StringType
          return value;
        case -294460212: // uniqueId
          this.getUniqueId().add((NamingSystemUniqueIdComponent) value); // NamingSystemUniqueIdComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("versionAlgorithm[x]")) {
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("kind")) {
          value = new NamingSystemTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<NamingSystemType>
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("responsible")) {
          this.responsible = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyrightLabel")) {
          this.copyrightLabel = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("approvalDate")) {
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("topic")) {
          this.getTopic().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("author")) {
          this.getAuthor().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("editor")) {
          this.getEditor().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("reviewer")) {
          this.getReviewer().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("endorser")) {
          this.getEndorser().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("usage")) {
          this.usage = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("uniqueId")) {
          this.getUniqueId().add((NamingSystemUniqueIdComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return getVersionElement();
        case -115699031:  return getVersionAlgorithm();
        case 1508158071:  return getVersionAlgorithm();
        case 3373707:  return getNameElement();
        case 110371416:  return getTitleElement();
        case -892481550:  return getStatusElement();
        case 3292052:  return getKindElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case 1847674614:  return getResponsibleElement();
        case 3575610:  return getType();
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 765157229:  return getCopyrightLabelElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -403934648:  return getEffectivePeriod();
        case 110546223:  return addTopic(); 
        case -1406328437:  return addAuthor(); 
        case -1307827859:  return addEditor(); 
        case -261190139:  return addReviewer(); 
        case 1740277666:  return addEndorser(); 
        case 666807069:  return addRelatedArtifact(); 
        case 111574433:  return getUsageElement();
        case -294460212:  return addUniqueId(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 1508158071: /*versionAlgorithm*/ return new String[] {"string", "Coding"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 3292052: /*kind*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case 1847674614: /*responsible*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 765157229: /*copyrightLabel*/ return new String[] {"string"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case 110546223: /*topic*/ return new String[] {"CodeableConcept"};
        case -1406328437: /*author*/ return new String[] {"ContactDetail"};
        case -1307827859: /*editor*/ return new String[] {"ContactDetail"};
        case -261190139: /*reviewer*/ return new String[] {"ContactDetail"};
        case 1740277666: /*endorser*/ return new String[] {"ContactDetail"};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case 111574433: /*usage*/ return new String[] {"string"};
        case -294460212: /*uniqueId*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.version");
        }
        else if (name.equals("versionAlgorithmString")) {
          this.versionAlgorithm = new StringType();
          return this.versionAlgorithm;
        }
        else if (name.equals("versionAlgorithmCoding")) {
          this.versionAlgorithm = new Coding();
          return this.versionAlgorithm;
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.status");
        }
        else if (name.equals("kind")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.kind");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("responsible")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.responsible");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.copyright");
        }
        else if (name.equals("copyrightLabel")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.copyrightLabel");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("topic")) {
          return addTopic();
        }
        else if (name.equals("author")) {
          return addAuthor();
        }
        else if (name.equals("editor")) {
          return addEditor();
        }
        else if (name.equals("reviewer")) {
          return addReviewer();
        }
        else if (name.equals("endorser")) {
          return addEndorser();
        }
        else if (name.equals("relatedArtifact")) {
          return addRelatedArtifact();
        }
        else if (name.equals("usage")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.usage");
        }
        else if (name.equals("uniqueId")) {
          return addUniqueId();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "NamingSystem";

  }

      public NamingSystem copy() {
        NamingSystem dst = new NamingSystem();
        copyValues(dst);
        return dst;
      }

      public void copyValues(NamingSystem dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.versionAlgorithm = versionAlgorithm == null ? null : versionAlgorithm.copy();
        dst.name = name == null ? null : name.copy();
        dst.title = title == null ? null : title.copy();
        dst.status = status == null ? null : status.copy();
        dst.kind = kind == null ? null : kind.copy();
        dst.experimental = experimental == null ? null : experimental.copy();
        dst.date = date == null ? null : date.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactDetail>();
          for (ContactDetail i : contact)
            dst.contact.add(i.copy());
        };
        dst.responsible = responsible == null ? null : responsible.copy();
        dst.type = type == null ? null : type.copy();
        dst.description = description == null ? null : description.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        if (jurisdiction != null) {
          dst.jurisdiction = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : jurisdiction)
            dst.jurisdiction.add(i.copy());
        };
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.copyrightLabel = copyrightLabel == null ? null : copyrightLabel.copy();
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        if (topic != null) {
          dst.topic = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : topic)
            dst.topic.add(i.copy());
        };
        if (author != null) {
          dst.author = new ArrayList<ContactDetail>();
          for (ContactDetail i : author)
            dst.author.add(i.copy());
        };
        if (editor != null) {
          dst.editor = new ArrayList<ContactDetail>();
          for (ContactDetail i : editor)
            dst.editor.add(i.copy());
        };
        if (reviewer != null) {
          dst.reviewer = new ArrayList<ContactDetail>();
          for (ContactDetail i : reviewer)
            dst.reviewer.add(i.copy());
        };
        if (endorser != null) {
          dst.endorser = new ArrayList<ContactDetail>();
          for (ContactDetail i : endorser)
            dst.endorser.add(i.copy());
        };
        if (relatedArtifact != null) {
          dst.relatedArtifact = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : relatedArtifact)
            dst.relatedArtifact.add(i.copy());
        };
        dst.usage = usage == null ? null : usage.copy();
        if (uniqueId != null) {
          dst.uniqueId = new ArrayList<NamingSystemUniqueIdComponent>();
          for (NamingSystemUniqueIdComponent i : uniqueId)
            dst.uniqueId.add(i.copy());
        };
      }

      protected NamingSystem typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof NamingSystem))
          return false;
        NamingSystem o = (NamingSystem) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(versionAlgorithm, o.versionAlgorithm, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
           && compareDeep(status, o.status, true) && compareDeep(kind, o.kind, true) && compareDeep(experimental, o.experimental, true)
           && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true)
           && compareDeep(responsible, o.responsible, true) && compareDeep(type, o.type, true) && compareDeep(description, o.description, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true) && compareDeep(copyrightLabel, o.copyrightLabel, true)
           && compareDeep(approvalDate, o.approvalDate, true) && compareDeep(lastReviewDate, o.lastReviewDate, true)
           && compareDeep(effectivePeriod, o.effectivePeriod, true) && compareDeep(topic, o.topic, true) && compareDeep(author, o.author, true)
           && compareDeep(editor, o.editor, true) && compareDeep(reviewer, o.reviewer, true) && compareDeep(endorser, o.endorser, true)
           && compareDeep(relatedArtifact, o.relatedArtifact, true) && compareDeep(usage, o.usage, true) && compareDeep(uniqueId, o.uniqueId, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof NamingSystem))
          return false;
        NamingSystem o = (NamingSystem) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(kind, o.kind, true)
           && compareValues(experimental, o.experimental, true) && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true)
           && compareValues(responsible, o.responsible, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(copyrightLabel, o.copyrightLabel, true)
           && compareValues(approvalDate, o.approvalDate, true) && compareValues(lastReviewDate, o.lastReviewDate, true)
           && compareValues(usage, o.usage, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , versionAlgorithm, name, title, status, kind, experimental, date, publisher
          , contact, responsible, type, description, useContext, jurisdiction, purpose, copyright
          , copyrightLabel, approvalDate, lastReviewDate, effectivePeriod, topic, author, editor
          , reviewer, endorser, relatedArtifact, usage, uniqueId);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.NamingSystem;
   }

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition
* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition
* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [Library](library.html): A quantity- or range-valued use context assigned to the library
* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire
* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition\r\n* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition\r\n* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide\r\n* [Library](library.html): A quantity- or range-valued use context assigned to the library\r\n* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script\r\n* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set\r\n", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition
* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition
* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [Library](library.html): A quantity- or range-valued use context assigned to the library
* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire
* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition
* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition
* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [Library](library.html): A use context type and quantity- or range-based value assigned to the library
* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition\r\n* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition\r\n* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide\r\n* [Library](library.html): A use context type and quantity- or range-based value assigned to the library\r\n* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script\r\n* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition
* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition
* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [Library](library.html): A use context type and quantity- or range-based value assigned to the library
* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition
* [Citation](citation.html): A use context type and value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition
* [Evidence](evidence.html): A use context type and value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [Library](library.html): A use context type and value assigned to the library
* [Measure](measure.html): A use context type and value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and value assigned to the test script
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition\r\n* [Citation](citation.html): A use context type and value assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context type and value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition\r\n* [Evidence](evidence.html): A use context type and value assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide\r\n* [Library](library.html): A use context type and value assigned to the library\r\n* [Measure](measure.html): A use context type and value assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context type and value assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context type and value assigned to the test script\r\n* [ValueSet](valueset.html): A use context type and value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition
* [Citation](citation.html): A use context type and value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition
* [Evidence](evidence.html): A use context type and value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [Library](library.html): A use context type and value assigned to the library
* [Measure](measure.html): A use context type and value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and value assigned to the test script
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition
* [Citation](citation.html): A type of use context assigned to the citation
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition
* [Evidence](evidence.html): A type of use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [Library](library.html): A type of use context assigned to the library
* [Measure](measure.html): A type of use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire
* [Requirements](requirements.html): A type of use context assigned to the requirements
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [TestScript](testscript.html): A type of use context assigned to the test script
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition\r\n* [Citation](citation.html): A type of use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A type of use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition\r\n* [Evidence](evidence.html): A type of use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide\r\n* [Library](library.html): A type of use context assigned to the library\r\n* [Measure](measure.html): A type of use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A type of use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A type of use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A type of use context assigned to the test script\r\n* [ValueSet](valueset.html): A type of use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition
* [Citation](citation.html): A type of use context assigned to the citation
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition
* [Evidence](evidence.html): A type of use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [Library](library.html): A type of use context assigned to the library
* [Measure](measure.html): A type of use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire
* [Requirements](requirements.html): A type of use context assigned to the requirements
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [TestScript](testscript.html): A type of use context assigned to the test script
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition
* [Citation](citation.html): A use context assigned to the citation
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context assigned to the event definition
* [Evidence](evidence.html): A use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [Library](library.html): A use context assigned to the library
* [Measure](measure.html): A use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire
* [Requirements](requirements.html): A use context assigned to the requirements
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [TestScript](testscript.html): A use context assigned to the test script
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition\r\n* [Citation](citation.html): A use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context assigned to the event definition\r\n* [Evidence](evidence.html): A use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide\r\n* [Library](library.html): A use context assigned to the library\r\n* [Measure](measure.html): A use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context assigned to the test script\r\n* [ValueSet](valueset.html): A use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition
* [Citation](citation.html): A use context assigned to the citation
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context assigned to the event definition
* [Evidence](evidence.html): A use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [Library](library.html): A use context assigned to the library
* [Measure](measure.html): A use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire
* [Requirements](requirements.html): A use context assigned to the requirements
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [TestScript](testscript.html): A use context assigned to the test script
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The activity definition publication date
* [ActorDefinition](actordefinition.html): The Actor Definition publication date
* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date
* [Citation](citation.html): The citation publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [ConditionDefinition](conditiondefinition.html): The condition definition publication date
* [EventDefinition](eventdefinition.html): The event definition publication date
* [Evidence](evidence.html): The evidence publication date
* [EvidenceVariable](evidencevariable.html): The evidence variable publication date
* [ExampleScenario](examplescenario.html): The example scenario publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [Library](library.html): The library publication date
* [Measure](measure.html): The measure publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [PlanDefinition](plandefinition.html): The plan definition publication date
* [Questionnaire](questionnaire.html): The questionnaire publication date
* [Requirements](requirements.html): The requirements publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [SubscriptionTopic](subscriptiontopic.html): Date status first applied
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [TestScript](testscript.html): The test script publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The activity definition publication date\r\n* [ActorDefinition](actordefinition.html): The Actor Definition publication date\r\n* [CapabilityStatement](capabilitystatement.html): The capability statement publication date\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date\r\n* [Citation](citation.html): The citation publication date\r\n* [CodeSystem](codesystem.html): The code system publication date\r\n* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date\r\n* [ConceptMap](conceptmap.html): The concept map publication date\r\n* [ConditionDefinition](conditiondefinition.html): The condition definition publication date\r\n* [EventDefinition](eventdefinition.html): The event definition publication date\r\n* [Evidence](evidence.html): The evidence publication date\r\n* [EvidenceVariable](evidencevariable.html): The evidence variable publication date\r\n* [ExampleScenario](examplescenario.html): The example scenario publication date\r\n* [GraphDefinition](graphdefinition.html): The graph definition publication date\r\n* [ImplementationGuide](implementationguide.html): The implementation guide publication date\r\n* [Library](library.html): The library publication date\r\n* [Measure](measure.html): The measure publication date\r\n* [MessageDefinition](messagedefinition.html): The message definition publication date\r\n* [NamingSystem](namingsystem.html): The naming system publication date\r\n* [OperationDefinition](operationdefinition.html): The operation definition publication date\r\n* [PlanDefinition](plandefinition.html): The plan definition publication date\r\n* [Questionnaire](questionnaire.html): The questionnaire publication date\r\n* [Requirements](requirements.html): The requirements publication date\r\n* [SearchParameter](searchparameter.html): The search parameter publication date\r\n* [StructureDefinition](structuredefinition.html): The structure definition publication date\r\n* [StructureMap](structuremap.html): The structure map publication date\r\n* [SubscriptionTopic](subscriptiontopic.html): Date status first applied\r\n* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date\r\n* [TestScript](testscript.html): The test script publication date\r\n* [ValueSet](valueset.html): The value set publication date\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The activity definition publication date
* [ActorDefinition](actordefinition.html): The Actor Definition publication date
* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date
* [Citation](citation.html): The citation publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [ConditionDefinition](conditiondefinition.html): The condition definition publication date
* [EventDefinition](eventdefinition.html): The event definition publication date
* [Evidence](evidence.html): The evidence publication date
* [EvidenceVariable](evidencevariable.html): The evidence variable publication date
* [ExampleScenario](examplescenario.html): The example scenario publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [Library](library.html): The library publication date
* [Measure](measure.html): The measure publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [PlanDefinition](plandefinition.html): The plan definition publication date
* [Questionnaire](questionnaire.html): The questionnaire publication date
* [Requirements](requirements.html): The requirements publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [SubscriptionTopic](subscriptiontopic.html): Date status first applied
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [TestScript](testscript.html): The test script publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The description of the activity definition
* [ActorDefinition](actordefinition.html): The description of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition
* [Citation](citation.html): The description of the citation
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [ConditionDefinition](conditiondefinition.html): The description of the condition definition
* [EventDefinition](eventdefinition.html): The description of the event definition
* [Evidence](evidence.html): The description of the evidence
* [EvidenceVariable](evidencevariable.html): The description of the evidence variable
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [Library](library.html): The description of the library
* [Measure](measure.html): The description of the measure
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [PlanDefinition](plandefinition.html): The description of the plan definition
* [Questionnaire](questionnaire.html): The description of the questionnaire
* [Requirements](requirements.html): The description of the requirements
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [TestScript](testscript.html): The description of the test script
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The description of the activity definition\r\n* [ActorDefinition](actordefinition.html): The description of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The description of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition\r\n* [Citation](citation.html): The description of the citation\r\n* [CodeSystem](codesystem.html): The description of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition\r\n* [ConceptMap](conceptmap.html): The description of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The description of the condition definition\r\n* [EventDefinition](eventdefinition.html): The description of the event definition\r\n* [Evidence](evidence.html): The description of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The description of the evidence variable\r\n* [GraphDefinition](graphdefinition.html): The description of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The description of the implementation guide\r\n* [Library](library.html): The description of the library\r\n* [Measure](measure.html): The description of the measure\r\n* [MessageDefinition](messagedefinition.html): The description of the message definition\r\n* [NamingSystem](namingsystem.html): The description of the naming system\r\n* [OperationDefinition](operationdefinition.html): The description of the operation definition\r\n* [PlanDefinition](plandefinition.html): The description of the plan definition\r\n* [Questionnaire](questionnaire.html): The description of the questionnaire\r\n* [Requirements](requirements.html): The description of the requirements\r\n* [SearchParameter](searchparameter.html): The description of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The description of the structure definition\r\n* [StructureMap](structuremap.html): The description of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities\r\n* [TestScript](testscript.html): The description of the test script\r\n* [ValueSet](valueset.html): The description of the value set\r\n", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The description of the activity definition
* [ActorDefinition](actordefinition.html): The description of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition
* [Citation](citation.html): The description of the citation
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [ConditionDefinition](conditiondefinition.html): The description of the condition definition
* [EventDefinition](eventdefinition.html): The description of the event definition
* [Evidence](evidence.html): The description of the evidence
* [EvidenceVariable](evidencevariable.html): The description of the evidence variable
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [Library](library.html): The description of the library
* [Measure](measure.html): The description of the measure
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [PlanDefinition](plandefinition.html): The description of the plan definition
* [Questionnaire](questionnaire.html): The description of the questionnaire
* [Requirements](requirements.html): The description of the requirements
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [TestScript](testscript.html): The description of the test script
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition
* [Citation](citation.html): External identifier for the citation
* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition
* [EventDefinition](eventdefinition.html): External identifier for the event definition
* [Evidence](evidence.html): External identifier for the evidence
* [EvidenceReport](evidencereport.html): External identifier for the evidence report
* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable
* [ExampleScenario](examplescenario.html): External identifier for the example scenario
* [GraphDefinition](graphdefinition.html): External identifier for the graph definition
* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [OperationDefinition](operationdefinition.html): External identifier for the search parameter
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SearchParameter](searchparameter.html): External identifier for the search parameter
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestPlan](testplan.html): An identifier for the test plan
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition\r\n* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition\r\n* [Citation](citation.html): External identifier for the citation\r\n* [CodeSystem](codesystem.html): External identifier for the code system\r\n* [ConceptMap](conceptmap.html): External identifier for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition\r\n* [EventDefinition](eventdefinition.html): External identifier for the event definition\r\n* [Evidence](evidence.html): External identifier for the evidence\r\n* [EvidenceReport](evidencereport.html): External identifier for the evidence report\r\n* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable\r\n* [ExampleScenario](examplescenario.html): External identifier for the example scenario\r\n* [GraphDefinition](graphdefinition.html): External identifier for the graph definition\r\n* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide\r\n* [Library](library.html): External identifier for the library\r\n* [Measure](measure.html): External identifier for the measure\r\n* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication\r\n* [MessageDefinition](messagedefinition.html): External identifier for the message definition\r\n* [NamingSystem](namingsystem.html): External identifier for the naming system\r\n* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition\r\n* [OperationDefinition](operationdefinition.html): External identifier for the search parameter\r\n* [PlanDefinition](plandefinition.html): External identifier for the plan definition\r\n* [Questionnaire](questionnaire.html): External identifier for the questionnaire\r\n* [Requirements](requirements.html): External identifier for the requirements\r\n* [SearchParameter](searchparameter.html): External identifier for the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): External identifier for the structure definition\r\n* [StructureMap](structuremap.html): External identifier for the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities\r\n* [TestPlan](testplan.html): An identifier for the test plan\r\n* [TestScript](testscript.html): External identifier for the test script\r\n* [ValueSet](valueset.html): External identifier for the value set\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition
* [Citation](citation.html): External identifier for the citation
* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition
* [EventDefinition](eventdefinition.html): External identifier for the event definition
* [Evidence](evidence.html): External identifier for the evidence
* [EvidenceReport](evidencereport.html): External identifier for the evidence report
* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable
* [ExampleScenario](examplescenario.html): External identifier for the example scenario
* [GraphDefinition](graphdefinition.html): External identifier for the graph definition
* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [OperationDefinition](operationdefinition.html): External identifier for the search parameter
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SearchParameter](searchparameter.html): External identifier for the search parameter
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestPlan](testplan.html): An identifier for the test plan
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition
* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition
* [Citation](citation.html): Intended jurisdiction for the citation
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition
* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition
* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [Library](library.html): Intended jurisdiction for the library
* [Measure](measure.html): Intended jurisdiction for the measure
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition
* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire
* [Requirements](requirements.html): Intended jurisdiction for the requirements
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [TestScript](testscript.html): Intended jurisdiction for the test script
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name="jurisdiction", path="ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition\r\n* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition\r\n* [Citation](citation.html): Intended jurisdiction for the citation\r\n* [CodeSystem](codesystem.html): Intended jurisdiction for the code system\r\n* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition\r\n* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition\r\n* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario\r\n* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition\r\n* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide\r\n* [Library](library.html): Intended jurisdiction for the library\r\n* [Measure](measure.html): Intended jurisdiction for the measure\r\n* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition\r\n* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system\r\n* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition\r\n* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition\r\n* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire\r\n* [Requirements](requirements.html): Intended jurisdiction for the requirements\r\n* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter\r\n* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition\r\n* [StructureMap](structuremap.html): Intended jurisdiction for the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities\r\n* [TestScript](testscript.html): Intended jurisdiction for the test script\r\n* [ValueSet](valueset.html): Intended jurisdiction for the value set\r\n", type="token" )
  public static final String SP_JURISDICTION = "jurisdiction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition
* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition
* [Citation](citation.html): Intended jurisdiction for the citation
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition
* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition
* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [Library](library.html): Intended jurisdiction for the library
* [Measure](measure.html): Intended jurisdiction for the measure
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition
* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire
* [Requirements](requirements.html): Intended jurisdiction for the requirements
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [TestScript](testscript.html): Intended jurisdiction for the test script
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_JURISDICTION);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition
* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [Citation](citation.html): Computationally friendly name of the citation
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition
* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition
* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable
* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [Library](library.html): Computationally friendly name of the library
* [Measure](measure.html): Computationally friendly name of the measure
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition
* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire
* [Requirements](requirements.html): Computationally friendly name of the requirements
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [TestScript](testscript.html): Computationally friendly name of the test script
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition\r\n* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement\r\n* [Citation](citation.html): Computationally friendly name of the citation\r\n* [CodeSystem](codesystem.html): Computationally friendly name of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition\r\n* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition\r\n* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition\r\n* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable\r\n* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario\r\n* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide\r\n* [Library](library.html): Computationally friendly name of the library\r\n* [Measure](measure.html): Computationally friendly name of the measure\r\n* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition\r\n* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system\r\n* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition\r\n* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition\r\n* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire\r\n* [Requirements](requirements.html): Computationally friendly name of the requirements\r\n* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition\r\n* [StructureMap](structuremap.html): Computationally friendly name of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities\r\n* [TestScript](testscript.html): Computationally friendly name of the test script\r\n* [ValueSet](valueset.html): Computationally friendly name of the value set\r\n", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition
* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [Citation](citation.html): Computationally friendly name of the citation
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition
* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition
* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable
* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [Library](library.html): Computationally friendly name of the library
* [Measure](measure.html): Computationally friendly name of the measure
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition
* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire
* [Requirements](requirements.html): Computationally friendly name of the requirements
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [TestScript](testscript.html): Computationally friendly name of the test script
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition
* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition
* [Citation](citation.html): Name of the publisher of the citation
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition
* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition
* [Evidence](evidence.html): Name of the publisher of the evidence
* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report
* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable
* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [Library](library.html): Name of the publisher of the library
* [Measure](measure.html): Name of the publisher of the measure
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition
* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire
* [Requirements](requirements.html): Name of the publisher of the requirements
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [TestScript](testscript.html): Name of the publisher of the test script
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition\r\n* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition\r\n* [Citation](citation.html): Name of the publisher of the citation\r\n* [CodeSystem](codesystem.html): Name of the publisher of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition\r\n* [ConceptMap](conceptmap.html): Name of the publisher of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition\r\n* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition\r\n* [Evidence](evidence.html): Name of the publisher of the evidence\r\n* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable\r\n* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario\r\n* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide\r\n* [Library](library.html): Name of the publisher of the library\r\n* [Measure](measure.html): Name of the publisher of the measure\r\n* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition\r\n* [NamingSystem](namingsystem.html): Name of the publisher of the naming system\r\n* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition\r\n* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition\r\n* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire\r\n* [Requirements](requirements.html): Name of the publisher of the requirements\r\n* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition\r\n* [StructureMap](structuremap.html): Name of the publisher of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities\r\n* [TestScript](testscript.html): Name of the publisher of the test script\r\n* [ValueSet](valueset.html): Name of the publisher of the value set\r\n", type="string" )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition
* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition
* [Citation](citation.html): Name of the publisher of the citation
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition
* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition
* [Evidence](evidence.html): Name of the publisher of the evidence
* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report
* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable
* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [Library](library.html): Name of the publisher of the library
* [Measure](measure.html): Name of the publisher of the measure
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition
* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire
* [Requirements](requirements.html): Name of the publisher of the requirements
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [TestScript](testscript.html): Name of the publisher of the test script
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PUBLISHER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The current status of the activity definition
* [ActorDefinition](actordefinition.html): The current status of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition
* [Citation](citation.html): The current status of the citation
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition
* [EventDefinition](eventdefinition.html): The current status of the event definition
* [Evidence](evidence.html): The current status of the evidence
* [EvidenceReport](evidencereport.html): The current status of the evidence report
* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable
* [ExampleScenario](examplescenario.html): The current status of the example scenario
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [Library](library.html): The current status of the library
* [Measure](measure.html): The current status of the measure
* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [PlanDefinition](plandefinition.html): The current status of the plan definition
* [Questionnaire](questionnaire.html): The current status of the questionnaire
* [Requirements](requirements.html): The current status of the requirements
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [TestPlan](testplan.html): The current status of the test plan
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The current status of the activity definition\r\n* [ActorDefinition](actordefinition.html): The current status of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition\r\n* [Citation](citation.html): The current status of the citation\r\n* [CodeSystem](codesystem.html): The current status of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition\r\n* [ConceptMap](conceptmap.html): The current status of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition\r\n* [EventDefinition](eventdefinition.html): The current status of the event definition\r\n* [Evidence](evidence.html): The current status of the evidence\r\n* [EvidenceReport](evidencereport.html): The current status of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The current status of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The current status of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The current status of the implementation guide\r\n* [Library](library.html): The current status of the library\r\n* [Measure](measure.html): The current status of the measure\r\n* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error\r\n* [MessageDefinition](messagedefinition.html): The current status of the message definition\r\n* [NamingSystem](namingsystem.html): The current status of the naming system\r\n* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown\r\n* [OperationDefinition](operationdefinition.html): The current status of the operation definition\r\n* [PlanDefinition](plandefinition.html): The current status of the plan definition\r\n* [Questionnaire](questionnaire.html): The current status of the questionnaire\r\n* [Requirements](requirements.html): The current status of the requirements\r\n* [SearchParameter](searchparameter.html): The current status of the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown\r\n* [StructureDefinition](structuredefinition.html): The current status of the structure definition\r\n* [StructureMap](structuremap.html): The current status of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown\r\n* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities\r\n* [TestPlan](testplan.html): The current status of the test plan\r\n* [TestScript](testscript.html): The current status of the test script\r\n* [ValueSet](valueset.html): The current status of the value set\r\n", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The current status of the activity definition
* [ActorDefinition](actordefinition.html): The current status of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition
* [Citation](citation.html): The current status of the citation
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition
* [EventDefinition](eventdefinition.html): The current status of the event definition
* [Evidence](evidence.html): The current status of the evidence
* [EvidenceReport](evidencereport.html): The current status of the evidence report
* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable
* [ExampleScenario](examplescenario.html): The current status of the example scenario
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [Library](library.html): The current status of the library
* [Measure](measure.html): The current status of the measure
* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [PlanDefinition](plandefinition.html): The current status of the plan definition
* [Questionnaire](questionnaire.html): The current status of the questionnaire
* [Requirements](requirements.html): The current status of the requirements
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [TestPlan](testplan.html): The current status of the test plan
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition
* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition
* [Citation](citation.html): The uri that identifies the citation
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition
* [EventDefinition](eventdefinition.html): The uri that identifies the event definition
* [Evidence](evidence.html): The uri that identifies the evidence
* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report
* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable
* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [Library](library.html): The uri that identifies the library
* [Measure](measure.html): The uri that identifies the measure
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition
* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire
* [Requirements](requirements.html): The uri that identifies the requirements
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [TestPlan](testplan.html): The uri that identifies the test plan
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition\r\n* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition\r\n* [Citation](citation.html): The uri that identifies the citation\r\n* [CodeSystem](codesystem.html): The uri that identifies the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition\r\n* [ConceptMap](conceptmap.html): The URI that identifies the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition\r\n* [EventDefinition](eventdefinition.html): The uri that identifies the event definition\r\n* [Evidence](evidence.html): The uri that identifies the evidence\r\n* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable\r\n* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario\r\n* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition\r\n* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide\r\n* [Library](library.html): The uri that identifies the library\r\n* [Measure](measure.html): The uri that identifies the measure\r\n* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition\r\n* [NamingSystem](namingsystem.html): The uri that identifies the naming system\r\n* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition\r\n* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition\r\n* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition\r\n* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire\r\n* [Requirements](requirements.html): The uri that identifies the requirements\r\n* [SearchParameter](searchparameter.html): The uri that identifies the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition\r\n* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition\r\n* [StructureMap](structuremap.html): The uri that identifies the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities\r\n* [TestPlan](testplan.html): The uri that identifies the test plan\r\n* [TestScript](testscript.html): The uri that identifies the test script\r\n* [ValueSet](valueset.html): The uri that identifies the value set\r\n", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition
* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition
* [Citation](citation.html): The uri that identifies the citation
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition
* [EventDefinition](eventdefinition.html): The uri that identifies the event definition
* [Evidence](evidence.html): The uri that identifies the evidence
* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report
* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable
* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [Library](library.html): The uri that identifies the library
* [Measure](measure.html): The uri that identifies the measure
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition
* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire
* [Requirements](requirements.html): The uri that identifies the requirements
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [TestPlan](testplan.html): The uri that identifies the test plan
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The business version of the activity definition
* [ActorDefinition](actordefinition.html): The business version of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition
* [Citation](citation.html): The business version of the citation
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition
* [EventDefinition](eventdefinition.html): The business version of the event definition
* [Evidence](evidence.html): The business version of the evidence
* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable
* [ExampleScenario](examplescenario.html): The business version of the example scenario
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [Library](library.html): The business version of the library
* [Measure](measure.html): The business version of the measure
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [PlanDefinition](plandefinition.html): The business version of the plan definition
* [Questionnaire](questionnaire.html): The business version of the questionnaire
* [Requirements](requirements.html): The business version of the requirements
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [TestScript](testscript.html): The business version of the test script
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The business version of the activity definition\r\n* [ActorDefinition](actordefinition.html): The business version of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition\r\n* [Citation](citation.html): The business version of the citation\r\n* [CodeSystem](codesystem.html): The business version of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition\r\n* [ConceptMap](conceptmap.html): The business version of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition\r\n* [EventDefinition](eventdefinition.html): The business version of the event definition\r\n* [Evidence](evidence.html): The business version of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The business version of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The business version of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The business version of the implementation guide\r\n* [Library](library.html): The business version of the library\r\n* [Measure](measure.html): The business version of the measure\r\n* [MessageDefinition](messagedefinition.html): The business version of the message definition\r\n* [NamingSystem](namingsystem.html): The business version of the naming system\r\n* [OperationDefinition](operationdefinition.html): The business version of the operation definition\r\n* [PlanDefinition](plandefinition.html): The business version of the plan definition\r\n* [Questionnaire](questionnaire.html): The business version of the questionnaire\r\n* [Requirements](requirements.html): The business version of the requirements\r\n* [SearchParameter](searchparameter.html): The business version of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The business version of the structure definition\r\n* [StructureMap](structuremap.html): The business version of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities\r\n* [TestScript](testscript.html): The business version of the test script\r\n* [ValueSet](valueset.html): The business version of the value set\r\n", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The business version of the activity definition
* [ActorDefinition](actordefinition.html): The business version of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition
* [Citation](citation.html): The business version of the citation
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition
* [EventDefinition](eventdefinition.html): The business version of the event definition
* [Evidence](evidence.html): The business version of the evidence
* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable
* [ExampleScenario](examplescenario.html): The business version of the example scenario
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [Library](library.html): The business version of the library
* [Measure](measure.html): The business version of the measure
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [PlanDefinition](plandefinition.html): The business version of the plan definition
* [Questionnaire](questionnaire.html): The business version of the questionnaire
* [Requirements](requirements.html): The business version of the requirements
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [TestScript](testscript.html): The business version of the test script
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);

 /**
   * Search parameter: <b>derived-from</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): A resource that the CodeSystem is derived from
* [ConceptMap](conceptmap.html): A resource that the ConceptMap is derived from
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): A resource that the NamingSystem is derived from
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): A resource that the ValueSet is derived from
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='derived-from').resource | CodeSystem.relatedArtifact.where(type='derived-from').resource | ConceptMap.relatedArtifact.where(type='derived-from').resource | EventDefinition.relatedArtifact.where(type='derived-from').resource | EvidenceVariable.relatedArtifact.where(type='derived-from').resource | Library.relatedArtifact.where(type='derived-from').resource | Measure.relatedArtifact.where(type='derived-from').resource | NamingSystem.relatedArtifact.where(type='derived-from').resource | PlanDefinition.relatedArtifact.where(type='derived-from').resource | ValueSet.relatedArtifact.where(type='derived-from').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="derived-from", path="ActivityDefinition.relatedArtifact.where(type='derived-from').resource | CodeSystem.relatedArtifact.where(type='derived-from').resource | ConceptMap.relatedArtifact.where(type='derived-from').resource | EventDefinition.relatedArtifact.where(type='derived-from').resource | EvidenceVariable.relatedArtifact.where(type='derived-from').resource | Library.relatedArtifact.where(type='derived-from').resource | Measure.relatedArtifact.where(type='derived-from').resource | NamingSystem.relatedArtifact.where(type='derived-from').resource | PlanDefinition.relatedArtifact.where(type='derived-from').resource | ValueSet.relatedArtifact.where(type='derived-from').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [CodeSystem](codesystem.html): A resource that the CodeSystem is derived from\r\n* [ConceptMap](conceptmap.html): A resource that the ConceptMap is derived from\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [NamingSystem](namingsystem.html): A resource that the NamingSystem is derived from\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n* [ValueSet](valueset.html): A resource that the ValueSet is derived from\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_DERIVED_FROM = "derived-from";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>derived-from</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): A resource that the CodeSystem is derived from
* [ConceptMap](conceptmap.html): A resource that the ConceptMap is derived from
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): A resource that the NamingSystem is derived from
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): A resource that the ValueSet is derived from
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='derived-from').resource | CodeSystem.relatedArtifact.where(type='derived-from').resource | ConceptMap.relatedArtifact.where(type='derived-from').resource | EventDefinition.relatedArtifact.where(type='derived-from').resource | EvidenceVariable.relatedArtifact.where(type='derived-from').resource | Library.relatedArtifact.where(type='derived-from').resource | Measure.relatedArtifact.where(type='derived-from').resource | NamingSystem.relatedArtifact.where(type='derived-from').resource | PlanDefinition.relatedArtifact.where(type='derived-from').resource | ValueSet.relatedArtifact.where(type='derived-from').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DERIVED_FROM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DERIVED_FROM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>NamingSystem:derived-from</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DERIVED_FROM = new ca.uhn.fhir.model.api.Include("NamingSystem:derived-from").toLocked();

 /**
   * Search parameter: <b>effective</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use
* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use
* [Citation](citation.html): The time during which the citation is intended to be in use
* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use
* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use
* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use
* [Library](library.html): The time during which the library is intended to be in use
* [Measure](measure.html): The time during which the measure is intended to be in use
* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use
* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use
* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use
* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod</b><br>
   * </p>
   */
  @SearchParamDefinition(name="effective", path="ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use\r\n* [Citation](citation.html): The time during which the citation is intended to be in use\r\n* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use\r\n* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use\r\n* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use\r\n* [Library](library.html): The time during which the library is intended to be in use\r\n* [Measure](measure.html): The time during which the measure is intended to be in use\r\n* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use\r\n* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use\r\n* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use\r\n* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use\r\n", type="date" )
  public static final String SP_EFFECTIVE = "effective";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>effective</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use
* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use
* [Citation](citation.html): The time during which the citation is intended to be in use
* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use
* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use
* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use
* [Library](library.html): The time during which the library is intended to be in use
* [Measure](measure.html): The time during which the measure is intended to be in use
* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use
* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use
* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use
* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EFFECTIVE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_EFFECTIVE);

 /**
   * Search parameter: <b>predecessor</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): The predecessor of the CodeSystem
* [ConceptMap](conceptmap.html): The predecessor of the ConceptMap
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): The predecessor of the NamingSystem
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): The predecessor of the ValueSet
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='predecessor').resource | CodeSystem.relatedArtifact.where(type='predecessor').resource | ConceptMap.relatedArtifact.where(type='predecessor').resource | EventDefinition.relatedArtifact.where(type='predecessor').resource | EvidenceVariable.relatedArtifact.where(type='predecessor').resource | Library.relatedArtifact.where(type='predecessor').resource | Measure.relatedArtifact.where(type='predecessor').resource | NamingSystem.relatedArtifact.where(type='predecessor').resource | PlanDefinition.relatedArtifact.where(type='predecessor').resource | ValueSet.relatedArtifact.where(type='predecessor').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="predecessor", path="ActivityDefinition.relatedArtifact.where(type='predecessor').resource | CodeSystem.relatedArtifact.where(type='predecessor').resource | ConceptMap.relatedArtifact.where(type='predecessor').resource | EventDefinition.relatedArtifact.where(type='predecessor').resource | EvidenceVariable.relatedArtifact.where(type='predecessor').resource | Library.relatedArtifact.where(type='predecessor').resource | Measure.relatedArtifact.where(type='predecessor').resource | NamingSystem.relatedArtifact.where(type='predecessor').resource | PlanDefinition.relatedArtifact.where(type='predecessor').resource | ValueSet.relatedArtifact.where(type='predecessor').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [CodeSystem](codesystem.html): The predecessor of the CodeSystem\r\n* [ConceptMap](conceptmap.html): The predecessor of the ConceptMap\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [NamingSystem](namingsystem.html): The predecessor of the NamingSystem\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n* [ValueSet](valueset.html): The predecessor of the ValueSet\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_PREDECESSOR = "predecessor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>predecessor</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): The predecessor of the CodeSystem
* [ConceptMap](conceptmap.html): The predecessor of the ConceptMap
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): The predecessor of the NamingSystem
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): The predecessor of the ValueSet
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='predecessor').resource | CodeSystem.relatedArtifact.where(type='predecessor').resource | ConceptMap.relatedArtifact.where(type='predecessor').resource | EventDefinition.relatedArtifact.where(type='predecessor').resource | EvidenceVariable.relatedArtifact.where(type='predecessor').resource | Library.relatedArtifact.where(type='predecessor').resource | Measure.relatedArtifact.where(type='predecessor').resource | NamingSystem.relatedArtifact.where(type='predecessor').resource | PlanDefinition.relatedArtifact.where(type='predecessor').resource | ValueSet.relatedArtifact.where(type='predecessor').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PREDECESSOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PREDECESSOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>NamingSystem:predecessor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PREDECESSOR = new ca.uhn.fhir.model.api.Include("NamingSystem:predecessor").toLocked();

 /**
   * Search parameter: <b>topic</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Topics associated with the module
* [CodeSystem](codesystem.html): Topics associated with the CodeSystem
* [ConceptMap](conceptmap.html): Topics associated with the ConceptMap
* [EventDefinition](eventdefinition.html): Topics associated with the module
* [EvidenceVariable](evidencevariable.html): Topics associated with the EvidenceVariable
* [Library](library.html): Topics associated with the module
* [Measure](measure.html): Topics associated with the measure
* [NamingSystem](namingsystem.html): Topics associated with the NamingSystem
* [PlanDefinition](plandefinition.html): Topics associated with the module
* [ValueSet](valueset.html): Topics associated with the ValueSet
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.topic | CodeSystem.topic | ConceptMap.topic | EventDefinition.topic | Library.topic | Measure.topic | NamingSystem.topic | PlanDefinition.topic | ValueSet.topic</b><br>
   * </p>
   */
  @SearchParamDefinition(name="topic", path="ActivityDefinition.topic | CodeSystem.topic | ConceptMap.topic | EventDefinition.topic | Library.topic | Measure.topic | NamingSystem.topic | PlanDefinition.topic | ValueSet.topic", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Topics associated with the module\r\n* [CodeSystem](codesystem.html): Topics associated with the CodeSystem\r\n* [ConceptMap](conceptmap.html): Topics associated with the ConceptMap\r\n* [EventDefinition](eventdefinition.html): Topics associated with the module\r\n* [EvidenceVariable](evidencevariable.html): Topics associated with the EvidenceVariable\r\n* [Library](library.html): Topics associated with the module\r\n* [Measure](measure.html): Topics associated with the measure\r\n* [NamingSystem](namingsystem.html): Topics associated with the NamingSystem\r\n* [PlanDefinition](plandefinition.html): Topics associated with the module\r\n* [ValueSet](valueset.html): Topics associated with the ValueSet\r\n", type="token" )
  public static final String SP_TOPIC = "topic";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>topic</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Topics associated with the module
* [CodeSystem](codesystem.html): Topics associated with the CodeSystem
* [ConceptMap](conceptmap.html): Topics associated with the ConceptMap
* [EventDefinition](eventdefinition.html): Topics associated with the module
* [EvidenceVariable](evidencevariable.html): Topics associated with the EvidenceVariable
* [Library](library.html): Topics associated with the module
* [Measure](measure.html): Topics associated with the measure
* [NamingSystem](namingsystem.html): Topics associated with the NamingSystem
* [PlanDefinition](plandefinition.html): Topics associated with the module
* [ValueSet](valueset.html): Topics associated with the ValueSet
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.topic | CodeSystem.topic | ConceptMap.topic | EventDefinition.topic | Library.topic | Measure.topic | NamingSystem.topic | PlanDefinition.topic | ValueSet.topic</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TOPIC = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TOPIC);

 /**
   * Search parameter: <b>contact</b>
   * <p>
   * Description: <b>Name of an individual to contact</b><br>
   * Type: <b>string</b><br>
   * Path: <b>NamingSystem.contact.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="contact", path="NamingSystem.contact.name", description="Name of an individual to contact", type="string" )
  public static final String SP_CONTACT = "contact";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>contact</b>
   * <p>
   * Description: <b>Name of an individual to contact</b><br>
   * Type: <b>string</b><br>
   * Path: <b>NamingSystem.contact.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam CONTACT = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_CONTACT);

 /**
   * Search parameter: <b>id-type</b>
   * <p>
   * Description: <b>oid | uuid | uri | other</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NamingSystem.uniqueId.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="id-type", path="NamingSystem.uniqueId.type", description="oid | uuid | uri | other", type="token" )
  public static final String SP_ID_TYPE = "id-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>id-type</b>
   * <p>
   * Description: <b>oid | uuid | uri | other</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NamingSystem.uniqueId.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ID_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ID_TYPE);

 /**
   * Search parameter: <b>kind</b>
   * <p>
   * Description: <b>codesystem | identifier | root</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NamingSystem.kind</b><br>
   * </p>
   */
  @SearchParamDefinition(name="kind", path="NamingSystem.kind", description="codesystem | identifier | root", type="token" )
  public static final String SP_KIND = "kind";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>kind</b>
   * <p>
   * Description: <b>codesystem | identifier | root</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NamingSystem.kind</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam KIND = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_KIND);

 /**
   * Search parameter: <b>period</b>
   * <p>
   * Description: <b>When is identifier valid?</b><br>
   * Type: <b>date</b><br>
   * Path: <b>NamingSystem.uniqueId.period</b><br>
   * </p>
   */
  @SearchParamDefinition(name="period", path="NamingSystem.uniqueId.period", description="When is identifier valid?", type="date" )
  public static final String SP_PERIOD = "period";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>period</b>
   * <p>
   * Description: <b>When is identifier valid?</b><br>
   * Type: <b>date</b><br>
   * Path: <b>NamingSystem.uniqueId.period</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam PERIOD = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_PERIOD);

 /**
   * Search parameter: <b>responsible</b>
   * <p>
   * Description: <b>Who maintains system namespace?</b><br>
   * Type: <b>string</b><br>
   * Path: <b>NamingSystem.responsible</b><br>
   * </p>
   */
  @SearchParamDefinition(name="responsible", path="NamingSystem.responsible", description="Who maintains system namespace?", type="string" )
  public static final String SP_RESPONSIBLE = "responsible";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>responsible</b>
   * <p>
   * Description: <b>Who maintains system namespace?</b><br>
   * Type: <b>string</b><br>
   * Path: <b>NamingSystem.responsible</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam RESPONSIBLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_RESPONSIBLE);

 /**
   * Search parameter: <b>telecom</b>
   * <p>
   * Description: <b>Contact details for individual or organization</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NamingSystem.contact.telecom</b><br>
   * </p>
   */
  @SearchParamDefinition(name="telecom", path="NamingSystem.contact.telecom", description="Contact details for individual or organization", type="token" )
  public static final String SP_TELECOM = "telecom";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>telecom</b>
   * <p>
   * Description: <b>Contact details for individual or organization</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NamingSystem.contact.telecom</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TELECOM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TELECOM);

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>e.g. driver,  provider,  patient, bank etc.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NamingSystem.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="NamingSystem.type", description="e.g. driver,  provider,  patient, bank etc.", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>e.g. driver,  provider,  patient, bank etc.</b><br>
   * Type: <b>token</b><br>
   * Path: <b>NamingSystem.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);

 /**
   * Search parameter: <b>value</b>
   * <p>
   * Description: <b>The unique identifier</b><br>
   * Type: <b>string</b><br>
   * Path: <b>NamingSystem.uniqueId.value</b><br>
   * </p>
   */
  @SearchParamDefinition(name="value", path="NamingSystem.uniqueId.value", description="The unique identifier", type="string" )
  public static final String SP_VALUE = "value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>value</b>
   * <p>
   * Description: <b>The unique identifier</b><br>
   * Type: <b>string</b><br>
   * Path: <b>NamingSystem.uniqueId.value</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam VALUE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_VALUE);

// Manual code (from Configuration.txt):
  public boolean supportsCopyright() {
    return true;
  }

// end addition

}

