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
import org.hl7.fhir.instance.model.api.IBaseDatatypeElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * SampledData Type: A series of measurements taken by a device, with upper and lower limits. There may be more than one dimension in the data.
 */
@DatatypeDef(name="SampledData")
public class SampledData extends DataType implements ICompositeType {

    /**
     * The base quantity that a measured value of zero represents. In addition, this provides the units of the entire measurement series.
     */
    @Child(name = "origin", type = {Quantity.class}, order=0, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Zero value and units", formalDefinition="The base quantity that a measured value of zero represents. In addition, this provides the units of the entire measurement series." )
    protected Quantity origin;

    /**
     * Amount of intervalUnits between samples, e.g. milliseconds for time-based sampling.
     */
    @Child(name = "interval", type = {DecimalType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Number of intervalUnits between samples", formalDefinition="Amount of intervalUnits between samples, e.g. milliseconds for time-based sampling." )
    protected DecimalType interval;

    /**
     * The measurement unit in which the sample interval is expressed.
     */
    @Child(name = "intervalUnit", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The measurement unit of the interval between samples", formalDefinition="The measurement unit in which the sample interval is expressed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/ucum-units")
    protected CodeType intervalUnit;

    /**
     * A correction factor that is applied to the sampled data points before they are added to the origin.
     */
    @Child(name = "factor", type = {DecimalType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Multiply data by this before adding to origin", formalDefinition="A correction factor that is applied to the sampled data points before they are added to the origin." )
    protected DecimalType factor;

    /**
     * The lower limit of detection of the measured points. This is needed if any of the data points have the value "L" (lower than detection limit).
     */
    @Child(name = "lowerLimit", type = {DecimalType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Lower limit of detection", formalDefinition="The lower limit of detection of the measured points. This is needed if any of the data points have the value \"L\" (lower than detection limit)." )
    protected DecimalType lowerLimit;

    /**
     * The upper limit of detection of the measured points. This is needed if any of the data points have the value "U" (higher than detection limit).
     */
    @Child(name = "upperLimit", type = {DecimalType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Upper limit of detection", formalDefinition="The upper limit of detection of the measured points. This is needed if any of the data points have the value \"U\" (higher than detection limit)." )
    protected DecimalType upperLimit;

    /**
     * The number of sample points at each time point. If this value is greater than one, then the dimensions will be interlaced - all the sample points for a point in time will be recorded at once.
     */
    @Child(name = "dimensions", type = {PositiveIntType.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Number of sample points at each time point", formalDefinition="The number of sample points at each time point. If this value is greater than one, then the dimensions will be interlaced - all the sample points for a point in time will be recorded at once." )
    protected PositiveIntType dimensions;

    /**
     * Reference to ConceptMap that defines the codes used in the data.
     */
    @Child(name = "codeMap", type = {CanonicalType.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Defines the codes used in the data", formalDefinition="Reference to ConceptMap that defines the codes used in the data." )
    protected CanonicalType codeMap;

    /**
     * A series of data points which are decimal values separated by a single space (character u20).  The units in which the offsets are expressed are found in intervalUnit.  The absolute point at which the measurements begin SHALL be conveyed outside the scope of this datatype, e.g. Observation.effectiveDateTime for a timing offset.
     */
    @Child(name = "offsets", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Offsets, typically in time, at which data values were taken", formalDefinition="A series of data points which are decimal values separated by a single space (character u20).  The units in which the offsets are expressed are found in intervalUnit.  The absolute point at which the measurements begin SHALL be conveyed outside the scope of this datatype, e.g. Observation.effectiveDateTime for a timing offset." )
    protected StringType offsets;

    /**
     * A series of data points which are decimal values or codes separated by a single space (character u20). The special codes "E" (error), "L" (below detection limit) and "U" (above detection limit) are also defined for used in place of decimal values.
     */
    @Child(name = "data", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Decimal values with spaces, or \"E\" | \"U\" | \"L\", or another code", formalDefinition="A series of data points which are decimal values or codes separated by a single space (character u20). The special codes \"E\" (error), \"L\" (below detection limit) and \"U\" (above detection limit) are also defined for used in place of decimal values." )
    protected StringType data;

    private static final long serialVersionUID = 1859118926L;

  /**
   * Constructor
   */
    public SampledData() {
      super();
    }

  /**
   * Constructor
   */
    public SampledData(Quantity origin, String intervalUnit, int dimensions) {
      super();
      this.setOrigin(origin);
      this.setIntervalUnit(intervalUnit);
      this.setDimensions(dimensions);
    }

    /**
     * @return {@link #origin} (The base quantity that a measured value of zero represents. In addition, this provides the units of the entire measurement series.)
     */
    public Quantity getOrigin() { 
      if (this.origin == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SampledData.origin");
        else if (Configuration.doAutoCreate())
          this.origin = new Quantity(); // cc
      return this.origin;
    }

    public boolean hasOrigin() { 
      return this.origin != null && !this.origin.isEmpty();
    }

    /**
     * @param value {@link #origin} (The base quantity that a measured value of zero represents. In addition, this provides the units of the entire measurement series.)
     */
    public SampledData setOrigin(Quantity value) { 
      this.origin = value;
      return this;
    }

    /**
     * @return {@link #interval} (Amount of intervalUnits between samples, e.g. milliseconds for time-based sampling.). This is the underlying object with id, value and extensions. The accessor "getInterval" gives direct access to the value
     */
    public DecimalType getIntervalElement() { 
      if (this.interval == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SampledData.interval");
        else if (Configuration.doAutoCreate())
          this.interval = new DecimalType(); // bb
      return this.interval;
    }

    public boolean hasIntervalElement() { 
      return this.interval != null && !this.interval.isEmpty();
    }

    public boolean hasInterval() { 
      return this.interval != null && !this.interval.isEmpty();
    }

    /**
     * @param value {@link #interval} (Amount of intervalUnits between samples, e.g. milliseconds for time-based sampling.). This is the underlying object with id, value and extensions. The accessor "getInterval" gives direct access to the value
     */
    public SampledData setIntervalElement(DecimalType value) { 
      this.interval = value;
      return this;
    }

    /**
     * @return Amount of intervalUnits between samples, e.g. milliseconds for time-based sampling.
     */
    public BigDecimal getInterval() { 
      return this.interval == null ? null : this.interval.getValue();
    }

    /**
     * @param value Amount of intervalUnits between samples, e.g. milliseconds for time-based sampling.
     */
    public SampledData setInterval(BigDecimal value) { 
      if (value == null)
        this.interval = null;
      else {
        if (this.interval == null)
          this.interval = new DecimalType();
        this.interval.setValue(value);
      }
      return this;
    }

    /**
     * @param value Amount of intervalUnits between samples, e.g. milliseconds for time-based sampling.
     */
    public SampledData setInterval(long value) { 
          this.interval = new DecimalType();
        this.interval.setValue(value);
      return this;
    }

    /**
     * @param value Amount of intervalUnits between samples, e.g. milliseconds for time-based sampling.
     */
    public SampledData setInterval(double value) { 
          this.interval = new DecimalType();
        this.interval.setValue(value);
      return this;
    }

    /**
     * @return {@link #intervalUnit} (The measurement unit in which the sample interval is expressed.). This is the underlying object with id, value and extensions. The accessor "getIntervalUnit" gives direct access to the value
     */
    public CodeType getIntervalUnitElement() { 
      if (this.intervalUnit == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SampledData.intervalUnit");
        else if (Configuration.doAutoCreate())
          this.intervalUnit = new CodeType(); // bb
      return this.intervalUnit;
    }

    public boolean hasIntervalUnitElement() { 
      return this.intervalUnit != null && !this.intervalUnit.isEmpty();
    }

    public boolean hasIntervalUnit() { 
      return this.intervalUnit != null && !this.intervalUnit.isEmpty();
    }

    /**
     * @param value {@link #intervalUnit} (The measurement unit in which the sample interval is expressed.). This is the underlying object with id, value and extensions. The accessor "getIntervalUnit" gives direct access to the value
     */
    public SampledData setIntervalUnitElement(CodeType value) { 
      this.intervalUnit = value;
      return this;
    }

    /**
     * @return The measurement unit in which the sample interval is expressed.
     */
    public String getIntervalUnit() { 
      return this.intervalUnit == null ? null : this.intervalUnit.getValue();
    }

    /**
     * @param value The measurement unit in which the sample interval is expressed.
     */
    public SampledData setIntervalUnit(String value) { 
        if (this.intervalUnit == null)
          this.intervalUnit = new CodeType();
        this.intervalUnit.setValue(value);
      return this;
    }

    /**
     * @return {@link #factor} (A correction factor that is applied to the sampled data points before they are added to the origin.). This is the underlying object with id, value and extensions. The accessor "getFactor" gives direct access to the value
     */
    public DecimalType getFactorElement() { 
      if (this.factor == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SampledData.factor");
        else if (Configuration.doAutoCreate())
          this.factor = new DecimalType(); // bb
      return this.factor;
    }

    public boolean hasFactorElement() { 
      return this.factor != null && !this.factor.isEmpty();
    }

    public boolean hasFactor() { 
      return this.factor != null && !this.factor.isEmpty();
    }

    /**
     * @param value {@link #factor} (A correction factor that is applied to the sampled data points before they are added to the origin.). This is the underlying object with id, value and extensions. The accessor "getFactor" gives direct access to the value
     */
    public SampledData setFactorElement(DecimalType value) { 
      this.factor = value;
      return this;
    }

    /**
     * @return A correction factor that is applied to the sampled data points before they are added to the origin.
     */
    public BigDecimal getFactor() { 
      return this.factor == null ? null : this.factor.getValue();
    }

    /**
     * @param value A correction factor that is applied to the sampled data points before they are added to the origin.
     */
    public SampledData setFactor(BigDecimal value) { 
      if (value == null)
        this.factor = null;
      else {
        if (this.factor == null)
          this.factor = new DecimalType();
        this.factor.setValue(value);
      }
      return this;
    }

    /**
     * @param value A correction factor that is applied to the sampled data points before they are added to the origin.
     */
    public SampledData setFactor(long value) { 
          this.factor = new DecimalType();
        this.factor.setValue(value);
      return this;
    }

    /**
     * @param value A correction factor that is applied to the sampled data points before they are added to the origin.
     */
    public SampledData setFactor(double value) { 
          this.factor = new DecimalType();
        this.factor.setValue(value);
      return this;
    }

    /**
     * @return {@link #lowerLimit} (The lower limit of detection of the measured points. This is needed if any of the data points have the value "L" (lower than detection limit).). This is the underlying object with id, value and extensions. The accessor "getLowerLimit" gives direct access to the value
     */
    public DecimalType getLowerLimitElement() { 
      if (this.lowerLimit == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SampledData.lowerLimit");
        else if (Configuration.doAutoCreate())
          this.lowerLimit = new DecimalType(); // bb
      return this.lowerLimit;
    }

    public boolean hasLowerLimitElement() { 
      return this.lowerLimit != null && !this.lowerLimit.isEmpty();
    }

    public boolean hasLowerLimit() { 
      return this.lowerLimit != null && !this.lowerLimit.isEmpty();
    }

    /**
     * @param value {@link #lowerLimit} (The lower limit of detection of the measured points. This is needed if any of the data points have the value "L" (lower than detection limit).). This is the underlying object with id, value and extensions. The accessor "getLowerLimit" gives direct access to the value
     */
    public SampledData setLowerLimitElement(DecimalType value) { 
      this.lowerLimit = value;
      return this;
    }

    /**
     * @return The lower limit of detection of the measured points. This is needed if any of the data points have the value "L" (lower than detection limit).
     */
    public BigDecimal getLowerLimit() { 
      return this.lowerLimit == null ? null : this.lowerLimit.getValue();
    }

    /**
     * @param value The lower limit of detection of the measured points. This is needed if any of the data points have the value "L" (lower than detection limit).
     */
    public SampledData setLowerLimit(BigDecimal value) { 
      if (value == null)
        this.lowerLimit = null;
      else {
        if (this.lowerLimit == null)
          this.lowerLimit = new DecimalType();
        this.lowerLimit.setValue(value);
      }
      return this;
    }

    /**
     * @param value The lower limit of detection of the measured points. This is needed if any of the data points have the value "L" (lower than detection limit).
     */
    public SampledData setLowerLimit(long value) { 
          this.lowerLimit = new DecimalType();
        this.lowerLimit.setValue(value);
      return this;
    }

    /**
     * @param value The lower limit of detection of the measured points. This is needed if any of the data points have the value "L" (lower than detection limit).
     */
    public SampledData setLowerLimit(double value) { 
          this.lowerLimit = new DecimalType();
        this.lowerLimit.setValue(value);
      return this;
    }

    /**
     * @return {@link #upperLimit} (The upper limit of detection of the measured points. This is needed if any of the data points have the value "U" (higher than detection limit).). This is the underlying object with id, value and extensions. The accessor "getUpperLimit" gives direct access to the value
     */
    public DecimalType getUpperLimitElement() { 
      if (this.upperLimit == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SampledData.upperLimit");
        else if (Configuration.doAutoCreate())
          this.upperLimit = new DecimalType(); // bb
      return this.upperLimit;
    }

    public boolean hasUpperLimitElement() { 
      return this.upperLimit != null && !this.upperLimit.isEmpty();
    }

    public boolean hasUpperLimit() { 
      return this.upperLimit != null && !this.upperLimit.isEmpty();
    }

    /**
     * @param value {@link #upperLimit} (The upper limit of detection of the measured points. This is needed if any of the data points have the value "U" (higher than detection limit).). This is the underlying object with id, value and extensions. The accessor "getUpperLimit" gives direct access to the value
     */
    public SampledData setUpperLimitElement(DecimalType value) { 
      this.upperLimit = value;
      return this;
    }

    /**
     * @return The upper limit of detection of the measured points. This is needed if any of the data points have the value "U" (higher than detection limit).
     */
    public BigDecimal getUpperLimit() { 
      return this.upperLimit == null ? null : this.upperLimit.getValue();
    }

    /**
     * @param value The upper limit of detection of the measured points. This is needed if any of the data points have the value "U" (higher than detection limit).
     */
    public SampledData setUpperLimit(BigDecimal value) { 
      if (value == null)
        this.upperLimit = null;
      else {
        if (this.upperLimit == null)
          this.upperLimit = new DecimalType();
        this.upperLimit.setValue(value);
      }
      return this;
    }

    /**
     * @param value The upper limit of detection of the measured points. This is needed if any of the data points have the value "U" (higher than detection limit).
     */
    public SampledData setUpperLimit(long value) { 
          this.upperLimit = new DecimalType();
        this.upperLimit.setValue(value);
      return this;
    }

    /**
     * @param value The upper limit of detection of the measured points. This is needed if any of the data points have the value "U" (higher than detection limit).
     */
    public SampledData setUpperLimit(double value) { 
          this.upperLimit = new DecimalType();
        this.upperLimit.setValue(value);
      return this;
    }

    /**
     * @return {@link #dimensions} (The number of sample points at each time point. If this value is greater than one, then the dimensions will be interlaced - all the sample points for a point in time will be recorded at once.). This is the underlying object with id, value and extensions. The accessor "getDimensions" gives direct access to the value
     */
    public PositiveIntType getDimensionsElement() { 
      if (this.dimensions == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SampledData.dimensions");
        else if (Configuration.doAutoCreate())
          this.dimensions = new PositiveIntType(); // bb
      return this.dimensions;
    }

    public boolean hasDimensionsElement() { 
      return this.dimensions != null && !this.dimensions.isEmpty();
    }

    public boolean hasDimensions() { 
      return this.dimensions != null && !this.dimensions.isEmpty();
    }

    /**
     * @param value {@link #dimensions} (The number of sample points at each time point. If this value is greater than one, then the dimensions will be interlaced - all the sample points for a point in time will be recorded at once.). This is the underlying object with id, value and extensions. The accessor "getDimensions" gives direct access to the value
     */
    public SampledData setDimensionsElement(PositiveIntType value) { 
      this.dimensions = value;
      return this;
    }

    /**
     * @return The number of sample points at each time point. If this value is greater than one, then the dimensions will be interlaced - all the sample points for a point in time will be recorded at once.
     */
    public int getDimensions() { 
      return this.dimensions == null || this.dimensions.isEmpty() ? 0 : this.dimensions.getValue();
    }

    /**
     * @param value The number of sample points at each time point. If this value is greater than one, then the dimensions will be interlaced - all the sample points for a point in time will be recorded at once.
     */
    public SampledData setDimensions(int value) { 
        if (this.dimensions == null)
          this.dimensions = new PositiveIntType();
        this.dimensions.setValue(value);
      return this;
    }

    /**
     * @return {@link #codeMap} (Reference to ConceptMap that defines the codes used in the data.). This is the underlying object with id, value and extensions. The accessor "getCodeMap" gives direct access to the value
     */
    public CanonicalType getCodeMapElement() { 
      if (this.codeMap == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SampledData.codeMap");
        else if (Configuration.doAutoCreate())
          this.codeMap = new CanonicalType(); // bb
      return this.codeMap;
    }

    public boolean hasCodeMapElement() { 
      return this.codeMap != null && !this.codeMap.isEmpty();
    }

    public boolean hasCodeMap() { 
      return this.codeMap != null && !this.codeMap.isEmpty();
    }

    /**
     * @param value {@link #codeMap} (Reference to ConceptMap that defines the codes used in the data.). This is the underlying object with id, value and extensions. The accessor "getCodeMap" gives direct access to the value
     */
    public SampledData setCodeMapElement(CanonicalType value) { 
      this.codeMap = value;
      return this;
    }

    /**
     * @return Reference to ConceptMap that defines the codes used in the data.
     */
    public String getCodeMap() { 
      return this.codeMap == null ? null : this.codeMap.getValue();
    }

    /**
     * @param value Reference to ConceptMap that defines the codes used in the data.
     */
    public SampledData setCodeMap(String value) { 
      if (Utilities.noString(value))
        this.codeMap = null;
      else {
        if (this.codeMap == null)
          this.codeMap = new CanonicalType();
        this.codeMap.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #offsets} (A series of data points which are decimal values separated by a single space (character u20).  The units in which the offsets are expressed are found in intervalUnit.  The absolute point at which the measurements begin SHALL be conveyed outside the scope of this datatype, e.g. Observation.effectiveDateTime for a timing offset.). This is the underlying object with id, value and extensions. The accessor "getOffsets" gives direct access to the value
     */
    public StringType getOffsetsElement() { 
      if (this.offsets == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SampledData.offsets");
        else if (Configuration.doAutoCreate())
          this.offsets = new StringType(); // bb
      return this.offsets;
    }

    public boolean hasOffsetsElement() { 
      return this.offsets != null && !this.offsets.isEmpty();
    }

    public boolean hasOffsets() { 
      return this.offsets != null && !this.offsets.isEmpty();
    }

    /**
     * @param value {@link #offsets} (A series of data points which are decimal values separated by a single space (character u20).  The units in which the offsets are expressed are found in intervalUnit.  The absolute point at which the measurements begin SHALL be conveyed outside the scope of this datatype, e.g. Observation.effectiveDateTime for a timing offset.). This is the underlying object with id, value and extensions. The accessor "getOffsets" gives direct access to the value
     */
    public SampledData setOffsetsElement(StringType value) { 
      this.offsets = value;
      return this;
    }

    /**
     * @return A series of data points which are decimal values separated by a single space (character u20).  The units in which the offsets are expressed are found in intervalUnit.  The absolute point at which the measurements begin SHALL be conveyed outside the scope of this datatype, e.g. Observation.effectiveDateTime for a timing offset.
     */
    public String getOffsets() { 
      return this.offsets == null ? null : this.offsets.getValue();
    }

    /**
     * @param value A series of data points which are decimal values separated by a single space (character u20).  The units in which the offsets are expressed are found in intervalUnit.  The absolute point at which the measurements begin SHALL be conveyed outside the scope of this datatype, e.g. Observation.effectiveDateTime for a timing offset.
     */
    public SampledData setOffsets(String value) { 
      if (Utilities.noString(value))
        this.offsets = null;
      else {
        if (this.offsets == null)
          this.offsets = new StringType();
        this.offsets.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #data} (A series of data points which are decimal values or codes separated by a single space (character u20). The special codes "E" (error), "L" (below detection limit) and "U" (above detection limit) are also defined for used in place of decimal values.). This is the underlying object with id, value and extensions. The accessor "getData" gives direct access to the value
     */
    public StringType getDataElement() { 
      if (this.data == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SampledData.data");
        else if (Configuration.doAutoCreate())
          this.data = new StringType(); // bb
      return this.data;
    }

    public boolean hasDataElement() { 
      return this.data != null && !this.data.isEmpty();
    }

    public boolean hasData() { 
      return this.data != null && !this.data.isEmpty();
    }

    /**
     * @param value {@link #data} (A series of data points which are decimal values or codes separated by a single space (character u20). The special codes "E" (error), "L" (below detection limit) and "U" (above detection limit) are also defined for used in place of decimal values.). This is the underlying object with id, value and extensions. The accessor "getData" gives direct access to the value
     */
    public SampledData setDataElement(StringType value) { 
      this.data = value;
      return this;
    }

    /**
     * @return A series of data points which are decimal values or codes separated by a single space (character u20). The special codes "E" (error), "L" (below detection limit) and "U" (above detection limit) are also defined for used in place of decimal values.
     */
    public String getData() { 
      return this.data == null ? null : this.data.getValue();
    }

    /**
     * @param value A series of data points which are decimal values or codes separated by a single space (character u20). The special codes "E" (error), "L" (below detection limit) and "U" (above detection limit) are also defined for used in place of decimal values.
     */
    public SampledData setData(String value) { 
      if (Utilities.noString(value))
        this.data = null;
      else {
        if (this.data == null)
          this.data = new StringType();
        this.data.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("origin", "Quantity", "The base quantity that a measured value of zero represents. In addition, this provides the units of the entire measurement series.", 0, 1, origin));
        children.add(new Property("interval", "decimal", "Amount of intervalUnits between samples, e.g. milliseconds for time-based sampling.", 0, 1, interval));
        children.add(new Property("intervalUnit", "code", "The measurement unit in which the sample interval is expressed.", 0, 1, intervalUnit));
        children.add(new Property("factor", "decimal", "A correction factor that is applied to the sampled data points before they are added to the origin.", 0, 1, factor));
        children.add(new Property("lowerLimit", "decimal", "The lower limit of detection of the measured points. This is needed if any of the data points have the value \"L\" (lower than detection limit).", 0, 1, lowerLimit));
        children.add(new Property("upperLimit", "decimal", "The upper limit of detection of the measured points. This is needed if any of the data points have the value \"U\" (higher than detection limit).", 0, 1, upperLimit));
        children.add(new Property("dimensions", "positiveInt", "The number of sample points at each time point. If this value is greater than one, then the dimensions will be interlaced - all the sample points for a point in time will be recorded at once.", 0, 1, dimensions));
        children.add(new Property("codeMap", "canonical(ConceptMap)", "Reference to ConceptMap that defines the codes used in the data.", 0, 1, codeMap));
        children.add(new Property("offsets", "string", "A series of data points which are decimal values separated by a single space (character u20).  The units in which the offsets are expressed are found in intervalUnit.  The absolute point at which the measurements begin SHALL be conveyed outside the scope of this datatype, e.g. Observation.effectiveDateTime for a timing offset.", 0, 1, offsets));
        children.add(new Property("data", "string", "A series of data points which are decimal values or codes separated by a single space (character u20). The special codes \"E\" (error), \"L\" (below detection limit) and \"U\" (above detection limit) are also defined for used in place of decimal values.", 0, 1, data));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1008619738: /*origin*/  return new Property("origin", "Quantity", "The base quantity that a measured value of zero represents. In addition, this provides the units of the entire measurement series.", 0, 1, origin);
        case 570418373: /*interval*/  return new Property("interval", "decimal", "Amount of intervalUnits between samples, e.g. milliseconds for time-based sampling.", 0, 1, interval);
        case -1569830935: /*intervalUnit*/  return new Property("intervalUnit", "code", "The measurement unit in which the sample interval is expressed.", 0, 1, intervalUnit);
        case -1282148017: /*factor*/  return new Property("factor", "decimal", "A correction factor that is applied to the sampled data points before they are added to the origin.", 0, 1, factor);
        case 1209133370: /*lowerLimit*/  return new Property("lowerLimit", "decimal", "The lower limit of detection of the measured points. This is needed if any of the data points have the value \"L\" (lower than detection limit).", 0, 1, lowerLimit);
        case -1681713095: /*upperLimit*/  return new Property("upperLimit", "decimal", "The upper limit of detection of the measured points. This is needed if any of the data points have the value \"U\" (higher than detection limit).", 0, 1, upperLimit);
        case 414334925: /*dimensions*/  return new Property("dimensions", "positiveInt", "The number of sample points at each time point. If this value is greater than one, then the dimensions will be interlaced - all the sample points for a point in time will be recorded at once.", 0, 1, dimensions);
        case 941825071: /*codeMap*/  return new Property("codeMap", "canonical(ConceptMap)", "Reference to ConceptMap that defines the codes used in the data.", 0, 1, codeMap);
        case -1548407232: /*offsets*/  return new Property("offsets", "string", "A series of data points which are decimal values separated by a single space (character u20).  The units in which the offsets are expressed are found in intervalUnit.  The absolute point at which the measurements begin SHALL be conveyed outside the scope of this datatype, e.g. Observation.effectiveDateTime for a timing offset.", 0, 1, offsets);
        case 3076010: /*data*/  return new Property("data", "string", "A series of data points which are decimal values or codes separated by a single space (character u20). The special codes \"E\" (error), \"L\" (below detection limit) and \"U\" (above detection limit) are also defined for used in place of decimal values.", 0, 1, data);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1008619738: /*origin*/ return this.origin == null ? new Base[0] : new Base[] {this.origin}; // Quantity
        case 570418373: /*interval*/ return this.interval == null ? new Base[0] : new Base[] {this.interval}; // DecimalType
        case -1569830935: /*intervalUnit*/ return this.intervalUnit == null ? new Base[0] : new Base[] {this.intervalUnit}; // CodeType
        case -1282148017: /*factor*/ return this.factor == null ? new Base[0] : new Base[] {this.factor}; // DecimalType
        case 1209133370: /*lowerLimit*/ return this.lowerLimit == null ? new Base[0] : new Base[] {this.lowerLimit}; // DecimalType
        case -1681713095: /*upperLimit*/ return this.upperLimit == null ? new Base[0] : new Base[] {this.upperLimit}; // DecimalType
        case 414334925: /*dimensions*/ return this.dimensions == null ? new Base[0] : new Base[] {this.dimensions}; // PositiveIntType
        case 941825071: /*codeMap*/ return this.codeMap == null ? new Base[0] : new Base[] {this.codeMap}; // CanonicalType
        case -1548407232: /*offsets*/ return this.offsets == null ? new Base[0] : new Base[] {this.offsets}; // StringType
        case 3076010: /*data*/ return this.data == null ? new Base[0] : new Base[] {this.data}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1008619738: // origin
          this.origin = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 570418373: // interval
          this.interval = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case -1569830935: // intervalUnit
          this.intervalUnit = TypeConvertor.castToCode(value); // CodeType
          return value;
        case -1282148017: // factor
          this.factor = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 1209133370: // lowerLimit
          this.lowerLimit = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case -1681713095: // upperLimit
          this.upperLimit = TypeConvertor.castToDecimal(value); // DecimalType
          return value;
        case 414334925: // dimensions
          this.dimensions = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        case 941825071: // codeMap
          this.codeMap = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case -1548407232: // offsets
          this.offsets = TypeConvertor.castToString(value); // StringType
          return value;
        case 3076010: // data
          this.data = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("origin")) {
          this.origin = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("interval")) {
          this.interval = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("intervalUnit")) {
          this.intervalUnit = TypeConvertor.castToCode(value); // CodeType
        } else if (name.equals("factor")) {
          this.factor = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("lowerLimit")) {
          this.lowerLimit = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("upperLimit")) {
          this.upperLimit = TypeConvertor.castToDecimal(value); // DecimalType
        } else if (name.equals("dimensions")) {
          this.dimensions = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else if (name.equals("codeMap")) {
          this.codeMap = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("offsets")) {
          this.offsets = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("data")) {
          this.data = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1008619738:  return getOrigin();
        case 570418373:  return getIntervalElement();
        case -1569830935:  return getIntervalUnitElement();
        case -1282148017:  return getFactorElement();
        case 1209133370:  return getLowerLimitElement();
        case -1681713095:  return getUpperLimitElement();
        case 414334925:  return getDimensionsElement();
        case 941825071:  return getCodeMapElement();
        case -1548407232:  return getOffsetsElement();
        case 3076010:  return getDataElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1008619738: /*origin*/ return new String[] {"Quantity"};
        case 570418373: /*interval*/ return new String[] {"decimal"};
        case -1569830935: /*intervalUnit*/ return new String[] {"code"};
        case -1282148017: /*factor*/ return new String[] {"decimal"};
        case 1209133370: /*lowerLimit*/ return new String[] {"decimal"};
        case -1681713095: /*upperLimit*/ return new String[] {"decimal"};
        case 414334925: /*dimensions*/ return new String[] {"positiveInt"};
        case 941825071: /*codeMap*/ return new String[] {"canonical"};
        case -1548407232: /*offsets*/ return new String[] {"string"};
        case 3076010: /*data*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("origin")) {
          this.origin = new Quantity();
          return this.origin;
        }
        else if (name.equals("interval")) {
          throw new FHIRException("Cannot call addChild on a singleton property SampledData.interval");
        }
        else if (name.equals("intervalUnit")) {
          throw new FHIRException("Cannot call addChild on a singleton property SampledData.intervalUnit");
        }
        else if (name.equals("factor")) {
          throw new FHIRException("Cannot call addChild on a singleton property SampledData.factor");
        }
        else if (name.equals("lowerLimit")) {
          throw new FHIRException("Cannot call addChild on a singleton property SampledData.lowerLimit");
        }
        else if (name.equals("upperLimit")) {
          throw new FHIRException("Cannot call addChild on a singleton property SampledData.upperLimit");
        }
        else if (name.equals("dimensions")) {
          throw new FHIRException("Cannot call addChild on a singleton property SampledData.dimensions");
        }
        else if (name.equals("codeMap")) {
          throw new FHIRException("Cannot call addChild on a singleton property SampledData.codeMap");
        }
        else if (name.equals("offsets")) {
          throw new FHIRException("Cannot call addChild on a singleton property SampledData.offsets");
        }
        else if (name.equals("data")) {
          throw new FHIRException("Cannot call addChild on a singleton property SampledData.data");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "SampledData";

  }

      public SampledData copy() {
        SampledData dst = new SampledData();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SampledData dst) {
        super.copyValues(dst);
        dst.origin = origin == null ? null : origin.copy();
        dst.interval = interval == null ? null : interval.copy();
        dst.intervalUnit = intervalUnit == null ? null : intervalUnit.copy();
        dst.factor = factor == null ? null : factor.copy();
        dst.lowerLimit = lowerLimit == null ? null : lowerLimit.copy();
        dst.upperLimit = upperLimit == null ? null : upperLimit.copy();
        dst.dimensions = dimensions == null ? null : dimensions.copy();
        dst.codeMap = codeMap == null ? null : codeMap.copy();
        dst.offsets = offsets == null ? null : offsets.copy();
        dst.data = data == null ? null : data.copy();
      }

      protected SampledData typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SampledData))
          return false;
        SampledData o = (SampledData) other_;
        return compareDeep(origin, o.origin, true) && compareDeep(interval, o.interval, true) && compareDeep(intervalUnit, o.intervalUnit, true)
           && compareDeep(factor, o.factor, true) && compareDeep(lowerLimit, o.lowerLimit, true) && compareDeep(upperLimit, o.upperLimit, true)
           && compareDeep(dimensions, o.dimensions, true) && compareDeep(codeMap, o.codeMap, true) && compareDeep(offsets, o.offsets, true)
           && compareDeep(data, o.data, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SampledData))
          return false;
        SampledData o = (SampledData) other_;
        return compareValues(interval, o.interval, true) && compareValues(intervalUnit, o.intervalUnit, true)
           && compareValues(factor, o.factor, true) && compareValues(lowerLimit, o.lowerLimit, true) && compareValues(upperLimit, o.upperLimit, true)
           && compareValues(dimensions, o.dimensions, true) && compareValues(codeMap, o.codeMap, true) && compareValues(offsets, o.offsets, true)
           && compareValues(data, o.data, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(origin, interval, intervalUnit
          , factor, lowerLimit, upperLimit, dimensions, codeMap, offsets, data);
      }


}

