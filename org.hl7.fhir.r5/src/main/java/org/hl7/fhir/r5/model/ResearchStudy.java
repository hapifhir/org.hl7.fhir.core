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
 * A scientific study of nature that sometimes includes processes involved in health and disease. For example, clinical trials are research studies that involve people. These studies may be related to new ways to screen, prevent, diagnose, and treat disease. They may also study certain outcomes and certain groups of people by looking at data collected in the past or future.
 */
@ResourceDef(name="ResearchStudy", profile="http://hl7.org/fhir/StructureDefinition/ResearchStudy")
public class ResearchStudy extends DomainResource {

    @Block()
    public static class ResearchStudyLabelComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Kind of name.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="primary | official | scientific | plain-language | subtitle | short-title | acronym | earlier-title | language | auto-translated | human-use | machine-use | duplicate-uid", formalDefinition="Kind of name." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/title-type")
        protected CodeableConcept type;

        /**
         * The name.
         */
        @Child(name = "value", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The name", formalDefinition="The name." )
        protected StringType value;

        private static final long serialVersionUID = 944223389L;

    /**
     * Constructor
     */
      public ResearchStudyLabelComponent() {
        super();
      }

        /**
         * @return {@link #type} (Kind of name.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyLabelComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Kind of name.)
         */
        public ResearchStudyLabelComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (The name.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public StringType getValueElement() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyLabelComponent.value");
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
         * @param value {@link #value} (The name.). This is the underlying object with id, value and extensions. The accessor "getValue" gives direct access to the value
         */
        public ResearchStudyLabelComponent setValueElement(StringType value) { 
          this.value = value;
          return this;
        }

        /**
         * @return The name.
         */
        public String getValue() { 
          return this.value == null ? null : this.value.getValue();
        }

        /**
         * @param value The name.
         */
        public ResearchStudyLabelComponent setValue(String value) { 
          if (Utilities.noString(value))
            this.value = null;
          else {
            if (this.value == null)
              this.value = new StringType();
            this.value.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Kind of name.", 0, 1, type));
          children.add(new Property("value", "string", "The name.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Kind of name.", 0, 1, type);
          case 111972721: /*value*/  return new Property("value", "string", "The name.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 111972721:  return getValueElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("value")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.label.value");
        }
        else
          return super.addChild(name);
      }

      public ResearchStudyLabelComponent copy() {
        ResearchStudyLabelComponent dst = new ResearchStudyLabelComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResearchStudyLabelComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResearchStudyLabelComponent))
          return false;
        ResearchStudyLabelComponent o = (ResearchStudyLabelComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResearchStudyLabelComponent))
          return false;
        ResearchStudyLabelComponent o = (ResearchStudyLabelComponent) other_;
        return compareValues(value, o.value, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "ResearchStudy.label";

  }

  }

    @Block()
    public static class ResearchStudyAssociatedPartyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Name of associated party.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of associated party", formalDefinition="Name of associated party." )
        protected StringType name;

        /**
         * Type of association.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="sponsor | lead-sponsor | sponsor-investigator | primary-investigator | collaborator | funding-source | general-contact | recruitment-contact | sub-investigator | study-director | study-chair", formalDefinition="Type of association." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-study-party-role")
        protected CodeableConcept role;

        /**
         * Identifies the start date and the end date of the associated party in the role.
         */
        @Child(name = "period", type = {Period.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="When active in the role", formalDefinition="Identifies the start date and the end date of the associated party in the role." )
        protected List<Period> period;

        /**
         * A categorization other than role for the associated party.
         */
        @Child(name = "classifier", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="nih | fda | government | nonprofit | academic | industry", formalDefinition="A categorization other than role for the associated party." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-study-party-organization-type")
        protected List<CodeableConcept> classifier;

        /**
         * Individual or organization associated with study (use practitionerRole to specify their organisation).
         */
        @Child(name = "party", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Individual or organization associated with study (use practitionerRole to specify their organisation)", formalDefinition="Individual or organization associated with study (use practitionerRole to specify their organisation)." )
        protected Reference party;

        private static final long serialVersionUID = -1418550998L;

    /**
     * Constructor
     */
      public ResearchStudyAssociatedPartyComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ResearchStudyAssociatedPartyComponent(CodeableConcept role) {
        super();
        this.setRole(role);
      }

        /**
         * @return {@link #name} (Name of associated party.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyAssociatedPartyComponent.name");
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
         * @param value {@link #name} (Name of associated party.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public ResearchStudyAssociatedPartyComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name of associated party.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name of associated party.
         */
        public ResearchStudyAssociatedPartyComponent setName(String value) { 
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
         * @return {@link #role} (Type of association.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyAssociatedPartyComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (Type of association.)
         */
        public ResearchStudyAssociatedPartyComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #period} (Identifies the start date and the end date of the associated party in the role.)
         */
        public List<Period> getPeriod() { 
          if (this.period == null)
            this.period = new ArrayList<Period>();
          return this.period;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ResearchStudyAssociatedPartyComponent setPeriod(List<Period> thePeriod) { 
          this.period = thePeriod;
          return this;
        }

        public boolean hasPeriod() { 
          if (this.period == null)
            return false;
          for (Period item : this.period)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Period addPeriod() { //3
          Period t = new Period();
          if (this.period == null)
            this.period = new ArrayList<Period>();
          this.period.add(t);
          return t;
        }

        public ResearchStudyAssociatedPartyComponent addPeriod(Period t) { //3
          if (t == null)
            return this;
          if (this.period == null)
            this.period = new ArrayList<Period>();
          this.period.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #period}, creating it if it does not already exist {3}
         */
        public Period getPeriodFirstRep() { 
          if (getPeriod().isEmpty()) {
            addPeriod();
          }
          return getPeriod().get(0);
        }

        /**
         * @return {@link #classifier} (A categorization other than role for the associated party.)
         */
        public List<CodeableConcept> getClassifier() { 
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          return this.classifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ResearchStudyAssociatedPartyComponent setClassifier(List<CodeableConcept> theClassifier) { 
          this.classifier = theClassifier;
          return this;
        }

        public boolean hasClassifier() { 
          if (this.classifier == null)
            return false;
          for (CodeableConcept item : this.classifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addClassifier() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return t;
        }

        public ResearchStudyAssociatedPartyComponent addClassifier(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.classifier == null)
            this.classifier = new ArrayList<CodeableConcept>();
          this.classifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #classifier}, creating it if it does not already exist {3}
         */
        public CodeableConcept getClassifierFirstRep() { 
          if (getClassifier().isEmpty()) {
            addClassifier();
          }
          return getClassifier().get(0);
        }

        /**
         * @return {@link #party} (Individual or organization associated with study (use practitionerRole to specify their organisation).)
         */
        public Reference getParty() { 
          if (this.party == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyAssociatedPartyComponent.party");
            else if (Configuration.doAutoCreate())
              this.party = new Reference(); // cc
          return this.party;
        }

        public boolean hasParty() { 
          return this.party != null && !this.party.isEmpty();
        }

        /**
         * @param value {@link #party} (Individual or organization associated with study (use practitionerRole to specify their organisation).)
         */
        public ResearchStudyAssociatedPartyComponent setParty(Reference value) { 
          this.party = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Name of associated party.", 0, 1, name));
          children.add(new Property("role", "CodeableConcept", "Type of association.", 0, 1, role));
          children.add(new Property("period", "Period", "Identifies the start date and the end date of the associated party in the role.", 0, java.lang.Integer.MAX_VALUE, period));
          children.add(new Property("classifier", "CodeableConcept", "A categorization other than role for the associated party.", 0, java.lang.Integer.MAX_VALUE, classifier));
          children.add(new Property("party", "Reference(Practitioner|PractitionerRole|Organization)", "Individual or organization associated with study (use practitionerRole to specify their organisation).", 0, 1, party));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Name of associated party.", 0, 1, name);
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "Type of association.", 0, 1, role);
          case -991726143: /*period*/  return new Property("period", "Period", "Identifies the start date and the end date of the associated party in the role.", 0, java.lang.Integer.MAX_VALUE, period);
          case -281470431: /*classifier*/  return new Property("classifier", "CodeableConcept", "A categorization other than role for the associated party.", 0, java.lang.Integer.MAX_VALUE, classifier);
          case 106437350: /*party*/  return new Property("party", "Reference(Practitioner|PractitionerRole|Organization)", "Individual or organization associated with study (use practitionerRole to specify their organisation).", 0, 1, party);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case -991726143: /*period*/ return this.period == null ? new Base[0] : this.period.toArray(new Base[this.period.size()]); // Period
        case -281470431: /*classifier*/ return this.classifier == null ? new Base[0] : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
        case 106437350: /*party*/ return this.party == null ? new Base[0] : new Base[] {this.party}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -991726143: // period
          this.getPeriod().add(TypeConvertor.castToPeriod(value)); // Period
          return value;
        case -281470431: // classifier
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 106437350: // party
          this.party = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("period")) {
          this.getPeriod().add(TypeConvertor.castToPeriod(value));
        } else if (name.equals("classifier")) {
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("party")) {
          this.party = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 3506294:  return getRole();
        case -991726143:  return addPeriod(); 
        case -281470431:  return addClassifier(); 
        case 106437350:  return getParty();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case -281470431: /*classifier*/ return new String[] {"CodeableConcept"};
        case 106437350: /*party*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.associatedParty.name");
        }
        else if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("period")) {
          return addPeriod();
        }
        else if (name.equals("classifier")) {
          return addClassifier();
        }
        else if (name.equals("party")) {
          this.party = new Reference();
          return this.party;
        }
        else
          return super.addChild(name);
      }

      public ResearchStudyAssociatedPartyComponent copy() {
        ResearchStudyAssociatedPartyComponent dst = new ResearchStudyAssociatedPartyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResearchStudyAssociatedPartyComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.role = role == null ? null : role.copy();
        if (period != null) {
          dst.period = new ArrayList<Period>();
          for (Period i : period)
            dst.period.add(i.copy());
        };
        if (classifier != null) {
          dst.classifier = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : classifier)
            dst.classifier.add(i.copy());
        };
        dst.party = party == null ? null : party.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResearchStudyAssociatedPartyComponent))
          return false;
        ResearchStudyAssociatedPartyComponent o = (ResearchStudyAssociatedPartyComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(role, o.role, true) && compareDeep(period, o.period, true)
           && compareDeep(classifier, o.classifier, true) && compareDeep(party, o.party, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResearchStudyAssociatedPartyComponent))
          return false;
        ResearchStudyAssociatedPartyComponent o = (ResearchStudyAssociatedPartyComponent) other_;
        return compareValues(name, o.name, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, role, period, classifier
          , party);
      }

  public String fhirType() {
    return "ResearchStudy.associatedParty";

  }

  }

    @Block()
    public static class ResearchStudyProgressStatusComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Label for status or state (e.g. recruitment status).
         */
        @Child(name = "state", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for status or state (e.g. recruitment status)", formalDefinition="Label for status or state (e.g. recruitment status)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-study-status")
        protected CodeableConcept state;

        /**
         * An indication of whether or not the date is a known date when the state changed or will change. A value of true indicates a known date. A value of false indicates an estimated date.
         */
        @Child(name = "actual", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Actual if true else anticipated", formalDefinition="An indication of whether or not the date is a known date when the state changed or will change. A value of true indicates a known date. A value of false indicates an estimated date." )
        protected BooleanType actual;

        /**
         * Date range.
         */
        @Child(name = "period", type = {Period.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Date range", formalDefinition="Date range." )
        protected Period period;

        private static final long serialVersionUID = 1232680620L;

    /**
     * Constructor
     */
      public ResearchStudyProgressStatusComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ResearchStudyProgressStatusComponent(CodeableConcept state) {
        super();
        this.setState(state);
      }

        /**
         * @return {@link #state} (Label for status or state (e.g. recruitment status).)
         */
        public CodeableConcept getState() { 
          if (this.state == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyProgressStatusComponent.state");
            else if (Configuration.doAutoCreate())
              this.state = new CodeableConcept(); // cc
          return this.state;
        }

        public boolean hasState() { 
          return this.state != null && !this.state.isEmpty();
        }

        /**
         * @param value {@link #state} (Label for status or state (e.g. recruitment status).)
         */
        public ResearchStudyProgressStatusComponent setState(CodeableConcept value) { 
          this.state = value;
          return this;
        }

        /**
         * @return {@link #actual} (An indication of whether or not the date is a known date when the state changed or will change. A value of true indicates a known date. A value of false indicates an estimated date.). This is the underlying object with id, value and extensions. The accessor "getActual" gives direct access to the value
         */
        public BooleanType getActualElement() { 
          if (this.actual == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyProgressStatusComponent.actual");
            else if (Configuration.doAutoCreate())
              this.actual = new BooleanType(); // bb
          return this.actual;
        }

        public boolean hasActualElement() { 
          return this.actual != null && !this.actual.isEmpty();
        }

        public boolean hasActual() { 
          return this.actual != null && !this.actual.isEmpty();
        }

        /**
         * @param value {@link #actual} (An indication of whether or not the date is a known date when the state changed or will change. A value of true indicates a known date. A value of false indicates an estimated date.). This is the underlying object with id, value and extensions. The accessor "getActual" gives direct access to the value
         */
        public ResearchStudyProgressStatusComponent setActualElement(BooleanType value) { 
          this.actual = value;
          return this;
        }

        /**
         * @return An indication of whether or not the date is a known date when the state changed or will change. A value of true indicates a known date. A value of false indicates an estimated date.
         */
        public boolean getActual() { 
          return this.actual == null || this.actual.isEmpty() ? false : this.actual.getValue();
        }

        /**
         * @param value An indication of whether or not the date is a known date when the state changed or will change. A value of true indicates a known date. A value of false indicates an estimated date.
         */
        public ResearchStudyProgressStatusComponent setActual(boolean value) { 
            if (this.actual == null)
              this.actual = new BooleanType();
            this.actual.setValue(value);
          return this;
        }

        /**
         * @return {@link #period} (Date range.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyProgressStatusComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (Date range.)
         */
        public ResearchStudyProgressStatusComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("state", "CodeableConcept", "Label for status or state (e.g. recruitment status).", 0, 1, state));
          children.add(new Property("actual", "boolean", "An indication of whether or not the date is a known date when the state changed or will change. A value of true indicates a known date. A value of false indicates an estimated date.", 0, 1, actual));
          children.add(new Property("period", "Period", "Date range.", 0, 1, period));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 109757585: /*state*/  return new Property("state", "CodeableConcept", "Label for status or state (e.g. recruitment status).", 0, 1, state);
          case -1422939762: /*actual*/  return new Property("actual", "boolean", "An indication of whether or not the date is a known date when the state changed or will change. A value of true indicates a known date. A value of false indicates an estimated date.", 0, 1, actual);
          case -991726143: /*period*/  return new Property("period", "Period", "Date range.", 0, 1, period);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 109757585: /*state*/ return this.state == null ? new Base[0] : new Base[] {this.state}; // CodeableConcept
        case -1422939762: /*actual*/ return this.actual == null ? new Base[0] : new Base[] {this.actual}; // BooleanType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 109757585: // state
          this.state = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1422939762: // actual
          this.actual = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("state")) {
          this.state = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actual")) {
          this.actual = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 109757585:  return getState();
        case -1422939762:  return getActualElement();
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 109757585: /*state*/ return new String[] {"CodeableConcept"};
        case -1422939762: /*actual*/ return new String[] {"boolean"};
        case -991726143: /*period*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("state")) {
          this.state = new CodeableConcept();
          return this.state;
        }
        else if (name.equals("actual")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.progressStatus.actual");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else
          return super.addChild(name);
      }

      public ResearchStudyProgressStatusComponent copy() {
        ResearchStudyProgressStatusComponent dst = new ResearchStudyProgressStatusComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResearchStudyProgressStatusComponent dst) {
        super.copyValues(dst);
        dst.state = state == null ? null : state.copy();
        dst.actual = actual == null ? null : actual.copy();
        dst.period = period == null ? null : period.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResearchStudyProgressStatusComponent))
          return false;
        ResearchStudyProgressStatusComponent o = (ResearchStudyProgressStatusComponent) other_;
        return compareDeep(state, o.state, true) && compareDeep(actual, o.actual, true) && compareDeep(period, o.period, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResearchStudyProgressStatusComponent))
          return false;
        ResearchStudyProgressStatusComponent o = (ResearchStudyProgressStatusComponent) other_;
        return compareValues(actual, o.actual, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(state, actual, period);
      }

  public String fhirType() {
    return "ResearchStudy.progressStatus";

  }

  }

    @Block()
    public static class ResearchStudyRecruitmentComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Estimated total number of participants to be enrolled.
         */
        @Child(name = "targetNumber", type = {UnsignedIntType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Estimated total number of participants to be enrolled", formalDefinition="Estimated total number of participants to be enrolled." )
        protected UnsignedIntType targetNumber;

        /**
         * Actual total number of participants enrolled in study.
         */
        @Child(name = "actualNumber", type = {UnsignedIntType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Actual total number of participants enrolled in study", formalDefinition="Actual total number of participants enrolled in study." )
        protected UnsignedIntType actualNumber;

        /**
         * Inclusion and exclusion criteria.
         */
        @Child(name = "eligibility", type = {Group.class, EvidenceVariable.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Inclusion and exclusion criteria", formalDefinition="Inclusion and exclusion criteria." )
        protected Reference eligibility;

        /**
         * Group of participants who were enrolled in study.
         */
        @Child(name = "actualGroup", type = {Group.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Group of participants who were enrolled in study", formalDefinition="Group of participants who were enrolled in study." )
        protected Reference actualGroup;

        private static final long serialVersionUID = 1483229827L;

    /**
     * Constructor
     */
      public ResearchStudyRecruitmentComponent() {
        super();
      }

        /**
         * @return {@link #targetNumber} (Estimated total number of participants to be enrolled.). This is the underlying object with id, value and extensions. The accessor "getTargetNumber" gives direct access to the value
         */
        public UnsignedIntType getTargetNumberElement() { 
          if (this.targetNumber == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyRecruitmentComponent.targetNumber");
            else if (Configuration.doAutoCreate())
              this.targetNumber = new UnsignedIntType(); // bb
          return this.targetNumber;
        }

        public boolean hasTargetNumberElement() { 
          return this.targetNumber != null && !this.targetNumber.isEmpty();
        }

        public boolean hasTargetNumber() { 
          return this.targetNumber != null && !this.targetNumber.isEmpty();
        }

        /**
         * @param value {@link #targetNumber} (Estimated total number of participants to be enrolled.). This is the underlying object with id, value and extensions. The accessor "getTargetNumber" gives direct access to the value
         */
        public ResearchStudyRecruitmentComponent setTargetNumberElement(UnsignedIntType value) { 
          this.targetNumber = value;
          return this;
        }

        /**
         * @return Estimated total number of participants to be enrolled.
         */
        public int getTargetNumber() { 
          return this.targetNumber == null || this.targetNumber.isEmpty() ? 0 : this.targetNumber.getValue();
        }

        /**
         * @param value Estimated total number of participants to be enrolled.
         */
        public ResearchStudyRecruitmentComponent setTargetNumber(int value) { 
            if (this.targetNumber == null)
              this.targetNumber = new UnsignedIntType();
            this.targetNumber.setValue(value);
          return this;
        }

        /**
         * @return {@link #actualNumber} (Actual total number of participants enrolled in study.). This is the underlying object with id, value and extensions. The accessor "getActualNumber" gives direct access to the value
         */
        public UnsignedIntType getActualNumberElement() { 
          if (this.actualNumber == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyRecruitmentComponent.actualNumber");
            else if (Configuration.doAutoCreate())
              this.actualNumber = new UnsignedIntType(); // bb
          return this.actualNumber;
        }

        public boolean hasActualNumberElement() { 
          return this.actualNumber != null && !this.actualNumber.isEmpty();
        }

        public boolean hasActualNumber() { 
          return this.actualNumber != null && !this.actualNumber.isEmpty();
        }

        /**
         * @param value {@link #actualNumber} (Actual total number of participants enrolled in study.). This is the underlying object with id, value and extensions. The accessor "getActualNumber" gives direct access to the value
         */
        public ResearchStudyRecruitmentComponent setActualNumberElement(UnsignedIntType value) { 
          this.actualNumber = value;
          return this;
        }

        /**
         * @return Actual total number of participants enrolled in study.
         */
        public int getActualNumber() { 
          return this.actualNumber == null || this.actualNumber.isEmpty() ? 0 : this.actualNumber.getValue();
        }

        /**
         * @param value Actual total number of participants enrolled in study.
         */
        public ResearchStudyRecruitmentComponent setActualNumber(int value) { 
            if (this.actualNumber == null)
              this.actualNumber = new UnsignedIntType();
            this.actualNumber.setValue(value);
          return this;
        }

        /**
         * @return {@link #eligibility} (Inclusion and exclusion criteria.)
         */
        public Reference getEligibility() { 
          if (this.eligibility == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyRecruitmentComponent.eligibility");
            else if (Configuration.doAutoCreate())
              this.eligibility = new Reference(); // cc
          return this.eligibility;
        }

        public boolean hasEligibility() { 
          return this.eligibility != null && !this.eligibility.isEmpty();
        }

        /**
         * @param value {@link #eligibility} (Inclusion and exclusion criteria.)
         */
        public ResearchStudyRecruitmentComponent setEligibility(Reference value) { 
          this.eligibility = value;
          return this;
        }

        /**
         * @return {@link #actualGroup} (Group of participants who were enrolled in study.)
         */
        public Reference getActualGroup() { 
          if (this.actualGroup == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyRecruitmentComponent.actualGroup");
            else if (Configuration.doAutoCreate())
              this.actualGroup = new Reference(); // cc
          return this.actualGroup;
        }

        public boolean hasActualGroup() { 
          return this.actualGroup != null && !this.actualGroup.isEmpty();
        }

        /**
         * @param value {@link #actualGroup} (Group of participants who were enrolled in study.)
         */
        public ResearchStudyRecruitmentComponent setActualGroup(Reference value) { 
          this.actualGroup = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("targetNumber", "unsignedInt", "Estimated total number of participants to be enrolled.", 0, 1, targetNumber));
          children.add(new Property("actualNumber", "unsignedInt", "Actual total number of participants enrolled in study.", 0, 1, actualNumber));
          children.add(new Property("eligibility", "Reference(Group|EvidenceVariable)", "Inclusion and exclusion criteria.", 0, 1, eligibility));
          children.add(new Property("actualGroup", "Reference(Group)", "Group of participants who were enrolled in study.", 0, 1, actualGroup));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -682948550: /*targetNumber*/  return new Property("targetNumber", "unsignedInt", "Estimated total number of participants to be enrolled.", 0, 1, targetNumber);
          case 746557047: /*actualNumber*/  return new Property("actualNumber", "unsignedInt", "Actual total number of participants enrolled in study.", 0, 1, actualNumber);
          case -930847859: /*eligibility*/  return new Property("eligibility", "Reference(Group|EvidenceVariable)", "Inclusion and exclusion criteria.", 0, 1, eligibility);
          case 1403004305: /*actualGroup*/  return new Property("actualGroup", "Reference(Group)", "Group of participants who were enrolled in study.", 0, 1, actualGroup);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -682948550: /*targetNumber*/ return this.targetNumber == null ? new Base[0] : new Base[] {this.targetNumber}; // UnsignedIntType
        case 746557047: /*actualNumber*/ return this.actualNumber == null ? new Base[0] : new Base[] {this.actualNumber}; // UnsignedIntType
        case -930847859: /*eligibility*/ return this.eligibility == null ? new Base[0] : new Base[] {this.eligibility}; // Reference
        case 1403004305: /*actualGroup*/ return this.actualGroup == null ? new Base[0] : new Base[] {this.actualGroup}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -682948550: // targetNumber
          this.targetNumber = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 746557047: // actualNumber
          this.actualNumber = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case -930847859: // eligibility
          this.eligibility = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1403004305: // actualGroup
          this.actualGroup = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("targetNumber")) {
          this.targetNumber = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("actualNumber")) {
          this.actualNumber = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("eligibility")) {
          this.eligibility = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("actualGroup")) {
          this.actualGroup = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -682948550:  return getTargetNumberElement();
        case 746557047:  return getActualNumberElement();
        case -930847859:  return getEligibility();
        case 1403004305:  return getActualGroup();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -682948550: /*targetNumber*/ return new String[] {"unsignedInt"};
        case 746557047: /*actualNumber*/ return new String[] {"unsignedInt"};
        case -930847859: /*eligibility*/ return new String[] {"Reference"};
        case 1403004305: /*actualGroup*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("targetNumber")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.recruitment.targetNumber");
        }
        else if (name.equals("actualNumber")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.recruitment.actualNumber");
        }
        else if (name.equals("eligibility")) {
          this.eligibility = new Reference();
          return this.eligibility;
        }
        else if (name.equals("actualGroup")) {
          this.actualGroup = new Reference();
          return this.actualGroup;
        }
        else
          return super.addChild(name);
      }

      public ResearchStudyRecruitmentComponent copy() {
        ResearchStudyRecruitmentComponent dst = new ResearchStudyRecruitmentComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResearchStudyRecruitmentComponent dst) {
        super.copyValues(dst);
        dst.targetNumber = targetNumber == null ? null : targetNumber.copy();
        dst.actualNumber = actualNumber == null ? null : actualNumber.copy();
        dst.eligibility = eligibility == null ? null : eligibility.copy();
        dst.actualGroup = actualGroup == null ? null : actualGroup.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResearchStudyRecruitmentComponent))
          return false;
        ResearchStudyRecruitmentComponent o = (ResearchStudyRecruitmentComponent) other_;
        return compareDeep(targetNumber, o.targetNumber, true) && compareDeep(actualNumber, o.actualNumber, true)
           && compareDeep(eligibility, o.eligibility, true) && compareDeep(actualGroup, o.actualGroup, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResearchStudyRecruitmentComponent))
          return false;
        ResearchStudyRecruitmentComponent o = (ResearchStudyRecruitmentComponent) other_;
        return compareValues(targetNumber, o.targetNumber, true) && compareValues(actualNumber, o.actualNumber, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(targetNumber, actualNumber
          , eligibility, actualGroup);
      }

  public String fhirType() {
    return "ResearchStudy.recruitment";

  }

  }

    @Block()
    public static class ResearchStudyComparisonGroupComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Allows the comparisonGroup for the study and the comparisonGroup for the subject to be linked easily.
         */
        @Child(name = "linkId", type = {IdType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Allows the comparisonGroup for the study and the comparisonGroup for the subject to be linked easily", formalDefinition="Allows the comparisonGroup for the study and the comparisonGroup for the subject to be linked easily." )
        protected IdType linkId;

        /**
         * Unique, human-readable label for this comparisonGroup of the study.
         */
        @Child(name = "name", type = {StringType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for study comparisonGroup", formalDefinition="Unique, human-readable label for this comparisonGroup of the study." )
        protected StringType name;

        /**
         * Categorization of study comparisonGroup, e.g. experimental, active comparator, placebo comparater.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Categorization of study comparisonGroup", formalDefinition="Categorization of study comparisonGroup, e.g. experimental, active comparator, placebo comparater." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-study-arm-type")
        protected CodeableConcept type;

        /**
         * A succinct description of the path through the study that would be followed by a subject adhering to this comparisonGroup.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Short explanation of study path", formalDefinition="A succinct description of the path through the study that would be followed by a subject adhering to this comparisonGroup." )
        protected MarkdownType description;

        /**
         * Interventions or exposures in this comparisonGroup or cohort.
         */
        @Child(name = "intendedExposure", type = {EvidenceVariable.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Interventions or exposures in this comparisonGroup or cohort", formalDefinition="Interventions or exposures in this comparisonGroup or cohort." )
        protected List<Reference> intendedExposure;

        /**
         * Group of participants who were enrolled in study comparisonGroup.
         */
        @Child(name = "observedGroup", type = {Group.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Group of participants who were enrolled in study comparisonGroup", formalDefinition="Group of participants who were enrolled in study comparisonGroup." )
        protected Reference observedGroup;

        private static final long serialVersionUID = 1107310853L;

    /**
     * Constructor
     */
      public ResearchStudyComparisonGroupComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ResearchStudyComparisonGroupComponent(String name) {
        super();
        this.setName(name);
      }

        /**
         * @return {@link #linkId} (Allows the comparisonGroup for the study and the comparisonGroup for the subject to be linked easily.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public IdType getLinkIdElement() { 
          if (this.linkId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyComparisonGroupComponent.linkId");
            else if (Configuration.doAutoCreate())
              this.linkId = new IdType(); // bb
          return this.linkId;
        }

        public boolean hasLinkIdElement() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        public boolean hasLinkId() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        /**
         * @param value {@link #linkId} (Allows the comparisonGroup for the study and the comparisonGroup for the subject to be linked easily.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public ResearchStudyComparisonGroupComponent setLinkIdElement(IdType value) { 
          this.linkId = value;
          return this;
        }

        /**
         * @return Allows the comparisonGroup for the study and the comparisonGroup for the subject to be linked easily.
         */
        public String getLinkId() { 
          return this.linkId == null ? null : this.linkId.getValue();
        }

        /**
         * @param value Allows the comparisonGroup for the study and the comparisonGroup for the subject to be linked easily.
         */
        public ResearchStudyComparisonGroupComponent setLinkId(String value) { 
          if (Utilities.noString(value))
            this.linkId = null;
          else {
            if (this.linkId == null)
              this.linkId = new IdType();
            this.linkId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #name} (Unique, human-readable label for this comparisonGroup of the study.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyComparisonGroupComponent.name");
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
         * @param value {@link #name} (Unique, human-readable label for this comparisonGroup of the study.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public ResearchStudyComparisonGroupComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Unique, human-readable label for this comparisonGroup of the study.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Unique, human-readable label for this comparisonGroup of the study.
         */
        public ResearchStudyComparisonGroupComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (Categorization of study comparisonGroup, e.g. experimental, active comparator, placebo comparater.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyComparisonGroupComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Categorization of study comparisonGroup, e.g. experimental, active comparator, placebo comparater.)
         */
        public ResearchStudyComparisonGroupComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #description} (A succinct description of the path through the study that would be followed by a subject adhering to this comparisonGroup.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyComparisonGroupComponent.description");
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
         * @param value {@link #description} (A succinct description of the path through the study that would be followed by a subject adhering to this comparisonGroup.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ResearchStudyComparisonGroupComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A succinct description of the path through the study that would be followed by a subject adhering to this comparisonGroup.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A succinct description of the path through the study that would be followed by a subject adhering to this comparisonGroup.
         */
        public ResearchStudyComparisonGroupComponent setDescription(String value) { 
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
         * @return {@link #intendedExposure} (Interventions or exposures in this comparisonGroup or cohort.)
         */
        public List<Reference> getIntendedExposure() { 
          if (this.intendedExposure == null)
            this.intendedExposure = new ArrayList<Reference>();
          return this.intendedExposure;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ResearchStudyComparisonGroupComponent setIntendedExposure(List<Reference> theIntendedExposure) { 
          this.intendedExposure = theIntendedExposure;
          return this;
        }

        public boolean hasIntendedExposure() { 
          if (this.intendedExposure == null)
            return false;
          for (Reference item : this.intendedExposure)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addIntendedExposure() { //3
          Reference t = new Reference();
          if (this.intendedExposure == null)
            this.intendedExposure = new ArrayList<Reference>();
          this.intendedExposure.add(t);
          return t;
        }

        public ResearchStudyComparisonGroupComponent addIntendedExposure(Reference t) { //3
          if (t == null)
            return this;
          if (this.intendedExposure == null)
            this.intendedExposure = new ArrayList<Reference>();
          this.intendedExposure.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #intendedExposure}, creating it if it does not already exist {3}
         */
        public Reference getIntendedExposureFirstRep() { 
          if (getIntendedExposure().isEmpty()) {
            addIntendedExposure();
          }
          return getIntendedExposure().get(0);
        }

        /**
         * @return {@link #observedGroup} (Group of participants who were enrolled in study comparisonGroup.)
         */
        public Reference getObservedGroup() { 
          if (this.observedGroup == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyComparisonGroupComponent.observedGroup");
            else if (Configuration.doAutoCreate())
              this.observedGroup = new Reference(); // cc
          return this.observedGroup;
        }

        public boolean hasObservedGroup() { 
          return this.observedGroup != null && !this.observedGroup.isEmpty();
        }

        /**
         * @param value {@link #observedGroup} (Group of participants who were enrolled in study comparisonGroup.)
         */
        public ResearchStudyComparisonGroupComponent setObservedGroup(Reference value) { 
          this.observedGroup = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("linkId", "id", "Allows the comparisonGroup for the study and the comparisonGroup for the subject to be linked easily.", 0, 1, linkId));
          children.add(new Property("name", "string", "Unique, human-readable label for this comparisonGroup of the study.", 0, 1, name));
          children.add(new Property("type", "CodeableConcept", "Categorization of study comparisonGroup, e.g. experimental, active comparator, placebo comparater.", 0, 1, type));
          children.add(new Property("description", "markdown", "A succinct description of the path through the study that would be followed by a subject adhering to this comparisonGroup.", 0, 1, description));
          children.add(new Property("intendedExposure", "Reference(EvidenceVariable)", "Interventions or exposures in this comparisonGroup or cohort.", 0, java.lang.Integer.MAX_VALUE, intendedExposure));
          children.add(new Property("observedGroup", "Reference(Group)", "Group of participants who were enrolled in study comparisonGroup.", 0, 1, observedGroup));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1102667083: /*linkId*/  return new Property("linkId", "id", "Allows the comparisonGroup for the study and the comparisonGroup for the subject to be linked easily.", 0, 1, linkId);
          case 3373707: /*name*/  return new Property("name", "string", "Unique, human-readable label for this comparisonGroup of the study.", 0, 1, name);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Categorization of study comparisonGroup, e.g. experimental, active comparator, placebo comparater.", 0, 1, type);
          case -1724546052: /*description*/  return new Property("description", "markdown", "A succinct description of the path through the study that would be followed by a subject adhering to this comparisonGroup.", 0, 1, description);
          case -407218606: /*intendedExposure*/  return new Property("intendedExposure", "Reference(EvidenceVariable)", "Interventions or exposures in this comparisonGroup or cohort.", 0, java.lang.Integer.MAX_VALUE, intendedExposure);
          case 375599255: /*observedGroup*/  return new Property("observedGroup", "Reference(Group)", "Group of participants who were enrolled in study comparisonGroup.", 0, 1, observedGroup);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return this.linkId == null ? new Base[0] : new Base[] {this.linkId}; // IdType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -407218606: /*intendedExposure*/ return this.intendedExposure == null ? new Base[0] : this.intendedExposure.toArray(new Base[this.intendedExposure.size()]); // Reference
        case 375599255: /*observedGroup*/ return this.observedGroup == null ? new Base[0] : new Base[] {this.observedGroup}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1102667083: // linkId
          this.linkId = TypeConvertor.castToId(value); // IdType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -407218606: // intendedExposure
          this.getIntendedExposure().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 375599255: // observedGroup
          this.observedGroup = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("intendedExposure")) {
          this.getIntendedExposure().add(TypeConvertor.castToReference(value));
        } else if (name.equals("observedGroup")) {
          this.observedGroup = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083:  return getLinkIdElement();
        case 3373707:  return getNameElement();
        case 3575610:  return getType();
        case -1724546052:  return getDescriptionElement();
        case -407218606:  return addIntendedExposure(); 
        case 375599255:  return getObservedGroup();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return new String[] {"id"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -407218606: /*intendedExposure*/ return new String[] {"Reference"};
        case 375599255: /*observedGroup*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkId")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.comparisonGroup.linkId");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.comparisonGroup.name");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.comparisonGroup.description");
        }
        else if (name.equals("intendedExposure")) {
          return addIntendedExposure();
        }
        else if (name.equals("observedGroup")) {
          this.observedGroup = new Reference();
          return this.observedGroup;
        }
        else
          return super.addChild(name);
      }

      public ResearchStudyComparisonGroupComponent copy() {
        ResearchStudyComparisonGroupComponent dst = new ResearchStudyComparisonGroupComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResearchStudyComparisonGroupComponent dst) {
        super.copyValues(dst);
        dst.linkId = linkId == null ? null : linkId.copy();
        dst.name = name == null ? null : name.copy();
        dst.type = type == null ? null : type.copy();
        dst.description = description == null ? null : description.copy();
        if (intendedExposure != null) {
          dst.intendedExposure = new ArrayList<Reference>();
          for (Reference i : intendedExposure)
            dst.intendedExposure.add(i.copy());
        };
        dst.observedGroup = observedGroup == null ? null : observedGroup.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResearchStudyComparisonGroupComponent))
          return false;
        ResearchStudyComparisonGroupComponent o = (ResearchStudyComparisonGroupComponent) other_;
        return compareDeep(linkId, o.linkId, true) && compareDeep(name, o.name, true) && compareDeep(type, o.type, true)
           && compareDeep(description, o.description, true) && compareDeep(intendedExposure, o.intendedExposure, true)
           && compareDeep(observedGroup, o.observedGroup, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResearchStudyComparisonGroupComponent))
          return false;
        ResearchStudyComparisonGroupComponent o = (ResearchStudyComparisonGroupComponent) other_;
        return compareValues(linkId, o.linkId, true) && compareValues(name, o.name, true) && compareValues(description, o.description, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(linkId, name, type, description
          , intendedExposure, observedGroup);
      }

  public String fhirType() {
    return "ResearchStudy.comparisonGroup";

  }

  }

    @Block()
    public static class ResearchStudyObjectiveComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Unique, human-readable label for this objective of the study.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for the objective", formalDefinition="Unique, human-readable label for this objective of the study." )
        protected StringType name;

        /**
         * The kind of study objective.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="primary | secondary | exploratory", formalDefinition="The kind of study objective." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-study-objective-type")
        protected CodeableConcept type;

        /**
         * Free text description of the objective of the study.  This is what the study is trying to achieve rather than how it is going to achieve it (see ResearchStudy.description).
         */
        @Child(name = "description", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of the objective", formalDefinition="Free text description of the objective of the study.  This is what the study is trying to achieve rather than how it is going to achieve it (see ResearchStudy.description)." )
        protected MarkdownType description;

        private static final long serialVersionUID = -1976083810L;

    /**
     * Constructor
     */
      public ResearchStudyObjectiveComponent() {
        super();
      }

        /**
         * @return {@link #name} (Unique, human-readable label for this objective of the study.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyObjectiveComponent.name");
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
         * @param value {@link #name} (Unique, human-readable label for this objective of the study.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public ResearchStudyObjectiveComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Unique, human-readable label for this objective of the study.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Unique, human-readable label for this objective of the study.
         */
        public ResearchStudyObjectiveComponent setName(String value) { 
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
         * @return {@link #type} (The kind of study objective.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyObjectiveComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The kind of study objective.)
         */
        public ResearchStudyObjectiveComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #description} (Free text description of the objective of the study.  This is what the study is trying to achieve rather than how it is going to achieve it (see ResearchStudy.description).). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyObjectiveComponent.description");
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
         * @param value {@link #description} (Free text description of the objective of the study.  This is what the study is trying to achieve rather than how it is going to achieve it (see ResearchStudy.description).). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ResearchStudyObjectiveComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Free text description of the objective of the study.  This is what the study is trying to achieve rather than how it is going to achieve it (see ResearchStudy.description).
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Free text description of the objective of the study.  This is what the study is trying to achieve rather than how it is going to achieve it (see ResearchStudy.description).
         */
        public ResearchStudyObjectiveComponent setDescription(String value) { 
          if (Utilities.noString(value))
            this.description = null;
          else {
            if (this.description == null)
              this.description = new MarkdownType();
            this.description.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Unique, human-readable label for this objective of the study.", 0, 1, name));
          children.add(new Property("type", "CodeableConcept", "The kind of study objective.", 0, 1, type));
          children.add(new Property("description", "markdown", "Free text description of the objective of the study.  This is what the study is trying to achieve rather than how it is going to achieve it (see ResearchStudy.description).", 0, 1, description));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Unique, human-readable label for this objective of the study.", 0, 1, name);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The kind of study objective.", 0, 1, type);
          case -1724546052: /*description*/  return new Property("description", "markdown", "Free text description of the objective of the study.  This is what the study is trying to achieve rather than how it is going to achieve it (see ResearchStudy.description).", 0, 1, description);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 3575610:  return getType();
        case -1724546052:  return getDescriptionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.objective.name");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.objective.description");
        }
        else
          return super.addChild(name);
      }

      public ResearchStudyObjectiveComponent copy() {
        ResearchStudyObjectiveComponent dst = new ResearchStudyObjectiveComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResearchStudyObjectiveComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.type = type == null ? null : type.copy();
        dst.description = description == null ? null : description.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResearchStudyObjectiveComponent))
          return false;
        ResearchStudyObjectiveComponent o = (ResearchStudyObjectiveComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(type, o.type, true) && compareDeep(description, o.description, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResearchStudyObjectiveComponent))
          return false;
        ResearchStudyObjectiveComponent o = (ResearchStudyObjectiveComponent) other_;
        return compareValues(name, o.name, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, type, description
          );
      }

  public String fhirType() {
    return "ResearchStudy.objective";

  }

  }

    @Block()
    public static class ResearchStudyOutcomeMeasureComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Label for the outcome.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for the outcome", formalDefinition="Label for the outcome." )
        protected StringType name;

        /**
         * The parameter or characteristic being assessed as one of the values by which the study is assessed.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="primary | secondary | exploratory", formalDefinition="The parameter or characteristic being assessed as one of the values by which the study is assessed." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-study-objective-type")
        protected List<CodeableConcept> type;

        /**
         * Description of the outcome.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of the outcome", formalDefinition="Description of the outcome." )
        protected MarkdownType description;

        /**
         * Structured outcome definition.
         */
        @Child(name = "reference", type = {EvidenceVariable.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Structured outcome definition", formalDefinition="Structured outcome definition." )
        protected Reference reference;

        private static final long serialVersionUID = 1786559672L;

    /**
     * Constructor
     */
      public ResearchStudyOutcomeMeasureComponent() {
        super();
      }

        /**
         * @return {@link #name} (Label for the outcome.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyOutcomeMeasureComponent.name");
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
         * @param value {@link #name} (Label for the outcome.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public ResearchStudyOutcomeMeasureComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Label for the outcome.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Label for the outcome.
         */
        public ResearchStudyOutcomeMeasureComponent setName(String value) { 
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
         * @return {@link #type} (The parameter or characteristic being assessed as one of the values by which the study is assessed.)
         */
        public List<CodeableConcept> getType() { 
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          return this.type;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ResearchStudyOutcomeMeasureComponent setType(List<CodeableConcept> theType) { 
          this.type = theType;
          return this;
        }

        public boolean hasType() { 
          if (this.type == null)
            return false;
          for (CodeableConcept item : this.type)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addType() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          this.type.add(t);
          return t;
        }

        public ResearchStudyOutcomeMeasureComponent addType(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.type == null)
            this.type = new ArrayList<CodeableConcept>();
          this.type.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist {3}
         */
        public CodeableConcept getTypeFirstRep() { 
          if (getType().isEmpty()) {
            addType();
          }
          return getType().get(0);
        }

        /**
         * @return {@link #description} (Description of the outcome.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyOutcomeMeasureComponent.description");
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
         * @param value {@link #description} (Description of the outcome.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ResearchStudyOutcomeMeasureComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Description of the outcome.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Description of the outcome.
         */
        public ResearchStudyOutcomeMeasureComponent setDescription(String value) { 
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
         * @return {@link #reference} (Structured outcome definition.)
         */
        public Reference getReference() { 
          if (this.reference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchStudyOutcomeMeasureComponent.reference");
            else if (Configuration.doAutoCreate())
              this.reference = new Reference(); // cc
          return this.reference;
        }

        public boolean hasReference() { 
          return this.reference != null && !this.reference.isEmpty();
        }

        /**
         * @param value {@link #reference} (Structured outcome definition.)
         */
        public ResearchStudyOutcomeMeasureComponent setReference(Reference value) { 
          this.reference = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Label for the outcome.", 0, 1, name));
          children.add(new Property("type", "CodeableConcept", "The parameter or characteristic being assessed as one of the values by which the study is assessed.", 0, java.lang.Integer.MAX_VALUE, type));
          children.add(new Property("description", "markdown", "Description of the outcome.", 0, 1, description));
          children.add(new Property("reference", "Reference(EvidenceVariable)", "Structured outcome definition.", 0, 1, reference));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Label for the outcome.", 0, 1, name);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The parameter or characteristic being assessed as one of the values by which the study is assessed.", 0, java.lang.Integer.MAX_VALUE, type);
          case -1724546052: /*description*/  return new Property("description", "markdown", "Description of the outcome.", 0, 1, description);
          case -925155509: /*reference*/  return new Property("reference", "Reference(EvidenceVariable)", "Structured outcome definition.", 0, 1, reference);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : new Base[] {this.reference}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -925155509: // reference
          this.reference = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("reference")) {
          this.reference = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 3575610:  return addType(); 
        case -1724546052:  return getDescriptionElement();
        case -925155509:  return getReference();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -925155509: /*reference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.outcomeMeasure.name");
        }
        else if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.outcomeMeasure.description");
        }
        else if (name.equals("reference")) {
          this.reference = new Reference();
          return this.reference;
        }
        else
          return super.addChild(name);
      }

      public ResearchStudyOutcomeMeasureComponent copy() {
        ResearchStudyOutcomeMeasureComponent dst = new ResearchStudyOutcomeMeasureComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResearchStudyOutcomeMeasureComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        dst.reference = reference == null ? null : reference.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResearchStudyOutcomeMeasureComponent))
          return false;
        ResearchStudyOutcomeMeasureComponent o = (ResearchStudyOutcomeMeasureComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(type, o.type, true) && compareDeep(description, o.description, true)
           && compareDeep(reference, o.reference, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResearchStudyOutcomeMeasureComponent))
          return false;
        ResearchStudyOutcomeMeasureComponent o = (ResearchStudyOutcomeMeasureComponent) other_;
        return compareValues(name, o.name, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, type, description
          , reference);
      }

  public String fhirType() {
    return "ResearchStudy.outcomeMeasure";

  }

  }

    /**
     * Canonical identifier for this study resource, represented as a globally unique URI.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Canonical identifier for this study resource", formalDefinition="Canonical identifier for this study resource, represented as a globally unique URI." )
    protected UriType url;

    /**
     * Identifiers assigned to this research study by the sponsor or other systems.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business Identifier for study", formalDefinition="Identifiers assigned to this research study by the sponsor or other systems." )
    protected List<Identifier> identifier;

    /**
     * The business version for the study record.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The business version for the study record", formalDefinition="The business version for the study record." )
    protected StringType version;

    /**
     * Name for this study (computer friendly).
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Name for this study (computer friendly)", formalDefinition="Name for this study (computer friendly)." )
    protected StringType name;

    /**
     * The human readable name of the research study.
     */
    @Child(name = "title", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Human readable name of the study", formalDefinition="The human readable name of the research study." )
    protected StringType title;

    /**
     * Additional names for the study.
     */
    @Child(name = "label", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional names for the study", formalDefinition="Additional names for the study." )
    protected List<ResearchStudyLabelComponent> label;

    /**
     * The set of steps expected to be performed as part of the execution of the study.
     */
    @Child(name = "protocol", type = {PlanDefinition.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Steps followed in executing study", formalDefinition="The set of steps expected to be performed as part of the execution of the study." )
    protected List<Reference> protocol;

    /**
     * A larger research study of which this particular study is a component or step.
     */
    @Child(name = "partOf", type = {ResearchStudy.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Part of larger study", formalDefinition="A larger research study of which this particular study is a component or step." )
    protected List<Reference> partOf;

    /**
     * Citations, references, URLs and other related documents.  When using relatedArtifact to share URLs, the relatedArtifact.type will often be set to one of "documentation" or "supported-with" and the URL value will often be in relatedArtifact.document.url but another possible location is relatedArtifact.resource when it is a canonical URL.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="References, URLs, and attachments", formalDefinition="Citations, references, URLs and other related documents.  When using relatedArtifact to share URLs, the relatedArtifact.type will often be set to one of \"documentation\" or \"supported-with\" and the URL value will often be in relatedArtifact.document.url but another possible location is relatedArtifact.resource when it is a canonical URL." )
    protected List<RelatedArtifact> relatedArtifact;

    /**
     * The date (and optionally time) when the ResearchStudy Resource was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ResearchStudy Resource changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Date the resource last changed", formalDefinition="The date (and optionally time) when the ResearchStudy Resource was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ResearchStudy Resource changes." )
    protected DateTimeType date;

    /**
     * The publication state of the resource (not of the study).
     */
    @Child(name = "status", type = {CodeType.class}, order=10, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The publication state of the resource (not of the study)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * The type of study based upon the intent of the study activities. A classification of the intent of the study.
     */
    @Child(name = "primaryPurposeType", type = {CodeableConcept.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="treatment | prevention | diagnostic | supportive-care | screening | health-services-research | basic-science | device-feasibility", formalDefinition="The type of study based upon the intent of the study activities. A classification of the intent of the study." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-study-prim-purp-type")
    protected CodeableConcept primaryPurposeType;

    /**
     * The stage in the progression of a therapy from initial experimental use in humans in clinical trials to post-market evaluation.
     */
    @Child(name = "phase", type = {CodeableConcept.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="n-a | early-phase-1 | phase-1 | phase-1-phase-2 | phase-2 | phase-2-phase-3 | phase-3 | phase-4", formalDefinition="The stage in the progression of a therapy from initial experimental use in humans in clinical trials to post-market evaluation." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-study-phase")
    protected CodeableConcept phase;

    /**
     * Codes categorizing the type of study such as investigational vs. observational, type of blinding, type of randomization, safety vs. efficacy, etc.
     */
    @Child(name = "studyDesign", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Classifications of the study design characteristics", formalDefinition="Codes categorizing the type of study such as investigational vs. observational, type of blinding, type of randomization, safety vs. efficacy, etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/study-design")
    protected List<CodeableConcept> studyDesign;

    /**
     * The medication(s), food(s), therapy(ies), device(s) or other concerns or interventions that the study is seeking to gain more information about.
     */
    @Child(name = "focus", type = {CodeableReference.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Drugs, devices, etc. under study", formalDefinition="The medication(s), food(s), therapy(ies), device(s) or other concerns or interventions that the study is seeking to gain more information about." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-study-focus-type")
    protected List<CodeableReference> focus;

    /**
     * The condition that is the focus of the study.  For example, In a study to examine risk factors for Lupus, might have as an inclusion criterion "healthy volunteer", but the target condition code would be a Lupus SNOMED code.
     */
    @Child(name = "condition", type = {CodeableConcept.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Condition being studied", formalDefinition="The condition that is the focus of the study.  For example, In a study to examine risk factors for Lupus, might have as an inclusion criterion \"healthy volunteer\", but the target condition code would be a Lupus SNOMED code." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
    protected List<CodeableConcept> condition;

    /**
     * Key terms to aid in searching for or filtering the study.
     */
    @Child(name = "keyword", type = {CodeableConcept.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Used to search for the study", formalDefinition="Key terms to aid in searching for or filtering the study." )
    protected List<CodeableConcept> keyword;

    /**
     * A country, state or other area where the study is taking place rather than its precise geographic location or address.
     */
    @Child(name = "region", type = {CodeableConcept.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Geographic area for the study", formalDefinition="A country, state or other area where the study is taking place rather than its precise geographic location or address." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> region;

    /**
     * A brief text for explaining the study.
     */
    @Child(name = "descriptionSummary", type = {MarkdownType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Brief text explaining the study", formalDefinition="A brief text for explaining the study." )
    protected MarkdownType descriptionSummary;

    /**
     * A detailed and human-readable narrative of the study. E.g., study abstract.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Detailed narrative of the study", formalDefinition="A detailed and human-readable narrative of the study. E.g., study abstract." )
    protected MarkdownType description;

    /**
     * Identifies the start date and the expected (or actual, depending on status) end date for the study.
     */
    @Child(name = "period", type = {Period.class}, order=20, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the study began and ended", formalDefinition="Identifies the start date and the expected (or actual, depending on status) end date for the study." )
    protected Period period;

    /**
     * A facility in which study activities are conducted.
     */
    @Child(name = "site", type = {Location.class, ResearchStudy.class, Organization.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Facility where study activities are conducted", formalDefinition="A facility in which study activities are conducted." )
    protected List<Reference> site;

    /**
     * Comments made about the study by the performer, subject or other participants.
     */
    @Child(name = "note", type = {Annotation.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments made about the study", formalDefinition="Comments made about the study by the performer, subject or other participants." )
    protected List<Annotation> note;

    /**
     * Additional grouping mechanism or categorization of a research study. Example: FDA regulated device, FDA regulated drug, MPG Paragraph 23b (a German legal requirement), IRB-exempt, etc. Implementation Note: do not use the classifier element to support existing semantics that are already supported thru explicit elements in the resource.
     */
    @Child(name = "classifier", type = {CodeableConcept.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Classification for the study", formalDefinition="Additional grouping mechanism or categorization of a research study. Example: FDA regulated device, FDA regulated drug, MPG Paragraph 23b (a German legal requirement), IRB-exempt, etc. Implementation Note: do not use the classifier element to support existing semantics that are already supported thru explicit elements in the resource." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-study-classifiers")
    protected List<CodeableConcept> classifier;

    /**
     * Sponsors, collaborators, and other parties.
     */
    @Child(name = "associatedParty", type = {}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Sponsors, collaborators, and other parties", formalDefinition="Sponsors, collaborators, and other parties." )
    protected List<ResearchStudyAssociatedPartyComponent> associatedParty;

    /**
     * Status of study with time for that status.
     */
    @Child(name = "progressStatus", type = {}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Status of study with time for that status", formalDefinition="Status of study with time for that status." )
    protected List<ResearchStudyProgressStatusComponent> progressStatus;

    /**
     * A description and/or code explaining the premature termination of the study.
     */
    @Child(name = "whyStopped", type = {CodeableConcept.class}, order=26, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="accrual-goal-met | closed-due-to-toxicity | closed-due-to-lack-of-study-progress | temporarily-closed-per-study-design", formalDefinition="A description and/or code explaining the premature termination of the study." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-study-reason-stopped")
    protected CodeableConcept whyStopped;

    /**
     * Target or actual group of participants enrolled in study.
     */
    @Child(name = "recruitment", type = {}, order=27, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Target or actual group of participants enrolled in study", formalDefinition="Target or actual group of participants enrolled in study." )
    protected ResearchStudyRecruitmentComponent recruitment;

    /**
     * Describes an expected event or sequence of events for one of the subjects of a study. E.g. for a living subject: exposure to drug A, wash-out, exposure to drug B, wash-out, follow-up. E.g. for a stability study: {store sample from lot A at 25 degrees for 1 month}, {store sample from lot A at 40 degrees for 1 month}.
     */
    @Child(name = "comparisonGroup", type = {}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Defined path through the study for a subject", formalDefinition="Describes an expected event or sequence of events for one of the subjects of a study. E.g. for a living subject: exposure to drug A, wash-out, exposure to drug B, wash-out, follow-up. E.g. for a stability study: {store sample from lot A at 25 degrees for 1 month}, {store sample from lot A at 40 degrees for 1 month}." )
    protected List<ResearchStudyComparisonGroupComponent> comparisonGroup;

    /**
     * A goal that the study is aiming to achieve in terms of a scientific question to be answered by the analysis of data collected during the study.
     */
    @Child(name = "objective", type = {}, order=29, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A goal for the study", formalDefinition="A goal that the study is aiming to achieve in terms of a scientific question to be answered by the analysis of data collected during the study." )
    protected List<ResearchStudyObjectiveComponent> objective;

    /**
     * An "outcome measure", "endpoint", "effect measure" or "measure of effect" is a specific measurement or observation used to quantify the effect of experimental variables on the participants in a study, or for observational studies, to describe patterns of diseases or traits or associations with exposures, risk factors or treatment.
     */
    @Child(name = "outcomeMeasure", type = {}, order=30, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A variable measured during the study", formalDefinition="An \"outcome measure\", \"endpoint\", \"effect measure\" or \"measure of effect\" is a specific measurement or observation used to quantify the effect of experimental variables on the participants in a study, or for observational studies, to describe patterns of diseases or traits or associations with exposures, risk factors or treatment." )
    protected List<ResearchStudyOutcomeMeasureComponent> outcomeMeasure;

    /**
     * Link to one or more sets of results generated by the study.  Could also link to a research registry holding the results such as ClinicalTrials.gov.
     */
    @Child(name = "result", type = {EvidenceReport.class, Citation.class, DiagnosticReport.class}, order=31, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Link to results generated during the study", formalDefinition="Link to one or more sets of results generated by the study.  Could also link to a research registry holding the results such as ClinicalTrials.gov." )
    protected List<Reference> result;

    private static final long serialVersionUID = -1217395129L;

  /**
   * Constructor
   */
    public ResearchStudy() {
      super();
    }

  /**
   * Constructor
   */
    public ResearchStudy(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (Canonical identifier for this study resource, represented as a globally unique URI.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.url");
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
     * @param value {@link #url} (Canonical identifier for this study resource, represented as a globally unique URI.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public ResearchStudy setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return Canonical identifier for this study resource, represented as a globally unique URI.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value Canonical identifier for this study resource, represented as a globally unique URI.
     */
    public ResearchStudy setUrl(String value) { 
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
     * @return {@link #identifier} (Identifiers assigned to this research study by the sponsor or other systems.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setIdentifier(List<Identifier> theIdentifier) { 
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

    public ResearchStudy addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The business version for the study record.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.version");
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
     * @param value {@link #version} (The business version for the study record.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public ResearchStudy setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The business version for the study record.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The business version for the study record.
     */
    public ResearchStudy setVersion(String value) { 
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
     * @return {@link #name} (Name for this study (computer friendly).). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.name");
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
     * @param value {@link #name} (Name for this study (computer friendly).). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public ResearchStudy setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return Name for this study (computer friendly).
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value Name for this study (computer friendly).
     */
    public ResearchStudy setName(String value) { 
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
     * @return {@link #title} (The human readable name of the research study.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.title");
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
     * @param value {@link #title} (The human readable name of the research study.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public ResearchStudy setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return The human readable name of the research study.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value The human readable name of the research study.
     */
    public ResearchStudy setTitle(String value) { 
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
     * @return {@link #label} (Additional names for the study.)
     */
    public List<ResearchStudyLabelComponent> getLabel() { 
      if (this.label == null)
        this.label = new ArrayList<ResearchStudyLabelComponent>();
      return this.label;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setLabel(List<ResearchStudyLabelComponent> theLabel) { 
      this.label = theLabel;
      return this;
    }

    public boolean hasLabel() { 
      if (this.label == null)
        return false;
      for (ResearchStudyLabelComponent item : this.label)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ResearchStudyLabelComponent addLabel() { //3
      ResearchStudyLabelComponent t = new ResearchStudyLabelComponent();
      if (this.label == null)
        this.label = new ArrayList<ResearchStudyLabelComponent>();
      this.label.add(t);
      return t;
    }

    public ResearchStudy addLabel(ResearchStudyLabelComponent t) { //3
      if (t == null)
        return this;
      if (this.label == null)
        this.label = new ArrayList<ResearchStudyLabelComponent>();
      this.label.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #label}, creating it if it does not already exist {3}
     */
    public ResearchStudyLabelComponent getLabelFirstRep() { 
      if (getLabel().isEmpty()) {
        addLabel();
      }
      return getLabel().get(0);
    }

    /**
     * @return {@link #protocol} (The set of steps expected to be performed as part of the execution of the study.)
     */
    public List<Reference> getProtocol() { 
      if (this.protocol == null)
        this.protocol = new ArrayList<Reference>();
      return this.protocol;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setProtocol(List<Reference> theProtocol) { 
      this.protocol = theProtocol;
      return this;
    }

    public boolean hasProtocol() { 
      if (this.protocol == null)
        return false;
      for (Reference item : this.protocol)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addProtocol() { //3
      Reference t = new Reference();
      if (this.protocol == null)
        this.protocol = new ArrayList<Reference>();
      this.protocol.add(t);
      return t;
    }

    public ResearchStudy addProtocol(Reference t) { //3
      if (t == null)
        return this;
      if (this.protocol == null)
        this.protocol = new ArrayList<Reference>();
      this.protocol.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #protocol}, creating it if it does not already exist {3}
     */
    public Reference getProtocolFirstRep() { 
      if (getProtocol().isEmpty()) {
        addProtocol();
      }
      return getProtocol().get(0);
    }

    /**
     * @return {@link #partOf} (A larger research study of which this particular study is a component or step.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setPartOf(List<Reference> thePartOf) { 
      this.partOf = thePartOf;
      return this;
    }

    public boolean hasPartOf() { 
      if (this.partOf == null)
        return false;
      for (Reference item : this.partOf)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPartOf() { //3
      Reference t = new Reference();
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return t;
    }

    public ResearchStudy addPartOf(Reference t) { //3
      if (t == null)
        return this;
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #partOf}, creating it if it does not already exist {3}
     */
    public Reference getPartOfFirstRep() { 
      if (getPartOf().isEmpty()) {
        addPartOf();
      }
      return getPartOf().get(0);
    }

    /**
     * @return {@link #relatedArtifact} (Citations, references, URLs and other related documents.  When using relatedArtifact to share URLs, the relatedArtifact.type will often be set to one of "documentation" or "supported-with" and the URL value will often be in relatedArtifact.document.url but another possible location is relatedArtifact.resource when it is a canonical URL.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      return this.relatedArtifact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
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

    public ResearchStudy addRelatedArtifact(RelatedArtifact t) { //3
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
     * @return {@link #date} (The date (and optionally time) when the ResearchStudy Resource was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ResearchStudy Resource changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.date");
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
     * @param value {@link #date} (The date (and optionally time) when the ResearchStudy Resource was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ResearchStudy Resource changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public ResearchStudy setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date (and optionally time) when the ResearchStudy Resource was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ResearchStudy Resource changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date (and optionally time) when the ResearchStudy Resource was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ResearchStudy Resource changes.
     */
    public ResearchStudy setDate(Date value) { 
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
     * @return {@link #status} (The publication state of the resource (not of the study).). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.status");
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
     * @param value {@link #status} (The publication state of the resource (not of the study).). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ResearchStudy setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The publication state of the resource (not of the study).
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The publication state of the resource (not of the study).
     */
    public ResearchStudy setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #primaryPurposeType} (The type of study based upon the intent of the study activities. A classification of the intent of the study.)
     */
    public CodeableConcept getPrimaryPurposeType() { 
      if (this.primaryPurposeType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.primaryPurposeType");
        else if (Configuration.doAutoCreate())
          this.primaryPurposeType = new CodeableConcept(); // cc
      return this.primaryPurposeType;
    }

    public boolean hasPrimaryPurposeType() { 
      return this.primaryPurposeType != null && !this.primaryPurposeType.isEmpty();
    }

    /**
     * @param value {@link #primaryPurposeType} (The type of study based upon the intent of the study activities. A classification of the intent of the study.)
     */
    public ResearchStudy setPrimaryPurposeType(CodeableConcept value) { 
      this.primaryPurposeType = value;
      return this;
    }

    /**
     * @return {@link #phase} (The stage in the progression of a therapy from initial experimental use in humans in clinical trials to post-market evaluation.)
     */
    public CodeableConcept getPhase() { 
      if (this.phase == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.phase");
        else if (Configuration.doAutoCreate())
          this.phase = new CodeableConcept(); // cc
      return this.phase;
    }

    public boolean hasPhase() { 
      return this.phase != null && !this.phase.isEmpty();
    }

    /**
     * @param value {@link #phase} (The stage in the progression of a therapy from initial experimental use in humans in clinical trials to post-market evaluation.)
     */
    public ResearchStudy setPhase(CodeableConcept value) { 
      this.phase = value;
      return this;
    }

    /**
     * @return {@link #studyDesign} (Codes categorizing the type of study such as investigational vs. observational, type of blinding, type of randomization, safety vs. efficacy, etc.)
     */
    public List<CodeableConcept> getStudyDesign() { 
      if (this.studyDesign == null)
        this.studyDesign = new ArrayList<CodeableConcept>();
      return this.studyDesign;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setStudyDesign(List<CodeableConcept> theStudyDesign) { 
      this.studyDesign = theStudyDesign;
      return this;
    }

    public boolean hasStudyDesign() { 
      if (this.studyDesign == null)
        return false;
      for (CodeableConcept item : this.studyDesign)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addStudyDesign() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.studyDesign == null)
        this.studyDesign = new ArrayList<CodeableConcept>();
      this.studyDesign.add(t);
      return t;
    }

    public ResearchStudy addStudyDesign(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.studyDesign == null)
        this.studyDesign = new ArrayList<CodeableConcept>();
      this.studyDesign.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #studyDesign}, creating it if it does not already exist {3}
     */
    public CodeableConcept getStudyDesignFirstRep() { 
      if (getStudyDesign().isEmpty()) {
        addStudyDesign();
      }
      return getStudyDesign().get(0);
    }

    /**
     * @return {@link #focus} (The medication(s), food(s), therapy(ies), device(s) or other concerns or interventions that the study is seeking to gain more information about.)
     */
    public List<CodeableReference> getFocus() { 
      if (this.focus == null)
        this.focus = new ArrayList<CodeableReference>();
      return this.focus;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setFocus(List<CodeableReference> theFocus) { 
      this.focus = theFocus;
      return this;
    }

    public boolean hasFocus() { 
      if (this.focus == null)
        return false;
      for (CodeableReference item : this.focus)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addFocus() { //3
      CodeableReference t = new CodeableReference();
      if (this.focus == null)
        this.focus = new ArrayList<CodeableReference>();
      this.focus.add(t);
      return t;
    }

    public ResearchStudy addFocus(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.focus == null)
        this.focus = new ArrayList<CodeableReference>();
      this.focus.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #focus}, creating it if it does not already exist {3}
     */
    public CodeableReference getFocusFirstRep() { 
      if (getFocus().isEmpty()) {
        addFocus();
      }
      return getFocus().get(0);
    }

    /**
     * @return {@link #condition} (The condition that is the focus of the study.  For example, In a study to examine risk factors for Lupus, might have as an inclusion criterion "healthy volunteer", but the target condition code would be a Lupus SNOMED code.)
     */
    public List<CodeableConcept> getCondition() { 
      if (this.condition == null)
        this.condition = new ArrayList<CodeableConcept>();
      return this.condition;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setCondition(List<CodeableConcept> theCondition) { 
      this.condition = theCondition;
      return this;
    }

    public boolean hasCondition() { 
      if (this.condition == null)
        return false;
      for (CodeableConcept item : this.condition)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCondition() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.condition == null)
        this.condition = new ArrayList<CodeableConcept>();
      this.condition.add(t);
      return t;
    }

    public ResearchStudy addCondition(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.condition == null)
        this.condition = new ArrayList<CodeableConcept>();
      this.condition.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #condition}, creating it if it does not already exist {3}
     */
    public CodeableConcept getConditionFirstRep() { 
      if (getCondition().isEmpty()) {
        addCondition();
      }
      return getCondition().get(0);
    }

    /**
     * @return {@link #keyword} (Key terms to aid in searching for or filtering the study.)
     */
    public List<CodeableConcept> getKeyword() { 
      if (this.keyword == null)
        this.keyword = new ArrayList<CodeableConcept>();
      return this.keyword;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setKeyword(List<CodeableConcept> theKeyword) { 
      this.keyword = theKeyword;
      return this;
    }

    public boolean hasKeyword() { 
      if (this.keyword == null)
        return false;
      for (CodeableConcept item : this.keyword)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addKeyword() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.keyword == null)
        this.keyword = new ArrayList<CodeableConcept>();
      this.keyword.add(t);
      return t;
    }

    public ResearchStudy addKeyword(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.keyword == null)
        this.keyword = new ArrayList<CodeableConcept>();
      this.keyword.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #keyword}, creating it if it does not already exist {3}
     */
    public CodeableConcept getKeywordFirstRep() { 
      if (getKeyword().isEmpty()) {
        addKeyword();
      }
      return getKeyword().get(0);
    }

    /**
     * @return {@link #region} (A country, state or other area where the study is taking place rather than its precise geographic location or address.)
     */
    public List<CodeableConcept> getRegion() { 
      if (this.region == null)
        this.region = new ArrayList<CodeableConcept>();
      return this.region;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setRegion(List<CodeableConcept> theRegion) { 
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

    public ResearchStudy addRegion(CodeableConcept t) { //3
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
     * @return {@link #descriptionSummary} (A brief text for explaining the study.). This is the underlying object with id, value and extensions. The accessor "getDescriptionSummary" gives direct access to the value
     */
    public MarkdownType getDescriptionSummaryElement() { 
      if (this.descriptionSummary == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.descriptionSummary");
        else if (Configuration.doAutoCreate())
          this.descriptionSummary = new MarkdownType(); // bb
      return this.descriptionSummary;
    }

    public boolean hasDescriptionSummaryElement() { 
      return this.descriptionSummary != null && !this.descriptionSummary.isEmpty();
    }

    public boolean hasDescriptionSummary() { 
      return this.descriptionSummary != null && !this.descriptionSummary.isEmpty();
    }

    /**
     * @param value {@link #descriptionSummary} (A brief text for explaining the study.). This is the underlying object with id, value and extensions. The accessor "getDescriptionSummary" gives direct access to the value
     */
    public ResearchStudy setDescriptionSummaryElement(MarkdownType value) { 
      this.descriptionSummary = value;
      return this;
    }

    /**
     * @return A brief text for explaining the study.
     */
    public String getDescriptionSummary() { 
      return this.descriptionSummary == null ? null : this.descriptionSummary.getValue();
    }

    /**
     * @param value A brief text for explaining the study.
     */
    public ResearchStudy setDescriptionSummary(String value) { 
      if (Utilities.noString(value))
        this.descriptionSummary = null;
      else {
        if (this.descriptionSummary == null)
          this.descriptionSummary = new MarkdownType();
        this.descriptionSummary.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #description} (A detailed and human-readable narrative of the study. E.g., study abstract.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.description");
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
     * @param value {@link #description} (A detailed and human-readable narrative of the study. E.g., study abstract.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public ResearchStudy setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A detailed and human-readable narrative of the study. E.g., study abstract.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A detailed and human-readable narrative of the study. E.g., study abstract.
     */
    public ResearchStudy setDescription(String value) { 
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
     * @return {@link #period} (Identifies the start date and the expected (or actual, depending on status) end date for the study.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (Identifies the start date and the expected (or actual, depending on status) end date for the study.)
     */
    public ResearchStudy setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #site} (A facility in which study activities are conducted.)
     */
    public List<Reference> getSite() { 
      if (this.site == null)
        this.site = new ArrayList<Reference>();
      return this.site;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setSite(List<Reference> theSite) { 
      this.site = theSite;
      return this;
    }

    public boolean hasSite() { 
      if (this.site == null)
        return false;
      for (Reference item : this.site)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSite() { //3
      Reference t = new Reference();
      if (this.site == null)
        this.site = new ArrayList<Reference>();
      this.site.add(t);
      return t;
    }

    public ResearchStudy addSite(Reference t) { //3
      if (t == null)
        return this;
      if (this.site == null)
        this.site = new ArrayList<Reference>();
      this.site.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #site}, creating it if it does not already exist {3}
     */
    public Reference getSiteFirstRep() { 
      if (getSite().isEmpty()) {
        addSite();
      }
      return getSite().get(0);
    }

    /**
     * @return {@link #note} (Comments made about the study by the performer, subject or other participants.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setNote(List<Annotation> theNote) { 
      this.note = theNote;
      return this;
    }

    public boolean hasNote() { 
      if (this.note == null)
        return false;
      for (Annotation item : this.note)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Annotation addNote() { //3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public ResearchStudy addNote(Annotation t) { //3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
     */
    public Annotation getNoteFirstRep() { 
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

    /**
     * @return {@link #classifier} (Additional grouping mechanism or categorization of a research study. Example: FDA regulated device, FDA regulated drug, MPG Paragraph 23b (a German legal requirement), IRB-exempt, etc. Implementation Note: do not use the classifier element to support existing semantics that are already supported thru explicit elements in the resource.)
     */
    public List<CodeableConcept> getClassifier() { 
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      return this.classifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setClassifier(List<CodeableConcept> theClassifier) { 
      this.classifier = theClassifier;
      return this;
    }

    public boolean hasClassifier() { 
      if (this.classifier == null)
        return false;
      for (CodeableConcept item : this.classifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addClassifier() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      this.classifier.add(t);
      return t;
    }

    public ResearchStudy addClassifier(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.classifier == null)
        this.classifier = new ArrayList<CodeableConcept>();
      this.classifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #classifier}, creating it if it does not already exist {3}
     */
    public CodeableConcept getClassifierFirstRep() { 
      if (getClassifier().isEmpty()) {
        addClassifier();
      }
      return getClassifier().get(0);
    }

    /**
     * @return {@link #associatedParty} (Sponsors, collaborators, and other parties.)
     */
    public List<ResearchStudyAssociatedPartyComponent> getAssociatedParty() { 
      if (this.associatedParty == null)
        this.associatedParty = new ArrayList<ResearchStudyAssociatedPartyComponent>();
      return this.associatedParty;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setAssociatedParty(List<ResearchStudyAssociatedPartyComponent> theAssociatedParty) { 
      this.associatedParty = theAssociatedParty;
      return this;
    }

    public boolean hasAssociatedParty() { 
      if (this.associatedParty == null)
        return false;
      for (ResearchStudyAssociatedPartyComponent item : this.associatedParty)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ResearchStudyAssociatedPartyComponent addAssociatedParty() { //3
      ResearchStudyAssociatedPartyComponent t = new ResearchStudyAssociatedPartyComponent();
      if (this.associatedParty == null)
        this.associatedParty = new ArrayList<ResearchStudyAssociatedPartyComponent>();
      this.associatedParty.add(t);
      return t;
    }

    public ResearchStudy addAssociatedParty(ResearchStudyAssociatedPartyComponent t) { //3
      if (t == null)
        return this;
      if (this.associatedParty == null)
        this.associatedParty = new ArrayList<ResearchStudyAssociatedPartyComponent>();
      this.associatedParty.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #associatedParty}, creating it if it does not already exist {3}
     */
    public ResearchStudyAssociatedPartyComponent getAssociatedPartyFirstRep() { 
      if (getAssociatedParty().isEmpty()) {
        addAssociatedParty();
      }
      return getAssociatedParty().get(0);
    }

    /**
     * @return {@link #progressStatus} (Status of study with time for that status.)
     */
    public List<ResearchStudyProgressStatusComponent> getProgressStatus() { 
      if (this.progressStatus == null)
        this.progressStatus = new ArrayList<ResearchStudyProgressStatusComponent>();
      return this.progressStatus;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setProgressStatus(List<ResearchStudyProgressStatusComponent> theProgressStatus) { 
      this.progressStatus = theProgressStatus;
      return this;
    }

    public boolean hasProgressStatus() { 
      if (this.progressStatus == null)
        return false;
      for (ResearchStudyProgressStatusComponent item : this.progressStatus)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ResearchStudyProgressStatusComponent addProgressStatus() { //3
      ResearchStudyProgressStatusComponent t = new ResearchStudyProgressStatusComponent();
      if (this.progressStatus == null)
        this.progressStatus = new ArrayList<ResearchStudyProgressStatusComponent>();
      this.progressStatus.add(t);
      return t;
    }

    public ResearchStudy addProgressStatus(ResearchStudyProgressStatusComponent t) { //3
      if (t == null)
        return this;
      if (this.progressStatus == null)
        this.progressStatus = new ArrayList<ResearchStudyProgressStatusComponent>();
      this.progressStatus.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #progressStatus}, creating it if it does not already exist {3}
     */
    public ResearchStudyProgressStatusComponent getProgressStatusFirstRep() { 
      if (getProgressStatus().isEmpty()) {
        addProgressStatus();
      }
      return getProgressStatus().get(0);
    }

    /**
     * @return {@link #whyStopped} (A description and/or code explaining the premature termination of the study.)
     */
    public CodeableConcept getWhyStopped() { 
      if (this.whyStopped == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.whyStopped");
        else if (Configuration.doAutoCreate())
          this.whyStopped = new CodeableConcept(); // cc
      return this.whyStopped;
    }

    public boolean hasWhyStopped() { 
      return this.whyStopped != null && !this.whyStopped.isEmpty();
    }

    /**
     * @param value {@link #whyStopped} (A description and/or code explaining the premature termination of the study.)
     */
    public ResearchStudy setWhyStopped(CodeableConcept value) { 
      this.whyStopped = value;
      return this;
    }

    /**
     * @return {@link #recruitment} (Target or actual group of participants enrolled in study.)
     */
    public ResearchStudyRecruitmentComponent getRecruitment() { 
      if (this.recruitment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchStudy.recruitment");
        else if (Configuration.doAutoCreate())
          this.recruitment = new ResearchStudyRecruitmentComponent(); // cc
      return this.recruitment;
    }

    public boolean hasRecruitment() { 
      return this.recruitment != null && !this.recruitment.isEmpty();
    }

    /**
     * @param value {@link #recruitment} (Target or actual group of participants enrolled in study.)
     */
    public ResearchStudy setRecruitment(ResearchStudyRecruitmentComponent value) { 
      this.recruitment = value;
      return this;
    }

    /**
     * @return {@link #comparisonGroup} (Describes an expected event or sequence of events for one of the subjects of a study. E.g. for a living subject: exposure to drug A, wash-out, exposure to drug B, wash-out, follow-up. E.g. for a stability study: {store sample from lot A at 25 degrees for 1 month}, {store sample from lot A at 40 degrees for 1 month}.)
     */
    public List<ResearchStudyComparisonGroupComponent> getComparisonGroup() { 
      if (this.comparisonGroup == null)
        this.comparisonGroup = new ArrayList<ResearchStudyComparisonGroupComponent>();
      return this.comparisonGroup;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setComparisonGroup(List<ResearchStudyComparisonGroupComponent> theComparisonGroup) { 
      this.comparisonGroup = theComparisonGroup;
      return this;
    }

    public boolean hasComparisonGroup() { 
      if (this.comparisonGroup == null)
        return false;
      for (ResearchStudyComparisonGroupComponent item : this.comparisonGroup)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ResearchStudyComparisonGroupComponent addComparisonGroup() { //3
      ResearchStudyComparisonGroupComponent t = new ResearchStudyComparisonGroupComponent();
      if (this.comparisonGroup == null)
        this.comparisonGroup = new ArrayList<ResearchStudyComparisonGroupComponent>();
      this.comparisonGroup.add(t);
      return t;
    }

    public ResearchStudy addComparisonGroup(ResearchStudyComparisonGroupComponent t) { //3
      if (t == null)
        return this;
      if (this.comparisonGroup == null)
        this.comparisonGroup = new ArrayList<ResearchStudyComparisonGroupComponent>();
      this.comparisonGroup.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #comparisonGroup}, creating it if it does not already exist {3}
     */
    public ResearchStudyComparisonGroupComponent getComparisonGroupFirstRep() { 
      if (getComparisonGroup().isEmpty()) {
        addComparisonGroup();
      }
      return getComparisonGroup().get(0);
    }

    /**
     * @return {@link #objective} (A goal that the study is aiming to achieve in terms of a scientific question to be answered by the analysis of data collected during the study.)
     */
    public List<ResearchStudyObjectiveComponent> getObjective() { 
      if (this.objective == null)
        this.objective = new ArrayList<ResearchStudyObjectiveComponent>();
      return this.objective;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setObjective(List<ResearchStudyObjectiveComponent> theObjective) { 
      this.objective = theObjective;
      return this;
    }

    public boolean hasObjective() { 
      if (this.objective == null)
        return false;
      for (ResearchStudyObjectiveComponent item : this.objective)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ResearchStudyObjectiveComponent addObjective() { //3
      ResearchStudyObjectiveComponent t = new ResearchStudyObjectiveComponent();
      if (this.objective == null)
        this.objective = new ArrayList<ResearchStudyObjectiveComponent>();
      this.objective.add(t);
      return t;
    }

    public ResearchStudy addObjective(ResearchStudyObjectiveComponent t) { //3
      if (t == null)
        return this;
      if (this.objective == null)
        this.objective = new ArrayList<ResearchStudyObjectiveComponent>();
      this.objective.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #objective}, creating it if it does not already exist {3}
     */
    public ResearchStudyObjectiveComponent getObjectiveFirstRep() { 
      if (getObjective().isEmpty()) {
        addObjective();
      }
      return getObjective().get(0);
    }

    /**
     * @return {@link #outcomeMeasure} (An "outcome measure", "endpoint", "effect measure" or "measure of effect" is a specific measurement or observation used to quantify the effect of experimental variables on the participants in a study, or for observational studies, to describe patterns of diseases or traits or associations with exposures, risk factors or treatment.)
     */
    public List<ResearchStudyOutcomeMeasureComponent> getOutcomeMeasure() { 
      if (this.outcomeMeasure == null)
        this.outcomeMeasure = new ArrayList<ResearchStudyOutcomeMeasureComponent>();
      return this.outcomeMeasure;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setOutcomeMeasure(List<ResearchStudyOutcomeMeasureComponent> theOutcomeMeasure) { 
      this.outcomeMeasure = theOutcomeMeasure;
      return this;
    }

    public boolean hasOutcomeMeasure() { 
      if (this.outcomeMeasure == null)
        return false;
      for (ResearchStudyOutcomeMeasureComponent item : this.outcomeMeasure)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ResearchStudyOutcomeMeasureComponent addOutcomeMeasure() { //3
      ResearchStudyOutcomeMeasureComponent t = new ResearchStudyOutcomeMeasureComponent();
      if (this.outcomeMeasure == null)
        this.outcomeMeasure = new ArrayList<ResearchStudyOutcomeMeasureComponent>();
      this.outcomeMeasure.add(t);
      return t;
    }

    public ResearchStudy addOutcomeMeasure(ResearchStudyOutcomeMeasureComponent t) { //3
      if (t == null)
        return this;
      if (this.outcomeMeasure == null)
        this.outcomeMeasure = new ArrayList<ResearchStudyOutcomeMeasureComponent>();
      this.outcomeMeasure.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #outcomeMeasure}, creating it if it does not already exist {3}
     */
    public ResearchStudyOutcomeMeasureComponent getOutcomeMeasureFirstRep() { 
      if (getOutcomeMeasure().isEmpty()) {
        addOutcomeMeasure();
      }
      return getOutcomeMeasure().get(0);
    }

    /**
     * @return {@link #result} (Link to one or more sets of results generated by the study.  Could also link to a research registry holding the results such as ClinicalTrials.gov.)
     */
    public List<Reference> getResult() { 
      if (this.result == null)
        this.result = new ArrayList<Reference>();
      return this.result;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchStudy setResult(List<Reference> theResult) { 
      this.result = theResult;
      return this;
    }

    public boolean hasResult() { 
      if (this.result == null)
        return false;
      for (Reference item : this.result)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addResult() { //3
      Reference t = new Reference();
      if (this.result == null)
        this.result = new ArrayList<Reference>();
      this.result.add(t);
      return t;
    }

    public ResearchStudy addResult(Reference t) { //3
      if (t == null)
        return this;
      if (this.result == null)
        this.result = new ArrayList<Reference>();
      this.result.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #result}, creating it if it does not already exist {3}
     */
    public Reference getResultFirstRep() { 
      if (getResult().isEmpty()) {
        addResult();
      }
      return getResult().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "Canonical identifier for this study resource, represented as a globally unique URI.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "Identifiers assigned to this research study by the sponsor or other systems.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The business version for the study record.", 0, 1, version));
        children.add(new Property("name", "string", "Name for this study (computer friendly).", 0, 1, name));
        children.add(new Property("title", "string", "The human readable name of the research study.", 0, 1, title));
        children.add(new Property("label", "", "Additional names for the study.", 0, java.lang.Integer.MAX_VALUE, label));
        children.add(new Property("protocol", "Reference(PlanDefinition)", "The set of steps expected to be performed as part of the execution of the study.", 0, java.lang.Integer.MAX_VALUE, protocol));
        children.add(new Property("partOf", "Reference(ResearchStudy)", "A larger research study of which this particular study is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Citations, references, URLs and other related documents.  When using relatedArtifact to share URLs, the relatedArtifact.type will often be set to one of \"documentation\" or \"supported-with\" and the URL value will often be in relatedArtifact.document.url but another possible location is relatedArtifact.resource when it is a canonical URL.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
        children.add(new Property("date", "dateTime", "The date (and optionally time) when the ResearchStudy Resource was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ResearchStudy Resource changes.", 0, 1, date));
        children.add(new Property("status", "code", "The publication state of the resource (not of the study).", 0, 1, status));
        children.add(new Property("primaryPurposeType", "CodeableConcept", "The type of study based upon the intent of the study activities. A classification of the intent of the study.", 0, 1, primaryPurposeType));
        children.add(new Property("phase", "CodeableConcept", "The stage in the progression of a therapy from initial experimental use in humans in clinical trials to post-market evaluation.", 0, 1, phase));
        children.add(new Property("studyDesign", "CodeableConcept", "Codes categorizing the type of study such as investigational vs. observational, type of blinding, type of randomization, safety vs. efficacy, etc.", 0, java.lang.Integer.MAX_VALUE, studyDesign));
        children.add(new Property("focus", "CodeableReference(Medication|MedicinalProductDefinition|SubstanceDefinition|EvidenceVariable)", "The medication(s), food(s), therapy(ies), device(s) or other concerns or interventions that the study is seeking to gain more information about.", 0, java.lang.Integer.MAX_VALUE, focus));
        children.add(new Property("condition", "CodeableConcept", "The condition that is the focus of the study.  For example, In a study to examine risk factors for Lupus, might have as an inclusion criterion \"healthy volunteer\", but the target condition code would be a Lupus SNOMED code.", 0, java.lang.Integer.MAX_VALUE, condition));
        children.add(new Property("keyword", "CodeableConcept", "Key terms to aid in searching for or filtering the study.", 0, java.lang.Integer.MAX_VALUE, keyword));
        children.add(new Property("region", "CodeableConcept", "A country, state or other area where the study is taking place rather than its precise geographic location or address.", 0, java.lang.Integer.MAX_VALUE, region));
        children.add(new Property("descriptionSummary", "markdown", "A brief text for explaining the study.", 0, 1, descriptionSummary));
        children.add(new Property("description", "markdown", "A detailed and human-readable narrative of the study. E.g., study abstract.", 0, 1, description));
        children.add(new Property("period", "Period", "Identifies the start date and the expected (or actual, depending on status) end date for the study.", 0, 1, period));
        children.add(new Property("site", "Reference(Location|ResearchStudy|Organization)", "A facility in which study activities are conducted.", 0, java.lang.Integer.MAX_VALUE, site));
        children.add(new Property("note", "Annotation", "Comments made about the study by the performer, subject or other participants.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("classifier", "CodeableConcept", "Additional grouping mechanism or categorization of a research study. Example: FDA regulated device, FDA regulated drug, MPG Paragraph 23b (a German legal requirement), IRB-exempt, etc. Implementation Note: do not use the classifier element to support existing semantics that are already supported thru explicit elements in the resource.", 0, java.lang.Integer.MAX_VALUE, classifier));
        children.add(new Property("associatedParty", "", "Sponsors, collaborators, and other parties.", 0, java.lang.Integer.MAX_VALUE, associatedParty));
        children.add(new Property("progressStatus", "", "Status of study with time for that status.", 0, java.lang.Integer.MAX_VALUE, progressStatus));
        children.add(new Property("whyStopped", "CodeableConcept", "A description and/or code explaining the premature termination of the study.", 0, 1, whyStopped));
        children.add(new Property("recruitment", "", "Target or actual group of participants enrolled in study.", 0, 1, recruitment));
        children.add(new Property("comparisonGroup", "", "Describes an expected event or sequence of events for one of the subjects of a study. E.g. for a living subject: exposure to drug A, wash-out, exposure to drug B, wash-out, follow-up. E.g. for a stability study: {store sample from lot A at 25 degrees for 1 month}, {store sample from lot A at 40 degrees for 1 month}.", 0, java.lang.Integer.MAX_VALUE, comparisonGroup));
        children.add(new Property("objective", "", "A goal that the study is aiming to achieve in terms of a scientific question to be answered by the analysis of data collected during the study.", 0, java.lang.Integer.MAX_VALUE, objective));
        children.add(new Property("outcomeMeasure", "", "An \"outcome measure\", \"endpoint\", \"effect measure\" or \"measure of effect\" is a specific measurement or observation used to quantify the effect of experimental variables on the participants in a study, or for observational studies, to describe patterns of diseases or traits or associations with exposures, risk factors or treatment.", 0, java.lang.Integer.MAX_VALUE, outcomeMeasure));
        children.add(new Property("result", "Reference(EvidenceReport|Citation|DiagnosticReport)", "Link to one or more sets of results generated by the study.  Could also link to a research registry holding the results such as ClinicalTrials.gov.", 0, java.lang.Integer.MAX_VALUE, result));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "Canonical identifier for this study resource, represented as a globally unique URI.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers assigned to this research study by the sponsor or other systems.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The business version for the study record.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "Name for this study (computer friendly).", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "The human readable name of the research study.", 0, 1, title);
        case 102727412: /*label*/  return new Property("label", "", "Additional names for the study.", 0, java.lang.Integer.MAX_VALUE, label);
        case -989163880: /*protocol*/  return new Property("protocol", "Reference(PlanDefinition)", "The set of steps expected to be performed as part of the execution of the study.", 0, java.lang.Integer.MAX_VALUE, protocol);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(ResearchStudy)", "A larger research study of which this particular study is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Citations, references, URLs and other related documents.  When using relatedArtifact to share URLs, the relatedArtifact.type will often be set to one of \"documentation\" or \"supported-with\" and the URL value will often be in relatedArtifact.document.url but another possible location is relatedArtifact.resource when it is a canonical URL.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date (and optionally time) when the ResearchStudy Resource was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the ResearchStudy Resource changes.", 0, 1, date);
        case -892481550: /*status*/  return new Property("status", "code", "The publication state of the resource (not of the study).", 0, 1, status);
        case -2132842986: /*primaryPurposeType*/  return new Property("primaryPurposeType", "CodeableConcept", "The type of study based upon the intent of the study activities. A classification of the intent of the study.", 0, 1, primaryPurposeType);
        case 106629499: /*phase*/  return new Property("phase", "CodeableConcept", "The stage in the progression of a therapy from initial experimental use in humans in clinical trials to post-market evaluation.", 0, 1, phase);
        case 1709211879: /*studyDesign*/  return new Property("studyDesign", "CodeableConcept", "Codes categorizing the type of study such as investigational vs. observational, type of blinding, type of randomization, safety vs. efficacy, etc.", 0, java.lang.Integer.MAX_VALUE, studyDesign);
        case 97604824: /*focus*/  return new Property("focus", "CodeableReference(Medication|MedicinalProductDefinition|SubstanceDefinition|EvidenceVariable)", "The medication(s), food(s), therapy(ies), device(s) or other concerns or interventions that the study is seeking to gain more information about.", 0, java.lang.Integer.MAX_VALUE, focus);
        case -861311717: /*condition*/  return new Property("condition", "CodeableConcept", "The condition that is the focus of the study.  For example, In a study to examine risk factors for Lupus, might have as an inclusion criterion \"healthy volunteer\", but the target condition code would be a Lupus SNOMED code.", 0, java.lang.Integer.MAX_VALUE, condition);
        case -814408215: /*keyword*/  return new Property("keyword", "CodeableConcept", "Key terms to aid in searching for or filtering the study.", 0, java.lang.Integer.MAX_VALUE, keyword);
        case -934795532: /*region*/  return new Property("region", "CodeableConcept", "A country, state or other area where the study is taking place rather than its precise geographic location or address.", 0, java.lang.Integer.MAX_VALUE, region);
        case 21530634: /*descriptionSummary*/  return new Property("descriptionSummary", "markdown", "A brief text for explaining the study.", 0, 1, descriptionSummary);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A detailed and human-readable narrative of the study. E.g., study abstract.", 0, 1, description);
        case -991726143: /*period*/  return new Property("period", "Period", "Identifies the start date and the expected (or actual, depending on status) end date for the study.", 0, 1, period);
        case 3530567: /*site*/  return new Property("site", "Reference(Location|ResearchStudy|Organization)", "A facility in which study activities are conducted.", 0, java.lang.Integer.MAX_VALUE, site);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Comments made about the study by the performer, subject or other participants.", 0, java.lang.Integer.MAX_VALUE, note);
        case -281470431: /*classifier*/  return new Property("classifier", "CodeableConcept", "Additional grouping mechanism or categorization of a research study. Example: FDA regulated device, FDA regulated drug, MPG Paragraph 23b (a German legal requirement), IRB-exempt, etc. Implementation Note: do not use the classifier element to support existing semantics that are already supported thru explicit elements in the resource.", 0, java.lang.Integer.MAX_VALUE, classifier);
        case -1841460864: /*associatedParty*/  return new Property("associatedParty", "", "Sponsors, collaborators, and other parties.", 0, java.lang.Integer.MAX_VALUE, associatedParty);
        case -1897502593: /*progressStatus*/  return new Property("progressStatus", "", "Status of study with time for that status.", 0, java.lang.Integer.MAX_VALUE, progressStatus);
        case -699986715: /*whyStopped*/  return new Property("whyStopped", "CodeableConcept", "A description and/or code explaining the premature termination of the study.", 0, 1, whyStopped);
        case 780783004: /*recruitment*/  return new Property("recruitment", "", "Target or actual group of participants enrolled in study.", 0, 1, recruitment);
        case -138266634: /*comparisonGroup*/  return new Property("comparisonGroup", "", "Describes an expected event or sequence of events for one of the subjects of a study. E.g. for a living subject: exposure to drug A, wash-out, exposure to drug B, wash-out, follow-up. E.g. for a stability study: {store sample from lot A at 25 degrees for 1 month}, {store sample from lot A at 40 degrees for 1 month}.", 0, java.lang.Integer.MAX_VALUE, comparisonGroup);
        case -1489585863: /*objective*/  return new Property("objective", "", "A goal that the study is aiming to achieve in terms of a scientific question to be answered by the analysis of data collected during the study.", 0, java.lang.Integer.MAX_VALUE, objective);
        case -1510689364: /*outcomeMeasure*/  return new Property("outcomeMeasure", "", "An \"outcome measure\", \"endpoint\", \"effect measure\" or \"measure of effect\" is a specific measurement or observation used to quantify the effect of experimental variables on the participants in a study, or for observational studies, to describe patterns of diseases or traits or associations with exposures, risk factors or treatment.", 0, java.lang.Integer.MAX_VALUE, outcomeMeasure);
        case -934426595: /*result*/  return new Property("result", "Reference(EvidenceReport|Citation|DiagnosticReport)", "Link to one or more sets of results generated by the study.  Could also link to a research registry holding the results such as ClinicalTrials.gov.", 0, java.lang.Integer.MAX_VALUE, result);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case 102727412: /*label*/ return this.label == null ? new Base[0] : this.label.toArray(new Base[this.label.size()]); // ResearchStudyLabelComponent
        case -989163880: /*protocol*/ return this.protocol == null ? new Base[0] : this.protocol.toArray(new Base[this.protocol.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -2132842986: /*primaryPurposeType*/ return this.primaryPurposeType == null ? new Base[0] : new Base[] {this.primaryPurposeType}; // CodeableConcept
        case 106629499: /*phase*/ return this.phase == null ? new Base[0] : new Base[] {this.phase}; // CodeableConcept
        case 1709211879: /*studyDesign*/ return this.studyDesign == null ? new Base[0] : this.studyDesign.toArray(new Base[this.studyDesign.size()]); // CodeableConcept
        case 97604824: /*focus*/ return this.focus == null ? new Base[0] : this.focus.toArray(new Base[this.focus.size()]); // CodeableReference
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : this.condition.toArray(new Base[this.condition.size()]); // CodeableConcept
        case -814408215: /*keyword*/ return this.keyword == null ? new Base[0] : this.keyword.toArray(new Base[this.keyword.size()]); // CodeableConcept
        case -934795532: /*region*/ return this.region == null ? new Base[0] : this.region.toArray(new Base[this.region.size()]); // CodeableConcept
        case 21530634: /*descriptionSummary*/ return this.descriptionSummary == null ? new Base[0] : new Base[] {this.descriptionSummary}; // MarkdownType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 3530567: /*site*/ return this.site == null ? new Base[0] : this.site.toArray(new Base[this.site.size()]); // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -281470431: /*classifier*/ return this.classifier == null ? new Base[0] : this.classifier.toArray(new Base[this.classifier.size()]); // CodeableConcept
        case -1841460864: /*associatedParty*/ return this.associatedParty == null ? new Base[0] : this.associatedParty.toArray(new Base[this.associatedParty.size()]); // ResearchStudyAssociatedPartyComponent
        case -1897502593: /*progressStatus*/ return this.progressStatus == null ? new Base[0] : this.progressStatus.toArray(new Base[this.progressStatus.size()]); // ResearchStudyProgressStatusComponent
        case -699986715: /*whyStopped*/ return this.whyStopped == null ? new Base[0] : new Base[] {this.whyStopped}; // CodeableConcept
        case 780783004: /*recruitment*/ return this.recruitment == null ? new Base[0] : new Base[] {this.recruitment}; // ResearchStudyRecruitmentComponent
        case -138266634: /*comparisonGroup*/ return this.comparisonGroup == null ? new Base[0] : this.comparisonGroup.toArray(new Base[this.comparisonGroup.size()]); // ResearchStudyComparisonGroupComponent
        case -1489585863: /*objective*/ return this.objective == null ? new Base[0] : this.objective.toArray(new Base[this.objective.size()]); // ResearchStudyObjectiveComponent
        case -1510689364: /*outcomeMeasure*/ return this.outcomeMeasure == null ? new Base[0] : this.outcomeMeasure.toArray(new Base[this.outcomeMeasure.size()]); // ResearchStudyOutcomeMeasureComponent
        case -934426595: /*result*/ return this.result == null ? new Base[0] : this.result.toArray(new Base[this.result.size()]); // Reference
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
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case 102727412: // label
          this.getLabel().add((ResearchStudyLabelComponent) value); // ResearchStudyLabelComponent
          return value;
        case -989163880: // protocol
          this.getProtocol().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 666807069: // relatedArtifact
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -2132842986: // primaryPurposeType
          this.primaryPurposeType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 106629499: // phase
          this.phase = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1709211879: // studyDesign
          this.getStudyDesign().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 97604824: // focus
          this.getFocus().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -861311717: // condition
          this.getCondition().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -814408215: // keyword
          this.getKeyword().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -934795532: // region
          this.getRegion().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 21530634: // descriptionSummary
          this.descriptionSummary = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 3530567: // site
          this.getSite().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -281470431: // classifier
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1841460864: // associatedParty
          this.getAssociatedParty().add((ResearchStudyAssociatedPartyComponent) value); // ResearchStudyAssociatedPartyComponent
          return value;
        case -1897502593: // progressStatus
          this.getProgressStatus().add((ResearchStudyProgressStatusComponent) value); // ResearchStudyProgressStatusComponent
          return value;
        case -699986715: // whyStopped
          this.whyStopped = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 780783004: // recruitment
          this.recruitment = (ResearchStudyRecruitmentComponent) value; // ResearchStudyRecruitmentComponent
          return value;
        case -138266634: // comparisonGroup
          this.getComparisonGroup().add((ResearchStudyComparisonGroupComponent) value); // ResearchStudyComparisonGroupComponent
          return value;
        case -1489585863: // objective
          this.getObjective().add((ResearchStudyObjectiveComponent) value); // ResearchStudyObjectiveComponent
          return value;
        case -1510689364: // outcomeMeasure
          this.getOutcomeMeasure().add((ResearchStudyOutcomeMeasureComponent) value); // ResearchStudyOutcomeMeasureComponent
          return value;
        case -934426595: // result
          this.getResult().add(TypeConvertor.castToReference(value)); // Reference
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
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("label")) {
          this.getLabel().add((ResearchStudyLabelComponent) value);
        } else if (name.equals("protocol")) {
          this.getProtocol().add(TypeConvertor.castToReference(value));
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("primaryPurposeType")) {
          this.primaryPurposeType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("phase")) {
          this.phase = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("studyDesign")) {
          this.getStudyDesign().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("focus")) {
          this.getFocus().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("condition")) {
          this.getCondition().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("keyword")) {
          this.getKeyword().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("region")) {
          this.getRegion().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("descriptionSummary")) {
          this.descriptionSummary = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("site")) {
          this.getSite().add(TypeConvertor.castToReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("classifier")) {
          this.getClassifier().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("associatedParty")) {
          this.getAssociatedParty().add((ResearchStudyAssociatedPartyComponent) value);
        } else if (name.equals("progressStatus")) {
          this.getProgressStatus().add((ResearchStudyProgressStatusComponent) value);
        } else if (name.equals("whyStopped")) {
          this.whyStopped = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("recruitment")) {
          this.recruitment = (ResearchStudyRecruitmentComponent) value; // ResearchStudyRecruitmentComponent
        } else if (name.equals("comparisonGroup")) {
          this.getComparisonGroup().add((ResearchStudyComparisonGroupComponent) value);
        } else if (name.equals("objective")) {
          this.getObjective().add((ResearchStudyObjectiveComponent) value);
        } else if (name.equals("outcomeMeasure")) {
          this.getOutcomeMeasure().add((ResearchStudyOutcomeMeasureComponent) value);
        } else if (name.equals("result")) {
          this.getResult().add(TypeConvertor.castToReference(value));
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
        case 3373707:  return getNameElement();
        case 110371416:  return getTitleElement();
        case 102727412:  return addLabel(); 
        case -989163880:  return addProtocol(); 
        case -995410646:  return addPartOf(); 
        case 666807069:  return addRelatedArtifact(); 
        case 3076014:  return getDateElement();
        case -892481550:  return getStatusElement();
        case -2132842986:  return getPrimaryPurposeType();
        case 106629499:  return getPhase();
        case 1709211879:  return addStudyDesign(); 
        case 97604824:  return addFocus(); 
        case -861311717:  return addCondition(); 
        case -814408215:  return addKeyword(); 
        case -934795532:  return addRegion(); 
        case 21530634:  return getDescriptionSummaryElement();
        case -1724546052:  return getDescriptionElement();
        case -991726143:  return getPeriod();
        case 3530567:  return addSite(); 
        case 3387378:  return addNote(); 
        case -281470431:  return addClassifier(); 
        case -1841460864:  return addAssociatedParty(); 
        case -1897502593:  return addProgressStatus(); 
        case -699986715:  return getWhyStopped();
        case 780783004:  return getRecruitment();
        case -138266634:  return addComparisonGroup(); 
        case -1489585863:  return addObjective(); 
        case -1510689364:  return addOutcomeMeasure(); 
        case -934426595:  return addResult(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case 102727412: /*label*/ return new String[] {};
        case -989163880: /*protocol*/ return new String[] {"Reference"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -2132842986: /*primaryPurposeType*/ return new String[] {"CodeableConcept"};
        case 106629499: /*phase*/ return new String[] {"CodeableConcept"};
        case 1709211879: /*studyDesign*/ return new String[] {"CodeableConcept"};
        case 97604824: /*focus*/ return new String[] {"CodeableReference"};
        case -861311717: /*condition*/ return new String[] {"CodeableConcept"};
        case -814408215: /*keyword*/ return new String[] {"CodeableConcept"};
        case -934795532: /*region*/ return new String[] {"CodeableConcept"};
        case 21530634: /*descriptionSummary*/ return new String[] {"markdown"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 3530567: /*site*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -281470431: /*classifier*/ return new String[] {"CodeableConcept"};
        case -1841460864: /*associatedParty*/ return new String[] {};
        case -1897502593: /*progressStatus*/ return new String[] {};
        case -699986715: /*whyStopped*/ return new String[] {"CodeableConcept"};
        case 780783004: /*recruitment*/ return new String[] {};
        case -138266634: /*comparisonGroup*/ return new String[] {};
        case -1489585863: /*objective*/ return new String[] {};
        case -1510689364: /*outcomeMeasure*/ return new String[] {};
        case -934426595: /*result*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.title");
        }
        else if (name.equals("label")) {
          return addLabel();
        }
        else if (name.equals("protocol")) {
          return addProtocol();
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("relatedArtifact")) {
          return addRelatedArtifact();
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.date");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.status");
        }
        else if (name.equals("primaryPurposeType")) {
          this.primaryPurposeType = new CodeableConcept();
          return this.primaryPurposeType;
        }
        else if (name.equals("phase")) {
          this.phase = new CodeableConcept();
          return this.phase;
        }
        else if (name.equals("studyDesign")) {
          return addStudyDesign();
        }
        else if (name.equals("focus")) {
          return addFocus();
        }
        else if (name.equals("condition")) {
          return addCondition();
        }
        else if (name.equals("keyword")) {
          return addKeyword();
        }
        else if (name.equals("region")) {
          return addRegion();
        }
        else if (name.equals("descriptionSummary")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.descriptionSummary");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchStudy.description");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("site")) {
          return addSite();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("classifier")) {
          return addClassifier();
        }
        else if (name.equals("associatedParty")) {
          return addAssociatedParty();
        }
        else if (name.equals("progressStatus")) {
          return addProgressStatus();
        }
        else if (name.equals("whyStopped")) {
          this.whyStopped = new CodeableConcept();
          return this.whyStopped;
        }
        else if (name.equals("recruitment")) {
          this.recruitment = new ResearchStudyRecruitmentComponent();
          return this.recruitment;
        }
        else if (name.equals("comparisonGroup")) {
          return addComparisonGroup();
        }
        else if (name.equals("objective")) {
          return addObjective();
        }
        else if (name.equals("outcomeMeasure")) {
          return addOutcomeMeasure();
        }
        else if (name.equals("result")) {
          return addResult();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ResearchStudy";

  }

      public ResearchStudy copy() {
        ResearchStudy dst = new ResearchStudy();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResearchStudy dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.name = name == null ? null : name.copy();
        dst.title = title == null ? null : title.copy();
        if (label != null) {
          dst.label = new ArrayList<ResearchStudyLabelComponent>();
          for (ResearchStudyLabelComponent i : label)
            dst.label.add(i.copy());
        };
        if (protocol != null) {
          dst.protocol = new ArrayList<Reference>();
          for (Reference i : protocol)
            dst.protocol.add(i.copy());
        };
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        if (relatedArtifact != null) {
          dst.relatedArtifact = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : relatedArtifact)
            dst.relatedArtifact.add(i.copy());
        };
        dst.date = date == null ? null : date.copy();
        dst.status = status == null ? null : status.copy();
        dst.primaryPurposeType = primaryPurposeType == null ? null : primaryPurposeType.copy();
        dst.phase = phase == null ? null : phase.copy();
        if (studyDesign != null) {
          dst.studyDesign = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : studyDesign)
            dst.studyDesign.add(i.copy());
        };
        if (focus != null) {
          dst.focus = new ArrayList<CodeableReference>();
          for (CodeableReference i : focus)
            dst.focus.add(i.copy());
        };
        if (condition != null) {
          dst.condition = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : condition)
            dst.condition.add(i.copy());
        };
        if (keyword != null) {
          dst.keyword = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : keyword)
            dst.keyword.add(i.copy());
        };
        if (region != null) {
          dst.region = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : region)
            dst.region.add(i.copy());
        };
        dst.descriptionSummary = descriptionSummary == null ? null : descriptionSummary.copy();
        dst.description = description == null ? null : description.copy();
        dst.period = period == null ? null : period.copy();
        if (site != null) {
          dst.site = new ArrayList<Reference>();
          for (Reference i : site)
            dst.site.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (classifier != null) {
          dst.classifier = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : classifier)
            dst.classifier.add(i.copy());
        };
        if (associatedParty != null) {
          dst.associatedParty = new ArrayList<ResearchStudyAssociatedPartyComponent>();
          for (ResearchStudyAssociatedPartyComponent i : associatedParty)
            dst.associatedParty.add(i.copy());
        };
        if (progressStatus != null) {
          dst.progressStatus = new ArrayList<ResearchStudyProgressStatusComponent>();
          for (ResearchStudyProgressStatusComponent i : progressStatus)
            dst.progressStatus.add(i.copy());
        };
        dst.whyStopped = whyStopped == null ? null : whyStopped.copy();
        dst.recruitment = recruitment == null ? null : recruitment.copy();
        if (comparisonGroup != null) {
          dst.comparisonGroup = new ArrayList<ResearchStudyComparisonGroupComponent>();
          for (ResearchStudyComparisonGroupComponent i : comparisonGroup)
            dst.comparisonGroup.add(i.copy());
        };
        if (objective != null) {
          dst.objective = new ArrayList<ResearchStudyObjectiveComponent>();
          for (ResearchStudyObjectiveComponent i : objective)
            dst.objective.add(i.copy());
        };
        if (outcomeMeasure != null) {
          dst.outcomeMeasure = new ArrayList<ResearchStudyOutcomeMeasureComponent>();
          for (ResearchStudyOutcomeMeasureComponent i : outcomeMeasure)
            dst.outcomeMeasure.add(i.copy());
        };
        if (result != null) {
          dst.result = new ArrayList<Reference>();
          for (Reference i : result)
            dst.result.add(i.copy());
        };
      }

      protected ResearchStudy typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResearchStudy))
          return false;
        ResearchStudy o = (ResearchStudy) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(name, o.name, true) && compareDeep(title, o.title, true) && compareDeep(label, o.label, true)
           && compareDeep(protocol, o.protocol, true) && compareDeep(partOf, o.partOf, true) && compareDeep(relatedArtifact, o.relatedArtifact, true)
           && compareDeep(date, o.date, true) && compareDeep(status, o.status, true) && compareDeep(primaryPurposeType, o.primaryPurposeType, true)
           && compareDeep(phase, o.phase, true) && compareDeep(studyDesign, o.studyDesign, true) && compareDeep(focus, o.focus, true)
           && compareDeep(condition, o.condition, true) && compareDeep(keyword, o.keyword, true) && compareDeep(region, o.region, true)
           && compareDeep(descriptionSummary, o.descriptionSummary, true) && compareDeep(description, o.description, true)
           && compareDeep(period, o.period, true) && compareDeep(site, o.site, true) && compareDeep(note, o.note, true)
           && compareDeep(classifier, o.classifier, true) && compareDeep(associatedParty, o.associatedParty, true)
           && compareDeep(progressStatus, o.progressStatus, true) && compareDeep(whyStopped, o.whyStopped, true)
           && compareDeep(recruitment, o.recruitment, true) && compareDeep(comparisonGroup, o.comparisonGroup, true)
           && compareDeep(objective, o.objective, true) && compareDeep(outcomeMeasure, o.outcomeMeasure, true)
           && compareDeep(result, o.result, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResearchStudy))
          return false;
        ResearchStudy o = (ResearchStudy) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(date, o.date, true) && compareValues(status, o.status, true)
           && compareValues(descriptionSummary, o.descriptionSummary, true) && compareValues(description, o.description, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , name, title, label, protocol, partOf, relatedArtifact, date, status, primaryPurposeType
          , phase, studyDesign, focus, condition, keyword, region, descriptionSummary, description
          , period, site, note, classifier, associatedParty, progressStatus, whyStopped
          , recruitment, comparisonGroup, objective, outcomeMeasure, result);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ResearchStudy;
   }

 /**
   * Search parameter: <b>classifier</b>
   * <p>
   * Description: <b>Classification for the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.classifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="classifier", path="ResearchStudy.classifier", description="Classification for the study", type="token" )
  public static final String SP_CLASSIFIER = "classifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>classifier</b>
   * <p>
   * Description: <b>Classification for the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.classifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CLASSIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CLASSIFIER);

 /**
   * Search parameter: <b>condition</b>
   * <p>
   * Description: <b>Condition being studied</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.condition</b><br>
   * </p>
   */
  @SearchParamDefinition(name="condition", path="ResearchStudy.condition", description="Condition being studied", type="token" )
  public static final String SP_CONDITION = "condition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>condition</b>
   * <p>
   * Description: <b>Condition being studied</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.condition</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONDITION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONDITION);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>When the study began and ended</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ResearchStudy.period</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="ResearchStudy.period", description="When the study began and ended", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>When the study began and ended</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ResearchStudy.period</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>Detailed narrative of the study</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ResearchStudy.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="ResearchStudy.description", description="Detailed narrative of the study", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>Detailed narrative of the study</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ResearchStudy.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>eligibility</b>
   * <p>
   * Description: <b>Inclusion and exclusion criteria</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchStudy.recruitment.eligibility</b><br>
   * </p>
   */
  @SearchParamDefinition(name="eligibility", path="ResearchStudy.recruitment.eligibility", description="Inclusion and exclusion criteria", type="reference", target={EvidenceVariable.class, Group.class } )
  public static final String SP_ELIGIBILITY = "eligibility";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>eligibility</b>
   * <p>
   * Description: <b>Inclusion and exclusion criteria</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchStudy.recruitment.eligibility</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ELIGIBILITY = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ELIGIBILITY);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ResearchStudy:eligibility</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ELIGIBILITY = new ca.uhn.fhir.model.api.Include("ResearchStudy:eligibility").toLocked();

 /**
   * Search parameter: <b>focus-code</b>
   * <p>
   * Description: <b>Drugs, devices, etc. under study, as a code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.focus.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="focus-code", path="ResearchStudy.focus.concept", description="Drugs, devices, etc. under study, as a code", type="token" )
  public static final String SP_FOCUS_CODE = "focus-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>focus-code</b>
   * <p>
   * Description: <b>Drugs, devices, etc. under study, as a code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.focus.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FOCUS_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FOCUS_CODE);

 /**
   * Search parameter: <b>focus-reference</b>
   * <p>
   * Description: <b>Drugs, devices, etc. under study, as a reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchStudy.focus.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="focus-reference", path="ResearchStudy.focus.reference", description="Drugs, devices, etc. under study, as a reference", type="reference", target={EvidenceVariable.class, Medication.class, MedicinalProductDefinition.class, SubstanceDefinition.class } )
  public static final String SP_FOCUS_REFERENCE = "focus-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>focus-reference</b>
   * <p>
   * Description: <b>Drugs, devices, etc. under study, as a reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchStudy.focus.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam FOCUS_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_FOCUS_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ResearchStudy:focus-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_FOCUS_REFERENCE = new ca.uhn.fhir.model.api.Include("ResearchStudy:focus-reference").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Business Identifier for study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ResearchStudy.identifier", description="Business Identifier for study", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Business Identifier for study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>keyword</b>
   * <p>
   * Description: <b>Used to search for the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.keyword</b><br>
   * </p>
   */
  @SearchParamDefinition(name="keyword", path="ResearchStudy.keyword", description="Used to search for the study", type="token" )
  public static final String SP_KEYWORD = "keyword";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>keyword</b>
   * <p>
   * Description: <b>Used to search for the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.keyword</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam KEYWORD = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_KEYWORD);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Name for this study</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ResearchStudy.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="ResearchStudy.name", description="Name for this study", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Name for this study</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ResearchStudy.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>objective-description</b>
   * <p>
   * Description: <b>Free text description of the objective of the study</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ResearchStudy.objective.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="objective-description", path="ResearchStudy.objective.description", description="Free text description of the objective of the study", type="string" )
  public static final String SP_OBJECTIVE_DESCRIPTION = "objective-description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>objective-description</b>
   * <p>
   * Description: <b>Free text description of the objective of the study</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ResearchStudy.objective.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam OBJECTIVE_DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_OBJECTIVE_DESCRIPTION);

 /**
   * Search parameter: <b>objective-type</b>
   * <p>
   * Description: <b>The kind of study objective</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.objective.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="objective-type", path="ResearchStudy.objective.type", description="The kind of study objective", type="token" )
  public static final String SP_OBJECTIVE_TYPE = "objective-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>objective-type</b>
   * <p>
   * Description: <b>The kind of study objective</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.objective.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam OBJECTIVE_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_OBJECTIVE_TYPE);

 /**
   * Search parameter: <b>part-of</b>
   * <p>
   * Description: <b>Part of larger study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchStudy.partOf</b><br>
   * </p>
   */
  @SearchParamDefinition(name="part-of", path="ResearchStudy.partOf", description="Part of larger study", type="reference", target={ResearchStudy.class } )
  public static final String SP_PART_OF = "part-of";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>part-of</b>
   * <p>
   * Description: <b>Part of larger study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchStudy.partOf</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PART_OF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PART_OF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ResearchStudy:part-of</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PART_OF = new ca.uhn.fhir.model.api.Include("ResearchStudy:part-of").toLocked();

 /**
   * Search parameter: <b>phase</b>
   * <p>
   * Description: <b>The stage in the progression of a study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.phase</b><br>
   * </p>
   */
  @SearchParamDefinition(name="phase", path="ResearchStudy.phase", description="The stage in the progression of a study", type="token" )
  public static final String SP_PHASE = "phase";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>phase</b>
   * <p>
   * Description: <b>The stage in the progression of a study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.phase</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PHASE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PHASE);

 /**
   * Search parameter: <b>protocol</b>
   * <p>
   * Description: <b>Steps followed in executing study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchStudy.protocol</b><br>
   * </p>
   */
  @SearchParamDefinition(name="protocol", path="ResearchStudy.protocol", description="Steps followed in executing study", type="reference", target={PlanDefinition.class } )
  public static final String SP_PROTOCOL = "protocol";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>protocol</b>
   * <p>
   * Description: <b>Steps followed in executing study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchStudy.protocol</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PROTOCOL = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PROTOCOL);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ResearchStudy:protocol</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PROTOCOL = new ca.uhn.fhir.model.api.Include("ResearchStudy:protocol").toLocked();

 /**
   * Search parameter: <b>recruitment-actual</b>
   * <p>
   * Description: <b>Actual number of participants enrolled in study across all groups</b><br>
   * Type: <b>number</b><br>
   * Path: <b>ResearchStudy.recruitment.actualNumber</b><br>
   * </p>
   */
  @SearchParamDefinition(name="recruitment-actual", path="ResearchStudy.recruitment.actualNumber", description="Actual number of participants enrolled in study across all groups", type="number" )
  public static final String SP_RECRUITMENT_ACTUAL = "recruitment-actual";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>recruitment-actual</b>
   * <p>
   * Description: <b>Actual number of participants enrolled in study across all groups</b><br>
   * Type: <b>number</b><br>
   * Path: <b>ResearchStudy.recruitment.actualNumber</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.NumberClientParam RECRUITMENT_ACTUAL = new ca.uhn.fhir.rest.gclient.NumberClientParam(SP_RECRUITMENT_ACTUAL);

 /**
   * Search parameter: <b>recruitment-target</b>
   * <p>
   * Description: <b>Target number of participants enrolled in study across all groups</b><br>
   * Type: <b>number</b><br>
   * Path: <b>ResearchStudy.recruitment.targetNumber</b><br>
   * </p>
   */
  @SearchParamDefinition(name="recruitment-target", path="ResearchStudy.recruitment.targetNumber", description="Target number of participants enrolled in study across all groups", type="number" )
  public static final String SP_RECRUITMENT_TARGET = "recruitment-target";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>recruitment-target</b>
   * <p>
   * Description: <b>Target number of participants enrolled in study across all groups</b><br>
   * Type: <b>number</b><br>
   * Path: <b>ResearchStudy.recruitment.targetNumber</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.NumberClientParam RECRUITMENT_TARGET = new ca.uhn.fhir.rest.gclient.NumberClientParam(SP_RECRUITMENT_TARGET);

 /**
   * Search parameter: <b>region</b>
   * <p>
   * Description: <b>Geographic area for the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.region</b><br>
   * </p>
   */
  @SearchParamDefinition(name="region", path="ResearchStudy.region", description="Geographic area for the study", type="token" )
  public static final String SP_REGION = "region";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>region</b>
   * <p>
   * Description: <b>Geographic area for the study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.region</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam REGION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_REGION);

 /**
   * Search parameter: <b>site</b>
   * <p>
   * Description: <b>Facility where study activities are conducted</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchStudy.site</b><br>
   * </p>
   */
  @SearchParamDefinition(name="site", path="ResearchStudy.site", description="Facility where study activities are conducted", type="reference", target={Location.class, Organization.class, ResearchStudy.class } )
  public static final String SP_SITE = "site";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>site</b>
   * <p>
   * Description: <b>Facility where study activities are conducted</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchStudy.site</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SITE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SITE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ResearchStudy:site</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SITE = new ca.uhn.fhir.model.api.Include("ResearchStudy:site").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>active | active-but-not-recruiting | administratively-completed | approved | closed-to-accrual | closed-to-accrual-and-intervention | completed | disapproved | enrolling-by-invitation | in-review | not-yet-recruiting | recruiting | temporarily-closed-to-accrual | temporarily-closed-to-accrual-and-intervention | terminated | withdrawn</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ResearchStudy.status", description="active | active-but-not-recruiting | administratively-completed | approved | closed-to-accrual | closed-to-accrual-and-intervention | completed | disapproved | enrolling-by-invitation | in-review | not-yet-recruiting | recruiting | temporarily-closed-to-accrual | temporarily-closed-to-accrual-and-intervention | terminated | withdrawn", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>active | active-but-not-recruiting | administratively-completed | approved | closed-to-accrual | closed-to-accrual-and-intervention | completed | disapproved | enrolling-by-invitation | in-review | not-yet-recruiting | recruiting | temporarily-closed-to-accrual | temporarily-closed-to-accrual-and-intervention | terminated | withdrawn</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>study-design</b>
   * <p>
   * Description: <b>Classifications of the study design characteristics</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.studyDesign</b><br>
   * </p>
   */
  @SearchParamDefinition(name="study-design", path="ResearchStudy.studyDesign", description="Classifications of the study design characteristics", type="token" )
  public static final String SP_STUDY_DESIGN = "study-design";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>study-design</b>
   * <p>
   * Description: <b>Classifications of the study design characteristics</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchStudy.studyDesign</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STUDY_DESIGN = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STUDY_DESIGN);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>The human readable name of the research study</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ResearchStudy.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="ResearchStudy.title", description="The human readable name of the research study", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>The human readable name of the research study</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ResearchStudy.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);


}

