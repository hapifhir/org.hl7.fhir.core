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
import java.math.*;
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
 * The Evidence Resource provides a machine-interpretable expression of an evidence concept including the evidence variables (e.g., population, exposures/interventions, comparators, outcomes, measured variables, confounding variables), the statistics, and the certainty of this evidence.
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
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/directness")
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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else if (name.equals("variableRole")) {
          this.variableRole = null;
        } else if (name.equals("observed")) {
          this.observed = null;
        } else if (name.equals("intended")) {
          this.intended = null;
        } else if (name.equals("directnessMatch")) {
          this.directnessMatch = null;
        } else
          super.removeChild(name, value);
        
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
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.variableDefinition.description");
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
    public static class EvidenceStatisticComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A description of the content value of the statistic.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of content", formalDefinition="A description of the content value of the statistic." )
        protected MarkdownType description;

        /**
         * Footnotes and/or explanatory notes.
         */
        @Child(name = "note", type = {Annotation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Footnotes and/or explanatory notes", formalDefinition="Footnotes and/or explanatory notes." )
        protected List<Annotation> note;

        /**
         * Type of statistic, e.g., relative risk.
         */
        @Child(name = "statisticType", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Type of statistic, e.g., relative risk", formalDefinition="Type of statistic, e.g., relative risk." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/statistic-type")
        protected CodeableConcept statisticType;

        /**
         * When the measured variable is handled categorically, the category element is used to define which category the statistic is reporting.
         */
        @Child(name = "category", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Associated category for categorical variable", formalDefinition="When the measured variable is handled categorically, the category element is used to define which category the statistic is reporting." )
        protected CodeableConcept category;

        /**
         * Statistic value.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Statistic value", formalDefinition="Statistic value." )
        protected Quantity quantity;

        /**
         * The number of events associated with the statistic, where the unit of analysis is different from numberAffected, sampleSize.knownDataCount and sampleSize.numberOfParticipants.
         */
        @Child(name = "numberOfEvents", type = {UnsignedIntType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The number of events associated with the statistic", formalDefinition="The number of events associated with the statistic, where the unit of analysis is different from numberAffected, sampleSize.knownDataCount and sampleSize.numberOfParticipants." )
        protected UnsignedIntType numberOfEvents;

        /**
         * The number of participants affected where the unit of analysis is the same as sampleSize.knownDataCount and sampleSize.numberOfParticipants.
         */
        @Child(name = "numberAffected", type = {UnsignedIntType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The number of participants affected", formalDefinition="The number of participants affected where the unit of analysis is the same as sampleSize.knownDataCount and sampleSize.numberOfParticipants." )
        protected UnsignedIntType numberAffected;

        /**
         * Number of samples in the statistic.
         */
        @Child(name = "sampleSize", type = {}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Number of samples in the statistic", formalDefinition="Number of samples in the statistic." )
        protected EvidenceStatisticSampleSizeComponent sampleSize;

        /**
         * A statistical attribute of the statistic such as a measure of heterogeneity.
         */
        @Child(name = "attributeEstimate", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="An attribute of the Statistic", formalDefinition="A statistical attribute of the statistic such as a measure of heterogeneity." )
        protected List<EvidenceStatisticAttributeEstimateComponent> attributeEstimate;

        /**
         * A component of the method to generate the statistic.
         */
        @Child(name = "modelCharacteristic", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="An aspect of the statistical model", formalDefinition="A component of the method to generate the statistic." )
        protected List<EvidenceStatisticModelCharacteristicComponent> modelCharacteristic;

        private static final long serialVersionUID = 1798829622L;

    /**
     * Constructor
     */
      public EvidenceStatisticComponent() {
        super();
      }

        /**
         * @return {@link #description} (A description of the content value of the statistic.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticComponent.description");
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
         * @param value {@link #description} (A description of the content value of the statistic.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public EvidenceStatisticComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A description of the content value of the statistic.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A description of the content value of the statistic.
         */
        public EvidenceStatisticComponent setDescription(String value) { 
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
        public EvidenceStatisticComponent setNote(List<Annotation> theNote) { 
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

        public EvidenceStatisticComponent addNote(Annotation t) { //3
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
         * @return {@link #statisticType} (Type of statistic, e.g., relative risk.)
         */
        public CodeableConcept getStatisticType() { 
          if (this.statisticType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticComponent.statisticType");
            else if (Configuration.doAutoCreate())
              this.statisticType = new CodeableConcept(); // cc
          return this.statisticType;
        }

        public boolean hasStatisticType() { 
          return this.statisticType != null && !this.statisticType.isEmpty();
        }

        /**
         * @param value {@link #statisticType} (Type of statistic, e.g., relative risk.)
         */
        public EvidenceStatisticComponent setStatisticType(CodeableConcept value) { 
          this.statisticType = value;
          return this;
        }

        /**
         * @return {@link #category} (When the measured variable is handled categorically, the category element is used to define which category the statistic is reporting.)
         */
        public CodeableConcept getCategory() { 
          if (this.category == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticComponent.category");
            else if (Configuration.doAutoCreate())
              this.category = new CodeableConcept(); // cc
          return this.category;
        }

        public boolean hasCategory() { 
          return this.category != null && !this.category.isEmpty();
        }

        /**
         * @param value {@link #category} (When the measured variable is handled categorically, the category element is used to define which category the statistic is reporting.)
         */
        public EvidenceStatisticComponent setCategory(CodeableConcept value) { 
          this.category = value;
          return this;
        }

        /**
         * @return {@link #quantity} (Statistic value.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (Statistic value.)
         */
        public EvidenceStatisticComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #numberOfEvents} (The number of events associated with the statistic, where the unit of analysis is different from numberAffected, sampleSize.knownDataCount and sampleSize.numberOfParticipants.). This is the underlying object with id, value and extensions. The accessor "getNumberOfEvents" gives direct access to the value
         */
        public UnsignedIntType getNumberOfEventsElement() { 
          if (this.numberOfEvents == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticComponent.numberOfEvents");
            else if (Configuration.doAutoCreate())
              this.numberOfEvents = new UnsignedIntType(); // bb
          return this.numberOfEvents;
        }

        public boolean hasNumberOfEventsElement() { 
          return this.numberOfEvents != null && !this.numberOfEvents.isEmpty();
        }

        public boolean hasNumberOfEvents() { 
          return this.numberOfEvents != null && !this.numberOfEvents.isEmpty();
        }

        /**
         * @param value {@link #numberOfEvents} (The number of events associated with the statistic, where the unit of analysis is different from numberAffected, sampleSize.knownDataCount and sampleSize.numberOfParticipants.). This is the underlying object with id, value and extensions. The accessor "getNumberOfEvents" gives direct access to the value
         */
        public EvidenceStatisticComponent setNumberOfEventsElement(UnsignedIntType value) { 
          this.numberOfEvents = value;
          return this;
        }

        /**
         * @return The number of events associated with the statistic, where the unit of analysis is different from numberAffected, sampleSize.knownDataCount and sampleSize.numberOfParticipants.
         */
        public int getNumberOfEvents() { 
          return this.numberOfEvents == null || this.numberOfEvents.isEmpty() ? 0 : this.numberOfEvents.getValue();
        }

        /**
         * @param value The number of events associated with the statistic, where the unit of analysis is different from numberAffected, sampleSize.knownDataCount and sampleSize.numberOfParticipants.
         */
        public EvidenceStatisticComponent setNumberOfEvents(int value) { 
            if (this.numberOfEvents == null)
              this.numberOfEvents = new UnsignedIntType();
            this.numberOfEvents.setValue(value);
          return this;
        }

        /**
         * @return {@link #numberAffected} (The number of participants affected where the unit of analysis is the same as sampleSize.knownDataCount and sampleSize.numberOfParticipants.). This is the underlying object with id, value and extensions. The accessor "getNumberAffected" gives direct access to the value
         */
        public UnsignedIntType getNumberAffectedElement() { 
          if (this.numberAffected == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticComponent.numberAffected");
            else if (Configuration.doAutoCreate())
              this.numberAffected = new UnsignedIntType(); // bb
          return this.numberAffected;
        }

        public boolean hasNumberAffectedElement() { 
          return this.numberAffected != null && !this.numberAffected.isEmpty();
        }

        public boolean hasNumberAffected() { 
          return this.numberAffected != null && !this.numberAffected.isEmpty();
        }

        /**
         * @param value {@link #numberAffected} (The number of participants affected where the unit of analysis is the same as sampleSize.knownDataCount and sampleSize.numberOfParticipants.). This is the underlying object with id, value and extensions. The accessor "getNumberAffected" gives direct access to the value
         */
        public EvidenceStatisticComponent setNumberAffectedElement(UnsignedIntType value) { 
          this.numberAffected = value;
          return this;
        }

        /**
         * @return The number of participants affected where the unit of analysis is the same as sampleSize.knownDataCount and sampleSize.numberOfParticipants.
         */
        public int getNumberAffected() { 
          return this.numberAffected == null || this.numberAffected.isEmpty() ? 0 : this.numberAffected.getValue();
        }

        /**
         * @param value The number of participants affected where the unit of analysis is the same as sampleSize.knownDataCount and sampleSize.numberOfParticipants.
         */
        public EvidenceStatisticComponent setNumberAffected(int value) { 
            if (this.numberAffected == null)
              this.numberAffected = new UnsignedIntType();
            this.numberAffected.setValue(value);
          return this;
        }

        /**
         * @return {@link #sampleSize} (Number of samples in the statistic.)
         */
        public EvidenceStatisticSampleSizeComponent getSampleSize() { 
          if (this.sampleSize == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticComponent.sampleSize");
            else if (Configuration.doAutoCreate())
              this.sampleSize = new EvidenceStatisticSampleSizeComponent(); // cc
          return this.sampleSize;
        }

        public boolean hasSampleSize() { 
          return this.sampleSize != null && !this.sampleSize.isEmpty();
        }

        /**
         * @param value {@link #sampleSize} (Number of samples in the statistic.)
         */
        public EvidenceStatisticComponent setSampleSize(EvidenceStatisticSampleSizeComponent value) { 
          this.sampleSize = value;
          return this;
        }

        /**
         * @return {@link #attributeEstimate} (A statistical attribute of the statistic such as a measure of heterogeneity.)
         */
        public List<EvidenceStatisticAttributeEstimateComponent> getAttributeEstimate() { 
          if (this.attributeEstimate == null)
            this.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          return this.attributeEstimate;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceStatisticComponent setAttributeEstimate(List<EvidenceStatisticAttributeEstimateComponent> theAttributeEstimate) { 
          this.attributeEstimate = theAttributeEstimate;
          return this;
        }

        public boolean hasAttributeEstimate() { 
          if (this.attributeEstimate == null)
            return false;
          for (EvidenceStatisticAttributeEstimateComponent item : this.attributeEstimate)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public EvidenceStatisticAttributeEstimateComponent addAttributeEstimate() { //3
          EvidenceStatisticAttributeEstimateComponent t = new EvidenceStatisticAttributeEstimateComponent();
          if (this.attributeEstimate == null)
            this.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          this.attributeEstimate.add(t);
          return t;
        }

        public EvidenceStatisticComponent addAttributeEstimate(EvidenceStatisticAttributeEstimateComponent t) { //3
          if (t == null)
            return this;
          if (this.attributeEstimate == null)
            this.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          this.attributeEstimate.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #attributeEstimate}, creating it if it does not already exist {3}
         */
        public EvidenceStatisticAttributeEstimateComponent getAttributeEstimateFirstRep() { 
          if (getAttributeEstimate().isEmpty()) {
            addAttributeEstimate();
          }
          return getAttributeEstimate().get(0);
        }

        /**
         * @return {@link #modelCharacteristic} (A component of the method to generate the statistic.)
         */
        public List<EvidenceStatisticModelCharacteristicComponent> getModelCharacteristic() { 
          if (this.modelCharacteristic == null)
            this.modelCharacteristic = new ArrayList<EvidenceStatisticModelCharacteristicComponent>();
          return this.modelCharacteristic;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceStatisticComponent setModelCharacteristic(List<EvidenceStatisticModelCharacteristicComponent> theModelCharacteristic) { 
          this.modelCharacteristic = theModelCharacteristic;
          return this;
        }

        public boolean hasModelCharacteristic() { 
          if (this.modelCharacteristic == null)
            return false;
          for (EvidenceStatisticModelCharacteristicComponent item : this.modelCharacteristic)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public EvidenceStatisticModelCharacteristicComponent addModelCharacteristic() { //3
          EvidenceStatisticModelCharacteristicComponent t = new EvidenceStatisticModelCharacteristicComponent();
          if (this.modelCharacteristic == null)
            this.modelCharacteristic = new ArrayList<EvidenceStatisticModelCharacteristicComponent>();
          this.modelCharacteristic.add(t);
          return t;
        }

        public EvidenceStatisticComponent addModelCharacteristic(EvidenceStatisticModelCharacteristicComponent t) { //3
          if (t == null)
            return this;
          if (this.modelCharacteristic == null)
            this.modelCharacteristic = new ArrayList<EvidenceStatisticModelCharacteristicComponent>();
          this.modelCharacteristic.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #modelCharacteristic}, creating it if it does not already exist {3}
         */
        public EvidenceStatisticModelCharacteristicComponent getModelCharacteristicFirstRep() { 
          if (getModelCharacteristic().isEmpty()) {
            addModelCharacteristic();
          }
          return getModelCharacteristic().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "A description of the content value of the statistic.", 0, 1, description));
          children.add(new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("statisticType", "CodeableConcept", "Type of statistic, e.g., relative risk.", 0, 1, statisticType));
          children.add(new Property("category", "CodeableConcept", "When the measured variable is handled categorically, the category element is used to define which category the statistic is reporting.", 0, 1, category));
          children.add(new Property("quantity", "Quantity", "Statistic value.", 0, 1, quantity));
          children.add(new Property("numberOfEvents", "unsignedInt", "The number of events associated with the statistic, where the unit of analysis is different from numberAffected, sampleSize.knownDataCount and sampleSize.numberOfParticipants.", 0, 1, numberOfEvents));
          children.add(new Property("numberAffected", "unsignedInt", "The number of participants affected where the unit of analysis is the same as sampleSize.knownDataCount and sampleSize.numberOfParticipants.", 0, 1, numberAffected));
          children.add(new Property("sampleSize", "", "Number of samples in the statistic.", 0, 1, sampleSize));
          children.add(new Property("attributeEstimate", "", "A statistical attribute of the statistic such as a measure of heterogeneity.", 0, java.lang.Integer.MAX_VALUE, attributeEstimate));
          children.add(new Property("modelCharacteristic", "", "A component of the method to generate the statistic.", 0, java.lang.Integer.MAX_VALUE, modelCharacteristic));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "A description of the content value of the statistic.", 0, 1, description);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note);
          case -392342358: /*statisticType*/  return new Property("statisticType", "CodeableConcept", "Type of statistic, e.g., relative risk.", 0, 1, statisticType);
          case 50511102: /*category*/  return new Property("category", "CodeableConcept", "When the measured variable is handled categorically, the category element is used to define which category the statistic is reporting.", 0, 1, category);
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "Statistic value.", 0, 1, quantity);
          case 1534510137: /*numberOfEvents*/  return new Property("numberOfEvents", "unsignedInt", "The number of events associated with the statistic, where the unit of analysis is different from numberAffected, sampleSize.knownDataCount and sampleSize.numberOfParticipants.", 0, 1, numberOfEvents);
          case -460990243: /*numberAffected*/  return new Property("numberAffected", "unsignedInt", "The number of participants affected where the unit of analysis is the same as sampleSize.knownDataCount and sampleSize.numberOfParticipants.", 0, 1, numberAffected);
          case 143123659: /*sampleSize*/  return new Property("sampleSize", "", "Number of samples in the statistic.", 0, 1, sampleSize);
          case -1539581980: /*attributeEstimate*/  return new Property("attributeEstimate", "", "A statistical attribute of the statistic such as a measure of heterogeneity.", 0, java.lang.Integer.MAX_VALUE, attributeEstimate);
          case 274795812: /*modelCharacteristic*/  return new Property("modelCharacteristic", "", "A component of the method to generate the statistic.", 0, java.lang.Integer.MAX_VALUE, modelCharacteristic);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -392342358: /*statisticType*/ return this.statisticType == null ? new Base[0] : new Base[] {this.statisticType}; // CodeableConcept
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 1534510137: /*numberOfEvents*/ return this.numberOfEvents == null ? new Base[0] : new Base[] {this.numberOfEvents}; // UnsignedIntType
        case -460990243: /*numberAffected*/ return this.numberAffected == null ? new Base[0] : new Base[] {this.numberAffected}; // UnsignedIntType
        case 143123659: /*sampleSize*/ return this.sampleSize == null ? new Base[0] : new Base[] {this.sampleSize}; // EvidenceStatisticSampleSizeComponent
        case -1539581980: /*attributeEstimate*/ return this.attributeEstimate == null ? new Base[0] : this.attributeEstimate.toArray(new Base[this.attributeEstimate.size()]); // EvidenceStatisticAttributeEstimateComponent
        case 274795812: /*modelCharacteristic*/ return this.modelCharacteristic == null ? new Base[0] : this.modelCharacteristic.toArray(new Base[this.modelCharacteristic.size()]); // EvidenceStatisticModelCharacteristicComponent
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
        case -392342358: // statisticType
          this.statisticType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 50511102: // category
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 1534510137: // numberOfEvents
          this.numberOfEvents = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case -460990243: // numberAffected
          this.numberAffected = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 143123659: // sampleSize
          this.sampleSize = (EvidenceStatisticSampleSizeComponent) value; // EvidenceStatisticSampleSizeComponent
          return value;
        case -1539581980: // attributeEstimate
          this.getAttributeEstimate().add((EvidenceStatisticAttributeEstimateComponent) value); // EvidenceStatisticAttributeEstimateComponent
          return value;
        case 274795812: // modelCharacteristic
          this.getModelCharacteristic().add((EvidenceStatisticModelCharacteristicComponent) value); // EvidenceStatisticModelCharacteristicComponent
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
        } else if (name.equals("statisticType")) {
          this.statisticType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("category")) {
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("numberOfEvents")) {
          this.numberOfEvents = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("numberAffected")) {
          this.numberAffected = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("sampleSize")) {
          this.sampleSize = (EvidenceStatisticSampleSizeComponent) value; // EvidenceStatisticSampleSizeComponent
        } else if (name.equals("attributeEstimate")) {
          this.getAttributeEstimate().add((EvidenceStatisticAttributeEstimateComponent) value);
        } else if (name.equals("modelCharacteristic")) {
          this.getModelCharacteristic().add((EvidenceStatisticModelCharacteristicComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else if (name.equals("statisticType")) {
          this.statisticType = null;
        } else if (name.equals("category")) {
          this.category = null;
        } else if (name.equals("quantity")) {
          this.quantity = null;
        } else if (name.equals("numberOfEvents")) {
          this.numberOfEvents = null;
        } else if (name.equals("numberAffected")) {
          this.numberAffected = null;
        } else if (name.equals("sampleSize")) {
          this.sampleSize = (EvidenceStatisticSampleSizeComponent) value; // EvidenceStatisticSampleSizeComponent
        } else if (name.equals("attributeEstimate")) {
          this.getAttributeEstimate().add((EvidenceStatisticAttributeEstimateComponent) value);
        } else if (name.equals("modelCharacteristic")) {
          this.getModelCharacteristic().add((EvidenceStatisticModelCharacteristicComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 3387378:  return addNote(); 
        case -392342358:  return getStatisticType();
        case 50511102:  return getCategory();
        case -1285004149:  return getQuantity();
        case 1534510137:  return getNumberOfEventsElement();
        case -460990243:  return getNumberAffectedElement();
        case 143123659:  return getSampleSize();
        case -1539581980:  return addAttributeEstimate(); 
        case 274795812:  return addModelCharacteristic(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -392342358: /*statisticType*/ return new String[] {"CodeableConcept"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 1534510137: /*numberOfEvents*/ return new String[] {"unsignedInt"};
        case -460990243: /*numberAffected*/ return new String[] {"unsignedInt"};
        case 143123659: /*sampleSize*/ return new String[] {};
        case -1539581980: /*attributeEstimate*/ return new String[] {};
        case 274795812: /*modelCharacteristic*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.statistic.description");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("statisticType")) {
          this.statisticType = new CodeableConcept();
          return this.statisticType;
        }
        else if (name.equals("category")) {
          this.category = new CodeableConcept();
          return this.category;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("numberOfEvents")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.statistic.numberOfEvents");
        }
        else if (name.equals("numberAffected")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.statistic.numberAffected");
        }
        else if (name.equals("sampleSize")) {
          this.sampleSize = new EvidenceStatisticSampleSizeComponent();
          return this.sampleSize;
        }
        else if (name.equals("attributeEstimate")) {
          return addAttributeEstimate();
        }
        else if (name.equals("modelCharacteristic")) {
          return addModelCharacteristic();
        }
        else
          return super.addChild(name);
      }

      public EvidenceStatisticComponent copy() {
        EvidenceStatisticComponent dst = new EvidenceStatisticComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceStatisticComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.statisticType = statisticType == null ? null : statisticType.copy();
        dst.category = category == null ? null : category.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.numberOfEvents = numberOfEvents == null ? null : numberOfEvents.copy();
        dst.numberAffected = numberAffected == null ? null : numberAffected.copy();
        dst.sampleSize = sampleSize == null ? null : sampleSize.copy();
        if (attributeEstimate != null) {
          dst.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          for (EvidenceStatisticAttributeEstimateComponent i : attributeEstimate)
            dst.attributeEstimate.add(i.copy());
        };
        if (modelCharacteristic != null) {
          dst.modelCharacteristic = new ArrayList<EvidenceStatisticModelCharacteristicComponent>();
          for (EvidenceStatisticModelCharacteristicComponent i : modelCharacteristic)
            dst.modelCharacteristic.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceStatisticComponent))
          return false;
        EvidenceStatisticComponent o = (EvidenceStatisticComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(statisticType, o.statisticType, true)
           && compareDeep(category, o.category, true) && compareDeep(quantity, o.quantity, true) && compareDeep(numberOfEvents, o.numberOfEvents, true)
           && compareDeep(numberAffected, o.numberAffected, true) && compareDeep(sampleSize, o.sampleSize, true)
           && compareDeep(attributeEstimate, o.attributeEstimate, true) && compareDeep(modelCharacteristic, o.modelCharacteristic, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceStatisticComponent))
          return false;
        EvidenceStatisticComponent o = (EvidenceStatisticComponent) other_;
        return compareValues(description, o.description, true) && compareValues(numberOfEvents, o.numberOfEvents, true)
           && compareValues(numberAffected, o.numberAffected, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, statisticType
          , category, quantity, numberOfEvents, numberAffected, sampleSize, attributeEstimate
          , modelCharacteristic);
      }

  public String fhirType() {
    return "Evidence.statistic";

  }

  }

    @Block()
    public static class EvidenceStatisticSampleSizeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Human-readable summary of population sample size.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Textual description of sample size for statistic", formalDefinition="Human-readable summary of population sample size." )
        protected MarkdownType description;

        /**
         * Footnote or explanatory note about the sample size.
         */
        @Child(name = "note", type = {Annotation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Footnote or explanatory note about the sample size", formalDefinition="Footnote or explanatory note about the sample size." )
        protected List<Annotation> note;

        /**
         * Number of participants in the population.
         */
        @Child(name = "numberOfStudies", type = {UnsignedIntType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Number of contributing studies", formalDefinition="Number of participants in the population." )
        protected UnsignedIntType numberOfStudies;

        /**
         * A human-readable string to clarify or explain concepts about the sample size.
         */
        @Child(name = "numberOfParticipants", type = {UnsignedIntType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Cumulative number of participants", formalDefinition="A human-readable string to clarify or explain concepts about the sample size." )
        protected UnsignedIntType numberOfParticipants;

        /**
         * Number of participants with known results for measured variables.
         */
        @Child(name = "knownDataCount", type = {UnsignedIntType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Number of participants with known results for measured variables", formalDefinition="Number of participants with known results for measured variables." )
        protected UnsignedIntType knownDataCount;

        private static final long serialVersionUID = -1710653289L;

    /**
     * Constructor
     */
      public EvidenceStatisticSampleSizeComponent() {
        super();
      }

        /**
         * @return {@link #description} (Human-readable summary of population sample size.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticSampleSizeComponent.description");
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
         * @param value {@link #description} (Human-readable summary of population sample size.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public EvidenceStatisticSampleSizeComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Human-readable summary of population sample size.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Human-readable summary of population sample size.
         */
        public EvidenceStatisticSampleSizeComponent setDescription(String value) { 
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
         * @return {@link #note} (Footnote or explanatory note about the sample size.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceStatisticSampleSizeComponent setNote(List<Annotation> theNote) { 
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

        public EvidenceStatisticSampleSizeComponent addNote(Annotation t) { //3
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
         * @return {@link #numberOfStudies} (Number of participants in the population.). This is the underlying object with id, value and extensions. The accessor "getNumberOfStudies" gives direct access to the value
         */
        public UnsignedIntType getNumberOfStudiesElement() { 
          if (this.numberOfStudies == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticSampleSizeComponent.numberOfStudies");
            else if (Configuration.doAutoCreate())
              this.numberOfStudies = new UnsignedIntType(); // bb
          return this.numberOfStudies;
        }

        public boolean hasNumberOfStudiesElement() { 
          return this.numberOfStudies != null && !this.numberOfStudies.isEmpty();
        }

        public boolean hasNumberOfStudies() { 
          return this.numberOfStudies != null && !this.numberOfStudies.isEmpty();
        }

        /**
         * @param value {@link #numberOfStudies} (Number of participants in the population.). This is the underlying object with id, value and extensions. The accessor "getNumberOfStudies" gives direct access to the value
         */
        public EvidenceStatisticSampleSizeComponent setNumberOfStudiesElement(UnsignedIntType value) { 
          this.numberOfStudies = value;
          return this;
        }

        /**
         * @return Number of participants in the population.
         */
        public int getNumberOfStudies() { 
          return this.numberOfStudies == null || this.numberOfStudies.isEmpty() ? 0 : this.numberOfStudies.getValue();
        }

        /**
         * @param value Number of participants in the population.
         */
        public EvidenceStatisticSampleSizeComponent setNumberOfStudies(int value) { 
            if (this.numberOfStudies == null)
              this.numberOfStudies = new UnsignedIntType();
            this.numberOfStudies.setValue(value);
          return this;
        }

        /**
         * @return {@link #numberOfParticipants} (A human-readable string to clarify or explain concepts about the sample size.). This is the underlying object with id, value and extensions. The accessor "getNumberOfParticipants" gives direct access to the value
         */
        public UnsignedIntType getNumberOfParticipantsElement() { 
          if (this.numberOfParticipants == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticSampleSizeComponent.numberOfParticipants");
            else if (Configuration.doAutoCreate())
              this.numberOfParticipants = new UnsignedIntType(); // bb
          return this.numberOfParticipants;
        }

        public boolean hasNumberOfParticipantsElement() { 
          return this.numberOfParticipants != null && !this.numberOfParticipants.isEmpty();
        }

        public boolean hasNumberOfParticipants() { 
          return this.numberOfParticipants != null && !this.numberOfParticipants.isEmpty();
        }

        /**
         * @param value {@link #numberOfParticipants} (A human-readable string to clarify or explain concepts about the sample size.). This is the underlying object with id, value and extensions. The accessor "getNumberOfParticipants" gives direct access to the value
         */
        public EvidenceStatisticSampleSizeComponent setNumberOfParticipantsElement(UnsignedIntType value) { 
          this.numberOfParticipants = value;
          return this;
        }

        /**
         * @return A human-readable string to clarify or explain concepts about the sample size.
         */
        public int getNumberOfParticipants() { 
          return this.numberOfParticipants == null || this.numberOfParticipants.isEmpty() ? 0 : this.numberOfParticipants.getValue();
        }

        /**
         * @param value A human-readable string to clarify or explain concepts about the sample size.
         */
        public EvidenceStatisticSampleSizeComponent setNumberOfParticipants(int value) { 
            if (this.numberOfParticipants == null)
              this.numberOfParticipants = new UnsignedIntType();
            this.numberOfParticipants.setValue(value);
          return this;
        }

        /**
         * @return {@link #knownDataCount} (Number of participants with known results for measured variables.). This is the underlying object with id, value and extensions. The accessor "getKnownDataCount" gives direct access to the value
         */
        public UnsignedIntType getKnownDataCountElement() { 
          if (this.knownDataCount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticSampleSizeComponent.knownDataCount");
            else if (Configuration.doAutoCreate())
              this.knownDataCount = new UnsignedIntType(); // bb
          return this.knownDataCount;
        }

        public boolean hasKnownDataCountElement() { 
          return this.knownDataCount != null && !this.knownDataCount.isEmpty();
        }

        public boolean hasKnownDataCount() { 
          return this.knownDataCount != null && !this.knownDataCount.isEmpty();
        }

        /**
         * @param value {@link #knownDataCount} (Number of participants with known results for measured variables.). This is the underlying object with id, value and extensions. The accessor "getKnownDataCount" gives direct access to the value
         */
        public EvidenceStatisticSampleSizeComponent setKnownDataCountElement(UnsignedIntType value) { 
          this.knownDataCount = value;
          return this;
        }

        /**
         * @return Number of participants with known results for measured variables.
         */
        public int getKnownDataCount() { 
          return this.knownDataCount == null || this.knownDataCount.isEmpty() ? 0 : this.knownDataCount.getValue();
        }

        /**
         * @param value Number of participants with known results for measured variables.
         */
        public EvidenceStatisticSampleSizeComponent setKnownDataCount(int value) { 
            if (this.knownDataCount == null)
              this.knownDataCount = new UnsignedIntType();
            this.knownDataCount.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "Human-readable summary of population sample size.", 0, 1, description));
          children.add(new Property("note", "Annotation", "Footnote or explanatory note about the sample size.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("numberOfStudies", "unsignedInt", "Number of participants in the population.", 0, 1, numberOfStudies));
          children.add(new Property("numberOfParticipants", "unsignedInt", "A human-readable string to clarify or explain concepts about the sample size.", 0, 1, numberOfParticipants));
          children.add(new Property("knownDataCount", "unsignedInt", "Number of participants with known results for measured variables.", 0, 1, knownDataCount));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "Human-readable summary of population sample size.", 0, 1, description);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Footnote or explanatory note about the sample size.", 0, java.lang.Integer.MAX_VALUE, note);
          case -177467129: /*numberOfStudies*/  return new Property("numberOfStudies", "unsignedInt", "Number of participants in the population.", 0, 1, numberOfStudies);
          case 1799357120: /*numberOfParticipants*/  return new Property("numberOfParticipants", "unsignedInt", "A human-readable string to clarify or explain concepts about the sample size.", 0, 1, numberOfParticipants);
          case -937344126: /*knownDataCount*/  return new Property("knownDataCount", "unsignedInt", "Number of participants with known results for measured variables.", 0, 1, knownDataCount);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -177467129: /*numberOfStudies*/ return this.numberOfStudies == null ? new Base[0] : new Base[] {this.numberOfStudies}; // UnsignedIntType
        case 1799357120: /*numberOfParticipants*/ return this.numberOfParticipants == null ? new Base[0] : new Base[] {this.numberOfParticipants}; // UnsignedIntType
        case -937344126: /*knownDataCount*/ return this.knownDataCount == null ? new Base[0] : new Base[] {this.knownDataCount}; // UnsignedIntType
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
        case -177467129: // numberOfStudies
          this.numberOfStudies = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case 1799357120: // numberOfParticipants
          this.numberOfParticipants = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
          return value;
        case -937344126: // knownDataCount
          this.knownDataCount = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
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
        } else if (name.equals("numberOfStudies")) {
          this.numberOfStudies = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("numberOfParticipants")) {
          this.numberOfParticipants = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else if (name.equals("knownDataCount")) {
          this.knownDataCount = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else if (name.equals("numberOfStudies")) {
          this.numberOfStudies = null;
        } else if (name.equals("numberOfParticipants")) {
          this.numberOfParticipants = null;
        } else if (name.equals("knownDataCount")) {
          this.knownDataCount = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 3387378:  return addNote(); 
        case -177467129:  return getNumberOfStudiesElement();
        case 1799357120:  return getNumberOfParticipantsElement();
        case -937344126:  return getKnownDataCountElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -177467129: /*numberOfStudies*/ return new String[] {"unsignedInt"};
        case 1799357120: /*numberOfParticipants*/ return new String[] {"unsignedInt"};
        case -937344126: /*knownDataCount*/ return new String[] {"unsignedInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.statistic.sampleSize.description");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("numberOfStudies")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.statistic.sampleSize.numberOfStudies");
        }
        else if (name.equals("numberOfParticipants")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.statistic.sampleSize.numberOfParticipants");
        }
        else if (name.equals("knownDataCount")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.statistic.sampleSize.knownDataCount");
        }
        else
          return super.addChild(name);
      }

      public EvidenceStatisticSampleSizeComponent copy() {
        EvidenceStatisticSampleSizeComponent dst = new EvidenceStatisticSampleSizeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceStatisticSampleSizeComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.numberOfStudies = numberOfStudies == null ? null : numberOfStudies.copy();
        dst.numberOfParticipants = numberOfParticipants == null ? null : numberOfParticipants.copy();
        dst.knownDataCount = knownDataCount == null ? null : knownDataCount.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceStatisticSampleSizeComponent))
          return false;
        EvidenceStatisticSampleSizeComponent o = (EvidenceStatisticSampleSizeComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(numberOfStudies, o.numberOfStudies, true)
           && compareDeep(numberOfParticipants, o.numberOfParticipants, true) && compareDeep(knownDataCount, o.knownDataCount, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceStatisticSampleSizeComponent))
          return false;
        EvidenceStatisticSampleSizeComponent o = (EvidenceStatisticSampleSizeComponent) other_;
        return compareValues(description, o.description, true) && compareValues(numberOfStudies, o.numberOfStudies, true)
           && compareValues(numberOfParticipants, o.numberOfParticipants, true) && compareValues(knownDataCount, o.knownDataCount, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, numberOfStudies
          , numberOfParticipants, knownDataCount);
      }

  public String fhirType() {
    return "Evidence.statistic.sampleSize";

  }

  }

    @Block()
    public static class EvidenceStatisticAttributeEstimateComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Human-readable summary of the estimate.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Textual description of the attribute estimate", formalDefinition="Human-readable summary of the estimate." )
        protected MarkdownType description;

        /**
         * Footnote or explanatory note about the estimate.
         */
        @Child(name = "note", type = {Annotation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Footnote or explanatory note about the estimate", formalDefinition="Footnote or explanatory note about the estimate." )
        protected List<Annotation> note;

        /**
         * The type of attribute estimate, e.g., confidence interval or p value.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The type of attribute estimate, e.g., confidence interval or p value", formalDefinition="The type of attribute estimate, e.g., confidence interval or p value." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/attribute-estimate-type")
        protected CodeableConcept type;

        /**
         * The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure", formalDefinition="The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure." )
        protected Quantity quantity;

        /**
         * Use 95 for a 95% confidence interval.
         */
        @Child(name = "level", type = {DecimalType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Level of confidence interval, e.g., 0.95 for 95% confidence interval", formalDefinition="Use 95 for a 95% confidence interval." )
        protected DecimalType level;

        /**
         * Lower bound of confidence interval.
         */
        @Child(name = "range", type = {Range.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Lower and upper bound values of the attribute estimate", formalDefinition="Lower bound of confidence interval." )
        protected Range range;

        /**
         * A nested attribute estimate; which is the attribute estimate of an attribute estimate.
         */
        @Child(name = "attributeEstimate", type = {EvidenceStatisticAttributeEstimateComponent.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A nested attribute estimate; which is the attribute estimate of an attribute estimate", formalDefinition="A nested attribute estimate; which is the attribute estimate of an attribute estimate." )
        protected List<EvidenceStatisticAttributeEstimateComponent> attributeEstimate;

        private static final long serialVersionUID = -1535970380L;

    /**
     * Constructor
     */
      public EvidenceStatisticAttributeEstimateComponent() {
        super();
      }

        /**
         * @return {@link #description} (Human-readable summary of the estimate.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticAttributeEstimateComponent.description");
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
         * @param value {@link #description} (Human-readable summary of the estimate.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public EvidenceStatisticAttributeEstimateComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return Human-readable summary of the estimate.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value Human-readable summary of the estimate.
         */
        public EvidenceStatisticAttributeEstimateComponent setDescription(String value) { 
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
         * @return {@link #note} (Footnote or explanatory note about the estimate.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceStatisticAttributeEstimateComponent setNote(List<Annotation> theNote) { 
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

        public EvidenceStatisticAttributeEstimateComponent addNote(Annotation t) { //3
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
         * @return {@link #type} (The type of attribute estimate, e.g., confidence interval or p value.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticAttributeEstimateComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of attribute estimate, e.g., confidence interval or p value.)
         */
        public EvidenceStatisticAttributeEstimateComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #quantity} (The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticAttributeEstimateComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.)
         */
        public EvidenceStatisticAttributeEstimateComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #level} (Use 95 for a 95% confidence interval.). This is the underlying object with id, value and extensions. The accessor "getLevel" gives direct access to the value
         */
        public DecimalType getLevelElement() { 
          if (this.level == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticAttributeEstimateComponent.level");
            else if (Configuration.doAutoCreate())
              this.level = new DecimalType(); // bb
          return this.level;
        }

        public boolean hasLevelElement() { 
          return this.level != null && !this.level.isEmpty();
        }

        public boolean hasLevel() { 
          return this.level != null && !this.level.isEmpty();
        }

        /**
         * @param value {@link #level} (Use 95 for a 95% confidence interval.). This is the underlying object with id, value and extensions. The accessor "getLevel" gives direct access to the value
         */
        public EvidenceStatisticAttributeEstimateComponent setLevelElement(DecimalType value) { 
          this.level = value;
          return this;
        }

        /**
         * @return Use 95 for a 95% confidence interval.
         */
        public BigDecimal getLevel() { 
          return this.level == null ? null : this.level.getValue();
        }

        /**
         * @param value Use 95 for a 95% confidence interval.
         */
        public EvidenceStatisticAttributeEstimateComponent setLevel(BigDecimal value) { 
          if (value == null)
            this.level = null;
          else {
            if (this.level == null)
              this.level = new DecimalType();
            this.level.setValue(value);
          }
          return this;
        }

        /**
         * @param value Use 95 for a 95% confidence interval.
         */
        public EvidenceStatisticAttributeEstimateComponent setLevel(long value) { 
              this.level = new DecimalType();
            this.level.setValue(value);
          return this;
        }

        /**
         * @param value Use 95 for a 95% confidence interval.
         */
        public EvidenceStatisticAttributeEstimateComponent setLevel(double value) { 
              this.level = new DecimalType();
            this.level.setValue(value);
          return this;
        }

        /**
         * @return {@link #range} (Lower bound of confidence interval.)
         */
        public Range getRange() { 
          if (this.range == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticAttributeEstimateComponent.range");
            else if (Configuration.doAutoCreate())
              this.range = new Range(); // cc
          return this.range;
        }

        public boolean hasRange() { 
          return this.range != null && !this.range.isEmpty();
        }

        /**
         * @param value {@link #range} (Lower bound of confidence interval.)
         */
        public EvidenceStatisticAttributeEstimateComponent setRange(Range value) { 
          this.range = value;
          return this;
        }

        /**
         * @return {@link #attributeEstimate} (A nested attribute estimate; which is the attribute estimate of an attribute estimate.)
         */
        public List<EvidenceStatisticAttributeEstimateComponent> getAttributeEstimate() { 
          if (this.attributeEstimate == null)
            this.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          return this.attributeEstimate;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceStatisticAttributeEstimateComponent setAttributeEstimate(List<EvidenceStatisticAttributeEstimateComponent> theAttributeEstimate) { 
          this.attributeEstimate = theAttributeEstimate;
          return this;
        }

        public boolean hasAttributeEstimate() { 
          if (this.attributeEstimate == null)
            return false;
          for (EvidenceStatisticAttributeEstimateComponent item : this.attributeEstimate)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public EvidenceStatisticAttributeEstimateComponent addAttributeEstimate() { //3
          EvidenceStatisticAttributeEstimateComponent t = new EvidenceStatisticAttributeEstimateComponent();
          if (this.attributeEstimate == null)
            this.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          this.attributeEstimate.add(t);
          return t;
        }

        public EvidenceStatisticAttributeEstimateComponent addAttributeEstimate(EvidenceStatisticAttributeEstimateComponent t) { //3
          if (t == null)
            return this;
          if (this.attributeEstimate == null)
            this.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          this.attributeEstimate.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #attributeEstimate}, creating it if it does not already exist {3}
         */
        public EvidenceStatisticAttributeEstimateComponent getAttributeEstimateFirstRep() { 
          if (getAttributeEstimate().isEmpty()) {
            addAttributeEstimate();
          }
          return getAttributeEstimate().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "markdown", "Human-readable summary of the estimate.", 0, 1, description));
          children.add(new Property("note", "Annotation", "Footnote or explanatory note about the estimate.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("type", "CodeableConcept", "The type of attribute estimate, e.g., confidence interval or p value.", 0, 1, type));
          children.add(new Property("quantity", "Quantity", "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.", 0, 1, quantity));
          children.add(new Property("level", "decimal", "Use 95 for a 95% confidence interval.", 0, 1, level));
          children.add(new Property("range", "Range", "Lower bound of confidence interval.", 0, 1, range));
          children.add(new Property("attributeEstimate", "@Evidence.statistic.attributeEstimate", "A nested attribute estimate; which is the attribute estimate of an attribute estimate.", 0, java.lang.Integer.MAX_VALUE, attributeEstimate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "Human-readable summary of the estimate.", 0, 1, description);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Footnote or explanatory note about the estimate.", 0, java.lang.Integer.MAX_VALUE, note);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of attribute estimate, e.g., confidence interval or p value.", 0, 1, type);
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.", 0, 1, quantity);
          case 102865796: /*level*/  return new Property("level", "decimal", "Use 95 for a 95% confidence interval.", 0, 1, level);
          case 108280125: /*range*/  return new Property("range", "Range", "Lower bound of confidence interval.", 0, 1, range);
          case -1539581980: /*attributeEstimate*/  return new Property("attributeEstimate", "@Evidence.statistic.attributeEstimate", "A nested attribute estimate; which is the attribute estimate of an attribute estimate.", 0, java.lang.Integer.MAX_VALUE, attributeEstimate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 102865796: /*level*/ return this.level == null ? new Base[0] : new Base[] {this.level}; // DecimalType
        case 108280125: /*range*/ return this.range == null ? new Base[0] : new Base[] {this.range}; // Range
        case -1539581980: /*attributeEstimate*/ return this.attributeEstimate == null ? new Base[0] : this.attributeEstimate.toArray(new Base[this.attributeEstimate.size()]); // EvidenceStatisticAttributeEstimateComponent
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
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 102865796: // level
          this.level = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 108280125: // range
          this.range = TypeConvertor.castToRange(value); // Range
          return value;
        case -1539581980: // attributeEstimate
          this.getAttributeEstimate().add((EvidenceStatisticAttributeEstimateComponent) value); // EvidenceStatisticAttributeEstimateComponent
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
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("level")) {
          this.level = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("range")) {
          this.range = TypeConvertor.castToRange(value); // Range
        } else if (name.equals("attributeEstimate")) {
          this.getAttributeEstimate().add((EvidenceStatisticAttributeEstimateComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("quantity")) {
          this.quantity = null;
        } else if (name.equals("level")) {
          this.level = null;
        } else if (name.equals("range")) {
          this.range = null;
        } else if (name.equals("attributeEstimate")) {
          this.getAttributeEstimate().add((EvidenceStatisticAttributeEstimateComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 3387378:  return addNote(); 
        case 3575610:  return getType();
        case -1285004149:  return getQuantity();
        case 102865796:  return getLevelElement();
        case 108280125:  return getRange();
        case -1539581980:  return addAttributeEstimate(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 102865796: /*level*/ return new String[] {"decimal"};
        case 108280125: /*range*/ return new String[] {"Range"};
        case -1539581980: /*attributeEstimate*/ return new String[] {"@Evidence.statistic.attributeEstimate"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.statistic.attributeEstimate.description");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("level")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.statistic.attributeEstimate.level");
        }
        else if (name.equals("range")) {
          this.range = new Range();
          return this.range;
        }
        else if (name.equals("attributeEstimate")) {
          return addAttributeEstimate();
        }
        else
          return super.addChild(name);
      }

      public EvidenceStatisticAttributeEstimateComponent copy() {
        EvidenceStatisticAttributeEstimateComponent dst = new EvidenceStatisticAttributeEstimateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceStatisticAttributeEstimateComponent dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.level = level == null ? null : level.copy();
        dst.range = range == null ? null : range.copy();
        if (attributeEstimate != null) {
          dst.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          for (EvidenceStatisticAttributeEstimateComponent i : attributeEstimate)
            dst.attributeEstimate.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceStatisticAttributeEstimateComponent))
          return false;
        EvidenceStatisticAttributeEstimateComponent o = (EvidenceStatisticAttributeEstimateComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(type, o.type, true)
           && compareDeep(quantity, o.quantity, true) && compareDeep(level, o.level, true) && compareDeep(range, o.range, true)
           && compareDeep(attributeEstimate, o.attributeEstimate, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceStatisticAttributeEstimateComponent))
          return false;
        EvidenceStatisticAttributeEstimateComponent o = (EvidenceStatisticAttributeEstimateComponent) other_;
        return compareValues(description, o.description, true) && compareValues(level, o.level, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, type
          , quantity, level, range, attributeEstimate);
      }

  public String fhirType() {
    return "Evidence.statistic.attributeEstimate";

  }

  }

    @Block()
    public static class EvidenceStatisticModelCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Description of a component of the method to generate the statistic.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Model specification", formalDefinition="Description of a component of the method to generate the statistic." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/statistic-model-code")
        protected CodeableConcept code;

        /**
         * Further specification of the quantified value of the component of the method to generate the statistic.
         */
        @Child(name = "value", type = {Quantity.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Numerical value to complete model specification", formalDefinition="Further specification of the quantified value of the component of the method to generate the statistic." )
        protected Quantity value;

        /**
         * A variable adjusted for in the adjusted analysis.
         */
        @Child(name = "variable", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A variable adjusted for in the adjusted analysis", formalDefinition="A variable adjusted for in the adjusted analysis." )
        protected List<EvidenceStatisticModelCharacteristicVariableComponent> variable;

        /**
         * An attribute of the statistic used as a model characteristic.
         */
        @Child(name = "attributeEstimate", type = {EvidenceStatisticAttributeEstimateComponent.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="An attribute of the statistic used as a model characteristic", formalDefinition="An attribute of the statistic used as a model characteristic." )
        protected List<EvidenceStatisticAttributeEstimateComponent> attributeEstimate;

        private static final long serialVersionUID = 1787793468L;

    /**
     * Constructor
     */
      public EvidenceStatisticModelCharacteristicComponent() {
        super();
      }

    /**
     * Constructor
     */
      public EvidenceStatisticModelCharacteristicComponent(CodeableConcept code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (Description of a component of the method to generate the statistic.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticModelCharacteristicComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Description of a component of the method to generate the statistic.)
         */
        public EvidenceStatisticModelCharacteristicComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #value} (Further specification of the quantified value of the component of the method to generate the statistic.)
         */
        public Quantity getValue() { 
          if (this.value == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticModelCharacteristicComponent.value");
            else if (Configuration.doAutoCreate())
              this.value = new Quantity(); // cc
          return this.value;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Further specification of the quantified value of the component of the method to generate the statistic.)
         */
        public EvidenceStatisticModelCharacteristicComponent setValue(Quantity value) { 
          this.value = value;
          return this;
        }

        /**
         * @return {@link #variable} (A variable adjusted for in the adjusted analysis.)
         */
        public List<EvidenceStatisticModelCharacteristicVariableComponent> getVariable() { 
          if (this.variable == null)
            this.variable = new ArrayList<EvidenceStatisticModelCharacteristicVariableComponent>();
          return this.variable;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceStatisticModelCharacteristicComponent setVariable(List<EvidenceStatisticModelCharacteristicVariableComponent> theVariable) { 
          this.variable = theVariable;
          return this;
        }

        public boolean hasVariable() { 
          if (this.variable == null)
            return false;
          for (EvidenceStatisticModelCharacteristicVariableComponent item : this.variable)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public EvidenceStatisticModelCharacteristicVariableComponent addVariable() { //3
          EvidenceStatisticModelCharacteristicVariableComponent t = new EvidenceStatisticModelCharacteristicVariableComponent();
          if (this.variable == null)
            this.variable = new ArrayList<EvidenceStatisticModelCharacteristicVariableComponent>();
          this.variable.add(t);
          return t;
        }

        public EvidenceStatisticModelCharacteristicComponent addVariable(EvidenceStatisticModelCharacteristicVariableComponent t) { //3
          if (t == null)
            return this;
          if (this.variable == null)
            this.variable = new ArrayList<EvidenceStatisticModelCharacteristicVariableComponent>();
          this.variable.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #variable}, creating it if it does not already exist {3}
         */
        public EvidenceStatisticModelCharacteristicVariableComponent getVariableFirstRep() { 
          if (getVariable().isEmpty()) {
            addVariable();
          }
          return getVariable().get(0);
        }

        /**
         * @return {@link #attributeEstimate} (An attribute of the statistic used as a model characteristic.)
         */
        public List<EvidenceStatisticAttributeEstimateComponent> getAttributeEstimate() { 
          if (this.attributeEstimate == null)
            this.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          return this.attributeEstimate;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceStatisticModelCharacteristicComponent setAttributeEstimate(List<EvidenceStatisticAttributeEstimateComponent> theAttributeEstimate) { 
          this.attributeEstimate = theAttributeEstimate;
          return this;
        }

        public boolean hasAttributeEstimate() { 
          if (this.attributeEstimate == null)
            return false;
          for (EvidenceStatisticAttributeEstimateComponent item : this.attributeEstimate)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public EvidenceStatisticAttributeEstimateComponent addAttributeEstimate() { //3
          EvidenceStatisticAttributeEstimateComponent t = new EvidenceStatisticAttributeEstimateComponent();
          if (this.attributeEstimate == null)
            this.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          this.attributeEstimate.add(t);
          return t;
        }

        public EvidenceStatisticModelCharacteristicComponent addAttributeEstimate(EvidenceStatisticAttributeEstimateComponent t) { //3
          if (t == null)
            return this;
          if (this.attributeEstimate == null)
            this.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          this.attributeEstimate.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #attributeEstimate}, creating it if it does not already exist {3}
         */
        public EvidenceStatisticAttributeEstimateComponent getAttributeEstimateFirstRep() { 
          if (getAttributeEstimate().isEmpty()) {
            addAttributeEstimate();
          }
          return getAttributeEstimate().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "Description of a component of the method to generate the statistic.", 0, 1, code));
          children.add(new Property("value", "Quantity", "Further specification of the quantified value of the component of the method to generate the statistic.", 0, 1, value));
          children.add(new Property("variable", "", "A variable adjusted for in the adjusted analysis.", 0, java.lang.Integer.MAX_VALUE, variable));
          children.add(new Property("attributeEstimate", "@Evidence.statistic.attributeEstimate", "An attribute of the statistic used as a model characteristic.", 0, java.lang.Integer.MAX_VALUE, attributeEstimate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Description of a component of the method to generate the statistic.", 0, 1, code);
          case 111972721: /*value*/  return new Property("value", "Quantity", "Further specification of the quantified value of the component of the method to generate the statistic.", 0, 1, value);
          case -1249586564: /*variable*/  return new Property("variable", "", "A variable adjusted for in the adjusted analysis.", 0, java.lang.Integer.MAX_VALUE, variable);
          case -1539581980: /*attributeEstimate*/  return new Property("attributeEstimate", "@Evidence.statistic.attributeEstimate", "An attribute of the statistic used as a model characteristic.", 0, java.lang.Integer.MAX_VALUE, attributeEstimate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // Quantity
        case -1249586564: /*variable*/ return this.variable == null ? new Base[0] : this.variable.toArray(new Base[this.variable.size()]); // EvidenceStatisticModelCharacteristicVariableComponent
        case -1539581980: /*attributeEstimate*/ return this.attributeEstimate == null ? new Base[0] : this.attributeEstimate.toArray(new Base[this.attributeEstimate.size()]); // EvidenceStatisticAttributeEstimateComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -1249586564: // variable
          this.getVariable().add((EvidenceStatisticModelCharacteristicVariableComponent) value); // EvidenceStatisticModelCharacteristicVariableComponent
          return value;
        case -1539581980: // attributeEstimate
          this.getAttributeEstimate().add((EvidenceStatisticAttributeEstimateComponent) value); // EvidenceStatisticAttributeEstimateComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value")) {
          this.value = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("variable")) {
          this.getVariable().add((EvidenceStatisticModelCharacteristicVariableComponent) value);
        } else if (name.equals("attributeEstimate")) {
          this.getAttributeEstimate().add((EvidenceStatisticAttributeEstimateComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("value")) {
          this.value = null;
        } else if (name.equals("variable")) {
          this.getVariable().add((EvidenceStatisticModelCharacteristicVariableComponent) value);
        } else if (name.equals("attributeEstimate")) {
          this.getAttributeEstimate().add((EvidenceStatisticAttributeEstimateComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case 111972721:  return getValue();
        case -1249586564:  return addVariable(); 
        case -1539581980:  return addAttributeEstimate(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"Quantity"};
        case -1249586564: /*variable*/ return new String[] {};
        case -1539581980: /*attributeEstimate*/ return new String[] {"@Evidence.statistic.attributeEstimate"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("value")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("variable")) {
          return addVariable();
        }
        else if (name.equals("attributeEstimate")) {
          return addAttributeEstimate();
        }
        else
          return super.addChild(name);
      }

      public EvidenceStatisticModelCharacteristicComponent copy() {
        EvidenceStatisticModelCharacteristicComponent dst = new EvidenceStatisticModelCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceStatisticModelCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.value = value == null ? null : value.copy();
        if (variable != null) {
          dst.variable = new ArrayList<EvidenceStatisticModelCharacteristicVariableComponent>();
          for (EvidenceStatisticModelCharacteristicVariableComponent i : variable)
            dst.variable.add(i.copy());
        };
        if (attributeEstimate != null) {
          dst.attributeEstimate = new ArrayList<EvidenceStatisticAttributeEstimateComponent>();
          for (EvidenceStatisticAttributeEstimateComponent i : attributeEstimate)
            dst.attributeEstimate.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceStatisticModelCharacteristicComponent))
          return false;
        EvidenceStatisticModelCharacteristicComponent o = (EvidenceStatisticModelCharacteristicComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(value, o.value, true) && compareDeep(variable, o.variable, true)
           && compareDeep(attributeEstimate, o.attributeEstimate, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceStatisticModelCharacteristicComponent))
          return false;
        EvidenceStatisticModelCharacteristicComponent o = (EvidenceStatisticModelCharacteristicComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, value, variable, attributeEstimate
          );
      }

  public String fhirType() {
    return "Evidence.statistic.modelCharacteristic";

  }

  }

    @Block()
    public static class EvidenceStatisticModelCharacteristicVariableComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Description of the variable.
         */
        @Child(name = "variableDefinition", type = {Group.class, EvidenceVariable.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of the variable", formalDefinition="Description of the variable." )
        protected Reference variableDefinition;

        /**
         * How the variable is classified for use in adjusted analysis.
         */
        @Child(name = "handling", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="continuous | dichotomous | ordinal | polychotomous", formalDefinition="How the variable is classified for use in adjusted analysis." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/variable-handling")
        protected Enumeration<EvidenceVariableHandling> handling;

        /**
         * Description for grouping of ordinal or polychotomous variables.
         */
        @Child(name = "valueCategory", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Description for grouping of ordinal or polychotomous variables", formalDefinition="Description for grouping of ordinal or polychotomous variables." )
        protected List<CodeableConcept> valueCategory;

        /**
         * Discrete value for grouping of ordinal or polychotomous variables.
         */
        @Child(name = "valueQuantity", type = {Quantity.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Discrete value for grouping of ordinal or polychotomous variables", formalDefinition="Discrete value for grouping of ordinal or polychotomous variables." )
        protected List<Quantity> valueQuantity;

        /**
         * Range of values for grouping of ordinal or polychotomous variables.
         */
        @Child(name = "valueRange", type = {Range.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Range of values for grouping of ordinal or polychotomous variables", formalDefinition="Range of values for grouping of ordinal or polychotomous variables." )
        protected List<Range> valueRange;

        private static final long serialVersionUID = 1516174900L;

    /**
     * Constructor
     */
      public EvidenceStatisticModelCharacteristicVariableComponent() {
        super();
      }

    /**
     * Constructor
     */
      public EvidenceStatisticModelCharacteristicVariableComponent(Reference variableDefinition) {
        super();
        this.setVariableDefinition(variableDefinition);
      }

        /**
         * @return {@link #variableDefinition} (Description of the variable.)
         */
        public Reference getVariableDefinition() { 
          if (this.variableDefinition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticModelCharacteristicVariableComponent.variableDefinition");
            else if (Configuration.doAutoCreate())
              this.variableDefinition = new Reference(); // cc
          return this.variableDefinition;
        }

        public boolean hasVariableDefinition() { 
          return this.variableDefinition != null && !this.variableDefinition.isEmpty();
        }

        /**
         * @param value {@link #variableDefinition} (Description of the variable.)
         */
        public EvidenceStatisticModelCharacteristicVariableComponent setVariableDefinition(Reference value) { 
          this.variableDefinition = value;
          return this;
        }

        /**
         * @return {@link #handling} (How the variable is classified for use in adjusted analysis.). This is the underlying object with id, value and extensions. The accessor "getHandling" gives direct access to the value
         */
        public Enumeration<EvidenceVariableHandling> getHandlingElement() { 
          if (this.handling == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceStatisticModelCharacteristicVariableComponent.handling");
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
         * @param value {@link #handling} (How the variable is classified for use in adjusted analysis.). This is the underlying object with id, value and extensions. The accessor "getHandling" gives direct access to the value
         */
        public EvidenceStatisticModelCharacteristicVariableComponent setHandlingElement(Enumeration<EvidenceVariableHandling> value) { 
          this.handling = value;
          return this;
        }

        /**
         * @return How the variable is classified for use in adjusted analysis.
         */
        public EvidenceVariableHandling getHandling() { 
          return this.handling == null ? null : this.handling.getValue();
        }

        /**
         * @param value How the variable is classified for use in adjusted analysis.
         */
        public EvidenceStatisticModelCharacteristicVariableComponent setHandling(EvidenceVariableHandling value) { 
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
         * @return {@link #valueCategory} (Description for grouping of ordinal or polychotomous variables.)
         */
        public List<CodeableConcept> getValueCategory() { 
          if (this.valueCategory == null)
            this.valueCategory = new ArrayList<CodeableConcept>();
          return this.valueCategory;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceStatisticModelCharacteristicVariableComponent setValueCategory(List<CodeableConcept> theValueCategory) { 
          this.valueCategory = theValueCategory;
          return this;
        }

        public boolean hasValueCategory() { 
          if (this.valueCategory == null)
            return false;
          for (CodeableConcept item : this.valueCategory)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addValueCategory() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.valueCategory == null)
            this.valueCategory = new ArrayList<CodeableConcept>();
          this.valueCategory.add(t);
          return t;
        }

        public EvidenceStatisticModelCharacteristicVariableComponent addValueCategory(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.valueCategory == null)
            this.valueCategory = new ArrayList<CodeableConcept>();
          this.valueCategory.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #valueCategory}, creating it if it does not already exist {3}
         */
        public CodeableConcept getValueCategoryFirstRep() { 
          if (getValueCategory().isEmpty()) {
            addValueCategory();
          }
          return getValueCategory().get(0);
        }

        /**
         * @return {@link #valueQuantity} (Discrete value for grouping of ordinal or polychotomous variables.)
         */
        public List<Quantity> getValueQuantity() { 
          if (this.valueQuantity == null)
            this.valueQuantity = new ArrayList<Quantity>();
          return this.valueQuantity;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceStatisticModelCharacteristicVariableComponent setValueQuantity(List<Quantity> theValueQuantity) { 
          this.valueQuantity = theValueQuantity;
          return this;
        }

        public boolean hasValueQuantity() { 
          if (this.valueQuantity == null)
            return false;
          for (Quantity item : this.valueQuantity)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Quantity addValueQuantity() { //3
          Quantity t = new Quantity();
          if (this.valueQuantity == null)
            this.valueQuantity = new ArrayList<Quantity>();
          this.valueQuantity.add(t);
          return t;
        }

        public EvidenceStatisticModelCharacteristicVariableComponent addValueQuantity(Quantity t) { //3
          if (t == null)
            return this;
          if (this.valueQuantity == null)
            this.valueQuantity = new ArrayList<Quantity>();
          this.valueQuantity.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #valueQuantity}, creating it if it does not already exist {3}
         */
        public Quantity getValueQuantityFirstRep() { 
          if (getValueQuantity().isEmpty()) {
            addValueQuantity();
          }
          return getValueQuantity().get(0);
        }

        /**
         * @return {@link #valueRange} (Range of values for grouping of ordinal or polychotomous variables.)
         */
        public List<Range> getValueRange() { 
          if (this.valueRange == null)
            this.valueRange = new ArrayList<Range>();
          return this.valueRange;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public EvidenceStatisticModelCharacteristicVariableComponent setValueRange(List<Range> theValueRange) { 
          this.valueRange = theValueRange;
          return this;
        }

        public boolean hasValueRange() { 
          if (this.valueRange == null)
            return false;
          for (Range item : this.valueRange)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Range addValueRange() { //3
          Range t = new Range();
          if (this.valueRange == null)
            this.valueRange = new ArrayList<Range>();
          this.valueRange.add(t);
          return t;
        }

        public EvidenceStatisticModelCharacteristicVariableComponent addValueRange(Range t) { //3
          if (t == null)
            return this;
          if (this.valueRange == null)
            this.valueRange = new ArrayList<Range>();
          this.valueRange.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #valueRange}, creating it if it does not already exist {3}
         */
        public Range getValueRangeFirstRep() { 
          if (getValueRange().isEmpty()) {
            addValueRange();
          }
          return getValueRange().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("variableDefinition", "Reference(Group|EvidenceVariable)", "Description of the variable.", 0, 1, variableDefinition));
          children.add(new Property("handling", "code", "How the variable is classified for use in adjusted analysis.", 0, 1, handling));
          children.add(new Property("valueCategory", "CodeableConcept", "Description for grouping of ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE, valueCategory));
          children.add(new Property("valueQuantity", "Quantity", "Discrete value for grouping of ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE, valueQuantity));
          children.add(new Property("valueRange", "Range", "Range of values for grouping of ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE, valueRange));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1807222545: /*variableDefinition*/  return new Property("variableDefinition", "Reference(Group|EvidenceVariable)", "Description of the variable.", 0, 1, variableDefinition);
          case 2072805: /*handling*/  return new Property("handling", "code", "How the variable is classified for use in adjusted analysis.", 0, 1, handling);
          case -694308465: /*valueCategory*/  return new Property("valueCategory", "CodeableConcept", "Description for grouping of ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE, valueCategory);
          case -2029823716: /*valueQuantity*/  return new Property("valueQuantity", "Quantity", "Discrete value for grouping of ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE, valueQuantity);
          case 2030761548: /*valueRange*/  return new Property("valueRange", "Range", "Range of values for grouping of ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE, valueRange);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1807222545: /*variableDefinition*/ return this.variableDefinition == null ? new Base[0] : new Base[] {this.variableDefinition}; // Reference
        case 2072805: /*handling*/ return this.handling == null ? new Base[0] : new Base[] {this.handling}; // Enumeration<EvidenceVariableHandling>
        case -694308465: /*valueCategory*/ return this.valueCategory == null ? new Base[0] : this.valueCategory.toArray(new Base[this.valueCategory.size()]); // CodeableConcept
        case -2029823716: /*valueQuantity*/ return this.valueQuantity == null ? new Base[0] : this.valueQuantity.toArray(new Base[this.valueQuantity.size()]); // Quantity
        case 2030761548: /*valueRange*/ return this.valueRange == null ? new Base[0] : this.valueRange.toArray(new Base[this.valueRange.size()]); // Range
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1807222545: // variableDefinition
          this.variableDefinition = TypeConvertor.castToReference(value); // Reference
          return value;
        case 2072805: // handling
          value = new EvidenceVariableHandlingEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.handling = (Enumeration) value; // Enumeration<EvidenceVariableHandling>
          return value;
        case -694308465: // valueCategory
          this.getValueCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -2029823716: // valueQuantity
          this.getValueQuantity().add(TypeConvertor.castToQuantity(value)); // Quantity
          return value;
        case 2030761548: // valueRange
          this.getValueRange().add(TypeConvertor.castToRange(value)); // Range
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("variableDefinition")) {
          this.variableDefinition = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("handling")) {
          value = new EvidenceVariableHandlingEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.handling = (Enumeration) value; // Enumeration<EvidenceVariableHandling>
        } else if (name.equals("valueCategory")) {
          this.getValueCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("valueQuantity")) {
          this.getValueQuantity().add(TypeConvertor.castToQuantity(value));
        } else if (name.equals("valueRange")) {
          this.getValueRange().add(TypeConvertor.castToRange(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("variableDefinition")) {
          this.variableDefinition = null;
        } else if (name.equals("handling")) {
          value = new EvidenceVariableHandlingEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.handling = (Enumeration) value; // Enumeration<EvidenceVariableHandling>
        } else if (name.equals("valueCategory")) {
          this.getValueCategory().remove(value);
        } else if (name.equals("valueQuantity")) {
          this.getValueQuantity().remove(value);
        } else if (name.equals("valueRange")) {
          this.getValueRange().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1807222545:  return getVariableDefinition();
        case 2072805:  return getHandlingElement();
        case -694308465:  return addValueCategory(); 
        case -2029823716:  return addValueQuantity(); 
        case 2030761548:  return addValueRange(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1807222545: /*variableDefinition*/ return new String[] {"Reference"};
        case 2072805: /*handling*/ return new String[] {"code"};
        case -694308465: /*valueCategory*/ return new String[] {"CodeableConcept"};
        case -2029823716: /*valueQuantity*/ return new String[] {"Quantity"};
        case 2030761548: /*valueRange*/ return new String[] {"Range"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("variableDefinition")) {
          this.variableDefinition = new Reference();
          return this.variableDefinition;
        }
        else if (name.equals("handling")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.statistic.modelCharacteristic.variable.handling");
        }
        else if (name.equals("valueCategory")) {
          return addValueCategory();
        }
        else if (name.equals("valueQuantity")) {
          return addValueQuantity();
        }
        else if (name.equals("valueRange")) {
          return addValueRange();
        }
        else
          return super.addChild(name);
      }

      public EvidenceStatisticModelCharacteristicVariableComponent copy() {
        EvidenceStatisticModelCharacteristicVariableComponent dst = new EvidenceStatisticModelCharacteristicVariableComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EvidenceStatisticModelCharacteristicVariableComponent dst) {
        super.copyValues(dst);
        dst.variableDefinition = variableDefinition == null ? null : variableDefinition.copy();
        dst.handling = handling == null ? null : handling.copy();
        if (valueCategory != null) {
          dst.valueCategory = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : valueCategory)
            dst.valueCategory.add(i.copy());
        };
        if (valueQuantity != null) {
          dst.valueQuantity = new ArrayList<Quantity>();
          for (Quantity i : valueQuantity)
            dst.valueQuantity.add(i.copy());
        };
        if (valueRange != null) {
          dst.valueRange = new ArrayList<Range>();
          for (Range i : valueRange)
            dst.valueRange.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EvidenceStatisticModelCharacteristicVariableComponent))
          return false;
        EvidenceStatisticModelCharacteristicVariableComponent o = (EvidenceStatisticModelCharacteristicVariableComponent) other_;
        return compareDeep(variableDefinition, o.variableDefinition, true) && compareDeep(handling, o.handling, true)
           && compareDeep(valueCategory, o.valueCategory, true) && compareDeep(valueQuantity, o.valueQuantity, true)
           && compareDeep(valueRange, o.valueRange, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EvidenceStatisticModelCharacteristicVariableComponent))
          return false;
        EvidenceStatisticModelCharacteristicVariableComponent o = (EvidenceStatisticModelCharacteristicVariableComponent) other_;
        return compareValues(handling, o.handling, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(variableDefinition, handling
          , valueCategory, valueQuantity, valueRange);
      }

  public String fhirType() {
    return "Evidence.statistic.modelCharacteristic.variable";

  }

  }

    @Block()
    public static class EvidenceCertaintyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Textual description of certainty.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Textual description of certainty", formalDefinition="Textual description of certainty." )
        protected MarkdownType description;

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

        private static final long serialVersionUID = -139300414L;

    /**
     * Constructor
     */
      public EvidenceCertaintyComponent() {
        super();
      }

        /**
         * @return {@link #description} (Textual description of certainty.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EvidenceCertaintyComponent.description");
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
         * @param value {@link #description} (Textual description of certainty.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public EvidenceCertaintyComponent setDescriptionElement(MarkdownType value) { 
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
          children.add(new Property("description", "markdown", "Textual description of certainty.", 0, 1, description));
          children.add(new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("type", "CodeableConcept", "Aspect of certainty being rated.", 0, 1, type));
          children.add(new Property("rating", "CodeableConcept", "Assessment or judgement of the aspect.", 0, 1, rating));
          children.add(new Property("rater", "string", "Individual or group who did the rating.", 0, 1, rater));
          children.add(new Property("subcomponent", "@Evidence.certainty", "A domain or subdomain of certainty.", 0, java.lang.Integer.MAX_VALUE, subcomponent));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "markdown", "Textual description of certainty.", 0, 1, description);
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
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
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
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
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
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("rating")) {
          this.rating = null;
        } else if (name.equals("rater")) {
          this.rater = null;
        } else if (name.equals("subcomponent")) {
          this.getSubcomponent().add((EvidenceCertaintyComponent) value);
        } else
          super.removeChild(name, value);
        
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
        case -1724546052: /*description*/ return new String[] {"markdown"};
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
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.certainty.description");
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
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.certainty.rater");
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
     * An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this evidence, represented as a globally unique URI", formalDefinition="An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers." )
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
     * Indicates the mechanism used to compare versions to determine which is more current.
     */
    @Child(name = "versionAlgorithm", type = {StringType.class, Coding.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How to compare versions", formalDefinition="Indicates the mechanism used to compare versions to determine which is more current." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/version-algorithm")
    protected DataType versionAlgorithm;

    /**
     * A natural language name identifying the evidence. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Name for this summary (machine friendly)", formalDefinition="A natural language name identifying the evidence. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the summary.
     */
    @Child(name = "title", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this summary (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the summary." )
    protected StringType title;

    /**
     * Citation Resource or display of suggested citation for this evidence.
     */
    @Child(name = "citeAs", type = {Citation.class, MarkdownType.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Citation for this evidence", formalDefinition="Citation Resource or display of suggested citation for this evidence." )
    protected DataType citeAs;

    /**
     * The status of this summary. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=7, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this summary. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the summary was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the summary was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes." )
    protected DateTimeType date;

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the summary was approved by publisher", formalDefinition="The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the summary was last reviewed by the publisher", formalDefinition="The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the evidence.
     */
    @Child(name = "publisher", type = {StringType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the evidence." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * An individiual, organization, or device primarily involved in the creation and maintenance of the content.
     */
    @Child(name = "author", type = {ContactDetail.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who authored the content", formalDefinition="An individiual, organization, or device primarily involved in the creation and maintenance of the content." )
    protected List<ContactDetail> author;

    /**
     * An individiual, organization, or device primarily responsible for internal coherence of the content.
     */
    @Child(name = "editor", type = {ContactDetail.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who edited the content", formalDefinition="An individiual, organization, or device primarily responsible for internal coherence of the content." )
    protected List<ContactDetail> editor;

    /**
     * An individiual, organization, or device primarily responsible for review of some aspect of the content.
     */
    @Child(name = "reviewer", type = {ContactDetail.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who reviewed the content", formalDefinition="An individiual, organization, or device primarily responsible for review of some aspect of the content." )
    protected List<ContactDetail> reviewer;

    /**
     * An individiual, organization, or device responsible for officially endorsing the content for use in some setting.
     */
    @Child(name = "endorser", type = {ContactDetail.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who endorsed the content", formalDefinition="An individiual, organization, or device responsible for officially endorsing the content for use in some setting." )
    protected List<ContactDetail> endorser;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence instances." )
    protected List<UsageContext> useContext;

    /**
     * Explanation of why this Evidence is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this Evidence is defined", formalDefinition="Explanation of why this Evidence is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A copyright statement relating to the Evidence and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Evidence.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the Evidence and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Evidence." )
    protected MarkdownType copyright;

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    @Child(name = "copyrightLabel", type = {StringType.class}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright holder and year(s)", formalDefinition="A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved')." )
    protected StringType copyrightLabel;

    /**
     * Link or citation to artifact associated with the summary.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Link or citation to artifact associated with the summary", formalDefinition="Link or citation to artifact associated with the summary." )
    protected List<RelatedArtifact> relatedArtifact;

    /**
     * A free text natural language description of the evidence from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=23, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Description of the particular summary", formalDefinition="A free text natural language description of the evidence from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * Declarative description of the Evidence.
     */
    @Child(name = "assertion", type = {MarkdownType.class}, order=24, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Declarative description of the Evidence", formalDefinition="Declarative description of the Evidence." )
    protected MarkdownType assertion;

    /**
     * Footnotes and/or explanatory notes.
     */
    @Child(name = "note", type = {Annotation.class}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Footnotes and/or explanatory notes", formalDefinition="Footnotes and/or explanatory notes." )
    protected List<Annotation> note;

    /**
     * Evidence variable such as population, exposure, or outcome.
     */
    @Child(name = "variableDefinition", type = {}, order=26, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Evidence variable such as population, exposure, or outcome", formalDefinition="Evidence variable such as population, exposure, or outcome." )
    protected List<EvidenceVariableDefinitionComponent> variableDefinition;

    /**
     * The method to combine studies.
     */
    @Child(name = "synthesisType", type = {CodeableConcept.class}, order=27, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The method to combine studies", formalDefinition="The method to combine studies." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/synthesis-type")
    protected CodeableConcept synthesisType;

    /**
     * The design of the study that produced this evidence. The design is described with any number of study design characteristics.
     */
    @Child(name = "studyDesign", type = {CodeableConcept.class}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The design of the study that produced this evidence", formalDefinition="The design of the study that produced this evidence. The design is described with any number of study design characteristics." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/study-design")
    protected List<CodeableConcept> studyDesign;

    /**
     * Values and parameters for a single statistic.
     */
    @Child(name = "statistic", type = {}, order=29, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Values and parameters for a single statistic", formalDefinition="Values and parameters for a single statistic." )
    protected List<EvidenceStatisticComponent> statistic;

    /**
     * Assessment of certainty, confidence in the estimates, or quality of the evidence.
     */
    @Child(name = "certainty", type = {}, order=30, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Certainty or quality of the evidence", formalDefinition="Assessment of certainty, confidence in the estimates, or quality of the evidence." )
    protected List<EvidenceCertaintyComponent> certainty;

    private static final long serialVersionUID = 1427750968L;

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
     * @return {@link #url} (An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
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
     * @param value {@link #url} (An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public Evidence setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.
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
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public DataType getVersionAlgorithm() { 
      return this.versionAlgorithm;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
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
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
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
     * @param value {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public Evidence setVersionAlgorithm(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof Coding))
        throw new FHIRException("Not the right type for Evidence.versionAlgorithm[x]: "+value.fhirType());
      this.versionAlgorithm = value;
      return this;
    }

    /**
     * @return {@link #name} (A natural language name identifying the evidence. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.name");
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
     * @param value {@link #name} (A natural language name identifying the evidence. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public Evidence setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the evidence. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the evidence. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public Evidence setName(String value) { 
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
        throw new FHIRException("Not the right type for Evidence.citeAs[x]: "+value.fhirType());
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
     * @return {@link #experimental} (A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.experimental");
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
    public Evidence setExperimentalElement(BooleanType value) { 
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
    public Evidence setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the summary was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
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
     * @param value {@link #date} (The date  (and optionally time) when the summary was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public Evidence setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the summary was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the summary was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.
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
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the evidence.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
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
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the evidence.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public Evidence setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the evidence.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the evidence.
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
     * @return {@link #purpose} (Explanation of why this Evidence is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.purpose");
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
     * @param value {@link #purpose} (Explanation of why this Evidence is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public Evidence setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this Evidence is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this Evidence is needed and why it has been designed as it has.
     */
    public Evidence setPurpose(String value) { 
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
     * @return {@link #copyright} (A copyright statement relating to the Evidence and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Evidence.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Evidence.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the Evidence and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Evidence.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public Evidence setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the Evidence and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Evidence.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the Evidence and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Evidence.
     */
    public Evidence setCopyright(String value) { 
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
          throw new Error("Attempt to auto-create Evidence.copyrightLabel");
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
    public Evidence setCopyrightLabelElement(StringType value) { 
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
    public Evidence setCopyrightLabel(String value) { 
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
      if (Utilities.noString(value))
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
     * @return {@link #studyDesign} (The design of the study that produced this evidence. The design is described with any number of study design characteristics.)
     */
    public List<CodeableConcept> getStudyDesign() { 
      if (this.studyDesign == null)
        this.studyDesign = new ArrayList<CodeableConcept>();
      return this.studyDesign;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setStudyDesign(List<CodeableConcept> theStudyDesign) { 
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

    public Evidence addStudyDesign(CodeableConcept t) { //3
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
     * @return {@link #statistic} (Values and parameters for a single statistic.)
     */
    public List<EvidenceStatisticComponent> getStatistic() { 
      if (this.statistic == null)
        this.statistic = new ArrayList<EvidenceStatisticComponent>();
      return this.statistic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Evidence setStatistic(List<EvidenceStatisticComponent> theStatistic) { 
      this.statistic = theStatistic;
      return this;
    }

    public boolean hasStatistic() { 
      if (this.statistic == null)
        return false;
      for (EvidenceStatisticComponent item : this.statistic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public EvidenceStatisticComponent addStatistic() { //3
      EvidenceStatisticComponent t = new EvidenceStatisticComponent();
      if (this.statistic == null)
        this.statistic = new ArrayList<EvidenceStatisticComponent>();
      this.statistic.add(t);
      return t;
    }

    public Evidence addStatistic(EvidenceStatisticComponent t) { //3
      if (t == null)
        return this;
      if (this.statistic == null)
        this.statistic = new ArrayList<EvidenceStatisticComponent>();
      this.statistic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #statistic}, creating it if it does not already exist {3}
     */
    public EvidenceStatisticComponent getStatisticFirstRep() { 
      if (getStatistic().isEmpty()) {
        addStatistic();
      }
      return getStatistic().get(0);
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
     * @return {@link #topic} (Descriptive topics related to the content of the evidence. Topics provide a high-level categorization as well as keywords for the evidence that can be useful for filtering and searching.)
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
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm));
        children.add(new Property("name", "string", "A natural language name identifying the evidence. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the summary.", 0, 1, title));
        children.add(new Property("citeAs[x]", "Reference(Citation)|markdown", "Citation Resource or display of suggested citation for this evidence.", 0, 1, citeAs));
        children.add(new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the summary was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.", 0, 1, date));
        children.add(new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the evidence.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("author", "ContactDetail", "An individiual, organization, or device primarily involved in the creation and maintenance of the content.", 0, java.lang.Integer.MAX_VALUE, author));
        children.add(new Property("editor", "ContactDetail", "An individiual, organization, or device primarily responsible for internal coherence of the content.", 0, java.lang.Integer.MAX_VALUE, editor));
        children.add(new Property("reviewer", "ContactDetail", "An individiual, organization, or device primarily responsible for review of some aspect of the content.", 0, java.lang.Integer.MAX_VALUE, reviewer));
        children.add(new Property("endorser", "ContactDetail", "An individiual, organization, or device responsible for officially endorsing the content for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("purpose", "markdown", "Explanation of why this Evidence is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the Evidence and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Evidence.", 0, 1, copyright));
        children.add(new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Link or citation to artifact associated with the summary.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
        children.add(new Property("description", "markdown", "A free text natural language description of the evidence from a consumer's perspective.", 0, 1, description));
        children.add(new Property("assertion", "markdown", "Declarative description of the Evidence.", 0, 1, assertion));
        children.add(new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("variableDefinition", "", "Evidence variable such as population, exposure, or outcome.", 0, java.lang.Integer.MAX_VALUE, variableDefinition));
        children.add(new Property("synthesisType", "CodeableConcept", "The method to combine studies.", 0, 1, synthesisType));
        children.add(new Property("studyDesign", "CodeableConcept", "The design of the study that produced this evidence. The design is described with any number of study design characteristics.", 0, java.lang.Integer.MAX_VALUE, studyDesign));
        children.add(new Property("statistic", "", "Values and parameters for a single statistic.", 0, java.lang.Integer.MAX_VALUE, statistic));
        children.add(new Property("certainty", "", "Assessment of certainty, confidence in the estimates, or quality of the evidence.", 0, java.lang.Integer.MAX_VALUE, certainty));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this evidence when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this summary is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the summary is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this summary when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the summary when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the summary author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case -115699031: /*versionAlgorithm[x]*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1508158071: /*versionAlgorithm*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1836908904: /*versionAlgorithmString*/  return new Property("versionAlgorithm[x]", "string", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1373807809: /*versionAlgorithmCoding*/  return new Property("versionAlgorithm[x]", "Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the evidence. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the summary.", 0, 1, title);
        case -1706539017: /*citeAs[x]*/  return new Property("citeAs[x]", "Reference(Citation)|markdown", "Citation Resource or display of suggested citation for this evidence.", 0, 1, citeAs);
        case -1360156695: /*citeAs*/  return new Property("citeAs[x]", "Reference(Citation)|markdown", "Citation Resource or display of suggested citation for this evidence.", 0, 1, citeAs);
        case 1269009762: /*citeAsReference*/  return new Property("citeAs[x]", "Reference(Citation)", "Citation Resource or display of suggested citation for this evidence.", 0, 1, citeAs);
        case 456265720: /*citeAsMarkdown*/  return new Property("citeAs[x]", "markdown", "Citation Resource or display of suggested citation for this evidence.", 0, 1, citeAs);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this summary. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this resource is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the summary was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the summary changes.", 0, 1, date);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the evidence.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1406328437: /*author*/  return new Property("author", "ContactDetail", "An individiual, organization, or device primarily involved in the creation and maintenance of the content.", 0, java.lang.Integer.MAX_VALUE, author);
        case -1307827859: /*editor*/  return new Property("editor", "ContactDetail", "An individiual, organization, or device primarily responsible for internal coherence of the content.", 0, java.lang.Integer.MAX_VALUE, editor);
        case -261190139: /*reviewer*/  return new Property("reviewer", "ContactDetail", "An individiual, organization, or device primarily responsible for review of some aspect of the content.", 0, java.lang.Integer.MAX_VALUE, reviewer);
        case 1740277666: /*endorser*/  return new Property("endorser", "ContactDetail", "An individiual, organization, or device responsible for officially endorsing the content for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate evidence instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this Evidence is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the Evidence and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the Evidence.", 0, 1, copyright);
        case 765157229: /*copyrightLabel*/  return new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Link or citation to artifact associated with the summary.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the evidence from a consumer's perspective.", 0, 1, description);
        case 1314395906: /*assertion*/  return new Property("assertion", "markdown", "Declarative description of the Evidence.", 0, 1, assertion);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note);
        case -1807222545: /*variableDefinition*/  return new Property("variableDefinition", "", "Evidence variable such as population, exposure, or outcome.", 0, java.lang.Integer.MAX_VALUE, variableDefinition);
        case 672726254: /*synthesisType*/  return new Property("synthesisType", "CodeableConcept", "The method to combine studies.", 0, 1, synthesisType);
        case 1709211879: /*studyDesign*/  return new Property("studyDesign", "CodeableConcept", "The design of the study that produced this evidence. The design is described with any number of study design characteristics.", 0, java.lang.Integer.MAX_VALUE, studyDesign);
        case -2081261232: /*statistic*/  return new Property("statistic", "", "Values and parameters for a single statistic.", 0, java.lang.Integer.MAX_VALUE, statistic);
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
        case 1508158071: /*versionAlgorithm*/ return this.versionAlgorithm == null ? new Base[0] : new Base[] {this.versionAlgorithm}; // DataType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1360156695: /*citeAs*/ return this.citeAs == null ? new Base[0] : new Base[] {this.citeAs}; // DataType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // ContactDetail
        case -1307827859: /*editor*/ return this.editor == null ? new Base[0] : this.editor.toArray(new Base[this.editor.size()]); // ContactDetail
        case -261190139: /*reviewer*/ return this.reviewer == null ? new Base[0] : this.reviewer.toArray(new Base[this.reviewer.size()]); // ContactDetail
        case 1740277666: /*endorser*/ return this.endorser == null ? new Base[0] : this.endorser.toArray(new Base[this.endorser.size()]); // ContactDetail
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 765157229: /*copyrightLabel*/ return this.copyrightLabel == null ? new Base[0] : new Base[] {this.copyrightLabel}; // StringType
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 1314395906: /*assertion*/ return this.assertion == null ? new Base[0] : new Base[] {this.assertion}; // MarkdownType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1807222545: /*variableDefinition*/ return this.variableDefinition == null ? new Base[0] : this.variableDefinition.toArray(new Base[this.variableDefinition.size()]); // EvidenceVariableDefinitionComponent
        case 672726254: /*synthesisType*/ return this.synthesisType == null ? new Base[0] : new Base[] {this.synthesisType}; // CodeableConcept
        case 1709211879: /*studyDesign*/ return this.studyDesign == null ? new Base[0] : this.studyDesign.toArray(new Base[this.studyDesign.size()]); // CodeableConcept
        case -2081261232: /*statistic*/ return this.statistic == null ? new Base[0] : this.statistic.toArray(new Base[this.statistic.size()]); // EvidenceStatisticComponent
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
        case 1508158071: // versionAlgorithm
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
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
        case -404562712: // experimental
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
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
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
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
        case 1709211879: // studyDesign
          this.getStudyDesign().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -2081261232: // statistic
          this.getStatistic().add((EvidenceStatisticComponent) value); // EvidenceStatisticComponent
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
        } else if (name.equals("versionAlgorithm[x]")) {
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("citeAs[x]")) {
          this.citeAs = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
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
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyrightLabel")) {
          this.copyrightLabel = TypeConvertor.castToString(value); // StringType
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
        } else if (name.equals("studyDesign")) {
          this.getStudyDesign().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("statistic")) {
          this.getStatistic().add((EvidenceStatisticComponent) value);
        } else if (name.equals("certainty")) {
          this.getCertainty().add((EvidenceCertaintyComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = null;
        } else if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("version")) {
          this.version = null;
        } else if (name.equals("versionAlgorithm[x]")) {
          this.versionAlgorithm = null;
        } else if (name.equals("name")) {
          this.name = null;
        } else if (name.equals("title")) {
          this.title = null;
        } else if (name.equals("citeAs[x]")) {
          this.citeAs = null;
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = null;
        } else if (name.equals("date")) {
          this.date = null;
        } else if (name.equals("approvalDate")) {
          this.approvalDate = null;
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = null;
        } else if (name.equals("publisher")) {
          this.publisher = null;
        } else if (name.equals("contact")) {
          this.getContact().remove(value);
        } else if (name.equals("author")) {
          this.getAuthor().remove(value);
        } else if (name.equals("editor")) {
          this.getEditor().remove(value);
        } else if (name.equals("reviewer")) {
          this.getReviewer().remove(value);
        } else if (name.equals("endorser")) {
          this.getEndorser().remove(value);
        } else if (name.equals("useContext")) {
          this.getUseContext().remove(value);
        } else if (name.equals("purpose")) {
          this.purpose = null;
        } else if (name.equals("copyright")) {
          this.copyright = null;
        } else if (name.equals("copyrightLabel")) {
          this.copyrightLabel = null;
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().remove(value);
        } else if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("assertion")) {
          this.assertion = null;
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else if (name.equals("variableDefinition")) {
          this.getVariableDefinition().add((EvidenceVariableDefinitionComponent) value);
        } else if (name.equals("synthesisType")) {
          this.synthesisType = null;
        } else if (name.equals("studyDesign")) {
          this.getStudyDesign().remove(value);
        } else if (name.equals("statistic")) {
          this.getStatistic().add((EvidenceStatisticComponent) value);
        } else if (name.equals("certainty")) {
          this.getCertainty().add((EvidenceCertaintyComponent) value);
        } else
          super.removeChild(name, value);
        
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
        case -1706539017:  return getCiteAs();
        case -1360156695:  return getCiteAs();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1406328437:  return addAuthor(); 
        case -1307827859:  return addEditor(); 
        case -261190139:  return addReviewer(); 
        case 1740277666:  return addEndorser(); 
        case -669707736:  return addUseContext(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 765157229:  return getCopyrightLabelElement();
        case 666807069:  return addRelatedArtifact(); 
        case -1724546052:  return getDescriptionElement();
        case 1314395906:  return getAssertionElement();
        case 3387378:  return addNote(); 
        case -1807222545:  return addVariableDefinition(); 
        case 672726254:  return getSynthesisType();
        case 1709211879:  return addStudyDesign(); 
        case -2081261232:  return addStatistic(); 
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
        case 1508158071: /*versionAlgorithm*/ return new String[] {"string", "Coding"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -1360156695: /*citeAs*/ return new String[] {"Reference", "markdown"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1406328437: /*author*/ return new String[] {"ContactDetail"};
        case -1307827859: /*editor*/ return new String[] {"ContactDetail"};
        case -261190139: /*reviewer*/ return new String[] {"ContactDetail"};
        case 1740277666: /*endorser*/ return new String[] {"ContactDetail"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 765157229: /*copyrightLabel*/ return new String[] {"string"};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 1314395906: /*assertion*/ return new String[] {"markdown"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -1807222545: /*variableDefinition*/ return new String[] {};
        case 672726254: /*synthesisType*/ return new String[] {"CodeableConcept"};
        case 1709211879: /*studyDesign*/ return new String[] {"CodeableConcept"};
        case -2081261232: /*statistic*/ return new String[] {};
        case -1404142937: /*certainty*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.version");
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
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.title");
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
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.date");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.lastReviewDate");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.publisher");
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
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.copyright");
        }
        else if (name.equals("copyrightLabel")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.copyrightLabel");
        }
        else if (name.equals("relatedArtifact")) {
          return addRelatedArtifact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.description");
        }
        else if (name.equals("assertion")) {
          throw new FHIRException("Cannot call addChild on a singleton property Evidence.assertion");
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
        else if (name.equals("studyDesign")) {
          return addStudyDesign();
        }
        else if (name.equals("statistic")) {
          return addStatistic();
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
        dst.versionAlgorithm = versionAlgorithm == null ? null : versionAlgorithm.copy();
        dst.name = name == null ? null : name.copy();
        dst.title = title == null ? null : title.copy();
        dst.citeAs = citeAs == null ? null : citeAs.copy();
        dst.status = status == null ? null : status.copy();
        dst.experimental = experimental == null ? null : experimental.copy();
        dst.date = date == null ? null : date.copy();
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
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.copyrightLabel = copyrightLabel == null ? null : copyrightLabel.copy();
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
        if (studyDesign != null) {
          dst.studyDesign = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : studyDesign)
            dst.studyDesign.add(i.copy());
        };
        if (statistic != null) {
          dst.statistic = new ArrayList<EvidenceStatisticComponent>();
          for (EvidenceStatisticComponent i : statistic)
            dst.statistic.add(i.copy());
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
           && compareDeep(versionAlgorithm, o.versionAlgorithm, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
           && compareDeep(citeAs, o.citeAs, true) && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true)
           && compareDeep(date, o.date, true) && compareDeep(approvalDate, o.approvalDate, true) && compareDeep(lastReviewDate, o.lastReviewDate, true)
           && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true) && compareDeep(author, o.author, true)
           && compareDeep(editor, o.editor, true) && compareDeep(reviewer, o.reviewer, true) && compareDeep(endorser, o.endorser, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(copyrightLabel, o.copyrightLabel, true) && compareDeep(relatedArtifact, o.relatedArtifact, true)
           && compareDeep(description, o.description, true) && compareDeep(assertion, o.assertion, true) && compareDeep(note, o.note, true)
           && compareDeep(variableDefinition, o.variableDefinition, true) && compareDeep(synthesisType, o.synthesisType, true)
           && compareDeep(studyDesign, o.studyDesign, true) && compareDeep(statistic, o.statistic, true) && compareDeep(certainty, o.certainty, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Evidence))
          return false;
        Evidence o = (Evidence) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true)
           && compareValues(date, o.date, true) && compareValues(approvalDate, o.approvalDate, true) && compareValues(lastReviewDate, o.lastReviewDate, true)
           && compareValues(publisher, o.publisher, true) && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true)
           && compareValues(copyrightLabel, o.copyrightLabel, true) && compareValues(description, o.description, true)
           && compareValues(assertion, o.assertion, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , versionAlgorithm, name, title, citeAs, status, experimental, date, approvalDate
          , lastReviewDate, publisher, contact, author, editor, reviewer, endorser, useContext
          , purpose, copyright, copyrightLabel, relatedArtifact, description, assertion, note
          , variableDefinition, synthesisType, studyDesign, statistic, certainty);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Evidence;
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


}

