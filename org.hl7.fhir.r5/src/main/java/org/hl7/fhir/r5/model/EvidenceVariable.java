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

// Generated on Tue, Dec 13, 2022 17:53+1100 for FHIR vcurrent

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
 * The EvidenceVariable resource describes an element that knowledge (Evidence) is about.
 */
@ResourceDef(name="EvidenceVariable", profile="http://hl7.org/fhir/StructureDefinition/EvidenceVariable")
public class EvidenceVariable extends MetadataResource {

    public enum CharacteristicCombination {
        /**
         * Combine characteristics with AND.
         */
        ALLOF, 
        /**
         * Combine characteristics with OR.
         */
        ANYOF, 
        /**
         * Meet at least the threshold number of characteristics for definition.
         */
        ATLEAST, 
        /**
         * Meet at most the threshold number of characteristics for definition.
         */
        ATMOST, 
        /**
         * Combine characteristics statistically. Use method to specify the statistical method.
         */
        STATISTICAL, 
        /**
         * Combine characteristics by addition of benefits and subtraction of harms.
         */
        NETEFFECT, 
        /**
         * Combine characteristics as a collection used as the dataset.
         */
        DATASET, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static CharacteristicCombination fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("all-of".equals(codeString))
          return ALLOF;
        if ("any-of".equals(codeString))
          return ANYOF;
        if ("at-least".equals(codeString))
          return ATLEAST;
        if ("at-most".equals(codeString))
          return ATMOST;
        if ("statistical".equals(codeString))
          return STATISTICAL;
        if ("net-effect".equals(codeString))
          return NETEFFECT;
        if ("dataset".equals(codeString))
          return DATASET;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown CharacteristicCombination code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ALLOF: return "all-of";
            case ANYOF: return "any-of";
            case ATLEAST: return "at-least";
            case ATMOST: return "at-most";
            case STATISTICAL: return "statistical";
            case NETEFFECT: return "net-effect";
            case DATASET: return "dataset";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ALLOF: return "http://hl7.org/fhir/characteristic-combination";
            case ANYOF: return "http://hl7.org/fhir/characteristic-combination";
            case ATLEAST: return "http://hl7.org/fhir/characteristic-combination";
            case ATMOST: return "http://hl7.org/fhir/characteristic-combination";
            case STATISTICAL: return "http://hl7.org/fhir/characteristic-combination";
            case NETEFFECT: return "http://hl7.org/fhir/characteristic-combination";
            case DATASET: return "http://hl7.org/fhir/characteristic-combination";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ALLOF: return "Combine characteristics with AND.";
            case ANYOF: return "Combine characteristics with OR.";
            case ATLEAST: return "Meet at least the threshold number of characteristics for definition.";
            case ATMOST: return "Meet at most the threshold number of characteristics for definition.";
            case STATISTICAL: return "Combine characteristics statistically. Use method to specify the statistical method.";
            case NETEFFECT: return "Combine characteristics by addition of benefits and subtraction of harms.";
            case DATASET: return "Combine characteristics as a collection used as the dataset.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ALLOF: return "All of";
            case ANYOF: return "Any of";
            case ATLEAST: return "At least";
            case ATMOST: return "At most";
            case STATISTICAL: return "Statistical";
            case NETEFFECT: return "Net effect";
            case DATASET: return "Dataset";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class CharacteristicCombinationEnumFactory implements EnumFactory<CharacteristicCombination> {
    public CharacteristicCombination fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("all-of".equals(codeString))
          return CharacteristicCombination.ALLOF;
        if ("any-of".equals(codeString))
          return CharacteristicCombination.ANYOF;
        if ("at-least".equals(codeString))
          return CharacteristicCombination.ATLEAST;
        if ("at-most".equals(codeString))
          return CharacteristicCombination.ATMOST;
        if ("statistical".equals(codeString))
          return CharacteristicCombination.STATISTICAL;
        if ("net-effect".equals(codeString))
          return CharacteristicCombination.NETEFFECT;
        if ("dataset".equals(codeString))
          return CharacteristicCombination.DATASET;
        throw new IllegalArgumentException("Unknown CharacteristicCombination code '"+codeString+"'");
        }
        public Enumeration<CharacteristicCombination> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<CharacteristicCombination>(this, CharacteristicCombination.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<CharacteristicCombination>(this, CharacteristicCombination.NULL, code);
        if ("all-of".equals(codeString))
          return new Enumeration<CharacteristicCombination>(this, CharacteristicCombination.ALLOF, code);
        if ("any-of".equals(codeString))
          return new Enumeration<CharacteristicCombination>(this, CharacteristicCombination.ANYOF, code);
        if ("at-least".equals(codeString))
          return new Enumeration<CharacteristicCombination>(this, CharacteristicCombination.ATLEAST, code);
        if ("at-most".equals(codeString))
          return new Enumeration<CharacteristicCombination>(this, CharacteristicCombination.ATMOST, code);
        if ("statistical".equals(codeString))
          return new Enumeration<CharacteristicCombination>(this, CharacteristicCombination.STATISTICAL, code);
        if ("net-effect".equals(codeString))
          return new Enumeration<CharacteristicCombination>(this, CharacteristicCombination.NETEFFECT, code);
        if ("dataset".equals(codeString))
          return new Enumeration<CharacteristicCombination>(this, CharacteristicCombination.DATASET, code);
        throw new FHIRException("Unknown CharacteristicCombination code '"+codeString+"'");
        }
    public String toCode(CharacteristicCombination code) {
      if (code == CharacteristicCombination.ALLOF)
        return "all-of";
      if (code == CharacteristicCombination.ANYOF)
        return "any-of";
      if (code == CharacteristicCombination.ATLEAST)
        return "at-least";
      if (code == CharacteristicCombination.ATMOST)
        return "at-most";
      if (code == CharacteristicCombination.STATISTICAL)
        return "statistical";
      if (code == CharacteristicCombination.NETEFFECT)
        return "net-effect";
      if (code == CharacteristicCombination.DATASET)
        return "dataset";
      return "?";
      }
    public String toSystem(CharacteristicCombination code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class EvidenceVariableCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Label used for when a characteristic refers to another characteristic.
         */
        @Child(name = "linkId", type = {IdType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Label for internal linking", formalDefinition="Label used for when a characteristic refers to another characteristic." )
        protected IdType linkId;

        /**
         * A short, natural language description of the characteristic that could be used to communicate the criteria to an end-user.
         */
        @Child(name = "description", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Natural language description of the characteristic", formalDefinition="A short, natural language description of the characteristic that could be used to communicate the criteria to an end-user." )
        protected StringType description;

        /**
         * A human-readable string to clarify or explain concepts about the characteristic.
         */
        @Child(name = "note", type = {Annotation.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Used for footnotes or explanatory notes", formalDefinition="A human-readable string to clarify or explain concepts about the characteristic." )
        protected List<Annotation> note;

        /**
         * When true, this characteristic is an exclusion criterion. In other words, not matching this characteristic definition is equivalent to meeting this criterion.
         */
        @Child(name = "exclude", type = {BooleanType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Whether the characteristic is an inclusion criterion or exclusion criterion", formalDefinition="When true, this characteristic is an exclusion criterion. In other words, not matching this characteristic definition is equivalent to meeting this criterion." )
        protected BooleanType exclude;

        /**
         * Defines the characteristic using a Reference.
         */
        @Child(name = "definitionReference", type = {EvidenceVariable.class, Group.class, Evidence.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Defines the characteristic (without using type and value) by a Reference", formalDefinition="Defines the characteristic using a Reference." )
        protected Reference definitionReference;

        /**
         * Defines the characteristic using Canonical.
         */
        @Child(name = "definitionCanonical", type = {CanonicalType.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Defines the characteristic (without using type and value) by a Canonical", formalDefinition="Defines the characteristic using Canonical." )
        protected CanonicalType definitionCanonical;

        /**
         * Defines the characteristic using CodeableConcept.
         */
        @Child(name = "definitionCodeableConcept", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Defines the characteristic (without using type and value) by a CodeableConcept", formalDefinition="Defines the characteristic using CodeableConcept." )
        protected CodeableConcept definitionCodeableConcept;

        /**
         * Defines the characteristic using Expression.
         */
        @Child(name = "definitionExpression", type = {Expression.class}, order=8, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Defines the characteristic (without using type and value) by a Expression", formalDefinition="Defines the characteristic using Expression." )
        protected Expression definitionExpression;

        /**
         * Defines the characteristic using id.
         */
        @Child(name = "definitionId", type = {IdType.class}, order=9, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Defines the characteristic (without using type and value) by a id", formalDefinition="Defines the characteristic using id." )
        protected IdType definitionId;

        /**
         * Defines the characteristic using both a type and value[x] elements.
         */
        @Child(name = "definitionByTypeAndValue", type = {}, order=10, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Defines the characteristic using type and value", formalDefinition="Defines the characteristic using both a type and value[x] elements." )
        protected EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent definitionByTypeAndValue;

        /**
         * Defines the characteristic as a combination of two or more characteristics.
         */
        @Child(name = "definitionByCombination", type = {}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to specify how two or more characteristics are combined", formalDefinition="Defines the characteristic as a combination of two or more characteristics." )
        protected EvidenceVariableCharacteristicDefinitionByCombinationComponent definitionByCombination;

        /**
         * Observation time from study specified event.
         */
        @Child(name = "timeFromEvent", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Observation time from study specified event", formalDefinition="Observation time from study specified event." )
        protected List<EvidenceVariableCharacteristicTimeFromEventComponent> timeFromEvent;

        private static final long serialVersionUID = -172205544L;

    /**
     * Constructor
     */
      public EvidenceVariableCharacteristicComponent() {
        super();
      }

        /**
         * @return {@link #linkId} (Label used for when a characteristic refers to another characteristic.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public IdType getLinkIdElement() { 
          if (this.linkId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicComponent.linkId");
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
         * @param value {@link #linkId} (Label used for when a characteristic refers to another characteristic.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public EvidenceVariableCharacteristicComponent setLinkIdElement(IdType value) { 
          this.linkId = value;
          return this;
        }

        /**
         * @return Label used for when a characteristic refers to another characteristic.
         */
        public String getLinkId() { 
          return this.linkId == null ? null : this.linkId.getValue();
        }

        /**
         * @param value Label used for when a characteristic refers to another characteristic.
         */
        public EvidenceVariableCharacteristicComponent setLinkId(String value) { 
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
         * @return {@link #description} (A short, natural language description of the characteristic that could be used to communicate the criteria to an end-user.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicComponent.description");
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
         * @param value {@link #description} (A short, natural language description of the characteristic that could be used to communicate the criteria to an end-user.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public EvidenceVariableCharacteristicComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A short, natural language description of the characteristic that could be used to communicate the criteria to an end-user.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A short, natural language description of the characteristic that could be used to communicate the criteria to an end-user.
         */
        public EvidenceVariableCharacteristicComponent setDescription(String value) { 
          if (Utilities.noString(value))
            this.description = null;
          else {
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #note} (A human-readable string to clarify or explain concepts about the characteristic.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceVariableCharacteristicComponent setNote(List<Annotation> theNote) { 
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

        public EvidenceVariableCharacteristicComponent addNote(Annotation t) { //3
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
         * @return {@link #exclude} (When true, this characteristic is an exclusion criterion. In other words, not matching this characteristic definition is equivalent to meeting this criterion.). This is the underlying object with id, value and extensions. The accessor "getExclude" gives direct access to the value
         */
        public BooleanType getExcludeElement() { 
          if (this.exclude == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicComponent.exclude");
            else if (Configuration.doAutoCreate())
              this.exclude = new BooleanType(); // bb
          return this.exclude;
        }

        public boolean hasExcludeElement() { 
          return this.exclude != null && !this.exclude.isEmpty();
        }

        public boolean hasExclude() { 
          return this.exclude != null && !this.exclude.isEmpty();
        }

        /**
         * @param value {@link #exclude} (When true, this characteristic is an exclusion criterion. In other words, not matching this characteristic definition is equivalent to meeting this criterion.). This is the underlying object with id, value and extensions. The accessor "getExclude" gives direct access to the value
         */
        public EvidenceVariableCharacteristicComponent setExcludeElement(BooleanType value) { 
          this.exclude = value;
          return this;
        }

        /**
         * @return When true, this characteristic is an exclusion criterion. In other words, not matching this characteristic definition is equivalent to meeting this criterion.
         */
        public boolean getExclude() { 
          return this.exclude == null || this.exclude.isEmpty() ? false : this.exclude.getValue();
        }

        /**
         * @param value When true, this characteristic is an exclusion criterion. In other words, not matching this characteristic definition is equivalent to meeting this criterion.
         */
        public EvidenceVariableCharacteristicComponent setExclude(boolean value) { 
            if (this.exclude == null)
              this.exclude = new BooleanType();
            this.exclude.setValue(value);
          return this;
        }

        /**
         * @return {@link #definitionReference} (Defines the characteristic using a Reference.)
         */
        public Reference getDefinitionReference() { 
          if (this.definitionReference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicComponent.definitionReference");
            else if (Configuration.doAutoCreate())
              this.definitionReference = new Reference(); // cc
          return this.definitionReference;
        }

        public boolean hasDefinitionReference() { 
          return this.definitionReference != null && !this.definitionReference.isEmpty();
        }

        /**
         * @param value {@link #definitionReference} (Defines the characteristic using a Reference.)
         */
        public EvidenceVariableCharacteristicComponent setDefinitionReference(Reference value) { 
          this.definitionReference = value;
          return this;
        }

        /**
         * @return {@link #definitionCanonical} (Defines the characteristic using Canonical.). This is the underlying object with id, value and extensions. The accessor "getDefinitionCanonical" gives direct access to the value
         */
        public CanonicalType getDefinitionCanonicalElement() { 
          if (this.definitionCanonical == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicComponent.definitionCanonical");
            else if (Configuration.doAutoCreate())
              this.definitionCanonical = new CanonicalType(); // bb
          return this.definitionCanonical;
        }

        public boolean hasDefinitionCanonicalElement() { 
          return this.definitionCanonical != null && !this.definitionCanonical.isEmpty();
        }

        public boolean hasDefinitionCanonical() { 
          return this.definitionCanonical != null && !this.definitionCanonical.isEmpty();
        }

        /**
         * @param value {@link #definitionCanonical} (Defines the characteristic using Canonical.). This is the underlying object with id, value and extensions. The accessor "getDefinitionCanonical" gives direct access to the value
         */
        public EvidenceVariableCharacteristicComponent setDefinitionCanonicalElement(CanonicalType value) { 
          this.definitionCanonical = value;
          return this;
        }

        /**
         * @return Defines the characteristic using Canonical.
         */
        public String getDefinitionCanonical() { 
          return this.definitionCanonical == null ? null : this.definitionCanonical.getValue();
        }

        /**
         * @param value Defines the characteristic using Canonical.
         */
        public EvidenceVariableCharacteristicComponent setDefinitionCanonical(String value) { 
          if (Utilities.noString(value))
            this.definitionCanonical = null;
          else {
            if (this.definitionCanonical == null)
              this.definitionCanonical = new CanonicalType();
            this.definitionCanonical.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #definitionCodeableConcept} (Defines the characteristic using CodeableConcept.)
         */
        public CodeableConcept getDefinitionCodeableConcept() { 
          if (this.definitionCodeableConcept == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicComponent.definitionCodeableConcept");
            else if (Configuration.doAutoCreate())
              this.definitionCodeableConcept = new CodeableConcept(); // cc
          return this.definitionCodeableConcept;
        }

        public boolean hasDefinitionCodeableConcept() { 
          return this.definitionCodeableConcept != null && !this.definitionCodeableConcept.isEmpty();
        }

        /**
         * @param value {@link #definitionCodeableConcept} (Defines the characteristic using CodeableConcept.)
         */
        public EvidenceVariableCharacteristicComponent setDefinitionCodeableConcept(CodeableConcept value) { 
          this.definitionCodeableConcept = value;
          return this;
        }

        /**
         * @return {@link #definitionExpression} (Defines the characteristic using Expression.)
         */
        public Expression getDefinitionExpression() { 
          if (this.definitionExpression == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicComponent.definitionExpression");
            else if (Configuration.doAutoCreate())
              this.definitionExpression = new Expression(); // cc
          return this.definitionExpression;
        }

        public boolean hasDefinitionExpression() { 
          return this.definitionExpression != null && !this.definitionExpression.isEmpty();
        }

        /**
         * @param value {@link #definitionExpression} (Defines the characteristic using Expression.)
         */
        public EvidenceVariableCharacteristicComponent setDefinitionExpression(Expression value) { 
          this.definitionExpression = value;
          return this;
        }

        /**
         * @return {@link #definitionId} (Defines the characteristic using id.). This is the underlying object with id, value and extensions. The accessor "getDefinitionId" gives direct access to the value
         */
        public IdType getDefinitionIdElement() { 
          if (this.definitionId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicComponent.definitionId");
            else if (Configuration.doAutoCreate())
              this.definitionId = new IdType(); // bb
          return this.definitionId;
        }

        public boolean hasDefinitionIdElement() { 
          return this.definitionId != null && !this.definitionId.isEmpty();
        }

        public boolean hasDefinitionId() { 
          return this.definitionId != null && !this.definitionId.isEmpty();
        }

        /**
         * @param value {@link #definitionId} (Defines the characteristic using id.). This is the underlying object with id, value and extensions. The accessor "getDefinitionId" gives direct access to the value
         */
        public EvidenceVariableCharacteristicComponent setDefinitionIdElement(IdType value) { 
          this.definitionId = value;
          return this;
        }

        /**
         * @return Defines the characteristic using id.
         */
        public String getDefinitionId() { 
          return this.definitionId == null ? null : this.definitionId.getValue();
        }

        /**
         * @param value Defines the characteristic using id.
         */
        public EvidenceVariableCharacteristicComponent setDefinitionId(String value) { 
          if (Utilities.noString(value))
            this.definitionId = null;
          else {
            if (this.definitionId == null)
              this.definitionId = new IdType();
            this.definitionId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #definitionByTypeAndValue} (Defines the characteristic using both a type and value[x] elements.)
         */
        public EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent getDefinitionByTypeAndValue() { 
          if (this.definitionByTypeAndValue == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicComponent.definitionByTypeAndValue");
            else if (Configuration.doAutoCreate())
              this.definitionByTypeAndValue = new EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent(); // cc
          return this.definitionByTypeAndValue;
        }

        public boolean hasDefinitionByTypeAndValue() { 
          return this.definitionByTypeAndValue != null && !this.definitionByTypeAndValue.isEmpty();
        }

        /**
         * @param value {@link #definitionByTypeAndValue} (Defines the characteristic using both a type and value[x] elements.)
         */
        public EvidenceVariableCharacteristicComponent setDefinitionByTypeAndValue(EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent value) { 
          this.definitionByTypeAndValue = value;
          return this;
        }

        /**
         * @return {@link #definitionByCombination} (Defines the characteristic as a combination of two or more characteristics.)
         */
        public EvidenceVariableCharacteristicDefinitionByCombinationComponent getDefinitionByCombination() { 
          if (this.definitionByCombination == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicComponent.definitionByCombination");
            else if (Configuration.doAutoCreate())
              this.definitionByCombination = new EvidenceVariableCharacteristicDefinitionByCombinationComponent(); // cc
          return this.definitionByCombination;
        }

        public boolean hasDefinitionByCombination() { 
          return this.definitionByCombination != null && !this.definitionByCombination.isEmpty();
        }

        /**
         * @param value {@link #definitionByCombination} (Defines the characteristic as a combination of two or more characteristics.)
         */
        public EvidenceVariableCharacteristicComponent setDefinitionByCombination(EvidenceVariableCharacteristicDefinitionByCombinationComponent value) { 
          this.definitionByCombination = value;
          return this;
        }

        /**
         * @return {@link #timeFromEvent} (Observation time from study specified event.)
         */
        public List<EvidenceVariableCharacteristicTimeFromEventComponent> getTimeFromEvent() { 
          if (this.timeFromEvent == null)
            this.timeFromEvent = new ArrayList<EvidenceVariableCharacteristicTimeFromEventComponent>();
          return this.timeFromEvent;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceVariableCharacteristicComponent setTimeFromEvent(List<EvidenceVariableCharacteristicTimeFromEventComponent> theTimeFromEvent) { 
          this.timeFromEvent = theTimeFromEvent;
          return this;
        }

        public boolean hasTimeFromEvent() { 
          if (this.timeFromEvent == null)
            return false;
          for (EvidenceVariableCharacteristicTimeFromEventComponent item : this.timeFromEvent)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public EvidenceVariableCharacteristicTimeFromEventComponent addTimeFromEvent() { //3
          EvidenceVariableCharacteristicTimeFromEventComponent t = new EvidenceVariableCharacteristicTimeFromEventComponent();
          if (this.timeFromEvent == null)
            this.timeFromEvent = new ArrayList<EvidenceVariableCharacteristicTimeFromEventComponent>();
          this.timeFromEvent.add(t);
          return t;
        }

        public EvidenceVariableCharacteristicComponent addTimeFromEvent(EvidenceVariableCharacteristicTimeFromEventComponent t) { //3
          if (t == null)
            return this;
          if (this.timeFromEvent == null)
            this.timeFromEvent = new ArrayList<EvidenceVariableCharacteristicTimeFromEventComponent>();
          this.timeFromEvent.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #timeFromEvent}, creating it if it does not already exist {3}
         */
        public EvidenceVariableCharacteristicTimeFromEventComponent getTimeFromEventFirstRep() { 
          if (getTimeFromEvent().isEmpty()) {
            addTimeFromEvent();
          }
          return getTimeFromEvent().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("linkId", "id", "Label used for when a characteristic refers to another characteristic.", 0, 1, linkId));
          children.add(new Property("description", "string", "A short, natural language description of the characteristic that could be used to communicate the criteria to an end-user.", 0, 1, description));
          children.add(new Property("note", "Annotation", "A human-readable string to clarify or explain concepts about the characteristic.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("exclude", "boolean", "When true, this characteristic is an exclusion criterion. In other words, not matching this characteristic definition is equivalent to meeting this criterion.", 0, 1, exclude));
          children.add(new Property("definitionReference", "Reference(EvidenceVariable|Group|Evidence)", "Defines the characteristic using a Reference.", 0, 1, definitionReference));
          children.add(new Property("definitionCanonical", "canonical(EvidenceVariable|Evidence)", "Defines the characteristic using Canonical.", 0, 1, definitionCanonical));
          children.add(new Property("definitionCodeableConcept", "CodeableConcept", "Defines the characteristic using CodeableConcept.", 0, 1, definitionCodeableConcept));
          children.add(new Property("definitionExpression", "Expression", "Defines the characteristic using Expression.", 0, 1, definitionExpression));
          children.add(new Property("definitionId", "id", "Defines the characteristic using id.", 0, 1, definitionId));
          children.add(new Property("definitionByTypeAndValue", "", "Defines the characteristic using both a type and value[x] elements.", 0, 1, definitionByTypeAndValue));
          children.add(new Property("definitionByCombination", "", "Defines the characteristic as a combination of two or more characteristics.", 0, 1, definitionByCombination));
          children.add(new Property("timeFromEvent", "", "Observation time from study specified event.", 0, java.lang.Integer.MAX_VALUE, timeFromEvent));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1102667083: /*linkId*/  return new Property("linkId", "id", "Label used for when a characteristic refers to another characteristic.", 0, 1, linkId);
          case -1724546052: /*description*/  return new Property("description", "string", "A short, natural language description of the characteristic that could be used to communicate the criteria to an end-user.", 0, 1, description);
          case 3387378: /*note*/  return new Property("note", "Annotation", "A human-readable string to clarify or explain concepts about the characteristic.", 0, java.lang.Integer.MAX_VALUE, note);
          case -1321148966: /*exclude*/  return new Property("exclude", "boolean", "When true, this characteristic is an exclusion criterion. In other words, not matching this characteristic definition is equivalent to meeting this criterion.", 0, 1, exclude);
          case -820021448: /*definitionReference*/  return new Property("definitionReference", "Reference(EvidenceVariable|Group|Evidence)", "Defines the characteristic using a Reference.", 0, 1, definitionReference);
          case 933485793: /*definitionCanonical*/  return new Property("definitionCanonical", "canonical(EvidenceVariable|Evidence)", "Defines the characteristic using Canonical.", 0, 1, definitionCanonical);
          case -1446002226: /*definitionCodeableConcept*/  return new Property("definitionCodeableConcept", "CodeableConcept", "Defines the characteristic using CodeableConcept.", 0, 1, definitionCodeableConcept);
          case 1463703627: /*definitionExpression*/  return new Property("definitionExpression", "Expression", "Defines the characteristic using Expression.", 0, 1, definitionExpression);
          case 101791182: /*definitionId*/  return new Property("definitionId", "id", "Defines the characteristic using id.", 0, 1, definitionId);
          case -164357794: /*definitionByTypeAndValue*/  return new Property("definitionByTypeAndValue", "", "Defines the characteristic using both a type and value[x] elements.", 0, 1, definitionByTypeAndValue);
          case -2043280539: /*definitionByCombination*/  return new Property("definitionByCombination", "", "Defines the characteristic as a combination of two or more characteristics.", 0, 1, definitionByCombination);
          case 2087274691: /*timeFromEvent*/  return new Property("timeFromEvent", "", "Observation time from study specified event.", 0, java.lang.Integer.MAX_VALUE, timeFromEvent);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return this.linkId == null ? new Base[0] : new Base[] {this.linkId}; // IdType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1321148966: /*exclude*/ return this.exclude == null ? new Base[0] : new Base[] {this.exclude}; // BooleanType
        case -820021448: /*definitionReference*/ return this.definitionReference == null ? new Base[0] : new Base[] {this.definitionReference}; // Reference
        case 933485793: /*definitionCanonical*/ return this.definitionCanonical == null ? new Base[0] : new Base[] {this.definitionCanonical}; // CanonicalType
        case -1446002226: /*definitionCodeableConcept*/ return this.definitionCodeableConcept == null ? new Base[0] : new Base[] {this.definitionCodeableConcept}; // CodeableConcept
        case 1463703627: /*definitionExpression*/ return this.definitionExpression == null ? new Base[0] : new Base[] {this.definitionExpression}; // Expression
        case 101791182: /*definitionId*/ return this.definitionId == null ? new Base[0] : new Base[] {this.definitionId}; // IdType
        case -164357794: /*definitionByTypeAndValue*/ return this.definitionByTypeAndValue == null ? new Base[0] : new Base[] {this.definitionByTypeAndValue}; // EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent
        case -2043280539: /*definitionByCombination*/ return this.definitionByCombination == null ? new Base[0] : new Base[] {this.definitionByCombination}; // EvidenceVariableCharacteristicDefinitionByCombinationComponent
        case 2087274691: /*timeFromEvent*/ return this.timeFromEvent == null ? new Base[0] : this.timeFromEvent.toArray(new Base[this.timeFromEvent.size()]); // EvidenceVariableCharacteristicTimeFromEventComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1102667083: // linkId
          this.linkId = TypeConvertor.castToId(value); // IdType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1321148966: // exclude
          this.exclude = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -820021448: // definitionReference
          this.definitionReference = TypeConvertor.castToReference(value); // Reference
          return value;
        case 933485793: // definitionCanonical
          this.definitionCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -1446002226: // definitionCodeableConcept
          this.definitionCodeableConcept = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1463703627: // definitionExpression
          this.definitionExpression = TypeConvertor.castToExpression(value); // Expression
          return value;
        case 101791182: // definitionId
          this.definitionId = TypeConvertor.castToId(value); // IdType
          return value;
        case -164357794: // definitionByTypeAndValue
          this.definitionByTypeAndValue = (EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent) value; // EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent
          return value;
        case -2043280539: // definitionByCombination
          this.definitionByCombination = (EvidenceVariableCharacteristicDefinitionByCombinationComponent) value; // EvidenceVariableCharacteristicDefinitionByCombinationComponent
          return value;
        case 2087274691: // timeFromEvent
          this.getTimeFromEvent().add((EvidenceVariableCharacteristicTimeFromEventComponent) value); // EvidenceVariableCharacteristicTimeFromEventComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("exclude")) {
          this.exclude = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("definitionReference")) {
          this.definitionReference = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("definitionCanonical")) {
          this.definitionCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("definitionCodeableConcept")) {
          this.definitionCodeableConcept = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("definitionExpression")) {
          this.definitionExpression = TypeConvertor.castToExpression(value); // Expression
        } else if (name.equals("definitionId")) {
          this.definitionId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("definitionByTypeAndValue")) {
          this.definitionByTypeAndValue = (EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent) value; // EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent
        } else if (name.equals("definitionByCombination")) {
          this.definitionByCombination = (EvidenceVariableCharacteristicDefinitionByCombinationComponent) value; // EvidenceVariableCharacteristicDefinitionByCombinationComponent
        } else if (name.equals("timeFromEvent")) {
          this.getTimeFromEvent().add((EvidenceVariableCharacteristicTimeFromEventComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083:  return getLinkIdElement();
        case -1724546052:  return getDescriptionElement();
        case 3387378:  return addNote(); 
        case -1321148966:  return getExcludeElement();
        case -820021448:  return getDefinitionReference();
        case 933485793:  return getDefinitionCanonicalElement();
        case -1446002226:  return getDefinitionCodeableConcept();
        case 1463703627:  return getDefinitionExpression();
        case 101791182:  return getDefinitionIdElement();
        case -164357794:  return getDefinitionByTypeAndValue();
        case -2043280539:  return getDefinitionByCombination();
        case 2087274691:  return addTimeFromEvent(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return new String[] {"id"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -1321148966: /*exclude*/ return new String[] {"boolean"};
        case -820021448: /*definitionReference*/ return new String[] {"Reference"};
        case 933485793: /*definitionCanonical*/ return new String[] {"canonical"};
        case -1446002226: /*definitionCodeableConcept*/ return new String[] {"CodeableConcept"};
        case 1463703627: /*definitionExpression*/ return new String[] {"Expression"};
        case 101791182: /*definitionId*/ return new String[] {"id"};
        case -164357794: /*definitionByTypeAndValue*/ return new String[] {};
        case -2043280539: /*definitionByCombination*/ return new String[] {};
        case 2087274691: /*timeFromEvent*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkId")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.characteristic.linkId");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.characteristic.description");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("exclude")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.characteristic.exclude");
        }
        else if (name.equals("definitionReference")) {
          this.definitionReference = new Reference();
          return this.definitionReference;
        }
        else if (name.equals("definitionCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.characteristic.definitionCanonical");
        }
        else if (name.equals("definitionCodeableConcept")) {
          this.definitionCodeableConcept = new CodeableConcept();
          return this.definitionCodeableConcept;
        }
        else if (name.equals("definitionExpression")) {
          this.definitionExpression = new Expression();
          return this.definitionExpression;
        }
        else if (name.equals("definitionId")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.characteristic.definitionId");
        }
        else if (name.equals("definitionByTypeAndValue")) {
          this.definitionByTypeAndValue = new EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent();
          return this.definitionByTypeAndValue;
        }
        else if (name.equals("definitionByCombination")) {
          this.definitionByCombination = new EvidenceVariableCharacteristicDefinitionByCombinationComponent();
          return this.definitionByCombination;
        }
        else if (name.equals("timeFromEvent")) {
          return addTimeFromEvent();
        }
        else
          return super.addChild(name);
      }

      public EvidenceVariableCharacteristicComponent copy() {
        EvidenceVariableCharacteristicComponent dst = new EvidenceVariableCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceVariableCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.linkId = linkId == null ? null : linkId.copy();
        dst.description = description == null ? null : description.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.exclude = exclude == null ? null : exclude.copy();
        dst.definitionReference = definitionReference == null ? null : definitionReference.copy();
        dst.definitionCanonical = definitionCanonical == null ? null : definitionCanonical.copy();
        dst.definitionCodeableConcept = definitionCodeableConcept == null ? null : definitionCodeableConcept.copy();
        dst.definitionExpression = definitionExpression == null ? null : definitionExpression.copy();
        dst.definitionId = definitionId == null ? null : definitionId.copy();
        dst.definitionByTypeAndValue = definitionByTypeAndValue == null ? null : definitionByTypeAndValue.copy();
        dst.definitionByCombination = definitionByCombination == null ? null : definitionByCombination.copy();
        if (timeFromEvent != null) {
          dst.timeFromEvent = new ArrayList<EvidenceVariableCharacteristicTimeFromEventComponent>();
          for (EvidenceVariableCharacteristicTimeFromEventComponent i : timeFromEvent)
            dst.timeFromEvent.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableCharacteristicComponent))
          return false;
        EvidenceVariableCharacteristicComponent o = (EvidenceVariableCharacteristicComponent) other_;
        return compareDeep(linkId, o.linkId, true) && compareDeep(description, o.description, true) && compareDeep(note, o.note, true)
           && compareDeep(exclude, o.exclude, true) && compareDeep(definitionReference, o.definitionReference, true)
           && compareDeep(definitionCanonical, o.definitionCanonical, true) && compareDeep(definitionCodeableConcept, o.definitionCodeableConcept, true)
           && compareDeep(definitionExpression, o.definitionExpression, true) && compareDeep(definitionId, o.definitionId, true)
           && compareDeep(definitionByTypeAndValue, o.definitionByTypeAndValue, true) && compareDeep(definitionByCombination, o.definitionByCombination, true)
           && compareDeep(timeFromEvent, o.timeFromEvent, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableCharacteristicComponent))
          return false;
        EvidenceVariableCharacteristicComponent o = (EvidenceVariableCharacteristicComponent) other_;
        return compareValues(linkId, o.linkId, true) && compareValues(description, o.description, true) && compareValues(exclude, o.exclude, true)
           && compareValues(definitionCanonical, o.definitionCanonical, true) && compareValues(definitionId, o.definitionId, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(linkId, description, note
          , exclude, definitionReference, definitionCanonical, definitionCodeableConcept, definitionExpression
          , definitionId, definitionByTypeAndValue, definitionByCombination, timeFromEvent);
      }

  public String fhirType() {
    return "EvidenceVariable.characteristic";

  }

  }

    @Block()
    public static class EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used to express the type of characteristic.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Expresses the type of characteristic", formalDefinition="Used to express the type of characteristic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/usage-context-type")
        protected CodeableConcept type;

        /**
         * Method for how the characteristic value was determined.
         */
        @Child(name = "method", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Method for how the characteristic value was determined", formalDefinition="Method for how the characteristic value was determined." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/definition-method")
        protected List<CodeableConcept> method;

        /**
         * Device used for determining characteristic.
         */
        @Child(name = "device", type = {Device.class, DeviceMetric.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Device used for determining characteristic", formalDefinition="Device used for determining characteristic." )
        protected Reference device;

        /**
         * Defines the characteristic when paired with characteristic.type.
         */
        @Child(name = "value", type = {CodeableConcept.class, BooleanType.class, Quantity.class, Range.class, Reference.class, IdType.class}, order=4, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Defines the characteristic when coupled with characteristic.type", formalDefinition="Defines the characteristic when paired with characteristic.type." )
        protected DataType value;

        /**
         * Defines the reference point for comparison when valueQuantity is not compared to zero.
         */
        @Child(name = "offset", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reference point for valueQuantity", formalDefinition="Defines the reference point for comparison when valueQuantity is not compared to zero." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/characteristic-offset")
        protected CodeableConcept offset;

        private static final long serialVersionUID = -498341653L;

    /**
     * Constructor
     */
      public EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent() {
        super();
      }

    /**
     * Constructor
     */
      public EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent(CodeableConcept type, DataType value) {
        super();
        this.setType(type);
        this.setValue(value);
      }

        /**
         * @return {@link #type} (Used to express the type of characteristic.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Used to express the type of characteristic.)
         */
        public EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #method} (Method for how the characteristic value was determined.)
         */
        public List<CodeableConcept> getMethod() { 
          if (this.method == null)
            this.method = new ArrayList<CodeableConcept>();
          return this.method;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent setMethod(List<CodeableConcept> theMethod) { 
          this.method = theMethod;
          return this;
        }

        public boolean hasMethod() { 
          if (this.method == null)
            return false;
          for (CodeableConcept item : this.method)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addMethod() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.method == null)
            this.method = new ArrayList<CodeableConcept>();
          this.method.add(t);
          return t;
        }

        public EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent addMethod(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.method == null)
            this.method = new ArrayList<CodeableConcept>();
          this.method.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #method}, creating it if it does not already exist {3}
         */
        public CodeableConcept getMethodFirstRep() { 
          if (getMethod().isEmpty()) {
            addMethod();
          }
          return getMethod().get(0);
        }

        /**
         * @return {@link #device} (Device used for determining characteristic.)
         */
        public Reference getDevice() { 
          if (this.device == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent.device");
            else if (Configuration.doAutoCreate())
              this.device = new Reference(); // cc
          return this.device;
        }

        public boolean hasDevice() { 
          return this.device != null && !this.device.isEmpty();
        }

        /**
         * @param value {@link #device} (Device used for determining characteristic.)
         */
        public EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent setDevice(Reference value) { 
          this.device = value;
          return this;
        }

        /**
         * @return {@link #value} (Defines the characteristic when paired with characteristic.type.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Defines the characteristic when paired with characteristic.type.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (Defines the characteristic when paired with characteristic.type.)
         */
        public BooleanType getValueBooleanType() throws FHIRException { 
          if (this.value == null)
            this.value = new BooleanType();
          if (!(this.value instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (BooleanType) this.value;
        }

        public boolean hasValueBooleanType() { 
          return this != null && this.value instanceof BooleanType;
        }

        /**
         * @return {@link #value} (Defines the characteristic when paired with characteristic.type.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (Defines the characteristic when paired with characteristic.type.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        /**
         * @return {@link #value} (Defines the characteristic when paired with characteristic.type.)
         */
        public Reference getValueReference() throws FHIRException { 
          if (this.value == null)
            this.value = new Reference();
          if (!(this.value instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Reference) this.value;
        }

        public boolean hasValueReference() { 
          return this != null && this.value instanceof Reference;
        }

        /**
         * @return {@link #value} (Defines the characteristic when paired with characteristic.type.)
         */
        public IdType getValueIdType() throws FHIRException { 
          if (this.value == null)
            this.value = new IdType();
          if (!(this.value instanceof IdType))
            throw new FHIRException("Type mismatch: the type IdType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (IdType) this.value;
        }

        public boolean hasValueIdType() { 
          return this != null && this.value instanceof IdType;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Defines the characteristic when paired with characteristic.type.)
         */
        public EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof BooleanType || value instanceof Quantity || value instanceof Range || value instanceof Reference || value instanceof IdType))
            throw new Error("Not the right type for EvidenceVariable.characteristic.definitionByTypeAndValue.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        /**
         * @return {@link #offset} (Defines the reference point for comparison when valueQuantity is not compared to zero.)
         */
        public CodeableConcept getOffset() { 
          if (this.offset == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent.offset");
            else if (Configuration.doAutoCreate())
              this.offset = new CodeableConcept(); // cc
          return this.offset;
        }

        public boolean hasOffset() { 
          return this.offset != null && !this.offset.isEmpty();
        }

        /**
         * @param value {@link #offset} (Defines the reference point for comparison when valueQuantity is not compared to zero.)
         */
        public EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent setOffset(CodeableConcept value) { 
          this.offset = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Used to express the type of characteristic.", 0, 1, type));
          children.add(new Property("method", "CodeableConcept", "Method for how the characteristic value was determined.", 0, java.lang.Integer.MAX_VALUE, method));
          children.add(new Property("device", "Reference(Device|DeviceMetric)", "Device used for determining characteristic.", 0, 1, device));
          children.add(new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference|id", "Defines the characteristic when paired with characteristic.type.", 0, 1, value));
          children.add(new Property("offset", "CodeableConcept", "Defines the reference point for comparison when valueQuantity is not compared to zero.", 0, 1, offset));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Used to express the type of characteristic.", 0, 1, type);
          case -1077554975: /*method*/  return new Property("method", "CodeableConcept", "Method for how the characteristic value was determined.", 0, java.lang.Integer.MAX_VALUE, method);
          case -1335157162: /*device*/  return new Property("device", "Reference(Device|DeviceMetric)", "Device used for determining characteristic.", 0, 1, device);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference|id", "Defines the characteristic when paired with characteristic.type.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|boolean|Quantity|Range|Reference|id", "Defines the characteristic when paired with characteristic.type.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "Defines the characteristic when paired with characteristic.type.", 0, 1, value);
          case 733421943: /*valueBoolean*/  return new Property("value[x]", "boolean", "Defines the characteristic when paired with characteristic.type.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "Defines the characteristic when paired with characteristic.type.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "Defines the characteristic when paired with characteristic.type.", 0, 1, value);
          case 1755241690: /*valueReference*/  return new Property("value[x]", "Reference", "Defines the characteristic when paired with characteristic.type.", 0, 1, value);
          case 231604844: /*valueId*/  return new Property("value[x]", "id", "Defines the characteristic when paired with characteristic.type.", 0, 1, value);
          case -1019779949: /*offset*/  return new Property("offset", "CodeableConcept", "Defines the reference point for comparison when valueQuantity is not compared to zero.", 0, 1, offset);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1077554975: /*method*/ return this.method == null ? new Base[0] : this.method.toArray(new Base[this.method.size()]); // CodeableConcept
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // Reference
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        case -1019779949: /*offset*/ return this.offset == null ? new Base[0] : new Base[] {this.offset}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1077554975: // method
          this.getMethod().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1335157162: // device
          this.device = TypeConvertor.castToReference(value); // Reference
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        case -1019779949: // offset
          this.offset = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("method")) {
          this.getMethod().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("device")) {
          this.device = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("offset")) {
          this.offset = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1077554975:  return addMethod(); 
        case -1335157162:  return getDevice();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        case -1019779949:  return getOffset();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1077554975: /*method*/ return new String[] {"CodeableConcept"};
        case -1335157162: /*device*/ return new String[] {"Reference"};
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "boolean", "Quantity", "Range", "Reference", "id"};
        case -1019779949: /*offset*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("method")) {
          return addMethod();
        }
        else if (name.equals("device")) {
          this.device = new Reference();
          return this.device;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueBoolean")) {
          this.value = new BooleanType();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueReference")) {
          this.value = new Reference();
          return this.value;
        }
        else if (name.equals("valueId")) {
          this.value = new IdType();
          return this.value;
        }
        else if (name.equals("offset")) {
          this.offset = new CodeableConcept();
          return this.offset;
        }
        else
          return super.addChild(name);
      }

      public EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent copy() {
        EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent dst = new EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (method != null) {
          dst.method = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : method)
            dst.method.add(i.copy());
        };
        dst.device = device == null ? null : device.copy();
        dst.value = value == null ? null : value.copy();
        dst.offset = offset == null ? null : offset.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent))
          return false;
        EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent o = (EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(method, o.method, true) && compareDeep(device, o.device, true)
           && compareDeep(value, o.value, true) && compareDeep(offset, o.offset, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent))
          return false;
        EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent o = (EvidenceVariableCharacteristicDefinitionByTypeAndValueComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, method, device, value
          , offset);
      }

  public String fhirType() {
    return "EvidenceVariable.characteristic.definitionByTypeAndValue";

  }

  }

    @Block()
    public static class EvidenceVariableCharacteristicDefinitionByCombinationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Used to specify if two or more characteristics are combined with OR or AND.
         */
        @Child(name = "code", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="all-of | any-of | at-least | at-most | statistical | net-effect | dataset", formalDefinition="Used to specify if two or more characteristics are combined with OR or AND." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/characteristic-combination")
        protected Enumeration<CharacteristicCombination> code;

        /**
         * Provides the value of "n" when "at-least" or "at-most" codes are used.
         */
        @Child(name = "threshold", type = {PositiveIntType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Provides the value of \"n\" when \"at-least\" or \"at-most\" codes are used", formalDefinition="Provides the value of \"n\" when \"at-least\" or \"at-most\" codes are used." )
        protected PositiveIntType threshold;

        /**
         * A defining factor of the characteristic.
         */
        @Child(name = "characteristic", type = {EvidenceVariableCharacteristicComponent.class}, order=3, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A defining factor of the characteristic", formalDefinition="A defining factor of the characteristic." )
        protected List<EvidenceVariableCharacteristicComponent> characteristic;

        private static final long serialVersionUID = -2053118515L;

    /**
     * Constructor
     */
      public EvidenceVariableCharacteristicDefinitionByCombinationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public EvidenceVariableCharacteristicDefinitionByCombinationComponent(CharacteristicCombination code, EvidenceVariableCharacteristicComponent characteristic) {
        super();
        this.setCode(code);
        this.addCharacteristic(characteristic);
      }

        /**
         * @return {@link #code} (Used to specify if two or more characteristics are combined with OR or AND.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public Enumeration<CharacteristicCombination> getCodeElement() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicDefinitionByCombinationComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new Enumeration<CharacteristicCombination>(new CharacteristicCombinationEnumFactory()); // bb
          return this.code;
        }

        public boolean hasCodeElement() { 
          return this.code != null && !this.code.isEmpty();
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Used to specify if two or more characteristics are combined with OR or AND.). This is the underlying object with id, value and extensions. The accessor "getCode" gives direct access to the value
         */
        public EvidenceVariableCharacteristicDefinitionByCombinationComponent setCodeElement(Enumeration<CharacteristicCombination> value) { 
          this.code = value;
          return this;
        }

        /**
         * @return Used to specify if two or more characteristics are combined with OR or AND.
         */
        public CharacteristicCombination getCode() { 
          return this.code == null ? null : this.code.getValue();
        }

        /**
         * @param value Used to specify if two or more characteristics are combined with OR or AND.
         */
        public EvidenceVariableCharacteristicDefinitionByCombinationComponent setCode(CharacteristicCombination value) { 
            if (this.code == null)
              this.code = new Enumeration<CharacteristicCombination>(new CharacteristicCombinationEnumFactory());
            this.code.setValue(value);
          return this;
        }

        /**
         * @return {@link #threshold} (Provides the value of "n" when "at-least" or "at-most" codes are used.). This is the underlying object with id, value and extensions. The accessor "getThreshold" gives direct access to the value
         */
        public PositiveIntType getThresholdElement() { 
          if (this.threshold == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicDefinitionByCombinationComponent.threshold");
            else if (Configuration.doAutoCreate())
              this.threshold = new PositiveIntType(); // bb
          return this.threshold;
        }

        public boolean hasThresholdElement() { 
          return this.threshold != null && !this.threshold.isEmpty();
        }

        public boolean hasThreshold() { 
          return this.threshold != null && !this.threshold.isEmpty();
        }

        /**
         * @param value {@link #threshold} (Provides the value of "n" when "at-least" or "at-most" codes are used.). This is the underlying object with id, value and extensions. The accessor "getThreshold" gives direct access to the value
         */
        public EvidenceVariableCharacteristicDefinitionByCombinationComponent setThresholdElement(PositiveIntType value) { 
          this.threshold = value;
          return this;
        }

        /**
         * @return Provides the value of "n" when "at-least" or "at-most" codes are used.
         */
        public int getThreshold() { 
          return this.threshold == null || this.threshold.isEmpty() ? 0 : this.threshold.getValue();
        }

        /**
         * @param value Provides the value of "n" when "at-least" or "at-most" codes are used.
         */
        public EvidenceVariableCharacteristicDefinitionByCombinationComponent setThreshold(int value) { 
            if (this.threshold == null)
              this.threshold = new PositiveIntType();
            this.threshold.setValue(value);
          return this;
        }

        /**
         * @return {@link #characteristic} (A defining factor of the characteristic.)
         */
        public List<EvidenceVariableCharacteristicComponent> getCharacteristic() { 
          if (this.characteristic == null)
            this.characteristic = new ArrayList<EvidenceVariableCharacteristicComponent>();
          return this.characteristic;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceVariableCharacteristicDefinitionByCombinationComponent setCharacteristic(List<EvidenceVariableCharacteristicComponent> theCharacteristic) { 
          this.characteristic = theCharacteristic;
          return this;
        }

        public boolean hasCharacteristic() { 
          if (this.characteristic == null)
            return false;
          for (EvidenceVariableCharacteristicComponent item : this.characteristic)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public EvidenceVariableCharacteristicComponent addCharacteristic() { //3
          EvidenceVariableCharacteristicComponent t = new EvidenceVariableCharacteristicComponent();
          if (this.characteristic == null)
            this.characteristic = new ArrayList<EvidenceVariableCharacteristicComponent>();
          this.characteristic.add(t);
          return t;
        }

        public EvidenceVariableCharacteristicDefinitionByCombinationComponent addCharacteristic(EvidenceVariableCharacteristicComponent t) { //3
          if (t == null)
            return this;
          if (this.characteristic == null)
            this.characteristic = new ArrayList<EvidenceVariableCharacteristicComponent>();
          this.characteristic.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist {3}
         */
        public EvidenceVariableCharacteristicComponent getCharacteristicFirstRep() { 
          if (getCharacteristic().isEmpty()) {
            addCharacteristic();
          }
          return getCharacteristic().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "code", "Used to specify if two or more characteristics are combined with OR or AND.", 0, 1, code));
          children.add(new Property("threshold", "positiveInt", "Provides the value of \"n\" when \"at-least\" or \"at-most\" codes are used.", 0, 1, threshold));
          children.add(new Property("characteristic", "@EvidenceVariable.characteristic", "A defining factor of the characteristic.", 0, java.lang.Integer.MAX_VALUE, characteristic));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "code", "Used to specify if two or more characteristics are combined with OR or AND.", 0, 1, code);
          case -1545477013: /*threshold*/  return new Property("threshold", "positiveInt", "Provides the value of \"n\" when \"at-least\" or \"at-most\" codes are used.", 0, 1, threshold);
          case 366313883: /*characteristic*/  return new Property("characteristic", "@EvidenceVariable.characteristic", "A defining factor of the characteristic.", 0, java.lang.Integer.MAX_VALUE, characteristic);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // Enumeration<CharacteristicCombination>
        case -1545477013: /*threshold*/ return this.threshold == null ? new Base[0] : new Base[] {this.threshold}; // PositiveIntType
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // EvidenceVariableCharacteristicComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          value = new CharacteristicCombinationEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<CharacteristicCombination>
          return value;
        case -1545477013: // threshold
          this.threshold = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add((EvidenceVariableCharacteristicComponent) value); // EvidenceVariableCharacteristicComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          value = new CharacteristicCombinationEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.code = (Enumeration) value; // Enumeration<CharacteristicCombination>
        } else if (name.equals("threshold")) {
          this.threshold = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add((EvidenceVariableCharacteristicComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCodeElement();
        case -1545477013:  return getThresholdElement();
        case 366313883:  return addCharacteristic(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"code"};
        case -1545477013: /*threshold*/ return new String[] {"positiveInt"};
        case 366313883: /*characteristic*/ return new String[] {"@EvidenceVariable.characteristic"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.characteristic.definitionByCombination.code");
        }
        else if (name.equals("threshold")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.characteristic.definitionByCombination.threshold");
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
        }
        else
          return super.addChild(name);
      }

      public EvidenceVariableCharacteristicDefinitionByCombinationComponent copy() {
        EvidenceVariableCharacteristicDefinitionByCombinationComponent dst = new EvidenceVariableCharacteristicDefinitionByCombinationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceVariableCharacteristicDefinitionByCombinationComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.threshold = threshold == null ? null : threshold.copy();
        if (characteristic != null) {
          dst.characteristic = new ArrayList<EvidenceVariableCharacteristicComponent>();
          for (EvidenceVariableCharacteristicComponent i : characteristic)
            dst.characteristic.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableCharacteristicDefinitionByCombinationComponent))
          return false;
        EvidenceVariableCharacteristicDefinitionByCombinationComponent o = (EvidenceVariableCharacteristicDefinitionByCombinationComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(threshold, o.threshold, true) && compareDeep(characteristic, o.characteristic, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableCharacteristicDefinitionByCombinationComponent))
          return false;
        EvidenceVariableCharacteristicDefinitionByCombinationComponent o = (EvidenceVariableCharacteristicDefinitionByCombinationComponent) other_;
        return compareValues(code, o.code, true) && compareValues(threshold, o.threshold, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, threshold, characteristic
          );
      }

  public String fhirType() {
    return "EvidenceVariable.characteristic.definitionByCombination";

  }

  }

    @Block()
    public static class EvidenceVariableCharacteristicTimeFromEventComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Human readable description.
         */
        @Child(name = "description", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Human readable description", formalDefinition="Human readable description." )
        protected StringType description;

        /**
         * A human-readable string to clarify or explain concepts about the timeFromEvent.
         */
        @Child(name = "note", type = {Annotation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Used for footnotes or explanatory notes", formalDefinition="A human-readable string to clarify or explain concepts about the timeFromEvent." )
        protected List<Annotation> note;

        /**
         * The event used as a base point (reference point) in time.
         */
        @Child(name = "event", type = {CodeableConcept.class, Reference.class, DateTimeType.class, IdType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The event used as a base point (reference point) in time", formalDefinition="The event used as a base point (reference point) in time." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/evidence-variable-event")
        protected DataType event;

        /**
         * Used to express the observation at a defined amount of time after the study start.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to express the observation at a defined amount of time after the study start", formalDefinition="Used to express the observation at a defined amount of time after the study start." )
        protected Quantity quantity;

        /**
         * Used to express the observation within a period after the study start.
         */
        @Child(name = "range", type = {Range.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Used to express the observation within a period after the study start", formalDefinition="Used to express the observation within a period after the study start." )
        protected Range range;

        private static final long serialVersionUID = 858422874L;

    /**
     * Constructor
     */
      public EvidenceVariableCharacteristicTimeFromEventComponent() {
        super();
      }

        /**
         * @return {@link #description} (Human readable description.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicTimeFromEventComponent.description");
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
         * @param value {@link #description} (Human readable description.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public EvidenceVariableCharacteristicTimeFromEventComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Human readable description.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Human readable description.
         */
        public EvidenceVariableCharacteristicTimeFromEventComponent setDescription(String value) { 
          if (Utilities.noString(value))
            this.description = null;
          else {
            if (this.description == null)
              this.description = new StringType();
            this.description.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #note} (A human-readable string to clarify or explain concepts about the timeFromEvent.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceVariableCharacteristicTimeFromEventComponent setNote(List<Annotation> theNote) { 
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

        public EvidenceVariableCharacteristicTimeFromEventComponent addNote(Annotation t) { //3
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
         * @return {@link #event} (The event used as a base point (reference point) in time.)
         */
        public DataType getEvent() { 
          return this.event;
        }

        /**
         * @return {@link #event} (The event used as a base point (reference point) in time.)
         */
        public CodeableConcept getEventCodeableConcept() throws FHIRException { 
          if (this.event == null)
            this.event = new CodeableConcept();
          if (!(this.event instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.event.getClass().getName()+" was encountered");
          return (CodeableConcept) this.event;
        }

        public boolean hasEventCodeableConcept() { 
          return this != null && this.event instanceof CodeableConcept;
        }

        /**
         * @return {@link #event} (The event used as a base point (reference point) in time.)
         */
        public Reference getEventReference() throws FHIRException { 
          if (this.event == null)
            this.event = new Reference();
          if (!(this.event instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.event.getClass().getName()+" was encountered");
          return (Reference) this.event;
        }

        public boolean hasEventReference() { 
          return this != null && this.event instanceof Reference;
        }

        /**
         * @return {@link #event} (The event used as a base point (reference point) in time.)
         */
        public DateTimeType getEventDateTimeType() throws FHIRException { 
          if (this.event == null)
            this.event = new DateTimeType();
          if (!(this.event instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.event.getClass().getName()+" was encountered");
          return (DateTimeType) this.event;
        }

        public boolean hasEventDateTimeType() { 
          return this != null && this.event instanceof DateTimeType;
        }

        /**
         * @return {@link #event} (The event used as a base point (reference point) in time.)
         */
        public IdType getEventIdType() throws FHIRException { 
          if (this.event == null)
            this.event = new IdType();
          if (!(this.event instanceof IdType))
            throw new FHIRException("Type mismatch: the type IdType was expected, but "+this.event.getClass().getName()+" was encountered");
          return (IdType) this.event;
        }

        public boolean hasEventIdType() { 
          return this != null && this.event instanceof IdType;
        }

        public boolean hasEvent() { 
          return this.event != null && !this.event.isEmpty();
        }

        /**
         * @param value {@link #event} (The event used as a base point (reference point) in time.)
         */
        public EvidenceVariableCharacteristicTimeFromEventComponent setEvent(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Reference || value instanceof DateTimeType || value instanceof IdType))
            throw new Error("Not the right type for EvidenceVariable.characteristic.timeFromEvent.event[x]: "+value.fhirType());
          this.event = value;
          return this;
        }

        /**
         * @return {@link #quantity} (Used to express the observation at a defined amount of time after the study start.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicTimeFromEventComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (Used to express the observation at a defined amount of time after the study start.)
         */
        public EvidenceVariableCharacteristicTimeFromEventComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #range} (Used to express the observation within a period after the study start.)
         */
        public Range getRange() { 
          if (this.range == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCharacteristicTimeFromEventComponent.range");
            else if (Configuration.doAutoCreate())
              this.range = new Range(); // cc
          return this.range;
        }

        public boolean hasRange() { 
          return this.range != null && !this.range.isEmpty();
        }

        /**
         * @param value {@link #range} (Used to express the observation within a period after the study start.)
         */
        public EvidenceVariableCharacteristicTimeFromEventComponent setRange(Range value) { 
          this.range = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "string", "Human readable description.", 0, 1, description));
          children.add(new Property("note", "Annotation", "A human-readable string to clarify or explain concepts about the timeFromEvent.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("event[x]", "CodeableConcept|Reference|dateTime|id", "The event used as a base point (reference point) in time.", 0, 1, event));
          children.add(new Property("quantity", "Quantity", "Used to express the observation at a defined amount of time after the study start.", 0, 1, quantity));
          children.add(new Property("range", "Range", "Used to express the observation within a period after the study start.", 0, 1, range));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "string", "Human readable description.", 0, 1, description);
          case 3387378: /*note*/  return new Property("note", "Annotation", "A human-readable string to clarify or explain concepts about the timeFromEvent.", 0, java.lang.Integer.MAX_VALUE, note);
          case 278115238: /*event[x]*/  return new Property("event[x]", "CodeableConcept|Reference|dateTime|id", "The event used as a base point (reference point) in time.", 0, 1, event);
          case 96891546: /*event*/  return new Property("event[x]", "CodeableConcept|Reference|dateTime|id", "The event used as a base point (reference point) in time.", 0, 1, event);
          case 1464167847: /*eventCodeableConcept*/  return new Property("event[x]", "CodeableConcept", "The event used as a base point (reference point) in time.", 0, 1, event);
          case 30751185: /*eventReference*/  return new Property("event[x]", "Reference", "The event used as a base point (reference point) in time.", 0, 1, event);
          case -116077483: /*eventDateTime*/  return new Property("event[x]", "dateTime", "The event used as a base point (reference point) in time.", 0, 1, event);
          case -1376502443: /*eventId*/  return new Property("event[x]", "id", "The event used as a base point (reference point) in time.", 0, 1, event);
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "Used to express the observation at a defined amount of time after the study start.", 0, 1, quantity);
          case 108280125: /*range*/  return new Property("range", "Range", "Used to express the observation within a period after the study start.", 0, 1, range);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 96891546: /*event*/ return this.event == null ? new Base[0] : new Base[] {this.event}; // DataType
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 108280125: /*range*/ return this.range == null ? new Base[0] : new Base[] {this.range}; // Range
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 96891546: // event
          this.event = TypeConvertor.castToType(value); // DataType
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 108280125: // range
          this.range = TypeConvertor.castToRange(value); // Range
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("event[x]")) {
          this.event = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("range")) {
          this.range = TypeConvertor.castToRange(value); // Range
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 3387378:  return addNote(); 
        case 278115238:  return getEvent();
        case 96891546:  return getEvent();
        case -1285004149:  return getQuantity();
        case 108280125:  return getRange();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 96891546: /*event*/ return new String[] {"CodeableConcept", "Reference", "dateTime", "id"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 108280125: /*range*/ return new String[] {"Range"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.characteristic.timeFromEvent.description");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("eventCodeableConcept")) {
          this.event = new CodeableConcept();
          return this.event;
        }
        else if (name.equals("eventReference")) {
          this.event = new Reference();
          return this.event;
        }
        else if (name.equals("eventDateTime")) {
          this.event = new DateTimeType();
          return this.event;
        }
        else if (name.equals("eventId")) {
          this.event = new IdType();
          return this.event;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("range")) {
          this.range = new Range();
          return this.range;
        }
        else
          return super.addChild(name);
      }

      public EvidenceVariableCharacteristicTimeFromEventComponent copy() {
        EvidenceVariableCharacteristicTimeFromEventComponent dst = new EvidenceVariableCharacteristicTimeFromEventComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceVariableCharacteristicTimeFromEventComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.event = event == null ? null : event.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.range = range == null ? null : range.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableCharacteristicTimeFromEventComponent))
          return false;
        EvidenceVariableCharacteristicTimeFromEventComponent o = (EvidenceVariableCharacteristicTimeFromEventComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(event, o.event, true)
           && compareDeep(quantity, o.quantity, true) && compareDeep(range, o.range, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableCharacteristicTimeFromEventComponent))
          return false;
        EvidenceVariableCharacteristicTimeFromEventComponent o = (EvidenceVariableCharacteristicTimeFromEventComponent) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, event
          , quantity, range);
      }

  public String fhirType() {
    return "EvidenceVariable.characteristic.timeFromEvent";

  }

  }

    @Block()
    public static class EvidenceVariableCategoryComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Description of the grouping.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of the grouping", formalDefinition="Description of the grouping." )
        protected StringType name;

        /**
         * Definition of the grouping.
         */
        @Child(name = "value", type = {CodeableConcept.class, Quantity.class, Range.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Definition of the grouping", formalDefinition="Definition of the grouping." )
        protected DataType value;

        private static final long serialVersionUID = 1839679495L;

    /**
     * Constructor
     */
      public EvidenceVariableCategoryComponent() {
        super();
      }

        /**
         * @return {@link #name} (Description of the grouping.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableCategoryComponent.name");
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
         * @param value {@link #name} (Description of the grouping.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public EvidenceVariableCategoryComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Description of the grouping.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Description of the grouping.
         */
        public EvidenceVariableCategoryComponent setName(String value) { 
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
         * @return {@link #value} (Definition of the grouping.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Definition of the grouping.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (Definition of the grouping.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (Definition of the grouping.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Definition of the grouping.)
         */
        public EvidenceVariableCategoryComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Quantity || value instanceof Range))
            throw new Error("Not the right type for EvidenceVariable.category.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "Description of the grouping.", 0, 1, name));
          children.add(new Property("value[x]", "CodeableConcept|Quantity|Range", "Definition of the grouping.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "Description of the grouping.", 0, 1, name);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|Quantity|Range", "Definition of the grouping.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|Quantity|Range", "Definition of the grouping.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "Definition of the grouping.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "Definition of the grouping.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "Definition of the grouping.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "Quantity", "Range"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.category.name");
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public EvidenceVariableCategoryComponent copy() {
        EvidenceVariableCategoryComponent dst = new EvidenceVariableCategoryComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceVariableCategoryComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableCategoryComponent))
          return false;
        EvidenceVariableCategoryComponent o = (EvidenceVariableCategoryComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableCategoryComponent))
          return false;
        EvidenceVariableCategoryComponent o = (EvidenceVariableCategoryComponent) other_;
        return compareValues(name, o.name, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, value);
      }

  public String fhirType() {
    return "EvidenceVariable.category";

  }

  }

    /**
     * An absolute URI that is used to identify this evidence variable when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this evidence variable is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the evidence variable is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this evidence variable, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this evidence variable when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this evidence variable is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the evidence variable is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this evidence variable when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the evidence variable", formalDefinition="A formal identifier that is used to identify this evidence variable when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the evidence variable when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the evidence variable author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the evidence variable", formalDefinition="The identifier that is used to identify this version of the evidence variable when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the evidence variable author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts." )
    protected StringType version;

    /**
     * A natural language name identifying the evidence variable. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this evidence variable (computer friendly)", formalDefinition="A natural language name identifying the evidence variable. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the evidence variable.
     */
    @Child(name = "title", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this evidence variable (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the evidence variable." )
    protected StringType title;

    /**
     * The short title provides an alternate title for use in informal descriptive contexts where the full, formal title is not necessary.
     */
    @Child(name = "shortTitle", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Title for use in informal contexts", formalDefinition="The short title provides an alternate title for use in informal descriptive contexts where the full, formal title is not necessary." )
    protected StringType shortTitle;

    /**
     * An explanatory or alternate title for the EvidenceVariable giving additional information about its content.
     */
    @Child(name = "subtitle", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Subordinate title of the EvidenceVariable", formalDefinition="An explanatory or alternate title for the EvidenceVariable giving additional information about its content." )
    protected StringType subtitle;

    /**
     * The status of this evidence variable. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=7, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this evidence variable. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the evidence variable was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence variable changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the evidence variable was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence variable changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the evidence variable.
     */
    @Child(name = "publisher", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the evidence variable." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the evidence variable from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Natural language description of the evidence variable", formalDefinition="A free text natural language description of the evidence variable from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * A human-readable string to clarify or explain concepts about the resource.
     */
    @Child(name = "note", type = {Annotation.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Used for footnotes or explanatory notes", formalDefinition="A human-readable string to clarify or explain concepts about the resource." )
    protected List<Annotation> note;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence variable instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence variable instances." )
    protected List<UsageContext> useContext;

    /**
     * A copyright statement relating to the resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the resource.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the resource." )
    protected MarkdownType copyright;

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the resource was approved by publisher", formalDefinition="The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the resource was last reviewed", formalDefinition="The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the resource content was or is planned to be in active use.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the resource is expected to be used", formalDefinition="The period during which the resource content was or is planned to be in active use." )
    protected Period effectivePeriod;

    /**
     * An individiual or organization primarily involved in the creation and maintenance of the content.
     */
    @Child(name = "author", type = {ContactDetail.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who authored the content", formalDefinition="An individiual or organization primarily involved in the creation and maintenance of the content." )
    protected List<ContactDetail> author;

    /**
     * An individual or organization primarily responsible for internal coherence of the content.
     */
    @Child(name = "editor", type = {ContactDetail.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who edited the content", formalDefinition="An individual or organization primarily responsible for internal coherence of the content." )
    protected List<ContactDetail> editor;

    /**
     * An individual or organization primarily responsible for review of some aspect of the content.
     */
    @Child(name = "reviewer", type = {ContactDetail.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who reviewed the content", formalDefinition="An individual or organization primarily responsible for review of some aspect of the content." )
    protected List<ContactDetail> reviewer;

    /**
     * An individual or organization responsible for officially endorsing the content for use in some setting.
     */
    @Child(name = "endorser", type = {ContactDetail.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who endorsed the content", formalDefinition="An individual or organization responsible for officially endorsing the content for use in some setting." )
    protected List<ContactDetail> endorser;

    /**
     * Related artifacts such as additional documentation, justification, or bibliographic references.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional documentation, citations, etc.", formalDefinition="Related artifacts such as additional documentation, justification, or bibliographic references." )
    protected List<RelatedArtifact> relatedArtifact;

    /**
     * True if the actual variable measured, false if a conceptual representation of the intended variable.
     */
    @Child(name = "actual", type = {BooleanType.class}, order=24, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Actual or conceptual", formalDefinition="True if the actual variable measured, false if a conceptual representation of the intended variable." )
    protected BooleanType actual;

    /**
     * A defining factor of the EvidenceVariable. Multiple characteristics are applied with "and" semantics.
     */
    @Child(name = "characteristic", type = {}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A defining factor of the EvidenceVariable", formalDefinition="A defining factor of the EvidenceVariable. Multiple characteristics are applied with \"and\" semantics." )
    protected List<EvidenceVariableCharacteristicComponent> characteristic;

    /**
     * The method of handling in statistical analysis.
     */
    @Child(name = "handling", type = {CodeType.class}, order=26, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="continuous | dichotomous | ordinal | polychotomous", formalDefinition="The method of handling in statistical analysis." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/variable-handling")
    protected Enumeration<EvidenceVariableHandling> handling;

    /**
     * A grouping for ordinal or polychotomous variables.
     */
    @Child(name = "category", type = {}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A grouping for ordinal or polychotomous variables", formalDefinition="A grouping for ordinal or polychotomous variables." )
    protected List<EvidenceVariableCategoryComponent> category;

    private static final long serialVersionUID = -532650354L;

  /**
   * Constructor
   */
    public EvidenceVariable() {
      super();
    }

  /**
   * Constructor
   */
    public EvidenceVariable(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this evidence variable when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this evidence variable is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the evidence variable is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify this evidence variable when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this evidence variable is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the evidence variable is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public EvidenceVariable setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this evidence variable when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this evidence variable is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the evidence variable is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this evidence variable when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this evidence variable is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the evidence variable is stored on different servers.
     */
    public EvidenceVariable setUrl(String value) { 
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
     * @return {@link #identifier} (A formal identifier that is used to identify this evidence variable when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setIdentifier(List<Identifier> theIdentifier) { 
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

    public EvidenceVariable addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the evidence variable when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the evidence variable author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the evidence variable when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the evidence variable author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public EvidenceVariable setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the evidence variable when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the evidence variable author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the evidence variable when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the evidence variable author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.
     */
    public EvidenceVariable setVersion(String value) { 
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
     * @return {@link #name} (A natural language name identifying the evidence variable. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.name");
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
     * @param value {@link #name} (A natural language name identifying the evidence variable. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public EvidenceVariable setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the evidence variable. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the evidence variable. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public EvidenceVariable setName(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the evidence variable.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the evidence variable.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public EvidenceVariable setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the evidence variable.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the evidence variable.
     */
    public EvidenceVariable setTitle(String value) { 
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
     * @return {@link #shortTitle} (The short title provides an alternate title for use in informal descriptive contexts where the full, formal title is not necessary.). This is the underlying object with id, value and extensions. The accessor "getShortTitle" gives direct access to the value
     */
    public StringType getShortTitleElement() { 
      if (this.shortTitle == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.shortTitle");
        else if (Configuration.doAutoCreate())
          this.shortTitle = new StringType(); // bb
      return this.shortTitle;
    }

    public boolean hasShortTitleElement() { 
      return this.shortTitle != null && !this.shortTitle.isEmpty();
    }

    public boolean hasShortTitle() { 
      return this.shortTitle != null && !this.shortTitle.isEmpty();
    }

    /**
     * @param value {@link #shortTitle} (The short title provides an alternate title for use in informal descriptive contexts where the full, formal title is not necessary.). This is the underlying object with id, value and extensions. The accessor "getShortTitle" gives direct access to the value
     */
    public EvidenceVariable setShortTitleElement(StringType value) { 
      this.shortTitle = value;
      return this;
    }

    /**
     * @return The short title provides an alternate title for use in informal descriptive contexts where the full, formal title is not necessary.
     */
    public String getShortTitle() { 
      return this.shortTitle == null ? null : this.shortTitle.getValue();
    }

    /**
     * @param value The short title provides an alternate title for use in informal descriptive contexts where the full, formal title is not necessary.
     */
    public EvidenceVariable setShortTitle(String value) { 
      if (Utilities.noString(value))
        this.shortTitle = null;
      else {
        if (this.shortTitle == null)
          this.shortTitle = new StringType();
        this.shortTitle.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #subtitle} (An explanatory or alternate title for the EvidenceVariable giving additional information about its content.). This is the underlying object with id, value and extensions. The accessor "getSubtitle" gives direct access to the value
     */
    public StringType getSubtitleElement() { 
      if (this.subtitle == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.subtitle");
        else if (Configuration.doAutoCreate())
          this.subtitle = new StringType(); // bb
      return this.subtitle;
    }

    public boolean hasSubtitleElement() { 
      return this.subtitle != null && !this.subtitle.isEmpty();
    }

    public boolean hasSubtitle() { 
      return this.subtitle != null && !this.subtitle.isEmpty();
    }

    /**
     * @param value {@link #subtitle} (An explanatory or alternate title for the EvidenceVariable giving additional information about its content.). This is the underlying object with id, value and extensions. The accessor "getSubtitle" gives direct access to the value
     */
    public EvidenceVariable setSubtitleElement(StringType value) { 
      this.subtitle = value;
      return this;
    }

    /**
     * @return An explanatory or alternate title for the EvidenceVariable giving additional information about its content.
     */
    public String getSubtitle() { 
      return this.subtitle == null ? null : this.subtitle.getValue();
    }

    /**
     * @param value An explanatory or alternate title for the EvidenceVariable giving additional information about its content.
     */
    public EvidenceVariable setSubtitle(String value) { 
      if (Utilities.noString(value))
        this.subtitle = null;
      else {
        if (this.subtitle == null)
          this.subtitle = new StringType();
        this.subtitle.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #status} (The status of this evidence variable. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.status");
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
     * @param value {@link #status} (The status of this evidence variable. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public EvidenceVariable setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this evidence variable. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this evidence variable. Enables tracking the life-cycle of the content.
     */
    public EvidenceVariable setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.experimental");
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
     * @param value {@link #experimental} (A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public EvidenceVariable setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public EvidenceVariable setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the evidence variable was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence variable changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the evidence variable was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence variable changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public EvidenceVariable setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the evidence variable was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence variable changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the evidence variable was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence variable changes.
     */
    public EvidenceVariable setDate(Date value) { 
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
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the evidence variable.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.publisher");
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
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the evidence variable.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public EvidenceVariable setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the evidence variable.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the evidence variable.
     */
    public EvidenceVariable setPublisher(String value) { 
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
    public EvidenceVariable setContact(List<ContactDetail> theContact) { 
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

    public EvidenceVariable addContact(ContactDetail t) { //3
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
     * @return {@link #description} (A free text natural language description of the evidence variable from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.description");
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
     * @param value {@link #description} (A free text natural language description of the evidence variable from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public EvidenceVariable setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the evidence variable from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the evidence variable from a consumer's perspective.
     */
    public EvidenceVariable setDescription(String value) { 
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
     * @return {@link #note} (A human-readable string to clarify or explain concepts about the resource.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setNote(List<Annotation> theNote) { 
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

    public EvidenceVariable addNote(Annotation t) { //3
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence variable instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setUseContext(List<UsageContext> theUseContext) { 
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

    public EvidenceVariable addUseContext(UsageContext t) { //3
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
     * @return {@link #copyright} (A copyright statement relating to the resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the resource.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the resource.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public EvidenceVariable setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the resource.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the resource.
     */
    public EvidenceVariable setCopyright(String value) { 
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
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.approvalDate");
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
    public EvidenceVariable setApprovalDateElement(DateType value) { 
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
    public EvidenceVariable setApprovalDate(Date value) { 
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
          throw new Error("Attempt to auto-create EvidenceVariable.lastReviewDate");
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
    public EvidenceVariable setLastReviewDateElement(DateType value) { 
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
    public EvidenceVariable setLastReviewDate(Date value) { 
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
     * @return {@link #effectivePeriod} (The period during which the resource content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the resource content was or is planned to be in active use.)
     */
    public EvidenceVariable setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #author} (An individiual or organization primarily involved in the creation and maintenance of the content.)
     */
    public List<ContactDetail> getAuthor() { 
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      return this.author;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setAuthor(List<ContactDetail> theAuthor) { 
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

    public EvidenceVariable addAuthor(ContactDetail t) { //3
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
     * @return {@link #editor} (An individual or organization primarily responsible for internal coherence of the content.)
     */
    public List<ContactDetail> getEditor() { 
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      return this.editor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setEditor(List<ContactDetail> theEditor) { 
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

    public EvidenceVariable addEditor(ContactDetail t) { //3
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
     * @return {@link #reviewer} (An individual or organization primarily responsible for review of some aspect of the content.)
     */
    public List<ContactDetail> getReviewer() { 
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      return this.reviewer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setReviewer(List<ContactDetail> theReviewer) { 
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

    public EvidenceVariable addReviewer(ContactDetail t) { //3
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
     * @return {@link #endorser} (An individual or organization responsible for officially endorsing the content for use in some setting.)
     */
    public List<ContactDetail> getEndorser() { 
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      return this.endorser;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setEndorser(List<ContactDetail> theEndorser) { 
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

    public EvidenceVariable addEndorser(ContactDetail t) { //3
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
     * @return {@link #relatedArtifact} (Related artifacts such as additional documentation, justification, or bibliographic references.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      return this.relatedArtifact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
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

    public EvidenceVariable addRelatedArtifact(RelatedArtifact t) { //3
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
     * @return {@link #actual} (True if the actual variable measured, false if a conceptual representation of the intended variable.). This is the underlying object with id, value and extensions. The accessor "getActual" gives direct access to the value
     */
    public BooleanType getActualElement() { 
      if (this.actual == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.actual");
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
     * @param value {@link #actual} (True if the actual variable measured, false if a conceptual representation of the intended variable.). This is the underlying object with id, value and extensions. The accessor "getActual" gives direct access to the value
     */
    public EvidenceVariable setActualElement(BooleanType value) { 
      this.actual = value;
      return this;
    }

    /**
     * @return True if the actual variable measured, false if a conceptual representation of the intended variable.
     */
    public boolean getActual() { 
      return this.actual == null || this.actual.isEmpty() ? false : this.actual.getValue();
    }

    /**
     * @param value True if the actual variable measured, false if a conceptual representation of the intended variable.
     */
    public EvidenceVariable setActual(boolean value) { 
        if (this.actual == null)
          this.actual = new BooleanType();
        this.actual.setValue(value);
      return this;
    }

    /**
     * @return {@link #characteristic} (A defining factor of the EvidenceVariable. Multiple characteristics are applied with "and" semantics.)
     */
    public List<EvidenceVariableCharacteristicComponent> getCharacteristic() { 
      if (this.characteristic == null)
        this.characteristic = new ArrayList<EvidenceVariableCharacteristicComponent>();
      return this.characteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setCharacteristic(List<EvidenceVariableCharacteristicComponent> theCharacteristic) { 
      this.characteristic = theCharacteristic;
      return this;
    }

    public boolean hasCharacteristic() { 
      if (this.characteristic == null)
        return false;
      for (EvidenceVariableCharacteristicComponent item : this.characteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public EvidenceVariableCharacteristicComponent addCharacteristic() { //3
      EvidenceVariableCharacteristicComponent t = new EvidenceVariableCharacteristicComponent();
      if (this.characteristic == null)
        this.characteristic = new ArrayList<EvidenceVariableCharacteristicComponent>();
      this.characteristic.add(t);
      return t;
    }

    public EvidenceVariable addCharacteristic(EvidenceVariableCharacteristicComponent t) { //3
      if (t == null)
        return this;
      if (this.characteristic == null)
        this.characteristic = new ArrayList<EvidenceVariableCharacteristicComponent>();
      this.characteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #characteristic}, creating it if it does not already exist {3}
     */
    public EvidenceVariableCharacteristicComponent getCharacteristicFirstRep() { 
      if (getCharacteristic().isEmpty()) {
        addCharacteristic();
      }
      return getCharacteristic().get(0);
    }

    /**
     * @return {@link #handling} (The method of handling in statistical analysis.). This is the underlying object with id, value and extensions. The accessor "getHandling" gives direct access to the value
     */
    public Enumeration<EvidenceVariableHandling> getHandlingElement() { 
      if (this.handling == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EvidenceVariable.handling");
        else if (Configuration.doAutoCreate())
          this.handling = new Enumeration<EvidenceVariableHandling>(new EvidenceVariableHandlingEnumFactory()); // bb
      return this.handling;
    }

    public boolean hasHandlingElement() { 
      return this.handling != null && !this.handling.isEmpty();
    }

    public boolean hasHandling() { 
      return this.handling != null && !this.handling.isEmpty();
    }

    /**
     * @param value {@link #handling} (The method of handling in statistical analysis.). This is the underlying object with id, value and extensions. The accessor "getHandling" gives direct access to the value
     */
    public EvidenceVariable setHandlingElement(Enumeration<EvidenceVariableHandling> value) { 
      this.handling = value;
      return this;
    }

    /**
     * @return The method of handling in statistical analysis.
     */
    public EvidenceVariableHandling getHandling() { 
      return this.handling == null ? null : this.handling.getValue();
    }

    /**
     * @param value The method of handling in statistical analysis.
     */
    public EvidenceVariable setHandling(EvidenceVariableHandling value) { 
      if (value == null)
        this.handling = null;
      else {
        if (this.handling == null)
          this.handling = new Enumeration<EvidenceVariableHandling>(new EvidenceVariableHandlingEnumFactory());
        this.handling.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #category} (A grouping for ordinal or polychotomous variables.)
     */
    public List<EvidenceVariableCategoryComponent> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<EvidenceVariableCategoryComponent>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setCategory(List<EvidenceVariableCategoryComponent> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (EvidenceVariableCategoryComponent item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public EvidenceVariableCategoryComponent addCategory() { //3
      EvidenceVariableCategoryComponent t = new EvidenceVariableCategoryComponent();
      if (this.category == null)
        this.category = new ArrayList<EvidenceVariableCategoryComponent>();
      this.category.add(t);
      return t;
    }

    public EvidenceVariable addCategory(EvidenceVariableCategoryComponent t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<EvidenceVariableCategoryComponent>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public EvidenceVariableCategoryComponent getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getVersionAlgorithmMax() { 
      return 0;
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public DataType getVersionAlgorithm() { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public StringType getVersionAlgorithmStringType() { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    public boolean hasVersionAlgorithmStringType() { 
      return false;////K 
    }
    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public Coding getVersionAlgorithmCoding() { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"versionAlgorithm[x]\""); 
    }
    public boolean hasVersionAlgorithmCoding() { 
      return false;////K 
    }
    public boolean hasVersionAlgorithm() { 
      return false;
    }
    /**
     * @param value {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public EvidenceVariable setVersionAlgorithm(DataType value) { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"versionAlgorithm[x]\""); 
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getJurisdictionMax() { 
      return 0;
    }
    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the evidence variable is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setJurisdiction(List<CodeableConcept> theJurisdiction) { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"jurisdiction\""); 
    }
    public boolean hasJurisdiction() { 
      return false;
    }

    public CodeableConcept addJurisdiction() { //3
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"jurisdiction\""); 
    }
    public EvidenceVariable addJurisdiction(CodeableConcept t) { //3
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"jurisdiction\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {2}
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"jurisdiction\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getPurposeMax() { 
      return 0;
    }
    /**
     * @return {@link #purpose} (Explanation of why this evidence variable is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"purpose\"");
    }

    public boolean hasPurposeElement() { 
      return false;
    }
    public boolean hasPurpose() {
      return false;
    }

    /**
     * @param value {@link #purpose} (Explanation of why this evidence variable is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public EvidenceVariable setPurposeElement(MarkdownType value) { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"purpose\""); 
    }
    public String getPurpose() { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"purpose\""); 
    }
    /**
     * @param value Explanation of why this evidence variable is needed and why it has been designed as it has.
     */
    public EvidenceVariable setPurpose(String value) { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"purpose\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getCopyrightLabelMax() { 
      return 0;
    }
    /**
     * @return {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StringType getCopyrightLabelElement() { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"copyrightLabel\"");
    }

    public boolean hasCopyrightLabelElement() { 
      return false;
    }
    public boolean hasCopyrightLabel() {
      return false;
    }

    /**
     * @param value {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public EvidenceVariable setCopyrightLabelElement(StringType value) { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"copyrightLabel\""); 
    }
    public String getCopyrightLabel() { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"copyrightLabel\""); 
    }
    /**
     * @param value A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public EvidenceVariable setCopyrightLabel(String value) { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"copyrightLabel\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getTopicMax() { 
      return 0;
    }
    /**
     * @return {@link #topic} (Descriptive topics related to the content of the evidence variable. Topics provide a high-level categorization as well as keywords for the evidence variable that can be useful for filtering and searching.)
     */
    public List<CodeableConcept> getTopic() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EvidenceVariable setTopic(List<CodeableConcept> theTopic) { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"topic\""); 
    }
    public boolean hasTopic() { 
      return false;
    }

    public CodeableConcept addTopic() { //3
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"topic\""); 
    }
    public EvidenceVariable addTopic(CodeableConcept t) { //3
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"topic\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #topic}, creating it if it does not already exist {2}
     */
    public CodeableConcept getTopicFirstRep() { 
      throw new Error("The resource type \"EvidenceVariable\" does not implement the property \"topic\""); 
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this evidence variable when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this evidence variable is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the evidence variable is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this evidence variable when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the evidence variable when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the evidence variable author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.", 0, 1, version));
        children.add(new Property("name", "string", "A natural language name identifying the evidence variable. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the evidence variable.", 0, 1, title));
        children.add(new Property("shortTitle", "string", "The short title provides an alternate title for use in informal descriptive contexts where the full, formal title is not necessary.", 0, 1, shortTitle));
        children.add(new Property("subtitle", "string", "An explanatory or alternate title for the EvidenceVariable giving additional information about its content.", 0, 1, subtitle));
        children.add(new Property("status", "code", "The status of this evidence variable. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the evidence variable was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence variable changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the evidence variable.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the evidence variable from a consumer's perspective.", 0, 1, description));
        children.add(new Property("note", "Annotation", "A human-readable string to clarify or explain concepts about the resource.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence variable instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the resource.", 0, 1, copyright));
        children.add(new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the resource content was or is planned to be in active use.", 0, 1, effectivePeriod));
        children.add(new Property("author", "ContactDetail", "An individiual or organization primarily involved in the creation and maintenance of the content.", 0, java.lang.Integer.MAX_VALUE, author));
        children.add(new Property("editor", "ContactDetail", "An individual or organization primarily responsible for internal coherence of the content.", 0, java.lang.Integer.MAX_VALUE, editor));
        children.add(new Property("reviewer", "ContactDetail", "An individual or organization primarily responsible for review of some aspect of the content.", 0, java.lang.Integer.MAX_VALUE, reviewer));
        children.add(new Property("endorser", "ContactDetail", "An individual or organization responsible for officially endorsing the content for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Related artifacts such as additional documentation, justification, or bibliographic references.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
        children.add(new Property("actual", "boolean", "True if the actual variable measured, false if a conceptual representation of the intended variable.", 0, 1, actual));
        children.add(new Property("characteristic", "", "A defining factor of the EvidenceVariable. Multiple characteristics are applied with \"and\" semantics.", 0, java.lang.Integer.MAX_VALUE, characteristic));
        children.add(new Property("handling", "code", "The method of handling in statistical analysis.", 0, 1, handling));
        children.add(new Property("category", "", "A grouping for ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE, category));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this evidence variable when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this evidence variable is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the evidence variable is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this evidence variable when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the evidence variable when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the evidence variable author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.", 0, 1, version);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the evidence variable. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the evidence variable.", 0, 1, title);
        case 1555503932: /*shortTitle*/  return new Property("shortTitle", "string", "The short title provides an alternate title for use in informal descriptive contexts where the full, formal title is not necessary.", 0, 1, shortTitle);
        case -2060497896: /*subtitle*/  return new Property("subtitle", "string", "An explanatory or alternate title for the EvidenceVariable giving additional information about its content.", 0, 1, subtitle);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this evidence variable. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the evidence variable was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the evidence variable changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the evidence variable.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the evidence variable from a consumer's perspective.", 0, 1, description);
        case 3387378: /*note*/  return new Property("note", "Annotation", "A human-readable string to clarify or explain concepts about the resource.", 0, java.lang.Integer.MAX_VALUE, note);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence variable instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the resource and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the resource.", 0, 1, copyright);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the resource content was or is planned to be in active use.", 0, 1, effectivePeriod);
        case -1406328437: /*author*/  return new Property("author", "ContactDetail", "An individiual or organization primarily involved in the creation and maintenance of the content.", 0, java.lang.Integer.MAX_VALUE, author);
        case -1307827859: /*editor*/  return new Property("editor", "ContactDetail", "An individual or organization primarily responsible for internal coherence of the content.", 0, java.lang.Integer.MAX_VALUE, editor);
        case -261190139: /*reviewer*/  return new Property("reviewer", "ContactDetail", "An individual or organization primarily responsible for review of some aspect of the content.", 0, java.lang.Integer.MAX_VALUE, reviewer);
        case 1740277666: /*endorser*/  return new Property("endorser", "ContactDetail", "An individual or organization responsible for officially endorsing the content for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Related artifacts such as additional documentation, justification, or bibliographic references.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        case -1422939762: /*actual*/  return new Property("actual", "boolean", "True if the actual variable measured, false if a conceptual representation of the intended variable.", 0, 1, actual);
        case 366313883: /*characteristic*/  return new Property("characteristic", "", "A defining factor of the EvidenceVariable. Multiple characteristics are applied with \"and\" semantics.", 0, java.lang.Integer.MAX_VALUE, characteristic);
        case 2072805: /*handling*/  return new Property("handling", "code", "The method of handling in statistical analysis.", 0, 1, handling);
        case 50511102: /*category*/  return new Property("category", "", "A grouping for ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE, category);
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
        case 1555503932: /*shortTitle*/ return this.shortTitle == null ? new Base[0] : new Base[] {this.shortTitle}; // StringType
        case -2060497896: /*subtitle*/ return this.subtitle == null ? new Base[0] : new Base[] {this.subtitle}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // ContactDetail
        case -1307827859: /*editor*/ return this.editor == null ? new Base[0] : this.editor.toArray(new Base[this.editor.size()]); // ContactDetail
        case -261190139: /*reviewer*/ return this.reviewer == null ? new Base[0] : this.reviewer.toArray(new Base[this.reviewer.size()]); // ContactDetail
        case 1740277666: /*endorser*/ return this.endorser == null ? new Base[0] : this.endorser.toArray(new Base[this.endorser.size()]); // ContactDetail
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case -1422939762: /*actual*/ return this.actual == null ? new Base[0] : new Base[] {this.actual}; // BooleanType
        case 366313883: /*characteristic*/ return this.characteristic == null ? new Base[0] : this.characteristic.toArray(new Base[this.characteristic.size()]); // EvidenceVariableCharacteristicComponent
        case 2072805: /*handling*/ return this.handling == null ? new Base[0] : new Base[] {this.handling}; // Enumeration<EvidenceVariableHandling>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // EvidenceVariableCategoryComponent
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
        case 1555503932: // shortTitle
          this.shortTitle = TypeConvertor.castToString(value); // StringType
          return value;
        case -2060497896: // subtitle
          this.subtitle = TypeConvertor.castToString(value); // StringType
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
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
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
        case -1422939762: // actual
          this.actual = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 366313883: // characteristic
          this.getCharacteristic().add((EvidenceVariableCharacteristicComponent) value); // EvidenceVariableCharacteristicComponent
          return value;
        case 2072805: // handling
          value = new EvidenceVariableHandlingEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.handling = (Enumeration) value; // Enumeration<EvidenceVariableHandling>
          return value;
        case 50511102: // category
          this.getCategory().add((EvidenceVariableCategoryComponent) value); // EvidenceVariableCategoryComponent
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
        } else if (name.equals("shortTitle")) {
          this.shortTitle = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("subtitle")) {
          this.subtitle = TypeConvertor.castToString(value); // StringType
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
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("approvalDate")) {
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
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
        } else if (name.equals("actual")) {
          this.actual = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("characteristic")) {
          this.getCharacteristic().add((EvidenceVariableCharacteristicComponent) value);
        } else if (name.equals("handling")) {
          value = new EvidenceVariableHandlingEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.handling = (Enumeration) value; // Enumeration<EvidenceVariableHandling>
        } else if (name.equals("category")) {
          this.getCategory().add((EvidenceVariableCategoryComponent) value);
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
        case 1555503932:  return getShortTitleElement();
        case -2060497896:  return getSubtitleElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case 3387378:  return addNote(); 
        case -669707736:  return addUseContext(); 
        case 1522889671:  return getCopyrightElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -403934648:  return getEffectivePeriod();
        case -1406328437:  return addAuthor(); 
        case -1307827859:  return addEditor(); 
        case -261190139:  return addReviewer(); 
        case 1740277666:  return addEndorser(); 
        case 666807069:  return addRelatedArtifact(); 
        case -1422939762:  return getActualElement();
        case 366313883:  return addCharacteristic(); 
        case 2072805:  return getHandlingElement();
        case 50511102:  return addCategory(); 
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
        case 1555503932: /*shortTitle*/ return new String[] {"string"};
        case -2060497896: /*subtitle*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case -1406328437: /*author*/ return new String[] {"ContactDetail"};
        case -1307827859: /*editor*/ return new String[] {"ContactDetail"};
        case -261190139: /*reviewer*/ return new String[] {"ContactDetail"};
        case 1740277666: /*endorser*/ return new String[] {"ContactDetail"};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case -1422939762: /*actual*/ return new String[] {"boolean"};
        case 366313883: /*characteristic*/ return new String[] {};
        case 2072805: /*handling*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.version");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.title");
        }
        else if (name.equals("shortTitle")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.shortTitle");
        }
        else if (name.equals("subtitle")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.subtitle");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.description");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.copyright");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
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
        else if (name.equals("actual")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.actual");
        }
        else if (name.equals("characteristic")) {
          return addCharacteristic();
        }
        else if (name.equals("handling")) {
          throw new FHIRException("Cannot call addChild on a primitive type EvidenceVariable.handling");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "EvidenceVariable";

  }

      public EvidenceVariable copy() {
        EvidenceVariable dst = new EvidenceVariable();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceVariable dst) {
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
        dst.shortTitle = shortTitle == null ? null : shortTitle.copy();
        dst.subtitle = subtitle == null ? null : subtitle.copy();
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
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
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
        dst.actual = actual == null ? null : actual.copy();
        if (characteristic != null) {
          dst.characteristic = new ArrayList<EvidenceVariableCharacteristicComponent>();
          for (EvidenceVariableCharacteristicComponent i : characteristic)
            dst.characteristic.add(i.copy());
        };
        dst.handling = handling == null ? null : handling.copy();
        if (category != null) {
          dst.category = new ArrayList<EvidenceVariableCategoryComponent>();
          for (EvidenceVariableCategoryComponent i : category)
            dst.category.add(i.copy());
        };
      }

      protected EvidenceVariable typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceVariable))
          return false;
        EvidenceVariable o = (EvidenceVariable) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(name, o.name, true) && compareDeep(title, o.title, true) && compareDeep(shortTitle, o.shortTitle, true)
           && compareDeep(subtitle, o.subtitle, true) && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true)
           && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true)
           && compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(copyright, o.copyright, true) && compareDeep(approvalDate, o.approvalDate, true)
           && compareDeep(lastReviewDate, o.lastReviewDate, true) && compareDeep(effectivePeriod, o.effectivePeriod, true)
           && compareDeep(author, o.author, true) && compareDeep(editor, o.editor, true) && compareDeep(reviewer, o.reviewer, true)
           && compareDeep(endorser, o.endorser, true) && compareDeep(relatedArtifact, o.relatedArtifact, true)
           && compareDeep(actual, o.actual, true) && compareDeep(characteristic, o.characteristic, true) && compareDeep(handling, o.handling, true)
           && compareDeep(category, o.category, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceVariable))
          return false;
        EvidenceVariable o = (EvidenceVariable) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(shortTitle, o.shortTitle, true) && compareValues(subtitle, o.subtitle, true)
           && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true) && compareValues(date, o.date, true)
           && compareValues(publisher, o.publisher, true) && compareValues(description, o.description, true) && compareValues(copyright, o.copyright, true)
           && compareValues(approvalDate, o.approvalDate, true) && compareValues(lastReviewDate, o.lastReviewDate, true)
           && compareValues(actual, o.actual, true) && compareValues(handling, o.handling, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , name, title, shortTitle, subtitle, status, experimental, date, publisher, contact
          , description, note, useContext, copyright, approvalDate, lastReviewDate, effectivePeriod
          , author, editor, reviewer, endorser, relatedArtifact, actual, characteristic
          , handling, category);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.EvidenceVariable;
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
   * Path: <b>(ActivityDefinition.useContext.value as Quantity) | (ActivityDefinition.useContext.value as Range) | (ActorDefinition.useContext.value as Quantity) | (ActorDefinition.useContext.value as Range) | (CapabilityStatement.useContext.value as Quantity) | (CapabilityStatement.useContext.value as Range) | (ChargeItemDefinition.useContext.value as Quantity) | (ChargeItemDefinition.useContext.value as Range) | (Citation.useContext.value as Quantity) | (Citation.useContext.value as Range) | (CodeSystem.useContext.value as Quantity) | (CodeSystem.useContext.value as Range) | (CompartmentDefinition.useContext.value as Quantity) | (CompartmentDefinition.useContext.value as Range) | (ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range) | (ConditionDefinition.useContext.value as Quantity) | (ConditionDefinition.useContext.value as Range) | (EventDefinition.useContext.value as Quantity) | (EventDefinition.useContext.value as Range) | (Evidence.useContext.value as Quantity) | (Evidence.useContext.value as Range) | (EvidenceReport.useContext.value as Quantity) | (EvidenceReport.useContext.value as Range) | (EvidenceVariable.useContext.value as Quantity) | (EvidenceVariable.useContext.value as Range) | (ExampleScenario.useContext.value as Quantity) | (ExampleScenario.useContext.value as Range) | (GraphDefinition.useContext.value as Quantity) | (GraphDefinition.useContext.value as Range) | (ImplementationGuide.useContext.value as Quantity) | (ImplementationGuide.useContext.value as Range) | (Library.useContext.value as Quantity) | (Library.useContext.value as Range) | (Measure.useContext.value as Quantity) | (Measure.useContext.value as Range) | (MessageDefinition.useContext.value as Quantity) | (MessageDefinition.useContext.value as Range) | (NamingSystem.useContext.value as Quantity) | (NamingSystem.useContext.value as Range) | (OperationDefinition.useContext.value as Quantity) | (OperationDefinition.useContext.value as Range) | (PlanDefinition.useContext.value as Quantity) | (PlanDefinition.useContext.value as Range) | (Questionnaire.useContext.value as Quantity) | (Questionnaire.useContext.value as Range) | (Requirements.useContext.value as Quantity) | (Requirements.useContext.value as Range) | (SearchParameter.useContext.value as Quantity) | (SearchParameter.useContext.value as Range) | (StructureDefinition.useContext.value as Quantity) | (StructureDefinition.useContext.value as Range) | (StructureMap.useContext.value as Quantity) | (StructureMap.useContext.value as Range) | (TerminologyCapabilities.useContext.value as Quantity) | (TerminologyCapabilities.useContext.value as Range) | (TestScript.useContext.value as Quantity) | (TestScript.useContext.value as Range) | (ValueSet.useContext.value as Quantity) | (ValueSet.useContext.value as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(ActivityDefinition.useContext.value as Quantity) | (ActivityDefinition.useContext.value as Range) | (ActorDefinition.useContext.value as Quantity) | (ActorDefinition.useContext.value as Range) | (CapabilityStatement.useContext.value as Quantity) | (CapabilityStatement.useContext.value as Range) | (ChargeItemDefinition.useContext.value as Quantity) | (ChargeItemDefinition.useContext.value as Range) | (Citation.useContext.value as Quantity) | (Citation.useContext.value as Range) | (CodeSystem.useContext.value as Quantity) | (CodeSystem.useContext.value as Range) | (CompartmentDefinition.useContext.value as Quantity) | (CompartmentDefinition.useContext.value as Range) | (ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range) | (ConditionDefinition.useContext.value as Quantity) | (ConditionDefinition.useContext.value as Range) | (EventDefinition.useContext.value as Quantity) | (EventDefinition.useContext.value as Range) | (Evidence.useContext.value as Quantity) | (Evidence.useContext.value as Range) | (EvidenceReport.useContext.value as Quantity) | (EvidenceReport.useContext.value as Range) | (EvidenceVariable.useContext.value as Quantity) | (EvidenceVariable.useContext.value as Range) | (ExampleScenario.useContext.value as Quantity) | (ExampleScenario.useContext.value as Range) | (GraphDefinition.useContext.value as Quantity) | (GraphDefinition.useContext.value as Range) | (ImplementationGuide.useContext.value as Quantity) | (ImplementationGuide.useContext.value as Range) | (Library.useContext.value as Quantity) | (Library.useContext.value as Range) | (Measure.useContext.value as Quantity) | (Measure.useContext.value as Range) | (MessageDefinition.useContext.value as Quantity) | (MessageDefinition.useContext.value as Range) | (NamingSystem.useContext.value as Quantity) | (NamingSystem.useContext.value as Range) | (OperationDefinition.useContext.value as Quantity) | (OperationDefinition.useContext.value as Range) | (PlanDefinition.useContext.value as Quantity) | (PlanDefinition.useContext.value as Range) | (Questionnaire.useContext.value as Quantity) | (Questionnaire.useContext.value as Range) | (Requirements.useContext.value as Quantity) | (Requirements.useContext.value as Range) | (SearchParameter.useContext.value as Quantity) | (SearchParameter.useContext.value as Range) | (StructureDefinition.useContext.value as Quantity) | (StructureDefinition.useContext.value as Range) | (StructureMap.useContext.value as Quantity) | (StructureMap.useContext.value as Range) | (TerminologyCapabilities.useContext.value as Quantity) | (TerminologyCapabilities.useContext.value as Range) | (TestScript.useContext.value as Quantity) | (TestScript.useContext.value as Range) | (ValueSet.useContext.value as Quantity) | (ValueSet.useContext.value as Range)", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition\r\n* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition\r\n* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide\r\n* [Library](library.html): A quantity- or range-valued use context assigned to the library\r\n* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script\r\n* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set\r\n", type="quantity" )
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
   * Path: <b>(ActivityDefinition.useContext.value as Quantity) | (ActivityDefinition.useContext.value as Range) | (ActorDefinition.useContext.value as Quantity) | (ActorDefinition.useContext.value as Range) | (CapabilityStatement.useContext.value as Quantity) | (CapabilityStatement.useContext.value as Range) | (ChargeItemDefinition.useContext.value as Quantity) | (ChargeItemDefinition.useContext.value as Range) | (Citation.useContext.value as Quantity) | (Citation.useContext.value as Range) | (CodeSystem.useContext.value as Quantity) | (CodeSystem.useContext.value as Range) | (CompartmentDefinition.useContext.value as Quantity) | (CompartmentDefinition.useContext.value as Range) | (ConceptMap.useContext.value as Quantity) | (ConceptMap.useContext.value as Range) | (ConditionDefinition.useContext.value as Quantity) | (ConditionDefinition.useContext.value as Range) | (EventDefinition.useContext.value as Quantity) | (EventDefinition.useContext.value as Range) | (Evidence.useContext.value as Quantity) | (Evidence.useContext.value as Range) | (EvidenceReport.useContext.value as Quantity) | (EvidenceReport.useContext.value as Range) | (EvidenceVariable.useContext.value as Quantity) | (EvidenceVariable.useContext.value as Range) | (ExampleScenario.useContext.value as Quantity) | (ExampleScenario.useContext.value as Range) | (GraphDefinition.useContext.value as Quantity) | (GraphDefinition.useContext.value as Range) | (ImplementationGuide.useContext.value as Quantity) | (ImplementationGuide.useContext.value as Range) | (Library.useContext.value as Quantity) | (Library.useContext.value as Range) | (Measure.useContext.value as Quantity) | (Measure.useContext.value as Range) | (MessageDefinition.useContext.value as Quantity) | (MessageDefinition.useContext.value as Range) | (NamingSystem.useContext.value as Quantity) | (NamingSystem.useContext.value as Range) | (OperationDefinition.useContext.value as Quantity) | (OperationDefinition.useContext.value as Range) | (PlanDefinition.useContext.value as Quantity) | (PlanDefinition.useContext.value as Range) | (Questionnaire.useContext.value as Quantity) | (Questionnaire.useContext.value as Range) | (Requirements.useContext.value as Quantity) | (Requirements.useContext.value as Range) | (SearchParameter.useContext.value as Quantity) | (SearchParameter.useContext.value as Range) | (StructureDefinition.useContext.value as Quantity) | (StructureDefinition.useContext.value as Range) | (StructureMap.useContext.value as Quantity) | (StructureMap.useContext.value as Range) | (TerminologyCapabilities.useContext.value as Quantity) | (TerminologyCapabilities.useContext.value as Range) | (TestScript.useContext.value as Quantity) | (TestScript.useContext.value as Range) | (ValueSet.useContext.value as Quantity) | (ValueSet.useContext.value as Range)</b><br>
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
   * Path: <b>(ActivityDefinition.useContext.value as CodeableConcept) | (ActorDefinition.useContext.value as CodeableConcept) | (CapabilityStatement.useContext.value as CodeableConcept) | (ChargeItemDefinition.useContext.value as CodeableConcept) | (Citation.useContext.value as CodeableConcept) | (CodeSystem.useContext.value as CodeableConcept) | (CompartmentDefinition.useContext.value as CodeableConcept) | (ConceptMap.useContext.value as CodeableConcept) | (ConditionDefinition.useContext.value as CodeableConcept) | (EventDefinition.useContext.value as CodeableConcept) | (Evidence.useContext.value as CodeableConcept) | (EvidenceReport.useContext.value as CodeableConcept) | (EvidenceVariable.useContext.value as CodeableConcept) | (ExampleScenario.useContext.value as CodeableConcept) | (GraphDefinition.useContext.value as CodeableConcept) | (ImplementationGuide.useContext.value as CodeableConcept) | (Library.useContext.value as CodeableConcept) | (Measure.useContext.value as CodeableConcept) | (MessageDefinition.useContext.value as CodeableConcept) | (NamingSystem.useContext.value as CodeableConcept) | (OperationDefinition.useContext.value as CodeableConcept) | (PlanDefinition.useContext.value as CodeableConcept) | (Questionnaire.useContext.value as CodeableConcept) | (Requirements.useContext.value as CodeableConcept) | (SearchParameter.useContext.value as CodeableConcept) | (StructureDefinition.useContext.value as CodeableConcept) | (StructureMap.useContext.value as CodeableConcept) | (TerminologyCapabilities.useContext.value as CodeableConcept) | (TestScript.useContext.value as CodeableConcept) | (ValueSet.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(ActivityDefinition.useContext.value as CodeableConcept) | (ActorDefinition.useContext.value as CodeableConcept) | (CapabilityStatement.useContext.value as CodeableConcept) | (ChargeItemDefinition.useContext.value as CodeableConcept) | (Citation.useContext.value as CodeableConcept) | (CodeSystem.useContext.value as CodeableConcept) | (CompartmentDefinition.useContext.value as CodeableConcept) | (ConceptMap.useContext.value as CodeableConcept) | (ConditionDefinition.useContext.value as CodeableConcept) | (EventDefinition.useContext.value as CodeableConcept) | (Evidence.useContext.value as CodeableConcept) | (EvidenceReport.useContext.value as CodeableConcept) | (EvidenceVariable.useContext.value as CodeableConcept) | (ExampleScenario.useContext.value as CodeableConcept) | (GraphDefinition.useContext.value as CodeableConcept) | (ImplementationGuide.useContext.value as CodeableConcept) | (Library.useContext.value as CodeableConcept) | (Measure.useContext.value as CodeableConcept) | (MessageDefinition.useContext.value as CodeableConcept) | (NamingSystem.useContext.value as CodeableConcept) | (OperationDefinition.useContext.value as CodeableConcept) | (PlanDefinition.useContext.value as CodeableConcept) | (Questionnaire.useContext.value as CodeableConcept) | (Requirements.useContext.value as CodeableConcept) | (SearchParameter.useContext.value as CodeableConcept) | (StructureDefinition.useContext.value as CodeableConcept) | (StructureMap.useContext.value as CodeableConcept) | (TerminologyCapabilities.useContext.value as CodeableConcept) | (TestScript.useContext.value as CodeableConcept) | (ValueSet.useContext.value as CodeableConcept)", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition\r\n* [Citation](citation.html): A use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context assigned to the event definition\r\n* [Evidence](evidence.html): A use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide\r\n* [Library](library.html): A use context assigned to the library\r\n* [Measure](measure.html): A use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context assigned to the test script\r\n* [ValueSet](valueset.html): A use context assigned to the value set\r\n", type="token" )
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
   * Path: <b>(ActivityDefinition.useContext.value as CodeableConcept) | (ActorDefinition.useContext.value as CodeableConcept) | (CapabilityStatement.useContext.value as CodeableConcept) | (ChargeItemDefinition.useContext.value as CodeableConcept) | (Citation.useContext.value as CodeableConcept) | (CodeSystem.useContext.value as CodeableConcept) | (CompartmentDefinition.useContext.value as CodeableConcept) | (ConceptMap.useContext.value as CodeableConcept) | (ConditionDefinition.useContext.value as CodeableConcept) | (EventDefinition.useContext.value as CodeableConcept) | (Evidence.useContext.value as CodeableConcept) | (EvidenceReport.useContext.value as CodeableConcept) | (EvidenceVariable.useContext.value as CodeableConcept) | (ExampleScenario.useContext.value as CodeableConcept) | (GraphDefinition.useContext.value as CodeableConcept) | (ImplementationGuide.useContext.value as CodeableConcept) | (Library.useContext.value as CodeableConcept) | (Measure.useContext.value as CodeableConcept) | (MessageDefinition.useContext.value as CodeableConcept) | (NamingSystem.useContext.value as CodeableConcept) | (OperationDefinition.useContext.value as CodeableConcept) | (PlanDefinition.useContext.value as CodeableConcept) | (Questionnaire.useContext.value as CodeableConcept) | (Requirements.useContext.value as CodeableConcept) | (SearchParameter.useContext.value as CodeableConcept) | (StructureDefinition.useContext.value as CodeableConcept) | (StructureMap.useContext.value as CodeableConcept) | (TerminologyCapabilities.useContext.value as CodeableConcept) | (TestScript.useContext.value as CodeableConcept) | (ValueSet.useContext.value as CodeableConcept)</b><br>
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
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ActivityDefinition.identifier | ActorDefinition.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition\r\n* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition\r\n* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition\r\n* [Citation](citation.html): External identifier for the citation\r\n* [CodeSystem](codesystem.html): External identifier for the code system\r\n* [ConceptMap](conceptmap.html): External identifier for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition\r\n* [EventDefinition](eventdefinition.html): External identifier for the event definition\r\n* [Evidence](evidence.html): External identifier for the evidence\r\n* [EvidenceReport](evidencereport.html): External identifier for the evidence report\r\n* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable\r\n* [ExampleScenario](examplescenario.html): External identifier for the example scenario\r\n* [Library](library.html): External identifier for the library\r\n* [Measure](measure.html): External identifier for the measure\r\n* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication\r\n* [MessageDefinition](messagedefinition.html): External identifier for the message definition\r\n* [NamingSystem](namingsystem.html): External identifier for the naming system\r\n* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition\r\n* [PlanDefinition](plandefinition.html): External identifier for the plan definition\r\n* [Questionnaire](questionnaire.html): External identifier for the questionnaire\r\n* [Requirements](requirements.html): External identifier for the requirements\r\n* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): External identifier for the structure definition\r\n* [StructureMap](structuremap.html): External identifier for the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities\r\n* [TestScript](testscript.html): External identifier for the test script\r\n* [ValueSet](valueset.html): External identifier for the value set\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
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
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

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
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestScript.status | ValueSet.status", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The current status of the activity definition\r\n* [ActorDefinition](actordefinition.html): The current status of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition\r\n* [Citation](citation.html): The current status of the citation\r\n* [CodeSystem](codesystem.html): The current status of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition\r\n* [ConceptMap](conceptmap.html): The current status of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition\r\n* [EventDefinition](eventdefinition.html): The current status of the event definition\r\n* [Evidence](evidence.html): The current status of the evidence\r\n* [EvidenceReport](evidencereport.html): The current status of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The current status of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The current status of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The current status of the implementation guide\r\n* [Library](library.html): The current status of the library\r\n* [Measure](measure.html): The current status of the measure\r\n* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error\r\n* [MessageDefinition](messagedefinition.html): The current status of the message definition\r\n* [NamingSystem](namingsystem.html): The current status of the naming system\r\n* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown\r\n* [OperationDefinition](operationdefinition.html): The current status of the operation definition\r\n* [PlanDefinition](plandefinition.html): The current status of the plan definition\r\n* [Questionnaire](questionnaire.html): The current status of the questionnaire\r\n* [Requirements](requirements.html): The current status of the requirements\r\n* [SearchParameter](searchparameter.html): The current status of the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown\r\n* [StructureDefinition](structuredefinition.html): The current status of the structure definition\r\n* [StructureMap](structuremap.html): The current status of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown\r\n* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities\r\n* [TestScript](testscript.html): The current status of the test script\r\n* [ValueSet](valueset.html): The current status of the value set\r\n", type="token" )
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
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition
* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition
* [Citation](citation.html): The human-friendly name of the citation
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition
* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition
* [Evidence](evidence.html): The human-friendly name of the evidence
* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [Library](library.html): The human-friendly name of the library
* [Measure](measure.html): The human-friendly name of the measure
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition
* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire
* [Requirements](requirements.html): The human-friendly name of the requirements
* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [TestScript](testscript.html): The human-friendly name of the test script
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition\r\n* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition\r\n* [Citation](citation.html): The human-friendly name of the citation\r\n* [CodeSystem](codesystem.html): The human-friendly name of the code system\r\n* [ConceptMap](conceptmap.html): The human-friendly name of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition\r\n* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition\r\n* [Evidence](evidence.html): The human-friendly name of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable\r\n* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide\r\n* [Library](library.html): The human-friendly name of the library\r\n* [Measure](measure.html): The human-friendly name of the measure\r\n* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition\r\n* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition\r\n* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition\r\n* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition\r\n* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire\r\n* [Requirements](requirements.html): The human-friendly name of the requirements\r\n* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition\r\n* [StructureMap](structuremap.html): The human-friendly name of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities\r\n* [TestScript](testscript.html): The human-friendly name of the test script\r\n* [ValueSet](valueset.html): The human-friendly name of the value set\r\n", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition
* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition
* [Citation](citation.html): The human-friendly name of the citation
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition
* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition
* [Evidence](evidence.html): The human-friendly name of the evidence
* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [Library](library.html): The human-friendly name of the library
* [Measure](measure.html): The human-friendly name of the measure
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition
* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire
* [Requirements](requirements.html): The human-friendly name of the requirements
* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [TestScript](testscript.html): The human-friendly name of the test script
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

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
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestScript.url | ValueSet.url", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition\r\n* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition\r\n* [Citation](citation.html): The uri that identifies the citation\r\n* [CodeSystem](codesystem.html): The uri that identifies the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition\r\n* [ConceptMap](conceptmap.html): The URI that identifies the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition\r\n* [EventDefinition](eventdefinition.html): The uri that identifies the event definition\r\n* [Evidence](evidence.html): The uri that identifies the evidence\r\n* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable\r\n* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario\r\n* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition\r\n* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide\r\n* [Library](library.html): The uri that identifies the library\r\n* [Measure](measure.html): The uri that identifies the measure\r\n* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition\r\n* [NamingSystem](namingsystem.html): The uri that identifies the naming system\r\n* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition\r\n* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition\r\n* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition\r\n* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire\r\n* [Requirements](requirements.html): The uri that identifies the requirements\r\n* [SearchParameter](searchparameter.html): The uri that identifies the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition\r\n* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition\r\n* [StructureMap](structuremap.html): The uri that identifies the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities\r\n* [TestScript](testscript.html): The uri that identifies the test script\r\n* [ValueSet](valueset.html): The uri that identifies the value set\r\n", type="uri" )
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
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestScript.url | ValueSet.url</b><br>
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
   * Search parameter: <b>composed-of</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='composed-of').resource | EventDefinition.relatedArtifact.where(type='composed-of').resource | EvidenceVariable.relatedArtifact.where(type='composed-of').resource | Library.relatedArtifact.where(type='composed-of').resource | Measure.relatedArtifact.where(type='composed-of').resource | PlanDefinition.relatedArtifact.where(type='composed-of').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="composed-of", path="ActivityDefinition.relatedArtifact.where(type='composed-of').resource | EventDefinition.relatedArtifact.where(type='composed-of').resource | EvidenceVariable.relatedArtifact.where(type='composed-of').resource | Library.relatedArtifact.where(type='composed-of').resource | Measure.relatedArtifact.where(type='composed-of').resource | PlanDefinition.relatedArtifact.where(type='composed-of').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_COMPOSED_OF = "composed-of";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>composed-of</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='composed-of').resource | EventDefinition.relatedArtifact.where(type='composed-of').resource | EvidenceVariable.relatedArtifact.where(type='composed-of').resource | Library.relatedArtifact.where(type='composed-of').resource | Measure.relatedArtifact.where(type='composed-of').resource | PlanDefinition.relatedArtifact.where(type='composed-of').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam COMPOSED_OF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_COMPOSED_OF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>EvidenceVariable:composed-of</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_COMPOSED_OF = new ca.uhn.fhir.model.api.Include("EvidenceVariable:composed-of").toLocked();

 /**
   * Search parameter: <b>depends-on</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='depends-on').resource | ActivityDefinition.library | EventDefinition.relatedArtifact.where(type='depends-on').resource | EvidenceVariable.relatedArtifact.where(type='depends-on').resource | Library.relatedArtifact.where(type='depends-on').resource | Measure.relatedArtifact.where(type='depends-on').resource | Measure.library | PlanDefinition.relatedArtifact.where(type='depends-on').resource | PlanDefinition.library</b><br>
   * </p>
   */
  @SearchParamDefinition(name="depends-on", path="ActivityDefinition.relatedArtifact.where(type='depends-on').resource | ActivityDefinition.library | EventDefinition.relatedArtifact.where(type='depends-on').resource | EvidenceVariable.relatedArtifact.where(type='depends-on').resource | Library.relatedArtifact.where(type='depends-on').resource | Measure.relatedArtifact.where(type='depends-on').resource | Measure.library | PlanDefinition.relatedArtifact.where(type='depends-on').resource | PlanDefinition.library", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_DEPENDS_ON = "depends-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>depends-on</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='depends-on').resource | ActivityDefinition.library | EventDefinition.relatedArtifact.where(type='depends-on').resource | EvidenceVariable.relatedArtifact.where(type='depends-on').resource | Library.relatedArtifact.where(type='depends-on').resource | Measure.relatedArtifact.where(type='depends-on').resource | Measure.library | PlanDefinition.relatedArtifact.where(type='depends-on').resource | PlanDefinition.library</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DEPENDS_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DEPENDS_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>EvidenceVariable:depends-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DEPENDS_ON = new ca.uhn.fhir.model.api.Include("EvidenceVariable:depends-on").toLocked();

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
  @SearchParamDefinition(name="derived-from", path="ActivityDefinition.relatedArtifact.where(type='derived-from').resource | CodeSystem.relatedArtifact.where(type='derived-from').resource | ConceptMap.relatedArtifact.where(type='derived-from').resource | EventDefinition.relatedArtifact.where(type='derived-from').resource | EvidenceVariable.relatedArtifact.where(type='derived-from').resource | Library.relatedArtifact.where(type='derived-from').resource | Measure.relatedArtifact.where(type='derived-from').resource | NamingSystem.relatedArtifact.where(type='derived-from').resource | PlanDefinition.relatedArtifact.where(type='derived-from').resource | ValueSet.relatedArtifact.where(type='derived-from').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [CodeSystem](codesystem.html): A resource that the CodeSystem is derived from\r\n* [ConceptMap](conceptmap.html): A resource that the ConceptMap is derived from\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [NamingSystem](namingsystem.html): A resource that the NamingSystem is derived from\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n* [ValueSet](valueset.html): A resource that the ValueSet is derived from\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
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
   * the path value of "<b>EvidenceVariable:derived-from</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DERIVED_FROM = new ca.uhn.fhir.model.api.Include("EvidenceVariable:derived-from").toLocked();

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
  @SearchParamDefinition(name="predecessor", path="ActivityDefinition.relatedArtifact.where(type='predecessor').resource | CodeSystem.relatedArtifact.where(type='predecessor').resource | ConceptMap.relatedArtifact.where(type='predecessor').resource | EventDefinition.relatedArtifact.where(type='predecessor').resource | EvidenceVariable.relatedArtifact.where(type='predecessor').resource | Library.relatedArtifact.where(type='predecessor').resource | Measure.relatedArtifact.where(type='predecessor').resource | NamingSystem.relatedArtifact.where(type='predecessor').resource | PlanDefinition.relatedArtifact.where(type='predecessor').resource | ValueSet.relatedArtifact.where(type='predecessor').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [CodeSystem](codesystem.html): The predecessor of the CodeSystem\r\n* [ConceptMap](conceptmap.html): The predecessor of the ConceptMap\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [NamingSystem](namingsystem.html): The predecessor of the NamingSystem\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n* [ValueSet](valueset.html): The predecessor of the ValueSet\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
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
   * the path value of "<b>EvidenceVariable:predecessor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PREDECESSOR = new ca.uhn.fhir.model.api.Include("EvidenceVariable:predecessor").toLocked();

 /**
   * Search parameter: <b>successor</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='successor').resource | EventDefinition.relatedArtifact.where(type='successor').resource | EvidenceVariable.relatedArtifact.where(type='successor').resource | Library.relatedArtifact.where(type='successor').resource | Measure.relatedArtifact.where(type='successor').resource | PlanDefinition.relatedArtifact.where(type='successor').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="successor", path="ActivityDefinition.relatedArtifact.where(type='successor').resource | EventDefinition.relatedArtifact.where(type='successor').resource | EvidenceVariable.relatedArtifact.where(type='successor').resource | Library.relatedArtifact.where(type='successor').resource | Measure.relatedArtifact.where(type='successor').resource | PlanDefinition.relatedArtifact.where(type='successor').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentManifest.class, DocumentReference.class, Encounter.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationUsage.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_SUCCESSOR = "successor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>successor</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='successor').resource | EventDefinition.relatedArtifact.where(type='successor').resource | EvidenceVariable.relatedArtifact.where(type='successor').resource | Library.relatedArtifact.where(type='successor').resource | Measure.relatedArtifact.where(type='successor').resource | PlanDefinition.relatedArtifact.where(type='successor').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUCCESSOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUCCESSOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>EvidenceVariable:successor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUCCESSOR = new ca.uhn.fhir.model.api.Include("EvidenceVariable:successor").toLocked();

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


}
