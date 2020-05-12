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
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Base StructureDefinition for Statistic Type: A fact or piece of data from a  study of a large quantity of numerical data.  A mathematical or quantified characteristic of a group of observations.
 */
@DatatypeDef(name="Statistic")
public class Statistic extends BackboneType implements ICompositeType {

    @Block()
    public static class StatisticSampleSizeComponent extends Element implements IBaseDatatypeElement {
        /**
         * Human-readable summary of population sample size.
         */
        @Child(name = "description", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Textual description of sample size for statistic", formalDefinition="Human-readable summary of population sample size." )
        protected StringType description;

        /**
         * Footnote or explanatory note about the sample size.
         */
        @Child(name = "note", type = {Annotation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Footnote or explanatory note about the sample size", formalDefinition="Footnote or explanatory note about the sample size." )
        protected List<Annotation> note;

        /**
         * Number of participants in the population.
         */
        @Child(name = "numberOfStudies", type = {IntegerType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Number of contributing studies", formalDefinition="Number of participants in the population." )
        protected IntegerType numberOfStudies;

        /**
         * A human-readable string to clarify or explain concepts about the sample size.
         */
        @Child(name = "numberOfParticipants", type = {IntegerType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Cumulative number of participants", formalDefinition="A human-readable string to clarify or explain concepts about the sample size." )
        protected IntegerType numberOfParticipants;

        /**
         * Number of participants with known results for measured variables.
         */
        @Child(name = "knownDataCount", type = {IntegerType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Number of participants with known results for measured variables", formalDefinition="Number of participants with known results for measured variables." )
        protected IntegerType knownDataCount;

        /**
         * Number of participants with “positive” results, only used to report actual numerator count for a proportion.
         */
        @Child(name = "numeratorCount", type = {IntegerType.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Number of participants with “positive” results, only used to report actual numerator count for a proportion", formalDefinition="Number of participants with “positive” results, only used to report actual numerator count for a proportion." )
        protected IntegerType numeratorCount;

        private static final long serialVersionUID = 1908820199L;

    /**
     * Constructor
     */
      public StatisticSampleSizeComponent() {
        super();
      }

        /**
         * @return {@link #description} (Human-readable summary of population sample size.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticSampleSizeComponent.description");
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
         * @param value {@link #description} (Human-readable summary of population sample size.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StatisticSampleSizeComponent setDescriptionElement(StringType value) { 
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
        public StatisticSampleSizeComponent setDescription(String value) { 
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
        public StatisticSampleSizeComponent setNote(List<Annotation> theNote) { 
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

        public StatisticSampleSizeComponent addNote(Annotation t) { //3
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
        public IntegerType getNumberOfStudiesElement() { 
          if (this.numberOfStudies == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticSampleSizeComponent.numberOfStudies");
            else if (Configuration.doAutoCreate())
              this.numberOfStudies = new IntegerType(); // bb
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
        public StatisticSampleSizeComponent setNumberOfStudiesElement(IntegerType value) { 
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
        public StatisticSampleSizeComponent setNumberOfStudies(int value) { 
            if (this.numberOfStudies == null)
              this.numberOfStudies = new IntegerType();
            this.numberOfStudies.setValue(value);
          return this;
        }

        /**
         * @return {@link #numberOfParticipants} (A human-readable string to clarify or explain concepts about the sample size.). This is the underlying object with id, value and extensions. The accessor "getNumberOfParticipants" gives direct access to the value
         */
        public IntegerType getNumberOfParticipantsElement() { 
          if (this.numberOfParticipants == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticSampleSizeComponent.numberOfParticipants");
            else if (Configuration.doAutoCreate())
              this.numberOfParticipants = new IntegerType(); // bb
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
        public StatisticSampleSizeComponent setNumberOfParticipantsElement(IntegerType value) { 
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
        public StatisticSampleSizeComponent setNumberOfParticipants(int value) { 
            if (this.numberOfParticipants == null)
              this.numberOfParticipants = new IntegerType();
            this.numberOfParticipants.setValue(value);
          return this;
        }

        /**
         * @return {@link #knownDataCount} (Number of participants with known results for measured variables.). This is the underlying object with id, value and extensions. The accessor "getKnownDataCount" gives direct access to the value
         */
        public IntegerType getKnownDataCountElement() { 
          if (this.knownDataCount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticSampleSizeComponent.knownDataCount");
            else if (Configuration.doAutoCreate())
              this.knownDataCount = new IntegerType(); // bb
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
        public StatisticSampleSizeComponent setKnownDataCountElement(IntegerType value) { 
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
        public StatisticSampleSizeComponent setKnownDataCount(int value) { 
            if (this.knownDataCount == null)
              this.knownDataCount = new IntegerType();
            this.knownDataCount.setValue(value);
          return this;
        }

        /**
         * @return {@link #numeratorCount} (Number of participants with “positive” results, only used to report actual numerator count for a proportion.). This is the underlying object with id, value and extensions. The accessor "getNumeratorCount" gives direct access to the value
         */
        public IntegerType getNumeratorCountElement() { 
          if (this.numeratorCount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticSampleSizeComponent.numeratorCount");
            else if (Configuration.doAutoCreate())
              this.numeratorCount = new IntegerType(); // bb
          return this.numeratorCount;
        }

        public boolean hasNumeratorCountElement() { 
          return this.numeratorCount != null && !this.numeratorCount.isEmpty();
        }

        public boolean hasNumeratorCount() { 
          return this.numeratorCount != null && !this.numeratorCount.isEmpty();
        }

        /**
         * @param value {@link #numeratorCount} (Number of participants with “positive” results, only used to report actual numerator count for a proportion.). This is the underlying object with id, value and extensions. The accessor "getNumeratorCount" gives direct access to the value
         */
        public StatisticSampleSizeComponent setNumeratorCountElement(IntegerType value) { 
          this.numeratorCount = value;
          return this;
        }

        /**
         * @return Number of participants with “positive” results, only used to report actual numerator count for a proportion.
         */
        public int getNumeratorCount() { 
          return this.numeratorCount == null || this.numeratorCount.isEmpty() ? 0 : this.numeratorCount.getValue();
        }

        /**
         * @param value Number of participants with “positive” results, only used to report actual numerator count for a proportion.
         */
        public StatisticSampleSizeComponent setNumeratorCount(int value) { 
            if (this.numeratorCount == null)
              this.numeratorCount = new IntegerType();
            this.numeratorCount.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "string", "Human-readable summary of population sample size.", 0, 1, description));
          children.add(new Property("note", "Annotation", "Footnote or explanatory note about the sample size.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("numberOfStudies", "integer", "Number of participants in the population.", 0, 1, numberOfStudies));
          children.add(new Property("numberOfParticipants", "integer", "A human-readable string to clarify or explain concepts about the sample size.", 0, 1, numberOfParticipants));
          children.add(new Property("knownDataCount", "integer", "Number of participants with known results for measured variables.", 0, 1, knownDataCount));
          children.add(new Property("numeratorCount", "integer", "Number of participants with “positive” results, only used to report actual numerator count for a proportion.", 0, 1, numeratorCount));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "string", "Human-readable summary of population sample size.", 0, 1, description);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Footnote or explanatory note about the sample size.", 0, java.lang.Integer.MAX_VALUE, note);
          case -177467129: /*numberOfStudies*/  return new Property("numberOfStudies", "integer", "Number of participants in the population.", 0, 1, numberOfStudies);
          case 1799357120: /*numberOfParticipants*/  return new Property("numberOfParticipants", "integer", "A human-readable string to clarify or explain concepts about the sample size.", 0, 1, numberOfParticipants);
          case -937344126: /*knownDataCount*/  return new Property("knownDataCount", "integer", "Number of participants with known results for measured variables.", 0, 1, knownDataCount);
          case -755509242: /*numeratorCount*/  return new Property("numeratorCount", "integer", "Number of participants with “positive” results, only used to report actual numerator count for a proportion.", 0, 1, numeratorCount);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -177467129: /*numberOfStudies*/ return this.numberOfStudies == null ? new Base[0] : new Base[] {this.numberOfStudies}; // IntegerType
        case 1799357120: /*numberOfParticipants*/ return this.numberOfParticipants == null ? new Base[0] : new Base[] {this.numberOfParticipants}; // IntegerType
        case -937344126: /*knownDataCount*/ return this.knownDataCount == null ? new Base[0] : new Base[] {this.knownDataCount}; // IntegerType
        case -755509242: /*numeratorCount*/ return this.numeratorCount == null ? new Base[0] : new Base[] {this.numeratorCount}; // IntegerType
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
        case -177467129: // numberOfStudies
          this.numberOfStudies = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 1799357120: // numberOfParticipants
          this.numberOfParticipants = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -937344126: // knownDataCount
          this.knownDataCount = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -755509242: // numeratorCount
          this.numeratorCount = TypeConvertor.castToInteger(value); // IntegerType
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
        } else if (name.equals("numberOfStudies")) {
          this.numberOfStudies = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("numberOfParticipants")) {
          this.numberOfParticipants = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("knownDataCount")) {
          this.knownDataCount = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("numeratorCount")) {
          this.numeratorCount = TypeConvertor.castToInteger(value); // IntegerType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 3387378:  return addNote(); 
        case -177467129:  return getNumberOfStudiesElement();
        case 1799357120:  return getNumberOfParticipantsElement();
        case -937344126:  return getKnownDataCountElement();
        case -755509242:  return getNumeratorCountElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -177467129: /*numberOfStudies*/ return new String[] {"integer"};
        case 1799357120: /*numberOfParticipants*/ return new String[] {"integer"};
        case -937344126: /*knownDataCount*/ return new String[] {"integer"};
        case -755509242: /*numeratorCount*/ return new String[] {"integer"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Statistic.sampleSize.description");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("numberOfStudies")) {
          throw new FHIRException("Cannot call addChild on a primitive type Statistic.sampleSize.numberOfStudies");
        }
        else if (name.equals("numberOfParticipants")) {
          throw new FHIRException("Cannot call addChild on a primitive type Statistic.sampleSize.numberOfParticipants");
        }
        else if (name.equals("knownDataCount")) {
          throw new FHIRException("Cannot call addChild on a primitive type Statistic.sampleSize.knownDataCount");
        }
        else if (name.equals("numeratorCount")) {
          throw new FHIRException("Cannot call addChild on a primitive type Statistic.sampleSize.numeratorCount");
        }
        else
          return super.addChild(name);
      }

      public StatisticSampleSizeComponent copy() {
        StatisticSampleSizeComponent dst = new StatisticSampleSizeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StatisticSampleSizeComponent dst) {
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
        dst.numeratorCount = numeratorCount == null ? null : numeratorCount.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StatisticSampleSizeComponent))
          return false;
        StatisticSampleSizeComponent o = (StatisticSampleSizeComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(numberOfStudies, o.numberOfStudies, true)
           && compareDeep(numberOfParticipants, o.numberOfParticipants, true) && compareDeep(knownDataCount, o.knownDataCount, true)
           && compareDeep(numeratorCount, o.numeratorCount, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StatisticSampleSizeComponent))
          return false;
        StatisticSampleSizeComponent o = (StatisticSampleSizeComponent) other_;
        return compareValues(description, o.description, true) && compareValues(numberOfStudies, o.numberOfStudies, true)
           && compareValues(numberOfParticipants, o.numberOfParticipants, true) && compareValues(knownDataCount, o.knownDataCount, true)
           && compareValues(numeratorCount, o.numeratorCount, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, numberOfStudies
          , numberOfParticipants, knownDataCount, numeratorCount);
      }

  public String fhirType() {
    return "Statistic.sampleSize";

  }

  }

    @Block()
    public static class StatisticAttributeEstimateComponent extends Element implements IBaseDatatypeElement {
        /**
         * Human-readable summary of the estimate.
         */
        @Child(name = "description", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Textual description of the precision estimate", formalDefinition="Human-readable summary of the estimate." )
        protected StringType description;

        /**
         * Footnote or explanatory note about the estimate.
         */
        @Child(name = "note", type = {Annotation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Footnote or explanatory note about the estimate", formalDefinition="Footnote or explanatory note about the estimate." )
        protected List<Annotation> note;

        /**
         * The estimateType of precision estimate, eg confidence interval or p value type.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The estimateType of precision estimate, eg confidence interval or p value type", formalDefinition="The estimateType of precision estimate, eg confidence interval or p value type." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/attribute-estimate-type")
        protected CodeableConcept type;

        /**
         * The singular quantity of the precision estimate, for precision estimates represented as single values; also used to report unit of measure.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The singular quantity of the precision estimate, for precision estimates represented as single values; also used to report unit of measure", formalDefinition="The singular quantity of the precision estimate, for precision estimates represented as single values; also used to report unit of measure." )
        protected Quantity quantity;

        /**
         * Use 95 for a 95% confidence interval.
         */
        @Child(name = "level", type = {DecimalType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Level of confidence interval, eg 0.95 for 95% confidence interval", formalDefinition="Use 95 for a 95% confidence interval." )
        protected DecimalType level;

        /**
         * Lower bound of confidence interval.
         */
        @Child(name = "range", type = {Range.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Lower and upper bound values of the precision estimate", formalDefinition="Lower bound of confidence interval." )
        protected Range range;

        /**
         * An estimate of the precision of the estimate.
         */
        @Child(name = "estimateQualifier", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="An estimate of the precision of the estimate", formalDefinition="An estimate of the precision of the estimate." )
        protected List<StatisticAttributeEstimateEstimateQualifierComponent> estimateQualifier;

        private static final long serialVersionUID = -682237703L;

    /**
     * Constructor
     */
      public StatisticAttributeEstimateComponent() {
        super();
      }

        /**
         * @return {@link #description} (Human-readable summary of the estimate.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticAttributeEstimateComponent.description");
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
         * @param value {@link #description} (Human-readable summary of the estimate.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StatisticAttributeEstimateComponent setDescriptionElement(StringType value) { 
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
        public StatisticAttributeEstimateComponent setDescription(String value) { 
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
        public StatisticAttributeEstimateComponent setNote(List<Annotation> theNote) { 
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

        public StatisticAttributeEstimateComponent addNote(Annotation t) { //3
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
         * @return {@link #type} (The estimateType of precision estimate, eg confidence interval or p value type.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticAttributeEstimateComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The estimateType of precision estimate, eg confidence interval or p value type.)
         */
        public StatisticAttributeEstimateComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #quantity} (The singular quantity of the precision estimate, for precision estimates represented as single values; also used to report unit of measure.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticAttributeEstimateComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (The singular quantity of the precision estimate, for precision estimates represented as single values; also used to report unit of measure.)
         */
        public StatisticAttributeEstimateComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #level} (Use 95 for a 95% confidence interval.). This is the underlying object with id, value and extensions. The accessor "getLevel" gives direct access to the value
         */
        public DecimalType getLevelElement() { 
          if (this.level == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticAttributeEstimateComponent.level");
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
        public StatisticAttributeEstimateComponent setLevelElement(DecimalType value) { 
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
        public StatisticAttributeEstimateComponent setLevel(BigDecimal value) { 
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
        public StatisticAttributeEstimateComponent setLevel(long value) { 
              this.level = new DecimalType();
            this.level.setValue(value);
          return this;
        }

        /**
         * @param value Use 95 for a 95% confidence interval.
         */
        public StatisticAttributeEstimateComponent setLevel(double value) { 
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
              throw new Error("Attempt to auto-create StatisticAttributeEstimateComponent.range");
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
        public StatisticAttributeEstimateComponent setRange(Range value) { 
          this.range = value;
          return this;
        }

        /**
         * @return {@link #estimateQualifier} (An estimate of the precision of the estimate.)
         */
        public List<StatisticAttributeEstimateEstimateQualifierComponent> getEstimateQualifier() { 
          if (this.estimateQualifier == null)
            this.estimateQualifier = new ArrayList<StatisticAttributeEstimateEstimateQualifierComponent>();
          return this.estimateQualifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public StatisticAttributeEstimateComponent setEstimateQualifier(List<StatisticAttributeEstimateEstimateQualifierComponent> theEstimateQualifier) { 
          this.estimateQualifier = theEstimateQualifier;
          return this;
        }

        public boolean hasEstimateQualifier() { 
          if (this.estimateQualifier == null)
            return false;
          for (StatisticAttributeEstimateEstimateQualifierComponent item : this.estimateQualifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public StatisticAttributeEstimateEstimateQualifierComponent addEstimateQualifier() { //3
          StatisticAttributeEstimateEstimateQualifierComponent t = new StatisticAttributeEstimateEstimateQualifierComponent();
          if (this.estimateQualifier == null)
            this.estimateQualifier = new ArrayList<StatisticAttributeEstimateEstimateQualifierComponent>();
          this.estimateQualifier.add(t);
          return t;
        }

        public StatisticAttributeEstimateComponent addEstimateQualifier(StatisticAttributeEstimateEstimateQualifierComponent t) { //3
          if (t == null)
            return this;
          if (this.estimateQualifier == null)
            this.estimateQualifier = new ArrayList<StatisticAttributeEstimateEstimateQualifierComponent>();
          this.estimateQualifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #estimateQualifier}, creating it if it does not already exist {3}
         */
        public StatisticAttributeEstimateEstimateQualifierComponent getEstimateQualifierFirstRep() { 
          if (getEstimateQualifier().isEmpty()) {
            addEstimateQualifier();
          }
          return getEstimateQualifier().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "string", "Human-readable summary of the estimate.", 0, 1, description));
          children.add(new Property("note", "Annotation", "Footnote or explanatory note about the estimate.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("type", "CodeableConcept", "The estimateType of precision estimate, eg confidence interval or p value type.", 0, 1, type));
          children.add(new Property("quantity", "Quantity", "The singular quantity of the precision estimate, for precision estimates represented as single values; also used to report unit of measure.", 0, 1, quantity));
          children.add(new Property("level", "decimal", "Use 95 for a 95% confidence interval.", 0, 1, level));
          children.add(new Property("range", "Range", "Lower bound of confidence interval.", 0, 1, range));
          children.add(new Property("estimateQualifier", "", "An estimate of the precision of the estimate.", 0, java.lang.Integer.MAX_VALUE, estimateQualifier));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "string", "Human-readable summary of the estimate.", 0, 1, description);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Footnote or explanatory note about the estimate.", 0, java.lang.Integer.MAX_VALUE, note);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The estimateType of precision estimate, eg confidence interval or p value type.", 0, 1, type);
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The singular quantity of the precision estimate, for precision estimates represented as single values; also used to report unit of measure.", 0, 1, quantity);
          case 102865796: /*level*/  return new Property("level", "decimal", "Use 95 for a 95% confidence interval.", 0, 1, level);
          case 108280125: /*range*/  return new Property("range", "Range", "Lower bound of confidence interval.", 0, 1, range);
          case 11745378: /*estimateQualifier*/  return new Property("estimateQualifier", "", "An estimate of the precision of the estimate.", 0, java.lang.Integer.MAX_VALUE, estimateQualifier);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 102865796: /*level*/ return this.level == null ? new Base[0] : new Base[] {this.level}; // DecimalType
        case 108280125: /*range*/ return this.range == null ? new Base[0] : new Base[] {this.range}; // Range
        case 11745378: /*estimateQualifier*/ return this.estimateQualifier == null ? new Base[0] : this.estimateQualifier.toArray(new Base[this.estimateQualifier.size()]); // StatisticAttributeEstimateEstimateQualifierComponent
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
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 102865796: // level
          this.level = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 108280125: // range
          this.range = TypeConvertor.castToRange(value); // Range
          return value;
        case 11745378: // estimateQualifier
          this.getEstimateQualifier().add((StatisticAttributeEstimateEstimateQualifierComponent) value); // StatisticAttributeEstimateEstimateQualifierComponent
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
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("level")) {
          this.level = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("range")) {
          this.range = TypeConvertor.castToRange(value); // Range
        } else if (name.equals("estimateQualifier")) {
          this.getEstimateQualifier().add((StatisticAttributeEstimateEstimateQualifierComponent) value);
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
        case -1285004149:  return getQuantity();
        case 102865796:  return getLevelElement();
        case 108280125:  return getRange();
        case 11745378:  return addEstimateQualifier(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 102865796: /*level*/ return new String[] {"decimal"};
        case 108280125: /*range*/ return new String[] {"Range"};
        case 11745378: /*estimateQualifier*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Statistic.attributeEstimate.description");
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
          throw new FHIRException("Cannot call addChild on a primitive type Statistic.attributeEstimate.level");
        }
        else if (name.equals("range")) {
          this.range = new Range();
          return this.range;
        }
        else if (name.equals("estimateQualifier")) {
          return addEstimateQualifier();
        }
        else
          return super.addChild(name);
      }

      public StatisticAttributeEstimateComponent copy() {
        StatisticAttributeEstimateComponent dst = new StatisticAttributeEstimateComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StatisticAttributeEstimateComponent dst) {
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
        if (estimateQualifier != null) {
          dst.estimateQualifier = new ArrayList<StatisticAttributeEstimateEstimateQualifierComponent>();
          for (StatisticAttributeEstimateEstimateQualifierComponent i : estimateQualifier)
            dst.estimateQualifier.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StatisticAttributeEstimateComponent))
          return false;
        StatisticAttributeEstimateComponent o = (StatisticAttributeEstimateComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(type, o.type, true)
           && compareDeep(quantity, o.quantity, true) && compareDeep(level, o.level, true) && compareDeep(range, o.range, true)
           && compareDeep(estimateQualifier, o.estimateQualifier, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StatisticAttributeEstimateComponent))
          return false;
        StatisticAttributeEstimateComponent o = (StatisticAttributeEstimateComponent) other_;
        return compareValues(description, o.description, true) && compareValues(level, o.level, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, type
          , quantity, level, range, estimateQualifier);
      }

  public String fhirType() {
    return "Statistic.attributeEstimate";

  }

  }

    @Block()
    public static class StatisticAttributeEstimateEstimateQualifierComponent extends Element implements IBaseDatatypeElement {
        /**
         * Human-readable summary of the estimate.
         */
        @Child(name = "description", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Textual description of the precision estimate", formalDefinition="Human-readable summary of the estimate." )
        protected StringType description;

        /**
         * Footnote or explanatory note about the estimate.
         */
        @Child(name = "note", type = {Annotation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Footnote or explanatory note about the estimate", formalDefinition="Footnote or explanatory note about the estimate." )
        protected List<Annotation> note;

        /**
         * The estimateType of attribute estimate, eg confidence interval or p value type.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The estimateType of attribute estimate, eg confidence interval or p value type", formalDefinition="The estimateType of attribute estimate, eg confidence interval or p value type." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/attribute-estimate-type")
        protected CodeableConcept type;

        /**
         * The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure", formalDefinition="The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure." )
        protected Quantity quantity;

        /**
         * Use 95 for a 95% confidence interval.
         */
        @Child(name = "level", type = {DecimalType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Level of confidence interval, eg 0.95 for 95% confidence interval", formalDefinition="Use 95 for a 95% confidence interval." )
        protected DecimalType level;

        /**
         * Lower bound of confidence interval.
         */
        @Child(name = "range", type = {Range.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Lower and upper bound values of the precision estimate", formalDefinition="Lower bound of confidence interval." )
        protected Range range;

        private static final long serialVersionUID = 1873606362L;

    /**
     * Constructor
     */
      public StatisticAttributeEstimateEstimateQualifierComponent() {
        super();
      }

        /**
         * @return {@link #description} (Human-readable summary of the estimate.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticAttributeEstimateEstimateQualifierComponent.description");
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
         * @param value {@link #description} (Human-readable summary of the estimate.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StatisticAttributeEstimateEstimateQualifierComponent setDescriptionElement(StringType value) { 
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
        public StatisticAttributeEstimateEstimateQualifierComponent setDescription(String value) { 
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
        public StatisticAttributeEstimateEstimateQualifierComponent setNote(List<Annotation> theNote) { 
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

        public StatisticAttributeEstimateEstimateQualifierComponent addNote(Annotation t) { //3
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
         * @return {@link #type} (The estimateType of attribute estimate, eg confidence interval or p value type.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticAttributeEstimateEstimateQualifierComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The estimateType of attribute estimate, eg confidence interval or p value type.)
         */
        public StatisticAttributeEstimateEstimateQualifierComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #quantity} (The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticAttributeEstimateEstimateQualifierComponent.quantity");
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
        public StatisticAttributeEstimateEstimateQualifierComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #level} (Use 95 for a 95% confidence interval.). This is the underlying object with id, value and extensions. The accessor "getLevel" gives direct access to the value
         */
        public DecimalType getLevelElement() { 
          if (this.level == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create StatisticAttributeEstimateEstimateQualifierComponent.level");
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
        public StatisticAttributeEstimateEstimateQualifierComponent setLevelElement(DecimalType value) { 
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
        public StatisticAttributeEstimateEstimateQualifierComponent setLevel(BigDecimal value) { 
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
        public StatisticAttributeEstimateEstimateQualifierComponent setLevel(long value) { 
              this.level = new DecimalType();
            this.level.setValue(value);
          return this;
        }

        /**
         * @param value Use 95 for a 95% confidence interval.
         */
        public StatisticAttributeEstimateEstimateQualifierComponent setLevel(double value) { 
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
              throw new Error("Attempt to auto-create StatisticAttributeEstimateEstimateQualifierComponent.range");
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
        public StatisticAttributeEstimateEstimateQualifierComponent setRange(Range value) { 
          this.range = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("description", "string", "Human-readable summary of the estimate.", 0, 1, description));
          children.add(new Property("note", "Annotation", "Footnote or explanatory note about the estimate.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("type", "CodeableConcept", "The estimateType of attribute estimate, eg confidence interval or p value type.", 0, 1, type));
          children.add(new Property("quantity", "Quantity", "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.", 0, 1, quantity));
          children.add(new Property("level", "decimal", "Use 95 for a 95% confidence interval.", 0, 1, level));
          children.add(new Property("range", "Range", "Lower bound of confidence interval.", 0, 1, range));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1724546052: /*description*/  return new Property("description", "string", "Human-readable summary of the estimate.", 0, 1, description);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Footnote or explanatory note about the estimate.", 0, java.lang.Integer.MAX_VALUE, note);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The estimateType of attribute estimate, eg confidence interval or p value type.", 0, 1, type);
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.", 0, 1, quantity);
          case 102865796: /*level*/  return new Property("level", "decimal", "Use 95 for a 95% confidence interval.", 0, 1, level);
          case 108280125: /*range*/  return new Property("range", "Range", "Lower bound of confidence interval.", 0, 1, range);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 102865796: /*level*/ return this.level == null ? new Base[0] : new Base[] {this.level}; // DecimalType
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
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("level")) {
          this.level = TypeConvertor.castToDecimal(value); // DecimalType
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
        case 3575610:  return getType();
        case -1285004149:  return getQuantity();
        case 102865796:  return getLevelElement();
        case 108280125:  return getRange();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 102865796: /*level*/ return new String[] {"decimal"};
        case 108280125: /*range*/ return new String[] {"Range"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Statistic.attributeEstimate.estimateQualifier.description");
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
          throw new FHIRException("Cannot call addChild on a primitive type Statistic.attributeEstimate.estimateQualifier.level");
        }
        else if (name.equals("range")) {
          this.range = new Range();
          return this.range;
        }
        else
          return super.addChild(name);
      }

      public StatisticAttributeEstimateEstimateQualifierComponent copy() {
        StatisticAttributeEstimateEstimateQualifierComponent dst = new StatisticAttributeEstimateEstimateQualifierComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(StatisticAttributeEstimateEstimateQualifierComponent dst) {
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
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof StatisticAttributeEstimateEstimateQualifierComponent))
          return false;
        StatisticAttributeEstimateEstimateQualifierComponent o = (StatisticAttributeEstimateEstimateQualifierComponent) other_;
        return compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(type, o.type, true)
           && compareDeep(quantity, o.quantity, true) && compareDeep(level, o.level, true) && compareDeep(range, o.range, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof StatisticAttributeEstimateEstimateQualifierComponent))
          return false;
        StatisticAttributeEstimateEstimateQualifierComponent o = (StatisticAttributeEstimateEstimateQualifierComponent) other_;
        return compareValues(description, o.description, true) && compareValues(level, o.level, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, type
          , quantity, level, range);
      }

  public String fhirType() {
    return "Statistic.attributeEstimate.estimateQualifier";

  }

  }

    /**
     * A description of the content value of the statistic.
     */
    @Child(name = "description", type = {StringType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Description of content", formalDefinition="A description of the content value of the statistic." )
    protected StringType description;

    /**
     * Footnotes and/or explanatory notes.
     */
    @Child(name = "note", type = {Annotation.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Footnotes and/or explanatory notes", formalDefinition="Footnotes and/or explanatory notes." )
    protected List<Annotation> note;

    /**
     * Type of statistic, eg relative risk.
     */
    @Child(name = "statisticType", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Type of statistic, eg relative risk", formalDefinition="Type of statistic, eg relative risk." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/statistic-type")
    protected CodeableConcept statisticType;

    /**
     * Statistic value.
     */
    @Child(name = "quantity", type = {Quantity.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Statistic value", formalDefinition="Statistic value." )
    protected Quantity quantity;

    /**
     * Number of samples in the statistic.
     */
    @Child(name = "sampleSize", type = {}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Number of samples in the statistic", formalDefinition="Number of samples in the statistic." )
    protected StatisticSampleSizeComponent sampleSize;

    /**
     * An estimate of the precision of the statistic.
     */
    @Child(name = "attributeEstimate", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="An estimate of the precision of the statistic", formalDefinition="An estimate of the precision of the statistic." )
    protected List<StatisticAttributeEstimateComponent> attributeEstimate;

    private static final long serialVersionUID = 1999038309L;

  /**
   * Constructor
   */
    public Statistic() {
      super();
    }

    /**
     * @return {@link #description} (A description of the content value of the statistic.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Statistic.description");
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
     * @param value {@link #description} (A description of the content value of the statistic.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Statistic setDescriptionElement(StringType value) { 
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
    public Statistic setDescription(String value) { 
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
    public Statistic setNote(List<Annotation> theNote) { 
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

    public Statistic addNote(Annotation t) { //3
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
     * @return {@link #statisticType} (Type of statistic, eg relative risk.)
     */
    public CodeableConcept getStatisticType() { 
      if (this.statisticType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Statistic.statisticType");
        else if (Configuration.doAutoCreate())
          this.statisticType = new CodeableConcept(); // cc
      return this.statisticType;
    }

    public boolean hasStatisticType() { 
      return this.statisticType != null && !this.statisticType.isEmpty();
    }

    /**
     * @param value {@link #statisticType} (Type of statistic, eg relative risk.)
     */
    public Statistic setStatisticType(CodeableConcept value) { 
      this.statisticType = value;
      return this;
    }

    /**
     * @return {@link #quantity} (Statistic value.)
     */
    public Quantity getQuantity() { 
      if (this.quantity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Statistic.quantity");
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
    public Statistic setQuantity(Quantity value) { 
      this.quantity = value;
      return this;
    }

    /**
     * @return {@link #sampleSize} (Number of samples in the statistic.)
     */
    public StatisticSampleSizeComponent getSampleSize() { 
      if (this.sampleSize == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Statistic.sampleSize");
        else if (Configuration.doAutoCreate())
          this.sampleSize = new StatisticSampleSizeComponent(); // cc
      return this.sampleSize;
    }

    public boolean hasSampleSize() { 
      return this.sampleSize != null && !this.sampleSize.isEmpty();
    }

    /**
     * @param value {@link #sampleSize} (Number of samples in the statistic.)
     */
    public Statistic setSampleSize(StatisticSampleSizeComponent value) { 
      this.sampleSize = value;
      return this;
    }

    /**
     * @return {@link #attributeEstimate} (An estimate of the precision of the statistic.)
     */
    public List<StatisticAttributeEstimateComponent> getAttributeEstimate() { 
      if (this.attributeEstimate == null)
        this.attributeEstimate = new ArrayList<StatisticAttributeEstimateComponent>();
      return this.attributeEstimate;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Statistic setAttributeEstimate(List<StatisticAttributeEstimateComponent> theAttributeEstimate) { 
      this.attributeEstimate = theAttributeEstimate;
      return this;
    }

    public boolean hasAttributeEstimate() { 
      if (this.attributeEstimate == null)
        return false;
      for (StatisticAttributeEstimateComponent item : this.attributeEstimate)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public StatisticAttributeEstimateComponent addAttributeEstimate() { //3
      StatisticAttributeEstimateComponent t = new StatisticAttributeEstimateComponent();
      if (this.attributeEstimate == null)
        this.attributeEstimate = new ArrayList<StatisticAttributeEstimateComponent>();
      this.attributeEstimate.add(t);
      return t;
    }

    public Statistic addAttributeEstimate(StatisticAttributeEstimateComponent t) { //3
      if (t == null)
        return this;
      if (this.attributeEstimate == null)
        this.attributeEstimate = new ArrayList<StatisticAttributeEstimateComponent>();
      this.attributeEstimate.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #attributeEstimate}, creating it if it does not already exist {3}
     */
    public StatisticAttributeEstimateComponent getAttributeEstimateFirstRep() { 
      if (getAttributeEstimate().isEmpty()) {
        addAttributeEstimate();
      }
      return getAttributeEstimate().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("description", "string", "A description of the content value of the statistic.", 0, 1, description));
        children.add(new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("statisticType", "CodeableConcept", "Type of statistic, eg relative risk.", 0, 1, statisticType));
        children.add(new Property("quantity", "Quantity", "Statistic value.", 0, 1, quantity));
        children.add(new Property("sampleSize", "", "Number of samples in the statistic.", 0, 1, sampleSize));
        children.add(new Property("attributeEstimate", "", "An estimate of the precision of the statistic.", 0, java.lang.Integer.MAX_VALUE, attributeEstimate));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1724546052: /*description*/  return new Property("description", "string", "A description of the content value of the statistic.", 0, 1, description);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0, java.lang.Integer.MAX_VALUE, note);
        case -392342358: /*statisticType*/  return new Property("statisticType", "CodeableConcept", "Type of statistic, eg relative risk.", 0, 1, statisticType);
        case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "Statistic value.", 0, 1, quantity);
        case 143123659: /*sampleSize*/  return new Property("sampleSize", "", "Number of samples in the statistic.", 0, 1, sampleSize);
        case -1539581980: /*attributeEstimate*/  return new Property("attributeEstimate", "", "An estimate of the precision of the statistic.", 0, java.lang.Integer.MAX_VALUE, attributeEstimate);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -392342358: /*statisticType*/ return this.statisticType == null ? new Base[0] : new Base[] {this.statisticType}; // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 143123659: /*sampleSize*/ return this.sampleSize == null ? new Base[0] : new Base[] {this.sampleSize}; // StatisticSampleSizeComponent
        case -1539581980: /*attributeEstimate*/ return this.attributeEstimate == null ? new Base[0] : this.attributeEstimate.toArray(new Base[this.attributeEstimate.size()]); // StatisticAttributeEstimateComponent
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
        case -392342358: // statisticType
          this.statisticType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 143123659: // sampleSize
          this.sampleSize = (StatisticSampleSizeComponent) value; // StatisticSampleSizeComponent
          return value;
        case -1539581980: // attributeEstimate
          this.getAttributeEstimate().add((StatisticAttributeEstimateComponent) value); // StatisticAttributeEstimateComponent
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
        } else if (name.equals("statisticType")) {
          this.statisticType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("sampleSize")) {
          this.sampleSize = (StatisticSampleSizeComponent) value; // StatisticSampleSizeComponent
        } else if (name.equals("attributeEstimate")) {
          this.getAttributeEstimate().add((StatisticAttributeEstimateComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052:  return getDescriptionElement();
        case 3387378:  return addNote(); 
        case -392342358:  return getStatisticType();
        case -1285004149:  return getQuantity();
        case 143123659:  return getSampleSize();
        case -1539581980:  return addAttributeEstimate(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1724546052: /*description*/ return new String[] {"string"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -392342358: /*statisticType*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 143123659: /*sampleSize*/ return new String[] {};
        case -1539581980: /*attributeEstimate*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Statistic.description");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("statisticType")) {
          this.statisticType = new CodeableConcept();
          return this.statisticType;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("sampleSize")) {
          this.sampleSize = new StatisticSampleSizeComponent();
          return this.sampleSize;
        }
        else if (name.equals("attributeEstimate")) {
          return addAttributeEstimate();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Statistic";

  }

      public Statistic copy() {
        Statistic dst = new Statistic();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Statistic dst) {
        super.copyValues(dst);
        dst.description = description == null ? null : description.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.statisticType = statisticType == null ? null : statisticType.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.sampleSize = sampleSize == null ? null : sampleSize.copy();
        if (attributeEstimate != null) {
          dst.attributeEstimate = new ArrayList<StatisticAttributeEstimateComponent>();
          for (StatisticAttributeEstimateComponent i : attributeEstimate)
            dst.attributeEstimate.add(i.copy());
        };
      }

      protected Statistic typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Statistic))
          return false;
        Statistic o = (Statistic) other_;
        return compareDeep(description, o.description, true) && compareDeep(note, o.note, true) && compareDeep(statisticType, o.statisticType, true)
           && compareDeep(quantity, o.quantity, true) && compareDeep(sampleSize, o.sampleSize, true) && compareDeep(attributeEstimate, o.attributeEstimate, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Statistic))
          return false;
        Statistic o = (Statistic) other_;
        return compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, statisticType
          , quantity, sampleSize, attributeEstimate);
      }


}