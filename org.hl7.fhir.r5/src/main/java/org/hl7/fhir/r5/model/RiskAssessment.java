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
 * An assessment of the likely outcome(s) for a patient or other subject as well as the likelihood of each outcome.
 */
@ResourceDef(name="RiskAssessment", profile="http://hl7.org/fhir/StructureDefinition/RiskAssessment")
public class RiskAssessment extends DomainResource {

    @Block()
    public static class RiskAssessmentPredictionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * One of the potential outcomes for the patient (e.g. remission, death,  a particular condition).
         */
        @Child(name = "outcome", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Possible outcome for the subject", formalDefinition="One of the potential outcomes for the patient (e.g. remission, death,  a particular condition)." )
        protected CodeableConcept outcome;

        /**
         * Indicates how likely the outcome is (in the specified timeframe).
         */
        @Child(name = "probability", type = {DecimalType.class, Range.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Likelihood of specified outcome", formalDefinition="Indicates how likely the outcome is (in the specified timeframe)." )
        protected DataType probability;

        /**
         * Indicates how likely the outcome is (in the specified timeframe), expressed as a qualitative value (e.g. low, medium, or high).
         */
        @Child(name = "qualitativeRisk", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Likelihood of specified outcome as a qualitative value", formalDefinition="Indicates how likely the outcome is (in the specified timeframe), expressed as a qualitative value (e.g. low, medium, or high)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/risk-probability")
        protected CodeableConcept qualitativeRisk;

        /**
         * Indicates the risk for this particular subject (with their specific characteristics) divided by the risk of the population in general.  (Numbers greater than 1 = higher risk than the population, numbers less than 1 = lower risk.).
         */
        @Child(name = "relativeRisk", type = {DecimalType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Relative likelihood", formalDefinition="Indicates the risk for this particular subject (with their specific characteristics) divided by the risk of the population in general.  (Numbers greater than 1 = higher risk than the population, numbers less than 1 = lower risk.)." )
        protected DecimalType relativeRisk;

        /**
         * Indicates the period of time or age range of the subject to which the specified probability applies.
         */
        @Child(name = "when", type = {Period.class, Range.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Timeframe or age range", formalDefinition="Indicates the period of time or age range of the subject to which the specified probability applies." )
        protected DataType when;

        /**
         * Additional information explaining the basis for the prediction.
         */
        @Child(name = "rationale", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Explanation of prediction", formalDefinition="Additional information explaining the basis for the prediction." )
        protected StringType rationale;

        private static final long serialVersionUID = -1559504257L;

    /**
     * Constructor
     */
      public RiskAssessmentPredictionComponent() {
        super();
      }

        /**
         * @return {@link #outcome} (One of the potential outcomes for the patient (e.g. remission, death,  a particular condition).)
         */
        public CodeableConcept getOutcome() { 
          if (this.outcome == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RiskAssessmentPredictionComponent.outcome");
            else if (Configuration.doAutoCreate())
              this.outcome = new CodeableConcept(); // cc
          return this.outcome;
        }

        public boolean hasOutcome() { 
          return this.outcome != null && !this.outcome.isEmpty();
        }

        /**
         * @param value {@link #outcome} (One of the potential outcomes for the patient (e.g. remission, death,  a particular condition).)
         */
        public RiskAssessmentPredictionComponent setOutcome(CodeableConcept value) { 
          this.outcome = value;
          return this;
        }

        /**
         * @return {@link #probability} (Indicates how likely the outcome is (in the specified timeframe).)
         */
        public DataType getProbability() { 
          return this.probability;
        }

        /**
         * @return {@link #probability} (Indicates how likely the outcome is (in the specified timeframe).)
         */
        public DecimalType getProbabilityDecimalType() throws FHIRException { 
          if (this.probability == null)
            this.probability = new DecimalType();
          if (!(this.probability instanceof DecimalType))
            throw new FHIRException("Type mismatch: the type DecimalType was expected, but "+this.probability.getClass().getName()+" was encountered");
          return (DecimalType) this.probability;
        }

        public boolean hasProbabilityDecimalType() { 
          return this != null && this.probability instanceof DecimalType;
        }

        /**
         * @return {@link #probability} (Indicates how likely the outcome is (in the specified timeframe).)
         */
        public Range getProbabilityRange() throws FHIRException { 
          if (this.probability == null)
            this.probability = new Range();
          if (!(this.probability instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.probability.getClass().getName()+" was encountered");
          return (Range) this.probability;
        }

        public boolean hasProbabilityRange() { 
          return this != null && this.probability instanceof Range;
        }

        public boolean hasProbability() { 
          return this.probability != null && !this.probability.isEmpty();
        }

        /**
         * @param value {@link #probability} (Indicates how likely the outcome is (in the specified timeframe).)
         */
        public RiskAssessmentPredictionComponent setProbability(DataType value) { 
          if (value != null && !(value instanceof DecimalType || value instanceof Range))
            throw new Error("Not the right type for RiskAssessment.prediction.probability[x]: "+value.fhirType());
          this.probability = value;
          return this;
        }

        /**
         * @return {@link #qualitativeRisk} (Indicates how likely the outcome is (in the specified timeframe), expressed as a qualitative value (e.g. low, medium, or high).)
         */
        public CodeableConcept getQualitativeRisk() { 
          if (this.qualitativeRisk == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RiskAssessmentPredictionComponent.qualitativeRisk");
            else if (Configuration.doAutoCreate())
              this.qualitativeRisk = new CodeableConcept(); // cc
          return this.qualitativeRisk;
        }

        public boolean hasQualitativeRisk() { 
          return this.qualitativeRisk != null && !this.qualitativeRisk.isEmpty();
        }

        /**
         * @param value {@link #qualitativeRisk} (Indicates how likely the outcome is (in the specified timeframe), expressed as a qualitative value (e.g. low, medium, or high).)
         */
        public RiskAssessmentPredictionComponent setQualitativeRisk(CodeableConcept value) { 
          this.qualitativeRisk = value;
          return this;
        }

        /**
         * @return {@link #relativeRisk} (Indicates the risk for this particular subject (with their specific characteristics) divided by the risk of the population in general.  (Numbers greater than 1 = higher risk than the population, numbers less than 1 = lower risk.).). This is the underlying object with id, value and extensions. The accessor "getRelativeRisk" gives direct access to the value
         */
        public DecimalType getRelativeRiskElement() { 
          if (this.relativeRisk == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RiskAssessmentPredictionComponent.relativeRisk");
            else if (Configuration.doAutoCreate())
              this.relativeRisk = new DecimalType(); // bb
          return this.relativeRisk;
        }

        public boolean hasRelativeRiskElement() { 
          return this.relativeRisk != null && !this.relativeRisk.isEmpty();
        }

        public boolean hasRelativeRisk() { 
          return this.relativeRisk != null && !this.relativeRisk.isEmpty();
        }

        /**
         * @param value {@link #relativeRisk} (Indicates the risk for this particular subject (with their specific characteristics) divided by the risk of the population in general.  (Numbers greater than 1 = higher risk than the population, numbers less than 1 = lower risk.).). This is the underlying object with id, value and extensions. The accessor "getRelativeRisk" gives direct access to the value
         */
        public RiskAssessmentPredictionComponent setRelativeRiskElement(DecimalType value) { 
          this.relativeRisk = value;
          return this;
        }

        /**
         * @return Indicates the risk for this particular subject (with their specific characteristics) divided by the risk of the population in general.  (Numbers greater than 1 = higher risk than the population, numbers less than 1 = lower risk.).
         */
        public BigDecimal getRelativeRisk() { 
          return this.relativeRisk == null ? null : this.relativeRisk.getValue();
        }

        /**
         * @param value Indicates the risk for this particular subject (with their specific characteristics) divided by the risk of the population in general.  (Numbers greater than 1 = higher risk than the population, numbers less than 1 = lower risk.).
         */
        public RiskAssessmentPredictionComponent setRelativeRisk(BigDecimal value) { 
          if (value == null)
            this.relativeRisk = null;
          else {
            if (this.relativeRisk == null)
              this.relativeRisk = new DecimalType();
            this.relativeRisk.setValue(value);
          }
          return this;
        }

        /**
         * @param value Indicates the risk for this particular subject (with their specific characteristics) divided by the risk of the population in general.  (Numbers greater than 1 = higher risk than the population, numbers less than 1 = lower risk.).
         */
        public RiskAssessmentPredictionComponent setRelativeRisk(long value) { 
              this.relativeRisk = new DecimalType();
            this.relativeRisk.setValue(value);
          return this;
        }

        /**
         * @param value Indicates the risk for this particular subject (with their specific characteristics) divided by the risk of the population in general.  (Numbers greater than 1 = higher risk than the population, numbers less than 1 = lower risk.).
         */
        public RiskAssessmentPredictionComponent setRelativeRisk(double value) { 
              this.relativeRisk = new DecimalType();
            this.relativeRisk.setValue(value);
          return this;
        }

        /**
         * @return {@link #when} (Indicates the period of time or age range of the subject to which the specified probability applies.)
         */
        public DataType getWhen() { 
          return this.when;
        }

        /**
         * @return {@link #when} (Indicates the period of time or age range of the subject to which the specified probability applies.)
         */
        public Period getWhenPeriod() throws FHIRException { 
          if (this.when == null)
            this.when = new Period();
          if (!(this.when instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.when.getClass().getName()+" was encountered");
          return (Period) this.when;
        }

        public boolean hasWhenPeriod() { 
          return this != null && this.when instanceof Period;
        }

        /**
         * @return {@link #when} (Indicates the period of time or age range of the subject to which the specified probability applies.)
         */
        public Range getWhenRange() throws FHIRException { 
          if (this.when == null)
            this.when = new Range();
          if (!(this.when instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.when.getClass().getName()+" was encountered");
          return (Range) this.when;
        }

        public boolean hasWhenRange() { 
          return this != null && this.when instanceof Range;
        }

        public boolean hasWhen() { 
          return this.when != null && !this.when.isEmpty();
        }

        /**
         * @param value {@link #when} (Indicates the period of time or age range of the subject to which the specified probability applies.)
         */
        public RiskAssessmentPredictionComponent setWhen(DataType value) { 
          if (value != null && !(value instanceof Period || value instanceof Range))
            throw new Error("Not the right type for RiskAssessment.prediction.when[x]: "+value.fhirType());
          this.when = value;
          return this;
        }

        /**
         * @return {@link #rationale} (Additional information explaining the basis for the prediction.). This is the underlying object with id, value and extensions. The accessor "getRationale" gives direct access to the value
         */
        public StringType getRationaleElement() { 
          if (this.rationale == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RiskAssessmentPredictionComponent.rationale");
            else if (Configuration.doAutoCreate())
              this.rationale = new StringType(); // bb
          return this.rationale;
        }

        public boolean hasRationaleElement() { 
          return this.rationale != null && !this.rationale.isEmpty();
        }

        public boolean hasRationale() { 
          return this.rationale != null && !this.rationale.isEmpty();
        }

        /**
         * @param value {@link #rationale} (Additional information explaining the basis for the prediction.). This is the underlying object with id, value and extensions. The accessor "getRationale" gives direct access to the value
         */
        public RiskAssessmentPredictionComponent setRationaleElement(StringType value) { 
          this.rationale = value;
          return this;
        }

        /**
         * @return Additional information explaining the basis for the prediction.
         */
        public String getRationale() { 
          return this.rationale == null ? null : this.rationale.getValue();
        }

        /**
         * @param value Additional information explaining the basis for the prediction.
         */
        public RiskAssessmentPredictionComponent setRationale(String value) { 
          if (Utilities.noString(value))
            this.rationale = null;
          else {
            if (this.rationale == null)
              this.rationale = new StringType();
            this.rationale.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("outcome", "CodeableConcept", "One of the potential outcomes for the patient (e.g. remission, death,  a particular condition).", 0, 1, outcome));
          children.add(new Property("probability[x]", "decimal|Range", "Indicates how likely the outcome is (in the specified timeframe).", 0, 1, probability));
          children.add(new Property("qualitativeRisk", "CodeableConcept", "Indicates how likely the outcome is (in the specified timeframe), expressed as a qualitative value (e.g. low, medium, or high).", 0, 1, qualitativeRisk));
          children.add(new Property("relativeRisk", "decimal", "Indicates the risk for this particular subject (with their specific characteristics) divided by the risk of the population in general.  (Numbers greater than 1 = higher risk than the population, numbers less than 1 = lower risk.).", 0, 1, relativeRisk));
          children.add(new Property("when[x]", "Period|Range", "Indicates the period of time or age range of the subject to which the specified probability applies.", 0, 1, when));
          children.add(new Property("rationale", "string", "Additional information explaining the basis for the prediction.", 0, 1, rationale));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1106507950: /*outcome*/  return new Property("outcome", "CodeableConcept", "One of the potential outcomes for the patient (e.g. remission, death,  a particular condition).", 0, 1, outcome);
          case 1430185003: /*probability[x]*/  return new Property("probability[x]", "decimal|Range", "Indicates how likely the outcome is (in the specified timeframe).", 0, 1, probability);
          case -1290561483: /*probability*/  return new Property("probability[x]", "decimal|Range", "Indicates how likely the outcome is (in the specified timeframe).", 0, 1, probability);
          case 888495452: /*probabilityDecimal*/  return new Property("probability[x]", "decimal", "Indicates how likely the outcome is (in the specified timeframe).", 0, 1, probability);
          case 9275912: /*probabilityRange*/  return new Property("probability[x]", "Range", "Indicates how likely the outcome is (in the specified timeframe).", 0, 1, probability);
          case 123308730: /*qualitativeRisk*/  return new Property("qualitativeRisk", "CodeableConcept", "Indicates how likely the outcome is (in the specified timeframe), expressed as a qualitative value (e.g. low, medium, or high).", 0, 1, qualitativeRisk);
          case -70741061: /*relativeRisk*/  return new Property("relativeRisk", "decimal", "Indicates the risk for this particular subject (with their specific characteristics) divided by the risk of the population in general.  (Numbers greater than 1 = higher risk than the population, numbers less than 1 = lower risk.).", 0, 1, relativeRisk);
          case 1312831238: /*when[x]*/  return new Property("when[x]", "Period|Range", "Indicates the period of time or age range of the subject to which the specified probability applies.", 0, 1, when);
          case 3648314: /*when*/  return new Property("when[x]", "Period|Range", "Indicates the period of time or age range of the subject to which the specified probability applies.", 0, 1, when);
          case 251476379: /*whenPeriod*/  return new Property("when[x]", "Period", "Indicates the period of time or age range of the subject to which the specified probability applies.", 0, 1, when);
          case -1098542557: /*whenRange*/  return new Property("when[x]", "Range", "Indicates the period of time or age range of the subject to which the specified probability applies.", 0, 1, when);
          case 345689335: /*rationale*/  return new Property("rationale", "string", "Additional information explaining the basis for the prediction.", 0, 1, rationale);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1106507950: /*outcome*/ return this.outcome == null ? new Base[0] : new Base[] {this.outcome}; // CodeableConcept
        case -1290561483: /*probability*/ return this.probability == null ? new Base[0] : new Base[] {this.probability}; // DataType
        case 123308730: /*qualitativeRisk*/ return this.qualitativeRisk == null ? new Base[0] : new Base[] {this.qualitativeRisk}; // CodeableConcept
        case -70741061: /*relativeRisk*/ return this.relativeRisk == null ? new Base[0] : new Base[] {this.relativeRisk}; // DecimalType
        case 3648314: /*when*/ return this.when == null ? new Base[0] : new Base[] {this.when}; // DataType
        case 345689335: /*rationale*/ return this.rationale == null ? new Base[0] : new Base[] {this.rationale}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1106507950: // outcome
          this.outcome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1290561483: // probability
          this.probability = TypeConvertor.castToType(value); // DataType
          return value;
        case 123308730: // qualitativeRisk
          this.qualitativeRisk = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -70741061: // relativeRisk
          this.relativeRisk = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 3648314: // when
          this.when = TypeConvertor.castToType(value); // DataType
          return value;
        case 345689335: // rationale
          this.rationale = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("outcome")) {
          this.outcome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("probability[x]")) {
          this.probability = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("qualitativeRisk")) {
          this.qualitativeRisk = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("relativeRisk")) {
          this.relativeRisk = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("when[x]")) {
          this.when = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("rationale")) {
          this.rationale = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1106507950:  return getOutcome();
        case 1430185003:  return getProbability();
        case -1290561483:  return getProbability();
        case 123308730:  return getQualitativeRisk();
        case -70741061:  return getRelativeRiskElement();
        case 1312831238:  return getWhen();
        case 3648314:  return getWhen();
        case 345689335:  return getRationaleElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1106507950: /*outcome*/ return new String[] {"CodeableConcept"};
        case -1290561483: /*probability*/ return new String[] {"decimal", "Range"};
        case 123308730: /*qualitativeRisk*/ return new String[] {"CodeableConcept"};
        case -70741061: /*relativeRisk*/ return new String[] {"decimal"};
        case 3648314: /*when*/ return new String[] {"Period", "Range"};
        case 345689335: /*rationale*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("outcome")) {
          this.outcome = new CodeableConcept();
          return this.outcome;
        }
        else if (name.equals("probabilityDecimal")) {
          this.probability = new DecimalType();
          return this.probability;
        }
        else if (name.equals("probabilityRange")) {
          this.probability = new Range();
          return this.probability;
        }
        else if (name.equals("qualitativeRisk")) {
          this.qualitativeRisk = new CodeableConcept();
          return this.qualitativeRisk;
        }
        else if (name.equals("relativeRisk")) {
          throw new FHIRException("Cannot call addChild on a primitive type RiskAssessment.prediction.relativeRisk");
        }
        else if (name.equals("whenPeriod")) {
          this.when = new Period();
          return this.when;
        }
        else if (name.equals("whenRange")) {
          this.when = new Range();
          return this.when;
        }
        else if (name.equals("rationale")) {
          throw new FHIRException("Cannot call addChild on a primitive type RiskAssessment.prediction.rationale");
        }
        else
          return super.addChild(name);
      }

      public RiskAssessmentPredictionComponent copy() {
        RiskAssessmentPredictionComponent dst = new RiskAssessmentPredictionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RiskAssessmentPredictionComponent dst) {
        super.copyValues(dst);
        dst.outcome = outcome == null ? null : outcome.copy();
        dst.probability = probability == null ? null : probability.copy();
        dst.qualitativeRisk = qualitativeRisk == null ? null : qualitativeRisk.copy();
        dst.relativeRisk = relativeRisk == null ? null : relativeRisk.copy();
        dst.when = when == null ? null : when.copy();
        dst.rationale = rationale == null ? null : rationale.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RiskAssessmentPredictionComponent))
          return false;
        RiskAssessmentPredictionComponent o = (RiskAssessmentPredictionComponent) other_;
        return compareDeep(outcome, o.outcome, true) && compareDeep(probability, o.probability, true) && compareDeep(qualitativeRisk, o.qualitativeRisk, true)
           && compareDeep(relativeRisk, o.relativeRisk, true) && compareDeep(when, o.when, true) && compareDeep(rationale, o.rationale, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RiskAssessmentPredictionComponent))
          return false;
        RiskAssessmentPredictionComponent o = (RiskAssessmentPredictionComponent) other_;
        return compareValues(relativeRisk, o.relativeRisk, true) && compareValues(rationale, o.rationale, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(outcome, probability, qualitativeRisk
          , relativeRisk, when, rationale);
      }

  public String fhirType() {
    return "RiskAssessment.prediction";

  }

  }

    /**
     * Business identifier assigned to the risk assessment.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique identifier for the assessment", formalDefinition="Business identifier assigned to the risk assessment." )
    protected List<Identifier> identifier;

    /**
     * A reference to the request that is fulfilled by this risk assessment.
     */
    @Child(name = "basedOn", type = {Reference.class}, order=1, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Request fulfilled by this assessment", formalDefinition="A reference to the request that is fulfilled by this risk assessment." )
    protected Reference basedOn;

    /**
     * A reference to a resource that this risk assessment is part of, such as a Procedure.
     */
    @Child(name = "parent", type = {Reference.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Part of this occurrence", formalDefinition="A reference to a resource that this risk assessment is part of, such as a Procedure." )
    protected Reference parent;

    /**
     * The status of the RiskAssessment, using the same statuses as an Observation.
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="registered | preliminary | final | amended +", formalDefinition="The status of the RiskAssessment, using the same statuses as an Observation." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-status")
    protected Enumeration<ObservationStatus> status;

    /**
     * The algorithm, process or mechanism used to evaluate the risk.
     */
    @Child(name = "method", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Evaluation mechanism", formalDefinition="The algorithm, process or mechanism used to evaluate the risk." )
    protected CodeableConcept method;

    /**
     * The type of the risk assessment performed.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Type of assessment", formalDefinition="The type of the risk assessment performed." )
    protected CodeableConcept code;

    /**
     * The patient or group the risk assessment applies to.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who/what does assessment apply to?", formalDefinition="The patient or group the risk assessment applies to." )
    protected Reference subject;

    /**
     * The encounter where the assessment was performed.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Where was assessment performed?", formalDefinition="The encounter where the assessment was performed." )
    protected Reference encounter;

    /**
     * The date (and possibly time) the risk assessment was performed.
     */
    @Child(name = "occurrence", type = {DateTimeType.class, Period.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When was assessment made?", formalDefinition="The date (and possibly time) the risk assessment was performed." )
    protected DataType occurrence;

    /**
     * For assessments or prognosis specific to a particular condition, indicates the condition being assessed.
     */
    @Child(name = "condition", type = {Condition.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Condition assessed", formalDefinition="For assessments or prognosis specific to a particular condition, indicates the condition being assessed." )
    protected Reference condition;

    /**
     * The provider or software application that performed the assessment.
     */
    @Child(name = "performer", type = {Practitioner.class, PractitionerRole.class, Device.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who did assessment?", formalDefinition="The provider or software application that performed the assessment." )
    protected Reference performer;

    /**
     * The reason the risk assessment was performed.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Why the assessment was necessary?", formalDefinition="The reason the risk assessment was performed." )
    protected List<CodeableReference> reason;

    /**
     * Indicates the source data considered as part of the assessment (for example, FamilyHistory, Observations, Procedures, Conditions, etc.).
     */
    @Child(name = "basis", type = {Reference.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Information used in assessment", formalDefinition="Indicates the source data considered as part of the assessment (for example, FamilyHistory, Observations, Procedures, Conditions, etc.)." )
    protected List<Reference> basis;

    /**
     * Describes the expected outcome for the subject.
     */
    @Child(name = "prediction", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Outcome predicted", formalDefinition="Describes the expected outcome for the subject." )
    protected List<RiskAssessmentPredictionComponent> prediction;

    /**
     * A description of the steps that might be taken to reduce the identified risk(s).
     */
    @Child(name = "mitigation", type = {StringType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="How to reduce risk", formalDefinition="A description of the steps that might be taken to reduce the identified risk(s)." )
    protected StringType mitigation;

    /**
     * Additional comments about the risk assessment.
     */
    @Child(name = "note", type = {Annotation.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments on the risk assessment", formalDefinition="Additional comments about the risk assessment." )
    protected List<Annotation> note;

    private static final long serialVersionUID = 1076114228L;

  /**
   * Constructor
   */
    public RiskAssessment() {
      super();
    }

  /**
   * Constructor
   */
    public RiskAssessment(ObservationStatus status, Reference subject) {
      super();
      this.setStatus(status);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Business identifier assigned to the risk assessment.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RiskAssessment setIdentifier(List<Identifier> theIdentifier) { 
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

    public RiskAssessment addIdentifier(Identifier t) { //3
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
     * @return {@link #basedOn} (A reference to the request that is fulfilled by this risk assessment.)
     */
    public Reference getBasedOn() { 
      if (this.basedOn == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RiskAssessment.basedOn");
        else if (Configuration.doAutoCreate())
          this.basedOn = new Reference(); // cc
      return this.basedOn;
    }

    public boolean hasBasedOn() { 
      return this.basedOn != null && !this.basedOn.isEmpty();
    }

    /**
     * @param value {@link #basedOn} (A reference to the request that is fulfilled by this risk assessment.)
     */
    public RiskAssessment setBasedOn(Reference value) { 
      this.basedOn = value;
      return this;
    }

    /**
     * @return {@link #parent} (A reference to a resource that this risk assessment is part of, such as a Procedure.)
     */
    public Reference getParent() { 
      if (this.parent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RiskAssessment.parent");
        else if (Configuration.doAutoCreate())
          this.parent = new Reference(); // cc
      return this.parent;
    }

    public boolean hasParent() { 
      return this.parent != null && !this.parent.isEmpty();
    }

    /**
     * @param value {@link #parent} (A reference to a resource that this risk assessment is part of, such as a Procedure.)
     */
    public RiskAssessment setParent(Reference value) { 
      this.parent = value;
      return this;
    }

    /**
     * @return {@link #status} (The status of the RiskAssessment, using the same statuses as an Observation.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<ObservationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RiskAssessment.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<ObservationStatus>(new ObservationStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the RiskAssessment, using the same statuses as an Observation.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public RiskAssessment setStatusElement(Enumeration<ObservationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the RiskAssessment, using the same statuses as an Observation.
     */
    public ObservationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the RiskAssessment, using the same statuses as an Observation.
     */
    public RiskAssessment setStatus(ObservationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<ObservationStatus>(new ObservationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #method} (The algorithm, process or mechanism used to evaluate the risk.)
     */
    public CodeableConcept getMethod() { 
      if (this.method == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RiskAssessment.method");
        else if (Configuration.doAutoCreate())
          this.method = new CodeableConcept(); // cc
      return this.method;
    }

    public boolean hasMethod() { 
      return this.method != null && !this.method.isEmpty();
    }

    /**
     * @param value {@link #method} (The algorithm, process or mechanism used to evaluate the risk.)
     */
    public RiskAssessment setMethod(CodeableConcept value) { 
      this.method = value;
      return this;
    }

    /**
     * @return {@link #code} (The type of the risk assessment performed.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RiskAssessment.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (The type of the risk assessment performed.)
     */
    public RiskAssessment setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #subject} (The patient or group the risk assessment applies to.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RiskAssessment.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The patient or group the risk assessment applies to.)
     */
    public RiskAssessment setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The encounter where the assessment was performed.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RiskAssessment.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The encounter where the assessment was performed.)
     */
    public RiskAssessment setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #occurrence} (The date (and possibly time) the risk assessment was performed.)
     */
    public DataType getOccurrence() { 
      return this.occurrence;
    }

    /**
     * @return {@link #occurrence} (The date (and possibly time) the risk assessment was performed.)
     */
    public DateTimeType getOccurrenceDateTimeType() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new DateTimeType();
      if (!(this.occurrence instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (DateTimeType) this.occurrence;
    }

    public boolean hasOccurrenceDateTimeType() { 
      return this != null && this.occurrence instanceof DateTimeType;
    }

    /**
     * @return {@link #occurrence} (The date (and possibly time) the risk assessment was performed.)
     */
    public Period getOccurrencePeriod() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Period();
      if (!(this.occurrence instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Period) this.occurrence;
    }

    public boolean hasOccurrencePeriod() { 
      return this != null && this.occurrence instanceof Period;
    }

    public boolean hasOccurrence() { 
      return this.occurrence != null && !this.occurrence.isEmpty();
    }

    /**
     * @param value {@link #occurrence} (The date (and possibly time) the risk assessment was performed.)
     */
    public RiskAssessment setOccurrence(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period))
        throw new Error("Not the right type for RiskAssessment.occurrence[x]: "+value.fhirType());
      this.occurrence = value;
      return this;
    }

    /**
     * @return {@link #condition} (For assessments or prognosis specific to a particular condition, indicates the condition being assessed.)
     */
    public Reference getCondition() { 
      if (this.condition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RiskAssessment.condition");
        else if (Configuration.doAutoCreate())
          this.condition = new Reference(); // cc
      return this.condition;
    }

    public boolean hasCondition() { 
      return this.condition != null && !this.condition.isEmpty();
    }

    /**
     * @param value {@link #condition} (For assessments or prognosis specific to a particular condition, indicates the condition being assessed.)
     */
    public RiskAssessment setCondition(Reference value) { 
      this.condition = value;
      return this;
    }

    /**
     * @return {@link #performer} (The provider or software application that performed the assessment.)
     */
    public Reference getPerformer() { 
      if (this.performer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RiskAssessment.performer");
        else if (Configuration.doAutoCreate())
          this.performer = new Reference(); // cc
      return this.performer;
    }

    public boolean hasPerformer() { 
      return this.performer != null && !this.performer.isEmpty();
    }

    /**
     * @param value {@link #performer} (The provider or software application that performed the assessment.)
     */
    public RiskAssessment setPerformer(Reference value) { 
      this.performer = value;
      return this;
    }

    /**
     * @return {@link #reason} (The reason the risk assessment was performed.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RiskAssessment setReason(List<CodeableReference> theReason) { 
      this.reason = theReason;
      return this;
    }

    public boolean hasReason() { 
      if (this.reason == null)
        return false;
      for (CodeableReference item : this.reason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addReason() { //3
      CodeableReference t = new CodeableReference();
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return t;
    }

    public RiskAssessment addReason(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
     */
    public CodeableReference getReasonFirstRep() { 
      if (getReason().isEmpty()) {
        addReason();
      }
      return getReason().get(0);
    }

    /**
     * @return {@link #basis} (Indicates the source data considered as part of the assessment (for example, FamilyHistory, Observations, Procedures, Conditions, etc.).)
     */
    public List<Reference> getBasis() { 
      if (this.basis == null)
        this.basis = new ArrayList<Reference>();
      return this.basis;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RiskAssessment setBasis(List<Reference> theBasis) { 
      this.basis = theBasis;
      return this;
    }

    public boolean hasBasis() { 
      if (this.basis == null)
        return false;
      for (Reference item : this.basis)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addBasis() { //3
      Reference t = new Reference();
      if (this.basis == null)
        this.basis = new ArrayList<Reference>();
      this.basis.add(t);
      return t;
    }

    public RiskAssessment addBasis(Reference t) { //3
      if (t == null)
        return this;
      if (this.basis == null)
        this.basis = new ArrayList<Reference>();
      this.basis.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #basis}, creating it if it does not already exist {3}
     */
    public Reference getBasisFirstRep() { 
      if (getBasis().isEmpty()) {
        addBasis();
      }
      return getBasis().get(0);
    }

    /**
     * @return {@link #prediction} (Describes the expected outcome for the subject.)
     */
    public List<RiskAssessmentPredictionComponent> getPrediction() { 
      if (this.prediction == null)
        this.prediction = new ArrayList<RiskAssessmentPredictionComponent>();
      return this.prediction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RiskAssessment setPrediction(List<RiskAssessmentPredictionComponent> thePrediction) { 
      this.prediction = thePrediction;
      return this;
    }

    public boolean hasPrediction() { 
      if (this.prediction == null)
        return false;
      for (RiskAssessmentPredictionComponent item : this.prediction)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RiskAssessmentPredictionComponent addPrediction() { //3
      RiskAssessmentPredictionComponent t = new RiskAssessmentPredictionComponent();
      if (this.prediction == null)
        this.prediction = new ArrayList<RiskAssessmentPredictionComponent>();
      this.prediction.add(t);
      return t;
    }

    public RiskAssessment addPrediction(RiskAssessmentPredictionComponent t) { //3
      if (t == null)
        return this;
      if (this.prediction == null)
        this.prediction = new ArrayList<RiskAssessmentPredictionComponent>();
      this.prediction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #prediction}, creating it if it does not already exist {3}
     */
    public RiskAssessmentPredictionComponent getPredictionFirstRep() { 
      if (getPrediction().isEmpty()) {
        addPrediction();
      }
      return getPrediction().get(0);
    }

    /**
     * @return {@link #mitigation} (A description of the steps that might be taken to reduce the identified risk(s).). This is the underlying object with id, value and extensions. The accessor "getMitigation" gives direct access to the value
     */
    public StringType getMitigationElement() { 
      if (this.mitigation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RiskAssessment.mitigation");
        else if (Configuration.doAutoCreate())
          this.mitigation = new StringType(); // bb
      return this.mitigation;
    }

    public boolean hasMitigationElement() { 
      return this.mitigation != null && !this.mitigation.isEmpty();
    }

    public boolean hasMitigation() { 
      return this.mitigation != null && !this.mitigation.isEmpty();
    }

    /**
     * @param value {@link #mitigation} (A description of the steps that might be taken to reduce the identified risk(s).). This is the underlying object with id, value and extensions. The accessor "getMitigation" gives direct access to the value
     */
    public RiskAssessment setMitigationElement(StringType value) { 
      this.mitigation = value;
      return this;
    }

    /**
     * @return A description of the steps that might be taken to reduce the identified risk(s).
     */
    public String getMitigation() { 
      return this.mitigation == null ? null : this.mitigation.getValue();
    }

    /**
     * @param value A description of the steps that might be taken to reduce the identified risk(s).
     */
    public RiskAssessment setMitigation(String value) { 
      if (Utilities.noString(value))
        this.mitigation = null;
      else {
        if (this.mitigation == null)
          this.mitigation = new StringType();
        this.mitigation.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #note} (Additional comments about the risk assessment.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RiskAssessment setNote(List<Annotation> theNote) { 
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

    public RiskAssessment addNote(Annotation t) { //3
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

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier assigned to the risk assessment.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(Any)", "A reference to the request that is fulfilled by this risk assessment.", 0, 1, basedOn));
        children.add(new Property("parent", "Reference(Any)", "A reference to a resource that this risk assessment is part of, such as a Procedure.", 0, 1, parent));
        children.add(new Property("status", "code", "The status of the RiskAssessment, using the same statuses as an Observation.", 0, 1, status));
        children.add(new Property("method", "CodeableConcept", "The algorithm, process or mechanism used to evaluate the risk.", 0, 1, method));
        children.add(new Property("code", "CodeableConcept", "The type of the risk assessment performed.", 0, 1, code));
        children.add(new Property("subject", "Reference(Patient|Group)", "The patient or group the risk assessment applies to.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The encounter where the assessment was performed.", 0, 1, encounter));
        children.add(new Property("occurrence[x]", "dateTime|Period", "The date (and possibly time) the risk assessment was performed.", 0, 1, occurrence));
        children.add(new Property("condition", "Reference(Condition)", "For assessments or prognosis specific to a particular condition, indicates the condition being assessed.", 0, 1, condition));
        children.add(new Property("performer", "Reference(Practitioner|PractitionerRole|Device)", "The provider or software application that performed the assessment.", 0, 1, performer));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "The reason the risk assessment was performed.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("basis", "Reference(Any)", "Indicates the source data considered as part of the assessment (for example, FamilyHistory, Observations, Procedures, Conditions, etc.).", 0, java.lang.Integer.MAX_VALUE, basis));
        children.add(new Property("prediction", "", "Describes the expected outcome for the subject.", 0, java.lang.Integer.MAX_VALUE, prediction));
        children.add(new Property("mitigation", "string", "A description of the steps that might be taken to reduce the identified risk(s).", 0, 1, mitigation));
        children.add(new Property("note", "Annotation", "Additional comments about the risk assessment.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier assigned to the risk assessment.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(Any)", "A reference to the request that is fulfilled by this risk assessment.", 0, 1, basedOn);
        case -995424086: /*parent*/  return new Property("parent", "Reference(Any)", "A reference to a resource that this risk assessment is part of, such as a Procedure.", 0, 1, parent);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the RiskAssessment, using the same statuses as an Observation.", 0, 1, status);
        case -1077554975: /*method*/  return new Property("method", "CodeableConcept", "The algorithm, process or mechanism used to evaluate the risk.", 0, 1, method);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The type of the risk assessment performed.", 0, 1, code);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The patient or group the risk assessment applies to.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The encounter where the assessment was performed.", 0, 1, encounter);
        case -2022646513: /*occurrence[x]*/  return new Property("occurrence[x]", "dateTime|Period", "The date (and possibly time) the risk assessment was performed.", 0, 1, occurrence);
        case 1687874001: /*occurrence*/  return new Property("occurrence[x]", "dateTime|Period", "The date (and possibly time) the risk assessment was performed.", 0, 1, occurrence);
        case -298443636: /*occurrenceDateTime*/  return new Property("occurrence[x]", "dateTime", "The date (and possibly time) the risk assessment was performed.", 0, 1, occurrence);
        case 1397156594: /*occurrencePeriod*/  return new Property("occurrence[x]", "Period", "The date (and possibly time) the risk assessment was performed.", 0, 1, occurrence);
        case -861311717: /*condition*/  return new Property("condition", "Reference(Condition)", "For assessments or prognosis specific to a particular condition, indicates the condition being assessed.", 0, 1, condition);
        case 481140686: /*performer*/  return new Property("performer", "Reference(Practitioner|PractitionerRole|Device)", "The provider or software application that performed the assessment.", 0, 1, performer);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "The reason the risk assessment was performed.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 93508670: /*basis*/  return new Property("basis", "Reference(Any)", "Indicates the source data considered as part of the assessment (for example, FamilyHistory, Observations, Procedures, Conditions, etc.).", 0, java.lang.Integer.MAX_VALUE, basis);
        case 1161234575: /*prediction*/  return new Property("prediction", "", "Describes the expected outcome for the subject.", 0, java.lang.Integer.MAX_VALUE, prediction);
        case 1293793087: /*mitigation*/  return new Property("mitigation", "string", "A description of the steps that might be taken to reduce the identified risk(s).", 0, 1, mitigation);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Additional comments about the risk assessment.", 0, java.lang.Integer.MAX_VALUE, note);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : new Base[] {this.basedOn}; // Reference
        case -995424086: /*parent*/ return this.parent == null ? new Base[0] : new Base[] {this.parent}; // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<ObservationStatus>
        case -1077554975: /*method*/ return this.method == null ? new Base[0] : new Base[] {this.method}; // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 1687874001: /*occurrence*/ return this.occurrence == null ? new Base[0] : new Base[] {this.occurrence}; // DataType
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : new Base[] {this.condition}; // Reference
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : new Base[] {this.performer}; // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 93508670: /*basis*/ return this.basis == null ? new Base[0] : this.basis.toArray(new Base[this.basis.size()]); // Reference
        case 1161234575: /*prediction*/ return this.prediction == null ? new Base[0] : this.prediction.toArray(new Base[this.prediction.size()]); // RiskAssessmentPredictionComponent
        case 1293793087: /*mitigation*/ return this.mitigation == null ? new Base[0] : new Base[] {this.mitigation}; // StringType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -332612366: // basedOn
          this.basedOn = TypeConvertor.castToReference(value); // Reference
          return value;
        case -995424086: // parent
          this.parent = TypeConvertor.castToReference(value); // Reference
          return value;
        case -892481550: // status
          value = new ObservationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ObservationStatus>
          return value;
        case -1077554975: // method
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1687874001: // occurrence
          this.occurrence = TypeConvertor.castToType(value); // DataType
          return value;
        case -861311717: // condition
          this.condition = TypeConvertor.castToReference(value); // Reference
          return value;
        case 481140686: // performer
          this.performer = TypeConvertor.castToReference(value); // Reference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 93508670: // basis
          this.getBasis().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1161234575: // prediction
          this.getPrediction().add((RiskAssessmentPredictionComponent) value); // RiskAssessmentPredictionComponent
          return value;
        case 1293793087: // mitigation
          this.mitigation = TypeConvertor.castToString(value); // StringType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("basedOn")) {
          this.basedOn = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("parent")) {
          this.parent = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("status")) {
          value = new ObservationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ObservationStatus>
        } else if (name.equals("method")) {
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("occurrence[x]")) {
          this.occurrence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("condition")) {
          this.condition = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("performer")) {
          this.performer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("basis")) {
          this.getBasis().add(TypeConvertor.castToReference(value));
        } else if (name.equals("prediction")) {
          this.getPrediction().add((RiskAssessmentPredictionComponent) value);
        } else if (name.equals("mitigation")) {
          this.mitigation = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -332612366:  return getBasedOn();
        case -995424086:  return getParent();
        case -892481550:  return getStatusElement();
        case -1077554975:  return getMethod();
        case 3059181:  return getCode();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -2022646513:  return getOccurrence();
        case 1687874001:  return getOccurrence();
        case -861311717:  return getCondition();
        case 481140686:  return getPerformer();
        case -934964668:  return addReason(); 
        case 93508670:  return addBasis(); 
        case 1161234575:  return addPrediction(); 
        case 1293793087:  return getMitigationElement();
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -995424086: /*parent*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1077554975: /*method*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 1687874001: /*occurrence*/ return new String[] {"dateTime", "Period"};
        case -861311717: /*condition*/ return new String[] {"Reference"};
        case 481140686: /*performer*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 93508670: /*basis*/ return new String[] {"Reference"};
        case 1161234575: /*prediction*/ return new String[] {};
        case 1293793087: /*mitigation*/ return new String[] {"string"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("basedOn")) {
          this.basedOn = new Reference();
          return this.basedOn;
        }
        else if (name.equals("parent")) {
          this.parent = new Reference();
          return this.parent;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type RiskAssessment.status");
        }
        else if (name.equals("method")) {
          this.method = new CodeableConcept();
          return this.method;
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("occurrenceDateTime")) {
          this.occurrence = new DateTimeType();
          return this.occurrence;
        }
        else if (name.equals("occurrencePeriod")) {
          this.occurrence = new Period();
          return this.occurrence;
        }
        else if (name.equals("condition")) {
          this.condition = new Reference();
          return this.condition;
        }
        else if (name.equals("performer")) {
          this.performer = new Reference();
          return this.performer;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("basis")) {
          return addBasis();
        }
        else if (name.equals("prediction")) {
          return addPrediction();
        }
        else if (name.equals("mitigation")) {
          throw new FHIRException("Cannot call addChild on a primitive type RiskAssessment.mitigation");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "RiskAssessment";

  }

      public RiskAssessment copy() {
        RiskAssessment dst = new RiskAssessment();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RiskAssessment dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.basedOn = basedOn == null ? null : basedOn.copy();
        dst.parent = parent == null ? null : parent.copy();
        dst.status = status == null ? null : status.copy();
        dst.method = method == null ? null : method.copy();
        dst.code = code == null ? null : code.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.occurrence = occurrence == null ? null : occurrence.copy();
        dst.condition = condition == null ? null : condition.copy();
        dst.performer = performer == null ? null : performer.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        if (basis != null) {
          dst.basis = new ArrayList<Reference>();
          for (Reference i : basis)
            dst.basis.add(i.copy());
        };
        if (prediction != null) {
          dst.prediction = new ArrayList<RiskAssessmentPredictionComponent>();
          for (RiskAssessmentPredictionComponent i : prediction)
            dst.prediction.add(i.copy());
        };
        dst.mitigation = mitigation == null ? null : mitigation.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      protected RiskAssessment typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RiskAssessment))
          return false;
        RiskAssessment o = (RiskAssessment) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(parent, o.parent, true)
           && compareDeep(status, o.status, true) && compareDeep(method, o.method, true) && compareDeep(code, o.code, true)
           && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true) && compareDeep(occurrence, o.occurrence, true)
           && compareDeep(condition, o.condition, true) && compareDeep(performer, o.performer, true) && compareDeep(reason, o.reason, true)
           && compareDeep(basis, o.basis, true) && compareDeep(prediction, o.prediction, true) && compareDeep(mitigation, o.mitigation, true)
           && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RiskAssessment))
          return false;
        RiskAssessment o = (RiskAssessment) other_;
        return compareValues(status, o.status, true) && compareValues(mitigation, o.mitigation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, parent
          , status, method, code, subject, encounter, occurrence, condition, performer
          , reason, basis, prediction, mitigation, note);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.RiskAssessment;
   }

 /**
   * Search parameter: <b>condition</b>
   * <p>
   * Description: <b>Condition assessed</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RiskAssessment.condition</b><br>
   * </p>
   */
  @SearchParamDefinition(name="condition", path="RiskAssessment.condition", description="Condition assessed", type="reference", target={Condition.class } )
  public static final String SP_CONDITION = "condition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>condition</b>
   * <p>
   * Description: <b>Condition assessed</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RiskAssessment.condition</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CONDITION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CONDITION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RiskAssessment:condition</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CONDITION = new ca.uhn.fhir.model.api.Include("RiskAssessment:condition").toLocked();

 /**
   * Search parameter: <b>method</b>
   * <p>
   * Description: <b>Evaluation mechanism</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RiskAssessment.method</b><br>
   * </p>
   */
  @SearchParamDefinition(name="method", path="RiskAssessment.method", description="Evaluation mechanism", type="token" )
  public static final String SP_METHOD = "method";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>method</b>
   * <p>
   * Description: <b>Evaluation mechanism</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RiskAssessment.method</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam METHOD = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_METHOD);

 /**
   * Search parameter: <b>performer</b>
   * <p>
   * Description: <b>Who did assessment?</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RiskAssessment.performer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performer", path="RiskAssessment.performer", description="Who did assessment?", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Device.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_PERFORMER = "performer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>performer</b>
   * <p>
   * Description: <b>Who did assessment?</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RiskAssessment.performer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PERFORMER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PERFORMER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RiskAssessment:performer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PERFORMER = new ca.uhn.fhir.model.api.Include("RiskAssessment:performer").toLocked();

 /**
   * Search parameter: <b>probability</b>
   * <p>
   * Description: <b>Likelihood of specified outcome</b><br>
   * Type: <b>number</b><br>
   * Path: <b>RiskAssessment.prediction.probability</b><br>
   * </p>
   */
  @SearchParamDefinition(name="probability", path="RiskAssessment.prediction.probability", description="Likelihood of specified outcome", type="number" )
  public static final String SP_PROBABILITY = "probability";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>probability</b>
   * <p>
   * Description: <b>Likelihood of specified outcome</b><br>
   * Type: <b>number</b><br>
   * Path: <b>RiskAssessment.prediction.probability</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.NumberClientParam PROBABILITY = new ca.uhn.fhir.rest.gclient.NumberClientParam(SP_PROBABILITY);

 /**
   * Search parameter: <b>risk</b>
   * <p>
   * Description: <b>Likelihood of specified outcome as a qualitative value</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RiskAssessment.prediction.qualitativeRisk</b><br>
   * </p>
   */
  @SearchParamDefinition(name="risk", path="RiskAssessment.prediction.qualitativeRisk", description="Likelihood of specified outcome as a qualitative value", type="token" )
  public static final String SP_RISK = "risk";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>risk</b>
   * <p>
   * Description: <b>Likelihood of specified outcome as a qualitative value</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RiskAssessment.prediction.qualitativeRisk</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam RISK = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_RISK);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Who/what does assessment apply to?</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RiskAssessment.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="RiskAssessment.subject", description="Who/what does assessment apply to?", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Who/what does assessment apply to?</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RiskAssessment.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RiskAssessment:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("RiskAssessment:subject").toLocked();

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [Encounter](encounter.html): A date within the period the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [List](list.html): When the list was prepared
* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.dateTime | DiagnosticReport.effective | Encounter.period | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective | Procedure.occurrence | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.dateTime | DiagnosticReport.effective | Encounter.period | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective | Procedure.occurrence | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded\r\n* [CarePlan](careplan.html): Time period plan covers\r\n* [CareTeam](careteam.html): A date within the coverage time period.\r\n* [ClinicalImpression](clinicalimpression.html): When the assessment was documented\r\n* [Composition](composition.html): Composition editing time\r\n* [Consent](consent.html): When consent was agreed to\r\n* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report\r\n* [Encounter](encounter.html): A date within the period the Encounter lasted\r\n* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period\r\n* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated\r\n* [Flag](flag.html): Time period when flag is active\r\n* [Immunization](immunization.html): Vaccination  (non)-Administration Date\r\n* [List](list.html): When the list was prepared\r\n* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period\r\n* [Procedure](procedure.html): When the procedure occurred or is occurring\r\n* [RiskAssessment](riskassessment.html): When was assessment made?\r\n* [SupplyRequest](supplyrequest.html): When the request was made\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [Encounter](encounter.html): A date within the period the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [List](list.html): When the list was prepared
* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.dateTime | DiagnosticReport.effective | Encounter.period | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective | Procedure.occurrence | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Composition](composition.html): Context of the Composition
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [DocumentReference](documentreference.html): Context of the document  content
* [Flag](flag.html): Alert relevant during encounter
* [List](list.html): Context in which list created
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Composition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | DocumentReference.context.encounter | Flag.encounter | List.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | RiskAssessment.encounter | ServiceRequest.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="Composition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | DocumentReference.context.encounter | Flag.encounter | List.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | RiskAssessment.encounter | ServiceRequest.encounter | VisionPrescription.encounter", description="Multiple Resources: \r\n\r\n* [Composition](composition.html): Context of the Composition\r\n* [DeviceRequest](devicerequest.html): Encounter during which request was created\r\n* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made\r\n* [DocumentReference](documentreference.html): Context of the document  content\r\n* [Flag](flag.html): Alert relevant during encounter\r\n* [List](list.html): Context in which list created\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier\r\n* [Observation](observation.html): Encounter related to the observation\r\n* [Procedure](procedure.html): The Encounter during which this Procedure was created\r\n* [RiskAssessment](riskassessment.html): Where was assessment performed?\r\n* [ServiceRequest](servicerequest.html): An encounter in which this request is made\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier\r\n", type="reference", target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Composition](composition.html): Context of the Composition
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [DocumentReference](documentreference.html): Context of the document  content
* [Flag](flag.html): Alert relevant during encounter
* [List](list.html): Context in which list created
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Composition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | DocumentReference.context.encounter | Flag.encounter | List.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | RiskAssessment.encounter | ServiceRequest.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RiskAssessment:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("RiskAssessment:encounter").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents
* [DocumentReference](documentreference.html): Master Version Specific Identifier
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number
* [Immunization](immunization.html): Business identifier
* [List](list.html): Business identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationUsage](medicationusage.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Procedure](procedure.html): A unique identifier for a procedure
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents\r\n* [DocumentReference](documentreference.html): Master Version Specific Identifier\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number\r\n* [Immunization](immunization.html): Business identifier\r\n* [List](list.html): Business identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationUsage](medicationusage.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents
* [DocumentReference](documentreference.html): Master Version Specific Identifier
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number
* [Immunization](immunization.html): Business identifier
* [List](list.html): Business identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationUsage](medicationusage.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Procedure](procedure.html): A unique identifier for a procedure
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient or group assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient or group present at the encounter
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [List](list.html): If all resources have the same subject
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ClinicalImpression](clinicalimpression.html): Patient or group assessed\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentManifest](documentmanifest.html): The subject of the set of documents\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient or group present at the encounter\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [List](list.html): If all resources have the same subject\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", target={Group.class, Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient or group assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient or group present at the encounter
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [List](list.html): If all resources have the same subject
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RiskAssessment:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("RiskAssessment:patient").toLocked();


}