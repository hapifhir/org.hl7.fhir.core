package org.hl7.fhir.r4b.model;

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

// Generated on Tue, May 4, 2021 07:17+1000 for FHIR v4.3.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.*;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r4b.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * Base StructureDefinition for Statistic Type: A fact or piece of data from a
 * study of a large quantity of numerical data. A mathematical or quantified
 * characteristic of a group of observations.
 */
@DatatypeDef(name = "Statistic")
public class Statistic extends BackboneType implements ICompositeType {

  @Block()
  public static class StatisticSampleSizeComponent extends Element implements IBaseDatatypeElement {
    /**
     * Human-readable summary of population sample size.
     */
    @Child(name = "description", type = {
        StringType.class }, order = 1, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Textual description of sample size for statistic", formalDefinition = "Human-readable summary of population sample size.")
    protected StringType description;

    /**
     * Footnote or explanatory note about the sample size.
     */
    @Child(name = "note", type = {
        Annotation.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
    @Description(shortDefinition = "Footnote or explanatory note about the sample size", formalDefinition = "Footnote or explanatory note about the sample size.")
    protected List<Annotation> note;

    /**
     * Number of participants in the population.
     */
    @Child(name = "numberOfStudies", type = {
        UnsignedIntType.class }, order = 3, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Number of contributing studies", formalDefinition = "Number of participants in the population.")
    protected UnsignedIntType numberOfStudies;

    /**
     * A human-readable string to clarify or explain concepts about the sample size.
     */
    @Child(name = "numberOfParticipants", type = {
        UnsignedIntType.class }, order = 4, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Cumulative number of participants", formalDefinition = "A human-readable string to clarify or explain concepts about the sample size.")
    protected UnsignedIntType numberOfParticipants;

    /**
     * Number of participants with known results for measured variables.
     */
    @Child(name = "knownDataCount", type = {
        UnsignedIntType.class }, order = 5, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Number of participants with known results for measured variables", formalDefinition = "Number of participants with known results for measured variables.")
    protected UnsignedIntType knownDataCount;

    private static final long serialVersionUID = -1870635979L;

    /**
     * Constructor
     */
    public StatisticSampleSizeComponent() {
      super();
    }

    /**
     * @return {@link #description} (Human-readable summary of population sample
     *         size.). This is the underlying object with id, value and extensions.
     *         The accessor "getDescription" gives direct access to the value
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
     * @param value {@link #description} (Human-readable summary of population
     *              sample size.). This is the underlying object with id, value and
     *              extensions. The accessor "getDescription" gives direct access to
     *              the value
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

    public Annotation addNote() { // 3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public StatisticSampleSizeComponent addNote(Annotation t) { // 3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if
     *         it does not already exist {3}
     */
    public Annotation getNoteFirstRep() {
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

    /**
     * @return {@link #numberOfStudies} (Number of participants in the population.).
     *         This is the underlying object with id, value and extensions. The
     *         accessor "getNumberOfStudies" gives direct access to the value
     */
    public UnsignedIntType getNumberOfStudiesElement() {
      if (this.numberOfStudies == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StatisticSampleSizeComponent.numberOfStudies");
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
     * @param value {@link #numberOfStudies} (Number of participants in the
     *              population.). This is the underlying object with id, value and
     *              extensions. The accessor "getNumberOfStudies" gives direct
     *              access to the value
     */
    public StatisticSampleSizeComponent setNumberOfStudiesElement(UnsignedIntType value) {
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
        this.numberOfStudies = new UnsignedIntType();
      this.numberOfStudies.setValue(value);
      return this;
    }

    /**
     * @return {@link #numberOfParticipants} (A human-readable string to clarify or
     *         explain concepts about the sample size.). This is the underlying
     *         object with id, value and extensions. The accessor
     *         "getNumberOfParticipants" gives direct access to the value
     */
    public UnsignedIntType getNumberOfParticipantsElement() {
      if (this.numberOfParticipants == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StatisticSampleSizeComponent.numberOfParticipants");
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
     * @param value {@link #numberOfParticipants} (A human-readable string to
     *              clarify or explain concepts about the sample size.). This is the
     *              underlying object with id, value and extensions. The accessor
     *              "getNumberOfParticipants" gives direct access to the value
     */
    public StatisticSampleSizeComponent setNumberOfParticipantsElement(UnsignedIntType value) {
      this.numberOfParticipants = value;
      return this;
    }

    /**
     * @return A human-readable string to clarify or explain concepts about the
     *         sample size.
     */
    public int getNumberOfParticipants() {
      return this.numberOfParticipants == null || this.numberOfParticipants.isEmpty() ? 0
          : this.numberOfParticipants.getValue();
    }

    /**
     * @param value A human-readable string to clarify or explain concepts about the
     *              sample size.
     */
    public StatisticSampleSizeComponent setNumberOfParticipants(int value) {
      if (this.numberOfParticipants == null)
        this.numberOfParticipants = new UnsignedIntType();
      this.numberOfParticipants.setValue(value);
      return this;
    }

    /**
     * @return {@link #knownDataCount} (Number of participants with known results
     *         for measured variables.). This is the underlying object with id,
     *         value and extensions. The accessor "getKnownDataCount" gives direct
     *         access to the value
     */
    public UnsignedIntType getKnownDataCountElement() {
      if (this.knownDataCount == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StatisticSampleSizeComponent.knownDataCount");
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
     * @param value {@link #knownDataCount} (Number of participants with known
     *              results for measured variables.). This is the underlying object
     *              with id, value and extensions. The accessor "getKnownDataCount"
     *              gives direct access to the value
     */
    public StatisticSampleSizeComponent setKnownDataCountElement(UnsignedIntType value) {
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
     * @param value Number of participants with known results for measured
     *              variables.
     */
    public StatisticSampleSizeComponent setKnownDataCount(int value) {
      if (this.knownDataCount == null)
        this.knownDataCount = new UnsignedIntType();
      this.knownDataCount.setValue(value);
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("description", "string", "Human-readable summary of population sample size.", 0, 1,
          description));
      children.add(new Property("note", "Annotation", "Footnote or explanatory note about the sample size.", 0,
          java.lang.Integer.MAX_VALUE, note));
      children.add(new Property("numberOfStudies", "unsignedInt", "Number of participants in the population.", 0, 1,
          numberOfStudies));
      children.add(new Property("numberOfParticipants", "unsignedInt",
          "A human-readable string to clarify or explain concepts about the sample size.", 0, 1, numberOfParticipants));
      children.add(new Property("knownDataCount", "unsignedInt",
          "Number of participants with known results for measured variables.", 0, 1, knownDataCount));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1724546052:
        /* description */ return new Property("description", "string",
            "Human-readable summary of population sample size.", 0, 1, description);
      case 3387378:
        /* note */ return new Property("note", "Annotation", "Footnote or explanatory note about the sample size.", 0,
            java.lang.Integer.MAX_VALUE, note);
      case -177467129:
        /* numberOfStudies */ return new Property("numberOfStudies", "unsignedInt",
            "Number of participants in the population.", 0, 1, numberOfStudies);
      case 1799357120:
        /* numberOfParticipants */ return new Property("numberOfParticipants", "unsignedInt",
            "A human-readable string to clarify or explain concepts about the sample size.", 0, 1,
            numberOfParticipants);
      case -937344126:
        /* knownDataCount */ return new Property("knownDataCount", "unsignedInt",
            "Number of participants with known results for measured variables.", 0, 1, knownDataCount);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1724546052:
        /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // StringType
      case 3387378:
        /* note */ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
      case -177467129:
        /* numberOfStudies */ return this.numberOfStudies == null ? new Base[0] : new Base[] { this.numberOfStudies }; // UnsignedIntType
      case 1799357120:
        /* numberOfParticipants */ return this.numberOfParticipants == null ? new Base[0]
            : new Base[] { this.numberOfParticipants }; // UnsignedIntType
      case -937344126:
        /* knownDataCount */ return this.knownDataCount == null ? new Base[0] : new Base[] { this.knownDataCount }; // UnsignedIntType
      default:
        return super.getProperty(hash, name, checkValid);
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
        this.numberOfStudies = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        return value;
      case 1799357120: // numberOfParticipants
        this.numberOfParticipants = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        return value;
      case -937344126: // knownDataCount
        this.knownDataCount = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("description")) {
        this.description = TypeConvertor.castToString(value); // StringType
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
      case -1724546052:
        return getDescriptionElement();
      case 3387378:
        return addNote();
      case -177467129:
        return getNumberOfStudiesElement();
      case 1799357120:
        return getNumberOfParticipantsElement();
      case -937344126:
        return getKnownDataCountElement();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1724546052:
        /* description */ return new String[] { "string" };
      case 3387378:
        /* note */ return new String[] { "Annotation" };
      case -177467129:
        /* numberOfStudies */ return new String[] { "unsignedInt" };
      case 1799357120:
        /* numberOfParticipants */ return new String[] { "unsignedInt" };
      case -937344126:
        /* knownDataCount */ return new String[] { "unsignedInt" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("description")) {
        throw new FHIRException("Cannot call addChild on a singleton property Statistic.sampleSize.description");
      } else if (name.equals("note")) {
        return addNote();
      } else if (name.equals("numberOfStudies")) {
        throw new FHIRException("Cannot call addChild on a singleton property Statistic.sampleSize.numberOfStudies");
      } else if (name.equals("numberOfParticipants")) {
        throw new FHIRException("Cannot call addChild on a singleton property Statistic.sampleSize.numberOfParticipants");
      } else if (name.equals("knownDataCount")) {
        throw new FHIRException("Cannot call addChild on a singleton property Statistic.sampleSize.knownDataCount");
      } else
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
      }
      ;
      dst.numberOfStudies = numberOfStudies == null ? null : numberOfStudies.copy();
      dst.numberOfParticipants = numberOfParticipants == null ? null : numberOfParticipants.copy();
      dst.knownDataCount = knownDataCount == null ? null : knownDataCount.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof StatisticSampleSizeComponent))
        return false;
      StatisticSampleSizeComponent o = (StatisticSampleSizeComponent) other_;
      return compareDeep(description, o.description, true) && compareDeep(note, o.note, true)
          && compareDeep(numberOfStudies, o.numberOfStudies, true)
          && compareDeep(numberOfParticipants, o.numberOfParticipants, true)
          && compareDeep(knownDataCount, o.knownDataCount, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof StatisticSampleSizeComponent))
        return false;
      StatisticSampleSizeComponent o = (StatisticSampleSizeComponent) other_;
      return compareValues(description, o.description, true) && compareValues(numberOfStudies, o.numberOfStudies, true)
          && compareValues(numberOfParticipants, o.numberOfParticipants, true)
          && compareValues(knownDataCount, o.knownDataCount, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, numberOfStudies,
          numberOfParticipants, knownDataCount);
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
    @Child(name = "description", type = {
        StringType.class }, order = 1, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Textual description of the attribute estimate", formalDefinition = "Human-readable summary of the estimate.")
    protected StringType description;

    /**
     * Footnote or explanatory note about the estimate.
     */
    @Child(name = "note", type = {
        Annotation.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
    @Description(shortDefinition = "Footnote or explanatory note about the estimate", formalDefinition = "Footnote or explanatory note about the estimate.")
    protected List<Annotation> note;

    /**
     * The type of attribute estimate, eg confidence interval or p value.
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 3, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "The type of attribute estimate, eg confidence interval or p value", formalDefinition = "The type of attribute estimate, eg confidence interval or p value.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/attribute-estimate-type")
    protected CodeableConcept type;

    /**
     * The singular quantity of the attribute estimate, for attribute estimates
     * represented as single values; also used to report unit of measure.
     */
    @Child(name = "quantity", type = { Quantity.class }, order = 4, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure", formalDefinition = "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.")
    protected Quantity quantity;

    /**
     * Use 95 for a 95% confidence interval.
     */
    @Child(name = "level", type = { DecimalType.class }, order = 5, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Level of confidence interval, eg 0.95 for 95% confidence interval", formalDefinition = "Use 95 for a 95% confidence interval.")
    protected DecimalType level;

    /**
     * Lower bound of confidence interval.
     */
    @Child(name = "range", type = { Range.class }, order = 6, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Lower and upper bound values of the attribute estimate", formalDefinition = "Lower bound of confidence interval.")
    protected Range range;

    /**
     * A nested attribute estimate; which is the attribute estimate of an attribute
     * estimate.
     */
    @Child(name = "attributeEstimate", type = {}, order = 7, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
    @Description(shortDefinition = "A nested attribute estimate; which is the attribute estimate of an attribute estimate", formalDefinition = "A nested attribute estimate; which is the attribute estimate of an attribute estimate.")
    protected List<StatisticAttributeEstimateAttributeEstimateComponent> attributeEstimate;

    private static final long serialVersionUID = 2062805621L;

    /**
     * Constructor
     */
    public StatisticAttributeEstimateComponent() {
      super();
    }

    /**
     * @return {@link #description} (Human-readable summary of the estimate.). This
     *         is the underlying object with id, value and extensions. The accessor
     *         "getDescription" gives direct access to the value
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
     * @param value {@link #description} (Human-readable summary of the estimate.).
     *              This is the underlying object with id, value and extensions. The
     *              accessor "getDescription" gives direct access to the value
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

    public Annotation addNote() { // 3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public StatisticAttributeEstimateComponent addNote(Annotation t) { // 3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if
     *         it does not already exist {3}
     */
    public Annotation getNoteFirstRep() {
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

    /**
     * @return {@link #type} (The type of attribute estimate, eg confidence interval
     *         or p value.)
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
     * @param value {@link #type} (The type of attribute estimate, eg confidence
     *              interval or p value.)
     */
    public StatisticAttributeEstimateComponent setType(CodeableConcept value) {
      this.type = value;
      return this;
    }

    /**
     * @return {@link #quantity} (The singular quantity of the attribute estimate,
     *         for attribute estimates represented as single values; also used to
     *         report unit of measure.)
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
     * @param value {@link #quantity} (The singular quantity of the attribute
     *              estimate, for attribute estimates represented as single values;
     *              also used to report unit of measure.)
     */
    public StatisticAttributeEstimateComponent setQuantity(Quantity value) {
      this.quantity = value;
      return this;
    }

    /**
     * @return {@link #level} (Use 95 for a 95% confidence interval.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getLevel" gives direct access to the value
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
     * @param value {@link #level} (Use 95 for a 95% confidence interval.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getLevel" gives direct access to the value
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
     * @return {@link #attributeEstimate} (A nested attribute estimate; which is the
     *         attribute estimate of an attribute estimate.)
     */
    public List<StatisticAttributeEstimateAttributeEstimateComponent> getAttributeEstimate() {
      if (this.attributeEstimate == null)
        this.attributeEstimate = new ArrayList<StatisticAttributeEstimateAttributeEstimateComponent>();
      return this.attributeEstimate;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StatisticAttributeEstimateComponent setAttributeEstimate(
        List<StatisticAttributeEstimateAttributeEstimateComponent> theAttributeEstimate) {
      this.attributeEstimate = theAttributeEstimate;
      return this;
    }

    public boolean hasAttributeEstimate() {
      if (this.attributeEstimate == null)
        return false;
      for (StatisticAttributeEstimateAttributeEstimateComponent item : this.attributeEstimate)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public StatisticAttributeEstimateAttributeEstimateComponent addAttributeEstimate() { // 3
      StatisticAttributeEstimateAttributeEstimateComponent t = new StatisticAttributeEstimateAttributeEstimateComponent();
      if (this.attributeEstimate == null)
        this.attributeEstimate = new ArrayList<StatisticAttributeEstimateAttributeEstimateComponent>();
      this.attributeEstimate.add(t);
      return t;
    }

    public StatisticAttributeEstimateComponent addAttributeEstimate(
        StatisticAttributeEstimateAttributeEstimateComponent t) { // 3
      if (t == null)
        return this;
      if (this.attributeEstimate == null)
        this.attributeEstimate = new ArrayList<StatisticAttributeEstimateAttributeEstimateComponent>();
      this.attributeEstimate.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #attributeEstimate},
     *         creating it if it does not already exist {3}
     */
    public StatisticAttributeEstimateAttributeEstimateComponent getAttributeEstimateFirstRep() {
      if (getAttributeEstimate().isEmpty()) {
        addAttributeEstimate();
      }
      return getAttributeEstimate().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("description", "string", "Human-readable summary of the estimate.", 0, 1, description));
      children.add(new Property("note", "Annotation", "Footnote or explanatory note about the estimate.", 0,
          java.lang.Integer.MAX_VALUE, note));
      children.add(new Property("type", "CodeableConcept",
          "The type of attribute estimate, eg confidence interval or p value.", 0, 1, type));
      children.add(new Property("quantity", "Quantity",
          "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.",
          0, 1, quantity));
      children.add(new Property("level", "decimal", "Use 95 for a 95% confidence interval.", 0, 1, level));
      children.add(new Property("range", "Range", "Lower bound of confidence interval.", 0, 1, range));
      children.add(new Property("attributeEstimate", "",
          "A nested attribute estimate; which is the attribute estimate of an attribute estimate.", 0,
          java.lang.Integer.MAX_VALUE, attributeEstimate));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1724546052:
        /* description */ return new Property("description", "string", "Human-readable summary of the estimate.", 0, 1,
            description);
      case 3387378:
        /* note */ return new Property("note", "Annotation", "Footnote or explanatory note about the estimate.", 0,
            java.lang.Integer.MAX_VALUE, note);
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept",
            "The type of attribute estimate, eg confidence interval or p value.", 0, 1, type);
      case -1285004149:
        /* quantity */ return new Property("quantity", "Quantity",
            "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.",
            0, 1, quantity);
      case 102865796:
        /* level */ return new Property("level", "decimal", "Use 95 for a 95% confidence interval.", 0, 1, level);
      case 108280125:
        /* range */ return new Property("range", "Range", "Lower bound of confidence interval.", 0, 1, range);
      case -1539581980:
        /* attributeEstimate */ return new Property("attributeEstimate", "",
            "A nested attribute estimate; which is the attribute estimate of an attribute estimate.", 0,
            java.lang.Integer.MAX_VALUE, attributeEstimate);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1724546052:
        /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // StringType
      case 3387378:
        /* note */ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
      case -1285004149:
        /* quantity */ return this.quantity == null ? new Base[0] : new Base[] { this.quantity }; // Quantity
      case 102865796:
        /* level */ return this.level == null ? new Base[0] : new Base[] { this.level }; // DecimalType
      case 108280125:
        /* range */ return this.range == null ? new Base[0] : new Base[] { this.range }; // Range
      case -1539581980:
        /* attributeEstimate */ return this.attributeEstimate == null ? new Base[0]
            : this.attributeEstimate.toArray(new Base[this.attributeEstimate.size()]); // StatisticAttributeEstimateAttributeEstimateComponent
      default:
        return super.getProperty(hash, name, checkValid);
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
      case -1539581980: // attributeEstimate
        this.getAttributeEstimate().add((StatisticAttributeEstimateAttributeEstimateComponent) value); // StatisticAttributeEstimateAttributeEstimateComponent
        return value;
      default:
        return super.setProperty(hash, name, value);
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
      } else if (name.equals("attributeEstimate")) {
        this.getAttributeEstimate().add((StatisticAttributeEstimateAttributeEstimateComponent) value);
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
        this.getAttributeEstimate().remove((StatisticAttributeEstimateAttributeEstimateComponent) value);
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1724546052:
        return getDescriptionElement();
      case 3387378:
        return addNote();
      case 3575610:
        return getType();
      case -1285004149:
        return getQuantity();
      case 102865796:
        return getLevelElement();
      case 108280125:
        return getRange();
      case -1539581980:
        return addAttributeEstimate();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1724546052:
        /* description */ return new String[] { "string" };
      case 3387378:
        /* note */ return new String[] { "Annotation" };
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case -1285004149:
        /* quantity */ return new String[] { "Quantity" };
      case 102865796:
        /* level */ return new String[] { "decimal" };
      case 108280125:
        /* range */ return new String[] { "Range" };
      case -1539581980:
        /* attributeEstimate */ return new String[] {};
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("description")) {
        throw new FHIRException("Cannot call addChild on a singleton property Statistic.attributeEstimate.description");
      } else if (name.equals("note")) {
        return addNote();
      } else if (name.equals("type")) {
        this.type = new CodeableConcept();
        return this.type;
      } else if (name.equals("quantity")) {
        this.quantity = new Quantity();
        return this.quantity;
      } else if (name.equals("level")) {
        throw new FHIRException("Cannot call addChild on a singleton property Statistic.attributeEstimate.level");
      } else if (name.equals("range")) {
        this.range = new Range();
        return this.range;
      } else if (name.equals("attributeEstimate")) {
        return addAttributeEstimate();
      } else
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
      }
      ;
      dst.type = type == null ? null : type.copy();
      dst.quantity = quantity == null ? null : quantity.copy();
      dst.level = level == null ? null : level.copy();
      dst.range = range == null ? null : range.copy();
      if (attributeEstimate != null) {
        dst.attributeEstimate = new ArrayList<StatisticAttributeEstimateAttributeEstimateComponent>();
        for (StatisticAttributeEstimateAttributeEstimateComponent i : attributeEstimate)
          dst.attributeEstimate.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof StatisticAttributeEstimateComponent))
        return false;
      StatisticAttributeEstimateComponent o = (StatisticAttributeEstimateComponent) other_;
      return compareDeep(description, o.description, true) && compareDeep(note, o.note, true)
          && compareDeep(type, o.type, true) && compareDeep(quantity, o.quantity, true)
          && compareDeep(level, o.level, true) && compareDeep(range, o.range, true)
          && compareDeep(attributeEstimate, o.attributeEstimate, true);
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
      return super.isEmpty()
          && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, type, quantity, level, range, attributeEstimate);
    }

    public String fhirType() {
      return "Statistic.attributeEstimate";

    }

  }

  @Block()
  public static class StatisticAttributeEstimateAttributeEstimateComponent extends Element
      implements IBaseDatatypeElement {
    /**
     * Human-readable summary of the estimate.
     */
    @Child(name = "description", type = {
        StringType.class }, order = 1, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Textual description of the attribute estimate", formalDefinition = "Human-readable summary of the estimate.")
    protected StringType description;

    /**
     * Footnote or explanatory note about the estimate.
     */
    @Child(name = "note", type = {
        Annotation.class }, order = 2, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
    @Description(shortDefinition = "Footnote or explanatory note about the estimate", formalDefinition = "Footnote or explanatory note about the estimate.")
    protected List<Annotation> note;

    /**
     * The type of attribute estimate, eg confidence interval or p value.
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 3, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "The type of attribute estimate, eg confidence interval or p value", formalDefinition = "The type of attribute estimate, eg confidence interval or p value.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/attribute-estimate-type")
    protected CodeableConcept type;

    /**
     * The singular quantity of the attribute estimate, for attribute estimates
     * represented as single values; also used to report unit of measure.
     */
    @Child(name = "quantity", type = { Quantity.class }, order = 4, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure", formalDefinition = "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.")
    protected Quantity quantity;

    /**
     * Use 95 for a 95% confidence interval.
     */
    @Child(name = "level", type = { DecimalType.class }, order = 5, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Level of confidence interval, eg 0.95 for 95% confidence interval", formalDefinition = "Use 95 for a 95% confidence interval.")
    protected DecimalType level;

    /**
     * Lower bound of confidence interval.
     */
    @Child(name = "range", type = { Range.class }, order = 6, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Lower and upper bound values of the attribute estimate", formalDefinition = "Lower bound of confidence interval.")
    protected Range range;

    private static final long serialVersionUID = 1873606362L;

    /**
     * Constructor
     */
    public StatisticAttributeEstimateAttributeEstimateComponent() {
      super();
    }

    /**
     * @return {@link #description} (Human-readable summary of the estimate.). This
     *         is the underlying object with id, value and extensions. The accessor
     *         "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() {
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StatisticAttributeEstimateAttributeEstimateComponent.description");
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
     * @param value {@link #description} (Human-readable summary of the estimate.).
     *              This is the underlying object with id, value and extensions. The
     *              accessor "getDescription" gives direct access to the value
     */
    public StatisticAttributeEstimateAttributeEstimateComponent setDescriptionElement(StringType value) {
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
    public StatisticAttributeEstimateAttributeEstimateComponent setDescription(String value) {
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
    public StatisticAttributeEstimateAttributeEstimateComponent setNote(List<Annotation> theNote) {
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

    public Annotation addNote() { // 3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public StatisticAttributeEstimateAttributeEstimateComponent addNote(Annotation t) { // 3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if
     *         it does not already exist {3}
     */
    public Annotation getNoteFirstRep() {
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

    /**
     * @return {@link #type} (The type of attribute estimate, eg confidence interval
     *         or p value.)
     */
    public CodeableConcept getType() {
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StatisticAttributeEstimateAttributeEstimateComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() {
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The type of attribute estimate, eg confidence
     *              interval or p value.)
     */
    public StatisticAttributeEstimateAttributeEstimateComponent setType(CodeableConcept value) {
      this.type = value;
      return this;
    }

    /**
     * @return {@link #quantity} (The singular quantity of the attribute estimate,
     *         for attribute estimates represented as single values; also used to
     *         report unit of measure.)
     */
    public Quantity getQuantity() {
      if (this.quantity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StatisticAttributeEstimateAttributeEstimateComponent.quantity");
        else if (Configuration.doAutoCreate())
          this.quantity = new Quantity(); // cc
      return this.quantity;
    }

    public boolean hasQuantity() {
      return this.quantity != null && !this.quantity.isEmpty();
    }

    /**
     * @param value {@link #quantity} (The singular quantity of the attribute
     *              estimate, for attribute estimates represented as single values;
     *              also used to report unit of measure.)
     */
    public StatisticAttributeEstimateAttributeEstimateComponent setQuantity(Quantity value) {
      this.quantity = value;
      return this;
    }

    /**
     * @return {@link #level} (Use 95 for a 95% confidence interval.). This is the
     *         underlying object with id, value and extensions. The accessor
     *         "getLevel" gives direct access to the value
     */
    public DecimalType getLevelElement() {
      if (this.level == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StatisticAttributeEstimateAttributeEstimateComponent.level");
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
     * @param value {@link #level} (Use 95 for a 95% confidence interval.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getLevel" gives direct access to the value
     */
    public StatisticAttributeEstimateAttributeEstimateComponent setLevelElement(DecimalType value) {
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
    public StatisticAttributeEstimateAttributeEstimateComponent setLevel(BigDecimal value) {
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
    public StatisticAttributeEstimateAttributeEstimateComponent setLevel(long value) {
      this.level = new DecimalType();
      this.level.setValue(value);
      return this;
    }

    /**
     * @param value Use 95 for a 95% confidence interval.
     */
    public StatisticAttributeEstimateAttributeEstimateComponent setLevel(double value) {
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
          throw new Error("Attempt to auto-create StatisticAttributeEstimateAttributeEstimateComponent.range");
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
    public StatisticAttributeEstimateAttributeEstimateComponent setRange(Range value) {
      this.range = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("description", "string", "Human-readable summary of the estimate.", 0, 1, description));
      children.add(new Property("note", "Annotation", "Footnote or explanatory note about the estimate.", 0,
          java.lang.Integer.MAX_VALUE, note));
      children.add(new Property("type", "CodeableConcept",
          "The type of attribute estimate, eg confidence interval or p value.", 0, 1, type));
      children.add(new Property("quantity", "Quantity",
          "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.",
          0, 1, quantity));
      children.add(new Property("level", "decimal", "Use 95 for a 95% confidence interval.", 0, 1, level));
      children.add(new Property("range", "Range", "Lower bound of confidence interval.", 0, 1, range));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1724546052:
        /* description */ return new Property("description", "string", "Human-readable summary of the estimate.", 0, 1,
            description);
      case 3387378:
        /* note */ return new Property("note", "Annotation", "Footnote or explanatory note about the estimate.", 0,
            java.lang.Integer.MAX_VALUE, note);
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept",
            "The type of attribute estimate, eg confidence interval or p value.", 0, 1, type);
      case -1285004149:
        /* quantity */ return new Property("quantity", "Quantity",
            "The singular quantity of the attribute estimate, for attribute estimates represented as single values; also used to report unit of measure.",
            0, 1, quantity);
      case 102865796:
        /* level */ return new Property("level", "decimal", "Use 95 for a 95% confidence interval.", 0, 1, level);
      case 108280125:
        /* range */ return new Property("range", "Range", "Lower bound of confidence interval.", 0, 1, range);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1724546052:
        /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // StringType
      case 3387378:
        /* note */ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
      case -1285004149:
        /* quantity */ return this.quantity == null ? new Base[0] : new Base[] { this.quantity }; // Quantity
      case 102865796:
        /* level */ return this.level == null ? new Base[0] : new Base[] { this.level }; // DecimalType
      case 108280125:
        /* range */ return this.range == null ? new Base[0] : new Base[] { this.range }; // Range
      default:
        return super.getProperty(hash, name, checkValid);
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
      default:
        return super.setProperty(hash, name, value);
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
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1724546052:
        return getDescriptionElement();
      case 3387378:
        return addNote();
      case 3575610:
        return getType();
      case -1285004149:
        return getQuantity();
      case 102865796:
        return getLevelElement();
      case 108280125:
        return getRange();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1724546052:
        /* description */ return new String[] { "string" };
      case 3387378:
        /* note */ return new String[] { "Annotation" };
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case -1285004149:
        /* quantity */ return new String[] { "Quantity" };
      case 102865796:
        /* level */ return new String[] { "decimal" };
      case 108280125:
        /* range */ return new String[] { "Range" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("description")) {
        throw new FHIRException(
            "Cannot call addChild on a singleton property Statistic.attributeEstimate.attributeEstimate.description");
      } else if (name.equals("note")) {
        return addNote();
      } else if (name.equals("type")) {
        this.type = new CodeableConcept();
        return this.type;
      } else if (name.equals("quantity")) {
        this.quantity = new Quantity();
        return this.quantity;
      } else if (name.equals("level")) {
        throw new FHIRException(
            "Cannot call addChild on a singleton property Statistic.attributeEstimate.attributeEstimate.level");
      } else if (name.equals("range")) {
        this.range = new Range();
        return this.range;
      } else
        return super.addChild(name);
    }

    public StatisticAttributeEstimateAttributeEstimateComponent copy() {
      StatisticAttributeEstimateAttributeEstimateComponent dst = new StatisticAttributeEstimateAttributeEstimateComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(StatisticAttributeEstimateAttributeEstimateComponent dst) {
      super.copyValues(dst);
      dst.description = description == null ? null : description.copy();
      if (note != null) {
        dst.note = new ArrayList<Annotation>();
        for (Annotation i : note)
          dst.note.add(i.copy());
      }
      ;
      dst.type = type == null ? null : type.copy();
      dst.quantity = quantity == null ? null : quantity.copy();
      dst.level = level == null ? null : level.copy();
      dst.range = range == null ? null : range.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof StatisticAttributeEstimateAttributeEstimateComponent))
        return false;
      StatisticAttributeEstimateAttributeEstimateComponent o = (StatisticAttributeEstimateAttributeEstimateComponent) other_;
      return compareDeep(description, o.description, true) && compareDeep(note, o.note, true)
          && compareDeep(type, o.type, true) && compareDeep(quantity, o.quantity, true)
          && compareDeep(level, o.level, true) && compareDeep(range, o.range, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof StatisticAttributeEstimateAttributeEstimateComponent))
        return false;
      StatisticAttributeEstimateAttributeEstimateComponent o = (StatisticAttributeEstimateAttributeEstimateComponent) other_;
      return compareValues(description, o.description, true) && compareValues(level, o.level, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, type, quantity, level, range);
    }

    public String fhirType() {
      return "Statistic.attributeEstimate.attributeEstimate";

    }

  }

  @Block()
  public static class StatisticModelCharacteristicComponent extends Element implements IBaseDatatypeElement {
    /**
     * Description of a component of the method to generate the statistic.
     */
    @Child(name = "code", type = {
        CodeableConcept.class }, order = 1, min = 1, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Model specification", formalDefinition = "Description of a component of the method to generate the statistic.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/statistic-model-code")
    protected CodeableConcept code;

    /**
     * Further specification of the quantified value of the component of the method
     * to generate the statistic.
     */
    @Child(name = "value", type = { Quantity.class }, order = 2, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Numerical value to complete model specification", formalDefinition = "Further specification of the quantified value of the component of the method to generate the statistic.")
    protected Quantity value;

    /**
     * A variable adjusted for in the adjusted analysis.
     */
    @Child(name = "variable", type = {}, order = 3, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
    @Description(shortDefinition = "A variable adjusted for in the adjusted analysis", formalDefinition = "A variable adjusted for in the adjusted analysis.")
    protected List<StatisticModelCharacteristicVariableComponent> variable;

    private static final long serialVersionUID = 1539071113L;

    /**
     * Constructor
     */
    public StatisticModelCharacteristicComponent() {
      super();
    }

    /**
     * Constructor
     */
    public StatisticModelCharacteristicComponent(CodeableConcept code) {
      super();
      this.setCode(code);
    }

    /**
     * @return {@link #code} (Description of a component of the method to generate
     *         the statistic.)
     */
    public CodeableConcept getCode() {
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StatisticModelCharacteristicComponent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() {
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Description of a component of the method to
     *              generate the statistic.)
     */
    public StatisticModelCharacteristicComponent setCode(CodeableConcept value) {
      this.code = value;
      return this;
    }

    /**
     * @return {@link #value} (Further specification of the quantified value of the
     *         component of the method to generate the statistic.)
     */
    public Quantity getValue() {
      if (this.value == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StatisticModelCharacteristicComponent.value");
        else if (Configuration.doAutoCreate())
          this.value = new Quantity(); // cc
      return this.value;
    }

    public boolean hasValue() {
      return this.value != null && !this.value.isEmpty();
    }

    /**
     * @param value {@link #value} (Further specification of the quantified value of
     *              the component of the method to generate the statistic.)
     */
    public StatisticModelCharacteristicComponent setValue(Quantity value) {
      this.value = value;
      return this;
    }

    /**
     * @return {@link #variable} (A variable adjusted for in the adjusted analysis.)
     */
    public List<StatisticModelCharacteristicVariableComponent> getVariable() {
      if (this.variable == null)
        this.variable = new ArrayList<StatisticModelCharacteristicVariableComponent>();
      return this.variable;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StatisticModelCharacteristicComponent setVariable(
        List<StatisticModelCharacteristicVariableComponent> theVariable) {
      this.variable = theVariable;
      return this;
    }

    public boolean hasVariable() {
      if (this.variable == null)
        return false;
      for (StatisticModelCharacteristicVariableComponent item : this.variable)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public StatisticModelCharacteristicVariableComponent addVariable() { // 3
      StatisticModelCharacteristicVariableComponent t = new StatisticModelCharacteristicVariableComponent();
      if (this.variable == null)
        this.variable = new ArrayList<StatisticModelCharacteristicVariableComponent>();
      this.variable.add(t);
      return t;
    }

    public StatisticModelCharacteristicComponent addVariable(StatisticModelCharacteristicVariableComponent t) { // 3
      if (t == null)
        return this;
      if (this.variable == null)
        this.variable = new ArrayList<StatisticModelCharacteristicVariableComponent>();
      this.variable.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #variable}, creating
     *         it if it does not already exist {3}
     */
    public StatisticModelCharacteristicVariableComponent getVariableFirstRep() {
      if (getVariable().isEmpty()) {
        addVariable();
      }
      return getVariable().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("code", "CodeableConcept",
          "Description of a component of the method to generate the statistic.", 0, 1, code));
      children.add(new Property("value", "Quantity",
          "Further specification of the quantified value of the component of the method to generate the statistic.", 0,
          1, value));
      children.add(new Property("variable", "", "A variable adjusted for in the adjusted analysis.", 0,
          java.lang.Integer.MAX_VALUE, variable));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 3059181:
        /* code */ return new Property("code", "CodeableConcept",
            "Description of a component of the method to generate the statistic.", 0, 1, code);
      case 111972721:
        /* value */ return new Property("value", "Quantity",
            "Further specification of the quantified value of the component of the method to generate the statistic.",
            0, 1, value);
      case -1249586564:
        /* variable */ return new Property("variable", "", "A variable adjusted for in the adjusted analysis.", 0,
            java.lang.Integer.MAX_VALUE, variable);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return this.code == null ? new Base[0] : new Base[] { this.code }; // CodeableConcept
      case 111972721:
        /* value */ return this.value == null ? new Base[0] : new Base[] { this.value }; // Quantity
      case -1249586564:
        /* variable */ return this.variable == null ? new Base[0]
            : this.variable.toArray(new Base[this.variable.size()]); // StatisticModelCharacteristicVariableComponent
      default:
        return super.getProperty(hash, name, checkValid);
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
        this.getVariable().add((StatisticModelCharacteristicVariableComponent) value); // StatisticModelCharacteristicVariableComponent
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("code")) {
        this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("value")) {
        this.value = TypeConvertor.castToQuantity(value); // Quantity
      } else if (name.equals("variable")) {
        this.getVariable().add((StatisticModelCharacteristicVariableComponent) value);
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
        this.getVariable().remove((StatisticModelCharacteristicVariableComponent) value);
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        return getCode();
      case 111972721:
        return getValue();
      case -1249586564:
        return addVariable();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 3059181:
        /* code */ return new String[] { "CodeableConcept" };
      case 111972721:
        /* value */ return new String[] { "Quantity" };
      case -1249586564:
        /* variable */ return new String[] {};
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("code")) {
        this.code = new CodeableConcept();
        return this.code;
      } else if (name.equals("value")) {
        this.value = new Quantity();
        return this.value;
      } else if (name.equals("variable")) {
        return addVariable();
      } else
        return super.addChild(name);
    }

    public StatisticModelCharacteristicComponent copy() {
      StatisticModelCharacteristicComponent dst = new StatisticModelCharacteristicComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(StatisticModelCharacteristicComponent dst) {
      super.copyValues(dst);
      dst.code = code == null ? null : code.copy();
      dst.value = value == null ? null : value.copy();
      if (variable != null) {
        dst.variable = new ArrayList<StatisticModelCharacteristicVariableComponent>();
        for (StatisticModelCharacteristicVariableComponent i : variable)
          dst.variable.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof StatisticModelCharacteristicComponent))
        return false;
      StatisticModelCharacteristicComponent o = (StatisticModelCharacteristicComponent) other_;
      return compareDeep(code, o.code, true) && compareDeep(value, o.value, true)
          && compareDeep(variable, o.variable, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof StatisticModelCharacteristicComponent))
        return false;
      StatisticModelCharacteristicComponent o = (StatisticModelCharacteristicComponent) other_;
      return true;
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, value, variable);
    }

    public String fhirType() {
      return "Statistic.modelCharacteristic";

    }

  }

  @Block()
  public static class StatisticModelCharacteristicVariableComponent extends Element implements IBaseDatatypeElement {
    /**
     * Description of the variable.
     */
    @Child(name = "variableDefinition", type = { Group.class,
        EvidenceVariable.class }, order = 1, min = 1, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "Description of the variable", formalDefinition = "Description of the variable.")
    protected Reference variableDefinition;

    /**
     * How the variable is classified for use in adjusted analysis.
     */
    @Child(name = "handling", type = { CodeType.class }, order = 2, min = 0, max = 1, modifier = false, summary = true)
    @Description(shortDefinition = "continuous | dichotomous | ordinal | polychotomous", formalDefinition = "How the variable is classified for use in adjusted analysis.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/variable-handling")
    protected Enumeration<EvidenceVariableHandling> handling;

    /**
     * Description for grouping of ordinal or polychotomous variables.
     */
    @Child(name = "valueCategory", type = {
        CodeableConcept.class }, order = 3, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
    @Description(shortDefinition = "Description for grouping of ordinal or polychotomous variables", formalDefinition = "Description for grouping of ordinal or polychotomous variables.")
    protected List<CodeableConcept> valueCategory;

    /**
     * Discrete value for grouping of ordinal or polychotomous variables.
     */
    @Child(name = "valueQuantity", type = {
        Quantity.class }, order = 4, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
    @Description(shortDefinition = "Discrete value for grouping of ordinal or polychotomous variables", formalDefinition = "Discrete value for grouping of ordinal or polychotomous variables.")
    protected List<Quantity> valueQuantity;

    /**
     * Range of values for grouping of ordinal or polychotomous variables.
     */
    @Child(name = "valueRange", type = {
        Range.class }, order = 5, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
    @Description(shortDefinition = "Range of values for grouping of ordinal or polychotomous variables", formalDefinition = "Range of values for grouping of ordinal or polychotomous variables.")
    protected List<Range> valueRange;

    private static final long serialVersionUID = 1516174900L;

    /**
     * Constructor
     */
    public StatisticModelCharacteristicVariableComponent() {
      super();
    }

    /**
     * Constructor
     */
    public StatisticModelCharacteristicVariableComponent(Reference variableDefinition) {
      super();
      this.setVariableDefinition(variableDefinition);
    }

    /**
     * @return {@link #variableDefinition} (Description of the variable.)
     */
    public Reference getVariableDefinition() {
      if (this.variableDefinition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StatisticModelCharacteristicVariableComponent.variableDefinition");
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
    public StatisticModelCharacteristicVariableComponent setVariableDefinition(Reference value) {
      this.variableDefinition = value;
      return this;
    }

    /**
     * @return {@link #handling} (How the variable is classified for use in adjusted
     *         analysis.). This is the underlying object with id, value and
     *         extensions. The accessor "getHandling" gives direct access to the
     *         value
     */
    public Enumeration<EvidenceVariableHandling> getHandlingElement() {
      if (this.handling == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create StatisticModelCharacteristicVariableComponent.handling");
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
     * @param value {@link #handling} (How the variable is classified for use in
     *              adjusted analysis.). This is the underlying object with id,
     *              value and extensions. The accessor "getHandling" gives direct
     *              access to the value
     */
    public StatisticModelCharacteristicVariableComponent setHandlingElement(
        Enumeration<EvidenceVariableHandling> value) {
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
    public StatisticModelCharacteristicVariableComponent setHandling(EvidenceVariableHandling value) {
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
     * @return {@link #valueCategory} (Description for grouping of ordinal or
     *         polychotomous variables.)
     */
    public List<CodeableConcept> getValueCategory() {
      if (this.valueCategory == null)
        this.valueCategory = new ArrayList<CodeableConcept>();
      return this.valueCategory;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StatisticModelCharacteristicVariableComponent setValueCategory(List<CodeableConcept> theValueCategory) {
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

    public CodeableConcept addValueCategory() { // 3
      CodeableConcept t = new CodeableConcept();
      if (this.valueCategory == null)
        this.valueCategory = new ArrayList<CodeableConcept>();
      this.valueCategory.add(t);
      return t;
    }

    public StatisticModelCharacteristicVariableComponent addValueCategory(CodeableConcept t) { // 3
      if (t == null)
        return this;
      if (this.valueCategory == null)
        this.valueCategory = new ArrayList<CodeableConcept>();
      this.valueCategory.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #valueCategory},
     *         creating it if it does not already exist {3}
     */
    public CodeableConcept getValueCategoryFirstRep() {
      if (getValueCategory().isEmpty()) {
        addValueCategory();
      }
      return getValueCategory().get(0);
    }

    /**
     * @return {@link #valueQuantity} (Discrete value for grouping of ordinal or
     *         polychotomous variables.)
     */
    public List<Quantity> getValueQuantity() {
      if (this.valueQuantity == null)
        this.valueQuantity = new ArrayList<Quantity>();
      return this.valueQuantity;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StatisticModelCharacteristicVariableComponent setValueQuantity(List<Quantity> theValueQuantity) {
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

    public Quantity addValueQuantity() { // 3
      Quantity t = new Quantity();
      if (this.valueQuantity == null)
        this.valueQuantity = new ArrayList<Quantity>();
      this.valueQuantity.add(t);
      return t;
    }

    public StatisticModelCharacteristicVariableComponent addValueQuantity(Quantity t) { // 3
      if (t == null)
        return this;
      if (this.valueQuantity == null)
        this.valueQuantity = new ArrayList<Quantity>();
      this.valueQuantity.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #valueQuantity},
     *         creating it if it does not already exist {3}
     */
    public Quantity getValueQuantityFirstRep() {
      if (getValueQuantity().isEmpty()) {
        addValueQuantity();
      }
      return getValueQuantity().get(0);
    }

    /**
     * @return {@link #valueRange} (Range of values for grouping of ordinal or
     *         polychotomous variables.)
     */
    public List<Range> getValueRange() {
      if (this.valueRange == null)
        this.valueRange = new ArrayList<Range>();
      return this.valueRange;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public StatisticModelCharacteristicVariableComponent setValueRange(List<Range> theValueRange) {
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

    public Range addValueRange() { // 3
      Range t = new Range();
      if (this.valueRange == null)
        this.valueRange = new ArrayList<Range>();
      this.valueRange.add(t);
      return t;
    }

    public StatisticModelCharacteristicVariableComponent addValueRange(Range t) { // 3
      if (t == null)
        return this;
      if (this.valueRange == null)
        this.valueRange = new ArrayList<Range>();
      this.valueRange.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #valueRange}, creating
     *         it if it does not already exist {3}
     */
    public Range getValueRangeFirstRep() {
      if (getValueRange().isEmpty()) {
        addValueRange();
      }
      return getValueRange().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("variableDefinition", "Reference(Group|EvidenceVariable)",
          "Description of the variable.", 0, 1, variableDefinition));
      children.add(new Property("handling", "code", "How the variable is classified for use in adjusted analysis.", 0,
          1, handling));
      children.add(new Property("valueCategory", "CodeableConcept",
          "Description for grouping of ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE,
          valueCategory));
      children.add(new Property("valueQuantity", "Quantity",
          "Discrete value for grouping of ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE,
          valueQuantity));
      children.add(
          new Property("valueRange", "Range", "Range of values for grouping of ordinal or polychotomous variables.", 0,
              java.lang.Integer.MAX_VALUE, valueRange));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -1807222545:
        /* variableDefinition */ return new Property("variableDefinition", "Reference(Group|EvidenceVariable)",
            "Description of the variable.", 0, 1, variableDefinition);
      case 2072805:
        /* handling */ return new Property("handling", "code",
            "How the variable is classified for use in adjusted analysis.", 0, 1, handling);
      case -694308465:
        /* valueCategory */ return new Property("valueCategory", "CodeableConcept",
            "Description for grouping of ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE,
            valueCategory);
      case -2029823716:
        /* valueQuantity */ return new Property("valueQuantity", "Quantity",
            "Discrete value for grouping of ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE,
            valueQuantity);
      case 2030761548:
        /* valueRange */ return new Property("valueRange", "Range",
            "Range of values for grouping of ordinal or polychotomous variables.", 0, java.lang.Integer.MAX_VALUE,
            valueRange);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -1807222545:
        /* variableDefinition */ return this.variableDefinition == null ? new Base[0]
            : new Base[] { this.variableDefinition }; // Reference
      case 2072805:
        /* handling */ return this.handling == null ? new Base[0] : new Base[] { this.handling }; // Enumeration<EvidenceVariableHandling>
      case -694308465:
        /* valueCategory */ return this.valueCategory == null ? new Base[0]
            : this.valueCategory.toArray(new Base[this.valueCategory.size()]); // CodeableConcept
      case -2029823716:
        /* valueQuantity */ return this.valueQuantity == null ? new Base[0]
            : this.valueQuantity.toArray(new Base[this.valueQuantity.size()]); // Quantity
      case 2030761548:
        /* valueRange */ return this.valueRange == null ? new Base[0]
            : this.valueRange.toArray(new Base[this.valueRange.size()]); // Range
      default:
        return super.getProperty(hash, name, checkValid);
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
      default:
        return super.setProperty(hash, name, value);
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
        this.handling = null;
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
      case -1807222545:
        return getVariableDefinition();
      case 2072805:
        return getHandlingElement();
      case -694308465:
        return addValueCategory();
      case -2029823716:
        return addValueQuantity();
      case 2030761548:
        return addValueRange();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -1807222545:
        /* variableDefinition */ return new String[] { "Reference" };
      case 2072805:
        /* handling */ return new String[] { "code" };
      case -694308465:
        /* valueCategory */ return new String[] { "CodeableConcept" };
      case -2029823716:
        /* valueQuantity */ return new String[] { "Quantity" };
      case 2030761548:
        /* valueRange */ return new String[] { "Range" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("variableDefinition")) {
        this.variableDefinition = new Reference();
        return this.variableDefinition;
      } else if (name.equals("handling")) {
        throw new FHIRException(
            "Cannot call addChild on a singleton property Statistic.modelCharacteristic.variable.handling");
      } else if (name.equals("valueCategory")) {
        return addValueCategory();
      } else if (name.equals("valueQuantity")) {
        return addValueQuantity();
      } else if (name.equals("valueRange")) {
        return addValueRange();
      } else
        return super.addChild(name);
    }

    public StatisticModelCharacteristicVariableComponent copy() {
      StatisticModelCharacteristicVariableComponent dst = new StatisticModelCharacteristicVariableComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(StatisticModelCharacteristicVariableComponent dst) {
      super.copyValues(dst);
      dst.variableDefinition = variableDefinition == null ? null : variableDefinition.copy();
      dst.handling = handling == null ? null : handling.copy();
      if (valueCategory != null) {
        dst.valueCategory = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : valueCategory)
          dst.valueCategory.add(i.copy());
      }
      ;
      if (valueQuantity != null) {
        dst.valueQuantity = new ArrayList<Quantity>();
        for (Quantity i : valueQuantity)
          dst.valueQuantity.add(i.copy());
      }
      ;
      if (valueRange != null) {
        dst.valueRange = new ArrayList<Range>();
        for (Range i : valueRange)
          dst.valueRange.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof StatisticModelCharacteristicVariableComponent))
        return false;
      StatisticModelCharacteristicVariableComponent o = (StatisticModelCharacteristicVariableComponent) other_;
      return compareDeep(variableDefinition, o.variableDefinition, true) && compareDeep(handling, o.handling, true)
          && compareDeep(valueCategory, o.valueCategory, true) && compareDeep(valueQuantity, o.valueQuantity, true)
          && compareDeep(valueRange, o.valueRange, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof StatisticModelCharacteristicVariableComponent))
        return false;
      StatisticModelCharacteristicVariableComponent o = (StatisticModelCharacteristicVariableComponent) other_;
      return compareValues(handling, o.handling, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(variableDefinition, handling, valueCategory,
          valueQuantity, valueRange);
    }

    public String fhirType() {
      return "Statistic.modelCharacteristic.variable";

    }

  }

  /**
   * A description of the content value of the statistic.
   */
  @Child(name = "description", type = {
      StringType.class }, order = 0, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Description of content", formalDefinition = "A description of the content value of the statistic.")
  protected StringType description;

  /**
   * Footnotes and/or explanatory notes.
   */
  @Child(name = "note", type = {
      Annotation.class }, order = 1, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Footnotes and/or explanatory notes", formalDefinition = "Footnotes and/or explanatory notes.")
  protected List<Annotation> note;

  /**
   * Type of statistic, eg relative risk.
   */
  @Child(name = "statisticType", type = {
      CodeableConcept.class }, order = 2, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Type of statistic, eg relative risk", formalDefinition = "Type of statistic, eg relative risk.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/statistic-type")
  protected CodeableConcept statisticType;

  /**
   * When the measured variable is handled categorically, the category element is
   * used to define which category the statistic is reporting.
   */
  @Child(name = "category", type = {
      CodeableConcept.class }, order = 3, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Associated category for categorical variable\"", formalDefinition = "When the measured variable is handled categorically, the category element is used to define which category the statistic is reporting.")
  protected CodeableConcept category;

  /**
   * Statistic value.
   */
  @Child(name = "quantity", type = { Quantity.class }, order = 4, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Statistic value", formalDefinition = "Statistic value.")
  protected Quantity quantity;

  /**
   * The number of events associated with the statistic, where the unit of
   * analysis is different from numberAffected, sampleSize.knownDataCount and
   * sampleSize.numberOfParticipants.
   */
  @Child(name = "numberOfEvents", type = {
      UnsignedIntType.class }, order = 5, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "The number of events associated with the statistic", formalDefinition = "The number of events associated with the statistic, where the unit of analysis is different from numberAffected, sampleSize.knownDataCount and sampleSize.numberOfParticipants.")
  protected UnsignedIntType numberOfEvents;

  /**
   * The number of participants affected where the unit of analysis is the same as
   * sampleSize.knownDataCount and sampleSize.numberOfParticipants.
   */
  @Child(name = "numberAffected", type = {
      UnsignedIntType.class }, order = 6, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "The number of participants affected", formalDefinition = "The number of participants affected where the unit of analysis is the same as sampleSize.knownDataCount and sampleSize.numberOfParticipants.")
  protected UnsignedIntType numberAffected;

  /**
   * Number of samples in the statistic.
   */
  @Child(name = "sampleSize", type = {}, order = 7, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Number of samples in the statistic", formalDefinition = "Number of samples in the statistic.")
  protected StatisticSampleSizeComponent sampleSize;

  /**
   * A statistical attribute of the statistic such as a measure of heterogeneity.
   */
  @Child(name = "attributeEstimate", type = {}, order = 8, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "An attribute of the Statistic", formalDefinition = "A statistical attribute of the statistic such as a measure of heterogeneity.")
  protected List<StatisticAttributeEstimateComponent> attributeEstimate;

  /**
   * A component of the method to generate the statistic.
   */
  @Child(name = "modelCharacteristic", type = {}, order = 9, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = true)
  @Description(shortDefinition = "Model characteristic", formalDefinition = "A component of the method to generate the statistic.")
  protected List<StatisticModelCharacteristicComponent> modelCharacteristic;

  private static final long serialVersionUID = -1861373489L;

  /**
   * Constructor
   */
  public Statistic() {
    super();
  }

  /**
   * @return {@link #description} (A description of the content value of the
   *         statistic.). This is the underlying object with id, value and
   *         extensions. The accessor "getDescription" gives direct access to the
   *         value
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
   * @param value {@link #description} (A description of the content value of the
   *              statistic.). This is the underlying object with id, value and
   *              extensions. The accessor "getDescription" gives direct access to
   *              the value
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

  public Annotation addNote() { // 3
    Annotation t = new Annotation();
    if (this.note == null)
      this.note = new ArrayList<Annotation>();
    this.note.add(t);
    return t;
  }

  public Statistic addNote(Annotation t) { // 3
    if (t == null)
      return this;
    if (this.note == null)
      this.note = new ArrayList<Annotation>();
    this.note.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #note}, creating it if
   *         it does not already exist {3}
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
   * @return {@link #category} (When the measured variable is handled
   *         categorically, the category element is used to define which category
   *         the statistic is reporting.)
   */
  public CodeableConcept getCategory() {
    if (this.category == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Statistic.category");
      else if (Configuration.doAutoCreate())
        this.category = new CodeableConcept(); // cc
    return this.category;
  }

  public boolean hasCategory() {
    return this.category != null && !this.category.isEmpty();
  }

  /**
   * @param value {@link #category} (When the measured variable is handled
   *              categorically, the category element is used to define which
   *              category the statistic is reporting.)
   */
  public Statistic setCategory(CodeableConcept value) {
    this.category = value;
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
   * @return {@link #numberOfEvents} (The number of events associated with the
   *         statistic, where the unit of analysis is different from
   *         numberAffected, sampleSize.knownDataCount and
   *         sampleSize.numberOfParticipants.). This is the underlying object with
   *         id, value and extensions. The accessor "getNumberOfEvents" gives
   *         direct access to the value
   */
  public UnsignedIntType getNumberOfEventsElement() {
    if (this.numberOfEvents == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Statistic.numberOfEvents");
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
   * @param value {@link #numberOfEvents} (The number of events associated with
   *              the statistic, where the unit of analysis is different from
   *              numberAffected, sampleSize.knownDataCount and
   *              sampleSize.numberOfParticipants.). This is the underlying object
   *              with id, value and extensions. The accessor "getNumberOfEvents"
   *              gives direct access to the value
   */
  public Statistic setNumberOfEventsElement(UnsignedIntType value) {
    this.numberOfEvents = value;
    return this;
  }

  /**
   * @return The number of events associated with the statistic, where the unit of
   *         analysis is different from numberAffected, sampleSize.knownDataCount
   *         and sampleSize.numberOfParticipants.
   */
  public int getNumberOfEvents() {
    return this.numberOfEvents == null || this.numberOfEvents.isEmpty() ? 0 : this.numberOfEvents.getValue();
  }

  /**
   * @param value The number of events associated with the statistic, where the
   *              unit of analysis is different from numberAffected,
   *              sampleSize.knownDataCount and sampleSize.numberOfParticipants.
   */
  public Statistic setNumberOfEvents(int value) {
    if (this.numberOfEvents == null)
      this.numberOfEvents = new UnsignedIntType();
    this.numberOfEvents.setValue(value);
    return this;
  }

  /**
   * @return {@link #numberAffected} (The number of participants affected where
   *         the unit of analysis is the same as sampleSize.knownDataCount and
   *         sampleSize.numberOfParticipants.). This is the underlying object with
   *         id, value and extensions. The accessor "getNumberAffected" gives
   *         direct access to the value
   */
  public UnsignedIntType getNumberAffectedElement() {
    if (this.numberAffected == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create Statistic.numberAffected");
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
   * @param value {@link #numberAffected} (The number of participants affected
   *              where the unit of analysis is the same as
   *              sampleSize.knownDataCount and sampleSize.numberOfParticipants.).
   *              This is the underlying object with id, value and extensions. The
   *              accessor "getNumberAffected" gives direct access to the value
   */
  public Statistic setNumberAffectedElement(UnsignedIntType value) {
    this.numberAffected = value;
    return this;
  }

  /**
   * @return The number of participants affected where the unit of analysis is the
   *         same as sampleSize.knownDataCount and
   *         sampleSize.numberOfParticipants.
   */
  public int getNumberAffected() {
    return this.numberAffected == null || this.numberAffected.isEmpty() ? 0 : this.numberAffected.getValue();
  }

  /**
   * @param value The number of participants affected where the unit of analysis
   *              is the same as sampleSize.knownDataCount and
   *              sampleSize.numberOfParticipants.
   */
  public Statistic setNumberAffected(int value) {
    if (this.numberAffected == null)
      this.numberAffected = new UnsignedIntType();
    this.numberAffected.setValue(value);
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
   * @return {@link #attributeEstimate} (A statistical attribute of the statistic
   *         such as a measure of heterogeneity.)
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

  public StatisticAttributeEstimateComponent addAttributeEstimate() { // 3
    StatisticAttributeEstimateComponent t = new StatisticAttributeEstimateComponent();
    if (this.attributeEstimate == null)
      this.attributeEstimate = new ArrayList<StatisticAttributeEstimateComponent>();
    this.attributeEstimate.add(t);
    return t;
  }

  public Statistic addAttributeEstimate(StatisticAttributeEstimateComponent t) { // 3
    if (t == null)
      return this;
    if (this.attributeEstimate == null)
      this.attributeEstimate = new ArrayList<StatisticAttributeEstimateComponent>();
    this.attributeEstimate.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #attributeEstimate},
   *         creating it if it does not already exist {3}
   */
  public StatisticAttributeEstimateComponent getAttributeEstimateFirstRep() {
    if (getAttributeEstimate().isEmpty()) {
      addAttributeEstimate();
    }
    return getAttributeEstimate().get(0);
  }

  /**
   * @return {@link #modelCharacteristic} (A component of the method to generate
   *         the statistic.)
   */
  public List<StatisticModelCharacteristicComponent> getModelCharacteristic() {
    if (this.modelCharacteristic == null)
      this.modelCharacteristic = new ArrayList<StatisticModelCharacteristicComponent>();
    return this.modelCharacteristic;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public Statistic setModelCharacteristic(List<StatisticModelCharacteristicComponent> theModelCharacteristic) {
    this.modelCharacteristic = theModelCharacteristic;
    return this;
  }

  public boolean hasModelCharacteristic() {
    if (this.modelCharacteristic == null)
      return false;
    for (StatisticModelCharacteristicComponent item : this.modelCharacteristic)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public StatisticModelCharacteristicComponent addModelCharacteristic() { // 3
    StatisticModelCharacteristicComponent t = new StatisticModelCharacteristicComponent();
    if (this.modelCharacteristic == null)
      this.modelCharacteristic = new ArrayList<StatisticModelCharacteristicComponent>();
    this.modelCharacteristic.add(t);
    return t;
  }

  public Statistic addModelCharacteristic(StatisticModelCharacteristicComponent t) { // 3
    if (t == null)
      return this;
    if (this.modelCharacteristic == null)
      this.modelCharacteristic = new ArrayList<StatisticModelCharacteristicComponent>();
    this.modelCharacteristic.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #modelCharacteristic},
   *         creating it if it does not already exist {3}
   */
  public StatisticModelCharacteristicComponent getModelCharacteristicFirstRep() {
    if (getModelCharacteristic().isEmpty()) {
      addModelCharacteristic();
    }
    return getModelCharacteristic().get(0);
  }

  protected void listChildren(List<Property> children) {
    super.listChildren(children);
    children.add(new Property("description", "string", "A description of the content value of the statistic.", 0, 1,
        description));
    children.add(new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0,
        java.lang.Integer.MAX_VALUE, note));
    children.add(
        new Property("statisticType", "CodeableConcept", "Type of statistic, eg relative risk.", 0, 1, statisticType));
    children.add(new Property("category", "CodeableConcept",
        "When the measured variable is handled categorically, the category element is used to define which category the statistic is reporting.",
        0, 1, category));
    children.add(new Property("quantity", "Quantity", "Statistic value.", 0, 1, quantity));
    children.add(new Property("numberOfEvents", "unsignedInt",
        "The number of events associated with the statistic, where the unit of analysis is different from numberAffected, sampleSize.knownDataCount and sampleSize.numberOfParticipants.",
        0, 1, numberOfEvents));
    children.add(new Property("numberAffected", "unsignedInt",
        "The number of participants affected where the unit of analysis is the same as sampleSize.knownDataCount and sampleSize.numberOfParticipants.",
        0, 1, numberAffected));
    children.add(new Property("sampleSize", "", "Number of samples in the statistic.", 0, 1, sampleSize));
    children.add(new Property("attributeEstimate", "",
        "A statistical attribute of the statistic such as a measure of heterogeneity.", 0, java.lang.Integer.MAX_VALUE,
        attributeEstimate));
    children.add(new Property("modelCharacteristic", "", "A component of the method to generate the statistic.", 0,
        java.lang.Integer.MAX_VALUE, modelCharacteristic));
  }

  @Override
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    switch (_hash) {
    case -1724546052:
      /* description */ return new Property("description", "string",
          "A description of the content value of the statistic.", 0, 1, description);
    case 3387378:
      /* note */ return new Property("note", "Annotation", "Footnotes and/or explanatory notes.", 0,
          java.lang.Integer.MAX_VALUE, note);
    case -392342358:
      /* statisticType */ return new Property("statisticType", "CodeableConcept",
          "Type of statistic, eg relative risk.", 0, 1, statisticType);
    case 50511102:
      /* category */ return new Property("category", "CodeableConcept",
          "When the measured variable is handled categorically, the category element is used to define which category the statistic is reporting.",
          0, 1, category);
    case -1285004149:
      /* quantity */ return new Property("quantity", "Quantity", "Statistic value.", 0, 1, quantity);
    case 1534510137:
      /* numberOfEvents */ return new Property("numberOfEvents", "unsignedInt",
          "The number of events associated with the statistic, where the unit of analysis is different from numberAffected, sampleSize.knownDataCount and sampleSize.numberOfParticipants.",
          0, 1, numberOfEvents);
    case -460990243:
      /* numberAffected */ return new Property("numberAffected", "unsignedInt",
          "The number of participants affected where the unit of analysis is the same as sampleSize.knownDataCount and sampleSize.numberOfParticipants.",
          0, 1, numberAffected);
    case 143123659:
      /* sampleSize */ return new Property("sampleSize", "", "Number of samples in the statistic.", 0, 1, sampleSize);
    case -1539581980:
      /* attributeEstimate */ return new Property("attributeEstimate", "",
          "A statistical attribute of the statistic such as a measure of heterogeneity.", 0,
          java.lang.Integer.MAX_VALUE, attributeEstimate);
    case 274795812:
      /* modelCharacteristic */ return new Property("modelCharacteristic", "",
          "A component of the method to generate the statistic.", 0, java.lang.Integer.MAX_VALUE, modelCharacteristic);
    default:
      return super.getNamedProperty(_hash, _name, _checkValid);
    }

  }

  @Override
  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    switch (hash) {
    case -1724546052:
      /* description */ return this.description == null ? new Base[0] : new Base[] { this.description }; // StringType
    case 3387378:
      /* note */ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
    case -392342358:
      /* statisticType */ return this.statisticType == null ? new Base[0] : new Base[] { this.statisticType }; // CodeableConcept
    case 50511102:
      /* category */ return this.category == null ? new Base[0] : new Base[] { this.category }; // CodeableConcept
    case -1285004149:
      /* quantity */ return this.quantity == null ? new Base[0] : new Base[] { this.quantity }; // Quantity
    case 1534510137:
      /* numberOfEvents */ return this.numberOfEvents == null ? new Base[0] : new Base[] { this.numberOfEvents }; // UnsignedIntType
    case -460990243:
      /* numberAffected */ return this.numberAffected == null ? new Base[0] : new Base[] { this.numberAffected }; // UnsignedIntType
    case 143123659:
      /* sampleSize */ return this.sampleSize == null ? new Base[0] : new Base[] { this.sampleSize }; // StatisticSampleSizeComponent
    case -1539581980:
      /* attributeEstimate */ return this.attributeEstimate == null ? new Base[0]
          : this.attributeEstimate.toArray(new Base[this.attributeEstimate.size()]); // StatisticAttributeEstimateComponent
    case 274795812:
      /* modelCharacteristic */ return this.modelCharacteristic == null ? new Base[0]
          : this.modelCharacteristic.toArray(new Base[this.modelCharacteristic.size()]); // StatisticModelCharacteristicComponent
    default:
      return super.getProperty(hash, name, checkValid);
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
      this.sampleSize = (StatisticSampleSizeComponent) value; // StatisticSampleSizeComponent
      return value;
    case -1539581980: // attributeEstimate
      this.getAttributeEstimate().add((StatisticAttributeEstimateComponent) value); // StatisticAttributeEstimateComponent
      return value;
    case 274795812: // modelCharacteristic
      this.getModelCharacteristic().add((StatisticModelCharacteristicComponent) value); // StatisticModelCharacteristicComponent
      return value;
    default:
      return super.setProperty(hash, name, value);
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
    } else if (name.equals("category")) {
      this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
    } else if (name.equals("quantity")) {
      this.quantity = TypeConvertor.castToQuantity(value); // Quantity
    } else if (name.equals("numberOfEvents")) {
      this.numberOfEvents = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
    } else if (name.equals("numberAffected")) {
      this.numberAffected = TypeConvertor.castToUnsignedInt(value); // UnsignedIntType
    } else if (name.equals("sampleSize")) {
      this.sampleSize = (StatisticSampleSizeComponent) value; // StatisticSampleSizeComponent
    } else if (name.equals("attributeEstimate")) {
      this.getAttributeEstimate().add((StatisticAttributeEstimateComponent) value);
    } else if (name.equals("modelCharacteristic")) {
      this.getModelCharacteristic().add((StatisticModelCharacteristicComponent) value);
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
      this.sampleSize = (StatisticSampleSizeComponent) value; // StatisticSampleSizeComponent
    } else if (name.equals("attributeEstimate")) {
      this.getAttributeEstimate().remove((StatisticAttributeEstimateComponent) value);
    } else if (name.equals("modelCharacteristic")) {
      this.getModelCharacteristic().remove((StatisticModelCharacteristicComponent) value);
    } else
      super.removeChild(name, value);
    
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case -1724546052:
      return getDescriptionElement();
    case 3387378:
      return addNote();
    case -392342358:
      return getStatisticType();
    case 50511102:
      return getCategory();
    case -1285004149:
      return getQuantity();
    case 1534510137:
      return getNumberOfEventsElement();
    case -460990243:
      return getNumberAffectedElement();
    case 143123659:
      return getSampleSize();
    case -1539581980:
      return addAttributeEstimate();
    case 274795812:
      return addModelCharacteristic();
    default:
      return super.makeProperty(hash, name);
    }

  }

  @Override
  public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case -1724546052:
      /* description */ return new String[] { "string" };
    case 3387378:
      /* note */ return new String[] { "Annotation" };
    case -392342358:
      /* statisticType */ return new String[] { "CodeableConcept" };
    case 50511102:
      /* category */ return new String[] { "CodeableConcept" };
    case -1285004149:
      /* quantity */ return new String[] { "Quantity" };
    case 1534510137:
      /* numberOfEvents */ return new String[] { "unsignedInt" };
    case -460990243:
      /* numberAffected */ return new String[] { "unsignedInt" };
    case 143123659:
      /* sampleSize */ return new String[] {};
    case -1539581980:
      /* attributeEstimate */ return new String[] {};
    case 274795812:
      /* modelCharacteristic */ return new String[] {};
    default:
      return super.getTypesForProperty(hash, name);
    }

  }

  @Override
  public Base addChild(String name) throws FHIRException {
    if (name.equals("description")) {
      throw new FHIRException("Cannot call addChild on a singleton property Statistic.description");
    } else if (name.equals("note")) {
      return addNote();
    } else if (name.equals("statisticType")) {
      this.statisticType = new CodeableConcept();
      return this.statisticType;
    } else if (name.equals("category")) {
      this.category = new CodeableConcept();
      return this.category;
    } else if (name.equals("quantity")) {
      this.quantity = new Quantity();
      return this.quantity;
    } else if (name.equals("numberOfEvents")) {
      throw new FHIRException("Cannot call addChild on a singleton property Statistic.numberOfEvents");
    } else if (name.equals("numberAffected")) {
      throw new FHIRException("Cannot call addChild on a singleton property Statistic.numberAffected");
    } else if (name.equals("sampleSize")) {
      this.sampleSize = new StatisticSampleSizeComponent();
      return this.sampleSize;
    } else if (name.equals("attributeEstimate")) {
      return addAttributeEstimate();
    } else if (name.equals("modelCharacteristic")) {
      return addModelCharacteristic();
    } else
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
    }
    ;
    dst.statisticType = statisticType == null ? null : statisticType.copy();
    dst.category = category == null ? null : category.copy();
    dst.quantity = quantity == null ? null : quantity.copy();
    dst.numberOfEvents = numberOfEvents == null ? null : numberOfEvents.copy();
    dst.numberAffected = numberAffected == null ? null : numberAffected.copy();
    dst.sampleSize = sampleSize == null ? null : sampleSize.copy();
    if (attributeEstimate != null) {
      dst.attributeEstimate = new ArrayList<StatisticAttributeEstimateComponent>();
      for (StatisticAttributeEstimateComponent i : attributeEstimate)
        dst.attributeEstimate.add(i.copy());
    }
    ;
    if (modelCharacteristic != null) {
      dst.modelCharacteristic = new ArrayList<StatisticModelCharacteristicComponent>();
      for (StatisticModelCharacteristicComponent i : modelCharacteristic)
        dst.modelCharacteristic.add(i.copy());
    }
    ;
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
    return compareDeep(description, o.description, true) && compareDeep(note, o.note, true)
        && compareDeep(statisticType, o.statisticType, true) && compareDeep(category, o.category, true)
        && compareDeep(quantity, o.quantity, true) && compareDeep(numberOfEvents, o.numberOfEvents, true)
        && compareDeep(numberAffected, o.numberAffected, true) && compareDeep(sampleSize, o.sampleSize, true)
        && compareDeep(attributeEstimate, o.attributeEstimate, true)
        && compareDeep(modelCharacteristic, o.modelCharacteristic, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_))
      return false;
    if (!(other_ instanceof Statistic))
      return false;
    Statistic o = (Statistic) other_;
    return compareValues(description, o.description, true) && compareValues(numberOfEvents, o.numberOfEvents, true)
        && compareValues(numberAffected, o.numberAffected, true);
  }

  public boolean isEmpty() {
    return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(description, note, statisticType, category, quantity,
        numberOfEvents, numberAffected, sampleSize, attributeEstimate, modelCharacteristic);
  }

}
