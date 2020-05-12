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
 * The regulatory authorization of a medicinal product, device or process.
 */
@ResourceDef(name="RegulatedAuthorization", profile="http://hl7.org/fhir/StructureDefinition/RegulatedAuthorization")
public class RegulatedAuthorization extends DomainResource {

    @Block()
    public static class RegulatedAuthorizationRelatedDateComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Another date associated with the authorization.
         */
        @Child(name = "date", type = {Period.class, DateTimeType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Another date associated with the authorization", formalDefinition="Another date associated with the authorization." )
        protected DataType date;

        /**
         * Type of this date, for example the data exclusitity period for a medicinal product.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of this date, for example the data exclusitity period for a medicinal product", formalDefinition="Type of this date, for example the data exclusitity period for a medicinal product." )
        protected CodeableConcept type;

        private static final long serialVersionUID = 950845613L;

    /**
     * Constructor
     */
      public RegulatedAuthorizationRelatedDateComponent() {
        super();
      }

    /**
     * Constructor
     */
      public RegulatedAuthorizationRelatedDateComponent(DataType date, CodeableConcept type) {
        super();
        this.setDate(date);
        this.setType(type);
      }

        /**
         * @return {@link #date} (Another date associated with the authorization.)
         */
        public DataType getDate() { 
          return this.date;
        }

        /**
         * @return {@link #date} (Another date associated with the authorization.)
         */
        public Period getDatePeriod() throws FHIRException { 
          if (this.date == null)
            this.date = new Period();
          if (!(this.date instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.date.getClass().getName()+" was encountered");
          return (Period) this.date;
        }

        public boolean hasDatePeriod() { 
          return this != null && this.date instanceof Period;
        }

        /**
         * @return {@link #date} (Another date associated with the authorization.)
         */
        public DateTimeType getDateDateTimeType() throws FHIRException { 
          if (this.date == null)
            this.date = new DateTimeType();
          if (!(this.date instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.date.getClass().getName()+" was encountered");
          return (DateTimeType) this.date;
        }

        public boolean hasDateDateTimeType() { 
          return this != null && this.date instanceof DateTimeType;
        }

        public boolean hasDate() { 
          return this.date != null && !this.date.isEmpty();
        }

        /**
         * @param value {@link #date} (Another date associated with the authorization.)
         */
        public RegulatedAuthorizationRelatedDateComponent setDate(DataType value) { 
          if (value != null && !(value instanceof Period || value instanceof DateTimeType))
            throw new Error("Not the right type for RegulatedAuthorization.relatedDate.date[x]: "+value.fhirType());
          this.date = value;
          return this;
        }

        /**
         * @return {@link #type} (Type of this date, for example the data exclusitity period for a medicinal product.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RegulatedAuthorizationRelatedDateComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Type of this date, for example the data exclusitity period for a medicinal product.)
         */
        public RegulatedAuthorizationRelatedDateComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("date[x]", "Period|dateTime", "Another date associated with the authorization.", 0, 1, date));
          children.add(new Property("type", "CodeableConcept", "Type of this date, for example the data exclusitity period for a medicinal product.", 0, 1, type));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1443311122: /*date[x]*/  return new Property("date[x]", "Period|dateTime", "Another date associated with the authorization.", 0, 1, date);
          case 3076014: /*date*/  return new Property("date[x]", "Period|dateTime", "Another date associated with the authorization.", 0, 1, date);
          case 432297743: /*datePeriod*/  return new Property("date[x]", "Period", "Another date associated with the authorization.", 0, 1, date);
          case 185136489: /*dateDateTime*/  return new Property("date[x]", "dateTime", "Another date associated with the authorization.", 0, 1, date);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Type of this date, for example the data exclusitity period for a medicinal product.", 0, 1, type);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DataType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3076014: // date
          this.date = TypeConvertor.castToType(value); // DataType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("date[x]")) {
          this.date = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1443311122:  return getDate();
        case 3076014:  return getDate();
        case 3575610:  return getType();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3076014: /*date*/ return new String[] {"Period", "dateTime"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("datePeriod")) {
          this.date = new Period();
          return this.date;
        }
        else if (name.equals("dateDateTime")) {
          this.date = new DateTimeType();
          return this.date;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else
          return super.addChild(name);
      }

      public RegulatedAuthorizationRelatedDateComponent copy() {
        RegulatedAuthorizationRelatedDateComponent dst = new RegulatedAuthorizationRelatedDateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RegulatedAuthorizationRelatedDateComponent dst) {
        super.copyValues(dst);
        dst.date = date == null ? null : date.copy();
        dst.type = type == null ? null : type.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RegulatedAuthorizationRelatedDateComponent))
          return false;
        RegulatedAuthorizationRelatedDateComponent o = (RegulatedAuthorizationRelatedDateComponent) other_;
        return compareDeep(date, o.date, true) && compareDeep(type, o.type, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RegulatedAuthorizationRelatedDateComponent))
          return false;
        RegulatedAuthorizationRelatedDateComponent o = (RegulatedAuthorizationRelatedDateComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(date, type);
      }

  public String fhirType() {
    return "RegulatedAuthorization.relatedDate";

  }

  }

    @Block()
    public static class RegulatedAuthorizationCaseComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifier by which this case can be referenced.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Identifier by which this case can be referenced", formalDefinition="Identifier by which this case can be referenced." )
        protected Identifier identifier;

        /**
         * The defining type of case.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The defining type of case", formalDefinition="The defining type of case." )
        protected CodeableConcept type;

        /**
         * The status associated with the case.
         */
        @Child(name = "status", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The status associated with the case", formalDefinition="The status associated with the case." )
        protected CodeableConcept status;

        /**
         * Relevant date for this of case.
         */
        @Child(name = "date", type = {Period.class, DateTimeType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Relevant date for this of case", formalDefinition="Relevant date for this of case." )
        protected DataType date;

        /**
         * Applcations submitted to obtain a marketing authorization. Steps within the longer running case or procedure.
         */
        @Child(name = "application", type = {RegulatedAuthorizationCaseComponent.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Applcations submitted to obtain a marketing authorization. Steps within the longer running case or procedure", formalDefinition="Applcations submitted to obtain a marketing authorization. Steps within the longer running case or procedure." )
        protected List<RegulatedAuthorizationCaseComponent> application;

        private static final long serialVersionUID = 2052202113L;

    /**
     * Constructor
     */
      public RegulatedAuthorizationCaseComponent() {
        super();
      }

        /**
         * @return {@link #identifier} (Identifier by which this case can be referenced.)
         */
        public Identifier getIdentifier() { 
          if (this.identifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RegulatedAuthorizationCaseComponent.identifier");
            else if (Configuration.doAutoCreate())
              this.identifier = new Identifier(); // cc
          return this.identifier;
        }

        public boolean hasIdentifier() { 
          return this.identifier != null && !this.identifier.isEmpty();
        }

        /**
         * @param value {@link #identifier} (Identifier by which this case can be referenced.)
         */
        public RegulatedAuthorizationCaseComponent setIdentifier(Identifier value) { 
          this.identifier = value;
          return this;
        }

        /**
         * @return {@link #type} (The defining type of case.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RegulatedAuthorizationCaseComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The defining type of case.)
         */
        public RegulatedAuthorizationCaseComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #status} (The status associated with the case.)
         */
        public CodeableConcept getStatus() { 
          if (this.status == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RegulatedAuthorizationCaseComponent.status");
            else if (Configuration.doAutoCreate())
              this.status = new CodeableConcept(); // cc
          return this.status;
        }

        public boolean hasStatus() { 
          return this.status != null && !this.status.isEmpty();
        }

        /**
         * @param value {@link #status} (The status associated with the case.)
         */
        public RegulatedAuthorizationCaseComponent setStatus(CodeableConcept value) { 
          this.status = value;
          return this;
        }

        /**
         * @return {@link #date} (Relevant date for this of case.)
         */
        public DataType getDate() { 
          return this.date;
        }

        /**
         * @return {@link #date} (Relevant date for this of case.)
         */
        public Period getDatePeriod() throws FHIRException { 
          if (this.date == null)
            this.date = new Period();
          if (!(this.date instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.date.getClass().getName()+" was encountered");
          return (Period) this.date;
        }

        public boolean hasDatePeriod() { 
          return this != null && this.date instanceof Period;
        }

        /**
         * @return {@link #date} (Relevant date for this of case.)
         */
        public DateTimeType getDateDateTimeType() throws FHIRException { 
          if (this.date == null)
            this.date = new DateTimeType();
          if (!(this.date instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.date.getClass().getName()+" was encountered");
          return (DateTimeType) this.date;
        }

        public boolean hasDateDateTimeType() { 
          return this != null && this.date instanceof DateTimeType;
        }

        public boolean hasDate() { 
          return this.date != null && !this.date.isEmpty();
        }

        /**
         * @param value {@link #date} (Relevant date for this of case.)
         */
        public RegulatedAuthorizationCaseComponent setDate(DataType value) { 
          if (value != null && !(value instanceof Period || value instanceof DateTimeType))
            throw new Error("Not the right type for RegulatedAuthorization.case.date[x]: "+value.fhirType());
          this.date = value;
          return this;
        }

        /**
         * @return {@link #application} (Applcations submitted to obtain a marketing authorization. Steps within the longer running case or procedure.)
         */
        public List<RegulatedAuthorizationCaseComponent> getApplication() { 
          if (this.application == null)
            this.application = new ArrayList<RegulatedAuthorizationCaseComponent>();
          return this.application;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RegulatedAuthorizationCaseComponent setApplication(List<RegulatedAuthorizationCaseComponent> theApplication) { 
          this.application = theApplication;
          return this;
        }

        public boolean hasApplication() { 
          if (this.application == null)
            return false;
          for (RegulatedAuthorizationCaseComponent item : this.application)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RegulatedAuthorizationCaseComponent addApplication() { //3
          RegulatedAuthorizationCaseComponent t = new RegulatedAuthorizationCaseComponent();
          if (this.application == null)
            this.application = new ArrayList<RegulatedAuthorizationCaseComponent>();
          this.application.add(t);
          return t;
        }

        public RegulatedAuthorizationCaseComponent addApplication(RegulatedAuthorizationCaseComponent t) { //3
          if (t == null)
            return this;
          if (this.application == null)
            this.application = new ArrayList<RegulatedAuthorizationCaseComponent>();
          this.application.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #application}, creating it if it does not already exist {3}
         */
        public RegulatedAuthorizationCaseComponent getApplicationFirstRep() { 
          if (getApplication().isEmpty()) {
            addApplication();
          }
          return getApplication().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "Identifier by which this case can be referenced.", 0, 1, identifier));
          children.add(new Property("type", "CodeableConcept", "The defining type of case.", 0, 1, type));
          children.add(new Property("status", "CodeableConcept", "The status associated with the case.", 0, 1, status));
          children.add(new Property("date[x]", "Period|dateTime", "Relevant date for this of case.", 0, 1, date));
          children.add(new Property("application", "@RegulatedAuthorization.case", "Applcations submitted to obtain a marketing authorization. Steps within the longer running case or procedure.", 0, java.lang.Integer.MAX_VALUE, application));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier by which this case can be referenced.", 0, 1, identifier);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The defining type of case.", 0, 1, type);
          case -892481550: /*status*/  return new Property("status", "CodeableConcept", "The status associated with the case.", 0, 1, status);
          case 1443311122: /*date[x]*/  return new Property("date[x]", "Period|dateTime", "Relevant date for this of case.", 0, 1, date);
          case 3076014: /*date*/  return new Property("date[x]", "Period|dateTime", "Relevant date for this of case.", 0, 1, date);
          case 432297743: /*datePeriod*/  return new Property("date[x]", "Period", "Relevant date for this of case.", 0, 1, date);
          case 185136489: /*dateDateTime*/  return new Property("date[x]", "dateTime", "Relevant date for this of case.", 0, 1, date);
          case 1554253136: /*application*/  return new Property("application", "@RegulatedAuthorization.case", "Applcations submitted to obtain a marketing authorization. Steps within the longer running case or procedure.", 0, java.lang.Integer.MAX_VALUE, application);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DataType
        case 1554253136: /*application*/ return this.application == null ? new Base[0] : this.application.toArray(new Base[this.application.size()]); // RegulatedAuthorizationCaseComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToType(value); // DataType
          return value;
        case 1554253136: // application
          this.getApplication().add((RegulatedAuthorizationCaseComponent) value); // RegulatedAuthorizationCaseComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("date[x]")) {
          this.date = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("application")) {
          this.getApplication().add((RegulatedAuthorizationCaseComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return getIdentifier();
        case 3575610:  return getType();
        case -892481550:  return getStatus();
        case 1443311122:  return getDate();
        case 3076014:  return getDate();
        case 1554253136:  return addApplication(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case 3076014: /*date*/ return new String[] {"Period", "dateTime"};
        case 1554253136: /*application*/ return new String[] {"@RegulatedAuthorization.case"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("datePeriod")) {
          this.date = new Period();
          return this.date;
        }
        else if (name.equals("dateDateTime")) {
          this.date = new DateTimeType();
          return this.date;
        }
        else if (name.equals("application")) {
          return addApplication();
        }
        else
          return super.addChild(name);
      }

      public RegulatedAuthorizationCaseComponent copy() {
        RegulatedAuthorizationCaseComponent dst = new RegulatedAuthorizationCaseComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RegulatedAuthorizationCaseComponent dst) {
        super.copyValues(dst);
        dst.identifier = identifier == null ? null : identifier.copy();
        dst.type = type == null ? null : type.copy();
        dst.status = status == null ? null : status.copy();
        dst.date = date == null ? null : date.copy();
        if (application != null) {
          dst.application = new ArrayList<RegulatedAuthorizationCaseComponent>();
          for (RegulatedAuthorizationCaseComponent i : application)
            dst.application.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RegulatedAuthorizationCaseComponent))
          return false;
        RegulatedAuthorizationCaseComponent o = (RegulatedAuthorizationCaseComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(type, o.type, true) && compareDeep(status, o.status, true)
           && compareDeep(date, o.date, true) && compareDeep(application, o.application, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RegulatedAuthorizationCaseComponent))
          return false;
        RegulatedAuthorizationCaseComponent o = (RegulatedAuthorizationCaseComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, type, status
          , date, application);
      }

  public String fhirType() {
    return "RegulatedAuthorization.case";

  }

  }

    /**
     * Business identifier for the authorization, typically assigned by the authorizing body.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for the authorization, typically assigned by the authorizing body", formalDefinition="Business identifier for the authorization, typically assigned by the authorizing body." )
    protected List<Identifier> identifier;

    /**
     * The type of product or service that is being authorized.
     */
    @Child(name = "subject", type = {MedicinalProductDefinition.class, PackagedProductDefinition.class, DeviceDefinition.class, ResearchStudy.class, ActivityDefinition.class, PlanDefinition.class, ObservationDefinition.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The type of product or service that is being authorized", formalDefinition="The type of product or service that is being authorized." )
    protected Reference subject;

    /**
     * Overall type of this authorization, for example drug marketing approval, orphan drug designation.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Overall type of this authorization, for example drug marketing approval, orphan drug designation", formalDefinition="Overall type of this authorization, for example drug marketing approval, orphan drug designation." )
    protected CodeableConcept type;

    /**
     * General textual supporting information.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="General textual supporting information", formalDefinition="General textual supporting information." )
    protected MarkdownType description;

    /**
     * The region (country, jurisdiction etc.) in which the marketing authorization has been granted.
     */
    @Child(name = "region", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The region (country, jurisdiction etc.) in which the marketing authorization has been granted", formalDefinition="The region (country, jurisdiction etc.) in which the marketing authorization has been granted." )
    protected List<CodeableConcept> region;

    /**
     * The status that is authorised e.g. approved. Intermediate states can be tracked with cases and applications.
     */
    @Child(name = "status", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The status that is authorised e.g. approved. Intermediate states can be tracked with cases and applications", formalDefinition="The status that is authorised e.g. approved. Intermediate states can be tracked with cases and applications." )
    protected CodeableConcept status;

    /**
     * The date at which the given status became applicable.
     */
    @Child(name = "statusDate", type = {DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The date at which the given status became applicable", formalDefinition="The date at which the given status became applicable." )
    protected DateTimeType statusDate;

    /**
     * The beginning of the time period in which the marketing authorization is in the specific status shall be specified A complete date consisting of day, month and year shall be specified using the ISO 8601 date format.
     */
    @Child(name = "validityPeriod", type = {Period.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The beginning of the time period in which the marketing authorization is in the specific status shall be specified A complete date consisting of day, month and year shall be specified using the ISO 8601 date format", formalDefinition="The beginning of the time period in which the marketing authorization is in the specific status shall be specified A complete date consisting of day, month and year shall be specified using the ISO 8601 date format." )
    protected Period validityPeriod;

    /**
     * Condition for which the medicinal use applies.
     */
    @Child(name = "indication", type = {CodeableConcept.class, ClinicalUseIssue.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Condition for which the medicinal use applies", formalDefinition="Condition for which the medicinal use applies." )
    protected DataType indication;

    /**
     * The intended use of the product, e.g. prevention, treatment.
     */
    @Child(name = "intendedUse", type = {CodeableConcept.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The intended use of the product, e.g. prevention, treatment", formalDefinition="The intended use of the product, e.g. prevention, treatment." )
    protected CodeableConcept intendedUse;

    /**
     * The legal or regulatory framework against which this authorization is granted, or other reasons for it.
     */
    @Child(name = "basis", type = {CodeableConcept.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The legal or regulatory framework against which this authorization is granted, or other reasons for it", formalDefinition="The legal or regulatory framework against which this authorization is granted, or other reasons for it." )
    protected List<CodeableConcept> basis;

    /**
     * Other dates associated with the authorization. It is common for an authorization to have renewal dates, initial time limited phases and so on.
     */
    @Child(name = "relatedDate", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Other dates associated with the authorization. It is common for an authorization to have renewal dates, initial time limited phases and so on", formalDefinition="Other dates associated with the authorization. It is common for an authorization to have renewal dates, initial time limited phases and so on." )
    protected List<RegulatedAuthorizationRelatedDateComponent> relatedDate;

    /**
     * Authorization in areas within a country.
     */
    @Child(name = "jurisdictionalAuthorization", type = {RegulatedAuthorization.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Authorization in areas within a country", formalDefinition="Authorization in areas within a country." )
    protected List<Reference> jurisdictionalAuthorization;

    /**
     * Marketing Authorization Holder.
     */
    @Child(name = "holder", type = {Organization.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Marketing Authorization Holder", formalDefinition="Marketing Authorization Holder." )
    protected Reference holder;

    /**
     * Medicines Regulatory Agency.
     */
    @Child(name = "regulator", type = {Organization.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Medicines Regulatory Agency", formalDefinition="Medicines Regulatory Agency." )
    protected Reference regulator;

    /**
     * The case or regulatory procedure for granting or amending a marketing authorization.
     */
    @Child(name = "case", type = {}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The case or regulatory procedure for granting or amending a marketing authorization", formalDefinition="The case or regulatory procedure for granting or amending a marketing authorization." )
    protected RegulatedAuthorizationCaseComponent case_;

    private static final long serialVersionUID = -896864670L;

  /**
   * Constructor
   */
    public RegulatedAuthorization() {
      super();
    }

    /**
     * @return {@link #identifier} (Business identifier for the authorization, typically assigned by the authorizing body.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RegulatedAuthorization setIdentifier(List<Identifier> theIdentifier) { 
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

    public RegulatedAuthorization addIdentifier(Identifier t) { //3
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
     * @return {@link #subject} (The type of product or service that is being authorized.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RegulatedAuthorization.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The type of product or service that is being authorized.)
     */
    public RegulatedAuthorization setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #type} (Overall type of this authorization, for example drug marketing approval, orphan drug designation.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RegulatedAuthorization.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Overall type of this authorization, for example drug marketing approval, orphan drug designation.)
     */
    public RegulatedAuthorization setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #description} (General textual supporting information.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RegulatedAuthorization.description");
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
     * @param value {@link #description} (General textual supporting information.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public RegulatedAuthorization setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return General textual supporting information.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value General textual supporting information.
     */
    public RegulatedAuthorization setDescription(String value) { 
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
     * @return {@link #region} (The region (country, jurisdiction etc.) in which the marketing authorization has been granted.)
     */
    public List<CodeableConcept> getRegion() { 
      if (this.region == null)
        this.region = new ArrayList<CodeableConcept>();
      return this.region;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RegulatedAuthorization setRegion(List<CodeableConcept> theRegion) { 
      this.region = theRegion;
      return this;
    }

    public boolean hasRegion() { 
      if (this.region == null)
        return false;
      for (CodeableConcept item : this.region)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addRegion() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.region == null)
        this.region = new ArrayList<CodeableConcept>();
      this.region.add(t);
      return t;
    }

    public RegulatedAuthorization addRegion(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.region == null)
        this.region = new ArrayList<CodeableConcept>();
      this.region.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #region}, creating it if it does not already exist {3}
     */
    public CodeableConcept getRegionFirstRep() { 
      if (getRegion().isEmpty()) {
        addRegion();
      }
      return getRegion().get(0);
    }

    /**
     * @return {@link #status} (The status that is authorised e.g. approved. Intermediate states can be tracked with cases and applications.)
     */
    public CodeableConcept getStatus() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RegulatedAuthorization.status");
        else if (Configuration.doAutoCreate())
          this.status = new CodeableConcept(); // cc
      return this.status;
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status that is authorised e.g. approved. Intermediate states can be tracked with cases and applications.)
     */
    public RegulatedAuthorization setStatus(CodeableConcept value) { 
      this.status = value;
      return this;
    }

    /**
     * @return {@link #statusDate} (The date at which the given status became applicable.). This is the underlying object with id, value and extensions. The accessor "getStatusDate" gives direct access to the value
     */
    public DateTimeType getStatusDateElement() { 
      if (this.statusDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RegulatedAuthorization.statusDate");
        else if (Configuration.doAutoCreate())
          this.statusDate = new DateTimeType(); // bb
      return this.statusDate;
    }

    public boolean hasStatusDateElement() { 
      return this.statusDate != null && !this.statusDate.isEmpty();
    }

    public boolean hasStatusDate() { 
      return this.statusDate != null && !this.statusDate.isEmpty();
    }

    /**
     * @param value {@link #statusDate} (The date at which the given status became applicable.). This is the underlying object with id, value and extensions. The accessor "getStatusDate" gives direct access to the value
     */
    public RegulatedAuthorization setStatusDateElement(DateTimeType value) { 
      this.statusDate = value;
      return this;
    }

    /**
     * @return The date at which the given status became applicable.
     */
    public Date getStatusDate() { 
      return this.statusDate == null ? null : this.statusDate.getValue();
    }

    /**
     * @param value The date at which the given status became applicable.
     */
    public RegulatedAuthorization setStatusDate(Date value) { 
      if (value == null)
        this.statusDate = null;
      else {
        if (this.statusDate == null)
          this.statusDate = new DateTimeType();
        this.statusDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #validityPeriod} (The beginning of the time period in which the marketing authorization is in the specific status shall be specified A complete date consisting of day, month and year shall be specified using the ISO 8601 date format.)
     */
    public Period getValidityPeriod() { 
      if (this.validityPeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RegulatedAuthorization.validityPeriod");
        else if (Configuration.doAutoCreate())
          this.validityPeriod = new Period(); // cc
      return this.validityPeriod;
    }

    public boolean hasValidityPeriod() { 
      return this.validityPeriod != null && !this.validityPeriod.isEmpty();
    }

    /**
     * @param value {@link #validityPeriod} (The beginning of the time period in which the marketing authorization is in the specific status shall be specified A complete date consisting of day, month and year shall be specified using the ISO 8601 date format.)
     */
    public RegulatedAuthorization setValidityPeriod(Period value) { 
      this.validityPeriod = value;
      return this;
    }

    /**
     * @return {@link #indication} (Condition for which the medicinal use applies.)
     */
    public DataType getIndication() { 
      return this.indication;
    }

    /**
     * @return {@link #indication} (Condition for which the medicinal use applies.)
     */
    public CodeableConcept getIndicationCodeableConcept() throws FHIRException { 
      if (this.indication == null)
        this.indication = new CodeableConcept();
      if (!(this.indication instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.indication.getClass().getName()+" was encountered");
      return (CodeableConcept) this.indication;
    }

    public boolean hasIndicationCodeableConcept() { 
      return this != null && this.indication instanceof CodeableConcept;
    }

    /**
     * @return {@link #indication} (Condition for which the medicinal use applies.)
     */
    public Reference getIndicationReference() throws FHIRException { 
      if (this.indication == null)
        this.indication = new Reference();
      if (!(this.indication instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.indication.getClass().getName()+" was encountered");
      return (Reference) this.indication;
    }

    public boolean hasIndicationReference() { 
      return this != null && this.indication instanceof Reference;
    }

    public boolean hasIndication() { 
      return this.indication != null && !this.indication.isEmpty();
    }

    /**
     * @param value {@link #indication} (Condition for which the medicinal use applies.)
     */
    public RegulatedAuthorization setIndication(DataType value) { 
      if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
        throw new Error("Not the right type for RegulatedAuthorization.indication[x]: "+value.fhirType());
      this.indication = value;
      return this;
    }

    /**
     * @return {@link #intendedUse} (The intended use of the product, e.g. prevention, treatment.)
     */
    public CodeableConcept getIntendedUse() { 
      if (this.intendedUse == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RegulatedAuthorization.intendedUse");
        else if (Configuration.doAutoCreate())
          this.intendedUse = new CodeableConcept(); // cc
      return this.intendedUse;
    }

    public boolean hasIntendedUse() { 
      return this.intendedUse != null && !this.intendedUse.isEmpty();
    }

    /**
     * @param value {@link #intendedUse} (The intended use of the product, e.g. prevention, treatment.)
     */
    public RegulatedAuthorization setIntendedUse(CodeableConcept value) { 
      this.intendedUse = value;
      return this;
    }

    /**
     * @return {@link #basis} (The legal or regulatory framework against which this authorization is granted, or other reasons for it.)
     */
    public List<CodeableConcept> getBasis() { 
      if (this.basis == null)
        this.basis = new ArrayList<CodeableConcept>();
      return this.basis;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RegulatedAuthorization setBasis(List<CodeableConcept> theBasis) { 
      this.basis = theBasis;
      return this;
    }

    public boolean hasBasis() { 
      if (this.basis == null)
        return false;
      for (CodeableConcept item : this.basis)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addBasis() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.basis == null)
        this.basis = new ArrayList<CodeableConcept>();
      this.basis.add(t);
      return t;
    }

    public RegulatedAuthorization addBasis(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.basis == null)
        this.basis = new ArrayList<CodeableConcept>();
      this.basis.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #basis}, creating it if it does not already exist {3}
     */
    public CodeableConcept getBasisFirstRep() { 
      if (getBasis().isEmpty()) {
        addBasis();
      }
      return getBasis().get(0);
    }

    /**
     * @return {@link #relatedDate} (Other dates associated with the authorization. It is common for an authorization to have renewal dates, initial time limited phases and so on.)
     */
    public List<RegulatedAuthorizationRelatedDateComponent> getRelatedDate() { 
      if (this.relatedDate == null)
        this.relatedDate = new ArrayList<RegulatedAuthorizationRelatedDateComponent>();
      return this.relatedDate;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RegulatedAuthorization setRelatedDate(List<RegulatedAuthorizationRelatedDateComponent> theRelatedDate) { 
      this.relatedDate = theRelatedDate;
      return this;
    }

    public boolean hasRelatedDate() { 
      if (this.relatedDate == null)
        return false;
      for (RegulatedAuthorizationRelatedDateComponent item : this.relatedDate)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RegulatedAuthorizationRelatedDateComponent addRelatedDate() { //3
      RegulatedAuthorizationRelatedDateComponent t = new RegulatedAuthorizationRelatedDateComponent();
      if (this.relatedDate == null)
        this.relatedDate = new ArrayList<RegulatedAuthorizationRelatedDateComponent>();
      this.relatedDate.add(t);
      return t;
    }

    public RegulatedAuthorization addRelatedDate(RegulatedAuthorizationRelatedDateComponent t) { //3
      if (t == null)
        return this;
      if (this.relatedDate == null)
        this.relatedDate = new ArrayList<RegulatedAuthorizationRelatedDateComponent>();
      this.relatedDate.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedDate}, creating it if it does not already exist {3}
     */
    public RegulatedAuthorizationRelatedDateComponent getRelatedDateFirstRep() { 
      if (getRelatedDate().isEmpty()) {
        addRelatedDate();
      }
      return getRelatedDate().get(0);
    }

    /**
     * @return {@link #jurisdictionalAuthorization} (Authorization in areas within a country.)
     */
    public List<Reference> getJurisdictionalAuthorization() { 
      if (this.jurisdictionalAuthorization == null)
        this.jurisdictionalAuthorization = new ArrayList<Reference>();
      return this.jurisdictionalAuthorization;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RegulatedAuthorization setJurisdictionalAuthorization(List<Reference> theJurisdictionalAuthorization) { 
      this.jurisdictionalAuthorization = theJurisdictionalAuthorization;
      return this;
    }

    public boolean hasJurisdictionalAuthorization() { 
      if (this.jurisdictionalAuthorization == null)
        return false;
      for (Reference item : this.jurisdictionalAuthorization)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addJurisdictionalAuthorization() { //3
      Reference t = new Reference();
      if (this.jurisdictionalAuthorization == null)
        this.jurisdictionalAuthorization = new ArrayList<Reference>();
      this.jurisdictionalAuthorization.add(t);
      return t;
    }

    public RegulatedAuthorization addJurisdictionalAuthorization(Reference t) { //3
      if (t == null)
        return this;
      if (this.jurisdictionalAuthorization == null)
        this.jurisdictionalAuthorization = new ArrayList<Reference>();
      this.jurisdictionalAuthorization.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #jurisdictionalAuthorization}, creating it if it does not already exist {3}
     */
    public Reference getJurisdictionalAuthorizationFirstRep() { 
      if (getJurisdictionalAuthorization().isEmpty()) {
        addJurisdictionalAuthorization();
      }
      return getJurisdictionalAuthorization().get(0);
    }

    /**
     * @return {@link #holder} (Marketing Authorization Holder.)
     */
    public Reference getHolder() { 
      if (this.holder == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RegulatedAuthorization.holder");
        else if (Configuration.doAutoCreate())
          this.holder = new Reference(); // cc
      return this.holder;
    }

    public boolean hasHolder() { 
      return this.holder != null && !this.holder.isEmpty();
    }

    /**
     * @param value {@link #holder} (Marketing Authorization Holder.)
     */
    public RegulatedAuthorization setHolder(Reference value) { 
      this.holder = value;
      return this;
    }

    /**
     * @return {@link #regulator} (Medicines Regulatory Agency.)
     */
    public Reference getRegulator() { 
      if (this.regulator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RegulatedAuthorization.regulator");
        else if (Configuration.doAutoCreate())
          this.regulator = new Reference(); // cc
      return this.regulator;
    }

    public boolean hasRegulator() { 
      return this.regulator != null && !this.regulator.isEmpty();
    }

    /**
     * @param value {@link #regulator} (Medicines Regulatory Agency.)
     */
    public RegulatedAuthorization setRegulator(Reference value) { 
      this.regulator = value;
      return this;
    }

    /**
     * @return {@link #case_} (The case or regulatory procedure for granting or amending a marketing authorization.)
     */
    public RegulatedAuthorizationCaseComponent getCase() { 
      if (this.case_ == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RegulatedAuthorization.case_");
        else if (Configuration.doAutoCreate())
          this.case_ = new RegulatedAuthorizationCaseComponent(); // cc
      return this.case_;
    }

    public boolean hasCase() { 
      return this.case_ != null && !this.case_.isEmpty();
    }

    /**
     * @param value {@link #case_} (The case or regulatory procedure for granting or amending a marketing authorization.)
     */
    public RegulatedAuthorization setCase(RegulatedAuthorizationCaseComponent value) { 
      this.case_ = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for the authorization, typically assigned by the authorizing body.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("subject", "Reference(MedicinalProductDefinition|PackagedProductDefinition|DeviceDefinition|ResearchStudy|ActivityDefinition|PlanDefinition|ObservationDefinition)", "The type of product or service that is being authorized.", 0, 1, subject));
        children.add(new Property("type", "CodeableConcept", "Overall type of this authorization, for example drug marketing approval, orphan drug designation.", 0, 1, type));
        children.add(new Property("description", "markdown", "General textual supporting information.", 0, 1, description));
        children.add(new Property("region", "CodeableConcept", "The region (country, jurisdiction etc.) in which the marketing authorization has been granted.", 0, java.lang.Integer.MAX_VALUE, region));
        children.add(new Property("status", "CodeableConcept", "The status that is authorised e.g. approved. Intermediate states can be tracked with cases and applications.", 0, 1, status));
        children.add(new Property("statusDate", "dateTime", "The date at which the given status became applicable.", 0, 1, statusDate));
        children.add(new Property("validityPeriod", "Period", "The beginning of the time period in which the marketing authorization is in the specific status shall be specified A complete date consisting of day, month and year shall be specified using the ISO 8601 date format.", 0, 1, validityPeriod));
        children.add(new Property("indication[x]", "CodeableConcept|Reference(ClinicalUseIssue)", "Condition for which the medicinal use applies.", 0, 1, indication));
        children.add(new Property("intendedUse", "CodeableConcept", "The intended use of the product, e.g. prevention, treatment.", 0, 1, intendedUse));
        children.add(new Property("basis", "CodeableConcept", "The legal or regulatory framework against which this authorization is granted, or other reasons for it.", 0, java.lang.Integer.MAX_VALUE, basis));
        children.add(new Property("relatedDate", "", "Other dates associated with the authorization. It is common for an authorization to have renewal dates, initial time limited phases and so on.", 0, java.lang.Integer.MAX_VALUE, relatedDate));
        children.add(new Property("jurisdictionalAuthorization", "Reference(RegulatedAuthorization)", "Authorization in areas within a country.", 0, java.lang.Integer.MAX_VALUE, jurisdictionalAuthorization));
        children.add(new Property("holder", "Reference(Organization)", "Marketing Authorization Holder.", 0, 1, holder));
        children.add(new Property("regulator", "Reference(Organization)", "Medicines Regulatory Agency.", 0, 1, regulator));
        children.add(new Property("case", "", "The case or regulatory procedure for granting or amending a marketing authorization.", 0, 1, case_));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for the authorization, typically assigned by the authorizing body.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(MedicinalProductDefinition|PackagedProductDefinition|DeviceDefinition|ResearchStudy|ActivityDefinition|PlanDefinition|ObservationDefinition)", "The type of product or service that is being authorized.", 0, 1, subject);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Overall type of this authorization, for example drug marketing approval, orphan drug designation.", 0, 1, type);
        case -1724546052: /*description*/  return new Property("description", "markdown", "General textual supporting information.", 0, 1, description);
        case -934795532: /*region*/  return new Property("region", "CodeableConcept", "The region (country, jurisdiction etc.) in which the marketing authorization has been granted.", 0, java.lang.Integer.MAX_VALUE, region);
        case -892481550: /*status*/  return new Property("status", "CodeableConcept", "The status that is authorised e.g. approved. Intermediate states can be tracked with cases and applications.", 0, 1, status);
        case 247524032: /*statusDate*/  return new Property("statusDate", "dateTime", "The date at which the given status became applicable.", 0, 1, statusDate);
        case -1434195053: /*validityPeriod*/  return new Property("validityPeriod", "Period", "The beginning of the time period in which the marketing authorization is in the specific status shall be specified A complete date consisting of day, month and year shall be specified using the ISO 8601 date format.", 0, 1, validityPeriod);
        case -501208668: /*indication[x]*/  return new Property("indication[x]", "CodeableConcept|Reference(ClinicalUseIssue)", "Condition for which the medicinal use applies.", 0, 1, indication);
        case -597168804: /*indication*/  return new Property("indication[x]", "CodeableConcept|Reference(ClinicalUseIssue)", "Condition for which the medicinal use applies.", 0, 1, indication);
        case -1094003035: /*indicationCodeableConcept*/  return new Property("indication[x]", "CodeableConcept", "Condition for which the medicinal use applies.", 0, 1, indication);
        case 803518799: /*indicationReference*/  return new Property("indication[x]", "Reference(ClinicalUseIssue)", "Condition for which the medicinal use applies.", 0, 1, indication);
        case -1618671268: /*intendedUse*/  return new Property("intendedUse", "CodeableConcept", "The intended use of the product, e.g. prevention, treatment.", 0, 1, intendedUse);
        case 93508670: /*basis*/  return new Property("basis", "CodeableConcept", "The legal or regulatory framework against which this authorization is granted, or other reasons for it.", 0, java.lang.Integer.MAX_VALUE, basis);
        case 1112535673: /*relatedDate*/  return new Property("relatedDate", "", "Other dates associated with the authorization. It is common for an authorization to have renewal dates, initial time limited phases and so on.", 0, java.lang.Integer.MAX_VALUE, relatedDate);
        case 1459432557: /*jurisdictionalAuthorization*/  return new Property("jurisdictionalAuthorization", "Reference(RegulatedAuthorization)", "Authorization in areas within a country.", 0, java.lang.Integer.MAX_VALUE, jurisdictionalAuthorization);
        case -1211707988: /*holder*/  return new Property("holder", "Reference(Organization)", "Marketing Authorization Holder.", 0, 1, holder);
        case 414760449: /*regulator*/  return new Property("regulator", "Reference(Organization)", "Medicines Regulatory Agency.", 0, 1, regulator);
        case 3046192: /*case*/  return new Property("case", "", "The case or regulatory procedure for granting or amending a marketing authorization.", 0, 1, case_);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -934795532: /*region*/ return this.region == null ? new Base[0] : this.region.toArray(new Base[this.region.size()]); // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case 247524032: /*statusDate*/ return this.statusDate == null ? new Base[0] : new Base[] {this.statusDate}; // DateTimeType
        case -1434195053: /*validityPeriod*/ return this.validityPeriod == null ? new Base[0] : new Base[] {this.validityPeriod}; // Period
        case -597168804: /*indication*/ return this.indication == null ? new Base[0] : new Base[] {this.indication}; // DataType
        case -1618671268: /*intendedUse*/ return this.intendedUse == null ? new Base[0] : new Base[] {this.intendedUse}; // CodeableConcept
        case 93508670: /*basis*/ return this.basis == null ? new Base[0] : this.basis.toArray(new Base[this.basis.size()]); // CodeableConcept
        case 1112535673: /*relatedDate*/ return this.relatedDate == null ? new Base[0] : this.relatedDate.toArray(new Base[this.relatedDate.size()]); // RegulatedAuthorizationRelatedDateComponent
        case 1459432557: /*jurisdictionalAuthorization*/ return this.jurisdictionalAuthorization == null ? new Base[0] : this.jurisdictionalAuthorization.toArray(new Base[this.jurisdictionalAuthorization.size()]); // Reference
        case -1211707988: /*holder*/ return this.holder == null ? new Base[0] : new Base[] {this.holder}; // Reference
        case 414760449: /*regulator*/ return this.regulator == null ? new Base[0] : new Base[] {this.regulator}; // Reference
        case 3046192: /*case*/ return this.case_ == null ? new Base[0] : new Base[] {this.case_}; // RegulatedAuthorizationCaseComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -934795532: // region
          this.getRegion().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 247524032: // statusDate
          this.statusDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1434195053: // validityPeriod
          this.validityPeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -597168804: // indication
          this.indication = TypeConvertor.castToType(value); // DataType
          return value;
        case -1618671268: // intendedUse
          this.intendedUse = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 93508670: // basis
          this.getBasis().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1112535673: // relatedDate
          this.getRelatedDate().add((RegulatedAuthorizationRelatedDateComponent) value); // RegulatedAuthorizationRelatedDateComponent
          return value;
        case 1459432557: // jurisdictionalAuthorization
          this.getJurisdictionalAuthorization().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1211707988: // holder
          this.holder = TypeConvertor.castToReference(value); // Reference
          return value;
        case 414760449: // regulator
          this.regulator = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3046192: // case
          this.case_ = (RegulatedAuthorizationCaseComponent) value; // RegulatedAuthorizationCaseComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("region")) {
          this.getRegion().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("statusDate")) {
          this.statusDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("validityPeriod")) {
          this.validityPeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("indication[x]")) {
          this.indication = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("intendedUse")) {
          this.intendedUse = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("basis")) {
          this.getBasis().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("relatedDate")) {
          this.getRelatedDate().add((RegulatedAuthorizationRelatedDateComponent) value);
        } else if (name.equals("jurisdictionalAuthorization")) {
          this.getJurisdictionalAuthorization().add(TypeConvertor.castToReference(value));
        } else if (name.equals("holder")) {
          this.holder = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("regulator")) {
          this.regulator = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("case")) {
          this.case_ = (RegulatedAuthorizationCaseComponent) value; // RegulatedAuthorizationCaseComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1867885268:  return getSubject();
        case 3575610:  return getType();
        case -1724546052:  return getDescriptionElement();
        case -934795532:  return addRegion(); 
        case -892481550:  return getStatus();
        case 247524032:  return getStatusDateElement();
        case -1434195053:  return getValidityPeriod();
        case -501208668:  return getIndication();
        case -597168804:  return getIndication();
        case -1618671268:  return getIntendedUse();
        case 93508670:  return addBasis(); 
        case 1112535673:  return addRelatedDate(); 
        case 1459432557:  return addJurisdictionalAuthorization(); 
        case -1211707988:  return getHolder();
        case 414760449:  return getRegulator();
        case 3046192:  return getCase();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -934795532: /*region*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case 247524032: /*statusDate*/ return new String[] {"dateTime"};
        case -1434195053: /*validityPeriod*/ return new String[] {"Period"};
        case -597168804: /*indication*/ return new String[] {"CodeableConcept", "Reference"};
        case -1618671268: /*intendedUse*/ return new String[] {"CodeableConcept"};
        case 93508670: /*basis*/ return new String[] {"CodeableConcept"};
        case 1112535673: /*relatedDate*/ return new String[] {};
        case 1459432557: /*jurisdictionalAuthorization*/ return new String[] {"Reference"};
        case -1211707988: /*holder*/ return new String[] {"Reference"};
        case 414760449: /*regulator*/ return new String[] {"Reference"};
        case 3046192: /*case*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type RegulatedAuthorization.description");
        }
        else if (name.equals("region")) {
          return addRegion();
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("statusDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type RegulatedAuthorization.statusDate");
        }
        else if (name.equals("validityPeriod")) {
          this.validityPeriod = new Period();
          return this.validityPeriod;
        }
        else if (name.equals("indicationCodeableConcept")) {
          this.indication = new CodeableConcept();
          return this.indication;
        }
        else if (name.equals("indicationReference")) {
          this.indication = new Reference();
          return this.indication;
        }
        else if (name.equals("intendedUse")) {
          this.intendedUse = new CodeableConcept();
          return this.intendedUse;
        }
        else if (name.equals("basis")) {
          return addBasis();
        }
        else if (name.equals("relatedDate")) {
          return addRelatedDate();
        }
        else if (name.equals("jurisdictionalAuthorization")) {
          return addJurisdictionalAuthorization();
        }
        else if (name.equals("holder")) {
          this.holder = new Reference();
          return this.holder;
        }
        else if (name.equals("regulator")) {
          this.regulator = new Reference();
          return this.regulator;
        }
        else if (name.equals("case")) {
          this.case_ = new RegulatedAuthorizationCaseComponent();
          return this.case_;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "RegulatedAuthorization";

  }

      public RegulatedAuthorization copy() {
        RegulatedAuthorization dst = new RegulatedAuthorization();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RegulatedAuthorization dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        dst.type = type == null ? null : type.copy();
        dst.description = description == null ? null : description.copy();
        if (region != null) {
          dst.region = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : region)
            dst.region.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.statusDate = statusDate == null ? null : statusDate.copy();
        dst.validityPeriod = validityPeriod == null ? null : validityPeriod.copy();
        dst.indication = indication == null ? null : indication.copy();
        dst.intendedUse = intendedUse == null ? null : intendedUse.copy();
        if (basis != null) {
          dst.basis = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : basis)
            dst.basis.add(i.copy());
        };
        if (relatedDate != null) {
          dst.relatedDate = new ArrayList<RegulatedAuthorizationRelatedDateComponent>();
          for (RegulatedAuthorizationRelatedDateComponent i : relatedDate)
            dst.relatedDate.add(i.copy());
        };
        if (jurisdictionalAuthorization != null) {
          dst.jurisdictionalAuthorization = new ArrayList<Reference>();
          for (Reference i : jurisdictionalAuthorization)
            dst.jurisdictionalAuthorization.add(i.copy());
        };
        dst.holder = holder == null ? null : holder.copy();
        dst.regulator = regulator == null ? null : regulator.copy();
        dst.case_ = case_ == null ? null : case_.copy();
      }

      protected RegulatedAuthorization typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RegulatedAuthorization))
          return false;
        RegulatedAuthorization o = (RegulatedAuthorization) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(subject, o.subject, true) && compareDeep(type, o.type, true)
           && compareDeep(description, o.description, true) && compareDeep(region, o.region, true) && compareDeep(status, o.status, true)
           && compareDeep(statusDate, o.statusDate, true) && compareDeep(validityPeriod, o.validityPeriod, true)
           && compareDeep(indication, o.indication, true) && compareDeep(intendedUse, o.intendedUse, true)
           && compareDeep(basis, o.basis, true) && compareDeep(relatedDate, o.relatedDate, true) && compareDeep(jurisdictionalAuthorization, o.jurisdictionalAuthorization, true)
           && compareDeep(holder, o.holder, true) && compareDeep(regulator, o.regulator, true) && compareDeep(case_, o.case_, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RegulatedAuthorization))
          return false;
        RegulatedAuthorization o = (RegulatedAuthorization) other_;
        return compareValues(description, o.description, true) && compareValues(statusDate, o.statusDate, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, subject, type
          , description, region, status, statusDate, validityPeriod, indication, intendedUse
          , basis, relatedDate, jurisdictionalAuthorization, holder, regulator, case_);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.RegulatedAuthorization;
   }

 /**
   * Search parameter: <b>case-type</b>
   * <p>
   * Description: <b>The defining type of case</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RegulatedAuthorization.case.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="case-type", path="RegulatedAuthorization.case.type", description="The defining type of case", type="token" )
  public static final String SP_CASE_TYPE = "case-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>case-type</b>
   * <p>
   * Description: <b>The defining type of case</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RegulatedAuthorization.case.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CASE_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CASE_TYPE);

 /**
   * Search parameter: <b>case</b>
   * <p>
   * Description: <b>The case or procedure number</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RegulatedAuthorization.case.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="case", path="RegulatedAuthorization.case.identifier", description="The case or procedure number", type="token" )
  public static final String SP_CASE = "case";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>case</b>
   * <p>
   * Description: <b>The case or procedure number</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RegulatedAuthorization.case.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CASE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CASE);

 /**
   * Search parameter: <b>holder</b>
   * <p>
   * Description: <b>Marketing Authorization Holder</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RegulatedAuthorization.holder</b><br>
   * </p>
   */
  @SearchParamDefinition(name="holder", path="RegulatedAuthorization.holder", description="Marketing Authorization Holder", type="reference", target={Organization.class } )
  public static final String SP_HOLDER = "holder";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>holder</b>
   * <p>
   * Description: <b>Marketing Authorization Holder</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RegulatedAuthorization.holder</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam HOLDER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_HOLDER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RegulatedAuthorization:holder</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_HOLDER = new ca.uhn.fhir.model.api.Include("RegulatedAuthorization:holder").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for the authorization, typically assigned by the authorizing body</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RegulatedAuthorization.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="RegulatedAuthorization.identifier", description="Business identifier for the authorization, typically assigned by the authorizing body", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for the authorization, typically assigned by the authorizing body</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RegulatedAuthorization.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>region</b>
   * <p>
   * Description: <b>The region (country, jurisdiction etc.) in which the marketing authorization has been granted</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RegulatedAuthorization.region</b><br>
   * </p>
   */
  @SearchParamDefinition(name="region", path="RegulatedAuthorization.region", description="The region (country, jurisdiction etc.) in which the marketing authorization has been granted", type="token" )
  public static final String SP_REGION = "region";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>region</b>
   * <p>
   * Description: <b>The region (country, jurisdiction etc.) in which the marketing authorization has been granted</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RegulatedAuthorization.region</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam REGION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_REGION);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status that is authorised e.g. approved. Intermediate states can be tracked with cases and applications</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RegulatedAuthorization.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="RegulatedAuthorization.status", description="The status that is authorised e.g. approved. Intermediate states can be tracked with cases and applications", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status that is authorised e.g. approved. Intermediate states can be tracked with cases and applications</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RegulatedAuthorization.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The type of product or service that is being authorized</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RegulatedAuthorization.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="RegulatedAuthorization.subject", description="The type of product or service that is being authorized", type="reference", target={ActivityDefinition.class, DeviceDefinition.class, MedicinalProductDefinition.class, ObservationDefinition.class, PackagedProductDefinition.class, PlanDefinition.class, ResearchStudy.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The type of product or service that is being authorized</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RegulatedAuthorization.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RegulatedAuthorization:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("RegulatedAuthorization:subject").toLocked();


}