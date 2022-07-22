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

// Generated on Fri, Jul 15, 2022 11:20+1000 for FHIR v5.0.0-snapshot2

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
        if ("v2csmnemonic".equals(codeString))
          return NamingSystemIdentifierType.V2CSMNEMONIC;
        if ("other".equals(codeString))
          return NamingSystemIdentifierType.OTHER;
        throw new IllegalArgumentException("Unknown NamingSystemIdentifierType code '"+codeString+"'");
        }
        public Enumeration<NamingSystemIdentifierType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<NamingSystemIdentifierType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("oid".equals(codeString))
          return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.OID);
        if ("uuid".equals(codeString))
          return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.UUID);
        if ("uri".equals(codeString))
          return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.URI);
        if ("v2csmnemonic".equals(codeString))
          return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.V2CSMNEMONIC);
        if ("other".equals(codeString))
          return new Enumeration<NamingSystemIdentifierType>(this, NamingSystemIdentifierType.OTHER);
        throw new FHIRException("Unknown NamingSystemIdentifierType code '"+codeString+"'");
        }
    public String toCode(NamingSystemIdentifierType code) {
      if (code == NamingSystemIdentifierType.OID)
        return "oid";
      if (code == NamingSystemIdentifierType.UUID)
        return "uuid";
      if (code == NamingSystemIdentifierType.URI)
        return "uri";
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
        public Enumeration<NamingSystemType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<NamingSystemType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("codesystem".equals(codeString))
          return new Enumeration<NamingSystemType>(this, NamingSystemType.CODESYSTEM);
        if ("identifier".equals(codeString))
          return new Enumeration<NamingSystemType>(this, NamingSystemType.IDENTIFIER);
        if ("root".equals(codeString))
          return new Enumeration<NamingSystemType>(this, NamingSystemType.ROOT);
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
        @Description(shortDefinition="oid | uuid | uri | v2csmnemonic | other", formalDefinition="Identifies the unique identifier scheme used for this particular identifier." )
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
     * An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this naming system, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers." )
    protected UriType url;

    /**
     * The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the naming system", formalDefinition="The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this naming system (computer friendly)", formalDefinition="A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the naming system.
     */
    @Child(name = "title", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Title for this naming system (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the naming system." )
    protected StringType title;

    /**
     * The status of this naming system. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=4, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this naming system. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * Indicates the purpose for the naming system - what kinds of things does it make unique?
     */
    @Child(name = "kind", type = {CodeType.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="codesystem | identifier | root", formalDefinition="Indicates the purpose for the naming system - what kinds of things does it make unique?" )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/namingsystem-type")
    protected Enumeration<NamingSystemType> kind;

    /**
     * The date  (and optionally time) when the naming system was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the naming system was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual that published the naming system.
     */
    @Child(name = "publisher", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher (organization or individual)", formalDefinition="The name of the organization or individual that published the naming system." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision.
     */
    @Child(name = "responsible", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Who maintains system namespace?", formalDefinition="The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision." )
    protected StringType responsible;

    /**
     * Categorizes a naming system for easier search by grouping related naming systems.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="e.g. driver,  provider,  patient, bank etc.", formalDefinition="Categorizes a naming system for easier search by grouping related naming systems." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/identifier-type")
    protected CodeableConcept type;

    /**
     * A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the naming system", formalDefinition="A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate naming system instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate naming system instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the naming system is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for naming system (if applicable)", formalDefinition="A legal or geographic region in which the naming system is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc.
     */
    @Child(name = "usage", type = {StringType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="How/where is it used", formalDefinition="Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc." )
    protected StringType usage;

    /**
     * Indicates how the system may be identified when referenced in electronic exchange.
     */
    @Child(name = "uniqueId", type = {}, order=15, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique identifiers used for system", formalDefinition="Indicates how the system may be identified when referenced in electronic exchange." )
    protected List<NamingSystemUniqueIdComponent> uniqueId;

    private static final long serialVersionUID = 329180848L;

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
     * @return {@link #url} (An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
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
     * @param value {@link #url} (An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public NamingSystem setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.
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
     * @return {@link #date} (The date  (and optionally time) when the naming system was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
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
     * @param value {@link #date} (The date  (and optionally time) when the naming system was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public NamingSystem setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the naming system was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the naming system was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.
     */
    public NamingSystem setDate(Date value) { 
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      return this;
    }

    /**
     * @return {@link #publisher} (The name of the organization or individual that published the naming system.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
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
     * @param value {@link #publisher} (The name of the organization or individual that published the naming system.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public NamingSystem setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual that published the naming system.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual that published the naming system.
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

    /**
     * not supported on this implementation
     */
    @Override
    public int getIdentifierMax() { 
      return 0;
    }
    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this naming system when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setIdentifier(List<Identifier> theIdentifier) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"identifier\"");
    }
    public boolean hasIdentifier() { 
      return false;
    }

    public Identifier addIdentifier() { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"identifier\"");
    }
    public NamingSystem addIdentifier(Identifier t) { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"identifier\"");
    }
    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {2}
     */
    public Identifier getIdentifierFirstRep() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"identifier\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getExperimentalMax() { 
      return 0;
    }
    /**
     * @return {@link #experimental} (A Boolean value to indicate that this naming system is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"experimental\"");
    }

    public boolean hasExperimentalElement() { 
      return false;
    }
    public boolean hasExperimental() {
      return false;
    }

    /**
     * @param value {@link #experimental} (A Boolean value to indicate that this naming system is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public NamingSystem setExperimentalElement(BooleanType value) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"experimental\"");
    }
    public boolean getExperimental() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"experimental\"");
    }
    /**
     * @param value A Boolean value to indicate that this naming system is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public NamingSystem setExperimental(boolean value) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"experimental\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getPurposeMax() { 
      return 0;
    }
    /**
     * @return {@link #purpose} (Explanation of why this naming system is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"purpose\"");
    }

    public boolean hasPurposeElement() { 
      return false;
    }
    public boolean hasPurpose() {
      return false;
    }

    /**
     * @param value {@link #purpose} (Explanation of why this naming system is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public NamingSystem setPurposeElement(MarkdownType value) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"purpose\"");
    }
    public String getPurpose() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"purpose\"");
    }
    /**
     * @param value Explanation of why this naming system is needed and why it has been designed as it has.
     */
    public NamingSystem setPurpose(String value) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"purpose\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getCopyrightMax() { 
      return 0;
    }
    /**
     * @return {@link #copyright} (A copyright statement relating to the naming system and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the naming system.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"copyright\"");
    }

    public boolean hasCopyrightElement() { 
      return false;
    }
    public boolean hasCopyright() {
      return false;
    }

    /**
     * @param value {@link #copyright} (A copyright statement relating to the naming system and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the naming system.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public NamingSystem setCopyrightElement(MarkdownType value) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"copyright\"");
    }
    public String getCopyright() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"copyright\"");
    }
    /**
     * @param value A copyright statement relating to the naming system and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the naming system.
     */
    public NamingSystem setCopyright(String value) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"copyright\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getApprovalDateMax() { 
      return 0;
    }
    /**
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"approvalDate\"");
    }

    public boolean hasApprovalDateElement() { 
      return false;
    }
    public boolean hasApprovalDate() {
      return false;
    }

    /**
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public NamingSystem setApprovalDateElement(DateType value) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"approvalDate\"");
    }
    public Date getApprovalDate() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"approvalDate\"");
    }
    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public NamingSystem setApprovalDate(Date value) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"approvalDate\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getLastReviewDateMax() { 
      return 0;
    }
    /**
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"lastReviewDate\"");
    }

    public boolean hasLastReviewDateElement() { 
      return false;
    }
    public boolean hasLastReviewDate() {
      return false;
    }

    /**
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public NamingSystem setLastReviewDateElement(DateType value) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"lastReviewDate\"");
    }
    public Date getLastReviewDate() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"lastReviewDate\"");
    }
    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public NamingSystem setLastReviewDate(Date value) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"lastReviewDate\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getEffectivePeriodMax() { 
      return 0;
    }
    /**
     * @return {@link #effectivePeriod} (The period during which the naming system content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"effectivePeriod\"");
    }
    public boolean hasEffectivePeriod() { 
      return false;
    }
    /**
     * @param value {@link #effectivePeriod} (The period during which the naming system content was or is planned to be in active use.)
     */
    public NamingSystem setEffectivePeriod(Period value) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"effectivePeriod\"");
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getTopicMax() { 
      return 0;
    }
    /**
     * @return {@link #topic} (Descriptive topics related to the content of the naming system. Topics provide a high-level categorization of the naming system that can be useful for filtering and searching.)
     */
    public List<CodeableConcept> getTopic() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setTopic(List<CodeableConcept> theTopic) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"topic\"");
    }
    public boolean hasTopic() { 
      return false;
    }

    public CodeableConcept addTopic() { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"topic\"");
    }
    public NamingSystem addTopic(CodeableConcept t) { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"topic\"");
    }
    /**
     * @return The first repetition of repeating field {@link #topic}, creating it if it does not already exist {2}
     */
    public CodeableConcept getTopicFirstRep() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"topic\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getAuthorMax() { 
      return 0;
    }
    /**
     * @return {@link #author} (An individiual or organization primarily involved in the creation and maintenance of the naming system.)
     */
    public List<ContactDetail> getAuthor() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setAuthor(List<ContactDetail> theAuthor) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"author\"");
    }
    public boolean hasAuthor() { 
      return false;
    }

    public ContactDetail addAuthor() { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"author\"");
    }
    public NamingSystem addAuthor(ContactDetail t) { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"author\"");
    }
    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist {2}
     */
    public ContactDetail getAuthorFirstRep() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"author\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getEditorMax() { 
      return 0;
    }
    /**
     * @return {@link #editor} (An individual or organization primarily responsible for internal coherence of the naming system.)
     */
    public List<ContactDetail> getEditor() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setEditor(List<ContactDetail> theEditor) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"editor\"");
    }
    public boolean hasEditor() { 
      return false;
    }

    public ContactDetail addEditor() { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"editor\"");
    }
    public NamingSystem addEditor(ContactDetail t) { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"editor\"");
    }
    /**
     * @return The first repetition of repeating field {@link #editor}, creating it if it does not already exist {2}
     */
    public ContactDetail getEditorFirstRep() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"editor\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getReviewerMax() { 
      return 0;
    }
    /**
     * @return {@link #reviewer} (An individual or organization primarily responsible for review of some aspect of the naming system.)
     */
    public List<ContactDetail> getReviewer() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setReviewer(List<ContactDetail> theReviewer) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"reviewer\"");
    }
    public boolean hasReviewer() { 
      return false;
    }

    public ContactDetail addReviewer() { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"reviewer\"");
    }
    public NamingSystem addReviewer(ContactDetail t) { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"reviewer\"");
    }
    /**
     * @return The first repetition of repeating field {@link #reviewer}, creating it if it does not already exist {2}
     */
    public ContactDetail getReviewerFirstRep() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"reviewer\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getEndorserMax() { 
      return 0;
    }
    /**
     * @return {@link #endorser} (An individual or organization responsible for officially endorsing the naming system for use in some setting.)
     */
    public List<ContactDetail> getEndorser() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setEndorser(List<ContactDetail> theEndorser) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"endorser\"");
    }
    public boolean hasEndorser() { 
      return false;
    }

    public ContactDetail addEndorser() { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"endorser\"");
    }
    public NamingSystem addEndorser(ContactDetail t) { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"endorser\"");
    }
    /**
     * @return The first repetition of repeating field {@link #endorser}, creating it if it does not already exist {2}
     */
    public ContactDetail getEndorserFirstRep() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"endorser\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getRelatedArtifactMax() { 
      return 0;
    }
    /**
     * @return {@link #relatedArtifact} (Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public NamingSystem setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"relatedArtifact\"");
    }
    public boolean hasRelatedArtifact() { 
      return false;
    }

    public RelatedArtifact addRelatedArtifact() { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"relatedArtifact\"");
    }
    public NamingSystem addRelatedArtifact(RelatedArtifact t) { //3
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"relatedArtifact\"");
    }
    /**
     * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {2}
     */
    public RelatedArtifact getRelatedArtifactFirstRep() { 
      throw new Error("The resource type \"NamingSystem\" does not implement the property \"relatedArtifact\"");
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.", 0, 1, url));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the naming system.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this naming system. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("kind", "code", "Indicates the purpose for the naming system - what kinds of things does it make unique?", 0, 1, kind));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the naming system was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual that published the naming system.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("responsible", "string", "The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision.", 0, 1, responsible));
        children.add(new Property("type", "CodeableConcept", "Categorizes a naming system for easier search by grouping related naming systems.", 0, 1, type));
        children.add(new Property("description", "markdown", "A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate naming system instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the naming system is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("usage", "string", "Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc.", 0, 1, usage));
        children.add(new Property("uniqueId", "", "Indicates how the system may be identified when referenced in electronic exchange.", 0, java.lang.Integer.MAX_VALUE, uniqueId));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this naming system when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this naming system is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the naming system is stored on different servers.", 0, 1, url);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the naming system when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the naming system author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the naming system. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the naming system.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this naming system. Enables tracking the life-cycle of the content.", 0, 1, status);
        case 3292052: /*kind*/  return new Property("kind", "code", "Indicates the purpose for the naming system - what kinds of things does it make unique?", 0, 1, kind);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the naming system was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the naming system changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual that published the naming system.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case 1847674614: /*responsible*/  return new Property("responsible", "string", "The name of the organization that is responsible for issuing identifiers or codes for this namespace and ensuring their non-collision.", 0, 1, responsible);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Categorizes a naming system for easier search by grouping related naming systems.", 0, 1, type);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the naming system from a consumer's perspective. Details about what the namespace identifies including scope, granularity, version labeling, etc.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate naming system instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the naming system is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case 111574433: /*usage*/  return new Property("usage", "string", "Provides guidance on the use of the namespace, including the handling of formatting characters, use of upper vs. lower case, etc.", 0, 1, usage);
        case -294460212: /*uniqueId*/  return new Property("uniqueId", "", "Indicates how the system may be identified when referenced in electronic exchange.", 0, java.lang.Integer.MAX_VALUE, uniqueId);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case 3292052: /*kind*/ return this.kind == null ? new Base[0] : new Base[] {this.kind}; // Enumeration<NamingSystemType>
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case 1847674614: /*responsible*/ return this.responsible == null ? new Base[0] : new Base[] {this.responsible}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
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
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
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
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
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
        case 351608024:  return getVersionElement();
        case 3373707:  return getNameElement();
        case 110371416:  return getTitleElement();
        case -892481550:  return getStatusElement();
        case 3292052:  return getKindElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case 1847674614:  return getResponsibleElement();
        case 3575610:  return getType();
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case 111574433:  return getUsageElement();
        case -294460212:  return addUniqueId(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 3292052: /*kind*/ return new String[] {"code"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case 1847674614: /*responsible*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
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
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type NamingSystem.version");
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
        dst.version = version == null ? null : version.copy();
        dst.name = name == null ? null : name.copy();
        dst.title = title == null ? null : title.copy();
        dst.status = status == null ? null : status.copy();
        dst.kind = kind == null ? null : kind.copy();
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
        return compareDeep(url, o.url, true) && compareDeep(version, o.version, true) && compareDeep(name, o.name, true)
           && compareDeep(title, o.title, true) && compareDeep(status, o.status, true) && compareDeep(kind, o.kind, true)
           && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true)
           && compareDeep(responsible, o.responsible, true) && compareDeep(type, o.type, true) && compareDeep(description, o.description, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(usage, o.usage, true) && compareDeep(uniqueId, o.uniqueId, true);
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
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(responsible, o.responsible, true)
           && compareValues(description, o.description, true) && compareValues(usage, o.usage, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, version, name, title
          , status, kind, date, publisher, contact, responsible, type, description, useContext
          , jurisdiction, usage, uniqueId);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.NamingSystem;
   }

// Manual code (from Configuration.txt):
  public boolean supportsCopyright() {
    return false;
  }

// end addition

}

