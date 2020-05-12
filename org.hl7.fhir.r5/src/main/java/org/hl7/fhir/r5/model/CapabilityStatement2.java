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

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent

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
 * A Capability Statement documents a set of capabilities (behaviors) of a FHIR Server for a particular version of FHIR that may be used as a statement of actual server functionality or a statement of required or desired server implementation.
 */
@ResourceDef(name="CapabilityStatement2", profile="http://hl7.org/fhir/StructureDefinition/CapabilityStatement2")
public class CapabilityStatement2 extends CanonicalResource {

    public enum SystemRestfulInteraction {
        /**
         * Update, create or delete a set of resources as a single transaction.
         */
        TRANSACTION, 
        /**
         * perform a set of a separate interactions in a single http operation
         */
        BATCH, 
        /**
         * Search all resources based on some filter criteria.
         */
        SEARCHSYSTEM, 
        /**
         * Retrieve the change history for all resources on a system.
         */
        HISTORYSYSTEM, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SystemRestfulInteraction fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("transaction".equals(codeString))
          return TRANSACTION;
        if ("batch".equals(codeString))
          return BATCH;
        if ("search-system".equals(codeString))
          return SEARCHSYSTEM;
        if ("history-system".equals(codeString))
          return HISTORYSYSTEM;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SystemRestfulInteraction code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case TRANSACTION: return "transaction";
            case BATCH: return "batch";
            case SEARCHSYSTEM: return "search-system";
            case HISTORYSYSTEM: return "history-system";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case TRANSACTION: return "http://hl7.org/fhir/restful-interaction";
            case BATCH: return "http://hl7.org/fhir/restful-interaction";
            case SEARCHSYSTEM: return "http://hl7.org/fhir/restful-interaction";
            case HISTORYSYSTEM: return "http://hl7.org/fhir/restful-interaction";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case TRANSACTION: return "Update, create or delete a set of resources as a single transaction.";
            case BATCH: return "perform a set of a separate interactions in a single http operation";
            case SEARCHSYSTEM: return "Search all resources based on some filter criteria.";
            case HISTORYSYSTEM: return "Retrieve the change history for all resources on a system.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case TRANSACTION: return "transaction";
            case BATCH: return "batch";
            case SEARCHSYSTEM: return "search-system";
            case HISTORYSYSTEM: return "history-system";
            default: return "?";
          }
        }
    }

  public static class SystemRestfulInteractionEnumFactory implements EnumFactory<SystemRestfulInteraction> {
    public SystemRestfulInteraction fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("transaction".equals(codeString))
          return SystemRestfulInteraction.TRANSACTION;
        if ("batch".equals(codeString))
          return SystemRestfulInteraction.BATCH;
        if ("search-system".equals(codeString))
          return SystemRestfulInteraction.SEARCHSYSTEM;
        if ("history-system".equals(codeString))
          return SystemRestfulInteraction.HISTORYSYSTEM;
        throw new IllegalArgumentException("Unknown SystemRestfulInteraction code '"+codeString+"'");
        }
        public Enumeration<SystemRestfulInteraction> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SystemRestfulInteraction>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("transaction".equals(codeString))
          return new Enumeration<SystemRestfulInteraction>(this, SystemRestfulInteraction.TRANSACTION);
        if ("batch".equals(codeString))
          return new Enumeration<SystemRestfulInteraction>(this, SystemRestfulInteraction.BATCH);
        if ("search-system".equals(codeString))
          return new Enumeration<SystemRestfulInteraction>(this, SystemRestfulInteraction.SEARCHSYSTEM);
        if ("history-system".equals(codeString))
          return new Enumeration<SystemRestfulInteraction>(this, SystemRestfulInteraction.HISTORYSYSTEM);
        throw new FHIRException("Unknown SystemRestfulInteraction code '"+codeString+"'");
        }
    public String toCode(SystemRestfulInteraction code) {
      if (code == SystemRestfulInteraction.TRANSACTION)
        return "transaction";
      if (code == SystemRestfulInteraction.BATCH)
        return "batch";
      if (code == SystemRestfulInteraction.SEARCHSYSTEM)
        return "search-system";
      if (code == SystemRestfulInteraction.HISTORYSYSTEM)
        return "history-system";
      return "?";
      }
    public String toSystem(SystemRestfulInteraction code) {
      return code.getSystem();
      }
    }

    public enum TypeRestfulInteraction {
        /**
         * Read the current state of the resource.
         */
        READ, 
        /**
         * Read the state of a specific version of the resource.
         */
        VREAD, 
        /**
         * Update an existing resource by its id (or create it if it is new).
         */
        UPDATE, 
        /**
         * Update an existing resource by posting a set of changes to it.
         */
        PATCH, 
        /**
         * Delete a resource.
         */
        DELETE, 
        /**
         * Retrieve the change history for a particular resource.
         */
        HISTORYINSTANCE, 
        /**
         * Retrieve the change history for all resources of a particular type.
         */
        HISTORYTYPE, 
        /**
         * Create a new resource with a server assigned id.
         */
        CREATE, 
        /**
         * Search all resources of the specified type based on some filter criteria.
         */
        SEARCHTYPE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static TypeRestfulInteraction fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("read".equals(codeString))
          return READ;
        if ("vread".equals(codeString))
          return VREAD;
        if ("update".equals(codeString))
          return UPDATE;
        if ("patch".equals(codeString))
          return PATCH;
        if ("delete".equals(codeString))
          return DELETE;
        if ("history-instance".equals(codeString))
          return HISTORYINSTANCE;
        if ("history-type".equals(codeString))
          return HISTORYTYPE;
        if ("create".equals(codeString))
          return CREATE;
        if ("search-type".equals(codeString))
          return SEARCHTYPE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown TypeRestfulInteraction code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case READ: return "read";
            case VREAD: return "vread";
            case UPDATE: return "update";
            case PATCH: return "patch";
            case DELETE: return "delete";
            case HISTORYINSTANCE: return "history-instance";
            case HISTORYTYPE: return "history-type";
            case CREATE: return "create";
            case SEARCHTYPE: return "search-type";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case READ: return "http://hl7.org/fhir/restful-interaction";
            case VREAD: return "http://hl7.org/fhir/restful-interaction";
            case UPDATE: return "http://hl7.org/fhir/restful-interaction";
            case PATCH: return "http://hl7.org/fhir/restful-interaction";
            case DELETE: return "http://hl7.org/fhir/restful-interaction";
            case HISTORYINSTANCE: return "http://hl7.org/fhir/restful-interaction";
            case HISTORYTYPE: return "http://hl7.org/fhir/restful-interaction";
            case CREATE: return "http://hl7.org/fhir/restful-interaction";
            case SEARCHTYPE: return "http://hl7.org/fhir/restful-interaction";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case READ: return "Read the current state of the resource.";
            case VREAD: return "Read the state of a specific version of the resource.";
            case UPDATE: return "Update an existing resource by its id (or create it if it is new).";
            case PATCH: return "Update an existing resource by posting a set of changes to it.";
            case DELETE: return "Delete a resource.";
            case HISTORYINSTANCE: return "Retrieve the change history for a particular resource.";
            case HISTORYTYPE: return "Retrieve the change history for all resources of a particular type.";
            case CREATE: return "Create a new resource with a server assigned id.";
            case SEARCHTYPE: return "Search all resources of the specified type based on some filter criteria.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case READ: return "read";
            case VREAD: return "vread";
            case UPDATE: return "update";
            case PATCH: return "patch";
            case DELETE: return "delete";
            case HISTORYINSTANCE: return "history-instance";
            case HISTORYTYPE: return "history-type";
            case CREATE: return "create";
            case SEARCHTYPE: return "search-type";
            default: return "?";
          }
        }
    }

  public static class TypeRestfulInteractionEnumFactory implements EnumFactory<TypeRestfulInteraction> {
    public TypeRestfulInteraction fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("read".equals(codeString))
          return TypeRestfulInteraction.READ;
        if ("vread".equals(codeString))
          return TypeRestfulInteraction.VREAD;
        if ("update".equals(codeString))
          return TypeRestfulInteraction.UPDATE;
        if ("patch".equals(codeString))
          return TypeRestfulInteraction.PATCH;
        if ("delete".equals(codeString))
          return TypeRestfulInteraction.DELETE;
        if ("history-instance".equals(codeString))
          return TypeRestfulInteraction.HISTORYINSTANCE;
        if ("history-type".equals(codeString))
          return TypeRestfulInteraction.HISTORYTYPE;
        if ("create".equals(codeString))
          return TypeRestfulInteraction.CREATE;
        if ("search-type".equals(codeString))
          return TypeRestfulInteraction.SEARCHTYPE;
        throw new IllegalArgumentException("Unknown TypeRestfulInteraction code '"+codeString+"'");
        }
        public Enumeration<TypeRestfulInteraction> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<TypeRestfulInteraction>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("read".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.READ);
        if ("vread".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.VREAD);
        if ("update".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.UPDATE);
        if ("patch".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.PATCH);
        if ("delete".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.DELETE);
        if ("history-instance".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.HISTORYINSTANCE);
        if ("history-type".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.HISTORYTYPE);
        if ("create".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.CREATE);
        if ("search-type".equals(codeString))
          return new Enumeration<TypeRestfulInteraction>(this, TypeRestfulInteraction.SEARCHTYPE);
        throw new FHIRException("Unknown TypeRestfulInteraction code '"+codeString+"'");
        }
    public String toCode(TypeRestfulInteraction code) {
      if (code == TypeRestfulInteraction.READ)
        return "read";
      if (code == TypeRestfulInteraction.VREAD)
        return "vread";
      if (code == TypeRestfulInteraction.UPDATE)
        return "update";
      if (code == TypeRestfulInteraction.PATCH)
        return "patch";
      if (code == TypeRestfulInteraction.DELETE)
        return "delete";
      if (code == TypeRestfulInteraction.HISTORYINSTANCE)
        return "history-instance";
      if (code == TypeRestfulInteraction.HISTORYTYPE)
        return "history-type";
      if (code == TypeRestfulInteraction.CREATE)
        return "create";
      if (code == TypeRestfulInteraction.SEARCHTYPE)
        return "search-type";
      return "?";
      }
    public String toSystem(TypeRestfulInteraction code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class CapabilityStatement2SoftwareComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Name the software is known by.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A name the software is known by", formalDefinition="Name the software is known by." )
        protected StringType name;

        /**
         * The version identifier for the software covered by this statement.
         */
        @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Version covered by this statement", formalDefinition="The version identifier for the software covered by this statement." )
        protected StringType version;

        /**
         * Date this version of the software was released.
         */
        @Child(name = "releaseDate", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Date this version was released", formalDefinition="Date this version of the software was released." )
        protected DateTimeType releaseDate;

        private static final long serialVersionUID = 1819769027L;

    /**
     * Constructor
     */
      public CapabilityStatement2SoftwareComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatement2SoftwareComponent(String name) {
        super();
        this.setName(name);
      }

        /**
         * @return {@link #name} (Name the software is known by.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2SoftwareComponent.name");
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
         * @param value {@link #name} (Name the software is known by.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public CapabilityStatement2SoftwareComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name the software is known by.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name the software is known by.
         */
        public CapabilityStatement2SoftwareComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #version} (The version identifier for the software covered by this statement.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
         */
        public StringType getVersionElement() { 
          if (this.version == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2SoftwareComponent.version");
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
         * @param value {@link #version} (The version identifier for the software covered by this statement.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
         */
        public CapabilityStatement2SoftwareComponent setVersionElement(StringType value) { 
          this.version = value;
          return this;
        }

        /**
         * @return The version identifier for the software covered by this statement.
         */
        public String getVersion() { 
          return this.version == null ? null : this.version.getValue();
        }

        /**
         * @param value The version identifier for the software covered by this statement.
         */
        public CapabilityStatement2SoftwareComponent setVersion(String value) { 
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
         * @return {@link #releaseDate} (Date this version of the software was released.). This is the underlying object with id, value and extensions. The accessor "getReleaseDate" gives direct access to the value
         */
        public DateTimeType getReleaseDateElement() { 
          if (this.releaseDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2SoftwareComponent.releaseDate");
            else if (Configuration.doAutoCreate())
              this.releaseDate = new DateTimeType(); // bb
          return this.releaseDate;
        }

        public boolean hasReleaseDateElement() { 
          return this.releaseDate != null && !this.releaseDate.isEmpty();
        }

        public boolean hasReleaseDate() { 
          return this.releaseDate != null && !this.releaseDate.isEmpty();
        }

        /**
         * @param value {@link #releaseDate} (Date this version of the software was released.). This is the underlying object with id, value and extensions. The accessor "getReleaseDate" gives direct access to the value
         */
        public CapabilityStatement2SoftwareComponent setReleaseDateElement(DateTimeType value) { 
          this.releaseDate = value;
          return this;
        }

        /**
         * @return Date this version of the software was released.
         */
        public Date getReleaseDate() { 
          return this.releaseDate == null ? null : this.releaseDate.getValue();
        }

        /**
         * @param value Date this version of the software was released.
         */
        public CapabilityStatement2SoftwareComponent setReleaseDate(Date value) { 
          if (value == null)
            this.releaseDate = null;
          else {
            if (this.releaseDate == null)
              this.releaseDate = new DateTimeType();
            this.releaseDate.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Name the software is known by.", 0, 1, name));
          children.add(new Property("version", "string", "The version identifier for the software covered by this statement.", 0, 1, version));
          children.add(new Property("releaseDate", "dateTime", "Date this version of the software was released.", 0, 1, releaseDate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Name the software is known by.", 0, 1, name);
          case 351608024: /*version*/  return new Property("version", "string", "The version identifier for the software covered by this statement.", 0, 1, version);
          case 212873301: /*releaseDate*/  return new Property("releaseDate", "dateTime", "Date this version of the software was released.", 0, 1, releaseDate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 212873301: /*releaseDate*/ return this.releaseDate == null ? new Base[0] : new Base[] {this.releaseDate}; // DateTimeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 212873301: // releaseDate
          this.releaseDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("releaseDate")) {
          this.releaseDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 351608024:  return getVersionElement();
        case 212873301:  return getReleaseDateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 212873301: /*releaseDate*/ return new String[] {"dateTime"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.software.name");
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.software.version");
        }
        else if (name.equals("releaseDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.software.releaseDate");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatement2SoftwareComponent copy() {
        CapabilityStatement2SoftwareComponent dst = new CapabilityStatement2SoftwareComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatement2SoftwareComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.version = version == null ? null : version.copy();
        dst.releaseDate = releaseDate == null ? null : releaseDate.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2SoftwareComponent))
          return false;
        CapabilityStatement2SoftwareComponent o = (CapabilityStatement2SoftwareComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(version, o.version, true) && compareDeep(releaseDate, o.releaseDate, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2SoftwareComponent))
          return false;
        CapabilityStatement2SoftwareComponent o = (CapabilityStatement2SoftwareComponent) other_;
        return compareValues(name, o.name, true) && compareValues(version, o.version, true) && compareValues(releaseDate, o.releaseDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, version, releaseDate
          );
      }

  public String fhirType() {
    return "CapabilityStatement2.software";

  }

  }

    @Block()
    public static class CapabilityStatement2ImplementationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Information about the specific installation that this capability statement relates to.
         */
        @Child(name = "description", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Describes this specific instance", formalDefinition="Information about the specific installation that this capability statement relates to." )
        protected StringType description;

        /**
         * An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.
         */
        @Child(name = "url", type = {UrlType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Base URL for the installation", formalDefinition="An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces." )
        protected UrlType url;

        /**
         * The organization responsible for the management of the instance and oversight of the data on the server at the specified URL.
         */
        @Child(name = "custodian", type = {Organization.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Organization that manages the data", formalDefinition="The organization responsible for the management of the instance and oversight of the data on the server at the specified URL." )
        protected Reference custodian;

        private static final long serialVersionUID = 1681322786L;

    /**
     * Constructor
     */
      public CapabilityStatement2ImplementationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatement2ImplementationComponent(String description) {
        super();
        this.setDescription(description);
      }

        /**
         * @return {@link #description} (Information about the specific installation that this capability statement relates to.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2ImplementationComponent.description");
            else if (Configuration.doAutoCreate())
              this.description = new StringType(); // bb
          return this.description;
        }

        public boolean hasDescriptionElement() { 
          return this.description != null && !this.description.isEmpty();
        }

        public boolean hasDescription() { 
          return this.description != null && !this.description.isEmpty();
        }

        /**
         * @param value {@link #description} (Information about the specific installation that this capability statement relates to.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public CapabilityStatement2ImplementationComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Information about the specific installation that this capability statement relates to.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Information about the specific installation that this capability statement relates to.
         */
        public CapabilityStatement2ImplementationComponent setDescription(String value) { 
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          return this;
        }

        /**
         * @return {@link #url} (An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public UrlType getUrlElement() { 
          if (this.url == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2ImplementationComponent.url");
            else if (Configuration.doAutoCreate())
              this.url = new UrlType(); // bb
          return this.url;
        }

        public boolean hasUrlElement() { 
          return this.url != null && !this.url.isEmpty();
        }

        public boolean hasUrl() { 
          return this.url != null && !this.url.isEmpty();
        }

        /**
         * @param value {@link #url} (An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
         */
        public CapabilityStatement2ImplementationComponent setUrlElement(UrlType value) { 
          this.url = value;
          return this;
        }

        /**
         * @return An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.
         */
        public String getUrl() { 
          return this.url == null ? null : this.url.getValue();
        }

        /**
         * @param value An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.
         */
        public CapabilityStatement2ImplementationComponent setUrl(String value) { 
          if (Utilities.noString(value))
            this.url = null;
          else {
            if (this.url == null)
              this.url = new UrlType();
            this.url.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #custodian} (The organization responsible for the management of the instance and oversight of the data on the server at the specified URL.)
         */
        public Reference getCustodian() { 
          if (this.custodian == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2ImplementationComponent.custodian");
            else if (Configuration.doAutoCreate())
              this.custodian = new Reference(); // cc
          return this.custodian;
        }

        public boolean hasCustodian() { 
          return this.custodian != null && !this.custodian.isEmpty();
        }

        /**
         * @param value {@link #custodian} (The organization responsible for the management of the instance and oversight of the data on the server at the specified URL.)
         */
        public CapabilityStatement2ImplementationComponent setCustodian(Reference value) { 
          this.custodian = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "string", "Information about the specific installation that this capability statement relates to.", 0, 1, description));
          children.add(new Property("url", "url", "An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.", 0, 1, url));
          children.add(new Property("custodian", "Reference(Organization)", "The organization responsible for the management of the instance and oversight of the data on the server at the specified URL.", 0, 1, custodian));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "string", "Information about the specific installation that this capability statement relates to.", 0, 1, description);
          case 116079: /*url*/  return new Property("url", "url", "An absolute base URL for the implementation.  This forms the base for REST interfaces as well as the mailbox and document interfaces.", 0, 1, url);
          case 1611297262: /*custodian*/  return new Property("custodian", "Reference(Organization)", "The organization responsible for the management of the instance and oversight of the data on the server at the specified URL.", 0, 1, custodian);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UrlType
        case 1611297262: /*custodian*/ return this.custodian == null ? new Base[0] : new Base[] {this.custodian}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case 116079: // url
          this.url = TypeConvertor.castToUrl(value); // UrlType
          return value;
        case 1611297262: // custodian
          this.custodian = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("url")) {
          this.url = TypeConvertor.castToUrl(value); // UrlType
        } else if (name.equals("custodian")) {
          this.custodian = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 116079:  return getUrlElement();
        case 1611297262:  return getCustodian();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case 116079: /*url*/ return new String[] {"url"};
        case 1611297262: /*custodian*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.implementation.description");
        }
        else if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.implementation.url");
        }
        else if (name.equals("custodian")) {
          this.custodian = new Reference();
          return this.custodian;
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatement2ImplementationComponent copy() {
        CapabilityStatement2ImplementationComponent dst = new CapabilityStatement2ImplementationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatement2ImplementationComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        dst.url = url == null ? null : url.copy();
        dst.custodian = custodian == null ? null : custodian.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2ImplementationComponent))
          return false;
        CapabilityStatement2ImplementationComponent o = (CapabilityStatement2ImplementationComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(url, o.url, true) && compareDeep(custodian, o.custodian, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2ImplementationComponent))
          return false;
        CapabilityStatement2ImplementationComponent o = (CapabilityStatement2ImplementationComponent) other_;
        return compareValues(description, o.description, true) && compareValues(url, o.url, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, url, custodian
          );
      }

  public String fhirType() {
    return "CapabilityStatement2.implementation";

  }

  }

    @Block()
    public static class CapabilityStatement2RestComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.
         */
        @Child(name = "mode", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="client | server", formalDefinition="Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/restful-capability-mode")
        protected Enumeration<RestfulCapabilityMode> mode;

        /**
         * Information about the system's restful capabilities that apply across all applications, such as security.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="General description of implementation", formalDefinition="Information about the system's restful capabilities that apply across all applications, such as security." )
        protected MarkdownType documentation;

        /**
         * A specification of the restful capabilities of the solution for a specific resource type.
         */
        @Child(name = "resource", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Resource served on the REST interface", formalDefinition="A specification of the restful capabilities of the solution for a specific resource type." )
        protected List<CapabilityStatement2RestResourceComponent> resource;

        /**
         * A specification of restful operations supported by the system.
         */
        @Child(name = "interaction", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="What operations are supported?", formalDefinition="A specification of restful operations supported by the system." )
        protected List<SystemInteractionComponent> interaction;

        /**
         * Search parameters that are supported for searching all resources for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.
         */
        @Child(name = "searchParam", type = {CapabilityStatement2RestResourceSearchParamComponent.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Search parameters for searching all resources", formalDefinition="Search parameters that are supported for searching all resources for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation." )
        protected List<CapabilityStatement2RestResourceSearchParamComponent> searchParam;

        /**
         * Definition of an operation or a named query together with its parameters and their meaning and type.
         */
        @Child(name = "operation", type = {CapabilityStatement2RestResourceOperationComponent.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Definition of a system level operation", formalDefinition="Definition of an operation or a named query together with its parameters and their meaning and type." )
        protected List<CapabilityStatement2RestResourceOperationComponent> operation;

        /**
         * An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .
         */
        @Child(name = "compartment", type = {CanonicalType.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Compartments served/used by system", formalDefinition="An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL ." )
        protected List<CanonicalType> compartment;

        private static final long serialVersionUID = -476653235L;

    /**
     * Constructor
     */
      public CapabilityStatement2RestComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatement2RestComponent(RestfulCapabilityMode mode) {
        super();
        this.setMode(mode);
      }

        /**
         * @return {@link #mode} (Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public Enumeration<RestfulCapabilityMode> getModeElement() { 
          if (this.mode == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestComponent.mode");
            else if (Configuration.doAutoCreate())
              this.mode = new Enumeration<RestfulCapabilityMode>(new RestfulCapabilityModeEnumFactory()); // bb
          return this.mode;
        }

        public boolean hasModeElement() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        public boolean hasMode() { 
          return this.mode != null && !this.mode.isEmpty();
        }

        /**
         * @param value {@link #mode} (Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.). This is the underlying object with id, value and extensions. The accessor "getMode" gives direct access to the value
         */
        public CapabilityStatement2RestComponent setModeElement(Enumeration<RestfulCapabilityMode> value) { 
          this.mode = value;
          return this;
        }

        /**
         * @return Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.
         */
        public RestfulCapabilityMode getMode() { 
          return this.mode == null ? null : this.mode.getValue();
        }

        /**
         * @param value Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.
         */
        public CapabilityStatement2RestComponent setMode(RestfulCapabilityMode value) { 
            if (this.mode == null)
              this.mode = new Enumeration<RestfulCapabilityMode>(new RestfulCapabilityModeEnumFactory());
            this.mode.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Information about the system's restful capabilities that apply across all applications, such as security.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Information about the system's restful capabilities that apply across all applications, such as security.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public CapabilityStatement2RestComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Information about the system's restful capabilities that apply across all applications, such as security.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Information about the system's restful capabilities that apply across all applications, such as security.
         */
        public CapabilityStatement2RestComponent setDocumentation(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #resource} (A specification of the restful capabilities of the solution for a specific resource type.)
         */
        public List<CapabilityStatement2RestResourceComponent> getResource() { 
          if (this.resource == null)
            this.resource = new ArrayList<CapabilityStatement2RestResourceComponent>();
          return this.resource;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatement2RestComponent setResource(List<CapabilityStatement2RestResourceComponent> theResource) { 
          this.resource = theResource;
          return this;
        }

        public boolean hasResource() { 
          if (this.resource == null)
            return false;
          for (CapabilityStatement2RestResourceComponent item : this.resource)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatement2RestResourceComponent addResource() { //3
          CapabilityStatement2RestResourceComponent t = new CapabilityStatement2RestResourceComponent();
          if (this.resource == null)
            this.resource = new ArrayList<CapabilityStatement2RestResourceComponent>();
          this.resource.add(t);
          return t;
        }

        public CapabilityStatement2RestComponent addResource(CapabilityStatement2RestResourceComponent t) { //3
          if (t == null)
            return this;
          if (this.resource == null)
            this.resource = new ArrayList<CapabilityStatement2RestResourceComponent>();
          this.resource.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #resource}, creating it if it does not already exist {3}
         */
        public CapabilityStatement2RestResourceComponent getResourceFirstRep() { 
          if (getResource().isEmpty()) {
            addResource();
          }
          return getResource().get(0);
        }

        /**
         * @return {@link #interaction} (A specification of restful operations supported by the system.)
         */
        public List<SystemInteractionComponent> getInteraction() { 
          if (this.interaction == null)
            this.interaction = new ArrayList<SystemInteractionComponent>();
          return this.interaction;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatement2RestComponent setInteraction(List<SystemInteractionComponent> theInteraction) { 
          this.interaction = theInteraction;
          return this;
        }

        public boolean hasInteraction() { 
          if (this.interaction == null)
            return false;
          for (SystemInteractionComponent item : this.interaction)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SystemInteractionComponent addInteraction() { //3
          SystemInteractionComponent t = new SystemInteractionComponent();
          if (this.interaction == null)
            this.interaction = new ArrayList<SystemInteractionComponent>();
          this.interaction.add(t);
          return t;
        }

        public CapabilityStatement2RestComponent addInteraction(SystemInteractionComponent t) { //3
          if (t == null)
            return this;
          if (this.interaction == null)
            this.interaction = new ArrayList<SystemInteractionComponent>();
          this.interaction.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #interaction}, creating it if it does not already exist {3}
         */
        public SystemInteractionComponent getInteractionFirstRep() { 
          if (getInteraction().isEmpty()) {
            addInteraction();
          }
          return getInteraction().get(0);
        }

        /**
         * @return {@link #searchParam} (Search parameters that are supported for searching all resources for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.)
         */
        public List<CapabilityStatement2RestResourceSearchParamComponent> getSearchParam() { 
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatement2RestResourceSearchParamComponent>();
          return this.searchParam;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatement2RestComponent setSearchParam(List<CapabilityStatement2RestResourceSearchParamComponent> theSearchParam) { 
          this.searchParam = theSearchParam;
          return this;
        }

        public boolean hasSearchParam() { 
          if (this.searchParam == null)
            return false;
          for (CapabilityStatement2RestResourceSearchParamComponent item : this.searchParam)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatement2RestResourceSearchParamComponent addSearchParam() { //3
          CapabilityStatement2RestResourceSearchParamComponent t = new CapabilityStatement2RestResourceSearchParamComponent();
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatement2RestResourceSearchParamComponent>();
          this.searchParam.add(t);
          return t;
        }

        public CapabilityStatement2RestComponent addSearchParam(CapabilityStatement2RestResourceSearchParamComponent t) { //3
          if (t == null)
            return this;
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatement2RestResourceSearchParamComponent>();
          this.searchParam.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #searchParam}, creating it if it does not already exist {3}
         */
        public CapabilityStatement2RestResourceSearchParamComponent getSearchParamFirstRep() { 
          if (getSearchParam().isEmpty()) {
            addSearchParam();
          }
          return getSearchParam().get(0);
        }

        /**
         * @return {@link #operation} (Definition of an operation or a named query together with its parameters and their meaning and type.)
         */
        public List<CapabilityStatement2RestResourceOperationComponent> getOperation() { 
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatement2RestResourceOperationComponent>();
          return this.operation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatement2RestComponent setOperation(List<CapabilityStatement2RestResourceOperationComponent> theOperation) { 
          this.operation = theOperation;
          return this;
        }

        public boolean hasOperation() { 
          if (this.operation == null)
            return false;
          for (CapabilityStatement2RestResourceOperationComponent item : this.operation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatement2RestResourceOperationComponent addOperation() { //3
          CapabilityStatement2RestResourceOperationComponent t = new CapabilityStatement2RestResourceOperationComponent();
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatement2RestResourceOperationComponent>();
          this.operation.add(t);
          return t;
        }

        public CapabilityStatement2RestComponent addOperation(CapabilityStatement2RestResourceOperationComponent t) { //3
          if (t == null)
            return this;
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatement2RestResourceOperationComponent>();
          this.operation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #operation}, creating it if it does not already exist {3}
         */
        public CapabilityStatement2RestResourceOperationComponent getOperationFirstRep() { 
          if (getOperation().isEmpty()) {
            addOperation();
          }
          return getOperation().get(0);
        }

        /**
         * @return {@link #compartment} (An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .)
         */
        public List<CanonicalType> getCompartment() { 
          if (this.compartment == null)
            this.compartment = new ArrayList<CanonicalType>();
          return this.compartment;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatement2RestComponent setCompartment(List<CanonicalType> theCompartment) { 
          this.compartment = theCompartment;
          return this;
        }

        public boolean hasCompartment() { 
          if (this.compartment == null)
            return false;
          for (CanonicalType item : this.compartment)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #compartment} (An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .)
         */
        public CanonicalType addCompartmentElement() {//2 
          CanonicalType t = new CanonicalType();
          if (this.compartment == null)
            this.compartment = new ArrayList<CanonicalType>();
          this.compartment.add(t);
          return t;
        }

        /**
         * @param value {@link #compartment} (An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .)
         */
        public CapabilityStatement2RestComponent addCompartment(String value) { //1
          CanonicalType t = new CanonicalType();
          t.setValue(value);
          if (this.compartment == null)
            this.compartment = new ArrayList<CanonicalType>();
          this.compartment.add(t);
          return this;
        }

        /**
         * @param value {@link #compartment} (An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .)
         */
        public boolean hasCompartment(String value) { 
          if (this.compartment == null)
            return false;
          for (CanonicalType v : this.compartment)
            if (v.getValue().equals(value)) // canonical
              return true;
          return false;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("mode", "code", "Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.", 0, 1, mode));
          children.add(new Property("documentation", "markdown", "Information about the system's restful capabilities that apply across all applications, such as security.", 0, 1, documentation));
          children.add(new Property("resource", "", "A specification of the restful capabilities of the solution for a specific resource type.", 0, java.lang.Integer.MAX_VALUE, resource));
          children.add(new Property("interaction", "", "A specification of restful operations supported by the system.", 0, java.lang.Integer.MAX_VALUE, interaction));
          children.add(new Property("searchParam", "@CapabilityStatement2.rest.resource.searchParam", "Search parameters that are supported for searching all resources for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.", 0, java.lang.Integer.MAX_VALUE, searchParam));
          children.add(new Property("operation", "@CapabilityStatement2.rest.resource.operation", "Definition of an operation or a named query together with its parameters and their meaning and type.", 0, java.lang.Integer.MAX_VALUE, operation));
          children.add(new Property("compartment", "canonical(CompartmentDefinition)", "An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .", 0, java.lang.Integer.MAX_VALUE, compartment));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3357091: /*mode*/  return new Property("mode", "code", "Identifies whether this portion of the statement is describing the ability to initiate or receive restful operations.", 0, 1, mode);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Information about the system's restful capabilities that apply across all applications, such as security.", 0, 1, documentation);
          case -341064690: /*resource*/  return new Property("resource", "", "A specification of the restful capabilities of the solution for a specific resource type.", 0, java.lang.Integer.MAX_VALUE, resource);
          case 1844104722: /*interaction*/  return new Property("interaction", "", "A specification of restful operations supported by the system.", 0, java.lang.Integer.MAX_VALUE, interaction);
          case -553645115: /*searchParam*/  return new Property("searchParam", "@CapabilityStatement2.rest.resource.searchParam", "Search parameters that are supported for searching all resources for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.", 0, java.lang.Integer.MAX_VALUE, searchParam);
          case 1662702951: /*operation*/  return new Property("operation", "@CapabilityStatement2.rest.resource.operation", "Definition of an operation or a named query together with its parameters and their meaning and type.", 0, java.lang.Integer.MAX_VALUE, operation);
          case -397756334: /*compartment*/  return new Property("compartment", "canonical(CompartmentDefinition)", "An absolute URI which is a reference to the definition of a compartment that the system supports. The reference is to a CompartmentDefinition resource by its canonical URL .", 0, java.lang.Integer.MAX_VALUE, compartment);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return this.mode == null ? new Base[0] : new Base[] {this.mode}; // Enumeration<RestfulCapabilityMode>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : this.resource.toArray(new Base[this.resource.size()]); // CapabilityStatement2RestResourceComponent
        case 1844104722: /*interaction*/ return this.interaction == null ? new Base[0] : this.interaction.toArray(new Base[this.interaction.size()]); // SystemInteractionComponent
        case -553645115: /*searchParam*/ return this.searchParam == null ? new Base[0] : this.searchParam.toArray(new Base[this.searchParam.size()]); // CapabilityStatement2RestResourceSearchParamComponent
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : this.operation.toArray(new Base[this.operation.size()]); // CapabilityStatement2RestResourceOperationComponent
        case -397756334: /*compartment*/ return this.compartment == null ? new Base[0] : this.compartment.toArray(new Base[this.compartment.size()]); // CanonicalType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3357091: // mode
          value = new RestfulCapabilityModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<RestfulCapabilityMode>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -341064690: // resource
          this.getResource().add((CapabilityStatement2RestResourceComponent) value); // CapabilityStatement2RestResourceComponent
          return value;
        case 1844104722: // interaction
          this.getInteraction().add((SystemInteractionComponent) value); // SystemInteractionComponent
          return value;
        case -553645115: // searchParam
          this.getSearchParam().add((CapabilityStatement2RestResourceSearchParamComponent) value); // CapabilityStatement2RestResourceSearchParamComponent
          return value;
        case 1662702951: // operation
          this.getOperation().add((CapabilityStatement2RestResourceOperationComponent) value); // CapabilityStatement2RestResourceOperationComponent
          return value;
        case -397756334: // compartment
          this.getCompartment().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("mode")) {
          value = new RestfulCapabilityModeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.mode = (Enumeration) value; // Enumeration<RestfulCapabilityMode>
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("resource")) {
          this.getResource().add((CapabilityStatement2RestResourceComponent) value);
        } else if (name.equals("interaction")) {
          this.getInteraction().add((SystemInteractionComponent) value);
        } else if (name.equals("searchParam")) {
          this.getSearchParam().add((CapabilityStatement2RestResourceSearchParamComponent) value);
        } else if (name.equals("operation")) {
          this.getOperation().add((CapabilityStatement2RestResourceOperationComponent) value);
        } else if (name.equals("compartment")) {
          this.getCompartment().add(TypeConvertor.castToCanonical(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091:  return getModeElement();
        case 1587405498:  return getDocumentationElement();
        case -341064690:  return addResource(); 
        case 1844104722:  return addInteraction(); 
        case -553645115:  return addSearchParam(); 
        case 1662702951:  return addOperation(); 
        case -397756334:  return addCompartmentElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3357091: /*mode*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        case -341064690: /*resource*/ return new String[] {};
        case 1844104722: /*interaction*/ return new String[] {};
        case -553645115: /*searchParam*/ return new String[] {"@CapabilityStatement2.rest.resource.searchParam"};
        case 1662702951: /*operation*/ return new String[] {"@CapabilityStatement2.rest.resource.operation"};
        case -397756334: /*compartment*/ return new String[] {"canonical"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("mode")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.mode");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.documentation");
        }
        else if (name.equals("resource")) {
          return addResource();
        }
        else if (name.equals("interaction")) {
          return addInteraction();
        }
        else if (name.equals("searchParam")) {
          return addSearchParam();
        }
        else if (name.equals("operation")) {
          return addOperation();
        }
        else if (name.equals("compartment")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.compartment");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatement2RestComponent copy() {
        CapabilityStatement2RestComponent dst = new CapabilityStatement2RestComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatement2RestComponent dst) {
        super.copyValues(dst);
        dst.mode = mode == null ? null : mode.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
        if (resource != null) {
          dst.resource = new ArrayList<CapabilityStatement2RestResourceComponent>();
          for (CapabilityStatement2RestResourceComponent i : resource)
            dst.resource.add(i.copy());
        };
        if (interaction != null) {
          dst.interaction = new ArrayList<SystemInteractionComponent>();
          for (SystemInteractionComponent i : interaction)
            dst.interaction.add(i.copy());
        };
        if (searchParam != null) {
          dst.searchParam = new ArrayList<CapabilityStatement2RestResourceSearchParamComponent>();
          for (CapabilityStatement2RestResourceSearchParamComponent i : searchParam)
            dst.searchParam.add(i.copy());
        };
        if (operation != null) {
          dst.operation = new ArrayList<CapabilityStatement2RestResourceOperationComponent>();
          for (CapabilityStatement2RestResourceOperationComponent i : operation)
            dst.operation.add(i.copy());
        };
        if (compartment != null) {
          dst.compartment = new ArrayList<CanonicalType>();
          for (CanonicalType i : compartment)
            dst.compartment.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2RestComponent))
          return false;
        CapabilityStatement2RestComponent o = (CapabilityStatement2RestComponent) other_;
        return compareDeep(mode, o.mode, true) && compareDeep(documentation, o.documentation, true) && compareDeep(resource, o.resource, true)
           && compareDeep(interaction, o.interaction, true) && compareDeep(searchParam, o.searchParam, true)
           && compareDeep(operation, o.operation, true) && compareDeep(compartment, o.compartment, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2RestComponent))
          return false;
        CapabilityStatement2RestComponent o = (CapabilityStatement2RestComponent) other_;
        return compareValues(mode, o.mode, true) && compareValues(documentation, o.documentation, true) && compareValues(compartment, o.compartment, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(mode, documentation, resource
          , interaction, searchParam, operation, compartment);
      }

  public String fhirType() {
    return "CapabilityStatement2.rest";

  }

  }

    @Block()
    public static class CapabilityStatement2RestResourceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A type of resource exposed via the restful interface.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A resource type that is supported", formalDefinition="A type of resource exposed via the restful interface." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/resource-types")
        protected CodeType type;

        /**
         * A specification of the profile that describes the solution's overall support for the resource, including any constraints on cardinality, bindings, lengths or other limitations. See further discussion in [Using Profiles](profiling.html#profile-uses).
         */
        @Child(name = "profile", type = {CanonicalType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Base System profile for all uses of resource", formalDefinition="A specification of the profile that describes the solution's overall support for the resource, including any constraints on cardinality, bindings, lengths or other limitations. See further discussion in [Using Profiles](profiling.html#profile-uses)." )
        protected CanonicalType profile;

        /**
         * A list of profiles that represent different use cases supported by the system. For a server, "supported by the system" means the system hosts/produces a set of resources that are conformant to a particular profile, and allows clients that use its services to search using this profile and to find appropriate data. For a client, it means the system will search by this profile and process data according to the guidance implicit in the profile. See further discussion in [Using Profiles](profiling.html#profile-uses).
         */
        @Child(name = "supportedProfile", type = {CanonicalType.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Profiles for use cases supported", formalDefinition="A list of profiles that represent different use cases supported by the system. For a server, \"supported by the system\" means the system hosts/produces a set of resources that are conformant to a particular profile, and allows clients that use its services to search using this profile and to find appropriate data. For a client, it means the system will search by this profile and process data according to the guidance implicit in the profile. See further discussion in [Using Profiles](profiling.html#profile-uses)." )
        protected List<CanonicalType> supportedProfile;

        /**
         * Additional information about the resource type used by the system.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Additional information about the use of the resource type", formalDefinition="Additional information about the resource type used by the system." )
        protected MarkdownType documentation;

        /**
         * Identifies a restful operation supported by the solution.
         */
        @Child(name = "interaction", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="What operations are supported?", formalDefinition="Identifies a restful operation supported by the solution." )
        protected List<ResourceInteractionComponent> interaction;

        /**
         * Search parameters for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.
         */
        @Child(name = "searchParam", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Search parameters supported by implementation", formalDefinition="Search parameters for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation." )
        protected List<CapabilityStatement2RestResourceSearchParamComponent> searchParam;

        /**
         * Definition of an operation or a named query together with its parameters and their meaning and type. Consult the definition of the operation for details about how to invoke the operation, and the parameters.
         */
        @Child(name = "operation", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Definition of a resource operation", formalDefinition="Definition of an operation or a named query together with its parameters and their meaning and type. Consult the definition of the operation for details about how to invoke the operation, and the parameters." )
        protected List<CapabilityStatement2RestResourceOperationComponent> operation;

        private static final long serialVersionUID = 1394978037L;

    /**
     * Constructor
     */
      public CapabilityStatement2RestResourceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatement2RestResourceComponent(String type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (A type of resource exposed via the restful interface.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public CodeType getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestResourceComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeType(); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (A type of resource exposed via the restful interface.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public CapabilityStatement2RestResourceComponent setTypeElement(CodeType value) { 
          this.type = value;
          return this;
        }

        /**
         * @return A type of resource exposed via the restful interface.
         */
        public String getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value A type of resource exposed via the restful interface.
         */
        public CapabilityStatement2RestResourceComponent setType(String value) { 
            if (this.type == null)
              this.type = new CodeType();
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #profile} (A specification of the profile that describes the solution's overall support for the resource, including any constraints on cardinality, bindings, lengths or other limitations. See further discussion in [Using Profiles](profiling.html#profile-uses).). This is the underlying object with id, value and extensions. The accessor "getProfile" gives direct access to the value
         */
        public CanonicalType getProfileElement() { 
          if (this.profile == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestResourceComponent.profile");
            else if (Configuration.doAutoCreate())
              this.profile = new CanonicalType(); // bb
          return this.profile;
        }

        public boolean hasProfileElement() { 
          return this.profile != null && !this.profile.isEmpty();
        }

        public boolean hasProfile() { 
          return this.profile != null && !this.profile.isEmpty();
        }

        /**
         * @param value {@link #profile} (A specification of the profile that describes the solution's overall support for the resource, including any constraints on cardinality, bindings, lengths or other limitations. See further discussion in [Using Profiles](profiling.html#profile-uses).). This is the underlying object with id, value and extensions. The accessor "getProfile" gives direct access to the value
         */
        public CapabilityStatement2RestResourceComponent setProfileElement(CanonicalType value) { 
          this.profile = value;
          return this;
        }

        /**
         * @return A specification of the profile that describes the solution's overall support for the resource, including any constraints on cardinality, bindings, lengths or other limitations. See further discussion in [Using Profiles](profiling.html#profile-uses).
         */
        public String getProfile() { 
          return this.profile == null ? null : this.profile.getValue();
        }

        /**
         * @param value A specification of the profile that describes the solution's overall support for the resource, including any constraints on cardinality, bindings, lengths or other limitations. See further discussion in [Using Profiles](profiling.html#profile-uses).
         */
        public CapabilityStatement2RestResourceComponent setProfile(String value) { 
          if (Utilities.noString(value))
            this.profile = null;
          else {
            if (this.profile == null)
              this.profile = new CanonicalType();
            this.profile.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #supportedProfile} (A list of profiles that represent different use cases supported by the system. For a server, "supported by the system" means the system hosts/produces a set of resources that are conformant to a particular profile, and allows clients that use its services to search using this profile and to find appropriate data. For a client, it means the system will search by this profile and process data according to the guidance implicit in the profile. See further discussion in [Using Profiles](profiling.html#profile-uses).)
         */
        public List<CanonicalType> getSupportedProfile() { 
          if (this.supportedProfile == null)
            this.supportedProfile = new ArrayList<CanonicalType>();
          return this.supportedProfile;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatement2RestResourceComponent setSupportedProfile(List<CanonicalType> theSupportedProfile) { 
          this.supportedProfile = theSupportedProfile;
          return this;
        }

        public boolean hasSupportedProfile() { 
          if (this.supportedProfile == null)
            return false;
          for (CanonicalType item : this.supportedProfile)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #supportedProfile} (A list of profiles that represent different use cases supported by the system. For a server, "supported by the system" means the system hosts/produces a set of resources that are conformant to a particular profile, and allows clients that use its services to search using this profile and to find appropriate data. For a client, it means the system will search by this profile and process data according to the guidance implicit in the profile. See further discussion in [Using Profiles](profiling.html#profile-uses).)
         */
        public CanonicalType addSupportedProfileElement() {//2 
          CanonicalType t = new CanonicalType();
          if (this.supportedProfile == null)
            this.supportedProfile = new ArrayList<CanonicalType>();
          this.supportedProfile.add(t);
          return t;
        }

        /**
         * @param value {@link #supportedProfile} (A list of profiles that represent different use cases supported by the system. For a server, "supported by the system" means the system hosts/produces a set of resources that are conformant to a particular profile, and allows clients that use its services to search using this profile and to find appropriate data. For a client, it means the system will search by this profile and process data according to the guidance implicit in the profile. See further discussion in [Using Profiles](profiling.html#profile-uses).)
         */
        public CapabilityStatement2RestResourceComponent addSupportedProfile(String value) { //1
          CanonicalType t = new CanonicalType();
          t.setValue(value);
          if (this.supportedProfile == null)
            this.supportedProfile = new ArrayList<CanonicalType>();
          this.supportedProfile.add(t);
          return this;
        }

        /**
         * @param value {@link #supportedProfile} (A list of profiles that represent different use cases supported by the system. For a server, "supported by the system" means the system hosts/produces a set of resources that are conformant to a particular profile, and allows clients that use its services to search using this profile and to find appropriate data. For a client, it means the system will search by this profile and process data according to the guidance implicit in the profile. See further discussion in [Using Profiles](profiling.html#profile-uses).)
         */
        public boolean hasSupportedProfile(String value) { 
          if (this.supportedProfile == null)
            return false;
          for (CanonicalType v : this.supportedProfile)
            if (v.getValue().equals(value)) // canonical
              return true;
          return false;
        }

        /**
         * @return {@link #documentation} (Additional information about the resource type used by the system.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestResourceComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Additional information about the resource type used by the system.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public CapabilityStatement2RestResourceComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Additional information about the resource type used by the system.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Additional information about the resource type used by the system.
         */
        public CapabilityStatement2RestResourceComponent setDocumentation(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #interaction} (Identifies a restful operation supported by the solution.)
         */
        public List<ResourceInteractionComponent> getInteraction() { 
          if (this.interaction == null)
            this.interaction = new ArrayList<ResourceInteractionComponent>();
          return this.interaction;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatement2RestResourceComponent setInteraction(List<ResourceInteractionComponent> theInteraction) { 
          this.interaction = theInteraction;
          return this;
        }

        public boolean hasInteraction() { 
          if (this.interaction == null)
            return false;
          for (ResourceInteractionComponent item : this.interaction)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ResourceInteractionComponent addInteraction() { //3
          ResourceInteractionComponent t = new ResourceInteractionComponent();
          if (this.interaction == null)
            this.interaction = new ArrayList<ResourceInteractionComponent>();
          this.interaction.add(t);
          return t;
        }

        public CapabilityStatement2RestResourceComponent addInteraction(ResourceInteractionComponent t) { //3
          if (t == null)
            return this;
          if (this.interaction == null)
            this.interaction = new ArrayList<ResourceInteractionComponent>();
          this.interaction.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #interaction}, creating it if it does not already exist {3}
         */
        public ResourceInteractionComponent getInteractionFirstRep() { 
          if (getInteraction().isEmpty()) {
            addInteraction();
          }
          return getInteraction().get(0);
        }

        /**
         * @return {@link #searchParam} (Search parameters for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.)
         */
        public List<CapabilityStatement2RestResourceSearchParamComponent> getSearchParam() { 
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatement2RestResourceSearchParamComponent>();
          return this.searchParam;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatement2RestResourceComponent setSearchParam(List<CapabilityStatement2RestResourceSearchParamComponent> theSearchParam) { 
          this.searchParam = theSearchParam;
          return this;
        }

        public boolean hasSearchParam() { 
          if (this.searchParam == null)
            return false;
          for (CapabilityStatement2RestResourceSearchParamComponent item : this.searchParam)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatement2RestResourceSearchParamComponent addSearchParam() { //3
          CapabilityStatement2RestResourceSearchParamComponent t = new CapabilityStatement2RestResourceSearchParamComponent();
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatement2RestResourceSearchParamComponent>();
          this.searchParam.add(t);
          return t;
        }

        public CapabilityStatement2RestResourceComponent addSearchParam(CapabilityStatement2RestResourceSearchParamComponent t) { //3
          if (t == null)
            return this;
          if (this.searchParam == null)
            this.searchParam = new ArrayList<CapabilityStatement2RestResourceSearchParamComponent>();
          this.searchParam.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #searchParam}, creating it if it does not already exist {3}
         */
        public CapabilityStatement2RestResourceSearchParamComponent getSearchParamFirstRep() { 
          if (getSearchParam().isEmpty()) {
            addSearchParam();
          }
          return getSearchParam().get(0);
        }

        /**
         * @return {@link #operation} (Definition of an operation or a named query together with its parameters and their meaning and type. Consult the definition of the operation for details about how to invoke the operation, and the parameters.)
         */
        public List<CapabilityStatement2RestResourceOperationComponent> getOperation() { 
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatement2RestResourceOperationComponent>();
          return this.operation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public CapabilityStatement2RestResourceComponent setOperation(List<CapabilityStatement2RestResourceOperationComponent> theOperation) { 
          this.operation = theOperation;
          return this;
        }

        public boolean hasOperation() { 
          if (this.operation == null)
            return false;
          for (CapabilityStatement2RestResourceOperationComponent item : this.operation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CapabilityStatement2RestResourceOperationComponent addOperation() { //3
          CapabilityStatement2RestResourceOperationComponent t = new CapabilityStatement2RestResourceOperationComponent();
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatement2RestResourceOperationComponent>();
          this.operation.add(t);
          return t;
        }

        public CapabilityStatement2RestResourceComponent addOperation(CapabilityStatement2RestResourceOperationComponent t) { //3
          if (t == null)
            return this;
          if (this.operation == null)
            this.operation = new ArrayList<CapabilityStatement2RestResourceOperationComponent>();
          this.operation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #operation}, creating it if it does not already exist {3}
         */
        public CapabilityStatement2RestResourceOperationComponent getOperationFirstRep() { 
          if (getOperation().isEmpty()) {
            addOperation();
          }
          return getOperation().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "A type of resource exposed via the restful interface.", 0, 1, type));
          children.add(new Property("profile", "canonical(StructureDefinition)", "A specification of the profile that describes the solution's overall support for the resource, including any constraints on cardinality, bindings, lengths or other limitations. See further discussion in [Using Profiles](profiling.html#profile-uses).", 0, 1, profile));
          children.add(new Property("supportedProfile", "canonical(StructureDefinition)", "A list of profiles that represent different use cases supported by the system. For a server, \"supported by the system\" means the system hosts/produces a set of resources that are conformant to a particular profile, and allows clients that use its services to search using this profile and to find appropriate data. For a client, it means the system will search by this profile and process data according to the guidance implicit in the profile. See further discussion in [Using Profiles](profiling.html#profile-uses).", 0, java.lang.Integer.MAX_VALUE, supportedProfile));
          children.add(new Property("documentation", "markdown", "Additional information about the resource type used by the system.", 0, 1, documentation));
          children.add(new Property("interaction", "", "Identifies a restful operation supported by the solution.", 0, java.lang.Integer.MAX_VALUE, interaction));
          children.add(new Property("searchParam", "", "Search parameters for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.", 0, java.lang.Integer.MAX_VALUE, searchParam));
          children.add(new Property("operation", "", "Definition of an operation or a named query together with its parameters and their meaning and type. Consult the definition of the operation for details about how to invoke the operation, and the parameters.", 0, java.lang.Integer.MAX_VALUE, operation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "A type of resource exposed via the restful interface.", 0, 1, type);
          case -309425751: /*profile*/  return new Property("profile", "canonical(StructureDefinition)", "A specification of the profile that describes the solution's overall support for the resource, including any constraints on cardinality, bindings, lengths or other limitations. See further discussion in [Using Profiles](profiling.html#profile-uses).", 0, 1, profile);
          case 1225477403: /*supportedProfile*/  return new Property("supportedProfile", "canonical(StructureDefinition)", "A list of profiles that represent different use cases supported by the system. For a server, \"supported by the system\" means the system hosts/produces a set of resources that are conformant to a particular profile, and allows clients that use its services to search using this profile and to find appropriate data. For a client, it means the system will search by this profile and process data according to the guidance implicit in the profile. See further discussion in [Using Profiles](profiling.html#profile-uses).", 0, java.lang.Integer.MAX_VALUE, supportedProfile);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Additional information about the resource type used by the system.", 0, 1, documentation);
          case 1844104722: /*interaction*/  return new Property("interaction", "", "Identifies a restful operation supported by the solution.", 0, java.lang.Integer.MAX_VALUE, interaction);
          case -553645115: /*searchParam*/  return new Property("searchParam", "", "Search parameters for implementations to support and/or make use of - either references to ones defined in the specification, or additional ones defined for/by the implementation.", 0, java.lang.Integer.MAX_VALUE, searchParam);
          case 1662702951: /*operation*/  return new Property("operation", "", "Definition of an operation or a named query together with its parameters and their meaning and type. Consult the definition of the operation for details about how to invoke the operation, and the parameters.", 0, java.lang.Integer.MAX_VALUE, operation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeType
        case -309425751: /*profile*/ return this.profile == null ? new Base[0] : new Base[] {this.profile}; // CanonicalType
        case 1225477403: /*supportedProfile*/ return this.supportedProfile == null ? new Base[0] : this.supportedProfile.toArray(new Base[this.supportedProfile.size()]); // CanonicalType
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        case 1844104722: /*interaction*/ return this.interaction == null ? new Base[0] : this.interaction.toArray(new Base[this.interaction.size()]); // ResourceInteractionComponent
        case -553645115: /*searchParam*/ return this.searchParam == null ? new Base[0] : this.searchParam.toArray(new Base[this.searchParam.size()]); // CapabilityStatement2RestResourceSearchParamComponent
        case 1662702951: /*operation*/ return this.operation == null ? new Base[0] : this.operation.toArray(new Base[this.operation.size()]); // CapabilityStatement2RestResourceOperationComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -309425751: // profile
          this.profile = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 1225477403: // supportedProfile
          this.getSupportedProfile().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1844104722: // interaction
          this.getInteraction().add((ResourceInteractionComponent) value); // ResourceInteractionComponent
          return value;
        case -553645115: // searchParam
          this.getSearchParam().add((CapabilityStatement2RestResourceSearchParamComponent) value); // CapabilityStatement2RestResourceSearchParamComponent
          return value;
        case 1662702951: // operation
          this.getOperation().add((CapabilityStatement2RestResourceOperationComponent) value); // CapabilityStatement2RestResourceOperationComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("profile")) {
          this.profile = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("supportedProfile")) {
          this.getSupportedProfile().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("interaction")) {
          this.getInteraction().add((ResourceInteractionComponent) value);
        } else if (name.equals("searchParam")) {
          this.getSearchParam().add((CapabilityStatement2RestResourceSearchParamComponent) value);
        } else if (name.equals("operation")) {
          this.getOperation().add((CapabilityStatement2RestResourceOperationComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case -309425751:  return getProfileElement();
        case 1225477403:  return addSupportedProfileElement();
        case 1587405498:  return getDocumentationElement();
        case 1844104722:  return addInteraction(); 
        case -553645115:  return addSearchParam(); 
        case 1662702951:  return addOperation(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case -309425751: /*profile*/ return new String[] {"canonical"};
        case 1225477403: /*supportedProfile*/ return new String[] {"canonical"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        case 1844104722: /*interaction*/ return new String[] {};
        case -553645115: /*searchParam*/ return new String[] {};
        case 1662702951: /*operation*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.type");
        }
        else if (name.equals("profile")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.profile");
        }
        else if (name.equals("supportedProfile")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.supportedProfile");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.documentation");
        }
        else if (name.equals("interaction")) {
          return addInteraction();
        }
        else if (name.equals("searchParam")) {
          return addSearchParam();
        }
        else if (name.equals("operation")) {
          return addOperation();
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatement2RestResourceComponent copy() {
        CapabilityStatement2RestResourceComponent dst = new CapabilityStatement2RestResourceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatement2RestResourceComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.profile = profile == null ? null : profile.copy();
        if (supportedProfile != null) {
          dst.supportedProfile = new ArrayList<CanonicalType>();
          for (CanonicalType i : supportedProfile)
            dst.supportedProfile.add(i.copy());
        };
        dst.documentation = documentation == null ? null : documentation.copy();
        if (interaction != null) {
          dst.interaction = new ArrayList<ResourceInteractionComponent>();
          for (ResourceInteractionComponent i : interaction)
            dst.interaction.add(i.copy());
        };
        if (searchParam != null) {
          dst.searchParam = new ArrayList<CapabilityStatement2RestResourceSearchParamComponent>();
          for (CapabilityStatement2RestResourceSearchParamComponent i : searchParam)
            dst.searchParam.add(i.copy());
        };
        if (operation != null) {
          dst.operation = new ArrayList<CapabilityStatement2RestResourceOperationComponent>();
          for (CapabilityStatement2RestResourceOperationComponent i : operation)
            dst.operation.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2RestResourceComponent))
          return false;
        CapabilityStatement2RestResourceComponent o = (CapabilityStatement2RestResourceComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(profile, o.profile, true) && compareDeep(supportedProfile, o.supportedProfile, true)
           && compareDeep(documentation, o.documentation, true) && compareDeep(interaction, o.interaction, true)
           && compareDeep(searchParam, o.searchParam, true) && compareDeep(operation, o.operation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2RestResourceComponent))
          return false;
        CapabilityStatement2RestResourceComponent o = (CapabilityStatement2RestResourceComponent) other_;
        return compareValues(type, o.type, true) && compareValues(profile, o.profile, true) && compareValues(supportedProfile, o.supportedProfile, true)
           && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, profile, supportedProfile
          , documentation, interaction, searchParam, operation);
      }

  public String fhirType() {
    return "CapabilityStatement2.rest.resource";

  }

  }

    @Block()
    public static class ResourceInteractionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Coded identifier of the operation, supported by the system resource.
         */
        @Child(name = "code", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="read | vread | update | patch | delete | history-instance | history-type | create | search-type", formalDefinition="Coded identifier of the operation, supported by the system resource." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/type-restful-interaction")
        protected Enumeration<TypeRestfulInteraction> code;

        /**
         * Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Anything special about operation behavior", formalDefinition="Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'." )
        protected MarkdownType documentation;

        private static final long serialVersionUID = 2128937796L;

    /**
     * Constructor
     */
      public ResourceInteractionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ResourceInteractionComponent(TypeRestfulInteraction code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (Coded identifier of the operation, supported by the system resource.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public Enumeration<TypeRestfulInteraction> getCodeElement() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResourceInteractionComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new Enumeration<TypeRestfulInteraction>(new TypeRestfulInteractionEnumFactory()); // bb
          return this.code;
        }

        public boolean hasCodeElement() { 
          return this.code != null && !this.code.isEmpty();
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Coded identifier of the operation, supported by the system resource.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public ResourceInteractionComponent setCodeElement(Enumeration<TypeRestfulInteraction> value) { 
          this.code = value;
          return this;
        }

        /**
         * @return Coded identifier of the operation, supported by the system resource.
         */
        public TypeRestfulInteraction getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value Coded identifier of the operation, supported by the system resource.
         */
        public ResourceInteractionComponent setCode(TypeRestfulInteraction value) { 
            if (this.code == null)
              this.code = new Enumeration<TypeRestfulInteraction>(new TypeRestfulInteractionEnumFactory());
            this.code.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResourceInteractionComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public ResourceInteractionComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.
         */
        public ResourceInteractionComponent setDocumentation(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "code", "Coded identifier of the operation, supported by the system resource.", 0, 1, code));
          children.add(new Property("documentation", "markdown", "Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "code", "Coded identifier of the operation, supported by the system resource.", 0, 1, code);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Guidance specific to the implementation of this operation, such as 'delete is a logical delete' or 'updates are only allowed with version id' or 'creates permitted from pre-authorized certificates only'.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // Enumeration<TypeRestfulInteraction>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          value = new TypeRestfulInteractionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<TypeRestfulInteraction>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          value = new TypeRestfulInteractionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<TypeRestfulInteraction>
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.interaction.code");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.interaction.documentation");
        }
        else
          return super.addChild(name);
      }

      public ResourceInteractionComponent copy() {
        ResourceInteractionComponent dst = new ResourceInteractionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResourceInteractionComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResourceInteractionComponent))
          return false;
        ResourceInteractionComponent o = (ResourceInteractionComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(documentation, o.documentation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResourceInteractionComponent))
          return false;
        ResourceInteractionComponent o = (ResourceInteractionComponent) other_;
        return compareValues(code, o.code, true) && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, documentation);
      }

  public String fhirType() {
    return "CapabilityStatement2.rest.resource.interaction";

  }

  }

    @Block()
    public static class CapabilityStatement2RestResourceSearchParamComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The name of the search parameter used in the interface.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of search parameter", formalDefinition="The name of the search parameter used in the interface." )
        protected StringType name;

        /**
         * An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.
         */
        @Child(name = "definition", type = {CanonicalType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Source of definition for parameter", formalDefinition="An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs." )
        protected CanonicalType definition;

        /**
         * The type of value a search parameter refers to, and how the content is interpreted.
         */
        @Child(name = "type", type = {CodeType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="number | date | string | token | reference | composite | quantity | uri | special", formalDefinition="The type of value a search parameter refers to, and how the content is interpreted." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/search-param-type")
        protected Enumeration<SearchParamType> type;

        /**
         * This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Server-specific usage", formalDefinition="This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms." )
        protected MarkdownType documentation;

        private static final long serialVersionUID = -171123928L;

    /**
     * Constructor
     */
      public CapabilityStatement2RestResourceSearchParamComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatement2RestResourceSearchParamComponent(String name, SearchParamType type) {
        super();
        this.setName(name);
        this.setType(type);
      }

        /**
         * @return {@link #name} (The name of the search parameter used in the interface.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestResourceSearchParamComponent.name");
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
         * @param value {@link #name} (The name of the search parameter used in the interface.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public CapabilityStatement2RestResourceSearchParamComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The name of the search parameter used in the interface.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The name of the search parameter used in the interface.
         */
        public CapabilityStatement2RestResourceSearchParamComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #definition} (An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public CanonicalType getDefinitionElement() { 
          if (this.definition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestResourceSearchParamComponent.definition");
            else if (Configuration.doAutoCreate())
              this.definition = new CanonicalType(); // bb
          return this.definition;
        }

        public boolean hasDefinitionElement() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        public boolean hasDefinition() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        /**
         * @param value {@link #definition} (An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public CapabilityStatement2RestResourceSearchParamComponent setDefinitionElement(CanonicalType value) { 
          this.definition = value;
          return this;
        }

        /**
         * @return An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.
         */
        public String getDefinition() { 
          return this.definition == null ? null : this.definition.getValue();
        }

        /**
         * @param value An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.
         */
        public CapabilityStatement2RestResourceSearchParamComponent setDefinition(String value) { 
          if (Utilities.noString(value))
            this.definition = null;
          else {
            if (this.definition == null)
              this.definition = new CanonicalType();
            this.definition.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #type} (The type of value a search parameter refers to, and how the content is interpreted.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<SearchParamType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestResourceSearchParamComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<SearchParamType>(new SearchParamTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of value a search parameter refers to, and how the content is interpreted.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public CapabilityStatement2RestResourceSearchParamComponent setTypeElement(Enumeration<SearchParamType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of value a search parameter refers to, and how the content is interpreted.
         */
        public SearchParamType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of value a search parameter refers to, and how the content is interpreted.
         */
        public CapabilityStatement2RestResourceSearchParamComponent setType(SearchParamType value) { 
            if (this.type == null)
              this.type = new Enumeration<SearchParamType>(new SearchParamTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestResourceSearchParamComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public CapabilityStatement2RestResourceSearchParamComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.
         */
        public CapabilityStatement2RestResourceSearchParamComponent setDocumentation(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "The name of the search parameter used in the interface.", 0, 1, name));
          children.add(new Property("definition", "canonical(SearchParameter)", "An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.", 0, 1, definition));
          children.add(new Property("type", "code", "The type of value a search parameter refers to, and how the content is interpreted.", 0, 1, type));
          children.add(new Property("documentation", "markdown", "This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "The name of the search parameter used in the interface.", 0, 1, name);
          case -1014418093: /*definition*/  return new Property("definition", "canonical(SearchParameter)", "An absolute URI that is a formal reference to where this parameter was first defined, so that a client can be confident of the meaning of the search parameter (a reference to [SearchParameter.url](searchparameter-definitions.html#SearchParameter.url)). This element SHALL be populated if the search parameter refers to a SearchParameter defined by the FHIR core specification or externally defined IGs.", 0, 1, definition);
          case 3575610: /*type*/  return new Property("type", "code", "The type of value a search parameter refers to, and how the content is interpreted.", 0, 1, type);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "This allows documentation of any distinct behaviors about how the search parameter is used.  For example, text matching algorithms.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // CanonicalType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<SearchParamType>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 3575610: // type
          value = new SearchParamTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SearchParamType>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("definition")) {
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("type")) {
          value = new SearchParamTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SearchParamType>
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -1014418093:  return getDefinitionElement();
        case 3575610:  return getTypeElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case -1014418093: /*definition*/ return new String[] {"canonical"};
        case 3575610: /*type*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.searchParam.name");
        }
        else if (name.equals("definition")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.searchParam.definition");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.searchParam.type");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.searchParam.documentation");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatement2RestResourceSearchParamComponent copy() {
        CapabilityStatement2RestResourceSearchParamComponent dst = new CapabilityStatement2RestResourceSearchParamComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatement2RestResourceSearchParamComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.definition = definition == null ? null : definition.copy();
        dst.type = type == null ? null : type.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2RestResourceSearchParamComponent))
          return false;
        CapabilityStatement2RestResourceSearchParamComponent o = (CapabilityStatement2RestResourceSearchParamComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(definition, o.definition, true) && compareDeep(type, o.type, true)
           && compareDeep(documentation, o.documentation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2RestResourceSearchParamComponent))
          return false;
        CapabilityStatement2RestResourceSearchParamComponent o = (CapabilityStatement2RestResourceSearchParamComponent) other_;
        return compareValues(name, o.name, true) && compareValues(definition, o.definition, true) && compareValues(type, o.type, true)
           && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, definition, type, documentation
          );
      }

  public String fhirType() {
    return "CapabilityStatement2.rest.resource.searchParam";

  }

  }

    @Block()
    public static class CapabilityStatement2RestResourceOperationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The name of the operation or query. For an operation, this is the name  prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Name by which the operation/query is invoked", formalDefinition="The name of the operation or query. For an operation, this is the name  prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called." )
        protected StringType name;

        /**
         * Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.
         */
        @Child(name = "definition", type = {CanonicalType.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The defined operation/query", formalDefinition="Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported." )
        protected CanonicalType definition;

        /**
         * Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Specific details about operation behavior", formalDefinition="Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation." )
        protected MarkdownType documentation;

        private static final long serialVersionUID = -388608084L;

    /**
     * Constructor
     */
      public CapabilityStatement2RestResourceOperationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CapabilityStatement2RestResourceOperationComponent(String name, String definition) {
        super();
        this.setName(name);
        this.setDefinition(definition);
      }

        /**
         * @return {@link #name} (The name of the operation or query. For an operation, this is the name  prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestResourceOperationComponent.name");
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
         * @param value {@link #name} (The name of the operation or query. For an operation, this is the name  prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public CapabilityStatement2RestResourceOperationComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The name of the operation or query. For an operation, this is the name  prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The name of the operation or query. For an operation, this is the name  prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called.
         */
        public CapabilityStatement2RestResourceOperationComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #definition} (Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public CanonicalType getDefinitionElement() { 
          if (this.definition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestResourceOperationComponent.definition");
            else if (Configuration.doAutoCreate())
              this.definition = new CanonicalType(); // bb
          return this.definition;
        }

        public boolean hasDefinitionElement() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        public boolean hasDefinition() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        /**
         * @param value {@link #definition} (Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.). This is the underlying object with id, value and extensions. The accessor "getDefinition" gives direct access to the value
         */
        public CapabilityStatement2RestResourceOperationComponent setDefinitionElement(CanonicalType value) { 
          this.definition = value;
          return this;
        }

        /**
         * @return Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.
         */
        public String getDefinition() { 
          return this.definition == null ? null : this.definition.getValue();
        }

        /**
         * @param value Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.
         */
        public CapabilityStatement2RestResourceOperationComponent setDefinition(String value) { 
            if (this.definition == null)
              this.definition = new CanonicalType();
            this.definition.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CapabilityStatement2RestResourceOperationComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public CapabilityStatement2RestResourceOperationComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.
         */
        public CapabilityStatement2RestResourceOperationComponent setDocumentation(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "The name of the operation or query. For an operation, this is the name  prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called.", 0, 1, name));
          children.add(new Property("definition", "canonical(OperationDefinition)", "Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.", 0, 1, definition));
          children.add(new Property("documentation", "markdown", "Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "The name of the operation or query. For an operation, this is the name  prefixed with $ and used in the URL. For a query, this is the name used in the _query parameter when the query is called.", 0, 1, name);
          case -1014418093: /*definition*/  return new Property("definition", "canonical(OperationDefinition)", "Where the formal definition can be found. If a server references the base definition of an Operation (i.e. from the specification itself such as ```http://hl7.org/fhir/OperationDefinition/ValueSet-expand```), that means it supports the full capabilities of the operation - e.g. both GET and POST invocation.  If it only supports a subset, it must define its own custom [OperationDefinition](operationdefinition.html#) with a 'base' of the original OperationDefinition.  The custom definition would describe the specific subset of functionality supported.", 0, 1, definition);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Documentation that describes anything special about the operation behavior, possibly detailing different behavior for system, type and instance-level invocation of the operation.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // CanonicalType
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("definition")) {
          this.definition = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -1014418093:  return getDefinitionElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case -1014418093: /*definition*/ return new String[] {"canonical"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.operation.name");
        }
        else if (name.equals("definition")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.operation.definition");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.resource.operation.documentation");
        }
        else
          return super.addChild(name);
      }

      public CapabilityStatement2RestResourceOperationComponent copy() {
        CapabilityStatement2RestResourceOperationComponent dst = new CapabilityStatement2RestResourceOperationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatement2RestResourceOperationComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.definition = definition == null ? null : definition.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2RestResourceOperationComponent))
          return false;
        CapabilityStatement2RestResourceOperationComponent o = (CapabilityStatement2RestResourceOperationComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(definition, o.definition, true) && compareDeep(documentation, o.documentation, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2RestResourceOperationComponent))
          return false;
        CapabilityStatement2RestResourceOperationComponent o = (CapabilityStatement2RestResourceOperationComponent) other_;
        return compareValues(name, o.name, true) && compareValues(definition, o.definition, true) && compareValues(documentation, o.documentation, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, definition, documentation
          );
      }

  public String fhirType() {
    return "CapabilityStatement2.rest.resource.operation";

  }

  }

    @Block()
    public static class SystemInteractionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A coded identifier of the operation, supported by the system.
         */
        @Child(name = "code", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="transaction | batch | search-system | history-system", formalDefinition="A coded identifier of the operation, supported by the system." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/system-restful-interaction")
        protected Enumeration<SystemRestfulInteraction> code;

        /**
         * Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.
         */
        @Child(name = "documentation", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Anything special about operation behavior", formalDefinition="Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented." )
        protected MarkdownType documentation;

        private static final long serialVersionUID = -1495143879L;

    /**
     * Constructor
     */
      public SystemInteractionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SystemInteractionComponent(SystemRestfulInteraction code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (A coded identifier of the operation, supported by the system.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public Enumeration<SystemRestfulInteraction> getCodeElement() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SystemInteractionComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new Enumeration<SystemRestfulInteraction>(new SystemRestfulInteractionEnumFactory()); // bb
          return this.code;
        }

        public boolean hasCodeElement() { 
          return this.code != null && !this.code.isEmpty();
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (A coded identifier of the operation, supported by the system.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public SystemInteractionComponent setCodeElement(Enumeration<SystemRestfulInteraction> value) { 
          this.code = value;
          return this;
        }

        /**
         * @return A coded identifier of the operation, supported by the system.
         */
        public SystemRestfulInteraction getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value A coded identifier of the operation, supported by the system.
         */
        public SystemInteractionComponent setCode(SystemRestfulInteraction value) { 
            if (this.code == null)
              this.code = new Enumeration<SystemRestfulInteraction>(new SystemRestfulInteractionEnumFactory());
            this.code.setValue(value);
          return this;
        }

        /**
         * @return {@link #documentation} (Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public MarkdownType getDocumentationElement() { 
          if (this.documentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SystemInteractionComponent.documentation");
            else if (Configuration.doAutoCreate())
              this.documentation = new MarkdownType(); // bb
          return this.documentation;
        }

        public boolean hasDocumentationElement() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        public boolean hasDocumentation() { 
          return this.documentation != null && !this.documentation.isEmpty();
        }

        /**
         * @param value {@link #documentation} (Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.). This is the underlying object with id, value and extensions. The accessor "getDocumentation" gives direct access to the value
         */
        public SystemInteractionComponent setDocumentationElement(MarkdownType value) { 
          this.documentation = value;
          return this;
        }

        /**
         * @return Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.
         */
        public String getDocumentation() { 
          return this.documentation == null ? null : this.documentation.getValue();
        }

        /**
         * @param value Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.
         */
        public SystemInteractionComponent setDocumentation(String value) { 
          if (value == null)
            this.documentation = null;
          else {
            if (this.documentation == null)
              this.documentation = new MarkdownType();
            this.documentation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "code", "A coded identifier of the operation, supported by the system.", 0, 1, code));
          children.add(new Property("documentation", "markdown", "Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.", 0, 1, documentation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "code", "A coded identifier of the operation, supported by the system.", 0, 1, code);
          case 1587405498: /*documentation*/  return new Property("documentation", "markdown", "Guidance specific to the implementation of this operation, such as limitations on the kind of transactions allowed, or information about system wide search is implemented.", 0, 1, documentation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // Enumeration<SystemRestfulInteraction>
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : new Base[] {this.documentation}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          value = new SystemRestfulInteractionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<SystemRestfulInteraction>
          return value;
        case 1587405498: // documentation
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          value = new SystemRestfulInteractionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<SystemRestfulInteraction>
        } else if (name.equals("documentation")) {
          this.documentation = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case 1587405498:  return getDocumentationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"code"};
        case 1587405498: /*documentation*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.interaction.code");
        }
        else if (name.equals("documentation")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.rest.interaction.documentation");
        }
        else
          return super.addChild(name);
      }

      public SystemInteractionComponent copy() {
        SystemInteractionComponent dst = new SystemInteractionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SystemInteractionComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.documentation = documentation == null ? null : documentation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SystemInteractionComponent))
          return false;
        SystemInteractionComponent o = (SystemInteractionComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(documentation, o.documentation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SystemInteractionComponent))
          return false;
        SystemInteractionComponent o = (SystemInteractionComponent) other_;
        return compareValues(code, o.code, true) && compareValues(documentation, o.documentation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, documentation);
      }

  public String fhirType() {
    return "CapabilityStatement2.rest.interaction";

  }

  }

    /**
     * An absolute URI that is used to identify this capability statement2 when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this capability statement2 is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement2 is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this capability statement2, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this capability statement2 when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this capability statement2 is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement2 is stored on different servers." )
    protected UriType url;

    /**
     * The identifier that is used to identify this version of the capability statement2 when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement2 author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the capability statement2", formalDefinition="The identifier that is used to identify this version of the capability statement2 when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement2 author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * A natural language name identifying the capability statement2. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this capability statement2 (computer friendly)", formalDefinition="A natural language name identifying the capability statement2. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the capability statement2.
     */
    @Child(name = "title", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this capability statement2 (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the capability statement2." )
    protected StringType title;

    /**
     * The status of this capability statement2. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=4, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this capability statement2. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this capability statement2 is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this capability statement2 is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the capability statement2 was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement2 changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the capability statement2 was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement2 changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual that published the capability statement2.
     */
    @Child(name = "publisher", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher (organization or individual)", formalDefinition="The name of the organization or individual that published the capability statement2." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the capability statement2 from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the capability statement2", formalDefinition="A free text natural language description of the capability statement2 from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate capability statement2 instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate capability statement2 instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the capability statement2 is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for capability statement2 (if applicable)", formalDefinition="A legal or geographic region in which the capability statement2 is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this capability statement2 is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this capability statement2 is defined", formalDefinition="Explanation of why this capability statement2 is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the capability statement2 and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement2.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the capability statement2 and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement2." )
    protected MarkdownType copyright;

    /**
     * The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).
     */
    @Child(name = "kind", type = {CodeType.class}, order=14, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="instance | capability | requirements", formalDefinition="The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/capability-statement-kind")
    protected Enumeration<CapabilityStatementKind> kind;

    /**
     * Reference to a canonical URL of another CapabilityStatement2 that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.
     */
    @Child(name = "instantiates", type = {CanonicalType.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Canonical URL of another capability statement this implements", formalDefinition="Reference to a canonical URL of another CapabilityStatement2 that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details." )
    protected List<CanonicalType> instantiates;

    /**
     * Reference to a canonical URL of another CapabilityStatement2 that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.
     */
    @Child(name = "imports", type = {CanonicalType.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Canonical URL of another capability statement this adds to", formalDefinition="Reference to a canonical URL of another CapabilityStatement2 that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them." )
    protected List<CanonicalType> imports;

    /**
     * Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation.
     */
    @Child(name = "software", type = {}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Software that is covered by this capability statement", formalDefinition="Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation." )
    protected CapabilityStatement2SoftwareComponent software;

    /**
     * Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program.
     */
    @Child(name = "implementation", type = {}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If this describes a specific instance", formalDefinition="Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program." )
    protected CapabilityStatement2ImplementationComponent implementation;

    /**
     * The version of the FHIR specification that this CapabilityStatement2 describes (which SHALL be the same as the FHIR version of the CapabilityStatement2 itself). There is no default value.
     */
    @Child(name = "fhirVersion", type = {CodeType.class}, order=19, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="FHIR Version the system supports", formalDefinition="The version of the FHIR specification that this CapabilityStatement2 describes (which SHALL be the same as the FHIR version of the CapabilityStatement2 itself). There is no default value." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/FHIR-version")
    protected Enumeration<FHIRVersion> fhirVersion;

    /**
     * A list of the formats supported by this implementation using their content types.
     */
    @Child(name = "format", type = {CodeType.class}, order=20, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="formats supported (xml | json | ttl | mime type)", formalDefinition="A list of the formats supported by this implementation using their content types." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
    protected List<CodeType> format;

    /**
     * A list of the patch formats supported by this implementation using their content types.
     */
    @Child(name = "patchFormat", type = {CodeType.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Patch formats supported", formalDefinition="A list of the patch formats supported by this implementation using their content types." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/mimetypes")
    protected List<CodeType> patchFormat;

    /**
     * A list of implementation guides that the server does (or should) support in their entirety.
     */
    @Child(name = "implementationGuide", type = {CanonicalType.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Implementation guides supported", formalDefinition="A list of implementation guides that the server does (or should) support in their entirety." )
    protected List<CanonicalType> implementationGuide;

    /**
     * A definition of the restful capabilities of the solution, if any.
     */
    @Child(name = "rest", type = {}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="If the endpoint is a RESTful one", formalDefinition="A definition of the restful capabilities of the solution, if any." )
    protected List<CapabilityStatement2RestComponent> rest;

    private static final long serialVersionUID = -242661375L;

  /**
   * Constructor
   */
    public CapabilityStatement2() {
      super();
    }

  /**
   * Constructor
   */
    public CapabilityStatement2(PublicationStatus status, Date date, CapabilityStatementKind kind, FHIRVersion fhirVersion, String format) {
      super();
      this.setStatus(status);
      this.setDate(date);
      this.setKind(kind);
      this.setFhirVersion(fhirVersion);
      this.addFormat(format);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this capability statement2 when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this capability statement2 is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement2 is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify this capability statement2 when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this capability statement2 is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement2 is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public CapabilityStatement2 setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this capability statement2 when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this capability statement2 is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement2 is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this capability statement2 when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this capability statement2 is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement2 is stored on different servers.
     */
    public CapabilityStatement2 setUrl(String value) { 
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
     * @return {@link #version} (The identifier that is used to identify this version of the capability statement2 when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement2 author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the capability statement2 when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement2 author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public CapabilityStatement2 setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the capability statement2 when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement2 author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the capability statement2 when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement2 author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public CapabilityStatement2 setVersion(String value) { 
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
     * @return {@link #name} (A natural language name identifying the capability statement2. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.name");
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
     * @param value {@link #name} (A natural language name identifying the capability statement2. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public CapabilityStatement2 setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the capability statement2. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the capability statement2. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public CapabilityStatement2 setName(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the capability statement2.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the capability statement2.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public CapabilityStatement2 setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the capability statement2.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the capability statement2.
     */
    public CapabilityStatement2 setTitle(String value) { 
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
     * @return {@link #status} (The status of this capability statement2. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.status");
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
     * @param value {@link #status} (The status of this capability statement2. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public CapabilityStatement2 setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this capability statement2. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this capability statement2. Enables tracking the life-cycle of the content.
     */
    public CapabilityStatement2 setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this capability statement2 is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.experimental");
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
     * @param value {@link #experimental} (A Boolean value to indicate that this capability statement2 is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public CapabilityStatement2 setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this capability statement2 is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this capability statement2 is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public CapabilityStatement2 setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the capability statement2 was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement2 changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the capability statement2 was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement2 changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public CapabilityStatement2 setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the capability statement2 was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement2 changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the capability statement2 was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement2 changes.
     */
    public CapabilityStatement2 setDate(Date value) { 
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      return this;
    }

    /**
     * @return {@link #publisher} (The name of the organization or individual that published the capability statement2.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.publisher");
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
     * @param value {@link #publisher} (The name of the organization or individual that published the capability statement2.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public CapabilityStatement2 setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual that published the capability statement2.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual that published the capability statement2.
     */
    public CapabilityStatement2 setPublisher(String value) { 
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
    public CapabilityStatement2 setContact(List<ContactDetail> theContact) { 
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

    public CapabilityStatement2 addContact(ContactDetail t) { //3
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
     * @return {@link #description} (A free text natural language description of the capability statement2 from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.description");
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
     * @param value {@link #description} (A free text natural language description of the capability statement2 from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public CapabilityStatement2 setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the capability statement2 from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the capability statement2 from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.
     */
    public CapabilityStatement2 setDescription(String value) { 
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate capability statement2 instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement2 setUseContext(List<UsageContext> theUseContext) { 
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

    public CapabilityStatement2 addUseContext(UsageContext t) { //3
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
     * @return {@link #jurisdiction} (A legal or geographic region in which the capability statement2 is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement2 setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public CapabilityStatement2 addJurisdiction(CodeableConcept t) { //3
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
     * @return {@link #purpose} (Explanation of why this capability statement2 is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.purpose");
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
     * @param value {@link #purpose} (Explanation of why this capability statement2 is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public CapabilityStatement2 setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this capability statement2 is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this capability statement2 is needed and why it has been designed as it has.
     */
    public CapabilityStatement2 setPurpose(String value) { 
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
     * @return {@link #copyright} (A copyright statement relating to the capability statement2 and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement2.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the capability statement2 and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement2.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public CapabilityStatement2 setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the capability statement2 and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement2.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the capability statement2 and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement2.
     */
    public CapabilityStatement2 setCopyright(String value) { 
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
     * @return {@link #kind} (The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public Enumeration<CapabilityStatementKind> getKindElement() { 
      if (this.kind == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.kind");
        else if (Configuration.doAutoCreate())
          this.kind = new Enumeration<CapabilityStatementKind>(new CapabilityStatementKindEnumFactory()); // bb
      return this.kind;
    }

    public boolean hasKindElement() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    public boolean hasKind() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    /**
     * @param value {@link #kind} (The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
     */
    public CapabilityStatement2 setKindElement(Enumeration<CapabilityStatementKind> value) { 
      this.kind = value;
      return this;
    }

    /**
     * @return The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).
     */
    public CapabilityStatementKind getKind() { 
      return this.kind == null ? null : this.kind.getValue();
    }

    /**
     * @param value The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).
     */
    public CapabilityStatement2 setKind(CapabilityStatementKind value) { 
        if (this.kind == null)
          this.kind = new Enumeration<CapabilityStatementKind>(new CapabilityStatementKindEnumFactory());
        this.kind.setValue(value);
      return this;
    }

    /**
     * @return {@link #instantiates} (Reference to a canonical URL of another CapabilityStatement2 that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.)
     */
    public List<CanonicalType> getInstantiates() { 
      if (this.instantiates == null)
        this.instantiates = new ArrayList<CanonicalType>();
      return this.instantiates;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement2 setInstantiates(List<CanonicalType> theInstantiates) { 
      this.instantiates = theInstantiates;
      return this;
    }

    public boolean hasInstantiates() { 
      if (this.instantiates == null)
        return false;
      for (CanonicalType item : this.instantiates)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiates} (Reference to a canonical URL of another CapabilityStatement2 that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.)
     */
    public CanonicalType addInstantiatesElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.instantiates == null)
        this.instantiates = new ArrayList<CanonicalType>();
      this.instantiates.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiates} (Reference to a canonical URL of another CapabilityStatement2 that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.)
     */
    public CapabilityStatement2 addInstantiates(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.instantiates == null)
        this.instantiates = new ArrayList<CanonicalType>();
      this.instantiates.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiates} (Reference to a canonical URL of another CapabilityStatement2 that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.)
     */
    public boolean hasInstantiates(String value) { 
      if (this.instantiates == null)
        return false;
      for (CanonicalType v : this.instantiates)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #imports} (Reference to a canonical URL of another CapabilityStatement2 that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.)
     */
    public List<CanonicalType> getImports() { 
      if (this.imports == null)
        this.imports = new ArrayList<CanonicalType>();
      return this.imports;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement2 setImports(List<CanonicalType> theImports) { 
      this.imports = theImports;
      return this;
    }

    public boolean hasImports() { 
      if (this.imports == null)
        return false;
      for (CanonicalType item : this.imports)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #imports} (Reference to a canonical URL of another CapabilityStatement2 that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.)
     */
    public CanonicalType addImportsElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.imports == null)
        this.imports = new ArrayList<CanonicalType>();
      this.imports.add(t);
      return t;
    }

    /**
     * @param value {@link #imports} (Reference to a canonical URL of another CapabilityStatement2 that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.)
     */
    public CapabilityStatement2 addImports(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.imports == null)
        this.imports = new ArrayList<CanonicalType>();
      this.imports.add(t);
      return this;
    }

    /**
     * @param value {@link #imports} (Reference to a canonical URL of another CapabilityStatement2 that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.)
     */
    public boolean hasImports(String value) { 
      if (this.imports == null)
        return false;
      for (CanonicalType v : this.imports)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #software} (Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation.)
     */
    public CapabilityStatement2SoftwareComponent getSoftware() { 
      if (this.software == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.software");
        else if (Configuration.doAutoCreate())
          this.software = new CapabilityStatement2SoftwareComponent(); // cc
      return this.software;
    }

    public boolean hasSoftware() { 
      return this.software != null && !this.software.isEmpty();
    }

    /**
     * @param value {@link #software} (Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation.)
     */
    public CapabilityStatement2 setSoftware(CapabilityStatement2SoftwareComponent value) { 
      this.software = value;
      return this;
    }

    /**
     * @return {@link #implementation} (Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program.)
     */
    public CapabilityStatement2ImplementationComponent getImplementation() { 
      if (this.implementation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.implementation");
        else if (Configuration.doAutoCreate())
          this.implementation = new CapabilityStatement2ImplementationComponent(); // cc
      return this.implementation;
    }

    public boolean hasImplementation() { 
      return this.implementation != null && !this.implementation.isEmpty();
    }

    /**
     * @param value {@link #implementation} (Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program.)
     */
    public CapabilityStatement2 setImplementation(CapabilityStatement2ImplementationComponent value) { 
      this.implementation = value;
      return this;
    }

    /**
     * @return {@link #fhirVersion} (The version of the FHIR specification that this CapabilityStatement2 describes (which SHALL be the same as the FHIR version of the CapabilityStatement2 itself). There is no default value.). This is the underlying object with id, value and extensions. The accessor "getFhirVersion" gives direct access to the value
     */
    public Enumeration<FHIRVersion> getFhirVersionElement() { 
      if (this.fhirVersion == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CapabilityStatement2.fhirVersion");
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
     * @param value {@link #fhirVersion} (The version of the FHIR specification that this CapabilityStatement2 describes (which SHALL be the same as the FHIR version of the CapabilityStatement2 itself). There is no default value.). This is the underlying object with id, value and extensions. The accessor "getFhirVersion" gives direct access to the value
     */
    public CapabilityStatement2 setFhirVersionElement(Enumeration<FHIRVersion> value) { 
      this.fhirVersion = value;
      return this;
    }

    /**
     * @return The version of the FHIR specification that this CapabilityStatement2 describes (which SHALL be the same as the FHIR version of the CapabilityStatement2 itself). There is no default value.
     */
    public FHIRVersion getFhirVersion() { 
      return this.fhirVersion == null ? null : this.fhirVersion.getValue();
    }

    /**
     * @param value The version of the FHIR specification that this CapabilityStatement2 describes (which SHALL be the same as the FHIR version of the CapabilityStatement2 itself). There is no default value.
     */
    public CapabilityStatement2 setFhirVersion(FHIRVersion value) { 
        if (this.fhirVersion == null)
          this.fhirVersion = new Enumeration<FHIRVersion>(new FHIRVersionEnumFactory());
        this.fhirVersion.setValue(value);
      return this;
    }

    /**
     * @return {@link #format} (A list of the formats supported by this implementation using their content types.)
     */
    public List<CodeType> getFormat() { 
      if (this.format == null)
        this.format = new ArrayList<CodeType>();
      return this.format;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement2 setFormat(List<CodeType> theFormat) { 
      this.format = theFormat;
      return this;
    }

    public boolean hasFormat() { 
      if (this.format == null)
        return false;
      for (CodeType item : this.format)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #format} (A list of the formats supported by this implementation using their content types.)
     */
    public CodeType addFormatElement() {//2 
      CodeType t = new CodeType();
      if (this.format == null)
        this.format = new ArrayList<CodeType>();
      this.format.add(t);
      return t;
    }

    /**
     * @param value {@link #format} (A list of the formats supported by this implementation using their content types.)
     */
    public CapabilityStatement2 addFormat(String value) { //1
      CodeType t = new CodeType();
      t.setValue(value);
      if (this.format == null)
        this.format = new ArrayList<CodeType>();
      this.format.add(t);
      return this;
    }

    /**
     * @param value {@link #format} (A list of the formats supported by this implementation using their content types.)
     */
    public boolean hasFormat(String value) { 
      if (this.format == null)
        return false;
      for (CodeType v : this.format)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #patchFormat} (A list of the patch formats supported by this implementation using their content types.)
     */
    public List<CodeType> getPatchFormat() { 
      if (this.patchFormat == null)
        this.patchFormat = new ArrayList<CodeType>();
      return this.patchFormat;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement2 setPatchFormat(List<CodeType> thePatchFormat) { 
      this.patchFormat = thePatchFormat;
      return this;
    }

    public boolean hasPatchFormat() { 
      if (this.patchFormat == null)
        return false;
      for (CodeType item : this.patchFormat)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #patchFormat} (A list of the patch formats supported by this implementation using their content types.)
     */
    public CodeType addPatchFormatElement() {//2 
      CodeType t = new CodeType();
      if (this.patchFormat == null)
        this.patchFormat = new ArrayList<CodeType>();
      this.patchFormat.add(t);
      return t;
    }

    /**
     * @param value {@link #patchFormat} (A list of the patch formats supported by this implementation using their content types.)
     */
    public CapabilityStatement2 addPatchFormat(String value) { //1
      CodeType t = new CodeType();
      t.setValue(value);
      if (this.patchFormat == null)
        this.patchFormat = new ArrayList<CodeType>();
      this.patchFormat.add(t);
      return this;
    }

    /**
     * @param value {@link #patchFormat} (A list of the patch formats supported by this implementation using their content types.)
     */
    public boolean hasPatchFormat(String value) { 
      if (this.patchFormat == null)
        return false;
      for (CodeType v : this.patchFormat)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #implementationGuide} (A list of implementation guides that the server does (or should) support in their entirety.)
     */
    public List<CanonicalType> getImplementationGuide() { 
      if (this.implementationGuide == null)
        this.implementationGuide = new ArrayList<CanonicalType>();
      return this.implementationGuide;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement2 setImplementationGuide(List<CanonicalType> theImplementationGuide) { 
      this.implementationGuide = theImplementationGuide;
      return this;
    }

    public boolean hasImplementationGuide() { 
      if (this.implementationGuide == null)
        return false;
      for (CanonicalType item : this.implementationGuide)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #implementationGuide} (A list of implementation guides that the server does (or should) support in their entirety.)
     */
    public CanonicalType addImplementationGuideElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.implementationGuide == null)
        this.implementationGuide = new ArrayList<CanonicalType>();
      this.implementationGuide.add(t);
      return t;
    }

    /**
     * @param value {@link #implementationGuide} (A list of implementation guides that the server does (or should) support in their entirety.)
     */
    public CapabilityStatement2 addImplementationGuide(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.implementationGuide == null)
        this.implementationGuide = new ArrayList<CanonicalType>();
      this.implementationGuide.add(t);
      return this;
    }

    /**
     * @param value {@link #implementationGuide} (A list of implementation guides that the server does (or should) support in their entirety.)
     */
    public boolean hasImplementationGuide(String value) { 
      if (this.implementationGuide == null)
        return false;
      for (CanonicalType v : this.implementationGuide)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #rest} (A definition of the restful capabilities of the solution, if any.)
     */
    public List<CapabilityStatement2RestComponent> getRest() { 
      if (this.rest == null)
        this.rest = new ArrayList<CapabilityStatement2RestComponent>();
      return this.rest;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement2 setRest(List<CapabilityStatement2RestComponent> theRest) { 
      this.rest = theRest;
      return this;
    }

    public boolean hasRest() { 
      if (this.rest == null)
        return false;
      for (CapabilityStatement2RestComponent item : this.rest)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CapabilityStatement2RestComponent addRest() { //3
      CapabilityStatement2RestComponent t = new CapabilityStatement2RestComponent();
      if (this.rest == null)
        this.rest = new ArrayList<CapabilityStatement2RestComponent>();
      this.rest.add(t);
      return t;
    }

    public CapabilityStatement2 addRest(CapabilityStatement2RestComponent t) { //3
      if (t == null)
        return this;
      if (this.rest == null)
        this.rest = new ArrayList<CapabilityStatement2RestComponent>();
      this.rest.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #rest}, creating it if it does not already exist {3}
     */
    public CapabilityStatement2RestComponent getRestFirstRep() { 
      if (getRest().isEmpty()) {
        addRest();
      }
      return getRest().get(0);
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getIdentifierMax() { 
      return 0;
    }
    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this capability statement2 when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CapabilityStatement2 setIdentifier(List<Identifier> theIdentifier) { 
      throw new Error("The resource type \"CapabilityStatement2\" does not implement the property \"identifier\"");
    }
    public boolean hasIdentifier() { 
      return false;
    }

    public Identifier addIdentifier() { //3
      throw new Error("The resource type \"CapabilityStatement2\" does not implement the property \"identifier\"");
    }
    public CapabilityStatement2 addIdentifier(Identifier t) { //3
      throw new Error("The resource type \"CapabilityStatement2\" does not implement the property \"identifier\"");
    }
    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {2}
     */
    public Identifier getIdentifierFirstRep() { 
      throw new Error("The resource type \"CapabilityStatement2\" does not implement the property \"identifier\"");
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this capability statement2 when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this capability statement2 is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement2 is stored on different servers.", 0, 1, url));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the capability statement2 when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement2 author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the capability statement2. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the capability statement2.", 0, 1, title));
        children.add(new Property("status", "code", "The status of this capability statement2. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this capability statement2 is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the capability statement2 was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement2 changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual that published the capability statement2.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the capability statement2 from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate capability statement2 instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the capability statement2 is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this capability statement2 is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the capability statement2 and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement2.", 0, 1, copyright));
        children.add(new Property("kind", "code", "The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).", 0, 1, kind));
        children.add(new Property("instantiates", "canonical(CapabilityStatement2)", "Reference to a canonical URL of another CapabilityStatement2 that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.", 0, java.lang.Integer.MAX_VALUE, instantiates));
        children.add(new Property("imports", "canonical(CapabilityStatement2)", "Reference to a canonical URL of another CapabilityStatement2 that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.", 0, java.lang.Integer.MAX_VALUE, imports));
        children.add(new Property("software", "", "Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation.", 0, 1, software));
        children.add(new Property("implementation", "", "Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program.", 0, 1, implementation));
        children.add(new Property("fhirVersion", "code", "The version of the FHIR specification that this CapabilityStatement2 describes (which SHALL be the same as the FHIR version of the CapabilityStatement2 itself). There is no default value.", 0, 1, fhirVersion));
        children.add(new Property("format", "code", "A list of the formats supported by this implementation using their content types.", 0, java.lang.Integer.MAX_VALUE, format));
        children.add(new Property("patchFormat", "code", "A list of the patch formats supported by this implementation using their content types.", 0, java.lang.Integer.MAX_VALUE, patchFormat));
        children.add(new Property("implementationGuide", "canonical(ImplementationGuide)", "A list of implementation guides that the server does (or should) support in their entirety.", 0, java.lang.Integer.MAX_VALUE, implementationGuide));
        children.add(new Property("rest", "", "A definition of the restful capabilities of the solution, if any.", 0, java.lang.Integer.MAX_VALUE, rest));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this capability statement2 when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this capability statement2 is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the capability statement2 is stored on different servers.", 0, 1, url);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the capability statement2 when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the capability statement2 author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the capability statement2. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the capability statement2.", 0, 1, title);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this capability statement2. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this capability statement2 is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the capability statement2 was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the capability statement2 changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual that published the capability statement2.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the capability statement2 from a consumer's perspective. Typically, this is used when the capability statement describes a desired rather than an actual solution, for example as a formal expression of requirements as part of an RFP.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate capability statement2 instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the capability statement2 is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this capability statement2 is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the capability statement2 and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the capability statement2.", 0, 1, copyright);
        case 3292052: /*kind*/  return new Property("kind", "code", "The way that this statement is intended to be used, to describe an actual running instance of software, a particular product (kind, not instance of software) or a class of implementation (e.g. a desired purchase).", 0, 1, kind);
        case -246883639: /*instantiates*/  return new Property("instantiates", "canonical(CapabilityStatement2)", "Reference to a canonical URL of another CapabilityStatement2 that this software implements. This capability statement is a published API description that corresponds to a business service. The server may actually implement a subset of the capability statement it claims to implement, so the capability statement must specify the full capability details.", 0, java.lang.Integer.MAX_VALUE, instantiates);
        case 1926037870: /*imports*/  return new Property("imports", "canonical(CapabilityStatement2)", "Reference to a canonical URL of another CapabilityStatement2 that this software adds to. The capability statement automatically includes everything in the other statement, and it is not duplicated, though the server may repeat the same resources, interactions and operations to add additional details to them.", 0, java.lang.Integer.MAX_VALUE, imports);
        case 1319330215: /*software*/  return new Property("software", "", "Software that is covered by this capability statement.  It is used when the capability statement describes the capabilities of a particular software version, independent of an installation.", 0, 1, software);
        case 1683336114: /*implementation*/  return new Property("implementation", "", "Identifies a specific implementation instance that is described by the capability statement - i.e. a particular installation, rather than the capabilities of a software program.", 0, 1, implementation);
        case 461006061: /*fhirVersion*/  return new Property("fhirVersion", "code", "The version of the FHIR specification that this CapabilityStatement2 describes (which SHALL be the same as the FHIR version of the CapabilityStatement2 itself). There is no default value.", 0, 1, fhirVersion);
        case -1268779017: /*format*/  return new Property("format", "code", "A list of the formats supported by this implementation using their content types.", 0, java.lang.Integer.MAX_VALUE, format);
        case 172338783: /*patchFormat*/  return new Property("patchFormat", "code", "A list of the patch formats supported by this implementation using their content types.", 0, java.lang.Integer.MAX_VALUE, patchFormat);
        case 156966506: /*implementationGuide*/  return new Property("implementationGuide", "canonical(ImplementationGuide)", "A list of implementation guides that the server does (or should) support in their entirety.", 0, java.lang.Integer.MAX_VALUE, implementationGuide);
        case 3496916: /*rest*/  return new Property("rest", "", "A definition of the restful capabilities of the solution, if any.", 0, java.lang.Integer.MAX_VALUE, rest);
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
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 3292052: /*kind*/ return this.kind == null ? new Base[0] : new Base[] {this.kind}; // Enumeration<CapabilityStatementKind>
        case -246883639: /*instantiates*/ return this.instantiates == null ? new Base[0] : this.instantiates.toArray(new Base[this.instantiates.size()]); // CanonicalType
        case 1926037870: /*imports*/ return this.imports == null ? new Base[0] : this.imports.toArray(new Base[this.imports.size()]); // CanonicalType
        case 1319330215: /*software*/ return this.software == null ? new Base[0] : new Base[] {this.software}; // CapabilityStatement2SoftwareComponent
        case 1683336114: /*implementation*/ return this.implementation == null ? new Base[0] : new Base[] {this.implementation}; // CapabilityStatement2ImplementationComponent
        case 461006061: /*fhirVersion*/ return this.fhirVersion == null ? new Base[0] : new Base[] {this.fhirVersion}; // Enumeration<FHIRVersion>
        case -1268779017: /*format*/ return this.format == null ? new Base[0] : this.format.toArray(new Base[this.format.size()]); // CodeType
        case 172338783: /*patchFormat*/ return this.patchFormat == null ? new Base[0] : this.patchFormat.toArray(new Base[this.patchFormat.size()]); // CodeType
        case 156966506: /*implementationGuide*/ return this.implementationGuide == null ? new Base[0] : this.implementationGuide.toArray(new Base[this.implementationGuide.size()]); // CanonicalType
        case 3496916: /*rest*/ return this.rest == null ? new Base[0] : this.rest.toArray(new Base[this.rest.size()]); // CapabilityStatement2RestComponent
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
        case 3292052: // kind
          value = new CapabilityStatementKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<CapabilityStatementKind>
          return value;
        case -246883639: // instantiates
          this.getInstantiates().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 1926037870: // imports
          this.getImports().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 1319330215: // software
          this.software = (CapabilityStatement2SoftwareComponent) value; // CapabilityStatement2SoftwareComponent
          return value;
        case 1683336114: // implementation
          this.implementation = (CapabilityStatement2ImplementationComponent) value; // CapabilityStatement2ImplementationComponent
          return value;
        case 461006061: // fhirVersion
          value = new FHIRVersionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.fhirVersion = (Enumeration) value; // Enumeration<FHIRVersion>
          return value;
        case -1268779017: // format
          this.getFormat().add(TypeConvertor.castToCode(value)); // CodeType
          return value;
        case 172338783: // patchFormat
          this.getPatchFormat().add(TypeConvertor.castToCode(value)); // CodeType
          return value;
        case 156966506: // implementationGuide
          this.getImplementationGuide().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 3496916: // rest
          this.getRest().add((CapabilityStatement2RestComponent) value); // CapabilityStatement2RestComponent
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
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactDetail(value));
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
        } else if (name.equals("kind")) {
          value = new CapabilityStatementKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<CapabilityStatementKind>
        } else if (name.equals("instantiates")) {
          this.getInstantiates().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("imports")) {
          this.getImports().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("software")) {
          this.software = (CapabilityStatement2SoftwareComponent) value; // CapabilityStatement2SoftwareComponent
        } else if (name.equals("implementation")) {
          this.implementation = (CapabilityStatement2ImplementationComponent) value; // CapabilityStatement2ImplementationComponent
        } else if (name.equals("fhirVersion")) {
          value = new FHIRVersionEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.fhirVersion = (Enumeration) value; // Enumeration<FHIRVersion>
        } else if (name.equals("format")) {
          this.getFormat().add(TypeConvertor.castToCode(value));
        } else if (name.equals("patchFormat")) {
          this.getPatchFormat().add(TypeConvertor.castToCode(value));
        } else if (name.equals("implementationGuide")) {
          this.getImplementationGuide().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("rest")) {
          this.getRest().add((CapabilityStatement2RestComponent) value);
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
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 3292052:  return getKindElement();
        case -246883639:  return addInstantiatesElement();
        case 1926037870:  return addImportsElement();
        case 1319330215:  return getSoftware();
        case 1683336114:  return getImplementation();
        case 461006061:  return getFhirVersionElement();
        case -1268779017:  return addFormatElement();
        case 172338783:  return addPatchFormatElement();
        case 156966506:  return addImplementationGuideElement();
        case 3496916:  return addRest(); 
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
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 3292052: /*kind*/ return new String[] {"code"};
        case -246883639: /*instantiates*/ return new String[] {"canonical"};
        case 1926037870: /*imports*/ return new String[] {"canonical"};
        case 1319330215: /*software*/ return new String[] {};
        case 1683336114: /*implementation*/ return new String[] {};
        case 461006061: /*fhirVersion*/ return new String[] {"code"};
        case -1268779017: /*format*/ return new String[] {"code"};
        case 172338783: /*patchFormat*/ return new String[] {"code"};
        case 156966506: /*implementationGuide*/ return new String[] {"canonical"};
        case 3496916: /*rest*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.url");
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.title");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.copyright");
        }
        else if (name.equals("kind")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.kind");
        }
        else if (name.equals("instantiates")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.instantiates");
        }
        else if (name.equals("imports")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.imports");
        }
        else if (name.equals("software")) {
          this.software = new CapabilityStatement2SoftwareComponent();
          return this.software;
        }
        else if (name.equals("implementation")) {
          this.implementation = new CapabilityStatement2ImplementationComponent();
          return this.implementation;
        }
        else if (name.equals("fhirVersion")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.fhirVersion");
        }
        else if (name.equals("format")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.format");
        }
        else if (name.equals("patchFormat")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.patchFormat");
        }
        else if (name.equals("implementationGuide")) {
          throw new FHIRException("Cannot call addChild on a primitive type CapabilityStatement2.implementationGuide");
        }
        else if (name.equals("rest")) {
          return addRest();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CapabilityStatement2";

  }

      public CapabilityStatement2 copy() {
        CapabilityStatement2 dst = new CapabilityStatement2();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CapabilityStatement2 dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
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
        };
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
        dst.kind = kind == null ? null : kind.copy();
        if (instantiates != null) {
          dst.instantiates = new ArrayList<CanonicalType>();
          for (CanonicalType i : instantiates)
            dst.instantiates.add(i.copy());
        };
        if (imports != null) {
          dst.imports = new ArrayList<CanonicalType>();
          for (CanonicalType i : imports)
            dst.imports.add(i.copy());
        };
        dst.software = software == null ? null : software.copy();
        dst.implementation = implementation == null ? null : implementation.copy();
        dst.fhirVersion = fhirVersion == null ? null : fhirVersion.copy();
        if (format != null) {
          dst.format = new ArrayList<CodeType>();
          for (CodeType i : format)
            dst.format.add(i.copy());
        };
        if (patchFormat != null) {
          dst.patchFormat = new ArrayList<CodeType>();
          for (CodeType i : patchFormat)
            dst.patchFormat.add(i.copy());
        };
        if (implementationGuide != null) {
          dst.implementationGuide = new ArrayList<CanonicalType>();
          for (CanonicalType i : implementationGuide)
            dst.implementationGuide.add(i.copy());
        };
        if (rest != null) {
          dst.rest = new ArrayList<CapabilityStatement2RestComponent>();
          for (CapabilityStatement2RestComponent i : rest)
            dst.rest.add(i.copy());
        };
      }

      protected CapabilityStatement2 typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2))
          return false;
        CapabilityStatement2 o = (CapabilityStatement2) other_;
        return compareDeep(url, o.url, true) && compareDeep(version, o.version, true) && compareDeep(name, o.name, true)
           && compareDeep(title, o.title, true) && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true)
           && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true)
           && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(kind, o.kind, true) && compareDeep(instantiates, o.instantiates, true) && compareDeep(imports, o.imports, true)
           && compareDeep(software, o.software, true) && compareDeep(implementation, o.implementation, true)
           && compareDeep(fhirVersion, o.fhirVersion, true) && compareDeep(format, o.format, true) && compareDeep(patchFormat, o.patchFormat, true)
           && compareDeep(implementationGuide, o.implementationGuide, true) && compareDeep(rest, o.rest, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CapabilityStatement2))
          return false;
        CapabilityStatement2 o = (CapabilityStatement2) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true)
           && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true) && compareValues(kind, o.kind, true)
           && compareValues(instantiates, o.instantiates, true) && compareValues(imports, o.imports, true) && compareValues(fhirVersion, o.fhirVersion, true)
           && compareValues(format, o.format, true) && compareValues(patchFormat, o.patchFormat, true) && compareValues(implementationGuide, o.implementationGuide, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, version, name, title
          , status, experimental, date, publisher, contact, description, useContext, jurisdiction
          , purpose, copyright, kind, instantiates, imports, software, implementation, fhirVersion
          , format, patchFormat, implementationGuide, rest);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.CapabilityStatement2;
   }

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the capability statement2</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(CapabilityStatement2.useContext.value as Quantity) | (CapabilityStatement2.useContext.value as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(CapabilityStatement2.useContext.value as Quantity) | (CapabilityStatement2.useContext.value as Range)", description="A quantity- or range-valued use context assigned to the capability statement2", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the capability statement2</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(CapabilityStatement2.useContext.value as Quantity) | (CapabilityStatement2.useContext.value as Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the capability statement2</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>CapabilityStatement2.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="CapabilityStatement2.useContext", description="A use context type and quantity- or range-based value assigned to the capability statement2", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the capability statement2</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>CapabilityStatement2.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the capability statement2</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>CapabilityStatement2.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="CapabilityStatement2.useContext", description="A use context type and value assigned to the capability statement2", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the capability statement2</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>CapabilityStatement2.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the capability statement2</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="CapabilityStatement2.useContext.code", description="A type of use context assigned to the capability statement2", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the capability statement2</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the capability statement2</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(CapabilityStatement2.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(CapabilityStatement2.useContext.value as CodeableConcept)", description="A use context assigned to the capability statement2", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the capability statement2</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(CapabilityStatement2.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The capability statement2 publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CapabilityStatement2.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="CapabilityStatement2.date", description="The capability statement2 publication date", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The capability statement2 publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CapabilityStatement2.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>The description of the capability statement2</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement2.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="CapabilityStatement2.description", description="The description of the capability statement2", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>The description of the capability statement2</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement2.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>fhirversion</b>
   * <p>
   * Description: <b>The version of FHIR</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="fhirversion", path="CapabilityStatement2.version", description="The version of FHIR", type="token" )
  public static final String SP_FHIRVERSION = "fhirversion";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>fhirversion</b>
   * <p>
   * Description: <b>The version of FHIR</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FHIRVERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FHIRVERSION);

 /**
   * Search parameter: <b>format</b>
   * <p>
   * Description: <b>formats supported (xml | json | ttl | mime type)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.format</b><br>
   * </p>
   */
  @SearchParamDefinition(name="format", path="CapabilityStatement2.format", description="formats supported (xml | json | ttl | mime type)", type="token" )
  public static final String SP_FORMAT = "format";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>format</b>
   * <p>
   * Description: <b>formats supported (xml | json | ttl | mime type)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.format</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FORMAT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FORMAT);

 /**
   * Search parameter: <b>guide</b>
   * <p>
   * Description: <b>Implementation guides supported</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement2.implementationGuide</b><br>
   * </p>
   */
  @SearchParamDefinition(name="guide", path="CapabilityStatement2.implementationGuide", description="Implementation guides supported", type="reference", target={ImplementationGuide.class } )
  public static final String SP_GUIDE = "guide";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>guide</b>
   * <p>
   * Description: <b>Implementation guides supported</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement2.implementationGuide</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam GUIDE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_GUIDE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CapabilityStatement2:guide</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_GUIDE = new ca.uhn.fhir.model.api.Include("CapabilityStatement2:guide").toLocked();

 /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the capability statement2</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name="jurisdiction", path="CapabilityStatement2.jurisdiction", description="Intended jurisdiction for the capability statement2", type="token" )
  public static final String SP_JURISDICTION = "jurisdiction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Intended jurisdiction for the capability statement2</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_JURISDICTION);

 /**
   * Search parameter: <b>mode</b>
   * <p>
   * Description: <b>Mode - restful (server/client) or messaging (sender/receiver)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.rest.mode</b><br>
   * </p>
   */
  @SearchParamDefinition(name="mode", path="CapabilityStatement2.rest.mode", description="Mode - restful (server/client) or messaging (sender/receiver)", type="token" )
  public static final String SP_MODE = "mode";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>mode</b>
   * <p>
   * Description: <b>Mode - restful (server/client) or messaging (sender/receiver)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.rest.mode</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam MODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_MODE);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the capability statement2</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement2.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="CapabilityStatement2.name", description="Computationally friendly name of the capability statement2", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Computationally friendly name of the capability statement2</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement2.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the capability statement2</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement2.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="CapabilityStatement2.publisher", description="Name of the publisher of the capability statement2", type="string" )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the capability statement2</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement2.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PUBLISHER);

 /**
   * Search parameter: <b>resource-profile</b>
   * <p>
   * Description: <b>A profile id invoked in a capability statement</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement2.rest.resource.profile</b><br>
   * </p>
   */
  @SearchParamDefinition(name="resource-profile", path="CapabilityStatement2.rest.resource.profile", description="A profile id invoked in a capability statement", type="reference", target={StructureDefinition.class } )
  public static final String SP_RESOURCE_PROFILE = "resource-profile";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>resource-profile</b>
   * <p>
   * Description: <b>A profile id invoked in a capability statement</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement2.rest.resource.profile</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RESOURCE_PROFILE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RESOURCE_PROFILE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CapabilityStatement2:resource-profile</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RESOURCE_PROFILE = new ca.uhn.fhir.model.api.Include("CapabilityStatement2:resource-profile").toLocked();

 /**
   * Search parameter: <b>resource</b>
   * <p>
   * Description: <b>Name of a resource mentioned in a capability statement</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.rest.resource.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="resource", path="CapabilityStatement2.rest.resource.type", description="Name of a resource mentioned in a capability statement", type="token" )
  public static final String SP_RESOURCE = "resource";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>resource</b>
   * <p>
   * Description: <b>Name of a resource mentioned in a capability statement</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.rest.resource.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam RESOURCE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_RESOURCE);

 /**
   * Search parameter: <b>software</b>
   * <p>
   * Description: <b>Part of the name of a software application</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement2.software.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="software", path="CapabilityStatement2.software.name", description="Part of the name of a software application", type="string" )
  public static final String SP_SOFTWARE = "software";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>software</b>
   * <p>
   * Description: <b>Part of the name of a software application</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement2.software.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam SOFTWARE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_SOFTWARE);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the capability statement2</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="CapabilityStatement2.status", description="The current status of the capability statement2", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the capability statement2</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>supported-profile</b>
   * <p>
   * Description: <b>Profiles for use cases supported</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement2.rest.resource.supportedProfile</b><br>
   * </p>
   */
  @SearchParamDefinition(name="supported-profile", path="CapabilityStatement2.rest.resource.supportedProfile", description="Profiles for use cases supported", type="reference", target={StructureDefinition.class } )
  public static final String SP_SUPPORTED_PROFILE = "supported-profile";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>supported-profile</b>
   * <p>
   * Description: <b>Profiles for use cases supported</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CapabilityStatement2.rest.resource.supportedProfile</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUPPORTED_PROFILE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUPPORTED_PROFILE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CapabilityStatement2:supported-profile</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUPPORTED_PROFILE = new ca.uhn.fhir.model.api.Include("CapabilityStatement2:supported-profile").toLocked();

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the capability statement2</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement2.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="CapabilityStatement2.title", description="The human-friendly name of the capability statement2", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the capability statement2</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CapabilityStatement2.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the capability statement2</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>CapabilityStatement2.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="CapabilityStatement2.url", description="The uri that identifies the capability statement2", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the capability statement2</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>CapabilityStatement2.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version of the capability statement2</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="CapabilityStatement2.version", description="The business version of the capability statement2", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version of the capability statement2</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CapabilityStatement2.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);


}