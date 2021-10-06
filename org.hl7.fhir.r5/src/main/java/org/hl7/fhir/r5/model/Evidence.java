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

// Generated on Tue, May 4, 2021 07:17+1000 for FHIR v4.6.0

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
 * The Evidence Resource provides a machine-interpretable expression of an evidence concept including the evidence variables (eg population, exposures/interventions, comparators, outcomes, measured variables, confounding variables), the statistics, and the certainty of this evidence.
 */
@ResourceDef(name="Evidence", profile="http://hl7.org/fhir/StructureDefinition/Evidence")
public class Evidence extends MetadataResource {

    @Block()
    public static class EvidenceVariableDefinitionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A text description or summary of the variable.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A text description or summary of the variable", formalDefinition="A text description or summary of the variable." )
        protected MarkdownType description;

        /**
         * Footnotes and/or explanatory notes.
         */
        @Child(name = "note", type = {Annotation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Footnotes and/or explanatory notes", formalDefinition="Footnotes and/or explanatory notes." )
        protected List<Annotation> note;

        /**
         * population | subpopulation | exposure | referenceExposure | measuredVariable | confounder.
         */
        @Child(name = "variableRole", type = {CodeableConcept.class}, order=3, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="population | subpopulation | exposure | referenceExposure | measuredVariable | confounder", formalDefinition="population | subpopulation | exposure | referenceExposure | measuredVariable | confounder." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/variable-role")
        protected CodeableConcept variableRole;

        /**
         * Definition of the actual variable related to the statistic(s).
         */
        @Child(name = "observed", type = {Group.class, EvidenceVariable.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Definition of the actual variable related to the statistic(s)", formalDefinition="Definition of the actual variable related to the statistic(s)." )
        protected Reference observed;

        /**
         * Definition of the intended variable related to the Evidence.
         */
        @Child(name = "intended", type = {Group.class, EvidenceVariable.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Definition of the intended variable related to the Evidence", formalDefinition="Definition of the intended variable related to the Evidence." )
        protected Reference intended;

        /**
         * Indication of quality of match between intended variable to actual variable.
         */
        @Child(name = "directnessMatch", type = {CodeableConcept.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="low | moderate | high | exact", formalDefinition="Indication of quality of match between intended variable to actual variable." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/directness")
        protected CodeableConcept directnessMatch;

        private static final long serialVersionUID = -702346164L;

    /**
     * Constructor
     */
      public EvidenceVariableDefinitionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public EvidenceVariableDefinitionComponent(CodeableConcept variableRole) {
        super();
        this.setVariableRole(variableRole);
      }

        /**
         * @return {@link #description} (A text description or summary of the variable.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableDefinitionComponent.description");
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
         * @param value {@link #description} (A text description or summary of the variable.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public EvidenceVariableDefinitionComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A text description or summary of the variable.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A text description or summary of the variable.
         */
        public EvidenceVariableDefinitionComponent setDescription(String value) { 
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
         * @return {@link #note} (Footnotes and/or explanatory notes.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceVariableDefinitionComponent setNote(List<Annotation> theNote) { 
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

        public EvidenceVariableDefinitionComponent addNote(Annotation t) { //3
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
         * @return {@link #variableRole} (population | subpopulation | exposure | referenceExposure | measuredVariable | confounder.)
         */
        public CodeableConcept getVariableRole() { 
          if (this.variableRole == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableDefinitionComponent.variableRole");
            else if (Configuration.doAutoCreate())
              this.variableRole = new CodeableConcept(); // cc
          return this.variableRole;
        }

        public boolean hasVariableRole() { 
          return this.variableRole != null && !this.variableRole.isEmpty();
        }

        /**
         * @param value {@link #variableRole} (population | subpopulation | exposure | referenceExposure | measuredVariable | confounder.)
         */
        public EvidenceVariableDefinitionComponent setVariableRole(CodeableConcept value) { 
          this.variableRole = value;
          return this;
        }

        /**
         * @return {@link #observed} (Definition of the actual variable related to the statistic(s).)
         */
        public Reference getObserved() { 
          if (this.observed == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableDefinitionComponent.observed");
            else if (Configuration.doAutoCreate())
              this.observed = new Reference(); // cc
          return this.observed;
        }

        public boolean hasObserved() { 
          return this.observed != null && !this.observed.isEmpty();
        }

        /**
         * @param value {@link #observed} (Definition of the actual variable related to the statistic(s).)
         */
        public EvidenceVariableDefinitionComponent setObserved(Reference value) { 
          this.observed = value;
          return this;
        }

        /**
         * @return {@link #intended} (Definition of the intended variable related to the Evidence.)
         */
        public Reference getIntended() { 
          if (this.intended == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableDefinitionComponent.intended");
            else if (Configuration.doAutoCreate())
              this.intended = new Reference(); // cc
          return this.intended;
        }

        public boolean hasIntended() { 
          return this.intended != null && !this.intended.isEmpty();
        }

        /**
         * @param value {@link #intended} (Definition of the intended variable related to the Evidence.)
         */
        public EvidenceVariableDefinitionComponent setIntended(Reference value) { 
          this.intended = value;
          return this;
        }

        /**
         * @return {@link #directnessMatch} (Indication of quality of match between intended variable to actual variable.)
         */
        public CodeableConcept getDirectnessMatch() { 
          if (this.directnessMatch == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceVariableDefinitionComponent.directnessMatch");
            else if (Configuration.doAutoCreate())
              this.directnessMatch = new CodeableConcept(); // cc
          return this.directnessMatch;
        }

        public boolean hasDirectnessMatch() { 
          return this.directnessMatch != null && !this.directnessMatch.isEmpty();
        }

        /**
         * @param value {@link #directnessMatch} (Indication of quality of match between intended variable to actual variable.)
         */
        public EvidenceVariableDefinitionComponent setDirectnessMatch(CodeableConcept value) { 
          this.directnessMatch = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "A text description or summary of the variable.", 0, 1, description));
          children.add(new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("variableRole", "CodeableConcept", "population | subpopulation | exposure | referenceExposure | measuredVariable | confounder.", 0, 1, variableRole));
          children.add(new Property("observed", "Reference(Group|EvidenceVariable)", "Definition of the actual variable related to the statistic(s).", 0, 1, observed));
          children.add(new Property("intended", "Reference(Group|EvidenceVariable)", "Definition of the intended variable related to the Evidence.", 0, 1, intended));
          children.add(new Property("directnessMatch", "CodeableConcept", "Indication of quality of match between intended variable to actual variable.", 0, 1, directnessMatch));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "A text description or summary of the variable.", 0, 1, description);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note);
          case -372889326: /*variableRole*/  return new Property("variableRole", "CodeableConcept", "population | subpopulation | exposure | referenceExposure | measuredVariable | confounder.", 0, 1, variableRole);
          case 348607176: /*observed*/  return new Property("observed", "Reference(Group|EvidenceVariable)", "Definition of the actual variable related to the statistic(s).", 0, 1, observed);
          case 570282027: /*intended*/  return new Property("intended", "Reference(Group|EvidenceVariable)", "Definition of the intended variable related to the Evidence.", 0, 1, intended);
          case -2144864283: /*directnessMatch*/  return new Property("directnessMatch", "CodeableConcept", "Indication of quality of match between intended variable to actual variable.", 0, 1, directnessMatch);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -372889326: /*variableRole*/ return this.variableRole == null ? new Base[0] : new Base[] {this.variableRole}; // CodeableConcept
        case 348607176: /*observed*/ return this.observed == null ? new Base[0] : new Base[] {this.observed}; // Reference
        case 570282027: /*intended*/ return this.intended == null ? new Base[0] : new Base[] {this.intended}; // Reference
        case -2144864283: /*directnessMatch*/ return this.directnessMatch == null ? new Base[0] : new Base[] {this.directnessMatch}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -372889326: // variableRole
          this.variableRole = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 348607176: // observed
          this.observed = TypeConvertor.castToReference(value); // Reference
          return value;
        case 570282027: // intended
          this.intended = TypeConvertor.castToReference(value); // Reference
          return value;
        case -2144864283: // directnessMatch
          this.directnessMatch = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("variableRole")) {
          this.variableRole = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("observed")) {
          this.observed = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("intended")) {
          this.intended = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("directnessMatch")) {
          this.directnessMatch = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 3387378:  return addNote(); 
        case -372889326:  return getVariableRole();
        case 348607176:  return getObserved();
        case 570282027:  return getIntended();
        case -2144864283:  return getDirectnessMatch();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -372889326: /*variableRole*/ return new String[] {"CodeableConcept"};
        case 348607176: /*observed*/ return new String[] {"Reference"};
        case 570282027: /*intended*/ return new String[] {"Reference"};
        case -2144864283: /*directnessMatch*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.variableDefinition.description");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("variableRole")) {
          this.variableRole = new CodeableConcept();
          return this.variableRole;
        }
        else if (name.equals("observed")) {
          this.observed = new Reference();
          return this.observed;
        }
        else if (name.equals("intended")) {
          this.intended = new Reference();
          return this.intended;
        }
        else if (name.equals("directnessMatch")) {
          this.directnessMatch = new CodeableConcept();
          return this.directnessMatch;
        }
        else
          return super.addChild(name);
      }

      public EvidenceVariableDefinitionComponent copy() {
        EvidenceVariableDefinitionComponent dst = new EvidenceVariableDefinitionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceVariableDefinitionComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.variableRole = variableRole == null ? null : variableRole.copy();
        dst.observed = observed == null ? null : observed.copy();
        dst.intended = intended == null ? null : intended.copy();
        dst.directnessMatch = directnessMatch == null ? null : directnessMatch.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableDefinitionComponent))
          return false;
        EvidenceVariableDefinitionComponent o = (EvidenceVariableDefinitionComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(variableRole, o.variableRole, true)
           && compareDeep(observed, o.observed, true) && compareDeep(intended, o.intended, true) && compareDeep(directnessMatch, o.directnessMatch, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceVariableDefinitionComponent))
          return false;
        EvidenceVariableDefinitionComponent o = (EvidenceVariableDefinitionComponent) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, variableRole
          , observed, intended, directnessMatch);
      }

  public String fhirType() {
    return "Evidence.variableDefinition";

  }

  }

    @Block()
    public static class EvidenceCertaintyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Textual description of certainty.
         */
        @Child(name = "description", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Textual description of certainty", formalDefinition="Textual description of certainty." )
        protected StringType description;

        /**
         * Footnotes and/or explanatory notes.
         */
        @Child(name = "note", type = {Annotation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Footnotes and/or explanatory notes", formalDefinition="Footnotes and/or explanatory notes." )
        protected List<Annotation> note;

        /**
         * Aspect of certainty being rated.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Aspect of certainty being rated", formalDefinition="Aspect of certainty being rated." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/certainty-type")
        protected CodeableConcept type;

        /**
         * Assessment or judgement of the aspect.
         */
        @Child(name = "rating", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Assessment or judgement of the aspect", formalDefinition="Assessment or judgement of the aspect." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/certainty-rating")
        protected CodeableConcept rating;

        /**
         * Individual or group who did the rating.
         */
        @Child(name = "rater", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Individual or group who did the rating", formalDefinition="Individual or group who did the rating." )
        protected StringType rater;

        /**
         * A domain or subdomain of certainty.
         */
        @Child(name = "subcomponent", type = {EvidenceCertaintyComponent.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A domain or subdomain of certainty", formalDefinition="A domain or subdomain of certainty." )
        protected List<EvidenceCertaintyComponent> subcomponent;

        private static final long serialVersionUID = 432882532L;

    /**
     * Constructor
     */
      public EvidenceCertaintyComponent() {
        super();
      }

        /**
         * @return {@link #description} (Textual description of certainty.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceCertaintyComponent.description");
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
         * @param value {@link #description} (Textual description of certainty.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public EvidenceCertaintyComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Textual description of certainty.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Textual description of certainty.
         */
        public EvidenceCertaintyComponent setDescription(String value) { 
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
         * @return {@link #note} (Footnotes and/or explanatory notes.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceCertaintyComponent setNote(List<Annotation> theNote) { 
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

        public EvidenceCertaintyComponent addNote(Annotation t) { //3
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
         * @return {@link #type} (Aspect of certainty being rated.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceCertaintyComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Aspect of certainty being rated.)
         */
        public EvidenceCertaintyComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #rating} (Assessment or judgement of the aspect.)
         */
        public CodeableConcept getRating() { 
          if (this.rating == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceCertaintyComponent.rating");
            else if (Configuration.doAutoCreate())
              this.rating = new CodeableConcept(); // cc
          return this.rating;
        }

        public boolean hasRating() { 
          return this.rating != null && !this.rating.isEmpty();
        }

        /**
         * @param value {@link #rating} (Assessment or judgement of the aspect.)
         */
        public EvidenceCertaintyComponent setRating(CodeableConcept value) { 
          this.rating = value;
          return this;
        }

        /**
         * @return {@link #rater} (Individual or group who did the rating.). This is the underlying object with id, value and extensions. The accessor "getRater" gives direct access to the value
         */
        public StringType getRaterElement() { 
          if (this.rater == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceCertaintyComponent.rater");
            else if (Configuration.doAutoCreate())
              this.rater = new StringType(); // bb
          return this.rater;
        }

        public boolean hasRaterElement() { 
          return this.rater != null && !this.rater.isEmpty();
        }

        public boolean hasRater() { 
          return this.rater != null && !this.rater.isEmpty();
        }

        /**
         * @param value {@link #rater} (Individual or group who did the rating.). This is the underlying object with id, value and extensions. The accessor "getRater" gives direct access to the value
         */
        public EvidenceCertaintyComponent setRaterElement(StringType value) { 
          this.rater = value;
          return this;
        }

        /**
         * @return Individual or group who did the rating.
         */
        public String getRater() { 
          return this.rater == null ? null : this.rater.getValue();
        }

        /**
         * @param value Individual or group who did the rating.
         */
        public EvidenceCertaintyComponent setRater(String value) { 
          if (Utilities.noString(value))
            this.rater = null;
          else {
            if (this.rater == null)
              this.rater = new StringType();
            this.rater.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #subcomponent} (A domain or subdomain of certainty.)
         */
        public List<EvidenceCertaintyComponent> getSubcomponent() { 
          if (this.subcomponent == null)
            this.subcomponent = new ArrayList<EvidenceCertaintyComponent>();
          return this.subcomponent;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceCertaintyComponent setSubcomponent(List<EvidenceCertaintyComponent> theSubcomponent) { 
          this.subcomponent = theSubcomponent;
          return this;
        }

        public boolean hasSubcomponent() { 
          if (this.subcomponent == null)
            return false;
          for (EvidenceCertaintyComponent item : this.subcomponent)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public EvidenceCertaintyComponent addSubcomponent() { //3
          EvidenceCertaintyComponent t = new EvidenceCertaintyComponent();
          if (this.subcomponent == null)
            this.subcomponent = new ArrayList<EvidenceCertaintyComponent>();
          this.subcomponent.add(t);
          return t;
        }

        public EvidenceCertaintyComponent addSubcomponent(EvidenceCertaintyComponent t) { //3
          if (t == null)
            return this;
          if (this.subcomponent == null)
            this.subcomponent = new ArrayList<EvidenceCertaintyComponent>();
          this.subcomponent.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #subcomponent}, creating it if it does not already exist {3}
         */
        public EvidenceCertaintyComponent getSubcomponentFirstRep() { 
          if (getSubcomponent().isEmpty()) {
            addSubcomponent();
          }
          return getSubcomponent().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "string", "Textual description of certainty.", 0, 1, description));
          children.add(new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("type", "CodeableConcept", "Aspect of certainty being rated.", 0, 1, type));
          children.add(new Property("rating", "CodeableConcept", "Assessment or judgement of the aspect.", 0, 1, rating));
          children.add(new Property("rater", "string", "Individual or group who did the rating.", 0, 1, rater));
          children.add(new Property("subcomponent", "@Evidence.certainty", "A domain or subdomain of certainty.", 0, java.lang.Integer.MAX_VALUE, subcomponent));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "string", "Textual description of certainty.", 0, 1, description);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Aspect of certainty being rated.", 0, 1, type);
          case -938102371: /*rating*/  return new Property("rating", "CodeableConcept", "Assessment or judgement of the aspect.", 0, 1, rating);
          case 108285842: /*rater*/  return new Property("rater", "string", "Individual or group who did the rating.", 0, 1, rater);
          case -1308662083: /*subcomponent*/  return new Property("subcomponent", "@Evidence.certainty", "A domain or subdomain of certainty.", 0, java.lang.Integer.MAX_VALUE, subcomponent);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -938102371: /*rating*/ return this.rating == null ? new Base[0] : new Base[] {this.rating}; // CodeableConcept
        case 108285842: /*rater*/ return this.rater == null ? new Base[0] : new Base[] {this.rater}; // StringType
        case -1308662083: /*subcomponent*/ return this.subcomponent == null ? new Base[0] : this.subcomponent.toArray(new Base[this.subcomponent.size()]); // EvidenceCertaintyComponent
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
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -938102371: // rating
          this.rating = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 108285842: // rater
          this.rater = TypeConvertor.castToString(value); // StringType
          return value;
        case -1308662083: // subcomponent
          this.getSubcomponent().add((EvidenceCertaintyComponent) value); // EvidenceCertaintyComponent
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
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("rating")) {
          this.rating = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("rater")) {
          this.rater = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("subcomponent")) {
          this.getSubcomponent().add((EvidenceCertaintyComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 3387378:  return addNote(); 
        case 3575610:  return getType();
        case -938102371:  return getRating();
        case 108285842:  return getRaterElement();
        case -1308662083:  return addSubcomponent(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -938102371: /*rating*/ return new String[] {"CodeableConcept"};
        case 108285842: /*rater*/ return new String[] {"string"};
        case -1308662083: /*subcomponent*/ return new String[] {"@Evidence.certainty"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.certainty.description");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("rating")) {
          this.rating = new CodeableConcept();
          return this.rating;
        }
        else if (name.equals("rater")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.certainty.rater");
        }
        else if (name.equals("subcomponent")) {
          return addSubcomponent();
        }
        else
          return super.addChild(name);
      }

      public EvidenceCertaintyComponent copy() {
        EvidenceCertaintyComponent dst = new EvidenceCertaintyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceCertaintyComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.rating = rating == null ? null : rating.copy();
        dst.rater = rater == null ? null : rater.copy();
        if (subcomponent != null) {
          dst.subcomponent = new ArrayList<EvidenceCertaintyComponent>();
          for (EvidenceCertaintyComponent i : subcomponent)
            dst.subcomponent.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceCertaintyComponent))
          return false;
        EvidenceCertaintyComponent o = (EvidenceCertaintyComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(type, o.type, true)
           && compareDeep(rating, o.rating, true) && compareDeep(rater, o.rater, true) && compareDeep(subcomponent, o.subcomponent, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceCertaintyComponent))
          return false;
        EvidenceCertaintyComponent o = (EvidenceCertaintyComponent) other_;
        return compareValues(description, o.description, true) && compareValues(rater, o.rater, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, type
          , rating, rater, subcomponent);
      }

  public String fhirType() {
    return "Evidence.certainty";

  }

  }

    /**
     * An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this evidence, represented as a globally unique URI", formalDefinition="An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the summary", formalDefinition="A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of this summary", formalDefinition="The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * A short, descriptive, user-friendly title for the summary.
     */
    @Child(name = "title", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this summary (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the summary." )
    protected StringType title;

    /**
     * Citation Resource or display of suggested citation for this evidence.
     */
    @Child(name = "citeAs", type = {Citation.class, MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Citation for this evidence", formalDefinition="Citation Resource or display of suggested citation for this evidence." )
    protected DataType citeAs;

    /**
     * The status of this summary. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=5, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this summary. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * The date  (and optionally time) when the summary was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the summary was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes." )
    protected DateTimeType date;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence instances." )
    protected List<UsageContext> useContext;

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the summary was approved by publisher", formalDefinition="The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the summary was last reviewed", formalDefinition="The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The name of the organization or individual that published the evidence.
     */
    @Child(name = "publisher", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher (organization or individual)", formalDefinition="The name of the organization or individual that published the evidence." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * An individiual, organization, or device primarily involved in the creation and maintenance of the content.
     */
    @Child(name = "author", type = {ContactDetail.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who authored the content", formalDefinition="An individiual, organization, or device primarily involved in the creation and maintenance of the content." )
    protected List<ContactDetail> author;

    /**
     * An individiual, organization, or device primarily responsible for internal coherence of the content.
     */
    @Child(name = "editor", type = {ContactDetail.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who edited the content", formalDefinition="An individiual, organization, or device primarily responsible for internal coherence of the content." )
    protected List<ContactDetail> editor;

    /**
     * An individiual, organization, or device primarily responsible for review of some aspect of the content.
     */
    @Child(name = "reviewer", type = {ContactDetail.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who reviewed the content", formalDefinition="An individiual, organization, or device primarily responsible for review of some aspect of the content." )
    protected List<ContactDetail> reviewer;

    /**
     * An individiual, organization, or device responsible for officially endorsing the content for use in some setting.
     */
    @Child(name = "endorser", type = {ContactDetail.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who endorsed the content", formalDefinition="An individiual, organization, or device responsible for officially endorsing the content for use in some setting." )
    protected List<ContactDetail> endorser;

    /**
     * Link or citation to artifact associated with the summary.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Link or citation to artifact associated with the summary", formalDefinition="Link or citation to artifact associated with the summary." )
    protected List<RelatedArtifact> relatedArtifact;

    /**
     * A free text natural language description of the evidence from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Description of the particular summary", formalDefinition="A free text natural language description of the evidence from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * Declarative description of the Evidence.
     */
    @Child(name = "assertion", type = {MarkdownType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Declarative description of the Evidence", formalDefinition="Declarative description of the Evidence." )
    protected MarkdownType assertion;

    /**
     * Footnotes and/or explanatory notes.
     */
    @Child(name = "note", type = {Annotation.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Footnotes and/or explanatory notes", formalDefinition="Footnotes and/or explanatory notes." )
    protected List<Annotation> note;

    /**
     * Evidence variable such as population, exposure, or outcome.
     */
    @Child(name = "variableDefinition", type = {}, order=20, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Evidence variable such as population, exposure, or outcome", formalDefinition="Evidence variable such as population, exposure, or outcome." )
    protected List<EvidenceVariableDefinitionComponent> variableDefinition;

    /**
     * The method to combine studies.
     */
    @Child(name = "synthesisType", type = {CodeableConcept.class}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The method to combine studies", formalDefinition="The method to combine studies." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/synthesis-type")
    protected CodeableConcept synthesisType;

    /**
     * The type of study that produced this evidence.
     */
    @Child(name = "studyType", type = {CodeableConcept.class}, order=22, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The type of study that produced this evidence", formalDefinition="The type of study that produced this evidence." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/study-type")
    protected CodeableConcept studyType;

    /**
     * Values and parameters for a single statistic.
     */
    @Child(name = "statistic", type = {Statistic.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Values and parameters for a single statistic", formalDefinition="Values and parameters for a single statistic." )
    protected List<Statistic> statistic;

    /**
     * An ordered group of statistics.
     */
    @Child(name = "distribution", type = {OrderedDistribution.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="An ordered group of statistics", formalDefinition="An ordered group of statistics." )
    protected List<OrderedDistribution> distribution;

    /**
     * Assessment of certainty, confidence in the estimates, or quality of the evidence.
     */
    @Child(name = "certainty", type = {}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Certainty or quality of the evidence", formalDefinition="Assessment of certainty, confidence in the estimates, or quality of the evidence." )
    protected List<EvidenceCertaintyComponent> certainty;

    private static final long serialVersionUID = -2080725419L;

  /**
   * Constructor
   */
    public Evidence() {
      super();
    }

  /**
   * Constructor
   */
    public Evidence(PublicationStatus status, EvidenceVariableDefinitionComponent variableDefinition) {
      super();
      this.setStatus(status);
      this.addVariableDefinition(variableDefinition);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Evidence setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    public Evidence setUrl(String value) { 
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
     * @return {@link #identifier} (A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setIdentifier(List<Identifier> theIdentifier) { 
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

    public Evidence addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public Evidence setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public Evidence setVersion(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the summary.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the summary.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public Evidence setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the summary.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the summary.
     */
    public Evidence setTitle(String value) { 
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
     * @return {@link #citeAs} (Citation Resource or display of suggested citation for this evidence.)
     */
    public DataType getCiteAs() { 
      return this.citeAs;
    }

    /**
     * @return {@link #citeAs} (Citation Resource or display of suggested citation for this evidence.)
     */
    public Reference getCiteAsReference() throws FHIRException { 
      if (this.citeAs == null)
        this.citeAs = new Reference();
      if (!(this.citeAs instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.citeAs.getClass().getName()+" was encountered");
      return (Reference) this.citeAs;
    }

    public boolean hasCiteAsReference() { 
      return this != null && this.citeAs instanceof Reference;
    }

    /**
     * @return {@link #citeAs} (Citation Resource or display of suggested citation for this evidence.)
     */
    public MarkdownType getCiteAsMarkdownType() throws FHIRException { 
      if (this.citeAs == null)
        this.citeAs = new MarkdownType();
      if (!(this.citeAs instanceof MarkdownType))
        throw new FHIRException("Type mismatch: the type MarkdownType was expected, but "+this.citeAs.getClass().getName()+" was encountered");
      return (MarkdownType) this.citeAs;
    }

    public boolean hasCiteAsMarkdownType() { 
      return this != null && this.citeAs instanceof MarkdownType;
    }

    public boolean hasCiteAs() { 
      return this.citeAs != null && !this.citeAs.isEmpty();
    }

    /**
     * @param value {@link #citeAs} (Citation Resource or display of suggested citation for this evidence.)
     */
    public Evidence setCiteAs(DataType value) { 
      if (value != null && !(value instanceof Reference || value instanceof MarkdownType))
        throw new Error("Not the right type for Evidence.citeAs[x]: "+value.fhirType());
      this.citeAs = value;
      return this;
    }

    /**
     * @return {@link #status} (The status of this summary. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.status");
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
     * @param value {@link #status} (The status of this summary. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Evidence setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this summary. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this summary. Enables tracking the life-cycle of the content.
     */
    public Evidence setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the summary was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the summary was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public Evidence setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the summary was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the summary was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.
     */
    public Evidence setDate(Date value) { 
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setUseContext(List<UsageContext> theUseContext) { 
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

    public Evidence addUseContext(UsageContext t) { //3
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
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.approvalDate");
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
    public Evidence setApprovalDateElement(DateType value) { 
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
    public Evidence setApprovalDate(Date value) { 
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
          throw new Error("Attempt to auto-create Evidence.lastReviewDate");
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
    public Evidence setLastReviewDateElement(DateType value) { 
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
    public Evidence setLastReviewDate(Date value) { 
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
     * @return {@link #publisher} (The name of the organization or individual that published the evidence.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.publisher");
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
     * @param value {@link #publisher} (The name of the organization or individual that published the evidence.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public Evidence setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual that published the evidence.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual that published the evidence.
     */
    public Evidence setPublisher(String value) { 
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
    public Evidence setContact(List<ContactDetail> theContact) { 
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

    public Evidence addContact(ContactDetail t) { //3
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
     * @return {@link #author} (An individiual, organization, or device primarily involved in the creation and maintenance of the content.)
     */
    public List<ContactDetail> getAuthor() { 
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      return this.author;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setAuthor(List<ContactDetail> theAuthor) { 
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

    public Evidence addAuthor(ContactDetail t) { //3
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
     * @return {@link #editor} (An individiual, organization, or device primarily responsible for internal coherence of the content.)
     */
    public List<ContactDetail> getEditor() { 
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      return this.editor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setEditor(List<ContactDetail> theEditor) { 
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

    public Evidence addEditor(ContactDetail t) { //3
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
     * @return {@link #reviewer} (An individiual, organization, or device primarily responsible for review of some aspect of the content.)
     */
    public List<ContactDetail> getReviewer() { 
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      return this.reviewer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setReviewer(List<ContactDetail> theReviewer) { 
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

    public Evidence addReviewer(ContactDetail t) { //3
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
     * @return {@link #endorser} (An individiual, organization, or device responsible for officially endorsing the content for use in some setting.)
     */
    public List<ContactDetail> getEndorser() { 
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      return this.endorser;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setEndorser(List<ContactDetail> theEndorser) { 
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

    public Evidence addEndorser(ContactDetail t) { //3
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
     * @return {@link #relatedArtifact} (Link or citation to artifact associated with the summary.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      return this.relatedArtifact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
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

    public Evidence addRelatedArtifact(RelatedArtifact t) { //3
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
     * @return {@link #description} (A free text natural language description of the evidence from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.description");
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
     * @param value {@link #description} (A free text natural language description of the evidence from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Evidence setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the evidence from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the evidence from a consumer's perspective.
     */
    public Evidence setDescription(String value) { 
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
     * @return {@link #assertion} (Declarative description of the Evidence.). This is the underlying object with id, value and extensions. The accessor "getAssertion" gives direct access to the value
     */
    public MarkdownType getAssertionElement() { 
      if (this.assertion == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.assertion");
        else if (Configuration.doAutoCreate())
          this.assertion = new MarkdownType(); // bb
      return this.assertion;
    }

    public boolean hasAssertionElement() { 
      return this.assertion != null && !this.assertion.isEmpty();
    }

    public boolean hasAssertion() { 
      return this.assertion != null && !this.assertion.isEmpty();
    }

    /**
     * @param value {@link #assertion} (Declarative description of the Evidence.). This is the underlying object with id, value and extensions. The accessor "getAssertion" gives direct access to the value
     */
    public Evidence setAssertionElement(MarkdownType value) { 
      this.assertion = value;
      return this;
    }

    /**
     * @return Declarative description of the Evidence.
     */
    public String getAssertion() { 
      return this.assertion == null ? null : this.assertion.getValue();
    }

    /**
     * @param value Declarative description of the Evidence.
     */
    public Evidence setAssertion(String value) { 
      if (value == null)
        this.assertion = null;
      else {
        if (this.assertion == null)
          this.assertion = new MarkdownType();
        this.assertion.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #note} (Footnotes and/or explanatory notes.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setNote(List<Annotation> theNote) { 
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

    public Evidence addNote(Annotation t) { //3
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
     * @return {@link #variableDefinition} (Evidence variable such as population, exposure, or outcome.)
     */
    public List<EvidenceVariableDefinitionComponent> getVariableDefinition() { 
      if (this.variableDefinition == null)
        this.variableDefinition = new ArrayList<EvidenceVariableDefinitionComponent>();
      return this.variableDefinition;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setVariableDefinition(List<EvidenceVariableDefinitionComponent> theVariableDefinition) { 
      this.variableDefinition = theVariableDefinition;
      return this;
    }

    public boolean hasVariableDefinition() { 
      if (this.variableDefinition == null)
        return false;
      for (EvidenceVariableDefinitionComponent item : this.variableDefinition)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public EvidenceVariableDefinitionComponent addVariableDefinition() { //3
      EvidenceVariableDefinitionComponent t = new EvidenceVariableDefinitionComponent();
      if (this.variableDefinition == null)
        this.variableDefinition = new ArrayList<EvidenceVariableDefinitionComponent>();
      this.variableDefinition.add(t);
      return t;
    }

    public Evidence addVariableDefinition(EvidenceVariableDefinitionComponent t) { //3
      if (t == null)
        return this;
      if (this.variableDefinition == null)
        this.variableDefinition = new ArrayList<EvidenceVariableDefinitionComponent>();
      this.variableDefinition.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #variableDefinition}, creating it if it does not already exist {3}
     */
    public EvidenceVariableDefinitionComponent getVariableDefinitionFirstRep() { 
      if (getVariableDefinition().isEmpty()) {
        addVariableDefinition();
      }
      return getVariableDefinition().get(0);
    }

    /**
     * @return {@link #synthesisType} (The method to combine studies.)
     */
    public CodeableConcept getSynthesisType() { 
      if (this.synthesisType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.synthesisType");
        else if (Configuration.doAutoCreate())
          this.synthesisType = new CodeableConcept(); // cc
      return this.synthesisType;
    }

    public boolean hasSynthesisType() { 
      return this.synthesisType != null && !this.synthesisType.isEmpty();
    }

    /**
     * @param value {@link #synthesisType} (The method to combine studies.)
     */
    public Evidence setSynthesisType(CodeableConcept value) { 
      this.synthesisType = value;
      return this;
    }

    /**
     * @return {@link #studyType} (The type of study that produced this evidence.)
     */
    public CodeableConcept getStudyType() { 
      if (this.studyType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.studyType");
        else if (Configuration.doAutoCreate())
          this.studyType = new CodeableConcept(); // cc
      return this.studyType;
    }

    public boolean hasStudyType() { 
      return this.studyType != null && !this.studyType.isEmpty();
    }

    /**
     * @param value {@link #studyType} (The type of study that produced this evidence.)
     */
    public Evidence setStudyType(CodeableConcept value) { 
      this.studyType = value;
      return this;
    }

    /**
     * @return {@link #statistic} (Values and parameters for a single statistic.)
     */
    public List<Statistic> getStatistic() { 
      if (this.statistic == null)
        this.statistic = new ArrayList<Statistic>();
      return this.statistic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setStatistic(List<Statistic> theStatistic) { 
      this.statistic = theStatistic;
      return this;
    }

    public boolean hasStatistic() { 
      if (this.statistic == null)
        return false;
      for (Statistic item : this.statistic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Statistic addStatistic() { //3
      Statistic t = new Statistic();
      if (this.statistic == null)
        this.statistic = new ArrayList<Statistic>();
      this.statistic.add(t);
      return t;
    }

    public Evidence addStatistic(Statistic t) { //3
      if (t == null)
        return this;
      if (this.statistic == null)
        this.statistic = new ArrayList<Statistic>();
      this.statistic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #statistic}, creating it if it does not already exist {3}
     */
    public Statistic getStatisticFirstRep() { 
      if (getStatistic().isEmpty()) {
        addStatistic();
      }
      return getStatistic().get(0);
    }

    /**
     * @return {@link #distribution} (An ordered group of statistics.)
     */
    public List<OrderedDistribution> getDistribution() { 
      if (this.distribution == null)
        this.distribution = new ArrayList<OrderedDistribution>();
      return this.distribution;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setDistribution(List<OrderedDistribution> theDistribution) { 
      this.distribution = theDistribution;
      return this;
    }

    public boolean hasDistribution() { 
      if (this.distribution == null)
        return false;
      for (OrderedDistribution item : this.distribution)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public OrderedDistribution addDistribution() { //3
      OrderedDistribution t = new OrderedDistribution();
      if (this.distribution == null)
        this.distribution = new ArrayList<OrderedDistribution>();
      this.distribution.add(t);
      return t;
    }

    public Evidence addDistribution(OrderedDistribution t) { //3
      if (t == null)
        return this;
      if (this.distribution == null)
        this.distribution = new ArrayList<OrderedDistribution>();
      this.distribution.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #distribution}, creating it if it does not already exist {3}
     */
    public OrderedDistribution getDistributionFirstRep() { 
      if (getDistribution().isEmpty()) {
        addDistribution();
      }
      return getDistribution().get(0);
    }

    /**
     * @return {@link #certainty} (Assessment of certainty, confidence in the estimates, or quality of the evidence.)
     */
    public List<EvidenceCertaintyComponent> getCertainty() { 
      if (this.certainty == null)
        this.certainty = new ArrayList<EvidenceCertaintyComponent>();
      return this.certainty;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setCertainty(List<EvidenceCertaintyComponent> theCertainty) { 
      this.certainty = theCertainty;
      return this;
    }

    public boolean hasCertainty() { 
      if (this.certainty == null)
        return false;
      for (EvidenceCertaintyComponent item : this.certainty)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public EvidenceCertaintyComponent addCertainty() { //3
      EvidenceCertaintyComponent t = new EvidenceCertaintyComponent();
      if (this.certainty == null)
        this.certainty = new ArrayList<EvidenceCertaintyComponent>();
      this.certainty.add(t);
      return t;
    }

    public Evidence addCertainty(EvidenceCertaintyComponent t) { //3
      if (t == null)
        return this;
      if (this.certainty == null)
        this.certainty = new ArrayList<EvidenceCertaintyComponent>();
      this.certainty.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #certainty}, creating it if it does not already exist {3}
     */
    public EvidenceCertaintyComponent getCertaintyFirstRep() { 
      if (getCertainty().isEmpty()) {
        addCertainty();
      }
      return getCertainty().get(0);
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getNameMax() { 
      return 0;
    }
    /**
     * @return {@link #name} (A natural language name identifying the evidence. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"name\"");
    }

    public boolean hasNameElement() { 
      return false;
    }
    public boolean hasName() {
      return false;
    }

    /**
     * @param value {@link #name} (A natural language name identifying the evidence. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public Evidence setNameElement(StringType value) { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"name\"");
    }
    public String getName() { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"name\"");
    }
    /**
     * @param value A natural language name identifying the evidence. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public Evidence setName(String value) { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"name\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getExperimentalMax() { 
      return 0;
    }
    /**
     * @return {@link #experimental} (A Boolean value to indicate that this evidence is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"experimental\"");
    }

    public boolean hasExperimentalElement() { 
      return false;
    }
    public boolean hasExperimental() {
      return false;
    }

    /**
     * @param value {@link #experimental} (A Boolean value to indicate that this evidence is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public Evidence setExperimentalElement(BooleanType value) { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"experimental\"");
    }
    public boolean getExperimental() { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"experimental\"");
    }
    /**
     * @param value A Boolean value to indicate that this evidence is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public Evidence setExperimental(boolean value) { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"experimental\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getJurisdictionMax() { 
      return 0;
    }
    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the evidence is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setJurisdiction(List<CodeableConcept> theJurisdiction) { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"jurisdiction\"");
    }
    public boolean hasJurisdiction() { 
      return false;
    }

    public CodeableConcept addJurisdiction() { //3
      throw new Error("The resource type \"Evidence\" does not implement the property \"jurisdiction\"");
    }
    public Evidence addJurisdiction(CodeableConcept t) { //3
      throw new Error("The resource type \"Evidence\" does not implement the property \"jurisdiction\"");
    }
    /**
     * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {2}
     */
    public CodeableConcept getJurisdictionFirstRep() { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"jurisdiction\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getPurposeMax() { 
      return 0;
    }
    /**
     * @return {@link #purpose} (Explanation of why this evidence is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"purpose\"");
    }

    public boolean hasPurposeElement() { 
      return false;
    }
    public boolean hasPurpose() {
      return false;
    }

    /**
     * @param value {@link #purpose} (Explanation of why this evidence is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public Evidence setPurposeElement(MarkdownType value) { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"purpose\"");
    }
    public String getPurpose() { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"purpose\"");
    }
    /**
     * @param value Explanation of why this evidence is needed and why it has been designed as it has.
     */
    public Evidence setPurpose(String value) { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"purpose\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getCopyrightMax() { 
      return 0;
    }
    /**
     * @return {@link #copyright} (A copyright statement relating to the evidence and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the evidence.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"copyright\"");
    }

    public boolean hasCopyrightElement() { 
      return false;
    }
    public boolean hasCopyright() {
      return false;
    }

    /**
     * @param value {@link #copyright} (A copyright statement relating to the evidence and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the evidence.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public Evidence setCopyrightElement(MarkdownType value) { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"copyright\"");
    }
    public String getCopyright() { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"copyright\"");
    }
    /**
     * @param value A copyright statement relating to the evidence and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the evidence.
     */
    public Evidence setCopyright(String value) { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"copyright\"");
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getEffectivePeriodMax() { 
      return 0;
    }
    /**
     * @return {@link #effectivePeriod} (The period during which the evidence content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"effectivePeriod\"");
    }
    public boolean hasEffectivePeriod() { 
      return false;
    }
    /**
     * @param value {@link #effectivePeriod} (The period during which the evidence content was or is planned to be in active use.)
     */
    public Evidence setEffectivePeriod(Period value) { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"effectivePeriod\"");
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getTopicMax() { 
      return 0;
    }
    /**
     * @return {@link #topic} (Descriptive topics related to the content of the library. Topics provide a high-level categorization of the library that can be useful for filtering and searching.)
     */
    public List<CodeableConcept> getTopic() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setTopic(List<CodeableConcept> theTopic) { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"topic\"");
    }
    public boolean hasTopic() { 
      return false;
    }

    public CodeableConcept addTopic() { //3
      throw new Error("The resource type \"Evidence\" does not implement the property \"topic\"");
    }
    public Evidence addTopic(CodeableConcept t) { //3
      throw new Error("The resource type \"Evidence\" does not implement the property \"topic\"");
    }
    /**
     * @return The first repetition of repeating field {@link #topic}, creating it if it does not already exist {2}
     */
    public CodeableConcept getTopicFirstRep() { 
      throw new Error("The resource type \"Evidence\" does not implement the property \"topic\"");
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the summary.", 0, 1, title));
        children.add(new Property("citeAs[x]", "Reference(Citation)|markdown", "Citation Resource or display of suggested citation for this evidence.", 0, 1, citeAs));
        children.add(new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the summary was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.", 0, 1, date));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("publisher", "string", "The name of the organization or individual that published the evidence.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("author", "ContactDetail", "An individiual, organization, or device primarily involved in the creation and maintenance of the content.", 0, java.lang.Integer.MAX_VALUE, author));
        children.add(new Property("editor", "ContactDetail", "An individiual, organization, or device primarily responsible for internal coherence of the content.", 0, java.lang.Integer.MAX_VALUE, editor));
        children.add(new Property("reviewer", "ContactDetail", "An individiual, organization, or device primarily responsible for review of some aspect of the content.", 0, java.lang.Integer.MAX_VALUE, reviewer));
        children.add(new Property("endorser", "ContactDetail", "An individiual, organization, or device responsible for officially endorsing the content for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Link or citation to artifact associated with the summary.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
        children.add(new Property("description", "markdown", "A free text natural language description of the evidence from a consumer's perspective.", 0, 1, description));
        children.add(new Property("assertion", "markdown", "Declarative description of the Evidence.", 0, 1, assertion));
        children.add(new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("variableDefinition", "", "Evidence variable such as population, exposure, or outcome.", 0, java.lang.Integer.MAX_VALUE, variableDefinition));
        children.add(new Property("synthesisType", "CodeableConcept", "The method to combine studies.", 0, 1, synthesisType));
        children.add(new Property("studyType", "CodeableConcept", "The type of study that produced this evidence.", 0, 1, studyType));
        children.add(new Property("statistic", "Statistic", "Values and parameters for a single statistic.", 0, java.lang.Integer.MAX_VALUE, statistic));
        children.add(new Property("distribution", "OrderedDistribution", "An ordered group of statistics.", 0, java.lang.Integer.MAX_VALUE, distribution));
        children.add(new Property("certainty", "", "Assessment of certainty, confidence in the estimates, or quality of the evidence.", 0, java.lang.Integer.MAX_VALUE, certainty));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the summary.", 0, 1, title);
        case -1706539017: /*citeAs[x]*/  return new Property("citeAs[x]", "Reference(Citation)|markdown", "Citation Resource or display of suggested citation for this evidence.", 0, 1, citeAs);
        case -1360156695: /*citeAs*/  return new Property("citeAs[x]", "Reference(Citation)|markdown", "Citation Resource or display of suggested citation for this evidence.", 0, 1, citeAs);
        case 1269009762: /*citeAsReference*/  return new Property("citeAs[x]", "Reference(Citation)", "Citation Resource or display of suggested citation for this evidence.", 0, 1, citeAs);
        case 456265720: /*citeAsMarkdown*/  return new Property("citeAs[x]", "markdown", "Citation Resource or display of suggested citation for this evidence.", 0, 1, citeAs);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the summary was published. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.", 0, 1, date);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual that published the evidence.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1406328437: /*author*/  return new Property("author", "ContactDetail", "An individiual, organization, or device primarily involved in the creation and maintenance of the content.", 0, java.lang.Integer.MAX_VALUE, author);
        case -1307827859: /*editor*/  return new Property("editor", "ContactDetail", "An individiual, organization, or device primarily responsible for internal coherence of the content.", 0, java.lang.Integer.MAX_VALUE, editor);
        case -261190139: /*reviewer*/  return new Property("reviewer", "ContactDetail", "An individiual, organization, or device primarily responsible for review of some aspect of the content.", 0, java.lang.Integer.MAX_VALUE, reviewer);
        case 1740277666: /*endorser*/  return new Property("endorser", "ContactDetail", "An individiual, organization, or device responsible for officially endorsing the content for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Link or citation to artifact associated with the summary.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the evidence from a consumer's perspective.", 0, 1, description);
        case 1314395906: /*assertion*/  return new Property("assertion", "markdown", "Declarative description of the Evidence.", 0, 1, assertion);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note);
        case -1807222545: /*variableDefinition*/  return new Property("variableDefinition", "", "Evidence variable such as population, exposure, or outcome.", 0, java.lang.Integer.MAX_VALUE, variableDefinition);
        case 672726254: /*synthesisType*/  return new Property("synthesisType", "CodeableConcept", "The method to combine studies.", 0, 1, synthesisType);
        case -1955265373: /*studyType*/  return new Property("studyType", "CodeableConcept", "The type of study that produced this evidence.", 0, 1, studyType);
        case -2081261232: /*statistic*/  return new Property("statistic", "Statistic", "Values and parameters for a single statistic.", 0, java.lang.Integer.MAX_VALUE, statistic);
        case -1580708220: /*distribution*/  return new Property("distribution", "OrderedDistribution", "An ordered group of statistics.", 0, java.lang.Integer.MAX_VALUE, distribution);
        case -1404142937: /*certainty*/  return new Property("certainty", "", "Assessment of certainty, confidence in the estimates, or quality of the evidence.", 0, java.lang.Integer.MAX_VALUE, certainty);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1360156695: /*citeAs*/ return this.citeAs == null ? new Base[0] : new Base[] {this.citeAs}; // DataType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // ContactDetail
        case -1307827859: /*editor*/ return this.editor == null ? new Base[0] : this.editor.toArray(new Base[this.editor.size()]); // ContactDetail
        case -261190139: /*reviewer*/ return this.reviewer == null ? new Base[0] : this.reviewer.toArray(new Base[this.reviewer.size()]); // ContactDetail
        case 1740277666: /*endorser*/ return this.endorser == null ? new Base[0] : this.endorser.toArray(new Base[this.endorser.size()]); // ContactDetail
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 1314395906: /*assertion*/ return this.assertion == null ? new Base[0] : new Base[] {this.assertion}; // MarkdownType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1807222545: /*variableDefinition*/ return this.variableDefinition == null ? new Base[0] : this.variableDefinition.toArray(new Base[this.variableDefinition.size()]); // EvidenceVariableDefinitionComponent
        case 672726254: /*synthesisType*/ return this.synthesisType == null ? new Base[0] : new Base[] {this.synthesisType}; // CodeableConcept
        case -1955265373: /*studyType*/ return this.studyType == null ? new Base[0] : new Base[] {this.studyType}; // CodeableConcept
        case -2081261232: /*statistic*/ return this.statistic == null ? new Base[0] : this.statistic.toArray(new Base[this.statistic.size()]); // Statistic
        case -1580708220: /*distribution*/ return this.distribution == null ? new Base[0] : this.distribution.toArray(new Base[this.distribution.size()]); // OrderedDistribution
        case -1404142937: /*certainty*/ return this.certainty == null ? new Base[0] : this.certainty.toArray(new Base[this.certainty.size()]); // EvidenceCertaintyComponent
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
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -1360156695: // citeAs
          this.citeAs = TypeConvertor.castToType(value); // DataType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        case 223539345: // approvalDate
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1687512484: // lastReviewDate
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case 1447404028: // publisher
          this.publisher = TypeConvertor.castToString(value); // StringType
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
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
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1314395906: // assertion
          this.assertion = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1807222545: // variableDefinition
          this.getVariableDefinition().add((EvidenceVariableDefinitionComponent) value); // EvidenceVariableDefinitionComponent
          return value;
        case 672726254: // synthesisType
          this.synthesisType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1955265373: // studyType
          this.studyType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -2081261232: // statistic
          this.getStatistic().add(TypeConvertor.castToStatistic(value)); // Statistic
          return value;
        case -1580708220: // distribution
          this.getDistribution().add(TypeConvertor.castToOrderedDistribution(value)); // OrderedDistribution
          return value;
        case -1404142937: // certainty
          this.getCertainty().add((EvidenceCertaintyComponent) value); // EvidenceCertaintyComponent
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
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("citeAs[x]")) {
          this.citeAs = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("approvalDate")) {
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactDetail(value));
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
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("assertion")) {
          this.assertion = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("variableDefinition")) {
          this.getVariableDefinition().add((EvidenceVariableDefinitionComponent) value);
        } else if (name.equals("synthesisType")) {
          this.synthesisType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("studyType")) {
          this.studyType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("statistic")) {
          this.getStatistic().add(TypeConvertor.castToStatistic(value));
        } else if (name.equals("distribution")) {
          this.getDistribution().add(TypeConvertor.castToOrderedDistribution(value));
        } else if (name.equals("certainty")) {
          this.getCertainty().add((EvidenceCertaintyComponent) value);
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
        case 110371416:  return getTitleElement();
        case -1706539017:  return getCiteAs();
        case -1360156695:  return getCiteAs();
        case -892481550:  return getStatusElement();
        case 3076014:  return getDateElement();
        case -669707736:  return addUseContext(); 
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1406328437:  return addAuthor(); 
        case -1307827859:  return addEditor(); 
        case -261190139:  return addReviewer(); 
        case 1740277666:  return addEndorser(); 
        case 666807069:  return addRelatedArtifact(); 
        case -1724546052:  return getDescriptionElement();
        case 1314395906:  return getAssertionElement();
        case 3387378:  return addNote(); 
        case -1807222545:  return addVariableDefinition(); 
        case 672726254:  return getSynthesisType();
        case -1955265373:  return getStudyType();
        case -2081261232:  return addStatistic(); 
        case -1580708220:  return addDistribution(); 
        case -1404142937:  return addCertainty(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -1360156695: /*citeAs*/ return new String[] {"Reference", "markdown"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1406328437: /*author*/ return new String[] {"ContactDetail"};
        case -1307827859: /*editor*/ return new String[] {"ContactDetail"};
        case -261190139: /*reviewer*/ return new String[] {"ContactDetail"};
        case 1740277666: /*endorser*/ return new String[] {"ContactDetail"};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 1314395906: /*assertion*/ return new String[] {"markdown"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -1807222545: /*variableDefinition*/ return new String[] {};
        case 672726254: /*synthesisType*/ return new String[] {"CodeableConcept"};
        case -1955265373: /*studyType*/ return new String[] {"CodeableConcept"};
        case -2081261232: /*statistic*/ return new String[] {"Statistic"};
        case -1580708220: /*distribution*/ return new String[] {"OrderedDistribution"};
        case -1404142937: /*certainty*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.version");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.title");
        }
        else if (name.equals("citeAsReference")) {
          this.citeAs = new Reference();
          return this.citeAs;
        }
        else if (name.equals("citeAsMarkdown")) {
          this.citeAs = new MarkdownType();
          return this.citeAs;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.status");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.date");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.lastReviewDate");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
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
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.description");
        }
        else if (name.equals("assertion")) {
          throw new FHIRException("Cannot call addChild on a primitive type Evidence.assertion");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("variableDefinition")) {
          return addVariableDefinition();
        }
        else if (name.equals("synthesisType")) {
          this.synthesisType = new CodeableConcept();
          return this.synthesisType;
        }
        else if (name.equals("studyType")) {
          this.studyType = new CodeableConcept();
          return this.studyType;
        }
        else if (name.equals("statistic")) {
          return addStatistic();
        }
        else if (name.equals("distribution")) {
          return addDistribution();
        }
        else if (name.equals("certainty")) {
          return addCertainty();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Evidence";

  }

      public Evidence copy() {
        Evidence dst = new Evidence();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Evidence dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.title = title == null ? null : title.copy();
        dst.citeAs = citeAs == null ? null : citeAs.copy();
        dst.status = status == null ? null : status.copy();
        dst.date = date == null ? null : date.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactDetail>();
          for (ContactDetail i : contact)
            dst.contact.add(i.copy());
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
        dst.description = description == null ? null : description.copy();
        dst.assertion = assertion == null ? null : assertion.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (variableDefinition != null) {
          dst.variableDefinition = new ArrayList<EvidenceVariableDefinitionComponent>();
          for (EvidenceVariableDefinitionComponent i : variableDefinition)
            dst.variableDefinition.add(i.copy());
        };
        dst.synthesisType = synthesisType == null ? null : synthesisType.copy();
        dst.studyType = studyType == null ? null : studyType.copy();
        if (statistic != null) {
          dst.statistic = new ArrayList<Statistic>();
          for (Statistic i : statistic)
            dst.statistic.add(i.copy());
        };
        if (distribution != null) {
          dst.distribution = new ArrayList<OrderedDistribution>();
          for (OrderedDistribution i : distribution)
            dst.distribution.add(i.copy());
        };
        if (certainty != null) {
          dst.certainty = new ArrayList<EvidenceCertaintyComponent>();
          for (EvidenceCertaintyComponent i : certainty)
            dst.certainty.add(i.copy());
        };
      }

      protected Evidence typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Evidence))
          return false;
        Evidence o = (Evidence) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(title, o.title, true) && compareDeep(citeAs, o.citeAs, true) && compareDeep(status, o.status, true)
           && compareDeep(date, o.date, true) && compareDeep(useContext, o.useContext, true) && compareDeep(approvalDate, o.approvalDate, true)
           && compareDeep(lastReviewDate, o.lastReviewDate, true) && compareDeep(publisher, o.publisher, true)
           && compareDeep(contact, o.contact, true) && compareDeep(author, o.author, true) && compareDeep(editor, o.editor, true)
           && compareDeep(reviewer, o.reviewer, true) && compareDeep(endorser, o.endorser, true) && compareDeep(relatedArtifact, o.relatedArtifact, true)
           && compareDeep(description, o.description, true) && compareDeep(assertion, o.assertion, true) && compareDeep(note, o.note, true)
           && compareDeep(variableDefinition, o.variableDefinition, true) && compareDeep(synthesisType, o.synthesisType, true)
           && compareDeep(studyType, o.studyType, true) && compareDeep(statistic, o.statistic, true) && compareDeep(distribution, o.distribution, true)
           && compareDeep(certainty, o.certainty, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Evidence))
          return false;
        Evidence o = (Evidence) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(title, o.title, true)
           && compareValues(status, o.status, true) && compareValues(date, o.date, true) && compareValues(approvalDate, o.approvalDate, true)
           && compareValues(lastReviewDate, o.lastReviewDate, true) && compareValues(publisher, o.publisher, true)
           && compareValues(description, o.description, true) && compareValues(assertion, o.assertion, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , title, citeAs, status, date, useContext, approvalDate, lastReviewDate, publisher
          , contact, author, editor, reviewer, endorser, relatedArtifact, description, assertion
          , note, variableDefinition, synthesisType, studyType, statistic, distribution, certainty
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Evidence;
   }

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the evidence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Evidence.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(Evidence.useContext.value as CodeableConcept)", description="A use context assigned to the evidence", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>A use context assigned to the evidence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(Evidence.useContext.value as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the evidence</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(Evidence.useContext.value as Quantity) | (Evidence.useContext.value as Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(Evidence.useContext.value as Quantity) | (Evidence.useContext.value as Range)", description="A quantity- or range-valued use context assigned to the evidence", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>A quantity- or range-valued use context assigned to the evidence</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(Evidence.useContext.value as Quantity) | (Evidence.useContext.value as Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the evidence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Evidence.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="Evidence.useContext.code", description="A type of use context assigned to the evidence", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>A type of use context assigned to the evidence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Evidence.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>The evidence publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Evidence.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="Evidence.date", description="The evidence publication date", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>The evidence publication date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Evidence.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>The description of the evidence</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Evidence.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="Evidence.description", description="The description of the evidence", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>The description of the evidence</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Evidence.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the evidence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Evidence.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Evidence.identifier", description="External identifier for the evidence", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifier for the evidence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Evidence.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the evidence</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Evidence.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="Evidence.publisher", description="Name of the publisher of the evidence", type="string" )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Name of the publisher of the evidence</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Evidence.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PUBLISHER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the evidence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Evidence.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Evidence.status", description="The current status of the evidence", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the evidence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Evidence.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the evidence</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Evidence.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="Evidence.title", description="The human-friendly name of the evidence", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>The human-friendly name of the evidence</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Evidence.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the evidence</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Evidence.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="Evidence.url", description="The uri that identifies the evidence", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the evidence</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>Evidence.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>The business version of the evidence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Evidence.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="Evidence.version", description="The business version of the evidence", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>The business version of the evidence</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Evidence.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the evidence</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Evidence.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="Evidence.useContext", description="A use context type and quantity- or range-based value assigned to the evidence", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>A use context type and quantity- or range-based value assigned to the evidence</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Evidence.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the evidence</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Evidence.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="Evidence.useContext", description="A use context type and value assigned to the evidence", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>A use context type and value assigned to the evidence</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>Evidence.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);


}

